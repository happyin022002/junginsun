/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : CPS_CNI_0003.js
*@FileTitle  : Claim Main 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab1=1;
var beforetab2=1;
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
// HTML Form
var frm=null;
var frm2=null;
// Claim Area Code
var clmAreaCd="";
var MainCode=""; 
var openTabIndex=0; 
var temp1="";
function loadPage() {
	frm=document.form;
	frm2=document.form2;
	//IBTab initializing
	tabCnt=tabObjects.length;
	for (var k=0; k < tabCnt; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	//IBMultiComboinitializing
	comboCnt=comboObjects.length;
	for (var j=0; j<comboCnt; j++) {
		initCombo(comboObjects[j],j+1);
	}
	//IBSheet initializing
	sheet1=sheetObjects[0];
	sheetCnt=sheetObjects.length;
	sheet1.SetWaitImageVisible(0);
	for ( var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComSetFocus(frm.cgo_clm_ref_bl_no);
	//registering initial event 
	
	//MultiComboBox value initializing
	initComboBoxValue();
	setRoleButton();
	initControl();
	ComBtnDisable("btn1_Cancel");
	var claim_no=ComGetObjValue(frm.cgo_clm_no);
	if (claim_no != "") {
		doActionIBSheet(SEARCH);
	}
}
 /**
  * setting Tab
  **/
function initTab(tabObj, tabNo) {
	  switch (tabNo) {
	 	case 1:
	 		with (tabObj) {
	 			var cnt=0;
				InsertItem( "Page1", "");
				InsertItem( "Page2", "");
				InsertItem( "Litigation", "");
	 		}
	 		break;
	 	case 2:
	 		with (tabObj) {
	 			var cnt=0;
				InsertItem( "Cause of Claim", "");
				InsertItem( "Fact Finding", "");
				InsertItem( "Main Issue Review & DV", "");
				InsertItem( "Claimant's Agent", "");
				InsertItem( "Insurer's Agent", "");
				InsertItem( "Case Summary & DV", "");
	 		}
	 		break;
 	   }
}
/*
 * registering IBSheet Object as list
 * @param sheetObj IBSheet Object  
 */
function setSheetObject(sheetObj){
	sheetObjects[sheetCnt++]=sheetObj;
}
/*
 * registering IBTab Object as list 
 * @param tabObj
 */
function setTabObject(tabObj) {
 	tabObjects[tabCnt++]=tabObj;
}
/*
 * registering IBCombo Object as list
 * @param comboObj
 */
function setComboObject(comboObj){
	comboObjects[comboCnt++]=comboObj;
}
/*
 * Occurs when a cell of tab1 range is clicked with a mouse
 * @param IBTabs tabObj
 * @param int nItem
 */
function tab1_OnClick(tabObj, nItem) {
 	if (nItem == 0) {
 		tabObjects[1].SetSelectedIndex(0);
 	}
 	if (nItem == 2) {
 		tabObjects[1].SetSelectedIndex(5);
 	}
}
/*
 * Occurs when a cell of tab2 range is clicked with a mouse
 * @param IBTabs tabObj
 * @param int nItem 
 */
function tab2_OnClick(tabObj, nItem) {
 	if (nItem == 0) {
 		tabObjects[0].SetSelectedIndex(0);
 	}
 	if (nItem == 5) {
 		tabObjects[0].SetSelectedIndex(2);
 	}
 	if (openTabIndex == nItem) {
		var pop_param='';
		if (nItem == 0) {
			pop_param="pop_title=Cause of Claim&pop_desc=&pop_cont_col=clm_cuz_desc";
		} else if (nItem == 1) {
			pop_param="pop_title=Fact Finding _ Assessment&pop_desc=&pop_cont_col=fact_fnd_desc";
		} else if (nItem == 2) {
			pop_param="pop_title=Main Issue Review_DV&pop_desc=&pop_cont_col=clm_rvw_desc";
		} else if (nItem == 5) {
			pop_param="pop_title=Case Summary _ DV&pop_desc=&pop_cont_col=ltgt_cs_desc";
		}
		if (nItem == 0 || nItem == 1 || nItem == 2 || nItem == 5) {
			ComPostOpenWindow("/opuscntr/CPS_CNI_0040.do?pop_flag=TAB&" + pop_param, 'CPS_CNI_0040', 'width=1000,height=587');
		}	
	} else {
		openTabIndex=nItem;
	}
}
/*
 * Occurs when the Tabq of a cell is changed
 * @param IBTabs tabObj
 * @param int nItem 
 */
function tab1_OnChange(tabObj, nItem) {
 	var objs=document.all.item("tabLayer1");
 	objs[nItem].style.display="Inline";
 	objs[beforetab1].style.display="none";
 	objs[beforetab1].style.zIndex=objs[nItem].style.zIndex - 1;
 	beforetab1=nItem;
}
 /*
  * Occurs when the Tabw of a cell is changed
  * @param IBTabs tabObj
  * @param int nItem 
  */
function tab2_OnChange(tabObj, nItem) {
 	var objs=document.all.item("tabLayer2");
 	objs[nItem].style.display="Inline";
 	objs[beforetab2].style.display="none";
 	objs[beforetab2].style.zIndex=objs[nItem].style.zIndex - 1;
 	beforetab2=nItem;
}
// Event handler processing by button click event 
document.onclick=processButtonClick;
function processButtonClick() {
	// Cargo Claim No.
	var claim_no=ComGetObjValue(frm.cgo_clm_no);
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn1_Retrieve": 
			if (claim_no == "") {
				ComShowCodeMessage("CNI00003", "Claim No.");
				ComSetFocus(frm.cgo_clm_no);
				return ;	
			}
			doActionIBSheet(SEARCH);
			break;
		case "btn1_New":
			if (ComShowCodeConfirm("CNI00015") ) { // "CNI00015=Do you want to initialize?"
				var sXml=frm2.sXml.value;
				ComResetAll();
				resetHiddenField(frm);
				ComSetObjValue(frm.cgo_clm_no, "");
				tabObjects[0].SetSelectedIndex(0);
				tabObjects[1].SetSelectedIndex(0);
				
				ComSetObjValue(frm2.sXml, sXml);
				
				initComboBoxValue("1");
				ComSetFocus(frm.cgo_clm_ref_bl_no);
				ComBtnEnable("btn1_Save");
				setRoleButton();
				ComBtnDisable("btn1_Cancel")
				frm.fmal_clm_rcv_ofc_cd.readOnly=true;
				frm.fmal_clm_rcv_ofc_cd.className="input2";
				frm.fmal_clm_rcv_ofc_cd.removeAttribute("required");
				frm.fmal_clm_rcv_dt.readOnly=true;
				frm.fmal_clm_rcv_dt.className="input2";
				frm.fmal_clm_rcv_dt.removeAttribute("required");
				inci_plc_tp_cd.SetEnable(1);
				frm.inci_occr_dt.readOnly=false;
				frm.inci_occr_dt.className="input";	
				
			}
			break;
		case "btn1_Save": 
			doActionIBSheet(MULTI);
			break;
		case "btn1_Cancel": 
			doActionIBSheet(MULTI01);
			break;
		case "btn1_Payment": 
			popupPayment(claim_no);
			break;	
		case "btn1_Handling_Costs": 
			popupHandlingCost(claim_no);
			break;
		case "btn1_Close":
			ComClosePopup(); 
			break;
		case "btns_hanlder_history":
			popupHandlerHistory(claim_no);
			break;
		case "btns_vvd":
			var trnk_ref_vvd_no=ComGetObjValue(frm.trnk_ref_vvd_no);
			popupVvdSkd(trnk_ref_vvd_no);
			break;		
		case "btns_clm_tm_bar_dt":
		case "btns_smns_sve_dt":
		case "btns_prlm_clm_ntc_dt":
		case "btns_cgo_clm_acknak_dt":
		case "btns_fact_fnd_dt":
		case "btns_deft_atty_apnt_dt":
		case "btns_cpln_file_dt":
		case "btns_jmt_rslt_dt":
		case "btns_inci_occr_dt":
		case "btns_svey_inp_dt":
		case "btns_de_dt":
		case "btns_lodg_dt":
		case "btns_clmt_agn_apnt_dt":
		case "btns_agn_crspn_apnt_dt":
		case "btns_fmal_clm_rcv_dt":	
			var result=srcName.replace("btns_", "");
		    var vCalObj=eval("frm." + result );
			var vCal=new ComCalendar();
			vCal.setDisplayType('date');
			vCal.select(vCalObj, 'yyyy-MM-dd');
            break;
		case "btn1_Style":
			var clmt_clm_pty_no=ComGetObjValue(frm.clmt_clm_pty_no);
			if (clmt_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Claimant");
				frm.clmt_clm_pty_abbr_nm.focus();
				return ;	
			}
			popupMainCodeView(clmt_clm_pty_no);
			break;
		case "btn3_Style":
			var deft_atty_clm_pty_no=ComGetObjValue(frm.deft_atty_clm_pty_no);
			if (deft_atty_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Def. Attorney");
				frm.deft_atty_clm_pty_abbr_nm.focus();
				return ;	
			}
			popupMainCodeView(deft_atty_clm_pty_no);
			break;
		case "btn4_Style":
			var clm_agn_clm_pty_no=ComGetObjValue(frm.clm_agn_clm_pty_no);
			if (clm_agn_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Claimant's Agent");
				frm.clm_agn_clm_pty_abbr_nm.focus();
				return ;	
			}
			popupMainCodeView(clm_agn_clm_pty_no);
			break;
		case "btn5_Style":
			var insur_agn_clm_pty_no=ComGetObjValue(frm.insur_agn_clm_pty_no);
			if (insur_agn_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Insurer's Agent");
				frm.insur_agn_clm_pty_abbr_nm.focus();
				return ;	
			}
			popupMainCodeView(insur_agn_clm_pty_no);
			break;
		//-----------------[Style 버튼 End]-----------//		
		case "btns_ofc_cd":
			if (!frm.fmal_clm_rcv_ofc_cd.readOnly){
			   popupOfficeCode(); //CoCni.js function
			}
			break;
		case "btn1_Claimant":
		case "clmt_clm_pty_abbr_nm":	
			MainCode="claimant"; 
			popupMainCodeInquiry(); //CoCni.js function
			break;
		case "btn1_Insurer":
		case "insur_clm_pty_abbr_nm":	
			MainCode="insurer";
			popupMainCodeInquiry(); //CoCni.js function
			break;
		case "btn4_Claimant_Agent":
		case "clm_agn_clm_pty_abbr_nm":	
			MainCode="claimant_agent";
			popupMainCodeInquiry(); //CoCni.js function
			break;
		case "btn5_Insurer_Agent":
		case "insur_agn_clm_pty_abbr_nm":	
			MainCode="insurer_agent";
			popupMainCodeInquiry(); //CoCni.js function
			break;
		case "btns_Attorney":
		case "deft_atty_clm_pty_abbr_nm":	
			MainCode="attorney";
			popupMainCodeInquiry(); //CoCni.js function
			break;
		case "btn1_Cargo":
			popupMainMiscView("15");
			break;	
	    //-----------------[ Miscellaneous Code Popup End ]-------------------------//	
		case "btns_BL_Get":
			doActionIBSheet(SEARCH20);
			break;
		case "btns_BL_Preview":
			var blNo=frm.cgo_clm_ref_bl_no.value;
			if (blNo == "") {
				ComShowMessage("Please use after retrieve ");		
				return false;
			}
			doActionIBSheet(SEARCH18);
			var bkgNo=frm.bkg_no.value;
			if (bkgNo == "") {
				ComShowCodeMessage("CNI00013");
				return false;
			}
			rdOpen(bkgNo);			
        	break;	
		case "btn3_FileUpload":
			 var cgo_clm_no=frm.cgo_clm_no.value;
			 if (cgo_clm_no.length == 10){
			     popupFileUpload("000301" ,cgo_clm_no );
			 }else{
				ComShowCodeMessage("CNI00003", "Claim No");
				frm.cgo_clm_no.focus();
			 }
			 break;
		case "btns_currency":
			//calling Currency commmon popup
			var display="1,0,1,1,1";
			ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 700, 450, "setCurrency", display);
			break;
		case "btns_roe":
			var clmtLoclCurrCd=frm.clmt_locl_curr_cd.value;
			if (ComIsNull(clmtLoclCurrCd)) {
				ComShowCodeMessage("CNI00009" , "Currency Code");
				ComSetFocus(frm.clmt_locl_curr_cd);
				return;
			}
       		var yrMon=frm.fmal_clm_rcv_dt.value;
       		if (yrMon ==  "") {
       			yrMon=ComGetNowInfo(); //return today
       		}
			popupRateOfExchange(clmtLoclCurrCd, yrMon);
			break;	
		case "btns_TB_Date":
			popupImpendingTBClaim();
			break;
		} // end switch
	} catch (e) {
		if( e == "[object Error]") {
		    ComShowMessage(OBJECT_ERROR);
		} else {
	       ComShowMessage(e.message);
		}
	}
}
/**
 * registering initial event 
 **/
function initControl() {
	// keypress
	axon_event.addListenerForm('keypress', 'obj_keypress', frm);
	// focus in
//	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	// focus out
//	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	// key up
	axon_event.addListenerForm('keyup', 'obj_keyup', frm);
	axon_event.addListener('change', 'jmt_rslt_cd_OnChange', 'jmt_rslt_cd')	// Template
	axon_event.addListenerFormat('blur','obj_blur',frm);      
}
 /**
  * setting initial combo
  **/
function initComboBoxValue(gubun) {
	var arrXml=ComGetObjValue(frm2.sXml).split("|$$|");
 	if (arrXml.length > 0 ) {
 		if(gubun == "" || gubun == null){
		 	var idx=0;
		 	setMultiComboBox("clmt_clm_tp_cd",      arrXml[idx++] ); //'03'
		 	setMultiComboBox("clmt_agn_tp_cd",      arrXml[idx++] ); //'04'
		 	setMultiComboBox("crr_term_cd",         arrXml[idx++] ); //'06'
		 	setMultiComboBox("jmt_rslt_cd",         arrXml[idx++] ); //'22'
		 	setMultiComboBox("agn_crspn_tp_cd",     arrXml[idx++] ); //'23'
		 	setMultiComboBox("cgo_clm_tp_cd",       arrXml[idx++] ); //'11' TOC
		 	setMultiComboBox("mjr_clm_dmg_lss_cd",  arrXml[idx++] ); //'02' CODL1
		 	setMultiComboBox("minr_clm_dmg_lss_cd", arrXml[idx++] ); //'05' CODL2
		 	setMultiComboBox("inci_plc_tp_cd",      arrXml[idx++] ); //'14' POI
		 	//Area Cd Setting
		 	var dataCount=ComGetTotalRows(arrXml[idx]);
		 	if (dataCount > 0) {
		 		var list=SheetXml2ListMap(arrXml[idx]);	
		 		var listVO=list[0];
		 		clmAreaCd=listVO["clm_area_cd"];
		 		ComSetObjValue(frm.clm_area_cd,clmAreaCd );
			} else {
				var popwin=popupClientDefault(); //calling setup display not existing Area Code
				popwin.focus();
			}
 		}
 		else{
 			var idx=9;
		 	//Area Cd Setting
		 	var dataCount=ComGetTotalRows(arrXml[idx]);
		 	if (dataCount > 0) {
		 		var list=SheetXml2ListMap(arrXml[idx]);	
		 		var listVO=list[0];
		 		clmAreaCd=listVO["clm_area_cd"];
		 		ComSetObjValue(frm.clm_area_cd,clmAreaCd );
			} else {
				var popwin=popupClientDefault(); //calling setup display not existing Area Code
				popwin.focus();
			}
 			
 		}
 	} 	
}
// focus in
function obj_activate(){
	obj=ComGetEvent();
	if (obj.getAttribute("readOnly")) return;
	ComClearSeparator(obj);
} 
// focus out
//function obj_deactivate(){
function obj_blur(){
	obj=ComGetEvent();
	ComChkObjValid(obj);
	if (obj.name == "cgo_clm_inci_no" && ComIsNull(obj.value)) {
		inci_plc_tp_cd.SetEnable(1);
		frm.inci_occr_dt.readOnly=false;
		frm.inci_occr_dt.className="input";		
	}
	if (ComIsNull(obj.value)) {
		return;
	}
	switch (ComGetEvent("name")) {
		case "clmt_locl_amt":
			var clmt_locl_amt=cniParseFloat(frm.clmt_locl_amt); 
			var cgo_clm_sts_cd=ComGetObjValue(frm.cgo_clm_sts_cd);
			if (clmt_locl_amt > 0 && ((cgo_clm_sts_cd == "" || cgo_clm_sts_cd == "N" || cgo_clm_sts_cd == "C"))) {
				frm.fmal_clm_rcv_ofc_cd.readOnly=false;
				frm.fmal_clm_rcv_ofc_cd.className="input1";
				frm.fmal_clm_rcv_ofc_cd.setAttribute("required","required");
				frm.fmal_clm_rcv_dt.readOnly=false;
				frm.fmal_clm_rcv_dt.className="input1";
				frm.fmal_clm_rcv_dt.setAttribute("required","required");
				$("#btns_fmal_clm_rcv_dt").removeAttr("disabled");
//				document.getElementById("div_btn2").style.display="block"; 
			} else {
				frm.fmal_clm_rcv_ofc_cd.readOnly=true;
				frm.fmal_clm_rcv_ofc_cd.className="input2";
				frm.fmal_clm_rcv_ofc_cd.removeAttribute("required");
				frm.fmal_clm_rcv_dt.readOnly=true;
				frm.fmal_clm_rcv_dt.className="input2";
				frm.fmal_clm_rcv_dt.removeAttribute("required");
//				document.getElementById("div_btn2").style.display="none"; 
				$("#btns_fmal_clm_rcv_dt").attr("disabled", "disabled");
				if (cgo_clm_sts_cd == "" || cgo_clm_sts_cd == "N") {
					frm.fmal_clm_rcv_ofc_cd.value="";
					frm.fmal_clm_rcv_dt.value="";
				}
			}
			break;
		case "clmt_locl_xch_rt": 
			setFeeUsdAmt();
			break;   
		case "clmt_locl_curr_cd":
			setXchRt();
			setFeeUsdAmt();
			break;
		case "lodg_dt":
			ComSetObjValue(frm.lodg_dt1,frm.lodg_dt.value)
			break;
		case "del_cd":
			ComSetObjValue(frm.del_cd1,frm.del_cd.value)
			break;
		case "de_dt":
			 var clm_tm_bar_dt=ComGetDateAdd(ComGetObjValue(frm.de_dt), "Y", 1) ; // today + 1
			 ComSetObjValue(frm.clm_tm_bar_dt,clm_tm_bar_dt) 
			break;
	}
}
/**
 * HTML Control KeyPress event
 **/
function obj_keypress() {
	obj=ComGetEvent();
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;
    switch(obj.dataformat) {
        case "ymd":
        case "ym":
        case "hms":
        case "hm":
        case "jumin":
        case "saupja":
            ComKeyOnlyNumber(obj);
            break;
        case "int":
            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
            else ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet(); 
            break;
        case "engup":
        	if(obj.name == "clmt_locl_curr_cd") ComKeyOnlyAlphabet('upper')
        	else
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "engdn":
            ComKeyOnlyAlphabet('lower');
            break;
   }// end of switch
   if (obj.name == "cgo_clm_no") {
	   if (event.keyCode == 13) {
		   doActionIBSheet(SEARCH);
	   }
   }
   if (obj.name == "cgo_clm_inci_no") {
	   if (event.keyCode == 13) {
		   doActionIBSheet(SEARCH15);
	   }
   }
   if (obj.name == "clmt_locl_xch_rt" || obj.name == "clmt_locl_amt") {
	   if ( event.keyCode == 13 ) {
		   setFeeUsdAmt();
	   }
   }
 }
/**
 * HTML Control KeyUp event
 **/
function obj_keyup() {
	if ((event.keyCode >= 37 && event.keyCode <= 40)|| (event.keyCode == 16)) return;
	switch (ComGetEvent().name) {
		case "cgo_clm_no":
			ComKeyOnlyAlphabet('uppernum');
			if (frm.cgo_clm_no.value.length == 10) {
				doActionIBSheet(SEARCH);
			}
			break;
		case "cgo_clm_inci_no":
			if (frm.cgo_clm_inci_no.value.length == 13) {
				doActionIBSheet(SEARCH15);
			}
			break;
		case "clmt_locl_amt":
	        if (cniParseFloat(frm.clmt_locl_xch_rt) > 0 && cniParseFloat(frm.clmt_locl_amt) > 0  ) {
			    setFeeUsdAmt();
	        }
	        break;
		case "plt_nm":
		case "jmt_rslt_dt":
	        if (ComIsNull(frm.smns_sve_dt.value)) {
	        	ComShowCodeMessage("CNI00009" , "Summon Served Date!");
	        	ComSetObjValue(ComGetEvent(),"")
				ComSetFocus(frm.smns_sve_dt);
	        }
	        break;    
   }//end of switch
}
/**
 * setting sheet initial values and header
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * adding case as numbers of counting sheets
 **/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
 	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
	    with(sheetObj){
	      var HeadTitle1="";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      (headCount, 0, 0, true);
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];      InitHeaders(headers, info);
	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];       
	      InitColumns(cols);
	      SetEditable(0);
      }//end of with
		break;
	}// end of switch
 }
/**
 * Combobox Initialize, Header Definition 
 * @param {object} comboObj Mandatory, IBMultiCombo Object
 * @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
 **/
function initCombo(comboObj, comboNo) {
	with (comboObj) {
		comboObj.SetMultiSelect(0);
		//no support[check again]CLT 		comboObj.UseCode=true;
		//no support[check again]CLT 		comboObj.LineColor="#ffffff";
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(175);
		var comboName=comboObj.name;
	}
} 
 /**
  * Handling Sheet's process
  **/
 function doActionIBSheet(sAction) {
	 
	frm.f_cmd.value=sAction;
	switch (sAction) {
 	case SEARCH: // Retrieve Claim Main
 		if (validateForm(sAction)) {
 			var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
			//에러 체크
			if (getErrorMsg(sheet1,sXml)) {
				return;
			}
			var dataCount=ComGetTotalRows(sXml);
			if (dataCount > 0) {
				  ComBtnEnable("btn1_Save");
				  ComBtnEnable("btn1_Cancel");
				  sheetXml2ObjectValue(sXml);
				  //자동처리 외 예외적인 값 처리 부분--------------------------
				  ComSetObjValue(frm.lodg_dt1,ComGetObjValue(frm.lodg_dt));
				  ComSetObjValue(frm.del_cd1,ComGetObjValue(frm.del_cd));
				  ComSetObjValue(frm.de_dt1,ComGetObjValue(frm.de_dt)); 
				  if (ComGetObjValue(frm.cgo_clm_inci_no) == ""){
					  inci_plc_tp_cd.SetEnable(1);
					  frm.inci_occr_dt.readOnly=false;
					  frm.inci_occr_dt.className="input";
			      }else{
					  inci_plc_tp_cd.SetEnable(0);
					  frm.inci_occr_dt.readOnly=true;
					  frm.inci_occr_dt.className="input2";
			      }	  
				  //-------------------------------------------------------
				  setRoleButton();
				  var cgo_clm_sts_cd=ComGetObjValue(frm.cgo_clm_sts_cd);
				  if (cgo_clm_sts_cd == "C" || cgo_clm_sts_cd == "X") { // Deactivation button in case X or C
					  setRoleButton();
					  ComBtnDisable("btn1_Save");
				  	  ComBtnDisable("btn1_Cancel");
				  }
				  // Deactivation button Cancel
				  if (cgo_clm_sts_cd == "P" || cgo_clm_sts_cd == "R" ||
					  cgo_clm_sts_cd == "L" || cgo_clm_sts_cd == "A" ||
					  cgo_clm_sts_cd == "V") { 
					  setRoleButton();
					  ComBtnDisable("btn1_Cancel");
			 	  }
			} else { 
				ComShowCodeMessage('CNI00013');
				ComResetAll();
				ComSetObjValue(frm.cgo_clm_no, "");
				tabObjects[0].SetSelectedIndex(0);
				tabObjects[1].SetSelectedIndex(0);
				ComSetFocus(frm.cgo_clm_no);
				ComBtnEnable("btn1_Save");
				setRoleButton();
				ComBtnDisable("btn1_Cancel");
			}// end if 
			
			frm.fmal_clm_rcv_ofc_cd.readOnly=true;
			frm.fmal_clm_rcv_ofc_cd.className="input2";
			frm.fmal_clm_rcv_ofc_cd.removeAttribute("required");
			frm.fmal_clm_rcv_dt.readOnly=true;
			frm.fmal_clm_rcv_dt.className="input2";
			frm.fmal_clm_rcv_dt.removeAttribute("required");
			document.getElementById("div_btn2").style.display="none"; 
		}
		break;
 	case SEARCH11: // Misc Code Validation
	 	var clss_clm_misc_cd=ComGetObjValue(frm.clss_clm_misc_cd);
	 	var clm_misc_cd=ComGetObjValue(frm.clm_misc_cd);
 		var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	"f_cmd="+sAction+"&clss_clm_misc_cd="+clss_clm_misc_cd + "&clm_misc_cd="+clm_misc_cd);
		if (getErrorMsg(sheet1,sXml)) {
			return "N";
		}
		var isExist=ComGetEtcData(sXml,"EXIST");
 	    return isExist;
		break;	
 	case SEARCH12: // Retrieve Office Cd
	 	var fmal_clm_rcv_ofc_cd=ComGetObjValue(frm.fmal_clm_rcv_ofc_cd);
 		var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	"f_cmd="+sAction+"&fmal_clm_rcv_ofc_cd="+fmal_clm_rcv_ofc_cd);
		if (getErrorMsg(sheet1,sXml)) {
			return "N";
		}
		var isExist=ComGetEtcData(sXml,"EXIST");
		return isExist;
		break;	
 	case SEARCH15: // Retrieve Incident Info
	 	var cgo_clm_inci_no=ComGetObjValue(frm.cgo_clm_inci_no);
	 	if (cgo_clm_inci_no != ""){
 		 	var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
		 	if (getErrorMsg(sheet1,sXml)) {
				return;
			}
		 	var list=SheetXml2ListMap(sXml);	
			var dataCount=ComGetTotalRows(sXml);
	 		if (dataCount == 0) {
	 			ComShowCodeMessage("CNI00013");
	 			//ComSetObjValue(frm.cgo_clm_inci_no, "");
	 		}else{
	 			var listVO=list[0];
				ComSetObjValue(inci_plc_tp_cd, listVO["inci_plc_tp_cd"]);
				ComSetObjValue(frm.inci_occr_dt,   listVO["inci_occr_dt"]);
				setFormatData(frm.inci_occr_dt, listVO["inci_occr_dt"], "ymd" );
				inci_plc_tp_cd.SetEnable(0);
				frm.inci_occr_dt.readOnly=true;
				frm.inci_occr_dt.className="input2";
	 		}
	 	}	
		break;	
 	case SEARCH18: // Retrieve BookingNo
 	 	var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do", FormQueryString(frm),"",true);
	 	var arrXml=sXml.split("|$$|");
	 	// ------------------------------------------------------------
	 	// setting Booking No
	 	// ------------------------------------------------------------
	 	if (arrXml.length > 0) {
	 		var list=SheetXml2ListMap(arrXml[0]);	
	 		if (list.length > 0) {
	 			var dataVO=list[0];					
	 			frm.bkg_no.value=dataVO["bkg_no"];					
	 		}
	 	} else {
	 		frm.bkg_no.value='';
	 	}
 	    break;
 	case SEARCH20: // Retrieve B/L 
 	    if (!validateForm(sAction)) return; 
 	    frm.f_cmd.value=SEARCH19;
  	    var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
 	    if (getErrorMsg(sheet1,sXml)) {
		   return;
	    }
	    var cgo_clm_ref_bl_no=ComGetEtcData(sXml,"CGO_CLM_REF_BL_NO");
	    if (cgo_clm_ref_bl_no != ""){
	        ComShowCodeMessage("CNI00035"); //"Same B/L Found! Please check Duplication." 
	    }
	    frm.f_cmd.value=SEARCH20;
  		var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
 		if (getErrorMsg(sheet1,sXml)) {
			return;
		}
	 	var list=SheetXml2ListMap(sXml);	
		if (list.length > 0) {
			var listVO=list[0];
			ComSetObjValue(frm.slan_cd,         listVO["slan_cd"]);
			ComSetObjValue(frm.lodg_dt,         ComGetMaskedValue(listVO["lodg_dt"], "ymd"));
			ComSetObjValue(frm.lodg_dt1,        ComGetMaskedValue(listVO["lodg_dt"], "ymd"));
			ComSetObjValue(frm.vsl_eng_nm,      listVO["vsl_eng_nm"]);
			ComSetObjValue(frm.trnk_ref_vvd_no, listVO["trnk_ref_vvd_no"]);
			ComSetObjValue(crr_term_cd,     listVO["crr_term_cd"]);
			ComSetObjValue(frm.del_cd,          listVO["del_cd"]);
			ComSetObjValue(frm.del_cd1,         listVO["del_cd"]);
			ComSetObjValue(frm.cgo_qlty_desc,   listVO["cgo_qlty_desc"]);
		} else {
			ComShowCodeMessage("CNI00013");
			ComSetObjValue(frm.slan_cd,         "");
			ComSetObjValue(frm.lodg_dt,         "");
			ComSetObjValue(frm.lodg_dt1,        "");
			ComSetObjValue(frm.vsl_eng_nm,      "");
			ComSetObjValue(frm.trnk_ref_vvd_no, "");
			ComSetObjValue(crr_term_cd,     "");
			ComSetObjValue(frm.del_cd,          "");
			ComSetObjValue(frm.del_cd1,         "");
			ComSetObjValue(frm.clm_cgo_tp_cd,   "");
			ComSetObjValue(frm.cgo_qlty_desc,   "");
		 	frm.cgo_clm_ref_bl_no.focus();
		}
		break;
 	case MULTI: //Save
 	    if (!validateForm(sAction)) return; 
	 	if (!validateMiscCd(cgo_clm_tp_cd, "11")) return; 
	 	if (!validateMiscCd(mjr_clm_dmg_lss_cd,"02")) return; 
	 	if (!validateMiscCd(minr_clm_dmg_lss_cd,"05")) return; 
	 	if (!validateMiscCd(inci_plc_tp_cd,"14")) return; 
	 	if (!validateOfficeCd(frm.fmal_clm_rcv_ofc_cd)) return;
	 	//checking save
	 	if(!ComShowCodeConfirm('CNI00012')) return;
 	    var cgo_clm_no=frm.cgo_clm_no.value.trim();
 		if (cgo_clm_no !=""){
 			frm.f_cmd.value=SEARCH;
  			var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
			// date count
		 	var dataCount=ComGetTotalRows(sXml);
		 	if (dataCount == 0) {
		 		ComShowCodeMessage("CNI00013");
		 		return;
		 	}
 		}
 		frm.f_cmd.value=MULTI;
 		clearAllObjectMask(); //Form Object UnMask
 		var param=FormQueryString(frm);
 		var saveString=sheet1.GetSaveString();
		param += "&" + saveString;	
		param = param.replace(/(\d{4})-(\d{2})-(\d{2})/g, '$1$2$3');
  		var sXml=sheet1.GetSaveData("CPS_CNI_0003GS.do", param);
 		if (getErrorMsg(sheet1,sXml)) {
			return;
		}
  	   	sheet1.LoadSaveData(sXml);
 		var cgo_clm_no=ComGetEtcData(sXml,"CGO_CLM_NO");
 		frm.cgo_clm_no.value=cgo_clm_no;
 		doActionIBSheet(SEARCH);
 		break;
	 case MULTI01: //Cancel
		if (!validateForm(sAction)) return; 
		if(!ComShowCodeConfirm('CNI00021')) return;
		var cgo_clm_no=frm.cgo_clm_no.value.trim();
		if (cgo_clm_no !=""){
			frm.f_cmd.value=SEARCH;
 			var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
		 	var dataCount=ComGetTotalRows(sXml);
		 	if (dataCount == 0) {
		 		ComShowCodeMessage("CNI00013");
		 		return;
		 	}
		}
		frm.f_cmd.value=MULTI01;
		clearAllObjectMask(); //Form Object UnMask
		var param=FormQueryString(frm);
		var saveString=sheet1.GetSaveString();
		param += "&" + saveString;	
 		var sXml=sheet1.GetSaveData("CPS_CNI_0003GS.do", param);
		if (getErrorMsg(sheet1,sXml)) {
			return;
		}
 		sheet1.LoadSaveData(sXml);
		var cgo_clm_no=ComGetEtcData(sXml,"CGO_CLM_NO");
		frm.cgo_clm_no.value=cgo_clm_no;
		doActionIBSheet(SEARCH); 
		break;
	}
 }
/**
 * handling process for input validation
 **/
function validateForm(sAction) {
	var cgo_clm_no=frm.cgo_clm_no.value;
	if (sAction == SEARCH20) {
		var cgo_clm_ref_bl_no=frm.cgo_clm_ref_bl_no.value;
		if (cgo_clm_ref_bl_no == "") {
			ComShowCodeMessage("CNI00003", "B/L No.");
			frm.cgo_clm_ref_bl_no.focus();
			return false;
		}
	} else if (sAction == MULTI || sAction == MULTI01) {
		if( !ChkRequiredWithTab(frm) ){
             return false;
        }
		var crr_term_cd=ComGetObjValue(frm.crr_term_cd_text);
		if (typeof(crr_term_cd) == "undefined" || crr_term_cd == "") {
			ComShowCodeMessage("CNI00003", "Term");
			tabObjects[0].SetSelectedIndex(0);
			return false;
		}
		var clmt_clm_tp_cd=ComGetObjValue(frm.clmt_clm_tp_cd_text);
		if (typeof(clmt_clm_tp_cd) == "undefined" || clmt_clm_tp_cd == "") {
			ComShowCodeMessage("CNI00003", "Type");
			tabObjects[0].SetSelectedIndex(0);
			return false;
		}
		var cgo_clm_tp_cd=ComGetObjValue(frm.cgo_clm_tp_cd_text);
		if (typeof(cgo_clm_tp_cd) == "undefined" || cgo_clm_tp_cd == "") {
			ComShowCodeMessage("CNI00003", "TOC");
			tabObjects[0].SetSelectedIndex(0);
			return false;
		}
		var inci_plc_tp_cd=ComGetObjValue(frm.inci_plc_tp_cd_text);
		if (typeof(inci_plc_tp_cd) == "undefined" || inci_plc_tp_cd == "") {
			ComShowCodeMessage("CNI00003", "POI");
			tabObjects[0].SetSelectedIndex(0);
			return false;
		}
		var jmt_rslt_cd=ComGetObjValue(frm.jmt_rslt_cd);
		var jmt_rslt_dt=ComGetObjValue(frm.jmt_rslt_dt);
		if (jmt_rslt_cd != "" && jmt_rslt_dt == "") {
			ComShowCodeMessage("CNI00003", "Final Judgment Date");
			tabObjects[0].SetSelectedIndex(2);
			frm.jmt_rslt_dt.focus();
			return false;
		}
		if (!chkAmount(frm.clmt_locl_amt, frm.clmt_locl_curr_cd, frm.fmal_clm_rcv_dt, frm.clmt_locl_xch_rt, "Claim Amount", "Date of Formal Claim")) return false;
	}
	return true;
}
//===================================================================================        
// Private Function
//=================================================================================== 
function clearAllObjectMask(){
	var vObjects=frm.elements;
	for ( var kdx=0; kdx < vObjects.length; kdx++) {
		var vObj=vObjects[kdx];
//		var vObjdf=vObj.dataformat;
		var vObjdf=$("#" +vObj.id).attr("dataformat");
		if ((typeof(vObjdf) != "undefined") && (vObjdf != null) && (vObjdf != "")) {
			ComClearSeparator(vObj);
		}//end if	
    }//end for
}
function sheetXml2ObjectValue(pXml) {
	var vListData=SheetXml2ListMap(pXml);
	if (vListData.length > 0) {
		var vListVO=vListData[0];
		var vObjects=frm.elements;
		var pattern = /_cd_text/;
		for ( var kdx=0; kdx < vObjects.length; kdx++) {
			var vObj=vObjects[kdx];
			var vObjtp=vObj.type;
//			var vObjdf=vObj.dataformat;
			var vObjdf=$("#" +vObj.id).attr("dataformat");
			var vObjnm=vObj.name;
			var vObjval=vObj.value;
			if (vObjnm == undefined || vObjnm == ""){
				continue;
			}	
			var vData=vListVO[vObjnm];
			if (typeof (vData) == "undefined") {
				vData=vObjval;
			}
			if (vObjtp =="checkbox" ) {
				var vUpperData=vData.toUpperCase();
			    if (vUpperData != "Y") vData="";	
			}  

			ComSetObjValue(vObj, pattern.test(vObjnm)?vListVO[vObjnm.replace("_text", "")]:vData);

			if (typeof(vObjdf) != "undefined" && vObjdf != null && vObjdf != "") {
				setFormatData(vObj, vData, vObjdf);
			}
		} //end for
	}// end if	
}
/**
 * retrieving sever format
 * @param {pObj} form object 
 * @param {pRawData} retrieving sever
 * @param {pDataFormat} dataformat value
 **/
function setFormatData(pObj, pRawData, pDataFormat){
    switch (pDataFormat) {
		case "ymd":    //yyyy-mm-dd
		case "ymdhms": //yyyy-mm-dd hh:mm:ss
		case "ymdhm":  //yyyy-mm-dd hh:mm
	   	    pObj.value=ComGetMaskedValue(pObj, pDataFormat);	
			break;
		case "int":
			pObj.value=ComAddComma2(pRawData, "#,###");
			break;
		case "float":
			if (pObj.name == "clmt_locl_xch_rt") {
				p=pRawData.split(".");
				p[0]=ComAddComma(p[0]);
				if      (p.length == 1) pObj.value=p[0]+".00000";
				else if (p.length == 2) pObj.value=p[0]+"."+p[1];
				else pObj.value="";
			} else { 
			    pObj.value=ComAddComma2(pRawData, "#,###.00");
			}
			break;
		default:
			pObj.value=pRawData;
			break;
	}
}
/**
 * setting IBMultiComboBox
 * @param {select box} combo object
 * @param {xml} code , name xml
 **/
function setMultiComboBox(pComboObjId, pXML) {
	var vComboObj=null; // IBMultiComboBox
	var vArrayListData=""; 
	var vListData="";
	var vCaptionText="";
	vComboObj=getComboObject(pComboObjId);
	if (vComboObj == null || pXML == null ) {
		return;
	}
	var vArrayListData=SheetXml2ListMap(pXML);
	for ( var idx=0, j = 0; idx < vArrayListData.length; idx++) {
	    vListData=vArrayListData[idx];
	    if (vListData != undefined) {
	    	vCaptionText=vListData["code"] + " |" + vListData["name"];
			vComboObj.InsertItem(j++, vCaptionText, vListData["code"]);
	    }
	}//end for
	vComboObj.InsertItem(0, "", "");
}
/**
 * return comboObject
 * @param comboId
 **/
function getComboObject(pComboObjId){
	var vCnt=comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].options.id== pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}
/**
  * setting Office Code
  * @param comboId
  **/ 
function setOfficeCode(pOfcCd){
	if (frm.fmal_clm_rcv_ofc_cd.readOnly == false){
	   ComSetObjValue(frm.fmal_clm_rcv_ofc_cd, pOfcCd);
	}   
}
/**
  * setting svyr_fee_usd_amt in case input ROE
  * Claim Amount = ( Survey Fee / R.O.E )
  * point in three-digit rounding
  **/
function setFeeUsdAmt() { 
  	var floatLoclAmt=cniParseFloat(frm.clmt_locl_amt);
  	var floatXchRt=cniParseFloat(frm.clmt_locl_xch_rt);
  	if(floatXchRt != 0 && floatLoclAmt != 0 ){
  		// clmt_locl_amt / clmt_locl_xch_rt
  		var tmpUsdAmt=roundPrecision(floatLoclAmt / floatXchRt, 2);
  		frm.clmt_usd_amt.value=tmpUsdAmt;
  		var tmpUsdAmt2=ComAddComma2(frm.clmt_usd_amt.value,"#,###.00");
  		frm.clmt_usd_amt.value=tmpUsdAmt2;
  	} else {
  		frm.clmt_usd_amt.value="0";
  	}
 }
/**
 * IBSheet XML by parsing the XML string in the value of an item that is returned in the parameter <br>
 * @param {string} xmlStr    Xml characters received through IBSheet
 * @param {string} dataNode  Parse items
 * @return {string} xmlValue
 **/
function getXMLData(pXmlStr, pDataNode) {
	var vXmlData="";
	try {
          var vXmlDoc=new ActiveXObject("Microsoft.XMLDOM");
          vXmlDoc.async="false";
          vXmlDoc.loadXML(pXmlStr);
          vXmlData=vXmlDoc.documentElement.getElementsByTagName(pDataNode).item(0).text
    } catch(err) {
    	  vXmlData='';
    }
	return vXmlData;
}
function setMainCodeInquiry(partyVo) {
	switch(MainCode){
		case "claimant":
			frm.clmt_clm_pty_no.value=partyVo.clm_pty_no;
			frm.clmt_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			frm.clmt_clm_pty_nm.value=partyVo.pty_nm;
			break;
		case "insurer":
			frm.insur_clm_pty_no.value=partyVo.clm_pty_no;
			frm.insur_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			break;
		case "claimant_agent":
			frm.clm_agn_clm_pty_no.value=partyVo.clm_pty_no;
			frm.clm_agn_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			frm.clm_agn_clm_pty_nm.value=partyVo.pty_nm;
			frm.clm_agn_intl_phn_no.value=partyVo.intl_phn_no;
			frm.clm_agn_phn_no.value=partyVo.phn_no;
			frm.clm_agn_pty_eml.value=partyVo.pty_eml;	
			break;
		case "insurer_agent":
			frm.insur_agn_clm_pty_no.value=partyVo.clm_pty_no;
			frm.insur_agn_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			frm.insur_agn_clm_pty_nm.value=partyVo.pty_nm;
			frm.insur_agn_intl_phn_no.value=partyVo.intl_phn_no;
			frm.insur_agn_phn_no.value=partyVo.phn_no;
			frm.insur_agn_pty_eml.value=partyVo.pty_eml;
		 	break;
		case "attorney":
			frm.deft_atty_clm_pty_no.value=partyVo.clm_pty_no;
			frm.deft_atty_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
			frm.deft_atty_clm_pty_nm.value=partyVo.pty_nm;
			break;
	}
} 
/**
 * Function selected Miscellaneous Code-Inquiry
 * @param miscCdVO
 * @return
 */
function setMiscCode(miscCdVO){
	var clss_clm_misc_cd=miscCdVO.clss_clm_misc_cd;
	switch(clss_clm_misc_cd){
	case "02":
		mjr_clm_dmg_lss_cd.value=miscCdVO.clm_misc_cd;
		break;
	case "05":
		minr_clm_dmg_lss_cd.value=miscCdVO.clm_misc_cd;
		break;
	case "11":
		cgo_clm_tp_cd.value=miscCdVO.clm_misc_cd;
		break;
	case "14":
		inci_plc_tp_cd.value=miscCdVO.clm_misc_cd;
		break;	
	case "15":
		frm.clm_cgo_tp_cd.value=miscCdVO.clm_misc_cd;
		frm.cgo_qlty_desc.value=miscCdVO.clm_misc_nm;
		break;
	}
}
/**
 * Currency subsequent operations in the pop-up selection : Automatic input selection ROE 1.00000 USD
 */
function setCurrency(rowArray) { 
   frm.clmt_locl_curr_cd.value=rowArray[0][2];
   if(rowArray[0][2] == "USD"){
		frm.clmt_locl_xch_rt.value="1.00000";
   }
}
/**
 * If you type a Currency USD ROE 1.00000 automatically when the input
 */
 function setXchRt() { 
	if(frm.clmt_locl_curr_cd.value == "USD"){
		frm.clmt_locl_xch_rt.value="1.00000";
	}
 }
/** calling popup R.O.E
 */
function setCurrencyROE(xchRtVo) {
 	frm.clmt_locl_curr_cd.value=xchRtVo.curr_cd;
 	frm.clmt_locl_xch_rt.value=xchRtVo.usd_locl_xch_rt;
 	setFeeUsdAmt();
}
/**
 * CCC VVD & SKD Inquiry set of selected values ​​from the pop-up
 * @param vvdSkdVo
 */
function setVvdSkd(vvdSkdVo){
	frm.slan_cd.value=vvdSkdVo.slan_cd;
	frm.trnk_ref_vvd_no.value=vvdSkdVo.vvd;
	frm.pol_cd.value=vvdSkdVo.pol;
	frm.pod_cd.value=vvdSkdVo.pod;
}
 /**
  * Common error-handling function
  * @class IAfter the Search IBSheet Exception message shows that when 
  * @param {IBSheet} pSheetObj it's IBSheet
  * @param {string} pXml XML on the server, the query results
  * @throws
  * @author
  * @since 2009.11.12
  */
function getErrorMsg(pSheetObj, pXml){
	var vErrorMsg=ComGetEtcData(pXml,"Exception");
	if (vErrorMsg != undefined && vErrorMsg != null && vErrorMsg != "" ) {
		pSheetObj.LoadSearchData(pXml,{Sync:1} );
		return true;
	}
	return false;
}
function validateMiscCd(pObj, pClassCd){
	if (ComIsNull(pObj.value)) {
		return true;
	}
	ComSetObjValue(frm.clss_clm_misc_cd, pClassCd);
	ComSetObjValue(frm.clm_misc_cd, pObj.value);
	var isExist=doActionIBSheet(SEARCH11);
	if (isExist != "Y") {
		ComShowCodeMessage("CNI00034", pObj.getAttribute("caption"));
		ComSetObjValue(pObj, "");
		ComSetFocus(pObj);
		return false;
	}
	return true;
}
function validateOfficeCd(pObj){
	if (ComIsNull(pObj.value)) {
		return true;
	}
	var isExist=doActionIBSheet(SEARCH12);
	if (isExist != "Y") {
		ComShowCodeMessage("CNI00034", pObj.getAttribute("caption"));
		ComSetObjValue(pObj, "");
		ComSetFocus(pObj);
		return false;
	}
	return true;
}
/* 
 * setting Final Judgment Code
 */
//function jmt_rslt_cd_onchange(){
function jmt_rslt_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var objVal = ComGetObjValue(jmt_rslt_cd);
    if (objVal!=""){
    	if (ComIsNull(frm.smns_sve_dt.value)) {
        	ComShowCodeMessage("CNI00009" , "Summon Served Date!");
        	ComSetObjValue(objVal,"")
			ComSetFocus(frm.smns_sve_dt);
        }
    }
}
/**
* Amount, currency, date, and the exchange rate at the input of the other three input fields, checking whether all
*/
function chkAmount(objLoclAmt, objCurrCd, objInputDt, objXchRt, msg1, msg2) {
	var loclAmt=cniParseFloat(objLoclAmt);
	var currCd=objCurrCd.value.trim();
	var inputDt=objInputDt.value.trim();
	var xchRt=cniParseFloat(objXchRt);
	if (loclAmt == 0  && ComIsNull(currCd) && ComIsNull(inputDt) && xchRt == 0) {
		return true;
	} else if (!ComIsNull(loclAmt) && !ComIsNull(currCd) && !ComIsNull(inputDt) && xchRt != 0) {
		return true;
	} else {
	   	if (loclAmt == 0) {
		    ComAlertFocus(objLoclAmt, ComGetMsg('CNI09028',msg1));
			return false;
	    } else if (ComIsNull(currCd)) {
		    ComAlertFocus(objCurrCd, ComGetMsg('CNI09028',msg1+"(Currency)"));
			return false;
	    } else if (ComIsNull(inputDt)) {
		    ComAlertFocus(objInputDt, ComGetMsg('CNI09028',msg2));
			return false;
	    } else if (xchRt == 0) {
		    ComAlertFocus(objXchRt, ComGetMsg('CNI09028',msg1+"(R.O.E)"));
			return false;
	   	} 
	}
	return true;
}
function setRoleButton(){
//	ComBtnDisable("btn1_Save");
//	ComBtnDisable("btn1_Cancel");
//	if (equalsRole("CNI03") || equalsRole("CNI93")) {
		 ComBtnEnable("btn1_Save");
		 ComBtnEnable("btn1_Cancel");	
//	} else if (equalsRole("CNI02")) {
//		var clm_area_cd=ComGetObjValue(frm.clm_area_cd);
//		if (equalsArea(clm_area_cd)) {
//			ComBtnEnable("btn1_Save");
//			ComBtnEnable("btn1_Cancel");
//		}	
//	} else if (equalsRole("CNI01")) {
//		var usr_id=ComGetObjValue(frm.usr_id);
//		var hdlr_usr_id=ComGetObjValue(frm.hdlr_usr_id);
//		var hdlr_ofc_cd=ComGetObjValue(frm.hdlr_ofc_cd);
//		if (usr_id == hdlr_usr_id &&  equalsOffice(hdlr_ofc_cd)) {
//			ComBtnEnable("btn1_Save");
//			ComBtnEnable("btn1_Cancel");
//		}
//	}
}
function rdOpen(strBkgNo){    
	rdUrl="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"; 
	rdFile="ESM_BKG_0109_DBL.mrd";	
	rdParam="/rv form_bkgNo[( '" + strBkgNo + "') ]"
		  + "  form_type[2]"
	      + " form_dataOnly[N]"
	      + " form_manifest[N]"
	      + " form_usrId[" +frm.usr_id.value+"] "
	      + " form_hiddeData[N]"
	      + " form_level[(3)]"
		  + " form_remark[]"
		  + " form_Cntr[1]"
		  + " form_mainOnly[N]"
		  + " form_CorrNo[]"
		  + " form_his_cntr[BKG_CONTAINER]"
		  + " form_his_bkg[BKG_BOOKING]"
		  + " form_his_mkd[BKG_BL_MK_DESC]"
		  + " form_his_xpt[BKG_XPT_IMP_LIC]"
		  + " form_his_bl[BKG_BL_DOC]"
		  + " isEncode[Y]"
		  + " /rp []"
		  + " /riprnmargin";
	frm.com_mrdTitle.value="OPUS Container Draft B/L Copies";
	frm.com_mrdPath.value=rdUrl+rdFile;
	frm.com_mrdArguments.value=rdParam + " /rwait";
	frm.com_mrdBodyTitle.value="OPUS Container Draft B/L Copies";
	ComOpenRDPopup('resizable=yes, width=900, height=620');
}
function popupClientDefault() {	
	var url = "CPS_CNI_0001_POP.do?popupYn=Y";
	var winName = "CPS_CNI_0001";
	var reqWin = openWinCenter(url,winName,400,150);
	reqWin.focus();
	return reqWin;
}

