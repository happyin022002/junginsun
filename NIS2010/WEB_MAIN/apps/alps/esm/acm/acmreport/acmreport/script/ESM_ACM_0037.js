/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0037.js
*@FileTitle : Commission Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.09.04 김상수
* 1.0 Creation

2014.04.30 박다은 [CHM-201430019] Report / Commission Report  // TEU, FEU Total Sum 항목 추가 요청
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
     * @class ESM_ACM_0037 : ESM_ACM_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0037() {
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
        var shtObj = sheetObjects[1];
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            if (srcName != "btn2_bl_no") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.bl_no);    // CoAcm.js에 정의
            }

            switch (srcName) {
                case "btn_calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.fm_dt, frmObj.to_dt, "yyyy-MM-dd");
                    }
                    break;

                case "btn_retrieve":
                    if (ComGetUnMaskedValue(ComGetDateAdd(frmObj.fm_dt.value, "M", 6), "ymd") < ComGetUnMaskedValue(frmObj.to_dt.value, "ymd")) {
                    	ComShowCodeMessage("COM132001","Period","6 months"); //{?msg1} exceeds maximum duration {?msg2}.
                        frmObj.fm_dt.focus();
                        return;
                    }
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_downexcel":
                    ComOpenWait(true);
                    shtObj.SpeedDown2Excel(-1);
                    ComOpenWait(false);
                    break;

                case "btn_bkg_ofc_popup":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_071.do", 700, 445, "setPopupData_bkgOfcCd", "1,0,1,1,1,1,1", true);
                    break;

                case "btn_ob_sls_ofc_popup":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_071.do", 700, 445, "setPopupData_obSlsOfcCd", "1,0,1,1,1,1,1", true);
                    break;

                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;

                case "btn_rpt_itm_popup":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0118.do", 608, 470, "", "1,0,1,1,1,1,1", true);
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
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     */
    function setPopupData_bkgOfcCd(aryPopupData) {
        if (aryPopupData.length > 0 ) {
            document.form.bkg_ofc_cd.value = aryPopupData[0][3];
        }
    }


    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     */
    function setPopupData_obSlsOfcCd(aryPopupData) {
        if (aryPopupData.length > 0 ) {
            document.form.ob_sls_ofc_cd.value = aryPopupData[0][3];
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
                    ACMMemoSheet_InitSheet(shtObj);    // CoAcm.js에 정의
                    break;

                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 315;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    /******************<주의>******************
                     * Sheet 항목에 변경이 있을 경우 다음 3가지에 대하여 수정이 필요함
                     * 1. js 파일
                     * 2. VO 파일
                     * 3. AGT_RPT_ITM_INFO_DTL 의 데이터
                     * ->경우에 따라서는 ACMReportBackEndJobSearchCommReport.java 파일 수정 필요(변경대상 항목이 조회 SQL의 Group By 대상일 경우 )
                     *****************************************/
                    // 컬럼 헤더타이틀
                    var HeadTitle  = "B/L No.|BKG No.|BND|Comm.VVD|R.VVD|S/A date|POR|POL|POD|DEL|TEU/FEU|FAC|CommⅠ|Comm Ⅱ|Brokerage|CHF|T/S|T/R|SOC|Cross|DOC|Deduction|USD AMT|Curr|Calc Date|RQST Date|Approval Date|I/F Date|PPD OFT|CCT OFT|" +
                                     "PPD Charge|CCT Charge|Net O/Rev|Gross Rev|PYMT AMT|F.Forwarder|F.F NAME|F.F ADDR|BRO ADDR1|BRO ADDR2|BRO ADDR3|BRO ADDR4|BRO ADDR5|BRO ADDR6|PAN CODE|Trade|Lane|Direction|TEU|FEU|Audit No.";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "bl_no");
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "bkg_no");
                    InitDataProperty(0, cnt++, dtData,         35,     daCenter,    false,    "io_bnd_cd");
                    InitDataProperty(0, cnt++, dtData,         75,     daCenter,    false,    "comm_vvd");
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "rev_vvd");
                    InitDataProperty(0, cnt++, dtData,         75,     daCenter,    false,    "sail_arr_dt");
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "por_cd");
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "pol_cd");
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "pod_cd");
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "del_cd");
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,    "teu_feu");
                    InitDataProperty(0, cnt++, dtData,         50,     daRight,     false,    "fac_amt",       false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "com_i",         false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "com_ii",        false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         70,     daRight,     false,    "brokerage_amt", false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "chf_amt",       false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "ts_amt",        false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "tr_amt",        false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "soc_amt",       false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "cross_amt",     false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     false,    "doc_amt",       false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         70,     daRight,     false,    "ddct_amt",      false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         70,     daRight,     false,    "usd_amt",       false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtData,         75,     daCenter,    false,    "calc_dt");
                    InitDataProperty(0, cnt++, dtData,         75,     daCenter,    false,    "rqst_dt");
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "apro_dt");
                    InitDataProperty(0, cnt++, dtData,         75,     daCenter,    false,    "if_dt");
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "ppd_frt_amt",   false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "clt_frt_amt",   false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "ppd_otr_amt",   false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "clt_otr_amt",   false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "net_amt",       false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "gross_amt",     false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "pymt_amt",      false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "ff_cd");
                    InitDataProperty(0, cnt++, dtData,         200,    daLeft,      false,    "ff_name");
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,      false,    "ff_addr");
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,      false,    "bro_addr1");
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,      false,    "bro_addr2");
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,      false,    "bro_addr3");
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,      false,    "bro_addr4");
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,      false,    "bro_addr5");
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,      false,    "bro_addr6");
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "pan_code");
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "trd_cd");
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "rlane_cd");
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,    "dir_cd");
                    InitDataProperty(0, cnt++, dtAutoSum,      50,     daRight,     false,    "teu",           false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtAutoSum,      50,     daRight,     false,    "feu",           false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "aud_no");

                    WaitImageVisible = false;
                    MessageText("Sum") = "Total Sum";
                    
                    
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
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd", "s_trd_cd", "slct_itm_fom_seq");
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:
                // Customized RPT Form 목록 조회
                var xmlStr2 = shtObj.GetSearchXml("ESM_ACM_0037GS.do", "f_cmd=" + SEARCH01);
                ACMXml2SelectItem(xmlStr2, frmObj.slct_itm_fom_seq, "slct_itm_fom_desc", "slct_itm_fom_seq", true);
                frmObj.slct_itm_fom_seq.fireEvent("onchange");    // form.slct_itm_fom_seq에 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                break;

            case SEARCH02:
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                // Trade 목록 조회
                var xmlStr2 = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH24);
                ACMXml2SelectItem(xmlStr2, frmObj.s_trd_cd, "value0", "value0", true);
                break;

            case IBSEARCH:    // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCHLIST01;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0037GS.do", FormQueryString(frmObj));
                backEndJobKey = ComGetEtcData(xmlStr, "backendjob_key")    // 전역변수로 setting
                if (backEndJobKey != "") {
                    shtObj.RequestTimeOut = 20000;
                    timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
                }
                break;
        }
    }


    /**
     * BackEndJob 호출함수
     */
    function getBackEndJobStatus() {
        var shtObj1 = sheetObjects[1];
        var xmlStr = shtObj1.GetSearchXml("ESM_ACM_0037GS.do", "f_cmd=" + SEARCHLIST02 + "&backendjob_key=" + backEndJobKey);
        var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg")

        if (jbStsFlg == "3") {
            shtObj1.DoSearch4Fx("ESM_ACM_0037GS.do", "f_cmd=" + SEARCHLIST03 + "&backendjob_key=" + backEndJobKey);
            clearInterval(timer);
            backEndJobKey = "";
            ComOpenWait(false);

        } else if (jbStsFlg == "4") {
            clearInterval(timer);
            backEndJobKey = "";
            ComOpenWait(false);
            ComShowCodeMessage("COM130406", "using Back End Job");    // Failed to retrieve {?msg1}. Please try again.

        } else if (jbStsFlg == "5") {
            clearInterval(timer);
            backEndJobKey = "";
            ComOpenWait(false);
            ComShowCodeMessage("ACM00029");    // Created BackEndJob File exist already!
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Office Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
         doActionIBSheet(shtObj, document.form, SEARCH02);
     }


    /**
     * Form Element의 OnChange 이벤트
     * Office선택 시 Sub Office가져오는 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj = sheetObjects[1];
        with (document.form) {
            switch (elementName) {

                case "ar_ofc_cd":
                    if (ar_ofc_cd.value == "") {
                        ComClearCombo(agn_cd);
                        return;
                    }
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + ar_ofc_cd.value);
                    if (ACMXml2SelectItem(xmlStr, agn_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (agn_cd.options.length > 1) {
                            // ar_ofc_cd와 같은 값이 선택되게 함
                            agn_cd.value = ar_ofc_cd.value;
                        }
                    }
                    break;

                case "s_trd_cd":
                    if (s_trd_cd.value == "") {
                        ComClearCombo(s_rlane_cd);
                        return;
                    }
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH25 + "&value0=" + s_trd_cd.value);
                    ACMXml2SelectItem(xmlStr, s_rlane_cd, "value0", "value0", false);
                    break;

                case "slct_itm_fom_seq":
                    shtObj.ReDraw = false;
                    shtObj.RemoveEtcData();
                    shtObj.RemoveAll();
                    var reportItem = "";
                    if (slct_itm_fom_seq.value == "") {
                        for (var i=0; i<shtObj.LastCol+1; i++) {
                            reportItem += (shtObj.ColSaveName(i) + "|");
                            shtObj.ColHidden(i) = false;
                        }
                        report_item.value = "|" + reportItem;
                    } else {
                        // Customized RPT Form 콤보에 따른 IBSheet헤더명을 조회
                        var xmlStr = shtObj.GetSearchXml("ESM_ACM_0037GS.do", "f_cmd=" + SEARCH02 + "&slct_itm_fom_seq=" + slct_itm_fom_seq.value);
                        reportItem = ComGetEtcData(xmlStr, "report_item");
                        if (reportItem.length > 1) {
                            for (var i=0; i<shtObj.LastCol+1; i++) {
                                if (reportItem.indexOf(shtObj.ColSaveName(i)) > -1) {
                                    shtObj.ColHidden(i) = false;
                                } else {
                                    shtObj.ColHidden(i) = true;
                                }
                            }
                            report_item.value = reportItem;
                        }
                    }
                    shtObj.ReDraw = true;
                    break;
            }
        }
    }


/* 개발자 작업 끝 */
