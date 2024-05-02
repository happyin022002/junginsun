/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0017.js
 *@FileTitle : [CPS_GEM_0017] Insurance Recovery by Case
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
 * ----------------------------------------------------------------------
 * History
 * 2010.11.19 이준범 [CHM-201007224-01] CNI Insurance Claim by Case화면 Save button logic 변경 요청
 * 1) doActionIBSheet()  
 *  - 저장시 insurFmalClmDt(INS DOF) 입력 여부 체크 하고, 미입력시  “Please input “INS DOF!”를 표시하고,
 *    그이후 SAVE 로직은 현행과 동일하게 적용한다. 
 * 2010.11.24 CHM-201007316-01 INS DOF, INS DOR 미입력시도 변경 내역이 저장되며, 
 *            INS DOF, INS DOR, INS Amout 금액이 있는 경우만 Claim status가 변경토록 반영
=========================================================*/

/**
 * [CPS_CNI_0017] Insurance Recovery by Case
 * @extends
 * @class Insurance Recovery by Case 대상 검색 및 금액 입력화면
 */
function cps_cni_0017() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}



// ===================================================================================
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;


// html form
var frm = null;
// Main Code Inquiry 팝업 타입
var type = "";

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}


// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param {string} year 현재년도
 **/
function loadPage(year) {
    //전역 변수 설정 
    frm = document.form;
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    //Form 이벤트 등록
    initControl();
    
    
	ComBtnDisable("btn1_Save");
	ComBtnDisable("btn1_Recovery_Cancel");
	ComBtnDisable("btn1_Case_Close");
	ComBtnDisable("btn1_Recovery_Open");    
    
    //claim party no가 존재하는경우 조회
    if (!ComIsNull(frm.cgo_clm_no.value)) {
    	
    	doActionIBSheet(SEARCHLIST01);
    }	
	

	
    frm.cgo_clm_no.focus();
   
    
}


/**
* Form 이벤트 등록
*/
function initControl() {
	axon_event.addListener('keypress', 'keypressFormat', 'form');	
	axon_event.addListener('keyup', 'keypressCgoClmNo', 'cgo_clm_no');
	axon_event.addListener ('keydown', 'keydownEnter', 'form');
	// focus out
    axon_event.addListenerForm('blur', 'obj_deactivate',  frm);    
    // focus in
    axon_event.addListenerFormat('focus',   'obj_activate',    frm);
}


/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
		  if (location.hostname != "") {
			  	WaitImageVisible = false; 
			  	InitHostInfo(location.hostname, location.port, page_path);
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

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		case "btn1_Retrieve":			
			var cgoClmNo = frm.cgo_clm_no.value;
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
	    		frm.cgo_clm_no.value = "";
	    	}	    	
	        break;	
		case "btn1_Save":
			frm.f_cmd.value = MULTI;		
//			if(ComChkValid(frm)) {
				//CNI00012(Do you want to save changes?)
			if (ComShowCodeConfirm("CNI00012")) {
				doActionIBSheet(MULTI);
			}
//			}			
	        break;
		case "btn1_FileUpload":			
			var cgoClmNo = frm.cgo_clm_no.value;
			if (ComIsNull(cgoClmNo) || cgoClmNo.length != 10 ) {
				//msgs["CNI00009"] = "Please input {?msg1},";
				ComShowCodeMessage("CNI00009" , "Claim No.");
				return;
			}
			
			popupFileUpload("001701" ,cgoClmNo);
			
	        break;	    	
		case "btn1_VVD":
			var trnkRefVvdNo = frm.trnk_ref_vvd_no.value;
			popupInsuranceRecoveryByVVD(trnkRefVvdNo);
			break;	        
		case "btn1_Recovery_Cancel":
			doActionIBSheet(MULTI01);
			break;	        
		case "btn1_Case_Close":
			
			var  mjrClmDmgLssCd = frm.mjr_clm_dmg_lss_cd.value;
			var  cgoClmStsCd = frm.cgo_clm_sts_cd.value;
			
			if (mjrClmDmgLssCd == "UI" ) {
				//msgs["CNI00009"] = "Please input {?msg1},";
				ComShowCodeMessage("CNI00009" , "CODL. Invalid 'Under Investigation' ");
				return;
			}
			doActionIBSheet(MULTI02);
			break;	        
		case "btn1_Recovery_Open":
			doActionIBSheet(MULTI03);
			break;	        
		case "btn1_Payment":
			var cgoClmNo = frm.cgo_clm_no.value;
			popupPayment(cgoClmNo);
			break;
		case "btns_calendar":
			var vCal = new ComCalendar();
			vCal.setDisplayType("date");
			vCal.select(frm.insur_rcvr_dt, "yyyy-MM-dd");
			break;	        
			
			
	}

}


/**
 * HTML Control KeyPress 이벤트 호출
 */
function keypressFormat() {
 	var obj = event.srcElement;
    switch (obj.name) {    
    case "cgo_clm_no":    
    	KeyOnlyUpper();    	
    	break;
	}
}

 
 /**
  * HTML Control KeyPress 이벤트 호출
  */
 function keypressCgoClmNo() {
	  
	if (event.keyCode >= 37 && event.keyCode <= 40) return;
	
  	var obj = event.srcElement;
     switch (obj.name) {    
     case "cgo_clm_no":
     	if (obj.value.length == 10) {
     		doActionIBSheet(SEARCHLIST01);
     		focusOut();
     	}
     	break;
 	}
 }
 
  
 
 
 /**
  * HTML Control KeyDown 이벤트 호출
  */
 function keydownEnter() {
 	 
 	if (event.keyCode != 13) {
 		return;
 	}
 	 
 	var obj = event.srcElement;
    switch (obj.name) {    
    case "cgo_clm_no":
    	
    	if (obj == null || 
    			obj.value.length != 10 ) {
    		return;
    	}
    	

		doActionIBSheet(SEARCHLIST01);
		
		focusOut();

    	break;          	
	}	  
 } 

  
  /**
   * HTML Control Foucs in
   */
  function obj_activate(){
      ComClearSeparator(event.srcElement);    
  }
  
  /**
   * HTML Control Focus out
   **/
  function obj_deactivate() {
  	switch (event.srcElement.name) {
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
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	
	if (sAction == SEARCHLIST01) {		
		frm.f_cmd.value = SEARCHLIST01;		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0017GS.do", FormQueryString(frm));		
		// ------------------------------------------------------------
		// Case Vo
		// ------------------------------------------------------------		
		var list = SheetXml2ListMap(sXml);
		if (list.length > 0) {
			
			var vo = list[0];
			frm.cgo_clm_no.value				    = vo["cgo_clm_no"];
			frm.clm_area_cd.value                   = vo["clm_area_cd"];
			frm.hdlr_ofc_cd.value                   = vo["hdlr_ofc_cd"];
			frm.hdlr_usr_id.value                   = vo["hdlr_usr_id"];
			frm.upd_dt.value                        = fmDate(vo["upd_dt"]);
			frm.trnk_ref_vvd_no.value               = vo["trnk_ref_vvd_no"];
			frm.cgo_clm_sts_cd.value                = vo["cgo_clm_sts_cd"];
			frm.cgo_clm_sts_nm.value                = vo["cgo_clm_sts_nm"];
			frm.cs_clz_dt.value                     = fmDate(vo["cs_clz_dt"]);
			frm.hpd.value                           = vo["hpd"];
			frm.nhp.value                           = vo["nhp"];
			frm.cgo_clm_stl_dt.value                = fmDate(vo["cgo_clm_stl_dt"]);			
			frm.fmal_clm_rcv_dt.value               = fmDate(vo["fmal_clm_rcv_dt"]);
			frm.cgo_clm_stl_tp_cd.value             = vo["cgo_clm_stl_tp_cd"];
			frm.cgo_clm_tp_cd.value                 = vo["cgo_clm_tp_cd"];
			frm.mjr_clm_dmg_lss_cd.value            = vo["mjr_clm_dmg_lss_cd"];
			frm.n3rd_labl_pty_cd.value           = vo["n3rd_labl_pty_cd"];
			frm.inci_plc_tp_cd.value                = vo["inci_plc_tp_cd"];
			frm.inci_occr_dt.value                  = fmDate(vo["inci_occr_dt"]);
			frm.clm_cgo_tp_cd.value                 = vo["clm_cgo_tp_cd"];
			frm.clmt_locl_amt.value                 = ComAddComma(vo["clmt_locl_amt"]);
			frm.clmt_locl_curr_cd.value             = vo["clmt_locl_curr_cd"];
			frm.clmt_locl_xch_rt.value              = ComAddComma(vo["clmt_locl_xch_rt"]);
			frm.clmt_usd_amt.value                  = ComAddComma(vo["clmt_usd_amt"]);
			frm.insur_clm_pty_abbr_nm.value         = vo["insur_clm_pty_abbr_nm"];
			frm.insur_pty_nm.value                  = vo["insur_pty_nm"];
			frm.insur_clm_pty_no.value              = vo["insur_clm_pty_no"];
			frm.cgo_clm_stl_locl_amt.value          = ComAddComma(vo["cgo_clm_stl_locl_amt"]);
			frm.cgo_clm_stl_locl_curr_cd.value      = vo["cgo_clm_stl_locl_curr_cd"];
			frm.cgo_clm_stl_xch_rt.value            = ComAddComma(vo["cgo_clm_stl_xch_rt"]);
			frm.cgo_clm_stl_usd_amt.value           = ComAddComma(vo["cgo_clm_stl_usd_amt"]);
			frm.labl_pty_rcvr_locl_amt.value        = ComAddComma(vo["labl_pty_rcvr_locl_amt"]);
			frm.labl_pty_rcvr_locl_curr_cd.value    = vo["labl_pty_rcvr_locl_curr_cd"];
			frm.labl_pty_rcvr_dt.value              = fmDate(vo["labl_pty_rcvr_dt"]);
			frm.labl_pty_rcvr_locl_xch_rt.value     = ComAddComma(vo["labl_pty_rcvr_locl_xch_rt"]);
			frm.labl_pty_rcvr_usd_amt.value         = ComAddComma(vo["labl_pty_rcvr_usd_amt"]);
			frm.insur_dmnd_amt.value                = ComAddComma(vo["insur_dmnd_amt"]);
			frm.insur_dmnd_curr_cd.value            = vo["insur_dmnd_curr_cd"];
			frm.insur_fmal_clm_dt.value             = fmDate(vo["insur_fmal_clm_dt"]);
			frm.insur_xch_rt.value                  = ComAddComma(vo["insur_xch_rt"]);
			frm.insur_dmnd_usd_amt.value            = ComAddComma(vo["insur_dmnd_usd_amt"]);
			frm.insur_rcvr_dt.value                 = fmDate(vo["insur_rcvr_dt"]);
			frm.insur_rcvr_usd_amt.value            = ComAddComma(vo["insur_rcvr_usd_amt"]);
			frm.insur_rmk.value                     = vo["insur_rmk"];
			frm.rcvr_usd_amt.value                  = ComAddComma(vo["rcvr_usd_amt"]); 
			// -------------------------------------------------
			// close case , cancel 인경우 save 버튼 비활성화
			// -------------------------------------------------			
			var cgoClmStsCd = frm.cgo_clm_sts_cd.value;
			
			
			// --------------------------------
			// 권한설정 
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
				if (equalsRole("CNI04")) {
					ComBtnEnable("btn1_Case_Close");
				} else {
					ComBtnDisable("btn1_Case_Close");
				}
				
				if (equalsRole("CNI05")) {
					ComBtnEnable("btn1_Recovery_Open");
				} else {
					ComBtnDisable("btn1_Recovery_Open");
				}				
			}
		} else {			
			ComResetAll();
    		frm.cgo_clm_no.value = "";    		
			ComBtnDisable("btn1_Save");
			ComBtnDisable("btn1_Recovery_Cancel");
			ComBtnDisable("btn1_Case_Close");
			ComBtnDisable("btn1_Recovery_Open");	    		
			//msgs["CNI00013"] = "There is no data to search.";    		
			ComShowCodeMessage("CNI00013");
			frm.cgo_clm_no.focus();
		}
		
		
	} else if (sAction == MULTI) {
		
		var insurFmalClmDt = frm.insur_fmal_clm_dt.value;
		var insurRcvrDt    = frm.insur_rcvr_dt.value;

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
		
		frm.f_cmd.value = MULTI;
		var param = FormQueryString(frm);
		var sXml = sheet1.GetSearchXml("CPS_CNI_0017GS.do", param);		
		sheet1.LoadSearchXml(sXml);
		doActionIBSheet(SEARCHLIST01);
		
	//[Recovery Cancel] ,[Case Close] ,[Recovery Open] 		
	} else {
		var cgoClmNo = frm.cgo_clm_no.value;
		if (ComIsNull(cgoClmNo)) {
			//msgs["CNI00009"] = "Please input {?msg1},";
			ComShowCodeMessage("CNI00009" , "Claim No.");
			return;
		}		
		frm.f_cmd.value = sAction;
		var param = FormQueryString(frm);
		var sXml = sheet1.GetSearchXml("CPS_CNI_0017GS.do", param);		
		sheet1.LoadSearchXml(sXml);
		doActionIBSheet(SEARCHLIST01);
	}
}

