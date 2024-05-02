/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0118.jsp
*@FileTitle : Customized Report Form
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.09.17 김상수
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
     * @class ESM_ACM_0118 : ESM_ACM_0118 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0118() {
        this.processButtonClick = tprocessButtonClick;
        this.setshtObj     = setshtObj;
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


    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
         var shtObj = sheetObjects[0];
         var shtObj1 = sheetObjects[1];
         var frmObj = document.form;

//        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btns_add":
                    var sRowStr = shtObj.GetSelectionRows("/");   //"/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                    var arr = sRowStr.split("/");

                    for (var j=0; j<arr.length; j++) {
                        var findRow = shtObj1.FindText("ac_rpt_itm_cd", shtObj.CellValue(arr[j],"ac_rpt_itm_cd"), 0, -1);
                        if (findRow < 0) {
                            // findRow가 -1면 동일한 데이터가 없는 것
                            // 해당 데이터를 sheet2에 추가한다.
                            //--------------------------------------
                            addRow(arr[j]);
                            //--------------------------------------
                        }
                    }
                    break;

                case "btns_del":
                    var sRowStr = shtObj1.GetSelectionRows("/");  //"/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                    if (sRowStr.length > 0) {
                        var arr = sRowStr.split("/");
                        // Ctrl키 혹은 Shift키를 누르고 다중 선택을 했을 경우
                        // Row number가 작은것 부턱 Row를 삭제하면 원하는 결과가 나오지 않는다
                        // 그래서 Row number가 큰것 부터 삭제하기 위해 reverse()를 사용하였다.
                        //---------------------------------------------------------
                        arr.reverse();  //배열의 값을 역순으로 변경한다.
                        //---------------------------------------------------------

                        for (var k=0; k<arr.length; k++) {
                            shtObj1.RowDelete(arr[k], false);
                        }
                    }
                    break;

                case "radio_save_yn":
                    if (frmObj.radio_save_yn[0].checked) {
                        ComEnableObject(frmObj.slct_itm_fom_desc, false);
                        ComBtnEnable("btn_ok");
                        ComBtnDisable("btn_save");
                    } else {
                        ComEnableObject(frmObj.slct_itm_fom_desc, true);
                        ComBtnDisable("btn_ok");
                        ComBtnEnable("btn_save");
                    }
                    break;

                case "btn_new":
                    shtObj1.RemoveAll();
                    frmObj.reset();
                    frmObj.slct_itm_fom_seq.selectedIndex = 0;
                    break;

                case "btn_ok":
                    var reportItem = "";
                    if (shtObj1.RowCount <= 0) {
                        ComShowMessage(ComGetMsg("ACM00012", "apply")); // There is no contents to {?msg1}.
                        return false;
                    }
                    for (var i=1; i<=shtObj1.LastRow; i++ ) {
                        reportItem += (shtObj1.CellValue(i, "rpt_itm_col_nm") + "|");
                    }
                    // 모달인 경우 Opener를 구해온다.
                    if (!opener) opener = window.dialogArguments;
                    var opnrShtObj = opener.sheetObjects[1];
                    opnrShtObj.ReDraw = false;
                    opnrShtObj.RemoveEtcData();
                    opnrShtObj.RemoveAll();
                    for (var i=0; i<opnrShtObj.LastCol+1; i++) {
                        if (reportItem.indexOf(opnrShtObj.ColSaveName(i)) > -1) {
                            opnrShtObj.ColHidden(i) = false;
                        } else {
                            opnrShtObj.ColHidden(i) = true;
                        }
                    }
                    opener.form.slct_itm_fom_seq.value = "";
                    opener.form.report_item.value = "|" + reportItem;
                    opnrShtObj.ReDraw = true;
                    window.close();
                    break;

                case "btn_save":
                    doActionIBSheet(shtObj1, frmObj, IBSAVE);
                    break;

                case "btn_delete":
                    doActionIBSheet(shtObj1, frmObj, IBDELETE);
                    break;

                case "btn_close":
                    window.close();
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
        for (var i=0; i<sheetObjects.length; i++) {
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
     * param : shtObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, sheetNo) {

        with (shtObj) {
            var cnt = 0;
            // 높이 설정
            style.height = GetSheetHeight(11);

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
            InitRowInfo(1, 1, 13, 500);
            document.form.pagerows.value = 500;

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, false, true, true, false, false);

            // 컬럼 헤더타이틀
            var HeadTitle = "|ac_rpt_itm_cd|rpt_itm_col_nm|Column Item" ;

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, false);

            // Enter키를 눌렀을때 Tab키처럼 작동
            EditEnterBehavior = "tab";

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 40,    daCenter,    true,    "ibflag");    // [필수]
            InitDataProperty(0, cnt++, dtHidden,       80,    daCenter,    true,    "ac_rpt_itm_cd");
            InitDataProperty(0, cnt++, dtHidden,       80,    daCenter,    true,    "rpt_itm_col_nm");
            InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,    "rpt_itm_desc");

            SelectionMode = smSelectionList;
            CountPosition  = 0 ;
            WaitImageVisible = false;
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
        axon_event.addListener("change", "frmObj_OnChange", "slct_itm_fom_seq");
        // OnKeyup 이벤트
        axon_event.addListener("keyup", "frmObj_OnKeyup", "slct_itm_fom_desc");

        ComBtnDisable("btn_ok");
    }


    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(shtObj, frmObj, sAction) {
        switch(sAction) {

            case SEARCH01:
                // Customized RPT Form 목록 조회
                var xmlStr2 = shtObj.GetSearchXml("ESM_ACM_0037GS.do", "f_cmd=" + SEARCH01);
                ACMXml2SelectItem(xmlStr2, frmObj.slct_itm_fom_seq, "slct_itm_fom_desc", "slct_itm_fom_seq", true);
                break;

            case IBSEARCH:      //조회
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0118GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                if (shtObj.RowCount < 1) {
                    ComShowCodeMessage("ACM00012", "save");    // There is no contents to {?msg1}.
                    return false;
                }
                if (frmObj.slct_itm_fom_desc.value == "") {
                    ComShowCodeMessage("COM130201", "Customized RPT Form Name");    // Please input {?msg1}.
                    frmObj.slct_itm_fom_desc.focus();
                    return false;
                }
                if (ComShowCodeConfirm("COM130101", "[" + frmObj.slct_itm_fom_desc.value + "]")) {    // Do you want to save {?msg1}?
                    ComOpenWait(true);
                    frmObj.save_flag.value = "I";
                    frmObj.f_cmd.value = MULTI;
                    shtObj.DoAllSave("ESM_ACM_0118GS.do", FormQueryString(frmObj));
                    ComOpenWait(false);
                }
                break;

            case IBDELETE:        //삭제
                if (frmObj.slct_itm_fom_seq.value == "") {
                    ComShowCodeMessage("COM12113", "Customized RPT Form");    // Please select {?msg1}
                    frmObj.slct_itm_fom_seq.focus();
                    return false;
                }
                if (ComShowCodeConfirm("COM12165", "[" + frmObj.slct_itm_fom_seq[frmObj.slct_itm_fom_seq.selectedIndex].text + "]")) {    // Do you want to delete {?msg1}?
                    ComOpenWait(true);
                    frmObj.save_flag.value = "D";
                    frmObj.f_cmd.value = MULTI;
                    shtObj.DoAllSave("ESM_ACM_0118GS.do", FormQueryString(frmObj));
                    ComOpenWait(false);
                }
                break;
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function sheet1_OnLoadFinish(shtObj) {
         // Customized RPT Form 목록 조회
         doActionIBSheet(shtObj, document.form, SEARCH01);
         // AGT_RPT_ITM_INFO_DTL에서 Default목록을 조회
         doActionIBSheet(shtObj, document.form, IBSEARCH);
     }


    /**
     *  sheet1에서 선택된 정보를 sheet2에 추가한다.
     */
    function sheet1_OnDblClick(shtObj , row, col , value) {
        var findRow = sheetObjects[1].FindText("ac_rpt_itm_cd", shtObj.CellValue(row,"ac_rpt_itm_cd"), 0, -1);
        if (findRow < 0) {
            // findRow가 -1면 동일한 데이터가 없는 것
            // 해당 데이터를 sheet2에 추가한다.
            //--------------------------------------
            addRow(row);
            //--------------------------------------
        }
    }


    /**
     * sheet2의 선택된 정보를 삭제한다.
     */
    function sheet2_OnDblClick(shtObj, row, col, value) {
        shtObj.RowDelete(row, false);
    }


    /**
     * sheet2에서 마우스가 이동했을 경우
     */
    function sheet2_OnMouseMove(shtObj, button, shift, x, y) {
        // 마우스 위치를 행과 컬럼 가져오기
        var row = shtObj.MouseRow;
        var col = shtObj.MouseCol;
    }


    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet2_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;

        var frmObj = document.form;
        if (frmObj.save_flag.value == "I") {
            ComShowCodeMessage("COM130102", "[" + frmObj.slct_itm_fom_desc.value + "]");    // {?msg1} was saved successfully.
        } else {
            shtObj.RemoveAll();
            ComShowCodeMessage("COM130303", "[" + frmObj.slct_itm_fom_seq[frmObj.slct_itm_fom_seq.selectedIndex].text + "]");    // {?msg1} was deleted successfully.
        }

        doActionIBSheet(shtObj, frmObj, SEARCH01);    // Customized RPT Form 목록 재조회
        if (!opener) opener = window.dialogArguments;    // MODAL창에서 부모창 호출
        opener.doActionIBSheet(opener.sheetObjects[1], opener.form, SEARCH01);    // Opener의 Customized RPT Form 목록 재조회
    }


    /**
     * sheet1의 내용을 sheet2에 추가
     */
    function addRow(selRowIdx) {
        var shtObj = sheetObjects[0];
        var shtObj1 = sheetObjects[1];
        var newRowIdx = shtObj1.DataInsert(-1);
        shtObj1.CellValue(newRowIdx, "ac_rpt_itm_cd") =  shtObj.CellValue(selRowIdx, "ac_rpt_itm_cd");
        shtObj1.CellValue(newRowIdx, "rpt_itm_col_nm") =  shtObj.CellValue(selRowIdx, "rpt_itm_col_nm");
        shtObj1.CellValue(newRowIdx, "rpt_itm_desc") =  shtObj.CellValue(selRowIdx, "rpt_itm_desc");
    }


    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj1 = sheetObjects[1];
        with (document.form) {
            switch (elementName) {

                case "slct_itm_fom_seq":
                    if (slct_itm_fom_seq.value == "") {
                        shtObj1.RemoveAll();
                        return;
                    }
                    slct_itm_fom_desc.value = slct_itm_fom_seq[slct_itm_fom_seq.selectedIndex].text;
                    // Customized RPT Form 콤보에 따른 목록을 조회
                    doActionIBSheet(shtObj1, document.form, IBSEARCH);
                    break;
            }
        }
    }


/* 개발자 작업 끝 */
