/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0154.js
*@FileTitle  : Client Default for Booking 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
   	/**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class esm_bkg_0154 : esm_bkg_0154 - task script definition for screen
     */
    function esm_bkg_0154() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	 // public variable
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 // Event handler processing by button name */
	 function processButtonClick(){
	      /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	      var sheetObject1=sheetObjects[0];
	      /*******************************************************/
	      var formObject=document.form;
	 	try {
	 		var srcName=ComGetEvent("name");
	         switch(srcName) {
	 				case "btn_save":
	 					doActionIBSheet(sheetObject1, formObject, IBSAVE);
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
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++]=sheet_obj;
	 }
	 /**
	 *  Get Receiving Term,Delivery Term combo data
	 **/
	 function initComboSetVal(sheetObj,formObj){
	 	formObj.f_cmd.value=SEARCH01;
	 	var sXml=sheetObj.GetSearchData("ESM_BKG_0154GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 1) 
			ComXml2ComboItem(arrXml[1],rcv_term_cd, "val", "val|name");
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0],de_term_cd, "val", "val|name");
		rcv_term_cd.SetDropHeight(150);
		rcv_term_cd.SetUseAutoComplete(1);
		de_term_cd.SetDropHeight(150);
		de_term_cd.SetUseAutoComplete(1);
	 }	
	 /**
	  * initializing sheet
	  * implementing onLoad event handler in body tag
	  * adding first-served functions after loading screen.
	  */
	 function loadPage() {
	     for(i=0;i<sheetObjects.length;i++){
	         //ComConfigSheet (sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	         //ComEndConfigSheet(sheetObjects[i]);
	     }
	     /*Button disabled as popup*/
	     if (ComGetObjValue(document.form.screenName).indexOf("POP") > -1) {
	    	 getButtonTable("btn_save").style.display="none";
	     }
	     initComboSetVal(sheetObjects[0],document.form);
	     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	 }
	 function initSheet(sheetObj,sheetNo) {
		 var cnt=0;
	    switch(sheetNo) {
	        case 1:   //sheet1 init
	            with(sheetObj){
			          var HeadTitle1=" |";
			          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" } ];
			          //InitColumns(cols);
			          SetEditable(1);
	                }
	            break;
	    }
	}
	 // handling sheet process
	 function doActionIBSheet(sheetObj, formObj, sAction) {
	     sheetObj.ShowDebugMsg(false);
	     switch(sAction) {
	 		case IBSEARCH:      //retrieve
	 			if(validateForm(sheetObj, formObj, sAction)) {
	 				formObj.f_cmd.value=SEARCH;
	 				var sXml=sheetObj.GetSearchData("ESM_BKG_0154GS.do", FormQueryString(formObj));
	    		    /*usr_id	--id / name
					trnk_vsl_cd	
					trnk_skd_voy_no	
					trnk_skd_dir_cd	
					bkg_cgo_tp_cd	
					rcv_term_cd	  --Default=CY
					de_term_cd	  --Default=CY
					por_cd	
					pol_cd	
					full_rtn_yd_cd	
					mty_pkup_yd_cd	
					wgt_ut_cd		--Default=KGS
					meas_ut_cd		--Default=CBM
					cntr_tpsz_cd	--Type/Size  Default=D4
					pre_vsl_cd	
					pre_skd_voy_no	
					pre_skd_dir_cd	
					fwrd_flg	
					rtn_cct_dp_flg	 
					tml_cct_dp_flg	 
					doc_cct_dp_flg	 
					xpt_cstms_cct_dp_flg	
					rail_cct_dp_flg  
					prn_bl_tp_cd	
					prn_chg_tp_cd	
					prn_cntr_tp_cd	
					prn_bl_face_knt	
					prn_bl_ridr_knt	
					dflt_eml	
					dflt_phn_no	
					dflt_fax_no	
					an_prn_rt_flg			
					an_rmk					
					dot_prn_flg	
					drft_bl_xch_rt_dp_flg	
					drft_bl_call_sgn_dp_flg	  
					drft_bl_mrn_no_dp_flg	  
					drft_bl_rmk	     Default=Blank 
					auto_edi_hld_flg 
					cre_usr_id	
					cre_dt	
					upd_usr_id	
					upd_dt		
					bl_prn_chg_tp_cd
					*/
	    		    if (ComGetEtcData(sXml,"usr_id") != undefined){
	    		    	formSettingVal(formObj,sXml);
	    		    }else{
	    		    	initFormSettingVal(formObj,sXml);
	    		    	ComShowCodeMessage('BKG00095');
	    		    }
	           	}
	             break;
	 		case IBSAVE:        //Save
	 			if(validateForm(sheetObj,formObj,sAction)) {
	 				formObj.f_cmd.value=MULTI;
	 				checkObjectSaveSetting(formObj.auto_edi_hld_flg);
	 				checkObjectSaveSetting(formObj.rtn_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.tml_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.doc_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.xpt_cstms_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.rail_cct_dp_flg);
	 				checkObjectSaveSetting(formObj.an_prn_rt_flg);
	 				checkObjectSaveSetting(formObj.drft_bl_xch_rt_dp_flg);
	 				checkObjectSaveSetting(formObj.drft_bl_call_sgn_dp_flg);
	 				//checkObjectSaveSetting(formObj.drft_bl_mrn_no_dp_flg);
	 				checkObjectSaveSetting(formObj.bkg_rct_ntc_rcv_flg);
	 				checkObjectSaveSetting(formObj.mty_rlse_ord_rcv_flg);
	 				checkObjectSaveSetting(formObj.tro_ntc_rcv_flg);
	 				checkObjectSaveSetting(formObj.drft_wbl_rcv_flg);
	 				checkObjectSaveSetting(formObj.srnd_ntc_rcv_flg);
	 				checkObjectSaveSetting(formObj.an_rcv_flg);
	 				checkObjectSaveSetting(formObj.eur_cgor_flg);
	 				checkObjectSaveSetting(formObj.fcntr_rlse_flg);
	 				
	 				if(formObj.cho_chg_0.checked)				formObj.bl_prn_chg_tp_cd.value = "1";
	 				else if(formObj.cho_chg_1.checked==true)		formObj.bl_prn_chg_tp_cd.value = "5";
	 				else if(formObj.cho_chg_2.checked==true)		formObj.bl_prn_chg_tp_cd.value = "4";
	 				else if(formObj.cho_chg_3.checked==true)		formObj.bl_prn_chg_tp_cd.value = "6";
	 				else if(formObj.cho_chg_4.checked==true)		formObj.bl_prn_chg_tp_cd.value = "3";
	 				else											formObj.bl_prn_chg_tp_cd.value = "";
	 				
	 				sheetObjects[0].SetWaitImageVisible(0);
	 				ComOpenWait(true);
	 				setTimeout( function () {
		 				var SaveXml=sheetObj.GetSaveData("ESM_BKG_0154GS.do", FormQueryString(formObj));
		 				sheetObj.LoadSaveData(SaveXml);
	 					ComOpenWait(false);
	 				} , 100);
	 			}
	             break;
	     }
	 }
	 function formSettingVal(formObj,sXml){
		ComSetObjValue(rcv_term_cd,ComGetEtcData(sXml,"rcv_term_cd"));
		ComSetObjValue(de_term_cd,ComGetEtcData(sXml,"de_term_cd"));
	 	formObj.mty_pkup_yd_cd.value=ComGetEtcData(sXml,"mty_pkup_yd_cd");                       
	 	formObj.wgt_ut_cd.value=ComGetEtcData(sXml,"wgt_ut_cd");                              
	 	formObj.meas_ut_cd.value=ComGetEtcData(sXml,"meas_ut_cd");                            
	 	formObj.cntr_tpsz_cd.value=ComGetEtcData(sXml,"cntr_tpsz_cd");    
	 	checkObjectSetting(formObj.auto_edi_hld_flg,ComGetEtcData(sXml,"auto_edi_hld_flg"));
	 	checkObjectSetting(formObj.rtn_cct_dp_flg,ComGetEtcData(sXml,"rtn_cct_dp_flg"));
	 	checkObjectSetting(formObj.rtn_cct_dp_flg,ComGetEtcData(sXml,"rtn_cct_dp_flg"));
	 	checkObjectSetting(formObj.tml_cct_dp_flg,ComGetEtcData(sXml,"tml_cct_dp_flg"));
	 	checkObjectSetting(formObj.doc_cct_dp_flg,ComGetEtcData(sXml,"doc_cct_dp_flg"));
	 	checkObjectSetting(formObj.xpt_cstms_cct_dp_flg,ComGetEtcData(sXml,"xpt_cstms_cct_dp_flg"));
	 	checkObjectSetting(formObj.rail_cct_dp_flg,ComGetEtcData(sXml,"rail_cct_dp_flg"));
	 	checkObjectSetting(formObj.an_prn_rt_flg,ComGetEtcData(sXml,"an_prn_rt_flg"));
	 	formObj.an_rmk.value=ComGetEtcData(sXml,"an_rmk");                                       
	 	checkObjectSetting(formObj.drft_bl_xch_rt_dp_flg,ComGetEtcData(sXml,"drft_bl_xch_rt_dp_flg"));
	 	checkObjectSetting(formObj.drft_bl_call_sgn_dp_flg,ComGetEtcData(sXml,"drft_bl_call_sgn_dp_flg"));
	 	//checkObjectSetting(formObj.drft_bl_mrn_no_dp_flg,ComGetEtcData(sXml,"drft_bl_mrn_no_dp_flg"));
	 	formObj.drft_bl_rmk.value=ComGetEtcData(sXml,"drft_bl_rmk"); 
	 	checkObjectSetting(formObj.bkg_rct_ntc_rcv_flg,ComGetEtcData(sXml,"bkg_rct_ntc_rcv_flg"));
	 	checkObjectSetting(formObj.mty_rlse_ord_rcv_flg,ComGetEtcData(sXml,"mty_rlse_ord_rcv_flg"));
	 	checkObjectSetting(formObj.tro_ntc_rcv_flg,ComGetEtcData(sXml,"tro_ntc_rcv_flg"));
	 	checkObjectSetting(formObj.drft_wbl_rcv_flg,ComGetEtcData(sXml,"drft_wbl_rcv_flg"));
	 	checkObjectSetting(formObj.srnd_ntc_rcv_flg,ComGetEtcData(sXml,"srnd_ntc_rcv_flg"));
	 	checkObjectSetting(formObj.an_rcv_flg,ComGetEtcData(sXml,"an_rcv_flg"));
	 	checkObjectSetting(formObj.eur_cgor_flg,ComGetEtcData(sXml,"eur_cgor_flg"));
	 	checkObjectSetting(formObj.fcntr_rlse_flg,ComGetEtcData(sXml,"fcntr_rlse_flg"));
	 	checkRdoObjectSetting(formObj,ComGetEtcData(sXml,"bl_prn_chg_tp_cd"));
	 }
	 function initFormSettingVal(formObj,sXml){
		rcv_term_cd.value="CY";                          	  	
	 	de_term_cd.value="CY";
	 	formObj.mty_pkup_yd_cd.value="";
	 	formObj.wgt_ut_cd.value="KGS";                              
	 	formObj.meas_ut_cd.value="CBM";                            
	 	formObj.cntr_tpsz_cd.value="D4";  
	 	formObj.auto_edi_hld_flg.checked=false;   
	 	formObj.auto_edi_hld_flg.value="N";  
	 	formObj.rtn_cct_dp_flg.checked=true;   
	 	formObj.rtn_cct_dp_flg.value="Y";  
	 	formObj.tml_cct_dp_flg.checked=false;   
	 	formObj.tml_cct_dp_flg.value="N";  
	 	formObj.doc_cct_dp_flg.checked=true;      
	 	formObj.doc_cct_dp_flg.value="Y";  
	 	formObj.xpt_cstms_cct_dp_flg.value="N";  
	 	formObj.xpt_cstms_cct_dp_flg.checked=false; 
	 	formObj.rail_cct_dp_flg.value="N";  
	 	formObj.rail_cct_dp_flg.checked=false; 
	 	formObj.an_prn_rt_flg.value="N";  
	 	formObj.an_prn_rt_flg.checked=false;
	 	formObj.an_rmk.value="";  
	 	formObj.drft_bl_xch_rt_dp_flg.checked=true;     
	 	formObj.drft_bl_xch_rt_dp_flg.value="Y";             
	 	formObj.drft_bl_call_sgn_dp_flg.checked=true;  
	 	formObj.drft_bl_call_sgn_dp_flg.value="Y";  
	 	//formObj.drft_bl_mrn_no_dp_flg.checked 	= false;    
	 	//formObj.drft_bl_mrn_no_dp_flg.value 	= "N"; 
	 	formObj.drft_bl_rmk.value="";    
	 	formObj.bkg_rct_ntc_rcv_flg.checked=false;   
	 	formObj.bkg_rct_ntc_rcv_flg.value="N";  
	 	formObj.mty_rlse_ord_rcv_flg.checked=false;   
	 	formObj.mty_rlse_ord_rcv_flg.value="N";  
	 	formObj.tro_ntc_rcv_flg.checked=false;   
	 	formObj.tro_ntc_rcv_flg.value="N";  
	 	formObj.drft_wbl_rcv_flg.checked=false;   
	 	formObj.drft_wbl_rcv_flg.value="N";  
	 	formObj.srnd_ntc_rcv_flg.checked=false;   
	 	formObj.srnd_ntc_rcv_flg.value="N";  
	 	formObj.an_rcv_flg.checked=false;   
	 	formObj.an_rcv_flg.value="N";  
	 	formObj.eur_cgor_flg.checked=false;   
	 	formObj.eur_cgor_flg.value="N";  
	 	formObj.fcntr_rlse_flg.checked=false;   
	 	formObj.fcntr_rlse_flg.value="N";
	 	checkRdoObjectSetting(formObj,"1");
	 	
	 	if (ComGetEtcData(sXml,"cnt_cd") == "KR"){
	 		formObj.drft_bl_call_sgn_dp_flg.checked=false;  
		    formObj.drft_bl_call_sgn_dp_flg.value="N";   
	 		//formObj.drft_bl_mrn_no_dp_flg.checked 	= true;    
		    //formObj.drft_bl_mrn_no_dp_flg.value 	= "Y"; 
		    formObj.drft_bl_rmk.value="WON : 우리은행 006-173481-01-001 ㈜   \n USD : 외환은행 061-JCD-100183";
	 	}else  if (ComGetEtcData(sXml,"cnt_cd") == "LK"){
	 		formObj.drft_bl_xch_rt_dp_flg.checked=false;     
		    formObj.drft_bl_xch_rt_dp_flg.value="N";   
	 	}else  if (ComGetEtcData(sXml,"cnt_cd") == "TH"){
	 		formObj.drft_bl_call_sgn_dp_flg.checked=false;  
		    formObj.drft_bl_call_sgn_dp_flg.value="N";   
	 	}else  if (ComGetEtcData(sXml,"cnt_cd") == "SG "){	
	 		formObj.drft_bl_call_sgn_dp_flg.checked=false;  
		    formObj.drft_bl_call_sgn_dp_flg.value="N";   
	 	}else  if (ComGetEtcData(sXml,"cnt_cd") == "US"){	
	 		formObj.rail_cct_dp_flg.checked=true;  
		    formObj.rail_cct_dp_flg.value="Y";   
	 	}
	 }
	 function checkObjectSaveSetting(obj){
		if (obj.checked == true){
			obj.value="Y";
		}else{
			obj.value="N";
		}
	 }
	 function checkObjectSetting(obj,val){
		if (val == 'Y'){
			obj.checked=true; 
		}else{
			obj.checked=false; 
	 	}
	 }
	 function checkRdoObjectSetting(formObj,val){
		if (val == '1'){
		 	formObj.cho_chg_0.checked=true;
		 	formObj.cho_chg_1.checked=false;
		 	formObj.cho_chg_2.checked=false;
		 	formObj.cho_chg_3.checked=false;
		 	formObj.cho_chg_4.checked=false;
		}else if(val == '5'){
		 	formObj.cho_chg_0.checked=false;
		 	formObj.cho_chg_1.checked=true;
		 	formObj.cho_chg_2.checked=false;
		 	formObj.cho_chg_3.checked=false;
		 	formObj.cho_chg_4.checked=false;
		}else if(val == '4'){
		 	formObj.cho_chg_0.checked=false;
		 	formObj.cho_chg_1.checked=false;
		 	formObj.cho_chg_2.checked=true;
		 	formObj.cho_chg_3.checked=false;
		 	formObj.cho_chg_4.checked=false;
		}else if(val == '6'){
		 	formObj.cho_chg_0.checked=false;
		 	formObj.cho_chg_1.checked=false;
		 	formObj.cho_chg_2.checked=false;
		 	formObj.cho_chg_3.checked=true;
		 	formObj.cho_chg_4.checked=false;
		}else if(val == '3'){
		 	formObj.cho_chg_0.checked=false;
		 	formObj.cho_chg_1.checked=false;
		 	formObj.cho_chg_2.checked=false;
		 	formObj.cho_chg_3.checked=false;
		 	formObj.cho_chg_4.checked=true;
	 	}else{
		 	formObj.cho_chg_0.checked=false;
		 	formObj.cho_chg_1.checked=false;
		 	formObj.cho_chg_2.checked=false;
		 	formObj.cho_chg_3.checked=false;
		 	formObj.cho_chg_4.checked=false;
	 	}
	}	 
	 
	 function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
	 	if (ErrMsg == "") {
	 		ComBkgSaveCompleted();  //server messege handling
		} 	 	
	 }
	 /**
	  * handling process for input validation
	  */
	 function validateForm(sheetObj, formObj,sAction){
	     return true;
	 }
	 
	function onCheck(obj)
	{
		if(obj.name=="cho_chg_0"){
			if(document.form.cho_chg_0.checked){
	    		document.form.cho_chg_1.checked = false;
	    		document.form.cho_chg_2.checked = false;
	    		document.form.cho_chg_3.checked = false;
	    		document.form.cho_chg_4.checked = false;
			}
		}else if(obj.name=="cho_chg_1"){
			if(document.form.cho_chg_1.checked){
	    		document.form.cho_chg_0.checked = false;
	    		document.form.cho_chg_2.checked = false;
	    		document.form.cho_chg_3.checked = false;
	    		document.form.cho_chg_4.checked = false;
			}
		}else if(obj.name=="cho_chg_2"){
			if(document.form.cho_chg_2.checked){
	    		document.form.cho_chg_0.checked = false;
	    		document.form.cho_chg_1.checked = false;
	    		document.form.cho_chg_3.checked = false;
	    		document.form.cho_chg_4.checked = false;
			}
		}else if(obj.name=="cho_chg_3"){
			if(document.form.cho_chg_3.checked){
	    		document.form.cho_chg_0.checked = false;
	    		document.form.cho_chg_1.checked = false;
	    		document.form.cho_chg_2.checked = false;
	    		document.form.cho_chg_4.checked = false;
			}
		}else if(obj.name=="cho_chg_4"){
			if(document.form.cho_chg_4.checked){
	    		document.form.cho_chg_0.checked = false;
	    		document.form.cho_chg_1.checked = false;
	    		document.form.cho_chg_2.checked = false;
	    		document.form.cho_chg_3.checked = false;
			}
		}
	}
