﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_PRI_2043.js
*@FileTitle :  RFA List Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
    /**
     * @extends Pri
     * @class ESM_PRI_2043 : business script for ESM_PRI_2043 
     */
  //global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1;
    var sheet2;
    var comboObjects=new Array();
    var comboCnt=0;
    var gCurrDate;
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /** 
     * registering IBMultiCombo Object as comboObjects array <br>
     */ 
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * Initializing and setting Sheet basics<br> 
     * Setting body tag's onLoad event handler<br>
     * Adding pre-handling function after loading screen on the browser <br>
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
        axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm('blur', 'obj_deactivate', form);
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
        axon_event.addListenerForm('keyup', 'obj_keyup', form );
        ComEnableObject(form.access_date, false); // access date disabled
        gCurrDate=ComGetNowInfo('ymd', '-');
        form.eff_date_from.value=gCurrDate;
        form.eff_date_to.value=gCurrDate;
        initIBComboItem();
    }
    /**
     * setting Items to IBMultiCombo <br>
     */ 
    function initIBComboItem() {
        ComPriTextCode2ComboItem(svcScpCdComboValue,     svcScpCdComboText,     getComboObject(comboObjects, 'svc_scp_cd'),    		 "|", "\t" );
        //ComPriTextCode2ComboItem(customerCodeComboValue, customerCodeComboText, getComboObject(comboObjects, 'customer_code'), 		 "|", "\t" );
        ComPriTextCode2ComboItem(customerTypeComboValue, customerTypeComboText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd'), "|", "\t" );
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheet1){
                             
              var HeadTitle1="Seq.|Service\nScope|RFA|RFA|Customer|Customer|Customer|Request\nOffice|Sales\nRep.|Date|Date";
              var HeadTitle2="Seq.|Service\nScope|RFA No|AMD No|Type|Code|Name|Request\nOffice|Sales\nRep.|Effective|Expiration";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prc_ctrt_cust_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"code",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:415,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prop_scp_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prop_scp_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                     {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Date",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_exp_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(0);
              SetEllipsis(1);
              resizeSheet(); //SetSheetHeight(395);
                    }

                break;
            case "sheet2": // find_text 
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
              SetSheetHeight(70);
              }
                break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }

    /**   
     * initializing IBMultiCombo <br>
     * adding pre-handling function after screen loading  <br>
     * adding case in case of multiple combo <br>
     */ 
    function initCombo(comboObj, comboNo) {
        switch (comboObj.options.id) {
            //svc scope
            case "svc_scp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                    ValidChar(2);    
                    SetMaxLength(3);
                }
                break;
                //customer type
            case "prc_ctrt_cust_tp_cd":
                var i=0;
                with (comboObj) {
                    SetDropHeight(200);
                    SetUseAutoComplete(1);
                }
                break;
        }
    }      
  //Event handler processing by button click event */
    document.onclick=processButtonClick;
	/**
     * Event handler processing by button name 
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
                case "btn_ctrt_cust": //reference esm_pri_2003 
                	var sUrl="/opuscntr/ESM_PRI_4014_POP.do?nmd_cust_flg=N&is_popup=true&cust_cnt_cd="+form.ctrt_cust_cnt_cd.value+"&cust_seq="+form.ctrt_cust_seq.value;
                	ComOpenPopup(sUrl, 640, 465, "findCustomer", "none", true);
                    break;   
                case "req_off_cd":	// Office Code pop-up
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 500, "ofc_cd:prop_scp_ofc_cd", "1,0,1,1,1,1,1,1", true);
                    searchSRep();
                    break;
                case "btn_retrieve":
                    setParamsClear();  
                    if (validateForm(sheet1, form, IBSEARCH)) {
                        doActionIBSheet(sheet1, form, IBSEARCH);
                    }
                    break;
                case "btn_new":
                    doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                    break;
                case "btn_downexcel":
                    doActionIBSheet(sheet1, form, IBDOWNEXCEL);
                    break;
                case "btn_viewrfa":
                case "btn_viewamdhistory":
                    var currRow=sheet1.GetSelectRow();
                    if(currRow < 1) return;
                    var pgmNo="ESM_PRI_2003";
                    var sUrl = "ESM_PRI_2003.do?"
                    if(srcName == "btn_viewamdhistory") {
                        pgmNo="ESM_PRI_2041";
                        sUrl = "ESM_PRI_2041.do?"
                    }
                    var rfaNo = sheet1.GetCellValue(currRow, "rfa_no");
                    var popParams="parentPgmNo=ESM_PRI_M001&rfa_no_2043=" + rfaNo +"&pgmNo=" +pgmNo;
                    sUrl += popParams;
//                    comCallPop(pgmNo, "ESM_PRI_2043", popParams, "", "");
                    window.open(sUrl, "");
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

   function findCustomer(rtnVal) {
        //form.prc_cmdt_def_cd.value = rtnVal;
        form.ctrt_cust_cnt_cd.value=rtnVal.custCntCd;         
        form.ctrt_cust_seq.value=rtnVal.custSeq;                    
        form.ctrt_pty_nm.value=rtnVal.custNm;
   }
    
 /**
   * handling OnKeyPress events<br>
   * handling process for input validation by object's dataformat 
  */    
    function obj_keypress(){
        var srcName=ComGetEvent("name");
        if (event.keyCode == 13 && document.form.svc_scp_cd.value !=""){
	        switch(srcName) {
	        case "cust_seq":
	        case "ctrt_cust_seq":
	        	custNameFind();
	        }
        }
                
        if(event.srcElement.dataformat == null) return;
        window.defaultStatus=obj.dataformat;
        switch(obj.dataformat){
            case "ymd": 
                ComKeyOnlyNumber(obj,"-"); 
                break;
            case "int": 
            case "number":       
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
    * calling function when occurring Onclick Event <br>
   * handling process for input validation by object's dataformat 
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
    
    function obj_keyup() {
    	 var obj=ComGetEvent();	  	  
 	  	 var formObj=document.form;
 		 switch(ComGetEvent("name")) {
 		 	case 'rfa_no':
 		 	case 'prop_scp_srep_cd':
 		 		obj.value=obj.value.toUpperCase();
 		 		break;   
 	  	 	case 'svc_scp_cd':
 	  	 		var svcScpCdTxt=comboObjects[0].GetSelectText();
 	  			if (svcScpCdTxt.length > 3) {
 	  				document.form.svc_scp_nm.focus();
 	  			}
 	        	break;   
 	  	}             
    }
  
    /**
     * handling OnBeforeActivate event <br>
    */     
    function obj_activate() {
        ComClearSeparator (event.srcElement);
    }
	/** 
	 * Object's Onbeforedeactivate event handler <br>
	 * checking validation inputting data by object's dataformat <br>
	 */ 
    function obj_deactivate() {
        var formObj=event.srcElement;
        var srcName=formObj.getAttribute("name");
        switch(srcName) {
            case "rfa_no":
            case "prop_scp_ofc_cd":
            case "prop_scp_srep_cd":
                break;
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
            case "ctrt_cust_cnt_cd":
            case "ctrt_cust_seq":
                custNameFind();
                break;
        }
    }
    /**                                                                                            
     * svc_scp_cd_OnChange event handler when changing svc scope combo selection<br>                                                                             
     */  
    function svc_scp_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) { 
        var form=document.form;
        //var code = comboObj.FindIndex(comboObj.Code, 0);
        //if (code != null && code != "") {
        var text=comboObj.GetText(code, 1);
        form.svc_scp_nm.value=text;
        //}else{
        //form.svc_scp_nm.value = "";
        //}
    }
    /** 
     * searchSRep function when occuring S.Rep retrieve event <br>
     * 
     */
    function searchSRep() {
        return true;
        //doActionIBSheet2(sheet2, form, IBSEARCH_ASYNC01)
    }
    /** 
     * retrieving customer name function <br>
     * reference 2003 method <br>
     */
    function custNameFind(){
        var form=document.form;
        var ctrt_cust_cnt_cd=form.ctrt_cust_cnt_cd.value;  
        var ctrt_cust_seq=form.ctrt_cust_seq.value;
        if(ctrt_cust_cnt_cd != "" && ctrt_cust_seq !="") {
            var sParam="f_cmd=" + SEARCH02 + "&cust_cnt_cd=" + ctrt_cust_cnt_cd + "&cust_seq=" + ctrt_cust_seq;
            var sXml=sheet2.GetSearchData("ESM_PRI_2003GS.do", sParam);
            //var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_cust_val_sgm|respb_srep_cd|respb_sls_ofc_cd|ctrt_cust_srep_nm|prc_ctrt_cust_tp_nm|ctrt_cust_val_sgm_cd");
            var arrText=ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm");        
            if(arrText==undefined){
                form.ctrt_pty_nm.value="";
            }else{           
                form.ctrt_pty_nm.value=arrText[0][1];
            }
        }else{
            form.ctrt_pty_nm.value="";
        }
    }
    
    
    /**                                                                                            
     * prop_scp_srep_cd_OnChange event handler when S.Rep combo focus out <br>                                                                             
     */  
    function prop_scp_srep_cd_OnChange(actObj, code, text) {
        var form=document.form;
        //var code = actObj.Code;
        var text=actObj.GetText(code, 1);
        form.prop_scp_srep_nm.value=text;
    }
    /**
     * calling function when occurring OnSearchEnd Event after finishing retrieve sheet1<br>
     */ 
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
        var chkBCO;
        var countBCO=0;
        if (errMsg == "") {
            /*
    	if(sheet1.RowCount()> 0) {
    	    var startRow=sheet1.HeaderRows();
    		var endRow=sheet1.HeaderRows()+ sheet1.RowCount();
    		for(var i=startRow; i < endRow; i++) {
chkBCO=sheet1.GetCellValue(i, "prc_ctrt_cust_tp_nm");
    			if(chkBCO == "BCO"){countBCO++;}
    		}
    	}
//parameter changed[check again]CLT     	sheet1.SetSumValue(0, "prc_ctrt_cust_tp_nm",countBCO);
             */
        }
    }   
    /** 
     * setParamsClear event handler for initializing parameter sheet1 <br>
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
     * Handling sheet process<br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheet1.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: 
                var rdoDtObj=formObj.rdoDate;
                formObj.f_cmd.value=SEARCH;
                if(rdoDtObj[0].checked){
                    formObj.eff_dt.value=formObj.eff_date_from.value;
                    formObj.exp_dt.value=formObj.eff_date_to.value;
                }else{
                    var accDt=formObj.access_date.value;
                    formObj.eff_dt.value=accDt;
                    formObj.exp_dt.value=accDt;
                }
                ComOpenWait(true);		
                 sheet1.DoSearch("ESM_PRI_2043GS.do", FormQueryString(formObj) );
                ComOpenWait(false);		
                break;
            case IBCREATE: // New
                formObj.reset();
                //formObj.svc_scp_cd.SetSelectIndex("-1");
                svc_scp_cd.SetSelectIndex("", true);
                //formObj.prc_ctrt_cust_tp_cd.SetSelectIndex("-1");
                prc_ctrt_cust_tp_cd.SetSelectIndex("", true);
                formObj.rdoDate[0].click();
    	        sheetObjects[0].RemoveAll();
    	        sheetObjects[1].RemoveAll();
                break;
            case IBDOWNEXCEL:      //download excel
//                sheet1.SpeedDown2Excel(-1); //, "chk|seq"
            	 if(sheet1.RowCount() < 1){
            			ComShowCodeMessage("COM132501");
            		}else{
            			sheet1.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
            		}                 
                break;
        }
    }
    /**
     * Handling sheet process<br>
     */
    function doActionIBSheet2(sheetObj, formObj, sAction) {
        sheet2.ShowDebugMsg(false);
        sheet2.SetWaitImageVisible(0);
        switch(sAction) {
            case IBSEARCH_ASYNC01: //s rep
                formObj.etc1.value=formObj.prop_scp_ofc_cd.value;
                formObj.f_cmd.value=SEARCH15;
                 var sXml=sheet2.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                ComPriXml2ComboItem(sXml, formObj.prop_scp_srep_cd, "cd", "cd|nm");
                formObj.prop_scp_srep_cd.InsertItem(0, "", "");
                formObj.prop_scp_srep_nm.value="";
                break;
        }
    }
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj, formObj, sAction){
        var form=document.form;
        var scopeObj=svc_scp_cd;
        var rdoDateObj=form.rdoDate;
        var effDtFromObj=form.eff_date_from;
        var effDtToObj=form.eff_date_to;
        var accessDtObj=form.access_date;
        
        switch (sAction) {
            case IBSEARCH:            	
                if(null == scopeObj.GetSelectCode()|| "" == scopeObj.GetSelectCode()){
                    ComShowCodeMessage("PRI00337", "SVC Scope");
                    ComSetFocus(scopeObj);
                    return false;
                }
                if(rdoDateObj[0].checked) {
                    if(effDtFromObj.value == "") {
                        ComShowCodeMessage("PRI00335", "RFA Effective Date");
                        ComSetFocus(effDtFromObj);
                        return false;
                    }
                    if(effDtToObj.value == "") {
                        ComShowCodeMessage("PRI00335", "RFA Effective Date");
                        ComSetFocus(effDtToObj);
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
