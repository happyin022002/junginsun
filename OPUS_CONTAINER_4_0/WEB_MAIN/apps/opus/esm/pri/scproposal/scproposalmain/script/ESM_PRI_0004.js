/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004.js
*@FileTitle  : Proposal & Amendment Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // global variables
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var preSvcScpCd="";
    var preScustCntCd="";
    var prePropOfcCd="";
    var preScustSeq="";
    var controlHidden=false;
    var timer=0;
    var backEndJobCnt=0;
    var ihcTabSts=true;
    var ICON_URL_NOT_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon1.gif"; 
    var ICON_URL_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon2.gif";
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    /**
     * Event handler processing by button name  <br>
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
                doActionIBSheet(sheetObjects[1],document.form,IBCREATE);
                break;                
            case "btn_ctrt_cust":
                ComOpenPopup("ESM_PRI_4014_POP.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.scust_cnt_cd.value+"&cust_seq="+formObj.scust_seq.value, 640, 430, "btn_ctrt_cust_returnVal", "none", true);
                break;                  
            case "btn_blpl_pop":
                var formObj=document.form;                
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                ComOpenPopup("ESM_PRI_0047.do?"+getParameters("btn_blpl_pop"), 1000, 500, "", "none", true);
                break;  
            case "btn_ctrt_pty_pop":
                var formObj=document.form;                
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                ComOpenPopup("ESM_PRI_0078.do?"+getParameters("btn_ctrt_pty_pop"), 900, 400, "", "none", true);
                break;                  
            case "btn_afil_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }                
                ComOpenPopup("ESM_PRI_0048.do?"+getParameters("btn_afil_pop"), 1100, 400, "", "none", true);
                break;
            case "btns_calendar1": 
            case "btns_calendar2":
                var cal=new ComCalendarFromTo();                
                cal.select(document.form.seff_dt1, document.form.seff_dt2, 'yyyy-MM-dd');
                break;  
            case "btn_proposal":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }	
	 		
	    		var params="&cond_prop_no=" + formObj.prop_no.value;				
	 			var sUrl="ESM_PRI_0003.do?parentPgmNo=ESM_PRI_M001&pgmNo=ESM_PRI_0003&MENU=Y&menuflag=true&mainPage=true" + params;	
	 			var sId="ESM_PRI_0003";
				var winObj=window.open("/opuscntr/"+sUrl , sId);	  
				
            	break;      
            case "btn_history":
                if (formObj.sc_no.value ==""){
                    ComShowCodeMessage('PRI02014');
                    return;
                }              	
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
	 			var pgmNo="ESM_PRI_0057";
	 			var pgmUrl="/opuscntr/ESM_PRI_0057.do"
	    		var params="&sc_no_0062=" + formObj.sc_no.value;
				var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
	 			var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
				var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
				var winObj=window.open("ESM_PRI_0057.do?parentPgmNo=" + parentPgmNo + src, pgmNo);	  

				break;               	
            /*case "btn_prop_pfmc_pop":
                if (formObj.sc_no.value ==""){
                    ComShowCodeMessage('PRI01061');
                    return;
                }	
	 			var pgmNo="ESM_PRI_0108";
	 			var pgmUrl="/opuscntr/ESM_PRI_0108.do"
	    		var params="&cond_sc_no=" + formObj.sc_no.value;
				var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
	 			var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
				var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
				var winObj=window.open("opusMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);              	
                break; */                 	
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * creating common parameter when calling pop-up<br>
     */     
     function getParameters(srcName){        
         var sheetObj=sheetObjects[1];
         var sheetScp=sheetObjects[2];
         var formObj=document.form;
		var sSc_No=sheetObj.GetCellValue(1,"sc_no1")+sheetObj.GetCellValue(1,"sc_no2");
		var sPropNo=sheetObj.GetCellValue(1,"prop_no");
		var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
         var sParam="";
         var sParam="sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq
         switch (srcName) {        
            case "btn_blpl_pop":
                var sCtrtEffDt=formObj.ctrt_eff_dt.value;
                var sCtrtExpDt=formObj.ctrt_exp_dt.value;
                var sBlplHdrSeq=sheetObj.GetCellValue(1, "blpl_hdr_seq");
                sParam += "&sCtrtEffDt="+sCtrtEffDt+"&sCtrtExpDt="+sCtrtExpDt +"&sBlplHdrSeq="+sBlplHdrSeq;;
                break;
            case "btn_ctrt_pty_pop":
            	var sCustCntCd=sheetObj.GetCellValue(1, "cust_cnt_cd");
            	var sCustSeq=ComLpad(sheetObj.GetCellValue(1, "cust_seq"), 6, "0");
            	var sCustNm=ComReplaceStr(sheetObj.GetCellValue(1, "ctrt_pty_nm"),"'"," ");//�뺤씤��
                sParam += "&sCustCntCd="+sCustCntCd+"&sCustSeq="+sCustSeq+"&sCustNm="+sCustNm;
                break;
            case "btn_afil_pop":
                var sCtrtEffDt=formObj.ctrt_eff_dt.value;
                var sCtrtExpDt=formObj.ctrt_exp_dt.value;         
                sParam += "&sCtrtEffDt="+sCtrtEffDt+"&sCtrtExpDt="+sCtrtExpDt;
                break;
            } 
         return sParam;
     }    
    /**
    * registering IBSheet Object as list <br>
    * adding process for list in case of needing batch processing with other items  <br>
    * defining list on the top of source <br>
    */       
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * registering IBTab Object as array <br>
    * adding process for list in case of needing batch processing with other items  <br>
    * defining list on the top of source <br>
    */        
    function setTabObject(tab_obj) {
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
    * registering IBMulti Combo Object as array <br>
    * adding process for list in case of needing batch processing with other items  <br>
    * defining list on the top of source <br>
    */      
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
    * Initializing and setting Sheet basics <br>
    * Setting body tag's onLoad event handler <br>
    * Adding pre-handling function after loading screen on the browser  <br>
    */
    function loadPage() {
        for (var i=0; i < sheetObjects.length; i++) { 
            ComConfigSheet(sheetObjects[i]);    
            initSheet(sheetObjects[i], i + 1);          
            ComEndConfigSheet(sheetObjects[i]);
            sheetObjects[i].XmlHttpVer=2;
        }
        for (var k=0; k < tabObjects.length; k++) {
            initTab(tabObjects[k], k + 1);
        }
        //initializing IBMultiCombo
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }        
        initControl();
        initFormControl();
        
        sheetObjects[1].DataInsert();
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01); 
      
        var chkSearch=false;
   	 	var form=document.form;

   	 	
        if("null" != form.sc_no_s.value && null != form.sc_no_s.value && "" != form.sc_no_s.value) {
        	form.ssc_no2.value=form.sc_no_p.value + form.sc_no_s.value;
        }
        if((form.ssc_no2.value).length > 0) {
        	chkSearch=true;        	
        }
        if("null" != form.sprop_no.value && null != form.sprop_no.value && "" != form.sprop_no.value) {
        	chkSearch=true;
        }
        if("null" != form.eff_dt.value && null != form.eff_dt.value && "" != form.eff_dt.value) {
        	form.seff_dt1.value=form.eff_dt.value;
        	chkSearch=true;
        }
        if("null" != form.exp_dt.value && null != form.exp_dt.value && "" != form.exp_dt.value) {
        	form.seff_dt2.value=form.exp_dt.value;
        	chkSearch=true;
        }
       
        if(chkSearch) {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
        }else{
//        	form.sprop_ofc_cd.value = form.in_usr_ofc_cd.value;
        	ComPriTextCode2ComboItem(saleListValue, saleListText, getComboObject(comboObjects, 'sprop_srep_cd') ,"|","\t" );
            var rDate=new Date();
            var yy=rDate.getFullYear();
            var mm=rDate.getMonth() + 1 +"";
            var dd=rDate.getDate() +"";
            if (mm.length == 1) mm="0" + mm;
            if (dd.length == 1) dd="0" + dd;              
        	form.seff_dt1.value=ComGetMaskedValue(yy+mm+dd,"ymd","-");
        	form.seff_dt2.value=form.seff_dt1.value;
        }
        
		if (tabObjects[0].GetSelectedIndex()== 0) {
			tab1_OnChange(tabObjects[0], 0);
		} else {
			tabObjects[0].SetSelectedIndex(0);
		} 
		
		//2015.05.27 ICH
		tab1.SetTabHidden(8, true);
		
		var hasUserRole = chkUsrRoleForButton();
		buttonController(hasUserRole);
    }
    /**
    * handling Axon event<br>
    */ 	
     function initControl() {
            //handling Axon event
    	 axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
     }
    /**
     * handling OnKeyDown events <br>
     */       
   function obj_keydown(){
       //retrieving data when clicking enter key 
       var eleName = event.srcElement.name;
       var keyValue = null;
       if(event == undefined || event == null) {
    	   keyValue = 13;
       }else{
    	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
       }
       if (keyValue == 13){
           switch (eleName){
           case "ssc_no2":
           case "sprop_no":
           case "seff_dt1":
           case "seff_dt2":
           case "sprop_ofc_cd":
           case "scust_cnt_cd":
           case "scust_seq":
           case "sprop_mqc_qty":
        	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
        	   break;
           }        
       }
   }
  
 
    /**
    * Handling sheet process <br>
    */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        try{
            switch (sAction) {            
            case IBSEARCH: // retrieve              
            	preSvcScpCd=sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "svc_scp_cd");
            	sheetObj=sheetObjects[1];
                formObj.f_cmd.value=SEARCH01;
                ComOpenWait(true); //->waiting->start
                 var sXml=sheetObjects[1].GetSearchData("ESM_PRI_0004GS.do" , FormQueryString(formObj));
                var arrXml=sXml.split("|$$|");
                if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
                clearAllTabPages();
                if (arrXml.length > 1) sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
                tabObjects[0].SetSelectedIndex(0);
                loadTabPage(beforetab);
                calcMVC();   
                ComOpenWait(false); //->waiting->End
                break;
                
            case IBSEARCH_ASYNC03: // 
              if (!validateForm(sheetObjects[0],document.form,sAction)) {
            	  return false;
              }         
            	formObj.f_cmd.value=SEARCH;
            	formObj.ssc_no.value=formObj.ssc_no2.value;
              	formObj.smqc_sign_nm.value=getComboObject(comboObjects, 'smqc_sign_cd').GetSelectText();
            	ComOpenWait(true); //->waiting->start
     	        sheetObj.DoSearch("ESM_PRI_0004GS.do", FormQueryString(formObj) );
    	        break;            
            case IBCREATE: // New
            	var hasUserRole = chkUsrRoleForButton();
        		buttonController(hasUserRole);
            	clearAllForms();
                clearAllTabPages();
                clearButtonImages();
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01); 
                break;        
            case IBSEARCH_ASYNC01: // setting Approval Office Code, customer type  
            	comboObjects[0].RemoveAll();
    	        comboObjects[1].RemoveAll();
    	        comboObjects[2].RemoveAll();
    	        comboObjects[3].RemoveAll();
    	    	comboObjects[4].RemoveAll();
    	        comboObjects[5].RemoveAll();
    	        ComPriTextCode2ComboItem(appListValue, appListText, getComboObject(comboObjects, 'sprop_apro_ofc_cd') ,"|","\t" );
    	        ComPriTextCode2ComboItem(mqcSignListValue, mqcSignListText, getComboObject(comboObjects, 'smqc_sign_cd') ,"|","\t" );
    	        ComPriTextCode2ComboItem(scTypeListValue, scTypeListText, getComboObject(comboObjects, 'ssc_type_cd') ,"|","\t" );
    	        ComPriTextCode2ComboItem(stsTypeListValue, stsTypeListText, getComboObject(comboObjects, 'sprop_sts_cd') ,"|","\t" );
    	        //cust type cd
    	        ComPriTextCode2ComboItem(custTpCdValue, custTpCdText, getComboObject(comboObjects, 'sprc_ctrt_cust_tp_cd') ,"|","\t" );
                break;     
            }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
        	if (sAction == IBCREATE || sAction == IBSEARCH_ASYNC01 ||sAction == COMMAND10) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
    }    
    /**
    * setting sheet initial values and header <br>
    * adding case as numbers of counting sheets <br>
    */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
	        case "sheet0":
	            with(sheetObj){
		          var HeadTitle="|Seq.|S/C No.|AMD\nNo.|Proposal No.|Customer Name|MQC|UNIT|Request\nOffice|S.Rep|Creation \nDate|EFF Date|EXP Date|Filed Date|Status";
		          var headCount=ComCountHeadTitle(HeadTitle);
	
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
	
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:0,  Width:77,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prop_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0,  Width:53,   Align:"Right",   ColMerge:0,   SaveName:"prop_mqc_qty",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"unit_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"prop_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"srep_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"file_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"prop_sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
	
		          SetEditable(0);
		          SetWaitImageVisible(0);
		          SetSheetHeight(150);
	        }
	            break;         	
        case "sheet1":
            with(sheetObj){
	          var HeadTitle="|sc_no1|sc_no2|prop_no|amdt_seq|ctrt_eff_dt|ctrt_exp_dt|rf_flg|gamt_flg|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt|prop_apro_staff";
	          HeadTitle += "|cre_dt|file_dt|cust_cnt_cd|cust_seq|ctrt_pty_nm|prc_ctrt_pty_tp_cd|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_sls_ofc_cd";
	          HeadTitle += "|ctrt_cust_srep_cd|ctrt_cust_srep_nm|real_cust_cnt_cd|real_cust_seq|real_cust_nm|real_cust_tp_cd|real_cust_val_sgm_cd|real_cust_val_sgm";
	          HeadTitle += "|real_cust_sls_ofc_cd|real_cust_srep_cd|real_cust_srep_nm|prop_mqc_qty|cntr_lod_ut_cd|unit|blpl_hdr_seq";
	          HeadTitle += "|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm|oti_no";
	          HeadTitle += "|oti_eff_dt|oti_exp_dt|oti_amt"
	          var headCount=ComCountHeadTitle(HeadTitle);
	
	          SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"sc_no1",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"sc_no2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rf_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gamt_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_sts",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_srep_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_srep_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_staff",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_sgn_tit_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_eff_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Float",     Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"oti_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prxy_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	           
	          InitColumns(cols);
	
	          SetWaitImageVisible(0);
	          SetVisible(0);
        	}
            break;
        case "sheet2":
            with(sheetObj){
	          var HeadTitle="|Seq.|Prop No|Amendment Seq|SVC Scope|Approval Office|Request Office|MQC|MQC|MQC|Sales Rep|Duration|Duration|eff_dt"; //14
	          HeadTitle += "|exp_dt|n1st_cmnc_dt|pre_exp_dt|Status|Status|Note Header Seq|Status";
	          HeadTitle += "|req_usr_flg|apro_usr_flg|prc_prog_sts_cd|src_info_cd|submqcori|PRE_EXT_SCP|dur_dup_flg";
	          var headCount=ComCountHeadTitle(HeadTitle);
	
	          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
	                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_apro_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"prop_scp_mqc_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lod_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"unit_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_srep_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"pre_exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"note_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 //{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"req_usr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_usr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_mqc_qty_ori",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pre_ext_scp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dur_dup_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

	          InitColumns(cols);
	
	          SetEditable(0);
	          SetWaitImageVisible(0);
	          //SetShowButtonImage(2);
	          SetSheetHeight(120);
          }


            break;      
        }
    }
    /**
     * initializing Tab setting Tab items  <br>
     * adding case in case of multiple Tab <br>
     */  
    function initTab(tabObj, tabNo) {
        switch (tabNo) {
        case 1:
            with (tabObj) {
                var cnt=0;
					InsertItem( "Ori/Dest", "" );
					InsertItem( "LOC Group", "");
					InsertItem( "CMDT Group", "");
					InsertItem( "Arbitrary", "");
					InsertItem( "Rate", "");
					InsertItem( "Standard Note", "");
					InsertItem( "Special Note", "");
					InsertItem( "L/Agent", "");
					InsertItem( "IHC", "");
					InsertItem( "GOH", "");
					//SetSelectedIndex(0);
                //no support[implemented common]CLT ShowIcon=true;
                //no support[check again]CLT UseLargeIcon=false;
                SetTabIcon(0,ICON_URL_NOT_EXIST);
                SetTabIcon(1,ICON_URL_NOT_EXIST);
                SetTabIcon(2,ICON_URL_NOT_EXIST);
                SetTabIcon(3,ICON_URL_NOT_EXIST);
                SetTabIcon(4,ICON_URL_NOT_EXIST);
                SetTabIcon(5,ICON_URL_NOT_EXIST);
                SetTabIcon(6,ICON_URL_NOT_EXIST);
                SetTabIcon(7,ICON_URL_NOT_EXIST);
                SetTabIcon(8,ICON_URL_NOT_EXIST);
                SetTabIcon(9,ICON_URL_NOT_EXIST);
            }
            break;
        }
    }
    /**
    * initializing Combo, Combo items  <br>
    */       
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.options.id) {
        	case "sprop_srep_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    //no support[check again]CLT IMEMode=0;
                    SetUseAutoComplete(1);
                    ValidChar(2, 1);
                    SetMaxLength(5);
                }
                break;
            case "sprop_apro_ofc_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
//no support[check again]CLT 	            	IMEMode=0;
 	            	ValidChar(2);
	            	SetMaxLength(6);
                }
                break;
            case "smqc_sign_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                }
                break;
            case "ssc_type_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
            case "sprop_sts_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;       
            case "sprc_ctrt_cust_tp_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    //no support[check again]CLT IMEMode=0;
                    SetUseAutoComplete(1);
                    ValidChar(2);
                    SetMaxLength(1);
                }
                break;                 
        }
    }
    /**
    * checking validation process of inputed form data <br>
    */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH_ASYNC03: // retrieve

        	var k=0;
        	var scNo2=formObj.ssc_no2.value;
        	if (scNo2 !="" && scNo2.length >= 3 ){
        		k++;
        	}
        	if (formObj.sprop_no.value != ""){
        		k++;
        	}
        	if (formObj.seff_dt1.value != "" && formObj.seff_dt2.value != ""){
        		k++;
        	}
        	if (k < 1){
        		ComShowCodeMessage("PRI01100");
        		return false;
        	}
            break;
        }
        return true;
    }           
    /**
     * activating selected tab items when clicking Tab <br>
     */ 
    function tab1_OnChange(tabObj, tabIndex) {
        if (beforetab != tabIndex) {
            var objs=document.all.item("tabLayer");
            objs[tabIndex].style.display="inline";
            objs[beforetab].style.display="none";            
        }
        beforetab=tabIndex;
        loadTabPage(tabIndex);
    }
    /**
     * loading screen when changing tab  <br>
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
                sUrl="ESM_PRI_0004_01.do"; //Ori/Dest
                break;
            case 1:
                sUrl="ESM_PRI_0004_02.do"; //LOC Group
                break;
            case 2:
                sUrl="ESM_PRI_0004_03.do"; //CMDT Group
                break;
            case 3:
                sUrl="ESM_PRI_0004_04.do"; //Arbitrary
                break;
            case 4:
                sUrl="ESM_PRI_0004_09.do"; //Rate
                break;
            case 5:
                sUrl="ESM_PRI_0004_08.do"; //Standard Note
                break;
            case 6:
                sUrl="ESM_PRI_0004_10.do"; //Special Note
                break;
            case 7:
                sUrl="ESM_PRI_0004_07.do"; //L/Agent
                break;
            case 8:
                sUrl="ESM_PRI_0004_05.do"; //IHC
                break;
            case 9:
                sUrl="ESM_PRI_0004_06.do"; //GOH
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
    * initializing sheet in the tab <br>
    */      
    function clearAllTabPages() {
        for (var i=0; i < tabObjects[0].GetCount(); i++) {
            tabObjects[0].SetTabIcon(i,ICON_URL_NOT_EXIST);
            if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
                document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
            }
        }
    }
    /**
    * initialiaing IBMulti Combo Object and all items on screen<br>
    */      
    function clearAllForms(){        
        var formObj=document.form;
        //search-- start
        for (var i=0; i < 5; i++){
        	comboObjects[i].SetSelectIndex(-1);
        }
        formObj.ssc_no2.value="";
        formObj.sprop_no.value="";
        formObj.seff_dt1.value="";
        formObj.seff_dt2.value="";
        formObj.sprop_ofc_cd.value="";
        formObj.sprop_srep_nm.value="";
        formObj.sprop_mqc_qty.value="";
        formObj.scust_cnt_cd.value="";
        formObj.scust_seq.value="";
        formObj.sctrt_pty_nm.value="";
        //search-- end
        clearMainFormControls();
        /*formObj.prop_pfmc.value="";*/
       /* formObj.sls_ld_no.value="";*/
    }
    function clearMainFormControls() {
    	var formObj=document.form;
    	formObj.sc_no.value="";
        formObj.amdt_seq.value="";
        formObj.prop_no.value="";
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";
        formObj.rf_flg.value="";
        formObj.gamt_flg.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";
        formObj.prop_srep_cd.value="";
        formObj.prop_srep_nm.value="";
        formObj.prop_apro_ofc_cd.value="";
        formObj.prop_apro_staff.value="";
        formObj.cre_dt.value="";
        formObj.file_dt.value="";
        formObj.cust_cnt_cd.value="";
        formObj.cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        formObj.prc_ctrt_cust_tp_cd.value="";        
        formObj.ctrt_cust_val_sgm.value="";
        formObj.ctrt_cust_sls_ofc_cd.value="";
        formObj.ctrt_cust_srep_cd.value="";        
        formObj.ctrt_cust_srep_nm.value="";
        formObj.oti_no.value="";
        formObj.real_cust_cnt_cd.value="";
        formObj.real_cust_nm.value="";
        formObj.real_cust_seq.value="";
        formObj.real_cust_tp_cd.value="";          
        formObj.real_cust_val_sgm.value="";
        formObj.real_cust_sls_ofc_cd.value="";
        formObj.real_cust_srep_cd.value="";             
        formObj.real_cust_srep_nm.value="";  
        formObj.prop_mqc_qty.value="";
        formObj.cntr_lod_ut_cd.value="";    
        formObj.prop_mvc.value="";
        formObj.prop_mvc_tp.value="";
    }
    /**
     * setting tab icon when changing main, scope's terms change <br>
     * 
     */ 
 function comApplyStyleProposalStatusSummary(svcScpCd){
	 var formObj=document.form;
     formObj.f_cmd.value=SEARCH04;
     var sXml=sheetObjects[1].GetSearchData("ESM_PRI_0004GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd);
     var arrText=ComPriXml2Array(sXml, "prop_scp_term_tp_cd|dat_flg");
     var icon="";
     var tabIdx="";
     var imgName="";
     for (i=0; arrText!= null && i < arrText.length; i++){
    	 imgName="";
    	 tabIdx="";
    	 switch(arrText[i][0]){
	     	case '01':  //Duration,Scope Duration
	         	imgName="";
	             break;
	         case '02':  //MQC,Scope MQC
		         	imgName="";
	             break;  
	         case '04':  //contract party
	         	imgName="btn_ctrt_pty_pop";
	         	break;  	             
	         case '05':
	        	 imgName="btn_afil_pop";
	        	 break;
	         case '06':
	        	 imgName="btn_blpl_pop";
	        	 break;               
	         case '13':  //Group Location
	             tabIdx="1";
	             break;	               
	         case '14':  //Group Commodity
	             tabIdx="2";                 
	             break;	               
	         case '15':  //Loading Agent
	             tabIdx="7";
	             break;	               
	         case '31':  //Standard Note
	             tabIdx="5";                 
	             break;	           
	         case '32':  //Special Note
	             tabIdx="6";
	             break;	               
	         case '42':                
	             tabIdx="0";                     
	             break;	               
	         case '52': 
	             tabIdx="3";
	             break;	               
	         case '62':                 
	             tabIdx="8";
	             break;	               
	         case '16':  //GOH Charge
	             tabIdx="9";
	             break;	               
	         case '72':               
	             tabIdx="4";
	             break;  
    	 }
    	 icon=ICON_URL_NOT_EXIST;
    	 switch(arrText[i][1]){
        	 case "1":
        		 icon=ICON_URL_EXIST;
        		 break;
    	 }
         // default : Black 
         if (arrText[i][0] == "01" || arrText[i][0] =="02"||arrText[i][0] == "04"||arrText[i][0] == "05"||arrText[i][0] == "06" ){
       		 if (imgName !="") {
       			var butObj = document.getElementById(imgName);
       			$("#"+imgName+" .btn_img").remove();
       			 $(butObj).prepend("<img class='btn_img'  src='"+icon+"'>");
       		 }
        	 
         }else{
             if (tabIdx != ""){
            	 tabObjects[0].SetTabIcon(tabIdx,icon);
             }
         }   
     }        
 }    
/////////////////////////////////////////////////////////////////////////   
/////////////////////// ONCHANGE (S)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////   
 /**
  * event handler when changing seleted item in IBMulti Combo<br>
  * setting the changed data by using com_change_sheet() function <br>
  */    
    function sprop_srep_cd_OnChange(comboObj, oldindex, oldtext , oldcode , newindex, text , code) {     
    	var formObj=document.form;		
 		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0 , true);
		if (code != null && code != "") {
			var text=comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.sprop_srep_nm.value) {
				formObj.sprop_srep_nm.value=comboObj.GetText(code, 1);
			}
			if (code == -1){
				formObj.sprop_srep_nm.value="";
			}
		}
    }   
    
    /**
    * calling Event when keyboard press<br>
    */
	function sprop_sts_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}       
    /**
    * calling Event when keyboard press<br>
    */
	function sprop_srep_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}  
    /**
    * calling Event when keyboard press<br>
    */
	function sprop_apro_ofc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}  
    /**
    * calling Event when keyboard press<br>
    */
	function smqc_sign_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}  
    /**
    * calling Event when keyboard press<br>
    */
	function ssc_type_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}  	
    /**
     * calling function when occurring OnSearchEnd Event <br>
     * setting sheet value with Html Object value after retrieving sheet<br>
     */ 
    function sheet0_OnSearchEnd(sheetObj, errMsg){
    	 ComOpenWait(false);
    	var hasUserRole = chkUsrRoleForButton();
  		buttonController(hasUserRole);
        var formObj=document.form;
        if(sheetObj.RowCount() <= 0) {
        	clearMainFormControls();
        	clearAllTabPages();
        	clearButtonImages();
        	sheetObjects[1].RemoveAll();
        	sheetObjects[2].RemoveAll();
        	return;
        }
    }   
    /**
    * calling function when occurring OnSearchEnd Event <br>
    * setting sheet value with Html Object value after retrieving sheet<br>
    */ 	
    function sheet1_OnSearchEnd(sheetObj, errMsg){
    	 ComOpenWait(false);
        var formObj=document.form;
        if(sheetObj.RowCount() <= 0) {
        	clearMainFormControls();
        	return;
        }
        formObj.sc_no.value=sheetObj.GetCellValue(1,"sc_no1") +  sheetObj.GetCellValue(1,"sc_no2");
		formObj.prop_no.value=sheetObj.GetCellValue(1,"prop_no");
		formObj.amdt_seq.value=sheetObj.GetCellValue(1,"amdt_seq");
		formObj.ctrt_eff_dt.value=sheetObj.GetCellValue(1,"ctrt_eff_dt");
		formObj.ctrt_exp_dt.value=sheetObj.GetCellValue(1,"ctrt_exp_dt");
		formObj.rf_flg.checked=sheetObj.GetCellValue(1,"rf_flg")=="Y"?true:false;
		formObj.gamt_flg.checked=sheetObj.GetCellValue(1,"gamt_flg")=="Y"?true:false;
		formObj.prop_sts.value=sheetObj.GetCellValue(1,"prop_sts");
		formObj.prop_ofc_cd.value=sheetObj.GetCellValue(1,"prop_ofc_cd");
		formObj.prop_srep_cd.value=sheetObj.GetCellValue(1,"prop_srep_cd");
		formObj.prop_srep_nm.value=sheetObj.GetCellValue(1,"prop_srep_nm");
		formObj.prop_apro_ofc_cd.value=sheetObj.GetCellValue(1,"prop_apro_ofc_cd");
		formObj.prop_apro_staff.value=sheetObj.GetCellValue(1,"prop_apro_staff");
		formObj.cre_dt.value=sheetObj.GetCellValue(1,"cre_dt");
		formObj.file_dt.value=sheetObj.GetCellValue(1,"file_dt");
		formObj.cust_cnt_cd.value=sheetObj.GetCellValue(1,"cust_cnt_cd");
		if (sheetObj.GetCellValue(1, "cust_seq") !="" ){
			formObj.cust_seq.value=ComLpad(sheetObj.GetCellValue(1,"cust_seq"), 6, "0");
        }else{
            formObj.cust_seq.value="";
        }
		formObj.ctrt_pty_nm.value=sheetObj.GetCellValue(1,"ctrt_pty_nm");
		formObj.prc_ctrt_cust_tp_cd.value=sheetObj.GetCellValue(1,"prc_ctrt_cust_tp_cd");
		formObj.ctrt_cust_val_sgm.value=sheetObj.GetCellValue(1,"ctrt_cust_val_sgm");
		formObj.ctrt_cust_sls_ofc_cd.value=sheetObj.GetCellValue(1,"ctrt_cust_sls_ofc_cd");
		formObj.ctrt_cust_srep_cd.value=sheetObj.GetCellValue(1,"ctrt_cust_srep_cd");
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
		formObj.real_cust_srep_cd.value=sheetObj.GetCellValue(1,"real_cust_srep_cd");
		formObj.real_cust_srep_nm.value=sheetObj.GetCellValue(1,"real_cust_srep_nm");
		formObj.prop_mqc_qty.value=ComAddComma(sheetObj.GetCellValue(1,"prop_mqc_qty"));
		formObj.cntr_lod_ut_cd.value=sheetObj.GetCellValue(1,"unit");
        //OTI
		formObj.oti_no.value=sheetObj.GetCellValue(1, "oti_no");
		formObj.oti_eff_dt.value=sheetObj.GetCellValue(1, "oti_eff_dt");
		formObj.oti_exp_dt.value=sheetObj.GetCellValue(1, "oti_exp_dt");
		formObj.oti_amt.value=sheetObj.GetCellValue(1, "oti_amt");
		formObj.prxy_flg.checked = sheetObj.GetCellValue(1,"prxy_flg")=="Y"?true:false;
        //sale lead
/*formObj.sls_ld_no.value=sheetObj.GetCellValue(1,"sls_ld_no");*/
    }   
    function sheet2_OnSearchEnd(sheetObj, errMsg){
    	ComOpenWait(false);
    }   
    /**
     * calling function when occurring OnSelectCell Event <br>
     * retrieving by Proposal No and Amdt Seq No<br>
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
     * calling function when occurring OnSelectCell Event <br>
     * changing tab icon and setting frame with selected scope's terms data <br>
     */  
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        try{
        	ComOpenWait(true); //->waiting->start
        	if(sheetObj.GetCellValue(NewRow,"svc_scp_cd")!=""&& OldRow!=NewRow&&sheetObj.GetCellValue(NewRow,"ibflag")!="I"){       	
        		comApplyStyleProposalStatusSummary(sheetObj.GetCellValue(NewRow,"svc_scp_cd"));
                loadTabPage(beforetab);   
            }
        } catch (e) {
          	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
        	ComOpenWait(false); //->waiting->End
        }
    }
     /**
     * calling function when occurring OnSort event <br>
     * retrieving again after column sort<br>
     */       
     function sheet0_OnSort(sheet, Col) {  
    	 var row=sheet.GetSelectRow();
    	 sheet0_OnSelectCell(sheet, -1, -1, row, 1);
     }
    /**
    * calculating MVC based on MQC <br>
    *  MVC = MQC / Duration valid day x 7  <br>
    */  
    function calcMVC(){
        var formObj=document.form;
        var mqcQty=sheetObjects[1].GetCellValue(1, "prop_mqc_qty");
        var sDay=formObj.ctrt_eff_dt.value;
        var eDay=formObj.ctrt_exp_dt.value;
        var mvcQty=0;     
        var durDay=ComGetDaysBetween(sDay, eDay);
        if (mqcQty != "" && mqcQty != "0"){
            if (durDay !=0){
            	mvcQty=ComRound((mqcQty / durDay * 7),0);
            }        	
        }   
        formObj.prop_mvc.value=ComAddComma(mvcQty);
        formObj.prop_mvc_tp.value=formObj.cntr_lod_ut_cd.value;
    }   
    /**
    * Setting IBMulti Combo after retrieving Request Office<br>
    */ 
    function setRequestOffice(){
        var formObj=document.form;
        var cd=formObj.sprop_ofc_cd.value;
        var sheetObj=sheetObjects[1];
        formObj.f_cmd.value=SEARCH15;
        var sParam=FormQueryString(formObj)+"&etc1="+cd;
        sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
        ComPriXml2ComboItem(sXml, sprop_srep_cd, "cd", "cd|nm");   
        getComboObject(comboObjects, 'sprop_srep_cd').InsertItem(0, "", "");
        formObj.sprop_srep_nm.value="";
    }
    /**
    * Request Office Customer data<br>
    */ 
  function sCustNameFind(eleName){
      var formObj=document.form;
      var sheetObj=sheetObjects[1];
      var cust_cnt_cd=formObj.scust_cnt_cd.value;        
      var cust_seq=formObj.scust_seq.value;      
      if(cust_cnt_cd != "" && cust_seq !=""){
          var sParam="f_cmd="+SEARCH02+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;
          var sXml=sheetObj.GetSearchData("ESM_PRI_0004GS.do", sParam);
          var arrText=ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_cust_srep_nm|oti_no");
          if(arrText==undefined){
        	  sClearCustName();
              formObj.scust_cnt_cd.focus();
          }else{
              formObj.sctrt_pty_nm.value=arrText[0][1];              
          }
      }
  }    
  /**
   *  initializing Html Object value about Customer <br>
   */     
  function sClearCustName(){
      var formObj=document.form;
      formObj.scust_cnt_cd.value="";
      formObj.scust_seq.value="";
      formObj.sctrt_pty_nm.value="";
  }  
  /**
   * initializing duration,Mvc,afiliate button image<br>
   */
  function clearButtonImages(){
	  
	var butObj = document.getElementById("btn_blpl_pop");
	$('#btn_blpl_pop .btn_img').remove();
	$(butObj).prepend("<img class='btn_img'  src='"+ICON_URL_NOT_EXIST+"'>");

	var butObj = document.getElementById("btn_afil_pop");
	$("#btn_afil_pop .btn_img").remove();
	$(butObj).prepend("<img class='btn_img'  src='"+ICON_URL_NOT_EXIST+"'>");
	 
	var butObj = document.getElementById("btn_ctrt_pty_pop");
	$("#btn_ctrt_pty_pop .btn_img").remove();
	$(butObj).prepend("<img class='btn_img'  src='"+ICON_URL_NOT_EXIST+"'>");

  }
  /**
  * setting button color and changing check box disable <br>
  */  
  function initFormControl(){
      document.getElementById("btn_blpl_pop").style.color="black";
      document.getElementById("btn_afil_pop").style.color="black";
      document.getElementById("btn_ctrt_pty_pop").style.color="black";
      document.form.rf_flg.disabled=true;         //reefer                    
      document.form.gamt_flg.disabled=true;       //garment
  }
  /**
   * resizing screen for wide view<br>
   */   
 	function setControlHidden(){
 		if (!controlHidden){
 			document.all.subterms.style.display="none";
 			controlHidden=true;
 		}else{
 			document.all.subterms.style.display="inline";
 			controlHidden=false;
 			sheet1_OnSearchEnd(sheetObjects[1], "");
 		}
 		try{
 		    parent.syncHeight();  
 			}catch(e){}
 	}
/**
 *  returning Customer Type code function <br>
 */ 
  function getCustTypeCode() {
	  var formObj=document.form;
	  var custTpCd=formObj.prc_ctrt_cust_tp_cd.value;
	  return custTpCd;
  }

  
  function btn_ctrt_cust_returnVal(rtnVal) {
  	var formObj = document.form;
  	if (rtnVal != null){
        formObj.scust_cnt_cd.value=rtnVal.custCntCd;
        formObj.scust_seq.value=rtnVal.custSeq;
        formObj.sctrt_pty_nm.value=rtnVal.custNm;
      }
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
  			ComBtnDisable("btn_proposal");
  		}else{
  			ComBtnEnable("btn_proposal");
  		}
  	}
  
  