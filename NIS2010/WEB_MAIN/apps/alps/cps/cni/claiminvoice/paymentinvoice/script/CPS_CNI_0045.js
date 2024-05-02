/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0045.js
 *@FileTitle : [CPS_CNI_0045] Invoice Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0045] Invoice Creation
 * @extends
 * @class 전표 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0045() {
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
    //Claim No.  가 존재하는경우 조회
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
            // 높이 설정
			style.height = 210;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|Type|Payee|Invoice No.|Inv. Date|Curr|Invoice Amount|CSR No.|CSR Status|Rejected Date|APF|AP Date|AP Amount|Description|Rcvd Date|Due Date|R.O.E.|USD Amount|Remark|cgo_clm_pay_no";
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 8, 0, true);
	         
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
           	InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	true,		"dataSeq",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			90,		daLeft,	true,		"clm_cost_tp_nm",			false,      "",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			120,	daLeft,	true,		"clm_pty_nm",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"inv_no",			false,      "",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"inv_dt",			false,      "",				dfDateYmd,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"locl_curr_cd",			false,      "",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daRight,	true,	"inv_amt",			false,      "",				dfFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,		"csr_no",			false,		"",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"inv_sts_cd",			false,      "",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"ap_cxl_dt",			false,      "",				dfDateYmd,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		"ap_pay_flg",			false,      "",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"ap_pay_dt",			false,		"",				dfDateYmd,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daRight,	true,	"ap_pay_amt",			false,      "",				dfFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			150,		daCenter,	true,	"cost_desc",			false,      "",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"pay_dt",			false,      "",				dfDateYmd,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"inv_eff_dt",			false,      "",				dfDateYmd,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"inv_xch_rt",			false,      "",				dfFloat,		5,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,		daRight,	true,	"inv_usd_amt",			false,      "",				dfFloat,		2,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			120,		daLeft,	true,	"inv_rmk",			false,      "",				dfNone,		0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		120,		daCenter,	true,	"cgo_clm_pay_no",			false,      "",				dfNone,		0,			true,		true);
			
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
function setLocation(rowArray) { 
   frm.loc_cd.value = rowArray[0][3];
}




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
			var vCal = new ComCalendar();
			vCal.setDisplayType("date");
			vCal.select(frm.inv_eff_dt, "yyyy-MM-dd");
			break;
			// Down Excel
		case "btn1_Down_Excel":		
			if (sheet1.RowCount > 0 ) {
				var columnSkipList = "ibflag|cgo_clm_pay_no";
				sheet1.SpeedDown2Excel(1,false,false,"","",false,false,"Processing Status",true,columnSkipList);
			}
			break;	
		case "btn1_Handling_Costs": 
			var cgo_clm_no = frm.cgo_clm_no.value;
			popupHandlingCost(cgo_clm_no);
			break;			
	    	
	}

}

/**
 * HTML Control KeyPress 이벤트 호출
 */
function keypressCgoClmNo() {
 	var obj = event.srcElement;
    switch (obj.name) {    
    case "cgo_clm_no":
    	if (obj.value.length == 10) {    		
    		doActionIBSheet(SEARCHLIST01);
    	}
    	break;
	}
}

 /**
  * HTML Control KeyPress 이벤트 호출
  */
 function keypressFormat() {
  	var obj = event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus = obj.dataformat;
     switch (obj.name) {    
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
   	case "inv_eff_dt":
   		ComChkObjValid(frm.inv_eff_dt)			
   		break;		
    case "inv_net_amt":
    case "inv_vat_amt":
    case "whld_tax_amt":		
   		ComChkObjValid(event.srcElement);
   		break;   		
   	}
   } 
	 
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================

/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnDblClick(sheet, row, col) {
	var cgoClmPayNo = sheet1.CellValue(row , "cgo_clm_pay_no");
	frm.cgo_clm_pay_no.value = cgoClmPayNo;
	doActionIBSheet(SEARCHLIST02);
}


/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value = SEARCHLIST01;		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0045GS.do", FormQueryString(frm));

		var cgoClmNo = frm.cgo_clm_no.value;			
		ComResetAll();
		frm.cgo_clm_no.value = cgoClmNo;
		
		sheet1.LoadSearchXml(sXml);		
		var list = SheetXml2ListMap(sXml);
		if (list.length > 0) {
			var vo = list[0];
			frm.clm_area_cd.value                = vo["clm_area_cd"];
			frm.hdlr_ofc_cd.value                = vo["hdlr_ofc_cd"];
			frm.hdlr_usr_id.value                = vo["hdlr_usr_id"];			
			frm.cgo_clm_sts_nm.value             = vo["cgo_clm_sts_nm"];
			frm.cgo_clm_div_nm.value             = vo["cgo_clm_div_nm"];			
		} else {
			frm.cgo_clm_no.value = "";
			frm.cgo_clm_no.focus();
		}
		
		
		// --------------------------------
		// 권한설정 
		// --------------------------------
		setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save");
		
		
	} else if (sAction == SEARCHLIST02) {
		frm.f_cmd.value = SEARCHLIST02;		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0045GS.do", FormQueryString(frm));
		
		// ------------------------------------------------------------
		// Case Vo
		// ------------------------------------------------------------		
		var list = SheetXml2ListMap(sXml);
		if (list.length > 0) {
			
			var vo = list[0];
			frm.inv_no.value				    	= vo["inv_no"];
			frm.inv_dt.value				    	= fmDate(vo["inv_dt"]);
			//Rcvd Date
			frm.pay_dt.value				    	= fmDate(vo["pay_dt"]);
			
			frm.clm_cost_tp_nm.value                = vo["clm_cost_tp_nm"];
			frm.clm_cost_tp_cd.value                = vo["clm_cost_tp_cd"];
			
			frm.acct_cd.value                       = vo["acct_cd"];
			
			if (ComIsNull(frm.acct_cd.value)) {
				var clmCostTpCd = vo["clm_cost_tp_cd"];
				var acctCd = "";
				// legal standard
				if (clmCostTpCd == "LS" || clmCostTpCd == "LC" ) {
					//lawyers fee
					acctCd = "564651";
				// survey , settlement , other standard
				} else if (clmCostTpCd == "SS" || 
						clmCostTpCd == "SC" ||
						clmCostTpCd == "TS" ||
						clmCostTpCd == "TC" ||
						clmCostTpCd == "OS" ||
						clmCostTpCd == "OC") {
					// Cargo claims due to cargo
					acctCd = "512541";
					
			    // survey ,legal, settlement , other prepayment					
				} else if (clmCostTpCd == "SP" || 
						clmCostTpCd == "LP" ||
						clmCostTpCd == "TP" ||
						clmCostTpCd == "OS") {
					// Cargo claims due to cargo
					acctCd = "113321";
				}
				
				frm.acct_cd.value = acctCd;
			}
			
			
			frm.inv_ofc_cd.value                    = vo["inv_ofc_cd"];		
			
			if (ComIsNull(frm.inv_ofc_cd.value)) {
				frm.inv_ofc_cd.value  = frm.hdlr_ofc_cd.value;
			}
			
			frm.clm_pty_abbr_nm.value               = vo["clm_pty_abbr_nm"];
			frm.pty_nm.value                        = vo["pty_nm"];
			
			frm.cost_ofc_cd.value                   = vo["cost_ofc_cd"];			
			frm.trnk_ref_vvd_no.value               = vo["trnk_ref_vvd_no"];
			frm.slan_cd.value               		= vo["slan_cd"];
			frm.vndr_seq.value                      = vo["vndr_seq"];
			frm.vndr_lgl_eng_nm.value               = vo["vndr_lgl_eng_nm"];
			frm.ap_ctrl_ofc_cd.value                = vo["ap_ctrl_ofc_cd"];
			
			frm.locl_curr_cd.value                  = vo["locl_curr_cd"];
			frm.inv_amt.value                       = ComAddComma(vo["inv_amt"]);		
			frm.inv_net_amt.value                   = ComAddComma(vo["inv_net_amt"]);
			frm.cost_desc.value                     = vo["cost_desc"];
			
			frm.inv_vat_amt.value                   = ComAddComma(vo["inv_vat_amt"]);
			frm.whld_tax_amt.value                  = ComAddComma(vo["whld_tax_amt"]);
			frm.inv_rgst_no.value                   = vo["inv_rgst_no"];
			frm.cre_dt.value                        = fmDate(vo["cre_dt"]);
			frm.inv_eff_dt.value              		= fmDate(vo["inv_eff_dt"]);
			frm.vndr_term_nm.value                  = vo["vndr_term_nm"];
			frm.inv_rgst_seq.value                  = vo["inv_rgst_seq"];
			
			//상태가 X이면 버튼 활성화  2010-04-07 ADD CYO
			frm.inv_sts_cd.value                    = vo["inv_sts_cd"];
			
			if (ComIsNull(frm.vndr_seq.value)) {
				ComShowCodeMessage("CNI00111");
				ComBtnDisable("btn1_Save");
				return;
			}
			
			
			if (!ComIsNull(frm.inv_rgst_no.value) && frm.inv_sts_cd.value != "X") {				
				ComBtnDisable("btn1_Save");				
			} else {
				// --------------------------------
				// 권한설정 
				// --------------------------------
				setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save");			
			}			
			
		}
		
		
	} else if (sAction == MULTI) {
		frm.f_cmd.value = MULTI;
		var sXml = sheet1.GetSaveXml("CPS_CNI_0045GS.do", FormQueryString(frm));
		
		var error = ComGetEtcData(sXml , "ERROR");
		// cost office 미존재
		if (error == "1") {
			// Cost Office 미존재
			ComShowCodeMessage("CNI00020" , "Cost Office");
		} else if (error == "2") {
			// 재무항차 미존재 
			ComShowCodeMessage("CNI00020" , "Revenue VVD");
		} else if (error == "N") {
			//재조회
			doActionIBSheet(SEARCHLIST02);
		} else {
			sheet1.LoadSaveXml(sXml);			
		}
		
	} 
}

