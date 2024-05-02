/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0007.js
*@FileTitle : Boiler Plate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.16 이승준
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
     * @class Standard Note Creation : ESM_PRI_0007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0007() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

    // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    var trMode = "R";
    var prevDtIdx = -1;

    var errMsg = "";

    //현재 이벤트를 저장
    var eventStatus = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {


                case "btn_rowadd":
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                    break;

                case "btn_rowadd2":
                    doActionIBSheet(sheetObjects[2], formObject, IBINSERT);
                    break;

                case "btn_rowcopy":
                    doActionIBSheet(sheetObjects[1],formObject,IBCOPYROW);
                    break;


                case "btn_rowcopy2":
                    doActionIBSheet(sheetObjects[2],formObject,IBCOPYROW);
                    break;

                case "btn_rowdelete":
                    doActionIBSheet(sheetObject2, formObject, IBDELETE);
                    break;

                case "btn_rowdelete2":
                    doActionIBSheet(sheetObjects[2], formObject, IBDELETE);
                    break;

                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
                    break;

                case "btn_new":
                    removeAll(document.form);
                    break;

                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    break;

                case "btn_confirm":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
                    break;

                case "btn_confirmcancel":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
                    break;

                case "btn_delete":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
                    break;

                case "btn_copy":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
                    break;

                case "btns_calendar": //달력버튼
                    var cal = new ComCalendarFromTo();
                    cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheetObjects[3], formObject, IBDOWNEXCEL);
                    break;

            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);

        var formObj = document.form;
        formObj.blpl_ref_yr.focus();


        toggleButtons("INIT");

//      setConfirmButton();

    }


    /**
     * Onactivate event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function obj_activate() {
        ComClearSeparator (event.srcElement);
    }

    /**
     * OnDeactivate event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function obj_deactivate() {
        ComChkObjValid(event.srcElement);
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {

            case "sheet0":      //hidden
                with (sheetObj) {
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);

                }
                break;

            case "sheet1":      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 160;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel.|Del Check|Seq.|Title|blpl_hdr_seq|blpl_seq|dp_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter,  false,       "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck,       40,    daCenter,  false,       "chk");
                    InitDataProperty(0, cnt++,  dtDelCheck,         40,    daCenter,  false,       "del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,              50,    daCenter,  false,       "Seq");
                    InitDataProperty(0, cnt++ , dtData,             300,   daLeft,    false,       "blpl_tit_nm",    true,  "", dfNone, 0, true,  true);
                    InitDataProperty(0, cnt++,  dtHidden,           90,    daLeft,    false,       "blpl_hdr_seq",   false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,           90,    daLeft,    false,       "blpl_seq",       false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,           90,    daLeft,    false,       "dp_seq",         false, "", dfNone, 0, false, false);

                    ColHidden("del_chk") = true;
                    //AutoRowHeight = false;
                    WaitImageVisible = false;
                }
                break;

            case "sheet2":      // sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 220;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel.|Del Check|Seq.|Contents|blpl_hdr_seq|blpl_seq|blpl_ctnt_seq|dp_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter,  false,       "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck,       40,    daCenter,  false,       "chk");
                    InitDataProperty(0, cnt++,  dtDelCheck,         40,    daCenter,  false,       "del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,              50,    daCenter,  false,       "Seq");
                    InitDataProperty(0, cnt++ , dtData,             800,   daLeft,    false,       "blpl_ctnt",      true, "",  dfNone, 0, false, false, 3000);
                    InitDataProperty(0, cnt++,  dtHidden,           90,    daLeft,    false,       "blpl_hdr_seq",   false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,           90,    daLeft,    false,       "blpl_seq",       false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,           90,    daLeft,    false,       "blpl_ctnt_seq",  false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++,  dtHidden,           90,    daLeft,    false,       "dp_seq",         false, "", dfNone, 0, false, false);

                    ColHidden("del_chk") = true;
                    AutoRowHeight = false;
                    WaitImageVisible = false;
                }
                break;

            case "sheet3":      // sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle = "|Seq.|Title|Contents";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter,  false,       "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,              50,    daCenter,  false,       "Seq");
                    InitDataProperty(0, cnt++ , dtData,             300,   daLeft,    false,       "blpl_tit_nm",    true,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,             800,   daLeft,    false,       "blpl_ctnt",      true, "",  dfNone);

                    AutoRowHeight = false;
                    WaitImageVisible = false;
                }
                break;

        }
    }

    /**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row
     * @param {String} Col
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName = sheetObj.ColSaveName(Col);

        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, Col);
        }
    }

    /**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row
     * @param {String} Col
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
        var colName = sheetObj.ColSaveName(Col);

        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, Col);
        }
    }

    /**
     * saveEnd 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} ErrMsg
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet0_OnSaveEnd(sheetObj, ErrMsg)  {
        //if (ErrMsg != "") {

        errMsg = ErrMsg;

        //ComPriSaveCompleted();
        //doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
        //}
    }

    /**
     * saveEnd 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} ErrMsg
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
        //if (ErrMsg != "") {

        errMsg = ErrMsg;
        //ComPriSaveCompleted();
        //doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
        //}
    }

    /**
     * saveEnd 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} ErrMsg
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
        if (ErrMsg != "") {
            //ComPriSaveCompleted();
            errMsg = ErrMsg;
        }
    }

    /**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow
     * @param {int} OldCol
     * @param {int} NewRow
     * @param {int} NewCol
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        doRowChange(OldRow, NewRow, OldCol, NewCol);
    }

    var isFiredNested = false;
    var supressConfirm = false;

    /**
     * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
     * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
     *
     * <br><b>Example :</b>
     * <pre>
     *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow
     * @param {int} OldCol
     * @param {int} NewRow
     * @param {int} NewCol
     * @param {String} sAction
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj = document.form;
        var adjNewRow = NewRow;

        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetObjects[1].IsDataModified) {
                isFiredNested = true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;

                if (validateForm(sheetObjects[1],document.form,IBSAVE)) {
                    if (sAction != IBINSERT && sAction != IBCOPYROW) {
                        isFiredNested = true;
                        sheetObjects[1].SelectCell(NewRow, NewCol, false);
                        isFiredNested = false;
                    }
                } else {
                    isFiredNested = true;
                    sheetObjects[1].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                    return -1;
                }
            }

            if (sheetObjects[2].IsDataModified) {
                isFiredNested = true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;

                var rslt = false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    adjNewRow = Math.max(NewRow - sheetObjects[1].RowCount("D"), sheetObjects[1].HeaderRows);
                    var rslt = doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
                    supressConfirm = false;
                }
                if (rslt) {
                    if (sAction != IBINSERT && sAction != IBCOPYROW) {
                        isFiredNested = true;
                        sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
                        isFiredNested = false;
                    }
                } else {
                    isFiredNested = true;
                    sheetObjects[1].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                    return -1;
                }
            }

            if (sAction == IBINSERT) {
                isFiredNested = true;
                var idx = sheetObjects[1].DataInsert();
                isFiredNested = false;
                return idx;
            } else if (sAction == IBCOPYROW) {
                isFiredNested = true;
                var idx = sheetObjects[1].DataCopy();
                isFiredNested = false;
                return idx;
            } else {

                formObj.blpl_seq.value = sheetObjects[1].CellValue(NewRow, "blpl_seq");
                if(formObj.blpl_seq.value == "undefined" || ComIsEmpty(formObj.blpl_seq.value)) {
                    formObj.blpl_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"blpl_seq");
                }
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
            }

        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBCLEAR:
                removeAll();
                break;

            case IBCREATE: // year 선택시, Duration 조회
                /*formObj.f_cmd.value = SEARCH01;


                //var sXml = sheetObj.GetSearchXml("ESM_PRI_0007GS.do", FormQueryString(formObj));
                //ComPriXml2ComboItem(sXml, formObj.eff_dt, "eff_dt", "eff_dt|exp_dt");

                //년도별 듀레이션이 하나이므로 같이 조회
                var arrData = ComPriXml2Array(sXml, "blpl_hdr_seq|cfm_flg|eff_dt|exp_dt");
                if (arrData != null && arrData.length > 0) {
                    formObj.blpl_hdr_seq.value = arrData[0][0];
                    formObj.cfm_flg.value = arrData[0][1];
//alert("formObj.blpl_hdr_seq.value " + FormQueryString(formObj))
                    formObj.exp_dt.value = arrData[0][2];
                    formObj.exp_dt.value = arrData[0][3];
                    if(formObj.cfm_flg.value == "") {
                        formObj.cfm_flg.value = "N";
                    }

                }*/
                break;

            case IBSEARCH:      //조회

                try {
                    for (var i = 0; i < sheetObjects.length; i++) {
                        sheetObjects[i].WaitImageVisible = false;
                    }
                    ComOpenWait(true);

                    if ( sheetObj.id == "sheet0") {
                        if (validateForm(sheetObj,document.form,sAction)) {
                            removeSearchCondition(formObj);

                            formObj.f_cmd.value = SEARCH01;
                            var sXml = sheetObj.GetSearchXml("ESM_PRI_0007GS.do", FormQueryString(formObj));

                            var arrData = ComPriXml2Array(sXml, "blpl_hdr_seq|cfm_flg|eff_dt|exp_dt");
                            if (arrData != null && arrData.length > 0) {
                                formObj.blpl_hdr_seq.value = arrData[0][0];
                                formObj.cfm_flg.value = arrData[0][1];

                                formObj.eff_dt.value = arrData[0][2];
                                formObj.exp_dt.value = arrData[0][3];

                                formObj.eff_dt_hidden.value = arrData[0][2];
                                formObj.exp_dt_hidden.value = arrData[0][3];

                                setConfirmButton();
                            }
                        }
                    }
                    else if ( sheetObj.id == "sheet1") {
                        if (validateForm(sheetObj,document.form,sAction)) {

                            for (var i = 0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }
                            formObj.f_cmd.value = SEARCH02;

                            sheetObj.DoSearch("ESM_PRI_0007GS.do", FormQueryString(formObj));

                            formObj.eff_dt.value = formObj.eff_dt_hidden.value;
                            formObj.exp_dt.value = formObj.exp_dt_hidden.value;

                            setConfirmButton();
                        }

                    }
                    else if ( sheetObj.id == "sheet2") {

                        if (validateForm(sheetObj,document.form,sAction)) {

                            formObj.f_cmd.value = SEARCH03;

                            sheetObj.DoSearch("ESM_PRI_0007GS.do", FormQueryString(formObj));

                            setConfirmButton();
                        }

                    }

                    ComOpenWait(false);

                } catch (e) {
                    if (e == "[object Error]") {
                        ComShowMessage(OBJECT_ERROR);
                    } else {
                        ComShowMessage(e);
                    }
                } finally {
                    ComOpenWait(false);
                }

                break;

            case IBSAVE:        //저장
                //COPY 후 저장인 경우
                if(eventStatus == "IBCOPY") {

                    if (!validateForm(sheetObj,document.form,IBSEARCH_ASYNC04)) return;

                    if (ComShowCodeConfirm('PRI00012')) {
                        formObj.f_cmd.value = MULTI05;

                        var sParam = FormQueryString(formObj);
                        var sParamSheet1 = sheetObjects[1].GetSaveString();

                        if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
                            return;
                        }

                        sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");

                        var sParamSheet2 = sheetObjects[2].GetSaveString();
                        if (sheetObjects[2].IsDataModified && sParamSheet2 == "") {
                            return;
                        }

                        sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");

                        try {
                            ComOpenWait(true);

                            var sXml = sheetObj.GetSaveXml("ESM_PRI_0007GS.do", sParam);
                            //sheetObjects[0].LoadSaveXml(sXml);
                            sheetObjects[2].LoadSaveXml(sXml);     
                            if(errMsg != "") {
                            	sheetObjects[1].LoadSaveXml(sXml);                            	
                            }
                            ComOpenWait(false);

                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }

                        if(errMsg != "") {
                            errMsg = "";
                        }else {
                            ComPriSaveCompleted();
                            formObj.blpl_hdr_seq.value = "";
                            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
                            eventStatus = "";
                        }
                        
                        toggleButtons(eventStatus);
                    }
                } else {

                    if (!validateForm(sheetObj,document.form,sAction)) {
                        return false;
                    }

                    eventStatus = "IBSAVE";

                    formObj.f_cmd.value = MULTI01;

                    var sParam = FormQueryString(formObj);
                    var sParamSheet1 = sheetObjects[1].GetSaveString();

                    if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
                        return;
                    }

                    //DP_SEQ SETTING
                    setDpSeq(sheetObjects[1]);
                    setDpSeq(sheetObjects[2]);

                    sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");

                    var sParamSheet2 = sheetObjects[2].GetSaveString();
                    if (sheetObjects[2].IsDataModified && sParamSheet2 == "") {
                        return;
                    }

                    sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");


                    if (!supressConfirm && !ComPriConfirmSave()) {
                        return false;
                    }

                    try {
                        ComOpenWait(true);

                        var sXml = sheetObj.GetSaveXml("ESM_PRI_0007GS.do", sParam);
                        //sheetObjects[0].LoadSaveXml(sXml);
                        sheetObjects[2].LoadSaveXml(sXml);
                        sheetObjects[1].LoadSaveXml(sXml);

                        ComOpenWait(false);

                    } catch (e) {
                        if (e == "[object Error]") {
                            ComShowMessage(OBJECT_ERROR);
                        } else {
                            ComShowMessage(e);
                        }
                    } finally {
                        ComOpenWait(false);
                    }


                    if (sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) {
                        return false;
                    } else {
                        if(errMsg != "") {
                            errMsg = "";
                        }
                        else {
                            ComPriSaveCompleted();
                            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//                          doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);

                            if (getValidRowCount(sheetObjects[1]) >= 1 && getValidRowCount(sheetObjects[2]) <= 0) {
                                doRowChange(sheetObjects[1].SelectRow, sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol);
//                              formObj.blpl_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "blpl_seq");
//                              doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
                            }
                        }
                        return true;
                    }

                    eventStatus = "";

                    setConfirmButton();
                }
                break;

            case IBSEARCH_ASYNC01:        //컨폼
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (ComPriConfirmConfirm()) {

                        try {
                            ComOpenWait(true);

                            formObj.f_cmd.value = MULTI02;

                            //formObj.cfm_flg.value = "Yes";

                            var sParam = FormQueryString(formObj);

                            var sXml = sheetObj.GetSaveXml("ESM_PRI_0007GS.do", sParam);

                            ComOpenWait(false);

                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }

                        if(errMsg != "") {
                            errMsg = "";
                        }
                        else ComPriConfirmCompleted();

                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

                        setConfirmButton();
                    }
                }

                break;

            case IBSEARCH_ASYNC02:        //컨폼 CANCEL
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (ComPriConfirmCancelConfirm()) {

                        try {
                            ComOpenWait(true);

                            formObj.f_cmd.value = MULTI03;

                            //formObj.cfm_flg.value = "No";

                            var sParam = FormQueryString(formObj);

                            var sXml = sheetObj.GetSaveXml("ESM_PRI_0007GS.do", sParam);

                            ComOpenWait(false);

                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }

                        if(errMsg != "") {
                            errMsg = "";
                        }
                        else ComPriCancelConfirmCompleted();
                        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

                        setConfirmButton();
                    }
                }

                break;


            case IBSEARCH_ASYNC03:        //ALL DELETE
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (ComPriConfirmDeleteAll()) {

                        try {
                            ComOpenWait(true);

                            formObj.f_cmd.value = MULTI04;

                            var sParam = FormQueryString(formObj);

                            var sXml = sheetObj.GetSaveXml("ESM_PRI_0007GS.do", sParam);

                            ComOpenWait(false);

                        } catch (e) {
                            if (e == "[object Error]") {
                                ComShowMessage(OBJECT_ERROR);
                            } else {
                                ComShowMessage(e);
                            }
                        } finally {
                            ComOpenWait(false);
                        }

                        if(errMsg != "") {
                            errMsg = "";
                        }
                        else {
                            ComPriDeleteCompleted();
                            removeAll(formObj);
                        }
                    }
                }

                break;

            case IBCOPYROW: // Row Copy

                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
//                      var idx = doRowChange(sheetObjects[1], sheetObjects[2], sheetObjects[1].SelectRow,
//                      sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, "3");
//                      var idx = doRowChange(sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
//                      if (idx < 0) {
//                      return false;
//                      }

                        var idx = doRowChange(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
                        if (idx < 0) {
                            return false;
                        }

                        sheetObj.CellValue(idx, "blpl_hdr_seq")   = formObj.blpl_hdr_seq.value;
                        sheetObj.CellValue(idx, "blpl_seq") = parseInt(ComPriGetMax(sheetObj, "blpl_seq")) + 1;
                        sheetObjects[2].RemoveAll();
                    }
                    else if (sheetObj.id == "sheet2") {
                        var idx = sheetObj.DataCopy();
                        sheetObj.CellValue(idx, "blpl_hdr_seq")   = formObj.blpl_hdr_seq.value;
                        var blpl_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "blpl_seq");
                        sheetObj.CellValue(idx, "blpl_seq") = blpl_seq;
                        sheetObj.CellValue(idx, "blpl_ctnt_seq") = parseInt(ComPriGetMax(sheetObj, "blpl_ctnt_seq")) + 1;
                    }
                }

                break;

            case IBINSERT: // Row Add

                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {
//                      var idx = doRowChange(sheetObjects[1], sheetObjects[2], sheetObjects[1].SelectRow,
//                      sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, "2");
                        var idx = doRowChange(sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
                        if (idx < 0) {
                            return false;
                        }

//                      var idx = doRowChange(sheetObj, sheetObjects[2], -2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
//                      if (idx < 0) {
//                      return false;
//                      }


//                      var idx = doRowChange(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
//                      if (idx < 0) {
//                      return false;
//                      }

                        sheetObj.CellValue(idx, "blpl_hdr_seq")   = formObj.blpl_hdr_seq.value;
                        sheetObj.CellValue(idx, "blpl_seq") = parseInt(ComPriGetMax(sheetObj, "blpl_seq")) + 1;
                        sheetObjects[2].RemoveAll();

                        sheetObj.SelectCell(idx, "blpl_tit_nm");
                    }
                    else if (sheetObj.id == "sheet2") {
                        var idx = sheetObj.DataInsert();
                        sheetObj.CellValue(idx, "blpl_hdr_seq")   = formObj.blpl_hdr_seq.value;
                        sheetObj.CellValue(idx, "blpl_seq") = parseInt(ComPriGetMax(sheetObj, "blpl_seq")) + 1;
                        var blpl_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "blpl_seq");
                        sheetObj.CellValue(idx, "blpl_seq") = blpl_seq;
                        sheetObj.CellValue(idx, "blpl_ctnt_seq") = parseInt(ComPriGetMax(sheetObj, "blpl_ctnt_seq")) + 1;

                        sheetObj.SelectCell(idx, "blpl_ctnt");
                    }
                }

                break;

            case IBDELETE: // Delete

//              deleteRowCheck(sheetObj, "chk");
//              if (sheetObj.id == "sheet1") {
//              deleteRowCheck(sheetObjects[2], "chk");
//              }
//              break;


                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }

                if (sheetObj.CheckedRows("chk") <= 0) {
                    sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
                }

//              var delCnt = deleteRowCheck(sheetObj, "chk");
//              if (delCnt > 0 && sheetObj.id == "sheet1") {
//              for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
//              sheetObjects[2].CellValue(i, "chk") = "1";
//              }
//              deleteRowCheck(sheetObjects[2], "chk");
//              }

                if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
                    sheetObjects[2].RemoveAll();
                }

                var delCnt = deleteRowCheck(sheetObj, "chk");
                if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
                    sheetObjects[2].RemoveAll();
                }

                break;


            case IBSEARCH_ASYNC04:        //COPY
                if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC04)) {
                    removeCopy(document.form);
                    eventStatus = "IBCOPY";
                    toggleButtons(eventStatus);
                }
                break;

            case IBDOWNEXCEL:
                ComOpenWait(true);
                if (!validateForm(sheetObj, document.form, sAction)) {
                    return false;
                }

                formObj.f_cmd.value = SEARCH04;
                sheetObj.DoSearch("ESM_PRI_0007GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이승준
     * @version 2009.04.17
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {

            case IBCREATE: // service scope 선택시
                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                return true;

                break;

            case IBDOWNEXCEL: // Down Excel
            case IBSEARCH: // 조회

                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }

                if(!ComIsNumber(document.form.blpl_ref_yr,'0123456789')) {
                    ComShowCodeMessage('PRI00311');
                    document.form.blpl_ref_yr.value = "";
                    return false;
                }

                if(document.form.blpl_ref_yr.value.length < 4) {
                    ComPriInputValueFailed("input","year 4 digit",formObj.blpl_ref_yr);
                    return false;
                }

                return true;
                break;

            case IBSAVE: // 저장

                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }

                if(!ComIsNumber(document.form.blpl_ref_yr,'0123456789')) {
                    ComShowCodeMessage('PRI00311');
                    document.form.blpl_ref_yr.value = "";
                    return false;
                }

                if(document.form.blpl_ref_yr.value.length < 4) {
                    ComPriInputValueFailed("input","year 4 digit",formObj.blpl_ref_yr);
                    return false;
                }

                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }

                if (formObj.eff_dt.value > formObj.exp_dt.value) {
                    ComShowCodeMessage('PRI00305', '[Duration]');
                    return false;
                }

                var blpl_ref_yr = formObj.blpl_ref_yr.value;
                if (blpl_ref_yr != formObj.eff_dt.value.substr(0,4) && blpl_ref_yr != formObj.exp_dt.value.substr(0,4)) {
                    ComShowCodeMessage('PRI00324');
                    formObj.eff_dt.focus();
                    return false;
                }

                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                //변경사항 체크
                if ((formObj.eff_dt.value == formObj.eff_dt_hidden.value && formObj.exp_dt.value == formObj.exp_dt_hidden.value)
                        && !sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }

                if (sheetObjects[1].IsDataModified ) {
                    var rowM = sheetObjects[1].ColValueDup("blpl_hdr_seq|blpl_seq",false);
                    if (rowM >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet1", rowM);
                        return false;
                    }
                }

                if (sheetObjects[2].IsDataModified ) {
                    var rowD = sheetObjects[2].ColValueDup("blpl_hdr_seq|blpl_seq|blpl_ctnt_seq",false);
                    if (rowD >= 0) {
                        ComShowCodeMessage("PRI00303", "Sheet2", rowD);
                        return false;
                    }
                }
                //getValidRowCount(sheetObjects[1]) >= 1 && getValidRowCount(sheetObjects[2]) <= 0

                //sheet1에서 하나라도 저장했는지 체크
                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
                    ComPriInputValueFailed("input","Title","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }

                //sheet2에서 하나라도 저장했는지 체크 sheetObjects[1]
//              if (getValidRowCount(sheetObjects[1]) >= 1 && (getValidRowCount(sheetObjects[2]) <= 0 && sheetObjects[1].SelectRow <= 0)) {
////            chekRowStatus(sheetObjects[2])
//              ComShowCodeMessage("input", "Content");
//              doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
//              return false;
//              }

                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("input", "Content");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }


                return true;
                break;

            case IBINSERT: // Row Add

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;

            case IBSEARCH_ASYNC01: //confirm

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (formObj.blpl_hdr_seq.value == "") {
                    return false;
                }

                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }

                //sheet1에서 하나라도 저장했는지 체크
                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
                    ComPriInputValueFailed("input","Title","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }


                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0) {
                    ComShowCodeMessage("input", "Content");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                    return false;
                }

                if (checkModified(formObj)) {
                    ComShowCodeMessage("PRI03009","");
                    return false;
                }

                return true;
                break;

            case IBSEARCH_ASYNC02: //confirm cancel

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (formObj.blpl_hdr_seq.value == "") {
                    return false;
                }

                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.cfm_flg.value == "No") {
                    ComShowCodeMessage('PRI00106');
                    return false;
                }

                return true;
                break;


            case IBSEARCH_ASYNC03: //all delete

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (formObj.blpl_hdr_seq.value == "") {
                    return false;
                }

                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }

                return true;
                break;

            case IBCOPYROW: // Row Copy

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;


            case IBDELETE: //row Delete

                if (eventStatus == "IBCOPY") {
                    return false;
                }

                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }
                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","input",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","input",formObj.exp_dt);
                    return false;
                }
                if (formObj.cfm_flg.value == "Yes") {
                    ComShowCodeMessage('PRI00105');
                    return false;
                }
                return true;
                break;


            case IBSEARCH_ASYNC04: // COPY

                if (formObj.blpl_hdr_seq.value == "") {
                    ComShowCodeMessage('PRI08015');
                    return false;
                }

                if (formObj.blpl_ref_yr.value == "") {
                    ComPriInputValueFailed("input","year",formObj.blpl_ref_yr);
                    return false;
                }

                if(!ComIsNumber(document.form.blpl_ref_yr,'0123456789')) {
                    ComShowCodeMessage('PRI00311');
                    document.form.blpl_ref_yr.value = "";
                    return false;
                }

                if(document.form.blpl_ref_yr.value.length < 4) {
                    ComPriInputValueFailed("input","year 4 digit",formObj.blpl_ref_yr);
                    return false;
                }

                if (formObj.eff_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.eff_dt);
                    return false;
                }
                if (formObj.exp_dt.value == "") {
                    ComPriInputValueFailed("input","Duration",formObj.exp_dt);
                    return false;
                }

                if (formObj.eff_dt.value > formObj.exp_dt.value) {
                    ComShowCodeMessage('PRI00305', '[Duration]');
                    return false;
                }

                var blpl_ref_yr = formObj.blpl_ref_yr.value;
                if (blpl_ref_yr != formObj.eff_dt.value.substr(0,4) && blpl_ref_yr != formObj.exp_dt.value.substr(0,4)) {
                    ComShowCodeMessage('PRI00324');
                    formObj.eff_dt.focus();
                    return false;
                }
        }

        return true;
    }

    /**
     * 년도 OnKeyPress 시 호출된다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchDuration
     * </pre>
     * @param {sheetObj} sheetObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function searchDuration() {
        if(ComIsEmpty(document.form.blpl_ref_yr)) return;

        if(!ComIsNumber(document.form.blpl_ref_yr,'0123456789')) {
            ComShowCodeMessage('PRI00311');
            document.form.blpl_ref_yr.value = "";
            return;
        }

        //COPY 상태이면 조회하지 않음
        if (eventStatus == "IBCOPY") return;

        var length = document.form.blpl_ref_yr.value.length;

        if(length == 4) {
            if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
                removeSearchCondition(document.form);

                //headr
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                //title
                doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);

                document.form.eff_dt.focus();
            }
        }
    }

    /**
     * 변경사항이 있으면 true 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     *      checkModified(formObj)
     * </pre>
     * @return boolean <br>
     * @author 이승준
     * @version 2009.06.10
     */
    function checkModified(formObj) {
        isModified = false;

        if (formObj.eff_dt.value != formObj.eff_dt_hidden.value
                || formObj.exp_dt.value != formObj.exp_dt_hidden.value
                || sheetObjects[1].IsDataModified
                || sheetObjects[2].IsDataModified) {

            isModified = true;
        }

        return isModified;
    }

    /**
     * 화면을 전체 리셋한다.<br>
     * 데이터가 변경된 경우 저장한다.
     * <br><b>Example :</b>
     * <pre>
     *     removeAll(formObj)
     * </pre>
     * @param {formObj} formObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function removeAll(formObj) {
        if (checkModified(formObj)) {

            if (ComShowCodeConfirm("PRI00006")) {
                supressConfirm = true;
                doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                supressConfirm = false;
            } else {
                formObj.reset();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
            }
        } else {
            formObj.reset();
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
        }

        formObj.blpl_ref_yr.focus();
        eventStatus = "";
        toggleButtons("INIT");
    }

    /**
     * 조회 조건을 리셋한다.<br>
     * 데이터가 변경된 경우 저장한다.
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,gubun)
     * </pre>
     * @param {form} formObj
     * @param {String} gubun
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function removeSearchCondition(formObj) {
        if(eventStatus == "IBCOPY") return;

        //년도를 빼고 화면 리셋
        formObj.eff_dt.value = "";
        formObj.exp_dt.value = "";
        formObj.eff_dt_hidden.value = "";
        formObj.exp_dt_hidden.value = "";
        formObj.blpl_hdr_seq.value = "";
        formObj.cfm_flg.value = "";

        toggleButtons("INIT");
    }


    /**
     * copy 시 기존 조회 조건을 히든값에 카피한 후 조회조건 리셋.<br>
     * <br><b>Example :</b>
     * <pre>
     *     removeCopy(formObj)
     * </pre>
     * @param {form} formObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function removeCopy(formObj) {
        if (eventStatus == "IBCOPY") {
            return false;
        }

        var blpl_hdr_seq_copy   = formObj.blpl_hdr_seq.value;

//      sheetObjects[1].RemoveAll();
//      sheetObjects[2].RemoveAll();

        formObj.reset();

        formObj.blpl_hdr_seq_copy.value     = blpl_hdr_seq_copy;
        formObj.blpl_hdr_seq.value          = blpl_hdr_seq_copy;

        formObj.blpl_ref_yr.focus();
    }

    /**
     * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {String} mode
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function toggleButtons(mode) {
        switch (mode) {
            case "INIT":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnDisable("btn_confirmcancel");
                ComBtnDisable("btn_delete");
                ComBtnDisable("btn_copy");
                ComBtnEnable("btn_downexcel");

                ComBtnEnable("btn_rowadd");
                ComBtnEnable("btn_rowadd2");
                ComBtnEnable("btn_rowcopy");
                ComBtnEnable("btn_rowcopy2");
                ComBtnEnable("btn_rowdelete");
                ComBtnEnable("btn_rowdelete2");

                sheetControl(true);
                break;

            case "CONF_YES":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnDisable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnEnable("btn_confirmcancel");
                ComBtnDisable("btn_delete");
                ComBtnEnable("btn_copy");
                ComBtnEnable("btn_downexcel");

                ComBtnDisable("btn_rowadd");
                ComBtnDisable("btn_rowadd2");
                ComBtnDisable("btn_rowcopy");
                ComBtnDisable("btn_rowcopy2");
                ComBtnDisable("btn_rowdelete");
                ComBtnDisable("btn_rowdelete2");

                sheetControl(false);
                break;

            case "CONF_NO":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnEnable("btn_confirm");
                ComBtnDisable("btn_confirmcancel");
                ComBtnEnable("btn_delete");
                ComBtnEnable("btn_copy");
                ComBtnEnable("btn_downexcel");

                ComBtnEnable("btn_rowadd");
                ComBtnEnable("btn_rowadd2");
                ComBtnEnable("btn_rowcopy");
                ComBtnEnable("btn_rowcopy2");
                ComBtnEnable("btn_rowdelete");
                ComBtnEnable("btn_rowdelete2");

                sheetControl(true);
                break;

            case "IBCOPY":
                ComBtnEnable("btn_retrieve");
                ComBtnEnable("btn_new");
                ComBtnEnable("btn_save");
                ComBtnDisable("btn_confirm");
                ComBtnDisable("btn_confirmcancel");
                ComBtnDisable("btn_delete");
                ComBtnDisable("btn_copy");

                ComBtnDisable("btn_rowadd");
                ComBtnDisable("btn_rowadd2");
                ComBtnDisable("btn_rowcopy");
                ComBtnDisable("btn_rowcopy2");
                ComBtnDisable("btn_rowdelete");
                ComBtnDisable("btn_rowdelete2");

                sheetControl(false);
                break;

        }
    }

    /**
     * IBSheet의 Cell을  컨폼 여부에 따라 활성,비활성화 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    sheetControl(mode);
     * </pre>
     * @param   {boolean} flag 필수
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheetControl(flag) {
        var sheetObj1 = sheetObjects[1];
        var sheetObj2 = sheetObjects[2];

        for (var i = 1; i <= sheetObj1.RowCount;i++) {
            sheetObj1.CellEditable(i, "chk") = flag;
            sheetObj1.CellEditable(i, "blpl_tit_nm") = flag;
        }

        for (var i = 1; i <= sheetObj2.RowCount;i++) {
            sheetObj2.CellEditable(i, "chk") = flag;
        }
    }

    /**
     * 버튼을 confirm에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setConfirmButton()
     * </pre>
     * @param {String} mode
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function setConfirmButton()  {
        var cfm_flg = document.form.cfm_flg.value;
        if(cfm_flg == "Yes") toggleButtons("CONF_YES");
        else if(cfm_flg == "No") toggleButtons("CONF_NO");
        else if(cfm_flg == "") toggleButtons("INIT");
    }

    /**
     * 저장시 dp_seq 세팅.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setDpSeq(sheetObj)
     * </pre>
     * @param {sheetObj} sheetObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function setDpSeq(sheetObj)  {
        if(!sheetObj.IsDataModified) return;

        for(var i=1; i<=sheetObj.RowCount; i++) {
            sheetObj.CellValue2(i, "dp_seq") = i;

            if(sheetObj.RowStatus(i) == "R") {
                sheetObj.RowStatus(i) = "U";
            }
        }
    }

    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
     * @return 없음
     * @author 공백진
     * @version 2009.06.03
     */
    function sheet2_OnClick(sheetObj, Row, Col, Value) {
        var cfm_flg = document.form.cfm_flg.value;

        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
        var colname = sheetObj.ColSaveName(Col);

        switch(colname)
        {
            case "blpl_ctnt":
                if(cfm_flg == "Yes")
                    ComShowMemoPad(sheetObj,Row,Col,true,903,200);
                else
                    ComShowMemoPad(sheetObj,Row,Col,false,903,200);

                break;
        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 Excel Download <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2010.04.23
     */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            sheetObj.Down2Excel(-1, false, false, true, "", "apps/alps/esm/pri/scguideline/scboilerplateguideline/script/ESM_PRI_0007.xml");
        }
    }

    /* 개발자 작업  끝 */