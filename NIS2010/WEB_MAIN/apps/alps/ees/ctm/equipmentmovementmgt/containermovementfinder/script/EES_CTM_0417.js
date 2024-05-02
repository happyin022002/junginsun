/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0417.js
*@FileTitle : EDI Error Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.28 김상수
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
     * @class EES_CTM_0417 : EES_CTM_0417 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0417() {
        this.processButtonClick = tprocessButtonClick;
        this.setsheetObj = setsheetObj;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initCombo = initCombo;
        this.doActionIBSheet = doActionIBSheet;
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var sourceRadioDisable = new Array();
var dataRadioDisable = new Array();


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var frmObj = document.form;
        var sheetObj1  = sheetObjects[0];   // sheet1
        var sheetObj2  = sheetObjects[1];   // sheet2

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_Calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                    }
                    break;

                case "btn_Retrieve":
                    if (!checkFormField()) return;
                    doActionIBSheet(sheetObj1, frmObj, IBSEARCH);
                    break;

                case "btn_New":
                    DomSetFormObjDisable(frmObj, false);
                    frmObj.rcc_cd.Enable = true;
                    frmObj.lcc_cd.Enable = true;
                    frmObj.p_yard2.Enable = true;
                    ComResetAll();
                    frmObj.p_yard2.RemoveAll();
                    // RCC_CD 기본셋팅
                    doActionIBSheet(sheetObj2, frmObj, SEARCH01);
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
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * IBMultiCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
       comboObjects[comboCnt++] = combo_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0; i<sheetObjects.length; i++){
        // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
        // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(i=0;i<comboObjects.length;i++){
            initCombo(comboObjects[i], comboObjects[i].id);
        }

        // CTM-COMMON (& 예외처리)
        setEventProcess("rcc_cd", "lcc_cd", "yd_cd_disp", "source_radio", "data_radio");
        // OnKeyPress 이벤트 (공통function)
        axon_event.addListener("keypress", "obj_keypress", "yd_cd_disp");
        // OnKeyUp 이벤트 (자체function _on)
        axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");

        // RCC_CD 기본셋팅
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);

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

            switch(sheetNo) {
                case 1:    //sheet1 init

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // 높이 설정
                    style.height = 382;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(20, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle0 = "Seq.|RCC|CN|LCC|LOC|Yard|Remained|Remained|Remained|Remained|Remained|Initial|Initial|Initial|Initial|Initial";
                    var HeadTitle1 = "Seq.|RCC|CN|LCC|LOC|Yard|Error|%|OK|%|Total|Error|%|OK|%|Total";

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW,  COL,  DATATYPE,  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtDataSeq,    30,    daCenter,    true,    "SEQ");
                    InitDataProperty(0, cnt++,    dtData,       60,    daCenter,    true,    "rcc",               false,    "",    dfNone);
                    InitDataProperty(0, cnt++,    dtData,       30,    daCenter,    true,    "cn",                false,    "",    dfNone);
                    InitDataProperty(0, cnt++,    dtData,       50,    daCenter,    true,    "lcc",               false,    "",    dfNone);
                    InitDataProperty(0, cnt++,    dtData,       50,    daCenter,    true,    "loc",               false,    "",    dfNone);
                    InitDataProperty(0, cnt++,    dtData,       70,    daCenter,    true,    "yard",              false,    "",    dfNone);
                    InitDataProperty(0, cnt++,    dtAutoSum,    80,    daRight,     true,    "corr_err",          false,    "",    dfNullInteger);
                    InitDataProperty(0, cnt++,    dtAutoSum,    50,    daRight,     true,    "corr_err_ratio",    false,    "",    dfNullFloat,      1);
                    InitDataProperty(0, cnt++,    dtAutoSum,    80,    daRight,     true,    "corr_ok",           false,    "",    dfNullInteger);
                    InitDataProperty(0, cnt++,    dtAutoSum,    50,    daRight,     true,    "corr_ok_ratio",     false,    "",    dfNullFloat,      1);
                    InitDataProperty(0, cnt++,    dtAutoSum,    80,    daRight,     true,    "corr_ttl",          false,    "",    dfNullInteger);
                    InitDataProperty(0, cnt++,    dtAutoSum,    80,    daRight,     true,    "init_err",          false,    "",    dfNullInteger);
                    InitDataProperty(0, cnt++,    dtAutoSum,    50,    daRight,     true,    "init_err_ratio",    false,    "",    dfNullFloat,      1);
                    InitDataProperty(0, cnt++,    dtAutoSum,    80,    daRight,     true,    "init_ok",           false,    "",    dfNullInteger);
                    InitDataProperty(0, cnt++,    dtAutoSum,    50,    daRight,     true,    "init_ok_ratio",     false,    "",    dfNullFloat,      1);
                    InitDataProperty(0, cnt++,    dtAutoSum,    70,    daRight,     true,    "init_ttl",          false,    "",    dfNullInteger);
                    InitDataProperty(0, cnt++,    dtHidden,     70,    daCenter,    true,    "divide");
                    InitDataProperty(0, cnt++,    dtHidden,     70,    daCenter,    true,    "source_radio");
                    InitDataProperty(0, cnt++,    dtHidden,     70,    daCenter,    true,    "p_date1");
                    InitDataProperty(0, cnt++,    dtHidden,     70,    daCenter,    true,    "p_date2");

                    CountPosition = 0;
                    RequestTimeOut = 20000;

                    break;


                case 2:    // 엑셀 다운로드용 hidden sheet

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // 높이 설정
                    //style.height = 100;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    var HeadTitle = "Container No.|Type/size|Status|I/O status|Event Yard|Event date|receiving date|Error MSG";

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE,  SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtData,    0,    daCenter,    false,    "cntr_no");
                    InitDataProperty(0, cnt++,    dtData,    0,    daCenter,    false,    "cntr_tpsz_cd");
                    InitDataProperty(0, cnt++,    dtData,    0,    daCenter,    false,    "edi_mvmt_sts_cd");
                    InitDataProperty(0, cnt++,    dtData,    0,    daCenter,    false,    "edi_gate_io_cd");
                    InitDataProperty(0, cnt++,    dtData,    0,    daCenter,    false,    "evnt_yd_cd");
                    InitDataProperty(0, cnt++,    dtData,    0,    daCenter,    false,    "evnt_dt");
                    InitDataProperty(0, cnt++,    dtData,    0,    daCenter,    false,    "cre_locl_dt");
                    InitDataProperty(0, cnt++,    dtData,    0,    daCenter,    false,    "mvmt_edi_rmk");

                    CountPosition = 0;
                    RequestTimeOut = 20000;

                    break;

            }
        }
    }


    /**
     * 콤보 Text, Value셋팅
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboId) {
        with (comboObj) {
            UseAutoComplete = true;
            ValidChar(2, 1);
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction, queryString) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:    // 조회
                if (validateForm(sheetObj, frmObj, sAction)) {
                    // p_date1과 p_date2가 3개월이 넘으면 return
                    if (ComGetUnMaskedValue(ComGetDateAdd(frmObj.p_date1.value, "M", 3), "ymd") < ComGetUnMaskedValue(frmObj.p_date2.value, "ymd")) {
                        ComShowCodeMessage("CTM30012", "3 months");
                        frmObj.p_date1.focus();
                        return;
                    }
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    sheetObj.RemoveAll();
                    ComBtnDisable("btn_Retrieve");
                    ComBtnDisable("btn_New");
                    for (var h=0; h<frmObj.source_radio.length; h++) {
                        sourceRadioDisable[h] = frmObj.source_radio[h].disabled;
                    }
                    for (var k=0; k<frmObj.data_radio.length; k++) {
                         dataRadioDisable[k] = frmObj.data_radio[k].disabled;
                    }
                    DomSetFormObjDisable(form, true);
                    frmObj.rcc_cd.Enable = false;
                    frmObj.lcc_cd.Enable = false;
                    frmObj.p_yard2.Enable = false;

                    frmObj.f_cmd.value = COMMAND01;
                    var sXml = sheetObj.GetSearchXml("EES_CTM_0417GS.do", FormQueryString(frmObj));
                    var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey")
                    if (backendJobKey.length > 0) {
                        frmObj.backendjob_key.value = backendJobKey;
                        sheetObj.RequestTimeOut = 20000;
                        timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
                    }
                }
                break;

            case SEARCH01:    // 조회 RCC_CD
                frmObj.f_cmd.value = SEARCH01;
                comboObj = frmObj.rcc_cd;
                var rtn = sheetObj.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(frmObj));
                if (rtn == "") return;
                rtn = ComGetEtcData(rtn, "rtn");
                var rtnList = rtn.split("^");
                comboObj.RemoveAll();
                idxSelect = "";
                for (var i=0; i<=rtnList.length; i++) {
                    if (rtnList[i]) {
                        rtnValue = rtnList[i].split("|");
                        comboObj.InsertItem(i, rtnValue[0], rtnValue[0]);
                        if (rtnValue[1] == "1") idxSelect = rtnValue[0];
                    }
                }
                comboObj.InsertItem(comboObj.GetCount(), "ALL", "");
                if (idxSelect == "") {
                    comboObj.Text = "ALL";
                } else {
                    comboObj.Text = idxSelect;
                }
                // LCC_CD 기본셋팅
                doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
                break;

            case SEARCH02:    // 조회 LCC_CD
                frmObj.f_cmd.value = SEARCH02;
                comboObj = frmObj.lcc_cd;
                var rtn = sheetObj.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(frmObj));
                if (rtn == "") return;
                rtn = ComGetEtcData(rtn, "rtn");
                var rtnList = rtn.split("^");
                comboObj.RemoveAll();
                comboObj.InsertItem(0, "", "");
                for (i=0; i<=rtnList.length; i++) {
                    if (rtnList[i]) {
                        rtnValue = rtnList[i].split("|");
                        comboObj.InsertItem(i+1, rtnValue[0], rtnValue[0]);
                    }
                }
                break;

            case COMMAND02:    //  엑셀다운로드
                var SaveFileName = sheetObj.SaveFileDialog("ExcelDown", "book1", "C:\\","엑셀파일(*.xls)|*.xls" );
                if (SaveFileName == "" || SaveFileName == "<USER_CANCEL>") {
                    return;
                } else {
                    ComOpenWait(true);
                    sheetObj.DoSearch4Fx("EES_CTM_0417GS.do", queryString + "&f_cmd=" + COMMAND02);
                    sheetObj.SpeedDown2Excel(-1, false, false, SaveFileName);
                    ComOpenWait(false);
                }
                break;
        }
    }


    /**
     * 해당 sheet의 col 모양을 지정값으로 변경
     */
    function colModify(sheetObj, colName) {
        with (sheetObj) {
            CellFont("FontBold", 2, colName, LastRow, colName) = true;
            ColFontColor(colName) = RgbColor(0, 0, 255);
            DataLinkMouse(colName) = true;
        }
    }


    /**
     * sheet1 Object의 OnSearchEnd이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        var frmObj = document.form;
        frmObj.rcc_cd.Enable = true;
        frmObj.lcc_cd.Enable = true;
        frmObj.p_yard2.Enable = true;
        DomSetFormObjDisable(frmObj, false);
        for (var h=0; h<frmObj.source_radio.length; h++) {
            frmObj.source_radio[h].disabled = sourceRadioDisable[h];
        }
        for (var k=0; k<frmObj.data_radio.length; k++) {
            frmObj.data_radio[k].disabled = dataRadioDisable[k];
        }

        if (ErrMsg == "") {
            with(sheetObj) {
                if (RowCount > 0) {
                    RowHidden(LastRow) = true;
                    frmObj.corr_err.value = ComAddComma(CellValue(LastRow, "corr_err"));
                    frmObj.corr_err_ratio.value = Math.round(CellValue(LastRow, "corr_err") / CellValue(LastRow, "init_ttl") * 1000) / 10 + " %";
                    frmObj.init_err.value = ComAddComma(CellValue(LastRow, "init_err"));
                    frmObj.init_err_ratio.value = Math.round(CellValue(LastRow, "init_err") / CellValue(LastRow, "init_ttl") * 1000) / 10 + " %";
                    frmObj.init_ttl.value = ComAddComma(CellValue(LastRow, "init_ttl"));
                    if (frmObj.data_radio[4].checked) {
                        colModify(sheetObj, "corr_err");
                        colModify(sheetObj, "corr_ok");
                        colModify(sheetObj, "corr_ttl");
                        colModify(sheetObj, "init_err");
                        colModify(sheetObj, "init_ok");
                        colModify(sheetObj, "init_ttl");
                    } else {
                        DataLinkMouse("corr_err") = false;
                        DataLinkMouse("corr_ok") = false;
                        DataLinkMouse("corr_ttl") = false;
                        DataLinkMouse("init_err") = false;
                        DataLinkMouse("init_ok") = false;
                        DataLinkMouse("init_ttl") = false;
                    }
                } else {
                    DataLinkMouse("corr_err") = false;
                    DataLinkMouse("corr_ok") = false;
                    DataLinkMouse("corr_ttl") = false;
                    DataLinkMouse("init_err") = false;
                    DataLinkMouse("init_ok") = false;
                    DataLinkMouse("init_ttl") = false;
                }
            }
        }
        ComBtnEnable("btn_Retrieve");
        ComBtnEnable("btn_New");
        ComOpenWait(false);
        sheetObj.WaitImageVisible = true;
    }


    /**
     * sheet1 Object의 OnDblClick이벤트 처리
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var frmObj = document.form;
        with (sheetObj) {
            if (DataLinkMouse(Col) && CellValue(Row, "yard") != "") {
                if (CellValue(Row, Col) < 1) {
                    return;
                } else if (CellValue(Row, Col) > 10000) {
                    ComShowCodeMessage("CTM20112");
                    return;
                } else {
                    if (ComShowCodeConfirm("CTM30006")) {
                        CellValue2(Row, "divide") = ColSaveName(Col);
                        doActionIBSheet(sheetObjects[1], frmObj, COMMAND02, RowSaveStr(Row));
                    }
                }
            } else {
                return;
            }
        }
    }


    /**
     * sheet2 Object의 OnDownFinish이벤트 처리
     */
    function sheet2_OnDownFinish(DownloadType, SaveAsName) {
        ComShowCodeMessage("CTM10115", "Data");
    }


    /**
     * rcc_cd[combo0] Object의 OnChange이벤트 처리
     */
    function rcc_cd_OnChange(comboObj, Index_Code, Text) {
        var frmObj = document.form;
        if (Text == "ALL" || Text == "USNYC") {
            // HTML Object Enable
            ComEnableObject(frmObj.source_radio[1], true);
            ComEnableObject(frmObj.source_radio[2], true);
        } else {
            // HTML Object Disable
            if (frmObj.source_radio[1].checked || frmObj.source_radio[2].checked) {
                frmObj.source_radio[0].checked = true;
            }
            ComEnableObject(frmObj.source_radio[1], false);
            ComEnableObject(frmObj.source_radio[2], false);
        }
        // LCC_CD 다시셋팅
        doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
    }


    /**
     * rcc_cd[combo0] Object의 OnKeyDown이벤트 처리
     */
    function rcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }


    /**
     * lcc_cd[combo1] Object의 OnChange이벤트 처리
     */
    function lcc_cd_OnChange(comboObj, Index_Code, Text) {
        var frmObj = document.form;
        if (Text == "") {
            if (frmObj.yd_cd_disp.value.length < 1) {
                // HTML Object Enable
                ComEnableObject(frmObj.data_radio[0], true);
                ComEnableObject(frmObj.data_radio[1], true);
            }
        } else {
            // HTML Object Disable
            if (frmObj.data_radio[0].checked || frmObj.data_radio[1].checked) {
                frmObj.data_radio[2].checked = true;
            }
            ComEnableObject(frmObj.data_radio[0], false);
            ComEnableObject(frmObj.data_radio[1], false);
        }
    }


    /**
     * lcc_cd[combo1] Object의 OnKeyDown이벤트 처리
     */
    function lcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }


    /**
     * p_yard2[combo2] Object의 OnChange이벤트 처리
     */
    function p_yard2_OnChange(comboObj, Index_Code, Text) {
        var frmObj = document.form;
        if (Text != "") {
            if (frmObj.data_radio[0].checked || frmObj.data_radio[1].checked || frmObj.data_radio[2].checked || frmObj.data_radio[3].checked) {
                frmObj.data_radio[4].checked = true;
            }
            // HTML Object Disable
            ComEnableObject(frmObj.data_radio[0], false);
            ComEnableObject(frmObj.data_radio[1], false);
            ComEnableObject(frmObj.data_radio[2], false);
            ComEnableObject(frmObj.data_radio[3], false);
        }
    }


    /**
     * p_yard2[combo2] Object의 OnKeyDown이벤트 처리
     */
    function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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

                        // HTML Object Enable
                        ComEnableObject(frmObj.data_radio[3], true);
                        ComEnableObject(frmObj.data_radio[2], true);
                        if (ydCdDisp.value.length < 1) {
                            ComEnableObject(frmObj.data_radio[1], true);
                            if (frmObj.lcc_cd.Text == "") {
                                ComEnableObject(frmObj.data_radio[0], true);
                            }
                        }
                        frmObj.p_yard2.RemoveAll();
                    }

                    // HTML Object Disable
                    if (frmObj.data_radio[0].checked || frmObj.data_radio[1].checked || frmObj.data_radio[2].checked) {
                        frmObj.data_radio[3].checked = true;
                    }
                    ComEnableObject(frmObj.data_radio[0], false);
                    ComEnableObject(frmObj.data_radio[1], false);
                    ComEnableObject(frmObj.data_radio[2], false);

                } else {
                    frmObj.p_yard1.value = "";
                    frmObj.p_yard2.RemoveAll();
                    // HTML Object Enable
                    ComEnableObject(frmObj.data_radio[2], true);
                    if (frmObj.lcc_cd.Text == "") {
                        ComEnableObject(frmObj.data_radio[1], true);
                        ComEnableObject(frmObj.data_radio[0], true);
                    }

                }
                break;
        }
        onShowErrMsg = false;
    }


    /**
     * BackEndJob 호출함수
     */
    function getBackEndJobStatus() {
        frmObj = document.form;
        var sheetObj = sheetObjects[0];
        frmObj.f_cmd.value = SEARCH;
        var sXml = sheetObj.GetSearchXml("EES_CTM_0417GS.do", FormQueryString(frmObj));
        var jobState = ComGetEtcData(sXml, "jb_sts_flg")
        // alert("sheet1 :::>> jobState : "+jobState);

        if (jobState == "3") {
            getBackEndJobLoadFile();
            clearInterval(timer);
        } else if (jobState == "4") {
            ComOpenWait(false);
            // BackEndJob을 실패 하였습니다.
            ComShowCodeMessage('CTM10024');
        } else if (jobState == "5") {
            ComOpenWait(false);
            // 이미 BackEndJob 결과 파일을 읽었습니다.
            ComShowCodeMessage('CTM10024');
        }
    }


    /**
    * BackEndJob의 결과가 완료되면 XML파일로 내려받음.(Request Expense Inital)
    */
    function getBackEndJobLoadFile() {
        frmObj = document.form;
        frmObj.f_cmd.value = SEARCHLIST;
        sheetObjects[0].DoSearch4Sax("EES_CTM_0417GS.do", FormQueryString(frmObj));
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction){
        with(frmObj){
     		if (sAction == IBSEARCH) {
    	          if (cancelDate == false){
    	        	  return false;
    	          }
    	        	  
    	         }
        }
        return true;
    }


/* 개발자 작업 끝 */