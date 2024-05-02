/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0111.js
*@FileTitle : CSR Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.16 김봉균
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @extends
     * @class ESM_ACM_0111 : ESM_ACM_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0111() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.doActionIBSheet    = doActionIBSheet;
    }

/* 개발자 작업 */

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var srcName = window.event.srcElement.getAttribute("name");

        switch (srcName) {

            case "btn_close":           // close
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
        
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var shtId = shtObj.id;
        with (shtObj) {
            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            document.form.pagerows.value = 500;

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, true, false, true, false, false);

            // Combo 항목이 없는 경우 조회한 글자 그대로 표시하기
            InitComboNoMatchText(true);

            ShowButtonImage = 3;
            WaitImageVisible = false;
            CountPosition = 0;

            switch (shtId) {
                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(16);

                    // 전체 너비 설정
                    SheetWidth = mainTable1.clientWidth;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(1, 1, 5, 500);

                    // 컬럼 헤더타이틀
                    var HeadTitle = "BKG No.|G.Rev.|N.Rev.|Vol.|O/B|I/B|T/S|CHF|Brokerage|Doc/Oth|DMDT|VSL Oper.|Cost M.U.";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 1, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    //InitDataProperty(0, cnt++,  dtHiddenStatus, 30,     daCenter,   false,      "ibflag");
    				InitDataProperty(0, cnt++ , dtData,	90,			daCenter,   true,    	"bkg_no",   false,		"",			dfNone,		0,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"g_rev",    false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"n_rev", 	false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"qty",		false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"out_bound",false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"in_bound",	false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"trans",	false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"chf",   	false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"brog",    	false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"doc_oth",  false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"dmdt",     false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"vsl_opr",  false,		"",			dfFloat,	2,			false,		false);
    				InitDataProperty(0, cnt++ , dtData,	110,		daRight,    true,    	"cost_mu",  false,		"",			dfFloat,	2,			false,		false);
    				
    				break;
            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0111GS.do", FormQueryString(frmObj));
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
         doActionIBSheet(shtObj, document.form, IBSEARCH);
     }

/* 개발자 작업 끝 */
