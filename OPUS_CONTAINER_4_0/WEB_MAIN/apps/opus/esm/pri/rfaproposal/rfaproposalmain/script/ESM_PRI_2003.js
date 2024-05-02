/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003.js
*@FileTitle  : Proposal & Amendment Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_PRI_2003 : business script for ESM_PRI_2003 
 */

    // global variables
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var saveSvcScpCd="";
    var controlHidden=false;
    var ICON_URL_NOT_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon1.gif"; 
    var ICON_URL_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon2.gif";
    var ICON_URL_AMEND="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon4.gif";
    var ICON_URL_ACCEPT="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon3.gif";
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     */
    function processButtonClick() {
        var formObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;

            switch (srcName) {
            case "btn_hidden":            	
            	setControlHidden();
            	break;
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;
            case "btn_new":
                doActionIBSheet(sheetObjects[0],document.form,IBCREATE);  
                
                //2015.05.12 ADD
           	 	formObj.rfa_no.readOnly=false;
           	 	formObj.prop_no.readOnly=false;
                break;              
            case "btn_save":    
                var effDt=ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
                var sEffDt=sheetObjects[0].GetCellValue(1, "ctrt_eff_dt");
                if (effDt != sEffDt){
                	com_change_sheet( sheetObjects[0], "ctrt_eff_dt" );
                }
                doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                break;
            case "btn_rowadd":
                doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
                break;
            case "btn_delete":
                doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
                break;      
            case "btns_calendar1": 
                var cal= new ComCalendarFromTo();                
                cal.select(document.form.ctrt_eff_dt, document.form.ctrt_exp_dt, 'yyyy-MM-dd');                
                break;  
            case "btn_ctrt_cust":
            	//2014.09.05 NYK change the way to call Popup function
            	var sUrl = "/opuscntr/ESM_PRI_4014_POP.do?nmd_cust_flg=N&is_popup=true&cust_cnt_cd="+formObj.ctrt_cust_cnt_cd.value+"&cust_seq="+formObj.ctrt_cust_seq.value;
            	ComOpenPopup(sUrl, 640, 465, "getCustInfoPop", "none", true);        
                
                break;   
            case "btn_amend":   
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                } 
    	        // checking update date 
    	        var checkSheetObj=sheetObjects[0];
    	        var checkTpCd="CHECK1";
    	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
    	        	return false;
    	        }
    	        checkTpCd="CHECK2";
    	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
    	        	return false;
    	        }

                var sParam=getParameters("btn_amend");
                if(sParam != "") {
                	 var sUrl = "/opuscntr/ESM_PRI_2040.do?"+sParam;
         	        ComOpenPopup(sUrl, 700, 270, "after_amend", "0,1,1,1,1,1", true);
                }
                break;                      
            case "btn_request":
            	doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
                break;        
            case "btn_coffer":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                doActionIBSheet(sheetObjects[0],document.form,COMMAND03);
// 2015-04-08 Chloe : Message poopup 일단 막음                
//                // Message Popup Open
//                ComOpenWait(true); //->waiting->start
//                openMessagePopup(sheetObjects[0].GetCellValue(1,"prop_sts_cd"), sheetObjects[0].GetCellValue(1,"prop_srep_cd"));
//                ComOpenWait(false); //->waiting->End
                break; 
            case "btn_approve":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }               
                doActionIBSheet(sheetObjects[0],document.form,COMMAND04);
// 2015-03-18 Chloe : Message poopup 일단 막음                 
//                // Message Popup Open
//                ComOpenWait(true); //->waiting->start
//                openMessagePopup(sheetObjects[0].GetCellValue(1,"prop_sts_cd"), sheetObjects[0].GetCellValue(1,"prop_srep_cd"));
//                ComOpenWait(false); //->waiting->End
                break;        
            case "btn_cancel":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }   
                doActionIBSheet(sheetObjects[0],document.form,COMMAND05);
// 2015-03-18 Chloe : Message poopup 일단 막음                      
//                // calling common message when Approver canceling Request
//                var aproUsrFlg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
//                if (sheetObjects[0].GetCellValue(1,"prop_sts_cd") =="I" && aproUsrFlg == "Y"){
//                    // Message Popup Open
//                    ComOpenWait(true); //->waiting->start
//                    openMessagePopup(sheetObjects[0].GetCellValue(1,"prop_sts_cd"), sheetObjects[0].GetCellValue(1,"prop_srep_cd"));
//                    ComOpenWait(false); //->waiting->End
//                }
                break;  
            case "btn_dur_pop":
            	popupCol="btn_dur_pop";
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                var sParam=getParameters(srcName,"");  
                if(sParam != "") {
                	ComOpenPopup("ESM_PRI_2010.do?"+sParam, 635, 330, "setReturnValue", "1,0", true);
                }
                break;                    
            case "btn_dem_pop":            
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }               
                var sUrl="/opuscntr/EES_DMT_2003.do?" + "prop_no="+formObj.prop_no.value + "&amdt_seq=" + formObj.amdt_seq.value + "&caller=2003";
                ComOpenPopup(sUrl, 1200, 690, "", "1,0", true);
                break;       
            case "btn_free_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }         
                var sParam=getParameters(srcName, "");
                if(sParam != "") {
                	ComOpenPopup("/opuscntr/ESM_PRI_2058.do?"+sParam, 840, 350, "getFreeTimePop", "1,0,1,1,1,1,1", true);
                }
                break;                  
            case "btn_afil_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }     
                var sParam=getParameters(srcName, "");  
                
                //2014.09.12 
                if(sParam != "") {
                	var sUrl = "/opuscntr/ESM_PRI_2003_06.do?"+sParam;
                	ComOpenPopup(sUrl, 1020, 360, "getAffilateInfoPop", "1,0,1,1,1,1,1", true); 
                }
                break;
            case "btn_copy":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                var sheetObj=sheetObjects[0];
                var sRfa_No=sheetObj.GetCellValue(1,"rfa_no");
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sParam="rfa_no="+sRfa_No+"&prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq
                ComOpenPopup("/opuscntr/ESM_PRI_2044.do?"+sParam, 650, 350, "getCopyPop", "1,0,1,1,1,1,1", true); 
                
                break;
            case "btn_print":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                var sheetObj=sheetObjects[0];
                var sPropNo=sheetObj.GetCellValue(1,"prop_no");
                var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
                var sParam="prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
                var rtnVal=ComPriOpenWindowCenter("/opuscntr/ESM_PRI_2039.do?"+sParam, "", 1024, 650, true);                
                break;
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
           	if (srcName == "btn_coffer" || srcName == "btn_approve") {
           		ComOpenWait(false); //->waiting->End
           	}
        }
    }
    function getCopyPop(str){
    	var formObj = document.form;
    	if(str != null){
            formObj.prop_no.value=str;
            formObj.rfa_no.value="";
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
    function getFreeTimePop(rtnVal){
    	if (rtnVal != null && rtnVal =="Y" ){                   
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
        }
    }
    function after_amend(rtnVal){
    	if (rtnVal != null && rtnVal =="Y"){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
    
    /**
     * set Cust and Sale Representitive Info From Customer Inquiry(ESM_PRI_4014) <br>
     * callback function of Popup
     * 2014.09.01 NYK
     */
    function getCustInfoPop(rtnVal) {
    	var formObj=document.form;
    	if (rtnVal != null) { 
    		formObj.ctrt_cust_cnt_cd.value=rtnVal.custCntCd;         
            formObj.ctrt_cust_seq.value=rtnVal.custSeq;
            formObj.ctrt_pty_nm.value=rtnVal.custNm;  
            custNameFind("ctrt_cust_cnt_cd");
            // sale rep
            setCustSaleRep();
            comboObjects[1].SetSelectCode(sheetObjects[0].GetCellValue(1,"respb_srep_cd"),false);
            com_change_sheet( sheetObjects[0], "ctrt_cust_seq");    
    	}
    }
    
    /**
     * set Result From Proposal Affilate Creation(ESM_PRI_2003_06) <br>
     * callback function of Popup
     * 2014.09.12 NYK
     */
    function getAffilateInfoPop(rtnVal) {
    	if (rtnVal != null && rtnVal =="Y"){
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
    	}
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
         }
         
         //2014.09.16 
         // 서버에서 tab렌더링 되는 부분이 제대로 되지 않아 넣은 코드 setTimeout
         setTimeout( function () { 
         
	        for (var k=0; k < tabObjects.length; k++) {
	            initTab(tabObjects[k], k + 1);
	        }
	        for(var k=0; k < comboObjects.length; k++){
	            initCombo(comboObjects[k], k + 1);
	        }
        
        	initControl();
	        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
	   	 	var form=document.form;
	        if("null" != form.rfa_no_2043.value && null != form.rfa_no_2043.value && "" != form.rfa_no_2043.value) {
	        	form.rfa_no.value=form.rfa_no_2043.value;
	        	doActionIBSheet(sheetObjects[0],form,IBSEARCH);
	        } else if (form.cond_prop_no.value != "") {
	            // retrieving RFA Proposal main when clicking Open button from ESM_PRI_2049
	            //adding ESM_PRI_2019 
	            form.prop_no.value=form.cond_prop_no.value;
	            doActionIBSheet(sheetObjects[0],form,IBSEARCH);
	        }
        
        } , 1000);
    }
    /**
    * handling Axon event<br>
    */    
     function initControl() {        
        axon_event.addListenerForm('blur', 'obj_blur', document.form);
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
        
        //2014.10.08 [NYK]
        axon_event.addListenerForm('click', 'obj_click', form);
     }
     /**
     * handling OnKeyPress events <br>
     */      

     /**
     * handling OnKeyDown events <br>
     */       
     function obj_keydown(){
    	 //retrieving data when clicking enter key 
    	 var eleName=ComGetEvent("name");
    	 if (eleName == "prop_no" || eleName == "rfa_no"){
    		 if (ComGetEvent("keycode") == 13){
    			 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    		 }
    	 }
     }
     /**
      * handling Onbeforedeactivate events <br>
      */        
    function obj_blur() {
        var formObj=document.form;
        var sheetObj=sheetObjects[0]; 
        var sheetObj1=sheetObjects[0];    
        var eleName=ComGetEvent("name");
        switch(eleName){
            case "rfa_no":     
                break;
            case "prop_no":      
                break;
            case "ctrt_cust_cnt_cd":
                //cust name find
            	if (sheetObj.GetCellValue(1, "ctrt_cust_cnt_cd") != formObj.ctrt_cust_cnt_cd.value){
                	if (formObj.ctrt_cust_cnt_cd.value == ""){
                		clearCustName();
                	} else{
                    	custNameFind(eleName);
                        // sale rep
                        setCustSaleRep();
                        comboObjects[1].SetSelectCode(sheetObj1.GetCellValue(1,"respb_srep_cd"),false);
                	}
                }
                ComChkObjValid(ComGetEvent());
                break;          
            case "ctrt_cust_seq":
                var custSeq=formObj.ctrt_cust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.ctrt_cust_seq.value=ComLpad(custSeq, 6, "0");
                }
                //cust name find
                if (ComParseInt(sheetObj.GetCellValue(1, "ctrt_cust_seq")) != ComParseInt(formObj.ctrt_cust_seq.value)){
                    if (formObj.ctrt_cust_seq.value ==""){   
                    	clearCustName();
                    }else{	
                        custNameFind(eleName);
                        // sale rep
                        setCustSaleRep();
                        comboObjects[1].SetSelectCode(sheetObj1.GetCellValue(1,"respb_srep_cd"),false);
                    }
                }
                break;
            case "ctrt_exp_dt":
            	if(!ComChkObjValid(event.srcElement, false, false, false)) return;
                com_change_sheet( sheetObj, "ctrt_exp_dt" );
                break;                   
            case "ctrt_eff_dt":
            	if(!ComChkObjValid(event.srcElement, false, false, false)) return;
                com_change_sheet( sheetObj, "ctrt_eff_dt","ymd" );
                break;     
            case "tgt_mvc_qty":
                com_change_sheet( sheetObj, eleName );
                break;
            case "prop_mvc":
                break;
            case "prop_ofc_cd":
            	if (sheetObj.GetCellValue(1,"prop_ofc_cd") != formObj.prop_ofc_cd.value){
                    var sheetObj=sheetObjects[0];                                                 
                    var cd=formObj.prop_ofc_cd.value;         
                    formObj.f_cmd.value=COMMAND22;
                    var sParam=FormQueryString(formObj)+"&cd="+cd;
                    var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
                    var arrData=ComPriXml2Array(sXml, "cd|nm");
                    if (arrData != null && arrData.length > 0) {
                    	setRequestOfficeSaleRep();
                    }else{
                    	formObj.prop_ofc_cd.value="";
                        prop_srep_cd.RemoveAll();
                        formObj.prop_srep_nm.value="";                        
                        formObj.prop_ofc_cd.focus();
                    }
                    com_change_sheet( sheetObj, eleName );
                }
                break;
            default:
            	break;

        }
    }    

    /**
    * Handling sheet process <br>
    */   
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        try{
            switch (sAction) {            
            case IBSEARCH:  
            	ComOpenWait(true); //->waiting->start
            	clearAllTabPages(); 
                sheetObj=sheetObjects[0];
                var researchXml="";
                if (validateForm(sheetObj,document.form,sAction)) {
                	formObj.f_cmd.value=SEARCH01;
                    if(formObj.rfa_no.value!=""){
                    	formObj.prop_no.value="";
                    }
                    var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , FormQueryString(formObj));
                    var arrXml=sXml.split("|$$|");
                    if (arrXml.length > 0) {
                    	sheetObjects[0].LoadSearchData(arrXml[0], {Sync:1} );
                    	researchXml=arrXml[0];
                    	formObj.ori_prop_no.value=sheetObj.GetCellValue(1, "prop_no");
                    	formObj.ori_rfa_no.value=sheetObj.GetCellValue(1, "rfa_no");
                    }
                    if (arrXml.length > 2){
                    	ComPriXml2ComboItem(arrXml[2], respb_srep_cd, "cd", "cd|nm|etc1");      
                    }
                    if (arrXml.length > 3){
                    	ComPriXml2ComboItem(arrXml[3], prop_srep_cd, "cd", "cd|nm");
                    }                
                    if (arrXml.length > 1){
                    	sheetObjects[1].LoadSearchData(arrXml[1], {Sync:1});
                    	for (var i=1; i<=sheetObjects[1].LastRow(); i++){
                    		setSheetRequestOfficeSaleRep(sheetObjects[1], i, sheetObjects[1].GetCellValue(i, "prop_scp_ofc_cd"));
                    	}
                    }
                } else {
                	 return false;
                }
                calcMVC();
                ComOpenWait(false); //->waiting->End
                if (arrXml[0] != null && ComPriGetRowCountFromXML(arrXml[0]) == -1){
                	if (researchXml != ""){
                		doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                	}else if (researchXml==""){                	
                		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                	}
                }
                break;
                
            case IBCREATE: // New
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
            	if (controlHidden) setControlHidden();
            	//selecting first tab when first adding
        		if (tabObjects[0].GetSelectedIndex()== 0) {
        			tab1_OnChange(tabObjects[0], 0);
        		} else {
        			tabObjects[0].SetSelectedIndex(0);
        		}
                clearAllForms();       
                clearAllTabPages();
                clearButtonImages();
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);           
                sheetObjects[0].DataInsert();
                var sheetObj=sheetObjects[0];
                var formObj=document.form;
                sheetObj.SetCellValue(1,"prop_sts_cd","I",0);
                sheetObj.SetCellValue(1,"prc_prog_sts_cd","I",0);
                sheetObj.SetCellValue(1,"src_info_cd","NW",0);
                sheetObj.SetCellValue(1,"prop_ofc_cd",formObj.in_usr_ofc_cd.value,0);
                sheetObj.SetCellValue(1,"cntr_lod_ut_cd","T",0);
                sheetObj.SetCellValue(1,"dmdt_ft_tp_cd","T",0);
                sheetObj.SetCellValue(1, "prc_prop_cre_tp_cd","G",0);
                sheet1_OnSearchEnd(sheetObj);            
                sheetObj.SetCellValue(1,"amdt_seq","0",0);
                formObj.amdt_seq.value="0";
                cntr_lod_ut_cd.SetSelectCode("T",false);
                comboObjects[3].SetSelectIndex(-1);
                setRequestOfficeSaleRep();
                prop_srep_cd.SetSelectCode(formObj.in_usr_srep_cd.value);
                prop_srep_cd_OnBlur(comboObjects[0]);
                
                //2014.09.05 ADD
                comboObjects[1].RemoveAll();
                
                ComOpenWait(false); //->waiting->End
                // formObj.ctrt_eff_dt.focus();
                buttonControl();            
                setNewDataControl();
                break;
                
            case IBSEARCH_ASYNC01: // setting Approval Office Code, customer type 
            	comboObjects[2].RemoveAll();
            	comboObjects[3].RemoveAll();
            	comboObjects[4].RemoveAll();
            	//scope cd
    	        sheetObjects[1].SetColProperty("svc_scp_cd", {ComboText:scopeCdText, ComboCode:scopeCdValue} );
    	        sheetObjects[1].SetColProperty("cntr_lod_ut_cd", {ComboText:lodUtCdText, ComboCode:lodUtCdValue} );
    	        //scope status
    	        sheetObjects[1].SetColProperty("prop_scp_sts_cd", {ComboText:scpStsCdText, ComboCode:scpStsCdValue} );
    	        ComPriTextCode2ComboItem(lodUtCdValue, lodUtCdText, getComboObject(comboObjects, 'cntr_lod_ut_cd') ,"|","\t" );
    	        //dmdt
    	        ComPriTextCode2ComboItem(dmdtCdValue, dmdtCdText, getComboObject(comboObjects, 'dmdt_ft_tp_cd'),"|","\t", 1);
    	        //Contract Type : 2015.07.23 ADD
    	        ComPriTextCode2ComboItem(ctrtDurTpCdValue, ctrtDurTpCdText, getComboObject(comboObjects, 'ctrt_dur_tp_cd') ,"|","\t" );
                break;   
                
            case IBSEARCH_ASYNC02: // setting Sale Rep
                setRequestOfficeSaleRep();
                setCustSaleRep();
                break;  
                
            case IBINSERT: // Row Add               
                var idx=sheetObj.DataInsert();                
                //2014.09.05 use SetCellEditable instead of SetColPropert
                if (formObj.amdt_seq.value == "0"){
                        sheetObj.SetCellEditable(idx, "scp_dur_pop",0);
                        sheetObj.SetCellEditable(idx,"tgt_mvc_qty",1);
                        sheetObj.SetCellEditable(idx,"cntr_lod_ut_cd",1);
                        sheetObj.SetCellEditable(idx,"ctrt_eff_dt",1);
                        sheetObj.SetCellEditable(i,"ctrt_exp_dt",1);
    	                sheetObj.SetCellEditable(idx, "gline_cp_flg_lnk",1);
    	                sheetObj.PopupButtonImage(idx, "gline_cp_flg_lnk",1);
    	                sheetButtonImageChange(sheetObj,idx, 0);
                } else{
                        sheetObj.SetCellEditable(idx, "ctrt_eff_dt",0);
                        sheetObj.SetCellEditable(idx, "tgt_mvc_qty",1);
                        sheetObj.SetCellEditable(idx, "cntr_lod_ut_cd",1);
                        if(sheetObj.GetCellValue(idx,"ctrt_eff_dt") == sheetObjects[0].GetCellValue(1,"eff_dt")){
                            sheetObj.SetCellEditable(idx, "ctrt_exp_dt",1);
                        }else{
                            sheetObj.SetCellEditable(idx, "ctrt_exp_dt",0);
                        }                                    
                    	sheetObj.SetCellEditable(idx, "gline_cp_flg_lnk",1);
                }
                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
                sheetObj.SetCellValue(idx, "prop_scp_ofc_cd",formObj.prop_ofc_cd.value,0);
                sheetObj.SetCellValue(idx, "tgt_mvc_qty","0",0);
                sheetObj.SetCellValue(idx, "cntr_lod_ut_cd",cntr_lod_ut_cd.GetSelectCode(),0);
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.SetCellValue(idx, "ctrt_eff_dt",formObj.ctrt_eff_dt.value,0);
                } else{
                	sheetObj.SetCellValue(idx, "ctrt_eff_dt",sheetObjects[0].GetCellValue(1,"eff_dt"),0);
                }
                sheetObj.SetCellValue(idx, "ctrt_exp_dt",formObj.ctrt_exp_dt.value,0);
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.SetCellValue(idx, "eff_dt",formObj.ctrt_eff_dt.value,0);
                } else{
                	sheetObj.SetCellValue(idx, "eff_dt",sheetObjects[0].GetCellValue(1,"eff_dt"),0);
                }
                sheetObj.SetCellValue(idx, "exp_dt",formObj.ctrt_exp_dt.value,0);
                sheetObj.SetCellValue(idx, "pre_exp_dt",sheetObjects[0].GetCellValue(1, "pre_exp_dt"),0);
                sheetObj.SetCellValue(idx, "prop_scp_sts_cd","I",0);
                sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
                sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
                sheetObj.SetCellValue(idx, "n1st_cmnc_dt",sheetObjects[0].GetCellValue(1,"eff_dt"),0);
                // setting SALE REP to main SALES REP
                setSheetRequestOfficeSaleRep(sheetObj, idx, sheetObj.GetCellValue(idx, "prop_scp_ofc_cd"));
                sheetObj.SetCellValue(idx, "prop_scp_srep_cd",prop_srep_cd.GetSelectText(),0);
                sheetButtonImageChange(sheetObj,idx, 0);
                if(formObj.amdt_seq.value!=0){
                	sheetObj.SetCellFont("FontColor", idx, "chk", idx, "prop_scp_sts_cd","#FF0000");
                }
                var preIbflag=sheetObjects[0].GetRowStatus(1);
                if (preIbflag == "R"){
                    sheetObjects[0].SetRowStatus(1,"U");
                }
                sheetObj.SelectCell(idx, "svc_scp_cd");
                break; 
                
            case IBSAVE: // Save
            	ComOpenWait(true); //->waiting->start
                var sheetObj=sheetObjects[1];
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }      
                var mstAmdtSeq=formObj.amdt_seq.value;
                formObj.f_cmd.value=MULTI01;
                var sParam="";
                var sParamSheet1=sheetObjects[0].GetSaveString(true);
                if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
                    return;
                }           
                if (sParamSheet1 != "") {
                    sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                var sParamSheet2=sheetObjects[1].GetSaveString(true);
                if (sheetObjects[1].IsDataModified()&& sParamSheet2 == "") {
                    return;
                }            
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                sParam += "&" + FormQueryString(formObj)+"&mstAmdtSeq="+mstAmdtSeq;
                var sXml=sheetObj.GetSaveData("ESM_PRI_2003GS.do", sParam);
                sheetObjects[0].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);//to showing only one message
                sheetObjects[1].LoadSaveData(sXml);
                var formObj=document.form;
                if(formObj.rfa_no.value=="" && formObj.prop_no.value==""){           
                    formObj.prop_no.value=ComGetEtcData(sXml,"prop_no");          
                }
                saveSvcScpCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "svc_scp_cd");
        		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);          
        		ComOpenWait(false); //->waiting->End
                break;
                
            case IBDELETE: // Delete
                if (validateForm(sheetObj,document.form,sAction)) {         
                    deleteRowCheck(sheetObj, "chk" ,true);  
                }       
                break;
                
            case COMMAND02: //REQUEST
            	ComOpenWait(true); //->waiting->start
    	        if (!validateForm(sheetObj,document.form,sAction)) {  
    	        	return false;
    	        }
    	        setRequestCallback(); 	        
    	        break;
    	        
            case COMMAND03: // Counter Offer      
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }       
                formObj.f_cmd.value=MULTI02;          
                sheetObj.SetCellValue(1,"prop_sts_cd","R",0);
                var sParam="";
                var sParamSheet1=sheetObjects[0].GetSaveString(true);
                if (sParamSheet1 != "") {
                    sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                var sParamSheet2=sheetObjects[1].GetSaveString(true);
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }           
                sParam += "&" + FormQueryString(formObj); 
                var sXml=sheetObj.GetSaveData("ESM_PRI_2003GS.do", sParam);
                sheetObjects[0].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);
                sheetObjects[1].LoadSaveData(sXml);
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComOpenWait(false); //->waiting->End
                break;    
                
            case COMMAND04: // Approve       
            	ComOpenWait(true); //->waiting->start	
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }      
                formObj.f_cmd.value=MULTI03;
                sheetObj.SetCellValue(1,"prop_sts_cd","A",0);
                var sParam="prop_no=" + sheetObjects[0].GetCellValue(1, "prop_no") +"&amdt_seq="+sheetObjects[0].GetCellValue(1, "amdt_seq");
                sParam += "&"+ sheetObjects[0].GetSaveString(true);
                sParam += "&"+FormQueryString(formObj);
                var sXml=sheetObj.GetSaveData("ESM_PRI_2003GS.do", sParam);
                sheetObjects[0].LoadSaveData(sXml);
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComOpenWait(false); //->waiting->End
                break;
                
            case COMMAND05: // Cancel
            	ComOpenWait(true); //->waiting->start
            	var prop_sts_cd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
            	var amdtSeq=formObj.amdt_seq.value;
            	var sXml="";
            	if (amdtSeq =="0"){
        	        if (prop_sts_cd !="I" && !ComShowCodeConfirm("PRI01046")) {
        	            return false;
        	        }   
            	} else{
        	        if (!ComShowCodeConfirm("PRI01046")) {
        	            return false;
        	        }   
            	}            
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }    
                formObj.f_cmd.value=MULTI04;            
                switch(prop_sts_cd) {
                case 'I':   
    	        	if (amdtSeq == "0"){
    	                if (!ComShowCodeConfirm("PRI01124")) {
    	                    return false;
    	                }    
    	        	}else{
    	                if (!ComShowCodeConfirm("PRI01050")) {
    	                    return false;
    	                }    
    	        	}
                    sheetObj.SetCellValue(1,"prop_sts_cd","D",0);
                    var sParam="";
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam += ComPriSetPrifix(sParamSheet1, "sheet1_");
                    } else{
                    	sheetObj.SetCellValue(1,"prop_sts_cd","I",0);
                    	return false
                    }
                    var sParamSheet2=sheetObjects[1].GetSaveString(true);
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    } else{
                    	sheetObj.SetCellValue(1,"prop_sts_cd","I",0);
                    	return false
                    }
                    sParam += "&" + FormQueryString(formObj);
                    sXml=sheetObjects[0].GetSaveData("ESM_PRI_2003GS.do", sParam);
                    sheetObjects[0].LoadSaveData(sXml);
                    var amdtSeq=formObj.amdt_seq.value;
                    if (amdtSeq != "0"){
                        formObj.amdt_seq.value=ComParseInt(amdtSeq) - 1;
                    }else{
                        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                    }
                    break;
                case 'Q':   // Requested    
                	var reqUsrFlg=sheetObjects[0].GetCellValue(1, "req_usr_flg");
                	var aproUsrFlg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
                	if (reqUsrFlg == "Y" && aproUsrFlg !="Y"){
	            		if (checkRequestCancel() != "Y"){	            			
	            			return false;
	            		}
	            	}
	            	formObj.f_cmd.value=MULTI04; 
                    sheetObj.SetCellValue(1,"prop_sts_cd","I",0);
                	var sParam="";
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }               
                    var sParamSheet2=sheetObjects[1].GetSaveString(true);
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }       
                    sParam += "&" + FormQueryString(formObj);
                    sXml=sheetObjects[0].GetSaveData("ESM_PRI_2003GS.do", sParam);
                    sheetObjects[0].LoadSaveData(sXml);
                    break;
                    
                case 'R':   // Returned
                    sheetObj.SetCellValue(1,"prop_sts_cd","Q",0);
                	var sParam="";
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    var sParamSheet2=sheetObjects[1].GetSaveString(true);
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }            
                    sParam += "&" + FormQueryString(formObj);
                    sXml=sheetObjects[0].GetSaveData("ESM_PRI_2003GS.do", sParam);
                    sheetObjects[0].LoadSaveData(sXml);
                    break;
                    
                case 'A':   // Approved
    	            var sParamSheet2=sheetObjects[1].GetSaveString(true);
    	            if (sParamSheet2 == "") {
    	            	return;
    	            }
                    sheetObj.SetCellValue(1,"prop_sts_cd","Q",0);
                    var sParam="";
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    sParamSheet2=sheetObjects[1].GetSaveString(true);
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }
                    sParam += "&" + FormQueryString(formObj);
                    sXml=sheetObjects[0].GetSaveData("ESM_PRI_2003GS.do", sParam);
                    sheetObjects[0].LoadSaveData(sXml);
                    break;
                }
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComOpenWait(false); //->waiting->End
                break;                   
            }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
        	if (sAction == IBSEARCH_ASYNC02 || sAction == IBDELETE || sAction == IBINSERT
        			|| sAction == IBSEARCH_ASYNC01) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
    }
    
    function setRequestCallback() {
        var formObj=document.form;
        formObj.f_cmd.value=MULTI02;
        sheetObjects[0].SetCellValue(1,"prop_sts_cd","Q",0);
        var sParam="";
        var sParamSheet1=sheetObjects[0].GetSaveString(true);
        if (sParamSheet1 != "") {
            sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
        }
        var sParamSheet2=sheetObjects[1].GetSaveString(true);
        if (sParamSheet2 != "") {
            sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
        }
        sParam += "&" + FormQueryString(formObj);
        var sXml=sheetObjects[0].GetSaveData("ESM_PRI_2003GS.do", sParam);
        sheetObjects[0].LoadSaveData(sXml);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        ComOpenWait(false); //->waiting->End    	
    }
    
    
    
    /**
    * setting sheet initial values and header <br>
    * adding case as numbers of counting sheets <br>
    */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
        case "sheet1":
            with (sheetObj) {
                var HeadTitle="|rfa_no|prop_no|amdt_seq|pre_amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|n1st_cmnc_dt|prc_prog_sts_cd"
                HeadTitle += "|src_info_cd|pre_exp_dt|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt|cre_dt";
                HeadTitle += "|ctrt_cust_cnt_cd|ctrt_cust_seq|ctrt_pty_nm|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|respb_sls_ofc_cd|respb_srep_cd|ctrt_cust_srep_nm|tgt_mvc_qty";
                HeadTitle += "|cntr_lod_ut_cd|unit|request user flag|approval user flag|all user flg|ctrt_eff_dt_ori|ctrt_exp_dt_ori"
                HeadTitle += "|prc_ctrt_cust_tp_nm|file_dt|prop_prpr_flg|createtype|prop_apro_staff|dur_dup_flg"
                HeadTitle += "|dmdt_ft_tp_cd|so_kup|dmdt_ft_tp_cd_ori|apro_usr_flg_ori|cre_tp|copy_auth|upd_dt|trf_ctrt_flg|ctrt_dur_tp_cd"

                SetConfig( { SearchMode:2, MergeSheet:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"}];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rfa_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"pre_amdt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
			                 {Type:"Int",       Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"tgt_mvc_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_lod_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"unit",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"req_usr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"apro_usr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"all_usr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_eff_dt_ori",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_exp_dt_ori",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_ctrt_cust_tp_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"file_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_prpr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_prop_cre_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_apro_staff",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dur_dup_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dmdt_ft_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"so_kup",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dmdt_ft_tp_cd_ori",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"apro_usr_flg_ori",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cre_tp",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"copy_auth",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_ctrt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_dur_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
                InitColumns(cols);
                SetEditable(0);
                SetWaitImageVisible(0);
             }
            break;
            
        case "sheet2":
            with(sheetObj){
	          var HeadTitle="|Sel.|Seq.|Prop No.|Amendment Seq|SVC Scope|Duration|Duration|Duration|Target MQC|Unit";
	          HeadTitle += "|G/L Copy|Request Office|Request Office|Sales Rep|Status|eff_dt|exp_dt|n1st_cmnc_dt|pre_exp_dt";
	          HeadTitle += "|Status|req_usr_flg|apro_usr_flg|prc_prog_sts_cd|src_info_cd|submqcori|DUR_DUP_FLG|pre_ext_scp";
	          var headCount=ComCountHeadTitle(HeadTitle);
	          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight: 120 } );
	          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	          //2014.09.24 
	          //(simptom) check valid when col is hidden field and keyField(true)
	          //(solution temporary) keyField 1-> 0 
	          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Combo", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_eff_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_exp_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"PopupEdit", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"scp_dur_pop",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                 {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"tgt_mvc_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lod_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Popup",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"gline_cp_flg_lnk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_ofc_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"PopupEdit", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"prop_scp_ofc_pop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Combo",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_srep_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"pre_exp_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_scp_sts",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"req_usr_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apro_usr_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Int",       Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tgt_mvc_qty_ori",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"dur_dup_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pre_ext_scp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	          InitColumns(cols);
	          SetEditable(1);
	          SetImageList(0,"/opuscntr/img/btns_search_off.gif");
	          SetImageList(1,"/opuscntr/js/ibsheet/Main/popup.gif");
	          SetColProperty("prop_scp_ofc_cd", {AcceptKeys: "E", InputCaseSensitive:1} );
	          SetWaitImageVisible(0);
	          // InitDataValid(0, "svc_scp_cd", vtEngUpOnly);
	          SetShowButtonImage(2);
	          SetSheetHeight(120);
          }
        break;      
        }
    }
    /**
     * initializing Tab setting Tab items  <br>
     */     
    function initTab(tabObj, tabNo) {
        switch (tabNo) {
        case 1:
            with (tabObj) {    
                var cnt=0;                
				InsertItem( "Location Group ", "");
				InsertItem( "Commodity Group ", "");
				InsertItem( "Arbitrary", "");
				InsertItem( "Rate ", "");
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
    * initializing Combo, Combo items  <br>
    */         
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "prop_srep_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(5);
                }
                break;     
                
            case "respb_srep_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    SetMaxLength(5);
                    SetColWidth(0, "50");
                    SetColAlign(0, "center");
                    SetColWidth(1, "150");
                    SetColWidth(2, "55");
                    SetColAlign(2, "center");
                }
                break;       
            case "cntr_lod_ut_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;   
            case "dmdt_ft_tp_cd":
                var i=0;
                with(comboObj) {
                    SetDropHeight(200);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }    
                break;
              //2015.07.23 ADD
            case "ctrt_dur_tp_cd":
                with(comboObj) {
                    SetDropHeight(80);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;
        }
    }
    /**
    * checking validation process of inputed form data <br>
    */
    function validateForm(sheetObj, formObj, sAction) {
        var rfa_no=formObj.rfa_no.value;
        var prop_no=formObj.prop_no.value;
        var amdt_seq=formObj.amdt_seq.value;
        switch (sAction) {
        case IBSEARCH: 
        	if ((rfa_no == "" && prop_no == "") || (rfa_no == null && prop_no == null))  {
        		formObj.rfa_no.readOnly=false;
            	formObj.prop_no.readOnly=false;
            	return false;
            }else{
            	formObj.rfa_no.readOnly=true;
            	formObj.prop_no.readOnly=true;
            	return true;
            }
            break;
        case IBCREATE: // New
            if(sheetObjects[0].IsDataModified()||sheetObjects[1].IsDataModified()){
                return ComPriClearChange;
            }
            break;
            
        case COMMAND02://REQUEST
	    	if (formObj.prop_no.value ==""){
	            ComShowCodeMessage('PRI01021');
	            return;
	        }
	    	if(sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        var rValue="";
	        if (formObj.rfa_no.value == "" && formObj.prop_no.value == "") {
	            return false;
	        }               
	        if (sheetObjects[1].RowCount()== 0){
	            return false;
	        }
	        if (!ComShowCodeConfirm("PRI01032","Request")){
	            return false;
	        }
	        //checking Main,Scope Duration Eff_dt,Exp_dt
	        var mainCtrtEffDt=ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
	        var mainCtrtExpDt=ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd");
	        var scpCtrtEffDt="";
	        var scpCtrtExpDt="";
	        var ctrtDateMatch=false;  
	        for (var i = 1; i <= getValidRowCount(sheetObjects[1]); i++){
	        	scpCtrtEffDt=sheetObjects[1].GetCellValue(i, "ctrt_eff_dt");
	        	scpCtrtExpDt=sheetObjects[1].GetCellValue(i, "ctrt_exp_dt");
	            if (mainCtrtEffDt == scpCtrtEffDt && mainCtrtExpDt == scpCtrtExpDt ){
	                ctrtDateMatch=true;
	                continue;
	            }
	        }
	        if (!ctrtDateMatch){
	             ComShowCodeMessage("PRI01096");
	        }                
	        rValue=checkRequest();
	        if (rValue !="Y"){
	            return false;
	        }
	        if ( checkDmdtData() !="Y"){
	            return false;
	        }                           
	        if ( checkDuration() =="Y"){
	            ComShowCodeMessage('PRI01092');
	        }     
        	break;
        	
        case COMMAND03: // Counter Offer
        	var prop_sts_cd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
        	var req_usr_flg=sheetObjects[0].GetCellValue(1, "req_usr_flg");
        	var apro_usr_flg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
            if (apro_usr_flg!="Y"){
                ComShowCodeMessage('PRI01033','C/Offer');
                return false;
            }
            var initCheck=checkCountOffer();
            if (initCheck !="Y"){
                ComShowCodeMessage('PRI01039');
                return false;
            }       
            if (!ComShowCodeConfirm("PRI01032","C/Offer")){
                return false;
            }
            if (prop_sts_cd !="Q" ){
                ComShowCodeMessage('PRI01034');
                return false;
            }
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
            break;
        case COMMAND04: // Approve        
        	var prop_sts_cd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
        	var req_usr_flg=sheetObjects[0].GetCellValue(1, "req_usr_flg");
        	var apro_usr_flg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
            if (apro_usr_flg=="N"){
                ComShowCodeMessage('PRI01033','Approve');
                return false;
            }           
            if (!ComShowCodeConfirm("PRI01032","Approve")){
                return false;
            }
            if (prop_sts_cd !="Q" ){
                ComShowCodeMessage('PRI01034');
                return false;
            }
            var rValue=checkAccept();         
            if (rValue != "Y"){
                ComShowCodeMessage('PRI01031');
                return false;
            }
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
            break;             
        case COMMAND05: // Cancel
	        var checkSheetObj=sheetObjects[0];
	        var checkTpCd="CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        var prop_sts_cd=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
	        var amdtSeq=sheetObjects[0].GetCellValue(1, "amdt_seq");
            switch(prop_sts_cd) {
                case 'I':   // Initial                
                	if (amdtSeq == "0"){
                		if (checkInitCancelDmdtData() == "Y"){
                			ComShowCodeMessage('PRI01116');
                			return false;
                		}                		
                	}
                    break;
                case 'A':   // Approved
                	if (checkApproveCancel() != "Y"){
                		return false;
                	}
                    break;
            }
            break;     
        case IBDELETE: // Delete        
            var sCheckedRows=sheetObj.FindCheckedRow("chk");
            var arrCheckedRows=new Array();
            if (sCheckedRows== "") {
                arrCheckedRows.push(sheetObj.GetSelectRow());
            } else { 
                arrCheckedRows=sCheckedRows.split("|");
            }       
            var effDt=sheetObjects[0].GetCellValue(1,"eff_dt");
            var amdtSeq=sheetObjects[0].GetCellValue(1,"amdt_seq");
            // can deleting scope added current amdt_seq 
            if (amdtSeq != "0"){        
                for (var i=0; i < arrCheckedRows.length; i++){
                	if (effDt != sheetObj.GetCellValue(arrCheckedRows[i], "eff_dt")){
                        ComShowCodeMessage('PRI01036');
                        sheetObj.SelectCell(arrCheckedRows[i],"svc_scp_cd");// PRI01036
                        return false;
                    }
                }
            }
            var rValue="";
            for (var i=0; i< arrCheckedRows.length; i++){
                rValue=checkScopeDelete(arrCheckedRows[i]);
                if (rValue != "Y"){
                    ComShowCodeMessage('PRI01051');
                    sheetObj.SelectCell(arrCheckedRows[i],"svc_scp_cd");
                    return false;
                }
            }
            break;  
            
        case IBSEARCH_ASYNC01: // 
            return true;
            if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
                return false;
            }
            if (formObj.cfm_flg.value != "No") {
                return false;
            }
            break; 
            
        case IBSAVE: // Save
            var formObj=document.form;
            if(!ComChkRequired(document.form)){
                return false;
            }
            if (comboObjects[0].GetSelectCode()== "") {
                ComShowCodeMessage('PRI00316','Sale Rep.'); 
                comboObjects[0].Focus();
                return false;
            }
            //respb_sls_ofc_cd
            if (formObj.respb_sls_ofc_cd.value ==""){
            	ComShowCodeMessage('PRI00316','Customer Sale Rep Office');
            	comboObjects[1].Focus();
            	return false;
            }
            if (comboObjects[1].GetSelectCode()== "") {
                ComShowCodeMessage('PRI00316','Customer Sale Rep.'); 
                comboObjects[1].Focus();
                return false;
            }            
            if (comboObjects[3].GetSelectCode()== "") {
                ComShowCodeMessage('PRI00316','Free Time'); 
                comboObjects[3].Focus();
                return false;
            }
            var rowCnt = getValidRowCount(sheetObjects[1]);
            var ctrtEffDt=sheetObjects[0].GetCellValue(1, "ctrt_eff_dt");
            var ctrtExpDt=sheetObjects[0].GetCellValue(1, "ctrt_exp_dt");
            var sheet2=sheetObjects[1];
            for (var i=1; i <= rowCnt; i++){
            	var effDt=ComGetUnMaskedValue(sheet2.GetCellValue(i, "ctrt_eff_dt"),"ymd");
            	var expDt=ComGetUnMaskedValue(sheet2.GetCellValue(i, "ctrt_exp_dt"),"ymd");
            	if (effDt != "" && expDt != ""){
                	if (effDt < ctrtEffDt){            		
                		ComShowCodeMessage("PRI01003",ComGetMaskedValue(ctrtEffDt,"ymd","-"),ComGetMaskedValue(ctrtExpDt,"ymd","-"),"RFA");
                		sheet2.SelectCell(i, "ctrt_eff_dt");
                		return false;
                	}
                	if (expDt > ctrtExpDt){            		
                		ComShowCodeMessage("PRI01003",ComGetMaskedValue(ctrtEffDt,"ymd","-"),ComGetMaskedValue(ctrtExpDt,"ymd","-"),"RFA");
                		sheet2.SelectCell(i, "ctrt_exp_dt");
                		return false;
                	}
            	}
            }
            if (rowCnt <= 0){
                ComShowCodeMessage('PRI01029'); 
                return false;
            }           
            if(!sheetObjects[0].IsDataModified()&&!sheetObjects[1].IsDataModified()){
                ComShowCodeMessage('PRI00301'); 
                return false;
            }            
            var SaveChk=0;
        	for( var i=1 ; i<=sheetObjects[1].RowCount(); i++){
        		if(sheetObjects[1].GetCellValue(i,"ibflag")=='I' || sheetObjects[1].GetCellValue(i,"ibflag")=='U'){
	        		SaveChk=SaveChk+1; 		
	        		if(sheetObjects[1].GetCellValue(i, "svc_scp_cd")==null || sheetObjects[1].GetCellValue(i, "svc_scp_cd")==""){
	        			ComShowCodeMessage('COM130403', 'Service Scope');//key field missing
	        			sheetObjects[1].SelectCell(i, "svc_scp_cd");
						return false;
					}else if(sheetObjects[1].GetCellValue(i, "prop_scp_ofc_cd") != "" && sheetObjects[1].GetCellValue(i, "prop_scp_ofc_cd").length == 5){
						if(sheetObjects[1].GetCellValue(i, "prop_scp_srep_cd")==null || sheetObjects[1].GetCellValue(i, "prop_scp_srep_cd")==""){
							ComShowCodeMessage('COM130403', 'Service Scope Sales Rep');//key field missing
		        			sheetObjects[1].SelectCell(i, "prop_scp_srep_cd");
							return false;
						}
					}
				}
	        }
             var rowM=sheetObjects[1].ColValueDup("svc_scp_cd", false);
             if (rowM >= 0) {
                 ComShowCodeMessage("PRI00303", "Sheet", rowM);
                 return false;
            }
            //MQC chk 
            var mainMqc=sheetObjects[0].GetCellValue(1, "tgt_mvc_qty");
            var subMqc=0;
            var sheetObj=sheetObjects[1];
            for (var i=1; i <= sheetObj.RowCount(); i++){
            	subMqc += ComParseInt(sheetObj.GetCellValue(i, "tgt_mvc_qty_ori"));
            	if (sheetObj.GetCellValue(i,"tgt_mvc_qty") != sheetObj.GetCellValue(i,"tgt_mvc_qty_ori") ){
            		subMqc += ComParseInt(sheetObj.GetCellValue(i, "tgt_mvc_qty")) - ComParseInt(sheetObj.GetCellValue(i, "tgt_mvc_qty_ori"));
                }           
            }
            if ((subMqc - mainMqc) > 0){
                 ComShowCodeMessage("PRI01008");                 
                 return false;
            }
            
            // 2015-05-18 CHLOE : 해당 로직은 Migration을 위한거라 Migration 이후 사용하지 않을 예정
            // AMD 0, Initial, Proposal No이 없을 때만 RFA No 넣을 수 있는 로직 추가.
            //check if the rfa no already exists
            var sRfaNo = formObj.rfa_no.value;
            var sPropNo = formObj.prop_no.value;
            if(sPropNo == "" && sRfaNo != "" ) {
	            formObj.f_cmd.value=SEARCH16;
	            var sParam=FormQueryString(formObj);
	            var sXml=sheetObjects[0].GetSearchData("ESM_PRI_2003GS.do" , sParam);
	            var isRfaNo=ComGetEtcData(sXml, "ISRFANO");
	            if (isRfaNo !=null && isRfaNo == "Y"){
	            	ComShowCodeMessage("PRI01138");
	            	formObj.rfa_no.value = "";
	            	return false;
	            }
	            sheetObjects[0].SetCellValue(1,"rfa_no",sRfaNo);           
            }
            
            if (!ComPriConfirmSave()) {
                return false;
            } 
            if (!saveChangeDuration("false")){
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
            var objs = document.all.item("tabLayer");
            objs[tabIndex].style.display = "inline";
            objs[beforetab].style.display = "none";            
        }
    	beforetab=tabIndex;
    	loadTabPage(tabIndex);
    }
    /**
     * loading screen when chaging tab<br>
     */       
    function loadTabPage(tabIndex, selRow) {
        if (tabIndex == null || tabIndex == "") {
            tabIndex=tabObjects[0].GetSelectedIndex();
        }
        var objTabWindow=document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
        if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
            var sUrl="";
            switch (tabIndex) {
            case 0:
                sUrl="ESM_PRI_2003_02.do"; //Location Group
                break;
            case 1:
                sUrl="ESM_PRI_2003_03.do"; //Commodity Group
                break;
            case 2:
                sUrl="ESM_PRI_2003_04.do"; //Arbitrary
                break;
            case 3:
                sUrl="ESM_PRI_2003_07.do"; //Rate
                break;
            case 4:
                sUrl="ESM_PRI_2003_01.do"; //Special Note
                break;
            }
            objTabWindow.location.href=sUrl;
            return true;
        }
        var sheetObj1=sheetObjects[0];
        var sheetObj2=sheetObjects[1];
        var sRow=sheetObj2.GetSelectRow();
        if (selRow != null && selRow != undefined){
        	sRow=selRow;
        }
        
        if(sRow == -1 || sRow == 0 ) return;
        var sPropNo=sheetObj2.GetCellValue(sRow,"prop_no");
        var sAmdtSeq=sheetObj2.GetCellValue(sRow, "amdt_seq");
        var sSvcScpCd=sheetObj2.GetCellValue(sRow, "svc_scp_cd");
        var sPreAmdtSeq=sheetObj1.GetCellValue(1, "pre_amdt_seq");
        var sPropStsCd=sheetObj1.GetCellValue(1, "prop_sts_cd");
        var sEffDt=sheetObj2.GetCellValue(sRow, "eff_dt");
        var sExpDt=sheetObj2.GetCellValue(sRow, "exp_dt");
        var sPreExpDt=sheetObj2.GetCellValue(sRow, "pre_exp_dt");
        var sIsReqUsr=sheetObj1.GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
        var sIsAproUsr=sheetObj1.GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
        var sDurDupFlg=sheetObj2.GetCellValue(sRow, "dur_dup_flg");
        if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" && sPreAmdtSeq != null && sPreAmdtSeq != "" && sPropStsCd != null && sPropStsCd != "" && sEffDt != null && sEffDt != "" && sPreExpDt != null && sPreExpDt != "" && sheetObj2.GetCellValue(sRow, "ibflag")!="I") {
        	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg);
        }        
    }
    /**
    * initializing all sheet's data <br>
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
    *  initializing all duration,Mvc,afiliate buttons image <br>
    */
    function clearButtonImages(){
    	var ICON_URL_NOT_EXIST = "img/tab_icon1.gif";
//        document.images("img_dur").src=ICON_URL_NOT_EXIST;
//        document.images("img_affil").src=ICON_URL_NOT_EXIST;
//        document.images("img_dmdt").src=ICON_URL_NOT_EXIST;
    	var butObj = document.getElementById("btn_dur_pop");
    	$(".btn_img").remove();
    	$(butObj).prepend("<img class='btn_img'  src='"+ICON_URL_NOT_EXIST+"'>");
    	
    	var butObj = document.getElementById("btn_afil_pop");
    	
    	$(butObj).prepend("<img class='btn_img'  src='"+ICON_URL_NOT_EXIST+"'>");
    	 
    	var butObj = document.getElementById("btn_free_pop");
    	
    	$(butObj).prepend("<img class='btn_img'  src='"+ICON_URL_NOT_EXIST+"'>");
    	
    }
    /**
    * initialiaing IBMulti Combo Object and all items on screen <br>
    */      
    function clearAllForms(){        
        var formObj=document.form;        
        formObj.rfa_no.value="";
        formObj.amdt_seq.value="";
        formObj.prop_no.value="";
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";
        comboObjects[0].SetSelectIndex(-1);
        formObj.prop_srep_nm.value="";
        formObj.prop_apro_staff.value="";
        formObj.cre_dt.value="";        
        formObj.ctrt_cust_cnt_cd.value="";
        formObj.ctrt_cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        formObj.prc_ctrt_cust_tp_nm.value="";   
        formObj.ctrt_cust_val_sgm.value="";
        formObj.respb_sls_ofc_cd.value="";
        comboObjects[1].SetSelectIndex(-1);
        formObj.ctrt_cust_srep_nm.value="";
        formObj.tgt_mvc_qty.value="";
        comboObjects[2].SetSelectIndex(-1);
        formObj.prop_mvc.value="";
        formObj.prop_mvc_tp.value="";    
        //2014.10.08 [NYK]
        formObj.trf_ctrt_flg.value="";
    }
    /**
     * changing pop-up button image on the sheet <br>
     */  
    function sheetButtonImageChange(sheetObj, Row, sw){      
    	sheetObj.PopupButtonImage(Row, "scp_dur_pop",sw);
    }
    /**
    * button authority control function by button status <br>
    */ 
    function buttonControl(){
        var formObj=document.form;
        var sts=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
        var req_usr_flg=sheetObjects[0].GetCellValue(1, "req_usr_flg");
        var apro_usr_flg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
        var all_usr_flg=sheetObjects[0].GetCellValue(1, "all_usr_flg");
        var aproUsrFlgOri=sheetObjects[0].GetCellValue(1, "apro_usr_flg_ori");
        //aproUsrFlgOri
        var scp_req_usr_flg="";
        var scp_apro_usr_flg="";
        var amdt_seq=sheetObjects[0].GetCellValue(1, "amdt_seq");
        var sheetObj=sheetObjects[1];
        scp_req_usr_flg=req_usr_flg;
        scp_apro_usr_flg=apro_usr_flg;         
        try{
            ComBtnEnable("btn_retrieve");
            ComBtnEnable("btn_new");
            ComBtnEnable("btn_save");
            ComBtnDisable("btn_amend");
            btnImgEnable(formObj.btns_calendar1, false);            
            ComBtnDisable("btn_request");             
            ComBtnDisable("btn_coffer");  
            ComBtnDisable("btn_approve");            
            ComBtnDisable("btn_cancel");            
            ComBtnEnable("btn_copy");     
            ComBtnEnable("btn_print"); 
            ComBtnDisable("btn_rowadd");            
            ComBtnDisable("btn_delete");                        
            ComBtnDisable("btn_dem_pop"); 
            document.getElementById("btn_dem_pop").style.color="";
            ComBtnEnable("btn_free_pop"); 
            document.getElementById("btn_free_pop").style.color="black";
            ComBtnEnable("btn_afil_pop"); 
            document.getElementById("btn_afil_pop").style.color="black";
            ComBtnEnable("btn_dur_pop");            
            document.getElementById("btn_dur_pop").style.color="black";
            /*
            btnImgEnable("btn_mqc_estimate",false);
            */
            formObj.ctrt_eff_dt.readOnly=false;
            formObj.ctrt_exp_dt.readOnly=false;
            dmdt_ft_tp_cd.SetEnable(0);
            
            formObj.trf_ctrt_flg.disabled = true;
            ctrt_dur_tp_cd.SetEnable(false); 

            //Retro Active aproUsrFlgOri
            if ((req_usr_flg =="Y" && sts=="Q") || apro_usr_flg =="Y" || aproUsrFlgOri=="Y"){
            	ComBtnEnable("btn_cancel");           	
            }  
            formObj.prop_ofc_cd.readOnly=true; //Proposal Requect Office        
            prop_srep_cd.SetEnable(0);//Proposal Sales Rep
            formObj.ctrt_cust_cnt_cd.readOnly=true; //Customer Code
            formObj.ctrt_cust_seq.readOnly=true;
            btnImgEnable(formObj.btn_ctrt_cust, false);
            respb_srep_cd.SetEnable(0);//Customer Sales Rep
            formObj.tgt_mvc_qty.readOnly=true;
            cntr_lod_ut_cd.SetEnable(0);
            changeDmdtBtnStatus();
            //UI control
            ComSetUIItem(sheetObjects[0], document.form, "PRI", "ESM_PRI_2003");
            if(req_usr_flg !="Y" && apro_usr_flg !="Y"){
                btnImgEnable(formObj.btns_calendar1, false);
                formObj.ctrt_eff_dt.readOnly=true;
                formObj.ctrt_exp_dt.readOnly=true;    
                prop_srep_cd.SetEnable(0);

                if (formObj.prop_sts.value == "") {
                	ComBtnEnable("btn_save");
                	ctrt_dur_tp_cd.SetEnable(true); 
                }else{
                	ComBtnDisable("btn_save");
                }
                if (sheetObj.GetCellValue(1, "copy_auth") == "N" ){
                	ComBtnDisable("btn_copy");	
                	ComBtnDisable("btn_print");
                }
        		for (var i=1; i <= sheetObj.RowCount();i++){
        			sheetObj.SetCellEditable(i, "gline_cp_flg_lnk",0);
        		    if (amdt_seq == "0"){
        		    	sheetObj.SetCellEditable(i, "scp_dur_pop",0);
        		    	sheetButtonImageChange(sheetObj,i, 0);
        		    }else{
        		    	sheetObj.SetCellEditable(i, "scp_dur_pop",1);
        		    	sheetButtonImageChange(sheetObj,i, 1);
        		    }
        		    sheetObj.SetCellEditable(i, "prop_scp_ofc_cd", 0);
        		    sheetObj.SetCellEditable(i, "prop_scp_ofc_pop", 0);
        		    sheetObj.SetCellEditable(i, "prop_scp_srep_cd", 0);
        		}
                return;
            }           
            for (var i=1; i <= sheetObj.RowCount(); i++){
                sheetButtonImageChange(sheetObj,i, 1);
            }
            switch(sts) {
                case 'I':   // Initial                    
                    if(req_usr_flg=="Y"||apro_usr_flg=="Y"){                 
                        if (formObj.prop_no.value !=""){
                            ComBtnEnable("btn_request");
                            ComBtnEnable("btn_cancel");
                            /*btnImgEnable("btn_mqc_estimate",true);*/
                        }               
                        ComBtnEnable("btn_rowadd");         
                        ComBtnEnable("btn_delete");
                        if(amdt_seq == "0"){
                            btnImgEnable(formObj.btns_calendar1, true);                             
                            ComBtnDisable("btn_free_pop"); 
                            ComBtnDisable("btn_dur_pop");
                        }else{
                            //duration
                            ComBtnEnable("btn_dur_pop");                            
                            document.getElementById("btn_dur_pop").style.color="black";                             
                        }
                        
                        //2014.10.08 [NYK]
                        //condition : The Status is Initial and Amend Seq is Zero(0)
                        var amendSeqNo = formObj.amdt_seq.value;
                        if( amendSeqNo == "0" && isRoleforPri == "Y" ) {
                        	formObj.trf_ctrt_flg.disabled = false;
                        }
                    }
                    ctrt_dur_tp_cd.SetEnable(true);
                    break;
                    
                case 'Q':   // Requested               
                    if (amdt_seq =="0"){            
                        ComBtnDisable("btn_free_pop");
                        ComBtnDisable("btn_dur_pop");                           
                    }           
                    if(apro_usr_flg=="Y"){                    
                        var rValue=checkAccept(); 
                        if (rValue == "Y"){
                            ComBtnEnable("btn_approve"); 
                            ComBtnDisable("btn_coffer");    
                        }else{
                            ComBtnDisable("btn_approve");
                            ComBtnEnable("btn_coffer"); 
                        }                                            
                    }              
                    formObj.ctrt_eff_dt.readOnly=true;    // duration
                    formObj.ctrt_exp_dt.readOnly=true;
                    dmdt_ft_tp_cd.SetEnable(0);

                    break;    
                    
                case 'A':   // Approved
                    ComBtnEnable("btn_amend");	                  
                    if (amdt_seq =="0"){            
                        ComBtnDisable("btn_free_pop");
                        ComBtnDisable("btn_dur_pop");
                    }
                    formObj.ctrt_eff_dt.readOnly=true;
                    formObj.ctrt_exp_dt.readOnly=true;
                    dmdt_ft_tp_cd.SetEnable(0);                       
                    break; 
                    
                case 'R':   // Returned                
                    if (amdt_seq =="0"){
                        ComBtnDisable("btn_dur_pop");
                        ComBtnDisable("btn_free_pop");
                    }                
                	ComBtnEnable("btn_request");
                    formObj.ctrt_eff_dt.readOnly=true;    // duration
                    formObj.ctrt_exp_dt.readOnly=true;                             
                    dmdt_ft_tp_cd.SetEnable(0);
                
                    break;
            }   
            otherFormControl(sts,amdt_seq,req_usr_flg,apro_usr_flg);
            sheetControl(sts,amdt_seq,req_usr_flg,apro_usr_flg);
        } catch (e) {
            if (e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    
    /**
     * event in case of changing selected item of IBMulti Combo.<br>
     *  Applying modified item to sheet by com_change_sheet() function . <br>
     * <br><b>Example :</b>
     * <pre>
     *    ctrt_dur_tp_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @param   {string} code Mandatory code
     * @param   {string} text Mandatory ,Character on screen
     * @return N/A
     * @author 
     * @version 2015.07.23
     */ 
     function ctrt_dur_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

         var formObj=document.form;
         var sheetObj=sheetObjects[0];
         com_change_sheet( sheetObj, "ctrt_dur_tp_cd" )      
     } 
    
    /**
    * setting Html tag object, IBMultiCombo's activate mode based on state of main <br>
    */      
    function otherFormControl(sts,amdtSeq,reqUsrFlg,aproUsrFlg){
        var formObj=document.form;
        switch (sts){
        case "I":
        	// (1) Non-Tariff RFA and (2) Authorized User(Request Or Approve)
        	if(!formObj.trf_ctrt_flg.checked && (aproUsrFlg == "Y" || reqUsrFlg == "Y")){
        		if(aproUsrFlg == "Y"){
    				formObj.prop_ofc_cd.readOnly = false;
    			}else{
    				formObj.prop_ofc_cd.readOnly = true;
    			}
        		prop_srep_cd.SetEnable(1);
    			respb_srep_cd.SetEnable(1);
				formObj.ctrt_eff_dt.readOnly=true;
        		formObj.ctrt_exp_dt.readOnly=true;
        		formObj.ctrt_cust_cnt_cd.readOnly=true;
    			formObj.ctrt_cust_seq.readOnly=true;
    			btnImgEnable(formObj.btn_ctrt_cust, false);
        		formObj.tgt_mvc_qty.readOnly=false;
            	cntr_lod_ut_cd.SetEnable(1);
            	ctrt_dur_tp_cd.SetEnable(1);
        		dmdt_ft_tp_cd.SetEnable(0);
    			if(amdtSeq == 0){
    				formObj.ctrt_eff_dt.readOnly=false;
            		formObj.ctrt_exp_dt.readOnly=false;
            		formObj.ctrt_cust_cnt_cd.readOnly=false;
        			formObj.ctrt_cust_seq.readOnly=false;
        			btnImgEnable(formObj.btn_ctrt_cust, true);
            		dmdt_ft_tp_cd.SetEnable(1);
    			}
        	}else{
        		// (2) Tariff RFA and (2) Authorized User(Request Or Approve)
        		if(formObj.trf_ctrt_flg.checked && (aproUsrFlg == "Y" || reqUsrFlg == "Y")){
                	formObj.ctrt_cust_cnt_cd.readOnly=true;
        			formObj.ctrt_cust_seq.readOnly=true;
        			btnImgEnable(formObj.btn_ctrt_cust, false);
            		formObj.prop_ofc_cd.readOnly=true;
        			prop_srep_cd.SetEnable(0);
        			respb_srep_cd.SetEnable(0);
        			formObj.tgt_mvc_qty.readOnly=false;
                	cntr_lod_ut_cd.SetEnable(1);
                	ctrt_dur_tp_cd.SetEnable(1);
                	if(amdtSeq==0){
                		dmdt_ft_tp_cd.SetEnable(1);
                	}else{
                		dmdt_ft_tp_cd.SetEnable(0);
                	}
        		}
        	}
        	break;
        	
        default:
        	formObj.prop_ofc_cd.readOnly = true;
        	if(!formObj.trf_ctrt_flg.checked && aproUsrFlg == "Y"){
        		prop_srep_cd.SetEnable(1);
        		respb_srep_cd.SetEnable(1);
        	}else{
        		prop_srep_cd.SetEnable(0);
        		respb_srep_cd.SetEnable(0);
        	}
        	
        }
    }
    /**
    * setting IBSheet's Cell activate mode based on state of main <br>
    */      
    function sheetControl(stsCd,amdtSeq,reqUsrFlg,aproUsrFlg){
    	var sheetObj=sheetObjects[1];
    	for(var i=1; i<=sheetObj.LastRow(); i++){
    		for (var j=2; j <=sheetObj.LastCol(); j++){
                sheetObj.SetCellEditable(i,j,0);
            }
    	}
    	if (stsCd == "I"){
    		for (var i=1; i <= sheetObj.RowCount();i++){
	              if (reqUsrFlg == "Y" || aproUsrFlg == "Y" ){
	                  sheetObj.SetCellEditable(i,"tgt_mvc_qty",1);
	                  sheetObj.SetCellEditable(i,"cntr_lod_ut_cd",1);
	                  sheetObj.SetCellEditable(i,"ctrt_eff_dt",1);
	                  sheetObj.SetCellEditable(i,"ctrt_exp_dt",1);
	                  sheetObj.SetCellEditable(i, "gline_cp_flg_lnk",1);
		              sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk",1);
		              sheetButtonImageChange(sheetObj,i, 0);
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_cd",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_pop",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_srep_cd",1);
	              }
	          }
    		if(amdtSeq == "0"){
    			for (var i=1; i <= sheetObj.RowCount();i++){
		              if (reqUsrFlg == "Y" || aproUsrFlg == "Y" ){
		                  sheetObj.SetCellEditable(i, "scp_dur_pop",0);
		                  sheetButtonImageChange(sheetObj,i, 0);
		                  sheetObj.SetCellEditable(i,"ctrt_eff_dt",1);
		                  sheetObj.SetCellEditable(i,"ctrt_exp_dt",1);
		              }
		          }
    		}else{
		          for (var i=1; i <= sheetObj.RowCount(); i++){
		              if (reqUsrFlg == "Y" || aproUsrFlg == "Y" ){
		            	  sheetObj.SetCellEditable(i, "scp_dur_pop",1);
		            	  sheetButtonImageChange(sheetObj,i, 1);
		            	  sheetObj.SetCellEditable(i,"ctrt_eff_dt",0);
		            	  sheetObj.SetCellEditable(i,"ctrt_exp_dt",0);
		            	  if(sheetObj.GetCellValue(i,"ctrt_eff_dt") == sheetObjects[0].GetCellValue(1,"eff_dt")){
		            		  sheetObj.SetCellEditable(i, "ctrt_exp_dt",1);
		                  }else{
		                	  sheetObj.SetCellEditable(i, "ctrt_exp_dt",0);
		                  }
		            	  sheetObj.SetCellEditable(i, "gline_cp_flg_lnk",1);
		              }
		          }
	        }
    	}else if (stsCd == "A"){
    		for (var i=1; i <= sheetObj.RowCount();i++){
    			for (var j=2; j <=sheetObj.LastCol(); j++){
    				sheetObj.SetCellEditable(i,j,0);
    			}
    			if(aproUsrFlg == "Y"){
    				sheetObj.SetCellEditable(i, "prop_scp_ofc_cd",1);
    				sheetObj.SetCellEditable(i, "prop_scp_ofc_pop",1);
    				sheetObj.SetCellEditable(i, "prop_scp_srep_cd",1);
    			}
		        if (amdtSeq == "0"){
			        sheetObj.SetCellEditable(i,"scp_dur_pop",0);
			        sheetButtonImageChange(sheetObj,i, 0);
		        }else{
			        sheetObj.SetCellEditable(i,"scp_dur_pop",1);
			        sheetButtonImageChange(sheetObj,i, 1);
		        }
    		    sheetObj.SetCellEditable(i, "gline_cp_flg_lnk",0);
    		}
    	}else{
    		for (var i=1; i <= sheetObj.RowCount();i++){
    		    if (amdtSeq != "0"){
    		        sheetObj.SetCellEditable(i, "scp_dur_pop",1);
    		        sheetButtonImageChange(sheetObj,i, 1);
    		    }else{
    		        sheetObj.SetCellEditable(i, "scp_dur_pop", 0);
    		        sheetButtonImageChange(sheetObj,i, 0);
    		    }
    		    if (aproUsrFlg == "Y"){
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_cd",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_pop",1);
	                  sheetObj.SetCellEditable(i, "prop_scp_srep_cd",1);
	              }else{
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_cd",0);
	                  sheetObj.SetCellEditable(i, "prop_scp_ofc_pop",0);
	                  sheetObj.SetCellEditable(i, "prop_scp_srep_cd",0);
	              }
    		}
    	}
    	if (amdtSeq =="0" && document.form.trf_ctrt_flg.checked){
    		for(var i=1; i<=sheetObj.RowCount(); i++){
    			sheetObj.SetCellEditable(i, "prop_scp_ofc_cd",0);
    			sheetObj.SetCellEditable(i, "prop_scp_ofc_pop",0);
    			sheetObj.SetCellEditable(i, "prop_scp_srep_cd",0);
    		}
		}
    }        
    /**
    * event handler when changing seleted item in IBMulti Combo<br>                                     
    */ 
    function prop_srep_cd_OnChange(comboObj, oldindex , oldtext , oldcode , newindex, text , code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length >= 1) {
    		formObj.prop_srep_nm.value=comboObj.GetText(code, 1);
    	}          
        com_change_sheet( sheetObj, "prop_srep_cd" );
    }    
    /**
    * event handler when changing seleted item in IBMulti Combo<br>
    * setting the changed data by using com_change_sheet() function <br>
    */     
    function respb_srep_cd_OnChange(comboObj, oldindex , oldtext , oldcode , newindex, text , code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var newRowIdx = parseInt(newindex);
        if (comboObj.GetText(1, 1) != null && comboObj.GetText(newRowIdx, 1) != undefined){
            formObj.ctrt_cust_srep_nm.value=comboObj.GetText(newRowIdx, 1);
            formObj.respb_sls_ofc_cd.value=comboObj.GetText(newRowIdx, 2);
        }else{
        	formObj.ctrt_cust_srep_nm.value="";
        	formObj.respb_sls_ofc_cd.value="";
        }
        com_change_sheet( sheetObj, "respb_srep_cd" );
        com_change_sheet( sheetObj, "respb_sls_ofc_cd" );
    } 
    
    
    /**
     * 2014-10-08 [NYK]
     * Event in case of modifying tariff Check Box Object's Check value<br>
     * Applying modified value to hidden sheet when modifying value<br>
     * Modifying N in case of unchecking Y when checking value<br>
     * <br><b>Example :</b>
     * <pre>
     *    obj_click();
     * </pre>
     * @param  N/A
     * @return N/A
     * @author 
     * @version 2014-10-08
     */  
    function obj_click(){
    	var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		if(event.srcElement.name == "trf_ctrt_flg") {

	        var vChkVal = document.form.trf_ctrt_flg.checked;
	        sheetObj.SetCellValue(1,event.srcElement.name, (vChkVal == true) ? "Y" : "N");   
	        
	        if(vChkVal) {
	        	var v_ctrt_cust_cnt_cd = tffBscCustCd.substr(0,2);
	            var v_ctrt_cust_seq = tffBscCustCd.substring(2,tffBscCustCd.length);
	            formObj.ctrt_cust_cnt_cd.value = v_ctrt_cust_cnt_cd;
	            formObj.ctrt_cust_seq.value = v_ctrt_cust_seq;
	            setCustomerInfo("ctrt_cust_cnt_cd",v_ctrt_cust_cnt_cd,true);
	            setCustomerInfo("ctrt_cust_seq",v_ctrt_cust_seq,true);
	        } else {
	        	document.form.ctrt_cust_cnt_cd.value = "";
	        	setCustomerInfo("ctrt_cust_cnt_cd","",true);
	            setCustomerInfo("ctrt_cust_seq","",true);
	        }
	        
	        
	        setTariffControl(document.form, vChkVal, false);
		} //end if

        
        
    }
    
    
    /**
    * calling the function when IBMulti Combo lost the focus<br>
    * setting Combo text in Html Object <br>
    */  
   function respb_srep_cd_OnBlur(comboObj) {
 		var formObj=document.form;		
 		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
 		var sheetObj=sheetObjects[0];
 		var ofc=comboObj.GetText(comboObj.GetSelectCode(),2);
 		if (code != null && code != "") {
 			var text=comboObj.GetText(code, 1);
 			if (text != null && text != "" && text != formObj.ctrt_cust_srep_nm.value) {
 				formObj.ctrt_cust_srep_nm.value=comboObj.GetText(code, 1);
 				formObj.respb_sls_ofc_cd.value=ofc;
 			}
 		}
		if (code == -1){
			formObj.ctrt_cust_srep_nm.value="";
		}
        com_change_sheet( sheetObj, "respb_srep_cd" );
        com_change_sheet( sheetObj, "respb_sls_ofc_cd" );
 	}        
    /**
    * event handler when changing seleted item in IBMulti Combo<br>
    * setting the changed data by using com_change_sheet() function <br>
    */     
    function cntr_lod_ut_cd_OnChange(comboObj, oldindex , oldtext , oldcode , newindex, text , code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        com_change_sheet( sheetObj, "cntr_lod_ut_cd" )      
    }        
    /**
    * event handler when changing seleted item in IBMulti Combo<br>
    * setting the changed data by using com_change_sheet() function <br>
    */      
    function dmdt_ft_tp_cd_OnChange(comboObj, oldindex , oldtext , oldcode , newindex, text , code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        com_change_sheet( sheetObj, "dmdt_ft_tp_cd" )
        changeDmdtBtnStatus();
    }     
    /**
     * setting Dem/Det buttons's activate mode based on Free Time condition <br>
     */     
    function changeDmdtBtnStatus(){    
    	var req_usr_flg=sheetObjects[0].GetCellValue(1, "req_usr_flg");
    	var apro_usr_flg=sheetObjects[0].GetCellValue(1, "apro_usr_flg");
    	var soKup=sheetObjects[0].GetCellValue(1, "so_kup");
    	var aproUsrFlgOri=sheetObjects[0].GetCellValue(1, "apro_usr_flg_ori");
        var formObj=document.form;
        var sw=false;
        //function skip control (common function)       
	    if(undefined != formObj.skip_flag_fun_changeDmdtBtnStatus && "Y" == formObj.skip_flag_fun_changeDmdtBtnStatus.value){	    	
	    	return;
	    }
        if (dmdt_ft_tp_cd.GetSelectCode()=="E"){
            sw=true;
        }
        if (sw ==true){
        	if (soKup == "Y"){
        		if (req_usr_flg =="Y" || aproUsrFlgOri == "Y"){
                    ComBtnEnable("btn_dem_pop"); 
                    document.getElementById("btn_dem_pop").style.color="black";
        		}else{
                    ComBtnDisable("btn_dem_pop"); 
                    document.getElementById("btn_dem_pop").style.color="";
        		}        		
        	}else{
        		if (req_usr_flg =="Y" || apro_usr_flg == "Y"){
                    ComBtnEnable("btn_dem_pop"); 
                    document.getElementById("btn_dem_pop").style.color="black";
        		}else{
                    ComBtnDisable("btn_dem_pop"); 
                    document.getElementById("btn_dem_pop").style.color="";
        		}
        	}        
        }else{
            ComBtnDisable("btn_dem_pop"); 
            document.getElementById("btn_dem_pop").style.color="";
        }
    }
    /**
    * setting changed data on the hidden sheet, when changing Html Object's value<br>
    */      
    function com_change_sheet( sheetObj, colNm ){
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
                case "n1st_cmnc_dt":
                    eleValue=ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");                     
                    break;                  
                case "ctrt_cust_seq":
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
    /**
    * calling function when occurring OnChange Event <br>
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
            		sheetObj.SetCellValue(Row, "n1st_cmnc_dt",sheetObj.GetCellValue(Row, "ctrt_eff_dt"),0);
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
    * calling function when occurring OnChange Event <br>
    * handling validation in case of changing Scope Duration <br>
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
                } else{
                	sheetObj.SetCellValue(Row, "eff_dt",sheetObj.GetCellValue(Row, "ctrt_eff_dt"),0);
                	sheetObj.SetCellValue(Row, "n1st_cmnc_dt",sheetObj.GetCellValue(Row, "ctrt_eff_dt"),0);
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
                var sParam = FormQueryString(formObj)+"&cd="+cd;
                var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
                var arrData=ComPriXml2Array(sXml, "cd|nm");
                if (arrData != null && arrData.length > 0) {
                    setSheetRequestOfficeSaleRep(sheetObj, Row, cd);
                }else{  
                    sheetObj.SetCellValue(Row,"prop_scp_ofc_cd","",0);
                    sheetObj.CellComboItem(Row,"prop_scp_srep_cd", {ComboText:"", ComboCode:""} );
                }
                if(formObj.prop_ofc_cd.value == sheetObj.GetCellValue(Row, Col)){
                	sheetObj.SetCellValue(Row, "prop_scp_srep_cd",prop_srep_cd.GetSelectText(),0);
                }
                break;
            case "tgt_mvc_qty":
            	if (sheetObj.GetCellValue(Row,Col) < 0){
            		sheetObj.SetCellValue(Row, Col,0,0);
            	}
            	break;
        }
    }    
    /**
    * calling function when occurring OnSearchEnd Event <br>
    * setting sheet's value to Html Object after retrieving sheet <br>
    */ 	
    function sheet1_OnSearchEnd(sheetObj, errMsg){
    	var formObj=document.form;
    	if(sheetObj.RowCount() < 1){
    		formObj.rfa_no.readOnly=false;
    		formObj.prop_no.readOnly=false;
    		return;
    	}
    	formObj.rfa_no.value=sheetObj.GetCellValue(1,"rfa_no");
    	formObj.prop_no.value=sheetObj.GetCellValue(1,"prop_no");
    	formObj.amdt_seq.value=sheetObj.GetCellValue(1,"amdt_seq");
    	formObj.ctrt_eff_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"ctrt_eff_dt"),"ymd");
    	formObj.ctrt_exp_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"ctrt_exp_dt"),"ymd");
    	formObj.prop_sts.value=sheetObj.GetCellValue(1,"prop_sts");
    	formObj.prop_ofc_cd.value=sheetObj.GetCellValue(1,"prop_ofc_cd");
    	formObj.prop_srep_nm.value=sheetObj.GetCellValue(1,"prop_srep_nm");
    	formObj.prop_apro_ofc_cd.value=sheetObj.GetCellValue(1,"prop_apro_ofc_cd");
    	formObj.prop_apro_staff.value=sheetObj.GetCellValue(1,"prop_apro_staff");
    	formObj.cre_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(1,"cre_dt"),"ymd");
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
    	formObj.ctrt_cust_srep_nm.value=sheetObj.GetCellValue(1,"ctrt_cust_srep_nm");
    	formObj.tgt_mvc_qty.value=ComAddComma(sheetObj.GetCellValue(1,"tgt_mvc_qty"));
    	comboObjects[2].SetSelectCode(sheetObj.GetCellValue(1,"cntr_lod_ut_cd"),false);
    	comboObjects[3].SetSelectCode(sheetObj.GetCellValue(1,"dmdt_ft_tp_cd"),false);
    	
    	//2014.10.08 [NYK]      
    	var trfCtrtFlg = sheetObj.GetCellValue(1,"trf_ctrt_flg")=="Y"?true:false;
        formObj.trf_ctrt_flg.checked = trfCtrtFlg;
        setTariffControl(formObj, trfCtrtFlg, true);
    	
		var preIbflag=sheetObj.GetRowStatus(1);
		sheetObj.SetCellValue(1,"ctrt_eff_dt_ori",sheetObj.GetCellValue(1,"ctrt_eff_dt"));
		sheetObj.SetCellValue(1,"ctrt_exp_dt_ori",sheetObj.GetCellValue(1,"ctrt_exp_dt"));
		sheetObj.SetCellValue(1, "dmdt_ft_tp_cd_ori",sheetObj.GetCellValue(1, "dmdt_ft_tp_cd"));
        sheetObj.SetCellValue(1, "prop_prpr_flg","Y",0);
        sheetObj.SetRowStatus(1,preIbflag);
        setCancelText();
//        popSokupMessage();
        
      //2015.07.23 ADD
   	  comboObjects[4].SetSelectCode(sheetObj.GetCellValue(1,"ctrt_dur_tp_cd"),false);
        
    }   
    /**
     * calling function when occurring OnSearchEnd Event <br>
     * setting the value to added column for calculating MQC
     */         
    function sheet2_OnSearchEnd(sheetObj, code, errMsg){
    	
    	//---------------------
    	//2014.09.05 NYK
    	if(code !=0) {
    		doActionIBSheet(sheetObjects[0],document.form, IBCREATE);
    	}
    	buttonControl();
    	document.form.prop_no.focus();
        //---------------------- 
    	
    	var sheetObj=sheetObjects[1];
        var sheetObj1=sheetObjects[0];
        var formObj=document.form;
        for ( var i=1; i <= sheetObj.RowCount(); i++ ){
        	sheetObj.SetCellValue(i,"tgt_mvc_qty_ori",sheetObj.GetCellValue(i,"tgt_mvc_qty"),0);
            sheetObj.SetRowStatus(i,"R");
        }
        for (var i = 1; i <= getValidRowCount(sheetObj); i++){        	
        	if (saveSvcScpCd == sheetObj.GetCellValue(i, "svc_scp_cd")){
        		sheetObj.SelectCell(i, 1);
        		break;
        	}
        }        
        if(sheetObj.RowCount() < 1) return;
        var cboObj=comboObjects[0];
        var srepCd=sheetObj1.GetCellValue(1,"prop_srep_cd");
        if (srepCd !="" && cboObj.FindItem(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.prop_srep_nm.value,srepCd);
        }
        cboObj=comboObjects[1];
        srepCd=sheetObj1.GetCellValue(1,"respb_srep_cd");
		if (srepCd !="" && cboObj.FindItem(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.ctrt_cust_srep_nm.value + "|" +formObj.respb_sls_ofc_cd.value, srepCd);
        }
        //sale rep        
		comboObjects[0].SetSelectCode(sheetObj1.GetCellValue(1,"prop_srep_cd"),false);
		comboObjects[1].SetSelectCode(sheetObj1.GetCellValue(1,"respb_srep_cd"),false);
        comboObjects[1].InsertItem(0, " | | "," ");
        var amdtSeq=document.form.amdt_seq.value;
        if(amdtSeq==0){                        
            return;
        }   
        for(var i=1 ; i <= sheetObj.RowCount(); i++){
        	if(sheetObj.GetCellValue(i,"pre_ext_scp") == "N"){
        		sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
            }
        }      
    }   
     /**
     * calling function when occurring OnSelectCell Event <br>
     */      
     function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
	   	  try{
	   		 ComOpenWait(true); //->waiting->start
	   		 if (saveSvcScpCd != "" && saveSvcScpCd != sheetObj.GetCellValue(NewRow, "svc_scp_cd")){
		   		  return;
		   	  }
	          if (OldRow != NewRow) {
	              changeSelectBackColor4Main(sheetObj);
	          }
		   	  saveSvcScpCd="";         
		   	  if(sheetObj.GetCellValue(NewRow,"svc_scp_cd")!=""&&OldRow!=NewRow&&sheetObj.GetCellValue(NewRow,"ibflag")!="I"){
		   		  comApplyStyleProposalStatusSummary(sheetObj.GetCellValue(NewRow,"svc_scp_cd"));
	            // 0728
	            if (tabObjects[0].GetSelectedIndex()== 0) {
	            	tab1_OnChange(tabObjects[0], 0);
	            } else {
	                tabObjects[0].SetSelectedIndex(0);
	            }           
	             loadTabPage(beforetab, NewRow);            
		   	  }else if(sheetObj.GetCellValue(NewRow,"ibflag")=="I"){
	             if (NewRow != OldRow){
	                clearAllTabPages();
	             }          
	         }	   		
	         ComOpenWait(false); //->waiting->End
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
    * calling function when occurring OnPopupClick Event <br>
    * calling Scope Duration,Scope MQC, G/L Copy <br>
    */   
    var popupRow = 0;
    var popupCol = "";
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        popupRow = Row;
        popupCol=colName;
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
                if(sParam != "") {
                	ComOpenPopup("ESM_PRI_2010.do?"+sParam, 635, 450, "setReturnValue", "1,0,1,1,1,1,1", true);
                }
                break;
                
            case "gline_cp_flg_lnk":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }  
                var sParam="prop_no="+sheetObjects[0].GetCellValue(1, "prop_no")+"&amdt_seq="+sheetObjects[0].GetCellValue(1, "amdt_seq")+"&rfa_no="+sheetObjects[0].GetCellValue(1, "rfa_no") +"&svc_scp_cd="+sheetObjects[1].GetCellValue(Row, "svc_scp_cd")+"&eff_dt="+sheetObjects[1].GetCellValue(Row, "ctrt_eff_dt")+"&exp_dt="+sheetObjects[1].GetCellValue(Row, "ctrt_exp_dt");      
                ComOpenPopup("ESM_PRI_2080.do?"+sParam, 522, 300, "setReturnValue", "1,0,1,1,1,1,1", true);
                break;
            case "prop_scp_ofc_pop":
                ComOpenPopup("COM_ENS_071.do?", 1000, 520, "setReturnValue", '1,0,1,1,1,1,1', true);
                break;
        }
    }          
    
    function setReturnValue(rtnVal) {
    	var formObj=document.form;
		if(popupCol=="scp_dur_pop" || popupCol=="btn_dur_pop") {
			 if (rtnVal != null && rtnVal =="Y") {
                 doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);    
             }   
		}
		if(popupCol=="gline_cp_flg_lnk") {
			if (rtnVal != null && rtnVal =="OK"){
                clearAllTabPages();
                comApplyStyleProposalStatusSummary(sheetObjects[1].GetCellValue(popupRow,"svc_scp_cd"));
                if (tabObjects[0].GetSelectedIndex()== 0) {
                    tab1_OnChange(tabObjects[0], 0);
                } else {
                    tabObjects[0].SetSelectedIndex(0);
                }
                loadTabPage(beforetab);
            }
		}
		if(popupCol=="prop_scp_ofc_pop") {
			if (rtnVal != null){
				sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "prop_scp_ofc_cd", ComLpad(rtnVal[0][3],6,""));
            }
		}
    }
    /**
    * calculationg MVC based on MQC<br>
    * MVC = MQC / Duration valid day x 7 <br>
    */  
    function calcMVC(){
        var formObj=document.form;
        var mqcQty=sheetObjects[0].GetCellValue(1, "tgt_mvc_qty");
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
        formObj.prop_mvc_tp.value=comboObjects[2].GetSelectText();
    }   
    /**
     * checking existane of Scope Terms's data when deleting scope<br>
     */  
    function checkScopeDelete(Row){
        var formObj=document.form;
        var sheetObj1=sheetObjects[1];
        var scpCd=sheetObj1.GetCellValue(Row, "svc_scp_cd");
        var rValue="N";
        formObj.f_cmd.value=SEARCH09;
        var sParam="prop_no="+ sheetObjects[0].GetCellValue(1, "prop_no")+ "&" + FormQueryString(formObj) +"&svc_scp_cd="+scpCd ;
        var sXml=sheetObjects[0].GetSearchData("ESM_PRI_2003GS.do" , sParam);
        var arrData=ComPriXml2Array(sXml, "delcnt");
        if (arrData !=null && arrData.length > 0){
            if (arrData[0] == 0){
                rValue="Y";
            }
        }
        return rValue;
    }
    /**
    * setting Scope main's state, buttons activate mode after changing Terms's state<br>
    */  
    function scopeStatusChange(scpCd){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var sheetObj1=sheetObjects[1];      
        var apro_usr_flg=sheetObj.GetCellValue(1, "apro_usr_flg")
        var sts=sheetObjects[0].GetCellValue(1, "prop_sts_cd");
        formObj.f_cmd.value=SEARCH08;     
        var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , FormQueryString(formObj)+"&svc_scp_cd="+scpCd);
        var arrData=ComPriXml2Array(sXml, "prop_scp_sts_cd","");
        if (arrData !=null && arrData.length > 0){  
            for (var i=1; i <= sheetObj1.RowCount(); i++ ){
            	if (sheetObj1.GetCellValue(i, "svc_scp_cd") == scpCd ){
            		var flag=sheetObj1.GetRowStatus(i);
                    sheetObj1.SetCellValue(i, "prop_scp_sts_cd",arrData[0][0]);
                    sheetObj1.SetRowStatus(i,flag);
                    break;
                }
            }    
            if (arrData[0][0] == "A"){       
                if (checkAccept() == "Y"){
                    if(apro_usr_flg == "Y"){            
                        ComBtnEnable("btn_approve"); 
                        ComBtnDisable("btn_coffer");
                    }            
                }else{          
                    ComBtnDisable("btn_approve"); 
                    if (sts == "Q"){
                        ComBtnEnable("btn_coffer"); 
                    }       
                }           
            }else if (arrData[0][0] =="I") {
            	if (sheetObj.GetCellValue(1,"prop_sts_cd") == "Q" || apro_usr_flg=="Y" ){
                    ComBtnDisable("btn_approve");   
                    if (sts == "Q"){
                        ComBtnEnable("btn_coffer"); 
                    }
                }
            }
        }
    }        
    /**
     * checking existance of Request Dem/Det <br>
     */  
    function checkDmdtData(){
    	var formObj=document.form;
        var sheetObj=sheetObjects[0]
        var rValue="N";            
        var dmdtSts=sheetObj.GetCellValue(1, "dmdt_ft_tp_cd_ori");
        formObj.f_cmd.value=SEARCH10;
        var sParam="prop_no="+sheetObj.GetCellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , sParam);
        var arrData=ComPriXml2Array(sXml, "ex_cnt|ta_cnt|all_cnt");
        if (arrData != null && arrData.length > 0) {
            if (dmdtSts == "E"){
            	if (arrData[0][2] == 0){
            		ComShowCodeMessage('PRI01091');            		
            	}else{
            		if (arrData[0][0] == 0){
            			ComShowCodeMessage('PRI01114');          
            		}else{
            			rValue="Y";	
            		}            		
            	}
            } else{
            	if (arrData[0][1] > 0){
            		ComShowCodeMessage('PRI01115');            		
            	}else{
            		rValue="Y";
            	}
            }        	
        } else{
        	if (dmdtSts == "E"){
            	ComShowCodeMessage('PRI01091');            	
        	} else{
        		rValue="Y";
        	}
        }
        return rValue;        
    }   
    /**
     * prohibiting Init Cancel in case of Proposal Number exists in DMT_RFA_EXPT_TRF table 
     */      
    function checkInitCancelDmdtData(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0]
        var rValue="N";            
        formObj.f_cmd.value=SEARCH10;
        var sParam="prop_no="+sheetObj.GetCellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , sParam);
        var arrData=ComPriXml2Array(sXml, "all_cnt");
        if (arrData != null && arrData.length > 0) {
            if (arrData[0][0] > 0){
            	rValue="Y";
            }        	
        }
        return rValue;        
    } 
    
    /**
     * checking Duration,DEM/DET 's change when Reuest <br>
     * showing the message when changed <br>
     */ 
    function checkDuration(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0]
        var rValue="N";                          
        formObj.f_cmd.value=SEARCH11;
        var sParam="prop_no="+sheetObj.GetCellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , sParam);
        var arrData=ComPriXml2Array(sXml, "cd");
        if (arrData != null && arrData.length > 0) {
            if (arrData[0][0] == "3"){
                rValue="Y";   
            }           
        }
        return rValue;        
    }       
    /**
    * checking all Terms Accecpt
    * checking Approve button's activate mode when Approving 
    */  
    function checkAccept(){
    	var formObj=document.form;
        var sheetObj=sheetObjects[0]
        var rValue="Y";
        formObj.f_cmd.value=SEARCH05;
        var sParam="prop_no="+sheetObj.GetCellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , sParam);
        var arrData=ComPriXml2ComboString(sXml, "prop_no","prop_no");
        if (arrData !=null && arrData.length > 0){
            rValue="N";
        }
        return rValue;
    }
    /**
    * checking all terms's modes are "accept or return"
    * do not Count Offer in case of return value is "N"  
    */ 
    function checkCountOffer(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0]
        var rValue="N";
        formObj.f_cmd.value=SEARCH06;
        var sParam="prop_no="+sheetObj.GetCellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , sParam);
        var arrData=ComPriXml2ComboString(sXml, "status","cnt");
        if (arrData !=null && arrData.length > 0){
            if (arrData[1] == 0){
                rValue="Y"
            }
        }
        return rValue;
    }
    /**
    * checking existance of BKG data when Approve Canceling
    * can not Approve Cancel in case of return value is "N"  
    */     
    function checkApproveCancel(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0]
        var rValue="N";
        formObj.f_cmd.value=SEARCH14;
        var sParam="rfa_no="+sheetObj.GetCellValue(1, "rfa_no")+"&eff_dt=" +sheetObj.GetCellValue(1, "eff_dt")+"&exp_dt="+sheetObj.GetCellValue(1, "exp_dt")+"&"+FormQueryString(formObj);
        var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , sParam);
        var arrData=ComPriXml2Array(sXml, "cd|etc1");
        var strMsg="";
        var chkData="";
        if (arrData !=null && arrData.length > 0){
        	chkData=arrData[0][0];
        	for (var i=1; i < arrData.length; i++){
        		if (i == 6){
        			strMsg += " ..."
        			break;
        		}else if (i !=1){
        			strMsg += ", "
        		}
        		strMsg+=arrData[i][0]
        	}        	
        }
        if (strMsg == "" && chkData == "OK"){
        	rValue="Y";
        } else{
        	ComShowCodeMessage('PRI01107',strMsg);
        }
        return rValue;
    }    
    /**
     * checking existance of returned in Terms
     * setting Returned in Scope's state in case of return value is "N"   
     */  
    function checkReturned(svcScpCd){
        var formObj=document.form;
        var sheetObj=sheetObjects[0]
        formObj.f_cmd.value=SEARCH06;
        var sParam="prop_no="+sheetObj.GetCellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , sParam);
        var arrData=ComPriXml2ComboString(sXml, "status","cnt");        
        if (arrData !=null && arrData.length > 0){
            if (arrData[1] == 0){
                rValue="Y"
            }
        }
        return rValue;        
    }    
     /**
      * cheking possibility of Request when clicking the Request button
      */    
     function checkRequest(){
        document.form.f_cmd.value=SEARCH07;
        var rMsg="";
        var rValue="N"; 
        var sParam="prop_no="+sheetObjects[0].GetCellValue(1, "prop_no")+ "&" + FormQueryString(document.form) ;
        var errMsg="";
        var sXml=sheetObjects[0].GetSearchData("ESM_PRI_2003GS.do", sParam);
        var chkType="";
        var arrData=ComPriXml2Array(sXml, "terms|cnt");
        var amendChk=false;
        if (arrData != null && arrData.length > 0) {
            for (var i=0; i < arrData.length; i++){
                if (arrData[i][0] == "CALC_CHK"){// RATE CALCULATE
                	chkType="1";
                	if (arrData[i][1] != ""){
                		rValue="N";
                		errMsg=arrData[i][1];
                		break;
                	}else{
                		rValue="Y";
                	}
                } else{
                	chkType="2";
                	if (arrData[i][1] != "0"){
                        rValue="Y";
                    }else{
                        rMsg += " "+arrData[i][0]+" "                    
                        rValue="N";
                    	if (arrData[i][0] == "AMEND"){
                    		amendChk=true;
                    	}
                        break;
                    }                	
                }
            }            
            if (rValue == "N" && amendChk == false && chkType == "2"){
                ComShowCodeMessage("PRI01042",rMsg);
            }else if (rValue == "N" && amendChk == true && chkType == "2"){
            	ComShowCodeMessage("PRI01105"); 
            }else if (rValue == "N" && chkType == "1"){//RATE CALCULATE
            	ComShowCodeMessage("PRI03027",errMsg,"Request");
            }
        } else{
        	ComShowMessage(OBJECT_ERROR);
        }
        return rValue;
     }
	  /**
	   * prohibiting Request Cancel when Accept,Returned data exist 
	   */  
   function checkRequestCancel(){
      var formObj=document.form;
      var sheetObj=sheetObjects[0];
      var rValue="N";                          
      formObj.f_cmd.value=SEARCH19;
      try {
    	  var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
          sParam += "&" + FormQueryString(formObj);
          var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , sParam);
          var arrData=ComPriXml2Array(sXml, "cnt");
          if (arrData != null && arrData.length > 0) {
        	  if (arrData[0][0] == "0" ){
        		  rValue="Y";	
              }  
          }        	
      	  if (rValue == "N"){
      		  ComShowCodeMessage("PRI01129");
      	  }
      } catch (e) {
		  	if (e == "[object Error]") {
		          ComShowMessage(OBJECT_ERROR);
		      } else {
		          ComShowMessage(e.message);
		      }
		  	rValue="N";
      } finally{
    	  return rValue;
      }       
   	}        
    /**
     * setting Sales Rep by inputted Customer Sale Office in IBMulti Combo 
     */   
    function setCustSaleRep(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        if (formObj.ctrt_cust_cnt_cd.value != "" && formObj.ctrt_cust_seq.value != "") {
            formObj.f_cmd.value=SEARCHLIST;
            var sParam=FormQueryString(formObj) + "&etc2=" + formObj.ctrt_cust_cnt_cd.value + "&etc3=" + ComParseInt(formObj.ctrt_cust_seq.value);
            sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
            ComPriXml2ComboItem(sXml, respb_srep_cd, "cd", "cd|nm|etc1");
            comboObjects[1].InsertItem(0, " | | "," ");
        }
    }
    /**
    * setting Sales Rep by inputted Office in IBMulti Combo 
    */
    function setRequestOfficeSaleRep(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        formObj.f_cmd.value=SEARCH15;     
        var sParam=FormQueryString(formObj) +"&etc1="+ formObj.prop_ofc_cd.value;
        var sXml=sheetObj.GetSearchData("PRICommonGS.do",sParam);
        ComPriXml2ComboItem(sXml,prop_srep_cd, "cd", "cd|nm");
    }
    

    /**
     * Setting Sales rep for inputted Scope's Request Office  to sheet Combo<br>    
     * <br><b>Example :</b>
     * <pre>
     *		setSheetRequestOfficeSaleRep(sheetObj, Row, offCd);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int}     Row      Mandatory selection한 Row Index
     * @param {string}  offCd    Mandatory Scope의 Request Office code
     * @return N/A
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
            var aTextSub = aText.substring(0,aText.length-1);
            sheetObj.CellComboItem(Row,"prop_scp_srep_cd", {ComboText:aTextSub, ComboCode:arrData[0]} );
        }else{
        	sheetObj.CellComboItem(Row,"prop_scp_srep_cd", {ComboText:"", ComboCode:""} );
        }
    } 
    
    /**
    * getting SaleRep.'s Office Code
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
    * initializing Html Object about Customer
    */  
    function clearCustName(){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        sheetObj.SetCellValue(1, "ctrt_cust_cnt_cd","");
        sheetObj.SetCellValue(1, "ctrt_cust_seq","");
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
        comboObjects[1].SetSelectCode("");
        formObj.ctrt_cust_val_sgm.value="";
        formObj.respb_sls_ofc_cd.value="";
        formObj.ctrt_cust_srep_nm.value="";
        formObj.prc_ctrt_cust_tp_nm.value="";
    }
    /**
    * retrieving information about Customer
    */      
    function custNameFind(eleName){
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var ctrt_cust_cnt_cd=formObj.ctrt_cust_cnt_cd.value;        
        var ctrt_cust_seq=formObj.ctrt_cust_seq.value;        
        if(ctrt_cust_cnt_cd != "" && ctrt_cust_seq !=""){
            var sParam="f_cmd="+SEARCH02+"&cust_cnt_cd="+ctrt_cust_cnt_cd+"&cust_seq="+ctrt_cust_seq;
            var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do", sParam);
            var arrText=ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_cust_val_sgm|respb_srep_cd|respb_sls_ofc_cd|ctrt_cust_srep_nm|prc_ctrt_cust_tp_nm|ctrt_cust_val_sgm_cd");
            if(arrText==undefined){
                clearCustName();
                formObj.ctrt_cust_cnt_cd.focus();
            } else{           
                comboObjects[1].SetSelectCode("");
                sheetObj.SetCellValue(1,"prc_ctrt_cust_tp_cd",arrText[0][0],0);
                sheetObj.SetCellValue(1,"ctrt_pty_nm",arrText[0][1],0);
                sheetObj.SetCellValue(1,"ctrt_cust_val_sgm",arrText[0][6],0);
                sheetObj.SetCellValue(1,"ctrt_cust_val_sgm_cd",arrText[0][7],0);
                sheetObj.SetCellValue(1,"respb_srep_cd",arrText[0][3],0);
                sheetObj.SetCellValue(1,"respb_sls_ofc_cd",arrText[0][4],0);
                formObj.ctrt_pty_nm.value=arrText[0][1];
                formObj.ctrt_cust_val_sgm.value=arrText[0][2];
                formObj.respb_sls_ofc_cd.value=arrText[0][4];           
                comboObjects[1].SetSelectCode(arrText[0][5]);
                formObj.ctrt_cust_srep_nm.value=arrText[0][5];
                formObj.prc_ctrt_cust_tp_nm.value=arrText[0][6];                
            }
        }
        var sheetObj=sheetObjects[0];         
        com_change_sheet( sheetObj, eleName);      
    }   
    /**
     * changing scope duration before saving main duration's changed data 
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
        var amdtSeq=sheetObj.GetCellValue(1,"amdt_seq");
        if (sheetObj.GetCellValue(1, "ibflag")=="I"){
            for( var i=1; i <= sheetObj1.RowCount(); i++){
            	sheetObj1.SetCellValue(i, "ctrt_eff_dt",ctrtEffDt);
            	sheetObj1.SetCellValue(i, "ctrt_exp_dt",ctrtExpDt);
            }
        	return true;
        }
        if (oriCtrtEffDt > ctrtEffDt ){
            effChk=1; // add Duration Eff 
            for ( var i=1 ; i <=sheetObj1.RowCount(); i++){
            	if (oriCtrtEffDt == sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    msgChk=1;
                    break;
                }
            }
        }else if (oriCtrtEffDt < ctrtEffDt){
            effChk=2; // reduce Duration Eff 
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (ctrtEffDt >= sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    msgChk=2;
                    break;
                }
            }
        }
        if (oriCtrtExpDt > ctrtExpDt ){ //reduce Duration Eff 
            expChk=1; //reduce Duration Eff 
            for ( var i=1 ; i <= sheetObj1.RowCount(); i++){
            	if (ctrtExpDt <= sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    msgChk += 3; 
                    break;
                }
            }
        } else if (oriCtrtExpDt < ctrtExpDt){
            expChk=2; // add Duration Eff 
            // add Proposal Duration Eff only in case of "NO" selected 
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (oriCtrtExpDt == sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    msgChk += 6;
                    break;
                }               
            }
        }       
        if ((effChk + expChk) == 0){
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
            //effChk = 1; // add Duration Eff 
            for ( var i=1 ; i <= sheetObj1.RowCount(); i++){
            	if (oriCtrtEffDt == sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    sheetObj1.SetCellValue(i,"ctrt_eff_dt",ctrtEffDt,0);
                    sheetObj1.SetCellValue(i,"eff_dt",ctrtEffDt,0);
                    if (amdtSeq =="0"){
                        sheetObj1.SetCellValue(i, "n1st_cmnc_dt",ctrtEffDt,0);
                    }
                }
            }
        } else if (effChk == 2){
            //effChk = 2; // reduce Duration Eff 
            for (var i=1; i <= sheetObj1.RowCount(); i++){
            	if (ctrtEffDt >= sheetObj1.GetCellValue(i, "ctrt_eff_dt")){
                    sheetObj1.SetCellValue(i, "ctrt_eff_dt",ctrtEffDt,0);
                    sheetObj1.SetCellValue(i, "eff_dt",ctrtEffDt,0);
                    if (amdtSeq =="0"){
                        sheetObj1.SetCellValue(i, "n1st_cmnc_dt",ctrtEffDt,0);
                    }
                }
            }
        }
        if (expChk == 1){
            //expChk = 1; // reduce Duration Eff 
            //Return and all process cancel in case of "NO" selected 
            for ( var i=1 ; i <= sheetObj1.RowCount(); i++){
            	if (ctrtExpDt <= sheetObj1.GetCellValue(i, "ctrt_exp_dt")){
                    sheetObj1.SetCellValue(i,"ctrt_exp_dt",ctrtExpDt,0);
                    sheetObj1.SetCellValue(i,"exp_dt",ctrtExpDt,0);
                }
            }
        } else if (expChk == 2){
            //expChk = 2; // add Duration Eff 
            // add Proposal Duration Exp only in case of "NO" selected 
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
      * changing Main,Scope's state based on main scope Terms's change
      */   
     function comUpdateProposalStatusSummary(termTpCd, svcScpCd){
         var sParam="";         
         var formObj=document.form;         
         var sheetObj=sheetObjects[0];
         try {
        	 ComOpenWait(true); //->waiting->start  
             changeMainStatus();
             if(svcScpCd != undefined && svcScpCd != ""){
                 comApplyStyleProposalStatusSummary(svcScpCd);
                 scopeStatusChange(svcScpCd) // changing scope state
             }
             ComOpenWait(false); //->waiting->End
             buttonControl();
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
       * retrieving main status after changing summary 
       * setting Status = Request, in case of 1) Main's Status =  Returned  2) all Terms's Accepted
       */      
      function changeMainStatus(){
          var formObj=document.form;
          var sheetObj=sheetObjects[0];                         
          var sParam="prop_no=" + sheetObj.GetCellValue(1, "prop_no") + "&amdt_seq="+sheetObj.GetCellValue(1, "amdt_seq");
          sParam += "&f_cmd="+SEARCH18;
          var sXml=sheetObj.GetSearchData("ESM_PRI_2003GS.do" , sParam);
          var arrData=ComPriXml2Array(sXml, "prop_sts_cd|prop_sts");
          if (arrData !=null && arrData.length > 0){
          	if (arrData[0][0] == "Q"){
                sheetObj.SetCellValue(1,"prop_sts_cd",arrData[0][0],0);
                formObj.prop_sts.value=arrData[0][1];
                sheetObj.SetCellValue(1,"prop_sts",arrData[0][1],0);
          	}
          }    
      }      
     /**
      * changing tab's icon based on scope terms's change
      */ 
     function comApplyStyleProposalStatusSummary(svcScpCd){
         var formObj=document.form;
         formObj.f_cmd.value=SEARCH04;
         var sParam="prop_no="+sheetObjects[0].GetCellValue(1, "prop_no")+ "&" + FormQueryString(formObj) +"&svc_scp_cd="+svcScpCd ;
         var sXml=sheetObjects[0].GetSearchData("ESM_PRI_2003GS.do", sParam);
         var arrText=ComPriXml2Array(sXml, "prop_scp_term_tp_cd|dat_flg");
         var icon="";
         var tabIdx="";
         var imgName="";
         for (i=0; i < arrText.length; i++){
             tabIdx="";
             imgName="";
             switch(arrText[i][0]){
                case '01':  //Duration,Scope Duration
                    imgName="btn_dur_pop";
                     break;
                 case '05':
                     imgName="btn_afil_pop";
                     break;
                 case '08':
                     imgName="btn_free_pop";
                     break;                  
                 case '13':  //Group Location
                     tabIdx="0";
                     break;                  
                 case '14':  //Group Commodity
                     tabIdx="1";                 
                     break;     
                 case '32':  //Special Note
                     tabIdx="4";
                     break;
                 case '52':  //Arbitrary                 
                     tabIdx="2";
                     break;     
                 case '71':  //Rate                  
                    tabIdx="3";
                 break;  
             }
             icon=ICON_URL_NOT_EXIST;
             switch(arrText[i][1]){
                 case "1":
                     icon=ICON_URL_EXIST;
                     break;
                 case "2":
                     icon=ICON_URL_AMEND;
                     break;
                 case "3":
                     icon=ICON_URL_ACCEPT;
                     break;
             }
             // e¸°e³¸ : Black , Amendi?œ : Red, All Accepti?œ : Blue
             if (arrText[i][0] == "01" || arrText[i][0] =="02"||arrText[i][0] == "05"||arrText[i][0] == "08" ){
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
     /**
     * creating Parameter when calling pop-up
     */     
     function getParameters(srcName, param){        
         var sheetObj=sheetObjects[0];
//         var sheetScp=sheetObjects[1];
         var sParam = "";
         if(sheetObj.RowCount() > 0) {
        	 
        	 var sRfaNo=sheetObj.GetCellValue(1,"rfa_no");
             var sPropNo=sheetObj.GetCellValue(1,"prop_no");
             var sAmdtSeq=sheetObj.GetCellValue(1, "amdt_seq");
             var sPreAmdtSeq=sheetObj.GetCellValue(1, "pre_amdt_seq");
             var sPropStsCd=sheetObj.GetCellValue(1, "prop_sts_cd");
             var sSrepCd=sheetObj.GetCellValue(1, "prop_srep_cd");
             var sSvcScpCd="";
             var aParam="";
             var sEffDt=ComGetMaskedValue(sheetObj.GetCellValue(1, "eff_dt"),"ymd");
             var sExpDt=ComGetMaskedValue(sheetObj.GetCellValue(1, "exp_dt"),"ymd");
             var sPreExpDt=ComGetMaskedValue(sheetObj.GetCellValue(1, "pre_exp_dt"),"ymd");
             var sIsReqUsr=sheetObj.GetCellValue(1, "req_usr_flg") == "Y" ? true: false;
             var sIsAproUsr=sheetObj.GetCellValue(1, "apro_usr_flg") == "Y" ? true: false;
             var sCtrtEffDt=document.form.ctrt_eff_dt.value;
             var sCtrtExpDt=document.form.ctrt_exp_dt.value;  
             var sDurDupFlg=sheetObj.GetCellValue(1, "dur_dup_flg");
             sParam="sRfaNo="+sRfaNo+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq
                        +"&sPropStsCd="+sPropStsCd+"&sSrepCd="+sSrepCd+"&sDurDupFlg="+sDurDupFlg
                        +"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr;
             switch (srcName) {        
                case "scp_dur_pop":
                    sParam += param;
                    break;
                case "btn_dem_pop":
                    break;
                case "btn_free_pop": 
                case "btn_afil_pop":
                    aParam="&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt                        
                            +"&sCtrtEffDt="+sCtrtEffDt+"&sCtrtExpDt="+sCtrtExpDt;               
                    sParam += aParam;
                    break;
                case "btn_amend":
                	var sDurDt=sheetObj.GetCellValue(1,"ctrt_eff_dt");
                	var eDurDt=sheetObj.GetCellValue(1,"ctrt_exp_dt");
                	var effDt=ComGetDateAdd(sheetObj.GetCellValue(1,"eff_dt"), "D", 1);
                    aParam="&sSdurDt=" + sDurDt + "&sEdurDt=" + eDurDt+ "&sEffDt=" + effDt ;
                    sParam += aParam;
                    break;
                } 
         }
         return sParam;
     }
     /**
      * returning Customer Type <br>
      */        
    function getCustTpCd(){
        var custTpCd="";
        var sheetObj=sheetObjects[0];
        custTpCd=sheetObj.GetCellValue(1, "prc_ctrt_cust_tp_cd");
        return custTpCd;
    }
    /**
     * setting control when user who doesn't have authority add new data <br>
     */ 
    function setNewDataControl(){
        var formObj=document.form;
        formObj.tgt_mvc_qty.readOnly=false;            
        formObj.ctrt_eff_dt.readOnly=false;
        formObj.ctrt_exp_dt.readOnly=false; 
        formObj.ctrt_cust_cnt_cd.readOnly=false;
        formObj.ctrt_cust_seq.readOnly=false;
        
        respb_srep_cd.SetEnable(1);
        cntr_lod_ut_cd.SetEnable(1);
        dmdt_ft_tp_cd.SetEnable(1);
        prop_srep_cd.SetEnable(1);
        
        //2014.10.08
        if(isRoleforPri == "Y") {
        	formObj.trf_ctrt_flg.disabled = false;
        } else {
        	formObj.trf_ctrt_flg.disabled = true;
        }

        btnImgEnable(formObj.btn_ctrt_cust, true);
        btnImgEnable(formObj.btns_calendar1, true);     
        ComBtnEnable("btn_save"); 
        ComBtnEnable("btn_rowadd");            
        ComBtnEnable("btn_delete");  
    }
    /**
     * calling the function when IBMulti Combo lost the focus<br>
     * setting Combo text in Html Object <br>
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
     * setting cancel button's data by main state <br>
     */ 
    function setCancelText(){
        var formObj=document.form;
        var cancelTxt=formObj.prop_sts.value ;
        if (cancelTxt == "Requested"){
            cancelTxt="Request ";
        }else if(cancelTxt == "Approved"){
            cancelTxt="Approve ";
        }else{
            cancelTxt="";
        }
        document.getElementById("btn_cancel").innerText=cancelTxt +"Cancel";
    }
 /**
  * setting screen width (hidden, show)<br>
  */   
	function setControlHidden(){
		if (!controlHidden){
			document.all.subterms.style.display="none";
			controlHidden=true;
		}else{
			document.all.subterms.style.display="inline";
			controlHidden=false;
			sheet1_OnSearchEnd(sheetObjects[0], "");
			buttonControl();
		}
		/*try{
		    parent.syncHeight(); 
			}catch(e){}*/
	}
    /**
     * showing message in case of retroactivity apply <br>
     * retroactivity authority OFFICE CODE : SINWSG,SHAASG, NYCNSG, HMAUSG,SELCTA,SELCTI,SELCTE,SELCGM,SINWA
     */         
    function popSokupMessage(){
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	//so_kup
    	var stsCd=sheetObj.GetCellValue(1, "prop_sts_cd");
    	var sokup=sheetObj.GetCellValue(1, "so_kup");
    	var aproveFlg=sheetObj.GetCellValue(1, "apro_usr_flg");
    	var aproOri=sheetObj.GetCellValue(1, "apro_usr_flg_ori");
    	if (stsCd == "Q" && formObj.prop_no.value !=""){
    		if (sokup == "Y" && aproveFlg != "Y" && aproOri == "Y"){
    			//PRI01103
    			 ComShowCodeMessage('PRI01103');
    		}
    	}
    }
    /**
     * setting image button activation <br>
     */ 
    function btnImgEnable(obj, gb) {
        if(obj.constructor == String){
            obj=document.getElementsByName(obj)[0];            
        }
        var btnStyle=obj.style;
        if (gb){           
            obj.enable = true;
            btnStyle.cursor="hand";
            btnStyle.filter="";
            obj.disabled=false;
        } else {         
        	obj.enable = false;
            btnStyle.cursor="auto";
            btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
            obj.disabled=true;
        }
    }
    /**
     * calling Message Popup function <br>
     * sending different Message by Status. setting user to receiver when Parameter has Sales Rep Code<br>
     */
    function openMessagePopup(stsCd, srepCd){
        var msg="";
        var formObj=document.form;
        var usrId="";
        var usrNm="";
        if(parent != undefined && parent.message != undefined){
        	if (srepCd != null) {
                formObj.f_cmd.value=SEARCHLIST11;
                var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj)+"&srep_cd="+srepCd);
                usrId=ComGetEtcData(sXml,"usr_id");
                usrNm=ComGetEtcData(sXml,"usr_nm");
            }
            if (stsCd == 'R') { // Counter Offer
                if (formObj.amdt_seq.value == '0') {
                    msg="<Returned> Proposal no. "+formObj.prop_no.value+"\\nRemark :";
                } else {
                    msg="<Returned> RFA no. "+formObj.rfa_no.value+" / Proposal no. "+formObj.prop_no.value+"\\nRemark :";
                }
                parent.message(usrId,usrNm,msg);
            } else if (stsCd == 'A') {  // Approve
                msg="<Approved> RFA no. "+formObj.rfa_no.value+" / Proposal no. "+formObj.prop_no.value;
                parent.message(usrId,usrNm,msg);
            } else if (stsCd == 'I'){//Request Cancel
                if (formObj.amdt_seq.value == '0') {
                    msg="<Request Cancel> Proposal no. "+formObj.prop_no.value+"\\nRemark :";
                } else {
                    msg="<Request Cancel> RFA no. "+formObj.rfa_no.value+" / Proposal no. "+formObj.prop_no.value+"\\nRemark :";
                }        	
            	parent.message(usrId,usrNm,msg);
            }
        }
        
    }
         /**
    * checking change for prohibiting same S/C changed simultaneously  
    */
   function checkChangingUpdateDate(checkSheetObj, checkTpCd ){
	   var returnValue=false;
	   switch(checkTpCd){
	   case "CHECK1" :
		   var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_RP_MN&page_name=RFA&key1=" + checkSheetObj.GetCellValue(1, "prop_no") + "&key2="+checkSheetObj.GetCellValue(1, "amdt_seq")+"&upd_dt="+checkSheetObj.GetCellValue(1, "upd_dt");
		   var cXml=checkSheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchData(cXml,{Sync:0} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        break;
	        
	   case "CHECK2" : //amend
		   var amdt_seq=parseInt(checkSheetObj.GetCellValue(1, "amdt_seq"));
	  		//checking existence of next seq 
	  		amdt_seq++;
	  		var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_RP_MN&page_name=RFA&key1=" + checkSheetObj.GetCellValue(1, "prop_no") + "&key2="+amdt_seq+"&upd_dt="+checkSheetObj.GetCellValue(1, "upd_dt");
	  		var cXml=checkSheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
		       	checkSheetObj.LoadSearchData(cXml,{Sync:0} );
		       	ComOpenWait(false); //->waiting->End
		       	returnValue=true;
	       }
	       break;
	   }
       return returnValue;
    }
   
   
   /**
    * set value of Customer info<br>
    * @param {String} Html Control name 
    * @param {Oject} the value of Object
    * @param {boolen} true/false
    * @version 2014.10.08
    */
   function setCustomerInfo(eleName, value, isTariff) {
	   var formObj = document.form;
       var sheetObj = sheetObjects[0]; 
  
       switch(eleName){

           case "ctrt_cust_cnt_cd":
        	   var str_ctrt_cust_cnt_cd = "";
        	   if(isTariff) {
        		   str_ctrt_cust_cnt_cd = value;
        	   } else {
        		   str_ctrt_cust_cnt_cd = formObj.ctrt_cust_cnt_cd.value;
        	   }
        	   
        	   //cust name find
               if (sheetObj.GetCellValue(1, "ctrt_cust_cnt_cd") != str_ctrt_cust_cnt_cd){
	               	if (str_ctrt_cust_cnt_cd == ""){
	               		clearCustName();
	               	}else{
	                   	custNameFind(eleName);
	                    // sale rep
	                    setCustSaleRep();
	                    comboObjects[1].SetSelectCode(sheetObj.GetCellValue(1,"respb_srep_cd"), true); 
	               	}
               }
               ComChkObjValid(event.srcElement);
             
               break;          
           case "ctrt_cust_seq":
        	   //2014.10.13
        	   setCustSeqInfo(formObj, sheetObj, eleName, value, isTariff);
               break;
       }
   }
   
   /**
    * set Customer info<br>
    * @param {Oject} form object
    * @param {Oject} sheet object
    * @param {Oject} the value of Object
    * @param {boolen} true/false
    * @version 2014.10.13
    */
   function setCustSeqInfo(formObj, sheetObj, eleName, value, isTariff) {
	   var custSeq = "";
	   if(isTariff) {
		   custSeq = value;
		   formObj.ctrt_cust_seq.value = custSeq;
	   } else {
		   custSeq = formObj.ctrt_cust_seq.value;
	   }
       
       if (custSeq.length < 6 && custSeq.length != 0 ){
           formObj.ctrt_cust_seq.value = ComLpad(custSeq, 6, "0");
       }
       //cust name find
       if (ComParseInt(sheetObj.GetCellValue(1, "ctrt_cust_seq")) != ComParseInt(custSeq)){                    
           if (custSeq ==""){   
           	clearCustName();
           }else{	
               custNameFind(eleName);
               // sale rep
               setCustSaleRep();
               comboObjects[1].SetSelectCode(sheetObj.GetCellValue(1,"respb_srep_cd"), true); 
           }
       }
   }
   
   /**
    * set readonly(enable) of Customer info by tariff<br>
    * @param {Oject} form object
    * @param {boolen} true/false
    * @param {boolen} true/false
    * @version 2014.10.08
    */
   function setTariffControl(formObj, isTariff, isSearch) {
       if(isTariff) {
    	   formObj.ctrt_cust_cnt_cd.readOnly = true; //Customer Code
           formObj.ctrt_cust_seq.readOnly = true;
           btnImgEnable(formObj.btn_ctrt_cust, false);
           respb_srep_cd.SetEnable(0);//Customer Sales Rep
           formObj.ctrt_cust_cnt_cd.required = false;
           formObj.ctrt_cust_seq.required = false;
           $("#ctrt_cust_cnt_cd, #ctrt_cust_seq").removeClass("input1");
           $("#ctrt_cust_cnt_cd, #ctrt_cust_seq").addClass("input2");
           
           //Request Office, Sales Rep
           formObj.prop_ofc_cd.readOnly = true;
           formObj.prop_ofc_cd.required = false;
           prop_srep_cd.SetSelectIndex(0, true);
           prop_srep_cd.SetEnable(0);
           
           $("#prop_ofc_cd").removeClass("input1");
           $("#prop_ofc_cd, #prop_srep_nm").addClass("input2");
           
           for(var i=1; i<=sheetObjects[1].RowCount(); i++){
        	   sheetObjects[1].SetCellEditable(i, "prop_scp_ofc_cd", 0);
        	   sheetObjects[1].SetCellEditable(i, "prop_scp_ofc_pop", 0);
        	   sheetObjects[1].SetCellEditable(i, "prop_scp_srep_cd", 0);
           }
       } else {
    	   formObj.ctrt_cust_cnt_cd.required = true;
           formObj.ctrt_cust_seq.required = true;
           $("#ctrt_cust_cnt_cd, #ctrt_cust_seq").removeClass("input2");
           $("#ctrt_cust_cnt_cd, #ctrt_cust_seq").addClass("input1");
           //Request Office, Sales Rep
           formObj.prop_ofc_cd.readOnly = false;
           formObj.prop_ofc_cd.required = true;
           prop_srep_cd.SetEnable(1);
           $("#prop_ofc_cd").removeClass("input2");
           $("#prop_ofc_cd").addClass("input1");
    	   if(!isSearch){
	    	   clearCustomControl(formObj);
	    	   setNewDataControl();
    	   }
    	   for(var i=1; i<=sheetObjects[1].RowCount(); i++){
        	   sheetObjects[1].SetCellEditable(i, "prop_scp_ofc_cd", 1);
        	   sheetObjects[1].SetCellEditable(i, "prop_scp_ofc_pop", 1);
        	   sheetObjects[1].SetCellEditable(i, "prop_scp_srep_cd", 1);
           }
       }
   }
   
   /**
    * set clear for Customer Info<br>
    * @param {Oject} form object
    * @version 2014.10.08
    */
   function clearCustomControl(formObj) {
	   comboObjects[1].RemoveAll();
	   
	   formObj.ctrt_cust_cnt_cd.value = "";
       formObj.ctrt_cust_seq.value = "";
       formObj.ctrt_pty_nm.value = "";
       comboObjects[1].SetSelectCode("");
       formObj.ctrt_cust_val_sgm.value = "";
       formObj.respb_sls_ofc_cd.value = "";
       formObj.ctrt_cust_srep_nm.value = "";
       formObj.prc_ctrt_cust_tp_nm.value ="";
   }
