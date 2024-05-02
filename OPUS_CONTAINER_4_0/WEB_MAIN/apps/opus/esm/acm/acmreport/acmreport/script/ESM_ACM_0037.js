/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0037.js
*@FileTitle  : Commission Report
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
     * @author 
     */
    /**
     * @extends
     * @class ESM_ACM_0037 : ESM_ACM_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
 
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
        var shtObj=sheetObjects[1];
        var shtObj2=sheetObjects[2];
        var frmObj=document.form;
            var srcName=ComGetEvent("name");
            if (srcName != "btn2_bl_no") {
                ACMMemoSheet_Close(memoShtObj1, frmObj.bl_no);    // CoAcm.js에 정의
            }
            switch (srcName) {
                case "btn_calendar":
                	 //var cal=new ComCalendar();
                     //cal.select(document.form.fm_dt, 'yyyy-MM-dd');
                     if (!window.event.srcElement.disabled) {
                         var cal=new ComCalendarFromTo();
                         cal.select(frmObj.fm_dt, frmObj.to_dt, "yyyy-MM-dd");
                     }
                    break;
                case "btn_retrieve":
                    if (ComGetUnMaskedValue(ComGetDateAdd(frmObj.fm_dt.value, "M", 6), "ymd") < ComGetUnMaskedValue(frmObj.to_dt.value, "ymd")) {
                    	ComShowCodeMessage("COM132001","Period","6 months");
                        frmObj.fm_dt.focus();
                        return;
                    }
    				if(tabObjects[0].GetSelectedIndex()==0){
                      doActionIBSheet(shtObj, frmObj, IBSEARCH);
     				}else if(tabObjects[0].GetSelectedIndex()==1){
     				  doActionIBSheet(shtObj2, frmObj, SEARCH03);
     				}
                    break;
                    
                case "btn_downexcel":
                	if(shtObj.RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
                	}else{
                        ComOpenWait(true);
        				if(tabObjects[0].GetSelectedIndex()==0){
        					shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
           				}else if(tabObjects[0].GetSelectedIndex()==1){
           					shtObj2.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj2), SheetDesign:1,Merge:1 });
           				}
                        ComOpenWait(false);
                	}
                	break;
                case "btn_bkg_ofc_popup":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_071.do", 700, 515, "setPopupData_bkgOfcCd", "1,0,1,1,1,1,1", true);
                    break;
                case "btn_ob_sls_ofc_popup":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_071.do", 700, 515, "setPopupData_obSlsOfcCd", "1,0,1,1,1,1,1", true);
                    break;
                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;
                case "btn_rpt_itm_popup":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0118.do", 608, 540, "", "1,0,1,1,1,1,1", false);
                    break;
            }
    }    
    
    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     */
    function setPopupData_bkgOfcCd(aryPopupData) {
        if (aryPopupData.length > 0 ) {
            document.form.bkg_ofc_cd.value=aryPopupData[0][3];
        }
    }
    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     */
    function setPopupData_obSlsOfcCd(aryPopupData) {
        if (aryPopupData.length > 0 ) {
            document.form.ob_sls_ofc_cd.value=aryPopupData[0][3];
        }
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
        memo_sheet1_OnLoadFinish(memo_sheet1);
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
        sheet1_OnLoadFinish(sheet1);        
    }
    
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj, tabNo) {
        with (tabObj) {
            var cnt=0 ;
            InsertItem( " By Customized Form ", "");
            InsertItem( " By Container No. ", "");
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
                    ACMMemoSheet_InitSheet(shtObj, "130");    // CoAcm.js에 정의
                    break;
                case "sheet1":
                    var cnt=0;
                    document.form.pagerows.value=500;
                    var HeadTitle="B/L No.|BKG No.|BND|VVD|S/A date|POR|POL|POD|DEL|TEU/FEU|FAC|General|Brokerage|CHF|CSF|RCSF|T/S|Cross|Deduction|USD AMT|Curr|Calc Date|RQST Date|Approval Date|I/F Date|PPD OFT|CCT OFT|" +
                    "PPD Charge|CCT Charge|Net O/Rev|Gross Rev|PYMT AMT|F.Forwarder|F.F NAME|F.F ADDR|Trade|Lane|Direction|TEU|FEU|Audit No.";
                    (ComCountHeadTitle(HeadTitle), 0, 0, false);
                    SetEditEnterBehavior("tab");
//                    SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:0, Page:20, DataRowMerge:0 } );
                    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bl_no" },
                                 {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
                                 {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd" },
                                 {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"comm_vvd" },
                                 {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"sail_arr_dt" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_cd" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd" },
                                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"teu_feu" },
                                 {Type:"Float",    Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"fac_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"com_i",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"brokerage_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"chf_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"csf_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rcsf_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cross_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ddct_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"usd_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
                                 {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"calc_dt" },
                                 {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt" },
                                 {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"apro_dt" },
                                 {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"if_dt" },
                                 {Type:"Float",    Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ppd_frt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"clt_frt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ppd_otr_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"clt_otr_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"net_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"gross_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pymt_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ff_cd" },
                                 {Type:"Text",     Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ff_name" },
                                 {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ff_addr" },
                                 {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd" },
                                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd" },
                                 {Type:"Float",    Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"teu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"feu",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Text",     Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"aud_no" } ];
                    InitColumns(cols);
                    SetSheetHeight(385); 
                    SetEditable(0);
                    SetWaitImageVisible(0);
                    break;
                case "sheet2":
                    var cnt=0;
                    document.form.pagerows.value=500;
                    var HeadTitle="B/L No.|BKG No.|Container No|Type Size|BND|VVD|S/A date|Office|POR|POL|POD|DEL|CHF|CSF|RCSF|USD AMT|Curr|Calc Date|RQST Date|Approval Date|I/F Date|Trade|Lane|Direction|Audit No.";
                    (ComCountHeadTitle(HeadTitle), 0, 0, false);
                    SetEditEnterBehavior("tab");
                    SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:0, Page:20, DataRowMerge:0 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bl_no" },
                                 {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
                                 {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd" },                                 
                                 {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd" },                           
                                 {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"comm_vvd" },
                                 {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"sail_arr_dt" },
                                 {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agn_cd" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_cd" },                           
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd" },
                                 {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"chf_amt" ,       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"csf_amt" ,       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rcsf_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                                 {Type:"Float",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"usd_amt",        KeyField:0,   CalcLogic:"|chf_amt|+|csf_amt|+|rcsf_amt|",   Format:"Float",       PointCount:2 },
                                 {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
                                 {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"calc_dt" },
                                 {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt" },
                                 {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"apro_dt" },
                                 {Type:"Text",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"if_dt" },                           
                                 {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd" },
                                 {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd" },
                                 {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd" },                           
                                 {Type:"Text",     Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"aud_no" } ];
                    InitColumns(cols);
                    SetSheetHeight(385); 
                    SetEditable(0);
                    SetWaitImageVisible(0);
                    break;
            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
        // axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd", "s_trd_cd", "slct_itm_fom_seq");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:
                // Customized RPT Form 목록 조회
            	var xmlStr2=shtObj.GetSearchData("ESM_ACM_0037GS.do", "f_cmd=" + SEARCH01);
                ACMXml2SelectItem(xmlStr2, frmObj.slct_itm_fom_seq, "slct_itm_fom_desc", "slct_itm_fom_seq", true);
               // document.form.slct_itm_fom_seq.fireEvent("onchange");
                break;
            case SEARCH02:
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                // Trade 목록 조회
                var xmlStr2=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH24);
                ACMXml2SelectItem(xmlStr2, frmObj.s_trd_cd, "value0", "value0", true);
                break;
            case IBSEARCH:    // 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCHLIST01;
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0037GS.do", FormQueryString(frmObj), {Sync:1});
                backEndJobKey=ComGetEtcData(xmlStr, "backendjob_key")    // 전역변수로 setting
                if (backEndJobKey != "") {
                    shtObj.SetWaitTimeOut(20000);
                    timer=setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
                }
                break;
            case SEARCH03:    // by Container No. 조회
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCHLIST04;
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0037GS.do", FormQueryString(frmObj), {Sync:1});
                backEndJobKey=ComGetEtcData(xmlStr, "backendjob_key")    // 전역변수로 setting
                if (backEndJobKey != "") {
                    shtObj.SetWaitTimeOut(20000);
                    timer=setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
                }            	
//            	if (!ComChkValid(frmObj)) return;
//            	ComOpenWait(true);
//            	frmObj.f_cmd.value=SEARCHLIST04;
//                shtObj.DoSearch("ESM_ACM_0037GS.do", FormQueryString(frmObj), {Sync:2} );
//                ComOpenWait(false);
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
 	 function sheet1_OnLoadFinish(shtObj) {
         // 조회조건의 Office Select Object 생성
         doActionIBSheet(shtObj, document.form, SEARCH01);
     }    
    /**
     * BackEndJob 호출함수
     */
    function getBackEndJobStatus() {
		var shtObj = sheetObjects[1];
		if(tabObjects[0].GetSelectedIndex()==0){
			shtObj = sheetObjects[1];
		}else{
			shtObj = sheetObjects[2];			
		}	
        var xmlStr=shtObj.GetSearchData("ESM_ACM_0037GS.do", "f_cmd=" + SEARCHLIST02 + "&backendjob_key=" + backEndJobKey);
        var jbStsFlg=ComGetEtcData(xmlStr, "jb_sts_flg")
        if (jbStsFlg == "3") {
        	shtObj.LoadSearch
        	shtObj.DoSearchFx("ESM_ACM_0037GS.do", "f_cmd=" + SEARCHLIST03 + "&backendjob_key=" + backEndJobKey );
            clearInterval(timer);
            backEndJobKey="";
            ComOpenWait(false);
        } else if (jbStsFlg == "4") {
            clearInterval(timer);
            backEndJobKey="";
            ComOpenWait(false);
            ComShowCodeMessage("COM130406", "using Back End Job");
        } else if (jbStsFlg == "5") {
            clearInterval(timer);
            backEndJobKey="";
            ComOpenWait(false);
            ComShowCodeMessage("ACM00029");
        }
    }


    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
   function sheet1_OnLoadFinish(shtObj) {
         doActionIBSheet(shtObj, document.form, SEARCH01);
         doActionIBSheet(shtObj, document.form, SEARCH02);
     }
   
   
   function sheet1_OnSearchEnd(sheetObj,Code, Msg) {
	   var cRow = sheetObj.LastRow();
	    
	   if(sheetObj.GetCellValue(cRow,"bl_no")=="" && cRow==1){
		   var noData = "<?xml version='1.0' ?><SHEET><DATA></DATA><RESULT CODE='0' MESSAGE='조회가 완료되었습니다.'></RESULT></SHEET>";
		   sheetObj.LoadSearchData(noData);
//		   sheetObj.RowDelete(cRow, 0);
	   }
	   
   }
   
   
   
    /**
     * Form Element의 OnChange 이벤트
     * Office선택 시 Sub Office가져오는 이벤트
     */
    function frmObj_OnChange() {
        var elementName=ComGetEvent("name");
        var shtObj=sheetObjects[1];
        with (document.form) {
            switch (elementName) {
                case "ar_ofc_cd":
                    if (ar_ofc_cd.value == "") {
                        ComClearCombo(agn_cd);
                        return;
                    }
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH09 + "&value0=" + ar_ofc_cd.value);
                    if (ACMXml2SelectItem(xmlStr, agn_cd, "value0", "value0", false)) {
                        if (agn_cd.options.length > 1) {
                            agn_cd.value=ar_ofc_cd.value;
                        }
                    }
                    break;
                case "s_trd_cd":
                    if (s_trd_cd.value == "") {
                        ComClearCombo(s_rlane_cd);
                        return;
                    }
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH25 + "&value0=" + s_trd_cd.value);
                    ACMXml2SelectItem(xmlStr, s_rlane_cd, "value0", "value0", true);
                    break;
                case "slct_itm_fom_seq":
                    shtObj.ReDraw=false;
                    shtObj.RemoveEtcData();
                    shtObj.RemoveAll();
                    var reportItem="";
                    if (slct_itm_fom_seq.value == "") {
                        for (var i=0; i<shtObj.LastCol()+1; i++) {
                            reportItem += (shtObj.ColSaveName(i) + "|");
                            shtObj.SetColHidden(i,0);
                        }
                        report_item.value="|" + reportItem;
                    } else {
                    	var xmlStr=shtObj.GetSearchData("ESM_ACM_0037GS.do", "f_cmd=" + SEARCH02 + "&slct_itm_fom_seq=" + slct_itm_fom_seq.value);
                        reportItem=ComGetEtcData(xmlStr, "report_item");
                        if (reportItem.length > 1) {
                            for (var i=0; i<shtObj.LastCol()+1; i++) {
                                if (reportItem.indexOf(shtObj.ColSaveName(i)) > -1) {
                                    shtObj.SetColHidden(i,0);
                                } else {
                                    shtObj.SetColHidden(i,1);
                                }
                            }
                            report_item.value=reportItem;
                        }
                    }
                    shtObj.FitColWidth("10|10|");
                    shtObj.ReDraw=true;
                    break;
            }
        }
    }