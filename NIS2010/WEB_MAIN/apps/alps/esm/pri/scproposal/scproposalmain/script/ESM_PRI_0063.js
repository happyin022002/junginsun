/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0063.js
*@FileTitle : TPW Group Commodity Guideline Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.22 문동규
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
     * @class ESM_PRI_0063 : ESM_PRI_0063 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0063() {
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
     * @version 2009.05.22
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

                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;

                case "btn_CheckAll":
                    sheetObject2.CheckAll("sel_chk") = 1;
                    break;

                case "btn_UncheckAll":
                    sheetObject2.CheckAll("sel_chk") = 0;
                    break;

                case "btn_OK":
                    addCheckedDetailData(sheetObject1, sheetObject2, sheetObject1.SelectRow);
                    
                    if (checkedMdata.size() == 0) {
                        ComShowCodeMessage('PRI00011');
                        break;
                    }
                    var keys = checkedDdata.getKeys();
                    var master = new Array();
                    var detail = new Array();
                    
                    for (var i = 0, n = keys.length; i < n; i++) {
                        if (checkedMdata.get(keys[i]) != null) {
                            master.push(checkedMdata.get(keys[i]));
                            detail.push(checkedDdata.get(keys[i]));
                        }
                    }
                    
                    var rtnVal = new Object();
                    rtnVal.master = master;
                    rtnVal.detail = detail;
                    
                    window.returnValue = rtnVal;
                    window.close();
                    
                    break;

                case "btn_Close":
                    window.close();
                    break;


            } // end switch
        }catch(e) {
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
     * @version 2009.05.22
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
     * @version 2009.05.22
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
    
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
    
                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
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
     * @version 2009.05.22
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
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
                    InitRowInfo( 1, 1, 6, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle = "|SEQ|||||Group Code|Description";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,   false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,      35,   daCenter,   false,  "seq");

                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "svc_scp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "gline_seq");
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "prc_cust_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "grp_cmdt_seq");
                    InitDataProperty(0, cnt++ , dtData,         140,  daCenter,   false,  "prc_grp_cmdt_cd",    false,  "",     dfNone,     0,          false,       false);
                    InitDataProperty(0, cnt++ , dtData,         140,  daLeft,     false,  "prc_grp_cmdt_desc",  false,  "",     dfNone,     0,          false,       false);
                    WaitImageVisible = false;

                }
                break;


            case 2:      // sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 160;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|Sel.|SEQ|||||||Code|Description";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,   false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,     45,   daCenter,   false,  "sel_chk");
                    InitDataProperty(0, cnt++ , dtDataSeq,      35,   daCenter,   false,  "seq");

                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "svc_scp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "gline_seq");
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "prc_cust_tp_cd");
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "grp_cmdt_seq");
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "grp_cmdt_dtl_seq");
                    InitDataProperty(0, cnt++ , dtHidden,       30,   daCenter,   false,  "prc_cmdt_tp_cd");

                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,   false,  "prc_cmdt_def_cd",  false,  "",     dfNone,     0,          false,       false);
                    InitDataProperty(0, cnt++ , dtData,         130,  daLeftTop,  false,  "loc_des",          false,  "",     dfNone,     0,          false,       false);
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
     * @version 2009.05.22
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH: // 조회
                ComOpenWait(true);
                if (validateForm(sheetObj,formObj,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value = SEARCH01;
                        sheetObj.DoSearch("ESM_PRI_0063GS.do" , FormQueryString(formObj));
                        
                    }else if (sheetObj.id == "sheet2") {
                        formObj.f_cmd.value = SEARCH02;
                        sheetObj.DoSearch("ESM_PRI_0063GS.do" , FormQueryString(formObj));
                        
                    }
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
     * @version 2009.05.22
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
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
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.05.19
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {

        if (OldRow != NewRow) {
            try {
                if (OldRow != 0) {
                    addCheckedDetailData(sheetObj, sheetObjects[1], OldRow);
        
                }
                var formObj = document.form;
        
                formObj.gline_seq.value      = sheetObj.CellValue(NewRow, "gline_seq");
                formObj.grp_cmdt_seq.value   = sheetObj.CellValue(NewRow, "grp_cmdt_seq");
        
                doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
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
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {string} errMsg 필수 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.05.19
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg){
        var sheetObj1 = sheetObjects[0];
        var row = sheetObj1.SelectRow;
        var key = sheetObj1.CellValue(row, "svc_scp_cd")+","+sheetObj1.CellValue(row, "gline_seq")+","+sheetObj1.CellValue(row, "prc_cust_tp_cd")+","+sheetObj1.CellValue(row, "grp_cmdt_seq");
        var val = checkedDdata.get(key);

        if (val != null && val.length > 0) {
            for (var i = 0, n = val.length; i < n; i++) {
                if (val[i] == "") {
                    continue;
                }
                 
                for (var j = 1 , k = sheetObj.RowCount; j <= k; j++) {
                    if (sheetObj.CellValue(j, "grp_cmdt_dtl_seq") == val[i].grp_cmdt_dtl_seq) {
                        sheetObj.CellValue(j, "sel_chk") = 1;
                    }
                }
            }
        }
    }

    var checkedMdata = new HashMap();
    var checkedDdata = new HashMap();
    var checkedData = new HashMap();

    /**
     * Detail Grid의 선택된 Data를 HashMap에 저장한다. <br>
     * 기존에 같은 key가 있으면 덮어쓰게된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     addCheckedDetailData(sheetObjects[0], sheetObjects[1], 1);
     * </pre>
     * @param {ibsheet} msheetObj 필수 HTML태그(Object) 오브젝트. Master Sheet
     * @param {ibsheet} dsheetObj 필수 HTML태그(Object) 오브젝트. Detail Sheet
     * @param {int} OldRow 필수 이전에 선택된 Master Grid의 Row Index
     * @return 없음
     * @author 문동규
     * @version 2009.05.22
     */
    function addCheckedDetailData(msheetObj, dsheetObj, OldRow) {
        var formObj = document.form;
        var chkd = dsheetObj.FindCheckedRow("sel_chk");
        var key = msheetObj.CellValue(OldRow, "svc_scp_cd")+","+msheetObj.CellValue(OldRow, "gline_seq")+","+msheetObj.CellValue(OldRow, "prc_cust_tp_cd")+","+msheetObj.CellValue(OldRow, "grp_cmdt_seq");

        if (chkd != "") {
            var arr = chkd.split("|");
            var vals = new StringBuffer();
            var valArr = new Array();
            var mobj = new Object();
            var dobj = new Object();
            mobj.prop_no = formObj.prop_no.value;
            mobj.amdt_seq = formObj.amdt_seq.value;
            mobj.svc_scp_cd = formObj.svc_scp_cd.value;
            mobj.gline_seq = msheetObj.CellValue(OldRow, "gline_seq");
            mobj.prc_cust_tp_cd = msheetObj.CellValue(OldRow, "prc_cust_tp_cd");
            mobj.grp_cmdt_seq = msheetObj.CellValue(OldRow, "grp_cmdt_seq");
            mobj.prc_grp_cmdt_cd = msheetObj.CellValue(OldRow, "prc_grp_cmdt_cd");
            mobj.prc_grp_cmdt_desc = msheetObj.CellValue(OldRow, "prc_grp_cmdt_desc");
            checkedMdata.put(key, mobj);

            for (var i = 0, n = arr.length; i < n; i++) {
                if (arr[i] == "") {
                    continue;
                }

                dobj = new Object();
                dobj.prop_no = formObj.prop_no.value;
                dobj.amdt_seq = formObj.amdt_seq.value;
                dobj.svc_scp_cd = formObj.svc_scp_cd.value;
                dobj.gline_seq = msheetObj.CellValue(OldRow, "gline_seq");
                dobj.prc_cust_tp_cd = msheetObj.CellValue(OldRow, "prc_cust_tp_cd");
                dobj.grp_cmdt_seq = msheetObj.CellValue(OldRow, "grp_cmdt_seq");
                dobj.prc_cmdt_tp_cd = dsheetObj.CellValue(Number(arr[i]), "prc_cmdt_tp_cd");
                dobj.prc_cmdt_def_cd = dsheetObj.CellValue(Number(arr[i]), "prc_cmdt_def_cd");
                dobj.grp_cmdt_dtl_seq = dsheetObj.CellValue(Number(arr[i]), "grp_cmdt_dtl_seq"); 

                valArr.push(dobj);
            }
            checkedDdata.put(key, valArr);
        } else {
            checkedMdata.remove(key);
            checkedDdata.remove(key);
        }
    }
    
    /**
     * HashMap 객체 생성자.<br>
     * Java 에서 사용하는 HashMap과 동일한 객체를 생성한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     hm = new HashMap();      // 생성
     *     hm.put(key, value);      // 값 입력
     *     val = hm.get(key);       // 값 출력
     *     hm.remove(key);          // 값 삭제
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.05.22
     */
    function HashMap() {
        this.mapVal = {};
        this.pos = new Array();
    }

    HashMap.prototype.get = function get( key ) {
        return this.mapVal[ key ];
    }

    HashMap.prototype.getPos = function getPos( n ) {
        return this.mapVal[ this.pos[n] ];
    }

    HashMap.prototype.getKeys = function getKeys() {
        return this.pos;
    }

    HashMap.prototype.remove = function remove( n ) {
        var ary = new Array();
        var len = this.pos.length;
        if ((n + 0) == n) { // number
            for( var i = 0; i < len; i++ ) {
                if( i != n ) {
                    ary.push( this.pos[i] );
                }
            }
            this.mapVal[ this.pos[n] ] = null;
        } else {    // string
            for( var i = 0; i < len; i++ ) {
                if( this.pos[i] != n ) {
                    ary.push( this.pos[i] );
                }
            }
            this.mapVal[ n ] = null;
        }

        this.pos = ary;
    }

    HashMap.prototype.put = function put( key, val ) {
        this.mapVal[key] = val;

        var flg = true;
        for( var i = 0; i < this.pos.length; i++ ) {
            if( key == this.pos[i] ) {
                flg = false;
                break;
            }
        }

        if( flg ) {
            this.pos.push( key );
        }
    }

    HashMap.prototype.size = function size() {
        return this.pos.length;
    }

    /* 개발자 작업  끝 */