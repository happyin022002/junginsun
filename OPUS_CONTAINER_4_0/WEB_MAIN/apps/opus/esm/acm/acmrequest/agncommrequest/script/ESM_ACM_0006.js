/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_ACM_0006.js
*@FileTitle  : Agent Commission Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1=sheetObjects[0];
        var memoShtObj2=sheetObjects[1];
        var shtObj=sheetObjects[2];
        var frmObj=document.form;
//        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            if (srcName != "btn2_vvd_cd") {
            		//ACMMemoSheet_Close(memo_sheet1, frmObj.vvd_cd);    // CoAcm.js에 정의
            		ACMMemoSheet_Close(memoShtObj1, frmObj.vvd_cd);    // CoAcm.js에 정의
            }
            if (srcName != "btn2_bl_no") {
              	//ACMMemoSheet_Close(memo_sheet2, frmObj.bl_no);    // CoAcm.js에 정의
              	ACMMemoSheet_Close(memoShtObj2, frmObj.bl_no);    // CoAcm.js에 정의
            }
            switch (srcName) {
                case "btn_calendar":
                    if (!window.event.srcElement.disabled) {
                        var cal=new ComCalendarFromTo();
                        cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    }
                    break;
                case "btn_execprc":
                    if (ComShowConfirm("Do you want to execute?")) {
                        doActionIBSheet(shtObj, frmObj, MULTI01);
                    }
                    break;
                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_detail":
                    var sRow=shtObj.GetSelectRow();
                    if (sRow < 1) {
                        ComShowCodeMessage("COM12189");
                        return;
                    }
                    ComOpenPopup("ESM_ACM_0105.do?" + shtObj.RowSaveStr(sRow), 886, 610, "", "1,0,1,1,1,1,1", true, false, "", "", true);
                    break;
                case "btn_request":
                    var sRow=shtObj.CheckedRows("chk");
                    if (sRow < 1) {
                        ComShowCodeMessage("COM12189");
                        return;
                    }
                    doActionIBSheet(shtObj, frmObj, MULTI);
                    break;
                case "btn_exrate":
                    var sRow=shtObj.CheckedRows("chk");
                    if (sRow < 1) {
                        ComShowCodeMessage("COM12189");
                        return;
                    }
                    doActionIBSheet(shtObj, frmObj, MULTI02);
                    break;
                case "btn_calculate":
                    var sRow=shtObj.CheckedRows("chk");
                    if (sRow < 1) {
                        ComShowCodeMessage("COM12189");
                        return;
                    }
                    doActionIBSheet(shtObj, frmObj, COMMAND01);
                    break;
                case "btn_downexcel":
                	if(shtObj.RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                	}else{
                		ComOpenWait(true);
//                		shtObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
                		shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
                        ComOpenWait(false);
                	}
                	break;
                case "btn2_vvd_cd":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;
                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj2);    // CoAcm.js에 정의
                    break;
                case "btn2_check":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 1);    // CoAcm.js에 정의
                    break;
                case "btn2_uncheck":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 0);    // CoAcm.js에 정의
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
       sheetObjects[sheetCnt++]=shtObj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var frmObj=document.form;
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
        sheet1_OnLoadFinish(sheet1);// 메서드 존재시 반드시 참조
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
                    ACMMemoSheet_InitSheet(shtObj, "155");    // CoAcm.js에 정의
                    break;
                case "memo_sheet2":
                    ACMMemoSheet_InitSheet(shtObj, "130");    // CoAcm.js에 정의
                    break;
                case "sheet1":
                    var cnt=0;
                    document.form.pagerows.value=500;
                    var HeadTitle0="STS|CHK|No.|BKG No.|B/L No.|BND|R.VVD|Comm.\nVVD|TRADE|Sub.TRADE|Comm.\nLane|S/A\nDate|Port|POL|POR|POD|DEL|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                    "Deduction|Deduction|Deduction|Deducted\nRevenue|Pre\nAMT\n(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|Current AMT(USD)|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Calculation|Calculation|BDR|Remarks||";
                    var HeadTitle1="STS||No.|BKG No.|B/L No.|BND|R.VVD|Comm.\nVVD|TRADE|Sub.TRADE|Comm.\nLane|S/A\nDate|Port|POL|POR|POD|DEL|Seq|BKG\nSTS|CNTR\nQ'ty|Base|Non deducted\nRevenue|" +
                    "CHG|TRS|Special Comp.|Deducted\nRevenue|Pre\nAMT\n(USD)|General|SWA BRKG|CHF|CSF|RCSF|T/S|Cross|USD\nAmount|Ex.\nRate|Cur|Local\nAmount|Comm.\nStaus|Date|Time|BDR|Remarks||";
                    (ComCountHeadTitle(HeadTitle1), 6, 0, false);
                    SetEditEnterBehavior("tab");
                    SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:0 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                              {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                              {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rev_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"comm_vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ac_rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sail_arr_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ac_occr_info_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pol_cd" },
                              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"por_cd" },
                              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pod_cd" },
                              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"del_cd" },
                              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ac_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rev_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"crnt_rev_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ddct_chg_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ddct_trsp_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"ddct_spcl_cmpn_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"post_rev_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ppd_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"general_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"brog_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"chf_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"csf_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rcsf_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },                              
                              {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cross_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"usd_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pay_xch_rt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pay_if_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ac_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cre_tm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ac_proc_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agn_cd" },
                              {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"xch_rt_aply_lvl" } ];
                     
                    InitColumns(cols);
                    SetEditable(1);
                    SetSheetHeight(455);
                    SetEditableColorDiff(0);
                    SetWaitImageVisible(0);
                    SetHeaderRowHeight(24);
                    break;


            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력)  - CoAcm.js에 정의
        //axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        //axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
       // axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListenerForm("change", "frmObj_OnChange",document.form);
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:    // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
                 var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;
            case IBSEARCH:    // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                 shtObj.DoSearch("ESM_ACM_0006GS.do", FormQueryString(frmObj), {Sync:2} );
                shtObj.SetColFontUnderline("bkg_no",1);
                shtObj.SetColFontUnderline("bl_no",1);
                ComOpenWait(false);
                break;
            case MULTI:    // Request
                if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI;
                shtObj.DoSave("ESM_ACM_0006GS.do", FormQueryString(frmObj), "chk", false);
//                ComOpenWait(false);
                break;  
            case MULTI01:    // EXEC PRC
                if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI01;
                shtObj.DoSave("ESM_ACM_0006GS.do", FormQueryString(frmObj), "chk", false);
//                ComOpenWait(false);
                break;
            case MULTI02:    // Ex. Rate Input
//                if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI02;
                shtObj.DoSave("ESM_ACM_0006GS.do", FormQueryString(frmObj), "chk", false);
//                ComOpenWait(false);
                break;
            case COMMAND01:    // Calculate
//                if(!validateForm(shtObj,frmObj,sAction)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=COMMAND01;
                shtObj.DoSave("ESM_ACM_0006GS.do", FormQueryString(frmObj), "chk", false);
//                ComOpenWait(false);
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Office Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
     }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet1_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount()> 0) {
                ReDraw=false;
                SetCellText(LastRow(), "seq" ,"");
                SetCellText(LastRow(), "bkg_no" ,"TOTAL");
                SetCellAlign(LastRow(), "bkg_no","Right");
                ReDraw=true;
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnDblClick(shtObj, row, col){
        var sRow=shtObj.GetSelectRow();
        if (sRow < 1) {
            ComShowCodeMessage("COM12189");
            return;
        }
        // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
        ComOpenPopup("ESM_ACM_0105.do?" + shtObj.RowSaveStr(sRow), 886, 610, "", "1,0,1,1,1,1,1", true, false, "", "", true);
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        ComOpenWait(false);
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }
    /**
     * Form Element의 OnChange 이벤트
     * Office선택 시 Sub Office가져오는 이벤트
     */
    function frmObj_OnChange() {
        var elementName=ComGetEvent("name");
        var shtObj=sheetObjects[0];
        with (document.form) {
            switch (elementName) {
                case "ar_ofc_cd":
                    if (ar_ofc_cd.value == "") {
                        ComClearCombo(agn_cd);
                        return;
                    }
                     var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + ar_ofc_cd.value);
                    if (ACMXml2SelectItem(xmlStr, agn_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (agn_cd.options.length > 1) {
                            // ar_ofc_cd와 같은 값이 선택되게 함
                            agn_cd.value=ar_ofc_cd.value;
                        }
                    }
                    break;
            }
        }
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {Object} shtObj
     * @param {Object} formObj
     * @param {Object} sAction
     */
    function validateForm(shtObj, frmObj, sAction){
    	
        with(frmObj){
            switch(sAction) {
                case MULTI:    //Request
                	var chkRow = shtObj.FindCheckedRow("chk");         
                	
                    if (chkRow != "") {
                    	var chkRowArr = chkRow.split("|");
                    	
                        for (var i=0; i<chkRowArr.length; i++) {
                            // BL No.가 없을 때
                        	if (shtObj.GetCellValue(chkRowArr[i], "bl_no") == "") {
                                shtObj.SetCellValue(chkRowArr[i], "chk","0");
                                shtObj.ClearHeaderCheck();
                            }
                            // Advanced 부킹일 때
                        	if (shtObj.GetCellValue(chkRowArr[i], "bkg_sts_cd") == "A") {
                                shtObj.SetCellValue(chkRowArr[i], "chk","0");
                                shtObj.ClearHeaderCheck();
                            }
                            // Cancel 부킹이고 ac_seq가 1일때
                        	if (shtObj.GetCellValue(chkRowArr[i], "bkg_sts_cd") == "X" && shtObj.GetCellValue(chkRowArr[i], "ac_seq") == "1") {                                
                                shtObj.SetCellValue(chkRowArr[i], "chk","0");
                                shtObj.ClearHeaderCheck();
                            }                        	
                        	if (shtObj.GetCellValue(chkRowArr[i], "ac_sts_cd") != "CS") {
                                shtObj.SetCellValue(chkRowArr[i], "chk","0");
                                shtObj.ClearHeaderCheck();
                                
                            }
                        	if (shtObj.GetCellValue(chkRowArr[i], "pay_if_amt") == "0") {                                
                                shtObj.SetCellValue(chkRowArr[i], "chk","0");
                                shtObj.ClearHeaderCheck();
                            }
                        	if (shtObj.GetCellValue(chkRowArr[i], "bdr_flg") == "N") {
                        		shtObj.ClearHeaderCheck();
                            }
                        }
                        
                        for (var i=0; i<chkRowArr.length; i++) {
                            // BL No.가 없을 때
                        	if (shtObj.GetCellValue(chkRowArr[i], "bl_no") == "") {
                                ComShowCodeMessage("ACM00019", parseInt(chkRowArr[i]) -1);
                                //ComShowMessage(parseInt(chkRowArr[i])-1 + " row could not be requested! Because B/L No does not exist.\n\n Please check again.");                        
                                return false;
                            }
                            // Advanced 부킹일 때
                        	if (shtObj.GetCellValue(chkRowArr[i], "bkg_sts_cd") == "A") {
                                ComShowCodeMessage("ACM00020", "A");
                                //ComShowMessage("There is(are) ‘A’ status booking(s). Please exclude ‘A’ status booking(s).");                                
                                return false;
                            }
                            // Cancel 부킹이고 ac_seq가 1일때
                        	if (shtObj.GetCellValue(chkRowArr[i], "bkg_sts_cd") == "X" && shtObj.GetCellValue(chkRowArr[i], "ac_seq") == "1") {
                                ComShowCodeMessage("ACM00020", "X");
                                //ComShowMessage("There is(are) ‘X’ status booking(s). Please exclude ‘X’ status booking(s).");                                
                                return false;
                            }                        	
                        	if (shtObj.GetCellValue(chkRowArr[i], "ac_sts_cd") != "CS") {
                                ComShowCodeMessage("ACM00022");
                                //ComShowMessage("Please request CS status bookings only!");                                
                                return false;
                            }
                        	if (shtObj.GetCellValue(chkRowArr[i], "pay_if_amt") == "0") {
                                ComShowCodeMessage("ACM00023");
                                //ComShowMessage("Zero commission booking(s) exist(s). Please exclude zero commission booking(s) first!");                                
                                return false;
                            }
                        	if (shtObj.GetCellValue(chkRowArr[i], "bdr_flg") == "N") {                        		
                                ComShowCodeMessage("ACM00025");                                
                                //ComShowMessage("Bookings before BDR cannot be requested. Please exclude bookings before BDR.");
                                return false;
                            }
                        	if (shtObj.GetCellValue(chkRowArr[i], "bkg_sts_cd") == "W") {   
                                ComShowCodeMessage("ACM00020", "W");
                                //ComShowMessage("There is(are) ‘W’ status booking(s). Please exclude ‘W’ status booking(s).");
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
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function memo_sheet2_OnChange(shtObj, Row, Col, Value) {
    	var myElement =document.getElementById(shtObj.id.toString() + "_change");
    	myElement.textContent = "Y";
    	var formObj=document.form; 
    	var val = "";
        for (var i=shtObj.HeaderRows(); i<=shtObj.LastRow(); i++) {
       	 if (shtObj.GetCellValue(i, 1) != "") {
       		 val = "Y"
       	 }
        }
        if (val == "Y") {
        	formObj.date_fm.className="input";
        	formObj.date_fm.removeAttribute("required");
        	formObj.date_to.className="input";
        	formObj.date_to.removeAttribute("required");
        }else{
        	formObj.date_fm.className="input1";
        	formObj.date_fm.setAttribute("required", "");
        	formObj.date_to.className="input1";
        	formObj.date_to.setAttribute("required", "");        	
        }
    }
    
/* 개발자 작업 끝 */
