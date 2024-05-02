/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0112.js
 *@FileTitle : GRI Calculation Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.09.16 박성수
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
    function ESM_PRI_0112() {
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

			case "btn_close":
				window.close();
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
                Editable = false;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                
                var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|GRI Group Seq.|Flat Percent Type Code|Application|GRI Application Flag|prc_cmdt_def_cd|Commodity Group|cust_seq|Actual Customer|origin|Origin|ovia|O.Via|dvia|D.Via|dest|Dest.";
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
                InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gri_grp_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "flt_pct_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtCombo, 80, daCenter, false, "gri_appl_div_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gri_appl_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 250, daLeft, false, "prc_cmdt_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 290, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, true, true);
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
                ShowButtonImage = 0;
                CountPosition = 2;
                CountFontBold = true;
                CountFormat = "[ ]";
                UnEditableColor = RgbColor(255, 255, 255);
                
        		if (document.form.gen_spcl_rt_tp_cd.value == "G") {
        			ColHidden("cust_lgl_eng_nm") = true;
        			ColWidth("prc_cmdt_def_nm") =  400;
        		}
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
                Editable = false;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                
        		var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|GRI Group Seq.|GRI Rate Seq.|Per|Cargo Type|Currency|GRI Amount|Percentage(%)";
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
                InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gri_grp_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "gri_rt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtCombo,150, daCenter, false, "rat_ut_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo,150, daCenter, false, "prc_cgo_tp_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo,150, daCenter, false, "curr_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 210, daRight,  false, "gri_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 210, daRight,  false, "gri_rt_rto", false, "", dfNullInteger, 0, true, true, 3);
                
                Ellipsis = true;
                ShowButtonImage = 0;
                CountPosition = 0;
                UnEditableColor = RgbColor(255, 255, 255);
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
		doRowChange(OldRow, NewRow, OldCol, NewRow, IBSEARCH);
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
	function doRowChange(OldRow, NewRow, OldCol, NewRow, sAction) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetObjects[0].IsDataModified
                    || sheetObjects[1].IsDataModified
                    || sheetObjects[2].IsDataModified
                    || sheetObjects[3].IsDataModified
                    || sheetObjects[4].IsDataModified
                    || sheetObjects[5].IsDataModified
                    || sheetObjects[6].IsDataModified
                    || sheetObjects[7].IsDataModified) {
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
            	formObj.gri_grp_seq.value = sheetObjects[0].CellValue(NewRow, "gri_grp_seq");
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
				setFltPctTpCd(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "flt_pct_tp_cd"));
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
	            
	        case IBCLEAR: // 화면 로딩시 
	            var sXml = "";
	            
	            //공통 GRI Application Division
	            formObj.f_cmd.value = SEARCH19;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01706");
	            setIBCombo(sheetObjects[0], sXml, "gri_appl_div_cd", true, 0);
	            
	            // per combo
	            formObj.f_cmd.value = SEARCH03;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "rat_ut_cd", true, 0);
	            
	            //공통 cargo
	            formObj.f_cmd.value = SEARCH19;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01701");
	            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", true, 0);
	            
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
	                var sXml = sheetObj.DoSearch("ESM_PRI_0112GS.do" , FormQueryString(formObj));
	                
	                if (sheetObj.RowCount > 0) {
	                	formObj.gri_appl_flg.value = sheetObj.CellValue(sheetObj.HeaderRows, "gri_appl_flg");
	                	
	                	if (document.form.gri_appl_flg.value == "Y") {
	                    	sheetObjects[0].CountFormat = "[Apply : Yes]";
	                	} else if (document.form.gri_appl_flg.value == "N") {
	                    	sheetObjects[0].CountFormat = "[Apply : No]";
	                	}
	                }
	                
	            } else if (sheetObj.id == "sheet2") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                formObj.f_cmd.value = SEARCH02;
	                var sXml = sheetObj.GetSearchXml("ESM_PRI_0112GS.do" , FormQueryString(formObj));
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
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
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
            	break;
            }
        }
    }
    

/* 개발자 작업 끝 */