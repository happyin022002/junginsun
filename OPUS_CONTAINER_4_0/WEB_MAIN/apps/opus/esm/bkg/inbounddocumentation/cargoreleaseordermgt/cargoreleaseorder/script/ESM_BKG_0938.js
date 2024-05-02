/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0938.js
*@FileTitle  : EU Cargo Release (D/O)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * business script for ESM_BKG_0938
	 */
    // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheetNames=new Array("blInfo", "refInfo", "euCstmsInfo", "euDoRlseStsCntr", "euDoRlseStsBl", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "partial", "otsRcvPop");
    var chkRowCnt=0;
    
    var chkRowCount = 0;
    var chkReleaseCount = 0;
    var chkNoReleaseCount = 0;    
    
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
     function processButtonClick(){
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            var releaseYn=fnReleaseYn();
            if(ComGetBtnDisable(srcName)){
            	return false;
            }
                switch(srcName) {
                    case "btn_retrieve":
                        doActionIBSheet(sheetObjects["blInfo"], formObject,IBSEARCH);
                    break;
                    case "btn_save":
                        doActionIBSheet(	sheetObjects["blInfo"], formObject,IBSAVE);
                    break;
                    case "btn_preview":
                        if (releaseYn == false) {
                            // in case of per BL
                            if (formObject.refInfo_do_split_flg.value == "N") {
                                if (sheetObjects["euDoRlseStsBl"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Preview");
                                } else {
                                    //alert message
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG40059", blNo);
                                }
                            } else {
                                if (sheetObjects["euDoRlseStsCntr"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Preview");
                                } else {
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG40071", blNo);
                                }
                            }
                            return;
                        }
                        if (sheetObjects["blInfo"].RowCount()== 0) {
                            ComShowCodeMessage("BKG40060");
                            return;
                        }
                        //get RD Info
                        if (document.form.split_flg[0].checked == true) {
                        	doNo=sheetObjects["euDoRlseStsBl"].GetCellValue(1, "euDoRlseStsBl_do_no");       //per BL
                        } else {
                            doNo=fnFindDoNo();
                            if (doNo == "") {
                                var blNo="";
                                if (sheetObjects["blInfo"].RowCount()> 0) {
                                	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40059", blNo);
                                return;
                            }
                        }
                        var mrdId=formObject.h_mrd_id.value;
                        var mrdParam=formObject.h_mrd_param.value;
                        if(mrdId == ""){
                            ComShowCodeMessage("BKG40080");
                            return;
                        }
                        if(doNo == ""){
                            var blNo="";
                            if (sheetObjects["blInfo"].RowCount()> 0) {
                            	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                            }
                            ComShowCodeMessage("BKG40059", blNo);
                            return;
                        }
                        formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"
                            + mrdId
                            + ".mrd";
                        var strArg="/rv ";
                        strArg += " form_doNo['" + doNo + "']";
                        strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
                        strArg += " form_usrId['" + strUsr_id + "']";
                        strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
                        strArg += " form_ofcCd['" + lginOfcCd + "']";
                        strArg += " " + mrdParam;
                        formObject.com_mrdArguments.value=strArg;
                        formObject.com_mrdTitle.value="EU Cargo Release Order";
                        formObject.com_mrdDisableToolbar.value="";
                        formObject.com_mrdBodyTitle.value="EU Cargo Release Order";
                        ComOpenRDPopup();
                        break;
                    case "btn_release":
                        //Hold Y/N
                    	if (sheetObjects["refInfo"].GetCellValue(1, "refInfo_do_hld_flg") =='Y') {
                            var blNo="";
                            if (sheetObjects["blInfo"].RowCount()> 0) {
                            	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                            }
                            ComShowCodeMessage('BKG40107', blNo, "Release");
                            return;
                        }
                    	//container 별로 hold
                    	var prefix = "euDoRlseStsCntr";
                    	for (var idx=1; idx <= sheetObjects[prefix].LastRow(); idx ++) {
                    		if (sheetObjects[prefix].GetCellValue(idx, prefix+"_cntr_chk") == 1) {
                    		  if (sheetObjects[prefix].GetCellValue(idx, prefix+ "_cntr_hld_flg") == 'Y'){
                    			  ComShowCodeMessage('BKG40108', "Container", "Release");
                                  return;
                    		  }
                    		}
                    	}

                        if (releaseYn == true  || chkReleaseCount > 0) {
                            ComShowCodeMessage("BKG00778");
                            return;
                        }
                        if (document.form.split_flg[0].checked == true) {
                        	
                        	for (var idx=1; idx <= sheetObjects[prefix].LastRow(); idx ++) {
                        		  if (sheetObjects[prefix].GetCellValue(idx, prefix+ "_cntr_hld_flg") == 'Y'){
                        			  ComShowCodeMessage('BKG40108', "Container", "Release");
                                      return;
                        		  }
                        	}
                        	doActionIBSheet(sheetObjects["euDoRlseStsBl"], formObject, MULTI01);
                        } else {
                            if (chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Release");
                                return;
                            }
                            doActionIBSheet(sheetObjects["euDoRlseStsCntr"], formObject, MULTI01);
                        }
                    break;
                    case "btn_cntr_hold":
                        
                    	if (chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "CNTR Hold");
                                return;
                            }
                    	var prefix = "euDoRlseStsCntr";
                    	for (var idx=1; idx <= sheetObjects[prefix].LastRow(); idx ++) {
                    	  if (sheetObjects[prefix].GetCellValue(idx, prefix+"_cntr_chk") == 1) {
                    		if (sheetObjects[prefix].GetCellValue(idx, prefix+ "_cntr_hld_flg") == 'Y'){
                  			  ComShowMessage("This Container already set as hold");
                                return;
                  		  }
                    	}
                  	}
                            
                    	doActionIBSheet(sheetObjects["euDoRlseStsCntr"], formObject, MULTI04);

                    break;
                    
                    case "btn_cntr_unhold":
                     
                    	if (chkRowCnt == 0) {
                            ComShowCodeMessage("BKG40069", "CNTR Hold Removal");
                            return;
                        }
                  	doActionIBSheet(sheetObjects["euDoRlseStsCntr"], formObject, MULTI05);

                  break;
                    //Hold
                    case "btn_hold":
                        if (formObject.blInfo_cntr_prt_flg.value == "Y") {
                            ComShowCodeMessage("BKG40074");
                            return;
                        }
                        doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI03);
                    break;
                    //Un-Hold
                    case "btn_unhold":
                        doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI03);
                    break;
                    //History
                    case "btn_history":
                        //Window Open
                    	var bl_tp_cd=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_tp_cd");
                        if (bl_tp_cd == "B") {
                            bl_tp_cd="";
                        }
                        var condition="?";
                        condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                        condition += "&bl_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                            condition += "&bl_tp_cd="+bl_tp_cd+"&pgmNo=ESM_BKG_0711";
                        ComOpenWindowCenter('ESM_BKG_0711.do'+condition, 'history', 980, 480, false);
                        
                    break;
                    //Form Setting
                    case "btn_form_setup":
                    	var condition="?";
                        condition += "pgmNo=ESM_BKG_0137";
                        condition += "&office="+lginOfcCd;
                    	ComOpenWindowCenter('ESM_BKG_0137_POP.do'+condition, 'setting', 1024, 480, false,"yes");
                    break;
                    //Receiver Info.
                    case "btn_receiverinfo":
                        if (releaseYn == false) {
                            // in case per BL
                            if (formObject.refInfo_do_split_flg.value == "N") {
                                if (sheetObjects["euDoRlseStsBl"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Receiver Info.");
                                } else {
                                    //alert message
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG40059", blNo);
                                }
                            } else {
                                if (sheetObjects["euDoRlseStsCntr"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Receiver Info.");
                                } else {
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG40071", blNo);
                                }
                            }
                            return;
                        }
                        var doNo="";
                        if (document.form.split_flg[0].checked == true) {
                        	doNo=sheetObjects["euDoRlseStsBl"].GetCellValue(1, "euDoRlseStsBl_do_no");       // per BL
                        } else {
                            doNo=fnFindDoNo();
                            if (doNo == "") {
                                var blNo="";
                                if (sheetObjects["blInfo"].RowCount()> 0) {
                                	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40059", blNo);
                                return;
                            }
                        }
                        var condition="?";
                            condition += "do_no="+doNo+"&pgmNo=ESM_BKG_0937";
                        ComOpenWindowCenter('ESM_BKG_0937.do'+condition, 'receiverinfo', 620, 320, true);
                    break;
                    //Cancel
                    case "btn_cancel":
                        //Hold Y/N
                    	if (sheetObjects["refInfo"].GetCellValue(1, "refInfo_do_hld_flg") =='Y') {
                            var blNo="";
                            if (sheetObjects["blInfo"].RowCount()> 0) {
                            	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                            }
                            ComShowCodeMessage('BKG40107', blNo, "Cancel");
                            return;
                        }
                    	
                    	//container 별로 hold
                    	var prefix = "euDoRlseStsCntr";
                    	for (var idx=1; idx <= sheetObjects[prefix].LastRow(); idx ++) {
                    		if (sheetObjects[prefix].GetCellValue(idx, prefix+"_cntr_chk") == 1) {
                    		  if (sheetObjects[prefix].GetCellValue(idx, prefix+ "_cntr_hld_flg") == 'Y'){
                    			  ComShowCodeMessage('BKG40108', "Container", "Cancel");
                                  return;
                    		  }
                    		}
                    	}
                        if (releaseYn == false) {
                            // in case of per BL
                            if (formObject.refInfo_do_split_flg.value == "N") {
                                if (sheetObjects["euDoRlseStsBl"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Cancel");
                                } else {
                                    //alert message
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG40059", blNo);
                                }
                            } else {
                                if (sheetObjects["euDoRlseStsCntr"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Cancel");
                                } else {
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG02120", blNo);
                                }
                            }
                            return;
                        }
                        if (document.form.split_flg[0].checked == true) {
                            doActionIBSheet(sheetObjects["euDoRlseStsBl"], formObject, MULTI02);      // per BL
                        } else {
                            doActionIBSheet(sheetObjects["euDoRlseStsCntr"], formObject, MULTI02);    // per Cntr
                        }
                    break;
                    //Remark
                    case "btn_remark":
                        //Window Open
                       if (releaseYn == false) {
                            //in case of per BL
                            if (formObject.refInfo_do_split_flg.value == "N") {
                                if (sheetObjects["euDoRlseStsBl"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Remark(s)");
                                } else {
                                    //alert message
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG40059", blNo);
                                }
                            } else {
                                if (sheetObjects["euDoRlseStsCntr"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Remark(s)");
                                } else {
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG40071", blNo);
                                }
                            }
                            return;
                        }
                       
                       //get RD Info
                       if (document.form.split_flg[0].checked == true) {
                       	doNo=sheetObjects["euDoRlseStsBl"].GetCellValue(1, "euDoRlseStsBl_do_no");       //per BL
                       } else {
                           doNo=fnFindDoNo();
                       }
                        var condition="?";
                        condition += "do_no="+doNo+"&pgmNo=ESM_BKG_1018";
                        ComOpenWindowCenter('ESM_BKG_1018.do'+condition, 'remark', 530, 230, false);
                    break;
                    //Print
                    case "btn_print":
                        if (releaseYn == false) {
                            //in case of per BL
                            if (formObject.refInfo_do_split_flg.value == "N") {
                                if (sheetObjects["euDoRlseStsBl"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Print");
                                } else {
                                    //alert message
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG40059", blNo);
                                }
                            } else {
                                if (sheetObjects["euDoRlseStsCntr"].RowCount()> 0 && chkRowCnt == 0) {
                                    ComShowCodeMessage("BKG40069", "Print");
                                } else {
                                    var blNo="";
                                    if (sheetObjects["blInfo"].RowCount()> 0) {
                                    	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                    }
                                    ComShowCodeMessage("BKG40071", blNo);
                                }
                            }
                            return;
                        }
                        if (sheetObjects["blInfo"].RowCount()== 0) {
                            ComShowCodeMessage("BKG40060");
                            return;
                        }
                        rdLoad();
                    break;
                    case "img_exp_del_dt":
                        var cal=new ComCalendar();
                        cal.select(formObject.exp_del_dt, 'yyyy-MM-dd');
                    break;
                    case "btn_cct":
                        blOutstandingAmountPopOpen(true);
                    break;
                    case "btn_third_cct":
                        blOutstandingAmountPopOpen(false);
                    break;
                    case "btn_tpb":
                        var frDate=ComGetDateAdd(null, "D", -60);
                        var toDate=ComGetNowInfo("ymd", "");
                        var otsStsCd="";
                        if (document.form.tpb_status.value == "1") {
                            otsStsCd="P";
                        } else {
                            otsStsCd="T";
                        }
                        var condition="?";
                            condition += "s_state=BKG";
                            condition += "&s_bkg_no_all="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                            condition += "&s_bl_no_all="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                            condition += "&s_ots_sts_cd=" + otsStsCd;
                            condition += "&pgmNo=ESD_TPB_0134";
                        ComOpenWindowCenter('ESD_TPB_0134.do'+condition, 'TPB', 1024, 568, true);
                    break;
                    case "btn_bl_surr_rmk":
                        var condition="?";
                        condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                            condition += "&inquery_only=Y"+"&pgmNo=ESM_BKG_0400";
                        ComOpenWindowCenter('ESM_BKG_0400_POP.do'+condition, 'bl_surr_rmk', 900, 300, true);
                    break;
                    //OBL Cancel
                    case "btn_obl_cancel":
                        if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                        oblInit();
                    break;
                    case "btn_dem_retrieve":
                        doActionIBSheet(sheetObjects["blInfo"], formObject,COMMAND05);
                        break;
                    case "btn_dmdt":
                    	var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                    	var blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                        var trfCd=document.getElementById("demur_type").value;
                        var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd+"&pgmNo=EES_DMT_3002P";
                        ComOpenWindowCenter('EES_DMT_3002P.do' + paramVal, 'dmdt', 1050, 670, false,"yes");
                    break;
                    case "btn_f_cntr_rls":
                        var condition="?";
                        condition += "bl_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                            condition += "&pgmNo=ESM_BKG_0272";
                        ComOpenWindowCenter('ESM_BKG_0272_POP.do' + condition, 'f_cntr_rls', 1010, 680, false);
                    break;
                    case "btn_hold_remark":
                        var paramVal="?sheet_name=X&pgmNo=ESM_BKG_1089";
                        ComOpenWindowCenter('ESM_BKG_1089.do' + paramVal, 'remark', 600, 270, false);
                    break;
                    case "btn_close":
                       	ComClosePopup(); 
                     break;  
             } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
     }
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      * @param sheet_obj
      * @return
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheet_obj.id]=sheet_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
    function loadPage() {
    	var formObj=document.form;
    	fnInSetComboBox(formObj.blIss_bl_otr_doc_rcv_cd, evtCode, evtValue, "|", "", "", true, "");
        for(i=0;i<sheetNames.length;i++){
            if(sheetObjects[sheetNames[i]].id =='euDoRlseStsCntr' || sheetObjects[sheetNames[i]].id =='euDoRlseStsBl'|| sheetObjects[sheetNames[i]].id =='demInfo'){
                ComConfigSheet (sheetObjects[sheetNames[i]] );
            }
            initSheet(sheetObjects[sheetNames[i]],i+1);
            if(sheetObjects[sheetNames[i]].id =='euDoRlseStsCntr' || sheetObjects[sheetNames[i]].id =='euDoRlseStsBl'|| sheetObjects[sheetNames[i]].id =='demInfo'){
                ComEndConfigSheet(sheetObjects[sheetNames[i]]);
            }
        }
        initControl();
        // on focus BL no
        ComSetFocus(document.form.bl_no)
        // disable all button except retrieve button
        buttonDisabledAll();
        
        //@ Test Code Start ----------
//		form.bkg_no.value = 'SIN400569300';
		//@ Test Code End   ----------
        if(document.getElementById("bkg_no").value !='' ){
            doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
        }
        
//        initRdConfig(rdObjects[0]);
    }
    
    /**
     * Rd Print setting
     */
    function initRdConfig(rdObject) {
    	var Rdviewer=rdObject;
    	Rdviewer.AutoAdjust=true;
    	Rdviewer.ViewShowMode(0);
    	Rdviewer.IsShowDlg=0;
    	Rdviewer.SetBackgroundColor(128, 128, 128);
    	Rdviewer.ApplyLicense("0.0.0.0");
    	Rdviewer.SetPageLineColor(128, 128, 128);
    	Rdviewer.style.height = 0;
       
    }
    
    /**
     * init control
     */
   function initControl(){
        axon_event.addListenerForm('keydown' , 'obj_keypress'   , form);
        axon_event.addListenerForm('change'   , 'obj_change'     , form);
        axon_event.addListenerForm('click'    , 'obj_click'      , form);
        axon_event.addListenerForm('blur'     , 'obj_deactivate' , form);
        axon_event.addListenerForm('focus'    , 'obj_focus'      , form);
        
        //axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
   }
    /**
     * obj key press event handling
     */
    function obj_keypress(){
        var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var srcName=ComGetEvent("name");
        // Enter key(13)
        if (keyCode == 13 && (srcName == 'bl_no' || srcName == 'bkg_no' || srcName == 'cntr_no')) {
            conditionReset();
            if (srcName == 'cntr_no'){
                 if(!ComChkObjValid(document.form.cntr_no)) {
                     return false;
                 }
                 fnSearchContainer();
            } else {
            	doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
            }
        } // end if
        else if (keyCode == 13 && srcName == 'exp_del_dt') {
            // no retrieve in case of no data
        	if(sheetObjects["blInfo"].GetCellValue(1,"blInfo_bkg_no") != undefined){
                doActionIBSheet(sheetObjects["blInfo"], document.form, COMMAND05);
            }
        }
    }
    /**
     * obj click event handling
     */
    function obj_click(){
        // setting B/L No SelectBox when click 
        if (ComGetEvent("name") == "bl_no") {
            showHideLayers();
        }
    }
   /**
    * obj change event handling
    */
    var onchangeFlag = true;
   function obj_change(){
        var oForm=document.form;
        //trim retrieve condition
        conditionTrim();
        if(ComGetEvent("name") == "bl_no" || ComGetEvent("name") == "bkg_no" ){
        	//@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
        	if(onchangeFlag){
        		conditionReset();
        	}
        }
//        if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
//            return false;
//        }
       if(ComGetEvent("name") == 'blIss_obl_rdem_knt' || ComGetEvent("name") == 'blIss_bl_otr_doc_rcv_cd' || ComGetEvent("name") == 'blIss_otr_doc_cgor_flg'){
            if (ComGetEvent("name") == 'blIss_bl_otr_doc_rcv_cd') {
                if (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex > 0) {
                    document.getElementById("blIss_otr_doc_cgor_flg").disabled=false;
                    document.getElementById("blIss_otr_doc_cgor_flg").value='N';
                } else {
                    document.getElementById("blIss_otr_doc_cgor_flg").selectedIndex=0;
                    document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
                }
            }
            // write history in case of Original Bill of Lading Status N => Y
            if( document.getElementById("blIss_obl_rdem_flg").value =='Y'){
                return;
            }
            // write history when obl cancel or obl clear 
            if(document.getElementById("blIss_obl_rdem_knt").value >0 || (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex > 0 && document.getElementById("blIss_otr_doc_cgor_flg").value =='Y')){
                document.getElementById("obl_cng_flg").value='Y';
                document.getElementById("do_cng_evnt_cd").value='RB';
            }
        }
    }
    /**
     * obj deactivate
     */
    function obj_deactivate(){
        var objName=ComGetEvent("name");
        var formObj=document.form;
        //setting B/L No SelectBox when event
        if(blLayer.style.visibility == "visible"){
            blLayer.style.visibility="hidden";
        }
        /*****************************************
        switch(objName) {
            case "exp_del_dt":
                ComChkObjValid(ComGetEvent());
            break;
        }
        *****************************************/
    }
   /**
    * obj focus event handling
    */
   function obj_focus(){
        var objName=ComGetEvent("name");
        var formObj=document.form;
        switch(objName) {
            
        }
    }
   /**
    * all button disable
    */
   function buttonDisabledAll(){
       ComBtnDisable("btn_obl_cancel");
       //ComBtnDisable("btn_erp");
       ComBtnDisable("btn_dem_retrieve");
       ComBtnDisable("btn_dmdt");
       ComBtnDisable("btn_save");
       ComBtnDisable("btn_hold");
       ComBtnDisable("btn_history");
       ComBtnDisable("btn_preview");
       ComBtnDisable("btn_print");
       ComBtnDisable("btn_remark");
       ComBtnDisable("btn_release");
       ComBtnDisable("btn_cancel");
       //ComBtnDisable("btn_print");
       ComBtnDisable("btn_receiverinfo");
       ComBtnDisable("btn_unhold");
       ComBtnDisable("btn_cct");
       ComBtnDisable("btn_third_cct");
       ComBtnDisable("btn_f_cntr_rls");
       ComBtnDisable("btn_cntr_hold");
       ComBtnDisable("btn_cntr_unhold");
//       document.getElementById("div_btn_bl_surr_flg").style.visibility="hidden";
//       document.getElementById("btn_tpb").style.visibility="hidden";
   }
   /**
    * all button enable
    */
   function buttonEnabledAll(){
        //ComBtnEnable("btn_erp");
        ComBtnEnable("btn_dem_retrieve");
        ComBtnEnable("btn_dmdt");
        ComBtnEnable("btn_save");
        ComBtnEnable("btn_hold");
        ComBtnEnable("btn_history");
        ComBtnEnable("btn_preview");
        ComBtnEnable("btn_print");
        ComBtnEnable("btn_remark");
        ComBtnEnable("btn_release");
        ComBtnEnable("btn_cancel");
        //ComBtnEnable("btn_print");
        ComBtnEnable("btn_receiverinfo");
        ComBtnEnable("btn_unhold");
        
        ComBtnEnable("btn_cntr_hold");
        ComBtnEnable("btn_cntr_unhold");
    }
    /**
     * reset input parameter
     */
    function inputParamReset(){
        for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
            if ( document.form.getElementsByTagName("input")[i].name != "bl_no"   &&
                 document.form.getElementsByTagName("input")[i].name != "cntr_no" &&
                 document.form.getElementsByTagName("input")[i].name != "bkg_no"
                ){
                    document.form.getElementsByTagName("input")[i].value="";
                }
        }
        //init Sheet
        var aryPrefix=new Array("blInfo", "refInfo", "euCstmsInfo", "euDoRlseStsCntr", "euDoRlseStsBl", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "otsRcvPop");
        for(var idx=0; idx < aryPrefix.length; idx++){
            sheetObjects[sheetNames[idx]].RemoveAll();
        }
        document.getElementById("refInfo_inter_rmk").value="";
        document.getElementById("blIss_otr_doc_cgor_flg").value='';
        document.getElementById("blIss_bl_otr_doc_rcv_cd").value='';
        document.getElementById("tot_ots_amt").value='';
        document.getElementById("tot_bil_amt").value='';
    }
     /**
      * setting sheet initial values and header 
      * @param sheetObj
      * @param sheetNo
      * @return
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
         	case "blInfo":
        	    with(sheetObj){
             /*********************************************/
		           var HeadTitle=" |POR|POL|POD|DEL|DELTerm|DELTerm Desc|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|BL TP CD|DSCH_LOC|OBL_ISS_RMK|lcloblissueflg";
		           var headCount=ComCountHeadTitle(HeadTitle);
		           var prefix="blInfo_";
		
		           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"por_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vessel",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"act_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_prt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"soc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_addr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shipper_cust_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shipper_cust_addr", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dsch_loc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lcloblissueflg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(0);
		           SetVisible(false);
             }
             break;
         case "refInfo":
             /****************************************************************
             //13. EU D/O Release Reference Info
             *****************************************************************/
        	 with(sheetObj){
		           var HeadTitle=" |BKG_NO|INTER_RMK|DO_HLD_FLG|CSTMS_REF_NM|CSTMS_REF_CTNT|CSTMS_ASGN_NM|CSTMS_ASGN_CTNT|CY_OP_CD|INFO_CGO_FLG|SPLIT_FLG";
		           var headCount=ComCountHeadTitle(HeadTitle);
		           var prefix="refInfo_";
		
		           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_ref_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"cstms_ref_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cy_op_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"info_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_split_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(0);
		           SetVisible(false);
           	}
        break;
         case "euCstmsInfo":
             /****************************************************************
        	 //14. get B/L Info for EU Customs 
             *****************************************************************/
        	 with(sheetObj){
		           var HeadTitle=" |CSTMS_REF_NM|CSTMS_REF_CTNT|CSTMS_ASGN_NM|CSTMS_ASGN_CTNT";
		           (ComCountHeadTitle(HeadTitle), 0, 0, true);
		           var prefix="euCstmsInfo_";
		
		           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_ref_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"cstms_ref_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(0);
		           SetVisible(false);
             }
         break;
         case "euDoRlseStsBl":
             /****************************************************************
        	 //17. D/O STATUS(ASSIGN, RELEASE, ISSUE) per B/L detail info 
             *****************************************************************/
        	 with(sheetObj){
        	 	var HeadTitle=" |Status|Status|D/O No.|Update Time|User ID|User Name|Office|BKG NO |RLSE STS CTNT";
        	 	var headCount=ComCountHeadTitle(HeadTitle);
			   (headCount, 0, 0, true);
			   var prefix="euDoRlseStsBl_";
			
			   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			
			   var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			
			   var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			  {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			    
			   InitColumns(cols);
			
			   SetEditable(1);
			   SetSheetHeight(130);
         }
         break;
         case "euDoRlseStsCntr":
             /****************************************************************
        	 // D/O STATUS(ASSIGN, RELEASE, ISSUE) per Container detail info
             *****************************************************************/
    	    with(sheetObj){
	             var HeadTitle=" |Check|CNTR No|Release Hold|Release Hold|Status CD|Status|D/O No.|MRN|Empty Return|Update Time|User ID|Hold Time|Hold User ID|OFC CD|Bkg No|STS SEQ|SEQ";
		           var headCount=ComCountHeadTitle(HeadTitle);
		           (headCount, 0, 0, true);
		           var prefix="euDoRlseStsCntr_";
		
		           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                  {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_hld_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_hld_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mvmt_ref_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rtn_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_hld_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_hld_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(1);
		           SetVisible(false);
             }
         break;
         case "blIss":
             /***********************************************************************
        	 //22. Original B/L return and Issue count Detail Info
             ***********************************************************************/
        	 with(sheetObj){
		           (18, 0, 0, true);
		           var HeadTitle=" |BL회수여부|BL발행통수|O/BL ISSUE|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG| | | | | | | | |";
		           var prefix="blIss_";
		
		           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_cpy_knt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_knt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_otr_doc_rcv_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_ofc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_cgor_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_ofc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];

		            
		           InitColumns(cols);
		
		           SetEditable(0);
		           SetVisible(false);
             }
         break;
         case "otsRcvInfo":
             /****************************************************************
        	 //11. fare approval Y/N and Outstanding Amounts Info
             *****************************************************************/
    	    with(sheetObj){
		           var HeadTitle=" |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";
		           var headCount=ComCountHeadTitle(HeadTitle);
		           (headCount, 0, 0, true);
		           var prefix="otsRcvInfo_";
		
		           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(0);
		           SetVisible(false);
             }
         break;
         case "demInfo":
             /****************************************************************
             //DEM.DET I/F
             *****************************************************************/
    	    with(sheetObj){
		           var HeadTitle=" |Seq\n|Container No.|F/T\nOver|Billable\nAmount|Billable\nAmount|Estimate\nFree Time|SAT\nExcl|SUN\nExcl|HOLI\nExcl|Estimate\nPOD LFD|Daily\nDemurrage|Fixed\nFree Time|Fixed\nPOD LFD";
		           (ComCountHeadTitle(HeadTitle), 0, 0, true);
		           var prefix="demInfo_";
		
		           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                  {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fx_ft_ovr_dys", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bil_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						  {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sat_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
						  {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sun_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
					      {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_hol_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_rt_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys_calc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(0);
		           SetSheetHeight(130);
             }
             break;
         case "demDtl":
             /****************************************************************
             //Demurrage per Container
             *****************************************************************/
    	    with(sheetObj){
		           var HeadTitle=" |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";
		           (ComCountHeadTitle(HeadTitle), 0, 0, true);
		           var prefix="demDtl_";
		
		           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_inv_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_ar_if_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"to_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bil_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(0);
		           SetSheetHeight(130);
             }
             break;
         case "totBlbAmt":
             /****************************************************************
             //Total Billable Amount
             *****************************************************************/
    	    with(sheetObj){
		           var HeadTitle1="|curr_cd|tot_bil_amt";
		           var headCount=ComCountHeadTitle(HeadTitle1);
		           (headCount, 0, 0, true);
		           prefix="totBlbAmt_";
		
		           SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_bil_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(1);
		           SetVisible(false);
             }
             break;
         case "partial":
             /****************************************************************
        	 // Partial Container Info
             *****************************************************************/
    	    with(sheetObj){
		           var HeadTitle1="|SEQ||B/L NO.|CNEE NAME|BKG No|BL_TP_CD";
		           var headCount=ComCountHeadTitle(HeadTitle1);
		           (headCount, 0, 0, true);
		           prefix="partial_";
		
		           SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
		                  {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"radio",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cstms_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(1);
		           SetVisible(false);
             }
             break;
         case "otsRcvPop":
             /****************************************************************
             //Total Billable Amount
             *****************************************************************/
    	    with(sheetObj){
		           var HeadTitle1="|OUTSTANDING|OUTSTANDING";
		           var headCount=ComCountHeadTitle(HeadTitle1);
		           (headCount, 0, 0, true);
		           prefix="otsRcvPop_";
		
		           SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_ots_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(1);
		           SetVisible(false);
             }
             break;
         }
     }
    /**
     * Sheet process handling
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        var param="";
        switch(sAction) {
            case IBSEARCH:  //Retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                	return;
                }
                    inputParamReset();
                    buttonDisabledAll();
                    formObj.f_cmd.value=SEARCH;
                    var temp_bl=formObj.bl_no.value;
                    //var temp_bl = "BCN300001300";
                    var temp_bkg=formObj.bkg_no.value;
                    //var temp_bkg ="CSC200097300";
                    formObj.bl_no.value=temp_bl;
                    formObj.bkg_no.value=temp_bkg;
                    // remove BL_TP_CD in case of BL_TP_CD = W or W 
                    if(formObj.bl_no.value !=''){
                        var blNo=formObj.bl_no.value;
                        var suffix=blNo.substring(formObj.bl_no.value.length-1)
                        if(suffix =='W' || suffix =='S'){
                            formObj.bl_no.value=blNo.substring(0, blNo.lastIndexOf(suffix));
                        }
                    }
                    ComOpenWait(true);
                    
                    //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
                    onchangeFlag = false;
                    
                    setTimeout( function () { //@ setTimeout ###########################################################
                    	
			                    	
			                    //Multi Retrieve
			                    var aryPrefix=new Array("blInfo_", "refInfo_", "euCstmsInfo_", "euDoRlseStsCntr_", "euDoRlseStsBl_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix 문자열 배열
			                    param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&demur_type=" + formObj.demur_type.value + "&exp_del_dt=" + formObj.exp_del_dt.value + "&obl_cng_flg=" + formObj.obl_cng_flg.value;
			                    var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0938GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
			                    var arrXml=sXml.split("|$$|");
			                    //ETC DATA transaction
			                    if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
			                        document.getElementById("demur_type").value=ComGetEtcData(arrXml[0], "demurType");
			                    }
			                    if(undefined != ComGetEtcData(arrXml[0], "mrdId") && ComGetEtcData(arrXml[0], "mrdId") != 'null'){
			                        var mrdId=ComGetEtcData(arrXml[0], "mrdId");
			                        var arrMrd=mrdId.split("@@");
			                        document.getElementById("h_mrd_id").value=arrMrd[0];
			                        if (arrMrd.length > 1) {
			                            document.getElementById("h_mrd_param").value=arrMrd[1];
			                        } else {
			                            document.getElementById("h_mrd_param").value="";
			                        }
			                    }
			                    if(undefined != ComGetEtcData(arrXml[0], "localLangFlg") && ComGetEtcData(arrXml[0], "localLangFlg") != 'null'){
			                        document.getElementById("h_local_lang_flg").value=ComGetEtcData(arrXml[0], "localLangFlg");
			                    }
			                    if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
			                        document.getElementById("tpb_status").value=ComGetEtcData(arrXml[0], "tpbStatus");
			                    }
			                    if(undefined != ComGetEtcData(arrXml[0], "splitFlg") && ComGetEtcData(arrXml[0], "splitFlg") != 'null'){
			                        var splitFlg=ComGetEtcData(arrXml[0], "splitFlg");
			                        if (splitFlg == "N") {
			                        	setSplitFlag("N");
			                        	document.form.split_flg[0].checked=true;

			                            //sheetObjects["euDoRlseStsBl"].SetSheetHeight(130);
			                            //sheetObjects["euDoRlseStsCntr"].SetSheetHeight(120);
			                        } else {
			                            //sheetObjects["euDoRlseStsBl"].SetSheetHeight(120);
			                            //sheetObjects["euDoRlseStsCntr"].SetSheetHeight(130);
			                            setSplitFlag("Y");
			                            document.form.split_flg[1].checked=true;

			                        }
			                    }
			                    if(undefined != ComGetEtcData(arrXml[0], "remainCntrCnt") && ComGetEtcData(arrXml[0], "remainCntrCnt") != 'null'){
			                        document.getElementById("remain_cntr_cnt").value=ComGetEtcData(arrXml[0], "remainCntrCnt");
			                    }
			                    for(var idx=0; idx < arrXml.length; idx++){
			                        
			                        if(idx > 0) {
			                            sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
			                        }
			                        sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1} );
			                        
			                    }
                    
			                  //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
			                    onchangeFlag = true;
			                    
			                  //@releaseRemarkFlag 초기화 한다. 
								releaseRemarkFlag =false;

                   } , 100);//@ setTimeout end ###########################################################
            break;
            case COMMAND05: //DEM Retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                	return;
                }
                
                	//check retrieve condition
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }
                    formObj.f_cmd.value=SEARCH;
                    var temp_bl=formObj.bl_no.value;
                    var temp_bkg=formObj.bkg_no.value;
                    ComOpenWait(true);
                    formObj.bl_no.value=temp_bl;
                    formObj.bkg_no.value=temp_bkg;
                    
                    setTimeout( function () { //@ setTimeout ###########################################################                    
		                    //Multi Retrieve
		                    var aryPrefix=new Array("blInfo_", "refInfo_", "euCstmsInfo_", "euDoRlseStsCntr_", "euDoRlseStsBl_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix 문자열 배열
		                    param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&demur_type=" + formObj.demur_type.value + "&exp_del_dt=" + formObj.exp_del_dt.value + "&obl_cng_flg=" + formObj.obl_cng_flg.value;
		                    var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0938GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
		                    var arrXml=sXml.split("|$$|");
		                    for(var idx=7; idx < arrXml.length; idx++){
		                        
		                        if(idx > 0) {
		                            sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
		                        }
		                        sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1} );
		                        
		                    }
		                    //ETC DATA transaction
		                    if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
		                        document.getElementById("demur_type").value=ComGetEtcData(arrXml[0], "demurType");
		                    }
		                    
                    } , 100);//@ setTimeout end ###########################################################
            break;
            case IBSAVE:    //Save
                if(validateForm(sheetObj, formObj, sAction)){
                	// check retrieve condition
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }
                    formObj.f_cmd.value=MODIFY;
                    if (document.form.split_flg[0].checked == true) {
                        document.form.refInfo_do_split_flg.value="N";
                    } else {
                      document.form.refInfo_do_split_flg.value="Y";
                    }
                    CopyFormToRow(formObj, sheetObjects["refInfo"], 1, "");
                    CopyFormToRow(formObj, sheetObjects["blIss"], 1, "");
                    CopyFormToRow(formObj, sheetObjects["euCstmsInfo"], 1, "");
                    var sParam1=sheetObjects["refInfo"].GetSaveString(true, false);     //EU D/O Release Reference Info
                    var sParam2=sheetObjects["blIss"].GetSaveString(true, false);       //Original B/L return Y/N, Issue count and Detail Info
                    var sParam3=sheetObjects["euCstmsInfo"].GetSaveString(true, false); //B/L INFO
                    // check grid change Y/N
                    if(! sheetObjects["refInfo"].IsDataModified()&& ! sheetObjects["blIss"].IsDataModified()&& ! sheetObjects["euCstmsInfo"].IsDataModified()){
                        ComShowCodeMessage('BKG00743');
                        return false;
                    }
                    var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                    if( !ComShowCodeConfirm('COM12147') ){
                        return false;
                    }
                    var aryPrefix=new Array("refInfo_", "blIss_", "euCstmsInfo_");
                    var sparam=sParam1 + "&" + sParam2 + "&" + sParam3 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                    var sXml=sheetObj.GetSaveData("ESM_BKG_0938GS.do", sparam);
                    sheetObjects["refInfo"].LoadSaveData(sXml);
                    sXml=ComDeleteMsg(sXml);
                }
            break;
            case MULTI01: // Release
                if(!validateForm(sheetObj, formObj, sAction)){
                	return ;
                }
                
                	//	GAP Display Credit Risk (2014.10.14 An Jin Eung)
	            	if(!fnExistBlackListedCustomer(formObj.bkg_no.value)){
//	                    return false;
	                }                
                	
                    //Are you sure to Release?
                    if(!ComShowCodeConfirm('BKG00673')){
                        return false;
                    }
                    
                    if (document.form.split_flg[0].checked == true) {
                        document.form.refInfo_do_split_flg.value="N";
                    } else {
                        document.form.refInfo_do_split_flg.value="Y";
                    }
                    if (sheetObjects["refInfo"].RowCount()> 0) {
                    	document.form.refInfo_do_hld_flg.value=sheetObjects["refInfo"].GetCellValue(1, "refInfo_do_hld_flg");
                    } else {
                        document.form.refInfo_do_hld_flg.value="N";
                    }
                    formObj.f_cmd.value=MULTI01;
                    if (document.form.split_flg[0].checked == true) {     //per BL
                    sheetObjects["euDoRlseStsBl"].SetRowStatus(1,"U");
                        var aryPrefix=new Array("euDoRlseStsBl_", "euDoRlseStsCntr_");
                        var sParam1=sheetObjects["euDoRlseStsBl"].GetSaveString();
                        var sParam2=sheetObjects["euDoRlseStsCntr"].GetSaveString();
                        var sparam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                        var sXml=sheetObj.GetSaveData("ESM_BKG_0938GS.do", sparam);
                        sheetObjects["euDoRlseStsBl"].LoadSaveData(sXml, {Sync:1} );
                        sXml=ComDeleteMsg(sXml); 
                    } else {
                        var aryPrefix=new Array("euDoRlseStsBl_", "euDoRlseStsCntr_");
                        var sParam1=sheetObjects["euDoRlseStsBl"].GetSaveString();
                        var sParam2=sheetObjects["euDoRlseStsCntr"].GetSaveString();
                        var sparam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                        var sXml=sheetObj.GetSaveData("ESM_BKG_0938GS.do", sparam);
                        sheetObjects["euDoRlseStsCntr"].LoadSaveData(sXml, {Sync:1} );
                        sXml=ComDeleteMsg(sXml); 
                    }

            break;
            case MULTI02: // Cancel
	        	//check retrieve condition
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
                //Are you sure to Cancel?
                if(!ComShowCodeConfirm('BKG00670')){
                    return false;
                }
                formObj.f_cmd.value=MULTI02;
                if (document.form.split_flg[0].checked == true) {
                      document.form.refInfo_do_split_flg.value="N";
                } else {
                      document.form.refInfo_do_split_flg.value="Y";
                }
                if (document.form.split_flg[0].checked == true) {     //per BL
                	sheetObjects["euDoRlseStsBl"].SetRowStatus(1,"U");
                    sheetObj.DoSave("ESM_BKG_0938GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("euDoRlseStsBl_"),-1,0);
                } else {
                    var aryPrefix=new Array("euDoRlseStsCntr_");
                    var sParam1=sheetObjects["euDoRlseStsCntr"].GetSaveString();
                    var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                    var sXml=sheetObj.GetSaveData("ESM_BKG_0938GS.do", sparam);
                    sheetObjects["euDoRlseStsCntr"].LoadSaveData(sXml);
                    sXml=ComDeleteMsg(sXml); 
                }
            break;
            case MULTI03: // Hold
	        	//check retrieve condition
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
            	if(document.getElementById("evnt_flag").value =='H'){
                    //Are you sure to Hold?
                    if(!ComShowCodeConfirm('BKG00671')){
                        return false;
                    }
                }
                formObj.f_cmd.value=MULTI03;
                var aryPrefix=new Array("blInfo_");
                var sParam1=sheetObjects["blInfo"].GetSaveString(true);
                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                var sXml=sheetObj.GetSaveData("ESM_BKG_0938GS.do", sparam);
                sheetObjects["blInfo"].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);  
            break;
            case MULTI04: // Hold by Container
                if(!validateForm(sheetObj, formObj, sAction)){
                	return ;
                }
 
                    formObj.f_cmd.value=MULTI04;
                  
                        var aryPrefix=new Array("euDoRlseStsBl_", "euDoRlseStsCntr_");
                        var sParam1=sheetObjects["euDoRlseStsBl"].GetSaveString();
                        var sParam2=sheetObjects["euDoRlseStsCntr"].GetSaveString();
                        var sparam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                        var sXml=sheetObj.GetSaveData("ESM_BKG_0938GS.do", sparam);
                        sheetObjects["euDoRlseStsCntr"].LoadSaveData(sXml, {Sync:1} );
                        sXml=ComDeleteMsg(sXml); 
                    

            break;
            case MULTI05: // Hold Removal by Container
                if(!validateForm(sheetObj, formObj, sAction)){
                	return ;
                }
 
                    formObj.f_cmd.value=MULTI05;
                  
                        var aryPrefix=new Array("euDoRlseStsBl_", "euDoRlseStsCntr_");
                        var sParam1=sheetObjects["euDoRlseStsBl"].GetSaveString();
                        var sParam2=sheetObjects["euDoRlseStsCntr"].GetSaveString();
                        var sparam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                        var sXml=sheetObj.GetSaveData("ESM_BKG_0938GS.do", sparam);
                        sheetObjects["euDoRlseStsCntr"].LoadSaveData(sXml, {Sync:1} );
                        sXml=ComDeleteMsg(sXml); 
                    

            break;
        }
    }
    /**
     * handling process for input validation
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function validateForm(sheetObj, formObj, sAction){
        var oForm=document.form;
        if(sAction ==IBSAVE){
            if(document.getElementById("blIss_obl_cpy_knt").value < parseInt(document.getElementById("blIss_obl_rdem_knt").value)){
                //The number of B/L Received you inputted is bigger than B/Ls released in B/L Issue Screen.\nYou have input the number in Received field less or the same number of B/L Released.
                ComShowCodeMessage('BKG40065');
                document.getElementById("blIss_obl_rdem_knt").focus();
                return false;
            }
        }else if(sAction ==IBSEARCH){
            //trim retrieve condition
            conditionTrim();
            if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.bkg_no)){
                ComShowCodeMessage('BKG40097');
                ComSetFocus(oForm.bl_no)
                return false;
            }
            if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
                return false;
            }
        }else if(sAction == MULTI01){
            if(document.getElementById("blIss_obl_rdem_flg").value == "N"){
                //'Orgin B/L not released!
                ComShowCodeMessage('BKG40066');
                return false;
            }
            
          //check retrieve condition
        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
            //Freight Received Status Y가 아니면 Remark for Release를 필수로 남겨야 한다.
            // leave Remark for Release in case of Freight Received Status != Y
			if(document.getElementById("otsRcvInfo_tot_ots_sts_cd").value == 'N'){
                if(!remarkForReleasePop()){
                    return false;
                }
            }
			
			            
        //DEM.DET Retrieve
        }else if(sAction == COMMAND05){
        	var dateget = formObj.exp_del_dt.value; 
            var toDay=ComGetNowInfo('ymd','-').replace(eval("/-/gi"), "");
            var expDelDt=dateget.replace(eval("/-/gi"), "");
            if(toDay > expDelDt){
                ComShowCodeMessage('BKG40114', expDelDt);
                return false;
            }
        }
        return true;
    }
    /**
     * call B/L No Popup in case of Container partial
     */
    function blSelectPopOpen(){
        var sXml=IBS_GetDataSearchXml(sheetObjects["partial"]);
        document.form.xmlData.value=sXml;
        ComOpenPopup("/opuscntr/ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
    }
    /**
     * setting BKG NO from B/L no Select box
     * @param idx
     * @return
     */
    function blNoSelect(idx){
		document.getElementById("bkg_no").value=sheetObjects["partial"].GetCellValue(idx, "partial_"+"bkg_no");
		document.getElementById("bl_no").value=sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_no")+sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_tp_cd");
        var length=document.getElementsByName("hdn_bl_no").length;
        if(document.getElementsByName("hdn_bl_no").length > 1){
            for(var i=1; i<=length; i++){
                if(i==idx){
                    document.all.hdn_bl_no[i-1].style.backgroundColor='rgb(49,106,197)';
                    document.all.hdn_bl_no[i-1].style.color='#FFFFFF';
                }else{
                    document.all.hdn_bl_no[i-1].style.backgroundColor='#FFFFFF';
                    document.all.hdn_bl_no[i-1].style.color='black';
                }
            }
        }
    }
    /**************************************************************
        TRIC SELECT BOX CODE START
    **************************************************************/
    /**
     * deactivate event process.
     **/
    function showHideLayers() {
        var el=ComGetEvent();
        if(el.tagName.toLowerCase() !='input'){
            return;
        }
        var rect=el.getBoundingClientRect();
        var blLayer = document.getElementById("blLayer");
        $('#blLayer').height((20 + (15 * sheetObjects["partial"].RowCount()) + 3) + 'px')
                     .css('top', (rect.top + 25) + 'px')
                     .css('left', rect.left + 'px')
                     .css('border-color', rgbToHex($(el).css('borderTopColor')))
                     .css('width', (rect.width - 2) + 'px');
        if(blLayer.style.visibility == "visible"){
            blLayer.style.visibility="hidden";
        }else{
            blLayer.style.visibility="visible";
        }
    }
    
    /**
     * Convert rgb color to hex
     * @param val - rgb(r, g, b)
     */
    function rgbToHex(rgbString) {
    	var parts = rgbString.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
    	delete(parts[0]);
    	for (var i = 1; i <= 3; ++i) {
    	    parts[i] = parseInt(parts[i]).toString(16);
    	    if (parts[i].length == 1) parts[i] = '0' + parts[i];
    	} 
    	return '#' + parts.join('').toUpperCase();
    }
    /**
     * draw TRiC SELECT BOX
     * @param aryPopupData
     * @return
     */
    function conditionSet(aryPopupData){
        if(aryPopupData != undefined){
            document.getElementById("bl_no").value=aryPopupData[0][3]+aryPopupData[0][6];
            document.getElementById("bkg_no").value=aryPopupData[0][5];
        }
        tbl=document.createElement("TABLE");
        tbl.id='oTbl';
        tbl.border="0";
        tbody=document.createElement("TBODY");
        tbl.insertBefore(tbody, null);
        blLayer.insertBefore(tbl);
        for (idx=1; idx<=sheetObjects["partial"].RowCount(); idx++) {
            tr=document.createElement("TR");
            td=document.createElement("TD");
            if(document.getElementById("bl_no").value == sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_no")){
            	text=document.createElement("<input type=text value='"+sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_no")+sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_tp_cd")+"' readonly style='border:0; height:15;background-color:rgb(49,106,197);COLOR:#FFFFFF' onmouseover=blNoSelect("+idx+"); onclick=blNoSelect("+idx+")>");
            }else{
            	text=document.createElement("<input type=text valuE='"+sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_no")+sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_tp_cd")+"' readonly style='border:0; height:15;' onmouseover=blNoSelect("+idx+"); onclick=blNoSelect("+idx+")>");
            }
            text.id="hdn_bl_no";
            td.insertBefore(text);
            tr.insertBefore(td);
            tbody.insertBefore(tr);
            text.className="input";
        }
        // on focus BL no
        ComSetFocus(document.form.bl_no)
    }
    /**
     * init BKG_NO. CNTR_NO in case of typing B/L No.
     */
    function conditionReset(){
        if (ComGetEvent('name') == "bl_no") {
            document.getElementById("bkg_no").value='';
            document.getElementById("blInfo_split_flg").value='';
            document.getElementById("cntr_no").value='';
            document.getElementById("h_cntr_no").value='';
        }else if (ComGetEvent('name') == "bkg_no") {
            document.getElementById("bl_no").value='';
            document.getElementById("cntr_no").value='';
            document.getElementById("h_cntr_no").value='';
        }else if (ComGetEvent('name') == "cntr_no") {
            document.getElementById("bl_no").value='';
            document.getElementById("bkg_no").value='';
            document.getElementById("blInfo_split_flg").value='';
            document.getElementById("h_cntr_no").value='';
        }
        if(ComGetEvent('name') == "bkg_no" ){
            try {
                oTbl.removeNode(true);
            }catch(e){}
        }
    }
    /**
     * trim condition
     */
    function conditionTrim(){
        document.getElementById("bl_no").value=document.getElementById("bl_no").value.trim();
        document.getElementById("bkg_no").value=document.getElementById("bkg_no").value.trim();
        document.getElementById("cntr_no").value=document.getElementById("cntr_no").value.trim();
    }
    /**
     * setting by O/BL Received 
     * @param obj
     * @return
     */
    function obl_rdem_knt_change(obj){
        var sheetObj=sheetObjects["blIss"];
        if (sheetObj.LastRow()== 0 ) {return;}
		var blTpCd=sheetObj.GetCellValue(1, "blIss_bl_tp_cd");
		var oblRedmFlg=sheetObj.GetCellValue(1, "blIss_obl_rdem_flg");
		var delCntCd=sheetObj.GetCellValue(1, "blIss_del_cnt_cd");
        if (blTpCd == "S" || blTpCd == "W") {
            // Way Bill, Surrendered can't cancel OB/L
            ComBtnDisable("btn_obl_cancel");
            document.getElementById("blIss_obl_rdem_knt").disabled=true;
            document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled=true;
            document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
        } else if (document.form.blIss_obl_rdem_flg.value == "Y") {
            ComBtnEnable("btn_obl_cancel");
            document.getElementById("blIss_obl_rdem_knt").disabled=false;
            document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled=true;
            document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
        } else {
            ComBtnDisable("btn_obl_cancel");
            document.getElementById("blIss_obl_rdem_knt").disabled=false;
            document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled=false;
            if (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex > 0) {
                document.getElementById("blIss_otr_doc_cgor_flg").disabled=false;
            } else {
                document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
            }
        }
    }
      /**
       * composite select box from ERP data
       * @param sheetObj
       * @return
       */
      function addSel(sheetObj) {
          var sel=document.form.tot_ots_amt;
          var prefix="otsRcvInfo_";
          for (i=sel.length-1; i>=0; i--){
              sel.options[i]=null
          }
          if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='Y' || sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='C'){
              // btn_cct disable
              document.getElementById("div_btn_cct").style.visibility="hidden";
              document.getElementById("div_btn_third_cct").style.visibility="hidden";
          } else if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='N'){
              // btn_cct, div_btn_third_cct visible
        	  if (sheetObj.GetCellValue(1, prefix+"cct_ots_curr_cd1") == "N") {
                document.getElementById("div_btn_cct").style.visibility="visible";
              }else {
                document.getElementById("div_btn_cct").style.visibility="hidden";
              }
        	  if (sheetObj.GetCellValue(1, prefix+"n3pty_cct_ots_curr_cd1") == "N") {
                document.getElementById("div_btn_third_cct").style.visibility="visible";
              } else {
                document.getElementById("div_btn_third_cct").style.visibility="hidden";
              }
          } else {
        	  document.form['tot_ots_amt'][0]=new Option(sheetObj.GetCellValue(1, prefix+"tot_ots_amt1"));
        	  document.getElementById("tot_ots_amt").className="input2_1";
              // btn_cct disable
              document.getElementById("div_btn_cct").style.visibility="hidden";
              document.getElementById("div_btn_third_cct").style.visibility="hidden";
              return;
          }
          var unit="";
          var amount="";
          var colorFlg="";
          for (j=0; j<5; j++){
        	  unit=sheetObj.GetCellValue(1, "otsRcvInfo_"+"tot_ots_curr_cd"+parseInt(j+1));
        	  amount=sheetObj.GetCellValue(1, "otsRcvInfo_"+"tot_ots_amt"+parseInt(j+1));
              if(! ComIsEmpty(unit)){
	            	if (amount > 0) {
	            		colorFlg="Y";
	            	}
              	    document.form['tot_ots_amt'][j]=new Option(unit+' '+ComAddCommaRun(amount), j);                
              }
          }
          if (colorFlg == "Y") {
          	//setting font : red and bold
          	document.getElementById("tot_ots_amt").className="input2_1";
          } else {
          	document.getElementById("tot_ots_amt").className="input2";
          }
      }
      /**
       * composite image and setting code by TPB data
       * @param tpbStatus
       * @return
       */
      function tpbImgSet(tpbStatus) {
          if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;
          if(document.getElementById("tpb_status").value == "1"){
              document.getElementById("tpb_icon").src="img/btng_icon_green.gif";
              document.getElementById("tpb_cd").value='C';
              document.getElementById("btn_tpb").style.visibility="visible";
              //tooltip C=Cleared
            document.getElementById("tpb_cd").setAttribute("title", "Cleared");
          }else if(document.getElementById("tpb_status").value == "0"){
              document.getElementById("tpb_icon").src="img/btng_icon_r.gif";
              document.getElementById("tpb_cd").value='P';
              document.getElementById("btn_tpb").style.visibility="visible";
              //tooltip P=Processing
            document.getElementById("tpb_cd").setAttribute("title", "Processing");
          }else{
              document.getElementById("tpb_icon").src="img/btng_icon_g.gif";
              document.getElementById("tpb_cd").value='';
              document.getElementById("btn_tpb").style.visibility="hidden";
              document.getElementById("tpb_cd").removeAttribute("title");
          }
      }
    /**
     * init OBL data
     */
    function oblInit(){
        if (document.getElementById("blIss_obl_rdem_flg").value != "Y" ) {
            // init in case of blIss_obl_rdem_flg = Y
            return;
        }
        document.getElementById("blIss_otr_doc_cgor_flg").value='';
        document.getElementById("blIss_bl_otr_doc_rcv_cd").value='';
        document.getElementById("blIss_obl_rdem_knt").value='0';
        document.getElementById("blIss_obl_rdem_ofc_cd").value='';
        document.getElementById("blIss_obl_rdem_usr_id").value='';
        document.getElementById("blIss_obl_rdem_dt").value='';
        document.getElementById("bl_surr_rmk_flg").value='';
        document.getElementById("blIss_otr_doc_rcv_ofc_cd").value='';
        document.getElementById("blIss_otr_doc_rcv_usr_id").value='';
        document.getElementById("blIss_otr_doc_rcv_dt").value='';
        //CR : Cancelled O/BL Received
        document.getElementById("do_cng_evnt_cd").value='CR';
        //value of D/O EVENT before change
        document.getElementById("pre_ctnt").value='N';
        //value of D/O EVENT before change
        document.getElementById("crnt_ctnt").value='Y';
        //OBL change Y/N setting 'Y'
        document.getElementById("obl_cng_flg").value='Y';
        //OB/L Redemption flg setting 'N'
        document.getElementById("blIss_obl_rdem_flg").value="N";
        // OBL Receive, Oth doc, inbound doc receive enable/disable status transaction
        obl_rdem_knt_change(document.getElementById("blIss_obl_rdem_knt"));
        // button disable
        ComBtnDisable("btn_obl_cancel");
      }
      /************************************************************************************
          IBSHEET OnSaveEnd Event Process Start
      ************************************************************************************/
      /**
       * handling process after ending refInfo save
       * @param sheetObj
       * @param ErrMsg
       * @return
       */
      function refInfo_OnSaveEnd(sheetObj, ErrMsg){
              doActionIBSheet(sheetObj, document.form,IBSEARCH);
      }
      /**
       * handling process after ending euDoRlseStsCntr save
       * @param sheetObj
       * @param ErrMsg
       * @return
       */
      function euDoRlseStsCntr_OnSaveEnd(sheetObj, ErrMsg){
              doActionIBSheet(sheetObj, document.form,IBSEARCH);
      }
     /**
      * handling process after ending euDoRlseStsBl save
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
     function euDoRlseStsBl_OnSaveEnd(sheetObj, ErrMsg){
             doActionIBSheet(sheetObj, document.form,IBSEARCH);
     }
      /************************************************************************************
      /************************************************************************************
          IBSHEET OnSearchEnd Event Process Start
      ************************************************************************************/
    /**
     * handling process after ending partial retrieve
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function partial_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            try {
                oTbl.removeNode(true);
            }catch(e){}
            if(sheetObj.RowCount()> 1){
                blSelectPopOpen();
            }else if(sheetObj.RowCount()== 1){
            	document.getElementById("bl_no").value=sheetObjects["partial"].GetCellValue(1, "partial_"+"bl_no")+sheetObjects["partial"].GetCellValue(1, "partial_"+"bl_tp_cd");
            	document.getElementById("bkg_no").value=sheetObjects["partial"].GetCellValue(1, "partial_"+"bkg_no");
                conditionSet();
                doActionIBSheet(sheetObjects["blInfo"], document.form ,IBSEARCH);
            }else{
                sheetObjects["partial"].RemoveAll();
                ComShowCodeMessage('BKG00379');
            }
        }
    }
    /**
     * handling process after ending blInfo save
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function blInfo_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
    /**
     * handling process after ending blInfo retrieve
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function blInfo_OnSearchEnd(sheetObj, ErrMsg){
        //Wait Image Show Hidden
        ComOpenWait(false);
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
                //ComBtnEnable("btn_save");
                //ComBtnEnable("btn_hold");
                //F/CNTR RLS
                ComBtnEnable("btn_f_cntr_rls");
                //Retrieve condition
                document.getElementById("bkg_no").value=sheetObj.GetCellValue(1,"blInfo_bkg_no");
                //append BL_TP_CD to the BL_NO
                if(sheetObj.GetCellValue(1,"blInfo_bl_tp_cd") !='B'){
                	document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no")+sheetObj.GetCellValue(1,"blInfo_bl_tp_cd");
                }else{
                	document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no");
                }
            }
            /*************************************************************
                TPB Setting  Start 0 : Red 1 : Green -1 : Gray
            *************************************************************/
            tpbImgSet(document.getElementById("tpb_status").value);
            //ComBtnEnable("btn_erp");
            //ComBtnEnable("btn_dem_retrieve");
            //ComBtnEnable("btn_dmdt");
            //ComBtnEnable("btn_history");
            buttonEnabledAll();
            if (sheetObj.GetCellValue(1,"blInfo_lcloblissueflg") == "Y") {
            	ComShowCodeMessage("BKG00667");
            }
            if (document.getElementById("blInfo_cntr_prt_flg").value == "Y") {
            	//font setting : red and bold
            	document.getElementById("blInfo_cntr_prt_flg").style.color="red";            	
            	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="bold";
            } else {
            	document.getElementById("blInfo_cntr_prt_flg").style.color="";
            	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="normal";
            }
            if (document.getElementById("blInfo_soc_flg").value == "Y") {
            	//font setting : red and bold
            	document.getElementById("blInfo_soc_flg").style.color="red";            	
            	document.getElementById("blInfo_soc_flg").style.fontWeight="bold";
            } else {
            	document.getElementById("blInfo_soc_flg").style.color="";
            	document.getElementById("blInfo_soc_flg").style.fontWeight="normal";
            }
            
            document.form.split_flg[0].disabled=false;
            document.form.split_flg[1].disabled=false;
            
            if (document.form.split_flg[0].checked == true) {
            	document.getElementById("div_cntr_hold_btn").style.display="none";  
                document.getElementById("div_cntr_unhold_btn").style.display="none";
                
         
                if(sheetObjects["refInfo"].GetCellValue(1, "refInfo_do_hld_flg") =="N"){
                    document.getElementById("div_hold_btn").style.display="";
                    document.getElementById("div_unhold_btn").style.display="none";
                }else if(sheetObjects["refInfo"].GetCellValue(1, "refInfo_do_hld_flg") =="Y"){
                    document.getElementById("div_hold_btn").style.display="none";
                    document.getElementById("div_unhold_btn").style.display="";
                }
            }else if(document.form.split_flg[1].checked == true){
            	document.getElementById("div_cntr_hold_btn").style.display="";  
                document.getElementById("div_cntr_unhold_btn").style.display="";
                document.getElementById("div_hold_btn").style.display="none"; 
                document.getElementById("div_unhold_btn").style.display="none"; 
            }
            
        }else{
            //init sheet when error
            var resetSheetNames=new Array("blInfo", "refInfo", "euCstmsInfo", "euDoRlseStsCntr", "euDoRlseStsBl", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "otsRcvPop");
            for(var idx=0; idx < resetSheetNames.length; idx++){
                sheetObjects[resetSheetNames[idx]].RemoveAll();
            }
        }
    }
      /**
       * handling process after ending refInfo retrieve
       * @param sheetObj
       * @param ErrMsg
       * @return
       */
      function refInfo_OnSearchEnd(sheetObj, ErrMsg){
          if (ErrMsg == "") {
              if(sheetObj.RowCount()> 0){
            	  if (sheetObj.GetCellValue(1, "refInfo_do_hld_flg") == "") {
                      sheetObj.SetCellValue(1, "refInfo_do_hld_flg","N",0);
                  }
                  ComCopyRowToForm(sheetObj, 1, form, "");
                  if(sheetObj.GetCellValue(1, "refInfo_do_hld_flg") =="N"){
                      document.getElementById("hold_flag").className="input2";
                      document.getElementById("evnt_flag").value="H";
                      if (document.form.split_flg[0].checked == true) {
                      document.getElementById("div_hold_btn").style.display="";
                      document.getElementById("div_unhold_btn").style.display="none";
                      }
                  }else if(sheetObj.GetCellValue(1, "refInfo_do_hld_flg") =="Y"){
                      document.getElementById("hold_flag").className="input2_1";
                      document.getElementById("hold_flag").value="Hold";
                      document.getElementById("evnt_flag").value="R";
                      if (document.form.split_flg[0].checked == true) {
                      document.getElementById("div_hold_btn").style.display="none";
                      document.getElementById("div_unhold_btn").style.display="";
                      }
                  }
                  //setting DO Split Flg
                  if (sheetObj.GetCellValue(1, "refInfo_do_split_flg") ==  "Y") {
                    document.getElementById("div_remain_cnt").style.visibility="visible";
                  } else {
                    document.getElementById("div_remain_cnt").style.visibility="hidden";
                  }
                  
                  chkRemark();
              }
          }
      }
      /**
       * handling process after ending blIss retrieve
       * @param sheetObj
       * @param ErrMsg
       * @return
       */
      function blIss_OnSearchEnd(sheetObj, ErrMsg){
          if (ErrMsg == "") {
              if(sheetObj.RowCount()> 0){
                  ComCopyRowToForm(sheetObj, 1, form, "");
              }
              if (document.form.blIss_bl_tp_cd.value == "") {
                  document.form.blIss_bl_tp_cd.value="B";
              }
              if( document.getElementById("blIss_obl_rdem_flg").value =='Y'){
                  document.getElementById("blIss_obl_rdem_flg").style.color='blue';
              }else if(document.getElementById("blIss_obl_rdem_flg").value =='N'){
                  document.getElementById("blIss_obl_rdem_flg").style.color='red';
              }
              document.getElementById("h_ori_obl_rdem_flg").value=document.getElementById("blIss_obl_rdem_flg").value;
              document.getElementById("h_aft_obl_rdem_flg").value=document.getElementById("blIss_obl_rdem_flg").value;
              document.getElementById("pre_ctnt").value=document.getElementById("blIss_obl_rdem_knt").value;
                  obl_rdem_knt_change(document.getElementById("blIss_obl_rdem_knt"))
                  if (sheetObj.GetCellValue(1, "blIss_bl_tp_cd") == "S") {
                    document.getElementById("bl_surr_rmk_flg").value="Y";
                    document.getElementById("div_btn_bl_surr_flg").style.visibility="visible";
                  } else {
                    document.getElementById("bl_surr_rmk_flg").value="";
                    document.getElementById("div_btn_bl_surr_flg").style.visibility="hidden";
                  }
          }
          //setting value of O/BL Received before chage
          document.getElementById("old_obl_rdem_knt").value=sheetObj.GetCellValue(1, "blIss_obl_rdem_knt");
          //OBL Cancel button enable
//          ComBtnEnable("btn_obl_cancel");
      }
      /**
       * handling process after ending demDtl retrieve
       * @param sheetObj
       * @return
       */
      function demDtl_OnSearchEnd(sheetObj){
          var invTotBilAmt=0;
          //first Container Info
          var fist_cntr_no=sheetObjects["demInfo"].GetCellValue(1, "demInfo_cntr_no");
          for(var idx=1; idx <= sheetObj.RowCount(); idx++){
        	  if(fist_cntr_no != sheetObjects["demDtl"].GetCellValue(idx, "demDtl_cntr_no")){
                  sheetObjects["demDtl"].SetRowHidden(idx,1);
              }
              // Logic Add by SC: invTotBilAmt += parseInt(sheetObjects["demDtl"].CellValue(idx, "demDtl_bil_amt"));
          }
          // Logic Add by SC:  document.getElementById("invTotBilAmt").value = invTotBilAmt;
      }
    /**
     * handling process after ending totBlbAmt retrieve
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function totBlbAmt_OnSearchEnd(sheetObj, ErrMsg){
        var sel=document.form.tot_bil_amt;
        //SELECT BOX Init
        for (i=sel.length-1; i>=0; i--){
            sel.options[i]=null
        }
        var currCd="";
        var bilAmt="";
        var demSts=false;
        if (sheetObj.RowCount()> 0) {
            for (j=0; j<sheetObj.RowCount(); j++){
            	currCd=sheetObj.GetCellValue(parseInt(j+1), "totBlbAmt_"+"curr_cd");
            	bilAmt=sheetObj.GetCellValue(parseInt(j+1), "totBlbAmt_"+"tot_bil_amt");
                if (parseInt(bilAmt) > 0) {
                    demSts=true;
                }
                document.form['tot_bil_amt'][j]=new Option(currCd+' '+ComAddCommaRun(bilAmt), j);
            }
            if (demSts == true) {
                document.getElementById("demur_sts").value="N";
                document.getElementById("demur_sts").style.color='red';
                document.getElementById("tot_bil_amt").className="input2_1";
            } else {
                document.getElementById("demur_sts").value="Y";
                document.getElementById("demur_sts").style.color='blue';
                document.getElementById("tot_bil_amt").className="input2";
            }
        } else {
            document.getElementById("demur_sts").value="Y";
            document.getElementById("demur_sts").style.color='blue';
            document.form['tot_bil_amt'][0]=new Option('0');
            document.getElementById("tot_bil_amt").className="input2";
        }
    }
    /**
     * handling process after ending euCstmsInfo retrieve
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function euCstmsInfo_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
            }
        }
    }
    /**
     * handling process after ending otsRcvInfo retrieve
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function otsRcvInfo_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
                addSel(sheetObj);
                ComBtnEnable("btn_cct");
                ComBtnEnable("btn_third_cct");
                //ComBtnEnable("btn_erp");
                if( document.getElementById("otsRcvInfo_tot_ots_sts_cd").value =='Y'){
                    document.getElementById("otsRcvInfo_tot_ots_sts_cd").style.color='blue';
                }else if(document.getElementById("otsRcvInfo_tot_ots_sts_cd").value =='N'){
                    document.getElementById("otsRcvInfo_tot_ots_sts_cd").style.color='red';
                }
            }
        }
    }
    /**
     * handling process after ending euDoRlseStsCntr retrieve
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function euDoRlseStsCntr_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if (document.form.refInfo_do_split_flg.value == "N") return;
            if(sheetObj.RowCount()> 0){
                //setting D/O status to Hidden Value
                for(var idx=1; idx <= sheetObj.RowCount(); idx++){
                    //leave value before cancel
                	if(sheetObj.GetCellValue(idx, "euDoRlseStsCntr_rlse_sts_cd") != 'C'){
                		document.getElementById("rlse_sts_cd").value=sheetObj.GetCellValue(idx, "euDoRlseStsCntr_rlse_sts_cd");
                    }
                    //setting to last row
                    if(idx == sheetObj.RowCount()){
                    	document.getElementById("last_rlse_sts_cd").value=sheetObj.GetCellValue(idx, "euDoRlseStsCntr_rlse_sts_cd");
                    }
                }
                //setting D/O no to Hidden value
                document.getElementById("h_do_no").value=sheetObj.GetCellValue(1, "euDoRlseStsCntr_do_no");
                var headRow=sheetObjects["euDoRlseStsCntr"].HeaderRows();
                var splitYn=false;
                for(var idx=headRow; idx <= sheetObjects["euDoRlseStsCntr"].LastRow(); idx++){
                	if (sheetObjects["euDoRlseStsCntr"].GetCellValue(idx, "euDoRlseStsCntr_rlse_sts_cd") == "R") {
                        splitYn=true;
                    }
                }
     
                //all data is Cancel
                if(splitYn == false){
                    document.form.split_flg[0].disabled=false;
                    document.form.split_flg[1].disabled=false;
                } else {
                    document.form.split_flg[0].disabled=true;
                    document.form.split_flg[1].disabled=true;
                }
                // value before D/O Event
                document.getElementById("pre_ctnt").value=sheetObj.GetCellValue(1, "doRlseSts_rlse_sts_cd");
                //High-Light bottom
//                sheetObj.SelectCell(1,0)
            }
        }
    }
    /**
     * handling process after ending euDoRlseStsBl retrieve
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function euDoRlseStsBl_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if (document.form.refInfo_do_split_flg.value == "Y") return;
            if(sheetObj.RowCount()> 0){
            //setting D/O status to Hidden Value
            for(var idx=1; idx <= sheetObj.RowCount(); idx++){
                //leave value before cancel
            	if(sheetObj.GetCellValue(idx, "euDoRlseStsBl_rlse_sts_cd") != 'C'){
            		document.getElementById("rlse_sts_cd").value=sheetObj.GetCellValue(idx, "euDoRlseStsBl_rlse_sts_cd");
                }
                //setting last row
                if(idx == sheetObj.RowCount()){
                	document.getElementById("last_rlse_sts_cd").value=sheetObj.GetCellValue(idx, "euDoRlseStsBl_rlse_sts_cd");
                }
            }
            //setting D/O to Hidden Value
            document.getElementById("h_do_no").value=sheetObj.GetCellValue(1, "euDoRlseStsBl_do_no");
            //when all data Cancel 
            if(sheetObj.RowCount()== 1 && sheetObj.GetCellValue(1, "euDoRlseStsBl_rlse_sts_cd") == 'C'){
                document.form.split_flg[0].disabled=false;
                document.form.split_flg[1].disabled=false;
            } else {
                document.form.split_flg[0].disabled=true;
                document.form.split_flg[1].disabled=true;
            }
            document.getElementById("pre_ctnt").value=sheetObj.GetCellValue(1, "euDoRlseStsBl_rlse_sts_cd");
            //High-Light bottom
            //sheetObj.SelectCell(sheetObj.RowCount(),0)
            }
        }
    }
    /************************************************************************************
        IBSHEET OnSearchEnd Event Process End
    ************************************************************************************/
    /************************************************************************************
        IBSHEET OnClick Event Process Start
    ************************************************************************************/
    /**
     * demInfo double click event handling
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function demInfo_OnDblClick(sheetObj, row, col){
        //first Container Info
    	var click_cntr_no=sheetObj.GetCellValue(row, "demInfo_cntr_no");
        // call Popup when Click
        demDtlPopOpen(click_cntr_no)
    }
    /**
     * open DEM. Detail Info 
     * @param cntr_no
     * @return
     */
    function demDtlPopOpen(cntr_no){
        var sXml=IBS_GetDataSearchXml(sheetObjects["demDtl"]);
        document.form.demDtlXmlData.value=sXml;
        var condition="?";
            condition += "cntr_no="+cntr_no;
        ComOpenWindowCenter('/opuscntr/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
    }
    /**
     * retrieve CCT,Third Office(CCT)
     * @param flag
     * @return
     */
    function blOutstandingAmountPopOpen(flag){
        if (sheetObjects["otsRcvInfo"].RowCount()== 0) {
            alert("Outstanding Amount No data.")
            return;
        }
        sheetObjects["otsRcvPop"].RemoveAll();
        var maxRow=sheetObjects["otsRcvInfo"].LastRow();
        var cellValue="";
        var prefix="otsRcvInfo_";
        var curr_cd="";
        var ots_amt=0;
        for(i=1;i <= maxRow ; i++){
            //setting font color by status
            for(var q=1;q<6;q++){
                if (flag == true) { // selected CCT
                	if (sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q) > 0) {
                		curr_cd=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "cct_ots_curr_cd" + q);
                		ots_amt=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q);
                        sheetObjects["otsRcvPop"].DataInsert(-1);
                        sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_curr_cd",curr_cd,0);
                        sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_tot_ots_amt",ots_amt,0);
                    }
                } else {            // Third Office(CCT)
                	if (sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q) > 0) {
                		curr_cd=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_curr_cd" + q);
                		ots_amt=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q);
                        sheetObjects["otsRcvPop"].DataInsert(-1);
                        sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_curr_cd",curr_cd,0);
                        sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_tot_ots_amt",ots_amt,0);
                    }
                }
            }
        }
        if (sheetObjects["otsRcvPop"].RowCount()> 0) {
            var sXml=IBS_GetDataSearchXml(sheetObjects["otsRcvPop"]);
            document.form.oaXmlData.value=sXml;
            ComOpenPopup("/opuscntr/ESM_BKG_1022.do", 400, 320, "", "1,0", true);
        }
    }
    /**
     * setting split flag
     * @param splitFlg
     * @return
     */
    function setSplitFlag(splitFlg) {
    	if (splitFlg == "N") {

    		sheetObjects["euDoRlseStsBl"].SetSheetHeight(130);
            sheetObjects["euDoRlseStsCntr"].SetVisible(0);
            sheetObjects["euDoRlseStsBl"].SetVisible(1);
            document.form.refInfo_do_split_flg.value="N";
            document.getElementById("div_remain_cnt").style.visibility="hidden";
            document.getElementById("div_cntr_hold_btn").style.display="none";  
            document.getElementById("div_cntr_unhold_btn").style.display="none";
            
     
            if(sheetObjects["refInfo"].GetCellValue(1, "refInfo_do_hld_flg") =="N"){
                document.getElementById("div_hold_btn").style.display="";
                document.getElementById("div_unhold_btn").style.display="none";
            }else if(sheetObjects["refInfo"].GetCellValue(1, "refInfo_do_hld_flg") =="Y"){
                document.getElementById("div_hold_btn").style.display="none";
                document.getElementById("div_unhold_btn").style.display="";
            }
        } else {
        	document.form.refInfo_do_split_flg.value="Y";
            sheetObjects["euDoRlseStsBl"].SetVisible(0);
            sheetObjects["euDoRlseStsCntr"].SetVisible(1);
            sheetObjects["euDoRlseStsCntr"].SetSheetHeight(130);
            document.getElementById("div_remain_cnt").style.visibility="visible";
            document.getElementById("div_cntr_hold_btn").style.display="";  
            document.getElementById("div_cntr_unhold_btn").style.display="";
            document.getElementById("div_hold_btn").style.display="none";  
            document.getElementById("div_unhold_btn").style.display="none";
        }
    }
    /**
     * release Y/N
     */
    function fnReleaseYn() {
        var formObj=document.form;
        var chkCount=0;
        chkRowCnt=0;
        if(sheetObjects["blInfo"].RowCount()== 0) return false;
        if (formObj.refInfo_do_split_flg.value == "N") {
            chkRowCnt=1;
            
       	    chkRowCount = 0;
    	    chkReleaseCount = 0;
    	    chkNoReleaseCount = 0;
    	    
    	    if(sheetObjects["euDoRlseStsBl"].RowCount()== 1 && sheetObjects["euDoRlseStsBl"].GetCellValue(1, "euDoRlseStsBl_rlse_sts_cd") == 'R'){
                return true;
            } else {
                return false;
            }
        } else {
            if(sheetObjects["euDoRlseStsCntr"].RowCount()> 0) {
                chkRowCount = 0;
           	    chkReleaseCount = 0;
           	    chkNoReleaseCount = 0;
           	   
                if (sheetObjects["euDoRlseStsCntr"].CheckedRows("euDoRlseStsCntr_cntr_chk") != 0) {
                    // read row of check row in case of SaveName = 'Pass_yn'
                    var iCheckRow2=sheetObjects["euDoRlseStsCntr"].FindCheckedRow("euDoRlseStsCntr_cntr_chk");
                    // composition array
                    
                    var arrRow=iCheckRow2.split("|");
                    
                    var releaseYn = "";
                    
                    chkRowCount = arrRow.length;
                    
                    for (idx=0; idx<arrRow.length; idx++){
                        chkRowCnt=chkRowCnt + 1;
                        if (sheetObjects["euDoRlseStsCntr"].GetCellValue(arrRow[idx], "euDoRlseStsCntr_rlse_sts_cd") == 'R') {
                           chkReleaseCount = chkReleaseCount + 1;
                     	   releaseYn = "Y";
                        } else {
                       	   chkNoReleaseCount = chkNoReleaseCount + 1;
                       	   releaseYn = "";
                        }
                    }
                    
                    if (chkRowCount == chkReleaseCount) {
                     	 return true;
                      } else {
                     	 return false;
                      }     
                } else {
                    // no checked row
                    chkRowCnt=0;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    /**
     * clear sheet
     */
    function fnAllSheetClear() {
        sheetObjects["blInfo"].RemoveAll();
        sheetObjects["refInfo"].RemoveAll();
        sheetObjects["euCstmsInfo"].RemoveAll();
        sheetObjects["euDoRlseStsCntr"].RemoveAll();
        sheetObjects["euDoRlseStsBl"].RemoveAll();
        sheetObjects["blIss"].RemoveAll();
        sheetObjects["otsRcvInfo"].RemoveAll();
        sheetObjects["demInfo"].RemoveAll();
        sheetObjects["demDtl"].RemoveAll();
        sheetObjects["totBlbAmt"].RemoveAll();
        sheetObjects["partial"].RemoveAll();
    }
    /**
     * euDoRlseStsCntr click event handling
     * @param sheetObj
     * @param row
     * @param col
     * @param value
     * @return
     */
    function euDoRlseStsCntr_OnClick(sheetObj, row, col, value){
        //first Container Info
        if (col == "1") {
        	var cntr_chk=sheetObj.GetCellValue(row, "euDoRlseStsCntr_cntr_chk");
            if (cntr_chk == "0") {
                cntr_chk="1";
            } else {
                cntr_chk="0";
            }
//            fnCntrSheetChk(row, cntr_chk);
        }
    }
    function fnCntrSheetChk(row, value) {
        if (sheetObjects["euDoRlseStsCntr"].RowCount()== 0) return;
        var headRow=sheetObjects["euDoRlseStsCntr"].HeaderRows();
        if (row < headRow) return;
        var doNo=sheetObjects["euDoRlseStsCntr"].GetCellValue(row, "euDoRlseStsCntr_do_no");
        if (doNo != "") {
            if (value == "1") {
                sheetObjects["euDoRlseStsCntr"].CheckAll("euDoRlseStsCntr_cntr_chk",0,1);
                for(var idx=headRow; idx <= sheetObjects["euDoRlseStsCntr"].LastRow(); idx++){
                	if (sheetObjects["euDoRlseStsCntr"].GetCellValue(idx, "euDoRlseStsCntr_do_no") == doNo) {
                        if (idx != row) {
                            sheetObjects["euDoRlseStsCntr"].SetCellValue(idx, "euDoRlseStsCntr_cntr_chk",value,0);
                        }
                    } else {
                        sheetObjects["euDoRlseStsCntr"].SetCellValue(idx, "euDoRlseStsCntr_cntr_chk","0",0);
                    }
                }
            } else {
                sheetObjects["euDoRlseStsCntr"].CheckAll("euDoRlseStsCntr_cntr_chk",0,1);
                sheetObjects["euDoRlseStsCntr"].SetCellValue(row, "euDoRlseStsCntr_cntr_chk",1,0);
            }
        } else {
            for(var idx=headRow; idx <= sheetObjects["euDoRlseStsCntr"].LastRow(); idx++){
            	if (sheetObjects["euDoRlseStsCntr"].GetCellValue(idx, "euDoRlseStsCntr_do_no") != "") {
                    sheetObjects["euDoRlseStsCntr"].SetCellValue(idx, "euDoRlseStsCntr_cntr_chk","0",0);
                }
            }
        }
    }
    /**
     * find Do No
     */
    function fnFindDoNo() {
        var formObj=document.form;
        var doNo="";
        if(sheetObjects["euDoRlseStsCntr"].RowCount()> 0) {
            if (sheetObjects["euDoRlseStsCntr"].CheckedRows("euDoRlseStsCntr_cntr_chk") != 0) {
                //read row of check row in case of SaveName = 'Pass_yn'
                var iCheckRow2=sheetObjects["euDoRlseStsCntr"].FindCheckedRow("euDoRlseStsCntr_cntr_chk");
                //composition array
                var arrRow=iCheckRow2.split("|");
                doNo=sheetObjects["euDoRlseStsCntr"].GetCellValue(arrRow[0], "euDoRlseStsCntr_do_no");
                return doNo;
            } else {
                // no checked row
                return "";
            }
        } else {
            return "";
        }
    }
    /**
     * call release popup for remark 
     */   
    //@ Pop Up에서 모달로 값을 받아야 하나 IE처럼 동기화가 되지않고 값을 받기 전에 다음으로 진행되어,
    //@ CallBack 메소드에서 다시 doAction메소드를 호출 시 체크하여 진행여부를 결정하게 한다.
    var releaseRemarkFlag = false;
     function remarkForReleasePop(){
    	 if(releaseRemarkFlag == false){
	         var condition = "?bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
	         ComOpenPopup("/opuscntr/ESM_BKG_0954.do"+condition, 600, 250, "callBack0954", '0,1,1,1,1,1,1', true);
             return false;
         }
         return true;
     }
     /**
      * Popup Ok Event Handling.<br>
      */
     function callBack0954(result){
    	 if(!ComIsNull(result)){
    		 ComShowCodeMessage("BKG00166"); //Data Saved Successfully!!
    		 document.form.releaseRemark.value=result;
        	 releaseRemarkFlag = true;
        	 
        	 //@ Pop-Up 레이어를 닫기 위해 시간차를 둠
        	 setTimeout( function () { //@ setTimeout ###########################################################
	        	 //Release 함.
	        	 var formObject=document.form;
	        	 doActionIBSheet(sheetObjects["euDoRlseStsCntr"], formObject, MULTI01);
        	 } , 100);//@ setTimeout end ###########################################################
         }
      }    
    
   /**
    * RD LOAD
    */
   function rdLoad() {
//       var Rdviewer=rdObjects[0];
	   var appendReport = [];
       var formObject=document.form;
        //RD Info
        if (document.form.split_flg[0].checked == true) {
        	doNo=sheetObjects["euDoRlseStsBl"].GetCellValue(1, "euDoRlseStsBl_do_no");       //per BL

            var mrdId=formObject.h_mrd_id.value;
            var mrdParam=formObject.h_mrd_param.value;
            if(mrdId == ""){
                ComShowCodeMessage("BKG40060");
                return;
            }
            if(doNo == ""){
                var blNo="";
                if (sheetObjects["blInfo"].RowCount()> 0) {
                	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                }
                    ComShowCodeMessage("BKG40059", blNo);
                return;
            }
            formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"
                + mrdId
                + ".mrd";
            var strArg="/rv ";
            strArg += " form_doNo['" + doNo + "']";
            strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
            strArg += " form_usrId['" + strUsr_id + "']";
            strArg += " form_ofcCd['" + lginOfcCd + "']";
            strArg += " " + mrdParam;
           var rdParam=strArg + " /riprnmargin /rwait";
           // setting RD file for open
           var strPath=RD_path+ formObject.com_mrdPath.value;

           appendReport.push({mrdPath:strPath, mrdParam:RDServer + rdParam});
           directReportDownload(appendReport);
//           viewer.openFile(strPath, RDServer + rdParam, {timeout:1800});
//           viewer.print({isServerSide:true});
        } else {
//            doNo=fnFindDoNo();
                
        	var prefix = "euDoRlseStsCntr";
        	
        	for (var idx=1; idx <= sheetObjects[prefix].LastRow(); idx ++) {
            	if (sheetObjects[prefix].GetCellValue(idx, prefix+"_cntr_chk") == 1) {
                    // validation for checked Info
            		doNo=sheetObjects[prefix].GetCellValue(idx, prefix+ "_do_no") + sheetObjects[prefix].GetCellValue(idx, prefix+ "_do_no_split");
                
		            if (doNo == "") {
		                var blNo="";
		                if (sheetObjects["blInfo"].RowCount()> 0) {
		                	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
		                }
		                    ComShowCodeMessage("BKG40059", blNo);
		                return;
		            }
		            
		            var mrdId=formObject.h_mrd_id.value;
		            var mrdParam=formObject.h_mrd_param.value;
		            if(mrdId == ""){
		                ComShowCodeMessage("BKG40060");
		                return;
		            }
		            if(doNo == ""){
		                var blNo="";
		                if (sheetObjects["blInfo"].RowCount()> 0) {
		                	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
		                }
		                    ComShowCodeMessage("BKG40059", blNo);
		                return;
		            }
		            formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"
		                + mrdId
		                + ".mrd";
		            var strArg="/rv ";
		            strArg += " form_doNo['" + doNo + "']";
		            strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
		            strArg += " form_usrId['" + strUsr_id + "']";
		            strArg += " form_ofcCd['" + lginOfcCd + "']";
		            strArg += " " + mrdParam;
		           var rdParam=strArg + " /riprnmargin /rwait";
		           // setting RD file for open
		           var strPath=RD_path+ formObject.com_mrdPath.value;
		           appendReport.push({mrdPath:strPath, mrdParam:RDServer + rdParam});
            	}
        	}
        	directReportDownload(appendReport);
//          	 viewer.openFile(appendReport, {timeout:1800});
//         	 viewer.print({isServerSide:true});  
        }
   }
   /**
    * check Textarea Max Line
    * @param obj
    * @return
    */
    function fncTextareaMaxLine(obj)
    {
        var str_line=obj;
        line=str_line.split("\r\n");
        ln=line.length;
        if(ln == 5 && event.keyCode == 13){
            event.returnValue=false;
        }
    }
    /**
     * retrieve container
     */
    function fnSearchContainer(){
        var formObj=document.form;
        if (ComIsNull(formObj.cntr_no)) return;
        if(document.getElementById("h_cntr_no").value == document.getElementById("cntr_no").value) {
            return;
        }
        document.getElementById("h_cntr_no").value=document.getElementById("cntr_no").value;
        //call popup
        formObj.f_cmd.value=SEARCH01;
        sheetObjects["partial"].DoSearch("ESM_BKG_0292GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("partial_") );
    }
    /**
     * handling process after ending demInfo retrieve
     * @param sheetObj
     * @return
     */
    function demInfo_OnSearchEnd(sheetObj){
     //Wait Image Show Hidden
        ComOpenWait(false);
        ComBtnEnable("btn_dem_retrieve"); //DMDT
        ComBtnEnable("btn_dmdt");         //RCV Cancel
    }
     /**
      * check remark
      */
     function chkRemark() {
  	   if (document.form.refInfo_inter_rmk.value.length > 0 ) {
  		   // have data
  		   buttonColorSet("btn_hold_remark", "red");
  	   } else {
  		   // no data
  		   buttonColorSet("btn_hold_remark", "gray");
  	   }
     }
      /**
       * button disable
       * @param btn_name
       * @param color
       * @return
       */
     function buttonColorSet(btn_name, color){
         var tds=document.getElementsByTagName("td");
         var curFlag=null;
         curFlag="hand";
         for(var i=0; i < tds.length; i++) {
             var td=tds[i];
             if(td.name == '•' + btn_name){
            	    td.style.color=color;
            	    td.style.cursor=curFlag;
            	    if (btn_name == "btn_hold_remark") {
             	    document.form.h_hold_remark.value=color;
             	}
                 break;
             }else if(td.name == btn_name){
            	    td.style.color=color;
            	    td.style.cursor=curFlag;
            	    if (btn_name == "btn_hold_remark") {
         		    document.form.h_hold_remark.value=color;
         	    }
                 break;
             }else{
            	    continue;
             }
         }
     }
     /**
      * set remark
      * @param remark
      * @return
      */
     function funcSetRemark(remark) {
  	   document.form.refInfo_inter_rmk.value=remark;
  	   chkRemark();
     }

     
   //GAP Display Credit Risk (2014.10.14 An Jin Eung)
     /**
      * fnExistBlackListedCustomer  
      * param :_val
      */
     function fnExistBlackListedCustomer(bkgNo) {
     	
     	var formObj = document.form;
     	var sheetObj = sheetObjects["blInfo"];

     	var param = "&f_cmd=" + COMMAND02 + "&input_text=" + bkgNo;
     	
 		var sXml = sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
 		var output_text=ComGetEtcData(sXml, "output_text");    	

     	if (output_text != '') {
     		ComShowMessage(ComGetMsg("BKG43055", output_text ));
     		return false;// Y-> error
     	}
     	return true;
     }     