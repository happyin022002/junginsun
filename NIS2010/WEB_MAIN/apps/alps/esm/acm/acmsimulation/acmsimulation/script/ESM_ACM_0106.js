/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0106.js
*@FileTitle : Agreement Search
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.09 김상수
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
     * @class ESM_ACM_0106 : ESM_ACM_0106 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0106() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
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

                case "btn_inquiry":
                    break;

                case "btn_select":
                    break;

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

        // sheet1_OnLoadFinish 메서드 반드시 참조
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
    	var shtId = shtObj.id;

        with (shtObj) {    // 2개 Sheet의 내용이 동일

            var cnt = 0;
            // 높이 설정
            style.height = GetSheetHeight(7);

            // 전체 너비 설정
            SheetWidth = mainTableS1.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;
            document.form.pagerows.value = 500;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
            InitRowInfo(2, 1, 13, 500);

            // 컬럼 헤더타이틀
            var HeadTitle0  = "STS|CHK|Agreement No.|Effective Date|Effective Date|Effective Date|Effective Date|Del|Update Date";
            var HeadTitle1  = "STS|CHK|Agreement No.|From|From|To|To|Del|Update Date";

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle0, true);
            InitHeadRow(1, HeadTitle1, true);

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, true, false, true, false, false);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    true,     "ibflag");    // [필수]
            InitDataProperty(0, cnt++, dtRadioCheck,   35,     daCenter,    true,     "chk");
            InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,     "agn_agmt_no",   false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtCombo,        100,    daCenter,    false,    "agmt_fm_dt_cd", false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,    "agmt_fm_dt",    false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtCombo,        100,    daCenter,    false,    "agmt_to_dt_cd", false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,    "agmt_to_dt",    false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         35,     daCenter,    true,     "delt_flg",      false,    "",    dfNone,    0,    false,    false);
            InitDataProperty(0, cnt++, dtData,         75,     daCenter,    true,     "upd_dt",        false,    "",    dfNone,    0,    false,    false);

            // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
            InitDataCombo(0, "agmt_fm_dt_cd", effDivText, effDivCode);
            InitDataCombo(0, "agmt_to_dt_cd", effDivText, effDivCode);
            // Combo 항목이 없는 경우 조회한 글자 그대로 표시하기
            InitComboNoMatchText(true);

            ShowButtonImage = 3;
            WaitImageVisible = false;
            CountPosition = 0;

            // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
            EditableColorDiff = false;

            // 선택된 행의 하이라이트
            SelectHighLight = false;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0106GS.do", FormQueryString(frmObj)).split("|$$|");
                for (var i=0; i<xmlStr.length; i++) {
                    sheetObjects[i].LoadSearchXml(xmlStr[i]);
                }
                ComOpenWait(false);
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Office Select Object 생성
         doActionIBSheet(shtObj, document.form, IBSEARCH);
     }


    /**
     * IBSeet내의 셀의 값을 편집하기 직전에 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnMouseDown(shtObj, Row, Col) {
        if (shtObj.ColSaveName(shtObj.MouseCol) == "chk") {
            with (shtObj) {
                EditableColorDiff = false;
                Editable = true;
            }
            with (sheetObjects[1]) {
                ReDraw = false;
                var chkRowIdx = FindCheckedRow("chk").split("|")[0];
                if (chkRowIdx != "") {
                    ReturnData(chkRowIdx);
                }
                Editable = false;
                EditableColorDiff = true;
                for (var i=HeaderRows; i<=LastRow; i++) {
                    RowBackColor(i) = UnEditableColor;
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
    function sheet2_OnMouseDown(shtObj, Row, Col) {
        if (shtObj.ColSaveName(shtObj.MouseCol) == "chk") {
            with (shtObj) {
                EditableColorDiff = false;
                Editable = true;
            }
            with (sheetObjects[0]) {
                ReDraw = false;
                var chkRowIdx = FindCheckedRow("chk").split("|")[0];
                if (chkRowIdx != "") {
                    ReturnData(chkRowIdx);
                }
                Editable = false;
                EditableColorDiff = true;
                for (var i=HeaderRows; i<=LastRow; i++) {
                    RowBackColor(i) = UnEditableColor;
                }
                ReDraw = true;
            }
        }
    }


/* 개발자 작업 끝 */
