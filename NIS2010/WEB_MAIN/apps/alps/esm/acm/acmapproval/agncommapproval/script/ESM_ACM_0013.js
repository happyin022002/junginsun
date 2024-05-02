/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0013.js
*@FileTitle : Returned CSR Reprocess
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.26 김상수
* 1.0 Creation
* 2013.06.21 이윤정 [CHM-201324817] Returned CSR Reprocess 에서 Error Reason 추가
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
     * @class ESM_ACM_0013 : ESM_ACM_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0013() {
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
                case "btn_calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;

                case "btn_retrieve":
                	sheetObjects[1].RemoveAll();
                	sheetObjects[2].RemoveAll();
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;

                case "btn_confirm":
					if(shtObj.CheckedRows("chk") < 1){
						//Please select **.
						ComShowCodeMessage("COM12113", "row");
						return;
					}
                	doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                    break;
                    
                case "btn_cancel":
                	if(shtObj.CheckedRows("chk") < 1){
                		//Please select **.
                		ComShowCodeMessage("COM12113", "row");
                		return;
                	}
                	doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC02);
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

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

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
                case 1:    // CSR Main
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(6);

                    // 전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|CHK|Returned CSR No.|Total BKG No.|Error Reason";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtRadioCheck,   40,     daCenter,    false,    "chk");
                    InitDataProperty(0, cnt++, dtData,         200,    daCenter,    false,    "csr_no",     false,    "",    dfNone,       0,    false);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "bkg_cnt",    false,    "",    dfInteger,    0,    false);
                    InitDataProperty(0, cnt++, dtData,         500,    daLeft,      false,    "if_err_rsn", false,    "",    dfNone,	   0,    false);

                    ColIndent("bkg_cnt") = 2;
                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    break;


                case 2:    // CSR Detail
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(7);

                    // 전체 너비 설정
                    SheetWidth = mainTable2.clientWidth;

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "|SEQ|Audit No.|Agent|VVD Count|Cur|Net\nAMT(USD)|VAT|TTL\nAMT(USD)|Approval Date";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    false,     "seq");
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    false,    "aud_no");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "agn_cd");
                    InitDataProperty(0, cnt++, dtAutoSum,      100,    daRight,     false,    "vvd_cnt",    false,    "",    dfInteger,    0,    false);
                    InitDataProperty(0, cnt++, dtAutoSum,      100,    daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtAutoSum,      100,    daRight,     false,    "net_amt",    false,    "",    dfInteger,    0,    false);
                    InitDataProperty(0, cnt++, dtAutoSum,      100,    daRight,     false,    "vat",        false,    "",    dfInteger,    0,    false);
                    InitDataProperty(0, cnt++, dtAutoSum,      100,    daRight,     false,    "tot_amt",    false,    "",    dfInteger,    0,    false);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "apro_dt");

                    ColIndent("vvd_cnt") = 2;
                    ColIndent("net_amt") = 2;
                    ColIndent("vat") = 2;
                    ColIndent("tot_amt") = 2;

                    break;


                case 3:    // Reprocessed Audit No. Detail
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(2);

                    // 전체 너비 설정
                    SheetWidth = mainTable3.clientWidth;

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "|Audit No.|Agent|VVD Count|Cur|Total Net Amount(USD)";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    false,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         200,    daCenter,    false,    "aud_no");
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    false,    "agn_cd");
                    InitDataProperty(0, cnt++, dtData,         150,    daRight,     false,    "vvd_cnt",    false,    "",    dfInteger,    0,    false);
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    false,    "curr_cd");
                    InitDataProperty(0, cnt++, dtData,         150,    daRight,     false,    "net_amt",    false,    "",    dfInteger,    0,    false);

                    ColIndent("vvd_cnt") = 2;
                    ColIndent("net_amt") = 2;
                    // 선택된 행의 하이라이트
                    SelectHighLight = false;

                    break;
            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate", document.form);
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

            case IBSEARCH:       // 조회 (Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0013GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case SEARCH02:       // 조회 (Detail)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH02;
                shtObj.DoSearch("ESM_ACM_0013GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01:      	// Reprocess to Audit Confirm
				if (!ComChkValid(frmObj)) return;
	            ComOpenWait(true);
	            var saveParam = "f_cmd=" + MULTI01 + "&ar_ofc_cd=" + frmObj.ar_ofc_cd.value + "&agn_cd=" + frmObj.agn_cd.value 
	            		+ "&" + shtObj.GetSaveString(false, true, "chk");
	            var xmlStr = shtObj.GetSaveXml("ESM_ACM_0013GS.do", saveParam);
	            if (ACMDecideErrXml(shtObj, xmlStr)) return;
	            sheetObjects[2].LoadSaveXml(xmlStr);
	            ComOpenWait(false);
				break;
				
            case IBSEARCH_ASYNC02:      	// CSR Cancel
            	if (!ComChkValid(frmObj)) return;
            	ComOpenWait(true);
            	frmObj.f_cmd.value = MULTI02;
            	shtObj.DoSave("ESM_ACM_0013GS.do", FormQueryString(frmObj), "chk", false);
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
                    document.form.csr_no_master.value = CellValue(Row, "csr_no");
                    doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
                    break;
            }
        }
    }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet2_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount > 0) {
                ReDraw = false;
                CellText(LastRow, "seq") = "";
                CellText(LastRow, "aud_no") = "TOTAL";
                CellAlign(LastRow, "aud_no") = daRight;
                ReDraw = true;
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
        // 저장 후 재조회
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
    }
    
    
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet3_OnSaveEnd(shtObj, ErrMsg) {
    	if (ErrMsg != "") return;
    	// 저장 후 재조회
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    	sheetObjects[1].RemoveAll();
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


/* 개발자 작업 끝 */
