/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3008.js
*@FileTitle : TAA No Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.07 문동규
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
     * @class ESM_PRI_3008 : ESM_PRI_3008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3008() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
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
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_OK":
                    if (sheetObject1.RowCount == 0) {
                        ComShowCodeMessage("PRI00011");
                        return;
                    } else {
                        window.returnValue = sheetObject1.CellValue(sheetObject1.SelectRow, "taa_no");
                        window.close();
                    }
                    break;
                    
                case "btn_Close":
                    window.close();
                    break;

                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;

                case "btn_New":
                    formObject.reset();
                    getComboObject(comboObjects, "svc_scp_cd").Code = "";
                    sheetObject1.RemoveAll();
                    break;

                case "btn_ctrt_cust":
                    var param = "is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObject.ctrt_cust_cnt_cd.value+"&cust_seq="+formObject.ctrt_cust_seq.value;
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?"+param, "", 640, 457, true);
                    if (rtnVal != null){
                        formObject.ctrt_cust_cnt_cd.value = rtnVal.custCntCd;
                        formObject.ctrt_cust_seq.value = rtnVal.custSeq;
                        formObject.ctrt_cust_nm.value = rtnVal.custNm;
                        custNameFind("ctrt_cust_cnt_cd");
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

        initIBComboItem();
        initControl();
    }

    /**
     * Open 시에 조회한 Combo Item 을 IBMultiCombo 에 셋팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.12.07
     */
    function initIBComboItem () {
        ComPriTextCode2ComboItem(svcScpComboValue, svcScpComboText, getComboObject(comboObjects, 'svc_scp_cd'),"|","\t");
    }

    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.08
     */
    function initControl () {
        var formObj = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
        axon_event.addListenerForm('blur', 'obj_deactivate', formObj);
        axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }

    /**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.08
     */
    function obj_keypress () {
        switch (event.srcElement.dataformat) {
            case "engup":
                ComKeyOnlyAlphabet('upper');
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
    }

    /**
     * Onbeforedeactivate Event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.08
     */
    function obj_deactivate () {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var eleName = event.srcElement.name;

        switch (eleName) {
            case "ctrt_cust_cnt_cd":
                //cust name find
                if (formObj.ctrt_cust_cnt_cd.value != "") {
                    custNameFind(eleName);
                } else {
                    clearCustName();
                }
                break;
            case "ctrt_cust_seq":
                var custSeq = formObj.ctrt_cust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0) {
                    formObj.ctrt_cust_seq.value = ComLpad(custSeq, 6, "0");
                }
                //cust name find
                if (formObj.ctrt_cust_seq.value != "") {
                    custNameFind(eleName);
                } else {
                    clearCustName();
                }
                break;

            default:
                ComChkObjValid(event.srcElement);
        }
    }

    /**
     * OnBeforeActivate Event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.08
     */
    function obj_activate () {
        var formObj = document.form;
        var sElement = event.srcElement;
        var srcName = sElement.getAttribute("name");
        ComClearSeparator(sElement);
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
     * @version 2009.12.08
     */
    function custNameFind (eleName) {
        var formObj = document.form;
        var sheetObj = sheetObjects[1];
        var ctrt_cust_cnt_cd = formObj.ctrt_cust_cnt_cd.value;
        var ctrt_cust_seq = formObj.ctrt_cust_seq.value;

        if (ctrt_cust_cnt_cd != "" && ctrt_cust_seq != "") {
            var sParam = "f_cmd=" + SEARCH02 + "&cust_cnt_cd=" + ctrt_cust_cnt_cd + "&cust_seq=" + ctrt_cust_seq;
            var sXml = sheetObj.GetSearchXml("ESM_PRI_3008GS.do", sParam);
            var arrText = ComPriXml2Array(sXml,"prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_cust_val_sgm|respb_srep_cd|respb_sls_ofc_cd|ctrt_cust_srep_nm|prc_ctrt_cust_tp_nm|ctrt_cust_val_sgm_cd");
            if (arrText == undefined) {
                clearCustName();
                formObj.ctrt_cust_cnt_cd.focus();
            } else {
                formObj.ctrt_cust_nm.value = arrText[0][1];
            }
        }
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
     * @version 2009.12.08
     */
    function clearCustName () {
        var formObj = document.form;

        formObj.ctrt_cust_cnt_cd.value = "";
        formObj.ctrt_cust_seq.value = "";
        formObj.ctrt_cust_nm.value = "";
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

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    var HeadTitle = "|Seq.|TAA No.|SVC Scope|Office|Sale Rep.|Sale Rep.|Customer|Customer|Duration|Duration";
                    var HeadTitle1 = "|Seq.|TAA No.|SVC Scope|Office|Code|Description|Code|Description|Effective Date|Expiration Date";
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
                    InitDataProperty(0, cnt++ , dtDataSeq,     30,  daCenter, true,  "seq",               false,  "",dfNone,   0,    false,  false);
                    InitDataProperty(0, cnt++ , dtData,        90,  daCenter, true,   "taa_no",           false,  "",dfNone,   0,    false,  true);
                    InitDataProperty(0, cnt++ , dtData,        70,  daCenter, true,   "svc_scp_cd",       false,  "",dfNone,   0,    false,  true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter, true,   "respb_sls_ofc_cd", false,  "",dfNone,   0,    false,  true);
                    InitDataProperty(0, cnt++ , dtData,        50,  daCenter, true,   "respb_srep_cd",    false,  "",dfNone,   0,    false,  true);
                    InitDataProperty(0, cnt++ , dtData,        120, daLeft,   true,   "respb_srep_nm",    false,  "",dfNone,   0,    false,  true);
                    InitDataProperty(0, cnt++ , dtData,        60,  daCenter, true,   "ctrt_cust_cd",     false,  "",dfNone,   0,    false,  true);
                    InitDataProperty(0, cnt++ , dtData,        170, daLeft,   true,   "ctrt_cust_nm",     false,  "",dfNone,   0,    false,  true);
                    InitDataProperty(0, cnt++ , dtData,        95,  daCenter, true,   "eff_dt",           false,  "",dfDateYmd,0,    false,  true);
                    InitDataProperty(0, cnt++ , dtData,        80,  daCenter, true,   "exp_dt",           false,  "",dfDateYmd,0,    false,  true);
                    WaitImageVisible = false;

                    ShowButtonImage = 2;

                    CountPosition = 0;
                }
                break;

            case "sheet2":  // hidden
                with (sheetObj) {
                    // 높이 설정
//                    style.height = 182;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
    
                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
    
                    var HeadTitle = "status";
                    var headCount = ComCountHeadTitle(HeadTitle);
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);
    
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
    
                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,   false,  "ibflag");
    
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
            case IBSEARCH:      //조회
                ComOpenWait(true);
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }

                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoSearch("ESM_PRI_3008GS.do" , FormQueryString(formObj));
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
        with(formObj){
        }

        return true;
    }

    /**
     * OnDblClick 이벤트 발생시 호출되는 function <br>
     * Sheet에서 Row 를 더블 클릭 시 해당 Row 의 TAA Number 를 return 함<br>
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
    function sheet1_OnDblClick (sheetObj, Row, Col, Value) {
        var colname = sheetObj.ColSaveName(Col);
        window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, "taa_no");
        window.close();
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
        var code = comboObj.FindIndex(comboObj.Code, 0);

        if (code != null && code != "") {
            var text = comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
                formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
            }
        }
    }

    /* 개발자 작업  끝 */