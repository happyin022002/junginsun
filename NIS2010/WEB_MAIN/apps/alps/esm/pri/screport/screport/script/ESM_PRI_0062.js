/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0062.js
*@FileTitle : S/C List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.31 김대호 
* 1.0 Creation 
=========================================================
* History
* 2011.05.30 서미진 [CHM-201111191-01] S/C List Inquiry 화면에 Conversion Update 여부 보이도록 추가
* 2011.11.18 이관샨 [CHM-201114462-01] 조회조건 상의 S/C Prefix Combo Box 와 S/C No Text Column 을 하나의 Text Column 으로 합치고 조회 결과 Sheet 에 R.Customer, Scope MQC, Total MQC ( 기존 MQC 의 변경 ), Contact Sub-Office ( 기존의 Contact Office 변경 ), Contact Office, Contact Office 별 Area Grouip 을 추가
* 2012.02.03 이석준[CHM-201215685] CHSS_EXPT_FLG, GRI_APPL_FLG, NEW_SCG_FLG 추가 컬럼 조회 반영
* 2012.03.30 서미진 [CHM-201216990] Contract Sub-Office, Contract Office, Contract Area-Office의 base Office를 S/C의 Req.OFC로 변경
* 2012.05.31 이석준[CHM-201218219-01] CHSS_EXPT_FLG, GRI_APPL_FLG, NEW_SCG_FLG 컬럼 이름 변경
* 2015.06.16 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
* 2015.09.21 최성환 [CHM-201537786] SC 다운로드 보안 강화_1차 보완
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
=========================================================*/
/**
 * @fileoverview S/C List Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운 
 */

    /**
     * @extends Pri
     * @class ESM_PRI_0062 : ESM_PRI_0062 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0062() {
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

    var comboObjects = new Array();
    var comboCnt = 0;
    //  업무전역변수
    var gCurrDate;
    
	 /*
	  *  숨겨진 기능인 super user 권한을 가졌는지 여부 
	  */
//	 var FILE_CANCEL_ID  = "0010244";
//	 var FILE_CANCEL_ID2 = "0010593";
//	 var FILE_CANCEL_ID3 = "0660082";
//	 var FILE_CANCEL_ID4 = "0810022";
//	 var FILE_CANCEL_ID5 = "0810071";
//	 var FILE_CANCEL_ID6 = "0810273";
//	 var FILE_CANCEL_ID7 = "Clairelee";
//	 var FILE_CANCEL_ID8 = "0260062"; // CHM-201431827 - Filed Cancel 권한 부여 요청 추가
//	 var FILE_CANCEL_ID9 = "1110071"; // CHM-201432052 - Filed Cancel 권한 부여 요청 추가
//	 var FILE_CANCEL_ID10 = "1110093"; // CHM-201432052 - Filed Cancel 권한 부여 요청 추가	 
//	 var FILE_CANCEL_ID11 = "0310064"; // CHM-201537788 Filed Cancel 권한 부여 요청 추가
	 
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

        //IBMultiCombo 초기화
        comboCnt = comboObjects.length;
        for(var k=0;k<comboCnt;k++){
            initCombo(comboObjects[k],k+1);
        }

        //IBSheet 초기화
        sheet1 = sheetObjects[0];
        sheetCnt = sheetObjects.length ;
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }

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
        form.fx_rt_flg.checked = false;
        sheet1.ColHidden("fx_rt_flg") = true;
		sheet1.ColHidden("act_cust_nm") = true;
		
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
        ComPriTextCode2ComboItem(svcScpComboValue,     svcScpComboText,     getComboObject(comboObjects, 'svc_scp_cd'),          "|", "\t" );
        ComPriTextCode2ComboItem(custTpCdComboValue,   custTpCdComboText,   getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(aproOfcCdComboValue,  aproOfcCdComboText,  getComboObject(comboObjects, 'prop_apro_ofc_cd'),    "|", "\t" );
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
                    //MergeSheet = msNone;
                    MergeSheet = msHeaderOnly;	
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    var HeadTitle1 = "Seq.|prop_no|S/C No.|AMD\nNo.|SVC\nScope|Customer Name|Real Customer|Actual Customer|Fixed|Rate\nType|Bullet\nNo.|Customer\nType|Scope\nMQC|Total\nMQC|Approval\nOffice|Request\nSub-Office|Request\nOffice|Request\nArea-Office|S.Rep|EFF Date|EXP Date|Filed Date|NIS|BUC|PSC|PSC|Chassis|NO GRI|No New\nSurcharge|Conv.";
                    var HeadTitle2 = "Seq.|prop_no|S/C No.|AMD\nNo.|SVC\nScope|Customer Name|Real Customer|Actual Customer|Fixed|Rate\nType|Bullet\nNo.|Customer\nType|Scope\nMQC|Total\nMQC|Approval\nOffice|Request\nSub-Office|Request\nOffice|Request\nArea-Office|S.Rep|EFF Date|EXP Date|Filed Date|NIS|BUC|Including|Exception|Chassis|NO GRI|No New\nSurcharge|Conv.";
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

//                  데이터속성       ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "seq");
                    InitDataProperty(0, cnt++, dtHidden, 40,  daLeft  , true, "prop_no"              ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   70,  daCenter, true, "sc_no"                ,false, "", dfNone,        0, false, false);                    
                    InitDataProperty(0, cnt++, dtData,   50,  daCenter, true, "amdt_seq"             ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   50,  daCenter, true, "svc_scp_cd"           ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   200, daLeft,   true, "ctrt_pty_nm"          ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   170, daLeft,   true, "real_cust_nm"         ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   170, daLeft,   true, "act_cust_nm"         ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   50, daCenter, true, "fx_rt_flg"         	,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   50, daCenter, true, "gen_spcl_rt_tp_cd"         	,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   50,  daCenter, true, "blet_no"         	 ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   65,  daCenter, true, "prc_ctrt_cust_tp_cd"  ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   50,  daRight,  true, "fnl_mqc_qty"          ,false, "", dfNullInteger, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   50,  daRight,  true, "ttl_mqc_qty"          ,false, "", dfNullInteger, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,   60,  daCenter, true, "prop_apro_ofc_cd"     ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   70,  daCenter, true, "prop_ofc_cd" 		 ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   60,  daCenter, true, "ctrt_ofc"     		 ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   70,  daCenter, true, "area_grp"             ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   60,  daCenter, true, "ctrt_cust_srep_cd"    ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   65,  daCenter, true, "ctrt_eff_dt"          ,false, "", dfDateYmd,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,   65,  daCenter, true, "ctrt_exp_dt"          ,false, "", dfDateYmd,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,   65,  daCenter, true, "file_dt"              ,false, "", dfDateYmd,     0, false, false);
                    InitDataProperty(0, cnt++, dtData,   30,  daCenter, true, "lgcy_if_flg"          ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtCheckBox,   30,  daCenter, true, "buc_ind"          ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtCheckBox,   60,  daCenter, true, "psc_incl_ind"          ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtCheckBox,   70,  daCenter, true, "psc_expt_ind"          ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtCheckBox,   60,  daCenter, true, "chss_expt_flg"          ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtCheckBox,   60,  daCenter, true, "gri_appl_flg"          ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtCheckBox,   70,  daCenter, true, "new_scg_flg"          ,false, "", dfNone,        0, false, false);
                    InitDataProperty(0, cnt++, dtData,   30,  daCenter, true, "conv_cfm_flg"         ,false, "", dfNone,        0, false, false);
                    WaitImageVisible = false;
                    Ellipsis = true;
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

            case "svc_scp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
                }
                break;
 

            case "prc_ctrt_cust_tp_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 1;      // 1자리만 입력
                }
                break;

            case "prop_apro_ofc_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 100;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 5;      // 5자리만 입력
                }
                break;

            case "sc_type":
                var i = 0;
                with (comboObj) {
                    DropHeight = 100;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 1;      // 1자리만 입력
                    InsertItem(i++, "", "");
                    InsertItem(i++, "Reefer S/C", "R");
                    InsertItem(i++, "Garment S/C", "G");
                    Code = "";
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

                case "ComOpenPopupWithTarget":	// Office Code 가져오기 팝업
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:prop_ofc_cd", "1,0,1,1,1,1,1,1", true);
                    break;

                case "btn_retrieve":
                    if (validateForm(sheet1, form, IBSEARCH)) {
                        doActionIBSheet(sheet1, form, IBSEARCH);
                    }
                    break;

                case "btn_downexcel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;

                case "btn_viewsc":
                    var currRow = sheet1.SelectRow;
                    if(currRow < 1) return;

                    //현재 화면에서 RD 호출 하는 화면으로 화면ID 전달 
                    var sSpScrnEvntPgmCd = "ESM_PRI_0062"; 
                    
                    //TODO:CHOI
                    //[CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
    				// ESM_PRI_0003.js. buttonControl와 동일한 권한 참고
    				var returnValue = checkPrintOpenAuthInfo();
    				if(returnValue == "Y" ){
    					// print Popup open :: ComOpenWindowCenter("/hanjin/ESM_PRI_0079.do?sParam="+txt, "", 1024, 768, true);
    					var popParams = "prop_no=" + sheet1.CellValue(sheet1.SelectRow,"prop_no") + "&amdt_seq="+sheet1.CellValue(sheet1.SelectRow,"amdt_seq") +"&sp_scrn_evnt_pgm_cd=" + sSpScrnEvntPgmCd;
//    						var popParams = "prop_no=" + sheet1.CellValue(sheet1.SelectRow,"prop_no") + "&amdt_seq="+sheet1.CellValue(sheet1.SelectRow,"amdt_seq");  //적용전
    					
                        comCallPop("ESM_PRI_0061", "ESM_PRI_0062", popParams, "");	
    				} else { 
    					//경고 : 권한이 없음.(경고 메세지 요청)
    					ComShowCodeMessage('PRI01163'); //("You are not the authorized user");
    				}	
                    break;		    		

                case "btn_opensc":
                case "btn_amdhistory":
                    var currRow = sheet1.SelectRow;
                    if(currRow < 1) return;
                    var pgmNo = "ESM_PRI_0003";
                    if(srcName == "btn_amdhistory") {
                        pgmNo = "ESM_PRI_0057";
                    }
                    var scNo = sheet1.CellValue(currRow, "sc_no"); 
                    var popParams = "sc_no=" + scNo + "&sc_no_0062=" + scNo + "&prop_no=" + sheet1.CellValue(currRow, "prop_no") + "&amdt_seq=" + sheet1.CellValue(currRow, "amdt_seq");
                    comCallPop(pgmNo, "ESM_PRI_0062", popParams, "");
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
        var except_chr = "32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|58|59|60|61|62|63|64|91|92|93|94|95|96|123|124|125|126";
        switch(obj.dataformat){
            case "ymd": //날짜 입력하기
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": //숫자만 입력
            case "number": //숫자만 입력        
                ComKeyOnlyNumber(obj);
                break;
            case "engup":
            	if (event.srcElement.name == "sc_no") {
                    ComKeyOnlyAlphabet('uppernum');
                } else if (event.srcElement.name == "cust_nm") {
                	ComKeyOnlyAlphabet('uppernum',except_chr);
                } else if (event.srcElement.name == "act_cust_nm") {
                	ComKeyOnlyAlphabet('uppernum',except_chr);	
                } else if (event.srcElement.name == "real_cust_nm") {
                	ComKeyOnlyAlphabet('uppernum',except_chr);	
                } else if (event.srcElement.name == "afil_nm") {
                	ComKeyOnlyAlphabet('uppernum',except_chr);	
                } else {
                ComKeyOnlyAlphabet('upper');
                }
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
                
            case "fx_rt_flg" : 
            	if(form.fx_rt_flg.checked == true){
            		sheet1.ColHidden("fx_rt_flg") = false;       
            		sheet1.ColHidden("act_cust_nm") = false;       
            	}else{
            		sheet1.ColHidden("fx_rt_flg") = true;
            		sheet1.ColHidden("act_cust_nm") = true;
            	}
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
            case "prop_ofc_cd":
                break;
            default :
                ComChkObjValid(formObj);
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
    function svc_scp_cd_OnChange(comboObj, Code, Text) {
        var form = document.form;
        var cText = comboObj.GetText(Code, 1);
        form.svc_scp_nm.value = cText;
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

                ComOpenWait(true);

                setParamsClear();

                var scTypeCd = formObj.sc_type.Code;
                var rdoDtObj = formObj.rdoDate;
                formObj.f_cmd.value = SEARCH;     

                if(scTypeCd == "R"){
                    formObj.rf_flg.value = "Y";
                }else if(scTypeCd == "G"){
                    formObj.gamt_flg.value = "Y";
                }

                if(rdoDtObj[0].checked){
                    formObj.eff_dt.value = formObj.eff_date_from.value;
                    formObj.exp_dt.value = formObj.eff_date_to.value;
                }else{
                    formObj.eff_dt.value = formObj.access_date.value;
                    formObj.exp_dt.value = formObj.access_date.value;
                }

                var sXml = sheet1.GetSearchXml("ESM_PRI_0062GS.do", FormQueryString(formObj));
                form.total_mqc.value = ComAddComma2(ComGetEtcData(sXml, "totalMqc"), "#,###");
                form.noof_sc.value = ComAddComma2(ComGetEtcData(sXml, "numberOfSc"), "#,###");
                sheet1.LoadSearchXml(sXml);

                ComOpenWait(false);

                break;

            case IBDOWNEXCEL:      //download excel
                sheet1.SpeedDown2Excel(-1); //, "chk|seq"
                //sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
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
        switch (sAction) {
            case IBSEARCH: //조회
                var rdoDateObj = form.rdoDate;
                if(rdoDateObj[0].checked) {
                    if(!ComChkObjValid(form.eff_date_from)) {return false;}
                    if(!ComChkObjValid(form.eff_date_to)) {return false;}
                }else{
                    var accDtObj = form.access_date;
                    if(!ComChkObjValid(accDtObj)) {return false;}
                    if(accDtObj.value == "") {
                        ComShowCodeMessage("PRI00335", accDtObj.caption);
                        ComSetFocus(accDtObj);
                        return false;
                    }
                }
                break;
        }

        return true;

    }
    
    /**
     * TODO::[CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
     * S/C Proposal & Amendment Creation 화면의 PRINT 버튼 사용시 기준으로 동일하게 아래 대상으로 권한 적용(ESM_PRI_0003.js. buttonContro 참고)<br>
     * @param  txt
     * @return {string} <br>
     * @author 최성환
     * @version 2015.05.15
     */ 
 	function checkPrintOpenAuthInfo(){
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
 		var rValue = "N";
 		formObj.f_cmd.value = SEARCH01;
 		var sParam   = "sc_no=" + sheetObj.CellValue(sheetObj.SelectRow,"sc_no") + "&prop_no=" + sheetObj.CellValue(sheetObj.SelectRow,"prop_no") + "&amdt_seq="+sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq");
 			  sParam += "&" + FormQueryString(formObj);
 		var sXml = sheetObj.GetSearchXml("ESM_PRI_0062GS.do", sParam);

 		var stsCd 			= ComGetEtcData(sXml, "stsCd");
 		var reqUsrFlg 		= ComGetEtcData(sXml, "reqUsrFlg");
 		var aproUsrFlg 	= ComGetEtcData(sXml, "aproUsrFlg");
 		var allUsrFlg 		= ComGetEtcData(sXml, "allUsrFlg");
 		var maxPropUsrId = ComGetEtcData(sXml, "maxPropUsrId");
 		
 		//요건
 		//※ 현재 Amd 회차 별 R.OFC 의 S.Rep 코드가 부여된 ID 유저에 해당 Amd 회차에 대해 활성화되고
 		//   있으나, 마지막 회차의 R.OFC/S.Rep 코드의 ID 유저는 전(全) 회차에 대해 다운로드 할 수 있도록    보완 필요.
 		//if (로그인 사용자가 = 마지막 회차의 R.OFC/S.Rep 코드의 ID 유저 일 경우) - 전회차 다운로드가능함
//		alert(stsCd + "||" + formObj.in_usr_id.value + "||"+maxPropUsrId);
		if(formObj.in_usr_id.value == maxPropUsrId){
			rValue = "Y";
			return rValue; 
		}
		
		var fileCancelAuth = checkFileCancelUser();
		
// 		if (!(stsCd =="F" && ( formObj.in_usr_id.value == FILE_CANCEL_ID   || formObj.in_usr_id.value == FILE_CANCEL_ID2 || formObj.in_usr_id.value == FILE_CANCEL_ID3
//						           ||formObj.in_usr_id.value == FILE_CANCEL_ID4 || formObj.in_usr_id.value == FILE_CANCEL_ID5 || formObj.in_usr_id.value == FILE_CANCEL_ID6 
//						           ||formObj.in_usr_id.value == FILE_CANCEL_ID7 || formObj.in_usr_id.value == FILE_CANCEL_ID8 || formObj.in_usr_id.value == FILE_CANCEL_ID9
//						           ||formObj.in_usr_id.value == FILE_CANCEL_ID10 ||formObj.in_usr_id.value == FILE_CANCEL_ID11) ))
		if (!(stsCd == "F" && (fileCancelAuth =="Y")))
		{ //Filed이고 허가된 유저이면 로직 적용 안함. 위 로직 변형
			if(reqUsrFlg !="Y" && aproUsrFlg !="Y")
			{
				rValue = "N";   	
				return rValue;  //권한 없을시 바로 리턴함.
			}
		}
		
		switch(stsCd) {
			case 'I':   // Initial    
			if(reqUsrFlg=="Y"||aproUsrFlg=="Y"){
				rValue = "Y";
			}
			break;
			
			case 'Q':   // Requested
			rValue = "Y";           
			break;
			
			case 'R':   // Returned
			if (amdt_seq =="0"){
				rValue = "N";
			}else{ 
				rValue = "Y";
			}
			break;
			
			case 'A':   // Approved
				rValue = "Y";           
			break;
			
			case 'F':   // Filed
				rValue = "Y";
			break;                    
		}
		return rValue;  
	}          
 	
 	function checkFileCancelUser(){
		   var formObj = document.form;
		   var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCH33;                                                                                                                                                                                                                                                                                                                                                                                                        
			sXml = sheetObj.GetSearchXml("PRICommonGS.do",                                                                                                                                                                                                                                                                                                                                                                                   
					FormQueryString(formObj));                                                                                                                                                                                                                                                                                                                                                                        
			var fileCancelAuth = ComGetEtcData(sXml, "fileCancelAuth");      
			return fileCancelAuth;
	   }
	