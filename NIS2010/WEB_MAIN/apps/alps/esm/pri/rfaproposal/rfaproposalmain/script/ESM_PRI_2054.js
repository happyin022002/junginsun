/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2054.jsp
*@FileTitle : RFA Proposal & Amendment Status By Office
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.01.05 최성환
* 1.0 Creation
* =========================================================
* History
                                 
=========================================================*/
/**
 * @fileoverview RFA Retrieve 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_2054 : ESM_PRI_2054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */ 
    function ESM_PRI_2054() {
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject        = setComboObject;	
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.initCombo              	= initCombo;
    	this.obj_click              		= obj_click;
    	this.obj_keypress           	= obj_keypress;
    	this.obj_deactivate         	= obj_deactivate;
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
     * @author 최성환
     * @version 2014.12.02
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
     * @author 최성환
     * @version 2014.12.02
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
     * @author 최성환
     * @version 2014.12.02
     */ 
    function loadPage() {
        var form = document.form;	
        sheet1 = sheetObjects[0];
        sheet2 = sheetObjects[1]; // distinct 용
        sheetCnt = sheetObjects.length ;

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

        //초기 날짜.
        gCurrDate = ComGetNowInfo('ymd', '-');
        form.eff_date_from.value = ComGetDateAdd(gCurrDate, "M", -1);
        form.eff_date_to.value = gCurrDate;

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
     * @author 최성환
     * @version 2014.12.02
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
                    var HeadTitle1 = "Seq.|Retrieve\nDate|RFA|RFA|Proposal\nNo.|Prog Seq|Staus|Customer|Customer|Customer|Request|Request|Request|Approval|Approval|Approval|SVC\nScope|Date|Date|Date";
                    var HeadTitle2 = "Seq.|Retrieve\nDate|RFA NO|AMD NO|Proposal\nNo.|Prog Seq|Staus|Type|Code|Name|Sales Rep.|Office|Date|Staff|Office|Date|SVC\nScope|Effective|Expiration|Creation";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

//                  데이터속성       ROW , COL   ,DATATYPE   ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME      ,KEYFIELD,CALCULOGIC,DATAFORMAT    ,POINTCOUNT,UPDATEEDIT,INSERTEDIT, EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    //rfa
                    InitDataProperty(0, cnt++ ,dtSeq      ,50     ,daCenter   ,true   ,"Seq"                          );                                                              
                    InitDataProperty(0, cnt++ ,dtData     ,110   ,daCenter    ,true  ,"srch_dt"            			,false   ,""        ,dfNone  		,0         ,true       ,true     ,30); //조회일자.
                    InitDataProperty(0, cnt++ ,dtData     ,80     ,daCenter   ,true   ,"rfa_no"                 		,false   ,""        ,dfNone        ,0         ,true       ,true      );          
                    InitDataProperty(0, cnt++ ,dtData     ,50     ,daCenter   ,true   ,"amdt_seq"               	,false   ,""        ,dfNone        ,0         ,true       ,true      );  
                    InitDataProperty(0, cnt++ ,dtData     ,80     ,daCenter   ,true   ,"prop_no"                		,false   ,""        ,dfNone        ,0         ,true       ,true      );  
                    InitDataProperty(0, cnt++ ,dtHidden  ,50     ,daCenter   ,true   ,"prop_prog_seq"            ,false   ,""        ,dfNone        ,0         ,true       ,true      ); //dtHidden
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter   ,true   ,"prop_sts_nm"              ,false    ,""        ,dfNone        ,0         ,true       ,true      ); //dtHidden
                    //customer
                    InitDataProperty(0, cnt++ ,dtData     ,55     ,daCenter   ,true   ,"prc_ctrt_cust_tp_nm"   ,false   ,""        ,dfNone        ,0         ,true       ,true      );
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter   ,true   ,"ctrt_cust_cd"              ,false   ,""        ,dfNone        ,0         ,true       ,true      );          
                    InitDataProperty(0, cnt++ ,dtData     ,165   ,daLeft     	,true   ,"ctrt_cust_nm"             	,false   ,""        ,dfNone        ,0         ,true       ,true     ,30);
                    //request
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter  	,true   ,"prop_srep_cd"       		,false   ,""        ,dfNone        ,0         ,true       ,true 		,5 );
                    InitDataProperty(0, cnt++ ,dtData     ,60     ,daCenter   	,true   ,"prop_ofc_cd"        		,false   ,""        ,dfNone        ,0         ,true       ,true        );
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter    ,true   ,"prop_rqst_dt"            	,false   ,""        ,dfDateYmd   ,0         ,true       ,true     ,30);
                    
                    //approval
                    InitDataProperty(0, cnt++ ,dtData     ,135   ,daLeft     	,true   ,"prop_apro_staff_nm"    	,false   ,""        ,dfNone        ,0         ,true       ,true     ,30);
                    InitDataProperty(0, cnt++ ,dtData     ,70    ,daCenter   ,true    ,"prop_apro_ofc_cd"      	,false   ,""        ,dfNone        ,0         ,true       ,true     ,30);
                    InitDataProperty(0, cnt++ ,dtData     ,70    ,daCenter   ,true    ,"prop_apro_dt"            	,false   ,""        ,dfDateYmd   ,0         ,true       ,true     ,30);
                    
                    //svc scope
                    InitDataProperty(0, cnt++ ,dtData     ,70    ,daCenter   ,true   ,"svc_scp_cd"	      			,false   ,""        ,dfNone        ,0         ,true       ,true     ,30);
                    
                    //date                    
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter   ,true   ,"eff_dt"            			,false   ,""        ,dfDateYmd   ,0         ,true       ,true      );          
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter   ,true   ,"exp_dt"            			,false   ,""        ,dfDateYmd   ,0         ,true       ,true      );       
                    InitDataProperty(0, cnt++ ,dtData     ,70     ,daCenter   ,true   ,"cre_dt"           			,false   ,""        ,dfDateYmd   ,0         ,true       ,true      );   

                    
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
     * @author 최성환
     * @version 2014.12.02
     */ 
    function processButtonClick(){
        var form = document.form;
        var rdoDateObj = form.rdoDate;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

	            case "btns_calendar1": //달력버튼
	            case "btns_calendar2":
	                var cal = new ComCalendar();
	                if(srcName == "btns_calendar1"){
	                    cal.select(form.eff_date_from, 'yyyy-MM-dd');
	                }else{
	                    cal.select(form.eff_date_to, 'yyyy-MM-dd');
	                }
	                
	                break;

                case "btn_ctrt_cust": //esm_pri_2003 참조
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?nmd_cust_flg=N&is_popup=true&cust_cnt_cd="+form.ctrt_cust_cnt_cd.value+"&cust_seq="+form.ctrt_cust_seq.value, "", 640, 460, true);
                    if (rtnVal != null){                    
                        form.ctrt_cust_cnt_cd.value = rtnVal.custCntCd;         
                        form.ctrt_cust_seq.value = rtnVal.custSeq;                    
                        form.ctrt_pty_nm.value = rtnVal.custNm;  
                    }
                    break;   

                case "ComOpenPopupWithTargetPropOfc":	// Office Code 가져오기 팝업
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:prop_ofc_cd", "1,0,1,1,1,1,1,1", true);
                    searchSRep();
                    break;

                case "ComOpenPopupWithTargetPropAproOfc":	//Approval Office Code 가져오기 팝업
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:prop_apro_ofc_cd", "1,0,1,1,1,1,1,1", true);
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
     * @author 최성환
     * @version 2014.12.02
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
        
        switch(obj.name){
            case "rdoDate":
            	//Effective Date
                ComEnableObject(objEffDtFrom, true);
                ComEnableObject(objEffDtTo, true);
                objEffDtFrom.className = "input1";
                objEffDtTo.className = "input1";
                objEffDtFrom.value = ComGetDateAdd(gCurrDate, "M", -1);
                objEffDtTo.value = gCurrDate;
            
                break;
        }
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
     * @author 최성환
     * @version 2014.12.02
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
     * @author 최성환
     * @version 2014.12.02
     */ 
    function obj_deactivate() {
        var formObj = document.form;
        var srcName = event.srcElement.name;
        switch(srcName) {
            case "rfa_no":
            case "prop_ofc_cd":
            case "prop_srep_cd":
                break;
                
            //커서에서 벗어 날때 이벤트 발생    
            case "ctrt_cust_cnt_cd":
                if (formObj.ctrt_cust_cnt_cd.value == ""  ){
                	formObj.ctrt_pty_nm.value = "";
        			formObj.ctrt_cust_cnt_cd.value = "";
        			formObj.ctrt_cust_seq.value = ""
        		} 
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
                
        	case "eff_date_from":
        		ComChkObjValid(event.srcElement);
        		break;                
        	case "eff_date_to":
        		ComChkObjValid(event.srcElement);
        		break;      
        		
            default :
                ComChkObjValid(formObj);
        }

        switch(srcName) {
            case "prop_ofc_cd":
                searchSRep();
                break;
            // //커서에서 벗어 나면서 다음 함수를 호출하여 값을 조회 함.    
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
     * S.Rep 조회 이벤트 발생시 호출하는 searchSRep 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 최성환
     * @version 2014.12.02
     */
    function searchSRep() {
        return true;
        //doActionIBSheet2(sheet2, form, IBSEARCH_ASYNC01)
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
     * @author 최성환
     * @version 2014.12.02
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
     * sheet1 데이터 조회하기위한 파라미터 초기화하는 setParamsClear 이벤트핸들러 <br>
     * <br><b>Example :</b>	
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 최성환
     * @version 2014.12.02
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
     * @author 최성환
     * @version 2014.12.02
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {

        sheet1.ShowDebugMsg = false;

        switch(sAction) {

            case IBSEARCH: //조회

                var rdoDtObj = formObj.rdoDate;
                formObj.f_cmd.value = SEARCH;
                
                if(rdoDtObj[0].checked){
                	//Requested Date
                	formObj.dt_type.value = "RQST";
                } else if(rdoDtObj[1].checked){
                	//Approval Date
                    formObj.dt_type.value = "APRO";
                } else {
                	//Effectvie Date
                    formObj.dt_type.value = "EFF";
                }
                formObj.eff_dt.value = formObj.eff_date_from.value;
                formObj.exp_dt.value = formObj.eff_date_to.value;

                ComOpenWait(true);		
                
                sheet1.DoSearch("ESM_PRI_2054GS.do", FormQueryString(formObj));

                ComOpenWait(false);		

                break;

            case IBCREATE: // New
                formObj.reset();
                formObj.rdoDate[0].click();
    	        sheetObjects[0].RemoveAll();
    	        sheetObjects[1].RemoveAll();
    	        
    	        //초기 날짜.
    	        gCurrDate = ComGetNowInfo('ymd', '-');
    	        form.eff_date_from.value = ComGetDateAdd(gCurrDate, "M", -1);
    	        form.eff_date_to.value = gCurrDate;

    	        
                break;

            case IBDOWNEXCEL:      //download excel
                sheet1.SpeedDown2Excel(-1); 
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
     * @author 최성환
     * @version 2014.12.02
     */ 
    function doActionIBSheet2(sheetObj, formObj, sAction) {

        sheet2.ShowDebugMsg = false;
        sheet2.WaitImageVisible = false;

        switch(sAction) {
            case IBSEARCH_ASYNC01: //s rep
                formObj.etc1.value = formObj.prop_scp_ofc_cd.value;
                formObj.f_cmd.value = SEARCH15;
                var sXml = sheet2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
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
     * @author 최성환
     * @version 2014.12.02
     */ 
    function validateForm(sheetObj, formObj, sAction){
        var form = document.form;
        var rdoDateObj = form.rdoDate;
        var effDtFromObj = form.eff_date_from;
        var effDtToObj = form.eff_date_to;

        switch (sAction) {
            case IBSEARCH: //조회
            	
            	//Effective Date
                if(effDtFromObj.value == "") {
                    ComShowCodeMessage("PRI00335", "From Date");
                    ComSetFocus(effDtFromObj);
                    return false;
                }
                if(effDtToObj.value == "") {
                    ComShowCodeMessage("PRI00335", "To Date");
                    ComSetFocus(effDtToObj);
                    return false;
                }
                if(!ComChkObjValid(effDtFromObj)) {return false;}
                if(!ComChkObjValid(effDtToObj)) {return false;}
                
                // msgs['PRI07055'] = 'Please check effective date (31 day validation)';
                var ret = ComGetDaysBetween(effDtFromObj, effDtToObj);
                if(ret > 31) {
                	ComShowCodeMessage("PRI07055", "31");
                	ComSetFocus(effDtFromObj);
   					return false;   					
   				}
                
                break;
        }

        return true;

    }
    
