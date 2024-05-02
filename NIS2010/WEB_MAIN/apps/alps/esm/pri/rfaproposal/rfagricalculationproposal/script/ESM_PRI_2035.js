/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_2035.js
 *@FileTitle : RFA Proposal Creation - Rate For IHC[GRI Calculation]
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.06
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
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
     * @class Guideline Creation : Guideline Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
     *        정의한다.
     */
    function ESM_PRI_2035() {
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
    
    var arrTermOrg = new Array();
    var arrTermDest = new Array();
    
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
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
    
            switch (srcName) {
            case "btn_rowadd1":
                doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
                break;
    
            case "btn_rowadd2":
                doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
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

            case "btn_save2":
                doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;

            case "btn_ok":
            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
                break;
    
            case "btn_cancel":
            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
                break;
                
			case "btn_close":
				window.close();
				break;
				
			case "flt_pct_tp_cd":
				setFltPctEnable();
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
        
        document.form.flt_pct_tp_cd[0].checked = true;
        
        doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
                style.height = 102;
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
                
                var HeadTitle = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|General Special Rate Type Code|GRI Group Seq.|Flat Percent Type Code|Application|GRI Application Flag|prc_cmdt_def_cd|Commodity Group|cust_seq|Actual Customer|origin|Origin|ovia|O.Via|dvia|D.Via|dest|Dest.";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gri_grp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "flt_pct_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "gri_appl_div_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gri_appl_flg", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 250, daLeft, false, "prc_cmdt_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 250, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 150, daLeft, false, "cust_seq", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 150, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daLeft, false, "org_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 100, daLeft, false, "org_rout_pnt_loc_def_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 100, daLeft, false, "org_rout_via_port_def_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 100, daLeft, false, "dest_rout_via_port_def_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daLeft, false, "dest_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 100, daLeft, false, "dest_rout_pnt_loc_def_nm", false, "", dfNone, 0, true, true);
                
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 2;
                CountFormat = "[ ]";

            }
            break;
    
        case "sheet2":  // Grid 2
            with (sheetObj) {
                // 높이 설정
                style.height = 102;
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
                InitRowInfo(1, 1, 3, 100);
                
        		var HeadTitle = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|General Special Rate Type Code|GRI Group Seq.|GRI Rate Seq.|Per|Cargo Type|Currency|GRI Amount|Percentage(%)";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gri_grp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gri_rt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtCombo,150, daCenter, false, "rat_ut_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo,150, daCenter, false, "prc_cgo_tp_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo,150, daCenter, false, "curr_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 210, daRight,  false, "gri_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 210, daRight,  false, "gri_rt_rto", false, "", dfNullFloat, 2, true, true, 5);
                
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 0;
            }
            break;
            
        case "sheet3":  // Grid 1의 Commodity Group
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
                
                var HeadTitle = "3-1|3-2|3-3|3-4|3-5|3-6|3-7|3-8|3-9|3-10";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_grp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet4":  // Grid 1의 Actual Customer
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
                
                var HeadTitle = "4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_grp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "act_cust_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_cnt_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_lgl_eng_nm", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet5":  // Grid 1의 Origin Point
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
                
                var HeadTitle = "5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_grp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
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
                
                var HeadTitle = "6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_grp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet7":  // Grid 1의 Destination Via.
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
                
                var HeadTitle = "7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_grp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet8":  // Grid 1의 Destination Point
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
                
                var HeadTitle = "8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12";
                var headCount = ComCountHeadTitle(HeadTitle);
                
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_grp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gri_rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet9":  // Grid 9
            with (sheetObj) {
                // 높이 설정
                style.height = 102;
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
                
                var HeadTitle = "|Proposal No.|Amend Seq.|Service Scope|Commodity Header Seq|Rout Seq|Rt Seq|fic_rt_use_sts_cd|blet_dp_seq";
                var headCount = ComCountHeadTitle(HeadTitle);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "fic_rt_use_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "blet_dp_seq", true, "", dfNone, 0, false, false);
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
            ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
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
            ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
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
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var colName = sheetObj.ColSaveName(Col);
        
        if (colName == "gri_appl_div_cd") {
        	if (sheetObjects[0].CellEditable(Row, "gri_appl_div_cd")) {
        		toggleButtons("INIT");
        	}
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
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
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
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(OldRow, NewRow, OldCol, NewCol, IBSEARCH);
		toggleButtons("INIT");
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
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.cmdt_desc.value = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "prc_cmdt_def_nm");
                
                sStr += "\n";
                document.form.cmdt_desc.value += sStr;
            }
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
    function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.actcust_desc.value = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "cust_lgl_eng_nm");
                
                sStr += "\n";
                document.form.actcust_desc.value += sStr;
            }
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
    function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.origin_desc.value = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_pnt_loc_def_nm");
                
                if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
                	sStr += "(" + arrTermOrg[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
                }
                
                sStr += "\n";
                document.form.origin_desc.value += sStr;
            }
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
        	document.form.ovia_desc.value = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_via_port_def_nm");
                
                sStr += "\n";
                document.form.ovia_desc.value += sStr;
            }
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
        	document.form.dvia_desc.value = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_via_port_def_nm");
                
                sStr += "\n";
                document.form.dvia_desc.value += sStr;
            }
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
        	document.form.dest_desc.value = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_pnt_loc_def_nm");
                
                if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
                	sStr += "(" + arrTermDest[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
                }
                
                sStr += "\n";
                document.form.dest_desc.value += sStr;
            }
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
        if (!LoadingComplete) {
            return;
        }
        
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        var sUrl1 = "/hanjin/ESM_PRI_2081.do?" + FormQueryString(document.form);
        var sUrl2 = "/hanjin/ESM_PRI_2086.do?" + FormQueryString(document.form);
        
        if (colName == "prc_cmdt_def_nm") {
        	sUrl1 += "&cmdt_actcust_tp_cd=C";
            var rtnVal = ComPriOpenWindowCenter(sUrl1, "ESM_PRI_2081", 600, 320, true);
            
            if (rtnVal == "O") {
            	setSheet1RowData(sheetObj, Row, Col);
            }
        }
        
        if (colName == "cust_lgl_eng_nm") {
        	sUrl1 += "&cmdt_actcust_tp_cd=A";
            var rtnVal = ComPriOpenWindowCenter(sUrl1, "ESM_PRI_2081", 600, 320, true);
            
            if (rtnVal == "O") {
            	setSheet1RowData(sheetObj, Row, Col);
            }
        }
        
        if (colName == "org_rout_pnt_loc_def_nm") {
        	sUrl2 += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl2, "ESM_PRI_2086", 700, 320, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "org_rout_via_port_def_nm") {
        	sUrl2 += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl2, "ESM_PRI_2086", 700, 320, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_via_port_def_nm") {
        	sUrl2 += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl2, "ESM_PRI_2086", 700, 320, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_pnt_loc_def_nm") {
        	sUrl2 += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl2, "ESM_PRI_2086", 700, 320, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
    }
    
	/**
	 * 팝업화면에서 변경된 내용을 Sheet1에 반영한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetIdx 필수 Sheet번호
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheet1RowData(sheetObj, Row, Col) {
    	var formObj = document.form;
    	
        var prevStatus = sheetObj.RowStatus(Row);
        var sNm;
        var sCd;
        
        sCd = "";
        sNm = "";
        for (var i = sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow; i++) {
            if (sheetObjects[2].RowStatus(i) == "D") {
                continue;
            }
            
            sCd += "|" + sheetObjects[2].CellValue(i, "prc_cmdt_def_cd");
            sNm += sheetObjects[2].CellValue(i, "prc_cmdt_def_nm") + " / ";
        }
        if (sNm != "") {
        	var lastIdx = sNm.lastIndexOf("/");
        	sNm = sNm.substring(0, lastIdx - 1);
        }
        sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = sCd;
        sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = sNm;
        
        sCd = "";
        sNm = "";
        for (var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].LastRow; i++) {
            if (sheetObjects[3].RowStatus(i) == "D") {
                continue;
            }
            
            sCd += "|" + sheetObjects[3].CellValue(i, "cust_cnt_cd") + sheetObjects[3].CellValue(i, "cust_seq");
            sNm += sheetObjects[3].CellValue(i, "cust_lgl_eng_nm") + " / ";
        }
        if (sNm != "") {
        	var lastIdx = sNm.lastIndexOf("/");
        	sNm = sNm.substring(0, lastIdx - 1);
        }
        sheetObj.CellValue2(Row, "cust_seq") = sCd;
        sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = sNm;
        
        sheetObj.RowStatus(Row) = prevStatus;
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
        var sCd;
        var sNm;
        
        sCd = "";
        sNm = "";
        for (var i = sheetObjects[4].HeaderRows; i <= sheetObjects[4].LastRow; i++) {
            if (sheetObjects[4].RowStatus(i) == "D") {
                continue;
            }
            
        	var sStr = "";
            sStr += sheetObjects[4].CellValue(i, "rout_pnt_loc_def_cd");
            if (sheetObjects[4].CellValue(i, "rcv_de_term_cd") != null && sheetObjects[4].CellValue(i, "rcv_de_term_cd") != "") {
            	sStr += "(" + arrTermOrg[sheetObjects[4].CellValue(i, "rcv_de_term_cd")] + ")";
            }

            sCd += "|" + sStr;
            sNm += sStr + ", ";
        }
        if (sNm != "") {
        	var lastIdx = sNm.lastIndexOf(",");
        	sNm = sNm.substring(0, lastIdx);
        }
        sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = sCd;
        sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = sNm;
    
        sCd = "";
        sNm = "";
        for (var i = sheetObjects[5].HeaderRows; i <= sheetObjects[5].LastRow; i++) {
            if (sheetObjects[5].RowStatus(i) == "D") {
                continue;
            }

            sCd += "|" + sheetObjects[5].CellValue(i, "rout_via_port_def_cd");
            sNm += sheetObjects[5].CellValue(i, "rout_via_port_def_cd") + ", ";
        }
        if (sNm != "") {
        	var lastIdx = sNm.lastIndexOf(",");
        	sNm = sNm.substring(0, lastIdx);
        }
        sheetObj.CellValue2(Row, "org_rout_via_port_def_cd") = sCd;
        sheetObj.CellValue2(Row, "org_rout_via_port_def_nm") = sNm;
    
        sCd = "";
        sNm = "";
        for (var i = sheetObjects[6].HeaderRows; i <= sheetObjects[6].LastRow; i++) {
            if (sheetObjects[6].RowStatus(i) == "D") {
                continue;
            }

            sCd += "|" + sheetObjects[6].CellValue(i, "rout_via_port_def_cd");
            sNm += sheetObjects[6].CellValue(i, "rout_via_port_def_cd") + ", ";
        }
        if (sNm != "") {
        	var lastIdx = sNm.lastIndexOf(",");
        	sNm = sNm.substring(0, lastIdx);
        }
        sheetObj.CellValue2(Row, "dest_rout_via_port_def_cd") = sCd;
        sheetObj.CellValue2(Row, "dest_rout_via_port_def_nm") = sNm;
        
        sCd = "";
        sNm = "";
        for (var i = sheetObjects[7].HeaderRows; i <= sheetObjects[7].LastRow; i++) {
            if (sheetObjects[7].RowStatus(i) == "D") {
                continue;
            }

        	var sStr = "";
            sStr += sheetObjects[7].CellValue(i, "rout_pnt_loc_def_cd");
            if (sheetObjects[7].CellValue(i, "rcv_de_term_cd") != null && sheetObjects[7].CellValue(i, "rcv_de_term_cd") != "") {
            	sStr += "(" + arrTermDest[sheetObjects[7].CellValue(i, "rcv_de_term_cd")] + ")";
            }

            sCd += "|" + sStr;
            sNm += sStr + ", ";
        }
        if (sNm != "") {
        	var lastIdx = sNm.lastIndexOf(",");
        	sNm = sNm.substring(0, lastIdx);
        }
        sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = sCd;
        sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = sNm;
        
        sheetObj.RowStatus(Row) = prevStatus;
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
	function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"
            	&& (sheetObjects[0].IsDataModified
                    || sheetObjects[1].IsDataModified
                    || sheetObjects[2].IsDataModified
                    || sheetObjects[3].IsDataModified
                    || sheetObjects[4].IsDataModified
                    || sheetObjects[5].IsDataModified
                    || sheetObjects[6].IsDataModified
                    || sheetObjects[7].IsDataModified)) {
                isFiredNested = true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested = false;
            	
                var rslt = false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    adjNewRow = Math.max(NewRow - sheetObjects[0].RowCount("D"), sheetObjects[0].HeaderRows);
                    rslt = doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                    supressConfirm = false;
                }
                if (rslt) {
                    isFiredNested = true;
                    sheetObjects[0].SelectCell(adjNewRow, NewCol, false);
                    isFiredNested = false;
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
            	LoadingComplete = false;
            	formObj.gri_grp_seq.value = sheetObjects[0].CellValue(NewRow, "gri_grp_seq");
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
				setFltPctTpCd(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "flt_pct_tp_cd"));
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
	        case IBSEARCH_ASYNC02: // OK. GRI Apply
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00014")) {
	            	return false;
	            }
	            
	            for (var i = sheetObjects[0].HeaderRows; sheetObjects[0].RowCount > 0 && i <= sheetObjects[0].LastRow; i++) {
	            	sheetObjects[0].CellValue2(i, "gri_appl_flg") = "Y";
	            }
	            
	            formObj.f_cmd.value = MODIFY01;
	            var sParam = FormQueryString(formObj);
	            var sParamSheet1 = sheetObjects[0].GetSaveString();
	            if (sParamSheet1 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	            }
	            
	            var sParamSheet8 = sheetObjects[8].GetSaveString(true);
	            if (sParamSheet8 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet9_");
	            }
	            
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_2035GS.do", sParam);
	            sheetObj.LoadSaveXml(sXml);
	            
	            if (sheetObjects[0].IsDataModified) {
	                for (var i = sheetObjects[0].HeaderRows; sheetObjects[0].RowCount > 0 && i <= sheetObjects[0].LastRow; i++) {
	                	sheetObjects[0].CellValue2(i, "gri_appl_flg") = "N";
	                }
	            	return false;
	            } else {
	                if (sheetObjects[0].RowCount > 0) {
	                	formObj.gri_appl_flg.value = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "gri_appl_flg");
	                	
	                }
	                toggleButtons("INIT");
	                
	                ComShowCodeMessage("PRI00114");
	    	        
	                checkIHCRateAmt();
	    	        
	    	        window.close();
	                opener.saveCurRowPos();
	            	opener.reloadPagePostTr();
	            }
	            break;
	            
	        case IBSEARCH_ASYNC03: // CANCEL
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            if (!ComShowCodeConfirm("PRI00015")) {
	            	return false;
	            }
	            
	            // Cancel시 기존 GRI를 모두 삭제처리. 2009-07-29.
	            for (var i = sheetObjects[0].HeaderRows; sheetObjects[0].RowCount > 0 && i <= sheetObjects[0].LastRow; i++) {
	            	sheetObjects[0].CellValue2(i, "chk") = "1";
	            }
	            for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
	            	sheetObjects[1].CellValue2(i, "chk") = "1";
	            }
	            
	        	deleteRowCheck(sheetObjects[0], "chk");
	        	deleteRowCheck(sheetObjects[1], "chk");
	            document.form.cmdt_desc.value = "";
	            document.form.actcust_desc.value = "";
	            document.form.origin_desc.value = "";
	            document.form.ovia_desc.value = "";
	            document.form.dvia_desc.value = "";
	            document.form.dest_desc.value = "";
	            
	            formObj.f_cmd.value = MODIFY02;
	            var sParam = FormQueryString(formObj);
	            var sParamSheet1 = sheetObjects[0].GetSaveString();
	            if (sParamSheet1 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	            }
	            
	            var sParamSheet8 = sheetObjects[8].GetSaveString(true);
	            if (sParamSheet8 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet9_");
	            }           
	            
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_2035GS.do", sParam);
	            sheetObj.LoadSaveXml(sXml);
	            
	            if (sheetObjects[0].IsDataModified) {
	            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	            	return false;
	            } else {
	                if (sheetObjects[0].RowCount > 0) {
	                	formObj.gri_appl_flg.value = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "gri_appl_flg");
	                	
	                }
	                toggleButtons("INIT");
	                
	            	ComShowCodeMessage("PRI00115");
	            	window.close();
	            	
	                opener.saveCurRowPos();
	            	opener.reloadPagePostTr();
	            }
	            break;
	            
	        case IBCLEAR: // 화면 로딩시 
	            var sXml = "";
	            
	            //공통 GRI Application Division
	            formObj.f_cmd.value = SEARCH19;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01706");
	            setIBCombo(sheetObjects[0], sXml, "gri_appl_div_cd", true, 0);
	            
	            // per combo
	            formObj.f_cmd.value = SEARCH03;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "rat_ut_cd", false, 0, "D2");
	            
	            //공통 cargo
	            formObj.f_cmd.value = SEARCH19;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01701");
	            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", false, 0, "DR");
	            
	            //currency combo
	            formObj.f_cmd.value = SEARCH06;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "curr_cd", false, 0, "USD");
	            
				//공통 Term Origin
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02138");
				arrTemp = ComPriXml2Array(sXml, "cd|nm");
				for (var i = 0; i < arrTemp.length; i++) {
					arrTermOrg[arrTemp[i][0]] = arrTemp[i][1];
				}
	
				//공통 Term Destination
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02139");
				arrTemp = ComPriXml2Array(sXml, "cd|nm");
				for (var i = 0; i < arrTemp.length; i++) {
					arrTermDest[arrTemp[i][0]] = arrTemp[i][1];
				}
	            
	            break;
	            
	        case IBSEARCH: // 조회
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI01007');
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                for (var i = 0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                document.form.cmdt_desc.value = "";
	                document.form.actcust_desc.value = "";
	                document.form.origin_desc.value = "";
	                document.form.ovia_desc.value = "";
	                document.form.dvia_desc.value = "";
	                document.form.dest_desc.value = "";
	                
	                formObj.f_cmd.value = SEARCH01;
	                var sXml = sheetObj.DoSearch("ESM_PRI_2035GS.do" , FormQueryString(formObj));
	                
	                if (sheetObj.RowCount > 0) {
	                	formObj.gri_appl_flg.value = sheetObj.CellValue(sheetObj.HeaderRows, "gri_appl_flg");
	                }
	                
	                toggleButtons("INIT");
	            } else if (sheetObj.id == "sheet2") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                formObj.f_cmd.value = SEARCH02;
	                var sXml = sheetObj.GetSearchXml("ESM_PRI_2035GS.do" , FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);    // Grid2.
	                if (arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[1]);    // Hidden. Grid1의 Commodity.
	                if (arrXml.length > 2) sheetObjects[3].LoadSearchXml(arrXml[2]);    // Hidden. Grid1의 Actual Customer.
	                if (arrXml.length > 3) sheetObjects[4].LoadSearchXml(arrXml[3]);    // Hidden. Grid1의 Origin Point.
	                if (arrXml.length > 4) sheetObjects[5].LoadSearchXml(arrXml[4]);    // Hidden. Grid1의 Origin Via.
	                if (arrXml.length > 5) sheetObjects[6].LoadSearchXml(arrXml[5]);    // Hidden. Grid1의 Destination Via.
	                if (arrXml.length > 6) sheetObjects[7].LoadSearchXml(arrXml[6]);    // Hidden. Grid1의 Destination Point.
	                
	            }
	            break;
	    
	        case IBSAVE: // 저장
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            formObj.f_cmd.value = MULTI01;
	            var sParam = FormQueryString(formObj);
	            var sParamSheet1 = sheetObjects[0].GetSaveString();
	            if (sParamSheet1 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	            }
	            var sParamSheet2 = sheetObjects[1].GetSaveString();
	            if (sParamSheet2 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	            }
	            var sParamSheet3 = sheetObjects[2].GetSaveString();
	            if (sParamSheet3 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
	            }
	            var sParamSheet4 = sheetObjects[3].GetSaveString();
	            if (sParamSheet4 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet4, "sheet4_");
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
	            
	            if (!supressConfirm && !ComPriConfirmSave()) {
	                return false;
	            }
	                
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_2035GS.do", sParam);
	            sheetObjects[7].LoadSaveXml(sXml);
	            sheetObjects[6].LoadSaveXml(sXml);
	            sheetObjects[5].LoadSaveXml(sXml);
	            sheetObjects[4].LoadSaveXml(sXml);
	            sheetObjects[3].LoadSaveXml(sXml);
	            sheetObjects[2].LoadSaveXml(sXml);
	            sheetObjects[1].LoadSaveXml(sXml);
	            sheetObjects[0].LoadSaveXml(sXml);
	            
	            if (sheetObjects[0].IsDataModified
	            		|| sheetObjects[1].IsDataModified
	            		|| sheetObjects[2].IsDataModified
	            		|| sheetObjects[3].IsDataModified
	            		|| sheetObjects[4].IsDataModified
	            		|| sheetObjects[5].IsDataModified
	            		|| sheetObjects[6].IsDataModified
	            		|| sheetObjects[7].IsDataModified) {
	                return false;
	            } else {
	            	toggleButtons("INIT");
	            	
	                ComPriSaveCompleted();
	                return true;
	            }
	
	            break;
	    
	        case IBINSERT: // Row Add
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (sheetObj.id == "sheet1") {
	                var idx = doRowChange(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
	                if (idx < 0) {
	                    return false;
	                }
	                
	                sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
	                sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
	                sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
	                sheetObj.CellValue(idx, "gen_spcl_rt_tp_cd") = formObj.fic_rt_tp_cd.value;
	                sheetObj.CellValue(idx, "gri_grp_seq") = parseInt(ComPriGetMax(sheetObj, "gri_grp_seq")) + 1;
	                sheetObj.CellValue(idx, "gri_appl_flg") = "N";
	                sheetObj.CellValue(idx, "flt_pct_tp_cd") = getFltPctTpCd();
	                
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                formObj.gri_grp_seq.value = sheetObj.CellValue(idx, "gri_grp_seq");
	                formObj.gri_appl_flg.value = sheetObj.CellValue(idx, "gri_appl_flg");
	                document.form.cmdt_desc.value = "";
	                document.form.actcust_desc.value = "";
	                document.form.origin_desc.value = "";
	                document.form.ovia_desc.value = "";
	                document.form.dvia_desc.value = "";
	                document.form.dest_desc.value = "";
	                
	                sheetObj.SelectCell(idx, "gri_appl_div_cd", false);
	            }
	            
	            if (sheetObj.id == "sheet2") {
	            	if (!sheetObjects[0].CellEditable(sheetObjects[0].SelectRow, "gri_appl_div_cd")) {
	            		return false;
	            	}
	            	
	                var idx = sheetObj.DataInsert();
	                
	                sheetObj.CellValue(idx, "prop_no") = formObj.prop_no.value;
	                sheetObj.CellValue(idx, "amdt_seq") = formObj.amdt_seq.value;
	                sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
	                sheetObj.CellValue(idx, "gen_spcl_rt_tp_cd") = formObj.fic_rt_tp_cd.value;
	                sheetObj.CellValue(idx, "gri_grp_seq") = formObj.gri_grp_seq.value;
	                sheetObj.CellValue(idx, "gri_rt_seq") = parseInt(ComPriGetMax(sheetObj, "gri_rt_seq")) + 1;
	                
	                setFltPctEnable();
	                
	                sheetObj.SelectCell(idx, "rat_ut_cd", false);
	            }
	            break;
	            
	        case IBCOPYROW: // Row Copy
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	            if (sheetObj.id == "sheet1") {
	                var idx = doRowChange(-2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
	                if (idx < 0) {
	                    return false;
	                }
	                
	                var newGriGrpSeq = parseInt(ComPriGetMax(sheetObj, "gri_grp_seq")) + 1;
	                sheetObj.CellValue(idx, "gri_grp_seq") = newGriGrpSeq;
	                
	                for (var a = 1; a < sheetObjects.length; a++) {
	                	if (sheetObjects[a].RowCount <= 0) {
	                		continue;
	                	}
	                    for (var i = sheetObjects[a].LastRow; i >= sheetObjects[a].HeaderRows; i--) {
	                    	if (sheetObjects[a].RowStatus(i) == "D") {
	                    		continue;
	                    	}
	                    	
	                        sheetObjects[a].CellValue(i, "gri_grp_seq") = newGriGrpSeq;
	                        
	                        sheetObjects[a].RowStatus(i) = "I";
	                    }
	                }
	            }
	            break;
	            
	        case IBDELETE: // Delete
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	        	if (sheetObj.id == "sheet2" && !sheetObj.Editable) {
	        		return false;
	        	}
	            
	            var prevCmdtHdrSeq = sheetObj.CellValue(sheetObj.SelectRow, "cmdt_hdr_seq");
	            
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	        	
				if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
				}
	            
	            var delCnt = deleteRowCheck(sheetObj, "chk");
	            if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                document.form.cmdt_desc.value = "";
	                document.form.actcust_desc.value = "";
	                document.form.origin_desc.value = "";
	                document.form.ovia_desc.value = "";
	                document.form.dvia_desc.value = "";
	                document.form.dest_desc.value = "";
	            }
	 
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
        case IBSEARCH_ASYNC02: // OK
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (getValidRowCount(sheetObjects[0]) <= 0) {
        		return false;
        	}
        	// GRI Calc.가 이미 Apply된 경우.
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
        	// "Include"항목이 없는 경우.
    		var incIdx = sheetObjects[0].FindText("gri_appl_div_cd", "Include");
    		if (incIdx < 0) {
        		ComShowCodeMessage("PRI00348");
        		return false;
    		}
        	// 변경후, 저장이 안된 Sheet가 존재하는 경우
        	for (var i = 0; i < sheetObjects.length; i++) {
        		if (sheetObjects[i].IsDataModified) {
                    ComShowCodeMessage("PRI08015");
                    return false;
        		}
        	}
        	
        	var str = '';	            
            formObj.f_cmd.value = SEARCH03;
            var sParam = FormQueryString(formObj);
        	var cXml = sheetObj.GetSearchXml("ESM_PRI_2035GS.do", sParam);
        	sheetObjects[8].LoadSearchXml(cXml);
        	if(sheetObjects[8].SearchRows > 0) {
        		var r =  sheetObjects[8].Rows;
        		for (var i = sheetObjects[8].HeaderRows; i < r; i++) {
        			str += sheetObjects[8].CellValue(i, 'blet_dp_seq');
        			if(i < r-1) {
        				str += ',';
        			}
        		}
        		ComShowCodeMessage('PRI07023', str);
        		return false;
        	}
        	return true;
            break;
            
        case IBSEARCH_ASYNC03: // CANCEL
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (getValidRowCount(sheetObjects[0]) <= 0) {
        		return false;
        	}
        	// GRI Calc.가  Apply되어있지 않은 경우.
        	if (formObj.gri_appl_flg.value == "N") {
        		return false;
        	}
        	// 변경후, 저장이 안된 Sheet가 존재하는 경우
        	for (var i = 0; i < sheetObjects.length; i++) {
        		if (sheetObjects[i].IsDataModified) {
                    ComShowCodeMessage("PRI08015");
                    return false;
        		}
        	}
        	
            formObj.f_cmd.value = SEARCH03;
            var sParam = FormQueryString(formObj);
        	var cXml = sheetObj.GetSearchXml("ESM_PRI_2035GS.do", sParam);
        	sheetObjects[8].LoadSearchXml(cXml);
            return true;
            break;
            
        case IBSEARCH: // 조회
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
    
        case IBSAVE: // 저장
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
        	
            if (!sheetObjects[0].IsDataModified
                    && !sheetObjects[1].IsDataModified
                    && !sheetObjects[2].IsDataModified
                    && !sheetObjects[3].IsDataModified
                    && !sheetObjects[4].IsDataModified
                    && !sheetObjects[5].IsDataModified
                    && !sheetObjects[6].IsDataModified
                    && !sheetObjects[7].IsDataModified) {
                ComShowCodeMessage("PRI00301");
                return false;
            }
            
            // Group이 삭제된 상태가 아닌데, Rate부분이 없는 경우
			if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"
				&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "gri_appl_div_cd") == "I"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
				ComShowCodeMessage("PRI00007");
				return false;
			}
            
            if (sheetObjects[0].IsDataModified
                    && sheetObjects[0].GetSaveString() == "") {
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
            if (sheetObjects[3].IsDataModified
                    && sheetObjects[3].GetSaveString() == "") {
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
                        
			var rowM = sheetObjects[0].ColValueDup("gri_appl_div_cd|prc_cmdt_def_nm|cust_lgl_eng_nm|org_rout_pnt_loc_def_cd|org_rout_via_port_def_cd|dest_rout_via_port_def_cd|dest_rout_pnt_loc_def_cd", false);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00302");
				return false;
			}
            
			var rowS = sheetObjects[1].ColValueDup("rat_ut_cd|prc_cgo_tp_cd|curr_cd", false);
			if (rowS >= 0) {
				ComShowCodeMessage("PRI00302");
				return false;
			}
            
			// GRI Amount나 Ratio 필수값 체크.
            for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
                if (getFltPctTpCd() == "F" 
                	&& (sheetObjects[1].CellValue(i, "gri_rt_amt") == 0.00
                			|| sheetObjects[1].CellValue(i, "gri_rt_amt") == "")) {
                	sheetObjects[1].SelectCell(i, "gri_rt_amt", false);
                    ComShowCodeMessage("PRI00316", "GRI Amount");
                    return false;
                }
                if (getFltPctTpCd() == "P" 
                	&& (sheetObjects[1].CellValue(i, "gri_rt_rto") == 0
                			|| sheetObjects[1].CellValue(i, "gri_rt_rto") == "")) {
                	sheetObjects[1].SelectCell(i, "gri_rt_rto", false);
                    ComShowCodeMessage("PRI00316", "Percentage");
                    return false;
                }
            }
    
            return true;
            break;
    
        case IBINSERT: // Row Add
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
        	
        	if (sheetObj.id == "sheet1") {

            } else if (sheetObj.id == "sheet2") {
                if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0) {
                    return false;
                }
                // Group이 "Exclude"일 경우, Rate를 달수 없다.
                if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "gri_appl_div_cd") == "E") {
                	return false;
                }
            }
            
            return true;
            break;
            
        case IBCOPYROW: // Row Copy
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
        	
            if (sheetObj.RowCount <= 0 || sheetObj.SelectRow <= 0) {
                return false;
            }
            
            return true;
            break;
    
        case IBDELETE: // Delete
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
        	
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	
        	return true;
            break;
        }
    }
    
    function getFltPctTpCd() {
        for (var i = 0; i < document.form.flt_pct_tp_cd.length; i++) {
            if (document.form.flt_pct_tp_cd[i].checked) {
                return document.form.flt_pct_tp_cd[i].value;
            }
        }
    }
    
    function getFltPctTpChecked() {
        for (var i = 0; i < document.form.flt_pct_tp_cd.length; i++) {
            if (document.form.flt_pct_tp_cd[i].checked) {
                return i;
            }
        }
    }
    
    function setFltPctTpCd(code) {
        for (var i = 0; i < document.form.flt_pct_tp_cd.length; i++) {
            if (document.form.flt_pct_tp_cd[i].value == code) {
            	document.form.flt_pct_tp_cd[i].checked = true;
            	setFltPctEnable();
            	break;
            }
        }
    }
    
	/**
	 * Radio Button [flt_pct_tp_cd]의 값에 따라, Amount와 Ratio부분 Enable/Disable.
	 * 
	 * @param 
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setFltPctEnable() {
    	var fltPctTpCd = getFltPctTpCd();
    	
    	if (sheetObjects[0].RowCount > 0) {
    		sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "flt_pct_tp_cd") = fltPctTpCd;
    	}
    	
    	if (sheetObjects[1].RowCount > 0) {
	    	for (var i = sheetObjects[1].HeaderRows; i <= sheetObjects[1].LastRow; i++) {
	        	if (fltPctTpCd == "F") {
	        		sheetObjects[1].CellValue2(i, "gri_rt_rto") = "";
	        		sheetObjects[1].CellEditable(i, "gri_rt_rto") = false;
	        		sheetObjects[1].CellEditable(i, "gri_rt_amt") = true;
	        	} else if (fltPctTpCd == "P") {
	        		sheetObjects[1].CellValue2(i, "gri_rt_amt") = "";
	        		sheetObjects[1].CellEditable(i, "gri_rt_amt") = false;
	        		sheetObjects[1].CellEditable(i, "gri_rt_rto") = true;
	        	}
	    	}
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
        var sXml = ComPriSheet2Xml(sheetObjects[sheetNo]);
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
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml);
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
            disableButton("btn_ok");
            disableButton("btn_cancel");
            sheetObjects[0].CountFormat = "[Apply : No]";
            
        	//sheetObjects[0].Editable = false;
            setSheetEditable(sheetObjects[0], false);
        	sheetObjects[1].Editable = false;
        	
        	document.form.flt_pct_tp_cd[0].disabled = true;
        	document.form.flt_pct_tp_cd[1].disabled = true;
            break;
        case "INIT":
        	if (sheetObjects[0].RowCount > 0 && document.form.gri_appl_flg.value == "Y") {
        		disableButton("btn_ok");
            	enableButton("btn_cancel");
            	sheetObjects[0].CountFormat = "[Apply : Yes]";
            	
            	//sheetObjects[0].Editable = false;
            	setSheetEditable(sheetObjects[0], false);
            	sheetObjects[1].Editable = false;
            	
            	document.form.flt_pct_tp_cd[0].disabled = true;
            	document.form.flt_pct_tp_cd[1].disabled = true;
        	} else if (sheetObjects[0].RowCount > 0 && document.form.gri_appl_flg.value == "N") {
            	enableButton("btn_ok");
            	disableButton("btn_cancel");
            	sheetObjects[0].CountFormat = "[Apply : No]";
            	
            	setSheetEditable(sheetObjects[0], true);
            	
        		if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "gri_appl_div_cd") == "E") {
        			for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
        				sheetObjects[1].RowHidden(i) = true;
        				sheetObjects[1].RowStatus(i) = "D";
        			}
                	sheetObjects[1].Editable = false;
                	document.form.flt_pct_tp_cd[0].disabled = true;
                	document.form.flt_pct_tp_cd[1].disabled = true;
        		} else {
                	sheetObjects[1].Editable = true;
                	document.form.flt_pct_tp_cd[0].disabled = false;
                	document.form.flt_pct_tp_cd[1].disabled = false;
        		}
        	} else {
        		disableButton("btn_ok");
        		disableButton("btn_cancel");
        		sheetObjects[0].CountFormat = "[Apply : No]";
        		
        		setSheetEditable(sheetObjects[0], true);
        		
        		if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "gri_appl_div_cd") == "E") {
        			for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
        				sheetObjects[1].RowHidden(i) = true;
        				sheetObjects[1].RowStatus(i) = "D";
        			}
                	sheetObjects[1].Editable = false;
                	document.form.flt_pct_tp_cd[0].disabled = true;
                	document.form.flt_pct_tp_cd[1].disabled = true;
        		} else {
                	sheetObjects[1].Editable = true;
                	document.form.flt_pct_tp_cd[0].disabled = false;
                	document.form.flt_pct_tp_cd[1].disabled = false;
        		}
        	}

            break;
        case "READONLY":
    		disableButton("btn_ok");
    		disableButton("btn_cancel");
    		sheetObjects[0].CountFormat = "[Apply : No]";
    		
    		setSheetEditable(sheetObjects[0], false);
    		
    		if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "gri_appl_div_cd") == "E") {
    			for (var i = sheetObjects[1].HeaderRows; sheetObjects[1].RowCount > 0 && i <= sheetObjects[1].LastRow; i++) {
    				sheetObjects[1].RowHidden(i) = true;
    				sheetObjects[1].RowStatus(i) = "D";
    			}
            	sheetObjects[1].Editable = false;
            	document.form.flt_pct_tp_cd[0].disabled = true;
            	document.form.flt_pct_tp_cd[1].disabled = true;
    		} else {
            	sheetObjects[1].Editable = true;
            	document.form.flt_pct_tp_cd[0].disabled = false;
            	document.form.flt_pct_tp_cd[1].disabled = false;
    		}
            break;
        }
    }
    
	/**
	 * Sheet가 ReadOnly상태에서도 팝업을 띠우기 위해 RowEditable 대신 사용하는 함수.
	 * dtPopup컬럼은 Disable시키지 않는다.
	 * 
	 * @param 
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheetEditable(sheetObj, flag) {
    	for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
			for (var j = 0; j <= sheetObj.LastCol; j++) {
				if (sheetObj.ReadDataProperty(i, j, dpDataType) == dtPopup) {
					continue;
				}
				sheetObj.CellEditable(i, j) = flag;
			}
    	}
    }
    
	/**
	 * Rate (For AEE/AEW)==> Proposal의 IHC금액이 0인 Rate 조회.
	 */
	function checkIHCRateAmt() {
        var formObj = document.form;
        var sheetObj = sheetObjects[8]
        formObj.f_cmd.value = SEARCH20;
        
        var sParam = FormQueryString(formObj) ; 
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);        
        var rValue = ComGetEtcData(sXml, "RSLT");
        if(rValue != '') {
        	ComShowCodeMessage('PRI07024', rValue);
        }
	}    

/* 개발자 작업 끝 */