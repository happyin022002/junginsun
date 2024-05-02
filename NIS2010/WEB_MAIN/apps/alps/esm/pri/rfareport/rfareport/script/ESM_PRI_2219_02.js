/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2219_02.js
*@FileTitle : S/C Performance Summary - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-04-01
*@LastModifier : Jong-Ock KIM
*@LastVersion : 1.0
* 2016-04-01 Jong-Ock KIM
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview Master RFA Inquiry (& Copied RFA List) 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_2219_02 : ESM_PRI_2219_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2219_02() {
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initCombo              = initCombo;
        this.obj_click              = obj_click;
        this.obj_keypress           = obj_keypress;
        this.processButtonClick     = processButtonClick;
        this.doActionIBSheet        = doActionIBSheet;
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

    //  ===================================================================================
    //  버튼 이벤트 처리
    //  ===================================================================================
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
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

                case "ComOpenPopupWithTarget":	// Office Code 가져오기 팝업
                	var ofc_cd = form.f_req_ofc.value;
                	var ofc_pts_cd = form.f_req_rhq.Text;
                    var rtnValues = new Object();
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do?pop_mode=1&func=buttonOkClick&ofc_cd='+ofc_cd+"&ofc_pts_cd="+ofc_pts_cd, 800, 430, "ofc_cd:f_rhq_ofc", "1,0,1,1,1,1,1,1", true);
                    break;   
                    
                case "btns_calendar": //달력버튼
                	var cal = new ComCalendarFromTo();
        			cal.select(form.f_eff_dt, form.f_exp_dt, 'yyyy-MM-dd');
                    break;

                case "btn_commodity": //prc_cmdt_def_cd
                    ComOpenPopup("/hanjin/COM_ENS_011.do", 780, 445, "getCOM_ENS_011", "1,0,1,1,1,1,1,1", true);
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
    //  페이지 초기화
    //  ===================================================================================
    /**
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBMultiCombo Object를 배열로 등록 <br>
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
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

        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        //axon_event.addListenerForm('beforeactivate', 'obj_activate', form); // clear Seperator
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);

        var gCurrDate = ComGetNowInfo('ymd', '-');
        form.f_eff_dt.value = gCurrDate;
        form.f_exp_dt.value = gCurrDate;

        initIBComboItem();
        
        form.f_rfa_tp.Text = 'Basic RFA';
        
//        doActionIBSheet(sheet1, form, IBSEARCH);
//        doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
    }

    /**
     * IBMultiCombo 에 Item을 setting한다. <br>
     */
    function initIBComboItem() {
    	var form = document.form;
        ComPriTextCode2ComboItem(svcScpCdComboValue,   svcScpCdComboText,   getComboObject(comboObjects, 'f_scp'),          "|", "\t" );
        ComPriTextCode2ComboItem(rhqComboValue,        rhqComboText,        getComboObject(comboObjects, 'f_req_rhq'),                 "|", "\t" );
        
        //alert(getComboObject(comboObjects, 'f_req_rhq'));
        ComSetObjValue(getComboObject(comboObjects, 'f_req_rhq'), ComGetObjValue(form.login_rhq_ofc_cd));
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":
                with (sheet1) {
                    //높이 설정
//                    style.height = 348;
            		style.height = 328;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msNone;
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
//                    var HeadTitle1 = "Seq.|Scope|RHQ|Office|EFF|EXP|Proposal\nNo.|Master\nRFA No.|AMD#|Route\nID|Origin|R.Term|O.Via|D.Via|Dest|D.Term|Lane|VVD|Current Rate|Current Rate|Current Rate|Charge Incl.|CMDT|Status";
                    
                    var HeadTitle1 = "Seq.|RFA No.|AMD\nNo.|Proposal\nNo.|Source|Scope|Request|Request|Request|EFF|EXP|Customer\nType|Customer\nName|Free Time|Status";
                    var HeadTitle1 = "Seq.|RFA No.|AMD\nNo.|Proposal\nNo.|Source|Scope|RHQ|Office|S.REp|EFF|EXP|Customer\nType|Customer\nName|Free Time|Status";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    
//                  데이터속성  ROW , COL   ,DATATYPE   ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME                  ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0, cnt++ , dtSeq     ,30     ,daCenter   ,true    ,"seq"                      );
					InitDataProperty(0, cnt++ , dtData    ,80     ,daCenter     ,false   ,"rfa_no"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"amdt_seq"                 ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,80     ,daCenter     ,false   ,"prop_no"                  ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,110     ,daCenter     ,false   ,"source"                   ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"svc_scp_cd"               ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"rhq_cd"                   ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"prop_ofc_cd"                   ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,60     ,daCenter   ,false   ,"prop_srep_cd"         ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daCenter     ,false   ,"eff_dt"                   ,false   ,""        ,dfNone    	   ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daCenter     ,false   ,"exp_dt"                   ,false   ,""        ,dfNone     	   ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtCombo    ,80     ,daCenter   ,false   ,"prc_ctrt_cust_tp_cd"              ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,230     ,daLeft   ,false   ,"cust_lgl_eng_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtCombo    ,80     ,daCenter   ,false   ,"dmdt_ft_tp_cd"     ,false   ,""        ,dfNone         ,0         ,false     ,false);                    
                    InitDataProperty(0, cnt++ , dtCombo    ,110     ,daCenter   ,false   ,"prop_sts_cd"              ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    WaitImageVisible = false;
                    
        			InitDataCombo(0, "prc_ctrt_cust_tp_cd", prcCtrtCustTpCdComboText, prcCtrtCustTpCdComboValue);
        			InitDataCombo(0, "dmdt_ft_tp_cd", dmdtFtTpCdComboText, dmdtFtTpCdComboValue);
        			InitDataCombo(0, "prop_sts_cd", propStsCdComboText, propStsCdComboValue);

                }
                break;
        }
    }

    /**
     * IBMultiCombo 기본 설정 및 초기화 <br>
     */
    function initCombo(comboObj, comboNo) {
        switch (comboObj.id) {

	        case "f_scp":
	            var i = 0;
	            with (comboObj) {
	                DropHeight = 200;
	                UseAutoComplete = true;
	                ValidChar(2, 0);    // 영문대문자만 입력
	                MaxLength = 3;      // 3자리만 입력
	            }
	            break;
        
            case "f_req_rhq":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;
                
            case "sprop_sts_cd":
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

            case "f_rfa_tp":
                var i=0;
                with(comboObj) {
					MultiSelect = true; 
					UseAutoComplete = true;	
					SetColAlign("left");
					SetColWidth("230");  
					DropHeight = 200;
					
                	InsertItem(0, "Basic RFA" , "B");
                	InsertItem(1, "Spot RFA" , "S");
                	InsertItem(2, "Contract RFA" , "C");
                }     
                break;                

        }
    }

    /**
     * 메인창에서 프로세스 호출시 분기처리하는 이벤트핸들러 <br>
     */
    function mainCallButtonClick(srcName){
        var form = document.form;
        switch(srcName) {

            case "btn_retrieve":
                if (validateForm(sheet1, form, IBSEARCH)) {
                	doActionIBSheet(sheet1, form, IBSEARCH);
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
     * sheet1 더블 클릭시 발생하는 sheet1_OnDblClick 이벤트핸들러 <br>
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var rfa_no = sheetObj.CellValue(Row, "rfa_no");
        var amdt_seq = sheetObj.CellValue(Row, "amdt_seq");
        var svc_scp_cd = sheetObj.CellValue(Row, "svc_scp_cd");
        if (rfa_no != "") { // by scope 는 scope 없다.
            var popParams = "rfa_tp_cd=M&rfa_no=" + rfa_no+"&amdt_seq="+amdt_seq+"&svc_scp_cd="+svc_scp_cd;
            comCallPop("ESM_PRI_2211", "ESM_PRI_2219_02", popParams, "");
        }else{
        	alert("There is no RFA No.");
        }
    }
    //  ===================================================================================
    //  서버 조회/저장
    //  ===================================================================================
    /**
     * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH: //조회
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch("ESM_PRI_2219_02GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:      //download excel
            	sheetObj.SpeedDown2Excel(-1);
                break;

        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 chkEffDate <br>
     */
    function chkEffDate(formObj) {
        var form = document.form;
        var effDt = form.f_eff_dt;
        var expDt = form.f_exp_dt;
        var fromVal = effDt.value.replace(/-/g,'');
        var toVal = expDt.value.replace(/-/g,'');

        var fromAddM = ComGetDateAdd(ComGetDateAdd(fromVal, "M", 3, "", true), "D", -1, "", true);
        if( parseInt(toVal,10) > parseInt(fromAddM,10) ) {
            ComShowCodeMessage("PRI00308", "check the date range!.", " Maximum date range is 3 months");
            ComSetFocus(formObj);
            return false;
        }
        return true;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
     */
    function validateForm(sheetObj, formObj, sAction){
        var form = document.form;
        var effDtObj = form.f_eff_dt;
        var expDtObj = form.f_exp_dt;
        var scpObj = form.f_scp;
        var typeObj = form.f_rfa_tp;
        switch (sAction) {
            case IBSEARCH: //조회
                if(effDtObj.value == "") {
                    ComShowCodeMessage("PRI00335", effDtObj.caption);
                    ComSetFocus(effDtObj);
                    return false;
                }
                if(expDtObj.value == "") {
                    ComShowCodeMessage("PRI00335", expDtObj.caption);
                    ComSetFocus(expDtObj);
                    return false;
                }
                if(scpObj.Text == "") {
                    ComShowCodeMessage("PRI00335", "Scope");
                    ComSetFocus(scpObj);
                    return false;
                }
                if(typeObj.Text == "") {
                    ComShowCodeMessage("PRI00335", "Type");
                    ComSetFocus(typeObj);
                    return false;
                }
                if(!ComChkObjValid(effDtObj)) {return false;}
                if(!ComChkObjValid(expDtObj)) {return false;}
                if(!chkEffDate(effDtObj)) {return false;}
                if(!chkEffDate(expDtObj)) {return false;}
                break;
        }

        return true;
    }
    
	//멀티콤보 클릭 이벤트	
	function f_rfa_tp_OnCheckClick(comboObj, index, code) { 
		MnrAllChkMultiCombo(comboObj,index);    		  
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
            case "f_req_ofc" :
            	var ofcCd = formObj.f_req_ofc.value;
            	if(sRepOfcCd != ofcCd){
            		formObj.f_req_rhq.Code = '';            		
            	}
            	break;
        }
    }
    
	function buttonOkClick(rArray) {
		var formObj = document.form;
		var ofc_cd = formObj.f_req_ofc;
		formObj.f_req_ofc.value = rArray[0][3];
        if(ofc_cd!=rArray[0][3]){//OFC_CD 가 바뀔 경우 Request RHQ 초기화
        	formObj.f_req_rhq.Text = '';
    	}
	}