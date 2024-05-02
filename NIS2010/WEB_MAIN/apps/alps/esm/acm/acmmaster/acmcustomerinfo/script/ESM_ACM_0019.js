/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0019.js
*@FileTitle : FF-Vendor Match for FF Compensation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.03 김상수
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
     * @class ESM_ACM_0019 : ESM_ACM_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0019() {
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
        var shtObj = sheetObjects[0];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {

                case "btn_retrieve":     // Retrieve
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_save":         // Save
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;

                case "btn_downexcel":    // Down Excel
                    ComOpenWait(true);
                    shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "chk|ibflag");
                    ComOpenWait(false);
                    break;

                case "btn_add":           // Row Add
                    shtObj.DataInsert();
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

        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var cnt = 0;

        with (shtObj) {

            // 높이 설정
            style.height = 375;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
            InitRowInfo(1, 1, 13, 500);
            document.form.pagerows.value = 500;

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, false, false, true, false, false);

            // 컬럼 헤더타이틀
            var HeadTitle  = "DEL|STS|SEQ|F/Forwarder Code|F/Forwarder Name|Vendor Code|Vendor Name" +
                             // Hidden Header
                             "|vndr_cnt_cd|ff_cnt_cd|org_ff_seq|org_vndr_cnt_cd|org_vndr_seq";


            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtDelCheck,   40,     daCenter,    false,    "chk");
            InitDataProperty(0, cnt++, dtStatus,     40,     daCenter,    false,    "ibflag");    // [필수]
            InitDataProperty(0, cnt++, dtDataSeq,    30,     daCenter,    false,    "seq");

            InitDataProperty(0, cnt++, dtPopupEdit,  120,    daCenter,    false,    "ff_cnt_seq",      true,     "",    dfNone,    0,    true,     true,    8,    true);
            InitDataProperty(0, cnt++, dtData,       300,    daLeft,      false,    "cust_lgl_eng_nm", false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtPopupEdit,  120,    daCenter,    false,    "vndr_seq",        true,     "",    dfNone,    0,    true,     true,    6);
            InitDataProperty(0, cnt++, dtData,       300,    daLeft,      false,    "vndr_lgl_eng_nm", false,    "",    dfNone,    0,    false,    false);

            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "vndr_cnt_cd");
            // UPDATE를 위한 PK
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "ff_cnt_cd");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "org_ff_seq");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "org_vndr_cnt_cd");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "org_vndr_seq");

            // 입력제한
            InitDataValid(0, "ff_cnt_seq", vtEngUpOther, "1234567890");    // 영대문자+숫자만
            InitDataValid(0, "vndr_seq", vtNumericOnly);    // 숫자만

            ColIndent("cust_lgl_eng_nm") = 2;
            ColIndent("vndr_lgl_eng_nm") = 2;

            ShowButtonImage = 3;
            WaitImageVisible = false;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0019GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSAVE:         // 저장
                if (shtObj.GetSaveString() == "") return;    // sheet mandatory check 용도
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0019GS.do", FormQueryString(frmObj));
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

                case "ff_cnt_seq":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_041.do", 775, 445, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;

                case "vndr_seq":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_0C1.do", 700, 423, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;
            }
        }
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
                if (ColSaveName(Col) == "ff_cnt_seq") {
                    CellValue(Row, Col) = aryPopupData[0][3];
                } else if (ColSaveName(Col) == "vndr_seq") {
                    CellValue(Row, Col) = aryPopupData[0][2];
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
    function sheet1_OnChange(shtObj, Row, Col, Value) {
        if (Value == "") return;
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "ff_cnt_seq":
                    if (Value == CellSearchValue(Row, Col)) return;
                    // Duplication check
                    var xmlStr0 = shtObj.GetSearchXml("ESM_ACM_0019GS.do", "f_cmd=" + SEARCH01 + "&ff_cnt_seq=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr0)) {
                        SelectCell(Row, Col, true, "");
                        return;
                    }
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        Cellvalue2(Row, "cust_lgl_eng_nm") = "";
                        SelectCell(Row, Col, true, "");
                        return;
                    }
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        Cellvalue2(Row, "cust_lgl_eng_nm") = "";
                        SelectCell(Row, Col, true, "");
                    } else {
                        var custCntCd = ComGetEtcData(xmlStr, "cust_cnt_cd");
                        // COSTOMER의 COUNTRY CODE가 form.ff_cnt_cd와 다를경우 Error
                        if (custCntCd != undefined && custCntCd != document.form.ff_cnt_cd.value) {
                            ComShowCodeMessage("ACM00003", "Country Code of Customer Code [" + Value + "]", "Customer Code");
                            Cellvalue2(Row, "cust_lgl_eng_nm") = "";
                            SelectCell(Row, Col, true, "");
                        } else {
                            CellValue2(Row, "cust_lgl_eng_nm") = ComGetEtcData(xmlStr, "cust_lgl_eng_nm");
                        }
                    }
                    break;

                case "vndr_seq":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        Cellvalue2(Row, "vndr_lgl_eng_nm") = "";
                        SelectCell(Row, Col, true, "");
                    } else {
                        CellValue2(Row, "vndr_lgl_eng_nm") = ComGetEtcData(xmlStr, "vndr_lgl_eng_nm");
                        CellValue2(Row, "vndr_cnt_cd") = ComGetEtcData(xmlStr, "vndr_cnt_cd");
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
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


/* 개발자 작업 끝 */
