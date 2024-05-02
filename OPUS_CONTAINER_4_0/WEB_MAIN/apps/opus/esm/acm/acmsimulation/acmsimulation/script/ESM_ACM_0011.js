/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0011.js
*@FileTitle  : Agent Commission Simulation Agreement Creation
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
     * @class ESM_ACM_0011 : ESM_ACM_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var t1s1chkRowIdx=-1;
    var t2s2chkRowIdx=-1;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var t1shtObj1=sheetObjects[0];
        var t2shtObj2=sheetObjects[2];
        var t2shtObj3=sheetObjects[3];
        var t3shtObj1=sheetObjects[8];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "tab1btn_retrieve":    // TAB1_Retrieve
                    doActionIBSheet(t1shtObj1, frmObj, IBSEARCH);
                    break;
                case "tab1btn_save":    // TAB1_Save
                    doActionIBSheet(t1shtObj1, frmObj, IBSAVE);
                    break;
                case "tab1btn_add":    // TAB1_Row Add
                    doActionIBSheet(t1shtObj1, frmObj, IBINSERT);
                    break;
                case "tab1btn_copy":    // TAB1_Copy
                    if (!ComChkValid(frmObj)) return;
                    var param="?agn_cd=" + frmObj.agn_cd.value;
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet)
                    ComOpenPopup("ESM_ACM_0115.do" + param, 910, 450, "", "1,0", true, false);
                    break;
//                case "rate_div":    // Compensation Rate의 radio버튼
//                    if (t2shtObj3.RowCount()< 1) return;
//                    if (frmObj.rate_div[1].checked) {
//                    	ACMCellEditable(t2shtObj3, "oft_pay_term_cd", "comm_fx_amt", false);    // CoAcm.js에 정의
//                    	ACMCellEditable(t2shtObj3, "comm_pay_term_cd", "comm_rt", true);    // CoAcm.js에 정의
//                        t2shtObj2.SetCellValue(t2s2chkRowIdx, "rate_div","R",0);
//                    } else {
//                    	ACMCellEditable(t2shtObj3, "comm_pay_term_cd", "comm_rt", false);    // CoAcm.js에 정의
//                    	ACMCellEditable(t2shtObj3, "oft_pay_term_cd", "comm_fx_amt", true);    // CoAcm.js에 정의
//                        t2shtObj2.SetCellValue(t2s2chkRowIdx, "rate_div","F",0);
//                    }
//                    break;
                case "tab2btn_add":    // TAB2_Row Add
                    // 신규 행추가는 한 row만 가능
                    if (t2shtObj2.RowCount("I") > 0) return;
                    for (var i=3; i<8; i++) {
                        sheetObjects[i].RemoveAll();
                    }
                    var t2s2newRowIdx=t2shtObj2.DataInsert(-1);
                    t2shtObj2.SetCellValue(t2s2newRowIdx, "rate_div","F",0);
                    t2shtObj2.SetCellValue(t2s2newRowIdx, "agn_agmt_no",t1shtObj1.GetCellValue(t1s1chkRowIdx, "agn_agmt_no"),0);
                    t2shtObj2.SetCellValue(t2s2newRowIdx, "agn_cd",t1shtObj1.GetCellValue(t1s1chkRowIdx, "agn_cd"),0);
                    // 신규 행추가와 동시에 CHK에 OnChange 이벤트
                    t2shtObj2.SetCellValue(t2s2newRowIdx, "chk","1");
                    break;
                case "tab2btn_delete":    // TAB2_Delete
                    // RowStatus만 Delete로
                    if (t2s2chkRowIdx > 0) {
                        if (ComShowCodeConfirm("ACM00006")) {    // "Selected agreement will be inactivated. Will you proceed?"
                            t2shtObj2.SetRowStatus(t2s2chkRowIdx,"D");
                        }
                    }
                    break;
                case "tab2btn_retrieve":    // TAB2_Retrieve
                    // TAB2의 내용을 조회하기 위해 TAB1 Sheet1의 OnChange이벤트를 발생
                    tab1sheet1_OnChange(t1shtObj1, t1s1chkRowIdx, t1shtObj1.SaveNameCol("chk"), "1");
                    break;
                case "tab2btn_save":    // TAB2_Save
                    doActionIBSheet(t2shtObj2, frmObj, MULTI01);
                    break;
                case "tab3btn_retrieve":    // TAB3_Retrieve
                    doActionIBSheet(t3shtObj1, frmObj, SEARCH03);
                    break;
            } // end switch
        } catch(e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
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
        tabObjects[0].SetTabDisable(1, true);    // Detail (Compensation) 탭 비 활성화
        // tab1sheet1_OnLoadFinish 메서드 존재시 반드시 참조
        tabObjects[0].SetTabDisable(1, true);
        // 화면을 load할 때, RHQ 코드 콤보생성
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
    }
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj, tabNo) {
        with (tabObj) {
            var cnt=0 ;
            InsertItem( " Master ", "");
            InsertItem( " Detail (Compensation) ", "");
            InsertItem( " Summary ", "");
        }
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var shtId=shtObj.id;
        with (shtObj) {
           document.form.pagerows.value=500;
            SetEditEnterBehavior("tab");
            InitComboNoMatchText(true);
            SetShowButtonImage(3);
            SetWaitImageVisible(0);
            switch (shtId) {
            case "tab1sheet1":
            	   var cnt=0;
            	   var HeadTitle0="STS|CHK|AGMT No.|Effective date|Effective date|Effective date|Effective date|Remark|Update Date|Update Date|Update User|DEL|agn_cd";
            	   var HeadTitle1="STS|CHK|AGMT No.|From|From|To|To|Remark|Local Time|GMT|Update User|DEL|agn_cd";
//            	   (ComCountHeadTitle(HeadTitle1), 0, 0, false);

            	   SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	   var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
            	   var headers = [ { Text:HeadTitle0, Align:"Center"},
            	                 { Text:HeadTitle1, Align:"Center"} ];
            	   InitHeaders(headers, info);

            	   var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	                {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
            	                {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agn_agmt_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Combo",     Hidden:0, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt_cd",  KeyField:1 },
            	                {Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd" },
            	                {Type:"Combo",     Hidden:0, Width:160,  Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt_cd",  KeyField:1 },
            	                {Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd" },
            	                {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"agn_agmt_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
            	                {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt_lcl",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt_gmt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg" },
            	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agn_cd" } ];
            	    
            	   InitColumns(cols);
            	  // style.height=GetSheetHeight(19);
            	   SetEditable(1);
            	   SetColProperty("agmt_fm_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
            	   SetColProperty("agmt_to_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
            	   SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
            	   SetSheetHeight(445);
            	   SetCountPosition(0);
            	   SetRangeBackColor(1,3,1,5,"#555555");
            	   SetRangeBackColor(1,7,1,9,"#555555");
            	   break;


            case "tab2sheet1":    // Selected Agreement
                var cnt=0;
                var HeadTitle0="STS|AGMT No.|Effective date|Effective date|Effective date|Effective date|Remark|DEL";
                var HeadTitle1="STS|AGMT No.|From|From|To|To|Remark|DEL";
                (ComCountHeadTitle(HeadTitle1), 0, 0, false);

                SetConfig( { SearchMode:2,MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle0, Align:"Center"},
                  { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		        {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agn_agmt_no" },
		        {Type:"Combo",    Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt_cd" },
		        {Type:"Date",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		        {Type:"Combo",    Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt_cd",  KeyField:0 },
		        {Type:"Date",     Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		        {Type:"Text",     Hidden:0,  Width:650,  Align:"Left",    ColMerge:1,   SaveName:"agn_agmt_rmk" },
		        {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg" } ];
                 
                InitColumns(cols);
             	SetEditable(0);
              	SetEditableColorDiff(0);
              	SetColProperty("agmt_fm_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
                SetColProperty("agmt_to_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
                SetSheetHeight(80, 1);
                SetRangeBackColor(1,2,1,5,"#555555");
            	SetCountPosition(0);
                break;


            case "tab2sheet2":    // Compensation Master
                var cnt=0;
                var HeadTitle="STS|CHK|SEQ|Bound|Account" +
                "|OFT Term|TP/SZ|Full/MT|Curr|Fixed AMT|Pay Term|Base|Rate|R. CHG|CHG|O. Haulage|D. Haulage|O. Feederage|D. Feederage" +
                "|por_1|por_2|por_3|por_4|por_lvl_cd|POR|pol_1|pol_2|pol_3|pol_4|pol_lvl_cd|POL|pod_1|pod_2|pod_3|pod_4|pod_lvl_cd|POD|del_1|del_2|del_3|del_4|del_lvl_cd|DEL" +
                "|Type|Covered Location|Office|rate_div|agn_cd|agn_agmt_no|agn_agmt_seq|agmt_dtl_pk";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);
                SetFocusAfterProcess(0);

                SetConfig( { SearchMode:2,MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				     {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
				     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				     {Type:"Combo",     Hidden:0, Width:54,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Combo",     Hidden:0, Width:102,  Align:"Center",  ColMerge:1,   SaveName:"ac_tp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"oft_pay_term_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"comm_fx_amt" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"comm_pay_term_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rev_div_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"comm_rt" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rep_chg_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_org_flg" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_dest_flg" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_org_flg" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_dest_flg" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_1" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_2" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_3" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_4" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_lvl_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_1" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_2" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_3" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_4" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_lvl_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_1" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_2" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_3" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_4" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_lvl_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_1" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_2" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_3" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_4" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_lvl_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_set_tp_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cvrg_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rate_div" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agn_cd" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agn_agmt_no" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agn_agmt_seq" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_dtl_pk" } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetColProperty("io_bnd_cd", {ComboText:ioBndText, ComboCode:ioBndCode} );
                SetColProperty("ac_tp_cd", {ComboText:"|"+acTpText, ComboCode:"|"+acTpCode} );
                SetSheetHeight(340);
                break;


            case "tab2sheet3":    // Compensation Rate (화면용)
                var cnt=0;
                var HeadTitle="STS|OFT Term|TP/SZ|Full/MT|Curr|Fixed AMT|Pay Term|Base|Rate(%)";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2,MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"oft_pay_term_cd" },
			     {Type:"Popup",     Hidden:0, Width:126,  Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd" },
			     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd" },
			     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			     {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"comm_fx_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
			     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"comm_pay_term_cd" },
			     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_div_cd" },
			     {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"comm_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3 } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetColProperty("oft_pay_term_cd", {ComboText:commPayTermText, ComboCode:commPayTermCode} );
                SetColProperty("full_mty_cd", {ComboText:fullMtyText, ComboCode:fullMtyCode} );
                SetColProperty("comm_pay_term_cd", {ComboText:commPayTermText, ComboCode:commPayTermCode} );
                SetColProperty("rev_div_cd", {ComboText:revDivText, ComboCode:revDivCode} );
                SetColProperty(0 ,"curr_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
//                SetColProperty("curr_cd", {ComboText:"USD|JPY", ComboCode:"USD|JPY"} );
                SetSheetHeight(53);
                SetCountPosition(0);
                //SetRangeBackColor(0,0,0,8,"#555555");
                break;


            case "tab2sheet4":    // Office Setting (화면용)
                var cnt=0;
                var HeadTitle="STS|Type|Covers|Office";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2,MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				  {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ofc_set_tp_cd" },
				  {Type:"Combo",     Hidden:0, Width:135,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cvrg_cd" },
				  {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
				                 
                InitColumns(cols);
                SetEditable(1);
                SetColProperty("ofc_set_tp_cd", {ComboText:ofcSetTpText, ComboCode:ofcSetTpCode} );
                SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
                SetColProperty(0 ,"ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
                SetSheetHeight(53);
                SetCountPosition(0);
                break;


            case "tab2sheet5":    // Route Setting (화면용)
                var cnt=0;
                var HeadTitle="STS|por_1|por_2|por_3|por_4|por_lvl_cd|POR|pol_1|pol_2|pol_3|pol_4|pol_lvl_cd|POL|pod_1|pod_2|pod_3|pod_4|pod_lvl_cd|POD|del_1|del_2|del_3|del_4|del_lvl_cd|DEL";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2,MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_1" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_2" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_3" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_4" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_lvl_cd" },
				     {Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"por" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_1" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_2" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_3" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_4" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_lvl_cd" },
				     {Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pol" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_1" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_2" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_3" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_4" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_lvl_cd" },
				     {Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pod" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_1" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_2" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_3" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_4" },
				     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_lvl_cd" },
				     {Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"del" } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetEditableColorDiff(0);
                SetSheetHeight(53);
                SetCountPosition(0);
             break;


            case "tab2sheet6":    // Charge/Surcharge Deduction Setting (화면용)
                var cnt=0;
                var HeadTitle="STS|Rep. Charge|Individual Charge/Surcharge";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);

                SetConfig( { SearchMode:2,MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				  {Type:"Popup",     Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"rep_chg_cd" },
				  {Type:"Popup",     Hidden:0, Width:400,  Align:"Left",    ColMerge:0,   SaveName:"chg_cd" } ];
                 
                InitColumns(cols);
            	SetEditable(1);
            	SetEditableColorDiff(0);
            	SetSheetHeight(53);
            	SetCountPosition(0);
             break;


            case "tab2sheet7":    // Haulage Deduction Setting (화면용)

                var cnt=0;
                var HeadTitle="STS|Origin Inland Haulage|Dest Inland Haulage|Origin Feederage|Dest Feederage";
                (ComCountHeadTitle(HeadTitle), 0, 0, false);
                SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:0 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				{Type:"CheckBox",  Hidden:0, Width:195,  Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_org_flg" },
				{Type:"CheckBox",  Hidden:0, Width:195,  Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_dest_flg" },
				{Type:"CheckBox",  Hidden:0, Width:195,  Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_org_flg" },
				{Type:"CheckBox",  Hidden:0, Width:195,  Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_dest_flg" } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetEditableColorDiff(0);
                SetSheetHeight(53);
                SetCountPosition(0);
               break;


            case "tab3sheet1":
            	   var cnt=0;
            	   var HeadTitle0="STS|CHK|Agreement No.|Effective date|Effective date|Effective date|Effective date|Remark|DEL|agn_cd";
            	   var HeadTitle1="STS|CHK|Agreement No.|From|From|To|To|Remark|DEL|agn_cd";
            	   (ComCountHeadTitle(HeadTitle1), 0, 0, false);

            	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	   var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
            	   var headers = [ { Text:HeadTitle0, Align:"Center"},
            	                 { Text:HeadTitle1, Align:"Center"} ];
            	   InitHeaders(headers, info);

            	   var cols = [ {Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	                {Type:"Radio",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
            	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agn_agmt_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"agmt_fm_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Combo",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"agmt_to_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:650,  Align:"Left",    ColMerge:1,   SaveName:"agn_agmt_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Combo",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agn_cd" } ];
            	    
            	   InitColumns(cols);
            	   SetEditable(1);
            	   SetEditableColorDiff(0);
            	   SetColProperty("agmt_fm_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
            	   SetColProperty("agmt_to_dt_cd", {ComboText:"|"+effDivText, ComboCode:"|"+effDivCode} );
            	   SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
            	   SetSheetHeight(160);
            	   SetRangeBackColor(1,3,1,5,"#555555");
            	   break;


            case "tab3sheet2":
                var cnt=0;
                var HeadTitle0="STS|Bound|Account|Fixed Base|Fixed Base|Fixed Base|Fixed Base|Fixed Base|Rate Base|Rate Base|Rate Base|Deduction|Deduction|Deduction|Deduction|Deduction|Deduction|Route Setting|Route Setting|Route Setting|Route Setting|Office Setting|Office Setting|Office Setting";
                var HeadTitle1="STS|Bound|Account|OFT Term|TP/SZ|Full/MT|Curr|Fixed AMT|Pay Term|Base|Rate|R. CHG|CHG|O. Haulage|D. Haulage|O. Feederage|D. Feederage|POR|POL|POD|DEL|Type|Covered Location|Office";
                (ComCountHeadTitle(HeadTitle1), 0, 0, false);

                SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:5 , Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle0, Align:"Center"},
                            { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd" },
                       {Type:"Combo",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"ac_tp_cd" },
                       {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"oft_pay_term_cd" },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                       {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd" },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd" },
                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"comm_fx_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
                       {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"comm_pay_term_cd" },
                       {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_div_cd" },
                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"comm_rt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3 },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rep_chg_cd" },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"chg_cd" },
                       {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_org_flg" },
                       {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"hlg_ddct_dest_flg" },
                       {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_org_flg" },
                       {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fdrg_ddct_dest_flg" },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por" },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol" },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod" },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del" },
                       {Type:"Combo",     Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"ofc_set_tp_cd" },
                       {Type:"Combo",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cvrg_cd" },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd" } ];
                 
                InitColumns(cols);
                SetEditable(0);
                SetColProperty("io_bnd_cd", {ComboText:ioBndText, ComboCode:ioBndCode} );
                SetColProperty("ac_tp_cd", {ComboText:acTpText, ComboCode:acTpCode} );
                SetColProperty("oft_pay_term_cd", {ComboText:commPayTermText, ComboCode:commPayTermCode} );
                SetColProperty("full_mty_cd", {ComboText:fullMtyText, ComboCode:fullMtyCode} );
                SetColProperty("comm_pay_term_cd", {ComboText:commPayTermText, ComboCode:commPayTermCode} );
                SetColProperty("rev_div_cd", {ComboText:revDivText, ComboCode:revDivCode} );
                SetColProperty("hlg_ddct_org_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
                SetColProperty("hlg_ddct_dest_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
                SetColProperty("fdrg_ddct_org_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
                SetColProperty("fdrg_ddct_dest_flg", {ComboText:"Y|N", ComboCode:"1|0"} );
                SetColProperty("ofc_set_tp_cd", {ComboText:ofcSetTpText, ComboCode:ofcSetTpCode} );
                SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
                SetSheetHeight(300);
                SetRangeBackColor(1,3,1,24,"#555555");
                break;


            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // OnChange 이벤트
    	var formObj=document.form;
        axon_event.addListenerForm("change", "frmObj_OnChange",formObj);
        axon_event.addListener("change", "frmObj_OnChange", "rhq_cd_disp");
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
        	
            case SEARCH01:       // RHQ 목록 조회
                // RHQ level과 목록 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH07);
                ACMXml2SelectItem(xmlStr, frmObj.rhq_cd_disp, "value0", "value0", true);    // CoAcm.js에 정의
                var rhqCd=ComGetEtcData(xmlStr, "rhq_cd");
                ofcKndCd=ComGetEtcData(xmlStr, "ofc_knd_cd");    // *** 반드시 전역변수로 setting에 유의 ***
                if (rhqCd == "") {
                    // 본사 User일 경우 (rhqCd가 Null로 조회)
                    frmObj.rhq_cd_disp.style.display="inline";    // hidden인 form.rhq_cd_disp가 보여지게 함
                    frmObj.rhq_cd.style.display="none";    // form.rhq_cd는 숨김
                } else {
                    frmObj.rhq_cd_disp.value=rhqCd;    // hidden상태 그대로 form.rhq_cd_disp에 rhqCd가 선택되게 하고
                    //frmObj.rhq_cd_disp.fireEvent("onchange");    // hidden상태 그대로 form.rhq_cd_disp에 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                    ComFireEvent(frmObj.rhq_cd_disp, "change");    // hidden상태 그대로 form.rhq_cd_disp에 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                }
                break;
            case IBSEARCH:       // TAB1_Retrieve / TAB3_Sheet1_Retrieve (TAB1, TAB3 둘다 조회 - TAB1에서 호출)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                // Sheet 전체 초기화
                for (var i=0; i<sheetObjects.length; i++){
                    sheetObjects[i].RemoveAll();
                }
                frmObj.f_cmd.value=SEARCH;
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0011GS.do", FormQueryString(frmObj));
                shtObj.LoadSearchData(xmlStr,{Sync:1} );
                sheetObjects[8].LoadSearchData(xmlStr,{Sync:1} );
                ComOpenWait(false);
                break;
            case IBINSERT:    // TAB1_Row Add
                // 신규 행추가는 한 row만 가능
                if (shtObj.RowCount("I") > 0) return;
                //if (!ComChkValid(frmObj)) return;
                frmObj.f_cmd.value=SEARCH02;
                var xmlStr=shtObj.GetSearchData("ESM_ACM_0011GS.do", FormQueryString(frmObj));
                if (ACMDecideErrXml(shtObj, xmlStr)) return;
                var newRowIdx=shtObj.DataInsert(-1);
                shtObj.SetCellValue(newRowIdx, "agn_agmt_no",ComGetEtcData(xmlStr, "new_agmt_no"),0);
                shtObj.SetCellValue(newRowIdx, "usr_id",ComGetEtcData(xmlStr, "usr_id"),0);// 로그인한 사용자 ID
                shtObj.SetCellValue(newRowIdx, "delt_flg","N",0);
                shtObj.SetCellEditable(newRowIdx, "delt_flg",0);
                shtObj.SetCellValue(newRowIdx, "agn_cd",frmObj.agn_cd.value,0);
                shtObj.SetCellValue(newRowIdx, "chk","1");// 이 부분만 GetCellValue로 하지 말것
                break;
            case IBSAVE:    // TAB1_Save
                if (shtObj.GetSaveString() == "") return;    // sheet mandatory check 용도
                ComOpenWait(true);
                shtObj.DoSave("ESM_ACM_0011GS.do", "f_cmd=" + MULTI);
                ComOpenWait(false);
                break;
            case SEARCH11:    // TAB2_Sheet2_Retrieve / TAB3_Sheet2_Retrieve
                ComOpenWait(true);
                shtObj.DoSearch("ESM_ACM_0011GS.do", "f_cmd=" + SEARCH11 + "&" + CondParam, {Sync:2} );
                ComOpenWait(false);
                break;
            case MULTI01:    // TAB2_Save
                if (shtObj.GetSaveString() == "") return;    // sheet mandatory check 용도
                if (frmObj.rate_div[1].checked) {
                	if (sheetObjects[3].GetCellValue(1, "comm_pay_term_cd") == "") {
                        ComShowCodeMessage("COM130201", "Pay Term");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "comm_pay_term_cd", true);
                        return;
                	} else if (sheetObjects[3].GetCellValue(1, "rev_div_cd") == "") {
                        ComShowCodeMessage("COM130201", "Base");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "rev_div_cd", true);
                        return;
                    }
                } else {
                	if (sheetObjects[3].GetCellValue(1, "oft_pay_term_cd") == "") {
                        ComShowCodeMessage("COM130201", "OFT Term");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "oft_pay_term_cd", true);
                        return;
                	} else if (sheetObjects[3].GetCellValue(1, "full_mty_cd") == "") {
                        ComShowCodeMessage("COM130201", "Full/MT");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "full_mty_cd", true);
                        return;
                	} else if (sheetObjects[3].GetCellValue(1, "curr_cd") == "") {
                        ComShowCodeMessage("COM130201", "Curr");    // "Please input {?msg1}."
                        sheetObjects[3].SelectCell(1, "curr_cd");
                        return;
                    }
                }
                ComOpenWait(true);
                shtObj.DoSave("ESM_ACM_0011GS.do", "f_cmd=" + MULTI01);
                ComOpenWait(false);
                break;
            case SEARCH03:    // TAB3_Sheet1_Retrieve (TAB3에서만 조회 - TAB3에서 호출)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                sheetObjects[9].RemoveAll();    // tab2sheet2 Clear
                frmObj.f_cmd.value=SEARCH;
                	shtObj.DoSearch("ESM_ACM_0011GS.do", FormQueryString(frmObj), {Sync:2} );
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
         // 조회조건의 RHQ Select Object 생성
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
                for (var i=HeaderRows(); i<=LastRow(); i++) {
                    // delt_flag가 Y일때 컬럼 편집 비활성화
                	if (GetCellValue(i, "delt_flg") == "Y") {
                        SetCellEditable(i, "agmt_fm_dt_cd",0);
                        SetCellEditable(i, "agmt_fm_dt",0);
                        SetCellEditable(i, "agmt_to_dt_cd",0);
                        SetCellEditable(i, "agmt_to_dt",0);
                        SetCellEditable(i, "agn_agmt_rmk",0);
                    }
                }
                ReDraw=true;
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab1sheet1_OnChange(shtObj, Row, Col, Value) {
        if (Value == "") return;
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "chk":
                    t1s1chkRowIdx=Row;    // 전역변수에 setting
                    // TAB2의 sheet초기화
                    for (var i=1; i<8; i++) {
                        sheetObjects[i].RemoveAll();
                    }
                    if (GetRowStatus(Row) == "I" || GetRowStatus(Row) == "D") {
                        // Detail (Compensation) 탭 비활성화
                        if (!tabObjects[0].GetTabDisable(1)) {
                            tabObjects[0].SetTabDisable(1, true);
                            return;
                        }
                    } else {
                        ACMRadioChkAction(shtObj, Row);    // CoAcm.js에 정의
                        // check된 한 row만 SeachXml로 parsing하여 TAB2의 Sheet1에 Load (반드시 컬럼명이 같아야 함)
                        var xmlStr=ComMakeSearchXml(shtObj, false, Col, IBS_ConcatSaveName(shtObj));
                        sheetObjects[1].LoadSearchData(xmlStr,{Sync:1} );
                        // Tab2_Sheet2용 전역변수 초기화
                        t2s2chkRowIdx=-1;
                        // check된 한 row의 Data를 param으로 TAB2의 Sheet2 내용 조회
                        doActionIBSheet(sheetObjects[2], document.form, SEARCH11, RowSaveStr(Row));
                    }
                    break;
                case "delt_flg":
                    if (Value == "Y") {
                        SetCellEditable(Row, "agmt_fm_dt_cd",0);
                        SetCellEditable(Row, "agmt_fm_dt",0);
                        SetCellEditable(Row, "agmt_to_dt_cd",0);
                        SetCellEditable(Row, "agmt_to_dt",0);
                        SetCellEditable(Row, "agn_agmt_rmk",0);
                    } else {
                        SetCellEditable(Row, "agmt_fm_dt_cd",1);
                        SetCellEditable(Row, "agmt_fm_dt",1);
                        SetCellEditable(Row, "agmt_to_dt_cd",1);
                        SetCellEditable(Row, "agmt_to_dt",1);
                        SetCellEditable(Row, "agn_agmt_rmk",1);
                    }
                    break;
            }
        }
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function tab1sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
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
                if (tabObjects[0].GetTabDisable(1)) {
                    //조회 완료 후 데이터 0건 이상 인경우 Detail (Compensation) 탭 활성화
                    tabObjects[0].SetTabDisable(1, false);
                }
            }
        }
    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function tab2sheet2_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount()< 1) {
                shtObj.RemoveAll();
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet2_OnClick(shtObj, Row, Col, Value) {
    	if (shtObj.GetCellValue(Row, "chk") != "1") {
        	shtObj.SetCellValue(Row, "chk", "1");    		
    	}
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet2_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "chk":
                    t2s2chkRowIdx=Row;    // 전역변수에 setting
                	if (GetRowStatus(Row) == "D") {
                		for (var i=3; i<8; i++) {
                			sheetObjects[i].RemoveAll();
                		}
                		break;
                	}
                    // check된 한 row만 SeachXml로 parsing하여 나머지 Sheet에 일괄 Load (반드시 컬럼명이 같아야 함에 주의)
                    var xmlStr=ComMakeSearchXml(shtObj, false, Col, IBS_ConcatSaveName(shtObj));
                    for (var i=3; i<8; i++) {
                        sheetObjects[i].RemoveAll();
                        sheetObjects[i].LoadSearchData(xmlStr,{Sync:1} );
                    }
                    if (sheetObjects[3].GetCellValue(1, "oft_pay_term_cd") == "") sheetObjects[3].SetCellValue(1, "oft_pay_term_cd","T");
                    if (sheetObjects[3].GetCellValue(1, "comm_pay_term_cd") == "") sheetObjects[3].SetCellValue(1, "comm_pay_term_cd","T");
                    if (GetCellValue(Row, "ac_tp_cd") == "N" || GetCellValue(Row, "ac_tp_cd") == "R") {
                        document.form.rate_div[0].checked=true;
                        document.form.rate_div[1].disabled=true;
                        chkRate("F");
                    } else {
                        document.form.rate_div[0].disabled=false;
                        document.form.rate_div[1].disabled=false;
	                    if (GetCellValue(Row, "rate_div") == "R") {
	                        document.form.rate_div[1].checked=true;
	                        chkRate("R");
	                    } else {
	                        document.form.rate_div[0].checked=true;
	                        chkRate("F");
	                    }
                    }
                    break;
                case "ac_tp_cd":
                    t2s2chkRowIdx=Row;    // 전역변수에 setting
                    if (GetCellValue(Row, "ac_tp_cd") == "N" || GetCellValue(Row, "ac_tp_cd") == "R") {
                        document.form.rate_div[0].checked=true;
                        document.form.rate_div[1].disabled=true;
                        chkRate("F");
                    } else {
                        document.form.rate_div[0].disabled=false;
                        document.form.rate_div[1].disabled=false;
                        chkRate("F");
                    }
               	 	sheetObjects[4].SetCellEditable(1, "ofc_set_tp_cd",1);
                    sheetObjects[4].SetCellEditable(1, "ofc_cvrg_cd",1);
                   break;
            }
        }
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function tab2sheet2_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        var agmtDtlPk=shtObj.GetCellValue(t2s2chkRowIdx, "agmt_dtl_pk");
        // Tab2_Sheet2용 전역변수 초기화
        t2s2chkRowIdx=-1;
        // TAB2의 내용을 조회하기 위해 TAB1 Sheet1의 OnChange이벤트를 발생
        tab1sheet1_OnChange(sheetObjects[0], t1s1chkRowIdx, sheetObjects[0].SaveNameCol("chk"), "1");
        // 저장 후 체크되어 있었던 row data 다시 체크
        if (agmtDtlPk != "") {
            var findRowIdx=shtObj.FindText("agmt_dtl_pk", agmtDtlPk);
            if (findRowIdx > -1) {
                shtObj.SetCellValue(findRowIdx, "chk","1");
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet3_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "cntr_tpsz_cd":
                    var tmpEditable=GetCellEditable(Row, Col);
                    // MemoPad를 open시 비활성화로 열어야 하므로 CellEditable이 활성화면 임시로 비활성화
                    if (tmpEditable) SetCellEditable(Row, Col,0);
                    ComShowMemoPad(shtObj, Row, Col, true);
                    // MemoPad가 닫힌 후에는 [비활성화/활성화]였던 원래상태 유지
                    if (tmpEditable) SetCellEditable(Row, Col,1);
                    break;
            }
        }
    }
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab2sheet3_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "cntr_tpsz_cd":
                	var param="?cntr_tpsz_cd=" + shtObj.GetCellValue(Row, Col);
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0102.do" + param, 742, 610, "setPopupData", "1,0", true, false, Row, Col, 3);
                    break;
                case "curr_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_N13.do", 700, 485, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 3);
                    break;
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet3_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
            	case "curr_cd":
                // validation
	                 var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH14 + "&value0=" + Value);
	                if (ACMDecideErrXml(shtObj, xmlStr)) {
	                	SetCellValue(Row, Col, "", 0);
	                	setTimeout(function(){
	                        SelectCell(Row, Col, true, "");
	                    	},10);    
	                }
	                break;
            }
        }
        // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
        sheetObjects[2].SetCellValue(t2s2chkRowIdx, shtObj.ColSaveName(Col),Value);
    }
    /**
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function tab2sheet4_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount()> 0) {
            	if (GetCellValue(1, "ofc_set_tp_cd") == "B" || GetCellValue(1, "ofc_set_tp_cd") == "C" ) {
                    SetCellEditable(1, "ofc_cvrg_cd",0);
                } else if (GetCellValue(1, "ofc_set_tp_cd") == "T") {
                		if(sheetObjects[2].GetCellValue(t2s2chkRowIdx, "io_bnd_cd") == "O"){
                        	SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
                			SetCellValue(1, "ofc_cvrg_cd","NBO");
                			SetCellEditable(1, "ofc_cvrg_cd",0);
                		}else{
                			SetColProperty("ofc_cvrg_cd", {ComboText:"& POD Fin Office|& DEL Fin Office", ComboCode:"PFO|DFO"} );
                			SetCellValue(1, "ofc_cvrg_cd", sheetObjects[2].GetCellValue(t2s2chkRowIdx, "ofc_cvrg_cd")!=""?sheetObjects[2].GetCellValue(t2s2chkRowIdx, "ofc_cvrg_cd"):"PFO");
                            SetCellEditable(1, "ofc_cvrg_cd",1);
                		}
                } else if (GetCellValue(1, "ofc_set_tp_cd") == "R"){
                	SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
        			SetCellValue(1, "ofc_cvrg_cd","MH");
        			SetCellEditable(1, "ofc_cvrg_cd",0);
                } else {
                	SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
                    SetCellEditable(1, "ofc_cvrg_cd",1);
                }
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet4_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "ofc_set_tp_cd":
                    if (Value == "B" || Value == "C" || Value == "G"  ) {
                        SetCellValue(Row, "ofc_cvrg_cd","");
                        SetCellEditable(Row, "ofc_cvrg_cd",0);
                    } else if (Value == "T") {
                    	if(sheetObjects[2].GetCellValue(t2s2chkRowIdx, "io_bnd_cd") == "O"){
                    		SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
                    		SetCellValue(Row, "ofc_cvrg_cd","NBO");
                    		SetCellEditable(Row, "ofc_cvrg_cd",0);
                    	}else{
                            SetColProperty("ofc_cvrg_cd", {ComboText:"& POD Fin Office|& DEL Fin Office", ComboCode:"PFO|DFO"} );
                            SetCellValue(Row, "ofc_cvrg_cd", "PFO");
                            SetCellEditable(1, "ofc_cvrg_cd",1);
                    	}
                    } else if (Value == "R") {
                        SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
                        SetCellValue(Row, "ofc_cvrg_cd","MH");
                        SetCellEditable(Row, "ofc_cvrg_cd",0);                   	
                    } else if (Value == "A" || Value == "F") {	
                    	SetColProperty("ofc_cvrg_cd", {ComboText:"POR|POL|POD|DEL|Pre T/S Port|Post T/S Port", ComboCode:"POR|POL|POD|DEL|PRE|PST"} );
                        SetCellValue(Row, "ofc_cvrg_cd","");
                        SetCellEditable(Row, "ofc_cvrg_cd",1);                    	
                    } else {
                        SetColProperty("ofc_cvrg_cd", {ComboText:"|"+ofcCvrgText, ComboCode:"|"+ofcCvrgCode} );
                        SetCellValue(Row, "ofc_cvrg_cd","");
                        SetCellEditable(Row, "ofc_cvrg_cd",1);
                    }
                    break;
                case "ofc_cd":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH13 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                    	SelectCell(Row, Col, true, "");
                    	SetCellValue(Row, Col, "", 0);
                    }
                    break;
            }
        }
        // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
        sheetObjects[2].SetCellValue(t2s2chkRowIdx, shtObj.ColSaveName(Col),Value);
    }
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab2sheet4_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "ofc_cd":
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("COM_ENS_071.do", 700, 445, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 4);
                    break;
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet5_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "por":
                case "pol":
                case "pod":
                case "del":
                    SetCellEditable(Row, Col,0);
                    ComShowMemoPad(shtObj, Row, Col, true, null, null, null, true);
                    SetCellEditable(Row, Col,1);
                    break;
            }
        }
    }
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab2sheet5_OnPopupClick(shtObj, Row, Col) {
        with (sheetObjects[2]) {
            var param="?agnCd=" + document.form.agn_cd.value +
            "&agnAgmtNo=" + GetCellValue(t2s2chkRowIdx, "agn_agmt_no") +
            "&ioBndCd=" + GetCellValue(t2s2chkRowIdx, "io_bnd_cd") +
            "&acTpCd=" + GetCellValue(t2s2chkRowIdx, "ac_tp_cd") +
            "&agnAgmtSeq=" + GetCellValue(t2s2chkRowIdx, "agn_agmt_seq");
        }
        switch (shtObj.ColSaveName(Col)) {
            case "por":
                param += "&routRefDivCd=POR";
                break;
            case "pol":
                param += "&routRefDivCd=POL";
                break;
            case "pod":
                param += "&routRefDivCd=POD";
                break;
            case "del":
                param += "&routRefDivCd=DEL";
                break;
        }
        // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
        ComOpenPopup("ESM_ACM_0113.do" + param, 970, 500, "setPopupData", "1,0,1,1,1,1,1", true, false, Row, Col, 5);
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet5_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "por":
                case "pol":
                case "pod":
                case "del":
                    if (Value == "") {
                        SetCellValue(Row, ColSaveName(Col) + "_1","");
                        SetCellValue(Row, ColSaveName(Col) + "_2","");
                        SetCellValue(Row, ColSaveName(Col) + "_3","");
                        SetCellValue(Row, ColSaveName(Col) + "_4","");
                        SetCellValue(Row, ColSaveName(Col) + "_lvl_cd","");
                    }
                    break;
            }
            // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
            sheetObjects[2].SetCellValue(t2s2chkRowIdx, ColSaveName(Col),Value);
        }
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet6_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "rep_chg_cd":
                case "chg_cd":
                    SetCellEditable(Row, Col,0);
                    ComShowMemoPad(shtObj, Row, Col, true);
                    SetCellEditable(Row, Col,1);
                    break;
            }
        }
    }
    /**
     * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function tab2sheet6_OnPopupClick(shtObj, Row, Col) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "rep_chg_cd":
                case "chg_cd":
                	var param="?rep_chg_cd=" + shtObj.GetCellValue(Row, "rep_chg_cd") + "&chg_cd=" + shtObj.GetCellValue(Row, "chg_cd");
                    // ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
                    ComOpenPopup("ESM_ACM_0103.do" + param, 780, 600, "setPopupData", "1,0", true, false, Row, Col, 6);
                    break;
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index 
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet6_OnChange(shtObj, Row, Col, Value) {
        // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
        sheetObjects[2].SetCellValue(t2s2chkRowIdx, shtObj.ColSaveName(Col),Value);
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab2sheet7_OnChange(shtObj, Row, Col, Value) {
        // OnChange 이벤트가 발생하면 TAB2의 Sheet2의 해당 컬럼에 값을 setting
        sheetObjects[2].SetCellValue(t2s2chkRowIdx, shtObj.ColSaveName(Col),Value);
    }
    /**
     * Pop-Up Return Value 처리 부분<br>
     * @param aryPopupData : {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row : 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col : 대상Object가 IBSheet일 경우 해당 Col index
     * @param ShtIdx : 대상IBSheet의 Sheet Array index
     */
    function setPopupData(aryPopupData, Row, Col, ShtIdx) {
        if (aryPopupData.length > 0 ) {
            with (sheetObjects[ShtIdx]) {
                switch (ColSaveName(Col)) {
                    case "cntr_tpsz_cd":
                        SetCellValue(Row, Col,aryPopupData[0]);
                        break;
                    case "por":
                    case "pol":
                    case "pod":
                    case "del":
                        SetCellValue(Row, ColSaveName(Col) + "_1",aryPopupData[1]);
                        SetCellValue(Row, ColSaveName(Col) + "_2",aryPopupData[2]);
                        SetCellValue(Row, ColSaveName(Col) + "_3",aryPopupData[3]);
                        SetCellValue(Row, ColSaveName(Col) + "_4",aryPopupData[4]);
                        SetCellValue(Row, ColSaveName(Col) + "_lvl_cd",aryPopupData[0]);
                        SetCellValue(Row, Col,aryPopupData[aryPopupData[0]]);
                        break;
                    case "rep_chg_cd":
                    case "chg_cd":
                        SetCellValue(Row, "rep_chg_cd",aryPopupData[0]);
                        SetCellValue(Row, "chg_cd",aryPopupData[1]);
                        break;
                    case "curr_cd":
                    	SetCellValue(Row,  Col,aryPopupData[0][2]);
                    	break;    
                    default:
                        SetCellValue(Row, Col,aryPopupData[0][3]);
                        break;
                }
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 값이 변경되었을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab3sheet1_OnChange(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "chk":
                    // check된 한 row의 Data를 param으로 TAB3의 Sheet2 내용 조회
                	doActionIBSheet(sheetObjects[9], document.form, SEARCH11, RowSaveStr(Row));
                    break;
            }
        }
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     */
    function tab3sheet2_OnClick(shtObj, Row, Col, Value) {
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "cntr_tpsz_cd":
                case "rep_chg_cd":
                case "chg_cd":
                    ComShowMemoPad(shtObj, Row, Col, true);
                    break;
            }
        }
    }
    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var elementName=ComGetEvent("name");
        var shtObj=sheetObjects[0];
        with (document.form) {
            switch (elementName) {
                case "rhq_cd_disp":    // RHQ를 변경시 Office목록을 setting
                    if (rhq_cd_disp.value == "") {
                        ComClearCombo(ar_ofc_cd);
                        ComClearCombo(agn_cd);
                        return;
                    }
                    rhq_cd.value=rhq_cd_disp.value;
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH07);
                    ofcKndCd=ComGetEtcData(xmlStr, "ofc_knd_cd");    // *** 반드시 전역변수로 setting에 유의 ***
                    var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH18 + "&value0=" + rhq_cd.value + "&value1=" + ofcKndCd );
                    if (ACMXml2SelectItem(xmlStr, ar_ofc_cd, "value0", "value0", false)) {
                        // option이 하나 이상이라면
                        if (ar_ofc_cd.options.length > 1) {
                            // rhq_cd와 같은 값이 선택되게 함
                            ar_ofc_cd.value=rhq_cd.value;
                        }
//                        ar_ofc_cd.fireEvent("onchange");    // form.ar_ofc_cd 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
                        ComFireEvent(ar_ofc_cd, "change");    // form.ar_ofc_cd 강제로 OnChange이벤트 발생(frmObj_OnChange를 호출)
//                        $('#ar_ofc_cd').change();
                        
                    }
                    agn_cd.value=ar_ofc_cd.value;
                    break;
                case "ar_ofc_cd":    // Office를 변경시 Sub Office목록을 setting
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
    
    function chkRate(type) {
        var t2shtObj3=sheetObjects[3];
        var frmObj=document.form;
        if (t2shtObj3.RowCount()< 1) return;
        if (type=="R") {
        	ACMCellEditable(t2shtObj3, "oft_pay_term_cd", "comm_fx_amt", false);    // CoAcm.js에 정의
        	ACMCellEditable(t2shtObj3, "comm_pay_term_cd", "comm_rt", true);    // CoAcm.js에 정의
        	sheetObjects[2].SetCellValue(t2s2chkRowIdx, "rate_div","R",0);
        } else {
        	ACMCellEditable(t2shtObj3, "comm_pay_term_cd", "comm_rt", false);    // CoAcm.js에 정의
        	ACMCellEditable(t2shtObj3, "oft_pay_term_cd", "comm_fx_amt", true);    // CoAcm.js에 정의
        	sheetObjects[2].SetCellValue(t2s2chkRowIdx, "rate_div","F",0);
        }
    	
    }

/* 개발자 작업 끝 */
