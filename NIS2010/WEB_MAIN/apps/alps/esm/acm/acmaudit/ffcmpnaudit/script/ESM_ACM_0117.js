/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0117.js
*@FileTitle : FF Compensation Details & History for B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.13
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.13 김상수
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
     * @class ESM_ACM_0117 : ESM_ACM_0117 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0117() {
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
    var currentRow = 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj = sheetObjects[1];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {

                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_new":
                    ComResetAll();
                    frmObj.bl_no.value = "";
                    frmObj.bkg_no.value = "";
                    break;

                 case "btn_close":
                    window.close();
                    break;
                } // end switch

        } catch(e) {
            if (e == "[object Error]") {
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

        // sheet2_OnLoadFinish 메서드 존재시 반드시 참조
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {

        var cnt = 0;

        with (shtObj) {

            switch(shtNo) {
                case 1:      //sheet1 init
                    // 높이 설정
                    style.height = GetSheetHeight(6) ;

                    //전체 너비 설정
                    SheetWidth = 120;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(2, 0 , 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false) ;

                    var HeadTitle = "CHG|AMT";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,    50,    daCenter,    true,    "chg_cd",         false,    "",    dfNone);
                    InitDataProperty(0, cnt++ , dtData,    70,    daRight,     true,    "bkg_chg_amt",    false,    "",    dfFloat,    2);

                    CountPosition  = 0;
                    WaitImageVisible = false;
                    break;

                case 2:      //sheet2 init
                    // 높이 설정
                    style.height = GetSheetHeight(6) ;
                    //전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 1 , 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false) ;

                    var HeadTitle = "CA\nSEQ|Freight Status|Freight Status|Freight Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|AMT DIFF|Calc Date|Status|Remark|IF Date";
                    var HeadTitle1 = "CA\nSEQ|Commissionable|Rate|Commission|BOX(CNT/AMT)|BOX(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|REU(CNT/AMT)|REU(CNT/AMT)|Commission|AMT DIFF|Calc Date|Status|Remark|IF Date";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,      40,     daCenter,    true,    "ff_cmpn_seq",       false,    "",    dfNone);
                    InitDataProperty(0, cnt++, dtData,      110,    daRight,     true,    "act_comm_able",     false,    "",    dfFloat,      2);
                    InitDataProperty(0, cnt++, dtData,      50,     daRight,     true,    "ff_bkg_rt",         false,    "",    dfFloat,      2);
                    InitDataProperty(0, cnt++, dtData,      80,     daRight,     true,    "act_comm_amt",      false,    "",    dfFloat,      2);
                    InitDataProperty(0, cnt++, dtData,      50,     daRight,     true,    "bkg_bx_qty",        false,    "",    dfFloat,      1);
                    InitDataProperty(0, cnt++, dtData,      50,     daRight,     true,    "ff_bx_amt",         false,    "",    dfFloat,      2);
                    InitDataProperty(0, cnt++, dtData,      50,     daRight,     true,    "bkg_teu_qty",       false,    "",    dfFloat,      1);
                    InitDataProperty(0, cnt++, dtData,      50,     daRight,     true,    "ff_teu_amt",        false,    "",    dfFloat,      2);
                    InitDataProperty(0, cnt++, dtData,      50,     daRight,     true,    "bkg_feu_qty",       false,    "",    dfFloat,      1);
                    InitDataProperty(0, cnt++, dtData,      50,     daRight,     true,    "ff_feu_amt",        false,    "",    dfFloat,      2);
                    InitDataProperty(0, cnt++, dtData,      50,     daRight,     true,    "bkg_rf_qty",        false,    "",    dfFloat,      1);
                    InitDataProperty(0, cnt++, dtData,      50,     daRight,     true,    "ff_rf_amt",         false,    "",    dfFloat,      2);
                    InitDataProperty(0, cnt++, dtData,      80,     daRight,     true,    "cntr_comm_amt",     false,    "",    dfFloat,      2);
                    InitDataProperty(0, cnt++, dtData,      70,     daRight,     true,    "if_amt",            false,    "",    dfFloat,      2);
                    InitDataProperty(0, cnt++, dtData,      70,     daCenter,    true,    "cre_dt",            false,    "",    dfDateYmd,    0);
                    InitDataProperty(0, cnt++, dtData,      50,     daCenter,    true,    "ff_cmpn_sts_cd",    false,    "",    dfNone);
                    InitDataProperty(0, cnt++, dtData,      300,    daLeft,      true,    "ff_cmpn_rmk",       false,    "",    dfNone);
                    InitDataProperty(0, cnt++, dtData,      70,     daCenter,    true,    "if_dt",             false,    "",    dfDateYmd,    0);

                    InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    true,    "ff_cnt_cd",         false,    "",    dfNone);
                    InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    true,    "ff_seq",            false,    "",    dfNone);
                    InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    true,    "ff_agmt_seq",       false,    "",    dfNone);

                    CountPosition  = 0 ;
                    HeadRowHeight  = 10;
                    WaitImageVisible = false;
                    break;

                case 3:      //sheet3 init
                    // 높이 설정
                    style.height = GetSheetHeight(3) ;
                    //전체 너비 설정
                    SheetWidth = mainTable2.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(26, 2 , 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false) ;

                    var HeadTitle = "SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|CHG|Kind";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,   false,    "seq");
                    InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "ff_cnt_seq");
                    InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "ff_cnt_cust_nm");
                    InitDataProperty(0, cnt++ , dtData,       90,    daCenter,   false,    "shpr_cnt_seq");
                    InitDataProperty(0, cnt++ , dtData,      150,    daLeft,     false,    "shpr_cnt_nm");
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "por_grp_tp_cd");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "por_rout_cd");
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "pol_grp_tp_cd");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "pol_rout_cd");
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   false,    "pod_grp_tp_cd");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "pod_rout_cd");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "fm_eff_dt");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "to_eff_dt");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "sc_no");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "rfa_no");
                    InitDataProperty(0, cnt++ , dtCombo,     100,    daCenter,   false,    "cmdt_tp_cd");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "cmdt_cd");
                    InitDataProperty(0, cnt++ , dtData,      130,    daLeft,     false,    "cmdt_nm");
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "ff_div_cd");
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "ff_bkg_rt");
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "ff_bx_amt");
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "ff_teu_amt");
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "ff_feu_amt");
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "ff_rf_amt");
                    InitDataProperty(0, cnt++ , dtData,      100,    daLeft,     false,    "ff_chg_ctnt");
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "ff_knd_cd");

                    InitDataCombo (0, "por_grp_tp_cd", grpTpText, grpTpCode);
                    InitDataCombo (0, "pol_grp_tp_cd", grpTpText, grpTpCode);
                    InitDataCombo (0, "pod_grp_tp_cd", grpTpText, grpTpCode);
                    InitDataCombo (0, "ff_div_cd", ffCmpnDivCode, ffCmpnDivCode);
                    InitDataCombo (0, "cmdt_tp_cd", "*|Rep|Common", "*|2|3");

                    CountPosition  = 0;
                    WaitImageVisible = false;
                    break;
            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력) - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate", document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:     // 조회
                if (frmObj.bl_no.value == "" && frmObj.bkg_no.value == "") {
                    ComShowMessage(ComGetMsg("COM12138", "B/L", "Booking No.", ""));
                    formObj.bl_no.focus();
                    return false;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0117GS.do", FormQueryString(frmObj)).split("|$$|");
                shtObj.LoadSearchXml(xmlStr[0]);
                sheetObjects[0].LoadSearchXml(xmlStr[1]);
                ComEtcDataToForm(frmObj, shtObj);    //조회된 ETC데이터를 Form의 Hidden오브젝트에 담는다.
                ComOpenWait(false);
                break;

            case SEARCH01:     // Rate 상세 조회
                ComOpenWait(true);
                shtObj.DoSearch("ESM_ACM_0117GS.do", "f_cmd=" + SEARCH01 + CondParam);
                ComOpenWait(false);
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet2_OnLoadFinish(shtObj) {
        // 조회조건의 Office Select Object 생성
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet2_OnDblClick(shtObj, Row, Col) {
        with (shtObj) {
            doActionIBSheet(sheetObjects[2], document.form, SEARCH01, "&ff_cnt_cd=" + Cellvalue(Row, "ff_cnt_cd") + "&ff_seq=" + Cellvalue(Row, "ff_seq") + "&ff_agmt_seq=" + Cellvalue(Row, "ff_agmt_seq"));
        }
    }


/* 개발자 작업 끝 */
