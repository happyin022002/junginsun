/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0045.js
*@FileTitle  : [CPS_CNI_0045] Invoice Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/**
 * [CPS_CNI_0045] Invoice Creation
 * @extends
 * @class 
 */
//function cps_cni_0045() {
//    this.processButtonClick=processButtonClick;
//    this.setSheetObject=setSheetObject;
//    this.loadPage=loadPage;
//    this.initSheet=initSheet;
//    this.initControl=initControl;
//    this.doActionIBSheet=doActionIBSheet;
//    this.setTabObject=setTabObject;
//    this.validateForm=validateForm;
//}
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage(year) {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    //registering initial event 
    initControl();
    //retrieving in case of existing Claim No.
    if (!ComIsNull(frm.cgo_clm_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    }	
    frm.cgo_clm_no.focus();
}
/**
* registering initial event 
*/
function initControl() {
//	axon_event.addListener('keypress', 'keypressFormat', 'form');	
	axon_event.addListener('keyup', 'keypressCgoClmNo', 'cgo_clm_no');
//	axon_event.addListener ('keydown', 'keydownEnter', 'form');
	// focus out
    axon_event.addListenerForm('blur', 'obj_deactivate',  frm);    
    // focus in
//    axon_event.addListenerFormat('focus',   'obj_activate',    frm);
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
          
	            var HeadTitle1="|Seq.|Type|Payee|Invoice No.|Inv. Date|Curr|Invoice Amount|CSR No.|CSR Status|Rejected Date|APF|AP Date|AP Amount|Description|Rcvd Date|Due Date|R.O.E.|USD Amount|Remark|cgo_clm_pay_no";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	//            (headCount, 8, 0, true);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dataSeq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"clm_cost_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"clm_pty_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"locl_curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ap_cxl_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ap_pay_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ap_pay_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ap_pay_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cost_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_eff_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_xch_rt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_usd_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"inv_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_pay_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	             
	            InitColumns(cols);
	            SetEditable(0);
	            SetSheetHeight(210);
			break;					
		}
	}
}
/**
 * setting Location
 */
function setLocation(rowArray) { 
   frm.loc_cd.value=rowArray[0][3];
}
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {	
		case "btn1_Retrieve":
			if (ComChkObjValid(frm.cgo_clm_no)) {
				doActionIBSheet(SEARCHLIST01);
			}
			break;
	    case "btn1_New":
    		ComResetAll();
    		frm.cgo_clm_no.focus();
	        break;	
	    case "btn1_Save":
	    	
	       
	        if (ComIsNull(frm.vndr_seq.value)) {
				ComShowCodeMessage("CNI00111");
				return;
			}
			//CNI00012(Do you want to save changes?)
			if (ComShowCodeConfirm("CNI00012")) {
				if (ComChkValid(frm)) {
					doActionIBSheet(MULTI);
				}
			}
	    	break;
		case "btns_calendar":
			var vCal=new ComCalendar();
			vCal.setDisplayType("date");
			vCal.select(frm.inv_eff_dt, "yyyy-MM-dd");
			break;
			// Down Excel
		case "btn1_Down_Excel":	
			if (sheet1.RowCount()> 0 ) {
				var columnSkipList="ibflag|cgo_clm_pay_no";
 				sheet1.Down2Excel({ HiddenColumn:1,TreeLevel:false,SheetName:"ProcessingStatus"});
			}
			break;	
		case "btn1_Handling_Costs": 
			var cgo_clm_no=frm.cgo_clm_no.value;
			popupHandlingCost(cgo_clm_no);
			break;			
	}
}
function keypressCgoClmNo() {
 	var obj=ComGetEvent();
    switch(ComGetEvent("name")) {    
    case "cgo_clm_no":
    	if (obj.value.length == 10) {    		
    		doActionIBSheet(SEARCHLIST01);
    	}
    	break;
	}
}
 function keypressFormat() {
  	var obj=ComGetEvent();
 	if(obj.dataformat == null) return;
 	window.defaultStatus=obj.dataformat;
     switch(ComGetEvent("name")) {    
     case "cgo_clm_no":
     case "inv_ofc_cd":
     	KeyOnlyUpper();
      	break;
     case "inv_net_amt":
     case "inv_vat_amt":
     case "whld_tax_amt":
    	 ComKeyOnlyNumber();
      	break;     	
	}
 }
  function keydownEnter() {
  	if (event.keyCode != 13) {
  		return;
  	}
  	var obj=ComGetEvent();
     switch(ComGetEvent("name")) {    
     case "cgo_clm_no":
     	if (obj == null || 
     			obj.value.length != 10 ) {
     		return;
     	}
 		doActionIBSheet(SEARCHLIST01);
     	break;          	
 	}	  
  } 
   /**
    * HTML Control Foucs in
    */
   function obj_activate(){
       ComClearSeparator(ComGetEvent());    
   }
   /**
    * HTML Control Focus out
    **/    
   function obj_deactivate() {
   	switch (ComGetEvent("name")) {
   	case "inv_eff_dt":
   		ComChkObjValid(frm.inv_eff_dt)			
   		break;		
    case "inv_net_amt":
    case "inv_vat_amt":
    case "whld_tax_amt":		
   		ComChkObjValid(ComGetEvent());
   		break;   		
   	}
   } 
/**
* The function called when OnDbClick event on Sheet1 triggered 
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
*/
function sheet1_OnDblClick(sheet, row, col) {
var cgoClmPayNo=sheet1.GetCellValue(row , "cgo_clm_pay_no");
	frm.cgo_clm_pay_no.value=cgoClmPayNo;
	doActionIBSheet(SEARCHLIST02);
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;		
 		var sXml=sheet1.GetSearchData("CPS_CNI_0045GS.do", FormQueryString(frm));
		var cgoClmNo=frm.cgo_clm_no.value;			
		ComResetAll();
		frm.cgo_clm_no.value=cgoClmNo;
		sheet1.LoadSearchData(sXml,{Sync:1} );
		var list=SheetXml2ListMap(sXml);
		if (list.length > 0) {
			var vo=list[0];
			frm.clm_area_cd.value=vo["clm_area_cd"];
			frm.hdlr_ofc_cd.value=vo["hdlr_ofc_cd"];
			frm.hdlr_usr_id.value=vo["hdlr_usr_id"];			
			frm.cgo_clm_sts_nm.value=vo["cgo_clm_sts_nm"];
			frm.cgo_clm_div_nm.value=vo["cgo_clm_div_nm"];			
		} else {
			frm.cgo_clm_no.value="";
			frm.cgo_clm_no.focus();
		}
		// --------------------------------
		// setting authority 
		// --------------------------------
		setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save");
	} else if (sAction == SEARCHLIST02) {
		frm.f_cmd.value=SEARCHLIST02;		
 		var sXml=sheet1.GetSearchData("CPS_CNI_0045GS.do", FormQueryString(frm));
		// ------------------------------------------------------------
		// Case Vo
		// ------------------------------------------------------------		
		var list=SheetXml2ListMap(sXml);
		if (list.length > 0) {
			var vo=list[0];
			frm.inv_no.value=vo["inv_no"];
			frm.inv_dt.value=fmDate(vo["inv_dt"]);
			//Rcvd Date
			frm.pay_dt.value=fmDate(vo["pay_dt"]);
			frm.clm_cost_tp_nm.value=vo["clm_cost_tp_nm"];
			frm.clm_cost_tp_cd.value=vo["clm_cost_tp_cd"];
			frm.acct_cd.value   =vo["acct_cd"];
			if (ComIsNull(frm.acct_cd.value)) {
				var clmCostTpCd=vo["clm_cost_tp_cd"];
				var acctCd="";
				// legal standard
				if (clmCostTpCd == "LS" || clmCostTpCd == "LC" ) {
					//lawyers fee
					acctCd="564651";
				// survey , settlement , other standard
				} else if (clmCostTpCd == "SS" || 
						clmCostTpCd == "SC" ||
						clmCostTpCd == "TS" ||
						clmCostTpCd == "TC" ||
						clmCostTpCd == "OS" ||
						clmCostTpCd == "OC") {
					// Cargo claims due to cargo
					acctCd="512541";
			    // survey ,legal, settlement , other prepayment					
				} else if (clmCostTpCd == "SP" || 
						clmCostTpCd == "LP" ||
						clmCostTpCd == "TP" ||
						clmCostTpCd == "OP") {
					// Cargo claims due to cargo
					acctCd="113321";
				}
				frm.acct_cd.value=acctCd;
			}
			frm.inv_ofc_cd.value=vo["inv_ofc_cd"];		
			if (ComIsNull(frm.inv_ofc_cd.value)) {
				frm.inv_ofc_cd.value=frm.hdlr_ofc_cd.value;
			}
			frm.clm_pty_abbr_nm.value=vo["clm_pty_abbr_nm"];
			frm.pty_nm.value    =vo["pty_nm"];
			frm.cost_ofc_cd.value=vo["cost_ofc_cd"];			
			frm.trnk_ref_vvd_no.value=vo["trnk_ref_vvd_no"];
			frm.slan_cd.value=vo["slan_cd"];
			frm.vndr_seq.value  =vo["vndr_seq"];
			frm.vndr_lgl_eng_nm.value=vo["vndr_lgl_eng_nm"];
			frm.ap_ctrl_ofc_cd.value=vo["ap_ctrl_ofc_cd"];
			frm.locl_curr_cd.value=vo["locl_curr_cd"];
			frm.inv_amt.value   =ComAddComma(vo["inv_amt"]);		
			frm.inv_net_amt.value=ComAddComma(vo["inv_net_amt"]);
			frm.cost_desc.value =vo["cost_desc"];
			frm.inv_vat_amt.value=ComAddComma(vo["inv_vat_amt"]);
			frm.whld_tax_amt.value=ComAddComma(vo["whld_tax_amt"]);
			frm.inv_rgst_no.value=vo["inv_rgst_no"];
			frm.cre_dt.value    =fmDate(vo["cre_dt"]);
			frm.inv_eff_dt.value=fmDate(vo["inv_eff_dt"]);
			frm.vndr_term_nm.value=vo["vndr_term_nm"];
			frm.inv_rgst_seq.value=vo["inv_rgst_seq"];
			//activating in case of X
			frm.inv_sts_cd.value=vo["inv_sts_cd"];
			if (ComIsNull(frm.vndr_seq.value)) {
				ComShowCodeMessage("CNI00111");
				ComBtnDisable("btn1_Save");
				return;
			}
			if (!ComIsNull(frm.inv_rgst_no.value) && frm.inv_sts_cd.value != "X") {				
				ComBtnDisable("btn1_Save");				
			} else {
				// --------------------------------
				// setting authority 
				// --------------------------------
				setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save");			
			}			
		}
	} else if (sAction == MULTI) {
		frm.f_cmd.value=MULTI;
 		var sXml=sheet1.GetSaveData("CPS_CNI_0045GS.do", FormQueryString(frm));
		var error=ComGetEtcData(sXml , "ERROR");
		// in case of not existing cost office
		if (error == "1") {
			// in case of not existing cost office
			ComShowCodeMessage("CNI00020" , "Cost Office");
		} else if (error == "2") {
			// in case of not existing Revenue VVD 
			ComShowCodeMessage("CNI00020" , "Revenue VVD");
		} else if (error == "N") {
			//retrieving
			doActionIBSheet(SEARCHLIST02);
		} else {
 			sheet1.LoadSaveData(sXml);
		}
	} 
}

function cgo_clm_no_change(){
	doActionIBSheet(SEARCHLIST01);
}
