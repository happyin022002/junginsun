﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2042.js
*@FileTitle : RFA Rate Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.31 김대호
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나 조회 가능토록 수정  
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만 자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2012.02.08 이석준 [CHM-201216074] RFA 조회시 HAMRU 산하의 BA OFFICE들이 상대방 BA RFA 조회 못하게 했던 부분을 다시 원래대로 조회 할 수 있도록 수정       
* 2013.02.18 전윤주 [CHM-201323103] Request Office 조회 조건에 user office 초기 세팅 Origin, Destination, request office 중에 최소한 1개는 입력 후 조회하도록 변경
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)   
* 2014.04.29 서미진 [CHM-201429649] Rate Search 화면 상 BOF 표시 추가    
=========================================================*/
/**
 * @fileoverview RFA Retrieve 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */ 

    /**
     * @extends Pri
     * @class ESM_PRI_2042 : ESM_PRI_2042 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2042() {
        this.setSheetObject 		= setSheetObject;
        this.setComboObject         = setComboObject;	
        this.loadPage 				= loadPage;
        this.initSheet 				= initSheet;
        this.initCombo              = initCombo;
        this.obj_click              = obj_click;
        this.obj_keypress           = obj_keypress;
        this.obj_deactivate         = obj_deactivate;
        this.processButtonClick		= processButtonClick;
        this.doActionIBSheet 		= doActionIBSheet;
    }

    //  ===================================================================================
    //  전역변수
    //  ===================================================================================
    //  공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheet1;
    var sheet2;

    var comboObjects = new Array();
    var comboCnt = 0;
    //  업무전역변수
    var gCurrDate;
    var gSheet1Width = 0;
    var gCallBackComEns041;
    //  컬럼변수
    var ROW_SUBSUM_GROUP = "row_subsum_group";
    var SUBSUM_GROUP = "subsum_group";
    var SVC_SCP_CD = "svc_scp_cd";
    var CMDT_HDR_SEQ = "cmdt_hdr_seq";
    var ROUT_SEQ = "rout_seq";
    var RT_SEQ = "rt_seq";							
    var RFA_NO = "rfa_no";
    var PRE_RATE = "fnl_frt_rt_amt"; 
    var RATE = "rate";
    var RATE_USD = "rate_usd";

    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /** 
     * IBMultiCombo Object를 comboObjects 배열에 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} combo_obj : IBMultiCombo Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }

    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function loadPage() {

        var form = document.form;	
        sheet1 = sheetObjects[0];
        sheet2 = sheetObjects[1]; // distinct 용
        sheetCnt = sheetObjects.length ;

        //IBMultiCombo 초기화
        comboCnt = comboObjects.length;
        for(var k=0;k<comboCnt;k++){
            initCombo(comboObjects[k],k+1);
        }

        //IBSheet 초기화
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }

        sheet1.WaitImageVisible = false;

        axon_event.addListenerForm('click', 'obj_click', form);	 
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	

        ComEnableObject(form.access_date, false); // access date disabled
        gCurrDate = ComGetNowInfo('ymd', '-');
        form.eff_date_from.value = gCurrDate;
        form.eff_date_to.value = gCurrDate;
        form.prop_scp_ofc_cd.value = form.in_usr_ofc_cd.value;

        initIBComboItem();
    }

    /**
     * IBMultiCombo 에 Item을 setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem();
     * </pre>
     * @return 없음
     * @author 김대호
     * @version 2009.12.15
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(svcScpCdComboValue,     svcScpCdComboText,    	getComboObject(comboObjects, 'svc_scp_cd'),       	 "|", "\t" );      
        ComPriTextCode2ComboItem(chargeComboValue,       chargeComboText,       getComboObject(comboObjects, 'chg_cd'), 		     "|", "\t" );
        getComboObject(comboObjects, 'chg_cd').Code2 = "OFT";
        ComPriTextCode2ComboItem(tpSzComboValue,         tpSzComboText,         getComboObject(comboObjects, 'rat_ut_cd'),           "|", "\t" );
        ComPriTextCode2ComboItem(cargoTypeComboValue,    cargoTypeComboText,    getComboObject(comboObjects, 'prc_cgo_tp_cd'),       "|", "\t" );    
        ComPriTextCode2ComboItem(customerTypeComboValue, customerTypeComboText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(rateComboValue,   		 rateComboValue,    	getComboObject(comboObjects, 'fnl_frt_rt'),       	 "|", "\t" );  
        ComPriTextCode2ComboItem(rateComboValue,    	 rateComboValue,    	getComboObject(comboObjects, 'fnl_mqc'),       		 "|", "\t" );      
        ComPriTextCode2ComboItem(rfaCtrtTpCdValue, rfaCtrtTpCdText, getComboObject(comboObjects, 'rfa_ctrt_tp_cd'),"|","\t" );
    }

    /** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":
                with (sheet1) {
                    //높이 설정
                    style.height = 340;
                    //전체 너비 설정
                    //gSheet1Width = mainTable.clientWidth;
                    //SheetWidth = gSheet1Width;
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    var HeadTitle1 = "Seq.|row_subsum_group|subsum_group|svc_scp_cd|cmdt_hdr_seq|rout_seq|rt_seq|RFA Number|RFA Type|Customer|MVC\n(TEU)|Request\nOffice|Sales\nRep.|Commodity|Actual\nCustomer|Origin\n(POR)|Origin Via\n(POL)|Dest Via\n(POD)|Dest.\n(DEL)|R/D\nTerm|Charge|Cargo\nType|Per|Cur.|Previous\nRate|Rate|Rate USD|Rate(BOF)|Diff|Effective\nDate|PFMC\n(TEU)";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME              ,KEYFIELD,CALCULOGIC,DATAFORMAT    ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0, cnt++ ,dtSeq     ,35     ,daCenter   ,false   ,"seq"                       );                                                      				// Seq.
//                  소계 
                    InitDataProperty(0, cnt++ ,dtData  ,100    ,daCenter   ,false   ,ROW_SUBSUM_GROUP      ,false   ,""        ,dfNone         ,0         ,false       ,false      ); //         
                    InitDataProperty(0, cnt++ ,dtData  ,100    ,daCenter   ,false   ,SUBSUM_GROUP          ,false   ,""        ,dfNone         ,0         ,false       ,false      ); //         
                    InitDataProperty(0, cnt++ ,dtData  ,80     ,daCenter   ,false   ,SVC_SCP_CD            ,false   ,""        ,dfNone         ,0         ,false       ,false      ); //         
                    InitDataProperty(0, cnt++ ,dtData  ,80     ,daCenter   ,false   ,CMDT_HDR_SEQ          ,false   ,""        ,dfNone         ,0         ,false       ,false      ); //          
                    InitDataProperty(0, cnt++ ,dtData  ,80     ,daCenter   ,false   ,ROUT_SEQ              ,false   ,""        ,dfNone         ,0         ,false       ,false      ); //          
                    InitDataProperty(0, cnt++ ,dtData  ,80     ,daCenter   ,false   ,RT_SEQ                ,false   ,""        ,dfNone         ,0         ,false       ,false      ); //          

                    InitDataProperty(0, cnt++ ,dtData    ,80     ,daCenter   ,false   ,RFA_NO                ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // RFA Number  
                    InitDataProperty(0, cnt++ ,dtData    ,60    ,daCenter   ,false   ,"rfa_ctrt_tp_cd"             ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // RFA Type
                    InitDataProperty(0, cnt++ ,dtData    ,125    ,daCenter   ,false   ,"cust_nm"             ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Customer         
                    InitDataProperty(0, cnt++ ,dtData    ,50     ,daRight    ,false   ,"fnl_mqc_qty"         ,false   ,""        ,dfNullInteger  ,0         ,false       ,false      ); // MVC\n(TEU)         
                    InitDataProperty(0, cnt++ ,dtData    ,73     ,daCenter   ,false   ,"prop_scp_ofc_cd"     ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Request\nOffice       
                    InitDataProperty(0, cnt++ ,dtData    ,50     ,daCenter   ,false   ,"prop_scp_srep_cd"    ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Sales\nRep.     
                    InitDataProperty(0, cnt++ ,dtData    ,120    ,daLeft     ,false   ,"cmdt_nm"             ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Commodity
                    InitDataProperty(0, cnt++ ,dtData    ,65     ,daCenter   ,false   ,"act_cust_nm"         ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Actual\nCustomer
                    InitDataProperty(0, cnt++ ,dtData    ,50     ,daCenter   ,false   ,"org_pnt_loc_def_cd"  ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Origin\n(POR)
                    InitDataProperty(0, cnt++ ,dtData    ,60     ,daCenter   ,false   ,"org_via_nm"          ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Origin Via\n(POL)
                    InitDataProperty(0, cnt++ ,dtData    ,50     ,daCenter   ,false   ,"dest_via_nm"         ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Dest Via\n(POD)         
                    InitDataProperty(0, cnt++ ,dtData    ,50     ,daCenter   ,false   ,"dest_pnt_loc_def_cd" ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Dest.\n(DEL)
                    InitDataProperty(0, cnt++ ,dtData    ,50     ,daCenter   ,false   ,"rcv_de_term_cd"      ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // R/D\nTerm
                    InitDataProperty(0, cnt++ ,dtData    ,50     ,daCenter   ,false   ,"chg_cd"              ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // charge
                    InitDataProperty(0, cnt++ ,dtData    ,60     ,daCenter   ,false   ,"prc_cgo_tp_cd"       ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // cargo type
                    InitDataProperty(0, cnt++ ,dtData    ,65     ,daCenter   ,false   ,"rat_ut_cd"           ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // Per
                    InitDataProperty(0, cnt++ ,dtData    ,50     ,daCenter   ,false   ,"curr_cd"             ,false   ,""        ,dfNone         ,0         ,false       ,false      ); // currency
                    InitDataProperty(0, cnt++ ,dtData    ,60     ,daRight    ,false   ,PRE_RATE              ,false   ,""        ,dfNullFloat    ,2         ,false       ,false      ); // pre rate
                    InitDataProperty(0, cnt++ ,dtData    ,80     ,daRight    ,false   ,RATE                  ,false   ,""        ,dfNullFloat    ,2         ,false       ,false      ); // rate
                    InitDataProperty(0, cnt++ ,dtHidden  ,60     ,daRight    ,false   ,RATE_USD              ,false   ,""        ,dfNullFloat    ,2         ,false       ,false      ); // rate usd
                    InitDataProperty(0, cnt++ ,dtData    ,80     ,daRight    ,false   ,"fnl_bof_amt"         ,false   ,""        ,dfNullFloat    ,2         ,false       ,false      ); // bof_amt
                    InitDataProperty(0, cnt++ ,dtData    ,60     ,daRight    ,false   ,"diff_amt"            ,false   ,""        ,dfNullFloat    ,2         ,false       ,false      ); // diff
                    InitDataProperty(0, cnt++ ,dtData    ,70     ,daCenter   ,false   ,"eff_dt"              ,false   ,""        ,dfDateYmd      ,0         ,false       ,false      ); // eff dt
                    InitDataProperty(0, cnt++ ,dtData    ,60     ,daRight    ,false   ,"prs_crnt_lod_qty"    ,false   ,""        ,dfNullFloat    ,2         ,false       ,false      ); // pfmc

                    ExtendLastCol = true;
                    Ellipsis = true;
                    // 소계
                    ColHidden(ROW_SUBSUM_GROUP) = true;									
                    ColHidden(SUBSUM_GROUP) = true;						
                    ColHidden(SVC_SCP_CD) = true;				
                    ColHidden(CMDT_HDR_SEQ) = true;				
                    ColHidden(ROUT_SEQ) = true;				
                    ColHidden(RT_SEQ) = true;				
                    // Receiving/Delivering Tem 
                    ColHidden("rcv_de_term_cd") = true;				
                    //Previous Rate
                    ColHidden(PRE_RATE) = true;
                    ColHidden("diff_amt") = true;
                    ColHidden("eff_dt") = true;

                }
                break;

            case "sheet2": // find_text 용
                with (sheet2) {

                    //높이 설정
                    style.height = 20;
                    //전체 너비 설정
                    SheetWidth = 300;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
                    var HeadTitle1 = "f_text1"
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME   ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0 ,cnt++ ,dtData   ,200  ,daLeft   ,false   ,"f_text1"  ,false   ,""        ,dfNone    ,0 );

                    var idx = sheet2.DataInsert();

                    Visible = false; // backendjob 용으로 같이씀 참고 : 0015

                }
                break;

        }
    }

    /** 
     * IBMultiCombo 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 콤보가 다수일 경우 시트 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBMultiCombo} comboObj : 시트오브젝트
     * @param {int} comboNo : 콤보오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function initCombo(comboObj, comboNo) {
        switch (comboObj.id) {
            // svc scope
            case "svc_scp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
                }
                break;
                // charge
            case "chg_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
                }
                break;
                // tp sz
            case "rat_ut_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 1);    // 영문대문자 + 숫자 만 입력
                    MaxLength = 2;      // 2자리만 입력
                }
                break;
                // cargo type
            case "prc_cgo_tp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자 만 입력
                    MaxLength = 2;      // 2자리만 입력
                }
                break;
                //customer type
            case "prc_ctrt_cust_tp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자 만 입력
                }
                break;
                // rate			
            case "fnl_frt_rt":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    MaxLength = 2;      // 2자리만 입력
                }
                break;
                // mqc
            case "fnl_mqc":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    MaxLength = 2;      // 2자리만 입력
                }
                break;
            case "rfa_ctrt_tp_cd":
                var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxLength = 8;      // 8자리만 입력
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                }    
                break; 
        }
    }      

    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick = processButtonClick;

    /** 
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function processButtonClick(){
        var form = document.form;
        var rdoDateObj = form.rdoDate;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

                case "btns_calendar1": //달력버튼
                case "btns_calendar2":
                    if(rdoDateObj[1].checked){
                        return;
                    }
                    var cal = new ComCalendar();
                    if(srcName == "btns_calendar1"){
                        cal.select(form.eff_date_from, 'yyyy-MM-dd');
                    }else{
                        cal.select(form.eff_date_to, 'yyyy-MM-dd');
                    }
                    break;

                case "btns_calendar3": //달력버튼
                    if(rdoDateObj[0].checked){
                        return;
                    }
                    var cal = new ComCalendar();
                    cal.select(form.access_date, 'yyyy-MM-dd');
                    break;

                case "btn_cust":
                case "btn_ctrt_cust":
                    gCallBackComEns041 = srcName;
                    //btn_cust
                    var custCd = form.cust_cnt_cd.value + form.cust_seq.value;
                    if(form.cust_cnt_cd.value == ""){
                        custCd = "";
                    }
                    //btn_ctrt_cust
                    if(srcName == "btn_ctrt_cust") {
                        custCd = form.ctrt_cust_cnt_cd.value + form.ctrt_cust_seq.value;
                        if(form.ctrt_cust_cnt_cd.value == ""){
                            custCd = "";
                        }
                    }
                    ComOpenPopup("/hanjin/COM_ENS_041.do?cust_cd="+custCd, 770, 420, "callBackComEns041", '1,0,1,1,1,1,1', false);
                    break;   

                case "btn_commodity": //prc_cmdt_def_cd
                    var param = "";
                    /*
	    		var param = "?rep_cmdt_cd=" + formObject.rep_cmdt_cd.value;
	    		param += "&cmdt_cd=" + formObject.cmdt_cd.value;
	    		param += "&cmdt_nm=" + formObject.cmdt_nm.value;
                     */
                    ComOpenPopup("/hanjin/COM_ENS_011.do" + param, 780, 445, "getCOM_ENS_011", "1,0,1,1,1,1,1,1", true);
                    break;

                case "ComOpenPopupWithTarget":	// Office Code 가져오기 팝업
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 430, "ofc_cd:prop_scp_ofc_cd", "1,0,1,1,1,1,1,1", true);
                    searchSRep();
                    break;

                case "btn_retrieve":
                    setParamsClear();
                    if (validateForm(sheet1, form, IBSEARCH)) {
                        doActionIBSheet(sheet2, form, IBBATCH);
                    }
                    break;

                case "btn_new":
                    doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;

                case "btn_viewrfa":
                    var currRow = sheet1.SelectRow;
                    if(currRow < 1) return;
                    var popParams = "rfa_no_2043=" + sheet1.CellValue(currRow, "rfa_no");
                    comCallPop("ESM_PRI_2003", "ESM_PRI_2042", popParams, "");
                    break;

            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    /** 
     * Object 의 Keypress 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function obj_keypress(){
        var obj = event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;
        switch(obj.dataformat){
            case "ymd": //날짜 입력하기
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": //숫자만 입력
            case "number": //숫자만 입력
                ComKeyOnlyNumber(obj);
                break;
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "uppernum":
                ComKeyOnlyAlphabet('uppernum');
                break;
            default:
                //ComKeyOnlyNumber(obj);
                break;
        }
    }

    /**
     * Object 의 Onclick 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.24
     */
    function obj_click(){
        var form = document.form;
        var obj = event.srcElement;
        var objEffDtFrom = form.eff_date_from;
        var objEffDtTo = form.eff_date_to;
        var objAccessDt = form.access_date;
        var tmpDt;
        switch(obj.name){
            case "rdoDate":
                if(obj.value == "2") {
                    tmpDt = objAccessDt.value;
                    objAccessDt.value = "";
                    ComEnableObject(objAccessDt, false);
                    ComEnableObject(objEffDtFrom, true);
                    ComEnableObject(objEffDtTo, true);
                    objEffDtFrom.className = "input1";
                    objEffDtTo.className = "input1";
                    if(tmpDt.length >= 8) {
                        objEffDtFrom.value = tmpDt;
                        objEffDtTo.value = tmpDt;
                    }else{
                        objEffDtFrom.value = gCurrDate;
                        objEffDtTo.value = gCurrDate;
                    }
                }else{
                    tmpDt = objEffDtFrom.value;
                    objEffDtFrom.value = "";
                    objEffDtTo.value = "";
                    ComEnableObject(objEffDtFrom, false);
                    ComEnableObject(objEffDtTo, false);
                    ComEnableObject(objAccessDt, true);
                    objAccessDt.className = "input1";
                    if(tmpDt.length >= 8) {
                        objAccessDt.value = tmpDt;
                    }else{
                        objAccessDt.value = gCurrDate;
                    }
                }
                break;

            case "chkDisplay":
                var colNm = obj.value;
                var colWidth = sheet1.ColWidth(colNm); 
                var bool = true;
                if(obj.checked){
                    bool = false;
                }
                sheet1.ColHidden(colNm) = bool;
                if(bool) {
                    gSheet1Width = gSheet1Width - colWidth;
                    //sheet1.ColWidth(colNm) = sheet1.ColWidth("dummyField") + colWidth;
                    //sheet1.ColHidden("dummyField") = false;	 		
                } else {
                    gSheet1Width = gSheet1Width + colWidth;
                    //sheet1.ColWidth(colNm) = sheet1.ColWidth("dummyField") - colWidth;
                    //sheet1.ColHidden("dummyField") = true;	 		
                }
                //sheet1.AutoSizeMode = false;
                //sheet1.SheetWidth = gSheet1Width;
                //sheet1.AutoSizeMode = true;            
                //sheet1.FitColWidth();
                break;

            case "previous_rate":
                var chgCdObj = form.chg_cd;
                if(obj.checked) {
                    chgCdObj.Code2 = "OFT";
                    chgCdObj.Enable = false;
                    obj.value = "Y";
                    sheet1.ColHidden(PRE_RATE) = false;
                    sheet1.ColHidden("diff_amt") = false;
                    sheet1.ColHidden("eff_dt") = false;
                }else{
                    chgCdObj.Enable = true;	 			
                    obj.value = "N";
                    sheet1.ColHidden(PRE_RATE) = true;
                    sheet1.ColHidden("diff_amt") = true;
                    sheet1.ColHidden("eff_dt") = true;
                }
                break;
        }
        //if(obj.dataformat == null) return;
    }

    /**
     * OnBeforeActivate event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param 없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2010.02.26
     */      
    function obj_activate() {
        ComClearSeparator (event.srcElement);
    }

    /** 
     * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function obj_deactivate() {
        var formObj = event.srcElement;
        var srcName = formObj.getAttribute("name");
        switch(srcName) {
            case "rfa_no": // RFA No. 
            case "prc_cmdt_def_cd": // Commodity
            case "prop_scp_ofc_cd":
            case "prop_scp_srep_cd":
            // 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - ComChkObjValid : dataformat(uppernum)이 없어 skip처리
            case "rout_pnt_loc_def_cd_ori":		// Origin
            case "rout_via_port_def_cd_ori":	// Origin Via
            case "rout_via_port_def_cd_dest":	// Dest Via
            case "rout_pnt_loc_def_cd_dest":	// Destination
                break;
            case "cust_seq":
            case "ctrt_cust_seq":
                if (formObj.value.length < 6 && formObj.value.length != 0 ){
                    formObj.value = ComLpad(formObj.value, 6, "0");
                }
                break;
            default :
                ComChkObjValid(formObj);
        }

        switch(srcName) {
            case "prop_scp_ofc_cd":
                searchSRep();
                break;
        }

    }

    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**                                                                                            
     * Actual Coustomer, Coustomer 의 코드값을 받기 위한 CallBack 함수 callBackComEns041 <br>      
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  없음                                  
     * @return 없음                                                                                 
     * @see #                                                                                       
     * @author 김대호                                                                               
     * @version 2009.08.12                                                                          
     */  
    function callBackComEns041(rArray){
        var form = document.form;
        if(rArray != null){
            var colArray = rArray[0];
            var ctrtCustCntCd = colArray[3].substring(0,2); 
            var ctrtCustSeq = ComLpad(colArray[3].substring(2),6,"0");
            if(gCallBackComEns041 == "btn_cust") {
                form.cust_cnt_cd.value = ctrtCustCntCd;
                form.cust_seq.value = ctrtCustSeq;
            }else if(gCallBackComEns041 == "btn_ctrt_cust"){
                form.ctrt_cust_cnt_cd.value = ctrtCustCntCd;
                form.ctrt_cust_seq.value = ctrtCustSeq;
            }
        }                   
    }    

    /**                                                                                            
     * Rep. Commodity 팝업창 선택값 Return <br>      
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBMultiCombo} comboObj : 콤보오브젝트                                               
     * @param  {IBMultiCombo} objCd : 선택된 코드값                                                 
     * @param  {IBMultiCombo} objTxt : 코드값에 해당하는 텍스트                                     
     * @return 없음                                                                                 
     * @see #                                                                                       
     * @author 김대호                                                                               
     * @version 2009.08.12                                                                          
     */  
    function getCOM_ENS_011(rowArray){
        var form = document.form;
        var colArray = rowArray[0];
        //alert("colArray[0] : [" + colArray[0] + "]\n\n" + "colArray[1] : [" + colArray[1] + "]\n\n" + "colArray[2] : [" + colArray[2] + "]\n\n" + "colArray[3] : [" + colArray[3] + "]\n\n" + "colArray[4] : [" + colArray[4] + "]\n\n" + "colArray[5] : [" + colArray[5] + "]\n\n" + "colArray[6] : [" + colArray[6] + "]");
        //form.rep_cmdt_cd.value = colArray[4]; // Rep. Commodity - btn_rep_cmdt_cd
        //form.cmdt_cd.value = colArray[2]; // Commodity - cmdt_cd
        //form.cmdt_nm.value = colArray[3]; // Commodity - btn_cmdt_cd
        form.prc_cmdt_def_cd.value = colArray[2]; // Commodity - cmdt_cd
    }

    /**                                                                                            
     * svc scope 의 콤보 오브젝트를 선택변경시 발생하는 svc_scp_cd_OnChange 이벤트핸들러 <br>      
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBMultiCombo} comboObj : 콤보오브젝트                                               
     * @param  {IBMultiCombo} objCd : 선택된 코드값                                                 
     * @param  {IBMultiCombo} objTxt : 코드값에 해당하는 텍스트                                     
     * @return 없음                                                                                 
     * @see #                                                                                       
     * @author 김대호                                                                               
     * @version 2009.08.12                                                                          
     */  
    function svc_scp_cd_OnChange(comboObj, Code, Text) {
        var form = document.form;
        //var code = comboObj.FindIndex(comboObj.Code, 0);
        //var code = comboObj.Code;
        //if (Code != null && Code != "") {
        var text = comboObj.GetText(Code, 1);
        form.svc_scp_nm.value = text;
        //}else{
        //	form.svc_scp_nm.value = "";
        //}
    }

    /** 
     * S.Rep 조회 이벤트 발생시 호출하는 searchSRep 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function searchSRep() {
        return true;
        //doActionIBSheet2(sheet2, form, IBSEARCH_ASYNC01)
    }

    /** 
     * S.Rep 콤보포커스 해제시 발생하는 prop_scp_srep_cd_OnBlur 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo 오브젝트
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function prop_scp_srep_cd_OnBlur(actObj) {
        var form = document.form;
        var code = actObj.Code;
        var text = actObj.GetText(code, 1);
        form.prop_scp_srep_nm.value = text;
    }

    /** 
     * sheet1 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {string} errMsg : 에러메세지  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
        if (errMsg == "") {
            var form = document.form;
            var chargeObj = form.chg_cd;
            if(sheet1.RowCount > 0) {

                ComOpenWait(true);			

                var startRow = sheet1.HeaderRows;
                var endRow = sheet1.HeaderRows + sheet1.RowCount;
                var chkDiffAmt = 0;
                for(var i = startRow; i < endRow; i++) {
                    chkDiffAmt = sheet1.CellValue(i, "diff_amt");
                    //sheet1.CellFont("FontColor", i, "chk", i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0); //빨간색
                    if( null != chkDiffAmt && "" != chkDiffAmt ) {
                        if( parseFloat(chkDiffAmt) > 0 ) {
                            sheet1.CellFontColor(i, "diff_amt") = sheet1.RgbColor(0, 0, 255);
                        }else{
                            sheet1.CellFontColor(i, "diff_amt") = sheet1.RgbColor(255, 0, 0);
                        }
                    }
                }
                // charge 미선택시만 subsum 보여줌...
                if(null == chargeObj.Code || "" == chargeObj.Code) {

                    //var subSumStdColNm = SUBSUM_GROUP;
                    var subSumStdColNm = ROW_SUBSUM_GROUP;
                    var subSumColNm = RATE_USD;
                    var realSumColNm = "seq=;curr_cd=USD;" + RATE + "=|" + RATE_USD + "|";

                    sheet1.ShowSubSum(subSumStdColNm, subSumColNm, -1, false, false, -1, realSumColNm, "", false);

                    var subSumRows = sheet1.FindSubSumRow(subSumStdColNm);
                    var subSumArr = subSumRows.split("|");
                    var subSumArrLen = subSumRows.split("|").length - 1;
                    //var tmpVal;
                    for(var i = 0; i < subSumArrLen; i++) {
                        //tmpVal = "USD " + sheet1.CellValue(subSumArr[i], RATE_USD);
                        //sheet1.InitCellProperty(subSumArr[i], RATE, dtData, daRight, RATE, "", dfNone);
                        //sheet1.CellValue(subSumArr[i], RATE) = tmpVal;
                        sheet1.CellFont("FontBold", subSumArr[i], "curr_cd", subSumArr[i], RATE) = true;
                    }

                }

                ComOpenWait(false);			

            }
        }
    }   

    /** 
     * sheet1 데이터 조회하기위한 파라미터 초기화하는 setParamsClear 이벤트핸들러 <br>
     * <br><b>Example :</b>	
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.01
     */ 
    function setParamsClear() {
        var form = document.form;
        for(var i = 0; i < form.length; i++){
            var formObj = form.elements[i];
            if(formObj.id == "searchParam") {
                formObj.value = "";
            }
        }
    }

    //  ===================================================================================
    //  서버 조회/저장
    //  ===================================================================================
    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheet1.ShowDebugMsg = false;

        switch(sAction) {
            case IBBATCH: //backendjob 조회

                try {

                    var rdoDtObj = formObj.rdoDate;
                    if(rdoDtObj[0].checked){
                        formObj.eff_dt.value = formObj.eff_date_from.value;
                        formObj.exp_dt.value = formObj.eff_date_to.value;
                    }else{
                        var accDt = formObj.access_date.value;
                        formObj.eff_dt.value = accDt;
                        formObj.exp_dt.value = accDt;
                    }
                    var preRate = formObj.previous_rate.value;
                    formObj.f_cmd.value = COMMAND01;

                    ComOpenWait(true);
                    sheet1.WaitImageVisible = false;
                    sheet2.WaitImageVisible = false;

                    var sXml = sheet2.GetSearchXml("ESM_PRI_2042GS.do", FormQueryString(formObj) + "&is_prerate=" + preRate);
                    var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value = backendJobKey;
                        sheet2.RequestTimeOut = 10000;
                        timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에
                        // getBackEndJobStatus함수
                        // 실행 - 재귀호출
                    }else{
                        ComOpenWait(false);
                    }
                }catch(e){
                    ComShowMessage(e);
                    ComOpenWait(false);
                }

                break;

            case IBCREATE: // New
                if (formObj.chkDisplay.checked) {
                	formObj.chkDisplay.click();
                }
                if (formObj.previous_rate.checked) {
                	formObj.previous_rate.click();
                } 
                formObj.reset();
                formObj.svc_scp_cd.Index = "-1";
                formObj.chg_cd.Index = "-1";
                formObj.rat_ut_cd.Index = "-1";
                formObj.prc_cgo_tp_cd.Index = "-1";
                formObj.prc_ctrt_cust_tp_cd.Index = "-1";
                formObj.fnl_frt_rt.Index = "-1";
                formObj.fnl_mqc.Index = "-1";
                formObj.rfa_ctrt_tp_cd.Index = "-1";
                formObj.rdoDate[0].click();                
    	        sheetObjects[0].RemoveAll();
    	        sheetObjects[1].RemoveAll();
                break;

            case IBDOWNEXCEL:      //download excel
                sheet1.SpeedDown2Excel(-1); //, "chk|seq"
                //sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
                break;

        }
    }

    /** 
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function getBackEndJobStatus() {
        try {
            var form = document.form;	
            form.f_cmd.value = SEARCH;
            var sXml = sheet2.GetSearchXml("ESM_PRI_2042GS.do", FormQueryString(form));
            var jobState = ComGetEtcData(sXml, "jb_sts_flg");
            if (jobState == "3") {
                getBackEndJobLoadFile();
                clearInterval(timer);
            } else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
                ComShowCodeMessage("PRI00338"); //msgs['PRI00338'] = 'Failed to download. Please try again.';
                clearInterval(timer);	
                ComOpenWait(false);	
            } else if (jobState == "5") {
                ComShowCodeMessage("PRI00339"); //msgs['PRI00339'] = 'Data was downloaded successfully.';
                clearInterval(timer);
                ComOpenWait(false);	
            }
        }catch(e){
            ComShowMessage(e);
            ComOpenWait(false);
        }
    }

    /** 
     * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital) <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function getBackEndJobLoadFile() {
        try {
            var form = document.form;
            form.f_cmd.value = SEARCHLIST;
            var sXml = sheet1.GetSearchXml("ESM_PRI_2042GS.do", FormQueryString(form));
            sheet1.LoadSearchXml(sXml);
            //form.result.value = ComGetEtcData(sXml, "RESULT");
        }catch(e){
            ComShowMessage(e);
        }finally{
            ComOpenWait(false);		
        }
    }

    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet2 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function doActionIBSheet2(sheetObj, formObj, sAction) {

        sheet2.ShowDebugMsg = false;
        sheet2.WaitImageVisible = false;

        switch(sAction) {
            case IBSEARCH_ASYNC01: //s rep
                var params = "f_cmd=" + SEARCH15 +"&etc1=" + formObj.prop_scp_ofc_cd.value;
                var sXml = sheet2.GetSearchXml("PRICommonGS.do?", params);
                formObj.prop_scp_srep_cd.RemoveAll();
                ComPriXml2ComboItem(sXml, formObj.prop_scp_srep_cd, "cd", "cd|nm");
                formObj.prop_scp_srep_cd.InsertItem(0, "", "");
                formObj.prop_scp_srep_nm.value = "";
                break;
        }
    }

    /** 
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function validateForm(sheetObj, formObj, sAction){
        var form = document.form;
        var svcScpCdObj = form.svc_scp_cd;
        var rdoDateObj = form.rdoDate;
        var effDtFromObj = form.eff_date_from;
        var effDtToObj = form.eff_date_to;
        var accessDtObj = form.access_date;
        //var chgCd = form.chg_cd;	
        var routPntLocDefCdOri = form.rout_pnt_loc_def_cd_ori;	
        var routPntLocDefCdDest = form.rout_pnt_loc_def_cd_dest;
        var prop_scp_ofc_cd = form.prop_scp_ofc_cd;

        switch (sAction) {
            case IBSEARCH: //조회
                //msgs['PRI00308'] = 'Please {?msg1} {?msg2}.';
                //msgs['PRI00335'] = '[{?msg1}]가(이) 입력되지 않았습니다.';
                //msgs['PRI00337'] = '[{?msg1}]가(이) 선택되지 않았습니다.';
                if(null == svcScpCdObj.Code || "" == svcScpCdObj.Code) {
                    ComShowCodeMessage("PRI00335", "SVC Scope");
                    ComSetFocus(svcScpCdObj);
                    return false;
                }
                if(rdoDateObj[0].checked) {
                    if(effDtFromObj.value == "") {
                        ComShowCodeMessage("PRI00335", "RFA EFF Date");
                        ComSetFocus(effDtFromObj);
                        return false;
                    }
                    if(effDtToObj.value == "") {
                        ComShowCodeMessage("PRI00335", "RFA EFF Date");
                        ComSetFocus(effDtToObj);
                        return false;
                    }
                    if(!ComChkObjValid(effDtFromObj)) {return false;}
                    if(!ComChkObjValid(effDtToObj)) {return false;}
                }else{
                    if(accessDtObj.value == "") {
                        ComShowCodeMessage("PRI00335", "Access Date");
                        ComSetFocus(accessDtObj);
                        return false;
                    }
                    if(!ComChkObjValid(accessDtObj)) {return false;}
                }
            
            //Origin, Destination, request office 중에 최소한 1개는 입력해야 함
			if(routPntLocDefCdOri.value == "" && routPntLocDefCdDest.value == "" && prop_scp_ofc_cd.value == "") {
				ComShowCodeMessage("PRI07046");
				ComSetFocus(routPntLocDefCdOri);
				return false;
			}
//       		if(routPntLocDefCdDest.value == "") {
//				ComShowCodeMessage("PRI00335", "Destination");
//				ComSetFocus(routPntLocDefCdDest);
//				return false;
//    		}
//                 */
                /*
	    	if( null == chgCd.Code || "" == chgCd.Code) {
				ComShowCodeMessage("PRI00337", "Charge");
	    		ComSetFocus(chgCd);
	    		return false;
	    	}
                 */

                break;
        }

        return true;

    }