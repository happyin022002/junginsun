/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0005.js
*@FileTitle : I/B China Agent Information for Lane / Port
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.13
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.06 김상수
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
     * @class ESM_ACM_0005 : ESM_ACM_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0005() {
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

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "btn_retrieve":     // Retrieve
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_save":         // Save
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;

                case "btn_downexcel":    // Down Excel
                    doActionIBSheet(shtObj, frmObj, IBDOWNEXCEL);
                    break;

                case "btn_add":           // Row Add
                    doActionIBSheet(shtObj, frmObj, IBINSERT);
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
            var HeadTitle  = "STS|SEQ|POD|Lane|Agent|A/R Office|Vendor Code|Vendor Name|DEL" +
                             // Hidden Header
                             "|vndr_delt_flg|org_pod_cd|org_slan_cd|org_agn_cd|org_vndr_seq";

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtStatus,       40,     daCenter,    false,    "ibflag");    // [필수]
            InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    false,    "seq");
            InitDataProperty(0, cnt++, dtPopupEdit,    100,    daCenter,    false,    "pod_cd",          true,     "",    dfNone,    0,    true,     true,    5,    true);
            InitDataProperty(0, cnt++, dtPopupEdit,    80,     daCenter,    false,    "slan_cd",         true,     "",    dfNone,    0,    true,     true,    3,    true);
            InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "agn_cd",          true,     "",    dfNone,    0,    true,     true,    5,    true);
            InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "agn_ar_ofc_cd",   true,     "",    dfNone,    0,    true,     true,    5,    true);
            InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "vndr_seq",        true,     "",    dfNone,    0,    true,     true,    6);
            InitDataProperty(0, cnt++, dtData,         380,    daLeft,      false,    "vndr_lgl_eng_nm", false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtCombo,        30,     daCenter,    false,    "delt_flg");

            InitDataProperty(0, cnt++, dtHidden,       80,     daCenter,    false,    "vndr_delt_flg");
            InitDataProperty(0, cnt++, dtHidden,       80,     daCenter,    false,    "org_pod_cd");    // UPDATE를 위한 PK
            InitDataProperty(0, cnt++, dtHidden,       80,     daCenter,    false,    "org_slan_cd");    // UPDATE를 위한 PK
            InitDataProperty(0, cnt++, dtHidden,       80,     daCenter,    false,    "org_agn_cd");    // DUP CHECK용
            InitDataProperty(0, cnt++, dtHidden,       80,     daCenter,    false,    "org_vndr_seq");    // DUP CHECK용

            // 입력제한
            InitDataValid(0, "pod_cd", vtEngUpOnly);    // 영대문자만
            InitDataValid(0, "slan_cd", vtEngUpOnly);    // 영대문자만
            InitDataValid(0, "agn_cd", vtEngUpOnly);    // 영대문자만
            InitDataValid(0, "agn_ar_ofc_cd", vtEngUpOnly);    // 영대문자만
            InitDataValid(0, "vndr_seq", vtNumericOnly);    // 숫자만

            // sheet내 combo설정
            InitDataCombo(0, "delt_flg", "Y|N", "Y|N", "N");

            ShowButtonImage = 3;
            WaitImageVisible = false;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:       // A/R Office 목록 조회
                ComOpenWait(true);
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH01);
                ACMXml2SelectItem(xmlStr, frmObj.agn_ar_ofc_cd, "value0", "value0", true);
                ComOpenWait(false);
                break;

            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0005GS.do", FormQueryString(frmObj));    // [주의]DoSearch4Fx를 사용할 경우 Combo의 CellValue가 셋팅되지 않음
                ComOpenWait(false);
                break;

            case IBSAVE:         // 저장
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0005GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:    // 엑셀다운로드
                ComOpenWait(true);
                shtObj.SpeedDown2Excel(-1);
                ComOpenWait(false);
                break;

            case IBINSERT:       // 신규 행추가
                var newRowIdx = shtObj.DataInsert();
                // 조회 조건의 A/R Office를 agn_ar_ofc_cd에 setting
                shtObj.CellValue2(newRowIdx, "agn_ar_ofc_cd") = frmObj.agn_ar_ofc_cd.value;
                // Lane에 초기값으로 "ALL" setting
                shtObj.CellValue2(newRowIdx, "slan_cd") = "ALL";
                shtObj.CellEditable(newRowIdx, "delt_flg") = false;
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 A/R Office Select Object 생성
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
                for (var i=HeaderRows; i<=LastRow; i++) {
                    // MDM_VENDOR테이블에서 가져온 delt_flag가 Y면 컬럼 편집 비활성화, vendor 컬럼폰트 빨간색에 취소선
                    if (CellValue(i, "vndr_delt_flg") == "Y") {
                        CellFont("FontColor", i, "vndr_seq") = RgbColor(200, 0, 0);
                        CellFont("FontColor", i, "vndr_lgl_eng_nm") = RgbColor(200, 0, 0);
                        CellFont("FontStrikethru", i, "vndr_seq") = true;
                        CellFont("FontStrikethru", i, "vndr_lgl_eng_nm") = true;
                    }
                    // delt_flag가 Y일때 컬럼 편집 비활성화
                    if (CellValue(i, "delt_flg") == "Y") {
                        CellEditable(i, "pod_cd") = false;
                        CellEditable(i, "slan_cd") = false;
                        CellEditable(i, "agn_cd") = false;
                        CellEditable(i, "agn_ar_ofc_cd") = false;
                        CellEditable(i, "vndr_seq") = false;
                    }
                }
                ReDraw = true;
            }
        }
    }


    /**
     * IBSeet내의 셀의 값을 편집하기 직전에 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnBeforeEdit(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "vndr_seq":
                    // Edit직전 빨간색에 취소선 일 수 있는 Cell속성을 Default로
                    CellFont("FontColor", Row, Col) = DataFontColor;
                    CellFont("FontColor", Row, "vndr_lgl_eng_nm") = DataFontColor;
                    CellFont("FontStrikethru", Row, Col) = false;
                    CellFont("FontStrikethru", Row, "vndr_lgl_eng_nm") = false;
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
    function sheet1_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "pod_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_051.do?cnt_cd=CN", 740, 425, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;

                case "slan_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_081.do", 770, 417, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
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
            sheetObjects[ShtIdx].CellValue2(Row, Col) = aryPopupData[0][3];
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

                case "pod_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH05 + "&value0=" + Value + "&value8=POD");
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
                    break;

                case "slan_cd":
                    // 업무상 "ALL"은 validation 하지 않음
                    if (Value == "ALL") return;
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH06 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
                    break;

                case "agn_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH02 + "&value0=" + Value.substring(3, 5) + "&value9=EXIST");
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        SelectCell(Row, Col, true, "");
                    } else {
                        CellValue2(Row, "agn_ar_ofc_cd") = ComGetEtcData(xmlStr, "finc_ofc_cd");
                    }
                    break;

                case "agn_ar_ofc_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value + "&value8=A/R Office");
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
                    break;

                case "vndr_seq":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        Cellvalue2(Row, "vndr_lgl_eng_nm") = "";
                        SelectCell(Row, Col, true, "");
                    } else {
                        // 빨간색에 취소선 일 수 있는 Cell속성을 Default로 (OnBeforeEdit 보완)
                        CellFont("FontColor", Row, Col) = DataFontColor;
                        CellFont("FontColor", Row, "vndr_lgl_eng_nm") = DataFontColor;
                        CellFont("FontStrikethru", Row, Col) = false;
                        CellFont("FontStrikethru", Row, "vndr_lgl_eng_nm") = false;

                        CellValue2(Row, "vndr_lgl_eng_nm") = ComGetEtcData(xmlStr, "vndr_lgl_eng_nm");
                    }
                    break;

                case "delt_flg":
                    if (Value == "Y") {
                        CellEditable(Row, "pod_cd") = false;
                        CellEditable(Row, "slan_cd") = false;
                        CellEditable(Row, "agn_cd") = false;
                        CellEditable(Row, "agn_ar_ofc_cd") = false;
                        CellEditable(Row, "vndr_seq") = false;
                    } else {
                        CellEditable(Row, "vndr_seq") = true;
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
        var frmObj = document.form;
        var agnArOfcCd = frmObj.agn_ar_ofc_cd.value;
        doActionIBSheet(shtObj, frmObj, SEARCH01);
        frmObj.agn_ar_ofc_cd.value = agnArOfcCd;
        doActionIBSheet(shtObj, frmObj, IBSEARCH);
    }


/* 개발자 작업 끝 */
