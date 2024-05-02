/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0961.js
*@FileTitle : S/P select Pop-up 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.13
*@LastModifier : Sun, Choi
*@LastVersion : 1.3
* 2006-11-21 poong_yeon
* 1.0 최초 생성 
* 1.1 CHM-200900431 Customer Code 입력가능요청(09.08.24)
* 1.2 2010.09.09 이재위 [SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
* 1.3 2010.09.13 Sun, Choi S/P Code 입력 POP-UP open 시, control office code param 변경
* 1.4 2010.12.28 민정호 [CHM-201008042] AGMT 적용시 Customer Nominated 적용
* 2011.05.06  손은주 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.07.03 김영철 [CHM-201111873] 2011.07.14 김영철 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청 - SO화면에서 Bundling Data를 보여줌.
=========================================================*/ 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0961 : SP SELECT Popup
 */
function ESD_TRS_0961() {
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
var defaultLoginOfficeCurr = '';
var docObjects = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject = sheetObjects[0];

	 /*******************************************************/
	 var formObject = document.form;


	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_ok":
				  doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
			  break;

			case "btn_close":
				  window.close();
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
 * Customor code를 설정한다.
 */
//* 1.19 CHM-200900431 Customer Code 입력가능요청(09.08.24) 
function custCode(){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
		
	sheetObjects[0].CellValue(1, 'cust_cnt_cd_seq') = formObj.cust_cnt_cd_seq.value;
}

/**
 * 로그인한 사용자의 OFC CD Default Currency를 설정한다.
 */
function initCurrency(){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	formObj.f_cmd.value = SEARCH01;
	sheetObj.DoRowSearch("ESD_TRS_0921GS.do", TrsFrmQryString(formObj));
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	sheetObjects[0].DataInsert();
	initCurrency();
//  2010.12.28 이 화면은 단순히 입력창이므로 필요없음.	
//	custCode();		
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var formObj = document.form;
	var wo_radio_flg = true;
	if(formObj.wo_radio.value == 'Y') wo_radio_flg = false;

	switch(sheetNo) {
		case 1:      //t1sheet1 init
			with (sheetObj) {
				style.height=GetSheetHeight(7);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1,10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				var HeadTitle = "S/P\nCode|S/P\nName|HAZMAT\n(DG)|Over\nweight|One Way/\nRound Trip|CNT|Customer\nCode|Default\nCurrency|Effective\nDate|Feeder Term\n(RCV / DEL)|Feeder Term\n(RCV / DEL)";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtPopupEdit,  70,  daCenter,  false,    "vndr_seq",    		false,          "",       dfNone,   		0,     wo_radio_flg,      wo_radio_flg);
				InitDataProperty(0, cnt++ , dtData,       90,  daLeft,    false,    "vndr_nm",     		false,          "",       dfNone,   		2,     false,   	false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  false,    "hzd_mtrl_flg", 	false,          "",       dfNone,   		0,     false,      	false);
				InitDataProperty(0, cnt++ , dtData,       60,  daCenter,  false,    "ovwt_tri_axl_flg",	false,          "",       dfNone,   		0,     false,      	false);
				InitDataProperty(0, cnt++ , dtCombo,      90,  daCenter,  false,    "po_way_type", 		false,          "",       dfNone,   		0,     true,      	true);
				InitDataProperty(0, cnt++ , dtCombo,      50,  daCenter,  false,    "sp_type",     		false,          "",       dfNone,   		0,     true,      	true);
				InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  false,    "cust_cnt_cd_seq",  false,  		"",       dfNone,   		0,     true,      	true);
				InitDataProperty(0, cnt++ , dtCombo,      70,  daCenter,  false,    "default_curr",     false,          "",       dfNone,   		0,     true,      	true);
				InitDataProperty(0, cnt++ , dtData,  	  80,  daCenter,  false,    "eff_dt",     		false,          "",       dfDateYmd,   		0,     true,      	true);
				InitDataProperty(0, cnt++ , dtCombo,      55,  daCenter,  false,    "ft_receiving",     false,          "",       dfNone,   		0,     true,      	true);
				InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter,  false,    "ft_delivery",     	false,          "",       dfNone,   		0,     true,      	true);
				InitDataProperty(0, cnt++ , dtStatus,      0,  daCenter,   true,    "ibflag");
				
				ColHidden('ibflag')							= true;
				//InitDataCombo(0, 'po_way_type',  " |"+po_way_typeText, " |"+po_way_typeCode);
				InitDataCombo(0, 'po_way_type', " |One Way(CY rate)|Round Trip(DR rate)", " |ONE|RND");
				//InitDataCombo(0, 'sp_type', sp_typeText, sp_typeCode);
				InitDataCombo(0, 'default_curr', default_currText, default_currCode);
				InitDataCombo(0, 'ft_receiving', ft_receivingText, ft_receivingCode);
				InitDataCombo(0, 'ft_delivery', ft_deliveryText, ft_deliveryCode);
				InitDataCombo(0, 'sp_type',    "SML|CNT|CPT|HPT",    "HJS|CNT|CPT|HPT");
			}
			break;

		case 2:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height=0
				//전체 너비 설정
				SheetWidth = 0

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(31, 7, 0, true);  //24

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "flag|cty|seq";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,    0,   daCenter,   true,    "ibflag");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "trsp_so_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "trsp_so_seq");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_trsp_agmt_ofc_cty_cd");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_trsp_agmt_seq");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_trsp_agmt_rt_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_way_type");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_trsp_agmt_rt_tp_nm");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_sp_type");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_cust_nomi_trkr_flg");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_cust_cnt_cd");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_cust_seq");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_local_curr_cd");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_basic_rt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_fuel_scg_rt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_vat_scg_rt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_scg1_rt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_scg2_rt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_scg3_rt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "toll_fee_amt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_over_wgt_scg_rt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_local_curr_tot_amt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_usd_curr_tot_amt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_rtn_cd");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_rtn_msg");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_wtr_rcv_term_cd");  //2011.10.18 이수진 추가
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_wtr_de_term_cd");
				
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_cfm_flg");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_agmt_rt_seq");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_agmt_upd_dt");
				InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   true,    "po_cust_nomi_trkr_ind_cd");

				ColHidden('ibflag')							= true;
			}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:      //조회

			if(!validateForm(sheetObjects[0],formObj,sAction)) return;
			var open_SheetObj = opener.sheetObjects[0];
			var queryStr = open_SheetObj.GetSaveString(false, true, 'ibcheck');
			sheetObj.DoSearch4Post('ESD_TRS_0969.screen',queryStr,'', true);
			this.focus();
			if(sheetObjects[0].CellValue(1, 'sp_type') == 'CNT' && sheetObjects[0].CellValue(1, 'cust_cnt_cd_seq') == ''){
				ComShowMessage("Please input Customer code for CNT")
				break;
			};
			var cust_cnt_cd = (sheetObjects[0].CellValue(1, 'cust_cnt_cd_seq')).substring(0,2);
			var cust_seq = (sheetObjects[0].CellValue(1, 'cust_cnt_cd_seq')).substring(2,8);			
			formObj.f_cmd.value = SEARCH02;
			formObj.WY_TP_CD.value = sheetObjects[0].CellValue(1, 'po_way_type');
			formObj.SP_TP_CD.value = sheetObjects[0].CellValue(1, 'sp_type');
			formObj.CUST_CNT_CD.value = cust_cnt_cd;
			formObj.CUST_SEQ.value = cust_seq;
			formObj.VNDR_CD.value = sheetObjects[0].CellValue(1, 'vndr_seq');
			formObj.BASIS_DT.value = sheetObjects[0].CellValue(1, 'eff_dt');
			formObj.WTR_RCV_TERM.value = sheetObjects[0].CellValue(1, 'ft_receiving');
			formObj.WTR_DE_TERM.value = sheetObjects[0].CellValue(1, 'ft_delivery');
			sheetObj.DoAllSave("ESD_TRS_0023GS.do", TrsFrmQryString(formObj));
	
			break;			
	}
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		/* 로그인한 사용자의 OFFICE CD에 해당되는 CURRENCY로 설정한다. */
		if(formObj.f_cmd.value == SEARCH01){
			var conti_cd = sheetObj.EtcData('conti_cd');
			var bil_curr_cd = sheetObj.EtcData('bil_curr_cd');
//			if(conti_cd=='M') { 
//				sheetObj.CellValue2(1, 'po_way_type') = 'RND';
//			}
			sheetObj.CellValue2(1, 'default_curr') = bil_curr_cd;
			defaultLoginOfficeCurr = bil_curr_cd;
		}
	}
}


/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	var sheetObj1 = sheetObjects[0];
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		var open_SheetObj = opener.sheetObjects[0];

		if(sheetObj.RowCount < 1){
			ComShowCodeMessage('TRS90132');
			return;
		}
		
		var checkList = open_SheetObj.FindCheckedRow('ibcheck');
		var checkArray = checkList.split('|');
		var value1 = '';
		var value2 = '';
		var result = 0;
		var isSearch = false;

		for(var i=0; i<checkArray.length-1; i++)
		{
			value1 = open_SheetObj.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd')+
						open_SheetObj.CellValue(checkArray[i], 'trsp_so_seq');
			isSearch = false;

			for(var k=1; k< sheetObj.RowCount+1; k++){
				value2 = sheetObj.CellValue(k, 'trsp_so_ofc_cty_cd')+
							sheetObj.CellValue(k, 'trsp_so_seq');
				if(value1 == value2){
					var spType = sheetObj.CellValue(k, 'po_sp_type');
					//var poSpType = "Y";
					//if(spType == "HJS"){
					//	poSpType = "N";
					//}

					open_SheetObj.CellValue2(checkArray[i], 'po_cust_cnt_cd') 			= sheetObj.CellValue(k, 'po_cust_cnt_cd');
					open_SheetObj.CellValue2(checkArray[i], 'po_cust_seq') 				= sheetObj.CellValue(k, 'po_cust_seq');
					open_SheetObj.CellValue2(checkArray[i], 'po_local_curr_cd') 		= sheetObj.CellValue(k, 'po_local_curr_cd');
					open_SheetObj.CellValue2(checkArray[i], 'po_trsp_agmt_ofc_cty_cd') 	= sheetObj.CellValue(k, 'po_trsp_agmt_ofc_cty_cd');
					open_SheetObj.CellValue2(checkArray[i], 'po_trsp_agmt_seq') 		= sheetObj.CellValue(k, 'po_trsp_agmt_seq');
					open_SheetObj.CellValue2(checkArray[i], 'po_trsp_agmt_rt_tp_cd') 	= sheetObj.CellValue(k, 'po_trsp_agmt_rt_tp_cd');
					open_SheetObj.CellValue2(checkArray[i], 'po_way_type') 				= sheetObj.CellValue(k, 'po_way_type');
					open_SheetObj.CellValue2(checkArray[i], 'po_trsp_agmt_rt_tp_nm') 	= sheetObj.CellValue(k, 'po_trsp_agmt_rt_tp_nm');					
					open_SheetObj.CellValue2(checkArray[i], 'po_sp_type')				= spType;
					if(sheetObj.CellValue(k, 'po_trsp_agmt_ofc_cty_cd') == ""){
						open_SheetObj.CellValue2(checkArray[i], 'po_cust_nomi_trkr_ind_cd')	= "";
					}
					else{
						open_SheetObj.CellValue2(checkArray[i], 'po_cust_nomi_trkr_ind_cd')	= sheetObj.CellValue(k, 'po_cust_nomi_trkr_ind_cd');
					}
					open_SheetObj.CellValue2(checkArray[i], 'po_cust_nomi_trkr_flg') 	= sheetObj.CellValue(k, 'po_cust_nomi_trkr_flg');	
					
					if ( open_SheetObj.CellValue(checkArray[i], 'mcntr_bdl_grp_seq') != "" && 
						 open_SheetObj.CellValue(checkArray[i], 'mcntr_bdl_grp_seq') != null ) {
						if ( open_SheetObj.CellValue(checkArray[i], 'mcntr_bdl_seq') != "1" ) {	
							if(ComTrim(sheetObj.CellValue(k, 'po_trsp_agmt_seq')) != ''){
								isSearch = true;
								result++;
							}
							sheetObj.RowDelete(k, false);
							break;
						}
					}
					open_SheetObj.CellValue2(checkArray[i], 'po_basic_rt') 			= sheetObj.CellValue(k, 'po_basic_rt');
					open_SheetObj.CellValue2(checkArray[i], 'po_fuel_scg_rt') 		= sheetObj.CellValue(k, 'po_fuel_scg_rt');
					open_SheetObj.CellValue2(checkArray[i], 'po_vat_scg_rt') 		= sheetObj.CellValue(k, 'po_vat_scg_rt');
					open_SheetObj.CellValue2(checkArray[i], 'po_scg1_rt')			= sheetObj.CellValue(k, 'po_scg1_rt');
					open_SheetObj.CellValue2(checkArray[i], 'toll_fee_amt') 		= sheetObj.CellValue(k, 'toll_fee_amt');
					open_SheetObj.CellValue2(checkArray[i], 'po_scg3_rt') 			= sheetObj.CellValue(k, 'po_scg3_rt');
					open_SheetObj.CellValue2(checkArray[i], 'po_over_wgt_scg_rt') 	= sheetObj.CellValue(k, 'po_over_wgt_scg_rt');
					open_SheetObj.CellValue2(checkArray[i], 'po_local_curr_tot_amt')= sheetObj.CellValue(k, 'po_local_curr_tot_amt');
					open_SheetObj.CellValue2(checkArray[i], 'po_usd_curr_tot_amt') 	= sheetObj.CellValue(k, 'po_usd_curr_tot_amt');
					open_SheetObj.CellValue2(checkArray[i], 'po_rtn_cd') 			= sheetObj.CellValue(k, 'po_rtn_cd');
					open_SheetObj.CellValue2(checkArray[i], 'po_rtn_msg') 			= sheetObj.CellValue(k, 'po_rtn_msg');
					open_SheetObj.CellValue2(checkArray[i], 'po_wtr_rcv_term_cd') 	= sheetObj.CellValue(k, 'po_wtr_rcv_term_cd'); //2011.10.18 이수진 추가
					open_SheetObj.CellValue2(checkArray[i], 'po_wtr_de_term_cd') 	= sheetObj.CellValue(k, 'po_wtr_de_term_cd');

					open_SheetObj.CellValue2(checkArray[i], 'po_cfm_flg') 		= sheetObj.CellValue(k, 'po_cfm_flg');
					open_SheetObj.CellValue2(checkArray[i], 'po_agmt_rt_seq') 	= sheetObj.CellValue(k, 'po_agmt_rt_seq');
					open_SheetObj.CellValue2(checkArray[i], 'po_agmt_upd_dt') 	= sheetObj.CellValue(k, 'po_agmt_upd_dt');

					if (sheetObj.CellValue(k, 'po_cfm_flg') == 'N') {
						open_SheetObj.RowFontColor(checkArray[i]) = sheetObj.RgbColor(163, 73, 164);
					}else if (sheetObj.CellValue(k, 'po_cfm_flg') == 'Y') {
						open_SheetObj.RowFontColor(checkArray[i]) = sheetObj.RgbColor(0, 0, 0);
					}
					
					if(ComTrim(sheetObj.CellValue(k, 'po_trsp_agmt_seq')) != ''){
						isSearch = true;
						result++;
					}
					sheetObj.RowDelete(k, false);
					break;
				}
			}
			
			if(formObj.wo_radio.value != 'Y'){
				open_SheetObj.CellValue2(checkArray[i], 'vndr_seq') 		= sheetObj1.CellValue(1, 'vndr_seq');
				open_SheetObj.CellValue2(checkArray[i], 'vndr_nm') 			= sheetObj1.CellValue(1, 'vndr_nm');
				open_SheetObj.CellValue2(checkArray[i], 'hzd_mtrl_flg') 	= sheetObj1.CellValue(1, 'hzd_mtrl_flg');
				open_SheetObj.CellValue2(checkArray[i], 'ovwt_tri_axl_flg') = sheetObj1.CellValue(1, 'ovwt_tri_axl_flg');
								
				if(sheetObj1.CellValue(1, 'cust_cnt_cd_seq').length > 0){
					open_SheetObj.CellValue2(checkArray[i], 'po_sp_type') 			= "Y";
					open_SheetObj.CellValue2(checkArray[i],	'po_cust_nomi_trkr_flg')= "Y";
					open_SheetObj.CellValue2(checkArray[i], 'cust_cnt_cd_seq') 		= sheetObj1.CellValue(1, 'cust_cnt_cd_seq');
					open_SheetObj.CellValue2(checkArray[i], 'po_cust_cnt_cd') 		= sheetObj1.CellValue(1, 'cust_cnt_cd_seq').substring(0,2);
					open_SheetObj.CellValue2(checkArray[i], 'po_cust_seq') 			= sheetObj1.CellValue(1, 'cust_cnt_cd_seq').substring(2,8);	
				}else{
					open_SheetObj.CellValue2(checkArray[i], 'po_sp_type') 			= "N"; 
					open_SheetObj.CellValue2(checkArray[i],	'po_cust_nomi_trkr_flg')= "N"; 						
					open_SheetObj.CellValue2(checkArray[i], 'cust_cnt_cd_seq') 		= "";
					open_SheetObj.CellValue2(checkArray[i], 'po_cust_cnt_cd') 		= "";
					open_SheetObj.CellValue2(checkArray[i], 'po_cust_seq') 			= "";	
				}
			}

			if(!isSearch) {
				open_SheetObj.CellValue(checkArray[i], 'po_local_curr_cd') = sheetObj1.CellValue(1, 'default_curr');
			}
		}
		if(result < 1) ComShowCodeMessage('TRS90132');
		else {
			ComShowCodeMessage('TRS90216')+' ['+result+'/'+(checkArray.length-1)+']';
		}
		self.close();
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){

	if (formObj.wo_radio.value != 'Y' && (sheetObj.CellValue(1, 'vndr_seq')==undefined || sheetObj.CellValue(1, 'vndr_seq') == '')) {
		ComShowCodeMessage('COM12114','vendor');
		sheetObj.SelectCell(1, 'vndr_seq');
		return false;
	}else if (sheetObj.CellValue(1, 'sp_type')==undefined || sheetObj.CellValue(1, 'sp_type') == '') {
		ComShowCodeMessage('COM12114','service provider type');
		sheetObj.SelectCell(1, 'sp_type');
		return false;
	}else if (sheetObj.CellValue(1, 'sp_type')!="HJS" && sheetObj.CellValue(1, 'cust_cnt_cd_seq') == '') {
		ComShowCodeMessage('COM12114','Customer');
		sheetObj.SelectCell(1, 'sp_type');
		return false;	
	}
	return true;
}


function sheet1_OnPopupClick (sheetObj , row , col )
{
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.CellValue(row, colName);

	switch(colName)
	{
		case('vndr_seq'):
			rep_OnPopupClick();
		break;
	}
}

/**
 * sheet의 OnChange 이벤트 정의
 */
function sheet1_OnChange(sheetObj, row, col, value)
{
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.CellValue(row, colName);

	switch(colName)
	{
		case('vndr_seq'):
			//Vendor Code Validation 추가 2013.11.13 조인영
			if(!ComIsNumber(value)) {
				ComShowCodeMessage('COM12122', 'S/P Code');
				sheetObj.SelectCell(1, 'vndr_seq');
				return false;
				}
			if(value.length > 6){
				ComShowCodeMessage('COM131901', 'S/P Code');
				sheetObj.SelectCell(1, 'vndr_seq');
				return false;
			}
			getSheetVendorSeq(sheetObj, document.form, value, row);
			break;
		case('cust_cnt_cd_seq'):
			sheetObj.CellValue2(row, col) = value.toUpperCase();
			//Customer Code Validation 추가 2013.11.13 조인영
			if(value.length > 8){
				ComShowCodeMessage('COM131901', 'Customer Code');
				sheetObj.SelectCell(1, 'vndr_seq');
				return false;
			}
			if(value.length > 0){
				sheetObj.CellValue2(row, col-1) = "CNT";
			}else{
				sheetObj.CellValue2(row, col-1) = "HJS";				
			}
		
			break;
	}
}

function getSheetVendorSeq(sheetObj, formObj, vndr_seq, row){
	
	var returnFlg = false;
	formObj.f_cmd.value = SEARCH11;
	formObj.combo_svc_provider.value = vndr_seq; 
		//get_only_num(vndr_seq);
	sheetObj.RemoveEtcData();
	sheetObj.DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));

	var vendorNoList 	= sheetObj.EtcData('vndr_no');
	var vendorNmList 	= sheetObj.EtcData('vndr_nm_eng');
	var vendorCurr 		= sheetObj.EtcData('vndr_cnt_curr_cd');
	var hzdMtrlFlg		= sheetObj.EtcData('hzd_mtrl_flg');
	var ovwtTriAxlFlg 	= sheetObj.EtcData('ovwt_tri_axl_flg');
	if (vendorNoList == undefined || vendorNoList == ''){
		formObj.combo_svc_provider.value 			= '';
		sheetObj.CellValue2(row, 'vndr_seq') 		= '';
		sheetObj.CellValue2(row, 'vndr_nm') 		= '';
		sheetObj.CellValue2(row, 'default_curr') 	= '';
		sheetObj.CellValue2(row, 'hzd_mtrl_flg') 	= '';
		sheetObj.CellValue2(row, 'ovwt_tri_axl_flg')= '';
		returnFlg = false;
	}else{
		sheetObj.CellValue2(row, 'vndr_seq') 		 = ComTrim(vendorNoList);
		sheetObj.CellValue2(row, 'vndr_nm') 		 = vendorNmList;
		sheetObj.CellValue2(row, 'default_curr') 	 = vendorCurr;
		sheetObj.CellValue2(row, 'hzd_mtrl_flg') 	 = hzdMtrlFlg;
		sheetObj.CellValue2(row, 'ovwt_tri_axl_flg') = ovwtTriAxlFlg;
		returnFlg = true;

	}

	if(vendorCurr == undefined || vendorCurr == ''){
		sheetObj.CellValue2(row, 'default_curr') = defaultLoginOfficeCurr;
	}
	return returnFlg;
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
//		var xx5="";  //CONTROL OFFIC
		var xx5= formObject.form_usr_ofc_cd.value;  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 400, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
		
}

/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {

	var sheetObj = sheetObjects[0];

	for(var i=0; i<rowArray.length; i++)
	{
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		
		sheetObj.CellValue(1, 'vndr_seq') = colArray2;
		sheetObj.CellValue(1, 'vndr_nm') = colArray3;
	}
	getSheetVendorSeq(sheetObj, document.form, colArray2, i);
}