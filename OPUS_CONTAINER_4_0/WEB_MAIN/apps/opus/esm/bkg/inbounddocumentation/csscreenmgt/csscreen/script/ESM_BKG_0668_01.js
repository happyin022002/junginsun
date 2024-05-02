/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_01.js
*@FileTitle  : In-bound C/S Screen US
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
     * @author
     */
    /* Developer Work  */
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var t1beforetab=1;
    var t3beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var t1sheet1_num=0;
    var t1sheet3_num=1;
    var t1sheet1_1_num=2;
    var t1sheet1_2_num=3;
    var t1sheet1_3_num=4;
    var t1sheet5_num=5;
    var t1sheet6_num=6;
//  var t1sheet2 = 1;
//  var t1sheet4 = 3;
//  var t1sheet7 = 9;
    var sheet2_num=0;
    var t1BkgNo="";
    var t2BkgNo="";
    var t3BkgNo="";
    var t4BkgNo="";
    var t5BkgNo="";
    var t6BkgNo="";
    var t1BlNo="";
    var t2BlNo="";
    var t3BlNo="";
    var t4BlNo="";
    var t5BlNo="";
    var t6BlNo="";
    var comboFlg=null;
    var cntrQtySum=0;
    var chgFlag=null;
    var frt_term_cd=null;
     	
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
             /***** using extra sheet valuable if there are more 2 sheets *****/
             /*******************************************************/
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
    				case "btn_retrieve":
                    	if (formObject.cntr_no.value != '' && combo_bl_no.GetSelectText() == '' && formObject.bkg_no.value == '' && formObject.po_no.value == '' && formObject.hbl_no.value == '') {
                    		fnSelectCntrPoQuery("cntr_no");
                    	} else if (formObject.po_no.value != '' && combo_bl_no.GetSelectText() == '' && formObject.bkg_no.value == '' && formObject.cntr_no.value == '' && formObject.hbl_no.value == '') {
                    		fnSelectCntrPoQuery("po_no");
                    	} else if (formObject.hbl_no.value != '' && combo_bl_no.GetSelectText() == '' && formObject.bkg_no.value == '' && formObject.cntr_no.value == '' && formObject.po_no.value == '') {
                    		fnSelectCntrPoQuery("hbl_no");
                    	}
                    	else {
	    					if (formObject.h_old_bl_no.value != combo_bl_no.GetSelectText() ||
	                    			formObject.h_old_bkg_no.value != formObject.bkg_no.value) {
	                    		// If you change your search criteria, all existing data is clear.
	                    		fnBlInfoClear();
	                    		fnSearch();		//The retrieve processing module is called.
	                    	} else {
	                    		fnSearch();			//The retrieve processing module is called.
	                    	}
                    	}
                        break;
                    case "btn_new":
                    	fnQueryCondClear();
                        break;
                    case "btn_inquiry":
                    	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', combo_bl_no.GetSelectText());
                            //document.form.combo_bl_no.focus();
                            return false;
                        }
                    	var bkg_no=document.form.bkg_no.value;
                    	var bl_no=combo_bl_no.GetSelectText();
            	        var strTemp=bl_no.substring(bl_no.length-1);
            	        if (strTemp == "W" || strTemp == "S" || strTemp == "B") {
                	        bl_no=bl_no.substring(0, bl_no.length-1);
            	        }
                    	var param="?bkg_no="+bkg_no+ "&bl_no="+bl_no + "&pgmNo=ESM_BKG_0034-03";                	
                    	ComOpenWindow("/opuscntr/ESM_BKG_0034_POP.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:700px;dialogLeft:0;dialogTop:0", false);
                        break;
                    case "btn_inquiry2":
                    	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', combo_bl_no.GetSelectText());
                            //document.form.combo_bl_no.focus();
                            return false;
                        }
                    	var bkg_no=document.form.bkg_no.value;
                    	var bl_no=combo_bl_no.GetSelectText();
            	        var strTemp=bl_no.substring(bl_no.length-1);
            	        if (strTemp == "W" || strTemp == "S" || strTemp == "B") {
                	        bl_no=bl_no.substring(0, bl_no.length-1);
            	        }
                    	var param="?bkg_no="+bkg_no+ "&bl_no="+bl_no + "&pgmNo=ESM_BKG_0029";                	
                    	ComOpenWindow("/opuscntr/ESM_BKG_0029_POP.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:700px;dialogLeft:0;dialogTop:0", false);
                        break;
                    case "btn_history":
                    	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', combo_bl_no.GetSelectText());
                            //document.form.combo_bl_no.focus();
                            return false;
                        }
                    	var bkg_no=document.form.bkg_no.value;
                    	var param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_0566";                	
                    	ComOpenWindow("/opuscntr/ESM_BKG_0566.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:900px;dialogHeight:700px;dialogLeft:0;dialogTop:0", false);
                        break;
                    case "btn_preview":
                    	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', combo_bl_no.GetSelectText());
                            //document.form.combo_bl_no.focus();
                            return false;
                        }
                    	var bkg_no=document.form.bkg_no.value;
                    	var blNo=combo_bl_no.GetSelectText();
            	        var blType="";
            			var param='bkg_no=' + bkg_no + '&pgmNo=ESM_BKG_0927' + '&bl_tp_cd=D&form_level=6';
            			var url="ESM_BKG_0927.do?" + param;
            			ComOpenWindow("/opuscntr/ESM_BKG_0927_POP.do?" + param, "PopupEsmBkg0927", "scroll:yes;status:no;help:no;dialogWidth:900px;dialogHeight:700px;dialogLeft:0;dialogTop:0", false);
            			break;                	
                    case "btn_BkgMain":
                    	if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(document.form.bkg_no.value)){
                            ComShowCodeMessage('BKG40031', combo_bl_no.GetSelectText());
                            //document.form.combo_bl_no.focus();
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
                            //document.form.combo_bl_no.focus();
                            return false;
                        }
                    	var bkgNo=document.form.bkg_no.value;
    		        	var sUrl="/opuscntr/opusMain.screen";
    		        	sUrl += "?parentPgmNo=ESM_BKG_M001";
    		        	sUrl += "&pgmUrl=^opuscntr^ESM_BKG_0079.do";
    		        	sUrl += "&pgmNo=ESM_BKG_0079&openTab=B9";
    		        	sUrl += "&bkg_no="+bkgNo;
    		        	comBkgCallPopBkgCharge(bkgNo);
                    	break;
        			case "btn_ts_route":
    					if (sheetObjects[t1sheet1_num].RowCount() == 0) return;
    					if (document.form.bkg_no.value.length == 0) retuen;
    					var bkg_no = sheetObjects[t1sheet1_num].GetCellValue(1, "t1sheet1_bkg_no"); 
    					param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_0650";
	                    ComOpenWindow("/opuscntr/ESM_BKG_0650.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:710px;dialogHeight:310px;dialogLeft:0;dialogTop:0", false);
						break;
	    			case "btn_corr_flg":
	    				if (sheetObjects[t1sheet1_num].RowCount() == 0) return;
	    				if (document.form.frm_t1sheet1_corr_flg.checked == true) {
	    					var bkg_no=t1sheet1.GetCellValue(1, "t1sheet1_bkg_no");
	    					param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_0651";
							ComOpenWindow("/opuscntr/ESM_BKG_0651.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:700px;dialogHeight:400px;dialogLeft:0;dialogTop:0", false);							
	    				}
	    				break;
	    			case "btn_contract_no":
	    				if (sheetObjects[t1sheet1_num].RowCount() == 0) return;
	                    if (sheetObjects[t1sheet1_num].GetCellValue(1,"t1sheet1_rfa_no").length > 0) {
	                        // If present RFA_NO, RFA screen call
	                        var rfaNo = sheetObjects[t1sheet1_num].GetCellValue(1, "t1sheet1_rfa_no"); 
	                        var pgmNo="ESM_PRI_2019";
	                        var params="?s_rfa_no=" + rfaNo+"&pgmNo=" + pgmNo+"&mainPage=false";
	                        var sFeatures="status=no, width=1100, height=800, resizable=yes, scrollbars=yes"; 
	                        ComOpenWindowCenter("/opuscntr/ESM_PRI_2019_POP.do"+params, "myWin", 1100, 800, false, "yes");
	                    } else {
	                        if (sheetObjects[t1sheet1_num].GetCellValue(1,"t1sheet1_sc_no").length > 0) {
	                            // SC screen call
	                    		var scRfaNo=sheetObjects[t1sheet1_num].GetCellValue(1, "t1sheet1_sc_no");
	                            var pgmNo="ESM_PRI_0004";
	                            var scRfaNoP=scRfaNo.substr(0, 3);
	                            var scRfaNoS=scRfaNo.substr(3);
	                            var params="?sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS+ "&pgmNo=" + pgmNo+"&mainPage=false";
	                            var sFeatures="status=no, width=1290, height=850, resizable=yes, scrollbars=yes";   
	                            ComOpenWindowCenter("/opuscntr/ESM_PRI_0004_POP.do"+params, "myWin", 1290, 850, false, "yes");
	                        }                  
	                    }
	    				break;
	    			case "btn_consignee":
	    				if (sheetObjects[t1sheet1_num].RowCount() == 0) return;
	                    //if Consignee value exist, button active
	                    if (sheetObjects[t1sheet1_num].GetCellValue(1,"t1sheet1_csg_cust_nm").length > 0) {
	    					var bkg_no = sheetObjects[t1sheet1_num].GetCellValue(1, "t1sheet1_bkg_no"); 
	    					param="?bkg_no="+bkg_no+"&tab_idx=0"+ "&pgmNo=ESM_BKG_0242";
	    					ComOpenWindow("/opuscntr/ESM_BKG_0242.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:530px;dialogHeight:380px;dialogLeft:0;dialogTop:0", false);
	                    }
	    				break;
	    			case "btn_notify":
	    				if (sheetObjects[t1sheet1_num].RowCount() == 0) return;
	                    //if Notify value exist, button active
	                    if (sheetObjects[t1sheet1_num].GetCellValue(1,"t1sheet1_noy_cust_nm").length > 0) {
	    					var bkg_no = sheetObjects[t1sheet1_num].GetCellValue(1, "t1sheet1_bkg_no"); 
	    					param="?bkg_no="+bkg_no+"&tab_idx=1"+ "&pgmNo=ESM_BKG_0242";
							ComOpenWindow("/opuscntr/ESM_BKG_0242.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:530px;dialogHeight:380px;dialogLeft:0;dialogTop:0", false);
	                    }
	    				break;
	    			case "btn_a_notify":
	    				if (sheetObjects[t1sheet1_num].RowCount() == 0) return;
	                    //if A.Notify value exist, button active
	                    if (sheetObjects[t1sheet1_num].GetCellValue(1,"t1sheet1_aoy_cust_nm").length > 0) {
	    					var bkg_no = sheetObjects[t1sheet1_num].GetCellValue(1, "t1sheet1_bkg_no"); 
	    					param="?bkg_no="+bkg_no+"&tab_idx=2"+ "&pgmNo=ESM_BKG_0242";
							ComOpenWindow("/opuscntr/ESM_BKG_0242.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:530px;dialogHeight:380px;dialogLeft:0;dialogTop:0", false);							
	                    }
	    				break;
	                case "btn_split":
	                	if (document.form.h_split.value != "red") return;
	                    document.form.xmlData.value=null;
	                    sheetObjects[sheetObjects.length-1].RemoveAll();
	                    doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND05);
	                	break;
	    			case "btn_c_flag":
	    				if (sheetObjects[t1sheet1_num].RowCount() == 0) return;
	    				var bl_no = sheetObjects[t1sheet1_num].GetCellValue(1, "t1sheet1_bl_no"); 
    					param="?bl_no="+bl_no+ "&pgmNo=ESM_BKG_0041&mainPage=false";
    					ComOpenWindowCenter("/opuscntr/ESM_BKG_0041_POP.do"+param, "ESM_BKG_0041", 1200, 650, false);
	                	break;
	    			case "btn_instruction":
	    				if (sheetObjects[t1sheet1_num].RowCount() == 0) return;
	    				var bkg_no = sheetObjects[t1sheet1_num].GetCellValue(1, "t1sheet1_bkg_no"); 
    					param="?bkg_no="+bkg_no+ "&pgmNo=ESM_BKG_1093";
    					ComOpenWindowCenter("/opuscntr/ESM_BKG_1093.do"+param, "ESM_BKG_1093", 1050, 400, false, "yes");
	                	break;
	    			case "btn_pu_history":
	    				if (sheetObjects[t1sheet1_num].RowCount() == 0) return;
	    				var bl_no = sheetObjects[t1sheet1_num].GetCellValue(1, "t1sheet1_bl_no");
	    				param="?bl_no="+bl_no+ "&pgmNo=ESM_BKG_0041&mainPage=false&autoSearchFlg=Y&sch_tp=B";
	    				ComOpenWindowCenter("/opuscntr/ESM_BKG_0414_POP.do"+param, "ESM_BKG_0414", 1150, 650, false);
	    				
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
         * registering IBSheet Object as list
         * adding process for list in case of needing batch processing with other items 
         * defining list on the top of source
         */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
            	if (sheetObjects[i].id == "t1sheet3" || sheetObjects[i].id == "t1sheet1_1" || sheetObjects[i].id == "t1sheet1_2") {
                	ComConfigSheet (sheetObjects[i] );
                    initSheet(sheetObjects[i],i+1);
                    ComEndConfigSheet(sheetObjects[i]);            		
            	} else {
                    initSheet(sheetObjects[i],i+1);            		
            	}            	
            }
            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }
            //IBMultiCombo Initialization
            for(var j=0;j<comboObjects.length;j++){
                initCombo(comboObjects[j],j+1);
            }
            sheet2_num=sheetObjects.length - 2;
            initControl();
            document.getElementById("btn_inquiry2").style.display="none"; 
            
            //@ Test Code Start ----------
//            document.form.bkg_no.value  = 'SHA300019100';
			//@ Test Code End   ----------
            
            if (document.form.bkg_no.value != "") {
            	fnSearch();
            }            
        }
         //Set IBCombo Object In comboObjects array
         function setComboObject(combo_obj){
            comboObjects[comboCnt++]=combo_obj;
         }
         function initCombo(comboObj, comboNo) {
        	 comboObj.RemoveAll();
        	 comboObj.SetUseEdit(1);
             //no support[check again]CLT comboObj.ValidChar(2, 1);		//English upper, numbers can be entered
             comboObj.IMEMODE=0;			//IMEMODE=English
             comboObj.SetMaxLength(13);
             comboObj.ValidChar("2","1");
             //no support[check again]CLT comboObj.UseCode=true;
         }
         function initControl() {
        	 axon_event.addListenerFormat('keypress',  'obj_keypress',    form); //- When typing the keyboard
        	 axon_event.addListenerFormat('keydown',  'enterKeySearch',    form); //- When typing the keyboard
//        	 axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
             //document.form.combo_bl_no.focus();
             fnButtonInit();
         }
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
            case "sheet1":
                with(sheetObj){
	              var HeadTitle1="|Seq.||B/L No.|CNEE Name|Bkg No.|B/L Type|SPLIT FLG";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              prefix="sheet1_";
	
	              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
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
	              SetVisible(1);
            }


			break;
            case "sheet2":
                with(sheetObj){
	             
	             var HeadTitle="ibflag|partial|bl_no|bkg_no|split_no|bl_tp_cd";
	             var headCount=ComCountHeadTitle(HeadTitle);
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
	             SetVisible(1);
            }


            	break;
            case "t1sheet1":
                with(sheetObj){
		             var HeadTitle="ibflag|arrival_vvd|arrival_vvd_nm|partial|vps_eta_dt|vps_etb_dt|slan_cd|rcv_term_cd|de_term_cd|por_cd|pol_cd|pod_cd|pod_nm|del_cd|del_nm|bkg_sts_cd|bdr_flg|corr_usr_id|pck_qty|pck_tp_cd|act_wgt|wgt_ut_cd|sc_no|rfa_no|cstms_desc|us_obl_rdem_flg|obl_rdem_dt|obl_rdem_ofc_cd|shp_cust_cd|shp_cust_nm|csg_cust_cd|csg_cust_nm|noy_cust_cd|noy_cust_nm|aoy_cust_cd|aoy_cust_nm|bl_no|bkg_no|split_no|bkg_cre_dt|bkg_ofc_cd|bl_tp_cd|Customs Clearance|Filer|MIB No.|IT Date|cstms_clr_cd|cstms_clr_lst_dt|evnt_ofc_cd|frtCltFlg|hisSeq|frtCltLstDt|frtCltOfcCd|tot_ots_sts_cd|tot_ots_curr_cd1|tot_ots_curr_cd2|tot_ots_curr_cd3|tot_ots_curr_cd4|tot_ots_curr_cd5|tot_ots_amt1|tot_ots_amt2|tot_ots_amt3|tot_ots_amt4|tot_ots_amt5|pod_yd_cd|del_yd_cd|instruction";
		             var headCount=ComCountHeadTitle(HeadTitle);
		             prefix="t1sheet1_";
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vvd_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"partial",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_etb_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"por_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"corr_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"act_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rfa_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"us_obl_rdem_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shp_cust_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shp_cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"csg_cust_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"csg_cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"noy_cust_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"noy_cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"aoy_cust_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"aoy_cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_cre_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_file_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_trsp_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_trsp_iss_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_lst_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"his_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_lst_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"instruction",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
		             SetCountPosition(0);
		             SetVisible(0);
            }


            	break;
            	case "t1sheet3":      //t1sheet3 init
           	      with(sheetObj){
	                 var HeadTitle="|TP/SZ|BKG Q'ty|CNTR Q'ty";
	                 var headCount=ComCountHeadTitle(HeadTitle);
	                 prefix="t1sheet3_";
	
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
                    SetSheetHeight(87);
                 }
                break;
	            case "t1sheet1_1":      //t1sheet1_1 init
		                with(sheetObj){
			             var HeadTitle1="|Seq.|Container No.|TS|Pickup Information|Pickup Information|Pickup Information|Pickup Information|Pickup Information|Pickup Information|Weight|Weight|Package|Package|SPC|Pick up Notice Information|Pick up Notice Information|Pick up Notice Information|Pick up Notice Information";
			             var HeadTitle2="|Seq.|Container No.|TS|Pickup No.|Yard|Available Date|Last Free Date|TP|Updated Date|Weight|Weight|Package|Package|SPC|(Exp)Send Date|OFC|User Name|Remark(s)";
			             var headCount=ComCountHeadTitle(HeadTitle1);
			             var prefix="t1sheet1_1_";
		
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
		
			             var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"},
			                       { Text:HeadTitle2, Align:"Center"} ];
			             InitHeaders(headers, info);
		
			             var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
			                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_yd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"aval_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"free_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ntc_tp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_upd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_wgt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pck_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_evnt_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pkup_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
			              
			             InitColumns(cols);
		
			             SetEditable(0);
			             SetCountPosition(0);
			             SetMergeCell(0, 10, 2, 2)
			             SetMergeCell(0, 12, 2, 2)
			             SetSheetHeight(182);//82
		             }

                    break;
    				case "t1sheet1_2":      //t1sheet1_2 init
    					with(sheetObj){
    		            
		    		         var HeadTitle="|Seq.|Container No.|F/M|TS|ESTIMATE\nFree Time|SAT\nExcl.|SUN\nExcl.|HOLI\nExcl.|ESTIMATE\nPOD LFD|Daily\nDemurrage|Fixed\nFreeTime|Fixed\nPOD LFD|Outstanding\nDemurrage|Bil Amt|Paid Amt|Seal No.|Package|Package|Weight|Weight|Measure|Measure|R/Term|D/Term|AS|ST|DG|BB|AK|RF(ºC)|RD|SOC";
		    		         var headCount=ComCountHeadTitle(HeadTitle);
		    		         prefix="t1sheet1_2_";
		
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
		    		             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sat_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
		    		             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sun_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
		    		             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_hol_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
		    		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys_calc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"out_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		    		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bil_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		    		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"paid_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		    		             {Type:"Combo",     Hidden:0, Width:170,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_seal_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
		    		         SetImageList(0,"/style/images/btns_search.gif");
		    		         SetImageList(1,"/style/images/btns_search_off.gif");
		    		         SetCountPosition(0);
		    		         SetShowButtonImage(1);
    		                 SetSheetHeight(200);//102
    		         }


	                    break;
    				case "t1sheet1_3":      //t1sheet1_3 init
	                    /****************************************************************
	                    //container Demurrage
	                    *****************************************************************/
    				    with(sheetObj){
		    			      var HeadTitle=" |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";
		    			      var prefix="t1sheet1_3_";
		
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
		    			             {Type:"Float",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bil_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		    			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		    			             {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		    			       
		    			      InitColumns(cols);
		
		    			      SetEditable(0);
		    			      SetCountPosition(0);
		    			      SetVisible(0);
    					}


	                break;
    	            case "t1sheet5":
    	                with(sheetObj){
	    	              var HeadTitle1="|Container No.|Seal No.";
	    	              var headCount=ComCountHeadTitle(HeadTitle1);
	    	              prefix="t1sheet5_";
	
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
                    case "t1sheet6":
                        with(sheetObj){
	                      var HeadTitle1="|curr_cd|tot_bil_amt";
	                      var headCount=ComCountHeadTitle(HeadTitle1);
	                      prefix="t1sheet6_";
	
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
            }
        }
      // handling sheet process
        function doActionIBSheet(sheetObj,formObj,sAction) {
            var param="";
            switch(sAction) {
               case IBSEARCH:      //retrieve
               		if(!validateForm(sheetObj,formObj,sAction)) return false;
                    document.form.xmlData.value=null;
            		if (!ComIsEmpty(combo_bl_no.GetSelectText())) {
	       				formObj.bl_no.value=combo_bl_no.GetSelectText().trim();
	       			}
                    var temp_bl=combo_bl_no.GetSelectText();
                    var temp_bkg=formObj.bkg_no.value;
                	//ComOpenWait(true);
                	combo_bl_no.SetSelectText(temp_bl);
                	formObj.bkg_no.value=temp_bkg;
                	//if BL_TP_CD is W Or S, BL_TP_CD remove
                    if(formObj.bl_no.value !=''){
                        var blNo=formObj.bl_no.value;
                        var suffix=blNo.substring(formObj.bl_no.value.length-1)
                        if(suffix =='W' || suffix =='S'){
                            formObj.bl_no.value=blNo.substring(0, blNo.lastIndexOf(suffix));
                        }
                    }
       				if ( sheetObj.id == "t1sheet1"){
	           			formObj.f_cmd.value=SEARCH;
	           			var aryPrefix=new Array("t1sheet1_", "t1sheet3_", "t1sheet1_1_", "t1sheet1_2_", "t1sheet1_3_", "t1sheet5_", "t1sheet6_"); //prefix 문자??배열
	           			param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value;
 	           			var sXml=sheetObj.GetSearchData("ESM_BKG_0668_01GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
		         		var arrXml=sXml.split("|$$|");
		         		for(var idx=0; idx < arrXml.length; idx++){
	                        //sheetObjects[idx].RenderSheet(0);
	                        if(idx > 0) {
	                            sheetObjects[idx].SetWaitImageVisible(0);
	                        }
	                        //alert ( sheetObjects[idx].id  +":::"+ arrXml[idx]);
	                        sheetObjects[idx].LoadSearchData(arrXml[idx],{Sync:1} );
	                        //alert(1111);
	                        //sheetObjects[idx].RenderSheet(1);
	                        //alert(2222);
	                    }
		         		frt_term_cd=ComGetEtcData(arrXml[0], "frtTermCd");
               		} else if ( sheetObj.id == "sheet2"){
               			sheetObjects[sheet2_num].WaitImageVisible = false;
	           			formObj.f_cmd.value=SEARCH09;
	           			var aryPrefix=new Array("sheet2_"); //prefix string array
	           			param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value;
 		                sheetObj.DoSearch("ESM_BKG_0668_01GS.do", param + "&" + ComGetPrefixParam(aryPrefix) );
 		               sheetObjects[sheet2_num].WaitImageVisible = true;
               		}

                    break;
    			case COMMAND01:
                    formObj.f_cmd.value=SEARCH01;
                    document.form.xmlData.value=null;
                    param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&cntr_no=" + formObj.cntr_no.value;
                     sheetObj.DoSearch("ESM_BKG_0292GS.do",param + "&" + ComGetPrefixParam("sheet1_") );
    	        	break;
    			case COMMAND02:
                    formObj.f_cmd.value=SEARCH02;
                    document.form.xmlData.value=null;
                    param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&po_no=" + formObj.po_no.value;
                     sheetObj.DoSearch("ESM_BKG_0292GS.do",param + "&" + ComGetPrefixParam("sheet1_") );
		        	break;
    			case COMMAND03:
    				formObj.f_cmd.value=SEARCH03;
            	 	document.form.xmlData.value=null;
                    param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&hbl_no=" + formObj.hbl_no.value;
 		        	sheetObj.DoSearch("ESM_BKG_0668_01GS.do",param + "&" + ComGetPrefixParam("sheet1_") );
		        	break;
                case COMMAND05:
                    formObj.f_cmd.value=SEARCH04;
                    document.form.xmlData.value=null;
                    param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value;
                     sheetObj.DoSearch("ESM_BKG_0292GS.do",param + "&" + ComGetPrefixParam("sheet1_") );
                    break;
            }
        }
        /**
         * set IBTab Object array
         * adding process for list in case of needing batch processing with other items 
         * defining list on the top of source
         */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++]=tab_obj;
        }
        /**
         * initializing Tab
         * Setting Tab items.
         */
        function initTab(tabObj , tabNo) {
        	 switch(tabNo) {
                 case 1:
                    with (tabObj) {
						InsertItem( "B/L Info" , "");
						InsertItem( "Cargo Release" , "");
						InsertItem( "Movement" , "");
						InsertItem( "Customs Result" , "");
						InsertItem( "S/O Info" , "");
						InsertItem( "A/N Sent" , "");
						InsertItem( "Pickup Notice" , "");
						SetSelectedIndex(0);
                    }
                 break;
                 case 2:
                    with (tabObj) {
                        var cnt=0 ;
						InsertItem( "US" , "");
						InsertItem( "General" , "");
						SetSelectedIndex(0);
                    }
                 break;
             }
        }
        /**
         * Event when clicking Tab
         * activating selected tab items.
         */
        function tab1_OnChange(tabObj , nItem)
        {
            var objs=document.all.item("tabLayer");
    	    	objs[nItem].style.display="Inline";
    	    	objs[beforetab].style.display="none";
    	    	//--------------- important --------------------------//
    	    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	    	//------------------------------------------------------//
    	    	beforetab=nItem;
    	    	if (beforetab == 0) {
    	    		if (document.form.mainPage.value != "") {
    	    			fnTabChangeQuery();	//Change when changing tab to check whether query conditions, inquiry viewed module automatically if the conditions have changed to invoke.
    	    		} else {
    	    			document.form.mainPage.value="Y";
    	    		}
    	        } else {
    	        	loadTabPage(beforetab);
    	        }    	    	
        }
        /**
         * Event when clicking Tab
         * activating selected tab items.
         * in B/L Info tab 
         */
        function t1tab1_OnChange(tabObj , nItem)
        {
            var objs=document.all.item("t1tabLayer");
    	    	objs[nItem].style.display="Inline";
    	    	objs[t1beforetab].style.display="none";
    	    	//--------------- important --------------------------//
    	    	objs[t1beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	    	//------------------------------------------------------//
    	    	t1beforetab=nItem;
        }
        /**
         * handling process for input validation
         */
        function validateForm(sheetObj,formObj,sAction){
      		switch(sAction) {       	 
				case IBSEARCH:
					conditionTrim();
					if(ComIsEmpty(combo_bl_no.GetSelectText()) && ComIsEmpty(formObj.bkg_no.value)){
	                    ComShowCodeMessage('BKG40097');
	                    //formObj.combo_bl_no.focus();
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
          * when push the Enter key, performing a retrieve function
          */
         function enterKeySearch(){
             var keyCode=ComGetEvent("keycode")// event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
             var formObject=document.form;
             var srcName=ComGetEvent("name");
             if(ComIsEmpty(srcName)){
                 return;
             }
             // if enter key
             if (keyCode == 13) {
 	            if (srcName == "cntr_no" || srcName == "po_no" || srcName == "hbl_no") {
 	            	obj_deactivate();
 	            } else {
 	            	fnTabChangeQuery();			//retrieve function call.
 	            }
             }            
         }                    
         function t1sheet1_OnSearchEnd(sheetObj, Code , ErrMsg){
      		ComOpenWait(false);
             if (ErrMsg == "") {
                 if(sheetObj.RowCount()> 0){
                     //Data in Grid copy Html value
                     IBS_CopyRowToForm(sheetObj, document.form, 1, "frm_");
                     	//document.form.btn_ts_route.style.cursor='hand';
                     
                      //POD = CA 면 Canada Manifest Details by B/L 버튼 보이게 함
                    if(sheetObj.GetCellValue(1,"t1sheet1_pod_cd") != ""){
                     if (sheetObj.GetCellValue(1,"t1sheet1_pod_cd").substr(0, 2) == "CA") {
                    	 document.getElementById("btn_inquiry2").style.display="Inline"; 
                     } else {
                    	 document.getElementById("btn_inquiry2").style.display="none"; 
                     }
                    }
                     
                     if (sheetObj.GetCellValue(1,"t1sheet1_bdr_flg") == "Y") {
                     	document.form.frm_t1sheet1_bdr_flg.checked=true;
                     } else {
                     	document.form.frm_t1sheet1_bdr_flg.checked=false;
                     }
                     if (sheetObj.GetCellValue(1,"t1sheet1_corr_usr_id") != "Y") {
                     	document.form.frm_t1sheet1_corr_flg.checked=false;
                        document.form.btn_corr_flg.disabled= true;
                        //document.form.btn_corr_flg.style.cursor='default';
                     } else {
                     	document.form.frm_t1sheet1_corr_flg.checked=true;
                        document.form.btn_corr_flg.disabled= false;;
                        //document.form.btn_corr_flg.style.cursor='hand';
                     }
                     //Depending on the value of Partial Set Font Color.
                     if (sheetObj.GetCellValue(1,"t1sheet1_partial") == "Y") {						//if Partial value is Y, Red
                     	document.getElementById("frm_t1sheet1_partial").style.color="red";
                     } else {																	//if Partial value is not Y, Black
                     	document.getElementById("frm_t1sheet1_partial").style.color="";
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
  						var itemindex=combo_bl_no.FindItem( blNo, 0 , true);
 						if (itemindex == -1) {
 							combo_bl_no.RemoveAll();
 							combo_bl_no.InsertItem(-1, blNo, sheetObj.GetCellValue(1,"t1sheet1_bkg_no"));
 							combo_bl_no.SetSelectIndex(0);
 						} else {
 							combo_bl_no.SetSelectCode(itemindex);
 						}
                     }
                     document.form.bkg_no.value=sheetObj.GetCellValue(1,"t1sheet1_bkg_no");
                     if (sheetObj.GetCellValue(1,"t1sheet1_split_flg") == "Y") {
              	    	buttonColorSet('btn_split', 'red');
                    } else {
               	    	buttonColorSet('btn_split', 'gray');
                    }
                     //T/S Route button active
                     document.form.btn_ts_route.disabled= false;;
                     //if Contract No value exist, button active
                     if (sheetObj.GetCellValue(1,"t1sheet1_rfa_no").length > 0) {
                         document.form.btn_contract_no.disabled= false;
                         //document.form.btn_contract_no.style.cursor='hand';
                         document.form.frm_t1sheet1_sc_no.value=sheetObj.GetCellValue(1,"t1sheet1_rfa_no");
                     } else {
                    	 if (sheetObj.GetCellValue(1,"t1sheet1_sc_no").length > 0) {
                             document.form.btn_contract_no.disabled= false;
                             //document.form.btn_contract_no.style.cursor='hand';                		
                             document.form.frm_t1sheet1_sc_no.value=sheetObj.GetCellValue(1,"t1sheet1_sc_no");
                     	} else {
                     		document.form.btn_contract_no.disabled= true;
     	                    //document.form.btn_contract_no.style.cursor='default';
     	                    document.form.frm_t1sheet1_sc_no.value="";
                     	}
                     }
                     // if Consignee No value exist, button active
                     if (sheetObj.GetCellValue(1,"t1sheet1_csg_cust_nm").length == 0) {
                         document.form.btn_consignee.disabled= true;
                         //document.form.btn_consignee.style.cursor='default';
                     } else {
                         document.form.btn_consignee.disabled= false;
                        // document.form.btn_consignee.style.cursor='hand';
                     }
                     //if Notify value exist, button active
                     if (sheetObj.GetCellValue(1,"t1sheet1_noy_cust_nm").length == 0) {
                         document.form.btn_notify.disabled= true;
                        // document.form.btn_notify.style.cursor='default';
                     } else {
                         document.form.btn_notify.disabled= false;
                         //document.form.btn_notify.style.cursor='hand';
                     }
                     //if A.Notify value exist, button active
                     if (sheetObj.GetCellValue(1,"t1sheet1_aoy_cust_nm").length == 0) {
                         document.form.btn_a_notify.disabled= true;
                        // document.form.btn_a_notify.style.cursor='default';
                     } else {
                         document.form.btn_a_notify.disabled= false;
                        // document.form.btn_a_notify.style.cursor='hand';
                     }
                     if (document.form.frm_t1sheet1_noy_cust_cd.value == "0") {
                    	 document.form.frm_t1sheet1_noy_cust_cd.value="";
                     }
                     if (document.form.frm_t1sheet1_aoy_cust_cd.value == "0") {
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
                     addSel(sheetObj);
                     buttonColorSet('btn_c_flag', 'black');
                     buttonColorSet('btn_pu_history', 'black');
                     if (sheetObj.GetCellValue(1,"t1sheet1_instruction") == "Y") {
                    	 buttonColorSet('btn_instruction', 'red');
                     } else {
                    	 buttonColorSet('btn_instruction', 'black');
                     }
                     fnSetHiddenKey();
                 } else {
                	 fnBlInfoClear();
                	 addSelZero();
                 }
             }
         }
         function t1sheet3_OnSearchEnd(sheetObj, Code , ErrMsg){
      		ComOpenWait(false);
        	 cntrQtySum=0;
         	if (ErrMsg == "") {
                 if(sheetObj.RowCount()> 0){
                 	for(var i=1; i<=sheetObj.RowCount(); i++) {
                 		//differ Bkg Qty to Cntr Qty check.
                 		if (sheetObj.GetCellValue(i,"t1sheet3_bkg_qty") != sheetObj.GetCellValue(i,"t1sheet3_cntr_qty")) {
                  			sheetObj.SetCellFont("FontBold", i,"t1sheet3_bkg_qty", i, "t1sheet3_cntr_qty",1);//Bold value set
                  			sheetObj.SetCellFontColor(i, "t1sheet3_bkg_qty" ,"#FF0000");//set Red
                  			sheetObj.SetCellFontColor(i, "t1sheet3_cntr_qty" ,"#FF0000");//set Red
                 		}
                 		//if Bkg Qty and Cntr Qty is prime number, set green bold. 102, 204, 0
                 		if (isFloat(sheetObj.GetCellValue(i,"t1sheet3_bkg_qty")) == true) {
                  			sheetObj.SetCellFont("FontBold", i,"t1sheet3_bkg_qty", i, "t1sheet3_cntr_qty",1);//Bold value set
                  			sheetObj.SetCellFontColor(i, "t1sheet3_bkg_qty" ,"#66CC00");//set Green
                  			sheetObj.SetCellFontColor(i, "t1sheet3_cntr_qty" ,"#66CC00");//set Green
                 		} else if (isFloat(sheetObj.GetCellValue(i,"t1sheet3_cntr_qty")) == true) {
                  			sheetObj.SetCellFont("FontBold", i,"t1sheet3_bkg_qty", i, "t1sheet3_cntr_qty",1);//Bold value set
                  			sheetObj.SetCellFontColor(i, "t1sheet3_bkg_qty" ,"#66CC00");//set Green
                  			sheetObj.SetCellFontColor(i, "t1sheet3_cntr_qty" ,"#66CC00");//set Green
                 		} else {
                 			cntrQtySum=parseInt(cntrQtySum) + parseInt(sheetObj.GetCellValue(i,"t1sheet3_cntr_qty"));
                 		}                 		
                 	}
                 }
         	}
         }
         //Select Box consist of info to ERP
         function addSel(sheetObj) {
             var sel=document.form.tot_ots_amt;
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
     	        	//font color red and bold.
     	        	document.getElementById("tot_ots_amt").className="input2_1";
     	        } else {
     	        	document.getElementById("tot_ots_amt").className="input2";
     	        }
     		} else {
     			document.form['tot_ots_amt'][0]=new Option(sheetObj.GetCellValue(1, prefix+"tot_ots_amt1"));
     			document.getElementById("tot_ots_amt").className="input2_1";
                 return;
             }
         }
         //Set O in tot_ots_amt
         function addSelZero() {
        	 var sel=document.form.tot_ots_amt;
             for (i=sel.length-1; i>=0; i--){
                 sel.options[i]=null
             }
             document.form['tot_ots_amt'][0]=new Option('0', 0);
             document.getElementById("tot_ots_amt").className="input2";
         }
		//Axon event handling2. event handling function --- start
		/**
		 * Keyboard input contol in onkeypress event of HTML Control
		 **/
		function obj_keypress(){
		    switch(ComGetEvent().dataformat){
		        case "float":
		            //number+"." input
		            ComKeyOnlyNumber(ComGetEvent(), ".");
		            break;
		        case "eng":
		            //Only eng input, eng+num -> ComKeyOnlyAlphabet('num');
		            //ComKeyOnlyAlphabet();
		            ComKeyOnlyAlphabet('uppernum');
		            break;
	            case "eng1":
	                //Only eng input, eng+num -> ComKeyOnlyAlphabet('num');
	                //ComKeyOnlyAlphabet(); -_$.
	                ComKeyOnlyAlphabet('uppernum', "45|95|36|46"); 
	                break;		            
		        case "engdn":
		            //Only lower eng input, lower eng+num -> ComKeyOnlyAlphabet('lowernum');
		            ComKeyOnlyAlphabet('lower');
		            break;
		        case "engup":
		            //Only upper eng input, upper eng+num -> ComKeyOnlyAlphabet('uppernum');
		            ComKeyOnlyAlphabet('upper');
		            break;
		        default:	
		            //Only num input(num,date,time)
		            ComKeyOnlyNumber(ComGetEvent());
		    }
		}
        function obj_deactivate(){
         	switch(ComGetEvent("name")){
	    	case "cntr_no":
	    		//check cntr_no
	    		if(ComIsEmpty(document.form.cntr_no.value)){
	    			document.form.h_cntr_no.value="";
	    			return false;
                }
	    		if (!(document.form.cntr_no.value.length == 10 || document.form.cntr_no.value.length == 11)) {
	    			ComShowCodeMessage('BKG00700');
	    			return false;
	    		}
	    		//check to cntr no equal previously entered value
	    			document.form.xmlData.value=null;
	    			sheetObjects[sheetObjects.length-1].RemoveAll();
	    			conditionReset();
	    			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND01);
	    			document.form.h_cntr_no.value=document.form.cntr_no.value;
	        	break;
	    	case "po_no":	    		
	    		//check PO no
	    		if(ComIsEmpty(document.form.po_no.value)){
	    			document.form.h_po_no.value="";
	    			return false;
                }
	    		//check to cntr no equal previously entered value
	    			document.form.xmlData.value=null;
	    			sheetObjects[sheetObjects.length-1].RemoveAll();
	    			conditionReset();
	    			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND02);
	    			document.form.h_po_no.value=document.form.po_no.value;
	        	break;
	    	case "hbl_no":	    		
	    		//check HBL NO
	    		if(ComIsEmpty(document.form.hbl_no.value)){
	    			document.form.h_hbl_no.value="";
	    			return false;
                }
	    		//check to cntr no equal previously entered value
	    			document.form.xmlData.value=null;
	    			sheetObjects[sheetObjects.length-1].RemoveAll();
	    			conditionReset();
	    			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND03);
	    			document.form.h_hbl_no.value=document.form.hbl_no.value;
	        	break;
         	}
        }
        /**
         * if BL_NO typing, BKG_NO. CNTR_NO Initialization<br>
         **/
        function conditionReset(){
        	 if (ComGetEvent("name") == "bl_no") {
                document.getElementById("hbl_no").value='';
                document.getElementById("bkg_no").value='';
                document.getElementById("cntr_no").value='';
                document.getElementById("po_no").value='';
                document.getElementById("h_cntr_no").value='';
                document.getElementById("h_po_no").value='';
                document.getElementById("h_hbl_no").value='';
                buttonColorSet('btn_split', 'gray');
            }else if (ComGetEvent("name") == "bkg_no") {
                document.getElementById("hbl_no").value='';
                document.getElementById("bl_no").value='';
                document.getElementById("cntr_no").value='';
                document.getElementById("po_no").value='';
                combo_bl_no.RemoveAll();
                combo_bl_no.SetSelectText('');
                combo_bl_no.SetBackColor("#FFFFFF");
                combo_bl_no.SetFontColor("#000000");
                document.getElementById("h_cntr_no").value='';
                document.getElementById("h_po_no").value='';
                document.getElementById("h_hbl_no").value='';
                buttonColorSet('btn_split', 'gray');
            }else if (ComGetEvent("name") == "cntr_no") {
                document.getElementById("hbl_no").value='';
                document.getElementById("bl_no").value='';
                document.getElementById("bkg_no").value='';
                combo_bl_no.RemoveAll();
                combo_bl_no.SetSelectText('');
                combo_bl_no.SetBackColor("#FFFFFF");
                combo_bl_no.SetFontColor("#000000");
                document.getElementById("po_no").value='';
                document.getElementById("h_cntr_no").value='';
                document.getElementById("h_po_no").value='';
                document.getElementById("h_hbl_no").value='';
                buttonColorSet('btn_split', 'gray');
            }else if (ComGetEvent("name") == "hbl_no") {
                document.getElementById("bl_no").value='';
                document.getElementById("bkg_no").value='';
                document.getElementById("cntr_no").value='';
                document.getElementById("po_no").value='';
                combo_bl_no.RemoveAll();
                combo_bl_no.SetSelectText('');
                combo_bl_no.SetBackColor("#FFFFFF");
                combo_bl_no.SetFontColor("#000000");
                document.getElementById("h_cntr_no").value='';
                document.getElementById("h_po_no").value='';
                document.getElementById("h_hbl_no").value='';
                buttonColorSet('btn_split', 'gray');
            }else if (ComGetEvent("name") == "po_no") {
                document.getElementById("hbl_no").value='';
                document.getElementById("bl_no").value='';
                document.getElementById("bkg_no").value='';
                document.getElementById("cntr_no").value='';
                combo_bl_no.RemoveAll();
                combo_bl_no.SetSelectText('');
                combo_bl_no.SetBackColor("#FFFFFF");
                combo_bl_no.SetFontColor("#000000");
                document.getElementById("h_cntr_no").value='';
                document.getElementById("h_po_no").value='';
                document.getElementById("h_hbl_no").value='';
                buttonColorSet('btn_split', 'gray');
            }
        }
         /**
          * Screen clear and Button initialization.
          */
         function fnAllClear () {
             //all input items clear.	
             for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
                	document.form.getElementsByTagName("input")[i].value="";      
             }
             //all check items clear.
             document.form.frm_t1sheet1_bdr_flg.checked=false;
             document.form.frm_t1sheet1_corr_flg.checked=false;
             combo_bl_no.RemoveAll();
             combo_bl_no.SetSelectText('');
             combo_bl_no.SetBackColor("#FFFFFF");
             combo_bl_no.SetFontColor("#000000");
              var selOtsAmt=document.form.tot_ots_amt;
     	     for (i=selOtsAmt.length-1; i>=0; i--){
     	    	 selOtsAmt.options[i]=null
     	     }
     	     //Outstanding Demurrage Per B/L ??��??Clear?�다.
              var selDemAmt=document.form.tot_bil_amt;
     	     for (i=selDemAmt.length-1; i>=0; i--){
     	    	 selDemAmt.options[i]=null
     	     }
     	     //all ibSheet clear.
     	     for(i=0;i<sheetObjects.length;i++){
     	    	 sheetObjects[i].RemoveAll();
              }
     	     //BL_no focus on
     	     //document.form.combo_bl_no.focus();
    	     //popup button Disable
    	     fnButtonInit();
         }
         /**
          * after retrieve Hidden IBSheet, handling
          */
          function sheet1_OnSearchEnd(sheetObj, Code , ErrMsg){
       		ComOpenWait(false);
        	  var blNo=null;
              if (ErrMsg == "") {
             	 if(sheetObj.RowCount()> 1){
                      blSelectPopOpen(sheetObj);
                  } else if (sheetObj.RowCount()== 1){
                	  if (sheetObj.GetCellValue(1,"sheet1_bl_tp_cd") != "B") {
                		  blNo=sheetObj.GetCellValue(1,"sheet1_bl_no") + sheetObj.GetCellValue(1,"sheet1_bl_tp_cd");
                	  } else {
                		  blNo=sheetObj.GetCellValue(1,"sheet1_bl_no");
                	  }
                	  document.getElementById("bkg_no").value=sheetObj.GetCellValue(1,"sheet1_bkg_no");
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
           * Validation check in onfocus event of HTML Control. <br>
           **/
          function blSelectPopOpen(){
              var sXml=IBS_GetDataSearchXml(sheetObjects[sheetObjects.length-1]);
              document.form.xmlData.value=sXml;
              ComOpenPopup("/opuscntr/ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
          }
          /**
           * selected value in BL_NO SELECT BOX set to BKG_NO<br>
           * selected value color change.
           **/
          function blNoSelect(idx){
        	  document.getElementById("bkg_no").value=sheetObjects[sheetObjects.length-1].GetCellValue(idx, "sheet1_bkg_no");
        	  document.getElementById("bl_no").value=sheetObjects[sheetObjects.length-1].GetCellValue(idx, "sheet1_bl_no");
              var length=document.getElementsByName("hdn_bl_no").length;
              if(document.getElementsByName("hdn_bl_no").length > 1){
                  for(var i=1; i<=length; i++){
                      if(i==idx){
                          document.all.hdn_bl_no[i-1].style.backgroundColor='#4169E1';
                          document.all.hdn_bl_no[i-1].style.color='#FFFFFF';
                      }else{
                          document.all.hdn_bl_no[i-1].style.backgroundColor='#FFFFFF';
                          document.all.hdn_bl_no[i-1].style.color='black';
                      }
                  }
              }
          }
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
              if (itemindex>-1) {        
            	  combo_bl_no.SetSelectIndex(itemindex);
              }
              if (sheetObjects[sheetObjects.length-1].RowCount()> 1) {
            	  combo_bl_no.SetBackColor("#00FFFF");
          	  } else {
          		combo_bl_no.SetBackColor("#FFFFFF");
          	  }
          }          
          function combo_bl_no_OnChange(comboObj, oldindx, oldtext , oldcode , newindx , Text ,Index_Code){
        	  conditionTrim();
              if (comboFlg != true) {
            	  if (Text.length > 0) {
            		  document.getElementById("bkg_no").value=Index_Code;
                      if (Index_Code == "") {
                      	  document.getElementById("bl_no").value='';
            	          document.getElementById("cntr_no").value='';
            	          document.getElementById("po_no").value='';
            	          document.getElementById("hbl_no").value='';
            	          document.getElementById("h_cntr_no").value='';
            	          document.getElementById("h_po_no").value='';
            	          document.getElementById("h_hbl_no").value='';
            	    	  document.getElementById("bkg_no").value='';    	
                          buttonColorSet('btn_split', 'gray');
                      }
            	  }
              } else {
              	  comboFlg=false;
              }
              fnSetComboText();              
          }          
          function combo_bl_no_OnKeyDown(comboObj, KeyCode, Shift){
        	if (KeyCode == 13 || KeyCode == 8) {
        	} else {
            	document.getElementById("bl_no").value='';
    	        document.getElementById("cntr_no").value='';
    	        document.getElementById("po_no").value='';
    	        document.getElementById("hbl_no").value='';
    	        document.getElementById("h_cntr_no").value='';
    	        document.getElementById("h_po_no").value='';
    	        document.getElementById("h_hbl_no").value='';
    	    	document.getElementById("bkg_no").value='';    	
                buttonColorSet('btn_split', 'gray');
        	}
        }
          /**
           * TRiC SELECT BOX set.
           */
          function conditionSet(aryPopupData){
              if(aryPopupData != undefined){
                  document.getElementById("bl_no").value=aryPopupData[0][3];
                  document.getElementById("bkg_no").value=aryPopupData[0][5];
                  blComboSet(aryPopupData[0][3]);            
              }
          }          
        function t1sheet1_1_OnSearchEnd(sheetObj, Code, ErrMsg){
     		ComOpenWait(false);
        	var wgt_sum=0;
        	var pkg_sum=0;
        	var prefix="t1sheet1_1";
            if (ErrMsg == "") {
                if(sheetObj.RowCount()> 0){
                	wgt_sum=sheetObj.ComputeSum("|10|");
                	pkg_sum=sheetObj.ComputeSum("|12|");
    
                	document.getElementById("frm_t1sheet1_1_cntr_cnt").value=ComAddComma(sheetObj.RowCount());
                	document.getElementById("frm_t1sheet1_1_wgt_sum").value=ComAddComma(wgt_sum);
                	document.getElementById("frm_t1sheet1_1_pkg_sum").value=ComAddComma(pkg_sum);
                	for(var j=1; j<=sheetObj.RowCount(); j++) {

                		sheetObj.SetCellValue(j+1, "t1sheet1_1_cntr_wgt",ComAddComma(sheetObj.GetCellValue(j+1, "t1sheet1_1_cntr_wgt")));
                		sheetObj.SetCellValue(j+1, "t1sheet1_1_pck_qty",ComAddComma(sheetObj.GetCellValue(j+1, "t1sheet1_1_pck_qty")));
                		
                		if (parseFloat(ComReplaceStr(sheetObj.GetCellValue(j+1,"t1sheet1_1_cntr_wgt"), ",","")) > 45000) {
                 			sheetObj.SetCellFont("FontBold", j+1,"t1sheet1_1_cntr_wgt",1);//Bold 값을 ?�정
                 			sheetObj.SetCellFontColor(j+1, "t1sheet1_1_cntr_wgt" ,"#FF0000");//set red
                		}
                	}
                } else {
              	    document.getElementById("frm_t1sheet1_1_cntr_cnt").value='0';
       	            document.getElementById("frm_t1sheet1_1_wgt_sum").value='0';
       	            document.getElementById("frm_t1sheet1_1_pkg_sum").value='0';
                }
            }    
        } 
        /**
         * Seal No set ComboBox
         */
         function t1sheet5_OnSearchEnd(sheetObj, Code , ErrMsg){
      		ComOpenWait(false);
       	    var t1sheet5_cntr_no=null;
         	var t1sheet5_cntr_seal_no=null;
         	var temp_cntr_no=null;
       	    var t1sheet3_cntr_no=null;
       	    var prefix6="t1sheet5_";
       	    var prefix3="t1sheet1_2_";
       	    var bStart=true;
            if (ErrMsg == "") {
                if (sheetObj.RowCount() > 0 && sheetObjects[t1sheet1_2_num].RowCount() > 0) {
                    for(i=0;i<sheetObj.RowCount();i++){
                    	t1sheet5_cntr_no=sheetObj.GetCellValue(i+1,prefix6+ "cntr_no");
                    	
                   	    if (temp_cntr_no != t1sheet5_cntr_no) {
                   		    if (bStart != true) {
                       		    setCntrSeslNo(temp_cntr_no, t1sheet5_cntr_seal_no);
                       	    } else {
                       		    bStart=false;
                       	    }
                   		    if (sheetObj.GetCellValue(i+1,prefix6+ "cntr_seal_no") != "") {
                   		    	t1sheet5_cntr_seal_no=sheetObj.GetCellValue(i+1,prefix6+ "cntr_seal_no");
                       	    }
                   		    temp_cntr_no=t1sheet5_cntr_no;
                   	    } else {
                   	    	if (sheetObj.GetCellValue(i+1,prefix6+ "cntr_seal_no") != "") {
                   	    		t1sheet5_cntr_seal_no=t1sheet5_cntr_seal_no + "|" + sheetObj.GetCellValue(i+1,prefix6+ "cntr_seal_no");
                   	    		t1sheet5_cntr_no=t1sheet5_cntr_seal_no + "|" + sheetObj.GetCellValue(i+1,prefix6+ "cntr_no");
                       	    }
                   	    }
                    }

                   	if (t1sheet5_cntr_seal_no != "") {
               		    setCntrSeslNo(temp_cntr_no, t1sheet5_cntr_seal_no);
                    }
                   	
           	    }
            }
         }
         function setCntrSeslNo(cntrNo, sealNo) {
       	     var t1sheet1_2_cntr_no=null;
       	     var prefix="t1sheet1_2_";
       	     for(k=0;k<sheetObjects[t1sheet1_2_num].RowCount();k++){
       		     t1sheet1_2_cntr_no = sheetObjects[t1sheet1_2_num].GetCellValue(k+1,prefix+ "cntr_no");

       		     if (t1sheet1_2_cntr_no == cntrNo) {
       		    	 if (sealNo != null) {
       		    		 
       		    		var arrSeal=sealNo.split("|");
       		    		 
     			    	 sheetObjects[t1sheet1_2_num].CellComboItem(k+1, prefix + "cntr_seal_no", {"ComboText":sealNo, "ComboCode":sealNo});
                 		 sheetObjects[t1sheet1_2_num].SetCellBackColor(k+1, prefix + "cntr_seal_no", "#EFEBEF");
                 		 sheetObjects[t1sheet1_2_num].SetCellValue(k+1, prefix + "cntr_seal_no", arrSeal[0]);
       		    	 }
       			     break;
       		     }
       	     }
         }
         function sheet2_OnSearchEnd(sheetObj, Code , ErrMsg){
      		ComOpenWait(false);
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
                    	 combo_bl_no.SetSelectIndex(0);
                     } else {
 						var itemindex=combo_bl_no.FindItem( blNo, 0 , true);
 						if (itemindex == -1) {
 							combo_bl_no.RemoveAll();
 							combo_bl_no.InsertItem(-1, blNo, sheetObj.GetCellValue(1,"sheet2_bkg_no"));
 							combo_bl_no.SetSelectIndex(0);
 						} else {
 							combo_bl_no.SetSelectIndex(itemindex);
 						}
                     }
                    if (combo_bl_no.GetItemCount() > 1) {
                     	combo_bl_no.SetBackColor("#00FFFF");
                 	} else {
                 		combo_bl_no.SetBackColor("#FFFFFF");
                 	}
                    document.form.bkg_no.value=sheetObj.GetCellValue(1,"sheet2_bkg_no");
                    if (sheetObj.GetCellValue(1,"sheet2_split_flg") == "Y") {
						buttonColorSet('btn_split', 'red');
                     } else {
						buttonColorSet('btn_split', 'gray');
                     }
                     fnSetHiddenKey();
                 }
                 var objTabWindow=document.getElementById("t" + (beforetab+1) + "frame").contentWindow;        
                 if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {                  
	                 if(beforetab == 1){//Cargo Release
	                	 t2frame.location.href="/opuscntr/ESM_BKG_0668_09.do?bl_no=" + sheetObj.GetCellValue(1,"sheet2_bl_no");
	                 } else if(beforetab == 2){
	                	 t3frame.location.href="/opuscntr/ESM_BKG_0668_03.do?bkg_no=" + sheetObj.GetCellValue(1,"sheet2_bkg_no");
	                 } else if(beforetab == 3){
	                	 t4frame.location.href="/opuscntr/ESM_BKG_0668_05.do?bkg_no=" + sheetObj.GetCellValue(1,"sheet2_bkg_no");
	                 } else if(beforetab == 4){
	                	 t5frame.location.href="/opuscntr/ESM_BKG_0668_08.do?bkg_no=" + sheetObj.GetCellValue(1,"sheet2_bkg_no");
	                 } else if(beforetab == 5){
	                	 t6frame.location.href="/opuscntr/ESM_BKG_0668_06.do?bkg_no=" + sheetObj.GetCellValue(1,"sheet2_bkg_no") + "&bl_no=" + sheetObj.GetCellValue(1,"sheet2_bl_no");
	                 } else if(beforetab == 6){
	                	 t7frame.location.href="/opuscntr/ESM_BKG_0668_07.do?bkg_no=" + sheetObj.GetCellValue(1,"sheet2_bkg_no") + "&bl_no=" + sheetObj.GetCellValue(1,"sheet2_bl_no");
	                 }
                 } else {
	                 if(beforetab == 1){//Cargo Release
	                	 t2frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bl_no"));
	                 } else if(beforetab == 2){
	                	 t3frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bkg_no"));
	                 } else if(beforetab == 3){
	                	 t4frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bkg_no"));
	                 } else if(beforetab == 4){
	                	 t5frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bkg_no"));
	                 } else if(beforetab == 5){
	                	 t6frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bkg_no"), sheetObj.GetCellValue(1,"sheet2_bl_no"));
	                 } else if(beforetab == 6){
	                	 t7frame.fnQueryExec(sheetObj.GetCellValue(1,"sheet2_bkg_no"), sheetObj.GetCellValue(1,"sheet2_bl_no"));
	                 }                	 
                 }
             } else {
                 if(beforetab == 1){//Cargo Release
                	 t2frame.location.href="/opuscntr/ESM_BKG_0668_09.do?bl_no=" + "";
                 } else if(beforetab == 2){
                     t3frame.location.href="/opuscntr/ESM_BKG_0668_03.do?bkg_no=" + "";            	
                 } else if(beforetab == 3){
                     t4frame.location.href="/opuscntr/ESM_BKG_0668_05.do?bkg_no=" + "";           	
                 } else if(beforetab == 4){
                     t5frame.location.href="/opuscntr/ESM_BKG_0668_08.do?bkg_no=" + "";           	
                 } else if(beforetab == 5){
                     t6frame.location.href="/opuscntr/ESM_BKG_0668_06.do?bkg_no=" + "" + "&bl_no=" + "";
                 } else if(beforetab == 6){
                     t7frame.location.href="/opuscntr/ESM_BKG_0668_07.do?bkg_no=" + "" + "&bl_no=" + "";           	
                 }
             }
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
             case 1:
                 sUrl="ESM_BKG_0668_09.do";
                 if (t1BkgNo != bkgNo || t1BlNo != blNo) {
                	 queryYn="Y";
                	 t1BkgNo=bkgNo;
                	 t1BlNo=blNo;
                 }
                 break;
             case 2:
                 sUrl="ESM_BKG_0668_03.do"; 
                 if (t2BkgNo != bkgNo || t2BlNo != blNo) {
                	 queryYn="Y";
                	 t2BkgNo=bkgNo;
                	 t2BlNo=blNo;
                 }
                 break;
             case 3:
                 sUrl="ESM_BKG_0668_05.do"; 
                 if (t3BkgNo != bkgNo || t3BlNo != blNo) {
                	 queryYn="Y";
                	 t3BkgNo=bkgNo;
                	 t3BlNo=blNo;            	 
                 }
                 break;
             case 4:
                 sUrl="ESM_BKG_0668_08.do"; 
                 if (t4BkgNo != bkgNo || t4BlNo != blNo) {
                	 queryYn="Y";
                	 t4BkgNo=bkgNo;
                	 t4BlNo=blNo;            	 
                 }
                 break;
             case 5:
                 sUrl="ESM_BKG_0668_06.do"; 
                 if (t5BkgNo != bkgNo || t5BlNo != blNo) {
                	 queryYn="Y";
                	 t5BkgNo=bkgNo;
                	 t5BlNo=blNo;            	 
                 }
                 break;
             case 6:
                 sUrl="ESM_BKG_0668_07.do"; 
                 if (t6BkgNo != bkgNo || t6BlNo != blNo) {
                	 queryYn="Y";
                	 t6BkgNo=bkgNo;
                	 t6BlNo=blNo;            	 
                 }
                 break;
             }
             var objTabWindow=document.getElementById("t" + (tabIndex+1) + "frame").contentWindow;        
             if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {             
            	 if (bkgNo != "" || blNo != "") {            	 
            		 if (queryYn == "Y") {
            			 objTabWindow.location.href=sUrl;
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
         * isFloat(str) : check number value, '.' contain
         */ 
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
 	    function fnSetComboText() {
 	    	var blNo=combo_bl_no.GetSelectText();
 	    	if (ComIsEmpty(blNo) == false) {
 	 	    	var strTemp=blNo.substr(blNo.length-1);
	 	    	if (strTemp == "W") {
	 	    		combo_bl_no.SetFontColor("Blue");
	 	    	} else if (strTemp == "S") {
	 	    		combo_bl_no.SetFontColor("Red");
	 	    	} else {
	 	    		combo_bl_no.SetFontColor("#000000");
	 	    	}
 	    	}
 	    }

 	    function combo_bl_no_OnClear(blCombo) {
 		//  blCombo.SetBackColor("#FFFFFF");
 		//  blCombo.SetFontColor("#000000");
 	   }
       /**
        * after t1sheet1_2 retrieve, set value
        */
        function t1sheet1_2_OnSearchEnd(sheetObj, Code , ErrMsg){
     		ComOpenWait(false);
        	var invTotBilAmt=0;
        	if (ErrMsg == "") {
                if(sheetObj.RowCount()> 0){
                	if (cntrQtySum > 0 && isFloat(cntrQtySum) == false) {				
                		if (cntrQtySum != sheetObj.RowCount()) {
                			for(var i=1; i<=sheetObjects[t1sheet3_num].RowCount(); i++) {
                				sheetObjects[t1sheet3_num].SetCellFont("FontBold", i,"t1sheet3_bkg_qty", i, "t1sheet3_cntr_qty",1);//set Bold value
                				sheetObjects[t1sheet3_num].SetCellFontColor(i, "t1sheet3_bkg_qty" ,"#0000FF");//set blue
                				sheetObjects[t1sheet3_num].SetCellFontColor(i, "t1sheet3_cntr_qty" ,"#0000FF");//set blue
                			}
                		}
                	}
                	for(var j=1; j<=sheetObj.RowCount(); j++) {
                		if (parseFloat(ComReplaceStr(sheetObj.GetCellValue(j,"t1sheet1_2_cntr_wgt"), ",","")) > 44000) {
                 			sheetObj.SetCellFont("FontBold", j,"t1sheet1_2_cntr_wgt",1);//set Bold value
                 			sheetObj.SetCellFontColor(j, "t1sheet1_2_cntr_wgt" ,"#FF0000");//set red
                		}
                		invTotBilAmt += parseInt(t1sheet1_2.GetCellValue(j, "t1sheet1_2_paid_amt"));	//??준 것을 ?�?�함
                		/*if (sheetObj.GetCellValue(j, "t1sheet1_2_dcgo_flg") == "Y") {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_dcgo_flg",0);
						} else {
 							sheetObj.PopupButtonImage(j, "t1sheet1_2_dcgo_flg" , 1);
						}
                		if (sheetObj.GetCellValue(j, "t1sheet1_2_bb_cgo_flg") == "Y") {
 							sheetObj.PopupButtonImage(j, "t1sheet1_2_bb_cgo_flg" , 0);
						} else {
 							sheetObj.PopupButtonImage(j, "t1sheet1_2_bb_cgo_flg" , 1);
						}
                		if (sheetObj.GetCellValue(j, "t1sheet1_2_in_ga_flg") == "OUT") {
 							sheetObj.PopupButtonImage(j, "t1sheet1_2_in_ga_flg" , 0);
						} else {
 							sheetObj.PopupButtonImage(j, "t1sheet1_2_in_ga_flg" , 1);
						}
                		if (sheetObj.GetCellValue(j, "t1sheet1_2_cdo_temp") == "N") {
 							sheetObj.PopupButtonImage(j, "t1sheet1_2_cdo_temp" ,1);
						} else {
 							sheetObj.PopupButtonImage(j, "t1sheet1_2_cdo_temp" , 0);
						}       */         	
                	}
                	document.form.invTotBilAmt.value=invTotBilAmt;
                }
        	}        	
        }
	    /**
	     * after Hidden IBSheet retrieved, handling
	     */
	    function t1sheet6_OnSearchEnd(sheetObj, Code , ErrMsg){
     		ComOpenWait(false);

	        var sel=document.form.tot_bil_amt;
	        var prefix="t1sheet6_";
	        //SELECT BOX clear
	        for (i=sel.length-1; i>=0; i--){
	            sel.options[i]=null
	        }
	        var currCd="";
	        var bilAmt="";
	        var invTotBilAmt="";
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
		            document.getElementById("tot_bil_amt").className="input2_1";
		   	  	} else {
		            document.getElementById("tot_bil_amt").className="input2";
		   	  	}
	        } else {
	            document.form['tot_bil_amt'][0]=new Option('0');
	            document.getElementById("tot_bil_amt").className="input2";
	        }			        
	    }
     /**
     * button disable
     */
    function buttonColorSet(btn_name, color){
     	var curFlag=null;
	   	if (color == 'red' || color == 'black') {
	   		curFlag="hand";
	   	} else {
	   		curFlag="default";
	   	}
    	var obj = document.getElementById(btn_name);
    	obj.style.color=color;
    	obj.style.cursor=curFlag;
       	 
       	 if (btn_name == "btn_split") {
       		 document.form.h_split.value=color;
       	 }
    }
     function fnButtonInit() {
    	document.form.btn_ts_route.disabled= true;
    	document.form.btn_corr_flg.disabled= true;
    	document.form.btn_contract_no.disabled= true;
    	document.form.btn_consignee.disabled= true;
    	document.form.btn_notify.disabled= true;
    	document.form.btn_a_notify.disabled= true;
    	buttonColorSet('btn_split', 'gray');
    	buttonColorSet('btn_c_flag', 'gray');
    	buttonColorSet('btn_instruction', 'gray');
    	buttonColorSet('btn_pu_history', 'gray');
        document.form.btn_ts_route.style.cursor='default';            
        document.form.btn_corr_flg.style.cursor='default';
        document.form.btn_contract_no.style.cursor='default';
        document.form.btn_consignee.style.cursor='default';
        document.form.btn_notify.style.cursor='default';
        document.form.btn_a_notify.style.cursor='default';
    }
    function t1sheet1_2_OnClick(sheetObj, Row, Col){
		var prefix1="t1sheet1_";
		var prefix3="t1sheet1_2_";
		var param=null;
		var bl_no=null;
		var bkg_no=null;
		var bl_tp_cd=null;
		var cntr_no=null;
		bl_no = sheetObjects[t1sheet1_num].GetCellValue(1, prefix1 + "bl_no");
		bkg_no = sheetObjects[t1sheet1_num].GetCellValue(1, prefix1 + "bkg_no");
		bl_tp_cd = sheetObjects[t1sheet1_num].GetCellValue(1, prefix1 + "bl_tp_cd");
        cntr_no = sheetObjects[t1sheet1_2_num].GetCellValue(Row, prefix3 + "cntr_no");
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
                    ComOpenWindow("/opuscntr/ESM_BKG_0659.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:810px;dialogHeight:400px;dialogLeft:0;dialogTop:0", true);
				}
			} else if (sheetObj.ColSaveName(Col) == prefix3 + "bb_cgo_flg") {
				if (sheetObj.GetCellValue(Row, prefix3 + "bb_cgo_flg") == "Y") {
					param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
					param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
                    ComOpenWindow("/opuscntr/ESM_BKG_0660.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:710px;dialogHeight:380px;dialogLeft:0;dialogTop:0", true);
				}
			} else if (sheetObj.ColSaveName(Col) == prefix3 + "in_ga_flg") {
				if (sheetObj.GetCellValue(Row, prefix3 + "in_ga_flg") == "OUT") {
					param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
					param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
                    ComOpenWindow("/opuscntr/ESM_BKG_0661.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:755px;dialogHeight:300px;dialogLeft:0;dialogTop:0", true);
				}
			}else if (sheetObj.ColSaveName(Col) == prefix3 + "cdo_temp") {
				if (sheetObj.GetCellValue(Row, prefix3 + "cdo_temp") != "N") {
					param="?bl_no="+bl_no+"&bkg_no="+bkg_no;
					param+="&bl_tp_cd="+bl_tp_cd+"&cntr_no="+cntr_no;
//					ComOpenWindow("/opuscntr/ESM_BKG_0498.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:500px;dialogLeft:0;dialogTop:0", true);
                    ComOpenWindow("/opuscntr/ESM_BKG_0498_POP.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1224px;dialogHeight:550px;dialogLeft:0;dialogTop:0", true);
				}
			}
		}
    }
    /**
    * OnDblClick event handling : retrieve invoice info
    */
   function t1sheet1_2_OnDblClick(sheetObj, row, col){
	   //set cntr_no
	   var click_cntr_no=sheetObj.GetCellValue(row, "t1sheet1_2_cntr_no");
       //call popup
       demDtlPopOpen(click_cntr_no);
   }    
     function fnBlInfoClear() {
        //all input items clear.   
        for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
            if (document.form.getElementsByTagName("input")[i].name.substr(0, 12) == "frm_t1sheet1") {
            	document.form.getElementsByTagName("input")[i].value="";
            }     
        }
        //all check items Clear   
        document.form.frm_t1sheet1_bdr_flg.checked=false;
        document.form.frm_t1sheet1_corr_flg.checked=false;
         //Outstanding Amount items Clear
         var selOtsAmt=document.form.tot_ots_amt;
         for (i=selOtsAmt.length-1; i>=0; i--){
             selOtsAmt.options[i]=null
         }
         //Outstanding Demurrage Per B/L items Clear.
         var selDemAmt=document.form.tot_bil_amt;
         for (i=selDemAmt.length-1; i>=0; i--){
             selDemAmt.options[i]=null
         }
         try {
             oTbl.removeNode(true);
         }catch(e){}         
     	sheetObjects[t1sheet1_num].RemoveAll();
    	sheetObjects[t1sheet3_num].RemoveAll();
    	sheetObjects[t1sheet5_num].RemoveAll();
    	sheetObjects[t1sheet6_num].RemoveAll();
    	sheetObjects[t1sheet1_1_num].RemoveAll();
    	sheetObjects[t1sheet1_2_num].RemoveAll();
        //popup button Disable.
        fnButtonInit();
    }
    // BL No and BKG No set to hidden value
    function fnSetHiddenKey() {
    	var formObj=document.form;
    	formObj.h_old_bl_no.value= combo_bl_no.GetSelectText();
    	formObj.h_old_bkg_no.value=formObj.bkg_no.value;
    }
    //if tab change and search condition change, call retrieve module
    function fnTabChangeQuery() {
    	var formObj=document.form;
    	// if BL no and BKG no in Hidden differ to BL no and BKG noin screen, retrieve. 
    	if (formObj.h_old_bl_no.value != combo_bl_no.GetSelectText() ||
    			formObj.h_old_bkg_no.value != formObj.bkg_no.value) {
    		fnBlInfoClear();
    		fnSearch();		//call search module.
    	} else {
    		if (combo_bl_no.GetSelectText() != '' || formObj.bkg_no.value != '') {
        		if(beforetab == 0){//B/L Info
        			if (t1sheet1.RowCount()== 0) {
                    	fnSearch();		//call search module.
                    }
                }else {
                	fnSearch();		//call search module.
                }
    		}
    	}
    }
    //manage search module.
    function fnSearch() {
    	if(beforetab == 0){//B/L Info
    		doActionIBSheet(sheetObjects[t1sheet1_num],document.form,IBSEARCH);
		}else {
			doActionIBSheet(sheetObjects[sheet2_num],document.form,IBSEARCH,"","");
		}
    }
    //Except for the current query and select the Tab is controlled to prevent..
    function fnTabEnable(flag) {
    	var formObj=document.form;
    	if (flag == false) {
    		tab1.SetEnable(0);
    	} else {
    		tab1.SetEnable(1);
    	}
    }
     /**
      * Search Criteria Clear.
      */
     function fnQueryCondClear() {
         combo_bl_no.RemoveAll();
         combo_bl_no.SetSelectText("");
         combo_bl_no.SetBackColor("#FFFFFF");
         document.form.bkg_no.value="";
         document.form.cntr_no.value="";
         document.form.po_no.value="";
         document.form.hbl_no.value="";
     }
      /**
      * after Hidden IBSheet retrieve, handling
      */
      function t1sheet1_3_OnSearchEnd(sheetObj , Code , msg){
   		ComOpenWait(false);
   		if (sheetObj.RowCount()< 1 ) return;
   		var invTotBilAmt=0;
         //set cntr_no
         var fist_cntr_no = sheetObjects[t1sheet1_3_num].GetCellValue(1, "t1sheet1_3_cntr_no");
         for(var idx=1; idx <= sheetObj.RowCount(); idx++){
             if(fist_cntr_no != sheetObjects[t1sheet1_3_num].GetCellValue(idx, "t1sheet1_3_cntr_no")){
                 sheetObjects[t1sheet1_3_num].SetRowHidden(idx, 1);
             }
         }
     }
     /**
      * DEM.DET detail info popup
      */
     function demDtlPopOpen(cntr_no){
         var sXml=IBS_GetDataSearchXml(sheetObjects[t1sheet1_3_num]);
         document.form.demDtlXmlData.value=sXml;
         var condition="?";
             condition += "cntr_no="+cntr_no;
         ComOpenWindowCenter('/opuscntr/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
     }
      /**
       * blank remove.
       */
      function conditionTrim(){
     	  combo_bl_no.SetSelectText(combo_bl_no.GetSelectText().trim());
     	  document.getElementById("bl_no").value=document.getElementById("bl_no").value.trim();
     	  document.getElementById("bkg_no").value=document.getElementById("bkg_no").value.trim();
     	  document.getElementById("cntr_no").value=document.getElementById("cntr_no").value.trim();
      }

         function fnSelectCntrPoQuery(name){
         	switch(name){
	    	case "cntr_no":
	    		//check cntr_no
	    		if(ComIsEmpty(document.form.cntr_no.value)){
	    			document.form.h_cntr_no.value="";
	    			return false;
                }
	    		if (!(document.form.cntr_no.value.length == 10 || document.form.cntr_no.value.length == 11)) {
	    			ComShowCodeMessage('BKG00700');
	    			return false;
	    		}
	    		//check to cntr no equal previously entered value
	    			document.form.xmlData.value=null;
	    			sheetObjects[sheetObjects.length-1].RemoveAll();
	    			conditionReset();
	    			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND01);
	    			document.form.h_cntr_no.value=document.form.cntr_no.value;
	        	break;
	    	case "po_no":	    		
	    		//check PO no
	    		if(ComIsEmpty(document.form.po_no.value)){
	    			document.form.h_po_no.value="";
	    			return false;
                }
	    		//check to cntr no equal previously entered value
	    			document.form.xmlData.value=null;
	    			sheetObjects[sheetObjects.length-1].RemoveAll();
	    			conditionReset();
	    			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND02);
	    			document.form.h_po_no.value=document.form.po_no.value;
	        	break;
	    	case "hbl_no":	    		
	    		//check HBL NO
	    		if(ComIsEmpty(document.form.hbl_no.value)){
	    			document.form.h_hbl_no.value="";
	    			return false;
                }
	    		//check to cntr no equal previously entered value
	    			document.form.xmlData.value=null;
	    			sheetObjects[sheetObjects.length-1].RemoveAll();
	    			conditionReset();
	    			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,COMMAND03);
	    			document.form.h_hbl_no.value=document.form.hbl_no.value;
	        	break;
         	}
        }
     
 /* Developer Work End */
