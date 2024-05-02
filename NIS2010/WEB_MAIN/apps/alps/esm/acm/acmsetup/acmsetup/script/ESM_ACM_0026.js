/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0026.js
*@FileTitle : Revenue Structure Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2012.03.20 이정수
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
     * @class ESM_ACM_0026 : ESM_ACM_0026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0026() {
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
                    ComOpenWait(true);
                    shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "ibflag|chk");
                    ComOpenWait(false);
                    break;

                case "btn_add":           // Row Add
                    doActionIBSheet(shtObj, frmObj, IBINSERT);
                    break;

                case "btn_delete":       // Row Delete
                    doActionIBSheet(shtObj, frmObj, IBDELETE);
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
            InitRowInfo(2, 1, 13, 500);
            document.form.pagerows.value = 500;

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, false, false, true, false, false);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            WaitImageVisible = false;

            CountPosition = 0;


            switch (shtNo) {
                case 1:    // sheet[0] init
                    var cnt = 0;
                    // 높이 설정
                    style.height = 350;

                    // 전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|CHK|Charge to Add to Revenue|RHQ|Scope|Effective Date|Effective Date|Effective Date|Effective Date|Prev STS|CHG_SEQ";
                    var HeadTitle1  = "STS|CHK|Charge to Add to Revenue|RHQ|Scope|From|From|To|To|Prev STS|CHG_SEQ";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 데이터속성        [ROW, COL,  DATATYPE,   WIDTH,    DATAALIGN,   COLMERGE,  SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus,     40,     daCenter,    true,     "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDummyCheck, 40,     daCenter,    true,     "chk");
                    InitDataProperty(0, cnt++, dtData,       180,    daCenter,    true,     "chg_cd",           true,     "",    dfNone,      0,    true,    true,    3);
                    InitDataProperty(0, cnt++, dtCombo,      120,    daCenter,    true,     "rhq_ofc_cd",       false,    "",    dfNone,      0,    true,    true,    6);
                    InitDataProperty(0, cnt++, dtCombo,      120,    daCenter,    true,     "scp_cd",           false,    "",    dfNone,      0,    true,    true,    3);
                    InitDataProperty(0, cnt++, dtCombo,      140,    daCenter,    false,    "rev_fm_dt_cd",     true);
                    InitDataProperty(0, cnt++, dtData,       75,     daCenter,    false,    "rev_fm_dt",        true,     "",    dfDateYmd);
                    InitDataProperty(0, cnt++, dtCombo,      140,    daCenter,    false,    "rev_to_dt_cd",     true);
                    InitDataProperty(0, cnt++, dtData,       75,     daCenter,    false,    "rev_to_dt",        true,     "",    dfDateYmd);

                    InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "pre_sts");
                    InitDataProperty(0, cnt++, dtHidden,     80,     daCenter,    false,    "rev_chg_seq");

                    // 입력제한
                    InitDataValid(0, "chg_cd", vtEngUpOnly);    // 영대문자만

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "rev_fm_dt_cd", " |" + effDivText, " |" + effDivCode, "");
                    InitDataCombo(0, "rev_to_dt_cd", " |" + effDivText, " |" + effDivCode, "");


                    ShowButtonImage = 3;
                    WaitImageVisible = false;
                    HeadRowHeight = 18;
                    break;


            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:       // RHQ 목록 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH07);
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                var comboStr = ComXml2ComboString(xmlStr, "value0", "value0");
                shtObj.InitDataCombo(0, "rhq_ofc_cd", " |" + comboStr[0], " |" + comboStr[1], "");

                break;

            case SEARCH02:       // Service Scope 목록 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH11 + "&value8=SCP");
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                var comboString = ComXml2ComboString(xmlStr, "value0", "value1");
                var codeStrTemp = comboString[0].split('|'); // Scope 코드
                var nameStrTemp = comboString[1].split('|'); // Scope 이름
                var fullStrTemp = '';  // 코드 + 이름
                for(var i=0; i<codeStrTemp.length; i++){
                    fullStrTemp = fullStrTemp + codeStrTemp[i] + '\t' + nameStrTemp[i] + '|' ;
                }
                shtObj.InitDataCombo(0, "scp_cd", "All|" + fullStrTemp, " |" + comboString[0], "All");
                break;

            case IBSEARCH:       // 조회
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0026GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSAVE:         // 저장
                if (shtObj.GetSaveString() == "") return;    // sheet mandatory check 용도
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0026GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBINSERT:       // 신규 행추가
                // 신규 행추가와 동시에 CHK에 체크
                //shtObj.CellValue2(shtObj.DataInsert(), "chk") = 1;
                var newRowIdx = shtObj.DataInsert(-1);
                break;

            case IBDELETE:       // 체크된 행삭제
                var checkedNum = shtObj.CheckedRows("chk");
                if(checkedNum > 0){
                    var chkRowNum = shtObj.FindCheckedRow(1);
                    var arrRow = chkRowNum.split("|");
                    for (var idx=0; idx<arrRow.length-1; idx++){
                        shtObj.CellValue(arrRow[idx],"pre_sts") = shtObj.RowStatus(arrRow[idx]);
                        shtObj.RowStatus(arrRow[idx]) = "D";
                    }
                }
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         doActionIBSheet(shtObj, document.form, SEARCH01);
         doActionIBSheet(shtObj, document.form, SEARCH02);
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

                case "chk":

                    if(Value == 1){
                        var PrevSts = shtObj.CellValue(Row,"pre_sts");
                        shtObj.RowStatus(Row) = PrevSts;
                    }
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

                case "chg_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH10 + "&value0=" + Value + "&value8=Charge Code");
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
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


/* 개발자 작업 끝 */
