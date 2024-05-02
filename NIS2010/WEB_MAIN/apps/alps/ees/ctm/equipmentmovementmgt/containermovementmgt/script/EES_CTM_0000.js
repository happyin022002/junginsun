/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0000.js
*@FileTitle : GATENEW Test
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.07.20 김상수
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
     * @class ees_ctm_0000 : ees_ctm_0000 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0000() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var frmObj = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btn_save":
                    sheetObjects[0].WaitImageVisible = false;
                    ComOpenWait(true);
                    sheetObjects[0].RemoveAll();
                    doActionIBSheet(sheetObjects[0], frmObj, IBSAVE);    // 저장
                    ComOpenWait(false);
                    sheetObjects[0].WaitImageVisible = true;
                   break;

                case "btn_new":
                    ComResetAll();
                    sheetObjects[0].RowStatus(sheetObjects[0].DataInsert()) = "R";
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
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
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
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        sheetObjects[0].RowStatus(sheetObjects[0].DataInsert()) = "R";
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 200;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(24, 0, 0, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    // Ctrl키를 눌러 다중행 선택가능
                    SelectionMode = smSelectionList;
                    var HeadTitle = "|SEQ|Msg Id|Muid Area|Cntr Number|Term Id|Event Yard|Event Date|Gate IO|Cont Stat|Sight Cd|Chss Code|Call Sign No|Lloyd No|Bl No|Pol|Pod|Dest Loc|Seal No|Dmg Flag|Pickup No|Mg Set|Bkg Number|Mvmt Status";
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";
                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;
                    // 데이터속성 [ROW, COL,    DATATYPE,    WIDTH,    DATAALIGN,    COLMERGE,    SAVENAME,    KEYFIELD,    CALCULOGIC,    DATAFORMAT,    POINTCOUNT,    UPDATEEDIT,    INSERTEDIT,    EDITLEN,    FULLINPUT,    SORTENABLE,    TOOLTIP,    ALLCHECK,    SAVESTATUS,    FORMATFIX]
                    InitDataProperty(0, cnt++,    dtHiddenStatus, 0,      daCenter,    false,    "ibflag");
                    InitDataProperty(0, cnt++,    dtDataSeq,      30,     daCenter,    false,    "Seq");
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "msg_id",         false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "muid_area",      false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "cntr_number",    false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "term_id",        false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "event_yard",     false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         120,    daCenter,    false,    "event_date",     false,    "",    dfUserFormat2, 0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "gate_io",        false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "cont_stat",      false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "sight_cd",       false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "chss_code",      false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "call_sign_no",   false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "lloyd_no",       false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "bl_no",          false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "pol",            false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "pod",            false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "dest_loc",       false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "seal_no",        false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "dmg_flag",       false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "pickup_no",      false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "mg_set",         false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "bkg_number0",    false,    "",    dfNone,        0,    true,    true,    20);
                    InitDataProperty(0, cnt++,    dtData,         100,    daCenter,    false,    "mvmt_status",    false,    "",    dfNone,        0,    true,    true,    20);

                    InitUserFormat2(0, "event_date", "####/##/## ##:##:##", "/|:" );

                    // 영대문자만 입력하기
                    InitDataValid(0, "msg_id", vtEngUpOther, "1234567890");
                    InitDataValid(0, "muid_area", vtEngUpOther, "1234567890");
                    InitDataValid(0, "cntr_number", vtEngUpOther, "1234567890");
                    InitDataValid(0, "term_id", vtEngUpOther, "1234567890");
                    InitDataValid(0, "event_yard", vtEngUpOther, "1234567890");
                    InitDataValid(0, "mvmt_status", vtEngUpOther, "1234567890");
                    InitDataValid(0, "gate_io", vtEngUpOther, "1234567890");
                    InitDataValid(0, "cont_stat", vtEngUpOther, "1234567890");
                    InitDataValid(0, "sight_cd", vtEngUpOther, "1234567890");
                    InitDataValid(0, "chss_code", vtEngUpOther, "1234567890");
                    InitDataValid(0, "call_sign_no", vtEngUpOther, "1234567890");
                    InitDataValid(0, "lloyd_no", vtEngUpOther, "1234567890");
                    InitDataValid(0, "bl_no", vtEngUpOther, "1234567890");
                    InitDataValid(0, "pol", vtEngUpOther, "1234567890");
                    InitDataValid(0, "pod", vtEngUpOther, "1234567890");
                    InitDataValid(0, "dest_loc", vtEngUpOther, "1234567890");
                    InitDataValid(0, "seal_no", vtEngUpOther, "1234567890");
                    InitDataValid(0, "dmg_flag", vtEngUpOther, "1234567890");
                    InitDataValid(0, "pickup_no", vtEngUpOther, "1234567890");
                    InitDataValid(0, "mg_set", vtEngUpOther, "1234567890");
                    InitDataValid(0, "bkg_number0", vtEngUpOther, "1234567890");
                    CountPosition = 0;
                }
                break;

            case 2:      //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=200]
                    InitRowInfo(1, 1, 13, 200);
                    //컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);
                    // Ctrl키를 눌러 다중행 선택가능
                    MultiSelection = true;
                    SelectionMode = smSelectionList;
                    var HeadTitle = "Seq.|Mvmt Status|Result Message|Result Message|Bkg Number|Edi Id|Msg Id|Muid Area|Muid Dt|Muid Seq|Vessel|Voyage|Dir";
                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";
                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;
                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,    dtSeq,     30,     daCenter,    false,    "Seq");
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "edi_mvmt_sts_cd",      false);
                    InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    false,    "mvmt_edi_rslt_cd",     false);
                    InitDataProperty(0, cnt++,    dtData,    250,    daLeft,      false,    "mvmt_edi_rmk",         false);
                    InitDataProperty(0, cnt++,    dtData,    100,    daCenter,    false,    "bkg_no",               false);
                    InitDataProperty(0, cnt++,    dtData,    60,     daCenter,    false,    "mvmt_edi_tp_cd",       true);
                    InitDataProperty(0, cnt++,    dtData,    60,     daCenter,    false,    "mvmt_edi_msg_tp_id",   true);
                    InitDataProperty(0, cnt++,    dtData,    80,     daCenter,    false,    "mvmt_edi_msg_area_cd", true);
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "mvmt_edi_msg_yrmondy", true);
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "mvmt_edi_msg_seq",     true);
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "crnt_vsl_cd",          false);
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "crnt_skd_voy_no",      false);
                    InitDataProperty(0, cnt++,    dtData,    70,     daCenter,    false,    "crnt_skd_dir_cd",      false);



                    CountPosition = 0;

                }
                break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSAVE:    //저장
                if (validateForm(sheetObj,frmObj,sAction)) {
                    if (frmObj.input_radio[0].checked && !sheetObj.IsDataModified) {
                        alert("Sheet에 저장할 DATA가 없습니다.");
                        return;
                    } else if (frmObj.input_radio[1].checked && frmObj.mq_text.value.trim() == "") {
                        alert("MQ_Text에 저장할 DATA가 없습니다.");
                        return;
                    }
                    sheetObjects[1].RemoveAll();
                    frmObj.f_cmd.value = MULTI;
                    var saveXml = sheetObjects[0].GetSaveXml("EES_CTM_0000GS.do", sheetObjects[0].GetSaveString() + "&" + FormQueryString(frmObj));
                    saveXml = ComReplaceStr(saveXml, "^#^", "'");
                    sheetObjects[1].LoadSearchXml(saveXml);
                }
                break;
        }

    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,frmObj,sAction){
        with(frmObj){
        }
        return true;
    }


/* 개발자 작업 끝 */
