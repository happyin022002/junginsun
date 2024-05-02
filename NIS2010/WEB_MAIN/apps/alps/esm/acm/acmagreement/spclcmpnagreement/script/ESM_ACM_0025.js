/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0025.js
*@FileTitle : Compensation Agreement Rate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
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
     * @class ESM_ACM_0025 : ESM_ACM_0025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0025() {
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
            case "btn_popup":
                //var cust_cd = "US"; // Default 셋팅
                var url = "COM_ENS_041.do";
                var width = 775;
                var height = 484;
                var func = "setForwarder";
                var display = "1,0,1,1,1,1,1,1,1,1,1,1";

                ComOpenPopup(url, width, height, func, display, true, false);
                break;

            case "btn_retrieve":
                doActionIBSheet(shtObj,frmObj,IBSEARCH);
                break;

            case "btn_save":
                doActionIBSheet(shtObj, frmObj, IBSAVE);
                break;

            case "btn_downexcel":
                ComOpenWait(true);
                shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "ibflag");
                ComOpenWait(false);
                break;

            case "btn_copy":
                doActionIBSheet(shtObj, frmObj, IBCOPYROW);
                break;

            case "btn_add":
                doActionIBSheet(shtObj, frmObj, IBINSERT);
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

                    // 컬럼 헤더타이틀  //2015-07-16 박세연 [CHM-201537091] Special compensation 부분 계약 기준 'DEL' 추가
                    var HeadTitle0 = "Del.|STS|SEQ|Office|Kind|AGMT Customer|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|RTEU AMT|RFEU AMT|Specific CHG|||";
                    var HeadTitle1 = "|STS|SEQ|Office|Kind|AGMT Customer|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|RTEU AMT|RFEU AMT|Specific CHG|||";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle0), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN,  COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,   true,    "",                 false,    "",    dfNone,       0,     true,     true);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,   true,    "ibflag",           false,    "",    dfNone,       0,     false,    true);
                    InitDataProperty(0, cnt++ , dtSeq,        40,    daCenter,   true,    "",                 false,    "",    dfNone,       0,     true,     true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "spcl_ofc_cd",      false,    "",    dfNone,       0,     false,    true,     5);
                    InitDataProperty(0, cnt++ , dtCombo,      140,   daLeft,     true,    "cust_knd_cd",      false,    "",    dfNone,       0,     true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  120,   daCenter,   true,    "cust_cnt_seq",     true,     "",    dfNone,       0,     true,     true,     8);
                    InitDataProperty(0, cnt++ , dtData,       150,   daLeft,     true,    "spcl_cnt_cust_nm", false,    "",    dfNone,       0,     false,    false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "shpr_cnt_seq",     false,    "",    dfNone,       0,     true,     true,     8);
                    InitDataProperty(0, cnt++ , dtData,       150,   daLeft,     true,    "shpr_cnt_nm",      false,    "",    dfNone,       0,     false,    false);

                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "por_grp_tp_cd",    false,    "",    dfNone,       0,     true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "por_rout_cd",      false,    "",    dfNone,       0,     true,     true,     5);
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "pol_grp_tp_cd",    false,    "",    dfNone,       0,     true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "pol_rout_cd",      false,    "",    dfNone,       0,     true,     true,     5);
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "pod_grp_tp_cd",    false,    "",    dfNone,       0,     true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "pod_rout_cd",      false,    "",    dfNone,       0,     true,     true,     5);
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "del_grp_tp_cd",    false,    "",    dfNone,       0,     true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "del_rout_cd",      false,    "",    dfNone,       0,     true,     true,     5);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "fm_eff_dt",        false,    "",    dfDateYmd,    0,     true,     true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "to_eff_dt",        false,    "",    dfDateYmd,    0,     true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "sc_no",            false,    "",    dfNone,       0,     true,     true,     9);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "rfa_no",           false,    "",    dfNone,       0,     true,     true,     11);
                    InitDataProperty(0, cnt++ , dtCombo,      100,   daCenter,   true,    "cmdt_tp_cd",       false,    "",    dfNone,       0,     true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "cmdt_cd",          false,    "",    dfNone,       0,     true,     true,     6);
                    InitDataProperty(0, cnt++ , dtData,       140,   daLeft,     true,    "cmdt_nm",          false,    "",    dfNone,       0,     false,    false);
                    InitDataProperty(0, cnt++ , dtCombo,      120,   daLeft,     true,    "spcl_div_cd",      false,    "",    dfNone,       0,     true,     true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "spcl_bkg_rt",      false,    "",    dfFloat,      3,     true,     true,     15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "spcl_bx_amt",      false,    "",    dfFloat,      3,     true,     true,     15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "spcl_teu_amt",     false,    "",    dfFloat,      3,     true,     true,     15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "spcl_feu_amt",     false,    "",    dfFloat,      3,     true,     true,     15);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daRight,    true,    "spcl_rf_amt",      false,    "",    dfFloat,      3,     true,     true,     15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "spcl_rf_teu_amt",  false,    "",    dfFloat,      3,     true,     true,     15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "spcl_rf_feu_amt",  false,    "",    dfFloat,      3,     true,     true,     15);
                    InitDataProperty(0, cnt++ , dtData,       130,   daLeft,     true,    "spcl_chg_ctnt",    false,    "",    dfNone,       0,     true,     true,     50);

                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,   true,    "cust_cnt_cd");
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,   true,    "cust_seq");
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,   true,    "spcl_agmt_seq");

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "por_grp_tp_cd", proTpText, proTpCode);
                    InitDataCombo(0, "pol_grp_tp_cd", proTpText, proTpCode);
                    InitDataCombo(0, "pod_grp_tp_cd", proTpText, proTpCode);
                    InitDataCombo(0, "del_grp_tp_cd", proTpText, proTpCode);
                    InitDataCombo(0, "cmdt_tp_cd", "*|Rep|Common", "*|2|3");
                    InitDataCombo(0, "spcl_div_cd", ffDivCdText, ffDivCdCode);
                    InitDataCombo(0, "cust_knd_cd", customerKindCdText, customerKindCdCode);

                    InitDataValid(0, "spcl_ofc_cd", vtEngUpOnly);    // 영대문자만
                    InitDataValid(0, "cust_cnt_seq", vtEngUpOther, "0123456789");    // 영대문자, 숫자만 입력되도록 설정
                    InitDataValid(0, "shpr_cnt_seq", vtEngUpOther, "0123456789*");    // 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "por_rout_cd", vtEngUpOther, "*");    // 영대문자, * 만 입력되도록 설정
                    InitDataValid(0, "pol_rout_cd", vtEngUpOther, "*");    // 영대문자, * 만 입력되도록 설정
                    InitDataValid(0, "pod_rout_cd", vtEngUpOther, "*");    // 영대문자, * 만 입력되도록 설정
                    InitDataValid(0, "del_rout_cd", vtEngUpOther, "*");    // 영대문자, * 만 입력되도록 설정
                    InitDataValid(0, "sc_no", vtEngUpOther, "0123456789*");    // 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "rfa_no", vtEngUpOther, "0123456789*");    // 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "cmdt_cd", vtNumericOther, "*");    // 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "spcl_chg_ctnt", vtEngUpOther, ",");    // 영대문자, 콤마(,) 만 입력되도록 설정

                    ShowButtonImage = 3;
                    WaitImageVisible = false;
                    HeadRowHeight = 24;
                    break;
            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        var newRow = -1;
        switch (sAction) {

            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 spcl_ofc_cd를 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.spcl_ofc_cd, "value0", "value0", true);
                break;

            case IBSEARCH:    // 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;

                if (frmObj.deleted_customer.checked) {
                    frmObj.delt_flg.value = "Y";
                } else {
                    frmObj.delt_flg.value = "N";
                }
                shtObj.DoSearch("ESM_ACM_0025GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBINSERT:      // 입력
                newRow = shtObj.DataInsert();
                shtObj.CellValue2(newRow, "spcl_ofc_cd") = frmObj.spcl_ofc_cd.value;
                shtObj.CellValue2(newRow, "cust_knd_cd") = "R";
                shtObj.CellValue2(newRow, "shpr_cnt_seq") = "*";
                shtObj.CellValue2(newRow, "por_grp_tp_cd") = "*";
                shtObj.CellValue2(newRow, "por_rout_cd") = "*";
                shtObj.CellValue2(newRow, "pol_grp_tp_cd") = "*";
                shtObj.CellValue2(newRow, "pol_rout_cd") = "*";
                shtObj.CellValue2(newRow, "pod_grp_tp_cd") = "*";
                shtObj.CellValue2(newRow, "pod_rout_cd") = "*";
                shtObj.CellValue2(newRow, "del_grp_tp_cd") = "*";
                shtObj.CellValue2(newRow, "del_rout_cd") = "*";
                shtObj.CellValue2(newRow, "fm_eff_dt") = "20000101";
                shtObj.CellValue2(newRow, "to_eff_dt") = "29991231";
                shtObj.CellValue2(newRow, "sc_no") = "*";
                shtObj.CellValue2(newRow, "rfa_no") = "*";
                shtObj.CellValue2(newRow, "cmdt_tp_cd") = "*";
                shtObj.CellValue2(newRow, "cmdt_cd") = "*";
                shtObj.CellValue2(newRow, "spcl_div_cd") = "CS";
                setBrogDivCd(shtObj, newRow, "spcl_div_cd");
                break;

            case IBCOPYROW:    //행 복사
                newRow = shtObj.DataCopy();
                setBrogDivCd(shtObj, newRow, "spcl_div_cd");
                break;

            case IBSAVE:
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0025GS.do", FormQueryString(frmObj));
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
                case "spcl_chg_ctnt":
                    //ACMCheckBox_OnClick(Param, Hidden);    // CoAcm.js에 정의
                    //ACMCheckBox_OnClick(frmObj.ac_sts_div, frmObj.ac_sts_cd);    // CoAcm.js에 정의

                    //SQL -> IN (${arr_val}).......

                    var ffChgCtntArray = new Array();
                    ffChgCtntArray = Value;
                    var ffChgCtntArraySplit = ffChgCtntArray.split(",");
                    var ffChgCtntVal = "";
                    for(j=0;j<ffChgCtntArraySplit.length; j++){
                        if(j < ffChgCtntArraySplit.length-1){
                            ffChgCtntVal += ffChgCtntArraySplit[j]+"','";
                        }else{
                            ffChgCtntVal += ffChgCtntArraySplit[j];
                        }
                    }

                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH20 + "&value0=" + "'"+ffChgCtntVal+"'"+ "&value1=" + ffChgCtntArraySplit.length);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        Cellvalue2(Row, "spcl_chg_ctnt") = "";
                        SelectCell(Row, Col, true, "");
                    } else {
                        //ERR_CNT 가 0 일경우엔 저장 진행, 0 이 아니면 ERR MSG 리턴 !!
                        if (ComGetEtcData(xmlStr, "err_cnt") == "0") {
                        } else {
                            //"{?msg1} of {?msg2} row is invalid."
                            ComShowCodeMessage("ACM00013", "["+Value+"] of ["+ Row+ "] row is invalid.");

                            //Cellvalue2(Row, "spcl_chg_ctnt") = "";
                            SelectCell(Row, Col, true, "");
                        }
                    }
                    break;

                case "cust_cnt_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        Cellvalue2(Row, "spcl_cnt_cust_nm") = "";
                        SelectCell(Row, Col, true, "");
                        return;
                    }
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        Cellvalue2(Row, "spcl_cnt_cust_nm") = "";
                        SelectCell(Row, Col, true, "");
                    } else {
                        CellValue2(Row, "spcl_cnt_cust_nm") = ComGetEtcData(xmlStr, "cust_lgl_eng_nm");
                    }
                    break;

                case "shpr_cnt_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        Cellvalue2(Row, "shpr_cnt_nm") = "";
                        SelectCell(Row, Col, true, "");
                        return;
                    }
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        Cellvalue2(Row, "shpr_cnt_nm") = "";
                        SelectCell(Row, Col, true, "");
                    } else {
                        CellValue2(Row, "shpr_cnt_nm") = ComGetEtcData(xmlStr, "cust_lgl_eng_nm");
                    }
                    break;

                case "spcl_div_cd":
                    if ( Value == "BA" || Value == "BF" ) {
                        CellValue2(Row, "spcl_bx_amt") = 0;
                        CellValue2(Row, "spcl_teu_amt") = 0;
                        CellValue2(Row, "spcl_feu_amt") = 0;
                        CellValue2(Row, "spcl_rf_teu_amt") = 0;
                        CellValue2(Row, "spcl_rf_feu_amt") = 0;
                        CellValue2(Row, "spcl_chg_ctnt") = "";

                        CellEditable(Row, "spcl_bkg_rt") = true;
                        CellEditable(Row, "spcl_bx_amt") = false;
                        CellEditable(Row, "spcl_teu_amt") = false;
                        CellEditable(Row, "spcl_feu_amt") = false;
                        CellEditable(Row, "spcl_rf_teu_amt") = false;
                        CellEditable(Row, "spcl_rf_feu_amt") = false;
                        CellEditable(Row, "spcl_chg_ctnt") = false;

                    } else if( Value == "BS" ) {
                        CellValue2(Row, "spcl_bx_amt") = 0;
                        CellValue2(Row, "spcl_teu_amt") = 0;
                        CellValue2(Row, "spcl_feu_amt") = 0;
                        CellValue2(Row, "spcl_rf_teu_amt") = 0;
                        CellValue2(Row, "spcl_rf_feu_amt") = 0;

                        CellEditable(Row, "spcl_bkg_rt") = true;
                        CellEditable(Row, "spcl_bx_amt") = false;
                        CellEditable(Row, "spcl_teu_amt") = false;
                        CellEditable(Row, "spcl_feu_amt") = false;
                        CellEditable(Row, "spcl_rf_teu_amt") = false;
                        CellEditable(Row, "spcl_rf_feu_amt") = false;
                        CellEditable(Row, "spcl_chg_ctnt") = true;

                    } else if( Value == "CA" ) {
                        CellValue2(Row, "spcl_bkg_rt") = 0;
                        CellValue2(Row, "spcl_teu_amt") = 0;
                        CellValue2(Row, "spcl_feu_amt") = 0;
                        CellValue2(Row, "spcl_rf_teu_amt") = 0;
                        CellValue2(Row, "spcl_rf_feu_amt") = 0;
                        CellValue2(Row, "spcl_chg_ctnt") = "";

                        CellEditable(Row, "spcl_bkg_rt") = false;
                        CellEditable(Row, "spcl_bx_amt") = true;
                        CellEditable(Row, "spcl_teu_amt") = false;
                        CellEditable(Row, "spcl_feu_amt") = false;
                        CellEditable(Row, "spcl_rf_teu_amt") = false;
                        CellEditable(Row, "spcl_rf_feu_amt") = false;
                        CellEditable(Row, "spcl_chg_ctnt") = false;

                    } else if( Value == "CS" ) {
                        CellValue2(Row, "spcl_bkg_rt") = 0;
                        CellValue2(Row, "spcl_bx_amt") = 0;
                        CellValue2(Row, "spcl_chg_ctnt") = "";

                        CellEditable(Row, "spcl_bkg_rt") = false;
                        CellEditable(Row, "spcl_bx_amt") = false;
                        CellEditable(Row, "spcl_teu_amt") = true;
                        CellEditable(Row, "spcl_feu_amt") = true;
                        CellEditable(Row, "spcl_rf_teu_amt") = true;
                        CellEditable(Row, "spcl_rf_feu_amt") = true;
                        CellEditable(Row, "spcl_chg_ctnt") = false;
                    }
                    break;

                case "cmdt_cd":
                    var cmdt_tp = ComTrim(shtObj.CellValue(Row, "cmdt_tp_cd"));
                    if(cmdt_tp == "*") {
                         //ComShowCodeMessage("COM12113", "Commodity Type", "", "");
                         //Cellvalue2(Row, Col) = "*";
                         //SelectCell (Row, parseInt(Col)-1 );
                         return;
                    }
                    var xmlStr = GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH19 + "&value0=" + cmdt_tp + "&value1=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                        SelectCell(Row, Col+1, true, "");
                        SelectCell(Row, Col, true, "");
                    } else {
                        var rsltCmdtNm = ComGetEtcData(xmlStr, "cmdt_nm");
                        if (rsltCmdtNm != "") {
                            Cellvalue2(Row, "cmdt_nm") = rsltCmdtNm;
                        } else {
                            // Commodity Code is invalid.
                            ComShowCodeMessage("COM132201", "Commodity Code");
                            SelectCell(Row, Col+1, true, "");
                            SelectCell(Row, Col, true, "");
                        }
                    }
                    break;

                case "cmdt_tp_cd":
                    SelectCell(Row, Col+1, true, "");
                    SelectCell(Row, Col+2, true, "");
                    break;
            }
        }
    }


    /**
     * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
     */
    function setForwarder(rowArray, row, col) {
        var colArray = rowArray[0];
        document.form.cust_cnt_seq.value = colArray[3];
    }

    /**
     * Type(spcl_div_cd) 입력시 Format 적용
     */
    function setBrogDivCd(shtObj, Row, Col) {

        with(shtObj) {

            var value = CellValue(Row, Col);

            if ( value == "BA" || value == "BF" ) {
                CellValue2(Row, "spcl_bx_amt") = 0;
                CellValue2(Row, "spcl_teu_amt") = 0;
                CellValue2(Row, "spcl_feu_amt") = 0;
                CellValue2(Row, "spcl_rf_teu_amt") = 0;
                CellValue2(Row, "spcl_rf_feu_amt") = 0;
                CellValue2(Row, "spcl_chg_ctnt") = "";

                CellEditable(Row, "spcl_bkg_rt") = true;
                CellEditable(Row, "spcl_bx_amt") = false;
                CellEditable(Row, "spcl_teu_amt") = false;
                CellEditable(Row, "spcl_feu_amt") = false;
                CellEditable(Row, "spcl_rf_teu_amt") = false;
                CellEditable(Row, "spcl_rf_feu_amt") = false;
                CellEditable(Row, "spcl_chg_ctnt") = false;

            } else if( value == "BS" ) {
                CellValue2(Row, "spcl_bx_amt") = 0;
                CellValue2(Row, "spcl_teu_amt") = 0;
                CellValue2(Row, "spcl_feu_amt") = 0;
                CellValue2(Row, "spcl_rf_teu_amt") = 0;
                CellValue2(Row, "spcl_rf_feu_amt") = 0;

                CellEditable(Row, "spcl_bkg_rt") = true;
                CellEditable(Row, "spcl_bx_amt") = false;
                CellEditable(Row, "spcl_teu_amt") = false;
                CellEditable(Row, "spcl_feu_amt") = false;
                CellEditable(Row, "spcl_rf_teu_amt") = false;
                CellEditable(Row, "spcl_rf_feu_amt") = false;
                CellEditable(Row, "spcl_chg_ctnt") = true;

            } else if( value == "CA" ) {
                CellValue2(Row, "spcl_bkg_rt") = 0;
                CellValue2(Row, "spcl_teu_amt") = 0;
                CellValue2(Row, "spcl_feu_amt") = 0;
                CellValue2(Row, "spcl_rf_teu_amt") = 0;
                CellValue2(Row, "spcl_rf_feu_amt") = 0;
                CellValue2(Row, "spcl_chg_ctnt") = "";

                CellEditable(Row, "spcl_bkg_rt") = false;
                CellEditable(Row, "spcl_bx_amt") = true;
                CellEditable(Row, "spcl_teu_amt") = false;
                CellEditable(Row, "spcl_feu_amt") = false;
                CellEditable(Row, "spcl_rf_teu_amt") = false;
                CellEditable(Row, "spcl_rf_feu_amt") = false;
                CellEditable(Row, "spcl_chg_ctnt") = false;

            } else if( value == "CS" ) {
                CellValue2(Row, "spcl_bkg_rt") = 0;
                CellValue2(Row, "spcl_bx_amt") = 0;
                CellValue2(Row, "spcl_chg_ctnt") = "";

                CellEditable(Row, "spcl_bkg_rt") = false;
                CellEditable(Row, "spcl_bx_amt") = false;
                CellEditable(Row, "spcl_teu_amt") = true;
                CellEditable(Row, "spcl_feu_amt") = true;
                CellEditable(Row, "spcl_rf_teu_amt") = true;
                CellEditable(Row, "spcl_rf_feu_amt") = true;
                CellEditable(Row, "spcl_chg_ctnt") = false;
            }
        }
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

                case "cust_cnt_seq":
                case "shpr_cnt_seq":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_041.do", 775, 445, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;

                case "por_rout_cd":
                case "pol_rout_cd":
                case "pod_rout_cd":
                case "del_rout_cd":
                    var iWidth = "";
                    var iHeight = "";
                    var sUrl = "";

                    switch (CellValue(Row, parseInt(Col)-1)) {
                        case "1":
                            iWidth = 306;
                            iHeight = 382;
                            sUrl = "COM_ENS_0H1.do";
                            break;
                        case "2":
                            iWidth = 406;
                            iHeight = 422;
                            sUrl = "COM_ENS_0I1.do";
                            break;
                        case "3":
                            iWidth = 566;
                            iHeight = 484;
                            sUrl = "COM_ENS_0M1.do";
                            break;
                        case "4":
                            iWidth = 526;
                            iHeight = 454;
                            sUrl = "COM_ENS_0J1.do";
                            break;
                        case "5":
                            iWidth = 775;
                            iHeight = 482;
                            sUrl = "COM_ENS_051.do";
                            break;
                        default:
                            if(ColSaveName(Col) == "por_rout_cd") {
                                ComShowMessage(ComGetMsg("COM12113", "POR TYPE", "", ""));
                            } else if (ColSaveName(Col) == "pol_rout_cd") {
                                ComShowMessage(ComGetMsg("COM12113", "POL TYPE", "", ""));
                            } else if (ColSaveName(Col) == "pod_rout_cd") {
                                ComShowMessage(ComGetMsg("COM12113", "POD TYPE", "", ""));
                            } else if (ColSaveName(Col) == "del_rout_cd") {
                                ComShowMessage(ComGetMsg("COM12113", "DEL TYPE", "", ""));
                            }
                            SelectCell(Row, parseInt(Col)-1);
                            return false;
                            break;
                    }

                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup(sUrl, iWidth, iHeight, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;

                case "cmdt_cd":
                    var iWidth = 0;
                    var iHeight = 0;
                    var sUrl = "";
                    var func = "";

                    switch (CellValue(Row, parseInt(Col)-1)) {
                        case "2":
                            iWidth = 506;
                            iHeight = 382;
                            sUrl = "COM_ENS_0K1.do";
                            break;
                        case "3":
                            iWidth = 775;
                            iHeight = 482;
                            sUrl = "COM_ENS_011.do";
                            break;
                        default:
                            ComShowMessage(ComGetMsg("COM12113", "Commodity Type", "", ""));
                            SelectCell(Row, parseInt(Col)-1);
                            return false;
                            break;
                    }

                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup(sUrl, iWidth, iHeight, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                    break;

                case "sc_no":
                    var bkgNo = "";
                    var bkgVvd = "";
                    var porCd = "";
                    var delCd = "";
                    var sCustCntCd = "";
                    var sCustSeq = "";
                    var cCustCntCd = "";
                    var cCustSeq = "";
                    document.form.rowNum.value = Row;
                    document.form.colNum.value = Col;

                    var func = "";
                    var display = "1,0,1,1,1,1,1,1,1,1,1,1";
                    var url = "";
                    func = "sheet1_setSheetData4";
                    url = "ESM_BKG_0655.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&func="+func;

                    ComOpenPopup(url, 860, 475, func, display, true, false, Row, Col);
                    break;

                case "rfa_no":
                    var bkgNo = "";
                    var bkgVvd = "";
                    var porCd = "";
                    var delCd = "";
                    var sCustCntCd = "";
                    var sCustSeq = "";
                    var cCustCntCd = "";
                    var cCustSeq = "";
                    document.form.rowNum.value = Row;
                    document.form.colNum.value = Col;

                    var func = "";
                    var display = "1,0,1,1,1,1,1,1,1,1,1,1";
                    var url = "";
                    func = "sheet1_setSheetData4";
                    url = "ESM_BKG_0654.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&func="+func;

                    ComOpenPopup(url, 860, 475, func, display, true, false, Row, Col);
                    break;
            }
        }
    }


    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData[0] : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData[0].length > 0 ) {
            with (sheetObjects[ShtIdx]) {
                switch (ColSaveName(Col)) {

                    // sheet1_setFFCntSeq
                    case "cust_cnt_seq":
                    case "shpr_cnt_seq":
                        CellValue2(Row, Col) = aryPopupData[0][3].substring(0, 2) + ComLpad(aryPopupData[0][3].substring(2), 6, "0");
                        CellValue2(Row, parseInt(Col)+1) = aryPopupData[0][4];
                        break;

                    // sheet1_setSheetData2
                    case "por_rout_cd":
                    case "pol_rout_cd":
                    case "pod_rout_cd":
                    case "del_rout_cd":
                        CellValue(Row, Col) = aryPopupData[0][3];
                        break;

                    // sheet1_setSheetData3
                    case "cmdt_cd":
                        switch (CellValue(Row, parseInt(Col)-1)) {
                            case "2":
                                CellValue(Row, Col) = aryPopupData[0][3];
                                CellValue(Row, parseInt(Col)+1) = aryPopupData[0][4];
                                break;

                            case "3":
                                CellValue(Row, Col) = aryPopupData[0][3];
                                CellValue(Row, parseInt(Col)+1) = aryPopupData[0][4];
                                break;
                        }
                        break;
                }
            }
        }
    }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            for(var i=1; i<=shtObj.LastRow; i++) {
                if (shtObj.CellValue(i, "spcl_div_cd") == "BA" || shtObj.CellValue(i, "spcl_div_cd") == "BF") {
                    //shtObj.CellValue2(i, "ff_bx_amt") = 0;
                    shtObj.CellValue2(i, "spcl_bx_amt") = 0;
                    shtObj.CellValue2(i, "spcl_teu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_feu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_rf_teu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_rf_feu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_chg_ctnt") = "";

                    shtObj.CellEditable(i, "spcl_bkg_rt") = true;
                    shtObj.CellEditable(i, "spcl_bx_amt") = false;
                    shtObj.CellEditable(i, "spcl_teu_amt") = false;
                    shtObj.CellEditable(i, "spcl_feu_amt") = false;
                    shtObj.CellEditable(i, "spcl_rf_teu_amt") = false;
                    shtObj.CellEditable(i, "spcl_rf_feu_amt") = false;
                    shtObj.CellEditable(i, "spcl_chg_ctnt") = false;

                } else if (shtObj.CellValue(i, "spcl_div_cd") == "BS") {
                    shtObj.CellValue2(i, "spcl_bx_amt") = 0;
                    shtObj.CellValue2(i, "spcl_teu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_feu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_rf_teu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_rf_feu_amt") = 0;

                    shtObj.CellEditable(i, "spcl_bkg_rt") = true;
                    shtObj.CellEditable(i, "spcl_bx_amt") = false;
                    shtObj.CellEditable(i, "spcl_teu_amt") = false;
                    shtObj.CellEditable(i, "spcl_feu_amt") = false;
                    shtObj.CellEditable(i, "spcl_rf_teu_amt") = false;
                    shtObj.CellEditable(i, "spcl_rf_feu_amt") = false;
                    shtObj.CellEditable(i, "spcl_chg_ctnt") = true;

                } else if (shtObj.CellValue(i, "spcl_div_cd") == "CA") {
                    shtObj.CellValue2(i, "spcl_bkg_rt") = 0;
                    shtObj.CellValue2(i, "spcl_teu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_feu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_rf_teu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_rf_feu_amt") = 0;
                    shtObj.CellValue2(i, "spcl_chg_ctnt") = "";

                    shtObj.CellEditable(i, "spcl_bkg_rt") = false;
                    shtObj.CellEditable(i, "spcl_bx_amt") = true;
                    shtObj.CellEditable(i, "spcl_teu_amt") = false;
                    shtObj.CellEditable(i, "spcl_feu_amt") = false;
                    shtObj.CellEditable(i, "spcl_rf_teu_amt") = false;
                    shtObj.CellEditable(i, "spcl_rf_feu_amt") = false;
                    shtObj.CellEditable(i, "spcl_chg_ctnt") = false;

                } else if (shtObj.CellValue(i, "spcl_div_cd") == "CS") {
                    shtObj.CellValue2(i, "spcl_bkg_rt") = 0;
                    shtObj.CellValue2(i, "spcl_bx_amt") = 0;
                    shtObj.CellValue2(i, "spcl_chg_ctnt") = "";

                    shtObj.CellEditable(i, "spcl_bkg_rt") = false;
                    shtObj.CellEditable(i, "spcl_bx_amt") = false;
                    shtObj.CellEditable(i, "spcl_teu_amt") = true;
                    shtObj.CellEditable(i, "spcl_feu_amt") = true;
                    shtObj.CellEditable(i, "spcl_rf_teu_amt") = true;
                    shtObj.CellEditable(i, "spcl_rf_feu_amt") = true;
                    shtObj.CellEditable(i, "spcl_chg_ctnt") = false;
                }
                shtObj.RowStatus(i) = "";
            }
        }
    }


     /**
     * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
     */
    function sheet1_setSheetData4(rowArray, row, col) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var colArray = rowArray[0];
        row = formObj.rowNum.value;
        col = formObj.colNum.value;

        sheetObj.CellValue2(row, col) = colArray[5];
    }

/* 개발자 작업 끝 */