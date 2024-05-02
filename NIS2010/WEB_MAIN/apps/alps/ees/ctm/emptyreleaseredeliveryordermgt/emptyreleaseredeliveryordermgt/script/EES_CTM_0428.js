/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0428.js
*@FileTitle : Territories Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.04 김상수
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
     * @class ees_ctm_0428 : ees_ctm_0428 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0428() {
        this.processButtonClick    = tprocessButtonClick;
        this.setSheetObject        = setSheetObject;
        this.loadPage              = loadPage;
        this.initSheet             = initSheet;
        this.doActionIBSheet       = doActionIBSheet;
        this.validateForm          = validateForm;
    }

/* 개발자 작업	*/


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboCountryText = null;
var comboOfficeText = null;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

        var sheetObj = sheetObjects[0];
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_add":
                    sheetObj.SelectCell(sheetObj.DataInsert(), 2);    // row추가
                    break;

                case "btn_del":
                    // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                    var sRowStr = sheetObj.GetSelectionRows("/");
                    var arr = sRowStr.split("/");
                    for (i=0; i<arr.length; i++) {
                        sheetObj.RowStatus(arr[i]) = "D";    // 삭제를 위해 선택row의 Status를 D로 변경
                        sheetObj.RowHidden(arr[i]) = true;    // 선택row를 숨김
                    }
                    break;

                case "btn_save":
                    ComOpenWait(true);
                    doActionIBSheet(sheetObj, frmObj, IBSAVE);    // 저장
                    ComOpenWait(false);
                    break;

                case "btn_downexcel":
                    ComOpenWait(true);
                    sheetObj.SpeedDown2Excel(-1);
                    ComOpenWait(false);
                    break;

            } // end switch

        } catch(e) {
            if(e == "[object Error]") {
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

        // CTM-COMMON
        setEventProcess();

        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1: //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 462;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    // Ctrl키를 눌러 다중행 선택가능
                    SelectionMode = smSelectionList;

                    var HeadTitle = "|Seq.|Territory|Country|Country Name||Office|User|Creation Date|Update Date";

                    // 헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 자동 트림하여 조회및 저장
                    DataAutoTrim = true;

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,    cnt++,    dtHiddenStatus, 0,      daCenter,    false,    "ibflag");
                    InitDataProperty(0,    cnt++,    dtDataSeq,      50,     daCenter,    false,    "SEQ");
                        // 화면 및 저장용
                    InitDataProperty(0,    cnt++,    dtCombo,        125,    daLeft,      false,    "cntr_stk_terr_cd", true,     "",    dfNone,    0,    true,     true);
                        // 화면용 (Combo Box)
                    InitDataProperty(0,    cnt++,    dtComboEdit,    90,     daCenter,    false,    "cnt_nm",           true,     "",    dfNone,    0,    true,     true,    2);
                        // 화면용 (Data Field)
                    InitDataProperty(0,    cnt++,    dtData,         155,    daCenter,    false,    "cnt_nm0",          false,    "",    dfNone,    0,    false,    false);
                        // 실제 저장용 (Hidden)
                    InitDataProperty(0,    cnt++,    dtHidden,       50,     daCenter,    false,    "cnt_cd");
                        // 화면 및 저장용
                    InitDataProperty(0,    cnt++,    dtComboEdit,    70,     daCenter,    false,    "ofc_cd",           true,     "",    dfNone,    0,    true,     true,    6);
                    InitDataProperty(0,    cnt++,    dtData,         60,     daCenter,    false,    "usr_id",           false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0,    cnt++,    dtData,         150,    daCenter,    false,    "cre_dt",           false,    "",    dfNone,    0,    false,    false);
                    InitDataProperty(0,    cnt++,    dtData,         150,    daCenter,    false,    "upd_dt",           false,    "",    dfNone,    0,    false,    false);
                        // Where조건용 (Hidden)
                    InitDataProperty(0,    cnt++,    dtHidden,       50,     daCenter,    false,    "cntr_stk_terr_cd0");
                        // Where조건용 (Hidden)
                    InitDataProperty(0,    cnt++,    dtHidden,       50,     daCenter,    false,    "cnt_cd0");
                        // Where조건용 (Hidden)
                    InitDataProperty(0,    cnt++,    dtHidden,       50,     daCenter,    false,    "ofc_cd0");

                    InitDataCombo(0, "cntr_stk_terr_cd", " |Central Europe (CEU)|Eastern Africa (EAF)|Eastern Europe (EEU)|Mediterranean Europe (MED)|Northern Africa (NAF)|Northern Europe (NEU)|Scandinavian (SCA)|Southern Africa (SAF)|Southern Europe (SEU)|Western Africa (WAF)|Western Europe (WEU)", " |CEU|EAF|EEU|MED|NAF|NEU|SCA|SAF|SEU|WAF|WEU", "", "");
                    //InitDataCombo(0, "cnt_nm")    // function doActionIBSheet에서 지정
                    //InitDataCombo(0, "ofc_cd")    // function doActionIBSheet에서 지정

                    // Combo 항목이 없는 경우 조회한 글자 그대로 표시
                    InitComboNoMatchText(true);

                    // 영문대문자만 입력하기
                    InitDataValid(0, "cnt_nm", vtEngUpOnly);
                    InitDataValid(0, "ofc_cd", vtEngUpOnly);

                    SelectHighLight = false;
                    WaitImageVisible = false;

                }
                break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH:      //조회
                if(validateForm(sheetObj, frmObj, sAction)) {
                    ComOpenWait(true);
                    // rtnValue[0] : CimTerritory list
                    // rtnValue[1] : Combo1-MdmCountry
                    // rtnValue[2] : Combo2-MdmOrganization
                    var rtnValue = sheetObj.GetSearchXml("EES_CTM_0428GS.do", "f_cmd=" + SEARCH).split("|$$|");
                    // Country Combo 생성
                    var countryXml = ComXml2ComboString(rtnValue[1], "cnt_cd", "cnt_nm");
                    comboCountryText = countryXml[0];    // 사용자 입력값을 비교하기 위하여 전역변수에 담기
                    sheetObj.InitDataCombo(0, "cnt_nm", " |" + countryXml[0], " |" + countryXml[1], "", "");    // IBSheet내 Combo 초기화
                    // Office Combo 생성
                    var officeXml = ComXml2ComboString(rtnValue[2], "ofc_cd", "ofc_nm");
                    comboOfficeText = officeXml[0];    // 사용자 입력값을 비교하기 위하여 전역변수에 담기
                    sheetObj.InitDataCombo(0, "ofc_cd", " |" + officeXml[1], " |" + officeXml[0], "", "");    // IBSheet내 Combo 초기화
                    // CimTerritory list
                    sheetObjects[0].LoadSearchXml(rtnValue[0]);
                  }
                break;

            case IBSAVE:        //저장
                if(validateForm(sheetObj, frmObj, sAction)) {
                    frmObj.f_cmd.value = MULTI;
                    sheetObj.DoSave("EES_CTM_0428GS.do", FormQueryString(frmObj));
                }
                break;
        }

    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        ComOpenWait(false);
    }


    /**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} SheetObj    IBSheet Object
     * @param {ibsheet} Row         sheetObj의 선택된 Row
     * @param {ibsheet} Col         sheetObj의 선택된 Col
     */
    function sheet1_OnChange(sheetObj, Row, Col) {
        with (sheetObj) {
            var colName = ColSaveName(Col);
            if (colName == "cnt_nm") {
                // Value입력시 Combo리스트와 비교
                if (comboCountryText.indexOf(CellText(Row, "cnt_nm")) == -1) {
                    CellText(Row, "cnt_nm0") = "";
                    CellText(Row, "cnt_nm") = "";
                    ComShowCodeMessage("CTM20096");
                    SelectCell(Row, "cnt_nm");
                    return false;
                } else {
                // Hidden 필드에 Value입력
                    CellValue(Row, "cnt_nm0") = CellValue(Row, "cnt_nm");
                    CellValue(Row, "cnt_cd") = CellText(Row, "cnt_nm");
                }
            }
            if (colName == "ofc_cd") {
                // Value입력시 Combo리스트와 비교
                if (comboOfficeText.indexOf(CellText(Row, "ofc_cd")) == -1) {
                    CellText(Row, "ofc_cd") = "";
                    ComShowCodeMessage("CTM20097");
                    SelectCell(Row, "ofc_cd");
                    return false;
                }
            }
        }
    }


    /**
     * 저장 함수를 이용하여 저장이 완료되면 다시 조회 <br>
     * @param {ibsheet} Event       IBSheet 저장 후 발생하는 Event
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            ComShowCodeMessage("CTM10022", "Territories Management");
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction){
        with(sheetObj){
        }
        return true;
    }


/* 개발자 작업 끝 */
