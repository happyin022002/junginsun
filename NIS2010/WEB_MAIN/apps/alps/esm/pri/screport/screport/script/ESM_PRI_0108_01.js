/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0108_01.js
*@FileTitle : S/C Performance Summary - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.02 김대호
* 1.0 Creation
=========================================================
* History
* 2011.08.25 서미진 [선처리 후 CSR] 화면 on load 시, Summary Type에서 Service scope 컬럼이 default로 보여지도록 수정
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
=========================================================*/
/**
 * @fileoverview S/C Performance Summary - Summary 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_0108_01 : ESM_PRI_0108_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0108_01() {
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initCombo              = initCombo;
        this.obj_click              = obj_click;
        this.obj_keypress           = obj_keypress;
        this.obj_deactivate         = obj_deactivate;
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
    //  컬럼변수
    var C1_SC_NO = "sc_no";
    var C1_SVC_SCP_CD = "svc_scp_cd";
    //  업무전역변수
    var gCurrDate;

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

                case "btns_calendar2":
                    var cal = new ComCalendar();
                    cal.select(form.bl_obrd_dt_to, 'yyyy-MM-dd');
                    break;

                case "btns_calendar3": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(form.eff_dt, 'yyyy-MM-dd');
                    break;

                case "btns_calendar4": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(form.exp_dt, 'yyyy-MM-dd');
                    break;

                case "ComOpenPopupWithTarget":  // Office Code 가져오기 팝업
                    ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 470, "ofc_cd:ctrt_cust_sls_ofc_cd", "1,0,1,1,1,1,1,1", true);
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
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수, IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBMultiCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj 필수, IBMultiCombo Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
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

        axon_event.addListenerForm('click', 'obj_click', form);
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');

        gCurrDate = ComGetNowInfo('ymd', '-');
        form.eff_dt.value = gCurrDate;
        form.exp_dt.value = gCurrDate;

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
        ComPriTextCode2ComboItem(rhqComboValue,        rhqComboText,        getComboObject(comboObjects, 'rhq'),                 "|", "\t" );
        ComPriTextCode2ComboItem(aproOfcCdComboValue,  aproOfcCdComboText,  getComboObject(comboObjects, 'prop_apro_ofc_cd'),    "|", "\t" );
        ComPriTextCode2ComboItem(svcScpCdComboValue,   svcScpCdComboText,   getComboObject(comboObjects, 'svc_scp_cd'),          "|", "\t" );
        ComPriTextCode2ComboItem(custTpCdComboValue,   custTpCdComboText,   getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} sheetNo 필수, IBSheet Object 태그의 아이디에 붙인 일련번호
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
                    style.height = 348;
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
                    var HeadTitle1 = "Seq.|RHQ|Approval\nOffice|Contract\nOffice|Key\nAC|S/C No.|Customer Name|Sales\nRep.|Type|SVC\nScope|MQC|EFF Date|EXP Date|PFMC (FEU)|MQC\nAttain.(%)|Pro rated\nMQC\nAttain.(%)";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

//                  데이터속성  ROW , COL   ,DATATYPE   ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME                  ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0, cnt++ , dtSeq     ,30     ,daCenter   ,true    ,"seq"                      );
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daCenter   ,false   ,"rhq_cd"                  ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,55     ,daCenter   ,false   ,"prop_apro_ofc_cd"        ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,55     ,daCenter   ,false   ,"ctrt_cust_sls_ofc_cd"    ,false   ,""         ,dfNone        ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,40     ,daCenter   ,false   ,"key_acct_flg"            ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daCenter   ,false   ,C1_SC_NO                  ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,195    ,daLeft     ,false   ,"ctrt_pty_nm"             ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,45     ,daCenter   ,false   ,"ctrt_cust_srep_cd"       ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,35     ,daCenter   ,false   ,"prc_ctrt_cust_tp_cd"     ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,40     ,daCenter   ,false   ,C1_SVC_SCP_CD             ,false   ,""        ,dfNone         ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,50     ,daRight    ,false   ,"fnl_mqc_qty"             ,false   ,""        ,dfNullInteger  ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,65     ,daLeft     ,false   ,"ctrt_eff_dt"             ,false   ,""        ,dfDateYmd      ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,65     ,daLeft     ,false   ,"ctrt_exp_dt"             ,false   ,""        ,dfDateYmd      ,0         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daRight    ,false   ,"op_cntr_qty"             ,false   ,""        ,dfNullFloat    ,2         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daRight    ,false   ,"mqc_perf"                ,false   ,""        ,dfNullFloat    ,2         ,false     ,false);
                    InitDataProperty(0, cnt++ , dtData    ,70     ,daRight    ,false   ,"pro_rt_mqc_perf"         ,false   ,""        ,dfNullFloat    ,2         ,false     ,false);
                    WaitImageVisible = false;
//                    ColHidden(C1_SVC_SCP_CD) = true;

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
                    var HeadTitle1 = "f_text1";
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

            case "rhq":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;

            case "prop_apro_ofc_cd":
                var i = 0;
                with (comboObj) {
                    DropHeight = 200;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;

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
            case "key_acct_flg":
                var i = 0;
                with (comboObj) {
                    DropHeight = 100;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    MaxLength = 1;
                    InsertItem(i++, "", "");
                    InsertItem(i++, "Y", "Y");
                    InsertItem(i++, "N", "N");
                    Code = "";
                }
                break;

        }
    }

    /**
     * 메인창에서 프로세스 호출시 분기처리하는 이벤트핸들러 <br>
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
                if (validateForm(sheet2, form, IBSEARCH)) {
                    doActionIBSheet(sheet2, form, IBBATCH);
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
        var scopeObj = form.svc_scp_cd;
        switch(obj.name){

            case "by_scope":
                var tf = true;
                if(obj.checked) {
                    //ComEnableObject(scopeObj, true);
                    scopeObj.Enable = true;
                    tf = false;
                    obj.value = "Y";
                }else{
                    //ComEnableObject(scopeObj, false);
                    scopeObj.Enable = false;
                    obj.value = "N";
                }
                sheet1.ColHidden(C1_SVC_SCP_CD) = tf;
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
        var formObj = event.srcElement;
        var srcName = formObj.getAttribute("name");
        switch(srcName) {
        	case "sc_no_input" :
        		break;
            case "ctrt_cust_sls_ofc_cd":
                break;
            default :
                ComChkObjValid(formObj);
        }
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

        try {

            var form = document.form;
            var totalMQC = 0;
            var noOfSC = 0;
            var totalOpCntrQty = 0;

            if (errMsg == "") {
                totalMQC = sheet1.ComputeSum("|fnl_mqc_qty|");
                totalOpCntrQty = sheet1.ComputeSum("|op_cntr_qty|");
            }
            form.total_mqc.value = ComAddComma2(totalMQC, "#,###");
            totalOpCntrQty = Math.round(totalOpCntrQty);
            form.total_performance.value = ComAddComma2(totalOpCntrQty, "#,###");

            sheet2.CellValue2(1, "f_text1") = "";
            var startRow = sheet1.HeaderRows;
            var endRow = sheet1.HeaderRows + sheet1.RowCount;
            var chkScNo;
            var chkFindNum;
            var tmpText;
            var noOfSc = 0;
            for(var i = startRow; i < endRow; i++) {
                chkScNo = sheet1.CellValue(i, C1_SC_NO);
                chkFindNum = sheet2.FindText("f_text1", "[" + chkScNo + "]", 1, 2, true);
                if(chkFindNum < 0){
                    noOfSc++;
                    tmpText = sheet2.CellValue(1, "f_text1");
                    sheet2.CellValue2(1, "f_text1") = tmpText + "[" + chkScNo + "]";
                }
            }
            form.noof_sc.value = ComAddComma2(noOfSc, "#,###");
        }catch(e){
            ComShowMessage(e);
        }
    }

    /**
     * sheet1 더블 클릭시 발생하는 sheet1_OnDblClick 이벤트핸들러 <br>
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
        var scNo = sheet1.CellValue(Row, C1_SC_NO);
        var svcScpCd = sheet1.CellValue(Row, C1_SVC_SCP_CD);
        var blObrdDtFrom = form.bl_obrd_dt_from.value;
        var blObrdDtTo= form.bl_obrd_dt_to.value;
        if (scNo != "") { // by scope 는 scope 없다.
            var popParams = "sc_no=" + scNo + "&svc_scp_cd=" + svcScpCd + "&bl_obrd_dt_from=" + blObrdDtFrom + "&bl_obrd_dt_to=" + blObrdDtTo;
            comCallPop("ESM_PRI_0111", "ESM_PRI_0108_01", popParams, "");
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

                    ComOpenWait(true);
                    sheet1.WaitImageVisible = false;
                    sheet2.WaitImageVisible = false;

                    var scTypeCd = formObj.sc_type.Code;
                    var rdoDtObj = formObj.rdoDate;
                    formObj.sc_no.value = formObj.sc_no_input.value;
                    if(scTypeCd == "R"){
                        formObj.rf_flg.value = "Y";
                    }else if(scTypeCd == "G"){
                        formObj.gamt_flg.value = "Y";
                    }
                    formObj.f_cmd.value = COMMAND01;
                    var sXml = sheetObj.GetSearchXml("ESM_PRI_0108_01GS.do", FormQueryString(formObj));
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

            case IBSEARCH: //조회

                ComOpenWait(true);

                var scTypeCd = formObj.sc_type.Code;
                var rdoDtObj = formObj.rdoDate;
                formObj.sc_no.value = formObj.sc_no_input.value;
                if(scTypeCd == "R"){
                    formObj.rf_flg.value = "Y";
                }else if(scTypeCd == "G"){
                    formObj.gamt_flg.value = "Y";
                }
                formObj.f_cmd.value = SEARCH;
                sheet1.DoSearch("ESM_PRI_0108_01GS.do", FormQueryString(formObj));

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
            var sXml = sheet2.GetSearchXml("ESM_PRI_0108_01GS.do", FormQueryString(form));
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
            var sXml = sheet1.GetSearchXml("ESM_PRI_0108_01GS.do", FormQueryString(form));
            sheet1.LoadSearchXml(sXml);
            //form.result.value = ComGetEtcData(sXml, "RESULT");
        }catch(e){
            ComShowMessage(e);
        }finally{
            ComOpenWait(false);
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 chkEffDate <br>
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
    function chkEffDate(formObj) {
        var form = document.form;
        var effDt = form.eff_dt;
        var expDt = form.exp_dt;
        var fromVal = effDt.value.replace(/-/g,'');
        var toVal = expDt.value.replace(/-/g,'');

        var fromAddM = ComGetDateAdd(ComGetDateAdd(fromVal, "M", 3, "", true), "D", -1, "", true);
        if( parseInt(toVal,10) > parseInt(fromAddM,10) ) {
            ComShowCodeMessage("PRI00308", "check the date range!.", " Maximum date range is 3 months");
            event.returnValue = false;
            ComSetFocus(formObj);
            return false;
        }
        return true;
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
                //msgs['PRI00305'] = '{?msg1} start date can not be greater than end date.';
                ComShowCodeMessage("PRI00305", formObj.caption);
                event.returnValue = false;
                ComSetFocus(formObj);
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
        var effDtObj = form.eff_dt;
        var expDtObj = form.exp_dt;
        var obrdFromDtObj = form.bl_obrd_dt_from;
        var obrdToDtObj = form.bl_obrd_dt_to;
        var propAproOfcCd = form.prop_apro_ofc_cd;
        switch (sAction) {
            case IBSEARCH: //조회
                //msgs['PRI00335'] = '[{?msg1}]가(이) 입력되지 않았습니다.';
                //msgs['PRI00337'] = '[{?msg1}]가(이) 선택되지 않았습니다.';
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
                if(!ComChkObjValid(effDtObj)) {return false;}
                if(!ComChkObjValid(expDtObj)) {return false;}
                if(!chkEffDate(effDtObj)) {return false;}
                if(!chkEffDate(expDtObj)) {return false;}
                if(!ComChkObjValid(obrdFromDtObj)) {return false;}
                if(!ComChkObjValid(obrdToDtObj)) {return false;}
                if(!chkObrdDate(obrdFromDtObj)) {return false;}
                if(!chkObrdDate(obrdToDtObj)) {return false;}
                /*
            if(null == propAproOfcCd.Code || "" == propAproOfcCd.Code) {
                ComShowCodeMessage("PRI00335", "Approval Office");
                ComSetFocus(propAproOfcCd);
                return false;
            }
                 */
                break;
        }

        return true;
    }