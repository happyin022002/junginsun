/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1000.js
*@FileTitle : Attorney Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 임진영
*@LastVersion : 1.0
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
     * @class esm_bkg_1000 : esm_bkg_1000 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1000() {
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

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
            var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn2_Row_Add":
                    doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;

                case "btn2_Row_Delete":
                    if(sheetObject1.FindCheckedRow("sheet1_del_chk") ==''){
                        ComShowCodeMessage("BKG00546");
                        return;
                    }

                    var cnt = 0;
                    for (var i=1; i<=sheetObject1.RowCount; i++) {

                        //자식레코드가 있고 체크가 되어있다면 카운트 증가
                        if( sheetObject1.CellValue(i, 'sheet1_child_record') > 0 && sheetObject1.CellValue(i, "sheet1_del_chk") == 1) {
                            cnt ++;
                            //sheetObject1.CellValue(i, "sheet1_del_chk") = 1;
                        }
                    }

                    if(cnt > 0){
                        ComShowCodeMessage('BKG00795');
                        cnt = 0;
                        return;
                    }

                    ComRowHideDelete(sheetObject1,"sheet1_del_chk");
                    break;

                case "btn1_Retrieve":

                    //그리드의 변경 여부 체크
                    if(sheetObject1.IsDataModified){
                        if(ComShowCodeConfirm("BKG00824")){
                            doActionIBSheet(sheetObject1,formObject,IBSAVE);
                            break;
                        }else{
                            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                            break;
                        }
                    }else{
                        doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                        break;
                    }
                case "btn1_Save":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;

                case "btn1_Close":
                    //그리드의 변경 여부 체크
                    if(sheetObject1.IsDataModified){
                        if(ComShowCodeConfirm("BKG00168")){
                            window.close();
                        }
                    }else{
                        window.close();
                    }
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

            //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH); 초기 페이지 로딩 시 검색 안되도록
        }
        initControl();
    }

    function initControl(){
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',         'obj_keypress',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    }

    //Axon 이벤트 처리2. 이벤트처리함수
    //포커스가 나갈 때
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }

    //포커스가 들어갈 때
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }

    /*
    //키보드가 눌릴 때
    function obj_keypress(){
        switch(event.srcElement.dataformat){
            case "int":
                //숫자 만입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;
            case "float":
                //숫자+"."입력하기
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "eng":
                //영문만입력하기
                ComKeyOnlyAlphabet();
                break;
            case "engup":
                //영문대문자만입력하기
                ComKeyOnlyAlphabet('upper');
                break;
            default:
                //숫자만입력하기
                ComKeyOnlyNumber(event.srcElement);
        }
    }
    */
    //Axon 이벤트 처리2. 이벤트처리함수 --- end

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
                    style.height = 262;
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

                    var HeadTitle1 = "|Sel.|Seq.|사업자명|사업자 등록 번호|User Name|Office|Update Date|User ID|Child Record";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    // 해더모드[선택][SORT=true,COLUMNMOVE=false,ALLCHECK=true,USERRESIZE=true]
                    InitHeadMode(false, false, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN,   COLMERGE,   SAVENAME,  KEYFIELD, CALCULOGIC,        DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet1_";
                    InitDataProperty(0, cnt++ , dtHiddenStatus ,30,     daCenter,   false,     prefix +"ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   40,     daCenter,   true,      prefix + "del_chk",         false,      "",   dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,          40,     daCenter,   true,      prefix + "seq",             false,      "",   dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,         160,    daCenter,   true,      prefix + "atty_cust_nm",    false,      "",   dfNone,     0,          true,       true, 100);
                    InitDataProperty(0, cnt++ , dtData,         120,    daCenter,   true,      prefix + "atty_biz_no",     true,       "",   dfSaupNo,   0,          false,      true);
                    InitDataProperty(0, cnt++ , dtData,         120,    daCenter,   true,      prefix + "upd_usr_nm",      false,      "",   dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,      prefix + "upd_ofc_cd",      false,      "",   dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenter,   true,      prefix + "upd_dt",          false,      "",   dfTimeHm,   0,          false,      false);
                    InitDataProperty(0, cnt++ , dtData,         0,      daCenter,   true,      prefix + "upd_usr_id",      false,      "",   dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,       0,      daCenter,   true,      prefix + "child_record",    false,      "",   dfNone,     0,          false,      false);

                    CountPosition = 0;
                }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH://조회

                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }//end if

                ComClearSeparator(document.getElementById("atty_biz_no"), "saupja", "-")
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("ESM_BKG_1000GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
            break;

            case IBSAVE://저장

                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }//end if
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_BKG_1000GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),'', true);
            break;

            case IBINSERT:// 입력
            //sheetObj.DataInsert(-1);
            var idx = sheetObj.DataInsert(-1);
            //추가된 행의 사업자명에 포거스를 준다.
            sheetObj.SelectCell(sheetObj.SelectRow, "sheet1_atty_cust_nm", true);
            //행이 추가되면 사업자 번호를 Edit 할 수 있도록 한다.
            //sheetObj.CellEditable(idx, "sheet1_atty_biz_no") = true;
            
            sheetObj.CellValue(idx, "sheet1_upd_usr_nm") = document.form.user_nm.value
            sheetObj.CellValue(idx, "sheet1_upd_ofc_cd") = document.form.ofc_cd.value;
            sheetObj.CellValue(idx, "sheet1_upd_usr_id") = document.form.user_id.value;

            break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){

        switch (sAction) {
            // 조회
            case IBSEARCH:
                //조회조건 미 입력 체크
                if(ComIsEmpty(formObj.atty_cust_nm.value) && ComIsEmpty(formObj.atty_biz_no.value)){
                    ComShowCodeMessage('BKG00701');
                    formObj.atty_cust_nm.focus();
                    return;
                }
                return true;
                break;
            // 저장
            case IBSAVE:
                //그리드의 변경 여부 체크
                if(!sheetObj.IsDataModified){
                    ComShowCodeMessage('BKG00743');
                    return false;
                }
                document.form.insertRow.value = sheetObj.RowCount("I");

                //사업자 명의 바이트 수 체크
                if(!mdtrNmByteCheck(sheetObj)){
                    return false;
                //사업자 번호 유효성 체크
                }else if(!validSaupjaCheck(sheetObj)){
                    return false;
                //사업자 번호 중복 체크
                }else if(!dupSaupjaCheck(sheetObj)){
                    return false;
                }
                return true;
                break;
        }
    }

    /**
     * IBSheet 그리드에 입력된 사업자 명의 바이트 수를 체크한다.
     */
    function mdtrNmByteCheck(sheetObj) {

        for(var idx=1; idx <= sheetObj.RowCount; idx++){
            //입력모드이고 사업자명이 존재하면 길이 체크
            if(sheetObj.RowStatus(idx) =='I' && sheetObj.CellValue(idx, "sheet1_atty_cust_nm") !=''){
                if( ComChkLenByByte(sheetObj.CellValue(idx, "sheet1_atty_cust_nm"),100) == 0){
                    ComShowCodeMessage("BKG40006");
                    sheetObj.SelectCell(idx, "sheet1_atty_cust_nm", true);
                    return false;
                    break;
                }
            }
        }
        return true;
    }

    /**
     * IBSheet 그리드에 입력된 사업자 번호의 중복 여부를 체크한다.
     */
    function dupSaupjaCheck(sheetObj) {

        var dRow = sheetObj.ColValueDup("sheet1_atty_biz_no", false);
        if(ComIsEmpty(sheetObj.CellValue(dRow, "sheet1_atty_biz_no"))){
            //공백 열은 중복체크 예외 중복 체크 함수 이후 IbSheet 함수 do save의 KEY VALUE 체크 로직을 수행하도록 한다.
            return true;
        }
        if (dRow != -1) {
            ComShowCodeMessage('COM12115', 'saupja: ['+sheetObj.CellValue(dRow, "sheet1_atty_biz_no")+']');
            sheetObj.SelectCell(dRow, sheetObj.SaveNameCol("sheet1_atty_biz_no"));
            return false;
        } else {
            return true;
        }
    }

    /**
     * IBSheet 그리드에 입력된 사업자의 유효성을 체크한다.
     */
    function validSaupjaCheck(sheetObj) {

        for(var idx=1; idx <= sheetObj.RowCount; idx++){

            if(sheetObj.RowStatus(idx) =='I' && sheetObj.CellValue(idx, "sheet1_atty_biz_no")!=''){
                if(!ComIsSaupjaNo(sheetObj.CellValue(idx, "sheet1_atty_biz_no"))){
                    ComShowCodeMessage("BKG40001");
                    sheetObj.SelectCell(idx, "sheet1_atty_biz_no", true);
                    return false;
                    break;
                }
            }
        }
        return true;
    }

    /**
     * sheet1를 저장하고 나서 처리할 사항
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            /*var oForm = document.form;
            //저장 후 재 조회 한다. 조회 조건은 초기화 단 INSERT ROW가 존재 할 경우에 한하여 재 조회 한다.
            if(oForm.insertRow.value > 0){
                oForm.atty_biz_no.value = "";
                oForm.atty_cust_nm.value = "";
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
            */
            ComBkgSaveCompleted();  //서버메세지 처리
        }
    }

   /**
    * 자식 레코드를 가진 데이터의 삭제 불가를 알림
    function sheet1_OnClick(sheetObj, Row, Col, Value){

        if(sheetObj.ColSaveName(Col) =='sheet1_del_chk' && sheetObj.CellValue(Row, "sheet1_child_record") >0){
            ComShowCodeMessage('BKG00795');
            sheetObj.CellValue(Row, "sheet1_del_chk") = 1;
        }
    }
    */
    /* 개발자 작업  끝 */