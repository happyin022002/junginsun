/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0060.js
*@FileTitle  : Rate Search
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
    var sheet3;
    var comboObjects=new Array();
    var comboCnt=0;
    // Global Variable
    var gCurrDate;
    var gBefParam="";
      
    
    //  ===================================================================================
    //  Initializing page
    //  ===================================================================================
    /** 
     * registering IBSheet Object as list</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /** 
     * registering IBCombo Object as list</b>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} combo_obj : IBMultiCombo Object
     * @return void
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
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function loadPage() {
        var form=document.form;	
        sheet1=sheetObjects[0];
        sheet2=sheetObjects[1]; // commodity, actual customer comboBox
        sheet3=sheetObjects[2]; // for backendjob
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
        sheet1.SetWaitImageVisible(0);
        initControl(); 
        
        gCurrDate=ComGetNowInfo('ymd', '-');
        form.eff_dt.value=gCurrDate;
        form.exp_dt.value=gCurrDate;
        initIBComboItem();
        setScNoMendatory();
       
        
    }
    
    /**
     * Catching events for Axon event.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.04.17
     */ 	    
     function initControl() {           
        axon_event.addListenerForm('blur', 'obj_deactivate', form);
        axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);  
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
        ComPriTextCode2ComboItem(chargeComboValue,       chargeComboText,       getComboObject(comboObjects, 'chg_cd'), 		     "|", "\t" );
        getComboObject(comboObjects, 'chg_cd').SetSelectCode("OFT",false);
        ComPriTextCode2ComboItem(customerTypeComboValue, customerTypeComboText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(tpSzComboValue,         tpSzComboText,         getComboObject(comboObjects, 'rat_ut_cd'),           "|", "\t" );
        getComboObject(comboObjects, 'rat_ut_cd').SetSelectCode("D4",false);
        ComPriTextCode2ComboItem(cargoTypeComboValue,    cargoTypeComboText,    getComboObject(comboObjects, 'prc_cgo_tp_cd'),       "|", "\t" );    
        getComboObject(comboObjects, 'prc_cgo_tp_cd').SetSelectCode("DR",false);
        ComPriTextCode2ComboItem(rateComboValue,   		 rateComboValue,    	getComboObject(comboObjects, 'fnl_frt_rt'),       	 "|", "\t" );  
        ComPriTextCode2ComboItem(rateComboValue,    	 rateComboValue,    	getComboObject(comboObjects, 'fnl_mqc'),       		 "|", "\t" );      
        ComPriTextCode2ComboItem(svcScpCdComboValue,     svcScpCdComboText,    	getComboObject(comboObjects, 'svc_scp_cd'),       	 "|", "\t" );      
        ComPriTextCode2ComboItem(rateTypeComboValue,     rateTypeComboText,    	getComboObject(comboObjects, 'gen_spcl_rt_tp_cd'),   "|", "\t" );      
    }
    
    /** 
     * initializing sheet <br>
     * adding first-served functions after loading screen. <br>
     * adding case as numbers of counting sheets  <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : sheet Object
     * @param {int} sheetNo : Sheet Serial No  
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
            		var HeadTitle1="Seq.|prop_no|rt_seq|S/C No.|AMD\nNo.|Customer Name|MQC|R.Office|S.Rep|SVC|Rate\nType|CMDT\nSeq.|Commodity\nGroup|Actual\nCustomer|Route\nSeq.|Origin|O.Via|D.Via|Dest|Charge|Per|Cargo\nType|Cur|Rate|Route\nNote|CMDT\nNote|Special\nNote";

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq." },
            		             {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:0,   SaveName:"rt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",    ColMerge:0,   SaveName:"amdt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Int",       Hidden:0, Width:45,   Align:"Right",   ColMerge:0,   SaveName:"fnl_mqc_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
            		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_srep_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
            		             {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:45,   Align:"Right",   ColMerge:0,   SaveName:"cmdt_hdr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:90,	  Align:"Left",    ColMerge:0,   SaveName:"act_cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:45,   Align:"Right",   ColMerge:0,   SaveName:"rout_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:75,   Align:"Left",    ColMerge:0,   SaveName:"org_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:75,   Align:"Left",    ColMerge:0,   SaveName:"org_via_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:75,   Align:"Left",    ColMerge:0,   SaveName:"dest_via_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:75,   Align:"Left",    ColMerge:0,   SaveName:"dest_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
            		             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
            		             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rnote_flag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cnote_flag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"snote_flag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
               
            		InitColumns(cols);

            		SetEditable(0);
//            		SetSheetHeight(400);
            		resizeSheet();
                }
                break;
            case "sheet2": // For ComboBox
                with(sheet2){
            		var HeadTitle1="f_text1"

            			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
                    var idx=sheet2.DataInsert();
            		SetVisible(0);
                    SetSheetHeight(200);
            	}
                break;
                
            case "sheet3": // For backendjob
                with(sheet3){
            		var HeadTitle1="f_text1"

            			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetVisible(0);//Usingitforbackendjobalso.RefertoESM_PRI_0015UI
                    var idx=sheet3.DataInsert();
                    SetSheetHeight(200);
            	}
                break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
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
            // charge
            case "chg_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2, 0);    // only upper case
                    SetMaxLength(3);
                }
                break;
                //customer type
            case "prc_ctrt_cust_tp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(1);
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
                    ValidChar(2, 1);    // Uppercase and numeric only
                    SetMaxLength(2);
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
                //svc scope
            case "svc_scp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // Uppercase Only
                    SetMaxLength(3);
                }
                break;
                // rate type
            case "gen_spcl_rt_tp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // Uppercase Only
                    SetMaxLength(1);
                }
                break;
                // commodity group
            case "cmdt_hdr_seq":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                }
                break;
                // actual customer
            case "act_cust_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
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
                // s.rep
            case "prop_scp_srep_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1); 
                    ValidChar(2, 1);    // Uppercase and numeric only
                    SetMaxLength(5);// Maximum Digit is 5
                }
                break;
        }
    }
    
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
                    cal.select(form.eff_dt, 'yyyy-MM-dd');
                    break;
                case "btns_calendar2":
                    var cal=new ComCalendar();
                    cal.select(form.exp_dt, 'yyyy-MM-dd');
                    break;
                case "btn_commodity": // prc_cmdt_def_cd : Commodity - cmdt_cd
                    var sUrl="/opuscntr/ESM_PRI_4027.do?grp_cd="+ PRI_SG+"&commodity_cmd=C";
                    ComOpenPopup(sUrl, 700, 345, "findCommodity", "1,0,1,1,1,1,1", true);
                    break;
                case "btn_reqOfc":  
                	ComOpenPopup('/opuscntr/COM_ENS_071.do', 800, 500, "findRequestOfc", "1,0,1,1,1,1,1,1", true);
                    break;
                case "btn_retrieve":
                    setParamsClear();
                    if (validateForm(sheet1, form, IBSEARCH)) {
                        doActionIBSheet(sheet3, form, IBBATCH);
                    }
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;
                case "btn_gotosc":
                    if(sheet1.RowCount() <= 0) {
                    	return false;
                    }
                    var params="&sprop_no=" + sheet1.GetCellValue(sheet1.GetSelectRow(), "prop_no")
                              +"&eff_dt=" + form.eff_dt.value
                              +"&exp_dt=" + form.exp_dt.value;                 
                    var sUrl="ESM_PRI_0004.do?parentPgmNo=ESM_PRI_M001&pgmNo=ESM_PRI_0004&MENU=Y&menuflag=true&mainPage=true" + params;	
                    var sId="ESM_PRI_0004";
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
    
    function findCommodity(rtnVal) {
    	form.prc_cmdt_def_cd.value = rtnVal.cd;
    }
    
    function findRequestOfc(rArray) {
        if(rArray != null ){
            var colArray=rArray[0];
            var rqstOfc=colArray[3]; 
        	form.prop_scp_ofc_cd.value = rqstOfc;
            searchSRep();
        } 
    }
    
    //  ===================================================================================
    //  Axson Event Handler
    //  ===================================================================================
    /** 
     * Object 's Keypress Event Handler <br>
     * Checking validtaion by object's dataformat <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void  
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function obj_keypress(){
        var obj=event.srcElement;
        if(obj.dataformat == null) return;
        window.defaultStatus=obj.dataformat;
        switch(obj.dataformat){
            case "ymd": //for date
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": //for number
            case "number": //Numeric characters Only 	
                ComKeyOnlyNumber(obj);
                break;
            case "engup":
                ComKeyOnlyAlphabet('upper');
                break;
            case "uppernum":
                ComKeyOnlyAlphabet('uppernum');
                break;
            default:
                break;
        }
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
     * @version 2009.08.24
     */
    function obj_click(){
        var form=document.form;
        var obj=event.srcElement;
        switch(ComGetEvent("name")){
            case "rdoDate":
                break;
        }
        //if(obj.dataformat == null) return;
    }
    
    /**
     * Handling OnBeforeActivate event <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2010.02.26
     */      
    function obj_activate() {
        ComClearSeparator (event.srcElement);
    }
    
    /** 
     * Handling Onbeforedeactivate event <br>
     * Checking validtaion by object's dataformat <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void  
     * @return void
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function obj_deactivate() {
        var form=document.form;
        //var formObj=event.srcElement;
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "prc_cmdt_def_cd": // Commodity
                break;
            case "sc_no_s":
                setScNoMendatory();
                break;
            case "prop_scp_ofc_cd":
                searchSRep();
                break;
            default :
                ComChkObjValid(form);
        }
        switch(srcName) {
            case "sc_no_s":
                doActionIBSheet2(sheet2, form, IBSEARCH);
                break;
        }
    }
    
    //  ===================================================================================
    //  UI Object Event Handler
    //  ===================================================================================
    /**                                                                                            
     * Return the selected code of Rep. Commodity Popup <br>      
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBMultiCombo} comboObj : ComboObject                                               
     * @param  {IBMultiCombo} objCd : Selected Code                                                 
     * @param  {IBMultiCombo} objTxt : Description of Code                                     
     * @return void                                                                                 
     * @see #                                                                                       
     * @author                                                                                
     * @version 2009.08.12                                                                          
     */  
    function getCOM_ENS_011(rowArray){
        var form=document.form;
        var colArray=rowArray[0];
        form.prc_cmdt_def_cd.value=colArray[2]; // Commodity - cmdt_cd
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
            case "dest_arb_amt": // Dar
            case "dor_trka_amt": // Door
                if(Row < 1) return;
                var svcScpCd=sheet1.GetCellValue(Row, "svc_scp_cd");
                var pgmNo="ESM_PRI_0083";
                var pgmUrl="/opuscntr/ESM_PRI_0083.do?";
                if(colName == "dor_trka_amt") {
                    pgmNo="ESM_PRI_0082";
                    pgmUrl="/opuscntr/ESM_PRI_0082.do?";
                }
                var propNo=sheet1.GetCellValue(Row, "prop_no");
                var amdtSeq=sheet1.GetCellValue(Row, "amdt_seq");
                var genSpclRrtTpCd=sheet1.GetCellValue(Row, "gen_spcl_rt_tp_cd");
                var cmdtHdrSeq=sheet1.GetCellValue(Row, "cmdt_hdr_seq");
                var routSeq=sheet1.GetCellValue(Row, "rout_seq");
                var rtSeq=sheet1.GetCellValue(Row, "rt_seq");
                var sParam="prop_no=" + propNo + "&amdt_seq=" + amdtSeq + "&svc_scp_cd=" + svcScpCd + "&gen_spcl_rt_tp_cd=" + genSpclRrtTpCd;
                sParam += "&cmdt_hdr_seq=" + cmdtHdrSeq + "&rout_seq=" + routSeq + "&rt_seq=" + rtSeq;
                ComPriOpenWindowCenter(pgmUrl + sParam, pgmNo, 600, 310, false);
                break;
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
                var sParam="is_sc=Y&note_gubun=R&prop_no=" + propNo + "&amdt_seq=" + amdtSeq + "&svc_scp_cd=" + svcScpCd + "&gen_spcl_rt_tp_cd=" + genSpclRrtTpCd;
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
                var sParam="is_sc=Y&note_gubun=C&prop_no=" + propNo + "&amdt_seq=" + amdtSeq + "&svc_scp_cd=" + svcScpCd + "&gen_spcl_rt_tp_cd=" + genSpclRrtTpCd;
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
                var sParam="is_sc=Y&note_gubun=S&prop_no=" + propNo + "&amdt_seq=" + amdtSeq + "&svc_scp_cd=" + svcScpCd;
            	ComOpenPopup('/opuscntr/ESM_PRI_0034_POP.do?'+sParam, 550, 355, pgmNo, '0,0', true);
                break;
                
            case "cmdt_nm":
            	ComShowMemoPad(sheetObj, Row, Col, true, 500, 200);
            	break;  
            	
            case "org_cd":	
            case "org_via_cd":	
            case "dest_via_cd":	
            case "dest_cd":	
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
    		if(sheetObj.RowCount() > 0) {
    			var redColor="#FF0000";
    		    var LastRow=sheetObj.LastRow();
    		    var firstRow=sheetObj.HeaderRows();
    			for(var i=firstRow; i <= LastRow; i++){
    				var rnote=sheetObj.GetCellValue(i, "rnote_flag");
    				if (rnote == "Y"){		
    				 	sheetObj.SetCellFontColor(i,"rnote_flag",redColor);			 
    				}else{
    					sheetObj.SetCellFontColor(i,"rnote_flag","");			
    				}
    				var cnote=sheetObj.GetCellValue(i, "cnote_flag");
    				if (cnote == "Y"){		
    				 	sheetObj.SetCellFontColor(i,"cnote_flag",redColor);			 
    				}else{
    					sheetObj.SetCellFontColor(i,"cnote_flag","");			
    				}
    				var snote=sheetObj.GetCellValue(i, "snote_flag");
    				if (snote == "Y"){		
    				 	sheetObj.SetCellFontColor(i,"snote_flag",redColor);			 
    				}else{
    					sheetObj.SetCellFontColor(i,"snote_flag","");			
    				}


    			}
    		}
    	}
    }
    
    /** 
     * chg_cd_OnChange function calls when charge Combo modified <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo Object
     * @return void
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function chg_cd_OnChange(chgCdObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var form=document.form;
        var scNoS=form.sc_no_s;
        var routPntLocDefCdOri=form.rout_pnt_loc_def_cd_ori;
        var routPntLocDefCdDest=form.rout_pnt_loc_def_cd_dest;
        if(newCode == "OBD") {
            scNoS.className="input1";
            routPntLocDefCdOri.className="input";		
            routPntLocDefCdDest.className="input"
        }else{
            scNoS.className="input";
            routPntLocDefCdOri.className="input1";		
            routPntLocDefCdDest.className="input1"
        }
    }
    
    
    /**                                                                                            
     * svc_scp_cd_OnBlur event handler : when focus move out of svc scope combobox <br>
     * <br><b>Example :</b>                                                                         
     * <pre>                                                                                        
     * </pre>                                                                                       
     * @param  {IBMultiCombo} comboObj : ComboObject                                               
     * @return void                                                                                 
     * @see #                                                                                       
     * @author                                                                                
     * @version 2009.08.12                                                                          
     */                   
    function svc_scp_cd_OnBlur(comboObj) {
        doActionIBSheet2(sheet2, form, IBSEARCH);	
    }
    
    /** 
     * gen_spcl_rt_tp_cd_OnBlur function calls when Rate Type ComboBox lose focus <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo Object
     * @return void
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function gen_spcl_rt_tp_cd_OnBlur(comboObj) {
        doActionIBSheet2(sheet2, form, IBSEARCH);
    }
    
    /** 
     * cmdt_hdr_seq_OnChange function calls when Commodity combo changed <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo Object
     * @return void
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function cmdt_hdr_seq_OnChange(cmdtObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var form=document.form;
        var actObj=form.act_cust_cd;
        act_cust_cd.SetSelectCode(newCode,false);
    }
    
    /** 
     * cmdt_hdr_seq_OnFocus called <br>
     */
    function cmdt_hdr_seq_OnFocus() {
        var formObj = document.form;
        var scNoSObj=formObj.sc_no_s;
        var svcScpObj = svc_scp_cd;
        var rateTypeObj=gen_spcl_rt_tp_cd;
        var commodityObj=cmdt_hdr_seq;
        var actualObj=act_cust_cd;
        
        if(commodityObj.GetEnable() && scNoSObj.value != ""){
        	if(svcScpObj.GetSelectCode() == "" || rateTypeObj.GetSelectCode()==""){
        		ComShowCodeMessage('PRI01143');
        		return false;
        	}
        }        
    }
    
    /** 
     * act_cust_cd_OnChange function calls when Actual Customer combo changed <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo Object
     * @return void
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function act_cust_cd_OnChange(actObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var form=document.form;
        var cmdtObj=form.cmdt_hdr_seq;
        cmdt_hdr_seq.SetSelectCode(newCode,false);
    }
    
    /** 
     * prop_scp_srep_cd_OnChange function calls when S.Rep ComboBox modified <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo Object
     * @return void
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function prop_scp_srep_cd_OnChange(actObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        var form=document.form;
        var text=actObj.GetText(newCode, 1);
        form.prop_scp_srep_nm.value=text;
    }
    
    /** 
     * searchSRep function calls when S.Rep retrieve event triggered <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function searchSRep() {
        doActionIBSheet2(sheet2, form, IBSEARCH_ASYNC01)
    }
    
    /** 
     * setScNoMendatory Event Handler : Setting Mandatory option of columns depend on S/C No. Data  <br>
     * <br><b>Example : </b>	
     * <pre>
     * </pre>
     * @param   {boolean} bool
     * @return void
     * @see #
     * @author 
     * @version 2009.09.01
     */ 
    function setScNoMendatory() {
        var form=document.form;
        var scNoSObj=form.sc_no_s;
        var rateTypeObj=gen_spcl_rt_tp_cd;
        var commodityObj=cmdt_hdr_seq;
        var actualObj=act_cust_cd;
        if( null != scNoSObj.value && "" != scNoSObj.value ){
            rateTypeObj.SetEnable(1);
            commodityObj.SetEnable(1);
            actualObj.SetEnable(1);
        }else{
            rateTypeObj.SetSelectCode("",false);
            commodityObj.SetSelectCode("",false);
            actualObj.SetSelectCode("",false);
            rateTypeObj.SetEnable(0);
            commodityObj.SetEnable(0);
            actualObj.SetEnable(0);
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
    
    /** 
     * setParamsSearch Event Handler : Setting Parameters for retrieving sheet1 data <br>
     * <br><b>Example :</b>	
     * <pre>
     * </pre>
     * @param  void
     * @return void
     * @see #
     * @author 
     * @version 2009.09.01
     */ 
    function setParamsSearch() {
        var form=document.form;
        var scNo=form.sc_no;
        var scNoS=form.sc_no_s;
        var cmdtNm=form.cmdt_nm;
        var actCustNm=form.act_cust_nm;
        var cmdtHdrSeq=cmdt_hdr_seq;
        var actCustCd=act_cust_cd;
        scNo.value=scNoS.value;
        if( cmdt_hdr_seq.GetSelectIndex() == -1){
        	cmdtNm.value="";
        } else {
        	cmdtNm.value=cmdt_hdr_seq.GetText(cmdt_hdr_seq.GetSelectCode(), 0);
        }
        if( act_cust_cd.GetSelectIndex() == -1){
        	actCustNm.value="";
        } else{
        	actCustNm.value=act_cust_cd.GetText(act_cust_cd.GetSelectCode(), 0);
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
            case IBSEARCH: 
                ComOpenWait(true);
                setParamsClear();
                setParamsSearch();
                formObj.f_cmd.value=SEARCH;
                sheet1.DoSearch("ESM_PRI_0060GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBBATCH: //backendjob
                try {
                	sheet1.ColumnSort();
                	ComOpenWait(true);
                    sheet1.SetWaitImageVisible(0);
                    sheet3.SetWaitImageVisible(0);
                    setParamsClear();
                    setParamsSearch();
                    formObj.f_cmd.value=COMMAND01;
                    var sXml=sheet3.GetSearchData("ESM_PRI_0060GS.do", FormQueryString(formObj));
                    var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
                    ComOpenWait(true);				
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value=backendJobKey;
                        sheet3.SetWaitTimeOut(10000);
                        timer=setInterval(getBackEndJobStatus, 3000); // after 3 seconds
                    }else{
                        ComOpenWait(false);
                    }
                }catch(e){
                    ComShowMessage(e.message);
                    ComOpenWait(false);
                }
                break; 			
            case IBDOWNEXCEL:      //download excel
                if(sheet1.RowCount() < 1){
    				ComShowCodeMessage("COM132501");
    			}else{
                    sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
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
             var sXml=sheet3.GetSearchData("ESM_PRI_0060GS.do", FormQueryString(form));
            var jobState=ComGetEtcData(sXml, "jb_sts_flg");
            form.job_status.value=jobState;
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
             var sXml=sheet1.GetSearchData("ESM_PRI_0060GS.do", FormQueryString(form));
            sheet1.LoadSearchData(sXml,{Sync:1} );
        }catch(e){
            ComShowMessage(e.message);
        }finally{
            ComOpenWait(false);		
        }
    }
    
    /** 
     * doActionIBSheet2  : Server side function ( Retrieve or Save ) calls. <br>
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
    function doActionIBSheet2(sheetObj, formObj, sAction) {
        sheet2.ShowDebugMsg(false);
        sheet2.SetWaitImageVisible(0);
        switch(sAction) {
            case IBSEARCH: //Commodity, actual ComboBox
                var scNo=formObj.sc_no_s.value; // sc_no
                var svcScpCd=svc_scp_cd.GetSelectCode(); // scope
                var genSpclRtTpCd=gen_spcl_rt_tp_cd.GetSelectCode(); // rate type
                var effDt=formObj.eff_dt.value;
                var expDt=formObj.exp_dt.value;
                var cmdtHdrSeqObj=cmdt_hdr_seq;
                var actCustCdObj=act_cust_cd;
                var chkValue=scNo + svcScpCd + genSpclRtTpCd;  
                if(gBefParam == chkValue) { return; }
                cmdtHdrSeqObj.RemoveAll();
                actCustCdObj.RemoveAll();
                gBefParam=chkValue;
                var params="f_cmd=" + SEARCH01 + "&sc_no=" + scNo + "&svc_scp_cd=" + svcScpCd + "&gen_spcl_rt_tp_cd=" + genSpclRtTpCd + "&eff_dt=" + effDt + "&exp_dt=" + expDt;
                var sXml=sheet2.GetSearchData("ESM_PRI_0060GS.do?", params);
                ComPriXml2ComboItem(sXml, cmdt_hdr_seq, "cmdt_hdr_seq", "cmdt_nm");
                cmdt_hdr_seq.InsertItem(0, "", "");
                ComPriXml2ComboItem(sXml, act_cust_cd, "cmdt_hdr_seq", "act_cust_nm");
                act_cust_cd.InsertItem(0, "", "");	
                break;
            case IBSEARCH_ASYNC01: //s rep
                var params="f_cmd=" + SEARCH15 + "&etc1=" + formObj.prop_scp_ofc_cd.value;
                var sXml=sheet2.GetSearchData("PRICommonGS.do?", params);
                prop_scp_srep_cd.RemoveAll();
                ComPriXml2ComboItem(sXml, prop_scp_srep_cd, "cd", "cd|nm");
                prop_scp_srep_cd.InsertItem(0, "", "");
               // ComSetMultiComboHeight(prop_scp_srep_cd);
                formObj.prop_scp_srep_nm.value="";
                break;
        }
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
        var chgCd=chg_cd;
        var effDt=form.eff_dt;
        var expDt=form.exp_dt;	
        var routPntLocDefCdOri=form.rout_pnt_loc_def_cd_ori;
        var routPntLocDefCdDest=form.rout_pnt_loc_def_cd_dest;
        var scNoS=form.sc_no_s;
        switch (sAction) {
            case IBSEARCH:
                if( null == chgCd.GetSelectCode()|| "" == chgCd.GetSelectCode()) {
                    ComShowCodeMessage("PRI00337", "Charge");
                    ComSetFocus(chgCd);
                    return false;
                }
                if(effDt.value == "") {
                    ComShowCodeMessage("PRI00335", effDt.caption);
                    ComSetFocus(effDt);
                    return false;
                }
                if(!ComChkObjValid(effDt)) { return false; }
                if(!ComChkObjValid(expDt)) { return false; }
                if(routPntLocDefCdOri.className == "input1" && routPntLocDefCdOri.value == "") {
                    ComShowCodeMessage("PRI00335", "Origin");
                    ComSetFocus(routPntLocDefCdOri);
                    return false;
                }
                if(routPntLocDefCdDest.className == "input1" && routPntLocDefCdDest.value == "") {
                    ComShowCodeMessage("PRI00335", "Destination");
                    ComSetFocus(routPntLocDefCdDest);
                    return false;
                }

                if(scNoS.className == "input1" && scNoS.value == "") {
                    ComShowCodeMessage("PRI00335", "S/C No.");
                    ComSetFocus(scNoS);
                    return false;
                }
                break;
        }
        return true;
    }
    
    function obj_onKeydown(){
 		var eleName=ComGetEvent("name");
 		if (eleName == "rout_pnt_loc_def_cd_ori" || 
 				eleName == "rout_pnt_loc_def_cd_dest" ||
 				eleName == "rout_via_port_def_cd_ori" ||
 				eleName == "rout_via_port_def_cd_dest" ||
 				eleName == "sc_no_s"){
		 	
		   	if (event != null && event.keyCode == 13){
		   		setParamsClear();
                if (validateForm(sheet1, form, IBSEARCH)) {
                    doActionIBSheet(sheet3, form, IBBATCH);
                }
		  	}
		}
	}
    

	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
		sheetObj.ReNumberSeq();    
	}

    