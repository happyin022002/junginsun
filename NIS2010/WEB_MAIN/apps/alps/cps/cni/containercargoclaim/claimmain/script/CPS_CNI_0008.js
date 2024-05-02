/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0008.js
 *@FileTitle : [cps_cni_0008] Payment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/

/**
 * [cps_cni_0008] Payment
 * @extends
 * @class Payment 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0008() {
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

	if(frm.cgo_clm_no.value != ""){
		doActionIBSheet(SEARCHLIST01);
	}
    
}

/**
* Form 이벤트 등록
*/
function initControl() {
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate', 'obj_activate',    frm);
axon_event.addListenerForm('keyup', 'obj_keyup',frm); 
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
					else if (p.length == 2) return p[0]+"."+p[1];
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
					//msgs["CNI00009"] = "Please input {?msg1}";
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
				frm.f_cmd.value = MULTI;	

				if(ComChkValid(frm)) {

					if (frm.pay_rmk.value == "") {
						//msgs["CNI00009"] = "Please input {?msg1}";
						ComShowCodeMessage("CNI00009" , "Remarks");
						ComSetFocus(frm.pay_rmk);
						return;
					}

					//CNI00012(Do you want to save changes?)
					if (ComShowCodeConfirm("CNI00012")) {
						doActionIBSheet(MULTI);
					}
				}			
				break; 

			case "btn1_Close":
				window.close();
				break;
				
			case "btn1_Handling_Costs":
					popupHandlingCost(frm.cgo_clm_no.value);
				break;

		} // end switch

}

/**
 * HTML Control KeyPress 이벤트 호출
 */

function obj_keypress() {
    switch (event.srcElement.name) {

		case "cgo_clm_no":
			ComKeyOnlyAlphabet('uppernum');
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
			if (!ComIsNull(frm.cgo_clm_no.value) && event.keyCode == 13) {
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

	default:
		ComChkObjValid(event.srcElement);
	}
}

/**
 * HTML Control Foucs in
 */

function obj_activate(){
    ComClearSeparator(event.srcElement);
}


// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
 
/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */

function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;

	if (sAction == SEARCHLIST01) {

		frm.f_cmd.value = SEARCHLIST01;

		var sXml = sheet1.GetSearchXml("CPS_CNI_0008GS.do", FormQueryString(frm));		

		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {			
			var list = SheetXml2ListMap(arrXml[0]);	

			if (list.length > 0) {
				var PaymentVO = list[0];
				frm.cgo_clm_no.value = PaymentVO["cgo_clm_no"];
				frm.clm_area_cd.value = PaymentVO["clm_area_cd"];
				frm.clm_misc_nm.value = PaymentVO["clm_misc_nm"];
				frm.cs_clz_dt.value = PaymentVO["cs_clz_dt"];
				frm.cs_clz_dt.value = ComGetMaskedValue(frm.cs_clz_dt, "ymd", "-")	;
				frm.pty_nm.value = PaymentVO["pty_nm"];

				frm.clmt_locl_amt.value = addComma2(PaymentVO["clmt_locl_amt"],"#,###.00");
				frm.clmt_locl_curr_cd.value = PaymentVO["clmt_locl_curr_cd"];
				frm.clmt_locl_xch_rt.value = addComma2(PaymentVO["clmt_locl_xch_rt"],"#,###.00000");
				frm.clmt_usd_amt.value = addComma2(PaymentVO["clmt_usd_amt"],"#,###.00");

				frm.cgo_clm_stl_locl_amt.value = addComma2(PaymentVO["cgo_clm_stl_locl_amt"],"#,###.00");
				frm.cgo_clm_stl_locl_curr_cd.value = PaymentVO["cgo_clm_stl_locl_curr_cd"];
				frm.cgo_clm_stl_xch_rt.value = addComma2(PaymentVO["cgo_clm_stl_xch_rt"],"#,###.00000");
				frm.cgo_clm_stl_usd_amt.value = addComma2(PaymentVO["cgo_clm_stl_usd_amt"],"#,###.00");

				frm.recovered_amount.value = addComma2(PaymentVO["recovered_amount"],"#,###.00");

				frm.labl_pty_rcvr_locl_amt.value = addComma2(PaymentVO["labl_pty_rcvr_locl_amt"],"#,###.00");
				frm.labl_pty_rcvr_locl_curr_cd.value = PaymentVO["labl_pty_rcvr_locl_curr_cd"];
				frm.labl_pty_rcvr_locl_xch_rt.value = addComma2(PaymentVO["labl_pty_rcvr_locl_xch_rt"],"#,###.00000");
				frm.labl_pty_rcvr_usd_amt.value = addComma2(PaymentVO["labl_pty_rcvr_usd_amt"],"#,###.00");

				frm.insur_rcvr_amt.value = addComma2(PaymentVO["insur_rcvr_amt"],"#,###.00");
				frm.insur_rcvr_locl_curr_cd.value = PaymentVO["insur_rcvr_locl_curr_cd"];
				frm.insur_rcvr_xch_rt.value = addComma2(PaymentVO["insur_rcvr_xch_rt"],"#,###.00000");
				frm.insur_rcvr_usd_amt.value = addComma2(PaymentVO["insur_rcvr_usd_amt"],"#,###.00");

				frm.fmal_clm_rcv_dt.value = PaymentVO["fmal_clm_rcv_dt"];	
				frm.fmal_clm_rcv_dt.value = ComGetMaskedValue(frm.fmal_clm_rcv_dt, "ymd", "-")	;
				frm.cgo_clm_stl_dt.value = PaymentVO["cgo_clm_stl_dt"];
				frm.cgo_clm_stl_dt.value = ComGetMaskedValue(frm.cgo_clm_stl_dt, "ymd", "-")	;
				frm.labl_pty_rcvr_dt.value = PaymentVO["labl_pty_rcvr_dt"];	
				frm.labl_pty_rcvr_dt.value = ComGetMaskedValue(frm.labl_pty_rcvr_dt, "ymd", "-")	;
				frm.insur_rcvr_dt.value = PaymentVO["insur_rcvr_dt"];
				frm.insur_rcvr_dt.value = ComGetMaskedValue(frm.insur_rcvr_dt, "ymd", "-")	;
				frm.net_paid_amount.value = addComma2(PaymentVO["net_paid_amount"],"#,###.00");
				frm.defense_ratio_on_settlement.value = PaymentVO["defense_ratio_on_settlement"];
				frm.on_net_payment.value = addComma2(PaymentVO["on_net_payment"],"#,###.00");
				frm.inv_usd_amt.value = addComma2(PaymentVO["inv_usd_amt"],"#,###.00");
				frm.pay_rmk.value = PaymentVO["pay_rmk"];
				frm.hdlr_usr_id.value = PaymentVO["hdlr_usr_id"];
				frm.hdlr_ofc_cd.value = PaymentVO["hdlr_ofc_cd"];
				
				//Status 변경을 위한 변수
				frm.cgo_clm_sts_cd.value = PaymentVO["cgo_clm_sts_cd"];
				frm.cgo_clm_clz_cd.value = PaymentVO["cgo_clm_clz_cd"];
				frm.upd_usr_id.value = PaymentVO["upd_usr_id"];
				
				//권한
				setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save");
				
				// close case , cancel 인경우 save 버튼 비활성화
				if(frm.cgo_clm_sts_cd.value == "C" || frm.cgo_clm_sts_cd.value == "X"){
					ComBtnDisable("btn1_Save");
				}


			}else{

				var tempCgoClmNo = frm.cgo_clm_no.value;
				ComResetAll();//조회건이 없으면 form reset.
				frm.cgo_clm_no.value = tempCgoClmNo;

				//msgs["CNI00013"] = "There is no data to search.";
				ComShowCodeMessage("CNI00013");
			}
        }

	} else if (sAction == MULTI) {

		frm.f_cmd.value = MULTI;

		var param = "";
		param += FormQueryString(frm);
		
		var saveString = sheet1.GetSaveString(); 
		
		param += "&" + saveString;	
		var sXml = sheet1.GetSaveXml("CPS_CNI_0008GS.do", param);		
		sheet1.LoadSaveXml(sXml);

		//재조회
		doActionIBSheet(SEARCHLIST01);
		
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