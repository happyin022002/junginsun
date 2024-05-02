/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2038.js
 *@FileTitle : RFA Authority Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.24
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.07.24 문동규
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
     * @extends Pri
     * @class ESM_PRI_2038 : ESM_PRI_2038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2038 () {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
    }

    /* 개발자 작업   */


    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                    break;

                case "btn_New":
                    comboObjects[0].Code = "";
                    formObject.svc_scp_nm.value = "";
                    formObject.ofc_cd.value = "";
                    comboObjects[1].removeAll();
                    sheetObject1.ShowTreeLevel(0, 1);
                    sheetObject2.removeAll();
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObject2,formObject,IBSAVE);
                    break;

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수, IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBMultiCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj 필수, IBMultiCombo Object
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                // khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
    
                initSheet(sheetObjects[i],i+1);
                // khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }

            // IBMultiCombo초기화
            for(var k = 0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }

            var formObj = document.form;
            // Service Scope Combo 생성
            initIBComboItem();
            // 조직도 조회
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
            axon_event.addListenerForm('change', 'obj_change', formObj);
            axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
            axon_event.addListener ('keyup', 'obj_keyup', 'form');
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * Open 시에 조회한 Combo Item 을 IBMultiCombo 에 셋팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.04
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    }

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Office Code를 입력하면 해당 User List를 조회한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function obj_change () {
        try {
            var formObj = document.form;
            var srcName = event.srcElement.getAttribute("name");
            var sheetObject1 = sheetObjects[0];
            var sheetObject2 = sheetObjects[1];
            var sheetObject3 = sheetObjects[2];
            var comboObject1 = comboObjects[0];
            var comboObject2 = comboObjects[1];
    
            if (srcName == "ofc_cd") {
                if (formObj.ofc_cd.value == "") {
                    comboObject2.removeAll();
                    sheetObject2.removeAll();
                    // 전체 조직도 조회
                    doActionIBSheet(sheetObject1,formObj,IBSEARCH);
                } else {
                    comboObject2.removeAll();
                    sheetObject2.removeAll();
    
                    var idx = sheetObject1.FindText("ofc_cd", formObj.ofc_cd.value);
                    if (idx != -1) {
                        sheetObject1.ShowTreeLevel(0,1);
                        // Tree에서 선택
                        sheetObject1.SelectCell(idx, "ofc_eng_nm");
    
                        // 사용자콤보 데이터 조회
                        doActionIBSheet(sheetObject3,formObj,IBSEARCH_ASYNC01);
                        if (comboObject1.Code != "") {
                            // 권한정보 조회
                            doActionIBSheet(sheetObject2,formObj,IBSEARCH);
                        }
                    } else {
                        formObj.ofc_cd.value = "";
                        sheetObject1.SelectCell(1, "ofc_eng_nm");
                        sheetObject1.ShowTreeLevel(2, 1);
                    }
                }
            }
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * OnKeyUp 이벤트 발생시 호출되는 function <br>
     * Enter 키를 입력하면 조회함수를 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2010.02.04
     */
    function obj_keyup () {
        try {
            var formObj = document.form;
            var sheetObject2 = sheetObjects[1];
            var srcName = event.srcElement.getAttribute("name");
    
            if (event.keyCode == 13) {
                if (srcName == "ofc_cd") {
                    document.body.focus();
                } else {
                    doActionIBSheet(sheetObject2, formObj, IBSEARCH);
                }
            }
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * OnBlur 이벤트 발생시 호출되는 function <br>
     * Office Code를 입력하면 해당 User List를 조회한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function obj_deactivate() {
        ComChkObjValid(event.srcElement);
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} sheetNo 필수, IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1: // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "||Name||";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData, 10, daLeft, false, "", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "ofc_eng_nm", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "prnt_ofc_cd");
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "ofc_cd");
                    WaitImageVisible = false;

                    InitTreeInfo(2, "slevel", RgbColor(0,0,255), true);
                    GridLine = 0;
                    CountPosition = 0;
                }
                break;

            case 2:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|ID|Name|Title|Authority|Effective Date|";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,    false,   "ibflag");
                    InitDataProperty(0, cnt++ , dtData,          90,    daLeft,      false,   "usr_id",      false,  "",  dfNone,     0, false,  false);
                    InitDataProperty(0, cnt++ , dtData,          110,   daLeft,      false,   "usr_nm",      false,  "",  dfNone,     0, false,  false);
                    InitDataProperty(0, cnt++ , dtData,          180,   daLeft,      false,   "grd_eng_nm",  false,  "",  dfNone,     0, false,  false);
                    InitDataProperty(0, cnt++ , dtCombo,         80,    daCenter,    false,   "auth_flg",    false,  "",  dfNone,     0, true,   true);
                    InitDataProperty(0, cnt++ , dtData,          80,    daCenter,    false,   "eff_dt",      false,  "",  dfDateYmd,  0, true,   true);
                    InitDataProperty(0, cnt++ , dtHidden,        80,    daLeft,      false,   "prc_ctrt_tp_cd", false,  "",  dfNone,     0, false,  false);
                    WaitImageVisible = false;

                    InitDataCombo(0,    "auth_flg", "YES|NO",    "Y|N"   ,"NO",   "N");

                }
                break;
            case 3:     // Hidden sheet for Transaction
                with (sheetObj) {
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle = "status";

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                    // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                    // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                    // SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");

                    Visible = false;
                }
                break;
        }
    }

    /**
     * 콤보 초기설정값, 헤더 정의 <br>
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @param {int} comboNo 필수, IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function initCombo (comboObj, comboNo) {
        switch (comboObj.id) {
            case "svc_scp_cd":
                with (comboObj) {
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    MaxLength = 3;
                }
                break;

            case "usr_id":
                with (comboObj) {
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = false;
                    ValidChar(1, 3);
                }
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH_ASYNC01: // office code 입력 시, 사원콤보리스트 조회
                comboObjects[1].RemoveAll();

                formObj.f_cmd.value = SEARCH03;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_2038GS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, formObj.usr_id, "usr_id", "usr_id|usr_nm");
                getComboObject(comboObjects, "usr_id").InsertItem(0, '', '');

                break;
            case IBSEARCH:      //조회
                ComOpenWait(true);
                if (validateForm(sheetObj,formObj,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value = SEARCH01;
                        sheetObj.DoSearch("ESM_PRI_2038GS.do", FormQueryString(formObj));
                    } else if(sheetObj.id == "sheet2") {
                        formObj.f_cmd.value = SEARCH02;
                        sheetObj.DoSearch("ESM_PRI_2038GS.do", FormQueryString(formObj));
                    }
                }
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                ComOpenWait(true);
                if (validateForm(sheetObj,formObj,sAction)) {
                    if(sheetObj.id == "sheet2"){
                        if (!ComPriConfirmSave()) {
                            return;
                        }
                        formObj.f_cmd.value = MULTI;
                        sheetObj.DoSave("ESM_PRI_2038GS.do", FormQueryString(formObj), -1, false);
                    }
                }
                ComOpenWait(false);
                break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.07.24
     */
    function validateForm(sheetObj,formObj,sAction){

        switch(sAction){
            case IBSAVE:
                if(sheetObj.id == "sheet2") {
                    for(var i = 1, n = sheetObj.RowCount; i <= n; i++) {
                        if (sheetObj.CellValue(i, "auth_flg") == "Y" && sheetObj.CellValue(i, "eff_dt") == "") {
                            ComShowCodeMessage('PRI01001');
                            sheetObj.SelectCell(i,"eff_dt");
                            return false;
                        }
                    }
                }
            case IBSEARCH:
                if(sheetObj.id == "sheet2") {
                    if (comboObjects[0].Code == "") {
                        ComShowCodeMessage('PRI08002');
                        return false;
                    }
                    if (formObj.ofc_cd.value == "") {
                        // ComShowCodeMessage('PRI01001');
                        ComShowCodeMessage('PRI00316', 'Office Code');
                        formObj.ofc_cd.focus();
                        return false;
                    }
                }
                break;
        }

        return true;
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 Node를 펼침 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            sheetObj.ShowTreeLevel(2, 1);
        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 Authority가 NO인 항목은 Effective Date를 disable 처리함 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function sheet2_OnSearchEnd (sheetObj, ErrMsg) {
        var comboObj = comboObjects[1];
        for (var i = 1, n = sheetObj.RowCount; i <= n; i++) {
            if (sheetObj.CellValue(i, "auth_flg") == "N") {
                sheetObj.CellEditable(i, "eff_dt") = false;
            }
            if (sheetObj.CellValue(i, "usr_id") == comboObj.Code) {
                sheetObj.SelectCell(i, "usr_nm");
            }
        }
    }

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Authority가 'YES'로 선택하면 Effective Date 항목을 enable시키고 그 외는 disable 시킨다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} Row 필수, OnChange 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, OnChange 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수, 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {
        var colname = sheetObj.ColSaveName(Col);

        switch(colname)
        {
            case "auth_flg":
                if (Value == "Y") {
                    sheetObj.CellEditable(Row, "eff_dt") = true;
                } else {
                    sheetObj.CellEditable(Row, "eff_dt") = false;
                    sheetObj.CellValue(Row, "eff_dt") = "";
                }
                break;
        }
    }

    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 Node를 펼침 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, HTML태그(Object) 오브젝트
     * @param {int} Row 필수, Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수, 이벤트가 발생한 해당 셀의 Value
     * @returns 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function sheet1_OnClick (sheetObj, Row, Col, Value) {
        var colname = sheetObj.ColSaveName(Col);

        switch(colname)
        {
            case "ofc_eng_nm":
                try {
                    var formObj = document.form;
                    formObj.ofc_cd.value = sheetObj.CellValue(Row, "ofc_cd");
                    doActionIBSheet(sheetObjects[2],formObj,IBSEARCH_ASYNC01);
                    if (comboObjects[0].Code != "") {
                        doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
                    }
                } catch(e) {
                    if( e == "[object Error]") {
                        ComShowMessage(OBJECT_ERROR);
                    } else {
                        ComShowMessage(e);
                    }
                } finally {
                    ComOpenWait(false);
                }
                break;

        }
    }

    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Sheet에서 User ID 를 클릭 시 User Info Popup이 호출됨<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, HTML태그(Object) 오브젝트
     * @param {int} Row 필수, Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수, 이벤트가 발생한 해당 셀의 Value
     * @returns 없음
     * @author 문동규
     * @version 2009.09.18
     */
    function sheet2_OnClick (sheetObj, Row, Col, Value) {
        var colname = sheetObj.ColSaveName(Col);

        switch(colname)
        {
            case "usr_id":
                if (Value != "") {
                    ComUserPopup(Value);
                }
                break;
        }
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보에서 값을 변경하면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @param {string} code 필수, 선택된 항목의 value
     * @param {string} text 필수, 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function svc_scp_cd_OnChange (comboObj, code, text) {
        var formObj = document.form;

        var arrText = text.split("|");
        if (arrText != null && arrText.length > 1) {
            formObj.svc_scp_nm.value = arrText[1];
        } else {
            formObj.svc_scp_nm.value = "";
        }
    }

    /**
     * IBMultiCombo에서 OnClear 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보데이터가 모두 삭제되면 svc_scp_nm 항목도 clear한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @returns 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function svc_scp_cd_OnClear (comboObj) {
        var formObj = document.form;
        formObj.svc_scp_nm.value = "";

        comboObj.Index2 = -1;
    }

    /**
     * IBMultiCombo에서 OnBlur 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @returns 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function svc_scp_cd_OnBlur(comboObj) {
        var formObj = document.form;

        var code = comboObj.FindIndex(comboObj.Code, 0);

        if (code != null && code != "") {
            var text = comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
            }
        }
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * usr_id 콤보에서 값을 변경하면 선택한 값에 대한 usr_nm을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @param {string} code 필수, 선택된 항목의 value
     * @param {string} text 필수, 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function usr_id_OnChange (comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[1];

        var arrText = text.split("|");
        if (arrText != null && arrText.length > 1) {
            formObj.usr_nm.value = arrText[1];
        } else {
            formObj.usr_nm.value = "";
        }

        for (var i = 1, n = sheetObj.RowCount; i <= n; i++) {
            if (sheetObj.CellValue(i, "usr_id") == comboObj.Code) {
                sheetObj.SelectCell(i, "usr_nm");
                break;
            }
        }
    }

    /**
     * IBMultiCombo에서 OnBlur 이벤트 발생시 호출되는 function <br>
     * usr_id 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @returns 없음
     * @author 문동규
     * @version 2009.08.17
     */
    function usr_id_OnBlur (comboObj) {
        var formObj = document.form;

        var code = comboObj.FindIndex(comboObj.Code, 0);

        if (code != null && code != "") {
            var text = comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.usr_nm.value) {
                formObj.usr_nm.value = comboObj.GetText(code, 1);
            }
        } else {
            formObj.usr_nm.value = "";
        }
    }

    /**
     * IBMultiCombo에서 OnClear 이벤트 발생시 호출되는 function <br>
     * usr_id 콤보데이터가 모두 삭제되면 usr_nm 항목도 clear한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @returns 없음
     * @author 문동규
     * @version 2009.07.24
     */
    function usr_id_OnClear (comboObj) {
        var formObj = document.form;
        formObj.usr_nm.value = "";
        comboObj.Index2 = -1;
    }

    /* 개발자 작업  끝 */