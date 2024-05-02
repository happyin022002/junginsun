/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0003.js
 *@FileTitle : [CPS_CNI_0003] Claim Main
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.12
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2009.10.12 정행룡
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0003] Claim Main
 * 
 * @extends
 * @class Claim Main 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function cps_cni_0003() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject     = setSheetObject;
	this.setComboObject     = setComboObject;
	this.setTabObject       = setTabObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.initCombo         	= initCombo;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab1 = 1;
var beforetab2 = 1;

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

// IBmultiCombo
var comboObjects = new Array();
var comboCnt = 0;

// HTML Form
var frm = null;
var frm2 = null;

// Claim Area Code
var clmAreaCd = "";

var MainCode = ""; //전역변수 popupMainCodeInquiry함수 호출 후 리턴값을 받을 곳을 알기 위해서 선언함

var openTabIndex = 0; //탭 클릭시 더블클릭 효과를 발생하기 위해서 쓰는 변수


/*
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 
 * 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	frm = document.form;
	frm2 = document.form2;
	
	//IBTab 초기화
	tabCnt = tabObjects.length;
	for (var k = 0; k < tabCnt; k++) {
		initTab(tabObjects[k], k + 1);
	}
	
	//IBMultiCombo초기화
	comboCnt = comboObjects.length;
	
	for (var j=0; j<comboCnt; j++) {
		initCombo(comboObjects[j],j+1);
	}
	
	//IBSheet 초기화
	sheet1 = sheetObjects[0];
	sheetCnt = sheetObjects.length;
	
	sheet1.WaitImageVisible = false;	
	for ( var i = 0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//B/L No. 포커싱
	ComSetFocus(frm.cgo_clm_ref_bl_no);
	//Form 이벤트 등록
	initControl();
    
	//MultiComboBox 값 초기화
	initComboBoxValue();
    
	
	setRoleButton();
	ComBtnDisable("btn1_Cancel");
	
	//Cargo Claim NO가 다른 화면에서  넘어오면(존재하면) 해당 상세정보 조회
	var claim_no = ComGetObjValue(frm.cgo_clm_no);
	
	if (claim_no != "") {
		doActionIBSheet(SEARCH);
	}
	
	
}

 /**
  * Tab 기본 설정
  * 탭의 항목을 설정한다.
  **/
function initTab(tabObj, tabNo) {
	  switch (tabNo) {
	 	case 1:
	 		with (tabObj) {
	 			var cnt = 0;
	 			InsertTab(cnt++, "Page1", -1);
	 			InsertTab(cnt++, "Page2", -1);
	 			InsertTab(cnt++, "Litigation", -1);
	 		}
	 		break;
	
	 	case 2:
	 		with (tabObj) {
	 			var cnt = 0;
	 			InsertTab(cnt++, "Cause of Claim", -1);
	 			InsertTab(cnt++, "Fact Finding", -1);
	 			InsertTab(cnt++, "Main Issue Review & DV", -1);
	 			InsertTab(cnt++, "Claimant's Agent", -1);
	 			InsertTab(cnt++, "Insurer's Agent", -1);
	 			InsertTab(cnt++, "Case Summary & DV", -1);
	 		}
	 		break;
 	   }
}

/*
 * IBSheet Object를 배열로 등록
 * @param sheetObj IBSheet Object  
 */
function setSheetObject(sheetObj){
	sheetObjects[sheetCnt++] = sheetObj;
}

/*
 * IBTab Object를 배열로 등록
 * @param tabObj
 */
function setTabObject(tabObj) {
 	tabObjects[tabCnt++] = tabObj;
}
   
/*
 * IBCombo Object를 배열에 등록
 * @param comboObj
 */
function setComboObject(comboObj){
	comboObjects[comboCnt++] = comboObj;
}

/*
 * Tab 클릭시 이벤트 관련  선택한 탭의 요소가 활성화 된다.
 * @param IBTabs tabObj
 * @param int nItem
 */

function tab1_OnClick(tabObj, nItem) {
 	if (nItem == 0) {
 		tabObjects[1].SelectedIndex = 0;
 	}
 	if (nItem == 2) {
 		tabObjects[1].SelectedIndex = 5;
 	}
}
/*
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 * @param IBTabs tabObj
 * @param int nItem 
 */

function tab2_OnClick(tabObj, nItem) {
 	if (nItem == 0) {
 		tabObjects[0].SelectedIndex = 0;
 	}
 	if (nItem == 5) {
 		tabObjects[0].SelectedIndex = 2;
 	}
 	// 탭 더블클릭 효과(상세보기창을 띄우기 위해)
 	if (openTabIndex == nItem) {
		var pop_param = '';
		if (nItem == 0) {
			pop_param = "pop_title=Cause of Claim&pop_desc=&pop_cont_col=clm_cuz_desc";
		} else if (nItem == 1) {
			pop_param = "pop_title=Fact Finding _ Assessment&pop_desc=&pop_cont_col=fact_fnd_desc";
		} else if (nItem == 2) {
			pop_param = "pop_title=Main Issue Review_DV&pop_desc=&pop_cont_col=clm_rvw_desc";
		} else if (nItem == 5) {
			pop_param = "pop_title=Case Summary _ DV&pop_desc=&pop_cont_col=ltgt_cs_desc";
		}
		if (nItem == 0 || nItem == 1 || nItem == 2 || nItem == 5) {
			ComPostOpenWindow("/hanjin/CPS_CNI_0040.do?pop_flag=TAB&" + pop_param, 'CPS_CNI_0040', 'width=1000,height=587');
		}	
	} else {
		openTabIndex = nItem;
	}
}

/*
 * Tab 변경시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 * @param IBTabs tabObj
 * @param int nItem 
 */
function tab1_OnChange(tabObj, nItem) {

 	var objs = document.all.item("tabLayer1");

 	objs[nItem].style.display = "Inline";
 	objs[beforetab1].style.display = "none";

 	objs[beforetab1].style.zIndex = objs[nItem].style.zIndex - 1;
 	beforetab1 = nItem;
 	
}

 /*
  * Tab 클릭시 이벤트 관련
  * 선택한 탭의 요소가 활성화 된다.
  * @param IBTabs tabObj
  * @param int nItem 
  */
function tab2_OnChange(tabObj, nItem) {

 	var objs = document.all.item("tabLayer2");

 	objs[nItem].style.display = "Inline";
 	objs[beforetab2].style.display = "none";

 	objs[beforetab2].style.zIndex = objs[nItem].style.zIndex - 1;
 	beforetab2 = nItem;
}

  
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
document.onclick = processButtonClick;

// 버튼 명으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
function processButtonClick() {
	
	// Cargo Claim No.
	var claim_no = ComGetObjValue(frm.cgo_clm_no);
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
	
		case "btn1_Retrieve": //조회
			if (claim_no == "") {
				ComShowCodeMessage("CNI00003", "Claim No.");
				ComSetFocus(frm.cgo_clm_no);
				return ;	
			}
			doActionIBSheet(SEARCH);
			break;

		case "btn1_New":
			if (ComShowCodeConfirm("CNI00015") ) { // "CNI00015=Do you want to initialize?"
				ComResetAll();
				ComSetObjValue(frm.cgo_clm_no, "");
				tabObjects[0].SelectedIndex = 0;
				tabObjects[1].SelectedIndex = 0;
				ComSetObjValue(frm.clm_area_cd, clmAreaCd);
				ComSetFocus(frm.cgo_clm_ref_bl_no);
				ComBtnEnable("btn1_Save");
				setRoleButton();//위치(순서)를 옮기면 안됨(Disable 처리 전에 사용 )
				ComBtnDisable("btn1_Cancel")
				frm.fmal_clm_rcv_ofc_cd.readOnly = true;
				frm.fmal_clm_rcv_ofc_cd.className = "input2";
				frm.fmal_clm_rcv_ofc_cd.removeAttribute("required");
				frm.fmal_clm_rcv_dt.readOnly = true;
				frm.fmal_clm_rcv_dt.className = "input2";
				frm.fmal_clm_rcv_dt.removeAttribute("required");
				frm.inci_plc_tp_cd.Enable = true;
				frm.inci_occr_dt.readOnly = false;
				frm.inci_occr_dt.className = "input";	
				
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
			self.close();
			break;
		case "btns_hanlder_history":
			popupHandlerHistory(claim_no);
			break;
			
		case "btns_vvd":
			var trnk_ref_vvd_no = ComGetObjValue(frm.trnk_ref_vvd_no);
			popupVvdSkd(trnk_ref_vvd_no);
			break;
		//-----------------[달력 버튼 Start]------------------//		
		// 공통처리함
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
			var result = srcName.replace("btns_", "");
		    var vCalObj = eval("frm." + result );
			var vCal = new ComCalendar();
			vCal.setDisplayType('date');
			vCal.select(vCalObj, 'yyyy-MM-dd');
            break;
        //-----------------[달력 버튼 End]------------------//    
		
		//-----------------[Style 버튼 Start]--------------//	
		case "btn1_Style":
			var clmt_clm_pty_no = ComGetObjValue(frm.clmt_clm_pty_no);
			if (clmt_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Claimant");
				frm.clmt_clm_pty_abbr_nm.focus();
				return ;	
			}
			popupMainCodeView(clmt_clm_pty_no);
			break;
		
		case "btn3_Style":
			var deft_atty_clm_pty_no = ComGetObjValue(frm.deft_atty_clm_pty_no);
			if (deft_atty_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Def. Attorney");
				frm.deft_atty_clm_pty_abbr_nm.focus();
				return ;	
			}
			popupMainCodeView(deft_atty_clm_pty_no);
			break;
			
		case "btn4_Style":
			var clm_agn_clm_pty_no = ComGetObjValue(frm.clm_agn_clm_pty_no);
			if (clm_agn_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Claimant's Agent");
				frm.clm_agn_clm_pty_abbr_nm.focus();
				return ;	
			}
			popupMainCodeView(clm_agn_clm_pty_no);
			break;
			
		case "btn5_Style":
			var insur_agn_clm_pty_no = ComGetObjValue(frm.insur_agn_clm_pty_no);
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
			   popupOfficeCode(); //CoCni.js 함수
			}
			break;
			
		case "btn1_Claimant":
		case "clmt_clm_pty_abbr_nm":	
			MainCode ="claimant"; 
			popupMainCodeInquiry(); //CoCni.js 함수
			break;
		
		case "btn1_Insurer":
		case "insur_clm_pty_abbr_nm":	
			MainCode ="insurer";
			popupMainCodeInquiry(); //CoCni.js 함수
			break;
			
		case "btn4_Claimant_Agent":
		case "clm_agn_clm_pty_abbr_nm":	
			MainCode ="claimant_agent";
			popupMainCodeInquiry(); //CoCni.js 함수
			break;
			
		case "btn5_Insurer_Agent":
		case "insur_agn_clm_pty_abbr_nm":	
			MainCode ="insurer_agent";
			popupMainCodeInquiry(); //CoCni.js 함수
			break;

		case "btns_Attorney":
		case "deft_atty_clm_pty_abbr_nm":	
			MainCode ="attorney";
			popupMainCodeInquiry(); //CoCni.js 함수
			break;
		case "btn1_Cargo":
			popupMainMiscView("15");
			break;	
	    //-----------------[ Miscellaneous Code Popup End ]-------------------------//	
		case "btns_BL_Get":
			doActionIBSheet(SEARCH20);
			break;
		case "btns_BL_Preview":
			var blNo  = frm.cgo_clm_ref_bl_no.value;
			
			if (blNo == "") {
				ComShowMessage("Please use after retrieve ");		
				return false;
			}
			doActionIBSheet(SEARCH18);
			var bkgNo = frm.bkg_no.value;
			
			if (bkgNo == "") {
				ComShowCodeMessage("CNI00013");
				return false;
			}
			rdOpen(bkgNo);			
        	break;	
		case "btn3_FileUpload":
			 var cgo_clm_no = frm.cgo_clm_no.value;
			 if (cgo_clm_no.length == 10){
			     popupFileUpload("000301" ,cgo_clm_no );
			 }else{
				ComShowCodeMessage("CNI00003", "Claim No");
				frm.cgo_clm_no.focus();
			 }
			 break;
			 
		case "btns_currency":
			//공통팝업 Currency 호출
			var display = "1,0,1,1,1";
			ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 500, 435, "setCurrency", display);
			break;
			
		case "btns_roe":
			var clmtLoclCurrCd = frm.clmt_locl_curr_cd.value;
			if (ComIsNull(clmtLoclCurrCd)) {
				ComShowCodeMessage("CNI00009" , "Currency Code");
				ComSetFocus(frm.clmt_locl_curr_cd);
				return;
			}
       		var yrMon = frm.fmal_clm_rcv_dt.value;
       		if (yrMon ==  "") {
       			yrMon = ComGetNowInfo(); //현재일자로 값을 넘겨줌.
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
	       ComShowMessage(e);
		}
	}
}

/**
 * Form 이벤트 등록
 **/
function initControl() {

	// keypress
	axon_event.addListenerForm('keypress', 'obj_keypress', frm);
	// focus in
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	// focus out
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	// key up
	axon_event.addListenerForm('keyup', 'obj_keyup', frm);
	
	axon_event.addListener('change', 'jmt_rslt_cd_onchange', 'jmt_rslt_cd', '')	// Template
}

 /**
  * 초기 콤보 설정
  **/
function initComboBoxValue() {

	var arrXml = ComGetObjValue(frm2.sXml).split("|$$|");
 	
 	if (arrXml.length > 0 ) {
	 	var idx = 0;
	 	setMultiComboBox("clmt_clm_tp_cd",      arrXml[idx++] ); //'03'
	 	setMultiComboBox("clmt_agn_tp_cd",      arrXml[idx++] ); //'04'
	 	setMultiComboBox("crr_term_cd",         arrXml[idx++] ); //'06'
	 	setMultiComboBox("jmt_rslt_cd",         arrXml[idx++] ); //'22'
	 	setMultiComboBox("agn_crspn_tp_cd",     arrXml[idx++] ); //'23'
	 	setMultiComboBox("cgo_clm_tp_cd",       arrXml[idx++] ); //'11' TOC
	 	setMultiComboBox("mjr_clm_dmg_lss_cd",  arrXml[idx++] ); //'02' CODL1
	 	setMultiComboBox("n3rd_labl_pty_cd", 	arrXml[idx++] ); //'39' 3rd Liable Party
	 	setMultiComboBox("inci_plc_tp_cd",      arrXml[idx++] ); //'14' POI
	    
	 	//Area Cd Setting
	 	var dataCount = ComGetTotalRows(arrXml[idx]);
	 	if (dataCount > 0) {
	 		var list = SheetXml2ListMap(arrXml[idx]);	
	 		var listVO = list[0];
	 		clmAreaCd = listVO["clm_area_cd"];
	 		ComSetObjValue(frm.clm_area_cd,clmAreaCd );
		} else { 
			var popwin = popupClientDefaultSetup(); //Area Code가 없으면 셋업화면 띄워줌
			popwin.focus();
		}
 	} 	
}
 
// focus in
function obj_activate(){
	obj = event.srcElement;
	
	//readonly 일때 데이터 포맷 변경되는 것  방지
	if (obj.getAttribute("readOnly")) return;
	
	ComClearSeparator(obj);
} 

// focus out
function obj_deactivate(){
	obj = event.srcElement;
	
	ComChkObjValid(obj);
	
	if (obj.name == "cgo_clm_inci_no" && ComIsNull(obj.value)) {
		frm.inci_plc_tp_cd.Enable = true;
		frm.inci_occr_dt.readOnly = false;
		frm.inci_occr_dt.className = "input";		
	}

	if (ComIsNull(obj.value)) {
		return;
	}
	
	switch (obj.name) {
		case "clmt_locl_amt":
			var clmt_locl_amt = cniParseFloat(frm.clmt_locl_amt); 
			var cgo_clm_sts_cd = ComGetObjValue(frm.cgo_clm_sts_cd);
			if (clmt_locl_amt > 0 && ((cgo_clm_sts_cd == "" || cgo_clm_sts_cd == "N"))) {
				frm.fmal_clm_rcv_ofc_cd.readOnly = false;
				frm.fmal_clm_rcv_ofc_cd.className = "input1";
				frm.fmal_clm_rcv_ofc_cd.setAttribute("required","required");
				frm.fmal_clm_rcv_dt.readOnly = false;
				frm.fmal_clm_rcv_dt.className = "input1";
				frm.fmal_clm_rcv_dt.setAttribute("required","required");
				document.getElementById("div_btn2").style.display = "block"; 
			} else {
				frm.fmal_clm_rcv_ofc_cd.readOnly = true;
				frm.fmal_clm_rcv_ofc_cd.className = "input2";
				frm.fmal_clm_rcv_ofc_cd.removeAttribute("required");
				frm.fmal_clm_rcv_dt.readOnly = true;
				frm.fmal_clm_rcv_dt.className = "input2";
				frm.fmal_clm_rcv_dt.removeAttribute("required");
				document.getElementById("div_btn2").style.display = "none"; 
				if (cgo_clm_sts_cd == "" || cgo_clm_sts_cd == "N") {
					frm.fmal_clm_rcv_ofc_cd.value = "";
					frm.fmal_clm_rcv_dt.value = "";
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
			 var clm_tm_bar_dt = ComGetDateAdd(ComGetObjValue(frm.de_dt), "Y", 1) ; // 1년 더해서 처리함
			 ComSetObjValue(frm.clm_tm_bar_dt,clm_tm_bar_dt) 
			break;
	
	}
}

/**
 * HTML Control KeyPress 이벤트 호출
 **/
function obj_keypress() {
    
	obj = event.srcElement;
    if(obj.dataformat == null) return;
    
    window.defaultStatus = obj.dataformat;

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
 * HTML Control KeyUp 이벤트 호출
 **/
function obj_keyup() {
	 
	if ((event.keyCode >= 37 && event.keyCode <= 40)|| (event.keyCode == 16)) return;
	switch (event.srcElement.name) {
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
	        	ComSetObjValue(event.srcElement,"")
				ComSetFocus(frm.smns_sve_dt);
	        }
	        break;    
   }//end of switch
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 **/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
 	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
		with (sheetObj) {
			if (location.hostname != "") {
				InitHostInfo(location.hostname, location.port, page_path);
			}
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=500]
			InitRowInfo(1, 1, 15, CNI_PAGE_SIZE);

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
            
		}//end of with
		break;
	}// end of switch
 }
  
/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 **/
function initCombo(comboObj, comboNo) {

	with (comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.SetColAlign("left|left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 175;
		var comboName = comboObj.name;
		if (comboName == "clmt_agn_tp_cd" || comboName=="agn_crspn_tp_cd" || comboName == "jmt_rslt_cd"){
		    comboObj.BackColor = "#FFFFFF"; //필수 입력이 아닌 콤보
		} else {
			comboObj.BackColor = "#CCFFFD";//필수 입력 색깔
		}
	}
	  
} 
 /**
  * Sheet관련 프로세스 처리
  **/
 function doActionIBSheet(sAction) {
     
	frm.f_cmd.value = sAction;

	switch (sAction) {

 	case SEARCH: // Retrieve Claim Main
 	
 		if (validateForm(sAction)) {
			var sXml = sheet1.GetSearchXml("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
			//에러 체크
			if (getErrorMsg(sheet1,sXml)) {
				return;
			}
			var dataCount = ComGetTotalRows(sXml);// 데이터 건수
			if (dataCount > 0) {
				  ComBtnEnable("btn1_Save");
				  ComBtnEnable("btn1_Cancel");
				  sheetXml2ObjectValue(sXml);

				  //자동처리 외 예외적인 값 처리 부분--------------------------
				  ComSetObjValue(frm.lodg_dt1,ComGetObjValue(frm.lodg_dt));
				  ComSetObjValue(frm.del_cd1,ComGetObjValue(frm.del_cd));
				  ComSetObjValue(frm.de_dt1,ComGetObjValue(frm.de_dt)); //다른 탭에 있는 DDL값 처리 (동일한 값)
				  if (ComGetObjValue(frm.cgo_clm_inci_no) == ""){
					  frm.inci_plc_tp_cd.Enable = true;
					  frm.inci_occr_dt.readOnly = false;
					  frm.inci_occr_dt.className = "input";
			      }else{
					  frm.inci_plc_tp_cd.Enable = false;
					  frm.inci_occr_dt.readOnly = true;
					  frm.inci_occr_dt.className = "input2";
			      }	  
				  //-------------------------------------------------------
				  
				  setRoleButton();//권한체크
				  
				  //상태코드별 버튼사용여부 체크
				  var cgo_clm_sts_cd = ComGetObjValue(frm.cgo_clm_sts_cd);
			 		  
				  if (cgo_clm_sts_cd == "C" || cgo_clm_sts_cd == "X") { // 상태 코드가 X, C 일경우 버튼 비활성화
					  setRoleButton();
					  ComBtnDisable("btn1_Save");
				  	  ComBtnDisable("btn1_Cancel");
				  }
				  // Cancel 버튼 비활성
				  if (cgo_clm_sts_cd == "P" || cgo_clm_sts_cd == "R" ||
					  cgo_clm_sts_cd == "L" || cgo_clm_sts_cd == "A" ||
					  cgo_clm_sts_cd == "V") { 
					  setRoleButton();
					  ComBtnDisable("btn1_Cancel");
			 	  }
			} else { //데이터가 없을시 화면 reset 처리
				ComShowCodeMessage('CNI00013');
				ComResetAll();
				ComSetObjValue(frm.cgo_clm_no, "");
				tabObjects[0].SelectedIndex = 0;
				tabObjects[1].SelectedIndex = 0;
				ComSetFocus(frm.cgo_clm_no);
				ComBtnEnable("btn1_Save");
				setRoleButton();
				ComBtnDisable("btn1_Cancel");
			}// end if 
			
			frm.fmal_clm_rcv_ofc_cd.readOnly = true;
			frm.fmal_clm_rcv_ofc_cd.className = "input2";
			frm.fmal_clm_rcv_dt.readOnly = true;
			frm.fmal_clm_rcv_dt.className = "input2";
			frm.fmal_clm_rcv_dt.removeAttribute("required");
			document.getElementById("div_btn2").style.display = "none"; 
			
		}
		break;
 	
 	case SEARCH11: // Misc Code Validation
	 	var clss_clm_misc_cd = ComGetObjValue(frm.clss_clm_misc_cd);
	 	var clm_misc_cd = ComGetObjValue(frm.clm_misc_cd);
		var sXml = sheet1.GetSearchXml("CPS_CNI_0003GS.do",	"f_cmd="+sAction+"&clss_clm_misc_cd="+clss_clm_misc_cd + "&clm_misc_cd="+clm_misc_cd);
		if (getErrorMsg(sheet1,sXml)) {
			return "N";
		}
		var isExist = ComGetEtcData(sXml,"EXIST");
 	    return isExist;
		break;	
 	
 	case SEARCH12: // Retrieve Office Cd
	 	var fmal_clm_rcv_ofc_cd = ComGetObjValue(frm.fmal_clm_rcv_ofc_cd);
		var sXml = sheet1.GetSearchXml("CPS_CNI_0003GS.do",	"f_cmd="+sAction+"&fmal_clm_rcv_ofc_cd="+fmal_clm_rcv_ofc_cd);
		if (getErrorMsg(sheet1,sXml)) {
			return "N";
		}
		var isExist = ComGetEtcData(sXml,"EXIST");
		return isExist;
		break;	
	
 	case SEARCH15: // Retrieve Incident Info
	 	var cgo_clm_inci_no = ComGetObjValue(frm.cgo_clm_inci_no);
	 	if (cgo_clm_inci_no != ""){
		 	var sXml = sheet1.GetSearchXml("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
		 	if (getErrorMsg(sheet1,sXml)) {
				return;
			}
		 	var list = SheetXml2ListMap(sXml);	
			var dataCount = ComGetTotalRows(sXml);
	 		if (dataCount == 0) {
	 			ComShowCodeMessage("CNI00013");
	 			//ComSetObjValue(frm.cgo_clm_inci_no, "");
	 		}else{
	 			var listVO = list[0];
				ComSetObjValue(frm.inci_plc_tp_cd, listVO["inci_plc_tp_cd"]);
				ComSetObjValue(frm.inci_occr_dt,   listVO["inci_occr_dt"]);
				setFormatData(frm.inci_occr_dt, listVO["inci_occr_dt"], "ymd" );
				frm.inci_plc_tp_cd.Enable = false;
				frm.inci_occr_dt.readOnly = true;
				frm.inci_occr_dt.className = "input2";
	 		}
	 	}	
		break;	
 	case SEARCH18: // Retrieve BookingNo
 	    
	 	var sXml = sheet1.GetSearchXml("CPS_CNI_0003GS.do", FormQueryString(frm),"",true);		
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
	 	}
	
 	    break;
 	case SEARCH20: // Retrieve B/L 
 	    if (!validateForm(sAction)) return; 
 	    frm.f_cmd.value = SEARCH19;
 	    var sXml = sheet1.GetSearchXml("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
 	    if (getErrorMsg(sheet1,sXml)) {
		   return;
	    }
	    var cgo_clm_ref_bl_no = ComGetEtcData(sXml,"CGO_CLM_REF_BL_NO");
	    if (cgo_clm_ref_bl_no != ""){
	        ComShowCodeMessage("CNI00035"); //"Same B/L Found! Please check Duplication." 
	    }
	    frm.f_cmd.value = SEARCH20;
 		var sXml = sheet1.GetSearchXml("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
 		if (getErrorMsg(sheet1,sXml)) {
			return;
		}
	 	var list = SheetXml2ListMap(sXml);	
		if (list.length > 0) {
			var listVO = list[0];
			ComSetObjValue(frm.slan_cd,         listVO["slan_cd"]);
			ComSetObjValue(frm.lodg_dt,         ComGetMaskedValue(listVO["lodg_dt"], "ymd"));
			ComSetObjValue(frm.lodg_dt1,        ComGetMaskedValue(listVO["lodg_dt"], "ymd"));
			ComSetObjValue(frm.vsl_eng_nm,      listVO["vsl_eng_nm"]);
			ComSetObjValue(frm.trnk_ref_vvd_no, listVO["trnk_ref_vvd_no"]);
			ComSetObjValue(frm.crr_term_cd,     listVO["crr_term_cd"]);
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
			ComSetObjValue(frm.crr_term_cd,     "");
			ComSetObjValue(frm.del_cd,          "");
			ComSetObjValue(frm.del_cd1,         "");
			ComSetObjValue(frm.clm_cgo_tp_cd,   "");
			ComSetObjValue(frm.cgo_qlty_desc,   "");
		 	frm.cgo_clm_ref_bl_no.focus();
		}
		break;
		
 	case MULTI: //Save
 		
 	    if (!validateForm(sAction)) return; 
	 	if (!validateMiscCd(frm.cgo_clm_tp_cd, "11")) return; 
	 	if (!validateMiscCd(frm.mjr_clm_dmg_lss_cd,"02")) return; 
	 	if (!validateMiscCd(frm.n3rd_labl_pty_cd,"39")) return; 
	 	if (!validateMiscCd(frm.inci_plc_tp_cd,"14")) return; 
	 	if (!validateOfficeCd(frm.fmal_clm_rcv_ofc_cd)) return;
        
	 	//저장여부 확인
	 	if(!ComShowCodeConfirm('CNI00012')) return;
 	    
		
 	    //공통함수로 처리할것 다시 호출로직
 	    var cgo_clm_no = frm.cgo_clm_no.value.trim();
 		if (cgo_clm_no !=""){
 			frm.f_cmd.value = SEARCH;
 			var sXml = sheet1.GetSearchXml("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
			// 데이터 건수
		 	var dataCount = ComGetTotalRows(sXml);
		 	if (dataCount == 0) {
		 		ComShowCodeMessage("CNI00013");
		 		return;
		 	}
 		} else {
 			var cgo_clm_sts_cd = frm.cgo_clm_sts_cd.value.trim();
 			if (cgo_clm_sts_cd !=""){
 				ComShowCodeMessage("CNI00013");
		 		return;
 			}
 		}
 			
 		// cmd 재설정 
 		frm.f_cmd.value = MULTI;
 		
 		clearAllObjectMask(); //Form Object UnMask
 		
 		var param = FormQueryString(frm);
 		var saveString = sheet1.GetSaveString(); 
		param += "&" + saveString;	
 		var sXml = sheet1.GetSaveXml("CPS_CNI_0003GS.do", param);
 		if (getErrorMsg(sheet1,sXml)) {
			return;
		}
 	   	sheet1.LoadSaveXml(sXml);
 		var cgo_clm_no = ComGetEtcData(sXml,"CGO_CLM_NO");
 		frm.cgo_clm_no.value = cgo_clm_no;
 		doActionIBSheet(SEARCH); //재조회
 		
 		break;
 		
	 case MULTI01: //Cancel
		if (!validateForm(sAction)) return; 
		if(!ComShowCodeConfirm('CNI00021')) return;
		
		var cgo_clm_no = frm.cgo_clm_no.value.trim();
		if (cgo_clm_no !=""){
			frm.f_cmd.value = SEARCH;
			var sXml = sheet1.GetSearchXml("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
			// 데이터 건수
		 	var dataCount = ComGetTotalRows(sXml);
		 	if (dataCount == 0) {
		 		ComShowCodeMessage("CNI00013");
		 		return;
		 	}
		}
			
		frm.f_cmd.value = MULTI01;
		
		clearAllObjectMask(); //Form Object UnMask
			
		var param = FormQueryString(frm);
		var saveString = sheet1.GetSaveString(); 
		param += "&" + saveString;	
		var sXml = sheet1.GetSaveXml("CPS_CNI_0003GS.do", param);
		if (getErrorMsg(sheet1,sXml)) {
			return;
		}
		sheet1.LoadSaveXml(sXml);
		var cgo_clm_no = ComGetEtcData(sXml,"CGO_CLM_NO");
		frm.cgo_clm_no.value = cgo_clm_no;
		doActionIBSheet(SEARCH); //재조회
		break;
	}
 }
 	

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 **/
function validateForm(sAction) {
	var cgo_clm_no = frm.cgo_clm_no.value;
	
	if (sAction == SEARCH20) {
		
		var cgo_clm_ref_bl_no = frm.cgo_clm_ref_bl_no.value;
		
		if (cgo_clm_ref_bl_no == "") {
			ComShowCodeMessage("CNI00003", "B/L No.");
			frm.cgo_clm_ref_bl_no.focus();
			return false;
		}
	} else if (sAction == MULTI || sAction == MULTI01) {
		if( !ChkRequiredWithTab(frm) ){
             return false;
        }
		var crr_term_cd = ComGetObjValue(frm.crr_term_cd);
		if (typeof(crr_term_cd) == "undefined" || crr_term_cd == "") {
			ComShowCodeMessage("CNI00003", "Term");
			tabObjects[0].SelectedIndex = 0;
			frm.crr_term_cd.focus();
			return false;
		}
		
		var clmt_clm_tp_cd = ComGetObjValue(frm.clmt_clm_tp_cd);
		if (typeof(clmt_clm_tp_cd) == "undefined" || clmt_clm_tp_cd == "") {
			ComShowCodeMessage("CNI00003", "Type");
			tabObjects[0].SelectedIndex = 0;
			frm.clmt_clm_tp_cd.focus();
			return false;
		}
		
		var cgo_clm_tp_cd = ComGetObjValue(frm.cgo_clm_tp_cd);
		if (typeof(cgo_clm_tp_cd) == "undefined" || cgo_clm_tp_cd == "") {
			ComShowCodeMessage("CNI00003", "TOC");
			tabObjects[0].SelectedIndex = 0;
			frm.cgo_clm_tp_cd.focus();
			return false;
		}
		
		var mjr_clm_dmg_lss_cd = ComGetObjValue(frm.mjr_clm_dmg_lss_cd);
		if (typeof(mjr_clm_dmg_lss_cd) == "undefined" || mjr_clm_dmg_lss_cd == "") {
			ComShowCodeMessage("CNI00003", "CODL");
			tabObjects[0].SelectedIndex = 0;
			frm.mjr_clm_dmg_lss_cd.focus();
			return false;
		}
		
		if (typeof(cgo_clm_no) == "undefined" || cgo_clm_no == "") {
			if (mjr_clm_dmg_lss_cd == "BC" || mjr_clm_dmg_lss_cd == "BP" || mjr_clm_dmg_lss_cd == "CN" || 
					mjr_clm_dmg_lss_cd == "HE" || mjr_clm_dmg_lss_cd == "HL" || mjr_clm_dmg_lss_cd == "HO" || 
					mjr_clm_dmg_lss_cd == "IP" || mjr_clm_dmg_lss_cd == "IS" || mjr_clm_dmg_lss_cd == "PC" || 
					mjr_clm_dmg_lss_cd == "PE" || mjr_clm_dmg_lss_cd == "RN" || mjr_clm_dmg_lss_cd == "RR" || 
					mjr_clm_dmg_lss_cd == "SC" || mjr_clm_dmg_lss_cd == "SN" || mjr_clm_dmg_lss_cd == "TM" || 
					mjr_clm_dmg_lss_cd == "TN" || mjr_clm_dmg_lss_cd == "UK" || mjr_clm_dmg_lss_cd == "VC") {
				ComShowCodeMessage("CNI00038", ". Can't be Created CODL[" + mjr_clm_dmg_lss_cd + "]");
				tabObjects[0].SelectedIndex = 0;
				frm.mjr_clm_dmg_lss_cd.focus();
				return false;
			}
		}

		var n3rd_labl_pty_cd = ComGetObjValue(frm.n3rd_labl_pty_cd);
		if (typeof(n3rd_labl_pty_cd) == "undefined" || n3rd_labl_pty_cd == "") {
			ComShowCodeMessage("CNI00003", "3rd Liable Party");
			tabObjects[0].SelectedIndex = 0;
			frm.n3rd_labl_pty_cd.focus();
			return false;
		}
	
		var inci_plc_tp_cd = ComGetObjValue(frm.inci_plc_tp_cd);
		if (typeof(inci_plc_tp_cd) == "undefined" || inci_plc_tp_cd == "") {
			ComShowCodeMessage("CNI00003", "POI");
			tabObjects[0].SelectedIndex = 0;
			frm.inci_plc_tp_cd.focus();
			return false;
		}
		
		var jmt_rslt_cd = ComGetObjValue(frm.jmt_rslt_cd);
		var jmt_rslt_dt = ComGetObjValue(frm.jmt_rslt_dt);
		if (jmt_rslt_cd != "" && jmt_rslt_dt == "") {
			ComShowCodeMessage("CNI00003", "Final Judgment Date");
			tabObjects[0].SelectedIndex = 2;
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
	
	var vObjects = frm.elements;
	
	for ( var kdx = 0; kdx < vObjects.length; kdx++) {
		var vObj   = vObjects[kdx];
		var vObjdf = vObj.dataformat;
		
		if ((typeof(vObjdf) != "undefined") && (vObjdf != null) && (vObjdf != "")) {
			ComClearSeparator(vObj);
		}//end if	
    }//end for
}

//Sheet 데이터를  HTML Form Object의 Value에 셋팅
function sheetXml2ObjectValue(pXml) {
	
	var vListData = SheetXml2ListMap(pXml);
	if (vListData.length > 0) {
		var vListVO = vListData[0];
		var vObjects = frm.elements;
		
		for ( var kdx = 0; kdx < vObjects.length; kdx++) {
			var vObj   = vObjects[kdx];
			var vObjtp = vObj.type;
			var vObjdf = vObj.dataformat;
			var vObjnm = vObj.name;
			var vObjval = vObj.value;

			if (vObjnm == undefined || vObjnm == ""){
				continue;
			}	
			
			var vData = vListVO[vObjnm];
         
			if (typeof (vData) == "undefined") {
				vData = vObjval;
			}
			//체크 박스시 'Y'일때 값 세팅
			if (vObjtp =="checkbox" ) {
				var vUpperData = vData.toUpperCase();
			    if (vUpperData != "Y") vData = "";	
			}  
			
			ComSetObjValue(vObj, vData);

			// 데이터 포맷 지정시 값 셋팅
			if (typeof(vObjdf) != "undefined" && vObjdf != null && vObjdf != "") {
				setFormatData(vObj, vData, vObjdf);
			}
		} //end for
	}// end if	
	
}

/**
 * 서버에서 조회한 Rawdata를 Form Object의 dataformat값에 따라 format처리함<br>
 * @param {pObj} form object 객체
 * @param {pRawData} 서버에서 조회한 값
 * @param {pDataFormat} dataformat값
 **/
function setFormatData(pObj, pRawData, pDataFormat){
	
    switch (pDataFormat) {
		case "ymd":    //yyyy-mm-dd
		case "ymdhms": //yyyy-mm-dd hh:mm:ss
		case "ymdhm":  //yyyy-mm-dd hh:mm
	   	    pObj.value = ComGetMaskedValue(pObj, pDataFormat);	
			break;
		case "int":
			pObj.value = ComAddComma2(pRawData, "#,###");
			break;
		case "float":
			if (pObj.name == "clmt_locl_xch_rt") {
				p = pRawData.split(".");
				p[0] = ComAddComma(p[0]);
				if      (p.length == 1) pObj.value = p[0]+".00000";
				else if (p.length == 2) pObj.value = p[0]+"."+p[1];
				else pObj.value = "";
			} else { 
			    pObj.value = ComAddComma2(pRawData, "#,###.00");
			}
			break;
		default:
			pObj.value = pRawData;
			break;
	}
}

/**
 * IBMultiComboBox 설정<br>
 * @param {select box} 콤보 객체
 * @param {xml} code , name의 xml
 **/
function setMultiComboBox(pComboObjId, pXML) {
	var vComboObj      = null; // IBMultiComboBox
	var vArrayListData = ""; 
	var vListData      = "";
	var vCaptionText   = "";
	
	vComboObj = getComboObject(pComboObjId);
	
	if (vComboObj == null || pXML == null ) {
		return;
	}

	var vArrayListData = SheetXml2ListMap(pXML);
	
	for ( var idx = 0; idx < vArrayListData.length; idx++) {
	    vListData = vArrayListData[idx];
		vCaptionText = vListData["code"] + " |" + vListData["name"];
		vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
	}//end for
	//빈 공백 추가
	vComboObj.InsertItem(0, "", "");
}


/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 **/
function getComboObject(pComboObjId){
	var vCnt = comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].id == pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}
 
/**
  * Office Code 값을 setting 한다.
  * @param comboId
  **/ 
function setOfficeCode(pOfcCd){
	if (frm.fmal_clm_rcv_ofc_cd.readOnly == false){
	   ComSetObjValue(frm.fmal_clm_rcv_ofc_cd, pOfcCd);
	}   
}
  
/**
  * ROE 입력후 svyr_fee_usd_amt 설정
  * Claim Amount 항목에 계산값 Setup = ( Survey Fee / R.O.E )
  * 소수점 세자리에서 반올림.
  **/
function setFeeUsdAmt() { 
  	var floatLoclAmt = cniParseFloat(frm.clmt_locl_amt);
  	var floatXchRt   = cniParseFloat(frm.clmt_locl_xch_rt);
  	if(floatXchRt != 0 && floatLoclAmt != 0 ){
  		// clmt_locl_amt / clmt_locl_xch_rt
  		var tmpUsdAmt = roundPrecision(floatLoclAmt / floatXchRt, 2);
  		frm.clmt_usd_amt.value = tmpUsdAmt;
  		var tmpUsdAmt2 = ComAddComma2(frm.clmt_usd_amt.value,"#,###.00"); //변수에 콤마를 입력하는 것이 안되어서 Object에 넣어서 처리함
  		frm.clmt_usd_amt.value = tmpUsdAmt2;
  	} else {
  		frm.clmt_usd_amt.value = "0";
  	}
 }
/**
 * IBSheet XML에서 XML 문자열을 파싱하여 그 안의 파라미터 항목 값을 리턴한다 <br>
 * @param {string} xmlStr    IBSheet를 통해 받아온 xml 문자열
 * @param {string} dataNode  파싱할 항목
 * @return {string} xmlValue
 **/
function getXMLData(pXmlStr, pDataNode) {
	
	var vXmlData = "";
 
	try {
          var vXmlDoc = new ActiveXObject("Microsoft.XMLDOM");
          vXmlDoc.async = "false";
          vXmlDoc.loadXML(pXmlStr);
          vXmlData = vXmlDoc.documentElement.getElementsByTagName(pDataNode).item(0).text
    } catch(err) {
    	  vXmlData = '';
    }
	return vXmlData;
}
 
function setMainCodeInquiry(partyVo) {
	switch(MainCode){
		case "claimant":
			frm.clmt_clm_pty_no.value = partyVo.clm_pty_no;
			frm.clmt_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			frm.clmt_clm_pty_nm.value = partyVo.pty_nm;
			break;
		case "insurer":
			frm.insur_clm_pty_no.value = partyVo.clm_pty_no;
			frm.insur_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			break;
		case "claimant_agent":
			frm.clm_agn_clm_pty_no.value = partyVo.clm_pty_no;
			frm.clm_agn_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			frm.clm_agn_clm_pty_nm.value = partyVo.pty_nm;
			frm.clm_agn_intl_phn_no.value = partyVo.intl_phn_no;
			frm.clm_agn_phn_no.value     = partyVo.phn_no;
			frm.clm_agn_pty_eml.value    = partyVo.pty_eml;	
			break;
		case "insurer_agent":
			frm.insur_agn_clm_pty_no.value = partyVo.clm_pty_no;
			frm.insur_agn_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			frm.insur_agn_clm_pty_nm.value = partyVo.pty_nm;
			frm.insur_agn_intl_phn_no.value = partyVo.intl_phn_no;
			frm.insur_agn_phn_no.value = partyVo.phn_no;
			frm.insur_agn_pty_eml.value = partyVo.pty_eml;
		 	break;
		case "attorney":
			frm.deft_atty_clm_pty_no.value = partyVo.clm_pty_no;
			frm.deft_atty_clm_pty_abbr_nm.value = partyVo.clm_pty_abbr_nm;
			frm.deft_atty_clm_pty_nm.value = partyVo.pty_nm;
			break;
	}
} 

/**
 * Miscellaneous Code-Inquiry 창에서 선택한 값을 처리하는 함수
 * @param miscCdVO
 * @return
 */
function setMiscCode(miscCdVO){
	
	var clss_clm_misc_cd = miscCdVO.clss_clm_misc_cd;
	
	switch(clss_clm_misc_cd){
	case "02":
		frm.mjr_clm_dmg_lss_cd.value = miscCdVO.clm_misc_cd;
		break;
	case "39":
		frm.n3rd_labl_pty_cd.value = miscCdVO.clm_misc_cd;
		break;
	case "11":
		frm.cgo_clm_tp_cd.value = miscCdVO.clm_misc_cd;
		break;
	case "14":
		frm.inci_plc_tp_cd.value = miscCdVO.clm_misc_cd;
		break;	
	case "15":
		frm.clm_cgo_tp_cd.value = miscCdVO.clm_misc_cd;
		frm.cgo_qlty_desc.value = miscCdVO.clm_misc_nm;
		break;
	}
}

/**
 * Currency 팝업에서 선택시 후속작업 : USD 선택시 ROE 1.00000를 자동 입력.
 */
function setCurrency(rowArray) { 
   frm.clmt_locl_curr_cd.value = rowArray[0][3];
   if(rowArray[0][3] == "USD"){
		frm.clmt_locl_xch_rt.value = "1.00000";
   }
}

/**
 * Currency 직접입력시 USD 일경우 ROE 1.00000를 자동 입력.
 */
 function setXchRt() { 
	if(frm.clmt_locl_curr_cd.value == "USD"){
		frm.clmt_locl_xch_rt.value = "1.00000";
	}
 }

/** R.O.E 팝업호출
 *  각화면에서 setCurrencyROE(xchRtVo) 메소드 구현
 */
function setCurrencyROE(xchRtVo) {
 	frm.clmt_locl_curr_cd.value = xchRtVo.curr_cd;
 	frm.clmt_locl_xch_rt.value = xchRtVo.usd_locl_xch_rt;
 	setFeeUsdAmt();
}

/**
 * CCC VVD & SKD Inquiry 팝업에서 선택한 값 셋팅
 * @param vvdSkdVo
 */
function setVvdSkd(vvdSkdVo){
	frm.slan_cd.value         = vvdSkdVo.slan_cd;
	frm.trnk_ref_vvd_no.value = vvdSkdVo.vvd;
	frm.pol_cd.value          = vvdSkdVo.pol;
	frm.pod_cd.value          = vvdSkdVo.pod;
}

 /**
  * 에러처러 공통 함수
  * @class IBSheet의 Search 후에 Exception시 해당 메세지를 보여준다 
  * @param {IBSheet} pSheetObj 해당 IBSheet
  * @param {string} pXml 서버에서 조회한 결과 XML
  * @throws
  * @author 정행룡
  * @since 2009.11.12
  */
function getErrorMsg(pSheetObj, pXml){
	var vErrorMsg = ComGetEtcData(pXml,"Exception");
	if (vErrorMsg != undefined && vErrorMsg != null && vErrorMsg != "" ) {
		pSheetObj.LoadSearchXml(pXml);//에러 메세지 처리
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
	var isExist = doActionIBSheet(SEARCH11);
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
	var isExist = doActionIBSheet(SEARCH12);
	if (isExist != "Y") {
		ComShowCodeMessage("CNI00034", pObj.getAttribute("caption"));
		ComSetObjValue(pObj, "");
		ComSetFocus(pObj);
		return false;
	}
	return true;
}

/* 
 * Final Judgment Code를 선택할때
 */
function jmt_rslt_cd_onchange(){
	var jmt_rslt_cd = ComGetObjValue(frm.jmt_rslt_cd);
    if (jmt_rslt_cd!=""){
    	if (ComIsNull(frm.smns_sve_dt.value)) {
        	ComShowCodeMessage("CNI00009" , "Summon Served Date!");
        	ComSetObjValue(frm.jmt_rslt_cd,"")
			ComSetFocus(frm.smns_sve_dt);
        }
    }
}


/**
* 금액, 통화, 날짜, 환율이 하나라도 입력시 다른 세개의 필드도 모두 입력되었는지 체크
*/
function chkAmount(objLoclAmt, objCurrCd, objInputDt, objXchRt, msg1, msg2) {
	
	var loclAmt = cniParseFloat(objLoclAmt);
	var currCd = objCurrCd.value.trim();
	var inputDt = objInputDt.value.trim();
	var xchRt = cniParseFloat(objXchRt);
	
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
	ComBtnDisable("btn1_Save");
	ComBtnDisable("btn1_Cancel");
	if (equalsRole("CNI03") || equalsRole("CNI93")) {
		 ComBtnEnable("btn1_Save");
		 ComBtnEnable("btn1_Cancel");	
	} else if (equalsRole("CNI02")) {
		var clm_area_cd = ComGetObjValue(frm.clm_area_cd);
		if (equalsArea(clm_area_cd)) {
			ComBtnEnable("btn1_Save");
			ComBtnEnable("btn1_Cancel");
		}
	} else if (equalsRole("CNI01")) {
		var usr_id = ComGetObjValue(frm.usr_id);
		var hdlr_usr_id = ComGetObjValue(frm.hdlr_usr_id);
		var hdlr_ofc_cd = ComGetObjValue(frm.hdlr_ofc_cd);
		if (usr_id == hdlr_usr_id &&  equalsOffice(hdlr_ofc_cd)) {
			ComBtnEnable("btn1_Save");
			ComBtnEnable("btn1_Cancel");
		}
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
	
	ComOpenRDPopup('resizable=yes, width=900, height=620');
}