/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0089.js
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.18 문동규
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
     * @class ESM_PRI_0089 : ESM_PRI_0089 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0089() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

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
     * @version 2009.05.19
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_OK":
                    returnSelectedData();
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
     * 선택한 Row의 정보를 Parent 창으로 리턴한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     returnSelectedData();
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.12.16
     */    
    function returnSelectedData() {
        var retVal = new Object();
        if(hcurSheet == null){
            ComShowCodeMessage('PRI00011');
            return;
        }else if(hcurSheet.id == "sheet1"){
            retVal.ctnt = hcurSheet.CellValue(hcurRow, "ctrt_cluz_ctnt");
            if (hcurSheet.CellValue(hcurRow, "note_clss_cd") == 'S') {
                retVal.chgcd = hcurSheet.CellValue(hcurRow, "chg_cd");
            }
        }else if(hcurSheet.id == "sheet2"){
            retVal.ctnt = hcurSheet.CellValue(hcurRow, "stnd_wdg_ctnt");
        }
        window.returnValue = retVal;
        window.close();
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
     * @version 2009.05.19
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
     * @version 2009.05.19
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
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
     * @version 2009.05.19
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 82;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "|Seq.|Item|Surcharge|Clause";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,       false,      "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,          35,     daCenter,       false,      "SEQ");
                    InitDataProperty(0, cnt++ , dtCombo,        65,     daCenter,       false,      "note_clss_cd",     false,          "",     dfNone,                 0,      false,       false);
                    InitDataProperty(0, cnt++ , dtData,         65,     daCenter,       false,      "chg_cd",           false,          "",     dfNone,                 0,      false,       false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daLeft,         false,      "ctrt_cluz_ctnt",   false,          "",     dfNone,                 0,      false,       false);
                    WaitImageVisible = false;

                    InitDataCombo(0, "note_clss_cd", itemComboText, itemComboValue);
                    CountPosition = 0;
                    EditableColorDiff = false;
                    SelectHighLight = false;
                    ColHidden("chg_cd") = true;
                }
                break;

            case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 122;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle = "|Seq.|Standard Wording";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,       false,      "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,          35,     daCenter,       false,      "SEQ");
                    InitDataProperty(0, cnt++ , dtData,         100,    daLeft,         false,      "stnd_wdg_ctnt",          false,          "",     dfNone,                 0,      false,       false);
                    WaitImageVisible = false;

                    CountPosition = 0;
                    EditableColorDiff = false;
                    SelectHighLight = false;
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
     * @version 2009.05.19
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH: // 조회
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_0089GS.do" , FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                if (arrXml.length > 1) {
                    sheetObjects[1].LoadSearchXml(arrXml[1]);
                }
                if (arrXml.length > 0) {
                    sheetObjects[0].LoadSearchXml(arrXml[0]);
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
     * @version 2009.05.19
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//             if (!isNumber(formObj.iPage)) {
//          return false;
//          }
        }

        return true;
    }

    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
     * <br><b>Example :</b>
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
     * @version 2009.05.19
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        highlightSelectRow(sheetObj, NewRow);
    }

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
     * <br><b>Example :</b>
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
     * @version 2009.05.19
     */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        highlightSelectRow(sheetObj, NewRow);
    }

    /**
     * OnDblClick 이벤트 발생시 호출되는 function <br>
     * Sheet에서 Row 를 더블 클릭 시 해당 Row 의 정보를 return 함<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, HTML태그(Object) 오브젝트
     * @param {int} Row 필수, 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수, 이벤트가 발생한 해당 셀의 Value
     * @returns 없음
     * @author 문동규
     * @version 2009.12.16
     */
    function sheet1_OnDblClick (sheetObj, Row, Col, Value) {
        returnSelectedData();
    }

    /**
     * OnDblClick 이벤트 발생시 호출되는 function <br>
     * Sheet에서 Row 를 더블 클릭 시 해당 Row 의 정보를 return 함<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, HTML태그(Object) 오브젝트
     * @param {int} Row 필수, 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수, 이벤트가 발생한 해당 셀의 Value
     * @returns 없음
     * @author 문동규
     * @version 2009.12.16
     */
    function sheet2_OnDblClick (sheetObj, Row, Col, Value) {
        returnSelectedData();
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Item이 Surcharge가 아닌 경우 Surcharge 컬럼을 disable시킨다.
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.07.10
     */
    function sheet1_OnSearchEnd (sheetObj, errMsg) {
        var formObj = document.form;

        if (formObj.note_clss_cd.value == 'S') {
            sheetObj.ColHidden("chg_cd") = false;
        } else {
            sheetObj.ColHidden("chg_cd") = true;
        }
    
    }

    var hcurSheet = null;  // 현재 선택된 sheet
    var hcurRow = 0;       // 현재 선택된 row
    
    /**
     * 선택한 Row를 하이라이트처리한다. <br>
     * 다른 sheet를 선택하면 기존 하이라이팅된 sheet의 Row는 원래색으로 돌아간다. <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     *     highlightSelectRow(sheetObj, 1);
     * </pre>
     * 
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} row 필수 현재 선택된 Row Index
     * @return 없음
     * @author 문동규
     * @version 2009.05.19
     */
    function highlightSelectRow(sheetObj, row){
        if(sheetObj == hcurSheet && row == hcurRow){
            return;
        }
        sheetObj.RowBackColor(row) = sheetObj.SelectBackColor;
        
        if(hcurSheet != null && hcurRow != 0){
            hcurSheet.RowBackColor(hcurRow) = hcurSheet.RgbColor(0, 0, 0);
        }
        hcurSheet = sheetObj;
        hcurRow = row;
    }

    /* 개발자 작업  끝 */