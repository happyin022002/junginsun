/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2049.js
 *@FileTitle : RFA Proposal Creation - Request Received and Sent
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 문동규
 *@LastVersion : 1.0
* 2009.10.05 문동규
* 1.0 Creation
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
       조회 가능토록 수정  
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만
                                                                    자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
 * 2012.02.08 이석준[CHM-201216074] RFA 조회시 HAMRU 산하의 BA OFFICE들이 상대방 BA RFA 조회 못하게 했던 부분을 다시 원래대로 조회 할 수 있도록 수정     
 * 2015.04.07 전지예 [CHM-201535026] Customer code & name 추가
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
     * @class ESM_PRI_2049 : ESM_PRI_2049 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2049 () {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
    }
 
    /* 개발자 작업   */

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.10.05
     */
    function processButtonClick () {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch (srcName) {

                case "btn_Retrieve":
                    if (formObj.trans_tp_cd[1].checked) {
                        doActionIBSheet(sheetObject2, formObj, IBSEARCH);
                    } else {
                        doActionIBSheet(sheetObject1, formObj, IBSEARCH);
                    }
                    break;

                case "btn_Open":
                    var propNo = "";
                    var curSheetCnt = 0;
                    if (formObj.trans_tp_cd[0].checked) {
                        propNo = sheetObject1.CellValue(sheetObject1.SelectRow, "prop_no");
                        curSheetCnt = sheetObject1.RowCount;
                    } else if (formObj.trans_tp_cd[1].checked) {
                        propNo = sheetObject2.CellValue(sheetObject2.SelectRow, "prop_no");
                        curSheetCnt = sheetObject2.RowCount;
                    }
                    if (curSheetCnt == 0 || propNo ==""){
                        ComShowCodeMessage('PRI01021');
                        return;
                    }
                    var pgmNo = "ESM_PRI_2003";
                    var pgmUrl = "/hanjin/ESM_PRI_2003.do"
                    var params = "&cond_prop_no=" + propNo;
                    var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
                    var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
                    var sUrl = "alpsMain.screen?parentPgmNo=" + parentPgmNo + src;
                    var iWidth = 1024;
                    var iHeight = 700;
                    var leftpos = (screen.width - iWidth) / 2;
                    if (leftpos < 0)
                        leftpos = 0;
                    var toppos = (screen.height - iHeight) / 2;
                    if (toppos < 0)
                        toppos = 0;

                    var sFeatures = "status=no, resizable=yes, scrollbars=yes, width="+iWidth+", left="+leftpos+", top="+toppos;
                    ComPriOpenWindow(sUrl, "", sFeatures, iHeight);
                    break;

                case "btn_calendar1": //달력버튼1
                case "btn_calendar2": //달력버튼2
                    var cal = new ComCalendarFromTo();
                    cal.select(formObj.eff_dt, formObj.exp_dt, 'yyyy-MM-dd');
                    break;

                case "trans_tp_cd":
                    if (formObj.trans_tp_cd[0].checked) {
                        sheetObject1.style.height = 420;
                        sheetObject2.style.height = 0;
                        sheetObject2.RemoveAll();
                        doActionIBSheet(sheetObject1, formObj, IBSEARCH);
                    } else if (formObj.trans_tp_cd[1].checked) {
                        sheetObject1.style.height = 0;
                        sheetObject2.style.height = 420;
                        sheetObject1.RemoveAll();
                        doActionIBSheet(sheetObject2, formObj, IBSEARCH);
                    }
                    break;
                    
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
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
     * @author 문동규
     * @version 2009.10.05
     */
    function setSheetObject (sheet_obj) {
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
     * @author 문동규
     * @version 2009.10.05
     */
    function loadPage () {
        try {
            for (i = 0; i < sheetObjects.length; i++) {
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            var formObj = document.form;
            initControl();
            initCondition();
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
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
     * 기본 조건값을 설정한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCondition ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.10.05
     */
    function initCondition () {
        var formObj = document.form;
        // 날짜 기본값 : from - 현재일 부터 1주일 전, to - 현재일
        formObj.eff_dt.value = ComGetDateAdd(null, "D", -7);
        formObj.exp_dt.value = ComGetNowInfo();
    }

    /**
     * 업무 자바스크립트 OnActivate/OnDeactivate 이벤트 Listener를 추가한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.10.05
     */
    function initControl () {
        var formObj = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
    }

    /**
     * 업무 자바스크립트 OnActivate 이벤트를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.10.05
     */
    function obj_activate () {
        var formObj = document.form;
        var eleName = event.srcElement.name;

        switch (eleName) {
            case "eff_dt":
            case "exp_dt":
                // 마스크 구분자 없애기
                ComClearSeparator(event.srcElement);
                break;
        }
    }

    /**
     * 업무 자바스크립트 OnDeactivate 이벤트를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.10.05
     */
    function obj_deactivate () {
        var formObj = document.form;
        var eleName = event.srcElement.name;

        switch (eleName) {
            case "eff_dt":
            case "exp_dt":
                // 입력Validation 확인 및 마스킹 처리
                ComChkObjValid(event.srcElement);
                break;
        }
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
     * @author 문동규
     * @version 2009.10.05
     */
    function initSheet (sheetObj, sheetNo) {

        var cnt = 0;

        switch (sheetNo) {
            case 1: // Received sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 6, 100);

                    var HeadTitle1 = "|TO/CC|prop_sts_cd|Status|Proposal No.|RFA No.|AMD No.|From|From|From|From|Customer|Customer|Date";
                    var HeadTitle2 = "|TO/CC|prop_sts_cd|Status|Proposal No.|RFA No.|AMD No.|Office|User ID|Code|Name|Code|Name|Date";
                    var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rqst_tp_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "prop_sts_cd", false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "prop_sts_nm", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "prop_no", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "rfa_no", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "amdt_seq", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "ofc_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "usr_id", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "srep_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "usr_nm", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "ctrt_cust_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 130, daLeft, true, "ctrt_pty_nm", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "prog_dt", false, "", dfDateYmd, 0, false, false);
                    WaitImageVisible = false;
                }
                break;

            case 2: // Sent sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);
    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 6, 100);
    
                    var HeadTitle1 = "|TO/CC|prop_sts_cd|Status|Proposal No.|RFA No.|AMD No.|To|To|To|To|Customer|Customer|Date";
                    var HeadTitle2 = "|TO/CC|prop_sts_cd|Status|Proposal No.|RFA No.|AMD No.|Office|User ID|Code|Name|Code|Name|Date";
                    var headCount = ComCountHeadTitle(HeadTitle2);
    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rqst_tp_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "prop_sts_cd", false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "prop_sts_nm", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "prop_no", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "rfa_no", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "amdt_seq", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "ofc_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "usr_id", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "srep_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "usr_nm", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "ctrt_cust_cd", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 130, daLeft, true, "ctrt_pty_nm", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "prog_dt", false, "", dfDateYmd, 0, false, false);
                    WaitImageVisible = false;
                }
                break;

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
     * @author 문동규
     * @version 2009.10.05
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
            case IBSEARCH: //조회
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch("ESM_PRI_2049GS.do", FormQueryString(formObj));
                }
                ComOpenWait(false);
                break;
        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 font 색상 변경<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2010.05.12
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            changeRowFontColor(sheetObj);
            changeSelectBackColor4Rate(sheetObj);
        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 font 색상 변경<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2010.05.12
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            changeRowFontColor(sheetObj);
            changeSelectBackColor4Rate(sheetObj);
        }
    }

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Initial/Returned Row 의 Highlight 색상을 다르게 표시한다. <br>
     * <br>
     * <b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 문동규
     * @version 2009.05.17
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if (OldRow != NewRow) {
            changeSelectBackColor4Rate(sheetObj);
        }
    }

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Initial/Returned Row 의 Highlight 색상을 다르게 표시한다. <br>
     * <br>
     * <b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 문동규
     * @version 2009.05.17
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if (OldRow != NewRow) {
            changeSelectBackColor4Rate(sheetObj);
        }
    }

    /**
     * Status 가 Initial/Returned 인 데이터 font 색상 변경<br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * changeRowFontColor(sheetObj);
     * </pre>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @returns 없음
     * @author 문동규
     * @version 2010.05.12
     */
    function changeRowFontColor(sheetObj) {
        for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows + sheetObj.RowCount ; i < n ; i++) {
            if (sheetObj.CellValue(i, "prop_sts_cd") == "I" || sheetObj.CellValue(i, "prop_sts_cd") == "R") {
                sheetObj.RowFontColor(i) =  sheetObj.RgbColor(255,0,0);
            }
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
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.10.05
     */
    function validateForm (sheetObj, formObj, sAction) {
        // Form 기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크
        if (!ComChkValid(formObj)) {
            return false;
        }
        return true;
    }

    /* 개발자 작업  끝 */