/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0033.js
*@FileTitle : Invoice Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 최 선
*@LastVersion : 1.4 
* 2009.02.27 ay han
* 1.0 최초 생성 
*----------------------------------------------------------
* History
* 2009.03.18 최 선     1.1 [N200903160120] 'Supplement S/O 조회조건 추가 '
* 2009.03.25 최 선     1.2 [N200903160120] 상하단의 invoice 관련 금액의 comma 적용 및 금액input box에 focus 줄때 0일때 값 없애기 등의 이벤트 추가 
* 2009.03.25 최 선     1.3 [N200903160130] Mty select 팝업 추가
* 2010.12.01 최 선     1.4 [] INV. Exchange Rate Validiation 변경
* 2011.03.28 손은주 [CHM-201109560-01] Split 04-Intra - Europe Business 관련 VAT 기능 개발
* 2011.04.05 김영철 [CHM-201109654-01] Frustrate 처리된 CNTR 에 대해 두번이상 S/O 가 난 건들의 Invoice 처리 가능하도록 수정요청
* 2011.05.06  손은주 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2012.01.06 김종호 [CHM-201109410] [TRS] CNTR No. 유효성에 대한 Validation 절차 추가요청
* 2012.03.20 금병주 [CHM-201216895] [TRS] Invoice issue / receive date format Validation 추가요청
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경
* 2013.02.26 조인영 [CHM-201323086] Invoice Audit시 validation 추가 요청
* 2013.11.08 조인영 [CHM-201327482] W/O creation 컬럼 추가
=========================================================*/ 


/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0033 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0033() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/


// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var beforetab2 = 1;
var prefix = 'surcharge_';
var selectedIdx = 0;

var apply_flag = false;
var confirm_flag = false;

var sheetObjects = new Array();
var sheetCnt = 0;

var ofc_cd_arr = new Array();

var Mincount = 0 ;

var g_vndr_Seq                 = '';
var g_ida_gst_rgst_sts_cd      = '';
var g_ida_gst_rgst_no          = '';
var g_ida_ste_cd               = '';
var g_ida_ste_nm               = '';
var g_prnt_vndr_seq            = '';
var g_prnt_ida_gst_rgst_sts_cd = '';
var g_prnt_ida_gst_rgst_no     = '';
var g_prnt_ida_ste_cd          = '';
var g_prnt_ida_ste_nm          = '';

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject = sheetObjects[0];
	 var sheetObject_confirm = sheetObjects[1];

	// tab 객체 선언
     var tabObject = tabObjects[0];
	 /*******************************************************/
	 var formObject = document.form;


	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var selectedTab = tabObject.selectedIndex;  // 선택된 tab정보
		
		switch(srcName) {

			case 'btng_save':
			case 'btng_save2':
			case 'btng_save3':
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				// CHM-201534183 [TD]Inv Creation Time-out 에러 해결 2015.02.16
				ComOpenWait(true);
				setTimeout(function(){ doActionIBSheet(sheetObject, formObject, IBSAVE); ComOpenWait(false); }, 100);
				break;

			case 'btng_confirm':
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				// CHM-201534183 [TD]Inv Creation Time-out 에러 해결 2015.02.16
				ComOpenWait(true);
				setTimeout(function(){ doActionIBSheet(sheetObject,formObject,'CONFIRM'); ComOpenWait(false); }, 100);
				break;

			case 'btng_reset':
				if(document.form.mode_param.value == 'search') return;
				resetHeader(sheetObject, sheetObject_confirm, formObject);
				break;

			case 'btng_reset2':
//				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				resetCondition(sheetObject, sheetObject_confirm, formObject);
				break;
		
			case 'btng_apply':
				if(document.form.mode_param.value == 'search' || confirm_flag) return;
				checkInvoice();
				break;

			case 'btns_recieve':
				if(document.form.mode_param.value == 'search' || confirm_flag) return;
				var cal = new ComCalendar();
				cal.select(formObject.recieve_dt, 'yyyyMMdd');
				break;

			case 'btns_issue':
				if(document.form.mode_param.value == 'search' || confirm_flag) return;
				var cal = new ComCalendar();
				cal.select(formObject.issue_dt, 'yyyyMMdd');
				break;

			case "btng_retrieve":
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case 'btns_wo_no':
			case 'btns_booking_no':
			case 'btns_bl_no':
			case 'btns_eq_no':
			case 'btns_so_no':
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				rep_Multiful_inquiry(srcName);
				break;
			
			case "btng_provider":
				if(document.form.mode_param.value == 'search' || confirm_flag) return;
				if(!apply_flag) rep_OnPopupClick();
				break;

			case "btn_minimize":
				Mincount = (Mincount+1)%2 ;
				Minimize(Mincount);
				break;
				
			// start 2014.10.02
			case "btng_cntrMvmt":
				var sheetObj = sheetObjects[selectedTab];
				
				if( !validCntrMvmt(sheetObj) ) return;
				
				var checkArray = sheetObj.FindCheckedRow('chk1').split('|');
				var cntrNo = sheetObj.CellValue(checkArray[0], 'eq_no');
				var typeSize = sheetObj.CellValue(checkArray[0], 'eq_tpsz_cd');
				
				var url = "EES_CTM_0411.do?func=&cntrNo=" + cntrNo + "&checkDigit=&pop_mode=Y&typeSize=" + typeSize;
				ComOpenWindowCenter(url, "EES_CTM_0411", 1010, 650, false);
				break;
				
			case "btng_woPreview":
				var sheetObj = sheetObjects[selectedTab];
				woPreview(sheetObj);
				break;
				
			// end
			case 'btng_sendtoconfirmtab':
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				// CHM-201534183 [TD]Inv Creation Time-out 에러 해결 2015.02.16
				/*if( !checkEmptyEqNo(sheetObjects[0]) ) {return;}
				if( !checkDupEqNoANDWoNo()) {return;}*/
				ComOpenWait(true);
				setTimeout(function(){
					if( !checkEmptyEqNo(sheetObjects[0]) ) { ComOpenWait(false); return; }
					if( !checkDupEqNoANDWoNo()) { ComOpenWait(false); return; }
					sendToConfirmTab();
					ComOpenWait(false);
					}, 100);
				break;

			case 'btng_sendbackto':
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				// CHM-201534183 [TD]Inv Creation Time-out 에러 해결 2015.02.16
				ComOpenWait(true);
				setTimeout(function(){ sendToAuditTab(); ComOpenWait(false); }, 100);
				break;

			case "btng_reject":
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				rejectInvoice(sheetObjects[2], formObject);
				break;

			case "btng_cntrselect":
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				popContainerSelect(sheetObject,formObject);
				break;

			case "btng_cntrnoimport":
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				popCntrFileImport(sheetObject, formObject);
				break;

			case "btng_currencychange":
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				popCurrencyChange(sheetObject,formObject);
				break;
			
			case 'btng_invoicefileimport':
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				popInvoiceFileImport(sheetObject,formObject);
				break;

			case "btng_downexcel":
				sheetObjects[4].Down2Excel(-1,false,false,true);
				break;
			
			case "btng_downexcel0":
				sheetObjects[0].Down2Excel(-1,false,false,true);
				break;

			case "btng_verify":
				verifyEqNo(sheetObject, formObject);
				break;

			case "btng_surchargeapply":
				popSurchargeInputInquiry(sheetObject, '', '', 'multiple', 'IV');
				break;
				
			case "btng_mtyselect":	
				if(document.form.mode_param.value == 'search' || confirm_flag || !apply_flag) return;
				popMtySelect(sheetObject,formObject);			
				break;	
			case "btn_authority":
				openInvoiceAuthority();
				break;

			case "btng_gstRateCalc":
				fn_gst_rate_calc(document.form.inp_hsn_sac.value);
				break;
	
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}



/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){

	//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}

	if(mode_tab == 'C'){
		tabObjects[0].SelectedIndex = 1;
	}else{
		tabObjects[0].SelectedIndex = 0;
	}

	//html컨트롤 이벤트초기화
	initControl();
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH03;
	
	var sheetObj = sheetObjects[0];
	sheetObj.DoSearch4Post("ESD_TRS_0999GS.do", TrsFrmQryString(formObj));

	var conti_cd = sheetObj.EtcData('CONTI_CD');
	formObj.conti_cd.value = conti_cd;
	var eurView = document.all.item("eurView");
	
	if( conti_cd == 'E'){
		eurView.style.display = "";
		
	}else{
		eurView.style.display = "none";
	}
	
	if (ida_ofc_cd == 'Y') {
		document.getElementById("IndiaLayer01").style.display = "inline";
		document.getElementById("IndiaLayer02").style.display = "inline";
		document.getElementById("IndiaLayer03").style.display = "inline";
	} else {
		document.getElementById("IndiaLayer01").style.display = "none";
		document.getElementById("IndiaLayer02").style.display = "none";
		document.getElementById("IndiaLayer03").style.display = "none";
	}
	
	//invoice 권한 부여 버튼 활성화
	trsAuthBtnVisible("btn_auth", sheetObjects[0], formObj);
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon ??? ??1. ???catch
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
}

//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
	form.boo_bl_no.value = "";
    else
	form.boo_bl_no.value = form.hdn_boo_bl_no.value;
	*/
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
    //입력Validation 확인하기
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//            ComKeyOnlyNumber(event.srcElement);
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end


/**
 * 외부페이지에서 호출시 페이지를 초기화한다.
 */
function initMode() {

	var sheetObj = sheetObjects[2];
	var formObj = document.form;
    
	formObj.f_cmd.value = SEARCH03;
	sheetObj.DoSearch4Post("ESD_TRS_0033GS.do", TrsFrmQryString(formObj));
	if(sheetObj.RowCount == 0){ 
		ComShowCodeMessage('TRS90132');
		return false;
	}else{
		bindInvoiceHeader(sheetObj, formObj);
	}
	formObj.f_cmd.value = SEARCH06;
	formObj.trsp_inv_act_sts_cd_param.value = 'O';
	sheetObjects[0].DoSearch4Post("ESD_TRS_0033GS.do", TrsFrmQryString(formObj), '', true);

	formObj.trsp_inv_act_sts_cd_param.value = 'C';
	sheetObjects[1].DoSearch4Post("ESD_TRS_0033GS.do", TrsFrmQryString(formObj), '', true);
	setCurrChange();

	if(document.form.mode_param.value == 'search'){
		setDisabled('SEARCH_MODE');
	}else if(document.form.mode_param.value == 'modify'){
		setDisabled('APPLY');
		getOfcCd();
	}

}

/**
 * 로그인한 사용자의 OFC CD Default Currency를 설정한다.
 */
function initCurrency(){

	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	formObj.f_cmd.value = SEARCH12;
	sheetObj.DoRowSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj));

}

/**
 * 불러온 Invoice Header 정보를 페이지의 form object에 세팅한다.
 */
function bindInvoiceHeader(sheetObj, formObj){
	var eurView = document.all.item("eurView"); 
	formObj.invoice_no.value = sheetObj.CellValue(1, 'inv_no');
	formObj.recieve_dt.value = sheetObj.CellValue(1, 'inv_rcv_dt');
	if(sheetObj.CellValue(1, 'ap_rvs_cng_flg') == 'Y'){
		eurView.style.display = "";
		formObj.ap_reverse_change_flg.checked = true;
	}else{
		formObj.ap_reverse_change_flg.checked = false;
	}
	formObj.issue_dt.value = sheetObj.CellValue(1, 'inv_iss_dt');

	formObj.combo_svc_provider.value = sheetObj.CellValue(1, 'wo_vndr_seq');
	formObj.svc_provider.value = sheetObj.CellValue(1, 'wo_vndr_nm');

	formObj.paymt_sp_cd.value = sheetObj.CellValue(1, 'inv_vndr_seq');
	formObj.paymt_sp_nm.value = sheetObj.CellValue(1, 'inv_vndr_nm');

	var comboObj = document.paymt_sp_combo;
	comboObj.InsertItem(-1, sheetObj.CellValue(1, 'inv_vndr_seq'), sheetObj.CellValue(1, 'inv_vndr_nm'));
	comboObj.Index2 = comboObj.GetCount()-1;

	formObj.apply_currency.value = sheetObj.CellValue(1, 'inv_curr_cd');

	formObj.inv_amt.value = sheetObj.CellValue(1, 'inv_bzc_amt');
	formObj.vat_amt.value = sheetObj.CellValue(1, 'inv_vat_amt');
	formObj.tot_amt.value = sheetObj.CellValue(1, 'inv_ttl_amt');
	formObj.wht_amt.value = sheetObj.CellValue(1, 'inv_whld_tax_amt');
	formObj.sbc_amt.value = sheetObj.CellValue(1, 'inv_sbc_amt');
	
	if(ida_ofc_cd == 'Y') {
		formObj.inp_ida_cgst_amt.value = sheetObj.CellValue(1, 'ida_cgst_amt');
		formObj.inp_ida_sgst_amt.value = sheetObj.CellValue(1, 'ida_sgst_amt');
		formObj.inp_ida_igst_amt.value = sheetObj.CellValue(1, 'ida_igst_amt');
		formObj.inp_ida_ugst_amt.value = sheetObj.CellValue(1, 'ida_ugst_amt');

		fn_vat_mna_input_chk();
	}
}

function getVendorSeq(sheetObj, formObj, vndr_seq){

	formObj.f_cmd.value = SEARCH11;
	formObj.TRSP_SO_VNDR_NO.value = get_only_num(vndr_seq);

	sheetObj.RemoveEtcData();
	sheetObj.DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));
    
	var vendorNoList = sheetObj.EtcData('vndr_no');
	var vendorNmList = sheetObj.EtcData('vndr_nm_eng');
	var comboObj = document.paymt_sp_combo;

	if (vendorNoList == undefined || vendorNoList == ''){
		formObj.combo_svc_provider.value = '';
		formObj.svc_provider.value = '';

		formObj.paymt_sp_cd.value = '';
		formObj.paymt_sp_nm.value = '';
		
		if(ida_ofc_cd == 'Y') {
			formObj.ida_gst_rgst_sts_cd.value = '';
			formObj.ida_gst_rgst_no.value     = '';
			formObj.ida_ste_cd.value          = '';
			formObj.ida_ste_nm.value          = '';
		}
		
		comboObj.RemoveAll();
		return false;
	}

	formObj.combo_svc_provider.value = lpad(vendorNoList, 6, '0') ;
	formObj.svc_provider.value = vendorNmList;
	searchPaymentSP(sheetObjects[1], formObj, vendorNoList);
	return true;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	
	var formObj = document.form;
	var cnt = 0;
	switch(sheetNo) {
		case 1:      // Auditing Object Sheet
			with (sheetObj) {

				style.height=GetSheetHeight(10);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				//InitColumnInfo(70, 3, 0, true);
				InitColumnInfo(84, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle1 = "|Equipment\nNumber|TP / SZ|Original\nTP / SZ|From Node|From Node|Via Node|Via Node|To Node|To Node|Door\nLocation|Door\nLocation|"
								+"Actual\nCustomer|Door Delivery\nAddress|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount"
								+"|Work Order Amount|Work Order Amount|Work Order Amount|Exchange\nRate|Calculation\nLogic|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|HSN/SAC|Goods/\nServices|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|TOTAL GST|TOTAL GST|S/O No|W/O No|"
								+"W/O Creation|W/O Creation|W/O Issue Time|W/O Issue Time|COP\nExecuted Time|BKG No|BL No|BKG\nCargo Type|BKG\nSPE|Bound|Door\nService Type|3rd Party"
								+"|Internal Remark|Special Instruction|Reference|Reference|Outgate Date|Ingate Date"
								+"|Verify Result|Invoice Remark|SPP\nInvoice Remark|S/O Type|";

				var HeadTitle2 = "|Equipment\nNumber|TP / SZ|Original\nTP / SZ|||||||||"
								+"Actual\nCustomer|Door Delivery\nAddress|Currency|Basic|Negotiated|Fuel|Vat"
								+"|Toll Fee|Additional|Total|Exchange\nRate|Calculation\nLogic|Currency|Basic|Surcharge|Total|HSN/SAC|Goods/\nServices|Rate|Amount|Rate|Amount|Rate|Amount|Rate|Amount|Rate|Amount|S/O No|W/O No|"
								+"ISS ID|Name|||COP\nExecuted Time|BKG No|BL No|BKG\nCargo Type|BKG\nSPE|Bound|Door\nService Type|3rd Party"
								+"|Internal Remark|Special Instruction|CNTR No|TP/SZ|Outgate Date|Ingate Date"
								+"|Verify Result|Invoice Remark|SPP\nInvoice Remark|S/O Type|";


				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				HeadRowHeight = 12;

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,    "chk1",     false,          "",       dfNone,   		0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      100,  daCenter,  true,    "eq_no",     false,          "",       dfNone,   		0,     true,      true, 15);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "eq_tpsz_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "org_eq_tpsz_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "fm_loc_value",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  true,    "fm_yard_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "via_loc_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  true,    "via_yard_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "to_loc_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  true,    "to_yard_value",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "dor_loc_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  true,    "dor_yard_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "cust_cnt_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "dor_de_addr",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "curr_cd",     false,          "",       dfNone,   		0,     false,      false);
				if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
					InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "bzc_amt",     	false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "nego_amt",     	false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "fuel_scg_amt",  false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "scg_vat_amt",   false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "toll_fee_amt",  false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "etc_add_amt",   false,          "",       dfInteger,   		0,     false,      false);

	
					InitDataProperty(0, cnt++ , dtData,       85,  daCenter,  true,    "wo_tot_amt",     false,          "",       dfInteger,   		0,     false,      false);
				}else{
					InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "bzc_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "nego_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "fuel_scg_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "scg_vat_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "toll_fee_amt",  false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "etc_add_amt",     false,          "",       dfFloat,   		2,     false,      false);
	
					InitDataProperty(0, cnt++ , dtData,       85,  daCenter,  true,    "wo_tot_amt",     false,          "",       dfFloat,   		2,     false,      false);
				}
				
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "inv_xch_rt",     false,          "",       dfNone,   		2,     false,      false);
				InitDataProperty(0, cnt++ , dtCombo,     170,  daCenter,  true,    "trsp_inv_calc_lgc_tp_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "inv_curr_cd",     false,          "",       dfNone,   		0,     false,      false);
				
				if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
					InitDataProperty(0, cnt++ , dtData,     100,  daCenter,  true,    "inv_bzc_amt",     false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtPopup,      100,  daCenter,  true,    "inv_etc_add_amt", false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "inv_tot_amt",     false,          "|inv_bzc_amt|+|inv_etc_add_amt|",       dfInteger,   		0,     false,      false);
				}else{
					InitDataProperty(0, cnt++ , dtData,     100,  daCenter,  true,    "inv_bzc_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtPopup,      100,  daCenter,  true,    "inv_etc_add_amt", false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "inv_tot_amt",     false,          "|inv_bzc_amt|+|inv_etc_add_amt|",       dfFloat,   		2,     false,      false);
				}
				
				if(ida_ofc_cd == 'Y'){
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,     "ida_sac_cd"          ,       false,          "",       dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++ , dtCombo,     70,    daCenter,  true,     "ida_pay_tp_cd"       ,       false,          "",       dfNone,    0,     true,       true);					
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_cgst_rto"        ,       false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_cgst_amt"        ,       false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_sgst_rto"        ,       false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_sgst_amt"        ,       false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_igst_rto"        ,       false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_igst_amt"        ,       false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_ugst_rto"        ,       false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_ugst_amt"        ,       false,          "",       dfFloat,   2,     true,       true);
                    //InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  true,     "ida_gst_amt"         ,       false,          "|ida_cgst_amt| + |ida_sgst_amt| + |ida_igst_amt| + |ida_ugst_amt|",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  true,     "ida_gst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  true,     "ida_gst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
					
				} else {
					InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,     "ida_sac_cd"          ,       false,          "",       dfNone,    0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,     "ida_pay_tp_cd"       ,       false,          "",       dfNone,    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_cgst_rto"        ,       false,          "",       dfFloat,   2,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_cgst_amt"        ,       false,          "",       dfFloat,   2,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_sgst_rto"        ,       false,          "",       dfFloat,   2,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_sgst_amt"        ,       false,          "",       dfFloat,   2,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_igst_rto"        ,       false,          "",       dfFloat,   2,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_igst_amt"        ,       false,          "",       dfFloat,   2,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_ugst_rto"        ,       false,          "",       dfFloat,   2,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_ugst_amt"        ,       false,          "",       dfFloat,   2,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_gst_rto"         ,       false,          "",       dfFloat,   2,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_gst_amt"         ,       false,          "",       dfFloat,   2,     false,      false);
				}				
				
				InitDataProperty(0, cnt++ , dtData,		  60,  daCenter,  true,    "trsp_so_ofc_cty_cd_seq",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "trsp_wo_ofc_cty_cd_seq",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"wo_iss_id",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daLeft,	true,	"wo_iss_nm",			false,		"",	dfNone,		0,	false,	false	);
				
				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "cre_dt",     false,          "",       dfDateYmd,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "cre_tm",     false,          "",       dfTimeHm,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "cop_exe_dt",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "bkg_no",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "bl_no",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "cgo_tp_cd",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "spcl_cgo_cntr_tp_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "trsp_bnd_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "dor_svc_tp_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtPopup,     110,  daCenter,  true,    "n3pty_bil_flg",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      120,  daLeft,  true,    "inter_rmk",     false,          "",       dfNone,   		2000,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      120,  daLeft,  true,    "spcl_instr_rmk",     false,          "",       dfNone,   		2000,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      120,  daCenter,  true,    "cntr_no",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      60,  daCenter,  true,    "cntr_tpsz_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      120,  daCenter,  true,    "org_gate_out_dt",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      120,  daCenter,  true,    "dest_gate_in_dt",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      200,  daLeft,  true,    "verify_result",     false,          "",       dfNone,   		2000,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      200,  daLeft,  true,    "inv_rmk",     false,          "",       dfNone,   		2000,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      200,  daLeft,  true,    "sp_inv_rmk",     false,          "",       dfNone,   		2000,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      60,  	daCenter,  true,    "trsp_so_tp_cd",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtStatus,      0,   daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "cust_seq",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "trsp_wo_ofc_cty_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "trsp_wo_seq",     false,          "",       dfNone,   		0,     false,      false);
				//InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "bkg_no_split",     false,          "",       dfNone,   		0,     false,      false);
				//InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "bl_no_tp",     false,          "",       dfNone,   		0,     false,      false);
				//InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,	"bl_no_chk",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "trsp_so_ofc_cty_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "trsp_so_seq",     false,          "",       dfNone,   		0,     false,      false);
				//InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "trsp_so_tp_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "trsp_cost_dtl_mod_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "eq_knd_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "trsp_inv_act_sts_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "trsp_mty_cost_mod_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "cre_ofc_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,	   0,  	daCenter,  true,	"surcharge_key");
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "cntr_sub_flg",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "sub_eq_tpsz_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "org_eq_no",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "empty_eq_no_verify_check",     false,          "",       dfNone,   		1,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "cost_act_grp_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "trsp_frst_flg",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "n3pty_curr_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  	daCenter,  true,    "tro_seq",     false,          "",       dfNone,   		0,     false,      false);
				
				ColHidden('ibflag')						= true;
				ColHidden('inv_curr_cd')				= true;
				ColHidden('trsp_so_tp_cd')              = false;
				InitDataCombo(0, 'trsp_inv_calc_lgc_tp_cd', calc_logic_cdText, calc_logic_cdCode);
				if(ida_ofc_cd == 'Y'){
					InitDataCombo(0, "ida_pay_tp_cd", "Goods|Services", "G|S");
				}				
				AllowEvent4CheckAll = false;
			}
			break;
		case 2:      // Comfirm Sheet
			with (sheetObj) {
				style.height=GetSheetHeight(10);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				//InitColumnInfo(64, 1, 0, true);
				InitColumnInfo(78, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle1 = "|Equipment\nNumber|TP / SZ|Original\nTP / SZ|From Node|From Node|Via Node|Via Node|To Node|To Node|Door\nLocation|Door\nLocation|"
								+"Actual\nCustomer|Door Delivery\nAddress|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount|Work Order Amount"
								+"|Work Order Amount|Work Order Amount|Work Order Amount|Exchange\nRate|Calculation\nLogic|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|HSN/SAC|Goods/\nServices|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|TOTAL GST|TOTAL GST|S/O No|W/O No|"
								+"W/O Issue Time|W/O Issue Time|COP\nExecuted Time|BKG No|BL No|BKG\nCargo Type|BKG\nSPE|Bound|Door\nService Type|3rd Party"
								+"|Internal Remark|Special Instruction|Reference|Reference|Outgate Date|Ingate Date"
								+"|Verify Result|Invoice Remark|SPP\nInvoice Remark";

				var HeadTitle2 = "|Equipment\nNumber|TP / SZ|Original\nTP / SZ|||||||||"
								+"Actual\nCustomer|Door Delivery\nAddress|Currency|Basic|Negotiated|Fuel|Vat"
								+"|Toll Fee|Additional|Total|Exchange\nRate|Calculation\nLogic|Currency|Basic|Surcharge|Total|HSN/SAC|Goods/\nServices|Rate|Amount|Rate|Amount|Rate|Amount|Rate|Amount|Rate|Amount|S/O No|W/O No|"
								+"||COP\nExecuted Time|BKG No|BL No|BKG\nCargo Type|BKG\nSPE|Bound|Door\nService Type|3rd Party"
								+"|Internal Remark|Special Instruction|CNTR No|TP/SZ|Outgate Date|Ingate Date"
								+"|Verify Result|Invoice Remark|SPP\nInvoice Remark";


				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				HeadRowHeight = 12;

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,    "chk1",     false,          "",       dfNone,   		0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      100,  daCenter,  true,    "eq_no",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "eq_tpsz_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "org_eq_tpsz_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "fm_loc_value",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  true,    "fm_yard_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "via_loc_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  true,    "via_yard_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "to_loc_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  true,    "to_yard_value",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "dor_loc_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       30,  daCenter,  true,    "dor_yard_value",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "cust_cnt_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "dor_de_addr",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "curr_cd",     false,          "",       dfNone,   		0,     false,      false);
				if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
					InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "bzc_amt",     false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "nego_amt",     false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "fuel_scg_amt",     false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "scg_vat_amt",     false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "toll_fee_amt",  false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "etc_add_amt",     false,          "",       dfInteger,   		0,     false,      false);
	
					InitDataProperty(0, cnt++ , dtData,       85,  daCenter,  true,    "wo_tot_amt",     false,          "",       dfInteger,   		0,     false,      false);
				}else{
					InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "bzc_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "nego_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "fuel_scg_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "scg_vat_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "toll_fee_amt",  false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "etc_add_amt",     false,          "",       dfFloat,   		2,     false,      false);
	
					InitDataProperty(0, cnt++ , dtData,       85,  daCenter,  true,    "wo_tot_amt",     false,          "",       dfFloat,   		2,     false,      false);
				}
				
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "inv_xch_rt",     false,          "",       dfNone,   		2,     false,      false);
				InitDataProperty(0, cnt++ , dtCombo,     170,  daCenter,  true,    "trsp_inv_calc_lgc_tp_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "inv_curr_cd",     false,          "",       dfNone,   		0,     false,      false);
				
				if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
					InitDataProperty(0, cnt++ , dtData,     100,  daCenter,  true,    "inv_bzc_amt",     false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtPopup,      100,  daCenter,  true,    "inv_etc_add_amt", false,          "",       dfInteger,   		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "inv_tot_amt",     false,          "|inv_bzc_amt|+|inv_etc_add_amt|",       dfInteger,   		0,     false,      false);
				
				}else{
					InitDataProperty(0, cnt++ , dtData,     100,  daCenter,  true,    "inv_bzc_amt",     false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtPopup,      100,  daCenter,  true,    "inv_etc_add_amt", false,          "",       dfFloat,   		2,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "inv_tot_amt",     false,          "|inv_bzc_amt|+|inv_etc_add_amt|",       dfFloat,   		2,     false,      false);
				}
				
				if(ida_ofc_cd == 'Y'){
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,  true,     "ida_sac_cd"           ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,     70,    daCenter,  true,     "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     false,       false);					
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  false,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  true,     "ida_gst_rto"          ,       false,          "|ida_cgst_rto| + |ida_sgst_rto| + |ida_igst_rto| + |ida_ugst_rto|",       dfFloat,   2,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,    daRight ,  true,     "ida_gst_amt"          ,       false,          "|ida_cgst_amt| + |ida_sgst_amt| + |ida_igst_amt| + |ida_ugst_amt|",       dfFloat,   2,     true,       true);
				} else {
					InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,     "ida_sac_cd"           ,       false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,     "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_gst_rto"          ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,     "ida_gst_amt"          ,       false,          "",       dfFloat,   2,     false,       false);
				}				
				
				InitDataProperty(0, cnt++ , dtData,		  60,  daCenter,  true,    "trsp_so_ofc_cty_cd_seq",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  true,    "trsp_wo_ofc_cty_cd_seq",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "cre_dt",     false,          "",       dfDateYmd,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,    "cre_tm",     false,          "",       dfTimeHm,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "cop_exe_dt",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "bkg_no",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "bl_no",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       90,  daCenter,  true,    "cgo_tp_cd",     false,          "",       dfNone,   		0,     false,      false);

				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "spcl_cgo_cntr_tp_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "trsp_bnd_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,    "dor_svc_tp_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtPopup,     110,  daCenter,  true,    "n3pty_bil_flg",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      120,  daLeft,  true,    "inter_rmk",     false,          "",       dfNone,   		2000,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      120,  daLeft,  true,    "spcl_instr_rmk",     false,          "",       dfNone,   		2000,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      120,  daCenter,  true,    "cntr_no",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      60,  daCenter,  true,    "cntr_tpsz_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      120,  daCenter,  true,    "org_gate_out_dt",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      120,  daCenter,  true,    "dest_gate_in_dt",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      200,  daLeft,  true,    "verify_result",     false,          "",       dfNone,   		2000,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      200,  daLeft,  true,    "inv_rmk",     false,          "",       dfNone,   		2000,     false,      false);
				InitDataProperty(0, cnt++ , dtData,      200,  daLeft,  true,    "sp_inv_rmk",     false,          "",       dfNone,   		2000,     false,      false);

				InitDataProperty(0, cnt++ , dtStatus,      0,   daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "cust_seq",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "trsp_wo_ofc_cty_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "trsp_wo_seq",     false,          "",       dfNone,   		0,     false,      false);
				//InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "bkg_no_split",     false,          "",       dfNone,   		0,     false,      false);
				//InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "bl_no_tp",     false,          "",       dfNone,   		0,     false,      false);
				//InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "bl_no_chk",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "trsp_so_ofc_cty_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,   daCenter,  true,    "trsp_so_seq",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,      "trsp_so_tp_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,      "trsp_cost_dtl_mod_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,      "eq_knd_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,      "trsp_inv_act_sts_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,      "cre_ofc_cd",     false,          "",       dfNone,   		0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,	   0,  daCenter,  true,		 "surcharge_key");
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,     "cntr_sub_flg",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,     "sub_eq_tpsz_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,     "org_eq_no",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,     "empty_eq_no_verify_check",     false,          "",       dfNone,   		1,     true,      true);
				InitDataProperty(0, cnt++ , dtHidden,      0,  daCenter,  true,     "cost_act_grp_cd",     false,          "",       dfNone,   		0,     false,      false);
				
				ColHidden('ibflag')						= true;
				ColHidden('inv_curr_cd')				= true;
				InitDataCombo(0, 'trsp_inv_calc_lgc_tp_cd', calc_logic_cdText, calc_logic_cdCode);
				if(ida_ofc_cd == 'Y') {
					InitDataCombo(0, "ida_pay_tp_cd", "Goods|Services", "G|S");
				}				
				AllowEvent4CheckAll = false;
			}
			break;
		case 3:      // Header Info Sheet
			with (sheetObj) {
				style.height= 0;
				//전체 너비 설정
				SheetWidth = 0;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(32, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				var HeadTitle = "";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,    0,  daCenter,  false,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_no",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_vndr_seq",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_vndr_nm",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "trsp_inv_aud_sts_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "gen_pay_term_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_cfm_dt",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "wo_vndr_seq",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "wo_vndr_nm",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_curr_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_bzc_amt",     false,          "",       dfFloat,   		3,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_vat_amt",     false,          "",       dfFloat,   		3,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_ttl_amt",     false,          "",       dfFloat,   		3,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "rgst_no",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_pay_mzd_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_chk_trns_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_rcv_dt",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "ap_rvs_cng_flg",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "pay_dt",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_rjct_flg",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_eff_dt",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_rjct_dt",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_iss_dt",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "vat_amt",     false,          "",       dfFloat,   		3,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "cur_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "if_sys_knd_cd",     false,          "",       dfNone,   		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_whld_tax_amt",     false,          "",       dfFloat,   		3,     true,      true);
				InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "inv_sbc_amt",     false,          "",       dfFloat,   		3,     true,      true);
				
				if(ida_ofc_cd == 'Y'){
					InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "ida_cgst_amt",     false,          "",       dfFloat,   		3,     true,      true);
					InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "ida_sgst_amt",     false,          "",       dfFloat,   		3,     true,      true);
					InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "ida_igst_amt",     false,          "",       dfFloat,   		3,     true,      true);
					InitDataProperty(0, cnt++ , dtData,      0,  daCenter,  false,    "ida_ugst_amt",     false,          "",       dfFloat,   		3,     true,      true);
				}
				
			}
			break;

			case 4:      //Surcharge sheet
					with (sheetObj) {
				// 높이 설정
				style.height= 0;
				//전체 너비 설정
				SheetWidth = 0;
//				style.height=GetSheetHeight(10);
				//전체 너비 설정
//				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(68, 2, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "ibflag|chk1|unique_cd|trsp_so_ofc_cty_cd|trsp_so_seq|lgs_cost_cd|lgs_cost_full_nm|trsp_step_tp_cd" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, false);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++ , dtStatus,30,daCenter,	false,	prefix+"ibflag");
				InitDataProperty(0, cnt++,dtCheckBox,30,daCenter,	false,	prefix+"chk1");
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'unique_cd'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 50,daCenter,	false,  prefix+'trsp_so_ofc_cty_cd'     ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	100,daCenter,	false,  prefix+'trsp_so_seq'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	100,daCenter,	false,  prefix+'lgs_cost_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lgs_cost_full_nm'       ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'trsp_step_tp_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	100,daCenter,	false,  prefix+'scg_amt'                ,false,"",dfFloat,2,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'chss_no' 			     ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incur_dt' 			     ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fne_cuz_desc'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'fumg_cost_tp_cd'        ,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'rf_hndl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'rf_mgst_usg_flg'		,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'mgst_tpsz_cd'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_knt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'lftg_cuz_desc'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'stop_loc_nod_cd'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'grs_wgt'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	100,daCenter,	false,  prefix+'wo_grs_wgt_meas_ut_cd'  ,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'tri_axl_flg'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ovr_wgt_prmt_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ovr_wgt_otr_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ovr_wgt_rmk'			,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'incrt_dt'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'scl_stop_plc_nod_cd'    ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'sto_dys'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no'              ,false,"",dfNone,0,true,true);
				//InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'ob_bkg_no_split'        ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'wt_hrs'		            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'otr_rmk'                ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	100,daCenter,	false,  prefix+'inv_scg_amt'			,false,"",dfFloat,2,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_chss_no'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incur_dt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_dry_run_rlbl_pty_tp_cd' ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fne_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_fumg_cost_tp_cd'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_mgst_tpsz_cd'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_insp_rf_pti_cstms_tp_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_knt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_lftg_cuz_desc'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_stop_loc_nod_cd'	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_rf_hndl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_rf_mgst_usg_flg'	,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 30,daCenter,	false,  prefix+'inv_grs_wgt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	100,daCenter,	false,  prefix+'inv_grs_wgt_meas_ut_cd' ,false,"",dfNone,0,true,true);
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_tri_axl_flg'		,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ovr_wgt_prmt_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ovr_wgt_otr_flg'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ovr_wgt_rmk'		,false,"",dfNone,0,true,true);
				
				
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_incrt_dt'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_scl_stop_plc_nod_cd',false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_sto_dys'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no'			,false,"",dfNone,0,true,true);
				//InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_ob_bkg_no_split'	,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_wt_hrs'				,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'inv_otr_rmk'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_bil_flg'          ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_cnt_cd'            ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cust_seq'               ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_vndr_seq'         ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_ofc_cd'           ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_amt'              ,false,"",dfFloat,2,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'n3pty_desc'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,  30,daCenter,  	false,  prefix+'n3pty_curr_cd'			,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_ofc_cd'             ,false,"",dfNone,0,true,true);
				InitDataProperty(0, cnt++ , dtData,	 10,daCenter,	false,  prefix+'cre_usr_id'             ,false,"",dfNone,0,true,true);
		   }
			break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.wo_no.value = formObj.wo_no.value.toUpperCase();
			formObj.so_no.value = formObj.so_no.value.toUpperCase();
			if(!validateForm(sheetObj,formObj, 'SEARCH01')) return;
			formObj.f_cmd.value = SEARCH01;
			var beforeRowCnt = sheetObj.RowCount;
			var sheetObj_surcharge = sheetObjects[3];
			var beforeScgRow = sheetObj_surcharge.RowCount;
			sheetObj.DoSearch4Post("ESD_TRS_0033GS.do", TrsFrmQryString(formObj), '', true);
			var afterRowCnt = sheetObj.RowCount;
			var afterScgRow = sheetObj_surcharge.RowCount;	
			if((afterRowCnt-beforeRowCnt) == 0) {
				ComShowCodeMessage('TRS90132');
				return;
			}else{
				removeDupSoNo(sheetObj, beforeRowCnt, afterRowCnt, beforeScgRow, afterScgRow);
				setCurrChange();
			}
			break;
		
		case IBSAVE:        //저장
			if(!apply_flag){
				ComShowCodeMessage('TRS90080');
				return;
			}
			
			if(sheetObjects[0].RowCount < 1 && sheetObjects[1].RowCount < 1){
				ComShowCodeMessage('TRS90132');
				return;
			}
			//AP VAT 부과여부에 대한 value 셋팅
			if( formObj.ap_reverse_change_flg.checked == true ) formObj.ap_rvs_cng_flg.value = 'Y';
			
			formObj.inv_amt.value = deleteComma(formObj.inv_amt.value);
			formObj.vat_amt.value = deleteComma(formObj.vat_amt.value);
			formObj.wht_amt.value = deleteComma(formObj.wht_amt.value);
			formObj.sbc_amt.value = deleteComma(formObj.sbc_amt.value);
			formObj.tot_amt.value = deleteComma(formObj.tot_amt.value);
			
			formObj.inp_ida_cgst_amt.value = deleteComma(formObj.inp_ida_cgst_amt.value);
			formObj.inp_ida_sgst_amt.value = deleteComma(formObj.inp_ida_sgst_amt.value);
			formObj.inp_ida_igst_amt.value = deleteComma(formObj.inp_ida_igst_amt.value);
			formObj.inp_ida_ugst_amt.value = deleteComma(formObj.inp_ida_ugst_amt.value);
			
			formObj.sum_inv_tot_amt.value = deleteComma(formObj.sum_inv_tot_amt.value);

			
			if(!validateForm(sheetObj,formObj, IBSAVE)) return;

			formObj.f_cmd.value = MULTI01;
			var sheetObj_confirm = sheetObjects[1];
			var sheetObj_surcharge = sheetObjects[3];
			for(var i=2; i<sheetObj.RowCount+2; i++){
				sheetObj.CellValue2(i, 'trsp_inv_act_sts_cd') = 'O';
			}

			for(var i=2; i<sheetObj_confirm.RowCount+2; i++){
				sheetObj_confirm.CellValue2(i, 'trsp_inv_act_sts_cd') = 'C';
			}
			
			var confirmQuery = '';
			var surchargeQuery = sheetObj_surcharge.GetSaveString(true, false);
//			alert(surchargeQuery);
//			var xml = sheetObj.GetSaveXml('ESD_TRS_0033GS.do', confirmQuery+'&'+surchargeQuery+'&'+TrsFrmQryString(formObj), false);
//			sheetObj.LoadSaveXml(xml);

			if(sheetObj.RowCount>0){
				confirmQuery = sheetObj_confirm.GetSaveString(true, false);
				sheetObj.DoAllSave('ESD_TRS_0033GS.do', confirmQuery+'&'+surchargeQuery+'&'+TrsFrmQryString(formObj), false);
			}else{
				confirmQuery = sheetObj.GetSaveString(true, false);
				sheetObj_confirm.DoAllSave('ESD_TRS_0033GS.do', confirmQuery+'&'+surchargeQuery+'&'+TrsFrmQryString(formObj), false);
			}
			
			//각 금액에 다시 comma를 붙인다.
			calAmt();
			formObj.sum_inv_tot_amt.value = ComAddComma(formObj.sum_inv_tot_amt.value);
			
			break;

		case 'CONFIRM':
			
			var cgstSum = 0;
			var sgstSum = 0;
			var igstSum = 0;
			var ugstSum = 0;

			if(!apply_flag){
				ComShowCodeMessage('TRS90080');
				return;
			}
			
			if(sheetObjects[0].RowCount < 1 && sheetObjects[1].RowCount < 1){
				ComShowCodeMessage('TRS90132');
				return;
			}

			//if(Number(formObj.sum_inv_tot_amt.value) != Number(formObj.inv_amt.value)){
			if(Number(deleteComma(formObj.sum_inv_tot_amt.value)) != Number(deleteComma(formObj.inv_amt.value))){
				ComShowCodeMessage('TRS90035');
				return;
			}
			
			//AP VAT 부과여부에 대한 value 셋팅
			if( formObj.ap_reverse_change_flg.checked == true ) formObj.ap_rvs_cng_flg.value = 'Y';
			
			//comma 삭제 
			formObj.inv_amt.value = deleteComma(formObj.inv_amt.value);
			formObj.vat_amt.value = deleteComma(formObj.vat_amt.value);
			formObj.wht_amt.value = deleteComma(formObj.wht_amt.value);
			formObj.sbc_amt.value = deleteComma(formObj.sbc_amt.value);
			formObj.tot_amt.value = deleteComma(formObj.tot_amt.value);
			
			formObj.inp_ida_cgst_amt.value = deleteComma(formObj.inp_ida_cgst_amt.value);
			formObj.inp_ida_sgst_amt.value = deleteComma(formObj.inp_ida_sgst_amt.value);
			formObj.inp_ida_igst_amt.value = deleteComma(formObj.inp_ida_igst_amt.value);
			formObj.inp_ida_ugst_amt.value = deleteComma(formObj.inp_ida_ugst_amt.value);
			
			formObj.sum_inv_tot_amt.value = deleteComma(formObj.sum_inv_tot_amt.value);
						
			if(!validateForm(sheetObj,formObj, 'CONFIRM')) return;

			formObj.f_cmd.value = MULTI02;
			var sheetObj_audit = sheetObjects[0];
			var sheetObj_confirm = sheetObjects[1];
			var sheetObj_surcharge = sheetObjects[3];

			var checkList = sheetObj_confirm.FindCheckedRow('chk1');
			var checkArray = checkList.split('|');

			if(checkList == ''){
				ComShowCodeMessage('TRS90215');
				return false;
			}

			for(var i=2; i<sheetObj.RowCount+2; i++){
				sheetObj.CellValue2(i, 'trsp_inv_act_sts_cd') = '';
				for(var k=sheetObj_surcharge.RowCount; k>0; k--){
					if(sheetObj_surcharge.CellValue(k, 'unique_cd') == sheetObj.CellValue(i, 'trsp_so_seq')){
						sheetObj_surcharge.RowDelete(k, false);
					}
				}
			}

			for(var i=2; i<sheetObj_confirm.RowCount+2; i++){
				sheetObj_confirm.CellValue2(i, 'trsp_inv_act_sts_cd') = '';
				if( sheetObj_confirm.CellValue(i, 'chk1') == 0){
					for(var k=sheetObj_surcharge.RowCount; k>0; k--){
						if(sheetObj_surcharge.CellValue(k, 'unique_cd') == sheetObj.CellValue(i, 'trsp_so_seq')){
							sheetObj_surcharge.RowDelete(k, false);
						}
					}
				} else {
					cgstSum += isNaN(Number(deleteComma(sheetObj_confirm.CellValue(i, 'ida_cgst_amt'))))?0:Number(deleteComma(sheetObj_confirm.CellValue(i, 'ida_cgst_amt')));
					sgstSum += isNaN(Number(deleteComma(sheetObj_confirm.CellValue(i, 'ida_sgst_amt'))))?0:Number(deleteComma(sheetObj_confirm.CellValue(i, 'ida_sgst_amt')));
					igstSum += isNaN(Number(deleteComma(sheetObj_confirm.CellValue(i, 'ida_igst_amt'))))?0:Number(deleteComma(sheetObj_confirm.CellValue(i, 'ida_igst_amt')));
					ugstSum += isNaN(Number(deleteComma(sheetObj_confirm.CellValue(i, 'ida_ugst_amt'))))?0:Number(deleteComma(sheetObj_confirm.CellValue(i, 'ida_ugst_amt')));
				}
			}
			
			if(ida_ofc_cd == 'Y') {
				if(parseFloat(cgstSum) != parseFloat(deleteComma(document.form.inp_ida_cgst_amt.value))) {
					ComShowMessage(ComGetMsg('TRS90724')); //ComShowMessage("CGST AMT and calculated CGST AMT do not match.");
					return false;
				}
				if(parseFloat(sgstSum) != parseFloat(deleteComma(document.form.inp_ida_sgst_amt.value))) {
					ComShowMessage(ComGetMsg('TRS90725')); //ComShowMessage("SGST AMT and calculated SGST AMT do not match.");
					return false;
				}
				if(parseFloat(igstSum) != parseFloat(deleteComma(document.form.inp_ida_igst_amt.value))) {
					ComShowMessage(ComGetMsg('TRS90726')); //ComShowMessage("IGST AMT and calculated IGST AMT do not match.");
					return false;
				}
				if(parseFloat(ugstSum) != parseFloat(deleteComma(document.form.inp_ida_ugst_amt.value))) {
					ComShowMessage(ComGetMsg('TRS90727')); //ComShowMessage("UGST AMT and calculated UGST AMT do not match.");
					return false;
				}
			}

			for(var i=0; i<checkArray.length-1; i++){
				sheetObj_confirm.CellValue2(checkArray[i], 'trsp_inv_act_sts_cd') = 'C';
			}
 
			var auditQuery = sheetObj.GetSaveString(true, true);
//			var confirmQuery = sheetObj_confirm.GetSaveString(true, true);
			var surchargeQuery = sheetObj_surcharge.GetSaveString(true, true);

//			var xml = sheetObj.GetSaveXml('ESD_TRS_0033GS.do', confirmQuery+'&'+surchargeQuery+'&'+TrsFrmQryString(formObj), false);
//			sheetObj.LoadSaveXml(xml);

			sheetObj_confirm.DoAllSave('ESD_TRS_0033GS.do',auditQuery+'&'+surchargeQuery+'&'+TrsFrmQryString(formObj), false);

			//각 금액에 다시 comma를 붙인다.
			calAmt();
			formObj.sum_inv_tot_amt.value = ComAddComma(formObj.sum_inv_tot_amt.value);
			
			break;
	}
}

function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){

	var colName = sheetObj.ColSaveName(sheetObj.MouseCol);
	var formObj = document.form;

	if(colName == 'chk1' && ( sheetObj.MouseRow == 0 ||  sheetObj.MouseRow == 1 )){
		if(sheetObj.CellText(sheetObj.MouseRow,'chk1') == 0){
			setSumOfInvoiceTotalAmountForAllCheck2(sheetObj, document.form);
			setNumOfEQForAllCheck2(sheetObj, document.form);
			if(ida_ofc_cd == 'Y') {
				fn_all_gst_chk_sum(sheetObj, formObj);
			}
		}else if(sheetObj.CellText(sheetObj.MouseRow,'chk1') == 1){
			formObj.cur_sum_inv_audit.value = formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
			formObj.sum_inv_tot_amt_audit.value = setPosition(0);
			formObj.num_eq_20_audit.value = '0';
			formObj.num_eq_40_audit.value = '0';
			formObj.num_eq_tot_audit.value = '0';
			
			if(ida_ofc_cd == 'Y') {
				formObj.ida_cgst_amt_chk_sum.value = '0';
				formObj.ida_sgst_amt_chk_sum.value = '0';
				formObj.ida_igst_amt_chk_sum.value = '0';
				formObj.ida_ugst_amt_chk_sum.value = '0';
			}
		}
	}
}

function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y){

	var colName = sheetObj.ColSaveName(sheetObj.MouseCol);
	var formObj = document.form;

	if(colName == 'chk1' && ( sheetObj.MouseRow == 0 ||  sheetObj.MouseRow == 1 )){
		if(sheetObj.CellText(sheetObj.MouseRow,'chk1') == 0){
			setSumOfInvoiceTotalAmountForAllCheck(sheetObj, document.form);
			setNumOfEQForAllCheck(sheetObj, document.form);
		}else if(sheetObj.CellText(sheetObj.MouseRow,'chk1') == 1){
			formObj.cur_sum_inv.value = formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
			formObj.sum_inv_tot_amt.value = setPosition(0);
			formObj.num_eq_20.value = '0';
			formObj.num_eq_40.value = '0';
			formObj.num_eq_tot.value = '0';
			formObj.bpm_sum_inv_tot_amt.value = setPosition(0);
		}
	}
}

/**
 * Sum of Invoice Total Amount를 계산한다.
 **/
function setSumOfInvoiceTotalAmountForAllCheck(sheetObj, formObj){
	var resultValue = 0;
	var resultValue2 = 0;
	for(var i=2; i<sheetObj.RowCount+2; i++){
		resultValue += isNaN(Number(deleteComma(sheetObj.CellValue(i, 'inv_tot_amt'))))?0:Number(deleteComma(sheetObj.CellValue(i, 'inv_tot_amt')));
		resultValue2 += isNaN(Number(deleteComma(sheetObj.CellValue(i, 'inv_bzc_amt'))))?0:Number(deleteComma(sheetObj.CellValue(i, 'inv_bzc_amt')));
	}
	formObj.cur_sum_inv.value = formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
	
	formObj.sum_inv_tot_amt.value = setPosition(resultValue);

	formObj.sum_inv_tot_amt.value = ComAddComma(formObj.sum_inv_tot_amt.value);
	
	formObj.bpm_sum_inv_tot_amt.value = setPosition(resultValue2);
	  
}

/**
 * Sum of Invoice Total Amount를 계산한다.
 **/
function setSumOfInvoiceTotalAmountForAllCheck2(sheetObj, formObj){
	var resultValue = 0;
	for(var i=2; i<sheetObj.RowCount+2; i++){
		resultValue += isNaN(Number(deleteComma(sheetObj.CellValue(i, 'inv_tot_amt'))))?0:Number(deleteComma(sheetObj.CellValue(i, 'inv_tot_amt')));
	}
	formObj.cur_sum_inv_audit.value = formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
	
	formObj.sum_inv_tot_amt_audit.value = setPosition(resultValue);
	
	formObj.sum_inv_tot_amt_audit.value = ComAddComma(formObj.sum_inv_tot_amt_audit.value);
	
}

/**
 * Number of EQ를 계산한다.
 **/
function setNumOfEQForAllCheck(sheetObj, formObj){
	var cnt_20 = 0;
	var cnt_40 = 0;
	var tp_cd = '';
	var tp_size = '';
	var resultValue = 0;
	for(var i=2; i<sheetObj.RowCount+2; i++){
		if(sheetObj.CellValue(i, 'eq_knd_cd')=='U'){

			tp_cd = sheetObj.CellValue(i, 'eq_tpsz_cd');
			if(tp_cd.length == 2) tp_size = tp_cd.substr(1,2);
			else continue;

			if(tp_size == '2') cnt_20++;
			else cnt_40++;
		}
	}

	formObj.num_eq_20.value = cnt_20;
	formObj.num_eq_40.value = cnt_40;
	formObj.num_eq_tot.value = sheetObj.RowCount;
}

/**
 * Number of EQ를 계산한다.
 **/
function setNumOfEQForAllCheck2(sheetObj, formObj){
	var cnt_20 = 0;
	var cnt_40 = 0;
	var tp_cd = '';
	var tp_size = '';
	var resultValue = 0;
	for(var i=2; i<sheetObj.RowCount+2; i++){
		if(sheetObj.CellValue(i, 'eq_knd_cd')=='U'){

			tp_cd = sheetObj.CellValue(i, 'eq_tpsz_cd');
			if(tp_cd.length == 2) tp_size = tp_cd.substr(1,2);
			else continue;

			if(tp_size == '2') cnt_20++;
			else cnt_40++;
		}
	}

	formObj.num_eq_20_audit.value = cnt_20;
	formObj.num_eq_40_audit.value = cnt_40;
	formObj.num_eq_tot_audit.value = sheetObj.RowCount;
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
		formObj.f_cmd.value = '';
	}else{
		/* 로그인한 사용자의 OFFICE CD에 해당되는 CURRENCY로 설정한다. */
		if(formObj.f_cmd.value == SEARCH12){
			var bil_curr_cd = sheetObj.EtcData('bil_curr_cd');
			var cnt_cd = sheetObj.EtcData('cnt_cd');
			var selectObj = formObj.apply_currency;
			for(var i=0; i<selectObj.length; i++){
				if( selectObj.options[i].value == bil_curr_cd){
					selectObj.options[i].selected = true;
					selectedIdx = i;
					break;
				}
			}
			if("IN" != cnt_cd) document.form.sbc_amt.readOnly = true;
			formObj.f_cmd.value = '';
		}else if(formObj.f_cmd.value == SEARCH15){
			setSumOfInvoiceTotalAmount2(sheetObj, formObj);
			setNumOfEQ2(sheetObj, formObj);
			formObj.f_cmd.value = '';
		}else if(formObj.f_cmd.value == SEARCH16){
			ComShowCodeMessage('COM12116', 'Verify');
			formObj.f_cmd.value = '';
		}else if( formObj.f_cmd.value == SEARCH01||formObj.f_cmd.value == SEARCH06){
			var scgXml = sheetObj.EtcData("scgXml");
			if( scgXml == undefined || ComTrim(scgXml) == ''){
				return;
			}
			scgXml = scgXml.replace(new RegExp("<TD>","gi"),'<TD><![CDATA[');
			scgXml = scgXml.replace(new RegExp("</TD>","gi"),']]></TD>');
			sheetObjects[3].LoadSearchXml(scgXml,true);
			sheetObj.RemoveEtcData();
			
			for(var i=2; i<sheetObj.RowCount+2; i++){
				sheetObj.CellValue2(i,'ida_pay_tp_cd') = 'S';
			}
			
		}	
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
		formObj.f_cmd.value = '';
	}else{
		/* 로그인한 사용자의 OFFICE CD에 해당되는 CURRENCY로 설정한다. */
		if( formObj.f_cmd.value == SEARCH01||formObj.f_cmd.value == SEARCH06){
			var scgXml = sheetObj.EtcData("scgXml");
			if( scgXml == undefined || ComTrim(scgXml) == ''){
				return;
			}
			scgXml = '<?xml version="1.0"  ?>'+scgXml;			
			scgXml = scgXml.replace(new RegExp("<TD>","gi"),'<TD><![CDATA[');
			scgXml = scgXml.replace(new RegExp("</TD>","gi"),']]></TD>');
			
			sheetObjects[3].LoadSearchXml(scgXml,true);
			sheetObj.RemoveEtcData();
			
		}	
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	
	var formObj = document.form;
	
	if(!diff_check(sheetObj)) {
		return;
	}
	
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == MULTI01){
			ComShowCodeMessage('TRS90057');
		}
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	
	var formObj = document.form;
	
	if(!diff_check(sheetObj)) {
		return;
	}

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == MULTI02){
			ComShowCodeMessage('TRS90056');
			setDisabled('CONFIRM');
		}else if(formObj.f_cmd.value == MULTI01){
			ComShowCodeMessage('TRS90057');
		}
	}
	
	if('modify'==formObj.mode_param.value){   //invoice inquery 화면에서 팝업으로 호출될 때 mode=modify 이며 confirm 시 팝업확인 후 Inv Creation Office code 변경한다.
		if(window.opener){
			opener.closeRetrieveOpener();
			self.close();
		}
	}
}

function diff_check(sheetObj){
	
	var bzc_diff = sheetObj.EtcData('bzc_diff');
	var etc_diff = sheetObj.EtcData('etc_diff');
	var nego_diff = sheetObj.EtcData('nego_diff');
	var scg_diff = sheetObj.EtcData('scg_diff');
	var scg_vat_diff = sheetObj.EtcData('scg_vat_diff');
	
	if(bzc_diff == "DIFF"){
		ComShowCodeMessage('TRS90505');
		sheetObj.RemoveEtcData();
		return false;
	}else if(etc_diff == "DIFF"){
		ComShowCodeMessage('TRS90506');
		sheetObj.RemoveEtcData();
		return false;
	}else if(nego_diff == "DIFF"){
		ComShowCodeMessage('TRS90507');
		sheetObj.RemoveEtcData();
		return false;
	}else if(scg_diff == "DIFF"){
		ComShowCodeMessage('TRS90508');
		sheetObj.RemoveEtcData();
		return false;
	}else if(scg_vat_diff == "DIFF"){
		ComShowCodeMessage('TRS90509');
		sheetObj.RemoveEtcData();
		return false;
	}
	return true;
}
// Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSEARCH:      //조회
			break;

		case IBSAVE:        //저장
			break;

	   case IBINSERT:
			break;

	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {

	 switch(tabNo) {
		 case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++ , "Auditing Object" , -1 );
				InsertTab( cnt++ , "      Confirm      " , -1 );
				//InsertTab( cnt++ , "      For NIS      " , -1 );
			}
		 break;
	 }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;

	beforetab= nItem;
}


/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function Minimize(nItem)
{

	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";

		sheetObjects[0].style.height = sheetObjects[1].GetSheetHeight(20);
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(20);
		sheetObjects[4].style.height = sheetObjects[4].GetSheetHeight(20);

	}
	else
	{
		objs.style.display = "inline";

		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(10);
		sheetObjects[4].style.height = sheetObjects[4].GetSheetHeight(10);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */	
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case 'APPLY':
			var inv_no = formObj.invoice_no.value;
			var rv_dt = formObj.recieve_dt.value;
			var is_dt = formObj.issue_dt.value;
			var ps_cd = formObj.paymt_sp_cd.value;
			var ap_cur = formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
			var is_dt_trim = ComTrimAll(ComTrimAll(is_dt, " "), "-");
			var rv_dt_trim = ComTrimAll(ComTrimAll(rv_dt, " "), "-");

			if(inv_no == null || inv_no == ''){
				ComShowCodeMessage('COM12114','Invoice No');
				formObj.invoice_no.focus();
				return false;
				//Issue Date, Recieve Date Validation 추가 2013.11.12 조인영
			}else if(rv_dt == null || rv_dt == '' || !ComIsDate(rv_dt_trim)){
				ComShowCodeMessage('COM12114','Receive DT');
				formObj.recieve_dt.focus();
				return false;
			}else if(is_dt == null || is_dt == '' || !ComIsDate(is_dt_trim)){
				ComShowCodeMessage('COM12114','Issue DT');
				formObj.issue_dt.focus();
				return false;
			}else if(formObj.combo_svc_provider.value == ''){
				ComShowCodeMessage('COM12114','W/O S/P');
				formObj.combo_svc_provider.focus();
				return false;
			}else if(ps_cd == null || ps_cd == ''){
				ComShowCodeMessage('COM12114','Payment S/P');
				formObj.combo_svc_provider.focus();
				return false;
			}else if(ap_cur == null || ap_cur == '' || ap_cur == 'ALL'){
				ComShowCodeMessage('COM12114','Currency');
				return false;
			}
		break;

		case 'SEARCH01':
			if( !apply_flag ){
				ComShowCodeMessage('TRS90080');
				return false;
			}else if(formObj.combo_svc_provider.value == ''){
				ComShowCodeMessage('COM12114','W/O S/P');
				formObj.combo_svc_provider.focus();
				return false;
			}else if(formObj.wo_no.value		== '' &&
				     formObj.booking_no.value	== '' &&
				     formObj.bl_no.value		== '' &&
				     formObj.eq_no_text.value	== '' &&
					 formObj.so_no.value		== ''){
				ComShowCodeMessage('TRS90124');
				formObj.wo_no.focus();
				return false;
			}
			//W/O No Validation 추가 2013.11.13 조인영
			if(formObj.wo_no.value	!= "" ){
				if ( !woNoCheck(formObj.wo_no.value) ){
					formObj.wo_no.value = "";
					formObj.wo_no.focus();
					return false;
				}
			//S/O No Validation 추가 2013.11.13 조인영
			}else if(formObj.so_no.value	!= "" ){
				if ( !soNoCheck(formObj.so_no.value) ){
					formObj.so_no.value = "";
					formObj.so_no.focus();
					return false;
				}
			}

		break;

		case IBSAVE:
			var sheetObj = sheetObjects[0];
			var sheetObj1 = sheetObjects[0];
			var sheetObj2 = sheetObjects[1];
			var surcharge_sheetObj = sheetObjects[3];
			
			//Issue Date validate 추가 2012.03.13 kbj
			if(!ComIsDate(formObj.issue_dt.value)){
				ComShowCodeMessage('TRS90415');
				formObj.issue_dt.value = '';
				formObj.issue_dt.focus();
				return false;
			}
			//Receive Date validate 추가 2012.03.13 kbj
			if(!ComIsDate(formObj.recieve_dt.value)){
				ComShowCodeMessage('TRS90415');
				formObj.recieve_dt.value = '';
				formObj.recieve_dt.focus();
				return false;
			}

			for(var i=sheetObj1.HeaderRows; i<sheetObj1.RowCount+sheetObj1.HeaderRows; i++){
				if( !checkValidInvoiceOfficeCd(sheetObj1.CellValue(i, 'cre_ofc_cd'))) {
					return false;
				}else if(sheetObj.CellValue(i, 'inv_etc_add_amt') != '' ||
							Number(sheetObj.CellValue(i, 'inv_etc_add_amt')) != 0 ) {
						var unique_cd = sheetObj.CellValue(i, 'surcharge_key');
					var sum = 0;
					for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
					{
						if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd)
							sum += Number(surcharge_sheetObj.CellValue(a, prefix+'inv_scg_amt'));
					}
					if(sum != Number(deleteComma(sheetObj.CellValue(i, 'inv_etc_add_amt')))){
						ComShowCodeMessage('COM12114', 'Invoice Additional Etc Amount'
						+' (S/O No:'+sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd')
						+sheetObj.CellValue(i, 'trsp_so_seq')
						+')'	
						);
						sheetObj.CellValue(i, 'inv_etc_add_amt') = 0;
						
						var scg_amt = '';
						var cnt = 0;
						for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
						{
							if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd){
								scg_amt = Number(surcharge_sheetObj.CellValue(a, prefix+'inv_scg_amt'));
								if(scg_amt == 0) {
									surcharge_sheetObj.RowDelete(a, false);
								}else{
									cnt++;
									surcharge_sheetObj.CellValue2(a, prefix+'inv_scg_amt') = '';
								}
							}
						}
						if (cnt == 0) sheetObj.CellValue(i, 'n3pty_bil_flg')='';

						setSumOfInvoiceTotalAmount2(sheetObj, formObj);
						setNumOfEQ2(sheetObj, formObj);
						return false;
					}
				}
				/*
				if( formObj.apply_currency.value != sheetObj.CellValue(i, 'inv_curr_cd') 
					&& sheetObj.CellValue(i, 'inv_curr_cd') != '' ){
					ComShowCodeMessage('TRS90396');
					return false;
				}*/
			}

			for(var i=sheetObj2.HeaderRows; i<	sheetObj2.RowCount+sheetObj2.HeaderRows; i++){
				if( !checkValidInvoiceOfficeCd(sheetObj2.CellValue(i, 'cre_ofc_cd'))) {
					return false;
				}
			}
		break;

		case 'CONFIRM':
			var sheetObj = sheetObjects[0];
			var sheetObj1 = sheetObjects[0];
			var sheetObj2 = sheetObjects[1];
			var surcharge_sheetObj = sheetObjects[3];
			
			//Issue Date, Recieve Date Validation 추가 2013.11.12 조인영
			if(!ComIsDate(formObj.issue_dt.value)){
				ComShowCodeMessage('TRS90415');
				formObj.issue_dt.value = '';
				formObj.issue_dt.focus();
				return false;
			}
			if(!ComIsDate(formObj.recieve_dt.value)){
				ComShowCodeMessage('TRS90415');
				formObj.recieve_dt.value = '';
				formObj.recieve_dt.focus();
				return false;
			}
			for(var i=sheetObj1.HeaderRows; i<	sheetObj1.RowCount+sheetObj1.HeaderRows; i++){
				if( !checkValidInvoiceOfficeCd(sheetObj1.CellValue(i, 'cre_ofc_cd'))) {
					return false;
				}else if(sheetObj.CellValue(i, 'inv_etc_add_amt') != '' ||
							Number(sheetObj.CellValue(i, 'inv_etc_add_amt')) != 0 ) {
						var unique_cd = sheetObj.CellValue(i, 'surcharge_key');
					var sum = 0;
					for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
					{
						if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd)
							sum += Number(surcharge_sheetObj.CellValue(a, prefix+'inv_scg_amt'));
					}
					if(sum != Number(deleteComma(sheetObj.CellValue(i, 'inv_etc_add_amt')))){
						ComShowCodeMessage('COM12114', 'Invoice Additional Etc Amount'
						+' (S/O No:'+sheetObj.CellValue(i, 'trsp_so_ofc_cty_cd')
						+sheetObj.CellValue(i, 'trsp_so_seq')
						+')'	
						);
						sheetObj.CellValue(i, 'inv_etc_add_amt') = 0;
						
						var scg_amt = '';
						var cnt = 0;
						for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
						{
							if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd){
								scg_amt = Number(surcharge_sheetObj.CellValue(a, prefix+'inv_scg_amt'));
								if(scg_amt == 0) {
									surcharge_sheetObj.RowDelete(a, false);
								}else{
									cnt++;
									surcharge_sheetObj.CellValue2(a, prefix+'inv_scg_amt') = '';
								}
							}
						}
						if (cnt == 0) sheetObj.CellValue(i, 'n3pty_bil_flg')='';

						setSumOfInvoiceTotalAmount2(sheetObj, formObj);
						setNumOfEQ2(sheetObj, formObj);
						return false;
					}
				}
			}

			for(var i=sheetObj2.HeaderRows; i<	sheetObj2.RowCount+sheetObj2.HeaderRows; i++){
				if( !checkValidInvoiceOfficeCd(sheetObj2.CellValue(i, 'cre_ofc_cd'))) {
					return false;
				}
			}
		break;
	}
	return true;
}


/**
 * rep_commodity팝업호출
 */
function rep_Multiful_inquiry(btn_obj)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getTRS_ENS_906";
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, x1) {
	
	if(x1 == 'btns_eq_no'){
		var obj = eval('document.form.'+x1.substring(x1.indexOf('btns_')+5)+'_text');
	}else{
		var obj = eval('document.form.'+x1.substring(x1.indexOf('btns_')+5));
	}	
	obj.value = rowArray;
	if(obj.name == 'eq_no_text') {
		checkDigit(obj);
	}
}



/**** WO SP에 대한 PAYMENT SP를 찾는다. ****/
function searchPaymentSP(sheetObj, formObj, wo_sp_value) {

	formObj.f_cmd.value = SEARCH02;
	var query = TrsFrmQryString(formObj);
	sheetObj.RemoveEtcData();
	sheetObj.DoSearch4Post("ESD_TRS_0033GS.do", query);
	var prnt_vndr_seq = sheetObj.EtcData('prnt_vndr_seq');
	var prnt_vndr_nm = sheetObj.EtcData('prnt_vndr_nm');
	var comboObj = document.paymt_sp_combo;
	comboObj.RemoveAll();
	comboObj.InsertItem(-1, formObj.combo_svc_provider.value, formObj.svc_provider.value);

	if(prnt_vndr_seq == null || prnt_vndr_seq == ''){
		ComShowCodeMessage('TRS90065');
		formObj.combo_svc_provider.focus();
	}else if(lpad(prnt_vndr_seq, 6,'0') !=  lpad(wo_sp_value,6,'0')) {
		comboObj.InsertItem(-1, lpad(prnt_vndr_seq, 6, '0'), prnt_vndr_nm);
	}

	
	comboObj.Index2 = 0;
	formObj.paymt_sp_cd.value = comboObj.Text;
	formObj.paymt_sp_nm.value = comboObj.Code;
	
	if(ida_ofc_cd == 'Y') {
		var ida_gst_rgst_sts_cd           = sheetObj.EtcData('ida_gst_rgst_sts_cd');
		var ida_gst_rgst_no               = sheetObj.EtcData('ida_gst_rgst_no');
		var ida_ste_cd                    = sheetObj.EtcData('ida_ste_cd');
		var ida_ste_nm                    = sheetObj.EtcData('ida_ste_nm');
		
		formObj.ida_gst_rgst_sts_cd.value = fn_ida_gst_rgst_name(ida_gst_rgst_sts_cd);
		formObj.ida_gst_rgst_no.value     = ida_gst_rgst_no;
		formObj.ida_ste_cd.value          = ida_ste_cd;
		formObj.ida_ste_nm.value          = ida_ste_nm;
		
		g_ida_gst_rgst_sts_cd             = sheetObj.EtcData('ida_gst_rgst_sts_cd');
		g_ida_gst_rgst_no                 = sheetObj.EtcData('ida_gst_rgst_no');
		g_ida_ste_cd                      = sheetObj.EtcData('ida_ste_cd');
		g_ida_ste_nm                      = sheetObj.EtcData('ida_ste_nm');
		
		g_prnt_vndr_seq                   = sheetObj.EtcData('prnt_vndr_seq');
		g_prnt_ida_gst_rgst_sts_cd        = sheetObj.EtcData('prnt_ida_gst_rgst_sts_cd');
		g_prnt_ida_gst_rgst_no            = sheetObj.EtcData('prnt_ida_gst_rgst_no');
		g_prnt_ida_ste_cd                 = sheetObj.EtcData('prnt_ida_ste_cd');
		g_prnt_ida_ste_nm                 = sheetObj.EtcData('prnt_ida_ste_nm');
	}

	formObj.inv_amt.focus();
}


function paymt_sp_combo_OnChange(comboObj, index_code, text){

	var formObj = document.form;
	formObj.paymt_sp_cd.value = comboObj.Text;
	formObj.paymt_sp_nm.value = comboObj.Code;
	
	if(ida_ofc_cd == 'Y') {
		if (g_prnt_vndr_seq == comboObj.Text) {
			formObj.ida_gst_rgst_sts_cd.value = fn_ida_gst_rgst_name(g_prnt_ida_gst_rgst_sts_cd);
			formObj.ida_gst_rgst_no.value     = g_prnt_ida_gst_rgst_no;
			formObj.ida_ste_cd.value          = g_prnt_ida_ste_cd;
			formObj.ida_ste_nm.value          = g_prnt_ida_ste_nm;		
		} else {
			formObj.ida_gst_rgst_sts_cd.value = fn_ida_gst_rgst_name(g_ida_gst_rgst_sts_cd);
			formObj.ida_gst_rgst_no.value     = g_ida_gst_rgst_no;
			formObj.ida_ste_cd.value          = g_ida_ste_cd;
			formObj.ida_ste_nm.value          = g_ida_ste_nm;
		}
	}
}

/**
 * cntr mvnt button validation check
 * 
 * @param sheetObj selected sheet
 */
function validCntrMvmt(sheetObj) {
	var checkArray = sheetObj.FindCheckedRow('chk1').split('|');
	
	if(sheetObj.FindCheckedRow('chk1') == '') {
		ComShowMessage(ComGetMsg('TRS90036'));
		return false;
	}

	if(checkArray.length-1 > 1) {
		ComShowMessage(ComGetMsg("COM12113", 'only one row'));
		return false;
	}
	
	var cntrNo = sheetObj.CellValue(checkArray[0], 'eq_no');
	
	// EQ NO
	if(cntrNo == ''){
        ComShowMessage(ComGetMsg("TRS90389"));
		return false;
	}

	// W/O No
	if(sheetObj.CellValue(checkArray[0], 'trsp_wo_ofc_cty_cd_seq') == ''){
		ComShowMessage(ComGetMsg("TRS90388", "W/O No"));
		return false;
	}
	
	return true;
}

/**
 * W/O PreView
 * 
 * @param sheetObj selected sheet
 */
function woPreview(sheetObj) {
	var chkRows = sheetObj.FindCheckedRow("chk1");
	var trsp_wo_ofc_cty_cd = "";
	var trsp_wo_seq = "";
	var emptyData = "";
	
	if ( chkRows == "") {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	
	var arrRow = chkRows.split("|");
	
	for(var idx=0; idx<arrRow.length-1; idx++) {
		if ( sheetObj.CellValue( arrRow[idx], "hjl_no" ) == "Y") {
			ComShowMessage(ComGetMsg("TRS90368"));
			return false;
		}
		if ( sheetObj.CellValue( arrRow[idx], "wo_no" ) == "") {
			ComShowMessage(ComGetMsg("TRS90377"));
			return false;
		}
		trsp_wo_ofc_cty_cd += sheetObj.CellValue(arrRow[idx], "trsp_wo_ofc_cty_cd" ) + ",";
		trsp_wo_seq += sheetObj.CellValue(arrRow[idx], "trsp_wo_seq" ) + ",";
		emptyData += ",";
	}

	trsp_wo_ofc_cty_cd = trsp_wo_ofc_cty_cd.substring(0, trsp_wo_ofc_cty_cd.length-1);
	trsp_wo_seq = trsp_wo_seq.substring(0, trsp_wo_seq.length-1);

	var wo_cancel_flag = '';
	var detain = '';
	var bno_issue = '';
	var eq_mode = 'IS';
	
	var param = "?trsp_wo_ofc_cty_cd="+trsp_wo_ofc_cty_cd+"&trsp_wo_seq="+trsp_wo_seq+"&wo_cancel_flag="+wo_cancel_flag+"&detain="+detain+"&eq_mode="+eq_mode+"&bno_issue="+bno_issue+"&isInquiry=Y"+"&pgmNo=ESD_TRS_0024";
	window.open('ESD_TRS_0024.do'+param, 'OpneHistoryWin', "scroll:no,status:no,help:no,width=1000,Height=800");
}

/**
 * rep_commodity팝업호출
 */
function rep_OnPopupClick()
{

	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_rep";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');

}


/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	
	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		
		if(ida_ofc_cd == 'Y') {
			var colArray4                     = colArray[10];
			var ida_gst_rgst_val              = "";
			ida_gst_rgst_val                  = fn_ida_gst_rgst_name (colArray4);
			formObj.ida_gst_rgst_sts_cd.value = ida_gst_rgst_val;
			var colArray5                     = colArray[11];
			formObj.ida_gst_rgst_no.value     = colArray5;
			var colArray6                     = colArray[12];
			formObj.ida_ste_cd.value          = colArray6;
			var colArray7                     = colArray[13];
			formObj.ida_ste_nm.value          = colArray7;
		}
		
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
	searchPaymentSP(sheetObjects[1],formObj,formObj.combo_svc_provider.value);
}

/**** AMOUNT를 계산한다. ****/
function calAmt(){
	var formObj = document.form;
    /*
	formObj.inv_amt.value =  setPosition(formObj.inv_amt.value);
	formObj.vat_amt.value =  setPosition(formObj.vat_amt.value);
	formObj.wht_amt.value =  setPosition(formObj.wht_amt.value);

	formObj.tot_amt.value = setPosition(Number(formObj.inv_amt.value) 
								+ Number(formObj.vat_amt.value)
								- Number(formObj.wht_amt.value));
								
  */								
  var inv_amt = deleteComma(formObj.inv_amt.value);
  var vat_amt = deleteComma(formObj.vat_amt.value);
  var wht_amt = deleteComma(formObj.wht_amt.value);
  var sbc_amt = deleteComma(formObj.sbc_amt.value);

  var tot_amt = Number(inv_amt) + Number(vat_amt) + Number(sbc_amt) - Number(wht_amt);
  
  var calc_ida_cgst_amt = deleteComma(formObj.inp_ida_cgst_amt.value);
  var calc_ida_sgst_amt = deleteComma(formObj.inp_ida_sgst_amt.value);
  var calc_ida_igst_amt = deleteComma(formObj.inp_ida_igst_amt.value);
  var calc_ida_ugst_amt = deleteComma(formObj.inp_ida_ugst_amt.value);  

  formObj.inv_amt.value = setPosition(inv_amt);
  formObj.vat_amt.value = setPosition(vat_amt);
  formObj.wht_amt.value = setPosition(wht_amt);
  formObj.sbc_amt.value = setPosition(sbc_amt);
  formObj.tot_amt.value = setPosition(tot_amt);
  
  
  formObj.inv_amt.value = ComAddComma(formObj.inv_amt.value);
  formObj.vat_amt.value = ComAddComma(formObj.vat_amt.value);
  formObj.wht_amt.value = ComAddComma(formObj.wht_amt.value);
  formObj.sbc_amt.value = ComAddComma(formObj.sbc_amt.value);
  
  formObj.tot_amt.value = ComAddComma(formObj.tot_amt.value);
  
  formObj.inp_ida_cgst_amt.value = ComAddComma(setPosition(formObj.inp_ida_cgst_amt.value));
  formObj.inp_ida_sgst_amt.value = ComAddComma(setPosition(formObj.inp_ida_sgst_amt.value));
  formObj.inp_ida_igst_amt.value = ComAddComma(setPosition(formObj.inp_ida_igst_amt.value));
  formObj.inp_ida_ugst_amt.value = ComAddComma(setPosition(formObj.inp_ida_ugst_amt.value));
  
  if(ida_ofc_cd == 'Y') {
	  fn_vat_mna_input_chk();
  }
					
}


function initAmt(obj) {	
	if(obj.value == '0.00' || obj.value == '0'){
		obj.value = '';
		obj.focus();
		return false;
	}
}
	

/*** 상황에따라 버튼의 사용여부를 disable/enable시킨다  ***/
function setDisabled(mode){
	var formObj = document.form;
	var comboObj = document.paymt_sp_combo;

	switch(mode){
		case 'APPLY':
			formObj.invoice_no.disabled = true;
			formObj.combo_svc_provider.disabled = true;
			formObj.apply_currency.disabled = true;
			formObj.ap_reverse_change_flg.disabled = false;
			apply_flag = true;
			comboObj.Enable = false;
			break;

		case 'RESET':
			formObj.invoice_no.disabled = false;
			formObj.combo_svc_provider.disabled = false;
			formObj.apply_currency.disabled = false;
			formObj.recieve_dt.disabled = false;
			formObj.issue_dt.disabled = false;
			formObj.inv_amt.disabled = false;
			formObj.vat_amt.disabled = false;
			formObj.wht_amt.disabled = false;
			formObj.sbc_amt.disabled = false;
			formObj.ap_reverse_change_flg.disabled = false;

			formObj.wo_no.disabled = false;
			formObj.booking_no.disabled = false;
			formObj.bl_no.disabled = false;
			formObj.eq_no_text.disabled = false;

			formObj.eq_no_rdo[0].disabled = false;
			formObj.eq_no_rdo[1].disabled = false;
			formObj.eq_no_rdo[2].disabled = false;
			sheetObjects[0].Editable = true;
			sheetObjects[1].Editable = true;
			comboObj.Enable = true;
			apply_flag = false;
			
			formObj.inp_ida_cgst_amt.disabled = false;
			formObj.inp_ida_sgst_amt.disabled = false;
			formObj.inp_ida_igst_amt.disabled = false;
			formObj.inp_ida_ugst_amt.disabled = false;
			break;

		case 'SEARCH_MODE':
			formObj.invoice_no.disabled = true;
			formObj.recieve_dt.disabled = true;
			formObj.issue_dt.disabled = true;
			formObj.combo_svc_provider.disabled = true;
			formObj.apply_currency.disabled = true;
			formObj.inv_amt.disabled = true;
			formObj.vat_amt.disabled = true;
			formObj.wht_amt.disabled = true;
			formObj.sbc_amt.disabled = true;
			formObj.ap_reverse_change_flg.disabled = true;

			formObj.wo_no.disabled = true;
			formObj.booking_no.disabled = true;
			formObj.bl_no.disabled = true;
			formObj.eq_no_text.disabled = true;

			formObj.eq_no_rdo[0].disabled = true;
			formObj.eq_no_rdo[1].disabled = true;
			formObj.eq_no_rdo[2].disabled = true;
			sheetObjects[0].Editable = false;
//			sheetObjects[1].Editable = false;
			comboObj.Enable = false;
			
			formObj.inp_ida_cgst_amt.disabled = true;
			formObj.inp_ida_sgst_amt.disabled = true;
			formObj.inp_ida_igst_amt.disabled = true;
			formObj.inp_ida_ugst_amt.disabled = true;
			break;

		case 'CONFIRM':
			formObj.invoice_no.disabled = true;
			formObj.recieve_dt.disabled = true;
			formObj.issue_dt.disabled = true;
			formObj.combo_svc_provider.disabled = true;
			formObj.apply_currency.disabled = true;
			formObj.inv_amt.disabled = true;
			formObj.vat_amt.disabled = true;
			formObj.wht_amt.disabled = true;
			formObj.sbc_amt.disabled = true;
			formObj.ap_reverse_change_flg.disabled = true;

			formObj.wo_no.disabled = true;
			formObj.booking_no.disabled = true;
			formObj.bl_no.disabled = true;
			formObj.eq_no_text.disabled = true;

			formObj.eq_no_rdo[0].disabled = true;
			formObj.eq_no_rdo[1].disabled = true;
			formObj.eq_no_rdo[2].disabled = true;
			sheetObjects[0].Editable = false;
			sheetObjects[1].Editable = false;
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			confirm_flag = true;
			
			formObj.inp_ida_cgst_amt.disabled = true;
			formObj.inp_ida_sgst_amt.disabled = true;
			formObj.inp_ida_igst_amt.disabled = true;
			formObj.inp_ida_ugst_amt.disabled = true;
			break;
	}
}

/**** 유효한 invoice no인지 체크한다. ****/
function checkInvoice(){

	var sheetObj = sheetObjects[2];
	var formObj = document.form;
	if (!validateForm(sheetObj,formObj,'APPLY')) return;

	if(	!getOfcCd() ) return;

	formObj.f_cmd.value = SEARCH03;
	sheetObj.DoSearch4Post("ESD_TRS_0033GS.do", TrsFrmQryString(formObj));
	if(sheetObj.RowCount > 0){ 
		ComShowCodeMessage('TRS90126');
		return false;
	}else {
		setDisabled('APPLY');
		return true;
	}
}

/**** Login Ofc cd가 invoice할수있는 Ofc cd를 가져온다. . ****/
function getOfcCd(){
	var sheetObj = sheetObjects[2];
	var formObj = document.form;

	sheetObj.RemoveEtcData();
	formObj.f_cmd.value = SEARCH10;
	
	var sXml = sheetObj.GetSearchXml("ESD_TRS_0033GS.do", TrsFrmQryString(formObj));
	var ofc_cd = ComGetEtcData(sXml,'ofc_cd');   

	if(ofc_cd == undefined || ofc_cd == ''){
		ComShowCodeMessage('TRS90229');
		return false;
	}else{
		ofc_cd_arr = ofc_cd.split('|');
		return true;
	}

}

/**** 유효한 office_cd인지 체크한다. ****/
function checkValidInvoiceOfficeCd(ofc_cd){
	
	var checkFlg = false;

	for(var i=0; i < ofc_cd_arr.length; i++){
		if(ofc_cd == ofc_cd_arr[i]) {
			checkFlg = true;
			break;
		}
	}

	
	if(!checkFlg) {
		ComShowCodeMessage('TRS90011');
	}
	return checkFlg;
}

/**** header부분을 reset한다. ****/
function resetHeader(sheetObj,sheetObject_confirm, formObj){
	
	if(sheetObjects[0].RowCount>0 &&
		!confirm('There are remaining Auditing Object.\nAre you sure to proceed?')){
		return false;
	}else if(sheetObjects[1].RowCount>0 &&
		!confirm('There are remaining Confirm Data.\nAre you sure to proceed?')){
		return false;
	}

	setDisabled('RESET');
	var comboObj = document.paymt_sp_combo;
	formObj.invoice_no.value = '';
	formObj.recieve_dt.value = today;
	formObj.issue_dt.value = today;
	formObj.combo_svc_provider.value = '';
	formObj.svc_provider.value = '';
	formObj.paymt_sp_cd.value = '';
	formObj.paymt_sp_nm.value = '';
	comboObj.RemoveAll();
	formObj.apply_currency.selectedIndex = selectedIdx;
	formObj.inv_amt.value = '0.00';
	formObj.vat_amt.value = '0.00';
	formObj.wht_amt.value = '0.00';
	formObj.sbc_amt.value = '0.00';
	formObj.tot_amt.value = '0.00';

	resetCondition(sheetObj,sheetObject_confirm, formObj);
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();

	formObj.cur_sum_inv_audit.value = '';
	formObj.sum_inv_tot_amt_audit.value = '';
	formObj.num_eq_20_audit.value = '';
	formObj.num_eq_40_audit.value = '';
	formObj.num_eq_tot_audit.value = '';

	formObj.cur_sum_inv.value = '';
	formObj.sum_inv_tot_amt.value = '';
	formObj.num_eq_20.value = '';
	formObj.num_eq_40.value = '';
	formObj.num_eq_tot.value = '';
	
	formObj.bpm_sum_inv_tot_amt.value = '';


	tabObjects[0].SelectedIndex = 0;
	confirm_flag = false;
	
	formObj.inp_ida_cgst_amt.value = '0.00';
	formObj.inp_ida_sgst_amt.value = '0.00';
	formObj.inp_ida_igst_amt.value = '0.00';
	formObj.inp_ida_ugst_amt.value = '0.00';	
	formObj.inp_hsn_sac.value      = '';	
}

/**** Condition 부분을 reset한다. ****/
function resetCondition(sheetObj,sheetObject_confirm, formObj){
	formObj.wo_no.value = '';
	formObj.booking_no.value = '';
	formObj.bl_no.value = '';
	formObj.eq_no_text.value = '';
	formObj.eq_no_rdo[0].checked = true;
	formObj.so_no.value = '';
}

/**** auditing Object sheet로부터 confirm sheet로 data를 보낸다. ****/
function sendToConfirmTab(){
	
	var sheetObj_auditing = sheetObjects[0];
	var sheetObj_confirm = sheetObjects[1];
	var formObj = document.form;
	var xchFlag = false;

	var checkList = sheetObj_auditing.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');

	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}

	var queryStr = '';
	var colName = '';
	var row = 1;
	var cur = formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;

	for(var k=checkArray.length-2; k>=0; k--){
		row = checkArray[k];

		if(sheetObj_auditing.CellValue(row,'eq_no') == ''){
			ComShowCodeMessage('TRS90312');
			return;
		}

		if(sheetObj_auditing.CellValue(checkArray[0],'curr_cd') != sheetObj_auditing.CellValue(row,'curr_cd')){
			ComShowCodeMessage('TRS90079');
			sheetObj_auditing.SelectCell(row,'curr_cd');
			return;
		}
		
		if(document.form.apply_currency.value != sheetObj_auditing.CellValue(row,'curr_cd') &&
			sheetObj_auditing.CellValue(row,'inv_xch_rt') == '1' ){
			
			if(!xchFlag && !confirm(ComGetMsg('TRS90303'))) {
				return;
			}else{
				xchFlag = true;
			}
		}
		/*
		if( formObj.apply_currency.value != sheetObj_auditing.CellValue(row, 'inv_curr_cd') 
				&& sheetObj_auditing.CellValue(row, 'inv_curr_cd') != '' ){
			ComShowCodeMessage('TRS90396');
			return;
		}
		*/
		sheetObj_auditing.CellValue2(row,'spcl_instr_rmk') = toHtml(sheetObj_auditing.CellValue(row,'spcl_instr_rmk'));
		sheetObj_auditing.CellValue2(row,'inter_rmk') = toHtml(sheetObj_auditing.CellValue(row,'inter_rmk'));
		sheetObj_auditing.CellValue2(row,'inv_rmk') = toHtml(sheetObj_auditing.CellValue(row,'inv_rmk'));
		sheetObj_auditing.CellValue2(row,'sp_inv_rmk') = toHtml(sheetObj_auditing.CellValue(row,'sp_inv_rmk'));
	}

	queryStr = sheetObj_auditing.GetSaveString(false, true, "chk1");

	sheetObj_confirm.DoSearch4Post("ESD_TRS_0969.screen", queryStr, '', true);

	for(var k=checkArray.length-2; k>=0; k--){
		sheetObj_auditing.RowDelete(checkArray[k], false);
	}
	
	setSumOfInvoiceTotalAmount(sheetObj_confirm, formObj);
	setNumOfEQ(sheetObj_confirm, formObj);

	setSumOfInvoiceTotalAmount2(sheetObj_auditing, formObj);
	setNumOfEQ2(sheetObj_auditing, formObj);
	fn_gst_chk_sum(sheetObj_auditing, formObj);
}

/**** confirm sheet로부터 auditing Object sheet로 data를 보낸다. ****/
function sendToAuditTab(){
	
	var sheetObj_auditing = sheetObjects[0];
	var sheetObj_confirm = sheetObjects[1];
	var formObj = document.form;

	var checkList = sheetObj_confirm.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');

	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}

	var queryStr = '';
	var colName = '';
	var row = 1;

	queryStr = sheetObj_confirm.GetSaveString(false, true, "chk1");

	sheetObj_auditing.DoSearch4Post("ESD_TRS_0969.screen", queryStr, '', true);
	
	for(var k=checkArray.length-2; k>=0; k--){
		sheetObj_confirm.RowDelete(checkArray[k], false);
	}
	
	setSumOfInvoiceTotalAmount(sheetObj_confirm, formObj);
	setNumOfEQ(sheetObj_confirm, formObj);

	setSumOfInvoiceTotalAmount2(sheetObj_auditing, formObj);
	setNumOfEQ2(sheetObj_auditing, formObj);
	
	setCurrChange();
	fn_gst_chk_sum(sheetObj_auditing, formObj);
	
}

/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry_CalLogic(sheetObj, row, col, mode, step_cd)
{
	var myOption = "width=1070,height=820,menubar=0,status=0,scrollbars=1,resizable=0";
	var url = 'ESD_TRS_0918.screen';
	url += '?unique_cd='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&open_mode='+mode;
	url += '&step_cd='+step_cd;
	url += '&main_row='+row;
	url += '&sheet_arr_no=3';
	url += '&ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&rate'+sheetObj.CellValue(row, 'inv_xch_rt');
	url += '&cal_logic'+sheetObj.CellValue(row, 'trsp_inv_calc_lgc_tp_cd');
	url += '&curr_cd='+sheetObj.CellValue(row, 'curr_cd');
	url += '&cgo_tp_cd='+ sheetObj.CellValue(row, 'cgo_tp_cd');
	myWin = window.open(url, "popSurchargeInputInquiry", myOption);
	myWin.focus();
}

/**
 * Surcharge Input Inquiry popup
 **/
function popSurchargeInputInquiry(sheetObj, row, col, mode, step_cd)
{
	var checkList = null;
	var checkArray = null;

	if(mode == 'multiple'){
		checkList = sheetObj.FindCheckedRow('chk1');
		checkArray = checkList.split('|');
		if( checkArray == '') {
			ComShowCodeMessage('TRS90036');
			return;
		}else{
			row = checkArray[0];
		}
	}
	
	var formObj = document.scgForm;
	var myOption = "width=1070,height=820,menubar=0,status=0,scrollbars=0,resizable=0";

	var myWin = window.open('', "popSurchargeInputInquiry", myOption);
	myWin.focus();


	
	formObj.unique_cd.value			= sheetObj.CellValue(row, 'trsp_so_seq');
	formObj.open_mode.value			= mode;
	formObj.step_cd.value			= step_cd;
	formObj.main_row.value			= row;
	formObj.sheet_arr_no.value		= '3';
	formObj.ofc_cty_cd.value		= sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
	formObj.so_seq.value			= sheetObj.CellValue(row, 'trsp_so_seq');
	formObj.curr_cd.value			= document.form.apply_currency.value;
	formObj.cgo_tp_cd.value			= sheetObj.CellValue(row, 'cgo_tp_cd');
	formObj.action					= 'ESD_TRS_0918.screen';
	formObj.target					= 'popSurchargeInputInquiry';

	if(mode == 'multiple'){
		formObj.multi_ofc_cty_cd.value	= getSoOfcCdArray(sheetObj, checkArray);
		formObj.multi_so_seq.value		= getSoSeqArray(sheetObj, checkArray);
		formObj.multi_cgo_tp_cd.value	= getCgoTpCdArray(sheetObj, checkArray);
		formObj.check_row.value			= getRowArray(sheetObj, checkArray);
	}
	formObj.submit();
}

function getSoOfcCdArray(sheetObj, checkArray){

	var returnStr = '';

	for(var i=0; i<checkArray.length-1; i++){
		if(i != 0){
			returnStr += '|';
		}
		returnStr += sheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
	}

	return returnStr;
}

function getSoSeqArray(sheetObj, checkArray){

	var returnStr = '';

	for(var i=0; i<checkArray.length-1; i++){
		if(i != 0){
			returnStr += '|';
		}
		returnStr += sheetObj.CellValue(checkArray[i], 'trsp_so_seq');
	}

	return returnStr;
}

function getCgoTpCdArray(sheetObj, checkArray){

	var returnStr = '';
	var cgo_tp_cd = '';

	for(var i=0; i<checkArray.length-1; i++){
		if(i != 0){
			returnStr += '|';
		}
		cgo_tp_cd = sheetObj.CellValue(checkArray[i], 'cgo_tp_cd');
		if (cgo_tp_cd == 'F') cgo_tp_cd = 'C';
		else cgo_tp_cd = 'M';
		returnStr += cgo_tp_cd
		
	}

	return returnStr;
}

function getRowArray(sheetObj, checkArray){

	var returnStr = '';

	for(var i=0; i<checkArray.length-1; i++){
		if(i != 0){
			returnStr += '|';
		}
		returnStr += checkArray[i];
	}

	return returnStr;
}


/**
 * Container File Imort Popup 을 띄운다.
 **/
function popCntrFileImport(sheetObj, formObj)
{
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');

	if( checkArray == '' || checkArray == null) {
		ComShowCodeMessage('TRS90036');
		return;
	}

	for(var i=0; i<checkArray.length-1; i++){
		if(sheetObj.CellValue(checkArray[i], 'eq_no') != ''){
			ComShowMessage('\"CNTR No Import\" function is only for S/O created without container number');
			return;
		}
	}

var myOption = "dialogWidth:900px; dialogHeight:400px; help:no; status:no; resizable:no; scroll=no; ";
var url = 'ESD_TRS_0957.do';
url += '?wo_vndr_cd='+formObj.combo_svc_provider.value;
url += '&wo_vndr_nm='+formObj.svc_provider.value;
url += '&payment_vndr_cd='+formObj.paymt_sp_cd.value;
url += '&payment_vndr_nm='+formObj.paymt_sp_nm.value;
url += '&invoice_no='+formObj.invoice_no.value;
url += '&apply_currency='+formObj.apply_currency.value;
window.showModalDialog(url, window, myOption);

}

/**
 * Container File Imort에서 verify된 EQ_NO를 SHEET에 import한다.
 **/
function importEqNo(popSheetObj, obj)
{
	var sheetObj = sheetObjects[0];
	var checkList = popSheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	
	var main_checkList = sheetObj.FindCheckedRow('chk1');
	var main_checkArray = main_checkList.split('|');

	// eq_no가 비어있는 row를 array로 담는다.
	var emptyEqArray = new Array();
	var cnt=0;

	for(var k=0; k<main_checkArray.length-1; k++)
	{
		if(sheetObj.CellValue(main_checkArray[k], 'eq_no')==''){
			emptyEqArray[cnt++] = main_checkArray[k];
		}
	}

	for(var k=0; k<emptyEqArray.length; k++)
	{
		for(var m=0; m<checkArray.length-1; m++) {
			if(checkArray[m] != -1 &&
			   sheetObj.CellValue(emptyEqArray[k], 'eq_tpsz_cd') == 
				popSheetObj.CellValue(checkArray[m], 'eq_tpsz_cd') &&
			   sheetObj.CellValue(emptyEqArray[k], 'trsp_wo_ofc_cty_cd_seq') == 
				popSheetObj.CellValue(checkArray[m], 'trsp_wo_ofc_cty_cd')) {
				sheetObj.CellValue2(emptyEqArray[k], 'eq_no') = popSheetObj.CellValue(checkArray[m], 'eq_no');
				sheetObj.CellValue2(emptyEqArray[k], 'chk1') = '1';
				checkArray[m] = -1;
				break;
			}
		}
	}
	//obj.close();
}

/**
 * Container Select Popup 을 띄운다.
 **/
function popContainerSelect(sheetObj,formObj){
	
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');

	if( checkArray == '' || checkArray == null) {
		ComShowCodeMessage('TRS90036');
		return;
	}

	var bkgValue = '';
	var row = 0;
	for(var i=0; i<checkArray.length-1; i++){
		row = checkArray[i];
		if(sheetObj.CellValue(row, 'trsp_bnd_cd') !='O' || sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd') != 'DR') {
			ComShowMessage('1,'+ComGetMsg('TRS90045'));
			sheetObj.SelectCell(row, 'trsp_bnd_cd');
			return false;
		}else if(sheetObj.CellValue(row, 'eq_no').length > 0) {
			ComShowMessage('2,'+ComGetMsg('TRS90045'));
			sheetObj.SelectCell(row, 'eq_no');
			return false;
		}else if(sheetObj.CellValue(row, 'bkg_no') == null || sheetObj.CellValue(row, 'bkg_no') == '' ) {
			ComShowMessage('3,'+ComGetMsg('TRS90045'));
			sheetObj.SelectCell(row, 'bkg_no');
			return false;
		}else if(sheetObj.CellValue(row, 'trsp_frst_flg') == 'Y' && formObj.conti_cd.value != 'E') {
			ComShowMessage('4,'+ComGetMsg('TRS90366'));
			sheetObj.SelectCell(row, 'eq_no');
			return false;													//Frustrated S/O건인 경우 팝업 불가.
		}
	}
	var myOption = "dialogWidth:800px; dialogHeight:522px; help:no; status:no; resizable:no; scroll=no; ";
	var url = 'ESD_TRS_0908.do';
	url += '?mainSheetArrayNo=0';
	window.showModalDialog(url, window, myOption);
	
}

/**
 * Empty repo Select Popup 을 띄운다.
 **/
function popMtySelect(sheetObj,formObj){
	
	var checkList	= sheetObj.FindCheckedRow('chk1');
	var checkArray	= checkList.split('|');
	var row = 0;
	
	if( checkArray == '' || checkArray == null ) {
		ComShowCodeMessage('TRS90036');
		return;
	}
	
	/* 체크리스트 중에 s/o type이 'M' 이 아닌것이 선택 됐을 경우  메세지를 뿌려준다.  */
	 	
	for(var i=0; i<checkArray.length-1; i++){
		row = checkArray[i];
		if(sheetObj.CellValue(row, 'trsp_so_tp_cd') != 'M'){
			ComShowMessage('Not Empty Repo!!');
			sheetObj.SelectCell(row, 'chk1');
			return;
		} 
	}
	
	
	var kgValue = '';
	var row = 0;

	var myOption = "dialogWidth:610px; dialogHeight:522px; help:no; status:no; resizable:no; scroll=no; ";
	var url = 'ESD_TRS_0909.do';
	url += '?mainSheetArrayNo=0';
	window.showModalDialog(url, window, myOption);
}


/**
 * Invoice File Import Popup 을 띄운다.
 **/
function popInvoiceFileImport(sheetObj,formObj){

	var myOption = "width=800,height=630,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0922.screen';
	url += '?wo_vndr_cd='+formObj.combo_svc_provider.value;
	url += '&wo_vndr_nm='+formObj.svc_provider.value;
	url += '&payment_vndr_cd='+formObj.paymt_sp_cd.value;
	url += '&payment_vndr_nm='+formObj.paymt_sp_nm.value;
	url += '&invoice_no='+formObj.invoice_no.value;
	url += '&apply_currency='+formObj.apply_currency.value;
//	myWin = window.open(url, "invoiceFileImport", myOption);
    ComOpenWindow(url, 'invoiceFileImport', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:800px;dialogHeight:665px', true);
}

/**
 * 중복 so를 삭제한다.
 **/
function removeDupSoNo(auditSheetObj, beforeRow, afterRow, beforeScgRow, afterScgRow){
	
	var confirmSheetObj = sheetObjects[1];
	var surchargeSheetObj = sheetObjects[3];

	var findIndex = 0;
	var srcData = null;
	var tgtData = null;
	var findFlag = false;

	for(var i=beforeRow;i< afterRow; i++){
		srcData = auditSheetObj.CellValue(i+2, 'trsp_so_ofc_cty_cd_seq');
		findFlag = false;
		for(var t=2;t< beforeRow+2;t++){
			tgtData = auditSheetObj.CellValue(t, 'trsp_so_ofc_cty_cd_seq');
			if(srcData == tgtData){
				auditSheetObj.RowStatus(i+2) = 'D';
				findFlag = true;
				break;
			}
		}
		for(var t=2; t< confirmSheetObj.RowCount+2;t++){
			tgtData = confirmSheetObj.CellValue(t, 'trsp_so_ofc_cty_cd_seq');
			if(srcData == tgtData){
				auditSheetObj.RowStatus(i+2) = 'D';
				findFlag = true;
				break;
			}
		}

		if(findFlag){			
			for(var t=beforeScgRow+1; t< afterScgRow+1; t++){
				tgtData = ComTrim(surchargeSheetObj.CellValue(t, 'surcharge_trsp_so_ofc_cty_cd')+surchargeSheetObj.CellValue(t, 'surcharge_trsp_so_seq'));
				if(srcData == tgtData){
					surchargeSheetObj.RowStatus(t) = 'D';
				}
			}
		}
	}

	for(var k = Number(auditSheetObj.RowCount)+2; k>beforeRow+1 ;k--){
		if( auditSheetObj.RowStatus(k) == 'D') auditSheetObj.RowDelete(k, false);
	}

	for(var k = Number(confirmSheetObj.RowCount)+2; k>2 ;k--){
		if( confirmSheetObj.RowStatus(k) == 'D') confirmSheetObj.RowDelete(k, false);
	}
	
	for(var k = Number(surchargeSheetObj.RowCount)+1; k>1 ;k--){
		if( surchargeSheetObj.RowStatus(k) == 'D') surchargeSheetObj.RowDelete(k, false);
	}
}

/**
 * Currency Change Popup 을 띄운다.
 **/
function popCurrencyChange(sheetObj,formObj){

	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	var wo_cur = formObj.apply_currency.value;
	var wo_totamount = 0;

	if( checkArray == '' || checkArray == null) {
		ComShowCodeMessage('TRS90036');
		return;
	}

	for(var i=0; i<checkArray.length-1; i++){
		if(sheetObj.CellValue(checkArray[0], 'curr_cd') != sheetObj.CellValue(checkArray[i], 'curr_cd')){
			ComShowCodeMessage('TRS90048');
			sheetObj.SelectCell(checkArray[i], 'curr_cd');
			return;
		}
		
		wo_totamount += Number(sheetObj.CellValue(checkArray[i], 'wo_tot_amt'));
	}

	var myOption = "width=700,height=250,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0910.screen';
	url += '?wo_currency='+sheetObj.CellValue(checkArray[0], 'curr_cd');
	url += '&wo_totamount='+wo_totamount;
	url += '&invoice_currency='+wo_cur;
	myWin = window.open(url, "currencyChange", myOption)
}

/**
 * Currency Change Popup에서 선택된 값을 sheet에 입력한다.
 **/
function setCurrencyChange(iv_curr_value, rate_value, cal_logic_value){
	
	var formObj = document.form;	
	var sheetObj = sheetObjects[0];	
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	if(rate_value > 0){ 
		
		for(var i=0; i<checkArray.length-1; i++){			
			sheetObj.CellValue2(checkArray[i], 'inv_curr_cd') = iv_curr_value;
			sheetObj.CellValue2(checkArray[i], 'inv_xch_rt') = rate_value;
			sheetObj.CellValue2(checkArray[i], 'trsp_inv_calc_lgc_tp_cd') = cal_logic_value;
			calCurrencyChange(checkArray[i], sheetObj);
			
			if(sheetObj.CellValue(checkArray[i], 'inv_curr_cd') == 'JPY' || sheetObj.CellValue(checkArray[i], 'inv_curr_cd') == 'KRW' || sheetObj.CellValue(checkArray[i], 'inv_curr_cd') == 'TWD'){
				setDecimalType_Audit(sheetObj, checkArray[i]);
			}else{
				setFloatingType_Audit(sheetObj, checkArray[i]);
			}
		}
	}
}

/**
 * Currency Change Popup에서 선택된 값을 row별로 계산하여 AMT 값을 변경한다.
 **/
function calCurrencyChange(row, sheetObj){
	var formObj = document.form;
	var url = 'trsp_inv_calc_lgc_tp_cd=' + sheetObj.CellValue(row, 'trsp_inv_calc_lgc_tp_cd');
		url +='&inv_xch_rt=' +  sheetObj.CellValue(row, 'inv_xch_rt');
		url +='&trsp_so_ofc_cty_cd=' +  sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
		url +='&trsp_so_seq=' +  sheetObj.CellValue(row, 'trsp_so_seq');
	formObj.f_cmd.value = SEARCH13;
	sheetObj.RemoveEtcData();
	sheetObj.DoSearch4Post("ESD_TRS_0033GS.do", TrsFrmQryString(formObj), url, true);
	var inv_bzc_amt = sheetObj.EtcData('inv_bzc_amt');
	if(!isNaN(inv_bzc_amt)){
		sheetObj.CellValue2(row, 'inv_bzc_amt') = inv_bzc_amt;
	}
}


/**
 * sheet cell value 변경시 발생하는 이벤트
 **/
function sheet1_OnChange(sheetObj, row, col, value){
	
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);

	switch(colName){

		case 'fm_loc_value':
		case 'to_loc_value':
		case 'via_loc_value':
			if( sheetObj.cellValue(row, colName) != '' )
			{
				document.form.TRSP_SO_EQ_KIND.value = "A";
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
			}
			break;
		case 'dor_loc_value':
			if( sheetObj.cellValue(row, colName) != '' )
			{
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				getZoneSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
			}
			break;
		case('inv_etc_add_amt'):
			if(value== '' || Number(value)==0){
				var surcharge_sheetObj = sheetObjects[3];
				var unique_cd = sheetObj.CellValue(row, 'surcharge_key');
				var scg_amt = '';
				var cnt = 0;

				// 이전에 세팅됐던 값은 지워버린다.
				for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
				{
					if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd){
						scg_amt = Number(surcharge_sheetObj.CellValue(a, prefix+'scg_amt'));
						if(scg_amt == 0) {
							surcharge_sheetObj.RowDelete(a, false);
						}else{
							cnt++;
							surcharge_sheetObj.CellValue2(a, prefix+'inv_scg_amt') = '';
						}
					}
				}
				if (cnt == 0) sheetObj.CellValue(row, 'n3pty_bil_flg')='';
			}else{
				var surcharge_sheetObj = sheetObjects[3];
				var unique_cd = sheetObj.CellValue(row, 'surcharge_key');
				var sum = 0;
				for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
				{
					if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd)
						sum += Number(surcharge_sheetObj.CellValue(a, prefix+'inv_scg_amt'));
				}

				if(sum != Number(deleteComma(value))){
					ComShowCodeMessage('COM12114', 'Invoice Additional Etc Amount');
					sheetObj.CellValue2(row, 'inv_etc_add_amt') = 0;
					var scg_amt = '';
					for(var a=surcharge_sheetObj.RowCount; a>0 ;a--)
					{
						if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd){
							scg_amt = Number(surcharge_sheetObj.CellValue(a, prefix+'inv_scg_amt'));
							if(scg_amt == 0) {
								surcharge_sheetObj.RowDelete(a, false);
							}else{
								cnt++;
								surcharge_sheetObj.CellValue2(a, prefix+'inv_scg_amt') = '';
							}
						}
					}
					if (cnt == 0) sheetObj.CellValue(row, 'n3pty_bil_flg')='';
				}
			}
			setSumOfInvoiceTotalAmount2(sheetObj, formObject);
			setNumOfEQ2(sheetObj, formObject);
			if(ida_ofc_cd == 'Y') {
				fn_gst_amt_change(sheetObj, row);
			}
			break;

		case('n3pty_bil_flg'):
			if(value== '' || value=='N'){
				var surcharge_sheetObj = sheetObjects[3];
				var unique_cd = sheetObj.CellValue(row, 'surcharge_key');

				// 이전에 세팅됐던 값은 지워버린다.
				for(var a=1; a<surcharge_sheetObj.RowCount ;a++)
				{
					if( surcharge_sheetObj.CellValue(a, prefix+'unique_cd') == unique_cd){
						surcharge_sheetObj.CellValue2(a, prefix+'cust_cnt_cd') = '';
						surcharge_sheetObj.CellValue2(a, prefix+'cust_seq') = '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_amt') = '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_vndr_seq') = '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_ofc_cd') = '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_desc') = '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_bil_flg') = '';
						surcharge_sheetObj.CellValue2(a, prefix+'n3pty_curr_cd') = '';
					}
				}
			}
			break;

		case 'eq_no':
			sheetObj.CellValue2(row,'eq_no') = value.toUpperCase();

			//full CNTR일 경우의 처리
			if( ( sheetObj.CellValue(row, 'org_eq_no') != '' || sheetObj.CellValue(row, 'trsp_so_tp_cd') == 'Y') && sheetObj.CellValue(row, 'trsp_frst_flg') != 'Y') {
				//ComShowCodeMessage('TRS90209'); 2007.08.10 지연대리 요청으로 message삭제
				sheetObj.CellValue2(row, 'eq_no') = '';
			}else if (sheetObj.CellValue(row, 'trsp_so_tp_cd') == 'Y' || sheetObj.CellValue(row, 'trsp_so_tp_cd') == 'M' || sheetObj.CellValue(row, 'trsp_so_tp_cd') == 'O') {
				//sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd')
				//유효한 CNTR인지 DB 조회를 통해 검사
				value = cntrCheckDigit(value);
				formObject.f_cmd.value = SEARCH07;
				var urlStr = 'ibflag=R&eq_no='+value+'&row='+row+'&col=eq_tpsz_cd';
				sheetObj.DoRowSearch('ESD_TRS_0999GS.do',urlStr+'&'+TrsFrmQryString(formObject));

				//DB에 있는 CNTR인 경우만 셀에 반영
				if (sheetObj.EtcData('EQ_NO')==''){
					ComShowCodeMessage('TRS00412');
					sheetObj.CellValue2(row,col)='';
				} else {				
					//조회 결과 EQ_TPSZ_CD가 기존 데이터와 상이한 경우 메세지를 표기하고 컨테이너를 입력하지 않음.
					if (sheetObj.CellValue(row,'eq_tpsz_cd') != sheetObj.EtcData('EQ_TPSZ_CD')){
						ComShowCodeMessage('TRS00413', sheetObj.EtcData('EQ_TPSZ_CD'));
						sheetObj.CellValue2(row,col)='';
					}
				}
			}
			sheetObj.CellValue2(row,'empty_eq_no_verify_check') = 'N';
			sheetObj.CellValue2(row,'verify_result') = '';

			break;
		case 'chk1':
			// CHM-201534183 [TD]Inv Creation Time-out 에러 해결 2015.02.16
			break;
		case 'inv_tot_amt':
			setSumOfInvoiceTotalAmount2(sheetObj, formObject);
			setNumOfEQ2(sheetObj, formObject);
			if(ida_ofc_cd == 'Y') {
				fn_gst_amt_change(sheetObj, row);
			}
			break;
			
		case 'ida_cgst_amt':
		case 'ida_sgst_amt':
		case 'ida_igst_amt':
		case 'ida_ugst_amt':
			fn_gst_chk_sum(sheetObj, formObject);
			fn_gst_amt_input (sheetObj, row);
			//fn_gst_amt_change (sheetObj, row);
			break;
			
		case 'ida_cgst_rto':
		case 'ida_sgst_rto':
		case 'ida_igst_rto':
		case 'ida_ugst_rto':
			fn_gst_amt_change (sheetObj, row);
			break;
			
		case 'ida_sac_cd':
			var v_sac_cd = sheetObj.CellValue(row,'ida_sac_cd');
			var v_sac_chk = fn_chk_sacNo(sheetObj, formObject, v_sac_cd);
			if (v_sac_chk) {
				ComShowMessage(ComGetMsg('TRS90723'));
				return;
			} else {
				fn_getSacRate(sheetObj, row);
			}
			break;
			
	}
}

/**
 * sheet2 cell value 변경시 발생하는 이벤트
 **/
function sheet2_OnChange(sheetObj, row, col, value){
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);

	switch(colName){

		case 'fm_loc_value':
		case 'to_loc_value':
		case 'via_loc_value':
		case 'dor_loc_value':
			if( sheetObj.cellValue(row, colName) != '' )
			{
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col+1), sheetObj.cellValue(row, colName));
			}
			break;
		case 'chk1':
			// CHM-201534183 [TD]Inv Creation Time-out 에러 해결 2015.02.16
			break;
		case 'inv_tot_amt':

			setSumOfInvoiceTotalAmount(sheetObj, formObject);
			setNumOfEQ(sheetObj, formObject);
			break;
	}
}

/**
 * sheet click시 일어나는 이벤트
 **/
function sheet1_OnClick(sheetObj, row, col, value)
{
	if(sheetObj.ReadDataProperty(row, col, 0)==6) 
	{	
		return;
	}
	var colName = sheetObj.ColSaveName(col);

	switch(colName){

		case 'fm_yard_value':
			if( sheetObj.cellValue(row, 'fm_loc_value') != '' ){
				document.form.TRSP_SO_EQ_KIND.value = "A";
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_loc_value'));
			}
			break;

		case 'to_yard_value':
			if( sheetObj.cellValue(row, 'to_loc_value') != '' ){
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_loc_value'));
			}
			break;
		
		case 'via_yard_value':
			if( sheetObj.cellValue(row, 'via_loc_value') != '' ){
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'via_loc_value'));
			}
			break;
		
		case 'dor_yard_value':
			if( sheetObj.cellValue(row, 'dor_loc_value') != '' ){
				getZoneSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'dor_loc_value'));
			}
			break;
		// CHM-201534183 [TD]Inv Creation Time-out 에러 해결 2015.02.16
		case 'chk1':
			setSumOfInvoiceTotalAmount2(sheetObj, document.form);
			setNumOfEQ2(sheetObj, document.form);
			if(ida_ofc_cd == 'Y') {
				fn_gst_chk_sum(sheetObj, document.form);
			}
			break;
	}
}

/**
 * sheet click시 일어나는 이벤트
 **/
function sheet2_OnClick(sheetObj, row, col, value)
{
	if(sheetObj.ReadDataProperty(row, col, 0)==6) 
	{	
		return;
	}
	var colName = sheetObj.ColSaveName(col);

	switch(colName){

		case 'fm_yard_value':
			if( sheetObj.cellValue(row, 'fm_loc_value') != '' ){
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_loc_value'));
			}
			break;

		case 'to_yard_value':
			if( sheetObj.cellValue(row, 'to_loc_value') != '' ){
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_loc_value'));
			}
			break;
		
		case 'via_yard_value':
			if( sheetObj.cellValue(row, 'via_loc_value') != '' ){
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'via_loc_value'));
			}
			break;
		
		case 'dor_yard_value':
			if( sheetObj.cellValue(row, 'dor_loc_value') != '' ){
				getZoneSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'dor_loc_value'));
			}
		// CHM-201534183 [TD]Inv Creation Time-out 에러 해결 2015.02.16
		case 'chk1':
			setSumOfInvoiceTotalAmount(sheetObj, document.form);
			setNumOfEQ(sheetObj, document.form);
			break;
	}
}

/**
 * Additional Amount를 클릭했을때 popup창을 띄워준다.
 **/
function sheet1_OnDblClick(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col);
	switch(colName) {
		case 'etc_add_amt':
			popSurchargeInputInquiry_CalLogic(sheetObj, row, col, 'search', 'WO');
			break;

		case 'inv_etc_add_amt':
			popSurchargeInputInquiry(sheetObj, row, col, 'modify', 'IV');
			break;
	}
}

/**
 * Additional Amount를 클릭했을때 popup창을 띄워준다.
 **/
function sheet2_OnDblClick(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col);
	switch(colName) {
		case 'etc_add_amt':
			popSurchargeInputInquiry_CalLogic(sheetObj, row, col, 'search', 'WO');
			break;

		case 'inv_etc_add_amt':
			popSurchargeInputInquiry(sheetObj, row, col, 'search', 'IV');
			break;
	}
}


/**
 * enter check
 **/
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'wo_no':
			case 'booking_no':
			case 'bl_no':
			case 'so_no':
				obj.value = obj.value.toUpperCase();
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			case 'eq_no':
				checkDigit(obj);
				obj.value = obj.value.toUpperCase();
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;

			case 'combo_svc_provider':
				getVendorSeq(sheetObj, formObj, obj.value);
				break;
		}
	}
}


/**
 * Sum of Invoice Total Amount를 계산한다.
 **/
function setSumOfInvoiceTotalAmount(sheetObj, formObj){

	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	
	var resultValue = 0;
	var resultValue2 = 0;
	
	for(var i=0; i<checkArray.length-1; i++){
		resultValue += isNaN(Number(deleteComma(sheetObj.CellValue(checkArray[i], 'inv_tot_amt'))))?0:Number(deleteComma(sheetObj.CellValue(checkArray[i], 'inv_tot_amt')));
		resultValue2 += isNaN(Number(deleteComma(sheetObj.CellValue(checkArray[i], 'inv_bzc_amt'))))?0:Number(deleteComma(sheetObj.CellValue(checkArray[i], 'inv_bzc_amt')));
	}
	
	formObj.cur_sum_inv.value = formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
	
	formObj.sum_inv_tot_amt.value = setPosition(resultValue);
	
	formObj.sum_inv_tot_amt.value = ComAddComma(formObj.sum_inv_tot_amt.value); // 2009-02-17 변경
	
	formObj.bpm_sum_inv_tot_amt.value = setPosition(resultValue2);
}

/**
 * Sum of Invoice Total Amount를 계산한다.
 **/
function setSumOfInvoiceTotalAmount2(sheetObj, formObj){
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	var resultValue = 0;
	for(var i=0; i<checkArray.length-1; i++){
		resultValue += isNaN(Number(deleteComma(sheetObj.CellValue(checkArray[i], 'inv_tot_amt'))))?0:Number(deleteComma(sheetObj.CellValue(checkArray[i], 'inv_tot_amt')));
	}
	
	formObj.cur_sum_inv_audit.value = formObj.apply_currency.options[formObj.apply_currency.selectedIndex].value;
	
	formObj.sum_inv_tot_amt_audit.value = setPosition(resultValue);
    
    formObj.sum_inv_tot_amt_audit.value = ComAddComma(formObj.sum_inv_tot_amt_audit.value); // 2009-02-17 변경
}

/**
 * Number of EQ를 계산한다.
 **/
function setNumOfEQ(sheetObj, formObj){
	
	var cnt_20 = 0;
	var cnt_40 = 0;
	var tp_cd = '';
	var tp_size = '';
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	var resultValue = 0;
	for(var i=0; i<checkArray.length-1; i++){
		if(sheetObj.CellValue(checkArray[i], 'eq_knd_cd')=='U'){

			tp_cd = sheetObj.CellValue(checkArray[i], 'eq_tpsz_cd');
			if(tp_cd.length == 2) tp_size = tp_cd.substr(1,2);
			else continue;

			if(tp_size == '2') cnt_20++;
			else cnt_40++;
		}
	}

	formObj.num_eq_20.value = cnt_20;
	formObj.num_eq_40.value = cnt_40;
	formObj.num_eq_tot.value = checkArray.length-1;
}

/**
 * Number of EQ를 계산한다.
 **/
function setNumOfEQ2(sheetObj, formObj){
	
	var cnt_20 = 0;
	var cnt_40 = 0;
	var tp_cd = '';
	var tp_size = '';
	var checkList = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	var resultValue = 0;
	for(var i=0; i<checkArray.length-1; i++){
		if(sheetObj.CellValue(checkArray[i], 'eq_knd_cd')=='U'){

			tp_cd = sheetObj.CellValue(checkArray[i], 'eq_tpsz_cd');
			if(tp_cd.length == 2) tp_size = tp_cd.substr(1,2);
			else continue;

			if(tp_size == '2') cnt_20++;
			else cnt_40++;
		}
	}

	formObj.num_eq_20_audit.value = cnt_20;
	formObj.num_eq_40_audit.value = cnt_40;
	formObj.num_eq_tot_audit.value = checkArray.length-1;
}



function sheet1_OnPopupClick (sheetObj , row , col )
{
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.CellValue(row, colName);

	switch(colName)
	{
		case('n3pty_bil_flg'):
			pop3rdPartyBilling(sheetObj, row, col, 'modify', 'WO');
		break;
	}
}

/**
 * Surcharge Input Inquiry popup
 **/
function pop3rdPartyBilling(sheetObj, row, col, mode, step_cd)
{
	if(sheetObj.CellValue(row, 'sp_kind')=='PRESET') row = row + 1;
	var myOption = "width=600,height=380,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0954.screen';
	url += '?unique_cd='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&open_mode='+mode;
	url += '&step_cd='+step_cd;
	url += '&main_row='+row;
	url += '&trsp_so_ofc_cty_cd='+sheetObj.CellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&trsp_so_seq='+sheetObj.CellValue(row, 'trsp_so_seq');
	url += '&sheet_arr_no=3';
	url += '&bkg_no='+sheetObj.CellValue(row, 'bkg_no');
	url += '&eq_no='+sheetObj.CellValue(row, 'eq_no');
	url += '&wo_no='+sheetObj.CellValue(row, 'trsp_wo_ofc_cty_cd')+sheetObj.CellValue(row, 'trsp_wo_seq');
	url += '&curr_cd='+document.form.apply_currency.value;
	myWin = window.open(url, "pop3rdPartyBilling", myOption);
	myWin.focus();
}


/**
 * Invoice reject하기
 **/
function rejectInvoice(sheetObj, formObj)
{
	if(sheetObj.RowCount < 1) return;

	if(sheetObj.CellValue(1, 'if_sys_knd_cd') != 'W') {
		ComShowCodeMessage('TRS90241');
		return;
	}

	formObj.f_cmd.value = SEARCH11;
	sheetObj.DoSearch4Post("ESD_TRS_0033GS.do", TrsFrmQryString(formObj), '', true);
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet3_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == SEARCH11){
			ComShowCodeMessage('TRS90240');
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			resetHeader(sheetObjects[0], sheetObjects[1], formObj);
		}
	}
}


function setPosition(amt){
	if (document.form.apply_currency.value == 'JPY' || document.form.apply_currency.value == 'KRW' || document.form.apply_currency.value == 'TWD'){
		amt = chkAmtPos_JPY(amt);
	}else{
		amt = chkAmtPos(amt);
	}
	return amt;
}

function setCurrChange(){
	var sheetObj_Audit		= sheetObjects[0];
	var sheetObj_Confirm	= sheetObjects[1];
	var formObj = document.form;
	if(formObj.apply_currency.value == 'JPY' || formObj.apply_currency.value == 'KRW' || formObj.apply_currency.value == 'TWD'){
		for(var i=2; i<sheetObj_Audit.RowCount+2; i++){
			setDecimalType_Audit(sheetObj_Audit, i);
		}
		
		for(var i=2; i<sheetObj_Confirm.RowCount+2; i++){
			setDecimalType_Confirm(sheetObj_Confirm, i);
		}
	}else{
		for(var i=2; i<sheetObj_Audit.RowCount+2; i++){
			setFloatingType_Audit(sheetObj_Audit, i);
		}

		for(var i=2; i<sheetObj_Confirm.RowCount+2; i++){
			setFloatingType_Confirm(sheetObj_Confirm, i);
		}
	}

	calAmt();
	setSumOfInvoiceTotalAmount(sheetObj_Confirm, formObj);

}


function setDecimalType_Audit(sheetObj, row){
	sheetObj.InitCellProperty(row, 'bzc_amt', dtNull, daNull, 'bzc_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'nego_amt', dtNull, daNull, 'nego_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'fuel_scg_amt', dtNull, daNull, 'fuel_scg_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'scg_vat_amt', dtNull, daNull, 'scg_vat_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'toll_fee_amt', dtNull, daNull, 'toll_fee_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'etc_add_amt', dtNull, daNull, 'etc_add_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'wo_tot_amt', dtNull, daNull, 'wo_tot_amt', '', dfInteger, 0);
	
	sheetObj.InitCellProperty(row, 'inv_bzc_amt', dtNull, daNull, 'inv_bzc_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'inv_etc_add_amt', dtNull, daNull, 'inv_etc_add_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'inv_tot_amt', dtNull, daNull, 'inv_tot_amt', '|inv_bzc_amt|+|inv_etc_add_amt|', dfInteger, 0);

	sheetObj.CellValue2(row, 'bzc_amt')			= chkAmtPos_JPY(sheetObj.CellValue(row, 'bzc_amt'));
	sheetObj.CellValue2(row, 'nego_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'nego_amt'));
	sheetObj.CellValue2(row, 'fuel_scg_amt')	= chkAmtPos_JPY(sheetObj.CellValue(row, 'fuel_scg_amt'));
	sheetObj.CellValue2(row, 'scg_vat_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'scg_vat_amt'));
	sheetObj.CellValue2(row, 'etc_add_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'etc_add_amt'));
	sheetObj.CellValue2(row, 'toll_fee_amt')	= chkAmtPos_JPY(sheetObj.CellValue(row, 'toll_fee_amt'));
	sheetObj.CellValue2(row, 'wo_tot_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'wo_tot_amt'));	
	sheetObj.CellValue2(row, 'inv_bzc_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'inv_bzc_amt'));
	sheetObj.CellValue2(row, 'inv_etc_add_amt')	= chkAmtPos_JPY(sheetObj.CellValue(row, 'inv_etc_add_amt'));
	sheetObj.CellValue2(row, 'inv_tot_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'inv_tot_amt'));

}

function setFloatingType_Audit(sheetObj, row){
	sheetObj.InitCellProperty(row, 'bzc_amt', dtNull, daNull, 'bzc_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'nego_amt', dtNull, daNull, 'nego_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'fuel_scg_amt', dtNull, daNull, 'fuel_scg_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'scg_vat_amt', dtNull, daNull, 'scg_vat_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'toll_fee_amt', dtNull, daNull, 'toll_fee_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'etc_add_amt', dtNull, daNull, 'etc_add_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'wo_tot_amt', dtNull, daNull, 'wo_tot_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'inv_bzc_amt', dtNull, daNull, 'inv_bzc_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'inv_etc_add_amt', dtNull, daNull, 'inv_etc_add_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'inv_tot_amt', dtNull, daNull, 'inv_tot_amt', '|inv_bzc_amt|+|inv_etc_add_amt|', dfFloat, 2);

	sheetObj.CellValue2(row, 'bzc_amt')			= chkAmtPos(sheetObj.CellValue(row, 'bzc_amt'));
	sheetObj.CellValue2(row, 'nego_amt')		= chkAmtPos(sheetObj.CellValue(row, 'nego_amt'));
	sheetObj.CellValue2(row, 'fuel_scg_amt')	= chkAmtPos(sheetObj.CellValue(row, 'fuel_scg_amt'));
	sheetObj.CellValue2(row, 'scg_vat_amt')		= chkAmtPos(sheetObj.CellValue(row, 'scg_vat_amt'));
	sheetObj.CellValue2(row, 'toll_fee_amt')	= chkAmtPos(sheetObj.CellValue(row, 'toll_fee_amt'));
	sheetObj.CellValue2(row, 'etc_add_amt')		= chkAmtPos(sheetObj.CellValue(row, 'etc_add_amt'));
	sheetObj.CellValue2(row, 'wo_tot_amt')		= chkAmtPos(sheetObj.CellValue(row, 'wo_tot_amt'));	
	sheetObj.CellValue2(row, 'inv_bzc_amt')		= chkAmtPos(sheetObj.CellValue(row, 'inv_bzc_amt'));
	sheetObj.CellValue2(row, 'inv_etc_add_amt')	= chkAmtPos(sheetObj.CellValue(row, 'inv_etc_add_amt'));
	sheetObj.CellValue2(row, 'inv_tot_amt')		= chkAmtPos(sheetObj.CellValue(row, 'inv_tot_amt')); 
}

function setDecimalType_Confirm(sheetObj, row){
	sheetObj.InitCellProperty(row, 'bzc_amt', dtNull, daNull, 'bzc_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'nego_amt', dtNull, daNull, 'nego_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'fuel_scg_amt', dtNull, daNull, 'fuel_scg_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'scg_vat_amt', dtNull, daNull, 'scg_vat_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'toll_fee_amt', dtNull, daNull, 'toll_fee_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'etc_add_amt', dtNull, daNull, 'etc_add_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'wo_tot_amt', dtNull, daNull, 'wo_tot_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'inv_bzc_amt', dtNull, daNull, 'inv_bzc_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'inv_etc_add_amt', dtNull, daNull, 'inv_etc_add_amt', '', dfInteger, 0);
	sheetObj.InitCellProperty(row, 'inv_tot_amt', dtNull, daNull, 'inv_tot_amt', '|inv_bzc_amt|+|inv_etc_add_amt|', dfInteger, 0);

	sheetObj.CellValue2(row, 'bzc_amt')			= chkAmtPos_JPY(sheetObj.CellValue(row, 'bzc_amt'));
	sheetObj.CellValue2(row, 'nego_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'nego_amt'));
	sheetObj.CellValue2(row, 'fuel_scg_amt')	= chkAmtPos_JPY(sheetObj.CellValue(row, 'fuel_scg_amt'));
	sheetObj.CellValue2(row, 'scg_vat_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'scg_vat_amt'));
	sheetObj.CellValue2(row, 'toll_fee_amt')	= chkAmtPos_JPY(sheetObj.CellValue(row, 'toll_fee_amt'));
	sheetObj.CellValue2(row, 'etc_add_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'etc_add_amt'));
	sheetObj.CellValue2(row, 'wo_tot_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'wo_tot_amt'));
	sheetObj.CellValue2(row, 'inv_bzc_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'inv_bzc_amt'));
	sheetObj.CellValue2(row, 'inv_etc_add_amt')	= chkAmtPos_JPY(sheetObj.CellValue(row, 'inv_etc_add_amt'));
	sheetObj.CellValue2(row, 'inv_tot_amt')		= chkAmtPos_JPY(sheetObj.CellValue(row, 'inv_tot_amt'));
}

function setFloatingType_Confirm(sheetObj, row){
	sheetObj.InitCellProperty(row, 'bzc_amt', dtNull, daNull, 'bzc_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'nego_amt', dtNull, daNull, 'nego_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'fuel_scg_amt', dtNull, daNull, 'fuel_scg_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'scg_vat_amt', dtNull, daNull, 'scg_vat_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'toll_fee_amt', dtNull, daNull, 'toll_fee_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'etc_add_amt', dtNull, daNull, 'etc_add_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'wo_tot_amt', dtNull, daNull, 'wo_tot_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'inv_bzc_amt', dtNull, daNull, 'inv_bzc_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'inv_etc_add_amt', dtNull, daNull, 'inv_etc_add_amt', '', dfFloat, 2);
	sheetObj.InitCellProperty(row, 'inv_tot_amt', dtNull, daNull, 'inv_tot_amt', '|inv_bzc_amt|+|inv_etc_add_amt|', dfFloat, 2);

	sheetObj.CellValue2(row, 'bzc_amt')			= chkAmtPos(sheetObj.CellValue(row, 'bzc_amt'));
	sheetObj.CellValue2(row, 'nego_amt')		= chkAmtPos(sheetObj.CellValue(row, 'nego_amt'));
	sheetObj.CellValue2(row, 'fuel_scg_amt')	= chkAmtPos(sheetObj.CellValue(row, 'fuel_scg_amt'));
	sheetObj.CellValue2(row, 'scg_vat_amt')		= chkAmtPos(sheetObj.CellValue(row, 'scg_vat_amt'));
	sheetObj.CellValue2(row, 'toll_fee_amt')	= chkAmtPos(sheetObj.CellValue(row, 'toll_fee_amt'));
	sheetObj.CellValue2(row, 'etc_add_amt')		= chkAmtPos(sheetObj.CellValue(row, 'etc_add_amt'));
	sheetObj.CellValue2(row, 'wo_tot_amt')		= chkAmtPos(sheetObj.CellValue(row, 'wo_tot_amt'));
	sheetObj.CellValue2(row, 'inv_bzc_amt')		= chkAmtPos(sheetObj.CellValue(row, 'inv_bzc_amt'));
	sheetObj.CellValue2(row, 'inv_etc_add_amt')	= chkAmtPos(sheetObj.CellValue(row, 'inv_etc_add_amt'));
	sheetObj.CellValue2(row, 'inv_tot_amt')		= chkAmtPos(sheetObj.CellValue(row, 'inv_tot_amt'));
}

function checkDigit(obj){
	var formObj = document.form;
	if (obj == undefined){
		obj = formObj.eq_no_text;
	}
	
	obj.value = obj.value.toUpperCase();

	if(formObj.eq_no_rdo[0].checked){
		obj.value = multiCntrChkDgt(obj.value);
	}
}

function verifyEqNo(sheetObj, formObj){

	var checkList	= sheetObj.FindCheckedRow('chk1');
	var checkArray	= checkList.split('|');
	var returnFlag	= false;
	var query		= '';
	var row			= 0;
	var verifyArray = new Array();
	var cnt			= 0;


	for(var i=0; i<checkArray.length-1; i++){
		row = checkArray[i];
		if(sheetObj.CellValue(row,'eq_no') == ''){
			ComShowMessage(ComGetMsg("TRS90389"));
			return false;
		}else if(sheetObj.CellValue(row,'eq_no') == sheetObj.CellValue(row,'org_eq_no')){
			continue;
		}else if(sheetObj.CellValue(row,'empty_eq_no_verify_check') == 'Y'){
			continue;
		}else{
			query	+= '&ibflag=S';
			query	+= '&eq_no='	+sheetObj.CellValue(row, 'eq_no');
			query	+= '&cre_dt='	+sheetObj.CellValue(row, 'cre_dt')
									+sheetObj.CellValue(row, 'cre_tm');
			query	+= '&fm_nod_cd='+sheetObj.CellValue(row, 'fm_loc_value')
									+sheetObj.CellValue(row, 'fm_yard_value');
			query	+= '&ref_seq='	+row;
			verifyArray[cnt++] = row;
		}
	}
	
	if(query != ''){
		formObj.f_cmd.value = SEARCH16;
		sheetObj.DoRowSearch("ESD_TRS_0033_01GS.do", TrsFrmQryString(formObj)+query);
		if( sheetObj.CellValue(row, 'verify_result')!='' ){
			sheetObj.SelectCell(row, 'verify_result');
		}
		for(var  k=0; k<verifyArray.length; k++){
			sheetObj.CellValue(verifyArray[k], 'empty_eq_no_verify_check') = 'Y';
		}
	}
}

function checkEmptyEqNo(sheetObj){
	var checkList	= sheetObj.FindCheckedRow('chk1');
	var checkArray	= checkList.split('|');
	var row = 0;
	for(var i=0; i<checkArray.length-1; i++){
		row = checkArray[i];

		if(sheetObj.CellValue(row, 'eq_no') == ''){
			ComShowMessage(ComGetMsg("TRS90389"));
			return false;
		}else if(sheetObj.CellValue(row, 'eq_no') == sheetObj.CellValue(row, 'org_eq_no')){
			continue;
		}else if(sheetObj.CellValue(row, 'empty_eq_no_verify_check') == 'Y'){
			continue;
		}else{
			ComShowMessage('Please verify first!!');
			sheetObj.SelectCell(row, 'eq_no');
			return false;
		}
	}
	return true;
}


function checkDupEqNoANDWoNo(){

	var audit_sheetObj = sheetObjects[0];
	var confirm_sheetObj = sheetObjects[1];

	var checkList	= audit_sheetObj.FindCheckedRow('chk1');
	var checkArray	= checkList.split('|');

	var src_wono = '';
	var src_eqno = '';
	var src_row = 0;
	var tgt_row = 0;

	for(var i=0; i<checkArray.length-2; i++){
		src_row = checkArray[i];
		src_wono = audit_sheetObj.CellValue(src_row, 'trsp_wo_ofc_cty_cd_seq');
		src_eqno = audit_sheetObj.CellValue(src_row, 'eq_no');

		for(var k=i+1; k<checkArray.length-1; k++){
			tgt_row = checkArray[k];
			if(src_wono == audit_sheetObj.CellValue(tgt_row, 'trsp_wo_ofc_cty_cd_seq')
				&& src_eqno == audit_sheetObj.CellValue(tgt_row, 'eq_no') ){
				ComShowMessage('Duplicated  CNTR w/ Auditing Sheet');
				audit_sheetObj.SelectCell(tgt_row, 'eq_no');
				return false;
			}
		}
	}

	for(var i=0; i<checkArray.length-1; i++){
		src_row = checkArray[i];
		src_wono = audit_sheetObj.CellValue(src_row, 'trsp_wo_ofc_cty_cd_seq');
		src_eqno = audit_sheetObj.CellValue(src_row, 'eq_no');

		for(var k=2; k<confirm_sheetObj.RowCount+2; k++){
			tgt_row = k;
			if(src_wono == confirm_sheetObj.CellValue(tgt_row, 'trsp_wo_ofc_cty_cd_seq')
				&& src_eqno == confirm_sheetObj.CellValue(tgt_row, 'eq_no') ){
				ComShowMessage('Duplicated  CNTR w/ Confirm Sheet');
				audit_sheetObj.SelectCell(src_row, 'eq_no');
				return false;
			}
		}
	}

	return true;
}

function openInvoiceAuthority()
{
	var formObj = document.form;
	var myOption = "width=1024,height=600,menubar=0,status=0,scrollbars=0,resizable=1";
    var param = "?"+TrsFrmQryString(formObj);
	myWin = window.open('/hanjin/ESD_TRS_0976.do' + param, "popup", myOption);  
}

function fn_ida_gst_rgst_name (mode) {
	var ida_gst_rgst_val = "";	
	switch(mode) {
	case "R" :
		ida_gst_rgst_val = "Registered";
		break;
	case "C" :
		ida_gst_rgst_val = "Composite";
		break;
	case "U" :
		ida_gst_rgst_val = "Unregistered";
		break;
	default :
		ida_gst_rgst_val = "";
		break;
	}		
	return ida_gst_rgst_val;
}

function fn_gst_chk_sum(sheetObj, formObj) {
	var checkList  = sheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');	
	var cgstSum    = 0;
	var sgstSum    = 0;
	var igstSum    = 0;
	var ugstSum    = 0;
	
	for(var i=0; i<checkArray.length-1; i++){
		cgstSum += isNaN(Number(deleteComma(sheetObj.CellValue(checkArray[i], 'ida_cgst_amt'))))?0:Number(deleteComma(sheetObj.CellValue(checkArray[i], 'ida_cgst_amt')));
		sgstSum += isNaN(Number(deleteComma(sheetObj.CellValue(checkArray[i], 'ida_sgst_amt'))))?0:Number(deleteComma(sheetObj.CellValue(checkArray[i], 'ida_sgst_amt')));
		igstSum += isNaN(Number(deleteComma(sheetObj.CellValue(checkArray[i], 'ida_igst_amt'))))?0:Number(deleteComma(sheetObj.CellValue(checkArray[i], 'ida_igst_amt')));
		ugstSum += isNaN(Number(deleteComma(sheetObj.CellValue(checkArray[i], 'ida_ugst_amt'))))?0:Number(deleteComma(sheetObj.CellValue(checkArray[i], 'ida_ugst_amt')));
	}
	
	formObj.ida_cgst_amt_chk_sum.value = cgstSum;
	formObj.ida_cgst_amt_chk_sum.value = ComAddComma(formObj.ida_cgst_amt_chk_sum.value);
	
	formObj.ida_sgst_amt_chk_sum.value = sgstSum;
	formObj.ida_sgst_amt_chk_sum.value = ComAddComma(formObj.ida_sgst_amt_chk_sum.value);
	
	formObj.ida_igst_amt_chk_sum.value = igstSum;
	formObj.ida_igst_amt_chk_sum.value = ComAddComma(formObj.ida_igst_amt_chk_sum.value);
	
	formObj.ida_ugst_amt_chk_sum.value = ugstSum;
	formObj.ida_ugst_amt_chk_sum.value = ComAddComma(formObj.ida_ugst_amt_chk_sum.value);	
}

function fn_all_gst_chk_sum(sheetObj, formObj) {
	var cgstSum = 0;
	var sgstSum = 0;
	var igstSum = 0;
	var ugstSum = 0;
	
	for(var i=2; i<sheetObj.RowCount+2; i++){
		cgstSum += isNaN(Number(deleteComma(sheetObj.CellValue(i, 'ida_cgst_amt'))))?0:Number(deleteComma(sheetObj.CellValue(i, 'ida_cgst_amt')));
		sgstSum += isNaN(Number(deleteComma(sheetObj.CellValue(i, 'ida_sgst_amt'))))?0:Number(deleteComma(sheetObj.CellValue(i, 'ida_sgst_amt')));
		igstSum += isNaN(Number(deleteComma(sheetObj.CellValue(i, 'ida_igst_amt'))))?0:Number(deleteComma(sheetObj.CellValue(i, 'ida_igst_amt')));
		ugstSum += isNaN(Number(deleteComma(sheetObj.CellValue(i, 'ida_ugst_amt'))))?0:Number(deleteComma(sheetObj.CellValue(i, 'ida_ugst_amt')));
	}
	
	formObj.ida_cgst_amt_chk_sum.value = cgstSum;
	formObj.ida_cgst_amt_chk_sum.value = ComAddComma(formObj.ida_cgst_amt_chk_sum.value);	
	formObj.ida_sgst_amt_chk_sum.value = sgstSum;
	formObj.ida_sgst_amt_chk_sum.value = ComAddComma(formObj.ida_sgst_amt_chk_sum.value);	
	formObj.ida_igst_amt_chk_sum.value = igstSum;
	formObj.ida_igst_amt_chk_sum.value = ComAddComma(formObj.ida_igst_amt_chk_sum.value);	
	formObj.ida_ugst_amt_chk_sum.value = ugstSum;
	formObj.ida_ugst_amt_chk_sum.value = ComAddComma(formObj.ida_ugst_amt_chk_sum.value);	
}

function fn_gst_rate_calc(sac_no) {
	var sheetObj        = sheetObjects[0];
	var formObj         = document.form;	
	var checkList       = sheetObj.FindCheckedRow('chk1');
	var checkArray      = checkList.split('|');
	var row             = sheetObj.SearchRows ;	
	formObj.f_cmd.value = SEARCH18;
	
	if (checkList == undefined || checkList == '') {
		ComShowMessage(ComGetMsg("TRS90215")); //Please select at least one row.
		return false;
	}
	
	if (formObj.inp_hsn_sac.value == '') {
		ComShowCodeMessage('COM12114','HSN/SAC'); //Please check HSN/SAC
		return false;
	}
	
	var v_sac_chk = fn_chk_sacNo(sheetObj, formObj, sac_no);
	if(v_sac_chk) {
		ComShowMessage(ComGetMsg('TRS90723'));
		return false;
	}
	
	sheetObj.DoRowSearch("ESD_TRS_0033GS.do", TrsFrmQryString(formObj));
	var v_ida_cgst_rto = sheetObj.EtcData('ida_cgst_rto');
	var v_ida_sgst_rto = sheetObj.EtcData('ida_sgst_rto');
	var v_ida_igst_rto = sheetObj.EtcData('ida_igst_rto');
	var v_ida_ugst_rto = sheetObj.EtcData('ida_ugst_rto');
	
	for(var i=2; i <= row+1; i++) {
		if (sheetObj.CellValue(i, 'chk1') == 1) {
			sheetObj.CellValue(i, 'ida_sac_cd')   = sac_no;
			sheetObj.CellValue(i, 'ida_cgst_rto') = v_ida_cgst_rto;
			sheetObj.CellValue(i, 'ida_sgst_rto') = v_ida_sgst_rto;
			sheetObj.CellValue(i, 'ida_igst_rto') = v_ida_igst_rto;
			sheetObj.CellValue(i, 'ida_ugst_rto') = v_ida_ugst_rto;
		}
	}
}

function fn_gst_amt_change (sheetObj, row) {
	sheetObj.CellValue(row,'ida_cgst_amt') = fn_gst_round((sheetObj.CellValue(row,'inv_tot_amt') * sheetObj.CellValue(row,'ida_cgst_rto')) / 100, 2) ;
	sheetObj.CellValue(row,'ida_sgst_amt') = fn_gst_round((sheetObj.CellValue(row,'inv_tot_amt') * sheetObj.CellValue(row,'ida_sgst_rto')) / 100, 2) ;
	sheetObj.CellValue(row,'ida_igst_amt') = fn_gst_round((sheetObj.CellValue(row,'inv_tot_amt') * sheetObj.CellValue(row,'ida_igst_rto')) / 100, 2) ;
	sheetObj.CellValue(row,'ida_ugst_amt') = fn_gst_round((sheetObj.CellValue(row,'inv_tot_amt') * sheetObj.CellValue(row,'ida_ugst_rto')) / 100, 2) ;
	
	sheetObj.CellValue(row,'ida_gst_amt')  = parseFloat(sheetObj.CellValue(row,'ida_cgst_amt')) 
	                                       + parseFloat(sheetObj.CellValue(row,'ida_sgst_amt')) 
	                                       + parseFloat(sheetObj.CellValue(row,'ida_igst_amt')) 
	                                       + parseFloat(sheetObj.CellValue(row,'ida_ugst_amt'));
	
	sheetObj.CellValue(row,'ida_gst_rto')  = parseFloat(sheetObj.CellValue(row,'ida_cgst_rto')) 
										   + parseFloat(sheetObj.CellValue(row,'ida_sgst_rto')) 
										   + parseFloat(sheetObj.CellValue(row,'ida_igst_rto')) 
										   + parseFloat(sheetObj.CellValue(row,'ida_ugst_rto'));
	
}

function fn_gst_round(val,precision) {
    val = val * Math.pow(100,precision); 
    val = Math.round(val); 
    return val/Math.pow(100,precision); 
}

function fn_chk_sacNo(sheetObj, formObj, sacNo) {
	var paramSacNo = sacNo;
	var chkValue = "";
	var f_cmd = SEARCH19;	
	if (paramSacNo != undefined && paramSacNo != '') {
		var param = "inp_hsn_sac="+paramSacNo+"&f_cmd="+f_cmd;
		var sXml = sheetObj.GetSearchXml("ESD_TRS_0033GS.do", param);
		var sac_no_exist = ComGetEtcData(sXml, "sac_no_exist");
		if(sac_no_exist == "Y") {
			chkValue = false;
		} else {
			chkValue = true;
		}
	}	
	return chkValue;
}

function fn_getSacRate(sheetObj, row) {
	var formObj = document.form;
	var f_cmd = SEARCH18;
	var sac_no = sheetObj.CellValue(row, 'ida_sac_cd');
	var param = "inp_hsn_sac="+sac_no+"&f_cmd="+f_cmd+"&FORM_USR_OFC_CD="+v_ofc_Cd+"&paymt_sp_cd="+formObj.paymt_sp_cd.value;
	sheetObj.DoRowSearch("ESD_TRS_0033GS.do", param);
	var v_ida_cgst_rto = sheetObj.EtcData('ida_cgst_rto');
	var v_ida_sgst_rto = sheetObj.EtcData('ida_sgst_rto');
	var v_ida_igst_rto = sheetObj.EtcData('ida_igst_rto');
	var v_ida_ugst_rto = sheetObj.EtcData('ida_ugst_rto');
	sheetObj.CellValue(row, 'ida_cgst_rto') = v_ida_cgst_rto;
	sheetObj.CellValue(row, 'ida_sgst_rto') = v_ida_sgst_rto;
	sheetObj.CellValue(row, 'ida_igst_rto') = v_ida_igst_rto;
	sheetObj.CellValue(row, 'ida_ugst_rto') = v_ida_ugst_rto;
}

function fn_calVat() {
	var formObj = document.form;
	var vat_amt = "";
	var calc_ida_cgst_amt = deleteComma(formObj.inp_ida_cgst_amt.value);
	var calc_ida_sgst_amt = deleteComma(formObj.inp_ida_sgst_amt.value);
	var calc_ida_igst_amt = deleteComma(formObj.inp_ida_igst_amt.value);
	var calc_ida_ugst_amt = deleteComma(formObj.inp_ida_ugst_amt.value);
	
    vat_amt = Number(calc_ida_cgst_amt) + Number(calc_ida_sgst_amt)
            + Number(calc_ida_igst_amt) + Number(calc_ida_ugst_amt);
	
    formObj.vat_amt.value = setPosition(vat_amt);
    formObj.vat_amt.value = ComAddComma(formObj.vat_amt.value);
    
    formObj.inp_ida_cgst_amt.value = ComAddComma(setPosition(formObj.inp_ida_cgst_amt.value));
    formObj.inp_ida_sgst_amt.value = ComAddComma(setPosition(formObj.inp_ida_sgst_amt.value));
    formObj.inp_ida_igst_amt.value = ComAddComma(setPosition(formObj.inp_ida_igst_amt.value));
    formObj.inp_ida_ugst_amt.value = ComAddComma(setPosition(formObj.inp_ida_ugst_amt.value));

    calAmt();	
}

function fn_gst_amt_input (sheetObj, row) {
	sheetObj.CellValue(row,'ida_gst_amt')  = parseFloat(sheetObj.CellValue(row,'ida_cgst_amt')) 
	                                       + parseFloat(sheetObj.CellValue(row,'ida_sgst_amt')) 
	                                       + parseFloat(sheetObj.CellValue(row,'ida_igst_amt')) 
	                                       + parseFloat(sheetObj.CellValue(row,'ida_ugst_amt'));	
}

function fn_vat_mna_input_chk() {
	var x = document.getElementById("vat_amt");
	var cgstSum  = 0;
	var sgstSum  = 0;
	var igstSum  = 0;
	var ugstSum  = 0;
	var totalGst = 0;
	var vatAmt   = 0;	
	if(ida_ofc_cd == 'Y') {
		cgstSum  +=  isNaN(parseFloat(deleteComma(document.form.inp_ida_cgst_amt.value)))?0:parseFloat(deleteComma(document.form.inp_ida_cgst_amt.value));
		sgstSum  +=  isNaN(parseFloat(deleteComma(document.form.inp_ida_sgst_amt.value)))?0:parseFloat(deleteComma(document.form.inp_ida_sgst_amt.value));
		igstSum  +=  isNaN(parseFloat(deleteComma(document.form.inp_ida_igst_amt.value)))?0:parseFloat(deleteComma(document.form.inp_ida_igst_amt.value));
		ugstSum  +=  isNaN(parseFloat(deleteComma(document.form.inp_ida_ugst_amt.value)))?0:parseFloat(deleteComma(document.form.inp_ida_ugst_amt.value));
		totalGst = cgstSum + sgstSum + igstSum + ugstSum;
		vatAmt   +=  isNaN(parseFloat(deleteComma(document.form.vat_amt.value)))?0:parseFloat(deleteComma(document.form.vat_amt.value));
		if (totalGst != vatAmt) {
			x.style.color = "red";
		} else {
			x.style.color = "black";
		}		
	}
}
