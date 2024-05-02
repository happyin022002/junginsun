/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_9999.js
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
     * @class ESM_ACM_9999 : ESM_ACM_9999 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_9999() {
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

        var srcName = window.event.srcElement.getAttribute("name");

        if (srcName != "btn2_bkg_no") {
            ACMMemoSheet_Close(memoShtObj1, frmObj.bkg_no);    // CoAcm.js에 정의
        }

        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(shtObj, frmObj, IBSEARCH);
                break;

            case "btn_downexcel":
                ComOpenWait(true);
                shtObj.Down2Excel(-1, false, false, true, "", "", false, false, "", false, "chk");
                ComOpenWait(false);
                break;

            case "btn_calculate":
                doActionIBSheet(shtObj, frmObj, IBSAVE);
                break;

            case "btn2_bkg_no":
                ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                break;

            case "chk_all":
                if (frmObj.chk_all.checked) {
                    frmObj.chk_comm_cmpn.checked = true;
                    frmObj.chk_fac.checked = true;
                    frmObj.chk_cmpn.checked = true;
                } else {
                    frmObj.chk_comm_cmpn.checked = false;
                    frmObj.chk_fac.checked = false;
                    frmObj.chk_cmpn.checked = false;
                }
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
        with (shtObj) {
            switch (shtObj.id) {

                case "memo_sheet1":
                    ACMMemoSheet_InitSheet(shtObj);    // CoAcm.js에 정의
                    break;

                case "sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = 320;

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
                    var HeadTitle = "||Seq|BKG No.|B/L No.|BKG STS|POL ETD|Calc Date";


                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,    daCenter,    false,    "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,     50,    daCenter,    false,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      50,    daCenter,    false,    "seq");
                    InitDataProperty(0, cnt++, dtData,         150,   daCenter,    false,    "bkg_no",        false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         150,   daCenter,    false,    "bl_no",         false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         100,   daCenter,    false,    "bkg_sts_cd",    false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         200,   daCenter,    false,    "pol_etd_dt",    false,    "",    dfNone,     0,   false,    false);
                    InitDataProperty(0, cnt++, dtData,         200,   daCenter,    false,    "upd_dt",        false,    "",    dfNone,     0,   false,    false);

                    // Edit 가능한 셀과 불가능한 셀을 배경색으로 구분여부
                    EditableColorDiff = false;
                    WaitImageVisible = false;
                    break;

            }
        }
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case IBSEARCH:    // 조회
                if (frmObj.bkg_no.value == "") {
                    ComShowCodeMessage("COM130201", "[BKG No]");    // Please input {?msg1}.
                    shtObj.SelectCell(1, 1);
                    return;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_9999GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSAVE:    // Calculate
                if (!frmObj.chk_comm_cmpn.checked  && !frmObj.chk_fac.checked && !frmObj.chk_cmpn.checked) {
                    ComShowCodeMessage("COM12114", "Calculate Condition.");    // Please check {?msg1}
                    ComSetFocus(frmObj.chk_comm_cmpn);
                    return;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value = MULTI;
                shtObj.DoSave("ESM_ACM_9999GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
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


/* 개발자 작업 끝 */
