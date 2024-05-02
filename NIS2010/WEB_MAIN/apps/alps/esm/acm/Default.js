/* 개발자 작업 */


    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj = sheetObjects[0];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "btn_calendar":    // 캘린더 호출
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;

                case "btn_save":        // 저장
                    doActionIBSheet(shtObj, frmObj, IBSAVE);
                    break;

                case "btn_close":       // 닫기
                    window.close();
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
     * IBMultiCombo Object를 배열로 등록
     * param : cmbObj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(cmbObj) {
       comboObjects[comboCnt++] = cmbObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(var i=0; i<sheetObjects.length; i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var i=0;i<comboObjects.length;i++) {
            initCombo(comboObjects[i], comboObjects[i].id);
        }

        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }


    /**
     * 콤보 Text, Value셋팅
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다
     */
    function initCombo(comboObj, comboId) {
        var frmObj = document.form;

        with (comboObj) {
            UseCode = true;
            switch (comboId) {
                case "콤보명":
                    MultiSelect = true;
                    DropHeight = 160;
                    InsertItem("322", "322");
                    InsertItem("COD", "COD");
                    InsertItem("PRV", "PRV");
                    InsertItem("222", "222");
                    InsertItem("SPP", "SPP");
                    InsertItem("ALL (Excl SPP)", "ALL");
                    Code = frmObj.mvmtEdiMsgTpId.value;
                    break;

            }
        }
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var cnt = 0;

        with (shtObj) {
            switch (shtNo) {
                case 1:    // sheet[0] init

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
                    InitRowInfo(1, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, false, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|SEQ|Sel|Col.01|Col.02|Col.03|Col.04|Col.05|Col.06|Col.07|Col.08|Col.09|Col.10";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    false,    "Seq");
                    InitDataProperty(0, cnt++, dtCheckBox,     30,     daCenter,    false,    "Sel");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.01");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.02");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.03");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.04");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.05");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.061");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.07");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.08");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.09");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "Col.10");

                    CountPosition = 0;
                    WaitImageVisible = false;

                    break;
            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:    //조회
                if (!validateForm(shtObj, frmObj, sAction)) {
                    return;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0007GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSAVE:      //저장
                if (!validateForm(shtObj, frmObj, sAction)) {
                    return;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0007GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
     }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
        }
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
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnDblClick(shtObj, Row, Col) {
        with (shtObj) {
        }
    }


    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnChange(shtObj, Row, Col, Value) {
        if (Value == "") return;
        with (shtObj) {
        }
    }


    /**
     * IBSeet내의 저장함수를 호출하여 저장 처리 하기 전에 Validation Check를 할 수 있도록 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnValidation(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {

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
        with (shtObj) {
            if (ErrMsg != "") return;
            ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
            // 저장 후 재조회
            doActionIBSheet(shtObj, document.form, IBSEARCH);
        }
    }


    /**
     * (멀티콤보명)의 OnChange 이벤트 처리
     */
    function 멀티콤보명_OnChange(comboObj, Index_Code, Text) {
        with (comboObj) {
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(shtObj, frmObj, sAction) {
        with (frmObj) {
            switch (sAction) {

                case IBSEARCH:    // btn_retrieve
                    if (!ComChkValid(frmObj)) return;
                    // 기타 validation 로직
                    break;
            }
        }
        return true;
    }


/* 개발자 작업 끝 */
