/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4010.js
*@FileTitle : E-Service Compensation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.10 김대호
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview E-Service Compensation Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_4010:ESM_PRI_4010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4010() {
        this.setSheetObject 		= setSheetObject;
        this.setComboObject         = setComboObject;
        this.loadPage 				= loadPage;
        this.initSheet 				= initSheet;
        this.initCombo              = initCombo;
        this.initControl            = initControl;
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
    var gCurrRow1 = 0;
    var gCurrDate;

    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : IBSheet Object
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
        sheetCnt = sheetObjects.length;
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }    

        //html컨트롤 이벤트초기화
        axon_event.addListenerForm('beforeactivate', 'obj_activate', form);    
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		        	    	

        initIBComboItem();

        sheet1.WaitImageVisible = false;

        form.eff_dt.value = ComGetNowInfo('ymd', '-');
        gCurrDate = ComGetNowInfo('ymd', '-');

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
        ComPriTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'), "|", "\t" );    
        ComPriTextCode2ComboItem(chargeComboValue,   chargeComboText,   getComboObject(comboObjects, 'chg_cd'), "|", "\t" );    
        ComPriTextCode2ComboItem(ctrtTypeCode, ctrtTypeText, getComboObject(comboObjects, 'prc_ctrt_tp_cd') ,"|","\t" );

        //S/C관련된 부분 제거 요청
        form.prc_ctrt_tp_cd.Code2 = "R";
        form.prc_ctrt_tp_cd.enable = false;
    }

    /** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {sheetObj} sheetObj : 시트오브젝트
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
                    style.height = 440;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    //Editable = false;
                    Editable = false;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    var HeadTitle1 = "Scope|Origin|Dest.|RFA No.|E-SVC Type|E-SVC Type|E-SVC Type|Charge|Discount|Discount|Discount|Effective\nDate|Expiration\nDate|Remark(s)|User ID|Update\nDate|cmpn_rmk_tooltip";
                    var HeadTitle2 = "Scope|Origin|Dest.|RFA No.|Web|EDI|Desk\nTop|Charge|Cur.|Amount|Percentage|Effective\nDate|Expiration\nDate|Remark(s)|User ID|Update\nDate|cmpn_rmk_tooltip";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

//                  데이터속성         ROW ,COL   ,DATATYPE         ,WIDTH  ,DATAALIGN   ,COLMERGE  ,SAVENAME             ,KEYFIELD,CALCULOGIC  ,DATAFORMAT       ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0 ,cnt++ ,dtData           ,55     ,daCenter    ,true      ,"svc_scp_cd"          ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,40     ,daCenter    ,true      ,"org_rgn_cd"          ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,40     ,daCenter    ,true      ,"dest_rgn_cd"         ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,80     ,daCenter    ,true      ,"sc_no"               ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtCheckBox       ,40     ,daCenter    ,true      ,"prc_esvc_tp_cd_w"    ,false  ,""          ,dfNone           ,0         ,false     ,false     ,-1     ,false    ,true      ,""     ,false);
                    InitDataProperty(0 ,cnt++ ,dtCheckBox       ,40     ,daCenter    ,true      ,"prc_esvc_tp_cd_e"    ,false  ,""          ,dfNone           ,0         ,false     ,false     ,-1     ,false    ,true      ,""     ,false);
                    InitDataProperty(0 ,cnt++ ,dtCheckBox       ,40     ,daCenter    ,true      ,"prc_esvc_tp_cd_d"    ,false  ,""          ,dfNone           ,0         ,false     ,false     ,-1     ,false    ,true      ,""     ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,60     ,daCenter    ,true      ,"chg_cd"              ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,30     ,daCenter    ,true      ,"curr_cd"             ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,110    ,daCenter    ,true      ,"dc_amt"              ,false  ,""          ,dfNullFloat      ,2         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,70     ,daCenter    ,true      ,"dc_per"              ,false  ,""          ,dfNullInteger    ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,70     ,daCenter    ,true      ,"eff_dt"              ,false  ,""          ,dfDateYmd        ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,75     ,daCenter    ,true      ,"exp_dt"              ,false  ,""          ,dfDateYmd        ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,200    ,daLeft      ,true      ,"cmpn_rmk"            ,false  ,""          ,dfNone           ,0         ,false     ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,68     ,daCenter    ,true      ,"upd_usr_id"          ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,65     ,daCenter    ,true      ,"upd_dt"              ,false  ,""          ,dfDateYmd        ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtHidden         ,200    ,daLeft      ,true      ,"cmpn_rmk_tooltip"    ,false  ,""          ,dfNone           ,0         ,false     ,false);

                    //WordWrap = true;
                    Ellipsis = true;
                    AutoRowHeight = false;
                    ToolTipOption = "balloon:true;width:600;icon:0";

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

            case "chg_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
                }
                break;

            case "org_rgn_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 10;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
                }
                break;

            case "dest_rgn_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 10;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
                }
                break;
                
            case "prc_ctrt_tp_cd":
                with(comboObj) {
                    Style = 1;
                    DropHeight = 260;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = false;
                    SetColWidth("18|50");
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
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheet1, form, IBSEARCH);
                    break;
                case "btn_new":
                    form.sc_no.value = "";
                    form.svc_scp_cd.Code = "";
                    form.svc_scp_nm.value = "";
                    form.chg_cd.Code = "";
                    //form.prc_ctrt_tp_cd.Code = "";
                    form.org_rgn_cd.RemoveAll();
                    form.org_rgn_cd.DropHeight = 10;
                    form.org_rgn_cd.InsertItem(0, "", "");
                    form.dest_rgn_cd.RemoveAll();
                    form.dest_rgn_cd.DropHeight = 10;
                    form.dest_rgn_cd.InsertItem(0, "", "");		
                    form.eff_dt.value = gCurrDate;
                    sheet1.RemoveAll();
                    break;
                case "btns_calendar": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(form.eff_dt, 'yyyy-MM-dd');
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
            case "uppernum": //영문대문자와 숫자만 입력할수 있고, 대문자로 자동 변환
                ComKeyOnlyAlphabet('uppernum'); 
                break;
            default:
                ComKeyOnlyNumber(event.srcElement);
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
        var objValue;
        switch(srcName) {
            case "sc_no":
                /*
			objValue = formObj.value; 
			if(objValue.length > 0 && objValue.length < 9){
				ComShowCodeMessage("PRI02013");
				ComSetFocus(formObj);
				//ComAlertFocus(formObj, "S/C No는 9자 이상 입력 하셔야 합니다.");
			}
                 */
                break;
                //case "eff_dt":
                //ComChkObjValid(formObj); 
                //break;
            case "svc_scp_cd":
                break;
            default :
                ComChkObjValid(formObj);
        }
    }

    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**                                                                                            
     * svc_scp_cd 의 콤보 오브젝트를 선택변경시 발생하는 svc_scp_cd_OnChange 이벤트핸들러 <br>      
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
     * svc_scp_cd 의 콤보 오브젝트에서 포커스를 잃을 때 이벤트가 발생하는 svc_scp_cd_OnBlur 이벤트핸들러 <br>
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
        var form = document.form;
        var comboOrgRgnCd = form.org_rgn_cd;
        var comboDestRgnCd = form.dest_rgn_cd;
        //var code = comboObj.FindIndex(comboObj.Code, 0);
        var code = comboObj.Code;
        if (code != null && code != "") {
            doActionIBSheet(sheet1, form, IBSEARCH_ASYNC01);
        }else{
            comboOrgRgnCd.RemoveAll();
            comboDestRgnCd.RemoveAll();
        }
    }

    //  ===================================================================================
    //  서버 조회/저장
    //  ===================================================================================
    /** 
     * 서버 조회 및 저장등의 기능을 호출하는 doActionIBSheet  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} comboObj : 콤보오브젝트
     * @param  {form} formObj : HTML Form 컨트롤
     * @param  {int} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
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

                formObj.f_cmd.value = SEARCH;
                sheet1.DoSearch("ESM_PRI_4009GS.do", FormQueryString(formObj));
                setToolTip(sheetObj, formObj, sAction);

                ComOpenWait(false);

                break;

            case IBSEARCH_ASYNC01: //origin, dest 콤보조회

                formObj.f_cmd.value = SEARCH01;
                var sXml = sheet1.GetSearchXml("ESM_PRI_4009GS.do", FormQueryString(formObj));
                var arrData = ComPriXml2Array(sXml, "rgn_cd|rgn_nm|org_dest_cd"); //"☜☞"
                var arrRow;
                var comboOrgRgnCd = formObj.org_rgn_cd;
                var comboDestRgnCd = formObj.dest_rgn_cd;
                comboOrgRgnCd.RemoveAll();
                comboDestRgnCd.RemoveAll();
                comboOrgRgnCd.InsertItem(0, "", "");
                comboDestRgnCd.InsertItem(0,  "", "");
                for(var i = 0; i < arrData.length; i++) {
                    arrRow = arrData[i];
                    if(arrRow[2] == "O") {
                        comboOrgRgnCd.InsertItem(-1, arrRow[0] + "|" + arrRow[1], arrRow[0]);
                    } else if (arrRow[2] == "D") {
                        comboDestRgnCd.InsertItem(-1, arrRow[0] + "|" + arrRow[1], arrRow[0]);
                    }
                }

                break;

        }
    }
    //  ===================================================================================
    //  User Function
    //  ===================================================================================
    /**
     * sheet1 Remark(s)을 풍선도움말로 보여주기 위해 도움말을 생성한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.14
     */
    function setToolTip (sheetObj) {
        var startRow = sheet1.HeaderRows;
        var endRow = sheet1.HeaderRows + sheet1.RowCount;
        for (var i = startRow; i < endRow; i++) {
            sheet1.ToolTipText(i, "cmpn_rmk") = sheet1.CellValue(i, "cmpn_rmk");
        }
    }