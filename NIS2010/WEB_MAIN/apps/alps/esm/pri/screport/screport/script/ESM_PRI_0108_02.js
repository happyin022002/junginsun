/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0108_02.js
*@FileTitle : S/C Performance Summary - Details by S/C
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.02 김대호
* 1.0 Creation
* History--------------------------------------------------
* 2011.02.17 이행지 [CHM-201109050-01] S/C PFMC Summary (Detailed by S/C) 기능 수정 요청
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
* 2015.04.06 송호진 [CHM-201534007] Rate Search & PFMC Summary - Detail 의 Actual Customer ComboList 조회시 4000 Byte Over 문제 해결
=========================================================*/
/**
 * @fileoverview S/C Performance Summary - Details by S/C 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_0108_02 : ESM_PRI_0108_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0108_02() {
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
    var sheet4;
    var sheet5;

    var comboObjects = new Array();
    var comboCnt = 0;
    //  컬럼변수
    var C1_SC_NO = "sc_no";
    var C1_SVC_SCP_CD = "svc_scp_cd";
    var C1_PFMC = "op_cntr_qty";
    var C1W_PFMC = 70;
    //  Sheet3 Column 정보
    var C3_TRADE        = "trd_cd";
    var C3_TRADE_NM     = "trd_nm";
    var C3_SUB_TRADE    = "sub_trd_cd";
    var C3_SUB_TRADE_NM = "sub_trd_nm";
    var C3_LANE         = "vsl_slan_cd";
    var C3_LANE_NM      = "vsl_slan_nm";
    //  업무전역변수
    var gCurrDate;
    var gBefScNo = "";
    var gBefParam = "";
    var gSheet1Width = 0;
    //  필터콤보관련
    var gArrTradeRange = {};  // Trade별 구간
    var gArrSubTradeCob = {}; // sub trade 콤보
    var gArrLaneCob = {};    // lane 콤보

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
        sheet3 = sheetObjects[2]; // trade, sub trade, lane 콤보용
        sheet4 = sheetObjects[3]; // group, costumer 콤보     
        sheet5 = sheetObjects[4]; // 
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

        //선택으로 변경
        //gCurrDate = ComGetNowInfo('ymd', '-');
        //form.bl_obrd_dt_from.value = gCurrDate;
        //form.bl_obrd_dt_to.value = gCurrDate;

        //콤보
        initIBComboItem();

        ComOpenWait(true);

        // trade, sub trade, lane 콤보
        doActionIBSheet(sheet3, form, IBSEARCH);

        ComOpenWait(false);

        //ESM_PRI_0003 에서 호출 
        var pForm = parent.document.form;
        var sc_no_code = "" ;
        var sc_no_seq = "" ;
        if (pForm.sc_no1.value !="" && pForm.sc_no2.value !="" ){
        	sc_no_code = pForm.sc_no1.value;
        	sc_no_seq = pForm.sc_no2.value;
        	form.sc_no_input.value = sc_no_code + sc_no_seq ;
            form.sc_no_input.focus();
            pForm.rdoSummaryType[1].checked = true;
            parent.setRdoSummaryType();
            mainCallButtonClick("btn_retrieve");  
            pForm.sc_no1.value = "";
            pForm.sc_no2.value = "";

        }

        /* 테스트 */ // AEN14902 엄청느림....?
        //form.sc_no_prefix.Code = "AWN";
        //form.sc_no_suffix.value = "23339";
        //form.bl_obrd_dt_from.value = "2008-08-01";
        //AEF28238, TPE, S
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
        ComPriTextCode2ComboItem(svcScpCdComboValue,   svcScpCdComboText,   getComboObject(comboObjects, 'svc_scp_cd'),        "|", "\t" );
        ComPriTextCode2ComboItem(skdDirCdComboValue,   skdDirCdComboText,   getComboObject(comboObjects, 'skd_dir_cd'),        "|", "\t" );
        ComPriTextCode2ComboItem(rtTpCdComboValue,     rtTpCdComboText,     getComboObject(comboObjects, 'gen_spcl_rt_tp_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(usModCdComboValue,    usModCdComboText,    getComboObject(comboObjects, 'usa_svc_mod_cd'),    "|", "\t" );
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
                    style.height = 288;
                    //전체 너비 설정
                    gSheet1Width = mainTable.clientWidth;
                    SheetWidth = gSheet1Width;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
                    var HeadTitle1 = "Seq|svc_scp_cd|YYYYMM|Week|Trade|Dir.|Sub\nTrade|Lane|VVD|Rate\nType|Commodity Group|Actual Customer|US\nMode|Org.\nCountry|POR|POL|POD|DEL|PFMC\n(FEU)";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성       ROW , COL   ,DATATYPE   ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME               ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0, cnt++ , dtSeq     ,30     ,daCenter   ,true    ,"seq"                   );
                    InitDataProperty(0, cnt++ , dtHidden  ,0      ,daCenter   ,false   ,"svc_scp_cd"           ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"cost_yrmon"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,40     ,daCenter   ,false   ,"cost_wk"               ,false   ,""        ,dfNone         ,0         ,false     ,false);

                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"trd_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,35     ,daCenter   ,false   ,"skd_dir_cd"           ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,45     ,daCenter   ,false   ,"sub_trd_cd"    	   ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,45     ,daCenter   ,false   ,"slan_cd"              ,false   ,""        ,dfNone         ,0         ,false     ,false); 
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daCenter   ,false   ,"vvd"                  ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,40     ,daCenter   ,false   ,"gen_spcl_rt_tp_cd"    ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,170    ,daLeft     ,false   ,"cmdt_nm"     		   ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,170    ,daLeft     ,false   ,"act_cust_nm"          ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,40     ,daCenter   ,false   ,"usa_svc_mod_cd"       ,false   ,""        ,dfNone         ,0         ,false     ,false); 
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"org_cnt"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"por_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"pol_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"pod_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"del_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daRight    ,false   ,"op_cntr_qty"          ,false   ,""        ,dfNullFloat    ,3         ,false     ,false);

                    ExtendLastCol = true;

                }
                break;

            case "sheet2": // find_text 용, sc 기본조회용, sum 용 
                with (sheet2) {

                    //높이 설정
                    style.height = 80;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
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

            case "sheet3": // trade, sub trade, lane 콤보용
                with (sheet3) {

                    //높이 설정
                    style.height = 100;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
                    var HeadTitle1 = "trd_cd|trd_nm|sub_trd_cd|sub_trd_nm|vsl_slan_cd|vsl_slan_nm"
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME       ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0 ,cnt++ ,dtData   ,80   ,daLeft   ,false   ,C3_TRADE       ,false   ,""        ,dfNone    ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,80   ,daLeft   ,false   ,C3_TRADE_NM    ,false   ,""        ,dfNone    ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,80   ,daLeft   ,false   ,C3_SUB_TRADE   ,false   ,""        ,dfNone    ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,80   ,daLeft   ,false   ,C3_SUB_TRADE_NM,false   ,""        ,dfNone    ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,80   ,daLeft   ,false   ,C3_LANE        ,false   ,""        ,dfNone    ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,80   ,daLeft   ,false   ,C3_LANE_NM     ,false   ,""        ,dfNone    ,0 );

                }
                break;

            case "sheet4": // group, costumer
                with (sheet4) {

                    //높이 설정
                    style.height = 100;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 1, 100);
                    var HeadTitle1 = "cmdt_hdr_seq|cmdt_nm|act_cust_nm|sc_no|svc_scp_cd|gen_spcl_rt_tp_cd"
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME            ,KEYFIELD,CALCULOGIC,DATAFORMAT  ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0 ,cnt++ ,dtData   ,50   ,daLeft   ,false   ,"cmdt_hdr_seq"      ,false   ,""        ,dfNone      ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,200  ,daLeft   ,false   ,"cmdt_nm"           ,false   ,""        ,dfNone      ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,200  ,daLeft   ,false   ,"act_cust_nm"       ,false   ,""        ,dfNone      ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,50   ,daLeft   ,false   ,"sc_no"             ,false   ,""        ,dfNone      ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,50   ,daLeft   ,false   ,"svc_scp_cd"        ,false   ,""        ,dfNone      ,0 );
                    InitDataProperty(0 ,cnt++ ,dtData   ,50   ,daLeft   ,false   ,"gen_spcl_rt_tp_cd" ,false   ,""        ,dfNone      ,0 );

                }
                break;

            case "sheet5": // backendjob 용
                with (sheet5) {

                    //높이 설정
                    style.height = 80;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 1, 100);
                    var HeadTitle1 = "job_id"
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME            ,KEYFIELD,CALCULOGIC,DATAFORMAT       ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0 ,cnt++ ,dtData   ,50   ,daLeft   ,false   ,"job_id"   ,false   ,""        ,dfNone      ,0 );

                    Visible = false; // backendjob 용
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
                //trd_cd
            case "trd_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
                    InsertItem(i++, "", "");                
                }
                break;
                //Direction : skd_dir_cd
            case "skd_dir_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 1;      // 1자리만 입력
                }
                break;
                //sub_trd_cd
            case "sub_trd_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 2;      // 2자리만 입력
                    InsertItem(i++, "", "");	
                }
                break;
                //lane
            case "vsl_slan_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
                    InsertItem(i++, "|", "");				
                }
                break;
                //SVC Scope
            case "svc_scp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
                }
                break;
                //rate type
            case "gen_spcl_rt_tp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 1;      // 1자리만 입력
                }
                break;
                // comodity group
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
                // us mode
            case "usa_svc_mod_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력				
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

                case "btn_retrieve":
                    mainCallButtonClick(srcName);
                    break;

                case "btns_calendar1": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(form.bl_obrd_dt_from, 'yyyy-MM-dd');
                    break;

                case "btns_calendar2": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(form.bl_obrd_dt_to, 'yyyy-MM-dd');
                    break;

                case "btn_com_ens_ob2":
                    var param = "";
                    param = param + "lane_cd=" + ComGetObjValue(form.vsl_slan_cd);
                    //param = "loc_cd="+ComGetObjValue(formObj.pol_cd);
                    //param = param + "&" + "pod_cd="+ComGetObjValue(formObj.pod_cd);
                    //param = param + "&" + "vvd_cd="+formObj.vvd.value;
                    //param = param + "&" + "etd_cd="+formObj.etd_cd.value;
                    ComOpenPopup('/hanjin/COM_ENS_0B2.do?' + param, 780, 450, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
                    break;

                case "btn_por_cd":
                case "btn_pol_cd":
                case "btn_pod_cd":
                case "btn_del_cd":
                    var sUrl = "/hanjin/ESM_PRI_4026.do?";
                    //sUrl += "group_cmd=" + PRI_SG;
                    sUrl += "group_cmd=" + PRI_SP_SCP;
                    sUrl += "&location_cmd=LGC";
                    sUrl += "&svc_scp_cd=" + form.svc_scp_cd.Code;
                    //sUrl += "&loc_tp_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "rout_pnt_loc_tp_cd");
                    //alert(sUrl);
                    var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
                    if (rtnVal != null){
                        //alert(rtnVal.cd +"<>"+ rtnVal.nm + "<>" + rtnVal.tp);
                        if(srcName == "btn_por_cd") {
                            form.por_cd.value = rtnVal.cd;
                        }else if(srcName == "btn_pol_cd"){
                            form.pol_cd.value = rtnVal.cd;
                        }else if(srcName == "btn_pod_cd"){
                            form.pod_cd.value = rtnVal.cd;
                        }else if(srcName == "btn_del_cd"){
                            form.del_cd.value = rtnVal.cd;
                        }
                    }
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

    /** 
     * 에인창에서 프로세스 호출시 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function mainCallButtonClick(srcName){
        var form = document.form;
        switch(srcName) {

            case "btn_retrieve":
                setParamsClear();
                if (validateForm(sheet1, form, IBSEARCH)) {
                    doActionIBSheet(sheet5, form, IBBATCH); // sum 용, backendjob 용 sheet5
                }
                break;

            case "btn_bl_list":
                if(sheet1.SelectRow < 0) return;
                sheet1_OnDblClick(sheet1, sheet1.SelectRow, "", 0, 0, 0, 0);
                break;

            case "btn_downexcel":
                doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                break;

        } //end switch
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
     * @version 2009.09.04
     */
    function obj_click(){
        var form = document.form;
        var obj = event.srcElement;
        //switch(obj.name){
        switch(obj.id){
            case "chkDisplay":
                return;
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
        var scNoSuffixObj = form.sc_no_input;

        var formObj = event.srcElement;
        var srcName = formObj.getAttribute("name");
        switch(srcName) {

            case "sc_no_input":
                if(scNoSuffixObj.value == "") {
                    //ComShowCodeMessage("PRI00335", "S/C No Suffix");
                    //ComSetFocus(scNoSuffixObj);
                    return;
                }
                doActionIBSheet(sheet2, form, IBSEARCH_ASYNC02);
                break;
            case "bl_obrd_dt_from":
            case "bl_obrd_dt_to":
                ComChkObjValid(formObj);
                chkObrdDate(formObj);
                break;
            case "skd_voy_no":
            case "por_cd":	// 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - ComChkObjValid : dataformat(uppernum)이 없어 skip처리
            case "pol_cd":
            case "pod_cd":
            case "del_cd":
                break;
            default :
                ComChkObjValid(formObj);

        }

    }

//  ===================================================================================
//  UI Object Event Handler
//  ===================================================================================
    /** 
     * searchScInfo 초기화하는 clearScInfomation <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function clearScInfomation() {
        var form = document.form;
        for(var i = 0; i < form.length; i++){
            var formObj = form.elements[i];
            if(formObj.id == "scInfomation") {
                formObj.value = "";
            }
        }
    }   

    /** 
     * sheet1 데이터 조회후 발생하는 sheet1_OnSearchEnd 이벤트핸들러 <br>
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
        var form = document.form;
        if (errMsg == "") {
            doActionIBSheet(sheet2, form, IBSEARCH_ASYNC04);

            var formObj, colNm, colWidth, bool;
            var ckSlane, ckVvd;
            for(var i = 0; i < form.length; i++){
                formObj = form.elements[i];
                if(formObj.id == "chkDisplay") {
                    colNm = formObj.value;
                    colWidth = sheet1.ColWidth(colNm); 
                    bool = true;
                    if(formObj.checked){
                        bool = false;
                    }
                    sheet1.ColHidden(colNm) = bool;
                    if(bool) {
                        gSheet1Width = gSheet1Width - colWidth;
                    } else {
                        gSheet1Width = gSheet1Width + colWidth;
                    }
                    if(colNm == "slan_cd")
                    	ckSlane = bool;
                    if(colNm == "vvd")
                    	ckVvd = bool;
                }
            }
            if(ckSlane == false && ckVvd == false){
            	sheet1.ColHidden("cost_yrmon") = false;
            	sheet1.ColHidden("cost_wk") = false;
            } else {
            	sheet1.ColHidden("cost_yrmon") = true;
            	sheet1.ColHidden("cost_wk") = true;
            }
        }else{
            ComOpenWait(false);        		
        }
    }   

    /** 
     * sheet3 데이터 조회후 발생하는 sheet3_OnSearchEnd 이벤트핸들러 <br>
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
    function sheet3_OnSearchEnd(sheetObj, errMsg) {
        var form = document.form;
        if (errMsg == "") {
            setTradeSubLaneComboMake();
        }
    }   

    /** 
     * sheet4 데이터 조회후 발생하는 sheet4_OnSearchEnd 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {string} errMsg : 에러메세지  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.10.23
     */ 
    function sheet4_OnSearchEnd(sheetObj, errMsg) {
        var form = document.form;
        var cmdtObj = form.cmdt_hdr_seq; 
        var actObj = form.act_cust_cd;
        var cd, cmdtNm, actNm;
        if (errMsg == "") {
            var startRow4 = sheet4.HeaderRows;
            var endRow4 = sheet4.HeaderRows + sheet4.RowCount;
            cmdtObj.InsertItem(-1, "", "");				
            actObj.InsertItem(-1, "", "");				
            for(var k = startRow4; k < endRow4; k++) {
                cd = sheet4.CellValue(k, "cmdt_hdr_seq");
                cmdtNm = sheet4.CellValue(k, "cmdt_nm");		
                actNm = sheet4.CellValue(k, "act_cust_nm");		
                cmdtObj.InsertItem(-1, cmdtNm, cd);				
                actObj.InsertItem(-1, actNm, cd);				
            }
        }
    }   

    /** 
     * sheet1 로우 더블 클릭시 발생하는 sheet1_OnDblClick 이벤트핸들러 <br>
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
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var form = document.form;
        //var scNo = sheet1.CellValue(Row, C1_SC_NO);
        var scNo = getScNoValue();
        var svcScpCd = sheet1.CellValue(Row, C1_SVC_SCP_CD);
        var blObrdDtFrom = form.bl_obrd_dt_from.value;
        var blObrdDtTo= form.bl_obrd_dt_to.value;
        if (scNo != "") {
            var popParams = "sc_no=" + scNo + "&svc_scp_cd=" + svcScpCd + "&bl_obrd_dt_from=" + blObrdDtFrom + "&bl_obrd_dt_to=" + blObrdDtTo;
            comCallPop("ESM_PRI_0111", "ESM_PRI_0108_02", popParams, "");
        }
    }   

    /** 
     * SC NO 값을 조회하기위한 파라미터 초기화하는 getScNoValue 이벤트핸들러 <br>
     * <br><b>Example :</b>	
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.01
     */ 
    function getScNoValue() {
        var form = document.form;
        var scNo = form.sc_no_input.value;
        form.sc_no.value = scNo;
        return scNo;
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
     * vvd : Vessel SKD & Code Inquiry부분. <br>
     * <br><b>Example :</b>	
     * <pre>
     * </pre>
     * @param {arry} aryPopupData
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.01
     */ 
    function setCallBack0B2(aryPopupData) {
        var form = document.form;
        //form.etd_cd.value = ComGetMaskedValue(aryPopupData[0][5], "ymd");
        var strValue = aryPopupData[0][7];
        //form.vvd.value = aryPopupData[0][7];
        form.vsl_cd.value = strValue.substr(0,4);
        form.skd_voy_no.value = strValue.substr(4,4);
        form.skd_dir_cd_txt.value = strValue.substr(8);
        //form.skd_dir_cd_txt.value = strValue.substr(8);

    } 

    /** 
     * Arbitray 화면에 기입력된 Point들의 정보로 Point 콤보를 생성을 위한 정보를 만드는 setPointComboMake 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param 없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function setTradeSubLaneComboMake() {
        var form = document.form;
        var trdObj = form.trd_cd; 
        var subTrdObj = form.sub_trd_cd; 
        var laneObj = form.vsl_slan_cd; 

        // trade 콤보 생성 및 구간정보 저장
        var chkTrade = "";   // 값확인
        var chkTradeNm = ""; // 값확인
        var tradeRange, arrTradeRange, startRng, endRng; 
        var startRow3 = sheet3.HeaderRows;
        var endRow3 = sheet3.HeaderRows + sheet3.RowCount;
        for(var k = startRow3; k < endRow3; k++) {
            chkTrade   = sheet3.CellValue(k, C3_TRADE);           // trade 값을 확인
            chkTradeNm = sheet3.CellValue(k, C3_TRADE_NM);        // trade nm 값을 확인
            trdObj.InsertItem(-1, chkTrade + "|" + chkTradeNm, chkTrade);
            tradeRange = sheet3.GetColSameDataRange(k, C3_TRADE); // 같은 값의 구간 확인
            gArrTradeRange[chkTrade] = tradeRange;                // trade 별 구간정보를 담는다.
            arrTradeRange = tradeRange.split("|");
            startRng = parseInt(arrTradeRange[0],10);
            endRng = parseInt(arrTradeRange[1],10);
            if(endRng > startRng) {
                k = k + (endRng - startRng);
            }
        }

        // sub trade 콤보 생성 및 구간정보 저장
        sheet2.CellValue2(1, "f_text1") = ""; // 코드검색 sheet 초기화
        var chkSubTrade = "";
        var chkSubTradeNm = "";
        var arrSubTrade = "", arrSubTradeNm = "";
        for(var k = startRow3; k < endRow3; k++) {
            chkSubTrade   = sheet3.CellValue(k, C3_SUB_TRADE);
            chkSubTradeNm = sheet3.CellValue(k, C3_SUB_TRADE_NM);
            if( null != chkSubTrade && "" != chkSubTrade ) {
                chkFindNum = sheet2.FindText("f_text1", "[" + chkSubTrade + "]", 1, 2, true);
                if(chkFindNum < 0){
                    subTrdObj.InsertItem(-1, chkSubTrade + "|" + chkSubTradeNm, chkSubTrade);				
                    arrSubTrade = arrSubTrade + "|" + chkSubTrade;
                    arrSubTradeNm = arrSubTradeNm + "|" + chkSubTradeNm;
                    tmpText = sheet2.CellValue(1, "f_text1");
                    sheet2.CellValue2(1, "f_text1") = tmpText + "[" + chkSubTrade + "]";
                }
            }
        }
        gArrSubTradeCob["[]"] = arrSubTrade + "☜☞" + arrSubTradeNm;

        sheet2.CellValue2(1, "f_text1") = ""; // 코드검색 sheet 초기화
        var chkLane = "";
        var arrLane = "", arrLaneNm= "";
        for(var k = startRow3; k < endRow3; k++) {
            chkLane = sheet3.CellValue(k, C3_LANE);
            chkLaneNm = sheet3.CellValue(k, C3_LANE_NM);
            if( null != chkLane && "" != chkLane ) {
                chkFindNum = sheet2.FindText("f_text1", "[" + chkLane + "]", 1, 2, true);
                if(chkFindNum < 0){
                    laneObj.InsertItem(-1, chkLane + "|" + chkLaneNm, chkLane);
                    arrLane = arrLane + "|" + chkLane;
                    arrLaneNm = arrLaneNm + "|" + chkLaneNm;
                    tmpText = sheet2.CellValue(1, "f_text1"); 
                    sheet2.CellValue2(1, "f_text1") = tmpText + "[" + chkLane + "]";
                }
            }
        }
        gArrLaneCob["[_]"] = arrLane + "☜☞" + arrLaneNm;

    }

    /**
     * sC NO 콤보 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @return 없음
     * @author 김대호
     * @version 2009.08.20
     */
//    function sc_no_prefix_OnBlur(comboObj) {
//        if(null == comboObj.Code || "" == comboObj.Code) {
//            //ComShowCodeMessage("PRI00335", "S/C No Prefix");
//            //ComSetFocus(comboObj);
//            return;
//        }
//        doActionIBSheet(sheet2, form, IBSEARCH_ASYNC02);
//    }

    /** 
     * trade 콤보선택 변경시 발생하는 trd_cd_OnChange 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : 콤보생성위한 로우
     * @param  {string} Code : 콤보 코드값
     * @param  {string} Text : 콤보 텍스트값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function trd_cd_OnChange(tradeObj, Code, Text) {
        var form = document.form;
        var subTradeObj = form.sub_trd_cd;

        subTradeObj.RemoveAll();
        sheet2.CellValue2(1, "f_text1") = ""; // 코드검색 sheet 초기화

        var startRow = sheet3.HeaderRows;
        var endRow = sheet3.HeaderRows + sheet3.RowCount;
        if("" != Code) {
            var arrRange = gArrTradeRange[Code].split("|");
            startRow = parseInt(arrRange[0],10);
            endRow = parseInt(arrRange[1],10) + 1;
        }
        var chkFindNum;
        var tmpText;
        var keyTrade = "[" + Code + "]";
        var chkTrade = "", chkSubTrade = "";
        var arrSubTrade = "", arrSubTradeNm = "";
        var compTrade = Code;
        if(undefined == gArrSubTradeCob[keyTrade]) {
            for(var i = startRow; i < endRow; i++) {
                chkTrade = sheet3.CellValue(i, C3_TRADE);
                chkSubTrade = sheet3.CellValue(i, C3_SUB_TRADE);
                chkSubTradeNm = sheet3.CellValue(i, C3_SUB_TRADE_NM);
                if(null == Code || "" == Code) {
                    compTrade = chkTrade;
                }
                if( chkSubTrade != "" && compTrade == chkTrade ) {
                    chkFindNum = sheet2.FindText("f_text1", "[" + chkSubTrade + "]", 1, 2, true);
                    if(chkFindNum < 0){
                        arrSubTrade = arrSubTrade + "|" + chkSubTrade;
                        arrSubTradeNm = arrSubTradeNm + "|" + chkSubTradeNm; 
                        tmpText = sheet2.CellValue(1, "f_text1"); 
                        sheet2.CellValue2(1, "f_text1") = tmpText + "[" + chkSubTrade + "]";
                    }
                }
            }
            gArrSubTradeCob[keyTrade] = arrSubTrade + "☜☞" + arrSubTradeNm;
        }
        var arrCombo = gArrSubTradeCob[keyTrade].split("☜☞");
        var arrCode = arrCombo[0].split("|");
        var arrNm = arrCombo[1].split("|");

        if(arrCode.length == 0) {
            arrCombo = gArrSubTradeCob["[]"].split("☜☞"); 
            arrCode = arrCombo[0].split("|"); 
            arrNm = arrCombo[1].split("|"); 
        }
        for(var i = 0; i < arrCode.length; i++){
            subTradeObj.InsertItem(-1, arrCode[i] + "|" + arrNm[i], arrCode[i]);		
        }

        sub_trd_cd_OnChange(subTradeObj, "", "");

    }

    /** 
     * sub trade 콤보선택 변경시 발생하는 trd_cd_OnChange 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : 콤보생성위한 로우
     * @param  {string} Code : 콤보 코드값
     * @param  {string} Text : 콤보 텍스트값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function sub_trd_cd_OnChange(subTradeObj, Code, Text) {
        var form = document.form;
        var tradeObj = form.trd_cd;
        var laneObj = form.vsl_slan_cd;

        //if(theTrade == "") {
        //tradeObj.Code2 = "IAS";
        //}

        laneObj.RemoveAll();
        sheet2.CellValue2(1, "f_text1") = ""; // 코드검색 sheet 초기화

        var startRow = sheet3.HeaderRows;
        var endRow = sheet3.HeaderRows + sheet3.RowCount;

        var theTrade = tradeObj.Code;
        var theSubTrade = Code;
        var compTrade = theTrade;
        var compSubTrade = theSubTrade;
        if("" != theTrade) {
            var arrRange = gArrTradeRange[theTrade].split("|");
            startRow = parseInt(arrRange[0],10);
            endRow = parseInt(arrRange[1],10) + 1;
        }
        var chkFindNum;
        var tmpText;
        var keySubTrade = "[" + theTrade + "_"+ theSubTrade + "]";
        var chkSubTrade = "";
        var arrLane = "", arrLaneNm = "";	
        if(undefined == gArrLaneCob[keySubTrade]) {
            for(var i = startRow; i < endRow; i++) {
                chkTrade = sheet3.CellValue(i, C3_TRADE);
                chkSubTrade = sheet3.CellValue(i, C3_SUB_TRADE);
                chkLane = sheet3.CellValue(i, C3_LANE);
                chkLaneNm = sheet3.CellValue(i, C3_LANE_NM);			
                if(null == theTrade || "" == theTrade) compTrade = chkTrade;
                if(null == theSubTrade || "" == theSubTrade) compSubTrade = chkSubTrade;			
                if( chkLane != "" && compTrade == chkTrade && compSubTrade == chkSubTrade) {
                    chkFindNum = sheet2.FindText("f_text1", "[" + chkLane + "]", 1, 2, true);
                    if(chkFindNum < 0){
                        arrLane = arrLane + "|" + chkLane;
                        arrLaneNm = arrLaneNm + "|" + chkLaneNm;
                        tmpText = sheet2.CellValue(1, "f_text1"); 
                        sheet2.CellValue2(1, "f_text1") = tmpText + "[" + chkLane + "]";
                    }
                }
            }
            gArrLaneCob[keySubTrade] = arrLane + "☜☞" + arrLaneNm;
        }
        var arrCombo = gArrLaneCob[keySubTrade].split("☜☞");
        var arrCode = arrCombo[0].split("|");
        var arrNm = arrCombo[1].split("|");
        if(arrCode.length == 0) {
            arrCombo = gArrLaneCob["[_]"].split("☜☞");
            arrCode = arrCombo[0].split("|");
            arrNm = arrCombo[1].split("|");
        }
        for(var i = 0; i < arrCode.length; i++){
            laneObj.InsertItem(-1, arrCode[i] + "|" + arrNm[i], arrCode[i]);		
        }
    }

    /**
     * SVC Scope 콤보 포커스를 잃을 때 발생하는 svc_scp_cd_OnBlur 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @return 없음
     * @author 김대호
     * @version 2009.08.20
     */
    function svc_scp_cd_OnBlur(comboObj) {
        doActionIBSheet4(sheet4, document.form, IBSEARCH_ASYNC03);
    }

    /** 
     * Rate Type 콤보 포커스를 잃을 때 발생하는 gen_spcl_rt_tp_cd_OnBlur 함수 <br>
     * Group, Customer 콤보를 셋팅한다. <br>
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
        doActionIBSheet4(sheet4, document.form, IBSEARCH_ASYNC03);
    }

    /** 
     * Commodity 콤보 선택변경시 발생하는 cmdt_hdr_seq_OnChange 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj  : IBMultiCombo 오브젝트
     * @param  {IBMultiCombo} Code : IBMultiCombo code 값
     * @param  {IBMultiCombo} Text : IBMultiCombo text 값 (화면에 보이는 값)
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function cmdt_hdr_seq_OnChange(cmdtObj, Code, Text) {
        var form = document.form;
        var actObj = form.act_cust_cd;
        //actObj.Code2 = cmdtObj.Code;
        actObj.Code2 = Code;
    }

    /** 
     * Actual Customer 콤보 선택변경시 발생하는 act_cust_cd_OnChange 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj : IBMultiCombo 오브젝트
     * @param  {IBMultiCombo} Code : IBMultiCombo code 값
     * @param  {IBMultiCombo} Text : IBMultiCombo text 값 (화면에 보이는 값)
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function act_cust_cd_OnChange(actObj, Code, Text) {
        var form = document.form;
        var cmdtObj = form.cmdt_hdr_seq;
        //cmdtObj.Code2 = actObj.Code;
        cmdtObj.Code2 = Code;
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

        var form = document.form;

        sheet1.ShowDebugMsg = false;
        sheet2.WaitImageVisible = false;

        switch(sAction) {

            case IBSEARCH: //trade, sub trade, lane 콤보

                formObj.f_cmd.value = SEARCH01;
                sheet3.DoSearch("ESM_PRI_0108_02GS.do", FormQueryString(formObj));

                break;

            case IBSEARCH_ASYNC02: //S/C 기본내용 조회
                var scNo = getScNoValue();
                if(gBefScNo == scNo) {return false;}

                clearScInfomation();
                gBefScNo = scNo;

                var sXml = sheet2.GetSearchXml("ESM_PRI_0108_02GS.do?", "f_cmd=" + SEARCH02 + "&sc_no=" + scNo);
                form.cust_cnt_cd.value          = ComGetEtcData(sXml, "custCntCd");
                form.cust_seq.value             = ComGetEtcData(sXml, "custSeq");
                form.ctrt_pty_nm.value          = ComGetEtcData(sXml, "ctrtPtyNm");
                form.prc_ctrt_cust_tp_cd.value  = ComGetEtcData(sXml, "prcCtrtCustTpCd");
                form.ctrt_cust_sls_ofc_cd.value = ComGetEtcData(sXml, "ctrtCustSlsOfcCd");
                form.ctrt_cust_srep_cd.value    = ComGetEtcData(sXml, "ctrtCustSrepCd");
                form.srep_nm.value              = ComGetEtcData(sXml, "srepNm");
                form.ctrt_eff_dt.value          = ComGetEtcData(sXml, "ctrtEffDt");
                form.ctrt_exp_dt.value          = ComGetEtcData(sXml, "ctrtExpDt");

                // C.Group, A.Customer 재조회 필요.
                doActionIBSheet4(sheet4, form, IBSEARCH_ASYNC03);

                break;

            case IBSEARCH_ASYNC04: // sum

                var scNo = getScNoValue();
                var params = "f_cmd=" + SEARCH04 + "&sc_no=" + scNo + "&bl_obrd_dt_from=" + formObj.bl_obrd_dt_from.value + "&bl_obrd_dt_to=" + formObj.bl_obrd_dt_to.value;
                var sXml = sheet2.GetSearchXml("ESM_PRI_0108_02GS.do?", params );
                form.fnl_mqc_qty.value     = ComAddComma(ComGetEtcData(sXml, "fnlMqcQty"));
                form.op_cntr_qty.value     = ComAddComma(ComGetEtcData(sXml, "opCntrQty"));
                form.mqc_perf.value        = ComAddComma(ComGetEtcData(sXml, "mqcPerf"));
                form.pro_rt_mqc_perf.value = ComAddComma(ComGetEtcData(sXml, "proRtMqcPerf"));

                ComOpenWait(false);        		

                break;

            case IBBATCH: //backendjob 조회

                try {

                    ComOpenWait(true);
                    sheet1.WaitImageVisible = false;
                    sheet2.WaitImageVisible = false;
                    sheet5.WaitImageVisible = false;	    	

                    getScNoValue();
                    formObj.f_cmd.value = COMMAND01;
                    var sXml = sheet5.GetSearchXml("ESM_PRI_0108_02GS.do", FormQueryString(formObj));
                    var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value = backendJobKey;
                        sheet5.RequestTimeOut = 10000;
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

            case IBSEARCH: //조회

                ComOpenWait(true);

                getScNoValue();
                formObj.f_cmd.value = SEARCH;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_0108_02GS.do" , FormQueryString(formObj));
                sheet1.LoadSearchXml(sXml);

                ComOpenWait(false);

                break;

            case IBDOWNEXCEL:      //download excel

                //SpeedDown2Excel(-1);
                //sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
                sheet1.SpeedDown2Excel(-1);
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
            var sXml = sheet5.GetSearchXml("ESM_PRI_0108_02GS.do", FormQueryString(form));
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
            var sXml = sheet1.GetSearchXml("ESM_PRI_0108_02GS.do", FormQueryString(form));
            sheet1.LoadSearchXml(sXml);
            //form.result.value = ComGetEtcData(sXml, "RESULT");
        }catch(e){
            ComShowMessage(e);
            ComOpenWait(false);		
        }
    }

    /** 
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet4 <br>
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
    function doActionIBSheet4(sheetObj, formObj, sAction) {

        sheet4.ShowDebugMsg = false;
        sheet4.WaitImageVisible = false;

        switch(sAction) {

            case IBSEARCH_ASYNC03: //Commodity, actual 콤보

                var scNo          = getScNoValue();
                var svcScpCd      = formObj.svc_scp_cd.Code;
                var genSpclRtTpCd = formObj.gen_spcl_rt_tp_cd.Code;

                var chkValue = scNo + svcScpCd + genSpclRtTpCd;  
                if(gBefParam == chkValue) { return; }

                formObj.cmdt_hdr_seq.RemoveAll();
                formObj.act_cust_cd.RemoveAll();

                gBefParam = chkValue;
                var params = "f_cmd=" + SEARCH03;           
                params += "&sc_no=" + scNo;
                params += "&svc_scp_cd=" + svcScpCd;
                params += "&gen_spcl_rt_tp_cd=" + genSpclRtTpCd;

                var sXml = sheet4.GetSearchXml("ESM_PRI_0108_02GS.do?", params);
                sheet4.LoadSearchXml(sXml);

                /* 테스트 서버서 group 생성이 안된다. 원인미상 -> sheet4만들어 직접생성하는걸로 변경해봄
			//ComPriXml2ComboItem(sXml, formObj.cmdt_hdr_seq, "cmdt_hdr_seq", "cmdt_nm");
            ComXml2ComboItem(sXml, formObj.cmdt_hdr_seq, "cmdt_hdr_seq", "cmdt_nm");
			formObj.cmdt_hdr_seq.InsertItem(0, "", "");
			//ComPriXml2ComboItem(sXml, formObj.act_cust_cd, "cmdt_hdr_seq", "act_cust_nm");
			ComXml2ComboItem(sXml, formObj.act_cust_cd, "cmdt_hdr_seq", "act_cust_nm");
			formObj.act_cust_cd.InsertItem(0, "", "");
                 */			
                break;

        }
    }

    /** 
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 chkObrdDate <br>
     * Period 날짜 Validation을 체크한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} formObj : 폼 오브젝트
     * @return {boolean}
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */ 
    function chkObrdDate(formObj) {
        var form = document.form;
        var blObrdDtFrom = form.bl_obrd_dt_from;
        var blObrdDtTo = form.bl_obrd_dt_to;
        var fromVal = blObrdDtFrom.value.replace(/-/g,'');
        var toVal = blObrdDtTo.value.replace(/-/g,'');
        if(fromVal != "" && toVal != "") {
            if( parseInt(fromVal,10) > parseInt(toVal,10) ) {
                ComShowCodeMessage("PRI00306");
                ComSetFocus(formObj);
                event.returnValue = false;			
                return false;
            }
        }
        return true;
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
        var scNoSuffixObj = form.sc_no_input;
        var blObrdDtFromObj = form.bl_obrd_dt_from;
        var blObrdDtToObj = form.bl_obrd_dt_to;

        switch (sAction) {
            case IBSEARCH: //조회
                if(scNoSuffixObj.value == "") {
                    ComShowCodeMessage("PRI00335", "S/C No");
                    ComSetFocus(scNoSuffixObj);
                    return false;
                }
                if(!ComChkObjValid(blObrdDtFromObj)) {return false;}
                if(!ComChkObjValid(blObrdDtToObj)) {return false;}
                if(!chkObrdDate(blObrdDtFromObj)) {return false;}
                if(!chkObrdDate(blObrdDtToObj)) {return false;}    		

                break;
        }

        return true;

    }