/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0015.js
 *@FileTitle : [CPS_CNI_0015] Indemnity Claim
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.10.22 박제성
 * 1.0 Creation
=========================================================*/
/**
 * [CPS_CNI_0015] Indemnity Claim
 * @extends
 * @class Indemnity Claim 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // initializing       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
var roeType=null;
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
function loadPage() {
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
    // ClaimNo 가 없을경우 권한
	setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn1_Cancel");
	if(frm.cgo_clm_no.value.length == 10){
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
	
	ComSetFocus(frm.cgo_clm_no);    	
}
/**
* registering initial event 
*/
function initControl() {
   //keypress
//   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   //keydown
//   axon_event.addListenerForm ('keydown', 'obj_keydown', frm);
   //key up
//   axon_event.addListenerForm('keyup', 'obj_keyup', frm); 
   // focus in
   axon_event.addListenerForm('blur', 'obj_deactivate',  frm);
   // focus out
 //  axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;	
	
		switch (sheetObj.id) {
			case "sheet1":
			    with(sheetObj){
		        if (location.hostname != "") {
		      }
		      var HeadTitle1="";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		       
		      InitColumns(cols);

		      SetWaitImageVisible(0);
		      SetEditable(1);
            }
		break;	
	}
}
// ===================================================================================
// Private function
// ===================================================================================
// 달력 화면 표시 공통  함수
function calendarDisplay (pInputObj){
	var vCal=new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(pInputObj, 'yyyy-MM-dd');
}
/**
 * setting Location
 */
 function setCurrency(rowArray) { 
    frm.labl_pty_dmnd_curr_cd.value=rowArray[0][2];
	if(rowArray[0][2] == "USD"){
		frm.labl_pty_xch_rt.value="1.00000";
	}
 }
 function setLoclCurrency(rowArray) { 
    frm.labl_pty_rcvr_locl_curr_cd.value=rowArray[0][2];
	if(rowArray[0][2] == "USD"){
		frm.labl_pty_rcvr_locl_xch_rt.value="1.00000";
	}
 }
 /**
 * USD 일경우 exchange rate 1.00000 설정
 */
 function setXchRt() { 
	if(frm.labl_pty_dmnd_curr_cd.value == "USD"){
		frm.labl_pty_xch_rt.value="1.00000";
	}
 }
 function setLoclXchRt() { 
		if(frm.labl_pty_rcvr_locl_curr_cd.value == "USD"){
			frm.labl_pty_rcvr_locl_xch_rt.value="1.00000";
		}
	 }
  /**
 * ROE 입력후 labl_pty_dmnd_usd_amt 설정
 * USD 항목에 계산값 Setup = ( Survey Fee / R.O.E )
 * 소수점 세자리에서 반올림.
 * onblur / enter / save 버튼 눌렀을때
 */
 function setDmndUsdAmt() { 
	var labl_pty_dmnd_amt=frm.labl_pty_dmnd_amt.value;
	var labl_pty_xch_rt=frm.labl_pty_xch_rt.value;
	var tmpUsdAmt="";
	var tmpUsdAmt2="";
	if( labl_pty_xch_rt.indexOf('.0')==0 ){
		return;
	}
	if(labl_pty_xch_rt != "" && labl_pty_xch_rt != "0"){
		var floatLoclAmt=parseFloat(ComReplaceStr(labl_pty_dmnd_amt,",",""));//콤마제거
        var floatXchRt=parseFloat(ComReplaceStr(labl_pty_xch_rt,",",""));
		tmpUsdAmt=roundPrecision(floatLoclAmt / floatXchRt,2);
		frm.labl_pty_dmnd_usd_amt.value=tmpUsdAmt;
		tmpUsdAmt2=ComAddComma2(frm.labl_pty_dmnd_usd_amt.value,"#,###.00");//변수에 comma를 처리하려고 했으나 안됨.
		frm.labl_pty_dmnd_usd_amt.value=tmpUsdAmt2;//콤마 format 적용.
	}else{
		frm.labl_pty_dmnd_usd_amt.value="0";
	}
 }
 /**
  * ROE 입력후 labl_pty_rcvr_usd_amt 설정
  * USD 항목에 계산값 Setup = ( Survey Fee / R.O.E )
  * 소수점 세자리에서 반올림.
  * onblur / enter / save 버튼 눌렀을때
  */
  function setRcvrUsdAmt() { 
 	var labl_pty_rcvr_locl_amt=frm.labl_pty_rcvr_locl_amt.value;
 	var labl_pty_rcvr_locl_xch_rt=frm.labl_pty_rcvr_locl_xch_rt.value;
 	var tmpUsdAmt="";
 	var tmpUsdAmt2="";
	if( labl_pty_rcvr_locl_xch_rt.indexOf('.0')==0 ){
		return;
	}
 	if(labl_pty_rcvr_locl_xch_rt != "" && labl_pty_rcvr_locl_xch_rt != "0"){
 		var floatLoclAmt=parseFloat(ComReplaceStr(labl_pty_rcvr_locl_amt,",",""));//콤마제거
        var floatXchRt=parseFloat(ComReplaceStr(labl_pty_rcvr_locl_xch_rt,",",""));
        if(floatXchRt == 0) {
        	tmpUsdAmt= "0.00";
        }
        else {
        	tmpUsdAmt=roundPrecision(floatLoclAmt / floatXchRt,2);
        }
 		frm.labl_pty_rcvr_usd_amt.value=tmpUsdAmt;
 		tmpUsdAmt2=ComAddComma2(frm.labl_pty_rcvr_usd_amt.value,"#,###.00");//변수에 comma를 처리하려고 했으나 안됨.
 		frm.labl_pty_rcvr_usd_amt.value=tmpUsdAmt2;//콤마 format 적용.
 	}else{
 		frm.labl_pty_dmnd_usd_amt.value="0";
 	}
  }
  /**
   *  팝업에서 Call 하는 함수
   */
  function setMainCodeInquiry(partyVo) {
  	frm.clm_pty_no.value=partyVo.clm_pty_no;
  	frm.clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
  	frm.pty_nm.value=partyVo.pty_nm;
  	setLpTbDate();
   } 
function addComma2(obj,sFormat)
{
	try {
		//첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
		var sVal=getArgValue(obj);
		switch(sFormat)
		{
			case "#,###" :
					return ComAddComma(sVal);
			case "#,###.0" :
					p=sVal.split(".");
					p[0]=ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".0";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00" :
					p=sVal.split(".");
					p[0]=ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".00";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00000" :
					p=sVal.split(".");
					p[0]=ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".00000";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}
function setLpTbDate() {
	var sts=frm.clm_misc_cd.value;
	var dos_dt=frm.cgo_clm_stl_dt.value;
	var tm_bar_dt=frm.tm_bar_dt.value;
	var pty_nm=frm.clm_pty_abbr_nm.value;
	if( sts != 'C' && dos_dt != '' && tm_bar_dt == '' && pty_nm != '' ){
		var tb_dt=ComGetDateAdd(dos_dt,"D", 90); // 90일 후 날짜 	
		frm.tm_bar_dt.value=tb_dt;
	}
}
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn1_Retrieve":
				var cgoClmNo=frm.cgo_clm_no.value;
				if (ComIsNull(cgoClmNo)) {
					//msgs["CNI00018"] = "Please select {?msg1}";
					ComShowCodeMessage("CNI00009" , "Claim No");
					ComSetFocus(frm.cgo_clm_no);
					return;
				}
				doActionIBSheet(SEARCHLIST01);					
				break;	
			case "btn1_New":
				//CNI00015 Do you want to initialize?
				if (ComShowCodeConfirm("CNI00015") ) {
					ComResetAll();
					resetHiddenField(frm);
					frm.cgo_clm_no.value="";
					ComSetFocus(frm.cgo_clm_no);
				}
				break;
			case "btn1_Save":
				frm.f_cmd.value=MULTI;
				if (!chkAmount(frm.labl_pty_dmnd_amt, frm.labl_pty_dmnd_curr_cd, frm.labl_pty_fmal_clm_dt, frm.labl_pty_xch_rt, "LP Claim Amount", "LP DOF")) return;
				if (!chkAmount(frm.labl_pty_rcvr_locl_amt, frm.labl_pty_rcvr_locl_curr_cd, frm.labl_pty_rcvr_dt, frm.labl_pty_rcvr_locl_xch_rt, "LP Recovered Amount", "LP DOR")) return;
				if (frm.labl_pty_rcvr_locl_amt.value != '' && parseFloat(frm.labl_pty_rcvr_locl_amt.value.trimAll(",")) > 0 ){
					if ( frm.labl_pty_dmnd_amt.value == '' || parseFloat(frm.labl_pty_dmnd_amt.value.trimAll(",") ) == 0 ) {
						ComAlertFocus(frm.labl_pty_dmnd_amt, ComGetMsg('CNI09028',"LP Claim Amount"));
						return ;						
					}
				}
				chkPointZero();
				if(ComChkValid(frm)) {
					//CNI00012(Do you want to save changes?)
					if (ComShowCodeConfirm("CNI00012")) {
						doActionIBSheet(MULTI);
						setRcvrUsdAmt();
					}
				}			
				break; 
			case "btn1_File_Upload":				
				var cgoClmNo=frm.cgo_clm_no.value;
				if (ComIsNull(cgoClmNo)) {
					//ComShowCodeMessage("CNI00009" , "Claim No.");
					ComShowMessage("Please use after retrieve or save");//CNI00103
				}else{
					popupFileUpload("001501" , cgoClmNo);
				}
				break;
			case "btn1_Cancel":				
				var cd=frm.clm_misc_cd.value;
				frm.f_cmd.value=MULTI01;	
				chkPointZero();
				if(ComChkValid(frm)) {
					//CNI09025(Do you really want to cancel this?)
					if (ComShowCodeConfirm("CNI09025")) {
						doActionIBSheet(MULTI01);
					}
				}			
				break;	
			case "btn1_Payment":
				var cgoClmNo=frm.cgo_clm_no.value;	
				popupPayment(cgoClmNo);
				break;
			case "btn1_Handling_Costs":
				var cgoClmNo=frm.cgo_clm_no.value;
				popupHandlingCost(cgoClmNo);
				break;	
			case "btn1_Handler":
				var cgoClmNo=frm.cgo_clm_no.value;	
				popupHandlerHistory(cgoClmNo);
				break;
			case "btns_liable_party":
				popupMainCodeInquiry();
				break;	
			case "btns_hndl_ofc_cd":
				popupOfficeCode();
				break;		
			case "btns_style":
				var clmPtyNo=frm.clm_pty_no.value;
				if (ComIsNull(clmPtyNo)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Liable Party");
					ComSetFocus(frm.clm_pty_abbr_nm);
					return;
				}
				popupMainCodeView(clmPtyNo);
				break;	
			case "btns_currency":
				//공통팝업 Currency 호출
				var display="1,0,1,1,1";
				ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 700, 450, "setCurrency", display);
				break;
			case "btns_currency2":
				//공통팝업 Currency 호출
				var display="1,0,1,1,1";
				ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 700, 450, "setLoclCurrency", display);
				break;	
			case "btns_roe1":
				var curr_cd=frm.labl_pty_dmnd_curr_cd.value;
				if (ComIsNull(curr_cd)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Currency Code");
					ComSetFocus(frm.labl_pty_dmnd_curr_cd);
					return;
				}
				var lp_dt=frm.labl_pty_fmal_clm_dt.value;
				if (ComIsNull(lp_dt)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "LP DOF");
					ComSetFocus(frm.labl_pty_fmal_clm_dt);
					return;
				}
				//공통팝업 ROE 호출
				var yrMon=ComReplaceStr(frm.labl_pty_fmal_clm_dt.value,"-","").substring(0,6);
				roeType=1;
				popupRateOfExchange(curr_cd, yrMon);
				break;
			case "btns_roe2":
				var curr_cd=frm.labl_pty_rcvr_locl_curr_cd.value;
				if (ComIsNull(curr_cd)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Currency Code");
					ComSetFocus(frm.labl_pty_rcvr_locl_curr_cd);
					return;
				}
				var lp_dt=frm.labl_pty_rcvr_dt.value;
				if (ComIsNull(lp_dt)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "LP DOR");
					ComSetFocus(frm.labl_pty_rcvr_dt);
					return;
				}
				//공통팝업 ROE 호출
				var yrMon=ComReplaceStr(frm.labl_pty_rcvr_dt.value,"-","").substring(0,6);
				roeType=2;
				popupRateOfExchange(curr_cd, yrMon);
				break;
			//-----------------[달력 Start]------------------//		
			case "btns_labl_pty_prlm_clm_ntfy_dt":
				calendarDisplay(frm.labl_pty_prlm_clm_ntfy_dt);
	            break;
			case "btns_labl_pty_fmal_clm_dt":
				calendarDisplay(frm.labl_pty_fmal_clm_dt);
	            break;
			case "btns_labl_pty_rcvr_dt":
				calendarDisplay(frm.labl_pty_rcvr_dt);
	            break;
			case "btns_tm_bar_dt":
				calendarDisplay(frm.tm_bar_dt);
	            break;	   
	        //-----------------[달력 End]------------------//
			case "btns_TB_Date":
				popupImpendingTBClaim();
				break;
			// Booking Preview	
			case "btn_BLPreview":
				var blNo=frm.cgo_clm_ref_bl_no.value;
				if (blNo == "") {
					ComShowMessage("Please use after retrieve ");					
					return false;
				}
				doActionIBSheet(SEARCHLIST02);
				var bkgNo=frm.bkg_no.value;
				if (bkgNo == "") {
					ComShowCodeMessage("CNI00013");
					return false;
				}
				rdOpen(bkgNo);					
            	break;	
		} // end switch
}
/**
 * HTML Control KeyPress event
 */
function obj_keypress() {
    switch (ComGetEvent("name")) {
    	case "labl_pty_dmnd_amt":
			ComKeyOnlyNumber(ComGetEvent(), ".");
			break;
		case "labl_pty_dmnd_curr_cd":
			ComKeyOnlyAlphabet('upper');
			break;
		case "labl_pty_xch_rt":
			ComKeyOnlyNumber(ComGetEvent(), ".");
			break;
		case "labl_pty_rcvr_locl_amt":
			ComKeyOnlyNumber(ComGetEvent(), ".");
			break;
		case "labl_pty_rcvr_locl_curr_cd":
			ComKeyOnlyAlphabet('upper');
			break;
		case "labl_pty_rcvr_locl_xch_rt":
			ComKeyOnlyNumber(ComGetEvent(), ".");
			break;	
		case "hndl_ofc_cd":
			ComKeyOnlyAlphabet('upper');
			break;				
	}
}
 /**
  * HTML Control KeyDowm event
  */
 function obj_keydown() {	  
	 if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;	  
     switch (ComGetEvent("name")) {    
 		case "cgo_clm_no":
 			break;
 	}
 }
  /**
   * HTML Control KeyUp event
   */
  function obj_keyup() {	   
	 if((ComGetEvent("keycode") >= 37)&&(ComGetEvent("keycode") <= 40)) return;
      switch (ComGetEvent("name")) {    
  		case "cgo_clm_no":  			
  			if(frm.cgo_clm_no.value.length == 10){
  				doActionIBSheet(SEARCHLIST01);
  			}
  			break;
  	}
  }  
 /**
  * HTML Control Focus out
  **/
 function obj_deactivate() {	 
 	var frm=document.form;
 	switch (ComGetEvent("name")) {
	case "labl_pty_dmnd_curr_cd":	//CURR_CD수정시
		// CURR_CD수정시  svyr_fee_usd_amt 설정
		if( frm.labl_pty_xch_rt.value.indexOf('.0')==0 
			|| frm.labl_pty_dmnd_amt.value.indexOf('.0')==0 ){ 				
			return;
		}
	    setXchRt();
		setDmndUsdAmt();
		ComAddSeparator(frm.labl_pty_dmnd_amt,"float");
	break;
 	case "labl_pty_dmnd_amt":
 		// LP Claim Amount 입력후 svyr_fee_usd_amt 설정
 		if( frm.labl_pty_xch_rt.value.indexOf('.0')==0 
 			|| frm.labl_pty_dmnd_amt.value.indexOf('.0')==0 ){ 				
 			return;
 		}
	    setXchRt();
 		setDmndUsdAmt();
 		ComAddSeparator(frm.labl_pty_dmnd_amt,"float");
 		break;
 	case "labl_pty_xch_rt":	
 		// ROE 입력후 svyr_fee_usd_amt 설정
 		if( frm.labl_pty_xch_rt.value.indexOf('.0')==0 
 				|| frm.labl_pty_dmnd_amt.value.indexOf('.0')==0 ){ 			
 			return;
 		}
	    setXchRt();
 		setDmndUsdAmt();
 		ComAddSeparator(frm.labl_pty_dmnd_amt,"float");
 		break;
 	case "labl_pty_rcvr_locl_curr_cd":	
 		// CURR_CD수정시 svyr_fee_usd_amt 설정
 		if( frm.labl_pty_rcvr_locl_amt.value.indexOf('.0')==0 
 			|| frm.labl_pty_rcvr_locl_xch_rt.value.indexOf('.0')==0 ){ 				
 			return;
 		}
 		setLoclXchRt();
 		setRcvrUsdAmt();
 		ComAddSeparator(frm.labl_pty_rcvr_locl_amt,"float");
 		break;	 		
 	case "labl_pty_rcvr_locl_amt":	
 		// LP Recovered Amount 입력후 svyr_fee_usd_amt 설정
 		if( frm.labl_pty_rcvr_locl_amt.value.indexOf('.0')==0 
 			|| frm.labl_pty_rcvr_locl_xch_rt.value.indexOf('.0')==0 ){ 			
 			return;
 		}
 		setLoclXchRt();
 		setRcvrUsdAmt();
 		ComAddSeparator(frm.labl_pty_rcvr_locl_amt,"float");
 		break;	
 	case "labl_pty_rcvr_locl_xch_rt":	
 		// ROE 입력후 svyr_fee_usd_amt 설정
 		if( frm.labl_pty_rcvr_locl_amt.value.indexOf('.0')==0 
 			|| frm.labl_pty_rcvr_locl_xch_rt.value.indexOf('.0')==0 ){ 				
 			return;
 		}
 		setLoclXchRt();
 		setRcvrUsdAmt();
 		ComAddSeparator(frm.labl_pty_rcvr_locl_amt,"float");
 		break;	
 	default:
 		ComChkObjValid(ComGetEvent());
 	}
 }
/**
 * HTML Control Foucs in
 */
function obj_activate(){
 	var frm=document.form;
 	switch (ComGetEvent("name")) {
	case "labl_pty_fmal_clm_dt":
 		//if(preSaveCheck()) return;
 		break;
 	case "labl_pty_dmnd_amt":
 		//if(preSaveCheck()) return;	
 		break;
	default:
		ComClearSeparator(ComGetEvent());
 	}
}
function preSaveCheck(){
	var val1=frm.clm_pty_abbr_nm.value;
	var val2=frm.hndl_ofc_cd.value;
	var val3=frm.labl_pty_prlm_clm_ntfy_dt.value;
	if((val1='')||(val2=='')||(val3=='')) {
		ComShowCodeMessage("CNI00009" , "Liable Party, LP HOFC, LP DON");
		//frm.labl_pty_dmnd_amt.value = '0.00';
		//frm.labl_pty_rcvr_dt.value = '';
		setFocus("labl_pty_clm_rmk");
		return true;
	}
	return false;
}
/**
 * Move Focus in Object
 */
function setFocus(name) {
	ComSetFocus(eval("document.form."+name));
	eval("document.form."+name).select();
}
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * sheet1_OnSearchEnd
 * @param {IBSheet} sheet
 * @param {ErrMsg} ErrMsg
 */
 /*
 function sheet1_OnSearchEnd(sheet, ErrMsg) {
	if(sheet.RowCount()<= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}
 }
 */
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case SEARCHLIST01:
			frm.f_cmd.value=SEARCHLIST01;
 			var sXml=sheet1.GetSearchData("CPS_CNI_0015GS.do", FormQueryString(frm),"",true);
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) {			
				var list=SheetXml2ListMap(arrXml[0]);	
				if (list.length > 0) {
					var liablePartyVO=list[0];					
					frm.cgo_clm_no.value=liablePartyVO["cgo_clm_no"];
					frm.clm_area_cd.value=liablePartyVO["clm_area_cd"];
					frm.hdlr_ofc_cd.value=liablePartyVO["hdlr_ofc_cd"];
					frm.hdlr_usr_id.value=liablePartyVO["hdlr_usr_id"];
					frm.upd_dt.value=liablePartyVO["upd_dt"];
					frm.cgo_clm_inci_no.value=liablePartyVO["cgo_clm_inci_no"];
					frm.crm_voc_no.value=liablePartyVO["crm_voc_no"];
					frm.clm_misc_cd.value=liablePartyVO["clm_misc_cd"];
					frm.clm_misc_nm.value=liablePartyVO["clm_misc_nm"];
					frm.hpc.value=liablePartyVO["hpc"];
					frm.nhp.value=liablePartyVO["nhp"];
					frm.cgo_clm_stl_tp_cd.value=liablePartyVO["cgo_clm_stl_tp_cd"];
					frm.cs_clz_dt.value=liablePartyVO["cs_clz_dt"];
					frm.clm_tm_bar_dt.value=liablePartyVO["clm_tm_bar_dt"];
					frm.smns_sve_date.value=liablePartyVO["smns_sve_dt"];
					frm.cgo_clm_ref_bl_no.value=liablePartyVO["cgo_clm_ref_bl_no"];
					frm.crr_term_cd.value=liablePartyVO["crr_term_cd"];
					frm.por_cd.value=liablePartyVO["por_cd"];
					frm.rct_dt.value=liablePartyVO["rct_dt"];
					frm.pol_cd.value=liablePartyVO["pol_cd"];
					frm.pod_cd.value=liablePartyVO["pod_cd"];
					frm.del_cd.value=liablePartyVO["del_cd"];
					frm.de_dt.value=liablePartyVO["de_dt"];
					frm.cgo_clm_tp_cd.value=liablePartyVO["cgo_clm_tp_cd"];
					frm.mjr_clm_dmg_lss_cd.value=liablePartyVO["mjr_clm_dmg_lss_cd"];
					frm.minr_clm_dmg_lss_cd.value=liablePartyVO["minr_clm_dmg_lss_cd"];
					frm.inci_plc_tp_cd.value=liablePartyVO["inci_plc_tp_cd"];
					frm.inci_occr_dt.value=liablePartyVO["inci_occr_dt"];					
					frm.clm_cgo_tp_cd.value=liablePartyVO["clm_cgo_tp_cd"];				
					frm.cgo_qlty_desc.value=liablePartyVO["cgo_qlty_desc"];												
					frm.clmt_locl_amt.value=ComAddComma2(liablePartyVO["clmt_locl_amt"],"#,###.00");
					frm.clmt_locl_curr_cd.value=liablePartyVO["clmt_locl_curr_cd"];
					frm.fmal_clm_rcv_dt.value=liablePartyVO["fmal_clm_rcv_dt"];
					frm.clmt_locl_xch_rt.value=addComma2( liablePartyVO["clmt_locl_xch_rt"],"#,###.00000");	
					frm.clmt_usd_amt.value=ComAddComma2( liablePartyVO["clmt_usd_amt"],"#,###.00");;					
					frm.cgo_clm_stl_locl_amt.value=ComAddComma2( liablePartyVO["cgo_clm_stl_locl_amt"],"#,###.00");
					frm.cgo_clm_stl_locl_curr_cd.value=liablePartyVO["cgo_clm_stl_locl_curr_cd"];
					frm.cgo_clm_stl_dt.value=liablePartyVO["cgo_clm_stl_dt"];
					frm.cgo_clm_stl_xch_rt.value=addComma2( liablePartyVO["cgo_clm_stl_xch_rt"],"#,###.00000");	
					frm.cgo_clm_stl_usd_amt.value=ComAddComma2( liablePartyVO["cgo_clm_stl_usd_amt"],"#,###.00");					
					frm.clm_pty_no.value=liablePartyVO["clm_pty_no"];
					frm.clm_pty_abbr_nm.value=liablePartyVO["clm_pty_abbr_nm"];				
					frm.pty_nm.value=liablePartyVO["pty_nm"];				
					frm.hndl_ofc_cd.value=liablePartyVO["hndl_ofc_cd"];							
					frm.labl_pty_prlm_clm_ntfy_dt.value=liablePartyVO["labl_pty_prlm_clm_ntfy_dt"];
					frm.tm_bar_dt.value=liablePartyVO["tm_bar_dt"];					
					frm.labl_pty_dmnd_amt.value=ComAddComma2( liablePartyVO["labl_pty_dmnd_amt"],"#,###.00");
					frm.labl_pty_dmnd_curr_cd.value=liablePartyVO["labl_pty_dmnd_curr_cd"];								
					frm.labl_pty_fmal_clm_dt.value=liablePartyVO["labl_pty_fmal_clm_dt"];				
					frm.labl_pty_xch_rt.value=addComma2( liablePartyVO["labl_pty_xch_rt"],"#,###.00000");							
					frm.labl_pty_dmnd_usd_amt.value=ComAddComma2( liablePartyVO["labl_pty_dmnd_usd_amt"],"#,###.00");				
					frm.labl_pty_rcvr_locl_amt.value=ComAddComma2( liablePartyVO["labl_pty_rcvr_locl_amt"],"#,###.00");
					frm.labl_pty_rcvr_locl_curr_cd.value=liablePartyVO["labl_pty_rcvr_locl_curr_cd"];								
					frm.labl_pty_rcvr_dt.value=liablePartyVO["labl_pty_rcvr_dt"];				
					frm.labl_pty_rcvr_locl_xch_rt.value=addComma2( liablePartyVO["labl_pty_rcvr_locl_xch_rt"],"#,###.00000");									
					frm.labl_pty_rcvr_usd_amt.value=ComAddComma2( liablePartyVO["labl_pty_rcvr_usd_amt"],"#,###.00");
					frm.labl_pty_clm_rmk.value=liablePartyVO["labl_pty_clm_rmk"];
					setLpTbDate();
					chkPointZero();
					//Role
					setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn1_Cancel");
					var sts=frm.clm_misc_cd.value;
					if( sts!='R'){
						ComBtnDisable("btn1_Cancel");
					}
					if( sts=='C'){
						ComBtnDisable("btn1_Save");
					}					
					
					setDmndUsdAmt();
					setRcvrUsdAmt();
				}else{
					ComResetAll();
					if(frm.cgo_clm_no.value == ""){
						//msgs["CNI00013"] = "There is no data to search.";
						ComShowCodeMessage("CNI00013");
					}
				}
	        }
			break;
		case SEARCHLIST02:	
			frm.f_cmd.value=SEARCHLIST02;
 			var sXml=sheet1.GetSearchData("CPS_CNI_0015GS.do", FormQueryString(frm),"",true);
			var arrXml=sXml.split("|$$|");
			// ------------------------------------------------------------
			// Booking No 설정
			// ------------------------------------------------------------
			if (arrXml.length > 0) {
				var list=SheetXml2ListMap(arrXml[0]);	
				if (list.length > 0) {
					var dataVO=list[0];					
					frm.bkg_no.value=dataVO["bkg_no"];					
				}
			} else {
				frm.bkg_no.value='';
				//ComShowCodeMessage("CNI00013");
			}
			break;
		case MULTI:
			frm.f_cmd.value=MULTI;
			setDmndUsdAmt();
			setRcvrUsdAmt();
			//sepatator 제거
			frm.labl_pty_prlm_clm_ntfy_dt.value=ComReplaceStr(frm.labl_pty_prlm_clm_ntfy_dt,'-','');
			frm.tm_bar_dt.value=ComReplaceStr(frm.tm_bar_dt,'-','');
			frm.labl_pty_fmal_clm_dt.value=ComReplaceStr(frm.labl_pty_fmal_clm_dt,'-','');
			frm.labl_pty_rcvr_dt.value=ComReplaceStr(frm.labl_pty_rcvr_dt,'-','');
			frm.labl_pty_dmnd_amt.value=ComReplaceStr(frm.labl_pty_dmnd_amt,',','');
			frm.labl_pty_xch_rt.value=ComReplaceStr(frm.labl_pty_xch_rt,',','');
			frm.labl_pty_dmnd_usd_amt.value=ComReplaceStr(frm.labl_pty_dmnd_usd_amt,',','');
			frm.labl_pty_rcvr_locl_amt.value=ComReplaceStr(frm.labl_pty_rcvr_locl_amt,',','');
			frm.labl_pty_rcvr_locl_xch_rt.value=ComReplaceStr(frm.labl_pty_rcvr_locl_xch_rt,',','');
			frm.labl_pty_rcvr_usd_amt.value=ComReplaceStr(frm.labl_pty_rcvr_usd_amt,',','');
			frm.cgo_clm_stl_usd_amt.value=ComReplaceStr(frm.cgo_clm_stl_usd_amt,',','');
			var param="";
			param += FormQueryString(frm);			
			var saveString=sheet1.GetSaveString();
			param += "&" + saveString;	
 			var sXml=sheet1.GetSaveData("CPS_CNI_0015GS.do", param);
 			sheet1.LoadSaveData(sXml);
			//main에 없는 clm_no 를 입력하려고 할경우 에러처리하고 재조회하지 않는다.
			var manageStr="";
			manageStr=ComGetEtcData(sXml, "MANAGE_STR");	
			if(manageStr == "N"){
				ComResetAll();
			}
			if(manageStr == "Y"){
				//재조회
				doActionIBSheet(SEARCHLIST01);
			}			
			break;
		case MULTI01:    // CANCEL
			frm.f_cmd.value=MULTI01;		
			//sepatator 제거
			frm.labl_pty_prlm_clm_ntfy_dt.value=ComReplaceStr(frm.labl_pty_prlm_clm_ntfy_dt,'-','');
			frm.tm_bar_dt.value=ComReplaceStr(frm.tm_bar_dt,'-','');
			frm.labl_pty_fmal_clm_dt.value=ComReplaceStr(frm.labl_pty_fmal_clm_dt,'-','');
			frm.labl_pty_rcvr_dt.value=ComReplaceStr(frm.labl_pty_rcvr_dt,'-','');
			frm.labl_pty_dmnd_amt.value=ComReplaceStr(frm.labl_pty_dmnd_amt,',','');
			frm.labl_pty_xch_rt.value=ComReplaceStr(frm.labl_pty_xch_rt,',','');
			frm.labl_pty_dmnd_usd_amt.value=ComReplaceStr(frm.labl_pty_dmnd_usd_amt,',','');
			frm.labl_pty_rcvr_locl_amt.value=ComReplaceStr(frm.labl_pty_rcvr_locl_amt,',','');
			frm.labl_pty_rcvr_locl_xch_rt.value=ComReplaceStr(frm.labl_pty_rcvr_locl_xch_rt,',','');
			frm.labl_pty_rcvr_usd_amt.value=ComReplaceStr(frm.labl_pty_rcvr_usd_amt,',','');
			var param="";
			param += FormQueryString(frm);
			var saveString=sheet1.GetSaveString();
			param += "&" + saveString;	
 			var sXml=sheet1.GetSaveData("CPS_CNI_0015GS.do", param);
 			sheet1.LoadSaveData(sXml);
			//main에 없는 clm_no 를 입력하려고 할경우 에러처리하고 재조회하지 않는다.
			//var manageStr ="";
			//manageStr = ComGetEtcData(sXml, "MANAGE_STR");	
			//재조회
			doActionIBSheet(SEARCHLIST01);
			break;	
	} //end of switch
}
function setOfficeCode(ofcCd){
	frm.hndl_ofc_cd.value=ofcCd;
}
/**
* ROE 팝업에서 호출하는 함수
*/
function setCurrencyROE(xchRtVo) {
	if(roeType==1){
		frm.labl_pty_dmnd_curr_cd.value=xchRtVo.curr_cd;
		frm.labl_pty_xch_rt.value=xchRtVo.usd_locl_xch_rt;
		setDmndUsdAmt();
	}else if(roeType==2){
		frm.labl_pty_rcvr_locl_curr_cd.value=xchRtVo.curr_cd;
		frm.labl_pty_rcvr_locl_xch_rt.value=xchRtVo.usd_locl_xch_rt;
		setRcvrUsdAmt();	
	}
} 
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
	}
	return true;
}
function chkAmount(objLoclAmt, objCurrCd, objInputDt, objXchRt, msg1, msg2) {
	var loclAmt=cniParseFloat(objLoclAmt);
	var xchRt=cniParseFloat(objXchRt);
	var currCd=objCurrCd.value.trim();
	var inputDt=objInputDt.value.trim();
	if (loclAmt == 0 && ComIsNull(currCd) && ComIsNull(inputDt) && xchRt == 0) {
		return true;
	} else if (loclAmt != 0 && !ComIsNull(currCd) && !ComIsNull(inputDt) && xchRt != 0) {
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
function chkPointZero(){
	if( (frm.labl_pty_dmnd_amt.value.indexOf('.0')==0) || (frm.labl_pty_dmnd_amt.value == "") ){ 			
		frm.labl_pty_dmnd_amt.value=0;
 	}
	if( (frm.labl_pty_xch_rt.value.indexOf('.0')==0) || (frm.labl_pty_xch_rt.value == "") ){ 			
		frm.labl_pty_xch_rt.value=0;
 	}
	if( (frm.labl_pty_dmnd_usd_amt.value.indexOf('.0')==0) || (frm.labl_pty_dmnd_usd_amt.value == "") ){ 			
		frm.labl_pty_dmnd_usd_amt.value=0;
 	}
	if( (frm.labl_pty_rcvr_locl_amt.value.indexOf('.0')==0) || (frm.labl_pty_rcvr_locl_amt.value == "") ){ 			
		frm.labl_pty_rcvr_locl_amt.value=0;
 	}
	if( (frm.labl_pty_rcvr_locl_xch_rt.value.indexOf('.0')==0) || (frm.labl_pty_rcvr_locl_xch_rt.value == "") ){ 			
		frm.labl_pty_rcvr_locl_xch_rt.value=0;
 	}
	if( (frm.labl_pty_rcvr_usd_amt.value.indexOf('.0')==0) || (frm.labl_pty_rcvr_usd_amt.value == "") ){ 			
		frm.labl_pty_rcvr_usd_amt.value=0;
 	}
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
	ComOpenRDPopup('resizable=yes, width=900, height=800');
}
