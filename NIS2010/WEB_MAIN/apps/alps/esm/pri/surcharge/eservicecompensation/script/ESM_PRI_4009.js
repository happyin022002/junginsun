/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4009.js
*@FileTitle : E-Service Compensation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.03 김대호
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview E-Service Compensation Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

    /**
     * @extends Pri
     * @class ESM_PRI_4009 : ESM_PRI_4009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4009() {
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initCombo              = initCombo;
        this.initControl            = initControl;
        this.processButtonClick     = processButtonClick;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
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
    var gSvcScpCd;
    var gScNo, gRfaNo;
    var gRgnCdS, gRgnNmS, gDestCdS, gDestNmS;
    var gCurrDate;

    //  ===================================================================================
    //  페이지 초기화
    //  ===================================================================================

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
                case "btn_add":
                    doActionIBSheet(sheet1, form, IBINSERT);
                    break;
                case "btn_del":
                    doActionIBSheet(sheet1, form, IBDELETE);
                    break;
                case "btn_save":
                    doActionIBSheet(sheet1, form, IBSAVE);
                    break;
            } //end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

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

        //html컨트롤 이벤트초기화
        axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');

        initIBComboItem();

        sheet1.WaitImageVisible = false;

        form.eff_dt.value = ComGetNowInfo('ymd', '-');
        gCurrDate = ComGetNowInfo('ymd', '-');

        doActionIBSheet(sheet1, form, IBSEARCH);
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
                    //style.height = 462;
                    style.height = 435;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);
                    var HeadTitle1 = "chk|cmpn_seq|ibflag|Scope|Origin|Dest.|RFA No.|E-SVC Type|E-SVC Type|E-SVC Type|Charge|Discount|Discount|Discount|Effective\nDate|Expiration\nDate|Remark(s)|User ID|Update\nDate";
                    var HeadTitle2 = "chk|cmpn_seq|ibflag|Scope|Origin|Dest.|RFA No.|Web|EDI|Desk\nTop|Charge|Cur.|Amount|Percentage|Effective\nDate|Expiration\nDate|Remark(s)|User ID|Update\nDate";
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

//                  데이터속성         ROW ,COL   ,DATATYPE         ,WIDTH  ,DATAALIGN   ,COLMERGE  ,SAVENAME             ,KEYFIELD,CALCULOGIC  ,DATAFORMAT       ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
                    InitDataProperty(0 ,cnt++ ,dtDummyCheck     ,30     ,daCenter    ,true      ,"chk"     );
                    InitDataProperty(0 ,cnt++ ,dtData           ,30     ,daCenter    ,true      ,"cmpn_seq"            ,true   ,""          ,dfNone);
                    InitDataProperty(0 ,cnt++ ,dtHiddenStatus   ,30     ,daCenter    ,true      ,"ibflag"  );
                    InitDataProperty(0 ,cnt++ ,dtCombo          ,55     ,daCenter    ,true      ,"svc_scp_cd"          ,true   ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtCombo          ,40     ,daCenter    ,true      ,"org_rgn_cd"          ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtCombo          ,40     ,daCenter    ,true      ,"dest_rgn_cd"         ,false  ,""          ,dfNone           ,0         ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,80     ,daCenter    ,true      ,"sc_no"               ,true   ,""          ,dfNone           ,0         ,true      ,true      ,11);
                    InitDataProperty(0 ,cnt++ ,dtCheckBox       ,40     ,daCenter    ,true      ,"prc_esvc_tp_cd_w"    ,false  ,""          ,dfNone           ,0         ,true      ,true      ,-1     ,false    ,true      ,""     ,false);
                    InitDataProperty(0 ,cnt++ ,dtCheckBox       ,40     ,daCenter    ,true      ,"prc_esvc_tp_cd_e"    ,false  ,""          ,dfNone           ,0         ,true      ,true      ,-1     ,false    ,true      ,""     ,false);
                    InitDataProperty(0 ,cnt++ ,dtCheckBox       ,40     ,daCenter    ,true      ,"prc_esvc_tp_cd_d"    ,false  ,""          ,dfNone           ,0         ,true      ,true      ,-1     ,false    ,true      ,""     ,false);
                    InitDataProperty(0 ,cnt++ ,dtCombo          ,60     ,daCenter    ,true      ,"chg_cd"              ,true   ,""          ,dfNone           ,0);
                    InitDataProperty(0 ,cnt++ ,dtCombo          ,30     ,daCenter    ,true      ,"curr_cd"             ,false  ,""          ,dfNone           ,0         ,true);
                    InitDataProperty(0 ,cnt++ ,dtData           ,110    ,daCenter    ,true      ,"dc_amt"              ,false  ,""          ,dfNullFloat      ,2         ,true      ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,70     ,daCenter    ,true      ,"dc_per"              ,false  ,""          ,dfNullInteger    ,0         ,true      ,true); //dc_amt 에 같이 들어감
                    InitDataProperty(0 ,cnt++ ,dtData           ,70     ,daCenter    ,true      ,"eff_dt"              ,true   ,""          ,dfDateYmd        ,0);
                    InitDataProperty(0 ,cnt++ ,dtData           ,75     ,daCenter    ,true      ,"exp_dt"              ,true   ,""          ,dfDateYmd        ,0);
                    InitDataProperty(0 ,cnt++ ,dtData           ,200    ,daLeft      ,true      ,"cmpn_rmk"            ,false  ,""          ,dfNone           ,0         ,false     ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,68     ,daCenter    ,true      ,"upd_usr_id"          ,false  ,""          ,dfNone           ,0         ,false     ,false);
                    InitDataProperty(0 ,cnt++ ,dtData           ,65     ,daCenter    ,true      ,"upd_dt"              ,false  ,""          ,dfDateYmd        ,0         ,false     ,false);
                    WaitImageVisible = false;
                    InitDataValid(0, "sc_no", vtEngUpOther, "0123456789"); //영문대문자+숫자만입력

                    InitDataCombo(0, "svc_scp_cd",  svcScpCdComboText, svcScpCdComboValue);
                    InitDataCombo(0, "org_rgn_cd",  originComboText,   originComboValue);
                    InitDataCombo(0, "chg_cd",      chargeComboText, chargeComboValue);
                    InitDataCombo(0, "dest_rgn_cd", destComboText, destComboValue);
                    InitDataCombo(0, "curr_cd",     curComboText,  curComboValue);

                    InitComboNoMatchText(true);

                    ColHidden("chk") = true;
                    ColHidden("cmpn_seq") = true;
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
            doActionIBSheet(sheet1, form, IBSEARCH_ASYNC02);
        }else{
            comboOrgRgnCd.RemoveAll();
            comboDestRgnCd.RemoveAll();
        }
    }

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

                formObj.f_cmd.value = SEARCH;
                sheet1.DoSearch("ESM_PRI_4009GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC01: //origin, dest 콤보조회
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheet1.GetSearchXml("ESM_PRI_4009GS.do", FormQueryString(formObj) + "&svc_scp_cd=" + gSvcScpCd + "&delt_flg=N" );
                var arrData = ComPriXml2Array(sXml, "rgn_cd|rgn_nm|org_dest_cd"); //"☜☞"
                var arrRow;
                gRgnCdS = ""; gRgnNmS = ""; gDestCdS = ""; gDestNmS = "";
                for(var i = 0; i < arrData.length; i++) {
                    arrRow = arrData[i];
                    if(arrRow[2] == "O") {
                        if(gRgnCdS.length == 0) {
                            gRgnCdS = arrRow[0];
                            gRgnNmS = arrRow[0] + "\t" + arrRow[1];
                        } else {
                            gRgnCdS += "|" + arrRow[0];
                            gRgnNmS += "|" + arrRow[0] + "\t" + arrRow[1];
                        }
                    } else if (arrRow[2] == "D") {
                        if(gDestCdS.length == 0) {
                            gDestCdS = arrRow[0];
                            gDestNmS = arrRow[0] + "\t" + arrRow[1];
                        } else {
                            gDestCdS += "|" + arrRow[0];
                            gDestNmS += "|" + arrRow[0] + "\t" + arrRow[1];
                        }
                    }
                }
                gRgnCdS = " |" + gRgnCdS;
                gRgnNmS = " |" + gRgnNmS;
                gDestCdS = " |" + gDestCdS;
                gDestNmS = " |" + gDestNmS;

                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC02: //origin, dest 멀티콤보조회
                formObj.f_cmd.value = SEARCH01;
                var param = "f_cmd=" + formObj.f_cmd.value + "&svc_scp_cd=" + formObj.svc_scp_cd.Code;
                var sXml = sheet1.GetSearchXml("ESM_PRI_4009GS.do", param);
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
            /* S/C NO 조회 삭제됨    
            case IBSEARCH_ASYNC04: //SC No 조회
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCH04;
                sheet1.CellValue2(gCurrRow1, "sc_no") = "";
                var sXml = sheet1.GetSearchXml("ESM_PRI_4009GS.do", "f_cmd=" + formObj.f_cmd.value + "&sc_no=" + gScNo );
                var chkScNo = ComGetEtcData(sXml, "SC_NO");
                if(chkScNo.length > 0 && gScNo == chkScNo) {
                    sheet1.CellValue2(gCurrRow1, "sc_no") = chkScNo;
                } else {
                    sheet1.CellValue2(gCurrRow1, "sc_no") = "";
                    ComShowCodeMessage("PRI02014");
                }
                ComOpenWait(false);
                break;
             */
            case IBSEARCH_ASYNC05: //RFA NO 조회
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCH05;
                sheet1.CellValue2(gCurrRow1, "sc_no") = "";
                var sXml = sheet1.GetSearchXml("ESM_PRI_4009GS.do", "f_cmd=" + formObj.f_cmd.value + "&rfa_no=" + gRfaNo );
                var chkRfaNo = ComGetEtcData(sXml, "RFA_NO");
                if(chkRfaNo.length > 0 && gRfaNo == chkRfaNo) {
                    sheet1.CellValue2(gCurrRow1, "sc_no") = chkRfaNo;
                } else {
                    sheet1.CellValue2(gCurrRow1, "sc_no") = "";
                    ComShowCodeMessage("PRI02015");
                }
                ComOpenWait(false);
                break;

            case IBINSERT: //Row Add
                var idx = sheet1.DataInsert();
                sheet1.CellValue(idx, "cmpn_seq") = getMaxCmpnSeq();
                sheet1.CellComboItem(idx, "org_rgn_cd", " ", " ");
                sheet1.CellComboItem(idx, "dest_rgn_cd", " ", " ");
                sheet1.SelectCell(idx, "svc_scp_cd", true);
                break;

            case IBDELETE: //Delete
                deleteRowCheck(sheet1, "chk", true);
                break;

            case IBSAVE:   //Save
                ComOpenWait(true);
                if (!validateForm(sheet1, form, IBSAVE)) {
                    return;
                }
                if (!ComPriConfirmSave()) {
                    return;
                }

                formObj.f_cmd.value = MULTI; //7
//                var sParamSheet1 = sheet1.GetSaveString();
//                if (sheet1.IsDataModified && sParamSheet1 == "") {
//                    return;
//                }
//
//                var sXml = sheet1.GetSaveXml("ESM_PRI_4009GS.do", FormQueryString(formObj) + "&" + sParamSheet1);
//                sheet1.LoadSaveXml(sXml);
                
                var param = "f_cmd=" + formObj.f_cmd.value;
                sheet1.DoSave("ESM_PRI_4009GS.do", param, -1, false);
                ComOpenWait(false);
                break;
        }
    }

    /**
     * sheet1 셀의 값이 바뀔때 발생하는 sheet1_OnChange 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트
     * @param  {IBSheet} Row : 변경된 행 정보
     * @param  {IBSheet} Col : 변경된 컬럼정보
     * @param  {IBSheet} Value : 변경된 값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
        var form = document.form;
        var colName = sheet1.ColSaveName(Col);
        switch (colName) {

            case "svc_scp_cd":
                var colValue = Value;
                colValue = colValue.replace(/ /g,"");

                if(colValue == "") {
                    sheet1.CellComboItem(Row, "org_rgn_cd", " ", " ");
                    sheet1.CellComboItem(Row, "dest_rgn_cd", " ", " ");
                    return;
                }
                gSvcScpCd = colValue;
                sheetObj.WaitImageVisible = false;
                doActionIBSheet(sheet1, form, IBSEARCH_ASYNC01);
                sheet1.CellComboItem(Row, "org_rgn_cd", gRgnNmS, gRgnCdS);
                sheet1.CellComboItem(Row, "dest_rgn_cd", gDestNmS, gDestCdS);

                break;

            case "sc_no":
                var colValue = Value;
                colValue = colValue.replace(/ /g,"");
                var valueLen = colValue.length;
                gCurrRow1 = Row;

                /* S/C NO 조회 삭제
                if(valueLen < 10) {
                    gScNo = colValue;
                    doActionIBSheet(sheet1, form, IBSEARCH_ASYNC04);
                } else {
                    //} else if(valueLen == 10) {
                    gRfaNo = colValue;
                    doActionIBSheet(sheet1, form, IBSEARCH_ASYNC05);
                }
                */
                
                
                /* else { // 이행 데이터 SC는 9자이하, RFA 10 자리 이상 있음.
	                sheet1.CellValue2(Row, "sc_no") = "";
	                ComShowCodeMessage("PRI02013"); //'RFA & S/C No. 는  9자 이상 입력하셔야 합니다.'
	                return;
	            }
                 */
                
                if(valueLen > 9) {
                	gRfaNo = colValue;
                    doActionIBSheet(sheet1, form, IBSEARCH_ASYNC05);
                } else {
                	sheet1.CellValue2(Row, "sc_no") = "";
                	sheet1.SelectCell(Row, Col);
                }
                
                break;

            case "eff_dt":
            case "exp_dt":
                var effDt = sheet1.CellValue(Row, "eff_dt");
                var expDt = sheet1.CellValue(Row, "exp_dt");
                if(effDt != "" && expDt != "") {
                    if(effDt >= expDt) {
                        //msgs['PRI00321'] = '[{?msg1}]는 {?msg2}보다 큰 값이어야 합니다.';
                        //msgs['PRI00336'] = '[{?msg1}]는 {?msg2}보다 작은 값이어야 합니다.';
                        ComShowCodeMessage("PRI00321","Expiration Date","Effective Date");
                        sheet1.SelectCell(Row, colName, true);
                        sheet1.CellValue2(Row, colName) = "";
                        return false;
                    }
                }
                break;
        }
    }

    /**
     * sheet1 특정 셀의 값을 편집한 직후에 발생하는 sheet1_OnAfterEdit 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트
     * @param  {Long} Row : 해당 셀의 Row Index
     * @param  {Long} Col : 해당 셀의 Column Index
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {
        var colName = sheet1.ColSaveName(Col);
        switch (colName) {

            case "curr_cd":
                var colValue = sheet1.CellValue(Row, "curr_cd");
                colValue = colValue.replace(/ /g,"");
                var orgCurrCd = sheet1.CellSearchValue(Row, "curr_cd").replace(/ /g,"");

                if(colValue != "") { // dc_amt 입력
                    sheet1.CellValue2(Row, "dc_per") = "";
                    sheet1.CellEditable(Row, "dc_per") = false;

                    sheet1.CellEditable(Row, "dc_amt") = true;
                    if(colValue == orgCurrCd) {
                        sheet1.CellValue2(Row, "dc_amt") = sheet1.CellSearchValue(Row, "dc_amt");
                    }else{
                        sheet1.CellValue2(Row, "dc_amt") = "";
                    }
                    sheet1.SelectCell(Row, "dc_amt", true);
                }else{ // dc_per 입력
                    sheet1.CellValue2(Row, "dc_amt") = "";
                    sheet1.CellEditable(Row, "dc_amt") = false;

                    sheet1.CellEditable(Row, "dc_per") = true;
                    if(colValue == orgCurrCd) {
                        sheet1.CellValue2(Row, "dc_per") = sheet1.CellSearchValue(Row, "dc_per");
                    }else{
                        sheet1.CellValue2(Row, "dc_per") = "";
                    }
                    sheet1.SelectCell(Row, "dc_per", true);
                }
                break;
        }
    }

    /**
     * sheet1 셀을 마우스 선택시 발생하는 sheet1_OnClick 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트
     * @param  {IBSheet} Row : 변경된 행 정보
     * @param  {IBSheet} Col : 변경된 컬럼정보
     * @param  {IBSheet} Value : 변경된 값
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
        var colName = sheet1.ColSaveName(Col);
        switch (colName) {
            case "cmpn_rmk":
                ComShowMemoPad(sheet1,null,null,null,200,180,500);
                break;
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
        if (errMsg == "") {
            var chkCurrCd;
            var startRow = sheet1.HeaderRows;
            var endRow = sheet1.HeaderRows + sheet1.RowCount;
            for(var i = startRow; i < endRow; i++ ) {
                chkCurrCd = sheet1.CellValue(i,"curr_cd").replace(/ /g,"");
                if(chkCurrCd == "") {
                    sheet1.CellEditable(i, "dc_amt") = false;
                    sheet1.CellEditable(i, "dc_per") = true;
                } else {
                    sheet1.CellEditable(i, "dc_amt") = true;
                    sheet1.CellEditable(i, "dc_per") = false;
                }
                sheet1.CellBackColor(i, "cmpn_rmk") = sheet1.RgbColor(0, 0, 0);
            }
        }
    }

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * Sheet 저장 완료 후 로직을 실행 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {string} ErrMsg 선택, 조회 후 메세지
     * @returns 없음
     * @author 문동규
     * @version 2010.04.29
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }

    /**
     * max seq 를 가져오는 getMaxCmpnSeq 함수. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return int maxSeq
     * @see #
     * @author 김대호
     * @version 2009.08.12
     */
    function getMaxCmpnSeq() {
        var maxSeq = 0; cmpnSeq = 0;
        var startRow = sheet1.HeaderRows;
        var endRow = sheet1.HeaderRows + sheet1.RowCount;
        for(var i = startRow; i < endRow; i++ ) {
            cmpnSeq = parseInt(sheet1.CellValue(i,"cmpn_seq"),10);
            if(cmpnSeq > maxSeq) {
                maxSeq = cmpnSeq;
            }
        }
        return maxSeq + 1;
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

        switch (sAction) {
            case IBSAVE: //저장
                if (sheet1.IsDataModified) {
                    var chkCurrCd, chkDcAmt, chkDcPer;
                    var startRow = sheet1.HeaderRows;
                    var endRow = sheet1.HeaderRows + sheet1.RowCount;
                    var rowStatus;
                    for(var i = startRow; i < endRow; i++ ) {
                        rowStatus = sheet1.RowStatus(i);
                        if(rowStatus != "D") {
                            chkSvcScpCd = sheet1.CellValue(i,"svc_scp_cd").replace(/ /g,"");
                            chkScNo = sheet1.CellValue(i,"sc_no");
                            chkESVCType = sheet1.CellValue(i,"prc_esvc_tp_cd_w") + sheet1.CellValue(i,"prc_esvc_tp_cd_e") + sheet1.CellValue(i,"prc_esvc_tp_cd_d");
                            chkCurrCd = sheet1.CellValue(i,"curr_cd").replace(/ /g,"");
                            chkChgCd = sheet1.CellValue(i,"chg_cd").replace(/ /g,"");
                            chkDcAmt = sheet1.CellValue(i,"dc_amt");
                            chkDcPer = sheet1.CellValue(i,"dc_per");
                            chkEffDt = sheet1.CellValue(i,"eff_dt");
                            chkExpDt = sheet1.CellValue(i,"exp_dt");
                            //msgs['PRI00335'] = '[{?msg1}]가(이) 입력되지 않았습니다.';
                            //msgs['PRI00337'] = '[{?msg1}]가(이) 선택되지 않았습니다.';
                            if(chkSvcScpCd == "") {
                                ComShowCodeMessage("PRI00337","Scope");
                                sheet1.SelectCell(i, "svc_scp_cd");
                                return false;
                            }
                            if(chkScNo == "") {
                                ComShowCodeMessage("PRI00335","RFA & S/C No");
                                sheet1.SelectCell(i, "sc_no");
                                return false;
                            }
                            if(chkESVCType == 0) {
                                ComShowCodeMessage("PRI00337","E-SVC Type");
                                sheet1.SelectCell(i, "prc_esvc_tp_cd_w");
                                return false;
                            }
                            if(chkChgCd == 0) {
                                ComShowCodeMessage("PRI00337","Charge");
                                sheet1.SelectCell(i, "chg_cd");
                                return false;
                            }
                            if(chkCurrCd == "") {
                                if(chkDcPer == 0 || chkDcPer == "" ) {
                                    ComShowCodeMessage("PRI00335","Percentage");
                                    sheet1.SelectCell(i, "dc_per", true);
                                    return false;
                                }
                            } else {
                                if(chkDcAmt == 0 || chkDcAmt == "") {
                                    ComShowCodeMessage("PRI00335","Amount");
                                    sheet1.SelectCell(i, "dc_amt", true);
                                    return false;
                                }
                            }
                            if(chkEffDt == "") {
                                ComShowCodeMessage("PRI00335","Effective Date");
                                sheet1.SelectCell(i, "eff_dt");
                                return false;
                            }
                            if(chkExpDt == "") {
                                ComShowCodeMessage("PRI00335","Expiration Date");
                                sheet1.SelectCell(i, "exp_dt");
                                return false;
                            }
                            if(chkEffDt >= chkExpDt) {
                                //msgs['PRI00321'] = '[{?msg1}]는 {?msg2}보다 큰 값이어야 합니다.';
                                //msgs['PRI00336'] = '[{?msg1}]는 {?msg2}보다 작은 값이어야 합니다.';
                                ComShowCodeMessage("PRI00321","Expiration Date","Effective Date");
                                sheet1.SelectCell(i, "exp_dt", true);
                                return false;
                            }
                        }
                    }
                    var dupRow = sheet1.ColValueDup("svc_scp_cd|org_rgn_cd|desc_rgn_cd|sc_no|chg_cd", false);
                    if(dupRow > 0) {
                        ComShowCodeMessage("PRI00302"); //중복된 자료가 존재합니다.
                        return false;
                    }
                } else {
                    ComShowCodeMessage("PRI00301"); //변경된 내역이 없습니다.
                    return false;
                }
                return true;
                break;
        }
    }