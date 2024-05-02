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
function cps_cni_0015() {
    this.processButtonClick = processButtonClick;
    this.loadPage = loadPage;
    this.initControl = initControl;
    this.validateForm = validateForm;
}

// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
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
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

// html form
var frm = null;

var roeType = null;

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
function loadPage() {
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
    
    // ClaimNo 가 없을경우 권한
	setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn1_Cancel");

	if(frm.cgo_clm_no.value.length == 10){
		doActionIBSheet(SEARCHLIST01);
	}
	ComSetFocus(frm.cgo_clm_no);    	
}

/**
* Form 이벤트 등록
*/
function initControl() {
   //keypress
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   //keydown
   axon_event.addListenerForm ('keydown', 'obj_keydown', frm);
   //key up
   axon_event.addListenerForm('keyup', 'obj_keyup', frm); 
   // focus in
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   // focus out
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}


/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
			if (location.hostname != "") {
			 	WaitImageVisible = false; 
			 	InitHostInfo(location.hostname, location.port, page_path);
			}
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "";

			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");

			break;		
		}
	}
}

// ===================================================================================
// Private function
// ===================================================================================

// 달력 화면 표시 공통  함수
function calendarDisplay (pInputObj){
	var vCal = new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(pInputObj, 'yyyy-MM-dd');
}


/**
 * Location 설정
 */
 function setCurrency(rowArray) { 
    frm.labl_pty_dmnd_curr_cd.value = rowArray[0][3];
	if(rowArray[0][3] == "USD"){
		frm.labl_pty_xch_rt.value = "1.00000";
	}
 }
 
 function setLoclCurrency(rowArray) { 
    frm.labl_pty_rcvr_locl_curr_cd.value = rowArray[0][3];
	if(rowArray[0][3] == "USD"){
		frm.labl_pty_rcvr_locl_xch_rt.value = "1.00000";
	}
 }
 
 
 /**
 * USD 일경우 exchange rate 1.00000 설정
 */
 function setXchRt() { 
	if(frm.labl_pty_dmnd_curr_cd.value == "USD"){
		frm.labl_pty_xch_rt.value = "1.00000";
	}
 }
 function setLoclXchRt() { 
		if(frm.labl_pty_rcvr_locl_curr_cd.value == "USD"){
			frm.labl_pty_rcvr_locl_xch_rt.value = "1.00000";
		}
	 }
 
  /**
 * ROE 입력후 labl_pty_dmnd_usd_amt 설정
 * USD 항목에 계산값 Setup = ( Survey Fee / R.O.E )
 * 소수점 세자리에서 반올림.
 * onblur / enter / save 버튼 눌렀을때
 */
 function setDmndUsdAmt() { 

	var labl_pty_dmnd_amt = frm.labl_pty_dmnd_amt.value;
	var labl_pty_xch_rt = frm.labl_pty_xch_rt.value;
	var tmpUsdAmt = "";
	var tmpUsdAmt2 = "";

	if( labl_pty_xch_rt.indexOf('.0')==0 ){
		return;
	}

	if(labl_pty_xch_rt != "" && labl_pty_xch_rt != "0"){
		
		var floatLoclAmt = parseFloat(ComReplaceStr(labl_pty_dmnd_amt,",",""));//콤마제거
        var floatXchRt = parseFloat(ComReplaceStr(labl_pty_xch_rt,",",""));
				
		tmpUsdAmt = roundPrecision(floatLoclAmt / floatXchRt,2);
		frm.labl_pty_dmnd_usd_amt.value = tmpUsdAmt;

		tmpUsdAmt2 = ComAddComma2(frm.labl_pty_dmnd_usd_amt.value,"#,###.00");//변수에 comma를 처리하려고 했으나 안됨.
		frm.labl_pty_dmnd_usd_amt.value = tmpUsdAmt2;//콤마 format 적용.
		
	}else{
		frm.labl_pty_dmnd_usd_amt.value = "0";
	}
 }
 
 /**
  * ROE 입력후 labl_pty_rcvr_usd_amt 설정
  * USD 항목에 계산값 Setup = ( Survey Fee / R.O.E )
  * 소수점 세자리에서 반올림.
  * onblur / enter / save 버튼 눌렀을때
  */
  function setRcvrUsdAmt() { 

 	var labl_pty_rcvr_locl_amt = frm.labl_pty_rcvr_locl_amt.value;
 	var labl_pty_rcvr_locl_xch_rt = frm.labl_pty_rcvr_locl_xch_rt.value;
 	var tmpUsdAmt = "";
 	var tmpUsdAmt2 = "";
 	
	if( labl_pty_rcvr_locl_xch_rt.indexOf('.0')==0 ){
		return;
	}

 	if(labl_pty_rcvr_locl_xch_rt != "" && labl_pty_rcvr_locl_xch_rt != "0"){
 		
 		var floatLoclAmt = parseFloat(ComReplaceStr(labl_pty_rcvr_locl_amt,",",""));//콤마제거
        var floatXchRt = parseFloat(ComReplaceStr(labl_pty_rcvr_locl_xch_rt,",",""));
 		 		
 		tmpUsdAmt = roundPrecision(floatLoclAmt / floatXchRt,2);
 		frm.labl_pty_rcvr_usd_amt.value = tmpUsdAmt;

 		tmpUsdAmt2 = ComAddComma2(frm.labl_pty_rcvr_usd_amt.value,"#,###.00");//변수에 comma를 처리하려고 했으나 안됨.
 		frm.labl_pty_rcvr_usd_amt.value = tmpUsdAmt2;//콤마 format 적용.
 		
 	}else{
 		frm.labl_pty_dmnd_usd_amt.value = "0";
 	}
  }
  
  /**
   *  팝업에서 Call 하는 함수
   */
  function setMainCodeInquiry(partyVo) {
  	frm.clm_pty_no.value = partyVo.clm_pty_no;
  	frm.clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
  	frm.pty_nm.value = partyVo.pty_nm;
 	
  	setLpTbDate();
   } 

function addComma2(obj,sFormat)
{
	try {
		//첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
		var sVal = getArgValue(obj);

		switch(sFormat)
		{
			case "#,###" :
					return ComAddComma(sVal);
			case "#,###.0" :
					p = sVal.split(".");
					p[0] = ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".0";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00" :
					p = sVal.split(".");
					p[0] = ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".00";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00000" :
					p = sVal.split(".");
					p[0] = ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".00000";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}


function setLpTbDate() {
	
	var sts = frm.clm_misc_cd.value;
	var dos_dt = frm.cgo_clm_stl_dt.value;
	var tm_bar_dt = frm.tm_bar_dt.value;
	var pty_nm = frm.clm_pty_abbr_nm.value;
	if( sts != 'C' && dos_dt != '' && tm_bar_dt == '' && pty_nm != '' ){
		
		var tb_dt = ComGetDateAdd(dos_dt,"D", 90); // 90일 후 날짜 	
				
		frm.tm_bar_dt.value = tb_dt;
	}

}

// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn1_Retrieve":
				var cgoClmNo = frm.cgo_clm_no.value;
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
					frm.cgo_clm_no.value = "";
					ComSetFocus(frm.cgo_clm_no);
				}
				break;

			case "btn1_Save":
				frm.f_cmd.value = MULTI;
				
				if (!chkAmount(frm.labl_pty_dmnd_amt, frm.labl_pty_dmnd_curr_cd, frm.labl_pty_fmal_clm_dt, frm.labl_pty_xch_rt, "LP Claim Amount", "LP DOF")) return;
				
				if (!chkAmount(frm.labl_pty_rcvr_locl_amt, frm.labl_pty_rcvr_locl_curr_cd, frm.labl_pty_rcvr_dt, frm.labl_pty_rcvr_locl_xch_rt, "LP Recovered Amount", "LP DOR")) return;

				if (frm.labl_pty_rcvr_locl_amt.value != '' && parseFloat(frm.labl_pty_rcvr_locl_amt.value.trimAll(",")) > 0 ){

					if ( frm.labl_pty_dmnd_amt.value == '' || parseFloat(frm.labl_pty_dmnd_amt.value.trimAll(",") ) == 0 ) {
						ComAlertFocus(frm.labl_pty_dmnd_amt, ComGetMsg('CNI09028',"LP Claim Amount"));
						return ;						
					}
				}
				
				var tos = frm.cgo_clm_stl_tp_cd.value;
				var mjrClmDmgLssCd = frm.mjr_clm_dmg_lss_cd.value;
				if (mjrClmDmgLssCd == "UI" ) {
					if( tos=='RP'||tos=='WD'||tos=='TB'||tos=='TD'||tos=='DS'){
						//msgs["CNI00009"] = "Please input {?msg1},";
						ComShowCodeMessage("CNI00009" , "CODL. Invalid 'Under Investigation' ");
						return;
					}
					var sts = frm.clm_misc_cd.value;
					if( sts == 'R' ){
						var labl_pty_rcvr_usd_amt = parseFloat(ComReplaceStr(frm.labl_pty_rcvr_usd_amt.value,",",""));//콤마제거
				        var cgo_clm_stl_usd_amt = parseFloat(ComReplaceStr(frm.cgo_clm_stl_usd_amt.value,",",""));
				 		var tmpStlAmt = labl_pty_rcvr_usd_amt - cgo_clm_stl_usd_amt;
						if( tmpStlAmt >= 0){
							//msgs["CNI00009"] = "Please input {?msg1},";
							ComShowCodeMessage("CNI00009" , "CODL. Invalid 'Under Investigation' ");
							return;
						}
					}
				}
				
				chkPointZero();
				
				if(ComChkValid(frm)) {
					//CNI00012(Do you want to save changes?)
					if (ComShowCodeConfirm("CNI00012")) {
						doActionIBSheet(MULTI);
					}
				}			
				break; 

			case "btn1_File_Upload":				
				var cgoClmNo = frm.cgo_clm_no.value;
				if (ComIsNull(cgoClmNo)) {
					//ComShowCodeMessage("CNI00009" , "Claim No.");
					ComShowMessage("Please use after retrieve or save");//CNI00103
				}else{
					popupFileUpload("001501" , cgoClmNo);
				}
				break;
			case "btn1_Cancel":				
				
				var cd = frm.clm_misc_cd.value;
								
				frm.f_cmd.value = MULTI01;	
				
				chkPointZero();

				if(ComChkValid(frm)) {
					//CNI09025(Do you really want to cancel this?)
					if (ComShowCodeConfirm("CNI09025")) {
						doActionIBSheet(MULTI01);
					}
				}			
				break;	
				
			case "btn1_Payment":
				var cgoClmNo = frm.cgo_clm_no.value;	
				popupPayment(cgoClmNo);
				break;
				
			case "btn1_Handling_Costs":
				var cgoClmNo = frm.cgo_clm_no.value;
				popupHandlingCost(cgoClmNo);
				break;	
				
			case "btn1_Handler":
				var cgoClmNo = frm.cgo_clm_no.value;	
				popupHandlerHistory(cgoClmNo);
				break;
			case "btns_liable_party":
				popupMainCodeInquiry();
				break;	
			case "btns_hndl_ofc_cd":
				popupOfficeCode();
				break;		
			case "btns_style":
				var clmPtyNo = frm.clm_pty_no.value;
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
				var display = "1,0,1,1,1";
				ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 500, 450, "setCurrency", display);
				break;
			case "btns_currency2":
				//공통팝업 Currency 호출
				var display = "1,0,1,1,1";
				ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 500, 450, "setLoclCurrency", display);
				break;	

			case "btns_roe1":
				var curr_cd = frm.labl_pty_dmnd_curr_cd.value;
				if (ComIsNull(curr_cd)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Currency Code");
					ComSetFocus(frm.labl_pty_dmnd_curr_cd);
					return;
				}

				var lp_dt = frm.labl_pty_fmal_clm_dt.value;
				if (ComIsNull(lp_dt)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "LP DOF");
					ComSetFocus(frm.labl_pty_fmal_clm_dt);
					return;
				}

				//공통팝업 ROE 호출
				var yrMon = ComReplaceStr(frm.labl_pty_fmal_clm_dt.value,"-","").substring(0,6);
				roeType = 1;
				popupRateOfExchange(curr_cd, yrMon);
				break;
			case "btns_roe2":
				var curr_cd = frm.labl_pty_rcvr_locl_curr_cd.value;
				if (ComIsNull(curr_cd)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Currency Code");
					ComSetFocus(frm.labl_pty_rcvr_locl_curr_cd);
					return;
				}

				var lp_dt = frm.labl_pty_rcvr_dt.value;
				if (ComIsNull(lp_dt)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "LP DOR");
					ComSetFocus(frm.labl_pty_rcvr_dt);
					return;
				}

				//공통팝업 ROE 호출
				var yrMon = ComReplaceStr(frm.labl_pty_rcvr_dt.value,"-","").substring(0,6);
				roeType = 2;
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
								
				var blNo  = frm.cgo_clm_ref_bl_no.value;
				
				if (blNo == "") {
					ComShowMessage("Please use after retrieve ");					
					return false;
				}
								
				doActionIBSheet(SEARCHLIST02);
				
				var bkgNo = frm.bkg_no.value;
				
				if (bkgNo == "") {
					ComShowCodeMessage("CNI00013");
					return false;
				}
						
				rdOpen(bkgNo);					
            	break;	

		} // end switch

}

/**
 * HTML Control KeyPress 이벤트 호출
 */

function obj_keypress() {
    switch (event.srcElement.name) {

		
    	case "labl_pty_dmnd_amt":
    		
			ComKeyOnlyNumber(event.srcElement, ".");
			
			break;
		
		case "labl_pty_dmnd_curr_cd":
			ComKeyOnlyAlphabet('upper');
			break;
		
		case "labl_pty_xch_rt":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
			
		case "labl_pty_rcvr_locl_amt":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		
		case "labl_pty_rcvr_locl_curr_cd":
			ComKeyOnlyAlphabet('upper');
			break;
		
		case "labl_pty_rcvr_locl_xch_rt":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;	
			
		case "hndl_ofc_cd":
			ComKeyOnlyAlphabet('upper');
			break;				

	}
}

 /**
  * HTML Control KeyDowm 이벤트 호출
  */
 function obj_keydown() {	  
	 if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;	  
     switch (event.srcElement.name) {    
 		case "cgo_clm_no":
 			break;
 	}
 }
  
  /**
   * HTML Control KeyUp 이벤트 호출
   */
  function obj_keyup() {	   
	 if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;	   
      switch (event.srcElement.name) {    
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
 	var frm = document.form;
 	switch (event.srcElement.name) {

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
 		ComChkObjValid(event.srcElement);
 	}
 }



/**
 * HTML Control Foucs in
 */

function obj_activate(){
    
 	var frm = document.form;
 	switch (event.srcElement.name) {

	case "labl_pty_fmal_clm_dt":
 		//if(preSaveCheck()) return;
 		break;
 	case "labl_pty_dmnd_amt":
 		//if(preSaveCheck()) return;	
 		break;
 		
	default:
		ComClearSeparator(event.srcElement);
 	}
}

function preSaveCheck(){
	
	var val1 = frm.clm_pty_abbr_nm.value;
	var val2 = frm.hndl_ofc_cd.value;
	var val3 = frm.labl_pty_prlm_clm_ntfy_dt.value;
	
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
	if(sheet.RowCount <= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}
 }
 */

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */

function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;

	switch (sAction) {
		case SEARCHLIST01:

			frm.f_cmd.value = SEARCHLIST01;
	
			var sXml = sheet1.GetSearchXml("CPS_CNI_0015GS.do", FormQueryString(frm),"",true);	
			var arrXml = sXml.split("|$$|");
	
			if (arrXml.length > 0) {			
				var list = SheetXml2ListMap(arrXml[0]);	
				
				if (list.length > 0) {
					var liablePartyVO = list[0];					
					
					frm.cgo_clm_no.value = liablePartyVO["cgo_clm_no"];
					frm.clm_area_cd.value = liablePartyVO["clm_area_cd"];
					frm.hdlr_ofc_cd.value = liablePartyVO["hdlr_ofc_cd"];
					frm.hdlr_usr_id.value = liablePartyVO["hdlr_usr_id"];
					frm.upd_dt.value = liablePartyVO["upd_dt"];
					frm.cgo_clm_inci_no.value = liablePartyVO["cgo_clm_inci_no"];
					frm.crm_voc_no.value = liablePartyVO["crm_voc_no"];
					frm.clm_misc_cd.value = liablePartyVO["clm_misc_cd"];
					frm.clm_misc_nm.value = liablePartyVO["clm_misc_nm"];
					frm.hpc.value = liablePartyVO["hpc"];
					frm.nhp.value = liablePartyVO["nhp"];
					frm.cgo_clm_stl_tp_cd.value = liablePartyVO["cgo_clm_stl_tp_cd"];
					frm.cs_clz_dt.value = liablePartyVO["cs_clz_dt"];
					frm.clm_tm_bar_dt.value = liablePartyVO["clm_tm_bar_dt"];
					frm.smns_sve_date.value = liablePartyVO["smns_sve_dt"];
					
					frm.cgo_clm_ref_bl_no.value = liablePartyVO["cgo_clm_ref_bl_no"];
					frm.crr_term_cd.value = liablePartyVO["crr_term_cd"];
					frm.por_cd.value = liablePartyVO["por_cd"];
					frm.rct_dt.value = liablePartyVO["rct_dt"];
					frm.pol_cd.value = liablePartyVO["pol_cd"];
					frm.pod_cd.value = liablePartyVO["pod_cd"];
					frm.del_cd.value = liablePartyVO["del_cd"];
					frm.de_dt.value = liablePartyVO["de_dt"];
					
					frm.cgo_clm_tp_cd.value = liablePartyVO["cgo_clm_tp_cd"];
					frm.mjr_clm_dmg_lss_cd.value = liablePartyVO["mjr_clm_dmg_lss_cd"];
					frm.n3rd_labl_pty_cd.value = liablePartyVO["n3rd_labl_pty_cd"];
					frm.inci_plc_tp_cd.value = liablePartyVO["inci_plc_tp_cd"];
					frm.inci_occr_dt.value = liablePartyVO["inci_occr_dt"];					
					frm.clm_cgo_tp_cd.value = liablePartyVO["clm_cgo_tp_cd"];				
					frm.cgo_qlty_desc.value = liablePartyVO["cgo_qlty_desc"];												
					frm.clmt_locl_amt.value = ComAddComma2(liablePartyVO["clmt_locl_amt"],"#,###.00");
					frm.clmt_locl_curr_cd.value = liablePartyVO["clmt_locl_curr_cd"];
					frm.fmal_clm_rcv_dt.value = liablePartyVO["fmal_clm_rcv_dt"];
					frm.clmt_locl_xch_rt.value = addComma2( liablePartyVO["clmt_locl_xch_rt"],"#,###.00000");	
					frm.clmt_usd_amt.value = ComAddComma2( liablePartyVO["clmt_usd_amt"],"#,###.00");;					
					frm.cgo_clm_stl_locl_amt.value = ComAddComma2( liablePartyVO["cgo_clm_stl_locl_amt"],"#,###.00");
					frm.cgo_clm_stl_locl_curr_cd.value = liablePartyVO["cgo_clm_stl_locl_curr_cd"];
					frm.cgo_clm_stl_dt.value = liablePartyVO["cgo_clm_stl_dt"];
					frm.cgo_clm_stl_xch_rt.value = addComma2( liablePartyVO["cgo_clm_stl_xch_rt"],"#,###.00000");	
					frm.cgo_clm_stl_usd_amt.value = ComAddComma2( liablePartyVO["cgo_clm_stl_usd_amt"],"#,###.00");					
					frm.clm_pty_no.value = liablePartyVO["clm_pty_no"];
					frm.clm_pty_abbr_nm.value = liablePartyVO["clm_pty_abbr_nm"];				
					frm.pty_nm.value = liablePartyVO["pty_nm"];				
					frm.hndl_ofc_cd.value = liablePartyVO["hndl_ofc_cd"];							
					frm.labl_pty_prlm_clm_ntfy_dt.value = liablePartyVO["labl_pty_prlm_clm_ntfy_dt"];
					frm.tm_bar_dt.value = liablePartyVO["tm_bar_dt"];					
					frm.labl_pty_dmnd_amt.value = ComAddComma2( liablePartyVO["labl_pty_dmnd_amt"],"#,###.00");
					frm.labl_pty_dmnd_curr_cd.value = liablePartyVO["labl_pty_dmnd_curr_cd"];								
					frm.labl_pty_fmal_clm_dt.value = liablePartyVO["labl_pty_fmal_clm_dt"];				
					frm.labl_pty_xch_rt.value = addComma2( liablePartyVO["labl_pty_xch_rt"],"#,###.00000");							
					frm.labl_pty_dmnd_usd_amt.value = ComAddComma2( liablePartyVO["labl_pty_dmnd_usd_amt"],"#,###.00");				
					frm.labl_pty_rcvr_locl_amt.value = ComAddComma2( liablePartyVO["labl_pty_rcvr_locl_amt"],"#,###.00");
					frm.labl_pty_rcvr_locl_curr_cd.value = liablePartyVO["labl_pty_rcvr_locl_curr_cd"];								
					frm.labl_pty_rcvr_dt.value = liablePartyVO["labl_pty_rcvr_dt"];				
					frm.labl_pty_rcvr_locl_xch_rt.value = addComma2( liablePartyVO["labl_pty_rcvr_locl_xch_rt"],"#,###.00000");									
					frm.labl_pty_rcvr_usd_amt.value = ComAddComma2( liablePartyVO["labl_pty_rcvr_usd_amt"],"#,###.00");
					frm.labl_pty_clm_rmk.value = liablePartyVO["labl_pty_clm_rmk"];
					
					setLpTbDate();
					chkPointZero();
					//Role
					setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn1_Cancel");
					
					var sts = frm.clm_misc_cd.value;
					if( sts!='R'){
						ComBtnDisable("btn1_Cancel");
					}
					if( sts=='C'){
						ComBtnDisable("btn1_Save");
					}					
						
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
			frm.f_cmd.value = SEARCHLIST02;
			var sXml = sheet1.GetSearchXml("CPS_CNI_0015GS.do", FormQueryString(frm),"",true);	
					
			var arrXml = sXml.split("|$$|");

			// ------------------------------------------------------------
			// Booking No 설정
			// ------------------------------------------------------------
			if (arrXml.length > 0) {
				var list = SheetXml2ListMap(arrXml[0]);	
				
				if (list.length > 0) {
					var dataVO = list[0];					
					frm.bkg_no.value = dataVO["bkg_no"];					
				}
				
			} else {
				frm.bkg_no.value = '';
				//ComShowCodeMessage("CNI00013");
			}
			
			break;
		case MULTI:
		
			frm.f_cmd.value = MULTI;
						
			setDmndUsdAmt();
			setRcvrUsdAmt();
	
			//sepatator 제거
			frm.labl_pty_prlm_clm_ntfy_dt.value = ComReplaceStr(frm.labl_pty_prlm_clm_ntfy_dt,'-','');
			frm.tm_bar_dt.value = ComReplaceStr(frm.tm_bar_dt,'-','');
			frm.labl_pty_fmal_clm_dt.value = ComReplaceStr(frm.labl_pty_fmal_clm_dt,'-','');
			frm.labl_pty_rcvr_dt.value = ComReplaceStr(frm.labl_pty_rcvr_dt,'-','');
			
			frm.labl_pty_dmnd_amt.value = ComReplaceStr(frm.labl_pty_dmnd_amt,',','');
			frm.labl_pty_xch_rt.value = ComReplaceStr(frm.labl_pty_xch_rt,',','');
			frm.labl_pty_dmnd_usd_amt.value = ComReplaceStr(frm.labl_pty_dmnd_usd_amt,',','');
			frm.labl_pty_rcvr_locl_amt.value = ComReplaceStr(frm.labl_pty_rcvr_locl_amt,',','');
			frm.labl_pty_rcvr_locl_xch_rt.value = ComReplaceStr(frm.labl_pty_rcvr_locl_xch_rt,',','');
			frm.labl_pty_rcvr_usd_amt.value = ComReplaceStr(frm.labl_pty_rcvr_usd_amt,',','');
			
			frm.cgo_clm_stl_usd_amt.value = ComReplaceStr(frm.cgo_clm_stl_usd_amt,',','');
					
			var param = "";
			param += FormQueryString(frm);			
			var saveString = sheet1.GetSaveString(); 
						
			param += "&" + saveString;	
			var sXml = sheet1.GetSaveXml("CPS_CNI_0015GS.do", param);		
			sheet1.LoadSaveXml(sXml);
			//main에 없는 clm_no 를 입력하려고 할경우 에러처리하고 재조회하지 않는다.
			var manageStr ="";
			manageStr = ComGetEtcData(sXml, "MANAGE_STR");	
			
			if(manageStr == "N"){
				ComResetAll();
			}
			if(manageStr == "Y"){
				//재조회
				doActionIBSheet(SEARCHLIST01);
			}			
			
			break;
	
		case MULTI01:    // CANCEL
		
			frm.f_cmd.value = MULTI01;		
	
			//sepatator 제거
			frm.labl_pty_prlm_clm_ntfy_dt.value = ComReplaceStr(frm.labl_pty_prlm_clm_ntfy_dt,'-','');
			frm.tm_bar_dt.value = ComReplaceStr(frm.tm_bar_dt,'-','');
			frm.labl_pty_fmal_clm_dt.value = ComReplaceStr(frm.labl_pty_fmal_clm_dt,'-','');
			frm.labl_pty_rcvr_dt.value = ComReplaceStr(frm.labl_pty_rcvr_dt,'-','');
			
			frm.labl_pty_dmnd_amt.value = ComReplaceStr(frm.labl_pty_dmnd_amt,',','');
			frm.labl_pty_xch_rt.value = ComReplaceStr(frm.labl_pty_xch_rt,',','');
			frm.labl_pty_dmnd_usd_amt.value = ComReplaceStr(frm.labl_pty_dmnd_usd_amt,',','');
			frm.labl_pty_rcvr_locl_amt.value = ComReplaceStr(frm.labl_pty_rcvr_locl_amt,',','');
			frm.labl_pty_rcvr_locl_xch_rt.value = ComReplaceStr(frm.labl_pty_rcvr_locl_xch_rt,',','');
			frm.labl_pty_rcvr_usd_amt.value = ComReplaceStr(frm.labl_pty_rcvr_usd_amt,',','');
				
			var param = "";
			param += FormQueryString(frm);
			
			var saveString = sheet1.GetSaveString(); 						
			param += "&" + saveString;	
			var sXml = sheet1.GetSaveXml("CPS_CNI_0015GS.do", param);		
			sheet1.LoadSaveXml(sXml);
			//main에 없는 clm_no 를 입력하려고 할경우 에러처리하고 재조회하지 않는다.
			//var manageStr ="";
			//manageStr = ComGetEtcData(sXml, "MANAGE_STR");	
			
			//재조회
			doActionIBSheet(SEARCHLIST01);
			
			break;	
		
	} //end of switch
	
}


function setOfficeCode(ofcCd){
	
	frm.hndl_ofc_cd.value = ofcCd;
}

/**
* ROE 팝업에서 호출하는 함수
*/
function setCurrencyROE(xchRtVo) {
	
	if(roeType==1){
		frm.labl_pty_dmnd_curr_cd.value = xchRtVo.curr_cd;
		frm.labl_pty_xch_rt.value = xchRtVo.usd_locl_xch_rt;
		setDmndUsdAmt();
	}else if(roeType==2){
		frm.labl_pty_rcvr_locl_curr_cd.value = xchRtVo.curr_cd;
		frm.labl_pty_rcvr_locl_xch_rt.value = xchRtVo.usd_locl_xch_rt;
		setRcvrUsdAmt();	
	}
} 


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
	
	var loclAmt = cniParseFloat(objLoclAmt);
	var xchRt = cniParseFloat(objXchRt);
	var currCd = objCurrCd.value.trim();
	var inputDt = objInputDt.value.trim();
		
	
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
		frm.labl_pty_dmnd_amt.value = 0;
 	}
	if( (frm.labl_pty_xch_rt.value.indexOf('.0')==0) || (frm.labl_pty_xch_rt.value == "") ){ 			
		frm.labl_pty_xch_rt.value = 0;
 	}
	if( (frm.labl_pty_dmnd_usd_amt.value.indexOf('.0')==0) || (frm.labl_pty_dmnd_usd_amt.value == "") ){ 			
		frm.labl_pty_dmnd_usd_amt.value = 0;
 	}
	
	
	if( (frm.labl_pty_rcvr_locl_amt.value.indexOf('.0')==0) || (frm.labl_pty_rcvr_locl_amt.value == "") ){ 			
		frm.labl_pty_rcvr_locl_amt.value = 0;
 	}
	if( (frm.labl_pty_rcvr_locl_xch_rt.value.indexOf('.0')==0) || (frm.labl_pty_rcvr_locl_xch_rt.value == "") ){ 			
		frm.labl_pty_rcvr_locl_xch_rt.value = 0;
 	}
	if( (frm.labl_pty_rcvr_usd_amt.value.indexOf('.0')==0) || (frm.labl_pty_rcvr_usd_amt.value == "") ){ 			
		frm.labl_pty_rcvr_usd_amt.value = 0;
 	}
}

function rdOpen(strBkgNo){    

	rdUrl = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"; 
	rdFile = "ESM_BKG_0109_DBL.mrd";	
	rdParam = "/rv form_bkgNo[( '" + strBkgNo + "') ]"
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
		
	frm.com_mrdTitle.value = "Hanjin Shipping Draft B/L Copies";
	frm.com_mrdPath.value = rdUrl+rdFile;
	frm.com_mrdArguments.value = rdParam + " /rwait";
	frm.com_mrdBodyTitle.value="Hanjin Shipping Draft B/L Copies";
		
	ComOpenRDPopup('resizable=yes, width=900, height=800');
}

