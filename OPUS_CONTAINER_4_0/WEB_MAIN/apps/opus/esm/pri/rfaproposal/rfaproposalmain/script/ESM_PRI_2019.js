/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019.js
*@FileTitle  : Proposal & Amendment Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var ICON_URL_NOT_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon1.gif"; 
    var ICON_URL_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon2.gif";
    // var sheetLastCol = 11;
    // Variable to focus on modifed scope
    var preSvcScpCd="";
    var preScustSeq="";
    var preScustCntCd="";
    var controlHidden=false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.17
     */
    function processButtonClick() {
        /** **************************************************** */
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
            case "btn_hidden":            	
            	setControlHidden();
            	break;
            case "btn_retrieve":
            	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
                break;
            case "btn_new":
                doActionIBSheet(sheetObjects[0],document.form,IBCREATE);                
                break; 
            case "btns_calendar1": //calendar button
	            var cal=new ComCalendar();                
	            cal.select(formObj.seff_dt, 'yyyy-MM-dd');
	            break;
            case "btn_ctrt_cust":
                ComOpenPopup("ESM_PRI_4014_POP.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.scust_cnt_cd.value+"&cust_seq="+formObj.scust_seq.value, 640, 465, "setCustomer", "none", true);
                break;     
            case "btn_dem_pop":            
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }               
                var sUrl="/opuscntr/EES_DMT_2003.do?" + "prop_no="+formObj.prop_no.value+"&amdt_seq="+formObj.amdt_seq.value + "&caller=2007";
                ComOpenPopup(sUrl, 1280, 800, "", "1,0", false);
                break;                   
            case "btn_afil_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }               
                var sParam=getParameters(srcName, "");                
                ComOpenPopup("ESM_PRI_2019_06.do?"+sParam, 1100, 400, "", "1,0", true);
                break;
            case "btn_proposal":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
	 			var pgmUrl="/opuscntr/ESM_PRI_2003.do?"
	    		var params="parentPgmNo=ESM_PRI_M001&cond_prop_no=" + formObj.prop_no.value;
				var winObj=window.open(pgmUrl + params);  
            	break;
            case "btn_history":
                if (formObj.rfa_no.value ==""){
                    ComShowCodeMessage('PRI02015');
                    return;
                }  	            	
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
	 			var pgmUrl="/opuscntr/ESM_PRI_2041.do?"
	    		var params="parentPgmNo=ESM_PRI_M001&rfa_no_2043=" + formObj.rfa_no.value;
				var winObj=window.open(pgmUrl + params);  
            	break;            	
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    
    function setCustomer(rtnVal) {
    	 if (rtnVal != null){
    		 var formObj=document.form;
           formObj.scust_cnt_cd.value=rtnVal.custCntCd;
           formObj.scust_seq.value=rtnVal.custSeq;
           formObj.sctrt_pty_nm.value=rtnVal.custNm;
         }
    }
    /**
    * registering IBSheet Object as list <br>
    * adding process for list in case of needing batch processing with other items<br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setSheetObject(sheetObj);
    * </pre>
    * @param {ibsheet} sheet_obj mandatory IBSheet Object
    * @return void
    * @author 
    * @version 2009.04.17
    */ 
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * registering IBTab Object as list <br>
    * adding process for list in case of needing batch processing with other items<br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setTabObject(tab_obj);
    * </pre>
    * @param {ibtab} tab_obj Mandatory IBTab Object
    * @return void
    * @author 
    * @version 2009.04.17
    */ 
    function setTabObject(tab_obj) {
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
    * registering IBMultiCombo Object as list
    * adding process for list in case of needing batch processing with other items<br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setComboObject(combo_obj);
    * </pre>
    * @param {ibCombo} combo_obj Mandatory IBMulti Combo Object
    * @return void
    * @author 
    * @version 2009.04.17
    */ 
    function setComboObject(combo_obj){
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
    * @author 
    * @version 2009.04.17
    */
    function loadPage() {
         for (var i=0; i < sheetObjects.length; i++) { 
            // Modify Enviroment Setting Function's name
            ComConfigSheet(sheetObjects[i]);   
            initSheet(sheetObjects[i], i + 1);          
            // Add Environment Setting Function 
            ComEndConfigSheet(sheetObjects[i]);
        }
        for (var k=0; k < tabObjects.length; k++) {
            initTab(tabObjects[k], k + 1);
        }
        //Initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        
        //Tariff Search Condition Activate
        comboObjects[2].SetVisible(true);
        
        initControl();
        initFormControl();
        sheetObjects[1].DataInsert();
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);         
        // ESM_BKG_0427 Main pop =>  2009-10-20 : Add Receiving Parameter and Writing modules to jsp.
   	 	var form=document.form;
        if("null" != form.srfa_no.value && null != form.srfa_no.value && "" != form.srfa_no.value) {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
        }     
        if("null" != form.sprop_no.value && null != form.sprop_no.value && "" != form.sprop_no.value) {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
        }
        form.srfa_no.focus();
        //UI control
        ComSetUIItem(sheetObjects[0], document.form, "PRI", "ESM_PRI_2019");
        // Load Tab Page
        loadTabPage(0);
    }
    /**
    * Catching events for Axon event.<br>
    * <br><b>Example :</b>
    * <pre>
    *     initControl()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */  
     function initControl() {
        // Process Axon Event No.1, Event Catch             
        axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
         axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
     }
     /**
     * Handling OnKeyDown even <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */       
   function obj_keydown(){
       var eleName=ComGetEvent("name");
       var keyValue=ComGetEvent("keycode");
       if (keyValue == 13){
           switch (eleName){
           case "srfa_no":
           case "sprop_no":
           case "seff_dt":
           case "sprop_ofc_cd":
           case "sprop_srep_cd":
           case "scust_cnt_cd":
           case "scust_seq":
        	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
        	   break;
           }        
       }
   }       
     /**
     * Handling Onbeforedeactivate event<br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */  
    function obj_deactivate() {
        var formObj=document.form;
        var sheetObj=sheetObjects[0]; 
        var sheetObj1=sheetObjects[0];    
        var eleName=ComGetEvent("name");
        switch(eleName){
            case "scust_cnt_cd":
                if (preScustCntCd != formObj.scust_cnt_cd.value){
                	if (formObj.scust_cnt_cd.value == ""){
                		formObj.sctrt_pty_nm.value="";
                		formObj.scust_seq.value="";
                		preScustCntCd="";
                	}else{
                    	sCustNameFind(eleName);
                    	preScustCntCd=formObj.scust_cnt_cd.value;
                	}
                }
                ComChkObjValid(ComGetEvent());
                break;  
            case "scust_seq":
                var custSeq=formObj.scust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.scust_seq.value=ComLpad(custSeq, 6, "0");
                }
                if (formObj.scust_seq.value == ""){
            		formObj.sctrt_pty_nm.value="";
            		formObj.scust_cnt_cd.value="";
            		preScustSeq="";
                }else{
                    if (ComParseInt(preScustSeq) != ComParseInt(formObj.scust_seq.value)){
                        //cust name find   
                        if (formObj.scust_seq.value !=""){                
                            sCustNameFind(eleName);
                        }
                        preScustSeq=ComParseInt(formObj.scust_seq.value);
                    }
                }
                break;
            case "seff_dt":
                ComChkObjValid(ComGetEvent());   
                break;    
            case "prop_mvc":
                ComChkObjValid(ComGetEvent());   
                break;                     
            default:
                ComChkObjValid(ComGetEvent());       
        }
    }    
    /**
    * Handling sheet's processes <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {form} formObj mandatory html form object
    * @param {int} sAction mandatory,Constant Variable
    * @return void
    * @author 
    * @version 2009.04.17
    */  
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg(false);
        try{
            switch (sAction) {            
            case IBSEARCH: // retrieving
            	ComOpenWait(true); //->waiting->start
            	preSvcScpCd=sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "svc_scp_cd");
    	    	sheetObj=sheetObjects[1];
    	        formObj.f_cmd.value=SEARCH01;
     	        var sXml=sheetObjects[0].GetSearchData("ESM_PRI_2019GS.do" , FormQueryString(formObj));
    	        var arrXml=sXml.split("|$$|");
    	        clearAllTabPages();
    	        if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0], {Sync:1});
    	        if (arrXml.length > 1) sheetObjects[2].LoadSearchData(arrXml[1], {Sync:1});
    	        ComOpenWait(false); //->waiting->End
                break;
                
            case IBSEARCH_ASYNC03: // 
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) return false;
              	formObj.f_cmd.value=SEARCH;
              	sheetObj.DoSearch("ESM_PRI_2019GS.do", FormQueryString(formObj));
      	        ComOpenWait(false); //->waiting->End
      	        break;       
      	        
            case IBCREATE: // New
    	        clearAllForms();
    	        clearAllTabPages();
    	        clearButtonImages();
    	        for(i=0; i<sheetObjects.length; i++) sheetObjects[i].RemoveAll();
    	        doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01); 
    	        form.srfa_no.focus();
                break;
                
            case IBSEARCH_ASYNC01:
            	comboObjects[0].RemoveAll();
            	comboObjects[1].RemoveAll();
            	comboObjects[2].RemoveAll();
            	ComPriTextCode2ComboItem(scopeCdValue, scopeCdText, getComboObject(comboObjects, 'ssvc_scp_cd') ,"|","\t" );
            	ComPriTextCode2ComboItem(stsCdValue, stsCdText, getComboObject(comboObjects, 'sprop_sts_cd'),"|","\t");
            	//2014.09.29
            	ComPriTextCode2ComboItem(ctrtFlgValue, ctrtFlgText, getComboObject(comboObjects, 'strf_ctrt_flg'),"|","\t");
                break;      
            }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
        	if (sAction == IBCREATE || sAction == IBSEARCH_ASYNC01) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
    }
    /**
    * setting sheet initial values and header <br>
    * adding case as numbers of counting sheets  <br>
    * <br><b>Example :</b>
    * <pre>
    *     initSheet(sheetObj,1);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} sheetNo mandatory IBSheet Object Serial No
    * @return void
    * @author 
    * @version 2009.04.17
    */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
        	case "sheet0":
        		with(sheetObj){
	        		var HeadTitle="Seq.|RFA No.|RFA No.|Proposal No.|Customer|Customer\nType|Request\nOffice|Sales\nRep.|Creation\nDate|Effective\nDate|Expiration\nDate|Status";
	        		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataGetRowMerge:1 } );
	        		var info={ Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
	        		var headers=[ { Text:HeadTitle, Align:"Center"} ];
	        		InitHeaders(headers, info);
	        		var cols=[ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				        		{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rfa_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prop_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_tp_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prop_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"prop_srep_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        		{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prop_sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	        		InitColumns(cols);
	        		SetEditable(0);
	        		SetWaitImageVisible(0);
	        		SetSheetHeight(150);
        		}
            break;
            
        case "sheet1":
        	  with(sheetObj){
		           var HeadTitle="|rfa_no|prop_no|amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|prc_prog_sts_cd"
		           HeadTitle += "|src_info_cd|pre_exp_dt|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt|cre_dt";
		           HeadTitle += "|ctrt_cust_cnt_cd|ctrt_cust_seq|ctrt_pty_nm|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|respb_sls_ofc_cd|respb_srep_cd|ctrt_cust_srep_nm|tgt_mvc_qty";
		           HeadTitle += "|cntr_lod_ut_cd|unit"
		           HeadTitle += "|prc_ctrt_cust_tp_nm|prop_prpr_flg|createtype|prop_apro_staff|dmdt_ft_tp_cd|act_cm|est_cm|trf_ctrt_flg";
		           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataGetRowMerge:1 } );
		           var info={ Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		           var headers=[ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		           var cols=[ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rfa_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"pre_exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_sts",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_srep_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_srep_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_ctrt_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_val_sgm_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_val_sgm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"respb_sls_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"respb_srep_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cust_srep_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"tgt_mvc_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_lod_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"unit",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_ctrt_cust_tp_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_prpr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_prop_cre_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_staff",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dmdt_ft_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					           {Type:"Text",      Hidden:1,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_ctrt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
		           
		       
		           InitColumns(cols);
		           SetEditable(0);
		           SetWaitImageVisible(0);
		           SetVisible(0);
           		}
            break;
            
        case "sheet2":
        	with(sheetObj){
	        	var HeadTitle="|Sel.|Prop No|Amendment Seq|SVC Scope|Duration|Duration|Target MQC|Unit";
	        	HeadTitle += "|Request Office|Sales Rep|Status Code|eff_dt|exp_dt|n1st_cmnc_dt";
	        	HeadTitle += "|Status|prc_prog_sts_cd|src_info_cd|submqcori|PRE_EXT_SCP";
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataGetRowMerge:1 } );
	        	var info={ Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	var headers=[ { Text:HeadTitle, Align:"Center"} ];
	        	InitHeaders(headers, info);
	        	var cols=[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				        	{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				        	{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				        	{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				        	{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, AcceptKeys:"E", InputCaseSensitive:1 },
				        	{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				        	{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				        	{Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"tgt_mvc_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				        	{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lod_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				        	{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				        	{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_srep_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				        	{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				        	{Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        	{Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        	{Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        	{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        	{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        	{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        	{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tgt_mvc_qty_ori",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				        	{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pre_ext_scp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	        	InitColumns(cols);
	        	SetShowButtonImage(2);
	        	SetEditable(0);
	        	SetImageList(0,"img/btns_search_off.gif");
	        	SetImageList(1,"img/btns_search.gif");
	        	SetWaitImageVisible(0);
	        	SetSheetHeight(135);
	        	}
            break;      
        }
    }
    /**
    * setting tab initial values .  <br>
    * adding process for list in case of needing batch processing with other items </b>
    * <br><b>Example :</b>
    * <pre>
    *     initTab(tabObj,1);
    * </pre>
    * @param {tabObj} tabObj Mandatory IBTab Object
    * @param {int} tabNo Mandatory IBTab Object ,Serial no for Tag's ID
    * @return void
    * @author 
    * @version 2009.04.17
    */   
    function initTab(tabObj, tabNo) {
        switch (tabNo) {
        case 1:
            with (tabObj) {
                InsertItem( "Rate ", "");
                InsertItem( "Location Group ", "");
                InsertItem( "Commodity Group ", "");
                InsertItem( "Arbitrary", "");
                InsertItem( "Special Note", "");
                SetTabIcon(0,ICON_URL_NOT_EXIST);
                SetTabIcon(1,ICON_URL_NOT_EXIST);
                SetTabIcon(2,ICON_URL_NOT_EXIST);
                SetTabIcon(3,ICON_URL_NOT_EXIST);
                SetTabIcon(4,ICON_URL_NOT_EXIST);
            }
            break;
        }
        tabObj.SetSelectedIndex(0);
    }
    /**
    * setting intial combo value <br>
    * <br><b>Example :</b>
    * <pre>
    *     initCombo(comboObj,1);
    * </pre>
    * @param {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
    * @return void
    * @author 
    * @version 2009.04.17
    */         
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "ssvc_scp_cd":
                var i=0;
                with(comboObj) {
                    //BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
	                SetUseAutoComplete(1);
	            	SetMaxLength(3);
	            	ValidChar(2);
                }
                break;     
                
            case "sprop_sts_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    // BackColor = "cyan";
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(9);
                }     
                break; 
                
              //2014.09.29 add
            case "strf_ctrt_flg":
                var i=0;
                with(comboObj) {  
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(3);
                }     
                break; 
        }
    }
    /**
    * handling process for input validation <br>
    * <br><b>Example :</b>
    * <pre>
    *     if (validateForm(sheetObj,document.form,IBSAVE)) {
    *        handling logic
    *     }
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {form} formObj mandatory html form object
    * @param {int} sAction mandatory,Constant Variable
    * @return bool <br>
    *          true  : valid<br>
    *          false : inValid
    * @author 
    * @version 2009.04.17
    */
   function validateForm(sheetObj, formObj, sAction) {
       switch (sAction) {
       	case IBSEARCH_ASYNC03: // Retrieving
       		var k=0;
	       	if (ComTrim(formObj.srfa_no.value) != "" ){
	       		k++;
	       	}
	       	if (ComTrim(formObj.sprop_no.value) != ""){
	       		k++;
	       	}
	       	if (ComTrim(formObj.seff_dt.value) != "" ){
	       		k++;
	       	}
	       	if (ComTrim(ssvc_scp_cd.GetSelectCode()) != ""){
	       		k++;
	       	}
	       	if (ComTrim(formObj.scust_cnt_cd.value) != "" && ComTrim(formObj.scust_seq.value) !="" ){
	       		k++;
	       	}
	       	if (k < 1){
	       		ComShowCodeMessage("PRI01101");
	       		return false;
	       	}       	
           break;           
       }
       return true;
   }           
   /**
    * Activating selected tab in case of cliking Tab<br>
    * <br><b>Example :</b>
    * <pre>
    *     tab1_OnChange(tabObj, tabIndex)
    * </pre>
    * @param {tabObj} tabObj Mandatory IBTab Object
    * @param {int} tabIndex Mandatory ,Process Flag constant variable
    * @return void
    * @author 
    * @version 2009.04.17
    */ 
    function tab1_OnChange(tabObj, nItem) {
    	formObject = document.form;
	   	var objs=document.all.item("tabLayer");
	   	objs[nItem].style.display="Inline";
	   	for(var i = 0; i< objs.length; i++){
	       	  if(i != nItem){
		        	   objs[i].style.display="none";
		        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       	  }
	   	}
	   	beforetab=nItem;
	   	loadTabPage(nItem);
    }
    /**
    * Loading a screen to frame when changing Tab<br>
    * <br><b>Example :</b>
    * <pre>
    *     loadTabPage(tabIndex)
    * </pre>
    * @param {tabIndex} tabIndex Mandatory tab's serial no
    * @return void
    * @author 
    * @version 2009.04.17
    */      
    function loadTabPage(tabIndex) {
        if (tabIndex == null || tabIndex == "") {
            tabIndex=tabObjects[0].GetSelectedIndex();
        }
        var objTabWindow=document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
        if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
            var sUrl="";
            switch (tabIndex) {
            case 0:
                sUrl="ESM_PRI_2019_07.do"; //Rate
                break;
            case 1:
                sUrl="ESM_PRI_2019_02.do"; //Location Group
                break;
            case 2:
                sUrl="ESM_PRI_2019_03.do"; //Commodity Group
                break;
            case 3:
                sUrl="ESM_PRI_2019_04.do"; //Arbitrary
                break;
            case 4:
                sUrl="ESM_PRI_2019_01.do"; //Special Note
                break;
            }
            objTabWindow.location.href=sUrl;
            return true;
        }
        var sheetObj1=sheetObjects[1];
        var sheetObj2=sheetObjects[2];
        var sRow=sheetObj2.GetSelectRow();
        var sPropNo=sheetObj2.GetCellValue(sRow,"prop_no");
        var sAmdtSeq=sheetObj2.GetCellValue(sRow, "amdt_seq");
        var sSvcScpCd=sheetObj2.GetCellValue(sRow, "svc_scp_cd");
        if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" && sheetObj2.GetCellValue(sRow, "ibflag")!="I") {
        	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd);
        }       
    }
    /**
    * Clearing all data of sheet which is loaded on Tab<br>
    * <br><b>Example :</b>
    * <pre>
    *     clearAllTabPages()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */         
    function clearAllTabPages() {
        for (var i=0; i < tabObjects[0].GetCount(); i++) {
            tabObjects[0].SetTabIcon(i,ICON_URL_NOT_EXIST);
            /*var obj = ComGetObject("t" + (i + 1) + "frame");
            if (obj.tabClearSheet) {
            	obj.tabClearSheet();
            }*/
            if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
                document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
            }
        }
    }
    /**
    * Initializaing duration,Mvc,afiliate button's image<br>
    * <br><b>Example :</b>
    * <pre>
    *		clearButtonImages();
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.05.07
    */
    function clearButtonImages(){
//        document.images("img_affil").src=ICON_URL_NOT_EXIST;
    }
    /**
     * Define the color of button, Deactivate Check Box.<br>
     * <br><b>Example :</b>
     * <pre>
     *		clearButtonImages();
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.05.07
     */      
    function initFormControl(){
        document.getElementById("btn_afil_pop").style.color="black";
        
        //2014.10.15 DEFAULT SEARCH DATE SET
        var rDate = new Date();
        var yy = rDate.getFullYear();
        var mm = rDate.getMonth() + 1 +"";
        var dd = rDate.getDate() +"";
        if (mm.length == 1) mm = "0" + mm;
        if (dd.length == 1) dd = "0" + dd;              
    	
        document.form.seff_dt.value = ComGetMaskedValue(yy+mm+dd,"ymd","-");
    }    
    /**
    * Clearing inputted fields on screen and a value of IBMulti Combo Object <br>
    * <br><b>Example :</b>
    * <pre>
    *     clearAllForms()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */       
    function clearAllForms(){
        var formObj=document.form;
        for (var i=0; i < 2; i++){
        	comboObjects[i].SetSelectIndex(-1);
        }
        formObj.srfa_no.value="";
        formObj.sprop_no.value="";
        formObj.seff_dt.value="";
        formObj.svc_scp_nm.value="";
        formObj.sprop_ofc_cd.value="";
        formObj.sprop_srep_cd.value="";
        formObj.scust_cnt_cd.value="";
        formObj.scust_seq.value="";
        formObj.sctrt_pty_nm.value="";       
        formObj.rfa_no.value="";        
        formObj.amdt_seq.value="";        
        formObj.prop_no.value="";        
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";        
        formObj.prop_srep_cd.value="";        
        formObj.prop_srep_nm.value="";
        formObj.prop_apro_staff.value="";
        formObj.cre_dt.value="";
        formObj.ctrt_cust_cnt_cd.value="";
        formObj.ctrt_cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        formObj.prc_ctrt_cust_tp_nm.value="";
        formObj.ctrt_cust_val_sgm.value="";        
        formObj.respb_srep_cd.value="";        
        formObj.respb_sls_ofc_cd.value="";     
        formObj.ctrt_cust_srep_nm.value="";
        formObj.tgt_mvc_qty.value="";
        formObj.prop_mvc.value="";
        formObj.prop_mvc_tp.value="";
        formObj.dmdt_ft_tp_cd.value="";
        formObj.prop_apro_ofc_cd.value="";
        formObj.prop_apro_dt.value="";
        formObj.cntr_lod_ut_cd.value="";
        formObj.trf_ctrt_flg.checked=false;
        
        $("img[name=img_affil]").attr('src', ICON_URL_NOT_EXIST);

        
    }
    /**
    * Changing Sheet's popup button image<br>
    * <br><b>Example :</b>
    * <pre>
    *     sheetButtonImageChange(sheetObj, Row, sw)
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row Mandatory ,Cell'sRow Index        
    * @return {int} <br>
    *          0 : Deactivation<br>
    *          1 : Activation
    * @author 
    * @version 2009.04.17
    */
    function sheetButtonImageChange(sheetObj, Row, sw){      
    }
    /**
     * event in case of losting IBMulti Combo's focus<br>
     * Setting Combo's text value to Html object<br>
     * <br><b>Example :</b>
     * <pre>
     *    ssvc_scp_cd_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return void
     * @author 
     * @version 2009.04.17
     */ 
	/*function ssvc_scp_cd_OnBlur(comboObj) {
		var formObj=document.form;		
		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		if (code != null && code != "") {
			var text=comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
			}
		}
	}    */
    /**
    * event in case of changing selected item of IBMulti Combo<br>
    * Fill Scope name using Text field of Combo Item. <br> 
    * <br><b>Example :</b>
    * <pre>
    *    ssvc_scp_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} code Mandatory code
    * @param   {string} text Mandatory ,Character on screen 
    * @return void
    * @author 
    * @version 2009.04.17
    */ 	
  	function ssvc_scp_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
  		var formObj=document.form;
		formObj.svc_scp_nm.value=ComPriGetNameFromComboVal(comboObj, NewCod);
	}	
    /**
    * event in case of pressing KeyBoard in IBMulti Comb<br>
    * changing focus to next object in case of exceeding designated length<br>
    * <br><b>Example :</b>
    * <pre>
    *    ssvc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} KeyCode Mandatory Ascii code Value
    * @param   {string} Shift   Displaying whether Mandatory shift is keyup
    * @return void
    * @author 
    * @version 2009.04.17
    */      	
	function ssvc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var svcScpCdTxt=comboObj.GetSelectText();
		if (svcScpCdTxt.length > 3) {
			document.form.svc_scp_nm.focus();
		}
	}
    /**
    * This event triggered When all item deleted in IBMulti Combo.<br>
    * Clear the Scope's Name.<br>
    * <br><b>Example :</b>
    * <pre>
    *    ssvc_scp_cd_OnClear(comboObj);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @return void
    * @author 
    * @version 2009.04.17
    */ 	
	function ssvc_scp_cd_OnClear(comboObj) {
		var formObject=document.form;
		formObject.svc_scp_nm.value="";
		ssvc_scp_cd.SetSelectIndex(-1);
	}  	
    /**
    * Execute any key pressed on keyboard.<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} KeyCode Mandatory Ascii code Value
    * @param   {string} Shift   Displaying whether Mandatory shift is keyup
    * @return void
    * @author 
    * @version 2009.04.17
    */
	function ssvc_scp_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}     
    /**
    * Execute any key pressed on keyboard.<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} KeyCode Mandatory Ascii code Value
    * @param   {string} Shift   Displaying whether Mandatory shift is keyup
    * @return void
    * @author 
    * @version 2009.04.17
    */
	function sprop_sts_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
 	}  	
     /**
     * calling function in case of OnSort event <br>
     * After Sorting that column, Retrieve again.<br>
     * <br><b>Example :</b>
     * <pre>
     *		
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int}     Col Sorted Column Index
     * @return void
     * @author 
     * @version 2009.04.17
     */       
     function sheet0_OnSort(sheet, Col) {  
    	 var row=sheet.GetSelectRow();
    	 sheet0_OnSelectCell(sheet, -1, -1, row, 1);
     }
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * Setting HTML object's value to sheet's value after retrieving sheet<br>
     * <br><b>Example :</b>
     * <pre>
     * 	sheet0_OnSearchEnd(sheetObj, errMsg)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.05.20
     */ 
    function sheet0_OnSearchEnd(sheetObj, Code, errMsg){
        var formObj=document.form;
        
        formObj.prop_no.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"prop_no");
        formObj.amdt_seq.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq");
        if(sheetObj.GetSelectRow() < 0) {
        	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
        } 
    }
    /**
    * calling function in case of OnSelectCell event <br>
    * Retrieve using Proposal No & Amdt Seq No. <br>
    * <br><b>Example :</b>
    * <pre>
    *		sheet0_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} OldRow Mandatory ,previous selected cell's Row Index
    * @param {int} OldCol Mandatory Previous selected Cell's Column Index
    * @param {int} NewRow Mandatory ,current selected cell's Row Index
    * @param {int} NewCol Mandatory ,current selected cell's Column Index
    * @return void
    * @author 
    * @version 2009.04.17
    */  
    function sheet0_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
     	if(OldRow!=NewRow){
            var formObj=document.form;
            formObj.prop_no.value=sheetObj.GetCellValue(NewRow,"prop_no");
            formObj.amdt_seq.value=sheetObj.GetCellValue(NewRow,"amdt_seq");
     		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
         }
     }   
    /**
    * Calling Function in case of OnSearchEnd event <br>
    * Setting HTML object's value to sheet's value after retrieving sheet<br>
    * <br><b>Example :</b>
    * <pre>
    * 	sheet1_OnSearchEnd(sheetObj, errMsg)
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {string} ErrMsg mandatory from server
    * @return void
    * @author 
    * @version 2009.05.20
    */ 
    function sheet1_OnSearchEnd(sheetObj, Code, errMsg){
        var formObj=document.form;
        
        if(sheetObj.RowCount() == 0) {
        	formObj.rfa_no.value="";
			formObj.prop_no.value="";
			formObj.amdt_seq.value="";
			formObj.ctrt_eff_dt.value="";
			formObj.ctrt_exp_dt.value="";
			formObj.prop_sts.value="";
			formObj.prop_ofc_cd.value="";
			formObj.prop_srep_cd.value="";
			formObj.prop_srep_nm.value="";
			formObj.prop_apro_ofc_cd.value="";
			formObj.prop_apro_staff.value="";
			formObj.cre_dt.value="";
			formObj.prop_apro_dt.value="";
			formObj.ctrt_cust_cnt_cd.value="";        
			formObj.ctrt_cust_seq.value="";        
			formObj.ctrt_pty_nm.value="";
			formObj.prc_ctrt_cust_tp_nm.value="";
			formObj.ctrt_cust_val_sgm.value="";
			formObj.respb_sls_ofc_cd.value="";
			formObj.respb_srep_cd.value="";
			formObj.ctrt_cust_srep_nm.value="";
			formObj.tgt_mvc_qty.value="";
			formObj.cntr_lod_ut_cd.value="";
			formObj.dmdt_ft_tp_cd.value="";
			
			//2014.09.29
	        formObj.trf_ctrt_flg.checked = sheetObj.GetCellValue(1,"trf_ctrt_flg") == "Y" ? true : false;
        	
        } else {
        
			formObj.rfa_no.value=sheetObj.GetCellValue(1,"rfa_no");
			formObj.prop_no.value=sheetObj.GetCellValue(1,"prop_no");
			formObj.amdt_seq.value=sheetObj.GetCellValue(1,"amdt_seq");
			formObj.ctrt_eff_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"ctrt_eff_dt"),"ymd");
			formObj.ctrt_exp_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"ctrt_exp_dt"),"ymd");
			formObj.prop_sts.value=sheetObj.GetCellValue(1,"prop_sts");
			formObj.prop_ofc_cd.value=sheetObj.GetCellValue(1,"prop_ofc_cd");
			formObj.prop_srep_cd.value=sheetObj.GetCellValue(1, "prop_srep_cd");
			formObj.prop_srep_nm.value=sheetObj.GetCellValue(1,"prop_srep_nm");
			formObj.prop_apro_ofc_cd.value=sheetObj.GetCellValue(1,"prop_apro_ofc_cd");
			formObj.prop_apro_staff.value=sheetObj.GetCellValue(1,"prop_apro_staff");
			formObj.cre_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"cre_dt"), "ymd");
			formObj.prop_apro_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"prop_apro_dt"),"ymd");
			formObj.ctrt_cust_cnt_cd.value=sheetObj.GetCellValue(1,"ctrt_cust_cnt_cd");
			if (sheetObj.GetCellValue(1, "ctrt_cust_seq") !="" ){
				formObj.ctrt_cust_seq.value=ComLpad(sheetObj.GetCellValue(1,"ctrt_cust_seq"), 6, "0");
	        }else{
	            formObj.ctrt_cust_seq.value="";
	        }        
			formObj.ctrt_pty_nm.value=sheetObj.GetCellValue(1,"ctrt_pty_nm");
			formObj.prc_ctrt_cust_tp_nm.value=sheetObj.GetCellValue(1,"prc_ctrt_cust_tp_nm");
			formObj.ctrt_cust_val_sgm.value=sheetObj.GetCellValue(1,"ctrt_cust_val_sgm");
			formObj.respb_sls_ofc_cd.value=sheetObj.GetCellValue(1,"respb_sls_ofc_cd");
			formObj.respb_srep_cd.value=sheetObj.GetCellValue(1, "respb_srep_cd");
			formObj.ctrt_cust_srep_nm.value=sheetObj.GetCellValue(1,"ctrt_cust_srep_nm");
			formObj.tgt_mvc_qty.value=ComAddComma(sheetObj.GetCellValue(1,"tgt_mvc_qty"));
			formObj.cntr_lod_ut_cd.value=sheetObj.GetCellValue(1, "unit");
			formObj.dmdt_ft_tp_cd.value=sheetObj.GetCellValue(1,"dmdt_ft_tp_cd");
			
			//2014.09.29
	        formObj.trf_ctrt_flg.checked = sheetObj.GetCellValue(1,"trf_ctrt_flg") == "Y" ? true : false;

        }
		
        if (formObj.dmdt_ft_tp_cd.value !="Exception"){
        	ComBtnDisable("btn_dem_pop"); 
        	document.getElementById("btn_dem_pop").style.color="";
        } else{
        	ComBtnEnable("btn_dem_pop"); 
        	document.getElementById("btn_dem_pop").style.color="black";
        }
        //UI control
        ComSetUIItem(sheetObjects[0], document.form, "PRI", "ESM_PRI_2019");
        
        
    }   
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * Putting a value into added column to calculate MQC
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.05.20
     */         
    function sheet2_OnSearchEnd(sheetObj, Code, errMsg){
        var sheetObj=sheetObjects[1];
        var formObj=document.form;
        for (var i = 1; i <= getValidRowCount(sheetObj); i++){          
        	if (preSvcScpCd == sheetObj.GetCellValue(i, "svc_scp_cd")){
                sheetObj.SelectCell(i, 1);
                break;
            }
        }
        loadTabPage(beforetab);	
        calcMVC();
    } 
    /**
     * calling function in case of OnSelectCell event <br>
     * Changing tab's icon after loading term's data for selected scope to Frame<br>
     * <br><b>Example :</b>
     * <pre>
     *		sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} OldRow Mandatory ,previous selected cell's Row Index
     * @param {int} OldCol Mandatory Previous selected Cell's Column Index
     * @param {int} NewRow Mandatory ,current selected cell's Row Index
     * @param {int} NewCol Mandatory ,current selected cell's Column Index
     * @return void
     * @author 
     * @version 2009.04.17
     */  
     function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
         try{
        	 ComOpenWait(true); //->waiting->start
        	 if(sheetObj.GetCellValue(NewRow,"svc_scp_cd")!="" && OldRow!=NewRow&&sheetObj.GetCellValue(NewRow,"ibflag")!="I"){
        		 comApplyStyleProposalStatusSummary(sheetObj.GetCellValue(NewRow,"svc_scp_cd"));
                 // 0728
                 if (tabObjects[0].GetSelectedIndex()== 0) {
                     tab1_OnChange(tabObjects[0], 0);
                 } else {
                     tabObjects[0].SetSelectedIndex(0);
                 }           
                  loadTabPage(beforetab);            
        	 } else if(sheetObj.GetCellValue(NewRow,"ibflag")=="I"){
                  if (NewRow != OldRow){
                     clearAllTabPages(); 
                  }
              }        	 
        	 ComOpenWait(false);
         } catch (e) {
           	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         } finally{
         	ComOpenWait(false); //->waiting->End
         }
     }
/*    
 *  *//**
      * Calling function in case of OnPopupClick event<br>
      * Calling Scope Duration. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
      * @param {int} Col Mandatory OnPopupClick 'Cell's Column Index
      * @return void
      * @author 
      * @version 2009.05.07
      *//*    
    function sheet2_OnPopupClick(sheetObj, Row, Col)
    {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        switch(colName)
        {
            case "scp_dur_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }               
                var sSvcScpCd="&sSvcScpCd=" + sheetObj.GetCellValue(Row, "svc_scp_cd");
                var sParam=getParameters(colName, sSvcScpCd);                
                var rtnVal=ComPriOpenWindowCenter ("/opuscntr/ESM_PRI_2010.do?"+sParam, "", 635, 320, true);
                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);    
                }  
                break;
        }
    }           */
     
     
    /**
    * Calculating MVC with MQC<br>
    * MVC = MQC / Duration valid days x 7 <br>
    * <br><b>Example :</b>
    * <pre>
    *		calcMVC();
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.05.07
    */ 
    function calcMVC(){
        var formObj=document.form;
        var mqcQty=sheetObjects[1].GetCellValue(1, "tgt_mvc_qty");
        var sDay=formObj.ctrt_eff_dt.value;
        var eDay=formObj.ctrt_exp_dt.value;
        var mvcQty=0;     
        var durDay=ComGetDaysBetween(sDay, eDay);
        if (mqcQty != "" && mqcQty != "0"){
            if (durDay != 0){
            	mvcQty=ComRound((mqcQty / durDay * 7),0);
            }        	
        }   
        formObj.prop_mvc.value=ComAddComma(mvcQty);        
        formObj.prop_mvc_tp.value=formObj.cntr_lod_ut_cd.value;
    }   
    /**
     * Setting Sales rep for inputted Customer Sale Office to IBMulti Combo<br>
     * <br><b>Example :</b>
     * <pre>
     *		setCustSaleRep();
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.05.07
     */  
    function setCustSaleRep(){              
        var formObj=document.form;
        var sheetObj=sheetObjects[1];
        if (formObj.ctrt_cust_cnt_cd.value !="" && formObj.ctrt_cust_seq.value !=""){         
            formObj.f_cmd.value=COMMAND20;       
            sParam=FormQueryString(formObj) +"&etc1="+formObj.respb_sls_ofc_cd.value;
            sXml=sheetObj.GetSearchData("PRICommonGS.do",sParam);
            ComPriXml2ComboItem(sXml, formObj.respb_srep_cd, "cd", "cd|nm");
        }
    }
    /**
    * Setting Sales rep for inputted Office to IBMulti Combo<br>
    * <br><b>Example :</b>
    * <pre>
    *		setRequestOfficeSaleRep();
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.05.07
    */  
    function setRequestOfficeSaleRep(){
        var formObj=document.form;
        var sheetObj=sheetObjects[1];
        formObj.f_cmd.value=SEARCH15;     
        var sParam=FormQueryString(formObj) +"&etc1="+formObj.prop_ofc_cd.value;
        var sXml=sheetObj.GetSearchData("PRICommonGS.do",sParam);
        ComPriXml2ComboItem(sXml, formObj.prop_srep_cd, "cd", "cd|nm");
    }
    /**
    * Retrieve SaleRep.'s Office Code.<br>
    * <br><b>Example :</b>
    * <pre>
    *		getOfficeCd(srepCd);
    * </pre>
    * @param  {string} srepCd Mandatory sale rep. code
    * @return  string  Office Code
    * @author 
    * @version 2009.05.07
    */  
    function getOfficeCd(srepCd){       
        document.form.f_cmd.value=COMMAND21;
        var sParam=FormQueryString(document.form)+"&etc1="+srepCd;
        var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", sParam);
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
    *		clearCustName();
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.05.07
    */  
    function clearCustName(){
        var formObj=document.form;
        var sheetObj=sheetObjects[1];
		sheetObj.SetCellValue(1,"prc_ctrt_cust_tp_cd","");
		sheetObj.SetCellValue(1,"ctrt_pty_nm","");
		sheetObj.SetCellValue(1,"ctrt_cust_val_sgm_cd","");
		sheetObj.SetCellValue(1,"ctrt_cust_val_sgm","");
		sheetObj.SetCellValue(1,"respb_srep_cd","");
		sheetObj.SetCellValue(1,"respb_sls_ofc_cd","");
		sheetObj.SetCellValue(1,"prc_ctrt_cust_tp_nm","");
        formObj.ctrt_cust_cnt_cd.value="";
        formObj.ctrt_cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        formObj.respb_srep_cd.value="";
        formObj.ctrt_cust_val_sgm.value="";
        formObj.respb_sls_ofc_cd.value="";
        formObj.ctrt_cust_srep_nm.value="";
        formObj.prc_ctrt_cust_tp_nm.value="";
    }
    /**
     * Modifying Tab's icon accorting to added data and modification of each terms in main and scope<br>
     * <br><b>Example :</b>
     * <pre>
     *    comApplyStyleProposalStatusSummary(termTpCd, svcScpCd);
     * </pre>
     * @param   {string} svcScpCd selection   Scope code
     * @return void
     * @author 
     * @version 2009.04.17
     */ 
     function comApplyStyleProposalStatusSummary(svcScpCd){
         var formObj=document.form;
         formObj.f_cmd.value=SEARCH04;
         var sXml=sheetObjects[0].GetSearchData("ESM_PRI_2019GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd);
         var arrText=ComPriXml2Array(sXml, "prop_scp_term_tp_cd|dat_flg");
         var icon="";
         var tabIdx="";
         var imgName="";
         for (i=0; i < arrText.length; i++){
             tabIdx="";
             imgName="";
             switch(arrText[i][0]){
                case '01':  //Duration,Scope Duration
                    imgName="";
                     break;
                 case '02':  //MQC,Scope MQC
                  imgName="";
                     break;  
                 case '05':
                     imgName="img_affil";
                     break;
                 case '08':
                     imgName="";
                     break;                  
                 case '13':  //Group Location
                     tabIdx="1";
                     break;                  
                 case '14':  //Group Commodity
                     tabIdx="2";                 
                     break;     
                 case '32':  //Special Note
                     tabIdx="4";
                     break;
                 case '52':  //Arbitrary                 
                     tabIdx="3";
                     break;     
                 case '71':  //Rate                  
                    tabIdx="0";
                     break;  
             }
             icon=ICON_URL_NOT_EXIST;
             switch(arrText[i][1]){
                 case "1":
                 case "2":
                 case "3":
                	 icon=ICON_URL_EXIST;
                     break;
             }
             if (arrText[i][0] == "01" || arrText[i][0] =="02"||arrText[i][0] == "05"||arrText[i][0] == "08" ){
//                 if (imgName !="") document.images.imgName.src=icon;
                 if (imgName !="") $("img[name="+imgName+"]").attr('src', icon);
             }else{
                 if (tabIdx !="") 
            	 {
                	 tabObjects[0].SetTabIcon(tabIdx,icon);
            	 }
                	
             }   
         }        
     }
     /**
     * Create common parameter when Popup opens.<br>
     * <br><b>Example :</b>
     * <pre>
     *    getParameters(srcName, param);
     * </pre>
     * @param   {string} srcName Mandatory  Html Object Name
     * @param   {string} param Optional, Passing Parameter Depend on screen
     * @return void
     * @author 
     * @version 2009.04.17
     */   
     function getParameters(srcName, param){        
         var sheetObj=sheetObjects[1];
         var sRfaNo=sheetObj.GetCellValue(1,"rfa_no");
         var sPropNo=sheetObj.GetCellValue(1,"prop_no");
         var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
         var sSvcScpCd="";
         var aParam="";
         var sCtrtEffDt=document.form.ctrt_eff_dt.value;
         var sCtrtExpDt=document.form.ctrt_exp_dt.value;  
         var sParam="sRfaNo="+sRfaNo+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq;
         switch (srcName) {        
            case "btn_afil_pop":
                aParam="&sCtrtEffDt="+sCtrtEffDt+"&sCtrtExpDt="+sCtrtExpDt;               
                sParam += aParam;
                break;
            } 
         return sParam;
     }
     /**
     * Returns Customer Type. <br>
     * <br><b>Example :</b>
     * <pre>
     *     getCustTpCd()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */      
    function getCustTpCd(){
        var custTpCd="";
        var sheetObj=sheetObjects[1];
        custTpCd=sheetObj.GetCellValue(1, "prc_ctrt_cust_tp_cd");
        return custTpCd;
    }
    /**
    * event in case of losting IBMulti Combo's focus<br>
    * Setting Combo's text value to Html object<br>
    * <br><b>Example :</b>
    * <pre>
    *    prop_srep_cd_OnBlur(comboObj);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @return void
    * @author 
    * @version 2009.04.17
    */ 
    function prop_srep_cd_OnBlur(comboObj) {
        var formObj=document.form;        
        var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
        if (code != null && code != "") {
            var text=comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.prop_srep_nm.value) {
                formObj.prop_srep_nm.value=comboObj.GetText(code, 1);
            }
        }
    }     
    /**
     * allowing to use widely a screen by showing or hiding a part of screen<br>
     * <br><b>Example :</b>
     * <pre>
     *    setControlHidden();
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */   
   	function setControlHidden(){
   		if (!controlHidden){
   			document.all.subterms.style.display="none";
   			controlHidden=true;
   		} else{
   			document.all.subterms.style.display="inline";
   			controlHidden=false;
   			sheet1_OnSearchEnd(sheetObjects[1], "");
   		}
   		try{
   		    parent.syncHeight();  
   			}catch(e){}
   	}  
    /**
     * Activating and deactivating image buttons<br>
     * <br><b>Example :</b>
     * <pre>
     *    btnImgEnable(obj, gb);
     * </pre>
     * @param  {form} obj Mandatory Html Object
     * @param  {bool} gb  Mandatory true : Activating, false : Deactivation
     * @return void
     * @author 
     * @version 2009.04.17
     */ 
    function btnImgEnable(obj, gb) {
        if(obj.constructor == String){
            obj=document.getElementsByName(obj)[0];            
        }
        ComEnableObject(obj,gb);
    }
    /**
    * Retrieving Customer information<br>
    * <br><b>Example :</b>
    * <pre>
    *		custNameFind(eleName);
    * </pre>
    * @param  {string} eleName Mandatory Html Object Name
    * @return void
    * @author 
    * @version 2009.05.07
    */     
    function sCustNameFind(eleName){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var cust_cnt_cd=formObj.scust_cnt_cd.value;        
        var cust_seq=formObj.scust_seq.value;      
        if(cust_cnt_cd != "" && cust_seq !=""){
            var sParam="f_cmd="+SEARCH02+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;
            var sXml=sheetObj.GetSearchData("ESM_PRI_2019GS.do", sParam);
            var arrText=ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_cust_srep_nm|oti_no");
            if(arrText==undefined){
          	  	formObj.scust_cnt_cd.value="";
          	  	formObj.sctrt_pty_nm.value="";
          	  	formObj.scust_seq.value="";
                formObj.scust_cnt_cd.focus();
            } else{
                formObj.sctrt_pty_nm.value=arrText[0][1];              
            }
        }
    }  
