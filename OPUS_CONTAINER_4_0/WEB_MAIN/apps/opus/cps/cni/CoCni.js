/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoCni.js
*@FileTitle  : Cni Common javascript
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	if(msgs == undefined){
		msgs = new Array();
	}

var CNI_PAGE_SIZE = 500;

// --------------------------------------------------------
// 메세지 관련
// -------------------------------------------------------
// CCC  ---------------------------
msgs["CNI99999"] = "Unexpected system error took place during data\nprocessing. \nPlease try again !";
msgs["CNI00001"] = "{?msg1} data is invalid !";
msgs["CNI00002"] = "{?msg1} is duplicated !";
msgs["CNI00003"] = "Please input all required entry fields {?msg1} !";
msgs["CNI00004"] = "{?msg1} You have no authority to request, Please check your authority !";
msgs["CNI00005"] = "{?msg1} Input data exceeds the length of field !";
msgs["CNI00006"] = "Really initialize unsaved data ?";
msgs["CNI00008"] = "Saved successfully.";
msgs["CNI00009"] = "Please input {?msg1} !";
msgs["CNI00010"] = "Deleted successfully.";
msgs["CNI00011"] = "Really initialize unsaved data ?";
msgs["CNI00012"] = "Data changed. Really save ?";
msgs["CNI00013"] = "No data found.";
msgs["CNI00014"] = "Really execute ?";
msgs["CNI00015"] = "Really initialize ?";
msgs["CNI00016"] = "Really delete ?";
msgs["CNI00017"] = "Really save changed data ?";
msgs["CNI00018"] = "Please select {?msg1} !";
msgs["CNI00019"] = "No updated data to be saved !";
msgs["CNI00020"] = "No existing {?msg1} !";
msgs["CNI00021"] = "Really cancel ?";
msgs["CNI00022"] = "No data to be saved !";
msgs["CNI00023"] = "No data to be deleted !";
msgs["CNI00024"] = "No data to be printed !";
msgs["CNI00102"] = "No Claim No to be Saved !";
msgs["CNI00103"] = "Please download after retrieve or save !";
msgs["CNI00104"] = "Please input either DOR or DOL !";
msgs["CNI00105"] = "No Deductible. Please update Insurance Entry Status !";
msgs["CNI00106"] = "Exceeding Recoverable Amount !";
msgs["CNI00107"] = "Your transfer is still pending ! \nPlease complete the process !";
msgs["CNI00108"] = "Please remark the reason for rejection !";
msgs["CNI00109"] = "Please input HOFC before inputing Handler !";
msgs["CNI00033"] = "Impossible to cancel !";
msgs["CNI00034"] = "Please check your Entered Data. {?msg1} !";
msgs["CNI00035"] = "Same B/L Found! Please check Duplication !";
msgs["CNI00036"] = "Please make it larger than 'From the Amount' or null !";
msgs["CNI00110"] = "Approval Status is pending or complete !";
msgs["CNI00111"] = "Please map S/Provider with Customer Code on Main Code Creation !";
msgs["CNI00112"] = "Really correct INS Claimed Amount?\n Yes or No.";	
msgs["CNI00113"] = "Really correct Recoverable Amount?\n Yes or No.";		
msgs["CNI00114"] = "Under Deductible! Please reconfirm INS Claimed Amount!";
msgs["CNI00115"] = "Canceled successfully.";
msgs["CNI00116"] = "At least 1 Contact Person is needed.";


msgs["CNI25006"] = "There is no data retrieved." ;
msgs["CNI21908"] = "There is no row selected.";
msgs["CNI40048"] = "There is no CSR No. on selected row." ;
msgs["CNI40041"] = "{?msg1} has been omitted." ;

// DWC ,INS  ---------------------------
msgs["CNI09001"] = "Saved successfully !";
msgs["CNI09002"] = "Data changed. Really execute?";
msgs["CNI09003"] = "{?msg1} is a compulsory input !";
msgs["CNI09004"] = "Really cancel ?";
msgs["CNI09005"] = "No existing {?msg1} !";
msgs["CNI09006"] = "No data to be saved !";
msgs["CNI09007"] = "No data to {?msg1} !";
msgs["CNI09008"] = "Failed to save File Upload !";
msgs["CNI09009"] = "The maximum length of {?msg1} is {?msg2} digits !";
msgs["CNI09010"] = "Failed to retrieve File Upload !";
msgs["CNI09010"] = "Failed to retrieve Miscellaneous Code !";
msgs["CNI09011"] = "Failed to retrieve DW Claim Main !";
msgs["CNI09012"] = "Failed to save DW Claim Main !";
msgs["CNI09013"] = "Failed to cancel DW Claim Main !";
msgs["CNI09014"] = "Failed to retrieve Name of Vessel !";
msgs["CNI09015"] = "Failed to validate Handler !";
msgs["CNI09016"] = "No existing Currency !";
msgs["CNI09017"] = "Failed to retrieve Handling Cost !";
msgs["CNI09018"] = "Failed to save Handling Cost !";
msgs["CNI09019"] = "Failed to retrieve DW Claim Status !";
msgs["CNI09020"] = "No Agent Code retrieved !";
msgs["CNI09021"] = "Failed to close DW Claim case !";
msgs["CNI09022"] = "Failed to reopen DW Claim !";
msgs["CNI09023"] = "Really close ?";
msgs["CNI09024"] = "Really reopen ?";
msgs["CNI09025"] = "Really cancel ?";
msgs["CNI09026"] = "Impossible to close !";
msgs["CNI09027"] = "Failed to retrieve Office Code !";
msgs["CNI09028"] = "Please input {?msg1} !";
msgs["CNI09029"] = "Failed to retrieve VVD !";
msgs["CNI09030"] = "Failed to retrieve Exchange Rate !";
msgs["CNI09031"] = "Failed to retrieve Vessel !";
msgs["CNI09032"] = "Payee doesn't exist.$s !";
msgs["CNI09033"] = "Impossible to cancel !";
msgs["CNI09034"] = "Please input Name of Vessel of one digit or more !";
msgs["CNI09035"] = "Please input Name or Voyage of Vessel of 4 digits or more !";
msgs["CNI09050"] = "Failed to retrieve Insurance !";
msgs["CNI09051"] = "Failed to save Insurance !";
msgs["CNI09052"] = "Failed to retrieve Premium !";
msgs["CNI09053"] = "Failed to save Premium !";
msgs["CNI09054"] = "Failed to retrieve Hull Insurance !";
msgs["CNI09055"] = "Failed to save Hull Insurance !";
msgs["CNI09056"] = "Failed to retrieve the Vessel !";
msgs["CNI09057"] = "Failed to retrieve the Flag !";
msgs["CNI09058"] = "From Date must be earlier than To Date !";
msgs["CNI09059"] = "Currency must be same as Total Currency !";
msgs["CNI09060"] = "Failed to delete Insurance Main File !";
msgs["CNI09061"] = "Failed to delete Premium File !";
msgs["CNI09062"] = "Existing Type of Insurance Main !";
msgs["CNI09063"] = "Existing Type of Premium !";
msgs["CNI09064"] = "No Type of Insurance Main input !";
msgs["CNI09065"] = "No Type of Premium !";
msgs["CNI09066"] = "Please input Main Terms first !";
msgs["CNI09067"] = "Failed to retrieve Vessel-related items !";	
msgs["CNI09068"] = "Please input Payee !";
msgs['CNI09069'] = "This Invoice No was already created. Please check it again.";
msgs['CNI09070'] = "Payee does not a vendor. Please customer code maps first which has a refund vendor code"
	
//--------------------------------------------------------
// 팝업 관련
//-------------------------------------------------------
/**
* Array의 값에 중복 된 데이타 여부
* function setLocation(rowArray) { 
*    frm.locCd.value = rowArray[0][3];
* }
*  
*/
function popupLocation() {
	var display = "0,0,1,1,0,1,1,1,1,0,1,1";
	ComOpenPopup("COM_ENS_051.do", 850, 600, "setLocation", display);
	//Location Code = rowArray[0][3]; 
}

/**
* Office Code 팝업호출
* @return  Office Code
* 사용법 : opener에서 setOfficeCode(ofcCd) 를 구현해야함.
*/
function popupOfficeCode() { 
	var url = "CPS_CNI_0007.do";
	var winName = "CPS_CNI_0007";
	var reqWin = openWinCenter(url,winName,600,500);
	reqWin.focus();
	return reqWin;
}


/**
* Misc 팝업호출
* @return  misc Code
* 사용법 : opener에서 setMiscCode(MiscCode) 를 구현해야함.
*/
function popupMainMiscView(clss_clm_misc_cd) { 
	var url = "CPS_CNI_0029_01.do?popupYn=Y&clss_clm_misc_cd=" + clss_clm_misc_cd ;
	var winName = "CPS_CNI_0029_01";
	var reqWin = openWinCenter(url,winName,1020,440);
	reqWin.focus();
	return reqWin;
}


/**
* Customer (COM_ENS_041) 팝업호출
* @return  customer code
* 사용법 : opener에서 setCustomer(arr) 를 구현해야함.
*/
function popupCustomer() { 
	var display = "0,0,1,1,1,0,1,0,1,1,0,0,1,1";	
	ComOpenPopup("COM_ENS_041.do", 768, 460, "setCustomer", display);
	//Location Code = rowArray[0][3];
	
}

/**
* Main Code View 팝업호출 Style
* @param {String} clmPtyNo party no
*/
function popupMainCodeView(clmPtyNo) {
	var param = "&clm_pty_no=" + clmPtyNo;
	var url = "CPS_CNI_0027_01.do?popupYn=Y"+param;
	var winName = "CPS_CNI_0027_01";
	var reqWin = openWinCenter(url,winName,1020,660);	
	reqWin.focus();
	return reqWin;
	
}

/**
* Main Code-Inquiry 팝업호출
* 각화면에서 setMainCodeInquiry(partyVo) 메소드 구현
* setMainCodeInquiry(partyVo) {
	frm.clm_pty_no.value = partyVo.clm_pty_no;
	frm.clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
	frm.pty_nm.value = partyVo.pty_nm;
	frm.intl_phn_no.value = partyVo.intl_phn_no;
	frm.phn_no.value = partyVo.phn_no;
	frm.loc_cd.value = partyVo.loc_cd;
	frm.pty_eml.value = partyVo.pty_eml;
 } 
*/
function popupMainCodeInquiry() {	
	var url = "CPS_CNI_0041.do";
	var winName = "CPS_CNI_0041";
	var reqWin = openWinCenter(url,winName,600,540);	
	reqWin.focus();
	return reqWin;
}

/**
* R.O.E 팝업호출
* 각화면에서 setCurrencyROE(xchRtVo) 메소드 구현
* setCurrencyROE(xchRtVo) {
	frm.curr_cd.value = xchRtVo.curr_cd;
	frm.xch_rt.value = xchRtVo.usd_locl_xch_rt;
 } 
*/
function popupRateOfExchange(currCd, yrMon) {
	if (currCd == undefined || currCd == null) {
		currCd = "";
	} 	
	if (yrMon == undefined || yrMon == null) {
		yrMon = "";
	} 	
	var url = "CPS_CNI_0307.do?curr_cd="+currCd+"&yr_mon="+ComReplaceStr(yrMon,"-","");
	var winName = "CPS_CNI_0307";
	var reqWin = openWinCenter(url,winName,800,450);	
	reqWin.focus();
	return reqWin;
}

/**
* Vessel 팝업호출
* 각화면에서 setVvdCd(vvdVo) 메소드 구현
* setVvdCd(vvdVo) {
	document.form.vvd_cd.value = vvdVo.vvd_cd;
	document.form.vsl_eng_nm.value = vvdVo.vsl_eng_nm;
 } 
*/
function popupVvdCd() {
	var url = "CPS_CNI_0306.do";
	var winName = "CPS_CNI_0306";
	var reqWin = openWinCenter(url,winName,800,430);	
	return reqWin;
}

/**
* Client Default Setup 팝업호출
*/
function popupClientDefaultSetup() {	
	var url = "CPS_CNI_0001_POP.do?popupYn=Y";
	var winName = "CPS_CNI_0001";
	var reqWin = openWinCenter(url,winName,400,150);
	reqWin.focus();
	return reqWin;
}

/**
* File Upload 팝업호출
* @param {String} clmFileTpCd (UI_ID 4자리) + (일련번호2자리) 
* @param {String} cgoClmRefNo 클레임번호 CC20090001
* 
* ex)Salvage  UI_CNI_0013 
* popupFileUpload("001301" , "CC20090001");
*/
function popupFileUpload(clmFileTpCd , cgoClmRefNo) {	
	var url = "CPS_CNI_0011.do?clm_file_tp_cd=" + clmFileTpCd + "&cgo_clm_ref_no=" + cgoClmRefNo;
	var winName = "CPS_CNI_0011";
	var reqWin = openWinCenter(url,winName,640,425);
	reqWin.focus();
	return reqWin;
}


/**
* Lane (COM_ENS_081) 팝업호출
* @return  lane 정보
* 사용법 : opener에서 setLane(arr) 를 구현해야함.
*/
function popupLane() {
	var display = "0,0,1,1,1,1,1,1";
	var param = "?mode=svc"
	ComOpenPopup("COM_ENS_081.do" + param, 768, 420, "setLane", display);
}



/**
* Vessel (COM_ENS_0A1)  팝업호출
* @return  Vessel 정보
* 사용법 : opener에서 setVessel(arr) 를 구현해야함.
*/
function popupVessel() {	
	var display = "0,0,1,1,1,1,1";	
	ComOpenPopup("COM_ENS_0A1.do" , 600, 400, "setVessel", display);
	//http://localhost:9001/opuscntr/COM_ENS_0A1.do?vsl_cd=&vsl_eng_nm=&car_cd=&classId=COM_ENS_0A1&pop_mode=1&display=1,0,1,1,1,1,1&func=getCOM_ENS_0A1_1
}

/**
* VVD (COM_ENS_0B2)   팝업호출
* @return  VVD 정보
* 사용법 : opener에서 setVVD(arr) 를 구현해야함.
*/
function popupVVD() {	
	var display = "0,0,1,1,1,1,1,1";	
	ComOpenPopup("COM_ENS_0B2.do?etdeta=A" , 768, 420, "setVVD", display);
	//http://localhost:9001/opuscntr/COM_ENS_0B2.do?etdeta=A&sdate=&edate=&vvd_cd=&loc_cd=&lane_cd=&oper=&classId=COM_ENS_0B2&pop_mode=1&display=1,0,1,1,1,1,1,1&func=getCOM_ENS_0B2_1
}

/**
* CCC VVD & SKD Inquiry   팝업호출
* @return  VVD 정보
* 사용법 : opener에서 setVvdSkd(vvdSkdVo) 를 구현해야함.
* function setVvdSkd(vvdSkdVo){
 		    frm.slan_cd.value = vvdSkdVo.slan_cd;
			frm.vvd.value = vvdSkdVo.vvd;
			frm.pol.value = vvdSkdVo.pol;
			frm.pod.value = vvdSkdVo.pod;
			frm.cct.value	=	vvdSkdVo.cct;
			frm.vps_etd_dt.value =  vvdSkdVo.vps_etd_dt;
			frm.vps_etb_dt.value =  vvdSkdVo.vps_etb_dt;
* }
*/
function popupVvdSkd(trnkRefVvdNo) {	
	if (trnkRefVvdNo == null || trnkRefVvdNo == undefined) {
		trnkRefVvdNo = "";
	}
	var url = "CPS_CNI_0042.do?trnk_ref_vvd_no=" + trnkRefVvdNo ;
	var winName = "CPS_CNI_0042";
	var reqWin = openWinCenter(url,winName,700,475);
	reqWin.focus();
	return reqWin;
}

/**
* Payment   팝업호출
* @return  Payment 정보
* 사용법 : opener에서 clmClmNo 를 parameter로 넘겨야함.
*/
function popupPayment(clmClmNo) {	
	if (clmClmNo == null || clmClmNo == undefined) {
		clmClmNo = "";
	}
	var url = "CPS_CNI_0008.do?cgo_clm_no=" + clmClmNo;
	var winName = "CPS_CNI_0008";
	var reqWin = openWinCenter(url,winName,800,510);
	reqWin.focus();
	return reqWin;
}


/**
* Insurance Recovery by VVD 팝업호출
* @param {String} vvd 
* 
*/
function popupInsuranceRecoveryByVVD(vvd) {	
	if (vvd == null || vvd == undefined) {
		vvd = "";
	}
	var url = "CPS_CNI_0016_01.do?popupYn=Y&trnk_ref_vvd_no=" + vvd;
	var winName = "CPS_CNI_0016";
	var reqWin = openWinCenter(url,winName,1020,650);
	reqWin.focus();
	return reqWin;
}

/**
* Handling Costs 팝업호출
* 사용법 : opener에서 clmClmNo 를 parameter로 넘겨야함.
*/
function popupHandlingCost(cgoClmNo) { 
	if (cgoClmNo == null || cgoClmNo == undefined) {
		cgoClmNo = "";
	}	
	var url = "CPS_CNI_0009_01.do?popupYn=Y&cgo_clm_no="+cgoClmNo;
	var winName = "CPS_CNI_0009_01";
	var reqWin = openWinCenter(url,winName,980,640);
	reqWin.focus();
	return reqWin;
}

/**
* Handler History 팝업호출
* 사용법 : opener에서 clmClmNo 를 parameter로 넘겨야함.
*/
function popupHandlerHistory(cgoClmNo) { 
	if (cgoClmNo == null || cgoClmNo == undefined) {
		cgoClmNo = "";
	}	
	var param = "cgo_clm_no=" + cgoClmNo;
	var url = "CPS_CNI_0004.do?" + param;
	var win3 = openWinCenter(url,"HandlerHistoryWin", 600, 380);	
	win3.focus();
	return win3;
}

/**
* Handler History 팝업호출(DWC)
* 사용법 : opener에서 dwClmNo 를 parameter로 넘겨야함.
*/
function popupDWCHandlerHistory(dwClmNo) { 
	if (dwClmNo == null || dwClmNo == undefined) {
		dwClmNo = "";
	}	
	var param = "dw_clm_no=" + dwClmNo;
	var url = "CPS_CNI_0310.do?" + param;
	var win3 = openWinCenter(url,"HandlerHistoryWin", 600, 380);	
	win3.focus();
	return win3;
}

/**
* Impending TB Claim 팝업호출
* main , indeminty에서 페이지 로딩시 호출
*/
function popupImpendingTBClaim() {	
	var url = "CPS_CNI_0043.do";
	var win3 = openWinCenter(url,"ImpendingTBClaim", 520, 600);	
	win3.focus();
	return win3;
}


/**
* Prevention Register 팝업호출
*/
function popupPreventionRegister(clmPrveNo) {	
	if (clmPrveNo == null || clmPrveNo == undefined) {
		clmPrveNo = "";
	}	
	var url = "CPS_CNI_0023_01.do?popupYn=Y&clm_prve_no=" + clmPrveNo ;
	var win = openWinCenter(url,"PreventionRegister", 880, 460);	
	win.focus();
	return win;
}


/**
* Prevention View 팝업호출
*/
function popupPreventionView(clmPrveNo) {	
	if (clmPrveNo == null || clmPrveNo == undefined) {
		clmPrveNo = "";
	}		
	var url = "CPS_CNI_0024_01.do?popupYn=Y&clm_prve_no=" + clmPrveNo ;
	var win = openWinCenter(url,"popupPreventionView", 880, 590);
	win.focus();
	return win;
}

/**
* Claim Main View 팝업호출
*/
function popupClaimMainView(cgoClmNo) {	
	if (cgoClmNo == null || cgoClmNo == undefined) {
		cgoClmNo = "";
	}	
 	var url = "CPS_CNI_0033_01.do?popupYn=Y&cgo_clm_no=" + cgoClmNo;
 	var winName = "CPS_CNI_0033_01";
 	var reqWin = openWinCenter(url,winName,1124,620);	
 	reqWin.focus();
 	return reqWin;
}

/**
* 공통 RD View Open
*/
function popupRd(width,height) {	
	var url = "CPS_CNI_9999.do";		
	var winName = "CPS_CNI_9999";	
	var rdWin = openWinCenter("about:blank",winName,width,height);
	frm.action = url;
	frm.method = "post";
	frm.target = winName;
	frm.submit();
	frm.target = "";
	rdWin.focus();
	return rdWin;
}

//--------------------------------------------------------
// 일반, Form , HTML 관련  
//-------------------------------------------------------
/**
* YYYY-MM-DD 포멧처리
* @param {String}  yyyymmdd
* @return {String} YYYY-MM-DD 
*/
function fmDate(yyyymmdd) {
	
	if (ComIsNull(yyyymmdd)) {
		return "";
	}
	
	if (yyyymmdd.length != 8) {
		return yyyymmdd;
	}
	
	var fmDt = yyyymmdd.substring(0,4) + "-" + 
	             yyyymmdd.substring(4,6) + "-" + 
	             yyyymmdd.substring(6,8);
	
	return  fmDt;
	
}

/**
* 입력문자 대문자로 변환
*/
function KeyOnlyUpper() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;	
	 if(keyValue >= 97 && keyValue <= 122){                  //소문자
		 event.keyCode ? event.keyCode : event.which ? event.which : event.charCode = keyValue + 65 - 97;
     }
}

/**
* 입력문자 소문자로 변환
*/
function KeyOnlyLower() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;	
	if(keyValue >= 65 && keyValue <= 90){            //대문자
		event.keyCode ? event.keyCode : event.which ? event.which : event.charCode = keyValue + 97 - 65;
    }
}

/**
* 윈도우 Center에서 열기   <br>
* @param {string} url url
* @param {string} winName 타겟  
* @param {int} width 타겟
* @param {int} height 타겟 
* @author 진윤오
* @version 2009.05.13
*/
function openWinCenter(url,winName,width,height , scrollYn) {
	   var left = (screen.width - width)/2;    
	   if(left < 0) {
		   left = 0;
	   }
       var top  = (screen.height- width)/2;   
       if( top < 0 ) {
    	   top = 0;
       }
       if (scrollYn == undefined) {
    	   scrollYn = "N";
       }
       
       if (ComIsNull(scrollYn)) {
    	   scrollYn = "no";
       } else {
    	   if (scrollYn == "Y") {
    		   scrollYn = "yes";
    	   } else {
    		   scrollYn = "no";
    	   }
       }
       
       var feature = 
    	   "status=no, resizable=yes, scrollbars="+scrollYn+", width="+width+", height="+height+", left="+left+", top="+top;
       
       var win = window.open(url,winName,feature);
       win.focus();
       
       return win;
	
}

/**
* Array의 값에 중복 된 데이타 여부 
* @param {map} Array[name] 의 값
* @return 중복 true 미중복 false 
*/
function isDupData(arr) {	
		
	for( var i = 0 ; i < arr.length ;  i++ ) {
		var a = arr[i];
		for( var j = i+1 ; j < arr.length ;  j++ ) {			
			var b = arr[j];
			if ( a == b ) {
				return true;
			}
		}
	}
	
	return false;

}

/**
* LOC금액을  USD 금액으로 환산  계산
* @param {float} 로컬금액
* @param {float} 로컬단위 천단위 일단위 
* @param {float} USD변환 경리 환율
**/
function getUsdAmt(loclAmt , loclUtVal , usdLoclXchRt  ) {
	 
	//FM LOC
	var locl_amt = removeComma(loclAmt);
	
	//FM USD
	var usd_locl_xch_rt = removeComma(usdLoclXchRt);
	
	//FM 단위
	var ut_val = removeComma(loclUtVal);
	
	if (locl_amt < 0) {
		return Math.floor( (locl_amt * ut_val) / usd_locl_xch_rt);	
	} else {
		return Math.ceil( (locl_amt * ut_val) / usd_locl_xch_rt);
	}
	
	
			
}


/**
 * USD금액을  LCL 금액으로 환산  계산
 * @param {float} 로컬금액
 * @param {float} 로컬단위 천단위 일단위 
 * @param {float} 로컬변환 경리 환율 
 **/
function getLclAmt(usdAmt , loclUtVal , usdLoclXchRt) {
	 	
	//TO USD
	var usd_amt = removeComma(usdAmt);
	//TO 단위
	var ut_val = removeComma(loclUtVal);
	//TO RATE
	var usd_locl_xch_rt = removeComma(usdLoclXchRt);

	//KRW금액 계산 (USD / (UNIT*RATE)
	return Math.ceil( (usd_amt * usd_locl_xch_rt) / ut_val);
	
}
 
 
 /**
 * 콤보 박스 내용 복사   <br>
 * @param {combo} combo1 원본
 * @param {combo} combo2 대상  
 * @param {boolean} init 대상콤보 initializing 여부 
 * @author 진윤오
 * @version 2009.05.13
 */
 function copySelectBox(combo1, combo2 , init) {
 	
 	if (init) {
 	 combo2.length = 0;
 	}
 	
 	for ( var i = 0; i < combo1.length; i++) {
 		var val = combo1.options[i].value;
 		var txt = combo1.options[i].text;
 		ComAddComboItem(combo2 , txt , val);
 	}
 	
 	combo2.value = combo1.value;
 } 
 
 
 /**
 *  체크박스 value를 ","로 문자열 연결   <br>
 * @param {obj} checkbox
 * @return checked value '1,2,3'  콤마(,) 로분리
 * @author 진윤오
 * @version 2009.05.13
 */
 function checkBoxValue(obj) {
 	var txt = "";
 	if (obj.length) {
 		var checked = 0;
 		for ( var i = 0; i < obj.length; i++) {
 			if (obj[i].checked) {
 				txt += "," + obj[i].value;
 				checked++;
 			}
 		}		
 		
 		if (checked > 0) {
 			return txt.substring(1 ,txt.length);
 		} else {
 			return "";
 		}
 		
 	} else {
 		if (obj.checked) {
 			return obj.value;
 		}
 	}
 	
 	return txt;
 }
 
 
 /**
  * select box onChange시 포커스 아웃
  * 
  */
 function focusOut() {
 	document.body.focus();
 }
 
  /**
   * form 에서 format 주고 parseFloat 시 comma 값 처리. (input : object)
   * 
   */
 function cniParseFloat(obj){
	 var value = obj.value.trim().replace(/\,/g,"");
	 if (value == "") value = "0"; 
	 return parseFloat(value);
 }
 
 /**
 * parseFloat 시 comma 값 처리. (input : value)
 * 
 */
function cniParseFloat2(objValue){
	if(typeof objValue == "number") {
	 return parseFloat(objValue);
	}
	else if(typeof objValue == "string") {
	 var value = objValue.trim().replace(/\,/g,"");
	 if (value == "") value = "0"; 
	 return parseFloat(value);
	}
}
 
 /**
  * form 에서 format 주고 parseInt 시 comma 값 처리. 
  * 
  */
function cniParseInt(obj){
	 var value = obj.value.trim().replace(/\,/g,"");
	 if (value == "") value = "0"; 
	 return parseInt(value);
} 
 
//--------------------------------------------------------
// 시트 관련  
//-------------------------------------------------------

/**
* Vo List를 array[array[name]]형태로 변환 
* @param {xml} xmlStr 조회 결과 (SC에서 setRsVoList , setRsVo 호출시) 
*/
function SheetXml2ListMap(xmlStr) {
	
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}

	try {
        var xmlDoc = ComGetXmlDoc(xmlStr);
        if (xmlDoc == null) return;
        var xmlRoot = xmlDoc.documentElement;

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return rtnArr;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		if (total == 0) {
			return rtnArr;
		}
		
		var dataCount=0;
		var dataChileNodes = dataNode.childNodes;
		if (dataChileNodes == null) {
			return rtnArr;
		}

		for ( var i = 0; i < dataChileNodes.length; i++) {
			if (dataChileNodes[i].nodeType != 1) {
				continue;
			}
			
			var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

			var subDataArr = new Array();
			
			for ( var j = 0; j < arrData.length; j++) {
				subDataArr[colArr[j]] = arrData[j];
			}
			
			rtnArr[dataCount] = (subDataArr);
			dataCount++;
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}





/**
* Status가 "D"가 아닌 row의 갯수를 가져온다 <br>
* <br><b>Example :</b>
* <pre>
*     rowCnt = SheetRowCount(sheetObj);
* </pre>
* @param {ibsheet} sheetObj 필수 IBSheet Object
* @return int sheet내의 유효한 row수
* @author 박성수
* @version 2009.05.13
*/
function SheetRowCount(sheetObj) {
   return (sheetObj.RowCount() - sheetObj.RowCount("D"));
}

/**
* 행을 삭제 <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {int} row 컬럼명
* @return 행번호 [1,3,7]
* @author 진윤오
* @version 2009.05.13
*/
function SheetRowDelete(sheet,row) {
	
	var status = sheet.GetRowStatus(row);
	
	if (status == "I") {
		sheet.RowDelete(row,false);
	} else {
		sheet.SetRowHidden(row, true);
		sheet.SetRowStatus(row, "D");
	}
	
}


/**
* 체크박스에서 checked된 Rows 취득 <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {string} chkColName 선택 컬럼명
* @return 행번호 [1,3,7]
* @author 진윤오
* @version 2009.05.13
*/
function SheetCheckedRows(sheet , chkColName) {
	
	var sRow = "";
	if (!ComIsNull(chkColName)) {
		sRow = sheet1.FindCheckedRow(chkColName);
	} else {
		sRow = sheet1.FindCheckedRow("delChk");
	}
	
	if (ComIsNull(sRow)) {
		return null;
	}
	
	var arrRow = sRow.split("|"); //결과 : "1|3|5|"
	//마지막 빈공백 요소 제거 
	arrRow.pop();
	
	return arrRow;
	
	
}





/**
* 시트 첫번째 행번호  <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {int} 시작 행 Index 해더가 2행이면 2  , 1행이면 1  
* @return 행번호 삭제가 아니 행번호
* @author 진윤오
* @version 2009.05.13
*/
function SheetFirstRowNum(sheet , rowIdx) {
	
	var idx = 1;
	
	if (rowIdx != null && rowIdx > 0) {
		idx = rowIdx;
	}
	
	for ( var i = 0; i < sheet.RowCount(); i++) {
		var row =  i + idx;
		if (sheet1.RowStatus(row) == "D")  {
			continue;
		} else {
			return row;
		}
	}
	
}





/**
*  선택한 시트의 row의 column값을 request queryString으로 변환   <br>
* @param {ibsheet} sheet IBSheet
* @param {long} row selected row number
* @return request queryString
* @author 진윤오
* @version 2009.05.13
*/
function SheetRowQueryString(sheet , row) {
	var queryString="";
	for ( var col=0; col <= sheet.LastCol(); col++) {
		queryString += "&" + sheet.ColSaveName(col) + "=" + sheet.GetCellValue(row,col);
	}
	if (queryString != "") {
		queryString=queryString.substring(1 ,queryString.length);
	}
	return queryString;
}





/**
* 일반 Html 콤보 설정<br>
* @param {select box} 콤보 객체
* @param {xml} code , name의 xml
* @param {String} 초기 선택 Code 
* @author 진윤오
* @version 2009.05.13
*/
function setComboBox(combo , xml , selected) {	
	if (xml == null) {
		return;
	}
	
	var list = SheetXml2ListMap(xml);			
	
	for(var i = 0 ; i < list.length; i++) {
		var code = list[i];
		ComAddComboItem(combo ,code["name"] , code["code"]);
	}
	
	combo.value = selected;
	
}


/**
* role 존재 여부 체크
* @param {String} role 비교대상 role
* @author 진윤오
* @version 2009.05.13
*/
function equalsRole(role) {
	var roles = frm.usr_roles.value;	
	
	if (roles.indexOf(role) == -1 ) {
		return false;
	} else {
		return true;
	}	
}

/**
* 로그인 Area 같은지 비교 
* @param {String} area 비교대상 area
* @author 진윤오
* @version 2009.05.13
*/
function equalsArea(area) {
	var usrArea = frm.usr_area.value;	
	if (usrArea == area ) {
		return true;
	} else {
		return false;
	}	
}

/**
* 로그인 office 같은지 비교 
* @param {String} office 비교대상 office
* @author 진윤오
* @version 2009.05.13
*/
function equalsOffice(office) {
	var usrOffice = frm.usr_office.value;	
	if (usrOffice == office ) {
		return true;
	} else {
		return false;
	}	
}

/**
* 로그인 ID 같은지 비교 
* @param {String} usr_id 비교대상 hdlr_usr_id
* @author 진윤오
* @version 2009.05.13
*/
function equalsHdlrId(hdlrId) {
	var usrHdlrId = frm.usr_id.value;	
	if (usrHdlrId == hdlrId ) {
		return true;
	} else {
		return false;
	}	
}

/**
* 화면 버튼 컨트롤 CCC
* @param {String} hdlr_usr_id 개별화면 변수값
* @param {String} clm_area_cd 개별화면 변수값
* @param {String} hdlr_ofc_cd 개별화면 변수값
* @param {String} btnStr 버튼name ex)btn1_Save,btn1_Handling_Costs
* @param {String} 권한있는유저가 초기페이지, 또는 New 버튼클릭시 Save 버튼 활성화 (Y,N)
* @author 양정란
* @version 2010.03.10
*/
function setRollBtnCtl(hdlr_usr_id, clm_area_cd, hdlr_ofc_cd, btnStr, createParam){
	
	var arrBtn = btnStr.split(",");
	
//	if (equalsRole("CNI03")||equalsRole("CNI93")){//All save.
		for (var i=0;i<arrBtn.length;i++) {
			ComBtnEnable(arrBtn[i].trim());
		}
//	}
//	else if (equalsRole("CNI02")){//ID, Area save.
//		if(createParam == "Y"){
//			for (var i=0;i<arrBtn.length;i++) {
//				ComBtnEnable(arrBtn[i].trim());
//			}
//		}else{
//			if (equalsArea(clm_area_cd)){
//				for (var i=0;i<arrBtn.length;i++) {
//					ComBtnEnable(arrBtn[i].trim());
//				}
//			}else{
//				for (var i=0;i<arrBtn.length;i++) {
//					ComBtnDisable(arrBtn[i].trim());
//				}			
//			}			
//		}
//	}
//	else if (equalsRole("CNI01")){//ID, Office Check.
//		if(createParam == "Y"){
//			for (var i=0;i<arrBtn.length;i++) {
//				ComBtnEnable(arrBtn[i].trim());
//			}
//		}else{
//			if (equalsHdlrId(hdlr_usr_id) && equalsOffice(hdlr_ofc_cd)){
//				for (var i=0;i<arrBtn.length;i++) {
//					ComBtnEnable(arrBtn[i].trim());
//				}
//			}else{
//				for (var i=0;i<arrBtn.length;i++) {
//					ComBtnDisable(arrBtn[i].trim());
//				}			
//			}
//		}
//	}else if (equalsRole("CNI19")){//조회사용자.
//		for (var i=0;i<arrBtn.length;i++) {
//			ComBtnDisable(arrBtn[i].trim());
//		}
//	}else{
//		for (var i=0;i<arrBtn.length;i++) {
//			ComBtnDisable(arrBtn[i].trim());
//		}
//	}
}


/**
* Prevention화면 버튼 컨트롤 
* @param {String} hdlr_usr_id 개별화면 변수값
* @param {String} btnStr 버튼name ex)btn1_Save,btn1_Handling_Costs
* @author 양정란
* @version 2010.03.10
*/
function setRollBtnCtlPrevention(hdlr_usr_id, btnStr){
	
	var arrBtn = btnStr.split(",");
	
//	if (equalsRole("CNI42")||equalsRole("CNI93")){//All save.
		for (var i=0;i<arrBtn.length;i++) {
			ComBtnEnable(arrBtn[i].trim());
		}
//	}
//	else if (equalsRole("CNI41")){//ID, Office Check.
//		if (equalsHdlrId(hdlr_usr_id)){
//			for (var i=0;i<arrBtn.length;i++) {
//				ComBtnEnable(arrBtn[i].trim());
//			}
//		}else{
//			for (var i=0;i<arrBtn.length;i++) {
//				ComBtnDisable(arrBtn[i].trim());
//			}			
//		}
//	}else if (equalsRole("CNI49")){//조회사용자.
//		for (var i=0;i<arrBtn.length;i++) {
//			ComBtnDisable(arrBtn[i].trim());
//		}
//	}else{
//		for (var i=0;i<arrBtn.length;i++) {
//			ComBtnDisable(arrBtn[i].trim());
//		}
//	}
}


/**
* role 존재 여부 체크
* @param {String} role 비교대상 role
* @author 진윤오
* @version 2009.05.13
*/
function equalsRoleDwc(role) {
	var roles = form.usr_roles.value;	
	
	if (roles.indexOf(role) == -1 ) {
		return false;
	} else {
		return true;
	}	
}

/**
* 로그인 ID 같은지 비교 
* @param {String} usr_id 비교대상 hdlr_usr_id
* @author 진윤오
* @version 2009.05.13
*/
function equalsHdlrIdDwc(hdlrId) {
	var usrHdlrId = form.usr_id.value;	
	if (usrHdlrId == hdlrId ) {
		return true;
	} else {
		return false;
	}	
}

/**
* 화면 버튼 컨트롤 DWC
* @param {String} hdlr_usr_id 개별화면 변수값
* @param {String} btnStr 버튼name ex)btn1_Save,btn1_Handling_Costs
* @author 양정란
* @version 2010.03.10
*/
function setRollBtnCtlDwc(hdlr_usr_id, btnStr){
	
	var arrBtn = btnStr.split(",");

//	if (equalsRoleDwc("CNI32")||equalsRoleDwc("CNI33")||equalsRoleDwc("CNI93")){
		for (var i=0;i<arrBtn.length;i++) {
			ComBtnEnable(arrBtn[i].trim());
		}
//	}
//	else if (equalsRoleDwc("CNI31")){//his own claim
//		if (equalsHdlrIdDwc(hdlr_usr_id)){
//			for (var i=0;i<arrBtn.length;i++) {
//				ComBtnEnable(arrBtn[i].trim());
//			}
//		}else{
//			for (var i=0;i<arrBtn.length;i++) {
//				ComBtnDisable(arrBtn[i].trim());
//			}			
//		}
//	}
//	else if (equalsRoleDwc("CNI39")){//조회사용자.
//		for (var i=0;i<arrBtn.length;i++) {
//			ComBtnDisable(arrBtn[i].trim());
//		}
//	}else{
//		for (var i=0;i<arrBtn.length;i++) {
//			ComBtnDisable(arrBtn[i].trim());
//		}
//	}

}

/**
* 화면 버튼 컨트롤 INS
* @param {String} hdlr_usr_id 개별화면 변수값
* @param {String} btnStr 버튼name ex)btn1_Save,btn1_Handling_Costs
* @author 양정란
* @version 2010.03.10
*/
function setRollBtnCtlIns(btnStr){
	
	var arrBtn = btnStr.split(",");
	
//	if (equalsRoleDwc("CNI51")||equalsRoleDwc("CNI52")||equalsRoleDwc("CNI93")){//all, create code
		for (var i=0;i<arrBtn.length;i++) {
			ComBtnEnable(arrBtn[i].trim());
		}
//	}
//	else if (equalsRoleDwc("CNI59")){//조회사용자.
//		for (var i=0;i<arrBtn.length;i++) {
//			ComBtnDisable(arrBtn[i].trim());
//		}
//	}else{
//		for (var i=0;i<arrBtn.length;i++) {
//			ComBtnDisable(arrBtn[i].trim());
//		}
//	}
}


/**
* 이벤트 발생시 실행여부 확인 <br>
* @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
* @author 윤세영
* @version 2009.10.13
 **/
function CoCniInitConfirm(sheetObj) {
	var okYn=true;
	if(sheetObj.IsDataModified()) {
		var okYn=confirm(ComGetMsg('CNI09002'));
	}
	return okYn;
}

 
/**
* Row Del 버튼 클릭 시 선택여부 <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {string}  saveName    IBSheet SaveName
* @author 윤세영
* @return {boolean} true:선택, false:미선택
**/
function ComCniCheckBoxCheckYn(sheetObj, saveName) {
	var sRow=sheetObj.FindCheckedRow(saveName);
	if(sRow == "") {
		ComShowCodeMessage('COM12189');
		return false;
	} else {
		ComShowCodeMessage('COM12188');
		return true;
	}
}

/**
* Type Combo 박스를 만든다 <br>
* @param {String} 	flag    	FORM/GRID/MULTI 구분값
* @param {form} 	formObj    	Form Object
* @param {ibsheet} sheetObj    IBSheet Object
* @param {String}  cdId   		코드 Id
* @param {String}  comboCode   코드 값
* @param {String}  comboText   코드 명칭
* @param {String}  nullYn   	콤보에 Null이 들어가야 할 경우 'Y'로 넣어줌
* @author 윤세영
 **/
function CoCniGetCombo(formObj, sheetObj, cdFlag, cdId, comboCode, comboText, nullYn) {
	formObj.f_cmd.value=SEARCHLIST02;
	var param="&cd_id="+cdId+"&com_code="+comboCode
				+"&com_text="+comboText;
 	var sXml=sheetObj.GetSearchData("CPS_CNI_0028GS.do" , FormQueryString(formObj)+param);
	var arrFlag=cdFlag.split(":");
	var arrCode=comboCode.split(":");
	var arrText=comboText.split(":");
	var arrLen=arrCode.length;
	for (var i=0;i<arrFlag.length;i++) {
		if (arrFlag[i] == 'FORM') {//Form
			CoCniSetMakeCondCombo(formObj, ComGetEtcData(sXml, arrText[i]), ComGetEtcData(sXml, arrCode[i]), arrCode[i], '', nullYn);
		} else if (arrFlag[i] == 'MULTI') {//Multi Combo
			CoCniSetMakeMultiCombo(formObj, ComGetEtcData(sXml, arrText[i]), ComGetEtcData(sXml, arrCode[i]), arrCode[i], '');
		} else {//Grid
			CoCniSetMakeCombo(sheetObj, ComGetEtcData(sXml, arrText[i]), ComGetEtcData(sXml, arrCode[i]), arrCode[i], '', nullYn);
		}
	}	
}
  
/**
* Search 조건에 있는 Type Combo 박스를 만든다 <br>
* @param {ibsheet} formObj    	Form Object
* @param {String}  comboCode   Type 의 코드값
* @param {String}  comboText   Type 의 명칭
* @param {String}  col   		column name
* @param {String}  msgCd   	Message 코드값
* @author 윤세영
 **/
function CoCniSetMakeCondCombo(formObj, comboText, comboCode, Col, msgCd, nullYn) {
	if(typeof comboCode != "undefined" && comboCode != "") {
 		var objCombo=eval("document." + formObj.name+"."+Col);
 		var arrcomboCode=comboCode.split("|");
 		var arrcomboText=comboText.split("|");
		if (nullYn == 'Y') {
     		var objOptionItem=document.createElement("option");
			objOptionItem.text='';
			objOptionItem.value='';
			objCombo.add(objOptionItem, objCombo.length);
		}
		var arrlen=arrcomboCode.length - 1;
 		for (var ii=0;ii<arrlen;ii++) {
     		var objOptionItem=document.createElement("option");
			objOptionItem.text=arrcomboText[ii];
			objOptionItem.value=arrcomboCode[ii];
			objCombo.add(objOptionItem, objCombo.length);
		}
	} else {
		if(msgCd != "") {
			ComShowMessage(ComGetMsg(msgCd));
		}
	}
}
/**
* Search 조건에 있는 Multi Combo 박스를 만든다 <br>
* @param {ibsheet} formObj    	Form Object
* @param {String}  comboCode   Type 의 코드값
* @param {String}  comboText   Type 의 명칭
* @param {String}  col   		column name
* @param {String}  msgCd   	Message 코드값
* @author 윤세영
 **/
function CoCniSetMakeMultiCombo(formObj, comboText, comboCode, Col, msgCd) {
	if(typeof comboCode != "undefined" && comboCode != "") {
 		var objCombo=eval("combo_"+Col);
 		var arrcomboCode=comboCode.split("|");
 		var arrcomboText=comboText.split("|");
		var arrlen=arrcomboCode.length-1;
 		objCombo.InsertItem(0, "", "");
 		for (var ii=0;ii<arrlen;ii++) {
			objCombo.InsertItem(-1, arrcomboCode[ii]+"|"+arrcomboText[ii], arrcomboCode[ii]);
		}
		objCombo.SetSelectCode("");
	} else {
		if(msgCd != "") {
			ComShowMessage(ComGetMsg(msgCd));
		}
	}
}
/**
* Type Combo 박스를 만든다 <br>
* @param {ibsheet} sheetObj    IBSheet Object
* @param {String}  comboCode   Type 의 코드값
* @param {String}  comboText   Type 의 명칭
* @param {String}  col   		column name
* @param {String}  msgCd   	Message 코드값
* @author 윤세영
 **/
function CoCniSetMakeCombo(sheetObj, comboText, comboCode, Col, msgCd, nullYn) {
	if(typeof comboCode != "undefined" && comboCode != "") {
		if (nullYn == 'Y') {
			comboText=' |' + comboText;
			comboCode='|' + comboCode;
		}
    	sheetObj.SetColProperty(0, Col, {ComboText:'|'+comboText.substring(0 ,comboText.length-1), ComboCode:'|'+comboCode.substring(0,comboCode.length-1)} );
	} else {
		if(msgCd != "") {
			ComShowMessage(ComGetMsg(msgCd));
		}
	}
}
/**
* 입력된 숫자값을 지정된 소숫점 자리로 round해서 값을 리턴 <br>
* @param {String} 입력된 숫자값
* @param {String} 지정된 소숫점 자리
* @author 양정란
 **/
function roundPrecision(val, precision){
	var p=Math.pow(10, precision);
	return Math.round(val*p)/p;
}
/**
 * 탭이 있는 경우 폼 개체 안에 컨트롤의 필수 입력 여부를 확인한 후 탭에 포커싱 처리를 한다. <br>
 * 필수 입력 여부를 확인하기 위해서는 HTML태그(Object)안에 사용자 정의 속성인 required속성과 caption속성을 설정해주어야 한다. 다음과 같이 설정한다. <br>
 *     &lt;input type="text" name="bmk_cd" <font color="red">required caption="비목코드"</font>&gt; <br>
 * &lt;input type="radio"&gt;의 경우 같은 name으로 여러개를 만든다면 첫번째 태그에만 required속성과 caption속성을 설정해준다. 예를 들어 다음과 같다. <br>
 *     &lt;input type="radio" name="rdoCity" value="01" required caption="도시"&gt;서울<br>
 *     &lt;input type="radio" name="rdoCity" value="02"&gt;대전<br>
 *     &lt;input type="radio" name="rdoCity" value="03"&gt;대구<br>
 * <br><b>Example :</b>
 * <pre>
 *     if(!ChkRequiredWithTab(document.frmMaster)) return;   //frmMaster폼안에 모든 오브젝트의 필수입력여부를 확인한다.
 * </pre>
 * @param {form} frm     필수,대상 Form 오브젝트
 * @returns bool
 *          false - 필수입력 항목에 값이 없는 경우
 *          true  - 모두 입력된 경우
 * @see #ComChkValid
 */
function ChkRequiredWithTab(frm) {
    try {
        var elems=frm.elements;
        for(var i=0; i < elems.length; i++) {
            var elem=elems[i];
            if(elem.getAttribute("required") == null || elem.getAttribute("disabled")) continue;
            //radio인 경우 같은이름으로 여러개 있는 경우
            if (elem.type =="radio") {
                if (elem.name == null || elem.name=="") continue;
                var eRadio=document.all[elem.name];
                //첫번째 radio만 "required"속성이 있는지 체크한다.
                if(eRadio.length>1) i += (eRadio.length-1);
                sVal=ComGetObjValue(eRadio);
            } else {
                sVal=ComGetObjValue(elem)
            }
            if (ComTrim(sVal)=="") {
                var nTabPos=elem.getAttribute("tabidx");
                if (nTabPos != null) { 
                    if (ComParseInt(nTabPos) < 3){
                	   tabObjects[0].SetSelectedIndex(ComParseInt(nTabPos));
                    } else {
                    	tabObjects[1].SetSelectedIndex((ComParseInt(nTabPos) - 3));
                    }
                }   
                var sTitle=(elem.getAttribute("caption")==null)?elem.name:elem.getAttribute("caption");
                ComShowMessage("'" + sTitle + "' " + Msg_Required);
                //컨트롤이 숨겨져 있을수도 있으므로 에러 감싼다.
                try{ 
                	elem.focus();
                } catch(ee) {;}
                return false;
            }
        } // end of for(i)
        return true;
    } catch(err) { ComFuncErrMsg(err.message); }
}
 /**
  * Booking B/L Preview 팝업 호출<br>
  * <br><b>Example :</b>
  * <pre>
  *     comBkgCallPop0927(bkgNo, blNo);
  * </pre>
  * @param  bkg_no
  * @param  blNo
  * @return 없음
  * @author 박제성
  * @version 2010.01.19
  */
function comBkgCallPop0927(bkgNo, blNo){
	    var blTpCd="W";    	    
	    if (blNo.substring(blNo.length-1, blNo.length) != "W") {
	    	blTpCd="D";
	    }
		var param="bkg_no="   +bkgNo+
                   "&bl_no="   +blNo+
                   "&bl_tp_cd="+blTpCd; 			
		ComOpenWindow("/opuscntr/ESM_BKG_0927.do?" + param, "PopupEsmBkg0927", "width=916, height=730, scrollbars=no", false);
}

function CNIcheckInvoiceNo(sheetObj,inv_no,vndr_seq,ref_pk){
	var sParam = "f_cmd="+SEARCH09;

	sParam = sParam + "&mdl_cd="+"CNI";

	sParam = sParam + "&inv_no="+inv_no;

	sParam = sParam + "&vndr_seq="+vndr_seq;
	sParam = sParam + "&ref_pk="+lpad(ref_pk,10,"0"); 
	
	sheetObj.SetWaitImageVisible(0);
	var sXml = sheetObj.GetSearchData("FINCommonGS.do" , sParam);
	sheetObj.SetWaitImageVisible(1);

	var message = ComGetSelectSingleNode(sXml , "MESSAGE");
	var arrResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	if (arrResult == "F") {
		showErrorMsg(sXml);
		if(message.indexOf("CSR10005") > -1){
			return "DUP"; //INV_NO
		}else{
			return null;
		}
	} else {
		return null;
	}
}

function lpad(str, num, chr) {    
    if (! str || ! chr || str.length >= num) {
        return str;
    }
 
    var max = num - str.length;
    for (var i = 0; i < max; i++) {
        str = chr + str;
    }
 
    return str;
}

function CNIXmlToArray(xmlStr) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return;
	}
	try {
        var xmlDoc = ComGetXmlDoc(xmlStr);
        if (xmlDoc == null) return;
        var xmlRoot = xmlDoc.documentElement;
        if (xmlRoot == null)  return;

		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var retStr="";
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			rtnArr.push(arrData);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
}

function popupClientDefault() {	
	var url = "CPS_CNI_0001_POP.do?popupYn=Y";
	var winName = "CPS_CNI_0001";
	var reqWin = openWinCenter(url,winName,400,150);
	reqWin.focus();
	return reqWin;
}

function resetHiddenField(frm) {
	var vObjects=frm.elements;
	for ( var kdx=0; kdx < vObjects.length; kdx++) {
		var vObj=vObjects[kdx];
		var vObjtp=vObj.type;
		var vObjnm=vObj.name;
			
		if (vObjnm == undefined || vObjnm == ""){
			continue;
		}	
		
		if(vObjtp == "hidden"){
			if(!vObj.readOnly){
				ComSetObjValue(vObj, "");
			}
		}
	} //end for
}
