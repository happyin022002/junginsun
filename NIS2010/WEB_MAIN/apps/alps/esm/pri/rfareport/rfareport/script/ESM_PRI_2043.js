﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2043.js
*@FileTitle :  RFA List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastVersion : 1.0
* 1.0 Creation
* =========================================================
* History
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나 조회 가능토록 수정 
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만 자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2012.02.08 이석준 [CHM-201216074] RFA 조회시 HAMRU 산하의 BA OFFICE들이 상대방 BA RFA 조회 못하게 했던 부분을 다시 원래대로 조회 할 수 있도록 수정           
* 2013.03.19 전윤주 [CHM-201323647] ALPS 통합로그 SQL 오류 제거 - customer 검색 시 customer seq. 자리에 숫자가 들어오지 않는 경우 validation 처리      
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)    
* 2014.01.22 서미진 [CHM-201428589] Actual Customer 추가
* 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
=========================================================*/
/**
 * @fileoverview RFA Retrieve 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_2043 : ESM_PRI_2043 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */ 
    function ESM_PRI_2043() {
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

        //html컨트롤 이벤트초기화    
        //initControl()
        axon_event.addListenerForm('click', 'obj_click', form);	 
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	

        ComEnableObject(form.access_date, false); // access date disabled
        gCurrDate = ComGetNowInfo('ymd', '-');
        form.eff_date_from.value = gCurrDate;
        form.eff_date_to.value = gCurrDate;

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
        ComPriTextCode2ComboItem(svcScpCdComboValue,     svcScpCdComboText,     getComboObject(comboObjects, 'svc_scp_cd'),    		 "|", "\t" );
        //ComPriTextCode2ComboItem(customerCodeComboValue, customerCodeComboText, getComboObject(comboObjects, 'customer_code'), 		 "|", "\t" );
        ComPriTextCode2ComboItem(customerTypeComboValue, customerTypeComboText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
        //RFA Contract Type
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
                    style.height = 395;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    ////RFA 효율화를 위한 요청 (1차) (CHM-201640671)
                    var HeadTitle1 = "Seq.|Service\nScope|RFA|RFA|Customer|Customer|Customer|Scope\nMVC|Total\nMVC|Free\nTime|Actual\nCustomer|Request\nOffice|Requested By|Requested By|Date|Date|RFA Type";
                    var HeadTitle2 = "Seq.|Service\nScope|RFA NO|AMD NO|Type|Code|Name|Scope\nMVC|Total\nMVC|Free\nTime|Actual\nCustomer|Request\nOffice|Staff|S.Rep|Effective|Expiration|RFA Type";
                    
//                    var HeadTitle1 = "Seq.|Service\nScope|RFA|RFA|Customer|Customer|Customer|Actual\nCustomer|Request\nOffice|Sales\nRep.|Date|Date|RFA Type";
//                    var HeadTitle2 = "Seq.|Service\nScope|RFA NO|AMD NO|Type|Code|Name|Actual\nCustomer|Request\nOffice|Sales\nRep.|Effective|Expiration|RFA Type";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

//                  데이터속성       ROW , COL   ,DATATYPE   ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME                ,KEYFIELD,CALCULOGIC,DATAFORMAT    ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0, cnt++ ,dtSeq      ,50     ,daCenter   ,true   ,"Seq"                          );                                                      
                    InitDataProperty(0, cnt++ ,dtData     ,50     ,daCenter   ,true   ,"svc_scp_cd"              ,false    ,""         ,dfNone         ,0         ,true       ,true      );          
                    InitDataProperty(0, cnt++ ,dtData     ,80     ,daCenter   ,true   ,"rfa_no"                     ,false    ,""         ,dfNone         ,0         ,true       ,true      );          
                    InitDataProperty(0, cnt++ ,dtData     ,50     ,daCenter   ,true   ,"amdt_seq"                 ,false    ,""         ,dfNone         ,0         ,true       ,true      );          
//                  InitDataProperty(0, cnt++ ,dtAutoSum  ,60     ,daCenter   ,true   ,"prc_ctrt_cust_tp_nm"    ,false   ,""        ,dfNone        ,0         ,true       ,true      );          
                    InitDataProperty(0, cnt++ ,dtData     ,55     ,daCenter   ,true   ,"prc_ctrt_cust_tp_nm"  ,false    ,""         ,dfNone         ,0         ,true       ,true      );
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter   ,true   ,"code"                        ,false    ,""         ,dfNone         ,0         ,true       ,true      );          
                    InitDataProperty(0, cnt++ ,dtData     ,165   ,daLeft       ,true   ,"cust_nm"                   ,false    ,""         ,dfNone         ,0         ,true       ,true     ,30);
                    //RFA 효율화를 위한 요청 (1차) (CHM-201640671)
                    InitDataProperty(0, cnt++, dtData 	  ,60      ,daCenter   ,true  ,"svc_tgt_qty"		       ,false	  ,""	       ,dfInteger	  ,0         ,false      ,false);
                    InitDataProperty(0, cnt++, dtData 	  ,60      ,daCenter   ,true  ,"mn_tgt_qty"		       	   ,false	  ,""	       ,dfInteger	  ,0         ,false      ,false);
                    InitDataProperty(0, cnt++ ,dtData    ,80      ,daCenter   ,true   ,"dmdt_ft_tp_nm"          ,false   ,""          ,dfNone         ,0         ,true       ,true     ,30);
                    
                    InitDataProperty(0, cnt++ ,dtData     ,135   ,daLeft       ,true   ,"act_cust_nm"             ,false   ,""          ,dfNone         ,0         ,true       ,true     ,30);
                    InitDataProperty(0, cnt++ ,dtData     ,60     ,daCenter   ,true   ,"prop_scp_ofc_cd"        ,false   ,""         ,dfNone          ,0         ,true       ,true        );
                    //RFA 효율화를 위한 요청 (1차) (CHM-201640671) Requested By Staff
                    InitDataProperty(0, cnt++ ,dtData     ,135   ,daLeft       ,true   ,"prop_scp_srep_nm"      ,false   ,""         ,dfNone          ,0         ,true       ,true     ,30);
                    InitDataProperty(0, cnt++ ,dtData     ,50     ,daCenter   ,true   ,"prop_scp_srep_cd"       ,false   ,""         ,dfNone          ,0         ,true       ,true 	,5 );
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter   ,true   ,"ctrt_eff_dt"                ,false   ,""         ,dfDateYmd     ,0         ,true       ,true      );          
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter   ,true   ,"ctrt_exp_dt"               ,false   ,""         ,dfDateYmd     ,0         ,true       ,true      );          
                    InitDataProperty(0, cnt++ ,dtData     ,50     ,daCenter   ,true   ,"rfa_ctrt_tp_cd"           ,false   ,""         ,dfNone           ,0         ,true       ,true      );     
                    Ellipsis = true;
                    HeadRowHeight = DataRowHeight;
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
            //svc scope
            case "svc_scp_cd":
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
                }
                break;
            case "rfa_ctrt_tp_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    // BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                }    
                break;   
            case "prop_scp_ofc_srep_cd":
                var i=0;
                with(comboObj) {
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 1);
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

                case "btn_ctrt_cust": //esm_pri_2003 참조
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?nmd_cust_flg=N&is_popup=true&cust_cnt_cd="+form.ctrt_cust_cnt_cd.value+"&cust_seq="+form.ctrt_cust_seq.value, "", 640, 460, true);
                    if (rtnVal != null){                    
                        form.ctrt_cust_cnt_cd.value = rtnVal.custCntCd;         
                        form.ctrt_cust_seq.value = rtnVal.custSeq;                    
                        form.ctrt_pty_nm.value = rtnVal.custNm;  
                    }
                    break;   

                case "ComOpenPopupWithTarget":	// Office Code 가져오기 팝업
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:prop_scp_ofc_cd", "1,0,1,1,1,1,1,1", true);
                    searchSRep();
                    break;

                case "btn_retrieve":
                    setParamsClear();
                    if (validateForm(sheet1, form, IBSEARCH)) {
                        doActionIBSheet(sheet1, form, IBSEARCH);
                    }
                    break;

                case "btn_new":
                    doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;

                case "btn_viewrfa":
                	//RFA 효율화를 위한 요청 (1차) (CHM-201640671)
                	var currRow = sheet1.SelectRow;
                    if(currRow < 1) return;
                    //CD03493  M: Master 
                    var type = sheet1.CellValue(currRow, "rfa_ctrt_tp_cd");
                    var pgmNo = "ESM_PRI_2003";   
                    if(type != null && type != "" && type == "Master") {
                    	 pgmNo = "ESM_PRI_2203"; //Master Creation.             
                    } else  if(type != null && type != "" && type == "Spot Guide") {
                    	pgmNo = "ESM_PRI_2103"; //Spot Guide Creation.
                    } else {
                    	pgmNo = "ESM_PRI_2003"; //Individual Creation.
                    }
                    var popParams = "rfa_no_2043=" + sheet1.CellValue(currRow, "rfa_no");
                    
                    comCallPop(pgmNo, "ESM_PRI_2043", popParams, "");
                    
                    break;
                    
                case "btn_viewamdhistory":
                    var currRow = sheet1.SelectRow;
                    if(currRow < 1) return;
                    var pgmNo = "ESM_PRI_2003";
                    if(srcName == "btn_viewamdhistory") {
                        pgmNo = "ESM_PRI_2041";
                    }
                    var popParams = "rfa_no_2043=" + sheet1.CellValue(currRow, "rfa_no");
                    comCallPop(pgmNo, "ESM_PRI_2043", popParams, "");
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
                ComKeyOnlyAlphabet('uppernum',"32|64");
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
        var formObj = document.form;
        var srcName = event.srcElement.name;
        switch(srcName) {
            case "rfa_no":
            case "prop_scp_ofc_cd":
            case "prop_scp_srep_cd":
                break;
            case "ctrt_cust_seq":
                if (formObj.ctrt_cust_seq.value.length < 6 && formObj.ctrt_cust_seq.value.length != 0 ){
                    formObj.ctrt_cust_seq.value = ComLpad(formObj.ctrt_cust_seq.value, 6, "0");
                }
                if (formObj.ctrt_cust_seq.value == "" || !ComIsNumber(formObj.ctrt_cust_seq.value)) { //[CHM-201323647] 숫자가 아닌 경우 clear
        			formObj.ctrt_pty_nm.value = "";
        			formObj.ctrt_cust_cnt_cd.value = "";
        			formObj.ctrt_cust_seq.value = ""
        		} 
                break;
            default :
                ComChkObjValid(formObj);
        }

        switch(srcName) {
            case "prop_scp_ofc_cd":
                searchSRep();
                break;
            case "ctrt_cust_cnt_cd":
            case "ctrt_cust_seq":
                custNameFind();
                break;
        }

    }

    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
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
    function svc_scp_cd_OnChange(comboObj, code, text) {
        var form = document.form;
        //var code = comboObj.FindIndex(comboObj.Code, 0);
        //if (code != null && code != "") {
        var text = comboObj.GetText(code, 1);
        form.svc_scp_nm.value = text;
        //}else{
        //form.svc_scp_nm.value = "";
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
    	doActionIBSheet2(sheet2, form, IBSEARCH_ASYNC01)
//    	return true;
    }

    /** 
     * customer name 조회하는 custNameFind 함수 <br>
     * 2003 메소드 참조. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function custNameFind(){
        var form = document.form;
        var ctrt_cust_cnt_cd = form.ctrt_cust_cnt_cd.value;  
        var ctrt_cust_seq = form.ctrt_cust_seq.value;
        if(ctrt_cust_cnt_cd != "" && ctrt_cust_seq !="") {
            var sParam = "f_cmd=" + SEARCH02 + "&cust_cnt_cd=" + ctrt_cust_cnt_cd + "&cust_seq=" + ctrt_cust_seq;
            var sXml = sheet2.GetSearchXml("ESM_PRI_2003GS.do", sParam);
            //var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_cust_val_sgm|respb_srep_cd|respb_sls_ofc_cd|ctrt_cust_srep_nm|prc_ctrt_cust_tp_nm|ctrt_cust_val_sgm_cd");
            var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm");        
            if(arrText==undefined){
                form.ctrt_pty_nm.value = "";
                form.ctrt_cust_cnt_cd.value = "";
                form.ctrt_cust_seq.value = "";
            }else{           
                form.ctrt_pty_nm.value = arrText[0][1];
            }
        }else{
            form.ctrt_pty_nm.value = "";
        }
    }   

    /** 
     * S.Rep 콤보포커스 해제시 발생하는 prop_scp_srep_cd_OnChange 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo 오브젝트
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.20
     */
    function prop_scp_srep_cd_OnChange(actObj, code, text) {
        var form = document.form;
        //var code = actObj.Code;
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
        var chkBCO;
        var countBCO = 0;
        if (errMsg == "") {
            /*
    	if(sheet1.RowCount > 0) {
    	    var startRow = sheet1.HeaderRows;
    		var endRow = sheet1.HeaderRows + sheet1.RowCount;
    		for(var i = startRow; i < endRow; i++) {
    			chkBCO = sheet1.CellValue(i, "prc_ctrt_cust_tp_nm");			
    			if(chkBCO == "BCO"){countBCO++;}
    		}
    	}
    	sheet1.SumValue(0, "prc_ctrt_cust_tp_nm") = countBCO;
             */
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

            case IBSEARCH: //조회

                var rdoDtObj = formObj.rdoDate;
                formObj.f_cmd.value = SEARCH;
                if(rdoDtObj[0].checked){
                    formObj.eff_dt.value = formObj.eff_date_from.value;
                    formObj.exp_dt.value = formObj.eff_date_to.value;
                }else{
                    var accDt = formObj.access_date.value;
                    formObj.eff_dt.value = accDt;
                    formObj.exp_dt.value = accDt;
                }

                ComOpenWait(true);		

                sheet1.DoSearch("ESM_PRI_2043GS.do", FormQueryString(formObj));

                ComOpenWait(false);		

                break;

            case IBCREATE: // New
                formObj.reset();
                formObj.svc_scp_cd.Index = "-1";
                formObj.prc_ctrt_cust_tp_cd.Index = "-1";
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
                formObj.etc1.value = formObj.prop_scp_ofc_cd.value;
                formObj.f_cmd.value = SEARCH32;//SEARCH32 <-- SEARCH15
//                alert(FormQueryString(formObj));
                var sXml = sheet2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, formObj.prop_scp_ofc_srep_cd, "cd", "nm|cd");
                formObj.prop_scp_ofc_srep_cd.InsertItem(0, "", "");
                formObj.prop_scp_ofc_srep_cd.value = "";
                
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
        var scopeObj = form.svc_scp_cd;
        var rdoDateObj = form.rdoDate;
        var effDtFromObj = form.eff_date_from;
        var effDtToObj = form.eff_date_to;
        var accessDtObj = form.access_date;

        switch (sAction) {
            case IBSEARCH: //조회
                if(null == scopeObj.Code || "" == scopeObj.Code){
                    ComShowCodeMessage("PRI00337", "SVC Scope");
                    ComSetFocus(scopeObj);
                    return false;
                }
                if(rdoDateObj[0].checked) {
                    if(effDtFromObj.value == "") {
                        ComShowCodeMessage("PRI00335", "RFA Effective Date");
                        ComSetFocus(effDtFromObj);
                        return false;
                    }
                    if(effDtToObj.value == "") {
                        ComShowCodeMessage("PRI00335", "RFA Effective Date");
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
                break;
        }

        return true;

    }