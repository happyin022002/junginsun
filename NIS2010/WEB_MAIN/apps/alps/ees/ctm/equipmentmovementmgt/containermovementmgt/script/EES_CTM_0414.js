/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ees_ctm_0414.js
 * @FileTitle : Update of EDI Message (Error)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2010-04-13
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2010-03-30 김상수 1.0 Creation
 *
 * 공통으로 사용되는 Script를 common_0404.js / common_0430.js에 별도로 분리하여 사용(중요)
 */
/**
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 *                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 *                 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 */

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends
     * @class ees_ctm_0414 : ees_ctm_0414 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0414() { 
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initCombo = initCombo;
        this.doActionIBSheet = doActionIBSheet;
        this.validateForm = validateForm;
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var sheetValidation = true;

var appendCondParam = null;
var appendPageNo = null;
var appendOnePageRows = null;
var appendPageNo = 1;

var okCount = 0;
var errorCount = 0;
var ignoredCount = 0;
var totalCount = 0;
var errorXml = "";
var saveXml = new Array();

var uploadObjects = new Array();
var uploadCnt = 0;

// sheet2 : 화면제어용 전역변수
var sheet2valid = true;
// sheet2 : sheet1으로 부터 넘겨온 데이터 확인용 변수
var fromSheet1 = 0;

var lastRetrieveDate = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {
                case "btn_Calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.p_date1, frmObj.p_date2, "yyyy-MM-dd");
                    }
                    break;

                case "btn_vvdchange":
                    with (sheetObj1) {
                        if (CheckedRows("Sel") < 1) {
                            ComShowCodeMessage("CTM30001");
                            return;
                        } else {
                            if (frmObj.vvdsts_change_combo.value == "VVD") {
                                if (frmObj.vvdcd_change.value.length < 9) {
                                    ComShowCodeMessage("CTM20073");
                                    return;
                                }
                            }
                            Redraw = false;
                            // "|" 구분자로 연결하여 체크된 행번 가져오기, 결과:"3|4|5|"
                            var arr = FindCheckedRow("Sel").split("|");
                            var vvdstsChange = "";
                            for (var i=0; i<arr.length-1; i++) {
                                if (frmObj.vvdsts_change_combo.value == "VVD") {
                                    if (CellEditable(arr[i], "vvd_cd")) {    //해당 셀의 Editable이 true일때
                                        // Validation을 하지 않게 CellValue2를 사용
                                        CellValue2(arr[i], "vvd_cd") = frmObj.vvdcd_change.value;
                                        CellValue2(arr[i], "crnt_vsl_cd") = frmObj.vvdcd_change.value.substring(0, 4);
                                        CellValue2(arr[i], "crnt_skd_voy_no") = frmObj.vvdcd_change.value.substring(4, 8);
                                        CellValue2(arr[i], "crnt_skd_dir_cd") = frmObj.vvdcd_change.value.substring(8, 9);
                                        // CellValue2를 사용하면 RowStatus가 변경되지 않으므로
                                        //  GateNew가 아닌 Common을 타게 하려면 RowStatus를 U로 setting
                                        RowStatus(arr[i]) = "U";
                                    }
                                } else {
                                    if (CellEditable(arr[i], "edi_mvmt_sts_cd")) {    //해당 셀의 Editable이 true일때
                                        // Validation을 하지 않게 CellValue2를 사용
                                        CellValue2(arr[i], "edi_mvmt_sts_cd") = frmObj.stscd_change.value;
                                        // CellValue2를 사용하면 RowStatus가 변경되지 않으므로
                                        //  GateNew가 아닌 Common을 타게 하려면 RowStatus를 U로 setting
                                        RowStatus(arr[i]) = "U";
                                    }
                                }
                            }
                            Redraw = true;
                        }
                    }
                    break;

                case "btn_more":
                    doActionIBSheet(sheetObj1, frmObj, IBSEARCHAPPEND, appendCondParam, appendPageNo);
                    break;

                case "btn_detail":
                    // sheet1_OnDblClick 함수를 호출하여 팝업을 띄움
                    sheet1_OnDblClick(sheetObj1, sheetObj1.SelectRow);
                    break;

                case "btn_downexcel":
                    sheetObj1.WaitImageVisible = false;
                    sheetObj2.WaitImageVisible = false;
                    ComOpenWait(true);
                    sheetObj1.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "Sel");
                    ComOpenWait(false);
                    sheetObj2.WaitImageVisible = true;
                    sheetObj1.WaitImageVisible = true;
                    break;

                case "btn_retrieve":
                    if (!checkFormField()) return;
                    sheetObj1.HeadCheck(0, "Sel") = false;
                    doActionIBSheet(sheetObj1, frmObj, IBSEARCH);
                    break;

                case "btn_save":
                    doActionIBSheet(sheetObj1, frmObj, IBSAVE);    // 저장
                    break;

                case "btn_close":
                    window.close();
                    break;

                case "btn2_retrieve":    // sheet1의 Retrive와 구분되어야하므로 btn_retrieve2로 네이밍 정의
                    // common_0430.js의 함수
                    btn2Retrieve();
                    break;

                case "btn2_save":
                    // common_0430.js의 함수
                    btn2Save();
                    break;

                case "btn2_add":
                    // common_0430.js의 함수
                    addRow();
                    break;

                case "btn2_delete":
                    // common_0430.js의 함수
                    btn2Delete();
                    break;

                case "btn2_new":
                    DomSetFormObjDisable(frmObj, false);
                    frmObj.statusCombo.Enable = true;
                    frmObj.mvmt_edi_msg_tp_id.Enable = true;
                    frmObj.p_yard2.Enable = true;
                    frmObj.ioStatusCombo.Enable = true;
                    sheetObj1.Editable = true;
                    ComBtnEnable("btn_vvdchange");
                    ComBtnEnable("btn_retrieve");
                    // UI의 Area콤보박스가 로그인 사용자의 서버아이디가 같을때는 Save버튼 활성화
                    if (frmObj.user_svr_id.value == frmObj.mvmt_edi_msg_area_cd.value) {
                        ComBtnEnable("btn_save");
                    } else {
                        ComBtnDisable("btn_save");
                    }
                    sheetObj2.RemoveAll();
                    ComBtnDisable("btn2_add");
                    ComBtnDisable("btn2_delete");
                    ComBtnDisable("btn2_save");
                    sheetObj2.ActionMenu = "";
                    if (sheetObj1.CheckedRows("Sel") == 1 && sheetObj1.CellValue(sheetObj1.FindCheckedRow("Sel").split("|")[0], "mvmt_edi_rslt_cd") == "Y") {
                        doActionIBSheet(sheetObj1, frmObj, IBSEARCH);
                    }
                    break;
                    
                case "btn_result":
                	if (frmObj.mvmt_edi_rslt_cd.value == "N"){
                		ComOpenPopup('EES_CTM_0467.do', 400, 380, '', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                	}
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
    function setSheetObject(sheetObj) {
       sheetObjects[sheetCnt++] = sheetObj;
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
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(var i=0;i<comboObjects.length;i++) {
            initCombo(comboObjects[i], comboObjects[i].id);
        }

        // button Disable
        ComBtnDisable("btn_more");
        ComBtnDisable("btn_detail");
        ComBtnDisable("btn_vvdchange");
        ComBtnDisable("btn2_add");
        ComBtnDisable("btn2_delete");
        ComBtnDisable("btn2_retrieve");
        ComBtnDisable("btn2_save");

        // CTM-COMMON (& 예외처리)
        setEventProcess("cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvd_combo", "vvdcd_change");

        // OnKeyPress 이벤트 (공통function)
        axon_event.addListener("keypress", "obj_keypress", "cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvdcd_change");
        // OnKeyUp 이벤트 (자체function)
        axon_event.addListener("keyup", "obj_onkeyup", "cntrno_disp", "yd_cd_disp", "lcc_cd", "rcc_cd", "vvdcd_change");
        // OnChange 이벤트 (자체function)
        axon_event.addListener("change", "obj_onchange", "vvdsts_change_combo", "mvmt_edi_rslt_cd");

        with (document.form) {
            // Request Setting
            vvd_combo.value = vvdCombo.value;
            if (cntrFullStsCd.value != "") cntr_full_sts_cd.value = cntrFullStsCd.value;
            vvd_combo.value = vvdCombo.value;
            mvmt_edi_rslt_cd.value = mvmtEdiRsltCd.value;
            if (rtyKnt.value != "") rty_knt.value = rtyKnt.value;

            // 로그인 사용자의 Office코드로 서버아이디 조회(또는 Request)
            doActionIBSheet(sheetObjects[0], document.form, SEARCH16);

            // Request받는 Parameter가 있다면 조회
            if (requestYN.value == "Y") doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

            // 페이지 로딩시 focus
            p_date1.focus();
        }

        ComConfigUpload(uploadObjects[0], "/hanjin/CTMCommonGS.do");

        if (document.form.mvmt_edi_rslt_cd.value == "N") {
            DomSetFormObjDisable(document.form, false);
        } else {
        	DomSetFormObjDisable(document.form, true);
        }
    }

	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        switch (sheetNo) {

            case 1:    // sheet[0] init

                var cnt = 0;
                with (sheetObj) {

                    // 높이 설정
                    style.height = 354;

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

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(52, 4, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    // Ctrl키를 눌러 다중행 선택가능
                    MultiSelection = true;
                    SelectionMode = smSelectionList;

                    var HeadTitle  = "|Seq.||Container No.|T/S|ORG YD|Event Date|Receiving Date|Booking No.|EDI Booking|B/L No.|VVD Code|Call sign/Lloyd|Seal No.|VGM|Chassis No.|M.G Set|S/P|Mode|LCC|RTN YD|POL|POD|STS|I/O|F/M|E/I|Retry|Result error message|Remark(s)";
                        // hidden columns
                        HeadTitle += "|crnt_vsl_cd|crnt_skd_voy_no|crnt_skd_dir_cd|call_sgn_no|lloyd_no|mvmt_edi_rslt_cd|mvmt_edi_msg_area_cd|mvmt_edi_msg_seq|mvmt_edi_msg_tp_id|mvmt_edi_msg_yrmondy|mvmt_edi_tp_cd|upd_flag||||||||";

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,     daCenter,    false,    "ibflag");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    false,    "Seq");
                    InitDataProperty(0, cnt++, dtDummyCheck,   30,     daCenter,    false,    "Sel");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "cntr_no",          true,     "",    dfNone,        0,    true,     true,     11);
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "cntr_tpsz_cd",     false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,    "evnt_yd_cd",       false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "evnt_dt",          false,    "",    dfUserFormat2, 0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,    "cre_locl_dt",      false,    "",    dfUserFormat2, 0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "bkg_no",           false,    "",    dfNone,        0,    true,     true,     13);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "edi_bkg_no",       false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "bl_no",            false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "vvd_cd",           false,    "",    dfNone,        0,    true,     true,     9);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    false,    "call_sgn_lloyd",   false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,    "cntr_seal_no",     false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,     daRight,     false,    "vgm",              false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "chss_no",          false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         80,     daCenter,    false,    "mgst_no",          false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "vndr_seq",         false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,    "mvmt_trsp_mod_cd", false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "lcc_cd",           false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    false,    "dest_yd_cd",       false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "pol_cd",           false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    false,    "pod_cd",           false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "edi_mvmt_sts_cd",  false,    "",    dfNone,        0,    true,     true,     2);
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "edi_gate_io_cd",   false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "cntr_full_sts_cd", false,    "",    dfNone,        0,    true,     true,     2);
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    false,    "mvmt_edi_sght_cd", false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,    "rty_knt",          false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         350,    daLeft,      false,    "mvmt_edi_rmk",     false,    "",    dfNone,        0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,         300,    daLeft,      false,    "cnmv_rmk",         false,    "",    dfNone,        0,    true,     true,     499);

                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    false,    "crnt_vsl_cd");
                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    false,    "crnt_skd_voy_no");
                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    false,    "crnt_skd_dir_cd");
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    false,    "call_sgn_no");
                    InitDataProperty(0, cnt++, dtHidden,       90,     daCenter,    false,    "lloyd_no");
                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    false,    "wbl_no");
                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    false,    "pkup_no");

                    InitDataProperty(0, cnt++, dtHidden,       30,     daCenter,    false,    "mvmt_edi_rslt_cd");
                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    false,    "mvmt_edi_msg_area_cd");
                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    false,    "mvmt_edi_msg_seq");
                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    false,    "mvmt_edi_msg_tp_id");
                    InitDataProperty(0, cnt++, dtHidden,       60,     daCenter,    false,    "mvmt_edi_msg_yrmondy");
                    InitDataProperty(0, cnt++, dtHidden,       40,     daCenter,    false,    "mvmt_edi_tp_cd");
                    // cnmv_rmk가 컬럼이 변경되어도 트랜젝션 상태를 기존값으로 유지하기 위한 Hidden컬럼
                    InitDataProperty(0, cnt++, dtHidden,       30,     daCenter,    false,    "upd_flag");

                    InitDataProperty(0, cnt++, dtHidden,        0,     daCenter,    false,    "vgm_mzd_tp_cd");
                    InitDataProperty(0, cnt++, dtHidden,        0,     daCenter,    false,    "vgm_wgt_ut_cd");
                    InitDataProperty(0, cnt++, dtHidden,        0,     daCenter,    false,    "vgm_wgt_qty");
                    InitDataProperty(0, cnt++, dtHidden,        0,     daCenter,    false,    "vgm_vrfy_dt");
                    InitDataProperty(0, cnt++, dtHidden,        0,     daCenter,    false,    "vgm_sig_ctnt");
                    InitDataProperty(0, cnt++, dtHidden,        0,     daCenter,    false,    "vgm_ref_no");
                    InitDataProperty(0, cnt++, dtHidden,        0,     daCenter,    false,    "vgm_wgt_pty_ctnt");
                    InitDataProperty(0, cnt++, dtHidden,        0,     daCenter,    false,    "vgm_vrfy_ord_ctnt");

                    InitUserFormat2(0, "evnt_dt", "####-##-## ##:##", "-|:");
                    InitUserFormat2(0, "cre_locl_dt", "####-##-## ##:##", "-|:");

                    // 영문자 또는 숫자만 입력
                    InitDataValid(0, "cntr_no", vtEngUpOther, "1234567890");
                    InitDataValid(0, "bkg_no", vtEngUpOther, "1234567890");
                    InitDataValid(0, "vvd_cd", vtEngUpOther, "1234567890");
                    InitDataValid(0, "edi_mvmt_sts_cd", vtEngUpOther, "1234567890");
                    InitDataValid(0, "cntr_full_sts_cd", vtEngUpOther, "1234567890");

                    CountPosition = 0;
                    RequestTimeOut = 36000;
                    SelectHighLight = false;
                }
                break;


            case 2:    //sheet[1] init
                // 높이 설정
                sheetObj.style.height = 377;

                // common_0430.js의 함수
                initSheet2();

                break;
        }
    }


    /**
     * 콤보 Text, Value셋팅
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다
     */
    function initCombo(comboObj, comboId) {
        var frmObj = document.form;
        with (comboObj) {
            UseCode = true;
            switch (comboId) {
                case "tpszCombo":
                    MultiSelect = true;
                    DropHeight = 160;
                    // coCtm.js의 code_get호출
                    var rtnValues = code_get("CNTR_TPSZ_CD", "'N' AND CNTR_TPSZ_CD  NOT IN ('Q2', 'Q4')", "DELT_FLG", "MDM_CNTR_TP_SZ");
                    // cntr_tpsz_cd IBMulticombo생성 (CoCtm.js)
                    parseMultiCombo(comboObj, "^#^" + rtnValues, "ALL^#^" + rtnValues);
                    if (frmObj.cntr_tpsz_cd.value != "") {
                        Text = frmObj.cntr_tpsz_cd.value;
                    } else {
                        Text = "ALL";
                    }
                    break;

                case "statusCombo":    // ComboObject Value Settting
                    MultiSelect = true;
                    DropHeight = 160;
                    InsertItem(0, "ALL", "");
                    InsertItem(1, "OP", "OP");
                    InsertItem(2, "EN", "EN");
                    InsertItem(3, "TN", "TN");
                    InsertItem(4, "OC", "OC");
                    InsertItem(5, "VL", "VL");
                    InsertItem(6, "VD", "VD");
                    InsertItem(7, "IC", "IC");
                    InsertItem(8, "ID", "ID");
                    InsertItem(9, "TS", "TS");
                    InsertItem(10, "MT", "MT");
                    InsertItem(11, "ER", "ER");
                    InsertItem(12, "CP", "CP");
                    InsertItem(13, "CT", "CT");
                    InsertItem(14, "CE", "CE");
                    InsertItem(15, "CO", "CO");
                    InsertItem(16, "CI", "CI");
                    InsertItem(17, "CD", "CD");
                    InsertItem(18, "CM", "CM");
                    InsertItem(19, "ZZ", "ZZ");
                    if (frmObj.edi_mvmt_sts_cd.value != "") {
                        Text = ComReplaceStr(frmObj.edi_mvmt_sts_cd.value, "'", "");
                    } else {
                        Text = "ALL";
                    }
                    break;

                case "mvmt_edi_msg_tp_id":    // ComboObject Value Settting
                    DropHeight = 160;
                    InsertItem(0, "322", "322");
                    InsertItem(1, "COD", "COD");
                    InsertItem(2, "PRV", "PRV");
                    InsertItem(3, "222", "222");
                    InsertItem(4, "SPP", "SPP");
                    InsertItem(5, "ALL (Excl SPP)", "ALL");
                    Code = frmObj.mvmtEdiMsgTpId.value;
                    break;

                case "ioStatusCombo":    // ComboObject Value Settting
                    MultiSelect = true;
                    DropHeight = 160;
                    InsertItem(0, "ALL", "");
                    InsertItem(1, "I|In-Gate", "I");
                    InsertItem(2, "O|Out-Gate", "O");
                    InsertItem(3, "AE|Loaded On Vessel", "AE");
                    InsertItem(4, "UV|Unloaded From Vessel", "UV");
                    InsertItem(5, "A|Arrived. Shipment has arrived at the location specified", "A");
                    InsertItem(6, "AL|Loaded On Rail", "AL");
                    InsertItem(7, "AO|Loaded On Barge", "AO");
                    InsertItem(8, "B|Bad Order (Inoperative or Damaged). Shipment was on a piece of equipment that failed", "B");
                    InsertItem(9, "D|Completed Unloading At Delivery Location. Shipment was delivered to the consignee or receiver", "D");
                    InsertItem(10, "N|No Paperwork Received With Shipment or Equipment", "N");
                    InsertItem(11, "OA|Out-Gate", "OA");
                    InsertItem(12, "P|Departed Terminal Location. Shipment has left the carrier's terminal or other control point", "P");
                    InsertItem(13, "R|Interchange received", "R");
                    InsertItem(14, "RL|Rail Departure From Origin Intermodal Ramp", "RL");
                    InsertItem(15, "UR|Unloaded From A Rail Car", "UR");
                    if (frmObj.edi_gate_io_cd.value != "") {
                        Text = ComReplaceStr(frmObj.edi_gate_io_cd.value, "'", "");
                    } else {
                        Text = "ALL";
                    }
                    break;
            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {

            case IBSEARCH:    //조회
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObjects[0].WaitImageVisible = false;
                    sheetObjects[1].WaitImageVisible = false;
                    ComOpenWait(true);
                    frmObj.vvdcd_change.value = "";
                    appendPageNo = 1;

                    // p_date1과 p_date2의 일자 간격이 5일 이하일 경우 쿼리에 쓰일 IN조건을 생성
                    var getDaysBetween = ComGetDaysBetween(frmObj.p_date1.value, frmObj.p_date2.value);
                    frmObj.p_date3.value = "";
                    if (getDaysBetween < 5) {
                        for (var i=0; i<=getDaysBetween; i++) {
                            if (i > 0) {
                                frmObj.p_date3.value = frmObj.p_date3.value + ", ";
                            }
                            frmObj.p_date3.value = frmObj.p_date3.value + "'" + ComGetUnMaskedValue(ComGetDateAdd(frmObj.p_date1.value, "D", i), "ymd") + "'";
                        }
                    }

                    sheetObjects[1].RemoveAll();
                    ComBtnDisable("btn2_add");
                    ComBtnDisable("btn2_delete");
                    ComBtnDisable("btn2_retrieve");
                    ComBtnDisable("btn2_save");
                    sheetObjects[1].ActionMenu = "";

                    frmObj.f_cmd.value = SEARCH;
                    // IBSEARCHAPPEND를 위해 전역변수에 조회조건 저장
                    appendCondParam = FormQueryString(frmObj);
                    // DoSearch4Fx를 사용하지 않음 (evnt_dt, cre_locl_dt를 일반String으로 GATENEW와 CTM-COMMON에 전달하기 위함)
                    sheetObj.DoSearch("EES_CTM_0404GS.do", appendCondParam);
                }
                break;

            case IBSEARCHAPPEND:    //Append 조회
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObjects[0].WaitImageVisible = false;
                    sheetObjects[1].WaitImageVisible = false;
                    ComOpenWait(true);
                    frmObj.f_cmd.value = SEARCH;
                    // DoSearch사용 (evnt_dt, cre_locl_dt를 날짜타입이 아닌 일반String으로 GATENEW와 CTM-COMMON에 전달하여야 하므로 화면에서만 날짜포맷 적용)
                    sheetObj.DoSearch("EES_CTM_0404GS.do", CondParam, "i_page=" + PageNo, true);
                }
                break;

            case IBSAVE:    //저장
                if (sheetObj.CheckedRows("Sel") < 1) {
                    ComShowCodeMessage("CTM30001");
                    return;
                } else if (sheetObj.CheckedRows("Sel") > 500) {
                    ComShowCodeMessage("CTM10051", "500");
                    return;
                } else if (sheetObj.IsDataModified && !sheetObj.GetSaveString(false, true, "Sel")) {
                    return;
                }
                if (ComShowCodeConfirm("CTM30006")) {
                    sheetObjects[0].WaitImageVisible = false;
                    sheetObjects[1].WaitImageVisible = false;
                    ComOpenWait(true);
                    // 전역변수 초기화
                    okCount = 0;
                    errorCount = 0;
                    ignoredCount = 0;
                    totalCount = 0;
                    errorXml = "";
                    saveXml = new Array();

                    // Object Disable
                    ComBtnDisable("btn_vvdchange");
                    ComBtnDisable("btn_more");
                    ComBtnDisable("btn_detail");
                    ComBtnDisable("btn_downexcel");
                    ComBtnDisable("btn_retrieve");
                    ComBtnDisable("btn_save");
                    DomSetFormObjDisable(frmObj, true);
                    frmObj.tpszCombo.Enable = false;
                    frmObj.statusCombo.Enable = false;
                    frmObj.mvmt_edi_msg_tp_id.Enable = false;
                    frmObj.p_yard2.Enable = false;
                    frmObj.ioStatusCombo.Enable = false;
                    with (sheetObj) {
                        Redraw = false;
                        // sheet[0] Sort
                        ColumnSort("cntr_no|evnt_dt", "ASC", "ASC|ASC", true);

                        var queryString = "";
                        var startIdx = 0;
                        var endIdx = 0;
                        var checkIdxArr = (FindCheckedRow("Sel").substring(0, FindCheckedRow("Sel").length - 1)).split("|");
                        var checkCount = checkIdxArr.length;
                        var loopCount = 0;
                        // check된 행갯수가 sendRows * maxThreadCount(공통)보다 작을 경우
                        if (checkCount < (sendRows * maxThreadCount) + 1) {
                            loopCount = Math.ceil(checkCount / sendRows);
                        // check된 행갯수가 sendRows * maxThreadCount(공통)보다 클 경우
                        } else {
                            sendRows = Math.ceil(checkCount / maxThreadCount);
                            loopCount = maxThreadCount;
                        }

                        for (var i=1; i<=loopCount; i++) {
                            if (i == loopCount) {
                                endIdx = checkCount - 1;
                            } else {
                                endIdx += sendRows;
                                var currStartIdx = Number(startIdx) + Number(endIdx);
                                var currEndIdx = endIdx;
                                // checkIdxArr[endIdx] 다음 check된 행의 Cntr No가 현재행의 Cntr No와 같으면 현재묶음(100행+)에 포함
                                for (var k=currStartIdx; k<=checkCount; k++) {
                                    if (CellValue(checkIdxArr[currEndIdx], "cntr_no") == CellValue(checkIdxArr[k], "cntr_no")) {
                                        endIdx = k;
                                    } else {
                                        break;
                                    }
                                }
                            }

                            // row data추출
                            var tempString = "";
                            for (var h=startIdx; h<=endIdx; h++) {
                                tempString = ("&mvmt_edi_rmk=" + CellValue(checkIdxArr[h], "mvmt_edi_rmk"));
                                queryString += (ComReplaceStr(RowSaveStr(checkIdxArr[h]), tempString, "") + "&");
                                tempString = "";
                            }

                            // 전송
                            xmlHttpPost ("EES_CTM_0404GS.do", queryString + "AJAX=Y&f_cmd=" + MULTI, "rtnUpdateParses", checkIdxArr[startIdx]);
                            queryString = "";

                            // 다수 중복 Cntr No로 인하여 endIdx-startIdx가 sendRows보다 클 경우 그만큼 loop를 이동
                            if ((endIdx-startIdx) > sendRows) {
                                i += (Math.ceil((endIdx-startIdx) / sendRows) - 1);
                            }

                            startIdx = endIdx + 1;
                            sendCount++;
                        }

                        // sheet[0] ReSort
                        ColumnSort("evnt_dt", "ASC", "ASC", true);
                        Redraw = true;
                        HeadCheck(0, "Sel") = false;
                    }
                }
                break;

            case SEARCH16:
                // 로그인 사용자의 서버아이디 조회
                frmObj.user_svr_id.value = ComGetEtcData(sheetObj.GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH16), "rtnValue");
                if (frmObj.mvmtEdiMsgAreaCd.value != "") {
                    frmObj.mvmt_edi_msg_area_cd.value = frmObj.mvmtEdiMsgAreaCd.value;
                } else {
                    var userSvrId = frmObj.user_svr_id.value;
                    if (userSvrId == "KOR" || userSvrId == "CHN" || userSvrId == "SWA" || userSvrId == "EUR" || userSvrId == "USA") {
                        // UI의 Area콤보박스를 로그인 사용자의 서버아이디로 선택되도록 함
                        frmObj.mvmt_edi_msg_area_cd.value = frmObj.user_svr_id.value;
                    } else {
                        frmObj.mvmt_edi_msg_area_cd.value = "";
                        ComBtnDisable("btn_save");
                    }
                }
                break;

            case SEARCH02:    // sheet2 조회
                if (sheetObjects[0].CheckedRows("Sel") < 1) {
                    ComShowCodeMessage("CTM30001");
                    return;
                } else if (sheetObjects[0].CheckedRows("Sel") > 1) {
                    ComShowCodeMessage("CTM20071");
                    return;
                } else {
                    sheetObjects[0].WaitImageVisible = false;
                    sheetObjects[1].WaitImageVisible = false;
                    ComOpenWait(true);
                    var pCntrno = sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow("Sel").split("|")[0], "cntr_no");
        			// 2016.07.25 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
        			var xml = sheetObj.GetSearchXml("EES_CTM_0414GS.do", "f_cmd=" + SEARCH02 + "&p_cntrno=" + pCntrno.substring(0, 10) + "&check_digit=" + pCntrno.substring(10, 11));
        			sheetObj.LoadSearchXml(xml);
        			lastRetrieveDate = ComGetEtcData(xml, "last_retrieve_date");
//					sheetObj.DoSearch("EES_CTM_0414GS.do", "f_cmd=" + SEARCH02 + "&p_cntrno=" + pCntrno.substring(0, 10) + "&check_digit=" + pCntrno.substring(10, 11));
                }
                break;

            case MULTI : // sheet2만 저장 또는 sheet2 저장후 sheet1 저장
                if (validateForm(sheetObj, frmObj, sAction)) {

                	// Correction Reason 필수 항목 미입력 check.
    				var sRowStr = sheetObj.FindStatusRow("U|I|D");
    				var arr = sRowStr.split(";");
    				for (var i=0; i<arr.length-1; i++) {
    					if (sheetObj.CellValue(arr[i], "cnmv_corr_rsn") == "") {
    						ComShowCodeMessage("CTM00000", "Correction Reason");
    						sheetObj.CellEditable(arr[i], "cnmv_corr_rsn") = true;
    						sheetObj.CellEditable(arr[i], "atch_file_sav_id") = true;
    						sheetObj.CellEditable(arr[i], "atch_file_sav_nm") = true;
    						sheetObj.SelectCell(arr[i], "cnmv_corr_rsn");
    						return false;
    					}
    				}

                    // 전역변수 fromSheet1 체크
                    if (fromSheet1 > 0) {
                        if (sheetObj.IsDataModified) {
                            // 별도로 정의 되지는 않았으나 sheet내장함수인 OnValidation으로 true/false를 먼저 check
                            if (sheetObj.GetSaveString()) {
                                var sParam2 = ComSetPrifix(sheetObj.GetSaveString(), "sheet2_");
                                if (sParam2 == "") {
                                    ComShowCodeMessage("CTM20118");
                                    return;
                                }
                                if (ComShowCodeConfirm("CTM30006")) {
                                    var sParam1 = ComSetPrifix(sheetObjects[0].GetSaveString(false, false, "Sel"), "sheet1_");
                                    var arrPrefix = new Array("sheet1_", "sheet2_");
                                    sheetObj.LoadSaveXml(sheetObj.GetSaveXml("EES_CTM_0414GS.do", sParam1 + "&" + sParam2 + "&f_cmd=" + MULTI + "&" + ComGetPrefixParam(arrPrefix)));
                                }
                            }
                        }
                    } else {
                        if (sheetObj.GetSaveString(false) == "") {
                            ComShowCodeMessage("CTM20118");
                            return;
                        }

        				// Insert, Update가 있을 경우, 현재 화면에 출력된 데이터가 최신인지 아닌지 check logic 추가
        				sRowStr = sheetObj.FindStatusRow("I|D");
        				if (sRowStr.length > 0) {
        					var param = "f_cmd=" + SEARCH03;
        					param += "&cntr_no=" + sheetObjects[0].CellValue(sheetObjects[0].FindCheckedRow("Sel").split("|")[0], "cntr_no");
        					param += "&upd_dt=" + lastRetrieveDate;
        					var xml = sheetObj.GetSearchXml("EES_CTM_0430GS.do", param);
        					var rowCount = ComGetEtcData(xml, "row_count");
        					if (Number(rowCount) > 0) {
        						ComShowCodeMessage("CTM30017");
        						return;
        					}
        				}

                        sheetObj.RemoveEtcData();
                        sheetObj.doSave("EES_CTM_0430GS.do", "f_cmd=" + MULTI);
                    }
                }
                break;
        }
    }


    function rtnUpdateParses(rtnXml, startId) {
        sendCount--;
        if (!ComGetEtcData(rtnXml, "total_count")) {
            errorXml = rtnXml;
        } else {
            rtnXml = ComReplaceStr(rtnXml, "^#^", "'");
            okCount += Number(ComGetEtcData(rtnXml, "ok_count"));
            errorCount += Number(ComGetEtcData(rtnXml, "error_count"));
            ignoredCount += Number(ComGetEtcData(rtnXml, "ignored_count"));
            totalCount += Number(ComGetEtcData(rtnXml, "total_count"));
            saveXml[sendCount] = rtnXml;
        }
        if (sendCount < 1) {
           var frmObj = document.form;
            // Object Enable
            ComBtnEnable("btn_vvdchange");
            ComBtnEnable("btn_more");
            ComBtnEnable("btn_detail");
            ComBtnEnable("btn_downexcel");
            ComBtnEnable("btn_retrieve");
            ComBtnEnable("btn_save");
            DomSetFormObjDisable(frmObj, false);
            frmObj.tpszCombo.Enable = true;
            frmObj.statusCombo.Enable = true;
            frmObj.mvmt_edi_msg_tp_id.Enable = true;
            frmObj.p_yard2.Enable = true;
            frmObj.ioStatusCombo.Enable = true;
            ComOpenWait(false);
            sheetObjects[1].WaitImageVisible = true;
            sheetObjects[0].WaitImageVisible = true;
            if (errorXml != "") {
                sheetObjects[0].LoadSaveXml(errorXml);
            } else {
                ComOpenPopup("/hanjin/EES_CTM_0432.do" +
                             "?ok_count=" + okCount +
                             "&error_count=" + errorCount +
                             "&ignored_count=" + ignoredCount +
                             "&total_count=" + totalCount, 300, 250, "", "0,1", true);
            }
        }
    }


    /**
     * EES_CTM_0432 팝업에서 호출하는 fucntion
     */
    function popup0432Function(event) {
        var frmObj = document.form;

        // error data 내용을 sheet[0]에 display
        if (event == "errorView") {
            with (sheetObjects[0]) {
                RemoveAll();
                Redraw = false;
                WaitImageVisible = false;
                sheetObjects[1].WaitImageVisible = false;
                ComOpenWait(true);
                // sheet[0]로 saveXml의 데이터 로드
                for (var i=0; i<=saveXml.length-1; i++) {
                    LoadSearchXml(saveXml[i], true);
                }
                // sheet[0] sort
                ColumnSort("evnt_dt", "ASC", "ASC", true);
                Redraw = true;
                if (RowCount > 0) {
                    ComBtnEnable("btn_detail");
                    ComBtnEnable("btn_vvdchange");
                }
                ComBtnDisable("btn_more");
            }
            var frmObj = document.form;
            frmObj.disp_total.value = "";
            frmObj.rtv_total.value = "";
            frmObj.gnd_total.value = "";

        // 화면 clear
        } else if (event == "reset") {
            sheetObjects[0].RemoveAll();
            var frmObj = document.form;
            frmObj.disp_total.value = "";
            frmObj.rtv_total.value = "";
            frmObj.gnd_total.value = "";
            // button Disable
            ComBtnDisable("btn_more");
            ComBtnDisable("btn_detail");
            ComBtnDisable("btn_vvdchange");
            ComBtnDisable("btn2_add");
            ComBtnDisable("btn2_delete");
            ComBtnDisable("btn2_retrieve");
            ComBtnDisable("btn2_save");
            // focus
            frmObj.p_date1.focus();
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
            case "cntrno_disp":
            // cntrno_disp에 입력되는 값의 length에 따른 처리
            	frmObj.cntrno_disp.value = frmObj.cntrno_disp.value.toUpperCase();
                var cntrnoDisp = frmObj.cntrno_disp;
                if (cntrnoDisp.value.length > 1) {
                    frmObj.p_cntrno.value = cntrnoDisp.value;
                    if (cntrnoDisp.value.length > 9) {
                        // p_cntrno에 10글자가 채워지면 CTM공통함수의 cntr_search호출
                        if (!cntr_search()) {
                            cntrnoDisp.select();
                            cntrnoDisp.focus();
                        } else {
                            // 정상적인 경우 CTM공통함수의 setFocusIndex호출(다음 Element에 Focus)
                            setFocusIndex(event.srcElement, 1);
                        }
                    } else {
                        frmObj.check_digit.value = "";
                    }
                } else {
                    frmObj.p_cntrno.value = "";
                    frmObj.check_digit.value = "";
                }
                break;

            case "yd_cd_disp":
            // yd_cd_disp에 입력되는 값의 length에 따른 처리
                var ydCdDisp = frmObj.yd_cd_disp;
                if (ydCdDisp.value.length > 1) {
                    frmObj.p_yard1.value = ydCdDisp.value;
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

            case "vvdcd_change":
            // vvdcd_change에 입력되는 값의 length에 따른 처리
                var vvdCd = frmObj.vvdcd_change;
                if (vvdCd.value.length > 8) {
                    var xml = sheetObj.GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH12 + "&vvdcode=" + vvdCd.value);
                    var rtnValue = ComGetEtcData(xml, "rtnValue");
                    if (rtnValue) {
                        if (sheetObj.CheckedRows("Sel") < 1) return;
                        if (sheetObj.RowCount < 1) return;
                    } else {
                        sheetObj.LoadSearchXml(xml);
                        vvdCd.select();
                        vvdCd.focus();
                    }
                }
                break;

            case "lcc_cd":
            case "rcc_cd":
            // lcc_cd나 rcc_cd에 입력되는 값의 length에 따른 처리
                var loc_cd = event.srcElement;
                // lcc_cd나 rcc_cd에 5글자가 채워지면 CTM공통함수의 code_search() 호출
                if (loc_cd.value.length > 4) {
                    // 결과값이 false면 Table에 해당 value가 없다는 것이므로 해당 element에 focus
                    if (!code_search(loc_cd.value, "LOC_CD", "MDM_LOCATION")) {
                        event.srcElement.select();
                        event.srcElement.focus();
                    // 결과값이 true면 다음 element에 focus
                    } else {
                        setFocusIndex(loc_cd, 1);
                    }
                }
              break;
        }
        onShowErrMsg = false;    // CoCtm.js의 공통스크립트의 자동실행 방지용
    }


    /**
     * HTML Object의 OnChange이벤트 처리
     */
    function obj_onchange(event) {
        var frmObj = document.form;
        switch(event.srcElement.name) {
            // vvdsts_change_combo선택에 따른 처리
            case "vvdsts_change_combo":
                var vvdStsCombo = frmObj.vvdsts_change_combo;
                if (vvdStsCombo.value == "VVD") {
                    frmObj.vvdcd_change.style.display = "inline";
                    frmObj.stscd_change.style.display = "none";
                    frmObj.stscd_change.selectedIndex = 0;
                    frmObj.vvdcd_change.focus();
                } else {
                    frmObj.stscd_change.style.display = "inline";
                    frmObj.vvdcd_change.style.display = "none";
                    frmObj.vvdcd_change.value = "";
                    frmObj.stscd_change.focus();
                }
                break;
                
                // mvmt_edi_rslt_cd선택에 따른 팝업버튼처리
                case "mvmt_edi_rslt_cd":
                    var mvmtRsltCd = frmObj.mvmt_edi_rslt_cd;
                    if (mvmtRsltCd.value == "N") {
                        DomSetFormObjDisable(document.form, false);
                    } else {
                        DomSetFormObjDisable(document.form, true);
                        frmObj.err_msg.value = "";
                    }
                    break;
        }
        onShowErrMsg = false;
    }


    /**
     * tpszCombo의 MultiSelection OnCheckClick 이벤트 처리
     */
    function tpszCombo_OnCheckClick(comboObj, index, code) {
        // coCtm의 multiComboOnCheckClick 호출
        multiComboOnCheckClick(comboObj, index, document.form.cntr_tpsz_cd);
    }


    /**
     * statusCombo의 MultiSelection OnCheckClick 이벤트 처리
     */
    function statusCombo_OnCheckClick(comboObj, index, code) {
        // coCtm의 multiComboOnCheckClick 호출
        multiComboOnCheckClick(comboObj, index, document.form.edi_mvmt_sts_cd);
    }


    /**
     * mvmt_edi_msg_tp_id의 MultiSelection OnChange 이벤트 처리
     */
    function mvmt_edi_msg_tp_id_OnChange(comboObj, Index_Code, Text) {
        var mvmtEdiRsltCd = document.form.mvmt_edi_rslt_cd;
        if (Index_Code == "SPP") {
            mvmtEdiRsltCd.value = "Y";
            ComEnableObject(mvmtEdiRsltCd, false);
        } else {
            mvmtEdiRsltCd.value = "N";
            ComEnableObject(mvmtEdiRsltCd, true);
        }
    }


    /**
     * ioStatusCombo의 MultiSelection OnCheckClick 이벤트 처리
     */
    function ioStatusCombo_OnCheckClick(comboObj, index, code) {
        // coCtm의 multiComboOnCheckClick 호출
        multiComboOnCheckClick(comboObj, index, document.form.edi_gate_io_cd);
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var frmObj = document.form;
            with(sheetObj) {
                frmObj.disp_total.value = ComAddComma(RowCount);

                // 첫조회(Append조회가 아닌) 라면..
                if (appendPageNo < 2) {
                    frmObj.rtv_total.value = ComAddComma(EtcData("rtv_total"));
                    // 조회조건의 mvmt_edi_rslt_cd가 X가 아니면 GRAND TOTAL을 표기 (APPEND 검색 대비)
                    if (EtcData("mvmt_edi_rslt_cd") == "X") {
                        frmObj.gnd_total.value = "";
                    } else {
                        frmObj.gnd_total.value = ComAddComma(EtcData("gnd_total"));
                    }
                    if (RowCount > 0) {
                        ComBtnEnable("btn_detail");
                        ComBtnEnable("btn_vvdchange");
                        ComBtnEnable("btn2_retrieve");
                    } else {
                        ComBtnDisable("btn_detail");
                        ComBtnDisable("btn_vvdchange");
                        ComBtnDisable("btn2_retrieve");
                    }
                }

                // EDI Result값에 따라 ROW의 편집상태 변경
                row_Editable(sheetObj, appendPageNo, frmObj.pagerows.value);

                if (RowCount < ComGetUnMaskedValue(frmObj.rtv_total.value, "int")) {
                    // APPEND 검색을 위한 페이지번호 setting
                    appendPageNo = Math.ceil(RowCount / frmObj.pagerows.value) + 1;
                    ComBtnEnable("btn_more");
                } else {
                    ComBtnDisable("btn_more");
                }
            }

            // UI의 Area콤보박스를 로그인 사용자의 서버아이디가 같을때는 Save버튼 활성화
            if (frmObj.user_svr_id.value == frmObj.mvmt_edi_msg_area_cd.value) {
                ComBtnEnable("btn_save");
            } else {
                ComBtnDisable("btn_save");
            }
        }
        ComOpenWait(false);
        sheetObjects[1].WaitImageVisible = true;
        sheetObjects[0].WaitImageVisible = true;
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
        with(sheetObj) {
            if (ColSaveName(Col) != "Sel") {
                // row클릭시 해당 Check Box도 체크
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
                        if (CellEditable(arr[i], "Sel")) {
                            CellValue2(arr[i], "Sel") = "1";    // 선택된 행의 CheckBox 체크
                        }
                    }
                }
// HeadCheck 로직
//                if (CheckedRows("Sel") == RowCount) {
//                    HeadCheck(0, "Sel") = true;
//                }
//            } else {
//                ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 더블클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
        with (sheetObj) {
            if (ColSaveName(Col) != "Sel") {
                ComOpenPopup("/hanjin/EES_CTM_0442.do" +
                             "?mvmt_edi_msg_area_cd=" + Cellvalue(Row, "mvmt_edi_msg_area_cd") +
                             "&mvmt_edi_msg_seq=" + Cellvalue(Row, "mvmt_edi_msg_seq") +
                             "&mvmt_edi_msg_tp_id=" + Cellvalue(Row, "mvmt_edi_msg_tp_id") +
                             "&mvmt_edi_msg_yrmondy=" + Cellvalue(Row, "mvmt_edi_msg_yrmondy") +
                             "&mvmt_edi_tp_cd=" + Cellvalue(Row, "mvmt_edi_tp_cd"), 920, 485, "", "0,1");
            }
        }
    }


    /**
     * Sheet1의 OnKeyUp 이벤트 처리
     */
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        with (sheetObj) {
            switch(ColSaveName(Col)) {
                case "cntr_no":
                    if (EditValue.length > 10) {
                        SelectCell(Row, Col++);
                    }
                    break;
            }
        }
    }


    /**
     * Sheet1의 OnChange 이벤트 처리
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            // 변경된 행의 CheckBox 체크
            if (ColSaveName(Col) != "Sel") {
                CellValue2(Row, "Sel") = "1";
            }
            // cnmv_rmk가 컬럼이 변경되었을 경우는 updateflag에 RowStatus값을 복사
            if (ColSaveName(Col) == "cnmv_rmk") {
                RowStatus(Row) = (CellValue(Row, "upd_flag") == "" ? "R" : CellValue(Row, "upd_flag"));
            } else {
                CellValue2(Row, "upd_flag") =  RowStatus(Row);
            }
            if (Value != CellSearchValue(Row, Col)) {
                switch(ColSaveName(Col)) {
                    case "cntr_no":
                        var xml = GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + Value);
                        rtnValue = ComGetEtcData(xml, "rtnValue");
                        if (!rtnValue) {
                            CellValue2(Row, "cntr_tpsz_cd") = CellSearchValue(Row, "cntr_tpsz_cd");
                            LoadSearchXml(xml);
                            sheetValidation = false;
                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                        } else {
                            sheetValidation = true;
                            // rtnValue = "CNTR_NO"|"CNMV_STS_CD"|"CNTR_TPSZ_CD"|"CRNT_YD_CD"|"ACIAC_DIV_CD"|"HJS_CRE_FLG"|"IMDT_EXT_FLG"
                            var arr = rtnValue.split("|");
                            CellValue2(Row, "cntr_tpsz_cd") = arr[2];
                            SelectCell(Row, "cntr_tpsz_cd");
                        }
                        break;

                    case "bkg_no":
                        // 결과값이 false면 Table에 해당 value가 없다는 것이므로 해당 Cell에 focus
                        if (Value != "" && !code_search(Value, "BKG_NO", "BKG_BOOKING")) {
                            sheetValidation = false;
                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                        } else {
                            sheetValidation = true;
                        }
                        break;

                    case "vvd_cd":
                        var xml = GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH12 + "&vvdcode=" + Value);
                        var rtnValue = ComGetEtcData(xml, "rtnValue");
                        if (!rtnValue) {
                            LoadSearchXml(xml);
                            sheetValidation = false;
                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                        } else {
                            sheetValidation = true;
                            CellValue2(Row, "crnt_vsl_cd") = Value.substring(0, 4);
                            CellValue2(Row, "crnt_skd_voy_no") = Value.substring(4, 8);
                            CellValue2(Row, "crnt_skd_dir_cd") = Value.substring(8, 9);
                        }
                        break;

                    case "edi_mvmt_sts_cd":
                        var xml = GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH09 + "&mvmt_sts_cd=" + Value);
                        var rtnValue = ComGetEtcData(xml, "rtnValue");
                        if (rtnValue == "0" || rtnValue == "") {
                            ComShowCodeMessage("CTM20102");
                            sheetValidation = false;
                            SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                        } else {
                            sheetValidation = true;
                        }
                        break;
                }
            }
        }
    }


    /**
     * EDI Result, Movement Status Cd에 따라 ROW의 편집상태 변경
     */
    function row_Editable(sheetObj, PageNo, OnePageRows) {
        var startRowNo = OnePageRows * (PageNo - 1) + 1;
        var endRowNo = OnePageRows * PageNo;
        with (sheetObj) {
            Redraw = false;
            for (var i=startRowNo; i<=endRowNo; i++) {
                if (CellValue(i, "mvmt_edi_rslt_cd") == "Y" || CellValue(i, "mvmt_edi_sght_cd") == "X") {
                    RowEditable(i) = false;
                } else {
                    if (CellValue(i, "edi_mvmt_sts_cd") != "VL" && CellValue(i, "edi_mvmt_sts_cd") != "VD") {
                        CellEditable(i, "vvd_cd") = false;
                    }
                }
            }
            Redraw = true;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
        with (frmObj) {
            /* Date format이 validation이 실패한 경우 경우 return false로 service 호출을 막음 */
//            if (sAction == IBSEARCH) {
//             if (cancelDate == false) return false;
//            }
        	var tmpobjValue = frmObj.p_date1.value;
        	var tmpobjValue2 = frmObj.p_date2.value;
            // 전체 내용중 -를 삭제.
        	
        	tmpobjValue = ComGetUnMaskedValue(tmpobjValue, "ymd");
            tmpobjValue2 = ComGetUnMaskedValue(tmpobjValue2, "ymd");
            if (!ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue2) || !ComIsDate(tmpobjValue2)) {
				return false;
            } else {
                    date1 = document.getElementById("p_date1").value;
                    date2 = document.getElementById("p_date2").value;
                    date1 = ComGetUnMaskedValue(date1, "ymd");
                    date2 = ComGetUnMaskedValue(date2, "ymd");
                    if (date1 == '' || date2 == '') return;
                    if (date1 > date2) {
                    	ComShowCodeMessage("CTM10114");
                    	frmObj.p_date1.focus();
                        return false;
                    }

            }
        }
        return true;
    }


    /**
     * 저장 함수를 이용하여 저장이 완료되면 다시 조회 <br>
     * @param {ibsheet} Event       IBSheet 저장 후 발생하는 Event
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var rtnStr = sheetObj.EtcData("rtnStr");
            if (rtnStr != null && rtnStr != "" && rtnStr !=  "undefined") {
                ComShowMessage(rtnStr);
            } else {
                // 전역변수 fromSheet1 체크
                if (fromSheet1 > 0) {
                    var sheet1selectRow = sheetObjects[0].FindCheckedRow("Sel").split("|")[0];
                    sheetObjects[0].CellValue(sheet1selectRow, "rty_knt") = parseInt(sheetObjects[0].CellValue(sheet1selectRow, "rty_knt")) + 1;
                    sheetObjects[0].CellValue(sheet1selectRow, "mvmt_edi_rmk") = "OK.PROCESSED";
                    sheetObjects[0].CellValue(sheet1selectRow, "mvmt_edi_rslt_cd") = "Y";
                }
            }
            fromSheet1 = 0;
            doActionIBSheet(sheetObj, document.form, SEARCH02);
        }
    }


    /**
     * Sheet2의 OnSearchEnd 이벤트 처리
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
        if (ErrMsg == "") {
            if (sheetObj.RowCount > 0) {
                var frmObj = document.form;
                DomSetFormObjDisable(frmObj, true);
                frmObj.statusCombo.Enable = false;
                frmObj.mvmt_edi_msg_tp_id.Enable = false;
                frmObj.p_yard2.Enable = false;
                frmObj.ioStatusCombo.Enable = false;
                sheetObjects[0].Editable = false;
                sheetObjects[1].ActionMenu = "Insert|Overwrite";
                ComBtnDisable("btn_vvdchange");
                ComBtnDisable("btn_more");
                ComBtnDisable("btn_retrieve");
                ComBtnDisable("btn_save");
                ComBtnEnable("btn2_add");
                ComBtnEnable("btn2_delete");
                ComBtnEnable("btn2_save");
                // common_0430.js의 함수
                row_Editable4Sheet2();

            } else {
                ComBtnDisable("btn2_add");
                ComBtnDisable("btn2_delete");
                ComBtnDisable("btn2_save");
            }
        }
        sheetObjects[0].WaitImageVisible = true;
        sheetObjects[1].WaitImageVisible = true;
    }


    /**
     * Sheet2의 OnMouseDown 이벤트 처리
     */
    function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
        with(sheetObj) {
            if (RowCount > 0) {
                // click한 row와 아래 row가 모두 RowEditable이 false면 btn2_add를 disable - 2010-07-08 : Rqst by IHJang
                if (!RowEditable(MouseRow) && !RowEditable(MouseRow + 1)) {
                    ComBtnDisable("btn2_add");
                    ActionMenu = "";
                } else {
                    ComBtnEnable("btn2_add");
                    ActionMenu = "Insert|Overwrite";
                    if (Button == 2) {
                        SelectRow = MouseRow;
                    }
                }
            }
        }
    }


    /**
     * Sheet2의 OnSelectMenu 이벤트 처리
     */
    function sheet2_OnSelectMenu(sheetObj, MenuString) {
        var sheet1CheckRow = sheetObjects[0].FindCheckedRow("Sel").split("|")[0];
        with (sheetObj) {
            switch (MenuString) {
                case "Insert":
                    if (!addRow()) return;

                    var row = SelectRow;    // 반드시 addRow()함수 호출뒤에 정의 할것

                    if (CellEditable(row, "mvmt_sts_cd") && sheetObjects[0].CellValue(sheet1CheckRow, "edi_mvmt_sts_cd") != "") {
                        CellValue(row, "mvmt_sts_cd") = sheetObjects[0].CellValue(sheet1CheckRow, "edi_mvmt_sts_cd");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (CellEditable(row, "org_yd_cd") && sheetObjects[0].CellValue(sheet1CheckRow, "evnt_yd_cd") != "") {
                        CellValue(row, "org_yd_cd") = sheetObjects[0].CellValue(sheet1CheckRow, "evnt_yd_cd");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (CellEditable(row, "cnmv_evnt_dt") && sheetObjects[0].CellText(sheet1CheckRow, "evnt_dt") != "") {
                        CellValue(row, "cnmv_evnt_dt") = sheetObjects[0].CellText(sheet1CheckRow, "evnt_dt");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (CellEditable(row, "cntr_id") && sheetObjects[0].CellValue(sheet1CheckRow, "vvd_cd") != "") {
                        CellValue(row, "cntr_id") = sheetObjects[0].CellValue(sheet1CheckRow, "vvd_cd");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (CellEditable(row, "vndr_seq") && (sheetObjects[0].CellValue(sheet1CheckRow, "vndr_seq") != "" && sheetObjects[0].CellValue(sheet1CheckRow, "vndr_seq") != "0")) {
                        CellValue(row, "vndr_seq") = sheetObjects[0].CellValue(sheet1CheckRow, "vndr_seq");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (CellEditable(row, "chss_no") && sheetObjects[0].CellValue(sheet1CheckRow, "chss_no") != "") {
                        CellValue(row, "chss_no") = sheetObjects[0].CellValue(sheet1CheckRow, "chss_no");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (CellEditable(row, "mgst_no") && sheetObjects[0].CellValue(sheet1CheckRow, "mgst_no") != "") {
                        CellValue(row, "mgst_no") = sheetObjects[0].CellValue(sheet1CheckRow, "mgst_no");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (CellEditable(row, "cntr_seal_no") && sheetObjects[0].CellValue(sheet1CheckRow, "cntr_seal_no") != "") {
                        CellValue(row, "cntr_seal_no") = sheetObjects[0].CellValue(sheet1CheckRow, "cntr_seal_no");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (CellEditable(row, "wbl_no") && sheetObjects[0].CellValue(sheet1CheckRow, "wbl_no") != "") {
                        CellValue(row, "wbl_no") = sheetObjects[0].CellValue(sheet1CheckRow, "wbl_no");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (CellEditable(row, "pkup_no") && sheetObjects[0].CellValue(sheet1CheckRow, "pkup_no") != "") {
                        CellValue(row, "pkup_no") = sheetObjects[0].CellValue(sheet1CheckRow, "pkup_no");
                    }
                    if (!sheet2valid) {
                        RowDelete(row, false);
                        sheet2valid = true;
                        return;
                    }

                    if (sheetObjects[0].CellValue(sheet1CheckRow, "mvmt_edi_msg_area_cd") != "") {
                        CellValue2(row, "mvmt_edi_msg_area_cd") = sheetObjects[0].CellValue(sheet1CheckRow, "mvmt_edi_msg_area_cd");
                    }
                    if (sheetObjects[0].CellValue(sheet1CheckRow, "mvmt_edi_msg_seq") != "") {
                        CellValue2(row, "mvmt_edi_msg_seq") = sheetObjects[0].CellValue(sheet1CheckRow, "mvmt_edi_msg_seq");
                    }
                    if (sheetObjects[0].CellValue(sheet1CheckRow, "mvmt_edi_msg_yrmondy") != "") {
                        CellValue2(row, "mvmt_edi_msg_yrmondy") = sheetObjects[0].CellValue(sheet1CheckRow, "mvmt_edi_msg_yrmondy");
                    }
                    if (sheetObjects[0].CellValue(sheet1CheckRow, "mvmt_edi_tp_cd") != "") {
                        CellValue2(row, "mvmt_edi_tp_cd") = sheetObjects[0].CellValue(sheet1CheckRow, "mvmt_edi_tp_cd");
                    }

                    break;


                case "Overwrite":

                    var row = SelectRow;

                    if (!RowEditable(row)) {
                        ComShowCodeMessage("CTM20108");
                        return;

                    } else {
                        // sheetObj.ReturnData(Row)를 사용하면 [Row Add] 한 다음 새로 생성된 row에
                        //   [Overwrite]시에 error가 발생하므로 아래와 같이 구현
                        var mvmtStsCd = CellText(row, "mvmt_sts_cd") + "";
                        var orgYdCd = CellText(row, "org_yd_cd") + "";
                        var destYdCd = CellText(row, "dest_yd_cd") + "";
                        var cnmvEvntDt = CellText(row, "cnmv_evnt_dt");
                        var cntrId = CellText(row, "cntr_id") + "";
                        var vndrSeq = CellText(row, "vndr_seq") + "";
                        var chssNo = CellText(row, "chss_no") + "";
                        var mgstNo = CellText(row, "mgst_no") + "";
                        var cntrSealNo = CellText(row, "cntr_seal_no") + "";
                        var wblNo = CellText(row, "wbl_no") + "";
                        var pkupNo = CellText(row, "pkup_no") + "";

                        if (CellEditable(row, "mvmt_sts_cd") && sheetObjects[0].CellValue(sheet1CheckRow, "edi_mvmt_sts_cd") != "") {
                            CellValue(row, "mvmt_sts_cd") = sheetObjects[0].CellValue(sheet1CheckRow, "edi_mvmt_sts_cd");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "mvmt_sts_cd", true);
                            return;
                        }

                        if (CellEditable(row, "org_yd_cd") && sheetObjects[0].CellValue(sheet1CheckRow, "evnt_yd_cd") != "") {
                            CellValue(row, "org_yd_cd") = sheetObjects[0].CellValue(sheet1CheckRow, "evnt_yd_cd");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "org_yd_cd")) CellValue2(row, "org_yd_cd") = orgYdCd;
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "org_yd_cd", true);
                            return;
                        }

                        if (CellEditable(row, "cnmv_evnt_dt") && sheetObjects[0].CellText(sheet1CheckRow, "evnt_dt") != "") {
                            CellValue(row, "cnmv_evnt_dt") = sheetObjects[0].CellText(sheet1CheckRow, "evnt_dt");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "cnmv_evnt_dt")) CellValue2(row, "cnmv_evnt_dt") = cnmvEvntDt;
                            if (CellEditable(row, "dest_yd_cd")) CellValue2(row, "dest_yd_cd") = destYdCd;
                            if (CellEditable(row, "org_yd_cd")) CellValue2(row, "org_yd_cd") = orgYdCd;
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "cnmv_evnt_dt", true);
                            return;
                        }

                        if (CellEditable(row, "cntr_id") && sheetObjects[0].CellValue(sheet1CheckRow, "vvd_cd") != "") {
                            CellValue(row, "cntr_id") = sheetObjects[0].CellValue(sheet1CheckRow, "vvd_cd");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "cntr_id")) CellValue2(row, "cntr_id") = cntrId;
                            if (CellEditable(row, "cnmv_evnt_dt")) CellValue2(row, "cnmv_evnt_dt") = cnmvEvntDt;
                            if (CellEditable(row, "dest_yd_cd")) CellValue2(row, "dest_yd_cd") = destYdCd;
                            if (CellEditable(row, "org_yd_cd")) CellValue2(row, "org_yd_cd") = orgYdCd;
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "cntr_id", true);
                            return;
                        }

                        if (CellEditable(row, "vndr_seq") && (sheetObjects[0].CellValue(sheet1CheckRow, "vndr_seq") != "" && sheetObjects[0].CellValue(sheet1CheckRow, "vndr_seq") != "0")) {
                            CellValue(row, "vndr_seq") = sheetObjects[0].CellValue(sheet1CheckRow, "vndr_seq");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "vndr_seq")) CellValue2(row, "vndr_seq") = vndrSeq;
                            if (CellEditable(row, "cntr_id")) CellValue2(row, "cntr_id") = cntrId;
                            if (CellEditable(row, "cnmv_evnt_dt")) CellValue2(row, "cnmv_evnt_dt") = cnmvEvntDt;
                            if (CellEditable(row, "dest_yd_cd")) CellValue2(row, "dest_yd_cd") = destYdCd;
                            if (CellEditable(row, "org_yd_cd")) CellValue2(row, "org_yd_cd") = orgYdCd;
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "vndr_seq", true);
                            return;
                        }

                        if (CellEditable(row, "chss_no") && sheetObjects[0].CellValue(sheet1CheckRow, "chss_no") != "") {
                            CellValue(row, "chss_no") = sheetObjects[0].CellValue(sheet1CheckRow, "chss_no");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "chss_no")) CellValue2(row, "chss_no") = chssNo;
                            if (CellEditable(row, "vndr_seq")) CellValue2(row, "vndr_seq") = vndrSeq;
                            if (CellEditable(row, "cntr_id")) CellValue2(row, "cntr_id") = cntrId;
                            if (CellEditable(row, "cnmv_evnt_dt")) CellValue2(row, "cnmv_evnt_dt") = cnmvEvntDt;
                            if (CellEditable(row, "dest_yd_cd")) CellValue2(row, "dest_yd_cd") = destYdCd;
                            if (CellEditable(row, "org_yd_cd")) CellValue2(row, "org_yd_cd") = orgYdCd;
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "chss_no", true);
                            return;
                        }

                        if (CellEditable(row, "mgst_no") && sheetObjects[0].CellValue(sheet1CheckRow, "mgst_no") != "") {
                            CellValue(row, "mgst_no") = sheetObjects[0].CellValue(sheet1CheckRow, "mgst_no");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "mgst_no")) CellValue2(row, "mgst_no") = mgstNo;
                            if (CellEditable(row, "chss_no")) CellValue2(row, "chss_no") = chssNo;
                            if (CellEditable(row, "vndr_seq")) CellValue2(row, "vndr_seq") = vndrSeq;
                            if (CellEditable(row, "cntr_id")) CellValue2(row, "cntr_id") = cntrId;
                            if (CellEditable(row, "cnmv_evnt_dt")) CellValue2(row, "cnmv_evnt_dt") = cnmvEvntDt;
                            if (CellEditable(row, "dest_yd_cd")) CellValue2(row, "dest_yd_cd") = destYdCd;
                            if (CellEditable(row, "org_yd_cd")) CellValue2(row, "org_yd_cd") = orgYdCd;
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "mgst_no", true);
                            return;
                        }

                        if (CellEditable(row, "cntr_seal_no") && sheetObjects[0].CellValue(sheet1CheckRow, "cntr_seal_no") != "") {
                            CellValue(row, "cntr_seal_no") = sheetObjects[0].CellValue(sheet1CheckRow, "cntr_seal_no");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "cntr_seal_no")) CellValue2(row, "cntr_seal_no") = cntrSealNo;
                            if (CellEditable(row, "mgst_no")) CellValue2(row, "mgst_no") = mgstNo;
                            if (CellEditable(row, "chss_no")) CellValue2(row, "chss_no") = chssNo;
                            if (CellEditable(row, "vndr_seq")) CellValue2(row, "vndr_seq") = vndrSeq;
                            if (CellEditable(row, "cntr_id")) CellValue2(row, "cntr_id") = cntrId;
                            if (CellEditable(row, "cnmv_evnt_dt")) CellValue2(row, "cnmv_evnt_dt") = cnmvEvntDt;
                            if (CellEditable(row, "dest_yd_cd")) CellValue2(row, "dest_yd_cd") = destYdCd;
                            if (CellEditable(row, "org_yd_cd")) CellValue2(row, "org_yd_cd") = orgYdCd;
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "cntr_seal_no", true);
                            return;
                        }

                        if (CellEditable(row, "wbl_no") && sheetObjects[0].CellValue(sheet1CheckRow, "wbl_no") != "") {
                            CellValue(row, "wbl_no") = sheetObjects[0].CellValue(sheet1CheckRow, "wbl_no");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "wbl_no")) CellValue2(row, "wbl_no") = wblNo;
                            if (CellEditable(row, "cntr_seal_no")) CellValue2(row, "cntr_seal_no") = cntrSealNo;
                            if (CellEditable(row, "mgst_no")) CellValue2(row, "mgst_no") = mgstNo;
                            if (CellEditable(row, "chss_no")) CellValue2(row, "chss_no") = chssNo;
                            if (CellEditable(row, "vndr_seq")) CellValue2(row, "vndr_seq") = vndrSeq;
                            if (CellEditable(row, "cntr_id")) CellValue2(row, "cntr_id") = cntrId;
                            if (CellEditable(row, "cnmv_evnt_dt")) CellValue2(row, "cnmv_evnt_dt") = cnmvEvntDt;
                            if (CellEditable(row, "dest_yd_cd")) CellValue2(row, "dest_yd_cd") = destYdCd;
                            if (CellEditable(row, "org_yd_cd")) CellValue2(row, "org_yd_cd") = orgYdCd;
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "wbl_no", true);
                            return;
                        }

                        if (CellEditable(row, "pkup_no") && sheetObjects[0].CellValue(sheet1CheckRow, "pkup_no") != "") {
                            CellValue(row, "pkup_no") = sheetObjects[0].CellValue(sheet1CheckRow, "pkup_no");
                        }
                        if (!sheet2valid) {
                            if (CellEditable(row, "pkup_no")) CellValue2(row, "pkup_no") = pkupNo;
                            if (CellEditable(row, "wbl_no")) CellValue2(row, "wbl_no") = wblNo;
                            if (CellEditable(row, "cntr_seal_no")) CellValue2(row, "cntr_seal_no") = cntrSealNo;
                            if (CellEditable(row, "mgst_no")) CellValue2(row, "mgst_no") = mgstNo;
                            if (CellEditable(row, "chss_no")) CellValue2(row, "chss_no") = chssNo;
                            if (CellEditable(row, "vndr_seq")) CellValue2(row, "vndr_seq") = vndrSeq;
                            if (CellEditable(row, "cntr_id")) CellValue2(row, "cntr_id") = cntrId;
                            if (CellEditable(row, "cnmv_evnt_dt")) CellValue2(row, "cnmv_evnt_dt") = cnmvEvntDt;
                            if (CellEditable(row, "dest_yd_cd")) CellValue2(row, "dest_yd_cd") = destYdCd;
                            if (CellEditable(row, "org_yd_cd")) CellValue2(row, "org_yd_cd") = orgYdCd;
                            if (CellEditable(row, "mvmt_sts_cd")) CellValue2(row, "mvmt_sts_cd") = mvmtStsCd;
                            sheet2valid = true;
                            clearStatus(sheetObj, row);
                            clearColor(sheetObj, row);
                            SelectCell(row, "pkup_no", true);
                            return;
                        }
                    }
                    break;
            }
        fromSheet1 ++;
        }
    }


    /**
     * clearColor 함수정의
     */
    function clearColor(sheetObj, Row) {
        with (sheetObj) {
            Redraw = false;
            RowBackColor(Row) = 0;
            for(i=0;i<LastCol;i++) {
                if (!CellEditable(Row, i)) {
                    CellBackColor(Row, i) = UnEditableColor;
                }
            }
            Redraw = true;
        }
    }


    /**
     * 그 외 common_0430.js에 정의된 함수 (반드시 참조할것)
     *
     * function deleteCondition(rmSubstr)
     * function deleteRow(sheetObj, Row)
     * function row_Editable4Sheet2()
     * function sheet2_OnChange(sheetObj, Row, Col, Value)
     * function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH)
     */


/* 개발자 작업 끝 */
