/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0110.js
*@FileTitle : Simulation No. Search
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.05 김상수
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
     * @class ESM_ACM_0110 : ESM_ACM_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0110() {
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
        var shtObj = sheetObjects[0];
        var frmObj = document.form;

        var srcName = window.event.srcElement.getAttribute("name");

        switch (srcName) {
			case "btn_calendar":	// Calendar
                if (!window.event.srcElement.disabled) {
                    var cal = new ComCalendarFromTo();
                    cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                }
                break;
				
            case "btn_retrieve":     // Retrieve
                doActionIBSheet(shtObj, frmObj, IBSEARCH);
                break;

            case "btn_select":       // Select
                var rArray = new Array();
				var opener = window.dialogArguments;
                var s1chkRowIdx = shtObj.FindCheckedRow("chk").split("|")[0];
				if (shtObj.CheckedRows("chk") < 1) {
                    ComShowCodeMessage("COM12113", "[Simulation No]");    // Please select {?msg1}
                    return;
                }
                rArray[0] = shtObj.CellValue(s1chkRowIdx, "sim_no");
				opener.document.form.sim_no.value = rArray[0];
				window.close();
                break;

            case "btn_close":        // close
                window.close();
                break;


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

        initControl();

        // sheet1_OnLoadFinish 메서드 반드시 참조
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
                    style.height = GetSheetHeight(10);

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
                    InitHeadMode(true, true, false, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|CHK|Office|Simulation No|BKG No.|Remark|Simulation Date";
                    var HeadTitle1  = "STS|CHK|Office|Simulation No|BKG No.|Remark|Simulation Date";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    //InitHeadRow(1, HeadTitle1, false);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 35,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtRadioCheck,   40,     daCenter,    true,    "chk");
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,   "sim_usr_ofc_cd", false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,   "sim_no",      	false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,   "sim_bkg_knt",     false,    "",    dfNone,     0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    true,    "sim_rmk",        	false,    "",    dfNone,     0,    false,    false);
					InitDataProperty(0, cnt++, dtData,         80,     daCenter,    true,    "cre_dt",        	false,    "",    dfDateYmd,  0,    false,    false);

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    ShowButtonImage = 3;
                    WaitImageVisible = false;
                    CountPosition = 0;

                    break;
            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnKeyUp 이벤트
        axon_event.addListener("keyup", "frmObj_OnKeyUp", "dir_agmt_no");
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
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

                case "agn_agmt_no":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
//                    ComOpenPopup("ESM_ACM_0011.do", 506, 382, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;
            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:       // RHQ 목록 조회
                frmObj.f_cmd.value = SEARCH02;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0110GS.do", FormQueryString(frmObj));
				//alert(xmlStr);
                ACMXml2SelectItem(xmlStr, frmObj.sim_usr_ofc_cd, "sim_usr_ofc_cd", "sim_usr_ofc_nm", false);
                break;

            case IBSEARCH:
                //if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0110GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
        }
    }

    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
        // 조회조건의 RHQ Select Object 생성
        doActionIBSheet(shtObj, document.form, SEARCH01);
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
                    // OnChange 이벤트가 발생하면 document.agn_agmt_no에 값을 setting
                    document.form.agn_agmt_no.value = CellValue(Row, "agn_agmt_no");
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
        // 저장 후 부모창 재조회 후 창 닫기
        var opener = window.dialogArguments;    // MODAL창에서 부모창 호출
        opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
        window.close();
    }
	
	
    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj = sheetObjects[0];
        with (document.form) {
            switch (elementName) {

            }
        }
    }


    /**
     * Form Element의 OnKeyUp 이벤트
     */
    function frmObj_OnKeyUp() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj = sheetObjects[0];

        with (document.form) {
            switch (elementName) {

                case "dir_agmt_no":
                    if (dir_agmt_no.value.length > 8) {
                        // validation
                        var xmlStr = shtObj.GetSearchXml("ESM_ACM_0110GS.do", "f_cmd=" + SEARCH02 + "&agn_agmt_no=" + dir_agmt_no.value);
                        if (ACMDecideErrXml(shtObj, xmlStr)) {
                            dir_agmt_no.value = "";
                            ComSetFocus(dir_agmt_no);
                        } else {
                            // 오류가 없으면 document.agn_agmt_no에 값을 setting
                            agn_agmt_no.value = dir_agmt_no.value;
                        }
                    }
                    break;
            }
        }
    }


/* 개발자 작업 끝 */
