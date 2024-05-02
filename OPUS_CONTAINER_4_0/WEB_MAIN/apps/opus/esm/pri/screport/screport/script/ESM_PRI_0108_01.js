/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0108_01.js
*@FileTitle  : S/C Performance Summary - Summary 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
    //  ===================================================================================
    // Global Variable
    //  ===================================================================================
    // Global Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var sheet2;
    var comboObjects=new Array();
    var comboCnt=0;
    // Column Variable
    var C1_SC_NO="sc_no";
    var C1_SVC_SCP_CD="svc_scp_cd";
    // Global Variable
    var gCurrDate;
    //  ===================================================================================
    // Process Button Event
    //  ===================================================================================
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function processButtonClick(){
        var form=document.form;
        var rdoDateObj=form.rdoDate;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
                case "btns_calendar1": //calendar button
                    var cal=new ComCalendar();
                    cal.select(form.bl_obrd_dt_from, 'yyyy-MM-dd');
                    break;
                case "btns_calendar2":
                    var cal=new ComCalendar();
                    cal.select(form.bl_obrd_dt_to, 'yyyy-MM-dd');
                    break;
                case "btns_calendar3": //Calendar Button
                    var cal=new ComCalendar();
                    cal.select(form.eff_dt, 'yyyy-MM-dd');
                    break;
                case "btns_calendar4": //Calendar Button
                    var cal=new ComCalendar();
                    cal.select(form.exp_dt, 'yyyy-MM-dd');
                    break;
                case "ComOpenPopupWithTarget":  // Popup to retrieve Office Code
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 500, "ofc_cd:ctrt_cust_sls_ofc_cd", "1,0,1,1,1,1,1,1", true);
                    break;
            } //end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    
    //  ===================================================================================
    //  Initializing page
    //  ===================================================================================
    /**
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory, IBSheet Object
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * registering IBMultiCombo Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory, IBMultiCombo Object
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
    
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function loadPage() {
        var form=document.form;
        sheet1=sheetObjects[0];
        sheet2=sheetObjects[1]; // distinct 
        sheetCnt=sheetObjects.length ;
        //Initializing IBMultiCombo
        comboCnt=comboObjects.length;
        for(var k=0;k<comboCnt;k++){
            initCombo(comboObjects[k],k+1);
        }
        //Initializing IBSheet
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); 
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        axon_event.addListenerForm('click', 'obj_click', form);
        axon_event.addListenerForm('blur', 'obj_blur', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');

        gCurrDate=ComGetNowInfo('ymd', '-');
        form.eff_dt.value=gCurrDate;
        form.exp_dt.value=gCurrDate;
        initIBComboItem();
        
    }
    
    /**
     * Setting items to IBMultiCombo  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem();
     * </pre>
     * @return void
     * @author 
     * @version 2009.12.15
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(rhqComboValue,        rhqComboText,        getComboObject(comboObjects, 'rhq'),                 "|", "\t" );
        ComSetMultiComboHeight(rhq);
        ComPriTextCode2ComboItem(aproOfcCdComboValue,  aproOfcCdComboText,  getComboObject(comboObjects, 'prop_apro_ofc_cd'),    "|", "\t" );
        ComSetMultiComboHeight(prop_apro_ofc_cd);
        ComPriTextCode2ComboItem(scNoPrefixComboValue, scNoPrefixComboText, getComboObject(comboObjects, 'sc_no_prefix'),        "|", "\t" );
        ComSetMultiComboHeight(sc_no_prefix);
        ComPriTextCode2ComboItem(svcScpCdComboValue,   svcScpCdComboText,   getComboObject(comboObjects, 'svc_scp_cd'),          "|", "\t" );
        ComPriTextCode2ComboItem(custTpCdComboValue,   custTpCdComboText,   getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
        ComSetMultiComboHeight(prc_ctrt_cust_tp_cd);
        
    }
    
    /**
     * initializing sheet <br>
     * adding first-served functions after loading screen. <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} sheetNo Mandatory, IBSheet Object ,Serial no for Tag's ID
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheet1){
            		var HeadTitle1="Seq.|RHQ|Approval\nOffice|Contract\nOffice|Key\nAC|S/C No.|Customer Name|Sales\nRep.|Type|SVC\nScope|MQC|EFF Date|EXP Date|PFMC (FEU)|MQC\nAttain.(%)|Pro rated\nMQC\nAttain.(%)";

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"rhq_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prop_apro_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"key_acct_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:C1_SC_NO,                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:335,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:C1_SVC_SCP_CD,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fnl_mqc_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",    ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",    ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"mqc_perf",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pro_rt_mqc_perf",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(0);
            		SetWaitImageVisible(0);
                    SetColHidden(C1_SVC_SCP_CD,1);
                    SetSheetHeight(420);
            	}
                break;
            case "sheet2": // For find_text
                with(sheet2){
            		var HeadTitle1="f_text1";

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
                    //DataInsert(-1);
                    SetVisible(false);
                    SetSheetHeight(100);
            	}
                break;
        }
    }
    
    /**
     * setting intial combo value <br>
     * adding first-served functions after loading screen. <br>
     * adding case as numbers of counting sheet <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBMultiCombo} comboObj : sheet Object
     * @param {int} comboNo : comboObject ,Serial no for Tag's ID  
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function initCombo(comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "rhq":
                var i=0;
                with (comboObj) {
                	SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(6);// Maximum Digit is 6
                }
                break;
            case "prop_apro_ofc_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(6);// Maximum Digit is 6
                }
                break;
            case "sc_no_prefix":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(3);
                }
                break;
            case "svc_scp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(3);
                }
                break;
            case "prc_ctrt_cust_tp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(1);
                }
                break;
            case "sc_type":
                var i=0;
                with (comboObj) {
                    //SetDropHeight(100);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    //SetMaxLength(1);
                    InsertItem(i++, "", "");
                    InsertItem(i++, "Reefer S/C", "R");
                    InsertItem(i++, "Garment S/C", "G");
                    SetSelectCode("");
                    SetDropHeight(GetItemHeight() * GetItemCount() +3);
                }
                break;
        }
    }
    
    /**
     * Event Handler : when it has called at main, branching the process <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function mainCallButtonClick(srcName){
        var form=document.form;
        switch(srcName) {
            case "btn_retrieve":
                setParamsClear();
                if (validateForm(sheet2, form, IBSEARCH)) {
                    doActionIBSheet(sheet2, form, IBBATCH);
                }
                break;
            case "btn_bl_list":
                if(sheet1.GetSelectRow()< 0) return;
                sheet1_OnDblClick(sheet1, sheet1.GetSelectRow(), "", 0, 0, 0, 0);
                break;
            case "btn_downexcel":
                doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                break;
        } //end switch
    }
    
    /**
     * Object 's Onclick Event Handler <br>
     * Checking validtaion by object's dataformat <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.09.04
     */
    function obj_click(){
        var form=document.form;
        var obj=ComGetEvent();
        var scopeObj=svc_scp_cd;
        switch(ComGetEvent("name")){
            case "by_scope":
                var tf=true;
                if(obj.checked) {
                    //ComEnableObject(scopeObj, true);
                    scopeObj.SetEnable(1);
                    tf=false;
                    obj.value="Y";
                }else{
                    //ComEnableObject(scopeObj, false);
                    scopeObj.SetEnable(0);
                    obj.value="N";
                }
                sheet1.SetColHidden(C1_SVC_SCP_CD,tf);
                //sheet1.FitColWidth();
                break;
        }
        //if(obj.dataformat == null) return;
    }
    
    /**
     * Handling OnBeforeActivate event <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_blur()
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2010.02.26
     */
   
    function obj_blur() {
        var formObj = event.srcElement;
        var srcName = ComGetEvent("name");//formObj.getAttribute("name");
        switch(srcName) {
            case "sc_no_suffix":
                if(null == comboObjects[2].GetSelectCode() || "" == comboObjects[2].GetSelectCode() ) {
                    formObj.value = "";
                }
                break;
            case "ctrt_cust_sls_ofc_cd":
                break;
            default :
            	ComChkObjValid(ComGetEvent());
        }
    }
    
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**
     * sc_no_prefix_OnChange Event Handler : Execute when selected item of S/C No. Combo Object changed<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} comboObj : ComboObject
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function sc_no_prefix_OnChange(comboObj, Code, Text) {
        var form=document.form;
        if (null == Code || "" == Code) {
            form.sc_no_suffix.value="";
        }
    }
    
    /**
     * OnSearchEnd event Handler : Execute after sheet1 retrieves <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {string} errMsg : error message
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function sheet1_OnSearchEnd(sheetObj, code, errMsg) {
        try {
            var form=document.form;
            var totalMQC=0;
            var noOfSC=0;
            var totalOpCntrQty=0;
            if (sheetObj.RowCount() > 0 && code == 0) {
                totalMQC=sheet1.ComputeSum("|fnl_mqc_qty|");
                totalOpCntrQty=sheet1.ComputeSum("|op_cntr_qty|");
            }
            form.total_mqc.value=ComAddComma2(totalMQC, "#,###");
            totalOpCntrQty=Math.round(totalOpCntrQty);
            form.total_performance.value=ComAddComma2(totalOpCntrQty, "#,###");
            sheet2.DataInsert(-1);
            sheet2.SetCellValue(1, "f_text1","",0);
            var startRow=sheet1.HeaderRows();
            var endRow=sheet1.HeaderRows()+ sheet1.RowCount();
            var chkScNo;
            var chkFindNum;
            var tmpText;
            var noOfSc=0;
            for(var i=startRow; i < endRow; i++) {
            	chkScNo=sheet1.GetCellValue(i, C1_SC_NO);
                chkFindNum=sheet2.FindText("f_text1", "[" + chkScNo + "]", 1, 2, true);
                if(chkFindNum < 0){
                    noOfSc++;
                    tmpText=sheet2.GetCellValue(1, "f_text1");
                    sheet2.SetCellValue(1, "f_text1", "[" + chkScNo + "]", 0);
                }
            }
            form.noof_sc.value=ComAddComma2(noOfSc, "#,###");
        }catch(e){
            ComShowMessage(e.message);
        }
    }
    
    /**
     * sheet1_OnDblClick event Handler : Execute when dclick event triggered on sheet1 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {string} errMsg : error message
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
    	var scNo=sheet1.GetCellValue(Row, C1_SC_NO);
    	var svcScpCd=sheet1.GetCellValue(Row, C1_SVC_SCP_CD);
        var blObrdDtFrom=form.bl_obrd_dt_from.value;
        var blObrdDtTo=form.bl_obrd_dt_to.value;
        if (scNo != "") { // "by scope" means "no scope".
            var popParams="sc_no=" + scNo + "&svc_scp_cd=" + svcScpCd + "&bl_obrd_dt_from=" + blObrdDtFrom + "&bl_obrd_dt_to=" + blObrdDtTo;
//            comCallPop("ESM_PRI_0111", "ESM_PRI_0108_01", popParams, "");
            ComOpenPopup('ESM_PRI_0111.do?'+popParams, 900, 500, "", "0,1", false);
            
            
        }
    }
    
    /**
     * Initializing parameter to retrieve sheet1 data <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.09.01
     */
    function setParamsClear() {
        var form=document.form;
        for(var i=0; i < form.length; i++){
            var formObj=form.elements[i];
            if(formObj.id == "searchParam") {
                formObj.value="";
            }
        }
    }
    
    //  ===================================================================================
    // Retrieve/Save at Server
    //  ===================================================================================
    /**
     * Retrieivng and saving <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj :form Object
     * @param  {sAction} sAction Mandatory ,Process Contant value
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheet1.ShowDebugMsg(false);
        switch(sAction) {
            case IBBATCH: //backendjob
                try {
                    ComOpenWait(true);
                    sheet1.SetWaitImageVisible(0);
                    sheet2.SetWaitImageVisible(0);
                    var scTypeCd=sc_type.GetSelectCode();
                    var rdoDtObj=formObj.rdoDate;
                    formObj.sc_no.value=sc_no_prefix.GetSelectCode()+ formObj.sc_no_suffix.value;
                    if(scTypeCd == "R"){
                        formObj.rf_flg.value="Y";
                    }else if(scTypeCd == "G"){
                        formObj.gamt_flg.value="Y";
                    }
                    formObj.f_cmd.value=COMMAND01;
//parameter changed[check again]CLT
                    var sXml=sheetObj.GetSearchData("ESM_PRI_0108_01GS.do", FormQueryString(formObj));
                    var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value=backendJobKey;
                        sheet2.SetWaitTimeOut(10000);
                        timer=setInterval(getBackEndJobStatus, 3000); // after 3 seconds
                        // recursive calling
                        // Execute - Recursive Call
                    }else{
                        ComOpenWait(false);
                    }
                }catch(e){
                    ComShowMessage(e.message);
                    ComOpenWait(false);
                }
                break;
            case IBSEARCH: 
                ComOpenWait(true);
                var scTypeCd=sc_type.GetSelectCode();
                var rdoDtObj=formObj.rdoDate;
                formObj.sc_no.value=formObj.sc_no_prefix.GetSelectCode()+ formObj.sc_no_suffix.value;
                if(scTypeCd == "R"){
                    formObj.rf_flg.value="Y";
                }else if(scTypeCd == "G"){
                    formObj.gamt_flg.value="Y";
                }
                formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
                sheet1.DoSearch("ESM_PRI_0108_01GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBDOWNEXCEL:      //download excel
//method change[check again]CLT
            	if(sheet1.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), Merge:1 });
            	}
                break;
        }
    }
    
    /**
     * Checking if BackEndJob Status='3' <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function getBackEndJobStatus() {
        try {
            var form=document.form;
            form.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
            var sXml=sheet2.GetSearchData("ESM_PRI_0108_01GS.do", FormQueryString(form));
            var jobState=ComGetEtcData(sXml, "jb_sts_flg");
            if (jobState == "3") {
                getBackEndJobLoadFile();
                clearInterval(timer);
            } else if (jobState == "4") { 
                ComShowCodeMessage("PRI00338"); //msgs['PRI00338']='Failed to download. Please try again.';
                clearInterval(timer);
                ComOpenWait(false);
            } else if (jobState == "5") {
                ComShowCodeMessage("PRI00339"); //msgs['PRI00339']='Data was downloaded successfully.';
                clearInterval(timer);
                ComOpenWait(false);
            }
        }catch(e){
            ComShowMessage(e.message);
            ComOpenWait(false);
        }
    }
    
    /**
     * downloading result file of BackEndJob<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function getBackEndJobLoadFile() {
        try {
            var form=document.form;
            form.f_cmd.value=SEARCHLIST;
            
            var sXml=sheet1.GetSearchData("ESM_PRI_0108_01GS.do", FormQueryString(form));
            sheet1.LoadSearchData(sXml,{Sync:1} );
        }catch(e){
            ComShowMessage(e.message);
        }finally{
            ComOpenWait(false);
        }
    }
    
    /**
     * chkEffDate : Check the validation rules on value of objects in windows <br>
     * validating period. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} formObj :form Object
     * @return {boolean}
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function chkEffDate(formObj) {
        var form=document.form;
        var effDt=form.eff_dt;
        var expDt=form.exp_dt;
        var fromVal=effDt.value.replace(/-/g,'');
        var toVal=expDt.value.replace(/-/g,'');
        var fromAddM=ComGetDateAdd(ComGetDateAdd(fromVal, "M", 3, "", true), "D", -1, "", true);
        if( parseInt(toVal,10) > parseInt(fromAddM,10) ) {
            ComShowCodeMessage("PRI00308", "check the date range!.", " Maximum date range is 3 months");
            //event.returnValue=false;
            ComSetFocus(formObj);
            return false;
        }
        return true;
    }
    
    /**
     * handling process for input validation <br>
     * validating period. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} formObj :form Object
     * @return {boolean}
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function chkObrdDate(formObj) {
        var form=document.form;
        var blObrdDtFrom=form.bl_obrd_dt_from;
        var blObrdDtTo=form.bl_obrd_dt_to;
        var fromVal=blObrdDtFrom.value.replace(/-/g,'');
        var toVal=blObrdDtTo.value.replace(/-/g,'');
        if(fromVal != "" && toVal != "") {
            if( parseInt(fromVal,10) > parseInt(toVal,10) ) {
                //msgs['PRI00305'] = '{?msg1} start date can not be greater than end date.';
                ComShowCodeMessage("PRI00305", formObj.caption);
                //event.returnValue=false;
                ComSetFocus(formObj);
                return false;
            }
        }
        return true;
    }
    
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object
     * @param  {object} formObj :form Object
     * @param  {sAction} sAction Mandatory ,Process Contant value
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */
    function validateForm(sheetObj, formObj, sAction){
        var form=document.form;
        var effDtObj=form.eff_dt;
        var expDtObj=form.exp_dt;
        var obrdFromDtObj=form.bl_obrd_dt_from;
        var obrdToDtObj=form.bl_obrd_dt_to;
        var scNoPrefixObj=form.sc_no_prefix;
        var scNoSuffixObj=form.sc_no_suffix;
        var propAproOfcCd=form.prop_apro_ofc_cd;
        switch (sAction) {
            case IBSEARCH:
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
                break;
        }
        return true;
    }

	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
		sheetObj.ReNumberSeq();    
	}

    