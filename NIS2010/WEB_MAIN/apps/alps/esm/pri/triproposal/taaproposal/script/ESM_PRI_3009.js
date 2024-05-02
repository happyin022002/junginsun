/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3009.js
 *@FileTitle : TRI Creation & Amendment - TRI Select
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.03
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.12.03 문동규
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
     * @class ESM_PRI_3009 : ESM_PRI_3009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3009 () {
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
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.12.03
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

                case "btn_OK":
                    var arr = new Array();
                    var obj = null;
                    var j = 0;
                    for (var i = sheetObject1.HeaderRows, n = sheetObject1.HeaderRows + sheetObject1.RowCount ; i < n ; i++) {
                        if (sheetObject1.CellValue(i, "chk") == 1) {
                            obj = new Object();
                            obj.tri_prop_no       = sheetObject1.CellValue(i, "tri_prop_no");
                            obj.trf_pfx_cd        = sheetObject1.CellValue(i, "trf_pfx_cd");
                            obj.trf_no            = sheetObject1.CellValue(i, "trf_no");
                            obj.tri_no            = sheetObject1.CellValue(i, "tri_no");
                            obj.cmdt_cd           = sheetObject1.CellValue(i, "cmdt_cd");
                            obj.cmdt_nm           = sheetObject1.CellValue(i, "cmdt_nm");
                            obj.org_pnt_loc_cd    = sheetObject1.CellValue(i, "org_pnt_loc_cd");
                            obj.org_via_port_cd   = sheetObject1.CellValue(i, "org_via_port_cd");
                            obj.dest_via_port_cd  = sheetObject1.CellValue(i, "dest_via_port_cd");
                            obj.dest_pnt_loc_cd   = sheetObject1.CellValue(i, "dest_pnt_loc_cd");
                            obj.org_pnt_loc_nm    = sheetObject1.CellValue(i, "org_pnt_loc_nm");
                            obj.org_via_port_nm   = sheetObject1.CellValue(i, "org_via_port_nm");
                            obj.dest_via_port_nm  = sheetObject1.CellValue(i, "dest_via_port_nm");
                            obj.dest_pnt_loc_nm   = sheetObject1.CellValue(i, "dest_pnt_loc_nm");
                            obj.rat_ut_cd         = sheetObject1.CellValue(i, "rat_ut_cd");
                            obj.prc_cgo_tp_cd     = sheetObject1.CellValue(i, "prc_cgo_tp_cd");
                            obj.curr_cd           = sheetObject1.CellValue(i, "curr_cd");
                            obj.fnl_frt_rt_amt    = sheetObject1.CellValue(i, "fnl_frt_rt_amt");
                            obj.note_ctnt         = sheetObject1.CellValue(i, "note_ctnt");
                            obj.note_conv_mapg_id = sheetObject1.CellValue(i, "note_conv_mapg_id");
                            obj.eff_dt            = sheetObject1.CellValue(i, "eff_dt");
                            obj.exp_dt            = sheetObject1.CellValue(i, "exp_dt");
                            arr[j++] = obj;
                        }
                    }

                    if (arr == null || arr.length == 0) {
                        ComShowCodeMessage("PRI00011");
                        return;
                    }

                    window.returnValue = arr;
                    window.close();
                    break;

                case "btn_Close":
                    window.close();
                    break;

                case "btn_cmdt":
                    var sUrl = "/hanjin/ESM_PRI_4027.do?grp_cd=" + PRI_SP_SCP + "&commodity_cmd=C";
                    var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 303, true);
                    if (rtnVal != null){
                        formObject.frm_cmdt_cd.value = rtnVal.cd;
                        formObject.frm_cmdt_nm.value = rtnVal.nm;
                    }
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
     * @param {ibsheet} sheet_obj 필수, IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.12.03
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
     * @version 2009.12.03
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
            var formObj = document.form;
            initControl();
            // 조회
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
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
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.12.07
     */
    function initControl () {
        var formObj = document.form;
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerForm('change', 'obj_change', formObj);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('beforeactivate', 'obj_activate', formObj);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
    }

    /**
     * OnChange event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.07
     */
    function obj_change () {
        var formObj = document.form;
        switch (event.srcElement.name) {
            case "frm_cmdt_cd":
                if (formObj.frm_cmdt_cd.value.length == 6) {
                    formObj.f_cmd.value = SEARCH08;
                    var param = "&cd=" + formObj.frm_cmdt_cd.value;
                    var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
                    var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
                    if (arrData != null && arrData.length > 0 && arrData[1] != "") {
                        formObj.frm_cmdt_nm.value = arrData[1];
                    } else {
                        formObj.frm_cmdt_cd.value = "";
                        formObj.frm_cmdt_nm.value = "";
                        return false;
                    }
                } else {
                    formObj.frm_cmdt_cd.value = "";
                    formObj.frm_cmdt_nm.value = "";
                }
                break;

            case "frm_org_pnt_loc_cd":
                checkLocationCode(formObj, formObj.frm_org_pnt_loc_cd);
                break;
            case "frm_org_via_port_cd":
                checkLocationCode(formObj, formObj.frm_org_via_port_cd);
                break;
            case "frm_dest_via_port_cd":
                checkLocationCode(formObj, formObj.frm_dest_via_port_cd);
                break;
            case "frm_dest_pnt_loc_cd":
                checkLocationCode(formObj, formObj.frm_dest_pnt_loc_cd);
                break;
            
            default:
        }
    }

    /**
     * Onbeforedeactivate Event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.08
     */
    function obj_deactivate () {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var ele = event.srcElement;
        var eleName = ele.name;

        switch (eleName) {
            case "frm_tri_no":
                // TRI No Format : 6자리-4자리-3자리
                var val = ele.value;
                if (val == "" || val.replace(/-/g,"").length != 13) {
                    ele.value = "";
                    return;
                }
                var re = /(^[0-9]{6})+([0-9]{4})+([0-9]{3}$)/g;
                ele.value = val.replace(re, "$1-$2-$3");
                break;
        }
    }

    /**
     * OnBeforeActivate Event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.12.08
     */
    function obj_activate () {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var eleName = event.srcElement.name;

        switch (eleName) {
            case "frm_tri_no":
                event.srcElement.value = event.srcElement.value.replace(/-/g,"");
                break;
        }
    }

    /**
     * Location Code 가 유효한지 체크한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     checkLocationCode(document.form, document.form.loc_cd);
     * </pre>
     * @param {object} frm 필수, Html Form Object
     * @param {object} src 필수, Html Object
     * @return 없음
     * @author 문동규
     * @version 2009.12.03
     */
    function checkLocationCode(frm, src) {
        if (src.value.length == 5) {
            frm.f_cmd.value = SEARCH05;
            var param = "&cd=" + src.value;
            var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(frm) + param);
            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
            // MDM_LOCATION에 없는 코드일 경우 Clear
            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
                src.value = "";
                src.focus();
            }
        } else {
            // 5자리가 아닌 코드일 경우 Clear
            src.value = "";
            src.focus();
        }
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} sheetNo 필수, IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.12.03
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 182;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    var HeadTitle = "status|Sel.|Seq.|tri_prop_no|Tariff Rate Item\n(TRI)|Commodity|Commodity|Route|Route|Route|Route|Route nm|Route nm|Route nm|Route nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Duration|Duration|trf_pfx_cd|trf_no";
                    var HeadTitle1 = "status|Sel.|Seq.|tri_prop_no|Tariff Rate Item\n(TRI)|Code|Description|Origin|Origin Via|Dest Via|Dest|Origin Nm|Origin Via Nm|Dest Via Nm|Dest Nm|Per|CGO\nType|Cur.|Rate|Note|note_conv_mapg_id|Effective|Expiration|trf_pfx_cd|trf_no";

                    var headCount = ComCountHeadTitle(HeadTitle);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 6, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,0,  daCenter,  false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,    40,  daCenter,  true,   "chk",               false, "", dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtDataSeq,     30,  daCenter,  true,   "seq",               false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,   "tri_prop_no",       true,  "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        105, daCenter,  true,   "tri_no",            true,  "", dfUserFormat,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        48,  daCenter,  true,   "cmdt_cd",           false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        120, daLeft,    true,   "cmdt_nm",           false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        77,  daLeft,    true,   "org_pnt_loc_cd",    false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        60,  daLeft,    true,   "org_via_port_cd",   false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        60,  daLeft,    true,   "dest_via_port_cd",  false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        77,  daLeft,    true,   "dest_pnt_loc_cd",   false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      0, daLeft,    true,   "org_pnt_loc_nm",    false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      0,  daLeft,    true,   "org_via_port_nm",   false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      0,  daLeft,    true,   "dest_via_port_nm",  false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      0, daLeft,    true,   "dest_pnt_loc_nm",   false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        25,  daCenter,  true,   "rat_ut_cd",         false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        33,  daCenter,  true,   "prc_cgo_tp_cd",     false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        28,  daCenter,  true,   "curr_cd",           false, "", dfNone,    0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        66,  daRight,   true,   "fnl_frt_rt_amt",    false, "", dfFloat,   0,  false,  false);
                    InitDataProperty(0, cnt++ , dtPopup,       58,  daLeft,    true,   "note_ctnt",         false, "", dfNone,    0,  true,   true);
                    InitDataProperty(0, cnt++ , dtHidden,      0,  daLeft,    true,   "note_conv_mapg_id", false, "", dfNone,    0,  false,  false);    // Hidden
                    InitDataProperty(0, cnt++ , dtData,        65,  daCenter,  true,   "eff_dt",            false, "", dfDateYmd, 0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,        65,  daCenter,  true,   "exp_dt",            false, "", dfDateYmd, 0,  false,  false);
                    InitDataProperty(0, cnt++ , dtHidden,      0,  daLeft,    true,   "trf_pfx_cd",        false, "", dfNone,    0,  false,  false);    // Hidden
                    InitDataProperty(0, cnt++ , dtHidden,      0,  daLeft,    true,   "trf_no",            false, "", dfNone,    0,  false,  false);    // Hidden
                    WaitImageVisible = false;
                    Ellipsis = true;
                    AutoRowHeight = false;

                    InitUserFormat(0, "tri_no", "######-####-###", "-");
                    ShowButtonImage = 2;
                    CountPosition = 0;
                }
                break;

            case "sheet2":  // hidden
                with (sheetObj) {
                    // 높이 설정
                    style.height = 182;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    var HeadTitle = "status";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,   false,  "ibflag");
                    WaitImageVisible = false;

                    Visible = false;
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
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @return 없음
     * @author 문동규
     * @version 2009.12.03
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
                ComOpenWait(true);
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return;
                }

                // Route Name 항목을 Clear
                formObj.frm_org_pnt_loc_nm.value = "";
                formObj.frm_org_via_port_nm.value = "";
                formObj.frm_dest_via_port_nm.value = "";
                formObj.frm_dest_pnt_loc_nm.value = "";

                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("ESM_PRI_3009GS.do" , FormQueryString(formObj));
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
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @returns bool, <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.12.03
     */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {
            case IBSEARCH:
                if (formObj.frm_trf_pfx_cd.value == '' || formObj.frm_trf_no.value == '') {
                    ComShowCodeMessage('PRI00316','Tariff Code');
                    return false;
                }
                break;
        }
        return true;
    }

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * 선택한 TRI 목록에 해당하는 Route Name을 보여준다.<br>
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
     * @version 2009.11.30
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if(OldRow != NewRow){
            var formObj = document.form;
            formObj.frm_org_pnt_loc_nm.value = sheetObj.CellValue(NewRow, "org_pnt_loc_nm").replace(/\|/g, "\n");
            formObj.frm_org_via_port_nm.value = sheetObj.CellValue(NewRow, "org_via_port_nm").replace(/\|/g, "\n");
            formObj.frm_dest_via_port_nm.value = sheetObj.CellValue(NewRow, "dest_via_port_nm").replace(/\|/g, "\n");
            formObj.frm_dest_pnt_loc_nm.value = sheetObj.CellValue(NewRow, "dest_pnt_loc_nm").replace(/\|/g, "\n");
        }
    }

    /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * Note Conversion Popup 을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} Row 필수, OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 문동규
     * @version 2009.12.07
     */      
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;

        switch(colName) {
            case "note_ctnt":
                var sParam = "";
                sParam += "note_conv_mapg_id=" + sheetObj.CellValue(Row, "note_conv_mapg_id");
                sParam += "&note_ctnt="+ encodeURIComponent(sheetObj.CellValue(Row, "note_ctnt"));
                var sUrl = "/hanjin/ESM_PRI_3003.do?" + sParam;
                var rtnVal = ComPriOpenWindowCenter(sUrl, window, 800, 460, true);
                break;
        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 조회 완료 후 Note Content 를 Tooltip 적용 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2009.12.07
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj = document.form;

        for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows + sheetObj.RowCount ; i < n ; i++) {
            sheetObj.ToolTipText(i, "note_ctnt") = sheetObj.CellValue(i, "note_ctnt");
        }
        formObj.frm_cmdt_cd.focus();
    }

    /* 개발자 작업  끝 */