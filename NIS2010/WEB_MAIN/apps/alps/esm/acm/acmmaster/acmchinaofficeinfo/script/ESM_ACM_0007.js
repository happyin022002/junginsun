/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0007.js
*@FileTitle : O/B Booking Office Info for China
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
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
     * @class ESM_ACM_0007 : ESM_ACM_0007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0007() {
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
                    doActionIBSheet(shtObj, frmObj, IBDOWNEXCEL);
                    break;

                case "btn_add":           // Row Add
                    doActionIBSheet(shtObj, frmObj, IBINSERT);
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
            var HeadTitle  = "STS|SEQ|Agent|Agent Name|A/R Office|Vendor Code|Vendor Name|DEL" +
                             // Hidden Header
                             "|vndr_delt_flg|bkg_blck_flg|vndr_cnt_cd|ofc_cd|diff_rmk|cust_cnt_cd|cust_seq|auto_dp_chk_flg|agn_eml|ar_ofc_cd|dir_pay_ofc_cd";

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtStatus,     40,     daCenter,    false,    "ibflag");    // [필수]
            InitDataProperty(0, cnt++, dtDataSeq,    30,     daCenter,    false,    "seq");
            InitDataProperty(0, cnt++, dtData,       60,     daCenter,    false,    "chn_agn_cd",      true,     "",    dfNone,    0,    false,    true,    2,    true);
            InitDataProperty(0, cnt++, dtData,       300,    daLeft,      false,    "agn_nm",          true);
            InitDataProperty(0, cnt++, dtData,       80,     daCenter,    false,    "finc_ofc_cd",     true,     "",    dfNone,    0,    false,    true,    5,    true);
            InitDataProperty(0, cnt++, dtData,       100,    daCenter,    false,    "vndr_seq",        true,     "",    dfNone,    0,    true,     true,    6);
            InitDataProperty(0, cnt++, dtData,       300,    daLeft,      false,    "vndr_lgl_eng_nm", false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtCombo,      30,     daCenter,    false,    "delt_flg");

            InitDataProperty(0, cnt++, dtHidden,      80,     daCenter,    false,    "vndr_delt_flg");

            // 아래는 BKG UPDATE메서드에 전달하기 위해 필요한 Hidden value
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "bkg_blck_flg");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "vndr_cnt_cd");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "ofc_cd");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "diff_rmk");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "cust_cnt_cd");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "cust_seq");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "auto_dp_chk_flg");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "agn_eml");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "ar_ofc_cd");
            InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "dir_pay_ofc_cd");

            // 입력제한
            InitDataValid(0, "chn_agn_cd", vtEngUpOnly);    // 영대문자만
            InitDataValid(0, "agn_nm",  vtEngUpOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?");    // 영대문자+숫자+특수키만 입력되도록 설정
            InitDataValid(0, "finc_ofc_cd", vtEngUpOnly);   // 영대문자만
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
                ACMXml2SelectItem(xmlStr, frmObj.finc_ofc_cd, "value0", "value0", true);
                ComOpenWait(false);
                break;

            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0007GS.do", FormQueryString(frmObj));    // [주의]DoSearch4Fx를 사용할 경우 Combo의 CellValue가 셋팅되지 않음
                ComOpenWait(false);
                break;

            case IBSAVE:         // 저장
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0007GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:    // 엑셀다운로드
                ComOpenWait(true);
                shtObj.SpeedDown2Excel(-1);
                ComOpenWait(false);
                break;

            case IBINSERT:       // 신규 행추가
                var newRowIdx = shtObj.DataInsert();
                // 조회 조건의 A/R Office를 finc_ofc_cd에 setting
                shtObj.CellValue2(newRowIdx, "finc_ofc_cd") = frmObj.finc_ofc_cd.value;
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
                    // MDM_VENDOR테이블에서 가져온 delt_flag가 Y면 agn_nm 컬럼 편집 비활성화, vendor 컬럼폰트 빨간색에 취소선
                    if (CellValue(i, "vndr_delt_flg") == "Y") {
                        CellFont("FontColor", i, "vndr_seq") = RgbColor(200, 0, 0);
                        CellFont("FontColor", i, "vndr_lgl_eng_nm") = RgbColor(200, 0, 0);
                        CellFont("FontStrikethru", i, "vndr_seq") = true;
                        CellFont("FontStrikethru", i, "vndr_lgl_eng_nm") = true;
                    }
                    // delt_flag가 Y면 agn_nm, vndr_seq 컬럼 편집 비활성화
                    if (CellValue(i, "delt_flg") == "Y") {
                        CellEditable(i, "agn_nm") = false;
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

                case "chn_agn_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH02 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
                    break;

                case "finc_ofc_cd":
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
                        var vndrCntCd = ComGetEtcData(xmlStr, "vndr_cnt_cd");
                        // VENDOR의 COUNTRY CODE가 CN이 아닐경우 Error
                        if (vndrCntCd != undefined && vndrCntCd != "CN") {
                            ComShowCodeMessage("ACM00003", "Country Code of Vendor Code [" + Value + "]", "Vendor Code");
                            Cellvalue2(Row, "vndr_lgl_eng_nm") = "";
                            SelectCell(Row, Col, true, "");
                        } else {
                            // 빨간색에 취소선 일 수 있는 Cell속성을 Default로 (OnBeforeEdit 보완)
                            CellFont("FontColor", Row, Col) = DataFontColor;
                            CellFont("FontColor", Row, "vndr_lgl_eng_nm") = DataFontColor;
                            CellFont("FontStrikethru", Row, Col) = false;
                            CellFont("FontStrikethru", Row, "vndr_lgl_eng_nm") = false;

                            CellValue2(Row, "vndr_lgl_eng_nm") = ComGetEtcData(xmlStr, "vndr_lgl_eng_nm");
                            CellValue2(Row, "vndr_cnt_cd") = ComGetEtcData(xmlStr, "vndr_cnt_cd");
                            CellValue2(Row, "ofc_cd") = ComGetEtcData(xmlStr, "ofc_cd");
                        }
                    }
                    break;

                case "delt_flg":
                    if (Value == "Y") {
                        CellEditable(Row, "agn_nm") = false;
                        CellEditable(Row, "vndr_seq") = false;
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
        var fincOfcCd = frmObj.finc_ofc_cd.value;
        doActionIBSheet(shtObj, frmObj, SEARCH01);
        frmObj.finc_ofc_cd.value = fincOfcCd;
        doActionIBSheet(shtObj, frmObj, IBSEARCH);
    }


/* 개발자 작업 끝 */
