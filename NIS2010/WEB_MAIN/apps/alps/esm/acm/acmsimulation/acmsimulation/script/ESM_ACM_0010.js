/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0010.js
*@FileTitle : Agent Commission Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.10 김상수
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
     * @class ESM_ACM_0010 : ESM_ACM_0010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_ACM_0010() {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.initControl        = initControl;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
    }

/* 개발자 작업 */


    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1 = sheetObjects[0];
        var memoShtObj2 = sheetObjects[1];
        var t1shtObj1 = sheetObjects[2];
        var t1shtObj2 = sheetObjects[3];
        var frmObj = document.form;

//        try {

            var srcName = window.event.srcElement.getAttribute("name");
            
            if (srcName != "btn2_vvd_cd") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.vvd_cd);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_bl_no") {
                ACMMemoSheet_Close(memoShtObj2, frmObj.bl_no);    // CoAcm.js에 정의
            }

            switch (srcName) {
                case "btn_calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal = new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;

                case "btn_retrieve":
                	if(frmObj.sim_no.value.trim() == "") {
                		doActionIBSheet(t1shtObj1, frmObj, IBSEARCH);
                	} else {
                		doActionIBSheet(t1shtObj2, frmObj, SEARCH02);
                	}
                    break;

                case "btn2_vvd_cd":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;

                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
                    break;

                case "btn2_check":
                    ACMMultiRowCheck(t1shtObj1, frmObj.slct_start, frmObj.slct_end, 1);    // CoAcm.js에 정의
                    break;

                case "btn2_uncheck":
                    ACMMultiRowCheck(t1shtObj1, frmObj.slct_start, frmObj.slct_end, 0);    // CoAcm.js에 정의
                    break;
                    
                case "btn_simulation":	//Start Simulation
                	if(frmObj.sim_rmk.value == "") {
                		ComShowCodeMessage("COM130201", "Simulation Remark");    // Please input {?msg1}
                		return;
                	}
                	var iCheckRow = t1shtObj1.CheckedRows("chk");
                	if (iCheckRow > 600) {
                		ComShowCodeMessage("COM12113", "less than 600 bookings!");    // Please select {?msg1}
                		return;
                	}
                	doActionIBSheet(t1shtObj1, frmObj, COMMAND01);
                	break;

                case "tab1btn_downexcel":         // TAB1 - Down Excel
                    doActionIBSheet(t1shtObj1, frmObj, IBDOWNEXCEL);
                    break;

                case "tab2btn_downexcel":         // TAB2 - Down Excel
                    doActionIBSheet(t1shtObj2, frmObj, IBDOWNEXCEL);
                    break;

                case "btn_smlt_popup":
                    ComOpenPopup("ESM_ACM_0110.do", 495, 390, "setPopupData", "1,0,1,1,1,1,1", true, false, 0, 0, 6);
                    break;

            } // end switch

//        } catch(e) {
//            if (e == "[object Error]") {
//                ComShowMessage(OBJECT_ERROR);
//            } else {
//                ComShowMessage(e);
//            }
//        }
    }


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++] = shtObj;
    }


   /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tabObj){
        tabObjects[tabCnt++] = tabObj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var k=0; k<tabObjects.length; k++){
            initTab(tabObjects[k], k+1);
        }

        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        initControl();

        // tab1sheet1_OnLoadFinish 메서드 존재시 반드시 참조
    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj, tabNo) {
        with (tabObj) {
            var cnt = 0 ;
            InsertTab(cnt++, " Actual ", -1);
            InsertTab(cnt++, " Simulation Result ", -1);
        }
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        with (shtObj) {
            switch (shtObj.id) {

                case "memo_sheet1":
                case "memo_sheet2":
                    ACMMemoSheet_InitSheet(shtObj);    // CoAcm.js에 정의
                    break;

                case "tab1sheet1":
                case "tab2sheet1":
                    var cnt = 0;
                    // 높이 설정
                    style.height = GetSheetHeight(10);

                    // 전체 너비 설정
                    SheetWidth = mainTableT2S1.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
                    InitRowInfo(2, 1, 13, 500);
                    document.form.pagerows.value = 500;

                    // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
                    InitHeadMode(true, false, true, true, false, false);

                    // 컬럼 헤더타이틀
                    var HeadTitle0  = "STS|CHK|No.|BKG No.|B/L No.|BND|R.VVD|Comm.\nVVD|TRADE|Sub.TRADE|Comm.\nLane|S/A\nDate|Port|POL|POR|POD|DEL|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                                      "Deduction|Deduction|Deduction|Deducted\nRevenue|Pre\nAMT\n(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Calculation|Calculation|BDR|Remarks||";
                    var HeadTitle1  = "STS||No.|BKG No.|B/L No.|BND|R.VVD|Comm.\nVVD|TRADE|Sub.TRADE|Comm.\nLane|S/A\nDate|Port|POL|POR|POD|DEL|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                                      "CHG|TRS|Compensation|Deducted\nRevenue|Pre\nAMT\n(USD)|General|BRKG|CHF|T/S|Cross|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Date|Time|BDR|Remarks||";

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, false);

                    // Enter키를 눌렀을때 Tab키처럼 작동
                    EditEnterBehavior = "tab";

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    true,    "ibflag");    // [필수]
                    InitDataProperty(0, cnt++, dtDummyCheck,   30,     daCenter,    true,    "chk");
                    InitDataProperty(0, cnt++, dtDataSeq,      30,     daCenter,    true,    "seq");
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "bkg_no",              false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "bl_no",               false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "io_bnd_cd",           false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "rev_vvd_cd",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         90,     daCenter,    true,    "comm_vvd",            false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         55,     daCenter,    true,    "trd_cd",		        false,     "",    dfNone,    0,    false,     false);
					InitDataProperty(0, cnt++, dtData,         75,     daCenter,    true,    "sub_trd_cd",          false,     "",    dfNone,    0,    false,     false);                    
                    InitDataProperty(0, cnt++, dtData,         55,     daCenter,    true,    "ac_rlane_cd",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    true,    "sail_arr_dt",         false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "ac_occr_info_cd",     false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "pol_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "por_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "pod_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "del_cd");
                    InitDataProperty(0, cnt++, dtData,         30,     daCenter,    true,    "ac_seq",              false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "bkg_sts_cd",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "cntr_qty",            false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "rev_div_cd",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      90,     daRight,     true,    "crnt_rev_amt",        false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "ddct_chg_amt",        false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "ddct_trsp_amt",       false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "ddct_spcl_cmpn_amt",  false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      70,     daRight,     true,    "post_rev_amt",        false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "ppd_amt",             false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "general_amt",         false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "brog_amt",            false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "chf_amt",             false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "ts_amt",              false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     false,   "cross_amt",           false,     "",    dfFloat,   2,    false,     false);

                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "usd_amt",             false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "pay_xch_rt",          false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "curr_cd",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtAutoSum,      60,     daRight,     true,    "pay_if_amt",          false,     "",    dfFloat,   2,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,     daCenter,    true,    "ac_sts_cd",           false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         70,     daCenter,    false,   "cre_dt",              false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    false,   "cre_tm",              false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         40,     daCenter,    true,    "bdr_flg",             false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtData,         150,    daCenter,    true,    "ac_proc_desc",        false,     "",    dfNone,    0,    false,     false);
                    InitDataProperty(0, cnt++, dtHidden,       80,     daCenter,    true,    "agn_cd");
                    InitDataProperty(0, cnt++, dtHidden,       0,      daCenter,    true,    "xch_rt_aply_lvl");                    

                    ColIndent("cntr_qty") = 2;
                    ColIndent("crnt_rev_amt") = 2;
                    ColIndent("ddct_chg_amt") = 2;
                    ColIndent("ddct_trsp_amt") = 2;
                    ColIndent("ddct_spcl_cmpn_amt") = 2;
                    ColIndent("post_rev_amt") = 2;
                    ColIndent("ppd_amt") = 2;
                    ColIndent("general_amt") = 2;
                    ColIndent("brog_amt") = 2;
                    ColIndent("chf_amt") = 2;
                    ColIndent("ts_amt") = 2;
                    ColIndent("cross_amt") = 2;
                    ColIndent("usd_amt") = 2;
                    ColIndent("pay_if_amt") = 2;

                    WaitImageVisible = false;
                    CountPosition = 0;
                    HeadRowHeight = 24;

                    break;
            }
        }
    }


    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {

            case SEARCH01:       // Final Office 목록 조회
            	var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;

            case IBSEARCH:       // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value = SEARCH;
                shtObj.DoSearch("ESM_ACM_0010GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
                
            case SEARCH02:       // 조회 - Simulation Result
            	if (!ComChkValid(frmObj)) return;
            	ComOpenWait(true);
            	frmObj.f_cmd.value = SEARCH02;
            	shtObj.DoSearch("ESM_ACM_0010GS.do", FormQueryString(frmObj));
            	ComOpenWait(false);
            	break;
            	
            case COMMAND01:       // Start Simulation
//            	if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                // Simulation No. 조회
                frmObj.f_cmd.value = SEARCH03;
                var xmlStr = shtObj.GetSearchXml("ESM_ACM_0010GS.do", FormQueryString(frmObj));
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                ComSetObjValue(frmObj.sim_no, ComGetEtcData(xmlStr, "sim_no"));
                
                frmObj.f_cmd.value = COMMAND01;
                shtObj.DoSave("ESM_ACM_0010GS.do", FormQueryString(frmObj), "chk", false);
                
                ComOpenWait(false);
            	break;

            case IBDOWNEXCEL:    // 엑셀다운로드
                ComOpenWait(true);
                shtObj.Down2Excel(1, false, false, true, "", "", false, false, "", false, "chk|agn_cd|xch_rt_aply_lvl");
                ComOpenWait(false);
                break;
        }
    }

    
    /**
     * Form Element의 OnChange 이벤트
     * Office선택 시 Sub Office가져오는 이벤트
     */
    function frmObj_OnChange() {
        var elementName = window.event.srcElement.getAttribute("name");
        var shtObj = sheetObjects[2];
        with (document.form) {
            switch (elementName) {

                case "ar_ofc_cd":
                    if (ar_ofc_cd.value == "") {
                        ComClearCombo(agn_cd);
                        return;
                    }
                    var xmlStr = shtObj.GetSearchXml("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + ar_ofc_cd.value);
                    if (ACMXml2SelectItem(xmlStr, agn_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (agn_cd.options.length > 1) {
                            // ar_ofc_cd와 같은 값이 선택되게 함
                            agn_cd.value = ar_ofc_cd.value;
                        }
                    }
                    break;
            }
        }
    }
    
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * (***** 기본 Event (중요) *****)
     */
    function tab1_OnChange(tabObj, nItem) {
        var objs = document.all.item("tabLayer");
        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
        beforetab = nItem;
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
     function tab1sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Office Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
     }


     /**
      * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {ErrMsg} String : 조회 후 메시지
      */
     function tab1sheet1_OnSearchEnd(shtObj, ErrMsg) {
         if (ErrMsg != "") return;
         with (shtObj) {
             if (RowCount > 0) {
                 ReDraw = false;
                 CellText(LastRow, "seq") = "";
                 CellText(LastRow, "bkg_no") = "TOTAL";
                 CellAlign(LastRow, "bkg_no") = daCenter;
                 ReDraw = true;
             }
         }
         tabObjects[0].SelectedIndex = 0; //"Actual" Tab 보여주기
     }

     
     /**
      * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {ErrMsg} String : 조회 후 메시지
      */
     function tab2sheet1_OnSearchEnd(shtObj, ErrMsg) {
    	 if (ErrMsg != "") return;
    	 with (shtObj) {
    		 if (RowCount > 0) {
    			 ReDraw = false;
    			 CellText(LastRow, "seq") = "";
    			 CellText(LastRow, "bkg_no") = "TOTAL";
    			 CellAlign(LastRow, "bkg_no") = daCenter;
    			 ReDraw = true;
    		 }
    	 }
    	 tabObjects[0].SelectedIndex = 1; //"Simulation Result" Tab 보여주기
     }
     

    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function tab1sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
//        ComShowCodeMessage("ACM00001", "Data", "simulated");    // {?msg1} was {?msg2} successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
        doActionIBSheet(sheetObjects[3], document.form, SEARCH02);
    }


/* 개발자 작업 끝 */
