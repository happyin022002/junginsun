/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0228.js
 *@FileTitle : e-Booking n SI Process
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.05.21 전용진
 * 1.0 Creation
 * 2010.09.06 전성진 [SRM-201008558] Action Date 에 시분 표시
 * 2011.05.25 김진승 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청 - Check Split Detail 버튼 추가.
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
===============================================================================
 History
 * 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 * 2010.09.29 전성진 [CHM-201006145] e-Booking & S/I Process List 화면 조정 : SHPR, CNEE, FWDR, POR NAME, DEL NAME 항목 왼쪽 정렬 및 크기 조절
 * 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
 * 2011.02.01 이일민 [] sheet의 request no width 조정 
 * 2011.03.23 정선용 [] e-Booking SI Upload 화면 - Lane 추가
 * 2011.03.29 이일민 [] seanaccs처럼 samsung추가
 * 2011.05.20 김진승 [CHM-201110982-01] e-Booking & SI Process(ESM_BKG_0228)에 조회 항목(Split Status) 추가; split_sts_cd
 * 2011.05.25~06.03 김진승 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청 - Check Split Detail 버튼 추가.
 * 2011.06.24 손은주 [CHM-201111279-01] s-si Process 개선 사항 요청
 * 2011.09.14 정선용 [] e-Booking & S/I Process 조회조건 검토 요청(메시지 추가 : 'BKG01146')
 * 2011.10.19 정선용 [CHM-201113772-01] [삼성SDS] 신규 TP ID 셋업 요청
 * 2012.09.21 김보배 [CHM-201219963] [BKG] ALPS Live Out of Memory Error 발생
 * 2012.09.25 이재위 [CHM-201220269] e-BKG & SI Process menu seq 처리 로직 변경 요청
 * 2013.01.07 이재위 [CHM-201221995] Split - Email 접수 Draft B/L Correction 분류 시스템 개발
 * 2013.05.21 임재관 [CHM-201324602] e-Booking & SI Process 상 Special 정보 column 추가
 * 2013.06.20 최문환 [CHM-201325258] e-Booking & SI Process 화면 상 special 정보 drag & drop 기능 보완
 * 2014.10.28 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차)
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends
 * @class esm_bkg_0228 : esm_bkg_0228 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0228() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
}

/* 개발자 작업	*/

// 공통전역변수 
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var iterator = "|$$|";

var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

var loguserid = null;

var arrMultiCombo;// 멀티콤보 세팅할 변수

var arrWindow = new Array(null, null); // esm_bkg_0229가 몇개가 떠있는지 확인함.
var reject_rmk = null;
var reject_code = null;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			formObject.inttra_rtv.value = "N";
			ComBtnDisable("btn_reject_inttra");
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "", "");
			break;
			
		case "btn_retrieve_inttra":
			formObject.inttra_rtv.value = "Y";
			ComBtnEnable("btn_reject_inttra");
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "", "");
			break;		
			
		case "btn_reject_inttra":
			doActionIBSheet(sheetObjects[0], document.form, "btn_inttra_reject", "", "");
			break;				

		case "btn_new":
			//			doActionIBSheet(sheetObjects[0],document.form,IBCLEAR, "", "");

			ComClearObject(formObject.rqst_from_dt);
			ComClearObject(formObject.rqst_to_dt);
			ComClearObject(formObject.vvd);
			ComClearObject(formObject.chn_agn_cd);
			ComClearObject(formObject.set_slct_flg);

			ComClearObject(formObject.xter_rqst_no);
			ComClearObject(formObject.xter_rqst_seq);
			formObject.xter_rqst_via_cd.Code = "";
			formObject.doc_tp_cd.Code = "";
			ComClearObject(formObject.origin);
			formObject.delivery.Code = "";

			ComClearObject(formObject.bkg_no);
			formObject.xter_bkg_rqst_sts_cd.Code = "";
			ComClearObject(formObject.hndl_ofc_cd);
			ComClearObject(formObject.pol_cd);
			ComClearObject(formObject.pod_cd);

			ComClearObject(formObject.po_no);
			formObject.bkg_upld_sts_cd.Code = "";
			ComClearObject(formObject.ofc_cd);
			ComClearObject(formObject.por_cd);
			ComClearObject(formObject.del_cd);

			ComSetObjValue(formObject.bkg_cust_tp_cd, "S");
			ComClearObject(formObject.cust_cnt_cd);
			ComClearObject(formObject.cust_seq);
			ComClearObject(formObject.cust_nm);
			ComClearObject(formObject.xter_sndr_id);
			ComClearObject(formObject.cntc_eml);
			break;

		case "btn_SRCH_SET":
			doActionIBSheet(sheetObjects[0], document.form, "btn_SRCH_SET", "", "");
			break;

		case "btn_exceldown":
			doActionIBSheet(sheetObjects[0], document.form, "btn_exceldown", "", "");
			break;

		case "btn_preview":
			doActionIBSheet(sheetObjects[0], document.form, "btn_preview", "", "");
			break;

		case "btn_previewprint":
			doActionIBSheet(sheetObjects[0], document.form, "btn_previewprint", "", "");
			break;

		case "btn_upload":
			doActionIBSheet(sheetObjects[0], document.form, "btn_upload", "", "");
			break;

		case "btn_reject":
			doActionIBSheet(sheetObjects[0], document.form, "btn_reject", "", "");
			break;

		case "btn_delete":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01, "", "");
			break;

		case "btn_pending":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02, "", "");
			break;
		case "btn_hold":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05, "", "");
			break;			
		case "btns_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.rqst_from_dt, formObject.rqst_to_dt, 'yyyy-MM-dd');
			break;

		case "btn_bkg_no_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03, "", "");
			break;
			
		case "btn_check_split_detail":
			doActionIBSheet(sheetObjects[0], document.form, "btn_check_split_detail", "", "");
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 콤보 Object를 배열로 등록
 * @param combo_obj 콤보오브젝트
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function initCombo(comboObj) {
	comboObj.MultiSelect = true;
	// comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
}

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm("keydown", "obj_keydown", formObject);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", formObject);
	axon_event.addListenerFormat("focus", "form_onFocus", formObject);
	axon_event.addListenerFormat("blur", "form_onBlur", formObject);
	axon_event.addListenerForm  ("change", "form_onChange", formObject);

	// axon_event.addListener("keydown", "ComKeyEnter", "form");
	// axon_event.addListenerForm("blur", "form1_blur", formObject);
	applyShortcut();
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	combo1 = comboObjects[0];
	comboCnt = comboObjects.length;
	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}

	initRdConfig(rdObjects[0]);
	
	if(ComGetObjValue(document.form.rhq_ofc_cd) != "NYCRA" && ComGetObjValue(document.form.usr_ofc_cd) != "SELCTY" ){
		ComBtnDisable("btn_hold");
	}
	
	if(ComGetObjValue(document.form.usr_ofc_cd) != "SELCTY" ){
		ComSetDisplay("btn_retrieve_inttra1", false);
		ComSetDisplay("btn_reject_inttra1", false);
	}
	ComBtnDisable("btn_reject_inttra");

	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, "", "");
	document.form.sXml.value = null;
	initControl();
	
	// 2017.09.21 iylee Inquiry 화면인 경우 버튼 비활성화
	if(ComGetObjValue(document.form.isInquiry) == "Y"){
	    var objs = document.all.item("buttonLayer");
	    objs.style.display = "none";
	    ComSetDisplay("btn_retrieve_inttra1", false);
		ComSetDisplay("btn_reject_inttra1", false);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {
			// 높이 설정
			// style.height = 140;
			style.height = 340;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(93, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode(true, true, true, true, false, false);
			InitHeadMode(true, true, true, true, false, false);
			if(document.form.usr_ofc_cd.value == "SELSC"){			
				// 10개씩 Enter
				var HeadTitle1 = "|Chk|Seq.|Doc\nType|Booking|Customer|Booking|Booking|DEL|Request|Request" +
								 "|Special(D/R/A/B)|CNTR TP/SZ|Request|Request|Booking|Booking|Booking|Booking|Booking|Booking" +
								 "|Request|Request|Request|WEB Manual Reason|WEB Manual Reason|WEB Manual Reason|Customer|Customer|Contract\nNO.|Contract\nHolder" +
								 "|Handling\nOffice|Origin|Delivery|POR|POR|POL|POD|DEL|Ship Date|Vessel" +
								 "|Vessel|Vessel|P/O No.|E-mail|Upload to ALPS|Upload to ALPS|Upload to ALPS|Upload to ALPS|WEB S/I Audit|EDI ID" +
								 "|TEU|CMTD\nCode|CMDT Name|External Remark|StaffNm|sls_cfm_nm|rqstNo|rqstSeq|senderId|vvd|pol|pod" +
								 "|Rejection/\nPending\nReason|Hold/Pending/Reject Status|Hold/Pending/Reject Status|Hold/Pending/Reject Status|Hold/Pending/Reject Status|External Request User ID|BL No.\n(from e-SI)|Cust Ref No" +
								 "|Xter Rqst Seq|AES/CAED/IE|Sales Confirm|Sales Confirm|1|2|3|4|5|6" +
								 "|7|8|9|0|BKGNOCHECK|VGM|Portal SVC|Portal SVC|Portal SVC|ITR Type" +
								 "|ITR Type|BAG DG";
				
				var HeadTitle2 = "|Chk|Seq.|Doc\nType|No.|Shipper|S.Rep|Lane|Code|Seq.|ST" +
								 "|Special(D/R/A/B)|CNTR TP/SZ|Date(LCL)|No.|Split|U/L|ST|DPCS|FO|NoRate" +
								 "|Date(GMT)|No.|Via|PC|Setup|Other|Consignee|Forwarder|Contract\nNO.|Contract\nHolder" +
								 "|Handling\nOffice|Origin|Delivery|Code|Name|POL|POD|Name|Ship Date|Code" +
								 "|Name|Voyage|P/O No.|E-mail|Office|Staff|Action Date|Auto|WEB S/I Audit|EDI ID" +
								 "|TEU|CMTD\nCode|CMDT Name|External Remark|StaffNm|sls_cfm_nm|rqstNo|rqstSeq|senderId|vvd" +
								 "|pol|pod|Rejection/\nPending\nReason|Office|Staff ID|Date|Status|External Request User ID|BL No.\n(from e-SI)|Cust Ref No" +
								 "|Xter Rqst Seq|AES/CAED/IE|Confirm|By|1|2|3|4|5|6" +
								 "|7|8|9|0|BKGNOCHECK|VGM|ITR|GTN|CSM|New AS" +
								 "|TRANS|BAG DG";
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,"ibflag");
				
				InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true,"slct_flg");
				InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq");
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "doc_tp_cd",false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "bkg_no",false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "sh_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "ob_srep_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "slan_cd",false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "xter_del_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "disp_xter_rqst_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "xter_bkg_rqst_sts_cd", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "spcl_cgo_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rqst_dt",false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "xter_rqst_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false,"split_sts_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bkg_upld_sts_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bkg_sts_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bl_doc_inp_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bl_fnt_ofc_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "non_rt_sts_cd",false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rqst_gmt_dt",false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "snaccs_split_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "xter_rqst_via_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "pctl_expt_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bkg_blck_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "other_flag", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "cn_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "ff_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "ctrt_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "ctrt_nm", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "hndl_ofc_cd", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "origin", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "delivery", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "xter_por_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "xter_por_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "xter_pol_cd", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "xter_pod_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "xter_del_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "rqst_dep_dt", false, "", dfDateYmd, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "vsl_cd", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "vsl_eng_nm", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "po_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "cntc_eml", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "ofc_cd", false, "", dfNone, 0, false, true);						
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "upld_usr_id", false, "", dfNone, 0, false, true);					
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "upld_dt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "sys_upld_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "si_aud_flg", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "xter_sndr_id", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "xter_teu", false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cmdt_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "cmdt_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 200, daLeft, true, "xter_rmk", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "upld_usr_nm");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "xter_rqst_acpt_usr_nm");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "rqst_no");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "rqst_seq");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "sender_id");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "vvd");
				
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "xter_pol_nm");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "xter_pod_nm");
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "xter_rjct_rsn_nm", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "xter_rqst_sts_ofc_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "xter_rqst_sts_usr_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "xter_rqst_sts_upd_dt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "xter_rqst_sts_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, false, "xter_rqst_sts_usr_id", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "bl_no_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "cust_ref_no", false, "", dfNone, 0, false, true);				
				
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "xter_rqst_rvis_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "xpt_ref_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rqst_acpt_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "xter_rqst_acpt_usr_id", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtHidden, 120, daCenter, true, "fax_log_ref_no", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "atch_file_path_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "eml_atch_file_nm", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "conv_atch_file_path_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "conv_eml_atch_file_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "sr_knd_cd", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tmplt_par_rto", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "xter_rqst_seq", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "xter_pnd_rsn_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rjct_rsn_rmk", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bkg_no_check", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vgm_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "itr_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "gtn_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "csm_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ulti_new_asia_cust_flg", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "ulti_trns_cust_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "bag_dg", false, "", dfNone, 0, false, true);
				
				InitDataValid(0, "bkg_no", vtEngUpOther, "0123456789");
				CountPosition = 0;
//				SetMergeCell (0, 49, 2, 1);
	
				sheetObj.FrozenCols = 5;
				
			}else{
				var HeadTitle1 = "|Chk|Seq.|Doc\nType|Booking|Booking|Booking|Booking|Booking|Booking|Booking" +
								 "|Booking|Request|Request|Request|Request|Request|Request|Request|WEB Manual Reason|WEB Manual Reason" +
								 "|WEB Manual Reason|Customer|Customer|Customer|Contract\nNO.|Contract\nHolder|Handling\nOffice|Origin" +
								 "|Delivery|POR|POR|POL|POD|DEL|DEL|Ship Date|Vessel|Vessel|Vessel|P/O No." +
								 "|E-mail|Upload to ALPS|Upload to ALPS|Upload to ALPS|Upload to ALPS|WEB S/I Audit|EDI ID|Special(D/R/A/B)|CNTR TP/SZ|TEU" +
								 "|CMTD\nCode|CMDT Name|External Remark|StaffNm|sls_cfm_nm|rqstNo|rqstSeq|senderId|vvd|pol" +
								 "|pod|Rejection\n/Pending\nReason|Hold/Pending/Reject Status|Hold/Pending/Reject Status|Hold/Pending/Reject Status|Hold/Pending/Reject Status|External Request User ID|BL No.\n(from e-SI)|Cust Ref No|Xter Rqst Seq" +
								 "|AES/CAED/IE|Sales Confirm|Sales Confirm|1|2|3|4|5|6|7" +
								 "|8|9|0|11|BKGNOCHECK|VGM|Portal SVC|Portal SVC|Portal SVC|ITR Type" +
								 "|ITR Type|BAG DG";
				
				var HeadTitle2 = "|Chk|Seq.|Doc\nType|No.|Split|Lane|U/L|ST|DPCS|FO" +
								 "|NoRate|Date(LCL)|Date(GMT)|No.|No.|Seq.|ST|Via|PC|Setup" +
								 "|Other|Shipper|Consignee|Forwarder|Contract\nNO.|Contract\nHolder|Handling\nOffice|Origin" +
								 "|Delivery|Code|Name|POL|POD|Code|Name|Ship Date|Code|Name|Voyage|P/O No." +
								 "|E-mail|Office|Staff|Action Date|Auto|WEB S/I Audit|EDI ID|Special(D/R/A/B)|CNTR TP/SZ|TEU" +
								 "|CMTD\nCode|CMDT Name|External Remark|StaffNm|sls_cfm_nm|rqstNo|rqstSeq|senderId|vvd|pol" +
								 "|pod|Rejection\n/Pending\nReason|Office|Staff ID|Date|Status|External Request User ID|BL No.\n(from e-SI)|Cust Ref No|Xter Rqst Seq" +
								 "|AES/CAED/IE|Confirm|By|1|2|3|4|5|6|7" +
								 "|8|9|0|11|BKGNOCHECK|VGM|ITR|GTN|CSM|New AS" +
								 "|TRANS|BAG DG";
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,"ibflag");
				
				InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true,"slct_flg");
				InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq");
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "doc_tp_cd",false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "bkg_no",false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false,"split_sts_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "slan_cd",false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bkg_upld_sts_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bkg_sts_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bl_doc_inp_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bl_fnt_ofc_flg", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "non_rt_sts_cd",false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rqst_dt",false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rqst_gmt_dt",false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "xter_rqst_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "snaccs_split_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "disp_xter_rqst_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "xter_bkg_rqst_sts_cd", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "xter_rqst_via_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "pctl_expt_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bkg_blck_flg", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "other_flag", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "sh_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "cn_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, false, "ff_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 80, daLeft, true, "ctrt_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "ctrt_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "hndl_ofc_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "origin", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "delivery", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "xter_por_cd", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "xter_por_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "xter_pol_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "xter_pod_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "xter_del_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "xter_del_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "rqst_dep_dt", false, "", dfDateYmd, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "vsl_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "vsl_eng_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "po_no", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 120, daLeft, true, "cntc_eml", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "ofc_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "upld_usr_id", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "upld_dt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "sys_upld_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "si_aud_flg", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "xter_sndr_id", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "spcl_cgo_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "xter_teu", false, "", dfInteger, 0, false, true);
				
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cmdt_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "cmdt_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "xter_rmk", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "upld_usr_nm");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "xter_rqst_acpt_usr_nm");				
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "rqst_no");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "rqst_seq");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "sender_id");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "vvd");
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "xter_pol_nm");
				
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "xter_pod_nm");
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "xter_rjct_rsn_nm", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "xter_rqst_sts_ofc_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "xter_rqst_sts_usr_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "xter_rqst_sts_upd_dt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "xter_rqst_sts_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 70, daCenter, false, "xter_rqst_sts_usr_id", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "bl_no_ctnt", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "cust_ref_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, true, "xter_rqst_rvis_seq", false, "", dfNone, 0, false, true);	
				
				InitDataProperty(0, cnt++, dtData, 120, daCenter, true, "xpt_ref_no", false, "", dfNone, 0, false, true);		
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rqst_acpt_desc", false, "", dfNone, 0, false, true);		
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "xter_rqst_acpt_usr_id", false, "", dfNone, 0, false, true);	
				InitDataProperty(0, cnt++, dtHidden, 120, daCenter, true, "fax_log_ref_no", false, "", dfNone, 0, false, true);				
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "atch_file_path_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "eml_atch_file_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "conv_atch_file_path_ctnt", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "conv_eml_atch_file_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "sr_knd_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "tmplt_par_rto", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "xter_rqst_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "xter_pnd_rsn_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "rjct_rsn_rmk", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bkg_no_check", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ob_srep_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vgm_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "itr_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "gtn_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "csm_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "ulti_new_asia_cust_flg", false, "", dfNone, 0, false, true);
				
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "ulti_trns_cust_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, "bag_dg", false, "", dfNone, 0, false, true);
				
				InitDataValid(0, "bkg_no", vtEngUpOther, "0123456789");
				CountPosition = 0;
//				SetMergeCell (0, 43, 2, 1);
	
				sheetObj.FrozenCols = 7;
			}
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, sCondParam, PageNo) {
	// sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSEARCH: //조회
		document.form.sXml.value = null;
		loguserid = formObj.usr_id.value;
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		if (sheetObj.id == "sheet1") {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
 
			var splitBkgYn = "N"; 
			if ( document.form.split_bkg_yn.checked == true ){
				splitBkgYn = "Y"
			}
			
			var sysUpldFlg = ""; 
			if ( document.form.sys_upld_flg.checked == true ){
				sysUpldFlg = "Y"
			}
			
			sheetObj.DoSearch("ESM_BKG_0228GS.do", FormQueryString(formObj)+"&split_bkg_yn="+splitBkgYn+"&sys_upld_flg="+sysUpldFlg,"page_no=1", false);
			// prompt('',"ESM_BKG_0228GS.do?"+FormQueryString(formObj)); 
			// var sXml = sheetObj.GetSearchXml("ESM_BKG_0228GS.do",
			// FormQueryString(formObj), "page_no=1", false);
			// sheetObj.loadSearchXml(sXml);
			ComOpenWait(false);
			var bColor = sheetObjects[0].RgbColor(0, 0, 255);
			var rColor = sheetObjects[0].RgbColor(255, 0, 0);
			var sColor = sheetObjects[0].RgbColor(187, 14, 216);
			var gColor = sheetObjects[0].RgbColor(47, 157, 39);
			for ( var i = 2; i < sheetObjects[0].RowCount + 2; i++) {
				//alert(sheetObjects[0].CellValue(i, "bkg_upld_sts_cd"));
				//alert(sheetObjects[0].CellValue(i, "non_rt_sts_cd"));
				var nonStsCd = sheetObjects[0].CellValue(i, "non_rt_sts_cd");
				
				if (sheetObjects[0].CellValue(i, "bkg_upld_sts_cd") == "R"
						|| sheetObjects[0].CellValue(i, "bkg_upld_sts_cd") == "D") {
					sheetObjects[0].RowFontColor(i) = rColor;
				} else if (sheetObjects[0].CellValue(i, "bkg_upld_sts_cd") == "N"
						|| sheetObjects[0].CellValue(i, "bkg_upld_sts_cd") == "P") {
					sheetObjects[0].RowFontColor(i) = bColor;
				}
				
				// 2017.10.18 No Rate 인 경우 색상 Control.
				// Booking Status가 'X'가 아니고 No Rate가 'R'인 경우에 초록색.
				if(sheetObjects[0].CellValue(i, "bkg_sts_cd") != "X" && nonStsCd == "R"){
					sheetObjects[0].RowFontColor(i) = gColor;
				} 
			}

			for ( var i = 2; i < sheetObjects[0].RowCount + 2; i++) {
				if (sheetObjects[0].CellValue(i, "bl_doc_inp_flg") == "Y") {
					sheetObjects[0].CellFontColor(i, "bl_doc_inp_flg") = sColor;
				}
				
				if(sheetObjects[0].CellValue(i, "bag_dg") == 'Y'){
					sheetObjects[0].CellFont("FontColor", i, 1, i, 50) = rColor;
				}
			}
		}
		break;

	case IBCLEAR: //OPEN			
		initCom(formObj);

		ComClearObject(formObj.xter_rqst_no);
		ComClearObject(formObj.xter_rqst_seq);
		ComClearObject(formObj.set_slct_flg);
		ComClearObject(formObj.xter_bkg_rqst_sts_cd);
		ComClearObject(formObj.bkg_upld_sts_cd);
		ComClearObject(formObj.xter_rqst_via_cd);
		ComClearObject(formObj.doc_tp_cd);
		ComClearObject(formObj.delivery);

		ComClearObject(formObj.bkg_no);
		ComClearObject(formObj.po_no);
		ComClearObject(formObj.por_cd);
		ComClearObject(formObj.pol_cd);
		ComClearObject(formObj.pod_cd);
		ComClearObject(formObj.del_cd);
		ComClearObject(formObj.origin);
		ComClearObject(formObj.hndl_ofc_cd);

		ComSetObjValue(formObj.bkg_cust_tp_cd, "S");
		ComClearObject(formObj.cust_cnt_cd);
		ComClearObject(formObj.cust_seq);
		ComClearObject(formObj.cust_nm);

		ComClearObject(formObj.cntc_eml);
		ComClearObject(formObj.xter_sndr_id);

		ComClearObject(formObj.ofc_cd);
		formObj.rqst_from_dt.value = ComGetDateAdd(null, "d", -1, "-");
		formObj.rqst_to_dt.value = ComGetNowInfo();
		formObj.hndl_ofc_cd.value = formObj.usr_ofc_cd.value;
		sheetObj.RemoveAll();

		break;

	case "btn_SRCH_SET": //조회조건 설정
		var param = "";

		ComOpenPopup("ESM_BKG_0232.do" + param, 825, 400, "PopupEsmBkg0232",
				"1,0,1,1,1", true);
		// ComOpenWindow("/hanjin/ESM_BKG_0232.do" + param, "PopupEsmBkg0232",
		// "dialogWidth:825px; dialogHeight:400px", true);
		break;

	case "btn_exceldown": //Excel down
		sheetObj.SpeedDown2Excel(1);
		break;

	case "btn_preview": //Preview
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		rdOpen(rdObjects[0], formObj, "preview");
		break;
		
	case "btn_previewprint": //Preview print
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		rdOpen(rdObjects[0], formObj, "print");
		break;
		
	case "btn_check_split_detail": // Split Detail Popup
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		callSplitClick(sheetObjects[0]);
		break;
		
	case "btn_upload": //Upload
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
		var chkRow = chkRowArr.split("|");
		//select doc type 체크 추가
		chkDocType(sheetObj, chkRow[0]); 		
		break;

	case "btn_reject": //Reject
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		var formObj = document.form;
		var bkgNo = null;
		var rqstNo = null;
		var rqstSeq = null;
		var senderId = null;
		var cntcEml = null;

		var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
		var arrRow = iCheckRow.split("|");
		for ( var idx = 0; idx < arrRow.length - 1; idx++) {
			bkgNo    = sheetObj.CellValue(arrRow[idx], "bkg_no");
			rqstNo   = sheetObj.CellValue(arrRow[idx], "xter_rqst_no");
			rqstSeq  = sheetObj.CellValue(arrRow[idx], "xter_rqst_seq");
			senderId = sheetObj.CellValue(arrRow[idx], "xter_sndr_id");
			cntcEml  = sheetObj.CellValue(arrRow[idx], "cntc_eml");
			formObj.vvd2.value		 	= sheetObj.CellValue(arrRow[idx], "vvd");
			formObj.vsl_nm2.value	 	= sheetObj.CellValue(arrRow[idx], "vsl_eng_nm");
			formObj.bkg_por_cd2.value 	= sheetObj.CellValue(arrRow[idx], "xter_por_cd");
			formObj.por_nm2.value 		= sheetObj.CellValue(arrRow[idx], "xter_por_nm");
			formObj.bkg_pol_cd2.value 	= sheetObj.CellValue(arrRow[idx], "xter_pol_cd");
			formObj.pol_nm2.value 		= sheetObj.CellValue(arrRow[idx], "xter_pol_nm");
			formObj.bkg_pod_cd2.value 	= sheetObj.CellValue(arrRow[idx], "xter_pod_cd");
			formObj.pod_nm2.value 		= sheetObj.CellValue(arrRow[idx], "xter_pod_nm");
			formObj.bkg_del_cd2.value 	= sheetObj.CellValue(arrRow[idx], "xter_del_cd");
			formObj.del_nm2.value	 	= sheetObj.CellValue(arrRow[idx], "xter_del_nm");
		} 

		var param = "?bkg_no=" + bkgNo + "&rqst_no="
				+ encodeURIComponent(rqstNo) + "&rqst_seq=" + rqstSeq
				+ "&sender_id=" + senderId + "&cntc_eml=" + cntcEml
				+ "&bkg_upld_sts_cd=R";
		ComOpenWindowCenter("/hanjin/ESM_BKG_0902.do" + param,
				"PopupEsmBkg0902", 500, 500, true);
		break;
		
	case "btn_inttra_reject": //Reject
		reject_rmk = null;
		reject_code = null;
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		
		var param = "?bkg_no=" + "" + "&rqst_no="
		+ "" + "&rqst_seq=" + ""
		+ "&sender_id=" + "" + "&cntc_eml=" + ""
		+ "&bkg_upld_sts_cd=M";
		ComOpenWindowCenter("/hanjin/ESM_BKG_0902.do" + param, "PopupEsmBkg0902", 500, 500, true);

		if (reject_code == '' || reject_code == null ) {
			return false;
		}
		
		var formObj = document.form;
		var rqstNo = null;
		var rqstSeq = null;
		var senderId = null;
		var reject_cnt = 0;
		
		if (sheetObj.id == "sheet1") {
			var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
			var arrRow = iCheckRow.split("|");
			for ( var idx = 0; idx < arrRow.length - 1; idx++) {
				rqstNo   = sheetObj.CellValue(arrRow[idx], "xter_rqst_no");
				rqstSeq  = sheetObj.CellValue(arrRow[idx], "xter_rqst_seq");
				senderId = sheetObj.CellValue(arrRow[idx], "xter_sndr_id");
				
				var sParam="f_cmd=4&sender_id="+senderId+"&rqst_no="+encodeURIComponent(rqstNo)+"&rqst_seq="+
				           rqstSeq+"&multi_reject=Y&eml_snd_yn=N&reject_reason_cd="+reject_code+"&reject_reason="+encodeURIComponent(reject_rmk);
				//formObj.f_cmd.value = MODIFY;
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0902GS.do", sParam);
				if(ComGetEtcData(sXml, "SuccessYn") != "Y"){
					sheetObj.LoadSearchXml(sXml);
					break;
				} else {
					reject_cnt = reject_cnt + 1;
				} 
			}
			
			ComShowCodeMessage('BKG00166');
			formObj.inttra_rtv.value = "Y";
			ComBtnEnable("btn_reject_inttra");
			doActionIBSheet(sheetObj, document.form, IBSEARCH, "", "");
		}
		
		break;

	case IBSEARCH_ASYNC01: //Delete
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		if (sheetObj.id == "sheet1") {
			var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
			var arrRow = iCheckRow.split("|");
			for ( var idx = 0; idx < arrRow.length - 1; idx++) {
				sheetObj.CellValue(arrRow[idx], "rqst_no") = sheetObj.CellValue(arrRow[idx], "xter_rqst_no");
				sheetObj.CellValue(arrRow[idx], "rqst_seq") = sheetObj.CellValue(arrRow[idx], "xter_rqst_seq");
				sheetObj.CellValue(arrRow[idx], "sender_id") = sheetObj.CellValue(arrRow[idx], "xter_sndr_id");
			}

			formObj.f_cmd.value = MODIFY01;
			// sheetObj.DoSave("ESM_BKG_0228GS.do", FormQueryString(formObj),
			// "slct_flg", true, true);
			// sheetObj.ShowDebugMsg = true;
			sheetObj.DoSave("ESM_BKG_0228GS.do", "f_cmd=" + MODIFY01,
					"slct_flg", true, true);
			// sheetObj.ShowDebugMsg = false;
			for ( var idx = 0; idx < arrRow.length - 1; idx++) {
				sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") = 'D';
			}
		}
		break;

	case IBSEARCH_ASYNC02: //Pending
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		var formObj = document.form;
		var bkgNo = null;
		var rqstNo = null;
		var rqstSeq = null;
		var senderId = null;
		var cntcEml = null;
		var docTpCd = null;
	
		var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
		var arrRow = iCheckRow.split("|");
		for ( var idx = 0; idx < arrRow.length - 1; idx++) {
			bkgNo = sheetObj.CellValue(arrRow[idx], "bkg_no");
			rqstNo = sheetObj.CellValue(arrRow[idx], "xter_rqst_no");
			rqstSeq = sheetObj.CellValue(arrRow[idx], "xter_rqst_seq");
			senderId = sheetObj.CellValue(arrRow[idx], "xter_sndr_id");
			cntcEml = sheetObj.CellValue(arrRow[idx], "cntc_eml");
			docTpCd = sheetObj.CellValue(arrRow[idx], "doc_tp_cd");
			formObj.vvd2.value = sheetObj.CellValue(arrRow[idx], "vvd");
			formObj.vsl_nm2.value = sheetObj.CellValue(arrRow[idx], "vsl_eng_nm");
			formObj.bkg_por_cd2.value = sheetObj.CellValue(arrRow[idx], "xter_por_cd");
			formObj.por_nm2.value = sheetObj.CellValue(arrRow[idx], "xter_por_nm");
			formObj.bkg_pol_cd2.value = sheetObj.CellValue(arrRow[idx], "xter_pol_cd");
			formObj.pol_nm2.value = sheetObj.CellValue(arrRow[idx], "xter_pol_nm");
			formObj.bkg_pod_cd2.value = sheetObj.CellValue(arrRow[idx], "xter_pod_cd");
			formObj.pod_nm2.value = sheetObj.CellValue(arrRow[idx], "xter_pod_nm");
			formObj.bkg_del_cd2.value = sheetObj.CellValue(arrRow[idx], "xter_del_cd");
			formObj.del_nm2.value = sheetObj.CellValue(arrRow[idx], "xter_del_nm");
		} 
	
		var param = "?bkg_no=" + bkgNo + "&rqst_no="
				+ encodeURIComponent(rqstNo) + "&rqst_seq=" + rqstSeq
				+ "&sender_id=" + senderId + "&cntc_eml=" + cntcEml
				+ "&doc_tp_cd=" + docTpCd + "&bkg_upld_sts_cd=P";
		ComOpenWindowCenter("/hanjin/ESM_BKG_0902.do" + param,
				"PopupEsmBkg0902", 500, 500, true);

//		if (sheetObj.id == "sheet1") {
//			for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
//				sheetObj.RowStatus(i) = "R";
//			}
//			var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
//			var arrRow = iCheckRow.split("|");
//			for ( var idx = 0; idx < arrRow.length - 1; idx++) {
//				sheetObj.RowStatus(arrRow[idx]) = "U";
//				sheetObj.CellValue(arrRow[idx], "rqst_no") = sheetObj
//						.CellValue(arrRow[idx], "xter_rqst_no");
//				sheetObj.CellValue(arrRow[idx], "rqst_seq") = sheetObj
//						.CellValue(arrRow[idx], "xter_rqst_seq");
//				sheetObj.CellValue(arrRow[idx], "sender_id") = sheetObj
//						.CellValue(arrRow[idx], "xter_sndr_id");
//			}
//			formObj.f_cmd.value = MODIFY02;
//			// sheetObj.DoSave("ESM_BKG_0228GS.do", FormQueryString(formObj),
//			// "slct_flg", true, true);
//			sheetObj.DoSave("ESM_BKG_0228GS.do", "f_cmd=" + MODIFY02,
//					"slct_flg", true, true);
//			for ( var idx = 0; idx < arrRow.length - 1; idx++) {
//				sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") = 'P';
//			}
//		}
		break;

	case IBSEARCH_ASYNC03: //Booking No Save
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		if (sheetObj.id == "sheet1") {
			var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
			var chkRow = chkRowArr.split("|");
			sheetObj.RowStatus(chkRow) = "U";
			sheetObj.CellValue(chkRow, "rqst_no") = sheetObj.CellValue(chkRow, "xter_rqst_no");
			sheetObj.CellValue(chkRow, "rqst_seq") = sheetObj.CellValue(chkRow, "xter_rqst_seq");
			sheetObj.CellValue(chkRow, "sender_id") = sheetObj.CellValue(chkRow, "xter_sndr_id");

			// var sXml = sheetObj.GetSaveXml("ESM_BKG_0228GS.do", "f_cmd=" +
			// MODIFY03 + "&" + ComSetPrifix(sheetObj.GetSaveString(true),
			// "sheet1_"));
			var sXml = sheetObj.DoSave("ESM_BKG_0228GS.do",
					"f_cmd=" + MODIFY03, "slct_flg", true, true);

			// if (sXml) {
			// ComBkgSaveCompleted();
			// } else {
			// ComShowMessage(msgs['BKG00167']);
			// }
		}
		break;
		
	case IBSEARCH_ASYNC05: //Hold
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		if (sheetObj.id == "sheet1") {
			var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
			var arrRow = iCheckRow.split("|");
			for ( var idx = 0; idx < arrRow.length - 1; idx++) {
				sheetObj.CellValue(arrRow[idx], "rqst_no") = sheetObj.CellValue(arrRow[idx], "xter_rqst_no");
				sheetObj.CellValue(arrRow[idx], "rqst_seq") = sheetObj.CellValue(arrRow[idx], "xter_rqst_seq");
				sheetObj.CellValue(arrRow[idx], "sender_id") = sheetObj.CellValue(arrRow[idx], "xter_sndr_id");
			}

			formObj.f_cmd.value = MODIFY05;
			// sheetObj.DoSave("ESM_BKG_0228GS.do", FormQueryString(formObj),
			// "slct_flg", true, true);
			// sheetObj.ShowDebugMsg = true;
			sheetObj.DoSave("ESM_BKG_0228GS.do", "f_cmd=" + MODIFY05,
					"slct_flg", true, true);
			// sheetObj.ShowDebugMsg = false;
			for ( var idx = 0; idx < arrRow.length - 1; idx++) {
				sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") = 'H';
			}
		}
		break;		
	}
}

function addValueNo(multi_value, multi_code){
	reject_rmk = multi_value;
	reject_code = multi_code;
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		ComBkgSaveCompleted(); // 서버메세지 처리
	}
}

function openUploadWindow(sheetObj, row) {
	//sheetObj.WaitImageVisible=false;
	if (encodeURIComponent(sheetObj.CellValue(row, "xter_sndr_id") == "SEANACCS")) {
		ComOpenWait(true);
		var param01 = "f_cmd=" + SEARCH02 + "&xter_rqst_no="
				+ encodeURIComponent(sheetObj.CellValue(row, "xter_rqst_no"))
				+ "&xter_sndr_id="
				+ encodeURIComponent(sheetObj.CellValue(row, "xter_sndr_id"))
				+ "&xter_rqst_seq="
				+ encodeURIComponent(sheetObj.CellValue(row, "xter_rqst_seq"))
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0228GS.do", param01);
		ComOpenWait(false);

		if (ComGetEtcData(sXml, "xterCreFlag") == "Y") {
			ComShowCodeMessage("BKG02068", "Creation");
			return false;
		}
		if (ComGetEtcData(sXml, "xterSrFlag") == "Y") {
			ComShowCodeMessage("BKG02068", "Previous");
			return false;
		}
	}

	var param = "?rqst_no="
			+ encodeURIComponent(sheetObj.CellValue(row, "xter_rqst_no"))
			+ "&rqst_seq="
			+ encodeURIComponent(sheetObj.CellValue(row, "xter_rqst_seq"))
			+ "&sender_id="
			+ encodeURIComponent(sheetObj.CellValue(row, "xter_sndr_id"))
			+ "&bkg_no="
			+ encodeURIComponent(sheetObj.CellValue(row, "bkg_no")) 
			+ "&fax_log_ref_no="
			+ encodeURIComponent(sheetObj.CellValue(row, "fax_log_ref_no"))
//			+ "&conv_atch_file_path_ctnt="
//			+ encodeURIComponent(sheetObj.CellValue(row, "conv_atch_file_path_ctnt"))
//			+ "&conv_eml_atch_file_nm="
//			+ encodeURIComponent(sheetObj.CellValue(row, "conv_eml_atch_file_nm"))			
			+ "&sr_knd_cd="
			+ encodeURIComponent(sheetObj.CellValue(row, "sr_knd_cd"))			
			+ "&tmplt_par_rto="
			+ encodeURIComponent(sheetObj.CellValue(row, "tmplt_par_rto"))
			+ "&xter_rqst_via_cd="
			+ encodeURIComponent(sheetObj.CellValue(row, "xter_rqst_via_cd"))
			;

	var date = new Date();
	var toDay = date.getYear() + "" + (date.getMonth() + 1) + ""
			+ date.getDate() + "" + date.getHours() + "" + date.getMinutes()
			+ "" + date.getSeconds();
	var winIdx = openUploadWindowCheck();
	if (winIdx == 99) {
		ComShowMessage(msgs['BKG95043']);
		return false;
	} else {
		arrWindow[winIdx] = ComOpenWindowCenter("/hanjin/ESM_BKG_0229.do"
				+ param, "PopupEsmBkg0229" + toDay, 1025, 720, false, "yes");
	}
}

function openUploadWindowCheck() {
	for ( var idx = 0; idx < arrWindow.length; idx++) {
		if (arrWindow[idx] == null || arrWindow[idx].closed)
			return idx;
	}
	return 99;
}

/*
 * 모든 조건 값들을 초기화 한다.
 * */
function initCom(formObject) {
	//Status Combo			
	// 최초 load시 같이 조회함
	// formObject.f_cmd.value = SEARCH01;
	// var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0228GS.do",
	// FormQueryString(formObject));
	var sXml = ComGetObjValue(formObject.sXml);
	arrMultiCombo = sXml.split(iterator);

	ComXml2ComboItem(arrMultiCombo[0], formObject.xter_bkg_rqst_sts_cd, "val", "val|desc");
	ComXml2ComboItem(arrMultiCombo[1], formObject.bkg_upld_sts_cd, "val", "val|desc");
	// var itemindex = formObject.bkg_upld_sts_cd.FindIndex ('N', 0);
	// alert(itemindex);
	formObject.bkg_upld_sts_cd.CheckIndex(0) = true;
	formObject.bkg_upld_sts_cd.CheckIndex(2) = true;
	ComXml2ComboItem(arrMultiCombo[2], formObject.xter_rqst_via_cd, "val", "val|desc");
	ComXml2ComboItem(arrMultiCombo[3], formObject.doc_tp_cd, "val", "val|desc");
	ComXml2ComboItem(arrMultiCombo[4], formObject.delivery, "val", "val|desc");
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH:
			//2011.09.09 대량 조회를 피하기위한 체크 
			if(
					formObj.inttra_rtv.value == "N" && 
					ComIsNull(formObj.vvd) 	&&
					ComIsNull(formObj.chn_agn_cd) &&
					ComIsNull(formObj.lane) &&
					(formObj.set_slct_flg.checked ==false) &&
					ComIsNull(formObj.xter_rqst_no) &&
					ComIsNull(formObj.xter_rqst_seq) &&
					ComIsNull(formObj.xter_rqst_via_cd.Code) &&
					ComIsNull(formObj.doc_tp_cd.Code) &&
					ComIsNull(formObj.origin) &&
					ComIsNull(formObj.delivery.Code) &&
					ComIsNull(formObj.bkg_no) &&
					ComIsNull(formObj.hndl_ofc_cd) &&
					ComIsNull(formObj.pol_cd) &&
					ComIsNull(formObj.pod_cd) &&
					ComIsNull(formObj.po_no) &&
					ComIsNull(formObj.ofc_cd) &&
					ComIsNull(formObj.por_cd) &&
					ComIsNull(formObj.del_cd) &&
					ComIsNull(formObj.cust_cnt_cd) &&
					ComIsNull(formObj.cust_seq) &&
					ComIsNull(formObj.cust_nm) &&
					(formObj.split_bkg_yn.checked ==false) &&
					ComIsNull(formObj.xter_sndr_id) &&
					ComIsNull(formObj.cntc_eml) 
					){
				//At least one(1) search element should be filled (eg. handling office).
				ComShowCodeMessage("BKG01146");
				return false;
			}
			
			if (formObj.rqst_from_dt.value == "") {
				ComShowCodeMessage("COM12114", "Request DT");
				formObj.rqst_from_dt.focus();
				return false;
			}
			if (formObj.rqst_to_dt.value == "") {
				ComShowCodeMessage("COM12114", "Request DT");
				formObj.rqst_to_dt.focus();
				return false;
			}
			if (formObj.rqst_from_dt.value != ""
					&& formObj.rqst_to_dt.value != "") {
				if (ComGetDaysBetween(formObj.rqst_from_dt, formObj.rqst_to_dt) < 0) {
					ComShowMessage(msgs['BKG00112']);
					return false;
				}
			}
			if(!ComIsNull(formObj.cust_seq)){
				if(!ComIsNumber(formObj.cust_seq)){
		 			ComShowCodeMessage("BKG00340");
					formObj.cust_seq.focus();
					return false;
				}
			}			
			// maximum 조회기간이 1개월
			if(!ComBkgMonthsBetweenCheck(formObj.rqst_from_dt.value, formObj.rqst_to_dt.value, "1")){
				ComShowMessage(msgs['BKG00605']);
                ComSetFocus(formObj.rqst_from_dt);
                return false;
            }
			break;
			
		case "btn_preview":
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") > 1) {
				ComShowMessage(msgs['BKG00362']);
				return false;
			}
			break;

		case "btn_previewprint":
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			//			if (sheetObj.CheckedRows("slct_flg") > 1) {
			//				ComShowMessage(msgs['BKG00362']);
			// return false;
			// }
			break;

		case "btn_upload":
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") > 1) {
				ComShowMessage(msgs['BKG00362']);
				return false;
			}
			break;
			
		case "btn_check_split_detail": /// 2011.05.26 Added
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			} 
			if (sheetObj.CheckedRows("slct_flg") > 1) {
				ComShowMessage(msgs['BKG00362']);
				return false;
			}
			var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
			var arrRow = iCheckRow.split("|");
			var idx = 0; 
//			if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
//				ComShowMessage(msgs['BKG00471']);
//				return false;
//			}
//			if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
//				ComShowMessage(msgs['BKG00473']);
//				return false;
//			}
//			if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "F") {
//				ComShowMessage(msgs['BKG02049']);
//				return false;
//			}
			if ( sheetObj.CellValue(arrRow[idx], "split_sts_cd").indexOf("/") < 0 
					&& sheetObj.CellValue(arrRow[idx], "split_sts_cd") != "S" 
					// && sheetObj.CellValue(arrRow[idx], "split_sts_cd") != "F" // Except F case  
				) {
				ComShowMessage(msgs['BKG02079']);
				return false;
			}
			break;
			
		case "btn_reject":
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			} else {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
				var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
				var arrRow = iCheckRow.split("|");

				for ( var idx = 0; idx < arrRow.length - 1; idx++) {
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
						ComShowMessage(msgs['BKG00471']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
						ComShowMessage(msgs['BKG00473']);
						return false;
					}
				}
			}
			break;
			
		case "btn_inttra_reject":
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			} else {
				var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
				var arrRow = iCheckRow.split("|");
				
				for ( var idx = 0; idx < arrRow.length - 1; idx++) {
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
						ComShowMessage(msgs['BKG00471']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
						ComShowMessage(msgs['BKG00473']);
						return false;
					}
				}
			}
			break;
		
		case IBSEARCH_ASYNC01:
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			} else {
				var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
				var arrRow = iCheckRow.split("|");
				for ( var idx = 0; idx < arrRow.length - 1; idx++) {
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
						ComShowMessage(msgs['BKG00471']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
						ComShowMessage(msgs['BKG00473']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "xter_rqst_via_cd") == "INT" && sheetObj.CellValue(arrRow[idx], "bkg_sts_cd") == "" && sheetObj.CellValue(arrRow[idx], "doc_tp_cd") == "B" ) {
						ComShowMessage(msgs['BKG08277']); //Do not select INT bookings to delete.
						return false;
					}
				}
			}
			break;

		case IBSEARCH_ASYNC02:
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			} else {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
				var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
				var arrRow = iCheckRow.split("|");
				for ( var idx = 0; idx < arrRow.length - 1; idx++) {
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
						ComShowMessage(msgs['BKG00471']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
						ComShowMessage(msgs['BKG00473']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "P") {
						ComShowMessage(msgs['BKG00472']);
						return false;
					}
				}
			}
			break;

		case IBSEARCH_ASYNC03:
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			} else {
				if (sheetObj.CheckedRows("slct_flg") > 1) {
					ComShowMessage(msgs['BKG00362']);
					return false;
				}
				var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
				var arrRow = iCheckRow.split("|");
				for ( var idx = 0; idx < arrRow.length - 1; idx++) {
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
						ComShowMessage(msgs['BKG00471']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
						ComShowMessage(msgs['BKG00473']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "F") {
						ComShowCodeMessage("BKG02049");
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "SEANACCS"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "C1T0W"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "C1T0S"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "C1T0M"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "C1T0P"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "C1S0"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T612" //2011.10.19 add jsy 
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T613"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T614"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T615"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T621"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T514"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T515"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T516"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T517"
							&& sheetObj.CellValue(arrRow[idx], "xter_sndr_id") != "T518"
								) {
						ComShowCodeMessage("BKG02060");
						return false;
					}
				}
			}
		case IBSEARCH_ASYNC05:
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			} else {
				var iCheckRow = sheetObj.FindCheckedRow("slct_flg");
				var arrRow = iCheckRow.split("|");
				for ( var idx = 0; idx < arrRow.length - 1; idx++) {
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "D") {
						ComShowMessage(msgs['BKG00471']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "R") {
						ComShowMessage(msgs['BKG00473']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "P") {
						ComShowMessage(msgs['BKG00472']);
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "F") {
						ComShowCodeMessage("BKG02049");
						return false;
					}
					if (sheetObj.CellValue(arrRow[idx], "bkg_upld_sts_cd") == "H") {
						ComShowCodeMessage("BKG08228");
						return false;
					}
				}
			}
			
			break;
		}
	}

	return true;
}

/**
 * 마우스 IN일때 
 */
function form_onFocus() {
	//입력Validation 확인하기
	switch (event.srcElement.name) {
	case "rqst_from_dt":
		ComClearSeparator(event.srcElement);
		break;
	case "rqst_to_dt":
		ComClearSeparator(event.srcElement);
		break;
	}
}

function form_onBlur() {
	switch (event.srcElement.name) {
	case "rqst_from_dt":
		ComAddSeparator(event.srcElement);
		break;
	case "rqst_to_dt":
		ComAddSeparator(event.srcElement);
		break;
	}
}

function obj_keydown() {
	var obj = event.srcElement;
	var vKeyCode = event.keyCode;
	var formObj = document.form;

	if (vKeyCode == 13) {
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, "", "");
	}
	return true;
}

function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	with (sheetObj) {
		Row = MouseRow;
		var colName = ColSaveName(MouseCol);
		if ("xter_rqst_acpt_usr_id" == colName) {
			MousePointer = "Hand";
			sText = CellText(Row, "xter_rqst_acpt_usr_nm");
			MouseToolTipText = sText;
		} else if ("upld_usr_id" == colName) {
			MousePointer = "Hand";
			sText = CellText(Row, "upld_usr_nm");
			MouseToolTipText = sText;
		} else {
			MouseToolTipText = "";
		}
	}
}

/**
 * 시트를 더블클릭했을 때 처리
 * @param row
 * @param col
 * @return
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	if (col != 1) {		
		var col_save_name = sheetObj.ColSaveName(col);
		if (col_save_name == "xter_rjct_rsn_nm" && (sheetObj.CellValue(row,"bkg_upld_sts_cd") == "R" || sheetObj.CellValue(row,"bkg_upld_sts_cd") == "P") ) {
			ComShowMemoPad(sheetObj, row, "rjct_rsn_rmk", true, 250, 300);
		} else {
			if(ComGetObjValue(document.form.isInquiry) != "Y"){
				//Doc Type check후 Upload
				chkDocType(sheetObj, row);
			}
		}
	}
}

/**
 * 시트를 클릭했을 때 처리
 */
function sheet1_OnClick(sheetObj, row, col) {
	if (col != 1) {		
		var col_save_name = sheetObj.ColSaveName(col);
		if (col_save_name == "xter_rjct_rsn_nm" && (sheetObj.CellValue(row,"bkg_upld_sts_cd") == "R" || sheetObj.CellValue(row,"bkg_upld_sts_cd") == "P")) {
			ComShowMemoPad(sheetObj, row, "rjct_rsn_rmk", true, 250, 300);
		} 
	}
} 

function initRdConfig(rdObject) {
	var Rdviewer = rdObject;
	Rdviewer.style.height = 0;

	Rdviewer.setbackgroundcolor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
}

function rdOpen(rdObject, formObject, viewType) {
	var sheetObj = sheetObjects[0];
	var Rdviewer = rdObject;

	// Rdviewer.SetAppendReport(1);
	Rdviewer.SetAppendReport(0);
	var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
	var chkRow = chkRowArr.split("|");

	if (viewType == "print") {
		for ( var idx = 0; idx < chkRow.length - 1; idx++) {
			var rdParam = "/rv " + "frm1_sender_id["
					+ sheetObj.CellValue(chkRow[idx], "xter_sndr_id")
					+ "] frm1_rqst_no["
					+ sheetObj.CellValue(chkRow[idx], "xter_rqst_no")
					+ "] frm1_rqst_seq["
					+ sheetObj.CellValue(chkRow[idx], "xter_rqst_seq")
					+ "] frm1_bkg_no["
					+ sheetObj.CellValue(chkRow[idx], "bkg_no") + "]";
			var rdUrl = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/";
			var rdFile = null;
			if (sheetObj.CellValue(chkRow[idx], "doc_tp_cd") == "B")
				rdFile = "ESM_BKG_0230B.mrd";
			else
				rdFile = "ESM_BKG_0230S.mrd";

			// alert(RD_path + rdUrl + rdFile, RDServer + rdParam+ "
			// /riprnmargin /rwait");
			Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam
					+ " /riprnmargin /rwait");
			Rdviewer.CMPrint();

			// Rdviewer.SetAppendReport(0);
			// Rdviewer.SetAppendReport(1);
		}
	} else {
		var rdParam = "/rv " + "frm1_sender_id["
				+ sheetObj.CellValue(chkRow[0], "xter_sndr_id")
				+ "] frm1_rqst_no["
				+ sheetObj.CellValue(chkRow[0], "xter_rqst_no")
				+ "] frm1_rqst_seq["
				+ sheetObj.CellValue(chkRow[0], "xter_rqst_seq")
				+ "] frm1_bkg_no[" + sheetObj.CellValue(chkRow[0], "bkg_no")
				+ "]";
		var rdUrl = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/";
		var rdFile = null;
		if (sheetObj.CellValue(chkRow[0], "doc_tp_cd") == "B")
			rdFile = "ESM_BKG_0230B.mrd";
		else
			rdFile = "ESM_BKG_0230S.mrd";

		formObject.com_mrdPath.value = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/"
				+ rdFile;
		formObject.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
		ComOpenRDPopup('resizable=yes');
	}
	//	Rdviewer.SetAppendReport(0);
}

/**
 * sheet1_OnSearchEnd 
 * Split Status Code가 'S'이 경우 해당 Line 모두 Bold로 변환
 * @param sheetObj
 * @param ErrMsg
 * @return
 * @since 2011.05.20
 * @author 김진승
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var tempSplitStsCd = null;
	var bColor = sheetObjects[0].RgbColor(0, 0, 255);
	for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
		tempSplitStsCd = sheetObj.CellValue(i, "split_sts_cd");
		if ( tempSplitStsCd.indexOf("S") >= 0 || tempSplitStsCd == "S") {  // S case
			sheetObj.CellFont("FontBold", i, 1, i, 50) = true;
			sheetObj.CellFont("FontColor", i, 1, i, 50) = bColor;
		}
	}
}

 /**
  * Queue Detail 상세 화면
  */
 function callSplitClick(sheetObj) { 
     if (sheetObj.RowCount < 1) {
         ComShowCodeMessage("BKG00495");
         return;
     }
     var chkRowArr = sheetObj.FindCheckedRow("slct_flg");
     var chkRow = chkRowArr.split("|");
     callSplitPop(sheetObj,chkRow[0]);
 }

 /**
  * Queue Detail 상세 화면
  */
 function callSplitPop(sheetObj,rowIdx) {
 	var formObj = document.form;
     if (rowIdx == "0" ){
	        ComShowCodeMessage("COM12189");
	        return;
     }
     var sts = sheetObjects[0].CellValue(rowIdx, "split_sts_cd");
     /*if (sts != "S"){
     	ComShowCodeMessage("BKG00063");
     	return;
     }*/
     
     var winIdx = openPopWindowCheck();
     var param   = new Array("xter_sndr_id","xter_rqst_no","xter_rqst_seq","bkg_no");
	 sParam = getGetSheetRowParam(sheetObj, rowIdx , "", param);
		
	 arrWindow[winIdx] = ComOpenWindowCenter("/hanjin/ESM_BKG_0445.do" + sParam+ "&pgmNo=ESM_BKG_0445", "SI_SPLIT_CANDIDATE", 1025, 650, true, "yes");
 }

 function openPopWindowCheck(){
	 for (var idx=0; idx< arrWindow.length ; idx++) {
		 if(arrWindow[idx] == null || arrWindow[idx].closed) 
			 return idx;
	 }	 
	 return 99;
 }

 function getGetSheetRowParam(sheetObj, Row, prefix, param){ // in cases that param equals save name
	var sParam = "?";
	with (sheetObj) {
		for(i=0;i<param.length;i++){
			sParam += "&"+param[i]+"=" + encodeURIComponent(CellValue(Row,prefix+param[i]));  
		}	
	}
	return sParam;
 }
 
 function chkDocType(sheetObj, Row){ 
	 //var formObj = document.form;
	 var sheetParam = "";
	 if (sheetObj.CellValue(Row, "bkg_no_check") != "" && sheetObj.CellValue(Row, "bkg_no_check") != sheetObj.CellValue(Row, "bkg_no")) {
		if(!ComShowConfirm(ComGetMsg("BKG08308"))){
			return false;
		}
	 }
	 
	 if (sheetObj.CellValue(Row,"xter_rqst_sts_usr_id") != loguserid && sheetObj.CellValue(Row,"bkg_upld_sts_cd") == 'H') {
 		if(!ComShowCodeConfirm("BKG08227",sheetObj.CellValue(Row,"bkg_no"),sheetObj.CellValue(Row,"xter_rqst_no"),sheetObj.CellValue(Row,"xter_rqst_sts_usr_id"))){
			return false;
 		}
  	 }
	 
	 if (sheetObj.CellValue(Row,"xter_rqst_sts_usr_id") == "BLACK_LIST" && sheetObj.CellValue(Row,"bkg_upld_sts_cd") == 'D') {
		 ComShowCodeMessage("BKG95086");
		 return false;
	 }	 
	 
	 if(sheetObj.CellValue(Row, "bag_dg") == 'Y'){
		 ComShowMessage("This Shipping Instruction may contain prohibited item.\n(Charcoal /Calcium Hypochloride)");
	 }
	 
	 if( sheetObj.CellValue(Row, "doc_tp_cd") == 'F'){
		  if( ComShowConfirm(ComGetMsg("BKG01167")) ){
			  executeUpload(sheetObj, Row);
		  }
	 }else	if( sheetObj.CellValue(Row, "doc_tp_cd") == 'E'){
		 if( ComShowConfirm(ComGetMsg("BKG01168", "AES")) ){
			 executeUpload(sheetObj, Row);
		 }
	 }else if( sheetObj.CellValue(Row, "doc_tp_cd") == 'C'){
		if(ComShowConfirm(ComGetMsg("BKG01168", "CAED"))){
			executeUpload(sheetObj, Row);
		}
	 }else if( sheetObj.CellValue(Row, "doc_tp_cd") == 'I'){
		if(ComShowConfirm(ComGetMsg("BKG01168", "IE"))){
			executeUpload(sheetObj, Row);
		}
	 }else{
		 openUploadWindow(sheetObj, Row);
	 }

 }
 
 function executeUpload(sheetObj, Row){
	 var sheetParam = "";
	 sheetParam = "&call_pgm_type="+sheetObj.CellValue(Row, "doc_tp_cd")
		+ "&bkg_no="+sheetObj.CellValue(Row, "bkg_no")
		+ "&xter_sndr_id="+sheetObj.CellValue(Row, "xter_sndr_id")
		+ "&xter_rqst_no="+sheetObj.CellValue(Row, "xter_rqst_no")
		+ "&xter_rqst_seq="+sheetObj.CellValue(Row, "xter_rqst_seq")
		
		var sXml = sheetObj.GetSaveXml('ESM_BKG_0228GS.do', "f_cmd= "+MODIFY04 + sheetParam); 
	 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "", "");
 }
 
function sheet1_OnMouseMove(sheetObj, button, Shift, X, Y) {
	with(sheetObj){
		 Row = MouseRow;
		 Col = MouseCol;
		 if (Col == 36) {
			 sText = CellText(Row,"upld_usr_nm");
			 MouseToolTipText = sText
			 MousePointer = "Hand";
			 window.status = MousePointer;
		 } else {
			 if(CellText(Row,"bkg_upld_sts_cd") == "P"){
				 sText = CellText(Row,"xter_pnd_rsn_nm");
				 MouseToolTipText = sText;
			 } else {
				 MouseToolTipText = "";		 
			 }
		 }
	}
}


function sysUploadFlg_onClick(sysUploadFlg){
	if(sysUploadFlg.checked == true ){		
		document.form.bkg_upld_sts_cd.Code = "";
		document.form.xter_rqst_via_cd.Code = "";
		document.form.doc_tp_cd.Code = "";
		
		document.form.bkg_upld_sts_cd.CheckIndex(1) = true;
		document.form.xter_rqst_via_cd.CheckIndex(0) = true;
		document.form.doc_tp_cd.CheckIndex(1) = true;
	}
}

function portalCtrctFlg_onClick(flg){
	if(flg.checked == true ){		
		sheetObjects[0].ColHidden("itr_flg") = false;
		sheetObjects[0].ColHidden("gtn_flg") = false;
		sheetObjects[0].ColHidden("csm_flg") = false;
		sheetObjects[0].ColHidden("ulti_new_asia_cust_flg") = false;
		sheetObjects[0].ColHidden("ulti_trns_cust_flg") = false;
	} else {
		sheetObjects[0].ColHidden("itr_flg") = true;
		sheetObjects[0].ColHidden("gtn_flg") = true;
		sheetObjects[0].ColHidden("csm_flg") = true;
		sheetObjects[0].ColHidden("ulti_new_asia_cust_flg") = true;
		sheetObjects[0].ColHidden("ulti_trns_cust_flg") = true;
	}
}
function form_onChange() {
	var srcObj = window.event.srcElement;
 	var srcName = srcObj.getAttribute("name");
 	var srcValue = srcObj.getAttribute("value");
 	var formObj = document.form;
 	switch (srcName) {
 		// No Rate의 R, F을 선택하면 Upload Status의 F를 자동 선택되게 한다.
	 	case "non_rt_sts_cd" :
	 		var noRateFlg = formObj.non_rt_sts_cd.value;
	 		if(noRateFlg == "R" || noRateFlg == "F"){
	 			formObj.bkg_upld_sts_cd.CheckIndex(1) = true;
	 		}
	 		break;	
 	}
}
//===== End of File =====