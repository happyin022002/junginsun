/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_02c.js
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
===============================================================================
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   	/* Developer Work	*/
    // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
	//---------------------------------
    var x_sheetObject2=null;
    var x_sheetObject3=null;
    var x_sheetObject4=null;
    var x_sheetObject5=null;
    var x_sheetObjMsg=null;
    var x_oldTroSeq="";   
    var x_cancelAllFlg="N";  
    var tab_alert_msg=false; 
    // Event handler processing by button click event */
    document.onclick=checkLoad;
	function checkLoad(){	//'target' undefined error
		var readyState = document.readyState;
		if(readyState != 'interactive' && readyState != 'complete') {
			setTimeout("checkLoad()", 100);
		}
		else {
			processButtonClick();
		}
	}
    // Event handler processing by button name */
    function processButtonClick(){
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		if(srcName != "btn_splitPop" && layList.style.display == "") layList.style.display="none";
    		
    		switch(srcName) { 
				case "btn_splitPop":
					doActionIBSheet(x_sheetObjMsg, formObject, COMMAND03);	
					break;	
			    case "btn_Danger":
			    	if(checkTdUnLink(srcName)) 
			    		return false;    
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
			    	
					var url="ESM_BKG_0200_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0200_POP", 1280, 682, false);
					break;			    	
			    case "btn_Reefer":
			    	if(checkTdUnLink(srcName)) 
			    		return false;    		
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
					var url="ESM_BKG_0498_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0498_POP", 1280, 682, false);
			    	break;
			    case "btn_Awkward":
			    	if(checkTdUnLink(srcName)) 
			    		return false;    	
			    	var bkgNo=formObject.bkg_no.value;
			    	var caFlg=formObject.ca_flg.value;
			    	var url="ESM_BKG_0055_POP.do?func=&bkg_no="+bkgNo+"&ca_flg="+caFlg+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0055_POP", 1280, 682, false);
			    	break;
				case "btn_t2cAdd":
					if(checkTdDisabled(srcName)) 
						return false;
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddCNTR();
						return false;
					}
					addRow(x_sheetObject3); 
					break;
				case "btn_t2cDelete":
					if(checkTdDisabled(srcName)) 
						return false;
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddCNTR();
						return false;
					}
					if (!ComShowCodeConfirm("COM12194", "")) {
        	    		return false;
        	    	}
					//2) save & delete : call
					if(formObject.tro_sub_seq_maxcnt.value == null || 
							formObject.tro_sub_seq_maxcnt.value == "" || 
							formObject.tro_sub_seq_maxcnt.value == "1") {
						return false;
					}
					deleteDtl();
					doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "Y"); 
					break;
				case "btn_t2cPrevious":
					changeTroSeqProc_dtl("P");
					break;
				case "btn_t2cNext":
					changeTroSeqProc_dtl("N");
					break;
				case "btn_t2cRetrieve":
					if(checkTdDisabled(srcName)) 
						return false;
					formObject.curr_tro_seq.value="";  //default Seq clear
					formObject.curr_tro_sub_seq.value="";  //default Seq clear : sub
					doActionIBSheet(x_sheetObject2, formObject, IBSEARCH);
					break;
				case "btn_t2cSave": //Save All
					if(checkTdDisabled(srcName)) 
						return false;
					doActionIBSheet(x_sheetObject2, formObject, IBSAVE);
					break;
				case "btn_t2cSaveSeq": //Save(Seq)
			    	doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "C");
					break;
				case "btn_t2cConfirm":
					if(checkTdDisabled(srcName)) 
						return false;
					var bkg_no=nullToBlank2(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank2(formObject.oldBkgNo.value); 
					var routeModifyFlag=nullToBlank2(formObject.routeModifyFlag.value);
					var io_bnd_cd=nullToBlank2(formObject.io_bnd_cd.value);  //hidden 					
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					if (routeModifyFlag == "Y") {
						ComShowCodeMessage("BKG00432");
						ComSetFocus(bkg_no);
						return false;
					}
					comBkgCallPop0906('setConfirmCallBack', bkg_no, io_bnd_cd); 
					break;
				case "btn_t2cCancelFrustrate":					
					if(checkTdDisabled(srcName)) 
						return false;
					var bkg_no=nullToBlank2(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank2(formObject.oldBkgNo.value); 
					var io_bnd_cd=nullToBlank2(formObject.io_bnd_cd.value);  //hidden 
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					//1) Save
					doActionIBSheet(x_sheetObject2, formObject, IBSAVE, "CF");
					//2) Popup
					//comBkgCallPop0703('setCxlFrustCallBack', bkg_no, io_bnd_cd);  
					break;
				case "btn_t2cAddCNTR":
					if(checkTdDisabled(srcName)) 
						return false;
					var bResult=checkAddSumTroqty();
					if (!bResult) {	
						ComShowCodeMessage("BKG00420");
						return false;
					}
					addRow(x_sheetObject2);
					break;
				case "btn_t2cCopyCNTR":
					if(checkTdDisabled(srcName)) 
						return false;
					if (x_sheetObject2.RowCount()<= 0) {
						callShowMessageAddCNTR();
						return false;
					}
					var bResult=checkCopySumTroqty(x_sheetObject2);					
					if (!bResult) {	
						return false;
					}
					copyRow(x_sheetObject2);
					break;
				case "btn_t2cTROCopy":
					if(checkTdDisabled(srcName)) 
						return false;
					var bkgNo=nullToBlank2(formObject.bkg_no.value);
					var bkgNoOld=nullToBlank2(formObject.oldBkgNo.value); 
					if (bkgNo == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkgNo != bkgNoOld) {
						ComShowCodeMessage("BKG00048", bkgNoOld, bkgNo);
						ComSetFocus(bkg_no);
						return false;
					}
					var boundCd=nullToBlank2(formObject.io_bnd_cd.value); 
					var troSeq=nullToBlank2(tro_seq.GetSelectText());
					var uiId="ESM_BKG_0079_02C";
					comBkgCallPop0920('setTroCopy', bkgNo, boundCd, troSeq, uiId); 
					break;
				case "btn_t2cTRONotice":
					var bkg_no=nullToBlank2(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank2(formObject.oldBkgNo.value); 					
					var boundCd=nullToBlank2(formObject.io_bnd_cd.value); 		
					formObject.eml.value=nullToBlank2(formObject.cntc_eml.value);
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}					
					var sUrl="/opuscntr/ESM_BKG_0221.do?pgmNo=ESM_BKG_0221&ui_id=ESM_BKG_0079_02C";
					ComOpenWindowCenter(sUrl, "ESM_BKG_0221", 400, 210, true);	
					break;
				case "btn_t2cMulti":					
					var bkg_no=nullToBlank2(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank2(formObject.oldBkgNo.value); 
					var cntr_no=nullToBlank2(formObject.cntr_no.value);
					var boundCd=nullToBlank2(formObject.io_bnd_cd.value); 
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					var url="ESM_BKG_0921.do?func=&bkg_no="+bkg_no+"&cntr_no="+cntr_no+"&bound_cd="+boundCd+"&pop_mode=1";
					ComOpenWindowCenter(url, "ESM_BKG_0921", 446, 396 , false);
//					comBkgCallPop0921('setMultiCallBack', bkg_no, cntr_no, boundCd); 
					break;
				case "btn_t2cT1Revenue":
					var bkg_no=nullToBlank2(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank2(formObject.oldBkgNo.value);
					var t1_doc_flg=nullToBlank2(formObject.t1_doc_flg.value);
					var cstms_clr_no=nullToBlank2(formObject.cstms_clr_no.value);
					var all_in_rt_cd=nullToBlank2(formObject.all_in_rt_cd.value);  
					var curr_cd=nullToBlank2(formObject.curr_cd.value);
					var trns_rev_amt=nullToBlank2(formObject.trns_rev_amt.value);
					var non_trns_rev_amt=nullToBlank2(formObject.non_trns_rev_amt.value);
					var add_rev_amt=nullToBlank2(formObject.add_rev_amt.value);
					var add_rev_chg_cd=nullToBlank2(formObject.add_rev_chg_cd.value);
					var cxl_flg=nullToBlank2(formObject.cxl_flg.value);     
					var vat_flg=nullToBlank2(formObject.vat_flg.value); 
					var term=nullToBlank2(formObject.term.value);
					//var hlg_tp_cd=nullToBlank2(hlg_tp_cd.GetSelectText());
					var hlg_tp_cd=nullToBlank2(comboObjects[4].GetSelectText());
					var io_bnd_cd=nullToBlank2(formObject.io_bnd_cd.value);
					var cfm_flg=nullToBlank2(formObject.cfm_flg.value);
					cfm_flg=(cfm_flg == "Yes")? "Y" : "N";
					var so_flg=(nullToBlank2(formObject.so_no.value) == "")? "N" : "Y";
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					//comBkgCallPop0317('setT1RevenueCallBack', bkg_no, t1_doc_flg, cstms_clr_no, all_in_rt_cd, curr_cd, trns_rev_amt, cxl_flg, term, vat_flg, hlg_tp_cd, io_bnd_cd, cfm_flg);
					comBkgCallPop0317('setT1RevenueCallBack', bkg_no, t1_doc_flg, cstms_clr_no, all_in_rt_cd, curr_cd, trns_rev_amt, non_trns_rev_amt , add_rev_amt, add_rev_chg_cd, cxl_flg, term, vat_flg, hlg_tp_cd, io_bnd_cd, so_flg);
					break;
				case "btns_t2cSearchCntrNo":
					if(checkInputDisabled("cntr_no")) 
						return false;
					var bkg_no=nullToBlank2(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank2(formObject.oldBkgNo.value); 
					var io_bnd_cd=nullToBlank2(formObject.io_bnd_cd.value);  //hidden 
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					comBkgCallPop0907('setCntrNoCallBack', bkg_no, io_bnd_cd); 
					break;				
				case "btns_repCommodity":
					if(checkInputDisabled("rep_cmdt_cd")){
						return false;
					}
					var cmdtCd=ComGetObjValue(formObject.tro_cmdt_cd);
	        		var repCmdtCd=ComGetObjValue(formObject.rep_cmdt_cd);
					comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd);
					break;
				case "btns_popLocation":
					if(checkInputDisabled("zn_cd")) 
						return false;					
					//var cnt_cd     = formObject.por_cd.value.substr(0,2);  
					var cnt_cd="";
					var node_cd="";
					var dor_loc_cd=formObject.dor_loc_cd.value;
					var zn_cd=formObject.zn_cd.value;					
					if (dor_loc_cd.length == 5 && zn_cd.length == 2) { 
						node=dor_loc_cd+zn_cd; 
					}					
					var param="";
					param += "?cnt_cd="    + cnt_cd;
					param += "&loc_cd="    + dor_loc_cd;
					param += "&ofc_cd="    + "N";
					param += "&node_cd="   + node_cd;
					param += "&mode="      + "zone";
					param += "&mode_only=" + "Y";
					ComOpenPopup("/opuscntr/COM_ENS_061.do"+param, 780, 520, 'getCOM_ENS_061_1', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;	
				case "btns_Address":
					if(checkInputDisabled("dor_addr_1")) 
						return false;
					var conti_cd=document.form.conti_cd.value;            
					var cnt_cd=document.form.por_cd.value.substr(0,2); 
					var dor_loc_cd=document.form.dor_loc_cd.value; 
					var act_shpr_cnt_cd=document.form.cust_cnt_cd.value; 
					var act_shpr_seq=document.form.cust_seq.value;
					var act_shpr_nm=document.form.cust_nm.value; 
					var arrAct_shpr_nm=act_shpr_nm.split(" ");
					act_shpr_nm=arrAct_shpr_nm[0]; 
					var bkg_no=nullToBlank2(formObject.bkg_no.value);
					var bkg_no_old=nullToBlank2(formObject.oldBkgNo.value); 
					if (bkg_no == "") {
						ComShowCodeMessage("BKG00255");
						ComSetFocus(bkg_no);
						return false;
					}
					if (bkg_no != bkg_no_old) {
						ComShowCodeMessage("BKG00048", bkg_no_old, bkg_no);
						ComSetFocus(bkg_no);
						return false;
					}
					var type = "C";
					comBkgCallPop0905('setActCustCallBack', conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm,type);
					break;
	    		case "btns_calendar":
	    			if(checkInputDisabled("cntr_rtn_dt")) 
	    				return false;	    			
	    			var cal=new ComCalendar();
	                cal.select(formObject.cntr_rtn_dt, 'yyyy-MM-dd');
	    			break;
	    		case "btns_calendar_2":
	    			if(checkInputDisabled("cntr_pkup_dt")) 
	    				return false;
	    			var cal=new ComCalendar();
	                cal.select(formObject.cntr_pkup_dt, 'yyyy-MM-dd');
	    			break;
	    		case "btns_calendar_3":
	    			if(checkInputDisabled("arr_dt")) 
	    				return false;
	    			var cal=new ComCalendar();
	                cal.select(formObject.arr_dt, 'yyyy-MM-dd');
	    			break;
            } // end switch
    	}catch(e) {
    		if( e.name == "TypeError") {
    			return false;
    		}else{
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
      * Set IBCombo Object In comboObjects array
      */
     function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
     }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form; 
  	    changeDisplayBtn("btn_Danger",  "N");
  	    changeDisplayBtn("btn_Reefer",  "N");
  	    changeDisplayBtn("btn_Awkward", "N");
     	for(var i=0; i<sheetObjects.length; i++){
             ComConfigSheet   (sheetObjects[i]);
             initSheet        (sheetObjects[i], i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
        //**************************************************************
 	   	x_sheetObject5=sheetObjects[0];  //sum_qty screen
 	   	x_sheetObject2=sheetObjects[1];  //tro all hidden
 	   	x_sheetObject3=sheetObjects[2];  //tro_dtl all hidden
 	   	x_sheetObject4=sheetObjects[3];  //tro_dg_seq all hidden
 	   	x_sheetObjMsg=sheetObjects[4];  //msg hidden
        //**************************************************************
        //---------------
        //IBMultiCombo Initialization
        for(var k=0; k<comboObjects.length; k++){
            initCombo(comboObjects[k],k+1);
        } 
        //---------------
  		//iframe Creation 
  		//CofigIframe();          
//        axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form); 
        axon_event.addListenerForm  ('keyup',    'obj_keyup_loc',    document.form); 
        axon_event.addListenerForm  ('change',   'obj_change_loc',   document.form);
        axon_event.addListenerForm	('keydown',  'check_Enter', 	 document.form);
        axon_event.addListenerForm  ('beforedeactivate'	, 'obj_deactivate'	, document.form); 
        if (formObj.bkg_no.value != "" || formObj.bl_no.value != "") {
        	formObj.curr_tro_seq.value="";  //default Seq clear
        	formObj.curr_tro_sub_seq.value="";  //default Seq clear : sub
            doActionIBSheet(x_sheetObject2, document.form, IBSEARCH);
        } else {
 	   		ComEnableManyTd(true,  "btn_t2cRetrieve");
 	   		ComEnableManyTd(false, "btn_t2cSave", "btn_t2cSaveSeq", 
 	   				               "btn_t2cConfirm", "btn_t2cCancelFrustrate", "btn_t2cTROCopy", "btn_t2cTRONotice",
                                   "btn_t2cAddCNTR", "btn_t2cCopyCNTR", "btn_t2cDeleteCNTR", 
                                   "btn_t2cAdd", "btn_t2cDelete", 
                                   "btn_t2cPrevious", "btn_t2cNext");
 	   	}
		ComEnableManyObjects_loc   (false,     document.form.comm_ofc_cd);       												//Dis-Active	
     	//------------------------------------------------>
     	if(ComGetObjValue(document.form.isInquiry) == "Y"){
     		setInquiryDisableButton();
     	}
     	initControl();
     }
 	function initControl() {
      	applyShortcut();
 	}
 	
//	/** 
//	 * OnKeyPress Event Handling 
//	 */
//	function obj_keypress_loc() {
//		var srcName  = event.srcElement.getAttribute("name");
//    	var srcValue = event.srcElement.getAttribute("value");		
//		
//		switch(event.srcElement.dataformat){
//	       case "float":
//	           //number+"." input
//	           ComKeyOnlyNumber(event.srcElement, ".");
//	           break;
//	       case "eng":
//	           //Only eng input, eng+num -> ComKeyOnlyAlphabet('num');
//	           ComKeyOnlyAlphabet();
//	           break;
//	       case "engdn":
//	           //Only lower eng input, lower eng+num -> ComKeyOnlyAlphabet('lowernum');
//	           ComKeyOnlyAlphabet('lower');
//	           break;
//	       case "engup":
//	           ComKeyOnlyAlphabet('upper');
//	           break;
//	       case "int":
//	           //Only num input(num,date,time)
//	           ComKeyOnlyNumber(event.srcElement);
//	           break;
//	       case "uppernum":
//	           ComKeyOnlyAlphabet('uppernum'); 
//	           break;
//	       case "tel":
//		        ComKeyOnlyNumber(event.srcElement, " -"); 
//		        break;
//	       case "ymd":
//	       case "hm":
//	    	    ComKeyOnlyNumber(event.srcElement);
//	    	    break;
//           case "engupspecial": 
//	   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
//	    	   break;
//		}
//	}	
    function obj_keyup_loc() {
		var formObj = document.form;
		
		with(formObj) {
			if (event.srcElement.type == "textarea") {
				return;
			}
			if ( window.event.keyCode == 13 ) { 
				formObj.curr_tro_seq.value     = "";  //default Seq clear
	        	formObj.curr_tro_sub_seq.value = "";  //default Seq clear : sub
				
				return;
		    }			
			
			switch(event.srcElement.name){
	            case "cgo_wgt":
	            	cgo_wgt.value = changeComma_loc(cgo_wgt.value, 0, 9, 3);
	            	break;
			}
				
			var srcName  = event.srcElement.getAttribute("name");
	    	var srcValue = event.srcElement.getAttribute("value");	
			switch(event.srcElement.dataformat){
	 	        case "ymd":
	 	        	formObj.elements[srcName].value = changeMask_ymd_loc(event.srcElement, "-");
	 	        	if (formObj.elements[srcName].value.length == 10) {
	 	            	if (!ComChkObjValid(event.srcElement, true, true, false)) return false;  //eval("formObj."+srcName)
	 	            	break;
	 	        	}
		        	break;
	        	case "hm":
	        		formObj.elements[srcName].value = changeMask_hm_loc(event.srcElement, ":");	
	 	        	if (formObj.elements[srcName].value.length == 5) {
	 	            	if (!ComChkObjValid(event.srcElement, true, true, false)) return false;  //eval("formObj."+srcName)
	 	            	break;
	 	        	}
		    		break;
			}
		}
    }   	
    function initCombo(comboObj, comboNo) {
    	with (comboObj) {
    		SetMultiSeparator("|");
	    	switch(comboObj.options.id) {
			    case "tro_seq" : 
			    	SetColWidth(0, "46");
			        break;
	    	    case "dcgo_seq" : 	    	    	
	    	    	SetColWidth(0, "40");
	    	    	SetColWidth(1, "280");
	                SetTitle("seq|Remark");
	                SetMultiSelect(1);
	    	        break;
	    	    case "rc_seq" : 
	    	    	SetColWidth(0, "40");
	    	    	SetColWidth(1, "380");
	    	    	SetTitle("seq|Remark");
	    	    	break;
	    	    case "awk_cgo_seq" : 
	    	    	SetColWidth(0, "70");
	    	        break;
	    	    case "hlg_tp_cd" : 	    	    	
	    	    	comboObj.InsertItem(-1, "C",  "C");  //"Carrier Haulage"
	    	    	comboObj.InsertItem(-1, "M",  "M");  //"Merchant Haulage"
			        break;
	    	    case "bkg_trsp_mzd_cd":
	    	    	break;
	    	    case "dor_addr_tp_cd" : 
	    	    	comboObj.InsertItem(-1, "",   "");
	    	    	comboObj.InsertItem(-1, "Door",    "D");
	    	    	comboObj.InsertItem(-1, "Customs", "C");
			        break;
	    	}
        }
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
     	switch(sheetObj.id) {
			case "t2csheet2":      //t2csheet2 init : all-master <hidden>  
				with (sheetObj) {
			        var HeadTitle=" |";
			        var HeadTitle=" | |rqst_sub_seq|cntr_no|cntr_tpsz_cd|hlg_tp_cd|cgo_wgt|cntr_pkup_yd_cd|cntr_rtn_yd_cd";
			        HeadTitle     += "|cntr_rtn_dt|cntr_rtn_dt_hhmi|tro_cmdt_cd|rep_cmdt_cd|rep_cmdt_nm|bkg_trsp_mzd_cd|cntr_pkup_dt|cntr_pkup_dt_hhmi";
			        HeadTitle     += "|spcl_instr_rmk|cfm_flg|cfm_dt|cfm_ofc_cd|cfm_usr_id|cfm_usr_nm|so_no|so_dt|so_ofc_cd|so_usr_id|so_usr_nm|cntr_prt_flg|t1_doc_flg";
			        HeadTitle     += "|cstms_clr_no|all_in_rt_cd|curr_cd|trns_rev_amt|non_trns_rev_amt|add_rev_amt|add_rev_chg_cd|vat_flg|cxl_flg|cntr_tpsz_cd_old|hlg_tp_cd_old|rc_seq|awk_cgo_seq|eur_trns_tp_cd|comm_ofc_cd|";
			        var headCount=ComCountHeadTitle(HeadTitle);
	
			        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"rqst_sub_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hlg_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_pkup_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_rtn_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_rtn_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_rtn_dt_hhmi",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tro_cmdt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rep_cmdt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rep_cmdt_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"bkg_trsp_mzd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_pkup_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_pkup_dt_hhmi",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"spcl_instr_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cfm_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"so_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"so_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"so_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"so_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"so_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_prt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"t1_doc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cstms_clr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"all_in_rt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"trns_rev_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"non_trns_rev_amt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"add_rev_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"add_rev_chg_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vat_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cxl_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd_old",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"hlg_tp_cd_old",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rc_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"awk_cgo_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"eur_trns_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"split_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			        		   {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"comm_ofc_cd",        keyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
			         
			        InitColumns(cols);
			        SetEditable(0);
			        SetWaitImageVisible(0);
//			        SetSheetHeight(120);
				}	
			    break;
			case "t2csheet3":      //t2csheet3 init : all-detail <hidden>   			
				with (sheetObj) {
			        var HeadTitle=" | |tro_seq|tro_sub_seq|dor_addr_tp_cd|dor_loc_cd|zn_cd|lod_ref_no|dor_pst_no|dor_addr_1|dor_addr_2";
			        HeadTitle     += "|dor_addr_3|dor_addr_4|arr_dt|arr_dt_hhmi|cntc_pson_nm|cntc_phn_no|cntc_eml|cxl_flg";  //20 cols
			        var headCount=ComCountHeadTitle(HeadTitle);
	
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
			               {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_sub_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"dor_addr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"dor_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"zn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"lod_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"dor_pst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"dor_addr_1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"dor_addr_2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"dor_addr_3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"dor_addr_4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"arr_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"arr_dt_hhmi",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"cntc_phn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"cntc_eml",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
			               {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"cxl_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];
			         
			        InitColumns(cols);
			        SetEditable(0);
			        SetWaitImageVisible(0);
//			        SetSheetHeight(120);
				}
		        break;	
			case "t2csheet4":      //t2csheet4 init : tro_dg_seq all <hidden>  
				with (sheetObj) {				
			        var HeadTitle=" | | | ";  //4 cols
			        var headCount=ComCountHeadTitle(HeadTitle);
	
			        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			               {Type:"DummyCheck", Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
			               {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tro_dcgo_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
			         
			        InitColumns(cols);
			        SetEditable(0);
			        SetWaitImageVisible(0);
//			        SetSheetHeight(120);
				}	
			    break;
     		case "t2csheet5":      //t2csheet5 init : sum_qty grid
 				with (sheetObj) {
	     		   var HeadTitle="TP/SZ|Total Qty|C/H|M/H";  //4 cols
	     		   var headCount=ComCountHeadTitle(HeadTitle);
	
	     		   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	     		   var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	     		   var headers = [ { Text:HeadTitle, Align:"Center"} ];
	     		   InitHeaders(headers, info);
	
	     		   var cols = [ {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	     		             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	     		             {Type:"Text",      Hidden:0, Width:52,   Align:"Right",   ColMerge:0,   SaveName:"tro_qty_ch",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	     		             {Type:"Text",      Hidden:0, Width:52,   Align:"Right",   ColMerge:0,   SaveName:"tro_qty_mh",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	     		    
	     		   InitColumns(cols);
	     		   SetSheetHeight(102);
	     		   SetEditable(1);
	     		   SetWaitImageVisible(0);
	     		   SetCountPosition(0);
 				}	
 			    break;
     		case "t2cmsgsheet1":      
				with (sheetObj) {
	     	        var HeadTitle="";
	     	       var headCount=ComCountHeadTitle(HeadTitle);
	
	     	       SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	     	       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	     	       var headers = [ { Text:HeadTitle, Align:"Center"} ];
	     	       InitHeaders(headers, info);
	
	     	       var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
	     	        
	     	       InitColumns(cols);
	     	       SetEditable(0);
	     	       SetWaitImageVisible(0);
//	     	      SetSheetHeight(120);
				}	
			    break;
     	}
    }
    // handling sheet process
    function doActionIBSheet(sheetObj, formObj, sAction, delFlg) {
        switch(sAction) {
			case COMMAND03:      //booking split no Retrieve 
				formObj.f_cmd.value=COMMAND03;
				var param="f_cmd=" + COMMAND03 + "&bkg_no=" + formObj.bkg_no.value;  
 			    var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02CGS.do", param);
			 	var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
			 	bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -23); 
			 	break;
			case COMMAND04:      //container cago weight Retrieve 
				formObj.f_cmd.value=COMMAND04;
				var param="f_cmd=" + COMMAND04 + "&bkg_no=" + formObj.bkg_no.value + "&cntr_no=" + formObj.cntr_no.value;
 			 	var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02CGS.do", param);
			 	sheetObj.LoadSearchData(sXml,{Sync:1} );
		    	var boundCd=formObj.io_bnd_cd.value;
		    	var cntrNo=formObj.cntr_no.value ;
			 	if ("I" == boundCd && cntrNo.trim() != "") {
				 	var t_cgo_wgt=nullToBlank2(ComGetEtcData(sXml, "cgo_wgt"));
				 	if ("" == t_cgo_wgt) {
				 		var bResult=ComShowCodeMessage("BKG00379");  //return Mandatory. 
				 	}
				 	formObj.cgo_wgt.value=t_cgo_wgt;
				 	ComSetFocus(formObj.cgo_wgt); 
			 	}
			 	//02. tpsz Change
        		var preVal_type=formObj.cntr_tpsz_cd.value; 
        		var nxtVal_type=nullToBlank2(ComGetEtcData(sXml, "cntr_tpsz_cd")); 
        		var preVal_hlg=hlg_tp_cd.GetSelectCode();
        		var nxtVal_hlg=hlg_tp_cd.GetSelectCode();
        		formObj.cntr_tpsz_cd.value=nxtVal_type;
    			changeSumTroQty(preVal_type, preVal_hlg, "1", nxtVal_type, nxtVal_hlg, "1");  //change : plus/minus
			 	break;
          	case IBSEARCH: 
          		if(!validateForm(sheetObj,formObj,sAction)) return;  	
          		initSearchVal(); 
				formObj.f_cmd.value=SEARCH;  
				ComOpenWait(true);
				var parm="f_cmd=" + SEARCH + "&bkg_no=" + formObj.bkg_no.value + "&io_bnd_cd=" + formObj.io_bnd_cd.value+"&bl_no="+formObj.bl_no.value;	
				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02CGS.do", parm);
				var arrXml=sXml.split("|$$|");  
				ComOpenWait(false); 
				if(ComGetEtcData(arrXml[0], "DataYn") == "N") {
					x_sheetObjMsg.LoadSearchData(arrXml[0],{Sync:1} );
					formObj.bkg_no.value=formObj.oldBkgNo.value;
					formObj.bl_no.value=formObj.oldBlNo.value;
					return;
				} 				
				//(정보 Retrieve all): Start------------------------------------------>
                if (arrXml.length > 0) 
				{ 
                    x_sheetObject4.LoadSearchData(arrXml[2],{Sync:1} );
                    ComBkgXml2ComboItem(arrXml[3], comboObjects[1],        "display_nm", "dg_seq"); 
                    ComBkgXml2ComboItem(arrXml[4], comboObjects[2],          "display_nm", "rf_seq"); 
                    ComBkgXml2ComboItem(arrXml[5], comboObjects[3],     "awk_seq",    "awk_seq"); 
                    ComBkgXml2ComboItem(arrXml[7], comboObjects[5], "val",        "desc"); 
                    ComBkgXml2ComboItem(arrXml[0], comboObjects[0],         "tro_seq",    "tro_seq");  
                	x_sheetObject2.LoadSearchData(arrXml[0],{Sync:1} );
                    setEtcDataToForm_bkg(formObj, x_sheetObject2); 
                    //max_tro_seq_old : setting
                    var max_tro_seq_old=x_sheetObject2.GetCellValue(x_sheetObject2.RowCount(), "tro_seq");
                    formObj.max_tro_seq_old.value=(nullToBlank2(max_tro_seq_old.trim())=="")? "0": max_tro_seq_old;
                    
                    var sheet2_tro_seq = "";
                    if(x_sheetObject2.RowCount() > 0 ){
                    	sheet2_tro_seq = x_sheetObject2.GetCellValue(1, "tro_seq");
                    }
                    setDataToForm_TroMst(sheet2_tro_seq);
                }
                x_sheetObject3.RemoveAll();
                
        		if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0)
        		{
        			x_sheetObject3.LoadSearchData(arrXml[1],{Sync:1} );
        		}
//        		setAllDataToData_TroDtl(tro_seq.text, 1);  //nRow_tro_sub_seq : 1
        		
        		setAllDataToData_TroDtl(tro_seq.GetText(parseInt(tro_seq.GetSelectIndex()), 0), 1);  //nRow_tro_sub_seq : 1
                //<--------------------------------------------(info Retrieve all): End 
        		if (ComGetTotalRows(arrXml[6]) > 0)
        		{
        			x_sheetObject5.LoadSearchData(arrXml[6],{Sync:1} );
        			changeTroQtyColor(x_sheetObject5);
        			checkTroQty(x_sheetObject5);
        		}
                if (formObj.tro_seq_maxcnt.value == "0") { 
                	addRow(x_sheetObject2);  
                } else {
                	if (formObj.curr_tro_seq.value != "") {                		
//                		tro_seq.SetSelectText(formObj.curr_tro_seq.value);//default seq    set : onchange!!!!!!!!
                		comboObjects[0].SetSelectText(formObj.curr_tro_seq.value);//default seq    set : onchange!!!!!!!!
                		//formObj.tro_sub_seq.Text = formObj.curr_tro_sub_seq.value;  //default suvseq set : onchange!!!!!!!!  ????????????????
                	}
                }                
                if(formObj.io_bnd_cd.value == "I") {        
            	dcgo_seq.SetEnable(0);
            	rc_seq.SetEnable(0);
            	awk_cgo_seq.SetEnable(0);
                }
				if('X' == ComGetObjValue(formObj.bkg_sts_cd)){
					ComEnableManyTd(false ,"btn_t2cRetrieve","btn_t2cSave","btn_t2cSaveSeq","btn_t2cConfirm","btn_t2cCancelFrustrate","btn_t2cTROCopy","btn_t2cTRONotice","btn_t2cAddCNTR","btn_t2cCopyCNTR");
				}else{
					ComEnableManyTd(true ,"btn_t2cRetrieve","btn_t2cSave","btn_t2cSaveSeq","btn_t2cConfirm","btn_t2cCancelFrustrate","btn_t2cTROCopy","btn_t2cTRONotice","btn_t2cAddCNTR","btn_t2cCopyCNTR");
				}
				ComSetObjValue(formObj.modify_flag, "N");
		     	//------------------------------------------------>
		     	//setInquiryDisableButton Event Call
		     	if(ComGetObjValue(document.form.isInquiry) == "Y"){
		     		setInquiryDisableButton();
		     	}
                //2) C/A Btn Control                
				parent.initCAControl(ComGetEtcData(arrXml[0], "bkg_no"), 
						             ComGetEtcData(arrXml[0], "ca_flg"), 
						             ComGetEtcData(arrXml[0], "bdr_flg"), 
						             ComGetEtcData(arrXml[0], "ca_exist_flg"), 
						             ComGetEtcData(arrXml[0], "bl_no"));
                break;  
     		case IBSAVE:
	 		    //alert(delFlg);
				var currTroSeq=tro_seq.GetSelectText();
				var currTroSubSeq_v=formObj.tro_sub_seq.value; 
                setFormToData_Tro_dg_seq(currTroSeq); 
     		    x_sheetObject4.ColumnSort("tro_seq|tro_dcgo_seq");
	        	setFormToData_TroMst(currTroSeq); // Values from Form object to ibsheet about Master
     		    setDataToAllData_TroDtl(currTroSeq, currTroSubSeq_v, "V"); // Values from Form object to ibsheet about Detail
				x_sheetObject3.ColumnSort("tro_seq|tro_sub_seq");
				if (delFlg == "C") { //Save(Seq) Change status of all rows other than current seq to R
					for (var i=1; i<=x_sheetObject2.RowCount(); i++) { //mst
						if (x_sheetObject2.GetCellValue(i, "tro_seq") != currTroSeq) {
//							x_sheetObject2.CellValue2(i, "ibflag") = "R";
							x_sheetObject2.SetRowStatus(i,"R");
						}
	     		    }
					for (var i=1; i<=x_sheetObject3.RowCount(); i++) { //dtl
						if (x_sheetObject3.GetCellValue(i, "tro_seq") != currTroSeq) {
//							x_sheetObject3.CellValue2(i, "ibflag") = "R";
							x_sheetObject3.SetRowStatus(i,"R");
						}
	     		    }
					for (var i=1; i<=x_sheetObject4.RowCount(); i++) { //dg
						if (x_sheetObject4.GetCellValue(i, "tro_seq") != currTroSeq) {
//							x_sheetObject4.CellValue2(i, "ibflag") = "R";
							x_sheetObject4.SetRowStatus(i,"R");
						}
	     		    }
				} else {
	     		    for (var i=1; i<=x_sheetObject4.RowCount(); i++) { //dg
//	     		    	x_sheetObject4.CellValue2(i, "ibflag") = "I";
	     		    	x_sheetObject4.SetRowStatus(i,"I");
	     		    }
				}
				if(!validateForm(sheetObj, formObj, sAction, delFlg)) return false;  
          		//(containerVO)----------------------------------------->
          	    formObj.f_cmd.value=MULTI;  
          	    formObj.curr_tro_seq.value=tro_seq.GetSelectText();       //default Seq setting
          	    formObj.curr_tro_sub_seq.value=formObj.tro_sub_seq.value;  //default Seq setting : sub
          	    var sheetSaveObjects=new Array();
          	    sheetSaveObjects[0]=x_sheetObject2;
          	    sheetSaveObjects[1]=x_sheetObject3;
          	    sheetSaveObjects[2]=x_sheetObject4;
          	    var sParam1=ComSetPrifix(x_sheetObject2.GetSaveString(), "t2asheet2_");
          	    var sParam2=ComSetPrifix(x_sheetObject3.GetSaveString(), "t2asheet3_");
          	    var sParam3=ComSetPrifix(x_sheetObject4.GetSaveString(), "t2asheet4_");
          	    var sParam="f_cmd=" + MULTI 
          	    			+ "&bkg_no=" + formObj.bkg_no.value
          	    			+ "&oldBkgNo=" + formObj.oldBkgNo.value
          	    			+ "&io_bnd_cd=" + formObj.io_bnd_cd.value
          	    			+ "&f_del_flg=" + formObj.f_del_flg.value //Save(Seq) -> C; Save All -> N; Dtl Delete -> Y
          	    			+ "&curr_tro_seq=" + formObj.curr_tro_seq.value
          	    			+ "&curr_tro_sub_seq=" + formObj.curr_tro_sub_seq.value
          	    			;
          		sParam += "&" + sParam1; 
          	    sParam += "&" + sParam2; 
          	    sParam += "&" + sParam3; 
//          	    alert(sParam);
          	    var sXml=sheetObj.GetSaveData("ESM_BKG_0079_02CGS.do", sParam);
          		formObj.post_flg.value=nullToBlank2(ComGetEtcData(sXml, "post_flg"));
          		sheetSaveObjects[0].LoadSaveData(sXml);
          		//<------------------------------------------(containerVO)	
                break;
			case COMMAND02:      
	          	//if(!validateForm(sheetObj, formObj, sAction, sCmd)){
		          	//	return false;
		        //}
			    //ComOpenWait(true);
			    formObj.f_cmd.value=COMMAND02;
				var sParam = "f_cmd=" + COMMAND02 
				+ "&bkg_no=" + formObj.bkg_no.value 
				+ "&io_bnd_cd=" + formObj.io_bnd_cd.value 
				+ "&eml=" + formObj.eml.value 
				+ "&fax_no=" + formObj.fax_no.value 
				+ "&bl_no=" + formObj.bl_no.value
//				+ "&cmdt=" + formObj.cmdt.value
//				+ "&receiver=" + formObj.receiver.value
//				+ "&other=" + formObj.other.value
//				+ "&cust_ntc=" + formObj.cust_ntc.value
//				+ "&slct_cntr=" + formObj.slct_cntr.value
				;
				
			    var sXml=sheetObj.GetSaveData("ESM_BKG_0079_02CGS.do", sParam);
			    sheetObj.LoadSaveData(sXml ,{Append:0 , Sync:1} );
				if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
					ComShowCodeMessage("BKG00497");  //Email
					//ComShowCodeMessage("BKG00496");  //Fax
				} else if(ComGetEtcData(sXml, "SuccessYn") == "YM"){
					ComShowCodeMessage("BKG00497");  //Email
				} else if(ComGetEtcData(sXml, "SuccessYn") == "YF"){
					ComShowCodeMessage("BKG00496");  //Fax
				}
			 	break;
			 	
			case SEARCH02:
				var param=param + "&f_cmd=" + SEARCH02 + "&loc_cd=" + formObj.dor_loc_cd.value;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0079_02CGS.do", param);
				var locUse=ComGetEtcData(sXml, "loc_use");
				if(locUse=="N"){
					ComShowCodeMessage("BKG00061", formObj.dor_loc_cd.value);
					formObj.dor_loc_cd.value="";
					formObj.dor_loc_cd.focus();
				}
				break;
        }
        return true;
    }
    function initSearchVal() {
    	var formObj=document.form;
    	x_oldTroSeq=""; 
        x_cancelAllFlg="N";  //Y:cancelAll Handling됨 
        formObj.post_flg.value="N";  //Initialization  
    }
    //######################[1. Event]############################################################
    /**
    * Tro master : tro_seq Combo Selected Change, Event Handling
    */
    function tro_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	if(newIndex >= 0)    		changeTroSeqProc();
    }
    /**
    * Tro master : dcgo_seq Check Click, Event Handling
    */
    function dcgo_seq_OnCheckClick(comboObj, idx_cd, text) {
    	var formObj=document.form;
    	setAddRemarkText(comboObj, idx_cd, text, "Y");     	
    	setComboBackColor(dcgo_seq);
    }   
    /**
    * Tro master : rc_seq change Event Handling
    */
    function rc_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	//comboObj->undefied.
    	var formObj=document.form;
    	setAddRemarkText(rc_seq, newIndex, newCode, "N"); 
    	setComboBackColor(rc_seq);	
    }  
    /**
    * Tro master : awk_cgo_seq change Event Handling
    */
    function awk_cgo_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	var formObj=document.form;
    	var nRow=x_sheetObject2.FindText("tro_seq", formObj.tro_seq.value);
    	x_sheetObject2.SetCellValue(nRow,"awk_cgo_seq",formObj.awk_cgo_seq.value,0);
    	setComboBackColor(awk_cgo_seq);	    
    }
    /**
    * On Save End Event Handling
    */    
    function t2csheet2_OnSaveEnd(sheetObj, Code, ErrMsg, StCode, StMsg) {
    	var formObj=document.form;
    	if (ErrMsg.length > 9 && ErrMsg.substr(0,9) == "[SUCCESS]") {
    		doActionIBSheet(x_sheetObject2, document.form, IBSEARCH);	//ReSearch call
    	} else {
    		var strPostFlg=nullToBlank2(formObj.post_flg.value);      
    		if (strPostFlg == "CF") {
    			var bkg_no=nullToBlank2(formObj.bkg_no.value);
				var io_bnd_cd=nullToBlank2(formObj.io_bnd_cd.value);     //hidden 
    			comBkgCallPop0703("setCxlFrustCallBack", bkg_no, io_bnd_cd);  //cancel/frustrate popup call
    		}
    	}
    }
    /**
    * Tro master : TP/SZ change Event Handling
    */
    function obj_change_loc() {
    	var formObj=document.form;
    	var elementNm=ComGetEvent("name");
		switch(elementNm){
            case "cntr_tpsz_cd":
        		var preVal_type=formObj.cntr_tpsz_cd_old.value; 
        		var nxtVal_type=formObj.cntr_tpsz_cd.value; 
        		var preVal_hlg=formObj.hlg_tp_cd_old.value; 
        		var nxtVal_hlg=hlg_tp_cd.GetSelectCode();
        		changeSumTroQty(preVal_type, preVal_hlg, "1", nxtVal_type, nxtVal_hlg, "1");  //change : plus/minus 
            	break;
            case "cntr_no":            	
            	//cgo_wgt/tpsz Change : tpsz Add 
                
            	var add_cntr_no = formObj.cntr_no.value;
                var sheetObj_qty=x_sheetObject2;
                for(var i=1; i<=sheetObj_qty.RowCount(); i++)
                {
                	if ( (sheetObj_qty.GetCellValue(i, "eur_trns_tp_cd") != "FR") && (sheetObj_qty.GetCellValue(i, "cxl_flg") != "Y") && (formObj.tro_seq.value != sheetObj_qty.GetCellValue(i, "tro_seq")) && (add_cntr_no == sheetObj_qty.GetCellValue(i, "cntr_no"))){
                    	       ComShowCodeMessage("BKG01197", add_cntr_no);
                    	       formObj.cntr_no.value  = "";
                    	       return;
                      }
                }
                     	
            	doActionIBSheet(x_sheetObjMsg, formObj, COMMAND04);	
            	break;
            case "dor_loc_cd":
            	if(formObj.dor_loc_cd.value!=""){
            		doActionIBSheet(x_sheetObjMsg, formObj, SEARCH02);	
            	}
            	break;
		}
    }
    /**
     * Tro master : hlg_tp_cd change Event Handling
     */
    function hlg_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) { 
    	var formObj=document.form;
        var sheetObj=x_sheetObject2;
    	//----------------------
		if ("Y" == formObj.cxl_flg.value) {
			return; 
		}
		var preVal_type=formObj.cntr_tpsz_cd_old.value; 
		var nxtVal_type=formObj.cntr_tpsz_cd.value; 
		var preVal_hlg=formObj.hlg_tp_cd_old.value; 
		var nxtVal_hlg=hlg_tp_cd.GetSelectCode();
		if (nxtVal_type.trim() != "" && (nxtVal_hlg != preVal_hlg)) {
			var bResult=changeSumTroQty(preVal_type, preVal_hlg, "1", nxtVal_type, nxtVal_hlg, "1");  //change : plus/minus
			if (!bResult) {
				return;
			}
		}
    	//----------------------
    	// Haulage change color 
     	changeEnabeld_haulage_master();  //master
     	changeEnabeld_haulage_dtl();     //dtl
     	//----------------------
     	if (formObj.new_row_flg.value == "Y") {
     		clearFormData_master(nxtVal_hlg);
     		clearFormData_dtl   (nxtVal_hlg);
     	}
    }
    /**
    * Tro master/detatil : tro_seq 콤보 선택Change시 Handling 
    */
    function changeTroSeqProc() { 
    	var formObj=document.form;
    	var comboObj=tro_seq; 
    	//----------------------
    	//1)tro_seq Retrieve
		var currTroSeq=comboObj.GetSelectText();
		var currTroSubSeq=formObj.tro_sub_seq_currcnt.value;
    	//----------------------
    	//2) tro-master  
		if (x_oldTroSeq != "") {
    	    setFormToData_TroMst(x_oldTroSeq);
		}	
    	setDataToForm_TroMst(currTroSeq); 
    	//----------------------
    	//3) tro-detail
    	if (x_oldTroSeq != "") {    		
    	    setDataToAllData_TroDtl(x_oldTroSeq, currTroSubSeq);  
    	}
    	setAllDataToData_TroDtl(currTroSeq, 1);                   
    	//----------------------
    	//4) x_oldTroSeq Save  	
    	x_oldTroSeq=comboObj.GetSelectText();  //currTroSeq
    }
    /**
    * Tro dtl : prev/next Btn Click Event Handling
    */
    function changeTroSeqProc_dtl(gubun) {   
    	var formObj=document.form;
    	var comboObj=tro_seq; 
    	with (formObj) {
    		var currTroSeq=comboObj.GetSelectText();
    		var currTroSubSeq=tro_sub_seq_currcnt.value;
	    	var n_tro_sub_seq_currcnt=parseInt(tro_sub_seq_currcnt.value);
	    	var n_tro_sub_seq_maxcnt=parseInt(tro_sub_seq_maxcnt.value);
	    	var n_t_tro_sub_seq=null;
	    	if (gubun == "P") {
	    		n_t_tro_sub_seq=n_tro_sub_seq_currcnt - 1;
	    	} else if (gubun == "N") {
	    		n_t_tro_sub_seq=n_tro_sub_seq_currcnt + 1;
	    	}
	    	setDataToAllData_TroDtl(currTroSeq, currTroSubSeq); 
	    	setAllDataToData_TroDtl(currTroSeq, n_t_tro_sub_seq); 
    	}
    }
    /**
    * Tro-dtl : dtl Prev/Dtl disabled Handling 
    */    
    function changeEnabled_dtl_PrevNext() {
    	var formObj=document.form;
    	with (formObj) {
        	var n_tro_sub_seq_currcnt=parseInt(tro_sub_seq_currcnt.value);
        	var n_tro_sub_seq_maxcnt=parseInt(tro_sub_seq_maxcnt.value);
        	var n_t_tro_sub_seq=null;
        	if (n_tro_sub_seq_maxcnt <= 1 || nullToBlank2(tro_sub_seq_currcnt.value)=="") {
        		ComEnableManyTd(false, "btn_t2cPrevious", "btn_t2cNext");  
    	    } else if ( n_tro_sub_seq_currcnt <= 1 ) {
       		    ComEnableManyTd(false, "btn_t2cPrevious");  
       		    ComEnableManyTd(true,  "btn_t2cNext"); 
        	} else if ( n_tro_sub_seq_currcnt == n_tro_sub_seq_maxcnt ) {
        		ComEnableManyTd(true,  "btn_t2cPrevious");  
        		ComEnableManyTd(false, "btn_t2cNext"); 
        	} else {
        		ComEnableManyTd(true, "btn_t2cPrevious", "btn_t2cNext"); 
        	}
    	}
    }
    /**
    * Tro-Dtl : Dtl DisEditable Handling 
    */    
    function changeDtlColor() {    	
    	var formObj=document.form;
    	//-------------------------------------------
    	//1) cxl_flg input_hidded: Master Editable Handling
    	var so_flg=(nullToBlank2(formObj.so_no.value) == "")? "N" : "Y";
    	//if (formObj.cxl_flg.value == "Y" || formObj.cfm_flg.value == "Yes") {
    	if (formObj.cxl_flg.value == "Y" || so_flg == "Y" || formObj.cfm_flg.value == "Yes" ) {
			changeEnabeld_haulage_dtl();  //Haulage change color
			changeEnabled_dtl(false); 		
		} else {
			changeEnabled_dtl(true);  
			changeEnabeld_haulage_dtl();  //Haulage change color
		}    	
		//-------------------------------------------
    	//2) Add/Del, Enabled Change
		//if (formObj.cfm_flg.value == "Yes" || formObj.so_no.value != "") {
		if (so_flg == "Y" || formObj.cfm_flg.value == "Yes" ) {
			ComEnableManyTd(false, "btn_t2cAdd", "btn_t2cDelete");
		}
		//-------------------------------------------
    	//3) Prev/Next, Enabled Change 
		changeEnabled_dtl_PrevNext();
    }
    /**
    * Tro-Master : Master Editable Handling 
    */    
    function changeMasterColor() {
    	var formObj=document.form;
    	//-------------------------------------------
    	//1) Master Editable Handling    	
    	var p_cxl_flg=formObj.cxl_flg.value;
    	var p_cfm_flg=(formObj.cfm_flg.value == "Yes")? "Y" : "N";
        var p_so_no_flg=(nullToBlank2(formObj.so_no.value) == "")? "N" : "Y";    	
        changeEnabled_master_control(p_cxl_flg, p_cfm_flg, p_so_no_flg);
		//-------------------------------------------
    	//2) Color Change 
		setChangeAllComboBackColor();
    	//----------------------
    	//3) tro_seq별 SaveSeq Btn Status Control
	    var t_max_tro_seq_old=(nullToBlank2(formObj.max_tro_seq_old.value)=="")? "0" : formObj.max_tro_seq_old.value; 
	    var t_currTroSeq=tro_seq.GetSelectText();
	    if (parseInt(t_currTroSeq) > parseInt(t_max_tro_seq_old)+1) {
	    	ComEnableManyTd(false, "btn_t2cSaveSeq"); 
	    } else {
	    	ComEnableManyTd(true, "btn_t2cSaveSeq"); 
	    }
    }
    /**
    * Tro-Master
    */
    function changeEnabled_master_control(p_cxl_flg, p_cfm_flg, p_so_no_flg) {
        var formObj=document.form;         		
        var p_eur_trns_tp_cd=formObj.eur_trns_tp_cd.value;
        //canceled : display
        if (p_cxl_flg == "Y") {
        	document.all.canceled.innerHTML='<font color="red">Canceled</font>';	
        } else if (p_eur_trns_tp_cd == "FR") {
        	document.all.canceled.innerHTML='<font color="red">Frustrate</font>';	
        } else {
        	document.all.canceled.innerHTML='';	
        }
        //eur_trns_tp_cd
 		//master all : disabled 
    	//if (p_cxl_flg == "Y" || p_cfm_flg == "Y") {
//        if (p_cxl_flg == "Y" || p_so_no_flg == "Y"|| p_cfm_flg == "Y") {
        if (p_cxl_flg == "Y") {
			changeEnabeld_haulage_master();  //Haulage change color
			changeEnabled_master(false);
        } else if (p_so_no_flg == "Y"|| p_cfm_flg == "Y"){
			changeEnabeld_haulage_master();  //Haulage change color
			changeEnabled_master_conf(false);
		} else { 
			changeEnabled_master(true);
			changeEnabeld_haulage_master();  //Haulage change color
		}
    }
    /**
    * Tro-Dtl : Halage OnChange Control Change Handling 
    */      
    function changeEnabeld_haulage_dtl() {
    	var formObj=document.form;
    	var haulage=hlg_tp_cd.GetSelectText();
        with(formObj) {  
        	if (haulage == "C") {
        		ComClassNameManyObjects_loc("input1",  dor_loc_cd, zn_cd, dor_pst_no, dor_addr_1, dor_addr_2, arr_dt, arr_dt_hhmi);             //className : Mandatory	
        		ComClassNameManyObjects_loc("input",   dor_addr_3, dor_addr_4, cntc_pson_nm, cntc_phn_no, cntc_eml);    //className : select    
        		ComEnableManyObjects_loc   (true,      dor_loc_cd, zn_cd, btns_popLocation, dor_pst_no, 
        				                               dor_addr_1, dor_addr_2, dor_addr_3, dor_addr_4, btns_Address, 
        				                               arr_dt, btns_calendar_3, arr_dt_hhmi, cntc_pson_nm, cntc_phn_no, cntc_eml);  //Active   		
//        		ComEnableManyIBCombo       (true, "#CCFFFD",  dor_addr_tp_cd);  //Active
    	 		comboObjects[6].SetEnable(true);
        		
        		
        	} else if (haulage == "M") {
        		ComClassNameManyObjects_loc("input",   dor_loc_cd, zn_cd, dor_pst_no, 
        				                               dor_addr_1, dor_addr_2, dor_addr_3, dor_addr_4, 
        				                               arr_dt, arr_dt_hhmi, cntc_pson_nm, cntc_phn_no, cntc_eml);                   //className : select  
        		ComEnableManyObjects_loc   (true,      dor_addr_1, dor_addr_2, dor_addr_3, dor_addr_4);                             //Active   		
        		ComEnableManyObjects_loc   (false,     dor_loc_cd, zn_cd, btns_popLocation, dor_pst_no, 
        				                               dor_addr_1, dor_addr_2, dor_addr_3, dor_addr_4, btns_Address, 
        				                               arr_dt, btns_calendar_3, arr_dt_hhmi, cntc_pson_nm, cntc_phn_no, cntc_eml);  //Dis-Active
//        		ComEnableManyIBCombo       (false, "", dor_addr_tp_cd);         //Dis-Active
        		comboObjects[6].SetEnable(false);
        	}
        }
    }
    /**
    * Tro-Master : Halage OnChange Control Change Handling 
    */    
    function changeEnabeld_haulage_master() {
    	var formObj=document.form;
    	var haulage=hlg_tp_cd.GetSelectText();
        with(formObj) {
        	if (haulage == "C") {
        		ComClassNameManyObjects_loc("input1",  cgo_wgt, tro_cmdt_cd, rep_cmdt_cd, rep_cmdt_nm);                         //className : Mandatory	
        		if (io_bnd_cd.value == "I") {
        			ComClassNameManyObjects_loc("input1",  cntr_pkup_yd_cd, cntr_pkup_dt, cntr_pkup_dt_hhmi);                   //className : Mandatory	
        			ComClassNameManyObjects_loc("input",   cntr_rtn_yd_cd, cntr_rtn_dt, cntr_rtn_dt_hhmi);                      //className : select         	        			
        			ComEnableManyObjects_loc   (true,      cntr_pkup_yd_cd, cntr_pkup_dt, btns_calendar_2, cntr_pkup_dt_hhmi);  //Active
            		ComEnableManyObjects_loc   (false,     cntr_rtn_yd_cd, cntr_rtn_dt, btns_calendar, cntr_rtn_dt_hhmi, comm_ofc_cd);       //Dis-Active	
        		} else {
        			ComClassNameManyObjects_loc("input",   cntr_pkup_yd_cd, cntr_pkup_dt, cntr_pkup_dt_hhmi);                   //className : select
        			ComClassNameManyObjects_loc("input1",  cntr_rtn_yd_cd, cntr_rtn_dt, cntr_rtn_dt_hhmi);                      //className : Mandatory         	
        			ComEnableManyObjects_loc   (false,     cntr_pkup_yd_cd, cntr_pkup_dt, btns_calendar_2, cntr_pkup_dt_hhmi);  //Dis-Active	
            		ComEnableManyObjects_loc   (true,      cntr_rtn_yd_cd, cntr_rtn_dt, btns_calendar, cntr_rtn_dt_hhmi);       //Active	
        		}
        		ComEnableManyObjects_loc(true, cgo_wgt, tro_cmdt_cd, rep_cmdt_cd, rep_cmdt_nm, btns_repCommodity, 
                                               btn_t2cAdd, btn_t2cDelete);       //Active   		
        		//ComEnableManyIBCombo    (true, "#CCFFFD",  bkg_trsp_mzd_cd);     //Active
        		comboObjects[5].SetEnable(true);
        		
        	} else if (haulage == "M") {		
        		ComClassNameManyObjects_loc("input",   cgo_wgt, tro_cmdt_cd, rep_cmdt_cd, rep_cmdt_nm);                     //className : select          		
        		if (io_bnd_cd.value == "I") {
        			ComClassNameManyObjects_loc("input1",  cntr_pkup_dt, cntr_pkup_dt_hhmi, 
                                                           cntr_rtn_yd_cd, cntr_rtn_dt, cntr_rtn_dt_hhmi);                  //className : Mandatory	   		
        			ComClassNameManyObjects_loc("input",   cntr_pkup_yd_cd);                                                //className : select  
            		ComEnableManyObjects_loc   (true,     comm_ofc_cd);       												//Dis-Active	
        		} else {
        			ComClassNameManyObjects_loc("input1",  cntr_pkup_yd_cd, cntr_pkup_dt, cntr_pkup_dt_hhmi, 
        					                               cntr_rtn_dt, cntr_rtn_dt_hhmi);                                  //className : Mandatory	   		
        			ComClassNameManyObjects_loc("input",   cntr_rtn_yd_cd);                                                 //className : select  
        		}        		
        		ComEnableManyObjects_loc(true,  cntr_pkup_yd_cd, cntr_pkup_dt, btns_calendar_2, cntr_pkup_dt_hhmi,
                                                cntr_rtn_yd_cd, cntr_rtn_dt, btns_calendar, cntr_rtn_dt_hhmi);              //Active
        		ComEnableManyObjects_loc(false, cgo_wgt, tro_cmdt_cd, rep_cmdt_cd, rep_cmdt_nm, btns_repCommodity, 
        				                        btn_t2cAdd, btn_t2cDelete);      //Dis-Active
//        		ComEnableManyIBCombo    (false, "", bkg_trsp_mzd_cd);            //Dis-Active
        		comboObjects[5].SetEnable(false);
        	}
        }
    }
    /**
    * Tro-Master : Editable Handling 
    */
    function changeEnabled_master(bFlag) {
        var formObj=document.form;        
        with(formObj) {        	
            ComEnableManyObjects_loc(bFlag, rqst_sub_seq, cntr_no, cntr_tpsz_cd, cgo_wgt, cntr_pkup_yd_cd, cntr_rtn_yd_cd, cntr_rtn_dt, cntr_rtn_dt_hhmi, 
            		                        tro_cmdt_cd, rep_cmdt_nm, rep_cmdt_cd, cntr_pkup_dt, cntr_pkup_dt_hhmi, spcl_instr_rmk,
            		                        btns_t2cSearchCntrNo, btns_repCommodity, btns_calendar, btns_calendar_2);
//	    	ComEnableManyIBCombo(bFlag, "", dcgo_seq, rc_seq, awk_cgo_seq, hlg_tp_cd, bkg_trsp_mzd_cd);
	    	//ComEnableManyTd(bFlag, "btn_t2cCopyCNTR");
        }
//	    	ComEnableManyIBCombo(bFlag, "", dcgo_seq, rc_seq, awk_cgo_seq, hlg_tp_cd, bkg_trsp_mzd_cd);
        comboObjects[1].SetEnable(bFlag);
        comboObjects[2].SetEnable(bFlag);
        comboObjects[3].SetEnable(bFlag);
        comboObjects[4].SetEnable(bFlag);
        comboObjects[5].SetEnable(bFlag);
        
    }
    /**
     * Tro-Master : Editable Handling (Confirmed case)
     */
     function changeEnabled_master_conf(bFlag) {
         var formObj=document.form;        
         with(formObj) {
             ComEnableManyObjects_loc(bFlag, rqst_sub_seq, cntr_no, cntr_tpsz_cd, cgo_wgt,
             		                        tro_cmdt_cd, rep_cmdt_nm, rep_cmdt_cd, cntr_pkup_dt, cntr_pkup_dt_hhmi, spcl_instr_rmk,
             		                        btns_t2cSearchCntrNo, btns_repCommodity, btns_calendar, btns_calendar_2);
// 	    	ComEnableManyIBCombo(bFlag, "", dcgo_seq, rc_seq, awk_cgo_seq, hlg_tp_cd, bkg_trsp_mzd_cd);
 	    	//ComEnableManyTd(bFlag, "btn_t2cCopyCNTR");
         }
// 	    	ComEnableManyIBCombo(bFlag, "", dcgo_seq, rc_seq, awk_cgo_seq, hlg_tp_cd, bkg_trsp_mzd_cd);
         comboObjects[1].SetEnable(bFlag);
         comboObjects[2].SetEnable(bFlag);
         comboObjects[3].SetEnable(bFlag);
         comboObjects[4].SetEnable(bFlag);
         comboObjects[5].SetEnable(bFlag);
         
     }
    /**
    * Tro-Dtl : Editable Handling 
    */
    function changeEnabled_dtl(bFlag) {
        var formObj=document.form;
        with(formObj) {        	
            ComEnableManyObjects_loc(bFlag, dor_loc_cd, zn_cd, lod_ref_no, dor_pst_no, 
            		                        dor_addr_1, dor_addr_2, dor_addr_3, dor_addr_4, 
            		                        arr_dt, arr_dt_hhmi, cntc_pson_nm, cntc_phn_no, cntc_eml, 
            		                        btns_popLocation, btns_Address, btns_calendar_3);
	    	ComEnableManyTd(bFlag, "btn_t2cAdd", "btn_t2cDelete");	    	
        }
//	    	ComEnableManyIBCombo(bFlag, "", dor_addr_tp_cd);
        comboObjects[6].SetEnable(bFlag);
        
    }
    //######################[2. Button Proc : Add/Copy/Cancel/Confirm/Sumqty]#####################
	/**     
	  * delete_dtl
	  */
	function deleteDtl() {
 	    var formObj=document.form; 
		var sheetObj=x_sheetObject3; 
		var tro_seq=comboObjects[0].GetSelectText();	//tro_seq
		var tro_sub_seg=formObj.tro_sub_seq.value;
		var nSRow=findRow_dtl_curr(tro_seq, tro_sub_seg, "V");
		//1) tro-detail : del
//		sheetObj.CellValue2(nSRow, "ibflag") = "D";		
		sheetObj.SetRowStatus(nSRow,"D");
	}
	/**     
	 *  Copy Handling Logic Control
	 */
	function copyRow(sheetObj) {
	  	var formObj=document.form;	  	
	  	if (formObj.cxl_flg.checked) {
	  		ComShowCodeMessage("BKG02022");  //"TP/SZ is full over!"
	  		return;
	  	}	
		sheetObj.ReDraw=false;
	    if (sheetObj.id == "t2csheet2")  //master
	    {
			var strCopyCnt=formObj.tro_copy_cnt.value;	
		    if (strCopyCnt == "") {
		    	strCopyCnt="1"; 
		    }
		    var nCopyCnt=parseInt(strCopyCnt);
	    	var nCopyRow=sheetObj.FindText("tro_seq", tro_seq.GetSelectText());
	    	for (var i=0; i<nCopyCnt; i++) {
	    		addRow(sheetObj, "C", nCopyRow);
	    	}
	    } 
	    ComSetObjValue(tro_seq, ComGetObjValue(formObj.tro_seq_maxcnt));
	    
		tro_seq_OnChange(tro_seq,'','');
	    sheetObj.ReDraw=true;
	}
	/** 
	 *  CopyCNTR dtl AllCopy Handling Logic Control 
	 */
    function copyAllRow_dtl(sheetObj, newTroSeq, sheetObj_copy, copyTroSeq) {
        var formObj=document.form; 
    	//sheetObj_copy.CheckAll2("chk") = 0;  //hidden chk : check clear
    	for (var i=1; i<=sheetObj_copy.RowCount(); i++) {
    		if (sheetObj_copy.GetCellValue(i, "chk") == 1) {
    			sheetObj_copy.SetCellValue(i, "chk",0,0);
    		}
    	}
        var nRow=0;  //findRow 
        var nStartRow=0;  //find Start Index 
        while (nRow > -1) {
    	    nRow=sheetObj_copy.FindText("tro_seq", copyTroSeq, nStartRow);
    	    if (nRow > -1) { 
    	    	sheetObj_copy.SetCellValue(nRow, "chk",1,0);//maxcount
    		    nStartRow=nRow+1;
    	    }
        } 
        //max sub_seq : get
        var sRow=sheetObj_copy.FindCheckedRow("chk")+"|";
        var arrRow=sRow.split("|");        
        for (var idx=0; idx<=arrRow.length-2; idx++)
        { 
        	addRow(sheetObj, "C", arrRow[idx], newTroSeq, sheetObj_copy);  //arrRow[idx]:copyRow, sheetObj:x_sheetObject3, sheetObj_copy:x_sheetObject3
        } 
    }
    /**     
    * AddRow Handling Logic Control 
    */
    function addRow(sheetObj, NCflag, nCopyRow, newCopyTroSeq, sheetObj_copy) {  
    	var formObj=document.form;  
    	if (NCflag == null) {
    		NCflag="N";  //N:New, C:Copy  
    	}
	    if (sheetObj.id == "t2csheet2")       //master
	    {	    	    	
	    	if (NCflag == "C") 
	    	{
	    		//pre_master/dtl : store
				if (x_oldTroSeq != "") {
		    	    setFormToData_TroMst(x_oldTroSeq);                                      //tro-master : store 
		    	    var currTroSubSeq_v=formObj.tro_sub_seq.value; 
		    	    setDataToAllData_TroDtl(x_oldTroSeq, currTroSubSeq_v, "V");             //tro-dtl    : store
				}
				//master : add
		    	var nNewRow=sheetObj.DataInsert(-1);                                   //add row : master
		    	var copyTroSeq=sheetObj.GetCellValue(nCopyRow, "tro_seq");
		    	//master : copy
		    	var newTroSeq=setDefaultInsertRow(sheetObj, nNewRow, NCflag, nCopyRow);   //default setting : master
		    	setDataCopy(sheetObj, nNewRow, nCopyRow);                                   //copy data : master
		    	//tro_seq combo : copy 
			   	tro_seq.InsertItem(-1, newTroSeq, newTroSeq);	                    //form tro_seq combo : add	
			   	ComSetObjValue(formObj.tro_seq_maxcnt, sheetObj.RowCount());
			   	//dg_seq : copy 
			   	copyTrodgseq(copyTroSeq, newTroSeq); 
			   	
			   	//dtl_all : copy -> call
			   	copyAllRow_dtl(x_sheetObject3, newTroSeq, x_sheetObject3, copyTroSeq);
	            //sum-qty : change  
	            var PM_gubun="P";  //P:Plus, M:Minus 
	            var p_Row=nNewRow;
	            var p_currVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd");
	            var p_currVal_hlg=sheetObj.GetCellValue(p_Row, "hlg_tp_cd");
	            plusMinusSumTroQty(p_currVal_type, p_currVal_hlg, "1", PM_gubun);	
	    	} 
	    	else 
	    	{
	    		var nNewRow=sheetObj.DataInsert(-1);                                    //add row : master
	    		var newTroSeq=setDefaultInsertRow(sheetObj, nNewRow, NCflag, nCopyRow);   //default setting : master 
			   	tro_seq.InsertItem(-1, newTroSeq, newTroSeq);	                    //form tro_seq combo : add
//	    		tro_seq.SetSelectText(newTroSeq,false);//form tro_seq combo : change
	    		comboObjects[0].SetSelectText(newTroSeq,false);//form tro_seq combo : change
	    		
			   	ComSetObjValue(formObj.tro_seq_maxcnt, sheetObj.RowCount());
		       	changeTroSeqProc();                                                         //store/display/old_tro_seq : change
		       	addRow(x_sheetObject3);                                                     //add row : dtl
	            //sum-qty : change  
	            var PM_gubun="P";  //P:Plus, M:Minus 
	            var p_Row=nNewRow;
	            var p_currVal_type=sheetObj.GetCellValue(p_Row, "cntr_tpsz_cd");
	            var p_currVal_hlg=sheetObj.GetCellValue(p_Row, "hlg_tp_cd");
	            //alert("^^p_currVal_type, p_currVal_hlg, p_Row->"+p_currVal_type+","+p_currVal_hlg+","+p_Row);
	            plusMinusSumTroQty(p_currVal_type, p_currVal_hlg, "1", PM_gubun);
	    	}
	    } 
		else if (sheetObj.id == "t2csheet3")  //dtl
	    { 
	    	if (NCflag == "C") 
	    	{
				if (newCopyTroSeq != null)    //dtl all : copy 
				{
					var nNewRow=sheetObj.DataInsert(-1);
		    		sheetObj.SetCellValue(nNewRow, "tro_seq",newCopyTroSeq,0);
		    		sheetObj.SetCellValue(nNewRow, "tro_sub_seq",sheetObj_copy.GetCellValue(nCopyRow, "tro_sub_seq"),0);
		    		//sheetObj.CellValue2(nNewRow, "del")         = sheetObj_copy.CellValue(nCopyRow, "del");   //'N';
		    		setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy);
		        } 
	    	} else {
	    		var currTroSeq=tro_seq.GetSelectText();
	    		var currTroSubSeq_v=formObj.tro_sub_seq.value;
	    		//1) dtl : store
	        	if (x_oldTroSeq != "") { 
	        	    setDataToAllData_TroDtl(currTroSeq, currTroSubSeq_v, "V");  
	        	}
	    		//2) insert data : defalut 
	    		var nNewRow=sheetObj.DataInsert(-1);
	    		setDefaultInsertRow_Dtl(sheetObj, nNewRow, currTroSeq);  //dtl : add  
	    		//3) display
	    		var currTroSeq_new=sheetObj.GetCellValue(nNewRow, "tro_seq");
	    		var currTroSubSeq_new_v=sheetObj.GetCellValue(nNewRow, "tro_sub_seq");
	    		setAllDataToData_TroDtl(currTroSeq_new, currTroSubSeq_new_v, "V");
	    	}
		}
    }
    /**     
    * [tro_master]AddRow Copy Data
    */
	function setDataCopy(sheetObj, nNewRow, nCopyRow) {
        var formObj=document.form;
        var sheetObj=x_sheetObject2;
        //alert("nNewRow,nCopyRow->"+nNewRow+","+nCopyRow);  
        sheetObj.SetCellValue(nNewRow, "hlg_tp_cd",sheetObj.GetCellValue(nCopyRow, "hlg_tp_cd"),0);
        sheetObj.SetCellValue(nNewRow, "rqst_sub_seq",sheetObj.GetCellValue(nCopyRow, "rqst_sub_seq"),0);
    	//sheetObj.CellValue2(nNewRow, "cntr_no")           = sheetObj.CellValue(nCopyRow, "cntr_no"); 
		sheetObj.SetCellValue(nNewRow, "cntr_tpsz_cd",sheetObj.GetCellValue(nCopyRow, "cntr_tpsz_cd"),0);
		sheetObj.SetCellValue(nNewRow, "cgo_wgt",sheetObj.GetCellValue(nCopyRow, "cgo_wgt"),0);
		sheetObj.SetCellValue(nNewRow, "cntr_pkup_yd_cd",sheetObj.GetCellValue(nCopyRow, "cntr_pkup_yd_cd"),0);
		sheetObj.SetCellValue(nNewRow, "cntr_rtn_yd_cd",sheetObj.GetCellValue(nCopyRow, "cntr_rtn_yd_cd"),0);
		sheetObj.SetCellValue(nNewRow, "cntr_rtn_dt",sheetObj.GetCellValue(nCopyRow, "cntr_rtn_dt"),0);
		sheetObj.SetCellValue(nNewRow, "cntr_rtn_dt_hhmi",sheetObj.GetCellValue(nCopyRow, "cntr_rtn_dt_hhmi"),0);
		sheetObj.SetCellValue(nNewRow, "tro_cmdt_cd",sheetObj.GetCellValue(nCopyRow, "tro_cmdt_cd"),0);
		sheetObj.SetCellValue(nNewRow, "rep_cmdt_nm",sheetObj.GetCellValue(nCopyRow, "rep_cmdt_nm"),0);
		sheetObj.SetCellValue(nNewRow, "rep_cmdt_cd",sheetObj.GetCellValue(nCopyRow, "rep_cmdt_cd"),0);
		sheetObj.SetCellValue(nNewRow, "bkg_trsp_mzd_cd",sheetObj.GetCellValue(nCopyRow, "bkg_trsp_mzd_cd"),0);
		sheetObj.SetCellValue(nNewRow, "cntr_pkup_dt",sheetObj.GetCellValue(nCopyRow, "cntr_pkup_dt"),0);
		sheetObj.SetCellValue(nNewRow, "cntr_pkup_dt_hhmi",sheetObj.GetCellValue(nCopyRow, "cntr_pkup_dt_hhmi"),0);
		sheetObj.SetCellValue(nNewRow, "spcl_instr_rmk",sheetObj.GetCellValue(nCopyRow, "spcl_instr_rmk"),0);
    	//sheetObj.CellValue2(nNewRow, "cfm_flg")           = sheetObj.CellValue(nCopyRow, "cfm_flg");
    	//sheetObj.CellValue2(nNewRow, "cfm_dt")            = sheetObj.CellValue(nCopyRow, "cfm_dt");
    	//sheetObj.CellValue2(nNewRow, "cfm_ofc_cd")        = sheetObj.CellValue(nCopyRow, "cfm_ofc_cd");
    	//sheetObj.CellValue2(nNewRow, "cfm_usr_id")        = sheetObj.CellValue(nCopyRow, "cfm_usr_id");
    	//sheetObj.CellValue2(nNewRow, "so_no")             = sheetObj.CellValue(nCopyRow, "so_no");
    	//sheetObj.CellValue2(nNewRow, "so_dt")             = sheetObj.CellValue(nCopyRow, "so_dt");
    	//sheetObj.CellValue2(nNewRow, "so_ofc_cd")         = sheetObj.CellValue(nCopyRow, "so_ofc_cd");
    	//sheetObj.CellValue2(nNewRow, "so_usr_id")         = sheetObj.CellValue(nCopyRow, "so_usr_id"); 
		sheetObj.SetCellValue(nNewRow, "cntr_prt_flg",sheetObj.GetCellValue(nCopyRow, "cntr_prt_flg"),0);
		sheetObj.SetCellValue(nNewRow, "t1_doc_flg",sheetObj.GetCellValue(nCopyRow, "t1_doc_flg"),0);
		sheetObj.SetCellValue(nNewRow, "cstms_clr_no",sheetObj.GetCellValue(nCopyRow, "cstms_clr_no"),0);
		sheetObj.SetCellValue(nNewRow, "all_in_rt_cd",sheetObj.GetCellValue(nCopyRow, "all_in_rt_cd"),0);
		sheetObj.SetCellValue(nNewRow, "curr_cd",sheetObj.GetCellValue(nCopyRow, "curr_cd"),0);
		sheetObj.SetCellValue(nNewRow, "trns_rev_amt",sheetObj.GetCellValue(nCopyRow, "trns_rev_amt"),0);
		sheetObj.SetCellValue(nNewRow, "non_trns_rev_amt",sheetObj.GetCellValue(nCopyRow, "non_trns_rev_amt"),0);
		sheetObj.SetCellValue(nNewRow, "add_rev_amt",sheetObj.GetCellValue(nCopyRow, "add_rev_amt"),0);
		sheetObj.SetCellValue(nNewRow, "add_rev_chg_cd",sheetObj.GetCellValue(nCopyRow, "add_rev_chg_cd"),0);
		sheetObj.SetCellValue(nNewRow, "vat_flg",sheetObj.GetCellValue(nCopyRow, "vat_flg"),0);
		sheetObj.SetCellValue(nNewRow, "rc_seq",sheetObj.GetCellValue(nCopyRow, "rc_seq"),0);
		sheetObj.SetCellValue(nNewRow, "awk_cgo_seq",sheetObj.GetCellValue(nCopyRow, "awk_cgo_seq"),0);
    	//hidden  
		sheetObj.SetCellValue(nNewRow, "cntr_tpsz_cd_old",sheetObj.GetCellValue(nCopyRow, "cntr_tpsz_cd_old"),0);
		sheetObj.SetCellValue(nNewRow, "hlg_tp_cd_old",sheetObj.GetCellValue(nCopyRow, "hlg_tp_cd_old"),0);
    	sheetObj.SetCellValue(nNewRow, "cxl_flg","N",0);
	} 
    /**     
    * [tro_dtl]AddRow Copy Data
    */
	function setDataCopy_dtl(sheetObj, nNewRow, nCopyRow, sheetObj_copy) {
	    var formObj=document.form;	
	    if (sheetObj_copy == null) {
	    	sheetObj_copy=sheetObj;
	    }
			sheetObj.SetCellValue(nNewRow, "dor_addr_tp_cd",sheetObj_copy.GetCellValue(nCopyRow, "dor_addr_tp_cd"),0);
			sheetObj.SetCellValue(nNewRow, "dor_loc_cd",sheetObj_copy.GetCellValue(nCopyRow, "dor_loc_cd"),0);
			sheetObj.SetCellValue(nNewRow, "zn_cd",sheetObj_copy.GetCellValue(nCopyRow, "zn_cd"),0);
			sheetObj.SetCellValue(nNewRow, "lod_ref_no",sheetObj_copy.GetCellValue(nCopyRow, "lod_ref_no"),0);
			sheetObj.SetCellValue(nNewRow, "dor_pst_no",sheetObj_copy.GetCellValue(nCopyRow, "dor_pst_no"),0);
			sheetObj.SetCellValue(nNewRow, "dor_addr_1",sheetObj_copy.GetCellValue(nCopyRow, "dor_addr_1"),0);
			sheetObj.SetCellValue(nNewRow, "dor_addr_2",sheetObj_copy.GetCellValue(nCopyRow, "dor_addr_2"),0);
			sheetObj.SetCellValue(nNewRow, "dor_addr_3",sheetObj_copy.GetCellValue(nCopyRow, "dor_addr_3"),0);
			sheetObj.SetCellValue(nNewRow, "dor_addr_4",sheetObj_copy.GetCellValue(nCopyRow, "dor_addr_4"),0);
			sheetObj.SetCellValue(nNewRow, "arr_dt",sheetObj_copy.GetCellValue(nCopyRow, "arr_dt"),0);
			sheetObj.SetCellValue(nNewRow, "arr_dt_hhmi",sheetObj_copy.GetCellValue(nCopyRow, "arr_dt_hhmi"),0);
			sheetObj.SetCellValue(nNewRow, "cntc_pson_nm",sheetObj_copy.GetCellValue(nCopyRow, "cntc_pson_nm"),0);
			sheetObj.SetCellValue(nNewRow, "cntc_phn_no",sheetObj_copy.GetCellValue(nCopyRow, "cntc_phn_no"),0);
			sheetObj.SetCellValue(nNewRow, "cntc_eml",sheetObj_copy.GetCellValue(nCopyRow, "cntc_eml"),0);
					//sheetObj.CellValue2(nNewRow, "cxl_flg")        = "N";	
			sheetObj.SetCellValue(nNewRow, "cntr_tpsz_cd_old",sheetObj_copy.GetCellValue(nCopyRow, "cntr_tpsz_cd"),0);
			sheetObj.SetCellValue(nNewRow, "tro_qty_old",sheetObj_copy.GetCellValue(nCopyRow, "tro_qty"),0);
	}
    /**     
    * [tro_master_multicombo]AddRow Copy Data
    */
    function copyTrodgseq(copy_tro_seq, new_tro_seq) {
	    var sheetObj=x_sheetObject4;  
	    //1) dtl check (tro_seq) 
	    sheetObj.CheckAll("del_chk",0,1);//hidden chk : check clear
        //2) copy_tro_seq checking
//        var nRow=0;  //findRow 
//        var nStartRow=0;  //find Start Index 
//        while (nRow > -1) {
//    	    nRow=sheetObj.FindText("tro_seq", copy_tro_seq, nStartRow);
//    	    if (nRow > -1) { 
//    		    sheetObj.SetCellValue(nRow, "del_chk",1,0);
//    		    nStartRow=nRow+1;
//    	    }
//        } 
        //3) sheetObj.copy 
//        var sRow=sheetObj.FindCheckedRow("del_chk");
//        var arrRow=sRow.split("|");
//        for (var idx=0; idx<=arrRow.length-2; idx++)
//        { 
//	        var nNewRow=sheetObj.DataInsert(-1);
//	        sheetObj.SetCellValue(nNewRow, "tro_seq",new_tro_seq,0);
//	        sheetObj.SetCellValue(nNewRow, "tro_dcgo_seq",sheetObj.GetCellValue(arrRow[idx], "tro_dcgo_seq"),0);
//        }
	    var rowCount = sheetObj.RowCount();
	    for(i=1;i<=rowCount;i++){
	    	if(sheetObj.GetCellValue(i, "tro_seq")==copy_tro_seq){
	    		var nNewRow=sheetObj.DataInsert(-1);
	    		sheetObj.SetCellValue(nNewRow, "tro_seq",new_tro_seq,0);
	    		sheetObj.SetCellValue(nNewRow, "tro_dcgo_seq",sheetObj.GetCellValue(i, "tro_dcgo_seq"),0);
	    	}
	    }
    } 
    /**     
    * [tro_master]AddRow Set Default Value
    */
    function setDefaultInsertRow(sheetObj, nRow, NCflag, nCopyRow) {
	   	var formObj=document.form; 
	   	var prevMaxTroSeq=""; 
	   	prevMaxTroSeq=getPrevMaxTroSeq(sheetObj, nRow, "tro_seq"); 
	   	with(formObj) {
        	sheetObj.SetCellValue(nRow, "tro_seq",parseInt(prevMaxTroSeq) + 1,0);//new tro_seq : max+1
        	sheetObj.SetCellValue(nRow, "hlg_tp_cd","C",0);
        	sheetObj.SetCellValue(nRow, "cxl_flg","N",0);
        	//sheetObj.CellValue2(nRow, "rqst_sub_seq")      = "001";
        	sheetObj.SetCellValue(nRow, "rqst_sub_seq","1",0);
        	sheetObj.SetCellValue(nRow, "cntr_tpsz_cd",getDefaultVal_tpsz(),0);
        	if (term.value == "D") {
        		sheetObj.SetCellValue(nRow, "all_in_rt_cd","Y",0);
        	} else {
        		sheetObj.SetCellValue(nRow, "all_in_rt_cd","N",0);
        	}
        	sheetObj.SetCellValue(nRow, "vat_flg","N",0);
			sheetObj.SetCellValue(nRow, "hlg_tp_cd_old",sheetObj.GetCellValue(nRow, "hlg_tp_cd"),0);//!!!!!!!!!!!!!!
			sheetObj.SetCellValue(nRow, "cntr_tpsz_cd_old",sheetObj.GetCellValue(nRow, "cntr_tpsz_cd"),0);//!!!!!!!!!!!!!!
        	clearHaulageData_master(sheetObj, nRow, "C");  
        }  
	   	return sheetObj.GetCellValue(nRow, "tro_seq");
    }
    /**     
     * [tro_dtl]AddRow Set Default Value
     */
    function setDefaultInsertRow_Dtl(sheetObj, nRow, currTroSeq) { 
     	var formObj=document.form; 
   	    var prevMaxTroSubSeq=""; 
   	    prevMaxTroSubSeq=getPrevMaxTroSubSeq(sheetObj, currTroSeq, "tro_sub_seq");  
        with(formObj) { 
          	sheetObj.SetCellValue(nRow, "tro_seq",currTroSeq,0);
          	sheetObj.SetCellValue(nRow, "tro_sub_seq",parseInt(prevMaxTroSubSeq) + 1,0);//new tro_sub_seq : max+1
          	
          	clearHaulageData_dtl(sheetObj, nRow, "C");  
        }

    }
    /** 
     * Retrieve qtysum color Initialization 
     */  
    function changeTroQtyColor(sheetObj_qty) {
       	var formObj=document.form;  	
       	for(var i=1; i<=sheetObj_qty.RowCount(); i++) {
       		var cntr_tpsz_cd=sheetObj_qty.GetCellValue(i, "cntr_tpsz_cd");
       		var n_totQty=parseInt(sheetObj_qty.GetCellValue(i, "total_qty"));
       		var n_currTroqty_CH=parseInt(sheetObj_qty.GetCellValue(i, "tro_qty_ch"));
       		var n_currTroqty_MH=parseInt(sheetObj_qty.GetCellValue(i, "tro_qty_mh"));
   	    	var n_currTroqty=n_currTroqty_CH + n_currTroqty_MH;
   			if (n_totQty > n_currTroqty) {
   				sheetObj_qty.SetCellFontColor(i, "tro_qty_ch","#FF0000");
   				sheetObj_qty.SetCellFontColor(i, "tro_qty_mh","#FF0000");
   			} else if (n_totQty == n_currTroqty) {
   				sheetObj_qty.SetCellFontColor(i, "tro_qty_ch","#000000");
   				sheetObj_qty.SetCellFontColor(i, "tro_qty_mh","#000000");
   			} else if (nullToBlank2(sheetObj_qty.GetCellValue(i, "tro_qty_ch")) != ""  || nullToBlank2(sheetObj_qty.GetCellValue(i, "tro_qty_mh")) != "" ) {
   				if (nullToBlank2(sheetObj_qty.GetCellValue(i, "tro_qty_ch")) != "") {
   					sheetObj_qty.SetCellFontColor(i, "tro_qty_ch","#FF0000");
   				}
   				if (nullToBlank2(sheetObj_qty.GetCellValue(i, "tro_qty_mh")) != "") {
   					sheetObj_qty.SetCellFontColor(i, "tro_qty_mh","#FF0000");
   				}
   				//callShowMessageBiggerQty("TP/SZ:"+sheetObj_qty.CellValue(i, "cntr_tpsz_cd"));
   			}
       	}
    }  
    /**     
     * [tro_dtl]Change sumqty Change : All(P/M)
     */
     function changeSumTroQty(preVal_type, preVal_hlg, preTroQty, nxtVal_type, nxtVal_hlg, nxtTroQty) {
	  	var formObj=document.form;
	  	var sheetObj_qty=x_sheetObject5; 
	  	var bTotSumChange_flg=false;	  	
	  	var flexHgtFlg = formObj.flex_hgt_flg.value;
	  	if (preVal_type != nxtVal_type) {
	  		if(flexHgtFlg == "Y" && preVal_type.substring(0,1) == "D" && nxtVal_type.substring(0,1) == "D"){
	  			bTotSumChange_flg=false;
	  		}else{
	  			bTotSumChange_flg=true;
	  		}
	  	}
	  	sheetObj_qty.ReDraw=false; 
	    //1) next qty (+)Handling 
	    var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", nxtVal_type);
		if(flexHgtFlg == "Y" && (nSRow == -1 || nSRow == undefined)) {
			var flexCntrTpsz="";
			if (nxtVal_type == "D4") {
				flexCntrTpsz="D5";
			} else if(nxtVal_type == "D5"){
				flexCntrTpsz="D4";
			}
			nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", flexCntrTpsz);
		}
	    if (nSRow > -1 ) 
        {
	    	var tro_qty_colid=null;
			var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
			var n_currTroqty_ch=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_ch"));
			var n_currTroqty_mh=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_mh"));
			var n_currTroqty=null; 
			if (nxtVal_hlg == "C") {
				n_currTroqty=n_currTroqty_ch;
				tro_qty_colid="tro_qty_ch";
			} else if (nxtVal_hlg == "M") {
				n_currTroqty=n_currTroqty_mh; 
				tro_qty_colid="tro_qty_mh";
			}
			var n_t_chgTroqty=null; 
			if (bTotSumChange_flg) {
				n_t_chgTroqty=(n_currTroqty_ch + n_currTroqty_mh) + parseInt(nxtTroQty); 
			} else {
				n_t_chgTroqty=(n_currTroqty_ch + n_currTroqty_mh);
			}
			if (n_totQty > n_t_chgTroqty) {
				sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_ch","#FF0000");
				sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_mh","#FF0000");
			} else if (n_totQty == n_t_chgTroqty) {
				sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_ch","#000000");
				sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_mh","#000000");
			} else {
				if((preVal_hlg!= nxtVal_hlg) && (x_sheetObject2.GetCellValue(1, "tro_seq") == 1) && (x_sheetObject2.GetCellValue(1, "ibflag") == "I")){
				} else {	
					callShowMessageBiggerQty("TP/SZ:"+sheetObj_qty.GetCellValue(nSRow, "cntr_tpsz_cd"));
					formObj.cntr_tpsz_cd.value=preVal_type;  
					hlg_tp_cd.SetSelectCode(preVal_hlg,false);
					if (preVal_hlg != nxtVal_hlg) {
//						formObj.hlg_tp_cd.focus();
						ComSetFocus(formObj.hlg_tp_cd_text);
					} else {
						formObj.cntr_tpsz_cd.focus();
					}
					sheetObj_qty.ReDraw=true; 
					return false;
				}
			}
			//<-------------------
			//Value Change
			sheetObj_qty.SetCellValue(nSRow, tro_qty_colid,n_currTroqty + parseInt(nxtTroQty),0);
		  	//2) pre qty (-)Handling 
			var nSRow=0;
			if (sheetObj_qty.RowCount()== 1){
				nSRow=1;
			} else {
				nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", preVal_type);
			}
			if(flexHgtFlg == "Y" && (nSRow == -1 || nSRow == undefined) && preVal_type != "") {
				var flexCntrTpsz="";
				if (preVal_type == "D4") {
					flexCntrTpsz="D5";
				} else if(preVal_type == "D5"){
					flexCntrTpsz="D4";
				}
				nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", flexCntrTpsz);
			}
		  	if (nSRow > -1) 
		  	{
		  		var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
		  		var n_currTroqty_ch=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_ch"));
		  		var n_currTroqty_mh=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_mh"));
				var n_currTroqty=null;
				if (preVal_hlg == "" && preVal_hlg != nxtVal_hlg) {
					if (nxtVal_hlg == "C"){
						preVal_hlg="M";
					} else
						preVal_hlg="C";
				}
				if (preVal_hlg == "C") {
					n_currTroqty=n_currTroqty_ch;
					tro_qty_colid="tro_qty_ch";
				} else if (preVal_hlg == "M") {
					n_currTroqty=n_currTroqty_mh; 
					tro_qty_colid="tro_qty_mh";
				}  
				var n_t_chgTroqty=null; 
				if (bTotSumChange_flg) {
					n_t_chgTroqty=(n_currTroqty_ch + n_currTroqty_mh) - parseInt(preTroQty);
				} else {
					n_t_chgTroqty=(n_currTroqty_ch + n_currTroqty_mh);
				}
				//Value Change
				sheetObj_qty.SetCellValue(nSRow, tro_qty_colid,n_currTroqty - parseInt(preTroQty),0);
		  		//Color Change
			  	if (n_totQty > n_t_chgTroqty) {
			  		sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_ch","#FF0000");
			  		sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_mh","#FF0000");
				} else if (n_totQty == n_t_chgTroqty) {
					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_ch","#000000");
					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_mh","#000000");
				}
		  	} 	  	
		  	//3) currVal -> oldVal 
			formObj.cntr_tpsz_cd_old.value=nxtVal_type;  
			formObj.hlg_tp_cd_old.value=nxtVal_hlg; 
        } else {
			ComShowCodeMessage("BKG00297"); 
			formObj.cntr_tpsz_cd.value=preVal_type;  
			formObj.cntr_tpsz_cd.focus();
		}
		sheetObj_qty.ReDraw=true; 
		return true;
	}
    /**     
    * [tro_dtl]Change sumqty Change : Option(P/M)
    */	
    function plusMinusSumTroQty(nxtVal_type, nxtVal_hlg, nxtTroQty, PM_gubun) {
	  	var formObj=document.form;
  	  	var sheetObj_qty=x_sheetObject5; 
  	  	var flexHgtFlg = formObj.flex_hgt_flg.value;
	  	if (preVal_type != nxtVal_type) {
	  		bTotSumChange_flg=true;
	  	}
	  	sheetObj_qty.ReDraw=false; 
	  	if ("P" == PM_gubun) {
			var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", nxtVal_type);
			if(flexHgtFlg == "Y" && (nSRow == -1 || nSRow == undefined)) {
				var flexCntrTpsz="";
				if (nxtVal_type == "D4") {
					flexCntrTpsz="D5";
					bTotSumChange_flg=false;
				} else if(nxtVal_type == "D5"){
					flexCntrTpsz="D4";
					bTotSumChange_flg=false;
				}
				nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", flexCntrTpsz);
			}
		  	if (nSRow > -1) 
		  	{
		  		var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
		  		var n_currTroqty_ch=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_ch"));
		  		var n_currTroqty_mh=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_mh"));
		    	var tro_qty_colid=null;
				var n_currTroqty=null; 				
				if (nxtVal_hlg == "C") {
					n_currTroqty=n_currTroqty_ch;
					tro_qty_colid="tro_qty_ch";
				} else if (nxtVal_hlg == "M") {
					n_currTroqty=n_currTroqty_mh; 
					tro_qty_colid="tro_qty_mh";
				}
				var n_t_chgTroqty=null; 
				if (bTotSumChange_flg) {
					n_t_chgTroqty=(n_currTroqty_ch + n_currTroqty_mh) + parseInt(nxtTroQty); 
				} else {
					n_t_chgTroqty=(n_currTroqty_ch + n_currTroqty_mh);
				}
				if (n_totQty > n_t_chgTroqty) {
					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_ch","#FF0000");
 					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_mh","#FF0000");
				} else if (n_totQty == n_t_chgTroqty) {
 					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_ch","#000000");
 					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_mh","#000000");
				} else {
					callShowMessageBiggerQty("TP/SZ:"+sheetObj_qty.GetCellValue(nSRow, "cntr_tpsz_cd"));
					var preVal_type=formObj.cntr_tpsz_cd_old.value; 
					var preVal_hlg=formObj.hlg_tp_cd_old.value; 
					formObj.cntr_tpsz_cd.value=preVal_type;  
					hlg_tp_cd.SetSelectCode(preVal_hlg,false);
					if (preVal_hlg != nxtVal_hlg) {
						formObj.hlg_tp_cd_text.focus();
					} else {
						formObj.cntr_tpsz_cd.focus();
					}
					sheetObj_qty.ReDraw=true; 
					return;
				}
				//<-------------------
				//Value Change
				sheetObj_qty.SetCellValue(nSRow, tro_qty_colid,n_currTroqty + parseInt(nxtTroQty),0);
		  	}
	    } else if ("M" == PM_gubun) {
		  	var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", nxtVal_type);
			if(flexHgtFlg == "Y" && (nSRow == -1 || nSRow == undefined)) {
				var flexCntrTpsz="";
				if (nxtVal_type == "D4") {
					flexCntrTpsz="D5";
					bTotSumChange_flg=false;
				} else if(nxtVal_type == "D5"){
					flexCntrTpsz="D4";
					bTotSumChange_flg=false;
				}
				nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", flexCntrTpsz);
			}
		  	if (nSRow > -1) 
		  	{
		  		var n_totQty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
		  		var n_currTroqty_ch=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_ch"));
		  		var n_currTroqty_mh=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_mh"));
		    	var tro_qty_colid=null;
				var n_currTroqty=null; 
				if (nxtVal_hlg == "C") {
					n_currTroqty=n_currTroqty_ch;
					tro_qty_colid="tro_qty_ch";
				} else if (nxtVal_hlg == "M") {
					n_currTroqty=n_currTroqty_mh; 
					tro_qty_colid="tro_qty_mh";
				}
				var n_t_chgTroqty=null; 
				if (bTotSumChange_flg) {
					n_t_chgTroqty=(n_currTroqty_ch + n_currTroqty_mh) - parseInt(nxtTroQty);
				} else {
					n_t_chgTroqty=(n_currTroqty_ch + n_currTroqty_mh);
				}
				//Value Change
				sheetObj_qty.SetCellValue(nSRow, tro_qty_colid,n_currTroqty - parseInt(nxtTroQty),0);
				//Value Change
			  	if (n_totQty > n_t_chgTroqty) {
  					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_ch","#FF0000");
 					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_mh","#FF0000");
				} else if (n_totQty == n_t_chgTroqty) {
 					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_ch","#000000");
 					sheetObj_qty.SetCellFontColor(nSRow, "tro_qty_mh","#000000");
				}
	      	} 
	  	} 
	  	sheetObj_qty.ReDraw=true; 
	}
	/**
	  troqty Number Check
	 */  
	function checkCopySumTroqty(sheetObj) {
	    var formObj=document.form;
	    var sheetObj_qty=x_sheetObject5;
	    var flexHgtFlg = formObj.flex_hgt_flg.value;
	    if (sheetObj.id == "t2csheet2")  
	    {
			var nCopyCnt=formObj.tro_copy_cnt.value;	
		    if (nCopyCnt == "") {
		    	nCopyCnt=1;  
		    }
			var cntr_tpsz_cd_copy=formObj.cntr_tpsz_cd.value; 
			var nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", cntr_tpsz_cd_copy);
			if(flexHgtFlg == "Y" && (nSRow == -1 || nSRow.length == undefined)) {
				var flexCntrTpsz="";
				if (cntr_tpsz_cd_copy == "D4") {
					flexCntrTpsz="D5";
					bTotSumChange_flg=false;
				} else if(cntr_tpsz_cd_copy == "D5"){
					flexCntrTpsz="D4";
					bTotSumChange_flg=false;
				}
				nSRow=sheetObj_qty.FindText("cntr_tpsz_cd", flexCntrTpsz);
			}
		  	if (nSRow > -1) {
		  		var totqty=parseInt(sheetObj_qty.GetCellValue(nSRow, "total_qty"));
		  		var n_currTroqty_CH=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_ch"));
		  		var n_currTroqty_MH=parseInt(sheetObj_qty.GetCellValue(nSRow, "tro_qty_mh"));
	   	    	var n_currTroqty=n_currTroqty_CH + n_currTroqty_MH;
		  	    //var changeTroqty    = n_currTroqty + 1;
	   	    	var changeTroqty=n_currTroqty + parseInt(nCopyCnt);
		  	    if (totqty < changeTroqty) {
		  	    	callShowMessageBiggerQty("TP/SZ:"+sheetObj_qty.GetCellValue(nSRow, "cntr_tpsz_cd"));
		  	        return false;  
		  	    }
		  	}
	    } 
	    return true;
	}  
	/**
	 * troqty Total Number Check
	 */  
	function checkAddSumTroqty() {
	    var formObj=document.form;
	    var sheetObj_qty=x_sheetObject5;
	    var bResult=false;  
	    for(var i=1; i<=sheetObj_qty.RowCount(); i++)
	    {
	    	var n_totQty=parseInt(sheetObj_qty.GetCellValue(i, "total_qty"));
	    	var n_currTroqty_CH=parseInt(sheetObj_qty.GetCellValue(i, "tro_qty_ch"));
	    	var n_currTroqty_MH=parseInt(sheetObj_qty.GetCellValue(i, "tro_qty_mh"));
   	    	var n_currTroqty=n_currTroqty_CH + n_currTroqty_MH;
   	    	if (n_totQty > n_currTroqty) {
   	    		bResult=true;
   	    		break;
   	    	}
	    }
	    return bResult;
	}
	/**
	 * get TP/SZ default Value   
	 */  
	function getDefaultVal_tpsz() {
		var formObj=document.form;
		var sheetObj_qty=x_sheetObject5;		
		var strTpsz="";
		if (sheetObj_qty.RowCount()== 1) {
			strTpsz=sheetObj_qty.GetCellValue(1, "cntr_tpsz_cd");
		}
		return strTpsz;
	}
    //######################[3. Data Display/Store (Master/Detail)]###############################
    /** 
     * Dis-Active Item : sheet data clear master
     */
    function clearHaulageData_master(sheetObj, nRow, haulage) {
    	var formObj=document.form;
    	with(formObj) {    		
    		sheetObj.SetCellValue(nRow, "tro_cmdt_cd",cmdt_cd.value,0);//Booking : cmdt_cd
    		sheetObj.SetCellValue(nRow, "rep_cmdt_cd",bkg_rep_cmdt_cd.value,0);//Booking : cmdt_cd
    		sheetObj.SetCellValue(nRow, "rep_cmdt_nm",bkg_rep_cmdt_nm.value,0);//Booking : cmdt_nm
    		if (haulage == "C") { 
			    //default val set
    			if (x_sheetObject5.RowCount()== 1 && x_sheetObject5.GetCellValue(1, "total_qty") == 1) {
				    //sheetObj.CellValue2(nRow, "cgo_wgt")       = act_wgt.value;    //Booking : estimagted weight
	        	    var t_cgo_wgt=act_wgt.value;
	        	    t_cgo_wgt=delComma_loc(t_cgo_wgt, 0, 9, 3);
	        	    sheetObj.SetCellValue(nRow, "cgo_wgt",t_cgo_wgt,0);
                }        	    
    			//clear 
        		if (io_bnd_cd.value == "I") {
        			sheetObj.SetCellValue(nRow, "cntr_pkup_yd_cd",pickup_cy.value,0);//Booking : pickup_cy
        			sheetObj.SetCellValue(nRow, "cntr_pkup_dt",pkup_dt.value,0);//Booking : pickup_dt
        			sheetObj.SetCellValue(nRow, "cntr_pkup_dt_hhmi",pkup_dt_hhmi.value,0);//Booking : pickup_hhmi
        			sheetObj.SetCellValue(nRow, "cntr_pkup_yd_cd",pickup_cy.value,0);//Booking : pickup_cy
        			sheetObj.SetCellValue(nRow, "cntr_rtn_yd_cd","",0);//Booking : return_yd
        			sheetObj.SetCellValue(nRow, "cntr_rtn_dt","",0);//Booking : return_dt
        			sheetObj.SetCellValue(nRow, "cntr_rtn_dt_hhmi","",0);//Booking : return_hhmi
        		} else {
        			sheetObj.SetCellValue(nRow, "cntr_pkup_yd_cd","",0);//Booking : pkup_yd
        			sheetObj.SetCellValue(nRow, "cntr_pkup_dt","",0);//Booking : pickup_dt
        			sheetObj.SetCellValue(nRow, "cntr_pkup_dt_hhmi","",0);//Booking : pickup_hhmi
        			sheetObj.SetCellValue(nRow, "cntr_rtn_yd_cd",return_cy.value,0);//Booking : return_yd
        			sheetObj.SetCellValue(nRow, "cntr_rtn_dt",rtn_dt.value,0);//Booking : return_dt
        			sheetObj.SetCellValue(nRow, "cntr_rtn_dt_hhmi",rtn_dt_hhmi.value,0);//Booking : return_hhmi
        		}
    		} else if (haulage == "M") { 
    		    //default val set
    			sheetObj.SetCellValue(nRow, "cntr_pkup_yd_cd",pickup_cy.value,0);//Booking : pickup_cy
    			sheetObj.SetCellValue(nRow, "cntr_pkup_dt",pkup_dt.value,0);//Booking : pickup_dt
    			sheetObj.SetCellValue(nRow, "cntr_pkup_dt_hhmi",pkup_dt_hhmi.value,0);//Booking : pickup_hhmi
    			sheetObj.SetCellValue(nRow, "cntr_rtn_yd_cd",return_cy.value,0);//Booking : return_yd
    			sheetObj.SetCellValue(nRow, "cntr_rtn_dt",rtn_dt.value,0);//Booking : return_dt
    			sheetObj.SetCellValue(nRow, "cntr_rtn_dt_hhmi",rtn_dt_hhmi.value,0);//Booking : return_hhmi
    			//clear 
    		    sheetObj.SetCellValue(nRow, "cgo_wgt","",0);
    		}
    	}
    }
    /** 
     * Dis-Active Item : form data clear master
     */
    function clearFormData_master(haulage) {
    	var formObj=document.form;
    	with(formObj) {
			tro_cmdt_cd.value=cmdt_cd.value;            //Booking : cmdt_cd
			rep_cmdt_cd.value=bkg_rep_cmdt_cd.value;    //Booking : cmdt_cd
			rep_cmdt_nm.value=bkg_rep_cmdt_nm.value;    //Booking : cmdt_nm  	
    		if (haulage == "C") { 
    			//default val set
    			//cgo_wgt.value           = t_cgo_wgt;    //Booking : estimagted weight
        	    var t_cgo_wgt=act_wgt.value;
        	    t_cgo_wgt=changeComma_loc(t_cgo_wgt, 0, 9, 3);
        	    cgo_wgt.value=t_cgo_wgt;
    			//clear 
        		if (io_bnd_cd.value == "I") {
        			cntr_pkup_yd_cd.value=pickup_cy.value;     //Booking : pickup_cy
        			cntr_pkup_dt.value=pkup_dt.value;       //Booking : pickup_dt
        			cntr_pkup_dt_hhmi.value=pkup_dt_hhmi.value;  //Booking : pickup_hhmi
        			cntr_rtn_yd_cd.value="";                  //Booking : return_yd	
        			cntr_rtn_dt.value="";                  //Booking : return_dt
        			cntr_rtn_dt_hhmi.value="";                  //Booking : return_hhmi
        		} else {
        			cntr_pkup_yd_cd.value="";                  //Booking : pkup_yd
        			cntr_pkup_dt.value="";                  //Booking : pickup_dt
        			cntr_pkup_dt_hhmi.value="";                  //Booking : pickup_hhmi
        			cntr_rtn_yd_cd.value=return_cy.value;     //Booking : return_yd	        
        			cntr_rtn_dt.value=rtn_dt.value;        //Booking : return_dt
        			cntr_rtn_dt_hhmi.value=rtn_dt_hhmi.value;   //Booking : return_hhmi
        		}
    		} else if (haulage == "M") { 
    			//default val set
    			cntr_pkup_yd_cd.value=pickup_cy.value;     //Booking : pickup_cy
    			cntr_pkup_dt.value=pkup_dt.value;       //Booking : pickup_dt
    			cntr_pkup_dt_hhmi.value=pkup_dt_hhmi.value;  //Booking : pickup_hhmi
    			cntr_rtn_yd_cd.value=return_cy.value;     //Booking : return_yd
    			cntr_rtn_dt.value=rtn_dt.value;        //Booking : return_dt
    			cntr_rtn_dt_hhmi.value=rtn_dt_hhmi.value;   //Booking : return_hhmi
    			//clear 
    			cgo_wgt.value="";
    		}
    	}
    }
    /** 
    * Dis-Active Item : sheet data clear master
    */
    function clearHaulageData_dtl(sheetObj, nRow, haulage) {
	   	var formObj=document.form;
	   	with(formObj) {
	   		if (io_bnd_cd.value == "O") {
	   			if (fd_grd_flg.value == "Y" && spcl_hide_flg.value == "Y") {
	   				if (spcl_instr_rmk.value == "") {
	   					spcl_instr_rmk.value="Food Grade, Hide ";
	   				}
	   			} 
	   			else if (fd_grd_flg.value == "Y") {
	   				if (spcl_instr_rmk.value == "") {
	   					spcl_instr_rmk.value="Food Grade ";
	   				}
	   			}
	   			else if (spcl_hide_flg.value == "Y") {
	   				if (spcl_instr_rmk.value == "") {
	   					spcl_instr_rmk.value="Hide ";
	   				}
	   			}
	   		}
	   		if (haulage == "C") { 
			    //default val set
			    sheetObj.SetCellValue(nRow, "dor_addr_tp_cd","D",0);//default : Door
			    if (term.value == "D") {
			    	if (io_bnd_cd.value == "O") {
			    		sheetObj.SetCellValue(nRow, "dor_loc_cd",por_cd.value.substr(0, 5),0);
			    	} else if (io_bnd_cd.value == "I") {
			    		sheetObj.SetCellValue(nRow, "dor_loc_cd",del_cd.value.substr(0, 5),0);
			    	}
			    }
			    if (sheetObj.GetCellValue(nRow, "zn_cd").trim() == "") {
			    	sheetObj.SetCellValue(nRow, "zn_cd", rep_zn_cd.value.substr(5, 7),0);
//			    	sheetObj.SetCellValue(nRow, "zn_cd","01",0);
			    }
	   		} else if (haulage == "M") { 
	   			//clear 
	   		    sheetObj.SetCellValue(nRow, "dor_loc_cd","",0);
	   			sheetObj.SetCellValue(nRow, "zn_cd","",0);
	   		}
	   	}
    }
   /** 
    * Dis-Active Item : form data clear master
    */
    function clearFormData_dtl(haulage) {
	   	var formObj=document.form;
	   	with(formObj) {
	   		if (io_bnd_cd.value == "O") {
	   			if (fd_grd_flg.value == "Y" && spcl_hide_flg.value == "Y") {
		    		if (spcl_instr_rmk.value == "") {
		    	    	spcl_instr_rmk.value="Food Grade, Hide ";
		    		}
		    	} 
		    	else if (fd_grd_flg.value == "Y") {
		    		if (spcl_instr_rmk.value == "") {
		    	    	spcl_instr_rmk.value="Food Grade ";
		    		}
		    	}
		    	else if (spcl_hide_flg.value == "Y") {
		    		if (spcl_instr_rmk.value == "") {
		    	    	spcl_instr_rmk.value="Hide ";
		    		}
		    	}
	   		}
	   		if (haulage == "C") { 
		        //default val set		        
			    if (term.value == "D") {			    	
			    	if (io_bnd_cd.value == "O") {
				    	dor_loc_cd.value=por_cd.value.substr(0, 5);
			    	} else if (io_bnd_cd.value == "I") {
				    	dor_loc_cd.value=del_cd.value.substr(0, 5);
			    	}
			    }
		        if (zn_cd.value.trim() == "") {
//		        	zn_cd.value="01";
		        	zn_cd.value=rep_zn_cd.value.substr(5,7);
		        }
			    
	   		} else if (haulage == "M") { 
	   			//clear 
	   			dor_loc_cd.value="";
	   			zn_cd.value="";
	   		}
	   	}
    }
    /** 
     * Tro-Master (Sheet -> Form : Display)
     */ 
    function setDataToForm_TroMst(tro_seq) {
        var formObj=document.form;
        var sheetObj=x_sheetObject2; 
        var nRow=sheetObj.FindText("tro_seq", tro_seq);
        with(formObj) {
//        	tro_seq.SetSelectText(sheetObj.GetCellValue(nRow, "tro_seq"),false);
        	comboObjects[0].SetSelectText(sheetObj.GetCellValue(nRow, "tro_seq"),false);
            if (x_oldTroSeq == "") { 
//                x_oldTroSeq=tro_seq.GetSelectText();
                x_oldTroSeq=comboObjects[0].GetSelectText();
            }            
    	    ComSetObjValue(tro_seq_maxcnt,sheetObj.RowCount());
    	    var t_new_row_flg=(nullToBlank2(sheetObj.GetCellValue(nRow, "ibflag")) == "I") ? "Y" : "N";
    	    ComSetObjValue(new_row_flg,       t_new_row_flg);
    	    ComSetObjValue(rqst_sub_seq,      nullToBlank2(sheetObj.GetCellValue(nRow, "rqst_sub_seq")));
    	    ComSetObjValue(cntr_no,           nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_no")));
    	    ComSetObjValue(cntr_tpsz_cd,      nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_tpsz_cd")));
//    	    hlg_tp_cd.SetSelectCode(nullToBlank2(sheetObj.GetCellValue(nRow, "hlg_tp_cd")),false);
    	    comboObjects[4].SetSelectCode(nullToBlank2(sheetObj.GetCellValue(nRow, "hlg_tp_cd")),false);
    	    var t_cgo_wgt=nullToBlank2(sheetObj.GetCellValue(nRow, "cgo_wgt"));
    	    t_cgo_wgt=changeComma_loc(t_cgo_wgt, 0, 9, 3);
    	    ComSetObjValue(cgo_wgt,           t_cgo_wgt);
    	    ComSetObjValue(cgo_wgt_tp,        wgt_ut_cd.value);  //Booking : estimagted weight tp
    	    ComSetObjValue(cntr_pkup_yd_cd,   nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_pkup_yd_cd")));
    	    ComSetObjValue(cntr_rtn_yd_cd,    nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_rtn_yd_cd")));
    	    ComSetObjValue(cntr_rtn_dt,       nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_rtn_dt")));
    	    ComSetObjValue(cntr_rtn_dt_hhmi,  nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_rtn_dt_hhmi")));
    	    ComSetObjValue(tro_cmdt_cd,       nullToBlank2(sheetObj.GetCellValue(nRow, "tro_cmdt_cd")));
    	    ComSetObjValue(rep_cmdt_cd,       nullToBlank2(sheetObj.GetCellValue(nRow, "rep_cmdt_cd")));
    	    ComSetObjValue(rep_cmdt_nm,       nullToBlank2(sheetObj.GetCellValue(nRow, "rep_cmdt_nm")));
//    	    bkg_trsp_mzd_cd.SetSelectCode(nullToBlank2(sheetObj.GetCellValue(nRow, "bkg_trsp_mzd_cd")));
    	    comboObjects[5].SetSelectCode(nullToBlank2(sheetObj.GetCellValue(nRow, "bkg_trsp_mzd_cd")));
    	    ComSetObjValue(cntr_pkup_dt,      nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_pkup_dt")));
    	    ComSetObjValue(cntr_pkup_dt_hhmi, nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_pkup_dt_hhmi")));
    	    ComSetObjValue(spcl_instr_rmk,    nullToBlank2(sheetObj.GetCellValue(nRow, "spcl_instr_rmk")));
    	    var t_cfm_flg_nm=(nullToBlank2(sheetObj.GetCellValue(nRow, "cfm_flg")) == "Y") ? "Yes" : "No";
    	    if (sheetObj.GetCellValue(nRow, "split_rmk") != "") t_cfm_flg_nm="Moved to " + sheetObj.GetCellValue(nRow, "split_rmk");
    	    ComSetObjValue(cfm_flg,           t_cfm_flg_nm);
    	    ComSetObjValue(cfm_dt,            nullToBlank2(sheetObj.GetCellValue(nRow, "cfm_dt")));
    	    ComSetObjValue(cfm_ofc_cd,        nullToBlank2(sheetObj.GetCellValue(nRow, "cfm_ofc_cd")));
    	    ComSetObjValue(cfm_usr_id,        nullToBlank2(sheetObj.GetCellValue(nRow, "cfm_usr_id")));
    	    ComSetObjValue(cfm_usr_nm,        nullToBlank2(sheetObj.GetCellValue(nRow, "cfm_usr_nm")));
    	    ComSetObjValue(so_no,             nullToBlank2(sheetObj.GetCellValue(nRow, "so_no")));
    	    ComSetObjValue(so_dt,             nullToBlank2(sheetObj.GetCellValue(nRow, "so_dt")));
    	    ComSetObjValue(so_ofc_cd,         nullToBlank2(sheetObj.GetCellValue(nRow, "so_ofc_cd")));
    	    ComSetObjValue(so_usr_id,         nullToBlank2(sheetObj.GetCellValue(nRow, "so_usr_id")));
    	    ComSetObjValue(so_usr_nm,         nullToBlank2(sheetObj.GetCellValue(nRow, "so_usr_nm")));
    	    ComSetObjValue(cntr_prt_flg,      nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_prt_flg")));
    	    if (cntr_prt_flg.value == "Y") {
//    		    document.getElementById("btn_t2cMulti").style.color="#0000ff";
    	    	document.getElementById("btn_t2cMulti").style.setProperty("color", BTN_BLUE, "important");
    	    } else { 
    	    	document.getElementById("btn_t2cMulti").style.setProperty("color", "#000000", "important");
    	    }
    	    ComSetObjValue(t1_doc_flg,        nullToBlank2(sheetObj.GetCellValue(nRow, "t1_doc_flg")));
    	    ComSetObjValue(cstms_clr_no,      nullToBlank2(sheetObj.GetCellValue(nRow, "cstms_clr_no")));
    	    ComSetObjValue(all_in_rt_cd,      nullToBlank2(sheetObj.GetCellValue(nRow, "all_in_rt_cd")));
    	    ComSetObjValue(curr_cd,           nullToBlank2(sheetObj.GetCellValue(nRow, "curr_cd")));
    	    //ComSetObjValue(trns_rev_amt,      nullToBlank2(sheetObj.CellValue(nRow, "trns_rev_amt")));
    	    var t_trns_rev_amt=nullToBlank2(sheetObj.GetCellValue(nRow, "trns_rev_amt"));
    	    t_trns_rev_amt=changeComma_loc(t_trns_rev_amt, 0, 9, 2);
    	    ComSetObjValue(trns_rev_amt,      t_trns_rev_amt);
    	    var t_non_trns_rev_amt=nullToBlank2(sheetObj.GetCellValue(nRow, "non_trns_rev_amt"));
    	    t_non_trns_rev_amt=changeComma_loc(t_non_trns_rev_amt, 0, 9, 2);
    	    ComSetObjValue(non_trns_rev_amt,      t_non_trns_rev_amt);
    	    var t_add_rev_amt=nullToBlank2(sheetObj.GetCellValue(nRow, "add_rev_amt"));
    	    t_add_rev_amt=changeComma_loc(t_add_rev_amt, 0, 9, 2);
    	    ComSetObjValue(add_rev_amt,      t_add_rev_amt);
    	    ComSetObjValue(add_rev_chg_cd,    nullToBlank2(sheetObj.GetCellValue(nRow, "add_rev_chg_cd")));
    	    ComSetObjValue(vat_flg,           nullToBlank2(sheetObj.GetCellValue(nRow, "vat_flg")));
            //if (t1_doc_flg.value == "Y") { 
            var strMandatoryFlg="N";
            var t_all_in_rt_cd=nullToBlank2(sheetObj.GetCellValue(nRow, "all_in_rt_cd"));
            var t_trns_rev_amt=nullToBlank2(sheetObj.GetCellValue(nRow, "trns_rev_amt"));
            var t_non_trns_rev_amt=nullToBlank2(sheetObj.GetCellValue(nRow, "non_trns_rev_amt"));
            var t_add_rev_amt=nullToBlank2(sheetObj.GetCellValue(nRow, "add_rev_amt"));
            if (t_all_in_rt_cd == "Y" || (t_all_in_rt_cd != "Y" && t_non_trns_rev_amt != "")) { 
            	strMandatoryFlg="Y";
            }
            if (strMandatoryFlg == "Y") { 
//    		    document.getElementById("btn_t2cT1Revenue").style.color="#0000ff";
            	document.getElementById("btn_t2cT1Revenue").style.setProperty("color", BTN_BLUE, "important");
    	    } else {
    	    	document.getElementById("btn_t2cT1Revenue").style.setProperty("color", "#000000", "important");
    	    } 
            ComSetObjValue(cxl_flg,           nullToBlank2(sheetObj.GetCellValue(nRow, "cxl_flg")));
            ComSetObjValue(cntr_tpsz_cd_old,  nullToBlank2(sheetObj.GetCellValue(nRow, "cntr_tpsz_cd_old")));
            ComSetObjValue(hlg_tp_cd_old,     nullToBlank2(sheetObj.GetCellValue(nRow, "hlg_tp_cd_old")));
            ComSetObjValue(eur_trns_tp_cd,    nullToBlank2(sheetObj.GetCellValue(nRow, "eur_trns_tp_cd")));
//            rc_seq.SetSelectText(nullToBlank2(sheetObj.GetCellValue(nRow, "rc_seq")),false);
            comboObjects[2].SetSelectText(nullToBlank2(sheetObj.GetCellValue(nRow, "rc_seq")),false);
//            ComSetObjValue(awk_cgo_seq,       nullToBlank2(sheetObj.GetCellValue(nRow, "awk_cgo_seq")));
            comboObjects[3].SetSelectText(nullToBlank2(sheetObj.GetCellValue(nRow, "awk_cgo_seq")),false);
            
            setDataToForm_Tro_dg_seq(sheetObj.GetCellValue(nRow, "tro_seq"));
    	    ComSetObjValue(comm_ofc_cd,   nullToBlank2(sheetObj.GetCellValue(nRow, "comm_ofc_cd")));
        }
        changeMasterColor();         
    }  
    /** 
     * Tro-Master Temp Save (Form ->Sheet  : Store)
     */
    function setFormToData_TroMst(prev_tro_seq) {
    	var formObj=document.form; 
        var sheetObj=x_sheetObject2; 
        var nRow=sheetObj.FindText("tro_seq", prev_tro_seq);
//        sheetObj.RenderSheet(0);//----------------->
        
        sheetObj.SetCellValue(nRow, "hlg_tp_cd",hlg_tp_cd.GetSelectCode(),0);
        sheetObj.SetCellValue(nRow, "bkg_trsp_mzd_cd",bkg_trsp_mzd_cd.GetSelectCode(),0);
        sheetObj.SetCellValue(nRow, "rc_seq",rc_seq.GetSelectText(),0);
        with(formObj) {
        	sheetObj.SetCellValue(nRow, "tro_seq",prev_tro_seq,0);
        	sheetObj.SetCellValue(nRow, "rqst_sub_seq",ComGetObjValue(rqst_sub_seq),0);
        	sheetObj.SetCellValue(nRow, "cntr_no",ComGetObjValue(cntr_no),0);
        	sheetObj.SetCellValue(nRow, "cntr_tpsz_cd",ComGetObjValue(cntr_tpsz_cd),0);
        	
    	    //var t_cgo_wgt = nullToBlank2(ComGetObjValue(cgo_wgt));
        	var t_cgo_wgt=ComGetObjValue(cgo_wgt);
    	    t_cgo_wgt=delComma_loc(t_cgo_wgt);
    	    sheetObj.SetCellValue(nRow, "cgo_wgt",t_cgo_wgt,0);
        	sheetObj.SetCellValue(nRow, "cntr_pkup_yd_cd",ComGetObjValue(cntr_pkup_yd_cd),0);
        	sheetObj.SetCellValue(nRow, "cntr_rtn_yd_cd",ComGetObjValue(cntr_rtn_yd_cd),0);
        	sheetObj.SetCellValue(nRow, "cntr_rtn_dt",ComGetObjValue(cntr_rtn_dt),0);
        	sheetObj.SetCellValue(nRow, "cntr_rtn_dt_hhmi",ComGetObjValue(cntr_rtn_dt_hhmi),0);
        	sheetObj.SetCellValue(nRow, "tro_cmdt_cd",ComGetObjValue(tro_cmdt_cd),0);
        	sheetObj.SetCellValue(nRow, "rep_cmdt_nm",ComGetObjValue(rep_cmdt_nm),0);
        	sheetObj.SetCellValue(nRow, "rep_cmdt_cd",ComGetObjValue(rep_cmdt_cd),0);
        	
        	sheetObj.SetCellValue(nRow, "cntr_pkup_dt",ComGetObjValue(cntr_pkup_dt),0);
        	sheetObj.SetCellValue(nRow, "cntr_pkup_dt_hhmi",ComGetObjValue(cntr_pkup_dt_hhmi),0);
        	sheetObj.SetCellValue(nRow, "spcl_instr_rmk",ComGetObjValue(spcl_instr_rmk),0);
        	sheetObj.SetCellValue(nRow, "cfm_flg",(ComGetObjValue(cfm_flg) == "Yes") ? "Y" : "N",0);
        	sheetObj.SetCellValue(nRow, "cfm_dt",ComGetObjValue(cfm_dt),0);
        	sheetObj.SetCellValue(nRow, "cfm_ofc_cd",ComGetObjValue(cfm_ofc_cd),0);
        	sheetObj.SetCellValue(nRow, "cfm_usr_id",ComGetObjValue(cfm_usr_id),0);
        	sheetObj.SetCellValue(nRow, "cfm_usr_nm",ComGetObjValue(cfm_usr_nm),0);
        	sheetObj.SetCellValue(nRow, "so_no",ComGetObjValue(so_no),0);
        	sheetObj.SetCellValue(nRow, "so_dt",ComGetObjValue(so_dt),0);
        	sheetObj.SetCellValue(nRow, "so_ofc_cd",ComGetObjValue(so_ofc_cd),0);
        	sheetObj.SetCellValue(nRow, "so_usr_id",ComGetObjValue(so_usr_id),0);
        	sheetObj.SetCellValue(nRow, "so_usr_nm",ComGetObjValue(so_usr_nm),0);
        	sheetObj.SetCellValue(nRow, "cntr_prt_flg",ComGetObjValue(cntr_prt_flg),0);
        	sheetObj.SetCellValue(nRow, "t1_doc_flg",ComGetObjValue(t1_doc_flg),0);
        	sheetObj.SetCellValue(nRow, "cstms_clr_no",ComGetObjValue(cstms_clr_no),0);
        	sheetObj.SetCellValue(nRow, "all_in_rt_cd",ComGetObjValue(all_in_rt_cd),0);
        	sheetObj.SetCellValue(nRow, "curr_cd",ComGetObjValue(curr_cd),0);
    	    //sheetObj.CellValue2(nRow, "trns_rev_amt")      = ComGetObjValue(trns_rev_amt);        
        	var t_trns_rev_amt=ComGetObjValue(trns_rev_amt);
        	t_trns_rev_amt=delComma_loc(t_trns_rev_amt);
    	    sheetObj.SetCellValue(nRow, "trns_rev_amt",t_trns_rev_amt,0);
    	    var t_non_trns_rev_amt=ComGetObjValue(non_trns_rev_amt);
    	    t_non_trns_rev_amt=delComma_loc(t_non_trns_rev_amt);
    	    sheetObj.SetCellValue(nRow, "non_trns_rev_amt",t_non_trns_rev_amt,0);
    	    var t_add_rev_amt=ComGetObjValue(add_rev_amt);
    	    t_add_rev_amt=delComma_loc(t_add_rev_amt);
    	    sheetObj.SetCellValue(nRow, "add_rev_amt",t_add_rev_amt,0);
    	    sheetObj.SetCellValue(nRow, "add_rev_chg_cd",ComGetObjValue(add_rev_chg_cd),0);
    	    sheetObj.SetCellValue(nRow, "vat_flg",ComGetObjValue(vat_flg),0);
        	sheetObj.SetCellValue(nRow, "cxl_flg",ComGetObjValue(cxl_flg),0);
        	sheetObj.SetCellValue(nRow, "cntr_tpsz_cd_old",ComGetObjValue(cntr_tpsz_cd_old),0);
        	sheetObj.SetCellValue(nRow, "hlg_tp_cd_old",ComGetObjValue(hlg_tp_cd_old),0);
        	
        	sheetObj.SetCellValue(nRow, "awk_cgo_seq",ComGetObjValue(awk_cgo_seq),0);
        	sheetObj.SetCellValue(nRow, "comm_ofc_cd",ComGetObjValue(comm_ofc_cd),0);
            setFormToData_Tro_dg_seq(prev_tro_seq);             
        }  
//        sheetObj.RenderSheet(1);//<------------------
    } 
    /** 
     * Tro-Detail ( HiddenSheet -> Sheet : Display ) 
     */
    //function setAllDataToData_TroDtl(tro_seq, nRow_tro_sub_seq) {
    function setAllDataToData_TroDtl(tro_seq, nRow_tro_sub_seq, ValRow_gubun) {
        var formObj=document.form;
        var sheetObj=x_sheetObject3; 
        if (ValRow_gubun == null) {
       	   ValRow_gubun="R";  //R:row, V:val
        }
        //-----------------------------------
        //var nRow = findRow_dtl(tro_seq, nRow_tro_sub_seq);
        var nRow=findRow_dtl(tro_seq, nRow_tro_sub_seq, ValRow_gubun);
        //-----------------------------------
        with(formObj) {
	        var sRow=sheetObj.FindCheckedRow("chk");
	         if(sRow.length >0 ) {
	        	 sRow = sRow +"|";
	         }
	        var arrRow=sRow.split("|");
	        
	        var n_tro_sub_seq_maxcnt=arrRow.length - 1;
			ComSetObjValue(tro_sub_seq_currcnt, nRow_tro_sub_seq); 	
    	    ComSetObjValue(tro_sub_seq_maxcnt,  n_tro_sub_seq_maxcnt); 
			ComSetObjValue(tro_sub_seq,         nullToBlank2(sheetObj.GetCellValue(nRow, "tro_sub_seq")));
//			dor_addr_tp_cd.SetSelectCode(nullToBlank2(sheetObj.GetCellValue(nRow, "dor_addr_tp_cd")),false);
			ComSetObjValue(dor_loc_cd,          nullToBlank2(sheetObj.GetCellValue(nRow, "dor_loc_cd")));
			ComSetObjValue(zn_cd,               nullToBlank2(sheetObj.GetCellValue(nRow, "zn_cd")));
			ComSetObjValue(lod_ref_no,          nullToBlank2(sheetObj.GetCellValue(nRow, "lod_ref_no")));
			ComSetObjValue(dor_pst_no,          nullToBlank2(sheetObj.GetCellValue(nRow, "dor_pst_no")));
			ComSetObjValue(dor_addr_1,          nullToBlank2(sheetObj.GetCellValue(nRow, "dor_addr_1")));
			ComSetObjValue(dor_addr_2,          nullToBlank2(sheetObj.GetCellValue(nRow, "dor_addr_2")));
			ComSetObjValue(dor_addr_3,          nullToBlank2(sheetObj.GetCellValue(nRow, "dor_addr_3")));
			ComSetObjValue(dor_addr_4,          nullToBlank2(sheetObj.GetCellValue(nRow, "dor_addr_4")));
			ComSetObjValue(arr_dt,              nullToBlank2(sheetObj.GetCellValue(nRow, "arr_dt")));
			ComSetObjValue(arr_dt_hhmi,         nullToBlank2(sheetObj.GetCellValue(nRow, "arr_dt_hhmi")));
			ComSetObjValue(cntc_pson_nm,        nullToBlank2(sheetObj.GetCellValue(nRow, "cntc_pson_nm")));
			ComSetObjValue(cntc_phn_no,         nullToBlank2(sheetObj.GetCellValue(nRow, "cntc_phn_no")));
			ComSetObjValue(cntc_eml,            nullToBlank2(sheetObj.GetCellValue(nRow, "cntc_eml")));
    	    //ComSetObjValue(cxl_flg,             nullToBlank2(sheetObj.CellValue(nRow, "cxl_flg")));       
        }
        dor_addr_tp_cd.SetSelectCode(nullToBlank2(sheetObj.GetCellValue(nRow, "dor_addr_tp_cd")),false);
        //-----------------------------------
        //3) Color
        changeDtlColor();

        
        //4) BKG_TRO, CFM_FLG = 'Y' enable 로직
        var p_cfm_flg = ComGetObjValue(formObj.cfm_flg);
	    if(p_cfm_flg == "Yes"){					
	    	with(formObj) {				
		    	//true 이면 입력 가능하게 처리함.				
		    	ComEnableManyObjects_loc   (true,      lod_ref_no, dor_pst_no,				
		    			dor_addr_1, btns_Address, dor_addr_2, dor_addr_3, 		
						dor_addr_4, arr_dt, btns_calendar_3, arr_dt_hhmi, cntc_pson_nm, cntc_phn_no, cntc_eml,	
						tro_sub_seq_currcnt, tro_sub_seq_maxcnt, spcl_instr_rmk, dor_loc_cd, zn_cd, btns_popLocation);  //Active
//		    	ComEnableManyIBCombo(true, "", dor_addr_tp_cd);	//Active
		    	comboObjects[6].SetEnable(true);
		    }					
	    	
	    	//버튼 이벤트를 changeDtlColor()를 무시하고 처리하기 위함.
	    	ComEnableManyTd(true, "btn_t2cAdd", "btn_t2cDelete");
	    	//Prev, Next 버튼 이벤트
	    	changeEnabled_dtl_PrevNext();	
	    }
        
    }  
     /** 
      * Tro-Detail Temp Save   ( Sheet -> HidenSheet : Store )
      */
     function setDataToAllData_TroDtl(prev_tro_seq, nRow_tro_sub_seq, ValRow_gubun) {
         var formObj=document.form;
         var sheetObj=x_sheetObject3; 
         if (ValRow_gubun == null) {
      	   ValRow_gubun="R";  //R:row, V:val
         }
         //-----------------------------------
         var nRow=findRow_dtl_curr(prev_tro_seq, nRow_tro_sub_seq, ValRow_gubun);
         //-----------------------------------
         with(formObj) {
         	sheetObj.SetCellValue(nRow, "tro_seq",prev_tro_seq,0);
         	sheetObj.SetCellValue(nRow, "tro_sub_seq",ComGetObjValue(tro_sub_seq),0);
         	
         	sheetObj.SetCellValue(nRow, "dor_loc_cd",ComGetObjValue(dor_loc_cd),0);
         	sheetObj.SetCellValue(nRow, "zn_cd",ComGetObjValue(zn_cd),0);
         	sheetObj.SetCellValue(nRow, "lod_ref_no",ComGetObjValue(lod_ref_no),0);
         	sheetObj.SetCellValue(nRow, "dor_pst_no",ComGetObjValue(dor_pst_no),0);
         	sheetObj.SetCellValue(nRow, "dor_addr_1",ComGetObjValue(dor_addr_1),0);
         	sheetObj.SetCellValue(nRow, "dor_addr_2",ComGetObjValue(dor_addr_2),0);
         	sheetObj.SetCellValue(nRow, "dor_addr_3",ComGetObjValue(dor_addr_3),0);
         	sheetObj.SetCellValue(nRow, "dor_addr_4",ComGetObjValue(dor_addr_4),0);
         	sheetObj.SetCellValue(nRow, "arr_dt",ComGetObjValue(arr_dt),0);
         	sheetObj.SetCellValue(nRow, "arr_dt_hhmi",ComGetObjValue(arr_dt_hhmi),0);
         	sheetObj.SetCellValue(nRow, "cntc_pson_nm",ComGetObjValue(cntc_pson_nm),0);
         	sheetObj.SetCellValue(nRow, "cntc_phn_no",ComGetObjValue(cntc_phn_no),0);
         	sheetObj.SetCellValue(nRow, "cntc_eml",ComGetObjValue(cntc_eml),0);
         	//sheetObj.CellValue2(nRow, "cxl_flg")        = ComGetObjValue(cxl_flg);  
         }
         sheetObj.SetCellValue(nRow, "dor_addr_tp_cd",dor_addr_tp_cd.GetSelectCode(),0);
     }
    //######################[4. Data Display/Store (Etc : Header/Combo)]##########################
    /**
    */
    function setEtcDataToForm_bkg(formObj, sheetObj) {
        //------------------------------
        //sheetEtcData -> Form 
        with (formObj) 
        {        
	        por_nod_cd.value=nullToBlank2(sheetObj.GetEtcData("por_nod_cd"));
	        skd_dir_cd.value=nullToBlank2(sheetObj.GetEtcData("skd_dir_cd"));
	        cust_seq.value=nullToBlank2(sheetObj.GetEtcData("cust_seq"));
	        fd_grd_flg.value=nullToBlank2(sheetObj.GetEtcData("fd_grd_flg"));
	        spcl_hide_flg.value=nullToBlank2(sheetObj.GetEtcData("spcl_hide_flg"));
	        pol_code.value=nullToBlank2(sheetObj.GetEtcData("pol_code"));
	        bkg_sts_cd.value=nullToBlank2(sheetObj.GetEtcData("bkg_sts_cd"));
	        cmdt_nm.value=nullToBlank2(sheetObj.GetEtcData("cmdt_nm"));
	        //bl_tp_cd.value        = nullToBlank2(sheetObj.EtcData("bl_tp_cd")); 
	        bkg_no.value=nullToBlank2(sheetObj.GetEtcData("bkg_no"));
	        bl_no.value=nullToBlank2(sheetObj.GetEtcData("bl_no"));
	        cust_cnt_cd.value=nullToBlank2(sheetObj.GetEtcData("cust_cnt_cd"));
	        cust_nm.value=nullToBlank2(sheetObj.GetEtcData("cust_nm"));
	        bkg_rep_cmdt_cd.value=nullToBlank2(sheetObj.GetEtcData("bkg_rep_cmdt_cd"));
	        cmdt_cd.value=nullToBlank2(sheetObj.GetEtcData("cmdt_cd"));
	        wgt_ut_cd.value=nullToBlank2(sheetObj.GetEtcData("wgt_ut_cd"));
	        pickup_cy.value=nullToBlank2(sheetObj.GetEtcData("pickup_cy"));
	        conti_cd.value=nullToBlank2(sheetObj.GetEtcData("conti_cd"));
	        del_cd.value=nullToBlank2(sheetObj.GetEtcData("del_cd"));
	        act_wgt.value=nullToBlank2(sheetObj.GetEtcData("act_wgt"));
	        term.value=nullToBlank2(sheetObj.GetEtcData("term"));
	        por_cd.value=nullToBlank2(sheetObj.GetEtcData("por_cd"));
	        pod_cd.value=nullToBlank2(sheetObj.GetEtcData("pod_cd"));
	        skd_voy_no.value=nullToBlank2(sheetObj.GetEtcData("skd_voy_no"));
	        etb_dt.value=nullToBlank2(sheetObj.GetEtcData("etb_dt"));
	        bkg_rep_cmdt_nm.value=nullToBlank2(sheetObj.GetEtcData("bkg_rep_cmdt_nm"));
	        vsl_cd.value=nullToBlank2(sheetObj.GetEtcData("vsl_cd"));
	        bkg_cgo_tp_cd.value=nullToBlank2(sheetObj.GetEtcData("bkg_cgo_tp_cd"));
	        //rd_cgo_flg.value      = nullToBlank2(sheetObj.EtcData("rd_cgo_flg")); 
	        //bb_cgo_flg.value      = nullToBlank2(sheetObj.EtcData("bb_cgo_flg"));
	        //dor_arr_dt.value      = nullToBlank2(sheetObj.EtcData("dor_arr_dt")); 
	        //dor_arr_dt_hhmi.value = nullToBlank2(sheetObj.EtcData("dor_arr_dt_hhmi")); 	        
	        rtn_dt.value=nullToBlank2(sheetObj.GetEtcData("rtn_dt"));
	        rtn_dt_hhmi.value=nullToBlank2(sheetObj.GetEtcData("rtn_dt_hhmi"));
	        pkup_dt.value=nullToBlank2(sheetObj.GetEtcData("pkup_dt"));
	        pkup_dt_hhmi.value=nullToBlank2(sheetObj.GetEtcData("pkup_dt_hhmi"));
	        flex_hgt_flg.value=nullToBlank2(sheetObj.GetEtcData("flex_hgt_flg"));
	        var boundCd=io_bnd_cd.value;
	        if (boundCd != "") {
	            io_bnd_cd_disp.value=boundCd + "/B"; 
	        }
	        var t_pkupCy=nullToBlank2(sheetObj.GetEtcData("pickup_cy"));
	        pickup_cy.value=t_pkupCy;  	        
	        var t_returnCy=nullToBlank2(sheetObj.GetEtcData("return_cy"));
	        return_cy.value=t_returnCy;
	        if (boundCd == "I") {
	        	document.all.cyHeader.innerHTML="P/UP CY";
			    if (t_pkupCy.length >= 7) {
			    	formObj.cy1.value=t_pkupCy.substr(0, 5);
			    	formObj.cy2.value=t_pkupCy.substr(5, 2);
			    } else {
			    	formObj.cy1.value=t_pkupCy;
			    	formObj.cy2.value="";
			    }
	        } else {
	        	document.all.cyHeader.innerHTML="Return CY";
			    if (t_returnCy.length >= 7) {
			    	formObj.cy1.value=t_returnCy.substr(0, 5);
			    	formObj.cy2.value=t_returnCy.substr(5, 2);
			    } else {
			    	formObj.cy1.value=t_returnCy;
			    	formObj.cy2.value="";
			    }
	        }
	        //------------------------------
	        oldBkgNo.value=nullToBlank2(sheetObj.GetEtcData("bkg_no"));
	        oldBlNo.value=nullToBlank2(sheetObj.GetEtcData("bl_no"));
	        ca_flg.value=nullToBlank2(sheetObj.GetEtcData("ca_flg"));
	        rep_zn_cd.value=nullToBlank2(sheetObj.GetEtcData("rep_zn_cd"));
		    var t_dcgo_flg=nullToBlank2(sheetObj.GetEtcData("dcgo_flg"));
		    var t_rc_flg=nullToBlank2(sheetObj.GetEtcData("rc_flg"));
		    var t_awk_cgo_flg=nullToBlank2(sheetObj.GetEtcData("awk_cgo_flg"));
		    var t_hcdg=nullToBlank2(sheetObj.GetEtcData("hcdg"));
		    dcgo_flg.checked=(t_dcgo_flg    == "Y") ? true : false;
		    rc_flag.checked=(t_rc_flg      == "Y") ? true : false;
		    awk_cgo_flg.checked=(t_awk_cgo_flg == "Y") ? true : false;
		    hcdg.checked=(t_hcdg        == "Y") ? true : false;
		    changeDisplayBtn("btn_Danger",  t_dcgo_flg);
		    changeDisplayBtn("btn_Reefer",  t_rc_flg);
		    changeDisplayBtn("btn_Awkward", t_awk_cgo_flg);
		    //<----------------------------------------------
			if (formObj.oldBkgNo.value != "") {
		        //ComEnableManyTd(true,  "btn_t2cRetrieve");
	   		    ComEnableManyTd(true, "btn_t2cSave", "btn_t2cConfirm", "btn_t2cCancelFrustrate", "btn_t2cTROCopy", "btn_t2cTRONotice", 
                                      "btn_t2cAddCNTR", "btn_t2cCopyCNTR", "btn_t2cDeleteCNTR", 
                                      "btn_t2cAdd", "btn_t2cDelete", 
                                      "btn_t2cPrevious", "btn_t2cNext");     
			}
        }
    }
    /** 
    * Tro-Mastr dgco_seq 
    */
    function setDataToForm_Tro_dg_seq(tro_seq) {
        var formObj=document.form;
        var sheetObj=x_sheetObject4; 
        var comboObj_1=dcgo_seq; 
        var cellId="tro_dcgo_seq";
//        var nRow=0;  //findRow 
//        var nStartRow=0;
        var strCode_1=""; //code Initialization
//        while (nRow > -1) {
//	        nRow=sheetObj.FindText("tro_seq", tro_seq, nStartRow);
//		    if (nRow > -1) {
//			    if (strCode_1 == "") {
//			    	strCode_1 += sheetObj.GetCellValue(nRow, cellId);
//			    } else {
//			    	strCode_1 += "|"+sheetObj.GetCellValue(nRow, cellId);
//			    }
//		    }
//	        nStartRow=nRow+1;
//	    }

        for(i=1;i<sheetObj.RowCount() + 1; i++){
        	if(sheetObj.GetCellValue(i, "tro_seq")== tro_seq){
			    if (strCode_1 == "") {
			    	strCode_1 += sheetObj.GetCellValue(i, cellId);
			    } else {
			    	strCode_1 += "|"+sheetObj.GetCellValue(i, cellId);
			    }
        	}
        }
	
        comboObj_1.SetSelectText("",false); //Clear current check 
        comboObj_1.SetSelectText(strCode_1,false);
    }
    /** 
     * Tro-Mastr dgco_seq Store_pre 
     */
    function setFormToData_Tro_dg_seq(prev_tro_seq) {
        var formObj=document.form;
        var sheetObj=x_sheetObject4; 
        var comboObj_1=dcgo_seq; 
//        var nRow=0;  //findRow 
//        var nStartRow=0;  //find Start Index 
//        while (nRow > -1) 
//	    {
//    	    nRow=sheetObj.FindText("tro_seq", prev_tro_seq, nStartRow);
//    	    if (nRow > -1) 
//		    {    		   
//    		    sheetObj.SetCellValue(nRow, "del_chk",1,0);
//    		    nStartRow=nRow+1;
//    	    }
//        } 
//        var sRow=sheetObj.FindCheckedRow("del_chk")+"|";
//        var arrRow=sRow.split("|");
//        for (var idx=arrRow.length-2; idx>=0; idx--)
//        { 
//    	    sheetObj.RowDelete(arrRow[idx], false);
//        }
        
        //Delete target seq data of x_sheetObject4
        for(i=sheetObj.RowCount();0<i;i--){
        	if(sheetObj.GetCellValue(i, "tro_seq")== prev_tro_seq){
        		sheetObj.RowDelete(i, false);
        	}
        }        
        //3) comboObj.Text를 parsing
        comboCodeToSheet(sheetObj, comboObj_1, prev_tro_seq);
    }
    /** 
    * Tro-Mastr spcl_cgo_seq Store : (multiComboValue) 
    */
    function comboCodeToSheet(sheetObj, comboObj, prev_tro_seq) {
        var strText=comboObj.GetSelectText();
        if (strText != "") {
	        var arrComboSeq=strText.split("|");   
	        for (var i=0; i<arrComboSeq.length; i++) {	
		        var nNewRow=sheetObj.DataInsert(-1);
		    	sheetObj.SetCellValue(nNewRow, "tro_seq",prev_tro_seq,0);
		    	sheetObj.SetCellValue(nNewRow, "tro_dcgo_seq",arrComboSeq[i],0);
	        }
        }
    }
    //######################[5. Etc]##############################################################
    // addRow prev MaxSeq get 
    function getPrevMaxTroSeq(sheetObj, nRow, colId)
	{
	    var prevMaxTroSeq=0;
		if (nRow > 1) {
			prevMaxTroSeq=sheetObj.GetCellValue(nRow-1, colId);
		}
		return prevMaxTroSeq;
	}
    // addRow prev MaxSeq get 
    function getPrevMaxTroSubSeq(sheetObj, tro_seq, colId)
	{
        var formObj=document.form; 
    	//sheetObj.CheckAll2("chk") = 0;  //hidden chk : check clear
    	for (var i=1; i<=sheetObj.RowCount(); i++) {
    		if (sheetObj.GetCellValue(i, "chk") == 1) {
    			sheetObj.SetCellValue(i, "chk",0,0);
    		}
    	} 
        var nRow=0;  //findRow 
        var nStartRow=0;  //find Start Index 
        while (nRow > -1) {
    	    nRow=sheetObj.FindText("tro_seq", tro_seq, nStartRow);
    	    if (nRow > -1) { 
    	    	sheetObj.SetCellValue(nRow, "chk",1,0);//maxcount
    		    nStartRow=nRow+1;
    	    }
        } 
        //max sub_seq : get
        var prevMaxTroSubSeq="0";
        var sRow=sheetObj.FindCheckedRow("chk")+"|";
        if (sRow != "") {
            var arrRow=sRow.split("|");
            for (var idx=0; idx<=arrRow.length-2; idx++)
            { 
            	var currVal=sheetObj.GetCellValue(arrRow[idx], colId);
            	if (parseInt(currVal) > parseInt(prevMaxTroSubSeq)) {
        			prevMaxTroSubSeq=currVal;
        		} 
            }
        }
    	return prevMaxTroSubSeq;
	}
    // dtl : tro_sub_seq_maxcount, nSRow_dtl get
    function findRow_dtl(tro_seq, nRow_tro_sub_seq, ValRow_gubun) {
        var formObj=document.form; 
        var sheetObj=x_sheetObject3; 
    	var nSRow=-1;
        if (ValRow_gubun == null) {
        	ValRow_gubun="R";  //R:row, V:val
        }
    	sheetObj.ColumnSort("tro_seq|tro_sub_seq");
    	//sheetObj.CheckAll2("chk") = 0;  //hidden chk : check clear
    	for (var i=1; i<=sheetObj.RowCount(); i++) {
    		if (sheetObj.GetCellValue(i, "chk") == 1) {
    			sheetObj.SetCellValue(i, "chk",0,0);
    		}	
    	}
        var nRow=0;  //findRow 
        var nStartRow=0;  //find Start Index 
        var nChkRowCnt=0; 
        while (nRow > -1) {
    	    nRow=sheetObj.FindText("tro_seq", tro_seq, nStartRow);
    	    if (nRow > -1) { 
    	    	sheetObj.SetCellValue(nRow, "chk",1,0);//maxcount 용
    	    	if (ValRow_gubun == "R") {
	    	    	nChkRowCnt++;
	    		    if ( (nSRow == -1) && (nChkRowCnt == nRow_tro_sub_seq) ) {
	    		    	nSRow=nRow;
	    		    }
    	    	}
    		    nStartRow=nRow+1;
    	    }
        }     	
    	if (ValRow_gubun == "V") {
    		nSRow=-1;  //Initialization 
	    	for (var i=1; i<=sheetObj.RowCount(); i++) {
	    		var t_tro_seq=sheetObj.GetCellValue(i, "tro_seq");
	    		var t_tro_sub_seq=sheetObj.GetCellValue(i, "tro_sub_seq");
	    		if ((t_tro_seq == tro_seq) && (t_tro_sub_seq == nRow_tro_sub_seq)) {
	    			nSRow=i;
	    		    break;
	    		}
	    	}
    	}
    	return nSRow;
    }
	// dtl : nSRow_dtl get
    function findRow_dtl_curr(tro_seq, nRow_tro_sub_seq, ValRow_gubun) {
        var formObj=document.form; 
        var sheetObj=x_sheetObject3; 
        if (ValRow_gubun == null) {
        	ValRow_gubun="R";  //R:row, V:val
        }
        if (ValRow_gubun == "R") {
	        sheetObj.ColumnSort("tro_seq|tro_sub_seq");
			var nCnt=0;
			var nSRow=0;
	    	for (var i=1; i<=sheetObj.RowCount(); i++) {
	    		if (sheetObj.GetCellValue(i, "tro_seq") == tro_seq) {
	    			nCnt++;
	    			if (nCnt == nRow_tro_sub_seq) {
	    				nSRow=i;
	    				break;
	    			}
	    		}	
	    	}
        } else if (ValRow_gubun == "V") {
			var nSRow=0;
	    	for (var i=1; i<=sheetObj.RowCount(); i++) {
	    		var t_tro_seq=sheetObj.GetCellValue(i, "tro_seq");
	    		var t_tro_sub_seq=sheetObj.GetCellValue(i, "tro_sub_seq");
	    		if ((t_tro_seq == tro_seq) && (t_tro_sub_seq == nRow_tro_sub_seq)) {
	    			nSRow=i;
	    		    break;
	    		}
	    	}
        }
        if(nSRow == 0) {
        	nSRow = sheetObj.RowCount()+1;
        }
    	return nSRow;
	}
	// dtl : tro_sub_seq_maxcount get
	function findRow_dtl_max(tro_seq) {
        var formObj=document.form; 
        var sheetObj=x_sheetObject3; 
    	var nSRow=-1;
        var nMaxCnt=0; 
        sheetObj.ColumnSort("tro_seq|tro_sub_seq");
    	//sheetObj.CheckAll2("chk") = 0;  //hidden chk : check clear
    	for (var i=1; i<=sheetObj.RowCount(); i++) {
    		if (sheetObj.GetCellValue(i, "chk") == 1) {
    			sheetObj.SetCellValue(i, "chk",0,0);
    		}	
    	}
        var nRow=0;  //findRow 
        var nStartRow=0;  //find Start Index 
        while (nRow > -1) {
    	    nRow=sheetObj.FindText("tro_seq", tro_seq, nStartRow);
    	    if (nRow > -1) { 
    	    	sheetObj.SetCellValue(nRow, "chk",1,0);//maxcount 용
    		    nStartRow=nRow+1;
    	    }
        } 
        var sRow=sheetObj.FindCheckedRow("chk");
        var arrRow=sRow.split("|");
        var nMaxCnt=arrRow.length - 1;
    	return nMaxCnt;
	}
    /**
     * Add Remark Text
     */    
    function setAddRemarkText(comboObj, idx_cd, text, chk_gubun) {
    	if (chk_gubun == "Y") {
        	if (comboObj.GetItemCheck(idx_cd)) {
    	    	if (comboObj) {
    	        	var arrComboText=text.split("|");
    	        	var objRemark=document.form.spcl_instr_rmk;
    	        	if(objRemark.value != "") {
    	        		objRemark.value += " ";
    	        	}
    	        	objRemark.value += arrComboText[1];
    	    	}
        	}
    	} else {
    		var arrComboText=text.split("|"); //textarea remark
    		if (arrComboText[1].trim() != "") { 	        	
	        	var objRemark=document.form.spcl_instr_rmk;
	        	if(objRemark.value != "") {
	        		objRemark.value += " ";
	        	}
	        	objRemark.value += arrComboText[1];
    		}
    	}
    }
    /**
     * Change Btn
     */
    function changeDisplayBtn(btnNm, link_flag) {
 	    if ("Y" == link_flag) {
// 	    	document.getElementById(btnNm).style.color="#0000ff";
 	    	document.getElementById(btnNm).style.setProperty("color", BTN_BLUE, "important");
	    } else {
		    document.getElementById(btnNm).style.setProperty("color", "#000000", "important");
	    }
    }
    /**
     * Check Td Btn Link 
     */
    function checkTdUnLink(btnNm) {
//    	return !(document.getElementById(btnNm).style.color == "rgb(1, 0, 255)");
    	return !( ComGetWebColor( document.getElementById(btnNm).style.color ) == BTN_BLUE);
    }  
    /** 
    * Change All Combo BackColor 
    */
    function setChangeAllComboBackColor() {
    	var formObj=document.form;    	
    	setComboBackColor(dcgo_seq);
    	setComboBackColor(rc_seq);
    	setComboBackColor(awk_cgo_seq);
    }
    /** 
    * Change Combo BackColor  
    */
    function setComboBackColor(comboObj) {
    	if ("" != comboObj.GetSelectText()) {
    		comboObj.SetBackColor("#ff0000");
    		comboObj.fontcolor="#ffffff";
    	} else {
    		comboObj.SetBackColor("#ffffff");
    		comboObj.fontcolor="#606060";
    	} 
    }
    function changeAllGetCellEditable(sheetObj, nRow, nSCol, nECol, bFlag) {
        for (var i=nSCol; i<=nECol; i++) {
            sheetObj.SetCellEditable(nRow, i,bFlag);
        }
    }
    /**
     * Td Btn Disabled Status Check 
     */
    function checkTdDisabled(srcName) {
    	return !(document.getElementById(srcName).className.indexOf('_1') == -1);
    }
    /**
     * img Btn Disabled Status Check
     */
    function checkInputDisabled(srcName) {
     	return (document.getElementById(srcName).getAttribute("readOnly") || document.getElementById(srcName).getAttribute("isDisabled"));
    }
    //######################[6. Check/Link/Popup]#################################################
    /**
     * handling process for input validation 
     */
    function validateForm(sheetObj, formObj, sAction, delFlg) {
	    if (delFlg == null) {
	    	delFlg="N";
	    }
        with(formObj)
        {
        	switch (sAction) {
          	    case IBSEARCH:
  					if (bkg_no.value == "" && bl_no.value == "") {
  					    //ComShowCodeMessage("BKG00255");
  					    //ComSetFocus(bkg_no);
  					    return false;
  					}
          	    	break;
          	    case IBSAVE:
  					if (bkg_no.value != oldBkgNo.value) {
  					    ComShowCodeMessage("BKG00448");  
  					    ComSetFocus(bkg_no);
  					    return false;
  					}
  					formObj.f_del_flg.value=delFlg; 
  					//if (delFlg == "N") {
  						//if (!ComChkValid(formObj)) return false;
  					//}
  					//1) Dtl : check
  					//alert(delFlg);
  					if (delFlg != 'CF') {
  						if (!checkDtl(x_sheetObject3)) {
  							return false;
  						}
  						//2) Master : check
  						if (!checkMaster(x_sheetObject2)) {
  							return false;
  						}
  					}
        	        if (delFlg == "N" && !ComShowCodeConfirm("COM12147", "")) {
        	    		return false;
        	        } else if (delFlg == "C" && !ComShowCodeConfirm("COM12147", "Current Troseq")) {
        	    		return false;
        	    	//} else if (delFlg == "CF" && !ComShowCodeConfirm("COM12147", "(Cancel/Frustrate)")) {
        	    	//	return false;
        	    	}
          	    	break; 
            }
        }
        return true;
    }    
    /**
    * DATEItem range validation check : message check 
	* getExistTodayChkMsgYn(t_all_dt, null, "M", 6);
	* getExistTodayChkMsgYn("200911301122", "2009-12-30", "M", 6);
	* sFlag : Y/M/D
    */
    function getExistTodayChkMsgYn(t_all_dt, fromDt, sFlag, nVal) {
        var strExistMsgYn="N";
        if (t_all_dt == "")
        {
			return strExistMsgYn;
        }
		var toDay=ComGetNowInfo("ymd"); 
		var toHm=ComGetNowInfo("hm");
		if (nullToBlank2(fromDt) == "") {
            fromDt=toDay; 
        }
		var t_fromDt=ComReplaceStr(fromDt, "-", "") + ComReplaceStr(toHm, ":", "");
		var t_toDt="";
		if (nullToBlank2(sFlag) != "") { 
			var toDt=ComGetDateAdd(fromDt, sFlag, nVal, "-", true);  
			t_toDt=ComReplaceStr(toDt,   "-", "") + ComReplaceStr(toHm, ":", ""); 
		}		
		//<----------------
		if ( (t_fromDt != "" && t_all_dt <= t_fromDt) || 
	         (t_toDt   != "" && t_all_dt >  t_toDt) ) { 
	       strExistMsgYn="Y";		        
		}	
		return strExistMsgYn;
	}    
    /**
    * Dtl Grid Check
    */ 
    function checkDtl(sheetObj) {
	   	var formObj=document.form;
	   	var sheetObjMst=x_sheetObject2;
	   	var strCurrTroSeq=tro_seq.GetSelectText();
   	    var boundCd=formObj.io_bnd_cd.value;
   	    var delFlg=formObj.f_del_flg.value;
   	    var strMsgExistYn_arrDt="N"; 
	   	var oldTroSeq="";
	   	var t_tro_seq="";
	   	var nTroSubCnt=0;
	   	for (var i=1; i<=sheetObj.RowCount(); i++)
	   	{	   		
	   		var t_tro_seq=sheetObj.GetCellValue(i, "tro_seq");
	   		var nSRow=sheetObjMst.FindText("tro_seq", t_tro_seq);
	   		if (i == 1) {
	   			oldTroSeq=t_tro_seq;
	   		}
	   		if (t_tro_seq == oldTroSeq) {
	   			nTroSubCnt++;
	   		} else {
	   			nTroSubCnt=1;
	   		}
		var t_ibflag=sheetObj.GetCellValue(i, "ibflag");
		var t_cxl_flg=sheetObjMst.GetCellValue(nSRow, "cxl_flg");
		var t_cfm_flg=sheetObjMst.GetCellValue(nSRow, "cfm_flg");
	   		//var so_flg    = (nullToBlank2(sheetObjMst.CellValue(nSRow, "so_no")) == "")? "N" : "Y";	   		
    		if ( (delFlg == "C" && (t_tro_seq != strCurrTroSeq)) || 
    			 (delFlg    == "Y") || 
       	   		 (t_cxl_flg == "Y") || 
//       	   	     (t_cfm_flg == "Y") ||
       	         (t_ibflag  == "D") ) 
       		{
    			oldTroSeq=t_tro_seq; 
       			continue; 
       		} 
    		var t_cntr_pkup_dt=ComReplaceStr(nullToBlank2(sheetObjMst.GetCellValue(nSRow, "cntr_pkup_dt")),      "-", "");
    		var t_cntr_pkup_dt_hhmi=ComReplaceStr(nullToBlank2(sheetObjMst.GetCellValue(nSRow, "cntr_pkup_dt_hhmi")), ":", "");
    		var t_cntr_rtn_dt=ComReplaceStr(nullToBlank2(sheetObjMst.GetCellValue(nSRow, "cntr_rtn_dt")),       "-", "");
    		var t_cntr_rtn_dt_hhmi=ComReplaceStr(nullToBlank2(sheetObjMst.GetCellValue(nSRow, "cntr_rtn_dt_hhmi")),  ":", "");
    		var t_dor_arr_dt=ComReplaceStr(nullToBlank2(sheetObj.GetCellValue(i, "arr_dt")),      "-", "");
    		var t_dor_arr_dt_hhmi=ComReplaceStr(nullToBlank2(sheetObj.GetCellValue(i, "arr_dt_hhmi")), ":", "");
			var t_pkup_dt=t_cntr_pkup_dt + t_cntr_pkup_dt_hhmi;  
			var t_rtn_dt=t_cntr_rtn_dt  + t_cntr_rtn_dt_hhmi;  
			var t_arr_dt=t_dor_arr_dt   + t_dor_arr_dt_hhmi;
			var etb_dt=formObj.etb_dt.value;
	   		//--------------------->
			var haulage=sheetObjMst.GetCellValue(nSRow, "hlg_tp_cd");
   			if (haulage == "C") 
   			{
   				//dor_addr_tp_cd
				if (!chkMandatoryItem(sheetObj, i, "dor_addr_tp_cd", t_tro_seq, nTroSubCnt, "Type")) {
                	return false;
                }
				//Location 
				if (!chkMandatoryItem(sheetObj, i, "dor_loc_cd", t_tro_seq, nTroSubCnt, "Location")) {
                	return false;
                }
				if (!chkMandatoryItem(sheetObj, i, "zn_cd", t_tro_seq, nTroSubCnt, "Location Zone Code")) {
                	return false;
                }					
            	//Zip
                if (!chkMandatoryItem(sheetObj, i, "dor_pst_no", t_tro_seq, nTroSubCnt, "Zip")) {
                	return false;
                }	                
                //dor_addr_1 : company 
                if (!chkMandatoryItem(sheetObj, i, "dor_addr_1", t_tro_seq, nTroSubCnt, "Company")) {
                	return false;
                }
                //dor_addr_2
                if (!chkMandatoryItem(sheetObj, i, "dor_addr_2", t_tro_seq, nTroSubCnt, "Address")) {
                	return false;
                }
                //-------------->
	    		//Arrival dt cuongle
    			if (!chkMandatoryDate(sheetObj, i, "arr_dt", "arr_dt_hhmi", t_tro_seq, nTroSubCnt, "Door Arrival Date")) {
            	    return false;  
                }
				if (boundCd == "O" && (t_arr_dt != "" && t_rtn_dt != "" && t_arr_dt > t_rtn_dt)) {
					ComShowCodeMessage("COM12133", "[CNTR Seq:"+t_tro_seq+", SubSeq:"+nTroSubCnt+"] Door Arrival Date", "or equal to the Return Date", "earlier"); 
					return false; 
				}
				if (boundCd == "O" && (t_arr_dt != "" && etb_dt != "" && t_arr_dt > etb_dt)) {
					ComShowCodeMessage("COM12133", "[CNTR Seq:"+t_tro_seq+", SubSeq:"+nTroSubCnt+"] Door Arrival Date", "or equal to the ETB Date", "earlier"); 
					return false; 
				} 
 				if (boundCd == "I" && (t_arr_dt != "" && t_pkup_dt != "" && t_arr_dt < t_pkup_dt)) {
 					ComShowCodeMessage("COM12133", "[CNTR Seq:"+t_tro_seq+", SubSeq:"+nTroSubCnt+"] Door Arrival Date", "or equal to the P/Up Date", "greater"); 
 					return false; 
 				}
				//04. toDay check : warning msg 
				if (getExistTodayChkMsgYn(t_arr_dt, null, "M", 6) == "Y") {
					strMsgExistYn_arrDt="Y";
				}
   				//<-------------
   			} 
   			oldTroSeq=t_tro_seq; 
	   		//<---------------------------
	   	}
	   	if (strMsgExistYn_arrDt == "Y") {
	   		ComShowMessage("Door Arrival Date must be between the current date and the current date + 6 months ! \n"+
	   				       "( today < input date <= today+6months )");
	   	} 
	   	return true;
    }
    /**
    * Master Grid Check 
    */    
    function checkMaster(sheetObj) {
   	    var formObj=document.form;
   	    var boundCd=formObj.io_bnd_cd.value;
   	    var strCurrTroSeq=tro_seq.GetSelectText();
   	    var delFlg=formObj.f_del_flg.value;
   	    var strMsgExistYn_pkupDt="N";
   	    var strMsgExistYn_rtnDt="N";
        for (var i=1; i<=sheetObj.RowCount(); i++)
        {
		var t_tro_seq=sheetObj.GetCellValue(i, "tro_seq");
		var t_cxl_flg=sheetObj.GetCellValue(i, "cxl_flg");
		var t_cfm_flg=sheetObj.GetCellValue(i, "cfm_flg");
        	//var so_flg    = (nullToBlank2(sheetObj.CellValue(i, "so_no")) == "")? "N" : "Y";
		var t_ibflag=sheetObj.GetCellValue(i, "ibflag");
 	   	    if ( (delFlg == "C" && (t_tro_seq != strCurrTroSeq)) || 
 	   	    	 (delFlg    == "Y") || 
       	   		 (t_cxl_flg == "Y") || 
//       	   	     (t_cfm_flg == "Y") ||
       	         (t_ibflag  == "D") ) 
 	   	    {
 		        continue; 
 		    }
            //------------------------>  
 	   	    var haulage=sheetObj.GetCellValue(i, "hlg_tp_cd");
        	//TP/SZ
        	if (!chkMandatoryItem(sheetObj, i, "cntr_tpsz_cd", t_tro_seq, null, "TP/SZ")) {
            	return false;
            }  
        	if (haulage == "C") 
   			{        	
            	//Cargo Weight
            	if (!chkMandatoryItem(sheetObj, i, "cgo_wgt", t_tro_seq, null, "Cargo Weight")) {
                	return false;
                }	            	
            	//Commodity
                if (!chkMandatoryItem(sheetObj, i, "tro_cmdt_cd", t_tro_seq, null, "Commodity")) {
                	return false;
                }
            	//Rep Commodity
                if (!chkMandatoryItem(sheetObj, i, "rep_cmdt_cd", t_tro_seq, null, "Rep Commodity code")) {
                	return false;
                }
                if (!chkMandatoryItem(sheetObj, i, "rep_cmdt_nm", t_tro_seq, null, "Rep Commodity name")) {
                	return false;
                }
                //Trans Mode
                //if (!chkMandatoryItem(sheetObj, i, "bkg_trsp_mzd_cd", t_tro_seq, null, "Trans Mode")) {
                	//return false;
                //} 
                if (boundCd == "I") {
                	// P/Up CY 
	                if (!chkMandatoryItem(sheetObj, i, "cntr_pkup_yd_cd", t_tro_seq, null, "P/Up CY")) {
	                	return false;
	                }
	            	//P/Up Date
	                if (!chkMandatoryDate(sheetObj, i, "cntr_pkup_dt", "cntr_pkup_dt_hhmi", t_tro_seq, null, "P/Up Date")) {
	                	return false;
	                } 
                } else {
	   			    //Return CY
	                if (!chkMandatoryItem(sheetObj, i, "cntr_rtn_yd_cd", t_tro_seq, null, "Return CY")) {
	                	return false;
	                }
	                //Return Date
	            	if (!chkMandatoryDate(sheetObj, i, "cntr_rtn_dt", "cntr_rtn_dt_hhmi", t_tro_seq, null, "Return Date")) {
	                	return false;
	                }
                }
                //Revenue
					var t_all_in_rt_cd=nullToBlank2(sheetObj.GetCellValue(i, "all_in_rt_cd"));
					var t_curr_cd=nullToBlank2(sheetObj.GetCellValue(i, "curr_cd"));
					var t_trns_rev_amt=nullToBlank2(sheetObj.GetCellValue(i, "trns_rev_amt"));
					var t_non_trns_rev_amt=nullToBlank2(sheetObj.GetCellValue(i, "non_trns_rev_amt"));
					var t_add_rev_amt=nullToBlank2(sheetObj.GetCellValue(i, "add_rev_amt"));
                if (t_all_in_rt_cd != "Y" && t_curr_cd.trim() == "") { 
                	ComShowCodeMessage("COM12200", "[CNTR Seq:"+t_tro_seq+"] T1Revenue::Currency");
                	return false;
                }
                //if (t_all_in_rt_cd != "Y" && (t_trns_rev_amt.trim() == "" || t_trns_rev_amt.trim() == ".00")) { 
                //	ComShowCodeMessage("COM12200", "[CNTR Seq:"+t_tro_seq+"] T1Revenue::Revenue(IHC)");
                //	return false;
                //} 
                if (t_all_in_rt_cd == "N" && (t_non_trns_rev_amt.trim() == "" || t_non_trns_rev_amt.trim() == ".00")) { 
                	ComShowCodeMessage("COM12200", "[CNTR Seq:"+t_tro_seq+"] T1Revenue::Revenue(IHC)");
                	return false;
                } 
   			} else if (haulage == "M") {
                if (boundCd == "I") {
	                //Return CY
	                if (!chkMandatoryItem(sheetObj, i, "cntr_rtn_yd_cd", t_tro_seq, null, "Return CY")) {
	                	return false;
	                }
                } else {
                	// P/Up CY 
	                if (!chkMandatoryItem(sheetObj, i, "cntr_pkup_yd_cd", t_tro_seq, null, "P/Up CY")) {
	                	return false;
	                }
                }
                //P/Up Date
                if (!chkMandatoryDate(sheetObj, i, "cntr_pkup_dt", "cntr_pkup_dt_hhmi", t_tro_seq, null, "P/Up Date")) {
                	return false;
                }
                //Return Date
            	if (!chkMandatoryDate(sheetObj, i, "cntr_rtn_dt", "cntr_rtn_dt_hhmi", t_tro_seq, null, "Return Date")) {
                	return false;
                }
   			}
			var t_cntr_pkup_dt=ComReplaceStr(nullToBlank2(sheetObj.GetCellValue(i, "cntr_pkup_dt")),      "-", "");
			var t_cntr_pkup_dt_hhmi=ComReplaceStr(nullToBlank2(sheetObj.GetCellValue(i, "cntr_pkup_dt_hhmi")), ":", "");
			var t_cntr_rtn_dt=ComReplaceStr(nullToBlank2(sheetObj.GetCellValue(i, "cntr_rtn_dt")),       "-", "");
			var t_cntr_rtn_dt_hhmi=ComReplaceStr(nullToBlank2(sheetObj.GetCellValue(i, "cntr_rtn_dt_hhmi")),  ":", "");
			var t_pkup_dt=t_cntr_pkup_dt + t_cntr_pkup_dt_hhmi;  
			var t_rtn_dt=t_cntr_rtn_dt  + t_cntr_rtn_dt_hhmi;  
			var etb_dt=formObj.etb_dt.value; 
			//-------------------
			//pkup date : check
			if (boundCd == "O" && (t_pkup_dt != "" && etb_dt != "" && t_pkup_dt > etb_dt)) {
				ComShowCodeMessage("COM12133", "[CNTR Seq:"+t_tro_seq+"] P/Up Date", "or equal to the ETB Date", "earlier");  
				return false; 
			} 
			//02. toDay check : warning msg 
			if (getExistTodayChkMsgYn(t_pkup_dt, null, null, null) == "Y") {
				strMsgExistYn_pkupDt="Y";
			}
			//-------------------
        	//rtn date : check
			if (boundCd == "O" && (t_rtn_dt != "" && etb_dt != "" && t_rtn_dt > etb_dt)) {
				ComShowCodeMessage("COM12133", "[CNTR Seq:"+t_tro_seq+"] Return Date", "or equal to the ETB Date", "earlier"); 
				return false; 
			} 
			if (t_rtn_dt != "" && t_pkup_dt != "" && t_rtn_dt < t_pkup_dt) {
				ComShowCodeMessage("COM12133", "[CNTR Seq:"+t_tro_seq+"] Return Date", "or equal to the P/Up Date", "greater"); 
				return false; 
			}
			if (getExistTodayChkMsgYn(t_rtn_dt, null, null, null) == "Y") {
				strMsgExistYn_rtnDt="Y";
			}
            //<------------------------
        }
        if (strMsgExistYn_pkupDt == "Y") {
        	ComShowCodeMessage("COM12133", "P/Up Date", "the current date", "greater");  
	   	} 
        if (strMsgExistYn_rtnDt == "Y") {
        	ComShowCodeMessage("COM12133", "Return Date", "the current date", "greater");  
	   	} 
        return true;
    }
    /**
    * master/dtl Mandatory Msg Handling
    */
    function chkMandatoryItem(sheetObj, nRow, colId, currTroSeq, nTroSubCnt, caption)
    {
    	var t_val=nullToBlank2(sheetObj.GetCellValue(nRow, colId));
        if (t_val.trim() == "") {
        	if (nTroSubCnt == null) {
        		ComShowCodeMessage("COM12200", "[CNTR Seq:"+currTroSeq+"] "+caption);
        	} else {
        		ComShowCodeMessage("COM12200", "[CNTR Seq:"+currTroSeq+", SubSeq:"+nTroSubCnt+"] "+caption);
        	}
            return false;
        }
        return true;
    }
    /**
    * master/dtl DATE Item Mandatory Msg Handling
    */
    function chkMandatoryDate(sheetObj, nRow, colId_d, colId_h, currTroSeq, nTroSubCnt, caption)
    {
		var t_dt=ComReplaceStr(nullToBlank2(sheetObj.GetCellValue(nRow, colId_d)), "-", "");
		var t_dt_hhmi=ComReplaceStr(nullToBlank2(sheetObj.GetCellValue(nRow, colId_h)), ":", "");
		var t_all_dt=t_dt + t_dt_hhmi;
		if (t_dt == "") {
			if (nTroSubCnt == null) {
			    ComShowCodeMessage("COM12200", "[CNTR Seq:"+currTroSeq+"] "+caption+"(day)");
        	} else {
        		ComShowCodeMessage("COM12200", "[CNTR Seq:"+currTroSeq+", SubSeq:"+nTroSubCnt+"] "+caption+"(day)");
        	} 
			return false; 
		}
		if (t_dt_hhmi == "") {
			if (nTroSubCnt == null) {
			    ComShowCodeMessage("COM12200", "[CNTR Seq:"+currTroSeq+"] "+caption+"(hour)");
        	} else {
        		ComShowCodeMessage("COM12200", "[CNTR Seq:"+currTroSeq+", SubSeq:"+nTroSubCnt+"] "+caption+"(hour)");
        	} 
			return false; 
		}
		return true;
    }   
    /**
    * Location CommonPopup Value setting 
    */
    function getCOM_ENS_061_1(aryPopupData, row, col, sheetIdx) { 
    	var formObj=document.form;
    	var nod_cd=aryPopupData[0][3];
    	if (nod_cd.length == 7) {
        	formObj.dor_loc_cd.value=nod_cd.substr(0,5); 
        	formObj.zn_cd.value=nod_cd.substr(5,7); 
        	formObj.dor_addr_3.value=aryPopupData[0][4];
        	var countrycd=aryPopupData[0][6];
        	getSearchCountryName(countrycd);
    	}
    }
    /**
    * MDM_COUNTRY Value setting 
    */
    function getSearchCountryName(cnt_cd) { 
    	var formObj=document.form;
    	var param="f_cmd=" + SEARCH01 + "&input_text=" + cnt_cd;
      	var sXml=x_sheetObject2.GetSearchData("ESM_Booking_UtilGS.do", param);
    	var output_text=ComGetEtcData(sXml, "output_text");
    	if(output_text.length > 0){
    		formObj.dor_addr_4.value=output_text;
    	}else{
    		formObj.dor_addr_4.value='' ;
    	}
    }
    /**
     * Booking TRO_Multi Cancel/Frustrate Select Popup Call. <br>
     */
    function comBkgCallPop0703(callback_func, bkg_no, io_bnd_cd){
     	var param="?bkg_no="+bkg_no+"&io_bnd_cd="+io_bnd_cd;     	
 		ComOpenPopup('ESM_BKG_0703.do'+param, 780, 445 , callback_func, '1,0,1,1,1,1,1,1,1,1,1,1', true);	
    }
	/**
	 * Booking TRO-Confirm Select Popup Call. <br>
	 */
	function comBkgCallPop0906(callback_func, bkg_no, io_bnd_cd){
		var param="?bkg_no="+bkg_no+"&io_bnd_cd="+io_bnd_cd;
		ComOpenPopup('ESM_BKG_0906.do'+param, 720, 425 , callback_func, '1,0,1,1,1,1,1,1,1,1,1,1', true, true, 0, 0, 0);	
	}    
	/**
	 * Booking TRO-Multi Select Popup Call. <br>
	 */
//	function comBkgCallPop0921(callback_func, bkg_no, cntr_no, boundCd){
//		var param="?bkg_no="+bkg_no+"&cntr_no="+cntr_no+"&bound_cd="+boundCd;
//		ComOpenPopup('ESM_BKG_0921.do'+param, 322, 320 , callback_func, '1,0,1,1,1,1,1,1,1,1,1,1', false);
//	} 
    /**
     * CntrNo popup Value setting
     */
    function setCntrNoCallBack(aryPopupData, row, col, sheetIdx) { 
    	var formObj=document.form;
        var add_cntr_no = aryPopupData[0][2];
        var sheetObj_qty=x_sheetObject2;
        for(var i=1; i<=sheetObj_qty.RowCount(); i++)
        {
        	if ( (sheetObj_qty.GetCellValue(i, "eur_trns_tp_cd") != "FR") && (sheetObj_qty.GetCellValue(i, "cxl_flg") != "Y") && (formObj.tro_seq.value != sheetObj_qty.GetCellValue(i, "tro_seq")) && (add_cntr_no == sheetObj_qty.GetCellValue(i, "cntr_no"))){
            	       ComShowCodeMessage("BKG01197", add_cntr_no);
                        return false;
              }
        }
  	
    	formObj.cntr_no.value=aryPopupData[0][2];
    	//cgo_wgt/tpsz Change : tpsz Add
    	doActionIBSheet(x_sheetObjMsg, formObj, COMMAND04);	
    }
    function setT1RevenueCallBack(aryPopupData) {
    	var formObj=document.form; 
    	//var t_bkg_no        	= nullToBlank2(aryPopupData[0][1]); 
    	var t_t1_doc_flg=nullToBlank2(aryPopupData[0][2]);    	
    	var t_cstms_clr_no=nullToBlank2(aryPopupData[0][3]);
    	var t_all_in_rt_cd=nullToBlank2(aryPopupData[0][4]); 
    	var t_curr_cd=nullToBlank2(aryPopupData[0][5]);
    	var t_trns_rev_amt=nullToBlank2(aryPopupData[0][6]);
    	var t_non_trns_rev_amt=nullToBlank2(aryPopupData[0][7]);
    	var t_add_rev_amt=nullToBlank2(aryPopupData[0][8]);
    	var t_add_rev_chg_cd=nullToBlank2(aryPopupData[0][9]);
    	var t_cxl_flg=nullToBlank2(aryPopupData[0][10]);
    	var t_vat_flg=nullToBlank2(aryPopupData[0][11]);
        with(formObj) {
        	t1_doc_flg.value=t_t1_doc_flg;
            cstms_clr_no.value=t_cstms_clr_no;
            all_in_rt_cd.value=t_all_in_rt_cd;
            curr_cd.value=t_curr_cd;
            trns_rev_amt.value=t_trns_rev_amt;
            non_trns_rev_amt.value=t_non_trns_rev_amt;
            add_rev_amt.value=t_add_rev_amt;
            add_rev_chg_cd.value=t_add_rev_chg_cd;
            cxl_flg.value=t_cxl_flg; 
            vat_flg.value=t_vat_flg;
            //if (t1_doc_flg.value == "Y") { 
            var strMandatoryFlg="N";
            if (t_all_in_rt_cd == "Y" || (t_all_in_rt_cd != "Y" && t_non_trns_rev_amt != "")) { 
            	strMandatoryFlg="Y";
            }
            if (strMandatoryFlg == "Y") { 
//    		    document.getElementById("btn_t2cT1Revenue").style.color="#0000ff";
            	document.getElementById("btn_t2cT1Revenue").style.setProperty("color", BTN_BLUE, "important");
    	    } else {
    	    	document.getElementById("btn_t2cT1Revenue").style.setProperty("color", "#000000", "important");
    	    }
        }
    }
    function setActCustCallBack(aryPopupData) {
    	var formObj=document.form; 
    	var p_loc_cd              = nullToBlank2(aryPopupData[0][1]); 
    	var p_zn_cd               = nullToBlank2(aryPopupData[0][2]); 
    	var p_act_shpr_nm=nullToBlank2(aryPopupData[0][3]); 
    	var p_cntc_pson_nm=nullToBlank2(aryPopupData[0][7]); 
    	var p_cntc_phn_no=nullToBlank2(aryPopupData[0][8]);
    	var p_cntc_phn_no=nullToBlank2(aryPopupData[0][8]);
//    	var addr=nullToBlank2(aryPopupData[0][10]); 
    	var addr_1 = nullToBlank2(aryPopupData[0][11]);
    	var addr_2 = nullToBlank2(aryPopupData[0][12]);
    	var addr_3 = nullToBlank2(aryPopupData[0][13]);
    	var p_dor_zip_id=nullToBlank2(aryPopupData[0][14]); 
//    	var nAddr=addr.length;    	
//    	var addr_1=""; //50
//    	var addr_2=""; //100
//    	var addr_3=""; //150
//    	//var addr_4 = ""; //200
//    	if (nAddr > 100) {
//    		addr_1=addr.substr(0, 50);
//    		addr_2=addr.substr(50, 50); 
//    		if (nAddr > 150) {
//    			addr_3=addr.substr(100, 50);
//    		} else {
//    			addr_3=addr.substr(100, nAddr);
//    		}
//    	} else if (nAddr > 50) {
//    		addr_1=addr.substr(0, 50);
//    		addr_2=addr.substr(50, nAddr);
//    	} else {
//    		addr_1=addr.substr(0, nAddr);
//    	}
    	formObj.dor_loc_cd.value   = p_loc_cd; 
        formObj.zn_cd.value        = p_zn_cd; 
        formObj.dor_addr_1.value=p_act_shpr_nm; 
		formObj.dor_addr_2.value=addr_1; 
		formObj.dor_addr_3.value=addr_2; 
		formObj.dor_addr_4.value=addr_3; 
    	formObj.dor_pst_no.value=p_dor_zip_id;
    	formObj.cntc_pson_nm.value=p_cntc_pson_nm;
    	formObj.cntc_phn_no.value=p_cntc_phn_no;
    }
    function setCxlFrustCallBack(aryPopupData) {    
    	var formObj=document.form;
    	doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);  //재Retrieve
    }    
    function setConfirmCallBack(aryPopupData) {
        var formObj=document.form; 
    	if(aryPopupData==null) return false;
    	if(aryPopupData.msg == "OK"){
    		doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);  //재Retrieve
    	}
    }
    function sendFaxEmail(fax, email) {
    	var formObj=document.form; 
    	formObj.fax_no.value=fax;
    	formObj.eml.value=email;
    	if (formObj.cntc_eml.value != email) {
    		formObj.cntc_eml.value=email;
    	}
    	doActionIBSheet(x_sheetObjMsg, formObj, COMMAND02);	
    }
    //#############################(7. Util/Etc)##################################################
    function ComEnableObject_loc(obj, bEnable)
    {
        try {
            switch( obj.type ) {
                case "password" :
                case "text" :
                	obj.readOnly=!bEnable;
                    break;
                default:
                    obj.disabled=!bEnable;
            }
            switch( obj.type ) {
                case "select-one" :
                case "text" :
                    if (bEnable){
                        //if (obj.className=="input2_1"){	     
                        if (obj.className=="input2_2"){	      
                        	obj.className="input1";	     
                        } else if (obj.className=="input2"){ 
                        	obj.className="input";          
                        }
                    } else {
                        if (obj.className=="input1"){         
                            //obj.className = "input2_1";    
                        	obj.className="input2_2";   
                        } else if (obj.className=="input"){  
                            obj.className="input2";       
                        }
                    }
                    break;
                case "textarea":
                    if (bEnable){
                        obj.className="textarea";
                    } else {
                        obj.className="textarea2";
                    }
                    break;
				default :
                    if (obj.tagName=="IMG" || obj.tagName=="img") {
                        if (bEnable){
                            obj.style.cursor="hand";
                            obj.style.filter="";
                        } else {
                            obj.style.cursor="default";
                            obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
                        }
                    }
             }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function ComEnableManyObjects_loc(bEnable, objs) {
        try {
            var args=arguments;
            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) ComEnableObject_loc(args[i], bEnable);
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    function ComClassNameManyObjects_loc(p_className, objs) {
        try {
            var args=arguments;
            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) {
                	args[i].className=p_className;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }    
//	/**
//	 * IBMultiCombo  Enable/Disable Handling  
//	 */
//    function ComEnableManyIBCombo(bEnable, bgColor, objs) {
//        try {
//            var args=arguments;
//            if (args.length < 2) return;
//            for(var i=1; i<args.length; i++) {
//                if (args[i].tagName != undefined) {
//                	args[i].SetEnable(bEnable);
//                	if (bgColor.length > 0) {
//                		args[i].SetBackColor(bgColor);
//                	}
//                }
//            } 
//        } catch(err) { ComFuncErrMsg(err.message); }
//    }
	/**
	 * IBMultiCombo  Enable/Disable Handling  
	 */
    function ComEnableManyTd(bEnable, objs) {
	    try {
	        var args=arguments;
	        if (args.length < 2) return;
	        for(var i=1; i<args.length; i++) {
	 	    	if (bEnable == true) {
		    		ComBtnEnable(args[i]);
		    	} else {
		    		ComBtnDisable(args[i]);
		    	} 
	        }
	    } catch(err) { ComFuncErrMsg(err.message); }
    }	         
    /*
     * Remove Comma
     * @author : Lee Nam Kyung
     */    
     function delComma_loc(txtVal) {
         var comma=/,/gi;
         var temp=txtVal;
         temp=temp.replace(comma, '');
         return temp;
     }
     /*
      * (-) Remove
      * @author : Lee Nam Kyung
      */    
      function delMask_loc(objTxt, gubun) {
    	  var mask="";
    	  if (gubun == "-") {
    		  mask=/-/gi;
    	  } else if (gubun == ":") {
    		  mask=/:/gi;
    	  }
          var temp=objTxt.value;
          temp=temp.replace(mask, '');
          return temp;
      }    
      function changeMask_hm_loc(objTxt, gubun) {
    	  var strTemp=delMask_loc(objTxt, gubun);
    	  var strHH="";
    	  var strMI="";
    	  var strgubun_1="";
    	  if (strTemp.length > 4) {
    	      strTemp=strTemp.substring(0, 4);
    	  }
    	  if (strTemp.length > 2 ) {
    		  strHH=strTemp.substring(0, 2);
    		  strgubun_1=gubun;
    		  strMI=strTemp.substring(2, strTemp.length);
    	  } else {
    		  strHH=strTemp.substring(0, strTemp.length);
    		  strgubun_1="";
    		  strMI="";
    	  }
    	  return strHH+strgubun_1+strMI;
      }
      function changeMask_ymd_loc(objTxt, gubun) {
    	  var strTemp=delMask_loc(objTxt, gubun);
    	  var strYYYY="";
    	  var strMM="";
    	  var strDD="";
    	  var strgubun_1="";
    	  var strgubun_2="";
    	  if (strTemp.length > 8) {
    	      strTemp=strTemp.substring(0, 8);
    	  }
    	  if (strTemp.length > 6 ) {
    		  strYYYY=strTemp.substring(0, 4);
    		  strgubun_1=gubun;
    		  strMM=strTemp.substring(4, 6);
    		  strgubun_2=gubun;
    		  strDD=strTemp.substring(6, strTemp.length);
    	  } else if (strTemp.length > 4 ) {
    		  strYYYY=strTemp.substring(0, 4);
    		  strgubun_1=gubun;
    		  strMM=strTemp.substring(4, strTemp.length);
    		  strgubun_2="";
    		  strDD="";
    	  } else {
    		  strYYYY=strTemp.substring(0, strTemp.length);
    		  strgubun_1="";
    		  strMM="";
    		  strgubun_2="";
    		  strDD="";
    	  }
    	  return strYYYY+strgubun_1+strMM+strgubun_2+strDD;
      }      
     /*
      * Change Comma
      */
    //function changeComma_loc(objTxt, term1, pCnt, nAccount)
    function changeComma_loc(txtVal, term1, pCnt, nAccount)
    {
        var strResult="";    	  
 		var comma=/,/gi;   
 		//var temp  = objTxt.value;
 		var temp2=txtVal;
// 		var temp2=temp.replace(comma, "");
 		temp2=ComReplaceStr(temp2, ",", "");
// 		temp=temp2.replace('-', '');
 		temp2=ComReplaceStr(temp2, "-", "");
 		if(temp2!= -1 && temp2.indexOf('.') != -1)  
 		{
 		    var jum_up=temp2.substring(0, temp2.indexOf('.'));
 		    if (jum_up.length > pCnt) {
 			    jum_up=jum_up.substring(0, pCnt);
 		    }
 		    var jum_down=temp2.substring(temp2.indexOf('.')+1, temp2.length);
 		    if (jum_down.length > nAccount) {
 			    jum_down=jum_down.substring(0, nAccount);
 		    }
 		    jum_up=parseInt(jum_up)+'';
 		    if(jum_up == 'NaN') jum_up='';
 		    if (term1 == 0) {
 		    	//objTxt.value = Comma_Input(jum_up)+"."+jum_down;
 		    	strResult=Comma_Input(jum_up)+"."+jum_down;
 		    } else { 
 		    	//objTxt.value = jum_up+'.'+jum_down;
 		    	strResult=jum_up+'.'+jum_down;
 		    }
 		}else {
 		    temp2=parseInt(temp2)+'';
 		    if (temp2.length > pCnt) {
 			    temp2=temp2.substring(0, pCnt);
 		    }        
 		    if(temp2 == 'NaN') temp2='';
 		    if (term1 == 0) {
 		    	//objTxt.value = Comma_Input(temp);
 		    	strResult=Comma_Input(temp2);
 		    } else {
 		    	//objTxt.value = temp;
 		    	strResult=temp2;
 		    }
 		}
 		return strResult;
     }
     /*
     * Input Comma
     */
     function Comma_Input(txtNumber)
     {
     	var v=txtNumber;
     	var vlen=v.length;
     	var c=1;       
     	var tmp=new Array();
     	var comma=','; 
     	var pas="";
     	for ( i=vlen ; i>-1; i-- ) { 
     		c++;
     		if ( ( c%3 == 0 ) && ( i != vlen - 1) ) {
     			tmp[i]=v.charAt(i) + comma; 
     		} else {
     			tmp[i]=v.charAt(i);
     		}
     	}
     	for ( i=0; i<tmp.length; i++ ) {
     		pas=pas + tmp[i];
     	}
     	return pas;
     }
     function callShowMessageAddCNTR() {
    	 ComShowCodeMessage("COM12130", "click event", "AddCNTR button");
     }
     function callShowMessageBiggerQty(strMsgTitle) {
         ComShowCodeMessage("COM12133", "["+strMsgTitle+"] Total Qty", "or equal to the BKG Qty", "lesser");
     }
	 /**
	 * check_Enter  
	 */
	function check_Enter() {
		var formObj=document.form;
    	var srcName=ComGetEvent("name");//cuongle
    	var srcValue=ComGetEvent("value");
		if (event.keyCode == 13) {
			if(ComGetEvent("name") == "bkg_no" || ComGetEvent("name") == "bl_no"){
				formObj.elements[srcName].value=srcValue.toUpperCase();
				doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
			}
		}
	}
	 /**
	  * onblur Event Handling <br>
	  **/
	 function obj_deactivate() {
		if(ComGetEvent("name") != "bkg_no" && ComGetEvent("name") != "bl_no"){
			 if(eval('document.form.'+ComGetEvent("name")).value.length > 0){
				 ComSetObjValue(document.form.modify_flag, "Y");	 
			 }
		} else {
	    	var formObj=document.form;
	    	var srcName=ComGetEvent("name");
	    	var srcValue=ComGetEvent("value");
			formObj.elements[srcName].value=srcValue.toUpperCase();
		}
	  }
	 /**
	 * searchData
	 */
	 function searchData(bkgNo){
	 	var formObj=document.form;
	 	ComSetObjValue(formObj.bkg_no ,bkgNo);
	 	ComSetObjValue(formObj.modify_flag,"N");
	 	doActionIBSheet(x_sheetObject2, formObj, IBSEARCH);
	 }
	 /**
	 * checkModify
	 */
	 function checkModify(){	
		var formObj=document.form;
		if(ComGetObjValue(formObj.modify_flag) == "Y"){
			tab_alert_msg=false;
			if (!ComShowConfirm(ComGetMsg("BKG00350")))
				return false; // Are you sure to save the changes?
			doActionIBSheet(x_sheetObject2, formObj, IBSAVE);
		}
	 }
	/**
	* setInquiryDisableButton Event Call
	*/
	function setInquiryDisableButton(){
		ComBtnDisable("btn_t2cSave");
		ComBtnDisable("btn_t2cSaveSeq");
		ComBtnDisable("btn_t2cConfirm");
		ComBtnDisable("btn_t2cCancelFrustrate");
		ComBtnDisable("btn_t2cTROCopy");
		ComBtnDisable("btn_t2cTRONotice");
		ComBtnDisable("btn_t2cAddCNTR");
		ComBtnDisable("btn_t2cCopyCNTR");		
		ComBtnDisable("btn_t2cAdd");		
		ComBtnDisable("btn_t2cDelete");		
	}
	/* Developer Work End */

	
	   function nullToBlank2(val) {
		   if((val==null) ||val == -1 ) {
			   return "";
		   }
		   return val;
	   }
	   
	     /**
	      * CMDT Info Save Function. <br>
	      */    
	 	function callBack0653(arrVal){
	     	var formObj=document.form;
	 		if(arrVal != null){
	 			ComSetObjValue(formObj.tro_cmdt_cd,arrVal[0][3]);
	 			ComSetObjValue(formObj.rep_cmdt_cd,arrVal[0][5]);
	 			ComSetObjValue(formObj.rep_cmdt_nm,arrVal[0][4]);		
	 		}
	 	}

	    /** 
	     * Check TRO container qty with booking
	     */ 
	    function checkTroQty(sheetObj_qty) {
	       	var cntr_tpsz_cd_msg = "";
	       	for(var i=1; i<=sheetObj_qty.RowCount(); i++) {
	       		var cntr_tpsz_cd=sheetObj_qty.GetCellValue(i, "cntr_tpsz_cd");
	       		var n_totQty=parseInt(sheetObj_qty.GetCellValue(i, "total_qty"));
	       		var n_currTroqty_CH=parseInt(sheetObj_qty.GetCellValue(i, "tro_qty_ch"));
	       		var n_currTroqty_MH=parseInt(sheetObj_qty.GetCellValue(i, "tro_qty_mh"));
	   	    	var n_currTroqty=n_currTroqty_CH + n_currTroqty_MH;
	   			if (n_totQty < n_currTroqty) {
	   				cntr_tpsz_cd_msg += ", " + cntr_tpsz_cd;
	   			} 
	       	}
	       	
			if(cntr_tpsz_cd_msg!=""){
				ComShowCodeMessage("BKG01194", cntr_tpsz_cd_msg.substr(2));
			}
	    }  
