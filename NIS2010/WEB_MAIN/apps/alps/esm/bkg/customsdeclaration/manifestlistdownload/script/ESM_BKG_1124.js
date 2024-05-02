/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : esm_bkg_1124.js
 *@FileTitle : Europe Advanced Manifest : B/L Inquiry - customer Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-09-29
 *@LastModifier : 계기훈
 *@LastVersion : 1.0
 * 2010-09-29 계기훈
 * 1.0 Creation
 * -----------------------------------------------------
 * History
 * 2012.03.05 김보배 [CHM-201216338] [BKG] [EXS- ES, PT] BL inquiry Prev. Doc 컬럼 추가
 * 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
 * 2012.06.20 김보배 [CHM-201218404] [BKG] [EXS] "Hold Release" Manual Update 기능
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class B/L Inquiry : B/L Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1124() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var seal_knd_str = "M|E";
var seal_pty_tp_str = "CA|SH|AA|CU|AB|AC|TO";
// 전역변수
var intervalId = "";
var temp_cntr_no = '';
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject0 = sheetObjects[0]; // Tab1 : BL Info
	var sheetObject1 = sheetObjects[1]; // Tab2-1 : Container
	var sheetObject2 = sheetObjects[2]; // Tab3 : Customer
	var sheetObject3 = sheetObjects[3]; // Tab2-2 : Container MF
	var sheetObject4 = sheetObjects[4]; // Tab4 : DG
	/** **************************************************** */
	var formObject = document.form;
	// try{
	var srcName = window.event.srcElement.getAttribute("name");
	switch (srcName) {
	case "btn_Retrieve":
		doActionIBSheet(sheetObject1, formObject, IBSEARCH);
		break;
	case "btn_New":
		doActionIBSheet(sheetObject1, formObject, IBRESET);
		break;
	case "btn_Save":
		doActionIBSheet(sheetObject1, formObject, IBSAVE);
		break;
	case "btn_Mark":
		doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
		break;
	case "btn_Transmit":
		doActionIBSheet(sheetObject1, formObject, MULTI01);
		break;
	case "btn_Close":
		window.close();
		break;
	case "btn_RowAdd1":
		doActionIBSheet(sheetObject2, formObject, IBINSERT);
		break;
	case "btn_RowAdd2":
		doActionIBSheet(sheetObject3, formObject, IBINSERT);
		break;
	case "btn_RowAdd3":
		doActionIBSheet(sheetObject4, formObject, IBINSERT);
		break;
	case "btn_RowDel1":
		doActionIBSheet(sheetObject2, formObject, IBDELETE);
		break;
	case "btn_RowDel2":
		doActionIBSheet(sheetObject3, formObject, IBDELETE);
		break;
	case "btn_RowDel3":
		doActionIBSheet(sheetObject4, formObject, IBDELETE);
		break;
	case "pop_shipper":
		doActionIBSheet(sheetObject1, formObject, COMMAND01);
		break;
	case "pop_fwrd":
		doActionIBSheet(sheetObject1, formObject, COMMAND05);
		break;
	case "pop_consignee":
		doActionIBSheet(sheetObject1, formObject, COMMAND03);
		break;
	case "pop_notify":
		doActionIBSheet(sheetObject1, formObject, COMMAND04);
		break;
	case "btn_prevDoc_pop":
		var param= "";
		param = "bl_no="+formObject.bl_no.value;
		param += "&pol_cd="+formObject.pol_cd.value;
		param += "&pgmNo=ESM_BKG_1124";
		ComOpenPopup("/hanjin/ESM_BKG_1146.do?"+param, 600, 450, "", "1,0,1,1,1,1", true, true);
		break;		
	}// end switch
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 콤보 Object를 comboObjects 배열에 등록
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Customer Info.", -1);
			InsertTab(cnt++, "Container Info.", -1);
			InsertTab(cnt++, "Danger Info.", -1);
		}
		break;
	}
}

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
}

/**
 * 컨테이너 리스트 콤보 변경시 이벤트
 * 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function vvd_OnChange(comboObj, value, text) {
	form.cstms_yd_cd.value = text.split("|")[1];
}

/**
 * Combo Object 초기화
 * 
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	
	}
}

var start_bl_no_flag = false;// 초기 bl_no가 유효하면 bl_no_flag 를 true 로 세팅한다.
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	
	ComSetDisplay("msg_func_hold_field", false);
	
	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

		sheetObjects[i].WaitImageVisible = false;
	}

	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}

	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("FocusIn", "obj_FocusIn", document.form);
	axon_event.addListenerForm("FocusOut", "obj_FocusOut", document.form);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('keydown', 'ComKeyEnter', document.form, "s_cust_cnt_cd", "s_cust_seq", "s_cust_nm",
			"s_cust_addr", "s_cust_cty_nm", "s_cstms_decl_cnt_cd", "s_cust_zip_id", "s_eur_cstms_st_nm", "s_eori_no", "s_eori_no_ori",
			"c_cust_cnt_cd", "c_cust_seq", "c_cust_nm", "c_cust_addr", "c_cust_cty_nm", "c_cstms_decl_cnt_cd","c_cust_zip_id", "c_eur_cstms_st_nm", "c_eori_no", "c_eori_no_ori",
			"f_cust_cnt_cd", "f_cust_seq", "f_cust_nm", "f_cust_addr", "f_cust_cty_nm", "f_cstms_decl_cnt_cd","f_cust_zip_id", "f_eur_cstms_st_nm", "f_eori_no", "f_eori_no_ori",
			"n_cust_cnt_cd", "n_cust_seq", "n_cust_nm", "n_cust_addr", "n_cust_cty_nm", "n_cstms_decl_cnt_cd","n_cust_zip_id", "n_eur_cstms_st_nm", "n_eori_no", "n_eori_no_ori");
	axon_event.addListenerForm('change', 'obj_change', document.form);

	if (document.form.bl_no.value != "") { 
		doActionIBSheet(sheetObjects[0], document.form, SEARCH02);

		var formObj = document.form;
		if (formObj.vvd.GetCount() == 1) {
		} else if (formObj.vvd.GetCount() > 1) {
			formObj.vvd.focus();
			ComShowCodeMessage('BKG95001', 'select a VVD|EU POL');
			SetButtonStatus();
			return;
		} else {
			ComShowCodeMessage('BKG03061', 'BL:' + formObj.bl_no.value);
			SetButtonStatus();
			return;
		}

		start_bl_no_flag = true;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	} else {
		document.form.bl_no.focus();
	}
	
	
	SetButtonStatus();
	
	
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 302;
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
			InitRowInfo(1, 1, 3, 100);

			// var HeadTitle1 = "| |Harmonized Tariff
			// Code|Description|Category";
			var HeadTitle1 = "| |bl_no|cstms_port_cd|type_cd|msg_func_id|vsl_cd|skd_voy_no|skd_dir_cd|snd_dt|mvmt_ref_no|vvd|vsl_eng_nm|lloyd_no|por_cd|bkg_pol_cd|bkg_pod_cd|del_cd|rcv_term_cd|de_term_cd|pck_qty|pck_tp_cd|act_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|cstms_desc|pol_cd|cstms_yd_cd";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 50, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bl_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
					"cstms_port_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "type_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
					"msg_func_id", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vsl_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "skd_voy_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "skd_dir_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "snd_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "mvmt_ref_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "vvd", false,
					"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "vsl_eng_nm",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "lloyd_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "por_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "bkg_pol_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "bkg_pod_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "del_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "rcv_term_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "de_term_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "pck_qty",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "pck_tp_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "act_wgt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "wgt_ut_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "meas_qty",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "meas_ut_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cstms_desc",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "pol_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cstms_yd_cd",
					false, "", dfNone, 0, false, false);
			CountPosition = 0;

			WaitImageVisible = false;
		}
		break;

	case "t1sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 130;
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
			InitRowInfo(1, 1, 2, 100);

			var HeadTitle1 = "|Sel.|Seq.|vvd|cstms_port_cd|bl_no|Container No.|TP/SZ|SEAL No. 1|SEAL No. 2|SEAL No. 2|Type|Package|Package|Weight|Weight|Measure|Measure";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "Sel");
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "vvd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true,
					"cstms_port_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "bl_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_no",
					false, "", dfEngUpKey, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true,
					"cntr_tpsz_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "seal_no",
					false, "", dfEngUpKey, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "seal_no2",
					false, "", dfEngUpKey, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtPopup, 20, daCenter, false,
					"seal_no3", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true,
					"full_mty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pck_qty",
					false, "", dfNullInteger, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pck_tp_cd",
					false, "", dfEngUpKey, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 100, daRight, true, "act_wgt",
					false, "", dfNullFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtCombo, 45, daCenter, true,
					"wgt_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 95, daRight, true, "meas_qty",
					false, "", dfNullFloat, 3, true, true, 12);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true,
					"meas_ut_cd", false, "", dfNone, 0, true, true, 3);
			InitDataCombo(0, "full_mty_cd", "F\tFull|P\tEmpty", "F|M");
			InitDataCombo(0, "wgt_ut_cd", "KGS|LBS", "KGS|LBS");
			InitDataValid(0, "seal_no", vtEngOther, "1234567890");
			InitDataValid(0, "seal_no2", vtEngOther, "1234567890");
			ShowButtonImage = 2;
			CountPosition = 0;
		}
		break;

	case "t2sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
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
			InitRowInfo(1, 1, 2, 100);

			var HeadTitle1 = "|Seq.|bl_no|vvd|cstms_port_cd";
			HeadTitle1 += "|S_BKG_CUST_TP_CD|S_CUST_CNT_CD|S_CUST_SEQ|S_CUST_NM|S_CUST_ADDR|S_CUST_CTY_NM|S_CSTMS_DECL_CNT_CD|S_CUST_ZIP_ID|S_EUR_CSTMS_ST_NM|S_EORI_NO|S_IBFLAG"
			HeadTitle1 += "|F_BKG_CUST_TP_CD|F_CUST_CNT_CD|F_CUST_SEQ|F_CUST_NM|F_CUST_ADDR|F_CUST_CTY_NM|F_CSTMS_DECL_CNT_CD|F_CUST_ZIP_ID|F_EUR_CSTMS_ST_NM|F_EORI_NO|F_IBFLAG"
			HeadTitle1 += "|C_BKG_CUST_TP_CD|C_CUST_CNT_CD|C_CUST_SEQ|C_CUST_NM|C_CUST_ADDR|C_CUST_CTY_NM|C_CSTMS_DECL_CNT_CD|C_CUST_ZIP_ID|C_EUR_CSTMS_ST_NM|C_EORI_NO|C_IBFLAG"
			HeadTitle1 += "|N_BKG_CUST_TP_CD|N_CUST_CNT_CD|N_CUST_SEQ|N_CUST_NM|N_CUST_ADDR|N_CUST_CTY_NM|N_CSTMS_DECL_CNT_CD|N_CUST_ZIP_ID|N_EUR_CSTMS_ST_NM|N_EORI_NO|N_IBFLAG"
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag");
			InitDataProperty(0, cnt++, dtSeq, 35, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bl_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vvd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true,
					"cstms_port_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"s_bkg_cust_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"s_cust_cnt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"s_cust_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"s_cust_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"s_cust_addr", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"s_cust_cty_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true,
					"s_cstms_decl_cnt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"s_cust_zip_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"s_eur_cstms_st_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"s_eori_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true, "s_ibflag",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"f_bkg_cust_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"f_cust_cnt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"f_cust_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"f_cust_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"f_cust_addr", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"f_cust_cty_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true,
					"f_cstms_decl_cnt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"f_cust_zip_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"f_eur_cstms_st_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"f_eori_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true, "f_ibflag",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"c_bkg_cust_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"c_cust_cnt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"c_cust_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"c_cust_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"c_cust_addr", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"c_cust_cty_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true,
					"c_cstms_decl_cnt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"c_cust_zip_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"c_eur_cstms_st_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"c_eori_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true, "c_ibflag",
					false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"n_bkg_cust_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"n_cust_cnt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"n_cust_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"n_cust_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"n_cust_addr", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"n_cust_cty_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true,
					"n_cstms_decl_cnt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"n_cust_zip_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"n_eur_cstms_st_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true,
					"n_eori_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daCenter, true, "n_ibflag",
					false, "", dfNone, 0, true, true);

			CountPosition = 0;
		}
		break;

	case "t3sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 262;
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
			InitRowInfo(1, 1, 2, 100);

			var HeadTitle1 = "|Sel.|Seq.|vvd|bl_no|dcgo_seq|cstms_port_cd|Container No.|UN No.|IMDG Class|Pacakge|Pacakge|Gross Weight|Gross Weight";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, "Sel");
			InitDataProperty(0, cnt++, dtDataSeq, 35, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "vvd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true, "bl_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true,
					"dcgo_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, true,
					"cstms_port_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_no",
					true, "", dfEngUpKey, 0, true, true, 14);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true,
					"imdg_un_no", false, "", dfNone, 0, true, true, 4);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true,
					"imdg_clss_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pck_qty",
					false, "", dfNullInteger, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pck_tp_cd",
					false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "grs_wgt",
					false, "", dfNullFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtCombo, 45, daCenter, true,
					"wgt_ut_cd", false, "", dfNone, 0, true, true);
			InitDataCombo(0, "wgt_ut_cd", "KGS|LBS", "KGS|LBS");
			CountPosition = 0;
		}
		break;

	case "t4sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 170;
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
			InitRowInfo(1, 1, 2, 100);

			var HeadTitle1 = "|Sel.|Seq.|vvd|bl_no|cstms_port_Cd|Container No.|Cntr Seq.|Package|Package|Weight|Weight|Measure|Measure|Mark|Mark|Description|HS";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false,
					"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "Sel");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, true, "Seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vvd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "bl_no",
					true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false,
					"cstms_port_cd", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false,
					"cntr_no", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false,
					"cntr_cgo_seq", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pck_qty",
					false, "", dfNullInteger, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true, "pck_tp_cd",
					false, "", dfEngUpKey, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 100, daRight, true,
					"cntr_mf_wgt", false, "", dfNullFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtCombo, 45, daCenter, true,
					"wgt_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 95, daRight, true, "meas_qty",
					false, "", dfNullFloat, 3, true, true, 12);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true,
					"meas_ut_cd", false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true,
					"cntr_mf_mk_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 20, daCenter, false, "MDPop",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true,
					"cntr_mf_gds_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, true,
					"cmdt_hs_cd", false, "", dfNone, 0, true, true);
			InitDataCombo(0, "wgt_ut_cd", "KGS|LBS", "KGS|LBS");
			ShowButtonImage = 2;
			CountPosition = 0;
			Ellipsis = true;
			AutoRowHeight = false;
		}
		break;

	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			// style.height = 100;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			var HeadTitle = "||bl_no|cntr_no|seal_no_seq|seal_no|knd_cd|pty_tp|pty_nm|vvd|cstms_port_cd";

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 0, daCenter, false, "sel");
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "bl_no",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 140, daRight, false, "cntr_no",
					false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 140, daRight, false,
					"seal_no_seq", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 140, daRight, false, "seal_no",
					false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false,
					"seal_knd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"seal_pty_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false,
					"seal_pty_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vvd",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,
					"cstms_port_cd", false, "", dfNone, 0, true, true);

			DataAutoTrim = false;
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 */
var err_yn = "N";// bl에러 여부
var ens_edi_svc_flg = "N";// edi서비스 플래그
var exs_edi_svc_flg = "N";// edi서비스 플래그
var dr_yn = "N";// dr 여부
var ata_yn ="";//ata 여부
/* A/N Sending 후 Accepted 된 VVD에 대한 ENS전송 방지 */
var arn_yn ="";

function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
	// sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return false;

		ComOpenWait(true);
		ens_edi_svc_flg == "N"; //ens_edi_svc_flg 초기화
		exs_edi_svc_flg == "N"; //exs_edi_svc_flg 초기화
		doActionIBSheet(sheetObj, formObj, COMMAND06);
		formObj.f_cmd.value = SEARCH;
		formObj.vvd.value = comboObjects[0].Code;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1124GS.do",
				FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		var State = ComGetEtcData(arrXml[0], ComWebKey.Trans_Result_Key);
		err_yn = ComGetEtcData(arrXml[0], "err_yn");
		ens_edi_svc_flg = ComGetEtcData(arrXml[0], "ens_edi_svc_flg");
		exs_edi_svc_flg = ComGetEtcData(arrXml[0], "exs_edi_svc_flg");
		dr_yn = ComGetEtcData(arrXml[0], "dr_yn");
		ata_yn = ComGetEtcData(arrXml[0], "ata_yn");
		arn_yn = ComGetEtcData(arrXml[0],"arn_yn");
		
		if (State == "S") {
			sheetObj.Redraw = false;
			ComEtcDataXmlToForm(arrXml[0], formObj);

			formObj.s_eori_no_ori.value = formObj.s_eori_no.value;
			formObj.c_eori_no_ori.value = formObj.c_eori_no.value;
			formObj.n_eori_no_ori.value = formObj.n_eori_no.value;
			formObj.f_eori_no_ori.value = formObj.f_eori_no.value;

			sheetObjects[2].LoadSearchXml(arrXml[0]);// CNTR정보
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			sheetObjects[3].LoadSearchXml(arrXml[2]);// CNTR MF정보
			sheetObjects[4].LoadSearchXml(arrXml[1]);// DG정보
			sheetObjects[4].SelectCell(0, 0);// DG정보
			sheetObjects[5].LoadSearchXml(arrXml[3]);// CNTR SEAL

			sheetObj.Redraw = true;
			if (ComGetEtcData(arrXml[0], "bl_no") == undefined
					&& sheetObjects[0].TotalRows == 0
					&& sheetObjects[2].TotalRows == 0) {
				// 조회된 데이터가 없을 경우
				ComShowCodeMessage("BKG00889"); // No Data Found

			} else {
				formObj.type_cd.Code = "I";
				formObj.wgt_ut_cd.Code = ComGetEtcData(arrXml[0], "wgt_ut_cd") == "" ? 'KGS'
						: ComGetEtcData(arrXml[0], "wgt_ut_cd");
				formObj.meas_ut_cd.Code = ComGetEtcData(arrXml[0], "meas_ut_cd") == "" ? 'CBM'
						: ComGetEtcData(arrXml[0], "meas_ut_cd");

				// if(formObj.pck_qty.value != "") AddComma( formObj.pck_qty,
				// "#,###.#");
				if (formObj.act_wgt.value != "")
					AddComma(formObj.act_wgt, "#,###.#");
				if (formObj.meas_qty.value != "")
					AddComma(formObj.meas_qty, "#,###.#");
			}

			// cntr에 있는 맨 첫줄의 CNTR NO를 임시 변수에 담는다.
			temp_cntr_no = sheetObjects[2].CellValue(1, 'cntr_no');

			setCMInfo(1);
			formObj.type_cd.selectedIndex = 0;
			
			var prevDoc = formObj.search_prev_doc_no.value;
			var tempPrevDoc = "";
			if(prevDoc != null && prevDoc != undefined) {
				tempPrevDoc  = prevDoc.split("@@@");
//				alert("kkk"+tempPrevDoc.length);
				if(tempPrevDoc.length == 1){
					formObj.prev_doc_no.value = tempPrevDoc[0];
				} else if (tempPrevDoc.length > 1){
					formObj.prev_doc_no.value = tempPrevDoc[0];
					formObj.prev_doc_yd.value = tempPrevDoc[1];
				}
			}
			if(formObj.ack_cd.value == "D" || formObj.ack_cd.value == "P" || formObj.ack_cd.value == "L"){
				formObj.msg_func_hold.value = form.ack_cd.value;
			}

		} else {
			ComShowMessage(ComResultMessage(sXml));
		}
		SetButtonStatus(); // Button Enabled

		ComOpenWait(false);
		break;

	case SEARCH01: // 조회
		formObj.f_cmd.value = SEARCH01;
		var val = sheetObj.CellValue(Row, Col);
		var params = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1124GS.do", params);
		var cntr_no = ComGetEtcData(sXml, "cntr_no");
		var cntr_tpsz_cd = ComGetEtcData(sXml, "cntr_tpsz_cd");
		if (cntr_no == undefined) {
			ComShowCodeMessage("BKG06012", val);
			sheetObj.CellValue2(Row, "cntr_no") = "";
			sheetObj.CellValue2(Row, "cntr_tpsz_cd") = "";
			// sheetObj.ReturnCellData(Row, "cntr_no");
			sheetObj.SelectCell(Row, "cntr_no");
		} else {
			sheetObj.CellValue2(Row, "cntr_tpsz_cd") = cntr_tpsz_cd;
			sheetObj.CellValue2(Row, "cntr_no") = cntr_no;
		}
		break;

	case SEARCH02: // VVD Combo setting
		formObj.f_cmd.value = SEARCH02;
		//formObj.vvd.RemoveAll();
		//form.cstms_yd_cd.value = "";
		
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1124GS.do",
				FormQueryString(formObj));
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State == "S") {
			
			if(ComGetTotalRows(sXml) =='0'){
				return;
			}
			
//			comboObjects[0].MultiSeparator = "|";
			formObj.vvd.MultiSeparator = "|";
			
			ComXml2ComboItem(sXml, formObj.vvd, "vvd",
					"vvd|cstms_yd_cd|vsl_eng_name|lloyd_no", true);

			var arr = new Array();
			var vvd = new Array();
			arr = ComBkgXml2ComboString(sXml, "vvd", "vvd");
			if (arr == undefined || arr == '') {
				//doActionIBSheet(comboObjects[0], formObj, COMMAND06);
				// ComShowCodeMessage("BKG00889"); // No Data Found
				return;
			}
			vvd = arr[0].split(",");
			var vsl_eng_nm = new Array();
			arr = ComBkgXml2ComboString(sXml, "vsl_eng_nm", "vsl_eng_nm");
			vsl_eng_nm = arr[0].split(",");

			var lloyd_no = new Array();
			arr = ComBkgXml2ComboString(sXml, "lloyd_no", "lloyd_no");
			lloyd_no = arr[0].split(",");

			formObj.vsl_eng_nm.value = vsl_eng_nm[0];
			formObj.lloyd_no.value = lloyd_no[0];

			formObj.vvd.Index = 0;
			return;
		}
		break;

	case IBROWSEARCH: // 그리드에서 Container No. 입력시 조회
		formObj.f_cmd.value = SEARCH03;
		formObj.sheet_id.value = sheetObj.id;
		sheetObj.DoSearch("ESM_BKG_1124GS.do", FormQueryString(formObj));
		if (sheetObj.RowCount == 0)
			sheetObj.RemoveAll();
		break;

	case IBRESET: // New
		var bl_no_tmp;
		var cstms_yd_cd_tmp ;
		if (start_bl_no_flag) { //초기 값을 전달 받았을 경우
			cstms_yd_cd_tmp = formObj.cstms_yd_cd.value;// 초기화 하기전 현재 cstms_yd_cd 백업 후  재할당한다.
		} else {
			formObj.vvd.RemoveAll();
		}
		
		formObj.reset();
		
		formObj.cstms_yd_cd.value = cstms_yd_cd_tmp;

		document.form.wgt_ut_cd.Code = "KGS";
		document.form.meas_ut_cd.Code = "CBM";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		SetButtonStatus(); // Button Disabled
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Transmit");
		
		ComSetDisplay("msg_func_hold_field", false);
		ComSetDisplay("msg_func_id_field", true);
		
		document.form.bl_no.focus();
		break;

	case COMMAND06: // Remove Grid

		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		
		formObj.s_cust_cnt_cd.value = '' ;
		formObj.s_cust_seq.value = '' ;
		formObj.s_cust_nm.value = '' ;
		formObj.s_cust_addr.value = '';
		formObj.s_cust_cty_nm.value = '';
		formObj.s_cstms_decl_cnt_cd.value = '';
		formObj.s_cust_zip_id.value = '';
		formObj.s_eur_cstms_st_nm.value = '';
		formObj.s_eori_no.value = '';

		formObj.f_cust_cnt_cd.value = '' ;
		formObj.f_cust_seq.value = '' ;
		formObj.f_cust_nm.value = '' ;
		formObj.f_cust_addr.value = '';
		formObj.f_cust_cty_nm.value = '';
		formObj.f_cstms_decl_cnt_cd.value = '';
		formObj.f_cust_zip_id.value = '';
		formObj.f_eur_cstms_st_nm.value = '';
		formObj.f_eori_no.value = '';

		formObj.n_cust_cnt_cd.value = '' ;
		formObj.n_cust_seq.value = '' ;
		formObj.n_cust_nm.value = '' ;
		formObj.n_cust_addr.value = '';
		formObj.n_cust_cty_nm.value = '';
		formObj.n_cstms_decl_cnt_cd.value = '';
		formObj.n_cust_zip_id.value = '';
		formObj.n_eur_cstms_st_nm.value = '';
		formObj.n_eori_no.value = '';

		formObj.c_cust_cnt_cd.value = '' ;
		formObj.c_cust_seq.value = '' ;
		formObj.c_cust_nm.value = '' ;
		formObj.c_cust_addr.value = '';
		formObj.c_cust_cty_nm.value = '';
		formObj.c_cstms_decl_cnt_cd.value = '';
		formObj.c_cust_zip_id.value = '';
		formObj.c_eur_cstms_st_nm.value = '';
		formObj.c_eori_no.value = ''
			
		SetButtonStatus(); // Button Disabled
		break;

	case IBSAVE: // Save
		if (!validateForm(sheetObj, formObj, IBSAVE)) return false;
		
        if(!ComShowCodeConfirm("BKG00350")) {
        	return false;
        }

		ComOpenWait(true, true);
		formObj.f_cmd.value = MULTI;
		var sheet2 = sheetObjects[1];
		// sheet2.RemoveAll();

		// Customer정보에 대한 조치
		if (formObj.s_cust_nm.value == '' && formObj.s_cust_addr.value == ''
				&& formObj.s_cust_cty_nm.value == ''
				&& formObj.s_cstms_decl_cnt_cd.value == ''
				&& formObj.s_cust_zip_id.value == ''
				&& formObj.s_eur_cstms_st_nm.value == ''
				&& formObj.s_eori_no.value == '') {
			formObj.s_ibflag.value = 'D';
		}

		if (formObj.f_cust_nm.value == '' && formObj.f_cust_addr.value == ''
				&& formObj.f_cust_cty_nm.value == ''
				&& formObj.f_cstms_decl_cnt_cd.value == ''
				&& formObj.f_cust_zip_id.value == ''
				&& formObj.f_eur_cstms_st_nm.value == ''
				&& formObj.f_eori_no.value == '') {
			formObj.f_ibflag.value = 'D';
		}

		if (formObj.n_cust_nm.value == '' && formObj.n_cust_addr.value == ''
				&& formObj.n_cust_cty_nm.value == ''
				&& formObj.n_cstms_decl_cnt_cd.value == ''
				&& formObj.n_cust_zip_id.value == ''
				&& formObj.n_eur_cstms_st_nm.value == ''
				&& formObj.n_eori_no.value == '') {
			formObj.n_ibflag.value = 'D';
		}

		if (formObj.c_cust_nm.value == '' && formObj.c_cust_addr.value == ''
				&& formObj.c_cust_cty_nm.value == ''
				&& formObj.c_cstms_decl_cnt_cd.value == ''
				&& formObj.c_cust_zip_id.value == ''
				&& formObj.c_eur_cstms_st_nm.value == ''
				&& formObj.c_eori_no.value == '') {
			formObj.c_ibflag.value = 'D';
		}

		var params = '';
		params += FormQueryString(formObj);
		params += "&"
				+ ComSetPrifix(ComGetSaveString(sheetObjects[0], false, true),
						"t1_");
		params += "&"
				+ ComSetPrifix(ComGetSaveString(sheetObjects[3], false, true),
						"t5_");// CNTR MF정보
		params += "&"
				+ ComSetPrifix(ComGetSaveString(sheetObjects[2], false, true),
						"t3_");// CNTR정보
		params += "&"
				+ ComSetPrifix(ComGetSaveString(sheetObjects[4], false, true),
						"t4_");// DG정보
		params += "&"
				+ ComSetPrifix(ComGetSaveString(sheetObjects[5], false, true),
						"t6_");// CNTR SEAL

		// formObj.flatfile.value = params;
		// alert(ComSetPrifix(ComGetSaveString(sheetObjects[2], false, true),
		// "t3_"));
		var sXml = sheetObj.GetSaveXml("ESM_BKG_1124GS.do", params);
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State == "S") {
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			sheetObj.Redraw = true;
			ComOpenWait(false);
			// ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		} else {
			ComOpenWait(false);
			ComShowMessage(ComResultMessage(sXml));
		}
		break;

	case IBINSERT:// Row Add
		var row = GetAddRowIndex(sheetObj);
		break;

	case IBDELETE:// Row Del
		var sheetID = sheetObj.id;
		if (sheetObj.CheckedRows(1) == 0) {
			ComShowCodeMessage('BKG00249'); // No Selected Row
			return;
		}
		ComShowCodeMessage('BKG03037');
		ComRowHideDelete(sheetObj, "Sel");

		var selectedRow = sheetObj.SelectRow;
		if (sheetID == 't1sheet1') {
			// CNTR MF sheet정보 삭제 조치
			var maxLength = sheetObjects[3].RowCount;
			for ( var i = 1; i <= maxLength; i++) {
				if (sheetObjects[3].CellValue(i, "cntr_no").trim() == sheetObjects[2]
						.CellValue(selectedRow, "cntr_no").trim()) {
					sheetObjects[3].RowHidden(i) = true; // 선택된 행 숨기기
					sheetObjects[3].RowStatus(i) = "D"; // 선택된 행 삭제 flag를 셋팅
				}
			}

			// Seal No sheet 정보 삭제 조치
			maxLength = sheetObjects[5].RowCount;
			for ( var i = 1; i <= maxLength; i++) {
				if (sheetObjects[5].CellValue(i, "cntr_no").trim() == sheetObjects[2]
						.CellValue(selectedRow, "cntr_no").trim()) {
					sheetObjects[5].RowHidden(i) = true; // 선택된 행 숨기기
					sheetObjects[5].RowStatus(i) = "D"; // 선택된 행 삭제 flag를 셋팅
				}
			}
		}
		break;

	case IBSEARCH_ASYNC01: // Mark
		ComOpenWindowCenter("ESM_BKG_1036.do?pgmNo=ESM_BKG_1036&bl_mk_desc="
				+ formObj.bl_mk_desc.value, "ESM_BKG_1036", 330, 248);
		break;

	case MULTI01: // Transmit Manifest
		
		if (!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
			return false;
		}

		if (err_yn != "N") { // 에러이면
			ComShowCodeMessage("BKG01133", form.bl_no.value, "");
			return;
		}
		
		var reg = /^[A-Z]{2}([a-zA-Z0-9]{1,15}$)/; // 정규식
		var reg2 = /TEST|NONE/; // 정규식

		var temp_eori_no = formObj.s_eori_no_ori.value;
		if (temp_eori_no != ""
				&& (!reg.test(temp_eori_no) || reg2.test(temp_eori_no
						.toUpperCase()))) {
			ComShowCodeMessage('BKG01143', 'Shipper ');
			formObj.s_eori_no.focus();
			return;
		}
		temp_eori_no = formObj.c_eori_no_ori.value;
		if (temp_eori_no != ""
				&& (!reg.test(temp_eori_no) || reg2.test(temp_eori_no
						.toUpperCase()))) {
			ComShowCodeMessage('BKG01143', 'Consignee ');
			formObj.c_eori_no.focus();
			return;
		}

		temp_eori_no = formObj.f_eori_no_ori.value;
		if (temp_eori_no != ""
				&& (!reg.test(temp_eori_no) || reg2.test(temp_eori_no
						.toUpperCase()))) {
			ComShowCodeMessage('BKG01143', 'FWRD ');
			formObj.f_eori_no.focus();
			return;
		}
		temp_eori_no = formObj.n_eori_no_ori.value;
		if (temp_eori_no != ""
				&& (!reg.test(temp_eori_no) || reg2.test(temp_eori_no
						.toUpperCase()))) {
			ComShowCodeMessage('BKG01143', 'Notify ');
			formObj.n_eori_no.focus();
			return;
		}

		var vvd = formObj.vvd.value;
		var sParam = "ibflag=U" + "&" + "p_send_yn=Y&" + "vsl_cd="
				+ vvd.substring(0, 4) + "&" + "skd_voy_no="
				+ vvd.substring(4, 8) + "&" + "skd_dir_cd="
				+ vvd.substring(8, 9) + "&" + "bl_no=" + formObj.bl_no.value
				+ "&" + "pol=" + formObj.cstms_port_cd.value;
		formObj.f_cmd.value = MULTI01;
		sParam += "&" + FormQueryString(formObj);

		ComOpenWait(true, true);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_1121GS.do", sParam);
		var key = ComGetEtcData(sXml, "KEY");
		intervalId = setInterval("doActionValidationResult(sheetObjects[0], '"
				+ key + "');", 3000);
		break;

	case COMMAND01: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH04;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.cust_type.value = "S";
			sheetObj.DoSearch("ESM_BKG_1124GS.do", FormQueryString(formObj));
			formObj.s_cust_nm.value = sheetObj.EtcData("s_cust_nm") == undefined ? ''
					: sheetObj.EtcData("s_cust_nm");
			formObj.s_cust_addr.value = sheetObj.EtcData("s_cust_addr") == undefined ? ''
					: sheetObj.EtcData("s_cust_addr");
			ComOpenWait(false);
		}
		break;

	case COMMAND05: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH04;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.cust_type.value = "F";
			sheetObj.DoSearch("ESM_BKG_1124GS.do", FormQueryString(formObj));
			formObj.f_cust_nm.value = sheetObj.EtcData("f_cust_nm") == undefined ? ''
					: sheetObj.EtcData("f_cust_nm");
			formObj.f_cust_addr.value = sheetObj.EtcData("f_cust_addr") == undefined ? ''
					: sheetObj.EtcData("f_cust_addr");
			ComOpenWait(false);
		}
		break;

	case COMMAND03: // 저장
		// alert("test3");
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH04;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.cust_type.value = "C";
			sheetObj.DoSearch("ESM_BKG_1124GS.do", FormQueryString(formObj));
			formObj.c_cust_nm.value = sheetObj.EtcData("c_cust_nm") == undefined ? ''
					: sheetObj.EtcData("c_cust_nm");
			formObj.c_cust_addr.value = sheetObj.EtcData("c_cust_addr") == undefined ? ''
					: sheetObj.EtcData("c_cust_addr");
			ComOpenWait(false);
		}

		break;

	case COMMAND04: // 저장
		// alert("test3");
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH04;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.cust_type.value = "N";
			sheetObj.DoSearch("ESM_BKG_1124GS.do", FormQueryString(formObj));
			formObj.n_cust_nm.value = sheetObj.EtcData("n_cust_nm") == undefined ? ''
					: sheetObj.EtcData("n_cust_nm");
			formObj.n_cust_addr.value = sheetObj.EtcData("n_cust_addr") == undefined ? ''
					: sheetObj.EtcData("n_cust_addr");
			ComOpenWait(false);
		}
		break;
		
	}
}

/**
 * BackEndJob 실행결과조회<br>
 * 
 * @param sheetObj
 * @param sKey
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_1106GS.do?f_cmd=" + SEARCH03
			+ "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

	// ComShowMessage("doActionValidationResult "+sJbStsFlg);

	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		ComShowCodeMessage('BKG00101');
		// resultlist.innerHTML = "<pre>"+ ComGetEtcData(sXml,
		// "RESULT")+"</pre>";
		return;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회

		if (ComIsNull(formObj.bl_no)) {
			ComShowCodeMessage('BKG00104', 'B/L No.');
			formObj.bl_no.focus();
			return false;
		}
		//alert(formObj.cstms_yd_cd.value);
//		if (ComIsNull(formObj.cstms_yd_cd) || formObj.cstms_yd_cd.value == 'undefined') {
		if(formObj.vvd.GetCount() < 1){
			ComShowCodeMessage('BKG00104', 'VVD');
			return false;
		}

		return true;
		break;

	case IBSAVE: // 저장
		var sheetObj1 = sheetObjects[2];// CNTR
		for ( var i = 1; i < sheetObj1.RowCount + 1; i++) {
			if (sheetObj1.CellValue(i, "cntr_no") == "") {
				// alert("[Container Info.] Container No. is Mandatory item.");
				ComShowCodeMessage('BKG00104', 'Container Info.');
				tabObjects[0].SelectedIndex = 1;
				sheetObj1.SelectCell(i, "cntr_no");
				return false;
			}
		}

		var sheetObj3 = sheetObjects[4];// DG
		for ( var i = 1; i < sheetObj3.RowCount + 1; i++) {
			if (sheetObj3.CellValue(i, "cntr_no") == "") {
				// alert("[Danger Info.] Container No. is Mandatory item.");
				ComShowCodeMessage('BKG00104', 'Danger Container Info.');
				tabObjects[0].SelectedIndex = 2;
				sheetObj3.SelectCell(i, "cntr_no");
				return false;
			}
		}
		
		return true;
		break;

	case COMMAND01: // 조회
		var cust_cnt;
		var cust_seq;

		cust_cnt = formObj.s_cust_cnt_cd;
		cust_seq = formObj.s_cust_seq;
		if (!ComChkObjValid(cust_cnt)
				|| !ComChkObjValid(cust_seq, true, true, false))
			return false;
		return true;
		break;

	case COMMAND05: // 조회
		var cust_cnt;
		var cust_seq;
		cust_cnt = formObj.f_cust_cnt_cd;
		cust_seq = formObj.f_cust_seq;
		if (!ComChkObjValid(cust_cnt)
				|| !ComChkObjValid(cust_seq, true, true, false))
			return false;
		return true;
		break;

	case COMMAND03: // 조회
		var cust_cnt;
		var cust_seq;

		cust_cnt = formObj.c_cust_cnt_cd;
		cust_seq = formObj.c_cust_seq;
		if (!ComChkObjValid(cust_cnt)
				|| !ComChkObjValid(cust_seq, true, true, false))
			return false;
		return true;
		break;

	case COMMAND04: // 조회
		var cust_cnt;
		var cust_seq;

		cust_cnt = formObj.n_cust_cnt_cd;
		cust_seq = formObj.n_cust_seq;
		if (!ComChkObjValid(cust_cnt)
				|| !ComChkObjValid(cust_seq, true, true, false))
			return false;
		return true;
		break;

	}
}



/**
 * 시트 데이터 변경 시 데이터 처리
 */
function t1sheet1_OnChange(sheetObj, row, col, val) {
	var formObject = document.form;
	var col_save_name = sheetObj.ColSaveName(col);
	if (sheetObj.ColSaveName(col) == "cntr_no"
			&& sheetObj.CellValue(row, "cntr_no") != "") {
		for ( var i = 1; i <= sheetObj.LastRow; i++) {
			if (i == row)
				continue;
			if (sheetObj.CellValue(i, "cntr_no") == sheetObj.CellValue(row,
					"cntr_no")) {
				// "Container No. [{?msg1}] is duplicated. Check container
				// number.
				ComShowCodeMessage("BKG00965", sheetObj.CellValue(row,
						"cntr_no"));
				sheetObj.CellValue2(row, "cntr_no") = "";
				sheetObj.SelectCell(row, "cntr_no");
				return;
			}
		}
		doActionIBSheet(sheetObj, document.form, SEARCH01, row, col);
		temp_cntr_no = sheetObj.CellValue(row, "cntr_no");
	}
	var bl_no = sheetObj.CellValue(row, "bl_no");
	var cntr_no = sheetObj.CellValue(row, "cntr_no").toUpperCase();
	/* seal_no */
	if (col_save_name == "seal_no" || col_save_name == "seal_no2") {
		var fmObject = sheetObjects[5];
		var arrRow = findText(fmObject, "cntr_no", cntr_no);
		var len = arrRow.length;
		if (len <= 1) {
			if (val != '') {
				var newRow = fmObject.DataInsert(-1);
				fmObject.CellValue2(newRow, "bl_no") = bl_no;
				fmObject.CellValue2(newRow, "cntr_no") = cntr_no;
				fmObject.CellValue2(newRow, "seal_no") = val;
			} else {
				if (col_save_name == "seal_no") {
					fmObject.CellValue2(arrRow[0], "seal_no") = val;
				} else {
					fmObject.CellValue2(arrRow[0], "seal_no") = val;
				}
			}
		} else {
			if (col_save_name == "seal_no") {
				fmObject.CellValue2(arrRow[0], "seal_no") = val;
			} else {
				fmObject.CellValue2(arrRow[1], "seal_no") = val;
			}
		}
		rowDelete(fmObject, "seal_no", '');
		setAllSealNo();
	}
}

/**
 * DG Cntr No 데이터 변경 시 유효성 체크 함수 호출
 */
function t3sheet1_OnChange(sheetObj, row, col, val) {
	var formObject = document.form;
	var col_save_name = sheetObj.ColSaveName(col);
	if (sheetObj.ColSaveName(col) == "cntr_no"
			&& sheetObj.CellValue(row, "cntr_no") != "") {
		/*
		 * for(var i=1; i<=sheetObj.LastRow; i++){ if(i == row) continue;
		 * if(sheetObj.CellValue(i, "cntr_no") == sheetObj.CellValue(row,
		 * "cntr_no")){ //"Container No. [{?msg1}] is duplicated. Check
		 * container number. ComShowCodeMessage("BKG00965",
		 * sheetObj.CellValue(row, "cntr_no")); sheetObj.CellValue2(row,
		 * "cntr_no") = ""; sheetObj.SelectCell(row, "cntr_no"); return; } }
		 */
		doActionIBSheet(sheetObj, document.form, SEARCH01, row, col);
	}
}

/**
 * Cntr No 데이터 변경 시 유효성 체크 함수 호출
 */
function t4sheet1_OnChange(sheetObj, row, col, val) {

}

/**
 * Form 컨트롤에서 포커스인 시 데이터 처리
 */
function obj_FocusIn() {
	var srcObj = window.event.srcElement;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");

	// if(srcName == "pck_qty" || srcName == "act_wgt" || srcName ==
	// "meas_qty"){
	if (srcName == "act_wgt" || srcName == "meas_qty") {
		srcObj.style.textAlign = "left";
		if (srcValue.substr(srcValue.length - 4) == ".000") {
			srcObj.value = srcValue.substr(0, srcValue.length - 4);
		}
	}

	if (srcName == "temp") {
		srcObj.style.textAlign = "left";
		if (srcValue == "0.0") {
			srcObj.value = "";
		}
	}
}

/**
 * Form 컨트롤에서 포커스아웃 시 데이터 처리
 */
function obj_FocusOut() {
	var srcObj = window.event.srcElement;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");

	// if(srcName == "pck_qty" || srcName == "act_wgt" || srcName ==
	// "meas_qty"){
	if (srcName == "act_wgt" || srcName == "meas_qty") {
		srcObj.style.textAlign = "right";
		AddComma(srcObj, "#,###.#");
	}

	if (srcName == "temp") {
		srcObj.style.textAlign = "right";
		if (srcValue == "") {
			srcObj.value = "0.0";
		} else {
			AddComma(srcObj, "#,###.#");
		}
	}
}

/**
 * 키보드 누를 때 Form 데이터 처리
 */
function obj_KeyUp() {
	var formObj = document.form;
	var srcObj = window.event.srcElement;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "" || srcName == "act_wgt" || srcName == "meas_qty") {
		AddComma(srcObj, "#,###.###", srcMaxLength);
	}
	if (srcName == "temp") {
		AddComma(srcObj, "#,###.##", srcMaxLength);
	}
	if ((srcName == "s_cust_cnt_cd" || srcName == "f_cust_cnt_cd"
			|| srcName == "c_cust_cnt_cd" || srcName == "n_cust_cnt_cd")
			&& ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 폼 필드 변경시 이벤트
 * 
 * @return
 */
function obj_change() {
	
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "bl_no") {
		var cstms_yd_cd_tmp ;
		if (start_bl_no_flag) {
			cstms_yd_cd_tmp = formObj.cstms_yd_cd.value;// 초기화 하기전 현재 cstms_yd_cd 백업 후  재할당한다.
		} else {
			formObj.cstms_yd_cd.value = "";
			formObj.vvd.RemoveAll();
		}
		
		formObj.cstms_yd_cd.value = cstms_yd_cd_tmp;
		
		
		doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
		doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
	}
		
}

/**
 * Form 데이터 초기화
 */
function initFormData() {
	var frmChild = document.getElementsByTagName("input");

	for ( var i = 0; i < frmChild.length; i++) {
		if (frmChild[i].type == "text" && frmChild[i].name != "bl_no") {
			frmChild[i].value = "";
		}
		if (frmChild[i].type == "hidden") {
			if (frmChild[i].name == "bl_mk_desc"
					|| frmChild[i].name == "bkg_pol_cd"
					|| frmChild[i].name == "bkg_pod_cd"
					|| frmChild[i].name == "chn_mf_snd_ind_cd") {
				frmChild[i].value = "";
			}
		}
		if (frmChild[i].type == "checkbox") {
			frmChild[i].checked = false;
		}
	}

	document.form.wgt_ut_cd.Code = "KGS";
	document.form.meas_ut_cd.Code = "CBM";

	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
}

/**
 * 문자열을 숫자포멧에 맞게 변경하여 리턴한다. 숫자포멧으로 설정할수 있는 값은 다음과 같다. <br>
 * <br>
 * 
 * @param{object,string} obj 필수,숫자문자열 또는 HTML태그(Object)
 * @param{string} string 필수,포맷 스트링
 * @param{int} int 선택,HTML태그(Object)의 Maxlength
 * @returns string, 숫자포멧이 설정된 문자열<br>
 *          "":sVal인자의 값이 잘못된 경우 공백("")을 리턴한다.
 * @see #ComAddComma
 * @see #ComGetMaskedValue
 */
function AddComma(obj, sFormat, len) {
	try {
		var sVal = obj.value.replace(/\,/g, "");
		switch (sFormat) {
		case "#,###":
			obj.value = ComAddComma(sVal);
			break;
		case "#,###.#":
			if (sVal == ".")
				sVal = "0.";
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if (p.length <= 1)
				obj.value = p[0] + ".000";
			else if (p.length == 2)
				obj.value = p[0] + "." + p[1].substr(0, 3);
			else if (p.length > 2)
				obj.value = p[0] + "." + p[1].substr(0, 3);
			else
				sVal = "";
			break;
		case "#,###.##":
			if (sVal == ".")
				sVal = "0.";
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if (p.length <= 1) {
				if (p[0].length > len - 3) {
					sVal = p[0].substr(0, len - 3).replace(/\,/g, "");
					p[0] = ComAddComma(sVal);
				}
				obj.value = p[0];
			} else if (p.length == 2)
				obj.value = p[0] + "." + p[1].substr(0, 2);
			else if (p.length > 2)
				obj.value = p[0] + "." + p[1].substr(0, 2);
			else
				sVal = "";
			break;
		case "#,###.###":
			if (sVal == ".")
				sVal = "0.";
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if (p.length <= 1) {
				if (p[0].length > len - 4) {
					sVal = p[0].substr(0, len - 3).replace(/\,/g, "");
					p[0] = ComAddComma(sVal);
				}
				obj.value = p[0];
			} else if (p.length == 2)
				obj.value = p[0] + "." + p[1].substr(0, 3);
			else if (p.length > 2)
				obj.value = p[0] + "." + p[1].substr(0, 3);
			else
				sVal = "";
			break;
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * sheet에 새 Row 를 추가하고 기본값을 셋팅한뒤 Row index를 리턴한다.<br>
 */
function GetAddRowIndex(sheetObj) {
	if (sheetObj.id == "t4sheet1" && temp_cntr_no == '') {
		ComShowCodeMessage('BKG00104', 'Container No.');
		return;
	}
	var row = sheetObj.DataInsert(-1);
	sheetObj.CellValue2(row, "vvd") = document.form.vvd.value;
	sheetObj.CellValue2(row, "cstms_port_cd") = document.form.cstms_port_cd.value;
	sheetObj.CellValue2(row, "bl_no") = document.form.bl_no.value;
	// alert(sheetObj.CellValue(row, "vvd") + " : " + sheetObj.CellValue(row,
	// "cstms_port_cd") + " : " + sheetObj.CellValue(row, "bl_no"));

	if (sheetObj.id == "t4sheet1") {
		setSeq();
		sheetObj.CellValue2(row, "cntr_no") = temp_cntr_no;
	}
	return row;
}

/**
 * 화면 로드 시 버튼 처리
 */
function SetButtonStatus() {
	if (form.bl_no.value == "" || form.cstms_yd_cd.value == "" || form.cstms_yd_cd.value == 'undefined') {
		ComBtnDisable("btn_RowAdd1");
		ComBtnDisable("btn_RowDel1");
		ComBtnDisable("btn_RowAdd2");
		ComBtnDisable("btn_RowDel2");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Transmit");
		ComBtnDisable("btn_Mark");
	} else {
		ComBtnEnable("btn_RowAdd1");
		ComBtnEnable("btn_RowDel1");
		ComBtnEnable("btn_RowAdd2");
		ComBtnEnable("btn_RowDel2");
		ComBtnEnable("btn_Save");
		if (exs_edi_svc_flg == "Y")
			ComBtnEnable("btn_Transmit");
		else
			ComBtnDisable("btn_Transmit");
		
		if( form.cstms_yd_cd.value.substring(0,2) == "GB" && form.mvmt_ref_no.value != "" && form.kts_send_dt.value < "2011012123")
			ComBtnDisable("btn_Transmit");
		else if( form.cstms_yd_cd.value.substring(0,2) != "GB" && form.mvmt_ref_no.value != "" && form.kts_send_dt.value < "2011011817")
			ComBtnDisable("btn_Transmit");
			

		ComBtnEnable("btn_Mark");
	}
}


/**
 * 조회 후 처리
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg != "")
		return;
	var formObj = document.form;
	if(formObj.pol_cd.value.indexOf("ES")> -1 || formObj.pol_cd.value.indexOf("PT")> -1){
//		ComBtnEnable("btn_prevDoc_pop");
		ComSetDisplay("btn_prevDoc_pop", true);
	}else {
//		ComBtnDisable("btn_prevDoc_pop");
		ComSetDisplay("btn_prevDoc_pop", false);
	}
	
	if(formObj.ack_cd.value == "D" || formObj.ack_cd.value == "P" || formObj.ack_cd.value == "L"){
		ComSetDisplay("msg_func_hold_field", true);
		ComSetDisplay("msg_func_id_field", false);
		
		// 콤보 박스 초기화
		formObj.msg_func_hold.options.length = 0;
		
		var dis = new Array();
		var cd = new Array();
		
		if(formObj.his_ack_cd.value == "D") {
			dis = ["Hold(Doc.)", "Hold Release"];
			cd = ["D", "L"];
		} else {
			dis = ["Hold(Phys.)", "Hold Release"];
			cd = ["P", "L"];
		}
		
	    for(var i=0; i<dis.length; i++){
	    	formObj.msg_func_hold.add(new Option(dis[i], cd[i]));

	    	if(form.msg_func_hold.options[i].value == "L") {
				form.msg_func_hold.options[i].style.color = "BLUE";
			} else {
				form.msg_func_hold.options[i].style.color = "RED";
			}
	    }
	    
//		var HoldOpionsSize = form.msg_func_hold.options.length;
//		for(var i=0; i<HoldOpionsSize ; i++) { 
//			if(form.msg_func_hold.options[i].value == "L") {
//				form.msg_func_hold.options[i].style.color = "BLUE";
//			} else {
//				form.msg_func_hold.options[i].style.color = "RED";
//			}
//		}
	    
		
	}else{
		ComSetDisplay("msg_func_hold_field", false);
		ComSetDisplay("msg_func_id_field", true);
	}
	
}


/**
 * 시트에 키필드 Validation 체크 및 해당 코드의 description 조회
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	// PORT 유효성 체크
	if (sheetObj.ColSaveName(Col) == "bl_no") {
		formObj.f_cmd.value = SEARCH01;
		formObj.strLocCd.value = sheetObj.CellValue(Row, Col);

		if (formObj.strLocCd.value != "") {
			doActionIBSheet(sheetObj, formObj, SEARCH01);
		}
	}
}

/**
 * 시트의 선택한 Row의 Container 에 해당하는 CM을 하단 그리드에 표시
 */
function t1sheet1_OnClick(sheetObj, Row, Col) {
	// if(sheetObj.ColSaveName(Col) != "cntr_no") return;
	temp_cntr_no = sheetObj.CellValue(Row, 'cntr_no');
	setCMInfo(Row);
	sheetObj.SelectCell(Row, sheetObj.ColSaveName(Col));
}

/**
 * 조회 후 처리
 */
function t1sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	if (ErrMsg != "")
		return;
	var formObj = document.form;
	if (sheetObj.RowCount > 0) {
		setCMInfo(1);
		// alert(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "Seq"));
		t1sheet1_OnClick(sheetObjects[2], sheetObjects[2].SelectRow,
				sheetObjects[2].SaveNameCol("cntr_no"));
	}
}

/**
 * IBSheet에 셀 클릭시 팝업 처리
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t1sheet1_OnPopupClick(sheetObj, row, col) {
	var bl_no = sheetObj.CellValue(row, "bl_no");
	var cntr_no = sheetObj.CellValue(row, "cntr_no");
	var url = "ESM_BKG_0697.do?bl_no=" + bl_no + "&cntr_no=" + cntr_no;
	ComOpenWindowCenter(url, "ESM_BKG_0697", 360, 390, true);
}

function t4sheet1_OnPopupClick(sheetObj, row, col) {
	// alert(sheetObj.id + " -> " + sheetObj.ColSaveName(col));
	var col_name = sheetObj.ColSaveName(col);
	switch (col_name) {
	case "MDPop":
		var frm2 = document.form;
		var width = 400;
		var height = 410;
		var left = (screen.width - width) / 2;
		var top = (screen.height - height) / 2;
		var win = window
				.open(
						"",
						"ESM_BKG_0706",
						"width="
								+ width
								+ ",height="
								+ height
								+ ",left="
								+ left
								+ ",top="
								+ top
								+ ",toolbar=no,directories=no,status=no,scrollbars=no,resizable=no,modal=yes");
		frm2.mk_desc.value = sheetObj.CellValue(row, "cntr_mf_mk_desc");
		frm2.gds_desc.value = sheetObj.CellValue(row, "cntr_mf_gds_desc");
		frm2.func.value = "callbackMFDesc";
		frm2.action = "ESM_BKG_0706.do";
		frm2.method = "POST";
		frm2.target = "ESM_BKG_0706";
		frm2.submit();

		break;
	} // end switch
}

function callbackMFDesc(mk_desc, gds_desc) {
	sheetObjects[3].CellValue2(sheetObjects[3].SelectRow, "cntr_mf_mk_desc") = mk_desc;
	sheetObjects[3].CellValue2(sheetObjects[3].SelectRow, "cntr_mf_gds_desc") = gds_desc;
	// 데이타 수정 여부 기록
	// document.form.dirty_flag.value = 'Y'
}

/**
 * Cntr 그리드에서 컨테이너 선택시, Cntr 정보 및 CM grid 세팅
 */
var cmTotal;
function setCMInfo(row) {
	// alert("selectCM : " + row);
	if (row > 0) {
		// retrieve CM
		showAndHideSheet(sheetObjects[3], "cntr_no", sheetObjects[2].CellValue(
				row, "cntr_no"));
		// rearangeSeq
		setSeq();
		// calculate sum
		// syncQuantity("pck_qty");
		// syncQuantity("grs_wgt");
		// sheetObjects[2].SelectCell(row,"cntr_no");
	}
}

/**
 * 상위 그리드의 Container 에 해당하는 CM 만 남기고 Hidden 처리
 */
function showAndHideSheet(sheetObj, colName, colValue) {
	var rcnt = sheetObj.RowCount + 2;
	for (rn = 1; rn < rcnt; rn++) {
		// alert(sheetObj.CellValue(rn, colName));
		if (sheetObj.RowStatus(rn) != 'D'
				&& sheetObj.CellValue(rn, colName) == colValue) {
			sheetObj.RowHidden(rn) = false;
		} else {
			sheetObj.RowHidden(rn) = true;
		}
	}
}

/**
 * Row Delete 버튼 클릭 시 처리
 */
function rowDelete(sheetObj, colName, colValue) {
	var arrRow = findText(sheetObj, colName, colValue);
	for (ir = 0; ir < arrRow.length; ir++) {
		if (arrRow[arrRow.length - 1 - ir] == '')
			continue;
		sheetObj.RowHidden(arrRow[arrRow.length - 1 - ir]) = true;
		sheetObj.RowStatus(arrRow[arrRow.length - 1 - ir]) = 'D';
	}
}

/**
 * 상위 그리드 Container 에 따라 보여지는 CM 그리드 Seq No. 재 설정
 */
function setSeq() {
	var rSeq = 0;
	var rCnt = sheetObjects[3].RowCount;
	for (rn = 1; rn <= rCnt; rn++) {
		var rsts = sheetObjects[3].RowStatus(rn);
		if (sheetObjects[3].RowHidden(rn))
			continue;
		// if(rsts != 'D' && sheetObjects[3].CellValue(rn, "Sel") == '0'){
		sheetObjects[3].CellValue2(rn, "Seq") = ++rSeq;
		// sheetObjects[3].RowStatus(rn) = rsts;

		if (rSeq == 1)
			sheetObjects[3].SelectCell(0, 0);
	}
}

/**
 * 모든 Container Seal No 세팅
 */
function setAllSealNo() {
	var cntrObj = sheetObjects[2];

	var cntrCount = cntrObj.RowCount + 1;
	for (idx = 1; idx < cntrCount; idx++) {
		setSealNo(cntrObj.CellValue(idx, "cntr_no"));
	}
}

/**
 * sheetObject의 특정 컬럼의 조건값에 해당하는 열의 Index를 구하는 함수.
 */
function findText(sheetObj, colName, colValue) {
	var idxs = new Array();
	var rcnt = sheetObj.RowCount + 1;
	for (ix = 1; ix < rcnt; ix++) {
		if (sheetObj.RowStatus(ix) != 'D'
				&& sheetObj.CellValue(ix, colName) == colValue) {
			idxs.push('' + ix);
		}
	}
	return idxs;
}

/**
 * 팝업에서 설정한 데이터 Seal No Hidden, Container 시트에 반영
 */
function setSealNo(cntr_no) {
	var fmObject = sheetObjects[5]; // SealNo Hidden Sheet
	var toObject = sheetObjects[2]; // Container Sheet

	// Container 그리드 데이터 행의 개수 확인
	var arrToRow = findText(toObject, "cntr_no", cntr_no);
	if (arrToRow.length == 0) {
		return;
	}

	if (arrToRow.length > 1) {
		return;
	}

	// SealNo 그리드 데이터 행의 개수 확인
	var arrFmRow = findText(fmObject, "cntr_no", cntr_no);
	if (arrFmRow.length == 1) {
		toObject.CellValue2(arrToRow[0], "seal_no") = arrFmRow[0] == '' ? ""
				: fmObject.CellValue(arrFmRow[0], "seal_no");
		toObject.CellValue2(arrToRow[0], "seal_no2") = '';
	} else if (arrFmRow.length > 1) {
		toObject.CellValue2(arrToRow[0], "seal_no") = arrFmRow[0] == '' ? ""
				: fmObject.CellValue(arrFmRow[0], "seal_no");
		toObject.CellValue2(arrToRow[0], "seal_no2") = arrFmRow[1] == '' ? ""
				: fmObject.CellValue(arrFmRow[1], "seal_no");
	} else {
		toObject.CellValue2(arrToRow[0], "seal_no") = '';
		toObject.CellValue2(arrToRow[0], "seal_no2") = '';
	}
}
function saveSeal(flg, cntr_no){
	 
}



/* 개발자 작업 끝 */