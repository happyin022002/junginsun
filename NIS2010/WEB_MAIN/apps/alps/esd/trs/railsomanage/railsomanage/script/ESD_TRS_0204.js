/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0204.js
*@FileTitle : USA Rail Billing Correction을 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 최 선
*@LastVersion : 1.7
* 2006.11.23 kim_sang_geun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
* N200907030100 2009-07-03 TRS Railbilling Correction 수정
* N200907240050 2009-07-31 TRS Railbilling Correction 화면 변경
* 2011.03.15 최 선    1.4 [CHM-201109283] [TRS] ALPS의 Location 조회불가건 수정 보완 요청
* 2012.01.16 금병주  1.5 [CHM-201215713] [TRS] S/O 다중작업에 의한 COP status 오류 방지로직 추가요청 (US rail)
* 2012.04.05 민정호  1.6 [CHM-201217112-01] USA Rail 조회 오류 수정
* 2012.04.09 최 선    1.7 [CHM-201217078] [TRS] US Rail 메뉴 테이블 상 칼럼추가 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0204 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0204() {
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

/* 공통전역변수  */
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0; //SHEET를 늘렸다가 줄였다가.
var docObjsep = "C";

var R = 222;
var G = 251;
var B = 248;

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
    
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		/*
		 * N200906020130 2009-06-09 [TRS-Rail EDI] DG 정보 오전송에 따른 보완
		 * N200907030100 2009-07-03 TRS Railbilling Correction 수정
		 * N200907240050 2009-07-31 TRS Railbilling Correction 화면 변경
		 */
		case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(13);
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
				InitColumnInfo(95, 4, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);

				var HeadTitle1 = "S|STS|Status|EDI Re-sent|EDI Resend Target|Suspended\nReason|Through|CNTR No|TP/SZ|Full/\nEmpty|BND|BL No|BKG No|Shipper Name|BKG\nStatus|Term|Revised BKG No|POR/POD|POR/POD|Rail ORG|Rail ORG|Rail DEST|Rail DEST|POL/DEL|POL/DEL|Revised\nPOL|Customs\nC.LOC|IT/Local|IT No|BKG Cargo\nType|From WRS|From WRS|From WRS|From WRS|Commodity\nDescription|Reference No|Route\nPlan|BKG\nSPE|Weight\n(LBS)|Unmatch|Unmatch|VVD|VVD|POD\n(for Export BKG)|POD\n(for Export BKG)|Movement|Movement|Revised\nVVD|Revised\nBKG SPE|Rail Road|Request S/P|Cost\nMonth|S/O Creation Time|S/O Creation Time|BKG Updated Time|BKG Updated Time|Cancel Request Time|Cancel Request Time|Cancel Status|Cancel Request\nReason|Cancel Request Reject Time|Cancel Request Reject Time|Cancel Request\nReject Reason|Requested\nBy BKG|Internal\nRemark|Remark\n(Special Instruction)";

				var HeadTitle2 = "S|STS|Status|EDI Re-sent|EDI Resend Target|Suspended\nReason|Through|CNTR No|TP/SZ|Full/\nEmpty|BND|BL No|BKG No|Shipper Name|BKG\nStatus|Term|Revised BKG No|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Revised\nPOL|Customs\nC.LOC|IT/Local|IT No|BKG Cargo\nType|Bulk|Steel Wire|Coil Shipment|Fumigation|Commodity\nDescription|Reference No|Route\nPlan|BKG\nSPE|Weight\n(LBS)|VVD|POD|Orignal|Revised|Orignal|Revised|Yard|Status|Revised\nVVD|Revised\nBKG SPE|Rail Road|Request S/P|Cost\nMonth|||||||Cancel Status|Cancel Request\nReason|||Cancel Request\nReject Reason|Requested\nBy BKG|Internal\nRemark|Remark\n(Special Instruction)";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

				InitDataProperty(0, cnt++, dtCheckBox     , 30, daCenter, true, "chk1"      );
				InitDataProperty(0, cnt++, dtHiddenStatus ,  0, daCenter, true, "ibflag"    );
				InitDataProperty(0, cnt++, dtData         , 75, daCenter, true, "status", false, "", dfNone, 0, false, false);
				
				//InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "edi_resend", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "edi_resent", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 150, daCenter, true, "edi_resend_target_flag", false, "", dfNone, 0, false, false);
				
				
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "err_desc", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "through", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "eq_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "trsp_bnd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 150,	daCenter, true,	"ship_nm",  false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "bkg_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "bkg_rcvde_term_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "revised_bkg_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "podpor_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "podpor_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "fm_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "fm_nod_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "to_nod_yard", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "poldel_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "poldel_yard", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "revised_pol", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "ibd_cstms_clr_loc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "ibd_ipi_locl_ind_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "ibd_no", false, "", dfNone, 0, true, true, 20);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "bkg_cargo_type", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "blk_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "stel_wire_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "coil_shp_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "fumg_flg", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 135, daCenter, true, "cmdt_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 135, daCenter, true, "ref_no", false, "", dfNone, 0, false, false);				// IRG 정보
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rout_pln_cd", false, "", dfNone, 0, false, false);		// IRG 정보
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_spe", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daRight, true, "cntr_wgt", false, "", dfNumber, 3,false, false);

				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "unmatch_vvd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "unmatch_pod", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "trunkvvd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "trunkvvd_revised", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "pod_cd_revised", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "mvmt_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "mvmt_status", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "revised_trunkvvd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "revised_bkg_spe", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vndr_abbr_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopup,90, daCenter, true, "request_sp", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cost_month", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cre_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cre_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_updated_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "bkg_updated_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cxl_rqst_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cxl_rqst_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "status_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cxl_rqst_rsn", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cxl_rqst_rjct_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cxl_rqst_rjct_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "cxl_rqst_rjct_rsn", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 70, daCenter, true, "trsp_rqst_bkg_flg", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "inter_rmk", false, "", dfEngUpKey, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "spcl_instr_rmk", false, "", dfEngUpKey, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "trsp_so_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "bil_iss_knt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "bil_iss_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cxl_rqst_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "trsp_rail_bil_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cop_no", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "cost_act_grp_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20,  daCenter, true, "rout_seq", false, "", dfNone, 0, false, false);			// IRG 정보
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rout_org_nod_cd", false, "", dfNone, 0, false, false);	// IRG 정보
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rout_dest_nod_cd", false, "", dfNone, 0, false, false);	// IRG 정보
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "pol_cd", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "inlnd_rout_rmk", false, "", dfNone, 0, false, false);		// IRG 정보

				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "repo_pln_id",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "pln_yrwk",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, "ref_seq",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 20, daCenter, true, "ref_id", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "interchange1_loc", false, "", dfNone, 0, false, false);		// IRG 정보
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "interchange1_nod", false, "", dfNone, 0, false, false);		// IRG 정보
				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "interchange2_loc", false, "", dfNone, 0, false, false);		// IRG 정보
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "interchange2_nod", false, "", dfNone, 0, false, false);		// IRG 정보
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "inv_bil_patt_div_flg", false, "", dfNone, 0, false, false);	// IRG 정보

				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rail_cmb_thru_tp_cd", false, "", dfNone, 0, false, false);		// IRG 정보
				InitDataProperty(0, cnt++, dtHidden,90, daCenter, true, "vndr_seq", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "org_fm_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "org_fm_nod_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "org_to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "org_to_nod_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "act_grp_cd", false, "", dfNone, 0, false, false);



				InitDataCombo(0, 'ibd_ipi_locl_ind_cd', ibd_ipi_locl_ind_cdText, ibd_ipi_locl_ind_cdCode);
				InitDataCombo(0, 'trsp_rqst_bkg_flg', 'YES|NO', 'Y|N');

				RangeBackColor(1,28, 1,31) = RgbColor(222, 251, 248);   // ENIS
				HeadRowHeight = 20;
				HeadRowHeight = 21;
			}
		break;
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "");
				}
			break;

			case "btn_reset":
				formObject.reset();
				formObject.frm_yard.RemoveAll(); // combo 데이터삭제
				formObject.to_yard.RemoveAll(); // combo 데이터삭제
			break;

			case "btn_minimize":
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;
			
			case "btng_irgadjust":
				if( validateForm(sheetObject, formObject) ) {
					doActionPopupOpen(sheetObject, formObject);
				}
				
			break;

			case "btns_calendar":
				getCalendar();
			break;

			case "btns_frmnode":
				openHireYardPopup('getFromNode');
			break;

			case "btns_tonode":
				openHireYardPopup('getToNode');
			break;

			case "btns_multivvd":
				openMultipleinquiry('VVD', 'T.VVD');
			break;

			case "btns_tvvd":
				openTVVDPopup();
			break;

			case "btns_multibkg":
				openMultipleinquiry('BKG', 'BKG No');
			break;

			case "btns_multibl":
				openMultipleinquiry('BLN', 'B/L No');
			break;
			
			case "btns_multicntr":
				openMultipleinquiry('CNT', 'CNTR No');
			break;

			case "btng_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL, "");
			break;

			case "btng_cancelreqreject":
				doActionCancelReqReject(sheetObject);
			break;

			case "btng_sodelete":
				if( validateFormDel(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBDELETE, "");
				}
			break;

			case "btng_ediresend_tti":
				if( validateForm_ediresend(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "EDI_RESEND");
				}
			break;

			case "btng_socorrection":
				if( validateForm(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSAVE, "");
				}
			break;

			case "btns_vender": //Service Provider
				rep_OnPopupClick();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
    		errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
    		ComShowMessage(e);
		}
	}
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction,obj) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:	  //조회
			if( obj == 'EDI_RESEND'){

    			docMessage = "S"; //send
    			formObj.f_cmd.value = MULTI04;    //EDI RESEND
    			sheetObj.DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(formObj), "chk1", false, true);
			
			} else {
			    formObj.f_cmd.value = SEARCH03;
			    sheetObj.DoSearch4Post("ESD_TRS_0204GS.do", TrsFrmQryString(formObj));
			}

		break;
		
		case IBSAVE:	  //수정
			formObj.f_cmd.value = MODIFY;
			sheetObj.DoSave("ESD_TRS_0204GS.do", TrsFrmQryString(formObj), "chk1", false, true);
		break;
		
		case IBDELETE:	   //Clear
			formObj.f_cmd.value = REMOVE;
			sheetObj.DoSave("ESD_TRS_0204GS.do", TrsFrmQryString(formObj), "chk1", false, true);
		break;
		
		case IBDOWNEXCEL:  //엑셀내려받기
			sheetObj.SpeedDown2Excel(true);
		break;
	}
}

// Enter Key시 지연대리 요청 20070115
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
		}
	}
}

//Popup창에서 처리결과를 확인하는 부분.
function doSearchPopup() {
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	if( validateFormSearch(formObject) ) {
		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	}
}

//팝업창에 넘겨주는 Sheet의 Object
function openObjSheet() {
	return sheetObjects[0];
}

//tab1의 sheet에 대한 정보
function sheet_OnChange(sheetObj, row , col , value) {
	var docObj = "";
	if( sheetObj.ColSaveName(col) == "ibd_ipi_locl_ind_cd" ) {
		docObj = sheetObj.CellValue(row, "ibd_ipi_locl_ind_cd");
		if( docObj == "I" ) {
			sheetObj.CellEditable(row, "ibd_no") = true;
		} else {
			sheetObj.CellEditable(row, "ibd_no") = false;
			sheetObj.CellValue2(row, "ibd_no") = "";
		}
	} else if( sheetObj.ColSaveName(col) == "ibd_no" ) {
		docObj = sheetObj.CellValue(row, "ibd_ipi_locl_ind_cd");
		if( docObj == "I" ) {
			sheetObj.CellEditable(row, "ibd_no") = true;
		} else {
			sheetObj.CellEditable(row, "ibd_no") = false;
			sheetObj.CellValue2(row, "ibd_no") = "";
		}
	} else if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.RowStatus(row) = "I";
		} else {
			sheetObj.RowStatus(row) = "R";
		}
	}










}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj){
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}


	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var ir = 0; ir < arrRow.length-1; ir++ ) {
		fromRow = arrRow[ir];
		if( sheetObj.CellValue(fromRow, "status") == "EDI Sent" ) {
			errMsg = ComGetMsg("TRS90358");
			ComShowMessage(errMsg);
			return false;
		}
	}
	
	//2012.01.16 S/O Correction 시 delete 여부 체크 kbj
	var chkSoNo = soDelteChk(sheetObj, formObj) 
	if (chkSoNo != ''){
		ComShowCodeMessage('TRS90411',chkSoNo);
		return false;
	}
	return true;
}

 /**
  * 선택한 S/O의 delete 여부 체크 함수 kbj
  */
function soDelteChk(sheetObj, formObj){
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	var fTrspSoSeq = '';
	var fTrspSoOfcCd = '';
	for( var ir = 0; ir < arrRow.length-1; ir++ ) {
		fromRow = arrRow[ir];
		fTrspSoSeq = fTrspSoSeq + sheetObj.CellValue(fromRow, "trsp_so_seq")  + ",";
		fTrspSoOfcCd = fTrspSoOfcCd + sheetObj.CellValue(fromRow, "trsp_so_ofc_cty_cd") + ",";
	} 
	formObj.f_cmd.value = COMMAND01;   //선택한 S/O의 delete 여부 체크
	var param = "fTrspSoSeq="+fTrspSoSeq+"&fTrspSoOfcCd="+fTrspSoOfcCd+"&"+ TrsFrmQryString(formObj)
	var sXml = sheetObj.GetSearchXml("ESD_TRS_0204GS.do",param);
	var soNo = ComGetEtcData(sXml, "so_no");
	return soNo;
	
} 
 
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateFormDel(sheetObj, formObj) { //20070719 정원근 수석 요청
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	} else {
		var sRow = sheetObj.FindCheckedRow("chk1");
		var arrRow = sRow.split("|");
		for( var ir = 0; ir < arrRow.length-1; ir++ ) {

			fromRow = arrRow[ir];

			if( sheetObj.CellValue(fromRow, "trsp_rqst_bkg_flg") == "Y" ) {
				errMsg = ComGetMsg("TRS90342");
				if( confirm(errMsg) ) {
				} else {
					sheetObj.CellValue2(fromRow,"trsp_rqst_bkg_flg") = "";
					return false;
				}
			}

			if( sheetObj.CellValue(fromRow, "status").substring(0,1) == "I" ) {
				errMsg = "The invoiced S/Os cannot be deleted.";
				ComShowMessage (errMsg);
					return false;
			}			
		}
	}
	return true;
}


/**
 * 404 EDI RESEND(TO 터미널) 시 Validation 체크로직.
 */
function validateForm_ediresend(sheetObj, formObj){

	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}

	var sRow      = sheetObj.FindCheckedRow("chk1");
	var arrRow    = sRow.split("|");
	
	var edi_no_resend_target_cnt  = 0;
	var edi_resent_cnt            = 0;
	
	var edi_no_resend_target_flag;
	
	for( var i=0; i<arrRow.length-1; i++ ) {
	    fromRow = arrRow[i];
		if( sheetObj.CellValue(fromRow, "edi_resend_target_flag") == 'X' ){
		   edi_no_resend_target_cnt    = edi_no_resend_target_cnt + 1; 
		}else if( sheetObj.CellValue(fromRow, "edi_resend_target_flag") == 'N' ){
		   edi_resent_cnt              = edi_resent_cnt + 1;
		}
	}
	
	if( edi_no_resend_target_cnt > 0 || edi_resent_cnt > 0 ){
	    errMsg   = ComGetMsg("TRS90370");
	    ComShowMessage(errMsg);
	    return false;
	}
	return true;
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet_OnSaveEnd(sheetObj, errMsg) {
    
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		var sRow   = sheetObj.FindCheckedRow("chk1");
		var arrRow = sRow.split("|");
		
		if( document.form.f_cmd.value == REMOVE ) {
			errMsg = ComGetMsg("TRS90146");
			ComShowMessage(errMsg);
			
			//원본에서 역순으로 특정 상태의 행을 이동한다.
			for( var ir = arrRow.length-2; ir >=0 ; ir-- ) {
				//원본에서 지움
				sheetObj.RowDelete(arrRow[ir], false);
			}
		
		} else if( document.form.f_cmd.value == MULTI04 ) {     //EDI RESEND
		
			//EDI Resend건에 대해 'Y' Marking처리한다.
			for( var i = arrRow.length-2; i >=0 ; i-- ) {
				 sheetObj.CellValue2(arrRow[i], "edi_resent")             = "Y";
				 sheetObj.CellValue2(arrRow[i], "edi_resend_target_flag") = "N";				 
				 sheetObj.CellValue2(arrRow[i], "chk1")       = "0";
			}		
			
			ComShowMessage("EDI Re-send - Success!!");    
		    
		} else {
			for( var ir = 0; ir < arrRow.length-1; ir++ ) {
				sheetObj.RowStatus(arrRow[ir]) = "I";
			}
			errMsg = ComGetMsg("TRS90102");
			ComShowMessage(errMsg);
		}
	}
}

function sheet_OnMouseDown(sheetObj, Button, Shift, X, Y){
}

/* Cancel Req Reject 
 * 대상 :TRS_TRSP_RAIL_BIL_ORD.CXL_RQST_FLG ='Y'
 *       TRS_TRSP_EDI_RAIL_ORD.TRSP_RAIL_BIL_TP_CD = 'W' 인건
 */
function doActionCancelReqReject(sheetObj) {
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i=0; i<arrRow.length-1; i++ ) {
		if( sheetObj.CellValue(arrRow[i], "cxl_rqst_flg") == "Y" && sheetObj.CellValue(arrRow[i], "trsp_rail_bil_tp_cd") == "W" ) {
		} else {
			sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.CellValue2(arrRow[i], "chk1") = "0";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
		}
	}
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	} else {
//		ComOpenWindow('ESD_TRS_0959Pop.screen', 'ESD_TRS_0959', 'top=200, left=200, width=800, height=264, toolbar=0, directories=0, status=yes, menubar=0, scrollbars=0, resizable=0');
	    ComOpenWindow('ESD_TRS_0959Pop.screen', 'ESD_TRS_0959', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:800px;dialogHeight:300px', true);
    }
}

// dtPopupEdit 로 처리 할 경우 팝업오픈 처리
var docProvvndrseq = "";
var docTrsp_so_seq = "";
var docTrsp_so_ofc_cd = "";
function sheet_OnPopupClick(sheetObj, row, col) {
	docProvvndrseq = "";
	if( sheetObj.ColSaveName(col) == "request_sp" ) {
		docProvvndrseq = sheetObj.CellValue(row, "request_sp");
		docTrsp_so_seq = sheetObj.CellValue(row, "trsp_so_seq");
		docTrsp_so_ofc_cd = sheetObj.CellValue(row, "trsp_so_ofc_cty_cd");
		if( docProvvndrseq != "" ) {
			var myOption = "top=200,left=200,width=402,height=256,menubar=0,status=0,scrollbars=0,resizable=0";
			var url = 'ESD_TRS_0956Pop.screen';
//			var myWin = window.open(url, "popRequestSP", myOption);
			var myWin = ComOpenWindow('ESD_TRS_0956Pop.screen', 'popRequestSP', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:402px;dialogHeight:286px', true);

		}
	}
}

function do_railroad(obj) {
	if( obj == "R" ) {
		document.form.combo_svc_provider.style.visibility = "visible";
		document.form.trsp_so_vndr_no.style.visibility = "visible";
		document.form.btns_vender.style.visibility = "visible";
		document.form.sel_railroad.style.visibility = "hidden";		
		document.all.item("SV")[0].style.display = "inline";
		document.all.item("SV")[1].style.display = "none"
	} else {
		document.form.combo_svc_provider.style.visibility = "hidden";
		document.form.trsp_so_vndr_no.style.visibility = "hidden";
		document.form.btns_vender.style.visibility = "hidden";
		document.form.sel_railroad.style.visibility = "visible";
		document.all.item("SV")[0].style.display = "none";
		document.all.item("SV")[1].style.display = "inline"		
	}
}

/**
 * 화면을 줄였다가 늘렸다가 된다.
 */
function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(19);
	} else {
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
	}
}

function validateFormSearch(formObj) {
	var lvFrmDate = ComTrimAll(ComTrimAll(formObj.frm_plandate.value, " "), "-");
	var lvToDate = ComTrimAll(ComTrimAll(formObj.to_plandate.value, " "), "-");

	var lvFrm_node = ComTrimAll(formObj.frm_node.value, " ");
	var lvTo_node = ComTrimAll(formObj.to_node.value, " ");
	
	var lvBkg_no = ComTrimAll(formObj.bkg_no.value, " ");
	var lvCntr_no = ComTrimAll(formObj.cntr_no.value, " ");
	var lvTrunk_vvd = ComTrimAll(formObj.trunk_vvd.value, " ");
	var lvBill_no = ComTrimAll(formObj.bill_no.value, " ");	

	if( lvFrmDate == "" ) //from date
		formObj.frm_plandate.value = "";
	if( lvToDate == "" ) //to date
		formObj.to_plandate.value = "";

	if( lvBkg_no == "" ) //BKG No
		formObj.bkg_no.value = "";
	if( lvCntr_no == "" ) //CNTR No
		formObj.cntr_no.value = "";

	if( lvFrmDate == "" && lvToDate != "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90119");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate == "" ) { //한쪽 날짜가 빠진 경우
		errMsg = ComGetMsg("TRS90121");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate != "" ) { //날짜 체크하는 부분
		if( !ComIsDate(lvFrmDate) ) {
			errMsg = ComGetMsg("TRS90072");
			ComShowMessage(errMsg);
			formObj.frm_plandate.focus();
			return false;
		} else if( !ComIsDate(lvToDate) ) {
			errMsg = ComGetMsg("TRS90073");
			ComShowMessage(errMsg);
			formObj.to_plandate.focus();
			return false;
		}
		if( ComGetDaysBetween(lvFrmDate, lvToDate) > 14 ) {
			errMsg = ComGetMsg("TRS90120");
			ComShowMessage(errMsg);
			return false;
		} else if( ComGetDaysBetween(lvFrmDate, lvToDate) < 0 ) {
			errMsg = ComGetMsg("TRS90118");
			ComShowMessage(errMsg);
			return false;
		}
		for(var i = 0; i < formObj.date_sep.length; i++){
			if(formObj.date_sep[i].checked == true && formObj.date_sep[i].value == "BU"){				
				if( lvFrm_node != "" && lvTo_node != "" ){			
				} else if(lvBkg_no != "" || lvCntr_no != "" || lvTrunk_vvd != "" || lvBill_no != ""){					
				} else{
					errMsg = ComGetMsg("TRS90124");
					ComShowMessage(errMsg);
					return false;
				}
			}
		}	
	} else {
		if( lvTrunk_vvd == "" && lvBkg_no == "" && lvBill_no == "" && lvCntr_no == "" ) {
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
	}

	if( lvFrm_node == "" ) { //From Node
		formObj.frm_node.value = "";
		formObj.frm_yard.RemoveAll(); // combo 데이터삭제
	}
	if( lvTo_node == "" ) { //To Node
		formObj.to_node.value = "";
		formObj.to_yard.RemoveAll(); // combo 데이터삭제
	}

	if( !ComIsAlphabet(ComTrimAll(lvBkg_no, ","), "n")  && lvBkg_no != "" ) {
		formObj.bkg_no.value = "";
		formObj.bkg_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvCntr_no, ","), "n") && lvCntr_no != "" ) {
		formObj.cntr_no.value = "";
		formObj.cntr_no.focus();
		return false;
	}
	formObj.hid_frmdate.value = lvFrmDate; //from Date
	formObj.hid_todate.value = lvToDate; //to Date

	formObj.frm_node.value = lvFrm_node.toUpperCase();
	formObj.to_node.value = lvTo_node.toUpperCase();

	formObj.bkg_no.value = lvBkg_no.toUpperCase(); //BKG No.
	formObj.cntr_no.value = lvCntr_no.toUpperCase(); //CNTR No
	return true;
}

/*
 * IRG Adjuct Pop up을 호출한다.
 */
function doActionPopupOpen(sheetObj, formObject) {
	var doc_flg = false;
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
	} else {
		var sRow = sheetObj.FindCheckedRow("chk1");
		var arrRow = sRow.split("|");
		var lvcgo_tp_cd = "";
		var lvchedk = false;
		for( var i=0; i<arrRow.length-1; i++ ) {
			if( i != 0 ) {
				if( sheetObj.CellValue(arrRow[i], "cgo_tp_cd") != lvcgo_tp_cd ) {
					lvchedk = true;
				}
			}
			lvcgo_tp_cd = sheetObj.CellValue(arrRow[i], "cgo_tp_cd");
			if( sheetObj.CellValue(arrRow[i], "inv_bil_patt_div_flg") == "Y" ) {
				sheetObj.RowStatus(arrRow[i]) = "R";
				sheetObj.CellValue2(arrRow[i], "chk1") = "0";
				sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
				doc_flg = true;
			}
		}
		if( doc_flg ) {
			errMsg = ComGetMsg("TRS90363");
			ComShowMessage(errMsg);
		} else {
			if( lvchedk ) {
				errMsg = ComGetMsg("TRS90325");
				ComShowMessage(errMsg);
			} else {

				var pop_width = 1000;

				var pop_leftloc= window.screenLeft;
				var pop_toploc = window.screenTop-400;
//				ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928', 'top='+pop_toploc +', left='+pop_leftloc+',width='+ pop_width +' , height=475, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0', true);
                ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:1000px;dialogHeight:510px', true);

			}
		}
	}
}

/*
 * 외부 콤보박스의 리스트 가져오기 (ESD_TRS_0003.js에도 존재).
 */
function getComboList(obj, comObj, sep) { //object, 값을 받는부분, 'Node종류
	var formObj = document.form;
	var lvobj = ComTrimAll(obj.value.toUpperCase(), " ");
	obj.value = lvobj;
	if( lvobj == "" ) {
		obj.value = "";
		comObj.RemoveAll();
		return false;
	} else if( lvobj.length != 5 ) {
		obj.focus();
		errMsg = ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		return false;
	}
	if( !doengnumcheck(lvobj) ) {
		obj.value = "";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if( sep == 'F' ) {
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
}

/**
 * rep_commodity팝업호출
 */
function rep_OnPopupClick() {
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
	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/** 
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		var colArray4 = colArray[4];

		formObj.combo_svc_provider.value =colArray2;
		formObj.trsp_so_vndr_no.value = colArray4;
	}
}

/**
 * 공통 Node popup
 */
 function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId = objName;
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * From Node 팝업에 대한 리턴값
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.frm_node.value = lvLoc;
	getYardCombo(document.frm_yard, sheetObjects[0], formObject, lvLoc);
	document.frm_yard.CODE = lvYard;
}

/**
 * To Node 팝업에 대한 리턴값
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];

	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.to_node.value = lvLoc;
	getYardCombo(document.to_yard, sheetObjects[0], formObject, lvLoc);
	document.to_yard.CODE = lvYard;
}

/**
 * 공통 Trunk VVD popup
 */
 function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";

	var param ="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj = "";
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ",";
		}
	}
	if( obj == "VVD" ) {
		formObject.trunk_vvd.value = reObj;
	} else if( obj == "BKG" ) {
		formObject.bkg_no.value = reObj;
	} else if( obj == "BLN" ) {
		formObject.bill_no.value = reObj;
	} else if( obj == "CNT" ) {
		formObject.cntr_no.value = multiCntrChkDgt(reObj);
	} else {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}

/**
 * 공통 Trunk VVD popup
 */
 function openTVVDPopup() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var v1 = ""; //ETDETA
	var v2 = ""; //SDATE
	var v3 = ""; //EDATE
	var v4 = ""; //VVD_CD
	var v5 = ""; //LOC_CD
	var v6 = ""; //LANE_CD
	var v7 = ""; //OPER
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getCOM_ENS_VVD_1";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0B2.do' + param, 772, 450, classId, '1,0,1,1,1,1,1,1');
}

function getCOM_ENS_VVD_1(rowArray) {
	var formObject = document.form;
	var gubun = "";
	var colArray = rowArray[0];
	formObject.trunk_vvd.value = colArray[7] + gubun;
}

/*
 * 멀티 달력 입력 Pop-Up
 */
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');
}

// 일자에 더하기를 한다.
function getDateBetween(obj) {
	if(document.form.frm_plandate.value == ""){
		document.form.to_plandate.value = "";
	}else{
		document.form.to_plandate.value = ComGetDateAdd(obj.value, "D", 14);		
	}
}

// Service Provider
function  vender_blur(){		
	var formObj = document.form;
	var lvobj = formObj.combo_svc_provider.value;
	var error_val = "";

	if(lvobj !=""){
		for (var i = 0; i < lvobj.length; i++) {
			var oneChar = lvobj.charAt(i);
			if (oneChar != "") {
				if (  (oneChar >= "0" && oneChar <= "9" )  ){
				}else {
					error_val ="Y";
					break;
				}
			}
		}
		if(error_val !="Y" ) {				
			formObj.f_cmd.value = SEARCH11;
			formObj.combo_svc_provider.value = get_only_num(formObj.combo_svc_provider.value);
			sheetObjects[0].RemoveEtcData();
			sheetObjects[0].DoRowSearch("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));
			
			var vendorNoList = sheetObjects[0].EtcData('vndr_no');
			var vendorNmList = sheetObjects[0].EtcData('vndr_nm_eng');
			
			if (vendorNoList == undefined || vendorNoList == ''){
				   formObj.combo_svc_provider.value = '';
				   formObj.trsp_so_vndr_no.value = '';
			}else{
				formObj.combo_svc_provider.value = lpad(ComTrim(vendorNoList), 6, '0') ;
				formObj.trsp_so_vndr_no.value = vendorNmList;
			}						
		} else {
			errMsg = ComGetMsg("TRS90076");
			ComShowMessage(errMsg);
			formObj.combo_svc_provider.focus();
			formObj.trsp_so_vndr_no.value ="";
		}
	} else {
		formObj.trsp_so_vndr_no.value ="";
	}
}