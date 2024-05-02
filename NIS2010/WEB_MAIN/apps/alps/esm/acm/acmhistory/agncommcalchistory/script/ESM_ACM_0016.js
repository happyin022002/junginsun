/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0016.js
*@FileTitle : Agent Commission Calculation History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.24 김상수
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.05.24 박다은 [CHM-201324690] Calculation History 에서  Calc_no 숨기기
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
     * @class ESM_ACM_0016 : ESM_ACM_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0016() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
        this.frmObj_OnChange    = frmObj_OnChange;
    }

/* 개발자 작업 */


    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj = sheetObjects[0];
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch (srcName) {

                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
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

                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 389;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(2, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|Event date|Event date\n(GMT)|Event Type|Office|Agreement\nNo.|Comm. VVD|BND|S/A Date|Calc.\nSeq|Type|STS|IF AMT|TTL|Q'ty|Rev.|" +
                                      "Deduction|Deduction|Deduction|" +
                                       // Hidden Column
                                      "bkg_no|ac_seq|calc_no";
                    var HeadTitle1  = "STS|Event date|Event date\n(GMT)|Event Type|Office|Agreement\nNo.|Comm. VVD|BND|S/A Date|Calc.\nSeq|Type|STS|IF AMT|TTL|Q'ty|Rev.|" +
                                      "CHG|Trans|S. Compen.|" +
                                       // Hidden Column
                                      "bkg_no|ac_seq|calc_no";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, false);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         76,    daCenter,    true,    "evt_dt",             false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         70,    daCenter,    true,    "evt_gmt_dt",         false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,    "evt_tp",             false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         50,    daCenter,    true,    "agn_cd",             false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,    "agn_agmt_no",        false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,    true,    "comm_vvd",           false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         36,    daCenter,    true,    "io_bnd_cd",          false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         70,    daCenter,    true,    "sail_arr_dt",        false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtPopup,        50,    daRight,     true,    "calc_seq",           false,    "",    dfNone,     0,    true,     true);
                    InitDataProperty(0, cnt++, dtData,         50,    daCenter,    true,    "ac_tp_cd",           false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         36,    daCenter,    true,    "ac_sts_cd",          false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         60,    daRight,     true,    "if_amt",             false,    "",    dfFloat,    2,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         60,    daRight,     true,    "crnt_amt",           false,    "",    dfFloat,    2,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         60,    daRight,     true,    "bkg_cnt",            false,    "",    dfFloat,    2,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,    daRight,     true,    "crnt_rev_amt",       false,    "",    dfFloat,    2,    false,    false);

                    InitDataProperty(0, cnt++, dtData,         80,    daRight,     true,    "ddct_chg_amt",       false,    "",    dfFloat,    2,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,    daRight,     true,    "ddct_trsp_amt",      false,    "",    dfFloat,    2,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,    daRight,     true,    "ddct_spcl_cmpn_amt", false,    "",    dfFloat,    2,    false,    false);

                    // Hidden Column (ESM_ACM_0105팝업 parameter용)
                    InitDataProperty(0, cnt++, dtHidden,       100,   daCenter,    true,    "bkg_no");
                    InitDataProperty(0, cnt++, dtHidden,       50,    daCenter,    true,    "ac_seq");
                    // [CHM-201324690] Calculation History 에서  Calc_no 숨기기
                    InitDataProperty(0, cnt++, dtHidden,       50,    daCenter,    true,    "calc_no");

                    ColIndent("calc_seq") = 2;
                    ColIndent("if_amt") = 2;
                    ColIndent("crnt_amt") = 2;
                    ColIndent("bkg_cnt") = 2;
                    ColIndent("crnt_rev_amt") = 2;
                    ColIndent("ddct_chg_amt") = 2;
                    ColIndent("ddct_trsp_amt") = 2;
                    ColIndent("ddct_spcl_cmpn_amt") = 2;

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    ShowButtonImage = 3;
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
        // 기본 OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:       // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0016GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
        }
    }


    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "calc_seq":
                	
                	if(CellValue(Row, "ac_tp_cd") == "CHF") {
                		if(CellValue(Row, "calc_seq") == CellValue(Row+1, "calc_seq")) {
                			if(CellValue(Row+1, "ac_tp_cd") == "General") {
                				Row++;
                			}
                		}
                	}
                	
                	var postRevAmt = (parseFloat(CellValue(Row, "crnt_rev_amt")) - parseFloat(CellValue(Row, "ddct_chg_amt")) - parseFloat(CellValue(Row, "ddct_trsp_amt")) - parseFloat(CellValue(Row, "ddct_spcl_cmpn_amt"))).toFixed(2);
                    var param = "?bkg_no=" + CellValue(Row, "bkg_no") + "&agn_cd=" + CellValue(Row, "agn_cd") + "&io_bnd_cd=" + CellValue(Row, "io_bnd_cd") + "&ac_seq=" + CellValue(Row, "ac_seq") + "&calc_no=" + CellValue(Row, "calc_no")
                              + "&crnt_rev_amt=" + CellValue(Row, "crnt_rev_amt") + "&ddct_chg_amt=" + CellValue(Row, "ddct_chg_amt") + "&ddct_trsp_amt=" + CellValue(Row, "ddct_trsp_amt") + "&post_rev_amt=" + postRevAmt;
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0116.do" + param, 886, 518, "", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;
            }
        }
    }


/* 개발자 작업 끝 */
