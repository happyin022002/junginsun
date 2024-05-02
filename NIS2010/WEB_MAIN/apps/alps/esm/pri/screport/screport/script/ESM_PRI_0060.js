/*=========================================================
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ESM_PRI_0060.js
 * @FileTitle : Rate Search
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.09.09
 * @LastModifier : 김대호
 * @LastVersion : 1.0
 * 2009.09.09 김대호
 * 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.11.08 이석준 [CHM-201114235-01] PSC,BUC,OFT에 대한 복합 조회 기능 추가
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
* 2012.02.09 서미진 [CHM-201216139] Down Excel 시, Hidden Column이 엑셀파일에 보여지지 않는 부분 수정
* 2012.02.09 서미진 [CHM-201216140] Charge select box 에 2가지 항목 추가 요청  1. OFT + FRC   2. OFT + FRC + PSC
* 2015.04.06 송호진 [CHM-201534007] Rate Search & PFMC Summary - Detail 의 Actual Customer ComboList 조회시 4000 Byte Over 문제 해결
=========================================================*/
/**
 * @fileoverview  Rate Search 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_0060 : ESM_PRI_0060 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0060() {
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
    var sheet3;

    var comboObjects = new Array();
    var comboCnt = 0;
    //  업무전역변수
    var gCurrDate;
    var gBefParam = "";
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
        sheet2 = sheetObjects[1]; // commodity, actual customer 콤보
        sheet3 = sheetObjects[2]; // backendjob 용
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

        //html컨트롤 이벤트초기화    
        //initControl()
        axon_event.addListenerForm('click', 'obj_click', form);	 
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		        	    	

        gCurrDate = ComGetNowInfo('ymd', '-');
        form.eff_dt.value = gCurrDate;
        form.exp_dt.value = gCurrDate;

        initIBComboItem();

        setScNoMendatory();

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
        ComPriTextCode2ComboItem(chargeComboValue,       chargeComboText,       getComboObject(comboObjects, 'chg_cd'), 		     "|", "\t" );
        getComboObject(comboObjects, 'chg_cd').Code2 = "OFT";
        ComPriTextCode2ComboItem(customerTypeComboValue, customerTypeComboText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(tpSzComboValue,         tpSzComboText,         getComboObject(comboObjects, 'rat_ut_cd'),           "|", "\t" );
        getComboObject(comboObjects, 'rat_ut_cd').Code2 = "D4";
        ComPriTextCode2ComboItem(cargoTypeComboValue,    cargoTypeComboText,    getComboObject(comboObjects, 'prc_cgo_tp_cd'),       "|", "\t" );    
        getComboObject(comboObjects, 'prc_cgo_tp_cd').Code2 = "DR";
        ComPriTextCode2ComboItem(rateComboValue,   		 rateComboValue,    	getComboObject(comboObjects, 'fnl_frt_rt'),       	 "|", "\t" );  
        ComPriTextCode2ComboItem(rateComboValue,    	 rateComboValue,    	getComboObject(comboObjects, 'fnl_mqc'),       		 "|", "\t" );      
        ComPriTextCode2ComboItem(svcScpCdComboValue,     svcScpCdComboText,    	getComboObject(comboObjects, 'svc_scp_cd'),       	 "|", "\t" );      
        ComPriTextCode2ComboItem(rateTypeComboValue,     rateTypeComboText,    	getComboObject(comboObjects, 'gen_spcl_rt_tp_cd'),   "|", "\t" );      
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
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    //var HeadTitle1 = "Seq|prop_no|amdt_seq|cmdt_hdr_seq|rout_seq|rt_seq|S/C No.|Customer Name|MQC|R.Office|S.Rep|SVC|Rate\nType|Commodity\nGroup|Actual\nCustomer|Origin|O.Via|D.Via|Dest|Charge|Per|Cargo\nType|Cur|Rate|BOF|DAR|Door|PFMC\n(Qty.)";
                    var HeadTitle1 = "Seq.|prop_no|amdt_seq|cmdt_hdr_seq|rout_seq|rt_seq|S/C No.|Customer Name|MQC|R.Office|S.Rep|SVC|Rate\nType|Commodity\nGroup|Actual\nCustomer|Origin|O.Via|D.Via|Dest||Charge|Per|Cargo\nType|Cur|Rate|OFT|BUC|FRC|PSC|PFMC\n(Qty.)";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0, cnt++ ,dtSeq     ,30     ,daCenter   ,true    ,"Seq."                     );
                    InitDataProperty(0, cnt++ ,dtHidden  ,65     ,daLeft     ,false   ,"prop_no"          ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtHidden  ,65     ,daLeft     ,false   ,"amdt_seq"         ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtHidden  ,65     ,daLeft     ,false   ,"cmdt_hdr_seq"     ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtHidden  ,65     ,daLeft     ,false   ,"rout_seq"         ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtHidden  ,65     ,daLeft     ,false   ,"rt_seq"           ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,65     ,daCenter   ,false   ,"sc_no"            ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,180    ,daLeft     ,false   ,"ctrt_pty_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,45     ,daRight    ,false   ,"fnl_mqc_qty"      ,false   ,""        ,dfNullInteger  ,0         ,false     ,false     ,6 );
                    InitDataProperty(0, cnt++ ,dtData    ,50     ,daCenter   ,false   ,"prop_scp_ofc_cd"  ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,45     ,daCenter   ,false   ,"prop_scp_srep_cd" ,false   ,""        ,dfNone         ,0         ,false     ,false     ,5 );
                    InitDataProperty(0, cnt++ ,dtData    ,35     ,daCenter   ,false   ,"svc_scp_cd"       ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,35     ,daCenter   ,false   ,"gen_spcl_rt_tp_cd",false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,110    ,daLeft     ,false   ,"cmdt_nm"          ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,110    ,daLeft     ,false   ,"act_cust_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false        );
//                  InitDataProperty(0, cnt++ ,dtData    ,60     ,daCenter   ,false   ,"org_nm"           ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,75     ,daLeft   ,false   ,"org_cd"           ,false   ,""        ,dfNone         ,0         ,false     ,false        );
//                  InitDataProperty(0, cnt++ ,dtData    ,60     ,daCenter   ,false   ,"org_via_nm"       ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,75     ,daLeft   ,false   ,"org_via_cd"       ,false   ,""        ,dfNone         ,0         ,false     ,false        );
//                  InitDataProperty(0, cnt++ ,dtData    ,60     ,daCenter   ,false   ,"dest_via_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false        ); 
                    InitDataProperty(0, cnt++ ,dtData    ,75     ,daLeft   ,false   ,"dest_via_cd"      ,false   ,""        ,dfNone         ,0         ,false     ,false        ); 
//                  InitDataProperty(0, cnt++ ,dtData    ,60     ,daCenter   ,false   ,"dest_nm"          ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,75     ,daLeft   ,false   ,"dest_cd"          ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtHidden   ,50     ,daCenter   ,false   ,"chg_cd"           ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,110     ,daCenter   ,false   ,"chg_cd_txt"           ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,30     ,daCenter   ,false   ,"rat_ut_cd"        ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,45     ,daCenter   ,false   ,"prc_cgo_tp_cd"    ,false   ,""        ,dfNone         ,0         ,false     ,false        );
                    InitDataProperty(0, cnt++ ,dtData    ,30     ,daCenter   ,false   ,"curr_cd"          ,false   ,""        ,dfNone         ,0         ,false     ,false     ,3 );
                    InitDataProperty(0, cnt++ ,dtData    ,60     ,daRight    ,false   ,"fnl_frt_rt_amt"   ,false   ,""        ,dfNullFloat    ,2         ,false     ,false     ,10);
                    InitDataProperty(0, cnt++ ,dtData  ,60     ,daRight    ,false   ,"fnl_oft_rt_amt"   ,false   ,""        ,dfNullFloat    ,2         ,false     ,false     ,10);
                    InitDataProperty(0, cnt++ ,dtData  ,60     ,daRight    ,false   ,"fnl_buc_rt_amt"   ,false   ,""        ,dfNullFloat    ,2         ,false     ,false     ,10);
                    InitDataProperty(0, cnt++ ,dtData  ,60     ,daRight    ,false   ,"fnl_frc_rt_amt"   ,false   ,""        ,dfNullFloat    ,2         ,false     ,false     ,10);
                    InitDataProperty(0, cnt++ ,dtData  ,60     ,daRight    ,false   ,"fnl_psc_rt_amt"   ,false   ,""        ,dfNullFloat    ,2         ,false     ,false     ,10);
//                  InitDataProperty(0, cnt++ ,dtData    ,50     ,daRight    ,false   ,"bzc_ofrt_rt_amt"  ,false   ,""        ,dfNullInteger  ,0         ,false     ,false     ,10);
//                  InitDataProperty(0, cnt++ ,dtData    ,50     ,daRight    ,false   ,"dest_arb_amt"     ,false   ,""        ,dfNullInteger  ,0         ,false     ,false     ,10);
//                  InitDataProperty(0, cnt++ ,dtData    ,40     ,daRight    ,false   ,"dor_trka_amt"     ,false   ,""        ,dfNullInteger  ,0         ,false     ,false     ,10);
                    InitDataProperty(0, cnt++ ,dtData    ,60     ,daRight    ,false   ,"prs_crnt_lod_qty" ,false   ,""        ,dfNullFloat    ,2         ,false     ,false     ,10);
                	ColHidden("fnl_oft_rt_amt") = true;
                	ColHidden("fnl_buc_rt_amt") = true;
                	ColHidden("fnl_frc_rt_amt") = true;
                	ColHidden("fnl_psc_rt_amt") = true;
                }
                break;

            case "sheet2": // 콤보용
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

                }
                break;

            case "sheet3": // backendjob 용
                with (sheet3) {

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

                    var idx = sheet3.DataInsert();

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
                //customer type
            case "prc_ctrt_cust_tp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
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
                // rate			
            case "fnl_frt_rt":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    MaxLength = 2;      // 2자리만 입력				
                }
                break;
                //svc scope
            case "svc_scp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자 만 입력
                    MaxLength = 3;      // 3자리만 입력
                }
                break;
                // rate type
            case "gen_spcl_rt_tp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자 만 입력
                    MaxLength = 1;      // 1자리만 입력
                }
                break;
                // commodity group
            case "cmdt_hdr_seq":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    SetColWidth("200");
                }
                break;
                // actual customer
            case "act_cust_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    SetColWidth("200");
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
                // s.rep
            case "prop_scp_srep_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 1);    // 영문대문자 + 숫자 만 입력
                    MaxLength = 5;      // 5자리만 입력
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
                    var cal = new ComCalendar();
                    cal.select(form.eff_dt, 'yyyy-MM-dd');
                    break;

                case "btns_calendar2":
                    var cal = new ComCalendar();
                    cal.select(form.exp_dt, 'yyyy-MM-dd');
                    break;

                case "btn_commodity": // prc_cmdt_def_cd : Commodity - cmdt_cd
                    /*
	    		//var param = "?rep_cmdt_cd=" + formObject.rep_cmdt_cd.value;
	    		//param += "&cmdt_cd=" + formObject.cmdt_cd.value;
	    		//param += "&cmdt_nm=" + formObject.cmdt_nm.value;
                     */
                    //var param = "";
                    //ComOpenPopup("/hanjin/COM_ENS_011.do" + param, 780, 460, "getCOM_ENS_011", "1,0,1,1,1,1,1,1", true);

                    var sUrl = "/hanjin/ESM_PRI_4027.do?grp_cd="+ PRI_SG+"&commodity_cmd=C";
                    var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 330, true);
                    if (rtnVal != null){
                        //alert(rtnVal.cd +"<>"+ rtnVal.nm + "<>" + rtnVal.tp);
                        form.prc_cmdt_def_cd.value = rtnVal.cd; // Commodity - cmdt_cd					
                        //if (rtnVal.cd.length == 5){ // Location Type
                        //tpCd = "G";
                        //}
                    }

                    break;

                case "ComOpenPopupWithTarget":	// prop_scp_ofc_cd : Office Code 가져오기 팝업
                    //ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:prop_scp_ofc_cd", "1,0,1,1,1,1,1,1", true);

                    var sUrl = "/hanjin/ESM_PRI_4026.do?";
                    //sUrl += "group_cmd=" + PRI_SG;
                    sUrl += "group_cmd=" + PRI_SP_SCP;
                    sUrl += "&location_cmd=L";
                    sUrl += "&svc_scp_cd=" + form.svc_scp_cd.Code;
                    //sUrl += "&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_pnt_loc_tp_cd");
                    //alert(sUrl);
                    var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_4026", getWidth(700), getHeight(375), true);
                    if (rtnVal != null){
                        //alert(rtnVal.cd +"<>"+ rtnVal.nm + "<>" + rtnVal.tp);
                        form.prop_scp_ofc_cd.value = rtnVal.cd; 
                    }

                    searchSRep();

                    break;

                case "btn_retrieve":
                    setParamsClear();
                    if (validateForm(sheet1, form, IBSEARCH)) {
                    	
                        //doActionIBSheet(sheet1, form, IBSEARCH);
                        doActionIBSheet(sheet3, form, IBBATCH);	    			
                    }
                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;

                case "btn_gotosc":
                    var currRow = sheet1.SelectRow;
                    if(currRow < 1) { return false; }
                    var popParams = "prop_no=" + sheet1.CellValue(currRow, "prop_no");
                    comCallPop("ESM_PRI_0003", "ESM_PRI_0060", popParams, "");

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
        switch(obj.name){
            case "rdoDate":
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
        var form = document.form;
        var formObj = event.srcElement;
        var srcName = formObj.getAttribute("name");
        switch(srcName) {
            case "prc_cmdt_def_cd": // Commodity
            case "rout_pnt_loc_def_cd_ori":    // 2011.03.15 이행지 ComChkObjValid 인자로 uppernum이 없어서 Skip하도록 수정
            case "rout_pnt_loc_def_cd_dest":
            case "rout_via_port_def_cd_ori":
            case "rout_via_port_def_cd_dest":
                break;
            case "sc_no":
                setScNoMendatory();
                break;
            case "prop_scp_ofc_cd":
                searchSRep();
                break;
            default :
                ComChkObjValid(formObj);
        }

        switch(srcName) {
            case "sc_no":
                doActionIBSheet2(sheet2, form, IBSEARCH);
                break;
        }

    }

    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
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
     * Rep. Commodity 팝업창 선택값 Return <br>      
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBSheet} sheetObj : sheet object                                        
     * @param  {Long} Row : 해당 셀의 Row Index                                              
     * @param  {Long} Col : 해당 셀의 Column Index  
     * @param  {String} Value : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @return 없음                                                                                 
     * @see #                                                                                       
     * @author 김대호                                                                               
     * @version 2009.08.12                                                                          
     */  
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        var form = document.form;
        var colName = sheet1.ColSaveName(Col);
        switch(colName){
            case "dest_arb_amt": // Dar
            case "dor_trka_amt": // Door
                if(Row < 1) return;
                var svcScpCd = sheet1.CellValue(Row, "svc_scp_cd");
                //if(svc_scp_cd != "TPE") return;
                var pgmNo = "ESM_PRI_0083";
                var pgmUrl = "/hanjin/ESM_PRI_0083.do?";
                if(colName == "dor_trka_amt") {
                    pgmNo = "ESM_PRI_0082";
                    pgmUrl = "/hanjin/ESM_PRI_0082.do?";
                }
                var propNo = sheet1.CellValue(Row, "prop_no"); 
                var amdtSeq = sheet1.CellValue(Row, "amdt_seq");
                var genSpclRrtTpCd = sheet1.CellValue(Row, "gen_spcl_rt_tp_cd");
                var cmdtHdrSeq = sheet1.CellValue(Row, "cmdt_hdr_seq");
                var routSeq = sheet1.CellValue(Row, "rout_seq");
                var rtSeq = sheet1.CellValue(Row, "rt_seq");
                var sParam = "prop_no=" + propNo + "&amdt_seq=" + amdtSeq + "&svc_scp_cd=" + svcScpCd + "&gen_spcl_rt_tp_cd=" + genSpclRrtTpCd;
                sParam += "&cmdt_hdr_seq=" + cmdtHdrSeq + "&rout_seq=" + routSeq + "&rt_seq=" + rtSeq;
                //alert(sParam);
                ComPriOpenWindowCenter(pgmUrl + sParam, pgmNo, 600, 310, false);

                break;
        }

    }

    /** 
     * chager 콤보변경시 발생하는 chg_cd_OnChange 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo 오브젝트
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function chg_cd_OnChange(chgCdObj, Code, Text) {
                              
        var form = document.form;
        var scNoS = form.sc_no;
        var routPntLocDefCdOri = form.rout_pnt_loc_def_cd_ori;
        var routPntLocDefCdDest = form.rout_pnt_loc_def_cd_dest;
        if(Code == "OBD") {
            scNoS.className = "input1";
            routPntLocDefCdOri.className = "input";		
            routPntLocDefCdDest.className = "input"
        }else{
            scNoS.className = "input";
            routPntLocDefCdOri.className = "input1";		
            routPntLocDefCdDest.className = "input1"
        }

    }

    /**                                                                                            
     * svc scope 의 콤보 포커스를 잃을 때 이벤트가 발생하는 svc_scp_cd_OnBlur 이벤트핸들러 <br>
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBMultiCombo} comboObj : 콤보오브젝트                                               
     * @return 없음                                                                                 
     * @see #                                                                                       
     * @author 김대호                                                                               
     * @version 2009.08.12                                                                          
     */                   
    function svc_scp_cd_OnBlur(comboObj) {
        doActionIBSheet2(sheet2, form, IBSEARCH);	
    }

    /** 
     * Rate Type 콤보 포커스를 잃을 때 이벤트가 발생하는 gen_spcl_rt_tp_cd_OnBlur 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo 오브젝트
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function gen_spcl_rt_tp_cd_OnBlur(comboObj) {
        doActionIBSheet2(sheet2, form, IBSEARCH);
    }

    /** 
     * Commodity 콤보변경시 발생하는 cmdt_hdr_seq_OnChange 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo 오브젝트
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function cmdt_hdr_seq_OnChange(cmdtObj, Code, Text) {
        var form = document.form;
        var actObj = form.act_cust_cd;
        actObj.Code2 = Code;
    }

    /** 
     * Actual Customer 콤보변경시 발생하는 act_cust_cd_OnChange 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo 오브젝트
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function act_cust_cd_OnChange(actObj, Code, Text) {
        var form = document.form;
        var cmdtObj = form.cmdt_hdr_seq;
        cmdtObj.Code2 = Code;
    }

    /** 
     * S.Rep 콤보변경시 발생하는 prop_scp_srep_cd_OnChange 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo 오브젝트
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function prop_scp_srep_cd_OnChange(actObj, Code, Text) {
        var form = document.form;
        //var code = actObj.Code;
        var text = actObj.GetText(Code, 1);
        form.prop_scp_srep_nm.value = text;
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
        doActionIBSheet2(sheet2, form, IBSEARCH_ASYNC01)
    }

    /** 
     * sc no 데이터 데이터 입력에 따라 mendatory 항목을 설정하는 setScNoMendatory 이벤트핸들러 <br>
     * <br><b>Example : </b>	
     * <pre>
     * </pre>
     * @param   {boolean} bool
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.01
     */ 
    function setScNoMendatory() {
        var form = document.form;
//        var scNoPObj = form.sc_no_p;
//        var scNoSObj = form.sc_no_s;
        var scNoObj = form.sc_no;
        var rateTypeObj = form.gen_spcl_rt_tp_cd;
        var commodityObj = form.cmdt_hdr_seq;
        var actualObj = form.act_cust_cd;
        //alert("scNoPObj["+scNoPObj.Code+"]scNoSObj["+scNoSObj.value+"]");
        if( null != scNoObj.value && "" != scNoObj.value ){
            rateTypeObj.Enable = true;
            commodityObj.Enable = true;
            actualObj.Enable = true;
        }else{
            rateTypeObj.Code2 = "";
            commodityObj.Code2 = "";
            actualObj.Code2 = "";
            rateTypeObj.Enable = false;
            commodityObj.Enable = false;
            actualObj.Enable = false;
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

    /** 
     * sheet1 데이터 조회하기위한 파라미터 셋팅하는 setParamsSearch 이벤트핸들러 <br>
     * <br><b>Example :</b>	
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.01
     */ 
    function setParamsSearch() {
        var form = document.form;
        var scNo = form.sc_no.value;
//        var scNoP = form.sc_no_p;
//        var scNoS = form.sc_no_s; 
        var cmdtNm = form.cmdt_nm;
        var actCustNm = form.act_cust_nm;
        var cmdtHdrSeq = form.cmdt_hdr_seq;
        var actCustCd = form.act_cust_cd;
//        scNo.value = scNoP.Code + scNoS.value;  
        cmdtNm.value = cmdtHdrSeq.GetText(cmdtHdrSeq.Code, 0);
        actCustNm.value = actCustCd.GetText(actCustCd.Code, 0);
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
            case IBSEARCH: //조회

                ComOpenWait(true);

                setParamsClear();
                setParamsSearch();
                formObj.f_cmd.value = SEARCH;
                sheet1.DoSearch("ESM_PRI_0060GS.do", FormQueryString(formObj));

                ComOpenWait(false);

                break;

            case IBBATCH: //backendjob 조회

                try {

                    ComOpenWait(true);
                    sheet1.WaitImageVisible = false;
                    sheet3.WaitImageVisible = false;

                    setParamsClear();
                    setParamsSearch();
                    formObj.f_cmd.value = COMMAND01;
//                    alert(formObj.chg_cd.text);
//                    formObj.chg_cd_txt.value = formObj.chg_cd.text;
                    var sXml = sheet3.GetSearchXml("ESM_PRI_0060GS.do", FormQueryString(formObj));
                    var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
                    ComOpenWait(true);				
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value = backendJobKey;
                        sheet3.RequestTimeOut = 10000;
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

            case IBDOWNEXCEL:      //download excel
                sheet1.SpeedDown2Excel(-1); //, "chk|seq"
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
            var sXml = sheet3.GetSearchXml("ESM_PRI_0060GS.do", FormQueryString(form));
            var jobState = ComGetEtcData(sXml, "jb_sts_flg");
            form.job_status.value = jobState;
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
            var sXml = sheet1.GetSearchXml("ESM_PRI_0060GS.do", FormQueryString(form));
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
            case IBSEARCH: //Commodity, actual 콤보

                var scNo = formObj.sc_no.value; // sc_no
                var svcScpCd = formObj.svc_scp_cd.Code; // scope
                var genSpclRtTpCd = formObj.gen_spcl_rt_tp_cd.Code; // rate type
                var effDt = formObj.eff_dt.value;
                var expDt = formObj.exp_dt.value;
                var cmdtHdrSeqObj = form.cmdt_hdr_seq;
                var actCustCdObj = form.act_cust_cd;

                var chkValue = scNo + svcScpCd + genSpclRtTpCd;  
                if(gBefParam == chkValue) { return; }

                cmdtHdrSeqObj.RemoveAll();
                actCustCdObj.RemoveAll();

                gBefParam = chkValue;

                var params = "f_cmd=" + SEARCH01 + "&sc_no=" + scNo + "&svc_scp_cd=" + svcScpCd + "&gen_spcl_rt_tp_cd=" + genSpclRtTpCd + "&eff_dt=" + effDt + "&exp_dt=" + expDt;
                var sXml = sheet2.GetSearchXml("ESM_PRI_0060GS.do?", params);
                ComPriXml2ComboItem(sXml, formObj.cmdt_hdr_seq, "cmdt_hdr_seq", "cmdt_nm");
                formObj.cmdt_hdr_seq.InsertItem(0, "", "");
                ComPriXml2ComboItem(sXml, formObj.act_cust_cd, "cmdt_hdr_seq", "act_cust_nm");
                formObj.act_cust_cd.InsertItem(0, "", "");	

                break;

            case IBSEARCH_ASYNC01: //s rep

                var params = "f_cmd=" + SEARCH15 + "&etc1=" + formObj.prop_scp_ofc_cd.value;
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
        var chgCd = form.chg_cd;
        var effDt = form.eff_dt;
        var expDt = form.exp_dt;	
        var routPntLocDefCdOri = form.rout_pnt_loc_def_cd_ori;
        var routPntLocDefCdDest = form.rout_pnt_loc_def_cd_dest;
//        var scNoP = form.sc_no_p;
        var scNoS = form.sc_no;

        switch (sAction) {

            case IBSEARCH: //조회
                if( null == chgCd.Code || "" == chgCd.Code) {
                    ComShowCodeMessage("PRI00337", "Charge");
                    ComSetFocus(chgCd);
                    return false;
                }
                if(effDt.value == "") {
                    ComShowCodeMessage("PRI00335", effDt.caption);
                    ComSetFocus(effDt);
                    return false;
                }
                if(!ComChkObjValid(effDt)) { return false; }
                if(!ComChkObjValid(expDt)) { return false; }
                if(routPntLocDefCdOri.className == "input1" && routPntLocDefCdOri.value == "") {
                    ComShowCodeMessage("PRI00335", "Origin");
                    ComSetFocus(routPntLocDefCdOri);
                    return false;
                }
                if(routPntLocDefCdDest.className == "input1" && routPntLocDefCdDest.value == "") {
                    ComShowCodeMessage("PRI00335", "Destination");
                    ComSetFocus(routPntLocDefCdDest);
                    return false;
                }
                if(scNoS.className == "input1" && scNoS.value == "") {
                    ComShowCodeMessage("PRI00335", "S/C No.");
                    ComSetFocus(scNoS);
                    return false;
                }

                break;
        }

        return true;

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
     * @author 이석준
     * @version 2011.11.08
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	if (errMsg == "") {
    		
            var form = document.form;
            var chg_cd = form.chg_cd.Code;

            if (chg_cd == "OBP"){ //OFT+BUC+PSC           	
            	sheetObj.ColHidden("fnl_oft_rt_amt") = false;
            	sheetObj.ColHidden("fnl_buc_rt_amt") = false;
            	sheetObj.ColHidden("fnl_psc_rt_amt") = false;
            	sheetObj.ColHidden("fnl_frc_rt_amt") = true;
            } else if (chg_cd == "OFB"){ //OFT+BUC
            	sheetObj.ColHidden("fnl_oft_rt_amt") = false;
            	sheetObj.ColHidden("fnl_buc_rt_amt") = false;
            	sheetObj.ColHidden("fnl_psc_rt_amt") = true;
            	sheetObj.ColHidden("fnl_frc_rt_amt") = true;
            } else if (chg_cd == "OFF"){ //OFT + FRC    = OFF
            	sheetObj.ColHidden("fnl_oft_rt_amt") = false;
            	sheetObj.ColHidden("fnl_frc_rt_amt") = false;
            	sheetObj.ColHidden("fnl_buc_rt_amt") = true;
            	sheetObj.ColHidden("fnl_psc_rt_amt") = true;          	
            } else if (chg_cd == "OFP"){ //OFT + FRC + PSC   = OFP
            	sheetObj.ColHidden("fnl_oft_rt_amt") = false;
            	sheetObj.ColHidden("fnl_frc_rt_amt") = false;
            	sheetObj.ColHidden("fnl_psc_rt_amt") = false;
            	sheetObj.ColHidden("fnl_buc_rt_amt") = true;
            } else {
            	sheetObj.ColHidden("fnl_oft_rt_amt") = true;
            	sheetObj.ColHidden("fnl_buc_rt_amt") = true;
            	sheetObj.ColHidden("fnl_psc_rt_amt") = true;
            	sheetObj.ColHidden("fnl_frc_rt_amt") = true;
            }

        }
    }    