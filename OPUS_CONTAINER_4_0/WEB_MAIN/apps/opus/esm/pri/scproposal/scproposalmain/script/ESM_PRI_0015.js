/*=========================================================
 ** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0015.js
*@FileTitle  :  S/C Master Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================*/
/****************************************************************************************
 Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
 [Mdofication]MODIFY=4; [Remove ]REMOVE=5; [Remove List]REMOVELIST=6 [Multi TXN]MULTI=7
 Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends Pri
     * @class ESM_PRI_0015 : business script for ESM_PRI_0015 
     */
    function ESM_PRI_0015 () {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.validateForm=validateForm;
    }
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var trMode="R";
    var prevDtIdx=-1;
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br>
     * <b>Example :</b>
     *
     * <pre>
     * processButtonClick();
     * </pre>
     *
     * @return none
     * @author 
     * @version 
     */
    function processButtonClick() {
        /** **************************************************** */
        var formObj=document.form;
        try {
            var srcObj=ComGetEvent();
            var srcName=srcObj.getAttribute("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
                    break;
                case "btn_New":
                    doActionIBSheet(sheetObjects[0],formObj,IBCREATE);
                    break;
                case "btn_ctrt_cust":
                    //Prohibiting from inputting in case of no office code
                    if (formObj.prop_ofc_cd.value == "") {
                        ComShowCodeMessage('PRI01042', 'Request Office first');
                        resetCustomer();
                        formObj.prop_ofc_cd.focus();
                        return;
                    }
                    
                	var sParam = "is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.cust_cnt_cd.value+"&cust_seq="+formObj.cust_seq.value;
               	 	ComOpenPopup("ESM_PRI_4014_POP.do?"+sParam, 800, 465, "btn_ctrt_cust_returnVal", "none", true);
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
                case "btns_calendar":
                    var cal=new ComCalendarFromTo();
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
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    /**
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return 
     * @author 
     * @version 2009.08.25
     */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBCombo Object as list</b>
     * adding process for list in case of needing batch processing with other items</b> 
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(comboObj);
     * </pre>
     * @param {object} combo_obj mandatory IBMultiCombo Object
     * @return 
     * @author 
     * @version 2009.08.25
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet</b>
     * implementing onLoad event handler in body tag</b>
     * adding first-served functions after loading screen.</b>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 
     * @version 2009.08.25
     */
    function loadPage() {
         //IBMultiCombo initialization
         for(var k=0; k < comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
             
         }
         for (var i=0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        initIBComboItem();  // Setting item to IBCombo
        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
    }
    /**
     * Registering event listener<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
     * @return 
     * @author 
     * @version 2009.08.25
     */
    function initControl() {
        axon_event.addListenerForm('blur', 'obj_blur', document.form);
//        axon_event.addListenerFormat('keypress', 'obj_keypress', 'form');
        axon_event.addListener('keyup', "ComKeyEnter('LengthNextFocus')", document.form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
    /**
     * Setting items to IBMultiCombo  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem();
     * </pre>
     * @return 
     * @author 
     * @version 2009.08.25
     */
    function initIBComboItem() {
        var formObj=document.form;
        ComPriTextCode2ComboItem(appOfcComboValue, appOfcComboText, getComboObject(comboObjects, 'prop_apro_ofc_cd') ,"|","\t" );
        ComPriTextCode2ComboItem(custTpComboValue, custTpComboText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd') ,"|","\t" );
        ComPriTextCode2ComboItem(lodUtComboValue, lodUtComboText, getComboObject(comboObjects, 'cntr_lod_ut_cd') ,"|","\t" );
    }

    /**
     * Catching business javascript Deactivate event<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate();
     * </pre>
     * @return 없음
     * @author 
     * @version 2009.09.04
     */
    function obj_blur() {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var eleName=ComGetEvent("name");
        switch(eleName){
            case "sc_no":
                com_change_sheet(sheetObj, eleName);
                break;
            case "cust_cnt_cd":
                //Prohibiting from inputing in case of no office code
                if (formObj.cust_cnt_cd.value != "" && formObj.prop_ofc_cd.value == "") {
                    ComShowCodeMessage('PRI01042', 'Request Office first');
                    resetCustomer();
                    formObj.prop_ofc_cd.focus();
                    return;
                }
                //cust name find
                if (sheetObj.GetCellValue(1, "cust_cnt_cd") != formObj.cust_cnt_cd.value){
                    custNameFind(eleName);
                    //sale rep
                    setCustSaleRep();
                    //Setting retrieved code after setting COMBO
                    getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectCode(sheetObj.GetCellValue(1,"ctrt_cust_srep_cd"),false);
                }
                ComChkObjValid(ComGetEvent());
                break;
            case "cust_seq":
                //Prohibiting from inputing in case of no office code
                if (formObj.cust_seq.value != "" && formObj.prop_ofc_cd.value == "") {
                    ComShowCodeMessage('PRI01042', 'Request Office first');
                    resetCustomer();
                    formObj.prop_ofc_cd.focus();
                    return;
                }
                var custSeq=formObj.cust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.cust_seq.value=ComLpad(custSeq, 6, "0");
                }
                //cust name find
                if (ComParseInt(sheetObj.GetCellValue(1, "cust_seq")) != ComParseInt(formObj.cust_seq.value)){
                    if (formObj.cust_seq.value !=""){
                        custNameFind(eleName);
                        //sale rep
                        setCustSaleRep();
                        getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectCode(sheetObj.GetCellValue(1,"ctrt_cust_srep_cd"),false);
                    }
                }
                break;
            case "ctrt_eff_dt":
            	if(ComChkObjValid(ComGetEvent(), false)) {
            		com_change_sheet(sheetObj, "ctrt_exp_dt");
                    com_change_sheet(sheetObj, eleName);
            	}
                break;
            case "ctrt_exp_dt":
            	if(ComChkObjValid(ComGetEvent(), false)) {
            		 com_change_sheet(sheetObj, eleName);
                     com_change_sheet(sheetObj, "ctrt_eff_dt");
            	}
                break;
            case "prop_mqc_qty":
                com_change_sheet(sheetObj, eleName);
                ComChkObjValid(ComGetEvent());
                break;
            case "prop_ofc_cd":
            	if (sheetObj.GetCellValue(1,"prop_ofc_cd") != formObj.prop_ofc_cd.value){
                    // Reset Customer in case of modifying office code
            		resetCustomer();
                    var cd=formObj.prop_ofc_cd.value;
                    formObj.f_cmd.value=COMMAND22;
                    var sParam=FormQueryString(formObj)+"&cd="+cd;
                    var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
                    var arrData=ComPriXml2Array(sXml, "cd|nm");
                    if (arrData != null && arrData.length > 0) {
                        checkRequestOffice();
                    }else{
                        formObj.prop_ofc_cd.value="";
                        formObj.prop_srep_nm.value="";
                        getComboObject(comboObjects, 'prop_srep_cd').RemoveAll();
                        formObj.prop_ofc_cd.focus();
                    }
                    com_change_sheet(sheetObj, "prop_ofc_cd");
                    com_change_sheet(sheetObj, "prop_srep_cd");
                }
                break;
            default:
                ComChkObjValid(ComGetEvent());
        }
    }

    /**
     * Reseting all of Customer information.
     */
	function resetCustomer() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;

		getComboObject(comboObjects, 'ctrt_cust_srep_cd').RemoveAll();
		getComboObject(comboObjects, "prc_ctrt_cust_tp_cd").SetSelectCode(-1, true);
		sheetObj.SetCellValue(1, "cust_cnt_cd", "", 0);
        sheetObj.SetCellValue(1,"cust_seq","",0);
        sheetObj.SetCellValue(1,"prc_ctrt_cust_tp_cd","",0);
        sheetObj.SetCellValue(1,"ctrt_pty_nm","",0);
        sheetObj.SetCellValue(1,"ctrt_pty_addr","",0);
        sheetObj.SetCellValue(1,"ctrt_cust_val_sgm_cd","",0);
        sheetObj.SetCellValue(1,"ctrt_cust_val_sgm","",0);
        sheetObj.SetCellValue(1,"ctrt_cust_srep_cd","",0);
        sheetObj.SetCellValue(1,"ctrt_cust_sls_ofc_cd","",0);
        sheetObj.SetCellValue(1,"ctrt_pty_sgn_nm","",0);
        sheetObj.SetCellValue(1,"ctrt_pty_sgn_tit_nm","",0);
        formObj.cust_cnt_cd.value="";
        formObj.cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        formObj.ctrt_cust_val_sgm.value="";
        formObj.ctrt_cust_sls_ofc_cd.value="";
        formObj.ctrt_cust_srep_nm.value="";
    }
    /**
     * Handling process about Sheet <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory process flag constant-variable
     * @return 
     * @author 
     * @version 2009.09.09
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: // Retrieve
                ComOpenWait(true);
                sheetObj=sheetObjects[0];
                if (validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value=SEARCH01;
                    if(formObj.sc_no.value!="")
                        formObj.prop_no.value="";
                    var sXml=sheetObj.GetSearchData("ESM_PRI_0015GS.do" , FormQueryString(formObj));
                    var arrXml=sXml.split("|$$|");
                    if (arrXml.length > 0) {
                        sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
                    }
                    //sale rep
//                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
                    if (arrXml.length > 1) {
                        sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
                    }
//                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
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
                var sheetObj=sheetObjects[0];
                sheetObj.SetCellValue(1,"prop_sts_cd","I",0);
                sheetObj.SetCellValue(1,"prc_prog_sts_cd","I",0);
                sheetObj.SetCellValue(1,"src_info_cd","NW",0);
                sheetObj.SetCellValue(1,"rf_flg","N",0);
                sheetObj.SetCellValue(1,"gamt_flg","N",0);
                sheetObj.SetCellValue(1,"prc_ctrt_pty_tp_cd","C",0);
                sheetObj.SetCellValue(1,"prop_ofc_cd","",0);
                sheetObj.SetCellValue(1,"cntr_lod_ut_cd","F",0);
                sheet1_OnSearchEnd(sheetObj);
                setRequestOfficeSaleRep();
                sheetObj.SetCellValue(1,"amdt_seq","0",0);
                formObj.amdt_seq.value="0";
                cntr_lod_ut_cd.SetSelectText("F");
                sheetObj.SetCellValue(1,"prc_prop_cre_tp_cd","M",0);
                sheetObj.SetCellValue(1,"prc_mst_prop_tp_cd","M",0);
                sheetObj.SetCellValue(1,"prop_prpr_flg","N",0);
                formObj.prc_mst_prop_tp_nm.value="Master";
                formObj.prop_sts.value="";
                buttonControl();
                firstFocus();
                ComOpenWait(false);
                break;
            case IBSAVE: // Save
                ComOpenWait(true);
                var sheetObj=sheetObjects[1];
                var insertFlag="false";// for updaing amend flag
                // Setting Scope Hidden Cell
                for (var i=sheetObj.HeaderRows(), n=sheetObj.HeaderRows()+ sheetObj.RowCount(); i < n ; i++) {
                    sheetObj.SetCellValue(i, "prop_scp_ofc_cd",formObj.prop_ofc_cd.value,0);
                    sheetObj.SetCellValue(i, "prop_scp_srep_cd",getComboObject(comboObjects,'prop_srep_cd').GetSelectCode(),0);
                    sheetObj.SetCellValue(i, "prop_scp_apro_ofc_cd",getComboObject(comboObjects, 'prop_apro_ofc_cd').GetSelectCode(),0);
                    if (formObj.amdt_seq.value == "0"){
                        sheetObj.SetCellValue(i, "eff_dt",formObj.ctrt_eff_dt.value,0);
                    }else{
                    	sheetObj.SetCellValue(i, "eff_dt",sheetObjects[0].GetCellValue(1,"eff_dt"),0);
                    }
                    sheetObj.SetCellValue(i, "exp_dt",formObj.ctrt_exp_dt.value,0);
                    sheetObj.SetCellValue(i, "pre_exp_dt",sheetObjects[0].GetCellValue(1, "pre_exp_dt"),0);
                    sheetObj.SetCellValue(i, "cntr_lod_ut_cd",getComboObject(comboObjects, "cntr_lod_ut_cd").GetSelectCode(),0);
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
                //Setting parameter including proposal status
                //Skip in case of not proposal status                
                var mstAmdtSeq=formObj.amdt_seq.value;
                formObj.f_cmd.value=MULTI01;
                var sParam=FormQueryString(formObj)+"&mstAmdtSeq="+mstAmdtSeq;
                var sParamSheet1=sheetObjects[0].GetSaveString(true);
                if (sheetObjects[0].GetRowStatus(1)=="I"){
                    insertFlag="true";
                }
                if (sParamSheet1 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                } else {
                    return;
                }
                var sParamSheet2=sheetObjects[1].GetSaveString();
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                } else {
                    return;
                }
                var sXml=sheetObj.GetSaveData("ESM_PRI_0015GS.do", sParam);
                sheetObjects[0].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);
                sheetObjects[1].LoadSaveData(sXml);
                ComOpenWait(false);
                break;
            case IBSEARCH_ASYNC02: // Setting Sale Rep
                setRequestOfficeSaleRep();
                setCustSaleRep();
                getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectCode(sheetObj.GetCellValue(1,"ctrt_cust_srep_cd"),false);
                break;
            case IBINSERT: 
                var idx=sheetObj.DataInsert();
                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
                sheetObj.SetCellValue(idx, "prop_scp_ofc_cd",formObj.prop_ofc_cd.value,0);
                sheetObj.SetCellValue(idx, "prop_scp_srep_cd",getComboObject(comboObjects, 'prop_srep_cd').GetSelectCode(),0);
                sheetObj.SetCellValue(idx, "prop_scp_apro_ofc_cd",getComboObject(comboObjects, 'prop_apro_ofc_cd').GetSelectCode(),0);
                sheetObj.SetCellValue(idx, "prop_scp_mqc_qty","0",0);
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.SetCellValue(idx, "ctrt_eff_dt",formObj.ctrt_eff_dt.value,0);
                }else{
                	sheetObj.SetCellValue(idx, "ctrt_eff_dt",sheetObjects[0].GetCellValue(1,"eff_dt"),0);
                }
                sheetObj.SetCellValue(idx, "ctrt_exp_dt",formObj.ctrt_exp_dt.value,0);
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.SetCellValue(idx, "eff_dt",formObj.ctrt_eff_dt.value,0);
                }else{
                	sheetObj.SetCellValue(idx, "eff_dt",sheetObjects[0].GetCellValue(1,"eff_dt"),0);
                }
                sheetObj.SetCellValue(idx, "exp_dt",formObj.ctrt_exp_dt.value,0);
                sheetObj.SetCellValue(idx, "pre_exp_dt",sheetObjects[0].GetCellValue(1, "pre_exp_dt"),0);
                sheetObj.SetCellValue(idx, "prop_scp_sts_cd","I",0);
                sheetObj.SetCellValue(idx, "prc_prop_cre_tp_cd","M",0);
//                sheetObj.CellValue2(idx, "note_hdr_seq") = "000";//Confirmation
                sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
                sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
                sheetObj.SetCellValue(idx, "cntr_lod_ut_cd",getComboObject(comboObjects, "cntr_lod_ut_cd").GetSelectCode(),0);
//                sheetObj.CellValue2(idx, "n1st_cmnc_dt") = formObj.ctrt_eff_dt.value;
                sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",0,0);
                if(formObj.amdt_seq.value!=0){
                	sheetObj.SetCellFont("FontColor", idx, "chk", idx, "prop_scp_sts_cd","#FF0000");
                }
                var preIbflag=sheetObjects[0].GetRowStatus(1);
                if (preIbflag == "R"){
                    sheetObjects[0].SetRowStatus(1,"U");
                }
                sheetObj.SelectCell(idx, "svc_scp_cd", false);
                break;
            case IBDELETE: // Delete
                if (validateForm(sheetObj,formObj,sAction)) {
                    if (sheetObj.id == "sheet1") {
                        formObj.f_cmd.value=MULTI02;
                        if (!ComPriConfirmDeleteAll()) {
                            return false;
                        }
                        sheetObj.SetCellValue(1,"prop_sts_cd","D",0);
                        var sParam=FormQueryString(formObj);
                        var sParamSheet1=sheetObjects[0].GetSaveString(true);
                        if (sParamSheet1 != "") {
                            sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                        }
                        var sParamSheet2=sheetObjects[1].GetSaveString(true);//Put all scope's data
                        if (sParamSheet2 != "") {
                            sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                        }
                        var sXml=sheetObjects[0].GetSaveData("ESM_PRI_0015GS.do", sParam);
                        sheetObjects[0].LoadSaveData(sXml);
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
                formObj.f_cmd.value=MULTI03;
                sheetObj.SetCellValue(1,"prc_mst_prop_tp_cd","P",0);
                sheetObj.SetCellValue(1,"prop_prpr_flg","Y",0);
                formObj.is_goto_prop.value="Y";
                sheetObj.DoAllSave("ESM_PRI_0015GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;
        }
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj manadory IBSheet Object
     * @param {int} sheetNo mandatory , serial no for IBSheet Object tag ID
     * @return 
     * @author 
     * @version 2009.09.09
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
        case "sheet1":  // hidden
            with(sheetObj){
				  if (location.hostname != "")
		          var HeadTitle="|sc_no|prop_no|amdt_seq|pre_amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|n1st_cmnc_amdt_seq|prc_prog_sts_cd|src_info_cd|pre_exp_dt|rf_flg|gamt_flg|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt";
		          HeadTitle += "|cre_dt|file_dt|cust_cnt_cd|cust_seq|ctrt_pty_nm|prc_ctrt_pty_tp_cd|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_sls_ofc_cd";
		          HeadTitle += "|ctrt_cust_srep_cd|ctrt_cust_srep_nm|real_cust_cnt_cd|real_cust_seq|real_cust_nm|real_cust_tp_cd|real_cust_val_sgm_cd|real_cust_val_sgm";
		          HeadTitle += "|real_cust_sls_ofc_cd|real_cust_srep_cd|real_cust_srep_nm|prop_mqc_qty|cntr_lod_ut_cd|unit|sls_ld_no|blpl_hdr_seq";
		          HeadTitle += "|request user flag|approval user flag|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm|ctrt_eff_dt_ori|ctrt_exp_dt_ori|prc_mst_prop_tp_cd|prc_prop_cre_tp_cd|prop_prpr_flg";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          (headCount, 0, 0, true);
		
		          SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"sc_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"pre_amdt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"pre_exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rf_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gamt_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_sts",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_srep_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_srep_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"file_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_ctrt_pty_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_ctrt_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_val_sgm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_val_sgm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_srep_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_val_sgm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_val_sgm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"real_cust_srep_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_mqc_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_lod_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"unit",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"sls_ld_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"req_usr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"apro_usr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_tit_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_eff_dt_ori",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_exp_dt_ori",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"prc_mst_prop_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prop_cre_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_prpr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		          SetWaitImageVisible(0);
                }


            break;
        case "sheet2":
            with(sheetObj){
		            
		          if (location.hostname != "")
		          var HeadTitle="|Sel.|Seq.|Prop No|Amendment Seq|SVC Scope|Approval Office|Request Office|MQC|Sales Rep|eff_dt";
		          HeadTitle += "|exp_dt|n1st_cmnc_amdt_seq|pre_exp_dt|Creation Type Code|Status Code|Status|cntr_lod_ut_cd";
		          HeadTitle += "|req_usr_flg|apro_usr_flg|prc_prog_sts_cd|src_info_cd|submqcori|PRE_EXT_SCP|Effective Date|Expiry Date|";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          (headCount, 0, 0, true);
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                 {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_apro_ofc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_ofc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Int",       Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"prop_scp_mqc_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_srep_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"pre_exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"prc_prop_cre_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_lod_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"req_usr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"apro_usr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"prop_scp_mqc_qty_ori",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pre_ext_scp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
		          SetWaitImageVisible(0);
		          SetColProperty("svc_scp_cd", {ComboText:svcScpComboText, ComboCode:svcScpComboValue} );
		          //SetSheetHeight(375);
		          resizeSheet();
          }


            break;
        case "sheet3":     // Hidden sheet for Transaction
            with(sheetObj){
            	  if (location.hostname != "")
		          (1, 0, 0, true);
		          var HeadTitle="status";
		
		          SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		           
		          InitColumns(cols);
		
		          SetWaitImageVisible(0);
		          SetVisible(false);
                }
            break;
        }
    }
    
    function resizeSheet(){
		ComResizeSheet(sheetObjects[1]);
    }
    
    function sheet2_OnSort(sheetObj ,Col, SortArrow){
  	  sheet2.ReNumberSeq();   
  	 }
    /**
     * setting intial combo value <br>
     * adding case as numbers of counting combos<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object , Serial Number for Tag's ID
     * @return 
     * @author 
     * @version 2009.09.09
     */
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "prop_srep_cd":
                with(comboObj) {
                    //no support[check again]CLT ValidChar(2,1);
                    SetDropHeight(190);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
            case "prop_apro_ofc_cd":
                with(comboObj) {
                    //no support[check again]CLT ValidChar(2,0);
                    SetDropHeight(190);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
            case "prc_ctrt_cust_tp_cd":
                with(comboObj) {
                    //no support[check again]CLT ValidChar(2,0);
                    SetDropHeight(190);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
            case "ctrt_cust_srep_cd":
                with(comboObj) {
                    //no support[check again]CLT ValidChar(2,0);
                    SetDropHeight(190);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
            case "cntr_lod_ut_cd":
                with(comboObj) {
                    //no support[check again]CLT ValidChar(2,0);
                    SetDropHeight(190);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
        }
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         Processing logic;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory process flag contant_variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : invalid
     * @author 
     * @version 2009.09.09
     */
    function validateForm(sheetObj, formObj, sAction) {
        var sc_no=formObj.sc_no.value;
        var prop_no=formObj.prop_no.value;
        var amdt_seq=formObj.amdt_seq.value;
        switch (sAction) {
            case IBSEARCH: // retrieving
                if (sc_no == null && prop_no == null) {
                    return false;
                }
                return true;
                break;
            case IBCREATE: // New
                if(sheetObjects[0].IsDataModified()||sheetObjects[1].IsDataModified()){
                    return ComPriClearChange;
                }
                return true;
                break;
            case IBSAVE: // Save
                if(!ComChkRequired(document.form)){
                    return false;
                }
                // Scope check
                var scpCnt=sheetObjects[1].RowCount();
                if (scpCnt == 0) {
                    ComShowCodeMessage('PRI00316', 'Service Scope');
                    return;
                }
                // S/C No validation
//                if (sheetObjects[0].GetRowStatus(1) == "I") {
//                    var re=new RegExp();
//                    var scNo=formObj.sc_no.value;
//                    re.compile("^([A-Z]{3}[0-9]{6})$");
//                    if (!re.test(scNo)) {
//                        ComShowCodeMessage('PRI01084');
//                        formObj.sc_no.focus();
//                        return;
//                    }
//                    if (!scNo.substring(0,3) == "GLO") {    // exception case of GLO
//                        formObj.f_cmd.value=SEARCH03;
//                        var svcScpCds="";
//                        for (var i=1 ; i <= scpCnt ; i++) {
//                            if (i != 1) {
//                                svcScpCds += ";"
//                            }
//                            svcScpCds += sheetObjects[1].GetCellValue(i, "svc_scp_cd");
//                        }
//                        // sc_no prefix check
//                        sheetObjects[2].DoSearch("ESM_PRI_0015GS.do", FormQueryString(formObj)+"&svc_scp_cds="+svcScpCds );
//                        if (sheetObjects[2].GetEtcData("prefix") == "") {
//                            ComShowCodeMessage('PRI01085');
//                            formObj.sc_no.focus();
//                            return;
//                        }
//                    }
//                }
                if (getComboObject(comboObjects, "prop_srep_cd").GetSelectCode()== "") {
                    ComShowCodeMessage('PRI00316','Sales Rep.');
//                    getComboObject(comboObjects, "prop_srep_cd").focus();
                    return false;
                }
                if (getComboObject(comboObjects, "prop_apro_ofc_cd").GetSelectCode()== "") {
                    ComShowCodeMessage('PRI00316','Approval Office');
//                    getComboObject(comboObjects, "prop_apro_ofc_cd").focus();
                    return false;
                }
                if (getComboObject(comboObjects, "prc_ctrt_cust_tp_cd").GetSelectCode()== "") {
                    ComShowCodeMessage('PRI00316','Customer Type');
//                    getComboObject(comboObjects, "prc_ctrt_cust_tp_cd").focus();
                    return false;
                }
                if (getComboObject(comboObjects, "ctrt_cust_srep_cd").GetSelectCode()== "") {
                    ComShowCodeMessage('PRI00316','Contract Cust Sales Rep.');
//                    getComboObject(comboObjects, "ctrt_cust_srep_cd").focus();
                    return false;
                }
                if (getComboObject(comboObjects, "cntr_lod_ut_cd").GetSelectCode()== "") {
                    ComShowCodeMessage('PRI00316','Container Load Unit Code');
//                    getComboObject(comboObjects, "cntr_lod_ut_cd").focus();
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
                if(!sheetObjects[0].IsDataModified()&&!sheetObjects[1].IsDataModified()){
                    ComShowCodeMessage('PRI00301');
                    return false;
                }
                var rowM=sheetObjects[1].ColValueDup("svc_scp_cd");
                if (rowM >= 0) {
                    ComShowCodeMessage("PRI00303", "Sheet", rowM);
                    return false;
                }

				// MQC chk
				var mainMqc = sheetObjects[0].GetCellValue(1, "prop_mqc_qty");
				var subMqc = 0;
				var sheetObj = sheetObjects[1];
				for (var i=1; i<=sheetObj.RowCount(); i++) {
					var oriMqc = 0;
					if (sheetObj.GetCellValue(i, "prop_scp_mqc_qty_ori") != undefined && sheetObj.GetCellValue(i, "prop_scp_mqc_qty_ori") != "") {
						oriMqc = ComParseInt(sheetObj.GetCellValue(i, "prop_scp_mqc_qty_ori"));
					}
					subMqc += oriMqc;
					if (sheetObj.GetCellValue(i, "prop_scp_mqc_qty") != sheetObj.GetCellValue(i, "prop_scp_mqc_qty_ori")) {
						subMqc += ComParseInt(sheetObj.GetCellValue(i, "prop_scp_mqc_qty")) - oriMqc;
					}
				}
				if ((subMqc - mainMqc) > 0) {
					ComShowCodeMessage("PRI01008");
					return false;
				}
                return true;
                break;
        }
        return true;
    }
    /**
     * Initialization all input fields in form<br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllForms();
     * </pre>
     * @return 
     * @author 
     * @version 2009.07.30
     */
    function clearAllForms(){
        var formObj=document.form;
        formObj.sc_no.value="";
        formObj.amdt_seq.value="";
        formObj.prop_no.value="";
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";
        getComboObject(comboObjects, 'prop_srep_cd').SetSelectIndex("");
//        prop_srep_cd.SetSelectIndex(-1);
        formObj.prop_srep_nm.value="";
        getComboObject(comboObjects, 'prop_apro_ofc_cd').SetSelectIndex("");
//        prop_apro_ofc_cd.SetSelectIndex(-1);
        formObj.cust_cnt_cd.value="";
        formObj.cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').SetSelectIndex("");
        formObj.ctrt_cust_val_sgm.value="";
        formObj.ctrt_cust_sls_ofc_cd.value="";

        //getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectIndex("");
        getComboObject(comboObjects, 'ctrt_cust_srep_cd').RemoveAll();	//다른 콤보와 동일한 방식으로 clear되지 않아서 이렇게 처리함
        
        getComboObject(comboObjects, 'cntr_lod_ut_cd').SetSelectIndex("");
        formObj.ctrt_cust_srep_nm.value="";
        formObj.real_cust_cnt_cd.value="";
        formObj.real_cust_nm.value="";
        formObj.real_cust_seq.value="";
        formObj.real_cust_tp_cd.value="";
        formObj.real_cust_val_sgm.value="";
        formObj.real_cust_sls_ofc_cd.value="";
        formObj.real_cust_srep_cd.value="";
        formObj.real_cust_srep_nm.value="";
        formObj.prop_mqc_qty.value="";
        formObj.prop_mvc.value="";
    }
    /**
     * Setting Button, form's enable/disable.<br>
     * Setting all controls related to CUD in case of not created data at Master<br>
     * <br><b>Example :</b>
     * <pre>
     *     buttonControl();
     * </pre>
     * @return
     * @author 
     * @version 2009.07.30
     */
    function buttonControl(){
        var formObj=document.form;
        var sts=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
        var amdt_seq=sheetObjects[0].GetCellValue(1, "amdt_seq");
        var sheetObj=sheetObjects[1];
        try{
        	if (sheetObjects[0].GetCellValue(1, "prc_mst_prop_tp_cd") == "M") {
        		if (sheetObjects[0].GetCellValue(1, "sc_no") == "") {
                    ComBtnDisable("btn_Delete");
                    ComBtnDisable("btn_GoToProposal");
                } else {
                    ComBtnEnable("btn_Delete");
                    ComBtnEnable("btn_GoToProposal");
                }
                ComBtnEnable("btn_Save");
                ComBtnEnable("btn_RowAdd");
                ComBtnEnable("btn_DeleteRow");
                prop_srep_cd.enable=true;
                formObj.prop_apro_ofc_cd.enable=true;
                formObj.prc_ctrt_cust_tp_cd.enable=true;
                formObj.ctrt_cust_srep_cd.enable=true;
                formObj.cntr_lod_ut_cd.enable=true;
                
                formObj.prop_mqc_qty.readOnly=false;
                formObj.ctrt_eff_dt.readOnly=false;
                formObj.ctrt_exp_dt.readOnly=false;
                formObj.prop_ofc_cd.readOnly=false;
                formObj.cust_cnt_cd.readOnly=false;
                formObj.cust_seq.readOnly=false;

                formObj.prop_mqc_qty.disabled=false;
                formObj.ctrt_eff_dt.disabled=false;
                formObj.ctrt_exp_dt.disabled=false;
                formObj.prop_ofc_cd.disabled=false;
                formObj.cust_cnt_cd.disabled=false;
                formObj.cust_seq.disabled=false;

                formObj.prop_mqc_qty.className="input1";
                formObj.ctrt_eff_dt.className="input1";
                formObj.ctrt_exp_dt.className="input1";
                formObj.prop_ofc_cd.className="input1";
                formObj.cust_cnt_cd.className="input1";
                formObj.cust_seq.className="input1";
                formObj.prop_sts.style.display="none";
                sheetObjects[1].SetEditable(1);
                btnImgEnable(document.getElementsByName("btn_ctrt_cust")[0], true);
                btnImgEnable(document.getElementsByName("btns_calendar")[0], true);
            } else {
                ComBtnDisable("btn_Save");
                ComBtnDisable("btn_RowAdd");
                ComBtnDisable("btn_DeleteRow");
                ComBtnDisable("btn_Delete");
                ComBtnDisable("btn_GoToProposal");
                prop_srep_cd.enable=false;
                formObj.prop_apro_ofc_cd.enable=false;
                formObj.prc_ctrt_cust_tp_cd.enable=false;
                formObj.ctrt_cust_srep_cd.enable=false;
                formObj.cntr_lod_ut_cd.enable=false;
                formObj.prop_mqc_qty.readOnly=true;
                formObj.ctrt_eff_dt.readOnly=true;
                formObj.ctrt_exp_dt.readOnly=true;
                formObj.prop_ofc_cd.readOnly=true;
                formObj.cust_cnt_cd.readOnly=true;
                formObj.cust_seq.readOnly=true;

                formObj.prop_mqc_qty.className="input2";
                formObj.ctrt_eff_dt.className="input2";
                formObj.ctrt_exp_dt.className="input2";
                formObj.prop_ofc_cd.className="input2";
                formObj.cust_cnt_cd.className="input2";
                formObj.cust_seq.className="input2";
                formObj.prop_sts.style.display="inline";
                sheetObjects[1].SetEditable(0);
                btnImgEnable(document.getElementsByName("btn_ctrt_cust")[0], false);
                btnImgEnable(document.getElementsByName("btns_calendar")[0], false);
                
                
                formObj.prop_ofc_cd.required=false;
                formObj.ctrt_eff_dt.required=false;
                formObj.ctrt_exp_dt.required=false;
                formObj.cust_cnt_cd.required=false;
                formObj.cust_seq.required=false;
                formObj.prop_mqc_qty.required=false;
                
                formObj.prop_ofc_cd.disabled  =true;
                formObj.ctrt_eff_dt.disabled  =true;
                formObj.ctrt_exp_dt.disabled  =true;
                formObj.cust_cnt_cd.disabled  =true;
                formObj.cust_seq.disabled     =true;
                formObj.prop_mqc_qty.disabled =true;
            }
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
/////////////////////// ONCHANGE (S)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
//  combo   -----
    /**
     * calling function in case of OnChange event in IBCombo   <br>
     * Modifying sheet's column accoring to chosen value in prop_apro_ofc_cd combo<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns 
     * @author 
     * @version 2009.09.10
     */
    function prop_apro_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        com_change_sheet(sheetObj, "prop_apro_ofc_cd");
        var sheetObj2=sheetObjects[1];
        if (sheetObj2.RowCount()> 0) {
            for (var i=1, n=sheetObj2.RowCount(); i <= n ; i++) {
                sheetObj2.SetCellValue(i, "prop_scp_apro_ofc_cd",getComboObject(comboObjects, 'prop_apro_ofc_cd').GetSelectCode(),0);
            }
        }
    }
    /**
     * calling function in case of OnChange event in IBCombo    <br>
     * Modifying sheet's column accoring to chosen value in prop_srep_cd combo prop_srep_cd<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns 
     * @author 
     * @version 2009.09.10
     */
    
    function prop_srep_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];    
        formObj.prop_srep_nm.value=comboObj.GetText(newCode, 1);
        com_change_sheet( sheetObj, "prop_srep_cd" );
        var sheetObj2=sheetObjects[1];
        if (sheetObj2.RowCount()> 0) {
            for (var i=1, n=sheetObj2.RowCount(); i <= n ; i++) {
                sheetObj2.SetCellValue(i, "prop_scp_srep_cd",getComboObject(comboObjects, 'prop_srep_cd').GetSelectCode(),0);
            }
        }
    }
    /**
     * calling function in case of OnChange event in IBCombo   <br>
     * Running below logic accoring to chosen value in ctrt_cust_srep_cd combo<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns 
     * @author 
     * @version 2009.09.10
     */
    function ctrt_cust_srep_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=oldText.split("|");
        if (arrText[1] != null && arrText[1] != undefined){
            formObj.ctrt_cust_srep_nm.value=arrText[1];
        }
        if (newCode != ""){
            formObj.ctrt_cust_sls_ofc_cd.value=getOfficeCd(oldCode);
        }
        com_change_sheet( sheetObj, "ctrt_cust_srep_cd" )
    }
    /**
     * calling function in case of OnChange event in IBCombo    <br>
     * Running below logic after modifying a value in real_cust_srep_cd <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns 
     * @author 
     * @version 2009.09.10
     */
    function real_cust_srep_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
        if (arrText[1] != null && arrText[1] != undefined){
            formObj.real_cust_srep_nm.value=arrText[1];
        }
        if (newCode != ""){
            formObj.real_cust_sls_ofc_cd.value=getOfficeCd(oldCode);
        }
        com_change_sheet( sheetObj, "real_cust_srep_cd" )
    }
    /**
     * calling function in case of OnChange event in IBCombo    <br>
     * Modifying Hidden sheet's column accoring to chosen value in prc_ctrt_cust_tp_cd combo <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns 없음
     * @author 
     * @version 2009.09.10
     */
    function prc_ctrt_cust_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        com_change_sheet( sheetObj, "prc_ctrt_cust_tp_cd" )
    }
    /**
     * calling function in case of OnChange event in IBCombo   <br>
     * Modifying Hidden sheet's column accoring to chosen value in real_cust_tp_cd combo<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns 없음
     * @author 
     * @version 2009.09.10
     */
    function real_cust_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        com_change_sheet( sheetObj, "real_cust_tp_cd" )
    }
    /**
     * Function for Onchange event in IBCombo <br>
     * Running below logic in case of modifying a value in cntr_lod_ut_cd combo <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {string} code Mandatory selected item's value
     * @param {string} text Mandatory selected item's text
     * @returns 
     * @author 
     * @version 2009.09.10
     */
    function cntr_lod_ut_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        com_change_sheet(sheetObj, "cntr_lod_ut_cd");
        var sheetObj2=sheetObjects[1];
        if (sheetObj2.RowCount()> 0) {
            for (var i=1, n=sheetObj2.RowCount(); i <= n ; i++) {
                sheetObj2.SetCellValue(i, "cntr_lod_ut_cd",getComboObject(comboObjects, 'cntr_lod_ut_cd').GetSelectCode(),0);
            }
        }
    }
//    combo (E)   -----
//    form  (S)   -----
    /**
     * Modifying Hidden sheet's column accoring to modified form field's value<br>
     * <br><b>Example :</b>
     * <pre>
     *     com_change_sheet(sheetObj, "svc_scp_cd");
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} colNm 
     * @returns 
     * @author 
     * @version 2009.09.10
     */
    function com_change_sheet(sheetObj, colNm){
        var eleValue="";
	        if(document.getElementById(colNm).type=="text"){
	            switch(colNm){
	                case "ctrt_eff_dt":
	                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
	                    break;
	                case "ctrt_exp_dt":
	                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
	                    break;
	                case "cre_dt":
	                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
	                    break;
	                case "file_dt":
	                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
	                    break;
	//                case "n1st_cmnc_dt":
	//                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
	//                    break;
	                case "cust_seq":
	                    eleValue=ComParseInt(document.getElementById(colNm).value);
	                    break;
	                case "real_cust_seq":
	                    eleValue=ComParseInt(document.getElementById(colNm).value);
	                    break;
	                default:
	                    eleValue=document.getElementById(colNm).value;
	                    break;
	            }
	            sheetObj.SetCellValue(1,colNm,eleValue);
	        }else{
	            sheetObj.SetCellValue(1,colNm,document.getElementById(colNm).GetSelectCode());
	        }
    }
//    form     (E)   -----
//    sheet     (S)   -----
    /**
     * calling function in case of OnChange event  <br>
     * Running below logic in case of modifying effectve date/expired date<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int}Row Index
     * @param {int}Column Index
     * @param {string} Value Mandatory Value
     * @return 
     * @author 
     * @version 2009.06.10
     */
    function sheet1_OnChange(sheetObj, Row, Col)
    {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch(colName)
        {
            case "ctrt_eff_dt":
            	if (sheetObj.GetCellValue(Row,"amdt_seq") == "0"){
            		sheetObj.SetCellValue(Row, "eff_dt",sheetObj.GetCellValue(Row, "ctrt_eff_dt"),0);
//                    sheetObj.CellValue2(Row, "n1st_cmnc_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                }
                break;
            case "ctrt_exp_dt":
            	if (sheetObj.GetCellValue(Row,"amdt_seq") == "0"){
            		sheetObj.SetCellValue(Row, "exp_dt",sheetObj.GetCellValue(Row, "ctrt_exp_dt"),0);
                }
                break;
        }
    }
    /**
     * calling function in case of OnChange event  <br>
     * Running below logic in case of modifying effectve date/expired date<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Row Index
     * @param {int} Col Mandatory,Column Index
     * @param {string} Value Mandatory ,Cell Value
     * @return 
     * @author 
     * @version 2009.06.10
     */
    function sheet2_OnChange(sheetObj, Row, Col)
    {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch(colName)
        {
            case "ctrt_eff_dt":
                var mnEffDt=ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd","-");
                if (mnEffDt == ""){
                    ComShowCodeMessage("PRI01030");
                    sheetObj.SetCellValue(Row,"ctrt_eff_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_eff_dt");
                    return;
                }
                if (mnEffDt > sheetObj.GetCellValue(Row,"ctrt_eff_dt")){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.SetCellValue(Row,"ctrt_eff_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_eff_dt");
                }else{
                	sheetObj.SetCellValue(Row, "eff_dt",sheetObj.GetCellValue(Row, "ctrt_eff_dt"),0);
                    //in case of proposal
//                    sheetObj.CellValue2(Row, "n1st_cmnc_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                }
                break;
            case "ctrt_exp_dt":
                var mnExpDt=ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd","-");
                if (mnExpDt == ""){
                    ComShowCodeMessage("PRI01030");
                    sheetObj.SetCellValue(Row,"ctrt_exp_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");
                    return;
                }
                if (mnExpDt < sheetObj.GetCellValue(Row,"ctrt_exp_dt")){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.SetCellValue(Row,"ctrt_exp_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");
                    return;
                }
                if (sheetObj.GetCellValue(Row, "ctrt_eff_dt") > sheetObj.GetCellValue(Row, "ctrt_exp_dt") ){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.SetCellValue(Row,"ctrt_exp_dt","",0);
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");
                    return;
                }
				sheetObj.SetCellValue(Row, "exp_dt",sheetObj.GetCellValue(Row, "ctrt_exp_dt"),0);
                break;
            case "prop_scp_ofc_cd":
            	var cd=sheetObj.GetCellValue(Row,"prop_scp_ofc_cd");
                formObj.f_cmd.value=COMMAND22;
                var sParam=FormQueryString(formObj)+"&cd="+cd;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
                var arrData=ComPriXml2Array(sXml, "cd|nm");
                if (arrData != null && arrData.length > 0) {
                    //sales Rep
                    setSheetRequestOfficeSaleRep(sheetObj, Row, cd);
                }else{
                    sheetObj.SetCellValue(Row,"prop_scp_ofc_cd","",0);
                }
                break;
        }
    }
    /**
     * calling function in case of OnSearchEnd event OnSearchEnd <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory from server
     * @return 
     * @author 
     * @version 2009.09.10
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
        var formObj=document.form;
        if (sheetObj.RowCount()== 0) {
            doActionIBSheet(sheetObj,formObj,IBCREATE);
            ComOpenWait(false);
            return;
            
        }        
        //re-loading in case of no approval office
//        getComboObject(comboObjects, 'prop_apro_ofc_cd').RemoveAll();
        //ComPriTextCode2ComboItem(appOfcComboValue, appOfcComboText, getComboObject(comboObjects, 'prop_apro_ofc_cd') ,"|","\t" );
        formObj.sc_no.value=sheetObj.GetCellValue(1,"sc_no");
        formObj.prop_no.value=sheetObj.GetCellValue(1,"prop_no");
        formObj.amdt_seq.value=sheetObj.GetCellValue(1,"amdt_seq");
        formObj.ctrt_eff_dt.value=sheetObj.GetCellValue(1,"ctrt_eff_dt");
        formObj.ctrt_exp_dt.value=sheetObj.GetCellValue(1,"ctrt_exp_dt");
        formObj.ctrt_eff_dt.focus();
        formObj.ctrt_exp_dt.focus();
        formObj.prop_sts.value=sheetObj.GetCellValue(1,"prop_sts");
        formObj.prop_ofc_cd.value=sheetObj.GetCellValue(1,"prop_ofc_cd");
//        prop_srep_cd.SetSelectText=sheetObj.GetCellValue(1,"prop_srep_cd");
        formObj.prop_srep_nm.value=sheetObj.GetCellValue(1,"prop_srep_nm");
        formObj.cust_cnt_cd.value=sheetObj.GetCellValue(1,"cust_cnt_cd");
        if (sheetObj.GetCellValue(1, "cust_seq") !="" ){
		formObj.cust_seq.value=ComLpad(sheetObj.GetCellValue(1,"cust_seq"), 6, "0");
        }else{
            formObj.cust_seq.value="";
        }
		getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').SetSelectCode(sheetObj.GetCellValue(1,"prc_ctrt_cust_tp_cd"),false);
		formObj.ctrt_pty_nm.value=sheetObj.GetCellValue(1,"ctrt_pty_nm");
		formObj.ctrt_cust_val_sgm.value=sheetObj.GetCellValue(1,"ctrt_cust_val_sgm");
		formObj.ctrt_cust_sls_ofc_cd.value=sheetObj.GetCellValue(1,"ctrt_cust_sls_ofc_cd");
		getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectCode(sheetObj.GetCellValue(1,"ctrt_cust_srep_cd"),false);
		formObj.ctrt_cust_srep_nm.value=sheetObj.GetCellValue(1,"ctrt_cust_srep_nm");
		formObj.real_cust_cnt_cd.value=sheetObj.GetCellValue(1,"real_cust_cnt_cd");
		if (sheetObj.GetCellValue(1, "real_cust_seq") !="" ){
		formObj.real_cust_seq.value=ComLpad(sheetObj.GetCellValue(1,"real_cust_seq"), 6, "0");
        }else{
            formObj.real_cust_seq.value="";
        }
		formObj.real_cust_nm.value=sheetObj.GetCellValue(1,"real_cust_nm");
		formObj.real_cust_tp_cd.value=sheetObj.GetCellValue(1,"real_cust_tp_cd");
		formObj.real_cust_val_sgm.value=sheetObj.GetCellValue(1,"real_cust_val_sgm");
		formObj.real_cust_sls_ofc_cd.value=sheetObj.GetCellValue(1,"real_cust_sls_ofc_cd");
		formObj.real_cust_srep_nm.value=sheetObj.GetCellValue(1,"real_cust_srep_nm");
		formObj.real_cust_srep_cd.value=sheetObj.GetCellValue(1,"real_cust_srep_cd");
		formObj.prop_mqc_qty.value=sheetObj.GetCellValue(1,"prop_mqc_qty");
        formObj.prop_mqc_qty.focus();
        getComboObject(comboObjects, 'cntr_lod_ut_cd').SetSelectCode(sheetObj.GetCellValue(1,"cntr_lod_ut_cd"),false);
        getComboObject(comboObjects, 'prop_apro_ofc_cd').SetSelectCode(sheetObj.GetCellValue(1,"prop_apro_ofc_cd"),false);
        //Having original duration to compare duration and scope when saving
        var preIbflag=sheetObj.GetRowStatus(1);
        sheetObj.SetCellValue(1,"ctrt_eff_dt_ori",sheetObj.GetCellValue(1,"ctrt_eff_dt"));
        sheetObj.SetCellValue(1,"ctrt_exp_dt_ori",sheetObj.GetCellValue(1,"ctrt_exp_dt"));
        if (sheetObj.GetCellValue(1,"prc_mst_prop_tp_cd") == "P") {
            formObj.prc_mst_prop_tp_nm.value="Proposal";
            formObj.prop_sts.style.display="inline";
        } else if (sheetObj.GetCellValue(1,"prc_mst_prop_tp_cd") == "M") {
            formObj.prc_mst_prop_tp_nm.value="Master";
            formObj.prop_sts.style.display="none";
        }
        //Inputting approval office in case of no approval office in combo 
        var cboObj=getComboObject(comboObjects, 'prop_apro_ofc_cd');
        var aproOfcCd=sheetObj.GetCellValue(1,"prop_apro_ofc_cd");
        if (aproOfcCd !="" && cboObj.FindItem(aproOfcCd, 0) == -1 ){
        	cboObj.InsertItem(0,aproOfcCd + "| "  ,aproOfcCd);
        	cboObj.SetSelectCode(aproOfcCd,false);
        }
        doActionIBSheet(sheet1, document.form, IBSEARCH_ASYNC02);
    }
    /**
     * alling function in case of OnSearchEnd event OnSearchEnd  <br>
     * Running below logic after saving.<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory from server
     * @return 
     * @author 
     * @version 2009.07.21
     */
    function sheet1_OnSaveEnd (sheetObj, errMsg) {
         if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
        	 if (sheetObj.GetCellValue(1, "prop_sts_cd") == "D") {
//                ComPriDeleteCompleted();  // Delete OK
                doActionIBSheet(sheetObj, document.form,IBCREATE);
            } else {
                if (document.form.is_goto_prop.value == "Y") {
                    // Moving Proposal mains creen without OK message
                	window.location.href="/opuscntr/ESM_PRI_0003.do?pgmNo=ESM_PRI_0003&prop_no="+sheetObj.GetCellValue(1,"prop_no");
                    return;
                } else {
                    ComPriSaveCompleted();  // Saving OK
                    doActionIBSheet(sheetObj, document.form,IBSEARCH);
                }
            }
        }
        document.form.is_goto_prop.value="";
    }
    /**
     * calling function in case of OnSearchEnd event OnSearchEnd  <br>
     * Putting a value into added column to calculate MQC
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory from server
     * @return 
     * @author 
     * @version 2009.05.20
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg){
        var sheetObj1=sheetObjects[0];
        var sheetObj2=sheetObj;
        var formObj=document.form;
        for ( var i=1; i <= sheetObj2.RowCount(); i++ ){
        	sheetObj2.SetCellValue(i,"prop_scp_mqc_qty_ori",sheetObj2.GetCellValue(i,"prop_scp_mqc_qty"),0);
        	sheetObj2.SetCellValue(i,"sale_rep_cd",sheetObj2.GetCellValue(i,"prop_scp_srep_cd"),0);
            sheetObj2.SetRowStatus(i,"R");
        }
        //sale rep
        getComboObject(comboObjects, 'prop_srep_cd').SetSelectCode(sheetObj1.GetCellValue(1,"prop_srep_cd"),false);

        //font
        var amdt_seq = formObj.amdt_seq.value;
        var eff_dt   = sheetObj1.GetCellValue(1,"eff_dt");

        if(amdt_seq==0){
            return;
        }

        for(i = 1 ; i <= sheetObj2.RowCount(); i++){
            if(sheetObj2.GetCellValue(i,"ctrt_eff_dt") == eff_dt){
                sheetObj2.SetCellFont("FontColor", i, 1, i, sheetObj2.LastCol(), "#FF0000");
            }
        }
    }

    /**
     * Setting retrieved sales rep according to inputted office into IBMulti Combo<br>
     * <br><b>Example :</b>
     * <pre>
     *        checkRequestOffice();
     * </pre>
     * @return 
     * @author 
     * @version 2009.05.07
     */
    function checkRequestOffice(){
        var formObj=document.form;
        var cd=formObj.prop_ofc_cd.value;
        var sheetObj=sheetObjects[2];
        formObj.f_cmd.value=SEARCH15;
        var sParam=FormQueryString(formObj)+"&etc1="+cd;
        sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
        ComPriXml2ComboItem(sXml,prop_srep_cd, "cd", "cd|nm");
        com_change_sheet( sheetObj, "prop_ofc_cd" );
        formObj.prop_srep_nm.value="";
    }
    /**
     * etting retrieved sales rep according to inputted customer sales office into IBMulti Combo.<br>
     * <br><b>Example :</b>
     * <pre>
     *      setCustSaleRep();
     * </pre>
     * @return 
     * @author 
     * @version 2009.05.07
     */
    function setCustSaleRep(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        if (formObj.cust_cnt_cd.value !="" && formObj.cust_seq.value !=""){
            formObj.f_cmd.value=COMMAND20;
            sParam=FormQueryString(formObj) +"&etc1="+formObj.ctrt_cust_sls_ofc_cd.value+"&etc2="+formObj.cust_cnt_cd.value+"&etc3="+ ComParseInt(formObj.cust_seq.value);
            sXml=sheetObj.GetSearchData("PRICommonGS.do",sParam);
            ComPriXml2ComboItem(sXml,ctrt_cust_srep_cd, "cd", "cd|nm");
        }
    }
    /**
     * Setting retrieved sales rep according to inputted office into IBMulti Combo<br>
     * <br><b>Example :</b>
     * <pre>
     *      setRequestOfficeSaleRep();
     * </pre>
     * @return 
     * @author 
     * @version 2009.05.07
     */
    function setRequestOfficeSaleRep(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        formObj.f_cmd.value=SEARCH15;
        var sParam=FormQueryString(formObj) +"&etc1="+formObj.prop_ofc_cd.value;
        var sXml=sheetObj.GetSearchData("PRICommonGS.do",sParam, {sync:1});
        ComPriXml2ComboItem(sXml,prop_srep_cd, "cd", "cd|nm");
    }
    /**
     * Setting retrieved sales rep according to request office of scope into sheet combo<br>
     * <br><b>Example :</b>
     * <pre>
     *      setSheetRequestOfficeSaleRep(sheetObj, 1, "HAMUR");
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int}     Row      Mandatory ,Selected Row Index
     * @param {string}  offCd    Mandatory Scope's Request Office code
     * @return 
     * @author 
     * @version 2009.05.07
     */
    function setSheetRequestOfficeSaleRep(sheetObj, Row, offCd){
        var formObj=document.form;
        formObj.f_cmd.value=SEARCH15;
        var sParam=FormQueryString(formObj) +"&etc1="+ offCd;
        var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do",sParam);
        var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
        if (arrData !=null && arrData.length > 0){
            var arrCode=arrData[0].split("|");
            var arrText=arrData[1].split("|");
            var aText="";
            if (arrCode != null && arrCode.length > 0){
                for (var i=0; i < arrCode.length; i++){
                    aText += arrCode[i]+"\t"+arrText[i]+"|";
                }
            }
            sheetObj.CellComboItem(Row,"prop_scp_srep_cd", {ComboText:aText, ComboCode:arrData[0]} );
        }
    }
    /**
     * Retrieving Sales Rep's Office Code.<br>
     * <br><b>Example :</b>
     * <pre>
     *      getOfficeCd(srepCd);
     * </pre>
     * @param  {string} srepCd Mandatory sale rep. code
     * @return  string  Office Code
     * @author 
     * @version 2009.05.07
     */
    function getOfficeCd(srepCd){
        document.form.f_cmd.value=COMMAND21;
        var sParam=FormQueryString(document.form)+"&etc1="+srepCd;
        var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", sParam);
        var arrData=ComPriXml2Array(sXml, "cd");
        if (arrData != null && arrData.length > 0) {
            return arrData[0];
        }
        return null;
    }
    /**
     * Clearing HTML object's value related to Customer<br>
     * <br><b>Example :</b>
     * <pre>
     *      clearCustName();
     * </pre>
     * @return 
     * @author 
     * @version 2009.05.07
     */
    function clearCustName(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        sheetObj.SetCellValue(1,"prc_ctrt_cust_tp_cd","");
        sheetObj.SetCellValue(1,"ctrt_pty_nm","");
        sheetObj.SetCellValue(1,"ctrt_pty_addr","");
        sheetObj.SetCellValue(1,"ctrt_cust_val_sgm_cd","");
        sheetObj.SetCellValue(1,"ctrt_cust_val_sgm","");
        sheetObj.SetCellValue(1,"ctrt_cust_srep_cd","");
        sheetObj.SetCellValue(1,"ctrt_cust_sls_ofc_cd","");
        sheetObj.SetCellValue(1,"ctrt_pty_sgn_nm","");//arrText[0][6];
        sheetObj.SetCellValue(1,"ctrt_pty_sgn_tit_nm","");//arrText[0][7];
        formObj.cust_cnt_cd.value="";
        formObj.cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').SetSelectCode("");
        formObj.ctrt_cust_val_sgm.value="";
        formObj.ctrt_cust_sls_ofc_cd.value="";
        formObj.ctrt_cust_srep_nm.value="";
        getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectCode("");
    }
    /**
     * Retrieving Customer information <br>
     * <br><b>Example :</b>
     * <pre>
     *      custNameFind(eleName);
     * </pre>
     * @param  {string} eleName Mandatory Html Object Name
     * @return 없음==
     * @author 
     * @version 2009.05.07
     */
    function custNameFind(eleName){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var cust_cnt_cd=formObj.cust_cnt_cd.value;
        var cust_seq=formObj.cust_seq.value;
        if(cust_cnt_cd != "" && cust_seq !=""){
            var sParam="f_cmd="+SEARCH02+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;
            var sXml=sheetObj.GetSearchData("ESM_PRI_0015GS.do", sParam);
            var arrText=ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_cust_srep_nm|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm");
            if(arrText==undefined){
                clearCustName();
                formObj.cust_cnt_cd.focus();
            }else{
                getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').SetSelectCode("");
                getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectCode("");
                sheetObj.SetCellValue(1,"prc_ctrt_cust_tp_cd",arrText[0][0],0);
                sheetObj.SetCellValue(1,"ctrt_pty_nm",arrText[0][1],0);
                sheetObj.SetCellValue(1,"ctrt_pty_addr",arrText[0][2],0);
                sheetObj.SetCellValue(1,"ctrt_cust_val_sgm_cd",arrText[0][3],0);
                sheetObj.SetCellValue(1,"ctrt_cust_val_sgm",arrText[0][4],0);
                sheetObj.SetCellValue(1,"ctrt_cust_srep_cd",arrText[0][5],0);
                sheetObj.SetCellValue(1,"ctrt_cust_sls_ofc_cd",arrText[0][6],0);
                sheetObj.SetCellValue(1,"ctrt_pty_sgn_nm",arrText[0][8],0);
                sheetObj.SetCellValue(1,"ctrt_pty_sgn_tit_nm",arrText[0][9],0);
                formObj.ctrt_pty_nm.value=arrText[0][1];
                getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd').SetSelectCode(arrText[0][0],false);
                formObj.ctrt_cust_val_sgm.value=arrText[0][4];
                formObj.ctrt_cust_sls_ofc_cd.value=arrText[0][6];
                getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectCode(arrText[0][5],false);
                formObj.ctrt_cust_srep_nm.value=arrText[0][7];
            }
        }
//        else if (cust_cnt_cd == "" || cust_seq ==""){
//          clearCustName();
//        }
//        var sheetObj = sheetObjects[0];
        com_change_sheet(sheetObj, eleName);
    }
    /**
     * Modifying Scope's duration according to condition in case of modifying main duration<br>
     * Modifying scope duration before saving
     * <br><b>Example :</b>
     * <pre>
     *      saveDurationChange();
     * </pre>
     * @param {string} msgPass Mandatory (false : in case of modifying scope's duration without showing message box, true : with showing message box
     * @return 
     * @author 
     * @version 2009.04.17
     */
    function saveChangeDuration(msgPass){
        var sheetObj=sheetObjects[0];
        var sheetObj1=sheetObjects[1];
        var oriCtrtEffDt=sheetObj.GetCellValue(1, "ctrt_eff_dt_ori");
        var oriCtrtExpDt=sheetObj.GetCellValue(1, "ctrt_exp_dt_ori");
        var ctrtEffDt=sheetObj.GetCellValue(1, "ctrt_eff_dt");
        var ctrtExpDt=sheetObj.GetCellValue(1, "ctrt_exp_dt");
        var effChk=0;
        var expChk=0;
        var msgChk=0;
        if (sheetObj.GetRowStatus(1) == "I"){
            return true;
        }
        if (oriCtrtEffDt > ctrtEffDt ){
            effChk=1; //Extending Duration Eff by day
             //but,in case of "No", Extending Proposal Duration Eff only
            for ( var i=1 ; i <=sheetObj1.RowCount(); i++){
            	if (oriCtrtEffDt == sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    msgChk=1;
                    break;
                }
            }
        }else if (oriCtrtEffDt < ctrtEffDt){
            effChk=2; //Reducing Duration Eff by day
            //but, in case of No,return
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (ctrtEffDt >= sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    msgChk=2;
                    break;
                }
            }
        }
        if (oriCtrtExpDt > ctrtExpDt ){ ///Reducing Duration Eff by day
            expChk=1; //Reducing Duration Eff by day
          //but, in case of No,return
            for ( var i=1 ; i <= sheetObj1.RowCount(); i++){
            	if (ctrtExpDt <= sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    msgChk += 3;
                    break;
                }
            }
        }else if (oriCtrtExpDt < ctrtExpDt){
            expChk=2; //Extending Duration Eff by day
            //but,in case of "No", Extending Proposal Duration Eff only
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (oriCtrtExpDt == sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    msgChk += 6;
                    break;
                }
            }
        }
        // after conforming modification by message
        if ((effChk + expChk) == 0){ //Modification of duration 
            return true;
        }
        if (msgPass == "true"){
            msgChk=0;
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
            for ( var i=1 ; i <=sheetObj1.RowCount(); i++){
            	if (oriCtrtEffDt == sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    sheetObj1.SetCellValue(i,"ctrt_eff_dt",ctrtEffDt,0);
                    sheetObj1.SetCellValue(i,"eff_dt",ctrtEffDt,0);
                }
            }
        }else if (effChk == 2){
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (ctrtEffDt >= sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    sheetObj1.SetCellValue(i, "ctrt_eff_dt",ctrtEffDt,0);
                    sheetObj1.SetCellValue(i, "eff_dt",ctrtEffDt,0);
                }
            }
        }
        if (expChk == 1){
            for ( var i=1 ; i <= sheetObj1.RowCount(); i++){
            	if (ctrtExpDt <= sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    sheetObj1.SetCellValue(i,"ctrt_exp_dt",ctrtExpDt,0);
                    sheetObj1.SetCellValue(i,"exp_dt",ctrtExpDt,0);
                }
            }
        }else if (expChk == 2){
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (oriCtrtExpDt == sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    sheetObj1.SetCellValue(i, "ctrt_exp_dt",ctrtExpDt,0);
                    sheetObj1.SetCellValue(i, "exp_dt",ctrtExpDt,0);
                }
            }
        }
        return true;
    }
    /**
     * Setting duration from Popup to duration of main,scope <br>
     * <br><b>Example :</b>
     * <pre>
     *      changeDuration(durData);
     * </pre>
     * @param {object} Mandatory ,Duration from PopUp
     * @return 
     * @author 
     * @version 2009.04.17
     */
    function changeDuration(durData){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var sheetObj1=sheetObjects[1];
        var preIbflag;
        if (durData !=null && durData.length > 0){
            for (var i=0; i < durData.length; i++){
                var arrData=durData[i].split("|");
                if (arrData[0] == ""){
                    formObj.ctrt_eff_dt.value=arrData[1];
                    formObj.ctrt_exp_dt.value=arrData[2];
                    formObj.ctrt_eff_dt.focus();
                    formObj.ctrt_exp_dt.focus();
                    formObj.prop_no.focus();
                    saveChangeDuration("true");
                    sheetObj.SetCellValue(1, "eff_dt",arrData[3],0);
                    sheetObj.SetCellValue(1, "exp_dt",arrData[4],0);
                }else{
                    for (var j=1; j < sheetObj1.RowCount(); j++){
                    	if (sheetObj1.GetCellValue(j, "svc_scp_cd") == arrData[0]){
                    		preIbflag=sheetObj1.GetRowStatus(j);
                            sheetObj1.SetCellValue(j, "ctrt_eff_dt",arrData[1],0);
                            sheetObj1.SetCellValue(j, "ctrt_exp_dt",arrData[2],0);
                            sheetObj1.SetCellValue(j, "eff_dt",arrData[3],0);
                            sheetObj1.SetCellValue(j, "exp_dt",arrData[4],0);
                            sheetObj1.SetRowStatus(j,preIbflag);
                        }
                    }
                }
            }
        }
    }
    /**
     * Setting MQC from PopUp to Main,Scope's MQC<br>
     * <br><b>Example :</b>
     * <pre>
     *      changeMQC(mqcData);
     * </pre>
     * @param {object} Mandatory ,Duration from PopUp
     * @return 
     * @author 
     * @version 2009.04.17
     */
    function changeMQC(mqcData){
        var formObj=document.form;
        var sheetObj=sheetObjects[1];
        var preIbflag;
        if (mqcData !=null && mqcData.length > 0){
            for (var i=0; i < mqcData.length; i++){
                var arrData=mqcData[i].split("|");
                if (arrData[0] == ""){
                    formObj.cntr_lod_ut_cd.value=arrData[1];
                    formObj.prop_mqc_qty.value=arrData[2];
                }else{
                    for (var j=1; j < sheetObj.RowCount(); j++){
                    	if (sheetObj.GetCellValue(j, "svc_scp_cd") == arrData[0]){
                    		preIbflag=sheetObj.GetRowStatus(j);
                            sheetObj.SetCellValue(j, "prop_scp_mqc_qty",arrData[2],0);
                            sheetObj.SetRowStatus(j,preIbflag);
                        }
                    }
                }
            }
        }
    }
    /**
     * Checking whether it's available to process rqeust when clicking Request button <br>
     * <br><b>Example :</b>
     * <pre>
     *         checkRequest
     * </pre>
     * @param {object} Mandatory ,Duration from PopUp
     * @return 
     * @author 
     * @version 2009.04.17
     */
    function checkRequest(){
        document.form.f_cmd.value=SEARCH07;
        var rValue="N"; //prohibition from request
        var sParam=FormQueryString(document.form);
        var sXml=sheetObjects[0].GetSearchData("ESM_PRI_0015GS.do", sParam);
        var arrData=ComPriXml2Array(sXml, "svc_scp_cd");
        if (arrData != null && arrData.length > 0) {
        }else{
            rValue="Y";
        }
        return rValue;
    }
//--> jin add (E)
//    sheet    (E)   -----
/////////////////////////////////////////////////////////////////////////
/////////////////////// ONCHANGE (E)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
    /**
     *  activating, deactivating  image button.<br>
     * <br><b>Example :</b>
     * <pre>
     *    btnImgEnable(obj, true);
     * </pre>
     * @param  {form} obj Mandatory, Html Object
     * @param  {bool} gb  Mandatory, true : activating , false : deactivating 
     * @return 
     * @author 
     * @version 2009.04.17
     */
    function btnImgEnable(obj, gb) {
        if(obj.constructor == String){
            obj=document.getElementsByName(obj)[0];
        }
        var btnStyle=obj.style;
        if (gb){
            btnStyle.cursor="hand";
            btnStyle.filter="";
        } else {
            btnStyle.cursor="auto";
            btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
        }
    }
    /**
     * Calculating MVC (MVC = MQC / Duration valid days x 7)<br>
     * <br>
     * <br><b>Example :</b>
     * <pre>
     *     calcMVC();
     * </pre>
     * @return 
     * @author 
     * @version 2009.07.10
     */
    function calcMVC(){
        var formObj=document.form;
        var mqcQty=ComGetUnMaskedValue(formObj.prop_mqc_qty.value, "int");
        var sDay=formObj.ctrt_eff_dt.value;
        var eDay=formObj.ctrt_exp_dt.value;
        var mvcQty=0;
        var durDay=ComGetDaysBetween(sDay, eDay);
        if (mqcQty != "" && mqcQty != "0") {
            mvcQty=ComRound((mqcQty / durDay * 7),0);
        }
        formObj.prop_mvc.value=mvcQty;
    }
    /**
     * Setting cursor's focus position<br>
     * <br>
     * <br><b>Example :</b>
     * <pre>
     *     firstFocus();
     * </pre>
     * @return 
     * @author 
     * @version 2009.07.30
     */
    function firstFocus(){
        document.form.sc_no.focus();
    }
    
    function setRtnVal(rtnVal) {
    	var formObj=document.form;
        formObj.cust_cnt_cd.value=rtnVal.custCntCd;
        formObj.cust_seq.value=rtnVal.custSeq;
        formObj.ctrt_pty_nm.value=rtnVal.custNm;
        custNameFind("cust_cnt_cd");
        //sale rep
        setCustSaleRep();
        getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectCode(sheetObjects[0].GetCellValue(1,"ctrt_cust_srep_cd"),false);
        com_change_sheet( sheetObjects[0], "cust_seq");
    }

$(function() {

	$("#ctrt_eff_dt, #ctrt_exp_dt").focusout(function() {
		var dateStr = $(this).val().replace(/[^0-9]/g, "");

		var value = dateStr.substr(0, 4);
		if (dateStr.length > 4) { value += "-"; }
		value += dateStr.substr(4, 2);
		if (dateStr.length > 6) { value += "-"; }
		value += dateStr.substr(6, 2);
		$(this).val(value);
	});

});

function btn_ctrt_cust_returnVal(rtnVal) {
	var formObj = document.form;
	if (rtnVal != null){
        formObj.cust_cnt_cd.value=rtnVal.custCntCd;
        formObj.cust_seq.value=rtnVal.custSeq;
        formObj.ctrt_pty_nm.value=rtnVal.custNm;                    
        custNameFind("cust_cnt_cd");
        //sale rep
        setCustSaleRep();
        getComboObject(comboObjects, 'ctrt_cust_srep_cd').SetSelectCode(sheetObjects[0].GetCellValue(1,"ctrt_cust_srep_cd"),false);
        com_change_sheet( sheetObjects[0], "cust_seq");
    }
}

