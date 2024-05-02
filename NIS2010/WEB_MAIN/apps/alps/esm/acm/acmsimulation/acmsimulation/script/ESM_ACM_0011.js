/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0011.js
*@FileTitle : Agent Commission Simulation Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.05 김상수
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
     * @class ESM_ACM_0011 : ESM_ACM_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0011() {
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

    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;

    var t1s1chkRowIdx = -1;
    var t2s2chkRowIdx = -1;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var t1shtObj1 = sheetObjects[0];
        var t2shtObj2 = sheetObjects[2];
        var t2shtObj3 = sheetObjects[3];
        var t3shtObj1 = sheetObjects[8];

        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "tab1btn_retrieve":    // TAB1_Retrieve
                    doActionIBSheet(t1shtObj1, frmObj, IBSEARCH);
                    break;

                case "tab1btn_save":    // TAB1_Save
                    doActionIBSheet(t1shtObj1, frmObj, IBSAVE);
                    break;

                case "tab1btn_add":    // TAB1_Row Add
                    doActionIBSheet(t1shtObj1, frmObj, IBINSERT);
                    break;

                case "tab1btn_copy":    // TAB1_Copy
                    if (!ComChkValid(frmObj)) return;
                    var param = "?agn_cd=" + frmObj.agn_cd.value;
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet)
                    ComOpenPopup("ESM_ACM_0115.do" + param, 500, 454, "", "1,0,1,1,1,1,1", true, false);
                    break;

                case "rate_div":    // Compensation Rate의 radio버튼
                    if (t2shtObj3.RowCount < 1) return;
                    if (frmObj.rate_div[1].checked) {
                        ACMCellEditable(t2shtObj3, "oft_pay_term_cd", "comm_fx_amt", false);    // CoAcm.js에 정의
                        ACMCellEditable(t2shtObj3, "comm_pay_term_cd", "comm_rt", true);    // CoAcm.js에 정의
                        t2shtObj2.CellValue2(t2s2chkRowIdx, "rate_div") = "R";
                    } else {
                        ACMCellEditable(t2shtObj3, "comm_pay_term_cd", "comm_rt", false);    // CoAcm.js에 정의
                        ACMCellEditable(t2shtObj3, "oft_pay_term_cd", "comm_fx_amt", true);    // CoAcm.js에 정의
                        t2shtObj2.CellValue2(t2s2chkRowIdx, "rate_div") = "F";
                    }
                    break;

                case "tab2btn_add":    // TAB2_Row Add
                    // 신규 행추가는 한 row만 가능
                    if (t2shtObj2.RowCount("I") > 0) return;
                    for (var i=3; i<8; i++) {
                        sheetObjects[i].RemoveAll();
                    }
                    var t2s2newRowIdx = t2shtObj2.DataInsert(-1);
                    t2shtObj2.CellValue2(t2s2newRowIdx, "rate_div") = "F";
                    t2shtObj2.CellValue2(t2s2newRowIdx, "agn_agmt_no") = t1shtObj1.CellValue(t1s1chkRowIdx, "agn_agmt_no");
                    t2shtObj2.CellValue2(t2s2newRowIdx, "agn_cd") = t1shtObj1.CellValue(t1s1chkRowIdx, "agn_cd");
                    // 신규 행추가와 동시에 CHK에 OnChange 이벤트
                    t2shtObj2.CellValue(t2s2newRowIdx, "chk") = "1";
                    break;

                case "tab2btn_delete":    // TAB2_Delete
                    // RowStatus만 Delete로
                    if (t2s2chkRowIdx > 0) {
                        if (ComShowCodeConfirm("ACM00006")) {    // "Selected agreement will be inactivated. Will you proceed?"
                            t2shtObj2.RowStatus(t2s2chkRowIdx) = "D";
                        }
                    }
                    break;

                case "tab2btn_retrieve":    // TAB2_Retrieve
                    // TAB2의 내용을 조회하기 위해 TAB1 Sheet1의 OnChange이벤트를 발생
                    tab1sheet1_OnChange(t1shtObj1, t1s1chkRowIdx, t1shtObj1.SaveNameCol("chk"), "1");
                    break;

                case "tab2btn_save":    // TAB2_Save
                    doActionIBSheet(t2shtObj2, frmObj, MULTI01);
                    break;

                case "tab3btn_retrieve":    // TAB3_Retrieve
                    doActionIBSheet(t3shtObj1, frmObj, SEARCH03);
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tabObj){
        tabObjects[tabCnt++] = tabObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var k=0; k<tabObjects.length; k++){
            initTab(tabObjects[k], k+1);
        }

        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        initControl();
        tabObjects[0].TabEnable(1) = false;    // Detail (Compensation) 탭 비 활성화

        // tab1sheet1_OnLoadFinish 메서드 존재시 반드시 참조

    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj, tabNo) {
        with (tabObj) {
            var cnt = 0 ;
            InsertTab(cnt++, " Master ", -1);
            InsertTab(cnt++, " Detail (Compensation) ", -1);
            InsertTab(cnt++, " Summary ", -1);
        }
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var shtId = shtObj.id;

        with (shtObj) {

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            document.form.pagerows.value = 500;

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, false, false, true, false, false);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // Combo 항목이 없는 경우 조회한 글자 그대로 표시하기
            InitComboNoMatchText(true);

            ShowButtonImage = 3;
            WaitImageVisible = false;
            CountPosition = 0;

            switch (shtId) {

                case "tab1sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(19);;

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(2, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|CHK|AGMT No.|Effective date|Effective date|Effective date|Effective date|Remark|Update Date|Update Date|Update User|DEL|agn_cd";
                    var HeadTitle1  = "STS|CHK|AGMT No.|From|From|To|To|Remark|Local Time|GMT|Update User|DEL|agn_cd";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus,     40,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtRadioCheck, 40,     daCenter,    true,    "chk");
                    InitDataProperty(0, cnt++, dtData,       80,     daCenter,    true,    "agn_agmt_no",      false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,      140,    daCenter,    false,   "agmt_fm_dt_cd",    true);
                    InitDataProperty(0, cnt++, dtData,       75,     daCenter,    false,   "agmt_fm_dt",       true,     "",    dfDateYmd);
                    InitDataProperty(0, cnt++, dtCombo,      140,    daCenter,    false,   "agmt_to_dt_cd",    true);
                    InitDataProperty(0, cnt++, dtData,       75,     daCenter,    false,   "agmt_to_dt",       true,     "",    dfDateYmd);
                    InitDataProperty(0, cnt++, dtData,       200,    daLeft,      true,    "agn_agmt_rmk",     false,    "",    dfNone,    0,    true,     true,     500);
                    InitDataProperty(0, cnt++, dtData,       100,    daCenter,    false,   "upd_dt_lcl",       false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,       100,    daCenter,    false,   "upd_dt_gmt",       false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,       100,    daCenter,    true,    "usr_id",           false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,      30,     daCenter,    true,    "delt_flg");

                    InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    true,    "agn_cd");    // INSERT / UPDATE를 위한 PK

                    // 입력제한
                    InitDataValid(0, "agn_agmt_rmk", vtEngUpOther, "1234567890 ");    // 영대문자+숫자+스페이스만

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "agmt_fm_dt_cd", " |" + effDivText, " |" + effDivCode, "");
                    InitDataCombo(0, "agmt_to_dt_cd", " |" + effDivText, " |" + effDivCode, "");
                    InitDataCombo(0, "delt_flg", "Y|N", "Y|N", "N");

                    ColIndent("agn_agmt_rmk") = 2;

                    break;


                case "tab2sheet1":    // Selected Agreement
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(3);

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(2, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|AGMT No.|Effective date|Effective date|Effective date|Effective date|Remark|DEL";
                    var HeadTitle1  = "STS|AGMT No.|From|From|To|To|Remark|DEL";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,     "agn_agmt_no");
                    InitDataProperty(0, cnt++, dtCombo,        120,    daCenter,    false,    "agmt_fm_dt_cd");
                    InitDataProperty(0, cnt++, dtData,         75,     daCenter,    false,    "agmt_fm_dt",     false,    "",    dfDateYmd);
                    InitDataProperty(0, cnt++, dtCombo,        140,    daCenter,    false,    "agmt_to_dt_cd",  false);
                    InitDataProperty(0, cnt++, dtData,         75,     daCenter,    false,    "agmt_to_dt",     false,    "",    dfDateYmd);
                    InitDataProperty(0, cnt++, dtData,         400,    daLeft,      true,     "agn_agmt_rmk");
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,     "delt_flg");

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "agmt_fm_dt_cd", " |" + effDivText, " |" + effDivCode, "");
                    InitDataCombo(0, "agmt_to_dt_cd", " |" + effDivText, " |" + effDivCode, "");

                    ColIndent("agn_agmt_rmk") = 2;

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    // 선택된 행의 하이라이트
                    SelectHighLight = false;
                    break;


                case "tab2sheet2":    // Compensation Master
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(13);

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;   // 292px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|CHK|SEQ|Bound|Account" +
                                     // Hidden 컬럼
                                     "|OFT Term|TP/SZ|Full/MT|Curr|Fixed AMT|Pay Term|Base|Rate|R. CHG|CHG|O. Haulage|D. Haulage|O. Feederage|D. Feederage" +
                                     "|por_1|por_2|por_3|por_4|por_lvl_cd|POR|pol_1|pol_2|pol_3|pol_4|pol_lvl_cd|POL|pod_1|pod_2|pod_3|pod_4|pod_lvl_cd|POD|del_1|del_2|del_3|del_4|del_lvl_cd|DEL" +
                                     "|Type|Covered Location|Office|rate_div|agn_cd|agn_agmt_no|agn_agmt_seq|agmt_dtl_pk";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 조회 후 포커스를 두지 않음
                    FocusAfterProcess = false;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus,       30,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtRadioCheck,   30,     daCenter,    true,     "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    false,    "seq");
                    InitDataProperty(0, cnt++, dtCombo,        54,     daCenter,    true,     "io_bnd_cd",         true,    "",    dfNone,    0,    false,    true);
                    InitDataProperty(0, cnt++, dtCombo,        100,    daCenter,    true,     "ac_tp_cd",          true,    "",    dfNone,    0,    false,    true);

                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,     "oft_pay_term_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    true,     "cntr_tpsz_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "full_mty_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "comm_fx_amt");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "comm_pay_term_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "rev_div_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "comm_rt");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "rep_chg_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "chg_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "hlg_ddct_org_flg");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "hlg_ddct_dest_flg");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "fdrg_ddct_org_flg");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "fdrg_ddct_dest_flg");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_lvl_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_lvl_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_lvl_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_lvl_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "ofc_set_tp_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "ofc_cvrg_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "ofc_cd");

                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "rate_div");
                    //Update시 PK
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "agn_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "agn_agmt_no");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "agn_agmt_seq");
                    //저장후 check row 찾기용
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "agmt_dtl_pk");

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "io_bnd_cd", ioBndText, ioBndCode);
                    InitDataCombo(0, "ac_tp_cd", " |" + acTpText, " |" + acTpCode, "");

                    break;


                case "tab2sheet3":    // Compensation Rate (화면용)
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;    // 652px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle = "STS|OFT Term|TP/SZ|Full/MT|Curr|Fixed AMT|Pay Term|Base|Rate(%)";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "oft_pay_term_cd");
                    InitDataProperty(0, cnt++, dtPopup,        100,    daLeft,      false,    "cntr_tpsz_cd");
                    InitDataProperty(0, cnt++, dtCombo,        60,     daCenter,    false,    "full_mty_cd");
                    InitDataProperty(0, cnt++, dtPopupEdit,    60,     daCenter,    false,    "curr_cd"       ,    false,    "",    dfNone,     0,    true,     true,    3,    true);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "comm_fx_amt",       false,    "",    dfFloat,    2);

                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "comm_pay_term_cd");
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "rev_div_cd");
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "comm_rt",           false,    "",    dfFloat,    2);

                    // 입력제한
                    InitDataValid(0, "curr_cd", vtEngUpOnly);    // 영대문자만

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "oft_pay_term_cd", commPayTermText, commPayTermCode);
                    InitDataCombo(0, "full_mty_cd", fullMtyText, fullMtyCode);
                    InitDataCombo(0, "comm_pay_term_cd", commPayTermText, commPayTermCode);
                    InitDataCombo(0, "rev_div_cd", revDivText, revDivCode);

                    ColIndent("cntr_tpsz_cd") = 2;
                    ColIndent("comm_fx_amt") = 2;
                    ColIndent("comm_rt") = 2;

                    // 선택된 행의 하이라이트
                    SelectHighLight = false;

                    break;


                case "tab2sheet4":    // Office Setting (화면용)
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;    // 315px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|Type|Covers|Office";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtCombo,        100,    daCenter,    false,    "ofc_set_tp_cd");
                    InitDataProperty(0, cnt++, dtCombo,        120,    daCenter,    false,    "ofc_cvrg_cd");
                    InitDataProperty(0, cnt++, dtPopupEdit,    80,     daCenter,    false,    "ofc_cd"       ,    false,    "",    dfNone,    0,    true,     true,    5,    true);

                    // 입력제한
                    InitDataValid(0, "ofc_cd", vtEngUpOnly);    // 영대문자만

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "ofc_set_tp_cd", ofcSetTpText, ofcSetTpCode);
                    InitDataCombo(0, "ofc_cvrg_cd", " |" + ofcCvrgText, " |" + ofcCvrgCode, "");

                    // 선택된 행의 하이라이트
                    SelectHighLight = false;

                    break;


                case "tab2sheet5":    // Route Setting (화면용)
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;    // 315px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|por_1|por_2|por_3|por_4|por_lvl_cd|POR|pol_1|pol_2|pol_3|pol_4|pol_lvl_cd|POL|pod_1|pod_2|pod_3|pod_4|pod_lvl_cd|POD|del_1|del_2|del_3|del_4|del_lvl_cd|DEL";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_lvl_cd");
                    InitDataProperty(0, cnt++, dtPopup,        78,     daCenter,    false,    "por");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_lvl_cd");
                    InitDataProperty(0, cnt++, dtPopup,        78,     daCenter,    false,    "pol");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_lvl_cd");
                    InitDataProperty(0, cnt++, dtPopup,        78,     daCenter,    false,    "pod");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_lvl_cd");
                    InitDataProperty(0, cnt++, dtPopup,        78,     daCenter,    false,    "del");

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    // 선택된 행의 하이라이트
                    SelectHighLight = false;

                    break;


                case "tab2sheet6":    // Charge/Surcharge Deduction Setting (화면용)
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;    // 652px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|Rep. Charge|Individual Charge/Surcharge";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtPopup,        200,    daLeft,      false,    "rep_chg_cd");
                    InitDataProperty(0, cnt++, dtPopup,        400,    daLeft,      false,    "chg_cd");

                    ColIndent("rep_chg_cd") = 2;
                    ColIndent("chg_cd") = 2;

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    // 선택된 행의 하이라이트
                    SelectHighLight = false;

                    break;


                case "tab2sheet7":    // Haulage Deduction Setting (화면용)
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;    // 652px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|Origin Inland Haulage|Dest Inland Haulage|Origin Feederage|Dest Feederage";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtCheckBox,     162,    daCenter,    false,    "hlg_ddct_org_flg");
                    InitDataProperty(0, cnt++, dtCheckBox,     162,    daCenter,    false,    "hlg_ddct_dest_flg");
                    InitDataProperty(0, cnt++, dtCheckBox,     162,    daCenter,    false,    "fdrg_ddct_org_flg");
                    InitDataProperty(0, cnt++, dtCheckBox,     162,    daCenter,    false,    "fdrg_ddct_dest_flg");

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    // 선택된 행의 하이라이트
                    SelectHighLight = false;

                    break;


                case "tab3sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(6)

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(2, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|CHK|Agreement No.|Effective date|Effective date|Effective date|Effective date|Remark|DEL|agn_cd";
                    var HeadTitle1  = "STS|CHK|Agreement No.|From|From|To|To|Remark|DEL|agn_cd";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtRadioCheck,   40,     daCenter,    true,     "chk");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,     "agn_agmt_no",      false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        120,    daCenter,    false,    "agmt_fm_dt_cd",    false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         75,     daCenter,    false,    "agmt_fm_dt",       false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        120,    daCenter,    false,    "agmt_to_dt_cd",    false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         75,     daCenter,    false,    "agmt_to_dt",       false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         300,    daLeft,      true,     "agn_agmt_rmk",     false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        30,     daCenter,    true,     "delt_flg",         false,    "",    dfNone,    0,    false,    false);

                    InitDataProperty(0, cnt++, dtHidden,       80,     daCenter,    true,     "agn_cd");    // Agreement Detail 조회를 위한 PK

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "agmt_fm_dt_cd", " |" + effDivText, " |" + effDivCode, "");
                    InitDataCombo(0, "agmt_to_dt_cd", " |" + effDivText, " |" + effDivCode, "");
                    InitDataCombo(0, "delt_flg", "Y|N", "Y|N", "N");

                    ColIndent("agn_agmt_rmk") = 2;

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    break;


                case "tab3sheet2":
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(10);

                    // 전체 너비 설정
                    SheetWidth = mainTableT1S1.clientWidth;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(2, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|Bound|Account|Fixed Base|Fixed Base|Fixed Base|Fixed Base|Fixed Base|Rate Base|Rate Base|Rate Base|Deduction|Deduction|Deduction|Deduction|Deduction|Deduction|Route Setting|Route Setting|Route Setting|Route Setting|Office Setting|Office Setting|Office Setting";
                    var HeadTitle1  = "STS|Bound|Account|OFT Term|TP/SZ|Full/MT|Curr|Fixed AMT|Pay Term|Base|Rate|R. CHG|CHG|O. Haulage|D. Haulage|O. Feederage|D. Feederage|POR|POL|POD|DEL|Type|Covered Location|Office";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtCombo,        50,     daCenter,    true,     "io_bnd_cd");
                    InitDataProperty(0, cnt++, dtCombo,        150,    daCenter,    true,     "ac_tp_cd");

                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "oft_pay_term_cd");
                    InitDataProperty(0, cnt++, dtData,         80,     daLeft,      true,     "cntr_tpsz_cd");
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "full_mty_cd");
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "comm_fx_amt",       false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "comm_pay_term_cd");
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "rev_div_cd");
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "comm_rt",           false,    "",    dfFloat,    2);

                    InitDataProperty(0, cnt++, dtData,         80,     daLeft,      false,    "rep_chg_cd");
                    InitDataProperty(0, cnt++, dtData,         100,    daLeft,      false,    "chg_cd");

                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "hlg_ddct_org_flg");
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "hlg_ddct_dest_flg");
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "fdrg_ddct_org_flg");
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "fdrg_ddct_dest_flg");

                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "por");
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "pol");
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "pod");
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "del");

                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "ofc_set_tp_cd");
                    InitDataProperty(0, cnt++, dtCombo,        110,    daCenter,    false,    "ofc_cvrg_cd");
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "ofc_cd");

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "io_bnd_cd", ioBndText, ioBndCode);
                    InitDataCombo(0, "ac_tp_cd", acTpText, acTpCode);
                    InitDataCombo(0, "oft_pay_term_cd", commPayTermText, commPayTermCode);
                    InitDataCombo(0, "full_mty_cd", fullMtyText, fullMtyCode);
                    InitDataCombo(0, "comm_pay_term_cd", commPayTermText, commPayTermCode);
                    InitDataCombo(0, "rev_div_cd", revDivText, revDivCode);
                    InitDataCombo(0, "hlg_ddct_org_flg", "Y|N", "1|0");
                    InitDataCombo(0, "hlg_ddct_dest_flg", "Y|N", "1|0");
                    InitDataCombo(0, "fdrg_ddct_org_flg", "Y|N", "1|0");
                    InitDataCombo(0, "fdrg_ddct_dest_flg", "Y|N", "1|0");
                    InitDataCombo(0, "ofc_set_tp_cd", ofcSetTpText, ofcSetTpCode);
                    InitDataCombo(0, "ofc_cvrg_cd", " |" + ofcCvrgText, " |" + ofcCvrgCode, "");

                    ColIndent("cntr_tpsz_cd") = 2;
                    ColIndent("comm_fx_amt") = 2;
                    ColIndent("comm_rt") = 2;
                    ColIndent("rep_chg_cd") = 2;
                    ColIndent("chg_cd") = 2;

                    break;
            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "rhq_cd_disp", "ar_ofc_cd", "agn_cd");
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:       // RHQ 목록 조회
                // RHQ level과 목록 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH07);
                ACMXml2SelectItem(xmlStr, frmObj.rhq_cd_disp, "value0", "value0", true);    // CoAcm.js에 정의
                var rhqCd = ComGetEtcData(xmlStr, "rhq_cd");
                ofcKndCd = ComGetEtcData(xmlStr, "ofc_knd_cd");    // *** 반드시 전역변수로 setting에 유의 ***
                if (rhqCd == "") {
                    // 본사 User일 경우 (rhqCd가 Null로 조회)
                    frmObj.rhq_cd_disp.style.display = "inline";    // hidden인 form.rhq_cd_disp가 보여지게 함
                    frmObj.rhq_cd.style.display = "none";    // form.rhq_cd는 숨김
                } else {
                    frmObj.rhq_cd_disp.value = rhqCd;    // hidden상태 그대로 form.rhq_cd_disp에 rhqCd가 선택되게 하고
                    frmObj.rhq_cd_disp.fireEvent("onchange");    // hidden상태 그대로 form.rhq_cd_disp에 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                }
                break;

            case IBSEARCH:       // TAB1_Retrieve / TAB3_Sheet1_Retrieve (TAB1, TAB3 둘다 조회 - TAB1에서 호출)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                // Sheet 전체 초기화
                for (var i=0; i<sheetObjects.length; i++){
                    sheetObjects[i].RemoveAll();
                }
                frmObj.f_cmd.value = SEARCH;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0011GS.do", FormQueryString(frmObj));
                shtObj.LoadSearchXml(xmlStr);
                sheetObjects[8].LoadSearchXml(xmlStr);
                ComOpenWait(false);
                break;

            case IBINSERT:    // TAB1_Row Add
                // 신규 행추가는 한 row만 가능
                if (shtObj.RowCount("I") > 0) return;
                if (!ComChkValid(frmObj)) return;
                frmObj.f_cmd.value = SEARCH02;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0011GS.do", FormQueryString(frmObj));
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                var newRowIdx = shtObj.DataInsert(-1);
                shtObj.CellValue2(newRowIdx, "agn_agmt_no") = ComGetEtcData(xmlStr, "new_agmt_no");
                shtObj.CellValue2(newRowIdx, "usr_id") = ComGetEtcData(xmlStr, "usr_id");    // 로그인한 사용자 ID
                shtObj.CellValue2(newRowIdx, "delt_flg") = "N";
                shtObj.CellEditable(newRowIdx, "delt_flg") = false;
                shtObj.CellValue2(newRowIdx, "agn_cd") = frmObj.agn_cd.value;
                shtObj.CellValue(newRowIdx, "chk") = "1";    // 이 부분만 CellValue2로 하지 말것
                break;

            case IBSAVE:    // TAB1_Save
                if (shtObj.GetSaveString() == "") return;    // sheet mandatory check 용도
                ComOpenWait(true);
                shtObj.DoSave("ESM_ACM_0011GS.do", "f_cmd=" + MULTI);
                ComOpenWait(false);
                break;

            case SEARCH11:    // TAB2_Sheet2_Retrieve / TAB3_Sheet2_Retrieve
                ComOpenWait(true);
                shtObj.DoSearch("ESM_ACM_0011GS.do", "f_cmd=" + SEARCH11 + "&" + CondParam);    // [주의]DoSearch4Fx를 사용할 경우 Combo의 CellValue가 셋팅되지 않음
                ComOpenWait(false);
                break;

            case MULTI01:    // TAB2_Save
                if (shtObj.GetSaveString() == "") return;    // sheet mandatory check 용도
                if (frmObj.rate_div[1].checked) {
                    if (sheetObjects[3].CellValue(1, "comm_pay_term_cd") == "") {
                        ComShowCodeMessage("COM130201", "Pay Term");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "comm_pay_term_cd", true);
                        return;
                    } else if (sheetObjects[3].CellValue(1, "rev_div_cd") == "") {
                        ComShowCodeMessage("COM130201", "Base");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "rev_div_cd", true);
                        return;
                    }
                } else {
                    if (sheetObjects[3].CellValue(1, "oft_pay_term_cd") == "") {
                        ComShowCodeMessage("COM130201", "OFT Term");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "oft_pay_term_cd", true);
                        return;
                    } else if (sheetObjects[3].CellValue(1, "full_mty_cd") == "") {
                        ComShowCodeMessage("COM130201", "Full/MT");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "full_mty_cd", true);
                        return;
                    } else if (sheetObjects[3].CellValue(1, "curr_cd") == "") {
                        ComShowCodeMessage("COM130201", "Curr");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "curr_cd");
                        return;
                    }
                }
                ComOpenWait(true);
                shtObj.DoSave("ESM_ACM_0011GS.do", "f_cmd=" + MULTI01);
                ComOpenWait(false);
                break;

            case SEARCH03:    // TAB3_Sheet1_Retrieve (TAB3에서만 조회 - TAB3에서 호출)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                sheetObjects[9].RemoveAll();    // tab2sheet2 Clear
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0011GS.do", FormQueryString(frmObj));    // [주의]DoSearch4Fx를 사용할 경우 Combo의 CellValue가 셋팅되지 않음
                ComOpenWait(false);
                break;
        }
    }


    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * (***** 기본 Event (중요) *****)
     */
    function tab1_OnChange(tabObj, nItem) {
        var objs = document.all.item("tabLayer");
        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
        beforetab = nItem;
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function tab1sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 RHQ Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
     }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function tab1sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount > 0) {
                ReDraw = false;
                for (var i=HeaderRows; i<=LastRow; i++) {
                    // delt_flag가 Y일때 컬럼 편집 비활성화
                    if (CellValue(i, "delt_flg") == "Y") {
                        CellEditable(i, "agmt_fm_dt_cd") = false;
                        CellEditable(i, "agmt_fm_dt") = false;
                        CellEditable(i, "agmt_to_dt_cd") = false;
                        CellEditable(i, "agmt_to_dt") = false;
                        CellEditable(i, "agn_agmt_rmk") = false;
                    }
                }
                ReDraw = true;
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab1sheet1_OnChange(shtObj, Row, Col, Value) {
        if (Value == "") return;
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "chk":
                    t1s1chkRowIdx = Row;    // 전역변수에 setting
                    // TAB2의 sheet초기화
                    for (var i=1; i<8; i++) {
                        sheetObjects[i].RemoveAll();
                    }
                    if (RowStatus(Row) == "I" || RowStatus(Row) == "D") {
                        // Detail (Compensation) 탭 비활성화
                        if (tabObjects[0].TabEnable(1)) {
                            tabObjects[0].TabEnable(1) = false;
                            return;
                        }
                    } else {
                        ACMRadioChkAction(shtObj, Row);    // CoAcm.js에 정의
                        // check된 한 row만 SeachXml로 parsing하여 TAB2의 Sheet1에 Load (반드시 컬럼명이 같아야 함)
                        var xmlStr = ComMakeSearchXml(shtObj, false, Col, IBS_ConcatSaveName(shtObj));
                        sheetObjects[1].LoadSearchXml(xmlStr);
                        // Tab2_Sheet2용 전역변수 초기화
                        t2s2chkRowIdx = -1;
                        // check된 한 row의 Data를 param으로 TAB2의 Sheet2 내용 조회
                        doActionIBSheet(sheetObjects[2], document.form, SEARCH11, RowSaveStr(Row));
                    }
                    break;

                case "delt_flg":
                    if (Value == "Y") {
                        CellEditable(Row, "agmt_fm_dt_cd") = false;
                        CellEditable(Row, "agmt_fm_dt") = false;
                        CellEditable(Row, "agmt_to_dt_cd") = false;
                        CellEditable(Row, "agmt_to_dt") = false;
                        CellEditable(Row, "agn_agmt_rmk") = false;
                    } else {
                        CellEditable(Row, "agmt_fm_dt_cd") = true;
                        CellEditable(Row, "agmt_fm_dt") = true;
                        CellEditable(Row, "agmt_to_dt_cd") = true;
                        CellEditable(Row, "agmt_to_dt") = true;
                        CellEditable(Row, "agn_agmt_rmk") = true;
                    }
                    break;
            }
        }
    }


    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function tab1sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function tab2sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount > 0) {
                if (!tabObjects[0].TabEnable(1)) {
                    //조회 완료 후 데이터 0건 이상 인경우 Detail (Compensation) 탭 활성화
                    tabObjects[0].TabEnable(1) = true;
                }
            }
        }
    }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function tab2sheet2_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount < 1) {
                shtObj.RemoveAll();
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet2_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "chk":
                    if (RowStatus(Row) == "D") {
                        for (var i=3; i<8; i++) {
                            sheetObjects[i].RemoveAll();
                        }
                    }
                    break;
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet2_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "chk":
                    t2s2chkRowIdx = Row;    // 전역변수에 setting
                    // check된 한 row만 SeachXml로 parsing하여 나머지 Sheet에 일괄 Load (반드시 컬럼명이 같아야 함에 주의)
                    var xmlStr = ComMakeSearchXml(shtObj, false, Col, IBS_ConcatSaveName(shtObj));
                    for (var i=3; i<8; i++) {
                        sheetObjects[i].RemoveAll();
                        sheetObjects[i].LoadSearchXml(xmlStr);
                    }

                    if (sheetObjects[3].CellValue(1, "oft_pay_term_cd") == "") sheetObjects[3].CellValue(1, "oft_pay_term_cd") = "T";
                    if (sheetObjects[3].CellValue(1, "comm_pay_term_cd") == "") sheetObjects[3].CellValue(1, "comm_pay_term_cd") = "T";
                    if (CellValue(Row, "rate_div") == "R") {
                        ACMCellEditable(sheetObjects[3], "oft_pay_term_cd", "comm_fx_amt", false);    // CoAcm.js에 정의
                        ACMCellEditable(sheetObjects[3], "comm_pay_term_cd", "comm_rt", true);    // CoAcm.js에 정의
                        document.form.rate_div[1].checked = true;
                    } else {
                        ACMCellEditable(sheetObjects[3], "oft_pay_term_cd", "comm_fx_amt", true);    // CoAcm.js에 정의
                        ACMCellEditable(sheetObjects[3], "comm_pay_term_cd", "comm_rt", false);    // CoAcm.js에 정의
                        document.form.rate_div[0].checked = true;
                    }
                    break;

                case "ac_tp_cd":
                    if (Value == "C") {
                        sheetObjects[4].CellValue2(1, "ofc_set_tp_cd") = "A";
                        sheetObjects[4].CellEditable(1, "ofc_set_tp_cd") = false;
                        sheetObjects[4].CellValue2(1, "ofc_cvrg_cd") = "BO";
                        sheetObjects[4].CellEditable(1, "ofc_cvrg_cd") = false;
                    } else {
                        sheetObjects[4].CellEditable(1, "ofc_set_tp_cd") = true;
                        sheetObjects[4].CellEditable(1, "ofc_cvrg_cd") = true;
                    }
                    break;
            }
        }
    }


    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function tab2sheet2_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        var agmtDtlPk = shtObj.CellValue(t2s2chkRowIdx, "agmt_dtl_pk");
        // Tab2_Sheet2용 전역변수 초기화
        t2s2chkRowIdx = -1;
        // TAB2의 내용을 조회하기 위해 TAB1 Sheet1의 OnChange이벤트를 발생
        tab1sheet1_OnChange(sheetObjects[0], t1s1chkRowIdx, sheetObjects[0].SaveNameCol("chk"), "1");
        // 저장 후 체크되어 있었던 row data 다시 체크
        if (agmtDtlPk != "") {
            var findRowIdx = shtObj.FindText("agmt_dtl_pk", agmtDtlPk);
            if (findRowIdx > -1) {
                shtObj.CellValue(findRowIdx, "chk") = "1";
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet3_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "cntr_tpsz_cd":
                    var tmpEditable = CellEditable(Row, Col);
                    // MemoPad를 open시 비활성화로 열어야 하므로 CellEditable이 활성화면 임시로 비활성화
                    if (tmpEditable) CellEditable(Row, Col) = false;
                    ComShowMemoPad(shtObj, Row, Col, true);
                    // MemoPad가 닫힌 후에는 [비활성화/활성화]였던 원래상태 유지
                    if (tmpEditable) CellEditable(Row, Col) = true;
                    break;
            }
        }
    }


    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab2sheet3_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "cntr_tpsz_cd":
                    var param = "?cntr_tpsz_cd=" + shtObj.CellValue(Row, Col);
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0102.do" + param, 742, 550, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 3);
                    break;

                case "curr_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_N13.do", 500, 420, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 3);
                    break;
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet3_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "curr_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH14 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
                    break;
            }
        }
        // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
        sheetObjects[2].CellValue(t2s2chkRowIdx, shtObj.ColSaveName(Col)) = Value;
    }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function tab2sheet4_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount > 0) {
                if (CellValue(1, "ofc_set_tp_cd") == "B" || CellValue(1, "ofc_set_tp_cd") == "C") {
                    CellEditable(1, "ofc_cvrg_cd") = false;
                } else {
                    CellEditable(1, "ofc_cvrg_cd") = true;
                }
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet4_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "ofc_set_tp_cd":
                    if (Value == "B" || Value == "C") {
                        CellValue(Row, "ofc_cvrg_cd") = "";
                        CellEditable(Row, "ofc_cvrg_cd") = false;
                    } else {
                        CellEditable(Row, "ofc_cvrg_cd") = true;
                    }
                    break;

                case "ofc_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH13 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
                    break;
            }
        }
        // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
        sheetObjects[2].CellValue(t2s2chkRowIdx, shtObj.ColSaveName(Col)) = Value;
    }


    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab2sheet4_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "ofc_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_071.do", 700, 445, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 4);
                    break;
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet5_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "por":
                case "pol":
                case "pod":
                case "del":
                    CellEditable(Row, Col) = false;
                    ComShowMemoPad(shtObj, Row, Col, true);
                    CellEditable(Row, Col) = true;
                    break;
            }
        }
    }


    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab2sheet5_OnPopupClick(shtObj, Row, Col) {
        with (sheetObjects[2]) {
            var param = "?agnCd=" + document.form.agn_cd.value +
                        "&agnAgmtNo=" + CellValue(t2s2chkRowIdx, "agn_agmt_no") +
                        "&ioBndCd=" + CellValue(t2s2chkRowIdx, "io_bnd_cd") +
                        "&acTpCd=" + CellValue(t2s2chkRowIdx, "ac_tp_cd") +
                        "&agnAgmtSeq=" + CellValue(t2s2chkRowIdx, "agn_agmt_seq");
        }
        switch (shtObj.ColSaveName(Col)) {
            case "por":
                param += "&routRefDivCd=POR";
                break;
            case "pol":
                param += "&routRefDivCd=POL";
                break;
            case "pod":
                param += "&routRefDivCd=POD";
                break;
            case "del":
                param += "&routRefDivCd=DEL";
                break;
        }
        // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
        ComOpenPopup("ESM_ACM_0113.do" + param, 970, 455, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 5);
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet5_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "por":
                case "pol":
                case "pod":
                case "del":
                    if (Value == "") {
                        CellValue(Row, ColSaveName(Col) + "_1") = "";
                        CellValue(Row, ColSaveName(Col) + "_2") = "";
                        CellValue(Row, ColSaveName(Col) + "_3") = "";
                        CellValue(Row, ColSaveName(Col) + "_4") = "";
                        CellValue(Row, ColSaveName(Col) + "_lvl_cd") = "";
                    }
                    break;
            }
            // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
            sheetObjects[2].CellValue(t2s2chkRowIdx, ColSaveName(Col)) = Value;
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet6_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "rep_chg_cd":
                case "chg_cd":
                    CellEditable(Row, Col) = false;
                    ComShowMemoPad(shtObj, Row, Col, true);
                    CellEditable(Row, Col) = true;
                    break;
            }
        }
    }


    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab2sheet6_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "rep_chg_cd":
                case "chg_cd":
                    var param = "?rep_chg_cd=" + shtObj.CellValue(Row, "rep_chg_cd") + "&chg_cd=" + shtObj.CellValue(Row, "chg_cd");
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0103.do" + param, 742, 550, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 6);
                    break;
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet6_OnChange(shtObj, Row, Col, Value) {
        // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
        sheetObjects[2].CellValue(t2s2chkRowIdx, shtObj.ColSaveName(Col)) = Value;
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet7_OnChange(shtObj, Row, Col, Value) {
        // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
        sheetObjects[2].CellValue(t2s2chkRowIdx, shtObj.ColSaveName(Col)) = Value;
    }


    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
                switch (ColSaveName(Col)) {
                    case "cntr_tpsz_cd":
                        CellValue(Row, Col) = aryPopupData[0];
                        break;

                    case "por":
                    case "pol":
                    case "pod":
                    case "del":
                        CellValue(Row, ColSaveName(Col) + "_1") = aryPopupData[1];
                        CellValue(Row, ColSaveName(Col) + "_2") = aryPopupData[2];
                        CellValue(Row, ColSaveName(Col) + "_3") = aryPopupData[3];
                        CellValue(Row, ColSaveName(Col) + "_4") = aryPopupData[4];
                        CellValue(Row, ColSaveName(Col) + "_lvl_cd") = aryPopupData[0];
                        CellValue(Row, Col) = aryPopupData[aryPopupData[0]];
                        break;

                    case "rep_chg_cd":
                    case "chg_cd":
                        CellValue(Row, "rep_chg_cd") = aryPopupData[0];
                        CellValue(Row, "chg_cd") = aryPopupData[1];
                        break;

                    default:
                        CellValue(Row, Col) = aryPopupData[0][3];
                        break;
                }
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab3sheet1_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "chk":
                    // check된 한 row의 Data를 param으로 TAB3의 Sheet2 내용 조회
                    doActionIBSheet(sheetObjects[9], document.form, SEARCH11, RowSaveStr(Row));
                    break;
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab3sheet2_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "cntr_tpsz_cd":
                case "rep_chg_cd":
                case "chg_cd":
                    ComShowMemoPad(shtObj, Row, Col, true);
                    break;
            }
        }
    }


    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj = sheetObjects[0];
        with (document.form) {
            switch (elementName) {

                case "rhq_cd_disp":    // RHQ를 변경시 Office목록을 setting
                    if (rhq_cd_disp.value == "") {
                        ComClearCombo(ar_ofc_cd);
                        ComClearCombo(agn_cd);
                        return;
                    }
                    rhq_cd.value = rhq_cd_disp.value;
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH18 + "&value0=" + rhq_cd.value + "&value1=" + ofcKndCd );
                    if (ACMXml2SelectItem(xmlStr, ar_ofc_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (ar_ofc_cd.options.length > 1) {
                            // rhq_cd와 같은 값이 선택되게 함
                            ar_ofc_cd.value = rhq_cd.value;
                        }
                        ar_ofc_cd.fireEvent("onchange");    // form.ar_ofc_cd 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                    }
                    break;

                case "ar_ofc_cd":    // Office를 변경시 Sub Office목록을 setting
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


/* 개발자 작업 끝 */
