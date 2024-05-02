/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0030.js
*@FileTitle  : FF Compensation CSR Creation
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
     * @class ESM_ACM_0030 : ESM_ACM_0030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
function ESM_ACM_0030() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
/* 개발자 작업 */
    // 공통전역변수
    var fromObj=new Array();
    var rdObj=new Array();
    var parmObj=new Array();

    var sheetObjects=new Array();
    var sheetCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var memoShtObj1=sheetObjects[0];
        var shtObj=sheetObjects[1];
        var frmObj=document.form;
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            if (srcName != "btn2_bl_no") {
                 ACMMemoSheet_Close(memoShtObj1,frmObj.bl_no);
            }
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
                case "btn_approval":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH_ASYNC01);
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheetObjects[3],frmObj,IBDOWNEXCEL);
                    break;
                case "btn_csr_print":
                    doActionIBSheet(sheetObjects[5],frmObj,SEARCH05);
                    break;
                case "btn2_bl_no":
                    ACMMemoSheet_Open(memoShtObj1);    // CoAcm.js에 정의
                    break;
                case "btn2_check":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 1);    // CoAcm.js에 정의
                    break;
                case "btn2_uncheck":
                    ACMMultiRowCheck(shtObj, frmObj.slct_start, frmObj.slct_end, 0);    // CoAcm.js에 정의
                    break;
                case "btn_forwarder":
                    var url="COM_ENS_041.do";
                    var width=775;
                    var height=484;
                    var func="setForwarder";
                    var display="1,0,1";
                    ComOpenPopup(url, width, height, func, display, true, false);
                    break;
                case "btn_popup":		//Edit Approval Staff
                    var v_ofc_cd=frmObj.ofc_cd.value;
                    var v_sub_sys_cd="AGT";
                    var v_apro_step=frmObj.apro_step.value;
                    var param="?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
                    ComOpenPopup('COM_ENS_0T1.do' + param, 835, 550, '', 'none', true, false);
                    break;
                case "btn_clear":
                    doActionIBSheet(shtObj,frmObj,IBSEARCH_ASYNC02);
                    break;
                case "btn_print":
                    doActionIBSheet(sheetObjects[6],frmObj,IBSEARCH_ASYNC03);
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
        memo_sheet1_OnLoadFinish(sheetObjects[0]);
        ACMMemoSheet_Open(sheetObjects[0]);    		// CoAcm.js에 정의
        ACMMemoSheet_Close(sheetObjects[0], "");    // CoAcm.js에 정의
        
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
            	case "memo_sheet1":
            		ACMMemoSheet_InitSheet(shtObj, "195");    // CoAcm.js에 정의
                    break;
                case "sheet1":
                    var cnt=0;
                    document.form.pagerows.value=500;
                    var HeadTitle="||FWDR|Vendor|Forwarder|CNT|Amount|AP Office|CSR NO|I/F Date|I/F Remark|" +
                    "Receiving Remark|Pay Amount|Pay Date|Check No.|Method||CSR Created\nTime|CSR Requested|CSR Requested|CSR Approved / Disapproved|CSR Approved / Disapproved";
                    var HeadTitle1="||FWDR|Vendor|Forwarder|CNT|Amount|AP Office|CSR NO|I/F Date|I/F Remark|" +
                    "Receiving Remark|Pay Amount|Pay Date|Check No.|Method||CSR Created\nTime|ID|Name|ID|Name";
                    SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                           {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ff_cnt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"tot_cnt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"tot_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ap_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"if_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"if_rsn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"rcv_rsn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pay_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pay_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ftu_use_ctnt1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pay_mzd_lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:1,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ff_cmpn_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"csr_cre_dt",       KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rqst_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    	   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rqst_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    	   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    	   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                    InitColumns(cols);
                    SetSheetHeight(230);
                    SetEditable(1);
                    SetEditableColorDiff(0);
                    SetWaitImageVisible(0);
                    SetHeaderRowHeight(24);
                    break;
                case "sheet2":
                	   var cnt=0;
                	   document.form.pagerows.value=500;
                	   var HeadTitle="F.F|Vendor|BKG No|B/L No|Ref. No.|I/F AMT|Type|Rate|BKG STS|Remark|";
                	   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                	   var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                	   var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	   InitHeaders(headers, info);
                	   var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ff_cnt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ff_ref_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"if_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ff_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ff_bkg_rt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"ff_cmpn_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ff_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                	   InitColumns(cols);
                       SetEditable(1);
                       SetEditableColorDiff(0);
                       SetWaitImageVisible(0);
                	   SetHeaderRowHeight(24);
                	   SetSheetHeight(230);
                	   break;
                case "sheet3":
                	   var cnt=0;
                	   document.form.pagerows.value=500;
                	   var HeadTitle="FWDR|Vendor|Forwarder|CSR NO|CNT|B/L No|Amount|AP Office|I/F Date|I/F Remark|" + "Receiving Remark|Pay Amount|Pay Date|Check No.|Method";
                	   SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
                	   var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
                	   var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	   InitHeaders(headers, info);
                	   var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ff_cnt_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_lgl_eng_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"tot_cnt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"tot_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ap_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"if_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"if_rsn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"rcv_rsn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pay_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pay_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ftu_use_ctnt1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"pay_mzd_lu_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                	   InitColumns(cols);
                	   SetSheetHeight(150);
                       SetEditable(1);
                       SetEditableColorDiff(0);
                       SetWaitImageVisible(0);
                	   SetHeaderRowHeight(24);
                	   break;
                case "sheet4":    	//sheet4 init
                    var cnt=0;
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
                case "sheet5":      //sheet5 init
                    var cnt=0;
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
                case "sheet6":      //sheet6 init
                    var cnt=0;
                    var HeadTitle="SEQ|CSR No|Vendor|CUR|Amount|Desc";
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"csr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vendor",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cur",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"amount",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						         {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vendor_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
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
//        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
        // OnChange 이벤트
        axon_event.addListener("change", "frmObj_OnChange", "if_opt", "ar_ofc_cd", "asa_no");
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
	    	case IBCLEAR://Office 목록 조회
	    		ComOpenWait(false);
				var sXml=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0){
					ComXml2ComboItem(arrXml[0], f_ap_ofc_cd, "value0", "value0");
					}
				if(frmObj.ofc_cd.value === "NYCHQ"){
					f_ap_ofc_cd.SetMultiSelect(1);	
				}else{
					f_ap_ofc_cd.SetSelectIndex(0);					
				}				
				ComOpenWait(false);
	    		break;        
            case SEARCH01:       //AP Office 목록 조회
                // 로그인한 사용자의 ofc_cd로 ar_ofc_cd를 조회
            	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH08);
                ACMXml2SelectItem(xmlStr, frmObj.ar_ofc_cd, "value0", "value0", false);
                //asa 로직 추가
                var xmlStr1=shtObj.GetSearchData("ESM_ACM_0009GS.do", "f_cmd=" + SEARCH16 + "&agn_cd=" + frmObj.ar_ofc_cd.value).split("|$$|");
                if( typeof(xmlStr1) == "object" ) xmlStr = xmlStr[0];
                //ASA_NAME 콤보 셋팅
                if (ACMXml2SelectItem(xmlStr1, frmObj.asa_no, "asa_name", "asa_no")) {
               	 ComFireEvent(frmObj.asa_no , "change");
                } else {
                  //오늘 날짜로 세팅
            	  frmObj.inv_dt.value=ComGetNowInfo();
                }
                break;                
            case IBSEARCH:       	// 조회(Master)
                if (!ComChkValid(frmObj)) return;
                ComOpenWait(true);
                var shtObj1=sheetObjects[1];
                sheetObjects[2].RemoveAll();
                frmObj.f_cmd.value=SEARCH;
                shtObj1.DoSearch("ESM_ACM_0030GS.do", FormQueryString(frmObj) );
                ComOpenWait(false);
                break;
            case SEARCH02:       	// 조회(Detail)
                ComOpenWait(true);
                var shtObj2=sheetObjects[2];
                frmObj.f_cmd.value=SEARCH02;
                shtObj2.DoSearch("ESM_ACM_0030GS.do", FormQueryString(frmObj) );
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC01:       	// 조회(Master)
                if (!ComChkValid(frmObj)) return;
                if(!validateForm(shtObj,frmObj,sAction))	return;
                ComOpenWait(true);
                var shtObj1=sheetObjects[1];
                sheetObjects[2].RemoveAll();
                frmObj.f_cmd.value=MODIFY;
                shtObj1.DoSave("ESM_ACM_0030GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
                break;
            case IBDOWNEXCEL:    	// 엑셀다운로드
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH03;
                shtObj.DoSearch("ESM_ACM_0030GS.do", FormQueryString(frmObj),{Sync:2} );
                shtObj.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj), SheetDesign:1, Merge:1, HiddenColumn:true });
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC03:  //Print
                if(!validateForm(shtObj,frmObj,sAction))	return false;
				if (frmObj.if_opt.value != "IF") {
					alert("Can't interface. Please check I/F Option.");
					return;
				}
                frmObj.f_cmd.value=MULTI01;
                var sXml=shtObj.GetSearchData("ESM_ACM_0030GS.do", FormQueryString(frmObj));
                shtObj.LoadSearchData(sXml,{Sync:1} );
                //보고서출력
                
                fromObj[0]=frmObj;  //RD로 보내기 위해 배열로담는다
                rdObj[0]=shtObj; //sheet를 RD로 보내기 위해 배열로 담는다
                // RD 로 보내기 위한 설정
                parmObj[0]="1";
                parmObj[1]="";
                parmObj[2]="N";
                parmObj[3]=RD_path + "apps/opus/esm/acm/acmapproval/ffcmpnapproval/report/ESM_ACM_0022.mrd"; //RD 화면
                parmObj[4]=rdObj;
                parmObj[5]=fromObj;
                rdObjModaless(RdReport, parmObj, 1200, 700);
                break;
            case SEARCH05:    	// CSR Print
                if(!validateForm(shtObj,frmObj,sAction))	return false;
				if (frmObj.if_opt.value != "IF") {
					alert("Can't interface. Please check I/F Option.");
					return;
				}
                //체크된 첫번째행의 번호를 읽어와서 Hidden Input에 담는다.
                var sRow=sheetObjects[1].FindCheckedRow("chk");
                var arrRow=sRow.split("|");
                frmObj.csr_no.value=sheetObjects[1].GetCellValue(arrRow[0], "csr_no");
                //보고서출력을 위해 정보 조회
                frmObj.f_cmd.value=PRINT;
                var sXml=shtObj.GetSearchData("ESM_ACM_0030GS.do", FormQueryString(frmObj));
                var arrXml=sXml.split("|$$|");
                var shtObj4=sheetObjects[4];
                var shtObj5=sheetObjects[5];
                //ETC데이터를 IBSheet에 세팅한다.
                shtObj.RemoveEtcData();
                shtObj4.LoadSearchData(arrXml[0],{Sync:1} );
                shtObj5.LoadSearchData(arrXml[1],{Sync:1} );
                //보고서출력
//                rdFromObj=new Array();
//                rdObj=new Array();
//                parmObj=new Array();
                fromObj[0]=frmObj;  //RD로 보내기 위해 배열로담는다
                rdObj[0]=sheetObjects[4]; //sheet를 RD로 보내기 위해 배열로 담는다
                rdObj[1]=sheetObjects[5];
                // RD 로 보내기 위한 설정
                parmObj[0]="1";
                parmObj[1]="";
                parmObj[2]="N";
                parmObj[3]=RD_path + "apps/opus/esm/acm/acmapproval/agncommapproval/report/ESM_ACM_0201A.mrd"; //RD 화면
                parmObj[4]=rdObj;
                parmObj[5]=fromObj;
                rdObjModaless(RdReport, parmObj, 1200, 700);
                break;
            case IBSEARCH_ASYNC02: 	//Clear
                frmObj.apro_step.value="";
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
                case IBSEARCH_ASYNC01:	//Approval
                    if(if_opt.value != "CS") {
                        //Interface Status is invalid. Please check Interface Status.
                        ComShowCodeMessage("ACM00003", "Interface Status", "Interface Status");
                        return false;
                    }
                    if(inv_dt.value == ""){
                        ComShowCodeMessage("COM12114", "Invoice Date");
                        return false;
                    }
//                    if(apro_step.value == ""){
//                        ComShowCodeMessage("COM12114", "Approval Step");
//                        return false;
//                    }
                    var checkCnt=shtObj.CheckedRows("chk");
                    if(checkCnt < 1){
                        //Please select **.
                        ComShowCodeMessage("COM12113", "row for interface");
                        return false;
                    }
                    // AP Office check
                    var sRow=sheetObjects[1].FindCheckedRow("chk");
                    var arrRow=sRow.split("|");
                    for(i=0;i<checkCnt;i++){
                    	if(ar_ofc_cd.value != sheetObjects[1].GetCellValue(arrRow[i], "ap_ofc_cd")){
                            //Please check **.
                            ComShowCodeMessage("COM12114", "AP Office.");                   		
                    		return false;
                    	}
                    }
                    break;
                case SEARCH05:	//Print
                    var checkCnt=sheetObjects[1].CheckedRows("chk");
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
     * 마스터 그리드에서 컬럼을 선택했을때, 디테일 그리드에 상세내역을 조회한다.
     * @param {Object} sheetObj
     * @param {Object} row
     * @param {Object} col
     * @param {Object} value
     */
    function sheet1_OnClick(shtObj, row, col, value) {
        var frmObj=document.form;
        frmObj.hid_ff_cnt_seq.value=shtObj.GetCellValue(row,"ff_cnt_seq");
        frmObj.vndr_seq.value=shtObj.GetCellValue(row,"vndr_seq");
        frmObj.ap_ofc_cd.value=shtObj.GetCellValue(row,"ap_ofc_cd");
        frmObj.csr_no.value=shtObj.GetCellValue(row,"csr_no");
        doActionIBSheet(shtObj, document.form, SEARCH02);
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
                if (ColSaveName(Col) == "vndr_seq") {
                    SetCellValue(Row, Col,aryPopupData[0][2],0);
                } else {
                    SetCellValue(Row, Col,aryPopupData[0][3],0);
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
    function sheet1_OnChange(shtObj, Row, Col, Value) {
        if (Value == "") return;
        with (shtObj) {
            switch (ColSaveName(Col)) {
                case "agn_cd":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                    	SelectCell(Row, Col, true, "");
                    	SetCellValue(Row, Col, "", 0);
                    }
                    break;
                case "ofc_cd":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH03 + "&value0=" + Value + "&value8=Sub Office");
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                    	SelectCell(Row, Col, true, "");
                    	SetCellValue(Row, Col, "", 0);
                    }
                    break;
                case "vndr_seq":
                    // validation
                	var xmlStr=shtObj.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH04 + "&value0=" + Value);
                    if (ACMDecideErrXml(shtObj, xmlStr)) {
                    	SelectCell(Row, Col, true, "");
                    	SetCellValue(Row, Col, "", 0);
                    }
                    break;
            }
        }
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
                SetCellAlign(LastRow(), "ff_cnt_seq","Right");
                SetCellText(LastRow(), "cust_lgl_eng_nm" ,"");
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
     * IBSeet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {ErrMsg} String : 조회 후 메시지
     */
    function sheet2_OnSearchEnd(shtObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (shtObj) {
            if (RowCount()> 0) {
                ReDraw=false;
                SetCellAlign(LastRow(), "ff_cnt_seq","Right");
                ReDraw=true;
            }
        }
    }
    /**
     * Form Element의 OnChange 이벤트
     */
    function frmObj_OnChange() {
        var elementName=ComGetEvent("name");
        var shtObj1=sheetObjects[1];
        var shtObj2=sheetObjects[2];
        with (document.form) {
            switch (elementName) {
                case "if_opt":
                    shtObj1.RemoveAll();
                    shtObj2.RemoveAll();
                    break;
                    
                case "ar_ofc_cd":    //AP Office 변경 시 ASA No 세팅
                    var xmlStr=shtObj1.GetSearchData("ESM_ACM_0009GS.do", "f_cmd=" + SEARCH16 + "&agn_cd=" + ar_ofc_cd.value).split("|$$|");
                    if( typeof(xmlStr) == "object" ) xmlStr = xmlStr[0];

                   //ASA_NAME 콤보 셋팅
                   if (ACMXml2SelectItem(xmlStr, asa_no, "asa_name", "asa_no")) {
                   	ComFireEvent(asa_no , "change");
                   } else {
                   //오늘 날짜로 세팅
                	 inv_dt.value=ComGetNowInfo();
                   }
                   // offsetFlag = "Y"(ar_ofc_cd가 상계 정산 대리점(operational))
                   var xmlStr1 = shtObj1.GetSearchData("ACMCommonGS.do", "f_cmd=" + SEARCH22 + "&value0=" + ar_ofc_cd.value);
                   
                   if(ACMDecideErrXml(shtObj1, xmlStr1)) return;
                   if(ComGetEtcData(xmlStr1, "so_flag") == "N"){ //ASA No.
                   	asa_no.disabled = true;
                 	asa_no.className="input2";
                   }else{
                   	asa_no.disabled = false;
                 	asa_no.className="input";
                   }

                   shtObj1.RemoveAll();
                   shtObj2.RemoveAll();
                   
                   break;  
                   
                case "asa_no":
                    var idx = asa_no.selectedIndex;
                    if(idx >= 0) {
                        //ASA No의 TO_DATE로 세팅
                        var arrAsaNo=document.form.asa_no[idx].text.split('~');
//                    	var split = asaNo.split('~');
                        var temp=ComReplaceStr(arrAsaNo[1], ')', ' ');
                        temp=ComReplaceStr(temp, '/', '-');
                        temp=ComReplaceStr(temp, ' ', '');
                        inv_dt.value=temp;
                    } else {
                        //오늘 날짜로 세팅
                    	inv_dt.value=ComGetNowInfo();
                    }
                    break;                    
            }
        }
    }
    /**
     * F.Forwarder 조회 후 값 Return 받아 셋팅한다.
     */
    function setForwarder(rowArray, row, col) {
        var colArray=rowArray[0];
        document.form.ff_cnt_seq.value=colArray[3];
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
    function sheet1_OnLoadFinish(shtObj) {
        document.form.inv_dt.value=ComGetNowInfo("ymd");
        doActionIBSheet(shtObj, document.form, IBCLEAR);
        doActionIBSheet(shtObj, document.form, SEARCH01);
    }
/* 개발자 작업 끝 */
