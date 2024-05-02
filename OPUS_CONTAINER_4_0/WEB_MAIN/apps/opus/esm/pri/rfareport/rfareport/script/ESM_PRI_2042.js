/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2042.js
*@FileTitle  : RFA Rate Search 
*@author     : CLT
*@version    : 1.0
=========================================================*/

    //  global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var sheet2;
    var comboObjects=new Array();
    var comboCnt=0;
    var gCurrDate;
    var gSheet1Width=0;
    var gCallBackComEns041;
    var ROW_SUBSUM_GROUP="row_subsum_group";
    var SUBSUM_GROUP="subsum_group";
    var SVC_SCP_CD="svc_scp_cd";
    var CMDT_HDR_SEQ="cmdt_hdr_seq";
    var ROUT_SEQ="rout_seq";
    var RT_SEQ="rt_seq";							
    var RFA_NO="rfa_no";
    var PRE_RATE="fnl_frt_rt_amt"; 
    var RATE="rate";
    var RATE_USD="rate_usd";
    
	/**
	 * registering IBSheet Object as list <br>
	 * adding process for list in case of needing batch processing with other items  <br>
	 * defining list on the top of source <br>
	 */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
	/**
	* registering IBCombo Object as list  <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
    
    /** 
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br> 
     */ 
    function loadPage() {
        var form=document.form;	
        sheet1=sheetObjects[0];
        sheet2=sheetObjects[1]; 
        sheetCnt=sheetObjects.length ;
        comboCnt=comboObjects.length;
        for(var k=0;k<comboCnt;k++){
            initCombo(comboObjects[k],k+1);
        }
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); 
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); 
        }
        sheet1.SetWaitImageVisible(0);
        axon_event.addListenerForm('click', 'obj_click', form);	 
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
        axon_event.addListenerForm('blur', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
        ComEnableObject(form.access_date, false); // access date disabled
        gCurrDate=ComGetNowInfo('ymd', '-');
        form.access_date.value = gCurrDate;
        ComEnableObject(form.access_date, true); // access date enabled
        ComEnableObject(form.eff_date_from, false); // eff_date_from disabled
        ComEnableObject(form.eff_date_to, false); // eff_date_to disabled
        initIBComboItem();
        
    }
    
    /**
     * setting Item in IBMultiCombo<br>
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(svcScpCdComboValue,     svcScpCdComboText,    	getComboObject(comboObjects, 'svc_scp_cd'),       	 "|", "\t" );      
        ComPriTextCode2ComboItem(chargeComboValue,       chargeComboText,       getComboObject(comboObjects, 'chg_cd'), 		     "|", "\t" );
        getComboObject(comboObjects, 'chg_cd').SetSelectCode("OFT",false);
        ComPriTextCode2ComboItem(tpSzComboValue,         tpSzComboText,         getComboObject(comboObjects, 'rat_ut_cd'),           "|", "\t" );
        ComPriTextCode2ComboItem(cargoTypeComboValue,    cargoTypeComboText,    getComboObject(comboObjects, 'prc_cgo_tp_cd'),       "|", "\t" );    
        ComPriTextCode2ComboItem(customerTypeComboValue, customerTypeComboText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(rateComboValue,   		 rateComboValue,    	getComboObject(comboObjects, 'fnl_frt_rt'),       	 "|", "\t" );  
        ComPriTextCode2ComboItem(rateComboValue,    	 rateComboValue,    	getComboObject(comboObjects, 'fnl_mqc'),       		 "|", "\t" );      
    }
    
    /** 
     * Initializing and setting Sheet basics <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     * adding case as numbers of counting sheets. <br> 
     */ 
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheet1){
            		var HeadTitle1="Seq.|row_subsum_group|subsum_group|svc_scp_cd|rt_seq|RFA Number|prop_no|AMD\nNo.|Customer|MVC\n(TEU)|Request\nOffice|Sales\nRep.|CMDT\nSeq.|Commodity|Actual\nCustomer|Route\nSeq.|Origin\n(POR)|Origin Via\n(POL)|Dest Via\n(POD)|Dest.\n(DEL)|R/D\nTerm|Charge|Cargo\nType|Per|Cur.|Previous\nRate|Rate|Rate USD|Diff|Effective\nDate|Route\nNote|CMDT\nNote|Special\nNote";

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Seq",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
            		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:ROW_SUBSUM_GROUP,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:SUBSUM_GROUP,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:SVC_SCP_CD,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:RT_SEQ,                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:RFA_NO,                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",    ColMerge:0,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:245,  Align:"Center",  ColMerge:0,   SaveName:"cust_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"fnl_mqc_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:73,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:CMDT_HDR_SEQ,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"act_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:ROUT_SEQ,               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"org_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_via_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dest_via_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dest_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:47,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:PRE_RATE,               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:RATE,                   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:RATE_USD,               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"diff_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rnote_flag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cnote_flag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"snote_flag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
               
            		InitColumns(cols);

            		SetEditable(0);
            		SetEllipsis(1);
                    SetExtendLastCol(1);
                    SetColHidden(ROW_SUBSUM_GROUP,1);
                    SetColHidden(SUBSUM_GROUP,1);
                    SetColHidden(SVC_SCP_CD,1);
                    //SetColHidden(CMDT_HDR_SEQ,1);
                    //SetColHidden(ROUT_SEQ,1);
                    SetColHidden(RT_SEQ,1);
                    SetColHidden("rcv_de_term_cd",1);
                    SetColHidden(PRE_RATE,1);
                    SetColHidden("diff_amt",1);
                    SetColHidden("eff_dt",1);
                    resizeSheet(); //SetSheetHeight(340);
            	}
                break;
            case "sheet2": // find_text
                with(sheet2){
            		var HeadTitle1="f_text1";

	            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            		InitHeaders(headers, info);
	
	            		var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	               
	            		InitColumns(cols);
	            		SetEditable(1);
	                    var idx=sheet2.DataInsert();
	                    SetVisible(false);
            	}
                break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    
    /**
     * initializing combo, header <br>
     * adding case in case of multiple combo <br>
     */
    function initCombo(comboObj, comboNo) {
        switch (comboObj.options.id) {
            // svc scope
            case "svc_scp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);
                    SetMaxLength(3);
                }
                break;
                // charge
            case "chg_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);
                    SetMaxLength(3);
                }
                break;
                // tp sz
            case "rat_ut_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);     
                    SetMaxLength(2);
                }
                break;
                // cargo type
            case "prc_cgo_tp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);    
                    SetMaxLength(2);
                }
                break;
                //customer type
            case "prc_ctrt_cust_tp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);     
                    //SetMaxLength(6);
                }
                break;
                // rate			
            case "fnl_frt_rt":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    SetMaxLength(2);
                }
                break;
                // mqc
            case "fnl_mqc":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    SetMaxLength(2);
                }
                break;
        }
    }
    
    document.onclick=processButtonClick;
    /** 
     * Event handler processing by button name  <br>
     */ 
    function processButtonClick(){
        var form=document.form;
        var rdoDateObj=form.rdoDate;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            
            switch(srcName) {
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
                case "btn_cust":
                case "btn_ctrt_cust":
                    gCallBackComEns041=srcName;
                    //btn_cust
                    var custCd=form.cust_cnt_cd.value + form.cust_seq.value;
                    if(form.cust_cnt_cd.value == ""){
                        custCd="";
                    }
                    //btn_ctrt_cust
                    if(srcName == "btn_ctrt_cust") {
                        custCd=form.ctrt_cust_cnt_cd.value + form.ctrt_cust_seq.value;
                        if(form.ctrt_cust_cnt_cd.value == ""){
                            custCd="";
                        }
                    }
                    ComOpenPopup("/opuscntr/COM_ENS_041.do?cust_cd="+custCd, 770, 470, "callBackComEns041", '1,0,1,1,1,1,1', true);
                    break;   
                case "btn_commodity": //prc_cmdt_def_cd
                    var param="";
                    ComOpenPopup("/opuscntr/COM_ENS_011.do" + param, 780, 445, "getCOM_ENS_011", "1,0,1,1,1,1,1", true);
                    break;
                case "ComOpenPopupWithTarget":	 
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 500, "ofc_cd:prop_scp_ofc_cd", "1,0,1,1,1,1,1,1", true);
                    searchSRep();
                    break;
                case "btn_retrieve":
                    setParamsClear();
                    if (validateForm(sheet1, form, IBSEARCH)) {
                        doActionIBSheet(sheet2, form, IBBATCH);
                    }
                    break;
                case "btn_new":
                    doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;
                case "btn_viewrfa":
                    if(sheet1.RowCount() <= 0) {
                    	return false;
                    }
                    var params="&s_rfa_no=" + sheet1.GetCellValue(sheet1.GetSelectRow(), "rfa_no");                 
                    var sUrl="ESM_PRI_2019.do?parentPgmNo=ESM_PRI_M001&pgmNo=ESM_PRI_2019&MENU=Y&menuflag=true&mainPage=true" + params;	
                    var sId="ESM_PRI_2019";
                    var winObj=window.open("/opuscntr/"+sUrl , sId);
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
     * handling OnKeyPress events <br>
     * handling process for input validation by object's dataformat   <br>
     */ 
    function obj_keypress(){
        var obj=event.srcElement;
        var srcName=obj.getAttribute("name");
        if (event.keyCode == 13 && document.form.svc_scp_cd.value !=""){
	        switch(srcName) {
	        case "cust_seq":
	        case "ctrt_cust_seq":
	            if (obj.value.length < 6 && obj.value.length != 0 ){
	            	obj.value=ComLpad(obj.value, 6, "0");
	            }
	            break;
	        }
        }
        if(obj.dataformat == null) return;
        window.defaultStatus=obj.dataformat;
        switch(obj.dataformat){
            case "ymd":
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": 
            case "number": //number only
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
     * Object's Onclick event handler <br>
     * handling process for input validation by object's dataformat   <br>
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
                    objAccessDt.value="";
                    ComEnableObject(objAccessDt, false);
                    ComEnableObject(objEffDtFrom, true);
                    ComEnableObject(objEffDtTo, true);
                    objEffDtFrom.className="input1";
                    objEffDtTo.className="input1";
                    objAccessDt.className="input";
                    objEffDtFrom.focus();
                }else{
                    tmpDt=objEffDtFrom.value;
                    objEffDtFrom.value="";
                    objEffDtTo.value="";
                    ComEnableObject(objEffDtFrom, false);
                    ComEnableObject(objEffDtTo, false);
                    ComEnableObject(objAccessDt, true);
                    objEffDtFrom.className="input";
                    objEffDtTo.className="input";
                    objAccessDt.className="input1";
                    if(tmpDt.length >= 8) {
                        objAccessDt.value=tmpDt;
                    }else{
                        objAccessDt.value=gCurrDate;
                    }
                }
                break;
            case "chkDisplay":
                var colNm=obj.value;
                var colWidth=sheet1.GetColWidth(colNm);
                var bool=true;
                if(obj.checked){
                    bool=false;
                }
                sheet1.SetColHidden(colNm,bool);
                if(bool) {
                    gSheet1Width=gSheet1Width - colWidth;	 		
                } else {
                    gSheet1Width=gSheet1Width + colWidth;	 		
                }
                break;
            case "previous_rate":
                var chgCdObj=chg_cd;
                if(obj.checked) {
                    chgCdObj.SetSelectCode("OFT",false);
                    chgCdObj.SetEnable(0);
                    obj.value="Y";
                    sheet1.SetColHidden(PRE_RATE,0);
                    sheet1.SetColHidden("diff_amt",0);
                    sheet1.SetColHidden("eff_dt",0);
                }else{
                    chgCdObj.SetEnable(1);
                    obj.value="N";
                    sheet1.SetColHidden(PRE_RATE,1);
                    sheet1.SetColHidden("diff_amt",1);
                    sheet1.SetColHidden("eff_dt",1);
                }
                break;
        }
    }
    
    /** 
     * Object's OnBlur event handler <br>
     *handling process for input validation by object's dataformat   <br>
     */ 
    function obj_deactivate() {
        var formObj=event.srcElement;
        var srcName=formObj.getAttribute("name");
        switch(srcName) {
            case "rfa_no": // RFA No. 
            case "prc_cmdt_def_cd": // Commodity
            case "prop_scp_ofc_cd":
            case "prop_scp_srep_cd":
                break;
            case "cust_seq":
            case "ctrt_cust_seq":
                if (formObj.value.length < 6 && formObj.value.length != 0 ){
                    formObj.value=ComLpad(formObj.value, 6, "0");
                }
                break;
            default :
                ComChkObjValid(formObj);
        }
        switch(srcName) {
            case "prop_scp_ofc_cd":
                searchSRep();
                break;
        }
    }
    
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**                                                                                            
     *  CallBack function for getting Actual Coustomer, Coustomer code <br>                                                                               
     */  
    function callBackComEns041(rArray){
        var form=document.form;
        if(rArray != null){
            var colArray=rArray[0];
            var ctrtCustCntCd=colArray[3].substring(0,2); 
            var ctrtCustSeq=ComLpad(colArray[3].substring(2),6,"0");
            if(gCallBackComEns041 == "btn_cust") {
                form.cust_cnt_cd.value=ctrtCustCntCd;
                form.cust_seq.value=ctrtCustSeq;
            }else if(gCallBackComEns041 == "btn_ctrt_cust"){
                form.ctrt_cust_cnt_cd.value=ctrtCustCntCd;
                form.ctrt_cust_seq.value=ctrtCustSeq;
            }
        }                   
    }
    
    /**                                                                                            
     * Returning select value of Rep. Commodity pop-up <br>                                                                                
     */  
    function getCOM_ENS_011(rowArray){
        var form=document.form;
        var colArray=rowArray[0];
        form.prc_cmdt_def_cd.value=colArray[2]; // Commodity - cmdt_cd
    }
    
    /**                                                                                            
     * when changing svc scope's combo selection<br>                                                                             
     */
    function svc_scp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, Text, Code) {
        var form=document.form;
        var text=comboObj.GetText(Code, 1);
        form.svc_scp_nm.value=text;
    }
    
    /** 
     * when retrieving S.Rep, calling function  <br>
     */
    function searchSRep() {
        return true;
    }
    
    /** 
     * calling when S.Rep combo focus out <br>
     */
    function prop_scp_srep_cd_OnBlur(actObj) {
        var form=document.form;
        var code=actObj.GetSelectCode();
        var text=actObj.GetText(code, 1);
        form.prop_scp_srep_nm.value=text;
    }
    
    /**                                                                                            
     * Return the selected code of Rep. Commodity Popup <br>      
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBSheet} sheetObj : sheet object                                        
     * @param  {Long} Row : Cell's Row Index                                              
     * @param  {Long} Col : Cell's Column Index  
     * @param  {String} Value : Modified Value, The value used at saving, not applied format.
     * @return void                                                                                 
     * @see #                                                                                       
     * @author                                                                                
     * @version 2009.08.12                                                                          
     */  
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        var form=document.form;
        var colName=sheet1.ColSaveName(Col);
        switch(colName){
            case "rnote_flag":
            	var flag=sheet1.GetCellValue(Row, "rnote_flag");
            	if(flag == "N") return;
            	var pgmNo="ESM_PRI_0034";
            	var propNo=sheet1.GetCellValue(Row, "prop_no");
                var amdtSeq=sheet1.GetCellValue(Row, "amdt_seq");
                var svcScpCd=sheet1.GetCellValue(Row, "svc_scp_cd");
                var genSpclRrtTpCd=sheet1.GetCellValue(Row, "gen_spcl_rt_tp_cd");
                var cmdtHdrSeq=sheet1.GetCellValue(Row, "cmdt_hdr_seq");
                var routSeq=sheet1.GetCellValue(Row, "rout_seq");
                var sParam="is_sc=N&note_gubun=R&prop_no=" + propNo + "&amdt_seq=" + amdtSeq + "&svc_scp_cd=" + svcScpCd + "&gen_spcl_rt_tp_cd=" + genSpclRrtTpCd;
                sParam += "&cmdt_hdr_seq=" + cmdtHdrSeq + "&rout_seq=" + routSeq;
            	ComOpenPopup('/opuscntr/ESM_PRI_0034_POP.do?'+sParam, 550, 355, pgmNo, '0,0', true);
                break;
            case "cnote_flag":
            	var flag=sheet1.GetCellValue(Row, "cnote_flag");
            	if(flag == "N") return;
            	var pgmNo="ESM_PRI_0034";
            	var propNo=sheet1.GetCellValue(Row, "prop_no");
                var amdtSeq=sheet1.GetCellValue(Row, "amdt_seq");
                var svcScpCd=sheet1.GetCellValue(Row, "svc_scp_cd");
                var genSpclRrtTpCd=sheet1.GetCellValue(Row, "gen_spcl_rt_tp_cd");
                var cmdtHdrSeq=sheet1.GetCellValue(Row, "cmdt_hdr_seq");
                var sParam="is_sc=N&note_gubun=C&prop_no=" + propNo + "&amdt_seq=" + amdtSeq + "&svc_scp_cd=" + svcScpCd + "&gen_spcl_rt_tp_cd=" + genSpclRrtTpCd;
                sParam += "&cmdt_hdr_seq=" + cmdtHdrSeq;
                ComOpenPopup('/opuscntr/ESM_PRI_0034_POP.do?'+sParam, 550, 355, pgmNo, '0,0', true);
                break;
            case "snote_flag":
            	var flag=sheet1.GetCellValue(Row, "snote_flag");
            	if(flag == "N") return;
            	var pgmNo="ESM_PRI_0034";
            	var propNo=sheet1.GetCellValue(Row, "prop_no");
                var amdtSeq=sheet1.GetCellValue(Row, "amdt_seq");
                var svcScpCd=sheet1.GetCellValue(Row, "svc_scp_cd");
                var sParam="is_sc=N&note_gubun=S&prop_no=" + propNo + "&amdt_seq=" + amdtSeq + "&svc_scp_cd=" + svcScpCd;
            	ComOpenPopup('/opuscntr/ESM_PRI_0034_POP.do?'+sParam, 550, 355, pgmNo, '0,0', true);
                break;
                
            case "cmdt_nm":
            	ComShowMemoPad(sheetObj, Row, Col, true, 500, 200);
            	break;  
            	
            case "org_pnt_loc_def_cd":	
            case "org_via_nm":	
            case "dest_via_nm":	
            case "dest_pnt_loc_def_cd":	
            	ComShowMemoPad(sheetObj, Row, Col, true, 300, 150);
            	break; 
            	
        }
    }
    
    /**
	 * Calling Function in case of OnSearchEnd event <br>
	 * Summarizing accepted data count and un-accepted data count
	 * In case of S/C,Retrieving count when getting General/Special Type information
	 * In case of RFA, using this way
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {Long} Processing result code (0 is success, others should be processed as error)
	 * @param {string} Processing result message
	 * @param {Integer} HTTP response code
	 * @param {string} HTTP response message
	 * @return N/A
	 */
    function sheet1_OnSearchEnd(sheetObj, code, msg, stCode, stMsg) {
    	if(code == 0) {
            var form=document.form;
            var chargeObj=comboObjects[1];
            if(sheet1.RowCount()> 0) {
                ComOpenWait(true);			
                
                var redColor="#FF0000";
                var blueColor="#0000FF";
                var startRow=sheet1.HeaderRows();
                var endRow=sheet1.HeaderRows()+ sheet1.RowCount();
                var chkDiffAmt=0;
                for(var i=startRow; i < endRow; i++) {
                	chkDiffAmt=sheet1.GetCellValue(i, "diff_amt");
                    if( null != chkDiffAmt && "" != chkDiffAmt ) {
                        if( parseFloat(chkDiffAmt) > 0 ) {
                        	sheet1.SetCellFontColor(i, "diff_amt",blueColor);
                        }else{
                        	sheet1.SetCellFontColor(i, "diff_amt",redColor);
                        }
                    }
                    
                    //Flag Color
                    var rnote=sheet1.GetCellValue(i, "rnote_flag");
    				if (rnote == "Y"){		
    					sheet1.SetCellFontColor(i,"rnote_flag",redColor);			 
    				}else{
    					sheet1.SetCellFontColor(i,"rnote_flag","");			
    				}
    				var cnote=sheet1.GetCellValue(i, "cnote_flag");
    				if (cnote == "Y"){		
    					sheet1.SetCellFontColor(i,"cnote_flag",redColor);			 
    				}else{
    					sheet1.SetCellFontColor(i,"cnote_flag","");			
    				}
    				var snote=sheet1.GetCellValue(i, "snote_flag");
    				if (snote == "Y"){		
    					sheet1.SetCellFontColor(i,"snote_flag",redColor);			 
    				}else{
    					sheet1.SetCellFontColor(i,"snote_flag","");			
    				}
                }
                /*
                 * 2016.11.03 : This logic purpose is to get subsum of all charge code amount (OFT, CAF, BAF, PSC) by each rate sequence.
                 * 					    However only OFT Charge code exists now, so this logic is unnecessary.
                 * 
                if(null == chargeObj.GetSelectCode()|| "" == chargeObj.GetSelectCode()) {
                    //var subSumStdColNm = SUBSUM_GROUP;
                    var subSumStdColNm=ROW_SUBSUM_GROUP;
                    var subSumColNm=RATE_USD;
                    var realSumColNm="seq=;curr_cd=USD;" + RATE + "=|" + RATE_USD + "|";
                    sheet1.ShowSubSum([{StdCol:subSumStdColNm, SumCols:subSumColNm, Sort:false, ShowCumulate:false, CaptionCol:-1, CaptionText:realSumColNm, AvgCols:""}]);
                    var subSumRows=sheet1.FindSubSumRow(subSumStdColNm);
                    var subSumArr=subSumRows.split("|");
                    var subSumArrLen=subSumRows.split("|").length - 1;
                    for(var i=0; i < subSumArrLen; i++) {
                    	sheet1.SetCellFont("FontBold", subSumArr[i], "curr_cd", subSumArr[i], RATE,1);
                    }
                }
                */

                ComOpenWait(false);			
            }
        }
    }
    
    /** 
     * initializing parameter for retrieving sheet1 <br>
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
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheet1.ShowDebugMsg(false);
        switch(sAction) {
            case IBBATCH: //backendjob retrieve
                try {
                    var rdoDtObj=formObj.rdoDate;
                    if(rdoDtObj[0].checked){
                        formObj.eff_dt.value=formObj.eff_date_from.value;
                        formObj.exp_dt.value=formObj.eff_date_to.value;
                    }else{
                        var accDt=formObj.access_date.value;
                        formObj.eff_dt.value=accDt;
                        formObj.exp_dt.value=accDt;
                    }
                    var preRate=formObj.previous_rate.value;
                    formObj.f_cmd.value=COMMAND01;
                    ComOpenWait(true);
                    sheet1.SetWaitImageVisible(0);
                    sheet2.SetWaitImageVisible(0);
                    var sXml=sheet2.GetSearchData("ESM_PRI_2042GS.do", FormQueryString(formObj) + "&is_prerate=" + preRate);
                    var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value=backendJobKey;
                        sheet2.SetWaitTimeOut(10000);
                        timer=setInterval(getBackEndJobStatus, 3000); 
                    }else{
                        ComOpenWait(false);
                    }
                }catch(e){
                    ComShowMessage(e.message);
                    ComOpenWait(false);
                }
                break;
            case IBCREATE: // New
                if (formObj.chkDisplay.checked) {
                	formObj.chkDisplay.click();
                }
                if (formObj.previous_rate.checked) {
                	formObj.previous_rate.click();
                } 
                formObj.reset();
                svc_scp_cd.SetSelectIndex("", true);
                chg_cd.SetSelectIndex("", true);
                rat_ut_cd.SetSelectIndex("", true);
                prc_cgo_tp_cd.SetSelectIndex("", true);
                prc_ctrt_cust_tp_cd.SetSelectIndex("", true);
                fnl_frt_rt.SetSelectIndex("", true);
                fnl_mqc.SetSelectIndex("", true);
                formObj.rdoDate[1].click();
    	        sheetObjects[0].RemoveAll();
    	        sheetObjects[1].RemoveAll();
                break;
            case IBDOWNEXCEL:      //download excel
            	if(sheet1.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
            	}            	
                break;
        }
    }
    
    /** 
     * about BackEndJob : checking until Status='3'<br>
     */ 
    function getBackEndJobStatus() {
        try {
            var form=document.form;	
            form.f_cmd.value=SEARCH;
            var sXml=sheet2.GetSearchData("ESM_PRI_2042GS.do", FormQueryString(form));
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
     * after finishing BackEndJobm, downloading result by Excel file(Request Expense Inital) <br>
     */ 
    function getBackEndJobLoadFile() {
        try {
            var form=document.form;
            form.f_cmd.value=SEARCHLIST;
            var sXml=sheet1.GetSearchData("ESM_PRI_2042GS.do", FormQueryString(form));
            sheet1.LoadSearchData(sXml,{Sync:1} );
        }catch(e){
            ComShowMessage(e.message);
        }finally{
            ComOpenWait(false);		
        }
    }
    
    /**
     * Handling sheet process 2<br>
     */
    function doActionIBSheet2(sheetObj, formObj, sAction) {
        sheet2.ShowDebugMsg(false);
        sheet2.SetWaitImageVisible(0);
        switch(sAction) {
            case IBSEARCH_ASYNC01: //s rep
                var params="f_cmd=" + SEARCH15 +"&etc1=" + formObj.prop_scp_ofc_cd.value;
                var sXml=sheet2.GetSearchData("PRICommonGS.do?", params);
                formObj.prop_scp_srep_cd.RemoveAll();
                ComPriXml2ComboItem(sXml, formObj.prop_scp_srep_cd, "cd", "cd|nm");
                formObj.prop_scp_srep_cd.InsertItem(0, "", "");
                formObj.prop_scp_srep_nm.value="";
                break;
        }
    }
    
    /** 
     * checking validation process of inputed form data  <br>
     */ 
    function validateForm(sheetObj, formObj, sAction){
        var form=document.form;
        var svcScpCdObj=svc_scp_cd;
        var rdoDateObj=form.rdoDate;
        var effDtFromObj=form.eff_date_from;
        var effDtToObj=form.eff_date_to;
        var accessDtObj=form.access_date;
        var routPntLocDefCdOri=form.rout_pnt_loc_def_cd_ori;	
        var routPntLocDefCdDest=form.rout_pnt_loc_def_cd_dest;	
        switch (sAction) {
            case IBSEARCH: //retrieve
                //msgs['PRI00308'] = 'Please {?msg1} {?msg2}.';
                if(null == svcScpCdObj.GetSelectCode()|| "" == svcScpCdObj.GetSelectCode()) {
                    ComShowCodeMessage("PRI00335", "SVC Scope");
                    ComSetFocus(svcScpCdObj);
                    return false;
                }
                if(rdoDateObj[0].checked) {
                    if(effDtFromObj.value == "") {
                        ComShowCodeMessage("PRI00335", "RFA EFF Date");
                        ComSetFocus(effDtFromObj);
                        return false;
                    }
                    if(effDtToObj.value == "") {
                        ComShowCodeMessage("PRI00335", "RFA EFF Date");
                        ComSetFocus(effDtToObj);
                        return false;
                    }
                    if(effDtFromObj.value >= effDtToObj.value) {
                        ComShowCodeMessage("PRI00345");
                        ComSetFocus(effDtFromObj);
                        return false;
                    }
                    if(!ComChkObjValid(effDtFromObj)) {return false;}
                    if(!ComChkObjValid(effDtToObj)) {return false;}
                }else{
                    if(accessDtObj.value == "") {
                        ComShowCodeMessage("PRI00335", "Access Date");
                        ComSetFocus(accessDtObj);
                        return false;
                    }
                    if(!ComChkObjValid(accessDtObj)) {return false;}
                }
                break;
        }
        return true;
    }