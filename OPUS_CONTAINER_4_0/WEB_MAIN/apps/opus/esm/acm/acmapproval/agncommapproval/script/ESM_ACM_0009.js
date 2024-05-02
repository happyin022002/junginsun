/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0009.js
*@FileTitle  : Agent Commission CSR Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var currentRow=0;
    var rdFromObj=new Array();
    var rdObj=new Array();
    var parmObj=new Array();
    // var event = document.createEvent("HTMLEvents");
    // event.initEvent("change",true,false);
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj=sheetObjects[0];
        var frmObj=document.form;
        var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_calendar":
                    var cal=new ComCalendarFromTo();
                    cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
                break;
            case "btn_inv_dt":
                var cal=new ComCalendar();
                cal.select(frmObj.inv_dt, 'yyyy-MM-dd');
                break;
            case "btn_retrieve":
                doActionIBSheet(shtObj, frmObj, IBSEARCH);
                break;
            case "btn_approval_request":
                doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                break;
            case "btn_audit_reject":
                doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC02);
                break;
            case "btng_downexcel1":
                doActionIBSheet(sheetObjects[0],frmObj,IBDOWNEXCEL);
                break;
            case "btng_downexcel2":
                doActionIBSheet(sheetObjects[1],frmObj,IBDOWNEXCEL);
                break;
            case "btn2_check":
                ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 1);    // CoAcm.js에 정의
                break;
            case "btn2_uncheck":
                ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 0);    // CoAcm.js에 정의
                break;
            case "btn_popup":		//Edit Approval Staff
                var v_ofc_cd=frmObj.ofc_cd.value;
                var v_sub_sys_cd="AGT";
                var v_apro_step=frmObj.apro_step.value;
                var param="?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
                ComOpenPopup("COM_ENS_0T1.do" + param, 835, 550, "", "none", true, false);
                break;
            case "btn_clear":
                doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC03);
                break;
            case "btn_print":
                doActionIBSheet(shtObj,frmObj,RDPRINT);
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
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        // sheet1_OnLoadFinish 메서드 존재시 반드시 참조
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
            case "sheet1":
                document.form.pagerows.value=500; 
                var HeadTitle="STS||No.|Audit No.|Agent|Vendor|Vendor|Cur|VVD Count|Net AMT|VAT|TTL AMT|CSR No.|Approval Date|I/F Date|" +
                "Interface Ramark|Receipt Ramark|Payment AMT|Payment Date|Method|CSR Created\nTime|CSR Requested|CSR Requested|CSR Approved / Disapproved|CSR Approved / Disapproved";
                var HeadTitle1="STS||No.|Audit No.|Agent|Code|Name|Cur|VVD Count|Net AMT|VAT|TTL AMT|CSR No.|Approval Date|I/F Date|" +
                "Interface Ramark|Receipt Ramark|Payment AMT|Payment Date|Method|CSR Created\nTime|ID|Name|ID|Name";
                SetEditEnterBehavior("tab");

                SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                       {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                       {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"aud_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"vvd_cnt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"net_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"vat",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ttl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"apro_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"if_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"if_flg_msg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"rcv_err_flg_msg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"pay_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pay_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"pay_mzd_lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"csr_cre_dt",  	KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rqst_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rqst_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

                
                InitColumns(cols);
                SetSheetHeight(200);
	            SetEditable(1);
	            SetWaitImageVisible(0);
	            SetEditableColorDiff(0);
	            break;
            case "sheet2":
            	   document.form.pagerows.value=500;
            	   var HeadTitle="STS|VVD|B/L No.|BKG No|Agent|Type|A/R OFC|A/P OFC|BKG STS|Calculated AMT|I/F AMT";
            	   SetEditEnterBehavior("tab");

            	   SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 } );

            	   var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
            	   var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	   InitHeaders(headers, info);

            	   var cols = [ {Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agn_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ac_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ar_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ap_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"AutoSum",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pay_if_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	                {Type:"AutoSum",   Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"if_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
            	    
            	   InitColumns(cols);
            	   SetSheetHeight(200);
                   SetEditable(1);
                   SetWaitImageVisible(0);
                   SetEditableColorDiff(0);
                   break;
            case "sheet3":    	//sheet3 init
                var HeadTitle="title|csr no|office|prpd by|pay to|csr type|desc|pay grp|evi tp|due date|asa no|inv dt|currcd|amt|apprd" ;

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_title",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_csr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_office",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_prpd_by",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_pay_to",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_csr_type",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_pay_grp",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_evi_tp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_due_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_asa_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_inv_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_apprd_by",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_amount",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"hdr_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetSheetHeight(120);
                SetEditable(1);
                break;
            case "sheet4":      //sheet4 init
                var HeadTitle="count|char of account|account name|gl date|city|inv no|desc|debit|credit" ;

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dtl_cht_acct",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dtl_acct_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dtl_gl_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dtl_city",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dtl_inv_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dtl_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dtl_debit",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dtl_credit",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);
                SetSheetHeight(120);
                SetEditable(1);
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
 //       axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
//        //axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "ar_ofc_cd", "agn_cd", "ac_sts_cd", "asa_no");
 //       $('#ar_ofc_cd, #agn_cd, #ac_sts_cd, #asa_no').on('change', frmObj_OnChange);
        with (document.form) {
            // date_div_disp에 초기값 setting
            date_div_disp.value=ac_sts_cd.options[ac_sts_cd.selectedIndex].text;
            // Invoice Date 날짜 설정
            inv_dt.value=ComGetNowInfo();
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case SEARCH01:    // Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
                 var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", true);
                break;
            case IBSEARCH:    // 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                 shtObj.DoSearch("ESM_ACM_0009GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case SEARCH02:    // 조회(Detail)
                ComOpenWait(true);
                var shtObj2=sheetObjects[1];
                frmObj.f_cmd.value=SEARCH01;
                shtObj2.DoSearch("ESM_ACM_0009GS.do", FormQueryString(frmObj), {Sync:2} );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01: //Approval Request
                if (!ComChkValid(frmObj)) return;
                if(!validateForm(shtObj,frmObj,sAction))	return;
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI01;
                shtObj.DoSave("ESM_ACM_0009GS.do", FormQueryString(frmObj), "chk");
                sheetObjects[1].RemoveAll();
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC02: //Audit Reject
                if (!ComChkValid(frmObj)) return;
                if(!validateForm(shtObj,frmObj,sAction))	return;
                ComOpenWait(true);
                frmObj.f_cmd.value=MULTI02;
                shtObj.DoSave("ESM_ACM_0009GS.do", FormQueryString(frmObj), "chk");
                sheetObjects[1].RemoveAll();
                ComOpenWait(false);
                break;
            case IBDOWNEXCEL:    //Down Excel
            	if(shtObj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		//shtObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
            		shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1,Merge:1 });
            	}
                break;
            case IBSEARCH_ASYNC03: //Clear
                frmObj.apro_step.value="";
                break;
            case RDPRINT:	//Print
                if(!validateForm(shtObj,frmObj,sAction))	return false;
				if (frmObj.ac_sts_cd.value != "PS") {
            		ComShowCodeMessage("COM12113", "approved row only.");
					return;
				}
                //체크된 첫번째행의 번호를 읽어와서 Hidden Input에 담는다.
                var sRow=shtObj.FindCheckedRow("chk");
//                var arrRow=sRow.split("|");
                var currCd=shtObj.GetCellValue(sRow, "curr_cd");
                frmObj.h_csr_no.value=shtObj.GetCellValue(sRow, "csr_no");
                //보고서출력을 위해 AP_INV_HDR, AP_INV_DTRB 정보 조회
                frmObj.f_cmd.value=PRINT;
                 var sXml=shtObj.GetSearchData("ESM_ACM_0009GS.do", FormQueryString(frmObj));
                var arrXml=sXml.split("|$$|");
                var shtObj3=sheetObjects[2];
                var shtObj4=sheetObjects[3];
                //ETC데이터를 IBSheet에 세팅한다.
                shtObj.RemoveEtcData();
                shtObj3.LoadSearchData(arrXml[0],{Sync:1} );
                shtObj4.LoadSearchData(arrXml[1],{Sync:1} );
                //보고서출력
              
                rdFromObj[0]=frmObj;  //RD로 보내기 위해 배열로담는다
                rdObj[0]=sheetObjects[2]; //sheet를 RD로 보내기 위해 배열로 담는다
                rdObj[1]=sheetObjects[3];
                //RD_path  = "http://203.246.136.105:7001/clt/";
                //RD_path = "http://kov440h.clt.com:9300/clt/";
                // RD 로 보내기 위한 설정
                parmObj[0]="1";
                parmObj[1]="";
                parmObj[2]="N";
                if(currCd == "JPY" || currCd == "KRW"){
                    parmObj[3]=RD_path + "apps/opus/esm/acm/acmapproval/agncommapproval/report/ESM_ACM_0201B.mrd"; //RD 화면
                }else{
                    parmObj[3]=RD_path + "apps/opus/esm/acm/acmapproval/agncommapproval/report/ESM_ACM_0201A.mrd"; //RD 화면
                }
                parmObj[4]=rdObj;
                parmObj[5]=rdFromObj;
                rdObjModaless(RdReport, parmObj, 1200, 700);
                break;
        }
    }
    /**
     * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 상세내역을 조회한다.
     * @param {Object} sheetObj
     * @param {Object} row
     * @param {Object} col
     * @param {Object} value
     */
    function sheet1_OnClick(shtObj, row, col, value) {
        var frmObj=document.form;
        var shtObj2=sheetObjects[1];
		frmObj.aud_no.value=shtObj.GetCellValue(row,"aud_no");
		frmObj.csr_no.value=shtObj.GetCellValue(row,"csr_no");
        doActionIBSheet(shtObj, document.form, SEARCH02);
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
         
         var shtObj = sheetObjects[1];
         
         shtObj.RemoveAll();
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
                SetCellText(LastRow(), "seq" ,"");
                SetCellText(LastRow(), "vvd" ,"TOTAL");
                ReDraw=true;
            }
        }
    }
    /**
     * IBSeet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 저장 후 메시지
     */
    function sheet1_OnSaveEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
        // 저장 후 재조회
        doActionIBSheet(shtObj, document.form, IBSEARCH);
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
            shtObj.RemoveAll();
            shtObj1.RemoveAll();
            break;
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
            
            // offsetFlag = "Y"(ar_ofc_cd가 상계 정산 대리점(operational))
            var xmlStr = shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH22 + "&value0=" + formObj.agn_cd.value);
            
            if(ACMDecideErrXml(shtObj, xmlStr)) return;
            if(ComGetEtcData(xmlStr, "so_flag") == "N"){ //ASA No.
            	formObj.asa_no.disabled = true;
          		formObj.asa_no.className="input2";
            }else{
            	formObj.asa_no.disabled = false;
          		formObj.asa_no.className="input";
            }

            shtObj.RemoveAll();
            shtObj1.RemoveAll();
            break;
        case "ac_sts_cd":
        	formObj.date_div_disp.value = formObj.ac_sts_cd.options[formObj.ac_sts_cd.selectedIndex].text;
            shtObj.RemoveAll();
            shtObj1.RemoveAll();
            break;
        case "asa_no":
            var idx = formObj.asa_no.selectedIndex;
            if(idx >= 0) {
                //ASA No의 TO_DATE로 세팅
                var arrAsaNo=formObj.asa_no[idx].text.split('~');
//            	var split = asaNo.split('~');
                var temp=ComReplaceStr(arrAsaNo[1], ')', ' ');
                temp=ComReplaceStr(temp, '/', '-');
                temp=ComReplaceStr(temp, ' ', '');
                formObj.inv_dt.value=temp;
            } else {
                //오늘 날짜로 세팅
            	formObj.inv_dt.value=ComGetNowInfo();
            }
            break;
        }
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param {Object} shtObj
     * @param {Object} formObj
     * @param {Object} sAction
     */
    function validateForm(shtObj,fromObj,sAction){
        with(fromObj){
            switch(sAction) {
                case IBSEARCH_ASYNC01:	//Approval Request
                    if(ac_sts_cd.value != "AS"){ //Commission Status != Audited
                        ComShowCodeMessage("COM12114", "Commission Status");
                        return false;
                    }
                    // offsetFlag = "Y"(ar_ofc_cd가 상계 정산 대리점(operational)) && asa_no가 없을 때
                     var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH22 + "&value0=" + agn_cd.value);
                    if(ACMDecideErrXml(shtObj, xmlStr)) return;
                    if(ComGetEtcData(xmlStr, "so_flag") == "Y" && asa_no.value == ""){ //ASA No.
                        ComShowCodeMessage("COM12113", "ASA No");
                        return false;
                    }
                   // if(apro_step.value == ""){ //Approval Step
                   //      ComShowCodeMessage("ACM00021");
                        //ComShowMessage("You are requested to designate the proper approval authority prior to Approval Request");
                   //     return false;
                   // }
                    var checkCnt=shtObj.CheckedRows("chk");
                    if(checkCnt < 1){
                        ComShowCodeMessage("COM12113", "row for approval request");
                        return false;
                    }
                    //2개 이상 Vendor, Currency check
                    var chkRow = shtObj.FindCheckedRow("chk");
                    if(chkRow != ""){
	                    var temp = chkRow.split("|");
	                    var tempVal = new Array();
	                    var tempCurr = new Array();
	                    
	                    for(var i =0; i<temp.length; i++){
	                    	tempVal[i] = shtObj.GetCellValue(temp[i],"vndr_seq");
	                    	tempCurr[i] = shtObj.GetCellValue(temp[i], "curr_cd");
	                    }
	                    for(var j =0; j<tempVal.length; j++){
	                    	if(tempVal[0]!==tempVal[j]){
	                    		ComShowCodeMessage("COM12113", "same vendor.");
	                    		return false;
	                    	}
	                    } 
	                    for(var j =0; j<tempCurr.length; j++){
	                    	if(tempCurr[0]!==tempCurr[j]){
	                    		ComShowCodeMessage("COM12113", "same currency.");
	                    		return false;
	                    	}
	                    } 
                    }                    
                    break;
                case RDPRINT:	//Print
                    if(ac_sts_cd.value != "IF"){		//Commission Status
                        //ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
                        //return false;
                    }
                    var checkCnt=shtObj.CheckedRows("chk");
                    if(checkCnt < 1 || checkCnt > 1){	//Grid 체크박스 1개만 선택
                        alert('If you want to print report, please select just one item.');
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    /**
     * 화면 VAT 항목에 FOCUS가 왔을때 처리
     */
    function invTaxRt_onfocus(obj){
        obj.select();
    }
    /**
     * 화면 VAT 항목에 FOCUS가 나갈때 유효성검증 프로세스 처리
     */
    function invTaxRt_validate(obj){
        var frmObj=document.form;
        if(!ComIsNumber(obj,'.')){
            alert("The range of VAT(%) is between 0.00% and 99.99%.");
            obj.value="0.00";
//            frmObj.inv_tax_rt.focus();
            frmObj.inv_tax_rt.select();
            return false;
        }
        var vat=parseFloat(obj.value);
        if(vat < 0 || vat >= 100){
            alert("The range of VAT(%) is between 0.00% and 99.99%.");
            obj.value="0.00";
//            frmObj.inv_tax_rt.focus();
            frmObj.inv_tax_rt.select();
            return false
        }
    }
/* 개발자 작업 끝 */