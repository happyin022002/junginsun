/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0456.js
*@FileTitle : Pre-booked VL/VD Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.09.09 김상수
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
     * @class EES_CTM_0456 : EES_CTM_0456 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0456() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.doActionIBSheet = doActionIBSheet;
        this.validateForm = validateForm;
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var frmObj = document.form;
        var sheetObj  = sheetObjects[0];

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btn_Calendar":
                    var cal = new ComCalendarFromTo();
                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                    break;

                case "btn_Delete":
                    // (공통함수 ComRowHideDelete는 checkbox를 해제하므로 현재 화면에서는 정상처리되지 않음)
                    with(sheetObj) {
                        // "|" 구분자로 연결하여 체크된 행번 가져오기, 결과:"3|4|5|"
                        var chkRows = FindCheckedRow("Sel");
                        var arr = chkRows.split("|");
                        if (arr.length > 1) {
//                            ComOpenWait(true);
                            Redraw = false;
                            for (i=0; i<arr.length-1; i++) {
                                RowHidden(arr[i]) = true;    // 선택row를 숨김
                                RowStatus(arr[i]) = "D";     // 삭제를 위해 선택row의 Status를 D로 변경
                            }
                            Redraw = true;
//                            ComOpenWait(false);
                        }
                    }
                    break;

                case "btn_Retrieve":
                    if (!checkFormField()) return;
                    doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                    break;

                case "btn_New":
                    ComResetAll();
                    frmObj.p_yard2.RemoveAll();
                    break;

                case "btn_Save":
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    doActionIBSheet(sheetObj, frmObj, IBSAVE);    // 저장
                    ComOpenWait(false);
                    sheetObj.WaitImageVisible = true;
                    break;

            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
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
    function setSheetObject(sheetObj){
       sheetObjects[sheetCnt++] = sheetObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        // CTM-COMMON (& 예외처리)
        setEventProcess("yd_cd_disp");

        // OnKeyPress 이벤트 (공통function)
        axon_event.addListener("keypress", "obj_keypress", "yd_cd_disp");
        // OnKeyUp 이벤트 (자체function _on)
        axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");

        // 페이지 로딩시 focus
        document.form.p_date1.focus();
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        with (sheetObj) {

            // 높이 설정
            style.height = 442;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, 100);

            var headTitle = "|Seq.||Container No.|T/S|STS|Origin YD|Event Date|VVD|Booking No.|Booking No.|B/L No.|F/M|Pre-booked Date|Office|User Name|Remark(s)|";
            var headCount = ComCountHeadTitle(headTitle);

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(headCount, 4, 0, true);

            // 헤더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, headTitle, true);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // 자동 트림하여 조회및 저장
            DataAutoTrim = true;

            // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 0,      daCenter,    false,    "ibflag");
            InitDataProperty(0, cnt++, dtSeq,          30,     daCenter,    false,    "Seq");
            InitDataProperty(0, cnt++, dtDummyCheck,   30,     daCenter,    false,    "Sel",         false,    "",    dfNone,        0,    true,    true);
            InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "cntr_no",     false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         35,     daCenter,    false,    "ts",          false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         35,     daCenter,    false,    "status",      false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "org_yard",    false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "event_dt",    true,     "",    dfUserFormat2, 0,    true,     true);
            InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "vvd",         false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         25,     daCenter,    false,    "bkg_knt",     false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "bkg_no",      false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "bl_no",       false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "fm",          false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         110,    daCenter,    false,    "prebkg_dt",   false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "office",      false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "user_nm",     false,    "",    dfNone,        0,    false,    true);
            InitDataProperty(0, cnt++, dtData,         300,    daLeft,      false,    "remark",      false,    "",    dfNone,        0,    true,     true,    30);
            InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    false,    "org_event_dt");

            InitUserFormat2(0, "event_dt", "####-##-## ##:##", "-|:" );

            CountPosition = 0;
            SelectHighLight = false;
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:    // 조회
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    if (frmObj.error.checked) {
                        frmObj.error_status.value = frmObj.error.value;
                    } else {
                        frmObj.error_status.value = "";
                    }
                    frmObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch4Fx("EES_CTM_0456GS.do", FormQueryString(frmObj));
                }
                break;

            case IBSAVE:        //저장
                if(validateForm(sheetObj, frmObj, sAction)) {
                    frmObj.f_cmd.value = MULTI;
                    sheetObj.DoSave("EES_CTM_0456GS.do", FormQueryString(frmObj), "Sel");
                }
                break;

        }
    }


    /**
     * HTML Object의 OnKeyUp이벤트 처리
     */
    function obj_onkeyup(event) {
        srcValue = event.srcElement.value;    // CoCtm.js의 공통스크립트의 자동실행 방지용
        var frmObj = document.form;
        var sheetObj = sheetObjects[0];
        switch(event.srcElement.name) {
            case "yd_cd_disp":
            // yd_cd_disp에 입력되는 값의 length에 따른 처리
                var ydCdDisp = frmObj.yd_cd_disp;
                if (ydCdDisp.value.length > 0) {
                    frmObj.p_yard1.value = ydCdDisp.value.toUpperCase();
                    if (ydCdDisp.value.length > 4) {
                        // p_yard1에 5글자가 채워지면 CTM공통함수의 yard_search() 호출
                        if (!yard_search()) {
                              ydCdDisp.select();
                              ydCdDisp.focus();
                        } else {
                              frmObj.p_yard2.focus();
                        }
                    } else {
                        frmObj.p_yard2.RemoveAll();
                    }
                } else {
                    frmObj.p_yard1.value = "";
                    frmObj.p_yard2.RemoveAll();
                }
                break;
        }
        onShowErrMsg = false;
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        sheetObj.WaitImageVisible = true;
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        if (sheetObj.ColSaveName(Col) != "Sel") {
            // row클릭시 해당 Check Box도 체크
            with(sheetObj) {
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
//                    ComOpenWait(true);
                    for (i=0; i<arr.length; i++) {
                        if (CellEditable(arr[i], "Sel")) {
                            CellValue2(arr[i], "Sel") = "1";    // 선택된 행의 CheckBox 체크
                        }
                    }
//                    ComOpenWait(false);
                }
            }
        }
    }


    /**
     * Sheet의 OnChange 이벤트 처리
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var frmObj = document.form;
        with (sheetObj) {
            var cellval = CellValue(Row, Col).trim();
            switch(ColSaveName(Col)) {
                case "event_dt":
                    // org_event_dt값과 다르다면(수정되었다면)
                    if (cellval != CellValue(Row, "org_event_dt")) {
                        // 날짜포맷에 맞는지 check
                        var tmpDatetime = cellval.substring(0, 8) + " " + cellval.substring(8, 12);
                        if (!ComIsDateTime(tmpDatetime, "", "hm")) {
                            ComShowCodeMessage("CTM00001");
                            CellValue2(Row, Col) = CellValue(Row, "org_event_dt");
                            CellValue2(Row, "Sel") = "";
                            SelectCell(Row, Col);
                            return;
                        }
                    }
                    break;
            }

            // 변경된 행의 CheckBox 체크
            if (ColSaveName(Col) != "Sel") {
                CellValue2(Row, "Sel") = "1";
            }
        }
    }


    /**
     * 저장 함수를 이용하여 저장이 완료되면 다시 조회 <br>
     * @param {ibsheet} Event       IBSheet 저장 후 발생하는 Event
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            ComShowCodeMessage("CTM10022", "Pre-booked VL/VD Correction");
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction){
        with(frmObj){
            /* Date format이 validation이 실패한 경우 경우 return false로 service 호출을 막음 */
            if (sAction == IBSEARCH) {
             if (cancelDate == false) return false;
            }
        }
        return true;
    }


/* 개발자 작업 끝 */
