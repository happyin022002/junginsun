/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0024.js
*@FileTitle : FAC Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.03 김봉균
* 1.0 Creation
* 2013.02.06 이윤정 [CHM-201323135] All in Rate 에 상관없이 Type 조정할 수 있도록 로직 변경 
* 2013.05.13 박다은 [CHM-201324643] FAC 계약 저장 Logic 변경 요청
* 2013.06.24 이윤정 [CHM-201325104] FAC Agreement DEL check box 삭제 요청
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
     * @class ESM_ACM_0024 : ESM_ACM_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0024() {
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

            case "btn_retrieve":
                doActionIBSheet(shtObj,frmObj,IBSEARCH);
                break;

            case "btn_save":
                doActionIBSheet(shtObj, frmObj, IBSAVE);
                break;

            case "btn_request":
                doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC01);
                break;

            case "btn_approve":
                doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC02);
                break;

            case "btn_reject":
                doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC03);
                break;

            case "btn_uploadexcel":
                if (!ComChkValid(frmObj)) return;//조건절 office 설정 여부 체크
                shtObj.LoadExcel();
                break;

            case "btn_downexcel":
                ComOpenWait(true);
                shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "ibflag|check");
                ComOpenWait(false);
                break;

            case "btn_copy":
                var newRow = shtObj.DataCopy();
                setCellData( shtObj, newRow );
                setCellEditable( shtObj, newRow );
                setFacDivCd( shtObj, newRow, "fac_div_cd" );
                checkSglFlg( shtObj, newRow );
                break;

            case "btn_add":
                if (!ComChkValid(frmObj)) return;//조건절 office 설정 여부 체크

                var newRow = shtObj.DataInsert();
                shtObj.CellValue2(newRow, "fac_ofc_cd") = frmObj.ar_ofc_cd.value; // 조회 조건의 Office를 fac_ofc_cd로 설정한다.
                shtObj.CellValue2(newRow, "shpr_cnt_seq") = "*";
                shtObj.CellValue2(newRow, "por_rout_cd") = "*";
                shtObj.CellValue2(newRow, "pol_rout_cd") = "*";
                shtObj.CellValue2(newRow, "pod_rout_cd") = "*";
                shtObj.CellValue2(newRow, "del_rout_cd") = "*";
                shtObj.CellValue2(newRow, "svc_scp_cd") = "*";
                shtObj.CellValue2(newRow, "fm_eff_dt") = "20000101";
                shtObj.CellValue2(newRow, "to_eff_dt") = "29991231";
                shtObj.CellValue2(newRow, "sc_no") = "*";
                shtObj.CellValue2(newRow, "rfa_no") = "*";
                shtObj.CellValue2(newRow, "cmdt_cd") = "*";
                //shtObj.CellValue(newRow, "cmdt_nm") = "*";
                shtObj.CellValue2(newRow, "fac_sts_cd") = "RS";//New
                shtObj.CellEditable(newRow, "check") = false;

                setFacDivCd( shtObj, newRow, "fac_div_cd" );
                // F/Forwarder 디폴트 값으로 설정
                doActionIBSheet(shtObj,frmObj,IBINSERT,newRow);
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

                    // 컬럼 헤더타이틀
                    var HeadTitle0 = "CHK|STS|SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|RCV Term|DEL Term|S.F.|D.F.|All in Rate|Scope|Eff.Date|Exp.Date|SC No.|RFA No.|Commodity TP|Commodity|Commodity Detail|Type|Rate|Special Rate1|Special Rate1|Special Rate2|Special Rate2|Cur|BL AMT|Box AMT|TEU AMT|FEU AMT|RTEU AMT|RFEU AMT|STEU AMT|SFEU AMT|Charge(Only for BS)|Status|Request ID|Approval ID|Approval Date|Remark||";
                    var HeadTitle1 = "|STS|SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|DEL TP|DEL|RCV Term|DEL Term|S.F.|D.F.|All in Rate|Scope|Eff.Date|Exp.Date|SC No.|RFA No.|Commodity TP|Commodity|Commodity Detail|Type|Rate|CNTR TP|Rate|CNTR TP|Rate|Cur|BL AMT|Box AMT|TEU AMT|FEU AMT|RTEU AMT|RFEU AMT|STEU AMT|SFEU AMT|Charge(Only for BS)|Status|Request ID|Approval ID|Approval Date|Remark||";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 5, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, false);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH,    DATAALIGN,  COLMERGE, SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtDelCheck,   40,    daCenter,   true,    "delchk");
                    InitDataProperty(0, cnt++,  dtCheckBox,   40,    daCenter,   true,    "check");
                    InitDataProperty(0, cnt++,  dtStatus,     30,    daCenter,   true,    "ibflag");
                    InitDataProperty(0, cnt++,  dtSeq,        30,    daCenter,   true,    "seq");
                    InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "frt_cnt_seq",            true,     "",    dfNone,       0,    false,    true,       8);
                    InitDataProperty(0, cnt++ , dtData,       150,   daLeft,     true,    "ff_lgl_eng_nm",          false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "shpr_cnt_seq",           false,    "",    dfNone,       0,    true,     true,       8);
                    InitDataProperty(0, cnt++ , dtData,       150,   daLeft,     true,    "shpr_lgl_eng_nm",        false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "por_grp_tp_cd",          false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "por_rout_cd",            false,    "",    dfNone,       0,    true,     true,       5);
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "pol_grp_tp_cd",          false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "pol_rout_cd",            false,    "",    dfNone,       0,    true,     true,       5);
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "pod_grp_tp_cd",          false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "pod_rout_cd",            false,    "",    dfNone,       0,    true,     true,       5);
                    InitDataProperty(0, cnt++ , dtCombo,      90,    daCenter,   true,    "del_grp_tp_cd",          false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "del_rout_cd",            false,    "",    dfNone,       0,    true,     true,       5);
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   true,    "bkg_rcv_term_cd",        false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   true,    "bkg_de_term_cd",         false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   true,    "fac_sgl_flg",            false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,   true,    "fac_dbl_flg",            false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   true,    "all_in_rt_cd",           false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "svc_scp_cd",             false,    "",    dfNone,       0,    true,     true,	    3);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "fm_eff_dt",              false,    "",    dfDateYmd,    0,    true,     true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "to_eff_dt",              false,    "",    dfDateYmd,    0,    true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,   true,    "sc_no",                  false,    "",    dfNone,       0,    true,     true,       20);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  100,   daCenter,   true,    "rfa_no",                 false,    "",    dfNone,       0,    true,     true,       11);
                    InitDataProperty(0, cnt++ , dtCombo,      100,   daCenter,   true,    "cmdt_tp_cd",             false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daCenter,   true,    "cmdt_cd",                false,    "",    dfNone,       0,    true,     true,       6);
                    InitDataProperty(0, cnt++ , dtData,       140,   daLeft,     true,    "cmdt_nm",                false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++ , dtCombo,      130,   daCenter,   true,    "fac_div_cd",             false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "bkg_fac_rt",             false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daLeft,     false,   "fac_spcl_cntr_tp_ctnt1", false,    "",    dfNone,       3,    true,     true,       50);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,   "fac_spcl_cntr_rt1",      false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  70,    daLeft,     false,   "fac_spcl_cntr_tp_ctnt2", false,    "",    dfNone,       3,    true,     true,       50);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,   "fac_spcl_cntr_rt2",      false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   true,    "curr_cd",                false,    "",    dfNone,       3,    true,     true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "bkg_fac_bl_amt",         false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_bx_amt",             false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_teu_amt",            false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_feu_amt",            false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_rf_teu_amt",         false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_rf_feu_amt",         false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_spcl_teu_amt",       false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtData,       70,    daRight,    true,    "fac_spcl_feu_amt",       false,    "",    dfFloat,      3,    true,     true,       15);
                    InitDataProperty(0, cnt++ , dtData,      130,    daLeft,     true,    "fac_chg_ctnt",           false,    "",    dfNone,       0,    true,     true,	   50);
                    InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,   true,    "fac_sts_cd",             false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++ , dtData,       70,    daLeft,     true,    "fac_rqst_usr_id",        false,    "",    dfNone,       0,    false,    false,      20);
                    InitDataProperty(0, cnt++ , dtData,       70,    daLeft,     true,    "fac_apro_usr_id",        false,    "",    dfNone,       0,    false,    false,      20);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   true,    "fac_apro_dt",            false,    "",    dfDateYmd,    0,    false,    false);
                    InitDataProperty(0, cnt++ , dtData,      130,    daLeft,     true,    "fac_rmk",                false,    "",    dfNone,       0,    true,     true,       1000);

                    InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "fac_ofc_cd",             false,     "",   dfNone,       0,    false,    true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,    daLeft,     true,    "fac_agmt_seq",           false,     "",   dfNone,       0,    false,    true);

                    // sheet내 combo설정 (jsp에서 공통코드 combo string 추출)
                    InitDataCombo(0, "por_grp_tp_cd", proTpText, proTpCode, "");
                    InitDataCombo(0, "pol_grp_tp_cd", proTpText, proTpCode, "");
                    InitDataCombo(0, "pod_grp_tp_cd", proTpText, proTpCode, "");
                    InitDataCombo(0, "del_grp_tp_cd", proTpText, proTpCode, "");
                    InitDataCombo (0,"cmdt_tp_cd","*|Rep|Common","*|2|3");
                    InitDataCombo(0, "bkg_rcv_term_cd", "*|" + bkgRcvTermCdText, "*|" + bkgRcvTermCdCode, "");
                    InitDataCombo(0, "bkg_de_term_cd", "*|" + bkgDeTermCdText, "*|" + bkgDeTermCdCode, "");
                    InitDataCombo (0,"fac_sgl_flg","Y|N","Y|N","N");
                    InitDataCombo (0,"fac_dbl_flg","Y|N","Y|N","N");
                    InitDataCombo (0,"all_in_rt_cd","Y|N","Y|N","N");
                    InitDataCombo (0,"curr_cd","USD|EUR","USD|EUR","USD");
                    InitDataCombo (0,"fac_sts_cd","New|Requested|Approved|Rejected","RS|RR|PS|RE");
                    InitDataCombo(0, "fac_div_cd", facDivCdText, facDivCdCode, "");

                    //Validation 체크
                    InitDataValid(0, "frt_cnt_seq", vtEngUpOther, "0123456789");	// 영대문자, 숫자만 입력되도록 설정
                    InitDataValid(0, "shpr_cnt_seq", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "por_rout_cd", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "pol_rout_cd", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "pod_rout_cd", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "del_rout_cd", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "svc_scp_cd", vtEngUpOther, "*");	// 영대문자, * 만 입력되도록 설정
                    InitDataValid(0, "sc_no", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "rfa_no", vtEngUpOther, "0123456789*");	// 영대문자, 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "cmdt_cd", vtNumericOther, "*");	// 숫자, * 만 입력되도록 설정
                    InitDataValid(0, "fac_chg_ctnt", vtEngUpOther, ","); // 영대문자, 콤마(,) 만 입력되도록 설정

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
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        var newRow = -1;
        switch (sAction) {

            case SEARCH01:       // agn_cd 조회
                // 로그인한 사용자의 rhq_cd로 agn_cd를 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH23);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);    // CoAcm.js에 정의
                break;

            case IBSEARCH:       	// 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0024GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                if (!ComChkValid(frmObj)) return;
                //[CHM-201324643][CO] FAC 계약 저장 Logic 변경 요청
                //if (!validateData(shtObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_0024GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01:      //REQUEST
                if (!ComChkValid(frmObj)) return;
                frmObj.f_cmd.value = MULTI01;
                var cnt = checkData("RR");
                if( cnt > 0 ) {
                    if(ComShowCodeConfirm("ACM00026", "Request "+cnt, "request") == 1) {
                        openStaffInfo(cnt);
                    }
                } else {
                    ComShowCodeMessage("ACM00012", "request");
                    //ComShowMessage("There is no contents to request");
                }
                break;

            case IBSEARCH_ASYNC02:      //APPROVE
                if (!ComChkValid(frmObj)) return;
                frmObj.f_cmd.value = MULTI02;
                var cnt = checkData("PS");
                if( cnt > 0 ) {
                    if(ComShowCodeConfirm("ACM00026", "Approval "+cnt, "approve") == 1) {
                        shtObj.DoSave("ESM_ACM_0024GS.do", FormQueryString(frmObj), "check", false);
                    }
                } else {
                    ComShowCodeMessage("ACM00012", "approve");
                    //ComShowMessage("There is no contents to approve");
                }
                break;

            case IBSEARCH_ASYNC03:        //REJECT
                if (!ComChkValid(frmObj)) return;
                frmObj.f_cmd.value = MULTI03;
                var cnt = checkData("RE");
                if( cnt > 0 ) {
                    if(ComShowCodeConfirm("ACM00026", "Reject "+cnt, "reject") == 1) {
                        shtObj.DoSave("ESM_ACM_0024GS.do", FormQueryString(frmObj), "check", false);
                    }
                } else {
                    ComShowCodeMessage("ACM00012", "reject");
                    //ComShowMessage("There is no contents to reject");
                }
                break;

            case IBINSERT:      // 입력
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + frmObj.ofc_cd.value);
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                //추가된 Row에 데이터 할당
                addRowData(CondParam, ComGetEtcData(xmlStr, "loc_cd").substring(0, 2));//(newRow, cntCd)
                break;

        }

        //Status에 따른 컬럼별 편집모드 설정
        var mod = frmObj.mod.value;
        var rows = shtObj.RowCount + 2;

        for(var i=2; i<rows; i++){
            var sts = shtObj.CellValue(i,"fac_sts_cd");
            var div = shtObj.CellValue(i,"fac_div_cd");

            var facSqlFlg  = shtObj.CellValue(i,"fac_sgl_flg");
            var facDblFlg  = shtObj.CellValue(i,"fac_dbl_flg");
            var allInRtCd  = shtObj.CellValue(i,"all_in_rt_cd");

            if((mod == "Y" && (sts == "RR" || sts == "RS")) || (mod == "N" && sts == "RS")){
                //(Approval 권한 : Y 이고 NEW or REQUEST) 혹은  (Approval 권한 : N 이고 NEW)
                shtObj.CellEditable(i, "shpr_cnt_seq")    = true;
                shtObj.CellEditable(i, "shpr_lgl_eng_nm") = true;
                shtObj.CellEditable(i, "por_grp_tp_cd")   = true;
                shtObj.CellEditable(i, "por_rout_cd")     = true;
                shtObj.CellEditable(i, "pol_grp_tp_cd")   = true;
                shtObj.CellEditable(i, "pol_rout_cd")     = true;
                shtObj.CellEditable(i, "pod_grp_tp_cd")   = true;
                shtObj.CellEditable(i, "pod_rout_cd")     = true;
                shtObj.CellEditable(i, "del_grp_tp_cd")   = true;
                shtObj.CellEditable(i, "del_rout_cd")     = true;
                shtObj.CellEditable(i, "bkg_rcv_term_cd") = true;
                shtObj.CellEditable(i, "bkg_de_term_cd")  = true;
                //shtObj.CellEditable(i, "fac_sgl_flg")     = true;
                //shtObj.CellEditable(i, "fac_dbl_flg")     = true;
                shtObj.CellEditable(i, "all_in_rt_cd")    = true;
                shtObj.CellEditable(i, "svc_scp_cd")      = true;
                shtObj.CellEditable(i, "fm_eff_dt")       = true;
                shtObj.CellEditable(i, "to_eff_dt")       = true;
                shtObj.CellEditable(i, "sc_no")           = true;
                shtObj.CellEditable(i, "rfa_no")          = true;
                shtObj.CellEditable(i, "cmdt_tp_cd")      = true;
                shtObj.CellEditable(i, "cmdt_cd")         = true;
                shtObj.CellEditable(i, "cmdt_nm")         = true;


                
// [선처리] All in Rate 에 상관없이 Type 조정할 수 있도록 로직 변경 
//                if(allInRtCd == "Y"){
//                    shtObj.CellValue(i,"fac_div_cd") = "BA";
//                    shtObj.CellEditable(i, "fac_div_cd")  = false;
//                }else{
                shtObj.CellEditable(i, "fac_div_cd")  = true;
//                }

                // DF, SF 중 둘중 하나가 Y이면 나머지는 편집불가
                if(facSqlFlg == "Y"){
                    shtObj.CellEditable(i, "fac_dbl_flg") = false;
                }else{
                    shtObj.CellEditable(i, "fac_dbl_flg") = true;
                }

                if(facDblFlg == "Y"){
                    shtObj.CellEditable(i, "fac_sgl_flg") = false;
                }else{
                    shtObj.CellEditable(i, "fac_sgl_flg") = true;
                }


                switch(div) {

                    case "BA":
                    case "BF":
                        shtObj.CellEditable(i, "bkg_fac_rt") = true;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
                        shtObj.CellEditable(i, "bkg_fac_bl_amt") = false;
                        shtObj.CellEditable(i, "fac_bx_amt") = false;
                        shtObj.CellEditable(i, "fac_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_chg_ctnt") = false;
                        shtObj.CellEditable(i, "curr_cd") = false;
                        break;

                    case "BS":
                        shtObj.CellEditable(i, "bkg_fac_rt") = true;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
                        shtObj.CellEditable(i, "bkg_fac_bl_amt") = false;
                        shtObj.CellEditable(i, "fac_bx_amt") = false;
                        shtObj.CellEditable(i, "fac_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_chg_ctnt") = true;
                        shtObj.CellEditable(i, "curr_cd") = false;
                        break;

                    case "BL":
                        shtObj.CellEditable(i, "bkg_fac_rt") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
                        shtObj.CellEditable(i, "bkg_fac_bl_amt") = true;
                        shtObj.CellEditable(i, "fac_bx_amt") = false;
                        shtObj.CellEditable(i, "fac_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_chg_ctnt") = false;
                        shtObj.CellEditable(i, "curr_cd") = true;
                        break;

                    case "CA":
                        shtObj.CellEditable(i, "bkg_fac_rt") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
                        shtObj.CellEditable(i, "bkg_fac_bl_amt") = false;
                        shtObj.CellEditable(i, "fac_bx_amt") = true;
                        shtObj.CellEditable(i, "fac_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_chg_ctnt") = false;
                        shtObj.CellEditable(i, "curr_cd") = true;
                        break;

                    case "CS":
                        shtObj.CellEditable(i, "bkg_fac_rt") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt1") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt2") = false;
                        shtObj.CellEditable(i, "bkg_fac_bl_amt") = false;
                        shtObj.CellEditable(i, "fac_bx_amt") = false;
                        shtObj.CellEditable(i, "fac_teu_amt") = true;
                        shtObj.CellEditable(i, "fac_feu_amt") = true;
                        shtObj.CellEditable(i, "fac_rf_teu_amt") = true;
                        shtObj.CellEditable(i, "fac_rf_feu_amt") = true;
                        shtObj.CellEditable(i, "fac_chg_ctnt") = false;
                        shtObj.CellEditable(i, "curr_cd")         = true;
                        break;

                    case "DR":
                        shtObj.CellEditable(i, "bkg_fac_rt") = false;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt1") = true;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt1") = true;
                        shtObj.CellEditable(i, "fac_spcl_cntr_tp_ctnt2") = true;
                        shtObj.CellEditable(i, "fac_spcl_cntr_rt2") = true;
                        shtObj.CellEditable(i, "bkg_fac_bl_amt") = false;
                        shtObj.CellEditable(i, "fac_bx_amt") = false;
                        shtObj.CellEditable(i, "fac_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_teu_amt") = false;
                        shtObj.CellEditable(i, "fac_rf_feu_amt") = false;
                        shtObj.CellEditable(i, "fac_chg_ctnt") = true;
                        shtObj.CellEditable(i, "curr_cd") = false;
                        break;
                }

            }else{
                //편집불가모드
                shtObj.CellEditable(i, "shpr_cnt_seq")    = false;
                shtObj.CellEditable(i, "shpr_lgl_eng_nm") = false;
                shtObj.CellEditable(i, "por_grp_tp_cd")   = false;
                shtObj.CellEditable(i, "por_rout_cd")     = false;
                shtObj.CellEditable(i, "pol_grp_tp_cd")   = false;
                shtObj.CellEditable(i, "pol_rout_cd")     = false;
                shtObj.CellEditable(i, "pod_grp_tp_cd")   = false;
                shtObj.CellEditable(i, "pod_rout_cd")     = false;
                shtObj.CellEditable(i, "del_grp_tp_cd")   = false;
                shtObj.CellEditable(i, "del_rout_cd")     = false;
                shtObj.CellEditable(i, "bkg_rcv_term_cd") = false;
                shtObj.CellEditable(i, "bkg_de_term_cd")  = false;
                shtObj.CellEditable(i, "fac_sgl_flg")     = false;
                shtObj.CellEditable(i, "fac_dbl_flg")     = false;
                shtObj.CellEditable(i, "all_in_rt_cd") 	  = false;
                shtObj.CellEditable(i, "svc_scp_cd")      = false;
                shtObj.CellEditable(i, "fm_eff_dt")       = false;
                shtObj.CellEditable(i, "to_eff_dt")       = false;
                shtObj.CellEditable(i, "sc_no")           = false;
                shtObj.CellEditable(i, "rfa_no")          = false;
                shtObj.CellEditable(i, "cmdt_tp_cd")      = false;
                shtObj.CellEditable(i, "cmdt_cd")         = false;
                shtObj.CellEditable(i, "cmdt_nm")         = false;
                shtObj.CellEditable(i, "fac_div_cd")      = false;

                shtObj.CellEditable(i, "curr_cd")         = false;
            }//if((mod == "Y" && (sts == "RR" || sts == "RN")) || (mod == "N" && sts == "RN")){

        }//for(var i=0; i<rows; i++)
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
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


    /**
     * 엑셀에서 데이터를 모두 읽어들였을때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     */
    function sheet1_OnLoadExcel(shtObj) {
        var rows = shtObj.RowCount + 2;
        var tmp_ofc_cd = document.form.ar_ofc_cd.value;

        for(var i=2; i<rows; i++) {
            shtObj.CellValue2(i, "fac_ofc_cd") = tmp_ofc_cd; // 조회 조건의 Office를 fac_ofc_cd로 설정한다.
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
                    shtObj.RemoveAll();
                    break;
            }
        }
    }


    /**
     * Grid 입력값에 대한 OnChange Event 처리
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {

        if (Value == "") return;

        with(sheetObj) {

            var saveNm = ColSaveName(Col);

            switch (saveNm) {

                case "frt_cnt_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        Cellvalue2(Row, "ff_lgl_eng_nm") = "";
                        SelectCell(Row, Col, true, "");
                        return;
                    }
                    var xmlStr = GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        Cellvalue2(Row, "ff_lgl_eng_nm") = "";
                        SelectCell(Row, Col, true, "");
                    } else {
                        CellValue2(Row, "ff_lgl_eng_nm") = ComGetEtcData(xmlStr, "cust_lgl_eng_nm");
                    }
                    break;

                case "shpr_cnt_seq":
                    // validation
                    if (!ComIsNumber(Value.substring(2))) {
                        ComShowCodeMessage("ACM00003", "Customer Code [" + Value + "]", "Customer Code");
                        Cellvalue2(Row, "shpr_lgl_eng_nm") = "";
                        SelectCell(Row, Col, true, "");
                        return;
                    }
                    var xmlStr = GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH17 + "&value0=" + Value);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        Cellvalue2(Row, "shpr_lgl_eng_nm") = "";
                        SelectCell(Row, Col, true, "");
                    } else {
                        CellValue2(Row, "shpr_lgl_eng_nm") = ComGetEtcData(xmlStr, "cust_lgl_eng_nm");
                    }
                    break;

                case "por_grp_tp_cd":
                case "pol_grp_tp_cd":
                case "pod_grp_tp_cd":
                case "del_grp_tp_cd":
                    if(Value == 5) {
                        CellValue2(Row, (parseInt(Col)+1)) = "";
                        //sheet1_OnPopupClick(sheetObj, Row, Col+1);
                    } else {
                        CellValue2(Row, (parseInt(Col)+1)) = "*";
                    }
                    break;

                case "cmdt_tp_cd":
                    CellValue2(Row, (parseInt(Col)+1)) = "*";
                    CellValue2(Row, (parseInt(Col)+2)) = "";
                    break;

                case "fac_div_cd":
                    setFacDivCd( sheetObj, Row, Col );
                    break;
                    
                    
//                2013.02.06 이윤정 [선처리] All in Rate 에 상관없이 Type 조정할 수 있도록 로직 변경 
//                case "all_in_rt_cd":
//                    if( Value == "Y" ) {
//                        CellValue(Row, "fac_div_cd") = "BA";
//                        CellEditable(Row, "fac_div_cd") = false;
//                    } else {
//                       CellValue(Row, "fac_div_cd") = "BF";
//                       CellEditable(Row, "fac_div_cd") = true;
//                    }
//                    break;

                case "por_rout_cd":
                case "pol_rout_cd":
                case "pod_rout_cd":
                case "del_rout_cd":
                    checkSglFlg( sheetObj, Row, Col );
                    break;

                case "fac_dbl_flg":
                    // DF == 'Y' 이면 SF == 'Y' 이다.
                    if( ComTrim(Value) != "" && ComTrim(Value) == "Y" ) {
                        //CellValue(Row, "fac_sgl_flg") = "Y";
                        CellEditable(Row, "fac_sgl_flg") = false;
                    }else {
                        CellEditable(Row, "fac_sgl_flg") = true;
                    }
                    break;

                case "fac_sgl_flg":
                    // SF 수정시 DF == 'Y' 이면 SF는 항상 'Y'이다.
                    if( ComTrim(Value) != "" && ComTrim(Value) == "Y" ) {
                        //CellValue(Row, "fac_sgl_flg") = "Y";
                        CellEditable(Row, "fac_dbl_flg") = false;
                    }else{
                        CellEditable(Row, "fac_dbl_flg") = true;
                    }
                    break;

                case "fm_eff_dt":
                    if( CellValue(Row,"fm_eff_dt") > CellValue(Row,"to_eff_dt") ) {
                        ComShowCodeMessage("ACM00017", "Eff. Date", "Exp. Date");
                        //ComShowMessage("Eff. Date is later than Exp. Date. Please check Eff. Or Exp. Date.");
                        SelectCell(Row, Col, true, "");
                    }
                    break;

                case "to_eff_dt":
                    if( CellValue(Row,"fm_eff_dt") > CellValue(Row,"to_eff_dt") ) {
                        ComShowCodeMessage("ACM00018", "Exp. Date", "Eff. Date");
                        //ComShowMessage("Exp. Date is earlier than Eff. Date. Please check Eff. Or Exp. Date.");
                        SelectCell(Row, Col, true, "");
                    }
                    break;

                case "sc_no":
                    if( !("*" == Value) && !/[A-Z]{3}[0-9]{5}/.test(Value) ) {
                        ComShowCodeMessage("ACM00003", "SC No.", "SC No.");
                        SelectCell(Row, Col, true, "*");
                    }
                    break;

                case "rfa_no":
                    if( !("*" == Value) && !/[A-Z]{3}[0-9]{2}[A-Z]{1}[0-9]{4}/.test(Value) ) {
                        ComShowCodeMessage("ACM00003", "RFA No.", "RFA No.");
                        SelectCell(Row, Col, true, "*");
                    }
                    break;

                case "cmdt_cd": // 입력값 Validation 체크
                    var cmdt_tp = ComTrim(sheetObj.CellValue(Row, "cmdt_tp_cd"));
                    if(cmdt_tp == "*") {
                         ComShowCodeMessage("COM12113", "Commodity Type", "", "");
                         Cellvalue2(Row, Col) = "*";
                         SelectCell ( Row, parseInt(Col)-1 );
                         return;
                    }
                    var xmlStr = GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH19 + "&value0=" + cmdt_tp + "&value1=" + Value);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        SelectCell(Row, Col, true, "");
                    } else {
                        var rsltCmdtNm = ComGetEtcData(xmlStr, "cmdt_nm");
                        if ( rsltCmdtNm != "") {
                            Cellvalue2(Row, "cmdt_nm") = rsltCmdtNm;
                        } else {
                            // Commodity Code is invalid.
                            ComShowCodeMessage("COM132201", "Commodity Code");
                            SelectCell(Row, Col, true, "");
                        }
                    }
                    break;

                case "fac_spcl_cntr_tp_ctnt1": // 입력값 Validation 체크
                case "fac_spcl_cntr_tp_ctnt2": // 입력값 Validation 체크
                    var facCtntTpArr = Value.split(",");
                    var facCtntTpVal = "'";
                    for(i=0; i<facCtntTpArr.length; i++) {
                        if(i == facCtntTpArr.length-1) {
                            facCtntTpVal += facCtntTpArr[i]+"'";
                        } else {
                            facCtntTpVal += facCtntTpArr[i]+"','";
                        }
                    }
                    var xmlStr = GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH21 + "&value0=" + facCtntTpVal);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        SelectCell(Row, Col, true, "");
                    } else {
                        // MDM_CNTR_TP 테이블에 값이 존재하지 않으면, Message
                        if (ComGetEtcData(xmlStr, "cnt") != facCtntTpArr.length) {
                            //"{?msg1} is invalid."
                            ComShowCodeMessage("COM132201", "Container TP code ["+Value+"]");
                            SelectCell(Row, Col, true, "");
                        }
                    }
                    break;

                case "fac_chg_ctnt": // 입력값 Validation 체크
                    var fac_div_cd = CellValue(Row, "fac_div_cd");
                    if( fac_div_cd == "BS" || fac_div_cd == "DR") { // fac_div_cd 이 'BS', 'DR' 인 경우 Charge를 체크 한다.
                        if( !checkCHG( sheetObj, Row, "fac_chg_ctnt") ) {
                            SelectCell( Row, Col, "" );
                            return;
                        }
                    }
                    if( fac_div_cd == "DR") {
                        if( !checkManCHG( sheetObj, Row, "fac_chg_ctnt" ) ) {
                            SelectCell( Row, Col, "" );
                            return;
                        }
                    }

                    var facChgCtntArr = Value.split(",");
                    var facChgCtntVal = "";
                    for(i=0; i<facChgCtntArr.length; i++) {
                        if(i == facChgCtntArr.length-1) {
                            facChgCtntVal += facChgCtntArr[i];
                        } else {
                            facChgCtntVal += facChgCtntArr[i]+"','";
                        }
                    }
                    var xmlStr = GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH20 + "&value0=" + "'"+facChgCtntVal+"'"+ "&value1=" +facChgCtntArr.length);
                    if (ACMDecideErrXml(sheetObj, xmlStr)) {
                        Cellvalue2(Row, "fac_chg_ctnt") = "";
                        SelectCell(Row, Col, true, "");
                    } else {
                        // MDM_CHARGE 테이블에 값이 존재하지 않으면, Message
                        if (ComGetEtcData(xmlStr, "err_cnt") != "0") {
                            //"{?msg1} is invalid."
                            ComShowCodeMessage("COM132201", "Charge code ["+Value+"]");
                            SelectCell(Row, Col, true, "");
                        }
                    }
                    break;

            }
        }
    }


    /**
     * Grid에서 OnPopupClick Event 처리
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {

        var saveNm = sheetObj.ColSaveName(Col);
        var func = "setPopupData";
        var width = 775;
        var height = 482;

        switch (saveNm) {
            case "frt_cnt_seq":
            case "shpr_cnt_seq":
                var cust_cd = "";
                var display = "1,0,1";
                var url = "COM_ENS_041.do";
             // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                ComOpenPopup("COM_ENS_041.do", 775, 445, func, "1,0,1,1,1,1,1", true, false, Row, Col, 0);
                break;

            case "por_rout_cd":
            case "pol_rout_cd":
            case "pod_rout_cd":
            case "del_rout_cd":
                var grp_tp = sheetObj.CellValue(Row, parseInt(Col)-1);
                var display = "1,0,1,1,1,1,1";
                var url = "";

                if( grp_tp == "1" ) {
                    width = 306;
                    height = 382;
                    url = "COM_ENS_0H1.do";
                } else if( grp_tp == "2" ) {
                    width = 406;
                    height = 382;
                    url = "COM_ENS_0I1.do";
                } else if( grp_tp == "3" ) {
                    width = 566;
                    height = 484;
                    url = "COM_ENS_0M1.do";
                } else if( grp_tp == "4" ) {
                    width = 526;
                    height = 454;
                    url = "COM_ENS_0J1.do";
                } else if( grp_tp == "5" ) {
                    width = 775;
                    height = 482;
                    url = "COM_ENS_051.do";
                } else {
                    if( saveNm == "por_rout_cd" ) {
                        ComShowMessage(ComGetMsg("COM12113", "POR TYPE", "", ""));
                    } else if( saveNm == "pol_rout_cd" ) {
                        ComShowMessage(ComGetMsg("COM12113", "POL TYPE", "", ""));
                    } else if( saveNm == "pod_rout_cd" ) {
                        ComShowMessage(ComGetMsg("COM12113", "POD TYPE", "", ""));
                    } else if( saveNm == "del_rout_cd" ) {
                        ComShowMessage(ComGetMsg("COM12113", "DEL TYPE", "", ""));
                    }
                    sheetObj.SelectCell ( Row, parseInt(Col)-1 );
                    return false;
                }

                ComOpenPopup(url, width, height, func, display, true, false, Row, Col, 0);
                break;

            case "cmdt_cd":
                var display = "1,0,1";
                var url = "";
                var cmdt_tp = ComTrim(sheetObj.CellValue(Row, "cmdt_tp_cd"));
                if(cmdt_tp == "2") {
                    width = 506;
                    height = 430;
                    url = "COM_ENS_0K1.do";
                } else if(cmdt_tp == "3") {
                    width = 775;
                    height = 482;
                    url = "COM_ENS_011.do";
                } else {
                    ComShowCodeMessage("COM12113", "Commodity Type", "", "");
                    sheetObj.SelectCell ( Row, Col-1 );
                    return false;
                }

                ComOpenPopup(url, width, height, func, display, true, false, Row, Col, 0);
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

                var func = "sheet1_setSheetData";
                var display = "1,0,1,1,1,1,1,1,1,1,1,1";
                var url = "";
                url = "ESM_BKG_0655.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&func="+func;

                ComOpenPopup(url, 860, 475, func, display, true, false, Row, Col, 0);
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

                var func = "sheet1_setSheetData";
                var display = "1,0,1,1,1,1,1,1,1,1,1,1";
                var url = "";
                url = "ESM_BKG_0654.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&func="+func;

                ComOpenPopup(url, 860, 475, func, display, true, false, Row, Col, 0);
                break;

            case "fac_spcl_cntr_tp_ctnt1":
            case "fac_spcl_cntr_tp_ctnt2":

                var ctntVal = sheetObj.CellValue(Row, Col);
                //ComOpenPopup(url, width, height, "setPopupData", display, modal, b2ndSheet, Row, Col);
                ComOpenPopup("ESM_ACM_0104.do?fac_spcl_cntr_tp_ctnt="+ctntVal, 340, 350, "", "0,1,1,1,1", true, false, Row, Col, 0);
                break;

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

                    case "frt_cnt_seq":
                    case "shpr_cnt_seq":
                        CellValue2(Row, Col) = aryPopupData[0][3].substring(0, 2) + ComLpad(aryPopupData[0][3].substring(2), 6, "0");
                        CellValue2(Row, parseInt(Col)+1) = aryPopupData[0][4];
                        break;

                    case "por_rout_cd":
                    case "pol_rout_cd":
                    case "pod_rout_cd":
                    case "del_rout_cd":
                        CellValue(Row, Col) = aryPopupData[0][3];
                        break;

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
     * 저장 버튼 클릭시 유효성검증 프로세스 처리
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {

        var f_cmd = document.form.f_cmd.value;
        var val = ComTrim(Value);
        var subValue = "";

        if(f_cmd == MULTI) { // 저장시에만 체크한다.

            with(sheetObj) {

                var saveNm = ColSaveName(Col);
                var ibStatus = RowStatus(Row);

                if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {

                    switch (saveNm) {

                        case "por_grp_tp_cd":
                        case "pol_grp_tp_cd":
                        case "pod_grp_tp_cd":
                        case "del_grp_tp_cd":
                        case "cmdt_tp_cd":
                            if( val.length > 0 && val != "*" ) {
                                subValue = ComTrim(CellValue(Row, Col+1));
                                if( subValue == "" || subValue == "*") {
                                    if(saveNm=="por_grp_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "POR", "", ""));
                                    } else if(saveNm=="pol_grp_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "POL", "", ""));
                                    } else if(saveNm=="pod_grp_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "POD", "", ""));
                                    } else if(saveNm=="del_grp_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "DEL", "", ""));
                                    } else if(saveNm=="cmdt_tp_cd") {
                                        ComShowMessage(ComGetMsg("COM130201", "Commodity", "", ""));
                                    }
                                    ValidateFail = true;
                                    SelectCell( Row, Col+1 );
                                } else {
                                    if( saveNm=="por_grp_tp_cd" || saveNm=="pol_grp_tp_cd" ||
                                        saveNm=="pod_grp_tp_cd" || saveNm=="del_grp_tp_cd" ) {

                                        if(checkSubLength( sheetObj, Row, Col, val ) == false) {
                                            ValidateFail = true;
                                            SelectCell( Row, Col+1 );
                                        }
                                    }
                                }
                            }

                            break;

                    }
                }
            }
        }
    }


    /**
     * Pop_up에서 조회 후 값 Return 받아 해당 셀에 셋팅한다.
     */
    function sheet1_setSheetData(rowArray, row, col) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var colArray = rowArray[0];
        row = formObj.rowNum.value;
        col = formObj.colNum.value;

        sheetObj.CellValue2(row, col) = colArray[5];
    }


    /**
     * Save 시에 Sheet 데이터 유효성 체크
     */
    function validateData(sheetObj) {
        with(sheetObj) {
            for (var i=HeaderRows; i<=TotalRows+HeaderRows; i++) {
                var ibStatus = RowStatus(i);
                if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {
                    // Rate, Amount 가 전부 미입력일때
                	alert(CellValue(i, "bkg_fac_rt"));
                    if( CellValue(i, "bkg_fac_rt") == "0" && CellValue(i, "fac_spcl_cntr_rt1") == "0" && CellValue(i, "fac_spcl_cntr_rt2") == "0" &&
                            CellValue(i, "bkg_fac_bl_amt") == "0" && CellValue(i, "fac_bx_amt") == "0" && CellValue(i, "fac_teu_amt") == "0" &&
                            CellValue(i, "fac_feu_amt") == "0" && CellValue(i, "fac_rf_teu_amt") == "0" && CellValue(i, "fac_rf_feu_amt") == "0" &&
                            CellValue(i, "fac_spcl_teu_amt") == "0" && CellValue(i, "fac_spcl_feu_amt") == "0" ) {

                            ComShowCodeMessage("COM130201", "rate or amount");
                            return false;
                    }
                }
            }
        }
        return true;
    }


    /**
     * Request, Approve, Reject 버튼 클릭시 대상 체크
     */
    function checkData( gubun ){
        var sheetObj = sheetObjects[0];
        var cnt = 0;
        if( gubun == "RE" ) {    // Reject일 경우

            for(var i=1; i<sheetObj.Rows; i++) {
                var check = sheetObj.CellValue(i, "check");
                var sts_cd = sheetObj.CellValue(i, "fac_sts_cd");

                if( check == 1 ) {
                    if(sts_cd == "RR" || sts_cd == "PS") {
                        cnt++;
                    } else {
                        sheetObj.CellValue2(i, "check") = "N";
                    }
                }
            }
        } else {   // Request/Approval일 경우

            var sts = "";

            if( gubun == "RR" ) {
                sts = "RS";
            } else if( gubun == "PS" ) {
                sts = "RR";
            }

            for(var i=1; i<sheetObj.Rows; i++) {
                var check = sheetObj.CellValue(i, "check");
                var sts_cd = sheetObj.CellValue(i, "fac_sts_cd");

                if( check == 1 ) {
                    if(sts_cd == sts) {
                        cnt++;
                    } else {
                        sheetObj.CellValue2(i, "check") = "N";
                    }
                }
            }
        }
        return cnt;
    }


    /**
     * 행추가
     */
    function addRowData(newRow, cntCd) {
        var sheetObj = sheetObjects[0];
        var ff_cnt_cd = "";
        var ff_cust_nm = "";
        if(cntCd != null && cntCd.length > 0) {
            ff_cnt_cd = cntCd + "999999";
            ff_cust_nm = "REP. CUSTOMER";

            sheetObj.CellValue2(newRow, "frt_cnt_seq") = ff_cnt_cd;
            sheetObj.CellValue2(newRow, "ff_lgl_eng_nm") = ff_cust_nm;
        }
        setCellEditable( sheetObj, newRow );
    }


    /**
     * 행복사시 Grid Cell Data 설정
     */
    function setCellData( sheetObj, newRow ) {
        with(sheetObj) {
            CellValue2(newRow, "fac_sts_cd") = "RS";
            CellValue2(newRow, "fac_rqst_usr_id") = "";
            CellValue2(newRow, "fac_apro_usr_id") = "";
            CellValue2(newRow, "fac_rmk") = "";
            CellValue2(newRow, "fac_agmt_seq") = "";
//	        CellValue2(newRow, "fac_rqst_usr_eml") = "";
//	        CellValue2(newRow, "fac_apro_usr_eml") = "";
//	        CellValue2(newRow, "fac_rqst_usr_name") = "";
        }
    }


    /**
     * 행복사시 Grid CellEditable 설정
     */
    function setCellEditable( sheetObj, newRow ) {
        with(sheetObj) {
//            CellEditable(newRow, "delchk") = true;
            CellEditable(newRow, "check") = false;
            CellEditable(newRow, "frt_cnt_seq") = true;
            CellEditable(newRow, "shpr_cnt_seq") = true;
            CellEditable(newRow, "por_grp_tp_cd") = true;
            CellEditable(newRow, "por_rout_cd") = true;
            CellEditable(newRow, "pol_grp_tp_cd") = true;
            CellEditable(newRow, "pol_rout_cd") = true;
            CellEditable(newRow, "pod_grp_tp_cd") = true;
            CellEditable(newRow, "pod_rout_cd") = true;
            CellEditable(newRow, "del_grp_tp_cd") = true;
            CellEditable(newRow, "del_rout_cd") = true;
            CellEditable(newRow, "bkg_rcv_term_cd") = true;
            CellEditable(newRow, "bkg_de_term_cd") = true;
            CellEditable(newRow, "fac_sgl_flg") = true;
            CellEditable(newRow, "fac_dbl_flg") = true;
            CellEditable(newRow, "all_in_rt_cd") = true;
            CellEditable(newRow, "svc_scp_cd") = true;
            CellEditable(newRow, "fm_eff_dt") = true;
            CellEditable(newRow, "to_eff_dt") = true;
            CellEditable(newRow, "sc_no") = true;
            CellEditable(newRow, "rfa_no") = true;
            CellEditable(newRow, "cmdt_tp_cd") = true;
            CellEditable(newRow, "cmdt_cd") = true;
            CellEditable(newRow, "fac_div_cd") = true;
            CellEditable(newRow, "bkg_fac_rt") = true;
            CellEditable(newRow, "fac_spcl_cntr_tp_ctnt1") = true;
            CellEditable(newRow, "fac_spcl_cntr_rt1") = true;
            CellEditable(newRow, "fac_spcl_cntr_tp_ctnt2") = true;
            CellEditable(newRow, "fac_spcl_cntr_rt2") = true;
//            CellEditable(newRow, "bkg_fac_bl_amt") = true;
            CellEditable(newRow, "fac_bx_amt") = true;
            CellEditable(newRow, "fac_teu_amt") = true;
            CellEditable(newRow, "fac_feu_amt") = true;
            CellEditable(newRow, "fac_rf_teu_amt") = true;
            CellEditable(newRow, "fac_rf_feu_amt") = true;
            CellEditable(newRow, "fac_chg_ctnt") = true;
            CellEditable(newRow, "fac_rmk") = true;
        }
    }


    /**
     * Type(fac_div_cd) 입력시 Format 적용
     */
    function setFacDivCd( sheetObj, Row, Col ) {

        with(sheetObj) {

            var value = CellValue(Row, Col);

            switch (value) {
                case "BA":
                case "BF":

                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                    CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                    CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                    CellValue2(Row, "bkg_fac_bl_amt") = 0;
                    CellValue2(Row, "fac_bx_amt") = 0;
                    CellValue2(Row, "fac_teu_amt") = 0;
                    CellValue2(Row, "fac_feu_amt") = 0;
                    CellValue2(Row, "fac_rf_teu_amt") = 0;
                    CellValue2(Row, "fac_rf_feu_amt") = 0;
                    CellValue2(Row, "fac_chg_ctnt") = "";

                    CellEditable(Row, "bkg_fac_rt") = true;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                    CellEditable(Row, "bkg_fac_bl_amt") = false;
                    CellEditable(Row, "fac_bx_amt") = false;
                    CellEditable(Row, "fac_teu_amt") = false;
                    CellEditable(Row, "fac_feu_amt") = false;
                    CellEditable(Row, "fac_rf_teu_amt") = false;
                    CellEditable(Row, "fac_rf_feu_amt") = false;
                    CellEditable(Row, "fac_chg_ctnt") = false;
                    CellEditable(Row, "fac_spcl_teu_amt") = false;
                    CellEditable(Row, "fac_spcl_feu_amt") = false;

                    CellEditable(Row, "curr_cd") = false;

                    break;

                case "BS":

                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                    CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                    CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                    CellValue2(Row, "bkg_fac_bl_amt") = 0;
                    CellValue2(Row, "fac_bx_amt") = 0;
                    CellValue2(Row, "fac_teu_amt") = 0;
                    CellValue2(Row, "fac_feu_amt") = 0;
                    CellValue2(Row, "fac_rf_teu_amt") = 0;
                    CellValue2(Row, "fac_rf_feu_amt") = 0;

                    CellEditable(Row, "bkg_fac_rt") = true;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                    CellEditable(Row, "bkg_fac_bl_amt") = false;
                    CellEditable(Row, "fac_bx_amt") = false;
                    CellEditable(Row, "fac_teu_amt") = false;
                    CellEditable(Row, "fac_feu_amt") = false;
                    CellEditable(Row, "fac_rf_teu_amt") = false;
                    CellEditable(Row, "fac_rf_feu_amt") = false;
                    CellEditable(Row, "fac_chg_ctnt") = true;
                    CellEditable(Row, "fac_spcl_teu_amt") = false;
                    CellEditable(Row, "fac_spcl_feu_amt") = false;

                    CellEditable(Row, "curr_cd") = false;

                    break;

                case "BL":

                    CellValue2(Row, "bkg_fac_rt") = 0;
                    CellValue2(Row, "fac_bx_amt") = 0;
                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                    CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                    CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                    CellValue2(Row, "fac_teu_amt") = 0;
                    CellValue2(Row, "fac_feu_amt") = 0;
                    CellValue2(Row, "fac_rf_teu_amt") = 0;
                    CellValue2(Row, "fac_rf_feu_amt") = 0;
                    CellValue2(Row, "fac_chg_ctnt") = "";

                    CellEditable(Row, "bkg_fac_bl_amt") = true;
                    CellEditable(Row, "bkg_fac_rt") = false;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                    CellEditable(Row, "fac_bx_amt") = false;
                    CellEditable(Row, "fac_teu_amt") = false;
                    CellEditable(Row, "fac_feu_amt") = false;
                    CellEditable(Row, "fac_rf_teu_amt") = false;
                    CellEditable(Row, "fac_rf_feu_amt") = false;
                    CellEditable(Row, "fac_chg_ctnt") = false;
                    CellEditable(Row, "fac_spcl_teu_amt") = false;
                    CellEditable(Row, "fac_spcl_feu_amt") = false;

                    CellEditable(Row, "curr_cd") = true;

                    break;

                case "CA":

                    CellValue2(Row, "bkg_fac_rt") = 0;
                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                    CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                    CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                    CellValue2(Row, "bkg_fac_bl_amt") = 0;
                    CellValue2(Row, "fac_teu_amt") = 0;
                    CellValue2(Row, "fac_feu_amt") = 0;
                    CellValue2(Row, "fac_rf_teu_amt") = 0;
                    CellValue2(Row, "fac_rf_feu_amt") = 0;
                    CellValue2(Row, "fac_chg_ctnt") = "";

                    CellEditable(Row, "bkg_fac_rt") = false;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                    CellEditable(Row, "bkg_fac_bl_amt") = false;
                    CellEditable(Row, "fac_bx_amt") = true;
                    CellEditable(Row, "fac_teu_amt") = false;
                    CellEditable(Row, "fac_feu_amt") = false;
                    CellEditable(Row, "fac_rf_teu_amt") = false;
                    CellEditable(Row, "fac_rf_feu_amt") = false;
                    CellEditable(Row, "fac_chg_ctnt") = false;
                    CellEditable(Row, "fac_spcl_teu_amt") = false;
                    CellEditable(Row, "fac_spcl_feu_amt") = false;

                    CellEditable(Row, "curr_cd") = true;

                    break;

                case "CS":

                    CellValue2(Row, "bkg_fac_rt") = 0;
                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt1") = "";
                    CellValue2(Row, "fac_spcl_cntr_tp_ctnt2") = "";
                    CellValue2(Row, "fac_spcl_cntr_rt1") = 0;
                    CellValue2(Row, "fac_spcl_cntr_rt2") = 0;
                    CellValue2(Row, "bkg_fac_bl_amt") = 0;
                    CellValue2(Row, "fac_bx_amt") = 0;
                    CellValue2(Row, "fac_rf_feu_amt") = "";

                    CellEditable(Row, "bkg_fac_rt") = false;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt1") = false;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = false;
                    CellEditable(Row, "fac_spcl_cntr_rt2") = false;
                    CellEditable(Row, "bkg_fac_bl_amt") = false;
                    CellEditable(Row, "fac_bx_amt") = false;
                    CellEditable(Row, "fac_teu_amt") = true;
                    CellEditable(Row, "fac_feu_amt") = true;
                    CellEditable(Row, "fac_rf_teu_amt") = true;
                    CellEditable(Row, "fac_rf_feu_amt") = true;
                    CellEditable(Row, "fac_chg_ctnt") = false;
                    CellEditable(Row, "fac_spcl_teu_amt") = true;
                    CellEditable(Row, "fac_spcl_feu_amt") = true;

                    CellEditable(Row, "curr_cd") = true;

                    break;

                case "DR":

                    CellValue2(Row, "bkg_fac_rt") = 0;
                    CellValue2(Row, "bkg_fac_bl_amt") = 0;
                    CellValue2(Row, "fac_bx_amt") = 0;
                    CellValue2(Row, "fac_rf_feu_amt") = "";

                    CellEditable(Row, "bkg_fac_rt") = false;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt1") = true;
                    CellEditable(Row, "fac_spcl_cntr_rt1") = true;
                    CellEditable(Row, "fac_spcl_cntr_tp_ctnt2") = true;
                    CellEditable(Row, "fac_spcl_cntr_rt2") = true;
                    CellEditable(Row, "bkg_fac_bl_amt") = false;
                    CellEditable(Row, "fac_bx_amt") = false;
                    CellEditable(Row, "fac_teu_amt") = false;
                    CellEditable(Row, "fac_feu_amt") = false;
                    CellEditable(Row, "fac_rf_teu_amt") = false;
                    CellEditable(Row, "fac_rf_feu_amt") = false;
                    CellEditable(Row, "fac_chg_ctnt") = true;
                    CellEditable(Row, "fac_spcl_teu_amt") = false;
                    CellEditable(Row, "fac_spcl_feu_amt") = false;

                    CellEditable(Row, "curr_cd") = false;
                    break;

            }
        }
    }


    /**
     * CHG 체크
     */
    function checkCHG( sheetObj, Row, ColNm ) {
        with(sheetObj) {
            var value = ComTrim(CellValue(Row, ColNm));

            var chg_arr = value.split(',');

            if(chg_arr.length > 0) {
                for(var i=0; i<chg_arr.length; i++) {
                    if(chg_arr[i] == "") { // 계산시 문제 발생 가능하므로 ComTrim하지 않고 체크한다.
                        ComShowCodeMessage("COM130201", "CHG", "(ex:OFT,OTH,DTH)", "");
                        SelectCell( Row, ColNm, true, "" );
                        return false;
                    } else {
                        if(chg_arr[i].length > 3) {
                            ComShowCodeMessage("ACM00016");
                            //ComShowMessage("Each CHG consists of maximum of 3 Characters.\n\n (ex:OFT,OTH,DTH)");
                            SelectCell( Row, ColNm, true, "" );
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


    /**
     * CHG 체크
     */
    function checkManCHG( sheetObj, Row, ColNm ) {
        with(sheetObj) {
            var value = ComTrim(CellValue(Row, ColNm));

            if(value.length <= 0) {
                ComShowCodeMessage("COM130201", "CHG", "(ex:OFT,OTH,DTH)", "");
                SelectCell( Row, ColNm );
                return false;
            }
        }

        return true;
    }


    /**
     * 입력 길이 체크
     */
    function checkSubLength( sheetObj, Row, Col, Value ) {

        with(sheetObj) {

            Value = ComTrim(Value);

            var saveNm = ColSaveName(Col);
            var subValue = ComTrim(CellValue(Row, Col+1));

            switch (Value) {
                case "1":
                    if(subValue.length > 1) {
                        if(saveNm=="por_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POR", "1", ""));
                        } else if(saveNm=="pol_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POL", "1", ""));
                        } else if(saveNm=="pod_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POD", "1", ""));
                        } else if(saveNm=="del_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "DEL", "1", ""));
                        }
                        return false;
                    }
                    break;

                case "2":
                case "3":
                    if(subValue.length > 2) {
                        if(saveNm=="por_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POR", "2", ""));
                        } else if(saveNm=="pol_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POL", "2", ""));
                        } else if(saveNm=="pod_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POD", "2", ""));
                        } else if(saveNm=="del_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "DEL", "2", ""));
                        }
                        return false;
                    }
                    break;

                case "4":
                    if(subValue.length > 3) {
                        if(saveNm=="por_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POR", "3", ""));
                        } else if(saveNm=="pol_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POL", "3", ""));
                        } else if(saveNm=="pod_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POD", "3", ""));
                        } else if(saveNm=="del_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "DEL", "3", ""));
                        }
                        return false;
                    }
                    break;

                case "5":
                    if(subValue.length > 5) {
                        if(saveNm=="por_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POR", "5", ""));
                        } else if(saveNm=="pol_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POL", "5", ""));
                        } else if(saveNm=="pod_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "POD", "5", ""));
                        } else if(saveNm=="del_grp_tp_cd") {
                            ComShowMessage(ComGetMsg("COM12173", "DEL", "5", ""));
                        }
                        return false;
                    }
                    break;
            }
        }

        return true;
    }


    /**
     * Grid에서 Sgl Flg 설정 처리
     */
    function checkSglFlg( sheetObj, Row ) {
        with (sheetObj) {

            var por_cd = ComTrim(CellValue(Row, "por_rout_cd"));
            var pol_cd = ComTrim(CellValue(Row, "pol_rout_cd"));
            var pod_cd = ComTrim(CellValue(Row, "pod_rout_cd"));
            var del_cd = ComTrim(CellValue(Row, "del_rout_cd"));

            if( por_cd != "*" && pol_cd != "*" && pod_cd != "*" &&
                del_cd != "*" && por_cd == pol_cd && pod_cd == del_cd ) {

                CellValue2(Row, "fac_sgl_flg") = "N";
                CellEditable(Row, "fac_sgl_flg") = false;
            } else {
                CellEditable(Row, "fac_sgl_flg") = true;
            }

            if( por_cd != "*" && pol_cd != "*" && pod_cd != "*" &&
                del_cd != "*" && por_cd != pol_cd && pod_cd != del_cd ) {

                CellValue2(Row, "fac_dbl_flg") = "Y";
                CellEditable(Row, "fac_dbl_flg") = true;
            } else {
                CellEditable(Row, "fac_dbl_flg") = false;
            }
        }
    }


    /**
     * Request Click Event 처리
     */
    function openStaffInfo( cnt ) {

        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        document.form.cnt.value = cnt; // Request Count를 셋팅한다.

        var cust_cd = "";
        var width = 858;
        var height = 554;
        var func = "doRequest";
        var url = "COM_ENS_092.do";

        ComOpenPopup(url, width, height, func, 'none', true);
    }


    /**
     * Request Click Event 처리
     */
    function doRequest( rowArray ) {

        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        var gubun = ';';
        formObj.recipients_eml.value = ""; // 초기화
        formObj.recipients_name.value = ""; // 초기화

        for(var i=0; i<rowArray.length; i++) {

            if(i == rowArray.length-1) gubun = '';

            var colArray = rowArray[i];

            if(colArray[1] == "1"){
                formObj.recipients_eml.value += colArray[4] + gubun;
                formObj.recipients_name.value += colArray[3] + gubun;
            }
        }
        if( formObj.recipients_eml.value.length <= 0) {
            ComShowCodeMessage("COM130402", "Recipient e-mail address");
            return false;
        }
        sheetObj.DoSave("ESM_ACM_0024GS.do", FormQueryString(formObj), "check", false);
    }

/* 개발자 작업 끝 */