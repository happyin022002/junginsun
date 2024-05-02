/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName :  VOP_VSK_0026.js
*@FileTitle : Actual SKD Report Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class VOP_VSK_0026.jsp : business script for VOP_VSK_0026.jsp
     */
    function vop_vsk_0026() { 
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.initCombo=initCombo;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	var focusObj=null;
	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	var glbDlayRsnCds=null;
	var glbDlayRsnNms=null;
	var glbVslCondCds=null;
	var glbVslCondNms=null;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/*******************************************************/
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
     	try {
			var srcName=ComGetEvent("name");
	         if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				case "btn_port":
					doActionIBSheet(sheetObj, formObj, COMMAND01);
					break;
				case "btn_vvd":
					doActionIBSheet(sheetObj, formObj, COMMAND02);
					break;
				case "btn_print_arr":
					callRDOpen(formObj, "ARR");
	                break;
				case "btn_print_dep":
					callRDOpen(formObj, "DEP");
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
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
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
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
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
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initControl();
		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		document.form.vps_port_cd.focus();
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
		case 1:      // sheet1 init
            with(sheetObj){            	
			      var HeadTitle1="|Sel|Seq";	      
			
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},];
			      InitHeaders(headers, info);			
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			                   {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
			                   {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 } ];
			       
			      InitColumns(cols);
			      SetVisible(0);
			      SetEditable(1);
                        }


		   break;
		}
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
					InsertItem( "Vessel Movement" , "");
					InsertItem( "Vessel Condition" , "");
				}
				break;
		}
	}
	
	/**
   	 * setting combo initial values and header 
   	 * param : comboObj, comboNo
   	 * adding case as numbers of counting combos 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form;
   	    switch(comboObj.options.id) {
   	    	case "vps_port_cd":
				with (comboObj) { 
	   	    		SetTitleVisible(true);
	   	    		SetMultiSelect(0);
		    		SetUseAutoComplete(1);
					SetTitle("SEQ|Port|C/S|Created");
					SetColAlign("center|left|center|center");        
					SetColWidth("38|70|35|60");
					
					ShowCol = 2;
					DropHeight = 160;
					ValidChar(2,0);
					MaxLength = 7;
				}
			break;
   	     }
   	}
	
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSearchData("VOP_VSK_0026GS.do", sParam);
					ComOpenWait(false);
					showSheetData(sheetObj, formObj, sXml);
				}
				break;
			case SEARCH01:		//Call Indicator
				formObj.f_cmd.value=SEARCH01;
				var vParam="vsl_cd=" + formObj.vsl_cd.value
				   + "&skd_voy_no=" + formObj.skd_voy_no.value
				   + "&skd_dir_cd=" + formObj.skd_dir_cd.value
				   + "&vps_port_cd=" + formObj.vps_port_cd.value
				   + "&clpt_ind_seq=" + formObj.clpt_ind_seq.value
				   + "&loc_cd=" + formObj.loc_cd.value
		   		   + "&f_cmd=" + formObj.f_cmd.value;
				//var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				//var sParam = vParam + "&" + ComGetPrefixParam("sheet1_");
				var sXml=sheetObj.GetSearchData("VOP_VSK_0026GS.do", vParam);
				var callIndCds=ComGetEtcData(sXml, "call_ind_cd").split("|");		//turn_clpt_ind_seq Code
				var callIndNms=ComGetEtcData(sXml, "call_ind_nm").split("|");		//turn_clpt_ind_seq Name
//				setHtmlComboSinc(formObj.clpt_ind_seq, callIndCds, callIndNms, "");
				break;
			case SEARCH02:		//pf_svc_tp_cd
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH02;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml=sheetObj.GetSearchData("VOP_VSK_0026GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH03:		//vps_port_cd
				
				formObj.f_cmd.value = SEARCH03;
				var sParam   = FormQueryString(formObj);
				var comboIdx = comboObjects[0].GetSelectIndex();
				var sXml     = sheetObj.GetSearchData("VOP_VSK_0026GS.do", sParam);
				var portList = ComGetEtcData(sXml, "port_list");
				
				//if (portList.length > 0) {
					ComVskXml2ComboItem(sXml, comboObjects[0], "val", "name");
				//}
				
				if(comboObjects[0].GetItemCount() > 0) {					
					comboObjects[0].SetSelectIndex(comboIdx, false);
					comboObjects[0].Focus();
				}else{
					if(formObj.vsl_cd.value!="" && formObj.skd_voy_no.value!="" && formObj.skd_dir_cd.value!=""){
						ComShowMessage("There is no Actual Schedule on VVD("+formObj.vsl_cd.value+formObj.skd_voy_no.value+formObj.skd_dir_cd.value+")");
					}
				}
				
				break;				
			case SEARCH10:		//VSL_CD Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH10;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
					var sXml=sheetObj.GetSearchData("VOP_VSK_0026GS.do", sParam);
					return sXml;
				}
				break;
			case COMMAND01:		//Port Search
				//sUrl = "/opuscntr/VOP_VSK_0043.do?op_=0043";
				//sUrl = "/opuscntr/VOP_VSK_0043.do?f_cmd=" + COMMAND13;
				sUrl="/opuscntr/VOP_VSK_0043.do?port_cd=" + formObj.vps_port_cd.value;
        		ComOpenPopup(sUrl, 422, 510, "returnPortHelp", "0,0", true);
				break;
			case COMMAND02:		//VVD Search
				var vslCd=formObj.vsl_cd.value;
            	if(vslCd == ""){
            		//sUrl = "/opuscntr/VOP_VSK_0219.do?op_=0219";
            		//sUrl = "/opuscntr/VOP_VSK_0219.do?f_cmd=" + COMMAND16;
            		sUrl="/opuscntr/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
            	}else{
            		//sUrl = "/opuscntr/VOP_VSK_0230.do?op_=0230&ctrl_cd=NORL&vsl_cd="+vslCd;
            		//sUrl = "/opuscntr/VOP_VSK_0230.do?f_cmd=" + COMMAND17 + "&ctrl_cd=NORL&vsl_cd="+vslCd;
            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
            	}
				break;
		}
	}
	/**
	 * handling process for input validation
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj, formObj, sAction){
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(ComIsNull(formObj.vps_port_cd.value)){
					ComShowCodeMessage('VSK00027', "Port Code");
					formObj.vps_port_cd.focus();
					return false;
				} else if (formObj.vps_port_cd.value.length < 5) {
					ComShowCodeMessage('VSK00027', "Port Code");
					formObj.vps_port_cd.value="";
					formObj.vps_port_cd.focus();
					return false;
				} else if(ComIsNull(formObj.vsl_cd.value)){
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if (formObj.vsl_cd.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.value="";
					formObj.vsl_cd.focus();
					return false;
				} else if(ComIsNull(formObj.skd_voy_no.value)){
					ComShowCodeMessage('VSK00027', "Voyage No.");
				 	formObj.skd_voy_no.focus();
					return false;
				} else if (formObj.skd_voy_no.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.value="";
					formObj.skd_voy_no.focus();
					return false;
				} else if(ComIsNull(formObj.skd_dir_cd.value)){
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				}
				break;
		}
		return true;
	}
	/**
	 * process after retrieve.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sXml
	 * @return
	 */
	function showSheetData(sheetObj, formObj, sXml){
		var prefix=sheetObj.id + "_";
		if(sXml != null){
			//var rootNode=VskGetXmlRootNode(sXml);
			//var errNode=rootNode.selectNodes("//ERROR");
			var errNode=sXml.search("ERROR");
			if(errNode > 0){
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				clearAllFormData(formObj);
				formObj.vps_port_cd.focus();
				return;
			}else{
//				var dataNode=rootNode.selectNodes("//ETC");
				//var dataNode=rootNode.getElementsByTagName("ETC");
				var dataNode=sXml.search("ETC");
				if(dataNode > 0){
					// Close Check !
					var skdStsCd=ComGetEtcData(sXml, "SKD_STS_CD");
//					if(skdStsCd == "CLO"){
//						ComShowCodeMessage("VSK00100");
//					} 
					setFormToEtcData(sXml);
					setDelayTime(formObj);
					glbVslCondCds=ComGetEtcData(sXml, "vsl_cond_cd").split("|");
					glbVslCondNms=ComGetEtcData(sXml, "vsl_cond_nm").split("|");
					setVslCondSts(formObj);
					glbDlayRsnCds=("|"+ComGetEtcData(sXml, "dlay_rsn_cd")).split("|");	//Delay Reason
					glbDlayRsnNms=("|"+ComGetEtcData(sXml, "dlay_rsn_nm")).split("|");	//Delay Reason
//					var ydCd=ComGetEtcData(sXml, "YD_CD");
	//				var ydCds = ComGetEtcData(sXml, "yd_cd_list").split("|");
	//				var ydNms = ComGetEtcData(sXml, "yd_nm_list").split("|");
//					formObj.yd_cd.value=ydCd;
					var vslArrDlayRsnCd=ComGetEtcData(sXml, "VSL_ARR_DLAY_RSN_CD").split("|");	//Delay Reason
					var vslBrthDlayRsnCd=ComGetEtcData(sXml, "VSL_BRTH_DLAY_RSN_CD").split("|");	//Delay Reason
					var vslDepDlayRsnCd=ComGetEtcData(sXml, "VSL_DEP_DLAY_RSN_CD").split("|");	//Delay Reason
	//				var pltUnldDlayCd = ComGetEtcData(sXml, "PLT_UNLD_DLAY_CD").split("|");	//Delay Reason
					formObj.vsl_arr_dlay_rsn_cd.value=vslArrDlayRsnCd;
					formObj.vsl_brth_dlay_rsn_cd.value=vslBrthDlayRsnCd;
					formObj.vsl_dep_dlay_rsn_cd.value=vslDepDlayRsnCd;
	//				formObj.plt_unld_dlay_cd.value = pltUnldDlayCd;
					setDlayRsnNms(vslArrDlayRsnCd, formObj.vsl_arr_dlay_rsn_nm);
					setDlayRsnNms(vslBrthDlayRsnCd, formObj.vsl_brth_dlay_rsn_nm);
					setDlayRsnNms(vslDepDlayRsnCd, formObj.vsl_dep_dlay_rsn_nm);
	//				setDlayRsnNms(pltUnldDlayCd, formObj.plt_unld_dlay_nm);
					formObj.diff_rmk.value=ComGetEtcData(sXml, "DIFF_RMK");
				}else{
					sheetObj.LoadSearchData(sXml,{Sync:1} );
	//				ComShowCodeMessage('VSK00043');
					clearAllFormData(formObj);
					formObj.vps_port_cd.focus();
					return;
				}
			}
		}
	}
	/*
	 * =====================================================================
	 * Tab Event
	 * =====================================================================
	 */
	/**
     * Event when clicking Tab
     * activating selected tab items
     */
	function tab1_OnChange(tabObj , nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="inline";
		objs[beforetab].style.display="none";
		//--------------- important --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
    function initControl() {
    	axon_event.addListenerForm('change', 'obj_change', form); 	
    	axon_event.addListenerForm('blur', 'obj_blur', form);
//    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
//    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form, 'diff_rmk');
//    	axon_event.addListenerForm('keydown', 'obj_keydown', form); 	
//    	axon_event.addListenerForm('focus', 'obj_focus', form);
	}
//	function obj_change(){
//		var eleObj=event.srcElement;
//		var formObj=document.form;
//		var sheetObj=sheetObjects[0];
//		try {
//			var srcName=ComGetEvent("name");
//	        switch(srcName) {	
//	            case "vps_port_cd":
//	            	if(eleObj.value.length < 6){
//		            	formObj.loc_cd.value=formObj.vps_port_cd.value;
//		            	clearAllFormData(formObj, "S");
//		            	var sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
//		            	if(!isCheckPortForm(sheetObj, formObj, sXml)){
//		            		formObj.vps_port_cd.value="";
//		            		formObj.vps_port_cd.focus();
//		            	}else{
//		            		formObj.vsl_cd.focus();
//		            	}
//	            	}
//	            	break;
//	            case "vsl_cd":
//	            	clearAllFormData(formObj, "S");
//	            	if(isCheckVslCd(sheetObj, formObj)){
//	            		formObj.skd_voy_no.focus();
//	            	}else{
//	            		formObj.vsl_cd.focus();
//	            		return false;
//	            	}
//	            	break;
//	            case "skd_voy_no":
//	            case "skd_dir_cd":
//	            case "clpt_ind_seq":
//	            	clearAllFormData(formObj, "S");
//	            	break;
////	            case "clpt_ind_seq":
////	            	clearAllFormData(formObj, "S");
////	            	break;
//	            case "act_arr_dt":
//	            case "act_brth_dt":
//	            case "act_dep_dt":
//	            	Usr_setDateTime(formObj, srcName);
//	            	setDelayTime(formObj);
//	            	setVslCondSts(formObj, "N");
//	            	break;
//	            case "plt_lst_unld_dt":
//	            case "bfr_brth_ank_drp_dt":
//	            case "bfr_brth_ank_off_dt":
//	            case "aft_unbrth_ank_drp_dt":
//	            case "aft_unbrth_ank_off_dt":
//	            	Usr_setDateTime(formObj, srcName);
//	            	break;
//	        } // end switch
//	        //[TAB] Checking Number Type of input Elements in Vessel Condition
//	        if(srcName){
//		        var inputObj=document.getElementsByName(srcName)[0];
//		        var parentObj=inputObj.parentNode;
//		        while(parentObj.parentNode){
//		        	parentObj=parentObj.parentNode;
//		        	if(parentObj.tagName.toLowerCase() == "table"){
//			        	if(parentObj.id == "tbl_vsl_cond"){
//			        		inputObj.value=ComAddComma(ComReplaceStr(inputObj, ",", ""));
//			        	}else{
//			        		break;
//			        	}
//		        	}
//		        }
//	        }
//		}catch(e) {
//			if( e == "[object Error]") {
//				ComShowCodeMessage('VSK00011');
//			} else {
//				ComShowMessage(e.message);
//			}
//		}
//	}

	function obj_focus(){
		var eleObj=event.srcElement;
		if(eleObj.name){
			focusObj=eleObj.name;
		}else{
			focusObj="";
		}
	}
	
    function obj_blur() {
		
		var srcName = ComGetEvent("name");
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		switch (srcName) {
		    case "vsl_cd":
		    	if(ComGetEvent("value").length == 4){
		    		doActionIBSheet(sheetObj, formObj, SEARCH03);
		    		formObj.skd_voy_no.focus();		    		
		    	}
				break;
		    case "skd_voy_no":
		    	if(ComGetEvent("value").length == 4) {
		    		doActionIBSheet(sheetObj, formObj, SEARCH03);
		    		formObj.skd_dir_cd.focus();
		    	}
				break;

		    case "skd_dir_cd":
		    	if(ComGetEvent("value").length == 1) {
		    		doActionIBSheet(sheetObj, formObj, SEARCH03);
		    		comboObjects[0].Focus();
		    	}
				break;
		}		
	}
	
	function obj_change(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		try {
			var srcName=ComGetEvent("name");
	        switch(srcName) {	
	            case "vps_port_cd":
	            	if(ComGetEvent("value").length < 5){
		            	formObj.loc_cd.value=formObj.vps_port_cd.value;
		            	clearAllFormData(formObj, "S");
		            	var sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
		            	if(!isCheckPortForm(sheetObj, formObj, sXml)){
		            		formObj.vps_port_cd.value="";
		            		formObj.vps_port_cd.focus();
		            	}else{
		            		formObj.vsl_cd.focus();
		            	}
	            	}
	            	break;
	            case "vsl_cd":
	            	clearAllFormData(formObj, "S");
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		formObj.skd_voy_no.focus();
	            	}else{
	            		formObj.vsl_cd.focus();
	            		return false;
	            	}
	            	break;
	            case "skd_voy_no":
	            case "skd_dir_cd":
	            case "clpt_ind_seq":
	            	clearAllFormData(formObj, "S");
	            	break;
//	            case "clpt_ind_seq":
//	            	clearAllFormData(formObj, "S");
//	            	break;
	            case "act_arr_dt":
	            case "act_brth_dt":
	            case "act_dep_dt":
//	            	Usr_setDateTime(formObj, srcName);
	            	setDelayTime(formObj);
	            	delayReasonControl(formObj, true);
	            	setVslCondSts(formObj, "N");
	            	break;
//	            case "plt_lst_unld_dt":
//	            case "bfr_brth_ank_drp_dt":
//	            case "bfr_brth_ank_off_dt":
//	            case "aft_unbrth_ank_drp_dt":
//	            case "aft_unbrth_ank_off_dt":
//	            	Usr_setDateTime(formObj, srcName);
	            	break;
	        } // end switch
	        //[TAB] Checking Number Type of input Elements in Vessel Condition
	        if(srcName){
		        var inputObj=document.getElementsByName(srcName)[0];
		        var parentObj=inputObj.parentNode;
		        while(parentObj.parentNode){
		        	parentObj=parentObj.parentNode;
		        	//if(parentObj.tagName.toLowerCase() == "table"){
			        	if(parentObj.id == "tbl_vsl_cond"){
			        		//+=======================================================
			        		var cCnt=0;
			        		for(var i=0; i<inputObj.value.length; i++) {
			            		if (".".charCodeAt() == inputObj.value.charCodeAt(i)) {
			            			
			            			cCnt++;
			            		}
			            	}
			        		if(cCnt > 1){
			        			inputObj.value="";
			        			return;
			        		}
			        		//+=======================================================
			        		inputObj.value=ComAddComma(ComReplaceStr(inputObj, ",", ""));
			        	}else{
			        		break;
			        	}
		        	
		        }
	        }
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
	function vps_port_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
	    formObj = document.form;

		var clptIndSeq = comboObj.GetText(parseInt(NewIndex), 2);	//comboObj.GetText(1, 2);
		formObj.clpt_ind_seq.value = clptIndSeq;
		formObj.loc_cd.value = NewCode;
	    
	    clearAllFormData(formObj, "S");
		comboObjects[0].SetSelectText(parseInt(NewIndex), 0);
	}
	/*
	 * =====================================================================
	 * Handling Pop Up Data
	 * =====================================================================
	 */
	/**
	 * Handling data from Port Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=null;
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vps_port_cd.value=rtnDatas;
					clearAllFormData(formObj, "S");
				}
			}
		}
	}
	/**
	 * Handling data from VSL Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_cd.value=rtnDatas[1];
					clearAllFormData(formObj, "S");
				}
			}
    	}
    }
    /**
     * Handling data from VVD Code Help (Pop-Up)
     * @param rtnObjs
     * @return
     */
	function returnVvdHelp(rtnObjs){
		var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.skd_voy_no.value=rtnDatas[2];
					formObj.skd_dir_cd.value=rtnDatas[3];
					clearAllFormData(formObj, "S");
					
					doActionIBSheet(sheet1, formObj, SEARCH03);
				}
			}
    	}
    }
	/*
	 * =====================================================================
	 * Form Control
	 * =====================================================================
	 */
	/**
	 * Showing DlayRsnNm with DlayRsnCd
	 * @param dlayCd
	 * @param inputObj
	 * @return
	 */
	function setDlayRsnNms(dlayCd, inputObj){
		var rsnCnt=glbDlayRsnNms.length;
		if(rsnCnt > 0){
			for(var i=0; i<rsnCnt; i++){
				if(dlayCd == glbDlayRsnCds[i]){
					document.getElementsByName(inputObj.name)[0].value=glbDlayRsnNms[i];
					break;
				}else{
					document.getElementsByName(inputObj.name)[0].value="";
				}
			}
		}
	}
	/**
	 * Combo Setting...
	 * 
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function setHtmlComboSinc(comboObj, optionCds, optionTxts, selCode){
		ComClearCombo(comboObj);
    	for(var i=0; i<optionCds.length; i++) {
			ComAddComboItem(comboObj, optionTxts[i], optionCds[i]);
//			comboObj.options[i].style.width = "200";
			if(comboObj.options[i].value == selCode){
				comboObj.options[i].selected=true;
			}
		}
	}
	/**
	 * Setting Value of formObj from xml
	 * @param sXml
	 * @return
	 */
	function setFormToEtcData(sXml){
		var rootNode=VskGetXmlRootNode(sXml);
		var dataNodes=rootNode.getElementsByTagName("ETC");
		if(dataNodes){
//			var dataNodes=rootNode.selectNodes("//ETC");
			var keyValue="";
			var inputName="";
			for(var i=0; i<dataNodes.length; i++){
//				keyValue=dataNodes[i].selectSingleNode("@KEY").nodeValue;
				keyValue=dataNodes[i].getAttribute("KEY");
				inputName=keyValue.toLowerCase();
				if(document.getElementsByName(inputName)[0]){
					var inputObj=document.getElementsByName(inputName)[0];
					if(inputObj.type == "text" || inputObj.type == "hidden"){
						inputObj.value=ComGetEtcData(sXml, keyValue);
					}
				}
			}
		}
	}
	/**
	 * Deleting Data of Form Object
	 * @param formObj
	 * @return
	 */
//	function clearAllFormData(formObj, flag){
//		var eleObjs=formObj.elements;
//		var len=eleObjs.length;
//		for(var i=0; i<len; i++){
//			if(flag != null && flag != undefined && flag != ""){
//				if(eleObjs[i].name == "vps_port_cd" 
//					|| eleObjs[i].name == "vsl_cd"
//					|| eleObjs[i].name == "skd_voy_no"
//					|| eleObjs[i].name == "skd_dir_cd"
//					|| eleObjs[i].name == "clpt_ind_seq"){
//					//pass
//				}else{
//					ComClearObject(eleObjs[i]);
//				}
//			}else{
//				ComClearObject(eleObjs[i]);
//			}
//		}
//	}
	/**
	 * Deleting Data of Form Object
	 * @param formObj
	 * @return
	 */
	function clearAllFormData(formObj, flag){
		var eleObjs=formObj.elements;
		var len=eleObjs.length;
		for(var i=0; i<len; i++){
			if(flag != null && flag != undefined && flag != ""){
				if(	   eleObjs[i].name == "vsl_cd"
					|| eleObjs[i].name == "skd_voy_no"
					|| eleObjs[i].name == "skd_dir_cd"
					|| eleObjs[i].name == "vps_port_cd_text") {
					//pass
				}else{
					ComClearObject(eleObjs[i]);
				}
			}else{
				ComClearObject(eleObjs[i]);
			}
		}
	}
	/**
	 * Setting Vessel Movement - Vessel Condition
	 * @param sXml
	 * @param formObj
	 * @return
	 */
	function setVslCondSts(formObj, flag){
		var portSkdStsCd="";
		if(flag != "N"){
			portSkdStsCd=formObj.port_skd_sts_cd.value;
		}
		if(portSkdStsCd != ""){
			for(var i=0; i<glbVslCondCds.length; i++){
				if(glbVslCondCds[i] == portSkdStsCd){
					formObj.port_skd_sts_nm.value=glbVslCondNms[i];
				}
			}
		}else{
			if (formObj.act_dep_dt.value != ""){
				for(var i=0; i<glbVslCondCds.length; i++){
					if(glbVslCondCds[i] == "D"){
						formObj.port_skd_sts_cd.value=glbVslCondCds[i];
						formObj.port_skd_sts_nm.value=glbVslCondNms[i];
					}
				}
			}else if(formObj.act_brth_dt.value != ""){
				for(var i=0; i<glbVslCondCds.length; i++){
					if(glbVslCondCds[i] == "B"){
						formObj.port_skd_sts_cd.value=glbVslCondCds[i];
						formObj.port_skd_sts_nm.value=glbVslCondNms[i];
					}
				}
			}else{
				for(var i=0; i<glbVslCondCds.length; i++){
					if(glbVslCondCds[i] == "A"){
						formObj.port_skd_sts_cd.value=glbVslCondCds[i];
						formObj.port_skd_sts_nm.value=glbVslCondNms[i];
					}
				}
			}
		}
	}
	/**
	 * Calling RD Viewer
	 * 
	 * @param formObj
	 * @return
	 */
	function callRDOpen(formObj, prtFlg){
		var rdParam=setQueryStr(formObj);
		if(VskIsNull(rdParam)){
			return;
		}else{
			if(prtFlg == "ARR"){
				formObj.com_mrdPath.value="apps/opus/vop/vsk/actualschedulemanagement/actualschedulemgt/report/VOP_VSK_0026_1.mrd";
			    formObj.com_mrdArguments.value=rdParam;
			    formObj.com_mrdBodyTitle.value="Vessel Arrival Report";
				formObj.com_mrdSaveDialogFileName.value="Vessel Arrival Report";
				ComOpenRDPopupModal();
			}else if(prtFlg == "DEP"){
				formObj.com_mrdPath.value="apps/opus/vop/vsk/actualschedulemanagement/actualschedulemgt/report/VOP_VSK_0026_2.mrd";
			    formObj.com_mrdArguments.value=rdParam;
			    formObj.com_mrdBodyTitle.value="Vessel Departure Report";
				formObj.com_mrdSaveDialogFileName.value="Vessel Departure Report";
				ComOpenRDPopupModal();
			}
		}
	}
	/**
	 * Setting Parameter for RD
	 * 
	 * @param formObj
	 * @return
	 */
	function setQueryStr(formObj){
		var qryStr="";
		if(VskIsNull(formObj.vsl_cd.value)
				|| VskIsNull(formObj.skd_voy_no.value)
				|| VskIsNull(formObj.skd_dir_cd.value)
				|| VskIsNull(formObj.loc_cd.value)
				|| VskIsNull(formObj.clpt_ind_seq.value)){
			qryStr="";
		}else{
			qryStr += "/rv vsl_cd[" + formObj.vsl_cd.value + "]";
			qryStr += " skd_voy_no[" + formObj.skd_voy_no.value + "]";
			qryStr += " skd_dir_cd[" + formObj.skd_dir_cd.value + "]";
			qryStr += " vps_port_cd[" + formObj.loc_cd.value + "]";
			qryStr += " clpt_ind_seq[" + formObj.clpt_ind_seq.value + "]";
			qryStr += " this_time[" + VskRdPrintDate() + "]";
		}
        return qryStr;
	}
	/**
     * Handling Screen as Port Code
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function isCheckPortForm(sheetObj, formObj, sXml){
    	var prefix=sheetObj.id + "_";
    	var chkPort=ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			ComShowCodeMessage("VSK00029", formObj.loc_cd.value);
			formObj.loc_cd.value="";
		}
		return false;
    }
    /**
     * Checking Vessel Code is exist in MDM_VSL_CNTR
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
		var sXml=doActionIBSheet(sheetObj, formObj, SEARCH10);
		var chkVslCd=ComGetEtcData(sXml, "vsl_chk");
		if(chkVslCd == "Y"){
    		return true;
    	}else{
    		sheetObj.LoadSearchData(sXml,{Sync:1} );
    		formObj.vsl_cd.value="";
    		return false;
    	}
	}
	/**
	 * Deleting Date separator
	 * @param sDate
	 * @return
	 */
	function Usr_replaceDateOrigin(sDate){
		var rDate=sDate;
		rDate=ComReplaceStr(rDate, "-", "");
		rDate=ComReplaceStr(rDate, ":", "");
		rDate=ComReplaceStr(rDate, " ", "");
		return rDate;
	}
    /**
     * Finding Delay Time and Setting it to input
     * @param formObj
     * @return
     */
    function setDelayTime(formObj){
    	var vpsEtaDt=Usr_replaceDateOrigin(formObj.vps_eta_dt.value);
    	var vpsEtbDt=Usr_replaceDateOrigin(formObj.vps_etb_dt.value);
    	var vpsEtdDt=Usr_replaceDateOrigin(formObj.vps_etd_dt.value);
    	var lstEtaDt=Usr_replaceDateOrigin(formObj.lst_eta_dt.value);
    	var lstEtbDt=Usr_replaceDateOrigin(formObj.lst_etb_dt.value);
    	var lstEtdDt=Usr_replaceDateOrigin(formObj.lst_etd_dt.value);
    	var actArrDt=Usr_replaceDateOrigin(formObj.act_arr_dt.value);
    	var actBrthDt=Usr_replaceDateOrigin(formObj.act_brth_dt.value);
    	var actDepDt=Usr_replaceDateOrigin(formObj.act_dep_dt.value);
    	var arrTimeDiff="";
    	var brthTimeDiff="";
    	var depTimeDiff="";
    	var sign="";
    	if(actArrDt != null && actArrDt != ""){
    		if(lstEtaDt != null && lstEtaDt != ""){
    			arrTimeDiff=setParsingDelayTime(lstEtaDt, actArrDt);
    		}else if(vpsEtaDt != null && vpsEtaDt != ""){
    			arrTimeDiff=setParsingDelayTime(vpsEtaDt, actArrDt);
    		}
    	}
    	if(actBrthDt != null && actBrthDt != ""){
    		if(lstEtbDt != null && lstEtbDt != ""){
    			brthTimeDiff=setParsingDelayTime(lstEtbDt, actBrthDt);
    		}else if(vpsEtbDt != null && vpsEtbDt != ""){
    			brthTimeDiff=setParsingDelayTime(vpsEtbDt, actBrthDt);
    		}
    	}
    	if(actDepDt != null && actDepDt != ""){
    		if(lstEtdDt != null && lstEtdDt != ""){
    			depTimeDiff=setParsingDelayTime(lstEtdDt, actDepDt);
    		}else if(vpsEtdDt != null && vpsEtdDt != ""){
    			depTimeDiff=setParsingDelayTime(vpsEtdDt, actDepDt);
    		}
    	}
    	formObj.dlay_arr_tm.value=arrTimeDiff;
    	formObj.dlay_brth_tm.value=brthTimeDiff;
    	formObj.dlay_dep_tm.value=depTimeDiff;
    }
	/**
	 * Taking over date String, and Converting it to year,month,day, then Returning
	 */
	function getDateObj(sDate) {
		sDate=sDate.replace(/\/|\-|\.|\:|\ /g,"");  //Removing Date, Time Separator and space
		var arr=new Array();
		for (var i=0; i <7; i++) {
			arr[i]=0;
		}
		var iLen=sDate.length;
		if (iLen>=4) arr[0]=sDate.substr(0,4);		//year
		if (iLen>=6) arr[1]=sDate.substr(4,2)-1;		//month
		if (iLen>=8) arr[2]=sDate.substr(6,2);		//day
		if (iLen>=10) arr[3]=sDate.substr(8,2);		//hours
		if (iLen>=12) arr[4]=sDate.substr(10,2);		//minutes
		if (iLen>=14) arr[5]=sDate.substr(12,2);		//seconds
		if (iLen<=17) arr[6]=sDate.substr(14);		//hour
		return new Date(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
	}
    /**
     * Converting Delay Time Format
     * @param fmDate
     * @param toDate
     * @return
     */
    function setParsingDelayTime(fmDate, toDate){
    	var fmDate1=getDateObj(fmDate);  
    	var toDate1=getDateObj(toDate);
    	var delayDay=(toDate1-fmDate1)/(1000*60*60);
		if(delayDay < 0){
			return "";
		}else{
			delayDay=delayDay.toFixed(1);
		}
		return delayDay;
    }
	/**
	 * Converting inputed date format
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function Usr_setDateTime(formObj, srcName){
		var inputObj=document.getElementsByName(srcName)[0];
		if(inputObj != null && inputObj != undefined){
			if(inputObj.value.length >= 10){
				var sDate=Usr_replaceDateOrigin(inputObj.value);
				sDate=ComGetMaskedValue(sDate, "ymdhm");
				if(ComIsDateTime(sDate, "", "hm")){
					inputObj.value=sDate;
				}
			}
		}
//		document.getElementsByName(srcName)[0].value = 
	}
