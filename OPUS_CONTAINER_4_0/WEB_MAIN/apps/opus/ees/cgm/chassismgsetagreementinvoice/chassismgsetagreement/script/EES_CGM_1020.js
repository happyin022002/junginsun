/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1020.js
*@FileTitle  : Lease Agreement Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ees_cgm_1020 : ees_cgm_1020 business script for
 */
    function ees_cgm_1020() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* developer job	*/
    // common global variables
    var currCd="";	// Currency
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var tabLoad=new Array();
    
    var oldCntrTypeSize = "";
    var sCntrTypeSize = "";

    
    tabLoad[0]=0;
    tabLoad[1]=0;
    BTN_ENABLE = "btn_accent";
    BTN_DISABLE = "btn_normal"
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    
    var t3sheet1_leftHeaders = [{Text:"Fixed Rate", Align:"Center"}];
    var t1sheet1_leftHeaders = [{Text:"Initial Value", Align:"Center"}];
    /**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version 2009.05.28
     */  
    function processButtonClick(){
    	///***** use additional sheet var in case of more than 2 tap each sheet *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        var sheetObject5=sheetObjects[4];
        ///*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
 			switch(srcName) {
 				case "btn_Retrieve":
 					if(ComCgmIsActionButtonEnable(srcName)){
	 					if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
	 						// Search 
	 						var result=doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	 						if(result){
		 						// Form Control enable/disable handling
		 						doControlEnable("btn_Retrieve");
		 						// 
			    		    	doActionBtnEnable('R');
			    		    	tabObjects[0].SetSelectedIndex(0);
			    		    	
	 						}else {
	 							//msgs['CGM10012']='There is no data to search.';
	 							ComShowCodeMessage('CGM10012');

	 						//20160504 Added by Jun Kato
	 						// Form Control reset
	 	 						initControl();
	 		 					// Form Control Enable setting
	 		 					doControlEnable("btn_New");
	 							
//	 					  		}
	 						}
	 					}
 					}
 					break;
 				case "btn_New":
 					if(ComCgmIsActionButtonEnable(srcName)){
	 					// Form Control reset
 						initControl();
 						formObj.agmt_ref_no.focus();
	 					// Form Control Enable setting
	 					doControlEnable("btn_New");
	 					// button enable/disable handling
	 					formObject.agmt_no.value="NEW";
	    		    	doActionBtnEnable('N');
	 					break;
 					}
 				case "btn_Delete":
 					if(ComCgmIsActionButtonEnable(srcName)){
 						if(validateForm(sheetObject1,formObject,IBDELETE) != false) {
 							if(ComShowCodeConfirm('CGM00005','the Agreement')){
		 						// deleting 
		 						doActionIBSheet(sheetObject2,formObject,IBDELETE);
		 					}
 						}
 					}
 					break;
 				case "btn_Save":
 					if(ComCgmIsActionButtonEnable(srcName)){
 						if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
		 					if(ComShowCodeConfirm('CGM10047')){
		 						// saving 
		 						doActionIBSheet(sheetObject1,formObject,IBSAVE);
		 					}
 						}
 					}
 					break;
 				case "btn_VersionUp":
// 					alert(srcName + " : " + ComCgmIsActionButtonEnable(srcName));
 					if(ComCgmIsActionButtonEnable(srcName)){
 						// Version Up
 						doVersionUp();
 						// Form Control Enable setting
 						doControlEnable("btn_VersionUp");
	 					// button enable/disable handling
	    		    	doActionBtnEnable('V');
 					}
 					break;
 				case "btn_t2RowAdd":
 					if(sheetObject5.GetEnable()){
 						doActionIBSheet(sheetObject5,formObject,IBINSERT);
 					}
 					break;
 				case "btn_t2Delete":
 					if(sheetObject5.GetEnable()){
 						doActionIBSheet(sheetObject5,formObject,IBRESET);
 					}
 					break;
 				case "btn_t3RowAdd":
 					if(formObject.eq_rntl_tp_cd[1].checked){	
 						if(sheetObject2.GetEnable()){
 							doActionIBSheet(sheetObject2,formObject,IBINSERT);
 						}
 					} else if (formObject.eq_rntl_tp_cd[2].checked){
 						if(sheetObject3.GetEnable()){
 							doActionIBSheet(sheetObject3,formObject,IBINSERT);
 						}
 					}
 					break;
 				case "btn_t3Delete":
 					if(formObject.eq_rntl_tp_cd[1].checked){
 						if(sheetObject2.GetEnable()){
 							doActionIBSheet(sheetObject2,formObject,IBRESET);
 						}
 					} else if (formObject.eq_rntl_tp_cd[2].checked){
 						if(sheetObject3.GetEnable()){
 							doActionIBSheet(sheetObject3,formObject,IBRESET);
 						}
 					}
 					break;
 				case "btns_Calendar_agmtDt" :		// Agreement Date
 					if(!formObject.agmt_dt.readOnly){
						var cal=new ComCalendar();
						cal.select(formObject.agmt_dt, "yyyy-MM-dd");
 					}
					break;
				case "btns_Calendar_effDt" :		// Effective Date (From Date)
					if(!formObject.eff_dt.readOnly){
						var cal=new ComCalendar();
			    		cal.select(formObject.eff_dt, "yyyy-MM-dd");
					}
		    		break;		
				case "btns_Calendar_agmt_effDt" :		// Agreement Effective Date (From Date)
					if(!formObject.agmt_eff_dt.readOnly){
						var cal=new ComCalendar();
			    		cal.select(formObject.agmt_eff_dt, "yyyy-MM-dd");
					}
		    		break;		
				case "btns_Calendar_agmt_expDt" :		// Agreement Effective Date (To Date)
					if(!formObject.agmt_exp_dt.readOnly){ 
						var cal=new ComCalendar();
			    		cal.select(formObject.agmt_exp_dt, "yyyy-MM-dd");
					}
		    		break;
				case "dpp_tp_cd": 					// Rental Rate Type Radio Button
				case "drp_off_lmt_tp_cd":			// Fixed Quantity, Guaranted Portion
         	   		doOptionBtnAction(formObject, srcName);
					break;
				case "eq_rntl_tp_cd":				// Rental Rate Type Radio Button
	         	   	setTab3SheetEnable(formObject);
	         	   	if(formObject.eq_rntl_tp_cd[0].checked){
		      			if(sheetObjects[0].RowCount() == 0){
		      				InitHeadColumn(t3sheet1_leftHeaders,sheetObjects[0]);
		      				sheetObjects[0].DataInsert(-1); // Rental Rate
		      			}
	         	   	}
					break;
				case "btns_agmtno":	// Agreement No getting popup
					if(!formObject.agmt_no.readOnly){
						
						ComOpenPopupWithTarget('/opuscntr/EES_CGM_1117.do', 800, 440, "agmt_no:agmt_no", "1,0,1,1,1,1,1,1,1", true);
					}
					break;
				case "btns_vndr":	// Lessor Code getting popup
					if(!formObject.vndr_seq.readOnly){
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_0C1.do', 700, 455, "vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "1,0,1,1,1,1", true);
					}
					break;	
				case "btns_curr_cd":	// Currency getting popup
					var currCd=document.getElementById("btns_curr_cd");
					if(!currCd.disabled){
						var param="curr_cd=&cnt_cd=&curr_desc=";
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 700, 450, "curr_cd:curr_cd", "1,0,1,1,1", true);
					}
					break;		
             } // end switch
             tRoleApply();
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
    /**
     * Control Action  Enable control <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */     
    function doControlEnable(srcName){
    	var formObj=document.form;
    	switch(srcName){
    		case "btn_Retrieve":
    			setFormControlEnable(formObj, false);
    			 //Added by kato (To disable agmt no version after version up due to Rate eff date onblur problem)
    	        agmt_ver_no.SetEnable(1);
    	        //
    	 		break;
    	 	case "btn_New":
    	 		setFormControlEnable(formObj, true);
    	 		doOptionBtnAction(formObj, "dpp_tp_cd");
    	 		//Added by kato (To disable agmt no version after version up due to Rate eff date onblur problem)
    	        agmt_ver_no.SetEnable(1);
    	        //
    	 		break;
    	 	case "btn_VersionUp":
    	 		setFormControlEnable(formObj, true);
    	        ComCgmEnableObject(formObj.agmt_no, false);
    	        ComCgmEnableObject(formObj.btns_agmtno, false);
    	        ComCgmEnableObject(formObj.agmt_eff_dt, false);
    	        ComCgmEnableObject(formObj.agmt_dt, false);
    	        ComCgmEnableObject(formObj.agmt_exp_dt, true);
    	        ComCgmEnableObject(formObj.btns_Calendar_agmt_effDt, false);
    	        ComCgmEnableObject(formObj.btns_Calendar_agmtDt, false);
        		ComCgmEnableObject(formObj.btns_Calendar_agmt_expDt, true);
        		ComCgmEnableObject(formObj.btns_curr_cd, false);
    	        agmt_lstm_cd.SetEnable(0);
    	        chss_pool_cd.SetEnable(0);
    	        ComCgmEnableObject(formObj.vndr_seq, false);
    	        ComCgmEnableObject(formObj.btns_vndr, false);
    	        doOptionBtnAction(formObj, "dpp_tp_cd");
    	        ComCgmEnableObject(formObj.agmt_exp_dt, true, 'input1');
    	        
    	      //Added by kato (To disable agmt no version after version up due to Rate eff date onblur problem)
    	        agmt_ver_no.SetEnable(0);
    	        //
    	        
    	 		break;
    	 	default:	// Load
    	 		setFormControlEnable(formObj, false);
    	 	    ComCgmEnableObject(formObj.agmt_no, true);
 	            ComCgmEnableObject(formObj.btns_agmtno, true);
    	 		break;
    	}
    	tRoleApply();
    }
    /**
     * registering IBSheet Object as list <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version 2009.05.28
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * @param  
     * @return 
     * @author 
     * @version 2009.05.28
     */
    function loadPage() {
    	var formObj=document.form;
    	// axon event regist
        // axon_event.addListenerFormat('keypress', 'obj_keypress', form);
         axon_event.addListenerForm('keydown', 'obj_keydown', formObj);
//    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListenerForm('focusin', 'obj_focusIn', form);
        axon_event.addListenerForm('blur', 'obj_onBlur', form);
        axon_event.addListener('change', 'obj_change', 'agmt_no', 'vndr_seq', 'pay_term_dys'); 
//        axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
//        axon_event.addListener('change', 'obj_change', 'pay_term_dys'); 
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);

        // Tab Object reset
    	for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
    	// Sheet Object reset
        for(i=0;i<sheetObjects.length;i++){
        	//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBMultiCombo reset
        comboObjects[comboCnt++]=agmt_ver_no;
        comboObjects[comboCnt++]=agmt_lstm_cd;
        comboObjects[comboCnt++]=chss_pool_cd;
     	for(var k=0;k<comboObjects.length;k++){
     		initCombo(comboObjects[k]);
 	    }
    	
    	t3sheet1_OnLoadFinish(sheetObjects[2]);
    	
    	//setTimeout( function () {
	      	
    	//}, 100);
    }
    
    function t3sheet1_OnLoadFinish(sheetObj) { 
    	var formObj=document.form;
    	ComOpenWait(true);
    	sheetObj.SetWaitImageVisible(0);
 
	     	doActionBtnEnable('L');
	     	
	     	doActionIBSheet(sheetObjects[4], formObj, IBCLEAR);
	        doControlEnable("LOAD");
	      	initControl();
	    	sheetObj.SetWaitImageVisible(1);
	    	ComOpenWait(false);

    	
    }
    /**
     * init control of form <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function initControl(){
    	// Form object
     	formObj=document.form;
        // Form Object reset 
        with(formObj){
        	ComCgmSetObjectValue(eq_knd_cd);
        	ComCgmSetObjectValue(agmt_ofc_cty_cd);
        	ComCgmSetObjectValue(agmt_seq);
        	ComCgmSetObjectValue(agmt_no);
        	ComCgmSetObjectValue(old_agmt_no);
        	ComCgmSetObjectValue(agmt_ver_no);
        	ComCgmSetObjectValue(lst_ver_flg);
        	ComCgmSetObjectValue(agmt_ref_no);
        	ComCgmSetObjectValue(agmt_ctrt_no);
        	ComCgmSetObjectValue(curr_cd);
        	ComCgmSetObjectValue(agmt_dt);
        	ComCgmSetObjectValue(agmt_iss_ofc_cd, ofc_cd.value);
        	ComCgmSetObjectValue(eff_dt);
        	ComCgmSetObjectValue(exp_dt);
        	ComCgmSetObjectValue(agmt_eff_dt);
        	ComCgmSetObjectValue(agmt_exp_dt);
        	ComCgmSetObjectValue(vndr_seq);
        	ComCgmSetObjectValue(vndr_lgl_eng_nm);
        	ComCgmSetObjectValue(pay_term_dys);
        	ComCgmSetObjectValue(dpp_rt_amt,'0');
        	ComCgmSetObjectValue(dpp_cvrg_amt,'0');
        	ComCgmSetObjectValue(lmsm_amt,'0');
        	ComCgmSetObjectValue(onh_hndl_rt_amt,'0');
        	ComCgmSetObjectValue(offh_hndl_rt_amt,'0');
        	ComCgmSetObjectValue(drp_off_lmt_qty,'0');
        	ComCgmSetObjectValue(drp_off_lmt_rto,'0');
        	ComCgmSetObjectValue(mon_dpc_rt_amt,'0');
        	ComCgmSetObjectValue(max_dpc_rt_amt,'0');
        	ComCgmSetObjectValue(init_dpc_rt_amt,'0');
        	diff_rmk.value="";
        	ComCgmSetObjectValue(pre_eff_dt);
        	ComCgmSetObjectValue(pre_exp_dt);
        	ComCgmSetObjectValue(eq_rntl_tp_cd[0]);
        	ComCgmSetObjectValue(dpp_tp_cd[0]);
        	ComCgmSetObjectValue(drp_off_lmt_prd_cd[0]);
        	ComCgmSetObjectValue(drp_off_lmt_tp_cd[0]);
       		dpp_rt_amt.readOnly=false;
			dpp_cvrg_amt.readOnly=false;
			lmsm_amt.readOnly=true;
        }
        // Currency setting
        formObj.curr_cd.value=currCd;
        // Visibility setting
		// Rental Rate Tab  Sheet Objects enable handling
        setTab3SheetEnable(formObj);
		// Fixed Quantity 
		document.getElementById("qtyLayer").style.display="block";
		document.getElementById("rtoLayer").style.display="none";
		// Pool Layer Hidden handling
		var element=document.getElementById("poolLayer");
    	element.style.visibility="hidden";
        // MultiCombo reset
        comboObjects[0].RemoveAll();
  		for(var i=1; i<comboObjects.length; i++){
  			comboObjects[i].SetSelectText("",false);
  		}
  		// Sheet Object reset
  		for(var i=0; i<sheetObjects.length; i++){
  			sheetObjects[i].RemoveAll();
  		}
  		
		sheetObjects[0].DataInsert(-1); // Rental Rate
		InitHeadColumn(t3sheet1_leftHeaders,sheetObjects[0]);
		sheetObjects[3].DataInsert(-1); // Depr. For Casualty Value
		InitHeadColumn(t1sheet1_leftHeaders, sheetObjects[3]);
		
  		// Sheet Object value setting
  		for(var i=0; i < 10; i++ ){
			sheetObjects[0].SetCellValue(1,i+2, 0);
			sheetObjects[3].SetCellValue(1,i+2, 0);
  		}
  		
  		tabObjects[0].SetSelectedIndex(0);
  		
  		
  		//  focus
        formObj.agmt_no.focus();
        
    }
    /**
     * Version Up . <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function doVersionUp(){
    	var index=comboObjects[0].GetItemCount(); 
    	var newAgmtVerNo=index + 1;
    	// version setting
    	
//    	comboObjects[0].InsertItem(index, newAgmtVerNo, newAgmtVerNo);
    	comboObjects[0].InsertItem(index, newAgmtVerNo.toString(), newAgmtVerNo.toString());
    	comboObjects[0].SetSelectText(newAgmtVerNo.toString(),false);
        document.form.pre_eff_dt.value=document.form.eff_dt.value;
        document.form.pre_exp_dt.value=document.form.exp_dt.value;
        document.form.pre_agmt_exp_dt.value=document.form.agmt_exp_dt.value;
        document.form.eff_dt.value="";
        document.form.exp_dt.value=document.form.agmt_exp_dt.value;
        
    }
    /**
     * Action button enable/disable setting. <br>
     * @param  
     * @return 
     * @author 
     * @version 2009.06.09
     */
    function doActionBtnEnable (actionFlag){

    	document.form.action_flag.value=actionFlag;
        switch(actionFlag){
            case "L":
//                btn_Retrieve.className=BTN_ENABLE;
//                btn_New.className=BTN_DISABLE;
//                btn_Save.className=BTN_DISABLE;
//                btn_Delete.className=BTN_DISABLE;
//                btn_VersionUp.className=BTN_DISABLE;
                ComBtnEnable("btn_Retrieve");
                ComBtnEnable("btn_New");
                ComBtnDisable("btn_Save");
                ComBtnDisable("btn_Delete");
                ComBtnDisable("btn_VersionUp");
                break;
            case "N":
//                btnRetrieve.className=BTN_ENABLE;
//                btnNew.className=BTN_DISABLE;
//                btnSave.className=BTN_DISABLE;
//                btnDelete.className=BTN_DISABLE;
//                btnVersionUp.className=BTN_DISABLE;                
                ComBtnEnable("btn_Retrieve");
                ComBtnEnable("btn_New");
                ComBtnEnable("btn_Save");
                ComBtnDisable("btn_Delete");
                ComBtnDisable("btn_VersionUp");
                break;
            case "R":
                var lstVerFlg=document.form.lst_ver_flg.value;
//                btnRetrieve.className=BTN_ENABLE;
//                btnNew.className=BTN_ENABLE;
                ComBtnEnable("btn_Retrieve");
                ComBtnEnable("btn_New");
             
                //20160504 Added by Jun Kato
                //Disable the below 2 buttons after searching
                ComBtnDisable("btn_t2RowAdd");
                ComBtnDisable("btn_t2Delete");
                
                if(lstVerFlg == 'Y'){
//                    btnSave.className=BTN_DISABLE;
//                    btnDelete.className=BTN_ENABLE;
//                    btnVersionUp.className=BTN_ENABLE;
//                    ComBtnDisable("btn_Save");
                    ComBtnEnable("btn_Delete");
                    ComBtnEnable("btn_VersionUp");
                    
                  //20160503 Added by Jun Kato 
                  // Enable Save button, Old Agreement No field and Remark tab
                    ComBtnEnable("btn_Save");
                    ComCgmEnableObject(old_agmt_no, true, 'input1');
                    ComCgmEnableObject(diff_rmk, true);
                    
                } else {
//                    btnSave.className=BTN_DISABLE;
//                    btnDelete.className=BTN_DISABLE;
//                    btnVersionUp.className=BTN_DISABLE;
                    ComBtnDisable("btn_Save");
                    ComBtnDisable("btn_Delete");
                    ComBtnDisable("btn_VersionUp");
                }
                break;
            case "V":
//                btnRetrieve.className=BTN_ENABLE;
//                btnNew.className=BTN_ENABLE;
//                btnSave.className=BTN_ENABLE;
//                btnDelete.className=BTN_DISABLE;
//                btnVersionUp.className=BTN_DISABLE;
                ComBtnEnable("btn_Retrieve");
                ComBtnEnable("btn_New");
                ComBtnEnable("btn_Save");
                ComBtnDisable("btn_Delete");
                ComBtnDisable("btn_VersionUp");
                
                ComBtnEnable("btn_t2RowAdd");
                ComBtnEnable("btn_t2Delete");
                ComBtnEnable("btn_t3RowAdd");
                ComBtnEnable("btn_t3Delete");
            	
                break;
        }
 //       tRoleApply();
    }
    /**
     * Form Control enable/disable setting. <br>
     * @param  {object} formObj	
     * @param  {boolean} bEnable	
     * @return 
     * @author 
     * @version 
     */ 
    function setFormControlEnable(formObj, bEnable){
    	with(formObj){
    		ComCgmEnableObject(agmt_no, 	bEnable);
    		ComCgmEnableObject(curr_cd, false);
    		ComCgmEnableObject(agmt_iss_ofc_cd, false);
    		ComCgmEnableObject(vndr_lgl_eng_nm, false);
    		ComCgmEnableObject(exp_dt, false);
    		if(bEnable){
    			ComCgmEnableObject(agmt_ref_no, bEnable, 'input1');
    			ComCgmEnableObject(agmt_dt, 	bEnable, 'input1');
    			ComCgmEnableObject(eff_dt, 		bEnable, 'input1');
    			ComCgmEnableObject(agmt_eff_dt, bEnable, 'input1');
    			ComCgmEnableObject(agmt_exp_dt, bEnable, 'input1');
    			ComCgmEnableObject(vndr_seq, 	bEnable, 'input1');
    			ComCgmEnableObject(agmt_ctrt_no, bEnable, 'input1');
    			ComCgmEnableObject(old_agmt_no, bEnable, 'input1');
    		} else { 
    		    ComCgmEnableObject(agmt_ref_no, bEnable);
    			ComCgmEnableObject(agmt_dt, 	bEnable);
    			ComCgmEnableObject(eff_dt, 		bEnable);
    			ComCgmEnableObject(agmt_eff_dt, bEnable);
    			ComCgmEnableObject(agmt_exp_dt, bEnable);
    			ComCgmEnableObject(vndr_seq, 	bEnable);
    			ComCgmEnableObject(agmt_ctrt_no, bEnable);
    			ComCgmEnableObject(old_agmt_no, bEnable);
    		}
    		// img button Enable
    		ComCgmEnableObject(btns_Calendar_agmtDt, 	bEnable);
    		ComCgmEnableObject(btns_Calendar_effDt, 	bEnable);
    		ComCgmEnableObject(btns_Calendar_agmt_effDt,bEnable);
    		ComCgmEnableObject(btns_Calendar_agmt_expDt,bEnable);
    		ComCgmEnableObject(btns_agmtno, bEnable);
    		ComCgmEnableObject(btns_vndr, 	bEnable);
    		ComCgmEnableObject(btns_curr_cd,bEnable);
    		ComCgmEnableObject(pay_term_dys,bEnable);
    		// Option Button Enable
    		ComCgmEnableObject(eq_rntl_tp_cd[0],	 bEnable);
    		ComCgmEnableObject(eq_rntl_tp_cd[1],	 bEnable);
    		ComCgmEnableObject(eq_rntl_tp_cd[2],	 bEnable);
    		ComCgmEnableObject(dpp_tp_cd[0], 		 bEnable);
    		ComCgmEnableObject(dpp_tp_cd[1], 		 bEnable);
    		ComCgmEnableObject(drp_off_lmt_prd_cd[0],bEnable);
    		ComCgmEnableObject(drp_off_lmt_prd_cd[1],bEnable);
    		ComCgmEnableObject(drp_off_lmt_tp_cd[0], bEnable);
    		ComCgmEnableObject(drp_off_lmt_tp_cd[1], bEnable);
    		// 기타 Text Box
    		ComCgmEnableObject(dpp_rt_amt, 		bEnable);
    		ComCgmEnableObject(dpp_cvrg_amt, 	bEnable);
    		ComCgmEnableObject(lmsm_amt, 		bEnable);
    		ComCgmEnableObject(onh_hndl_rt_amt, bEnable);
    		ComCgmEnableObject(offh_hndl_rt_amt,bEnable);
    		ComCgmEnableObject(drp_off_lmt_qty, bEnable);
    		ComCgmEnableObject(drp_off_lmt_rto, bEnable);
    		ComCgmEnableObject(mon_dpc_rt_amt, 	bEnable);
    		ComCgmEnableObject(max_dpc_rt_amt, 	bEnable);
    		ComCgmEnableObject(init_dpc_rt_amt, bEnable);
    		if(bEnable){
    			 ComCgmEnableObject(diff_rmk, bEnable);
    		} else {
    			 ComCgmEnableObject(diff_rmk, bEnable);
    		}
    		// MultiCombo Enable
    		comboObjects[1].SetEnable(bEnable);
    		comboObjects[2].SetEnable(bEnable);
    		// IBSheet Enable
    		for(var idx=0; idx < sheetObjects.length; idx++) {
//    		    sheetObjects[idx].SetEnable(bEnable); //-> 시트 전체를 disable 시키면서 탭이동시 잔상이 남게됨(IBSheet 버그로 보임)
    			for(var jdx = 1; jdx <= sheetObjects[idx].RowCount(); jdx++) {
    				for(var kdx = 1; kdx <= sheetObjects[idx].LastCol(); kdx++) { // 최좌측 컬럼은 좌측헤더컬럼(disable 시키면 글자가 사라짐)
    					sheetObjects[idx].SetCellEditable(jdx, kdx, bEnable);
    				}
    			}
    		}
    	}
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {int} sheetNo
     * @return 
     * @author 
     * @version 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
 		var sheetID=sheetObj.id;
 		switch(sheetID) {
	 		case "t3sheet1":
	 		    with(sheetObj){
		 	      var HeadTitle="Type/Size|";
			 	      
        			//making data as list for changing column
        			oldCntrTypeSize = sCntrTypeSize;
        			var arrCntrTypeSize = "";
        			if(oldCntrTypeSize != ""){
        				arrCntrTypeSize = oldCntrTypeSize.split("|");
        			}

        			//handling header title by changing column
    				if (sCntrTypeSize != "") {
    					HeadTitle += "|" + oldCntrTypeSize;
    				}

			 	      var headCount=ComCountHeadTitle(HeadTitle);
			 	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
			 	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			 	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			 	      InitHeaders(headers, info);
			 	      var cols = [ {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 }, 
			 	                   {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];

  					  var sCount = "";
					  var x = 1;
					  
 	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:sCount , KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }
 	 	              
			 	      InitColumns(cols);
			 	      SetEditable(1);
//			 	      InitHeadColumn("title","Fixed Rate");
			 	      InitHeadColumn(t3sheet1_leftHeaders, sheetObj);
 			 	      resizeSheet( sheetObj );
	 				}
	            break;
	            
	       case "t3sheet2":
	    	    with(sheetObj){
			         var HeadTitle="||Number of Units|Number of Units|Number of Units|Number of Units";
	        			//making data as list for changing column
	        			oldCntrTypeSize = sCntrTypeSize;
	        			var arrCntrTypeSize = "";
	        			if(oldCntrTypeSize != ""){
	        				arrCntrTypeSize = oldCntrTypeSize.split("|");
	        			}

	        			//handling header title by changing column
	    				if (sCntrTypeSize != "") {
	    					HeadTitle += "|" + oldCntrTypeSize;
	    				}

			         var headCount=ComCountHeadTitle(HeadTitle);
			         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			         var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			         var headers = [ { Text:HeadTitle, Align:"Center"} ];
			         InitHeaders(headers, info);
			         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_fm_title",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			                {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_fm_tr_val",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_to_title",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			                {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_to_tr_val",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
			         
 					  var sCount = "";
					  var x = 1;
					  
 	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:sCount,  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }
			         
			         InitColumns(cols);
			         SetEditable(1);
			         SetSheetHeight(120);
	               }
	            break;
	            
	       case "t3sheet3":
	    	    with(sheetObj){
			         var HeadTitle="||Used Days|Used Days|Used Days|Used Days";
	        			//making data as list for changing column
	        			oldCntrTypeSize = sCntrTypeSize;
	        			var arrCntrTypeSize = "";
	        			if(oldCntrTypeSize != ""){
	        				arrCntrTypeSize = oldCntrTypeSize.split("|");
	        			}

	        			//handling header title by changing column
	    				if (sCntrTypeSize != "") {
	    					HeadTitle += "|" + oldCntrTypeSize;
	    				}

			         var headCount=ComCountHeadTitle(HeadTitle);
			         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			         var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			         var headers = [ { Text:HeadTitle, Align:"Center"} ];
			         InitHeaders(headers, info);
			         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_fm_title",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			                {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_fm_tr_val",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_to_title",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			                {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rntl_to_tr_val",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
			                
					  var sCount = "";
					  var x = 1;
					  
 	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:sCount,  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }

 	 	             InitColumns(cols);
			         SetEditable(1);
			         SetSheetHeight(120);
	               }
	            break;
	            
            case "t1sheet1":
                with(sheetObj){
		             var HeadTitle="T/S|";
	        			//making data as list for changing column
	        			oldCntrTypeSize = sCntrTypeSize;
	        			var arrCntrTypeSize = "";
	        			if(oldCntrTypeSize != ""){
	        				arrCntrTypeSize = oldCntrTypeSize.split("|");
	        			}

	        			//handling header title by changing column
	    				if (sCntrTypeSize != "") {
	    					HeadTitle += "|" + oldCntrTypeSize;
	    				}
		             
		             var headCount=ComCountHeadTitle(HeadTitle);
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 },
		                 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];
		             
		             
					  var sCount = "";
					  var x = 1;
					  
 	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:sCount,  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }
		             InitColumns(cols);
		             SetEditable(1);
		             InitHeadColumn(t1sheet1_leftHeaders, sheetObj);
		             SetSheetHeight(120);
            		}
                 break;    
                 
            case "t2sheet1":
                with(sheetObj){
		              var HeadTitle1="||Seq.|Registered State|Surcharge Rate";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                     {Type:"Combo",     Hidden:0, Width:250,  Align:"Center",  ColMerge:1,   SaveName:"ste_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rgst_scg_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(120);
		              SetColProperty(0, "rgst_scg_rt_amt", {AcceptKeys:"N"});
                    }
                break;
            case "sheet":	// Hidden Sheet
                with (sheetObj) {
               }
               break;
        }
    }
    /**
     * handling process for Sheet <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01)
     * @return 
     * @author 
     * @version
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      //retrieve
         		formObj.f_cmd.value=SEARCH;
         		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
        	    sheetObj.SetWaitImageVisible(0);
		 	    ComOpenWait(true);
		 	    var sXml=sheetObjects[5].GetSearchData("EES_CGM_1020GS.do" , FormQueryString(formObj), '', true);
         		var arrXml=sXml.split("|$$|");
               	ComOpenWait(false);
               	
         		// Sheet Object Clear
/*         		for(var k=0; k < sheetObjects.length; k++){
         			sheetObjects[k].RemoveAll();
         		}*/
         		// Sheet Object value setting
/*          		for (var i=0; i < 10; i++ ){
					sheetObjects[0].SetCellValue(1,i+2, 0);
					sheetObjects[3].SetCellValue(1,i+2, 0);
          		}
*/         		// Depr. For Casualty Value Tab Sheet Object value setting
         		sheetObjects[3].LoadSearchData(arrXml[0],{Sync:1} );
         		// ETC DATA ->  FORM OBJECT 
         		setEtcDataToForm(formObj, sheetObjects[3]);
         		// data count
         		var dataCount=ComGetTotalRows(arrXml[0]);
         		
         		if(dataCount != null && dataCount > 0){
         			// Rental Rate Tab  sheet status setting (display setting)
         			setTab3SheetEnable(formObj);
         			// Rental Rate Tab   Sheet Object value setting
         			
         			if(sheetObjects[3].GetEtcData("eq_rntl_tp_cd") == 'F'){
         				sheetObjects[0].LoadSearchData(arrXml[2],{Sync:1} );
	         		} else if(sheetObjects[3].GetEtcData("eq_rntl_tp_cd") == 'U'){
	         			sheetObjects[1].LoadSearchData(arrXml[2],{Sync:1} );
	         		} else if(sheetObjects[3].GetEtcData("eq_rntl_tp_cd") == 'D'){
	         			sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
	         		}
         			// Surchage Tab Sheet Object value setting
	         		sheetObjects[4].LoadSearchData(arrXml[1],{Sync:1} );
	         		// Agreement Version MultiCombo setting
//	         		var comboItemCnt=comboObjects[0].getCount();
		         	var cols=ComCgmXml2ComboString(arrXml[3], "agmt_ver_no", "agmt_ver_no");
		         	
		         	ComCgmMakeMultiCombo(comboObjects[0], cols[0], cols[1], 0);
		         	comboObjects[0].SetSelectText(ComCgmNullToBlank(sheetObjects[3].GetEtcData("agmt_ver_no")),false);
		         	
         			formObj.lmsm_amt.value = ComAddComma(formObj.lmsm_amt.value);
         			formObj.dpp_cvrg_amt.value =  ComAddComma(formObj.dpp_cvrg_amt.value);
         			formObj.dpp_rt_amt.value =  ComAddComma(formObj.dpp_rt_amt.value);
         			formObj.onh_hndl_rt_amt.value =  ComAddComma(formObj.onh_hndl_rt_amt.value);
         			formObj.offh_hndl_rt_amt.value =  ComAddComma(formObj.offh_hndl_rt_amt.value);
         			formObj.drp_off_lmt_qty.value =  ComAddComma(formObj.drp_off_lmt_qty.value);
         			formObj.drp_off_lmt_rto.value =  ComAddComma(formObj.drp_off_lmt_rto.value);
         			formObj.mon_dpc_rt_amt.value =  ComAddComma(formObj.mon_dpc_rt_amt.value);
         			formObj.max_dpc_rt_amt.value =  ComAddComma(formObj.max_dpc_rt_amt.value);
         			formObj.init_dpc_rt_amt.value =  ComAddComma(formObj.init_dpc_rt_amt.value);
         			
	         		return true;
         		} else {
         			return false;
         		}
         		
         		break;
         	case IBSAVE:     // saving
         		formObj.f_cmd.value=MULTI;
         		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
         		
         		var sParam="";
	         	var sParam1=sheetObjects[0].GetSaveString(true);
				var sParam2=sheetObjects[1].GetSaveString(true);
				var sParam3=sheetObjects[2].GetSaveString(true);
				var sParam4=sheetObjects[3].GetSaveString(true);
				var sParam5=sheetObjects[4].GetSaveString(true);
				
				sParam1=ComSetPrifix(sParam1, "t3sheet1_");
				sParam2=ComSetPrifix(sParam2, "t3sheet2_");
				sParam3=ComSetPrifix(sParam3, "t3sheet3_");
				sParam4=ComSetPrifix(sParam4, "t1sheet1_");
				sParam5=ComSetPrifix(sParam5, "t2sheet1_");

				sParam=sParam + sParam1 + "&";
				sParam=sParam + sParam2 + "&";
				sParam=sParam + sParam3 + "&";
				sParam=sParam + sParam4 + "&";
				sParam=sParam + sParam5 + "&";
				sParam=sParam + FormQueryString(formObj);
        	    sheetObj.SetWaitImageVisible(0);
        	   
		 	    ComOpenWait(true);
		 	    var sXml=sheetObj.GetSaveData("EES_CGM_1020GS.do", sParam);
         		ComOpenWait(false);
         		
         		if(formObj.action_flag.value == "N"){
         			
         			formObj.agmt_no.value=ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_no"));
         			formObj.agmt_ofc_cty_cd.value=ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_ofc_cty_cd"));
         			formObj.agmt_seq.value=ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_seq"));
         			formObj.lst_ver_flg.value=ComCgmNullToBlank(ComGetEtcData(sXml, "lst_ver_flg"));
         			var agmtVerNo=ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_ver_no"));
         			comboObjects[0].InsertItem(0,agmtVerNo,agmtVerNo);
         			comboObjects[0].SetSelectText(agmtVerNo,false);
         		}
         		
         		sheetObj.LoadSaveData(sXml);
         		break;
         		
         	case IBDELETE:
         		formObj.f_cmd.value=REMOVE;
         		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;
        	    sheetObj.SetWaitImageVisible(0);
		 	    ComOpenWait(true);
		 	    var sXml=sheetObj.GetSaveData("EES_CGM_1020GS.do", FormQueryString(formObj));
		 	    sheetObj.LoadSaveData(sXml);
         		ComOpenWait(false);
         		break;
         		
         	case IBSEARCH_ASYNC01:	// Term Code MultiCombo retrieve
	        	formObj.f_cmd.value=SEARCH;
	        	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		// code type setting ( AGREEMENT LEASE TERM CODE )
	        	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
	    		var sStr=ComGetEtcData(sXml,"comboList");    			
	    		var arrStr=sStr.split("@");
	   			MakeComboObject(agmt_lstm_cd, arrStr, 0, 0);
	        	break;
	        	
         	case IBSEARCH_ASYNC02:	// pool List MultiCombo retrieve
	    		formObj.f_cmd.value=SEARCH02;
	    		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				var cols=ComCgmXml2ComboString(sXml, "code1", "code1");
         	  	ComCgmMakeMultiCombo(comboObjects[2], cols[0], cols[1], 1);
	    		break;	
	    		
         	case IBSEARCH_ASYNC03:	// IBCombo setting
         	 	formObj.f_cmd.value=SEARCH08;
         	 	var xml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
         	  	var cols=ComCgmXml2ComboString(xml, "code1", "code1|desc1", "\t");
         	  	sheetObj.SetColProperty(0, "ste_cd", {ComboText:cols[1], ComboCode:cols[0]} );
         		break;
         		
         	case IBSEARCH_ASYNC04:	// Vendor Code,Name retrieve
	        	formObj.f_cmd.value=SEARCH07;
	        	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
	        	var text=ComCgmNullToBlank(ComGetEtcData(sXml,"text"));
	        	var payCurrCd=ComCgmNullToBlank(ComGetEtcData(sXml,"pay_curr_cd"));
	        	var genPayTermCd=ComCgmNullToBlank(ComGetEtcData(sXml,"gen_pay_term_cd"));
	        	for(var i=0; i<genPayTermCd.length; i++){
	        		if(genPayTermCd.charCodeAt(i) < 48 || genPayTermCd.charCodeAt(i) > 57){
	        			genPayTermCd="0";
	        			break;
	        		}
	        	}
	        	formObj.vndr_lgl_eng_nm.value=text;
	        	if(text ==""){
	        		formObj.vndr_seq.value="";
	        	}
	        	formObj.curr_cd.value=payCurrCd;
	        	formObj.pay_term_dys.value=genPayTermCd;
	        	break;	
	        	
         	case IBSEARCH_ASYNC05:	// Oragnization info retrieve
         		formObj.f_cmd.value=SEARCH09;
         		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
         		formObj.curr_cd.value=ComCgmNullToBlank(ComGetEtcData(sXml, "ar_curr_cd"));	// Currency 
         		currCd=ComCgmNullToBlank(ComGetEtcData(sXml, "ar_curr_cd"));		// Currency saving
         		break;
         		
        	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
	        	formObj.f_cmd.value = SEARCH21;
        		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
				var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
				sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
				
				//getting changing column information from server
				oldCntrTypeSize = sCntrTypeSize;
				
/*				t3sheet1.RenderSheet(0);
				t3sheet1.Reset();
				initSheet(t3sheet1);
				t3sheet1.RenderSheet(1);
				
				t3sheet2.RenderSheet(0);
				t3sheet2.Reset();
				initSheet(t3sheet2);
				t3sheet2.RenderSheet(1);
				
				t3sheet3.RenderSheet(0);
				t3sheet3.Reset();
				initSheet(t3sheet3);
				t3sheet3.RenderSheet(1);
				
				t1sheet1 = t1sheet1.Reset();
				initSheet(t1sheet1);
*/

	     	  	break;
         		
 			case IBINSERT:   // row add
 				if(sheetObj.id == 't3sheet2' || sheetObj.id == 't3sheet3'){
 					var findRow=sheetObj.FindText("rntl_fm_title", "Over")
 					var rowCount = sheetObj.RowCount() - sheetObj.RowCount("D");
 					var newRow;
 					if(findRow == -1 || rowCount == 0){
 		 				newRow=sheetObj.DataInsert();
	 					sheetObj.SetCellValue(newRow, "rntl_fm_title","From",0);
	 					sheetObj.SetCellValue(newRow, "rntl_to_title","To",0);
	 					newRow=sheetObj.DataInsert();
 		 				sheetObj.SetCellValue(newRow, "rntl_fm_title","Over",0);
 		 				sheetObj.SetCellValue(newRow, "rntl_to_title","To",0);
 		 				sheetObj.SetCellValue(newRow, "rntl_to_tr_val","999999",0);
 		 				sheetObj.SetCellEditable(newRow, "rntl_to_tr_val",0);
 					} else {
	 					//sheetObj.SelectRow = findRow - 1;
 						newRow=sheetObj.DataInsert(findRow - 1);
	 					sheetObj.SetCellValue(newRow, "rntl_fm_title","From",0);
	 					sheetObj.SetCellValue(newRow, "rntl_to_title","To",0);
 					}
         		} else if(sheetObj.id == 't2sheet1'){
         			var newRow=sheetObj.DataInsert(-1);
         			sheetObj.SetCellValue(newRow, "ste_cd","",0);
         		}	
               	break;
               	
 			case IBRESET:	 // 
 				if(sheetObj.id == 't3sheet2' || sheetObj.id == 't3sheet3'){
 					var sRow=sheetObj.FindCheckedRow("del_chk");
 					var arrRow=sRow.split("|");
 					for(var i=arrRow.length-1; i>=0; i--){
 						var cellText=sheetObj.GetCellValue(arrRow[i], "rntl_fm_title");
 						if(cellText != "Over"){
 							sheetObj.SetCellValue(arrRow[i], "del_chk",0,0);
 							sheetObj.SetRowHidden(arrRow[i],1);
 							sheetObj.SetRowStatus(arrRow[i],"D");
 						}
 					}
 				} else {
 					ComRowHideDelete(sheetObj, "del_chk");
 				}
 				break;
 				
 			 case IBCLEAR:
     	 		var idx=0
     	 		var sXml2=document.form2.sXml.value;
     	 		var arrXml=sXml2.split("|$$|");
     	        formObj.curr_cd.value=ComGetEtcData(arrXml[0], "ar_curr_cd");	// ComCgmNullToBlank(ComGetEtcData(arrXml[idx], "ar_curr_cd"));	// Currency 
      		    currCd=ComCgmNullToBlank(ComGetEtcData(arrXml[0], "ar_curr_cd"));	
    	 		if ( arrXml[idx] == null ) {return;}
    	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	 	    var arrStr1=new Array();
    	 		for ( var i=0; i < vArrayListData.length; i++) {
    	 		    vListData=vArrayListData[i];
    	 		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
    	 		}
    		  	MakeComboObject(agmt_lstm_cd, arrStr1, 0, 0);     
    	 		idx++;       
    	 		if ( arrXml[idx] == null ) {return;}
    	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	 	    var arrStr1=new Array();
    	 	    var arrStr2=new Array();
    	 		for ( var i=0; i < vArrayListData.length; i++) {
    	 		    vListData=vArrayListData[i];
    	 		    arrStr1[i]=vListData["code1"];
    	 		    //arrStr2[i] = vListData["desc1"]; // 
    	 		}
    		  	MakeComboObject4(comboObjects[2], arrStr1, arrStr1); // 
    	 		idx++;       
    	 		if ( arrXml[idx] == null ) {return;}
    		  	var cols=ComCgmXml2ComboString(arrXml[idx], "code1", "code1|desc1", "\t");
         	  	sheetObj.SetColProperty(0, "ste_cd", {ComboText:cols[1], ComboCode:cols[0]} );
    	 		idx++;       
     	 		break;
        }
    }
 	function MakeComboObject4(cmbObj, arrStr, arrStr2) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0,"","");
		for (var i=1; i < arrStr.length;i++ ) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i, arrStr[i-1], arrStr2[i-1]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
    /**
     * Tab3  Sheet enable/disable setting. <br>
     * @param  {object} formObj
     * @param  {boolean} bEnable
     * @return 
     * @author 
     * @version 2009.06.09
     */ 
    function setTab3SheetEnable(formObj){
    	var objsheets1=document.getElementById("t3sheetLayer1");
    	var objsheets2=document.getElementById("t3sheetLayer2");
    	var objsheets3=document.getElementById("t3sheetLayer3");
  	    var objButton=document.getElementById("t3ButtonLayer");
    	with(formObj){
			if(eq_rntl_tp_cd[0].checked){
				objsheets1.style.display='Inline';
				objsheets2.style.display='none';
				objsheets3.style.display='none';
      			objButton.style.display="none";
			} else if (eq_rntl_tp_cd[1].checked){	
				objsheets1.style.display='none';
				objsheets2.style.display='Inline';
				objsheets3.style.display='none';
      			objButton.style.display="Inline";
			} else if (eq_rntl_tp_cd[2].checked){
				objsheets1.style.display='none';
				objsheets2.style.display='none';
				objsheets3.style.display='Inline';
      			objButton.style.display="Inline";
			}
    	}
    } 
    function doOptionBtnAction(formObj, srcName){
    	with(formObj){
    		switch(srcName){
    			case "dpp_tp_cd":
    				if(dpp_tp_cd[0].checked){
    					dpp_rt_amt.readOnly=false;
    	    			dpp_cvrg_amt.readOnly=false;
    	    			lmsm_amt.readOnly=true;
    	    			lmsm_amt.value="0";	
    	    			dpp_rt_amt.className="input";
    	    			dpp_cvrg_amt.className="input";
    	    			lmsm_amt.className="input2";
    	    		} else if(dpp_tp_cd[1].checked){
    	    			dpp_rt_amt.readOnly=true;
    	    			dpp_cvrg_amt.readOnly=true;
    	    			lmsm_amt.readOnly=false;
    	    			dpp_rt_amt.value="0";
    	    			dpp_cvrg_amt.value="0";
    	    			dpp_rt_amt.className="input2";
    	    			dpp_cvrg_amt.className="input2";
    	    			lmsm_amt.className="input";
    	    		}
    				break;
    			case "drp_off_lmt_tp_cd":
    				var qtyLayer=document.getElementById("qtyLayer");
    				var rtoLayer=document.getElementById("rtoLayer");
    				if(drp_off_lmt_tp_cd[0].checked){
    					qtyLayer.style.display="block";
    					rtoLayer.style.display="none";
    					drp_off_lmt_rto.value="0";
    	    		} else if(drp_off_lmt_tp_cd[1].checked){
    	    			qtyLayer.style.display="none";
    					rtoLayer.style.display="block";
    					drp_off_lmt_qty.value="0";
    	    		}
    				break;
    		}
    	}
    }
    function setEtcDataToForm(formObj, sheetObj){
    	formObj.eq_knd_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("eq_knd_cd"));
    	formObj.agmt_ofc_cty_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ofc_cty_cd"));
  		formObj.agmt_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_seq"));
  		formObj.lst_ver_flg.value=ComCgmNullToBlank(sheetObj.GetEtcData("lst_ver_flg"));
  		formObj.agmt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_no"));
  		formObj.old_agmt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("old_agmt_no"));
  		formObj.agmt_ref_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ref_no"));
  		formObj.curr_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("curr_cd"));
  		formObj.agmt_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_dt"));
  		formObj.agmt_iss_ofc_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_iss_ofc_cd"));
  		formObj.eff_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("eff_dt"));
  		formObj.exp_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("exp_dt"));
  		formObj.agmt_eff_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_eff_dt"));
  		formObj.agmt_exp_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_exp_dt"));
  		formObj.vndr_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_seq"));
  		formObj.vndr_lgl_eng_nm.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_lgl_eng_nm"));
  		formObj.dpp_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("dpp_rt_amt"));
  		formObj.dpp_cvrg_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("dpp_cvrg_amt"));
  		formObj.lmsm_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("lmsm_amt"));
  		formObj.onh_hndl_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("onh_hndl_rt_amt"));
  		formObj.offh_hndl_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("offh_hndl_rt_amt"));
  		formObj.pay_term_dys.value=ComCgmNullToBlank(sheetObj.GetEtcData("pay_term_dys"));
  		formObj.drp_off_lmt_qty.value=ComCgmNullToZero(sheetObj.GetEtcData("drp_off_lmt_qty"));
  		formObj.drp_off_lmt_rto.value=ComCgmNullToZero(sheetObj.GetEtcData("drp_off_lmt_rto"));
  		formObj.mon_dpc_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("mon_dpc_rt_amt"));
  		formObj.max_dpc_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("max_dpc_rt_amt"));
  		formObj.init_dpc_rt_amt.value=ComCgmNullToZero(sheetObj.GetEtcData("init_dpc_rt_amt"));
  		formObj.diff_rmk.value=ComCgmNullToBlank(sheetObj.GetEtcData("diff_rmk"));
  		formObj.agmt_ctrt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ctrt_no"));
  		comboObjects[0].SetSelectText(ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ver_no")),false);
  		comboObjects[1].SetSelectText(ComCgmNullToBlank(sheetObj.GetEtcData("agmt_lstm_cd")),false);
  		comboObjects[2].SetSelectText(ComCgmNullToBlank(sheetObj.GetEtcData("chss_pool_cd")),false);
  		if(sheetObj.GetEtcData("eq_rntl_tp_cd") == 'F'){
  			formObj.eq_rntl_tp_cd[0].checked=true;
  		} else if(sheetObj.GetEtcData("eq_rntl_tp_cd") == 'U'){
  			formObj.eq_rntl_tp_cd[1].checked=true;
  		} else if(sheetObj.GetEtcData("eq_rntl_tp_cd") == 'D'){
  			formObj.eq_rntl_tp_cd[2].checked=true;
  		}
    	if(sheetObj.GetEtcData("dpp_tp_cd") == 'G'){
    		formObj.dpp_tp_cd[0].checked=true;
  		} else if(sheetObj.GetEtcData("dpp_tp_cd") == 'L'){
  			formObj.dpp_tp_cd[1].checked=true;
  		}	
  		if(sheetObj.GetEtcData("drp_off_lmt_prd_cd") == 'M'){
  			formObj.drp_off_lmt_prd_cd[0].checked=true;
  		} else if(sheetObj.GetEtcData("drp_off_lmt_prd_cd") == 'Y'){
  			formObj.drp_off_lmt_prd_cd[1].checked=true;
  		}	
  		if(sheetObj.GetEtcData("drp_off_lmt_tp_cd") == 'F'){
  			formObj.drp_off_lmt_tp_cd[0].checked=true;
  		} else if(sheetObj.GetEtcData("drp_off_lmt_tp_cd") == 'R'){
  			formObj.drp_off_lmt_tp_cd[1].checked=true;
  		}
  		var element=document.getElementById("poolLayer");
  		if(comboObjects[1].GetSelectText()== "CP"){
  			element.style.visibility="visible";
  		} else {
  			element.style.visibility="hidden";
  		}
  		doOptionBtnAction(formObj,"drp_off_lmt_tp_cd");
     }
    /**
     * IBTab Object
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "Rental Rate" , "");
					InsertItem( "Depr. For Casualty Value" , "");
					InsertItem( "Surcharge" , "");
					InsertItem( "Remark(s)" , "");
                }
                break;
        }
        tabObj.SetSelectedIndex(0);
    }
    /**
    * Event when clicking Tab
     */
    function tab1_OnChange(tabObj , nItem)
    {
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
    }
    /** 
     * Combo Object reset  <br>
     * @param  {object} comboObj	Combo Object
     * @return 
     * @author 
     * @version 
     */ 
    function initCombo(comboObj) {
    	switch(comboObj.options.id) {
	    	case "agmt_ver_no":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code="";
	  	            Text="";
	  	            SetDropHeight(100);
	  	            SetMultiSelect(0);
	  	            SetMaxSelect(1);
	  	            SetEnable(1);
	  	        }
	  	        break;
    	 	case "agmt_lstm_cd":
    	 		var cnt=0;
     	        with(comboObj) {
     	        	Code="";
     	            Text="";
     	            SetDropHeight(100);
     	            SetMultiSelect(0);
     	            SetMaxSelect(1);
     	            SetEnable(1);
     	            comboObj.SetUseAutoComplete(1);
     	        }
     	        break;
    	}
    }  
    function validateForm(sheetObj,formObj,sAction){
        var formObj = document.form;
    	switch(sAction){
        	 	case IBSEARCH:	// retrieve
        	 		if(formObj.agmt_no.value == ''){
        	 			ComShowCodeMessage('CGM10004','Agreement No.');
        	 			formObj.agmt_no.focus();
        	 			return false;
                    } else {
                    	return true;
                    }
        	 		break;
        	 		
        	 	case IBSAVE:	// saving
        	 		var agmt_lstm_cd=comboObjects[1];
        	 		var chss_pool_cd=comboObjects[2];
//        	 		var sheet;
        	 		
        	 		// Form inserting check
//        	 		alert("V1 : " + agmt_ref_no.value);
//        	 		alert("V8 : " + comboObjects[1].GetSelectText()); // agmt_lstm_cd
//        	 		alert("V9 : " + comboObjects[2].GetSelectText()); // chss_pool_cd
        	 		
        	 		if(formObj.agmt_ref_no.value == ''){
        	 			ComShowCodeMessage('CGM10004','Ref. No.');
        	 			formObj.agmt_ref_no.focus();
        	 			return false;
        	 		} else if(formObj.agmt_dt.value == ''){
        	 			ComShowCodeMessage('CGM10004','Agreement Date');
        	 			formObj.agmt_dt.focus();
        	 			return false;
        	 		} else if(formObj.agmt_eff_dt.value == ''){
        	 			ComShowCodeMessage('CGM10004','Agreement Eff. From Date');
        	 			formObj.agmt_eff_dt.focus();
        	 			return false;
        	 		} else if(formObj.agmt_exp_dt.value == ''){
        	 			ComShowCodeMessage('CGM10004','Agreement Eff. To Date');
        	 			formObj.agmt_exp_dt.focus();
        	 			return false;	
        	 		} else if(formObj.eff_dt.value == ''){
        	 			ComShowCodeMessage('CGM10004','Rate Eff. From Date');
        	 			formObj.eff_dt.focus();
        	 			return false;
        	 		} else if(formObj.exp_dt.value == ''){
        	 			ComShowCodeMessage('CGM10004','Rate Eff. To Date');
        	 			formObj.exp_dt.focus();
        	 			return false;
        	 		} else if(formObj.vndr_seq.value == ''){
        	 			ComShowCodeMessage('CGM10004','Lessor');
        	 			formObj.vndr_seq.focus();
        	 			return false;
        	 		} else if(formObj.old_agmt_no.value == ''){
        	 			ComShowCodeMessage('CGM10004','Old AGMT No.');
        	 			formObj.old_agmt_no.focus();
        	 			return false;
        	 		} else if(comboObjects[1].GetSelectText() == ''){ // agmt_lstm_cd 
        	 			ComShowCodeMessage('CGM10004','Lease Term');
        	 			agmt_lstm_cd.focus();
        	 			return false;
        	 		} else if(comboObjects[1].GetSelectText() == 'CP' && comboObjects[2].GetSelectText() == ''){ // agmt_lstm_cd & chss_pool_cd
        	 			ComShowCodeMessage('CGM10004','Pool');
        	 			chss_pool_cd.focus();
        	 			return false;
        	 		} else if((formObj.pay_term_dys.value == '')||(formObj.pay_term_dys.value == 0)) {
        	 			ComShowCodeMessage('CGM10004','Payment Term');
        	 			formObj.pay_term_dys.focus();
        	 			return false;
        	 		} else if(formObj.agmt_ctrt_no.value == ''){
        	 			ComShowCodeMessage('CGM10004','Contract No.');
        	 			formObj.agmt_ctrt_no.focus();
        	 			return false;
        	 		}
        	 		var effDt=ComReplaceStr(formObj.eff_dt.value,"-","");
         			var expDt=ComReplaceStr(formObj.exp_dt.value,"-","");
         			var agmtEffDt=ComReplaceStr(formObj.agmt_eff_dt.value,"-","");
         			var agmtExpDt=ComReplaceStr(formObj.agmt_exp_dt.value,"-","");
         			
         			formObj.lmsm_amt.value = ComReplaceStr(formObj.lmsm_amt.value,",","");
         			formObj.dpp_cvrg_amt.value =  ComReplaceStr(formObj.dpp_cvrg_amt.value,",","");
         			formObj.dpp_rt_amt.value =  ComReplaceStr(formObj.dpp_rt_amt.value,",","");
         			formObj.onh_hndl_rt_amt.value =  ComReplaceStr(formObj.onh_hndl_rt_amt.value,",","");
         			formObj.offh_hndl_rt_amt.value =  ComReplaceStr(formObj.offh_hndl_rt_amt.value,",","");
         			formObj.drp_off_lmt_qty.value =  ComReplaceStr(formObj.drp_off_lmt_qty.value,",","");
         			formObj.drp_off_lmt_rto.value =  ComReplaceStr(formObj.drp_off_lmt_rto.value,",","");
         			formObj.mon_dpc_rt_amt.value =  ComReplaceStr(formObj.mon_dpc_rt_amt.value,",","");
         			formObj.max_dpc_rt_amt.value =  ComReplaceStr(formObj.max_dpc_rt_amt.value,",","");
         			formObj.init_dpc_rt_amt.value =  ComReplaceStr(formObj.init_dpc_rt_amt.value,",","");
         			
         			if(formObj.agmt_no.value == 'NEW'){
	         			if(effDt != agmtEffDt){
	         				ComShowCodeMessage('CGM10074');
	         				formObj.eff_dt.focus();
	         				return false
	         			}
         			}
        	 		if(formObj.eq_rntl_tp_cd[0].checked){
        	 			var strRate="";
        	 			for(var i=0; i < 10; i++){
        	 				strRate=strRate + sheetObj.GetCellValue(1, i+2);
        	 			}
        	 			if(Number(strRate) == 0){
        	 				ComShowCodeMessage('CGM10004','Fixed Rate');
        	 				tabObjects[0].SetSelectedIndex(0);
//        	 				sheetObjects[0].focus();
        	 				sheetObjects[0].SelectCell(1, "eq_tpsz_cd_sf2", true);
        	 				return false;
        	 			}
        	 		} else if(formObj.eq_rntl_tp_cd[1].checked){	    	 			
	        	 		if(sheetObjects[1].RowCount()== 0){
	        	 			ComShowCodeMessage('CGM10004','Tier Rate');
	        	 			tabObjects[0].SetSelectedIndex(0);
	        	 			return false;
	        	 		} else {
		        	 		for(var i=1; i <= sheetObjects[1].RowCount(); i++){
		        	 			if(sheetObjects[1].GetCellValue(i, "rntl_fm_tr_val") == ''){
		        	 				ComShowCodeMessage('CGM10004','Tier Rate');
		        	 				tabObjects[0].SetSelectedIndex(0);
//		        	 				sheetObjects[1].focus();
		        	 				sheetObjects[1].SelectCell(i, "rntl_fm_tr_val", true);
		        	 				return false;
		        	 			} else if(sheetObjects[1].GetCellValue(i, "rntl_to_tr_val") == ''){
		        	 				if(sheetObjects[1].GetCellValue(i, "rntl_fm_title") != 'Over'){
			        	 				ComShowCodeMessage('CGM10004','Tier Rate');
			        	 				tabObjects[0].SetSelectedIndex(0);
//			        	 				sheetObjects[1].focus();
			        	 				sheetObjects[1].SelectCell(i, "rntl_to_tr_val", true);
			        	 				return false;
		        	 				}
		        	 			}
		        	 		}	
	        	 		}
	        	 		if(sheetObjects[1].RowCount()> 1){
	        	 			for(var k=1; k <= sheetObjects[1].RowCount()- 1; k++){
	        	 				if(sheetObjects[1].GetCellValue(k, "rntl_to_tr_val") != sheetObjects[1].GetCellValue(k+1, "rntl_fm_tr_val")-1){
	    	 						ComShowCodeMessage('CGM10009','From Number');
	    	 						tabObjects[0].SetSelectedIndex(0);
//	    	 						sheetObjects[1].focus();
		        	 				sheetObjects[1].SelectCell(k+1, "rntl_fm_tr_val", true);
	    	 						return false;
	    	 					}
	    	 				}
	        	 		}
        	 		} else if(formObj.eq_rntl_tp_cd[2].checked){		
	        	 		if(sheetObjects[2].RowCount()== 0){
	        	 			ComShowCodeMessage('CGM10004','Tier Rate');
	        	 			tabObjects[0].SetSelectedIndex(0);
	        	 			return false;
	        	 		} else {
		        	 		for(var i=1; i <= sheetObjects[2].RowCount(); i++){
		        	 			if(sheetObjects[2].GetCellValue(i, "rntl_fm_tr_val") == ''){
		        	 				ComShowCodeMessage('CGM10004','Tier Rate');
		        	 				tabObjects[0].SetSelectedIndex(0);
//		        	 				sheetObjects[2].focus();
		        	 				sheetObjects[2].SelectCell(i, "rntl_fm_tr_val", true);
		        	 				return false;
		        	 			} else if(sheetObjects[2].GetCellValue(i, "rntl_to_tr_val") == ''){
		        	 				if(sheetObjects[2].GetCellValue(i, "rntl_fm_title") != 'Over'){
			        	 				ComShowCodeMessage('CGM10004','Tier Rate');
			        	 				tabObjects[0].SetSelectedIndex(0);
//			        	 				sheetObjects[2].focus();
			        	 				sheetObjects[2].SelectCell(i, "rntl_to_tr_val", true);
			        	 				return false;
		        	 				}
		        	 			}
		        	 		}	
	        	 		}
	        	 		if(sheetObjects[1].RowCount()> 1){
	        	 			for(var k=1; k <= sheetObjects[1].RowCount()- 1; k++){
	        	 				if(sheetObjects[1].GetCellValue(k, "rntl_to_tr_val") != sheetObjects[1].GetCellValue(k+1, "rntl_fm_tr_val") - 1){
	    	 						ComShowCodeMessage('CGM10009','From Number');
	    	 						tabObjects[0].SetSelectedIndex(0);
//	    	 						sheetObjects[1].focus();
		        	 				sheetObjects[1].SelectCell(k+1, "rntl_fm_tr_val", true);
	    	 						return false;
	    	 					}
	    	 				}
	        	 		}
	        	 	}
        	 		return true;
        	 		break;
        	 		
        	 	case IBDELETE:	// deleting
        	 		if(formObj.agmt_no.value == ''){
        	 			ComShowCodeMessage('CGM10004','Agreement No.');
        	 			formObj.agmt_no.focus();
        	 			return false;
        	 		} else if(formObj.agmt_ver_no.value == ''){
        	 			ComShowCodeMessage('CGM10004','Version');
        	 			formObj.agmt_ver_no.focus();
        	 			return false;
        	 		} else {
        	 			return true;
        	 		}
        	 		break;
        	}    
    }
//    function obj_keypress(){
//     	obj=ComGetEvent();
//     	if(obj.dataformat == null) return;
//     	window.defaultStatus=obj.dataformat;
//     	var specChar='33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|'
//     	specChar=specChar + '58|59|60|61|62|63|64|91|92|93|94|95|123|124|125|126';
//     	switch(obj.dataformat) {
//     	 	case "ym": case "ymd":
//     	 		ComKeyOnlyNumber(obj);
//     	 		break;
//     	 	case "int":
//     	    	ComKeyOnlyNumber(obj);
//     	        break;
//     	 	case "float":
//	            ComKeyOnlyNumber(obj, "-.");
//	            break;    
//     	    case "eng":
//     	        ComKeyOnlyAlphabet(); 
//     	        break;
//     	    case "engup":
//     	        if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum');
//     	        else if(obj.name=="agmt_no") ComKeyOnlyAlphabet('uppernum');
//     	        else if(obj.name=="agmt_ref_no") ComKeyOnlyAlphabet('uppernum',specChar);
//     	        else ComKeyOnlyAlphabet('upper');
//     	        break;
//     	    case "engdn":
//     	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
//     	        else ComKeyOnlyAlphabet('lower');
//     	        break;
//     	}
//    }
    function obj_keydown(){
    	obj=ComGetEvent();
    	switch(ComGetEvent("name")){
    		case 'agmt_no':
    			var keyValue=null;
            	if(event == undefined || event == null) {
            		keyValue=13;
            	} else {
            		keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    			}
    			if(keyValue != 13) return;
    			var agmtNo=formObj.agmt_no.value;
    	 		var result=true;
    	 		if(agmtNo != "" && agmtNo != "NEW"){
    	 			if(agmtNo.length <= 3){
	    	 			result=false;
	    	 		} else {
	    	 			if(ComIsNumber(agmtNo.substring(3))==false){
	    	 				result=false;
	    	 			}
	    	 		}
    	 		} else {
    	 			result=true;
    	 		}
    	 		if(!result){
    	 			ComShowCodeMessage('CGM10004','Agreement No.');
    	 			formObj.agmt_no.value="";
    	 			ComSetFocus(formObj.agmt_no);
    	 		} else {
    	 			ComKeyEnter();
    	 		}
    			break;
    	}
    }
    /** 
     * Object activate event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */
    function obj_focusIn(){
     	ComClearSeparator(ComGetEvent());
    }
    /** 
     * Object deactivate event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version
     */
    function obj_onBlur(){
     	var formObj=document.form;
     	obj=ComGetEvent();      	
     	with(formObj){
     		if(obj.name=='agmt_dt' || obj.name=="eff_dt" || obj.name=="exp_dt" || obj.name=="agmt_eff_dt" || obj.name=="agmt_exp_dt"){
     			var agmtDt			= ComReplaceStr(agmt_dt.value,"-","");
     			var effDt			= ComReplaceStr(eff_dt.value,"-","");
     			var expDt			= ComReplaceStr(exp_dt.value,"-","");
     			var preEffDt		= ComReplaceStr(pre_eff_dt.value,"-","");
     			var preExpDt		= ComReplaceStr(pre_exp_dt.value,"-","");
     			var agmtEffDt		= ComReplaceStr(agmt_eff_dt.value,"-","");
     			var agmtExpDt		= ComReplaceStr(agmt_exp_dt.value,"-","");
     		    var preAgmtExpDt	= ComReplaceStr(pre_agmt_exp_dt.value,"-","");
     			switch(ComGetEvent("name")) {
     				
     				case "agmt_dt":	// Agreement Date
						if(!ComIsEmpty(agmtDt)){
							if(ComChkObjValid(agmt_dt)) {
								obj.value = ComGetMaskedValue(obj, 'ymd', '-');
							}else {
								agmt_dt.value='';
								agmt_dt.focus();
								break;
							}
						}
						
						break;
     				case "eff_dt":	// Agreement From Date
 	    	    		if(effDt != '' && expDt != ''){
 	    	    			if(effDt > expDt){
 	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
 	    	    				eff_dt.value='';
 	    	    				eff_dt.focus();
 	    	    				break;
 	    	    			}
 	    	    		}
// 	    	    		if(effDt != "" && preExpDt != ""){
 	    	    		if(effDt != '' && preExpDt != ''){
 	    	    		//	var nextEffDt=ComReplaceStr(ComGetDateAdd(pre_exp_dt.value,"D","1"),"-","");

 	    	    			if(effDt <= preExpDt && effDt <= preEffDt){
 	    	    				ComShowCodeMessage('COM12133','From date', pre_eff_dt.value,'greater');
	    	    				eff_dt.value='';
	 	    	    			eff_dt.focus();
 	    	    			} else if(effDt > preExpDt){
 	    	    				ComShowCodeMessage('COM12133','From date', pre_exp_dt.value,'greater');
 	    	    				
 	    	    				eff_dt.value=preExpDt;
	 	    	    			exp_dt.focus();
 	    	    			}
 	    	    		}
 	    	    		obj.value = ComGetMaskedValue(obj, 'ymd', '-');
 	    	    		
 	    	            break;
 	    	    	case "exp_dt":	// Agreement To Date
 	    	    		if(effDt != '' && expDt != ''){
 	    	    			if(effDt > expDt){
 	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
 	    	    				exp_dt.value='';
 	    	    				exp_dt.focus();
 	    	    				break;
 	    	    			}
 	    	    		}
 	    	    		obj.value = ComGetMaskedValue(obj, 'ymd', '-');
 	    	    		
 	    	           	break;	
 	    	    	case "agmt_eff_dt":
 	    	    		if(agmtEffDt != '' && agmtExpDt != ''){
 	    	    			if(agmtEffDt > agmtExpDt){
 	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
 	    	    				agmt_eff_dt.value='';
 	    	    				agmt_eff_dt.focus();
 	    	    			}
 	    	    		}
 	    	    		obj.value = ComGetMaskedValue(obj, 'ymd', '-');
 	    	    		
 	    	    		break;
 	    	    	case "agmt_exp_dt":
 	    	    		if(agmtEffDt != '' && agmtExpDt != ''){
 	    	    			if(agmtEffDt > agmtExpDt){
 	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
 	    	    				agmt_exp_dt.value='';
 	    	    				agmt_exp_dt.focus();
 	    	    				break;
 	    	    			}
 	    	    		}
 	    	    		if(preAgmtExpDt!= '' && agmtExpDt != ''){
 	    	    			if(preAgmtExpDt > agmtExpDt){
 	    	    				ComShowCodeMessage('COM12133','Agreement Exp. Date', pre_agmt_exp_dt.value,'greater');
 	    	    				agmt_exp_dt.value=pre_agmt_exp_dt.value;
 	    	    				agmt_exp_dt.focus();
 	    	    				break;
 	    	    			}
 	    	    		}
 	    	    		if(agmt_exp_dt.value != ''){
 	    	    			if(agmt_exp_dt.value.indexOf("-") > -1){
 	    	    				exp_dt.value=agmt_exp_dt.value.substring(0,4) + '-' + agmt_exp_dt.value.substring(5,7) + '-' + agmt_exp_dt.value.substring(8,10);
 	    	    			}else{
 	    	    				exp_dt.value=agmt_exp_dt.value.substring(0,4) + '-' + agmt_exp_dt.value.substring(4,6) + '-' + agmt_exp_dt.value.substring(6,8);
 	    	    			}
 	    	    		} else {
 	    	    			exp_dt.value='';
 	    	    		}
 	    	    		obj.value = ComGetMaskedValue(obj, 'ymd', '-');
 	    	    		
 	    	    		break;
 	        	}
     			ComChkObjValid(ComGetEvent());
     		}
        }     
    } 
    /** 
     * Object change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */  
    function obj_change(){ 	 
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	obj=ComGetEvent();
    	switch(ComGetEvent("name")){
    	 	case "agmt_no":
    	 		var agmtNo=formObj.agmt_no.value;
    	 		var result=true;
    	 		if(agmtNo != "" && agmtNo != "NEW"){
    	 			if(agmtNo.length <= 3){
	    	 			result=false;
	    	 		} else {
	    	 			if(ComIsNumber(agmtNo.substring(3))==false){
	    	 				result=false;
	    	 			}
	    	 		}
    	 		} else {
    	 			result=true;
    	 		}
    	 		if(!result){
    	 			ComShowCodeMessage('CGM10004','Agreement No.');
    	 			formObj.agmt_no.value="";
    	 			ComSetFocus(formObj.agmt_no);
    	 		}
    	 		// button enable/disable
    	 		if(formObj.action_flag.value == "N"){
    	 			if(agmtNo != "NEW"){
    	 				doActionBtnEnable('L');
    	 			}
    	 		}
    	 		break;
    	 	case "vndr_seq":
    	 		var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
    	 		if(vndrSeq != ''){
    	 			// Lessor 
	    	 		doActionIBSheet(sheetObjects[5], formObj, IBSEARCH_ASYNC04);
    	 		} else {
    	 			formObj.vndr_lgl_eng_nm.value="";
    	 			formObj.pay_term_dys.value="";
    	 		}
    	 		break;
    	 	case "pay_term_dys":
    	 		if(formObj.pay_term_dys.value !=''){
    	 			formObj.pay_term_dys.value=Math.abs(formObj.pay_term_dys.value)
    	 		}
    	 		break;
    	}
    }
    function agmt_lstm_cd_OnChange(Index_Code, Text){
    	var element=document.getElementById("poolLayer");
    	comboObjects[2].SetSelectText("",false);
    	if(agmt_lstm_cd.GetSelectCode()=='CP'){
    		element.style.visibility="visible";
    	} else {
    		element.style.visibility="hidden";
    	}
    }
    
    function t3sheet1_OnSearchEnd(sheetObj , code , msg){
    	if( sheetObj.RowCount() < 1) {
    		InitHeadColumn(t3sheet1_leftHeaders,sheetObj);
    	}else {
    		InitHeadText(t3sheet1_leftHeaders,sheetObj);
    	}
	}
    
    function t1sheet1_OnSearchEnd(sheetObj , code , msg){
    	if( sheetObj.RowCount() < 1) {
    		InitHeadColumn(t1sheet1_leftHeaders,sheetObj);
    	}else {
    		InitHeadText(t1sheet1_leftHeaders,sheetObj);
    	}
    	
	}
    
    function t3sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	for(var i=1; i<= sheetObj.RowCount(); i++){
    		if(i < sheetObj.RowCount()){
    			sheetObj.SetCellValue(i, "rntl_fm_title","From",0);
    			sheetObj.SetCellValue(i, "rntl_to_title","To",0);
    		} else {
    			sheetObj.SetCellValue(i, "rntl_fm_title","Over",0);
    			sheetObj.SetCellValue(i, "rntl_to_title","To",0);
    			sheetObj.SetCellEditable(i, "rntl_to_tr_val",0);
    		}
    		sheetObj.SetCellEditable(i, "rntl_fm_title",0);
			sheetObj.SetCellEditable(i, "rntl_to_title",0);
     	}
    	ComBtnDisable("btn_t2RowAdd");
    	ComBtnDisable("btn_t2Delete");
    	ComBtnDisable("btn_t3RowAdd");
    	ComBtnDisable("btn_t3Delete");
    }
    function t3sheet3_OnSearchEnd(sheetObj, ErrMsg){
    	for(var i=1; i<= sheetObj.RowCount(); i++){
    		if(i < sheetObj.RowCount()){
    			sheetObj.SetCellValue(i, "rntl_fm_title","From",0);
    			sheetObj.SetCellValue(i, "rntl_to_title","To",0);
    		} else {
    			sheetObj.SetCellValue(i, "rntl_fm_title","Over",0);
    			sheetObj.SetCellValue(i, "rntl_to_title","To",0);
    			sheetObj.SetCellEditable(i, "rntl_to_tr_val",0);
    		}
    		sheetObj.SetCellEditable(i, "rntl_fm_title",0);
			sheetObj.SetCellEditable(i, "rntl_to_title",0);
     	}
    	ComBtnDisable("btn_t2RowAdd");
    	ComBtnDisable("btn_t2Delete");
    	ComBtnDisable("btn_t3RowAdd");
    	ComBtnDisable("btn_t3Delete");
    }
    function t2sheet1_OnChange(sheetObj, Row, Col){ 
    	var targetCol=sheetObj.SaveNameCol("ste_cd");
    	if(Col == targetCol){
    		var cellText=sheetObj.GetCellValue(Row, Col);
    		if(cellText != ''){
    			var rtn=sheetObj.ColValueDup("ste_cd");
    			if(rtn != -1){
    				ComShowCodeMessage('CGM10017','State Code');
    				// focus to grid
    				sheetObj.SetCellValue(Row, Col , "");
//    				sheetObj.focus();
 	 				sheetObj.SelectCell(Row, Col, true);
    			}
    		}
    	}
    }
    function t3sheet2_OnChange(sheetObj, Row, Col){
    	var GetCellValue=sheetObj.GetCellValue(Row, Col);
    	var colSaveName=sheetObj.ColSaveName(Col);
    	var currRow=Row;
    	var fmValue=sheetObj.GetCellValue(currRow, "rntl_fm_tr_val");
    	var toValue=sheetObj.GetCellValue(currRow, "rntl_to_tr_val");
    	switch(colSaveName){
    	 	case "rntl_fm_tr_val":
    	 		var toValue=sheetObj.GetCellValue(currRow, "rntl_to_tr_val");
    	 		if(Number(GetCellValue) >= 999999){
	 				ComShowCodeMessage('CGM10019','Number 999,999');
	 				// focus to grid
	 				sheetObj.SetCellValue(currRow, Col, "");
//	 				sheetObj.focus();
   	 			 	sheetObj.SelectCell(currRow, Col, true);
   	 			 	break;
	 			}
    	 		if(fmValue != '' && toValue != ''){
	    	 		if(Number(fmValue) > Number(toValue)){
	    	 			ComShowCodeMessage('COM12133','To','From','greater');
		 				// focus to grid
	    	 			sheetObj.SetCellValue(currRow, Col, "");
//		 				sheetObj.focus();
	   	 			 	sheetObj.SelectCell(currRow, Col, true);
	   	 			 	break;
	    	 		}
    	 		}
    	 		if(currRow > 1) {
    	 			var preToValue=sheetObj.GetCellValue(currRow-1, "rntl_to_tr_val");
    	 			if(GetCellValue!=""){
    	 				if(preToValue != "" && Number(GetCellValue) != Number(preToValue) + 1 ){
	    	 				ComShowCodeMessage('CGM10009','From Number');
	    	 				// focus to grid
	    	 				sheetObj.SetCellValue(currRow, Col, "");
//	    	 				sheetObj.focus();
	       	 			 	sheetObj.SelectCell(currRow, Col, true);
	       	 			 	break;	
	    	 			} 
    	 			}
    	 		}
    	 		break;
    	 	case "rntl_to_tr_val":
    	 		if(Number(GetCellValue) >= 999999){
	 				ComShowCodeMessage('CGM10019','Number 999,999');
	 				// focus to grid
	 				sheetObj.SetCellValue(currRow, Col, "");
//	 				sheetObj.focus();
   	 			 	sheetObj.SelectCell(currRow, Col, true);
   	 			 	break;
	 			}
    		 	if(fmValue != '' && toValue != ''){
	    	 		if(Number(fmValue) > Number(toValue)){
	    	 			ComShowCodeMessage('COM12133','To','From','greater');
		 				// focus to grid
	    	 			sheetObj.SetCellValue(currRow, Col, "");
//		 				sheetObj.focus();
	   	 			 	sheetObj.SelectCell(currRow, Col, true);
	    	 		}
    	 		}
    	 		break;
    	}    	 
    }
    function t3sheet3_OnChange(sheetObj, Row, Col){
    	var GetCellValue=sheetObj.GetCellValue(Row, Col);
     	var colSaveName=sheetObj.ColSaveName(Col);
     	var currRow=Row;
     	var fmValue=sheetObj.GetCellValue(currRow, "rntl_fm_tr_val");
     	var toValue=sheetObj.GetCellValue(currRow, "rntl_to_tr_val");
     	switch(colSaveName){
     	 	case "rntl_fm_tr_val":
     	 		var toValue=sheetObj.GetCellValue(currRow, "rntl_to_tr_val");
     	 		if(Number(GetCellValue) >= 999999){
 	 				ComShowCodeMessage('CGM10019','Number 999,999');
 	 				// focus to grid
 	 				sheetObj.SetCellValue(currRow, Col, "");
// 	 				sheetObj.focus();
    	 			sheetObj.SelectCell(currRow, Col, true);
    	 			break;
 	 			}
     	 		if(fmValue != '' && toValue != ''){
 	    	 		if(Number(fmValue) > Number(toValue)){
 	    	 			ComShowCodeMessage('COM12133','To','From','greater');
 		 				// focus to grid
 	    	 			sheetObj.SetCellValue(currRow, Col, "");
// 		 				sheetObj.focus();
 	   	 			 	sheetObj.SelectCell(currRow, Col, true);
 	    	 		}
     	 		}
     	 		if(currRow > 1) {
     	 			var preToValue=sheetObj.GetCellValue(currRow-1, "rntl_to_tr_val");
     	 			if(GetCellValue!=""){
     	 				if(preToValue != "" && Number(GetCellValue) != Number(preToValue) + 1 ){
 	    	 				ComShowCodeMessage('CGM10009','From Number');
 	    	 				// focus to grid
 	    	 				sheetObj.SetCellValue(currRow, Col, "");
 	    	 			//	sheetObj.focus();
 	       	 			 	sheetObj.SelectCell(currRow, Col, true);
 	       	 			 	break;	
 	    	 			} 
     	 			}
     	 		}
     	 		break;
     	 	case "rntl_to_tr_val":
     	 		if(Number(GetCellValue) >= 999999){
 	 				ComShowCodeMessage('CGM10019','Number 999,999');
 	 				// focus to grid
 	 				sheetObj.SetCellValue(currRow, Col, "");
// 	 				sheetObj.focus();
    	 			sheetObj.SelectCell(currRow, Col, true);
    	 			break;
 	 			}
     		 	if(fmValue != '' && toValue != ''){
 	    	 		if(Number(fmValue) > Number(toValue)){
 	    	 			ComShowCodeMessage('COM12133','To','From','greater');
 		 				// focus to grid
 	    	 			sheetObj.SetCellValue(currRow, Col, "");
// 		 				sheetObj.focus();
 	   	 			 	sheetObj.SelectCell(currRow, Col, true);
 	    	 		}
     	 		}
     	 		break;
     	}    	 
    }
 	function t3sheet1_OnSaveEnd(sheetObj, errMsg) {
 		var formObject=document.form;
 		if(errMsg =='') {   
 			ComShowCodeMessage('CGM00003');
 			// retrieve
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			// Form Control enable/disable handling
			doControlEnable("btn_Retrieve");
			// button enable/disable handling
	    	doActionBtnEnable('R');
	    	tabObjects[0].SetSelectedIndex(0);
	    	
	    	//20160503 Added by Jun Kato 
            // Enable Save button, Old Agreement No field and Remark tab
            ComBtnEnable("btn_Save");
            ComCgmEnableObject(old_agmt_no, true, 'input1');
            ComCgmEnableObject(diff_rmk, true);
	    	
 		}
    }
  	function t3sheet2_OnSaveEnd(sheetObj, errMsg) {
  		var formObject=document.form;
  		if(errMsg =='') {
  			ComShowCodeMessage('CGM00003');
  			if(comboObjects[0].GetItemCount() > 1){
				// retrieve
				comboObjects[0].SetSelectText("",false);
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				// Form Control Enable setting
				doControlEnable("btn_Retrieve");
				// button enable/disable handling
				doActionBtnEnable('R');
				
				//20160503 Added by Jun Kato 
                // Enable Save button, Old Agreement No field and Remark tab
                ComBtnEnable("btn_Save");
                ComCgmEnableObject(old_agmt_no, true, 'input1');
                ComCgmEnableObject(diff_rmk, true);
				
			} else {
				//Form Control reset
				initControl();
				// Form Control Enable setting
				doControlEnable("btn_New");
				// button enable/disable handling
				doActionBtnEnable('L');
			}
  		}
  	} 	 
    function agmt_ver_no_OnChange(Index_Code, Text){
    	///***** use additional sheet var in case of more than 2 tap each sheet *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        var sheetObject5=sheetObjects[4];
        ///*******************************************************/
        var formObject=document.form;
//    	var obj=document.getElementById("btn_Retrieve");
//    	obj.fireEvent("onclick");
		if(ComCgmIsActionButtonEnable("btn_Retrieve")){
			if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
				// Search 
				var result=doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				if(result){
					// Form Control enable/disable handling
					doControlEnable("btn_Retrieve");
					// 
		    	doActionBtnEnable('R');
		    	
				}
			}
		}
    }
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
     	cmbObj.RemoveAll();
     	cmbObj.InsertItem(0,"","");
     	for (var i=0; i < arrStr.length;i++ ) {
     		var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
     	}
     	cmbObj.SetSelectIndex("" ,false);
    }
	 /**
	  * function(ex:btn_save) role(trole) apply  <br>
	  * @param  
	  * @return 
	  * @author 
	  * @version 2010.03.05
	  */     
	  function tRoleApply() {
//		  var formObj=document.form;
//		  if(formObj.trole.value == "Authenticated")
//		  {
//		  }else
//		  {
//			  ComBtnDisable("btn_Delete");
//			  ComBtnDisable("btn_Save");
//			  ComBtnDisable("btn_VersionUp");
//			  ComBtnDisable("btn_t2RowAdd");
//			  ComBtnDisable("btn_t2Delete");
//			  ComBtnDisable("btn_t3RowAdd");
//			  ComBtnDisable("btn_t3Delete");
//		      var btnSave=document.getElementById("btn_Save");
//		      var btnDelete=document.getElementById("btn_Delete");
//		      var btnVersionUp=document.getElementById("btn_VersionUp");
//			  btnSave.className=BTN_DISABLE;
//			  btnDelete.className=BTN_DISABLE;
//			  btnVersionUp.className=BTN_DISABLE;
//		  }
	  } 