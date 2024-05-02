/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292.js
*@FileTitle  : Some Title 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    // Common global variable
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    
    // sheet variables
    var t1st1 = 0;
    var t1st2 = 1;
    var t1st3 = 2;
    var t1st4 = 3;
    var t1st6 = 4;
    var t1st7 = 5;
    
    var t1BkgNo = "";
    var t2BkgNo = "";
    var t3BkgNo = "";
    var t4BkgNo = "";
    var t5BkgNo = "";

    var t1BlNo = "";
    var t2BlNo = "";
    var t3BlNo = "";
    var t4BlNo = "";
    var t5BlNo = "";
    var comboFlg = null;
    var cntrQtySum = 0;
    var frt_term_cd = null;
    
    var previewSheet = 1;
    var isInit = true;
    
    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    /**
     * Event handler processing by button name<br>
     * @param {void}
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function processButtonClick(){
        var param=null;
        var sc_no=null;
        var cntr_no=null;
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(!ComIsBtnEnable(srcName)) return;
            switch(srcName) {
                case "btn_Retrieve":
                	if (formObject.cntr_no.value != '' && combo_bl_no.GetSelectText() == '' && formObject.bkg_no.value == '' && formObject.po_no.value == '') {
                		fnSelectCntrPoQuery("cntr_no");
                	} else if (formObject.po_no.value != '' && combo_bl_no.GetSelectText() == '' && formObject.bkg_no.value == '' && formObject.cntr_no.value == '') {
                		fnSelectCntrPoQuery("po_no");
                	}
                	else {
	                	if (formObject.h_old_bl_no.value != combo_bl_no.GetSelectText() ||
	                		formObject.h_old_bkg_no.value != formObject.bkg_no.value) {
	                		// Change search criteria -> All data Clear
	                		fnBlInfoClear();
	                		fnSearch();		
	                	} else {
	                		fnSearch();			
	                	}
                	}
                    break;
                case "btn_New":
                	fnQueryCondClear();
                    break;
                case "btn_History":
                	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(document.form.bkg_no.value)){
                        ComShowCodeMessage('BKG40031', combo_bl_no.GetSelectText());
                        //combo_bl_no.focus();
                        return false;
                    }
                	var bkg_no=document.form.bkg_no.value;
                	var param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_0566";                	
                    ComOpenWindowCenter("ESM_BKG_0566.do" + param, "BKG History", 900, 700, false);
                	
                    break;
                case "btn_BLPreview":
                	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(document.form.bkg_no.value)){
                        ComShowCodeMessage('BKG40031', combo_bl_no.GetSelectText());
                        //combo_bl_no.focus();
                        return false;
                    }
                	var bkg_no=document.form.bkg_no.value;
                	var blNo=combo_bl_no.GetSelectText();
        	        var blType="";
        			var param='bkg_no=' + bkg_no + '&pgmNo=ESM_BKG_0927' + '&bl_tp_cd=D&form_level=6';
        			var url="ESM_BKG_0927.do?" + param;
        			ComOpenWindowCenter("ESM_BKG_0927_POP.do?" + param, "BL Preview", 900, 700, false);
        			break;                	
                case "btn_BkgMain":
                	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(document.form.bkg_no.value)){
                        ComShowCodeMessage('BKG40031', combo_bl_no.GetSelectText());
                        //combo_bl_no.focus();
                        return false;
                    }
                	var bkgNo=document.form.bkg_no.value;
		        	var sUrl="/opuscntr/opusMain.screen";
		        	sUrl += "?parentPgmNo=ESM_BKG_M001";
		        	sUrl += "&pgmUrl=^opuscntr^ESM_BKG_0079.do";
		        	sUrl += "&pgmNo=ESM_BKG_0079";
		        	sUrl += "&bkg_no="+bkgNo;
		        	comBkgCallPopBkgDetail(bkgNo);
                    break;
                case "btn_charge":
                	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(document.form.bkg_no.value)){
                        ComShowCodeMessage('BKG40031', combo_bl_no.GetSelectText());
                        //combo_bl_no.focus();
                        return false;
                    }
                	var bkgNo=document.form.bkg_no.value;
		        	var sUrl = "?parentPgmNo=ESM_BKG_M001";
		        	sUrl += "&pgmUrl=^opuscntr^ESM_BKG_0079.do";
		        	sUrl += "&pgmNo=ESM_BKG_0079&openTab=B9";
		        	sUrl += "&bkg_no="+bkgNo;
		        	//comBkgCallPopBkgCharge(bkgNo);
		        	//var sUrl="ESM_BKG_0079_POP.do?openTab=B9&bkg_no="+bkgNo;
		        	ComOpenWindowCenter("ESM_BKG_0079_POP.do" + sUrl, "Charge", 1250, 850,false);
                	break;
                case "btn_ts_route":
                    if (sheetObjects[t1st1].RowCount()== 0) return;
                    if (document.form.bkg_no.value.length == 0) retuen;
                    var bkg_no=sheetObjects[t1st1].GetCellValue(1, "t1sheet1_bkg_no");
                    param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_0650";
                    ComOpenWindowCenter("ESM_BKG_0650.do" + param, "TS Route", 710, 320, true);
                    break;
                case "btn_corr_flg":
                    if (sheetObjects[t1st1].RowCount()== 0) return;
                    if (document.form.frm_t1sheet1_corr_flg.checked == true) {
                    	var bkg_no=sheetObjects[t1st1].GetCellValue(1, "t1sheet1_bkg_no");
                        param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_0651";
                        ComOpenWindowCenter("ESM_BKG_0651.do" + param, "Corr Info", 700, 400, true);
                    }
                    break;
                case "btn_contract_no":
                    if (sheetObjects[t1st1].RowCount()== 0) return;
                    if (sheetObjects[t1st1].GetCellValue(1,"t1sheet1_rfa_no").length > 0) {
                        //  RFA_NO  If the value exists RFA Screen call
                    	var rfaNo=sheetObjects[t1st1].GetCellValue(1, "t1sheet1_rfa_no");
                        var pgmNo="ESM_PRI_2019";
                        var params="?s_rfa_no=" + rfaNo+"&pgmNo=" + pgmNo;
                        var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
                        ComOpenWindowCenter("ESM_PRI_2019_POP.do" + params, "Contract Info", 1024, 700, false,"yes");
                    } else {
                    	if (sheetObjects[t1st1].GetCellValue(1,"t1sheet1_sc_no").length > 0) {
                            // SC Screen call
                    		var scRfaNo=sheetObjects[t1st1].GetCellValue(1, "t1sheet1_sc_no");
                            var pgmNo="ESM_PRI_0004";
                            var scRfaNoP=scRfaNo.substr(0, 3);
                            var scRfaNoS=scRfaNo.substr(3);
                            var params="?sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS+ "&pgmNo=" + pgmNo;
                            var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
                            ComOpenWindowCenter("ESM_PRI_0004_POP.do" + params, "Contract Info", 1024, 700, false,"yes");
                            
                        }                  
                    }
                    break;
                case "btn_consignee":
                    if (sheetObjects[t1st1].RowCount()== 0) return;
                    //activate  button:  exists Consignee value 
                    if (sheetObjects[t1st1].GetCellValue(1,"t1sheet1_csg_cust_nm").length > 0) {
                    	var bkg_no=sheetObjects[t1st1].GetCellValue(1, "t1sheet1_bkg_no");
                        param="?bkg_no="+bkg_no+"&tab_idx=0"+ "&pgmNo=ESM_BKG_0242";
                        ComOpenWindowCenter("ESM_BKG_0242_POP.do" + param, "Consignee Info", 530, 400, true);
                    }
                    break;
                case "btn_notify":
                    if (sheetObjects[t1st1].RowCount()== 0) return;
                    //activate  button:  exists Notify value  
                    if (sheetObjects[t1st1].GetCellValue(1,"t1sheet1_noy_cust_nm").length > 0) {
                    	var bkg_no=sheetObjects[t1st1].GetCellValue(1, "t1sheet1_bkg_no");
                        param="?bkg_no="+bkg_no+"&tab_idx=1"+ "&pgmNo=ESM_BKG_0242";
                        ComOpenWindowCenter("ESM_BKG_0242_POP.do" + param, "Notify Info", 530, 400, true);
                    }
                    break;
                case "btn_a_notify":
                    if (sheetObjects[t1st1].RowCount()== 0) return;
                    //activate  button: exists Notify value  
                    if (sheetObjects[t1st1].GetCellValue(1,"t1sheet1_aoy_cust_nm").length > 0) {
                    	var bkg_no=sheetObjects[t1st1].GetCellValue(1, "t1sheet1_bkg_no");
                        param="?bkg_no="+bkg_no+"&tab_idx=2"+ "&pgmNo=ESM_BKG_0242";
                        ComOpenWindowCenter("ESM_BKG_0242_POP.do" + param, "Consignee Info", 530, 400, true);
                    }
                    break;
                case "btn_split":
                	if (document.form.h_split.value != "#ff0000") return;
                    document.form.xmlData.value=null;
                    sheetObjects[sheetObjects.length-1].RemoveAll();
                    doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND04);
                	break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
     /**
      * registering IBSheet Object as list<br>
      * @param sheet_obj IBSheet Object
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function setSheetObject(sheet_obj){
    	  sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
      * initializing sheet<br>
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      * @param {void}
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function loadPage() {
        //Tab Initialization 
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        //IBMultiCombo initialization
        for(var j=0;j<comboObjects.length;j++){
            initCombo(comboObjects[j]);
        }
        initControl();
        isInit = false;
        for(i=0;i<sheetObjects.length;i++){
        	if (sheetObjects[i].id == "t1sheet2" || sheetObjects[i].id == "t1sheet3") {
        		ComConfigSheet (sheetObjects[i] );
	            initSheet(sheetObjects[i],i+1);
	            ComEndConfigSheet(sheetObjects[i]);
        	} else {
        		initSheet(sheetObjects[i],i+1);
        	}
        }
        
        //@ Test Code Start ----------
//        	document.form.cntr_no.value = "NYKU5000002";
		
		//@ Test Code End   ----------
        	
        if (document.form.bkg_no.value != "") {
        	fnSearch();
        }
        
        resizeIfSheet();
    }
    /**
     * registering IBCombo Object as list<br>
     * @param {void}
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
    * Initialize Multi-Combo<br>
    * @param comboObj Multi-Combo Object
    * @return void
    * @author
    * @version 2009.11.01
    **/
    function initCombo(comboObj) {
        comboObj.RemoveAll();
        comboObj.SetUseEdit(1);
        comboObj.SetImeMode(0);			 
        comboObj.SetMaxLength(13);
        comboObj.ValidChar("2","1");
    }
    /**
    * Initialization of the event handling of the screen and buttons  declare.<br>
    * @param (void)
    * @return void
    * @author
    * @version 2009.11.01
    **/
    function initControl() {
    	var formObject=document.form;
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', formObject);
    	axon_event.addListenerFormat('keypress',  'obj_keypress',    form); //- 키보드 입력할때
        fnButtonInit();
        
    }
     /**
      * setting sheet initial values and header<br>
      * @param sheetObj IBSheet Object
      * @param sheetNo  The order of IBSheet
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var prefix="";
        var sheetID=sheetObj.id;
        switch(sheetID) {        
        	case "t1sheet1":
        	    with(sheetObj){
		              var HeadTitle="ibflag|arrival_vvd|arrival_vvd_nm|partial|vps_eta_dt|vps_etb_dt|slan_cd|rcv_term_cd|de_term_cd|por_cd|" +
		              "        pol_cd|pod_cd|pod_nm|del_cd|del_nm|bkg_sts_cd|bdr_flg|corr_usr_id|pck_qty|pck_tp_cd|" +
		              "        act_wgt|wgt_ut_cd|sc_no|rfa_no|cstms_desc|obl_rdem_flg|obl_rdem_dt|obl_rdem_ofc_cd|shp_cust_cd|shp_cust_nm|" +
		              "        csg_cust_cd|csg_cust_nm|noy_cust_cd|noy_cust_nm|aoy_cust_cd|aoy_cust_nm|bl_no|bkg_no|split_no|bkg_cre_dt|" +
		              "        bkg_ofc_cd|bl_tp_cd|tot_ots_sts_cd|tot_ots_curr_cd1|tot_ots_curr_cd2|tot_ots_curr_cd3|tot_ots_curr_cd4|tot_ots_curr_cd5|tot_ots_amt1|tot_ots_amt2|tot_ots_amt3|" +
		              "        tot_ots_amt4|tot_ots_amt5|ppt_sts_cd|ppt_rcv_ofc_cd|ppt_rcv_usr_id|ppt_rcv_dt|cct_sts_cd|cct_rcv_ofc_cd|cct_rcv_usr_id|cct_rcv_dt|" +
		              "        cct_ots_curr_cd1|cct_ots_curr_cd2|cct_ots_curr_cd3|cct_ots_curr_cd4|cct_ots_curr_cd5|cct_ots_amt1|cct_ots_amt2|cct_ots_amt3|cct_ots_amt4|cct_ots_amt5|" +
		              "        n3pty_ppt_sts_cd|n3pty_ppt_rcv_ofc_cd|n3pty_ppt_rcv_usr_id|n3pty_ppt_rcv_dt|n3pty_cct_sts_cd|n3pty_cct_rcv_ofc_cd|n3pty_cct_rcv_usr_id|n3pty_cct_rcv_dt|n3pty_cct_ots_curr_cd1|n3pty_cct_ots_curr_cd2|" +
		              "        n3pty_cct_ots_curr_cd3|n3pty_cct_ots_curr_cd4|n3pty_cct_ots_curr_cd5|n3pty_cct_ots_amt1|n3pty_cct_ots_amt2|n3pty_cct_ots_amt3|n3pty_cct_ots_amt4|n3pty_cct_ots_amt5|" +
		              "        pod_yd_cd|del_yd_cd";
		              prefix="t1sheet1_";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vvd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"partial",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_etb_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rcv_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"por_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"corr_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_qty",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"act_wgt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sc_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rfa_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shp_cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shp_cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"csg_cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"csg_cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"noy_cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"noy_cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"aoy_cust_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"aoy_cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetCountPosition(0);
		              SetVisible(0);
        		}
	            break;
            case "t1sheet2":      //t1sheet2 init
                with(sheetObj){
					var HeadTitle="|TP/SZ|BKG Q'ty|CNTR Q'ty";
					prefix="t1sheet2_";					
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );					
					var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					
					InitColumns(cols);
					
					SetEditable(1);
					SetCountPosition(0);
					SetSheetHeight(100,1);
				}
                break;
            case "t1sheet3":      //t1sheet3 init
                with(sheetObj){
					  var HeadTitle="|Seq.|Container No.|F/M|TS|ESTIMATE\nFree Time|SAT\nExcl.|SUN\nExcl.|HOLI\nExcl.|ESTIMATE\nPOD LFD|Daily\nDemurrage|Fixed\nFreeTime|Fixed\nPOD LFD|Outstanding\nDemurrage|Bil Amt|Paid Amt|Seal No.|Package|Package|Weight|Weight|Measure|Measure|R/Term|D/Term|AS|ST|DG|BB|AK|RF(ºC)|RD|SOC";
					  prefix="t1sheet3_";
					
					  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
					
					  var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
					  var headers = [ { Text:HeadTitle, Align:"Center"} ];
					  InitHeaders(headers, info);
					
					  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
								 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
								 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fm_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sat_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
								 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sun_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
								 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_hol_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
								 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys_calc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Int",       Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"out_amt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bil_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"paid_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Combo",     Hidden:0, Width:170,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_seal_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"pck_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"cntr_wgt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"meas_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rcv_term_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"adv_shtg_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cnmv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		    		             {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dcgo_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bb_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"in_ga_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    		             {Type:"Popup",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cdo_temp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rd_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"soc_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
					   				  
	    		         InitColumns(cols);
	    		 		
	    		         SetEditable(1);
	    		         SetImageList(0,"/img/btns_search.gif");
	    		         SetImageList(1,"/img/btns_search_off.gif");
	    		         SetCountPosition(0);
	    		         SetShowButtonImage(1);
		                 SetSheetHeight(200);//102					  
    	      }


                break;
            case "t1sheet4":      //Demurrage data retrieve
            /****************************************************************
            //Container Demurrage
            *****************************************************************/
                with(sheetObj){
		              var HeadTitle=" |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";
		              var prefix="t1sheet4_";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_inv_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_ar_if_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"to_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bil_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
		              SetCountPosition(0);
		              SetVisible(0);
                }
		        break;
            case "t1sheet7":
                with(sheetObj){
		              var HeadTitle1="|curr_cd|tot_bil_amt";
		              prefix="t1sheet7_";
		
		              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_bil_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetCountPosition(0);
		              SetVisible(0);
                }
            	break;
            case "sheet1":
                with(sheetObj){
		              var HeadTitle1="|Seq.||B/L No.|CNEE Name|Bkg No.|B/L Type|SPLIT FLG";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              prefix="sheet1_";
		
		              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
		                     {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"radio",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cstms_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetCountPosition(0);
		              SetVisible(0);
                }
            	break;
            case "sheet2":
                with(sheetObj){
		              var HeadTitle="ibflag|partial|bl_no|bkg_no|split_no|bl_tp_cd";
		              prefix="sheet2_";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"partial",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetCountPosition(0);
		              SetVisible(0);
                    }


            	break;
            case "t1sheet6":
                with(sheetObj){
		              var HeadTitle1="|Container No.|Seal No.";
		              prefix="t1sheet6_";
		
		              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_seal_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetCountPosition(0);
		              SetVisible(0);
                }


            	break;
        }
    }
    /**
     * Sheet handling process<br>
     * @param sheetObj IBSheet Object
     * @param formObj  UI  Object
     * @param sAction  IBSEARCH - Retrieve, COMMAND01, COMMAND02, COMMAND04
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //Retrieve
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                document.form.xmlData.value=null;
                if (!ComIsEmpty(combo_bl_no.GetSelectText())) {
                    formObj.bl_no.value=ComTrim(combo_bl_no.GetSelectText());                    
                }
                ComOpenWait(true);
                
                setTimeout( function () { //@ setTimeout ###########################################################
		                	
		                var temp_bl=combo_bl_no.GetSelectText();
		                var temp_bkg=formObj.bkg_no.value;
		            	formObj.bkg_no.value=temp_bkg;
		            	//BL_TP_CD -> W Or S ->Remove BL_TP_CD
		                if(formObj.bl_no.value !=''){
		                    var blNo=formObj.bl_no.value;
		                    var suffix=blNo.substring(formObj.bl_no.value.length-1)
		                    if(suffix =='W' || suffix =='S'){
		                        formObj.bl_no.value=blNo.substring(0, blNo.lastIndexOf(suffix));
		                    }
		                }
		                if ( sheetObj.id == "t1sheet1"){
		                    formObj.f_cmd.value=SEARCH;
		                    var aryPrefix=new Array("t1sheet1_", "t1sheet2_", "t1sheet3_", "t1sheet4_", "t1sheet6_", "t1sheet7_"); //prefix string array
		                     var sXml=sheetObj.GetSearchData("ESM_BKG_0292GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		                    var arrXml=sXml.split("|$$|");
		                    for(var idx=0; idx < arrXml.length; idx++){
		                        sheetObjects[idx].LoadSearchData(arrXml[idx]);
		                    }
		                    var cust_ref_no=ComGetEtcData(arrXml[0], "customsRefNo");
		                    frt_term_cd=ComGetEtcData(arrXml[0], "frtTermCd");
		                    if (ComIsNull(cust_ref_no) == false) {
		                        var arrCust=cust_ref_no.split(";");
		                        if (arrCust.length == 1) {  //Max 2
		                            document.form.frm_t1sheet1_cust_ref_no.value=arrCust[0];
		                            document.form.frm_t1sheet1_cust_ref_nm.value="";
		                        } else if (arrCust.length == 2) {
		                            document.form.frm_t1sheet1_cust_ref_no.value=arrCust[0];
		                            document.form.frm_t1sheet1_cust_ref_nm.value=arrCust[1];
		                        } else {
		                            document.form.frm_t1sheet1_cust_ref_no.value="";
		                            document.form.frm_t1sheet1_cust_ref_nm.value="";
		                        }
		                    }
		                } else if ( sheetObj.id == "sheet2"){
		                	formObj.f_cmd.value=SEARCH03;
		                    var aryPrefix=new Array("sheet2_"); //prefix string array
		                     var sXml=sheetObj.GetSearchData("ESM_BKG_0292GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		                    var arrXml=sXml.split("|$$|");
		                    sheetObjects[sheetObjects.length-2].LoadSearchData(arrXml[0]);
		                }
		                ComOpenWait(false);
                } , 100);//@ setTimeout end ###########################################################
                break;
            case COMMAND01:
                formObj.f_cmd.value=SEARCH01;
                document.form.xmlData.value=null;
                 sheetObj.DoSearch("ESM_BKG_0292GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
                break;
            case COMMAND02:
                formObj.f_cmd.value=SEARCH02;
                document.form.xmlData.value=null;
                 sheetObj.DoSearch("ESM_BKG_0292GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
                break;
            case COMMAND04:
                formObj.f_cmd.value=SEARCH04;
                document.form.xmlData.value=null;
                 sheetObj.DoSearch("ESM_BKG_0292GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
                break;
        }
    }
    /**
     * Register as array  to IBTab Object<br>
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     * @param tab_obj  Tab Object
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * initializing Tab<br>
     * setting Tab items
     * @param tab_obj  Tab Object
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    InsertItem( "B/L Info.");
					InsertItem( "Movement");
					InsertItem( "Cargo Release");
					InsertItem( "A/N Sent");
					InsertItem( "S/O Info.");
					SetSelectedIndex(0);
                } 
            break;
        }
    }
     /**
      * Event when clicking Tab<br>
      * activating selected tab items
      * @param tab_obj  Tab Object
      * @param nItem	Tab order
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
        objs[nItem].style.display="Inline";
        objs[beforetab].style.display="none";
        objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
        beforetab=nItem;
        if (beforetab == 0) {
        	if (document.form.mainPage.value != "") {
        		fnTabChangeQuery();	//Change search conditions when changing tab. Automatically calls the lookup module 
    		} else {
    			document.form.mainPage.value="Y";
    		}        	
        } else {
        	loadTabPage(beforetab);
        }       
        resizeIfSheet();
    }
     /**
      * handling process for input validation
      * @param sheetObj IBSheet Object
      * @param formObj  UI Object
      * @param sAction  IBSEARCH - Retrieve
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {            
        case IBSEARCH:
            conditionTrim();
        	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(formObj.bkg_no.value)){
                ComShowCodeMessage('BKG40097');
                //combo_bl_no.focus();
                return false;
            }
            if(!ComChkObjValid(formObj.bkg_no)) {
                return false;
            }        	
            return true;
            break;
        }
        return true;
    }
     /**
      * t1Upon completion of sheet1 to set the value to lookup.
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg  Error Messages
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
    	var prefix="t1sheet1_";
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                //Copy to Grid Data Html argument values ​​
                IBS_CopyRowToForm(sheetObj, document.form, 1, "frm_");
                document.form.btn_ts_route.style.cursor='hand';
                if (sheetObj.GetCellValue(1,"t1sheet1_bdr_flg") == "Y") {
                    document.form.frm_t1sheet1_bdr_flg.checked=true;
                } else {
                    document.form.frm_t1sheet1_bdr_flg.checked=false;
                }
                //activate popup button: exists C/A value
                if (sheetObj.GetCellValue(1,"t1sheet1_corr_usr_id") != "Y") {
					ComEnableObject(document.form.btn_corr_flg, false);
                    document.form.frm_t1sheet1_corr_flg.checked=false;
                } else {
                    document.form.frm_t1sheet1_corr_flg.checked=true;
					ComEnableObject(document.form.btn_corr_flg, true);
                }
                //Partial Value -> Font Color setting
                if (sheetObj.GetCellValue(1,"t1sheet1_partial") == "Y") {                      //Partial-> Y :Red
                	formObj.frm_t1sheet1_partial.style.color="#ff0000";
                } else {                                                                    //Partial<> Y :Black
                	formObj.frm_t1sheet1_partial.style.color="";
                }
                var blNo=null;
                if (sheetObj.GetCellValue(1,"t1sheet1_bl_tp_cd") != "B") {
                	blNo=sheetObj.GetCellValue(1,"t1sheet1_bl_no") + sheetObj.GetCellValue(1,"t1sheet1_bl_tp_cd");
                } else {
                	blNo=sheetObj.GetCellValue(1,"t1sheet1_bl_no");
                }
                if (combo_bl_no.GetItemCount() == 0) {
                	combo_bl_no.InsertItem(-1, blNo, sheetObj.GetCellValue(1,"t1sheet1_bkg_no"));
                    combo_bl_no.SetSelectIndex(0);
                } else {
                     var itemindex=combo_bl_no.FindItem( blNo, 0, true);
                    if (itemindex == -1) {
                        combo_bl_no.RemoveAll();
                        combo_bl_no.InsertItem(-1, blNo, sheetObj.GetCellValue(1,"t1sheet1_bkg_no"));
                        combo_bl_no.SetSelectIndex(0);
                    } else {
                		combo_bl_no.SetSelectCode(itemindex);
                    }
                }
                if (combo_bl_no.GetItemCount() > 1) {
                    combo_bl_no.SetBackColor("#ffff00");
                } else {
                    combo_bl_no.SetBackColor("#ffffff");
                }                    
                document.form.bkg_no.value=sheetObj.GetCellValue(1,"t1sheet1_bkg_no");
                if (sheetObj.GetCellValue(1,"t1sheet1_split_flg") == "Y") {
                	buttonColorSet("btn_split", "#ff0000");
                } else {
                    buttonColorSet("btn_split", "gray");
                }
                //T / S Route button to activate 
                ComEnableObject(document.form.btn_ts_route, true);
                //activate button: exists Contract_No value 
                if (sheetObj.GetCellValue(1,"t1sheet1_rfa_no").length > 0) {
                	ComEnableObject(document.form.btn_contract_no, true);
                    document.form.frm_t1sheet1_sc_no.value=sheetObj.GetCellValue(1,"t1sheet1_rfa_no");
                } else {
                	if (sheetObj.GetCellValue(1,"t1sheet1_sc_no").length > 0) {
                    	ComEnableObject(document.form.btn_contract_no, true);
                        document.form.frm_t1sheet1_sc_no.value=sheetObj.GetCellValue(1,"t1sheet1_sc_no");
                	} else {
                    	ComEnableObject(document.form.btn_contract_no, false);
	                    document.form.frm_t1sheet1_sc_no.value="";
                	}
                }
                //activate button: exists Consignee value 
                if (sheetObj.GetCellValue(1,"t1sheet1_csg_cust_nm").length == 0) {
                	ComEnableObject(document.form.btn_consignee, false);
                } else {
                	ComEnableObject(document.form.btn_consignee, true);
                }
                //activate button: exists Notify value 
                if (sheetObj.GetCellValue(1,"t1sheet1_noy_cust_nm").length == 0) {
                	ComEnableObject(document.form.btn_notify, false);
                } else {
                	ComEnableObject(document.form.btn_notify, true);
                }
                //A.activate button: exists Notify value
                if (sheetObj.GetCellValue(1,"t1sheet1_aoy_cust_nm").length == 0) {
                	ComEnableObject(document.form.btn_a_notify, false);
                } else {
                	ComEnableObject(document.form.btn_a_notify, true);
                }
                if (sheetObj.GetCellValue(1,"t1sheet1_noy_cust_cd") == "0") {
                	document.form.frm_t1sheet1_noy_cust_cd.value="";
                }
                if (sheetObj.GetCellValue(1,"t1sheet1_aoy_cust_cd") == "0") {
                	document.form.frm_t1sheet1_aoy_cust_cd.value="";
                }
                if (sheetObj.GetCellValue(1,"t1sheet1_act_wgt") != "0") {
                	document.form.frm_t1sheet1_act_wgt.value=ComAddComma2(sheetObj.GetCellValue(1,"t1sheet1_act_wgt"), "#,###.00");
                }
                document.form.frm_t1sheet1_pod_nm.title=sheetObj.GetCellValue(1,"t1sheet1_pod_nm");
                document.form.frm_t1sheet1_del_cd.title=sheetObj.GetCellValue(1,"t1sheet1_del_cd");
                document.form.frm_t1sheet1_del_nm.title=sheetObj.GetCellValue(1,"t1sheet1_del_nm");
                document.form.frm_t1sheet1_pck_qty.title=sheetObj.GetCellValue(1,"t1sheet1_pck_qty");
				document.form.frm_t1sheet1_act_wgt.title=sheetObj.GetCellValue(1,"t1sheet1_act_wgt");
				document.form.frm_t1sheet1_cstms_desc.title=sheetObj.GetCellValue(1,"t1sheet1_cstms_desc");
				document.form.frm_t1sheet1_shp_cust_nm.title=sheetObj.GetCellValue(1,"t1sheet1_shp_cust_nm");
				document.form.frm_t1sheet1_csg_cust_nm.title=sheetObj.GetCellValue(1,"t1sheet1_csg_cust_nm");
				document.form.frm_t1sheet1_noy_cust_nm.title=sheetObj.GetCellValue(1,"t1sheet1_noy_cust_nm");
				document.form.frm_t1sheet1_aoy_cust_nm.title=sheetObj.GetCellValue(1,"t1sheet1_aoy_cust_nm");
				tot_ots_sts_cd=sheetObj.GetCellValue(1, prefix + "tot_ots_sts_cd");
                document.form.frm_t1sheet1_frt_flg.value=tot_ots_sts_cd;
				document.form.frm_t1sheet1_frt_dt.value=sheetObj.GetCellValue(1, prefix + "cct_rcv_dt").substring(0, 16);
				document.form.frm_t1sheet1_frt_ofc_cd.value=sheetObj.GetCellValue(1, prefix + "cct_rcv_ofc_cd");
                addSel(sheetObj);
                // search Conditions BL_No and BKG_No save in hidden fields.
                fnSetHiddenKey();
            } else {
                for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
                    if (document.form.getElementsByTagName("input")[i].name != "bl_no"   &&
                        document.form.getElementsByTagName("input")[i].name != "cntr_no" &&
                        document.form.getElementsByTagName("input")[i].name != "po_no" &&
                        document.form.getElementsByTagName("input")[i].name != "bkg_no") {
                        document.form.getElementsByTagName("input")[i].value="";      
                    }
                }
                ComShowCodeMessage('BKG00095');   
            }
        } else {
        	fnBlInfoClear();
        }
    }
    /**
     * value setting after  retrieve t1sheet2
     * @param Object sheetObj IBSheet Object
     * @param Object ErrMsg  Error Messages
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function t1sheet2_OnSearchEnd(sheetObj, ErrMsg){
        cntrQtySum=0;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                for(var i=1; i<=sheetObj.RowCount(); i++) {
                    // Bkg Qty  != Cntr Qty : Set in bold red letters.
                	if (sheetObj.GetCellValue(i,"t1sheet2_bkg_qty") != sheetObj.GetCellValue(i,"t1sheet2_cntr_qty")) {
                         sheetObj.SetRangeFontBold(i,"t1sheet2_bkg_qty", i, "t1sheet2_cntr_qty",1);//Bold setting
                         sheetObj.SetCellFontColor(i, "t1sheet2_bkg_qty" ,"#FF0000");//Red setting
                         sheetObj.SetCellFontColor(i, "t1sheet2_cntr_qty" ,"#FF0000");//Red setting
                    }
                    //Bkg Qty and Cntr Qty decimal fractions -> Set in bold green letters. 102, 204, 0
                	if (isFloat(sheetObj.GetCellValue(i,"t1sheet2_bkg_qty")) == true) {
                         sheetObj.SetRangeFontBold(i,"t1sheet2_bkg_qty", i, "t1sheet2_cntr_qty",1);//Bold setting
                         sheetObj.SetCellFontColor(i, "t1sheet2_bkg_qty" ,"#66CC00");//Green setting
                         sheetObj.SetCellFontColor(i, "t1sheet2_cntr_qty" ,"#66CC00");//Green setting
                	} else if (isFloat(sheetObj.GetCellValue(i,"t1sheet2_cntr_qty")) == true) {
                         sheetObj.SetRangeFontBold(i,"t1sheet2_bkg_qty", i, "t1sheet2_cntr_qty",1);//Bold setting
                         sheetObj.SetCellFontColor(i, "t1sheet2_bkg_qty" ,"#66CC00");//Green setting
                         sheetObj.SetCellFontColor(i, "t1sheet2_cntr_qty" ,"#66CC00");//Green setting
                    } else {
                    	cntrQtySum=parseInt(cntrQtySum) + parseInt(sheetObj.GetCellValue(i,"t1sheet2_cntr_qty"));
                    }
                }
            }
        }
    }
    /**
     * value setting after  retrieve t1sheet3
     * @param Object sheetObj IBSheet Object
     * @param Object ErrMsg  Error Messages
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function t1sheet3_OnSearchEnd(sheetObj, ErrMsg){
        var invTotBilAmt=0;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                if (cntrQtySum > 0 && isFloat(cntrQtySum) == false) {               //If the value is an integer of Container
                    if (cntrQtySum != sheetObj.RowCount()) {      //Container Value != t1sheet3.RowCount()Value=> Set in bold blue letters t1sheet2 value.
                        for(var i=1; i<=sheetObjects[t1st2].RowCount(); i++) {
                             sheetObjects[t1st2].SetRangeFontBold(i,"t1sheet2_bkg_qty", i, "t1sheet2_cntr_qty",1);//Bold setting
                             sheetObjects[t1st2].SetCellFontColor(i, "t1sheet2_bkg_qty" ,"#0000FF");//blue setting
                             sheetObjects[t1st2].SetCellFontColor(i, "t1sheet2_cntr_qty" ,"#0000FF");//blue setting
                        }
                    }
                }
                for(var j=1; j<=sheetObj.RowCount(); j++) {
//                	if (parseFloat(ComReplaceStr(sheetObj.GetCellValue(j,"t1sheet3_cntr_wgt"), ",","")) > 25000) {
//                		sheetObj.SetCellFontBold(j,"t1sheet3_cntr_wgt",1);//Bold setting
//                		sheetObj.SetCellFontColor(j, "t1sheet3_cntr_wgt" ,"#FF0000");//red setting
//                    }
                	invTotBilAmt += parseInt(sheetObjects[t1st3].GetCellValue(j, "t1sheet3_paid_amt"));
                	/*
					if (sheetObj.GetCellValue(j, "t1sheet3_dcgo_flg") == "Y") {
						sheetObj.PopupButtonImage(j, "t1sheet3_dcgo_flg",0);
                    } else {
                    	sheetObj.PopupButtonImage(j, "t1sheet3_dcgo_flg",1);
                    }
					if (sheetObj.GetCellValue(j, "t1sheet3_bb_cgo_flg") == "Y") {
						sheetObj.PopupButtonImage(j, "t1sheet3_bb_cgo_flg",0);
                    } else {
                    	sheetObj.PopupButtonImage(j, "t1sheet3_bb_cgo_flg",1);
                    }
					if (sheetObj.GetCellValue(j, "t1sheet3_in_ga_flg") == "OUT") {
						sheetObj.PopupButtonImage(j, "t1sheet3_in_ga_flg",0);
                    } else {
                    	sheetObj.PopupButtonImage(j, "t1sheet3_in_ga_flg",1);
                    }
					if (sheetObj.GetCellValue(j, "t1sheet3_cdo_temp") == "N") {
						sheetObj.PopupButtonImage(j, "t1sheet3_cdo_temp",0);
                    } else {
                    	sheetObj.PopupButtonImage(j, "t1sheet3_cdo_temp",1);
                    }
                    */
                }
                document.form.invTotBilAmt.value=invTotBilAmt;
            }
        }           
    }
    //Axon event handling. 2. Event-handling functions--- start
    /**
     * HTML Control onkeypress event Keyboard input and control.
     * @param void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function obj_keypress(){
    	var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var srcName=ComGetEvent("name");
        // Enter key(13)
        if (keyCode == 13 && (srcName == 'combo_bl_no' || srcName == 'bkg_no' || srcName == 'cntr_no' || srcName == 'po_no')) {
        	enterKeySearch();
        } // end if
    }
    /**
    * Cntr_No or Po_No input: B / L_No retrieve
    * @param void
    * @return void
    * @author
    * @version 2009.11.01
    **/
    function fnCntrPoQuery(){
        switch(ComGetEvent("name")){
        case "cntr_no":
            if(ComIsEmpty(document.form.cntr_no.value)){
                document.form.h_cntr_no.value="";
                return false;
            }
			if (!(document.form.cntr_no.value.length == 10 || document.form.cntr_no.value.length == 11)) {
	    		ComShowCodeMessage('BKG00700');
	    		return false;
	    	}
                document.form.xmlData.value=null;
                sheetObjects[sheetObjects.length-1].RemoveAll();
                conditionReset();
                doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND01);
                document.form.h_cntr_no.value=document.form.cntr_no.value;
            break;
        case "po_no":               
            if(ComIsEmpty(document.form.po_no.value)){
                document.form.h_po_no.value="";
                return false;
            }
                document.form.xmlData.value=null;
                sheetObjects[sheetObjects.length-1].RemoveAll();
                conditionReset();
                doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND02);
                document.form.h_po_no.value=document.form.po_no.value;
            break;
        }
    }
     /**
      * By receiving information from ERP set Select Box
      * @param Object sheetObj IBSheet Object
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function addSel(sheetObj) {
        var sel=document.form.tot_ots_amt;
        var formObj = document.form;
        var prefix="t1sheet1_";
        for (i=sel.length-1; i>=0; i--){
            sel.options[i]=null
        }
        if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd") == 'N' || sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd") == 'Y' || sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd") == 'C'){
	        var unit="";
	        var amount="";
	        var colorFlg="";
	        for (j=0; j<5; j++){
	        	unit=sheetObj.GetCellValue(1, "t1sheet1_"+"tot_ots_curr_cd"+parseInt(j+1));
	        	amount=sheetObj.GetCellValue(1, "t1sheet1_"+"tot_ots_amt"+parseInt(j+1));
	            if(! ComIsEmpty(unit)){
	            	if (amount > 0) {
	            		colorFlg="Y";
	            	}
	            	document.form['tot_ots_amt'][j]=new Option(unit+' '+ComAddCommaRun(amount), j);
	            }
	        }
	        if (colorFlg == "Y") {
	        	//Bold font color to red
	        	formObj.tot_ots_amt.className="input2_1";
	        } else {
	        	formObj.tot_ots_amt.className="input2";
	        }
		} else {
			document.form['tot_ots_amt'][0]=new Option(sheetObj.GetCellValue(1, prefix+"tot_ots_amt1"));
            return;
        }
    }
     /**
      * tot_ots_amt Item is set to 0.
      * @param  void
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function addSelZero() {
    	var formObj = document.form;
        var sel=document.form.tot_ots_amt;
        for (i=sel.length-1; i>=0; i--){
            sel.options[i]=null
        }
        document.form['tot_ots_amt'][0]=new Option('0', 0);
        formObj.tot_ots_amt.className="input2";
    }
     /**
      * value setting after  retrieve t1sheet6
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg  Error Messages
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function t1sheet6_OnSearchEnd(sheetObj, ErrMsg){
        var t1sheet6_cntr_no=null;
        var t1sheet6_cntr_seal_no=null;
        var temp_cntr_no=null;
        var t1sheet3_cntr_no=null;
        var prefix6="t1sheet6_";
        var prefix3="t1sheet3_";
        var bStart=true;
        if (ErrMsg == "") {
        	if (sheetObj.RowCount()> 0 && sheetObjects[t1st3].RowCount()> 0) {
        		for(i=0;i<sheetObj.RowCount();i++){
        			t1sheet6_cntr_no=sheetObj.GetCellValue(i+1,prefix6+ "cntr_no");
    				if (temp_cntr_no != t1sheet6_cntr_no) {
    					if (bStart != true) {
    						setCntrSeslNo(temp_cntr_no, t1sheet6_cntr_seal_no);
    					} else {
    						bStart=false;
    					}
    					if (sheetObj.GetCellValue(i+1,prefix6+ "cntr_seal_no") != "") {
    						t1sheet6_cntr_seal_no=sheetObj.GetCellValue(i+1,prefix6+ "cntr_seal_no");
    					}
    					temp_cntr_no=t1sheet6_cntr_no;
    				} else {
    					if (sheetObj.GetCellValue(i+1,prefix6+ "cntr_seal_no") != "") {
    						t1sheet6_cntr_seal_no=t1sheet6_cntr_seal_no + "|" + sheetObj.GetCellValue(i+1,prefix6+ "cntr_seal_no");
    					}
                    }
              	}
                if (t1sheet6_cntr_seal_no != "") {
                    setCntrSeslNo(temp_cntr_no, t1sheet6_cntr_seal_no);
                }
            }
        }
    }
      /**
       * Cntr Seal No value > 0 : Combo the setting.
       * @param String cntrNo 
       * @param String sealNo 
       * @return void
       * @author
       * @version 2009.11.01
       **/
    function setCntrSeslNo(cntrNo, sealNo) {
        var t1sheet3_cntr_no=null;
        var prefix3="t1sheet3_";
        for(k=0;k<sheetObjects[t1st3].RowCount();k++){
        	t1sheet3_cntr_no=sheetObjects[t1st3].GetCellValue(k+1,prefix3+ "cntr_no");
          if (t1sheet3_cntr_no == cntrNo) {
          	if (sealNo != null) { 
          		var arrSeal=sealNo.split("|");
          		
          		sheetObjects[t1st3].CellComboItem(k+1,prefix3+"cntr_seal_no", {"ComboText":sealNo, "ComboCode":sealNo} );
          		sheetObjects[t1st3].SetCellBackColor(k+1, prefix3 + "cntr_seal_no","#EFEBEF");
          		
          		sheetObjects[t1st3].SetCellValue(k+1, prefix3 + "cntr_seal_no", arrSeal[0]);
          	}
          	break;
          }
      }
    }
     /**
      * Combo BOX setting
      * @param  Object aryPopupData 
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function conditionSet(aryPopupData){
    	var formObj = document.form;
        if(aryPopupData != undefined){
        	formObj.bl_no.value=aryPopupData[0][3];
        	formObj.bkg_no.value=aryPopupData[0][5];
            blComboSet(aryPopupData[0][3]);            
        }
    }
     /**
      * Container_No or P/O_No result > 0 -> Popup call 
      * @param  void
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function blSelectPopOpen(){
        var sXml=IBS_GetDataSearchXml(sheetObjects[sheetObjects.length-1]);
        document.form.xmlData.value=sXml;
        ComOpenPopup("ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
    }
    /**
     * Multi Combo  B/L_No the setting
     * @param  String bl_no B/L No.
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function blComboSet(bl_no) {
        combo_bl_no.RemoveAll();
        comboFlg=true;
        var itemindex=null;
        var blNo=null;
        for (idx=1; idx<=sheetObjects[sheetObjects.length-1].RowCount(); idx++) {
        	if (sheetObjects[sheetObjects.length-1].GetCellValue(idx,"sheet1_bl_tp_cd") != "B") {
        		blNo=sheetObjects[sheetObjects.length-1].GetCellValue(idx,"sheet1_bl_no") + sheetObjects[sheetObjects.length-1].GetCellValue(idx,"sheet1_bl_tp_cd");
            } else {
            	blNo=sheetObjects[sheetObjects.length-1].GetCellValue(idx,"sheet1_bl_no");
            }
        	combo_bl_no.InsertItem(-1, blNo , sheetObjects[sheetObjects.length-1].GetCellValue(idx,"sheet1_bkg_no"));
        	if (bl_no == sheetObjects[sheetObjects.length-1].GetCellValue(idx,"sheet1_bl_no")) {
                itemindex=idx -1;
            }
        }
        if (sheetObjects[sheetObjects.length-1].RowCount()> 1) {
            combo_bl_no.SetBackColor("#ffff00");
        } else {
            combo_bl_no.SetBackColor("#ffffff");
        }
        if (itemindex>-1) {        
            combo_bl_no.SetSelectIndex(itemindex);
        }
    }
     /**
      * BL_NO input BKG_NO, CNTR_NO initialization
      * @param  void
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function conditionReset(){
    	var formObj = document.form;
         if (ComGetEvent("name") == "bl_no") {
            formObj.bkg_no.value='';
            formObj.cntr_no.value='';
            formObj.h_cntr_no.value='';
            formObj.h_po_no.value='';
            buttonColorSet("btn_split", 'gray');
        }else if (ComGetEvent("name") == "bkg_no") {
            formObj.bl_no.value='';
            formObj.cntr_no.value='';
            formObj.h_cntr_no.value='';
            formObj.h_po_no.value='';
            combo_bl_no.RemoveAll();
            combo_bl_no.SetBackColor("#ffffff");
            buttonColorSet("btn_split", 'gray');
        }else if (ComGetEvent("name") == "cntr_no") {
            formObj.bl_no.value='';
            formObj.bkg_no.value='';
            formObj.h_cntr_no.value='';
            formObj.h_po_no.value='';
            combo_bl_no.RemoveAll();
            combo_bl_no.SetBackColor("#ffffff");
            buttonColorSet("btn_split", 'gray');
        }else if (ComGetEvent("name") == "po_no") {
            formObj.bl_no.value='';
            formObj.bkg_no.value='';
            formObj.h_cntr_no.value='';
            formObj.h_po_no.value='';
            combo_bl_no.RemoveAll();
            combo_bl_no.SetBackColor("#ffffff");
            buttonColorSet("btn_split", 'gray');
        }
    }
     /**
      * Upon completion of sheet1 to set the value to lookup.
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg  Error Messages
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        var blNo=null;
        var formObj = document.form;
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 1){
                blSelectPopOpen(sheetObj);
            } else if (sheetObj.RowCount()== 1){
            	if (sheetObj.GetCellValue(1,"sheet1_bl_tp_cd") != "B") {
            		blNo=sheetObj.GetCellValue(1,"sheet1_bl_no") + sheetObj.GetCellValue(1,"sheet1_bl_tp_cd");
            	} else {
            		blNo=sheetObj.GetCellValue(1,"sheet1_bl_no");
            	}
            	formObj.bkg_no.value=sheetObj.GetCellValue(1,"sheet1_bkg_no");
                combo_bl_no.RemoveAll();
                combo_bl_no.InsertItem(-1, blNo, sheetObj.GetCellValue(1,"sheet1_bkg_no"));
                combo_bl_no.SetSelectIndex(0);
                fnTabChangeQuery();
            } else {
            	ComShowCodeMessage('BKG00095');            	
            	sheetObj.RemoveAll();
            }
        }
    }
    /**
     * Multi Combo value change Event
     * @param Object  comboObj   Multi-Combo Object
     * @param Integer Index_Code Multi-Combo Index Value
     * @param String  Text       Multi-Combo Text Value
     * @return void
     * @author
     * @version 2009.11.01
     **/
//    function combo_bl_no_OnChange(comboObj, Index_Code, Text){
    function combo_bl_no_OnChange(comboObj, oldindx, oldtext , oldcode , newindx , Text ,Index_Code){    	
        conditionTrim();
        if (comboFlg != true) {
        	var formObj = document.form;
            if (Text.length > 0) {
            	document.form.bkg_no.value=Index_Code;
                if (Index_Code == "") {
                    formObj.bl_no.value='';
                    formObj.cntr_no.value='';
                    formObj.h_cntr_no.value='';
                    formObj.h_po_no.value='';
                    formObj.bkg_no.value='';           
                    formObj.po_no.value='';
                    buttonColorSet("btn_split", 'gray');
                }
            }
        } else {
            comboFlg=false;
        }
        fnSetComboText();
    }
    /**
     * Multi Combo value change Event
     * @param Object  comboObj   Multi-Combo Object
     * @param String  KeyCode 
     * @param String  Shift    
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function combo_bl_no_OnKeyDown(comboObj, KeyCode, Shift){
    	var formObj = document.form;
        if (KeyCode == 13) {
        	if(ComIsEmpty(comboObj.GetSelectText())){
                return;
            }
        	fnTabChangeQuery();			//Retrieve
        } else if (KeyCode == 8) {
        } else {
            formObj.bl_no.value='';
            formObj.cntr_no.value='';
            formObj.h_cntr_no.value='';
            formObj.h_po_no.value='';
            formObj.bkg_no.value='';           
            formObj.po_no.value='';
            buttonColorSet("btn_split", 'gray');
        }
    }
     /**
      * all items and the button initializes
      * @param  void
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function fnAllClear () {
        //All input Data Clear   
        for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
            document.form.getElementsByTagName("input")[i].value="";      
        }
        //All check box Clear    
        document.form.frm_t1sheet1_bdr_flg.checked=false;
        document.form.frm_t1sheet1_corr_flg.checked=false;
        combo_bl_no.RemoveAll();
        combo_bl_no.SetBackColor("#ffffff");
         //Outstanding Amount Clear
         var selOtsAmt=document.form.tot_ots_amt;
         for (i=selOtsAmt.length-1; i>=0; i--){
             selOtsAmt.options[i]=null
         }
         //Outstanding Demurrage Per B/L Clear
         var selDemAmt=document.form.tot_bil_amt;
         for (i=selDemAmt.length-1; i>=0; i--){
             selDemAmt.options[i]=null
         }
         try {
             oTbl.removeNode(true);
         }catch(e){}         
         //Initialize ibSheet
         for(i=0;i<sheetObjects.length;i++){
             sheetObjects[i].RemoveAll();
         }
         //BL_No the focus on
         //combo_bl_no.focus();
         //Disable pop-up button
         fnButtonInit();
    }
     /**
      * search  function call 
      * @param  void
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function enterKeySearch(){
        var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var formObject=document.form;
        var srcName=ComGetEvent("name");
        if(ComIsEmpty(srcName)){
            return;
        }
        if (keyCode == 13) {
	        if (srcName == "cntr_no" || srcName == "po_no") {
	        	fnCntrPoQuery();
	        } else {
	        	fnTabChangeQuery();			//Retrieve 
	        }
        }            
    }                    
     /**
      * value setting after  retrieve t1sheet2
      * @param Object sheetObj IBSheet Object
      * @param Object ErrMsg  Error Messages
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                var blNo=null;
                if (sheetObj.GetCellValue(1,"sheet2_bl_tp_cd") != "B") {
                	blNo=sheetObj.GetCellValue(1,"sheet2_bl_no") + sheetObj.GetCellValue(1,"sheet2_bl_tp_cd");
                } else {
                	blNo=sheetObj.GetCellValue(1,"sheet2_bl_no");
                }
                if (combo_bl_no.GetItemCount() == 0) {
                	combo_bl_no.InsertItem(-1, blNo, sheetObj.GetCellValue(1,"sheet2_bkg_no"));
                   combo_bl_no.index=0;
                } else {
                    var itemindex=combo_bl_no.FindItem( blNo, 0);
                   if (itemindex == -1) {
                       combo_bl_no.RemoveAll();
                       combo_bl_no.InsertItem(-1, blNo, sheetObj.GetCellValue(1,"sheet2_bkg_no"));
                       combo_bl_no.index=0;
                   } else {
                	   combo_bl_no.SetSelectIndex(itemindex);
                   }
                }
               if (combo_bl_no.GetItemCount() > 1) {
                   combo_bl_no.SetBackColor("#ffff00");
               } else {
                   combo_bl_no.SetBackColor("#ffffff");
               }
               document.form.bkg_no.value=sheetObj.GetCellValue(1,"sheet2_bkg_no");
               if (sheetObj.GetCellValue(1,"sheet2_split_flg") == "Y") {
               	 buttonColorSet("btn_split", 'red');
                } else {
               	 buttonColorSet("btn_split", 'gray');                  
                }
                // search Conditions BL_No and BKG_No save in hidden fields.
                fnSetHiddenKey();
            }
            var objTabWindow=ComGetObject("t"+beforetab + "frame").contentWindow;
            if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {            
	            if(beforetab == 1){//Movement
	            	t1frame.location.href="ESM_BKG_0292_01.do?bkg_no=" + sheetObj.GetCellValue(1,"sheet2_bkg_no");
	            } else if(beforetab == 2){
	            	t2frame.location.href="ESM_BKG_0292_02.do?bkg_no=" + sheetObj.GetCellValue(1,"sheet2_bkg_no");
	            } else if(beforetab == 3){
	            	t3frame.location.href="ESM_BKG_0292_04.do?bkg_no=" + sheetObj.GetCellValue(1,"sheet2_bkg_no") + "&bl_no=" + sheetObj.GetCellValue(1,"sheet2_bl_no");
	            } else if(beforetab == 4){
	            	t4frame.location.href="ESM_BKG_0292_03.do?bkg_no=" + sheetObj.GetCellValue(1,"sheet2_bkg_no");
	            }
            } else {
			    if(beforetab == 1){//Movement
			    	t1frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bkg_no"));
			    } else if(beforetab == 2){
			    	t2frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bkg_no"));
			    } else if(beforetab == 3){
			    	t3frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bkg_no"), sheetObj.GetCellValue(1,"sheet2_bl_no"));
			    } else if(beforetab == 4){
			    	t4frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bkg_no"));
			    }
            }
        }
    }
    /**
     * BL Type -> Multi Combo Sets the color.
     * W - Blue, S - Red, ETC - Black 
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnSetComboText() {
        var blNo=combo_bl_no.GetSelectText();
        if (ComIsEmpty(blNo) == false) {
            var strTemp=blNo.substr(blNo.length-1);
            if (strTemp == "W") {
                combo_bl_no.SetFontColor("#0000ff");
            } else if (strTemp == "S") {
                combo_bl_no.SetFontColor("#ff0000");
            } else {
                combo_bl_no.SetFontColor("#000000");
            }
        }
    }
    /**
    * Multi Combo value Clear Event
    * @param  Object blCombo Combo Object
    * @return void
    * @author
    * @version 2009.11.01
    **/
    function combo_bl_no_OnClear(blCombo) {
    	combo_bl_no.SetBackColor("#ffffff");
    	combo_bl_no.SetFontColor("#000000");
    }         
     /**
      * Button disabled
      * @param  void
      * @return void
      * @author
      * @version 2009.11.01
      **/
    function buttonColorSet(btn_name, color){
    	var btn= ComGetObject(btn_name);
        if (color == 'red') {
        	ComEnableObject(btn, 1)
        } else {
        	ComEnableObject(btn, 0)
        }
        
       	if (btn_name == "btn_split") {
       	    document.form.h_split.value=color;
       	}
       	btn.style.color = color;
    }
    /**
     *  the screen clears of a button.
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnButtonInit() {
    	ComEnableObject(document.form.btn_ts_route, false);
    	ComEnableObject(document.form.btn_corr_flg, false);
    	ComEnableObject(document.form.btn_contract_no, false);
    	ComEnableObject(document.form.btn_consignee, false);
    	ComEnableObject(document.form.btn_notify, false);
    	ComEnableObject(document.form.btn_a_notify, false);

        buttonColorSet("btn_split", 'gray');
    }
    /**
     * t1sheet3 Click Event
     * @param Object  sheetObj IBSheet Object
     * @param Integer row       
     * @param Integer col      
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function t1sheet3_OnClick(sheetObj, Row, Col){
        var prefix1="t1sheet1_";
        var prefix3="t1sheet3_";
        var param=null;
        var bl_no=null;
        var bkg_no=null;
        var bl_tp_cd=null;
        var cntr_no=null;
        bl_no=sheetObjects[t1st1].GetCellValue(1, prefix1 + "bl_no");
        bkg_no=sheetObjects[t1st1].GetCellValue(1, prefix1 + "bkg_no");
        bl_tp_cd=sheetObjects[t1st1].GetCellValue(1, prefix1 + "bl_tp_cd");
        cntr_no=sheetObjects[t1st3].GetCellValue(Row, prefix3 + "cntr_no");
        if (bl_tp_cd == "B") {
        	bl_tp_cd="";
        }
        if (sheetObj.ColSaveName(Col) == prefix3 + "dcgo_flg"   ||
                sheetObj.ColSaveName(Col) == prefix3 + "bb_cgo_flg" ||
                sheetObj.ColSaveName(Col) == prefix3 + "in_ga_flg"  ||
                sheetObj.ColSaveName(Col) == prefix3 + "cdo_temp")  {
            if (sheetObj.ColSaveName(Col) == prefix3 + "dcgo_flg") {
            	if (sheetObj.GetCellValue(Row, prefix3 + "dcgo_flg") == "Y") {
                    param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
                    param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
                    ComOpenWindow("ESM_BKG_0659.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:810px;dialogHeight:400px;dialogLeft:0;dialogTop:0", true);
                }
            } else if (sheetObj.ColSaveName(Col) == prefix3 + "bb_cgo_flg") {
            	if (sheetObj.GetCellValue(Row, prefix3 + "bb_cgo_flg") == "Y") {
                    param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
                    param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
                    ComOpenWindow("ESM_BKG_0660.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:710px;dialogHeight:380px;dialogLeft:0;dialogTop:0", true);
                }
            } else if (sheetObj.ColSaveName(Col) == prefix3 + "in_ga_flg") {
            	if (sheetObj.GetCellValue(Row, prefix3 + "in_ga_flg") == "OUT") {
                    param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
                    param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
                    ComOpenWindow("ESM_BKG_0661.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:755px;dialogHeight:300px;dialogLeft:0;dialogTop:0", true);
                }
            }else if (sheetObj.ColSaveName(Col) == prefix3 + "cdo_temp") {
            	if (sheetObj.GetCellValue(Row, prefix3 + "cdo_temp") != "N") {
                    param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
                    param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
                    ComOpenWindow("ESM_BKG_0498_POP.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1224px;dialogHeight:540px;dialogLeft:0;dialogTop:0", true);
                }
            }
        }
    }
     /**
      * If you have an OnClick event of the Grid : cntr_no :  show INVOICE information 
      */
     function t1sheet3_OnDblClick(sheetObj, row, col){
    	 var click_cntr_no=sheetObj.GetCellValue(row, "t1sheet3_cntr_no");
         demDtlPopOpen(click_cntr_no);
     }     
    /**
     * B/L Info Clear 
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnBlInfoClear() {
       for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
           if (document.form.getElementsByTagName("input")[i].name.substr(0, 12) == "frm_t1sheet1") {
           	document.form.getElementsByTagName("input")[i].value="";
           }     
       }
       document.form.frm_t1sheet1_bdr_flg.checked=false;
       document.form.frm_t1sheet1_corr_flg.checked=false;
        var selOtsAmt=document.form.tot_ots_amt;
        for (i=selOtsAmt.length-1; i>=0; i--){
            selOtsAmt.options[i]=null
        }
        var selDemAmt=document.form.tot_bil_amt;
        for (i=selDemAmt.length-1; i>=0; i--){
            selDemAmt.options[i]=null
        }
        for(i=0; i<sheetObjects.length; i++){
        	sheetObjects[i].RemoveAll();
        }
        //Disable pop-up button
        fnButtonInit();
    }
    /**
     * search Conditions BL_No and BKG_No save in hidden fields.
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnSetHiddenKey() {
    	var formObj=document.form;
    	formObj.h_old_bl_no.value=combo_bl_no.GetSelectText();
    	formObj.h_old_bkg_no.value=formObj.bkg_no.value;
    }
    /**
     * Change search conditions when changing tab. Automatically calls the lookup module 
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnTabChangeQuery() {
    	var formObj=document.form;
    	// Hidden BL_No and BKG_No<> input BL_No and  BKG_No -> search
    	if (formObj.h_old_bl_no.value != combo_bl_no.GetSelectText() ||
    			formObj.h_old_bkg_no.value != formObj.bkg_no.value) {
    		// Change search criteria -> All data Clear
    		fnBlInfoClear();
    		fnSearch();		//Retrieve
    	} else {
    		// Processed only if Search condition entered.
    		if (combo_bl_no.GetSelectText() != '' || formObj.bkg_no.value != '') {
	    		if(beforetab == 0){//B/L Info
	    			if (sheetObjects[t1st1].RowCount()== 0) {
	    				fnSearch();		
	                }
	            }else {
                	fnSearch();	
	            }
    		}
    	}
    }
    /**
     * Query processing module integrated management
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnSearch() {
    	if(beforetab == 0){//B/L Info
        	doActionIBSheet(sheetObjects[t1st1],document.form,IBSEARCH);
        }else {
            doActionIBSheet(sheetObjects[sheetObjects.length-2],document.form,IBSEARCH,"","");
        }
    }
    /**
     * controlling not to allowed to select the other tabs except the retrieved tab
     * @param  void
     * @return void
     * @author
     * @version 2009.11.01
     **/
    function fnTabEnable(flag) {
    	var formObj=document.form;
    	if (flag == false) {
    		formObj.tab1.SetEnable(0);
    	} else {
    		formObj.tab1.SetEnable(1);
    	}
    }
    /**
    * Check  Float value .
    * @param  Object  fVal 
    * @return Boolean True - Float, False  
    * @author
    * @version 2009.11.01
    **/
    function isFloat(fVal) {
    	var temp=0;
    	var sVal=null;
    	var sIdx=fVal.toString().indexOf(".");
    	if (sIdx > 0) {
	    	var sTemp=fVal.toString();
    		sVal=sTemp.substring(parseInt(sIdx) + 1);
	    	if (parseInt(sVal) > 0 ) {
	    		return true;
	    	} else {
	    		return false;
	    	}
    	} else {
    		return false;
    	}
    }
     /**
      * End of Search condition remove the spaces
      */
    function conditionTrim(){
    	var formObj = document.form;
    	combo_bl_no.SetSelectText(ComTrim(combo_bl_no.GetSelectText()), false);
    	formObj.bl_no.value=ComTrim(formObj.bl_no.value);
    	formObj.bkg_no.value=ComTrim(formObj.bkg_no.value);
    	formObj.cntr_no.value=ComTrim(formObj.cntr_no.value);
    }
    /**
     * Clear Search condition 
     */
    function fnQueryCondClear() {
        combo_bl_no.RemoveAll();
        combo_bl_no.SetBackColor("#ffffff");
        document.form.bkg_no.value="";
        document.form.cntr_no.value="";
        document.form.po_no.value="";
    }
    function loadTabPage(tabIndex) {
         if (tabIndex == null || tabIndex == "") {
             tabIndex=tabObjects[0].GetSelectedIndex();
         }
         var bkgNo=document.form.bkg_no.value;
         var blNo=combo_bl_no.GetSelectText();
         var sUrl="";
         var param="?bkg_no=" + bkgNo;
         var queryYn="N";
         switch (tabIndex) {
         case 0:
        	 return true;
         case 1:
             sUrl="ESM_BKG_0292_01.do";
             if (t1BkgNo != bkgNo || t1BlNo != blNo) {
            	 queryYn="Y";
            	 t1BkgNo=bkgNo;
            	 t1BlNo=blNo;
             }
             break;
         case 2:
             sUrl="ESM_BKG_0292_02.do"; 
             if (t2BkgNo != bkgNo || t2BlNo != blNo) {
            	 queryYn="Y";
            	 t2BkgNo=bkgNo;
            	 t2BlNo=blNo;
             }
             break;
         case 3:
        	 sUrl="ESM_BKG_0292_04.do"; 
             if (t4BkgNo != bkgNo || t4BlNo != blNo) {
            	 queryYn="Y";
            	 t4BkgNo=bkgNo;
            	 t4BlNo=blNo;            	 
             }
             break;
         case 4:       
             sUrl="ESM_BKG_0292_03.do"; 
             if (t3BkgNo != bkgNo || t3BlNo != blNo) {
            	 queryYn="Y";
            	 t3BkgNo=bkgNo;
            	 t3BlNo=blNo;            	 
             }
             break;
         }
         var objTabWindow=ComGetObject("t" + tabIndex + "frame").contentWindow;        
         if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {             
        	 if (bkgNo != "" || blNo != "") {            	 
        		 if (queryYn == "Y") {
        			 fnTabChangeQuery();
        		 }
             } else {
            	 objTabWindow.location.href=sUrl;
             }
             return true;
         } else {
             if (bkgNo != "" || blNo != "") {
    			 if (queryYn == "Y") {
    				 fnTabChangeQuery();
    			 }
             }
         }
     }     
    /**
     * Hidden IBSheet 
     */
    function t1sheet7_OnSearchEnd(sheetObj, ErrMsg){
        var sel=document.form.tot_bil_amt;
        var formObj = document.form;
        var prefix="t1sheet7_";
        //Initialization SELECT BOX
        for (i=sel.length-1; i>=0; i--){
            sel.options[i]=null
        }
        var currCd="";
        var bilAmt="";
        var demSts=false;
        if (sheetObj.RowCount()> 0) {
	        for (j=0; j<sheetObj.RowCount(); j++){
	        	currCd=sheetObj.GetCellValue(parseInt(j+1), prefix+"curr_cd");
	        	bilAmt=sheetObj.GetCellValue(parseInt(j+1), prefix+"tot_bil_amt");
	            if (parseInt(bilAmt) > 0) {
	    			demSts=true;
	    		}
	            document.form['tot_bil_amt'][j]=new Option(currCd+' '+ComAddCommaRun(bilAmt), j);
	        }
	        if (demSts == true) {
	            formObj.tot_bil_amt.className="input2_1";
	   	  	} else {
	            formObj.tot_bil_amt.className="input2";
	   	  	}
        } else {
            document.form['tot_bil_amt'][0]=new Option('0');
            formObj.tot_bil_amt.className="input2";
        }	        
    }          
     /**
      * Hidden IBSheet post-processing
      */
     function t1sheet4_OnSearchEnd(sheetObj){
         var invTotBilAmt=0;
         //Container Information the container number of the first
         var fist_cntr_no=sheetObjects[t1st4].GetCellValue(1, "t1sheet4_cntr_no");
         for(var idx=1; idx <= sheetObj.RowCount(); idx++){
             //INVOICE =  first container number -> show
        	 if(fist_cntr_no != sheetObjects[t1st4].GetCellValue(idx, "t1sheet4_cntr_no")){
                 sheetObjects[t1st4].SetRowHidden(idx,1);
             }
         }
     }
    /**
     * DEM.DET pop-up 
     */
    function demDtlPopOpen(cntr_no){
          var sXml=IBS_GetDataSearchXml(sheetObjects[t1st4]);
          document.form.demDtlXmlData.value=sXml;
          var condition="?";
              condition += "cntr_no="+cntr_no;
          ComOpenWindowCenter('/opuscntr/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
    }         

    $(window).resize(function() {
		if(this.resizeTO) {
			clearTimeout(this.resizeTO);
		}
		this.resizeTO = setTimeout(function() {
			$(this).trigger('resizeEnd');
		}, 300);
    });

    $(window).on('resizeEnd', function() {
        if(beforetab == 0) {
        	resizeIfSheet();
        }
        else {
            var ifrId = "#t" + (beforetab) + "frame";
            var height = $(window).height();
            var ifrOffset = $(ifrId).offset();
            $(ifrId).height(height - ifrOffset.top - 25);
            $(ifrId)[0].contentWindow.resizeIfSheet();
        }
    });

    function resizeIfSheet(){
        ComResizeSheet(sheetObjects[2]);
    }
 
    
    function fnSelectCntrPoQuery(name){
        switch(name){
        case "cntr_no":
            if(ComIsEmpty(document.form.cntr_no.value)){
                document.form.h_cntr_no.value="";
                return false;
            }
			if (!(document.form.cntr_no.value.length == 10 || document.form.cntr_no.value.length == 11)) {
	    		ComShowCodeMessage('BKG00700');
	    		return false;
	    	}
                document.form.xmlData.value=null;
                sheetObjects[sheetObjects.length-1].RemoveAll();
                conditionReset();
                doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND01);
                document.form.h_cntr_no.value=document.form.cntr_no.value;
            break;
        case "po_no":               
            if(ComIsEmpty(document.form.po_no.value)){
                document.form.h_po_no.value="";
                return false;
            }
                document.form.xmlData.value=null;
                sheetObjects[sheetObjects.length-1].RemoveAll();
                conditionReset();
                doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND02);
                document.form.h_po_no.value=document.form.po_no.value;
            break;
        }
    }    