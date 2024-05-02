/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3007.js
 *@FileTitle : TAA Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.18
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.11.18 문동규
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
     * @class ESM_PRI_3007 : ESM_PRI_3007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3007 () {
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
     * @version 2009.11.20
     */
    function processButtonClick(){
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

            switch(srcName) {

                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1, formObj, IBSEARCH);
                    break;

                case "btn_Cancel":
                    doActionIBSheet(sheetObject1, formObj, IBRESET);
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObject1, formObj, IBSAVE);
                    break;

                case "btn_New":
                    doActionIBSheet(sheetObject1, formObj, IBCREATE);
                    break;

                case "btn_Confirm":
                    doActionIBSheet(sheetObject1, formObj, MODIFY01);
                    break;

                case "btn_ConfirmCancel":
                    doActionIBSheet(sheetObject1, formObj, MODIFY02);
                    break;

                case "btn_Amend":
                    var param = "taa_no="+sheetObject1.CellValue(1,"taa_no")+"&amdt_seq="+sheetObject1.CellValue(1,"amdt_seq")+"&eff_dt="+formObj.eff_dt.value+"&exp_dt="+formObj.exp_dt.value;
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_3017.do?"+param, "", 400, 165, true);
                    if (rtnVal != null && rtnVal.taaNo != null){
                        formObj.taa_no.value = rtnVal.taaNo;
                        getComboObject(comboObjects, "amdt_seq").RemoveAll();
                        doActionIBSheet(sheetObject1, formObj, IBSEARCH);
                    }
                    
                    break;

                case "btn_RowAdd":
                    doActionIBSheet(sheetObject2, formObj, IBINSERT);
                    break;

                case "btn_RowDelete":
                    doActionIBSheet(sheetObject2, formObj, IBDELETE);
                    break;

                case "btns_calendar1": //달력버튼
                case "btns_calendar2":
                    var cal = new ComCalendarFromTo();
                    cal.select(formObj.eff_dt, formObj.exp_dt, 'yyyy-MM-dd');
                    break;

                case "btn_taa_no":
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_3008.do", "", 900, 320, true);
                    if (rtnVal != null){
                        formObj.taa_no.value = rtnVal;
                        getComboObject(comboObjects, "amdt_seq").RemoveAll();
                        doActionIBSheet(sheetObject1, formObj, IBSEARCH);
                    }
                    
                    break;

                case "btn_ctrt_cust":
                    var param = "is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.ctrt_cust_cnt_cd.value+"&cust_seq="+formObj.ctrt_cust_seq.value;
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?"+param, "", 640, 457, true);
                    if (rtnVal != null){
                        formObj.ctrt_cust_cnt_cd.value = rtnVal.custCntCd;
                        formObj.ctrt_cust_seq.value = rtnVal.custSeq;
                        formObj.ctrt_cust_nm.value = rtnVal.custNm;
                        custNameFind("ctrt_cust_cnt_cd");
                        formChangeSheet(sheetObject1, "ctrt_cust_cnt_cd");
                        formChangeSheet(sheetObject1, "ctrt_cust_seq");
                        //sale rep
                        setCustSaleRep();
                        getComboObject(comboObjects, "respb_srep_cd").Code2 = sheetObject1.CellValue(1,"respb_srep_cd");
                    }

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
     * @version 2009.11.20
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
     * @version 2009.11.20
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
     * @version 2009.11.20
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
    
                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            // IBMultiCombo초기화
            for(var k = 0; k < comboObjects.length; k++){
                initCombo(comboObjects[k], k + 1);
            }
            initControl();
            
            var arrVal = svcScpTrfsValue.split("|");
            var arrText = svcScpTrfsText.split("|");
            // Scope 별 Trf Code
            for (var i = 0 , n = arrVal.length ; i < n ; i++) {
                hmap.put(arrVal[i], arrText[i]);
            }
            
            // Service Scope Combo 생성
            initIBComboItem();
            var formObj = document.form;
            if (formObj.cond_taa_no.value != "") {
                formObj.taa_no.value = formObj.cond_taa_no.value;
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            } else {
                doActionIBSheet(sheetObjects[0], formObj, IBCREATE);
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

    var hmap = new HashMap();  // Scope 별 Trf Code
    var usrSrepAuth = "N";    // Save 권한
    var usrOfcAuth  = "N";    // Save/Update/Confirm/Amend 권한
    var usrAprvAuth = "N";    // Sales Rep Code 수정 권한

    /**
     * 사용자 권한을 체크한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     checkUserAuth();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2010.01.13
     */
    function checkUserAuth() {
        var formObj = document.form;
        // 등록권한 체크 : Srep Code 유무 체크
        if (formObj.usr_srep_cd.value != "") {
            usrSrepAuth = "Y";
        } else {
            usrSrepAuth = "N";
        }
        
        // 수정권한 체크 : Office Code 포함 여부 체크
        if (formObj.respb_sls_ofc_cd.value != "" && formObj.respb_sls_ofc_cd.value == formObj.usr_ofc_cd.value) {
            usrOfcAuth = "Y";
        } else {
            usrOfcAuth = "N";
        }

        // 승인권한 체크 : Service Scope Code 체크
        if (getComboObject(comboObjects, "svc_scp_cd").Code != "") {
            formObj.f_cmd.value = SEARCH05;
            var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_3007GS.do" , FormQueryString(formObj));
            usrAprvAuth = ComGetEtcData(sXml, "approvalAuth");
        } else {
            usrAprvAuth = "N";
        }
    }

    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.11.30
     */
    function initControl () {
        var formObj = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerForm('change', 'obj_change', formObj);
        axon_event.addListenerForm('focus', 'obj_activate', formObj);
        axon_event.addListenerForm('blur', 'obj_deactivate', formObj);
        axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
        axon_event.addListenerFormat('keyup', 'obj_keyup', formObj);
        //axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }

    /**
     * Open 시에 조회한 Combo Item 을 IBMultiCombo 에 셋팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    }

    /**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function obj_keypress () {
        switch (event.srcElement.dataformat) {
            case "engup":
                if (event.srcElement.name == "taa_no") {
                    ComKeyOnlyAlphabet('uppernum');
                } else {
                    ComKeyOnlyAlphabet('upper');
                }
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            case "float":
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "ymd":
                ComKeyOnlyNumber(event.srcElement, "-");
                break;
            default:
        }

        switch (event.srcElement.name) {
            case "taa_no":
                var formObj = document.form;
                formObj.taa_prop_no.value = "";
                formObj.cond_taa_no.value = "";
                formObj.eff_dt.value = "";
                formObj.exp_dt.value = "";
                formObj.cfm_nm.value = "";
                formObj.svc_scp_nm.value = "";
                formObj.ctrt_cust_cnt_cd.value = "";
                formObj.ctrt_cust_seq.value = "";
                formObj.ctrt_cust_nm.value = "";
                formObj.respb_sls_ofc_cd.value = "";
                formObj.respb_srep_nm.value = "";
                formObj.org_pnt_loc_nm.value = "";
                formObj.org_via_port_nm.value = "";
                formObj.dest_via_port_nm.value = "";
                formObj.dest_pnt_loc_nm.value = "";

                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                getComboObject(comboObjects, "amdt_seq").RemoveAll();
                getComboObject(comboObjects, "respb_srep_cd").RemoveAll();
                sheetObjects[0].DataInsert();
                    
                getComboObject(comboObjects, "svc_scp_cd").Code2 = "";
                sheetObjects[0].CellValue2(1, "cfm_flg") = "N";
                
                break;
            default:
        }
    }

    /**
     * OnKeyUp event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2010.03.12
     */       
    function obj_keyup(){
        //enter key조회
        var eleName = event.srcElement.name;
        if (eleName == "taa_no"){
//            var keyValue = null;
//            if(event == undefined || event == null) {
//                keyValue = 13;
//            }else{
//                keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//            }
//            if (keyValue == 13){
//                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//            }
            if (event.keyCode == 13){
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
        }
    }

    /**
     * OnChange event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function obj_change () {
        switch (event.srcElement.name) {
            case "taa_no":
                sheetObjects[0].CellValue2(1, "amdt_seq") = "";
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                break;
            default:
        }
    }

    /**
     * Onbeforedeactivate Event를 처리한다. <br>
     * 이 Event 사용시 여러가지 문제가 발생하여 OnBlur로 Event를 변경함.<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function obj_deactivate () {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var eleName = event.srcElement.name;

        switch (eleName) {
            case "taa_no":
                formChangeSheet(sheetObj, eleName);
                break;
            case "ctrt_cust_cnt_cd":
                //cust name find
                if (formObj.ctrt_cust_cnt_cd.value != "") {
                    custNameFind(eleName);
                    // sales rep
                    setCustSaleRep();
                    // COMBO를 채워 준 후 조회해온 코드를 채운다.
                    getComboObject(comboObjects, "respb_srep_cd").Code2 = sheetObj.CellValue(1, "respb_srep_cd");
                } else {
                    clearCustName();
                }
                ComChkObjValid(event.srcElement);

                break;
            case "ctrt_cust_seq":
                var custSeq = ComTrim(formObj.ctrt_cust_seq.value);
                formObj.ctrt_cust_seq.value = custSeq;
                
                var re = new RegExp();
                re.compile("[\\D]");
                
                // 문자가 들어오면 reset
                if (re.test(custSeq)) {
                    clearCustName();
                    return;
                }

                if (custSeq.length < 6 && custSeq.length != 0) {
                    formObj.ctrt_cust_seq.value = ComLpad(custSeq, 6, "0");
                }

                //cust name find
                if (ComParseInt(sheetObj.CellValue(1, "ctrt_cust_seq")) != ComParseInt(formObj.ctrt_cust_seq.value)) {
                    if (formObj.ctrt_cust_seq.value != "") {
                        custNameFind(eleName);
                        // sale rep
                        setCustSaleRep();
                        getComboObject(comboObjects, "respb_srep_cd").Code2 = sheetObj.CellValue(1, "respb_srep_cd");
                    } else {
                        clearCustName();
                    }
                }
                break;
            case "exp_dt":
                formChangeSheet(sheetObj, eleName);
                ComChkObjValid(event.srcElement);
                break;
            case "eff_dt":
                formChangeSheet(sheetObj, eleName);
                ComChkObjValid(event.srcElement);
                break;

            default:
                ComChkObjValid(event.srcElement);
        }
    }

    /**
     * OnBeforeActivate Event를 처리한다. <br>
     * 이 Event 사용시 여러가지 문제가 발생하여 OnFocus로 Event를 변경함.<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function obj_activate () {
        var formObj = document.form;
        var sElement = event.srcElement;
        var srcName = sElement.getAttribute("name");
        ComClearSeparator(sElement);
        try{
            sElement.select();
        }catch(e){}
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
     * @version 2009.11.20
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":  // hidden
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    var HeadTitle = "|TAA No|TAA Proposal No|Amdt Seq|Service Scope|Service Scope Name|Effective Date|Expire Date|Ctrt Cust Seq|Ctrt Cust Cnt Cd|prc-ctrt_cust_tp_cd|ctrt_cust_nm|ctrt_cust_val_sgm_cd|respb_srep_cd|respb_srep_nm|respb_sls_ofc_cd|cfm_flg|cfm_nm";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 6, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,   true,  "ibflag");
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter,   true,   "taa_no",               false, "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter,   true,   "taa_prop_no",          false, "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        20,  daCenter,   true,   "amdt_seq",             false, "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter,   true,   "svc_scp_cd",           true,  "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter,   true,   "svc_scp_nm",           false, "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        70,  daCenter,   true,   "eff_dt",               true,  "",dfDateYmd, 0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        70,  daCenter,   true,   "exp_dt",               true,  "",dfDateYmd, 0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        70,  daCenter,   true,   "ctrt_cust_seq",        true,  "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        40,  daLeft,     true,   "ctrt_cust_cnt_cd",     true,  "",dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter,   true,   "prc_ctrt_cust_tp_cd",  false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter,   true,   "ctrt_cust_nm",         false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        85,  daCenter,   true,   "ctrt_cust_val_sgm_cd", false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter,   true,   "respb_srep_cd",        false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter,   true,   "respb_srep_nm",        false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtData,        70,  daCenter,   true,   "respb_sls_ofc_cd",     false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtPopup,       70,  daCenter,   true,   "cfm_flg",              false, "",dfNone,    0,  false,  true);
                    InitDataProperty(0, cnt++ , dtPopup,       70,  daCenter,   true,   "cfm_nm",               false, "",dfNone,    0,  false,  true);
                    WaitImageVisible = false;

                    Visible = false;
                }
                break;

            case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 246;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    var HeadTitle = "|Sel.|Seq.|taa_prop_no|amdt_seq|tri_prop_no|Tariff Rate Item\n(TRI)|Commodity|Commodity|Route|Route|Route|Route|Route nm|Route nm|Route nm|Route nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Duration|Duration|trf_pfx_cd|trf_no";
                    var HeadTitle1 = "|Sel.|Seq.|taa_prop_no|amdt_seq|tri_prop_no|Tariff Rate Item\n(TRI)|Code|Description|Origin|Origin Via|Dest Via|Dest|Origin Nm|Origin Via Nm|Dest Via Nm|Dest Nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Effective|Expiration|trf_pfx_cd|trf_no";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 6, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,    50,  daCenter, true,  "chk",               false,  "",dfNone,   0,    true,   true);
                    InitDataProperty(0, cnt++ , dtDataSeq,     30,  daCenter, true,  "seq",               false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      10,  daCenter, true,  "taa_prop_no",       false,  "",dfNone,   0,    false,  false);  // Hidden
                    InitDataProperty(0, cnt++ , dtHidden,      10,  daCenter, true,  "amdt_seq",          false,  "",dfNone,   0,    false,  false);  // Hidden
                    InitDataProperty(0, cnt++ , dtHidden,      10,  daCenter, true,  "tri_prop_no",       true,   "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        115, daCenter, true,  "tri_no",            true,   "",dfUserFormat,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter, true,  "cmdt_cd",           false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        120, daLeft,   true,  "cmdt_nm",           false,  "",dfNone,   0,    false,  false);

                    InitDataProperty(0, cnt++ , dtData,        108, daLeft,   true,  "org_pnt_loc_cd",    false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        60,  daLeft,   true,  "org_via_port_cd",   false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        60,  daLeft,   true,  "dest_via_port_cd",  false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        108, daLeft,   true,  "dest_pnt_loc_cd",   false,  "",dfNone,   0,    false,  false);

                    InitDataProperty(0, cnt++ , dtHidden,      120, daLeft,   true,  "org_pnt_loc_nm",    false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "org_via_port_nm",   false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "dest_via_port_nm",  false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      120, daLeft,   true,  "dest_pnt_loc_nm",   false,  "",dfNone,   0,    false,  false);

                    InitDataProperty(0, cnt++ , dtData,        35,  daCenter, true,  "rat_ut_cd",         false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        40,  daCenter, true,  "prc_cgo_tp_cd",     false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        38,  daCenter, true,  "curr_cd",           false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        62,  daRight,  true,  "fnl_frt_rt_amt",    false,  "",dfFloat,  0,    false,  false);

                    InitDataProperty(0, cnt++ , dtPopup,       70,  daLeft,   true,  "note_ctnt",         false,  "",dfNone,   0,    true,   true);
                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "note_conv_mapg_id", false,  "",dfNone,   0,    false,  false);    // Hidden
                    InitDataProperty(0, cnt++ , dtData,        65,  daCenter, true,  "eff_dt",            false,  "",dfDateYmd,0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        65,  daCenter, true,  "exp_dt",            false,  "",dfDateYmd,0,    false,  false);

                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "trf_pfx_cd",        false,  "",dfNone,   0,    false,  false);    // Hidden
                    InitDataProperty(0, cnt++ , dtHidden,      70,  daLeft,   true,  "trf_no",            false,  "",dfNone,   0,    false,  false);    // Hidden
                    WaitImageVisible = false;
                    Ellipsis = true;
                    AutoRowHeight = false;

                    InitUserFormat(0, "tri_no", "######-####-###", "-");
                    ShowButtonImage = 2;
                    CountPosition = 0;
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
     * @version 2009.11.20
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

            case "amdt_seq":
                with (comboObj) {
                    DropHeight = 100;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = false;
                }
                break;

            case "respb_srep_cd":
                with (comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                    ValidChar(2, 1);
                    MaxLength = 5;
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
     * @version 2009.11.20
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      // Retrieve
                ComOpenWait(true);
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }

                // Route Name 항목을 Clear
                formObj.org_pnt_loc_nm.value = "";
                formObj.org_via_port_nm.value = "";
                formObj.dest_via_port_nm.value = "";
                formObj.dest_pnt_loc_nm.value = "";
                
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_3007GS.do" , FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) {
                    sheetObjects[0].LoadSearchXml(arrXml[0]);    // sheet1. hidden sheet - main 데이터
                }
                if (arrXml.length > 1) {
                    sheetObjects[1].LoadSearchXml(arrXml[1]);
                }
                //sale rep
                doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
                ComOpenWait(false);
                buttonControl();
                break;

            case IBSAVE:        // Save
                ComOpenWait(true);
                // 저장시에 한번 더 sheet에 copy함
//                var items = formObj.elements;
//                var itemlen = items.length;
//                for (var i = 0 ; i < itemlen ; i++) {
//                    if (items[i].name == "") continue;
//                    formChangeSheet (sheetObjects[0], items[i].name);
//                }
                
                if (!validateForm(sheetObjects[0],formObj,sAction)) {
                    return false;
                }
                if (!ComPriConfirmSave()) {
                    return false;
                }

                formObj.f_cmd.value = MULTI01;
                var sParam = "";

                var sParamSheet1 = sheetObjects[0].GetSaveString();
                var sParamSheet2 = sheetObjects[1].GetSaveString();

                if (sheetObjects[0].IsDataModified && sParamSheet1 == "") {
                    return;
                }
                if (sheetObjects[1].IsDataModified && sParamSheet2 == "") {
                    return;
                }

                if (sParamSheet1 == "" && sParamSheet2 == "") {
                    ComShowCodeMessage("PRI00301");
                    return;
                }

                if (sParamSheet1 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                }

                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                sParam += "&" + FormQueryString(formObj);
                var sXml = sheetObj.GetSaveXml("ESM_PRI_3007GS.do", sParam);

                sheetObjects[0].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);
                sheetObjects[1].LoadSaveXml(sXml);

                ComOpenWait(false);
                buttonControl();
                break;

            case IBINSERT:      // Row Add
                if (sheetObj.id == "sheet1") {
                    var row = sheetObj.DataInsert();
                } else if (sheetObj.id == "sheet2") {
                    if (!validateForm(sheetObj,formObj,sAction)) {
                        return false;
                    }
                    var param = "svc_scp_cd="+getComboObject(comboObjects, "svc_scp_cd").Code;
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_3009.do?"+param, "", 1010, 495, true);
                    if (rtnVal != null){
                        var arr = rtnVal;
                        var row = 0;
                        var obj = null;
                        for (var i = 0, n = arr.length ; i < n ; i++) {
                            row = sheetObj.DataInsert();
                            obj = arr[i];
                            sheetObj.CellValue2(row, "taa_prop_no")       = sheetObjects[0].CellValue(1, "taa_prop_no");
                            sheetObj.CellValue2(row, "amdt_seq")          = sheetObjects[0].CellValue(1, "amdt_seq");
                            sheetObj.CellValue2(row, "tri_prop_no")       = obj.tri_prop_no;
                            sheetObj.CellValue2(row, "trf_pfx_cd")        = obj.trf_pfx_cd;
                            sheetObj.CellValue2(row, "trf_no")            = obj.trf_no;
                            sheetObj.CellValue2(row, "tri_no")            = obj.tri_no;
                            sheetObj.CellValue2(row, "cmdt_cd")           = obj.cmdt_cd;
                            sheetObj.CellValue2(row, "cmdt_nm")           = obj.cmdt_nm;
                            sheetObj.CellValue2(row, "org_pnt_loc_cd")    = obj.org_pnt_loc_cd;
                            sheetObj.CellValue2(row, "org_via_port_cd")   = obj.org_via_port_cd;
                            sheetObj.CellValue2(row, "dest_via_port_cd")  = obj.dest_via_port_cd;
                            sheetObj.CellValue2(row, "dest_pnt_loc_cd")   = obj.dest_pnt_loc_cd;
                            sheetObj.CellValue2(row, "org_pnt_loc_nm")    = obj.org_pnt_loc_nm;
                            sheetObj.CellValue2(row, "org_via_port_nm")   = obj.org_via_port_nm;
                            sheetObj.CellValue2(row, "dest_via_port_nm")  = obj.dest_via_port_nm;
                            sheetObj.CellValue2(row, "dest_pnt_loc_nm")   = obj.dest_pnt_loc_nm;
                            sheetObj.CellValue2(row, "rat_ut_cd")         = obj.rat_ut_cd;
                            sheetObj.CellValue2(row, "prc_cgo_tp_cd")     = obj.prc_cgo_tp_cd;
                            sheetObj.CellValue2(row, "curr_cd")           = obj.curr_cd;
                            sheetObj.CellValue2(row, "fnl_frt_rt_amt")    = obj.fnl_frt_rt_amt;
                            sheetObj.CellValue2(row, "note_ctnt")         = obj.note_ctnt;
                            sheetObj.CellValue2(row, "note_conv_mapg_id") = obj.note_conv_mapg_id;
                            sheetObj.CellValue2(row, "eff_dt")            = obj.eff_dt;
                            sheetObj.CellValue2(row, "exp_dt")            = obj.exp_dt;
                        }
                        sheetObj.SelectRow = 2;
                    }
                }
                break;
            case IBCREATE: // New
                // Form Object Reset
                formObj.f_cmd.value = "";
                formObj.taa_prop_no.value = "";
                formObj.cond_taa_no.value = "";
                formObj.taa_no.value = "";
                formObj.eff_dt.value = "";
                formObj.exp_dt.value = "";
                formObj.cfm_nm.value = "";
                formObj.svc_scp_nm.value = "";
                formObj.ctrt_cust_cnt_cd.value = "";
                formObj.ctrt_cust_seq.value = "";
                formObj.ctrt_cust_nm.value = "";
                formObj.respb_sls_ofc_cd.value = "";
                formObj.respb_srep_nm.value = "";
                formObj.org_pnt_loc_nm.value = "";
                formObj.org_via_port_nm.value = "";
                formObj.dest_via_port_nm.value = "";
                formObj.dest_pnt_loc_nm.value = "";

                sheetObj.RemoveAll();
                sheetObjects[1].RemoveAll();
                getComboObject(comboObjects, "amdt_seq").RemoveAll();
                getComboObject(comboObjects, "respb_srep_cd").RemoveAll();
                sheetObj.DataInsert();
                
                getComboObject(comboObjects, "svc_scp_cd").Code2 = "";
                sheetObj.CellValue2(1, "cfm_flg") = "N";
                buttonControl();
                break;

            case IBSEARCH_ASYNC01: // TAA No 입력시 Amdt Seq Combo 조회
                getComboObject(comboObjects, "amdt_seq").RemoveAll();

                formObj.f_cmd.value = SEARCH02;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_3007GS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, formObj.amdt_seq, "amdt_seq", "cd|nm");
                break;

            case IBSEARCH_ASYNC02: // Sale Rep 설정
                setCustSaleRep();
                getComboObject(comboObjects, 'respb_srep_cd').Code2 = sheetObj.CellValue(1,"respb_srep_cd");
                break;

            case IBDELETE:  // Row Delete
                if (validateForm(sheetObj, formObj, sAction)) {
                    if (sheetObj.id == "sheet1") {

                    } else if (sheetObj.id == "sheet2") {
                        var delrow = deleteRowCheck(sheetObj, "chk" ,true);
                    }
                }
                break;

            case MODIFY01: // Confirm
                ComOpenWait(true);
                if (!validateForm(sheetObjects[0], formObj, sAction)) {
                    return false;
                }
                if (!ComPriConfirmConfirm()) {
                    return false;
                }
                
                formObj.f_cmd.value = MULTI02;
                sheetObj.DoAllSave("ESM_PRI_3007GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;
                
            case MODIFY02: // Confirm Cancel
                ComOpenWait(true);
                if (!validateForm(sheetObjects[0], formObj, sAction)) {
                    return false;
                }
                if (!ComPriConfirmCancelConfirm()) {
                    return false;
                }

                formObj.f_cmd.value = MULTI03;
                sheetObj.DoAllSave("ESM_PRI_3007GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBRESET: // Cancel
                ComOpenWait(true);
                if (!validateForm(sheetObjects[0], formObj, sAction)) {
                    return false;
                }
                if (!ComPriConfirmDelete()) {
                    return false;
                }

                formObj.f_cmd.value = MULTI04;
                sheetObj.DoAllSave("ESM_PRI_3007GS.do", FormQueryString(formObj));
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
     * @returns bool, <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.11.20
     */
    function validateForm(sheetObj,formObj,sAction){

        switch (sAction) {
            case IBSEARCH: // 조회
                var taaNo = formObj.taa_no.value;
                if (taaNo == null) {
                    ComShowCodeMessage('PRI00316','TAA Number');
                    formObj.taa_no.focus();
                    return false;
                }
                break;

            case IBINSERT: // Row Add
                formChangeSheetAll(sheetObjects[0]);
                if (getComboObject(comboObjects, "svc_scp_cd").Code == "") {
                    ComShowCodeMessage("PRI01007");
                    return false;
                }
                break;

            case IBSAVE: // Save
                var formObj = document.form;
                formChangeSheetAll(sheetObjects[0]);

                if(!ComChkRequired(document.form)){
                    return false;
                }

                if (getComboObject(comboObjects, "svc_scp_cd").Code == "") {
                    ComShowCodeMessage('PRI00316','Service Scope');
                    getComboObject(comboObjects, "svc_scp_cd").focus();
                    return false;
                }

                if (getComboObject(comboObjects, "respb_srep_cd").Code == "") {
                    ComShowCodeMessage('PRI00316','Customer S.Rep.');
                    getComboObject(comboObjects, "respb_srep_cd").focus();
                    return false;
                }

                if(!sheetObjects[0].IsDataModified &&!sheetObjects[1].IsDataModified){
                    ComShowCodeMessage('PRI00301');
                    return false;
                }

                // TRI List 중복여부 Check
                var rowM = sheetObjects[1].ColValueDup("tri_no", false);
                if (rowM >= 0) {
                    ComShowCodeMessage("PRI00303", "Sheet", sheetObjects[1].CellValue(rowM, "seq"));
                    sheetObjects[1].SelectRow = rowM;
                    return false;
                }
                
                // Duration Check
                var cnt = sheetObjects[1].RowCount + sheetObjects[1].HeaderRows;
                var taaEffDt = ComGetUnMaskedValue(formObj.eff_dt,"ymd");
                var taaExpDt = ComGetUnMaskedValue(formObj.exp_dt,"ymd");
                var triNos = "";
                for (var i = sheetObjects[1].HeaderRows ; i < cnt ; i ++) {
                    if (sheetObjects[1].RowStatus(i) != "D" && (sheetObjects[1].CellValue(i, "eff_dt") > taaExpDt || sheetObjects[1].CellValue(i, "exp_dt") < taaEffDt)) {
                        triNos += sheetObjects[1].CellText(i, "tri_no")+", ";
                    }
                }
                if (triNos != "") {
                    triNos = triNos.substring(0, triNos.length - 2);
                    ComShowCodeMessage("PRI05001", triNos);
                    return false;
                }
                break;

            case MODIFY01: // Confirm
                var formObj = document.form;
                // 저장시에 한번 더 sheet에 copy함
//                var items = formObj.elements;
//                var itemlen = items.length;
//                for (var i = 0 ; i < itemlen ; i++) {
//                    if (items[i].name == "") continue;
//                    formChangeSheet (sheetObjects[0], items[i].name);
//                }
                formChangeSheetAll(sheetObjects[0]);

                // Save 할 데이터가 있는 경우 메세지 출력
                if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
                    ComShowCodeMessage('PRI03009', 'changed data');
                    return false;
                }

                if(!ComChkRequired(document.form)){
                    return false;
                }

                if (getComboObject(comboObjects, "amdt_seq").Code == "") {
                    ComShowCodeMessage('PRI00316','Amendment Sequence');
                    getComboObject(comboObjects, "amdt_seq").focus();
                    return false;
                }
    
                if (formObj.eff_dt.value > formObj.exp_dt.value){
                    ComShowCodeMessage('PRI00306');
                    formObj.eff_dt.focus();
                    return false;
                }

                var rowCnt = sheetObjects[1].RowCount;
                // TRI List 유무
//                if (rowCnt == 0) {
//                    ComShowCodeMessage("PRI05002");
//                    return false;
//                }
                // TRI List 중복여부 체크
                var rowM = sheetObjects[1].ColValueDup("tri_prop_no", false);
                if (rowM >= 0) {
                    ComShowCodeMessage("PRI00303", "Sheet", sheetObjects[1].CellValue(rowM, "seq"));
                    return false;
                }

                var cnt = rowCnt + sheetObjects[1].HeaderRows;
                var taaEffDt = ComGetUnMaskedValue(formObj.eff_dt,"ymd");
                var taaExpDt = ComGetUnMaskedValue(formObj.exp_dt,"ymd");
                var triNos = "";
                for (var i = sheetObjects[1].HeaderRows ; i < cnt ; i ++) {
                    if (sheetObjects[1].CellValue(i, "eff_dt") > taaExpDt || sheetObjects[1].CellValue(i, "exp_dt") < taaEffDt) {
                        triNos += sheetObjects[1].CellText(i, "tri_no")+", ";
                    }
                }
                if (triNos != "") {
                    triNos = triNos.substring(0, triNos.length - 2);
                    ComShowCodeMessage("PRI05001", triNos);
                    return false;
                }
                break;

            case MODIFY02:  // Confirm Cancel
                var formObj = document.form;
                // Confirm Calcel 하려는 TAA NO가 Booking 에서 사용하고 있는지를 체크한다.
                formObj.f_cmd.value = SEARCH03;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_3007GS.do", FormQueryString(formObj));
                var bkgNos = ComGetEtcData(sXml, "bkgNos");
                if (ComTrim(bkgNos) != "") {
                    ComShowCodeMessage("PRI05003", bkgNos);
                    return false;
                }
        }

        return true;
    }

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * 선택한 TRI 목록에 해당하는 Route Name을 보여준다.<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
         if(sheetObj.CellValue(NewRow,"tri_prop_no")!="" && OldRow != NewRow){
            var formObj = document.form;
            formObj.org_pnt_loc_nm.value = sheetObj.CellValue(NewRow, "org_pnt_loc_nm").replace(/\|/g, "\n");
            formObj.org_via_port_nm.value = sheetObj.CellValue(NewRow, "org_via_port_nm").replace(/\|/g, "\n");
            formObj.dest_via_port_nm.value = sheetObj.CellValue(NewRow, "dest_via_port_nm").replace(/\|/g, "\n");
            formObj.dest_pnt_loc_nm.value = sheetObj.CellValue(NewRow, "dest_pnt_loc_nm").replace(/\|/g, "\n");
        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 form 에 데이터를 보여줌 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.RowCount == 0) {
            doActionIBSheet(sheetObj, document.form, IBCREATE);
            return;
        } else {
            var formObj = document.form;
            doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);  // amdt_seq combo
            getComboObject(comboObjects, "amdt_seq").Code2 = sheetObj.CellValue(1, "amdt_seq");
            getComboObject(comboObjects, "svc_scp_cd").Code2 = sheetObj.CellValue(1, "svc_scp_cd");
            ComPriCopyRowToForm(sheetObj, formObj, 1);
            formObj.ctrt_cust_seq.value = ComLpad(sheetObj.CellValue(1, "ctrt_cust_seq"), 6, "0");
            formObj.eff_dt.value = sheetObj.CellText(1, "eff_dt");
            formObj.exp_dt.value = sheetObj.CellText(1, "exp_dt");
            formObj.old_svc_scp_cd.value = sheetObj.CellValue(1, "svc_scp_cd");
            formObj.taa_prop_no.value = sheetObj.CellValue(1, "taa_prop_no");
        }
    }

    /**
     * 상태에 따라 Button 을 Enabel/Disable 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *     buttonControl();
     * </pre>
     * @returns 없음
     * @author 문동규
     * @version 2009.12.02
     */
    function buttonControl() {
        // 사용자권한 체크
        checkUserAuth();

        var formObj = document.form;
        if (sheetObjects[0].CellValue(1,"taa_no") == "") {  // New, No Data
            ComBtnDisable("btn_Amend");
            ComBtnDisable("btn_Confirm");
            ComSetDisplay("btn_ConfirmCancel",false);
            
            ComBtnDisable("btn_ConfirmCancel");
            ComSetDisplay("btn_Cancel",true);
            ComBtnDisable("btn_Cancel");

            if (usrSrepAuth == "Y") {
                ComBtnEnable("btn_Save");
                ComBtnEnable("btn_RowAdd");
                ComBtnEnable("btn_RowDelete");
                
                btnImgEnable(formObj.btns_calendar1, true);
                btnImgEnable(formObj.btns_calendar2, true);
                btnImgEnable(formObj.btn_ctrt_cust, true);

                getComboObject(comboObjects, "svc_scp_cd").Enable = true;
                getComboObject(comboObjects, "respb_srep_cd").Enable = true;
                
                formObj.eff_dt.readOnly = false;
                formObj.exp_dt.readOnly = false;
                formObj.ctrt_cust_cnt_cd.readOnly = false;
                formObj.ctrt_cust_seq.readOnly = false;
            } else {
                ComBtnDisable("btn_Save");
                ComBtnDisable("btn_RowAdd");
                ComBtnDisable("btn_RowDelete");
                
                btnImgEnable(formObj.btns_calendar1, false);
                btnImgEnable(formObj.btns_calendar2, false);
                btnImgEnable(formObj.btn_ctrt_cust, false);

                getComboObject(comboObjects, "svc_scp_cd").Enable = false;
                getComboObject(comboObjects, "respb_srep_cd").Enable = false;
                
                formObj.eff_dt.readOnly = true;
                formObj.exp_dt.readOnly = true;
                formObj.ctrt_cust_cnt_cd.readOnly = true;
                formObj.ctrt_cust_seq.readOnly = true;
            }
        } else {
            if (sheetObjects[0].CellValue(1,"cfm_flg") == "Y") {    // Confirm
                if (usrOfcAuth == "Y") {
                    if (getComboObject(comboObjects,"amdt_seq").Index == 0) {  // max seq
                        ComBtnEnable("btn_Amend");
                        ComSetDisplay("btn_ConfirmCancel",true);
                        ComBtnEnable("btn_ConfirmCancel");
                    } else {
                        ComBtnDisable("btn_Amend");
                        ComSetDisplay("btn_ConfirmCancel",false);
                        ComBtnDisable("btn_ConfirmCancel");
                    }
                } else {
                    ComBtnDisable("btn_Amend");
                    ComSetDisplay("btn_ConfirmCancel",false);
                    ComBtnDisable("btn_ConfirmCancel");
                }
                ComBtnDisable("btn_Confirm");
                ComSetDisplay("btn_Cancel",false);
                ComBtnDisable("btn_Cancel");

                ComBtnDisable("btn_RowAdd");
                ComBtnDisable("btn_RowDelete");

                btnImgEnable(formObj.btns_calendar1, false);
                btnImgEnable(formObj.btns_calendar2, false);
                btnImgEnable(formObj.btn_ctrt_cust, false);
                
                getComboObject(comboObjects, "svc_scp_cd").Enable = false;

                if (usrAprvAuth == "Y" && getComboObject(comboObjects,"amdt_seq").Index == 0) {   // 승인권자는 Srep Code 수정 가능
                    ComBtnEnable("btn_Save");
                    getComboObject(comboObjects, "respb_srep_cd").Enable = true;
                } else {
                    ComBtnDisable("btn_Save");
                    getComboObject(comboObjects, "respb_srep_cd").Enable = false;
                }

                formObj.eff_dt.readOnly = true;
                formObj.exp_dt.readOnly = true;
                formObj.ctrt_cust_cnt_cd.readOnly = true;
                formObj.ctrt_cust_seq.readOnly = true;
            } else {    // Retrieve, Confirm Cancel
                ComBtnDisable("btn_Amend");
                ComSetDisplay("btn_ConfirmCancel",false);
                ComBtnDisable("btn_ConfirmCancel");
                ComSetDisplay("btn_Cancel",true);

                if (usrOfcAuth == "Y") {
                    ComBtnEnable("btn_Save");
                    ComBtnEnable("btn_Confirm");
                    ComBtnEnable("btn_Cancel");
                    ComBtnEnable("btn_RowAdd");
                    ComBtnEnable("btn_RowDelete");
                    
                    btnImgEnable(formObj.btns_calendar1, true);
                    btnImgEnable(formObj.btns_calendar2, true);
                    
                    formObj.eff_dt.readOnly = false;
                    formObj.exp_dt.readOnly = false;
                    
                    var amdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
                    
                    // Confirm 되지 않은 Seq 0 번 데이터는 수정가능
                    if (!isNaN(amdtSeq) && Number(amdtSeq) > Number("0")) {
                        getComboObject(comboObjects, "svc_scp_cd").Enable = false;
                        if (usrAprvAuth == "Y") {   // 승인권자는 srep_cd 수정가능
                            getComboObject(comboObjects, "respb_srep_cd").Enable = true;
                        } else {
                            getComboObject(comboObjects, "respb_srep_cd").Enable = false;
                        }
                        btnImgEnable(formObj.btn_ctrt_cust, false);
                        formObj.ctrt_cust_cnt_cd.readOnly = true;
                        formObj.ctrt_cust_seq.readOnly = true;
                    } else {    // amdt_seq = 0
                        getComboObject(comboObjects, "svc_scp_cd").Enable = true;
                        getComboObject(comboObjects, "respb_srep_cd").Enable = true;
                        btnImgEnable(formObj.btn_ctrt_cust, true);
                        formObj.ctrt_cust_cnt_cd.readOnly = false;
                        formObj.ctrt_cust_seq.readOnly = false;
                    }
                } else {
                    if (usrAprvAuth == "Y" && getComboObject(comboObjects,"amdt_seq").Index == 0) {
                        ComBtnEnable("btn_Save");
                        getComboObject(comboObjects, "respb_srep_cd").Enable = true;
                    } else {
                        ComBtnDisable("btn_Save");
                        getComboObject(comboObjects, "respb_srep_cd").Enable = false;
                    }
                    ComBtnDisable("btn_Confirm");
                    ComBtnDisable("btn_Cancel");
                    ComBtnDisable("btn_RowAdd");
                    ComBtnDisable("btn_RowDelete");
                    
                    btnImgEnable(formObj.btns_calendar1, false);
                    btnImgEnable(formObj.btns_calendar2, false);
                    btnImgEnable(formObj.btn_ctrt_cust, false);
                    
                    getComboObject(comboObjects, "svc_scp_cd").Enable = false;

                    formObj.eff_dt.readOnly = true;
                    formObj.exp_dt.readOnly = true;
                    formObj.ctrt_cust_cnt_cd.readOnly = true;
                    formObj.ctrt_cust_seq.readOnly = true;
                }
            }
        }
    }

    /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * Note Conversion Popup 을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} Row 필수, OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 문동규
     * @version 2009.12.07
     */      
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;

        switch(colName) {
            case "note_ctnt":
                var sParam = "";
                sParam += "note_conv_mapg_id=" + sheetObj.CellValue(Row, "note_conv_mapg_id");
                sParam += "&note_ctnt="+ encodeURIComponent(sheetObj.CellValue(Row, "note_ctnt"));
                var sUrl = "/hanjin/ESM_PRI_3003.do?" + sParam;
                var rtnVal = ComPriOpenWindowCenter(sUrl, window, 800, 535, true);
                break;
        }
    }

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 저장 완료 후 로직을 실행 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.12.02
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            if (formObj.taa_no.value == "" && sheetObj.EtcData("taa_no") != null && sheetObj.EtcData("taa_no") != "") {
                formObj.taa_no.value = sheetObj.EtcData("taa_no");
                getComboObject(comboObjects, "amdt_seq").RemoveAll();
            } else if (formObj.f_cmd.value == MULTI04) {
                // Cancel 일 경우 해당 TAA No의 Max Amdt Seq로 조회
                getComboObject(comboObjects, "amdt_seq").RemoveAll();
            }
            doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 Note Content 를 Tooltip 적용 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.12.02
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        
        for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows + sheetObj.RowCount ; i < n ; i++) {
            sheetObj.ToolTipText(i, "note_ctnt") = sheetObj.CellValue(i, "note_ctnt");
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
     * @version 2009.11.20
     */
    function svc_scp_cd_OnChange (comboObj, code, text) {
        formChangeSheet(sheetObjects[0], "svc_scp_cd");
        var formObj = document.form;
        if (code == "") {
            formObj.svc_scp_nm.value = "";
        } else {
            var indx = comboObj.FindIndex(code, 0);
            if (indx != -1) {
                formObj.svc_scp_nm.value = comboObj.GetText(indx, 1);
            } else {
                formObj.svc_scp_nm.value = "";
            }
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
     * @version 2009.11.20
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
     * @version 2009.11.20
     */
    function svc_scp_cd_OnBlur(comboObj) {
        var formObj = document.form;
        
        if (sheetObjects[1].RowCount > 0) {
            var trfCd = hmap.get(getComboObject(comboObjects, "svc_scp_cd").Code);
            if (trfCd != "") {
                if (trfCd != (sheetObjects[1].CellValue(2, "trf_pfx_cd")+";"+sheetObjects[1].CellValue(2, "trf_no"))) {
                    ComShowCodeMessage("PRI05010");
                    getComboObject(comboObjects, "svc_scp_cd").Code = formObj.old_svc_scp_cd.value;
                    getComboObject(comboObjects, "svc_scp_cd").focus();
                    return false;
                }
            }
        }
        formObj.old_svc_scp_cd.value = getComboObject(comboObjects, "svc_scp_cd").Code;
        formChangeSheet(sheetObjects[0], "svc_scp_cd");
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * amdt_seq 콤보에서 값을 변경하면 TAA Main 을 조회한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수, IBMultiCombo Object
     * @param {string} code 필수, 선택된 항목의 value
     * @param {string} text 필수, 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function amdt_seq_OnChange (comboObj, code, text) {
        if (document.form.taa_no.value != "") {
            try {
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
    }

    /**
     * Customer에 관련된 정보를 조회한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *       custNameFind(eleName);
     * </pre>
     * @param  {string} eleName 필수, Html Object Name
     * @return 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function custNameFind (eleName) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var ctrt_cust_cnt_cd = formObj.ctrt_cust_cnt_cd.value;
        var ctrt_cust_seq = formObj.ctrt_cust_seq.value;

        if (ctrt_cust_cnt_cd != "" && ctrt_cust_seq != "") {
            var sParam = "f_cmd=" + SEARCH04 + "&cust_cnt_cd=" + ctrt_cust_cnt_cd + "&cust_seq=" + ctrt_cust_seq;
            var sXml = sheetObj.GetSearchXml("ESM_PRI_3007GS.do", sParam);
            var arrText = ComPriXml2Array(
                    sXml,
                    "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_cust_val_sgm|respb_srep_cd|respb_sls_ofc_cd|ctrt_cust_srep_nm|prc_ctrt_cust_tp_nm|ctrt_cust_val_sgm_cd");
            // CTRT_CUST_VAL_SGM_CD
            if (arrText == undefined) {
                clearCustName();
                formObj.ctrt_cust_cnt_cd.focus();
            } else {
                getComboObject(comboObjects,"respb_srep_cd").Code = "";
                sheetObj.CellValue2(1, "prc_ctrt_cust_tp_cd") = arrText[0][0];

                sheetObj.CellValue2(1, "ctrt_cust_val_sgm_cd") = arrText[0][7];
                sheetObj.CellValue2(1, "respb_srep_cd") = arrText[0][3];
                sheetObj.CellValue2(1, "respb_sls_ofc_cd") = arrText[0][4];

                formObj.ctrt_cust_nm.value = arrText[0][1];
                formObj.respb_sls_ofc_cd.value = arrText[0][4];
                formObj.respb_srep_nm.value = arrText[0][5];
            }
        }
        formChangeSheet(sheetObj, eleName);
    }

    /**
     * Customer에 관련된 Html Object의 값을 clear 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *       clearCustName();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function clearCustName () {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];

        sheetObj.CellValue2(1, "ctrt_cust_cnt_cd") = "";
        sheetObj.CellValue2(1, "ctrt_cust_seq") = "";
        sheetObj.CellValue2(1, "prc_ctrt_cust_tp_cd") = "";
        sheetObj.CellValue2(1, "ctrt_cust_val_sgm_cd") = "";
        sheetObj.CellValue2(1, "respb_srep_cd") = "";
        sheetObj.CellValue2(1, "respb_sls_ofc_cd") = "";

        formObj.ctrt_cust_cnt_cd.value = "";
        formObj.ctrt_cust_seq.value = "";
        formObj.ctrt_cust_nm.value = "";
        formObj.respb_sls_ofc_cd.value = "";
        getComboObject(comboObjects, "respb_srep_cd").removeAll();
        formObj.respb_srep_nm.value = "";
    }

    /**
     * 입력한 Customer Sale Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setCustSaleRep();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function setCustSaleRep () {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if (formObj.ctrt_cust_cnt_cd.value != "" && formObj.ctrt_cust_seq.value != "") {
            formObj.f_cmd.value = SEARCHLIST;

            var sParam = FormQueryString(formObj) + "&etc2=" + formObj.ctrt_cust_cnt_cd.value
                       + "&etc3=" + ComParseInt(formObj.ctrt_cust_seq.value);
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
            ComPriXml2ComboItem(sXml, formObj.respb_srep_cd, "cd", "cd|nm|etc1");
            //첫줄 빈칸 추가
            formObj.respb_srep_cd.InsertItem(0, "||","");
        }
    }

    /**
     * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
     * 변경된 사항은 formChangeSheet() 함수로 Sheet에 반영한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    respb_srep_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수, IBMultiCombo Object
     * @param   {string} code 필수, 코드
     * @param   {string} text 필수, 화면에 표시된 문자
     * @return 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function respb_srep_cd_OnChange (comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
        if (arrText[1] != null && arrText[1] != undefined) {
            formObj.respb_srep_nm.value = arrText[1];
            formObj.respb_sls_ofc_cd.value = arrText[2];
        }

        formChangeSheet(sheetObj, "respb_srep_cd")
        formChangeSheet(sheetObj, "respb_sls_ofc_cd")
    }

    /**
     * Html Object의 값을 변경할 때 숨겨진 Sheet에 변경된 값을 반영한다.<br>
     * 숨겨진 sheet를 이용하여 값을 저장한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *   formChangeSheet( sheetObj, colNm );
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} colNm 필수, Html Object의 name
     * @return 없음
     * @author 문동규
     * @version 2009.11.30
     */
    function formChangeSheet (sheetObj, colNm) {
        var eleValue = "";
        if (document.getElementById(colNm).type == "text") {
            switch (colNm) {
                case "eff_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value, "ymd");
                    break;
                case "exp_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value, "ymd");
                    break;

                case "ctrt_cust_seq":
                    eleValue = ComParseInt(document.getElementById(colNm).value);
                    break;

                default:
                    eleValue = document.getElementById(colNm).value;
                    break;
            }
            sheetObj.CellValue2(1, colNm) = eleValue;
        } else if (document.getElementById(colNm).type == "hidden") {
            return;
        } else {
            sheetObj.CellValue2(1, colNm) = document.getElementById(colNm).Code;
        }
    }

    /**
     * Html Object의 모든 값을 숨겨진 Sheet에 반영한다.<br>
     * 숨겨진 sheet를 이용하여 값을 저장한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *   formChangeSheetAll(sheetObj, colNm);
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2010.03.17
     */
    function formChangeSheetAll(sheetObj) {
        var items = document.form.elements;
        var itemlen = items.length;
        for (var i = 0 ; i < itemlen ; i++) {
            if (items[i].name == "") continue;
            formChangeSheet(sheetObj, items[i].name);
        }
    }

    /**
     * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    btnImgEnable(obj, gb);
     * </pre>
     * @param  {form} obj 필수, Html Object
     * @param  {bool} gb  필수, true : 활성화 false : 비활성화
     * @return 없음
     * @author 문동규
     * @version 2009.12.92
     */ 
    function btnImgEnable(obj, gb) {
        if(obj.constructor == String){
            obj = document.getElementsByName(obj)[0];            
        }
        var btnStyle = obj.style;

        if (gb){           
            obj.Enable = true;
            btnStyle.cursor = "hand";
            btnStyle.filter="";
            enableButton(obj.name); 
        } else {
            obj.Enable = false;
            btnStyle.cursor = "auto";
            btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
            disableButton(obj.name);    
        }
    }

    /**
     * HashMap 객체 생성자.<br>
     * Java 에서 사용하는 HashMap과 동일한 객체를 생성한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     hm = new HashMap();      // 생성
     *     hm.put(key, value);      // 값 입력
     *     val = hm.get(key);       // 값 출력
     *     hm.remove(key);          // 값 삭제
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.05.22
     */
    function HashMap() {
        this.mapVal = {};
        this.pos = new Array();
    }

    HashMap.prototype.get = function get( key ) {
        return this.mapVal[ key ];
    }

    HashMap.prototype.getPos = function getPos( n ) {
        return this.mapVal[ this.pos[n] ];
    }

    HashMap.prototype.getKeys = function getKeys() {
        return this.pos;
    }

    HashMap.prototype.remove = function remove( n ) {
        var ary = new Array();
        var len = this.pos.length;
        if ((n + 0) == n) { // number
            for( var i = 0; i < len; i++ ) {
                if( i != n ) {
                    ary.push( this.pos[i] );
                }
            }
            this.mapVal[ this.pos[n] ] = null;
        } else {    // string
            for( var i = 0; i < len; i++ ) {
                if( this.pos[i] != n ) {
                    ary.push( this.pos[i] );
                }
            }
            this.mapVal[ n ] = null;
        }

        this.pos = ary;
    }

    HashMap.prototype.put = function put( key, val ) {
        this.mapVal[key] = val;

        var flg = true;
        for( var i = 0; i < this.pos.length; i++ ) {
            if( key == this.pos[i] ) {
                flg = false;
                break;
            }
        }

        if( flg ) {
            this.pos.push( key );
        }
    }

    HashMap.prototype.size = function size() {
        return this.pos.length;
    }

    /* 개발자 작업  끝 */