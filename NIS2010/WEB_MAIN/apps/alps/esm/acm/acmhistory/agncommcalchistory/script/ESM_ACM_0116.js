/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0116.js
*@FileTitle : Calculation Detail from History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.10 김상수
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
     * @class ESM_ACM_0116 : ESM_ACM_0116 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0116() {
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
        var vvd_shtObj = sheetObjects[0];
        var bl_shtObj = sheetObjects[1];
        var shtObj = sheetObjects[2];
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "btn_close":
                    window.close();
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

        // box1sheet1_OnLoadFinish 메서드 반드시 참조
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

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            // Combo 항목이 없는 경우 조회한 글자 그대로 표시하기
            InitComboNoMatchText(true);

            ShowButtonImage = 3;
            CountPosition = 0;

            // 선택된 행의 하이라이트
            SelectHighLight = false;

            switch (shtId) {

                case "box1sheet1":    // Booking Revenue
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(7);

                    // 전체 너비 설정
                    SheetWidth = mainTableB1S1.clientWidth;    // 200px (세로 스크롤바 18px포함)

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|CHG|Amount|Cur|USD AMT";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "chg_cd");
                    InitDataProperty(0, cnt++, dtData,         132,    daRight,     false,    "chg_amt",        false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtData,         130,    daRight,     false,    "usd_chg_amt",    false,    "",    dfFloat,    2);

                    ColIndent("chg_amt") = 2;
                    ColIndent("usd_chg_amt") = 2;

                    break;

                case "box1sheet2":    // Booking Q’ty
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(3);

                    // 전체 너비 설정
                    SheetWidth = mainTableB1S2.clientWidth;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|TP/SZ|Q'ty";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "cntr_tpsz_cd");
                    InitDataProperty(0, cnt++, dtData,         100,    daRight,     false,    "op_cntr_qty",    false,    "",    dfFloat,    2);

                    ColIndent("op_cntr_qty") = 2;

                    break;

                case "box1sheet3":    // Booking Route
                    var cnt = 0;
                    // 높이 설정
                    style.height =  GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTableB1S3.clientWidth;    // 200px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|POR|POL|Pre|Post|POD|DEL|R/D";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         58,     daCenter,    false,    "por_cd");
                    InitDataProperty(0, cnt++, dtData,         58,     daCenter,    false,    "pol_cd");
                    InitDataProperty(0, cnt++, dtData,         58,     daCenter,    false,    "pre_port_cd");
                    InitDataProperty(0, cnt++, dtData,         58,     daCenter,    false,    "pst_port_cd");
                    InitDataProperty(0, cnt++, dtData,         58,     daCenter,    false,    "pod_cd");
                    InitDataProperty(0, cnt++, dtData,         58,     daCenter,    false,    "del_cd");
                    InitDataProperty(0, cnt++, dtData,         52,     daCenter,    false,    "rcv_de_term_cd");

                    break;

                //---------------------------------------------------------------------------------------------------------
                case "box2sheet1":    // Charge Deduction
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(5);

                    // 전체 너비 설정
                    SheetWidth = mainTableB2S1.clientWidth;    // 200px (세로 스크롤바 18px포함)
                    SheetWidth = 200;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|CHG|Amount|Cur|USD AMT";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "chg_cd");
                    InitDataProperty(0, cnt++, dtData,         132,    daRight,     false,    "chg_ddct_pay_amt",    false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtData,         130,    daRight,     false,    "chg_ddct_amt",        false,    "",    dfFloat,    2);

                    ColIndent("chg_ddct_pay_amt") = 2;
                    ColIndent("chg_ddct_amt") = 2;

                    break;

                case "box2sheet2":    // Transportation Cost Deduction
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(5);

                    // 전체 너비 설정
//                    SheetWidth = mainTableB2S1.clientWidth;    // 200px
                    SheetWidth = 200;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|Item|From|To|USD AMT";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         100,    daLeft,      false,    "stnd_cost_nm");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "nod_cd");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "to_nod_cd");
                    InitDataProperty(0, cnt++, dtData,         100,    daRight,     false,    "usd_uc_amt",    false,    "",    dfFloat,    2);

                    ColIndent("usd_uc_amt") = 2;

                    break;

                //---------------------------------------------------------------------------------------------------------
                case "box3sheet1":    // General Commission
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTableB3S1.clientWidth;    // 829px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|Net Revenue|Net Revenue|Rate(%)|Q'ty|Fixed Amount|General AMT(LCL)|General AMT(USD)";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         100,    daRight,     false,    "crnt_rev_amt",       false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         44,     daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "comm_rt");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "cntr_tpsz_qty");
                    InitDataProperty(0, cnt++, dtData,         168,    daCenter,    false,    "comm_fx_amt");
                    InitDataProperty(0, cnt++, dtData,         168,    daRight,     false,    "pay_if_amt",    false,    "",    dfFloat,    2);
                    InitDataProperty(0, cnt++, dtData,         168,    daRight,     false,    "if_amt",        false,    "",    dfFloat,    2);

                    ColIndent("net_rev") = 2;
                    ColIndent("pay_if_amt") = 2;
                    ColIndent("if_amt") = 2;

                    break;

                case "box3sheet2":    // Container Handling Fee (CHF)
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTableB3S2.clientWidth;    // 829px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|Q'ty|Rate(USD)|CHF AMT(USD)";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         270,    daCenter,    false,    "cntr_tpsz_qty");
                    InitDataProperty(0, cnt++, dtData,         270,    daCenter,    false,    "comm_fx_amt");
                    InitDataProperty(0, cnt++, dtData,         270,    daCenter,    false,    "if_amt",          false,    "",    dfFloat,    2);

                    ColIndent("if_amt") = 2;

                    break;

                case "box3sheet3":    // T/S Commission
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTableB3S2.clientWidth;    // 829px

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|Q'ty|Rate(USD)|T/S AMT(USD)";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         270,    daCenter,    false,    "cntr_tpsz_qty");
                    InitDataProperty(0, cnt++, dtData,         270,    daCenter,    false,    "comm_fx_amt");
                    InitDataProperty(0, cnt++, dtData,         270,    daCenter,    false,    "if_amt",          false,    "",    dfFloat,    2);

                    ColIndent("if_amt") = 2;

                    break;
            }

            WaitImageVisible = false;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:       // 조회
                frmObj.f_cmd.value = SEARCH;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0116GS.do", FormQueryString(frmObj)).split("|$$|");
                for (var i=0; i<xmlStr.length; i++) {
                    sheetObjects[i].LoadSearchXml(xmlStr[i]);
                }
                frmObj.non_ddc_rev.value = ComAddComma2(frmObj.non_ddc_rev.value==""?"0":frmObj.non_ddc_rev.value, "#,###.00"); //Non Deducted Rev.
                frmObj.ttl_chr_ddc.value = ComAddComma2(frmObj.ttl_chr_ddc.value==""?"0":frmObj.ttl_chr_ddc.value, "#,###.00"); //Total Charge Deduction
                frmObj.ttl_trs_ddc.value = ComAddComma2(frmObj.ttl_trs_ddc.value==""?"0":frmObj.ttl_trs_ddc.value, "#,###.00"); //Total Transportation Deduction
                frmObj.net_rev.value = ComAddComma2(frmObj.net_rev.value==""?"0":frmObj.net_rev.value, "#,###.00"); //Net Revenue
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function box1sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Office Select Object 생성
         doActionIBSheet(shtObj, document.form, IBSEARCH);
     }


     /**
      * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {ErrMsg} String : 조회 후 메시지
      */
     function box3sheet3_OnSearchEnd(shtObj, ErrMsg) {
    	 if (ErrMsg != "") return;
         var frmObj = document.form;
         var ttlQty = sheetObjects[1].ComputeSum("|2|"); //Total Q'ty
         frmObj.ttl_qty.value = ComAddComma2(ttlQty+'', "#,###.00");
     }

/* 개발자 작업 끝 */
