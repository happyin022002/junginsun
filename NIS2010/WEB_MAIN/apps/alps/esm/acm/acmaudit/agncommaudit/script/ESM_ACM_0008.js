/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0008.js
*@FileTitle : Agent Commission Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.02 김상수
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.09.21 김봉균 [CHM-201220389] 대리점비 multi Audit 시 로직 변경 요청  (100개 이상 Audit 시 기능 보완 )
* 2013.05.24 박다은 [CHM-201324688] Audit 버튼 클릭은 RS만 되고 Audit Reject 는 AS만 되게 수정
* 2014.06.27 박다은 [CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청
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
     * @class ESM_ACM_0008 : ESM_ACM_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0008() {
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
        var memoShtObj1 = sheetObjects[0];
        var memoShtObj2 = sheetObjects[1];
        var shtObj = sheetObjects[2];
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            if (srcName != "btn2_vvd_cd") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.vvd_cd);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_bl_no") {
                ACMMemoSheet_Close(memoShtObj2, frmObj.bl_no);    // CoAcm.js에 정의
            }

            switch (srcName) {
                case "btn_calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;

                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_detail":
                    var sRow = shtObj.SelectRow;
                    if (sRow < 1) {
                        ComShowCodeMessage("COM12189");
                        return;
                    }
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0105.do?generalBrkg=General Commission&" + shtObj.RowSaveStr(sRow), 886, 518, "", "1,0,1,1,1,1,1", true, false);
                    break;

                case "btn_audit":
                	if(shtObj.CheckedRows("chk") < 1){
						ComShowCodeMessage("COM12113", "row");//Please select **.
						return;
					}else if(shtObj.CheckedRows("chk") > 3000){ // [CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청
						ComShowCodeMessage("COM12113", "less than 3000 bookings!"); // Please select **.
						return;						
					}
                    doActionIBSheet(shtObj, frmObj, MULTI);
                    break;

                case "btn_reject":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                    break;

                case "btn_cancel":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC02);
                    break;

                case "btn_calculate":
                    break;

                case "btn_downexcel":
                    ComOpenWait(true);
                    shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "chk");
                    ComOpenWait(false);
                    break;

                case "btn2_vvd_cd":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;

                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
                    break;

                case "btn2_check":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 1);    // CoAcm.js에 정의
                    break;

                case "btn2_uncheck":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 0);    // CoAcm.js에 정의
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

        initControl();

        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            switch (shtObj.id) {

                case "memo_sheet1":
                case "memo_sheet2":
                    ACMMemoSheet_InitSheet(shtObj);    // CoAcm.js에 정의
                    break;

                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 389;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

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
                    InitHeadMode(true, false, true, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|CHK|No.|BKG No.|B/L No.|Audit No.|BND|R.VVD|Comm.\nVVD|S/A Date|Rqst. Date|Seq|BKG STS|Pre AMT|" +
                                      "Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|Current AMT|" +
                                      "Difference\n(USD)|Ex. Rate|Cur.|Payment\nAMT (LCL)|STS|CSR No.|Remarks|||||";

                    var HeadTitle1  = "STS||No.|BKG No.|B/L No.|Audit No.|BND|R.VVD|Comm.\nVVD|S/A Date|Rqst. Date|Seq|BKG STS|Pre AMT|" +
                                      "Total|General|CHF|Charge|T/S|BKRG|C/B|" +
                                      "Difference\n(USD)|Ex. Rate|Cur.|Payment\nAMT (LCL)|STS|CSR No.|Remarks|||||";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, false);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDummyCheck,   30,     daCenter,    true,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    true,    "seq");
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "bkg_no",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "bl_no",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "aud_no",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "io_bnd_cd",      false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "rev_vvd_cd",     false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "comm_vvd",       false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    true,    "sail_arr_dt",    false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    true,    "rqst_dt",		   false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    true,    "ac_seq",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "bkg_sts_cd",     false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "ppd_amt",        false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "usd_amt",        false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "general_amt",    false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "chf_amt",        false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "chg_comm_amt",   false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "ts_amt",         false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "brog_amt",       false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "cross_amt",      false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      80,     daRight,     true,    "dff_amt",        false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daRight,     true,    "pay_xch_rt",     false,     "",    dfFloat,   4,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "curr_cd",        false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      80,     daRight,     true,    "pay_if_amt",     false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "ac_sts_cd",      false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    true,    "csr_no",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    true,    "ac_proc_desc",   false,     "",    dfNone,    0,    false,     false);

                    InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    true,    "agn_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    true,    "crnt_rev_amt",   false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    true,    "ddct_chg_amt",   false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    true,    "ddct_trsp_amt",  false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       100,    daCenter,    true,    "post_rev_amt",   false,     "",    dfNone,    0,    false,     false);

                    ColIndent("ppd_amt") = 2;
                    ColIndent("usd_amt") = 2;
                    ColIndent("general_amt") = 2;
                    ColIndent("chf_amt") = 2;
                    ColIndent("ts_amt") = 2;
                    ColIndent("brog_amt") = 2;
                    ColIndent("cross_amt") = 2;
                    ColIndent("dff_amt") = 2;
                    ColIndent("pay_xch_rt") = 2;
                    ColIndent("daRight") = 2;

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    WaitImageVisible = false;
                    HeadRowHeight = 24;

                    break;
            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;

            case IBSEARCH:       // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0008GS.do", FormQueryString(frmObj));
                shtObj.ColFontUnderline("bkg_no") = true;
                shtObj.ColFontUnderline("bl_no") = true;
                ComOpenWait(false);
                break;

            case MULTI:    // Audit
            	//[CHM-201324688] Audit 버튼 클릭은 RS만 되고 Audit Reject 는 AS만 되게 수정
            	if(!validateForm(shtObj,frmObj,sAction)) return;
            	ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                var rArray = getCheckedRows(shtObj, "chk");
                frmObj.bkg_no_array.value = rArray;
                var bkgNoArray = new Array();
                var bkgNoArraySplit = frmObj.bkg_no_array.value.split(",");
                var queryVal = "";
                for(j=0;j<bkgNoArraySplit.length; j++){
                    if(j <= bkgNoArraySplit.length-1){
                        if(j == 0){
                            queryVal = "to_clob('";
                        }else if(j % 100 == 1 && j != 1){
                            queryVal = queryVal + "||to_clob(',";
                        }
                        queryVal += bkgNoArraySplit[j];
                    }else{
                        queryVal += bkgNoArraySplit[j];
                    }
                    if((j != 0 && j % 100 == 0) || j == bkgNoArraySplit.length - 1){
                        queryVal = queryVal + "')";
                    }else{
                        queryVal +=  ","; // bkgNoArraySplit[j]+
                    }
                }
                frmObj.bkg_no.value = queryVal; //"'"+queryVal+"'";

                //Audit for the selected rows will be completed. Are you sure to proceed?
                if(ComShowConfirm(ComGetMsg("ACM00010"))){
                    sheetObjects[0].LoadSaveXml(shtObj.GetSaveXml("ESM_ACM_0008GS.do",
                    		"f_cmd=" + MULTI + "&ar_ofc_cd=" + frmObj.ar_ofc_cd.value+ "&bkg_no=" + frmObj.bkg_no.value+ "&agn_cd=" + frmObj.agn_cd.value + "&ac_tp_cd=" + frmObj.ac_tp_cd.value));
                }
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01:    //Reject
            	// [CHM-201324688] Audit 버튼 클릭은 RS만 되고 Audit Reject 는 AS만 되게 수정
            	if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI01;
                shtObj.DoSave("ESM_ACM_0008GS.do", FormQueryString(frmObj), "chk", false);
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC02:    //Audit Cancel
            	// [CHM-201324688] Audit 버튼 클릭은 RS만 되고 Audit Reject 는 AS만 되게 수정
            	if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI02;
                shtObj.DoSave("ESM_ACM_0008GS.do", FormQueryString(frmObj), "chk", false);
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
                CellText(LastRow, "seq") = "";
                CellText(LastRow, "bkg_no") = "TOTAL";
                CellAlign(LastRow, "bkg_no") = daRight;
                ReDraw = true;
            }
        }
    }

    
    /**
     * IBSheet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }

    
    /**
     * IBSheet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function memo_sheet1_OnSaveEnd(shtObj, ErrMsg) {
    	if (ErrMsg != "") return;
    	// 저장 후 재조회
    	ComShowCodeMessage("ACM00011"); //Audit Success!
    	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnDblClick(shtObj, row, col){
    var sRow = shtObj.SelectRow;
        if (sRow < 1) {
            ComShowCodeMessage("COM12189");
            return;
        }
        // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
        if(shtObj.ColSaveName(col) == "brog_amt" && Number(shtObj.CellValue(row, "brog_amt")) != 0){
        	ComOpenPopup("ESM_ACM_0105.do?brkg_flg=1&generalBrkg=Brokerage&" + shtObj.RowSaveStr(row), 886, 518, "", "1,0,1,1,1,1,1", true, false);
        } else if(shtObj.ColSaveName(col) == "cross_amt" && Number(shtObj.CellValue(row, "cross_amt")) != 0){
        	ComOpenPopup("ESM_ACM_0105.do?brkg_flg=2&generalBrkg=Cross&" + shtObj.RowSaveStr(row), 886, 518, "", "1,0,1,1,1,1,1", true, false);
        } else{
        	ComOpenPopup("ESM_ACM_0105.do?generalBrkg=General Commission&" + shtObj.RowSaveStr(sRow), 886, 518, "", "1,0,1,1,1,1,1", true, false);	
        } 
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

        if (checkRows == 0) {
            return null;
        } else {
            var idx = 0;
            rArray = new Array(checkRows);
            for(var i=shtObj.HeaderRows; i<rows-1; i++) {
                if(shtObj.CellText(i,colName) == 1) {
                    bkg_no = "";
                    bkg_no_tmp = "";
                    bkg_no_len = 0;
                    bkg_no_tmp = shtObj.CellText(i,"bkg_no");
                    bkg_no_len = bkg_no_tmp.length;
                    bkg_no = bkg_no_tmp;
                    rArray[idx++] = bkg_no + document.form.agn_cd.value + shtObj.CellText(i,"io_bnd_cd") + shtObj.CellText(i,"ac_seq");
                }
            }
            return rArray;
        }
    }


    //[CHM-201324688] Audit 버튼 클릭은 RS만 되고 Audit Reject 는 AS만 되게 수정    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {Object} shtObj
     * @param {Object} frmObj
     * @param {Object} sAction
     */
    function validateForm(shtObj, frmObj, sAction){
        with(frmObj){
            switch(sAction) {

                case MULTI:    //Audit
                    var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
                    if (chkRowArr.length > 1) {
                        	for (var i=0; i<chkRowArr.length-1; i++) {
                        		// RS 상태일 때만 Audit 가능
                            if (shtObj.CellValue(chkRowArr[i], "ac_sts_cd") != "RS") {
                                ComShowCodeMessage("ACM00031");
                                //ComShowMessage("Please select Requested bookings only!");
                                shtObj.CellValue(chkRowArr[i], "chk") = "0";
                                return false;
                            }

                        }
                    }
                    break;
                    
                case IBSEARCH_ASYNC01: //Reject
                    var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
                    if (chkRowArr.length > 1) {
                        	for (var i=0; i<chkRowArr.length-1; i++) {
                        		// AS 일 경우에만 Reject 가능
                               if (shtObj.CellValue(chkRowArr[i], "ac_sts_cd") != "RS") {
                                   ComShowCodeMessage("ACM00031");
                                   //ComShowMessage("Please select Requested bookings only!");
                                   shtObj.CellValue(chkRowArr[i], "chk") = "0";
                                   return false;
                               }
                        	}
                    	}
                    	break;
                    
                case IBSEARCH_ASYNC02: //Audit Cancel
                	 var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
                     if (chkRowArr.length > 1) {
                         	for (var i=0; i<chkRowArr.length-1; i++) {
                         		// AS 일 경우에만 Audit Cancel 가능
                                if (shtObj.CellValue(chkRowArr[i], "ac_sts_cd") != "AS") {
                                    ComShowCodeMessage("ACM00024");
                                    //ComShowMessage("Please select Audited bookings only!");
                                    shtObj.CellValue(chkRowArr[i], "chk") = "0";
                                    return false;
                                }
                         	}
                     	}
            }
        return true;
        }
   }   
    

/* 개발자 작업 끝 */
