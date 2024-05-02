/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0006.js
*@FileTitle : Agent Commission Request
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.26 김상수
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
     * @class ESM_ACM_0006 : ESM_ACM_0006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0006() {
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
        var shtObj2 = sheetObjects[3];
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

                case "btn_execprc":
                    if (ComShowConfirm("Do you want to execute?")) {
                        doActionIBSheet(shtObj, frmObj, MULTI01);
                    }
                    break;

                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_detail":
                    var sRow = shtObj.SelectRow;
                    if (sRow < 1) {
                        ComShowCodeMessage("COM12189");
                        return;
                    }
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0105.do?generalBrkg=General Commission&" + shtObj.RowSaveStr(sRow), 886, 518, "", "1,0,1,1,1,1,1", true, false);
                    break;

                case "btn_request":
                    doActionIBSheet(shtObj, frmObj, MULTI);
                    break;

                case "btn_exrate":
                    doActionIBSheet(shtObj, frmObj, MULTI02);
                    break;

                case "btn_calculate":
                    doActionIBSheet(shtObj, frmObj, COMMAND01);
                    break;

                case "btn_downexcel":
                    ComOpenWait(true);
                    shtObj.Down2Excel(1, false, false, true, "", "", false, false, "", false, "chk|xch_rt_aply_lvl|brkg_crnt_rev_amt|crs_crnt_rev_amt|brkg_ddct_chg_amt|brkg_ddct_trsp_amt|brkg_ddct_vip_amt|crs_ddct_chg_amt|crs_ddct_trsp_amt|crs_ddct_vip_amt|brkg_post_rev_amt|crs_post_rev_amt");
                    ComOpenWait(false);
                    break;
                    
                case "btn_loadexcel":
                    ComOpenWait(true);
                    shtObj2.LoadExcel(-1, 1, "", -1, -1, "", false, false, "");
                    ComOpenWait(false);
                    break;
                    
                case "btn2_vvd_cd":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;

                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
                    break;

                case "btn2_check":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 1);    // CoAcm.js에 정의
                    break;

                case "btn2_uncheck":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 0);    // CoAcm.js에 정의
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
                    style.height = 366;

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
                    var HeadTitle0  = "STS|CHK|No.|BKG No.|B/L No.|BND|B.OFC|R.VVD|Comm.\nVVD|TRADE|Sub.TRADE|Comm.\nLane|S/A\nDate|Port|B.POR|B.POL|B.POD|B.DEL|POL|POR|POD|DEL|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                                      "Deduction|Deduction|Deduction|Deduction|Deducted\nRevenue|Pre\nAMT\n(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Calculation|Calculation|BDR|Remarks|Agent Code||Shipper Cd.|Shipper Name|Request Flag|||||||||||";
                    var HeadTitle1  = "STS||No.|BKG No.|B/L No.|BND|B.OFC|R.VVD|Comm.\nVVD|TRADE|Sub.TRADE|Comm.\nLane|S/A\nDate|Port|B.POR|B.POL|B.POD|B.DEL|POL|POR|POD|DEL|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                                      "CHG|TRS|Compensation|VIP|Deducted\nRevenue|Pre\nAMT\n(USD)|General|BRKG|CHF|Charge|T/S|Cross|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Date|Time|BDR|Remarks|Agent Code||Shipper Cd.|Shipper Name|Request Flag|||||||||||";
                    
                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 6, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, false);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDummyCheck,   30,     daCenter,    true,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    true,    "seq");
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "bkg_no",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "bl_no",              false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "io_bnd_cd",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "bkg_ofc_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "rev_vvd_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "comm_vvd",           false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         55,     daCenter,    true,    "trd_cd",		       false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         75,     daCenter,    true,    "sub_trd_cd",         false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         55,     daCenter,    true,    "ac_rlane_cd",        false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         70,     daCenter,    true,    "sail_arr_dt",        false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "ac_occr_info_cd",    false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "bkg_por_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "bkg_pol_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "bkg_pod_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "bkg_del_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "pol_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "por_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "pod_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "del_cd");
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    true,    "ac_seq",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "bkg_sts_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,     true,   "cntr_qty",           false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "rev_div_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      90,     daRight,     true,    "crnt_rev_amt",       false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      50,     daRight,     false,   "ddct_chg_amt",       false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      50,     daRight,     false,   "ddct_trsp_amt",      false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      90,     daRight,     false,   "ddct_spcl_cmpn_amt", false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      50,     daRight,     false,   "ddct_vip_amt",       false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      70,     daRight,     true,    "post_rev_amt",       false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "ppd_amt",            false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "general_amt",        false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "brog_amt",           false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "chf_amt",            false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "chg_comm_amt",       false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "ts_amt",             false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "cross_amt",          false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "usd_amt",            false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     true,    "pay_xch_rt",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "curr_cd",            false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "pay_if_amt",         false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "ac_sts_cd",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,   "cre_dt",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,   "cre_tm",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "bdr_flg",            false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    true,    "ac_proc_desc",       false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       80,     daCenter,    true,    "agn_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "xch_rt_aply_lvl");                   
                    InitDataProperty(0, cnt++, dtHidden,       30,     daCenter,    true,    "vndr_seq");
					InitDataProperty(0, cnt++, dtHidden,       30,     daCenter,    true,    "cust_lgl_eng_nm");	
					InitDataProperty(0, cnt++, dtHidden,       30,     daCenter,    true,    "rqst_flg",      	   false,     "",    dfNone,    0,    false,     false); 
                    InitDataProperty(0, cnt++, dtHidden,       90,     daRight,     true,    "brkg_crnt_rev_amt",  false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       90,     daRight,     true,    "crs_crnt_rev_amt",   false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       50,     daRight,     false,   "brkg_ddct_chg_amt",  false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       50,     daRight,     false,   "brkg_ddct_trsp_amt", false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       50,     daRight,     false,   "brkg_ddct_vip_amt",  false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       50,     daRight,     false,   "crs_ddct_chg_amt",   false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       50,     daRight,     false,   "crs_ddct_trsp_amt",  false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       50,     daRight,     false,   "crs_ddct_vip_amt",   false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       70,     daRight,     true,    "brkg_post_rev_amt",  false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       70,     daRight,     true,    "crs_post_rev_amt",   false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    true,    "chg_comm_flg",       false,     "",    dfNone,    0,    false,     false);

                    ColIndent("cntr_qty") = 2;
                    ColIndent("crnt_rev_amt") = 2;
                    ColIndent("ddct_chg_amt") = 2;
                    ColIndent("ddct_trsp_amt") = 2;
                    ColIndent("ddct_vip_amt") = 2;
                    ColIndent("post_rev_amt") = 2;
                    ColIndent("ppd_amt") = 2;
                    ColIndent("general_amt") = 2;
                    ColIndent("brog_amt") = 2; 
                    ColIndent("chf_amt") = 2;
                    ColIndent("chg_comm_amt") = 2;
                    ColIndent("ts_amt") = 2;
                    ColIndent("cross_amt") = 2;
                    ColIndent("usd_amt") = 2;
                    ColIndent("pay_xch_rt") = 2;
                    ColIndent("pay_if_amt") = 2;

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    WaitImageVisible = false;
                    HeadRowHeight = 24;

                    break;

                   
                case "sheet2":
                    var cnt = 0;
                    
                    // 높이 설정
                    style.height = 366;

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
                    var HeadTitle0  = "STS|CHK|No.|BKG No.|B/L No.|BND|R.VVD|Comm.\nVVD|TRADE|Sub.TRADE|Comm.\nLane|S/A\nDate|Port|POL|POR|POD|DEL|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                                      "Deduction|Deduction|Deduction|Deducted\nRevenue|Pre\nAMT\n(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Calculation|Calculation|BDR|Remarks|Agent Code||Shipper Cd.|Shipper Name|Request Flag||||||||";
                    var HeadTitle1  = "STS||No.|BKG No.|B/L No.|BND|R.VVD|Comm.\nVVD|TRADE|Sub.TRADE|Comm.\nLane|S/A\nDate|Port|POL|POR|POD|DEL|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                                      "CHG|TRS|Compensation|Deducted\nRevenue|Pre\nAMT\n(USD)|General|BRKG|CHF|T/S|Cross|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Date|Time|BDR|Remarks|Agent Code||Shipper Cd.|Shipper Name|Request Flag||||||||";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 6, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, false);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDummyCheck,   30,     daCenter,    true,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    true,    "seq");
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "bkg_no",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "bl_no",              false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "io_bnd_cd",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "rev_vvd_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "comm_vvd",           false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         55,     daCenter,    true,    "trd_cd",		       false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         75,     daCenter,    true,    "sub_trd_cd",         false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         55,     daCenter,    true,    "ac_rlane_cd",        false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         70,     daCenter,    true,    "sail_arr_dt",        false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "ac_occr_info_cd",    false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "pol_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "por_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "pod_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "del_cd");
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    true,    "ac_seq",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "bkg_sts_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,     true,   "cntr_qty",           false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "rev_div_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      90,     daRight,     true,    "crnt_rev_amt",       false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      50,     daRight,     false,   "ddct_chg_amt",       false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      50,     daRight,     false,   "ddct_trsp_amt",      false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      90,     daRight,     false,   "ddct_spcl_cmpn_amt", false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      70,     daRight,     true,    "post_rev_amt",       false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "ppd_amt",            false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "general_amt",        false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "brog_amt",           false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "chf_amt",            false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "ts_amt",             false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "cross_amt",          false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "usd_amt",            false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     true,    "pay_xch_rt",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "curr_cd",            false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "pay_if_amt",         false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "ac_sts_cd",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,   "cre_dt",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,   "cre_tm",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "bdr_flg",            false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    true,    "ac_proc_desc",       false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       80,     daCenter,    true,    "agn_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "xch_rt_aply_lvl");        
                    InitDataProperty(0, cnt++, dtHidden,       30,     daCenter,    true,    "vndr_seq");
					InitDataProperty(0, cnt++, dtHidden,       30,     daCenter,    true,    "cust_lgl_eng_nm");	
					InitDataProperty(0, cnt++, dtHidden,       30,     daCenter,    true,    "rqst_flg",      	   false,     "",    dfNone,    0,    false,     false); 
					InitDataProperty(0, cnt++, dtHidden,       0,      daRight,     true,    "brkg_crnt_rev_amt");	
	                InitDataProperty(0, cnt++, dtHidden,       0,      daRight,     true,    "crs_crnt_rev_amt");	
	                InitDataProperty(0, cnt++, dtHidden,       0,      daRight,     false,   "brkg_ddct_chg_amt");	
	                InitDataProperty(0, cnt++, dtHidden,       0,      daRight,     false,   "brkg_ddct_trsp_amt");	
	                InitDataProperty(0, cnt++, dtHidden,       0,      daRight,     false,   "crs_ddct_chg_amt");	
	                InitDataProperty(0, cnt++, dtHidden,       0,      daRight,     false,   "crs_ddct_trsp_amt");	
	                InitDataProperty(0, cnt++, dtHidden,       0,      daRight,     true,    "brkg_post_rev_amt");	
	                InitDataProperty(0, cnt++, dtHidden,       0,      daRight,     true,    "crs_post_rev_amt");	
					

                    ColIndent("cntr_qty") = 2;
                    ColIndent("crnt_rev_amt") = 2;
                    ColIndent("ddct_chg_amt") = 2;
                    ColIndent("ddct_trsp_amt") = 2;
                    ColIndent("post_rev_amt") = 2;
                    ColIndent("ppd_amt") = 2;
                    ColIndent("general_amt") = 2;
                    ColIndent("brog_amt") = 2;
                    ColIndent("chf_amt") = 2;
                    ColIndent("ts_amt") = 2;
                    ColIndent("cross_amt") = 2;
                    ColIndent("usd_amt") = 2;
                    ColIndent("pay_xch_rt") = 2;
                    ColIndent("pay_if_amt") = 2;

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

            case SEARCH01:    // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;

            case IBSEARCH:    // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                sheetObjects[2].DoSearch("ESM_ACM_0006GS.do", FormQueryString(frmObj));
                sheetObjects[2].ColFontUnderline("bkg_no") = true;
                sheetObjects[2].ColFontUnderline("bl_no") = true;
                ComOpenWait(false);
                break;

            case MULTI:    // Request
                if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0006GS.do", FormQueryString(frmObj), "chk", false);
                ComOpenWait(false);
                break;

            case MULTI01:    // EXEC PRC
                if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI01;
                shtObj.DoSave("ESM_ACM_0006GS.do", FormQueryString(frmObj), "chk", false);
                ComOpenWait(false);
                break;

            case MULTI02:    // Ex. Rate Input
                if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI02;
                shtObj.DoSave("ESM_ACM_0006GS.do", FormQueryString(frmObj), "chk", false);
                ComOpenWait(false);
                break;

            case COMMAND01:    // Calculate
                if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = COMMAND01;
                shtObj.DoSave("ESM_ACM_0006GS.do", FormQueryString(frmObj), "chk", false);
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
     }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount > 0) {
                ReDraw = false;
                CellText(LastRow, "seq") = "";
                CellText(LastRow, "bkg_no") = "TOTAL";
                CellAlign(LastRow, "bkg_no") = daRight;
                ReDraw = true;
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnDblClick(shtObj, row, col){
        var sRow = shtObj.SelectRow;
        if (sRow < 1) {
            ComShowCodeMessage("COM12189");
            return;
        }
        // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
        
        if(shtObj.ColSaveName(col) == "brog_amt" && Number(shtObj.CellValue(row, "brog_amt")) != 0){
        	ComOpenPopup("ESM_ACM_0105.do?brkg_flg=1&generalBrkg=Brokerage&" + shtObj.RowSaveStr(row), 886, 518, "", "1,0,1,1,1,1,1", true, false);
        } else if(shtObj.ColSaveName(col) == "cross_amt" && Number(shtObj.CellValue(row, "cross_amt")) != 0){
        	ComOpenPopup("ESM_ACM_0105.do?brkg_flg=2&generalBrkg=Cross&" + shtObj.RowSaveStr(row), 886, 518, "", "1,0,1,1,1,1,1", true, false);
        } else{
        	ComOpenPopup("ESM_ACM_0105.do?generalBrkg=General Commission&" + shtObj.RowSaveStr(sRow), 886, 518, "", "1,0,1,1,1,1,1", true, false);	
        }        
    }


    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }

   
    /**
     * Excel Upload 후 실행되는 이벤트
     * flag에 따라 자동 체크표시 해주는 이벤트
     */
	function sheet2_OnLoadExcel(shtObj2) { 
		var shtObj2 = sheetObjects[3];
		var shtObj = sheetObjects[2];
		var rowCount = shtObj2.RowCount;

		for (var i=0; i<rowCount; i++) {
			if ((shtObj2.CellValue(i,"rqst_flg").toUpperCase()) == "Y") {
				shtObj.CellValue2(i, "chk") = 1;
			}
		}
		sheet2_OnSearchEnd(shtObj2, "");
    }  
    
    /**
     * Form Element의 OnChange 이벤트
     * Office선택 시 Sub Office가져오는 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj = sheetObjects[0];
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
            }
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {Object} shtObj
     * @param {Object} formObj
     * @param {Object} sAction
     */
    function validateForm(shtObj, frmObj, sAction){
        with(frmObj){
            switch(sAction) {

                case MULTI:    //Request
                    var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
                     if (chkRowArr.length > 1) { 
                        for (var i=0; i<chkRowArr.length-1; i++) {
                            // BL No.가 없을 때
                            if (shtObj.CellValue(chkRowArr[i], "bl_no") == "") {
                                ComShowCodeMessage("ACM00019", parseInt(chkRowArr[i]) -1);
                                //ComShowMessage(parseInt(chkRowArr[i])-1 + " row could not be requested! Because B/L No does not exist.\n\n Please check again.");
                                shtObj.CellValue(chkRowArr[i], "chk") = "0";
                                return false;
                            }

                            // Advanced 부킹일 때
                            if (shtObj.CellValue(chkRowArr[i], "bkg_sts_cd") == "A") {
                                ComShowCodeMessage("ACM00020", "A");
                                //ComShowMessage("There is(are) ‘A’ status booking(s). Please exclude ‘A’ status booking(s).");
                                shtObj.CellValue(chkRowArr[i], "chk") = "0";
                                return false;
                            }
                            
                            // Cancel 부킹이고 ac_seq가 1일때
						    if (shtObj.CellValue(chkRowArr[i], "bkg_sts_cd") == "X" && shtObj.CellValue(chkRowArr[i], "ac_seq") == "1") {
                                ComShowCodeMessage("ACM00020", "X");
                                //ComShowMessage("There is(are) ‘X’ status booking(s). Please exclude ‘X’ status booking(s).");
                                shtObj.CellValue(chkRowArr[i], "chk") = "0";
                                return false;
                            }
						    
                            if (shtObj.CellValue(chkRowArr[i], "ac_sts_cd") != "CS") { 
                                ComShowCodeMessage("ACM00022");
                                //ComShowMessage("Please request CS status bookings only!");
                                shtObj.CellValue(chkRowArr[i], "chk") = "0";
                                return false;
                            }

                            if (shtObj.CellValue(chkRowArr[i], "pay_if_amt") == "0") {
                                ComShowCodeMessage("ACM00023");
                                //ComShowMessage("Zero commission booking(s) exist(s). Please exclude zero commission booking(s) first!");
                                shtObj.CellValue(chkRowArr[i], "chk") = "0";
                                return false;
                            }

                            if (shtObj.CellValue(chkRowArr[i], "bdr_flg") == "N") {
                                ComShowCodeMessage("ACM00025");
                                //ComShowMessage("Bookings before BDR cannot be requested. Please exclude bookings before BDR.");
                                return false;
                            }
                        }
                    }
                    break;
                    
                // 2017.08.25 Charge Commission 추가
                case MULTI02:
                    var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
                    if (chkRowArr.length > 1) { 
                        for (var i=0; i<chkRowArr.length-1; i++) {
                            if (shtObj.CellValue(chkRowArr[i], "chg_comm_flg") == "Y") {
                                ComShowCodeMessage("ACM00037", parseInt(chkRowArr[i]) -1);
                                shtObj.CellValue(chkRowArr[i], "chk") = "0";
                                return false;
                            }         
                        }
                    }
                    break;
            }
        }
        return true;
    }


/* 개발자 작업 끝 */
