/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0013.js
 *@FileTitle : [CPS_CNI_0013] Salvage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/

/**
 * [cps_cni_0013] Salvage
 * @extends
 * @class Salvage 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0013() {
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
    
	if(frm.cgo_clm_no.value == ""){
    	setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save","Y");
    }else{
    	setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save","N");
    }

	if(frm.cgo_clm_no.value.length == 10){
		doActionIBSheet(SEARCHLIST01);
	}
	frm.cgo_clm_no.focus();
    
}

/**
* Form 이벤트 등록
*/
function initControl() {
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate', 'obj_activate',    frm);
	axon_event.addListenerForm('keyup',	'obj_keyup',frm); 
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
/**
 * Location 설정
 */
 function setCurrency(rowArray) { 
    frm.slv_locl_curr_cd.value = rowArray[0][3];
	if(rowArray[0][3] == "USD"){
		frm.slv_xch_rt.value = "1.00000";
	}
 }

/**
 * ROE 팝업에서 호출하는 함수
 */
  function setCurrencyROE(xchRtVo) {
	frm.slv_locl_curr_cd.value = xchRtVo.curr_cd;
	frm.slv_xch_rt.value = xchRtVo.usd_locl_xch_rt;
	setFeeUsdAmt();
 } 

 /**
 * USD 일경우 exchange rate 1.00000 설정
 */
 function setXchRt() { 
	if(frm.slv_locl_curr_cd.value == "USD"){
		frm.slv_xch_rt.value = "1.00000";
	}
 }

  /**
 * ROE 입력후 slv_usd_amt 설정
 * Salvage Fee USD 항목에 계산값 Setup = ( Survey Fee / R.O.E )
 * 소수점 세자리에서 반올림.
 * Local --> USD 
 * onblur / enter / save 버튼 눌렀을때
 */
 function setFeeUsdAmt() { 

	var floatLoclAmt = cniParseFloat(frm.slv_locl_amt);
	var floatXchRt = cniParseFloat(frm.slv_xch_rt);
	var locl_curr_cd = frm.slv_locl_curr_cd.value;
	var tmpUsdAmt = "";
	var tmpUsdAmt2 = "";

      if(floatXchRt != 0 && floatLoclAmt != 0  && locl_curr_cd != "" ){
    	  
//    if(xch_rt != "" && xch_rt != "0" && locl_amt != "" && locl_amt != "0"  && locl_curr_cd != "" ){		
//		var floatLoclAmt = parseFloat(ComReplaceStr(locl_amt,",",""));//콤마제거
//      var floatXchRt = parseFloat(ComReplaceStr(xch_rt,",",""));
//        var floatLoclAmt = locl_amt;
//        var floatXchRt = xch_rt;
		
		//locl_amt / xch_rt
		tmpUsdAmt = roundPrecision(floatLoclAmt / floatXchRt,2);
		
		frm.slv_usd_amt.value = tmpUsdAmt;

		tmpUsdAmt2 = ComAddComma2(frm.slv_usd_amt.value,"#,###.00");//변수에 comma를 처리하려고 했으나 안됨.
		frm.slv_usd_amt.value = tmpUsdAmt2;//콤마 format 적용.
	}else{
		frm.slv_usd_amt.value = "0";
	}
 }

 /**
 * Surveyor 팝업에서 Call 하는 함수
 */
function setMainCodeInquiry(partyVo) {
	frm.clm_pty_no.value = partyVo.clm_pty_no;
	frm.clm_pty_abbr_nm2.value = partyVo.clm_pty_abbr_nm;
	frm.pty_nm.value = partyVo.pty_nm;
} 

 function addComma2(obj,sFormat)
 {
 	try {
 		//첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
 		var sVal = getArgValue(obj);

 		if(sVal == "") return "";//값이 없을때 .00000으로 세팅되는것 방지.

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
					else if (p.length == 2) {
						if(p[1].length == 1)return p[0]+"."+p[1]+"0";
						if(p[1].length == 2)return p[0]+"."+p[1];
					}
 					else return "";
 			case "#,###.00000" :
 					p = sVal.split(".");
 					p[0] = ComAddComma(p[0]);
 					if      (p.length == 1) return p[0]+".00000";
 					else if (p.length == 2) {
 						if(p[1].length == 1)return p[0]+"."+p[1]+"0000";
 						if(p[1].length == 2)return p[0]+"."+p[1]+"000";
 						if(p[1].length == 3)return p[0]+"."+p[1]+"00";  
 						if(p[1].length == 4)return p[0]+"."+p[1]+"0";   
 						if(p[1].length == 5)return p[0]+"."+p[1];
 					}
 					else return "";
 		}
 	} catch(err) { ComFuncErrMsg(err.message); }
 }

// 달력 화면 표시 공통  함수
function calendarDisplay (pInputObj){
	var vCal = new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(pInputObj, 'yyyy-MM-dd');
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
					setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save","Y");
				}
				break;

			case "btn1_Save":
				
				if(!validateForm(sheet1,frm,MULTI)) return;
				
				frm.f_cmd.value = MULTI;	
			
				if(ComChkValid(frm)) {
					//CNI00012(Do you want to save changes?)
					if (ComShowCodeConfirm("CNI00012")) {
						doActionIBSheet(MULTI);
					}
				}			
				break; 

			case "btn1_Handling_Costs":
				popupHandlingCost(frm.cgo_clm_no.value);
				break;
				
			case "btn1_Handler":
				popupHandlerHistory(frm.cgo_clm_no.value);
				break;

			case "btns_currency":
				//공통팝업 Currency 호출
				var display = "1,0,1,1,1";
				ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 500, 450, "setCurrency", display);
				break;

			case "btns_roe":
				var svyrLoclCurrCd = frm.slv_locl_curr_cd.value;
				if (ComIsNull(svyrLoclCurrCd)) {
					//msgs["CNI00018"] = "Please select {?msg1}";
					ComShowCodeMessage("CNI00009" , "Currency Code");
					ComSetFocus(frm.slv_locl_curr_cd);
					return;
				}

				var slvDt = frm.slv_dt.value;
				if (ComIsNull(slvDt)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Surveyed Date");
					ComSetFocus(frm.slv_dt);
					return;
				}

				//공통팝업 ROE 호출
				var yrMon = ComReplaceStr(frm.slv_dt.value,"-","").substring(0,6);
				popupRateOfExchange(svyrLoclCurrCd, yrMon);
				break;

			case "btns_salvager":
				popupMainCodeInquiry();
				break;

			case "btns_style":
				var clmPtyNo = frm.clm_pty_no.value;
				if (ComIsNull(clmPtyNo)) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Salvager");
					ComSetFocus(frm.clm_pty_abbr_nm2);
					return;
				}
				popupMainCodeView(clmPtyNo);
				break;

			case "btn1_File_Upload":
				var cgoClmNo = frm.cgo_clm_no_old.value;
				var dispCgoClmNo = frm.cgo_clm_no.value;
				if (ComIsNull(cgoClmNo) || dispCgoClmNo.length != 10) {
					ComShowCodeMessage("CNI00103");//Please use after retrieve or save
				}else{
					popupFileUpload("001301" ,  cgoClmNo);
				}
				break;

			case "btns_date_cal1":
				calendarDisplay(frm.slv_dt);
				break;

		} // end switch

}

/**
 * HTML Control KeyPress 이벤트 호출
 */

function obj_keypress() {
    switch (event.srcElement.name) {

		case "slv_locl_amt":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		
		case "slv_locl_curr_cd":
			ComKeyOnlyAlphabet('upper');
			break;
		
		case "slv_xch_rt":
			ComKeyOnlyNumber(event.srcElement, ".");
			break;

		case "ref_svyr_no":
			ComKeyOnlyAlphabet("num");
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
			if (frm.cgo_clm_no.length == 10 && event.keyCode == 13) {
				doActionIBSheet(SEARCHLIST01);
			}
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
		case "slv_locl_curr_cd":	//CURR_CD수정시
		setXchRt();
		setFeeUsdAmt();
		break;

		case "slv_locl_amt": //금액수정시	
			// ROE 입력후 slv_fee_usd_amt 설정
			setFeeUsdAmt();
			ComAddSeparator(frm.slv_locl_amt, "float")
		case "slv_xch_rt":	//ROE수정시
			// ROE 입력후 slv_fee_usd_amt 설정
			setFeeUsdAmt();
			ComAddSeparator(frm.slv_xch_rt, "float")
			break;
		default:
			ComChkObjValid(event.srcElement);
	}
}

/**
 * HTML Control Foucs in
 */

function obj_activate(){
	if( event.srcElement.name != "clmt_usd_amt"){
		ComClearSeparator(event.srcElement);
	}
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

	if (sAction == SEARCHLIST01) {

		frm.f_cmd.value = SEARCHLIST01;
		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0013GS.do", FormQueryString(frm),"",true);		
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {			
			var list = SheetXml2ListMap(arrXml[0]);	
			
			if (list.length > 0) {
				var salvageVO = list[0];
				frm.cgo_clm_no.value = salvageVO["cgo_clm_no"];
				frm.cgo_clm_no_old.value = salvageVO["cgo_clm_no"];//file upload 위한 old값.
				frm.clm_area_cd.value = salvageVO["clm_area_cd"];
				frm.hdlr_ofc_cd.value = salvageVO["hdlr_ofc_cd"];
				frm.hdlr_usr_id.value = salvageVO["hdlr_usr_id"];
				frm.upd_dt1.value = salvageVO["upd_dt1"];
				frm.cgo_clm_inci_no.value = salvageVO["cgo_clm_inci_no"];
				frm.crm_voc_no.value = salvageVO["crm_voc_no"];
				frm.clm_misc_cd.value = salvageVO["clm_misc_cd"];
				frm.clm_misc_nm.value = salvageVO["clm_misc_nm"];
				frm.hpc.value = salvageVO["hpc"];
				frm.nhp.value = salvageVO["nhp"];
				frm.cgo_clm_stl_tp_cd.value = salvageVO["cgo_clm_stl_tp_cd"];
				frm.cs_clz_dt.value = salvageVO["cs_clz_dt"];
				frm.clm_tm_bar_dt.value = salvageVO["clm_tm_bar_dt"];
				frm.smns_sve_date.value = salvageVO["smns_sve_dt"];
				frm.cgo_clm_tp_cd.value = salvageVO["cgo_clm_tp_cd"];
				frm.mjr_clm_dmg_lss_cd.value = salvageVO["mjr_clm_dmg_lss_cd"];
				frm.n3rd_labl_pty_cd.value = salvageVO["n3rd_labl_pty_cd"];
				frm.clm_cgo_tp_cd.value = salvageVO["clm_cgo_tp_cd"];
				frm.cgo_qlty_desc.value = salvageVO["cgo_qlty_desc"];
				frm.clmt_usd_amt.value = addComma2(salvageVO["clmt_usd_amt"], "#,###.00");//Claim Amount
				frm.slan_cd.value = salvageVO["slan_cd"];
				frm.clm_inci_plc_tp_cd.value = salvageVO["clm_inci_plc_tp_cd"];
				frm.inci_occr_dt.value = salvageVO["inci_occr_dt"];				
				frm.clm_pty_abbr_nm1.value = salvageVO["clm_pty_abbr_nm1"];
				frm.insur_ref_no.value = salvageVO["insur_ref_no"];	
				frm.clm_pty_no.value = salvageVO["clm_pty_no"];
				frm.clm_pty_abbr_nm2.value = salvageVO["clm_pty_abbr_nm2"];
				frm.pty_nm.value = salvageVO["pty_nm"];
				frm.ref_slv_no.value = salvageVO["ref_slv_no"];
				frm.slv_dt.value = salvageVO["slv_dt"];
				frm.upd_usr_id.value = salvageVO["upd_usr_id"];
				frm.upd_dt2.value = salvageVO["upd_dt2"];
				frm.slv_locl_amt.value = addComma2(salvageVO["slv_locl_amt"], "#,###.00");//Salvage Amount	
				frm.slv_locl_curr_cd.value = salvageVO["slv_locl_curr_cd"];	
				frm.slv_xch_rt.value = addComma2(salvageVO["slv_xch_rt"],"#,###.00000");//R.O.E
				frm.slv_usd_amt.value = addComma2(salvageVO["slv_usd_amt"], "#,###.00");//
				frm.slv_desc.value = salvageVO["slv_desc"];
				
				//권한
				setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save");
				
				// close case , cancel 인경우 save 버튼 비활성화
				if(frm.clm_misc_cd.value == "C" || frm.clm_misc_cd.value == "X"){
					ComBtnDisable("btn1_Save");
				}

			}else{
				ComResetAll();//조회건이 없으면 form reset.
				frm.cgo_clm_no.value = "";

				if(frm.cgo_clm_no.value == ""){
					//msgs["CNI00013"] = "There is no data to search.";
					ComShowCodeMessage("CNI00013");
				}
			}
        }

	} else if (sAction == MULTI) {

		
		frm.f_cmd.value = MULTI;

		//ROE 입력후 svyr_fee_usd_amt 설정
		setFeeUsdAmt();

		//sepatator 제거
		frm.slv_dt.value = ComReplaceStr(frm.slv_dt,'-','');
		frm.slv_locl_amt.value = ComReplaceStr(frm.slv_locl_amt,',','');
		frm.slv_locl_curr_cd.value = ComReplaceStr(frm.slv_locl_curr_cd,',','');
		frm.slv_xch_rt.value = ComReplaceStr(frm.slv_xch_rt,',','');
		frm.slv_usd_amt.value = ComReplaceStr(frm.slv_usd_amt,',','');

		var param = "";
		param += FormQueryString(frm);
		
		var saveString = sheet1.GetSaveString(); 
		
		param += "&" + saveString;	
		var sXml = sheet1.GetSaveXml("CPS_CNI_0013GS.do", param);		
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
		
	} 
	
}

/**
 * 금액, 통화, 날짜, 환율이 하나라도 입력시 다른 세개의 필드도 모두 입력되었는지 체크
 */
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

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (sAction == MULTI) {
			if (!chkAmount(frm.slv_locl_amt, frm.slv_locl_curr_cd, frm.slv_dt, frm.slv_xch_rt, "Salvage Amount", "Salvaged Date")) return;
		}
	}

	return true;
}