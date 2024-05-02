/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0017.js
*@FileTitle : Special Compensation CSR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.04 김영오
* 1.0 Creation
* 2013.04.25 박다은 [CHM-201324281][ACM] Agreement History 의 Haulage Deduction 조회 결과 형식 변경
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
     * @class ESM_ACM_0017 : ESM_ACM_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0017() {
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
        //var memoShtObj1 = sheetObjects[0];
        var shtObj = sheetObjects[1];
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
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
                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 140;

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

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var HeadTitle1 = "|CHK|Agreement No.|Effrctive Date|Effrctive Date|Remark|Del|Event Date|Event Date|Event Date|Event Date|User Name|||||";
                    var HeadTitle2 = "|CHK|Agreement No.|From|To|Remark|Del|Local Time|Local Time|GMT|GMT|User Name|||||";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 	30,    daCenter,  true,    "ibflag",    		false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtRadioCheck, 	30,    daCenter,  true,    "chk",    			false,    "",         dfNone,     0,          true,       true);
                    //InitDataProperty(0, cnt++, dtData, 			110,   daCenter,  true,    "agn_cd",    		false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtData,         	110,   daCenter,  true,    "agn_agmt_no",   	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,         	70,    daCenter,  false,   "agmt_fm_dt",   		false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,         	70,    daCenter,  false,   "agmt_to_dt",  		false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,      	300,   daLeft,    true,    "agn_agmt_rmk", 		false,    "",         dfNone,  	  0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,     		30,    daCenter,  true,    "delt_flg", 			false,    "",         dfNone,     0,          false,      false);

                    InitDataProperty(0, cnt++, dtData,   		70,    daCenter,  false,   "cre_locl_dt",   	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    		40,    daCenter,  false,   "cre_locl_dt_tm",    false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   		70,    daCenter,  false,   "cre_gdt",   		false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    		40,    daCenter,  false,   "cre_gdt_tm",   		false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    		90,    daCenter,  true,    "cre_usr_id",   		false,    "",         dfNone,     0,          false,      false);

                    InitDataProperty(0, cnt++, dtHidden,     	90,    daRight,   true,    "agmt_fm_dt_cd", 	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtHidden,     	90,    daRight,   true,    "agmt_to_dt_cd", 	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtHidden,     	90,    daRight,   true,    "cre_dt", 			false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtHidden,     	90,    daRight,   true,    "cre_usr_id", 		false,    "",         dfNone,     0,          false,      false);

                    //하위 그리드 파라미터
                    InitDataProperty(0, cnt++, dtHidden,     	90,    daRight,   true,    "agmt_his_no", 		false,    "",         dfNone,     0,          false,      false);

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    WaitImageVisible = false;
                    CountPosition = 0;

                    break;

                case "sheet2":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 90;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var HeadTitle = "Agreement No.|Item|Current|Privious";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,    	100,   daCenter,  true,     "agn_agmt_no");
                    InitDataProperty(0, cnt++, dtData,    	110,   daCenter,  true,     "item");
                    InitDataProperty(0, cnt++, dtData,    	350,   daCenter,  false,    "current_value",   	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    	350,   daCenter,  false,    "previous_value",  	false,    "",         dfNone,     0,          false,      false);

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    WaitImageVisible = false;
                    CountPosition = 0;
                    // 선택된 행의 하이라이트 
                    SelectHighLight = false;
                    break;

                case "sheet3":
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(18);

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var HeadTitle = "Agreement No.|Item|Item|Current|Previous|Comp. Master Info";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,     100,    daCenter,  true,     "agn_agmt_no",   	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,     120,    daCenter,  true,     "item1",   			false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    	90,    daCenter,  true,     "item2",   			false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtCombo,    210,    daCenter,  false,    "current_value",   	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtCombo,    210,    daCenter,  false,    "previous_value",  	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData, 	   210,    daCenter,  false,    "master_info",  	false,    "",         dfNone,     0,          false,      false);

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    // [CHM-201324281][ACM] Agreement History 의 Haulage Deduction 조회 결과 형식 변경
                    InitDataCombo(0, "current_value", "Y|N", "1|0");
                    InitDataCombo(0, "previous_value", "Y|N", "1|0"); 
                    
                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    WaitImageVisible = false;
                    CountPosition = 0;

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
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "rhq_cd_disp", "ar_ofc_cd", "agn_cd");
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:       // Office 목록 조회
                // RHQ level과 목록 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH07);
                ACMXml2SelectItem(xmlStr, frmObj.rhq_cd_disp, "value0", "value0", true);    // CoAcm.js에 정의
                var rhqCd = ComGetEtcData(xmlStr, "rhq_cd");
                ofcKndCd = ComGetEtcData(xmlStr, "ofc_knd_cd");    // *** 반드시 전역변수로 setting에 유의 ***
                if (rhqCd == "") {
                    // 본사 User일 경우 (rhqCd가 Null로 조회)
                    frmObj.rhq_cd_disp.style.display = "inline";    // hidden인 form.rhq_cd_disp가 보여지게 함
                    frmObj.rhq_cd.style.display = "none";    // form.rhq_cd는 숨김
                } else {
                    frmObj.rhq_cd_disp.value = rhqCd;    // hidden상태 그대로 form.rhq_cd_disp에 rhqCd가 선택되게 하고
                    frmObj.rhq_cd_disp.fireEvent("onchange");    // hidden상태 그대로 form.rhq_cd_disp에 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                }
                break;

            case IBSEARCH:    // 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                sheetObjects[1].removeAll();
                sheetObjects[0].DoSearch("ESM_ACM_0017GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case SEARCH02:    // 조회(Detail)
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH02;
                var shtObj2 = sheetObjects[1];
                var shtObj3 = sheetObjects[2];
                shtObj2.RemoveEtcData();
                shtObj3.RemoveEtcData();
                var xmlArr = shtObj2.GetSearchXml("ESM_ACM_0017GS.do", FormQueryString(frmObj)).split("|$$|");
                shtObj2.LoadSearchXml(xmlArr[0]);
                shtObj3.LoadSearchXml(xmlArr[1]);
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
     * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 상세내역을 조회한다.
     * @param {Object} sheetObj
     * @param {Object} row
     * @param {Object} col
     * @param {Object} value
     */
    function sheet1_OnClick(shtObj, row, col, value) {
        var frmObj = document.form;
        frmObj.agmt_his_no.value = shtObj.CellValue(row,"agmt_his_no");
        frmObj.agn_agmt_no.value = shtObj.CellValue(row,"agn_agmt_no");
        doActionIBSheet(shtObj, document.form, SEARCH02);
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
                RangeFontBold(TopRow, SaveNameCol("agn_agmt_no"), LastRow, SaveNameCol("item")) = true;
                RangeFontColor(TopRow, SaveNameCol("agn_agmt_no"), LastRow, SaveNameCol("item")) = RgbColor(39,95,101);
                RangeBackColor(TopRow, SaveNameCol("agn_agmt_no"), LastRow, SaveNameCol("item")) = RgbColor(193,196,232);
            }
        }
    }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet3_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount > 0) {
                RangeFontBold(TopRow, SaveNameCol("agn_agmt_no"), LastRow, SaveNameCol("item2")) = true;
                RangeFontColor(TopRow, SaveNameCol("agn_agmt_no"), LastRow, SaveNameCol("item2")) = RgbColor(39,95,101);
                RangeBackColor(TopRow, SaveNameCol("agn_agmt_no"), LastRow, SaveNameCol("item2")) = RgbColor(193,196,232);
            }
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

                case "rhq_cd_disp":    // RHQ를 변경시 Office목록을 setting
                    if (rhq_cd_disp.value == "") {
                        ComClearCombo(ar_ofc_cd);
                        ComClearCombo(agn_cd);
                        return;
                    }
                    rhq_cd.value = rhq_cd_disp.value;
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH18 + "&value0=" + rhq_cd.value + "&value1=" + ofcKndCd );
                    if (ACMXml2SelectItem(xmlStr, ar_ofc_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (ar_ofc_cd.options.length > 1) {
                            // rhq_cd와 같은 값이 선택되게 함
                            ar_ofc_cd.value = rhq_cd.value;
                        }
                        ar_ofc_cd.fireEvent("onchange");    // form.ar_ofc_cd 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                    }
                    break;

                case "ar_ofc_cd":    // Office를 변경시 Sub Office목록을 setting
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
