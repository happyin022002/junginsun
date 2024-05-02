/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0104.js
*@FileTitle : Guideline Route Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.20 문동규
* 1.0 Creation
* 
* 2013.12.05 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
*                 route note 에서는 Chassis Exception 입력 불가	처리
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
     * @class ESM_PRI_0104 : ESM_PRI_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0104() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
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
     * @version 2009.05.20
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            
            if (srcName == null || srcName == "") {
            	return false;
            }
            if (srcName.indexOf("btn") == 0 && getButtonTable(srcName).disabled) {
            	return false;
            }

            switch(srcName) {

                case "btn_RowAdd":
                    doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;

                case "btn_RowCopy":
                    doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
                    break;

                case "btn_Delete":
                    doActionIBSheet(sheetObject1,formObject,IBDELETE);
                    break;

                case "btn_Ok":
                    doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    // 변경사항이 없을 경우에 창닫기
                    if (!sheetObject1.IsDataModified) {
                        window.returnValue = "O";
                        window.close();
                    }
                    break;

                case "btn_Close":
                    window.close();
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
     * @author 문동규
     * @version 2009.05.20
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
     * @author 문동규
     * @version 2009.05.20
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            
    		if (document.form.isEditable.value == "false") {
    			sheetObjects[0].Editable = false;
    			ComBtnDisable("btn_RowAdd");
    			ComBtnDisable("btn_RowCopy");
    			ComBtnDisable("btn_Delete");
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
     * @version 2009.05.20
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 170;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1 = "|Sel|Seq.|||||||Item|Surcharge|Content";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,      WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 0,   daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtDummyCheck,   30,  daCenter, true,  "sel_chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      40,  daCenter, true,  "seq");

                    InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, "svc_scp_cd");
                    InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, "gline_seq");
                    InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, "prc_cust_tp_cd");
                    InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, "cmdt_hdr_seq");
                    InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, "rout_seq");
                    InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, "rout_note_seq");

                    InitDataProperty(0, cnt++, dtCombo,        80,  daCenter, true,  "note_clss_cd", true,  "", dfNone, 0, true, true);
                    InitDataProperty(0, cnt++, dtCombo,        90,  daCenter, true,  "chg_cd",       false, "", dfNone, 0, true, true);
                    InitDataProperty(0, cnt++, dtData,         200, daLeft,   true,  "note_ctnt",    true,  "", dfNone, 0, true, true);

                    InitDataCombo(0, "note_clss_cd", itemComboText, itemComboValue," ", " ");
                    InitDataCombo(0, "chg_cd", scgComboText, scgComboValue, " \t ", " ");
                    InitDataValid(0, "note_ctnt", vtEngOther, PRI_VALID_CHAR);  // 한글제외
                    CountPosition = 0;
                    ColHidden("chg_cd") = true;
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
     * @version 2009.05.20
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
                ComOpenWait(true);
                //sheet data를 메인페이지에서 가져온다.
                var sXml = dialogArguments.getSheetXml(8);
                sheetObj.LoadSearchXml(sXml);
                checkSurcharge(sheetObj);
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                ComOpenWait(true);
                if(validateForm(sheetObj,formObj,sAction)){
                    var sXml = ComPriSheet2Xml(sheetObj);
                    dialogArguments.setSheetXml(sXml, 8);
                    window.returnValue = "O";
                    window.close();
                }
                ComOpenWait(false);
                break;

            case IBINSERT:      // 입력
                var Row = sheetObj.DataInsert();
                sheetObj.CellValue2(Row,"svc_scp_cd")     = formObj.svc_scp_cd.value;
                sheetObj.CellValue2(Row,"gline_seq")      = formObj.gline_seq.value;
                sheetObj.CellValue2(Row,"prc_cust_tp_cd") = formObj.prc_cust_tp_cd.value;
                sheetObj.CellValue2(Row,"cmdt_hdr_seq")   = formObj.cmdt_hdr_seq.value;
                sheetObj.CellValue2(Row,"rout_seq")       = formObj.rout_seq.value;
                // key 채번                
                sheetObj.CellValue2(Row,"rout_note_seq") = parseInt(ComPriGetMax(sheetObj, "rout_note_seq")) + 1;
                break;

            case IBCOPYROW:      // 입력
                var Row = sheetObj.DataCopy();
                // key 채번
                sheetObj.CellValue2(Row,"rout_note_seq") = parseInt(ComPriGetMax(sheetObj, "rout_note_seq")) + 1;
                break;

            case IBDELETE:      // 삭제
                deleteRowCheck(sheetObj, "sel_chk", true);
                checkSurcharge(sheetObj);
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
     * @version 2009.05.20
     */
    function validateForm(sheetObj,formObj,sAction){

        with(sheetObj){
            switch(sAction){
                case IBSAVE:
                    var saveStr = sheetObj.GetSaveString(false);

                    if (saveStr == "") {
                        return false;
                    }

                    var cnt = sheetObj.RowCount;

                    for (var i = 1; i <= cnt; i++) {
                        if (sheetObj.CellValue(i, "note_clss_cd") == "S") {
                            if (ComIsEmpty(sheetObj.CellValue(i, "chg_cd"))) {
                                ComShowCodeMessage("PRI08010", i, "Surcharge");
                                sheetObj.SelectCell(i, "chg_cd");
                                return false;
                            }
                        }
                    }
                    break;
            }
        }
        return true;
    }

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Item ComboBox에서 'Surcharge'가 선택 되었을 경우만 Surcharge 셀을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnChange 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnChange 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.05.20
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var colname = sheetObj.ColSaveName(Col);

        switch(colname) {
            case "note_clss_cd":
                checkSurcharge(sheetObj);
                break;

        }
    }

    /**
     * Item ComboBox에서 'Surcharge' 선택유무에 따라 Surcharge 셀을 보여주거나 감춘다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     checkSurcharge(sheetObj);
     *     checkSurcharge(sheetObj, "note_clss_cd", "chg_cd");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} iColName 선택 Item ComboBox SaveName
     *                               default="note_clss_cd"
     * @param {string} sColName 선택 Surcharge ComboBox SaveName
     *                               default="chg_cd"
     * @return 없음
     * @author 문동규
     * @version 2009.05.20
     */
    function checkSurcharge(sheetObj, iColName, sColName) {

        iColName = (iColName == null) ? "note_clss_cd" : iColName;
        sColName = (sColName == null) ? "chg_cd" : sColName;

        var cnt = sheetObj.RowCount;
        var bool = false;
        var status;

        for (var i = 1; i <= cnt; i++) {
            if (sheetObj.CellValue(i, iColName) == "S") {
                bool = true;
                sheetObj.CellEditable(i, sColName) = true;
            } else if (sheetObj.CellValue(i, iColName) == "C") {
            	ComShowCodeMessage("PRI00333", "Chassis");				
				sheetObj.CellValue2(i, "note_clss_cd") = "";
            } else {
                if (ComRtrim(sheetObj.CellValue(i, sColName)) != "") {
                    status = sheetObj.RowStatus(i);
                    sheetObj.CellValue2(i, sColName) = " ";
                    sheetObj.RowStatus(i) = status;                    
                }
                sheetObj.CellEditable(i, sColName) = false;
            }
        }

        if (bool) {
            sheetObj.ColHidden(sColName) = false;
        } else {
            sheetObj.ColHidden(sColName) = true;
        }
    }

    /* 개발자 작업  끝 */