/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0017.js
*@FileTitle  : [CPS_GEM_0017] Insurance Recovery by Case
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/
/**
 * [CPS_CNI_0017] Insurance Recovery by Case
 * @extends
 * @class Insurance Recovery by Case 대상 검색 및 금액 입력화면
 */

// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
// Main Code Inquiry 팝업 타입
var type="";
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
// ===================================================================================
// initializing 
// ===================================================================================
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
	ComBtnDisable("btn1_Save");
	ComBtnDisable("btn1_Recovery_Cancel");
	ComBtnDisable("btn1_Case_Close");
	ComBtnDisable("btn1_Recovery_Open");    
    //claim party no가 존재하는경우 조회
    if (!ComIsNull(frm.cgo_clm_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    }	
    
    var sXml2=document.form2.sXml.value;	
 	var arrXml=sXml2.split("|$$|");
 	
 	var dataCount=ComGetTotalRows(arrXml[1]);
	if (dataCount > 0) {
		var list=SheetXml2ListMap(arrXml[1]);	
	 	var listVO=list[0];
	 	clmAreaCd=listVO["clm_area_cd"];
	 	ComSetObjValue(frm.clm_area_cd,clmAreaCd );
	} else {
		var popwin=popupClientDefault(); //calling setup display not existing Area Code
		popwin.focus();
	}
   document.getElementById("cgo_clm_no").focus();
    //cgo_clm_no
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
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
            if (location.hostname != "") {
            	SetVisible(false);
            }
            break;
		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
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
			var cgoClmNo=frm.cgo_clm_no.value;
			if (ComIsNull(cgoClmNo)) {
				//msgs["CNI00009"] = "Please input {?msg1},";
				ComShowCodeMessage("CNI00009" , "Claim No.");
				return;
			}
			doActionIBSheet(SEARCHLIST01);
			break;	
	    case "btn1_New":
	    	//msgs["CNI00015"] = "Do you want to initialize?";
	    	if (ComShowCodeConfirm("CNI00015")) {
	    		ComResetAll();
	    		resetHiddenField(frm);
	    		frm.cgo_clm_no.value="";
	    	}	    	
	        break;	
		case "btn1_Save":
			frm.f_cmd.value=MULTI;		
//			if(ComChkValid(frm)) {
				//CNI00012(Do you want to save changes?)
			if (ComShowCodeConfirm("CNI00012")) {
				doActionIBSheet(MULTI);
			}
//			}			
	        break;
		case "btn1_FileUpload":			
			var cgoClmNo=frm.cgo_clm_no.value;
			if (ComIsNull(cgoClmNo) || cgoClmNo.length != 10 ) {
				//msgs["CNI00009"] = "Please input {?msg1},";
				ComShowCodeMessage("CNI00009" , "Claim No.");
				return;
			}
			popupFileUpload("001701" ,cgoClmNo);
	        break;	    	
		case "btn1_VVD":
			var trnkRefVvdNo=frm.trnk_ref_vvd_no.value;
			popupInsuranceRecoveryByVVD(trnkRefVvdNo);
			break;	        
		case "btn1_Recovery_Cancel":
			doActionIBSheet(MULTI01);
			break;	        
		case "btn1_Case_Close":
			doActionIBSheet(MULTI02);
			break;	        
		case "btn1_Recovery_Open":
			doActionIBSheet(MULTI03);
			break;	        
		case "btn1_Payment":
			var cgoClmNo=frm.cgo_clm_no.value;
			popupPayment(cgoClmNo);
			break;
		case "btn1_Handler":
			var cgoClmNo=frm.cgo_clm_no.value;	
			popupHandlerHistory(cgoClmNo);
			break;
		case "btns_calendar":
			var vCal=new ComCalendar();
			vCal.setDisplayType("date");
			vCal.select(frm.insur_rcvr_dt, "yyyy-MM-dd");
			break;	        
	}
}
/**
 * HTML Control KeyPress event
 */
//function keypressFormat() {
// 	var obj=event.srcElement;
//    switch(ComGetEvent("name")) {    
//    case "cgo_clm_no":    
//    	KeyOnlyUpper();    	
//    	break;
//	}
//}
 /**
  * HTML Control KeyPress event
  */
 function keypressCgoClmNo() {
	if (ComGetEvent("keycode") >= 37 && ComGetEvent("keycode") <= 40) return;
     switch (ComGetEvent("name")) {    
     case "cgo_clm_no":
     	if (frm.cgo_clm_no.value.length == 10) {
     		doActionIBSheet(SEARCHLIST01);
     		focusOut();
     	}
     	break;
 	}
 }
 /**
  * HTML Control KeyDown event
  */
// function keydownEnter() {
// 	if (event.keyCode != 13) {
// 		return;
// 	}
// 	var obj=event.srcElement;
//    switch(ComGetEvent("name")) {    
//    case "cgo_clm_no":
//    	if (obj == null || 
//    			obj.value.length != 10 ) {
//    		return;
//    	}
//		doActionIBSheet(SEARCHLIST01);
//		focusOut();
//    	break;          	
//	}	  
// } 
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
  	case "insur_rcvr_dt":
  		if ( !ComChkObjValid(frm.insur_rcvr_dt) ) {			
  			return;
  		}
  		break;  
  	case "insur_rcvr_usd_amt":
  		if ( !ComChkObjValid(frm.insur_rcvr_usd_amt) ) {			
  			return;
  		}
  		break;    		
  	}
  }  
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST01) {		
		frm.f_cmd.value=SEARCHLIST01;		
		var sXml=sheet1.GetSearchData("CPS_CNI_0017GS.do", FormQueryString(frm));
		// ------------------------------------------------------------
		// Case Vo
		// ------------------------------------------------------------		
		var list=SheetXml2ListMap(sXml);
		if (list.length > 0) {
			for(var j=0;j<list.length;j++){
				if(list[j]!=undefined){
					var vo=list[j];
					break;
				}
			}
			frm.cgo_clm_no.value=vo["cgo_clm_no"];
			frm.clm_area_cd.value=vo["clm_area_cd"];
			frm.hdlr_ofc_cd.value=vo["hdlr_ofc_cd"];
			frm.hdlr_usr_id.value=vo["hdlr_usr_id"];
			frm.upd_dt.value    =fmDate(vo["upd_dt"]);
			frm.trnk_ref_vvd_no.value=vo["trnk_ref_vvd_no"];
			frm.cgo_clm_sts_cd.value=vo["cgo_clm_sts_cd"];
			frm.cgo_clm_sts_nm.value=vo["cgo_clm_sts_nm"];
			frm.cs_clz_dt.value =fmDate(vo["cs_clz_dt"]);
			frm.hpd.value       =vo["hpd"];
			frm.nhp.value       =vo["nhp"];
			frm.cgo_clm_stl_dt.value=fmDate(vo["cgo_clm_stl_dt"]);			
			frm.fmal_clm_rcv_dt.value=fmDate(vo["fmal_clm_rcv_dt"]);
			frm.cgo_clm_stl_tp_cd.value=vo["cgo_clm_stl_tp_cd"];
			frm.cgo_clm_tp_cd.value=vo["cgo_clm_tp_cd"];
			frm.mjr_clm_dmg_lss_cd.value=vo["mjr_clm_dmg_lss_cd"];
			frm.minr_clm_dmg_lss_cd.value=vo["minr_clm_dmg_lss_cd"];
			frm.inci_plc_tp_cd.value=vo["inci_plc_tp_cd"];
			frm.inci_occr_dt.value=fmDate(vo["inci_occr_dt"]);
			frm.clm_cgo_tp_cd.value=vo["clm_cgo_tp_cd"];
			frm.clmt_locl_amt.value=ComAddComma(vo["clmt_locl_amt"]);
			frm.clmt_locl_curr_cd.value=vo["clmt_locl_curr_cd"];
			frm.clmt_locl_xch_rt.value=ComAddComma(vo["clmt_locl_xch_rt"]);
			frm.clmt_usd_amt.value=ComAddComma(vo["clmt_usd_amt"]);
			frm.insur_clm_pty_abbr_nm.value=vo["insur_clm_pty_abbr_nm"];
			frm.insur_pty_nm.value=vo["insur_pty_nm"];
			frm.insur_clm_pty_no.value=vo["insur_clm_pty_no"];
			frm.cgo_clm_stl_locl_amt.value=ComAddComma(vo["cgo_clm_stl_locl_amt"]);
			frm.cgo_clm_stl_locl_curr_cd.value=vo["cgo_clm_stl_locl_curr_cd"];
			frm.cgo_clm_stl_xch_rt.value=ComAddComma(vo["cgo_clm_stl_xch_rt"]);
			frm.cgo_clm_stl_usd_amt.value=ComAddComma(vo["cgo_clm_stl_usd_amt"]);
			frm.labl_pty_rcvr_locl_amt.value=ComAddComma(vo["labl_pty_rcvr_locl_amt"]);
			frm.labl_pty_rcvr_locl_curr_cd.value=vo["labl_pty_rcvr_locl_curr_cd"];
			frm.labl_pty_rcvr_dt.value=fmDate(vo["labl_pty_rcvr_dt"]);
			frm.labl_pty_rcvr_locl_xch_rt.value=ComAddComma(vo["labl_pty_rcvr_locl_xch_rt"]);
			frm.labl_pty_rcvr_usd_amt.value=ComAddComma(vo["labl_pty_rcvr_usd_amt"]);
			frm.insur_dmnd_amt.value=ComAddComma(vo["insur_dmnd_amt"]);
			frm.insur_dmnd_curr_cd.value=vo["insur_dmnd_curr_cd"];
			frm.insur_fmal_clm_dt.value=fmDate(vo["insur_fmal_clm_dt"]);
			frm.insur_xch_rt.value=ComAddComma(vo["insur_xch_rt"]);
			frm.insur_dmnd_usd_amt.value=ComAddComma(vo["insur_dmnd_usd_amt"]);
			frm.insur_rcvr_dt.value=fmDate(vo["insur_rcvr_dt"]);
			frm.insur_rcvr_usd_amt.value=ComAddComma(vo["insur_rcvr_usd_amt"]);
			frm.insur_rmk.value =vo["insur_rmk"];
			frm.rcvr_usd_amt.value=ComAddComma(vo["rcvr_usd_amt"]); 
			// -------------------------------------------------
			// close case , cancel 인경우 save 버튼 비활성화
			// -------------------------------------------------			
			var cgoClmStsCd=frm.cgo_clm_sts_cd.value;
			// --------------------------------
			// setting authority 
			// --------------------------------
			ComBtnEnable("btn1_Recovery_Cancel");
			ComBtnEnable("btn1_Case_Close");
			ComBtnEnable("btn1_Recovery_Open");
			setRollBtnCtl(frm.hdlr_usr_id.value, 
					frm.clm_area_cd.value, 
					frm.hdlr_ofc_cd.value, 
					"btn1_Save,btn1_Recovery_Cancel");
			// Close , Cancel  
			if (cgoClmStsCd == "C" ||
					cgoClmStsCd == "X") {
				ComBtnDisable("btn1_Save");
				ComBtnDisable("btn1_Recovery_Cancel");
				ComBtnDisable("btn1_Case_Close");
			// Recovered Insure 
			} else if(cgoClmStsCd == "I" ) {				
				ComBtnDisable("btn1_Recovery_Open");	
			// Indemnity Claim  , Payment & Receipt of Release (화해금/판결금 지불 및 면책각서 수취)
			} else if(cgoClmStsCd == "R" || cgoClmStsCd == "P") {				
				ComBtnDisable("btn1_Recovery_Cancel");				
				ComBtnDisable("btn1_Recovery_Open");
			} else {				
//				if (equalsRole("CNI04")) {
					ComBtnEnable("btn1_Case_Close");
//				} else {
//					ComBtnDisable("btn1_Case_Close");
//				}
//				if (equalsRole("CNI05")) {
					ComBtnEnable("btn1_Recovery_Open");
//				} else {
//					ComBtnDisable("btn1_Recovery_Open");
//				}				
			}
		} else {			
			ComResetAll();
    		frm.cgo_clm_no.value="";    		
			ComBtnDisable("btn1_Save");
			ComBtnDisable("btn1_Recovery_Cancel");
			ComBtnDisable("btn1_Case_Close");
			ComBtnDisable("btn1_Recovery_Open");	    		
			//msgs["CNI00013"] = "There is no data to search.";    		
			ComShowCodeMessage("CNI00013");
			document.getElementById("cgo_clm_no").focus();
		}
	} else if (sAction == MULTI) {
		var insurFmalClmDt=frm.insur_fmal_clm_dt.value;
		var insurRcvrDt=frm.insur_rcvr_dt.value;
// 한종희 2011.11.23		
//		if (ComIsNull(insurFmalClmDt)) {
//			//msgs["CNI00009"] = "Please input {?msg1},";
//			ComShowCodeMessage("CNI00009" , "INS DOF");
////			return;
//		}			
//		if (ComIsNull(insurRcvrDt)) {
//			//msgs["CNI00009"] = "Please input {?msg1},";
//			ComShowCodeMessage("CNI00009" , "INS DOR");
////			return;
//		}	
		frm.f_cmd.value=MULTI;
		var param=FormQueryString(frm);
		var sXml=sheet1.GetSearchData("CPS_CNI_0017GS.do", param);
		sheet1.LoadSearchData(sXml,{Sync:0} );
		doActionIBSheet(SEARCHLIST01);
	//[Recovery Cancel] ,[Case Close] ,[Recovery Open] 		
	} else {
		var cgoClmNo=frm.cgo_clm_no.value;
		if (ComIsNull(cgoClmNo)) {
			//msgs["CNI00009"] = "Please input {?msg1},";
			ComShowCodeMessage("CNI00009" , "Claim No.");
			return;
		}		
		frm.f_cmd.value=sAction;
		var param=FormQueryString(frm);
		var sXml=sheet1.GetSearchData("CPS_CNI_0017GS.do", param);
		sheet1.LoadSearchData(sXml,{Sync:0} );
		doActionIBSheet(SEARCHLIST01);
	}
}
