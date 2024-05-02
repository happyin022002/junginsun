/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0044.js
*@FileTitle  : Container Master Update 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
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
 * @class ees_mst_0044 : business script for ees_mst_0044
 */
	 // common static variable
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	//Retrieve, New 시 변경된 데이터에 대해서 저장 여부를 묻지 위한 Flag로 사용
	 var arr_de_yrmon=new Array();
	 var arr_fctry_spec_no=new Array();
	 var arr_certi_no=new Array();
	 var arr_apro_csc_no=new Array();
	 var arr_apro_tir_no=new Array();
	 var arr_apro_uic_no=new Array();
	 var arr_apro_tct_no=new Array();
	 var arr_cntr_grs_wgt=new Array();
	 var arr_tare_wgt=new Array();
	 var arr_pay_load=new Array();
	 var arr_unit_type=new Array();
	 var arr_fa_if_grp_sts_cd=new Array();
	 var arr_rf_mkr_seq=new Array();
	 var arr_rf_mdl_nm=new Array();
	 var arr_rf_rfr_no=new Array();
	 var arr_min_temp=new Array();
	 var arr_max_temp=new Array();
	 var arr_diff_rmk=new Array();
	 var arr_cntr_mtrl_cd=new Array();
	 var arr_vndr_abbr_nm=new Array();
	 var arr_mft_dt=new Array();
	 var head_cntr_tpsz_cd="";
	 var tot_cntr_tpsz_cd="";
	 var comboObjects=new Array();
	 var comboCnt=0;
	 var IBSEARCH01=29; 
	 var SEARCH_ENABLE=true; 
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
     // Event handler processing by button name */
     function processButtonClick(){
         var formObj=document.form;
         try {
             var srcName=ComGetEvent("name");
             if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
					case "btn_retrieve":
//						if ( f_change_data_checking(formObj)  == true)  return;
						doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					break;
					
					case "btn_new":
//						if ( f_change_data_checking(formObj)  == true)  return;
						initDisplay(); 
						formObj.cntr_no.value="";
						formObj.chk_dgt.value="";
						formObj.rf_tp_cd_text.value="";
						formObj.rf_cmpr_ctnt.value="";
						comboObjects[0].SetSelectIndex(-1);
						rf_humid_ctrl_val_cd.SetSelectIndex(-1);
						comboObjects[1].SetSelectIndex(-1);
						formObj.cntr_spec_no.value = "";
						formObj.lsr_cd.value = "";
						formObj.lsr_nm.value = "";						
						formObj.chk_dgt.readOnly = true;
	                	formObj.chk_dgt.className="input";	
	                	formObj.cntr_grs_wgt.className = "input";		
	                	formObj.tare_wgt.className = "input";
	                	formObj.pay_load.value = "";		
	                	formObj.pay_load_lbs.value = "";		
					break;
					
					case "ComOpenPopupWithTarget3":
						//if(!checkAgmtNo(formObj)) return;
						var active_flag = "";
						var own_cntr_flg = "";
						var lstm_cd = "";
						lstm_cd = formObj.lstm_cd.value;
						if(  lstm_cd == 'OW' || lstm_cd == 'OL' || lstm_cd == 'LP' ){
							//Own
							active_flag = "4";
							own_cntr_flg = "O";
						} else if(lstm_cd == 'SH' || lstm_cd == 'SI' || lstm_cd == 'MI' || lstm_cd == 'OF' || lstm_cd == 'ST') {
							own_cntr_flg = "S";
							active_flag = "5";							
						}else{
							//Lease
							own_cntr_flg = "L";
							active_flag = "5";
						}
						if(formObj.cntr_no.value == "" ) {
							ComShowCodeMessage("MST00001", "CNTR No.");
					    	formObj.cntr_no.focus();
					    	return;
						}else if(formObj.btn_save.disabled == true ) {
							//ComShowCodeMessage("MST02014");
					    	formObj.cntr_spec_no.focus();
					    	return;
						}else{
							var strvndr_seq = formObj.lsr_cd.value;
							var strvndr_lgl_eng_nm = formObj.lsr_nm.value;
							if(own_cntr_flg=="S") {
								strvndr_seq="";
								strvndr_lgl_eng_nm="";
							}
							ComOpenPopupWithTarget('/opuscntr/EES_MST_0022_POP.do?active_flag='+active_flag+'&own_cntr_flg='+own_cntr_flg+'&lstm_cd='+lstm_cd+'&cntr_tpsz_cd='+formObj.cntr_tpsz_cd.value+
									'&strVndrSeq='+strvndr_seq+'&strVndrNm='+strvndr_lgl_eng_nm, 1250, 660, "cntr_spec_no:cntr_spec_no|cntr_grs_wgt:cntr_grs_wgt|tare_wgt:tare_wgt|pay_load:pay_load", "0,0", true);
						}
						
	   					break;
					case "btn_save":
						doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
					break;
					case "cal_img":
						func_calendar('calendarPopup1');
						break;
             } // end switch
         } catch(e) {
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
    * registering IBMultiCombo Object as list
    * adding process for list in case of needing batch processing with other items 
    * defining list on the top of source
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
		for (i=0; i<sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
		}
		for (var k=0; k<comboObjects.length; k++) {  	    	
			initCombo(comboObjects[k], k + 1);
 	    }
		vndr_abbr_nm.SetBackColor("#d4f6ff");
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH01);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		doActionIBSheet(sheetObjects[0], document.form, SEARCH08);
		doActionIBSheet(sheetObjects[0], document.form, SEARCH11);;
		doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
	}

	/**
	 * Initialize Combo.
	 */
	function initCombo(comboObj, comboNo) {
		var formObj = document.form;

		switch(comboObj.options.id) {
		 case "cntr_mtrl_cd": 
			   with (comboObj) { 
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "30");
					SetColWidth(1, "140");
				    SetDropHeight(160);
			   }   
			   break; 	
		 
		case "cntr_tpsz_cd" :
			comboObj.SetColAlign(0, "center");
			comboObj.SetDropHeight(160);
			comboObj.SetMultiSelect(0);
			comboObj.SetMaxSelect(1);
			comboObj.Style = 0;
			comboObj.SetEnable(false);
			comboObj.SetUseAutoComplete(1);
			break;
		case "vndr_abbr_nm" :
			comboObj.SetColAlign(0, "center");
			comboObj.SetColAlign(1, "left");
			comboObj.SetColWidth(0, "70");
			comboObj.SetColWidth(1, "200");
			comboObj.SetDropHeight(160);
			comboObj.SetMultiSelect(0);
			comboObj.SetMaxSelect(1);
			comboObj.Style = 0;
			comboObj.SetBackColor("#d4f6ff");
			comboObj.SetUseAutoComplete(1);
			break;
		case "rf_tp_cd" :
			comboObj.SetColAlign(0, "left");
			comboObj.SetColWidth(0, "170");
			comboObj.SetDropHeight(160);
			comboObj.SetMultiSelect(0);
			comboObj.SetMaxSelect(1);
			comboObj.Style = 0;
			comboObj.SetUseAutoComplete(1);
			break;
		}
  	}

	/**
	 * Initialize Control.
	 */
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerFormat("blur", "obj_blur", form); // handling OnBeforeDeactivate event of all control except rdoCity
		axon_event.addListenerFormat("beforeactivate", "obj_focus", form); // handling OnBeforeDeactivate event of all control that has dataformat attribute
		axon_event.addListenerForm("change", "obj_change", form); // when object is changed.		
		
		formObj.cntr_no.focus();
		ComBtnDisable("btn_save");
		comboObjects[3].SetEnable(0);
		comboObjects[4].SetEnable(0);

		if (formObj.cntr_no.value.length > 0) {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}
  	}

	//handling event blur
	function obj_blur(){
		var obj=ComGetEvent();
        if(ComGetEvent("name") == "mft_dt"){		
        	ComChkObjValid(obj);
        }
	}
	
	function obj_focus(){
		var obj=ComGetEvent();
        if(ComGetEvent("name") == "mft_dt"){		
        	ComClearSeparator(obj);
        }
	}
	
	function obj_focusout01() {
		
		var formObj = document.form;
		formObj.cntr_grs_wgt.value = formObj.cntr_grs_wgt.value.replaceStr(",");
		
		var strCntrGrsWgt = parseFloat(formObj.cntr_grs_wgt.value);
 		formObj.cntr_grs_wgt.value = strCntrGrsWgt.toFixed(3);
 		formObj.cntr_grs_wgt.value = ComAddComma(formObj.cntr_grs_wgt.value);
 		
 		var cntr_grs_wgt_lbs           = computeKgIbs(strCntrGrsWgt);
 		cntr_grs_wgt_lbs					= cntr_grs_wgt_lbs.toFixed(3);
 		formObj.cntr_grs_wgt_lbs.value = ComAddComma(cntr_grs_wgt_lbs);
 		formObj.tare_wgt.value = formObj.tare_wgt.value.replaceStr(",");
 		//팝업에서 가져올때
 		var strTareWgt = parseFloat(formObj.tare_wgt.value);
 		formObj.tare_wgt.value = strTareWgt.toFixed(3);
 		formObj.tare_wgt.value = ComAddComma(formObj.tare_wgt.value);
 		
 		var tare_wgt_lbs           = computeKgIbs(strTareWgt);
 		tare_wgt_lbs					= tare_wgt_lbs.toFixed(3);
 		formObj.tare_wgt_lbs.value = ComAddComma(tare_wgt_lbs);
 		
 		var cntr_grs_wgt = formObj.cntr_grs_wgt.value.replaceStr(",");
 		var tare_wgt = formObj.tare_wgt.value.replaceStr(",");
 		var pay_load=cntr_grs_wgt - tare_wgt;
 		
		pay_load = parseFloat(pay_load).toFixed(3);
		formObj.pay_load.value=ComAddComma(pay_load);
		formObj.pay_load_lbs.value=ComAddComma(computeKgIbs(pay_load));
 		
	}
	
	/**
	 * handling Focus-out Event
	 */
	function obj_focusout() {
		var obj = ComGetEvent();
		var formObj = document.form;
		switch(ComGetEvent("name")) {
		case "cntr_grs_wgt":
			if(ComTrim(obj.value) == "" && formObj.cntr_no.value!= "") obj.value = "0";
			var cntr_grs_wgt = obj.value.replaceStr(",");
			var tare_wgt = formObj.tare_wgt.value.replaceStr(",");
			
			if (ComTrim(obj.value) != "") {
				var cntr_grs_wgt = parseFloat(cntr_grs_wgt).toFixed(3);
				formObj.cntr_grs_wgt_lbs.value=ComAddComma(computeKgIbs(cntr_grs_wgt));
				
				var pay_load=cntr_grs_wgt - tare_wgt;
				pay_load = parseFloat(pay_load).toFixed(3);
				formObj.pay_load.value=ComAddComma(pay_load);
				formObj.pay_load_lbs.value=ComAddComma(computeKgIbs(pay_load));
			}
			sheetObjects[0].SetCellValue(1, "cntr_grs_wgt",obj.value.replaceStr(","));
		break;
		
		case "tare_wgt":
			if(ComTrim(obj.value) == "" && formObj.cntr_no.value!= "") obj.value = "0";
			var cntr_grs_wgt=formObj.cntr_grs_wgt.value.replaceStr(",");
			var tare_wgt=obj.value.replaceStr(",");
			if (ComTrim(obj.value) != "") {
				var tare_wgt = parseFloat(tare_wgt).toFixed(3);
				formObj.tare_wgt_lbs.value=ComAddComma(computeKgIbs(tare_wgt));
				
				var pay_load=cntr_grs_wgt - tare_wgt;
				pay_load = parseFloat(pay_load).toFixed(3);
				formObj.pay_load.value=ComAddComma(pay_load);
				formObj.pay_load_lbs.value=ComAddComma(computeKgIbs(pay_load));
			}
			sheetObjects[0].SetCellValue(1, "tare_wgt",obj.value.replaceStr(","));
		break;
		}
	}
  	/**
 	* handling Key-Down Event
 	*/
//	function obj_keydown() {
//		var obj=ComGetEvent();
//		var vKeyCode=event.keyCode;
//		var formObj=document.form;
//  		switch(ComGetEvent("name")) {
//			case "cntr_no":
//		  		if ( vKeyCode == 9 || vKeyCode == 13 ) {
//		  			SEARCH_ENABLE=false;
//		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//		  			SEARCH_ENABLE=true;
//		  			ComSetFocus(formObj.cntr_no);  			
//		  		}
//  		   break;
//	   }			
//	}
//  	function obj_keyup() {
// 		var obj=ComGetEvent();
// 		var vKeyCode=event.keyCode;
// 		var formObj=document.form;
//  		switch(ComGetEvent("name")) {
//			case "cntr_no":
//				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
//					ComKeyEnter('LengthNextFocus');
//				}
//			break;
//	   }
// 	}  	 
// 	function obj_keypress(){
//	    obj=ComGetEvent();
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "engup":
//	            if(obj.name=="cntr_no") ComKeyOnlyAlphabet('uppernum');
//	        break;
//	        case "ymd":
//	        	if(obj.name=="mft_dt") ComKeyOnlyNumber('int', "-");
//	        break;	            
//	    }        
//	}
	/**
	 * handling event on change
	 */
	function obj_change(){
		var obj = ComGetEvent();
		var formObj = document.form;
		if (ComTrim(ComGetObjValue(obj)) != "") {
			switch(ComGetEvent("name")) {
			case "cntr_no" :
				if (SEARCH_ENABLE) {
					formObj.cntr_no.value = formObj.cntr_no.value.toUpperCase(); // Copy&paste lower case to upper case
					formObj.chk_dgt.value="";
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					ComSetFocus(formObj.cntr_no);
				}
    			break;
			case "cntr_mtrl_cd" :
	    		arr_cntr_mtrl_cd[1] = obj.value;
	    		break;
	    	case "mft_dt" :
	    		arr_mft_dt[1] = obj.value;
				break;
	    	case "chk_dgt":
    			if ( formObj.chk_dgt.value !="" ) {
    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase() + formObj.chk_dgt.value; // Copy&paste lower case to upper case
    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    				//ComSetFocus(formObj.cntr_no);
    			}
    			break;
	    	case "cntr_grs_wgt":
	    		formObj.cntr_grs_wgt.value = formObj.cntr_grs_wgt.value.replaceStr(",");
 	    		//팝업에서 가져올때
 	    		var strCntrGrsWgt = parseFloat(formObj.cntr_grs_wgt.value);
 	    		formObj.cntr_grs_wgt.value = strCntrGrsWgt.toFixed(3);
 	    		formObj.cntr_grs_wgt.value = ComAddComma(formObj.cntr_grs_wgt.value);
 	    		
 	    		var cntr_grs_wgt_lbs           = computeKgIbs(strCntrGrsWgt);
 	    		cntr_grs_wgt_lbs					= cntr_grs_wgt_lbs.toFixed(3);
 	    		formObj.cntr_grs_wgt_lbs.value = ComAddComma(cntr_grs_wgt_lbs);
 	    		
 				break;
 	    	case "tare_wgt":
 	    		formObj.tare_wgt.value = formObj.tare_wgt.value.replaceStr(",");
 	    		//팝업에서 가져올때
 	    		var strTareWgt = parseFloat(formObj.tare_wgt.value);
 	    		formObj.tare_wgt.value = strTareWgt.toFixed(3);
 	    		formObj.tare_wgt.value = ComAddComma(formObj.tare_wgt.value);
 	    		var tare_wgt_lbs           = computeKgIbs(strTareWgt);
 	    		tare_wgt_lbs					= tare_wgt_lbs.toFixed(3);
 	    		formObj.tare_wgt_lbs.value = ComAddComma(tare_wgt_lbs);
 	    		
 				break;
 	    	case "pay_load":
 	    		formObj.pay_load.value = formObj.pay_load.value.replaceStr(",");
 	    		//팝업에서 가져올때
 	    		var strPayLoad = parseFloat(formObj.pay_load.value);
 	    		formObj.pay_load.value = strPayLoad.toFixed(3);
 	    		formObj.pay_load.value = ComAddComma(formObj.pay_load.value);
 	    		
 	    		var pay_load_lbs           = computeKgIbs(strPayLoad);
 	    		pay_load_lbs					= pay_load_lbs.toFixed(3);
 	    		formObj.pay_load_lbs.value = ComAddComma(pay_load_lbs);
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
         switch(sheetNo) {
             case 1:
            	 with(sheetObj){
		           SetConfig( { SearchMode:2, DataRowMerge:0 } );
		
		           var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		           var headers = [{Text: "", Align: "Center"}];
		           InitHeaders(headers, info);
		
		           var cols = [{}];
		           InitColumns(cols);
		           SetVisible(false);
             	 }
             break;
         }
     }
     
     
     function obj_change01(){
 		var obj = ComGetEvent();
 		var formObj = document.form;
 		if (ComTrim(ComGetObjValue(obj)) != "") {
 			switch(ComGetEvent("name")) {
 	    	case "cntr_grs_wgt":
 	    		//팝업에서 가져올때
 	    		var strCntrGrsWgt = parseFloat(formObj.cntr_grs_wgt.value);
 	    		formObj.cntr_grs_wgt.value = strCntrGrsWgt.toFixed(3);
 	    		formObj.cntr_grs_wgt.value = ComAddComma(formObj.cntr_grs_wgt.value);
 	    		
 	    		var cntr_grs_wgt_lbs           = computeKgIbs(strCntrGrsWgt);
 	    		cntr_grs_wgt_lbs					= cntr_grs_wgt_lbs.toFixed(3);
 	    		formObj.cntr_grs_wgt_lbs.value = ComAddComma(cntr_grs_wgt_lbs);
 	    		
 				break;
 	    	case "tare_wgt":
 	    		//팝업에서 가져올때
 	    		var strTareWgt = parseFloat(formObj.tare_wgt.value);
 	    		formObj.tare_wgt.value = strTareWgt.toFixed(3);
 	    		formObj.tare_wgt.value = ComAddComma(formObj.tare_wgt.value);
 	    		var tare_wgt_lbs           = computeKgIbs(strTareWgt);
 	    		tare_wgt_lbs					= tare_wgt_lbs.toFixed(3);
 	    		formObj.tare_wgt_lbs.value = ComAddComma(tare_wgt_lbs);
 	    		
 				break;
 	    	case "pay_load":
 	    		//팝업에서 가져올때
 	    		var strPayLoad = parseFloat(formObj.pay_load.value);
 	    		formObj.pay_load.value = strPayLoad.toFixed(3);
 	    		formObj.pay_load.value = ComAddComma(formObj.pay_load.value);
 	    		
 	    		var pay_load_lbs           = computeKgIbs(strPayLoad);
 	    		pay_load_lbs					= pay_load_lbs.toFixed(3);
 	    		formObj.pay_load_lbs.value = ComAddComma(pay_load_lbs);
 				break;	
 		    }
 		}	
 	}

	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch(sAction) {
		case IBSEARCH : // retrieve
			initDisplay();
			formObj.f_cmd.value = SEARCH;
			if (formObj.cntr_no.value.trim().length == 0) {
				ComShowCodeMessage("MST00001", "Cntr No.");
				formObj.cntr_no.focus();
				return;
			}
			
			if (formObj.cntr_no.value.trim().length == 10){
        		formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase() + formObj.chk_dgt.value; // Copy&paste lower case to upper case
        	}
			
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchData("EES_MST_0044GS.do", FormQueryString(formObj) + "&gubun=1");
			var chk = sXml.indexOf("ERROR");
			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1) {
				sheetObj.LoadSearchData(sXml, {Sync:0});
				ComOpenWait(false);
				return;
			}
			// fill data to input boxes 	  
			var strCntrNo                  = ComXmlString(sXml, "cntr_no")+"";
			var cntr_grs_wgt               = ComXmlString(sXml, "cntr_grs_wgt");
			var cntr_grs_wgt_lbs           = computeKgIbs(cntr_grs_wgt);
			var tare_wgt                   = ComXmlString(sXml, "tare_wgt");
			var tare_wgt_lbs               = computeKgIbs(tare_wgt);
			var pay_load                   = ComXmlString(sXml, "pay_load");
			var pay_load_lbs               = computeKgIbs(pay_load);
			
        	formObj.cntr_no.value          = strCntrNo.substring(0,10);
			formObj.chk_dgt.value          = ComXmlString(sXml, "chk_dgt");
			formObj.aciac_div_cd.value     = ComXmlString(sXml, "aciac_div_cd");
			formObj.sub_lstm_cd.value      = ComXmlString(sXml, "sub_lstm_cd");
			formObj.lstm_cd.value          = ComXmlString(sXml, "lstm_cd");
			formObj.cntr_tpsz_iso_cd.value = ComXmlString(sXml, "cntr_tpsz_iso_cd");
			formObj.cntr_spec_no.value     = ComXmlString(sXml, "cntr_spec_no");
			formObj.cntr_spec_tp_cd.value  = ComXmlString(sXml, "cntr_spec_tp_cd");			
			formObj.lsr_cd.value           = ComXmlString(sXml, "lsr_cd");
			formObj.lsr_nm.value           = ComXmlString(sXml, "lsr_nm");
			
			cntr_grs_wgt     = parseFloat(cntr_grs_wgt).toFixed(3);
			cntr_grs_wgt_lbs = parseFloat(cntr_grs_wgt_lbs).toFixed(3);
			tare_wgt         = parseFloat(tare_wgt).toFixed(3);
			tare_wgt_lbs     = parseFloat(tare_wgt_lbs).toFixed(3);
			pay_load         = parseFloat(pay_load).toFixed(3);
			pay_load_lbs     = parseFloat(pay_load_lbs).toFixed(3);
			
			formObj.cntr_grs_wgt.value     = ComAddComma(cntr_grs_wgt);
			formObj.cntr_grs_wgt_lbs.value = ComAddComma(cntr_grs_wgt_lbs);
			formObj.tare_wgt.value         = ComAddComma(tare_wgt);
			formObj.tare_wgt_lbs.value     = ComAddComma(tare_wgt_lbs);
			
			var pay_load=cntr_grs_wgt - tare_wgt;
			pay_load = parseFloat(pay_load).toFixed(3);
			formObj.pay_load.value=ComAddComma(pay_load);
			formObj.pay_load_lbs.value=ComAddComma(computeKgIbs(pay_load));
			
			f_change_data_setting(formObj, true);
			comboObjects[0].SetEnable(1);
			comboObjects[0].SetSelectCode(ComXmlString(sXml, "cntr_tpsz_cd") + "", true);
			comboObjects[1].SetSelectCode(ComXmlString(sXml, "cntr_mtrl_cd") + "", true);
			
			formObj.cntr_mtrl_cd.value     = ComXmlString(sXml, "cntr_mtrl_cd");  
			formObj.cntr_use_co_cd.value   = ComXmlString(sXml, "cntr_use_co_cd");
			formObj.ownr_co_cd.value       = ComXmlString(sXml, "ownr_co_cd");
			formObj.vndr_lgl_eng_nm.value  = ComXmlString(sXml, "vndr_lgl_eng_nm");
			formObj.rf_cmpr_ctnt.value     = ComXmlString(sXml, "rf_cmpr_ctnt");
			formObj.lot_pln_yr.value       = ComXmlString(sXml, "lot_pln_yr");
			formObj.lot_loc_cd.value       = ComXmlString(sXml, "lot_loc_cd");
			formObj.lot_cntr_tpsz_cd.value = ComXmlString(sXml, "lot_cntr_tpsz_cd");
			formObj.lot_seq.value          = ComXmlString(sXml, "lot_seq");
			
			comboObjects[2].SetSelectText(ComXmlString(sXml, "vndr_abbr_nm") + "", true);
			formObj.mft_dt.value = ComXmlString(sXml, "mft_dt");
			if (ComXmlString(sXml, "d2_payld_flg") == 'Y')
				formObj.d2_payld_flg.checked = true;
				comboObjects[2].SetEnable(1);
				vndr_abbr_nm.SetBackColor("#d4f6ff");
				rf_tp_cd.SetBackColor("#CCFFFD");
			ComSetObjValue(rf_tp_cd, ComXmlString(sXml, "rf_tp_cd"));
			ComSetObjValue(formObj.rf_humid_ctrl_val_cd, ComXmlString(sXml, "rf_humid_ctrl_val_cd"));
			if (vndr_abbr_nm.GetSelectText() == "") {
				vndr_abbr_nm.SetSelectText(ComXmlString(sXml, "vndr_abbr_nm"));
			}
			if (formObj.chk_dgt.value == "" && formObj.lstm_cd.value == "" && formObj.cntr_tpsz_cd.value == "" && formObj.aciac_div_cd.value == "") {
				ComBtnDisable("btn_save");
			} else {
				f_change_data_setting(formObj, true);
				ComBtnEnable("btn_save");
			}
			comboObjects[3].SetSelectCode(ComXmlString(sXml, "rf_tp_cd") + "", true);
			comboObjects[4].SetSelectCode(ComXmlString(sXml, "rf_humid_ctrl_val_cd") + "", true);
			
			var strLeftTs = ComXmlString(sXml, "cntr_tpsz_cd")+"";
			
			if(strLeftTs.substr(0, 1) != "R" ) {
				comboObjects[3].SetEnable(0);
				comboObjects[4].SetEnable(0);
				formObj.rf_cmpr_ctnt.readOnly=true;
			}else{
				comboObjects[3].SetEnable(1);
				comboObjects[4].SetEnable(1);
				formObj.rf_cmpr_ctnt.readOnly=false;
			}
			
			if(strCntrNo == "") {
    			formObj.chk_dgt.readOnly = true;
            	formObj.chk_dgt.className="input";			
			}else{
				formObj.chk_dgt.readOnly = false;
				formObj.chk_dgt.className="input1";
			}
			
			if(formObj.lstm_cd.value == "SH") {
				comboObjects[0].SetEnable(true);
			} else {
				comboObjects[0].SetEnable(false);
			}
			// <begin> 2017.07.22 BluePrint#15678: Office user access restriction to screens to update Container Master data by Jiyeon Jeon 
			// Pre condition : When login user is not HO office user.
			if (!OfficeCodeMgr.checkContainOfficeCode("000002", "LSE", ComGetObjValue(formObj.usr_ofc_cd)) ) {
				//Users can only update Gross&Tare weight&Pay Load values.
				comboObjects[0].SetEnable(false);
				comboObjects[1].SetEnable(false);
				comboObjects[2].SetEnable(false);
				comboObjects[3].SetEnable(false);
				comboObjects[4].SetEnable(false);
				formObj.mft_dt.readOnly = true;
				formObj.cntr_spec_no.readOnly = true;
				formObj.cntr_spec_no.className="input";	
				formObj.rf_cmpr_ctnt.readOnly = true;
				formObj.cntr_grs_wgt.readOnly = false;
				formObj.tare_wgt.readOnly = false;
				
				ComBtnDisable("cal_img");
				ComBtnDisable("ComOpenPopupWithTarget3");
				// If the Spec No is not "Standard Spec"(CNTR_SPEC_TP_CD != "S"), disable to update Tare Weight, gross weight and Payload info.
				if(formObj.cntr_spec_tp_cd.value != "Standard") {
					formObj.cntr_grs_wgt.readOnly = true;
					formObj.tare_wgt.readOnly = true;
					formObj.pay_load.readOnly = true;
				}
			}

			// <end> 2017.07.22 BluePrint#15678: Office user access restriction to screens to update Container Master data  By Jiyeon Jeon  
			ComOpenWait(false);
 			break;
 			
		case IBSEARCH01 :
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchData("EES_MST_COMGS.do" , FormQueryString(formObj)+"&eq_knd_cd=U");
			var chk = sXml.indexOf("ERROR");
			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1) {
				sheetObj.LoadSearchData(sXml,{Sync:0});
				return;
			}

			// TP/SZ retrieve.
			var cntr_tpsz_cd = ComGetEtcData(sXml, "cntr_tpsz_cd");
			head_cntr_tpsz_cd = cntr_tpsz_cd;
			tot_cntr_tpsz_cd = cntr_tpsz_cd;
			formObj.head_cntr_tpsz_cd.value = head_cntr_tpsz_cd;

			var strCntrTpszCd = cntr_tpsz_cd.split("|");
			comboObjects[0].SetMultiSelect(0);
			comboObjects[0].SetDropHeight(150);
			for (var i=0; i<strCntrTpszCd.length; i++) {
				comboObjects[0].InsertItem(i, ComTrim(strCntrTpszCd[i]), ComTrim(strCntrTpszCd[i]));
			}
			
			//Material code
			formObj.f_cmd.value=SEARCH09;	
			var intgCdId='CD01862';
			var param="&intgCdId="+intgCdId;
			var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
			var chk=xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xml,{Sync:1} );
			   return;
		    } 
			
			if (xml != "") {
				var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
				var arrCntrMtrlCdNm=sCntrMtrlCdNm.split("@");
				MakeComboObject(comboObjects[1], arrCntrMtrlCdNm, 1, 0);
			}
			
			break;
		case IBSEARCH_ASYNC01 :
			formObj.f_cmd.value = SEARCH01;
			sheetObj = sheetObjects[0];
			var xmlStr = sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
			var chk = xmlStr.indexOf("ERROR");
			if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1) {
				sheetObj.LoadSearchData(xmlStr,{Sync:0});
				return;
			}
			var sStr = ComGetEtcData(xmlStr, "comboList");
			var arrStr = sStr.split("@");
			MakeComboObject(vndr_abbr_nm, arrStr, 1, 0); 
			comboObjects[2].SetColAlign(0, "center");
			comboObjects[2].SetColAlign(1, "left");
			comboObjects[2].SetColWidth(0, "70");
			comboObjects[2].SetColWidth(1, "200");
			comboObjects[2].SetDropHeight(160);
			comboObjects[2].SetMultiSelect(0);
			comboObjects[2].SetMaxSelect(1); 
			break;
		case IBSAVE :
			    if (formObj.cntr_no.value.trim().length == 0 || formObj.cntr_mtrl_cd.value.trim() == ""){
			    	if (formObj.cntr_no.value.trim().length == 0){
				    	   ComShowCodeMessage("MST00001", "CNTR No.");
				    	   formObj.cntr_no.focus();
				    	   return;
				    } else if (formObj.cntr_tpsz_cd.value.trim() == "" && formObj.lstm_cd.value != "SH"){
				    	   ComShowCodeMessage("MST00001", "TP/SZ");
				    	   formObj.cntr_tpsz_cd.focus();
				    	   return;
				    } else if (formObj.cntr_mtrl_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Material");
				    	   formObj.cntr_mtrl_cd.focus();
				    	   return;
				    } else if (formObj.sub_lstm_cd.value.trim() == "" && formObj.lstm_cd.value.trim() == "") {
			    		   ComShowCodeMessage("MST00012");
				    	   formObj.cntr_no.focus();
				    	   return;
			    	} 
			    }	
		    	sheetObj.SetWaitImageVisible(0);
		    	ComOpenWait(true);
		    	formObj.f_cmd.value=MULTI;
		    	
		    	var cntr_grs_wgt = formObj.cntr_grs_wgt.value.replaceStr(",");
				var tare_wgt = formObj.tare_wgt.value.replaceStr(",");
				var pay_load = formObj.pay_load.value.replaceStr(",");
		    	formObj.cntr_grs_wgt.value = cntr_grs_wgt
		    	formObj.tare_wgt.value = tare_wgt	
		    	formObj.pay_load.value = pay_load	
		    	var sXml=sheetObj.GetSaveData("EES_MST_0044GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") == -1 && sXml.indexOf("Error") == -1) {
				    ComShowCodeMessage("MST01025")
				}
				else {
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					f_change_data_setting(formObj, true);
				}
				formObj.cntr_grs_wgt.value=ComAddComma(cntr_grs_wgt);
				formObj.tare_wgt.value=ComAddComma(tare_wgt);
				formObj.pay_load.value=ComAddComma(pay_load);
	        break;
	        case SEARCH08:
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH08;
				var xml="";
				xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
				var comboItems=ComGetEtcData(xml, "unit_type").split("|");
				if(comboItems != ""){
					addComboItem(rf_tp_cd, comboItems);
				}
				

				/* Contaer Type/Size Item Setting */
				var sParam = "f_cmd=" + SEARCH02;		
		     	var sXml = sheetObj.GetSearchData("EES_LSE_COMGS.do", sParam);
		        if ( sXml != "" ) {
		        	var cntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");
		        	var arrCntrTpSzCd = cntrTpszCd.split("|");		        	
		        	for ( var i = 0 ; i < arrCntrTpSzCd.length ; i++ ) {
		        		comboObjects[0].InsertItem(i, arrCntrTpSzCd[i]+"|"+arrCntrTpSzCd[i], arrCntrTpSzCd[i]);		        					        		
		        	}
		        	comboObjects[0].SetColWidth("40|40");
	        		comboObjects[0].Index = 0;
		        }	
		        
				ComOpenWait(false);
				break;
	        case SEARCH11:
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);			
				formObj.f_cmd.value=SEARCH11;			
				var xml="";
				var rfHumidCtrlValCdCnt = 0;
				xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));				
				rfHumidCtrlValCdCnt = ComGetEtcData(xml, "rf_humid_ctrl_val_cd").split("|").length;
				if(rfHumidCtrlValCdCnt > 0) {
					var comboItems=ComGetEtcData(xml, "rf_humid_ctrl_val_cd").split("|");
					if(comboItems != ""){
						addComboItem(rf_humid_ctrl_val_cd, comboItems);
					}	
				}
				ComOpenWait(false);
				break;
	        case IBINSERT:  //inserting
	        	f_change_data_setting(formObj, false);
	        	break;
       }
    }
	
  	/**
  	 * creating combo object(Spec No * Type/Size)
  	 */
  	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
  		cmbObj.RemoveAll();
  		//cmbObj.InsertItem(0, "", "");
  		for (var i=0; i<arrStr.length; i++) {
  			var arrCode=arrStr[i].split("|");
  			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
  		}
  		cmbObj.SetSelectIndex("" ,false);
  	}    

    /**
     * Initialize Display.
     */
	function initDisplay() {
		var formObj = document.form;

		formObj.aciac_div_cd.value = "";
		comboObjects[0].SetSelectIndex(-1);
		formObj.sub_lstm_cd.value = "";
		formObj.lstm_cd.value = "";
		formObj.cntr_mtrl_cd.value = "";         
		formObj.tare_wgt.value = "";        
		formObj.tare_wgt.className = "input";
		formObj.tare_wgt_lbs.value = "";
		formObj.cntr_grs_wgt.value = "";
		formObj.cntr_grs_wgt.className = "input";
		formObj.cntr_grs_wgt_lbs.value = "";
		formObj.pay_load.value = "";
		formObj.pay_load_lbs.value = "";
		formObj.cntr_use_co_cd.value = "";
		formObj.ownr_co_cd.value = "";
		vndr_abbr_nm.SetSelectText("");
		vndr_abbr_nm.SetEnable(true);
		vndr_abbr_nm.SetBackColor("#d4f6ff");
		formObj.vndr_lgl_eng_nm.value = "";
		formObj.mft_dt.value = "";
		formObj.d2_payld_flg.checked = false;
		formObj.rf_tp_cd_text.value = "";
		formObj.cntr_tpsz_iso_cd.value = "";
		f_change_data_setting(formObj, false);
	}

	/**
	 * vndr_abbr_nm OnChange handling event 
	 */
	function vndr_abbr_nm_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj,Index_Code, Text){
		var formObj = document.form;
		formObj.vndr_lgl_eng_nm.value = vndr_abbr_nm.GetText(newCode, 1);
		arr_vndr_abbr_nm[1] = newCode;
	}	

	function cntr_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		
		if(oldCode != "" && newCode != "" && oldCode != newCode){
			if(ComShowCodeConfirm("MST02037") != true){
				formObj.cntr_tpsz_cd.value = oldCode;
			}
		}
		
		if (newText.substring(0,1) == "R"){
			rf_tp_cd.disabled=false;
    		// document.getElementById("rf_tp_cd").className="input1";
			rf_tp_cd.className = "input1";
		} else {
			rf_tp_cd.disabled=true;
    		//document.getElementById("rf_tp_cd").className="input2";
    		rf_tp_cd.className="input2";
    		formObj.rf_tp_cd.value="";
		}
	}

	/*
	 * vndr_abbr_nm OnChange handling event 
	 */
     function func_calendar(){
     	var formObj=document.form; 
         if (formObj.mft_dt.readOnly == false){    	 
 	         var cal=new ComCalendar();
 	         cal.select(document.form.mft_dt, "yyyy-MM-dd");
         } 
      }
	 /**
	  * adding tem to combo field
	  */
	 function addComboItem(comboObj, comboItems) {
		  for ( var i=0; i < comboItems.length; i++) {
	 		var comboItem=comboItems[i].split(",");
	 		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
	 	}
		  comboObj.InsertItem(0,"","");
	 }
	 /**
	  * 변경 가능한 컬럼에 대한 전,후 데이터를 셋팅한다.
	  */
	 function f_change_data_setting(formObj, inputFlg) {
		 if (inputFlg == true) {
			 arr_cntr_mtrl_cd[0] = formObj.cntr_mtrl_cd.value;
			 arr_cntr_mtrl_cd[1] = formObj.cntr_mtrl_cd.value;
			 arr_vndr_abbr_nm[0] = formObj.vndr_abbr_nm.text;			 
			 arr_vndr_abbr_nm[1] = formObj.vndr_abbr_nm.text;
			 arr_mft_dt[0]       = formObj.mft_dt.value;
			 arr_mft_dt[1]       = formObj.mft_dt.value;
			 arr_cntr_grs_wgt[0] = formObj.cntr_grs_wgt.value;  
			 arr_cntr_grs_wgt[1] = formObj.cntr_grs_wgt.value;
			 arr_tare_wgt[0]     = formObj.tare_wgt.value;  
			 arr_tare_wgt[1]     = formObj.tare_wgt.value;
			 arr_pay_load[0]     = formObj.pay_load.value;  
			 arr_pay_load[1]     = formObj.pay_load.value;
			 
		 } else {
			 arr_cntr_mtrl_cd[0]="";
			 arr_cntr_mtrl_cd[1]="";
			 arr_vndr_abbr_nm[0]="";
			 arr_vndr_abbr_nm[1]="";
			 arr_mft_dt[0]="";
			 arr_mft_dt[1]="";
			 arr_cntr_grs_wgt[0]="";  
			 arr_cntr_grs_wgt[1]="";     
			 arr_tare_wgt[0]="";  
			 arr_tare_wgt[1]="";     
			 arr_pay_load[0]="";  
			 arr_pay_load[1]="";     
			 
		 }
	 }
	 /**
	  * 변경 가능한 컬럼에 대한 전,후 데이터 변경 여부를 리턴한다.
	  * return Value
	  * true : 변경 됨
	  * false : 유지 됨
	  */
	 function f_change_data_checking(formObj) {
		 arr_cntr_grs_wgt[1] = formObj.cntr_grs_wgt.value;
		 arr_tare_wgt[1]     = formObj.tare_wgt.value;
		 if ((getZeroToNum(arr_cntr_grs_wgt[0]) !=  getZeroToNum(arr_cntr_grs_wgt[1])) ||      
			 (getZeroToNum(arr_tare_wgt[0]) !=  getZeroToNum(arr_tare_wgt[1] )) ||      
			 (getZeroToNum(arr_pay_load[0]) !=  getZeroToNum(arr_pay_load[1] )) ) {
			return  ComShowCodeConfirm("COM130504")  ;
		 } else {
			 return false;
		 }
	 }
	 /**
	  * Kg to Ibs(kg * 2.20459)
	  * @param kg
	  * @return
	 */
	function computeKgIbs(kg) {
		return ComRound(kg * 2.20459, 3);
	}
