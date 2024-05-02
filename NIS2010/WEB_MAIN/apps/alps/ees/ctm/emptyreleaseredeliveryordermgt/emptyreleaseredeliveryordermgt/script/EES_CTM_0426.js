/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0426.js
*@FileTitle : Release/Re-delivery Order
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.27
*@LastModifier : 김상수
*@LastVersion : 1.0
*
* 2009.07.27 김상수
* 1.0 Creation
*
* 2010.08.27 김상수
*     [CHM-201005606-01] CTM의 Release/Redelivery Order 화면 변경
*         : [EES_CTM_0426] ReDerivery 조회시 sheet내에 lstm_cd 컬럼추가  by 김상수
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
     * @class EES_CTM_0426 : EES_CTM_0426 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0426() { 
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
		this.initCombo = initCombo;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var sheet2_errMsg = "";


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var sheetObj = sheetObjects[0];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Calendar":
                    var cal = new ComCalendarFromTo();
                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                    break;

                case "btn_retrieve":
                    if (!checkFormField()) return;
                    doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                    break;

                case "btn_new":
                    ComResetAll();
                    if (comboObjects[0].GetCount() > 0) {
                        comboObjects[0].Index = 0;
                    }
                    document.getElementById("p_yard2").RemoveAll();
                    // button Disable
                    ComBtnDisable("btn_settled");
                    break;

                case "btn_downExcel":
                    sheetObj.SpeedDown2Excel(-1);
                    break;

                case "btn_settled":
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    doActionIBSheet(sheetObj, frmObj, IBSAVE);    // 저장
                    ComOpenWait(false);
                    sheetObj.WaitImageVisible = true;
                    break;

                case "btn_preview":
                    with (sheetObj) {
                        if (CheckedRows("Sel") < 1) {
                            ComShowCodeMessage("CTM30001");
                            return;
                        } else {
                            var arr = FindCheckedRow("Sel").split("|");
                            for (var i=0; i<arr.length-1; i++) {
                                // empty_cy 체크
                                if (CellValue(arr[i], "empty_cy") == "") {
                                    ComShowCodeMessage("CTM30002");
                                    return;

                                // CheckedRows가 0보다 크면 동일하지 않은 empty_cy 체크
                                } else if (i > 0 && CellValue(arr[i], "empty_cy") != CellValue(arr[0], "empty_cy")) {
                                    ComShowCodeMessage("CTM30005");
                                    return;

                                // pd_date 체크
                                } else if (CellValue(arr[i], "pd_date") == "" || !ComIsDate(CellValue(arr[i], "pd_date"))) {
                                    ComShowCodeMessage("CTM30003");
                                    return;

                                // qty 체크
                                } else if (!ColHidden("qty") && (CellValue(arr[i], "qty") == "" || CellValue(arr[i], "qty") < 1 || CellValue(arr[i], "qty") > CellValue(arr[i], "o_qty"))) {
                                    ComShowCodeMessage("CTM30004");
                                    return;
                                }

                            }
                            ComOpenPopup("/hanjin/EES_CTM_0451.do", 775, 755, "", "0,1", true);
                        }
                        break;
                    }

            } // end switch

        } catch(e) {
            if ( e == "[object Error]") {
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

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(var i=0;i<comboObjects.length;i++) {
            initCombo(comboObjects[i], comboObjects[i].id);
        }

        // CTM-COMMON (& 예외처리)
        setEventProcess("yd_cd_disp");

        // OnKeyPress 이벤트 (공통function)
        axon_event.addListener("keypress", "obj_keypress", "yd_cd_disp");
        // OnKeyUp 이벤트 (자체function)
        axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");
        // OnChange 이벤트 (자체function)
        axon_event.addListener("change", "obj_onchange", "type", "issued");

        // button Disable
        ComBtnDisable("btn_settled");

        // 2010-08-27 Rqst by I.H.Jang
        sheetObjects[0].ColHidden("lstm_cd") = true;

        // 로그인한 사용자의 Office코드로 Country코드를 조회
        doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
        // 로그인한 사용자의 Office코드로 Multicombo용 TerritoryList 조회
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

            if (sheetNo == 1) {
                // 높이 설정
                style.height = 420;
            } else {
                // 높이 설정
                // style.height = 100;
            }

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

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(42, 12, 0, true);

            // 헤더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false, false);

            // Ctrl키를 눌러 다중행 선택가능
            MultiSelection = true;
            SelectionMode = smSelectionList;

            var HeadTitle  = "||No.|I.Office|BD|Mode|Type|POL|POD|Empty CY|S/P|P/D Date|Container No.|Q'ty|O.Q'ty|TP|Term|CB|Empty Dest|Fax No.|E-mail Address|Office|User ID" +
                             "|Issue Date|Fax/E-mail/EDI Result|Booking No.|B/L No.|VVD Code|W/O No.|Special Instruction|SHPR Name|CNEE Name|NTFY Name";
                // hidden columns
                HeadTitle += "|org_empty_cy|pd_date|tro_seq|bd|type_cd|so_ofc_cty_cd|so_seq|vndr_lgl_eng_nm";

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // 자동 트림하여 조회및 저장
            DataAutoTrim = true;

            // 데이터속성    [ROW, COL,  DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++,    dtHiddenStatus, 0,      daCenter,    false,    "ibflag");
            InitDataProperty(0, cnt++,    dtDummyCheck,   30,     daCenter,    false,    "Sel");
            InitDataProperty(0, cnt++,    dtSeq,          30,     daRight,     false,    "Seq");
            InitDataProperty(0, cnt++,    dtData,         60,     daCenter,    false,    "i_office",      false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         60,     daCenter,    false,    "bd_disp",       false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         40,     daCenter,    false,    "mode_cd",       false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         60,     daCenter,    false,    "type_disp",     false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         45,     daCenter,    false,    "pol",           false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         45,     daCenter,    false,    "pod",           false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         60,     daCenter,    false,    "empty_cy",      false,    "",    dfNone,        0,    true,     true,    7);
            InitDataProperty(0, cnt++,    dtData,         60,     daCenter,    false,    "s_p",           false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         70,     daCenter,    false,    "pd_date_disp",  false,    "",    dfUserFormat,  0,    true,     true,    10);
            InitDataProperty(0, cnt++,    dtData,         90,     daCenter,    false,    "cntr_no",       false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         40,     daCenter,    false,    "qty",           false,    "",    dfNullInteger, 0,    true,     true,    3);
            InitDataProperty(0, cnt++,    dtData,         40,     daCenter,    false,    "o_qty",         false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         30,     daCenter,    false,    "tp",            false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         50,     daCenter,    false,    "lstm_cd",       false,    "",    dfNone,        0,    false,    false);    // 2010-08-27 Rqst by I.H.Jang
            InitDataProperty(0, cnt++,    dtData,         30,     daCenter,    false,    "cb",            false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         80,     daCenter,    false,    "empty_dest",    false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         100,    daLeft,      false,    "fax_no",        false,    "",    dfNone,        0,    true,     true,    20);
            InitDataProperty(0, cnt++,    dtData,         150,    daLeft,      false,    "email",         false,    "",    dfNone,        0,    true,     true,    50);
            InitDataProperty(0, cnt++,    dtData,         60,     daCenter,    false,    "office",        false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         60,     daCenter,    false,    "user_id",       false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         95,     daCenter,    false,    "issue_dt",      false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         150,    daLeft,      false,    "fax_email_rst", false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "bkg_no",        false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         85,     daCenter,    false,    "bl_no",         false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         75,     daCenter,    false,    "vvd",           false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         75,     daCenter,    false,    "wo_no",         false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         120,    daLeft,      false,    "spcl_inst",     false,    "",    dfNone,        0,    true,     true,    490);
            InitDataProperty(0, cnt++,    dtData,         100,    daLeft,      false,    "shpr",          false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         100,    daLeft,      false,    "cnee",          false,    "",    dfNone,        0,    false,    false);
            InitDataProperty(0, cnt++,    dtData,         100,    daLeft,      false,    "ntfy",          false,    "",    dfNone,        0,    false,    false);

            InitDataProperty(0, cnt++,    dtHidden,       70,     daCenter,    false,    "org_empty_cy");
            InitDataProperty(0, cnt++,    dtHidden,       70,     daCenter,    false,    "pd_date");
            InitDataProperty(0, cnt++,    dtHidden,       50,     daCenter,    false,    "tro_seq");
            InitDataProperty(0, cnt++,    dtHidden,       30,     daCenter,    false,    "bd");
            InitDataProperty(0, cnt++,    dtHidden,       40,     daCenter,    false,    "type_cd");
            InitDataProperty(0, cnt++,    dtHidden,       50,     daCenter,    false,    "so_ofc_cty_cd");
            InitDataProperty(0, cnt++,    dtHidden,       50,     daCenter,    false,    "so_seq");
            InitDataProperty(0, cnt++,    dtHidden,       50,     daCenter,    false,    "vndr_lgl_eng_nm");
            InitDataProperty(0, cnt++,    dtHidden,       50,     daCenter,    false,    "ship_opr");

            InitDataValid(0, "empty_cy" , vtEngUpOther, "1234567890");
            InitUserFormat(0, "pd_date_disp", "####-##-##", "-");

            CountPosition = 0;
            SelectHighLight = false;
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
//                    var rtnValues = code_get("CNTR_TPSZ_CD", "'N' AND CNTR_TPSZ_CD  NOT IN ('Q2', 'Q4')", "DELT_FLG", "MDM_CNTR_TP_SZ");
                    // 2014.02.04 Release-Redelivery 화면의 Cntr TP_SZ 순서 변경 - CHM-201428668
                    var rtnValues = "D2^#^D4^#^D5^#^D7^#^R2^#^R5^#^R7^#^O2^#^O4^#^O5^#^F2^#^F4^#^F5^#^A2^#^A4^#^S2^#^S4^#^T2^#^T4^#^C2^#^C4^#^D3^#^D8^#^D9^#^DW^#^DX^#^P2^#^P4^#^Q5^#^R4^#^R8^#^R9^#^";
                    // cntr_tpsz_cd IBMulticombo생성 (CoCtm.js)
                    parseMultiCombo(comboObj, "^#^" + rtnValues, "ALL^#^" + rtnValues);
                    Text = "ALL";
                    break;
            }
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        var frmObj = document.form;
        switch (sAction) {
            case IBSEARCH:    //조회
                if (validateForm(sheetObj, frmObj, sAction)) {
                    sheetObj.WaitImageVisible = false;
                    ComOpenWait(true);
                    frmObj.office.value = comboObjects[0].GetIndexText(comboObjects[0].Index, 1);
                    frmObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch("EES_CTM_0426GS.do", FormQueryString(frmObj));
                }
                break;

            case IBSAVE:    //Settled
                if (validateForm(sheetObj, formObj, sAction)) {
                    if (ComShowCodeConfirm("CTM30006")) {
                        frmObj.f_cmd.value = MULTI;
                        sheetObj.DoSave("EES_CTM_0426GS.do", FormQueryString(frmObj), "Sel");
                    }
                }
                break;

            case SEARCH01:    // 사용자 ofcCd에 따른 Multicombo용 TerritoryList 조회
                var xml = sheetObj.GetSearchXml("EES_CTM_0426GS.do", "f_cmd=" + SEARCH01);
                ComXml2ComboItem(xml, comboObjects[0], "cntr_stk_terr_cd", "cntr_stk_terr_txt");
                if (comboObjects[0].GetCount() > 0) {
                    comboObjects[0].Index = 0;
                }
                break;

            case SEARCH02:    // function sheet1_OnChange에서 직접 호출함
                break;

            case MULTI02:    // EES_CTM_0451에서 호출, 현재페이지의 sheet[0]저장후 자동 재조회가 되어야 하므로 이곳에 위치함
            	sheet2_errMsg = "";    // RDPopup창에서 사용되는 전역변수 초기화
            	if(frmObj.issue_type.value == "D"){
					var sRowStr = sheetObj.FindCheckedRow("Sel");
					var arr = sRowStr.split("|");
	            	var xml = sheetObj.GetSearchXml("EES_CTM_0426GS.do", "f_cmd=" + MULTI03 + "&empty_cy=" + sheetObj.CellValue(arr[0], "empty_cy"));
	            	var ediYardSetup = ComGetEtcData(xml, "edi_yard_setup");
	            	var yardCd = ComGetEtcData(xml, "yard_cd");
	            	if(ediYardSetup == "Y"){
		            	frmObj.f_cmd.value = MULTI02;
		                sheetObj.DoSave("EES_CTM_0426GS.do", FormQueryString(frmObj), "Sel", false);
	            	}else{
	            		ComShowCodeMessage("CTM30013" , yardCd);
	            		sheet2_errMsg = "no EDI connection err"; 
	            	}
            	}else{
            		frmObj.f_cmd.value = MULTI02;
	                sheetObj.DoSave("EES_CTM_0426GS.do", FormQueryString(frmObj), "Sel", false);
            	}
                break;

            case COMMAND05:    // 로그인한 사용자의 Office코드로 국가코드를 조회
                frmObj.sender_usr_cnt.value = ComGetEtcData(sheetObj.GetSearchXml("CTMCommonGS.do?f_cmd=" + COMMAND05), "rtnValue");
                break;
        }
    }


    /**
     * HTML Object의 OnChange이벤트 처리
     */
    function obj_onchange(event) {
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        var frmObj = document.form;
        var sheetObj = sheetObjects[0];
        switch(event.srcElement.name) {
            // Type 선택에 따른 처리
            case "type":
                with (sheetObj) {
                    if (frmObj.type.value == "RDV") {    // Re-Delivery 선택시
                        CellText(0, "MTYDest") = "Empty Org";
                        ColHidden("qty") = true;
                        ColHidden("q_qty") = true;
                        // 2010-08-27 Rqst by I.H.Jang
                        ColHidden("lstm_cd") = false;
                    } else {                             // Release 선택시
                        CellText(0, "MTYDest") = "Empty Dest";
                        ColHidden("qty") = false;
                        ColHidden("q_qty") = false;
                        // 2010-08-27 Rqst by I.H.Jang
                        ColHidden("lstm_cd") = true;
                    }
                }
                break;

            // Issued 선택에 따른 처리
            case "issued":
                if (frmObj.issued.value == "N") {        // No 선택시
                    ComBtnDisable("btn_settled");
                } else {    // Yes 선택시
                    ComBtnEnable("btn_settled");
                }
                break;

        }
        onShowErrMsg = false;
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
                var pYard2 = document.getElementById("p_yard2");
                if (ydCdDisp.value.length > 1) {
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
                        pYard2.RemoveAll();
                    }
                } else {
                    frmObj.p_yard1.value = "";
                    pYard2.RemoveAll();
                }
                break;
        }
        onShowErrMsg = false;
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            with (sheetObj) {
                // 조회결과가 있으면
                if (RowCount > 0) {
                    Redraw = false;
                    for (var i=1; i<RowCount+1; i++) {
                        if (document.form.issued.value == "Y") {    // 이슈가 Y일때 : empty_cy, qty가 Readonly
                            CellEditable(i, "empty_cy") = false;
                            CellEditable(i, "qty") = false;
                        } else {                                    // 이슈가 N일때 : empty_cy가 type_cd가 M이 아닐때만 Readonly
                            if (CellValue(i, "type_cd") != "M") {
                                CellEditable(i, "empty_cy") = false;
                            }
                        }
                    }
                    Redraw = true;
                }
            }
        }
        sheetObjects[1].RemoveAll();
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
                    Redraw = false;
                    for (i=0; i<arr.length; i++) {
                        CellValue2(arr[i], "Sel") = "1";    // 선택된 행의 CheckBox 체크
                    }
                    Redraw = true;
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
            // 변경된 행의 CheckBox 체크
            if (ColSaveName(Col) != "Sel") {
                CellValue2(Row, "Sel") = "1";
            }
            switch(ColSaveName(Col)) {
                case "empty_cy":
                    var xml = sheetObj.GetSearchXml("EES_CTM_0426GS.do", "f_cmd=" + SEARCH02 + "&empty_cy=" + CellValue(Row, Col));
                    if (!ComGetEtcData(xml, "ydCd")) {
                        LoadSearchXml(xml);
                        CellValue2(Row, Col) = CellSearchValue(Row, Col);
                        SelectCell(Row, Col, true);
                    } else {
                        CellValue(Row, "fax_no") = ComGetEtcData(xml, "faxNo");
                        CellValue(Row, "email") = ComGetEtcData(xml, "ydEml");
                    }
                    break;

                case "pd_date_disp":
                    if (!ComIsDate(CellText(Row, Col))) {
                        ComShowCodeMessage("CTM00001");
                        SelectCell(Row, Col, true, CellValue(Row, "pd_date"));
                    } else {
                        CellValue2(Row, "pd_date") = CellText(Row, Col);
                    }
                    break;

                case "qty":
                    if (CellValue(Row, Col) == "" || CellValue(Row, Col) < 1 || CellValue(Row, Col) > CellValue(Row, "o_qty")) {
                        ComShowCodeMessage("CTM30004");
                        SelectCell(Row, Col, true, CellSearchValue(Row, Col));
                    }
                    break;
            }
        }
    }


    /**
     * 저장 함수를 이용하여 저장이 완료되면 다시 조회 <br>
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            ComShowCodeMessage("CTM10022", "Release/Redelivery Order");
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }


    /**
     * 저장 함수를 이용하여 저장이 완료되면 전역변수 setting (RDPopup에서 사용)<br>
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
        sheet2_errMsg = ErrMsg;
    }


    /**
     * territory[combo0] Object의 OnKeyDown이벤트 처리
     */
    function territory_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }


    /**
     * p_yard2[combo1] Object의 OnKeyDown이벤트 처리
     */
    function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj){
            /* Date format이 validation이 실패한 경우 경우 return false로 service 호출을 막음 */
//            if (sAction == IBSEARCH) {
//             if (cancelDate == false) return false;
//            }
        	var tmpobjValue = document.getElementById("p_date1").value;
        	var tmpobjValue2 = document.getElementById("p_date2").value
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
                    if (date1 == '' || date2 == '') return false;
                    if (date1 > date2) {
                    	ComShowCodeMessage("CTM10114");
                    	formObj.p_date1.focus();
                        return false;
                    }

            }
        }
        return true;
    }

    /**
     * tpszCombo의 MultiSelection OnCheckClick 이벤트 처리
     */
    function tpszCombo_OnCheckClick(comboObj, index, code) {
        // coCtm의 multiComboOnCheckClick 호출
        multiComboOnCheckClick(comboObj, index, document.form.cntr_tpsz_cd);
    }

/* 개발자 작업 끝 */
