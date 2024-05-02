/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : ESM_ACM_0009.js
 * @FileTitle : Agent Commission CSR Creation
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.04.05
 * @LastModifier : 김영오
 * @LastVersion : 1.0
 * 2012.04.05 김영오 1.0 Creation
 * 2014.06.27 박다은 [CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청
 * 2015.01.05 김상현 1.11 [CHM-201433439] 파일 첨부 기능 개발 요청
 */
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
     * @class ESM_ACM_0009 : ESM_ACM_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0009() {
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
    //var rtnApprovedYN = ""; //N:GW결재>최종결재:PDT, Y:기존결재>최종결재>본부장
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
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
//		case "btn_approval_request":
//			doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
//			break;
		case "btn_approval_request":
//			if (frmObj.ac_sts_cd.value == "AL") {
//				doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC05); // GW결재창 URL호출
//			} else {
				doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01); // Approved 결재로직
//			}
			break;
		case "btn_csr_create":
			// doActionIBSheet(shtObj, frmObj, SEARCH04);	// IBSEARCH_ASYNC01->IBSEARCH_ASYNC05
			doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
			break;
		case "btn_audit_reject":
			doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC02);
			break;
		case "btng_downexcel1":
			doActionIBSheet(sheetObjects[0], frmObj, IBDOWNEXCEL);
			break;
		case "btng_downexcel2":
			doActionIBSheet(sheetObjects[1], frmObj, IBDOWNEXCEL);
			break;
		case "btn2_check":
			ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 1); // CoAcm.js에 정의
			break;
		case "btn2_uncheck":
			ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 0); // CoAcm.js에 정의
			break;
		case "btn_popup": // Edit Approval Staff
			var v_ofc_cd = frmObj.ofc_cd.value;
			var v_sub_sys_cd = "AGT";
			var v_apro_step = frmObj.apro_step.value;
			var param = "?mode=save&ofc_cd=" + v_ofc_cd + "&sub_sys_cd=" + v_sub_sys_cd + "&apro_step=" + encodeURIComponent(v_apro_step) + "&target_obj_nm=apro_step&classId=COM_ENS_0T1";
			ComOpenPopup("COM_ENS_0T1.do" + param, 835, 550, "", "none", true, false);
			break;
		case "btn_clear":
			doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC03);
			break;
//		case "btn_clearALL":
//			doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC04);
//			break;
		case "btn_print":
			doActionIBSheet(shtObj, frmObj, RDPRINT);
			break;
		case "btn_agmt_files": // 2015.01.05 김상현 1.11 [CHM-201433439] 파일 첨부 기능 개발 요청
			doActionIBSheet(shtObj, frmObj, COMMAND01);
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
                    style.height = 120;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 14, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS||No.|Audit No.|Agent|Cur|Count|VVD Count|Net AMT|VAT|WHT|TTL AMT|CSR No.|Approval Date|I/F Date|" +
                                      "Interface Ramark|Receipt Ramark|Payment AMT|Payment Date|Method||approYN|commStndCostCd"

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
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "aud_no",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "agn_cd",          false,     "",    dfNone,    0,    false,     false);

                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "curr_cd",       	false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    true,    "cnt",       		false,     "",    dfInteger, 0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    true,    "vvd_cnt",       	false,     "",    dfInteger, 0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daRight,     true,    "net_amt",         false,     "",    dfFloat,   2);
                    InitDataProperty(0, cnt++, dtData,         50,     daRight,     true,    "vat",         	false,     "",    dfFloat,   2);
                    InitDataProperty(0, cnt++, dtData,         50,     daRight,     true,    "whld",    	false,     "",    dfFloat,   2);
                    InitDataProperty(0, cnt++, dtData,         90,     daRight,     true,    "ttl_amt",         false,     "",    dfFloat,   2);
                    InitDataProperty(0, cnt++, dtData,         130,    daCenter,    true,    "csr_no",        	false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "apro_dt",         false,     "",    dfDateYmd, 0,    false,     false);

                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,    false,   "if_dt",        	false,     "",    dfDateYmd, 0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    false,   "if_flg_msg",    	false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    false,   "rcv_err_flg_msg", false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daRight,     false,   "pay_amt",       	false,     "",    dfFloat,   0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daCenter,    false,   "pay_dt",       	false,     "",    dfDateYmd, 0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    false,   "pay_mzd_lu_cd",   false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       50,     daCenter,    true,    "vvd_cnt",      	false,     "",    dfNone,    0,    false,     false);

                    InitDataProperty(0, cnt++, dtHidden,       50,     daCenter,    true,    "appro_yn",      	false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       50,     daCenter,    true,    "comm_stnd_cost_cd",false,    "",    dfNone,    0,    false,     false);

                    WaitImageVisible = false;
                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    break;

                case "sheet2":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 120;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "STS|VVD|B/L No.|BKG No|Agent|Type|A/R OFC|A/P OFC|BKG STS|Calculated AMT|I/F AMT";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,      daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtData,         100,     daCenter,    true,    "vvd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,     daCenter,    true,    "bl_no",       false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,     daCenter,    true,    "bkg_no",      false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         70,      daCenter,    true,    "agn_cd",      false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,     daCenter,    true,    "ac_tp_cd",    false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,     daCenter,    true,    "ar_ofc_cd",   false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,     daCenter,    true,    "ap_ofc_cd",   false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,      daCenter,    true,    "bkg_sts_cd",  false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      100,     daRight,     true,    "pay_if_amt",  false,     "",    dfFloat,   2);
                    InitDataProperty(0, cnt++, dtAutoSum,      100,     daRight,     true,    "if_amt",      false,     "",    dfFloat,   2);

                    WaitImageVisible = false;
                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    break;

                case "sheet3":    	//sheet3 init
                    var cnt = 0;
                    //높이 설정
                    style.height = 120;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 1, 0, true);

                    //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var HeadTitle = "title|csr no|office|prpd by|pay to|csr type|desc|pay grp|evi tp|due date|asa no|inv dt|currcd|amt|apprd" ;
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_title",    false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_csr_no",   false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_office",   false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_prpd_by",  false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_pay_to",   false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_csr_type", false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_desc",     false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_pay_grp",  false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_evi_tp",   false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_due_dt",   false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_asa_no",   false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_inv_dt",   false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_curr_cd",  false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_apprd_by", false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_amt",      false,    "",         dfNone,     0,          false,      false);
                    break;

                case "sheet4":      //sheet4 init
                    var cnt = 0;
                    // 높이 설정
                    style.height = 120;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 1, 0, true);

                    //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var HeadTitle = "count|char of account|account name|gl date|city|inv no|desc|debit|credit" ;
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_seq",      false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_cht_acct", false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_acct_nm",  false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_gl_dt",    false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_city",     false,    "",         dfNone,     2,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_inv_no",   false,    "",         dfNone,     2,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_desc",     false,    "",         dfNone,     2,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_debit",    false,    "",         dfNone,     2,          false,      false);
                    InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_credit",   false,    "",         dfNone,     2,          false,      false);
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
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd", "agn_cd", "ac_sts_cd", "asa_no");

        with (document.form) {
            // date_div_disp에 초기값 setting
            date_div_disp.value = ac_sts_cd.options[ac_sts_cd.selectedIndex].text;
            // Invoice Date 날짜 설정
            inv_dt.value = ComGetNowInfo();
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:    // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
                var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;

            case IBSEARCH:    // 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0009GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case SEARCH02:    // 조회(Detail)
                ComOpenWait(true);
                var shtObj2 = sheetObjects[1];
                frmObj.f_cmd.value = SEARCH01;
                shtObj2.DoSearch("ESM_ACM_0009GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01: //Approval Request
            	//alert('doaction-IBSEARCH_ASYNC01 425 line');
                if (!ComChkValid(frmObj)) return;
                if(!validateForm(shtObj,frmObj,sAction))	return;
                ComOpenWait(true);
                
            	var audNosStr = setChkAudNosFun(shtObj); 
            	frmObj.aud_nos.value = audNosStr;
                
                frmObj.f_cmd.value = MULTI01;
                //alert(FormQueryString(frmObj));
                shtObj.DoSave("ESM_ACM_0009GS.do", FormQueryString(frmObj), "chk");
                sheetObjects[1].RemoveAll();
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC02: //Audit Reject
                if (!ComChkValid(frmObj)) return;
                if(!validateForm(shtObj,frmObj,sAction))	return;
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI02;
                shtObj.DoSave("ESM_ACM_0009GS.do", FormQueryString(frmObj), "chk");
                sheetObjects[1].RemoveAll();
                ComOpenWait(false);
                break;
                
            case IBSEARCH_ASYNC05:    // GW연동팝업
            	if (!ComChkValid(frmObj)) return;
                if(!validateForm(shtObj,frmObj,sAction))	return;

    	        var csrNoStr = "";
    	        var checkCnt = shtObj.CheckedRows("chk");
    	        
    	        if(checkCnt > 0){
    	        	var ts = shtObj.RowCount;
    		        //최초 체크한 csr_no를 구하기
    		        brkCsr:for(var i=1; i <= ts; i++){
    		        	var chk = shtObj.CellValue(i, "chk");
    		        	if(chk == 1){
    		        		csrNoStr = shtObj.CellValue(i, "csr_no");
    		        		break brkCsr;
    		        	}
    		        }
    	        }
                
                frmObj.csr_no.value = csrNoStr;
                frmObj.f_cmd.value  = MULTI03;
        		var sXml = shtObj.GetSearchXml("ESM_ACM_0009GS.do", FormQueryString(frmObj),"",true);
        		var gwUrl = ComGetEtcData( sXml , "GW_URL");
//        		alert(gwUrl);
//        		if (ComIsNull(gwUrl)) {
//        			ComShowCodeMessage("ACM00033");
//        			return;
//        		}
        		var winName = "GW";
//        		openWinCenter(gwUrl,winName,900,780);
        		ComOpenPopup(gwUrl, 900, 780, "", "1,0,1,1,1", true);
        		
        		doActionIBSheet(shtObj, frmObj, IBSEARCH);
        		break;

            case IBDOWNEXCEL:    //Down Excel
                shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "chk");
                break;

            case IBSEARCH_ASYNC03: //Clear
                frmObj.apro_step.value = "";
                break;

//            case IBSEARCH_ASYNC04: //Clear ALL > 처음상태로 돌린다 > GW & ALPS 결정위함 
//            	//ComResetAll();
//            	
//                with (document.form) {
//                    // date_div_disp에 초기값 setting
//                    date_div_disp.value = ac_sts_cd.options[0].text;	//ac_sts_cd.selectedIndex
//                }
//                
//                rtnApprovedYN = "";
//                frmObj.appro_yn.value = "";
//                document.getElementById("appro_gb").options[0].selected = true;
//                document.getElementById("appro_gb").disabled = false;
//                settingBtn("ALPS");	//GW BUTTON
//            	
//                break;

            case RDPRINT:	//Print
                if(!validateForm(shtObj,frmObj,sAction))	return false;

                //체크된 첫번째행의 번호를 읽어와서 Hidden Input에 담는다.
                var sRow = shtObj.FindCheckedRow("chk");
                var arrRow = sRow.split("|");
                var currCd = shtObj.CellValue(arrRow[0], "curr_cd");
                frmObj.h_csr_no.value = shtObj.CellValue(arrRow[0], "csr_no");
                //보고서출력을 위해 AP_INV_HDR, AP_INV_DTRB 정보 조회
                frmObj.f_cmd.value = PRINT;
                var sXml = shtObj.GetSearchXml("ESM_ACM_0009GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");

                var shtObj3 = sheetObjects[2];
                var shtObj4 = sheetObjects[3];

                //ETC데이터를 IBSheet에 세팅한다.
                shtObj.RemoveEtcData();
                shtObj3.LoadSearchXml(arrXml[0]);
                shtObj4.LoadSearchXml(arrXml[1]);

                //보고서출력
                var rdfrmObj = new Array();
                var rdObj  	= new Array();
                var parmObj = new Array();

                rdfrmObj[0] = frmObj;  //RD로 보내기 위해 배열로담는다
                rdObj[0] = sheetObjects[2]; //sheet를 RD로 보내기 위해 배열로 담는다
                rdObj[1] = sheetObjects[3];
                //RD_path  = "http://203.246.136.105:7001/hanjin/";
                //RD_path = "http://kov440h.hanjin.com:9300/hanjin/";

                // RD 로 보내기 위한 설정
                parmObj[0] = "1";
                parmObj[1] = "";
                parmObj[2] = "N";
                if(currCd == "JPY" || currCd == "KRW"){
                    parmObj[3] = RD_path + "apps/alps/esm/acm/acmapproval/agncommapproval/report/ESM_ACM_0201B.mrd"; //RD 화면
                }else{
                    parmObj[3] = RD_path + "apps/alps/esm/acm/acmapproval/agncommapproval/report/ESM_ACM_0201A.mrd"; //RD 화면
                }
                parmObj[4] = rdObj;
                parmObj[5] = rdfrmObj;

                rdObjModaless(RdReport, parmObj, 700, 700);
                break;

	      	/*case SEARCH04:      //N:GW결재>최종결재:PDT, Y:기존결재>최종결재>본부장
                if (!ComChkValid(frmObj)) return;
                if(!validateForm(shtObj,frmObj,sAction))	return;
				//if(shtObj.id == "sheet2") {
                	var audNosStr = setChkAudNosFun(shtObj); 
                	frmObj.aud_nos.value = audNosStr;
					frmObj.f_cmd.value = SEARCH04;
	        		var sXml = shtObj.GetSearchXml("ESM_ACM_0009GS.do", FormQueryString(frmObj), "chk");
		  		    rtnApprovedYN = ComGetEtcData(sXml,"approvedYN");
		  		    //@@ 자동계산 계정은 차후 처리한다 > CSR 생성하면서 AP_INV_DTRB 테이블의 DTRB_COA_ACCT_CD 컬럼의 값은 자동계정이 들어갈수 없는데 이것은 언제정해지는가? > 차후 이 체크로직넣자
		  		    if (ComIsNull(rtnApprovedYN)) {
	        			ComShowCodeMessage("ACM00033");
	        			return;
	        		}

		  		    if(rtnApprovedYN == "Y"){	//ALPS결재
		  		    	if(!ComShowCodeConfirm('ACM00034', 'data')) return false;	//The CSR is less than $ 100,000.\n Do you want to use the ALPS payment?
	                    //if(frmObj.apro_step.value == ""){ //Approval Step
	                    //    ComShowCodeMessage("ACM00021");
	                        //ComShowMessage("You are requested to designate the proper approval authority prior to Approval Request");
	                        //return false;
	                    //  }
		  		    	settingBtn("ALPS");	//ALPS BUTTON
		  		    }else if(rtnApprovedYN == "N"){	//GW결재
		  		    	settingBtn("GW");	//GW BUTTON

		  		    	doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
		  		    }else{
		  		    	settingBtn("E");	//ERROR
		  		    	//alert("error!!");
		  		    }

		  		     //
		  		     // GW Approval System 상태에서 10만불여부를 체크하자마자 수정이 가해지지 않도록 한다 
		  		     // 	-> 나중에 필요하면 넣자 > GW Approval System 을 선택한순간 이 토글은 화면이 이벤트든 Clear 버튼이든
		  		     //     화면이 재조회를 필요할만큼(데이타셋 리무브) 초기화되기 전까지는 그 선택박스 자체를 disable 
		  		     // 기존 chk 박스를 변경하려면 Clear버튼을 눌러서 초기화해야한다
		  		     
				    //for(var d=shtObj.HeaderRows; d<=shtObj.LastRow; d++) {
				    //	shtObj.CellEditable(d, "chk") = false;
				    //}

				//}
	    	   	break;*/
		case COMMAND01: // Agreement 관련 첨부 file 추가 Popup - 2015.01.05 김상현 1.11 [CHM-201433439] 파일 첨부 기능 개발 요청
			var checkdCount = shtObj.CheckedRows("chk");
			if (checkdCount == 1) {
				for (var i=1; i<=shtObj.LastRow; i++) {
					if (shtObj.CellValue(i, "chk") == "1") {
						var csrNo = shtObj.CellValue(i, "csr_no");
						if (csrNo != "") {
							var approYn = shtObj.CellValue(i, "appro_yn");
							var tpCd = "GW";
							if (approYn == "Y") {
								tpCd = "ALPS";
							}
							openPopupAgmtFiles(csrNo, "Requesting Approval", tpCd); // 공통 file 첨부 창 실행 - CoAcm.js
						}
					}
				}
			} else {
				ComShowMessage(ComGetMsg("COM12177"));
			}
			break;
		}
	}

    /**
     * 버튼셋팅
     */
    function settingBtn(tp){
    	if(tp == "GW"){
    	    document.getElementById("divStepNo").style.display   = "inline";
    	    document.getElementById("divStepYes").style.display  = "none";
    		document.getElementById("divApproBtn").style.display = "none";
    		document.getElementById("divCsrBtn").style.display 	 = "inline";
    		//Clear 또는 화면전환전까진 선택할 수 없음
        	document.getElementById("appro_gb").options[2].selected = true;
        	//document.getElementById("appro_gb").disabled = true;
    	}else if(tp == "GW_AL"){
    	    document.getElementById("divStepNo").style.display   = "inline";
    	    document.getElementById("divStepYes").style.display  = "none";
    		document.getElementById("divApproBtn").style.display = "inline";
    		document.getElementById("divCsrBtn").style.display 	 = "none";
    		//Clear 또는 화면전환전까진 선택할 수 없음
        	document.getElementById("appro_gb").options[2].selected = true;
        	//document.getElementById("appro_gb").disabled = true;
        	document.form.appro_yn.value = "N";
         	//자동조회
//        	var shtObj = sheetObjects[0];
//        	var frmObj = document.form;
//        	doActionIBSheet(shtObj, frmObj, IBSEARCH);
    	}else if(tp == "ALPS"){
            document.getElementById("divStepNo").style.display   = "none";
            document.getElementById("divStepYes").style.display  = "inline";
        	document.getElementById("divApproBtn").style.display = "inline";
        	document.getElementById("divCsrBtn").style.display 	 = "none";
    	}else if(tp == "E"){
            document.getElementById("divStepNo").style.display   = "inline";
            document.getElementById("divStepYes").style.display  = "none";
        	document.getElementById("divApproBtn").style.display = "none";
        	document.getElementById("divCsrBtn").style.display 	 = "none";
    	}
    }

    /**
     * Approval System 선택박스
     */
 	function approSrch(){
 		var frmObj = document.form;
 		
 		if(frmObj.appro_gb.options[1].selected){ //ALPS System
 			frmObj.appro_yn.value = "Y"; 
 			settingBtn("ALPS");
 		}else if(frmObj.appro_gb.options[2].selected){ //GW Approval System
 			frmObj.appro_yn.value = "N";
 			settingBtn("GW");
 		}else{ //ALL : document.form.appro_gb.options[0].selected
 			frmObj.appro_yn.value = "";
 			settingBtn("ALPS");
 		}
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
 	}

    /**
     * 체크한 audNo들 셋팅
     */
    function setChkAudNosFun(shtObj){
    	var frmObj = document.form;
    	frmObj.aud_nos.value = "";
    	var audNosStr = "";

    	var checkCnt = shtObj.CheckedRows("chk");
        if(checkCnt < 1){
            ComShowCodeMessage("COM12113", "row for CSR Create"); //approval request
            return false;
        }
        var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
        var arrFirst = 0;
        if (chkRowArr.length > 1) {
        	for (var i=0; i < chkRowArr.length-1; i++) {
        		var audNO = shtObj.CellValue(chkRowArr[i], "aud_no");
        		if(i > 0){
        			audNosStr += ",";
        		}else{
        			arrFirst = 1;
        		}
        		audNosStr += "'"+audNO+"'";
            }
        }
        return audNosStr;
        //alert(frmObj.aud_nos.value);
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
        frmObj.aud_no.value = shtObj.CellValue(row,"aud_no");
        frmObj.csr_no.value = shtObj.CellValue(row,"csr_no");
    	
    	if(col == 1){ //체크박스클릭
    		var ts = shtObj.RowCount;
	        //alert("frmObj.appro_yn.value"+frmObj.appro_yn.value);
	        //alert("col>"+col+",frmObj.appro_yn.value>"+frmObj.appro_yn.value);
    		var acStsNM = frmObj.date_div_disp.value;
	        if(acStsNM == "Audited" && !document.getElementById("appro_gb").options[2].selected){ //checkbox click && Commission Status is 'AS'  && Approval System is 'ALL'
	        	sel:for(var i=1; i <= ts; i++){
	            	if(i == row){
	                	var approYN = shtObj.CellValue(i, "appro_yn");
	                	//alert("chk>"+chk+", approYN>"+approYN+", i>>"+i+", row>>"+row);
	     	    		if(approYN == "N"){ //Manual Account YN 체크유무
	     	    			var msg = "This Audit is Manual Account for Change Approval\nPlease select the GW Approval System.";
	     	    			ComShowMessage(msg);
	     	    			break sel;
	     	    		}
	            	}
	            }
	        }
	        
	        /*if(acStsNM == "Approved" || acStsNM == "Disapproved"){ //체크박스를 하나만 선택하도록 한다
	        	for(var i=1; i<ts; i++){
	        		shtObj.CellEditable(i, "chk") = false;
	        	}
	        	
	        	for(var i=1; i<ts; i++){
	        		if(row == i){
	        			if(shtObj.CellValue(row, "chk") == 0){
	        				alert("0");
	        	        	for(var i=1; i<ts; i++){
	        	        		shtObj.CellEditable(i, "chk") = false;
	        	        	}
	        	        	shtObj.CellEditable(row, "chk") = true;	//del_chk 를 false
	        			}else{
	        				alert("1>>"+shtObj.CellValue(row, "chk"));
	        	        	for(var i=1; i<ts; i++){
	        	        		shtObj.CellEditable(i, "chk") = true;
	        	        	}
	        			}
	        		}
	        	}
	        }*/
    	}
    	
    	doActionIBSheet(shtObj, document.form, SEARCH02); //상세조회
		
    	
        /*var approYND = "D"; //1. Y:Manual Account 재조회, 2. N:조회없음 3. D:상세조회

        var ts = shtObj.RowCount;
        if(col == 1){ //체크박스 클릭한경우
            brkAppro:for(var i=1; i <= ts; i++){
            	alert("i>"+i+",row>"+row);
            	if(i == row){
                	var chk = shtObj.CellValue(i, "chk");
                	var approYN = shtObj.CellValue(i, "appro_yn");
                	//alert("chk>"+chk+", approYN>"+approYN+", i>>"+i+", row>>"+row);
     	    		if(approYN == "N"){ //Manual Account YN 체크유무
     	    			var msg = "This invoice, you must create a separate invoice.\nPlease check the manual account YN.";
     	    			if(confirm(msg)){
     	    				//체크박스체크후 Manual Account 재조회 실행
     	    				document.form.approYN.checked = true;
     	    				approYND = "Y";
     	    			}else{
     	    				//체크박스 디폴트 체크되지않고 해당행의 체크박스도 푼다
         	    			document.form.approYN.checked = false;
         	    			//alert(">>>>>>>>"+shtObj.CellValue(row, col));
         	    			approYND = "N";
         	    		}
     	    			break brkAppro;
     	    		}
            	}
            }
        }

        if(approYND == "Y"){
        	doActionIBSheet(shtObj, document.form, IBSEARCH);
        }else  if(approYND == "D"){ //상세조회
        	doActionIBSheet(shtObj, document.form, SEARCH02);
        }else{ //D
        	//alert('D');
        }*/
    }

    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
        // 조회조건의 Office Select Object 생성
        doActionIBSheet(shtObj, document.form, SEARCH01);
    }

    function sheet1_OnSearchEnd(shtObj) {
    	shtObj.AllowCheck = false;

    	var frmObj = document.form;
    	
    	var acStsNM = frmObj.date_div_disp.value;
    	if(acStsNM == "Audited" && frmObj.appro_gb.options[0].selected){
	    	//기본적으로 del_chk 는 선택할 수 없음
	        for(var i=shtObj.HeaderRows; i<=shtObj.LastRow; i++) {
	        	var approYN = shtObj.CellValue(i, "appro_yn");
	
	        	if(frmObj.appro_yn.value == "N"){
	           		shtObj.CellEditable(i, "chk") = true;
	        	}else{
	        		if(approYN == "N"){
	        			shtObj.CellEditable(i, "chk") = false;
	        		}else{
	        			shtObj.CellEditable(i, "chk") = true;
	        		}
	        	}
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
                CellText(LastRow, "vvd") = "TOTAL";
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
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj = sheetObjects[0];
        var shtObj1 = sheetObjects[1];
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
                        agn_cd.fireEvent("onchange");
                    }
                    shtObj.RemoveAll();
                    shtObj1.RemoveAll();
                    break;

                case "agn_cd":    //Sub Office변경 시 ASA No와 Vendor값 세팅
                    var xmlStr = shtObj.GetSearchXml("ESM_ACM_0009GS.do", "f_cmd=" + SEARCH16 + "&agn_cd=" + agn_cd.value).split("|$$|");
                    //ASA_NAME 콤보 셋팅
                    if (ACMXml2SelectItem(xmlStr, document.form.asa_no, "asa_name", "asa_no")) {
                        asa_no.fireEvent("onchange");
                    } else {
                        //오늘 날짜로 세팅
                        inv_dt.value = ComGetNowInfo();
                    }
                    //VNDR_CODE, VNDR_NAME 셋팅
                    vendor_name.value = "[" + ComGetEtcData(xmlStr, "vndr_code") +"] " + ComGetEtcData(xmlStr, "vndr_name");
                    shtObj.RemoveAll();
                    shtObj1.RemoveAll();
                    break;

				case "ac_sts_cd":
					date_div_disp.value = ac_sts_cd.options[ac_sts_cd.selectedIndex].text;
					document.getElementById("appro_gb").options[0].selected = true;

					shtObj.RemoveAll();
					shtObj1.RemoveAll();

					document.getElementById("appro_gb").disabled = false;
					document.getElementById("divAuditRejectBtn").style.display = "none"; // AS(Audited)의 상태캔슬버튼
					document.getElementById("divAGMTFilesBtn").style.display = "none"; // 추가 - 2015.01.05 김상현 1.11 [CHM-201433439] 파일 첨부 기능 개발 요청
					document.getElementById("divCSRPrintBtn").style.display = "inline"; // CSR Print 버튼
					document.form.appro_yn.value = "";

					if (ac_sts_cd.value == "AS") {
						settingBtn("ALPS");
						document.getElementById("divAuditRejectBtn").style.display = "inline";
						document.getElementById("divCSRPrintBtn").style.display = "none";
					} else if (ac_sts_cd.value == "AL") {
						settingBtn("GW_AL");
						document.getElementById("appro_gb").disabled = true;
						/* 
						 * 추가 - 2015.01.05 김상현 1.11 [CHM-201433439] 파일 첨부 기능 개발 요청
						 * ALPS 결재만 사용함. 임시로 삭제
						 */
						// document.getElementById("divAGMTFilesBtn").style.display = "inline";
					} else {
						settingBtn("E");
					}
					break;
                case "asa_no":
                    var idx = asa_no.selectedIndex;
                    if(idx >= 0) {
                        //ASA No의 TO_DATE로 세팅
                        var arrAsaNo = asa_no[idx].text.split('~');
//                    	var split = asaNo.split('~');
                        var temp = ComReplaceStr(arrAsaNo[1], ')', ' ');
                        temp = ComReplaceStr(temp, '/', '-');
                        temp = ComReplaceStr(temp, ' ', '');
                        inv_dt.value = temp;
                    } else {
                        //오늘 날짜로 세팅
                        inv_dt.value = ComGetNowInfo();
                    }
                    break;
            }
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {Object} shtObj
     * @param {Object} frmObj
     * @param {Object} sAction
     */
    function validateForm(shtObj,frmObj,sAction){
        with(frmObj){
            switch(sAction) {
//                case IBSEARCH_ASYNC01:	//Approval Request
//                    if(ac_sts_cd.value != "AS"){ //Commission Status != Audited
//                        ComShowCodeMessage("COM12114", "Commission Status");
//                        return false;
//                    }
//
//                    // offsetFlag = "Y"(ar_ofc_cd가 상계 정산 대리점(operational)) && asa_no가 없을 때
//                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH22 + "&value0=" + ofc_cd.value);
//                    if(ACMDecideErrXml(shtObj, xmlStr)) return;
//                    if(ComGetEtcData(xmlStr, "so_flag") == "Y" && asa_no.value == ""){ //ASA No.
//                        ComShowCodeMessage("COM12113", "ASA No");
//                        return false;
//                    }
//
//                    if(apro_step.value == ""){ //Approval Step
//                        ComShowCodeMessage("ACM00021");
//                        //ComShowMessage("You are requested to designate the proper approval authority prior to Approval Request");
//                        return false;
//                    }
//
//                    var checkCnt = shtObj.CheckedRows("chk");
//                    if(checkCnt < 1){
//                        ComShowCodeMessage("COM12113", "row for approval request");
//                        return false;
//                    }
//                    //[CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청
//
//                    var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
//                    var rqstCnt = 0;
//                    var sumCnt = 0;
//
//                    if (chkRowArr.length > 1) {
//                        	for (var i=0; i<chkRowArr.length-1; i++) {
//                        		rqstCnt = parseInt(shtObj.CellValue(chkRowArr[i], "cnt"), 10);
//                        		sumCnt = sumCnt + rqstCnt;
//                            }
//
//                        	if(sumCnt > 3000){
//                        		//msgs["ACM00032"] = "{?msg2} of {?msg1} should be equal to or less than {?msg3}.";
//                        		ComShowCodeMessage("ACM00032", "rows you selected","The booking count","3000");
//                        	return false;
//                        	}
//                        }
//
//                    break;
			case IBSEARCH_ASYNC01:	// CSR Create <-(변경) Approval Request
				if (ac_sts_cd.value != "AS") { //Commission Status != Audited
					ComShowCodeMessage("COM12114", "Commission Status");
					return false;
				}

				// offsetFlag = "Y"(ar_ofc_cd가 상계 정산 대리점(operational)) && asa_no가 없을 때
				var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH22 + "&value0=" + agn_cd.value);
				if (ACMDecideErrXml(shtObj, xmlStr)) return;
				if (ComGetEtcData(xmlStr, "so_flag") == "Y" && asa_no.value == "") { //ASA No.
					ComShowCodeMessage("COM12113", "ASA No");
					return false;
				}

				// 기존 ALPS Approval System 사용 => ALPS결재 즉, 결재라인 필수체크
				//if (!frmObj.appro_gb.options[2].selected) { // || rtnApprovedYN != "N"
					if (apro_step.value == "") { //Approval Step
						ComShowCodeMessage("ACM00021");
						settingBtn("ALPS");
						// ComShowMessage("You are requested to designate the proper approval authority prior to Approval Request");
						return false;
					}
				//}

				var checkCnt = shtObj.CheckedRows("chk");
				if (checkCnt < 1) {
					ComShowCodeMessage("COM12113", "row for approval request");
					return false;
				}
                // [CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청

				var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
				var rqstCnt = 0;
				var sumCnt = 0;

				if (chkRowArr.length > 1) {
					var preCommStndCostCd = "";
					for (var i=0; i<chkRowArr.length-1; i++) {
						rqstCnt = parseInt(shtObj.CellValue(chkRowArr[i], "cnt"), 10);
						sumCnt = sumCnt + rqstCnt;

						if (i == 0) {
							preCommStndCostCd = shtObj.CellValue(chkRowArr[i], "comm_stnd_cost_cd");
						} else {
							currentCommStndCostCd = shtObj.CellValue(chkRowArr[i], "comm_stnd_cost_cd");
							if ((preCommStndCostCd == "512694" || currentCommStndCostCd == "512694")
									&& preCommStndCostCd != currentCommStndCostCd) {
								ComShowCodeMessage("ACM00036");
								return false;
							}
						}
					}

					if (sumCnt > 3000) {
						// msgs["ACM00032"] = "{?msg2} of {?msg1} should be equal to or less than {?msg3}.";
						ComShowCodeMessage("ACM00032", "rows you selected","The booking count","3000");
						return false;
					}
				}
				break;
            case IBSEARCH_ASYNC05:	//Approval Request
                var checkCnt = shtObj.CheckedRows("chk");
                if(checkCnt < 1){
                    ComShowCodeMessage("COM12113", "row for approval request");
                    return false;
                }else if(checkCnt > 1){	//Grid 체크박스 1개만 선택
                    alert('Please select just one item.');
                    return false;
                }
                //[CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청

                var chkRowArr = shtObj.FindCheckedRow("chk").split("|");
                var rqstCnt = 0;
                var sumCnt = 0;

                if (chkRowArr.length > 1) {
                	for (var i=0; i<chkRowArr.length-1; i++) {
                		rqstCnt = parseInt(shtObj.CellValue(chkRowArr[i], "cnt"), 10);
                		sumCnt = sumCnt + rqstCnt;
                    }

                	if(sumCnt > 3000){
                		//msgs["ACM00032"] = "{?msg2} of {?msg1} should be equal to or less than {?msg3}.";
                		ComShowCodeMessage("ACM00032", "rows you selected","The booking count","3000");
                	return false;
                	}
                }

                break;

            case RDPRINT:	//Print
                if(ac_sts_cd.value != "IF"){		//Commission Status
                    //ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
                    //return false;
                }

                var checkCnt = shtObj.CheckedRows("chk");
                if(checkCnt < 1 || checkCnt > 1){	//Grid 체크박스 1개만 선택
                    alert('Please select just one item.');
                    return false;
                }
                break;
            }
        }
        return true;
    }


    /**
     * 화면 VAT 항목에 FOCUS가 왔을때 처리
     */
    function invTaxRt_onfocus(obj){
        obj.select();
    }


    /**
     * 화면 VAT 항목에 FOCUS가 나갈때 유효성검증 프로세스 처리
     */
    function invTaxRt_validate(obj){
        var frmObj = document.form;

        if(!ComIsNumber(obj,'.')){
            alert("The range of VAT(%) is between 0.00% and 99.99%.");
            obj.value = "0.00";
            frmObj.inv_tax_rt.focus();
            frmObj.inv_tax_rt.select();
            return false;
        }

        var vat = parseFloat(obj.value);
        if(vat < 0 || vat >= 100){
            alert("The range of VAT(%) is between 0.00% and 99.99%.");
            obj.value = "0.00";
            frmObj.inv_tax_rt.focus();
            frmObj.inv_tax_rt.select();
            return false
        }
    }

    /**
     * PDT 화면에서 호출하여 사용
     * Common Approval Inquiry화면에서 Preview화면 호출시 사용함.
     * ACM에서 사용하지 않음.
     * 2014.07.18 (Requested by 비용 전표 상신용 Approval 구축 프로젝트)
     */
    function doPaymentSlip() {

    	var frmObj = document.form;
	    frmObj.h_csr_no.value = parent.document.form.csr_no.value;
	    var currCd = parent.document.form.curr_cd.value;

	    //보고서출력을 위해 AP_INV_HDR, AP_INV_DTRB 정보 조회
	    frmObj.f_cmd.value = PRINT;
	    var sXml = sheetObjects[0].GetSearchXml("ESM_ACM_0009GS.do", FormQueryString(frmObj));
	    var arrXml = sXml.split("|$$|");

	    var shtObj3 = sheetObjects[2];
	    var shtObj4 = sheetObjects[3];

	    //ETC데이터를 IBSheet에 세팅한다.
	    shtObj3.LoadSearchXml(arrXml[0]);
	    shtObj4.LoadSearchXml(arrXml[1]);

	    //보고서출력
	    var rdfrmObj = new Array();
	    var rdObj  	= new Array();
	    var parmObj = new Array();

	    rdfrmObj[0] = frmObj;  //RD로 보내기 위해 배열로담는다
	    rdObj[0] = sheetObjects[2]; //sheet를 RD로 보내기 위해 배열로 담는다
	    rdObj[1] = sheetObjects[3];

	    // RD 로 보내기 위한 설정
	    parmObj[0] = "1";
	    parmObj[1] = "";
	    parmObj[2] = "N";
	    if(currCd == "JPY" || currCd == "KRW"){
	        parmObj[3] = RD_path + "apps/alps/esm/acm/acmapproval/agncommapproval/report/ESM_ACM_0201B.mrd"; //RD 화면
	    }else{
	        parmObj[3] = RD_path + "apps/alps/esm/acm/acmapproval/agncommapproval/report/ESM_ACM_0201A.mrd"; //RD 화면
	    }
	    parmObj[4] = rdObj;
	    parmObj[5] = rdfrmObj;

	    rdObjModaless(RdReport, parmObj, 700, 700);
    }
/* 개발자 작업 끝 */
