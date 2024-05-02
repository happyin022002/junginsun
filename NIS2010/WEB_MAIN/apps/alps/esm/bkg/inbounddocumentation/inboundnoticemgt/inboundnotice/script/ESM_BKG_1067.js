/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1067.js
*@FileTitle : Pick up upload history
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.11.03 박미옥
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
     * @class ESM_BKG_1067 : ESM_BKG_1067 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1067() {
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
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
                var sheetObject1 = sheetObjects[0];
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
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    
    /**
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
     * @return 없슴
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
     * 
     * @return 없슴
     */
    function loadPage() {

        for(var i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }


    /**
     * 시트 초기설정값, 헤더 정의<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
     * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
     * @return 없슴
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "|Seq.|B/L No.|Container|POD|IT LOC|DEL|TERM|Pick up No.|PICK YD|RTN YD|RL DT|AR DT|AVL DT|FRE DT|Update DT|Update USER|Update OFC";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                                        

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false, "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,          30,    daCenter,   false, "seq");
                    InitDataProperty(0, cnt++ , dtData,         100,   daCenter,   true,  "bl_no",          false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         100,   daCenter,   true,  "cntr_no",        false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   true,  "pod_cd",         false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   true,  "ibd_trsp_hub_cd",false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   true,  "del_cd",         false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,   true,  "de_term_cd",     false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   true,  "pkup_no",        false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   true,  "pkup_yd_cd",     false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   true,  "rtn_yd_cd",      false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   true,  "rail_arr_dt",    false,  "",  dfUserFormat2, 0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   true,  "rail_dep_dt",    false,  "",  dfUserFormat2, 0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   true,  "pkup_aval_dt",   false,  "",  dfUserFormat2, 0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   true,  "lst_free_dt",    false,  "",  dfUserFormat2, 0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         100,   daCenter,   true,  "pkup_upd_dt",    false,  "",  dfUserFormat2, 0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,   true,  "pkup_upd_usr_id",false,  "",  dfNone,        0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,   true,  "ofc_cd",         false,  "",  dfNone,        0,  false,  false);

                    InitUserFormat2(0, "rail_arr_dt", "####-##-##", "-|:" );
                    InitUserFormat2(0, "rail_dep_dt", "####-##-##", "-|:" );
                    InitUserFormat2(0, "pkup_aval_dt", "####-##-##", "-|:" );
                    InitUserFormat2(0, "lst_free_dt", "####-##-##", "-|:" );
                    InitUserFormat2(0, "pkup_upd_dt", "####-##-## ##:##", "-|:" );
               }
               
               break;

        }
    }
    

    /**
     * Sheet관련 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return 없슴
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
    	
        switch(sAction) {

        //조회
        case IBSEARCH:      
            if(validateForm(sheetObj,formObj,sAction) == false) break;
            
            ComOpenWait(true);
            
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_BKG_1067GS.do", FormQueryString(formObj));
            
            ComOpenWait(false);
        
            break;
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }


	/* 개발자 작업  끝 */