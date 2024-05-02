/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0032.js
*@FileTitle : Batch Management
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.25
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.25 김봉균
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
     * @class ESM_ACM_0032 : ESM_ACM_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0032() {
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
    var currentRow = 0;

    var loginUsr = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj = sheetObjects[0];
        var shtObj2 = sheetObjects[1];
        var frmObj = document.form;
        var srcName = window.event.srcElement.getAttribute("name");

        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(shtObj, frmObj, IBSEARCH);
                break;

            case "btng_cancel_cal":
            	doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
            	break;

            case "btng_cancel_sim":
            	doActionIBSheet(shtObj2, frmObj, IBSEARCH_ASYNC01);
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
                    style.height = 170;

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
                    InitHeadMode(true, false, false, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "|CHK|Seq|User|Total BKG No.|Completed|Start Date|Start Date|Remark|||"

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDummyCheck,   35,     daCenter,    true,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      35,     daCenter,    true,    "seq");
                    InitDataProperty(0, cnt++, dtData,         120,    daCenter,    true,    "cre_usr_id",      false,     "",    dfNone,    	0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daRight,    	true,    "tot_bkg_cnt",     false,     "",    dfInteger,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,    daRight,    	true,    "com_cnt",       	false,     "",    dfInteger,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daCenter,    true,    "stat_dt",       	false,     "",    dfNone,    	0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    true,    "stat_tm",       	false,     "",    dfNone,    	0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,     	true,    "bat_desc",        false,     "",    dfNone,   	0);
                    InitDataProperty(0, cnt++, dtHidden,       10,     daCenter,    true,    "bat_flg",         false,     "",    dfNone,   	0);
                    InitDataProperty(0, cnt++, dtHidden,       10,     daCenter,    true,    "n_cnt",      		false,     "",    dfNone,   	0);
                    InitDataProperty(0, cnt++, dtHidden,       10,     daCenter,    true,    "bat_itm_nm",      false,     "",    dfNone,   	0);
                    WaitImageVisible = false;

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    break;

                case "sheet2":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 170;

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
                    InitHeadMode(true, false, false, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle  = "|CHK|Seq|Simulation No.|User|Total BKG No.|Completed|Start Date|Start Date|Remark|"

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDummyCheck,   35,     daCenter,    true,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      35,     daCenter,    true,    "seq");
                    InitDataProperty(0, cnt++, dtData,         120,    daCenter,    true,    "bat_itm_nm",     	false,     "",    dfNone,    	0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daCenter,    true,    "cre_usr_id",      false,     "",    dfNone,    	0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daRight,    	true,    "tot_bkg_cnt",     false,     "",    dfInteger,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,    daRight,    	true,    "com_cnt",       	false,     "",    dfInteger,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         120,    daCenter,    true,    "stat_dt",       	false,     "",    dfNone,    	0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         50,     daCenter,    true,    "stat_tm",       	false,     "",    dfNone,    	0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         150,    daLeft,     	true,    "bat_desc",        false,     "",    dfNone,   	0);
                    InitDataProperty(0, cnt++, dtHidden,       10,     daCenter,    true,    "n_cnt",      		false,     "",    dfNone,   	0);

                    WaitImageVisible = false;

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;

                    break;
            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:    // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                var sXml = shtObj.GetSearchXml("ESM_ACM_0032GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");
                //데이터를 IBSheet에 세팅한다.
                sheetObjects[0].LoadSearchXml(arrXml[0]);
                sheetObjects[1].LoadSearchXml(arrXml[1]);
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01:    // Cancel Batch
            	if (!ComChkValid(frmObj)) return;
            	ComOpenWait(true);
            	frmObj.f_cmd.value = MULTI01;
            	shtObj.DoSave("ESM_ACM_0032GS.do", FormQueryString(frmObj), "chk", false);
                ComOpenWait(false);
            	break;

        }
    }


    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        loginUsr = document.form.usr_id.value;
        with (shtObj) {
			for(var i=1; i<=shtObj.LastRow; i++) {
				//Processing or 유저가 다른 로우에 대해서 Check box 비활성화
				if ( CellValue(i, "com_cnt") != "0" || CellValue(i, "cre_usr_id") != loginUsr ) {
					CellEditable(i, "chk") = false;
					CellBackColor(i, "chk") = RgbColor (239,240,243);
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
    		for(var i=1; i<=shtObj.LastRow; i++) {
    			//Processing or 유저가 다른 로우에 대해서 Check box 비활성화
    			if ( CellValue(i, "com_cnt") != "0" || CellValue(i, "cre_usr_id") != loginUsr ) {
    				CellEditable(i, "chk") = false;
    				CellBackColor(i, "chk") = RgbColor (239,240,243);
    			}
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
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }


    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet2_OnSaveEnd(shtObj, ErrMsg) {
    	if (ErrMsg != "") return;
    	// 저장 후 재조회
    	doActionIBSheet(shtObj, document.form, IBSEARCH);
    }

/* 개발자 작업 끝 */
