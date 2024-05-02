/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0028.js
*@FileTitle : Agent Commission Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.26 김영오
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
     * @class ESM_ACM_0028 : ESM_ACM_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0028() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
    }

/* 개발자 작업 */


    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1 = sheetObjects[0];
        var memoShtObj2 = sheetObjects[1];
        var shtObj = sheetObjects[2];
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            if (srcName != "btn2_vvd_cd") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.vvd_cd);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_bl_no") {
                ACMMemoSheet_Close(memoShtObj2, frmObj.bl_no);    // CoAcm.js에 정의
            }

            switch (srcName) {
                case "btn_calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;

                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_new":
                    ComResetAll();    //기본 object 초기화
                    memo_sheet1_OnLoadFinish(memoShtObj1)    // CoAcm.js에 정의
                    memo_sheet2_OnLoadFinish(memoShtObj2)    // CoAcm.js에 정의
                    break;

                case "btn_calculate":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                    break;

                case "btn_downexcel":
                    ComOpenWait(true);
                    shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "chk");
                    ComOpenWait(false);
                    break;

                case "btn2_vvd_cd":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;

                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
                    break;

                case "btn_forwarder":
                    var url = "COM_ENS_041.do";
                    var width = 775;
                    var height = 484;
                    var func = "setForwarder";
                    var display = "1,0,1";
                    //comPopup(url, width, height, func, display, bModal, b2ndSheet);
                    ComOpenPopup(url, width, height, func, display, true, false);
                    break;

                case "ofc_option":
                    if (frmObj.ofc_option[0].checked) {
                        //ar_ofc_cd 목록을 조회
                        ACMXml2SelectItem(xmlStrOfc1, frmObj.ar_ofc_cd, "value0", "value0", true);
                    } else if (frmObj.ofc_option[1].checked) {
                        //Sales Office 목록을 조회
                        ACMXml2SelectItem(xmlStrOfc2, frmObj.ar_ofc_cd, "value0", "value0", true);
                    }
                    break;

            } // end switch

//        } catch(e) {
//            if (e == "[object Error]") {
//                ComShowMessage(OBJECT_ERROR);
//            } else {
//                ComShowMessage(e);
//            }
//        }
    }


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++] = shtObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        initControl();

        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            switch (shtObj.id) {

                case "memo_sheet1":
                case "memo_sheet2":
                    ACMMemoSheet_InitSheet(shtObj);    // CoAcm.js에 정의
                    break;

                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 389;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(2, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|CHK|Seq|Calc.\nSeq|Freight\nForwarder|Name|BKG No.|B/L No.|BKG\nSTS|VVD|ETD|B/L AMT|Cur|" +
                                      "Freight Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|Container Status|" +
                                      "Container Status|Previous\nAmount|Comm.\nStatus|Remarks||||||||||";
                    var HeadTitle1  = "STS||Seq|Calc.\nSeq|Freight\nForwarder|Name|BKG No.|B/L No.|BKG\nSTS|VVD|ETD|B/L AMT|Cur|" +
                                      "Commission|Box(CNT/AMT)|Box(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|RTEU(CNT/AMT)|RTEU(CNT/AMT)|RFEU(CNT/AMT)|RFEU(CNT/AMT)|" +
                                      "Commission|Previous\nAmount|Comm.\nStatus|Remarks|||||||||";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus,       40,     daCenter,    true,     "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtCheckBox,     30,     daCenter,    false,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    true,     "seq");
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    true,     "fac_seq",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    true,     "ff_cnt_seq",      false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         200,    daLeft,      true,     "cust_lgl_eng_nm", false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,     "bkg_no",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,     "bl_no",           false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    true,     "bkg_sts_cd",      false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,     "vvd",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,     "vsl_dep_dt",      false,     "",    dfNone,    0,    false,     false);

                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     true,     "bl_crnt_amt",     false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,     "curr_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daRight,     false,    "crnt_amt",        false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "bkg_bx_qty",      false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "fac_bx_amt",      false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "bkg_dry_teu_qty", false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "fac_dry_teu_amt", false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "bkg_dry_feu_qty", false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "fac_dry_feu_amt", false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     true,     "bkg_rf_teu_qty",  false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     true,     "fac_rf_teu_amt",  false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     true,     "bkg_rf_feu_qty",  false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     true,     "fac_rf_feu_amt",  false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     true,     "cntr_crnt_amt",   false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     true,     "ppd_amt",         false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    true,     "fac_sts_cd",      false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daLeft,      true,     "fac_rmk",         false,     "",    dfNone,    0,    false,     false);

                    //hidden
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "if_dt",           false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "sls_ofc_cd",      false,     "",    dfNone,    0,    false,     false);
                    //InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "bkg_no",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "fac_ofc_cd",      false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "ff_cnt_cd",       false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "ff_seq",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "fac_agmt_seq",    false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "fac_div_cd",      false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "fac_div_cd_1",    false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    true,     "old_crnt_amt",    false,     "",    dfNone,    0,    false,     false);

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    WaitImageVisible = false;
                    HeadRowHeight = 24;

                    break;

            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                if (ACMDecideErrXml(shtObj, xmlStr)) {
                    return;
                } else {
                    xmlStrOfc1 = xmlStr;    // *** 반드시 전역변수로 setting에 유의 ***
                }
                // 로그인한 사용자의 ofc_cd로 Sales Office 목록을 조회
                var xmlStr2 = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH15);
                if (ACMDecideErrXml(shtObj, xmlStr2)) {
                    return;
                } else {
                    xmlStrOfc2 = xmlStr2;    // *** 반드시 전역변수로 setting에 유의 ***
                }
                break;

            case IBSEARCH:       // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0028GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01: // 재계산
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MODIFY ;
                //alert(FormQueryString(frmObj));
                shtObj.DoSave("ESM_ACM_0028GS.do", FormQueryString(frmObj),"chk",false);
                ComOpenWait(false);
            break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
        // 조회조건의 Office Select Object 생성
        doActionIBSheet(shtObj, document.form, SEARCH01);
        //최초 페이지 로드 시 [AR Office] 셋팅
        document.form.ofc_option[0].fireEvent("onclick");
     }


    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


    /**
     * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
     */
    function setForwarder(rowArray, row, col) {
        var colArray = rowArray[0];
        document.form.ff_cnt_seq.value = colArray[3];
    }


/* 개발자 작업 끝 */
