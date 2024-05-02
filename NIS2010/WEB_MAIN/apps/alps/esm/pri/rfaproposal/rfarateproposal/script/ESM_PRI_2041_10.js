/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_2041_10.js
 *@FileTitle : Amendment History - Rate (For AEE/AEW)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.06.27
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 * 2012.06.27 서미진
 * 1.0 Creation
* =========================================================
* History
* 2014.03.31 서미진 [CHM-201429599] RFA Conversion 상 S/I Column 추가                                 
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
    function ESM_PRI_2041_10() {
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
    
    var sheetObjects2 = new Array(); // 신규로 추가된 sheet. 기존 로직 보호 위해
    var sheetCnt2 = 0;
    // ComboBox에는 표시되지 않지만 이행데이타에 존재하는 Rating Unit 코드.
    var unusedRatUtCd = "|20|40|CT|DF|DW|HC|UN";
    
    var tabLoad = new Array();
    tabLoad[0] = 0;
    tabLoad[1] = 0;
    
    var LoadingComplete = false;
    
//    var arrTermOrg = new Array();
//    var arrTermDest = new Array();
//    var arrTransMode = new Array();
    
    var acptCnt = null;
    var notAcptCnt = null;
    
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
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
                
            case "btn_gricalc":
            	if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
            		ComPriOpenWindowCenter("/hanjin/ESM_PRI_2087.do?" + FormQueryString(formObject), "ESM_PRI_2087", 1000, 405, false);
                }
                break;
                
            case "btn_specification":
            	if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
	            	if (sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "prc_cgo_tp_cd") != "AK") {
	            		return false;
	            	}
            	}
            	
            	ComPriOpenWindowCenter("/hanjin/ESM_PRI_2075.do?" + FormQueryString(formObject) + "&rt_seq=" + sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "rt_seq"), "ESM_PRI_2075", 700, 380, false);
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
//        sheetObjects[sheetCnt++] = sheet_obj;
    	var id = sheet_obj.id;
    	var numId = Number(id.substr(5));
    	if(numId<17){
    		sheetObjects[sheetCnt++] = sheet_obj;
    	}else{
    		sheetObjects2[sheetCnt2++] = sheet_obj;
    	}
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
        
        // 추가한 sheet 초기화
        for (var i = 0; i < sheetObjects2.length; i++) {
            ComConfigSheet(sheetObjects2[i]);
            initSheet(sheetObjects2[i], i + 1);
            sheetObjects2[i].WaitImageVisible = false;
            ComEndConfigSheet(sheetObjects2[i]);
        }
        initControl();
        loadSts = true;
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
                
                var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Bullet No.|Commodity Group|Actual Customer|Commodity Note|note_ctnt_tooltip|Not Deleted Rows|Not Accepted Rows|Accepted Rows|n1st_cmnc_amdt_seq|fic_rt_tp_cd";
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
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "blet_dp_seq", false, "", dfNullInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtPopup, 350, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, true, true);
        		InitDataProperty(0, cnt++, dtPopup, 300, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, true, true);
        		InitDataProperty(0, cnt++, dtPopup, 130, daLeft, false, "note_ctnt", false, "", dfNone, 0, true, true);
        		InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "note_ctnt_tooltip", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "nd_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "na_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "ac_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "fic_rt_tp_cd", true, "", dfNone, 0, false, false);
                
        		ToolTipOption = "balloon:true;width:1000;icon:1;title:Commodity Note";
                Ellipsis = true;
                ShowButtonImage = 2;
                AutoRowHeight = false;
                CountPosition = 0;
                UnEditableColor = RgbColor(255, 255, 255);
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
                MergeSheet = msHeaderOnly;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                
                var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Origin|Origin Via|Destination Via|Destination|Route Note|Note Tooltip|Not Deleted Rows|Not Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq";
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
                InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "rn", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", false, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, dtPopup, 165, daLeft, false, "org_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 165, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 165, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 165, daLeft, false, "dest_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 130, daLeft, false, "note_ctnt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "note_ctnt_tooltip", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "nd_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "na_cnt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "note_dp_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                
                ToolTipOption = "balloon:true;width:1000;icon:1;title:Route Note";
                Ellipsis = true;
                ShowButtonImage = 2;
                AutoRowHeight = false;
                CountPosition = 0;
                UnEditableColor = RgbColor(255, 255, 255);
            }
            break;
    
        case "sheet3":  // Grid 3
            with (sheetObj) {
                // 높이 설정
                style.height = 142;
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
                
        		var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Proposal|C/Offer|Final|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|GRI|GRI|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord";
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
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rt_seq", false, "", dfNone, 0, false, false);
                
                InitDataProperty(0, cnt++, dtCombo,40, daCenter, false, "rat_ut_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo,70, daCenter, false, "prc_cgo_tp_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo,40, daCenter, false, "curr_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "prop_frt_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "coffr_frt_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
                
                InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daCenter, false, "next_n1st_cmnc_amdt_seq", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
                
                InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "gri_appl_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "gri_appl_amt", false, "", dfNullFloat, 2, false, false);
                
                InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);

                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
                
                InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue, "D2");
                InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCddValue, "DR");
                InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");
                
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 0;
                UnEditableColor = RgbColor(255, 255, 255);
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
                
                var HeadTitle = "4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10|4-11|4-12|4-13|4-14|4-15|4-16|4-17|4-18|4-19|4-20|4-21";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet5":  // Grid 1의 Actual Customer
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
                
                var HeadTitle = "5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13|5-14|5-15|5-16|5-17|5-18|5-19";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "act_cust_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_cnt_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_lgl_eng_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet6":  // Grid 1의 Commodity Note
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
                
                var HeadTitle = "6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11|6-12|6-13|6-14|6-15|6-16|6-17|6-18|6-19|6-20";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_note_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_ctnt", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id_chk", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet7":  // Grid 2의 Origin Point
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
                
                var HeadTitle = "7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11|7-12|7-13|7-14|7-15|7-16|7-17|7-18|7-19|7-20|7-21|7-22|7-23|7-24|7-25|7-26|7-27";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cnt_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet8":  // Grid 2의 Origin Via.
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
                
                var HeadTitle = "8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12|8-13|8-14|8-15|8-16|8-17|8-18|8-19|8-20|8-21|8-22|8-23";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet9":  // Grid 2의 Destination Via.
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
                
                var HeadTitle = "9-1|9-2|9-3|9-4|9-5|9-6|9-7|9-8|9-9|9-10|9-11|9-12|9-13|9-14|9-15|9-16|9-17|9-18|9-19|9-20|9-21|9-22|9-23";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet10":  // Grid 2의 Destination Point
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
                
                var HeadTitle = "10-1|10-2|10-3|10-4|10-5|10-6|10-7|10-8|10-9|10-10|10-11|10-12|10-13|10-14|10-15|10-16|10-17|10-18|10-19|10-20|10-21|10-22|10-23|10-24|10-25|10-26|10-27";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cnt_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "loc_grd_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet11":  // Grid 2의 Direct Call
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
                
                var HeadTitle = "status";
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

                Visible = false;
            }
            break;
            
        case "sheet12":  // Grid 2의 Rnote
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
                
                var HeadTitle = "12-1|12-2|12-3|12-4|12-5|12-6|12-7|12-8|12-9|12-10|12-11|12-12|12-13|12-14|12-15|12-16|12-17|12-18|12-19|12-20";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_note_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_ctnt", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prog_sts_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "note_conv_mapg_id_chk", false, "", dfNone, 0, false, false);
            }
            break;
            
        case "sheet13": // Excel Download용 Sheet(Vertical)
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

                var HeadTitle1 = "Seq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Seq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Surcharge(USD)|Surcharge(USD)|Surcharge(USD)";
                var HeadTitle2 = "Seq.|Code|Description|Code|Description|Seq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|PER|Cargo Type|Rate|BUC|IFC|PSC";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cmdt_dp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cust_lgl_eng_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rout_dp_seq", true, "", dfNone, 0, false, false);
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rat_ut_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cgo_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "prop_frt_rt_amt", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_usd_amt", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_usd_amt", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_usd_amt", true, "", dfNullFloat, 2, false, false);
            }
            break;
            
        case "sheet14": // Excel Download용 Sheet(Horizontal)
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

                var HeadTitle1 = "Seq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Seq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)";
                var HeadTitle2 = "Seq.|Code|Description|Code|Description|Seq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC";
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
                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cmdt_dp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "cust_lgl_eng_nm", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rout_dp_seq", true, "", dfNone, 0, false, false);
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
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry20", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry45", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rf40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rd40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry20", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry40", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry45", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_rf40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_rd40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry20", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry40", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry45", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_rf40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_rd40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry20", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry40", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry45", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_rf40hc", true, "", dfNullFloat, 2, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_rd40hc", true, "", dfNullFloat, 2, false, false);

            }
            break;
            
        case "sheet15": // Commodity Note Conversion
            with (sheetObj) {
                // 높이 설정
                style.height = 130; 
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                var HeadTitle = "|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
                     	"|Lane|T/S\nPort|VVD|SOC|POR|POL|POD|DEL|S/I|Node|CMDT|Weight\n(Ton < = )|Weight\n( > Ton)|Direct\nCall|Bar Type" +
                		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,   daCenter,  true,	"ibflag");
	            InitDataProperty(0, cnt++ , dtData,	   			40,   daCenter,  true,	"chg_rule_def_cd",			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,				85,   daCenter,  true,	"eff_dt",  					false,	"",	dfDateYmd,			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,				85,   daCenter,  true,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			75,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,  	    	40,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,        		35,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,         	75,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,      	2,     true,       true,	9);
	            InitDataProperty(0, cnt++ , dtData,      		75,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     true,       true);
	            
	            InitDataProperty(0, cnt++ , dtData,   			35,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,  			35,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,   	    	40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     true,       true, 	3);
	            InitDataProperty(0, cnt++ , dtData,  			50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     true,       true,	3);
	            InitDataProperty(0, cnt++ , dtData,				60,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
	            InitDataProperty(0, cnt++ , dtData,				85,   daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     true,       true,	9);
	            InitDataProperty(0, cnt++ , dtData,				35,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     true,       true,	5);                     
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     true,       true,	5);
	            
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
	            InitDataProperty(0, cnt++ , dtData,				150,  daCenter,  true,	"bkg_esvc_tp_cd",			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_yd_cd",     			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     true,       true,	6);
	            InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     true,       true,	4);
	            InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     true,       true,	4);
	            InitDataProperty(0, cnt++ , dtData,				45,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,   	 		55,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     true,       true);
	            
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_mapg_id");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_seq");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"svc_scp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"amdt_seq");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"prop_no");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"chg_rule_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_chg_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_rule_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_hdr_seq");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_tp_cd");    
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_cmdt_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_por_tp_cd");
                
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_pol_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_pod_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_del_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_vsl_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_skd_voy_no");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_skd_dir_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_ts_port_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"amdt_seq");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"prop_no");
            }
            break;

        case "sheet16": // Route Note Conversion
            with (sheetObj) {
                // 높이 설정
                style.height = 130; 
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                var HeadTitle = "|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
                     	"|Lane|T/S\nPort|VVD|SOC|POR|POL|POD|DEL|S/I|Node|CMDT|Weight\n(Ton < = )|Weight\n( > Ton)|Direct\nCall|Bar Type" +
                		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,   daCenter,  true,	"ibflag");
	            InitDataProperty(0, cnt++ , dtData,	   			40,   daCenter,  true,	"chg_rule_def_cd",			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,				85,   daCenter,  true,	"eff_dt",  					false,	"",	dfDateYmd,			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,				85,   daCenter,  true,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			75,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,  	    	40,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,        		35,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,         	75,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,      	2,     true,       true,	9);
	            InitDataProperty(0, cnt++ , dtData,      		75,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     true,       true);
	            
	            InitDataProperty(0, cnt++ , dtData,   			35,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,  			35,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,   	    	40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     true,       true, 	3);
	            InitDataProperty(0, cnt++ , dtData,  			50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     true,       true,	3);
	            InitDataProperty(0, cnt++ , dtData,				60,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
	            InitDataProperty(0, cnt++ , dtData,				85,   daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     true,       true,	9);
	            InitDataProperty(0, cnt++ , dtData,				35,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     true,       true,	5);                     
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     true,       true,	5);
	            
	            InitDataProperty(0, cnt++ , dtData,    			65,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     true,       true,	5);
	            InitDataProperty(0, cnt++ , dtData,				150,  daCenter,  true,	"bkg_esvc_tp_cd",			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_yd_cd",     			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,    			70,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     true,       true,	6);
	            InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     true,       true,	4);
	            InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     true,       true,	4);
	            InitDataProperty(0, cnt++ , dtData,				45,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
	            InitDataProperty(0, cnt++ , dtData,   	 		55,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     true,       true);
	            
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_mapg_id");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_seq");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"svc_scp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"amdt_seq");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"prop_no");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"chg_rule_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_chg_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_rule_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_hdr_seq");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"note_conv_tp_cd");    
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_cmdt_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_por_tp_cd");
                
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_pol_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_pod_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_del_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_vsl_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_skd_voy_no");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_skd_dir_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"bkg_ts_port_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"amdt_seq");
                InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		false,	"prop_no");
            }
            break;
            
        case "sheet17":  // Rate(화면표시)
            with (sheetObj) {
                // 높이 설정
                style.height = 142;
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
                InitRowInfo(2, 1, 3, 100);
                
        		var HeadTitle1 = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Proposal|Proposal|Proposal|Proposal|C/Offer|C/Offer|C/Offer|C/Offer|Final|Final|Final|Final|Surcharge|Cost|Cost|CMPB|CMPB G/L|OPB|Diff|prs_pfit_cm_uc_amt|prs_pfit_cmpb_amt|prs_upd_dt|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|GRI|GRI|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord|||";
        		var HeadTitle2 = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Total|BOF|IHC|Diff.|Total|BOF|IHC|Diff.|Total|BOF|IHC|Diff.|Surcharge|Cost|Cost|CMPB|CMPB G/L|OPB|Diff|prs_pfit_cm_uc_amt|prs_pfit_cmpb_amt|prs_upd_dt|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|GRI|GRI|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord|||";
                var headCount = ComCountHeadTitle(HeadTitle1);
    
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false)
    
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 40, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rout_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "rt_seq", false, "", dfNone, 0, false, false);
                
                InitDataProperty(0, cnt++, dtCombo, 45, daCenter, true, "rat_ut_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo, 75, daCenter, true, "prc_cgo_tp_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo, 45, daCenter, true, "curr_cd", false, "", dfNone, 0, true, true);
                
                InitDataProperty(0, cnt++, dtData, 70, daRight,  true, "prop_frt_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  true, "prop_bof_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  true, "fic_prop_rt_amt", false, "", dfFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  true, "diff_prop_rt_amt", false, "", dfNone, 2, false, false, 9);
                
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "coffr_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "coffr_bof_amt", false, "", dfNone, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "fic_coffr_rt_amt", false, "", dfNullFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "diff_coffr_rt_amt", false, "", dfNone, 2, false, false, 9);
                
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "fnl_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "fnl_bof_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "fic_fnl_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtData, 70, daRight,  false, "diff_fnl_rt_amt", false, "", dfNone, 2, false, false, 9);
                
                InitDataProperty(0, cnt++, dtHidden, 65, daRight,  true, "prs_scg_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 65, daRight,  true, "prs_respb_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 65, daRight,  true, "prs_respb_opfit_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 65, daRight,  true, "prs_respb_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);;
                InitDataProperty(0, cnt++, dtHidden, 65, daRight,  true, "prs_gid_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 65, daRight,  true, "prs_respb_opb_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 65, daRight,  true, "diff", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 65, daRight,  false, "prs_pfit_cm_uc_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 65, daRight,  false, "prs_pfit_cmpb_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, dtHidden, 65, daCenter, false, "prs_upd_dt", false, "", dfDateYmd, 0, false, false);
                
                InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "next_n1st_cmnc_amdt_seq", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "src_info_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "src_info_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daCenter, true, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
                
                InitDataProperty(0, cnt++, dtData, 20, daCenter, true, "gri_appl_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "gri_appl_amt", false, "", dfNullFloat, 2, false, false);
                
                InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "acpt_dt", false, "", dfDateYmd, 0, false, false);
                                
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n2nd_ord_ref", false, "", dfNone, 0, false, false);               
                
                InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_gline_rt_amt", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_rt_use_sts_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "optm_trsp_mod_flg", false, "", dfNone, 0, false, false);
                
                InitDataCombo(0, "rat_ut_cd", ratUtCdText + unusedRatUtCd, ratUtCdValue + unusedRatUtCd, "D2", "D2", 0, "", "", ratUtCdText);
                InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCddValue, "DR");
                InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");
                
                Ellipsis = true;
                ShowButtonImage = 2;
                CountPosition = 0;
                FrozenCols = 11;
//                SetMergeCell(0, 1, 2, 1);
                SetMergeCell(0, 40, 2, 2);
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
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
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
    	changeSelectBackColor4Rate(sheetObj);
        doRowChange2(OldRow, NewRow, OldCol, NewCol);
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
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
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
        	origin_desc.innerHTML = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value
                		&& sheetObj.CellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_pnt_loc_def_nm");
                
                if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
                	sStr += "(" + arrTermOrg[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
                }
                if (sheetObj.CellValue(i, "prc_trsp_mod_cd") != null && sheetObj.CellValue(i, "prc_trsp_mod_cd") != "") {
                	sStr += "(" + arrTransMode[sheetObj.CellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                if ((sheetObj.CellValue(i, "loc_grd_cnt_cd") != null && sheetObj.CellValue(i, "loc_grd_cnt_cd") != "")
                		|| (sheetObj.CellValue(i, "loc_grd_cd") != null && sheetObj.CellValue(i, "loc_grd_cd") != "")) {
                	sStr += "(" + sheetObj.CellValue(i, "loc_grd_cnt_cd") + sheetObj.CellValue(i, "loc_grd_cd") + ")";
                }
                
            	if (document.form.amdt_seq.value != "0") {
            		if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value
            				|| sheetObj.CellValue(i, "src_info_cd") == "AD") {
                		sStr = "<s>" + sStr + "</s>";
            		} 
            		if (sheetObj.CellValue(i, "src_info_cd") == "AD") {
            			sStr += "(Deleted)";
            		}
            		if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
                		sStr = "<font color='red'>" + sStr + "</font>";
                	}
            	}
                
                sStr += "<br>";
                origin_desc.innerHTML += sStr;
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
        	ovia_desc.innerHTML = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value
                		&& sheetObj.CellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_via_port_def_nm");
                
            	if (document.form.amdt_seq.value != "0") {
            		if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value
            				|| sheetObj.CellValue(i, "src_info_cd") == "AD") {
                		sStr = "<s>" + sStr + "</s>";
            		} 
            		if (sheetObj.CellValue(i, "src_info_cd") == "AD") {
            			sStr += "(Deleted)";
            		}
            		if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
                		sStr = "<font color='red'>" + sStr + "</font>";
                	}
            	}
                
                sStr += "<br>";
                ovia_desc.innerHTML += sStr;
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
    function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	dvia_desc.innerHTML = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value
                		&& sheetObj.CellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_via_port_def_nm");
                
            	if (document.form.amdt_seq.value != "0") {
            		if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value
            				|| sheetObj.CellValue(i, "src_info_cd") == "AD") {
                		sStr = "<s>" + sStr + "</s>";
            		} 
            		if (sheetObj.CellValue(i, "src_info_cd") == "AD") {
            			sStr += "(Deleted)";
            		}
            		if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
                		sStr = "<font color='red'>" + sStr + "</font>";
                	}
            	}
                
                sStr += "<br>";
                dvia_desc.innerHTML += sStr;
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
    function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	dest_desc.innerHTML = "";
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	var sStr = "";
                if (sheetObj.RowStatus(i) == "D") {
                    continue;
                }
                if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value
                		&& sheetObj.CellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
                
                sStr += sheetObj.CellValue(i, "rout_pnt_loc_def_nm");
                
                if (sheetObj.CellValue(i, "rcv_de_term_cd") != null && sheetObj.CellValue(i, "rcv_de_term_cd") != "") {
                	sStr += "(" + arrTermDest[sheetObj.CellValue(i, "rcv_de_term_cd")] + ")";
                }
                if (sheetObj.CellValue(i, "prc_trsp_mod_cd") != null && sheetObj.CellValue(i, "prc_trsp_mod_cd") != "") {
                	sStr += "(" + arrTransMode[sheetObj.CellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                if ((sheetObj.CellValue(i, "loc_grd_cnt_cd") != null && sheetObj.CellValue(i, "loc_grd_cnt_cd") != "")
                		|| (sheetObj.CellValue(i, "loc_grd_cd") != null && sheetObj.CellValue(i, "loc_grd_cd") != "")) {
                	sStr += "(" + sheetObj.CellValue(i, "loc_grd_cnt_cd") + sheetObj.CellValue(i, "loc_grd_cd") + ")";
                }
                
            	if (document.form.amdt_seq.value != "0") {
            		if (sheetObj.CellValue(i, "amdt_seq") != document.form.amdt_seq.value
            				|| sheetObj.CellValue(i, "src_info_cd") == "AD") {
                		sStr = "<s>" + sStr + "</s>";
            		} 
            		if (sheetObj.CellValue(i, "src_info_cd") == "AD") {
            			sStr += "(Deleted)";
            		}
            		if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
                		sStr = "<font color='red'>" + sStr + "</font>";
                	}
            	}
                
                sStr += "<br>";
                dest_desc.innerHTML += sStr;
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
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        if (colName == "prc_cmdt_def_nm") {
            var sUrl = "/hanjin/ESM_PRI_2089.do?" + FormQueryString(document.form);
            ComPriOpenWindowCenter(sUrl, "ESM_PRI_2089", 900, 225, true);
        }

        if (colName == "cust_lgl_eng_nm") {
        	var sUrl = "/hanjin/ESM_PRI_2090.do?" + FormQueryString(document.form);
        	ComPriOpenWindowCenter(sUrl, "ESM_PRI_2090", 820, 210, true);
        }
        
        if (colName == "note_ctnt") {
        	var sUrl = "/hanjin/ESM_PRI_2084.do?" + FormQueryString(document.form) + "&select_row=" + sheetObjects[0].SelectRow;
            ComPriOpenWindowCenter(sUrl, "ESM_PRI_2084", 900, 600, true);
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
        
        var sUrl = "/hanjin/ESM_PRI_2088.do?" + FormQueryString(document.form);

        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            ComPriOpenWindowCenter(sUrl, "ESM_PRI_2025", 1000, 285, true);
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            ComPriOpenWindowCenter(sUrl, "ESM_PRI_2025", 1000, 285, true);
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            ComPriOpenWindowCenter(sUrl, "ESM_PRI_2025", 1000, 285, true);
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            ComPriOpenWindowCenter(sUrl, "ESM_PRI_2025", 1000, 285, true);
        }
        
        if (colName == "note_ctnt") {
            sUrl = "/hanjin/ESM_PRI_2085.do?" + FormQueryString(document.form);
            ComPriOpenWindowCenter(sUrl, "ESM_PRI_2024", 900, 480, true);
        }
    }
    
    var isFiredNested = false;
    var isFiredNestedExt = false;
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
            if (sheetObjects[0].IsDataModified
            		|| sheetObjects[3].IsDataModified
            		|| sheetObjects[4].IsDataModified
            		|| sheetObjects[5].IsDataModified) {
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
                    || sheetObjects[6].IsDataModified
                    || sheetObjects[7].IsDataModified
                    || sheetObjects[8].IsDataModified
                    || sheetObjects[9].IsDataModified
                    || sheetObjects[10].IsDataModified
                    || sheetObjects[11].IsDataModified) {
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
        
        if (!isFiredNested && !isFiredNestedExt && (OldRow != NewRow)) {
            if (sheetObjects[1].IsDataModified
                    || sheetObjects[2].IsDataModified
                    || sheetObjects[6].IsDataModified
                    || sheetObjects[7].IsDataModified
                    || sheetObjects[8].IsDataModified
                    || sheetObjects[9].IsDataModified
                    || sheetObjects[10].IsDataModified
                    || sheetObjects[11].IsDataModified) {
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
	            
	        case IBSEARCH: // 조회
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage("PRI01007");
	                return false;
	            }

	            if (sheetObj.id == "sheet1") {
	                for (var i = 0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                for (var i = 0; i < sheetObjects2.length; i++) {
	                    sheetObjects2[i].RemoveAll();
	                }
	                
	                formObj.f_cmd.value = SEARCH01;
	                var sXml = sheetObj.GetSearchXml("ESM_PRI_2041_10GS.do" , FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);    // Grid1.
	                if (arrXml.length > 1) sheetObjects[3].LoadSearchXml(arrXml[1]);    // Hidden. Grid1의 Commodity
	                if (arrXml.length > 2) sheetObjects[4].LoadSearchXml(arrXml[2]);    // Hidden. Grid1의 Actual Customer
	                if (arrXml.length > 3) sheetObjects[5].LoadSearchXml(arrXml[3]);    // Hidden. Grid1의 Commodity Note
	                if (arrXml.length > 4) sheetObjects[14].LoadSearchXml(arrXml[4]);   // Hidden. Grid1의 Commodity Note Conversion
	                
	                var griCnt = ComGetEtcData(arrXml[0], "gri_cnt");
	                if (parseInt(griCnt) > 0) {
	                	enableButton("btn_gricalc");
	                } else {
	                	disableButton("btn_gricalc");
	                }
	                
	            } else if (sheetObj.id == "sheet2") {
	                for (var i = 1; i < sheetObjects.length; i++) {
	                    if (i == 3 || i == 4 || i == 5 || i == 14) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                sheetObjects2[0].RemoveAll();
	                
	                origin_desc.innerHTML = "";
	                ovia_desc.innerHTML = "";
	                dvia_desc.innerHTML = "";
	                dest_desc.innerHTML = "";
	                
	                formObj.f_cmd.value = SEARCH02;
	                sheetObj.DoSearch("ESM_PRI_2041_10GS.do" , FormQueryString(formObj) + "&cmdt_row_seq=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "blet_dp_seq"));
	                
	            } else if (sheetObj.id == "sheet3" || sheetObj.id == "sheet17") {
	                for (var i = 2; i < sheetObjects.length; i++) {
	                	if (i == 3 || i == 4 || i == 5 || i == 14) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                
	                sheetObjects2[0].RemoveAll();
	                formObj.f_cmd.value = SEARCH03;
	                var sXml = sheetObj.GetSearchXml("ESM_PRI_2041_10GS.do" , FormQueryString(formObj));
	                var arrXml = sXml.split("|$$|");
	                
	                if (arrXml.length > 0) getRateSheet().LoadSearchXml(arrXml[0]);    // Grid3.
	                if (arrXml.length > 1) sheetObjects[6].LoadSearchXml(arrXml[1]);    // Hidden. Grid2의 Origin Point.
	                if (arrXml.length > 2) sheetObjects[7].LoadSearchXml(arrXml[2]);    // Hidden. Grid2의 Origin Via.
	                if (arrXml.length > 3) sheetObjects[8].LoadSearchXml(arrXml[3]);    // Hidden. Grid2의 Destination Via.
	                if (arrXml.length > 4) sheetObjects[9].LoadSearchXml(arrXml[4]);    // Hidden. Grid2의 Destination Point.
	                if (arrXml.length > 5) sheetObjects[11].LoadSearchXml(arrXml[5]);    // Hidden. Grid2의 Route Note.
	                if (arrXml.length > 6) sheetObjects[15].LoadSearchXml(arrXml[6]);    // Hidden. Grid2의 Route Note Conversion.

	                setSheet3Style(getRateSheet(), -1);
	                
	            }
	            break;
	            
	        case IBSEARCH_ASYNC08: // font type
	        	formObj.f_cmd.value = SEARCH04;
				var sXml = sheetObj.getSearchXml("ESM_PRI_2041_10GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
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

    
    function setSheet3Style(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	setLineStyle(sheetObj, i);
            }
        } else {
        	setLineStyle(sheetObj, idx);
        }
    }
    
    function setLineStyle(sheetObj, idx) {

    	if (idx <= 0) {
    		return false;
    	}
    	
    	if (sheetObj.RowStatus(idx) == "D") {
    		sheetObj.RowHidden(idx) = true;
    	}
    	
    	if (document.form.amdt_seq.value == "0") {
    		return true;
    	}
    	
    	if (sheetObj.CellValue(idx, "amdt_seq") != document.form.amdt_seq.value) {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = true;
			sheetObj.RowEditable(idx) = false;
			
			return true;
		} else {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = false;
			sheetObj.RowEditable(idx) = true;
    	}
    	
    	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
			sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
    	} else {
    		sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(0,0,0);
    	}
    	
    	changeSelectBackColor4Rate(sheetObj);
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
        
        if (sheetNo == 3 || sheetNo == 4) {
            sCol = "prop_no|svc_scp_cd|cmdt_hdr_seq";
            sValue = formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
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
        
        if (sheetNo == 3 || sheetNo == 4) {
            bAppendMode = 1;
            sCol = "prop_no|svc_scp_cd|cmdt_hdr_seq";
            sValue = formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
        }
        
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
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
    function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd) {
        var formObject = document.form;
        
        if (sSvcScpCd == null || sSvcScpCd == "") {
        	return;
        }
    
        if (formObject.prop_no.value != sPropNo
                || formObject.amdt_seq.value != sAmdtSeq
                || formObject.svc_scp_cd.value != sSvcScpCd) {
        	formObject.prop_no.value = sPropNo;
        	formObject.amdt_seq.value = sAmdtSeq;
            formObject.svc_scp_cd.value = sSvcScpCd;

            //Radio Checked
            funcSelectedRadio();
            comUpdateTypeFontStyle();
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            
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
    
    	formObject.prop_no.value = "";
    	formObject.amdt_seq.value = "";
        formObject.svc_scp_cd.value = "";
        
        for (var i = 0; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
        sheetObjects2[0].RemoveAll();
        
        origin_desc.innerHTML = "";
        ovia_desc.innerHTML = "";
        dvia_desc.innerHTML = "";
        dest_desc.innerHTML = "";
        
        var ficRtTpCd1 = document.getElementById("fic_rt_tp_cd1");
		var ficRtTpCd2 = document.getElementById("fic_rt_tp_cd2");
        ficRtTpCd1.style.fontWeight = "";
		ficRtTpCd1.style.color = "";
        ficRtTpCd2.style.fontWeight = "";
		ficRtTpCd2.style.color = "";
    }
    
    var enableFlag = true;
    function tabEnableSheet(flag) {
        var formObject = document.form;
    
        enableFlag = flag;
    
        sheetObjects[0].Editable = flag;
        sheetObjects[1].Editable = flag;
        sheetObjects[2].Editable = flag;
    }
    var loadSts = false;
 // 메인에서 호출한다.
 function loadFinishCheck(){
     return loadSts;
 } 
 
 ////////// add here
	/**
  * OnClick 이벤트 발생시 호출되는 function <br>
  * <br><b>Example :</b>
  * <pre>
  *	
  * </pre>
  * @return 없음
  * @author 김재연
  * @version 2009.07.30
  */
	function obj_click(){
		var formObj = document.form;
		if (event.srcElement.name == "fic_rt_tp_cd") {
			if(formObj.fic_rt_tp_cd[0].checked){
				formObj.bak_fic_rt_tp_cd.value = formObj.fic_rt_tp_cd[0].value;
			} else if (formObj.fic_rt_tp_cd[1].checked){
				formObj.bak_fic_rt_tp_cd.value = formObj.fic_rt_tp_cd[1].value;
			}
			sheetObjects[1].Reset();
			initSheet(sheetObjects[1], 0);
			
			controlSheetDisplay();
			var btnRetrieve = document.getElementById('btn_retrieve');
			btnRetrieve.fireEvent('onclick');
		}
	}
	
	/**
  * 조건에 맞는 Sheet를 표현하는 function <br>
  * <br><b>Example : controlSheetDisplay()</b>
  * <pre>
  *	
  * </pre>
  * @return 없음
  * @author 김재연
  * @version 2009.07.30
  */
	function controlSheetDisplay(){

		var formObj = document.form;
		var svcScpCd = formObj.svc_scp_cd.value;
		var mainTable = document.getElementsByName("mainTable");
		
		if(formObj.fic_rt_tp_cd[1].checked){
			mainTable[3].style.display = "none";
			mainTable[4].style.display = "";
		}else{
			mainTable[3].style.display = "";
			mainTable[4].style.display = "none";
		}
		
	}
	
 function funcSelectedRadio() {
 	var formObj = document.form;
 	formObj.f_cmd.value = SEARCH04;
 	var sXml = sheetObjects[0].getSearchXml("ESM_PRI_2041_10GS.do", FormQueryString(formObj));
		var arrDesc = ComPriXml2Array(sXml, "intg_cd_val_ctnt|font_style|tot_cnt");
		var g = false;
		var a = false;
			
		if (arrDesc != null && arrDesc.length > 0) {
			for(var i =0; i < arrDesc.length; i++) {
				if(arrDesc[i][0] == 'G' && arrDesc[i][1] == "blue") {
					g = true;
				} else if(arrDesc[i][0] == 'A' && arrDesc[i][1] == "blue") {
					a = true;
				} 				
			}
		}
		
		//라이디오 버튼 셀렉트
		if(!g && a) {
			formObj.bak_fic_rt_tp_cd.value = formObj.fic_rt_tp_cd[0].value;
			formObj.fic_rt_tp_cd[1].checked = true;
			formObj.fic_rt_tp_cd[1].fireEvent('onclick');					
		} else {
			formObj.bak_fic_rt_tp_cd.value = formObj.fic_rt_tp_cd[1].value;	
			formObj.fic_rt_tp_cd[0].checked = true;
			formObj.fic_rt_tp_cd[0].fireEvent('onclick');	
		}
 }
 
 /**
  * 타입 폰트 스타일 변경
  */
 function comUpdateTypeFontStyle() {
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC08);
 }
 
	/**	
	 * TYPE RADIO 버튼의 폰트색을 변경하는 function <br>
	 * 1) ALL ACCEPT일 경우는 파란색 <br>
	 * 2) AMEND할 건수가 존재할 경우 빨간색 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		setTypeFontStyle(sXml);
	 * </pre>
	 * @param {object} sXml 필수 Xml Object
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.30
	 */
	function setTypeFontStyle(sXml) {
		var arrDesc = ComPriXml2Array(sXml, "intg_cd_val_ctnt|font_style|tot_cnt");
		var ficRtTpCd1 = document.getElementById("fic_rt_tp_cd1");
		var ficRtTpCd2 = document.getElementById("fic_rt_tp_cd2");
		
		if (arrDesc != null && arrDesc.length > 0) {
			for(var i =0; i < arrDesc.length; i++) {
				var obj;
				if(arrDesc[i][0] == 'G') {
					obj = ficRtTpCd1;
				} else if(arrDesc[i][0] == 'A') {
					obj = ficRtTpCd2;
				}

				if(arrDesc[i][1] == "blue") {
					obj.style.fontWeight = "bold";
					obj.style.color = "blue";
				} else if(arrDesc[i][1] == "red") {
					obj.style.fontWeight = "bold";
					obj.style.color = "red";
				} else if(arrDesc[i][1] == "bold") {
					obj.style.fontWeight = "bold";
					obj.style.color = "black";
				} else {
					obj.style.fontWeight = "";
					obj.style.color = "black";
				}
			}
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
	 * @author 박성수
	 * @version 2009.04.17
	 */
 function initControl() {
     //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
//	    axon_event.addListener('mouseover', 'btn_calculate_OnMouseOver', 'btn_calculate');  
//     axon_event.addListener('mouseout', 'btn_calculate_OnMouseOut', 'btn_calculate');
     axon_event.addListenerForm  ('click', 'obj_click', form);
 }
 
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * Route Group 그리드 하단의 Location 상세정보 박스에 표시할 문자열을 조합하고, 표시해준다. Origin Point
	 * 
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.20
	 */
 function sheet17_OnSearchEnd(sheetObj, ErrMsg) {
 	var sRow = sheetObj.HeaderRows;
 	var eRow = sRow + sheetObj.RowCount;
 	
 	sheetObj.Redraw = false;
 	for(var i=sRow; i < eRow; i++) {
 		var ficGlineRtAmt = sheetObj.CellValue(i, "fic_gline_rt_amt"); //GuideLine 금약
 		var fnlFrtRtAmt = parseFloat(sheetObj.CellValue(i, "fnl_frt_rt_amt")); //final Total 금액
 		var coffrFrtRtAmt = parseFloat(sheetObj.CellValue(i, "coffr_frt_rt_amt")); //C.offer Total 금액
 		var ficPropRtAmt = parseFloat(sheetObj.CellValue(i, "fic_prop_rt_amt")); //Proposal IHc 금액
 		var propFrtRtAmt = parseFloat(sheetObj.CellValue(i, "prop_frt_rt_amt")); //Proposal Total 금액
 		
 		
 		if(ficGlineRtAmt == "" || ficGlineRtAmt == "N/A"){
 			ficGlineRtAmt =  "N/A";
 			sheetObj.CellValue2(i, "fic_gline_rt_amt") = ficGlineRtAmt;
 			sheetObj.CellValue2(i, "diff_prop_rt_amt") = ficGlineRtAmt;
 		} 
 		
 		//Proposal TOTAL 금액이 없을 경우 0으로 인식해줌.
			if(isNaN(propFrtRtAmt)) {
				propFrtRtAmt = 0;
			}
			
			//Proposal IHC금액이 공백이거나, 0인경우  Proposal Diff 금액을 N/A로 설정.
 		if(isNaN(ficPropRtAmt) || ficPropRtAmt == 0) {
 			ficPropRtAmt = 0;
 			sheetObj.CellValue2(i, "diff_prop_rt_amt") = 'N/A';
 		} 
 		
 		//Proposal IHC 금액이 0보다 큰경우, 
 		// Guide Line 금액이 N/A 가 아닌경우 Proposal Diff 를 계산
 		// Guide Line 금액이 N/A 인 경우 Proposal Diff를 N/A로 설정.
 		//  
 		if(ficPropRtAmt > 0) {
 			if(ficGlineRtAmt != "N/A") {
 				sheetObj.CellValue2(i, "diff_prop_rt_amt") = ComAddComma2((ComTrunc(ComTrunc(ficPropRtAmt, 2) - ComTrunc(ficGlineRtAmt, 2), 2)).toString(), "#,###.00");	
 			} else {
 				sheetObj.CellValue2(i, "diff_prop_rt_amt") = "N/A";	
 			}
 		}
 		
 		//Proposal bof 금액 설정 = Proposal Total 금액 - Proposal IHc 금액
 		sheetObj.CellValue2(i, "prop_bof_amt") = propFrtRtAmt - ficPropRtAmt;
 		
			// Final Total 금액이 있는 경우 Final Diff, Final Bof 설정    		
 		if(!isNaN(fnlFrtRtAmt)) {
	    		var ficFnlRtAmt = sheetObj.CellValue(i, "fic_fnl_rt_amt");  //Final IHC 금액
	    		//final Ihc 금액이 존재하는 경우 처리.
	    		if(ficFnlRtAmt != '')  {
	    			ficFnlRtAmt = parseFloat(ficFnlRtAmt);
					sheetObj.CellValue2(i, "fnl_bof_amt") = ComGetMaskedValue(ComTrunc(ComTrunc(fnlFrtRtAmt, 2) - ComTrunc(ficFnlRtAmt, 2), 2), "float");
					
					if(ficFnlRtAmt > 0) {
						if(ficGlineRtAmt != "N/A") {
							sheetObj.CellValue2(i, "diff_fnl_rt_amt") = ComAddComma2((ComTrunc(ComTrunc(ficFnlRtAmt, 2) - ComTrunc(ficGlineRtAmt, 2) ,2)).toString(), "#,###.00");
						} else {
							sheetObj.CellValue2(i, "diff_fnl_rt_amt") = "N/A";	
						}
					} else {
						sheetObj.CellValue2(i, "diff_fnl_rt_amt") = 'N/A';
					}
	    		}
 		}
	    		
			// C.Off Total 금액이 있는 경우 C.Off Diff, C.Off Bof 설정    		
 		if(!isNaN(coffrFrtRtAmt)) {
	    		var ficCoffrRtAmt = sheetObj.CellValue(i, "fic_coffr_rt_amt");  //C.offer IHC 금액
	    		//C.offer Ihc 금액이 존재하는 경우 처리.
	    		if(ficCoffrRtAmt != '')  {
	    			ficCoffrRtAmt = parseFloat(ficCoffrRtAmt);
					sheetObj.CellValue2(i, "coffr_bof_amt") = ComGetMaskedValue(ComTrunc(ComTrunc(coffrFrtRtAmt, 2) - ComTrunc(ficCoffrRtAmt, 2), 2), "float");
					
					if(ficFnlRtAmt > 0) {
						if(ficGlineRtAmt != "N/A") {
							sheetObj.CellValue2(i, "diff_coffr_rt_amt") = ComAddComma2((ComTrunc(ComTrunc(ficCoffrRtAmt, 2) - ComTrunc(ficGlineRtAmt, 2) ,2)).toString(), "#,###.00");
						} else {
							sheetObj.CellValue2(i, "diff_coffr_rt_amt") = "N/A";	
						}
					} else {
						sheetObj.CellValue2(i, "diff_coffr_rt_amt") = 'N/A';
					}
	    		}
 		}
 		sheetObj.RowStatus(i) = "R";
 	}
		sheetObj.Redraw = true;
 }
 
	/**
	 * Rate 대상 Sheet를 조회한다.
	 * <br><b>Example : getRateSheet()</b>
	 * 
	 * @return sheetObj
	 */
	function getRateSheet(){
		var formObj = document.form;
		if(formObj.fic_rt_tp_cd[1].checked){
			return sheetObjects2[0];
		}else{
			return sheetObjects[2];
		}
	}
/* 개발자 작업 끝 */