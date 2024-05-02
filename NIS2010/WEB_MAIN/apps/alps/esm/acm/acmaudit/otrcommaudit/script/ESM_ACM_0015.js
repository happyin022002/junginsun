/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0015.js
*@FileTitle : Other Commission Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.12 김영오
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
     * @class ESM_ACM_0015 : ESM_ACM_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0015() {
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
    var currentRow = 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj = sheetObjects[0];
        var frmObj = document.form;
        var srcName = window.event.srcElement.getAttribute("name");

        switch (srcName) {
            case "btn_calendar":
                if (!window.event.srcElement.disabled) {
                    var cal = new ComCalendarFromTo();
                    cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                }
                break;

            case "btn_inv_dt":
                var cal = new ComCalendar();
                cal.select(frmObj.inv_dt, 'yyyy-MM-dd');
                break;

            case "btn_retrieve":
                doActionIBSheet(shtObj, frmObj, IBSEARCH);
                break;

            case "btn_add":
                doActionIBSheet(shtObj, frmObj, IBINSERT);
                break;

            case "btn_delete":       // Row Delete
                doActionIBSheet(shtObj, frmObj, IBDELETE);
                break;

            case "btn_audit":
                doActionIBSheet(shtObj, frmObj, MULTI);
                break;

            case "btn_reject":
                doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                break;

            case "btn_audit_cancel":
                doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC02);
                break;

            case "btn_downexcel":
                doActionIBSheet(shtObj,frmObj,IBDOWNEXCEL);
                break;
        } // end switch
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
                    style.height = 320;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 15, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|CHK|No.|Acct.|Description|vdCnt|Office|Vendor|Name|City|Center|Apply Date|" +
                                      "VVD|Cur|Payment Amount|Ex. Rate|USD Amount|Audit No|CSR No|Approval Date|Status|Remark|||||"

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDummyCheck,   30,     daCenter,    true,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    true,    "seq");
                    InitDataProperty(0, cnt++, dtCombo,        60,     daCenter,    true,    "comm_stnd_cost_cd",   false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         200,    daCenter,    true,    "otr_comm_rmk",        false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       70,     daCenter,    true,    "vndr_cnt_cd");
                    InitDataProperty(0, cnt++, dtPopup,        70,     daCenter,    true,    "ar_ofc_cd",        	false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtPopup,        70,     daCenter,    false,   "vndr_seq",            false,    "",    dfNone,    0,    false,     false,    6);
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,      false,   "vndr_lgl_eng_nm",     false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    true,    "ac_occr_info_cd",     false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    true,    "ap_ctr_cd",     		false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,   "aply_dt",             false,    "",    dfDateYmd, 0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         110,    daCenter,    false,   "vvd",                 false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtCombo,        45,     daCenter,    true,    "curr_cd",     		false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daRight,     false,   "pay_if_amt",          false,    "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daRight,     false,   "pay_xch_rt",          false,    "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daRight,     false,   "if_amt",              false,    "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,   "aud_no",              false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         140,    daCenter,    false,   "csr_no",              false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,   "apro_dt",             false,    "",    dfDateYmd, 0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    true,    "ac_sts_cd",           false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         180,    daLeft,      true,    "ac_proc_desc",        false,    "",    dfNone,    0,    false,     false);

                    InitDataProperty(0, cnt++, dtHidden,       180,    daLeft,      true,    "otr_comm_no",         false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       100,    daLeft,      true,    "agn_cd");
                    InitDataProperty(0, cnt++, dtHidden,       50,     daCenter,    true,    "vvd_cnt",             false,    "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       100,    daLeft,      true,    "io_bnd_cd");
                    InitDataProperty(0, cnt++, dtHidden,       50,     daCenter,    true,    "ac_seq",              false,    "",    dfNone,    0,    false,     false);

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "curr_cd", " |" + currText, " |" + currCode, "");

                    ColIndent("pay_if_amt") = 2;
                    ColIndent("pay_xch_rt") = 2;
                    ColIndent("if_amt") = 2;

                    ShowButtonImage = 3;
                    WaitImageVisible = false;

                    break;
            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd", "ac_sts_cd");
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate",   "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;

            case IBSEARCH:       	// 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0015GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case MULTI:    		 // Audit
                //if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;

                var rArray = getCheckedRows(shtObj, "chk");
                frmObj.bkg_no_array.value = rArray;
                var bkgNoArray = new Array();
                var bkgNoArraySplit = frmObj.bkg_no_array.value.split(",");
                var queryVal = "";
                for(j=0;j<bkgNoArraySplit.length; j++){
                    if(j < bkgNoArraySplit.length-1){
                        queryVal += bkgNoArraySplit[j]+"','";
                    }else{
                        queryVal += bkgNoArraySplit[j];
                    }
                }
                frmObj.bkg_no.value = "'"+queryVal+"'";

                //Audit for the selected rows will be completed. Are you sure to proceed?
                if(ComShowConfirm(ComGetMsg("ACM00010"))){
                    var sParam = FormQueryString(frmObj);
                    var sXml = shtObj.LoadSaveXml(shtObj.GetSaveXml("ESM_ACM_0015GS.do", "f_cmd=" + MULTI + "&ar_ofc_cd=" + frmObj.ar_ofc_cd.value+ "&bkg_no=" + frmObj.bkg_no.value));
                    if (sXml == true) {
                        doActionIBSheet(shtObj, frmObj, IBSEARCH);
                        ComShowCodeMessage("ACM00011","");
                    }
                } else {
                    //alert("취소");
                }

                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:		//Down Excel
                shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "chk");
                break;

            case IBINSERT:       	// 신규 행추가
                shtObj.DataInsert();
                break;

            case IBDELETE:       	// 체크된 행삭제
                // RowStatus만 Delete로
                var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
                if (chkRowArr.length > 1) {
                    shtObj.RowStatus(chkRowArr[0]) = "D";
                }
                break;

            case IBSEARCH_ASYNC01:    //Reject
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI01;
                shtObj.DoSave("ESM_ACM_0015GS.do", FormQueryString(frmObj), "chk", false);


                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0015GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC02:    //Audit Cancel
                ComOpenWait(true);

                for(var i=1; i<=shtObj.LastRow; i++) {
                    if (shtObj.CellValue(i, "ac_sts_cd") != "AS") {
                        ComShowCodeMessage("ACM00024","");	//Please select Audited bookings only!
                        ComOpenWait(false);
                        return;
                    }
                }

                frmObj.f_cmd.value = MULTI02;
                shtObj.DoSave("ESM_ACM_0015GS.do", FormQueryString(frmObj), "chk", false);

                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0015GS.do", FormQueryString(frmObj));
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
        doActionIBSheet(shtObj, document.form, SEARCH01);
        document.form.comm_yrmon.value = ComGetNowInfo("ym");//최초 페이지 로드 시 현재 YYY-MM 셋팅
    }


    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj = sheetObjects[0];
        with (document.form) {
            switch (elementName) {

                case "ar_ofc_cd":
                    if (ar_ofc_cd.value == "") {
                        ComClearCombo(agn_cd);
                        return;
                    }
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + ar_ofc_cd.value);
                    if (ACMXml2SelectItem(xmlStr, agn_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (agn_cd.options.length > 1) {
                            // ar_ofc_cd와 같은 값이 선택되게 함
                            agn_cd.value = ar_ofc_cd.value;
                        }
                    }
                    break;
            }
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {Object} shtObj
     * @param {Object} formObj
     * @param {Object} sAction
     */
    function validateForm(shtObj,fromObj,sAction){
        with(fromObj){
            switch(sAction) {
                case RDPRINT:	//Print
                    //if(if_option.value != "IF"){
                    //	ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
                    //	return false;
                    //}

                    var checkCnt = shtObj.CheckedRows("chk");
                    if(checkCnt < 1 || checkCnt > 1){
                        ComShowMessage(ComGetMsg("AGT10016", "", "", ""));
                        return false;
                    }
                    break;
            }
        }

        return true;
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

                case "ar_ofc_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_071.do", 700, 445, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
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
                if (ColSaveName(Col) == "vndr_seq") {
                    CellValue(Row, Col) = aryPopupData[0][2];
                } else {
                    CellValue2(Row, Col) = aryPopupData[0][3];
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

                case "ar_ofc_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value + "&value8=Sub Office");
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
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
     * 선택한 행의 정보를 Array에 담는다.
     * @param {Object} sheetObj
     * @param {Object} colName
     */
    function getCheckedRows(shtObj, colName) {
        var colsCnt = shtObj.LastCol + 1;
        var rows = shtObj.Rows;
        var rArray = null; //행데이터를 담고 있는 배열
        var checkRows = shtObj.CheckedRows(colName);
        var bkg_no;
        var bkg_no_tmp;
        var bkg_no_len = 0;

        if(checkRows == 0){
            return null;
        }else{
            var idx = 0;
            rArray = new Array(checkRows);
            for(var i=0; i<rows; i++) {
                if(shtObj.CellText(i,colName) == 1) {
                    bkg_no = "";
                    bkg_no_tmp = "";
                    bkg_no_len = 0;
                    bkg_no_tmp = shtObj.CellText(i,"otr_comm_no");
                    bkg_no_len = bkg_no_tmp.length;

                        bkg_no = bkg_no_tmp;
                    rArray[idx++] = bkg_no + document.form.agn_cd.value + shtObj.CellText(i,"io_bnd_cd") + shtObj.CellText(i,"ac_seq");
                }
            }

            return rArray;
        }
    }


/* 개발자 작업 끝 */
