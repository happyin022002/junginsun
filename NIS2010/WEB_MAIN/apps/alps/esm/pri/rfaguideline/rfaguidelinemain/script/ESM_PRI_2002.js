/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2002.js
 *@FileTitle : Guideline Creation [Copy]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.09
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.09.09 문동규
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
     * @class ESM_PRI_2002 : ESM_PRI_2002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2002 () {
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
     * @version 2009.09.09
     */
    function processButtonClick () {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
    
        /*******************************************************/
        var formObj = document.form;
    
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {              
                if (getButtonTable(srcName).disabled) {
                    return false;
                }
            }

            switch (srcName) {
                case "btn_OK":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;
    
                case "btn_Close":
                    window.close();
                    break;
    
                case "btns_calendar1": //달력버튼
                case "btns_calendar2": //달력버튼
                    var cal = new ComCalendarFromTo();
                    cal.select(formObj.trgt_eff_dt, formObj.trgt_exp_dt, 'yyyy-MM-dd');
                    break;
    
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
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
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.09.09
     */
    function setSheetObject (sheet_obj) {
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
     * @param {ibcombo} combo_obj 필수 IBMultiCombo Object
     * @return 없음
     * @author 문동규
     * @version 2009.09.09
     */
    function setComboObject (combo_obj) {
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
     * @version 2009.09.09
     */
    function loadPage () {
        try {
            // IBMultiCombo초기화
            for ( var k = 0; k < comboObjects.length; k++) {
                initCombo(comboObjects[k], k + 1);
            }
            for (i = 0; i < sheetObjects.length; i++) {
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            initControl();
            initIBComboItem();
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
     * 업무 자바스크립트 OnActivate/OnDeactivate 이벤트 Listener를 추가한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.04
     */
    function initControl () {
        var formObj = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
    }
    
    /**
     * 업무 자바스크립트 OnActivate 이벤트를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.04
     */
    function obj_activate () {
        var formObj = document.form;
        var eleName = event.srcElement.name;
    
        switch (eleName) {
            case "trgt_eff_dt":
            case "trgt_exp_dt":
                // 마스크 구분자 없애기
                ComClearSeparator(event.srcElement);
                break;
        }
    }
    
    /**
     * 업무 자바스크립트 OnDeactivate 이벤트를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.04
     */
    function obj_deactivate () {
        var formObj = document.form;
        var eleName = event.srcElement.name;
    
        switch (eleName) {
            case "trgt_eff_dt":
            case "trgt_exp_dt":
                // 입력Validation 확인 및 마스킹 처리
                ComChkObjValid(event.srcElement);
                break;
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
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects,'trgt_svc_scp_cd'),"|","\t");
    }
    
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.09.09
     */
    function initSheet (sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetId = sheetObj.id;
    
        switch (sheetId) {
    
            case "sheet1":
                with (sheetObj) {
    
                    // 높이 설정
                    style.height = 95;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);
    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);
    
                    var HeadTitle1 = "|Service Scope|Duration|Duration|Rate|Location\nGroup|Commodity\nGroup|Origin\nArbitrary|Destination\nArbitrary|rt_cmdt_chk|rt_loc_chk|aro_loc_chk|ard_loc_chk";
                    var HeadTitle2 = "|Service Scope|Effective|Expiration|Rate|Location\nGroup|Commodity\nGroup|Origin\nArbitrary|Destination\nArbitrary|rt_cmdt_chk|rt_loc_chk|aro_loc_chk|ard_loc_chk";
                    var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false, false)
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, false);
    
                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,   COLMERGE,   SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtHiddenStatus,       0,      daCenter,   true,       "hdnStatus");
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "svc_scp_cd", false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false);
                    InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false);
                    InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, true, "rate_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, true, "loc_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 70, daCenter, true, "cmdt_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 70, daCenter, true, "arb_org_chk");
                    InitDataProperty(0, cnt++, dtCheckBox, 70, daCenter, true, "arb_des_chk");

                    InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rt_cmdt_chk");
                    InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rt_loc_chk");
                    InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "aro_loc_chk");
                    InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ard_loc_chk");
                    WaitImageVisible = false;
                    CountPosition = 0;
                    SelectHighLight = false;
                }
                break;
    
            case "sheet2":  // hidden
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
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.09.09
     */
    function initCombo (comboObj, comboNo) {
        switch (comboObj.id) {
            case "trgt_svc_scp_cd":
                with (comboObj) {
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;
    
        }
    }
    
    var isAuthUsr = false;
    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 문동규
     * @version 2009.09.09
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
    
            case IBSEARCH: //조회
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    if ("sheet1" == sheetObj.id) {
                        formObj.f_cmd.value = SEARCH;
                        sheetObj.DoSearch("ESM_PRI_2002GS.do", FormQueryString(formObj));
                    }
                }
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01:
                var sParam = "f_cmd="+COMMAND15+"&pagerows=&prc_ctrt_tp_cd=R&svc_scp_cd=" + getComboObject(comboObjects, "trgt_svc_scp_cd").Code + "&usr_id=" + formObj.usr_id.value;
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
                var arrAuth = ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");

                if (arrAuth != null && arrAuth.length > 0) {
                    isAuthUsr = true;
                } else {
                    isAuthUsr = false;
                }
                toggleButtons();
                break;
    
            case IBSAVE: //저장
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction) && ComShowCodeConfirm('PRI00012')) {
                    formObj.f_cmd.value = MULTI;
                    sheetObj.DoAllSave("ESM_PRI_2002GS.do", FormQueryString(formObj));
                }
                ComOpenWait(false);
                break;
    
        }
    }

    /**
    * 사용자권한에 따라 버튼을 enable/disable 한다<br>
    * <br><b>Example :</b>
    * <pre>
    *     toggleButtons();
    * </pre>
    * @return 없음
    * @author 문동규
    * @version 2009.09.17
    */
    function toggleButtons() {
        if (isAuthUsr) {
            ComBtnEnable("btn_OK");
        } else {
            ComBtnDisable("btn_OK");
        }
    }

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Rate 선택 시에는 Group Commodity, Group Location 은 자동 선택됨<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnChange 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnChange 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.06.10
     */
    function sheet1_OnChange (sheetObj, Row, Col, Value) {
        var colname = sheetObj.ColSaveName(Col);
        var formObj = document.form;
    
        switch (colname) {
            case "rate_chk":
                if (Value == 1) {
                    if (sheetObj.CellEditable(Row, "loc_chk") && sheetObj.CellValue(Row, "rt_loc_chk") == "1") {
                        sheetObj.CellValue2(Row, "loc_chk") = 1;
                    }
                    if (sheetObj.CellEditable(Row, "cmdt_chk") && sheetObj.CellValue(Row, "rt_cmdt_chk") == "1") {
                        sheetObj.CellValue2(Row, "cmdt_chk") = 1;
                    }
                }
                break;

            case "arb_org_chk":
                if (Value == 1) {
                    if (sheetObj.CellEditable(Row, "loc_chk") && sheetObj.CellValue(Row, "aro_loc_chk") == "1") {
                        sheetObj.CellValue2(Row, "loc_chk") = 1;
                    }
                }
                break;

            case "arb_des_chk":
                if (Value == 1) {
                    if (sheetObj.CellEditable(Row, "loc_chk") && sheetObj.CellValue(Row, "ard_loc_chk") == "1") {
                        sheetObj.CellValue2(Row, "loc_chk") = 1;
                    }
                }
                break;

            case "loc_chk":
                if (Value == 0) {
                    if (sheetObj.CellValue(Row, "rate_chk") == 1 && sheetObj.CellValue(Row, "rt_loc_chk") == "1") {
                        sheetObj.CellValue2(Row, "rate_chk") = 0;
                    }
                    if (sheetObj.CellValue(Row, "arb_org_chk") == 1 && sheetObj.CellValue(Row, "aro_loc_chk") == "1") {
                        sheetObj.CellValue2(Row, "arb_org_chk") = 0;
                    }
                    if (sheetObj.CellValue(Row, "arb_des_chk") == 1 && sheetObj.CellValue(Row, "ard_loc_chk") == "1") {
                        sheetObj.CellValue2(Row, "arb_des_chk") = 0;
                    }
                }
                break;
    
            case "cmdt_chk":
                if (Value == 0 && sheetObj.CellValue(Row, "rate_chk") == 1 && sheetObj.CellValue(Row, "rt_cmdt_chk") == "1") {
                    sheetObj.CellValue2(Row, "rate_chk") = 0;
                }
                break;
        }// end switch
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.09.09
     */
    function validateForm (sheetObj, formObj, sAction) {
    
        switch (sAction) {
            case IBSAVE:
                // 1.IBSheet Data Check
                if (sheetObj.CellValue(2, "rate_chk") != 1 && sheetObj.CellValue(2, "loc_chk") != 1
                        && sheetObj.CellValue(2, "cmdt_chk") != 1 && sheetObj.CellValue(2, "arb_org_chk") != 1
                        && sheetObj.CellValue(2, "arb_des_chk") != 1) {
                    ComShowCodeMessage('PRI01043');
                    return false;
                }
    
                // 2.IBMultiCombo Data Check
                if (getComboObject(comboObjects, "trgt_svc_scp_cd").Code == "") {
                    ComShowCodeMessage('PRI01029');
                    getComboObject(comboObjects, "trgt_svc_scp_cd").focus();
                    return false;
                }
    
                // 3.Form 기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크
                if (!ComChkValid(formObj))
                    return false;
    
                // 4.Effective Date Check
                formObj.f_cmd.value = SEARCH01;
                sheetObjects[1].DoSearch("ESM_PRI_2002GS.do", FormQueryString(formObj));
    
                if (sheetObjects[1].EtcData("valid") == "FALSE") {
                    formObj.trgt_eff_dt.select();
                    formObj.trgt_eff_dt.focus();
                    return false;
                }
    
                break;
        }
    
        return true;
    }
    
    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * trgt_svc_scp_cd 콤보에서 값을 변경하면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function trgt_svc_scp_cd_OnChange (comboObj, code, text) {
        var formObj = document.form;
    
        var arrText = text.split("|");
        if (arrText != null && arrText.length > 1) {
            formObj.trgt_svc_scp_nm.value = arrText[1];
        } else {
            formObj.trgt_svc_scp_nm.value = "";
        }
        checkAuthUser (comboObj);
    }
    
    /**
     * IBMultiCombo에서 OnClear 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보데이터가 모두 삭제되면 svc_scp_nm 항목도 clear한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function trgt_svc_scp_cd_OnClear (comboObj) {
        var formObj = document.form;
        formObj.trgt_svc_scp_nm.value = "";
    
        comboObj.Index2 = -1;
    }
    
    /**
     * IBMultiCombo에서 OnBlur 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function trgt_svc_scp_cd_OnBlur (comboObj) {
        var formObj = document.form;
    
        var code = comboObj.FindIndex(comboObj.Code, 0);
    
        if (code != null && code != "") {
            var text = comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.trgt_svc_scp_nm.value) {
                formObj.trgt_svc_scp_nm.value = comboObj.GetText(code, 1);
            }
            checkAuthUser (comboObj);
        }
    }

    /**
     * 선택한 Service Scope 에 대한 권한을 체크한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     checkAuthUser (comboObjects[0]);
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function checkAuthUser (comboObj) {
        var formObj = document.form;
        var sheetObj2 = sheetObjects[1];

        doActionIBSheet(sheetObj2, formObj, IBSEARCH_ASYNC01);

    }
    
    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * 데이터가 없는 항목은 선택을 못하게 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            var formObj = document.form;
            // 체크박스 enable/disable
            for ( var i = sheetObj.HeaderRows, n = sheetObj.RowCount + sheetObj.HeaderRows; i < n; i++) {
                if (sheetObj.CellValue(i, "rate_chk") != 1) {
                    sheetObj.CellEditable(i, "rate_chk") = false;
                }
                if (sheetObj.CellValue(i, "loc_chk") != 1) {
                    sheetObj.CellEditable(i, "loc_chk") = false;
                }
                if (sheetObj.CellValue(i, "cmdt_chk") != 1) {
                    sheetObj.CellEditable(i, "cmdt_chk") = false;
                }
                if (sheetObj.CellValue(i, "arb_org_chk") != 1) {
                    sheetObj.CellEditable(i, "arb_org_chk") = false;
                }
                if (sheetObj.CellValue(i, "arb_des_chk") != 1) {
                    sheetObj.CellEditable(i, "arb_des_chk") = false;
                }
            }
            getComboObject(comboObjects, "trgt_svc_scp_cd").Code = formObj.svc_scp_cd.value;
            
            formObj.trgt_svc_scp_nm.value = getComboObject(comboObjects, "trgt_svc_scp_cd").GetText(formObj.svc_scp_cd.value, 1)
        }
    }
    
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 정삭적으로 Copy 후 창을 닫는다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.09.15
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            dialogArguments.reloadPostCopy(getComboObject(comboObjects, "trgt_svc_scp_cd").Code, sheetObj.EtcData("glineSeq"));
            window.close();
        }
    }

    /* 개발자 작업  끝 */