/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0015.js
 *@FileTitle : S/C Master Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.07
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.07.07 문동규
 * 1.0 Creation
 =========================================================
 * History 
 * 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends Pri
     * @class ESM_PRI_0015 : ESM_PRI_0015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0015 () {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.validateForm = validateForm;
    }

    /* 개발자 작업   */
    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    var trMode = "R";
    var prevDtIdx = -1;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br>
     * <b>Example :</b>
     *
     * <pre>
     * processButtonClick();
     * </pre>
     *
     * @return 없음
     * @author 문동규
     * @version 2009.08.25
     */
    function processButtonClick() {
        /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

        /** **************************************************** */
        var formObj = document.form;

        try {
            var srcObj = window.event.srcElement;
            var srcName = srcObj.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
                if (srcObj.disabled) {
                    return false;
                } else if (srcObj.style.filter != null && srcObj.style.filter != "") {
                    return false;
                }
            }

            switch (srcName) {

                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
                    break;

                case "btn_New":
                    doActionIBSheet(sheetObjects[0],formObj,IBCREATE);
                    break;

                case "btn_ctrt_cust":
                    //office code가 없는 경우 입력제한
                    if (formObj.prop_ofc_cd.value == "") {
                        ComShowCodeMessage('PRI01042', 'Request Office first');
                        resetCustomer();
                        formObj.prop_ofc_cd.focus();
                        return;
                    }

                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.cust_cnt_cd.value+"&cust_seq="+formObj.cust_seq.value, "", 640, 460, true);
                    if (rtnVal != null){
                        formObj.cust_cnt_cd.value = rtnVal.custCntCd;
                        formObj.cust_seq.value = rtnVal.custSeq;
                        formObj.ctrt_pty_nm.value = rtnVal.custNm;

                        custNameFind("cust_cnt_cd");
                        //sale rep
                        setCustSaleRep();
                        getComboObject(comboObjects, 'ctrt_cust_srep_cd').Code2 = sheetObjects[0].CellValue(1,"ctrt_cust_srep_cd");
                        com_change_sheet( sheetObjects[0], "cust_seq");
                    }

                    break;

                case "btn_prop_mqc_pop":
                    var sheetObj = sheetObjects[0];
                    var sSc_No = sheetObj.CellValue(1,"sc_no");
                    var sPropNo = sheetObj.CellValue(1,"prop_no");
                    var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                    var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");
                    var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");
                    var sSvcScpCd = "";
                    var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");

                    var sParam = "sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd+"&sSrepCd="+sSrepCd;
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0020.do?"+sParam, "", 650, 500, true);

                    if ( rtnVal != null && rtnVal.length > 0){
                        changeMQC(rtnVal);
                    }
                    break;

                case "btn_prop_pfmc_pop":
                    var sheetObj = sheetObjects[0];
                    var sPropNo = sheetObj.CellValue(1,"prop_no");
                    var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                    var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");
                    var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");
                    var sSvcScpCd = "";

                    var sParam = "sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd;
                    var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0019.do?"+sParam, "", 640, 335, true);
                    if (rtnVal != null){
                        sheetObj.CellValue2(Row, Col-1) = rtnVal[0];
                        sheetObj.CellValue2(Row, Col) = rtnVal[1];
                    }
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
                    break;


                case "btn_RowAdd":
                    doActionIBSheet(sheetObjects[1],formObj,IBINSERT);
                    break;

                case "btn_DeleteRow":
                    doActionIBSheet(sheetObjects[1],formObj,IBDELETE);
                    break;

                case "btn_Delete":
                    doActionIBSheet(sheetObjects[0],formObj,IBDELETE);
                    break;

                case "btns_calendar1": //달력버튼
                case "btns_calendar2":
                    var cal = new ComCalendarFromTo();

                    cal.select(formObj.ctrt_eff_dt, formObj.ctrt_exp_dt, 'yyyy-MM-dd');
                    break;

                case "btn_GoToProposal":
                    doActionIBSheet(sheetObjects[0],formObj,IBBATCH);
                    break;

            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.08.25
     */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBMultiCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(comboObj);
     * </pre>
     * @param {object} combo_obj 필수 IBMultiCombo Object
     * @return 없음
     * @author 문동규
     * @version 2009.08.25
     */
    function setComboObject(combo_obj){
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
     * @author 문동규
     * @version 2009.08.25
     */
    function loadPage() {
         //IBMultiCombo초기화
         for(var k = 0; k < comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }

         for (var i = 0; i < sheetObjects.length; i++) {
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        initIBComboItem();  // IBCombo에 Item setting
        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
    }

    /**
     * 사용하는 Event Listener 를 등록한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.08.25
     */
    function initControl() {
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
        axon_event.addListener('keyup', "ComKeyEnter('LengthNextFocus')", document.form);
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
    }

    /**
     * IBMultiCombo 에 Item을 setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.08.25
     */
    function initIBComboItem() {
        var formObj = document.form;
        ComPriTextCode2ComboItem(appOfcComboValue, appOfcComboText, getComboObject(comboObjects, 'prop_apro_ofc_cd') ,"|","\t" );
        ComPriTextCode2ComboItem(custTpComboValue, custTpComboText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd') ,"|","\t" );
        ComPriTextCode2ComboItem(lodUtComboValue, lodUtComboText, getComboObject(comboObjects, 'cntr_lod_ut_cd') ,"|","\t" );
    }

    /**
     * 업무 자바스크립트 OnKeyPress 이벤트를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.04
     */
    function obj_keypress() {

        switch (event.srcElement.dataformat) {
            case "engup":
                if (event.srcElement.name == "sc_no") {
                    ComKeyOnlyAlphabet('uppernum');
                } else {
                    ComKeyOnlyAlphabet('upper');
                }

                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            case "float":
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "ymd":
                ComKeyOnlyNumber(event.srcElement, "-");
                break;
            default:
        }
    }

    /**
     * 업무 자바스크립트 OnDeactivate 이벤트를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.04
     */
    function obj_deactivate() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var eleName = event.srcElement.name;

        switch(eleName){
            case "sc_no":
                com_change_sheet(sheetObj, eleName);
                break;

            case "cust_cnt_cd":
                //office code가 없는 경우 입력제한
                if (formObj.cust_cnt_cd.value != "" && formObj.prop_ofc_cd.value == "") {
                    ComShowCodeMessage('PRI01042', 'Request Office first');
                    resetCustomer();
                    formObj.prop_ofc_cd.focus();
                    return;
                }
                //cust name find
                if (sheetObj.CellValue(1, "cust_cnt_cd") != formObj.cust_cnt_cd.value){
                    custNameFind(eleName);
                    //sale rep
                    setCustSaleRep();
                    //COMBO를 채워 준 후 조회해온 코드를 채운다.
                    getComboObject(comboObjects, 'ctrt_cust_srep_cd').Code2 = sheetObj.CellValue(1,"ctrt_cust_srep_cd");
                }
                ComChkObjValid(event.srcElement);
                break;
            case "cust_seq":
                //office code가 없는 경우 입력제한
                if (formObj.cust_seq.value != "" && formObj.prop_ofc_cd.value == "") {
                    ComShowCodeMessage('PRI01042', 'Request Office first');
                    resetCustomer();
                    formObj.prop_ofc_cd.focus();
                    return;
                }

                var custSeq = formObj.cust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.cust_seq.value = ComLpad(custSeq, 6, "0");
                }
                //cust name find
                if (ComParseInt(sheetObj.CellValue(1, "cust_seq")) != ComParseInt(formObj.cust_seq.value)){

                    if (formObj.cust_seq.value !=""){
                        custNameFind(eleName);
                        //sale rep
                        setCustSaleRep();
                        getComboObject(comboObjects, 'ctrt_cust_srep_cd').Code2 = sheetObj.CellValue(1,"ctrt_cust_srep_cd");
                    }
                }
                break;

            case "ctrt_eff_dt":
                com_change_sheet(sheetObj, eleName);
                com_change_sheet(sheetObj, "ctrt_exp_dt");
                ComChkObjValid(event.srcElement);
                break;
            case "ctrt_exp_dt":
                com_change_sheet(sheetObj, "ctrt_eff_dt");
                com_change_sheet(sheetObj, eleName);
                ComChkObjValid(event.srcElement);
                break;
            case "prop_mqc_qty":
                com_change_sheet(sheetObj, eleName);
                ComChkObjValid(event.srcElement);
                break;
            case "prop_ofc_cd":
                if (sheetObj.CellValue(1,"prop_ofc_cd") != formObj.prop_ofc_cd.value){
                    // office code를 변경하면 Customer를 모두 reset 한다
                    resetCustomer();
                    
                    var cd = formObj.prop_ofc_cd.value;
                    formObj.f_cmd.value = COMMAND22;
                    var sParam = FormQueryString(formObj)+"&cd="+cd;
                    var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
                    var arrData = ComPriXml2Array(sXml, "cd|nm");
                    if (arrData != null && arrData.length > 0) {
                        checkRequestOffice();
                    }else{
                        formObj.prop_ofc_cd.value = "";
                        formObj.prop_srep_nm.value = "";
                        getComboObject(comboObjects, 'prop_srep_cd').RemoveAll();
                        formObj.prop_ofc_cd.focus();
                    }
                    com_change_sheet(sheetObj, "prop_ofc_cd");
                    com_change_sheet(sheetObj, "prop_srep_cd");
                }
                break;
            default:
                ComChkObjValid(event.srcElement);
        }
    }

    /**
     * 업무 자바스크립트 OnActivate 이벤트를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.09.04
     */
    function obj_activate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);
    }

    /**
     * OnKeyDown event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2010.03.17
     */
    function obj_keydown(){
        //enter key조회
        var eleName = event.srcElement.name;
        if (eleName == "sc_no"){
            if (event.keyCode == 13){
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            }
        }
    }

    /**
     * Customer 정보를 모두 Reset 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     resetCustomer()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2010.03.18
     */
    function resetCustomer() {
        var sheetObj = sheetObjects[0];
        var formObj = document.form;
        getComboObject(comboObjects, 'ctrt_cust_srep_cd').RemoveAll();
        getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').Code = "";
        sheetObj.CellValue2(1,"cust_cnt_cd")          = "";
        sheetObj.CellValue2(1,"cust_seq")             = "";
        sheetObj.CellValue2(1,"prc_ctrt_cust_tp_cd")  = "";
        sheetObj.CellValue2(1,"ctrt_pty_nm")          = "";
        sheetObj.CellValue2(1,"ctrt_pty_addr")        = "";
        sheetObj.CellValue2(1,"ctrt_cust_val_sgm_cd") = "";
        sheetObj.CellValue2(1,"ctrt_cust_val_sgm")    = "";
        sheetObj.CellValue2(1,"ctrt_cust_srep_cd")    = "";
        sheetObj.CellValue2(1,"ctrt_cust_sls_ofc_cd") = "";
        sheetObj.CellValue2(1,"ctrt_pty_sgn_nm")      = "";
        sheetObj.CellValue2(1,"ctrt_pty_sgn_tit_nm")  = "";
        formObj.cust_cnt_cd.value          = "";
        formObj.cust_seq.value             = "";
        formObj.ctrt_pty_nm.value          = "";
        formObj.ctrt_cust_val_sgm.value    = "";
        formObj.ctrt_cust_sls_ofc_cd.value = "";
        formObj.ctrt_cust_srep_nm.value    = "";
    }
    
    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 문동규
     * @version 2009.09.09
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch (sAction) {
            case IBSEARCH: // 조회
                ComOpenWait(true);
                sheetObj = sheetObjects[0];
                if (validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value = SEARCH01;
                    if(formObj.sc_no.value!="")
                        formObj.prop_no.value = "";
                    var sXml = sheetObj.GetSearchXml("ESM_PRI_0015GS.do" , FormQueryString(formObj));
                    var arrXml = sXml.split("|$$|");
                    if (arrXml.length > 0) {
                        sheetObjects[0].LoadSearchXml(arrXml[0]);    // sheet1. hidden sheet - main 데이터
                    }
                    //sale rep
                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
                    if (arrXml.length > 1) {
                        sheetObjects[1].LoadSearchXml(arrXml[1]);
                    }

                } else {
                    ComShowCodeMessage('PRI08001');
                }

                buttonControl();
                calcMVC();
                firstFocus();
                ComOpenWait(false);
                break;

            case IBCREATE: // New
                ComOpenWait(true);
                if (!validateForm(sheetObjects[0],formObj,sAction)) {
                    return false;
                }
                ComBtnEnable("btn_Save");
                clearAllForms();
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();

                sheetObjects[0].DataInsert();
                var sheetObj = sheetObjects[0];
                sheetObj.CellValue2(1,"prop_sts_cd")= "I";
                sheetObj.CellValue2(1,"prc_prog_sts_cd")= "I";
                sheetObj.CellValue2(1,"src_info_cd")= "NW";
                sheetObj.CellValue2(1,"rf_flg")= "N";
                sheetObj.CellValue2(1,"gamt_flg")= "N";
                sheetObj.CellValue2(1,"prc_ctrt_pty_tp_cd") = "C";
                sheetObj.CellValue2(1,"prop_ofc_cd")= "";

                sheetObj.CellValue2(1,"cntr_lod_ut_cd")= "F";
                sheet1_OnSearchEnd(sheetObj);

                setRequestOfficeSaleRep();
                sheetObj.CellValue2(1,"amdt_seq")= "0";
                formObj.amdt_seq.value = "0";
                formObj.cntr_lod_ut_cd.Text = "F";

                sheetObj.CellValue2(1,"prc_prop_cre_tp_cd")= "M";
                sheetObj.CellValue2(1,"prc_mst_prop_tp_cd")= "M";
                sheetObj.CellValue2(1,"prop_prpr_flg")= "N";
                formObj.prc_mst_prop_tp_nm.value = "Master";
                formObj.prop_sts.value = "";
                buttonControl();
                firstFocus();
                ComOpenWait(false);
                break;

            case IBSAVE: // Save
                ComOpenWait(true);
                var sheetObj = sheetObjects[1];
                var insertFlag = "false";// amend flag를 update 하기 위해사용한다.

                // Scope Hidden Cell 셋팅
                for (var i = sheetObj.HeaderRows , n = sheetObj.HeaderRows + sheetObj.RowCount ; i < n ; i++) {
                    sheetObj.CellValue2(i, "prop_scp_ofc_cd") = formObj.prop_ofc_cd.value;
                    sheetObj.CellValue2(i, "prop_scp_srep_cd") = getComboObject(comboObjects, 'prop_srep_cd').Code;
                    sheetObj.CellValue2(i, "prop_scp_apro_ofc_cd") = getComboObject(comboObjects, 'prop_apro_ofc_cd').Code;
                    if (formObj.amdt_seq.value == "0"){
                        sheetObj.CellValue2(i, "eff_dt") = formObj.ctrt_eff_dt.value;
                    }else{
                        sheetObj.CellValue2(i, "eff_dt") = sheetObjects[0].CellValue(1,"eff_dt");
                    }
                    sheetObj.CellValue2(i, "exp_dt") = formObj.ctrt_exp_dt.value;
                    sheetObj.CellValue2(i, "pre_exp_dt") = sheetObjects[0].CellValue(1, "pre_exp_dt");
                    sheetObj.CellValue2(i, "cntr_lod_ut_cd") = getComboObject(comboObjects, "cntr_lod_ut_cd").Code;
                }

                if (!validateForm(sheetObjects[0],formObj,sAction)) {
                    return false;
                }
                if (!ComPriConfirmSave()) {
                    return false;
                }

                //duration change
                if (!saveChangeDuration("false")){
                    return false;
                }

                // proposal 여부를 포함하여 parameter 에 보내준다. main 관련 이외의 것들은
                // proposal 이 아닌 경우는 건너뜀
                var mstAmdtSeq = formObj.amdt_seq.value;

                formObj.f_cmd.value = MULTI01;
                var sParam = FormQueryString(formObj)+"&mstAmdtSeq="+mstAmdtSeq;

                var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                if (sheetObjects[0].RowStatus(1)=="I"){
                    insertFlag = "true";
                }

                if (sParamSheet1 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                } else {
                    return;
                }
                var sParamSheet2 = sheetObjects[1].GetSaveString();

                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                } else {
                    return;
                }
                var sXml = sheetObj.GetSaveXml("ESM_PRI_0015GS.do", sParam);

                sheetObjects[0].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);
                sheetObjects[1].LoadSaveXml(sXml);
                ComOpenWait(false);
                break;

            case IBSEARCH_ASYNC02: // Sale Rep 설정
                setRequestOfficeSaleRep();
                setCustSaleRep();
                getComboObject(comboObjects, 'ctrt_cust_srep_cd').Code2 = sheetObj.CellValue(1,"ctrt_cust_srep_cd");
                break;

            case IBINSERT: // Row Add
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("ctrt_eff_dt"), dtData, 100, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, true, true);
                    sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("ctrt_exp_dt"), dtData, 100, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, true, true);
                }else{
                    sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("ctrt_eff_dt"), dtData, 100, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, false, false);
                    sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("ctrt_exp_dt"), dtData, 100, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, false, false);
                }
                var idx = sheetObj.DataInsert();
                sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
                sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;

                sheetObj.CellValue2(idx, "prop_scp_ofc_cd") = formObj.prop_ofc_cd.value;
                sheetObj.CellValue2(idx, "prop_scp_srep_cd") = getComboObject(comboObjects, 'prop_srep_cd').Code;

                sheetObj.CellValue2(idx, "prop_scp_apro_ofc_cd") = getComboObject(comboObjects, 'prop_apro_ofc_cd').Code;
                sheetObj.CellValue2(idx, "prop_scp_mqc_qty") = "0";

                if (formObj.amdt_seq.value == "0"){
                    sheetObj.CellValue2(idx, "ctrt_eff_dt") = formObj.ctrt_eff_dt.value;
                }else{
                    sheetObj.CellValue2(idx, "ctrt_eff_dt") = sheetObjects[0].CellValue(1,"eff_dt");
                }
                sheetObj.CellValue2(idx, "ctrt_exp_dt") = formObj.ctrt_exp_dt.value;
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.CellValue2(idx, "eff_dt") = formObj.ctrt_eff_dt.value;
                }else{
                    sheetObj.CellValue2(idx, "eff_dt") = sheetObjects[0].CellValue(1,"eff_dt");
                }
                sheetObj.CellValue2(idx, "exp_dt") = formObj.ctrt_exp_dt.value;

                sheetObj.CellValue2(idx, "pre_exp_dt") = sheetObjects[0].CellValue(1, "pre_exp_dt");
                sheetObj.CellValue2(idx, "prop_scp_sts_cd") = "I";
                sheetObj.CellValue2(idx, "prc_prop_cre_tp_cd") = "M";
//                sheetObj.CellValue2(idx, "note_hdr_seq") = "000";//확인
                sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
                sheetObj.CellValue2(idx, "src_info_cd") = "NW";
                sheetObj.CellValue2(idx, "cntr_lod_ut_cd") = getComboObject(comboObjects, "cntr_lod_ut_cd").Code;

//                sheetObj.CellValue2(idx, "n1st_cmnc_dt") = formObj.ctrt_eff_dt.value;
                sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = 0;

                if(formObj.amdt_seq.value!=0){
                    sheetObj.CellFont("FontColor", idx, "chk", idx, "prop_scp_sts_cd")= sheetObj.RgbColor(255,0,0);
                }

                var preIbflag = sheetObjects[0].RowStatus(1);

                if (preIbflag == "R"){
                    sheetObjects[0].RowStatus(1) = "U";
                }

                sheetObj.SelectCell(idx, "svc_scp_cd", false);

                break;

            case IBDELETE: // Delete
                if (validateForm(sheetObj,formObj,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value = MULTI02;
                        if (!ComPriConfirmDeleteAll()) {
                            return false;
                        }
                        sheetObj.CellValue2(1,"prop_sts_cd") = "D";

                        var sParam = FormQueryString(formObj);
                        var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                        if (sParamSheet1 != "") {
                            sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                        }
                        var sParamSheet2 = sheetObjects[1].GetSaveString(true);//scope의 모든 데이터를 넘긴다.
                        if (sParamSheet2 != "") {
                            sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                        }
                        var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_0015GS.do", sParam);
                        sheetObjects[0].LoadSaveXml(sXml);
                    } else if (sheetObj.id == "sheet2") {
                        deleteRowCheck(sheetObj, "chk");
                    }
                }
                break;

            case IBBATCH: // Go To Proposal
                ComOpenWait(true);
                if (!ComShowCodeConfirm('PRI01082')) {
                    return;
                }
                formObj.f_cmd.value = MULTI03;
                sheetObj.CellValue2(1,"prc_mst_prop_tp_cd")= "P";
                sheetObj.CellValue2(1,"prop_prpr_flg")= "Y";

                formObj.is_goto_prop.value = "Y";
                sheetObj.DoAllSave("ESM_PRI_0015GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;

        }
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.09.09
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {

        case "sheet1":  // hidden
            with (sheetObj) {
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                var HeadTitle  = "|sc_no|prop_no|amdt_seq|pre_amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|n1st_cmnc_amdt_seq|prc_prog_sts_cd|src_info_cd|pre_exp_dt|rf_flg|gamt_flg|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt";
                HeadTitle += "|cre_dt|file_dt|cust_cnt_cd|cust_seq|ctrt_pty_nm|prc_ctrt_pty_tp_cd|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_sls_ofc_cd";
                HeadTitle += "|ctrt_cust_srep_cd|ctrt_cust_srep_nm|real_cust_cnt_cd|real_cust_seq|real_cust_nm|real_cust_tp_cd|real_cust_val_sgm_cd|real_cust_val_sgm";
                HeadTitle += "|real_cust_sls_ofc_cd|real_cust_srep_cd|real_cust_srep_nm|prop_mqc_qty|cntr_lod_ut_cd|unit|sls_ld_no|blpl_hdr_seq";
                HeadTitle += "|request user flag|approval user flag|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm|ctrt_eff_dt_ori|ctrt_exp_dt_ori|prc_mst_prop_tp_cd|prc_prop_cre_tp_cd|prop_prpr_flg";
                var headCount = ComCountHeadTitle(HeadTitle);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)


                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]

                InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "sc_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pre_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "src_info_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pre_exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "gamt_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_ofc_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_ofc_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cre_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "file_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cust_cnt_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cust_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_pty_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_cust_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_val_sgm_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_val_sgm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_sls_ofc_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_srep_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_srep_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_cnt_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_val_sgm_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_val_sgm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_sls_ofc_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_srep_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_srep_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_mqc_qty", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cntr_lod_ut_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "unit", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "sls_ld_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "blpl_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "req_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "apro_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_addr", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_sgn_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_sgn_tit_nm", false, "", dfNone, 0, false, false);

                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt_ori", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt_ori", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "prc_mst_prop_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_prop_cre_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prop_prpr_flg", false, "", dfNone, 0, false, false);
                WaitImageVisible = false;
            }
            break;

        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 340;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);

                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                var HeadTitle =  "|Sel.|Seq.|Prop No|Amendment Seq|SVC Scope|Approval Office|Request Office|MQC|Sales Rep|eff_dt";
                    HeadTitle += "|exp_dt|n1st_cmnc_amdt_seq|pre_exp_dt|Creation Type Code|Status Code|Status|cntr_lod_ut_cd";
                    HeadTitle += "|req_usr_flg|apro_usr_flg|prc_prog_sts_cd|src_info_cd|submqcori|PRE_EXT_SCP|Effective Date|Expiry Date|";
                var headCount = ComCountHeadTitle(HeadTitle);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck, 50, daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 60, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtComboEdit, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, true, 3);
                InitDataProperty(0, cnt++, dtHidden, 120, daCenter, false, "prop_scp_apro_ofc_cd", true, "", dfNone, 0, true, true, 6);
                InitDataProperty(0, cnt++, dtHidden, 120, daCenter, false, "prop_scp_ofc_cd", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 150, daRight, false, "prop_scp_mqc_qty", false, "", dfInteger, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_scp_srep_cd", true, "", dfNone, 0, true, true);

                InitDataProperty(0, cnt++, dtHidden, 95, daCenter, false, "eff_dt", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 95, daCenter, false, "exp_dt", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 95, daCenter, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 95, daCenter, false, "pre_exp_dt", false, "", dfDateYmd, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "prc_prop_cre_tp_cd", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 80, daCenter, false, "prop_scp_sts_cd", false, "", dfNone, 0, false, false, 100);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "prop_scp_sts", false, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "cntr_lod_ut_cd", false, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "req_usr_flg", false, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "apro_usr_flg", false, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "src_info_cd", false, "", dfNone, 0, true, true, 100);

                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "prop_scp_mqc_qty_ori", false, "", dfInteger, 0, true, true);
                //PRE_EXT_SCP
                InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "pre_ext_scp", false, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "", false, "", dfNone, 0, false, false);

                InitDataValid(0, "svc_scp_cd", vtEngUpOnly);
                InitDataCombo(0, "svc_scp_cd", svcScpComboText, svcScpComboValue);
                WaitImageVisible = false;
            }
            break;

        case "sheet3":     // Hidden sheet for Transaction
            with (sheetObj) {
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);

                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);

                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(1, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                var HeadTitle = "status";

                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                WaitImageVisible = false;
                Visible = false;
            }
            break;

        }
    }


    /**
     * combo 초기설정값 <br>
     * combo가 다수일 경우 combo 수만큼 case를 추가하여 combo 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 문동규
     * @version 2009.09.09
     */
    function initCombo(comboObj, comboNo) {
        switch(comboObj.id) {
            case "prop_srep_cd":
                with(comboObj) {
                    ValidChar(2,1);
                    DropHeight = 190;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;

            case "prop_apro_ofc_cd":
                with(comboObj) {
                    ValidChar(2,0);
                    DropHeight = 190;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;

            case "prc_ctrt_cust_tp_cd":
                with(comboObj) {
                    ValidChar(2,0);
                    DropHeight = 190;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;

            case "ctrt_cust_srep_cd":
                with(comboObj) {
                    ValidChar(2,0);
                    DropHeight = 190;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;

            case "cntr_lod_ut_cd":
                with(comboObj) {
                    ValidChar(2,0);
                    DropHeight = 190;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;

        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 문동규
     * @version 2009.09.09
     */
    function validateForm(sheetObj, formObj, sAction) {

        var sc_no = formObj.sc_no.value;
        var prop_no = formObj.prop_no.value;
        var amdt_seq = formObj.amdt_seq.value;

        switch (sAction) {
            case IBSEARCH: // 조회

                if (sc_no == null && prop_no == null) {
                    return false;
                }
                return true;
                break;

            case IBCREATE: // New
                if(sheetObjects[0].IsDataModified||sheetObjects[1].IsDataModified){
                    return ComPriClearChange;
                }
                return true;
                break;

            case IBSAVE: // Save
                if(!ComChkRequired(document.form)){
                    return false;
                }

                // Scope check
                var scpCnt = sheetObjects[1].RowCount;
                if (scpCnt == 0) {
                    ComShowCodeMessage('PRI00316', 'Service Scope');
                    return;
                }

                // S/C No validation
                if (sheetObjects[0].RowStatus(1) == "I") {
                    var re = new RegExp();
                    var scNo = formObj.sc_no.value;
                    re.compile("^([A-Z]{3}[0-9]{6})$");
                    if (!re.test(scNo)) {
                        ComShowCodeMessage('PRI01084');
                        formObj.sc_no.focus();
                        return;
                    }

                    if (!scNo.substring(0,3) == "GLO") {    // GLO 예외처리
                        formObj.f_cmd.value = SEARCH03;

                        var svcScpCds = "";
                        for (var i = 1 ; i <= scpCnt ; i++) {
                            if (i != 1) {
                                svcScpCds += ";"
                            }
                            svcScpCds += sheetObjects[1].CellValue(i, "svc_scp_cd");
                        }
                        // sc_no prefix check
                        sheetObjects[2].doSearch("ESM_PRI_0015GS.do", FormQueryString(formObj)+"&svc_scp_cds="+svcScpCds);
                        if (sheetObjects[2].EtcData("prefix") == "") {
                            ComShowCodeMessage('PRI01085');
                            formObj.sc_no.focus();
                            return;
                        }
                    }
                }

                if (getComboObject(comboObjects, "prop_srep_cd").Code == "") {
                    ComShowCodeMessage('PRI00316','Sales Rep.');
                    getComboObject(comboObjects, "prop_srep_cd").focus();
                    return false;
                }
                if (getComboObject(comboObjects, "prop_apro_ofc_cd").Code == "") {
                    ComShowCodeMessage('PRI00316','Approval Office');
                    getComboObject(comboObjects, "prop_apro_ofc_cd").focus();
                    return false;
                }
                if (getComboObject(comboObjects, "prc_ctrt_cust_tp_cd").Code == "") {
                    ComShowCodeMessage('PRI00316','Customer Type');
                    getComboObject(comboObjects, "prc_ctrt_cust_tp_cd").focus();
                    return false;
                }
                if (getComboObject(comboObjects, "ctrt_cust_srep_cd").Code == "") {
                    ComShowCodeMessage('PRI00316','Contract Cust Sales Rep.');
                    getComboObject(comboObjects, "ctrt_cust_srep_cd").focus();
                    return false;
                }
                if (getComboObject(comboObjects, "cntr_lod_ut_cd").Code == "") {
                    ComShowCodeMessage('PRI00316','Container Load Unit Code');
                    getComboObject(comboObjects, "cntr_lod_ut_cd").focus();
                    return false;
                }

                if (formObj.ctrt_eff_dt.value >= formObj.ctrt_exp_dt.value){
                    ComShowCodeMessage('PRI01024');
                    formObj.ctrt_eff_dt.focus();
                    return false;
                }

                var rowCnt = getValidRowCount(sheetObjects[1]);

                if (rowCnt <= 0){
                    ComShowCodeMessage('PRI01029');
                    return false;
                }


                if(!sheetObjects[0].IsDataModified &&!sheetObjects[1].IsDataModified){
                    ComShowCodeMessage('PRI00301');
                    return false;
                }

                var rowM = sheetObjects[1].ColValueDup("svc_scp_cd");
                if (rowM >= 0) {
                    ComShowCodeMessage("PRI00303", "Sheet", rowM);
                    return false;
                }

                //MQC chk
                var mainMqc = sheetObjects[0].CellValue(1, "prop_mqc_qty");

                var subMqc = 0;
                var sheetObj = sheetObjects[1];
                for (var i = 1; i <= sheetObj.RowCount; i++){
                    subMqc += ComParseInt(sheetObj.CellValue(i, "prop_scp_mqc_qty_ori"));
                    if (sheetObj.CellValue(i,"prop_scp_mqc_qty") != sheetObj.CellValue(i,"prop_scp_mqc_qty_ori") ){
                        subMqc += ComParseInt(sheetObj.CellValue(i, "prop_scp_mqc_qty")) - ComParseInt(sheetObj.CellValue(i, "prop_scp_mqc_qty_ori"));
                    }
                }
                if ((subMqc - mainMqc) > 0){
                     ComShowCodeMessage("PRI01008");
                     return false;
                }

                return true;
                break;

        }
        return true;
    }

    /**
     * form 의 입력필드를 모두 초기화시킨다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllForms();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.07.30
     */
    function clearAllForms(){

        var formObj = document.form;

        formObj.sc_no.value="";
        formObj.amdt_seq.value="";
        formObj.prop_no.value="";
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";
        getComboObject(comboObjects, 'prop_srep_cd').Index = -1;
        formObj.prop_srep_nm.value="";
        getComboObject(comboObjects, 'prop_apro_ofc_cd').Index = -1;
        formObj.cust_cnt_cd.value="";
        formObj.cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').Index = -1;
        formObj.ctrt_cust_val_sgm.value="";
        formObj.ctrt_cust_sls_ofc_cd.value="";
        getComboObject(comboObjects, 'ctrt_cust_srep_cd').Index = -1;
        getComboObject(comboObjects, 'cntr_lod_ut_cd').Index = -1;
        formObj.ctrt_cust_srep_nm.value="";
        formObj.real_cust_cnt_cd.value="";
        formObj.real_cust_nm.value="";
        formObj.real_cust_seq.value="";
        formObj.real_cust_tp_cd.value = "";
        formObj.real_cust_val_sgm.value="";
        formObj.real_cust_sls_ofc_cd.value="";
        formObj.real_cust_srep_cd.value = "";
        formObj.real_cust_srep_nm.value="";
        formObj.prop_mqc_qty.value="";
        formObj.prop_mvc.value="";
    }

    /**
     * Button, form의 enable/disable을 설정한다.<br>
     * Master에서 생성된 데이터가 아니면 CUD관련 컨트롤은 모두 disable 시킨다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     buttonControl();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.07.30
     */
    function buttonControl(){

        var formObj = document.form;
        var sts = sheetObjects[0].CellValue(1, "prop_sts_cd");

        var amdt_seq = sheetObjects[0].CellValue(1, "amdt_seq");
        var sheetObj = sheetObjects[1];

        try{

            if (sheetObjects[0].CellValue(1, "prc_mst_prop_tp_cd") == "M") {

                if (sheetObjects[0].CellValue(1, "sc_no") == "") {
                    ComBtnDisable("btn_Delete");
                    ComBtnDisable("btn_GoToProposal");
                } else {
                    ComBtnEnable("btn_Delete");
                    ComBtnEnable("btn_GoToProposal");
                }

                ComBtnEnable("btn_Save");
                ComBtnEnable("btn_RowAdd");
                ComBtnEnable("btn_DeleteRow");

                formObj.prop_srep_cd.enable = true;
                formObj.prop_apro_ofc_cd.enable = true;
                formObj.prc_ctrt_cust_tp_cd.enable = true;
                formObj.ctrt_cust_srep_cd.enable = true;
                formObj.cntr_lod_ut_cd.enable = true;

                formObj.prop_mqc_qty.readOnly = false;
                formObj.ctrt_eff_dt.readOnly = false;
                formObj.ctrt_exp_dt.readOnly = false;
                formObj.prop_ofc_cd.readOnly = false;
                formObj.cust_cnt_cd.readOnly = false;
                formObj.cust_seq.readOnly = false;

                formObj.prop_mqc_qty.className = "input1";
                formObj.ctrt_eff_dt.className = "input1";
                formObj.ctrt_exp_dt.className = "input1";
                formObj.prop_ofc_cd.className = "input1";
                formObj.cust_cnt_cd.className = "input1";
                formObj.cust_seq.className = "input1";

                formObj.prop_sts.style.display = "none";
                sheetObjects[1].Editable = true;

                btnImgEnable(document.getElementsByName("btn_ctrt_cust")[0], true);
                btnImgEnable(document.getElementsByName("btns_calendar1")[0], true);
                btnImgEnable(document.getElementsByName("btns_calendar2")[0], true);
            } else {
                ComBtnDisable("btn_Save");
                ComBtnDisable("btn_RowAdd");
                ComBtnDisable("btn_DeleteRow");
                ComBtnDisable("btn_Delete");
                ComBtnDisable("btn_GoToProposal");

                formObj.prop_srep_cd.enable = false;
                formObj.prop_apro_ofc_cd.enable = false;
                formObj.prc_ctrt_cust_tp_cd.enable = false;
                formObj.ctrt_cust_srep_cd.enable = false;
                formObj.cntr_lod_ut_cd.enable = false;

                formObj.prop_mqc_qty.readOnly = true;
                formObj.ctrt_eff_dt.readOnly = true;
                formObj.ctrt_exp_dt.readOnly = true;
                formObj.prop_ofc_cd.readOnly = true;
                formObj.cust_cnt_cd.readOnly = true;
                formObj.cust_seq.readOnly = true;

                formObj.prop_mqc_qty.className = "input2";
                formObj.ctrt_eff_dt.className = "input2";
                formObj.ctrt_exp_dt.className = "input2";
                formObj.prop_ofc_cd.className = "input2";
                formObj.cust_cnt_cd.className = "input2";
                formObj.cust_seq.className = "input2";

                formObj.prop_sts.style.display = "inline";
                sheetObjects[1].Editable = false;

                btnImgEnable(document.getElementsByName("btn_ctrt_cust")[0], false);
                btnImgEnable(document.getElementsByName("btns_calendar1")[0], false);
                btnImgEnable(document.getElementsByName("btns_calendar2")[0], false);
            }
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

/////////////////////////////////////////////////////////////////////////
/////////////////////// ONCHANGE (S)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////

//  combo 관련  (S)   -----

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * prop_apro_ofc_cd 콤보에서 값을 변경하면 Sheet의 해당 Column값을 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function prop_apro_ofc_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        com_change_sheet(sheetObj, "prop_apro_ofc_cd");

        var sheetObj2 = sheetObjects[1];
        if (sheetObj2.RowCount > 0) {
            for (var i = 1, n = sheetObj2.RowCount ; i <= n ; i++) {
                sheetObj2.CellValue2(i, "prop_scp_apro_ofc_cd") = getComboObject(comboObjects, 'prop_apro_ofc_cd').Code;
            }
        }
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * prop_srep_cd 콤보에서 값을 변경하면 Sheet의 해당 Column값을 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function prop_srep_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
        formObj.prop_srep_nm.value = arrText[1];
        com_change_sheet( sheetObj, "prop_srep_cd" );

        var sheetObj2 = sheetObjects[1];
        if (sheetObj2.RowCount > 0) {
            for (var i = 1, n = sheetObj2.RowCount ; i <= n ; i++) {
                sheetObj2.CellValue2(i, "prop_scp_srep_cd") = getComboObject(comboObjects, 'prop_srep_cd').Code;
            }
        }
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * ctrt_cust_srep_cd 콤보에서 값을 변경하면 다음 로직을 수행한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function ctrt_cust_srep_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
        if (arrText[1] != null && arrText[1] != undefined){
            formObj.ctrt_cust_srep_nm.value = arrText[1];
        }

        if (code != ""){
            formObj.ctrt_cust_sls_ofc_cd.value = getOfficeCd(code);
        }

        com_change_sheet( sheetObj, "ctrt_cust_srep_cd" )
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * real_cust_srep_cd 콤보에서 값을 변경하면 다음 로직을 수행한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function real_cust_srep_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
        if (arrText[1] != null && arrText[1] != undefined){
            formObj.real_cust_srep_nm.value = arrText[1];
        }
        if (code != ""){
            formObj.real_cust_sls_ofc_cd.value = getOfficeCd(code);
        }
        com_change_sheet( sheetObj, "real_cust_srep_cd" )
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * prc_ctrt_cust_tp_cd 콤보에서 값을 변경하면 Hidden Sheet 의 해당하는 값을 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function prc_ctrt_cust_tp_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        com_change_sheet( sheetObj, "prc_ctrt_cust_tp_cd" )
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * real_cust_tp_cd 콤보에서 값을 변경하면 Hidden Sheet 의 해당하는 값을 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function real_cust_tp_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        com_change_sheet( sheetObj, "real_cust_tp_cd" )
    }

    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * cntr_lod_ut_cd 콤보에서 값을 변경하면 다음 로직을 수행한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function cntr_lod_ut_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        com_change_sheet(sheetObj, "cntr_lod_ut_cd");

        var sheetObj2 = sheetObjects[1];
        if (sheetObj2.RowCount > 0) {
            for (var i = 1, n = sheetObj2.RowCount ; i <= n ; i++) {
                sheetObj2.CellValue2(i, "cntr_lod_ut_cd") = getComboObject(comboObjects, 'cntr_lod_ut_cd').Code;
            }
        }
    }

//    combo 관련  (E)   -----
//    form  관련  (S)   -----

    /**
     * form field 의 값을 변경할때 그에 해당하는 Hidden Sheet의 값도 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     com_change_sheet(sheetObj, "svc_scp_cd");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} colNm 필수 값을 변경한 form field 의 name
     * @returns 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function com_change_sheet(sheetObj, colNm){

        var eleValue = "";

        if(document.getElementById(colNm).type=="text"){
            switch(event.srcElement.name){
                case "ctrt_eff_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "ctrt_exp_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "cre_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "file_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
//                case "n1st_cmnc_dt":
//                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
//                    break;
                case "cust_seq":
                    eleValue = ComParseInt(document.getElementById(colNm).value);
                    break;
                case "real_cust_seq":
                    eleValue = ComParseInt(document.getElementById(colNm).value);
                    break;
                default:
                    eleValue = document.getElementById(colNm).value;
                    break;
            }
            sheetObj.CellValue(1,colNm) = eleValue;
        }else{
            sheetObj.CellValue(1,colNm) = document.getElementById(colNm).Code;
        }
    }

//    form  관련   (E)   -----

//    sheet  관련   (S)   -----


    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * effectve date/expired date 변경할 경우 다음 로직을 수행한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnChange 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnChange 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.06.10
     */
    function sheet1_OnChange(sheetObj, Row, Col)
    {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;

        switch(colName)
        {
            case "ctrt_eff_dt":
                if (sheetObj.CellValue(Row,"amdt_seq") == "0"){
                    sheetObj.CellValue2(Row, "eff_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
//                    sheetObj.CellValue2(Row, "n1st_cmnc_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                }
                break;

            case "ctrt_exp_dt":
                if (sheetObj.CellValue(Row,"amdt_seq") == "0"){
                    sheetObj.CellValue2(Row, "exp_dt") = sheetObj.CellValue(Row, "ctrt_exp_dt");
                }
                break;
        }
    }

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * effectve date/expired date 변경할 경우 다음 로직을 수행한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnChange 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnChange 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.06.10
     */
    function sheet2_OnChange(sheetObj, Row, Col)
    {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;

        switch(colName)
        {
            case "ctrt_eff_dt":

                var mnEffDt = ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd","-");
                if (mnEffDt == ""){
                    ComShowCodeMessage("PRI01030");
                    sheetObj.CellValue2(Row,"ctrt_eff_dt") ="";
                    sheetObj.SelectCell(Row,"ctrt_eff_dt");
                    return;
                }
                if (mnEffDt > sheetObj.CellValue(Row,"ctrt_eff_dt")){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.CellValue2(Row,"ctrt_eff_dt") ="";
                    sheetObj.SelectCell(Row,"ctrt_eff_dt");
                }else{
                    sheetObj.CellValue2(Row, "eff_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                    //Proposal 일 경우 적용
//                    sheetObj.CellValue2(Row, "n1st_cmnc_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                }

                break;

            case "ctrt_exp_dt":
                var mnExpDt = ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd","-");
                if (mnExpDt == ""){
                    ComShowCodeMessage("PRI01030");
                    sheetObj.CellValue2(Row,"ctrt_exp_dt") ="";
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");
                    return;
                }
                if (mnExpDt < sheetObj.CellValue(Row,"ctrt_exp_dt")){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.CellValue2(Row,"ctrt_exp_dt") ="";
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");
                    return;
                }

                if (sheetObj.CellValue(Row, "ctrt_eff_dt") > sheetObj.CellValue(Row, "ctrt_exp_dt") ){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.CellValue2(Row,"ctrt_exp_dt") = "";
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");
                    return;
                }
                sheetObj.CellValue2(Row, "exp_dt") = sheetObj.CellValue(Row, "ctrt_exp_dt");
                break;
            case "prop_scp_ofc_cd":

                var cd = sheetObj.CellValue(Row,"prop_scp_ofc_cd");
                formObj.f_cmd.value = COMMAND22;
                var sParam = FormQueryString(formObj)+"&cd="+cd;
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
                var arrData = ComPriXml2Array(sXml, "cd|nm");
                if (arrData != null && arrData.length > 0) {
                    //sales Rep
                    setSheetRequestOfficeSaleRep(sheetObj, Row, cd);

                }else{
                    sheetObj.CellValue2(Row,"prop_scp_ofc_cd") = "";
                }

                break;

        }
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * IBSheet로 조회한 데이터를 form 에 보여준다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.09.10
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
        var formObj = document.form;
        if (sheetObj.RowCount == 0) {
            doActionIBSheet(sheetObj,formObj,IBCREATE);
            return;
        }
        // 없는 aproval office가 조회 될경우 approval office가 추가 되기때문에 재 조회시 다시 load 해준다.
        getComboObject(comboObjects, 'prop_apro_ofc_cd').RemoveAll();
        ComPriTextCode2ComboItem(appOfcComboValue, appOfcComboText, getComboObject(comboObjects, 'prop_apro_ofc_cd') ,"|","\t" );
        
        formObj.sc_no.value = sheetObj.CellValue(1,"sc_no");
        formObj.prop_no.value = sheetObj.CellValue(1,"prop_no");
        formObj.amdt_seq.value = sheetObj.CellValue(1,"amdt_seq");
        formObj.ctrt_eff_dt.value = sheetObj.CellValue(1,"ctrt_eff_dt");
        formObj.ctrt_exp_dt.value = sheetObj.CellValue(1,"ctrt_exp_dt");
        formObj.ctrt_eff_dt.focus();
        formObj.ctrt_exp_dt.focus();

        formObj.prop_sts.value = sheetObj.CellValue(1,"prop_sts");
        formObj.prop_ofc_cd.value = sheetObj.CellValue(1,"prop_ofc_cd");
        formObj.prop_srep_nm.value = sheetObj.CellValue(1,"prop_srep_nm");
        formObj.cust_cnt_cd.value = sheetObj.CellValue(1,"cust_cnt_cd");
        if (sheetObj.CellValue(1, "cust_seq") !="" ){
            formObj.cust_seq.value = ComLpad(sheetObj.CellValue(1,"cust_seq"), 6, "0");
        }else{
            formObj.cust_seq.value = "";
        }

        getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').Code2 = sheetObj.CellValue(1,"prc_ctrt_cust_tp_cd");

        formObj.ctrt_pty_nm.value = sheetObj.CellValue(1,"ctrt_pty_nm");
        formObj.ctrt_cust_val_sgm.value = sheetObj.CellValue(1,"ctrt_cust_val_sgm");
        formObj.ctrt_cust_sls_ofc_cd.value = sheetObj.CellValue(1,"ctrt_cust_sls_ofc_cd");
        getComboObject(comboObjects, 'ctrt_cust_srep_cd').Code2 = sheetObj.CellValue(1,"ctrt_cust_srep_cd");

        formObj.ctrt_cust_srep_nm.value = sheetObj.CellValue(1,"ctrt_cust_srep_nm");
        formObj.real_cust_cnt_cd.value = sheetObj.CellValue(1,"real_cust_cnt_cd");
        if (sheetObj.CellValue(1, "real_cust_seq") !="" ){
            formObj.real_cust_seq.value = ComLpad(sheetObj.CellValue(1,"real_cust_seq"), 6, "0");
        }else{
            formObj.real_cust_seq.value = "";
        }

        formObj.real_cust_nm.value = sheetObj.CellValue(1,"real_cust_nm");
        formObj.real_cust_tp_cd.value = sheetObj.CellValue(1,"real_cust_tp_cd");
        formObj.real_cust_val_sgm.value = sheetObj.CellValue(1,"real_cust_val_sgm");
        formObj.real_cust_sls_ofc_cd.value = sheetObj.CellValue(1,"real_cust_sls_ofc_cd");
        formObj.real_cust_srep_nm.value = sheetObj.CellValue(1,"real_cust_srep_nm");
        formObj.real_cust_srep_cd.value = sheetObj.CellValue(1,"real_cust_srep_cd");
        formObj.prop_mqc_qty.value = sheetObj.CellValue(1,"prop_mqc_qty");
        formObj.prop_mqc_qty.focus();
        getComboObject(comboObjects, 'cntr_lod_ut_cd').Code2 = sheetObj.CellValue(1,"cntr_lod_ut_cd");
        getComboObject(comboObjects, 'prop_apro_ofc_cd').Code2 = sheetObj.CellValue(1,"prop_apro_ofc_cd");

        //저장시 duration을 scope과 비교하기 위하여 원본 duration을 가지고 있다.
        var preIbflag = sheetObj.RowStatus(1);
        sheetObj.CellValue(1,"ctrt_eff_dt_ori") = sheetObj.CellValue(1,"ctrt_eff_dt");
        sheetObj.CellValue(1,"ctrt_exp_dt_ori") = sheetObj.CellValue(1,"ctrt_exp_dt");

        if (sheetObj.CellValue(1,"prc_mst_prop_tp_cd") == "P") {
            formObj.prc_mst_prop_tp_nm.value = "Proposal";
            formObj.prop_sts.style.display = "inline";
        } else if (sheetObj.CellValue(1,"prc_mst_prop_tp_cd") == "M") {
            formObj.prc_mst_prop_tp_nm.value = "Master";
            formObj.prop_sts.style.display = "none";
        }
        
        //조회한 Approval Office가 combo 에 없다면 Approval Office를 입력한다.
        var cboObj = getComboObject(comboObjects, 'prop_apro_ofc_cd');
        var aproOfcCd = sheetObj.CellValue(1,"prop_apro_ofc_cd");
        if (aproOfcCd !="" && cboObj.FindIndex(aproOfcCd, 0) == -1 ){
        	cboObj.InsertItem(0,aproOfcCd + "| "  ,aproOfcCd);
        	cboObj.Code2 = aproOfcCd;
        }
    }

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장 후 로직을 처리한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 문동규
     * @version 2009.07.21
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
         if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            if (sheetObj.CellValue(1, "prop_sts_cd") == "D") {
                ComPriDeleteCompleted();  // 삭제성공메세지
                doActionIBSheet(sheetObj, document.form,IBCREATE);
            } else {
                if (document.form.is_goto_prop.value == "Y") {
                    // 성공메세지 없이 바로 Proposal Main 화면으로 이동
                    window.location.href = "/hanjin/ESM_PRI_0003.do?pgmNo=ESM_PRI_0003&prop_no="+sheetObj.CellValue(1,"prop_no");
                    return;
                } else {
                    ComPriSaveCompleted();  // 저장성공메세지
                    doActionIBSheet(sheetObj, document.form,IBSEARCH);
                }
            }
        }
        document.form.is_goto_prop.value = "";
    }

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * MQC를 계산하기 위하여 추가한 컬럼에 값을 채워 넣는다.
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 공백진
     * @version 2009.05.20
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg){
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObj;
        var formObj = document.form;
        for ( var i = 1; i <= sheetObj2.RowCount; i++ ){
            sheetObj2.CellValue2(i,"prop_scp_mqc_qty_ori") = sheetObj2.CellValue(i,"prop_scp_mqc_qty");
            sheetObj2.CellValue2(i,"sale_rep_cd") = sheetObj2.CellValue(i,"prop_scp_srep_cd");
            sheetObj2.RowStatus(i) = "R";
        }

        //sale rep
        getComboObject(comboObjects, 'prop_srep_cd').Code2 = sheetObj1.CellValue(1,"prop_srep_cd");

        //font
//        var amdt_seq = formObj.amdt_seq.value;
//        var eff_dt   = sheetObj1.CellValue(1,"eff_dt");
//
//        if(amdt_seq==0){
//            return;
//        }
//
//        for(i = 1 ; i < sheetObj2.Rows; i++){
//            if(sheetObj2.CellValue(i,"ctrt_eff_dt") == eff_dt){
//                sheetObj2.CellFont("FontColor", i, 1, i, sheetObj2.LastCol)= sheetObj2.RgbColor(255,0,0);
//            }
//        }
    }


//    /**
//     * OnPopupClick 이벤트 발생시 호출되는 function <br>
//     * Popup아이콘 클릭 시 Popup을 호출한다.<br>
//     * <br><b>Example :</b>
//     * <pre>
//     * </pre>
//     * @param {ibsheet} sheetObj 필수 IBSheet Object
//     * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
//     * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
//     * @return 없음
//     * @author 문동규
//     * @version 2009.09.10
//     */
//    function sheet2_OnPopupClick(sheetObj, Row, Col)
//    {
//        var colName = sheetObj.ColSaveName(Col);
//        var formObj = document.form;
//
//        switch(colName)
//        {
//            case "scp_dur_pop":
//
//                var sPropNo = sheetObjects[0].CellValue(1,"prop_no");
//                var sAmdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
//                var sPreAmdtSeq = sheetObjects[0].CellValue(1, "pre_amdt_seq");
//                var sPropStsCd = sheetObjects[0].CellValue(1, "prop_sts_cd");
//                var sSvcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
//                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");
//
//                var sParam = "sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd+"&sSrepCd="+sSrepCd;
//                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0019.do?"+sParam, "", 640, 335, true);
//
//                if (rtnVal != null && rtnVal.length > 0){
//                    changeDuration(rtnVal);
//                }
//                break;
//
//            case "prop_scp_mqc_pop":
//                var sPropNo = sheetObjects[0].CellValue(1,"prop_no");
//                var sAmdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
//                var sPreAmdtSeq = sheetObjects[0].CellValue(1, "pre_amdt_seq");
//                var sPropStsCd = sheetObjects[0].CellValue(1, "prop_sts_cd");
//                var sSvcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
//                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");
//
//                var sParam = "sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd+"&sSrepCd="+sSrepCd;
//                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0020.do?"+sParam, "", 650, 500, true);
//
//                if (rtnVal != null && rtnVal.length > 0){
//                    changeMQC(rtnVal);
//                }
//                break;

//            case "gline_cp_flg_lnk":
//                var sPropNo = sheetObjects[0].CellValue(1,"prop_no");
//                var sAmdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
//                var sPreAmdtSeq = sheetObjects[0].CellValue(1, "pre_amdt_seq");
//                var sPropStsCd = sheetObjects[0].CellValue(1, "prop_sts_cd");
//                var sSvcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
//
//                var sParam = "sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd;
//                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0018.do?"+sParam, "", 640, 335, true);
//                if (rtnVal != null){
//                    sheetObj.CellValue2(Row, Col-1) = rtnVal;
//                }
//                break;
//        }
//    }

//--> jin add (S)

    /**
     * 입력한 Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *        checkRequestOffice();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.05.07
     */
    function checkRequestOffice(){
        var formObj = document.form;
        var cd = formObj.prop_ofc_cd.value;
        var sheetObj = sheetObjects[2];
        formObj.f_cmd.value = SEARCH15;
        var sParam = FormQueryString(formObj)+"&etc1="+cd;

        sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
        ComPriXml2ComboItem(sXml, formObj.prop_srep_cd, "cd", "cd|nm");
        com_change_sheet( sheetObj, "prop_ofc_cd" );
        formObj.prop_srep_nm.value = "";
    }

    /**
     * 입력한 Customer Sale Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      setCustSaleRep();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.05.07
     */
    function setCustSaleRep(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if (formObj.cust_cnt_cd.value !="" && formObj.cust_seq.value !=""){
            formObj.f_cmd.value = COMMAND20;
            sParam = FormQueryString(formObj) +"&etc1="+formObj.ctrt_cust_sls_ofc_cd.value+"&etc2="+formObj.cust_cnt_cd.value+"&etc3="+ ComParseInt(formObj.cust_seq.value);
            sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
            ComPriXml2ComboItem(sXml, formObj.ctrt_cust_srep_cd, "cd", "cd|nm");
        }
    }

    /**
     * 입력한 Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *      setRequestOfficeSaleRep();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.05.07
     */
    function setRequestOfficeSaleRep(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];

        formObj.f_cmd.value = SEARCH15;
        var sParam = FormQueryString(formObj) +"&etc1="+formObj.prop_ofc_cd.value;
        var sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
        ComPriXml2ComboItem(sXml, formObj.prop_srep_cd, "cd", "cd|nm");
    }


    /**
     * Scope의 Request Office 에 따른 Sales Rep을 조회하여 sheet Combo에 Setting한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      setSheetRequestOfficeSaleRep(sheetObj, 1, "HAMRU");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int}     Row      필수 선택한 Row Index
     * @param {string}  offCd    필수 Scope의 Request Office code
     * @return 없음
     * @author 문동규
     * @version 2009.05.07
     */
    function setSheetRequestOfficeSaleRep(sheetObj, Row, offCd){
        var formObj = document.form;

        formObj.f_cmd.value = SEARCH15;

        var sParam = FormQueryString(formObj) +"&etc1="+ offCd;

        var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do",sParam);

        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
        if (arrData !=null && arrData.length > 0){
            var arrCode = arrData[0].split("|");
            var arrText = arrData[1].split("|");
            var aText = "";
            if (arrCode != null && arrCode.length > 0){
                for (var i = 0; i < arrCode.length; i++){
                    aText += arrCode[i]+"\t"+arrText[i]+"|";
                }
            }
            sheetObj.CellComboItem(Row,"prop_scp_srep_cd",aText,arrData[0],0);
        }
    }

    /**
     * Sales Rep 의 Office Code를 조회한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getOfficeCd(srepCd);
     * </pre>
     * @param  {string} srepCd 필수 sale rep. code
     * @return  string  Office Code
     * @author 문동규
     * @version 2009.05.07
     */
    function getOfficeCd(srepCd){
        document.form.f_cmd.value = COMMAND21;
        var sParam = FormQueryString(document.form)+"&etc1="+srepCd;
        var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", sParam);
        var arrData = ComPriXml2Array(sXml, "cd");
        if (arrData != null && arrData.length > 0) {
            return arrData[0];
        }
        return null;
    }

    /**
     * Customer에 관련된 Html Object의 값을 clear 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      clearCustName();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.05.07
     */
    function clearCustName(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];

        sheetObj.CellValue(1,"prc_ctrt_cust_tp_cd") = "";
        sheetObj.CellValue(1,"ctrt_pty_nm") = "";
        sheetObj.CellValue(1,"ctrt_pty_addr") = "";
        sheetObj.CellValue(1,"ctrt_cust_val_sgm_cd") = "";
        sheetObj.CellValue(1,"ctrt_cust_val_sgm") = "";
        sheetObj.CellValue(1,"ctrt_cust_srep_cd") = "";
        sheetObj.CellValue(1,"ctrt_cust_sls_ofc_cd") = "";
        sheetObj.CellValue(1,"ctrt_pty_sgn_nm") = "";   //arrText[0][6];
        sheetObj.CellValue(1,"ctrt_pty_sgn_tit_nm") = "";   //arrText[0][7];

        formObj.cust_cnt_cd.value = "";
        formObj.cust_seq.value = "";
        formObj.ctrt_pty_nm.value = "";
        getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').Code = "";
        formObj.ctrt_cust_val_sgm.value = "";
        formObj.ctrt_cust_sls_ofc_cd.value = "";
        formObj.ctrt_cust_srep_nm.value = "";
        getComboObject(comboObjects, 'ctrt_cust_srep_cd').Code = "";
    }

    /**
     * Customer에 관련된 정보를 조회한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      custNameFind(eleName);
     * </pre>
     * @param  {string} eleName 필수 Html Object Name
     * @return 없음
     * @author 문동규
     * @version 2009.05.07
     */
    function custNameFind(eleName){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var cust_cnt_cd = formObj.cust_cnt_cd.value;

        var cust_seq = formObj.cust_seq.value;
        if(cust_cnt_cd != "" && cust_seq !=""){
            var sParam = "f_cmd="+SEARCH02+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;

            var sXml = sheetObj.GetSearchXml("ESM_PRI_0015GS.do", sParam);
            var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_cust_srep_nm|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm");

            if(arrText==undefined){
                clearCustName();
                formObj.cust_cnt_cd.focus();
            }else{
                getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').Code = "";
                getComboObject(comboObjects, 'ctrt_cust_srep_cd').Code = "";
                sheetObj.CellValue2(1,"prc_ctrt_cust_tp_cd")  = arrText[0][0];
                sheetObj.CellValue2(1,"ctrt_pty_nm")          = arrText[0][1];
                sheetObj.CellValue2(1,"ctrt_pty_addr")        = arrText[0][2];
                sheetObj.CellValue2(1,"ctrt_cust_val_sgm_cd") = arrText[0][3];
                sheetObj.CellValue2(1,"ctrt_cust_val_sgm")    = arrText[0][4];
                sheetObj.CellValue2(1,"ctrt_cust_srep_cd")    = arrText[0][5];
                sheetObj.CellValue2(1,"ctrt_cust_sls_ofc_cd") = arrText[0][6];
                sheetObj.CellValue2(1,"ctrt_pty_sgn_nm")      = arrText[0][8];
                sheetObj.CellValue2(1,"ctrt_pty_sgn_tit_nm")  = arrText[0][9];

                formObj.ctrt_pty_nm.value = arrText[0][1];
                getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').Code2 = arrText[0][0];
                formObj.ctrt_cust_val_sgm.value = arrText[0][4];
                formObj.ctrt_cust_sls_ofc_cd.value = arrText[0][6];
                getComboObject(comboObjects, 'ctrt_cust_srep_cd').Code2 = arrText[0][5];
                formObj.ctrt_cust_srep_nm.value = arrText[0][7];
            }
        }
//        else if (cust_cnt_cd == "" || cust_seq ==""){
//          clearCustName();
//        }
//        var sheetObj = sheetObjects[0];
        com_change_sheet(sheetObj, eleName);
    }

    /**
     * 메인 duration이 변경되었을 경우 조건에 따라 Scope의 duration을 변경한다. <br>
     * 저장 전에 scope duration을 변경한다.
     * <br><b>Example :</b>
     * <pre>
     *      saveDurationChange();
     * </pre>
     * @param {string} msgPass 필수 메세지 박스를 보이지 않고 scope의 duration만 변경할 경우 false,메세지박스를 보여주려면 true
     * @return 없음
     * @author 문동규
     * @version 2009.04.17
     */
    function saveChangeDuration(msgPass){
        var sheetObj = sheetObjects[0];
        var sheetObj1 = sheetObjects[1];
        var oriCtrtEffDt = sheetObj.CellValue(1, "ctrt_eff_dt_ori");
        var oriCtrtExpDt = sheetObj.CellValue(1, "ctrt_exp_dt_ori");
        var ctrtEffDt = sheetObj.CellValue(1, "ctrt_eff_dt");
        var ctrtExpDt = sheetObj.CellValue(1, "ctrt_exp_dt");
        var effChk = 0;
        var expChk = 0;
        var msgChk = 0;

        if (sheetObj.RowStatus(1) == "I"){
            return true;
        }
        if (oriCtrtEffDt > ctrtEffDt ){
            effChk = 1; //일자 앞으로 늘림 Duration Eff 늘이기
             //단, 아니요를 선택 할 경우 Proposal Duration Eff 만 늘임
            for ( var i = 1 ; i <=sheetObj1.RowCount; i++){
                if (oriCtrtEffDt == sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    msgChk = 1;
                    break;
                }
            }
        }else if (oriCtrtEffDt < ctrtEffDt){
            effChk = 2; //일자 줄임 Duration Eff 줄이기
            //단, 아니요를 선택 할 경우 모든 수행을 취소하고 Return
            for (var i = 1; i <= sheetObj1.RowCount; i++){
                if (ctrtEffDt >= sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    msgChk = 2;
                    break;
                }
            }
        }
        if (oriCtrtExpDt > ctrtExpDt ){ //일자 줄임 Duration Eff 줄이기
            expChk = 1; //일자 줄임 Duration Eff 줄이기
            //단, 아니요를 선택 할 경우 모든 수행을 취소하고 Return
            for ( var i = 1 ; i <= sheetObj1.RowCount; i++){
                if (ctrtExpDt <= sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    msgChk += 3;
                    break;
                }
            }
        }else if (oriCtrtExpDt < ctrtExpDt){
            expChk = 2; //일자 뒤로 늘림 Duration Exp 늘이기
            //단, 아니요를 선택 할 경우 Proposal Duration Exp 만 늘임
            for (var i = 1; i <= sheetObj1.RowCount; i++){
                if (oriCtrtExpDt == sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    msgChk += 6;
                    break;
                }
            }
        }

        // 메세지로 변경 확인 한 후
        if ((effChk + expChk) == 0){ //duration 만 변경된다.
            return true;
        }
        if (msgPass == "true"){
            msgChk = 0;
        }

        switch (msgChk){
            case 1:
                if (!ComShowCodeConfirm("PRI01025")){
                    return true;
                }
                break;
            case 2:
                if (!ComShowCodeConfirm("PRI01025")){
                    return false;
                }
                break;
            case 3:
            case 4:
            case 5:
                if (!ComShowCodeConfirm("PRI01025")){
                    return false;
                }
                break;
            case 6:
                if (!ComShowCodeConfirm("PRI01025")){
                    return true;
                }
                break;
            case 7:
                if (!ComShowCodeConfirm("PRI01025")){
                    return true;
                }
                break;
            case 8:
                if (!ComShowCodeConfirm("PRI01025")){
                    return false;
                }
                break;

        }

        if (effChk == 1){
            for ( var i = 1 ; i <=sheetObj1.RowCount; i++){
                if (oriCtrtEffDt == sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    sheetObj1.CellValue2(i,"ctrt_eff_dt") = ctrtEffDt;
                    sheetObj1.CellValue2(i,"eff_dt") = ctrtEffDt;
                }
            }
        }else if (effChk == 2){
            for (var i = 1; i <= sheetObj1.RowCount; i++){
                if (ctrtEffDt >= sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    sheetObj1.CellValue2(i, "ctrt_eff_dt") = ctrtEffDt;
                    sheetObj1.CellValue2(i, "eff_dt") = ctrtEffDt;
                }

            }
        }

        if (expChk == 1){
            for ( var i = 1 ; i <= sheetObj1.RowCount; i++){
                if (ctrtExpDt <= sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    sheetObj1.CellValue2(i,"ctrt_exp_dt") = ctrtExpDt;
                    sheetObj1.CellValue2(i,"exp_dt") = ctrtExpDt;
                }
            }
        }else if (expChk == 2){
            for (var i = 1; i <= sheetObj1.RowCount; i++){
                if (oriCtrtExpDt == sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    sheetObj1.CellValue2(i, "ctrt_exp_dt") = ctrtExpDt;
                    sheetObj1.CellValue2(i, "exp_dt") = ctrtExpDt;
                }
            }
        }
        return true;
    }


    /**
     * Duration PopUp에서 받아온 Duration을 Main,Scope의 Duration으로 Setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *      changeDuration(durData);
     * </pre>
     * @param {object} 필수 Duration PopUp에서 받아 온 데이터
     * @return 없음
     * @author 문동규
     * @version 2009.04.17
     */
    function changeDuration(durData){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var sheetObj1 = sheetObjects[1];
        var preIbflag;

        if (durData !=null && durData.length > 0){
            for (var i = 0; i < durData.length; i++){
                var arrData = durData[i].split("|");
                if (arrData[0] == ""){
                    formObj.ctrt_eff_dt.value = arrData[1];
                    formObj.ctrt_exp_dt.value = arrData[2];
                    formObj.ctrt_eff_dt.focus();
                    formObj.ctrt_exp_dt.focus();
                    formObj.prop_no.focus();
                    saveChangeDuration("true");

                    sheetObj.CellValue2(1, "eff_dt") = arrData[3];
                    sheetObj.CellValue2(1, "exp_dt") = arrData[4];


                }else{
                    for (var j = 1; j < sheetObj1.RowCount; j++){

                        if (sheetObj1.CellValue(j, "svc_scp_cd") == arrData[0]){
                            preIbflag = sheetObj1.RowStatus(j);
                            sheetObj1.CellValue2(j, "ctrt_eff_dt") = arrData[1];
                            sheetObj1.CellValue2(j, "ctrt_exp_dt") = arrData[2];
                            sheetObj1.CellValue2(j, "eff_dt") = arrData[3];
                            sheetObj1.CellValue2(j, "exp_dt") = arrData[4];
                            sheetObj1.RowStatus(j) = preIbflag;
                        }
                    }
                }
            }
        }
    }

    /**
     * MQC PopUp에서 받아온 값을 Main,Scope의 MQC로 Setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *      changeMQC(mqcData);
     * </pre>
     * @param {object} 필수 Duration PopUp에서 받아 온 데이터
     * @return 없음
     * @author 문동규
     * @version 2009.04.17
     */
    function changeMQC(mqcData){
        var formObj = document.form;
        var sheetObj = sheetObjects[1];
        var preIbflag;

        if (mqcData !=null && mqcData.length > 0){
            for (var i = 0; i < mqcData.length; i++){
                var arrData = mqcData[i].split("|");
                if (arrData[0] == ""){
                    formObj.cntr_lod_ut_cd.value = arrData[1];
                    formObj.prop_mqc_qty.value = arrData[2];
                }else{
                    for (var j = 1; j < sheetObj.RowCount; j++){
                        if (sheetObj.CellValue(j, "svc_scp_cd") == arrData[0]){
                            preIbflag = sheetObj.RowStatus(j);
                            sheetObj.CellValue2(j, "prop_scp_mqc_qty") = arrData[2];
                            sheetObj.RowStatus(j) = preIbflag;
                        }
                    }
                }
            }
        }
    }

    /**
     * Request버튼 클릭시 Request를 진행 할 수 없는 경우를 확인한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *         checkRequest
     * </pre>
     * @param {object} 필수 Duration PopUp에서 받아 온 데이터
     * @return 없음
     * @author 문동규
     * @version 2009.04.17
     */
    function checkRequest(){
        document.form.f_cmd.value = SEARCH07;

        var rValue = "N"; //Request 금지
        var sParam = FormQueryString(document.form);
        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0015GS.do", sParam);
        var arrData = ComPriXml2Array(sXml, "svc_scp_cd");
        if (arrData != null && arrData.length > 0) {
        }else{
            rValue = "Y";
        }
        return rValue;
    }
//--> jin add (E)

//    sheet  관련   (E)   -----

/////////////////////////////////////////////////////////////////////////
/////////////////////// ONCHANGE (E)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////

    /**
     * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    btnImgEnable(obj, true);
     * </pre>
     * @param  {form} obj 필수, Html Object
     * @param  {bool} gb  필수, true : 활성화, false : 비활성화
     * @return 없음
     * @author 문동규
     * @version 2009.04.17
     */
    function btnImgEnable(obj, gb) {
        if(obj.constructor == String){
            obj = document.getElementsByName(obj)[0];
        }
        var btnStyle = obj.style;

        if (gb){
            btnStyle.cursor = "hand";
            btnStyle.filter="";
        } else {
            btnStyle.cursor = "auto";
            btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
        }
    }

    /**
     * MVC 값을 계산한다. (MVC = MQC / Duration 유효 일수 x 7)<br>
     * <br>
     * <br><b>Example :</b>
     * <pre>
     *     calcMVC();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.07.10
     */
    function calcMVC(){
        var formObj = document.form;

        var mqcQty = ComGetUnMaskedValue(formObj.prop_mqc_qty.value, "int");

        var sDay = formObj.ctrt_eff_dt.value;
        var eDay = formObj.ctrt_exp_dt.value;
        var mvcQty = 0;
        var durDay = ComGetDaysBetween(sDay, eDay);
        if (mqcQty != "" && mqcQty != "0") {
            mvcQty = ComRound((mqcQty / durDay * 7),0);
        }
        formObj.prop_mvc.value = mvcQty;
    }

    /**
     * 커서의 focus 위치를 지정한다.<br>
     * <br>
     * <br><b>Example :</b>
     * <pre>
     *     firstFocus();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.07.30
     */
    function firstFocus(){
        document.form.sc_no.focus();
    }
    /* 개발자 작업  끝 */