/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0034.js
*@FileTitle : CSR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.17
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.17 김봉균
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
     * @class ESM_ACM_0034 : ESM_ACM_0034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0034() {
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
        var shtTotObj = sheetObjects[2];
        var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            if (srcName != "btn2_csr_no") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.csr_no);    // CoAcm.js에 정의
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

                case "btn_new":
                    ComResetAll();    //기본 object 초기화
                    memo_sheet1_OnLoadFinish(memoShtObj1)    // CoAcm.js에 정의
                    break;

                case "btn_detail":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                    break;

                case "btn_downexcel":
                    ComOpenWait(true);
                    shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "check");
                    ComOpenWait(false);
                    break;

                case "btn2_csr_no":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
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
                    style.height = 240;

                    // 전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 9, 1000);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle1 = "CHK|Office|CSR No.|Audit No.|CSR Detail|Acct. Code|USD AMT|Local AMT|Local AMT|R.VVD|Ex.Rate|Status|Creation Date|Approval Date|G/L Date|Payment Date|Creation User ID|Approval User ID";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 4, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성  [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,  	true,		"ibflag",	false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtRadioCheck,	50,		daCenter,   true,    	"check",    		false,		"",			dfNone,		0,			true,		false);
                    InitDataProperty(0, cnt++ , dtData,			70,		daCenter,   true,    	"agn_cd",     		false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			130,	daCenter,   true,    	"csr_no",   	 	false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			130,	daCenter,   true,    	"aud_no",   	 	false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			200,	daLeft,   	true,    	"inv_desc", 		false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,   true,    	"comm_stnd_cost_cd",false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRight,   	true,    	"if_amt",			false,		"",			dfFloat,	2,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRight,   	true,    	"pay_if_amt",		false,		"",			dfFloat,	2,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,  	true,    	"curr_cd",			false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,   true,    	"rev_vvd_cd",		false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,   true,    	"xch_rt",   		false,		"",			dfFloat,	2,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			65,		daLeft,   	false,    	"status",    		false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,   false,    	"cre_dt",    		false,		"",			dfDateYmd,	0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,   false,    	"apro_dt",     		false,		"",			dfDateYmd,	0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,   false,    	"gl_dt",     		false,		"",			dfDateYmd,	0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenter,   false,    	"pay_dt",     		false,		"",			dfDateYmd,	0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,   	false,    	"cre_usr_id",     	false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,   	false,    	"apro_usr_id",     	false,		"",			dfNone,		0,			false,		false);

                    WaitImageVisible = false;
                    HeadRowHeight = 24;

                    break;

                case "sheet2":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 85;

                    // 전체 너비 설정
                    SheetWidth = mainTable2.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 9, 1000);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle1 = "Local Total AMT|Local Total AMT|USD AMT";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성  [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,  	true,		"ibflag",	false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,		100,	daRight,   	true,    	"pay_if_amt",		false,		"",			dfFloat,	2,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,		60,		daCenter,   true,    	"curr_cd",			false,		"",			dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,		100,	daRight,   	true,    	"if_amt",   		false,		"",			dfFloat,	2,			false,		false);

                    WaitImageVisible = false;
                    CountPosition = 0;
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
        axon_event.addListener("blur", "frmObj_OnBlur", "rev_vvd_cd");
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
                var sXml = shtObj.GetSearchXml("ESM_ACM_0034GS.do", FormQueryString(frmObj));

                var arrXml = sXml.split("|$$|");

                //데이터를 IBSheet에 세팅한다.
                sheetObjects[1].LoadSearchXml(arrXml[0]);
                sheetObjects[2].LoadSearchXml(arrXml[1]);
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01:       // Detail
                if (!ComChkValid(frmObj)) return;
                var sRow = shtObj.SelectRow;
                if(sRow < 0) {
                    ComShowCodeMessage("COM12189");
                    return;
                }

                var agn_cd  = shtObj.CellText(sRow,"agn_cd");
                var csr_no  = shtObj.CellText(sRow,"csr_no");
                var rev_vvd_cd  = shtObj.CellText(sRow,"rev_vvd_cd");
                var comm_stnd_cost_cd  = shtObj.CellText(sRow,"comm_stnd_cost_cd");

                var param = "?agn_cd=" + agn_cd + "&csr_no=" + csr_no + "&rev_vvd_cd=" + rev_vvd_cd + "&comm_stnd_cost_cd=" + comm_stnd_cost_cd;

                ComOpenWindowCenter("ESM_ACM_0111.do" + param, "compop1", "800", "456", false);
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
    function sheet2_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount > 0) {
                ReDraw = false;
                document.form.usd_total.value = ComAddComma2(ComputeSum("|2|")+"", "#,###.00");
                ReDraw = true;
            } else {
                document.form.usd_total.value = "";
            }
        }
    }


    /**
     * Form Element의 OnChange 이벤트
     * Office선택 시 Sub Office가져오는 이벤트
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
            }
        }
    }


    /**
     * Form Element의 OnBlur 이벤트
     * R.VVD 유효성 체크
     */
    function frmObj_OnBlur() {
        var elementName = window.event.srcElement.getAttribute("name");
        with (document.form) {
            switch (elementName) {

            case "rev_vvd_cd":
                if( !/[A-Z]{4}[0-9]{4}[A-Z]{1,2}/.test(rev_vvd_cd.value) ) {
                    ComShowCodeMessage("COM132201", "R.VVD Code", "", "");
                }
                break;
            }
        }
    }


/* 개발자 작업 끝 */
