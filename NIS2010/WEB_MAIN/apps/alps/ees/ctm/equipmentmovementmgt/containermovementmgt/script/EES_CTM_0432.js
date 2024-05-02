/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0432.js
*@FileTitle : Detail Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.26 김상수
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
     * @class ees_ctm_0432 : ees_ctm_0432 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0432() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.doActionIBSheet = doActionIBSheet;
        this.validateForm = validateForm;
    }

/* 개발자 작업 */


// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        try {

            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btn_close":
                    document.form.unload_flag.value = "reset";
                    window.close();
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
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        with (sheetObjects[0]) {
            DataInsert();
            DataInsert();
            DataInsert();
            DataInsert();

            CellBackColor(1, 0) = RgbColor(232, 239, 249);
            CellValue(1, 0) = "OK";
            CellValue(1, 1) = ComAddComma(document.form.ok_count.value);

            CellBackColor(2, 0) = RgbColor(230, 180, 180);
            CellBackColor(2, 1) = RgbColor(250, 210, 210);
            CellFont("FontBold", 2, 1) = true;
//            CellFont("FontColor", 2, 1) = RgbColor(200, 100, 100);
            CellValue(2, 0) = "Error";
            CellValue(2, 1) = ComAddComma(document.form.error_count.value);

            CellBackColor(3, 0) = RgbColor(232, 239, 249);
            CellValue(3, 0) = "Ignored";
            CellValue(3, 1) = ComAddComma(document.form.ignored_count.value);

            CellBackColor(4, 0) = RgbColor(232, 239, 249);
            CellFont("FontBold", 4, 0, 4, 1) = true;
            CellValue(4, 0) = "Total";
            CellValue(4, 1) = ComAddComma(document.form.total_count.value);
        }
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 94;

                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(0, 1, 4);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(2, 0, 0, false);

                    var HeadTitle = "title";

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,    false,    "Title",      false,    "",    dfNone ,    0,    false,    false);
                    InitDataProperty(0, cnt++, dtData,    40,     daRight,     false,    "Content",    false,    "",    dfNone ,    0,    false,    false);

                    CountPosition = 0;

                    DataRowHeight = 23;

                }
                break;

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
        if (Row == 2 && sheetObj.CellValue(2, 1) > 0) {
            document.form.unload_flag.value = "errorView";
            window.close();
        }
    }


    /**
     * IBSeet위에서 마우스가 움직일 때 발생하는 Event<br>
     * @param {sheetObj} Integer : 해당 IBSheet셀
     * @param {Button} Long : 마우스버튼, 1:왼쪽, 2:오른쪽
     * @param {Shift} Integer : Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {X} Long : Long X 좌표
     * @param {Y} Long : Long Y 좌표
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        if (sheetObj.MouseRow == 2 && sheetObj.CellValue(2, 1) > 0) {
            sheetObj.MousePointer = "Hand";
        } else {
            sheetObj.MousePointer = "Default";
        }
    }


    /**
     * HTML Object의 OnUnLoad 이벤트 처리
     */
    function unloadPage(value) {
        // MODAL창에서 부모창 javascript호출
        var opener = window.dialogArguments;
        if (value == "errorView") {
            document.form.unload_flag.value = "";
            opener.popup0432Function("errorView");
        } else if (value == "reset") {
            document.form.unload_flag.value = "";
            opener.popup0432Function("reset");
        }
    }


/* 개발자 작업 끝 */
