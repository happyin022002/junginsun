/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0062.js
*@FileTitle  : S/C List Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    //  ===================================================================================
    //  Global Variable
    //  ===================================================================================
    //  Common Global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var comboObjects=new Array();
    var comboCnt=0;
    //  BIZ Global Variable
    var gCurrDate;
     
    
    /** 
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /** 
     * registering IBMultiCombo Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>     
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} combo_obj : IBMultiCombo Object
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
    
    /** 
     * implementing onLoad event handler in body tag <br>
     * adding first-served functions after loading screen. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function loadPage() {
        var form=document.form;	
        //IBMultiCombo 
        comboCnt=comboObjects.length;
        for(var k=0;k<comboCnt;k++){
            initCombo(comboObjects[k],k+1);
        }
        //IBSheet 
        sheet1=sheetObjects[0];
        sheetCnt=sheetObjects.length ;
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); 
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); 
        }
        axon_event.addListenerForm('click', 'obj_click', form);	 
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');	
        ComEnableObject(form.access_date, false); // access date disabled
        gCurrDate=ComGetNowInfo('ymd', '-');
        form.eff_date_from.value=gCurrDate;
        form.eff_date_to.value=gCurrDate;
        initIBComboItem();
        
        //button controll
		var hasUserRole = chkUsrRoleForButton();
		buttonController(hasUserRole);
        
    }
    
    /**
     * Setting item into IBMultiCombo  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.12.15
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(svcScpComboValue,     svcScpComboText,     getComboObject(comboObjects, 'svc_scp_cd'),          "|", "\t" );
        ComPriTextCode2ComboItem(custTpCdComboValue,   custTpCdComboText,   getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(aproOfcCdComboValue,  aproOfcCdComboText,  getComboObject(comboObjects, 'prop_apro_ofc_cd'),    "|", "\t" );
    }
    
    /** 
     * initializing sheet <br>
     * adding first-served functions after loading screen. <br>
     * adding case as numbers of counting sheets. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : Sheet Object
     * @param {int} sheetNo : Sheet Object Tag's ID Serial No  
     * @return N/A
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
	                //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                var HeadTitle1="Seq.|prop_no|S/C No.|AMD\nNo.|SVC\nScope|Customer Name|Customer\nType|MQC|Approval\nOffice|Contract\nOffice|S.Rep|EFF Date|EXP Date|Filed Date|";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                             {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:450,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"prc_ctrt_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fnl_mqc_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prop_apro_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_cust_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"file_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lgcy_if_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetWaitImageVisible(0);
	                SetEllipsis(1);
	                resizeSheet(); //SetSheetHeight(400);
            	}
            	break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    
    /** 
     * setting intial combo value <br>
     * adding case as numbers of counting combos<br>
     * adding first-served functions after loading screen. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBMultiCombo} comboObj : Sheet Object
     * @param {int} comboNo : Object Tag's ID Serial No  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function initCombo(comboObj, comboNo) {
        switch (comboObj.options.id) {
            case "svc_scp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // Only upper case
                    SetMaxLength(3);
                }
                break;
            case "prc_ctrt_cust_tp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // Only upper case
                    SetMaxLength(1);
                }
                break;
            case "prop_apro_ofc_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(100);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // Only upper case
                    SetMaxLength(6);
                }
                break;
            case "sc_type":
                var i=0;
                with (comboObj) {
                    SetDropHeight(100);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // Only upper case
                    SetMaxLength(1);
                    InsertItem(i++, "", "");
                    InsertItem(i++, "Reefer S/C", "R");
                    InsertItem(i++, "Garment S/C", "G");
                    Code="";
                }
                break;
        }
    }
    
    //  ===================================================================================
    //  Event handler processing by button click event
    //  ===================================================================================
    document.onclick=processButtonClick;
    /** 
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
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
            	case "rdoDate":
            		if(rdoDateObj[0].checked){
            			form.access_date.value="";
            			form.access_date.className="input";
            			form.eff_date_from.className="input1";
            			form.eff_date_to.className="input1";
            			
            			if(form.eff_date_from.value.length != 8) {
            				form.eff_date_from.value = gCurrDate;
            				form.eff_date_to.value = gCurrDate;
            			}
            				
            		}
            		else if(rdoDateObj[1].checked) {
            			form.eff_date_from.value="";
            			form.eff_date_to.value="";
            			form.eff_date_from.className="input";
            			form.eff_date_to.className="input";
            			form.access_date.className="input1";
            			
            			if(form.access_date.value.length != 8) {
            				form.access_date.value = gCurrDate;
            			}
            		}
            		break;
                case "btns_calendar1": 
                case "btns_calendar2":
                    if(rdoDateObj[1].checked){
                        return;
                    }
                    var cal=new ComCalendar();
                    if(srcName == "btns_calendar1"){
                        cal.select(form.eff_date_from, 'yyyy-MM-dd');
                    }else{
                        cal.select(form.eff_date_to, 'yyyy-MM-dd');
                    }
                    break;
                case "btns_calendar3": 
                    if(rdoDateObj[0].checked){
                        return;
                    }
                    var cal=new ComCalendar();
                    cal.select(form.access_date, 'yyyy-MM-dd');
                    break;
                case "btn_contract_ofc":	// Getting Office Code 
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 500, "ofc_cd:ctrt_cust_sls_ofc_cd", "1,0,1,1,1,1,1,1", true);
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
                    var currRow=sheet1.GetSelectRow();
                    if(currRow < 1) return;
                    var popParams = "prop_no=" + sheet1.GetCellValue(sheet1.GetSelectRow(),"prop_no") + "&amdt_seq="+sheet1.GetCellValue(sheet1.GetSelectRow(),"amdt_seq");
                    //ComOpenWindowCenter("/opuscntr/ESM_PRI_0061.do?"+popParams, "", 1024, 550, false);	
                    ComOpenPopup("/opuscntr/ESM_PRI_0061.do?"+popParams, 1024, 650,"", "none", true);
                    break;		    		
                case "btn_opensc":
                case "btn_amdhistory":
                    var currRow=sheet1.GetSelectRow();
                    if(currRow < 1) return;
                    var pgmNo="ESM_PRI_0003";
                    if(srcName == "btn_amdhistory") {
                        pgmNo="ESM_PRI_0057";
                    }
                    var scNo=sheet1.GetCellValue(currRow, "sc_no");
                    var popParams="parentPgmNo=ESM_PRI_M001&sc_no=" + scNo + "&sc_no_0062=" + scNo + "&prop_no=" + sheet1.GetCellValue(currRow, "prop_no") + "&amdt_seq=" + sheet1.GetCellValue(currRow, "amdt_seq");
                    comCallPop(pgmNo, "ESM_PRI_0062", popParams, "","");
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
    //  Axson Event Handler
    //  ===================================================================================
    /** 
     * Object's Keypress event handler <br>
     * Checking validation of inputed value according to object's dataformat <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function obj_keypress(){
        var obj=event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus=obj.dataformat;
        switch(obj.dataformat){
            case "ymd": //
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": 
            case "number":    
                ComKeyOnlyNumber(obj);
                break;
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            default:
                //ComKeyOnlyNumber(obj);
                break;
        }
    }
    
    /**
     * Object's Onclick event handler  <br>
     *  Checking validation of inputed value according to object's dataformat   <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.24
     */
    function obj_click(){
        var form=document.form;
        var obj=event.srcElement;
        var objEffDtFrom=form.eff_date_from;
        var objEffDtTo=form.eff_date_to;
        var objAccessDt=form.access_date;
        var tmpDt;
        switch(ComGetEvent("name")){
            case "rdoDate":
                if(obj.value == "2") {
                    tmpDt=objAccessDt.value;
                    objAccessDt.value="";
                    ComEnableObject(objAccessDt, false);
                    ComEnableObject(objEffDtFrom, true);
                    ComEnableObject(objEffDtTo, true);
                    objEffDtFrom.className="input1";
                    objEffDtTo.className="input1";
                    if(tmpDt.length >= 8) {
                        objEffDtFrom.value=tmpDt;
                        objEffDtTo.value=tmpDt;
                    }else{
                        objEffDtFrom.value=gCurrDate;
                        objEffDtTo.value=gCurrDate;
                    }
                }else{
                    tmpDt=objEffDtFrom.value;
                    objEffDtFrom.value="";
                    objEffDtTo.value="";
                    ComEnableObject(objEffDtFrom, false);
                    ComEnableObject(objEffDtTo, false);
                    ComEnableObject(objAccessDt, true);
                    objAccessDt.className="input1";
                    if(tmpDt.length >= 8) {
                        objAccessDt.value=tmpDt;
                    }else{
                        objAccessDt.value=gCurrDate;
                    }
                }
                break;
        }
        //if(obj.dataformat == null) return;
    }
        
    /** 
     *  Object's Onbeforedeactivate event handler<br>
     * Checking validation of inputed value according to object's dataformat  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function obj_deactivate() {
        var formObj=event.srcElement;
        var srcName=formObj.getAttribute("name");
        switch(srcName) {
            case "sc_no_suffix":
            case "ctrt_cust_sls_ofc_cd":
                break;
            default :
                ComChkObjValid(formObj);
        }
    }
    
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**                                                                                            
     *  svc_scp_cd_OnChange event handler <br>      
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBMultiCombo} comboObj                                          
     * @param  {IBMultiCombo} objCd : selected code value                                                 
     * @param  {IBMultiCombo} objTxt : selected code value's text
     * @return N/A                                                                                 
     * @see #                                                                                       
     * @author                                                                                
     * @version 2009.08.12                                                                          
     */
    function svc_scp_cd_OnChange(obj, code, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
        var form=document.form;
        var cText=obj.GetText(newindex, 1);
        form.svc_scp_nm.value=cText;
    }
    
    
    /** 
     * setParamsClear event handler to initialize parameter<br>
     * <br><b>Example :</b>	
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
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
    
    /** 
     * Function to call Retrieving/Saving server function<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object  
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheet1.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: 
                ComOpenWait(true);
                setParamsClear();
                var scTypeCd=sc_type.GetSelectCode();
                var rdoDtObj=formObj.rdoDate;
                formObj.f_cmd.value=SEARCH;
                formObj.sc_no.value=formObj.sc_no_suffix.value;
                if(scTypeCd == "R"){
                    formObj.rf_flg.value="Y";
                }else if(scTypeCd == "G"){
                    formObj.gamt_flg.value="Y";
                }
                if(rdoDtObj[0].checked){
                    formObj.eff_dt.value=formObj.eff_date_from.value;
                    formObj.exp_dt.value=formObj.eff_date_to.value;
                }else{
                    formObj.eff_dt.value=formObj.access_date.value;
                    formObj.exp_dt.value=formObj.access_date.value;
                }
//parameter changed[check again]CLT                 
                var sXml=sheet1.GetSearchData("ESM_PRI_0062GS.do", FormQueryString(formObj));
                form.total_mqc.value=ComAddComma2(ComGetEtcData(sXml, "totalMqc"), "#,###");
                form.noof_sc.value=ComAddComma2(ComGetEtcData(sXml, "numberOfSc"), "#,###");
                sheet1.LoadSearchData(sXml,{Sync:1} );
                ComOpenWait(false);
                break;
            case IBDOWNEXCEL:      //download excel
//method change[check again]CLT
            	if(sheet1.RowCount() < 1){//no data
                	ComShowCodeMessage("COM132501");
                }else{
                	//sheetObject1.Down2Excel({ HiddenColumn:0,TreeLevel:false});
                	sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
                }
                //sheet1.Down2Excel(-1, false, false, true, "", "", false, false, "", false); //, "chk|seq"
                break;
        }
    }
    
    /** 
     * handling process for input validation하는 validateForm <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : Sheet Object  
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function validateForm(sheetObj, formObj, sAction){
        var form=document.form;
        switch (sAction) {
            case IBSEARCH: 
                var rdoDateObj=form.rdoDate;
                if(rdoDateObj[0].checked) {
                    if(!ComChkObjValid(form.eff_date_from)) {return false;}
                    if(!ComChkObjValid(form.eff_date_to)) {return false;}
                }else{
                    var accDtObj=form.access_date;
                    if(!ComChkObjValid(accDtObj)) {return false;}
                    if(accDtObj.value == "") {
                    	ComShowCodeMessage("PRI00335", accDtObj.caption);
                        ComSetFocus(accDtObj);
                    }
                }
                break;
        }
        return true;
    }
    

	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
		sheetObj.ReNumberSeq();    
	}
	
	/**
     * calling function when occurring OnSearchEnd Event <br>
     * setting sheet value with Html Object value after retrieving sheet<br>
     */ 
    function sheet1_OnSearchEnd(sheetObj, errMsg){
    	var hasUserRole = chkUsrRoleForButton();
  		buttonController(hasUserRole);
       
    }  
	
	/**
	 *  checking user role for button
	 */
  	function chkUsrRoleForButton(){
  		var formObj=document.form;
        formObj.f_cmd.value=SEARCH21;        
        
        var sParam=FormQueryString(formObj)+"&xtn_phn_no=PRICD0003";
        var sheetObj=sheetObjects[0];
        sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
        
        var isRole = ComGetEtcData(sXml,"isRole");
        return isRole;
  	}
	  	
	/**
	 *  enable or disable buttons
	 */
  	function buttonController(hasUserRole){
  		if(hasUserRole=="N"){
  			ComBtnDisable("btn_opensc");
  		}else{
  			ComBtnEnable("btn_opensc");
  		}
  	}
