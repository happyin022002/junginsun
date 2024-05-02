/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0068.js
*@FileTitle  : B/L(Manifest) Clearance Cross-Check List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
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
 var prefix="sheet1_";//IBSheet Delimiter
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
 	var comboObjects=new Array();
	var p_no_goodMultiComboDataAdded=false;
	var p_eq_typeMultiComboDataAdded=false;
	var p_rcv_term_cdMultiComboDataAdded=false;
	var p_de_term_cdMultiComboDataAdded=false;
	var p_bkg_sts_cdMultiComboDataAdded=false;
	var p_cnmv_sts_cdMultiComboDataAdded=false;
	var p_bkg_cust_tp_cdMultiComboDataAdded=false;
	var p_del_contiMultiComboDataAdded=false;
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
                         p_cnmv_sts_cd:"p_cnmv_sts_cd.GetSelectText()" ,
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
	             p_cnmv_sts_cd:"Cargo Type" ,
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
 	    if(comboId == "p_no_good"){
    			comboObj.SetDropHeight(200);
    			initCombo_p_no_good();
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
    function initCombo_p_no_good() {
    	with (p_no_good) {
    		SetMultiSelect(1);
    		SetMultiSeparator("|");
    		//ColCnt = 2;
				var i=0; 
				InsertItem(i++, " ", ""); 
				InsertItem(i++, "Un-Rated B/L", "BL"); 
				InsertItem(i++, "Un-Confirm CNTR", "CFC"); 
				InsertItem(i++, "Non-CM CNTR", "CMC"); 
				InsertItem(i++, "Non-M&D B/L", "MD"); 
				InsertItem(i++, "Non-VL CNTR", "VLC"); 
				InsertItem(i++, "Non-Issued B/L", "IS"); 
				InsertItem(i++, "Non-SR Received B/L", "RC"); 
			} 
    }
/*############################# combo onchage start ########################*/
/**
	 * Check if the value entered in MultiCombo int added
	 * After changes to the English uppercase input value re-input
	 * @param comboObj
	 * @return
	 */
	function p_eq_type_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.options.id+"MultiComboDataAdded"));
	 }
	function p_rcv_term_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.options.id+"MultiComboDataAdded"));
	 }
	function p_de_term_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.options.id+"MultiComboDataAdded"));
	 }
	function p_bkg_sts_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.options.id+"MultiComboDataAdded"));
	 }
	function p_cnmv_sts_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.options.id+"MultiComboDataAdded"));
	 }
	function p_bkg_cust_tp_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.options.id+"MultiComboDataAdded"));
	 }
	function p_del_conti_OnChange(comboObj) {
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
	    form.p_vvd.focus();
     }
    function initControl() {
    	var formObject=document.form;
//        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- When typing the keyboard
        axon_event.addListenerForm  ('beforedeactivate', 'bkg_deactivate',  formObject); //- out  focus 
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- in  focus 
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    }        
 /*********************** KEY EVENT START ********************/ 	 
//	function bkg_keypress(){
//	    switch(event.srcElement.dataformat){
//	    	case "engup":
//	        //English uppercase characters
//    			ComKeyOnlyAlphabet('upper');
//	        break;
//	      case "engupnum":
//	        //the number + English capital letter
//	      	ComKeyOnlyAlphabet('uppernum');
//	        break;
//	      case "num":
//	        //Numeric input
//	        ComKeyOnlyNumber(event.srcElement);
//	        break;	 
//	      case "engnum":
//  	  	  	ComKeyOnlyAlphabet('num'); 
//	      	break;	    
//	      case "custname":
//	        //Numeric input
//	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
//	        break;	            
//	      default:
//	    }
//	}  
	  /**
     * HTML Control  onBlur Event.
     **/
    function bkg_deactivate() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "bdr_dt":
	    		ComAddSeparator(ComGetEvent());
					break;
	    	case "from_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
	    	case "to_dt":
	    		ComAddSeparator(ComGetEvent());
					break;	    		
				default:
					break;
	    }
    }        
	/**
	 * The onFocus event in HTML Control Validation Check. <br>
	 **/
	function bkg_activate(){
		//Input Validation to check
		switch(ComGetEvent("name")){	
	    	case "bdr_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
	    	case "from_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
	    	case "to_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
			default:
				break;
		}
	}  
/*********************** KEY EVENT END ********************/
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
		 				case "btn_RowAdd":
		 					doActionIBSheet(sheetObject1,formObject,IBINSERT);
		 					break;
		 				case "btn_RowDelete":
		 					ComRowHideDelete(sheetObject1,"sheet1_del_chk");
		 					break;
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_New":
		 					location.reload(true);
		 					formObject.p_vvd.focus();
		 					break;
		 				case "btn_DownExcel":
		 					if(sheetObject1.RowCount() < 1){//no data
		 						ComShowCodeMessage("COM132501");
		 					}else{
		 						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					}
		 					break;
		 				case "btn_Print":
		 					doActionIBSheet(sheetObjects[0],formObject,RDPRINT);
		 					break;
						case "btn_Combine":
							var chkRowArr=ComFindAll(sheetObjects[0], prefix + "check2", "1");
							var iCheckRow=sheetObjects[0].CheckedRows(prefix + "check");
							if (iCheckRow < 2){
								ComShowCodeMessage("BKG95001","select more than 2","Booking No");
								return false;
							}
							if (0 < chkRowArr.indexOf("|")) {
								if (!validateForm(sheetObjects[0],formObject,"btn_Combine")) {
									return false;
								}
								comBkgCallPop0974('callBack0974');
							} else {
								ComShowCodeMessage("BKG00155");
								return false;
							}
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
   // Sheet handling process
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         switch(sAction) {
 			case IBSEARCH:      //Retrieve 				
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				formObj.f_cmd.value=SEARCH;
 				//formObj.curr_page.value=1;
				form.rows_per_page.value=rowsPerPage;
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0068GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				ComOpenWait(false);
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				if(ComGetEtcData(sXml, "total_bkg") == undefined){
					break;
				}
				formObj.total_bkg.value=ComGetEtcData(sXml, "total_bkg");
				formObj.total_bl.value=ComGetEtcData(sXml, "total_bl");
				formObj.total_bkg_f.value=ComGetEtcData(sXml, "total_bkg_f");
				formObj.total_bkg_t.value=ComGetEtcData(sXml, "total_bkg_t");
				formObj.total_ctrl_f.value=ComGetEtcData(sXml, "total_ctrl_f");
				formObj.total_ctrl_t.value=ComGetEtcData(sXml, "total_ctrl_t");
				formObj.total_cfm.value=ComGetEtcData(sXml, "total_cfm");
				formObj.total_vl.value=ComGetEtcData(sXml, "total_vl");
				formObj.total_cm.value=ComGetEtcData(sXml, "total_cm");
				formObj.total_md.value=ComGetEtcData(sXml, "total_md");
				formObj.total_charge.value=ComGetEtcData(sXml, "total_charge");
				formObj.total_apprval.value=ComGetEtcData(sXml, "total_apprval");
				formObj.total_issue.value=ComGetEtcData(sXml, "total_issue");
				formObj.total_receiving.value=ComGetEtcData(sXml, "total_receiving");							
				if(form.p_pol_cd.value.substring(0,2)=='KR' || form.p_pol_cd.value.substring(0,2)=='KR'){
					sheetObj.SetColHidden(prefix + "el_no",0);
				}else{
					sheetObj.SetColHidden(prefix + "el_no",1);
				}
				if(form.p_pol_cd.value.substring(0,2)=='US' || form.p_pol_cd.value.substring(0,2)=='US'){
					sheetObj.SetColHidden(prefix + "aes",0);
				}else{
					sheetObj.SetColHidden(prefix + "aes",1);
				}
				if(form.p_pol_cd.value.substring(0,2)=='BR' || form.p_pol_cd.value.substring(0,2)=='BR'){
					sheetObj.SetColHidden(prefix + "dde",0);
				}else{
					sheetObj.SetColHidden(prefix + "dde",1);
				}
				if(form.p_pol_cd.value.substring(0,2)=='ID' || form.p_pol_cd.value.substring(0,2)=='ID'){
					sheetObj.SetColHidden(prefix + "peb",0);
				}else{
					sheetObj.SetColHidden(prefix + "peb",1);
				}
				if(form.p_pol_cd.value.substring(0,2)=='MX' || form.p_por_cd.value.substring(0,2)=='MX'|| form.p_apod_cd.value.substring(0,2)=='MX'|| form.p_del_cd.value.substring(0,2)=='MX'||
						form.p_pol_cd.value.substring(0,2)=='CO' || form.p_por_cd.value.substring(0,2)=='CO'|| form.p_apod_cd.value.substring(0,2)=='CO'|| form.p_del_cd.value.substring(0,2)=='CO'||
						form.p_pol_cd.value.substring(0,2)=='EC' || form.p_por_cd.value.substring(0,2)=='EC'|| form.p_apod_cd.value.substring(0,2)=='EC'|| form.p_del_cd.value.substring(0,2)=='EC'||
						form.p_pol_cd.value.substring(0,2)=='PE' || form.p_por_cd.value.substring(0,2)=='PE'|| form.p_apod_cd.value.substring(0,2)=='PE'|| form.p_del_cd.value.substring(0,2)=='PE'
					){
					sheetObj.SetColHidden(prefix + "tax_id",0);
				}else{
					sheetObj.SetColHidden(prefix + "tax_id",1);
				}
				if(form.p_pol_cd.value.substring(0,2)=='CA' || form.p_pol_cd.value.substring(0,2)=='CA'){
					sheetObj.SetColHidden(prefix + "caed",0);
				}else{
					sheetObj.SetColHidden(prefix + "caed",1);
				}
				//if ("sheet1" == sheetObj.id) sheetObj.DoSearch("ESM_BKG_0071GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );				
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
				var sXml=sheetObj.GetSearchData("ESM_BKG_0068GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				/*EQ TYPE - CONTAINER TYPE SIZE*/
				/*R/D R- OUTBOUND RECEIVED*/
				/*R/D D- INBOUND DELIVERY*/
				/*BOOKING STATUS*/
				/*CARGO STATUS*/
				/*CUSTOMER TYPE*/
			  ComXml2ComboItem(arrXml[0], p_eq_type, "cntr_tpsz_cd", "cntr_tpsz_cd");
			  ComXml2ComboItem(arrXml[1], p_rcv_term_cd, "val", "val");
			  ComXml2ComboItem(arrXml[2], p_de_term_cd, "val", "val");
			  ComXml2ComboItem(arrXml[3], p_bkg_sts_cd, "val", "val");
			  ComXml2ComboItem(arrXml[4], p_cnmv_sts_cd, "val", "name");
			  ComXml2ComboItem(arrXml[5], p_bkg_cust_tp_cd, "val", "val");
			  ComXml2ComboItem(arrXml[6], p_del_conti, "conti_cd", "conti_nm");
			  p_cnmv_sts_cd.SetSelectIndex(0, false);
			  formObj.p_vvd.focus();
				break;
			case IBINSERT:    
				sheetObj.DataInsert(-1);
				break;
			case IBDOWNEXCEL:   // Excel download
				//sheetObj.Down2Excel({ HiddenColumn:1});
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				break;
			case RDPRINT:   
				//alert("RDPRINTvalue"+form.p_pol_lt.value);	
				//alert("RDPRINTtext"+form.p_pol_lt.text);
				if (sheetObj.RowCount()< 1) {
					ComShowCodeMessage("BKG00495");
					return;
				}
	 			var options="";
				var temp="";
				for (var key in searchOptionsMap){
					temp=eval(searchOptionsMap[key]);
					if(temp != "") {
						options += searchOptionsTitleMap[key]+"-"+temp + "  |  ";
					}
				}
				options=options.substring(0,options.length-5);
				var url="ESM_BKG_0772.do?"+FormQueryString(formObj);	    	
				var winName="ESM_BKG_0772";
				repWin=openWinCenter("about:blank",winName,1010,600);
	 			formObj.f_cmd.value=SEARCH02;
				var frm2=document.form2;
				frm2.rfn.value="/ESM_BKG_0772_1.do?"+FormQueryString(formObj);	    
				frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0772.mrd";
				frm2.rv.value="options["+options+"]";		    
				frm2.rd_title.value="B/L Data Input Cross-Check";
				frm2.action=url;
				frm2.target=winName;
				frm2.submit();
				//frm2.target = "";
			  repWin.focus();
				break;					
		case "run_combine":       
			formObj.f_cmd.value=MODIFY01;
			var params=FormQueryString(formObj);
			params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, prefix + "check2"), "");
			var sXml=sheetObj.GetSaveData("ESM_BKG_0614GS.do", params);
			if(ComGetEtcData(sXml, "isSuccess") == "Y"){
				ComShowCodeMessage("BKG00166");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				if("Y" == ComGetEtcData(sXml, "pre_checking")){
					comBkgCallPop0200(formObj.mst_bkg_no.value, "N");
				}
			} else {
				sheetObjects[0].LoadSaveData(sXml,{Sync:0} );
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
    	ComOpenWait(false);
		var tempFlag;
		with (sheetObj) {
			if (sheetObj.RowCount() <= 0)
	    	     ComShowCodeMessage("BKG00095");
			else
				{
   			var redColor="#FF0000";
   			var blueColor="#0000FF";
   			var rowSpan=1, tmpCnt=rowCnt=0;
   			for (var i=sheetObj.HeaderRows(); i < sheetObj.RowCount()+ HeaderRows(); i++) {
   				SetCellFontColor(i, prefix+"bkg_no",blueColor);
   				SetCellFontUnderline(i, prefix+"bkg_no",1);
   				SetCellFontColor(i, prefix+"bl_no",blueColor);
   				SetCellFontUnderline(i, prefix+"bl_no",1);
				setCelColor( GetCellValue(i, prefix+"cntr_cfm_flg"), sheetObj, i, prefix+"cntr_cfm_flg", redColor);
				setCelColor( GetCellValue(i, prefix+"firm"),         sheetObj, i, prefix+"firm",         redColor);
				setCelColor( GetCellValue(i, prefix+"cm"),           sheetObj, i, prefix+"cm",           redColor);
				setCelColor( GetCellValue(i, prefix+"md"),           sheetObj, i, prefix+"md",           redColor);
				setCelColor( GetCellValue(i, prefix+"charge"),       sheetObj, i, prefix+"charge",       redColor);
				setCelColor( GetCellValue(i, prefix+"apprval"),      sheetObj, i, prefix+"apprval",      redColor);
				setCelColor( GetCellValue(i, prefix+"pkg"),          sheetObj, i, prefix+"pkg",          redColor);
				setCelColor( GetCellValue(i, prefix+"weight"),       sheetObj, i, prefix+"weight",       redColor);
				setCelColor( GetCellValue(i, prefix+"measuere"),     sheetObj, i, prefix+"measuere",     redColor);
				setCelColor( GetCellValue(i, prefix+"issue"),        sheetObj, i, prefix+"issue",        redColor);
				setCelColor( GetCellValue(i, prefix +"aes"),         sheetObj, i, prefix + "aes",        redColor);
				setCelColor( GetCellValue(i, prefix +"receiving"),   sheetObj, i, prefix + "receiving",  redColor);
				setCelColor( GetCellValue(i, prefix +"el_no"),		  sheetObj, i, prefix + "el_no",	  redColor);
				setCelColor( GetCellValue(i, prefix +"dde"),		  sheetObj, i, prefix + "dde",		  redColor);
				setCelColor( GetCellValue(i, prefix +"peb"), 		  sheetObj, i, prefix + "peb",		  redColor);
				setCelColor( GetCellValue(i, prefix +"caed"),		  sheetObj, i, prefix + "caed",		  redColor);
				if(GetCellValue(i,prefix+"weight") == "E"){
					SetCellFontColor(i, prefix+"weight",redColor);
	      		}
				if(GetCellValue(i,prefix+"pkg") == "E"){
					SetCellFontColor(i, prefix+"pkg",redColor);
	      		}      		
				if(GetCellValue(i,prefix+"measuere") == "E"){
					SetCellFontColor(i, prefix+"measuere",redColor);
	      		}
				if ( GetCellValue(i,prefix + "qty_bkg") != GetCellValue(i,prefix + "qty_cntr")){
					SetCellFontColor(i, prefix+"qty_bkg",redColor);
					SetCellFontColor(i, prefix+"qty_cntr",redColor);
	      		}
	      	}
    	 }
		}
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
	    		if (ComIsNull(formObj.p_vvd)) {
     					ComShowCodeMessage('BKG00227');
     					formObj.p_vvd.focus();
     					return false;
		  		}
	    		if (formObj.p_vvd.value.length != 9) {
     					ComShowCodeMessage('BKG00538');
     					formObj.p_vvd.focus();
     					return false;
		  		}
	  			break;
    		case "btn_Combine":
				var param="";
				var chkRow=ComFindAll(sheetObj, prefix + "check2", "1").split("|");
				var bdrBkgList="";
				if ( 1 < chkRow.length ) {
					var bkgNo=sheetObj.GetCellValue(chkRow[0], prefix + "bkg_no").substring(0, 3);
					var shCd=sheetObj.GetCellValue(chkRow[0], prefix + "shipper_code");
					var vvdCd=sheetObj.GetCellValue(chkRow[0], prefix + "tvvd");
					var porCd=sheetObj.GetCellValue(chkRow[0], prefix + "por");
					var polCd=sheetObj.GetCellValue(chkRow[0], prefix + "pol");
					var podCd=sheetObj.GetCellValue(chkRow[0], prefix + "pod");
					var delCd=sheetObj.GetCellValue(chkRow[0], prefix + "del");
					var porNodCd=sheetObj.GetCellValue(chkRow[0], prefix + "por_nod_cd");
					var delNodCd=sheetObj.GetCellValue(chkRow[0], prefix + "del_nod_cd");
					var broker=sheetObj.GetCellValue(chkRow[0], prefix + "broker");
					var bkgOfcCd=sheetObj.GetCellValue(chkRow[0], prefix + "bkg_ofc_no");
					for (var idx=0;idx<chkRow.length-1;idx++) {
						if (bkgOfcCd != sheetObj.GetCellValue(chkRow[idx], prefix + "bkg_ofc_no")) {
    						ComShowMessage(msgs['BKG00160']);
    						return false;
						}
						if (shCd != sheetObj.GetCellValue(chkRow[idx], prefix + "shipper_code")) {
							ComShowMessage(msgs['BKG00157']);
							return false;
						}
						if (vvdCd != sheetObj.GetCellValue(chkRow[idx], prefix + "tvvd")) {
							ComShowMessage(msgs['BKG00998']);
							return false;
						}
						if (porCd != sheetObj.GetCellValue(chkRow[idx], prefix + "por")) {
							ComShowMessage(msgs['BKG00158']);
							return false;
						}
						if (polCd != sheetObj.GetCellValue(chkRow[idx], prefix + "pol")) {
							ComShowMessage(msgs['BKG00997']);
							return false;
						}
						if (podCd != sheetObj.GetCellValue(chkRow[idx], prefix + "pod")) {
							ComShowMessage(msgs['BKG03159']);
							return false;
						} 
						if (delCd != sheetObj.GetCellValue(chkRow[idx], prefix + "del")) {
							ComShowMessage(msgs['BKG00159']);
							return false;
						}
						if (porNodCd != sheetObj.GetCellValue(chkRow[idx], prefix + "por_nod_cd")) {
							ComShowMessage(msgs['BKG02014']);
						}
						if (delNodCd != sheetObj.GetCellValue(chkRow[idx], prefix + "del_nod_cd")) {
							ComShowMessage(msgs['BKG02015']);
						}
						if (broker != sheetObj.GetCellValue(chkRow[idx], prefix + "broker")) {
							ComShowMessage(msgs['BKG02015']);
							return false;
						}
						if(sheetObj.GetCellValue(chkRow[idx],prefix + "bdr")=="Y"){
							if(bdrBkgList ==""){
								bdrBkgList=sheetObj.GetCellValue(chkRow[idx], prefix + "bkg_no");
							} else {
								bdrBkgList=bdrBkgList + ", " + sheetObj.GetCellValue(chkRow[idx], prefix + "bkg_no");
							}
						}
					}
					if(bdrBkgList !=""){
						if (!ComShowCodeConfirm("BKG02038", bdrBkgList)) {
	        	    		return false;
						} 
					}
				}		
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
			              
			            var HeadTitle1=" |No.||No.|Booking No.|B/L No.|Sales\nOffice|Status|Status|Q'ty|Q'ty|Final\nConfirm|Container|Container|Container|Container|Container|Container|Shipper|Consignee|FF|M/D|AES|TAX ID|E/L|DDE|PEB|CAED|POD|DEL|SVC Term|SVC Term|Rate|Rate|Package|Weight|Measure|Special|Special|Special|Special|BDR|B/L Issue|Via S/I|Via S/I|row|chk";
			            var HeadTitle2=" |No.||No.|Booking No.|B/L No.|Sales\nOffice|B|C|BKG|CNTR|Final\nConfirm|No.|SZ|Seal|Vol|ST|C/M|Shipper|Consignee|FF|M/D|AES|TAX ID|E/L|DDE|PEB|CAED|POD|DEL|R|D|Charge|Approval|Package|Weight|Measure|D|R|A|B|BDR|B/L Issue|Receiving|Via|row|chk";
			            var headCount=ComCountHeadTitle(HeadTitle1);
			
			            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:5 , DataRowMerge:0, PrevColumnMergeMode:0 } );
			
			            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			            var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
			            InitHeaders(headers, info);
			
			            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dense_rank",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"check",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dense_rank2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_sls_ofc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_cgo_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:prefix+"qty_bkg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:prefix+"qty_cntr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_cfm_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sz",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seal",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"st",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"shipper",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"consignee",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ff",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"md",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"aes",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tax_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"el_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dde",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"peb",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"caed",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rcv_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"charge",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"apprval",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pkg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"weight",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"measuere",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix+"special_d",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix+"special_r",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix+"special_a",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:prefix+"special_b",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bdr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"issue",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"receiving",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"via",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"rows_per_bkg" },
			                /*{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"shipper_code" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"por" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"pol" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"pod" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"del" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"por_nod_cd" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"del_nod_cd" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"broker" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"bkg_ofc_no" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"hitchment_yn" },
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"tvvd" },*/
			                {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"check2" } ];
			             
			            InitColumns(cols);
			            SetEditable(1);
			            SetCountPosition(0);
			            SetWaitImageVisible(0);
			            SetSheetHeight(350);
			            SetRangeBackColor(1,6,1,10,"#555555");
			            SetRangeBackColor(1,11,1,17,"#555555");
			            SetRangeBackColor(1,29,1,33,"#555555");
			            SetRangeBackColor(1,36,1,40,"#555555");
			            SetRangeBackColor(1,43,1,45,"#555555");
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
	function sheet1_OnChange(sheetObj, Row, Col, Value) {  //After the change event
		if (2==Col) {
    		sheetObj.SetCellValue(startMergeRow, prefix+"check2",1==Value ? "1":"",0);
	    	for (var i=startMergeRow; i <= lastMergeRow; i++) {
	    		sheetObj.SetCellValue(i, Col,Value,0);
	    	}
		}
	}
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
    
