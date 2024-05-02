/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0028.js
*@FileTitle : USA 404 EDI Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 최 선
*@LastVersion : 1.4
* 2006.11.28 kim_sang_geun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.04.07       1.1[N200903260080 ]  [TRS-US Rail] AES No 관련 보완 요청
* 2009.05.20       1.2 [N200905150040] [TRS]USA RAIL YARD 정보 저장 화면 개발
* 2012.04.05 민정호  1.3 [CHM-201217112-01] USA Rail 조회 오류 수정
* 2012.04.09 최 선    1.4 [CHM-201217078] [TRS] US Rail 메뉴 테이블 상 칼럼추가 요청
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
 * @class ESD_TRS_0028 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0028() {
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

/* 공통전역변수 */
//var calPop = new ComCalendarGrid();
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var docMessage = "";

var R = 0;
var G = 255;
var B = 0;

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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
	for(i=0;i<sheetObjects.length;i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}   

	if(s_cntr_no != undefined && s_cntr_no != ''){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		formObject.bkg_no.value = s_bkg_no;
		formObject.cntr_no.value = s_cntr_no;
		formObject.frm_plandate.value = "";
		formObject.to_plandate.value = "";
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * * N200903260080 2009-04-07 [TRS-US Rail] AES No 관련 보완 요청
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				style.height = GetSheetHeight(13); // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(88, 6, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false);
				
				var HeadTitle1 = "S|STS|Cancellation\nEDI|Frustrate|Confirmation\nMSG Send|Status|Through|Container\nNumber|Type\nSize|BKG\nAttached|BKG\nSPE|CNTR\nSPE|BKG Cargo\nType|S/O\nCreation Time|S/O\nCreation Time|EDI\nKind|Rail ORG|Rail ORG|Interchange I|Interchange I|Rail DEST|Rail DEST|POL/DEL|POL/DEL|Route\nPlan|Rail\nRoad|Customs\nC.LOC|Trunk\nVVD|Lane|BL No|Booking No|Commodity\nDescription|Reference No|AES No|AES No|Billing EDI\nSent Time|Billing EDI\nSent Time|Bill\nACK/NCK|Billing EDI\nResent Time|Billing EDI\nResent Time|Weight|VGM|Shipper|Consignee|Trucker\nCode/Name|IT No|Bill ACK/NCK\nReceived Time|Bill ACK/NCK\nReceived Time|Waybill\nNo|EDI\nCC|EDI CC\nACK/NCK|EDI CC ACK/NCK\nReceived Time|EDI CC ACK/NCK\nReceived Time|Confirmation MSG\nSent Time|Confirmation MSG\nSent Time|Request S/P|Cancel Request\nTime|Cancel Request\nTime|Cancel Status|Cancel Request\nReason|Cancel Request\nReject Time|Cancel Request\nReject Time|Cancel Request\nReject Reason|Cancel\nReason|Internal\nRemark|Remark\n(Special Instruction)|Billing Sent\n User ID|Frustrate";//Remark";
				var HeadTitle2 = "S|STS|Cancellation\nEDI|Frustrate|Confirmation\nMSG Send|Status|Through|Container\nNumber|Type\nSize|BKG\nAttached|BKG\nSPE|CNTR\nSPE|BKG Cargo\nType|||EDI\nKind|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Route\nPlan|Rail\nRoad|Customs\nC.LOC|Trunk\nVVD|Lane|BL No|Booking No|Commodity\nDescription|Reference No|AES No|AES No|||Bill\nACK/NCK|||Weight|VGM|Shipper|Consignee|Trucker\nCode/Name|IT No|||Waybill\nNo|EDI\nCC|EDI CC\nACK/NCK|||||Request S/P|||Cancel Status|Cancel Request\nReason|||Cancel Request\nReject Reason|Cancel\nReason|Internal\nRemark|Remark\n(Special Instruction)|Billing Sent\n User ID|Frustrate";//Remark";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 90, daCenter, true, "chk2");     // cancellation edi chkbox
				InitDataProperty(0, cnt++, dtCheckBox, 90, daCenter, true, "chk4");
				InitDataProperty(0, cnt++, dtRadioCheck, 90, daCenter, true, "chk3");
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "trsp_so_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "trsp_rail_bil_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eq_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "bkg_cntr_attached", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bkg_spe", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "spcl_cgo_cntr_tp_cd",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "cgo_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cre_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cre_dt_hms", false, "", dfTimeHms, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bil_iss_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "fm_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "fm_nod_yard", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "inter_fm_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "inter_fm_nod_yard", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "to_nod_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "to_nod_yard", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "poldel_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "poldel_yard", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rout_pln_cd", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vndr_abbr_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "ibd_cstms_clr_loc_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "trunkvvd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "slan_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "bl_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,100, daCenter, true, "cmdt_name", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 135, daCenter, true, "ref_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "auto_xpt_sys_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "auto_xpt_sys_no", false, "", dfNone, 0, false, false, 15);

				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "bil_edi_snt_dt", false, "", dfDateYmd, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bil_edi_snt_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "bil_edi_rcv_rslt_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "bil_edi_rsnt_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bil_edi_rsnt_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daRight, true, "cntr_wgt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daRight, true, "vgm_wgt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "shpr_cust_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cnee_cust_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "trk_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "ibd_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "bil_edi_rcv_rslt_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "bil_edi_rcv_rslt_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "waybill_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "mtc_edi_ind_cd", false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "mtc_edi_rcv_rslt_flg", false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "mtc_edi_rcv_rslt_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "mtc_edi_rcv_rslt_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "cfm_msg_snt_dt", false, "", dfDateYmd, 0, false, false);

				InitDataProperty(0, cnt++, dtData, 65, daCenter, true, "cfm_msg_snt_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "prov_vndr_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,75, daCenter, true, "cxl_rqst_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,65, daCenter, true, "cxl_rqst_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "status_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,100, daCenter, true, "cxl_rqst_rsn", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,75, daCenter, true, "cxl_rqst_rjct_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,65, daCenter, true, "cxl_rqst_rjct_dt_hms", false, "", dfTimeHms, 0, false, false);
				InitDataProperty(0, cnt++, dtData,100, daCenter, true, "cxl_rqst_rjct_rsn", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo,100, daCenter, true, "wo_rjct_rsn", false, "", dfNone, 0, true, true); //20070725
				InitDataProperty(0, cnt++, dtData,150, daLeft, true, "inter_rmk", false, "", dfNone, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtData,150, daCenter, true, "spcl_instr_rmk", false, "", dfNone, 0, true, true, 255);
				InitDataProperty(0, cnt++, dtData,100, daCenter, true, "edi_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,80, daCenter, true, "trsp_frst_flg", false, "", dfNone, 0, false, false); //20070725

				InitDataProperty(0, cnt++, dtHidden,0, daCenter, true, "sub_rail_seq", false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,0, daCenter, true, "vndr_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,0, daCenter, true, "trsp_so_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_so_ofc_cty_cd",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,0, daCenter, true, "rail_cmb_thru_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cxl_rqst_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_rail_bil_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,0, daCenter, true, "cop_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,0, daCenter, true, "cost_act_grp_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ref_id", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "repo_pln_id",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "pln_yrwk",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ref_seq",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cre_ofc_cd",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bkg_cgo_tp_cd",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "rail_ord_rjct_flg",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bil_iss_knt",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "lastchk",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "inv_no",false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "trsp_bnd_cd",false, "", dfNone, 0, false, false);

				InitDataCombo(0, "wo_rjct_rsn", " |Requested By SP|RQST By BKG|TRS Own Reason", " |RBSP|RBB|TOR");
				InitDataCombo(0, 'auto_xpt_sys_cd', auto_xpt_sys_cdText, auto_xpt_sys_cdCode);

				HeadRowHeight = 30 ;
			}
		break;
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
				}
			break;

			case "btn_new":
				formObject.reset();
//				formObject.combo_svc_provider.RemoveAll(); //Service Provider 
				formObject.frm_yard.RemoveAll(); // combo 데이터삭제
				formObject.to_yard.RemoveAll(); // combo 데이터삭제
			break;
 
			case "btn_minimize":
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;

			case "btng_404edisend":
				doActionIBSheet(sheetObject, formObject, IBSEARCH, "02");
			break;
 
			case "btng_frustrate": //Frustrate
				if( validationFrustrate(sheetObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "03");
				}
			break;

			case "btng_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL, "");
			break;

			case "btng_confirmationmsg":
				doActionPopupOpen(sheetObject, formObject);
			break;

			case "btng_cancellationedisend":
				if( validationCancel(sheetObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSAVE, "");
				}
			break;

			case "btng_cancelreqreject":
				doActionCancelReqReject(sheetObject);
			break;

			case "btns_frmnode": //FromNode Popup창
				openHireYardPopup('getFromNode');
			break;

			case "btns_tonode": //ToNode Popup창
				openHireYardPopup('getToNode');
			break;

			case "btns_vender": //Service Provider
				rep_OnPopupClick();
			break;

			case "btns_calendar":
				getCalendar();
			break;

			case "btns_tvvd": //Trunk VVD Popup창
				openTVVDPopup();
			break;

			case "btns_multivvd": //M Trunk VVD
				openMultipleinquiry('VVD', 'T.VVD');
			break;

			case "btns_multibkg": //M BKG No
				openMultipleinquiry('BKG', 'BKG No');
			break;

			case "btns_multibl": //M B/L No
				openMultipleinquiry('BLN', 'B/L No');
			break;

			case "btns_multicntr": //M CNTR
				openMultipleinquiry('CNT', 'CNTR No');
			break;
			
			/*
			 * * N200905150040 2009-05-20 [TRS]USA RAIL YARD 정보 저장 화면 개발
			 */
			case "btng":
				ComOpenWindow('ESD_TRS_0084Pop.screen', 'ESD_TRS_0084', 'top=200, left=200, width=800, height=460, toolbar=0, directories=0, status=yes, menubar=0, scrollbars=0, resizable=0');
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

function validateFormSearch(formObj) {
	var lvFrmDate = ComTrimAll(ComTrimAll(formObj.frm_plandate.value, " "), "-");
	var lvToDate = ComTrimAll(ComTrimAll(formObj.to_plandate.value, " "), "-");

	var lvFrm_node = ComTrimAll(formObj.frm_node.value, " ");
	var lvTo_node = ComTrimAll(formObj.to_node.value, " ");
	
	var lvTrunk_vvd = ComTrimAll(formObj.trunk_vvd.value, " ");
	var lvBkg_no = ComTrimAll(formObj.bkg_no.value, " ");
	var lvBill_no = ComTrimAll(formObj.bill_no.value, " ");
	var lvCntr_no = ComTrimAll(formObj.cntr_no.value, " ");

	if( lvFrmDate == "" ) //from date
		formObj.frm_plandate.value = "";
	if( lvToDate == "" ) //to date
		formObj.to_plandate.value = "";

	if( lvTrunk_vvd == "" ) //T.VVD
		formObj.trunk_vvd.value = "";
	if( lvBkg_no == "" ) //BKG No
		formObj.bkg_no.value = "";
	if( lvBill_no == "" ) //B/L No
		formObj.bill_no.value = "";
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

		if( ComGetDaysBetween(lvFrmDate, lvToDate) > 31 ) {
			errMsg = "The inquiry period is limited to 1 month."   //ComGetMsg("TRS90120");
			ComShowMessage(errMsg);
			return false;
		} else if(  ComGetDaysBetween(lvFrmDate, lvToDate) > 14 && (lvFrm_node =="" || lvTo_node ==""  ) )   {
			errMsg = "The inquiry period is limited to 2 weeks without ORG, DEST Loc." //ComGetMsg("TRS90118");
			ComShowMessage(errMsg);
			return false;
		} else if( ComGetDaysBetween(lvFrmDate, lvToDate) < 0 ) {
			errMsg = ComGetMsg("TRS90118");
			ComShowMessage(errMsg);
			return false;
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

	if( !ComIsAlphabet(ComTrimAll(lvTrunk_vvd, ","), "n") && lvTrunk_vvd != "" ) {
		formObj.trunk_vvd.value = "";
		formObj.trunk_vvd.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvBkg_no, ","), "n") && lvBkg_no != "" ) {
		formObj.bkg_no.value = "";
		formObj.bkg_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvBill_no, ","), "n") && lvBill_no != "" ) {
		formObj.bill_no.value = "";
		formObj.bill_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvCntr_no, ","), "n") && lvCntr_no != "" ) {
		formObj.cntr_no.value = "";
		formObj.cntr_no.focus();
		return false;
	}
	
	var lvRdate = "";
	var lvRvndr = "";
	if( formObj.rad_date[0].checked ) {
		lvRdate = formObj.rad_date[0].value;
	} else if( formObj.rad_date[1].checked ) {
		lvRdate = formObj.rad_date[1].value;
	} else if( formObj.rad_date[2].checked ) {
		lvRdate = formObj.rad_date[2].value;
	} else if( formObj.rad_date[3].checked ) {
		lvRdate = formObj.rad_date[3].value;
	}	
	if( formObj.rad_vendor[0].checked ) {
		lvRvndr = formObj.rad_vendor[0].value;
	} else if( formObj.rad_vendor[1].checked ) {
		lvRvndr = formObj.rad_vendor[1].value;
	}
	formObj.hid_rad_date.value = lvRdate;
	formObj.hid_rad_vendor.value = lvRvndr;

	formObj.hid_frmdate.value = lvFrmDate; //from Date
	formObj.hid_todate.value = lvToDate; //to Date

	formObj.frm_node.value = lvFrm_node.toUpperCase();
	formObj.to_node.value = lvTo_node.toUpperCase();

	formObj.trunk_vvd.value = lvTrunk_vvd.toUpperCase(); //T.VVD
	formObj.bkg_no.value = lvBkg_no.toUpperCase(); //BKG No.
	formObj.bill_no.value = lvBill_no.toUpperCase(); //B/L No
	formObj.cntr_no.value = lvCntr_no.toUpperCase(); //CNTR No
	return true;
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, obj) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:
			if( obj == "01" ) {
				formObj.f_cmd.value = SEARCH;
			    IBS_DoSearchSax(sheetObj, "ESD_TRS_0028GS.do", TrsFrmQryString(formObj));
			} else if( obj == "02" ) {
				if( sheetObj.CheckedRows("chk1") < 1 ) {
					errMsg = ComGetMsg("TRS90036");
					ComShowMessage(errMsg);
				} else {
					docMessage = "S"; //send
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(formObj), "chk1", false, true);
				}
			} else if( obj == "03" ) {
				docMessage = "F"; //send
				formObj.f_cmd.value = MULTI03;
				sheetObj.DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(formObj), "chk4", false, true);			
			}
		break;

		case IBSAVE:
 			if( sheetObj.CheckedRows("chk2") < 1 ) {
				errMsg = ComGetMsg("TRS90036");
				ComShowMessage(errMsg);
			} else {
				docMessage = "C"; //send
				formObj.f_cmd.value = MULTI02;
				sheetObj.DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(formObj), "chk2", false, true);
			}
		break;
		
		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.SpeedDown2Excel(true);
		break;

		case IBINSERT:      // 입력
			sheetObj.DataInsert();
		break;
	}
}

//팝업창에 넘겨주는 Sheet의 Object
function openObjSheet() {
	return sheetObjects[1];
}

// Enter Key시 지연대리 요청 20070115
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
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

/* Cancel Req Reject 
 * 대상 :TRS_TRSP_RAIL_BIL_ORD.CXL_RQST_FLG ='Y'
 *       TRS_TRSP_EDI_RAIL_ORD.TRSP_RAIL_BIL_TP_CD = 'W' 인건
 */
function doActionCancelReqReject(sheetObj) {
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i=0; i<arrRow.length-1; i++ ) {
		if( sheetObj.CellValue(arrRow[i], "cxl_rqst_flg") == "Y" && sheetObj.CellValue(arrRow[i], "trsp_rail_bil_tp_cd") == "WRS" ) {
		} else {
			sheetObj.RowStatus(arrRow[i]) = "R";
			sheetObj.CellValue2(arrRow[i], "chk1") = "0";
			sheetObj.RowBackColor(arrRow[i]) = sheetObj.RgbColor(R,G,B);
		}
	}
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	} else {
//		ComOpenWindow('ESD_TRS_0959Pop.screen', 'ESD_TRS_0959', 'top=200, left=200, width=800, height=264, toolbar=0, directories=0, status=yes, menubar=0, scrollbars=0, resizable=0');
        ComOpenWindow('ESD_TRS_0959Pop.screen', 'ESD_TRS_0959', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:800px;dialogHeight:300px', true);
	}
}

//Popup창에서 처리결과를 확인하는 부분.
function doSearchPopup() {
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	if( validateFormSearch(formObject) ) {
		doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
	}
}

/**
 * Sheet1에서 이벤트를 발생시킴.
 */
function sheet_OnChange(sheetObj, row , col , value) {
	var chk_last = sheetObj.CellValue(row, "lastchk"); 
	var doc_soseq = sheetObj.CellValue(row, "trsp_so_seq");
	//김종욱 수석 요청으로 추가
	var lv_spcl_cgo = null;
	var lv_fm_nod_cd = sheetObj.CellValue(row, "fm_nod_cd");
	var lv_to_nod_cd = sheetObj.CellValue(row, "to_nod_cd");
	var b_chk = false;
	var bnd_cd = sheetObj.CellValue(row, "trsp_bnd_cd");
	
	var chk2 = sheetObj.CellValue(row, "chk2"); //Cancellation EDI Flag 


	if(sheetObj.CellValue(row, "trsp_bnd_cd") == 'I'){
		lv_spcl_cgo = sheetObj.CellValue(row, "spcl_cgo_cntr_tp_cd");
	}else{
		lv_spcl_cgo = sheetObj.CellValue(row, "bkg_spe");
	}

	if( lv_spcl_cgo == "AK" ) {
		b_chk = true;
	} else if( lv_spcl_cgo == "DG" ) {
		if( lv_fm_nod_cd.substring(0, 2) == "CA" || lv_to_nod_cd.substring(0, 2) == "CA" ) {
			b_chk = true;
		} else {
//			b_chk = false;
			b_chk = true;
		}
	} else {
		b_chk = true;
	}

	if( (chk_last == "" || chk_last == "Y") && b_chk ) {
		if( sheetObj.ColSaveName(col) == "chk1" ) {
			if( value == "1" ) {
				sheetObj.RowStatus(row) = "I";
				sheetObj.CellValue2(row, "chk1") = "1";
			} else {
				sheetObj.RowStatus(row) = "R";
				sheetObj.CellValue2(row, "chk1") = "0";
			}
		}
		if( sheetObj.ColSaveName(col) == "chk2" ) {
			if( value == "1" ) {
				sheetObj.CellValue2(row, "chk2") = "1";
				sheetObj.CellValue2(row, "wo_rjct_rsn") = "TOR";
			} else {
				sheetObj.CellValue2(row, "chk2") = "0";
				sheetObj.CellValue2(row, "wo_rjct_rsn") = "";
			}		
		}
	} else {
		sheetObj.CellValue2(row, "chk1") = "0";
		sheetObj.RowStatus(row) = "R";
	}
}

/**
 * Cancellation EDI Send 버튼 Click시 validation 함수
 */
function validationCancel(sheetObj) {
	if( sheetObj.CheckedRows("chk2") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	} else {
		var sRow = sheetObj.FindCheckedRow("chk2");
		var arrRow = sRow.split("|");
		for( var i=0; i<arrRow.length-1; i++ ) {
			if( sheetObj.CellValue(arrRow[i], "cgo_tp_cd") == "F" ) {
				if( sheetObj.CellValue(arrRow[i], "wo_rjct_rsn") == "" ) {
					errMsg = ComGetMsg("TRS90232");
					ComShowMessage(errMsg);
					sheetObj.SelectCell(arrRow[i], "wo_rjct_rsn");
					return false;
				} else {
					if( sheetObj.CellValue(arrRow[i], "trsp_frst_flg") == "Y" ) { //Frustrate가 Y인 경우
						errMsg = ComGetMsg("TRS90231");
						if( confirm(errMsg) ) {
						} else {
							return false;
						}
					}
					if( sheetObj.CellValue(arrRow[i], "wo_rjct_rsn") == "RBB" ) { //Cancel Reason이 RQST BY BKG인 경우
						errMsg = ComGetMsg("TRS90342");
						if( confirm(errMsg) ) {
						} else {
							return false;
						}
					}
				}
			}
		}
	}
	return true;
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet_OnSaveEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		/*******************************************************/
		if( docMessage == "S" ) {
			ComShowMessage("EDI Send - Success!!");
		} else if( docMessage == "C" ) {
			ComShowMessage("Cancellation EDI Send - Success!!");
		} else if( docMessage == "F" ) { //Frustrate
			ComShowMessage("Frustrate - Success!!");
		}
	}
	if( docMessage == "F" ) {
		frustrate_saveEnd(sheetObj);
	} else {
		var formObject = document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObj, formObject, IBSEARCH, "01");
		}
	}
}

/*
 * Frustrate는 Empty인 경우는 제외를 한다.
 */
function validationFrustrate(sheetObj) {
	if( sheetObj.CheckedRows("chk4") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	} else {
		var sRow = sheetObj.FindCheckedRow("chk4");
		var arrRow = sRow.split("|");
		for( var i=0; i<arrRow.length-1; i++ ) {
			if( sheetObj.CellValue(arrRow[i], "cgo_tp_cd") == "M" ) {
				errMsg = ComGetMsg("TRS90310");
				ComShowMessage(errMsg);
				return false;
			}
		}
	}
	return true;
}

/*
 * Frustrate는 Empty인 경우는 제외를 한다.
 */
function frustrate_saveEnd(sheetObj) {
	var sRow = sheetObj.FindCheckedRow("chk4");
	var arrRow = sRow.split("|");
	for( var i=0; i<arrRow.length-1; i++ ) {
		sheetObj.CellValue(arrRow[i], "trsp_frst_flg") = "Y";
		sheetObj.CellValue(arrRow[i], "chk4") = "0";
	}
	return true;
}

/*
 * Confirmation Message Send Pop up을 호출한다.
 * 팝업 파라미터 체크 및 데이터를 제공한다.
 */
var parmOfccd = "";
var parmSoseq = "";
//라디오 버튼을 클릭시 데이터를 검색한다. CHK3
function sheet_OnClick(sheetObj, Row, Col, Value) {
	if( sheetObj.ColSaveName(Col) == "chk3" ) {
		if( sheetObj.CellValue(Row, "lastchk") == "Y" ) {
			sheetObj.CellValue2(Row, "chk3") = "1";
			parmOfccd = "";
			parmSoseq = "";
			parmOfccd = sheetObj.CellValue(Row, "trsp_so_ofc_cty_cd");
			parmSoseq = sheetObj.CellValue(Row, "trsp_so_seq");	
		}
	}
}

function sheet_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	if (sheetObj.ColSaveName(NewCol)=='chk1' || sheetObj.ColSaveName(NewCol)=='chk2'){
		var dgFlg =sheetObj.CellValue(NewRow, 'spcl_cgo_cntr_tp_cd');
//		if(sheetObj.CellValue(NewRow, 'spcl_cgo_cntr_tp_cd')=='DG'
		if(dgFlg.indexOf("DG",0) >= 0
			&& sheetObj.CellValue(NewRow, 'vndr_seq')!='105475'
		    && sheetObj.CellValue(NewRow, 'vndr_seq')!='105484'
			&& !(sheetObj.CellValue(NewRow, 'vndr_seq')=='105480'
				&& sheetObj.CellValue(NewRow, 'fm_nod_cd')=='USDET'
			    && sheetObj.CellValue(NewRow, 'fm_nod_yard')=='R5')){
			ComShowCodeMessage('TRS90443');
		}
	}
}

function doActionPopupOpen(sheetObj, formObj) {
	if( sheetObj.CheckedRows("chk3") == 1 ) {
		ComOpenWindow('ESD_TRS_0927.do', 'ESD_TRS_0927', 'top=200, left=200, width=795, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');

    } else {
		errMsg = ComGetMsg("TRS90141");
		ComShowMessage(errMsg);
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
		obj.focus();
		return false;
	} else if( lvobj.length != 5 ) {
		obj.focus();
		errMsg = ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		return false;
	}
	if( !ComIsAlphabet(lvobj) ) {
		obj.value = "";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if( sep == 'F' )
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	else if( sep == 'T' )
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);

	comObj.focus();
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
//	ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 772, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
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
 * 외부 콤보박스의 리스트 가져오기 Service Provider
function getVendorComboList() {
	var formObj = document.form;
	var vendorNo = formObj.combo_svc_provider.Text;
	getVendorCombo(document.combo_svc_provider, sheetObjects[0], formObj, vendorNo);
}
 **/

/**
 * service provider combo 선택시 textfield의 값 변경하는 이벤트
function combo_svc_provider_OnChange(combo, Index_Code, Text) {
	document.form.trsp_so_vndr_no.value = combo.GetText(Index_Code,1);
}
 **/

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
//		formObject.cntr_no.value = reObj;
		formObject.cntr_no.value = multiCntrChkDgt(reObj);

	} else if( obj == "SON" ) {
		formObject.so_no.value = reObj;
	} else if( obj == "WON" ) {
		formObject.wo_no.value = reObj;
	} else {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
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

//Service Provider
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

function onChange_through(obj){
	var codeval =obj.value;
	var formObject = document.form;

    if ( codeval == 'W' ){
    formObject.sel_bnd.value = 'O';
    formObject.rad_vendor[1].checked = true;
    do_railroad('R');
    }
}
