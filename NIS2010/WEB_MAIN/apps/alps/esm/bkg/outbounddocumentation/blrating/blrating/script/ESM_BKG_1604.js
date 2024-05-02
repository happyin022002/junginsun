/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1604.js
 *@FileTitle : RFA Proposal Creation [Request]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.01
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.10.01 문동규
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
     * @class ESM_BKG_1604 : ESM_BKG_1604 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1604 () {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
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
        var sheetObject3 = sheetObjects[2];
        /*******************************************************/
        var formObj = document.form;
    
        try {
            var srcName = window.event.srcElement.getAttribute("name");
    
            switch (srcName) {
    
                case "btn_AddTo":
                    var SRow = sheetObject1.SelectRow;
                    if (sheetObject1.CellValue(SRow, "type_flg") != 'U') {
                        return;
                    }
    
                    var usrId = sheetObject1.CellValue(sheetObject1.SelectRow, "usr_id");
                    if (-1 != sheetObject2.FindText("apro_rqst_ref_usr_id", usrId)
                            || -1 != sheetObject3.FindText("apro_rqst_ref_usr_id", usrId)) {
                        return;
                    }
                    doActionIBSheet(sheetObject2, formObj, IBINSERT);
                    break;
    
                case "btn_DeleteTo":
                    doActionIBSheet(sheetObject2, formObj, IBDELETE);
                    break;
    
                case "btn_AddCC":
                    var SRow = sheetObject1.SelectRow;
                    if (sheetObject1.CellValue(SRow, "type_flg") != 'U') {
                        return;
                    }
    
                    var usrId = sheetObject1.CellValue(sheetObject1.SelectRow, "usr_id");
                    if (-1 != sheetObject2.FindText("apro_rqst_ref_usr_id", usrId)
                            || -1 != sheetObject3.FindText("apro_rqst_ref_usr_id", usrId)) {
                        return;
                    }
                    doActionIBSheet(sheetObject3, formObj, IBINSERT);
                    break;
    
                case "btn_DeleteCC":
                    doActionIBSheet(sheetObject3, formObj, IBDELETE);
                    break;
    
                case "btn_Send":
                	var cnt = sheetObject2.RowCount;
                	if(cnt == 0){
                		ComShowCodeMessage("BKG95034", "[To User]");
                		return false;
                	}
                	
                	var rArray	 = new Array();
                	var idx = 0;
                	var cnt = sheetObject2.RowCount;
                	for ( var i = 1; i <= cnt; i++)
                	{
                		var obj = new Object(); //값 셋팅
                		obj.apro_rqst_ref_tp_cd			= sheetObject2.CellValue(i,"apro_rqst_ref_tp_cd");
                		obj.apro_rqst_ref_usr_seq		= sheetObject2.CellValue(i,"apro_rqst_ref_usr_seq");
                		obj.apro_rqst_ref_usr_id		= sheetObject2.CellValue(i,"apro_rqst_ref_usr_id");
                		obj.apro_rqst_ref_usr_ofc_cd	= sheetObject2.CellValue(i,"apro_rqst_ref_usr_ofc_cd");
                		obj.apro_rqst_ref_usr_eml		= sheetObject2.CellValue(i,"apro_rqst_ref_usr_eml");
                		rArray[idx++] = obj;
                	}
                	
                	cnt = sheetObject3.RowCount;
                	for ( var i = 1; i <= cnt; i++)
                	{
                		var obj = new Object(); //값 셋팅
                		obj.apro_rqst_ref_tp_cd			= sheetObject3.CellValue(i,"apro_rqst_ref_tp_cd");
                		obj.apro_rqst_ref_usr_seq		= sheetObject3.CellValue(i,"apro_rqst_ref_usr_seq");
                		obj.apro_rqst_ref_usr_id		= sheetObject3.CellValue(i,"apro_rqst_ref_usr_id");
                		obj.apro_rqst_ref_usr_ofc_cd	= sheetObject3.CellValue(i,"apro_rqst_ref_usr_ofc_cd");
                		obj.apro_rqst_ref_usr_eml		= sheetObject3.CellValue(i,"apro_rqst_ref_usr_eml");
                		rArray[idx++] = obj;
                	}
                	
                	window.returnValue = rArray ;//return 변수값 설정.		 		 
    				self.close();
                	break;
    
                case "btn_Search":
                    doActionIBSheet(sheetObject1, formObj, IBSEARCH);
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
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i], i + 1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            // Axon 이벤트 처리1. 이벤트catch(개발자변경)
            axon_event.addListenerForm('keydown', 'obj_keydown', document.form);
            // 조직도 조회
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
     * keyDown 이벤트 발생시 호출되는 function<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keydown ();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.10.05
     */
    function obj_keydown () {
        var formObj = document.form;
        var eleName = event.srcElement.name;
    
        switch (eleName) {
            case "ofc_cd":
            case "usr_id":
            case "usr_nm":
                if (event.keyCode == 13) {
                    try {
                        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
            case 1: //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 254;
                    // 전체 너비 설정
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
    
                    var HeadTitle = "ibflag||Organization|pnode_id|node_id|ofc_cd|usr_id|usr_nm|usr_eml|type_flg|auth_flg";
                    var headCount = ComCountHeadTitle(HeadTitle);
    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtData, 10, daLeft, false, "", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtImageText, 200, daLeft, false, "node_nm", false, "", dfNone, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "pnode_id");
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "node_id");
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "ofc_cd");
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "usr_id");
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "usr_nm");
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "usr_eml");
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "type_flg");
                    InitDataProperty(0, cnt++, dtHidden, 10, daLeft, false, "auth_flg");
                    WaitImageVisible = false;

                    InitTreeInfo(2, "slevel", RgbColor(0, 0, 255), true);
                    GridLine = 0;
                    CountPosition = 0;
                    ImageList("user") = "img/icon_tree_04.gif";
                }
                break;
    
            case 2: // sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 121;
                    // 전체 너비 설정
                    SheetWidth = subTable1.clientWidth;
    
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
    
                    var HeadTitle = "|rqst_tp_cd|rqst_ref_usr_seq|ofc_cd|User ID|EML|To:";
                    var headCount = ComCountHeadTitle(HeadTitle);
    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC,
                    // DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
                    // ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "apro_rqst_ref_tp_cd");
                    InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "apro_rqst_ref_usr_seq");
                    InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "apro_rqst_ref_usr_ofc_cd");
                    InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "apro_rqst_ref_usr_id", false);
                    InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "apro_rqst_ref_usr_eml", false);
                    InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "usr_nm", false, "", dfNone);
                    WaitImageVisible = false;
                    CountPosition = 0;
                }
                break;
    
            case 3: // sheet3 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 121;
                    // 전체 너비 설정
                    SheetWidth = subTable2.clientWidth;
    
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
    
                    var HeadTitle = "|rqst_tp_cd|rqst_ref_usr_seq|ofc_cd|User ID|EML|CC:";
                    var headCount = ComCountHeadTitle(HeadTitle);
    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                    InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "apro_rqst_ref_tp_cd");
                    InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "apro_rqst_ref_usr_seq");
                    InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "apro_rqst_ref_usr_ofc_cd");
                    InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "apro_rqst_ref_usr_id", false);
                    InitDataProperty(0, cnt++, dtHidden, 80, daLeft, false, "apro_rqst_ref_usr_eml", false);
                    InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "usr_nm", false, "", dfNone);
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
     * @version 2009.10.05
     */
    function doActionIBSheet (sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
            case IBSEARCH: //조회
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch("ESM_BKG_1604GS.do", FormQueryString(formObj));
                }
                ComOpenWait(false);
                break;
    
            case IBSAVE: //저장
                ComOpenWait(true);
                if (validateForm(sheetObj, formObj, sAction)) {
                    if (!ComPriProcessYn("send")) {
                        return;
                    }
                    formObj.f_cmd.value = MULTI;
    
                    var sParam = "";
                    var sParamSheet1 = sheetObjects[1].GetSaveString();
                    var sParamSheet2 = sheetObjects[2].GetSaveString();
    
                    if ((sheetObjects[1].IsDataModified && sParamSheet1 != "")
                            || (sheetObjects[2].IsDataModified && sParamSheet2 != "")) {
                        if (sheetObjects[1].IsDataModified && sParamSheet1 != "") {
                            sParam += "&" + sParamSheet1;
                        }
                        if (sheetObjects[2].IsDataModified && sParamSheet2 != "") {
                            sParam += "&" + sParamSheet2;
                        }
                    } else {
                        return;
                    }
    
                    sParam += "&" + FormQueryString(formObj);
                    var sXml = sheetObj.GetSaveXml("ESM_BKG_1604GS.do", sParam);
                    sheetObjects[1].LoadSaveXml(sXml);
                }
                ComOpenWait(false);
                break;
    
            case IBINSERT: // 입력
                var newRow = sheetObj.DataInsert();
                sheetObj.CellValue(newRow, "apro_rqst_ref_tp_cd") = (sheetObj.id == "sheet2") ? "T" : "C";
                sheetObj.CellValue(newRow, "apro_rqst_ref_usr_ofc_cd") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ofc_cd");
                sheetObj.CellValue(newRow, "apro_rqst_ref_usr_id") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"usr_id");
                sheetObj.CellValue(newRow, "apro_rqst_ref_usr_eml") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"usr_eml");
                sheetObj.CellValue(newRow, "usr_nm") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "node_nm");
    
                var seq = 0;
                for ( var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows + sheetObj.RowCount; i < n; i++) {
                    sheetObj.CellValue(i, "apro_rqst_ref_usr_seq") = ++seq;
                }
                break;
    
            case IBDELETE: // 삭제
                sheetObj.RowDelete(sheetObj.SelectRow, false);
                var seq = 0;
                for ( var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows + sheetObj.RowCount; i < n; i++) {
                    sheetObj.CellValue(i, "apro_rqst_ref_usr_seq") = ++seq;
                }
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
     * @version 2009.10.05
     */
    function validateForm (sheetObj, formObj, sAction) {
    
        switch (sAction) {
            case IBSAVE:
                if (!sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified) {
                    ComShowCodeMessage('PRI00301');
                    return false;
                }
                break;
        }
    
        return true;
    }
    
    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 User Node 일 경우 아이콘을 넣는다.<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 선택 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.10.05
     */
    function sheet1_OnSearchEnd (sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            var formObj = document.form;
            var indx = 0;
            while (true) {
                indx = sheetObj.FindText("type_flg", "U", indx + 1);
                if (indx != -1) {
                    if (sheetObj.CellImage(indx, "node_nm") != "user") {
                        sheetObj.CellImage(indx, "node_nm") = "user";
                    }
                } else {
                    break;
                }
            }
    
            while (true) {
                indx = sheetObj.FindText("auth_flg", "Y", indx + 1);
                if (indx != -1) {
                    if (sheetObj.CellFontColor(indx, "node_nm") != sheetObj.RgbColor(0, 0, 255)) {
                        sheetObj.CellFontColor(indx, "node_nm") = sheetObj.RgbColor(0, 0, 255);
                    }
                } else {
                    break;
                }
            }
    
            if (formObj.usr_id.value != '') {
                indx = sheetObj.FindText("usr_id", formObj.usr_id.value);
                if (indx != -1) {
                    sheetObj.SelectCell(indx, "node_nm");
                }
            }
            if (formObj.ofc_cd.value != '') {
                indx = sheetObj.FindText("ofc_cd", formObj.ofc_cd.value);
                if (indx != -1) {
                    sheetObj.SelectCell(indx, "node_nm");
                }
            }
            if (formObj.usr_nm.value != '') {
                indx = sheetObj.FindText("usr_nm", formObj.usr_nm.value, 0, 2, false);
                if (indx != -1) {
                    sheetObj.SelectCell(indx, "node_nm");
                }
            }
            sheetObjects[0].RowExpanded(1) = true;
        }
    }
    
    /**
     * OnTreeChild 이벤트 발생시 호출되는 function <br>
     * 트리의 [+] 버튼을 눌렀을때 트리를 확장하면서 Child 데이터를 조회한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} CondParam 필수 처음 조회 시 사용된 조회조건
     * @param {int} Row 필수 해당 행의 Row Index
     * @returns 없음
     * @author 문동규
     * @version 2009.10.05
     */
    function sheet1_OnTreeChild (sheetObj, CondParam, Row) {
        try {
            ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_1604GS.do", CondParam, "pnode_id=" + sheetObj.CellValue(Row, "node_id"), true, Row + 1);
            ComOpenWait(false);
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
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 저장 완료 후 창을 닫는다.<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 선택 저장 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.10.08
     */
    function sheet2_OnSaveEnd (sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            window.returnValue = "OK";
            window.close();
        }
    }

    /* 개발자 작업  끝 */