/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0030.js
*@FileTitle : FF Compensation CSR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.04 김영오
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
     * @class ESM_ACM_0030 : ESM_ACM_0030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0030() {
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
        var shtObj = sheetObjects[1];
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            if (srcName != "btn2_bl_no") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.bl_no);    // CoAcm.js에 정의
            }

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

                case "btn_approval":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheetObjects[3],frmObj,IBDOWNEXCEL);
                    break;

                case "btn_csr_print":
                    doActionIBSheet(sheetObjects[5],frmObj,SEARCH05);
                    break;

                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;

                case "btn2_check":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 1);    // CoAcm.js에 정의
                    break;

                case "btn2_uncheck":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 0);    // CoAcm.js에 정의
                    break;

                case "btn_forwarder":
                    var url = "COM_ENS_041.do";
                    var width = 775;
                    var height = 484;
                    var func = "setForwarder";
                    var display = "1,0,1";
                    //comPopup(url, width, height, func, display, bModal, b2ndSheet);
                    ComOpenPopup(url, width, height, func, display, true, false);
                    break;

                case "btn_popup":		//Edit Approval Staff
                    var v_ofc_cd = frmObj.ofc_cd.value;
                    var v_sub_sys_cd = "AGT";
                    var v_apro_step = frmObj.apro_step.value;
                    var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
                    ComOpenPopup('COM_ENS_0T1.do' + param, 835, 550, '', 'none', true, false);

                    break;

                case "btn_clear":
                    doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC02);
                    break;

                case "btn_print":
                    doActionIBSheet(sheetObjects[6],frmObj,IBSEARCH_ASYNC03);
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
                    ACMMemoSheet_InitSheet(shtObj);    // CoAcm.js에 정의
                    break;

                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 150;

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
                    InitHeadMode(true, false, true, true, false, false);

                    var HeadTitle = "||FWDR|Vendor|Forwarder|CNT|Amount|AP Office|CSR NO|I/F Date|I/F Remark|" +
                                    "Receiving Remark|Pay Amount|Pay Date|Check No.|Method|";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,  30,     daCenter,    false,    "ibflag",          false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++, dtCheckBox,      30,     daCenter,    false,    "chk",             false,    "",    dfNone,       0,    true,     true);
                    InitDataProperty(0, cnt++, dtData,          70,     daCenter,    false,    "ff_cnt_seq",      false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          50,     daCenter,    false,    "vndr_seq",        false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          200,    daLeft,      false,    "cust_lgl_eng_nm", false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++, dtAutoSum,       40,     daRight,     false,    "tot_cnt",         false,    "",    dfInteger,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtAutoSum,       90,     daRight,     false,    "tot_amt",         false,    "",    dfFloat,      2,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          80,     daCenter,    false,    "ap_ofc_cd",       false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          150,    daCenter,    false,    "csr_no",          false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          80,     daCenter,    false,    "if_dt",           false,    "",    dfDateYmd,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          80,     daCenter,    false,    "if_rsn",          false,    "",    dfNone,       0,    false,    false);

                    InitDataProperty(0, cnt++, dtData,          140,    daCenter,    false,    "rcv_rsn",         false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++, dtAutoSum,       80,     daRight,     false,    "pay_amt",         false,    "",    dfFloat,      2,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          80,     daCenter,    false,    "pay_dt",          false,    "",    dfDateYmd,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          100,    daRight,     false,    "ftu_use_ctnt1",   false,    "",    dfNone,       0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,          100,    daRight,     false,    "pay_mzd_lu_cd",   false,    "",    dfNone,       0,    false,    false);
					
					InitDataProperty(0, cnt++, dtHidden,        100,    daRight,     false,    "ff_cmpn_sts_cd",   false,    "",    dfNone,       0,    false,    false);
                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    WaitImageVisible = false;
                    HeadRowHeight = 24;
                    CountPosition = 0;

                    break;

                case "sheet2":
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
                    InitHeadMode(true, false, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    var HeadTitle = "F.F|Vendor|BKG No|B/L No|Ref. No.|I/F AMT|Type|Rate|BKG STS|Remark|";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,    	70,    daCenter,  false,    "ff_cnt_seq",   false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    	50,    daCenter,  false,    "vndr_seq",   	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    	100,   daCenter,  false,    "bkg_no",   	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    	100,   daCenter,  false,    "bl_no",  		false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData, 		70,    daRight,   false,    "ff_ref_no",  	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtAutoSum,   80,    daRight,   false,    "if_amt",   	false,    "",         dfFloat,    2,          false,      false);
                    InitDataProperty(0, cnt++, dtData,      50,    daCenter,  false,    "ff_type",   	false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,      50,    daRight,   false,    "ff_bkg_rt",   	false,    "",         dfFloat,    2,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    	80,    daCenter,  false,    "bkg_sts_cd",   false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,    	300,   daCenter,  false,    "ff_cmpn_rmk",  false,    "",         dfNone,     0,          false,      false);

                    InitDataProperty(0, cnt++, dtHidden,    50,    daCenter,  false,    "ff_seq",  		false,    "",         dfNone,     0,          false,      false);

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    WaitImageVisible = false;
                    HeadRowHeight = 24;
                    CountPosition = 0;

                    break;


                case "sheet3":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 150;

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
                    var HeadTitle = "FWDR|Vendor|Forwarder|CSR NO|CNT|B/L No|Amount|AP Office|I/F Date|I/F Remark|"
                    +"Receiving Remark|Pay Amount|Pay Date|Check No.|Method";


                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,         	70,    daCenter,  true,     "ff_cnt_seq",   	true,    "",         dfNone,     0,          true,      true);
                    InitDataProperty(0, cnt++, dtData,         	50,    daCenter,  true,     "vndr_seq",   		true,    "",         dfNone,     0,          true,      true);
                    InitDataProperty(0, cnt++, dtData,         	200,   daLeft,    true,     "cust_lgl_eng_nm",  true,    "",         dfNone,     0,          true,      true);
                    InitDataProperty(0, cnt++, dtData,      	150,   daCenter,  true,     "csr_no", 			false,    "",         dfNone,    0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,      	40,    daRight,   false,    "tot_cnt", 			false,    "",         dfInteger,  0,          false,      false);

                    InitDataProperty(0, cnt++, dtData,          80,    daCenter,  false,    "bl_no",  			false,    "",         dfNone,     0,          false,      false);

                    InitDataProperty(0, cnt++, dtData,     		90,    daRight,   false,    "tot_amt", 			false,    "",         dfFloat,    2,          false,       false);
                    InitDataProperty(0, cnt++, dtData,     		80,    daCenter,  false,    "ap_ofc_cd",    	false,    "",         dfNone,    0,          false,       false);
                    InitDataProperty(0, cnt++, dtData,       	80,    daCenter,  false,    "if_dt",			false,    "",         dfDateYmd,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,          80,    daCenter,  false,    "if_rsn",  			false,    "",         dfNone,     0,          false,      false);

                    InitDataProperty(0, cnt++, dtData,          140,   daCenter,  false,    "rcv_rsn",  		false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtData,          80,    daRight,   false,    "pay_amt",   		false,    "",         dfFloat,  2,          false,      false);
                    InitDataProperty(0, cnt++, dtData,          80,    daCenter,  false,    "pay_dt",  			false,    "",         dfDateYmd,     0,          false,       false);
                    InitDataProperty(0, cnt++, dtData,          100,   daRight,   false,    "ftu_use_ctnt1", 	false,    "",         dfNone,     0,          false,       false);
                    InitDataProperty(0, cnt++, dtData,          100,   daRight,   false,    "pay_mzd_lu_cd", 	false,    "",         dfNone,    0,          false,      false);

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    WaitImageVisible = false;
                    HeadRowHeight = 24;
                    CountPosition = 0;

                    break;

                //RD 프린트 전용 Hidden Sheet
                case "sheet4":    	//sheet4 init
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

                case "sheet5":      //sheet5 init
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

                case "sheet6":      //sheet6 init
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
                        InitColumnInfo(6, 0, 0, true);

                        //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                        InitHeadMode(true, true, false, true, false, false) ;

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        var HeadTitle = "SEQ|CSR No|Vendor|CUR|Amount|Desc";
                        InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "seq",    false,    "",         dfNone,     0,          false,      false);
                        InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "csr_no",  false,    "",        dfNone,     0,          false,      false);
                        InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "vendor", false,    "",         dfNone,     0,          false,      false);
                        InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "cur",    false,    "",         dfNone,     0,          false,      false);
                        InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "amount", false,    "",         dfNone,     0,          false,      false);
                        InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "vendor_nm",   false,    "",    dfNone,     0,          false,      false);
                        CountPosition = 0;
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
        axon_event.addListener("change", "frmObj_OnChange", "if_opt");
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
                var shtObj1 = sheetObjects[1];
                sheetObjects[2].removeAll();
                frmObj.f_cmd.value = SEARCH;
                shtObj1.DoSearch("ESM_ACM_0030GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case SEARCH02:       	// 조회(Detail)
                ComOpenWait(true);
                var shtObj2 = sheetObjects[2];
                frmObj.f_cmd.value = SEARCH02;
                shtObj2.DoSearch("ESM_ACM_0030GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01:       	// 조회(Master)
                if (!ComChkValid(frmObj)) return;
                if(!validateForm(shtObj,frmObj,sAction))	return;
                ComOpenWait(true);
                var shtObj1 = sheetObjects[1];
                sheetObjects[2].removeAll();
                frmObj.f_cmd.value = MODIFY;
                shtObj1.DoSave("ESM_ACM_0030GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:    	// 엑셀다운로드
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH03;
                shtObj.DoSearch("ESM_ACM_0030GS.do", FormQueryString(frmObj));
                shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "ibflag|chk");
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC03:  //Print
                if(!validateForm(shtObj,frmObj,sAction))	return false;				
				if (frmObj.if_opt.value != "IF") {
					alert("Can't interface. Please check I/F Option.");
					return;
				}
				
                frmObj.f_cmd.value = MULTI01;
                var sXml = shtObj.GetSearchXml("ESM_ACM_0030GS.do", FormQueryString(frmObj));
                shtObj.LoadSearchXml(sXml);

                //보고서출력
                var rdFromObj = new Array();
                var rdObj  	= new Array();
                var parmObj = new Array();

                rdFromObj[0] = frmObj;  //RD로 보내기 위해 배열로담는다
                rdObj[0] = shtObj; //sheet를 RD로 보내기 위해 배열로 담는다

                // RD 로 보내기 위한 설정
                parmObj[0] = "1";
                parmObj[1] = "";
                parmObj[2] = "N";
                parmObj[3] = RD_path + "apps/alps/esm/acm/acmapproval/ffcmpnapproval/report/ESM_ACM_0022.mrd"; //RD 화면
                parmObj[4] = rdObj;
                parmObj[5] = rdFromObj;

                rdObjModaless(RdReport, parmObj, 700, 700);
                break;

            case SEARCH05:    	// CSR Print
                if(!validateForm(shtObj,frmObj,sAction))	return false;
				if (frmObj.if_opt.value != "IF") {
					alert("Can't interface. Please check I/F Option.");
					return;
				}
                //체크된 첫번째행의 번호를 읽어와서 Hidden Input에 담는다.
                var sRow = sheetObjects[1].FindCheckedRow("chk");
                var arrRow = sRow.split("|");

                frmObj.csr_no.value = sheetObjects[1].CellValue(arrRow[0], "csr_no");
                //보고서출력을 위해 정보 조회
                frmObj.f_cmd.value = PRINT;
                var sXml = shtObj.GetSearchXml("ESM_ACM_0030GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");

                var shtObj4 = sheetObjects[4];
                var shtObj5 = sheetObjects[5];

                //ETC데이터를 IBSheet에 세팅한다.
                shtObj.RemoveEtcData();
                shtObj4.LoadSearchXml(arrXml[0]);
                shtObj5.LoadSearchXml(arrXml[1]);

                //보고서출력
                var rdFromObj = new Array();
                var rdObj  	= new Array();
                var parmObj = new Array();

                rdFromObj[0] = frmObj;  //RD로 보내기 위해 배열로담는다
                rdObj[0] = sheetObjects[4]; //sheet를 RD로 보내기 위해 배열로 담는다
                rdObj[1] = sheetObjects[5];

                // RD 로 보내기 위한 설정
                parmObj[0] = "1";
                parmObj[1] = "";
                parmObj[2] = "N";
                parmObj[3] = RD_path + "apps/alps/esm/acm/acmapproval/agncommapproval/report/ESM_ACM_0201A.mrd"; //RD 화면
                parmObj[4] = rdObj;
                parmObj[5] = rdFromObj;

                rdObjModaless(RdReport, parmObj, 700, 700);
                break;

            case IBSEARCH_ASYNC02: 	//Clear
                frmObj.apro_step.value = "";
                break;
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
                case IBSEARCH_ASYNC01:	//Approval

                    if(if_opt.value != "CS") {
                        //Interface Status is invalid. Please check Interface Status.
                        ComShowCodeMessage("ACM00003", "Interface Status", "Interface Status");
                        return false;
                    }

                    if(inv_dt.value == ""){
                        ComShowCodeMessage("COM12114", "Invoice Date");
                        return false;
                    }

                    if(apro_step.value == ""){
                        ComShowCodeMessage("COM12114", "Approval Step");
                        return false;
                    }

                    var checkCnt = shtObj.CheckedRows("chk");
                    if(checkCnt < 1){
                        //Please select **.
                        ComShowCodeMessage("COM12113", "row for interface");
                        return false;
                    }
                    break;

                case SEARCH05:	//Print

                    var checkCnt = sheetObjects[1].CheckedRows("chk");
                    if(checkCnt < 1 || checkCnt > 1){	//Grid 체크박스 1개만 선택
                        alert('If you want to print report, please select just one item.');
                        return false;
                    }
                    break;
            }
        }
        return true;
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
        frmObj.hid_ff_cnt_seq.value = shtObj.CellValue(row,"ff_cnt_seq");
        frmObj.vndr_seq.value = shtObj.CellValue(row,"vndr_seq");
        frmObj.ap_ofc_cd.value = shtObj.CellValue(row,"ap_ofc_cd");
        frmObj.csr_no.value = shtObj.CellValue(row,"csr_no");
        doActionIBSheet(shtObj, document.form, SEARCH02);
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
                    CellValue2(Row, Col) = aryPopupData[0][2];
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

                case "agn_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
                    break;

                case "ofc_cd":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value + "&value8=Sub Office");
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
                    break;

                case "vndr_seq":
                    // validation
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) SelectCell(Row, Col, true, "");
                    break;
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
            if (RowCount > 0) {
                ReDraw = false;
                CellAlign(LastRow, "ff_cnt_seq") = daRight;
                CellText(LastRow, "cust_lgl_eng_nm") = "";
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
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet2_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount > 0) {
                ReDraw = false;
                CellAlign(LastRow, "ff_cnt_seq") = daRight;
                ReDraw = true;
            }
        }
    }


    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj1 = sheetObjects[1];
        var shtObj2 = sheetObjects[2];
        with (document.form) {
            switch (elementName) {

                case "if_opt":
                    shtObj1.RemoveAll();
                    shtObj2.RemoveAll();
                    break;
            }
        }
    }


    /**
     * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
     */
    function setForwarder(rowArray, row, col) {
        var colArray = rowArray[0];
        document.form.ff_cnt_seq.value = colArray[3];
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
        document.form.inv_dt.value = ComGetNowInfo("ymd");
    }

/* 개발자 작업 끝 */
