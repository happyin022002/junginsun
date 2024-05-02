/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_4019.js
 *@FileTitle : Surcharge Commodity Group Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.05
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.06.05 문동규
 * 1.0 Creation
=========================================================
 * History
 * 2015.09.04 전지예 [CHM-201537789] [Non-Cargo NOS] Surcharge Commodity Group 관련 요청
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
     * @class ESM_PRI_4019 : ESM_PRI_4019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4019 () {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
    }
    
    /* 개발자 작업	*/
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
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
     * @version 2009.06.05
     */
    function processButtonClick () {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
    
        /*******************************************************/
        var formObject = document.form;
    
        try {
            var srcName = window.event.srcElement.getAttribute("name");
    
            switch (srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject2, formObject, IBSEARCH);
                    break;
    
                case "btn_new":
                    searchConditionReset(document.form);
                    break;
    
                case "btn_downexcel":
                    doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL);
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
     * @version 2009.06.05
     */
    function setSheetObject (sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBMultiCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj 필수 IBMultiCombo Object
     * @return 없음
     * @author 문동규
     * @version 2009.06.05
     */
    function setComboObject (combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
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
     * @version 2009.06.05
     */
    function loadPage () {
        try {
            for (i = 0; i < sheetObjects.length; i++) {
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
        
                initSheet(sheetObjects[i], i + 1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
        
            //IBMultiCombo초기화
            for ( var k = 0; k < comboObjects.length; k++) {
                initCombo(comboObjects[k], k + 1);
            }
            doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
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
     * 콤보 초기설정값, 헤더 정의 <br>
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.06.05
     */
    function initCombo (comboObj, comboNo) {
        switch (comboObj.id) {
            case "svc_scp_cd":
                with (comboObj) {
                    Style = 0;
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseCode = true;
                    UseAutoComplete = false;
                    ValidChar(2, 0);
                    MaxLength = 3;
                }
                break;
        }
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보에서 값을 변경하면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.06.05
     */
    function svc_scp_cd_OnChange(comboObj, code, text) {
        if(comboObjects[0].GetCount() > 0 && comboObjects[0].Index != "-1") {
            var formObj = document.form;
            var desc = null;
            if (isNaN(parseInt(code, 10))) {
                desc = formObj.svc_scp_cd.GetText(code,1);
            } else {
                desc = formObj.svc_scp_cd.GetIndexText(code,1);
            }
            formObj.svc_scp_nm.value = desc;

            // TPW, ACW Scope에만 NON Cargo NOS 적용
            if(comboObjects[0].Code == 'TPW' || comboObjects[0].Code == 'ACW') {
            	sheetObjects[2].ColHidden("non_cgo_nos_flg") = false;
            } else {
            	sheetObjects[2].ColHidden("non_cgo_nos_flg") = true;
            }
            
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
    }
    
    /**
     * IBMultiCombo에서 OnBlur 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @returns 없음
     * @author 문동규
     * @version 2009.06.02
     */
    function svc_scp_cd_OnBlur (comboObj) {
        var formObj = document.form;
        var code = comboObj.FindIndex(comboObj.Code, 0);

        if (code != "-1") {
            var text = comboObj.GetText(comboObj.Text, 1);

            if (text == "" && !ComIsEmpty(comboObj.Text)) {
                formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
                searchConditionReset(formObj,"1");
                doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
//                formObj.svc_scp_nm.focus();
            }
        } else {
            ComShowCodeMessage("PRI00315");
            comboObj.Text = "";
            comboObj.Index = "-1";
            formObj.svc_scp_nm.value = "";

            sheetObjects[1].removeAll();
            sheetObjects[2].removeAll();
        }
    }

    /**
     * IBMultiCombo에서 OnClear 이벤트 발생시 호출되는 function <br>
     * svc_scp_cd 콤보에서 포커스가 나가면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @returns 없음
     * @author 문동규
     * @version 2009.06.02
     */
//    function svc_scp_cd_OnClear (comboObj) {
//        var formObject = document.form;
//        formObject.svc_scp_nm.value = "";
//        comboObj.Index2 = -1;
//    }

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
     * @version 2009.06.05
     */
    function initSheet (sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
    
            case "sheet0": //hidden 
                with (sheetObj) {
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);
    
                }
                break;
    
            case "sheet1": // 
                with (sheetObj) {
    
                    // 높이 설정
                    style.height = 480;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);
    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)
    
                    var HeadTitle = "|Group\nCode|Group Name|Delete\nMark|Creation\nDate|svc_scp_cd|chg_cd|scg_grp_cmdt_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData,     60,  daCenter, false, "scg_grp_cmdt_cd",   false, "", dfNone, 0, false, false, 2);
                    InitDataProperty(0, cnt++, dtData,     160, daLeft,   false, "scg_grp_cmdt_desc", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtCheckBox, 50,  daCenter, false, "delt_flg",          false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,     60,  daCenter, false, "cre_dt",            false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   90,  daLeft,   false, "svc_scp_cd",        false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   90,  daLeft,   false, "chg_cd",            false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   90,  daLeft,   false, "scg_grp_cmdt_seq",  false, "", dfNone, 0, false, false);
                    WaitImageVisible = false;

                    InitDataValid(0, "scg_grp_cmdt_cd", vtEngUpOther, "0123456789"); // 영문대문자,숫자만 입력 
                }
                break;
    
            case "sheet2": // 
                with (sheetObj) {
    
                    // 높이 설정
                    style.height = 480;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);
    
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle = "|Non-Cargo\nNOS|Seq.|Commodity\nCode|Description|Effective\nDate|Expiration\nDate|Update\nDate|svc_scp_cd|chg_cd|scg_grp_cmdt_seq|scg_grp_cmdt_dtl_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,	70,	daCenter,		false,	"non_cgo_nos_flg",		false,	"",	dfNone,	0,	false, false,	0,	false, false, "", false);
                    InitDataProperty(0, cnt++, dtSeq,     40,  daCenter, false, "Seq");
                    InitDataProperty(0, cnt++, dtData,   90,  daCenter, false, "cmdt_cd",              false, "", dfNone,    0, false, false, 6);
                    InitDataProperty(0, cnt++, dtData,   240, daLeft,   false, "cmdt_des",             false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtData,   70,  daCenter, false, "eff_dt",               false, "", dfDateYmd, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   70,  daCenter, false, "exp_dt",               false, "", dfDateYmd, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   70,  daCenter, false, "upd_dt",               false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "svc_scp_cd",           false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "chg_cd",               false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "scg_grp_cmdt_seq",     false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "scg_grp_cmdt_dtl_seq", false, "", dfNone,    0, false, false);
                    WaitImageVisible = false;

                    ShowButtonImage = 2;
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
     * @version 2009.06.05
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
    
            case IBCLEAR:
                // 화면 로딩시 Service Scope 조회
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");

                comboObjects[0].Index = "-1";
                comboObjects[0].Code = "TPW";
                break;
    
            case IBSEARCH: //조회
                if (validateForm(sheetObj, document.form, sAction)) {
                    try {
                        ComOpenWait(true);
                        if (sheetObj.id == "sheet1") {
                            for ( var i = 0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }
                            formObj.f_cmd.value = SEARCH01;
                            sheetObj.DoSearch("ESM_PRI_4019GS.do", FormQueryString(formObj));
                        } else if (sheetObj.id == "sheet2") {
                            formObj.f_cmd.value = SEARCH02;
                            sheetObj.DoSearch("ESM_PRI_4019GS.do", FormQueryString(formObj));
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
                }
                break;
    
            case IBDOWNEXCEL:
                ComOpenWait(true);
                sheetObj.Down2Excel(-1);
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
     * @version 2009.06.05
     */
    function validateForm (sheetObj, formObj, sAction) {
        switch (sAction) {
    
            case IBSEARCH: // 조회
                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                break;

            case IBDOWNEXCEL: // excel down
                if (comboObjects[0].Code == "") {
                    ComShowCodeMessage('PRI08002');
                    return false;
                }
                break;
        }

        return true;
    }

    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * </pre>
     * 
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.05.19
     */
    function sheet1_OnSelectCell (sheetObj, OldRow, OldCol, NewRow, NewCol) {
        doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, false);
    }

    var isFiredNested = false;
    var supressConfirm = false;

    /**
     * Sheet에서 Row변경되었을 때 이벤트를 처리할 함수. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.05.19
     */ 
    function doRowChange (sheetM, sheetD, OldRow, NewRow, OldCol, appendRow) {
        try {
            var formObj = document.form;

            if (!isFiredNested && (OldRow != NewRow)) {
                if (sheetM.IsDataModified) {
                    isFiredNested = true;
                    if (!validateForm(sheetM, document.form, IBSAVE)) {
                        sheetM.SelectCell(OldRow, OldCol, false);
                        isFiredNested = false;
                        return -1;
                    }
                    isFiredNested = false;
                }

                if (sheetD.IsDataModified) {
                    if (ComShowCodeConfirm("PRI00006")) {

                        supressConfirm = true;
                        var rslt = doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                        supressConfirm = false;
                        if (!rslt) {
                            isFiredNested = true;
                            sheetM.SelectCell(OldRow, OldCol, false);
                            isFiredNested = false;
                            return -1;
                        }
                    }
                }

                if (appendRow) {
                    isFiredNested = true;
                    var idx = sheetM.DataInsert();
                    isFiredNested = false;
                    return idx;
                } else {
                    formObj.f_cmd.value = SEARCH02;
                    formObj.scg_grp_cmdt_seq.value = sheetM.CellValue(NewRow, "scg_grp_cmdt_seq");
                    doActionIBSheet(sheetD, document.form, IBSEARCH);
                }
            }
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

    /* 개발자 작업  끝 */