/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0019.js
*@FileTitle  : Container Master Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 /**
 * @fileoverview 
 * @author 
 */
/**
 * @extends 
 * @class ees_mst_0019 :  business script for ees_mst_0019
 */
    function ees_mst_0019() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	 // common static variable
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var timer='';
	 var SEARCH_ENABLE=true;
	 var bkg_click=false; 
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
     // Event handler processing by button name */
     function processButtonClick(){
         /*******************************************************/
         var formObj=document.form;
         try {
             var srcName= ComGetEvent("name");
             if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					case "btn_new":
						formObj.cntr_no.value="";
						formObj.chk_dgt.value="";
						initDisplay(); 
						formObj.cntr_no.focus();
						formObj.chk_dgt.readOnly = true;
	                	formObj.chk_dgt.className="input";			
						downButtonDisable();
					break;
					case "btn_spec":
						openPopupSpec();
					break;
					case "btn_mvmt":
						openPopupMVMT();
					break;
					case "btn_status":
						openPopupStatus();
					break;
					case "btn_mnr":
						openPopupMnr();
					break;
					case "btn_doldoc":
						openPopupAGMT();
					break;
					case "btn_close":
						ComClosePopup(); 
					break;		
					break;	
					case "btn_ru_label_info":
						openPopupRuLabel(); 
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
     * registering IBsheet Object as list
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
             ComConfigSheet(sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         }
     	 initControl();    
     	 downButtonDisable();
     }
      function downButtonDisable(){
    	  ComBtnDisable("btn_spec");
    	  ComBtnDisable("btn_mvmt");
    	  ComBtnDisable("btn_status");
    	  ComBtnDisable("btn_mnr");
    	  ComBtnDisable("btn_doldoc");
      }
      
      function downButtonEnable(){
    	  var formObj=document.form;
    	  ComBtnEnable("btn_spec");
    	  ComBtnEnable("btn_mvmt");
    	  ComBtnEnable("btn_status");
    	  ComBtnEnable("btn_mnr");
    	  if ( OfficeCodeMgr.checkContainOfficeCode("000001", "LSE", ComGetObjValue(formObj.usr_ofc_cd)) ) {
    		  ComBtnEnable("btn_doldoc");
    	  } else {
    		  ComBtnDisable("btn_doldoc");
    	  }
    	  
      }
  	// Axon handling event
  	// 1. event catch
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListener('dblclick','obj_dblclick_1',	"bkg_no1"); //- when key down
  		axon_event.addListener('dblclick','obj_dblclick_1',	"bkg_no2"); //- when key down
  		axon_event.addListener('dblclick','obj_dblclick_1',	"bkg_no3"); //- when key down
  		axon_event.addListener('click','obj_dblclick1',	"bkg_no1"); //- when key down
  		axon_event.addListener('click','obj_dblclick1',	"bkg_no2"); //- when key down
  		axon_event.addListener('click','obj_dblclick1',	"bkg_no3"); //- when key down
  		axon_event.addListener('click','obj_dblclick4',	"lse_vndr_url"); //- when key down
	    axon_event.addListenerFormat('blur',    'obj_blur',     form); //- handling OnBeforeDeactivate event of all control except rdoCity
	    axon_event.addListenerFormat('focus',   'obj_focus',    form); //- handling OnBeforeDeactivate event of all control that has dataformat attribute
		// axon_event.addListenerFormat('keydown',	'obj_keydown',	form); //- when key down
		// axon_event.addListenerFormat('keypress','obj_keypress',	form); //- when key down
		// axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- when key down
		// axon_event.addListenerFormat('keyup',	'obj_keyup',	form); //- when key down
		// axon_event.addListenerFormat('keypress','obj_keypress',	form); //- when key down  
		axon_event.addListenerForm('change',	'obj_change',	form); //- when object is changed.		
		ComSetFocus(formObj.cntr_no);
  		if (formObj.cntr_no.value.length > 0){
  		    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
  		    ComSetFocus(formObj.cntr_no);
  		}    
  	}       
	//handling event blur
	function obj_blur(){
	    //ComChkObjValid(ComGetEvent());
	}
	function obj_focus(){
	    //ComClearSeparator(ComGetEvent());
	}
  	/**
 	 * handling Key-Down Event 
 	 */
// 	function obj_keydown() {
//		var obj=ComGetEvent();
//		var vKeyCode=event.keyCode;
//		var ctrlKey=event.ctrlKey;
//		var formObj=document.form;
//  		switch(ComGetEvent("name")) {
//			case "cntr_no":
//	  		if ( vKeyCode == 9 || vKeyCode == 13 ) {
//	  			SEARCH_ENABLE=false;
//	  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//	  			SEARCH_ENABLE=true;
//	  			ComSetFocus(formObj.cntr_no);
//	  		}
//	  		break;
//  		}	
//	} 	 
//   	function obj_keyup() {
//  		var obj=ComGetEvent();
//  		var formObj=document.form;
//  		switch(ComGetEvent("name")) {
//			case "cntr_no":
//  				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
//  					ComKeyEnter('LengthNextFocus');
//  				}
//  				break;
//  		}		
//  	}	
	/**
	 * handling event on change
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		if (ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "cntr_no":
	    			if ( SEARCH_ENABLE ) {
	    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase(); // Copy&paste lower case to upper case
	    				formObj.chk_dgt.value="";
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    				ComSetFocus(formObj.cntr_no);
	    			}
					break;
					
	    		case "chk_dgt":
	    			if ( formObj.chk_dgt.value !="" ) {
	    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase() + formObj.chk_dgt.value; // Copy&paste lower case to upper case
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    				ComSetFocus(formObj.cntr_no);
	    			}
					break;
		    }
		}	
	}		
// 	function obj_keypress(){
//	    var obj=ComGetEvent();
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "engup":
//	            if(obj.name=="cntr_no") ComKeyOnlyAlphabet('uppernum');
//	            break;
//	    }        
//	}
 	function obj_dblclick1(){
 		var formObj=document.form;	
 		var obj=ComGetEvent();
		var chkBkgNo="";
		if (bkg_click == true) return;
		bkg_click=true;
		if(obj.name == "bkg_no1"){
			chkBkgNo=formObj.bkg_no1.value;
		} else if (obj.name == "bkg_no2"){
			chkBkgNo=formObj.bkg_no2.value;
		} else if (obj.name == "bkg_no3"){
			chkBkgNo=formObj.bkg_no3.value;
		}
		if ( chkBkgNo != "" ) {
	        var sUrl = "ESM_BKG_0079_Q.do?bkg_no=" + chkBkgNo;
	        try {
	        ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1024, 700, false, "yes");
	        } catch( e ) {
	        	alert("e :::"+e)
	        }
		}
		bkg_click=false;
		/*
		var sUrl="ESM_BKG_0079_Q.do?bkg_no="+chkBkgNo;
		var iWidth=1024;
		var iHeight=700;
		var sTargetObjList="cntr_spec_no:cntr_spec_no";
		var sDisplay="0,1";
		var param="?cntr_spec_no="+formObj.cntr_spec_no.value+"&popflag=1";
		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);		
		*/
 	}
 	function obj_dblclick_1(){
 		var formObj=document.form;	
 		var obj=ComGetEvent();
		var chkBkgNo="";
		if (bkg_click == true) return;
		bkg_click=true;
		if(obj.name == "bkg_no1"){
			chkBkgNo=formObj.bkg_no1.value;
		} else if (obj.name == "bkg_no2"){
			chkBkgNo=formObj.bkg_no2.value;
		} else if (obj.name == "bkg_no3"){
			chkBkgNo=formObj.bkg_no3.value;
		}
		if ( chkBkgNo != "" ) {
	        var sUrl="ESM_BKG_0079_Q.do?bkg_no="+chkBkgNo;
	        try {
	        ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1024, 700, false, "yes");
	        } catch( e ) {
	        	alert("e :::"+e)
	        }
		}
		bkg_click=false;
 	}
 	function obj_dblclick4(){
 		var formObj=document.form;		
		var lsevndrurl=formObj.lse_vndr_url.value;
		if ( lsevndrurl != "" ) {
			window.open(lsevndrurl, "", "");
		}
 	}
    /**
    * Pop-up Open <br>
    */
   function openPopupSpec(){
		var formObj=document.form;
		var sUrl='/opuscntr/EES_MST_0021_POP.do';
		var iWidth=1150;
		var iHeight=630;
		var sTargetObjList="cntr_spec_no:cntr_spec_no";
		var sDisplay="0,1";
		var param="?cntr_spec_no="+formObj.cntr_spec_no.value+"&popflag=1";
		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
   } 	
   /**
    * Pop-up Open<br>
    */
   function openPopupStatus(){
		var formObj=document.form;
		var sUrl='/opuscntr/EES_MST_0029_POP.do';
		var iWidth=1030;
		var iHeight=635;
		var sTargetObjList="cntr_no:cntr_no";
		var sDisplay="0,1";
		var param="?cntr_no="+formObj.cntr_no.value+"&popflag=1";
		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
   }
   
   function openPopupAGMT(){
		var formObj=document.form;
		var sUrl='/opuscntr/EES_LSE_0095Pop.do';
		var iWidth=1050;
		var iHeight=750;
		var sTargetObjList="agmt_seq:agmt_seq";
		var sDisplay="0,1";
		var tmpseqno=formObj.onh_agmt_no.value.substr(3);
		var tmpseqno_1="";
		for (var i=0; i < tmpseqno.length; i++){
			if(tmpseqno.substr(i,1) == "0"){
				tmpseqno_1=tmpseqno.substr(i+1);
			} else {
				break;
			}
		}
		if (formObj.onh_agmt_no.value != ""){
			var param="?agmt_seq="+tmpseqno_1;
		}
		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, false);
   }
   
   function openPopupMnr(){
		var formObj=document.form;
		var sUrl='/opuscntr/EES_MNR_0028_POP.do';
		var iWidth=1030;
		var iHeight=700;
		var sTargetObjList="";
		var sDisplay="0,1";
		if (formObj.cntr_no.value != ""){
			var param="?from_sys=MST&eq_no="+formObj.cntr_no.value+formObj.chk_dgt.value+"&eq_type=U&popup_mode=Y";
		}
		//ComOpenPopupWithTargetModal(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, false);
		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);	   
   }
   
   function openPopupMVMT(){
	  var formObj=document.form;
      var cnmv_dt=ComGetNowInfo("ymd"); //formObj.cnmv_dt.value;
      ComOpenPopupWithTarget("/opuscntr/EES_CTM_0408_POP.do?" +
              "p_cntrno=" + formObj.cntr_no.value + "&" +
              "check_digit=" + formObj.chk_dgt.value + "&" +
              "ctnr_tpsz_cd=" + formObj.cntr_tpsz_cd.value + "&" +
              "p_date1=" + ComGetDateAdd(cnmv_dt, "M", -6, "-", true) + "&" +
              "p_date2=" + ComGetDateAdd(cnmv_dt, "M", 0, "-", true), 1020, 682, "", "0,1", true);
   }
   
   function openPopupRuLabel(){
		  var formObj=document.form;
	      ComOpenWindowCenter("/opuscntr/EES_MST_0053.do?" + "p_cntr_no=" + formObj.cntr_no.value + formObj.chk_dgt.value, "EES_MST_0053", 1020, 520);
   }
   
  /**
   * setting sheet initial values and header
   * param : sheetObj, sheetNo
   * adding case as numbers of counting sheets
   */
  function initSheet(sheetObj,sheetNo) {
      var cnt=0;
      switch(sheetNo) {
          case 1:      //sheet1 init
              with (sheetObj) {
                  //setting Host information [mandatory][HostIp, Port, PagePath]
                  //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
             }
          break;
      }
  }      
  // handling process for sheet
  function doActionIBSheet(sheetObj,formObj,sAction) {
      //sheetObj.ShowDebugMsg = false;
      switch(sAction) {
		case IBSEARCH:      //retrieve
		        initDisplay();
            	formObj.f_cmd.value=SEARCH;
            	if (formObj.cntr_no.value.trim().length == 0) {
            		ComShowCodeMessage("MST00001", "Cntr No.");
            		ComSetFocus(formObj.cntr_no);
            		return;
            	}
            	sheetObj.SetWaitImageVisible(0);
            	ComOpenWait(true);	
            	
            	if (formObj.cntr_no.value.trim().length == 10){
            		formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase() + formObj.chk_dgt.value; // Copy&paste lower case to upper case
            	}
            	
            	var sXml=sheetObj.GetSearchData("EES_MST_0019GS.do", FormQueryString(formObj));
            	var chk=sXml.indexOf("ERROR");
            	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
            		sheetObj.LoadSearchData(sXml,{Sync:1} );
            		ComOpenWait(false);
            		return;
            	}
                // fill data to input boxes 	  
            	var strCntrNo = ComXmlString(sXml, "cntr_no")+"";
            	formObj.cntr_no.value=strCntrNo.substring(0,10);
            	formObj.chk_dgt.value=ComXmlString(sXml, "chk_dgt");
            	var aciacstr=ComXmlString(sXml, "aciac_div_cd");
        		if (aciacstr == "Active") {
        			div_dcond1.style.display="inline";
        			div_dcond2.style.display="none";
        			formObj.aciac_div_cd1.value="Active";
        		} else if (aciacstr == "Inactive") {
        			div_dcond1.style.display="none";
        			div_dcond2.style.display="inline";
        			formObj.aciac_div_cd2.value="Inactive";
        			formObj.aciac_div_cd2.style.backgroundColor ="red";
        			formObj.aciac_div_cd2.style.color ="yellow";
        		} else {
        			div_dcond1.style.display="inline";
        			div_dcond2.style.display="none";
        			formObj.aciac_div_cd1.value="";
        			ComOpenWait(false);
        			ComShowCodeMessage("MST02026");
        			formObj.cntr_no.value = "";
        			formObj.chk_dgt.readOnly = true;
                	formObj.chk_dgt.className="input";			
        			return; 
        		}
            	formObj.cntr_tpsz_cd.value=ComXmlString(sXml, "cntr_tpsz_cd");
            	formObj.lstm_cd.value=ComXmlString(sXml, "lstm_cd");
            	formObj.cntr_tpsz_iso_cd.value=ComXmlString(sXml, "cntr_tpsz_iso_cd");
            	formObj.cntr_mtrl_cd.value=ComXmlString(sXml, "cntr_mtrl_cd");  
            	if (ComXmlString(sXml, "tare_wgt").toString() != "")
            	   formObj.tare_wgt.value=ComAddComma(ComXmlString(sXml, "tare_wgt").toString());
            	if (ComXmlString(sXml, "tare_wgt_lbs").toString() != "")
            	   formObj.tare_wgt_lbs.value=ComAddComma(ComXmlString(sXml, "tare_wgt_lbs").toString());
            	if (ComXmlString(sXml, "cntr_grs_wgt").toString() != "")
             	   formObj.cntr_grs_wgt.value=ComAddComma(ComXmlString(sXml, "cntr_grs_wgt").toString());
             	if (ComXmlString(sXml, "cntr_grs_wgt_lbs").toString() != "")
             	   formObj.cntr_grs_wgt_lbs.value=ComAddComma(ComXmlString(sXml, "cntr_grs_wgt_lbs").toString());
             	if (ComXmlString(sXml, "pay_load").toString() != "")
             	   formObj.pay_load.value=ComAddComma(ComXmlString(sXml, "pay_load").toString());
             	if (ComXmlString(sXml, "pay_load_lbs").toString() != "")
             	   formObj.pay_load_lbs.value=ComAddComma(ComXmlString(sXml, "pay_load_lbs").toString());
            	formObj.cntr_use_co_cd.value=ComXmlString(sXml, "cntr_use_co_cd");
            	formObj.ownr_co_cd.value=ComXmlString(sXml, "ownr_co_cd");
            	formObj.vndr_abbr_nm.value=ComXmlString(sXml, "vndr_abbr_nm");
            	formObj.vndr_lgl_eng_nm.value=ComXmlString(sXml, "vndr_lgl_eng_nm");
            	formObj.mft_dt.value=ComXmlString(sXml, "mft_dt");
            	
            	formObj.rf_humid_ctrl_val_cd.value=ComXmlString(sXml, "rf_humid_ctrl_val_cd");
            	formObj.rf_cmpr_ctnt.value=ComXmlString(sXml, "rf_cmpr_ctnt");
            	
            	if (ComXmlString(sXml, "d2_payld_flg") == 'Y')
            	    formObj.d2_payld_flg.checked=true;
            	formObj.rf_tp_cd.value=ComXmlString(sXml, "rf_tp_cd");
            	formObj.cnmv_sts_cd.value=ComXmlString(sXml, "cnmv_sts_cd");
            	formObj.crnt_yd_cd.value=ComXmlString(sXml, "crnt_yd_cd");
            	formObj.vsl_cd.value=ComXmlString(sXml, "vsl_cd");
            	formObj.skd_voy_no.value=ComXmlString(sXml, "skd_voy_no");
            	formObj.skd_dir_cd.value=ComXmlString(sXml, "skd_dir_cd");
            	formObj.cnmv_dt.value=ComXmlString(sXml, "cnmv_dt");
            	if (ComXmlString(sXml, "full_flg") == 'Y')
            	    formObj.full_flg.checked=true;
            	if (ComXmlString(sXml, "dmg_flg") == 'Y')
            	    formObj.dmg_flg.checked=true;
            	if (ComXmlString(sXml, "imdt_ext_flg") == 'Y')
            	    formObj.imdt_ext_flg.checked=true;
            	formObj.cntr_hngr_rck_cd.value=ComXmlString(sXml, "cntr_hngr_rck_cd");
            	formObj.mnr_hngr_bar_tp_cd.value=ComXmlString(sXml, "mnr_hngr_bar_tp_cd");
            	formObj.cntr_hngr_bar_atch_knt.value=ComAddComma(ComXmlString(sXml, "cntr_hngr_bar_atch_knt").toString());
            	if (ComXmlString(sXml, "disp_flg") == 'Y')
            	    formObj.disp_flg.checked=true;
            	if (ComXmlString(sXml, "plst_flr_flg") == 'Y')
            	    formObj.plst_flr_flg.checked=true;
            	if (ComXmlString(sXml, "uclm_ls") == "L")
            		formObj.ls_flg.checked=true;
            	if (ComXmlString(sXml, "uclm_ls") == "U")
            		formObj.uc_flg.checked=true;
            	if (ComXmlString(sXml, "uclm_ls") == ""){
            		formObj.ls_flg.checked=false;
            		formObj.uc_flg.checked=false;
            	}
            	formObj.onh_dt.value=ComXmlString(sXml, "onh_dt");
            	formObj.onh_cntr_sts_cd.value=ComXmlString(sXml, "onh_cntr_sts_cd");
            	formObj.onh_agmt_no.value=ComXmlString(sXml, "onh_agmt_no");
            	formObj.vndr_seq.value=ComXmlString(sXml, "vndr_seq");
            	formObj.lessor_nm.value=ComXmlString(sXml, "lessor_nm");
            	if (ComXmlString(sXml, "dpc_val").toString() != "")
            	   formObj.dpc_val.value=ComAddComma(ComXmlString(sXml, "dpc_val").toString())
            	else
            		formObj.dpc_val.value="0";	
            	if (ComXmlString(sXml, "using_days").toString() != "")
            	   formObj.using_days.value=ComAddComma(ComXmlString(sXml, "using_days").toString());
            	formObj.cre_dt.value=ComXmlString(sXml, "cre_dt");
            	formObj.cre_usr_id.value=ComXmlString(sXml, "cre_usr_id");
            	formObj.upd_dt.value=ComXmlString(sXml, "upd_dt");
            	formObj.upd_usr_id.value=ComXmlString(sXml, "upd_usr_id");
            	formObj.cntr_sts_cd.value=ComXmlString(sXml, "cntr_sts_cd");
            	formObj.cntr_sts_evnt_dt.value=ComXmlString(sXml, "cntr_sts_evnt_dt");
            	formObj.exit_agmt_no.value=ComXmlString(sXml, "exit_agmt_no");
            	formObj.exit_vndr_seq.value=ComXmlString(sXml, "exit_vndr_seq");
            	formObj.exit_vndr_eng_nm.value=ComXmlString(sXml, "exit_vndr_eng_nm");
            	formObj.dpp_tp_cd.value=ComXmlString(sXml, "dpp_tp_cd");
            	formObj.sub_lstm_cd.value=ComXmlString(sXml, "sub_lstm_cd");
            	formObj.cntr_spec_no.value=ComXmlString(sXml, "cntr_spec_no");
            	formObj.off_hire_avail.value=ComXmlString(sXml, "off_hire_avail");
            	formObj.hid_off_hire_avail.value=ComXmlString(sXml, "off_hire_avail");
            	formObj.bkg_no1.value=ComXmlString(sXml, "bkg_no1");
            	formObj.bkg_no2.value=ComXmlString(sXml, "bkg_no2");
            	formObj.bkg_no3.value=ComXmlString(sXml, "bkg_no3");
            	if (ComXmlString(sXml, "dpp_amt").toString() != "")
            	   formObj.dpp_amt.value=ComAddComma(ComXmlString(sXml, "dpp_amt").toString())
            	else
            		formObj.dpp_amt.value="0";	
            	if (ComXmlString(sXml, "cost_amt").toString() != "")
            	   formObj.cost_amt.value=ComAddComma(ComXmlString(sXml, "cost_amt").toString())
            	else    
            	   formObj.cost_amt.value="0";
            	if (ComXmlString(sXml, "rntl_chg_amt").toString() != "")
            	   formObj.rntl_chg_amt.value=ComAddComma(ComXmlString(sXml, "rntl_chg_amt").toString())
            	else
            	   formObj.rntl_chg_amt.value="0";
            	formObj.lse_vndr_url.value=ComXmlString(sXml, "lse_vndr_url");
            	formObj.certi_no.value=ComXmlString(sXml, "certi_no");
            	formObj.apro_csc_no.value=ComXmlString(sXml, "apro_csc_no");
            	formObj.apro_tir_no.value=ComXmlString(sXml, "apro_tir_no");
            	formObj.rf_mkr_seq.value=ComXmlString(sXml, "rf_mkr_seq");
            	formObj.rf_mdl_nm.value=ComXmlString(sXml, "rf_mdl_nm");
            	formObj.rf_rfr_no.value=ComXmlString(sXml, "rf_rfr_no"); 
            	formObj.min_temp.value=ComXmlString(sXml, "min_temp"); 
            	formObj.max_temp.value=ComXmlString(sXml, "max_temp");             	
            	formObj.rstr_usg_lbl_tp.value   =  ComXmlString(sXml, "rstr_usg_lbl_tp");
            	formObj.rstr_usg_lbl_desc.value   =  ComXmlString(sXml, "rstr_usg_lbl_desc");
            	formObj.cntr_auth_no.value   =  ComXmlString(sXml, "cntr_auth_no");
            	formObj.cntr_offh_auth_no.value   =  ComXmlString(sXml, "cntr_offh_auth_no");
            	timer=window.setInterval('clock()', 50);
            	formObj.chk_dgt.readOnly = false;
            	formObj.chk_dgt.className="input1";			
            	downButtonEnable();
            	ComOpenWait(false);
		break;
      }
  }
  /**
   * handling process for input validation
   */
  function validateForm(sheetObj,formObj,sAction){
      return true;
  }
  
  function initDisplay(){
	  var formObj=document.form;
	  var cntrstr=formObj.cntr_no.value;
	  var chkditstr=formObj.chk_dgt.value;
   	  formObj.reset();
      formObj.cntr_no.value=cntrstr;
      formObj.chk_dgt.value=chkditstr;
      if (timer) window.clearInterval(timer);      
  } 
  
  function Call(numb){ 
	  var formObj=document.form;
	  if (numb){ // effect click mouse
           formObj.off_hire_avail.value=formObj.hid_off_hire_avail.value;
	  }
	  else {
		  formObj.off_hire_avail.value="";
	  }
  } // end fuction
  function clock(){ 
	  now=new Date(); 
      second=now.getSeconds(); 
	  Call(second%2); 
  }  
