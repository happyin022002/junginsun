/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0035.js
*@FileTitle : Agent Commission Agreement Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.13 김영오
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.09.24 김봉균 [CHM-201220407] Charge deduction의 메모창 추가 
* 2013.05.21 이윤정 [CHM-201324691] Agreement Inquiry에 고유 seq 보여주기 (agn_agmt_seq 추가)
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
     * @class ESM_ACM_0035 : ESM_ACM_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0035() {
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
        var t3shtObj2 = sheetObjects[0];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "tab3btn_retrieve":    // TAB3_Retrieve
                    doActionIBSheet(t3shtObj2, frmObj, SEARCH03);
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
                    var HeadTitle0  = "STS|Bound|AGMT\nSeq.|Account|Fixed Base|Fixed Base|Fixed Base|Fixed Base|Rate Base|Rate Base|Rate Base|Deduction|Deduction|Deduction|Deduction|Deduction|Deduction|Route Setting|Route Setting|Route Setting|Route Setting|Office Setting|Office Setting|Office Setting|||||||||||||||||||||||";
                    var HeadTitle1  = "STS|Bound|AGMT\nSeq.|Account|TP/SZ|Full/MT|Curr|Fixed Amount|Pay Term|Base|Rate|R. CHG|CHG|O. Haulage|D. Haulage|O. Feederage|D. Feederage|POR|POL|POD|DEL|Type|Covered Location|Office|||||||||||||||||||||||";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtCombo,        50,     daCenter,    true,     "io_bnd_cd",          false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    true,     "agn_agmt_seq",       false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        140,    daCenter,    true,     "ac_tp_cd",           false,    "",    dfNone,    0,    false,    false);

                    InitDataProperty(0, cnt++, dtData,         80,     daLeft,      true,     "cntr_tpsz_cd",       false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "full_mty_cd",        false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "curr_cd",            false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         100,    daRight,     false,    "comm_fx_amt",        false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "comm_pay_term_cd",   false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "rev_div_cd",         false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "comm_rt",            false,    "",    dfNone,    0,    false,    false);

                    InitDataProperty(0, cnt++, dtData,         80,     daLeft,      false,    "rep_chg_cd",         false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         100,    daLeft,      false,    "chg_cd",             false,    "",    dfNone,    0,    false,    false);

                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "hlg_ddct_org_flg",   false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "hlg_ddct_dest_flg",  false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "fdrg_ddct_org_flg",  false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "fdrg_ddct_dest_flg", false,    "",    dfNone,    0,    false,    false);

                    InitDataProperty(0, cnt++, dtPopup,        80,     daCenter,    false,    "por");
                    InitDataProperty(0, cnt++, dtPopup,        80,     daCenter,    false,    "pol");
                    InitDataProperty(0, cnt++, dtPopup,        80,     daCenter,    false,    "pod");
                    InitDataProperty(0, cnt++, dtPopup,        80,     daCenter,    false,    "del");

                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "ofc_set_tp_cd",      false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtCombo,        110,    daCenter,    false,    "ofc_cvrg_cd",        false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "ofc_cd",         	false,    "",    dfNone,    0,    false,    false);
                    
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "agn_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "agn_agmt_no");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "agn_agmt_seq");
                    
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "por_lvl_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pol_lvl_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "pod_lvl_cd");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_1");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_2");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_3");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_4");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "del_lvl_cd");

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "io_bnd_cd", ioBndText, ioBndCode);
                    InitDataCombo(0, "ac_tp_cd", acTpText, acTpCode);
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
                    
                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
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

            case SEARCH11:    // TAB2_Sheet2_Retrieve / TAB3_Sheet2_Retrieve
                ComOpenWait(true);
                sheetObjects[1].DoSearch("ESM_ACM_0001GS.do", "f_cmd=" + SEARCH11 + "&" + CondParam);    // [주의]DoSearch4Fx를 사용할 경우 Combo의 CellValue가 셋팅되지 않음
                ComOpenWait(false);
                break;

            case SEARCH03:    // TAB3_Sheet1_Retrieve (TAB3에서만 조회 - TAB3에서 호출)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                // Sheet 전체 초기화
                for (var i=0; i<sheetObjects.length; i++){
                    sheetObjects[i].RemoveAll();
                }
                frmObj.f_cmd.value = SEARCH;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0001GS.do", FormQueryString(frmObj));
                shtObj.LoadSearchXml(xmlStr);
                ComOpenWait(false);
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function tab3sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 RHQ Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
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
     * IBSheet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab3sheet2_OnPopupClick(shtObj, Row, Col) {
        with (sheetObjects[1]) {
            var param = "?agnCd=" + CellValue(Row, "agn_cd") +
                        "&agnAgmtNo=" + CellValue(Row, "agn_agmt_no") +
                        "&ioBndCd=" + CellValue(Row, "io_bnd_cd") +
                        "&acTpCd=" + CellValue(Row, "ac_tp_cd") +
                        "&agnAgmtSeq=" + CellValue(Row, "agn_agmt_seq");
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
        ComOpenPopup("ESM_ACM_0113.do" + param, 970, 455, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 1);
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

                }
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
