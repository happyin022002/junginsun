/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0168.js
*@FileTitle  : VGM Dashboard
*@author     : CLT
*@version    : 1.0
*@since      : 2016/06/01
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
 // Common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var rowsPerPage=999999;
// var fnl_cls_str="Y|N";
 var fnl_cls_str="N|Y";
 var wgtUtCd="KGS|LBS";
 var prefix="sheet1_";//IBSheet Delimiter
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
 	var comboObjects=new Array();
	var p_no_goodMultiComboDataAdded=false;
	var rcv_term_cdMultiComboDataAdded=false;
	var de_term_cdMultiComboDataAdded=false;
	var p_bkg_cust_tp_cdMultiComboDataAdded=false;
	//registering IBCombo Object as list
	//ComComboObject Called from the constructor method
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	} 	
/**
 * RD print -> Used to create the search criteria
 */
 		var searchOptionsMap={ p_vvd:'form.p_vvd.value', 
						 pol:"eval(\"form.p_pol_cd.value != '' ? form.p_pol_cd.value:''\")"+
	  						"+eval(\"form.p_pol_yd_cd.value != '' ? ' Yard:'+form.p_pol_yd_cd.value :''\")"+
	  						//"+eval(\"form.p_pol_lt.options[form.p_pol_lt.selectedIndex].text != '' ? ' L/T:'+form.p_pol_lt.options[form.p_pol_lt.selectedIndex].text:''\")",
	  						"+eval(\"form.p_pol_lt.value != '' ? ' L/T:'+form.p_pol_lt.value:''\")",											 
                         p_por_cd:'form.p_por_cd.value',
						 p_apod_cd:"eval(\"form.p_apod_cd.value != '' ? form.p_apod_cd.value:''\")"+
						 			//"+eval(\"form.p_apod_lt.options[form.p_apod_lt.selectedIndex].text != '' ? ' L/T:'+form.p_apod_lt.options[form.p_apod_lt.selectedIndex].text:''\")",
	          						"+eval(\"form.p_apod_lt.value != '' ? ' L/T:'+form.p_apod_lt.value:''\")",
                         p_del_cd:'form.p_del_cd.value',
                         p_eq_type:"p_eq_type.GetSelectText()" ,
                        // p_rcv_term_cd:"p_rcv_term_cd.Text" , 
                        // p_de_term_cd:"p_de_term_cd.Text" ,
                         rd:"eval(\"p_rcv_term_cd.GetSelectText()!= '' ? p_rcv_term_cd.GetSelectText()+(p_de_term_cd.GetSelectText()!= '' ? '/':''):''\")"+
  					        "+eval(\"p_de_term_cd.GetSelectText()!= '' ? p_de_term_cd.GetSelectText():''\")",
                         p_bkg_ofc_cd:"form.p_bkg_ofc_cd.value",
                         p_doc_usr_id:"form.p_doc_usr_id.value",
                         p_ob_sls_ofc_cd:"form.p_ob_sls_ofc_cd.value",
                         p_ob_srep_cd:"form.p_ob_srep_cd.value",
                         p_bkg_sts_cd:"p_bkg_sts_cd.GetSelectText()" ,
                         p_zone_cd:"form.p_zone_cd.options[form.p_zone_cd.selectedIndex].text" ,
//                        p_dcgo_flg:"form.p_dcgo_flg.checked ? 'Danger':''" , 
//                        p_rc_flg:"form.p_rc_flg.checked ? 'Reefer':''" , 
//                        p_awk_cgo_flg:"form.p_awk_cgo_flg.checked ? 'Awkward':''" , 
//                        p_bb_cgo_flg:"form.p_bb_cgo_flg.checked ? 'Break Bulk':''" ,
                         special_cargo:"eval(\"form.p_dcgo_flg.checked ? 'Danger'+(form.p_rc_flg.checked || form.p_awk_cgo_flg.checked || form.p_bb_cgo_flg.checked ? '/':''):''\")"+
							           "+eval(\"form.p_rc_flg.checked ? 'Reefer'+(form.p_awk_cgo_flg.checked || form.p_bb_cgo_flg.checked ? '/':''):''\")"+
										 "+eval(\"form.p_awk_cgo_flg.checked ? 'Awkward'+(form.p_bb_cgo_flg.checked ? '/':''):''\")"+
										 "+eval(\"form.p_bb_cgo_flg.checked ? 'Break Bulk':''\")",
                         p_bdr_flg:"form.p_bdr_flg.options[form.p_bdr_flg.selectedIndex].text" ,
                         p_si_flg:"form.p_si_flg.options[form.p_si_flg.selectedIndex].text" ,
                         p_obl_iss_ofc_cd:"form.p_obl_iss_ofc_cd.value",
//                        p_bkg_cust_tp_cd:"p_bkg_cust_tp_cd.Text" ,
//                        p_cust_cnt_cd:"form.p_cust_cnt_cd.value",
//                        p_cust_seq:"form.p_cust_seq.value",
//                        p_cust_nm:"form.p_cust_nm.value",
//                         
                          customer:"eval(\"p_bkg_cust_tp_cd.GetSelectText()!= '' ? p_bkg_cust_tp_cd.GetSelectText()+(form.p_cust_cnt_cd.value != '' || form.p_cust_seq.value != '' || form.p_cust_nm.value != '' ? '/':''):''\")"+
							       "+eval(\"form.p_cust_cnt_cd.value != '' ? ' '+form.p_cust_cnt_cd.value +(form.p_cust_seq.value != '' || form.p_cust_nm.value != '' ? '/':''):''\")"+
							       "+eval(\"form.p_cust_seq.value != '' ? ' '+form.p_cust_seq.value +(form.p_cust_nm.value != '' ? '/':''):''\")"+
							       "+eval(\"form.p_cust_nm.value != '' ? ' '+form.p_cust_nm.value :''\")"
//                         p_no_good:"ComReplaceStr(p_no_good.Text,'|',',')" 
			}	
/**
 * RD print ->  search criteria Title
 */
		var searchOptionsTitleMap={ p_vvd:'VVD', 
				 pol:"POL",											 
	             p_por_cd:'POR',
				 p_apod_cd:"A/POD",
	             p_del_cd:'DEL',
	             p_eq_type:"E/Q Type" , 
	             rd:"R/D",
	             p_bkg_ofc_cd:"BKG Office",
	             p_doc_usr_id:"BKG STF",
	             p_ob_sls_ofc_cd:"Sales Office",
	             p_ob_srep_cd:"Sales Rep",
	             p_bkg_sts_cd:"BKG Status" ,
	             p_zone_cd:"Zone" ,
	             special_cargo:"Special Cargo",
	             p_bdr_flg:"BDR Status" ,
	             p_si_flg:"S/I Received" ,
	             p_obl_iss_ofc_cd:"B/L Office",
	             customer:"Customer",
	             p_no_good:"No Good" 
		}		
/**
 	 * The default setting Combo
 	 * param : comboObj ==> Combo Object, comboNo ==> Combo Object tag Id +serial number
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject=document.form;
 	    if(comboId == "vgm_val"){
    			comboObj.SetDropHeight(200);
    			initCombo_vgm_val();
 	    }else{
 					initComboEditable(comboObj)
 	    } 
 	}
 	 function initComboEditable(combo){
	 	 	with (combo) {
	 	 		SetMultiSelect(0);
	 	 		SetUseEdit(1);
	 	 	}
 	 }
/*############################# combo onchage start ########################*/
/**
	 * Check if the value entered in MultiCombo int added
	 * After changes to the English uppercase input value re-input
	 * @param comboObj
	 * @return
	 */
	function rcv_term_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.options.id+"MultiComboDataAdded"));
	 }
	function de_term_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.options.id+"MultiComboDataAdded"));
	 }
	function p_bkg_cust_tp_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.options.id+"MultiComboDataAdded"));
	 }
	function combo_Change(comboObj, multiComboDataAddedFlag) {
		var formObject=document.form;  
   	 	var comboText=comboObj.GetSelectText().toUpperCase();
   	 	if (multiComboDataAddedFlag) { 
   	 			comboObj.DeleteItem(0);
	 			multiComboDataAddedFlag=false; 
   	 	} 
   	 	if (comboObj.FindItem(comboText, 0) != -1) {
   	 		return; 
   	 	} 
   	 	//comboObj.InsertItem(0, comboText, comboText); 
	 	multiComboDataAddedFlag=true; 
	 	comboObj.SetSelectText(comboText,false);
	 }	 
/*############################# combo onchage end ########################*/	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
	    }	
		  //MultiCombo initialization
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k], comboObjects[k].options.id);
	    }
	    initControl();
	    //for multi combo gives 0.1 seconds for the delay
	    setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH01); },100);
	 	//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	    document.form.in_vvd.focus();
	    jqueryEvent();
     }
    function initControl() {
    	var formObject=document.form;
//        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- When typing the keyboard
//        axon_event.addListenerForm  ('beforedeactivate', 'bkg_deactivate',  formObject); //- out  focus 
//        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- in  focus 
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    }        
// Event handler processing by button click event */
 		document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
          var sheetObject1=sheetObjects[0];
					var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	     	try {
	     		var srcName=ComGetEvent("name");
	     	    if(ComGetBtnDisable(srcName)) return false;
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_New":
		 					location.reload(true);
		 					formObject.in_vvd.focus();
		 					break;
		 				case "btn_DownExcel":
		 					if(sheetObject1.RowCount() < 1){//no data
		 						ComShowCodeMessage("COM132501");
		 					}else{
		 						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					}
		 					break;
		 				case "btn_Print":
		 					doActionIBSheet(sheetObject1,formObject,RDPRINT);
		 					break;
						case "btn_board_date":
		 					var cal=new ComCalendarFromTo();
							cal.select(formObject.board_from_dt, formObject.board_to_dt,'yyyy-MM-dd');
						 	break;
						case "btn_bkg_date":
							var cal=new ComCalendarFromTo();
							cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
							break; 		
						case "btn_DownExcel":
							doActionIBSheet(sheetObject,formObject,IBSENDEMAILFAX);
							break;
						case "btn_vgm_upd":
							for(var i=2;i <= sheetObject1.LastRow();i++){
								if(sheetObject1.GetCellValue(i,prefix+"check") ==1){
									sheetObject1.SetCellValue(i,prefix+"vgm_wgt",sheetObject1.GetCellValue(i,prefix+"xter_vgm_wgt"));
									sheetObject1.SetCellValue(i,prefix+"vgm_wgt_ut_cd",sheetObject1.GetCellValue(i,prefix+"xter_vgm_wgt_ut_cd")); 
									sheetObject1.SetCellValue(i,prefix+"vgm_wgt_upd_usr_id",formObject.strUsr_id.value); 
									sheetObject1.SetCellValue(i,prefix+"vgm_wgt_upd_dt",ComGetNowInfo()+" "+ComGetNowInfo("hm"));
									sheetObject1.SetCellBackColor(i,prefix+"vgm_wgt","#58FA58");
									sheetObject1.SetCellBackColor(i,prefix+"vgm_wgt_ut_cd","#58FA58");
									sheetObject1.SetCellBackColor(i,prefix+"vgm_wgt_upd_usr_id","#58FA58");
									sheetObject1.SetCellBackColor(i,prefix+"vgm_wgt_upd_dt","#58FA58");
								} 
							}
						case "btn_save":
							doActionIBSheet(sheetObject1, formObject, IBSAVE);
							break;
		                case "btn_History":
		                    //Window Open
		                	var slt =  sheetObject1.GetSelectRow();
		                	var bkgNo = sheetObject1.GetCellValue(slt,prefix+"bkg_no");
		                    ComOpenPopup("/opuscntr/ESM_BKG_0169.do?bkg_no="+bkgNo, 800, 600, false, '0,0', true, true, 0);
		                    break;
		                case "btn_email":
		                	doActionIBSheet(sheetObject1, formObject, COMMAND02);
		                	break;
		                case "btn_edi":
		                	if(sheetObject1.CheckedRows(prefix+"check") == 0){
		                		ComShowCodeMessage("BKG00249");
		                		return false;
		                	}
		        			for (var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++) {
		        				if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && sheetObject1.GetCellValue(i, prefix+"vgm_clz_flg")=="Y" ){
	        						ComShowCodeMessage("BKG08342",sheetObject1.GetCellValue(i, prefix+"bkg_no"));
	        						return false;
		        				}
	                			if(formObject.in_pol_cd.value.substring(0,2) == "KR" && formObject.in_pol_lt.value != sheetObject1.GetCellValue(i,prefix+"lt") ){
	                				ComShowCodeMessage("BKG08348");
	                				return false;
	                			}
		        			}
		        			var notUpdVgm = 0;
		                	for (var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++) {
		                		if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && 
		                				(((sheetObject1.GetCellValue(i, prefix+"vgm_wgt") == "" || sheetObject1.GetCellValue(i, prefix+"vgm_wgt") == null) 
		                						&& sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt") != "") 
		                				  || sheetObject1.GetCellValue(i, prefix+"vgm_wgt") != sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt"))){
		                			formObject.save_flg.value = 'Y'
		                			notUpdVgm++;
		                		}
		                	}
		                	if(notUpdVgm>0){
	                			if(!ComShowCodeConfirm("BKG08345")){
	                				formObject.save_flg.value = 'N'
	                				return false;
	                			}
//	                			for (var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++) {
//	                				if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt")==""){
//	                					formObject.save_flg.value = 'N'
//	                					ComShowCodeMessage("BKG08346");
//	                					return false;
//	                				}
//	                			}
		                	}
		                	formObject.edi_tp_cd.value = "C";
		                	if(formObject.save_flg.value == 'Y'){
		                		doActionIBSheet(sheetObject1, formObject, COMMAND03);
                				formObject.save_flg.value = 'N'
		                	}else{
		                		doActionIBSheet(sheetObject1, formObject, COMMAND04);
		                	}
		                	break;
		                case "btn_vgm_close":
		                	if(sheetObject1.CheckedRows(prefix+"check") == 0){
		                		ComShowCodeMessage("BKG00249");
		                		return false;
		                	}
		        			var notUpdVgm = 0;
		                	for (var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++) {
		                		if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && 
		                				(((sheetObject1.GetCellValue(i, prefix+"vgm_wgt") == "" || sheetObject1.GetCellValue(i, prefix+"vgm_wgt") == null) 
		                						&& sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt") != "") 
		                				  || sheetObject1.GetCellValue(i, prefix+"vgm_wgt") != sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt"))){
		                			formObject.save_flg.value = 'Y'
		                			notUpdVgm++;
		                		}
	                			if(formObject.in_pol_cd.value.substring(0,2) == "KR" && formObject.in_pol_lt.value != sheetObject1.GetCellValue(i,prefix+"lt") ){
	                				ComShowCodeMessage("BKG08348");
	                				return false;
	                			}
		                	}
		                	if(notUpdVgm>0){
	                			if(!ComShowCodeConfirm("BKG08345")){
	                				formObject.save_flg.value = 'N'
	                				return false;
	                			}
//	                			for (var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++) {
//	                				if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt")==""){
//	                					formObject.save_flg.value = 'N'
//	                					ComShowCodeMessage("BKG08346");
//	                					return false;
//	                				}
//	                			}
		                	}
		                	for(var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++){
		                		if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt") != "" ){
		                			sheetObject1.SetCellValue(i, prefix+"vgm_clz_flg",'Y');
		                		}
		                	}
//		    				for (var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++) {
//		    					if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && ( sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt")==null ||sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt")=="") ){
//		    						ComShowCodeMessage("BKG08341",sheetObject1.GetCellValue(i, prefix+"bkg_no"));	//There is no VGM of BKG {?msg1}
//		    						return false;
//		    					}
//		    				}
//		                	if(formObject.save_flg.value == 'Y'){
//		                		doActionIBSheet(sheetObject1, formObject, COMMAND03);
//                				formObject.save_flg.value = 'N'
//		                	}else{
//		                		doActionIBSheet(sheetObject1, formObject, COMMAND04);
//		                	}
		                	formObject.edi_tp_cd.value = "C";
		                	doActionIBSheet(sheetObject1, formObject, COMMAND03);
		                	break;
		                case "btn_edi_others":
		                	if(sheetObject1.CheckedRows(prefix+"check") == 0){
		                		ComShowCodeMessage("BKG00533");
		                		return false;
		                	}
//		                	var mltChk = sheetObject1.FindCheckedRow(prefix+"check").indexOf("|")
//		                	var bkgNo = "";
//		                	var slt = "";
//		                	if(mltChk == -1){
//		                		bkgNo = sheetObject1.GetCellValue(sheetObject1.FindCheckedRow(prefix+"check"),prefix+"bkg_no");
//		                	}else{
//		                		slt =  sheetObject1.FindCheckedRow(prefix+"check").substr(0,mltChk);
//		                		bkgNo = sheetObject1.GetCellValue(slt,prefix+"bkg_no");
//		                	}
//	                		for (var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++) {
//	                			if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && sheetObject1.GetCellValue(i, prefix+"bkg_no")!=bkgNo){
//	                				ComShowCodeMessage("BKG00154");
//			                		return false;
//	                			}
//	                		}
	                		var bkgNos = "";
	                		var exBkgNo = "";
	                		var cntrNos = "";	                		
	                		for (var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++) {
	                			if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && sheetObject1.GetCellValue(i, prefix+"bkg_no") != ""
	                				&& sheet1.GetCellValue(i, prefix + "bkg_no") != exBkgNo){
	                				bkgNos = bkgNos + "'"+sheet1.GetCellValue(i, prefix + "bkg_no")+"',";
	                				exBkgNo = sheet1.GetCellValue(i, prefix + "bkg_no");
	                			}
	                			if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && sheetObject1.GetCellValue(i,prefix + "cntr_no") != ""
	                				&& sheetObject1.GetCellValue(i,prefix + "vgm_wgt") != "" && sheetObject1.GetCellValue(i,prefix + "vgm_wgt_ut_cd") != ""){
	                				cntrNos = cntrNos + "'"+ sheet1.GetCellValue(i,prefix + "cntr_no")+"',";
	                			}
	                		}
	                		var lastBkgNos = bkgNos.lastIndexOf(",");
	                		bkgNos = bkgNos.substring(0,lastBkgNos);
	                		formObject.bkg_no_list.value = bkgNos;
	                		
//	                		if(cntrNos == ""){
//	                			ComShowCodeMessage("BKG08347");
//	                			return false;
//	                		}else if(cntrNos != ""){
//	                			var lastCntrNos = cntrNos.lastIndexOf(",");
//	                			cntrNos = cntrNos.substring(0,lastCntrNos);
//	                		}
	                		if(cntrNos != ""){
	                			var lastCntrNos = cntrNos.lastIndexOf(",");
	                			cntrNos = cntrNos.substring(0,lastCntrNos);
	                			formObject.cntr_no_list.value = cntrNos;
	                		}
	                		
	                		var notUpdVgm = 0;
		                	for (var i=sheetObject1.HeaderRows(); i < sheetObject1.RowCount()+ sheetObject1.HeaderRows(); i++) {
		                		if(sheetObject1.GetCellValue(i, prefix+"check") == 1 && 
		                				(((sheetObject1.GetCellValue(i, prefix+"vgm_wgt") == "" || sheetObject1.GetCellValue(i, prefix+"vgm_wgt") == null) 
		                						&& sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt") != "") 
		                				  || sheetObject1.GetCellValue(i, prefix+"vgm_wgt") != sheetObject1.GetCellValue(i, prefix+"xter_vgm_wgt"))){
		                			formObject.save_flg.value = 'Y'
		                			notUpdVgm++;
		                		}
		                	}
		                	if(notUpdVgm>0){
	                			if(!ComShowCodeConfirm("BKG08353")){
	                				formObject.save_flg.value = 'N'
	                				return false;
	                			}
		                	}
		                	formObject.edi_tp_cd.value = "M";
		                	if(formObject.save_flg.value == "Y"){
		                		doActionIBSheet(sheetObject1, formObject, COMMAND03);
		                	}
	                		
	                		if(bkgNos.length >14){
//	                			ComOpenPopup("/opuscntr/ESM_BKG_0172.do?bkgNos="+bkgNos+"&cntrNos="+cntrNos, 950, 550, false, '0,0', true, false, 0);
	            				ComOpenWindowCenter("ESM_BKG_0172.do?", "ESM_BKG_0172", 950, 550, true);
	                		}else{
//	                			ComOpenPopup("/opuscntr/ESM_BKG_0171.do?cntrNos="+cntrNos, 850, 550, false, '0,0', true, false, 0);
	            				ComOpenWindowCenter("ESM_BKG_0171.do?", "ESM_BKG_0171", 850, 550, true);
	                		}
		                    
		                    break;
		        		case "btn_multBkgNo":	
		        			
		        			if($("#btn_multBkgNo").is(":disabled")) return;
		        			var stop = $("#bkg_no").offset().top;
		        		    var sleft = $("#bkg_no").offset().left;
		        		    layList.style.left = (sleft+150) + "px";
		        		    layList.style.top = (stop+0) + "px";
		        		    
		        			if($("#layList").is(":visible") == false){
		        				$("#layList").show();
		        			}else{
		        				$("#layList").hide();
		        			}
		        			
		        			break;
		        } // end switchRF
	     	}catch(e) {
		     		if( e == "[object Error]") {
		    			ComShowMessage(OBJECT_ERROR);
		    		} else {
		    			ComShowMessage(e);
		    		}		     	
	     	}
    }
   // Sheet handling process
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         switch(sAction) {
 			case IBSEARCH:      //Retrieve 				
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				formObj.f_cmd.value=SEARCH;
 				//formObj.curr_page.value=1;
				form.rows_per_page.value=rowsPerPage;
				if(formObj.r_vgm_opt[0].checked){
					formObj.vgm_opt.value = "A";
 				}else if(formObj.r_vgm_opt[1].checked) {
 					formObj.vgm_opt.value = "I";
 				}else if(formObj.r_vgm_opt[2].checked){
 					formObj.vgm_opt.value = "N";
 				}
                ComOpenWait(true);
                
                setTimeout(function(){
//    				var sXml=sheetObj.GetSearchData("ESM_BKG_0168GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//    				sheetObj.LoadSearchData(sXml,{Sync:1} );
    				sheetObj.DoSearch("ESM_BKG_0168GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//    				sheetObj.LoadSearchData(sXml,{Sync:0} );
//    				if(ComGetEtcData(sXml, "ttl_bkg") == undefined){
//    					formObj.ttl_bkg.value="";
//    					formObj.ttl_qty_f.value="";
//    					formObj.ttl_qty_t.value="";
//    					formObj.ttl_vgm.value="";
//    					formObj.ttl_non_vgm.value="";
//    					formObj.ttl_non_rcvd_vgm.value="";
//    					formObj.ttl_clz_bkg.value="";
//    					formObj.srch_mlt_bkg.value="";
////    					break;
//    				}else{
//        				formObj.ttl_bkg.value=ComGetEtcData(sXml, "ttl_bkg");
//        				formObj.ttl_qty_f.value=ComGetEtcData(sXml, "ttl_qty_f");
//        				formObj.ttl_qty_t.value=ComGetEtcData(sXml, "ttl_qty_t");
//        				formObj.ttl_vgm.value=ComGetEtcData(sXml, "ttl_vgm");
//        				formObj.ttl_non_vgm.value=ComGetEtcData(sXml, "ttl_non_vgm");
//        				formObj.ttl_non_rcvd_vgm.value=ComGetEtcData(sXml, "ttl_non_rcvd_vgm");
//        				formObj.ttl_clz_bkg.value=ComGetEtcData(sXml, "ttl_clz_bkg");
//        				formObj.srch_mlt_bkg.value=ComGetEtcData(sXml, "srch_mlt_bkg");
//    				}
                },300);
                
 				break;
 			case IBSAVE:
 				formObj.f_cmd.value=MULTI;
				var sXml=sheetObj.GetSaveData("ESM_BKG_0168GS.do", FormQueryString(formObj)+ "&" + sheetObj.GetSaveString());
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if(State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					ComOpenWait(false, false);
					return false;
				}else if(State == "S"){
					ComShowCodeMessage('BKG00166');
				}
				doActionIBSheet(sheetObj,formObj, IBSEARCH);
				break;

 			case IBSEARCHAPPEND:  // Retrieve paging
					formObj.f_cmd.value=SEARCH;
					formObj.curr_page.value=PageNo;
					selectVal=FormQueryString(formObj);
					sheetObj.DoSearch("ESM_BKG_0068GS.do", selectVal+ "&" + ComGetPrefixParam(prefix)+"&"+ "iPage=" + PageNo,{Append:true} );
					break;  
 			case SEARCH01:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0168GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
			  ComXml2ComboItem(arrXml[0], rcv_term_cd, "val", "val");
			  ComXml2ComboItem(arrXml[1], de_term_cd, "val", "val");
			  ComXml2ComboItem(arrXml[2], p_bkg_cust_tp_cd, "val", "val");
			  formObj.in_vvd.focus();
				break;
			case IBINSERT:    
				sheetObj.DataInsert(-1);
				break;
			case IBDOWNEXCEL:   // Excel download
				//sheetObj.Down2Excel({ HiddenColumn:1});
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				break;
			case RDPRINT:   
 				formObj.f_cmd.value=COMMAND01;
 				//formObj.curr_page.value=1;
				form.rows_per_page.value=rowsPerPage;
				if(formObj.r_vgm_opt[0].checked){
					formObj.vgm_opt.value = "A";
 				}else if(formObj.r_vgm_opt[1].checked) {
 					formObj.vgm_opt.value = "I";
 				}else if(formObj.r_vgm_opt[2].checked){
 					formObj.vgm_opt.value = "N";
 				}
				var inPolLt="";
				if (formObj.in_pol_lt.value == "")
					inPolLt="";
				else if (formObj.in_pol_lt.value == "LC")
					inPolLt="L";
				else if (formObj.in_pol_lt.value == "TS")
					inPolLt="T";
				var inPodLt="";
				if (formObj.in_pod_lt.value == "")
					inPodLt="";
				else if (formObj.in_pod_lt.value == "LC")
					inPodLt="L";
				else if (formObj.in_pod_lt.value == "TS")
					inPodLt="T";
	        	var bkgNos = "";
				for (var i=sheetObj.HeaderRows(); i < sheetObj.RowCount()+ sheetObj.HeaderRows(); i++) {
					if(sheetObj.GetCellValue(i, prefix+"bkg_no") != "" ){
						bkgNos = bkgNos + "'" + sheetObj.GetCellValue(i, prefix+"bkg_no")+"',";
					}
				}
				var lastBkgNos = bkgNos.lastIndexOf(",");
				var bkgNoList = bkgNos.substring(0,lastBkgNos);
				formObj.bkg_no_list.value = bkgNoList
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0168GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				formObj.un_loc_cd.value=ComGetEtcData(sXml,"un_loc_cd");
				formObj.vps_eta_dt.value=ComGetEtcData(sXml,"vps_eta_dt");
				formObj.vps_etd_dt.value=ComGetEtcData(sXml,"vps_etd_dt");
				formObj.vps_etb_dt.value=ComGetEtcData(sXml,"vps_etb_dt");
				formObj.cssm_vvd.value=ComGetEtcData(sXml,"cssm_vvd");
				formObj.d2.value=ComGetEtcData(sXml,"d2");
				formObj.d4.value=ComGetEtcData(sXml,"d4");
				formObj.d5.value=ComGetEtcData(sXml,"d5");
				formObj.d7.value=ComGetEtcData(sXml,"d7");
				formObj.d8.value=ComGetEtcData(sXml,"d8");
				formObj.d9.value=ComGetEtcData(sXml,"d9");
				formObj.dw.value=ComGetEtcData(sXml,"dw");
				formObj.dx.value=ComGetEtcData(sXml,"dx");
				formObj.r2.value=ComGetEtcData(sXml,"r2");
				formObj.r4.value=ComGetEtcData(sXml,"r4");
				formObj.r5.value=ComGetEtcData(sXml,"r5");
				formObj.f2.value=ComGetEtcData(sXml,"f2");
				formObj.f4.value=ComGetEtcData(sXml,"f4");
				formObj.f5.value=ComGetEtcData(sXml,"f5");
				formObj.o2.value=ComGetEtcData(sXml,"o2");
				formObj.o4.value=ComGetEtcData(sXml,"o4");
				formObj.o5.value=ComGetEtcData(sXml,"o5");
				formObj.s2.value=ComGetEtcData(sXml,"s2");
				formObj.s4.value=ComGetEtcData(sXml,"s4");
				formObj.t2.value=ComGetEtcData(sXml,"t2");
				formObj.t4.value=ComGetEtcData(sXml,"t4");
				formObj.a2.value=ComGetEtcData(sXml,"a2");
				formObj.a4.value=ComGetEtcData(sXml,"a4");
				formObj.p2.value=ComGetEtcData(sXml,"p2");
				formObj.p4.value=ComGetEtcData(sXml,"p4");
				formObj.z2.value=ComGetEtcData(sXml,"z2");
				formObj.z4.value=ComGetEtcData(sXml,"z4");
				formObj.t20.value=ComGetEtcData(sXml,"t20");
				formObj.t40.value=ComGetEtcData(sXml,"t40");
				formObj.wgt.value=ComGetEtcData(sXml,"wgt");
				formObj.mea.value=ComGetEtcData(sXml,"mea");
				formObj.e_wgt.value=ComGetEtcData(sXml,"e_wgt");
				formObj.lcl.value=ComGetEtcData(sXml,"lcl");
				formObj.ts.value=ComGetEtcData(sXml,"ts");
				formObj.ttl.value=ComGetEtcData(sXml,"ttl");
				ComOpenWait(false);
				var param="/rp [L][B][" + formObj.in_bkg_ofc_cd.value + "][A][]"
				+ "[" + formObj.in_vvd.value + "][" + formObj.in_pol_cd.value + "][" + inPolLt + "][" + formObj.in_pod_cd.value
				+ "][" + inPodLt + "][][][][" + formObj.rcv_term_cd.value + "]["
				+ formObj.de_term_cd.value + "][][][][][]["
				+ "][][][][][]["
				+ "][Y][][" + formObj.in_pol_yd_cd.value + "][" + formObj.in_pod_yd_cd.value
				+ "][][" + formObj.cssm_vvd.value + "][" + formObj.un_loc_cd.value + "][" + formObj.vps_eta_dt.value
				+ "][" + formObj.vps_etd_dt.value + "][" + formObj.vps_etb_dt.value + "][" + formObj.d2.value + "][" + formObj.d4.value + "]["
				+ formObj.d5.value + "][" + formObj.d7.value + "][" + formObj.d8.value + "][" + formObj.d9.value + "][" + formObj.dw.value + "]["
				+ formObj.dx.value + "][" + formObj.r2.value + "][" + formObj.r4.value + "][" + formObj.r5.value + "][" + formObj.f2.value + "]["
				+ formObj.f4.value + "][" + formObj.f5.value + "][" + formObj.o2.value + "][" + formObj.o4.value + "][" + formObj.s2.value + "]["
				+ formObj.s4.value + "][" + formObj.t2.value + "][" + formObj.t4.value + "][" + formObj.a2.value + "][" + formObj.a4.value + "]["
				+ formObj.p2.value + "][" + formObj.p4.value + "][" + formObj.t20.value + "][" + formObj.t40.value + "][" + formObj.ttl.value
				+ "][" + formObj.ttl.value + "][0][" + formObj.lcl.value + "][" + formObj.ts.value + "]["
				+ formObj.e_wgt.value + "][" + formObj.wgt.value + "][" + formObj.mea.value + "][" 
				+ "1 : 0,     2 : 0,     3 : 0,     4 : 0,     5 : 0,     6 : 0,     7 : 0,     8 : 0,     9 : 0,     10 : 0,     12 : 0][" //72번째
				+ "Y][][" + formObj.o5.value + "]["+bkgNoList+"]";
				formObj.com_mrdArguments.value=param;
				ComOpenRDPopup("width=1024, height=650");
//				 ComOpenWindowCenter(sUrl, "0783", 1024, 720, false);
				
				break;				
		case COMMAND02:
			var sUrl="/opuscntr/ESM_BKG_0221.do?pgmNo=ESM_BKG_0221&ui_id=ESM_BKG_0168&ok_hidden=Y";
			ComOpenWindowCenter(sUrl, "ESM_BKG_0221", 360, 200, true);
			break;
		case COMMAND03:
			formObj.f_cmd.value=COMMAND03;
			var sXml=sheetObj.GetSaveData("ESM_BKG_0168GS.do", FormQueryString(formObj)+ "&" + sheetObj.GetSaveString());
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				ComOpenWait(false, false);
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('BKG00166');
				formObj.save_flg.value = 'N'
				if(formObj.edi_tp_cd.value == "C"){
					doActionIBSheet(sheetObj, formObj, COMMAND04);
				}
			}
//			doActionIBSheet(sheetObj,formObj, IBSEARCH);
			break;
		case COMMAND04:
			var formObj = document.form;
			if(formObj.srch_mlt_bkg.value == "Y"){
				ComShowMessage(msgs['BKG08351']);
				return false;
			}
        	var bkgNos = "";
			for (var i=sheetObj.HeaderRows(); i < sheetObj.RowCount()+ sheetObj.HeaderRows(); i++) {
				if(sheetObj.GetCellValue(i, prefix+"check") == 1 ){
					bkgNos = bkgNos + "'" + sheetObj.GetCellValue(i, prefix+"bkg_no")+"',";
				}
			}
			var lastBkgNos = bkgNos.lastIndexOf(",");
			formObj.bkg_no_list.value = bkgNos.substring(0,lastBkgNos);
			var vgmVvd = formObj.in_vvd.value;
			var vgmPol = formObj.in_pol_cd.value;
			if(vgmPol.substring(0,2) == "KR"){
				var url="ESM_BKG_0930_POP.do?func=&pgmNo=ESM_BKG_0930&pop_mode=VGM&vgm_vvd="+vgmVvd+"&vgm_pol="+vgmPol+"&lcl_ts="+formObj.in_pol_lt.value;
				ComOpenWindowCenter(url, "ESM_BKG_0930_POP", 1400, 700, false);
			}else{
				var url="ESM_BKG_0159_POP.do?func=&pgmNo=ESM_BKG_0159-1&pop_mode=VGM&vgm_vvd="+vgmVvd+"&vgm_pol="+vgmPol;
				ComOpenWindowCenter(url, "ESM_BKG_0159_POP", 1400, 700, false);
			}
			break;
         }
     }
    function openWinCenter(url,winName,width,height , scrollYn) {
 	   var left=(screen.width - width)/2;    
 	   if(left < 0) {
 		   left=0;
 	   }
        var top=(screen.height- width)/2;   
        if( top < 0 ) {
     	   top=0;
        }
        if (ComIsNull(scrollYn)) {
     	   scrollYn="no";
        } else {
     	   if (scrollYn == "Y") {
     		   scrollYn="yes";
     	   } else {
     		   scrollYn="no";
     	   }
        }
        var feature=
     	   "status=no, resizable=yes, scrollbars="+scrollYn+", width="+width+", height="+height+", left="+left+", top="+top;
        return window.open(url,winName,feature);
 		}     
	 /**
     * Scroll click  :Next Page handling <br>
     */ 
    function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
	     doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true,true, PageNo);
	}        
    /**
     * After query the event processing 
     */ 
    function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
		with (sheetObj) {
			if (sheetObj.RowCount() <= 0)
	    	     ComShowCodeMessage("BKG00095");
			else
				{
				var formObj = document.form;
				formObj.ttl_bkg.value=GetCellValue(2, prefix+"ttl_bkg");
				formObj.ttl_qty_f.value=GetCellValue(2, prefix+"ttl_qty_f");
				formObj.ttl_qty_t.value=GetCellValue(2, prefix+"ttl_qty_t");
				formObj.ttl_vgm.value=GetCellValue(2, prefix+"ttl_vgm");
				formObj.ttl_non_vgm.value=GetCellValue(2, prefix+"ttl_non_vgm");
				formObj.ttl_non_rcvd_vgm.value=GetCellValue(2, prefix+"ttl_non_rcvd_vgm");
				formObj.ttl_clz_bkg.value=GetCellValue(2, prefix+"ttl_clz_bkg");
				formObj.srch_mlt_bkg.value=GetCellValue(2, prefix+"srch_mlt_bkg");
		    	var redColor="#FF0000";
				var blueColor="#0000FF";
				var rowSpan=1, tmpCnt=rowCnt=0;
				for (var i=sheetObj.HeaderRows(); i < sheetObj.RowCount()+ HeaderRows(); i++) {

					
					setCelColor( GetCellValue(i, prefix+"vgm_clz_flg"),           sheetObj, i, prefix+"vgm_clz_flg",           redColor);
					if(GetCellValue(i,prefix+"esig")=="N"){
						SetCellFontColor(i, prefix+"esig", redColor);
					}
					if(GetCellValue(i,prefix+"vgm_wgt") !=  GetCellValue(i,prefix+"xter_vgm_wgt")){
						if(GetCellValue(i,prefix+"vgm_clz_flg") == "Y"){
							SetCellFontColor(i, prefix+"vgm_wgt", redColor);
							SetCellFontColor(i, prefix+"vgm_wgt_ut_cd", redColor);
							SetCellFontColor(i, prefix+"vgm_wgt_upd_usr_id", redColor);
							SetCellFontColor(i, prefix+"vgm_wgt_upd_dt", redColor);
							SetCellFontColor(i, prefix+"vgm_via", redColor);
							SetCellFontColor(i, prefix+"xter_vgm_wgt", redColor);
							SetCellFontColor(i, prefix+"xter_vgm_wgt_ut_cd", redColor);
							SetCellFontColor(i, prefix+"in_usr", redColor);
							SetCellFontColor(i, prefix+"in_dt", redColor);
						}else{
//							if(GetCellValue(i,prefix+"sup")){
//								SetCellFontColor(i, prefix+"vgm_wgt", redColor);
//								SetCellFontColor(i, prefix+"vgm_wgt_ut_cd", redColor);
//								SetCellFontColor(i, prefix+"vgm_wgt_upd_usr_id", redColor);
//								SetCellFontColor(i, prefix+"vgm_wgt_upd_dt", redColor);
//								SetCellFontColor(i, prefix+"vgm_via", redColor);
//								SetCellFontColor(i, prefix+"xter_vgm_wgt", redColor);
//								SetCellFontColor(i, prefix+"xter_vgm_wgt_ut_cd", redColor);
//								SetCellFontColor(i, prefix+"in_usr", redColor);
//								SetCellFontColor(i, prefix+"in_dt", redColor);
//							}
						}
					}else{
						SetCellFontColor(i, prefix+"vgm_wgt", blueColor);
						SetCellFontColor(i, prefix+"vgm_wgt_ut_cd", blueColor);
						SetCellFontColor(i, prefix+"vgm_wgt_upd_usr_id", blueColor);
						SetCellFontColor(i, prefix+"vgm_wgt_upd_dt", blueColor);
						SetCellFontColor(i, prefix+"vgm_via", blueColor);
						SetCellFontColor(i, prefix+"xter_vgm_wgt", blueColor);
						SetCellFontColor(i, prefix+"xter_vgm_wgt_ut_cd", blueColor);
						SetCellFontColor(i, prefix+"in_usr", blueColor);
						SetCellFontColor(i, prefix+"in_dt", blueColor);
					}
					if(GetCellValue(i,prefix+"vgm_wgt") > GetCellValue(i,prefix+"payld_pls_tare")){
						SetCellFontColor(i, prefix+"payld_pls_tare", redColor);
					}
					if(Math.abs(GetCellValue(i,prefix+"diff_pct").substr(1,8)) > 5){
						SetCellFontColor(i, prefix+"cgo_pls_tare", redColor);
						SetCellFontColor(i, prefix+"diff_pct", redColor);
					}
				}

				if(formObj.srch_mlt_bkg.value == "Y"){
					formObj.btn_edi.disabled = true;
				}else{
					formObj.btn_edi.disabled = false;
				}
			}
		}
		ComOpenWait(false);
     }
     function setCelColor(flag, obj,idx,celName,color){
     	if(flag =="N")
     		obj.SetCellFontColor(idx,celName,color);
     }
			/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
     		if( colIdx == sheetObj.SaveNameCol(prefix + 	"bkg_no")){
     			var param="?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.GetCellValue(rowIdx, prefix+"bkg_no");
				ComOpenWindowCenter2("/opuscntr/ESM_BKG_0079_POP.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
     		}else if( colIdx == sheetObj.SaveNameCol(prefix + 	"bl_no")){
     			var param="?bkg_no="+sheetObj.GetCellValue(rowIdx, prefix+"bkg_no");
//						ComOpenWindowCenter2("/opuscntr/ESM_BKG_BL_TEST.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
						ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927_POP.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
     		}
     }	 
//	 function sheet1_OnSort(sheetObj) {
//		 var rowNum = 1;
//		 var curKey ;
//		 with (sheetObj) {
//			 MergSheet = msNone;
//			 for (var i=HeaderRows ; i <= Rows; i++) {
//				 curKey =  CellValue(i,prefix+"bkg_no");
//				 CellValue2(i,prefix+"dense_rank2") = rowNum;
//				 if (CellValue(i+1,prefix+"bkg_no") != curKey){
//					 rowNum++;
//			 	 }
//			  }
//			 MergeSheet = msHeaderOnly +	msPrevColumnMerge;
//		 }
//	  }
	 function sheet1_OnSort(sheetObj,col,SortArrow) {
		 var rowNum=1;
		 var curKey ;
		 with (sheetObj) {
			 MergSheet=msNone;
			 if (SortArrow == "DESC"){
				 for (var i=2 ; i <= Rows; i++) {
					 curKey=GetCellValue(i,prefix+"bkg_no");
					 SetCellValue(i,prefix+"dense_rank2",rowNum,0);
					 if (GetCellValue(i+1,prefix+"bkg_no") != curKey){
						 rowNum++;
				 	 }
				  }
			 }
			 else{
				 for (var i=3 ; i <= Rows ; i++) {
				 	curKey=GetCellValue(i,prefix+"bkg_no");
					SetCellValue(i,prefix+"dense_rank2",rowNum,0);
					if (GetCellValue(i+1,prefix+"bkg_no") != curKey){
						 rowNum++;
				 	 }
				  }
			 }
			 }
			 MergeSheet=msHeaderOnly +	msPrevColumnMerge;
		 }
	  
	 /*
	* Rd Param
	*/
	function RdParam(sheetObject,prefix) {
		var strResult=""; 
		var inStr="";
		var title="0";
		var vsNM="";
		var iCheckRow=sheetObject.FindCheckedRow(prefix + "check");
		var arrRow=iCheckRow.split("|");
		if(iCheckRow == "")
			 return;
		for (var idx=0; idx<arrRow.length-1; idx++) {			
			if(sheetObject.GetCellValue(arrRow[idx],prefix+"check")==1){
				if (inStr.length > 1){
					inStr+=","+"('"+sheetObject.GetCellValue(arrRow[idx],prefix+"bl_no")+"','"+sheetObject.GetCellValue(arrRow[idx],prefix+"cntr_no")+"')";
				}else{
					inStr="('"+sheetObject.GetCellValue(arrRow[idx],prefix+"bl_no")+"','"+sheetObject.GetCellValue(arrRow[idx],prefix+"cntr_no")+"')";
				}
			}
		}
		strResult=rdParamSet(inStr);		 
		return strResult; 
	}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
    			if (ComIsEmpty(formObj.bkg_no) && ComIsEmpty($("#mult_bkg_no").val())){
    	    		if (ComIsNull(formObj.in_vvd)) {
     					ComShowCodeMessage('BKG00227');
     					formObj.in_vvd.focus();
     					return false;
    	    		}
    	    		if (formObj.in_vvd.value.length != 9) {
     					ComShowCodeMessage('BKG00538');
     					formObj.in_vvd.focus();
     					return false;
    	    		}
    	    		if (ComIsNull(formObj.in_pol_cd)) {
    	    			ComShowCodeMessage('BKG00209');
    	    			formObj.in_pol_cd.focus();
    	    			return false;
    	    		}
    	    		if (formObj.in_pol_cd.value.length < 3) {
    	    			ComShowCodeMessage('BKG00288');
    	    			formObj.in_pol_cd.focus();
    	    			return false;
    	    		}
    			}
	    		if($("#mult_bkg_no").val().indexOf("'")!=-1){
	    			ComShowCodeMessage('BKG00445',"only alphanumeric characters in Booking No");
	    			return false;
	    		}
//	    		if(duplicateBkgNoCheck()) return false;
				if($('#rows').css("color").indexOf('255') > 0){
					ComShowMessage('You can input Booking No up to 100 Maximum. Please kindly check Booking No again.');
					$("#layList").show();
					return false;
				}
				/* 멀티 부킹 중복 체크 */
				duplicateBkgNoCheck('mult_bkg_no');
				return true;
	  			break;
    	}
         return true;
     }
     /**
      *  yyyyMMd Date Check
      */
     function dateCheck(dateobj){
     	if(dateobj.value =="") return true;
      return ComIsDate(dateobj.value);
     }	
    function isNullEtcData(xmlStr){
    	var rtn=false;
    	var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);
        var xmlRoot=xmlDoc.documentElement;
        if(xmlRoot == null) return true;
        var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;
        var etcNodes=etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn=true;
        return rtn;
    }
 /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
           case "sheet1":
        	      with(sheetObj){
			              
			            var HeadTitle1=" |||No.|Booking No.|B/L No.|BKG\nOffice|Route|Route|Route|Route|Q'ty|Q'ty|1st\nETD|VGM Cut-off|Shipper|Container|Container|Validation|Validation|Validation|VGM Declared|VGM Declared|VGM Declared|VGM Declared|VGM Declared|Latest VGM|Latest VGM|Latest VGM|Latest VGM|Latest VGM|Latest VGM|Latest VGM|Latest VGM|Latest VGM|Latest VGM|Latest VGM|Latest VGM|VGM Close|VGM Close|VGM Close||||||||||";
			            var HeadTitle2=" |||No.|Booking No.|B/L No.|BKG\nOffice|T.VVD|POL|POD||BKG|CNTR|1st\nETD|VGM Cut-off|Shipper|No.|SZ|P/L+Tare|CGO+Tare|+/- %|VGM|Unit|USR ID|UPD DT|C/M|Via|VGM|Unit||User|Date|Esig||||||CLZ|User|Date|||||||||";
			            var headCount=ComCountHeadTitle(HeadTitle1);
			
			            SetConfig( { SearchMode:2, MergeSheet:7, Page:100, FrozenCol:6 , DataRowMerge:0, PrevColumnMergeMode:0 } );
			
			            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			            var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
			            InitHeaders(headers, info);
			
			            var cols = [ {Type:"Status",    	Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"ibflag",					KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         		{Type:"Text",      		Hidden:1, Width:25,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"dense_rank",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"CheckBox", Hidden:0, Width:20,	  Align:"Center",	ColMerge:0,   SaveName:prefix+"check",         		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                         		{Type:"Text",      		Hidden:0, Width:25,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"num",					KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:95,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"bkg_no",        			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:95,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"bl_no",         			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:50,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"bkg_ofc_cd", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:80,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"trnk_vvd",    			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:50,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"pol_cd",    			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:50,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"pod_cd", 			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:50,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"lt", 			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:80,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"qty_bkg",       		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:80,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"qty_cntr",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:110, Align:"Center",  	ColMerge:1,   SaveName:prefix+"fst_etd",  			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",	        Hidden:0, Width:110, Align:"Center",    ColMerge:1,   SaveName:prefix+"vgm_cut_off_tm",      			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:200, Align:"Center",    	ColMerge:1,   SaveName:prefix+"shpr",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:85,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"cntr_no",       		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"sz",            			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Float",      	Hidden:0, Width:80,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"payld_pls_tare",            			KeyField:0,   CalcLogic:"",   Format:"NullFloat",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Float",      	Hidden:0, Width:80,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"cgo_pls_tare",            			KeyField:0,   CalcLogic:"",   Format:"NullFloat",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:60,   Align:"Right",  	ColMerge:0,   SaveName:prefix+"diff_pct",            			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//			                         		{Type:"Float",      	Hidden:0, Width:50,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"wgt",           			KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//			                         		{Type:"Text",      		Hidden:0, Width:40,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"unit",            		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Float",      	Hidden:0, Width:80,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"vgm_wgt",          	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Combo",      Hidden:0, Width:40,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"vgm_wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:wgtUtCd, ComboCode:wgtUtCd  },
			                         		{Type:"Text",      		Hidden:0, Width:80,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"vgm_wgt_upd_usr_id",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:110,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"vgm_wgt_upd_dt",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"cm",            			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:50,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"vgm_via",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Float",      	Hidden:0, Width:80,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"xter_vgm_wgt",          	KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:40,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"xter_vgm_wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:40,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"vgm_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:80, Align:"Center",  	ColMerge:0,   SaveName:prefix+"in_usr",            	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:110,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"in_dt",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"esig",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"esig_co_nm",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"xter_sndr_id",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"xter_vgm_doc_id",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"xter_vgm_rqst_seq",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"xter_vgm_usr_id",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Combo",     Hidden:0, Width:35,    Align:"Center",    ColMerge:0,   SaveName:prefix+"vgm_clz_flg",      			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:fnl_cls_str, ComboCode:fnl_cls_str },
			                         		{Type:"Text",      		Hidden:0, Width:80, Align:"Center",  	ColMerge:0,   SaveName:prefix+"cls_usr",   			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:0, Width:110, Align:"Center",    	ColMerge:0,   SaveName:prefix+"cls_dt" ,				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"sup",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"wgt_tp_cd",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"vgm_bkg_no",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"ref_id",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"ttl_bkg",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"ttl_qty_f",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"ttl_qty_t",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"ttl_vgm",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"ttl_non_vgm",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"ttl_non_rcvd_vgm",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"ttl_clz_bkg",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                         		{Type:"Text",      		Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:prefix+"srch_mlt_bkg",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			             
			            InitColumns(cols);
			            SetEditable(1);
			            SetCountPosition(0);
			            SetWaitImageVisible(0);
			            SetSheetHeight(500);
			            SetRangeBackColor(1,6,1,10,"#555555");
			            SetRangeBackColor(1,11,1,19,"#555555");
			            SetRangeBackColor(1,20,1,23,"#555555");
			            SetRangeBackColor(1,24,1,27,"#555555");
			            SetRangeBackColor(1,28,1,40,"#555555");
                     }
			break;
       	case "sheet2": // sheet_search
    		with (sheetObj) {
    	        var HeadTitle1="ibflag|SysCd|TmplMrd|Title|TmplParam|RcvInfo|SndNm|SndEml|Filekey|RcvEml|Contents|Bkg_no|Bl_no|TmplMrdPdf|itr|";
    	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
    	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    	        InitHeaders(headers, info);
    	        var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"syscd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplmrd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"title",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplparam",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rcvinfo",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sndnm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sndeml",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"filekey",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rcveml",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"contents",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"history_gubun",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tmplmrdpdf",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
    		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"itr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
    	        InitColumns(cols);
    	        SetEditable(1);
    	        SetSheetHeight(100, 1);
    		}
    		break;
        }
    }
  	function comBkgCallPop0974(callback_func){
		var chkRow=ComFindAll(sheetObjects[0], prefix + "check2", "1").toString().split("|");
		if (1 < chkRow.length) {
			var param="";
			for (var idx=0; idx<chkRow.length; idx++) {
				if (0==idx) {
					param="ibflag=U&bkg_no=" + sheetObjects[0].GetCellValue(chkRow[idx], prefix + "bkg_no")
					+"&bdr_flg=" + ("Y"==sheetObjects[0].GetCellValue(chkRow[idx], prefix + "bdr") ? "YES":"NO");
				} else {
					param=param +"&ibflag=U&bkg_no=" + sheetObjects[0].GetCellValue(chkRow[idx], prefix + "bkg_no")
					+"&bdr_flg=" + ("Y"==sheetObjects[0].GetCellValue(chkRow[idx], prefix + "bdr") ? "YES":"NO");
									}
			}
			ComOpenPopup("/opuscntr/ESM_BKG_0974.do?"+param, 850, 350, callback_func, "0,1", true);
		}
	}
	function callBack0974(rArray){
		var formObj=document.form;
		formObj.mst_bkg_no.value=rArray[0];
		var chkRow=ComFindAll(sheetObjects[0], prefix + "check2", "1").split("|");
		var bdrFlg="N";
		if (1 < chkRow.length) {
			for (var idx=0; idx<chkRow.length; idx++) {
				if (sheetObjects[0].GetCellValue(chkRow[idx], prefix + "bdr") == "Y") {
					bdrFlg="Y"; 
					break;
				}
			}
			if ("Y"==bdrFlg) {
				comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.mst_bkg_no), "C");
		 		//doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			} else {
				doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			}
		}
	}         
	/**
     * CA Reason : CaReasonModify
     */ 
	function setCAReasonCallBack(arrPopupData) {
		var formObj=document.form;
		var strRsnCd=nullToBlank(arrPopupData[0][2]);
		var strRemark=nullToBlank(arrPopupData[0][3]);
		//02. modifyCaReason(e) call
		formObj.ca_rsn_cd.value=strRsnCd;
		formObj.ca_remark.value=strRemark;
		
		doActionIBSheet(sheetObjects[0],formObj,"run_combine");
	}
	/**
	 * Global variables, event  function 
	 */
	var startMergeRow=lastMergeRow=0;
	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {  //Before the change event
		with (sheetObj) {
	    	if (2==MouseCol()) {
		    	startMergeRow=Number(GetMergedStartCell(MouseRow(),MouseCol()).split(",")[0]);
		    	lastMergeRow=Number(GetMergedEndCell(MouseRow(),MouseCol()).split(",")[0]);
			}
		}
	}
//	function sheet1_OnChange(sheetObj, Row, Col, Value) {  //After the change event
//		if (2==Col) {
//    		sheetObj.SetCellValue(startMergeRow, prefix+"check2",1==Value ? "1":"",0);
//	    	for (var i=startMergeRow; i <= lastMergeRow; i++) {
//	    		sheetObj.SetCellValue(i, Col,Value,0);
//	    	}
//		}
//	}
	 /**
     * handling  search condition  Input 
     */
//    function obj_KeyUp() {
//    	 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//    	 var formObject=document.form;
//    	var srcName=ComGetEvent("name");
//    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//    	var srcValue=window.event.srcElement.getAttribute("value");
//    	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
//    		ComSetNextFocus();
//    	}
    function initCombo_vgm_val() {
    	with (vgm_val) {
    		SetMultiSelect(1);
    		SetMultiSeparator("|");
    		//ColCnt = 2;
				var i=0; 
				InsertItem(i++, " ", ""); 
				InsertItem(i++, "Missing signature", "S"); 
//				InsertItem(i++, "Over payload", "P"); 
				InsertItem(i++, "Late update", "U"); 
			} 
    }
    function sheet1_OnChange(sheetObj, Row, Col, Val, oldVal){
    	if(sheetObj.ColSaveName(Col) == prefix+"vgm_clz_flg"){
    		var bkgNo = sheetObj.GetCellValue(Row,prefix+"bkg_no");
    		var vgmClzFlg = sheetObj.GetCellValue(Row,prefix+"vgm_clz_flg");
    		for(var i=2;i <= sheetObj.LastRow();i++){
    			if(sheetObj.GetCellValue(i,prefix+"bkg_no") == bkgNo){
    				sheetObj.SetCellValue(i,prefix+"vgm_clz_flg",vgmClzFlg);
    			}
    		}
    	}
//    	if(sheetObj.ColSaveName(Col) == prefix+"vgm_wgt"||sheetObj.ColSaveName(Col) == prefix+"vgm_wgt_ut_cd"){
//    		sheetObj.SetCellValue(Row,prefix+"vgm_wgt_upd_usr_id",document.form.strUsr_id.value);
//    		sheetObj.SetCellValue(Row,prefix+"vgm_wgt_upd_dt",ComGetNowInfo()+" "+ComGetNowInfo("hm"));
//    		sheetObj.SetCellBackColor(Row,prefix+"vgm_wgt","#58FA58");
//			sheetObj.SetCellBackColor(Row,prefix+"vgm_wgt_ut_cd","#58FA58");
//			sheetObj.SetCellBackColor(Row,prefix+"vgm_wgt_upd_usr_id","#58FA58");
//			sheetObj.SetCellBackColor(Row,prefix+"vgm_wgt_upd_dt","#58FA58");
//    	}
//    	if(sheetObj.ColSaveName(Col) == prefix + "check"){
//    		var chk = sheetObj.GetCellValue(Row,prefix+"check")
//    		var bkgNo = sheetObj.GetCellValue(Row,prefix+"bkg_no");
//    		var vgmClzFlg = sheetObj.GetCellValue(Row,prefix+"vgm_clz_flg");
//    		for(var i=2;i <= sheetObj.LastRow();i++){
//    			if(sheetObj.GetCellValue(i,prefix+"bkg_no") == bkgNo){
////    				sheetObj.SetCellValue(i,prefix+"vgm_clz_flg",vgmClzFlg);
//    				sheetObj.SetCellValue(i,prefix+"check",chk)
////    				sheetObj.SetCellBackColor(i,prefix+"vgm_clz_flg","#58FA58");
////    				sheetObj.SetCellBackColor(i,prefix+"vgm_wgt_upd_dt","#58FA58");
//    			}
//    		}
//    	}
    }
    /**
     * In the pop-up screen, the fax number and e-mail address Input -> the call transfer function Call 
     * @param faxNo faxNo
     * @param eMail eMail
     */
    function sendFaxEmail(faxNo, eMail) {
    	var formObj=document.form;
    	formObj.fax.value=faxNo;
    	formObj.email.value=eMail;
    	paramSet(sheetObjects[1], document.form);
    }
    /**
     * for send  Parameters setting, fax number and e-mail address
     * @param sheetObject sheetObject
     * @param formObj formObj
     */
    function paramSet(sheetObject, formObj) {
    		var sheetObjectData=sheetObjects[0];
    		var rdParam="";
    		var strPath="";
    		var strPdf="";
    		var bkg_no="";
    		var inListType="";
    		formObj.f_cmd.value=COMMAND01;
				//formObj.curr_page.value=1;
			form.rows_per_page.value=rowsPerPage;
			if(formObj.r_vgm_opt[0].checked){
				formObj.vgm_opt.value = "A";
				}else if(formObj.r_vgm_opt[1].checked) {
					formObj.vgm_opt.value = "I";
				}else if(formObj.r_vgm_opt[2].checked){
					formObj.vgm_opt.value = "N";
				}
			var inPolLt="";
			if (formObj.in_pol_lt.value == "")
				inPolLt="";
			else if (formObj.in_pol_lt.value == "LC")
				inPolLt="L";
			else if (formObj.in_pol_lt.value == "TS")
				inPolLt="T";
			var inPodLt="";
			if (formObj.in_pod_lt.value == "")
				inPodLt="";
			else if (formObj.in_pod_lt.value == "LC")
				inPodLt="L";
			else if (formObj.in_pod_lt.value == "TS")
				inPodLt="T";
        	var bkgNos = "";
			for (var i=sheetObjects[0].HeaderRows(); i < sheetObjects[0].RowCount()+ sheetObjects[0].HeaderRows(); i++) {
				if(sheetObjects[0].GetCellValue(i, prefix+"bkg_no") != "" ){
					bkgNos = bkgNos + "'" + sheetObjects[0].GetCellValue(i, prefix+"bkg_no")+"',";
				}
			}
			var lastBkgNos = bkgNos.lastIndexOf(",");
			var bkgNoList = bkgNos.substring(0,lastBkgNos);
			formObj.bkg_no_list.value = bkgNoList
			ComOpenWait(true);
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0168GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			formObj.un_loc_cd.value=ComGetEtcData(sXml,"un_loc_cd");
			formObj.vps_eta_dt.value=ComGetEtcData(sXml,"vps_eta_dt");
			formObj.vps_etd_dt.value=ComGetEtcData(sXml,"vps_etd_dt");
			formObj.vps_etb_dt.value=ComGetEtcData(sXml,"vps_etb_dt");
			formObj.cssm_vvd.value=ComGetEtcData(sXml,"cssm_vvd");
			formObj.d2.value=ComGetEtcData(sXml,"d2");
			formObj.d4.value=ComGetEtcData(sXml,"d4");
			formObj.d5.value=ComGetEtcData(sXml,"d5");
			formObj.d7.value=ComGetEtcData(sXml,"d7");
			formObj.d8.value=ComGetEtcData(sXml,"d8");
			formObj.d9.value=ComGetEtcData(sXml,"d9");
			formObj.dw.value=ComGetEtcData(sXml,"dw");
			formObj.dx.value=ComGetEtcData(sXml,"dx");
			formObj.r2.value=ComGetEtcData(sXml,"r2");
			formObj.r4.value=ComGetEtcData(sXml,"r4");
			formObj.r5.value=ComGetEtcData(sXml,"r5");
			formObj.f2.value=ComGetEtcData(sXml,"f2");
			formObj.f4.value=ComGetEtcData(sXml,"f4");
			formObj.f5.value=ComGetEtcData(sXml,"f5");
			formObj.o2.value=ComGetEtcData(sXml,"o2");
			formObj.o4.value=ComGetEtcData(sXml,"o4");
			formObj.o5.value=ComGetEtcData(sXml,"o5");
			formObj.s2.value=ComGetEtcData(sXml,"s2");
			formObj.s4.value=ComGetEtcData(sXml,"s4");
			formObj.t2.value=ComGetEtcData(sXml,"t2");
			formObj.t4.value=ComGetEtcData(sXml,"t4");
			formObj.a2.value=ComGetEtcData(sXml,"a2");
			formObj.a4.value=ComGetEtcData(sXml,"a4");
			formObj.p2.value=ComGetEtcData(sXml,"p2");
			formObj.p4.value=ComGetEtcData(sXml,"p4");
			formObj.z2.value=ComGetEtcData(sXml,"z2");
			formObj.z4.value=ComGetEtcData(sXml,"z4");
			formObj.t20.value=ComGetEtcData(sXml,"t20");
			formObj.t40.value=ComGetEtcData(sXml,"t40");
			formObj.wgt.value=ComGetEtcData(sXml,"wgt");
			formObj.mea.value=ComGetEtcData(sXml,"mea");
			formObj.e_wgt.value=ComGetEtcData(sXml,"e_wgt");
			formObj.lcl.value=ComGetEtcData(sXml,"lcl");
			formObj.ts.value=ComGetEtcData(sXml,"ts");
			formObj.ttl.value=ComGetEtcData(sXml,"ttl");
			ComOpenWait(false);
    		var rdParam="/rp [L][B][" + formObj.in_bkg_ofc_cd.value + "][A][]"
			+ "[" + formObj.in_vvd.value + "][" + formObj.in_pol_cd.value + "][" + inPolLt + "][" + formObj.in_pod_cd.value
			+ "][" + inPodLt + "][][][][" + formObj.rcv_term_cd.value + "]["
			+ formObj.de_term_cd.value + "][][][][][]["
			+ "][][][][][]["
			+ "][Y][][" + formObj.in_pol_yd_cd.value + "][" + formObj.in_pod_yd_cd.value
			+ "][][" + formObj.cssm_vvd.value + "][" + formObj.un_loc_cd.value + "][" + formObj.vps_eta_dt.value
			+ "][" + formObj.vps_etd_dt.value + "][" + formObj.vps_etb_dt.value + "][" + formObj.d2.value + "][" + formObj.d4.value + "]["
			+ formObj.d5.value + "][" + formObj.d7.value + "][" + formObj.d8.value + "][" + formObj.d9.value + "][" + formObj.dw.value + "]["
			+ formObj.dx.value + "][" + formObj.r2.value + "][" + formObj.r4.value + "][" + formObj.r5.value + "][" + formObj.f2.value + "]["
			+ formObj.f4.value + "][" + formObj.f5.value + "][" + formObj.o2.value + "][" + formObj.o4.value + "][" + formObj.s2.value + "]["
			+ formObj.s4.value + "][" + formObj.t2.value + "][" + formObj.t4.value + "][" + formObj.a2.value + "][" + formObj.a4.value + "]["
			+ formObj.p2.value + "][" + formObj.p4.value + "][" + formObj.t20.value + "][" + formObj.t40.value + "][" + formObj.ttl.value
			+ "][" + formObj.ttl.value + "][0][" + formObj.lcl.value + "][" + formObj.ts.value + "]["
			+ formObj.e_wgt.value + "][" + formObj.wgt.value + "][" + formObj.mea.value + "][" 
			+ "1 : 0,     2 : 0,     3 : 0,     4 : 0,     5 : 0,     6 : 0,     7 : 0,     8 : 0,     9 : 0,     10 : 0,     12 : 0][" //72번째
			+ "Y][][" + formObj.o5.value + "]["+bkgNoList+"]";
    		// alert(rdParam);
    		// rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_type[2]
    		// form_dataOnly[N] form_manifest[N] form_hiddeData[N] form_mainOnly[N]
    		// form_level[(1)] form_remark[] form_Cntr[1] ";
    		// rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER]
    		// form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC]
    		// form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] /rp []
    		// /riprnmargin";
    		strPath="ESM_BKG_0783.mrd";
   			strPdf=formObj.in_vvd.value + "(CLL).pdf";
    		var bkgNo2="";
    		if (sheetObjectData.RowCount()> 0) {
    			bkgNo2="|";
    		}
    		var title="";
   			title = "Container Loading List(VVD: " + formObj.in_vvd.value + ", Loading Port: " + formObj.in_pol_cd.value + ")";
   			var Row1=sheetObject.DataInsert();
   			sheetObject.SetCellValue(Row1, "bkg_no",bkgNo2,0);
    		sheetObject.SetCellValue(Row1, "bl_no","",0);
    		sheetObject.SetCellValue(Row1, "syscd","BKG",0);
    		sheetObject.SetCellValue(Row1, "tmplmrd",strPath,0);
    		sheetObject.SetCellValue(Row1, "batchflg","N",0);
    		sheetObject.SetCellValue(Row1, "tmplparam",rdParam,0);
    		sheetObject.SetCellValue(Row1, "rcvinfo",formObj.fax.value,0);
    		sheetObject.SetCellValue(Row1, "tmplmrdpdf",strPdf,0);// change pdf name(RD file name)
    		sheetObject.SetCellValue(Row1, "history_gubun","N",0);// change pdf name(RD file name)
    		sheetObject.SetCellValue(Row1, "title",title,0);
    		// ---> pdf name)
    		sheetObject.SetCellValue(Row1, "itr","|$$|",0);
    		var Row2=sheetObject.DataInsert();
    		sheetObject.SetCellValue(Row2, "bkg_no",bkgNo2,0);
    		sheetObject.SetCellValue(Row2, "bl_no","",0);
    		sheetObject.SetCellValue(Row2, "syscd","BKG",0);
    		sheetObject.SetCellValue(Row2, "tmplmrd",strPath,0);
    		sheetObject.SetCellValue(Row2, "batchflg","N",0);
    		sheetObject.SetCellValue(Row2, "tmplparam",rdParam,0);
    		sheetObject.SetCellValue(Row2, "history_gubun","N",0);// change pdf name(RD file name)
//    		 alert("ggg -> " + inListType);
//    		 alert("Row2 : " + Row2);
   			sheetObject.SetCellValue(Row2, "title",title);
   			sheetObject.SetCellValue(Row2, "contents","Dear Partner,\n\nPlease refer to the attachment for Container Loading List\n\n- VVD: "
   					+ formObj.in_vvd.value + "\n- Loading Port: " + formObj.in_pol_cd.value + "\n\nNYK Shipping Co., Ltd");
    		//alert("ddd-> " + sheetObject.CellValue(Row2, "contents"));
    		sheetObject.SetCellValue(Row2, "rcveml",formObj.email.value,0);// Receive e-mail address
    		sheetObject.SetCellValue(Row2, "tmplmrdpdf",strPdf,0);// change pdf name(RD file name)
    		// ---> pdf file name)
    		sheetObject.SetCellValue(Row2, "itr","|$$|",0);
    		FaxEmailSend(sheetObject, formObj);
    }
    function FaxEmailSend(sheetObj, formObject) {
    	ComOpenWait(true);
    	formObject.f_cmd.value=SEARCH01;
    	var sXml=sheetObj.GetSaveData("ESM_BKG_0221GS.do", FormQueryString(formObject) + "&" + sheetObj.GetSaveString());
    	ComOpenWait(false);
    	if (sXml.substring(1, 6) == "ERROR") {
    		//
    		alert(ComResultMessage(sXml).split('<||>').join('\n'));
    	} else {
    		//
    		var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
    		// alert("State : [" + State + "]");
    		if (State == "S") {
    			ComShowCodeMessage('BKG06082');
    		}
    	}
    	sheetObj.RemoveAll();
    	return;
    }
    function sheet1_OnMouseMove( sheetObj, Button, Shift, X, Y){
    	var mCol = sheetObj.MouseCol();
    	var mRow = sheetObj.MouseRow();
    	if ( sheetObj.ColSaveName(mCol) == prefix+"esig" && sheetObj.GetCellValue(mRow, prefix+"esig") =='Y'){
    		sheetObj.SetToolTipText(mRow, mCol, sheetObj.GetCellValue(mRow, prefix+"esig_co_nm"));
    	}
    }
    function jqueryEvent(){
    	$("#bkg_no").keyup(function(){
    		if($(this).val() != ""){
    			multiBkgTextArea(1, 'mult_bkg_no');
    		}
    	});
    	$("#mult_bkg_no").keyup(function(){
    		multiBkgTextArea(2, 'mult_bkg_no');
    	});
    	
    	$("#mult_bkg_no").focusout(function(){
    		$("#layList").hide();
    	});    	
    	
    }
    
    function onCheck(obj)
    {
    	if(obj.name=="diff_5_pct"){
    		if(document.form.diff_5_pct.checked){
        		document.form.diff_10_pct.checked = false;
    		}else{
    			document.form.diff_5_pct.checked = false;
    		}
    	}else if(obj.name=="diff_10_pct"){
    		if(document.form.diff_10_pct.checked){
        		document.form.diff_5_pct.checked = false;
    		}else{
    			document.form.diff_10_pct.checked = false;
    		}
    	}
    }
