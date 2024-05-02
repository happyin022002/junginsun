/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_ACM_0117.js
*@FileTitle  : FF Compensation Details & History for B/L
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/* 개발자 작업 */
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var currentRow=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var shtObj=sheetObjects[1];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch (srcName) {
                case "btn_retrieve":
                    doActionIBSheet(shtObj, frmObj, IBSEARCH);
                    break;
                case "btn_new":
                    ComResetAll();
                    frmObj.bl_no.value="";
                    frmObj.bkg_no.value="";
                    break;
                 case "btn_Close":
                	 ComClosePopup(); 
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
        // sheet2_OnLoadFinish 메서드 존재시 반드시 참조
        sheet2_OnLoadFinish(sheetObjects[1]);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(shtObj, shtNo) {
        var cnt=0;
        with (shtObj) {
            switch(shtNo) {
                case 1:      //sheet1 init
                    var HeadTitle="CHG|AMT";
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
                                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_chg_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 } ];
                     
                    InitColumns(cols);
                    SetEditable(0);
                    SetWaitImageVisible(0);
                    SetSheetHeight(200);
                    break;
                case 2:      //sheet2 init
                    var HeadTitle="CA\nSEQ|Freight Status|Freight Status|Freight Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|CNTR Status|AMT DIFF|Calc Date|Status|Remark|IF Date";
                    var HeadTitle1="CA\nSEQ|Commissionable|Rate|Commission|BOX(CNT/AMT)|BOX(CNT/AMT)|TEU(CNT/AMT)|TEU(CNT/AMT)|FEU(CNT/AMT)|FEU(CNT/AMT)|REU(CNT/AMT)|REU(CNT/AMT)|Commission|AMT DIFF|Calc Date|Status|Remark|IF Date";
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ff_cmpn_seq",     KeyField:0,   CalcLogic:"",   Format:"" },
	                           {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"act_comm_able",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
	                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ff_bkg_rt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
	                           {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"act_comm_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
	                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_bx_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1 },
	                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ff_bx_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
	                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_teu_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1 },
	                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ff_teu_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
	                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_feu_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1 },
	                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ff_feu_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
	                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_rf_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1 },
	                           {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ff_rf_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
	                           {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_comm_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
	                           {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"if_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
	                           {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
	                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ff_cmpn_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	                           {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"ff_cmpn_rmk",     KeyField:0,   CalcLogic:"",   Format:"" },
	                           {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"if_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
	                           {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ff_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	                           {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ff_seq",          KeyField:0,   CalcLogic:"",   Format:"" },
	                           {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ff_agmt_seq",     KeyField:0,   CalcLogic:"",   Format:"" } ];
                     
                    InitColumns(cols);
                    SetEditable(0);
                    SetWaitImageVisible(0);
                    SetHeaderRowHeight(10);
                    SetSheetHeight(160);
                    SetRangeBackColor(1,1,1,12,"#555555");

                    break;
                case 3:      //sheet3 init
                	         var HeadTitle="SEQ|F/Forwarder|Name|Shipper|Name|POR TP|POR|POL TP|POL|POD TP|POD|EFF DT|EXP DT|SC No|RFA No|Commodity TP|Commodity|Commodity|Type|Rate|Box AMT|TEU AMT|FEU AMT|REU AMT|CHG|Kind";
                	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                	         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                	         var headers = [ { Text:HeadTitle, Align:"Center"} ];
                	         InitHeaders(headers, info);
                	         var cols = [{Type:"Seq",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                	             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ff_cnt_seq" },
		                	             {Type:"Text",     Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"ff_cnt_cust_nm" },
		                	             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"shpr_cnt_seq" },
		                	             {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"shpr_cnt_nm" },
		                	             {Type:"Combo",    Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"por_grp_tp_cd" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"por_rout_cd" },
		                	             {Type:"Combo",    Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pol_grp_tp_cd" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_rout_cd" },
		                	             {Type:"Combo",    Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pod_grp_tp_cd" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_rout_cd" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fm_eff_dt" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"to_eff_dt" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sc_no" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rfa_no" },
		                	             {Type:"Combo",    Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_tp_cd" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd" },
		                	             {Type:"Text",     Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ff_div_cd" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ff_bkg_rt" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ff_bx_amt" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ff_teu_amt" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ff_feu_amt" },
		                	             {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ff_rf_amt" },
		                	             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ff_chg_ctnt" },
		                	             {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ff_knd_cd" } ];                	          
                	         InitColumns(cols);
                	         SetEditable(0);
                	         SetWaitImageVisible(0);
                	         SetColProperty("por_grp_tp_cd", {ComboText:grpTpText, ComboCode:grpTpCode} );
                         	 SetColProperty("pol_grp_tp_cd", {ComboText:grpTpText, ComboCode:grpTpCode} );
                         	 SetColProperty("pod_grp_tp_cd", {ComboText:grpTpText, ComboCode:grpTpCode} );
                         	 SetColProperty("ff_div_cd", {ComboText:ffCmpnDivCode, ComboCode:ffCmpnDivCode} );
                         	 SetColProperty("cmdt_tp_cd", {ComboText:"*|Rep|Common", ComboCode:"*|2|3"} );
                         	 SetSheetHeight(160);
                         	
                    break;
            }
        }
    }
    /**
     * Form의 Conrol 초기화 및 초기 이벤트 등록
     */
    function initControl() {
        // 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력) - CoAcm.js에 정의
        axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate", document.form);
        axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
        //axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
        switch (sAction) {
            case IBSEARCH:     // 조회
                if (frmObj.bl_no.value == "" && frmObj.bkg_no.value == "") {
                    ComShowMessage(ComGetMsg("COM12138", "B/L", "Booking No.", ""));
                    bl_no.focus();
                    return false;
                }
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                 var xmlStr=shtObj.GetSearchData("ESM_ACM_0117GS.do", FormQueryString(frmObj)).split("|$$|");
                shtObj.LoadSearchData(xmlStr[0],{Sync:1} );
                sheetObjects[0].LoadSearchData(xmlStr[1],{Sync:1} );
                ComEtcDataToForm(frmObj, shtObj);    //조회된 ETC데이터를 Form의 Hidden오브젝트에 담는다.
                ComOpenWait(false);
                break;
            case SEARCH01:     // Rate 상세 조회
                ComOpenWait(true);
                shtObj.DoSearch("ESM_ACM_0117GS.do", "f_cmd=" + SEARCH01 + CondParam, {Sync:2} );
                ComOpenWait(false);
                break;
        }
    }
    /**
     * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
     * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
     */
   function sheet2_OnLoadFinish(shtObj) {
        // 조회조건의 Office Select Object 생성
        doActionIBSheet(shtObj, document.form, IBSEARCH);
    }
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet2_OnDblClick(shtObj, Row, Col) {
        with (shtObj) {
            doActionIBSheet(sheetObjects[2], document.form, SEARCH01, "&ff_cnt_cd=" + GetCellValue(Row, "ff_cnt_cd") + "&ff_seq=" + GetCellValue(Row, "ff_seq") + "&ff_agmt_seq=" + GetCellValue(Row, "ff_agmt_seq"));
        }
    }
/* 개발자 작업 끝 */
