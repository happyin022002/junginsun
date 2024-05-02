/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0999.js
*@FileTitle : Attorney Create Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.05.12 임진영
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
     * @class esm_bkg_0999 : esm_bkg_0999 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0999() {
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

        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
        var sheetObject1 = sheetObjects[0];
        /**************************************************************************/
        var formObject = document.form;

        try {

            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btn_Row_Add":
                    doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;

                case "btn_Row_Copy":
                    var index = sheetObjects[0].DataCopy();
                    break;

                case "btn_Row_Delete":
                    //체크 박스  미 선택 시 알림 메세지
                    if(sheetObject1.FindCheckedRow("sheet1_del_chk") ==''){
                        ComShowCodeMessage("BKG00546");
                        return;
                    }
                    ComRowHideDelete(sheetObject1,"sheet1_del_chk");
                    break;

                case "btn_Retrieve":

                    //그리드의 변경 여부 체크
                    if(sheetObject1.IsDataModified){
                        if(ComShowCodeConfirm("BKG00824")){
                            doActionIBSheet(sheetObject1,formObject,IBSAVE);
                            break;
                        }else{
                            //조회조건 미 입력 시 알림 메세지
                            if( ComIsEmpty(formObject.cust_name.value) && ComIsEmpty(formObject.cust_biz_no.value)){
                                ComShowCodeMessage('BKG00701');
                                formObject.cust_name.focus();
                                return;
                            }
                            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                            break;
                        }
                    }else{
                        //조회 조건 미 입력 시 알림 메세지
                        if( ComIsEmpty(formObject.cust_name.value) && ComIsEmpty(formObject.cust_biz_no.value)){
                            ComShowCodeMessage('BKG00701');
                            formObject.cust_name.focus();
                            return;
                        }
                        doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                        break;
                    }

                case "btn_Register":
                    //Window를 Open합니다.
                    //ComPostOpenWindow('/hanjin/ESM_BKG_1000.do', 'win1', 'width=900,height=485');
                    ComOpenWindowCenter('/hanjin/ESM_BKG_1000.do',"ESM_BKG_1000",900,485,true);
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;

                case "btn_Close":
                    //그리드의 변경 여부 체크 후 저장 여부 알림 메세지
                    if(sheetObject1.IsDataModified){
                        if(ComShowCodeConfirm("BKG00168")){
                            window.close();
                        }
                    }else{
                        window.close();
                    }
                    break;

                case "pop_attorney":
                    //위임자에서 호출
                    attorneyPopOpen();
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

            //조회조건 수임자명에 포커스를 준다.
            ComSetFocus(document.form.cust_name)

            //Axon 이벤트 처리1. 이벤트catch
            axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
            axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
            axon_event.addListenerFormat('keypress',         'obj_keypress',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
            axon_event.addListenerForm  ('change', 'obj_change', form);
            //axon_event.addListenerForm  ('click', 'obj_click', form);

            //조회조건 수임자의 라디오가 체크 되도록 한다.
            document.getElementsByName("rdo_flag")[0].checked = true;

            if(document.getElementById("cust_biz_no").value !='' ){
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
        }
    }

    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }

    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }

    /**
     * 조회조건 수임자명, 위임자명이 바뀌면 각 사업자 번호를 초기화 한다.
     */
    function obj_change(){
        if(event.srcElement.name == "cust_name"){
            document.getElementById("cust_biz_no").value = '';
        }
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
                    style.height = 250;
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

                    var HeadTitle1 = "|Sel.|Seq.|수임자|사업자 등록 번호|위임자|사업자 등록 번호|발효일자|만료일자|계산서|Remark|User Name|Office|Update Date|User ID|중복여부|현재날짜|현재날짜-만료일자";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    // 헤더속성  [SortEnable, ColumnMove, AllCheckEnable, AllCheckEnable, UserResize, RowMove, Head3D]
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //Edit 가능한 셀에 포커스가 들어갔을 때 Edit를 시작할지 여부를 확인하거나 설정한다.
                    FocusEditMode = -1;

                    var prefix="sheet1_";

                    //데이터속성    [ROW, COL,    DATATYPE,        WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,                   KEYFIELD,   CALCULOGIC,               DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,   cnt++ , dtHiddenStatus,  30,     daCenter,   false,     prefix +"ibflag");
                    InitDataProperty(0,   cnt++ , dtDummyCheck,    40,     daCenter,   true,      prefix + "del_chk",         false,      "",                       dfNone,     0,          true,       true);
                    InitDataProperty(0,   cnt++ , dtSeq,           40,     daCenter,   true,      prefix + "seq",             false,      "",                       dfNone,     0,          true,       true);
                    InitDataProperty(0,   cnt++ , dtPopupEdit,     143,    daCenter,   true,      prefix + "fm_atty_biz_nm",  false,      "",                       dfNone,     0,          false,      true);
                    InitDataProperty(0,   cnt++ , dtData,          120,    daCenter,   true,      prefix + "fm_atty_biz_no",  true,       "",                       dfSaupNo,   0,          false,      false);
                    InitDataProperty(0,   cnt++ , dtPopupEdit,     143,    daCenter,   true,      prefix + "to_atty_biz_nm",  false,      "",                       dfNone,     0,          false,      true);
                    InitDataProperty(0,   cnt++ , dtData,          120,    daCenter,   true,      prefix + "to_atty_biz_no",  true,       "",                       dfSaupNo,   0,          false,      false);
                    InitDataProperty(0,   cnt++ , dtData,          90,    daCenter,   true,      prefix + "eff_dt",          true,       "",                       dfDateYmd,  0,          true,       true);
                    InitDataProperty(0,   cnt++ , dtData,          90,    daCenter,   true,      prefix + "exp_dt",          true,       "",                       dfDateYmd,  0,          true,       true);
                    InitDataProperty(0,   cnt++ , dtCombo,         60,     daCenter,   true,      prefix + "acct_flg",        false,      "",                       dfNone,     0,          true,       true);
                    InitDataProperty(0,   cnt++ , dtData,          160,    daCenter,   true,      prefix + "diff_rmk",        false,      "",                       dfNone,     0,          true,       true);
                    InitDataProperty(0,   cnt++ , dtData,          120,    daCenter,   true,      prefix + "upd_usr_nm",      false,      "",                       dfNone,     0,          false,      false);
                    InitDataProperty(0,   cnt++ , dtData,          100,    daCenter,   true,      prefix + "upd_ofc_cd",      false,      "",                       dfNone,     0,          false,      false);
                    InitDataProperty(0,   cnt++ , dtData,          100,    daCenter,   true,      prefix + "upd_dt",          false,      "",                       dfDateYmd,  0,          false,      false);
                    InitDataProperty(0,   cnt++ , dtData,          0,      daCenter,   true,      prefix + "upd_usr_id",      false,      "",                       dfNone,     0,          false,      false);
                    InitDataProperty(0,   cnt++ , dtHidden,        0,      daCenter,   true,      prefix + "dup_cnt",         false,      "",                       dfNone,     0,          false,      false);
                    InitDataProperty(0,   cnt++ , dtHidden,        0,      daCenter,   true,      prefix + "current_dt",      false,      "",                       dfDateYmd,  0,          false,      false);
                    InitDataProperty(0,   cnt++ , dtHidden,        100,    daCenter,   false,     prefix + "calcu_dt",        false,      "DateDiff(d, |16|, |8|)", dfNone,     0,          false,      false);

                    InitDataCombo(0, prefix+ "acct_flg", "No|Yes", "N|Y");

                    PopupImage  =  "img/btns_search.gif";
                    //팝업과 콤보의 버튼 이미지를 표시하는 종류를 확인하거나 설정한다.
                    ShowButtonImage = 1; //Edit 가능할때 팝업 이미지 표시

                    //건수 정보의 표시 위치를 확인하거나 설정한다.
                    CountPosition = 0; //표시하지않음
               }
               break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction, param, row) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            //조회
            case IBSEARCH:
                //마스크 구분자 없애기 초기 로딩 시 오브젝트를 찾지 못함 스크립트 에러 방지를 위해 try 문 구현
                try{
                    ComClearSeparator(document.getElementById("cust_biz_no"), "saupja", "-")
                }catch(e) {
                }

                var condition = "?";

                if(document.getElementsByName("rdo_flag")[0].checked == true){
                    condition += "cust_type=to";
                }else{
                    condition += "cust_type=fm";
                }

                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("ESM_BKG_0999GS.do"+condition, FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
                break;

            //저장
            case IBSAVE:
                //그리드의 변경 여부 체크
                if(sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D") == 0){
                    ComShowCodeMessage('BKG00743');
                    return false;
                }

                if(!validateForm(sheetObj, formObj, sAction)) {
                    return false;
                }//end if

                document.form.insertRow.value = sheetObj.RowCount("I");
                formObj.f_cmd.value = MULTI;
                sheetObj.DoSave("ESM_BKG_0999GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),'', true);
                break;

            // 입력
            case IBINSERT:
                //sheetObj.DataInsert(-1);
                var idx = sheetObj.DataInsert(-1);
                //추가된 행의 사업자명에 포거스를 준다.
                sheetObj.SelectCell(sheetObj.SelectRow, "sheet1_mdtr_nm", true);
                //행이 추가되면 사업자 번호를 Edit 할 수 있도록 한다.
                //sheetObj.CellEditable(idx, "sheet1_mdtr_no") = true;

                sheetObj.CellValue(idx, "sheet1_upd_usr_nm") = document.form.user_nm.value
                sheetObj.CellValue(idx, "sheet1_upd_ofc_cd") = document.form.ofc_cd.value;
                sheetObj.CellValue(idx, "sheet1_upd_usr_id") = document.form.user_id.value;

                break;

            //수임자 위임자 사업자 번호 중복 조회
            /*
            2009-06-09 서버단에서 체크 하기로 결정 클라이언트에서는 IB Sheet 기능 이용 해서만 체크
            case IBSEARCH_ASYNC01:
                formObj.f_cmd.value = SEARCH01;

                //수임자 사업번호 위임자 사업번호로 카운트를 구해서 히든 컬럼에 세팅한다. 0 : 중복아님 0 값이 아니면 중복
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0999GS.do"+param, FormQueryString(formObj));
                sheetObj.CellValue2(row, "sheet1_dup_cnt") = ComGetEtcData(sXml, "dupCnt");
                break;
            */
        }
    }

    /**
     * HTML Control의 onfocus이벤트에서 Validation을 체크한다. <br>
     **/
    function attorneyPopOpen(){

        var fnc = "";
        var attyCustNm ="";

        fnc = "fncSetAttyBiz";

        document.getElementById("atty_cust_nm").value = document.getElementById("cust_name").value;

        var condition = "?";
            condition += FormQueryString(document.form);

        ComOpenPopup("/hanjin/ESM_BKG_1001.do"+condition, 400, 290, fnc, "1,0", true);
    }

    /**
     * Attorney Search 팝업에서 선택된 값을 위임자 조회 조건에 세팅한다.
     */
    function fncSetAttyBiz(aryPopupData){
        document.getElementById("cust_name").value = aryPopupData[0][2];
        document.getElementById("cust_biz_no").value = aryPopupData[0][3];
    }

    /**
     * 그리드에서 Attorney Search 팝업 호출
     */
    function sheet1_OnPopupClick(sheetObj,Row,Col){

        document.getElementById("atty_cust_nm").value = sheetObj.CellValue(Row, Col);

        var condition = "?";
            condition += FormQueryString(document.form);

        ComOpenPopup("/hanjin/ESM_BKG_1001.do"+condition, 400, 250, "setParam", "1,0", true, false, Row, Col, 0);
    }

    /**
     * Attorney Search 팝업에서 선택된 값을 sheet에 세팅한다.
     * 값 세팅 후 포커스를 다음 입력 항목으로 이동 시킨다.
     */
    function setParam(aryPopupData, row, col, sheetIdx){

        var prefix="sheet1_";
        var sheetObject = sheetObjects[0];

        sheetObject.CellValue(row,col)= aryPopupData[0][2];
        sheetObject.CellValue(row,parseInt(col)+1)= aryPopupData[0][3];

        if(sheetObjects[0].ColSaveName(col) =='sheet1_to_atty_biz_nm'){
            sheetObjects[0].SelectCell(row, "sheet1_fm_atty_biz_nm", true);
        }else{
            sheetObjects[0].SelectCell(row, "sheet1_eff_dt", true);
        }
    }

    /**
     * sheet1를 저장하고 나서 처리할 사항
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){

        if (ErrMsg == "") {
            /*
            var oForm = document.form;
            //저장 후 재 조회 한다. 조회 조건은 초기화 단 INSERT ROW가 존재 할 경우에 한하여 재 조회 한다.
            if(oForm.insertRow.value > 0){
                document.getElementById("fm_atty_biz_nm").value = '';
                document.getElementById("fm_atty_biz_no").value = '';
                document.getElementById("to_atty_biz_nm").value = '';
                document.getElementById("to_atty_biz_no").value = '';
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
            */
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            ComBkgSaveCompleted();  //서버메세지 처리
        }
    }

    /**
     * Grid의 OnChange 이벤트가 발생하면 처리 할 사항

    function sheet1_OnChange(sheetObj, row, col, value){
        //이벤트가 발생 체크 컬럼은 수임자명 , 수임자 사업자 번호, 위임자명, 위임자 사업자 번호로 제한
        if( sheetObj.ColSaveName(col) !='sheet1_to_atty_biz_no' &&
            sheetObj.ColSaveName(col) !='sheet1_fm_atty_biz_no' &&
            sheetObj.ColSaveName(col) !='sheet1_to_atty_biz_nm' &&
            sheetObj.ColSaveName(col) !='sheet1_fm_atty_biz_nm'){
            return;
        }

        //그리드의 RowStatus 상태가 입력모드이고(I) 수임자 위임자 사업자 번호가 입력되었다면 중복 체크를 수행한다.
        if( sheetObj.CellValue(row, "sheet1_to_atty_biz_no") !='' &&
            sheetObj.CellValue(row, "sheet1_fm_atty_biz_no") !='' &&
            sheetObj.RowStatus(row)=='I'){

            var param = "?";
                param += "to_atty_biz_no="+sheetObj.CellValue(row, "sheet1_to_atty_biz_no");
                param += "&fm_atty_biz_no="+sheetObj.CellValue(row, "sheet1_fm_atty_biz_no");

            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01, param, row);
        }
    }
    */

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){

        switch (sAction) {
            case IBSEARCH: // 조회
                return true;
                break;
            case IBSAVE:   // 저장

                if(!validGridDate(sheetObj)){
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
     * IBSheet 그리드에 입력된 사업자의 유효성을 체크한다.
     */
    function validGridDate(sheetObj) {

        for(var idx=1; idx <= sheetObj.RowCount; idx++){

            //if(sheetObj.RowStatus(idx) !='I'){
            //    continue;
            //}

            //if(sheetObj.CellValue(idx, "sheet1_dup_cnt")!='0' && sheetObj.CellValue(idx, "sheet1_dup_cnt")!=''){
            //    ComShowCodeMessage("BKG00764");
            //    sheetObj.SelectCell(idx, "sheet1_fm_atty_biz_no", true);
            //    return false;
            //    break;
            //}

            //수임자 사업번호에 대한 유효성을 체크합니다.
            if(sheetObj.RowStatus(idx) =='I' && sheetObj.CellValue(idx, "sheet1_fm_atty_biz_no")!=''){
                if(!ComIsSaupjaNo(sheetObj.CellValue(idx, "sheet1_fm_atty_biz_no"))){
                    ComShowCodeMessage("BKG40001");
                    sheetObj.SelectCell(idx, "sheet1_fm_atty_biz_no", true);
                    return false;
                    break;
                }
            }

            //위임자 사업번호에 대한 유효성을 체크합니다.
            if(sheetObj.RowStatus(idx) =='I' && sheetObj.CellValue(idx, "sheet1_to_atty_biz_no")!=''){
                if(!ComIsSaupjaNo(sheetObj.CellValue(idx, "sheet1_to_atty_biz_no"))){
                    ComShowCodeMessage("BKG40001");
                    sheetObj.SelectCell(idx, "sheet1_to_atty_biz_no", true);
                    return false;
                    break;
                }
            }

            //발효일자와 만료일자 간의 대소 관계 비교
            if(sheetObj.RowStatus(idx) =='I' || sheetObj.RowStatus(idx) =='U') {
	            if( ! ComIsEmpty(sheetObj.CellValue(idx, "sheet1_eff_dt")) && 
	                ! ComIsEmpty(sheetObj.CellValue(idx, "sheet1_exp_dt")) && 
	                ComChkPeriod(sheetObj.CellValue(idx, "sheet1_eff_dt"), sheetObj.CellValue(idx, "sheet1_exp_dt")) < 1){
	                ComShowCodeMessage("BKG40002");
	                return false;
	                break;
	            }
	
	            //발효일자와 만료일자 간의 기간 비교 5년 미만 입력 가능
	            if( ! ComIsEmpty(sheetObj.CellValue(idx, "sheet1_eff_dt")) && 
	                ! ComIsEmpty(sheetObj.CellValue(idx, "sheet1_exp_dt"))){
	                var interval = (ComGetDaysBetween(sheetObj.CellValue(idx, "sheet1_eff_dt"), sheetObj.CellValue(idx, "sheet1_exp_dt"))/30/12)
	                if( interval > 5){
	                    ComShowCodeMessage("BKG40003");
	                    return false;
	                    break;
	                }
	            }
            }
        }
        return true;
    }

    /**
     * IBSheet 그리드에 입력된 수임자, 위임자 사업자 번호의 중복 여부를 체크한다.
     */
    function dupSaupjaCheck(sheetObj) {

        var dRow = sheetObj.ColValueDup("sheet1_fm_atty_biz_no|sheet1_to_atty_biz_no", false);
        if(sheetObj.CellValue(dRow, "sheet1_fm_atty_biz_no") =='' || sheetObj.CellValue(dRow, "sheet1_to_atty_biz_no") ==''){
            //공백 열은 중복체크 예외 중복 체크 함수 이후 IbSheet 함수 do save의 KEY VALUE 체크 로직을 수행하도록 한다.
            return true;
        }
        if (dRow != -1) {
            ComShowCodeMessage('COM12115', 'saupja: ['+sheetObj.CellValue(dRow, "sheet1_fm_atty_biz_no")+']');
            sheetObj.SelectCell(dRow, sheetObj.SaveNameCol("sheet1_fm_atty_biz_no"));
            return false;
        } else {
            return true;
        }
    }

    function saupja_lenght(obj) {
    }

    /**
     * 데이터 조회 후 현재날짜와 비교하여 7일 이내의 만료일자 데이터에 대해서 붉은색으로 표시한다.
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){

        var prefix="sheet1_";

        if (ErrMsg == "") {
            for (var i=1; i<=sheetObj.RowCount; i++) {
                if( sheetObj.CellValue(i, prefix+'calcu_dt') <= 7){
                    sheetObj.CellFontColor(i, prefix+"seq")            = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"fm_atty_biz_nm") = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"fm_atty_biz_no") = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"to_atty_biz_nm") = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"to_atty_biz_no") = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"eff_dt")         = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"exp_dt")         = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"diff_rmk")       = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"upd_usr_nm")     = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"upd_ofc_cd")     = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"upd_dt")         = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    sheetObj.CellFontColor(i, prefix+"upd_usr_id")     = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                    //sheetObj.CellFontColor(i, prefix+"exp_dt") = sheetObj.RgbColor(255,0,0); //빨간색으로 표시
                }
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }

    /**
     * 수임자 위임자 값 초기화 시 사업자 번호를 초기화 시킨다.
     */
    function sheet1_OnAfterEdit(sheetObj, row, col) {
        var prefix="sheet1_";

        with (sheetObj) {

            if (sheetObj.CellValue(row, prefix+'to_atty_biz_nm') == ''){
                sheetObj.CellValue(row, prefix+'to_atty_biz_no') = "";
            }

            if (sheetObj.CellValue(row, prefix+'fm_atty_biz_nm') == ''){
                sheetObj.CellValue(row, prefix+'fm_atty_biz_no') = "";
            }
        }
    }

    /**
     * 엔터키 수행 시 조회 함수 호출
     */
    function enterKeySearch(){
        var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");

        if(ComIsEmpty(srcName)){
            return;
        }

        // 엔터키(13)이면
        if (keyCode == 13) {
            //조회조건 미 입력 시 알림 메세지
            if( ComIsEmpty(formObject.cust_name.value) && ComIsEmpty(formObject.cust_biz_no.value)){
                ComShowCodeMessage('BKG00701');
                eval("formObject."+srcName).focus();
                return false;
            }
            if(!ComIsEmpty(formObject.cust_biz_no.value) && !ComIsSaupjaNo(formObject.cust_biz_no.value)){
                ComShowCodeMessage("BKG40001");
                formObject.cust_biz_no.focus();
                return false;
            }
            doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
        } // end if
    }
    /* 개발자 작업  끝 */