/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0108_02.js
*@FileTitle  : S/C Performance Summary - Details by S/C 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    //  Common Global Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var sheet2;
    var sheet3;
    var sheet4;
    var sheet5;
    var comboObjects=new Array();
    var comboCnt=0;
    var C1_SC_NO="sc_no";
    var C1_SVC_SCP_CD="svc_scp_cd";
    var C1_PFMC="op_cntr_qty";
    var C1W_PFMC=70;
    //  Sheet3 Column Information
    var C3_TRADE="trd_cd";
    var C3_TRADE_NM="trd_nm";
    var C3_SUB_TRADE="sub_trd_cd";
    var C3_SUB_TRADE_NM="sub_trd_nm";
    var C3_LANE="vsl_slan_cd";
    var C3_LANE_NM="vsl_slan_nm";
    // global
    var gCurrDate;
    var gBefScNo="";
    var gBefParam="";
    var gSheet1Width=0;
    //  filter combo
    var gArrTradeRange={};  // Trade 
    var gArrSubTradeCob={}; // sub tradecombo
    var gArrLaneCob={};    // lane combo
    
    //  ===================================================================================
    //  Initializing page
    //  ===================================================================================
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
     * registering IBCombo Object as list</b>
     * adding process for list in case of needing batch processing with other items</b> 
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
        sheet1=sheetObjects[0];
        sheet2=sheetObjects[1]; // distinct 
        sheet3=sheetObjects[2]; // trade, sub trade, lane combo
        sheet4=sheetObjects[3]; // group, costumer combo     
        sheet5=sheetObjects[4]; // 
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
        //Initializing html control event
        axon_event.addListenerForm('click', 'obj_click', form);	 
        axon_event.addListenerForm('blur', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        //combo
        initIBComboItem();
        ComOpenWait(true);
        // trade, sub trade, lane combo
        doActionIBSheet(sheet3, form, IBSEARCH);
        ComOpenWait(false);
        //Calling from ESM_PRI_0003 
        var pForm=parent.document.form;
        if (pForm.sc_no1.value !="" && pForm.sc_no2.value !="" ){
            form.sc_no_prefix.SetSelectCode(pForm.sc_no1.value);
            form.sc_no_suffix.value=pForm.sc_no2.value;
            form.sc_no_suffix.focus();
            pForm.rdoSummaryType[1].checked=true;
            parent.setRdoSummaryType();
            mainCallButtonClick("btn_retrieve");  
            pForm.sc_no1.value="";
            pForm.sc_no2.value="";
        }
        
    }
    
    /**
     * Setting item to IBMultiCombo <br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.12.15
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(scNoPrefixComboValue, scNoPrefixComboText, getComboObject(comboObjects, 'sc_no_prefix'),      "|", "\t" );
        ComPriTextCode2ComboItem(svcScpCdComboValue,   svcScpCdComboText,   getComboObject(comboObjects, 'svc_scp_cd'),        "|", "\t" );
        ComPriTextCode2ComboItem(skdDirCdComboValue,   skdDirCdComboText,   getComboObject(comboObjects, 'skd_dir_cd'),        "|", "\t" );
        ComPriTextCode2ComboItem(rtTpCdComboValue,     rtTpCdComboText,     getComboObject(comboObjects, 'gen_spcl_rt_tp_cd'), "|", "\t" );
        ComPriTextCode2ComboItem(usModCdComboValue,    usModCdComboText,    getComboObject(comboObjects, 'usa_svc_mod_cd'),    "|", "\t" );
    }
    
    /** 
     * initializing sheet <br>
     * adding first-served functions after loading screen. <br>
     * adding case as numbers of counting sheets . <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : sheet Object
     * @param {int} sheetNo : sheet Object ,Serial no for Tag's ID  
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
            		var HeadTitle1="Seq|svc_scp_cd|Trade|Dir.|Sub\nTrade|Lane|VVD|Rate\nType|Commodity Group|Actual Customer|US\nMode|POR|POL|POD|DEL|PFMC\n(FEU)";

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"act_cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"usa_svc_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(0);
                    SetExtendLastCol(1);
                    SetSheetHeight(370);
            	}
                break;
            case "sheet2": // for find_text ,retrieving sc , sum 
                with(sheet2){
            		var HeadTitle1="f_text1";

        			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
           
        			InitColumns(cols);

        			SetEditable(1);
        			var idx=sheet2.DataInsert();

//        			SetSheetHeight(80);
              	}
                break;
            case "sheet3": // trade, sub trade, lane combo
                with(sheet3){
            		var HeadTitle1="trd_cd|trd_nm|sub_trd_cd|sub_trd_nm|vsl_slan_cd|vsl_slan_nm";

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C3_TRADE,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C3_TRADE_NM,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C3_SUB_TRADE,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C3_SUB_TRADE_NM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C3_LANE,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:C3_LANE_NM,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
//            		SetSheetHeight(100);
            	}
                break;
            case "sheet4": // group, costumer
                with(sheet4){
            		var HeadTitle1="cmdt_hdr_seq|cmdt_nm|act_cust_nm|sc_no|svc_scp_cd|gen_spcl_rt_tp_cd";

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"act_cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"sc_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
            		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
//            		SetSheetHeight(100);
            	}
                break;
            case "sheet5": // backendjob 
                with(sheet5){
            		var HeadTitle1="job_id";

            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"job_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		SetVisible(0);//backendjob
//            		SetSheetHeight(80);
            	}
                break;
        }
    }
    
    /** 
     * setting intial combo value <br>
     * adding case as numbers of counting combos<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBMultiCombo} comboObj : sheet Object
     * @param {int} comboNo : comboObject ,Serial no for Tag's ID  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function initCombo(comboObj, comboNo) {
        switch (comboObj.options.id) {
            // S/C No.
            case "sc_no_prefix":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(3);
                }
                break;
                //trd_cd
            case "trd_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(3);
                    InsertItem(i++, "", "");                
                }
                break;
                //Direction : skd_dir_cd
            case "skd_dir_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(1);
                }
                break;
                //sub_trd_cd
            case "sub_trd_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(2);
                    InsertItem(i++, "", "");	
                }
                break;
                //lane
            case "vsl_slan_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(3);
                    InsertItem(i++, "|", "");				
                }
                break;
                //SVC Scope
            case "svc_scp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(3);
                }
                break;
                //rate type
            case "gen_spcl_rt_tp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    // only upper case
                    SetMaxLength(1);
                }
                break;
                // comodity group
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
                // us mode
            case "usa_svc_mod_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);				
                    ValidChar(2);    // only upper case
                }
                break;
        }
    }  
    
    document.onclick=processButtonClick;
    /** 
     * Event handler processing by button name  <br>
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
                case "btn_retrieve":
                    mainCallButtonClick(srcName);
                    break;
                case "btns_calendar1": //calendar button
                    var cal=new ComCalendar();
                    cal.select(form.bl_obrd_dt_from, 'yyyy-MM-dd');
                    break;
                case "btns_calendar2": //calendar button
                    var cal=new ComCalendar();
                    cal.select(form.bl_obrd_dt_to, 'yyyy-MM-dd');
                    break;
                case "btn_com_ens_ob2":
                    var param="";
                    param=param + "lane_cd=" + ComGetObjValue(vsl_slan_cd);
                    ComOpenPopup('/opuscntr/COM_ENS_0B2.do?' + param, 780, 520, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
                    break;
                case "btn_por_cd":
                	var param="";
                	param=param + "group_cmd=" + PRI_SP_SCP + "&location_cmd=LGC" + "&svc_scp_cd=" + svc_scp_cd.GetSelectCode();
                	ComOpenPopup('/opuscntr/ESM_PRI_4026.do?' + param, 700, 310, 'setCallBackPorCd', '1,0', true);
                	break;
                case "btn_pol_cd":
                	var param="";
                	param=param + "group_cmd=" + PRI_SP_SCP + "&location_cmd=LGC" + "&svc_scp_cd=" + svc_scp_cd.GetSelectCode();
                	ComOpenPopup('/opuscntr/ESM_PRI_4026.do?' + param, 700, 310, 'setCallBackPolCd', '1,0', true);
                	break;
                case "btn_pod_cd":
                	var param="";
                	param=param + "group_cmd=" + PRI_SP_SCP + "&location_cmd=LGC" + "&svc_scp_cd=" + svc_scp_cd.GetSelectCode();
                	ComOpenPopup('/opuscntr/ESM_PRI_4026.do?' + param, 700, 310, 'setCallBackPodCd', '1,0', true);
                	break;
                case "btn_del_cd":
                	var param="";
                	param=param + "group_cmd=" + PRI_SP_SCP + "&location_cmd=LGC" + "&svc_scp_cd=" + svc_scp_cd.GetSelectCode();
                	ComOpenPopup('/opuscntr/ESM_PRI_4026.do?' + param, 700, 310, 'setCallBackDelCd', '1,0', true);
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
    
    function setCallBackPorCd(rtnVal) {
    	form.por_cd.value=rtnVal.cd;
    }
    
    function setCallBackPolCd(rtnVal) {
    	form.pol_cd.value = rtnVal.cd;
    }
    
    function setCallBackPodCd(rtnVal) {
    	form.pod_cd.value = rtnVal.cd;
    }
    
    function setCallBackDelCd(rtnVal) {
    	form.del_cd.value = rtnVal.cd;
    }
    
    /** 
     * Event handler processing by calling from main screen<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function mainCallButtonClick(srcName){
        var form=document.form;
        switch(srcName) {
            case "btn_retrieve":
                setParamsClear();
                if (validateForm(sheet1, form, IBSEARCH)) {
                    doActionIBSheet(sheet5, form, IBBATCH); //for sum , backendjob  sheet5
                }
                break;
            case "btn_bl_list":
                sheet1_OnDblClick(sheet1, sheet1.GetSelectRow(), "", 0, 0, 0, 0);
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
     * Object 's Keypress Event Handler <br>
     * Checking validtaion by object's dataformat <br>
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
            case "ymd": //for date
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": //for number
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
     * Checking validtaion by object's dataformat  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.09.04
     */
    function obj_click(){
        var form=document.form;
        var obj=ComGetEvent();
        switch(obj.id){
            case "chkDisplay":
                return;
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
        }
        //if(obj.dataformat == null) return;
    }
    
    /**
     * Handling OnBeforeActivate event <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param N/A
     * @return N/A
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
     * @param  N/A  
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function obj_deactivate() {
        var form=document.form;
        var scNoSuffixObj=form.sc_no_suffix;
        var formObj=ComGetEvent();
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "sc_no_suffix":
                if(scNoSuffixObj.value == "") {
                    return;
                }
                doActionIBSheet(sheet2, form, IBSEARCH_ASYNC02);
                break;
            case "bl_obrd_dt_from":
            case "bl_obrd_dt_to":
                ComChkObjValid(formObj);
                chkObrdDate(formObj);
                break;
            case "skd_voy_no":
                break;
            default :
                ComChkObjValid(formObj);
        }
    }
    
//  ===================================================================================
//  UI Object Event Handler
//  ===================================================================================
    /** 
     * Initializing searchScInfo<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function clearScInfomation() {
        var form=document.form;
        for(var i=0; i < form.length; i++){
            var formObj=form.elements[i];
            if(formObj.id == "scInfomation") {
                formObj.value="";
            }
        }
    }
    
    /** 
     * event after retrieving sheet2 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : sheet Object  
     * @param  {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
        var form=document.form;
        if (errMsg == "") {
            doActionIBSheet(sheet2, form, IBSEARCH_ASYNC04);
            var formObj, colNm, colWidth, bool; 
            for(var i=0; i < form.length; i++){
                formObj=form.elements[i];
                if(formObj.id == "chkDisplay") {
                    colNm=formObj.value;
                    colWidth=sheet1.GetColWidth(colNm);
                    bool=true;
                    if(formObj.checked){
                        bool=false;
                    }
                    sheet1.SetColHidden(colNm,bool);
                    if(bool) {
                        gSheet1Width=gSheet1Width - colWidth;
                    } else {
                        gSheet1Width=gSheet1Width + colWidth;
                    }
                }
            }
        }else{
            ComOpenWait(false);        		
        }
    }
    
    /** 
     * event after retrieving sheet3 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : sheet Object  
     * @param  {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function sheet3_OnSearchEnd(sheetObj, errMsg) {
        var form=document.form;
        if (errMsg == "") {
            setTradeSubLaneComboMake();
        }
    }
    
    /** 
     * event after retrieving sheet4 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : sheet Object  
     * @param  {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function sheet4_OnSearchEnd(sheetObj, errMsg) {
        var form=document.form;
        var cmdtObj=cmdt_hdr_seq; 
        var actObj=act_cust_cd;
        var cd, cmdtNm, actNm;
        if (errMsg == "") {
            var startRow4=sheet4.HeaderRows();
            var endRow4=sheet4.HeaderRows()+ sheet4.RowCount();
            cmdtObj.InsertItem(-1, "", "");				
            actObj.InsertItem(-1, "", "");				
            for(var k=startRow4; k < endRow4; k++) {
            	cd=sheet4.GetCellValue(k, "cmdt_hdr_seq");
            	cmdtNm=sheet4.GetCellValue(k, "cmdt_nm");
            	actNm=sheet4.GetCellValue(k, "act_cust_nm");
                cmdtObj.InsertItem(-1, cmdtNm, cd);				
                actObj.InsertItem(-1, actNm, cd);				
            }
        }
    }
    
    /** 
     * event handler in case of double-clicking sheet1's row <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : sheet Object  
     * @param  {string} errMsg : error message
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function sheet1_OnDblClick(sheetObj, Row, Col) {
        var form=document.form;
        //var scNo = sheet1.CellValue(Row, C1_SC_NO);
        var scNo=getScNoValue();
        var svcScpCd=sheet1.GetCellValue(Row, C1_SVC_SCP_CD);
        var blObrdDtFrom=form.bl_obrd_dt_from.value;
        var blObrdDtTo=form.bl_obrd_dt_to.value;
        if (scNo != "") {
            var popParams="sc_no=" + scNo + "&svc_scp_cd=" + svcScpCd + "&bl_obrd_dt_from=" + blObrdDtFrom + "&bl_obrd_dt_to=" + blObrdDtTo;
//            comCallPop("ESM_PRI_0111", "ESM_PRI_0108_02", popParams, "");
            ComOpenPopup('ESM_PRI_0111.do?'+popParams, 900, 500, "", "0,1", false);
        }
    }
    
    /** 
     * Initializing parameter to retrieve SC NO<br>
     * <br><b>Example :</b>	
     * <pre>
     * </pre>
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.09.01
     */ 
    function getScNoValue() {
        var form=document.form;
        var scNo=sc_no_prefix.GetSelectCode()+ form.sc_no_suffix.value;
        form.sc_no.value=scNo;
        return scNo;
    }
    
    /** 
     * Initializing parameter to retrieve sheet1 data <br>
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
     * vvd : Vessel SKD & Code Inquiry<br>
     * <br><b>Example :</b>	
     * <pre>
     * </pre>
     * @param {arry} aryPopupData
     * @return N/A
     * @see #
     * @author 
     * @version 2009.09.01
     */ 
    function setCallBack0B2(aryPopupData) {
        var form=document.form;
        var strValue=aryPopupData[0][7];
        form.vsl_cd.value=strValue.substr(0,4);
        form.skd_voy_no.value=strValue.substr(4,4);
        form.skd_dir_cd_txt.value=strValue.substr(8);
    }
    
    /** 
     * Creating information point combo by inputted point information on Arbitray screen<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function setTradeSubLaneComboMake() {
        var form=document.form;
        var trdObj=trd_cd; 
        var subTrdObj=sub_trd_cd; 
        var laneObj=vsl_slan_cd; 
        var chkTrade="";  
        var chkTradeNm="";
        var tmpText="";
        var tradeRange, arrTradeRange, startRng, endRng; 
        var startRow3=sheet3.HeaderRows();
        var endRow3=sheet3.HeaderRows()+ sheet3.RowCount();
        for(var k=startRow3; k < endRow3; k++) {
        	chkTrade=sheet3.GetCellValue(k, C3_TRADE);
        	chkTradeNm=sheet3.GetCellValue(k, C3_TRADE_NM);
            trdObj.InsertItem(-1, chkTrade + "|" + chkTradeNm, chkTrade);
            tradeRange=sheet3.GetColSameDataRange(k, C3_TRADE); 
            gArrTradeRange[chkTrade]=tradeRange;              
            arrTradeRange=tradeRange.split("|");
            startRng=parseInt(arrTradeRange[0],10);
            endRng=parseInt(arrTradeRange[1],10);
            if(endRng > startRng) {
                k=k + (endRng - startRng);
            }
        }
        //Creating sub trade combo and saving route information
        sheet2.SetCellValue(1, "f_text1","",0);
        var chkSubTrade="";
        var chkSubTradeNm="";
        var arrSubTrade="", arrSubTradeNm="";
        for(var k=startRow3; k < endRow3; k++) {
        	chkSubTrade=sheet3.GetCellValue(k, C3_SUB_TRADE);
        	chkSubTradeNm=sheet3.GetCellValue(k, C3_SUB_TRADE_NM);
            if( null != chkSubTrade && "" != chkSubTrade ) {
                chkFindNum=sheet2.FindText("f_text1", "[" + chkSubTrade + "]", 1, 2, true);
                if(chkFindNum < 0){
                    subTrdObj.InsertItem(-1, chkSubTrade + "|" + chkSubTradeNm, chkSubTrade);				
                    arrSubTrade=arrSubTrade + "|" + chkSubTrade;
                    arrSubTradeNm=arrSubTradeNm + "|" + chkSubTradeNm;
                    if(sheet2.RowCount()>0){
                    	tmpText=sheet2.GetCellValue(1, "f_text1");
                    }else{
                    	sheet2.DataInsert(-1);
                    }
                    sheet2.SetCellValue(1, "f_text1",tmpText + "[" + chkSubTrade + "]",0);
                }
            }
        }
        gArrSubTradeCob["[]"]=arrSubTrade + "☜☞" + arrSubTradeNm;
        sheet2.SetCellValue(1, "f_text1","",0);
        var chkLane="";
        var arrLane="", arrLaneNm="";
        for(var k=startRow3; k < endRow3; k++) {
        	chkLane=sheet3.GetCellValue(k, C3_LANE);
        	chkLaneNm=sheet3.GetCellValue(k, C3_LANE_NM);
            if( null != chkLane && "" != chkLane ) {
                chkFindNum=sheet2.FindText("f_text1", "[" + chkLane + "]", 1, 2, true);
                if(chkFindNum < 0){
                    laneObj.InsertItem(-1, chkLane + "|" + chkLaneNm, chkLane);
                    arrLane=arrLane + "|" + chkLane;
                    arrLaneNm=arrLaneNm + "|" + chkLaneNm;
                    tmpText=sheet2.GetCellValue(1, "f_text1");
                    sheet2.SetCellValue(1, "f_text1",tmpText + "[" + chkLane + "]",0);
                }
            }
        }
        gArrLaneCob["[_]"]=arrLane + "☜☞" + arrLaneNm;
    }
    
    /**
     * Calling event in case of onBlur event of SC NO combo<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2009.08.20
     */
    function sc_no_prefix_OnBlur(comboObj) {
        if(null == comboObj.GetSelectCode()|| "" == comboObj.GetSelectCode()) {
            return;
        }
        doActionIBSheet(sheet2, form, IBSEARCH_ASYNC02);
    }
    
    /** 
     * Calling function in case of OnChange event for trade combo<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj  
     * @param  {string} Code : combo code
     * @param  {string} Text : combo text
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function sub_trd_cd_OnChange(tradeObj, oldindex , oldtext , oldcode , newindex ,Text , Code) {
        var form=document.form;
        var subTradeObj=sub_trd_cd;
        subTradeObj.RemoveAll();
        sheet2.SetCellValue(1, "f_text1","",0);
        var startRow=sheet3.HeaderRows();
        var endRow=sheet3.HeaderRows()+ sheet3.RowCount();
        if("" != Code) {
            var arrRange=gArrTradeRange[Code].split("|");
            startRow=parseInt(arrRange[0],10);
            endRow=parseInt(arrRange[1],10) + 1;
        }
        var chkFindNum;
        var tmpText;
        var keyTrade="[" + Code + "]";
        var chkTrade="", chkSubTrade="";
        var arrSubTrade="", arrSubTradeNm="";
        var compTrade=Code;
        if(undefined == gArrSubTradeCob[keyTrade]) {
            for(var i=startRow; i < endRow; i++) {
            	chkTrade=sheet3.GetCellValue(i, C3_TRADE);
            	chkSubTrade=sheet3.GetCellValue(i, C3_SUB_TRADE);
            	chkSubTradeNm=sheet3.GetCellValue(i, C3_SUB_TRADE_NM);
                if(null == Code || "" == Code) {
                    compTrade=chkTrade;
                }
                if( chkSubTrade != "" && compTrade == chkTrade ) {
                    chkFindNum=sheet2.FindText("f_text1", "[" + chkSubTrade + "]", 1, 2, true);
                    if(chkFindNum < 0){
                        arrSubTrade=arrSubTrade + "|" + chkSubTrade;
                        arrSubTradeNm=arrSubTradeNm + "|" + chkSubTradeNm; 
                        tmpText=sheet2.GetCellValue(1, "f_text1");
                        sheet2.SetCellValue(1, "f_text1",tmpText + "[" + chkSubTrade + "]",0);
                    }
                }
            }
            gArrSubTradeCob[keyTrade]=arrSubTrade + "☜☞" + arrSubTradeNm;
        }
        var arrCombo=gArrSubTradeCob[keyTrade].split("☜☞");
        var arrCode=arrCombo[0].split("|");
        var arrNm=arrCombo[1].split("|");
        if(arrCode.length == 0) {
            arrCombo=gArrSubTradeCob["[]"].split("☜☞"); 
            arrCode=arrCombo[0].split("|"); 
            arrNm=arrCombo[1].split("|"); 
        }
        for(var i=0; i < arrCode.length; i++){
            subTradeObj.InsertItem(-1, arrCode[i] + "|" + arrNm[i], arrCode[i]);		
        }
        sub_trd_cd_OnChange(subTradeObj, "" , "" , "" , "" ,"", "");
    }
    
    /** 
     * Calling function in case of OnChange event for sub trade combobr>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj   
     * @param  {string} Code : combo code
     * @param  {string} Text : combo text
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function sub_trd_cd_OnChange(subTradeObj, oldindex , oldtext , oldcode , newindex ,Text , Code) {
        var form=document.form;
        var tradeObj=trd_cd;
        var laneObj=vsl_slan_cd;
        laneObj.RemoveAll();
        sheet2.SetCellValue(1, "f_text1","",0);
        var startRow=sheet3.HeaderRows();
        var endRow=sheet3.HeaderRows()+ sheet3.RowCount();
        var theTrade=tradeObj.GetSelectCode();
        var theSubTrade=Code;
        var compTrade=theTrade;
        var compSubTrade=theSubTrade;
        if("" != theTrade) {
            var arrRange=gArrTradeRange[theTrade].split("|");
            startRow=parseInt(arrRange[0],10);
            endRow=parseInt(arrRange[1],10) + 1;
        }
        var chkFindNum;
        var tmpText;
        var keySubTrade="[" + theTrade + "_"+ theSubTrade + "]";
        var chkSubTrade="";
        var arrLane="", arrLaneNm="";	
        if(undefined == gArrLaneCob[keySubTrade]) {
            for(var i=startRow; i < endRow; i++) {
            	chkTrade=sheet3.GetCellValue(i, C3_TRADE);
            	chkSubTrade=sheet3.GetCellValue(i, C3_SUB_TRADE);
            	chkLane=sheet3.GetCellValue(i, C3_LANE);
            	chkLaneNm=sheet3.GetCellValue(i, C3_LANE_NM);
                if(null == theTrade || "" == theTrade) compTrade=chkTrade;
                if(null == theSubTrade || "" == theSubTrade) compSubTrade=chkSubTrade;			
                if( chkLane != "" && compTrade == chkTrade && compSubTrade == chkSubTrade) {
                    chkFindNum=sheet2.FindText("f_text1", "[" + chkLane + "]", 1, 2, true);
                    if(chkFindNum < 0){
                        arrLane=arrLane + "|" + chkLane;
                        arrLaneNm=arrLaneNm + "|" + chkLaneNm;
                        tmpText=sheet2.GetCellValue(1, "f_text1");
                        sheet2.SetCellValue(1, "f_text1",tmpText + "[" + chkLane + "]",0);
                    }
                }
            }
            gArrLaneCob[keySubTrade]=arrLane + "☜☞" + arrLaneNm;
        }
        var arrCombo=gArrLaneCob[keySubTrade].split("☜☞");
        var arrCode=arrCombo[0].split("|");
        var arrNm=arrCombo[1].split("|");
        if(arrCode.length == 0) {
            arrCombo=gArrLaneCob["[_]"].split("☜☞");
            arrCode=arrCombo[0].split("|");
            arrNm=arrCombo[1].split("|");
        }
        for(var i=0; i < arrCode.length; i++){
            laneObj.InsertItem(-1, arrCode[i] + "|" + arrNm[i], arrCode[i]);		
        }
    }
    
    /**
     * Calling function in case of OnBlur event for SVC Scope combo <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return N/A
     * @author 
     * @version 2009.08.20
     */
    function svc_scp_cd_OnBlur(comboObj) {
        doActionIBSheet4(sheet4, document.form, IBSEARCH_ASYNC03);
    }
    
    /** 
     *  Calling function in case of OnBlur event for Rate Type combo <br>
     * Group, Customer combo를 셋팅한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj     : IBMultiCombo Object
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function gen_spcl_rt_tp_cd_OnBlur(comboObj) {
        doActionIBSheet4(sheet4, document.form, IBSEARCH_ASYNC03);
    }
    
    /** 
     * Calling function in case of OnChange event for Commodity combo<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj  : IBMultiCombo Object
     * @param  {IBMultiCombo} Code : IBMultiCombo code 
     * @param  {IBMultiCombo} Text : IBMultiCombo text 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function cmdt_hdr_seq_OnChange(cmdtObj, oldindex , oldtext , oldcode , newindex ,Text, Code) {
        var form=document.form;
        var actObj=act_cust_cd;
        //actObj.Code2 = cmdtObj.Code;
        actObj.SetSelectCode(Code,false);
    }
    
    /** 
     * Calling function in case of OnChange event for Actual Customer combo <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBMultiCombo} Obj : IBMultiCombo Object
     * @param  {IBMultiCombo} Code : IBMultiCombo code 
     * @param  {IBMultiCombo} Text : IBMultiCombo text 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.20
     */
    function act_cust_cd_OnChange(actObj, oldindex , oldtext , oldcode , newindex ,Text, Code) {
        var form=document.form;
        var cmdtObj=cmdt_hdr_seq;
        cmdtObj.SetSelectCode(Code,false);
    }
    
    /** 
     * Retrieivng and saving <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : sheet Object  
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {
        var form=document.form;
        sheet1.ShowDebugMsg(false);
        sheet2.SetWaitImageVisible(0);
        switch(sAction) {
            case IBSEARCH: //trade, sub trade, lane combo
                formObj.f_cmd.value=SEARCH01;
//parameter changed[check again]CLT
                sheet3.DoSearch("ESM_PRI_0108_02GS.do", FormQueryString(formObj) );
                break;
            case IBSEARCH_ASYNC02: //Retrieving basic S/C information
                var scNo=getScNoValue();
                if(gBefScNo == scNo) {return false;}
                clearScInfomation();
                gBefScNo=scNo;
//parameter changed[check again]CLT
                var sXml=sheet2.GetSearchData("ESM_PRI_0108_02GS.do?", "f_cmd=" + SEARCH02 + "&sc_no=" + scNo);
                form.cust_cnt_cd.value=ComGetEtcData(sXml, "custCntCd");
                form.cust_seq.value=ComGetEtcData(sXml, "custSeq");
                form.ctrt_pty_nm.value=ComGetEtcData(sXml, "ctrtPtyNm");
                form.prc_ctrt_cust_tp_cd.value=ComGetEtcData(sXml, "prcCtrtCustTpCd");
                form.ctrt_cust_sls_ofc_cd.value=ComGetEtcData(sXml, "ctrtCustSlsOfcCd");
                form.ctrt_cust_srep_cd.value=ComGetEtcData(sXml, "ctrtCustSrepCd");
                form.srep_nm.value=ComGetEtcData(sXml, "srepNm");
                form.ctrt_eff_dt.value=ComGetEtcData(sXml, "ctrtEffDt");
                form.ctrt_exp_dt.value=ComGetEtcData(sXml, "ctrtExpDt");
                //Retrieving C.Group, A.Customer
                doActionIBSheet4(sheet4, form, IBSEARCH_ASYNC03);
                break;
            case IBSEARCH_ASYNC04: // sum
                var scNo=getScNoValue();
                var params="f_cmd=" + SEARCH04 + "&sc_no=" + scNo + "&bl_obrd_dt_from=" + formObj.bl_obrd_dt_from.value + "&bl_obrd_dt_to=" + formObj.bl_obrd_dt_to.value;
//parameter changed[check again]CLT
                var sXml=sheet2.GetSearchData("ESM_PRI_0108_02GS.do?", params );
                form.fnl_mqc_qty.value=ComAddComma(ComGetEtcData(sXml, "fnlMqcQty"));
                form.op_cntr_qty.value=ComAddComma(ComGetEtcData(sXml, "opCntrQty"));
                form.mqc_perf.value=ComAddComma(ComGetEtcData(sXml, "mqcPerf"));
                form.pro_rt_mqc_perf.value=ComAddComma(ComGetEtcData(sXml, "proRtMqcPerf"));
                ComOpenWait(false);        		
                break;
            case IBBATCH: //backendjob
                try {
                    ComOpenWait(true);
                    sheet1.SetWaitImageVisible(0);
                    sheet2.SetWaitImageVisible(0);
                    sheet5.SetWaitImageVisible(0);
                    getScNoValue();
                    formObj.f_cmd.value=COMMAND01;
//parameter changed[check again]CLT
                    var sXml=sheet5.GetSearchData("ESM_PRI_0108_02GS.do", FormQueryString(formObj));
                    var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value=backendJobKey;
                        sheet5.SetWaitTimeOut(10000);
                        timer=setInterval(getBackEndJobStatus, 3000); // after 3 seconds
                        // recursive calling
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
                getScNoValue();
                formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
                var sXml=sheetObj.GetSearchData("ESM_PRI_0108_02GS.do" , FormQueryString(formObj));
                sheet1.LoadSearchData(sXml,{Sync:1} );
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
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function getBackEndJobStatus() {
        try {
            var form=document.form;	
            form.f_cmd.value=SEARCH;
//parameter changed[check again]CLT
            var sXml=sheet5.GetSearchData("ESM_PRI_0108_02GS.do", FormQueryString(form));
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
     * @param  N/A
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function getBackEndJobLoadFile() {
        try {
            var form=document.form;
            form.f_cmd.value=SEARCHLIST;
//parameter changed[check again]CLT
            var sXml=sheet1.GetSearchData("ESM_PRI_0108_02GS.do", FormQueryString(form));
            sheet1.LoadSearchData(sXml,{Sync:1} );
        }catch(e){
            ComShowMessage(e.message);
            ComOpenWait(false);		
        }
    }
    
    /** 
     * Retrieivng and savin<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : sheet Object  
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function doActionIBSheet4(sheetObj, formObj, sAction) {
        sheet4.ShowDebugMsg(false);
        sheet4.SetWaitImageVisible(0);
        switch(sAction) {
            case IBSEARCH_ASYNC03: //Commodity, actual combo
                var scNo=getScNoValue();
                var svcScpCd=svc_scp_cd.GetSelectCode();
                var genSpclRtTpCd=gen_spcl_rt_tp_cd.GetSelectCode();
                var chkValue=scNo + svcScpCd + genSpclRtTpCd;  
                if(gBefParam == chkValue) { return; }
                cmdt_hdr_seq.RemoveAll();
                act_cust_cd.RemoveAll();
                gBefParam=chkValue;
                var params="f_cmd=" + SEARCH03;
                params += "&sc_no=" + scNo;
                params += "&svc_scp_cd=" + svcScpCd;
                params += "&gen_spcl_rt_tp_cd=" + genSpclRtTpCd;
//parameter changed[check again]CLT
                var sXml=sheet4.GetSearchData("ESM_PRI_0108_02GS.do?", params);
                sheet4.LoadSearchData(sXml,{Sync:1} );
                ComXml2ComboItem(sXml, cmdt_hdr_seq, "cmdt_hdr_seq", "cmdt_nm");
                cmdt_hdr_seq.InsertItem(0, "", "");
                ComXml2ComboItem(sXml, act_cust_cd, "cmdt_hdr_seq", "act_cust_nm");
                act_cust_cd.InsertItem(0, "", "");
                break;
        }
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
                ComShowCodeMessage("PRI00306");
                ComSetFocus(formObj);
                //event.returnValue=false;			
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
     * @param  {IBSheet} sheetObj : sheet Object  
     * @param  {object} formObj : form Object
     * @param  {sAction} sAction 
     * @return N/A
     * @see #
     * @author 
     * @version 2009.08.12
     */ 
    function validateForm(sheetObj, formObj, sAction){
        var form=document.form;
        var scNoPrefixObj=sc_no_prefix;
        var scNoSuffixObj=form.sc_no_suffix;
        var blObrdDtFromObj=form.bl_obrd_dt_from;
        var blObrdDtToObj=form.bl_obrd_dt_to;
        switch (sAction) {
            case IBSEARCH: //조회
                if(null == scNoPrefixObj.GetSelectCode()|| scNoPrefixObj.GetSelectCode()== "") {
                    ComShowCodeMessage("PRI00335", "S/C No Prefix");
                    ComSetFocus(scNoPrefixObj);
                    return false;
                }
                if(scNoSuffixObj.value == "") {
                    ComShowCodeMessage("PRI00335", "S/C No Suffix");
                    ComSetFocus(scNoSuffixObj);
                    return false;
                }
                if(!ComChkObjValid(blObrdDtFromObj)) {return false;}
                if(!ComChkObjValid(blObrdDtToObj)) {return false;}
                if(!chkObrdDate(blObrdDtFromObj)) {return false;}
                if(!chkObrdDate(blObrdDtToObj)) {return false;}    		
                break;
        }
        return true;
    }

	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
		sheetObj.ReNumberSeq();    
	}

