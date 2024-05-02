/*=========================================================
 *Copyright(c)2009 CyberLogitec
 *@FileName : esm_bkg_1104.js
 *@FileTitle : esm_bkg_1104
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.29
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2009.05.07 경종윤
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2011.05.29 민정호 [] HIS_SEQ 칼럼 select 하면서 중복 seq 선택되면서 Uniq 에러 발생 수정
 * 2011.05.29 민정호 [CHM-201111128] Split 04-Split 08-ALPS Error 처리 요청
 * 2013.06.25 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
 * 2014.04.21 김보배 [CHM-201429518] ENS - Arrival Notice 화면 관련 시스템 보완요청
 * 2015.12.02 [CHM-201538926]	[ENS] WAND1543N 항차 / POFE calling seq 적용 로직 테스트
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
 * @class esm_bkg_1104 : esm_bkg_1104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1104() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/
var comboObjects = new Array();
var comboCnt = 0;

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// POFE에 mapping되는 YD_CD를 담아내는 배열 : form_cstms_yd_cd property에 mapping된다!
var eu_1st_port_yd_cd = new Array();
var eu_1st_port_clpt_seq = new Array(); // Add 2015.12.02
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
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	switch (comboObj.id) {
	case "p_type":
		with (comboObj) {
 			DropHeight = 300;
 			MultiSelect = false;
 			UseEdit = false;
			InsertItem(cnt ++, "ENS",			  "ENS");
			//InsertItem(cnt ++, "Finland (IE347)", "FI");
			Code = "ENS";
		}
		break;   
	case "trsp_mod_id":
		var i = 0;
		with (comboObj) {
			ColBackColor(0) = "#FFFFFF";
			DropHeight = 200;
			MultiSelect = false;
			MaxSelect = 1;
		}
		break;
	case "seal_pty_tp_cd":
		with (comboObj) {
			ColBackColor(0) = "#CCFFFD";
			DropHeight = 200;
			MultiSelect = false;
			MaxSelect = 1;
		}
		break;
	case "wgt_ut_cd":
		var i = 0;
		with (comboObj) {
			ColBackColor(0) = "#FFFFFF";
			DropHeight = 200;
			MultiSelect = false;
			MaxSelect = 1;
		}
		break;
	case "meas_ut_cd":
		var i = 0;
		with (comboObj) {
			ColBackColor(0) = "#FFFFFF";
			DropHeight = 200;
			MultiSelect = false;
			MaxSelect = 1;
		}
		break;
	case "msg_type":
		var i = 0;
		with (comboObj) {
			ColBackColor(0) = "#CCFFFD";
			DropHeight = 200;
			MultiSelect = false;
			MaxSelect = 1;
		}
		break;
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_MrnDelete":
			doActionIBSheet(sheetObject1, formObject, MULTI02);
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_new":
			doActionIBSheet(sheetObject1, formObject, IBINSERT);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_transmit":
			doActionIBSheet(sheetObject1, formObject, MULTI01);
			break;
		case "btn_viewMsg":
			var row = sheetObject1.SelectRow;
			var edi_rcv_dt_msg = sheetObject1.CellValue(row, "edi_rcv_dt_msg");
			ComOpenWindowCenter(	"/hanjin/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" +  edi_rcv_dt_msg + "&edi_rcv_seq=" + sheetObject1.CellValue(row, "edi_rcv_seq"), "1104", 500, 650, true);
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}

	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form);
	axon_event.addListenerForm("Click","obj_Click", document.form);
	SetButtonStatus();
}
 /**
 * 화면 로드 시 버튼 처리
 */
function SetButtonStatus(){
	if(document.form.vvd.value == ''){
		ComBtnDisable("btn_transmit");
	}else{
		if(document.form.form_crr_cd.value == 'SML'){   //|| form.p_type.Code == "FI"
			if(document.form.form_an_edi_svc_flg.value == 'Y'){
				ComBtnEnable("btn_transmit");
			}else{
				ComBtnDisable("btn_transmit");
			}
   	 	}else{
   	 		ComBtnDisable("btn_transmit");
   	 	}
		
		// SML EU Staff 인 경우에만 All MRN Delete 버튼과 ENS ETA 수정용 체크박스 활성화
		if(sheetObjects[0].CellValue(1, "eu_stf_flg") == "Y"){
			document.getElementById("modify_ens_eta").disabled = false;
//			document.getElementById("modify_ens_eta").checked = true;
			b_MrnDelete.style.display='';
		}else{
			document.getElementById("modify_ens_eta").disabled = true;
			document.getElementById("modify_ens_eta").checked = false;
			b_MrnDelete.style.display='none';
		}
		
		// ENS ETA 수정 이력 여부 초기화
		document.form.init_eta_dt_modi_flg.value = "N";
    }
} 
/**
 * 화면 로딩 완료 후 이벤트
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	var formObj = document.form;
	initSheetData(sheetObjects[0], formObj);
	ComSetFocus(formObj.form_vvd_cd);
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
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
			var HeadTitle1 = "| |eu_stf_flg|vvd|cvy_ref_no|cvy_ref_no_hidden|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|lloyd_no|piclb_desc|cstms_port_cd|eta_dt|etd_dt|n1st_port_ofc_cd|tml_cd|tml_nm|lst_clpt_cd|nxt_clpt_cd|rgst_no|rgst_dt|rgst_port_cd|grs_rgst_tong_wgt|net_rgst_tong_wgt|cre_usr_id|cre_dt|upd_usr_id|upd_dt|snd_usr_id|snd_dt|snd_ofc_cd|ack|result|cstms_yd_cd|edi_rcv_dt|edi_rcv_seq|edi_rcv_dt_msg|crr_cd|init_eta_dt|an_edi_svc_flg";
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
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eu_stf_flg",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vvd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
					"cvy_ref_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
					"cvy_ref_no_hidden", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "vsl_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "skd_voy_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "skd_dir_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "vsl_eng_nm",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "lloyd_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "piclb_desc",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, true,
					"cstms_port_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "eta_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "etd_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true,
					"n1st_port_ofc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "tml_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "tml_nm",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "lst_clpt_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "nxt_clpt_cd",
					false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "rgst_no",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "rgst_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true,
					"rgst_port_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true,
					"grs_rgst_tong_wgt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true,
					"net_rgst_tong_wgt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cre_usr_id",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cre_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "upd_usr_id",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "upd_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "snd_usr_id",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "snd_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "snd_ofc_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "ack", false,
					"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "result",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "cstms_yd_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "edi_rcv_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "edi_rcv_seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "edi_rcv_dt_msg",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "crr_cd",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "init_eta_dt",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, true, "an_edi_svc_flg",
					false, "", dfNone, 0, false, false);
			CountPosition = 0;

			WaitImageVisible = false;
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		
//		if(form.p_type.Code == "ENS") {
			formObj.vvd.value = formObj.form_vvd.value;
			formObj.cvy_ref_no.value = formObj.form_cvy_ref_no.value;
			var cstms_yd_cd = formObj.form_cstms_yd_cd.value;
			formObj.cstms_yd_cd.value = formObj.form_cstms_yd_cd.value;
			
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1104GS.do",	FormQueryString(formObj));
			var valResult = ComGetEtcData(sXml, "data");
			sheetObjects[0].LoadSearchXml(sXml);
			
			var vvd = sheetObjects[0].CellValue(1, "vvd");
			
			if(vvd == "CSGP0071W" || vvd == "CSHI0074W" || vvd == "COLH0178W" || vvd == "CHKG0079W" ||  vvd == "CHAM0076W" 
					 || vvd == "CRTM0069W" ||  vvd == "CQIN0083W"){
				var oldDt = sheetObjects[0].CellValue(1, "init_eta_dt");
				var timeDt = oldDt.substr(10,6);
				var newDt = ComGetDateAdd(oldDt, "D", -1)+timeDt;
				sheetObjects[0].CellValue2(1, "init_eta_dt") = newDt;	
			}
			
			if (sheetObj.RowCount == 1) {
				IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
				formObj.form_init_eta_dt_old.value = formObj.form_init_eta_dt.value;
				if (cstms_yd_cd != '' && cstms_yd_cd != undefined)
					formObj.form_cstms_yd_cd.value = cstms_yd_cd;
			} else {
				ComShowCodeMessage('BKG00095', "VSL Code");
				initSheetData(sheetObj, formObj);
				ComSetFocus(formObj.form_vvd);
			}
//		} else { // Finland (IE344)
//			formObj.vvd.value = formObj.form_fi_vvd.value;
//			formObj.cvy_ref_no.value = formObj.form_fi_cvy_ref_no.value;
//			var cstms_yd_cd = formObj.form_fi_cstms_yd_cd.value;
//			formObj.cstms_yd_cd.value = formObj.form_fi_cstms_yd_cd.value;
//			formObj.eur_edi_msg_tp_id.value = "347";
//			var sParam = ""; 
//			sParam += "cstms_port_cd="	+ formObj.form_fi_cstms_yd_cd.value	+ "&"
//					+ "p_type="			+ formObj.p_type.Code				+ "&"
//					+ FormQueryString(formObj);
//
//			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1104GS.do", sParam);
//					
//			var valResult = ComGetEtcData(sXml, "data");
//			sheetObjects[0].LoadSearchXml(sXml);
//			
//			var vvd = sheetObjects[0].CellValue(1, "vvd");
//						
//			if (sheetObj.RowCount == 1) {
//				IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
//				if (cstms_yd_cd != '' && cstms_yd_cd != undefined)
//					formObj.form_fi_cstms_yd_cd.value = cstms_yd_cd;
//					formObj.form_fi_eta_dt.value = formObj.form_eta_dt.value;
//					formObj.form_fi_etd_dt.value = formObj.form_etd_dt.value;
//					formObj.form_fi_cvy_ref_no.value = sheetObjects[0].CellValue(1, "cvy_ref_no");
//			} else {
//				ComShowCodeMessage('BKG00095', "VSL Code");
//				initSheetData(sheetObj, formObj);
//				ComSetFocus(formObj.form_fi_vvd);
//			}
//		}
		SetButtonStatus();
		ComOpenWait(false);
		break;
	case IBINSERT: // 초기화
		initSheetData(sheetObj, formObj);
		document.form.form_init_eta_dt_old.value = "";
		document.form.init_eta_dt_modi_flg.value = "N";

		document.form.cstms_port_clpt_ind_seq.value =""; // Add. 2015.12.02
//		if(form.p_type.Code == "ENS") {
			ComSetFocus(formObj.form_vvd);
//		} else { // Finland (IE344)
//			formObj.form_fi_vvd.value = "";
//			formObj.form_fi_eta_dt.value = "";
//			formObj.form_fi_etd_dt.value = "";
//			formObj.form_fi_cvy_ref_no.value = "";
//			ComSetFocus(formObj.form_fi_vvd);
//		}
		break;
	case IBSAVE: // 저장,수정
		if (!validateForm(sheetObj, formObj, sAction))
			return;
//		if(form.p_type.Code == "ENS") {
			formObj.form_cstms_port_cd.value = comboObjects[1].Text;
//		} else { // Finland (IE344)
//			formObj.form_cstms_port_cd.value = formObj.form_fi_cstms_yd_cd.value;
//			formObj.form_cstms_yd_cd.value = sheetObjects[0].CellValue(1, "tml_cd");
//			formObj.form_cvy_ref_no.value = formObj.form_fi_cvy_ref_no.value; 
//		}

		if(formObj.form_init_eta_dt_old.value != formObj.form_init_eta_dt.value){
			formObj.init_eta_dt_modi_flg.value = "Y";
		}
		
		if(formObj.init_eta_dt_modi_flg.value == "Y"){
			// Are you sure to change ENS ETA? If yes, previous ENS ETA data will be revised.
			if (ComShowConfirm(ComGetMsg("BKG06153"))) {
				// 확인을 누르면 진행 계속
			} else {
				// 취소를 누르면 진행 중지
				return;
			}
		}
		
		IBS_CopyFormToRow(formObj, sheetObj, 1, "form_");
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("ESM_BKG_1104GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
	case MULTI01: // 전송	
		//alert(location.href.indexOf('alpsdev'));
		//return;
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		ComOpenWait(true);
		formObj.f_cmd.value = MULTI01;
		
		var sParam = ""; 
		
//		if(form.p_type.Code == "ENS") {
			formObj.vvd.value = formObj.form_vvd.value;
			formObj.cvy_ref_no.value = formObj.form_cvy_ref_no.value;
//		} else { // Finland (IE344)
//			formObj.vvd.value = formObj.form_fi_vvd.value;
//			formObj.form_cstms_port_cd.value = formObj.form_fi_cstms_yd_cd.value;
//			formObj.form_cstms_yd_cd.value = sheetObjects[0].CellValue(1, "tml_cd");
//			formObj.form_cvy_ref_no.value = formObj.form_fi_cvy_ref_no.value; 
//			
//			sParam += "cstms_port_cd="	+ formObj.form_fi_cstms_yd_cd.value	+ "&"
//					+ "p_type="	   +formObj.p_type.Code+"&";
//		}
		
		if (location.href.indexOf('alpsdev') != -1 && formObj.form_ibflag.value == 'I') {
			if (formObj.form_snd_usr_id.value = '') {
				ComShowCodeMessage("BKG01128");// No ENS data Found!
			} else {
				ComShowCodeMessage("BKG01129");// Please Save First!
			}
		}else{
//			var sXml = sheetObj.GetSearchXml("ESM_BKG_1104GS.do", FormQueryString(formObj));
			sParam += "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1104GS.do", sParam);
			
			var valResult = ComGetEtcData(sXml, "flatFile");
			formObj.flatfile.value = valResult;
			var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if (State == "S") {
				ComShowCodeMessage("BKG00101"); // Data Transmitted Successfully!!
			}else{
				ComShowCodeMessage("BKG00099"); // Failed to transmit ED!!
			}
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		ComOpenWait(false);
		break;

	case SEARCH02: // VVD Combo setting
		formObj.f_cmd.value = SEARCH02;
		formObj.p_vvd_cd.value = formObj.form_vvd.value;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1104GS.do", FormQueryString(formObj));
		//alert(sXml);
		if (sXml.length > 0) {
			ComBkgXml2ComboItem(sXml, comboObjects[1], "eu_1st_port",	"eu_1st_port|eu_1st_port_yd_cd|eu_1st_port_clpt_seq", true);
			var arr = new Array();
			arr = ComBkgXml2ComboString(sXml, "eu_1st_port", "eu_1st_port");
			if (arr == undefined || arr == '') {
				ComShowCodeMessage("BKG00889"); // No Data Found
				return;
			}
			arr = ComBkgXml2ComboString(sXml, "eu_1st_port_yd_cd",	"eu_1st_port_yd_cd");
			
			//eu_1st_port_yd_cd = arr[0].split(",");
	        var arrYd = arr[0].split("|");
	        for (var i = 0; i < arrYd.length; i++) {
	        	eu_1st_port_yd_cd[i] = arrYd[i];
	        }
	        
	        // Add. 2015.12
			arr =  ComBkgXml2ComboString(sXml, "eu_1st_port_clpt_seq", "eu_1st_port_clpt_seq");
			
			var arrYd = arr[0].split("|");
	        for (var i = 0; i < arrYd.length; i++) {
	        	eu_1st_port_clpt_seq[i] = arrYd[i];
	        }
	        
			formObj.cstms_port_clpt_ind_seq.value = eu_1st_port_clpt_seq[0];
			// End.
			
			comboObjects[1].Index = 0;
		}
		break;
		
	case MULTI02:
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		formObj.form_cstms_port_cd.value = comboObjects[1].Text;
		IBS_CopyFormToRow(formObj, sheetObj, 1, "form_");
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI02;
		sheetObj.DoSave("ESM_BKG_1104GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;
	}
}

// 시트 데이터 초기화
function initSheetData(sheetObj, formObj) {
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);

	IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: { // 조회
//		if(form.p_type.Code == "ENS") {
			if (formObj.form_vvd.value == "") {
				// "Please, input VVD!"
				ComShowCodeMessage("BKG00115");
				ComSetFocus(formObj.form_vvd);
				return false;
			}
//		} else { // Finland (IE344)
//			if (formObj.form_fi_vvd.value == "") {
//				// "Please, input VVD!"
//				ComShowCodeMessage("BKG00115");
//				ComSetFocus(formObj.form_fi_vvd);
//				return false;
//			}
//		}
		break;
	}

	case IBSAVE: { // 입력
		// 기본포멧체크
		if (!ComChkValid(formObj))
			return false;
		
//		if(form.p_type.Code == "ENS") {
			if (formObj.form_vvd.value == "") {
				ComShowCodeMessage('BKG00715', "VSL Code");
				ComSetFocus(formObj.form_vvd);
				return false;
			}
			
			var port = comboObjects[1].Code;
			if(port != undefined && port != ''){
				port = port.substring(0,2);
			}
			
			if(port == 'NL' && formObj.form_cvy_ref_no.value == ""){
				ComShowCodeMessage('BKG00715', "CRN No.");
				ComSetFocus(formObj.form_cvy_ref_no);
				return false;
			}
//		} else { // Finland (IE344)
//			if (formObj.form_fi_vvd.value == "") {
//				ComShowCodeMessage('BKG00715', "VSL Code");
//				ComSetFocus(formObj.form_fi_vvd);
//				return false;
//			}
//		}

		if (formObj.form_vsl_eng_nm.value == "") {
			ComShowCodeMessage('BKG00012');
			ComSetFocus(formObj.form_vsl_eng_nm);
			return false;
		}

		break;
	}

	case REMOVE: { // 삭제
		// 기본포멧체크
		if (!ComChkValid(formObj))
			return false;

		if (sheetObj.RowCount == 0) {
			ComShowCodeMessage('BKG00889');
			return false;
		}

		if (sheetObj.RowCount == 1) {
			if (sheetObj.CellValue(1, "vvd_cd") == ""
					|| sheetObj.CellValue(1, "pod_cd") == "") {
				ComShowCodeMessage('BKG00889');
				return false;
			}
		}
		break;
	}
	case MULTI01: {
		//기본포멧체크
		if (!ComChkValid(formObj))	return false;
		if (formObj.form_vvd.value == "") {
			ComShowCodeMessage('BKG00715', "VSL Code");
			ComSetFocus(formObj.form_vvd);
			return false;
		}
		
		var port = comboObjects[1].Code;
		if(port != undefined && port != ''){
			port = port.substring(0,2);
		}
		
		if(port == 'NL' && formObj.form_cvy_ref_no.value == ""){
			ComShowCodeMessage('BKG00715', "CRN No.");
			ComSetFocus(formObj.form_cvy_ref_no);
			return false;
		}
		
		if (formObj.form_n1st_port_ofc_cd.value == "") {
			ComShowCodeMessage('BKG01131');
			ComSetFocus(formObj.form_n1st_port_ofc_cd);
			return false;
		}
		break;
	}
	
	case MULTI02: {
		// Are you sure to delete All MRN? If yes, previous all MRN will be deleted.
		if (ComShowConfirm(ComGetMsg("BKG06154"))) {
			// 확인을 누르면 진행 계속
		} else {
			// 취소를 누르면 진행 중지
			return;
		}
		break;
	}
	} // end switch
	return true;
}

/**
 * 저장 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		if (document.form.f_cmd.value == MULTI
				&& document.form.f_cmd_detail.value != "D") {
			ComShowCodeMessage('BKG00102');
			return false;
		}
		if (document.form.f_cmd_detail.value == "D") {
			ComShowCodeMessage('BKG00593');
			return false;
		}
	}
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 조회 후 이벤트
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

	
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

	if (srcName == "form_vvd") {
		var temp_vvd = formObj.form_vvd.value;
		doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
		formObj.form_vvd.value = temp_vvd;
		formObj.p_vvd_cd.value = temp_vvd;
		doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
	}
	if (srcName == "cstms_port_cd") {
		var comboIndex = comboObjects[1].Index;
	}
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	/*
	 * if(srcName == "form_vvd_cd" && ComChkLen(srcValue, srcMaxLength)== "2"){
	 * ComSetNextFocus(); }
	 */
}



/**
 * POL, POD Click 여부
 * @return
 */
function obj_Click() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	var sheetObject1 = sheetObjects[0];
	
	if(srcName == "modify_ens_eta"){

		if(document.getElementById("modify_ens_eta").checked == true){
			formObj.form_init_eta_dt.disabled = false;
			formObj.form_init_eta_dt.className="input";
		}else{
			formObj.form_init_eta_dt.className="input2";
			formObj.form_init_eta_dt.disabled = true;
		}
		
	}
}



/**
 * 컨테이너 리스트 콤보 변경시 이벤트
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cstms_port_cd_OnChange(comboObj, value, text) {
	var formObj = document.form;
	var index = comboObj.Index;
	formObj.form_cstms_yd_cd.value = eu_1st_port_yd_cd[index];
	formObj.cstms_port_clpt_ind_seq.value = eu_1st_port_clpt_seq[index]; // Add. 2015.11
}

/**
 * Type 콤보 이벤트 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */ 
//function p_type_OnChange(comboObj, value, text){
//	if(form.p_type.Code == "ENS") {
//		document.getElementById("ensView").style.display = "Inline";
//		document.getElementById("fiView").style.display = "none";
//		ComSetDisplay("ensEtaView", true);
//		ComSetDisplay("fiEtaView", false);
//		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
//		document.form.eur_edi_msg_tp_id.value = "ARN"
//	} else if (form.p_type.Code == "FI") {
//		document.getElementById("ensView").style.display = "none";
//		document.getElementById("fiView").style.display = "Inline";
//		ComSetDisplay("ensEtaView", false);
//		ComSetDisplay("fiEtaView", true);
//		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
//		document.form.eur_edi_msg_tp_id.value = "347"
//	}
//	document.form.reset();
//	sheetObjects[0].RemoveAll();
//}
/* 개발자 작업  끝 */