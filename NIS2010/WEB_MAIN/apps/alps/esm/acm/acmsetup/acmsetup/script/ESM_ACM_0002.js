/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0002.js
*@FileTitle : Container TP/SZ Grouping
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.16 김상수
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
     * @class ESM_ACM_0002 : ESM_ACM_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0002() {
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
                case "btn_save":         // Save
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;

                case "btn_delete":       // Row Delete
                    // RowStatus만 Delete로
                    var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
                    if (chkRowArr.length > 1) {
                        shtObj.RowStatus(chkRowArr[0]) = "D";
                    }
                    break;

                case "btn_add":           // Row Add
                    // 신규 행추가는 한 row만 가능
                    if (shtObj.RowCount("I") > 0) return;
                    // 신규 행추가와 동시에 CHK에 체크
                    shtObj.CellValue2(shtObj.DataInsert(), "chk") = 1;
                    // Container TP/SZ Code uncheck all
                    sheetObjects[1].CheckAll("chk") = 0;

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

        with (shtObj) {

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

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            WaitImageVisible = false;

            CountPosition = 0;


            switch (shtNo) {
                case 1:    // User Set List
                    var cnt = 0;
                    // 높이 설정
                    style.height = 130;

                    // 전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|CHK|Group Name|Detail|org_tpsz_grp_nm";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus,       40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtRadioCheck,   40,     daCenter,    false,    "chk");
                    InitDataProperty(0, cnt++, dtData,         120,    daCenter,    false,    "cntr_tpsz_grp_nm",     true,     "",    dfNone,    0,    true,      true,    20);
                    InitDataProperty(0, cnt++, dtData,         500,    daLeft,      false,    "cntr_tpsz_cd",         false,    "",    dfNone,    0,    false,     false);
                    // Hidden
                    InitDataProperty(0, cnt++, dtHidden,       120,    daLeft,      false,    "org_cntr_tpsz_grp_nm");

                    // 입력제한
                    InitDataValid(0, "cntr_tpsz_grp_nm", vtEngUpOther, "1234567890 ");    // 영대문자+숫자+스페이스만

                    break;


                case 2:    // Container TP/SZ Code Selection
                    var cnt = 0;
                    // 높이 설정
                    style.height = 135;

                    // 전체 너비 설정
                    SheetWidth = mainTable2.clientWidth;

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|CHK|Code|Description";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtCheckBox,     40,     daCenter,    false,    "chk");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "cntr_tpsz_cd",   false,    "",    dfNone,    0,    false);
                    InitDataProperty(0, cnt++, dtData,         200,    daLeft,      false,    "cntr_tpsz_desc", false,    "",    dfNone,    0,    false);

                    break;
            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:       // 조회
                ComOpenWait(true);
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0002GS.do", "f_cmd=" + SEARCH).split("|$$|");
                // User Set List
                sheetObjects[0].LoadSearchXml(xmlStr[0]);
                // Container TP/SZ Code
                sheetObjects[1].LoadSearchXml(xmlStr[1]);
                ComOpenWait(false);
                break;

            case IBSAVE:         // 저장
                if (shtObj.RowCount < 1) {
                    ComShowCodeMessage("COM130201", "[User Set List]");    // Please input {?msg1}.
                    return;
                } else if (shtObj.CheckedRows("chk") < 1) {
                    ComShowCodeMessage("COM12113", "[User Set List]");    // Please select {?msg1}
                    return;
                } else if (shtObj.GetSaveString() == "") {    // sheet mandatory check 용도
                    return;
                } else if (sheetObjects[1].CheckedRows("chk") < 1) {
                    ComShowCodeMessage("COM12113", "[Container TP/SZ Code]");    // Please select {?msg1}
                    return;
                }

                ComOpenWait(true);
                var sParam0 = ComSetPrifix(shtObj.GetSaveString(false, false, "chk"), "UsrSet_");
                var sParam1 = ComSetPrifix(sheetObjects[1].GetSaveString(false, false, "chk"), "TpszCd_");
                shtObj.LoadSaveXml(shtObj.GetSaveXml("ESM_ACM_0002GS.do", "f_cmd=" + MULTI + "&" + sParam0 + "&" + sParam1));
                ComOpenWait(false);
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         doActionIBSheet(shtObj, document.form, IBSEARCH);
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

                case "chk":
                    if (RowStatus(Row) == "I" || RowStatus(Row) == "D") return;
                    ACMRadioChkAction(shtObj, Row);    // CoAcm.js에 정의

                    // Container TP/SZ Code 선택(sheet2_OnChang와는 반대 기능임)
                    var cntrTpszCd = CellValue(Row, "cntr_tpsz_cd");
                    if (cntrTpszCd == null || cntrTpszCd == undefined) cntrTpszCd = "";
                    var tmpArr = cntrTpszCd.split(",");
                    var shtObj2 = sheetObjects[1];
                    shtObj2.ReDraw = false;
                    shtObj2.CheckAll("chk") = 0;
                    for (var i=0; i<tmpArr.length; i++) {
                        var findRowIdx = shtObj2.FindText("cntr_tpsz_cd", tmpArr[i]);
                        if (findRowIdx > -1) {
                            shtObj2.CellValue2(findRowIdx, "chk") = 1;
                        }
                    }
                    shtObj2.ReDraw = true;
                    document.form.slct_tpsz.value = CellValue(Row, "cntr_tpsz_cd");
                    break;

                case "cntr_tpsz_grp_nm":
                    if (ComTrim(Value) == CellSearchValue(Row, Col)) {
                        CellValue2(Row, Col) = ComTrim(Value);
                        return;
                    }
                    // Duplication check
                    var xmlStr = GetSearchXml("ESM_ACM_0002GS.do", "f_cmd=" + SEARCH01 + "&cntr_tpsz_grp_nm=" + ComTrim(Value));
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
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

        ComResetAll();
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet2_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

                case "chk":
                    var chkRowArr = shtObj.FindCheckedRow(Col).split("|");
                    var slctTpSz = document.form.slct_tpsz;
                    if (chkRowArr.length > 1) {
                        // 선택된 row의 Container TP/SZ Code를 textarea에 setting
                        var tempArray = new Array();
                        for (var i=0; i<chkRowArr.length-1; i++) {
                            tempArray[tempArray.length] = shtObj.CellValue(chkRowArr[i], "cntr_tpsz_cd");
                        }
                        slctTpSz.value = tempArray.toString();
                    } else {
                        slctTpSz.value = "";
                    }
                    break;
            }
        }
    }


/* 개발자 작업 끝 */
