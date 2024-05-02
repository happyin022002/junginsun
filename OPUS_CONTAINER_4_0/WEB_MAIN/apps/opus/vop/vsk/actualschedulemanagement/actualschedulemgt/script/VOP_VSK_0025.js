/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName :  VOP_VSK_0025.jsp
*@FileTitle : Actual SKD Report Creation
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
     * @class vop_vsk_0025.jsp : business script for VOP_VSK_0025.jsp
     */
    function vop_vsk_0025() { 
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
	var glbDlayRsnTm  = 10;
	var glbAdvanceTm  = -10;
	var skdBuffTimeCode=0.5; // CD20071
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
 				case "btn_save":
 					doActionIBSheet(sheetObj, formObj, IBSAVE);
 					break;
 				case "btn_delete":
 					doActionIBSheet(sheetObj, formObj, IBDELETE);
 					break;
				case "btn_port":
					doActionIBSheet(sheetObj, formObj, COMMAND01);
					break;
				case "btn_vvd":
					doActionIBSheet(sheetObj, formObj, COMMAND02);
					break;
				case "btn_new":
					doActionIBSheet(sheetObj, formObj, IBCLEAR);
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
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_delete");
		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		delayReasonControl(document.form, false);
		if(document.form.pop_yn.value=="Y"){
			searchCstPopup(document.form);
		}else{
			document.form.vsl_cd.focus();
		}
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
			case 1:
			with(sheetObj){	        
		     
		      var HeadTitle1="|Sel|Seq";
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"}, ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 } ];
		       
		      InitColumns(cols);
		      SetVisible(false);
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
   	    	case "yd_cd":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);   					
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "70");
					SetColWidth(1, "340");
  					SetDropHeight(160);
   		    	}
   	    		break;
   	    	case "vsl_arr_dlay_rsn_cd":
   	    	case "vsl_brth_dlay_rsn_cd":
   	    	case "vsl_dep_dlay_rsn_cd":
//   	    	case "plt_unld_dlay_cd":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "40");
					SetColWidth(1, "300");
  					SetDropHeight(160);
//					ColBackColor(0) = "#CCFFFD";
//  					ColBackColor(1) = "#CCFFFD";
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
					var vParam="vsl_cd=" + formObj.vsl_cd.value
							   + "&skd_voy_no=" + formObj.skd_voy_no.value
							   + "&skd_dir_cd=" + formObj.skd_dir_cd.value
							   + "&vps_port_cd=" + comboObjects[0].GetSelectCode()
							   + "&clpt_ind_seq=" + comboObjects[0].GetText(Number(comboObjects[0].GetSelectIndex()), 2)
							   + "&loc_cd=" + formObj.loc_cd.value
					   		   + "&f_cmd=" + formObj.f_cmd.value;
//					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//					var sParam = vParam + "&" + ComGetPrefixParam("sheet1_");
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0025GS.do", vParam);
					ComOpenWait(false);
					showSheetData(sheetObj, formObj, sXml);
				}
				break;
//			case SEARCH01:		//Call Indicator
//				formObj.f_cmd.value=SEARCH01;
//				var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
// 				var sXml=sheetObj.GetSearchData("VOP_VSK_0025GS.do", sParam);
//				var callIndCds=ComGetEtcData(sXml, "call_ind_cd").split("|");		//call_ind_cd Code
//				var callIndNms=ComGetEtcData(sXml, "call_ind_nm").split("|");		//call_ind_nm Name
//				var ofcList=ComGetEtcData(sXml, "auth_ofc").split("|");		//auth_ofc
//				var isExistOfc=false;
//				for (var i=0; i < ofcList.length; i++){
//					if (ofcList[i] == gOfcCd){
//						isExistOfc=true;
//						break;
//					}
//				}
//				// control button
//				isExistOfc=true;
//				if (isExistOfc){
//					document.all.btn_delete.style.display="";
//				}else{
//					document.all.btn_delete.style.display="none";
//				}
//				setHtmlComboSinc(formObj.clpt_ind_seq, callIndCds, callIndNms, "");
//				break;
//			case SEARCH02:		//vps_port_cd
//				if(validateForm(sheetObj, formObj, sAction)){
//					formObj.f_cmd.value=SEARCH02;
//					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
// 					var sXml=sheetObj.GetSearchData("VOP_VSK_0025GS.do", sParam);
//					return sXml;
//				}
//				break;
			case SEARCH03:		//vps_port_cd
				
				formObj.f_cmd.value = SEARCH03;
				var sParam   = FormQueryString(formObj);
				var comboIdx = comboObjects[0].GetSelectIndex();
				var sXml     = sheetObj.GetSearchData("VOP_VSK_0025GS.do", sParam);
				var portList = ComGetEtcData(sXml, "port_list");
				
				if (portList.length > 0) {
					ComVskXml2ComboItem(sXml, comboObjects[0], "val", "name");
				} else {
					comboObjects[0].RemoveAll();
					comboObjects[0].SetDropHeight(100);
				}
				
				if(comboObjects[0].GetItemCount() > 0) {					
					comboObjects[0].SetSelectIndex(comboIdx, false);
					comboObjects[0].SetDropHeight(comboObjects[0].GetItemCount()*21);
					comboObjects[0].Focus();
				}
								
				break;
			case SEARCH10:		//VSL_CD Check
				if (validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value=SEARCH10;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0025GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH11:		//PORT TIME Check				
				formObj.f_cmd.value = COMMAND23;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
				
				return sXml;
				
				break;
			case IBSAVE:		//Save
				if(validateForm(sheetObj, formObj, sAction)){
//					if(ComShowCodeConfirm("VSK00038")){
					if(true){
						formObj.f_cmd.value=MULTI;
						setVslCondSts(formObj, "N");
						//======================================================
	//					var len = document.all.elements.length;
	//					for(i=0; i<len; i++){
	//						var inputObj = document.all.elements[i];
	//						if(inputObj.name.idexOf("wgt") > 0
	//								|| inputObj.name.idexOf("hgt") > 0
	//								|| inputObj.name.idexOf("knt") > 0){
	//				        	inputObj.value = ComAddComma(ComReplaceStr(inputObj, ",", ""));
	//						}
	//					}
						//======================================================
						var sParam=ComGetSaveString(sheetObjects, false);
						sParam += "&" + FormQueryString(formObj);
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
 						var sXml=sheetObj.GetSaveData("VOP_VSK_0025GS.do", sParam);
						ComOpenWait(false);
 						sheetObj.LoadSaveData(sXml);
						//var nodeText=VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
 						var nodeText =  ComGetSelectSingleNode(sXml, "TR-ALL")
						if(nodeText == "OK"){
							doActionIBSheet(sheetObj, formObj, SEARCH03);
							doActionIBSheet(sheetObj, formObj, IBSEARCH);
						}
					}
				}
				break;
			case IBDELETE:	// PUSCOV, Delete available
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=REMOVE;
					var sParam=ComGetSaveString(sheetObjects, false);
					    sParam += "&" + FormQueryString(formObj);
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
 					var sXml=sheetObj.GetSaveData("VOP_VSK_0025GS.do", sParam);
					ComOpenWait(false);
 					sheetObj.LoadSaveData(sXml);
//					var nodeText=VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
 					var nodeText =  ComGetSelectSingleNode(sXml, "TR-ALL")
					if(nodeText == "OK"){
						doActionIBSheet(sheetObj, formObj, SEARCH03);
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
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
            		sUrl="/opuscntr/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
            	}else{
            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
            	}
				break;
			case SEARCH04:		//FUTURE DATE 입력에 대한 VALIDATION
				formObj.f_cmd.value = SEARCH04;
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
				var sXml = sheetObj.GetSearchData("VOP_VSK_0025GS.do", sParam);
				
				return sXml;
				break;
			case IBCLEAR:        //NEW
				clearAllFormData(formObj);
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
			case IBSAVE:		//Save
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
				} else if(formObj.diff_rmk.value.length > 600){
					ComShowCodeMessage( "VSK01019", "[Remark(s)]" );
					formObj.diff_rmk.focus();
					return false;
				}
				// cannot return to Vessel Condition's former state
				var orgStsCd=formObj.org_port_skd_sts_cd.value;
				if(orgStsCd == "D"){
					if(formObj.act_dep_dt.value == ""){
						ComShowCodeMessage('VSK00027', "Departure Date");
						formObj.act_dep_dt.focus();
						return false;
					}
				}else if(orgStsCd == "B"){
					if(formObj.act_brth_dt.value == ""){
						ComShowCodeMessage('VSK00027', "Berth Date");
						formObj.act_brth_dt.focus();
						return false;
					}
				}else if(orgStsCd == "A"){
					if(formObj.act_arr_dt.value == ""){
						ComShowCodeMessage('VSK00027', "Arrival Date");
						formObj.act_arr_dt.focus();
						return false;
					}
				}
				//Actual SKD Date Check
				var preEtdDt=formObj.pre_etd_dt.value;
				var actArrDt=formObj.act_arr_dt.value;
				var actBrthDt=formObj.act_brth_dt.value;
				var actDepDt=formObj.act_dep_dt.value;
				var nxtEtaDt=formObj.nxt_eta_dt.value;
				var nxtActInpFlg=formObj.nxt_act_inp_flg.value;
				// ATA, ATB, ATD are all mandatory
				if(actArrDt == "" && actBrthDt == "" && actDepDt == ""){
					ComShowCodeMessage('VSK00027', "ATA, ATB, ATD");
					if(document.all.item("tabLayer")[1].style.display == "inline"){
						tabObjects[0].SetSelectedIndex(0);
					}
					formObj.act_arr_dt.focus();
					return false;
				}
		
				
				//::FOR.NYK.START::by dongsoo:2014-10-20:://
				/*
				// ATA < ETD of pre port, Blocking
				if(actArrDt != "" && preEtdDt != ""){
					if(!isValidDate(formObj, preEtdDt, actArrDt)){
						ComShowCodeMessage("VSK00055", actArrDt, preEtdDt);
						if(document.all.item("tabLayer")[1].style.display == "inline"){
							tabObjects[0].SetSelectedIndex(0);
						}
						formObj.act_arr_dt.focus();
						return false;
					}
				}
				//::FOR.NYK.END::by dongsoo:2014-10-20:://
				*/
				
				//ATA > Previous port ETD check.
				if(actArrDt != "" && preEtdDt != ""){
					if(!isPortTimeCheck(sheetObj, formObj)) {
						ComShowCodeMessage('VSK55002', preEtdDt);
						if(document.all.item("tabLayer")[1].style.display == "inline"){
							tabObjects[0].SelectedIndex = 0;
						}
						
						formObj.act_arr_dt.focus();
						return false;
					}
				}
				
				// ATA > ATB, Blocking
				if(actArrDt != "" && actBrthDt != ""){
					if(!isValidDate(formObj, actArrDt, actBrthDt)){ 
						//ComShowCodeMessage("VSK55011", actBrthDt, actArrDt);
						ComShowCodeMessage("VSK57101", "Arrival Date", "Berth Date");
						if(document.all.item("tabLayer")[1].style.display == "inline"){
							tabObjects[0].SetSelectedIndex(0);
						}
						formObj.act_brth_dt.focus();
						return false;
					}
				}else if(actBrthDt != ""){	// if ATB is inputed, ATA is not inputed, then Blocking
					//ComShowCodeMessage("VSK55011", actBrthDt, actArrDt);
					ComShowCodeMessage("VSK00027", "Arrival Date");
					if(document.all.item("tabLayer")[1].style.display == "inline"){
						tabObjects[0].SetSelectedIndex(0);
					}
					formObj.act_arr_dt.focus();
					return false;
				}
				// ATD < ATB, Blocking
				if(actBrthDt != "" && actDepDt != ""){
					if(!isValidDate(formObj, actBrthDt, actDepDt)){
						ComShowCodeMessage("VSK57101", "Berth Date", "Departure Date");
						if(document.all.item("tabLayer")[1].style.display == "inline"){
							tabObjects[0].SetSelectedIndex(0);
						}
						formObj.act_dep_dt.focus();
						return false;
					}
				}else if(actDepDt != ""){	// if ATD is inputed, ATB is not inputed, then Blocking
					//ComShowCodeMessage("VSK00057", actDepDt, actBrthDt);
					ComShowCodeMessage("VSK00027", "Berth Date");
					if(document.all.item("tabLayer")[1].style.display == "inline"){
						tabObjects[0].SetSelectedIndex(0);
					}
					formObj.act_brth_dt.focus();
					return false;
				}
				// ETA of next Port < ATD, Blocking
				if(actDepDt != "" && nxtEtaDt != ""){
					if(nxtActInpFlg == "Y"){
						if(!isValidDate(formObj, actDepDt, nxtEtaDt)){
							//ComShowCodeMessage("VSK55013", actDepDt, nxtEtaDt);
							ComShowCodeMessage('VSK55010', 'Actual Departure Date');
							if(document.all.item("tabLayer")[1].style.display == "inline"){
								tabObjects[0].SetSelectedIndex(0);
							}
							formObj.act_dep_dt.focus();
							return false;
						}
					}
				}
				
				// NEXT PORT ETA < ACTUAL DATE Checking  
				if(nxtEtaDt!=""){
				if(actArrDt>=nxtEtaDt||actBrthDt>=nxtEtaDt||actDepDt>=nxtEtaDt){
					//ComShowCodeMessage ('VSK55009');
				
					if(actArrDt>=nxtEtaDt){
					formObj.act_arr_dt.focus();	
					ComShowCodeMessage ('VSK55010' , 'Actual Arrival Date');
					}
					else if(actBrthDt>=nxtEtaDt){
					formObj.act_brth_dt.focus();
					ComShowCodeMessage ('VSK55010' , 'Acutal Berthing Date');
					}
					else if(actDepDt>=nxtEtaDt){
					formObj.act_dep_dt.focus();
					ComShowCodeMessage ('VSK55010', 'Actual Departure Date');
					}
//					else if(actArrDt>=nxtEtaDt && actBrthDt>=nxtEtaDt && actDepDt>=nxtEtaDt){
//					formObj.act_arr_dt.focus();
//					ComShowCodeMessage ('VSK55010', 'All');
//					}
							
					return false;
					}
				}
				
				
				if(formObj.plt_lst_unld_dt.value != ""){
					if(!ComIsDateTime(formObj.plt_lst_unld_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.plt_lst_unld_dt.focus();
						return false;
					}
				}
				if(formObj.bfr_brth_ank_drp_dt.value != ""){
					if(!ComIsDateTime(formObj.bfr_brth_ank_drp_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.bfr_brth_ank_drp_dt.focus();
						return false;
					}
				}
				if(formObj.bfr_brth_ank_off_dt.value != ""){
					if(!ComIsDateTime(formObj.bfr_brth_ank_off_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.bfr_brth_ank_off_dt.focus();
						return false;
					}
				}
				if(formObj.aft_unbrth_ank_drp_dt.value != ""){
					if(!ComIsDateTime(formObj.aft_unbrth_ank_drp_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.aft_unbrth_ank_drp_dt.focus();
						return false;
					}
				}
				if(formObj.aft_unbrth_ank_off_dt.value != ""){
					if(!ComIsDateTime(formObj.aft_unbrth_ank_off_dt.value, "", "hm")){
						ComShowCodeMessage('VSK00047');
						formObj.aft_unbrth_ank_off_dt.focus();
						return false;
					}
				}
				
				//::FOR.NYK.START::by dongsoo:2014-10-13:://
				var sXml = doActionIBSheet(sheetObj, formObj, SEARCH04);
				
				var chkCnt = ComGetEtcData(sXml, "iCnt");
				
				if(Number(chkCnt) > 0){
					ComShowCodeMessage('VSK55001', ComGetEtcData(sXml, "infoMsg"));
		    		return false;
		    	}
				//::FOR.NYK.FINISH::by dongso:2014-10-13:://
				
				//Delay Reason Check.
				//in case delay occur, change delay reason's state to mandatory item
				//when save button click, Showing message and focus in that column
				//::FOR.NYK.START::by dongsoo:2014-10-13:://
				var arrSeq  = ["0", "0", "0"];
				var infoMsg = "";
				
				//Delay Reason Check.
				//지연 시간 10시간 발생시 Delay Reason 컬럼을 필수항목으로 바탕색을 바꾸고, 
				//Save시 "Delay Reason 정보를 입력하세요"라는 메시지를 띄우고 해당 컬럼으로 Focus를 이동 시킨다.
				if(formObj.dlay_arr_tm.value != null && formObj.dlay_arr_tm.value != ""){
					if(Number(formObj.dlay_arr_tm.value) >= glbDlayRsnTm){
						if(getComboObject("vsl_arr_dlay_rsn_cd").GetSelectCode() == ""){							
							infoMsg = "Arrival";
							arrSeq[0]  = "1";		
						}
					}
				}
				if(formObj.dlay_brth_tm.value != null && formObj.dlay_brth_tm.value != ""){
					if(Number(formObj.dlay_brth_tm.value) >= glbDlayRsnTm){
						if(getComboObject("vsl_brth_dlay_rsn_cd").GetSelectCode() == ""){
							infoMsg   = (arrSeq[0] == "1") ? infoMsg + "/Berthing" : "Berthing";
							arrSeq[1] = "2";
						}
					}
				}
				if(formObj.dlay_dep_tm.value != null && formObj.dlay_dep_tm.value != ""){
					if(Number(formObj.dlay_dep_tm.value) >= glbDlayRsnTm){
						if(getComboObject("vsl_dep_dlay_rsn_cd").GetSelectCode() == ""){
							infoMsg = (arrSeq[0] == "1" || arrSeq[1] == "2") ? infoMsg + "/Departure" : "Departure";
							arrSeq[2] = "3";
						}
					}
				}
				
				if (arrSeq[0] == "1" || arrSeq[1] == "2" || arrSeq[2] == "3") {
					ComShowCodeMessage('VSK55003', infoMsg);
					
					if (arrSeq[0] == "1") {
						getComboObject("vsl_arr_dlay_rsn_cd").Focus();
					} else if (arrSeq[1] == "2") {
						getComboObject("vsl_brth_dlay_rsn_cd").Focus();
					} else if (arrSeq[2] == "3") {
						getComboObject("vsl_dep_dlay_rsn_cd").Focus();
					}
					
					return false;
				}
				//::FOR.NYK.FINISH::by dongso:2014-10-13:://
				
				//::FOR.NYK.START::by dongsoo:2014-10-06:://
				//::<advance> msg code 추가 
				//::실제 도착 날짜/시간 및 예상 도착 날짜/시간과 10 시간 이상 차이가 날경우 메시지 (VSK55004)
				//::TimeDiff 계산 기준 변경 (Last ETA Date)
				var estArrDt  = formObj.lst_eta_dt.value;
				var estBrthDt = formObj.lst_etb_dt.value;
				var estDepDt  = formObj.lst_etd_dt.value;
				
				var isBool  = false;
				
				infoMsg = "";
				
				if ((estArrDt.length > 0    && actArrDt.length  && 
					  isValidAdvanceDate(estArrDt, actArrDt)   <= glbAdvanceTm)) {
					infoMsg = "Arrival";
					isBool  = true;
				}

				if ((estBrthDt.length > 0 && actBrthDt.length && 
					  isValidAdvanceDate(estBrthDt, actBrthDt) <= glbAdvanceTm)) {
					infoMsg = (isBool) ? infoMsg + "/Berthing" : "Berthing";
					isBool  = true;
				}

				if ((estDepDt.length > 0  && actDepDt.length  && 
					  isValidAdvanceDate(estDepDt, actDepDt)   <= glbAdvanceTm)) {
					infoMsg = (isBool) ? infoMsg + "/Departure" : "Departure";
					isBool  = true;
				}
				
				if (isBool) {
					ComShowCodeMessage('VSK55004', infoMsg);
									
				}
				//::FOR.NYK.FINISH::by dongso:2014-10-06:://
				break;
				break;
				case IBDELETE:		//Delete
				if(!ComShowCodeConfirm("VSK00005")){
					return false;
				}
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
				formObj.diff_rmk.value = VopAsciiRemove(formObj.diff_rmk.value);
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
	/**
	 * xmlDoc.getElementsByTagName("");
	 * var totValue =  ComGetSelectSingleNode(sXml, "TOTAL")
	 */
	
	function showSheetData(sheetObj, formObj, sXml){
		var prefix=sheetObj.id + "_";
		if(sXml != null){
			//var rootNode=VskGetXmlRootNode(sXml);
//			var errNode=rootNode.selectNodes("//ERROR");
			var errNode=sXml.search("ERROR");
			if(errNode > 0){
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				clearAllFormData(formObj);
				formObj.vps_port_cd.focus();
				return;
			}else{
//				var dataNode=rootNode.selectNodes("//ETC");
				var dataNode=sXml.search("ETC");
				
				if(dataNode > 0){
					// Close Check !
					var skdStsCd=ComGetEtcData(sXml, "SKD_STS_CD");
					var portSkdStsCd=ComGetEtcData(sXml, "PORT_SKD_STS_CD");
					if(skdStsCd == "CLO"){
						ComShowCodeMessage("VSK00100");
						// Handling Save Button Disable
						ComBtnDisable("btn_save");
						ComBtnDisable("btn_delete");
					}else{
						ComBtnEnable("btn_save");
						if (VskIsNull(portSkdStsCd)) {
							// Handling Delete Button Disable
							ComBtnDisable("btn_delete");
						}else{
							ComBtnEnable("btn_delete");
						}
					}
					setFormToEtcData(sXml);
					setDelayTime(formObj);
					delayReasonControl(formObj, false);
					glbVslCondCds=ComGetEtcData(sXml, "vsl_cond_cd").split("|");
					glbVslCondNms=ComGetEtcData(sXml, "vsl_cond_nm").split("|");
					setVslCondSts(formObj);
					formObj.org_port_skd_sts_cd.value=formObj.port_skd_sts_cd.value;
					glbDlayRsnCds=("|"+ComGetEtcData(sXml, "dlay_rsn_cd")).split("|");	//Delay Reason
					glbDlayRsnNms=("|"+ComGetEtcData(sXml, "dlay_rsn_nm")).split("|");	//Delay Reason
					//alert(sXml);
					var ydCd_val=ComGetEtcData(sXml, "YD_CD");
					var ydCds=ComGetEtcData(sXml, "yd_cd_list").split("|");
					var ydNms=ComGetEtcData(sXml, "yd_nm_list").split("|");
					//alert( ydCd_val );
					//appendMultiComboItem(getComboObject("yd_cd"), ydCds, ydNms, ydCd_val);
					var vslArrDlayRsnCd=ComGetEtcData(sXml, "VSL_ARR_DLAY_RSN_CD").split("|");	//Delay Reason
					var vslBrthDlayRsnCd=ComGetEtcData(sXml, "VSL_BRTH_DLAY_RSN_CD").split("|");	//Delay Reason
					var vslDepDlayRsnCd=ComGetEtcData(sXml, "VSL_DEP_DLAY_RSN_CD").split("|");	//Delay Reason
	//				var pltUnldDlayCd = ComGetEtcData(sXml, "PLT_UNLD_DLAY_CD").split("|");	//Delay Reason
					for(var i=0; i<comboObjects.length; i++){
						if(comboObjects[i].options.id== "vsl_arr_dlay_rsn_cd"){
							appendMultiComboItem(comboObjects[i], glbDlayRsnCds, glbDlayRsnNms, vslArrDlayRsnCd);
							setSelectMultiText(comboObjects[i], formObj.vsl_arr_dlay_rsn_nm);
						}else if(comboObjects[i].options.id== "vsl_brth_dlay_rsn_cd"){
							appendMultiComboItem(comboObjects[i], glbDlayRsnCds, glbDlayRsnNms, vslBrthDlayRsnCd);
							setSelectMultiText(comboObjects[i], formObj.vsl_brth_dlay_rsn_nm);
						}else if(comboObjects[i].options.id== "vsl_dep_dlay_rsn_cd"){
							appendMultiComboItem(comboObjects[i], glbDlayRsnCds, glbDlayRsnNms, vslDepDlayRsnCd);
							setSelectMultiText(comboObjects[i], formObj.vsl_dep_dlay_rsn_nm);
						}
	//					else if(comboObjects[i].id == "plt_unld_dlay_cd"){
	//						appendMultiComboItem(comboObjects[i], glbDlayRsnCds, glbDlayRsnNms, pltUnldDlayCd);
	//						setSelectMultiText(comboObjects[i], formObj.plt_unld_dlay_nm);
	//					}
					}
					formObj.diff_rmk.value=ComGetEtcData(sXml, "DIFF_RMK");
					controlDelete();
					
				}else{
					sheetObj.LoadSearchData(sXml,{Sync:0} );
	//				ComShowCodeMessage('VSK00043');
					clearAllFormData(formObj);
					formObj.vps_port_cd.focus();
					return;
				}
			}
		}else{
			sheetObj.LoadSearchData(sXml,{Sync:0} );
			clearAllFormData(formObj);
			formObj.vps_port_cd.focus();
			return;
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
	 * Combo Event
	 * =====================================================================
	 */
	function vsl_arr_dlay_rsn_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		setSelectMultiText(comboObj, vsl_arr_dlay_rsn_nm);
	}
	function vsl_brth_dlay_rsn_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		setSelectMultiText(comboObj,vsl_brth_dlay_rsn_nm);
	}
	function vsl_dep_dlay_rsn_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text) {
		var formObj=document.form;
		setSelectMultiText(comboObj, vsl_dep_dlay_rsn_nm);
	}
//	function plt_unld_dlay_cd_OnChange(comboObj, Index_Code, Text) {
//		var formObj = document.form;
//		setSelectMultiText(comboObj, formObj.plt_unld_dlay_nm);
//	}
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
    function initControl() {
    	axon_event.addListenerForm('change', 'obj_change', form); 
    	//axon_event.addListenerForm('keyup' , 'obj_keyup' , form);
    	//axon_event.addListenerForm('activate', "obj_activate", form);
    	axon_event.addListenerForm('blur', 'obj_blur', form);

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
	
	function vps_port_cd_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
		
	    formObj = document.form;
		clearAllFormData(formObj, "S");		
		comboObjects[0].SetSelectText(NewText, 0);
	}
	
	/*
	 * =====================================================================
	 * Pop Up Data
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
	 * Adding item to Mutil Combo
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
		comboObj.RemoveAll();
    	for(var i=0; i<optionCds.length; i++) {
			comboObj.InsertItem(i, optionCds[i]+"|"+optionTxts[i], optionCds[i]);
		}
    	
    	if(Array.isArray(selCode) == true) {
    		comboObj.SetSelectCode(selCode[0],false);
    	}else{
    		comboObj.SetSelectCode(selCode,false);
    	}
	}
	/**
	 * Showing selected desc of Multi Combo
	 * @param comboObj
	 * @param inputObj
	 * @return
	 */
	function setSelectMultiText(comboObj, inputObj){
		var idx=comboObj.GetSelectIndex();
    	if(idx != null && idx != undefined){
    		if(glbDlayRsnNms[idx] != null && glbDlayRsnNms[idx] != undefined){
    			document.getElementsByName(inputObj.name)[0].value=glbDlayRsnNms[idx];
    		}else{
    			document.getElementsByName(inputObj.name)[0].value="";
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
	 * Calling from Delay Reason Combo change Event
	 * @param comboObj
	 * @param inputObj
	 * @return
	 */
	function setSelectedText(comboObj, inputObj){
		var idx=document.getElementsByName(comboObj.name)[0].options.selectedIndex;
    	if(idx != null && idx != undefined){
    		document.getElementsByName(inputObj.name)[0].value=glbDlayRsnNms[idx];
    	}
	}
	/**
	 * Setting Value of formObj from xml
	 * @param sXml
	 * @return
	 */
	/**
	 * xmlDoc.getElementsByTagName("");
	 * var totValue =  ComGetSelectSingleNode(sXml, "TOTAL")
	 */
	
	function setFormToEtcData(sXml){
		var rootNode=VskGetXmlRootNode(sXml);
		//var dataNodes=rootNode.selectNodes("//ETC");
//		var dataNodes=sXml.search("ETC");
		
		var dataNodes=rootNode.getElementsByTagName("ETC");

		if(dataNodes.length > 0){
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
		//remark remove
		formObj.diff_rmk.value="";
		//Yard Code Combo Remove...
//		ComClearCombo(formObj.yd_cd);
		//Delay Reason Combo Remove...
		for(var i=0; i<comboObjects.length; i++){
			if(flag == "S") i++;
			comboObjects[i].RemoveAll();
		}
		//Delay Reason Editable Setting.
		delayReasonControl(formObj, false);
		if(flag != "S"){
			comboObjects[0].Focus();
		}
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_delete");
	}
	/**
	 * Setting Vessel Movement - Vessel Condition
	 * 
	 * @param sXml
	 * @param formObj
	 * @return
	 */
	function setVslCondSts(formObj, flag){
		if(glbVslCondCds == null || glbVslCondCds.length < 1) return;
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
     * Returning combo Object with combo id
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt=comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].options.id== comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	return null;
    }
	/**
	 * Comparing Dates
	 * @param formObj
	 * @param fmDate
	 * @param toDate
	 * @return
	 */
	function isValidDate(formObj, fmDate, toDate){
		if(ComIsDateTime(fmDate, "", "hm") && ComIsDateTime(toDate, "", "hm")){
			if(Usr_replaceDateOrigin(fmDate) < Usr_replaceDateOrigin(toDate)){
				return true;
			}
		}
		return false;
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
	 * -10시간을 체크 하기 위한 function 
	 * @param formObj
	 * @param fmDate
	 * @param toDate
	 * @return
	 */
	function isValidAdvanceDate(fmDate, toDate){
		fmDate = Usr_replaceDateOrigin(fmDate);
		toDate = Usr_replaceDateOrigin(toDate);
		return getTimesBetween(ComGetMaskedValue(fmDate.substring(0,8), "ymd")+ComGetMaskedValue(fmDate.substring(8), "hm"), ComGetMaskedValue(toDate.substring(0,8), "ymd")+ComGetMaskedValue(toDate.substring(8), "hm"));		
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
    		sheetObj.LoadSearchData(sXml,{Sync:0} );
    		formObj.vsl_cd.value="";
    		formObj.vsl_cd.focus();
    		return false;
    	}
	}
    /**
     * Setting Delay Reason State
     * 
     * @param formObj
     * @return
     */
    function delayReasonControl(formObj, isFocusFlg){
    	if(Number(formObj.dlay_arr_tm.value) < glbDlayRsnTm){
    		getComboObject("vsl_arr_dlay_rsn_cd").SetSelectCode("");
    		formObj.vsl_arr_dlay_rsn_nm.value="";
    		getComboObject("vsl_arr_dlay_rsn_cd").SetEnable(0);
    	}else{
    		getComboObject("vsl_arr_dlay_rsn_cd").SetEnable(1);
    		if(isFocusFlg){
    			getComboObject("vsl_arr_dlay_rsn_cd").Focus();
    		}
    	}
    	if(Number(formObj.dlay_brth_tm.value) < glbDlayRsnTm){
    		getComboObject("vsl_brth_dlay_rsn_cd").SetSelectCode("");
    		formObj.vsl_brth_dlay_rsn_nm.value="";
    		getComboObject("vsl_brth_dlay_rsn_cd").SetEnable(0);
    	}else{
    		getComboObject("vsl_brth_dlay_rsn_cd").SetEnable(1);
    		if(isFocusFlg){
    			getComboObject("vsl_brth_dlay_rsn_cd").Focus();
    		}
    	}
    	if(Number(formObj.dlay_dep_tm.value) < glbDlayRsnTm){
    		getComboObject("vsl_dep_dlay_rsn_cd").SetSelectCode("");
    		formObj.vsl_dep_dlay_rsn_nm.value="";
    		getComboObject("vsl_dep_dlay_rsn_cd").SetEnable(0);
    	}else{
    		getComboObject("vsl_dep_dlay_rsn_cd").SetEnable(1);
    		if(isFocusFlg){
    			getComboObject("vsl_dep_dlay_rsn_cd").Focus();
    		}
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
     * Delay Time을 정해진 Format 으로 변환.
     * @param fmDate
     * @param toDate
     * @return
     */
    function setParsingDelayTime(fmDate, toDate){
    	var timeDiff = "";
    	var sign = "";
    	
    	var timeDiff = getTimesBetween(ComGetMaskedValue(fmDate.substring(0,8), "ymd")+ComGetMaskedValue(fmDate.substring(8), "hm"), ComGetMaskedValue(toDate.substring(0,8), "ymd")+ComGetMaskedValue(toDate.substring(8), "hm"));
		
		if(Number(timeDiff) < 0){
			timeDiff = "";
		} else{
			timeDiff = parseFloat(timeDiff.toFixed(1));
		}
		
		return timeDiff;
    }
    
    /**
     * 두 날짜 사이의 시간을 반환한다. 시간은 sToDate - sFromDate로 계산되며, 둘중 하나라도 날짜포멧이 아닌 경우 결과는 "NaN"으로 리턴된다. <br>
     * @param {string,object} sFromDate   필수,시작일자 문자열 또는 HTML태그(Object)
     * @param {string,object} sToDate     필수,종료일자 문자열 또는 HTML태그(Object)
     * @returns number,두 날짜 사이의 시간<br>
     * NaN : 두 인자 중 날짜가 아닌것이 하나라도 있어서 연산이 불가능한 경우
     */
    function getTimesBetween(sFromDate, sToDate) {
        try {
            var iFromTime = getTimeObj(sFromDate);
            var iToTime   = getTimeObj(sToDate);
            var val = iToTime - iFromTime;
    		return (iToTime - iFromTime) / (60*60*1000) ;
    		
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * 날짜 문자열을 인자로 받아서 new Date()로 년월일시분을 설정하여 반환한다. 인자가 날짜형태가 아니면 null을 반환한다. <br>
     * @param {string,object} sDate   필수,년월일시분 문자열 또는 HTML태그(Object)
     * @return date
     */
    function getTimeObj(sDate) {
        try {
	        sDate = sDate.replace(/\/|\-|\.|\:|\ /g,"");  //날짜구분자,시간구분자,스페이스 없애기
	        
		    var arr = ComNumberArray(7);
	        var iLen = sDate.length;
	        
	        if (iLen>=4) arr[0]  = sDate.substr(0,4);		//year
	    	if (iLen>=6) arr[1]  = sDate.substr(4,2)-1;		//month
	    	if (iLen>=8) arr[2]  = sDate.substr(6,2);		//day
	    	
	        if (iLen>=10) arr[3] = sDate.substr(8,2);		//hours
	        if (iLen>=12) arr[4] = sDate.substr(10,2);		//minutes
	        if (iLen>=14) arr[5] = sDate.substr(12,2);		//seconds
	        if (iLen<=17) arr[6] = sDate.substr(14);		//hour
	        
	        return new Date(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
	        
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * Converting Delay Time Format
     * @param fmDate
     * @param toDate
     * @return
     */
    /*
    function setParsingDelayTime(fmDate, toDate){
    	var timeDiff="";
    	var sign="";
    	var day=ComGetDaysBetween(ComGetMaskedValue(fmDate.substring(0,8), "ymd"), ComGetMaskedValue(toDate.substring(0,8), "ymd"));
		var time=getTimeDiff(fmDate.substring(8), toDate.substring(8));
		if(day >= 0){
			if(time >= 0){
			}else{
				if(day > 0){
					day=Number(day) - 1;
					time=10 + Number(time);
				}
				else{
					time=time * (-1);
					sign="-";
				}
			}
		}else{
			if(time > 0){
				day=Number(day) + 1;
				time=10 - Number(time);
				sign="-";
			}else{
				if(time < 0) time=time * (-1);
			}
		}
		timeDiff=sign + day + "." + time;
		if(Number(timeDiff) < 0){
			timeDiff="";
		}
		return timeDiff;
    }
    */
    /**
     * Calculating Time Difference
     * @param fmTime
     * @param toTime
     * @return
     */
    function getTimeDiff(fmTime, toTime){
		var rtnTime="";
    	var convertTime=10 * 24;
//    	if(toTime > fmTime){
    		rtnTime=Math.round((toTime - fmTime) / convertTime);
//    	}else{
//    		rtnTime = Math.round((fmTime - toTime) / convertTime);
//    	}
		return rtnTime;
	}
	/**
	 * Converting inputed date format
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function Usr_setDateTime(formObj, srcName){
		var inputObj=document.getElementsByName(srcName)[0];
		ComAddSeparator(inputObj);
//		if(inputObj != null && inputObj != undefined){
//			if(inputObj.value.length >= 10){
//				var sDate = Usr_replaceDateOrigin(inputObj.value);
//				sDate = ComGetMaskedValue(sDate, "ymdhm");
//				if(ComIsDateTime(sDate, "", "hm")){
//					inputObj.value = sDate;
//				}else{
//					inputObj.value = "";
//				}
//			}else{
//				inputObj.value = "";
//			}
//		}
	}
	
	/**
     * PORT TIME CHECK
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isPortTimeCheck(sheetObj, formObj) {
    		
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH11);
		
		var actStatus = ComGetEtcData(sXml, "actStatus");
		
		if(actStatus == "NORMAL"){
    		return true;
    	}else{    		
    		return false;
    	}
	}
    
    function searchCstPopup(formObj){
		formObj.vsl_cd.value     = formObj.cst_vsl_cd.value;
		formObj.skd_voy_no.value = formObj.cst_skd_voy_no.value;
		formObj.skd_dir_cd.value = formObj.cst_skd_dir_cd.value;

		doActionIBSheet(sheetObjects[0], formObj, SEARCH03);//port 조회
		for(var i=0; i<formObj.vps_port_cd.GetCount(); i++){
			if(formObj.vps_port_cd.GetIndexText(i,1) == formObj.cst_yd_cd.value && formObj.vps_port_cd.GetIndexText(i,2)==formObj.cst_clpt_ind_seq.value) {
				formObj.vps_port_cd.Index = i;
				break;
			}
		}
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);//actual skd 조회
		formObj.vps_port_cd.Enable  = false;
		formObj.vsl_cd.readOnly     = true;
		formObj.skd_voy_no.readOnly = true;
		formObj.skd_dir_cd.readOnly = true;
		formObj.vsl_cd.className    = "input2";
		formObj.skd_voy_no.className= "input2";
		formObj.skd_dir_cd.className= "input2";
	}
    
    function controlDelete(){
		var formObj = document.form;
		var aryAuth = formObj.usr_auth.value.split("|");
		var isOk = false;
		for(var i=0; i<aryAuth.length; i++){
			if(aryAuth[i]=="VSK01" || aryAuth[i]=="VSK02" || formObj.cre_usr_id.value==formObj.usr_id.value){
				isOk = true;
			}
		}
		if(isOk){
			document.all.btn_delete.style.display="";
			ComBtnEnable("btn_delete");
		}else{
			ComBtnDisable("btn_delete");
		}
		
		if(formObj.act_arr_dt.value=="" && formObj.act_brth_dt.value=="" && formObj.act_dep_dt.value==""){
			document.all.btn_delete.style.display="none";
			ComBtnDisable("btn_delete");
		}
	}
	
