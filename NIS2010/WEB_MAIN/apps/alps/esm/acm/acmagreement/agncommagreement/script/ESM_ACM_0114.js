/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0114.js
*@FileTitle : Agreement Information
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.15
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.06.15 김봉균
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @extends
     * @class ESM_ACM_0114 : ESM_ACM_0114 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0114() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.doActionIBSheet    = doActionIBSheet;
    }

/* 개발자 작업 */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var srcName = window.event.srcElement.getAttribute("name");

        switch (srcName) {

            case "btn_close":           // close
                window.close();
                break;
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

        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
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
            InitHeadMode(true, true, false, true, false, false);

            // Combo 항목이 없는 경우 조회한 글자 그대로 표시하기
            InitComboNoMatchText(true);

            ShowButtonImage = 3;
//            WaitImageVisible = false;
            CountPosition = 0;

            switch (shtId) {
                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(16);

                    // 전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(2, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|Bound|Account|Fixed Base|Fixed Base|Fixed Base|Fixed Base|Rate Base|Rate Base|Rate Base|Deduction|Deduction|Deduction|Deduction|Deduction|Deduction|Route Setting|Route Setting|Route Setting|Route Setting|Office Setting|Office Setting|Office Setting";
                    var HeadTitle1  = "STS|Bound|Account|TP/SZ|Full/MT|Curr|Fixed Amount|Pay Term|Base|Rate|R. CHG|CHG|O. Haulage|D. Haulage|O. Feederage|D. Feederage|POR|POL|POD|DEL|Type|Covered Location|Office";

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

                    InitDataProperty(0, cnt++, dtData,         80,     daLeft,      true,     "cntr_tpsz_cd");
                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "full_mty_cd");
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtData,         100,    daRight,     false,    "comm_fx_amt",       false,    "",    dfFloat,    2);
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
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "del");

                    InitDataProperty(0, cnt++, dtCombo,        80,     daCenter,    false,    "ofc_set_tp_cd");
                    InitDataProperty(0, cnt++, dtCombo,        110,    daCenter,    false,    "ofc_cvrg_cd");
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "ofc_cd");

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

                    break;
            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0114GS.do", FormQueryString(frmObj));
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 RHQ Select Object 생성
         doActionIBSheet(shtObj, document.form, IBSEARCH);
     }


     /**
      * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {Row} Long : 해당 셀의 Row Index
      * @param {Col} Long : 해당 셀의 Column Index
      * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
      */
     function sheet1_OnClick(shtObj, Row, Col, Value) {
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

/* 개발자 작업 끝 */
