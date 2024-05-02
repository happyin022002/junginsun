/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0104_01.js
*@FileTitle  : Report Template
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
   	/* developer's work*/
/*
 * variable which is for handling inserting value to initial value 
 * */
var arrFormElementMap={vvd_cd:'input',       trunk_flag:'check',     lane_cd:'input',			 dir_cd:'multi',				 pol_cd:'input', 
                         pol_yard_cd:'input',  pol_local:'check',      pol_ts:'check',			 pod_cd:'input',				 pod_yard_cd:'input', 
												 pod_local:'check',    pod_ts:'check',         por_cd:'input',			 del_cd:'input',				 r_term:'multi', 
												 d_term:'multi',       zone_cd:'select',       deli_mode:'multi',		 board_from_dt:'input',  board_to_dt:'input', 
												 bkg_from_dt:'input',  bkg_to_dt:'input',      bkg_kind:'multi',		 b_ofc_cd:'input',       b_ofc_cd_sub:'check', 
												 b_staff_id:'combo',   ca_flag:'check',        agent_cd:'input',		 agent_cd_all:'check',   eq_type:'multi', 
												 cmdt_cd:'input',      cmdt_nm:'input',        wgt_from:'input',		 wgt_to:'input',         so_no:'input', 
												 l_ofc_cd:'input',     l_ofc_cd_sub:'check',   dept_cd:'input',			 l_rep_id:'combo',       c_ofc_cd:'input', 
												 c_ofc_cd_sub:'check', c_rep_id:'input',       ctr_rfa_cd:'radio',	 ctr_rfa_no:'input',     s_mode_ori:'multi', 
												 s_mode_dest:'multi',  s_route_ori:'multi',    s_route_dest:'multi', fv_pre_pst_cd:'radio',  fv_vvd_cd:'input', 
												 fv_pol_cd:'input',    fv_pol_yard_cd:'input', fv_pol_local:'check', fv_pod_cd:'input',      fv_pod_yard_cd:'input', 
												 fv_pod_local:'check', cust_tp_cd_s:'check',   cust_tp_cd_c:'check', cust_tp_cd_n:'check',   cust_tp_cd_f:'check', 
												 cust_tp_cd_a:'check', cust_tp_cd_g:'check',   cust_cnt_cd:'input',  cust_seq:'input',       cust_nm:'input', 
												 cust_tp_cd:'multi',   sp_cargo_dg:'check',    sp_cargo_rf:'check',  sp_cargo_ak:'check',    sp_cargo_bb:'check', 
												 sp_cargo_hg:'check',  sp_cargo_soc:'check',   sp_cargo_eq:'check',  sp_cargo_rd:'check',    sp_cargo_pm:'check', 
												 sp_cargo_pc:'check',  sp_cargo_fg:'check',    sp_cargo_hd:'check',  sp_cargo_rb:'check',    cargo_tp_f:'check', 
												 cargo_tp_p:'check',   cargo_tp_r:'check',     bkg_sts_cd_f:'check', bkg_sts_cd_x:'check',   bkg_sts_cd_a:'check', 
												 bkg_sts_cd_w:'check', non_sp_cargo:'check',   holding:'check',      bl_type_a:'check',      bl_type_s:'check', 
												 rev:'check',          non_rev:'check',        aes_y:'check',        aes_n:'check',          stop_cargo:'check', 
												 ro_y:'multi',                                 caed_y:'check',       caed_n:'check',         crn_no_flag:'check', 
												 certi_y:'check',      certi_n:'check',        certi_d:'check',      certi_a:'check',        certi_b:'check',
												 certi_g:'check',      certi_c:'check'
                        }
 // global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var prefix="";//IBSheet divider
 /*********************** EDTITABLE MULIT COMBO START ********************/
 var comboCnt=0;
 var comboObjects=new Array();
 var b_staff_idMultiComboDataAdded=false;
 var l_rep_idMultiComboDataAdded=false;
   /*********************** EDTITABLE MULIT COMBO END ********************/
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
      /**
      * registering the created IBCombo Object at page as comboObjects list
      * calling from ComComboObject 
	 	 	* param : comboObj ==> combo Object
	 	 	* 
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
         for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }
		      //initializing MultiCombo
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
	 	    //setItemOptionHidden();//Item Option Hidden 
		    initControl();
		     if (document.form.edit_yn.value == "N"){
            	ComBtnDisable("btn_OK");
            	ComBtnDisable("btn_New");
		     }
		     doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
				 setFeederVessel(); //  initializing Feeder Vessel with Trunk
				 setCRNNo();//  initializing CRN No. with POD T/S
     }
	/**
	 	 * setting Combo  
	 	 * param : comboObj ==> combo Object, comboNo ==> sequence which is ID of comboObject tag
	 	 * construct initial module of sheet, as adding case which is a number of combo 
	 	 */ 
	 	function initCombo(comboObj, comboId) {
	 	    var formObject=document.form
 				initComboEditable(comboObj, comboId)
	 	}
 	 // setting multiple combo selection and modification
 	 function initComboEditable(combo, comboId){
	 	 	with (combo) {
	 	 		if(comboId == "b_staff_id" || comboId == "l_rep_id" || comboId == "ro_y" ){
	 	 			MultiSelect = false;
		 	 		UseAutoComplete = true; 
			 	    UseEdit = false;
	 	 		}
	 	 		else{
		 	 		MultiSelect = true;
			 	    UseEdit = false;	
	 	 		}
	 	 	}
 	 }
    function initControl() {
    	var formObject=document.form;
//        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- keyboard
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- out of focus     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- focus in
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
    }
/*********************** KEY EVENT START ********************/ 	 
	  /**
     * controlling onBlur of HTML Control .
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "b_ofc_cd":
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','b_ofc_cd');
					break;	    		
	    	case "l_ofc_cd":
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','l_ofc_cd');
					break;	    		
	    	case "board_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "board_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }        
	/**
	 * checking Validation at onFocus event  <br>
	 **/
	function bkg_focus(){
		//checking Validation 
		switch(event.srcElement.name){	
	    	case "board_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "board_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "bkg_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
					break;
		}
	}  
/**
	 	 *  initializing Feeder Vessel with Trunk 
	 	 * param : 
	 	 *  initializing Feeder Vessel with Trunk 
	 	 */ 
function setFeederVessel(){
	if(form.trunk_flag.checked){
		form.fv_vvd_cd.disabled=false;
		form.fv_pre_pst_cd[0].disabled=false;
		form.fv_vvd_cd.disabled=false;
		form.fv_pre_pst_cd[0].disabled=false;
		form.fv_pre_pst_cd[1].disabled=false;
		form.fv_vvd_cd.disabled=false;
		form.fv_pol_cd.disabled=false;
		form.fv_pol_yard_cd.disabled=false;
		form.fv_pol_local.disabled=false;
		form.fv_pod_cd.disabled=false;
		form.fv_pod_yard_cd.disabled=false;
		form.fv_pod_local.disabled=false;
		form.fv_vvd_cd.style.background="#FFFFFF";
		form.fv_pol_cd.style.background="#FFFFFF";
		form.fv_pol_yard_cd.style.background="#FFFFFF";
		form.fv_pod_cd.style.background="#FFFFFF";
		form.fv_pod_yard_cd.style.background="#FFFFFF";		
	}else{
		form.fv_vvd_cd.value="";
		form.fv_pre_pst_cd[0].checked=false;
		form.fv_pre_pst_cd[1].checked=false;
		form.fv_vvd_cd.value="";
		form.fv_pol_cd.value="";
		form.fv_pol_yard_cd.value="";
		form.fv_pol_local.checked=false;
		form.fv_pod_cd.value="";
		form.fv_pod_yard_cd.value="";
		form.fv_pod_local.checked=false;
		form.fv_vvd_cd.disabled=true;
		form.fv_vvd_cd.disabled=true;
		form.fv_pre_pst_cd[0].disabled=true;
		form.fv_pre_pst_cd[0].disabled=true;
		form.fv_pre_pst_cd[1].disabled=true;
		form.fv_vvd_cd.disabled=true;
		form.fv_pol_cd.disabled=true;
		form.fv_pol_yard_cd.disabled=true;
		form.fv_pol_local.disabled=true;
		form.fv_pod_cd.disabled=true;
		form.fv_pod_yard_cd.disabled=true;
		form.fv_pod_local.disabled=true;
		form.fv_vvd_cd.style.background="#E8E7EC";
		form.fv_pol_cd.style.background="#E8E7EC";
		form.fv_pol_yard_cd.style.background="#E8E7EC";
		form.fv_pod_cd.style.background="#E8E7EC";
		form.fv_pod_yard_cd.style.background="#E8E7EC";
	}
}	
/*********************** KEY EVENT END ********************/
	/**
	 	 * initializing CRN No. check button with POD T/S
	 	 * param : 
	 	 */ 
function setCRNNo(){
	if(form.pod_ts.checked){
		form.crn_no_flag.disabled=false;
		form.crn_no_flag.style.background="#FFFFFF";
	}else{
		form.crn_no_flag.checked=false;
		form.crn_no_flag.disabled=true;
		form.crn_no_flag.style.background="#E8E7EC";
	}
}
	// Event handler processing by button click event */
 		document.onclick=processButtonClick;
		var tempSqlCon="";
		var nullMultiComboStr="<SHEET> <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='1'> <TR><![CDATA[]]></TR> </DATA> </SHEET> ";
		var roYComboStr="<SHEET> <DATA COLORDER='val|desc' COLSEPARATOR=',' TOTAL='6'> 	<TR><![CDATA[,]]></TR> 	<TR><![CDATA[1,Over 1 time]]></TR> 	<TR><![CDATA[2,Over 2 times]]></TR> 	<TR><![CDATA[3,Over 3 times]]></TR> 	<TR><![CDATA[4,Over 4 times]]></TR> 	<TR><![CDATA[5,Over 5 times]]></TR> </DATA> </SHEET> ";
 	// Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1=sheetObjects[0];
					var comboObject1=comboObjects[0]; 
          /*******************************************************/
          var formObject=document.form;
	     	try {
	     		var srcName=ComGetEvent("name");
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_Save":
		 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
		 					break;
		 				case "btn_OK":
		 					var opener = window.dialogArguments;
		 					if (!opener)  opener=window.opener;
		 					if (!opener) opener=parent;
		 					opener.setSearchOption(getValidCondition(FormQueryString(formObject)));
		 					/*  clicking the save button at screen 0104 */
		 					opener.setSearchSaveOption();
		 					ComClosePopup(); 
		 					break;
		 				case "btn_Set":
		 					setCondition(tempSqlCon);
		 					break;
		 				case "btn_New":
		 					initAll(formObject);
		 					//sheetObject1.RemoveAll();  
		 					break;
		 				case "btn_Close":
		 					ComClosePopup(); 
		 					break;
		 				case "btn_commodity_pop": 		
							comBkgCallPop0653("setCallBack0653",formObject.cmdt_cd.value,'','Commo Pop');
							break;		 								
		 				case "btn_ctr_fra_pop": 		
							var param="?cust_cd="+formObject.cust_cnt_cd.value+eval(formObject.cust_seq.value);
	 						ComOpenPopup('/opuscntr/COM_ENS_021.do'+param, 780, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
							break;		 								
		 				case "btn_customer_pop":
		 				  var param="" ;
		 				  param="?cust_cd="+formObject.cust_cnt_cd.value;
		 				  if(formObject.cust_seq.value != ""){
		 				  	param += eval(formObject.cust_seq.value);
		 				  }
		 				  param += "&cust_nm="+formObject.cust_nm.value;	
	 						ComOpenPopup('/opuscntr/COM_ENS_041.do'+param, 770, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
							break;		
						case "btn_board_date":
		 					var cal=new ComCalendarFromTo();
							cal.select(formObject.board_from_dt, formObject.board_to_dt,'yyyy-MM-dd');
						 	break;
						case "btn_bkg_date":
							var cal=new ComCalendarFromTo();
							cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
							break; 								
						case "cust_tp_cd_g":
							if(form.cust_tp_cd_g.checked){
								form.cust_tp_cd_s.checked=false;
								form.cust_tp_cd_c.checked=false;
								form.cust_tp_cd_n.checked=false;
								form.cust_tp_cd_f.checked=false;
								form.cust_tp_cd_a.checked=false;
							}
							break;
						case "trunk_flag":
							setFeederVessel();
							break; 	
						case "cust_tp_cd_s":
							form.cust_tp_cd_g.checked=false;
							break; 								
						case "cust_tp_cd_c":
							form.cust_tp_cd_g.checked=false;
							break; 								
						case "cust_tp_cd_n":
							form.cust_tp_cd_g.checked=false;
							break; 								
						case "cust_tp_cd_f":
							form.cust_tp_cd_g.checked=false;
							break; 								
						case "cust_tp_cd_a":
							form.cust_tp_cd_g.checked=false;
							break;
						case "pol_local":
							if(form.pol_local.checked){
								form.pol_ts.checked=false;
							}
							break; 		
						case "pol_ts":
							if(form.pol_ts.checked){
								form.pol_local.checked=false;
							}
							break; 										
						case "pod_local":
							if(form.pod_local.checked){
								form.pod_ts.checked=false;
							}
							break; 		
						case "pod_ts":
							if(form.pod_ts.checked){
								form.pod_local.checked=false;
							}
							setCRNNo();
							break; 										
						case "rev":
							if(form.rev.checked){
								form.non_rev.checked=false;
							}
							break; 		
						case "non_rev":
							if(form.non_rev.checked){
								form.rev.checked=false;
							}
							break; 		
						case "aes_y":
							if(form.aes_y.checked){
								form.aes_n.checked=false;
							}
							break; 		
						case "aes_n":
							if(form.aes_n.checked){
								form.aes_y.checked=false;
							}
							break; 		
//		   	     case "ro_y":
//							if(form.ro_y.checked){
//								form.ro_n.checked = false;
//							}
//							break; 		
//		  	      case "ro_n":
//							if(form.ro_n.checked){
//								form.ro_y.checked = false;
//							}
//							break; 		
						case "caed_y":
							if(form.caed_y.checked){
								form.caed_n.checked=false;
							}
							break; 		
						case "caed_n":
							if(form.caed_n.checked){
								form.caed_y.checked=false;
							}
							break; 		
						case "certi_y":
							if(form.certi_y.checked){
								form.certi_n.checked=false;
							}
							break; 		
						case "certi_n":
							if(form.certi_n.checked){
								form.certi_y.checked=false;
							}
							break; 		
						case "bl_type_a":
							if(form.bl_type_a.checked){
								form.bl_type_s.checked=false;
							}
							break; 		
						case "bl_type_s":
							if(form.bl_type_s.checked){
								form.bl_type_a.checked=false;
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
   // handling of Sheet 
     var arrMultiCombo;//variable to set multi combo
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			 			case SEARCH01:     
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH01;
							var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj));
							arrMultiCombo=sXml.split("|$$|");	
							initAll(formObj);
							initReportType();
						  setCondition(report_type.GetSelectCode());
						  //debugdiv.innerHTML=ComReplaceStr(arrXml[1], "<", "&lt") ;
						  //var p_skd_dir_cd ="<SHEET> <DATA COLORDER='val|ibflag|desc|name|comboCd|pagerows|'	COLSEPARATOR='~~' TOTAL='3'> <TR> 	<![CDATA[A~~~~ALL~~ ~~CD00714~~]]> </TR> <TR> 	<![CDATA[E~~~~EAST~~EAST~~CD00714~~]]> </TR> <TR> 	<![CDATA[W~~~~WEST~~WEST~~CD00714~~]]> </TR> </DATA> </SHEET>"
						  //var arrData = ComXml2ComboItem(p_skd_dir_cd , formObj.skd_dir_cd, "val", "name");
							break;
			 			case SEARCH02:      //Staff List 
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value=SEARCH02;
							var p_ofc_cd="";
							var p_ofc_gubun="";
							if(subGubun =="b_ofc_cd"){
								p_ofc_cd=formObj.b_ofc_cd.value;
								p_ofc_gubun="BO";
							}else if(subGubun =="l_ofc_cd"){
								p_ofc_cd=formObj.l_ofc_cd.value;
								p_ofc_gubun="LO";
							}
							var sXml=sheetObj.GetSearchData("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd+"&p_ofc_gubun="+p_ofc_gubun);
							if(subGubun =="b_ofc_cd"){
							  ComXml2ComboItem(sXml, b_staff_id, "usr_id", "usr_id");
							}else if(subGubun =="l_ofc_cd"){
							  ComXml2ComboItem(sXml, l_rep_id, "srep_cd", "srep_cd");
							}
							break;
 						case IBSEARCHAPPEND:  
						case IBINSERT:      				
							sheetObj.DataInsert(-1);
							break;
			    }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
     	return true;
    	switch(sAction) {
    		case IBSEARCH:
	    		if (ComIsNull(formObj.p_pod_cd)) {
	     					ComShowCodeMessage('BKG00626','POD Code');
	     					return false;
			  	}
	    		if (formObj.p_pod_cd.value.length !=5) {
	     					ComShowCodeMessage('BKG95018','POD Code','5');
	     					return false;
			  	}
	  			break;
    		case IBSAVE:
	  			break;
    	 }
         return true;
     }
	 /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
   function initSheet(sheetObj,sheetNo) {}
/*############################# combo onchage start ########################*/
/**
	 * checking the inserting value at MultiCombo is added value or not
	 * registering the inserting value to change upper
	 * @param comboObj
	 * @return
	 */
	function report_type_OnChange(comboObj) {
		initAll(document.form);
		setCondition(comboObj.GetSelectCode());
		setFeederVessel(); 
	}
	function b_staff_id_OnChange(comboObj) {
		//combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function l_rep_id_OnChange(comboObj) {
		//combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function combo_Change(comboObj, multiComboDataAddedFlag) {
		var formObject=document.form;  
		// changing the input value to upper case  
   	 	var comboText=comboObj.GetSelectText().toUpperCase();
   	 	// deleting if it is registered before 
   	 	if (multiComboDataAddedFlag) { 
   	 		comboObj.DeleteItem(0);
	 			multiComboDataAddedFlag=false; 
   	 	} 
   	 	// return if selected or inserted value is in the combo
   	 	if (comboObj.FindItem(comboText, 0) != -1) {
   	 		return; 
   	 	} 
   	 	comboObj.InsertItem(0, comboText, comboText); 
	 		multiComboDataAddedFlag=true; // registering combo to inserting value(global variable) 
	 		comboObj.SetSelectText(comboText,false);// inserting value can be selected
	 }	 
/*############################# combo onchage end ########################*/		
	 /*
	  * the name of Report Template which is parameter
	  * setting Report Type.
	  */
	var paramReportName="";
	var paramReportIndex="";
	/*
	 * initializing all.
	 * */
	function initAll(formObject){
		form.reset();
		ComXml2ComboItem(roYComboStr, ro_y, "val", "desc");
		ComXml2ComboItem(nullMultiComboStr, b_staff_id, "val", "val");
		ComXml2ComboItem(nullMultiComboStr, l_rep_id, "val", "val");
		ComXml2ComboItem(arrMultiCombo[0], dir_cd, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[1], r_term, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[2], d_term, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[3], deli_mode, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[4], bkg_kind, "desc", "desc");
	  ComXml2ComboItem(arrMultiCombo[5], eq_type, "cntr_tpsz_cd", "cntr_tpsz_cd");
	  ComXml2ComboItem(arrMultiCombo[6], s_mode_ori, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[6], s_mode_dest, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[7], s_route_ori, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[7], s_route_dest, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[8], cust_tp_cd, "val", "val");	  
	  
		dir_cd.SetMultiSelect(1);
		dir_cd.SetMultiSeparator(",");	
		r_term.SetMultiSelect(1);
		r_term.SetMultiSeparator(",");		
		d_term.SetMultiSelect(1);
		d_term.SetMultiSeparator(",");
		deli_mode.SetMultiSelect(1);
		deli_mode.SetMultiSeparator(",");
		bkg_kind.SetMultiSelect(1);
		bkg_kind.SetMultiSeparator(",");
		eq_type.SetMultiSelect(1);
		eq_type.SetMultiSeparator(",");
		s_mode_ori.SetMultiSelect(1);
		s_mode_ori.SetMultiSeparator(",");		
		s_mode_dest.SetMultiSelect(1);
		s_mode_dest.SetMultiSeparator(",");
		s_route_ori.SetMultiSelect(1);
		s_route_ori.SetMultiSeparator(",");
		s_route_dest.SetMultiSelect(1);
		s_route_dest.SetMultiSeparator(",");
		cust_tp_cd.SetMultiSelect(1);
		cust_tp_cd.SetMultiSeparator(",");		
		
	}
	function initReportType(){
		ComXml2ComboItem(arrMultiCombo[8], report_type, "bzc_cond_sql_ctnt", "rpt_nm");
//	  var arr=ComBkgXml2Array(arrMultiCombo[9], "rpt_nm");
//	  var chkRptTypeFlg=false;
//	  for(var index=0; index<arr.length; index++) {
//	  	if(arr[index] == paramReportName){
//	  		chkRptTypeFlg=true;
//	  		report_type.SetSelectIndex(index);
//	  	}
//	  }
//	  if(!chkRptTypeFlg){
//	  	report_type.SetSelectText(arr[0],false);
//	  }
 	  report_type.SetSelectIndex(paramReportIndex);
 	  
	}
    /**
     * condition setting
     */ 
  function setCondition(sqlCtnt){
  	var arrSqlCtnt=sqlCtnt.URLDecode().split("|");
   	var formNameValue ; 
  	var field;
  	try{
	   	for (var i=0 ; i < arrSqlCtnt.length ; i++){
	   			formNameValue=arrSqlCtnt[i].split("=");
	   			if(formNameValue[1] =="") continue;
	   			if(arrFormElementMap[formNameValue[0]] == "check"){
						eval("form."+formNameValue[0]).checked=true;
					}else if(arrFormElementMap[formNameValue[0]] == "radio"){
						field=eval("form."+formNameValue[0]);
							for(var j=0; j < field.length; j++) {
								if(field[j].value == formNameValue[1]){
									field[j].checked=true;
									break;
								}
							}
					}else if(arrFormElementMap[formNameValue[0]] == "select"){
						field=eval("form."+formNameValue[0]);
							for(var j=0; j < field.length; j++) {
								if(field[j].value == formNameValue[1]){
									field[j].selected=true;
									break;
								}
							}
					}else if(arrFormElementMap[formNameValue[0]] == "combo"){
//						eval("form."+formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
						eval(formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
					}else if(arrFormElementMap[formNameValue[0]] == "multi"){
//						eval("form."+formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
						eval(formNameValue[0]).SetSelectCode(formNameValue[1].URLDecode());
					}else{
						field=eval("form."+formNameValue[0]);
					  field.value=formNameValue[1];
					  if(field.name == "b_ofc_cd")
					  	doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','b_ofc_cd');
					  else if(field.name == "l_ofc_cd")
					  	doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','l_ofc_cd');  		
	   			}
	   	}//end for
  	}catch(e){}
  }
		/*
		 * method of setting Customer searching result 
		 * */
		function setCustomer(val){
				var c_cd=val[0][3];
				var c_name=val[0][4];
				form.cust_cnt_cd.value=c_cd.substring(0,2);
				form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
				form.cust_nm.value=c_name;
		} 
		 /**
		 * searching the Code to input Commodity Code .<br>
		 * @param {arry} aryPopupData
		 */
		function setCallBack0653(aryPopupData) {
			var formObject=document.form;
			formObject.cmdt_cd.value=aryPopupData[0][3];
			//formObject.rep_cmdt_cd.value = aryPopupData[0][5];
			formObject.cmdt_nm.value=aryPopupData[0][4];
		}
	/**
  * deleting if value is not existed
  */ 
  function getValidCondition(sql){
  	var arrSqlCtnt=sql.URLDecode().split("&");
   	var formNameValue ;
   	var returnSql=""; 
   	for (var i=0 ; i < arrSqlCtnt.length ; i++){
   			formNameValue=arrSqlCtnt[i].split("=");
   			if(formNameValue[1] == undefined || formNameValue[1] == "") continue;
   			returnSql += formNameValue[0]+"="+formNameValue[1].URLEncode()+"|";
   	}//end for
   	return returnSql;
  }
  /* version up 2010.1.22 */
	/* the end of developer's work */    
