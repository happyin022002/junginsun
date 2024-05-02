/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0010.js
*@FileTitle  : Agent Commission Simulation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
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
   
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1=sheetObjects[0];
        var memoShtObj2=sheetObjects[1];
//        var memoShtObj3=sheetObjects[2];
        var t1shtObj1=sheetObjects[2];
        var t1shtObj2=sheetObjects[3];
        var frmObj=document.form;
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            if (srcName != "btn2_vvd_cd") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.vvd_cd);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_bl_no") {
                ACMMemoSheet_Close(memoShtObj2, frmObj.bl_no);    // CoAcm.js에 정의
            }
//            if (srcName != "btn2_agmt_no") {
//                ACMMemoSheet_Close(memoShtObj3, frmObj.agmt_no);    // CoAcm.js에 정의
//            }
            switch (srcName) {
                case "btn_calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal=new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;
                case "btn_retrieve":
                	if(frmObj.sim_no.value.trim() == "") {
                		doActionIBSheet(t1shtObj1, frmObj, IBSEARCH);
                	} else {
                		doActionIBSheet(t1shtObj1, frmObj, SEARCH02);
                	}
                    break;
                case "btn2_vvd_cd":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;
                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
                    break;
                case "btn2_agmt_no":
                    ACMMemoSheet_Open(memoShtObj3);    // CoAcm.js에 정의
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
                	var iCheckRow=t1shtObj1.CheckedRows("chk");
                	if (iCheckRow > 600) {
                		ComShowCodeMessage("COM12113", "less than 600 bookings!");    // Please select {?msg1}
                		return;
                	}
                	doActionIBSheet(t1shtObj1, frmObj, COMMAND01);
                	break;
                case "tab1btn_downexcel":         // TAB1 - Down Excel
                    if(t1shtObj1.RowCount() < 1){//no data
	        	     	ComShowCodeMessage("COM132501");
	        	    }else{
	        	    	doActionIBSheet(t1shtObj1, frmObj, IBDOWNEXCEL);
	        	    }
                    break;
                case "tab2btn_downexcel":         // TAB2 - Down Excel
                    if(t1shtObj2.RowCount() < 1){//no data
	        	     	ComShowCodeMessage("COM132501");
	        	    }else{
	        	    	doActionIBSheet(t1shtObj2, frmObj, IBDOWNEXCEL);
	        	    }
                    break;
                case "btn_smlt_popup":
                    //ComOpenPopup("ESM_ACM_0110.do", 495, 420, "setPopupData", "1,0", true, false, 0, 0, 6);
                	ComOpenPopup("ESM_ACM_0110.do?"+ FormQueryString(frmObj), 495, 420, "setPopupData", "1,0", true, false, 0, 0, 6);
                    break;
            } // end switch
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(shtObj) {
       sheetObjects[sheetCnt++]=shtObj;
    }
   /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tabObj){
        tabObjects[tabCnt++]=tabObj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var frmObj=document.form;
        for (var k=0; k<tabObjects.length; k++){
            initTab(tabObjects[k], k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        memo_sheet1_OnLoadFinish(sheetObjects[0]);
        memo_sheet2_OnLoadFinish(sheetObjects[1]);
        ACMMemoSheet_Open(sheetObjects[0]);    // CoAcm.js에 정의
        ACMMemoSheet_Open(sheetObjects[1]);    // CoAcm.js에 정의
        ACMMemoSheet_Close(sheetObjects[0], frmObj.vvd_cd);    // CoAcm.js에 정의
        ACMMemoSheet_Close(sheetObjects[1], frmObj.bl_no);    // CoAcm.js에 정의
        tab1sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj, tabNo) {
        with (tabObj) {
            var cnt=0 ;
            InsertItem( " Actual ", "");
            InsertItem( " Simulation Result ", "");
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
                    ACMMemoSheet_InitSheet(shtObj, "145");    // CoAcm.js에 정의
                    break;
                case "memo_sheet2":
                    ACMMemoSheet_InitSheet(shtObj, "130");    // CoAcm.js에 정의
                    break;
                case "tab1sheet1":
                case "tab2sheet1":
                    var cnt=0;
                    document.form.pagerows.value=500;
                    var HeadTitle0="STS|CHK|No.|BKG No.|B/L No.|BND|R.VVD|Comm.\nVVD|Comm.\nLane|S/A\nDate|Comm.\nLocation|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                    "Deduction|Deduction|Deduction|Deducted\nRevenue|Pre\nAMT\n(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Calculation|Calculation|BDR|Remarks";
                    var HeadTitle1="STS||No.|BKG No.|B/L No.|BND|R.VVD|Comm.\nVVD|Comm.\nLane|S/A\nDate|Comm.\nLocation|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                    "CHG|TRS|Special Comp.|Deducted\nRevenue|Pre\nAMT\n(USD)|General|SWA BRKG|CHF|CSF|RCSF|T/S|Cross|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Date|Time|BDR|Remarks";
                    SetEditEnterBehavior("tab");
                    SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:0 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"},
                                    { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                           {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                           {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                           {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rev_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"comm_vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ac_rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sail_arr_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ac_occr_info_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ac_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",   	  Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_qty",            KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rev_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"crnt_rev_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ddct_chg_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ddct_trsp_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"ddct_spcl_cmpn_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"post_rev_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ppd_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"general_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"brog_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"chf_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"csf_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rcsf_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cross_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"usd_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pay_xch_rt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pay_if_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ac_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cre_tm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ac_proc_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    InitColumns(cols);
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetHeaderRowHeight(24);
                    SetSheetHeight(400);
                    break;

            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd", "agn_cd", "ac_sts_cd");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // Final Office 목록 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH13);
            	ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
//                ACMXml2SelectItem(xmlStr, frmObj.agn_cd, "value0", "value0", true);
                break;
            case IBSEARCH:       // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                shtObj.DoSearch("ESM_ACM_0010GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case SEARCH02:       // 조회 - Simulation Result
//            	if (!ComChkValid(frmObj)) return;
            	ComOpenWait(true);
            	frmObj.f_cmd.value=SEARCH02;
            	sheetObjects[3].DoSearch("ESM_ACM_0010GS.do", FormQueryString(frmObj), {Sync:2} );
            	ComOpenWait(false);
            	break;
            case COMMAND01:       // Start Simulation
                ComOpenWait(true);
                // Simulation No. 조회
                frmObj.f_cmd.value=SEARCH03;
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0010GS.do", FormQueryString(frmObj));
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                ComSetObjValue(frmObj.sim_no, ComGetEtcData(xmlStr, "sim_no"));
                frmObj.f_cmd.value=COMMAND01;
                shtObj.DoSave("ESM_ACM_0010GS.do", FormQueryString(frmObj), "chk", false);
//                ComOpenWait(false);
            	break;
            case IBDOWNEXCEL:    // 엑셀다운로드
                ComOpenWait(true);
                if(shtObj.RowCount() < 1){//no data
                	ComShowCodeMessage("COM132501");
                	}else{
                		 //shtObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
                		 shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                	}

               
                ComOpenWait(false);
                break;
        }
    }
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * (***** 기본 Event (중요) *****)
     */
    function tab1_OnChange(tabObj, nItem) {
        var objs=document.all.item("tabLayer");
        objs[nItem].style.display="Inline";
        objs[beforetab].style.display="none";
        objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1;
        beforetab=nItem;
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
             if (RowCount()> 0) {
                 ReDraw=false;
                 SetCellText(LastRow(), "seq" ,"");
                 SetCellText(LastRow(), "bkg_no" ,"TOTAL");
                 SetCellAlign(LastRow(), "bkg_no","Center");
                 ReDraw=true;
             }
         }
         tabObjects[0].SetSelectedIndex(0);//"Actual" Tab 보여주기
     }
     /**
      * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
      * @param {shtObj} String : 해당 IBSheet Object
      * @param {ErrMsg} String : 조회 후 메시지
      */
     function tab2sheet1_OnSearchEnd(shtObj, ErrMsg) {
    	 if (ErrMsg != "") return;
    	 with (shtObj) {
    		 if (RowCount()> 0) {
    			 ReDraw=false;
    			 SetCellText(LastRow(), "seq" ,"");
    			 SetCellText(LastRow(), "bkg_no" ,"TOTAL");
    			 SetCellAlign(LastRow(), "bkg_no","Center");
    			 ReDraw=true;
    		 }
    	 }
    	 tabObjects[0].SetSelectedIndex(1);//"Simulation Result" Tab 보여주기
     }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function tab1sheet1_OnSaveEnd(shtObj, ErrMsg) {
    	ComOpenWait(false);
        if (ErrMsg != "") return;
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
        doActionIBSheet(shtObj, document.form, SEARCH02);
    }
    
    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName=ComGetEvent("name");
        var shtObj=sheetObjects[0];
        var shtObj1=sheetObjects[1];
        var formObj = document.form;
        
        switch (elementName) {
        case "ar_ofc_cd":
            if (formObj.ar_ofc_cd.value == "") {
                ComClearCombo(formObj.agn_cd);
                return;
            }
             var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + formObj.ar_ofc_cd.value);
            if (ACMXml2SelectItem(xmlStr, formObj.agn_cd, "value0", "value0", false)) {
                // option이 하나 이상이라면
                if (formObj.agn_cd.options.length > 1) {
                    // ar_ofc_cd와 같은 값이 선택되게 함
                	formObj.agn_cd.value = formObj.ar_ofc_cd.value;
                }
                ComFireEvent(formObj.agn_cd , "change");
            }
//            shtObj.RemoveAll();
//            shtObj1.RemoveAll();
            break;
            /*
        case "agn_cd":    //Sub Office변경 시 ASA No와 Vendor값 세팅
             var xmlStr=shtObj.GetSearchData("ESM_ACM_0009GS.do", "f_cmd=" + SEARCH16 + "&agn_cd=" + formObj.agn_cd.value).split("|$$|");
             if( typeof(xmlStr) == "object" ) xmlStr = xmlStr[0];
             
            //ASA_NAME 콤보 셋팅
            if (ACMXml2SelectItem(xmlStr, document.form.asa_no, "asa_name", "asa_no")) {
            	ComFireEvent(formObj.asa_no , "change");
            } else {
                //오늘 날짜로 세팅
            	formObj.inv_dt.value=ComGetNowInfo();
            }
            //VNDR_CODE, VNDR_NAME 셋팅
            formObj.vendor_name.value="[" + ComGetEtcData(xmlStr, "vndr_code") +"] " + ComGetEtcData(xmlStr, "vndr_name");
            shtObj.RemoveAll();
            shtObj1.RemoveAll();
            break;
        case "ac_sts_cd":
        	formObj.date_div_disp.value = formObj.ac_sts_cd.options[formObj.ac_sts_cd.selectedIndex].text;
            shtObj.RemoveAll();
            shtObj1.RemoveAll();
            break;
            */
        }
    }