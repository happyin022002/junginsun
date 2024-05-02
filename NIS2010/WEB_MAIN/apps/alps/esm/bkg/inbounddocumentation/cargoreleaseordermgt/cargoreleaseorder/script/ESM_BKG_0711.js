/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0711.js
*@FileTitle      : Cargo Release Order History
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.05.04
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.05.04 임진영
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
     * @class ui_bkg_0711 : ui_bkg_0711 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ui_bkg_0711() {
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
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
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

            if (document.form.bl_no.value != "") {
            	if (document.form.h_bl_tp_cd != "") {
            		document.form.h_bl_no.value = document.form.bl_no.value + document.form.h_bl_tp_cd.value; 
            	} else {
            		document.form.h_bl_no.value = document.form.bl_no.value;
            	}
            } else {
            	document.form.h_bl_no.value = "";
            }
            
            doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
        initControl();
        //조회조건 BL번호에 포커스를 준다.
        ComSetFocus(document.form.bl_no)
        //조회조건 BL번호의 라디오가 체크 되도록 한다.
        //document.getElementsByName("rdo_flag")[0].checked = true;

    }

    function initControl(){
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',         'obj_keypress',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        //axon_event.addListenerForm  ('click', 'obj_click', form);
        axon_event.addListenerForm  ('change', 'obj_change', form);
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
                    style.height = 240;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.| |Item|New|Old|User Name|Office|Update Time|User ID";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtSeq,      40,         daCenter,   true,           "Seq");
                        InitDataProperty(0, cnt++ , dtHidden,   50,         daCenter,   true,           "do_cng_evnt_cd",   false,          "",      dfNone,        0,      false,      false);
                        InitDataProperty(0, cnt++ , dtData,     130,        daCenter,   true,           "do_cng_evnt_nm",   false,          "",      dfNone,        0,      false,      false);
                        InitDataProperty(0, cnt++ , dtData,     90,         daCenter,   true,           "crnt_ctnt_nm",     false,          "",      dfNone,        0,      false,      false);
                        InitDataProperty(0, cnt++ , dtData,     90,         daCenter,   true,           "pre_ctnt",         false,          "",      dfNone,        0,      false,      false);
                        InitDataProperty(0, cnt++ , dtData,     130,        daCenter,   true,           "upd_usr_nm",       false,          "",      dfNone,        0,      false,      false);
                        InitDataProperty(0, cnt++ , dtData,     70,         daCenter,   true,           "evnt_ofc_cd",      false,          "",      dfNone,        0,      false,      false);
                        InitDataProperty(0, cnt++ , dtData,     120,        daCenter,   true,           "evnt_dt",          false,          "",      dfUserFormat2, 0,      false,      false);
                        InitDataProperty(0, cnt++ , dtData,     80,         daCenter,   true,           "upd_usr_id",       false,          "",      dfNone,        0,      false,      false);

                        InitUserFormat2(0, "evnt_dt", "####-##-## ##:##", "-|:" );
                        //sheetObj.ScrollBar = 2;
                    }
                break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        var form = document.form;
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
                //if(validateForm(sheetObj,formObj,sAction)){
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch("ESM_BKG_0711GS.do", FormQueryString(formObj));
                //}
                break;
        }
    }

    /**
     * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_change(){
        var oForm = document.form;
        if (event.srcElement.name == "bl_no") {
            document.getElementsByName("rdo_flag")[0].checked = true;
            oForm.bkg_no.value ='';
            oForm.cntr_no.value ='';
            //공통 유틸이 개발되면 BL NO로 BKG NO / CNTR_NO를 조회해서 세팅하는 로직 추가
        }else if (event.srcElement.name == "cntr_no") {
            document.getElementsByName("rdo_flag")[1].checked = true;
            oForm.bkg_no.value ='';
            oForm.bl_no.value ='';
            //공통 유틸이 개발되면 CNTR_NO로 BKG NO / BL_NO를 조회해서 세팅하는 로직 추가
        }else if (event.srcElement.name == "bkg_no") {
            document.getElementsByName("rdo_flag")[2].checked = true;
            oForm.bl_no.value ='';
            oForm.cntr_no.value ='';
            //공통 유틸이 개발되면 BKG NO로 CNTR_NO / BL_NO를 조회해서 세팅하는 로직 추가
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        var oForm = document.form;
        if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.cntr_no) && ComIsNull(oForm.bkg_no)){
            ComShowCodeMessage('BKG00786'); //필수 조회 조건이 누락되었습니다. B/L No or Container No or BKG No가 필수 조회 조건입니다.
            ComSetFocus(oForm.bl_no)
            return false;
        }else if (!ComIsNull(oForm.bl_no) && ComChkLen(oForm.bl_no, 12) != 2){
            ComShowCodeMessage('BKG00652'); //B/L No's prefix is invalid
            ComSetFocus(oForm.bl_no)
            return false;
        }else if (!ComIsNull(oForm.cntr_no) && ComChkLen(oForm.cntr_no, 14) != 2){
            //ComShowCodeMessage('BKG00443'); //유효하지않은 컨테이너 번호입니다
            ComShowCodeMessage('BKG00700');   //Container No's prefix is invalid
            ComSetFocus(oForm.cntr_no)
            return false;
        }else if (!ComIsNull(oForm.bkg_no) && ( oForm.bkg_no.value.length != 13 && oForm.bkg_no.value.length != 11)){
            ComShowCodeMessage('BKG00651'); //BKG prefix is invalid
            ComSetFocus(oForm.bkg_no)
            return false;
        }
        return true;
    }

   /**
    * sheet1 MouseMove 이벤트
    * @param {ibsheet} sheet 해당 시트
    * @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
    * @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
    * @param {long} X X 좌표
    * @param {long} Y Y 좌표
    */
    function sheet1_OnMouseMove(sheetObj, row, col, value, button, shift, X, Y) {

        var sName = sheetObj.ColSaveName(sheetObj.MouseCol);

        if ("crnt_ctnt" != sName ){
            return;
        }

        if (sheetObj.CellValue(sheetObj.MouseRow ,'crnt_ctnt') == 'YES' && sheetObj.CellValue(sheetObj.MouseRow ,'do_cng_evnt_cd') == 'RR') {
            sheetObj.MousePointer = "Hand";
        } else {
            sheetObj.MousePointer = "Default";
        }
    }

    /**
     * Hidden IBSheet를 조회하고 나서 처리할 사항
     * 데이터 조회 건수가 10건 이상이면 스크롤바 처리 : 수직 스크롤 만 가능 상태로 아니면 스크롤바 생기지 않음
     * crnt_ctnt 값이 YES이고 do_cng_evnt_cd 값이 RR이면 링크 처리 (Cargo Release Order Auto Pop-up Remark이 Open됨 (UI_BKG-0954))
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {

            if(sheetObj.RowCount > 10){//
                sheetObj.ScrollBar = 2;
            }else{
                sheetObj.ScrollBar = 0;
            }

            for (var i=1; i<=sheetObj.RowCount; i++) {
                if( sheetObj.CellValue(i,'crnt_ctnt') == 'YES' && sheetObj.CellValue(i,'do_cng_evnt_cd') == 'RR'){
                    sheetObj.CellFontUnderline(i,'crnt_ctnt') = true;
                    sheetObj.CellFontColor(i, "crnt_ctnt") = sheetObj.RgbColor(0,0,255);
                }
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }

    
    function sheet1_OnClick(sheetObj, Row, Col, Value){
        if(sheetObj.ColSaveName(Col) =='crnt_ctnt' && sheetObj.CellValue(Row, "crnt_ctnt") == 'YES' && sheetObj.CellValue(sheetObj.MouseRow ,'do_cng_evnt_cd') == 'RR'){
            //ComShowMessage("Cargo Release Order Auto Pop-up Remark이 Open됨 (UI_BKG-0954) 미 구현");
        }
    }
    /* 개발자 작업  끝 */