/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0034.js
*@FileTitle  : CSR Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1=sheetObjects[0];
        var shtObj=sheetObjects[1];
        var shtTotObj=sheetObjects[2];
        var frmObj=document.form;
//        try {
            var srcName=ComGetEvent("name");
            if (srcName != "btn2_csr_no") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.csr_no);    // CoAcm.js에 정의
            }
            switch (srcName) {
                case "btn_calendar":
                	var cal=new ComCalendarFromTo();
                    cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                    break;
                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_new":
                    ComResetAll();    //기본 object 초기화
                    frmObj_OnChange();
                    memo_sheet1_OnLoadFinish(memoShtObj1);
                    break;
                case "btn_detail":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                    break;
                case "btn_downexcel":
                    ComOpenWait(true);
                    shtObj.Down2Excel({ HiddenColumn:true, DownCols: makeHiddenSkipCol(shtObj), Merge:true, SheetDesign:1, TreeLevel:false});
                    ComOpenWait(false);
                    break;
                case "btn2_csr_no":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
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
        for (var i=0; i<sheetObjects.length; i++){
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i+1);
            // khlee-마지막 환경 설정 함수 추가
            if( sheetObjects[i].id != "memo_sheet1"){
            	ComEndConfigSheet(sheetObjects[i]);
            }
        }
        initControl();
        memo_sheet1_OnLoadFinish(memo_sheet1);
        sheet1_OnLoadFinish(sheet1);
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
                    ACMMemoSheet_InitSheet(shtObj,"190");    // CoAcm.js에 정의
                    break;
                case "sheet1":
                    var cnt=0;
                    document.form.pagerows.value=500;
                    var HeadTitle1="CHK|Office|CSR No.|Audit No.|CSR Detail|Acct. Code|USD AMT|Local AMT|Local AMT|R.VVD|Ex.Rate|Status|Creation Date|Approval Date|G/L Date|Payment Date|CSR Requested|CSR Requested|CSR Approved / Disapproved|CSR Approved / Disapproved";
                    var HeadTitle2="CHK|Office|CSR No.|Audit No.|CSR Detail|Acct. Code|USD AMT|Local AMT|Local AMT|R.VVD|Ex.Rate|Status|Creation Date|Approval Date|G/L Date|Payment Date|ID|Name|ID|Name";
                    SetEditEnterBehavior("tab");

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 4 } );

                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [ {Type:"Radio",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"check",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agn_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"aud_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inv_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"comm_stnd_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"if_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pay_if_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rev_vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"xch_rt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"status",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gl_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pay_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_usr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                     
                    InitColumns(cols);
                    SetSheetHeight(345);
                    SetEditable(1);
                    SetWaitImageVisible(0);
                    SetHeaderRowHeight(24);
                    break;
                case "sheet2": 
                	   var cnt=0;
                	   document.form.pagerows.value=500;
                	   var HeadTitle1="Local Total AMT|Local Total AMT|USD AMT";
                	   SetEditEnterBehavior("tab");

                	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                	   var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                	   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                	   InitHeaders(headers, info);

                	   var cols = [ {Type:"Float",     Hidden:0,  Width:90,  Align:"Right",   ColMerge:1,   SaveName:"pay_if_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                	                {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	                {Type:"Float",     Hidden:0,  Width:90,  Align:"Right",   ColMerge:1,   SaveName:"if_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
                	    
                	   InitColumns(cols);
                	   SetSheetHeight(105);
                	   SetEditable(0);
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
//        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
//        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
        axon_event.addListener("blur", "frmObj_OnBlur", "rev_vvd_cd");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:       // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;
            case IBSEARCH:       // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                var sXml=shtObj.GetSearchData("ESM_ACM_0034GS.do", FormQueryString(frmObj));
                var arrXml=sXml.split("|$$|");
                //데이터를 IBSheet에 세팅한다.
                sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
                sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01:       // Detail
                if (!ComChkValid(frmObj)) return;
                var sRow=shtObj.GetSelectRow();
                if(sRow < 0) {
                    ComShowCodeMessage("COM12189");
                    return;
                }
                var agn_cd=shtObj.GetCellText(sRow,"agn_cd");
                var csr_no=shtObj.GetCellText(sRow,"csr_no");
                var rev_vvd_cd=shtObj.GetCellText(sRow,"rev_vvd_cd");
                var comm_stnd_cost_cd=shtObj.GetCellText(sRow,"comm_stnd_cost_cd");
                var param="?agn_cd=" + agn_cd + "&csr_no=" + csr_no + "&rev_vvd_cd=" + rev_vvd_cd + "&comm_stnd_cost_cd=" + comm_stnd_cost_cd;
                ComOpenWindowCenter("ESM_ACM_0111.do" + param, "compop1", "800", "456", false);
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
 	 function sheet1_OnLoadFinish(shtObj) {
         doActionIBSheet(shtObj, document.form, SEARCH01);
     }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet2_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount()> 0) {
                ReDraw=false;
                document.form.usd_total.value=ComAddComma2(ComputeSum("|2|")+"", "#,###.00");
                ReDraw=true;
            } else {
                document.form.usd_total.value="";
            }
        }
    }
    /**
     * Form Element의 OnChange 이벤트
     * Office선택 시 Sub Office가져오는 이벤트
     */
    function frmObj_OnChange() {
        var elementName=ComGetEvent("name");
        if (elementName=="btn_new") elementName = "ar_ofc_cd";
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
            }
        }
    }
    /**
     * Form Element의 OnBlur 이벤트
     * R.VVD 유효성 체크
     */
    function frmObj_OnBlur() {
        var elementName=ComGetEvent("name");
        with (document.form) {
            switch (elementName) {
            case "rev_vvd_cd":
            	if(rev_vvd_cd.value =="")return;
                if( !/[A-Z]{4}[0-9]{4}[A-Z]{1,2}/.test(rev_vvd_cd.value) ) {
                    ComShowCodeMessage("COM132201", "R.VVD Code", "", "");
                    rev_vvd_cd.value = "";
                    rev_vvd_cd.focus();
                }
                break;
            }
        }
    }
/* 개발자 작업 끝 */
