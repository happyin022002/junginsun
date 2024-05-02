/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ui_pri_0001_06.js
 *@FileTitle : Rate Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.04 박성수
 * 1.0 Creation
=========================================================
* History
* 2011.04.04 서미진 [CHM-201109785-01] BCO S/C 일 경우, 특정 CMDTY 에 대해서 system 으로 차단
* 2013.04.22 전윤주 [CHM-201324292] SC Commodity validation 대상 추가
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
     * @class Guideline Creation : Guideline Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
     *        정의한다.
     */
    function ESM_PRI_0001_06() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
    }

    /* 개발자 작업 */

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var tabLoad = new Array();
    tabLoad[0] = 0;
    tabLoad[1] = 0;
    
    var LoadingComplete = false;
    
//    var arrTermOrg = new Array();
//    var arrTermDest = new Array();
//    var arrNoteClass = new Array();
//    var arrTransMode = new Array();
    
    var isOViaMandatory = false;
    var isDViaMandatory = false;
    var isDirCallVisible = false;
    
	// 2011-04-04 서미진 [CHM-201109785] TPE Scope, BCO S/C 일 경우 특정 CMDTY 에 대해서 system 으로 차단
	var block_cmdt_list = "000000/000002/000004/000005/000010/000017/961900/989200/989201";
	var block_cmdt = block_cmdt_list.split("/");
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function processButtonClick() {
        /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
    
        var sheetObject1 = sheetObjects[0];
    
        /** **************************************************** */
        var formObject = document.form;
    
        try {
            var srcName = window.event.srcElement.getAttribute("name");
    
            switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
    
            case "btn_downexcel":
                doActionIBSheet(sheetObjects[9], document.form, IBDOWNEXCEL);
                break;
                
            case "btn_loadexcel":
                if (formObject.gline_seq.value == "" || formObject.svc_scp_cd.value == "") {
                    return;
                }
                
                //execScript("rtn = msgbox(\"" + ComGetMsg("PRI01080") + "\", 3, \"Load Excel\")", "vbscript");
                var param = new StringBuffer();
                param.append("svc_scp_cd=").append(formObject.svc_scp_cd.value);
                param.append("&gline_seq=").append(formObject.gline_seq.value);
                param.append("&prc_cust_tp_cd=").append(getPrcCustTpCd());
                param.append("&eff_dt=").append(parent.getEffDt());
                param.append("&exp_dt=").append(parent.getExpDt());
                    
                ComPriOpenWindowCenter("/hanjin/ESM_PRI_0120.do?" + param, "ESM_PRI_0120", 950, 550, false);

                break;
                
            case "btn_mqc":
                if (formObject.svc_scp_cd.value != "" && formObject.gline_seq.value != "") {
                    var sUrl = '/hanjin/ESM_PRI_0030.do?svc_scp_cd='+formObject.svc_scp_cd.value+'&gline_seq='+formObject.gline_seq.value+'&prc_cust_tp_cd='+getPrcCustTpCd()+'&enable_flg='+enableFlag;
                    ComPriOpenWindowCenter(sUrl, 'p', 440, 350, false);
                    //ComPriOpenWindowCenter('/hanjin/ESM_PRI_0053.do?svc_scp_cd=' + formObject.svc_scp_cd.value + '&gline_seq=' + formObject.gline_seq.value + '&prc_cust_tp_cd=' + getPrcCustTpCd() + '', 'p', 440, 360, false);
                }
                break;
    
            case "btn_rowadd1":
                doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
                break;
    
            case "btn_rowadd2":
                doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                break;
                
            case "btn_rowadd3":
                doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                break;
                
            case "btn_rowcopy1":
                doActionIBSheet(sheetObjects[0], document.form, IBCOPYROW);
                break;
    
            case "btn_rowcopy2":
                doActionIBSheet(sheetObjects[1], document.form, IBCOPYROW);
                break;
            case "btn_delete1":
                doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
                break;
    
            case "btn_delete2":
                doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
                break;

            case "btn_delete3":
                doActionIBSheet(sheetObjects[2], document.form, IBDELETE);
                break;

            case "btn_save1":
                doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;
                
            case "btn_save2":
                doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
                break;

            case "btn_save3":
                doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
                break;

            case "prc_cust_tp_cd":
                if (formObject.svc_scp_cd.value != "" && formObject.gline_seq.value != "") {
                    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                }
                break;

            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheetObject(sheet_obj) {
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function loadPage() {
        for (var i = 0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].WaitImageVisible = false;
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        toggleButtons("CLEAR");
        parent.loadTabPage();
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function initSheet(sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
        case "sheet1":  // Grid 1
            with (sheetObj) {
                // 높이 설정
                style.height = 122;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(11, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Sel.|Seq.|Service Scope Code|Gline Seq.|Customer Type|Header Seq.|Commodity Code|Description|EFF Date|EXP Date";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prc_cust_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtPopup, 180, daLeft, false, "prc_cmdt_def_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 500, daLeft, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, true, true);
                InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, true, true);
                
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 0;
                ImageList(0) = "img/btns_calendar.gif";
                PopupButtonImage(0, "eff_dt") = 0;
                PopupButtonImage(0, "exp_dt") = 0;
            }
            break;
    
        case "sheet2":  // Grid 2
            with (sheetObj) {
                // 높이 설정
                style.height = 142;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(15, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Sel.|Seq.|Service Scope Code|Gline Seq.|Customer Type|Header Seq.|Route Seq.|Origin|O.Via|D.Via|Dest.|Direct Call|Route Note|Note Tooltip";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prc_cust_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, dtPopup, 140, daLeft, false, "org_rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 140, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 140, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 140, daLeft, false, "dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCheckBox, 95, daCenter, false, "dir_call_flg", false, "", dfNone, 0, true, true, -1, false, true, "", false);
                InitDataProperty(0, cnt++, dtPopup, 120, daLeft, false, "note_clss_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "note_tooltip", false, "", dfNone, 0, false, false);
                
                ToolTipOption="balloon:true;width:979;icon:1;title:Route Note";
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 0;
    
            }
            break;
    
        case "sheet3":  // Grid 3
            with (sheetObj) {
                // 높이 설정
                style.height = 122;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(15, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "|Sel.|Seq.|Service Scope Code|Gline Seq.|Customer Type|Header Seq.|Route Seq.|Rate Seq.|Min|Max|Per|Cargo Type|Cur.|Rate|";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gline_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prc_cust_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "mqc_rng_fm_qty", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "mqc_rng_to_qty", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo, 140, daCenter, false, "rat_ut_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo, 140, daCenter, false, "prc_cgo_tp_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo, 140, daCenter, false, "curr_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 150, daRight, false, "frt_rt_amt", true, "", dfNullFloat, 2, true, true, 9);
                
                InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
                InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue);
                InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");
                
                InitDataValid(0, "mqc_rng_fm_qty", vtNumericOnly);
                InitDataValid(0, "mqc_rng_to_qty", vtNumericOnly);
                
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 0;
    
            }
            break;
            
        case "sheet4":  // Grid 1의 Commodity 
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(9, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cust_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet5":  // Grid 2의 Origin Point
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(13, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cust_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet6":  // Grid 2의 Origin Via.
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(11, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cust_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet7":  // Grid 2의 Destination Via.
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(11, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cust_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet8":  // Grid 2의 Destination Point
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(13, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12|8-13";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cust_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet9":  // Grid 2의 Rnote
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(10, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
                var HeadTitle = "9-1|9-2|9-3|9-4|9-5|9-6|9-7|9-8|9-9|9-10";
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cust_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_note_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_clss_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "chg_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_ctnt", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet10": // Excel Download용 Sheet
	        with (sheetObj) {
	            // 높이 설정
	            style.height = 300;
	            // 전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            // Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "")
	                InitHostInfo(location.hostname, location.port, page_path);
	
	            // 전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	
	            // 전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	
	            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(2, 1, 3, 100);
	
	            var HeadTitle1 = "CMDT\nSeq|Commodity Group|Commodity Group|Route\nSeq|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|D.Call|MQC|MQC|Rate(USD)|Rate(USD)|Rate(USD)";
	            var HeadTitle2 = "CMDT\nSeq|Code|Description|Route\nSeq|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|D.Call|Min|Max|PER|Cargo Type|Rate";
	            var headCount = ComCountHeadTitle(HeadTitle2);
	
	            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(false, true, true, true, false, false)
	    
	            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, false);
	
	            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
	            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
	            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
	            // SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cmdt_dp_seq", true, "", dfNullInteger, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rout_dp_seq", true, "", dfNullInteger, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "org_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rcv_de_term_nm", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "dest_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_rcv_de_term_nm", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dest_prc_trsp_mod_nm", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "dir_call_flg", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "mqc_rng_fm_qty", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "mqc_rng_to_qty", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rat_ut_cd", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cgo_tp_cd", true, "", dfNone, 0, false, false);
	            InitDataProperty(0, cnt++, dtData, 100, daRight, false, "frt_rt_amt", true, "", dfNullFloat, 2, false, false);
	        }
            break;
        }
    }
    
	/**
	 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 0, Row, Col);
        }
    }
    
	/**
	 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 1, Row, Col);
        }
    }
    
	/**
	 * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet3_OnBeforeCheck(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 2, Row, Col);
        }
    }

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 서미진
     * @version 2011.03.31
     */  	
     function sheet1_OnChange(sheetObj, Row, Col, Value)
     {
     	var colname = sheetObj.ColSaveName(Col);  
     	var formObj = document.form
     	switch(colname)
     	{
 	    	case "prc_cmdt_def_cd":	    		
 	    		if (Value.length !=""){ 	
 	    			
 	    		// 2011-04-04 서미진 [CHM-201109785] TPE Scope, BCO S/C 일 경우 특정 CMDTY 에 대해서 system 으로 차단
 	    		// 2013-04-22 [CHM-201324292] Scope 추가 TPW TAE ASE TAW ASW MME MMW SAN SAS 
 	    			if( (sheetObj.CellValue(Row,"svc_scp_cd")=="TPE" ||sheetObj.CellValue(Row,"svc_scp_cd")=="TPW" 
 	    			   ||sheetObj.CellValue(Row,"svc_scp_cd")=="TAE" ||sheetObj.CellValue(Row,"svc_scp_cd")=="ASE"
 		    		   ||sheetObj.CellValue(Row,"svc_scp_cd")=="TAW" ||sheetObj.CellValue(Row,"svc_scp_cd")=="ASW"
 		    		   ||sheetObj.CellValue(Row,"svc_scp_cd")=="MME" ||sheetObj.CellValue(Row,"svc_scp_cd")=="MMW"
 		    		   ||sheetObj.CellValue(Row,"svc_scp_cd")=="SAN" ||sheetObj.CellValue(Row,"svc_scp_cd")=="SAS")
 	    					
 	    			  && sheetObj.CellValue(Row,"prc_cust_tp_cd")=="I"){
	 	               	var before_def_cd = sheetObj.CellValue(Row, "prc_cmdt_def_cd");         
	 	            	var split_def_cd = ComTrimAll(before_def_cd).split("/");
	 	            	
	 	            	for( var i = 0; i <split_def_cd.length ; i++ ){
		    				for( var j = 0; j <block_cmdt.length ; j++ ){
		    					if(split_def_cd[i] == block_cmdt[j]){
			    					ComShowCodeMessage("PRI00357");
			    					sheetObj.CellValue2(Row,"prc_cmdt_def_cd") ="";  
			    					sheetObj.CellValue(Row,"prc_cmdt_def_nm") ="";  
			    					sheetObj.SelectCell(Row, "prc_cmdt_def_cd");
			    					return false;
		    					}
		    				}
	 	            	} 
 	    			}
 	    		}
 	    		break; 
     	}
     }    
    
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet3_OnChange(sheetObj, Row, Col, Value) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "prc_cgo_tp_cd") {
            if (Value == "AK") {
                var validPerClass = "A,F,O,Q,S,P";
                var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
                if (validPerClass.indexOf(perClass) < 0) {
                    ComShowCodeMessage("PRI08003");
                    sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "";
                }
            }
        }
        
        if (colName == "rat_ut_cd") {
        	var validPerClass = "A,F,O,Q,S,P";
            var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
            if (perClass == "") {
            	return;
            }
            if (perClass == "D") {
            	sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "DR"
            } else if (perClass == "R") {
            	sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "RF"
            } else if (validPerClass.indexOf(perClass) >= 0) {
            	sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "AK"
            } else {
            	if (sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK") {
	                ComShowCodeMessage("PRI08003");
	                sheetObj.CellValue(Row, "prc_cgo_tp_cd") = "";
            	}
            }
        }
        
        // MQC 시작값을 바꿔주면 이전 행의 MQC종료값도 연결되도록 바꿔준다. 단 같은 Rating Unit안에서만 동작한다.(Partition by rat_ut_cd)
        if (colName == "mqc_rng_fm_qty") {
            if (Value != ""){
                var validPrevRow = getPrevValidRowCond(sheetObj, Row, "rat_ut_cd", sheetObj.CellValue(Row, "rat_ut_cd"));
                if (validPrevRow > 0) {
                    sheetObj.CellValue2(validPrevRow, "mqc_rng_to_qty") = parseInt(sheetObj.CellValue(Row, "mqc_rng_fm_qty")) - 1;
                }
            }
        }
        // MQC 종료값을 바꿔주면 다음 행의 MQC시작값도 연결되도록 바꿔준다. 단 같은 Rating Unit안에서만 동작한다.(Partition by rat_ut_cd)
        if (colName == "mqc_rng_to_qty") {
            if (Value != ""){
                var validNextRow = getNextValidRowCond(sheetObj, Row, "rat_ut_cd", sheetObj.CellValue(Row, "rat_ut_cd"));
                if (validNextRow > 0) {
                    sheetObj.CellValue2(validNextRow, "mqc_rng_fm_qty") = parseInt(sheetObj.CellValue(Row, "mqc_rng_to_qty")) + 1;
                }
            }
        }
    }
    
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        doRowChange1(OldRow, NewRow, OldCol, NewCol);
    }
    
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        doRowChange2(OldRow, NewRow, OldCol, NewCol);
    }
    
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var sStr = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                sStr += sheetObj.CellValue(i, "rout_pnt_loc_def_nm");
                if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
                	sStr += "(" + arrTermOrg[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
                }
                if (sheetObj.CellValue(i, "prc_trsp_mod_cd") != null && sheetObj.CellValue(i, "prc_trsp_mod_cd") != "") {
                	sStr += "(" + arrTransMode[sheetObj.CellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                sStr += "\n";
            }
            document.form.origin_desc.value = sStr;
        }
    }
    
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var sStr = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                sStr += sheetObj.CellValue(i, "rout_via_port_def_nm");
                sStr += "\n";
            }
            document.form.ovia_desc.value = sStr;
        }
    }
    
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var sStr = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                sStr += sheetObj.CellValue(i, "rout_via_port_def_nm");
                sStr += "\n";
            }
            document.form.dvia_desc.value = sStr;
        }
    }
    
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var sStr = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                sStr += sheetObj.CellValue(i, "rout_pnt_loc_def_nm");
                if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
                	sStr += "(" + arrTermDest[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
                }
                if (sheetObj.CellValue(i, "prc_trsp_mod_cd") != null && sheetObj.CellValue(i, "prc_trsp_mod_cd") != "") {
                	sStr += "(" + arrTransMode[sheetObj.CellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                sStr += "\n";
            }
            document.form.dest_desc.value = sStr;
        }
    }
    
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.20
	 */
    function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	if (sheetObj.RowCount > 300) {
        		sheetObj.SpeedDown2Excel();
        	} else {
        		sheetObj.Down2Excel();
        	}
        	sheetObj.RemoveAll();
        }
    }
    
	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        if (colName == "prc_cmdt_def_cd") {
            var sUrl = "/hanjin/ESM_PRI_0106.do?svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value + "&prc_cust_tp_cd=" + getPrcCustTpCd() + "&cmdt_hdr_seq=" + formObj.cmdt_hdr_seq.value + "&isEditable=" + enableFlag;
            
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0106", 700, 260, true);
            
            if (rtnVal == "O") {
                var prevStatus = sheetObj.RowStatus(Row);
                var sCd = "";
                var sNm = "";
                
                for (var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].LastRow; i++) {
                    if (sheetObjects[3].CellValue(i, "svc_scp_cd") == formObj.svc_scp_cd.value
                            && sheetObjects[3].CellValue(i, "gline_seq") == formObj.gline_seq.value
                            && sheetObjects[3].CellValue(i, "prc_cust_tp_cd") == getPrcCustTpCd()
                            && sheetObjects[3].CellValue(i, "cmdt_hdr_seq") == formObj.cmdt_hdr_seq.value) {
                        if (sheetObjects[3].RowStatus(i) == "D") {
                            continue;
                        }
                        sCd += sheetObjects[3].CellValue(i, "prc_cmdt_def_cd");
                        sNm += sheetObjects[3].CellValue(i, "prc_cmdt_def_nm");
                        sCd += " / ";
                        sNm += " / ";
                    }
                }
                
                if (sCd != "") {
                	var lastIdx = sCd.lastIndexOf("/");
                	sCd = sCd.substring(0, lastIdx - 1);
                }
                if (sNm != "") {
                	var lastIdx = sNm.lastIndexOf("/");
                	sNm = sNm.substring(0, lastIdx - 1);
                }
                
                sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = sNm;
                sheetObj.CellValue(Row, "prc_cmdt_def_cd") = sCd;              
                
                sheetObj.RowStatus(Row) = prevStatus;
            }
        }
        if (colName == "eff_dt") {
            var cal = new ComCalendarGrid();
            cal.select(sheetObj, sheetObj.SelectRow, "eff_dt", 'yyyyMMdd');
        }
        if (colName == "exp_dt") {
            var cal = new ComCalendarGrid();
            cal.select(sheetObj, sheetObj.SelectRow, "exp_dt", 'yyyyMMdd');
        }
    }
    
	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        if (!LoadingComplete) {
            return;
        }
        
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        var sUrl = "/hanjin/ESM_PRI_0021.do?";
        var keyParam = "svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value + "&prc_cust_tp_cd=" + getPrcCustTpCd() + "&cmdt_hdr_seq=" + formObj.cmdt_hdr_seq.value + "&rout_seq=" + formObj.rout_seq.value + "&isEditable=" + enableFlag;
        sUrl += keyParam;

        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0021", 700, 320, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0021", 700, 320, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0021", 700, 320, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0021", 700, 320, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "note_clss_nm") {
            sUrl = "/hanjin/ESM_PRI_0104.do?";
            sUrl += keyParam;
            var rtnVal = ComPriOpenWindowCenter(sUrl, window, 600, 310, true);
            
            if (rtnVal == "O") {
                var prevStatus = sheetObj.RowStatus(Row);
                var sNm = "";
                
                for (var i = sheetObjects[8].HeaderRows; i <= sheetObjects[8].LastRow; i++) {
                    if (sheetObjects[8].RowStatus(i) == "D") {
                        continue;
                    }
                    var clssNm = arrNoteClass[sheetObjects[8].CellValue(i, "note_clss_cd")];
    	            if (sNm.indexOf(clssNm) < 0) {
        	            sNm += clssNm;
        	            sNm += ", ";
    	            }
                }
                if (sNm != "") {
                	var lastIdx = sNm.lastIndexOf(",");
                	sNm = sNm.substring(0, lastIdx);
                }
                
                sheetObj.CellValue2(Row, "note_clss_nm") = sNm;
                
                makeNoteTooltip(sheetObj, Row);
                
                sheetObj.RowStatus(Row) = prevStatus;
            }
        }
    }
    
	/**
	 * 팝업화면에서 변경된 내용을 Sheet2에 반영한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheet2RowData(sheetObj, Row, Col) {
        var formObj = document.form;
        var prevStatus = sheetObj.RowStatus(Row);
        
        if (sheetObjects[4].IsDataModified) {
            var sCd = "";
            for (var i = sheetObjects[4].HeaderRows; i <= sheetObjects[4].LastRow; i++) {
                if (sheetObjects[4].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[4].CellValue(i, "rout_pnt_loc_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(",");
            	sCd = sCd.substring(0, lastIdx);
            }
            
            sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = sCd;
        }
        
        if (sheetObjects[5].IsDataModified) {
            var sCd = "";
            for (var i = sheetObjects[5].HeaderRows; i <= sheetObjects[5].LastRow; i++) {
                if (sheetObjects[5].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[5].CellValue(i, "rout_via_port_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(",");
            	sCd = sCd.substring(0, lastIdx);
            }
            
            sheetObj.CellValue2(Row, "org_rout_via_port_def_cd") = sCd;
        }
        
        if (sheetObjects[6].IsDataModified) {
            var sCd = "";
            for (var i = sheetObjects[6].HeaderRows; i <= sheetObjects[6].LastRow; i++) {
                if (sheetObjects[6].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[6].CellValue(i, "rout_via_port_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(",");
            	sCd = sCd.substring(0, lastIdx);
            }
            
            sheetObj.CellValue2(Row, "dest_rout_via_port_def_cd") = sCd;
        }
        
        if (sheetObjects[7].IsDataModified) {
            var sCd = "";
            for (var i = sheetObjects[7].HeaderRows; i <= sheetObjects[7].LastRow; i++) {
                if (sheetObjects[7].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[7].CellValue(i, "rout_pnt_loc_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(",");
            	sCd = sCd.substring(0, lastIdx);
            }
            
            sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = sCd;
        }
        
        sheetObj.RowStatus(Row) = prevStatus;
    }
    
	/**
	 * Note의 내용을 이용하여 Tooltip에 표시할 내용을 만들어준다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetIdx 필수 Sheet번호
	 * @param {int} Row 필수 해당 셀의 Row Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function makeNoteTooltip(sheetObj, Row) {
    	var formObj = document.form;
    	
        var sTooltip = "";
        
        for (var i = sheetObjects[8].HeaderRows; i <= sheetObjects[8].LastRow; i++) {
            if (sheetObjects[8].RowStatus(i) == "D") {
                continue;
            }
            sTooltip += "<" + arrNoteClass[sheetObjects[8].CellValue(i, "note_clss_cd")] + ">\n";
            sTooltip += "<" + sheetObjects[8].CellValue(i, "note_ctnt") + ">\n\n";
        }
        sheetObj.CellValue2(Row, "note_tooltip") = sTooltip;
        
        setRNoteTooltip(Row);
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj = document.form;
    
        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetObjects[0].IsDataModified || sheetObjects[3].IsDataModified) {
            	isFiredNested = true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                if (validateForm(sheetObjects[0], document.form, IBSAVE)) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                	isFiredNested = true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested = false;
                	}
                } else {
                	isFiredNested = true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                    return -1;
                }
            }
            
            if (sheetObjects[1].IsDataModified
                    || sheetObjects[2].IsDataModified
                    || sheetObjects[4].IsDataModified
                    || sheetObjects[5].IsDataModified
                    || sheetObjects[6].IsDataModified
                    || sheetObjects[7].IsDataModified
                    || sheetObjects[8].IsDataModified) {
                isFiredNested = true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                var rslt = false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    var rslt = doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
                    supressConfirm = false;
                }
                if (rslt) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested = true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested = false;
                	}
                } else {
                    isFiredNested = true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                	return -1;
                }
            }
    
            if (sAction == IBINSERT) {
                isFiredNested = true;
                var idx = sheetObjects[0].DataInsert();
                isFiredNested = false;
                return idx;
            } else if (sAction == IBCOPYROW) {
                isFiredNested = true;
                var idx = sheetObjects[0].DataCopy();
                isFiredNested = false;
                return idx;
            } else {
                formObj.cmdt_hdr_seq.value = sheetObjects[0].CellValue(NewRow, "cmdt_hdr_seq");
                
                doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
            }
        }
    }
    
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doRowChange2(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj = document.form;
        var adjNewRow = NewRow;
    
        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D"
            	&& (sheetObjects[1].IsDataModified
                    || sheetObjects[2].IsDataModified
                    || sheetObjects[4].IsDataModified
                    || sheetObjects[5].IsDataModified
                    || sheetObjects[6].IsDataModified
                    || sheetObjects[7].IsDataModified
                    || sheetObjects[8].IsDataModified)) {
                isFiredNested = true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                var rslt = false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    adjNewRow = Math.max(NewRow - sheetObjects[1].RowCount("D"), sheetObjects[1].HeaderRows);
                    rslt = doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
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
                LoadingComplete = false;
                formObj.rout_seq.value = sheetObjects[1].CellValue(adjNewRow, "rout_seq");
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
                LoadingComplete = true;
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
		 
			sheetObj.ShowDebugMsg = false;
	        switch (sAction) {
	        case IBSEARCH_ASYNC01: // 화면조회시 Customer Type 재조회
	        	var prevChecked = getPrcCustTpChecked();
	        	
	            formObj.f_cmd.value = SEARCH20;
	            var sXml = sheetObj.GetSearchXml("ESM_PRI_0001_06GS.do" , FormQueryString(formObj));
	            var arrData = ComPriXml2Array(sXml, "cd|nm|rate_cnt");
	            
	            var sHTML = "";
	            var firstMatch = -1;
	            for (var i = 0; i < arrData.length; i++) {
	                sHTML += "<input name='prc_cust_tp_cd' value='" + arrData[i][0] + "' type='radio' class='trans'";
	                // 해당 customer type에 입력된 rate가 존재한다면 bold처리한다.
	                if (parseInt(arrData[i][2]) > 0) {
	                    // 값이 있는 첫번째 항목으로 이동하기 위해 값 세팅.
	                	if (firstMatch < 0) {
	                        firstMatch = i;
	                    }
	                    sHTML += "><b>" + arrData[i][1] + "</b>&nbsp;&nbsp;&nbsp;&nbsp;";
	                } else {
	                    sHTML += ">" + arrData[i][1] + "&nbsp;&nbsp;&nbsp;&nbsp;";
	                }
	            }
	            
	            rdoCustTp.innerHTML = sHTML;
	            
	            // 이전에 선택되어 있던 radio로 이동한다.
	            if (prevChecked != null && prevChecked != undefined && prevChecked >= 0 && parseInt(arrData[prevChecked][2]) > 0) {
	            	formObj.prc_cust_tp_cd[prevChecked].checked = true;
	            // 최초 조회시 가장 처음 데이터가 존재하는 radio로 이동한다.
	            } else if (firstMatch >= 0) {
	            	formObj.prc_cust_tp_cd[firstMatch].checked = true;
	            // 위 두가지 케이스가 아닌경우, 첫번째로 이동.
	            } else {
	            	formObj.prc_cust_tp_cd[0].checked = true;
	            }
	            
	            break;
	            
	        case IBSEARCH_ASYNC20: // PRI_SVC_SCP_PPT_MAPG 조회
	            var sXml = ""; 
	            
	            isOViaMandatory = false;
	            isDViaMandatory = false;
	            isDirCallVisible = false;
				
				formObj.f_cmd.value = COMMAND17;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
				arrTemp = ComPriXml2Array(sXml, "cd|nm");
				if (arrTemp != null && arrTemp.length > 0) {
					for (var i = 0; i < arrTemp.length; i++) {
						var pptCd = arrTemp[i][1];
						// S/C O.Via mandatory
						if (pptCd == "SOVA") {
							isOViaMandatory = true;
						// S/C D.Via mandatory
						} else if (pptCd == "SDVA") {
							isDViaMandatory = true;
						// S/C D.Call 사용여부.
						} else if (pptCd == "SDRC") {
							isDirCallVisible = true;
						}
					}
				}
				
	            break;
	            
	        case IBSEARCH: // 조회
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI08001');
	                return false;
	            }
	            
	            if (sheetObj.id == "sheet1") {
	                for (var i = 0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                formObj.f_cmd.value = SEARCH01;
	                var sXml = sheetObj.GetSearchXml("ESM_PRI_0001_06GS.do" , FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);    // Grid1.
	                if (arrXml.length > 1) sheetObjects[3].LoadSearchXml(arrXml[1]);    // Hidden. Grid1의 Commodity
	                
	            } else if (sheetObj.id == "sheet2") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    if (i == 3) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                formObj.f_cmd.value = SEARCH02;
	                var sXml = sheetObj.DoSearch("ESM_PRI_0001_06GS.do" , FormQueryString(formObj));
	                
	                setRNoteTooltip(-1);
	            } else if (sheetObj.id == "sheet3") {
	                for (var i = 2; i < sheetObjects.length; i++) {
	                    if (i == 3) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                formObj.f_cmd.value = SEARCH03;
	                var sXml = sheetObj.GetSearchXml("ESM_PRI_0001_06GS.do" , FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                if (arrXml.length > 0) sheetObjects[2].LoadSearchXml(arrXml[0]);    // Grid3.
	                if (arrXml.length > 1) sheetObjects[4].LoadSearchXml(arrXml[1]);    // Hidden. Grid2의 Origin Point.
	                if (arrXml.length > 2) sheetObjects[5].LoadSearchXml(arrXml[2]);    // Hidden. Grid2의 Origin Via.
	                if (arrXml.length > 3) sheetObjects[6].LoadSearchXml(arrXml[3]);    // Hidden. Grid2의 Destination Via.
	                if (arrXml.length > 4) sheetObjects[7].LoadSearchXml(arrXml[4]);    // Hidden. Grid2의 Destination Point.
	                if (arrXml.length > 5) sheetObjects[8].LoadSearchXml(arrXml[5]);    // Hidden. Grid2의 Rnote.
	                
	                setRateMinMax(-1);
	            }
	            break;
	    
	        case IBSAVE: // 저장
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            if (sheetObj.id == "sheet1") {
	                formObj.f_cmd.value = MULTI01;
	                var sParam = FormQueryString(formObj);
	                var sParamSheet1 = sheetObjects[0].GetSaveString();
	                if (sParamSheet1 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	                }
	                var sParamSheet4 = sheetObjects[3].GetSaveString();
	                if (sParamSheet4 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet4, "sheet4_");
	                }
	        
	                if (!supressConfirm && !ComPriConfirmSave()) {
	                    return false;
	                }
	        
	                var sXml = sheetObj.GetSaveXml("ESM_PRI_0001_06GS.do", sParam);
	                sheetObjects[3].LoadSaveXml(sXml);
	                sheetObjects[0].LoadSaveXml(sXml);
	                
	                if (sheetObjects[0].IsDataModified || sheetObjects[3].IsDataModified) {
	                    return false;
	                } else {
						if (getValidRowCount(sheetObjects[1]) <= 0) {
							doRowChange1(-1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, IBSEARCH);
						}
						
						parent.setTabStyle();
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	                    ComPriSaveCompleted();
	                    return true;
	                }
	            } else if (sheetObj.id == "sheet3") {
	                formObj.f_cmd.value = MULTI02;
	                var sParam = FormQueryString(formObj);
	                var sParamSheet2 = sheetObjects[1].GetSaveString();
	                if (sParamSheet2 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	                }
	                var sParamSheet3 = sheetObjects[2].GetSaveString();
	                if (sParamSheet3 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
	                }
	                var sParamSheet5 = sheetObjects[4].GetSaveString();
	                if (sParamSheet5 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet5_");
	                }
	                var sParamSheet6 = sheetObjects[5].GetSaveString();
	                if (sParamSheet6 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet6, "sheet6_");
	                }
	                var sParamSheet7 = sheetObjects[6].GetSaveString();
	                if (sParamSheet7 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet7_");
	                }
	                var sParamSheet8 = sheetObjects[7].GetSaveString();
	                if (sParamSheet8 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet8_");
	                }
	                var sParamSheet9 = sheetObjects[8].GetSaveString();
	                if (sParamSheet9 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet9, "sheet9_");
	                }
	        
	                if (!supressConfirm && !ComPriConfirmSave()) {
	                    return false;
	                }
	        
	                var sXml = sheetObj.GetSaveXml("ESM_PRI_0001_06GS.do", sParam);
	                sheetObjects[8].LoadSaveXml(sXml);
	                sheetObjects[7].LoadSaveXml(sXml);
	                sheetObjects[6].LoadSaveXml(sXml);
	                sheetObjects[5].LoadSaveXml(sXml);
	                sheetObjects[4].LoadSaveXml(sXml);
	                sheetObjects[2].LoadSaveXml(sXml);
	                sheetObjects[1].LoadSaveXml(sXml);
	                
	                if (sheetObjects[1].IsDataModified
	                        || sheetObjects[2].IsDataModified
	                        || sheetObjects[4].IsDataModified
	                        || sheetObjects[5].IsDataModified
	                        || sheetObjects[6].IsDataModified
	                        || sheetObjects[7].IsDataModified
	                        || sheetObjects[8].IsDataModified) {
	                    return false;
	                } else {
						if (getValidRowCount(sheetObjects[2]) <= 0) {
							doRowChange2(-1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, IBSEARCH);
						}
						
						parent.setTabStyle();
	                    ComPriSaveCompleted();
	                    return true;
	                }
	            }
	            return true;
	            break;
	    
	        case IBDOWNEXCEL:
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI08001');
	                return false;
	            }
	            
	            formObj.f_cmd.value = SEARCH10;
	            sheetObj.DoSearch("ESM_PRI_0001_06GS.do", FormQueryString(formObj));
	            break;
	    
	        case IBINSERT: // Row Add
	            if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (sheetObj.id == "sheet1") {
	                var idx = doRowChange1(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
	                if (idx < 0) {
	                    return false;
	                }
	                
	                sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
	                sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
	                sheetObj.CellValue(idx, "prc_cust_tp_cd") = getPrcCustTpCd();
	                sheetObj.CellValue(idx, "cmdt_hdr_seq") = parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1;
	                sheetObj.CellValue(idx, "eff_dt") = parent.getEffDt();
	                sheetObj.CellValue(idx, "exp_dt") = parent.getExpDt();
	                
	                sheetObjects[1].RemoveAll();
	                sheetObjects[2].RemoveAll();
	                sheetObjects[4].RemoveAll();
	                sheetObjects[5].RemoveAll();
	                sheetObjects[6].RemoveAll();
	                sheetObjects[7].RemoveAll();
	                sheetObjects[8].RemoveAll();
	                
	                formObj.cmdt_hdr_seq.value = sheetObj.CellValue(idx, "cmdt_hdr_seq");
	                formObj.origin_desc.value = "";
	                formObj.ovia_desc.value = "";
	                formObj.dvia_desc.value = "";
	                formObj.dest_desc.value = "";
	                
	                sheet1_OnPopupClick(sheetObj, idx, 7);
	                
	            }
	            if (sheetObj.id == "sheet2") {
	                var idx = doRowChange2(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
	                if (idx < 0) {
	                    return false;
	                }
	                
	                sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
	                sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
	                sheetObj.CellValue(idx, "prc_cust_tp_cd") = getPrcCustTpCd();
	                sheetObj.CellValue(idx, "cmdt_hdr_seq") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq");
	                sheetObj.CellValue(idx, "rout_seq") = parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
	                
	                setRNoteTooltip(idx);
	                
	                sheetObjects[2].RemoveAll();
	                sheetObjects[4].RemoveAll();
	                sheetObjects[5].RemoveAll();
	                sheetObjects[6].RemoveAll();
	                sheetObjects[7].RemoveAll();
	                sheetObjects[8].RemoveAll();
	                
	                formObj.rout_seq.value = sheetObj.CellValue(idx, "rout_seq");
	                formObj.origin_desc.value = "";
	                formObj.ovia_desc.value = "";
	                formObj.dvia_desc.value = "";
	                formObj.dest_desc.value = "";
	                
	                // Route에서 Row Add시 MQC에 설정되어 있던 값을 조회해서 Default 입력해 줌.
	                formObj.f_cmd.value = SEARCH;
	                sheetObjects[2].DoSearch("ESM_PRI_0030GS.do", FormQueryString(formObj));
	                for (var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow && sheetObjects[2].RowCount > 0; i++) {
	                    sheetObjects[2].CellValue(i, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
	                    sheetObjects[2].CellValue(i, "rout_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "rout_seq");
	                    sheetObjects[2].CellValue(i, "rt_seq") = i;
	                    sheetObjects[2].CellValue(i, "frt_rt_amt") = 0.00;
	                    sheetObjects[2].CellValue(i, "prc_cgo_tp_cd") = "";
	                    sheetObjects[2].CellValue(i, "curr_cd") = "USD";
	                    sheetObjects[2].RowStatus(i) = "I";
	                }
	                
	                sheet2_OnPopupClick(sheetObj, idx, 8);
	            }
	            if (sheetObj.id == "sheet3") {
	            	var bAddRow = false;
	            	var rowCnt = getValidRowCount(sheetObj);
	            	
	            	// Rate그리드 Row Add시에도, 기존에 입력된 행이 없다면(첫번째 Row Add시에만..) MQC에 있는 항목을 가져와 세팅해준다.
	            	if (rowCnt == 0) {
	                    formObj.f_cmd.value = SEARCH;
	                    var sXml = sheetObj.GetSearchXml("ESM_PRI_0030GS.do", FormQueryString(formObj));
	                    ComPriXml2Sheet(sheetObj, sXml, 2);
	                    
	                    sheetObj.SelectCell(1, "mqc_rng_fm_qty", false);
	                    
	                    if (getValidRowCount(sheetObj) > 0) {
		                    for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow && sheetObj.RowCount > 0; i++) {
		                    	if (sheetObj.RowStatus(i) == "D") {
		                    		continue;
		                    	}
		                    	sheetObj.CellValue(i, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
		                    	sheetObj.CellValue(i, "rout_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "rout_seq");
		                    	sheetObj.CellValue(i, "rt_seq") = i;
		                    	sheetObj.CellValue(i, "frt_rt_amt") = 0.00;
		                    	sheetObj.CellValue(i, "prc_cgo_tp_cd") = "";
		                    	sheetObj.CellValue(i, "curr_cd") = "USD";
		                    	sheetObj.RowStatus(i) = "I";
		                    }
	                    } else {
	                    	bAddRow = true;
	                    }
	            	}
	            	
	            	if (bAddRow || rowCnt > 0) {
		                var idx = sheetObj.DataInsert();
		                
		                sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
		                sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
		                sheetObj.CellValue(idx, "prc_cust_tp_cd") = getPrcCustTpCd();
		                sheetObj.CellValue(idx, "cmdt_hdr_seq") = formObj.cmdt_hdr_seq.value;
		                sheetObj.CellValue(idx, "rout_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "rout_seq");
		                sheetObj.CellValue(idx, "rt_seq") = parseInt(ComPriGetMax(sheetObj, "rt_seq")) + 1;
		                
		                var cnt = getValidRowCount(sheetObj);
		                
		                if (cnt == 1) {
		                    sheetObj.CellValue(idx, "mqc_rng_fm_qty") = 1;
	                        sheetObj.CellValue(idx, "rat_ut_cd") = "";
	                        sheetObj.CellValue(idx, "prc_cgo_tp_cd") = "";
		                } else {
		                    var prevIdx = getPrevValidRow(sheetObj, idx);
		                    if (prevIdx > 0) {
		                        if (sheetObj.CellValue(prevIdx, "mqc_rng_to_qty") != "") {
		                            sheetObj.CellValue(idx, "mqc_rng_fm_qty") = parseInt(sheetObj.CellValue(prevIdx, "mqc_rng_to_qty")) + 1;
		                        }
		                        sheetObj.CellValue(idx, "rat_ut_cd") = sheetObj.CellValue(prevIdx, "rat_ut_cd");
		                        sheetObj.CellValue(idx, "prc_cgo_tp_cd") = "";
		                    } else {
		                        sheetObj.CellValue(idx, "rat_ut_cd") = "";
		                        sheetObj.CellValue(idx, "prc_cgo_tp_cd") = "";
		                    }
		                }
		                sheetObj.CellValue(idx, "frt_rt_amt") = 0.00;
		                
		                setRateMinMax(idx);
		                
		                sheetObj.SelectCell(idx, "mqc_rng_fm_qty", false);
	            	}
	            }
	            break;
	            
	        case IBCOPYROW: // Row Add
	            if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (sheetObj.id == "sheet1") {
	                var prevCmdtHdrSeq = sheetObj.CellValue(sheetObj.SelectRow, "cmdt_hdr_seq");
	                
	                var idx = doRowChange1(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
	                if (idx < 0) {
	                    return false;
	                }
	                
	                var newCmdtHdrSeq = parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1;
	                
	                sheetObj.CellValue(idx, "cmdt_hdr_seq") = newCmdtHdrSeq;
	                
	                formObj.cmdt_hdr_seq.value = sheetObj.CellValue(idx, "cmdt_hdr_seq");
	                
	                //sheetObjects[3] copy
	                for (var i = sheetObjects[3].LastRow; i >= sheetObjects[3].HeaderRows; i--) {
	                    if (sheetObjects[3].CellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
	                        sheetObjects[3].SelectCell(i, 0);
	                        var insIdx = sheetObjects[3].DataCopy();
	                        sheetObjects[3].CellValue(insIdx, "cmdt_hdr_seq") = newCmdtHdrSeq;
	                    }
	                }
	                
	                formObj.origin_desc.value = "";
	                formObj.ovia_desc.value = "";
	                formObj.dvia_desc.value = "";
	                formObj.dest_desc.value = "";
	                
	                for (var i = 1; i < sheetObjects.length; i++) {
	                	if (i == 3) {
	                		continue;
	                	}
	                	sheetObjects[i].RemoveAll();
	                }
	            }
	            if (sheetObj.id == "sheet2") {
	                var prevRoutSeq = sheetObj.CellValue(sheetObj.SelectRow, "rout_seq");
	                
	                var idx = doRowChange2(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
	                if (idx < 0) {
	                    return false;
	                }
	                
	                var newRoutSeq = parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
	                sheetObj.CellValue(idx, "rout_seq") = newRoutSeq;
	                
	                formObj.rout_seq.value = sheetObj.CellValue(idx, "rout_seq");
	                
	                //sheetObjects[4,5,6,7,8] copy
	                for (var a = 4; a <= 8; a++) {
	                	if (sheetObjects[a].RowCount <= 0) {
	                		continue;
	                	}
	                    for (var i = sheetObjects[a].HeaderRows; i <= sheetObjects[a].LastRow; i++) {
	                        var colName = "";
	                        if (a == 4 || a == 7) {
	                            colName = "rout_pnt_seq";
	                        } else if (a == 5 || a == 6) {
	                            colName = "rout_via_seq";
	                        } else if (a == 8) {
	                            colName = "rout_note_seq";
	                        }
	                        sheetObjects[a].CellValue(i, "rout_seq") = newRoutSeq;
	                        sheetObjects[a].CellValue(i, colName) = i;
	                        sheetObjects[a].RowStatus(i) = "I";
	                    }
	                }
	                
	                for (var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow && sheetObjects[2].RowCount > 0; i++) {
	                    sheetObjects[2].CellValue(i, "rout_seq") = newRoutSeq;
	                    sheetObjects[2].CellValue(i, "rt_seq") = i;
	                    sheetObjects[2].RowStatus(i) = "I";
	                }
	                
	                setRNoteTooltip(idx);
	            }
	            break;
	            
	        case IBDELETE: // Delete
	            if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	        	
	    		var sCheckedRows = sheetObj.FindCheckedRow("chk");
	    		var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	            
				if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                	if (i == 3) {
	                		continue;
	                	}
	                    sheetObjects[i].RemoveAll();
	                }
				}
				if (sheetObj.id == "sheet2" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
	                for (var i = 2; i < sheetObjects.length; i++) {
	                	if (i == 3) {
	                		continue;
	                	}
	                    sheetObjects[i].RemoveAll();
	                }
				}
	            
	            var delCnt = deleteRowCheck(sheetObj, "chk");
	            
	            if (delCnt > 0 && sheetObj.id == "sheet1") {
	            	for (var i = sheetObjects[3].LastRow; sheetObjects[3].RowCount > 0 && i >= sheetObjects[3].HeaderRows; i--) {
	        			var curCmdtHdrSeq = sheetObjects[3].CellValue(i, "cmdt_hdr_seq");
	        			for (var k = 0; k < arrCheckedRows.length; k++) {
	        				if (sheetObj.CellValue(arrCheckedRows[k], "cmdt_hdr_seq") == curCmdtHdrSeq) {
	        					sheetObjects[3].RowDelete(i, false);
	        					continue;
	        				}
	        			}
	            	}
	            }
	
	//            if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
	//                for (var i = sheetObjects[3].LastRow; i >= sheetObjects[3].HeaderRows; i--) {
	//                    if (sheetObjects[3].CellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
	//                        sheetObjects[3].RowDelete(i, false);
	//                    }
	//                }
	//                for (var i = 1; i < sheetObjects.length; i++) {
	//                	if (i == 3) {
	//                		continue;
	//                	}
	//                    sheetObjects[i].RemoveAll();
	//                }
	//                
	//                formObj.origin_desc.value = "";
	//                formObj.ovia_desc.value = "";
	//                formObj.dvia_desc.value = "";
	//                formObj.dest_desc.value = "";
	//            }
	//            if (delCnt > 0 && sheetObj.id == "sheet2" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
	//                for (var i = 2; i < sheetObjects.length; i++) {
	//                	if (i == 3) {
	//                		continue;
	//                	}
	//                    sheetObjects[i].RemoveAll();
	//                }
	//                
	//                formObj.origin_desc.value = "";
	//                formObj.ovia_desc.value = "";
	//                formObj.dvia_desc.value = "";
	//                formObj.dest_desc.value = "";
	//            }
	            break;
	    
	        }
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
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH: // 조회
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            } else {
                return true;
            }
            break;
    
        case IBSAVE: // 저장
            if (sheetObj.id == "sheet1") {
                if (!sheetObjects[0].IsDataModified && !sheetObjects[3].IsDataModified) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                if (sheetObjects[0].IsDataModified
                        && sheetObjects[0].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[3].IsDataModified
                        && sheetObjects[3].GetSaveString() == "") {
                    return false;
                }
                
                for (var i = sheetObjects[0].HeaderRows; sheetObjects[0].RowCount > 0 && i <= sheetObjects[0].LastRow; i++) {
                	if (sheetObjects[0].RowStatus(i) == "D") {
                		continue;
                	}
                	
                	if (sheetObjects[0].CellValue(i, "prc_cmdt_def_cd") == "") {
                		sheetObjects[0].SelectCell(i, "prc_cmdt_def_cd", false);
                        ComShowCodeMessage("PRI00316", "Commodity Code");
                        return false;
                	}
                }
                
                var effDt = parent.getEffDt();
                var expDt = parent.getExpDt();
                
                for (var i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
                    var lEffDt = sheetObjects[0].CellValue(i, "eff_dt");
                    var lExpDt = sheetObjects[0].CellValue(i, "exp_dt");
                    if (lEffDt > lExpDt) {
                        ComShowCodeMessage("PRI00306");
                        return false;
                    }
                    if (lEffDt < effDt) {
                        ComShowCodeMessage("PRI08016");
                        return false;
                    }
                    if (lExpDt > expDt) {
                        ComShowCodeMessage("PRI08016");
                        return false;
                    }
                }
                
            } else if (sheetObj.id == "sheet3") {
                if (!sheetObjects[1].IsDataModified
                        && !sheetObjects[2].IsDataModified
                        && !sheetObjects[4].IsDataModified
                        && !sheetObjects[5].IsDataModified
                        && !sheetObjects[6].IsDataModified
                        && !sheetObjects[7].IsDataModified
                        && !sheetObjects[8].IsDataModified) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                
                if (sheetObjects[0].IsDataModified || sheetObjects[3].IsDataModified) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
                    return false;
                }
                
    			if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D"
    				&& getValidRowCount(sheetObjects[2]) <= 0) {
    				ComShowCodeMessage("PRI01125");
    				return false;
    			}
                
                if (sheetObjects[1].IsDataModified
                        && sheetObjects[1].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[2].IsDataModified
                        && sheetObjects[2].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[4].IsDataModified
                        && sheetObjects[4].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[5].IsDataModified
                        && sheetObjects[5].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[6].IsDataModified
                        && sheetObjects[6].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[7].IsDataModified
                        && sheetObjects[7].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[8].IsDataModified
                        && sheetObjects[8].GetSaveString() == "") {
                    return false;
                }
                
                // Route Point들 Mandatory check.
                for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
                	if (sheetObjects[1].RowStatus(i) == "D") {
                		continue;
                	}
                	
                	if (sheetObjects[1].CellValue(i, "org_rout_pnt_loc_def_cd") == "") {
                    	sheetObj.SelectCell(i, "org_rout_pnt_loc_def_cd", false);
                        ComShowCodeMessage("PRI00316", "Origin");
                        return false;
                	}
                	if (sheetObjects[1].CellValue(i, "org_rout_via_port_def_cd") == "" && isOViaMandatory) {
                    	sheetObj.SelectCell(i, "org_rout_via_port_def_cd", false);
                        ComShowCodeMessage("PRI00316", "O.Via");
                        return false;
                	}
                	if (sheetObjects[1].CellValue(i, "dest_rout_via_port_def_cd") == ""&& isDViaMandatory) {
                    	sheetObj.SelectCell(i, "dest_rout_via_port_def_cd", false);
                        ComShowCodeMessage("PRI00316", "D.Via");
                        return false;
                	}
                	if (sheetObjects[1].CellValue(i, "dest_rout_pnt_loc_def_cd") == "") {
                    	sheetObj.SelectCell(i, "dest_rout_pnt_loc_def_cd", false);
                        ComShowCodeMessage("PRI00316", "Dest.");
                        return false;
                	}
                }
                
                //Sheet3 Amount 및 MQC Min-Max 점검
                for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
                    if (parseInt(sheetObj.CellValue(i, "mqc_rng_fm_qty")) > parseInt(sheetObj.CellValue(i, "mqc_rng_to_qty"))) {
                    	sheetObj.SelectCell(i, "mqc_rng_fm_qty", false);
                        ComShowCodeMessage("PRI08008");
                        return false;
                    }
                    
                    var validNextRow = getNextValidRowCond(sheetObj, i, "rat_ut_cd", sheetObj.CellValue(i, "rat_ut_cd"));
                    if (validNextRow > 0 && parseInt(sheetObj.CellValue(i, "mqc_rng_to_qty")) != parseInt(sheetObj.CellValue(validNextRow, "mqc_rng_fm_qty")) - 1) {
                    	sheetObj.SelectCell(i, "mqc_rng_to_qty", false);
                        ComShowCodeMessage("PRI08009");
                        return false;
                    }
                    
                    if (sheetObj.CellValue(i, "frt_rt_amt") <= 0.00) {
                    	sheetObj.SelectCell(i, "frt_rt_amt", false);
                        ComShowCodeMessage("PRI00321", "Rate", "0.00");
                        return false;
                    }
                }
                
            }

            return true;
            break;
    
        case IBDOWNEXCEL: // 엑셀조회
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            } else {
                return true;
            }
            break;
    
        case IBINSERT: // Row Add
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            }
            if (sheetObj.id == "sheet2") {
                if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0) {
                    return false;
                }
            } else if (sheetObj.id == "sheet3") {
                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
                    return false;
                }
            }
            
            return true;
            break;
            
        case IBCOPYROW: // Row Add
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            }
            if (sheetObj.RowCount <= 0 || sheetObj.SelectRow <= 0) {
                return false;
            }
            
            return true;
            break;
    
        case IBDELETE: // Delete
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        }
    }
    
    function getPrcCustTpCd() {
        for (var i = 0; i < document.form.prc_cust_tp_cd.length; i++) {
            if (document.form.prc_cust_tp_cd[i].checked) {
                return document.form.prc_cust_tp_cd[i].value;
            }
        }
    }
    
    function getPrcCustTpChecked() {
        for (var i = 0; i < document.form.prc_cust_tp_cd.length; i++) {
            if (document.form.prc_cust_tp_cd[i].checked) {
                return i;
            }
        }
    }
    
    function setRNoteTooltip(idx) {
        if (idx == null || idx < 0) {
            for (var i = sheetObjects[1].HeaderRows; i <= sheetObjects[1].LastRow; i++) {
                sheetObjects[1].ToolTipText(i, "note_clss_nm") = sheetObjects[1].CellValue(i, "note_tooltip");
            }
        } else {
            sheetObjects[1].ToolTipText(idx, "note_clss_nm") = sheetObjects[1].CellValue(idx, "note_tooltip");
        }
    }
    
    function setRateMinMax(idx) {
        if (idx == null || idx < 0) {
            for (var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow; i++) {
                sheetObjects[2].MinimumValue(i, "frt_rt_amt") = 0.00;
            }
        } else {
            sheetObjects[2].MinimumValue(idx, "frt_rt_amt") = 0.00;
        }
    }
    
	/**
	 * Sheet Data를 XML형태로 넘겨받는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function getSheetXml(sheetNo) {
        var formObj = document.form;
        var sXml = "";
        var sCol = "";
        var sValue = "";
        
        if (sheetNo == 3) {
            sCol = "svc_scp_cd|gline_seq|prc_cust_tp_cd|cmdt_hdr_seq";
            sValue = formObj.svc_scp_cd.value + "|" + formObj.gline_seq.value + "|" + getPrcCustTpCd() + "|" + formObj.cmdt_hdr_seq.value;
        }

        sXml = ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
        
        return sXml;
    }
    
	/**
	 * Sheet Data를 XML형태로 넘겨받는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheetXml(sXml, sheetNo) {
        var formObj = document.form;
        var sCol = "";
        var sValue = "";
        var bAppendMode = 0;
        
        if (sheetNo == 3) {
            bAppendMode = 1;
            sCol = "svc_scp_cd|gline_seq|prc_cust_tp_cd|cmdt_hdr_seq";
            sValue = formObj.svc_scp_cd.value + "|" + formObj.gline_seq.value + "|" + getPrcCustTpCd() + "|" + formObj.cmdt_hdr_seq.value;
        }
        
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
    }
	 
    function reloadPagePostTr() {
    	parent.setTabStyle();
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode 필수 사용자 권한이나 모드
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function toggleButtons(mode) {
        switch (mode) {
        case "CLEAR":
            disableButton("btn_retrieve");
            disableButton("btn_downexcel");
            disableButton("btn_loadexcel");
            disableButton("btn_mqc");
            disableButton("btn_rowadd1");
            disableButton("btn_rowadd2");
            disableButton("btn_rowadd3");
            disableButton("btn_rowcopy1");
            disableButton("btn_rowcopy2");
            disableButton("btn_delete1");
            disableButton("btn_delete2");
            disableButton("btn_delete3");
            disableButton("btn_save1");
            disableButton("btn_save2");
            disableButton("btn_save3");
            
            sheetObjects[0].InitDataProperty2(0, 9, dtPopupEdit, "insert-edit=false; update-edit=false");
            sheetObjects[0].InitDataProperty2(0, 10, dtPopupEdit, "insert-edit=false; update-edit=false");
            sheetObjects[1].InitDataProperty(0, 12, dtCheckBox, 95, daCenter, false, "dir_call_flg", false, "", dfNone, 0, true, true, -1, false, true, "", false);
            sheetObjects[2].Editable = false;
            break;
        case "INIT":
            enableButton("btn_retrieve");
            enableButton("btn_downexcel");
            enableButton("btn_loadexcel");
            enableButton("btn_mqc");
            enableButton("btn_rowadd1");
            enableButton("btn_rowadd2");
            enableButton("btn_rowadd3");
            enableButton("btn_rowcopy1");
            enableButton("btn_rowcopy2");
            enableButton("btn_delete1");
            enableButton("btn_delete2");
            enableButton("btn_delete3");
            enableButton("btn_save1");
            enableButton("btn_save2");
            enableButton("btn_save3");
            
            // TPW 일 경우에만 Commodity Group의 eff_dt, exp_dt를 사용할 수 있다.
            if (enableFlag && document.form.svc_scp_cd.value == "TPW") {
            	sheetObjects[0].InitDataProperty(0, 9, dtPopupEdit, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, true, true);
            	sheetObjects[0].InitDataProperty(0, 10, dtPopupEdit, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, true, true);
            } else {
            	sheetObjects[0].InitDataProperty(0, 9, dtPopupEdit, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
            	sheetObjects[0].InitDataProperty(0, 10, dtPopupEdit, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
            }
            sheetObjects[1].InitDataProperty(0, 12, dtCheckBox, 95, daCenter, false, "dir_call_flg", false, "", dfNone, 0, true, true, -1, false, true, "", false);
            sheetObjects[2].Editable = true;
            break;
        case "READONLY":
            enableButton("btn_retrieve");
            enableButton("btn_downexcel");
            disableButton("btn_loadexcel");
            enableButton("btn_mqc");
            disableButton("btn_rowadd1");
            disableButton("btn_rowadd2");
            disableButton("btn_rowadd3");
            disableButton("btn_rowcopy1");
            disableButton("btn_rowcopy2");
            disableButton("btn_delete1");
            disableButton("btn_delete2");
            disableButton("btn_delete3");
            disableButton("btn_save1");
            disableButton("btn_save2");
            disableButton("btn_save3");
            
            sheetObjects[0].InitDataProperty2(0, 9, dtPopupEdit, "insert-edit=false; update-edit=false");
            sheetObjects[0].InitDataProperty2(0, 10, dtPopupEdit, "insert-edit=false; update-edit=false");
            sheetObjects[1].InitDataProperty(0, 12, dtCheckBox, 95, daCenter, false, "dir_call_flg", false, "", dfNone, 0, false, false, -1, false, true, "", false);
            sheetObjects[2].Editable = false;
            break;
        }
    }
    
	/**
	 * 탭안의 화면이 로드되었을때 상위에서 호출하는 함수. 초기값을 세팅하고 화면을 조회한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
        var formObject = document.form;
    	
        if (formObject.svc_scp_cd.value != sSvcScpCd
                || formObject.gline_seq.value != sGlineSeq) {
            formObject.svc_scp_cd.value = sSvcScpCd;
            formObject.gline_seq.value = sGlineSeq;
            
            doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC20);
            
            // O.Via 필수여부
            if (isOViaMandatory) {
            	sheetObjects[1].InitDataProperty(0, 9, dtPopup, 160, daLeft, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
            } else {
            	sheetObjects[1].InitDataProperty(0, 9, dtPopup, 160, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
            }
            
            // D.Via 필수여부
            if (isDViaMandatory) {
            	sheetObjects[1].InitDataProperty(0, 10, dtPopup, 160, daLeft, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
            } else {
            	sheetObjects[1].InitDataProperty(0, 10, dtPopup, 160, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
            }
            
            // Direct Call Enable
            if (isDirCallVisible) {
            	sheetObjects[1].ColHidden("dir_call_flg") = false;
            } else {
            	sheetObjects[1].ColHidden("dir_call_flg") = true;
            }
            
            if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag = true;
            } else {
            	enableFlag = false;
            }
            
            // TPW일 경우, eff_dt, exp_dt 사용가능
            if (enableFlag && formObject.svc_scp_cd.value == "TPW") {
            	sheetObjects[0].InitDataProperty(0, 9, dtPopupEdit, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, true, true);
            	sheetObjects[0].InitDataProperty(0, 10, dtPopupEdit, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, true, true);
            } else {
            	sheetObjects[0].InitDataProperty(0, 9, dtPopupEdit, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
            	sheetObjects[0].InitDataProperty(0, 10, dtPopupEdit, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
            }
            
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            
            tabEnableSheet(enableFlag);
        }
    }
    
	/**
	 * 화면의 모든 내용을 초기화하는 함수로, 상위프레임에서 호출된다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function tabClearSheet() {
        var formObject = document.form;
    
        formObject.svc_scp_cd.value = "";
        formObject.gline_seq.value = "";
        formObject.cmdt_hdr_seq.value = "";
        formObject.rout_seq.value = "";
        
        for (var i = 0; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
        
        formObject.origin_desc.value = "";
        formObject.ovia_desc.value = "";
        formObject.dvia_desc.value = "";
        formObject.dest_desc.value = "";
        
        toggleButtons("CLEAR");
    }
    
    var enableFlag = true;
    function tabEnableSheet(flag) {
        var formObject = document.form;
    
        enableFlag = flag;

        if (enableFlag) {
            toggleButtons("INIT");
        } else {
            toggleButtons("READONLY");
        }
    }

/* 개발자 작업 끝 */