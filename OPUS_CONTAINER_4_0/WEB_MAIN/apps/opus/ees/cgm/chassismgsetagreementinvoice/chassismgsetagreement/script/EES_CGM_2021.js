/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2021.js
*@FileTitle  : Lease Agreement Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_2021 : ees_cgm_2021 business script for
 */
    function ees_cgm_2021() {
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
    var tabObjects=new Array();
    
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var oldCntrTypeSize = "";
    var sCntrTypeSize = "";
    
    var t3sheet1_leftHeaders = [{Text:"During Build-up Period|During Fixed Period", Align:"Center"}];
    
    var t3sheet2_leftHeaders = [{Text:"Initial Value(USD)", Align:"Center"}];
    
    var t3sheet3_leftHeaders = [{Text:"Post Trip Charge(POTC)|Pre Trip Charge(PRTC)", Align:"Center"}];
    
    BTN_ENABLE = "btn_accent";
    BTN_DISABLE = "btn_normal";
    // Event handler processing by button click event */;
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version 
     */
    function processButtonClick(){
        /***** use additional sheet var in case of more than 2 tap each sheet *****/
        var sheetObject1=sheetObjects[3];
        var sheetObject2=sheetObjects[4];
        /*******************************************************/
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
                                // button enable/disable handling
                                doActionBtnEnable('R');
                                tabObjects[0].SetSelectedIndex(0);
                            }
                        }
                    }
                    break;
                case "btn_New":
                    if(ComCgmIsActionButtonEnable(srcName)){
                        // Form Control reset
                        initControl();
                        //formObj.agmt_ref_no.focus();
                        // Form Control Enable setting
                        doControlEnable("btn_New");
                        // button enable/disable handling
                        formObject.agmt_no.value="NEW";
                        doActionBtnEnable('N');
                    }
                    break;
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
                    if(ComCgmIsActionButtonEnable(srcName)){
                        // Version Up
                        doVersionUp();
                        // Form Control Enable setting
                        doControlEnable("btn_VersionUp");
                        // button enable/disable handling
                        doActionBtnEnable('V');
                    }
                    break;
                case "btns_Calendar_agmtDt" :		// Agreement Date
                    if(!formObject.agmt_dt.readOnly){
                    var cal=new ComCalendar();
                    cal.select(formObject.agmt_dt, "yyyy-MM-dd");
                    }
                    break;
                case "btns_Calendar_effDt" :		// Rate Eff. Date (From Date)
                    if(!formObject.eff_dt.readOnly){
                        var cal=new ComCalendar();
                        cal.select(formObject.eff_dt, "yyyy-MM-dd");
                    }
                    break;
                case "btns_Calendar_agmt_effDt" :		// Agreement Eff. Date (From Date)
                    if(!formObject.agmt_eff_dt.readOnly){
                        var cal=new ComCalendar();
                        cal.select(formObject.agmt_eff_dt, "yyyy-MM-dd");
                    }
                    break;
                case "btns_Calendar_agmt_expDt" :		// Agreement Eff. Date (To Date)
                    if(!formObject.agmt_exp_dt.readOnly){
                        var cal=new ComCalendar();
                        cal.select(formObject.agmt_exp_dt, "yyyy-MM-dd");
                    }
                    break;
                case "btns_agmtno":	// Agreement No getting popup
                    if(!formObject.agmt_no.readOnly){
                        ComOpenPopupWithTarget('/opuscntr/EES_CGM_2022.do', 800, 415, "agmt_no:agmt_no", "1,0,1,1,1,1,1,1,1", true);
                    }
                    break;
                case "btns_curr_cd":	// Currency getting popup
                    var currCd=document.getElementById("btns_curr_cd");
                    if(!currCd.disabled){
                        var param="curr_cd=&cnt_cd=&curr_desc=";
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 700, 450, "curr_cd:curr_cd", "1,0,1,1,1", true);
                    }
                    break;
                case "btns_vndr":	// Lessor Code getting popup
                    if(!formObject.vndr_seq.readOnly){
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_0C1.do', 700, 455, "vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "1,0,1,1,1,1", true);
                    }
                    break;
                case "btns_office":	// Lessor Code getting popup
                    if(!formObject.agmt_iss_ofc_cd.readOnly){
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 620, 480, "ofc_cd:agmt_iss_ofc_cd", "1,0,1,1,1,1", true);
                    }
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
     * registering IBSheet Object as list <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version 
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
     * @version 
     */
    function loadPage() {
        var formObj=document.form;
        
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);
        
    //    axon_event.addListenerForm('focusin', 'obj_focusIn', form);
        axon_event.addListenerForm('blur', 'obj_onBlur', form);
//        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListener('change', 'obj_change', 'agmt_no', 'vndr_seq', 'agmt_iss_ofc_cd', 'pay_term_dys');

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
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
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k]);
        }
        // button enable/disable handling
        doActionBtnEnable('L');
        doActionIBSheet(sheetObjects[0], formObj, IBRESET);
        // Form Control Enable setting
        doControlEnable("LOAD");
        // Form Object reset and  Control Value Reset handling
        initControl();
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
            ComCgmSetObjectValue(agmt_ver_no);
            ComCgmSetObjectValue(lst_ver_flg);
            ComCgmSetObjectValue(agmt_ref_no);
            ComCgmSetObjectValue(agmt_ctrt_no);
            ComCgmSetObjectValue(curr_cd);
            ComCgmSetObjectValue(agmt_dt);
            ComCgmSetObjectValue(agmt_iss_ofc_cd, ofc_cd.value);
            ComCgmSetObjectValue(eff_dt);
            ComCgmSetObjectValue(exp_dt);
            ComCgmSetObjectValue(vndr_seq);
            ComCgmSetObjectValue(vndr_lgl_eng_nm);
            ComCgmSetObjectValue(pay_term_dys);
            ComCgmSetObjectValue(onh_hndl_rt_amt,'0.00');
            ComCgmSetObjectValue(offh_hndl_rt_amt,'0.00');
            ComCgmSetObjectValue(mon_dpc_rt_amt,'0.00');
            ComCgmSetObjectValue(max_dpc_rt_amt,'0.00');
            ComCgmSetObjectValue(init_dpc_rt_amt,'0.00');
/*            ComCgmSetObjectValue(onh_init_val_amt_clg,'0.00');
            ComCgmSetObjectValue(mgst_potc_scg_rt_amt_clg,'0.00');
            ComCgmSetObjectValue(mgst_prtc_scg_rt_amt_clg,'0.00');
            ComCgmSetObjectValue(mgst_bldp_rt_amt_clg,'0.00');
            ComCgmSetObjectValue(mgst_lse_fx_rt_amt_clg,'0.00');
            ComCgmSetObjectValue(onh_init_val_amt_umg,'0.00');
            ComCgmSetObjectValue(mgst_potc_scg_rt_amt_umg,'0.00');
            ComCgmSetObjectValue(mgst_prtc_scg_rt_amt_umg,'0.00');
            ComCgmSetObjectValue(mgst_bldp_rt_amt_umg,'0.00');
            ComCgmSetObjectValue(mgst_lse_fx_rt_amt_umg,'0.00');*/
            diff_rmk.value="";
            ComCgmSetObjectValue(pre_eff_dt);
            ComCgmSetObjectValue(pre_exp_dt);
            ComCgmSetObjectValue(agmt_eff_dt);
            ComCgmSetObjectValue(agmt_exp_dt);
            agmt_ref_no.ReadOnly=true;
            vndr_lgl_eng_nm.ReadOnly=true;
            ComCgmSetObjectValue(old_agmt_no);
        }
        // Currency setting
        formObj.curr_cd.value=currCd;
        // MultiCombo reset
        comboObjects[0].RemoveAll();
        comboObjects[1].SetSelectText("",false);
        tabObjects[0].SetSelectedIndex(0);
        
		sheetObjects[0].DataInsert(); 
		sheetObjects[0].DataInsert();
		InitHeadColumn(t3sheet1_leftHeaders,sheetObjects[0]);
		

		
		sheetObjects[1].DataInsert(); 
		InitHeadColumn(t3sheet2_leftHeaders,sheetObjects[1]);
		
		sheetObjects[2].DataInsert(); 
		sheetObjects[2].DataInsert(); 
		InitHeadColumn(t3sheet3_leftHeaders,sheetObjects[2]);


        formObj.agmt_no.focus();
    }
    
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	
    function doVersionUp(){
        var index=comboObjects[0].GetItemCount();
        var newAgmtVerNo=index + 1;
        // version setting
    	comboObjects[0].InsertItem(index, newAgmtVerNo.toString(), newAgmtVerNo.toString());
    	comboObjects[0].SetSelectText(newAgmtVerNo.toString(),false);
        // eff_dt nad exp_dt saving
        document.form.pre_eff_dt.value=document.form.eff_dt.value;
        document.form.pre_exp_dt.value=document.form.exp_dt.value;
        document.form.eff_dt.value="";
        document.form.exp_dt.value=document.form.agmt_exp_dt.value;
        document.form.pre_agmt_exp_dt.value=document.form.agmt_exp_dt.value;
    }
    
    /**
     * Control Action  Enable control. <br>
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
                //Added by kato (To disable agmt no version after version up due to Rate eff date onblur problem)
    	        agmt_ver_no.SetEnable(1);
    	        //
                break;
            case "btn_VersionUp":
                setFormControlEnable(formObj, true);
                ComCgmEnableObject(formObj.agmt_no, false);
                ComCgmEnableObject(formObj.btns_agmtno, false);
                ComCgmEnableObject(formObj.agmt_eff_dt, false);
                ComCgmEnableObject(formObj.agmt_exp_dt, true);
                ComCgmEnableObject(formObj.btns_Calendar_agmt_effDt, false);
                ComCgmEnableObject(formObj.btns_Calendar_agmt_expDt, true);
                ComCgmEnableObject(formObj.btns_curr_cd, false);
                comboObjects[1].SetEnable(0);
                ComCgmEnableObject(formObj.vndr_seq, false);
                ComCgmEnableObject(formObj.btns_vndr, false);
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
    }
     /**
     * Action button의 enable/disable setting. <br>
     * @param  
     * @return 
     * @author 
     * @version9
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
                if(lstVerFlg == 'Y'){
//                    btnSave.className=BTN_DISABLE;
//                    btnDelete.className=BTN_ENABLE;
//                    btnVersionUp.className=BTN_ENABLE;
                    ComBtnDisable("btn_Save");
                    ComBtnEnable("btn_Delete");
                    ComBtnEnable("btn_VersionUp");
                    
                    //20160518 Added by Jun Kato 
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
                break;
        }
     }
    /**
     * Form Control enable/disable setting. <br>
     * @param  {object} formObj	mandatory
     * @param  {boolean} bEnable	mandatory
     * @return 
     * @author 
     * @version9
     */
    function setFormControlEnable(formObj, bEnable){
        with(formObj){
            ComCgmEnableObject(curr_cd, false);
            ComCgmEnableObject(vndr_lgl_eng_nm, false);
            ComCgmEnableObject(exp_dt, false);
            ComCgmEnableObject(agmt_no, 	bEnable);
            if(bEnable){
//            	agmt_ref_no.className="input1";
//            	agmt_dt.className="input1";
//            	agmt_iss_ofc_cd.className="input1";
//            	eff_dt.className="input1";
//            	agmt_eff_dt.className="input1";
//            	agmt_exp_dt.className="input1";
//            	vndr_seq.className="input1";
            	ComCgmEnableObject(agmt_ref_no, 	bEnable, 'input1');
            	ComCgmEnableObject(agmt_ctrt_no, 	bEnable, 'input1');
                ComCgmEnableObject(agmt_dt, 		bEnable, 'input1');
//                ComCgmEnableObject(agmt_iss_ofc_cd, bEnable, 'input1');
                ComCgmEnableObject(eff_dt, 			bEnable, 'input1');
                ComCgmEnableObject(agmt_eff_dt, 	bEnable, 'input1');
                ComCgmEnableObject(agmt_exp_dt, 	bEnable, 'input1');
                ComCgmEnableObject(vndr_seq,		bEnable, 'input1');
                ComCgmEnableObject(old_agmt_no,		bEnable, 'input1');
            } else {
                ComCgmEnableObject(agmt_ref_no, 	bEnable);
                ComCgmEnableObject(agmt_ctrt_no, 	bEnable);
                ComCgmEnableObject(agmt_dt, 		bEnable);
                ComCgmEnableObject(agmt_iss_ofc_cd, bEnable);
                ComCgmEnableObject(eff_dt, 			bEnable);
                ComCgmEnableObject(agmt_eff_dt, 	bEnable);
                ComCgmEnableObject(agmt_exp_dt, 	bEnable);
                ComCgmEnableObject(vndr_seq,		bEnable);
                ComCgmEnableObject(old_agmt_no,		bEnable);
            }
            ComCgmEnableObject(pay_term_dys,bEnable);
            // img button Enable
            ComCgmEnableObject(btns_Calendar_agmtDt, 	bEnable);
            ComCgmEnableObject(btns_Calendar_effDt, 	bEnable);
            ComCgmEnableObject(btns_Calendar_agmt_effDt,bEnable);
            ComCgmEnableObject(btns_Calendar_agmt_expDt,bEnable);
            ComCgmEnableObject(btns_agmtno, bEnable);
            ComCgmEnableObject(btns_vndr, bEnable);
            ComCgmEnableObject(btns_curr_cd,bEnable);
//            ComCgmEnableObject(btns_office, 		bEnable);
            // etc Text Box
            ComCgmEnableObject(onh_hndl_rt_amt, bEnable);
            ComCgmEnableObject(offh_hndl_rt_amt,bEnable);
            ComCgmEnableObject(mon_dpc_rt_amt, 	bEnable);
            ComCgmEnableObject(max_dpc_rt_amt, 	bEnable);
            ComCgmEnableObject(init_dpc_rt_amt, bEnable);
 //           ComCgmEnableObject(onh_init_val_amt_clg, 	 bEnable);
 //           ComCgmEnableObject(onh_init_val_amt_umg, 	 bEnable);
 //           ComCgmEnableObject(mgst_potc_scg_rt_amt_clg, bEnable);
 //           ComCgmEnableObject(mgst_prtc_scg_rt_amt_clg, bEnable);
 //           ComCgmEnableObject(mgst_potc_scg_rt_amt_umg, bEnable);
 //           ComCgmEnableObject(mgst_prtc_scg_rt_amt_umg, bEnable);
 //           ComCgmEnableObject(mgst_bldp_rt_amt_clg,	 bEnable);
 //           ComCgmEnableObject(mgst_lse_fx_rt_amt_clg, 	 bEnable);
 //           ComCgmEnableObject(mgst_bldp_rt_amt_umg, 	 bEnable);
 //           ComCgmEnableObject(mgst_lse_fx_rt_amt_umg, 	 bEnable);
            if(bEnable){
                 ComCgmEnableObject(diff_rmk, bEnable);
            } else {
                 ComCgmEnableObject(diff_rmk, bEnable);
            }
            // MultiCombo Enable
            comboObjects[1].SetEnable(bEnable);
          
         //2016.05.19 Added by Kato
         // IBSheet Enable
    		for(var idx=0; idx < sheetObjects.length; idx++) {
    			for(var jdx = 1; jdx <= sheetObjects[idx].RowCount(); jdx++) {
    				for(var kdx = 1; kdx <= sheetObjects[idx].LastCol(); kdx++) { 
    					sheetObjects[idx].SetCellEditable(jdx, kdx, bEnable);
    				}
    			}
    		}
            
        }
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
			 	      var cols = [ {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 }, 
			 	                   {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];

  					  var sCount = "";
					  var x = 1;
					  
 	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:sCount , KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }
 	 	              
			 	      InitColumns(cols);
			 	      SetEditable(1);
			 	      InitHeadColumn(t3sheet1_leftHeaders, sheetObj);
			 	     // resizeSheet(sheetObj);
			 	     SetSheetHeight(120);
	 				}
	            break;
	            
	       case "t3sheet2":
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
			 	      var cols = [ {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 }, 
			 	                   {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];

					  var sCount = "";
					  var x = 1;
					  
	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:sCount , KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
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
			 	      var cols = [ {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"title",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, Focus:0 }, 
			 	                   {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];

					  var sCount = "";
					  var x = 1;
					  
	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"Float",     Hidden:0,  Width:150,   Align:"Center",  ColMerge:0,   SaveName:sCount , KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
					 		  x++;
					 	  }
					  }

 	 	             InitColumns(cols);
			         SetEditable(1);
			         SetSheetHeight(120);
	               }
	            break;        
            case "sheet1":
                with(sheetObj){
		              var HeadTitle="|";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(82);
                    }
                break;
                
            case "sheet2":
                with(sheetObj){
		              var HeadTitle="|";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(82);
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
                formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
                sheetObj.SetWaitImageVisible(0);
//                ComOpenWait(true);
//                var sXml=sheetObj.GetSearchData("EES_CGM_2021GS.do" , FormQueryString(formObj), '', true);
//                ComOpenWait(false);
                
		 	    ComOpenWait(true);
		 	    var sXml=sheetObjects[2].GetSearchData("EES_CGM_2021GS.do" , FormQueryString(formObj), '', true);
         		var arrXml=sXml.split("|$$|");
               	ComOpenWait(false);
               
               	
                // Sheet Object 1
               	sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
               	
                setEtcDataToForm(formObj, sheetObj);
                
                var dataCount=ComGetTotalRows(arrXml[0]);
                
                if(dataCount != null && dataCount > 0){
                    sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
                    sheetObjects[1].LoadSearchData(arrXml[2],{Sync:1} );
                    sheetObjects[2].LoadSearchData(arrXml[3],{Sync:1} );
                    
                   // Agreement Version Multi Combo setting
                    var cols=ComCgmXml2ComboString(arrXml[0], "agmt_ver_no", "agmt_ver_no");
                    ComCgmMakeMultiCombo(comboObjects[0], cols[0], cols[1], 0);
                    comboObjects[0].SetSelectText(ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ver_no")),false);
                    
                    formObj.pay_term_dys.value = ComAddComma(formObj.pay_term_dys.value);
                    formObj.onh_hndl_rt_amt.value = ComAddComma(formObj.onh_hndl_rt_amt.value);
                    formObj.offh_hndl_rt_amt.value = ComAddComma(formObj.offh_hndl_rt_amt.value);
                    formObj.mon_dpc_rt_amt.value = ComAddComma(formObj.mon_dpc_rt_amt.value);
                    formObj.max_dpc_rt_amt.value = ComAddComma(formObj.max_dpc_rt_amt.value);
                    formObj.init_dpc_rt_amt.value = ComAddComma(formObj.init_dpc_rt_amt.value);
                    
                    return true;
                } else {
                    ComShowCodeMessage('CGM10004', 'Agreement No.');
                    return false;
                }
                
          		
                break;
                
            case IBSAVE:        //saving
                formObj.f_cmd.value=MULTI;
                formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
                
                var sParam="";
	         	var sParam1=sheetObjects[0].GetSaveString(true);
				var sParam2=sheetObjects[1].GetSaveString(true);
				var sParam3=sheetObjects[2].GetSaveString(true);
				
				sParam1=ComSetPrifix(sParam1, "t3sheet1_");
				sParam2=ComSetPrifix(sParam2, "t3sheet2_");
				sParam3=ComSetPrifix(sParam3, "t3sheet3_");

				sParam=sParam + sParam1 + "&";
				sParam=sParam + sParam2 + "&";
				sParam=sParam + sParam3 + "&";
				sParam=sParam + FormQueryString(formObj);

                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveData("EES_CGM_2021GS.do", sParam);
                ComOpenWait(false);
                if(formObj.action_flag.value == "N"){
                    formObj.agmt_no.value=ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_no"));
                    formObj.agmt_ofc_cty_cd.value=ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_ofc_cty_cd"));
                    formObj.agmt_seq.value=ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_seq"));
                    formObj.lst_ver_flg.value=ComCgmNullToBlank(ComGetEtcData(sXml, "lst_ver_flg"));
                    // Version info MultiCombo setting
                    var agmtVerNo=ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_ver_no"));
                    comboObjects[0].InsertItem(0,agmtVerNo,agmtVerNo);
                    comboObjects[0].SetSelectText(agmtVerNo,false);
                }
                sheetObj.LoadSaveData(sXml);
                break;
                
            case IBDELETE:		// deleting
                formObj.f_cmd.value=REMOVE;
                formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveData("EES_CGM_2021GS.do", FormQueryString(formObj));
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
                
            case IBSEARCH_ASYNC02:	// Vendor Code,Name retrieve
                formObj.f_cmd.value=SEARCH07;
                var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
                var text=ComGetEtcData(sXml,"text");
                var payCurrCd=ComCgmNullToBlank(ComGetEtcData(sXml,"pay_curr_cd"));
                var genPayTermCd=ComGetEtcData(sXml,"gen_pay_term_cd");
                for(var i=0; i<genPayTermCd.length; i++){
                    if(genPayTermCd.charCodeAt(i) < 48 || genPayTermCd.charCodeAt(i) > 57){
                        genPayTermCd="0";
                        break;
                    }
                }
                if(text ==""){
                    formObj.vndr_seq.value="";
                }
                formObj.curr_cd.value=payCurrCd;
                formObj.vndr_lgl_eng_nm.value=text;
                formObj.pay_term_dys.value=genPayTermCd;
                break;
                
            case IBSEARCH_ASYNC03:	// Office Code  Validation check
                formObj.f_cmd.value=COMMAND01;
                formObj.ofc_cd.value=formObj.agmt_iss_ofc_cd.value;
                var sXml=sheetObj.GetSearchData("CgmValidationGS.do", FormQueryString(formObj), '', true);
                var sCheckResult=ComGetEtcData(sXml,"checkResult");
                if(sCheckResult == COM_VALIDATION_FALSE){
                    ComShowCodeMessage('CGM10009','Office');
                    formObj.agmt_iss_ofc_cd.value="";
                    ComSetFocus(formObj.agmt_iss_ofc_cd);
                }
                break;
                
          	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
            	formObj.f_cmd.value = SEARCH21;
        		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
    			var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
    			sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
    			
    			//getting changing column information from server
    			oldCntrTypeSize = sCntrTypeSize;
    			
    			
    			
    			break;
            case IBRESET:
                var idx=0
                var sXml2=document.form2.sXml.value;
                var arrXml=sXml2.split("|$$|");
                formObj.curr_cd.value=ComGetEtcData(arrXml[0], "ar_curr_cd");
                currCd=ComCgmNullToBlank(ComGetEtcData(arrXml[0], "ar_curr_cd"));
                //agmt_lstm_cd
                if ( arrXml[idx] == null ) {return;}
                var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
                var arrStr1=new Array();
                for ( var i=0; i < vArrayListData.length; i++) {
                    vListData=vArrayListData[i];
                    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
                }
                // combo control, result string, Text Index, Code Index
                MakeComboObject(agmt_lstm_cd, arrStr1, 0, 0);
                idx++;
                break;
        }
    }
     /**
      * ETC data Form Tag setting. <br>
      * @param  {object} formObj	 mandatory
      * @param  {object} sheetObj mandatory
      * @return 
      * @author 
      * @version
      */
    function setEtcDataToForm(formObj, sheetObj){
        formObj.eq_knd_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("eq_knd_cd"));
        formObj.agmt_ofc_cty_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ofc_cty_cd"));
        formObj.agmt_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_seq"));
        formObj.lst_ver_flg.value=ComCgmNullToBlank(sheetObj.GetEtcData("lst_ver_flg"));
        formObj.agmt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_no"));
        formObj.agmt_ref_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ref_no"));
        formObj.agmt_ctrt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ctrt_no"));
        formObj.curr_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("curr_cd"));
        formObj.agmt_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_dt"));
        formObj.agmt_iss_ofc_cd.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_iss_ofc_cd"));
        formObj.eff_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("eff_dt"));
        formObj.exp_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("exp_dt"));
        formObj.agmt_eff_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_eff_dt"));
        formObj.agmt_exp_dt.value=ComCgmNullToBlank(sheetObj.GetEtcData("agmt_exp_dt"));
        formObj.vndr_seq.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_seq"));
        formObj.vndr_lgl_eng_nm.value=ComCgmNullToBlank(sheetObj.GetEtcData("vndr_lgl_eng_nm"));
        formObj.pay_term_dys.value=ComCgmNullToBlank(sheetObj.GetEtcData("pay_term_dys"));
        formObj.onh_hndl_rt_amt.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("onh_hndl_rt_amt"))).toFixed(2);
        formObj.offh_hndl_rt_amt.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("offh_hndl_rt_amt"))).toFixed(2);
        formObj.mon_dpc_rt_amt.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("mon_dpc_rt_amt"))).toFixed(2);
        formObj.max_dpc_rt_amt.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("max_dpc_rt_amt"))).toFixed(2);
        formObj.init_dpc_rt_amt.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("init_dpc_rt_amt"))).toFixed(2);
        formObj.diff_rmk.value=ComCgmNullToBlank(sheetObj.GetEtcData("diff_rmk"));
        comboObjects[0].SetSelectText(ComCgmNullToBlank(sheetObj.GetEtcData("agmt_ver_no")),false);
        comboObjects[1].SetSelectText(ComCgmNullToBlank(sheetObj.GetEtcData("agmt_lstm_cd")),false);
//        formObj.onh_init_val_amt_clg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("onh_init_val_amt_clg"))).toFixed(2);
//        formObj.mgst_potc_scg_rt_amt_clg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_potc_scg_rt_amt_clg"))).toFixed(2);
//        formObj.mgst_prtc_scg_rt_amt_clg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_prtc_scg_rt_amt_clg"))).toFixed(2);
//        formObj.mgst_bldp_rt_amt_clg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_bldp_rt_amt_clg"))).toFixed(2);
//        formObj.mgst_lse_fx_rt_amt_clg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_lse_fx_rt_amt_clg"))).toFixed(2);
//        formObj.onh_init_val_amt_umg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("onh_init_val_amt_umg"))).toFixed(2);
//        formObj.mgst_potc_scg_rt_amt_umg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_potc_scg_rt_amt_umg"))).toFixed(2);
//        formObj.mgst_prtc_scg_rt_amt_umg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_prtc_scg_rt_amt_umg"))).toFixed(2);
//        formObj.mgst_bldp_rt_amt_umg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_bldp_rt_amt_umg"))).toFixed(2);
//        formObj.mgst_lse_fx_rt_amt_umg.value=parseFloat(ComCgmNullToZero(sheetObj.GetEtcData("mgst_lse_fx_rt_amt_umg"))).toFixed(2);
        formObj.old_agmt_no.value=ComCgmNullToBlank(sheetObj.GetEtcData("old_agmt_no"));
    }
    /**
     * registering IBTab Object as list
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
    /**
     * handling process for input validation <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			false => validation check error, true => validation check succes
     * @author 
     * @version 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            switch(sAction){
                case IBSEARCH:	// retrieve
                    if(agmt_no.value == ''){
                        ComShowCodeMessage('CGM10004','Agreement No.');
                        agmt_no.focus();
                        return false;
                    } else {
                        return true;
                    }
                    break;
                case IBSAVE:	// saving
                    var combo_agmt_lstm_cd=comboObjects[1];
                    var sheet;
                    // Form inserting check
                    if(agmt_ref_no.value == ''){
                        ComShowCodeMessage('CGM10004','Ref. No.');
                        agmt_ref_no.focus();
                        return false;
                    } else if(agmt_dt.value == ''){
                        ComShowCodeMessage('CGM10004','Agreement Date');
                        agmt_dt.focus();
                        return false;
                    } else if(agmt_iss_ofc_cd.value == ''){
                        ComShowCodeMessage('CGM10004','Office');
                        agmt_iss_ofc_cd.focus();
                        return false;
                    } else if(agmt_eff_dt.value == ''){
                        ComShowCodeMessage('CGM10004','Agreement Eff. From Date');
                        agmt_eff_dt.focus();
                        return false;
                    } else if(agmt_exp_dt.value == ''){
                        ComShowCodeMessage('CGM10004','Agreement Eff. To Date');
                        agmt_exp_dt.focus();
                        return false;
                    } else if(eff_dt.value == ''){
                        ComShowCodeMessage('CGM10004','Rate Eff. From Date');
                        eff_dt.focus();
                        return false;
                    } else if(exp_dt.value == ''){
                        ComShowCodeMessage('CGM10004','Rate Eff. To Date');
                        exp_dt.focus();
                        return false;
                    } else if(combo_agmt_lstm_cd.GetSelectText()== ''){
                        ComShowCodeMessage('CGM10004','Lease Term');
                        agmt_lstm_cd.focus();
                        return false;
                    } else if(vndr_seq.value == ''){
                        ComShowCodeMessage('CGM10004','Lessor');
                        vndr_seq.focus();
                        return false;
                    } else if(agmt_ctrt_no.value == ''){
                        ComShowCodeMessage('CGM10004','Contract No.');
                        agmt_ctrt_no.focus();
                        return false;
                    } else if(old_agmt_no.value == ''){
                        ComShowCodeMessage('CGM10004','Old AGMT No.');
                        old_agmt_no.focus();
                        return false;
                    }
                    var effDt=ComReplaceStr(eff_dt.value,"-","");
                    var expDt=ComReplaceStr(exp_dt.value,"-","");
                    var agmtEffDt=ComReplaceStr(agmt_eff_dt.value,"-","");
                    var agmtExpDt=ComReplaceStr(agmt_exp_dt.value,"-","");
                    if(agmt_no.value == 'NEW'){
                        if(effDt != agmtEffDt){
                            ComShowCodeMessage('CGM10074');
                            eff_dt.focus();
                            return false
                        }
                    }
                    return true;
                    break;
                    
                case IBDELETE:	// deleting
                    if(agmt_no.value == ''){
                        ComShowCodeMessage('CGM10004','Agreement No.');
                        agmt_no.focus();
                        return false;
                    } else if(agmt_ver_no.value == ''){
                        ComShowCodeMessage('CGM10004','Version');
                        agmt_ver_no.focus();
                        return false;
                    } else {
                        return true;
                    }
                    break;
            }
        }
    }
     /**
      * Object Keypress event handling  <br>
      * 
      * @param  
      * @return 
      * @author 
      * @version
      */
//    function obj_keypress(){
//        obj=ComGetEvent();
//        if(obj.getAttribute("dataformat") == null) return;
//        window.defaultStatus=obj.getAttribute("dataformat");
//        var specChar='33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|'
//        specChar=specChar + '58|59|60|61|62|63|64|91|92|93|94|95|123|124|125|126';
//        switch(obj.getAttribute("dataformat")) {
//            case "ym": case "ymd":
//                ComKeyOnlyNumber(obj);
//                break;
//            case "int":
//                ComKeyOnlyNumber(obj);
//                break;
//            case "float":
//                ComKeyOnlyNumber(obj, "-.");
//                break;
//            case "eng":
//                ComKeyOnlyAlphabet();
//                break;
//            case "engup":
//                if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum');
//                else if(obj.name=="agmt_no") ComKeyOnlyAlphabet('uppernum');
//                else if(obj.name=="agmt_ref_no") ComKeyOnlyAlphabet('uppernum',specChar);
//                else ComKeyOnlyAlphabet('upper');
//                break;
//            case "engdn":
//                if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
//                else ComKeyOnlyAlphabet('lower');
//                break;
//        }
//    }
//    function obj_keydown(){
//        obj=ComGetEvent();
//        switch(ComGetEvent("name")){
//            case 'agmt_no':
//                var keyValue=null;
//                if(event == undefined || event == null) {
//                    keyValue=13;
//                } else {
//                    keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//                }
//                if(keyValue != 13) return;
//                var agmtNo=formObj.agmt_no.value;
//                var result=true;
//                if(agmtNo != "" && agmtNo != "NEW"){
//                    if(agmtNo.length <= 3){
//                        result=false;
//                    } else {
//                        if(ComIsNumber(agmtNo.substring(3))==false){
//                            result=false;
//                        }
//                    }
//                } else {
//                    result=true;
//                }
//                if(!result){
//                    ComShowCodeMessage('CGM10004','Agreement No.');
//                    formObj.agmt_no.value="";
//                    ComSetFocus(formObj.agmt_no);
//                } else {
//                    ComKeyEnter();
//                }
//                break;
//        }
//    }
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
							if(ComChkObjValid2(agmt_dt)) {
								obj.value = ComGetMaskedValue(obj, 'ymd', '-');
							}else {
								agmt_dt.value='';
								agmt_dt.focus();
								break;
							}
						}
						
						
						break;
                	case "eff_dt":	// Agreement Eff. Date(from)
                        if(effDt != '' && expDt != ''){
                            if(effDt > expDt){
                                ComShowCodeMessage('COM12133','To date','From date','greater');
                                eff_dt.value='';
                                eff_dt.focus();
                                break;
                            }
                        }
                        if(effDt != "" && preExpDt != ""){
                          //  var nextEffDt=ComReplaceStr(ComGetDateAdd(pre_exp_dt.value,"D","1"),"-","");
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
                    case "exp_dt":	// Agreement Eff. Date(to)
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
                                exp_dt.value=pre_agmt_exp_dt.value;
                                agmt_exp_dt.focus();
                                break;
                            }
                        }
                        if(agmt_exp_dt.value != ''){
                        	if(agmt_exp_dt.value.length > 8){
                        		exp_dt.value=agmt_exp_dt.value;
                        	}
                        	else{
                        		exp_dt.value=agmt_exp_dt.value.substring(0,4) + '-' + agmt_exp_dt.value.substring(4,6) + '-' + agmt_exp_dt.value.substring(6,8);
                        	}
                            
                        } else {
                            exp_dt.value='';
                        }
                        obj.value = ComGetMaskedValue(obj, 'ymd', '-');
                        
                        break;
                } // switch  End
            } // if End
        } // with
        if(obj.getAttribute("dataformat") == 'ymd' || obj.getAttribute("dataformat") == 'ym' || obj.getAttribute("dataformat") == 'float'){
            ComChkObjValid2(obj);
        }
    }
    
	function ComChkObjValid2(obj, bMsg, bTrim, bMasked){
		try {
			var sTitle="";
			var sMsg="";
			var props=new Array("required", "dataformat", "maxLength", "minlength", "fullfill", "maxnum", "minnum", "pointcount", "cofield");
			if (bMsg==undefined || bMsg==null)            bMsg=true;
			if (bTrim==undefined || bTrim==null)          bTrim=true;
			if (bMasked==undefined || bMasked==null)      bMasked=true;
			var sFormat="";
			var sVal="";
			var maskValue="";
			var iMaxLen=0, iMaxVal=null, iMinVal=null;
			sVal=ComGetObjValue(obj)
			if (obj.type=="radio") {
				if (obj.name == null || obj.name=="") return true;
				var eRadio=document.all[obj.name];
				obj=eRadio[0];
			}else if(obj.type == undefined && obj.length != undefined && obj[0].type == "radio") {
				obj=obj[0];
			}
             sTitle=(obj.getAttribute("caption")==null)?obj.name:obj.getAttribute("caption");
             if(bTrim) sVal=ComTrim(sVal);
             maskValue=sVal;
             for(var j=0; j<props.length; j++){
                 var attriVal=obj.getAttribute(props[j]);
                 if (attriVal == null) continue;
                 switch(props[j]) {
                     case "required":    //mandatory inserting check
                         if(sVal==""){
                            sMsg="'" + sTitle + "' " +Msg_Required;
                            j=99;
                         }
                         break;
                     case "dataformat":  
                         sFormat=attriVal;
                        if (sFormat!="") sVal=ComGetUnMaskedValue(sVal, sFormat);
                         if (sVal== "") continue;
                         maskValue=ComGetMaskedValue(obj, sFormat);
                         if (sVal != maskValue && sFormat.indexOf("eng")>=0) obj.value=maskValue;
                         if (maskValue!= "") continue;
                         switch(sFormat) {
                             case "float":   
                                 sMsg="'" + sTitle + "' is not valid. Please enter a correct float(real type) format.";
                                j=99;
                                break;
                         }
                         break;
                     case "maxLength":  
                         if (sVal== "") continue;
                         iMaxLen=attriVal;
                         if(ComGetLenByByte(sVal) > iMaxLen){
                            sMsg=ComGetMsg('COM12142', sTitle, attriVal);
                            j=99;
                         }
                         break;
                     case "minlength":  
                         if (sVal== "") continue;
                         if(ComGetLenByByte(sVal) < attriVal) {
                            sMsg=ComGetMsg('COM12143', sTitle, attriVal);
                            j=99;
                         }
                         break;
                     case "fullfill":    
                         if (sVal== "") continue;
                         if(ComGetLenByByte(sVal) != iMaxLen) {
                            sMsg=ComGetMsg('COM12174', sTitle, iMaxLen);
                            j=99;
                         }
                         break;
                     case "maxnum":      
                        iMaxVal=attriVal;
                         if (sVal== "") continue;
                         if (!ComIsMoneyNumber(sVal, true, true, true)) {
                             sMsg=ComGetMsg('COM12178');
                            j=99;
                         } else if(!ComIsMoneyNumber(attriVal, true, false, false)) {
                             sMsg="is not valid. Please enter an correct number format. maxnum=" + attriVal;
                            j=99;
                         } else if (parseFloat(sVal) > parseFloat(attriVal)) {
                             sMsg="'" + sTitle + "' have to be less than " + attriVal;
                            j=99;
                         }
                         break;
                     case "minnum":     
                        iMinVal=attriVal;
                         if (sVal== "") continue;
                         if (!ComIsMoneyNumber(sVal, true, true, true)) {
                             sMsg=ComGetMsg('COM12178');
                            j=99;
                         } else if(!ComIsMoneyNumber(attriVal, true, false, false)) {
                             sMsg="is not valid. Please enter an correct number format. minnum=" + attriVal;
                            j=99;
                        } else if (parseFloat(sVal) < parseFloat(attriVal)) {
                             sMsg="'" + sTitle + "' have to be greater than " + attriVal;
                            j=99;
                         }
                         break;
                     case "pointcount":	
                         if (sVal== "") continue;
                         if (!ComIsMoneyNumber(sVal, true, true, true)) {
                             sMsg=ComGetMsg('COM12178');
                            j=99;
                         } else if(!ComIsMoneyNumber(attriVal, false, false, false)) {
                             sMsg="is not valid. Please enter an correct number format. pointcount=" + attriVal;
                            j=99;
                         } else {
                            var iLeftLen=iMaxLen-attriVal-1;
                            var iNum=sVal;
                            var iPointNum=0;
                            if(sVal.indexOf(".") >= 0) {
                                iNum=sVal.split(".")[0];		
                                iPointNum=sVal.split(".")[1];	
                            }
                            if (iPointNum.length > attriVal) {
                                 sMsg="'" + sTitle + "' is not valid decimal point. Please enter a maximum " + attriVal + " decimal point";
                                j=99;
                             } else if (iMaxLen<100 && iLeftLen>0) {
                                if (iMaxVal==null) iMaxVal=eval(ComLpad("9",iLeftLen,"9") + "." + ComLpad("9",attriVal,"9"));
                                if (iMinVal==null) iMinVal=eval("-" + ComLpad("9",iLeftLen,"9") + "." + ComLpad("9",attriVal,"9"));
                                if (parseFloat(iNum) > parseFloat(iMaxVal)) {
                                    sMsg="'" + sTitle + "' have to be less than " +iMaxVal;
                                    j=99;
                                } else if(parseFloat(iNum) < parseFloat(iMinVal)) {
                                    sMsg="'" + sTitle + "' have to be greater than " +iMinVal;
                                    j=99;
                                }
                             }
                         }
                        break;
                     case "cofield":     
                         switch(sFormat) {
                             case "ymd":     //yyyy-mm-dd
                             case "ymdhms":     //yyyy-mm-dd
                             case "ymdhm":     //yyyy-mm-dd
                             case "ym":      //yyyy-mm
                             case "yw":      //yyyy-ww
                             case "yyyy":      //yyyy
                             case "hms":     //hh:mm:ss
                             case "hm":      //hh:mm
                                 var coObj=eval("document.all." + attriVal);
                                 var coVal=ComGetObjValue(coObj);
                                 if (coVal != "" && sVal == "")          
                                     obj.value=coVal;
                                 else if (coVal == "" && sVal != "")    
                                     coObj.value=maskValue;
                                 else { 
                                    var startDate, endDate;
                                    if (obj.sourceIndex < coObj.sourceIndex) {
                                        startDate=maskValue;
                                        endDate=coVal;
                                    } else {
                                        startDate=coVal;
                                        endDate=maskValue;
                                    }
                                    if (startDate > endDate && !CofieldFlag) {
                                        if (obj.sourceIndex < coObj.sourceIndex){
                                            CofieldFlag=true;
                                            sTitle2=(coObj.getAttribute("caption")==null)?"end date":coObj.getAttribute("caption");
                                            sMsg=ComGetMsg("COM12133", "'" + sTitle+ "'", "'" + sTitle2 + "'", "earlier");
                                        } else {
                                            CofieldFlag=false;
                                            sTitle2=(coObj.getAttribute("caption")==null)?"start date":coObj.getAttribute("caption");
                                            sMsg=ComGetMsg("COM12133", "'" + sTitle+ "'", "'" + sTitle2 + "'", "later");
                                        }
                                        j=99;
                                    }else
                                        CofieldFlag=false;
                                 }
                                 break;
                         }
                         break;
                 }
                 if (sMsg!="") {
                    if(event == null){
                        if (bMsg) ComShowMessage(sMsg);
                        obj.focus();
                        obj.select();
                    }else{
                        var canFocusOut=(ComGetEvent() == obj && (sVal=="" || obj.getAttribute("readOnly")==true));
                        if (bMsg && !canFocusOut) ComShowMessage(sMsg);
                        try{
                            if(canFocusOut) {
                                event.returnValue=true;
                            } else {
// 		                    	event.cancelBubble = true;
                                if(pastEventNum == 0){
                                    pastEventNum=1;
                                    pastEventObj=ComGetEvent().name;
                                }else if(pastEventNum ==1){
                                    pastEventNum=2;
                                }else{
                                    pastEventNum=0;
                                    if(pastEventObj == ComGetEvent().name)
                                        event.stopPropagation();
                                }
                                event.returnValue=false;
                                obj.value="0";
                                obj.focus();
                                obj.select();
                                event.stopPropagation( );
                            }
                        } catch(ee) {;}
                    }
                     return false;
                 }
             }
             if (bMasked && sFormat != "") {
                 obj.value=ComGetMaskedValue(obj, sFormat);
             }
         } catch(err) { ComFuncErrMsg(err.message); }
         return true;
	}
     /**
     * Object change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version3
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
                    doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
                } else {
                    formObj.vndr_lgl_eng_nm.value="";
                    formObj.pay_term_dys.value="";
                }
                break;
            case "agmt_iss_ofc_cd":
                if(formObj.agmt_iss_ofc_cd.value != ''){
                    doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
                }
                break;
            case "pay_term_dys":
                if(formObj.pay_term_dys.value !=''){
                    formObj.pay_term_dys.value=Math.abs(formObj.pay_term_dys.value)
                }
                break;
        }
    }
    /**
     * Sheet1 OnSaveEnd event handling (saving)<br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {string} ErrMsg		 String
     * @return 
     * @version 
     */
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
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
        }
    }
    /**
     * Sheet2 OnSaveEnd event handling (deleting) <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {string} ErrMsg		 String
     * @return 
     * @version 
     */
    function sheet2_OnSaveEnd(sheetObj, errMsg) {
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
    /**
     * Agreement Version No Change event. <br>
     * @param  {string} Index_Code mandatory
     * @param  {string} Text mandatory
     * @return 
     * @author 
     * @version9
     */
    function agmt_ver_no_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
        var obj=document.getElementById("btn_Retrieve");
       
        fireEvents(obj,"click");
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
    
    function fireEvents(element,event){
    	
        if (document.createEventObject){
            // dispatch for IE
            var evt = document.createEventObject();
            return element.fireEvent('on'+event,evt)
        }
        else{
        	 
            // dispatch for firefox + others
            var evt = document.createEvent("HTMLEvents");
            evt.initEvent(event, true, true ); // event type,bubbling,cancelable
            
            return !element.dispatchEvent(evt);
        }
    }

    function t3sheet1_OnSearchEnd(sheetObj , code , msg){
    	if( sheetObj.RowCount() < 1) {
    		InitHeadColumn(t3sheet1_leftHeaders,sheetObj);
    	}else {
    		InitHeadText(t3sheet1_leftHeaders,sheetObj);
    	}
	}
    
    function t3sheet2_OnSearchEnd(sheetObj , code , msg){
    	if( sheetObj.RowCount() < 1) {
    		InitHeadColumn(t3sheet2_leftHeaders,sheetObj);
    	}else {
    		InitHeadText(t3sheet2_leftHeaders,sheetObj);
    	}
	}
    
    function t3sheet3_OnSearchEnd(sheetObj , code , msg){
    	if( sheetObj.RowCount() < 1) {
    		InitHeadColumn(t3sheet3_leftHeaders,sheetObj);
    	}else {
    		InitHeadText(t3sheet3_leftHeaders,sheetObj);
    	}
	}    
    /* developer job end */