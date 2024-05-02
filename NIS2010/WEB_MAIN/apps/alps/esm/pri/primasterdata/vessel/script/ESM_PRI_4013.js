/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_4013.js
 *@FileTitle : Vessel Code Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.05.27 문동규
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
     * @extends Pri
     * @class ESM_PRI_4013 : ESM_PRI_4013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4013 () {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br>
     * <b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.05.27
     */
    function processButtonClick () {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    
        var sheetObject1 = sheetObjects[0];
    
        /** **************************************************** */
        var formObject = document.form;
    
        try {
            var srcName = window.event.srcElement.getAttribute("name");
    
            switch (srcName) {
    
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    break;
    
                case "btn_Ok":
                    returnSelectCode(sheetObject1);
                    break;
    
                case "btn_Close":
                    window.close();
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
     * @version 2009.05.27
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
     * @version 2009.05.27
     */
    function loadPage () {
        try {
            for (i = 0; i < sheetObjects.length; i++) {
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                // khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
            document.form.vsl_cd.focus();
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
     * @version 2009.05.27
     */
    function initSheet (sheetObj, sheetNo) {
    
        var cnt = 0;
    
        switch (sheetObj.id) {
            case "sheet1": // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 150;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);
    
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
    
                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
    
                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);
    
                    var HeadTitle = "|Code|Description";
                    var headCount = ComCountHeadTitle(HeadTitle);
    
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)
    
                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
                    // POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
                    // FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
                    InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vsl_cd",     false, "", dfNone);
                    InitDataProperty(0, cnt++, dtData, 0,  daLeft,   true, "vsl_eng_nm", false, "", dfNone);
                    WaitImageVisible = false;
    
                    CountPosition = 0;
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
     * @version 2009.05.27
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
    
            case IBSEARCH: //조회
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value = SEARCH;
//                    sheetObj.DoSearch("ESM_PRI_4013GS.do", FormQueryString(formObj));
                    sheetObj.DoSearch4Fx("ESM_PRI_4013GS.do", FormQueryString(formObj));
                }
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
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.05.27
     */
    function validateForm (sheetObj, formObj, sAction) {
   
        with (sAction) {
            switch (sAction) {
                case IBSEARCH:
                    var len = formObj.vsl_cd.value.length;
                    if (len > 0 && len < 2) {
                        ComShowCodeMessage("PRI04001", "2");
                        formObj.vsl_cd.select();
                        return false;
                    }
                    break;
            }
        }
    
        return true;
    }
    
    /**
     * OnDblClick 이벤트 발생시 호출되는 function <br>
     * sheet의 Row를 더블클릭하면 선택한 Row의 Code를 메인화면으로 return하고 창을 닫는다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.05.26
     */
    function sheet1_OnDblClick (sheetObj, Row, Col, Value) {
        returnSelectCode(sheetObj);
    }
    
    /**
     * 선택한 Row의 코드를 메인페이지로 return한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     returnSelectCode(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 문동규
     * @version 2009.05.26
     */
    function returnSelectCode (sheetObj) {
        window.returnValue = sheetObj.CellValue(sheetObj.SelectRow, "vsl_cd");
        window.close();
    }
/* 개발자 작업  끝 */