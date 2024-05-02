/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1001.js
*@FileTitle : Attorney Search Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.04.30 임진영
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
     * @class esm_bkg_1001 : esm_bkg_1001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1001() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 엔터키 클릭 시 조회 이벤트 호출
    function enterKeyNextSearch(){
        var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var formObject = document.form;
        // 엔터키(13)이면
        if (keyCode == 13) {
            doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
        } // end if
    }

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                    break;
                case "btn_select":
                    comPopupOK();
                break;

                case "btn_close":
                    window.close();
                break;

            } // end switch
        } catch(e) {
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

            if(!ComIsEmpty(document.form.atty_cust_nm)){
                doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
            }

        }

        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',         'obj_keypress',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    }

    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }

    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            case 'sheet1':      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 82;
                   //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|Sel.|사업자명|사업자 등록 번호";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    //헤더속성    [SortEnable, ColumnMove, AllCheckEnable, AllCheckEnable, UserResize, RowMove, Head3D]
                    InitHeadMode(false, false, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,   COLMERGE,   SAVENAME,  KEYFIELD, CALCULOGIC,        DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daCenter,    false,      "");
                    InitDataProperty(0, cnt++ , dtRadioCheck,   0,      daCenter,    false,      "radio",          false,      "",       dfNone,     0,     true,     true);
                    InitDataProperty(0, cnt++ , dtData,         160,    daCenter,    true,       "atty_cust_nm",   false,      "",       dfNone,     0,     false,    false);
                    InitDataProperty(0, cnt++ , dtData,         0,      daCenter,    true,       "atty_biz_no",    false,      "",       dfSaupNo,   0,     false,    false);

                    ColHidden("radio") = true;

                    DataLinkMouse("atty_cust_nm") = true;
                    DataLinkMouse("atty_biz_no")  = true;

                    CountPosition = 0;
               }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회

                if(validateForm(sheetObj,formObj,sAction)){

                    formObj.f_cmd.value = SEARCH;

                    //마스크 구분자 없애기 초기 로딩 시 오브젝트를 찾지 못함
                    /*
                    try{
                        if(event.srcElement.name =='atty_biz_no'){
                            ComClearSeparator (event.srcElement, "saupja", "-");
                        }
                    }catch(e) {
                    }
                    */

                    //var condition = "?";
                    //condition += "atty_cust_nm="+document.form.atty_cust_nm.value;

                    //sheetObj.DoSearch("ESM_BKG_1001GS.do"+condition, FormQueryString(formObj));
                    sheetObj.DoSearch("ESM_BKG_1001GS.do", FormQueryString(formObj));
                    break;
                }
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        var oForm = document.form;
        with(formObj){
            if(ComIsEmpty(oForm.atty_cust_nm)){
                ComShowCodeMessage('BKG40005');
                ComSetFocus(oForm.atty_cust_nm)
                return false;
            }
        }
        return true;
    }

   /**
    * 조회된 데이터를 더블 클릭 할 때
    */
    function sheet1_OnDblClick(sheetObj, Row, Col){
        sheetObj.CellValue(Row, "radio") = 1;
        comPopupOK();
    }
    /* 개발자 작업  끝 */
