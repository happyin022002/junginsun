/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0030.js
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 최 선
*@LastVersion : 1.0 
* 2007.01.26 poong_yeon
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2011.05.06  손은주 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.12.01  유선오 [CHM-            ][TRS] Invoice inquiry 화면에서 Down excel (2) button 을 통해 Down 되는 Excel 파일 양식 
* 2012.02.07  최 선 [CHM-201215882] [TRS/SPP] 210 EDI 수신요건 변경 요청
* 2012.04.03  최 선 [] Invoice Amount 헤더 타이틀 변경
=========================================================*/


/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운 
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0030 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0030() {
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

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject  = sheetObjects[0];
	 var sheetObject1 = sheetObjects[1];

	 /*******************************************************/
	 var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case 'btng_invoicedelete':				
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				
				for(var i=0; i< checkArray.length-1; i++){	
					if(sheetObject.CellValue(checkArray[i], 'ets_sts_flg') == 'Y'){			
						ComShowCodeMessage('TRS90367');
						return;
					}
				}		
				
				if(!confirm( ComGetMsg('COM12171', 'Invoice') )) {
					return;
				}
				doActionIBSheet(sheetObject,formObject,'invoiceDelete');
				break;

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				sheetObject.ColFontColor('inv_whld_tax_amt') = sheetObject.RgbColor(255, 0, 0);
				break;

			case "btn_reset":
				resetSearchCondition(formObject);
				break;

			case "btn_minimize":
				Mincount = (Mincount+1)%2 ;
				Minimize(Mincount);
				break;

			case "btns_calendar":
				var cal2 = new ComCalendarFromTo();
				cal2.displayType = "date";
				cal2.select(document.form.fmdate, document.form.todate, 'yyyyMMdd');
				break;

			case 'btns_no_cd':
				rep_Multiful_inquiry(srcName);
				break;
				
			case 'btns_ofc_cd':
				rep_Multiful_inquiry('Office Code');
				break;

			case 'btng_provider':
				rep_OnPopupClick();
				break;

			case "btng_downexcel1":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case "btng_downexcel2":
				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}
				doActionIBSheet(sheetObject1,formObject,'IBDOWNEXCEL2');
				break;
				
			case "btng_MasterInvoiceCreation":
				// 조회조건과 동일하게 조회조건 추가 시작
				if(ComIsNull(formObject.no_cd)){
		   			if(ComIsNull(formObject.fmdate) || ComIsNull(formObject.todate) || ComIsNull(formObject.inv_cre_ofc)){
		   				ComShowCodeMessage("TRS90124");
						return false;
		   			}	   			
		   		}
		   		var days_between = ComGetDaysBetween(formObject.fmdate , formObject.todate) ;  // 조회 기간
		   		if( days_between   < 0) {
					ComShowCodeMessage("TRS90118");
					formObject.fmdate.focus();
					return false;
				} 
				if ( days_between > 60 ) {
					ComShowMessage(" Possible inquiry period is limited to 2 months.");
					return false;
				}
				// 조회조건과 동일하게 조회조건 추가 종료
				
				var sheetObj = sheetObjects[0];
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				
				if(checkInvVndrSeq()){
					ComShowCodeMessage('TRS90365');
					return;
				}
				
				if(checkEDI()){
					return;
				}
				
				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}
				
				if(checkList != ""){
					print_excel(sheetObject);
				}else{
					ComShowCodeMessage('COM12176');
					return;
				}
				break;
					
			case "btng_holdsave":
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');

				for(var i=0; i< checkArray.length-1; i++){	
					if(sheetObject.CellValue(checkArray[i], 'ets_sts_flg') == 'Y'){			
						ComShowCodeMessage('TRS90367');
						return;
					}
					if(sheetObject.CellValue(checkArray[i], 'trsp_inv_aud_sts_cd') != 'RC' &&
					   sheetObject.CellValue(checkArray[i], 'trsp_inv_aud_sts_cd') != 'SV' &&
					   sheetObject.CellValue(checkArray[i], 'trsp_inv_aud_sts_cd') != 'CF' 
					   ){			
						ComShowCodeMessage('TRS90386','Once CSR is created, related invoice can’t be hold.\n' +
								                      'Pls check the status of selected invoice again');
						return;
					}
				}
				
				if(checkEDI()){
					return;
				}
			
				if(checkReject()){
					ComShowCodeMessage('COM12113', 'not Rejected Invoice');
					return;
				}

				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}
				
				doActionIBSheet(sheetObject,formObject,'HOLD_SAVE');
				break;

			case "btng_saveupdusrid":
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');

				for(var i=0; i< checkArray.length-1; i++){	
					if(sheetObject.CellValue(checkArray[i], 'ets_sts_flg') == 'Y'){			
						ComShowCodeMessage('TRS90367');
						return;
					}
					if(sheetObject.CellValue(checkArray[i], 'trsp_inv_aud_sts_cd') != 'RC' &&
					   sheetObject.CellValue(checkArray[i], 'trsp_inv_aud_sts_cd') != 'SV' 
					   ){			
						ComShowCodeMessage('TRS90386','Pls check the status of selected invoice again');
						return;
					}
				}	
				
				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}
				
				doActionIBSheet(sheetObject,formObject,'USR_ID_SAVE');
				break;
				
			case "btng_invaudit":
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				
				for(var i=0; i< checkArray.length-1; i++){	
					if(sheetObject.CellValue(checkArray[i], 'ets_sts_flg') == 'Y'){			
						ComShowCodeMessage('TRS90367');
						return;
					}
				}		

				if(checkEDI()){
					return;
				}
				
				if(checkReject()){
					ComShowCodeMessage('COM12113', 'not Rejected Invoice');
					return;
				}

				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}

				detailInquiry(sheetObject,formObject, 'modify');
				break;

			case "btng_invconfirm":			
				if(checkETS()){
					ComShowCodeMessage('TRS90367');
					return;
				}

				if(checkEDI()){
					return;
				}
				
				if(checkReject()){
					ComShowCodeMessage('COM12113', 'not Rejected Invoice');
					return;
				}

				if(checkManual()){
					ComShowCodeMessage('TRS90347');
					return;
				}

				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}

				doActionIBSheet(sheetObject,formObject,'CONFIRM');
				break;
				
			case "btng_invconfrimcancel":
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				
				for(var i=0; i< checkArray.length-1; i++){	
					if(sheetObject.CellValue(checkArray[i], 'ets_sts_flg') == 'Y'){			
						ComShowCodeMessage('TRS90367');
						return;
					}
				}	
	
				if(checkEDI()){
					return;
				}
				
				if(checkReject()){
					ComShowCodeMessage('COM12113', 'not Rejected Invoice');
					return;
				}

				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}

				doActionIBSheet(sheetObject,formObject,'CONFIRM_CANCEL');
			break;

			case "btng_detailinquiry":
				if(checkRefund()){
					ComShowCodeMessage('COM12113', 'not Refund Invoice');
					return;
				}

				detailInquiry(sheetObject,formObject, 'search');
			break;
			
			case "btn_inv_edi_pdf_view":
				ediPdfFileView(sheetObject,formObject);
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
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObjects[0], false);
	
	//html컨트롤 이벤트초기화
	initControl();
	
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(16);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(45, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				 var HeadTitle = "|Received\nType|Status|Hold|Invoice No|S/P|S/P|W/O Amount|W/O Amount|Exchange\nRate"
								+"|Calculation\nLogic|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount"
								+"|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount|Date|Date|Date|Date|Date|Date|CSR No"
								+"|Payment\nMethod|Check/\nT.T No|Invoice Remark|SPP\nInvoice Remark|Inv Creation|Inv Creation|Inv Update|Inv Update|ETS" ;
                 var HeadTitle1= "|Received\nType|Status|Hold|Invoice No|Code|Name|Currency|Total|Exchange\nRate"
								+"|Calculation\nLogic|Currency|Basic|Surcharge|Invoice Total|VAT|W.H.T|SBC|Total|G.Total|Issue|Received"
								+"|Paid|G/L|Status\nUpdated|Invoice Confirm|CSR No|Payment\nMethod|Check/\nT.T No"
								+"|Invoice Remark|SPP\nInvoice Remark|Office|User ID|User Nm|User ID|ETS" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				HeadRowHeight = 12;

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ ,dtDummyCheck,30,		daCenter,	true,	"ibcheck",				false,		"",	dfNone,		0,	true,	false	);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"if_sys_knd_nm",		false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"trsp_inv_aud_sts_nm",	false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtCheckBox,	60,		daCenter,	true,	"inv_hld_flg",			false,		"",	dfNone,		0,	true,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		true,	"inv_no",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		true,	"inv_vndr_seq",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"inv_vndr_nm",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"curr_cd",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,	"wo_tot_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_xch_rt",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"trsp_inv_calc_lgc_tp_nm",false,	"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_curr_cd",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,	"so_inv_bzc_amt",		false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,	"scg_amt",				false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"inv_bzc_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"inv_vat_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"inv_whld_tax_amt",		false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"inv_sbc_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtHidden,	90,		daCenter,	true,	"inv_tot_amt",			false,		"|inv_bzc_amt|+|scg_amt|",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"inv_ttl_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"inv_iss_dt",			false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"inv_rcv_dt",			false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"pay_dt",				false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"gl_dt",				false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"upd_dt",				false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_cfm_dt",			false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"csr_no",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_pay_mzd_cd",		false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_chk_trns_no",		false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_rmk",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"sp_inv_rmk",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"cre_ofc_cd",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"cre_usr_id",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"upd_usr_nm",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"upd_usr_id",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"ets_sts_flg",			false,		"",	dfNone,		0,	false,	false	);
				
				InitDataProperty(0, cnt++ , dtStatus,    0,		daCenter,	false,	"ibflag"					);
				InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,	"if_sys_knd_cd"				);
				InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,	"trsp_inv_aud_sts_cd"		);
				InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,	"trsp_inv_calc_lgc_tp_cd"	);
				InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,	"cnt_spp"					);
				InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,	"rfnd_flg"					);
				InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,	"abs_scg_amt"				);
				InitDataProperty(0, cnt++ , dtCheckBox,	 0,		daCenter,	true,	"sppCheck"					);
				InitDataProperty(0, cnt++ , dtHidden,	 0,		daCenter,	true,	"file_chk"					);
				
				
				RangeBackColor(1, 11, 1, 23) = RgbColor(222, 251, 248);   // ENIS
				ColHidden('ibflag')							= true;
				ColHidden('sppCheck')						= true;

				HeadRowHeight = 20 ;
				
				ActionMenu = "Header Setting Save|Header Setting Reset|Header Setting Delete";
		   }
			break;

			 case 2:      //sheet1 init
                with (sheetObj) {
				// 높이 설정
//				style.height = GetSheetHeight(13);
				//전체 너비 설정
//				SheetWidth = mainTable.clientWidth;
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = 0;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(47, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				 var HeadTitle = "Received\nType|Status|Hold|Invoice No|Payment S/P|Payment S/P"
								+"|W/O|W/O S/P|W/O S/P|S/O No|BL No|Equipment No|TP / SZ|Unplanned"
								+"|W/O Amount|W/O Amount|W/O Amount|W/O Amount|W/O Amount|W/O Amount|W/O Amount|W/O Amount|Exchange\nRate"
								+"|Calculation\nLogic|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount"
								+"|Invoice Amount|Invoice Amount|Invoice Amount|Invoice Amount"
								+"|Date|Date|Date|Date|Date|CSR No"
								+"|Payment\nMethod|Check/\nT.T No"
								+"|Invoice Remark|SPP\nInvoice Remark|Inv Creation|Inv Creation|Inv Update|Inv Update|ETS" ;

                 var HeadTitle1= "Received\nType|Status|Hold|Invoice No|Code|Name"
								+"|W/O|Code|Name|S/O No|BL No|Equipment No|TP / SZ|Unplanned"
								+"|Currency|Basic|Negotiated|Fuel|Vat|Toll Fee|Additional|Total|Exchange\nRate"
								+"|Calculation\nLogic|Currency|Basic|Surcharge|Total"
								+"|VAT|WHT|SBC|G.Total"
								+"|Issue|Received|Paid|G/L|Status\nUpdated|CSR No"
								+"|Payment\nMethod|Check/\nT.T No"
								+"|Invoice Remark|SPP\nInvoice Remark|Office|User ID|User Nm|User ID|ETS" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				HeadRowHeight = 12;

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"if_sys_knd_nm",		false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"trsp_inv_aud_sts_nm",	false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtCheckBox,	60,		daCenter,	true,	"inv_hld_flg",			false,		"",	dfNone,		0,	true,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"inv_no",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"inv_vndr_seq",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"inv_vndr_nm",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,  "trsp_wo_ofc_cty_cd_seq",false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"vndr_seq",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"vndr_nm",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,  "trsp_so_ofc_cty_cd_seq",false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"bl_no",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"eq_no",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"eq_tpsz_cd",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"upln_so_flg",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"curr_cd",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	"bzc_amt",				false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	"nego_amt",				false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	"fuel_scg_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	"scg_vat_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	"toll_fee_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	"etc_add_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,	"wo_tot_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_xch_rt",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true, "trsp_inv_calc_lgc_tp_nm",false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_curr_cd",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,	"inv_bzc_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daRight,	true,	"inv_etc_add_amt",		false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daRight,	true,	"inv_tot_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daRight,	true,	"inv_vat_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daRight,	true,	"inv_whld_tax_amt",		false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daRight,	true,	"inv_sbc_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daRight,	true,	"inv_gttl_amt",			false,		"",	dfFloat,	2,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"inv_iss_dt",			false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"inv_rcv_dt",			false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"pay_dt",				false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"gl_dt",				false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"upd_dt",				false,		"",	dfDateYmd,	0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"csr_no",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_pay_mzd_cd",		false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_chk_trns_no",		false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"inv_rmk",				false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"sp_inv_rmk",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"cre_ofc_cd",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"cre_usr_id",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"upd_usr_nm",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"upd_usr_id",			false,		"",	dfNone,		0,	false,	false	);
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,	"ets_sts_flg",			false,		"",	dfNone,		0,	false,	false	);
				
				RangeBackColor(1, 11, 1, 23) = RgbColor(222, 251, 248);   // ENIS

				HeadRowHeight = 20 ;
               }
               break;
	}
}

function sheet1_OnSelectMenu(sheetObj, MenuString){
	
	 switch(MenuString){
		case('Header Setting Save'):
			IBS_SaveGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
		
		case('Header Setting Reset'):
			IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
		
		case('Header Setting Delete'):
			IBS_DelGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
		break;
	 }
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			if(ComIsNull(formObj.no_cd)){
	   			if(ComIsNull(formObj.fmdate) || ComIsNull(formObj.todate) || ComIsNull(formObj.inv_cre_ofc)){
	   				ComShowCodeMessage("TRS90124");
					return false;
	   			}	   			
	   		}
	   		var days_between = ComGetDaysBetween(formObj.fmdate , formObj.todate) ;  // 조회 기간
	   		if( days_between   < 0) {
				ComShowCodeMessage("TRS90118");
				formObj.fmdate.focus();
				return false;
			} 
			if ( days_between > 60 ) {
				ComShowMessage(" Possible inquiry period is limited to 2 months.");
				return false;
			}
			
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESD_TRS_0030GS.do", TrsFrmQryString(formObj));
		break;

		case 'invoiceDelete':
			if(!validateForm(sheetObj,formObj,'invoiceDelete')) return;
		
			formObj.f_cmd.value = REMOVE;
			sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'ibcheck',false);
		break;

		case 'CONFIRM':
			if(!validateForm(sheetObj,formObj, sAction)) return;
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'ibcheck',false);
		break;

		case 'CONFIRM_CANCEL':
			if(!validateForm(sheetObj,formObj, sAction)) return;
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'ibcheck',false);
		break;

		case 'HOLD_SAVE':
			formObj.f_cmd.value = MULTI03;
			if(!CheckCreOfcCdForSPP(sheetObj)) return false;
			sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), -1, false);
		break;
			
		case 'USR_ID_SAVE':
			formObj.f_cmd.value = MULTI05;
//			if(!CheckCreOfcCdForSPP(sheetObj)) return false;
			sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'ibcheck', false);
		break;

		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
		break;

		case 'IBDOWNEXCEL2':     //엑셀 다운로드2
			ComOpenWait(true);
			if(!validateForm(sheetObjects[0],formObj, sAction)){
				ComOpenWait(false);
				return;
			}
			formObj.f_cmd.value = SEARCH02;
			var query = sheetObjects[0].GetSaveString(false, true, 'ibcheck');
			sheetObj.DoSearch4Post("ESD_TRS_0030GS.do", query, TrsFrmQryString(formObj), false);
		break;
	}
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == MULTI04){
			var checkList = sheetObj.FindCheckedRow('sppCheck');
			var checkArray = checkList.split('|');

			for(var i=0; i< checkArray.length-1; i++){
				sheetObj.CellValue2(checkArray[i], 'cre_ofc_cd') = formObj.FORM_USR_OFC_CD.value;			
			}
		}else if(formObj.f_cmd.value == MULTI03){
			ComShowCodeMessage('TRS90057');
			setDisabled('CONFIRM');
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}else if(formObj.f_cmd.value == MULTI02){
			ComShowCodeMessage('TRS90330');
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}else if(formObj.f_cmd.value == MULTI01){
			ComShowCodeMessage('TRS90056');
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}else if(formObj.f_cmd.value == MULTI05){
			ComShowCodeMessage('TRS90511');
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}else if(formObj.f_cmd.value == REMOVE){
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			for(var k=checkArray.length-2; k>=0; k--)
			{
				sheetObj.RowDelete(checkArray[k], false);
			}
			ComShowCodeMessage('TRS90331');
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
	}
}
/**
 * onclick event처리
 * @param sheetObj
 * @return
 */
function sheet1_OnClick(sheetObj){
	/** HKGSC Invoice EDI PDF File view Button Control */
	btnCtrlEdiView(sheetObj);
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case 'detailInquiry_modify':
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}else if(checkArray.length > 2){
				ComShowCodeMessage("COM12113", 'only one row');
				return false;
			}
			
			var stu_cd = '';
			for(var k=0; k<checkArray.length-1; k++)
			{
				stu_cd = sheetObj.CellValue(checkArray[k], 'trsp_inv_aud_sts_cd');
				if(stu_cd != 'RC' && stu_cd != 'SV'){
					ComShowCodeMessage('TRS90059');
					return false;
				}
			}
			
		//	if(!CheckCreOfcCdForSPP(sheetObj)) return false;
			
			break;

		case 'detailInquiry_search':
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}else if(checkArray.length > 2){
				ComShowCodeMessage("COM12113", 'only one row');
				return false;
			}
			break;

		case 'invoiceDelete':
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}

			if(!CheckCreOfcCdForSPP(sheetObj)) return false;

			for(var k=0; k<checkArray.length-1; k++)
			{

				if(sheetObj.CellValue(checkArray[k], 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value){
					ComShowCodeMessage('TRS90323');
					return false;
				}

				var stu_cd = sheetObj.CellValue(checkArray[k], 'trsp_inv_aud_sts_cd');
				if(stu_cd != 'RC' && stu_cd != 'SV' && stu_cd != 'CF'){
					ComShowCodeMessage('TRS90058');
					return false;
				}
			}
			break;

		case 'CONFIRM':
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');

			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}

			if(!CheckCreOfcCdForSPP(sheetObj)) return false;

			for(var k=0; k<checkArray.length-1; k++)
			{
				if(sheetObj.CellValue(checkArray[k], 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value){
					ComShowCodeMessage('TRS90323');
					return false;
				}

				var stu_cd = sheetObj.CellValue(checkArray[k], 'trsp_inv_aud_sts_cd');
				if(stu_cd != 'RC' && stu_cd != 'SV'){
					ComShowCodeMessage('TRS90042');
					return false;
				}
				
				if(Number(sheetObj.CellValue(checkArray[k], 'abs_scg_amt')) > 0){
					ComShowCodeMessage('TRS90348',sheetObj.CellValue(checkArray[k], 'inv_no'));
					return false;
				}
			}
			break;

		case 'CONFIRM_CANCEL':
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}

			if(!CheckCreOfcCdForSPP(sheetObj)) return false;

			for(var k=0; k<checkArray.length-1; k++)
			{
				var stu_cd = sheetObj.CellValue(checkArray[k], 'trsp_inv_aud_sts_cd');

				if(sheetObj.CellValue(checkArray[k], 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value){
					ComShowCodeMessage('TRS90323');
					return false;
				}

				if(stu_cd != 'CF'){
					ComShowCodeMessage('TRS90041');
					return false;
				}
			}
			break;

		case 'IBDOWNEXCEL2':     //엑셀 다운로드2
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');
			if(checkList == ''){
				ComShowCodeMessage('COM12176');
				return false;
			}
			break;
	}
	return true;
}

/**
  * 저장결과가 오류가 발생했을 때 공통처리하는 함수
  * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var rowCount = sheetObj.rowcount;
	var value = null;
	var curr_cd = null;
	var inv_curr_cd = null;
	var wo_tot_amt = null;
	var inv_bzc_amt = null;
//	var inv_tot_amt = 0;   //1.8에 추가된부분
//	var inv_ttl_amt = 0;   //1.8에 추가된부분
	for(var i=2; i<rowCount+2; i++){
		value = sheetObj.CellValue(i, 'if_sys_knd_cd');
		curr_cd = sheetObj.CellValue(i, 'curr_cd');
		inv_curr_cd = sheetObj.CellValue(i, 'inv_curr_cd');
		wo_tot_amt = sheetObj.CellValue(i, 'wo_tot_amt');
		inv_bzc_amt = sheetObj.CellValue(i, 'inv_bzc_amt');
		
//		inv_tot_amt = sheetObj.CellValue(i, 'inv_tot_amt'); //1.8에 추가된부분
//		inv_ttl_amt = sheetObj.CellValue(i, 'inv_ttl_amt'); //1.8에 추가된부분
		
		if(value == 'I' && (curr_cd != inv_curr_cd || wo_tot_amt != inv_bzc_amt) ){
			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
		}
//??		if(value == 'I' && (curr_cd != inv_curr_cd || inv_tot_amt != inv_ttl_amt) ){
//??			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
//??		}
	}
	/** HKGSC Invoice EDI PDF File view Button Control */
	btnCtrlEdiView(sheetObj);
}
 
/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != '' ) {
		if(formObj.f_cmd.value == SEARCH02){
			ComOpenWait(false);
		}
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == SEARCH02){
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
		}
	}
}

/**
 * MInimize 클릭시 이벤트 관련
 */
function Minimize(nItem)
{
	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(18);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =20;
	}
	else
	{
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(13);
		sheetObjects[0].focus();
		sheetObjects[0].ViewRows  =10;
	}
}

/**
 * rep_commodity팝업호출
 */
function rep_Multiful_inquiry(val)
{
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getTRS_ENS_906";
		var xx1=val;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var title = val;
		
		if (val == "btns_no_cd" ) {
			if(formObject.no_tp[0].checked)  {
				title = "Invoice No.";
			} else {
				title = "CSR No.";
			}
		}
		
		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

function print_excel(sheetObj){
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	
	var inv_no = new Array();
	var inv_vndr_seq = new Array();
    var queryStr = 'AND A.INV_VNDR_SEQ =';
	
	for(var k=0; k<checkArray.length-1; k++)
	{
		if(k==0){
			queryStr += sheetObjects[0].CellValue(checkArray[k],'inv_vndr_seq')+" AND A.INV_NO IN (";
		}else{
			queryStr += ", ";
		}
		queryStr += "'"+sheetObjects[0].CellValue(checkArray[k],'inv_no')+"'";
		
		if(k==checkArray.length-2){
			queryStr += ") ";
		}
	}
	
//	var param ='?inv_no='+inv_no+'&inv_vndr_seq='+inv_vndr_seq;
	var form = document.esd_030rd_form;
	
	form.queryStr.value = queryStr;
	
	//ComOpenWindow('ESD_TRS_0208.do','rdObjModal','width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0', false);
	ComPostOpenWindow("ESD_TRS_0208.do", "ReportDesignerCommonPopup", "width=775,height=720,menubar=0,status=0,scrollbars=0,resizable=0");
	form.target = 'ReportDesignerCommonPopup';
	form.submit();
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,returnval) {
	var formObject = document.form;
	
	if(returnval=="btns_no_cd") {
		var x1=formObject.no_cd.value;
		if(x1==""){
			formObject.no_cd.value = rowArray;
			formObject.no_cd.focus();
		}else{
			formObject.no_cd.value = formObject.no_cd.value+","+rowArray;
			formObject.no_cd.focus();
		}
	} else if(returnval=="Office Code") {
		var x2=formObject.inv_cre_ofc.value;
		if(x2==""){
			formObject.inv_cre_ofc.value = rowArray;
			formObject.inv_cre_ofc.focus();
		}else{
			formObject.inv_cre_ofc.value = formObject.inv_cre_ofc.value+","+rowArray;
			formObject.inv_cre_ofc.focus();
		}
	}
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

		var param	="?conti_cd="+xx1
					+"&sconti_cd="+xx2
					+"&cnt_cd="+xx3
					+"&loc_state="+xx4
					+"&loc_eq_ofc="+xx5
					+"&loc_cd="+xx6
					+"&loc_desc="+xx7
					+"&loc_port_ind="+xx8
					+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do'+param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
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
		
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
}

/**
 * Invoice Audit에서 조회 or Collection이 가능하다.
 */
function detailInquiry(sheetObj, formObj, mode){

//05.01 mail subject - FW: Invoice Inquiry 화면 권한 관련 -에 의거 수정
	
	if(!validateForm(sheetObj,formObj,'detailInquiry_'+mode)) return false;
	
	/*---orignal----
	if(sheetObj.CellValue(sheetObj.SelectRow, 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value){
		ComShowCodeMessage('TRS90323');
		return false;
	}
	
	*/
	/*
	alert(sheetObj.CellValue(sheetObj.SelectRow, 'if_sys_knd_cd')+"\n"
			+sheetObj.CellValue(sheetObj.SelectRow, 'cnt_spp'));*/
	
	var	rcv_tp_cd = sheetObj.CellValue(sheetObj.SelectRow, 'if_sys_knd_cd');
	//Invoice Office Check
	var	value = isNaN(Number(sheetObj.CellValue(sheetObj.SelectRow, 'cnt_spp')))?0:Number(sheetObj.CellValue(sheetObj.SelectRow, 'cnt_spp'));
	
	if(rcv_tp_cd =='W'){
		if(value == 0){
			ComShowCodeMessage('TRS90323');
			return ;
		}
	}else{
		if(sheetObj.CellValue(sheetObj.SelectRow, 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value){
			ComShowCodeMessage('TRS90323');
			return ;
		}
	}
	
	//inv_audit_YN='Y';
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var v_mode = mode;

	var invForm = document.inv_form;
	invForm.inv_no.value = sheetObj.CellValue(checkArray[0], 'inv_no');
	invForm.inv_vndr_seq.value = sheetObj.CellValue(checkArray[0], 'inv_vndr_seq');
	invForm.mode.value = mode;
	invForm.if_sys_knd_cd_param.value =  sheetObj.CellValue(checkArray[0], 'if_sys_knd_cd');

	if(mode == 'modify'){
		//Invoice Audit버튼 클릭시 팝업화면 띄움.
		ComPostOpenWindow("ESD_TRS_0033.do", "AuditConfirmPopup", "width=1024,height=675,menubar=0,status=0,scrollbars=1,resizable=0");
		invForm.target = 'AuditConfirmPopup';
		invForm.submit();
	}else{
		invForm.target = '';
		invForm.submit();
	}
}

/*function pUpdateCreOfcCdForSPP(){
	var sheetObj=sheetObjects[0];
	
	var formObj = document.form;
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var isUpdate = false;

	if(checkList == ''){
		return;
	}
	var value = null;
	var rcv_tp_cd = null;
	var row = 0;

	sheetObj.CheckAll2('sppCheck') = 0;

	for(var i=0; i<checkArray.length-1; i++){
		row = checkArray[i];
		value = isNaN(Number(sheetObj.CellValue(row, 'cnt_spp')))?0:Number(sheetObj.CellValue(row, 'cnt_spp'));
		rcv_tp_cd = sheetObj.CellValue(row, 'if_sys_knd_cd');
		if(rcv_tp_cd == 'W' && value > 0 
					&& sheetObj.CellValue(row, 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value) {
			sheetObj.CellValue2(row, 'sppCheck') = 1;
			isUpdate = true;
		}
	}

	if(isUpdate){
		formObj.f_cmd.value = MULTI04;
		sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'sppCheck',false);
	}
}*/

function closeRetrieveOpener(){
	var sheetObj=sheetObjects[0];
	var formObj = document.form;
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}

/**
 * 조회조건을 초기화한다.
 */
function resetSearchCondition(formObj){
	
	formObj.reset();
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
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
			case 'inv_cre_ofc':
			case 'ivc_upd_usr_id':
				value_upper(obj);
			case 'no_cd':
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
		}
	}
}

/**
 * Include Office를 처리하기 위한 Logic
 */
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

/**
 * Include Check Bok를 Click했을 때
 */
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.inv_cre_ofc.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.inv_cre_ofc.value = "";
		ComShowMessage("Please input the 'Invoice Creation Office'!!");
//		document.form.inv_cre_ofc.disabled = false;
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
//		document.form.inv_cre_ofc.disabled = true;
	} else {
		document.form.inv_cre_ofc.value = document.form.old_ofc_cd.value;
		document.form.inv_cre_ofc.disabled = false;
	}
}

/**
 * Office의 값을 가지고 온다.
 */
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.inv_cre_ofc.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}

/**
 * CRE_OFC_CD = OFC_CD인 경우에만 AUDIT, CONFIRM, DETAIL INQUIRY가능.
 * 예외 WIS & RCV상태 건에 대해서는 AUDIT, CONFIRM을 INV_OFC가 해야 하며
 * , 이때 CRE_OFC_CD가 작업한 사용자의 OFC_CD로 변경 후 위 RULE적용
 */
function CheckCreOfcCdForSPP(sheetObj){
	var formObj = document.form;
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var isUpdate = false;

	if(checkList == ''){
		return false;
	}
	var value = null;
	var rcv_tp_cd = null;
	var row = 0;

	sheetObj.CheckAll2('sppCheck') = 0;

	for(var i=0; i<checkArray.length-1; i++){
		row = checkArray[i];
		value = isNaN(Number(sheetObj.CellValue(row, 'cnt_spp')))?0:Number(sheetObj.CellValue(row, 'cnt_spp'));
		rcv_tp_cd = sheetObj.CellValue(row, 'if_sys_knd_cd');
		if( rcv_tp_cd == 'W' && value == 0 ){
			ComShowCodeMessage('TRS90323');
			return false;
		}

		if(rcv_tp_cd == 'W' && value > 0 
					&& sheetObj.CellValue(row, 'cre_ofc_cd') != formObj.FORM_USR_OFC_CD.value) {
			sheetObj.CellValue2(row, 'sppCheck') = 1;
			isUpdate = true;
		}
	}

	if(isUpdate){
		formObj.f_cmd.value = MULTI04;
		sheetObj.DoSave("ESD_TRS_0030GS.do", TrsFrmQryString(formObj), 'sppCheck',false);
	}

	return true;
}

function checkRefund(){

	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var value = null;
	var returnFlag = false;

	for(var i=0; i<checkArray.length-1; i++){
		
		value = sheetObj.CellValue(checkArray[i], 'rfnd_flg');
		if(value == 'Y'){
			returnFlag = true;
			break;
		}
	}
	return returnFlag;
}

function checkInvVndrSeq(){

	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var value = null;
	var preValue = null;
	var returnFlag = false;
	
	for(var i=0; i<checkArray.length-1; i++){
		
		if(i>0){
			preValue = sheetObj.CellValue(checkArray[i-1], 'inv_vndr_seq');
			value = sheetObj.CellValue(checkArray[i], 'inv_vndr_seq');
		}
		if(preValue != value){
			returnFlag = true;
			break;
		}
	}
	return returnFlag;
}

function checkManual(){

	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var value = null;
	var returnFlag = false;

	for(var i=0; i<checkArray.length-1; i++){
		
		value = sheetObj.CellValue(checkArray[i], 'if_sys_knd_cd');
		if(value == 'E'){
			returnFlag = true;
			break;
		}
	}
	return returnFlag;
}

function checkReject(){

	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var value = null;
	var returnFlag = false;

	for(var i=0; i<checkArray.length-1; i++){
		
		value = sheetObj.CellValue(checkArray[i], 'trsp_inv_aud_sts_cd');
		if(value == 'RJ'){
			returnFlag = true;
			break;
		}
	}
	return returnFlag;
}

function checkETS(){

	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var value = null;
	var returnFlag = false;

	for(var i=0; i<checkArray.length-1; i++){
		
		value = sheetObj.CellValue(checkArray[i], 'ets_sts_flg');
		if(value == 'Y'){
			returnFlag = true;
			break;
		}
	}
	return returnFlag;
}

function checkEDI(){

	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var value = null;
	var curr_cd = null;
	var inv_curr_cd = null;
	var wo_tot_amt = null;
	var inv_bzc_amt = null;
	var inv_tot_amt = null;
	var inv_ttl_amt = null;

	var returnFlag = false;

	for(var i=0; i<checkArray.length-1; i++){
		
		value = sheetObj.CellValue(checkArray[i], 'if_sys_knd_cd');
		curr_cd = sheetObj.CellValue(checkArray[i], 'curr_cd');
		inv_curr_cd = sheetObj.CellValue(checkArray[i], 'inv_curr_cd');
		wo_tot_amt = sheetObj.CellValue(checkArray[i], 'wo_tot_amt');
		inv_bzc_amt = sheetObj.CellValue(checkArray[i], 'inv_bzc_amt');
		inv_tot_amt = sheetObj.CellValue(checkArray[i], 'inv_tot_amt');
		inv_ttl_amt = sheetObj.CellValue(checkArray[i], 'inv_ttl_amt');

		if(value == 'I' && (curr_cd != inv_curr_cd || wo_tot_amt != inv_bzc_amt) ){
			ComShowCodeMessage('TRS90397');
			returnFlag = true;
			break;
		}
		if(value == 'I' && (curr_cd != inv_curr_cd || inv_tot_amt != inv_ttl_amt) ){
			ComShowCodeMessage('TRS90035');
			returnFlag = true;
			break;
		}
	}
	return returnFlag;
}

/**
 * EDI Invoice View Button cotrol 
 * @param sheetObj
 */
function btnCtrlEdiView(sheetObj){
	var invCreOfcCd = sheetObj.CellValue(sheetObj.SelectRow,'cre_ofc_cd');
	var ifSysKndCd = sheetObj.CellValue(sheetObj.SelectRow,'if_sys_knd_cd');
	var fileChk = sheetObj.CellValue(sheetObj.SelectRow,'file_chk');
	/** HKGSC Invoice EDI PDF File view Button Control */
	if (invCreOfcCd = 'HKGSC' && ifSysKndCd == 'I' && fileChk == 'Y') {
		document.all.invEdiPdfViewLayer.style.display = "inline";
	} else {
		document.all.invEdiPdfViewLayer.style.display = "none";
	}
}

/***
 * Open EDI Invoice View PopUp
 * @param sheetObj
 * @param formObj
 */

function ediPdfFileView(sheetObj,formObj){
	var url_str = 'ESD_TRS_0330.screen';
		url_str += '?inv_no='+sheetObj.CellValue(sheetObj.SelectRow,'inv_no');
		url_str += '&inv_vndr_seq='+sheetObj.CellValue(sheetObj.SelectRow,'inv_vndr_seq');
	window.showModalDialog(url_str, window, "dialogWidth:1050px; dialogHeight:970px; help:no; status:no; resizable:yes;");
	
}