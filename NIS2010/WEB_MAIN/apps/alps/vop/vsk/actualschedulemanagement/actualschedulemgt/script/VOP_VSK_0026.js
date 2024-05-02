/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0026.js
 *@FileTitle : Actual SKD Report Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.13
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.07.28 정진우
 * 1.0 Creation
 * 
 * History
 * 2010.12.14 진마리아 [CHM-201007712-01] Delay Time 구하는 로직 수정
 * 2011.03.14 진마리아 [CHM-201109291-01] Location Code(숫자포함)의 Validation 체크로직 수정
 * 2011.04.11 진마리아 [CHM-201109577-01] Delete Vessel Code에 대한 조회 로직 보완
 * 2011.05.13 진마리아 [CHM-201110230-01] VSK-Actual SKD creation 화면 일부 수정 요청(EDI와 Departure Report 정보 구분)
* 2011.10.04 김민아 [CHM-201112983-01] Actual SKD Creation 및 Inquiry 화면 및 로직 변경 : Port및 Terminal, Calling Seq, 입력칼럼을 Select Box로 변경 /ATA,ATB,ATD 별 Remark 칼럼 추가 / Delay Time을 Hrs로 로직 변경
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
 * @class VOP_VSK_0026.jsp : VOP_VSK_0026.jsp 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0026() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initCombo = initCombo;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
// 현재 포커스를 가지고 있는 객체명 변수
var focusObj = null;

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var tabLoad = new Array();
tabLoad[0] = 0;
tabLoad[1] = 0;

var glbDlayRsnCds = null;
var glbDlayRsnNms = null;
var glbVslCondCds = null;
var glbVslCondNms = null;

var keyDownFlag = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {

	/** **************************************************** */
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case "btn_port":
			doActionIBSheet(sheetObj, formObj, COMMAND01);
			break;

		case "btn_vvd":
			doActionIBSheet(sheetObj, formObj, COMMAND02);
			break;

		case "btn_print_arr":
			callRDOpen(formObj, "ARR");
			break;

		case "btn_print_dep":
			callRDOpen(formObj, "DEP");
			break;
			
		case "btn_remark_arr":
			if(!document.getElementById(srcName).disabled){
				doActionIBSheet(sheetObj, formObj, COMMAND03);
			}
			break;
			
		case "btn_remark_brth":
			if(!document.getElementById(srcName).disabled){
				doActionIBSheet(sheetObj, formObj, COMMAND04);
			}
			break;
			
		case "btn_remark_dep":
			if(!document.getElementById(srcName).disabled){
				doActionIBSheet(sheetObj, formObj, COMMAND05);
			}

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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * 
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	initControl();

	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);

	document.form.vsl_cd.focus();
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	var prefix = sheetID + "_";

	switch (sheetNo) {
	case 1: // sheet1 init
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
			InitRowInfo(2, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(3, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			/*
			 * mySheet.InitHeadMode([SortEnable], [ColumnMove],
			 * [AllCheckEnable], [UserResize], [RowMove], [Head3D]) SortEnable
			 * Boolean 선택 해더 행의 소트 가능 여부, Default=true ColumnMove Boolean 선택 해더
			 * 행의 컬럼 이동 가능 여부, Default=false AllCheckEnable Boolean 선택 해더 행의 전체
			 * CheckBox 표시 여부, Default=true UserResize Boolean 선택 해더 행의 컬럼 너비 변경
			 * 가능 여부, Default=true RowMove Boolean 선택 좌측 해더의 행 이동 가능 여부,
			 * Default=false Head3D Boolean 선택 해더 셀의 모양의 입체 여부Default=true
			 */
			InitHeadMode(false, true, false, true, false, false);

			var HeadTitle1 = "|Sel|Seq";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,
					prefix + "ibflag");
			InitDataProperty(0, cnt++, dtDelCheck, 30, daCenter, true, prefix
					+ "del_chk", false, "", dfNone, 0, true, true, -1, false,
					false);
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, prefix
					+ "clpt_seq", false, "", dfNone, 0, true, true, -1, false,
					true);
		}
		break;
	}
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Vessel Movement", -1);
			InsertTab(cnt++, "Vessel Condition", -1);
		}
		break;

	}
}

/**
 * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initCombo(comboObj, comboNo) {
	var formObj = document.form;

	switch (comboObj.id) {
	case "vps_port_cd":
		with (comboObj) {
			MultiSelect = false;
			SetTitle("SEQ|Port|C/S|Created");
			SetColAlign("center|left|center|center");
			SetColWidth("38|70|35|60");
			ShowCol = 1;
			DropHeight = 160;
			ValidChar(2, 0);
			MaxLength = 7;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			// Dep에 대해서 색 표시 된 부분을 지운다.
			var ele = document.form.elements;
			for ( var i = 0; i < ele.length; i++) {
				if (ele[i].style.backgroundColor.toUpperCase() == "#DDDDFF") {
					ele[i].style.backgroundColor = "#FFFFFF";
				}
			}

			var sParam = FormQueryString(formObj) + "&"
					+ ComGetPrefixParam("sheet1_");
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0026GS.do", sParam);
			ComOpenWait(false);
			showSheetData(sheetObj, formObj, sXml);
		}
		break;

	case SEARCH01: // Call Indicator
		formObj.f_cmd.value = SEARCH01;

		var vParam = "vsl_cd=" + formObj.vsl_cd.value + "&skd_voy_no="
				+ formObj.skd_voy_no.value + "&skd_dir_cd="
				+ formObj.skd_dir_cd.value
				+ "&vps_port_cd="
				+ getComboObject("vps_port_cd").Code// .substring(0, 5)
				+ "&clpt_ind_seq=" + formObj.clpt_ind_seq.value + "&loc_cd="
				+ formObj.loc_cd.value + "&f_cmd=" + formObj.f_cmd.value;

		// var sParam = FormQueryString(formObj) + "&" +
		// ComGetPrefixParam("sheet1_");
		// var sParam = vParam + "&" + ComGetPrefixParam("sheet1_");
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0026GS.do", vParam);
		break;

	case SEARCH03: // vps_port_cd
		formObj.f_cmd.value = SEARCH03;
		var sParam = FormQueryString(formObj);// + "&" +
												// ComGetPrefixParam("sheet1_");
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0026GS.do", sParam);
		var portList = ComGetEtcData(sXml, "port_list");
		ComVskXml2ComboItem(sXml, comboObjects[0], "val", "name");

		if (comboObjects[0].GetCount() > 0) {
			sheetObjects[0].Index = 1;
			getComboObject("vps_port_cd").focus();
		}else{
			if(formObj.vsl_cd.value!="" && formObj.skd_voy_no.value!="" && formObj.skd_dir_cd.value!=""){
				ComShowMessage("There is no Actual Schedule on VVD("+formObj.vsl_cd.value+formObj.skd_voy_no.value+formObj.skd_dir_cd.value+")");
			}
		}
		break;

	case SEARCH10: // VSL_CD Check
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH10;
			var sParam = FormQueryString(formObj) + "&"
					+ ComGetPrefixParam("sheet1_");
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0026GS.do", sParam);

			return sXml;
		}
		break;

	case COMMAND01: // Port Search
		// sUrl = "/hanjin/VOP_VSK_0043.do?op_=0043";
		// sUrl = "/hanjin/VOP_VSK_0043.do?f_cmd=" + COMMAND13;
		sUrl = "/hanjin/VOP_VSK_0043.do?port_cd="
				+ getComboObject("vps_port_cd").Code;
		ComOpenPopup(sUrl, 422, 510, "returnPortHelp", "0,0", true);
		break;

	case COMMAND02: // VVD Search
		var vslCd = formObj.vsl_cd.value;

		if (vslCd == "") {
			// sUrl = "/hanjin/VOP_VSK_0219.do?op_=0219";
			// sUrl = "/hanjin/VOP_VSK_0219.do?f_cmd=" + COMMAND16;
			sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y"; // [CHM-201109577-01]
			ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
		} else {
			// sUrl =
			// "/hanjin/VOP_VSK_0230.do?op_=0230&ctrl_cd=NORL&vsl_cd="+vslCd;
			// sUrl = "/hanjin/VOP_VSK_0230.do?f_cmd=" + COMMAND17 +
			// "&ctrl_cd=NORL&vsl_cd="+vslCd;
			sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd=" + vslCd;
			ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
		}
		break;
		
	case COMMAND03:		//Remarks
    	var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + formObj.act_arr_rmk.value + "&readonly=true";
		ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
		break;
		
	case COMMAND04:		//Remarks
    	var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + formObj.act_brth_rmk.value + "&readonly=true";
		ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
		break;
		
	case COMMAND05:		//Remarks
    	var sUrl = "/hanjin/VOP_VSK_0218.do?remarks=" + formObj.act_dep_rmk.value + "&readonly=true";
		ComOpenPopupWithTarget(sUrl, 342, 370, "", "0,0", true);
		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		if (ComIsNull(formObj.vsl_cd.value)) {
			ComShowCodeMessage('VSK00027', "Vessel Code");
			formObj.vsl_cd.focus();
			return false;
		} else if (formObj.vsl_cd.value.length < 4) {
			ComShowCodeMessage('VSK00027', "Vessel Code");
			formObj.vsl_cd.value = "";
			formObj.vsl_cd.focus();
			return false;
		} else if (ComIsNull(formObj.skd_voy_no.value)) {
			ComShowCodeMessage('VSK00027', "Voyage No.");
			formObj.skd_voy_no.focus();
			return false;
		} else if (formObj.skd_voy_no.value.length < 4) {
			ComShowCodeMessage('VSK00027', "Voyage No.");
			formObj.skd_voy_no.value = "";
			formObj.skd_voy_no.focus();
			return false;
		} else if (ComIsNull(formObj.skd_dir_cd.value)) {
			ComShowCodeMessage('VSK00027', "Direction Code");
			formObj.skd_dir_cd.focus();
			return false;
		} else if (getComboObject("vps_port_cd").Code == "") {
			ComShowCodeMessage('VSK00027', "Port Code");
			getComboObject("vps_port_cd").focus();
			return false;
		}
		break;
	}

	return true;
}

/**
 * 조회 후 처리로직.
 * 
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml) {
	var prefix = sheetObj.id + "_";

	if (sXml != null) {
		var rootNode = VskGetXmlRootNode(sXml);
		var errNode = rootNode.selectNodes("//ERROR");
		if (errNode.length > 0) {
			sheetObj.LoadSearchXml(sXml);
			clearAllFormData(formObj);
			formObj.vsl_cd.focus();
			return;
		} else {
			var dataNode = rootNode.selectNodes("//ETC");
			if (dataNode.length > 0) {
				// Close Check !
				var skdStsCd = ComGetEtcData(sXml, "SKD_STS_CD");
				// close 메세지 띄우지 마세요(2010.03.29 김기원 C).
				// if(skdStsCd == "CLO"){
				// ComShowCodeMessage("VSK00100");
				// }

				setFormToEtcData(sXml);

				setDelayTime(formObj);

				glbVslCondCds = ComGetEtcData(sXml, "vsl_cond_cd").split("|");
				glbVslCondNms = ComGetEtcData(sXml, "vsl_cond_nm").split("|");

				setVslCondSts(formObj);

				glbDlayRsnCds = ("|" + ComGetEtcData(sXml, "dlay_rsn_cd"))
						.split("|"); // Delay Reason
				glbDlayRsnNms = ("|" + ComGetEtcData(sXml, "dlay_rsn_nm"))
						.split("|"); // Delay Reason

				var ydCd = ComGetEtcData(sXml, "YD_CD");

				formObj.yd_cd.value = ydCd;

				var vslArrDlayRsnCd = ComGetEtcData(sXml, "VSL_ARR_DLAY_RSN_CD")
						.split("|"); // Delay Reason
				var vslBrthDlayRsnCd = ComGetEtcData(sXml,
						"VSL_BRTH_DLAY_RSN_CD").split("|"); // Delay Reason
				var vslDepDlayRsnCd = ComGetEtcData(sXml, "VSL_DEP_DLAY_RSN_CD")
						.split("|"); // Delay Reason
				// var pltUnldDlayCd = ComGetEtcData(sXml,
				// "PLT_UNLD_DLAY_CD").split("|"); //Delay Reason
				formObj.vsl_arr_dlay_rsn_cd.value = vslArrDlayRsnCd;
				formObj.vsl_brth_dlay_rsn_cd.value = vslBrthDlayRsnCd;
				formObj.vsl_dep_dlay_rsn_cd.value = vslDepDlayRsnCd;
				// formObj.plt_unld_dlay_cd.value = pltUnldDlayCd;

				setDlayRsnNms(vslArrDlayRsnCd, formObj.vsl_arr_dlay_rsn_nm);
				setDlayRsnNms(vslBrthDlayRsnCd, formObj.vsl_brth_dlay_rsn_nm);
				setDlayRsnNms(vslDepDlayRsnCd, formObj.vsl_dep_dlay_rsn_nm);
				// setDlayRsnNms(pltUnldDlayCd, formObj.plt_unld_dlay_nm);
				formObj.diff_rmk.value = ComGetEtcData(sXml, "DIFF_RMK");

			} else {
				sheetObj.LoadSearchXml(sXml);
				// ComShowCodeMessage('VSK00043');
				clearAllFormData(formObj);
				formObj.vsl_cd.focus();
				return;
			}
		}
	}
}

/*
 * ===================================================================== Tab
 * Event =====================================================================
 */

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
}

/*
 * ===================================================================== Combo
 * Event =====================================================================
 */

function vps_port_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 13) {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

function vps_port_cd_OnChange(comboObj, Index_Code, Text) {
	var formObj = document.form;
	var sText = Text.split('|');
	var clptIndSeq = sText[2];

	formObj.clpt_ind_seq.value = clptIndSeq;
	formObj.loc_cd.value = Index_Code;
	clearAllFormData(formObj, "S");
}

/*
 * ===================================================================== Object
 * Event =====================================================================
 */

function initControl() {
	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('change', 'obj_change', form); // - form 전체 컨트롤중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
	axon_event.addListenerForm('keypress', 'obj_keypress', form); // - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerForm('keyup', 'obj_keyup', form); // - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeyup 이벤트에 코드 처리
	axon_event.addListenerForm('keydown', 'obj_keydown', form); // - form 전체 컨트롤 onkeydownup 이벤트에 코드 처리
	axon_event.addListenerForm('focus', 'obj_focus', form);
}

function obj_change() {
	var eleObj = event.srcElement;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "vsl_cd":
			if (eleObj.value.length == 0) {
				clearAllFormData(formObj, "N");
			} else {
				clearAllFormData(formObj, "S");
			}

			if (isCheckVslCd(sheetObj, formObj)) {
				formObj.skd_voy_no.focus();
			} else {
				formObj.vsl_cd.focus();
				return false;
			}
			break;
		case "skd_voy_no":
		case "skd_dir_cd":
			if (eleObj.value.length == 0) {
				clearAllFormData(formObj, "N");
			} else {
				clearAllFormData(formObj, "S");
			}
			break;
			
		case "act_arr_dt":
		case "act_brth_dt":
		case "act_dep_dt":
			Usr_setDateTime(formObj, srcName);
			setDelayTime(formObj);
			setVslCondSts(formObj, "N");
			break;

		case "plt_lst_unld_dt":
		case "bfr_brth_ank_drp_dt":
		case "bfr_brth_ank_off_dt":
		case "aft_unbrth_ank_drp_dt":
		case "aft_unbrth_ank_off_dt":
			Usr_setDateTime(formObj, srcName);
			break;

		} // end switch

		// [TAB] Vessel Condition 의 input Element들의 숫자타입 체크
		if (srcName) {
			var inputObj = document.getElementsByName(srcName)[0];
			var parentObj = inputObj.parentNode;
			while (parentObj.parentNode) {
				parentObj = parentObj.parentNode;
				if (parentObj.tagName.toLowerCase() == "table") {
					if (parentObj.id == "tbl_vsl_cond") {
						inputObj.value = ComAddComma(ComReplaceStr(inputObj,
								",", ""));
					} else {
						break;
					}
				}
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}

function obj_keypress() {
	var formObj = document.form;
	var srcName = event.srcElement.name;

	switch (srcName) {
	case "vsl_cd":
		ComKeyOnlyAlphabet('uppernum');
		break;

	case "skd_voy_no":
		ComKeyOnlyNumber(formObj.skd_voy_no);
		break;

	case "skd_dir_cd":
		ComKeyOnlyAlphabet('upper');
		break;

	case "act_arr_dt":
	case "act_brth_dt":
	case "act_dep_dt":
	case "plt_lst_unld_dt":
	case "bfr_brth_ank_drp_dt":
	case "bfr_brth_ank_off_dt":
	case "aft_unbrth_ank_drp_dt":
	case "aft_unbrth_ank_off_dt":
		ComKeyOnlyNumber(formObj.skd_voy_no, ",:");
		break;
	}

	// [TAB] Vessel Condition 의 input Element들의 숫자타입 체크
	if (srcName) {
		var inputObj = document.getElementsByName(srcName)[0];
		var parentObj = inputObj.parentNode;
		while (parentObj.parentNode) {
			parentObj = parentObj.parentNode;
			if (parentObj.tagName == "table") {
				if (parentObj.id == "tbl_vsl_cond") {
					ComKeyOnlyNumber(inputObj, ",.");
				} else {
					break;
				}
			}
		}
	}
}

function obj_keyup() {
	var eleObj = event.srcElement;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	switch (eleObj.name) {
	case "vsl_cd":
		if (eleObj.value.length == 4) {
			doActionIBSheet(sheetObj, formObj, SEARCH03);
			if (keyDownFlag) {
				getComboObject("vps_port_cd").focus();
				keyDownFlag = false;
			} else {
				formObj.skd_voy_no.focus();
			}
		}

		break;
	case "skd_voy_no":
		if (eleObj.value.length == 4) {
			doActionIBSheet(sheetObj, formObj, SEARCH03);
			formObj.skd_dir_cd.focus();
		}
		break;

	case "skd_dir_cd":
		if (eleObj.value.length == 1) {
			doActionIBSheet(sheetObj, formObj, SEARCH03);
		}
		break;
	}
}

function obj_keydown() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	if (focusObj == "vsl_cd") {
		var ctrl = event.ctrlKey;
		var code = event.keyCode;
		if (ctrl && code == 86) {
			var clipData = window.clipboardData.getData('Text');
			if (clipData != null && clipData.length == 9) {
				clipData = clipData.toUpperCase();
				formObj.vsl_cd.value = clipData.substring(0, 4);
				if (isCheckVslCd(sheetObj, formObj)) {
					formObj.skd_voy_no.value = clipData.substring(4, 8);
					formObj.skd_dir_cd.value = clipData.substring(8, 9);
					keyDownFlag = true;
				}
			}
			event.returnValue = false;
		}
	}
}

function obj_focus() {
	var eleObj = event.srcElement;

	if (eleObj.name) {
		focusObj = eleObj.name;
	} else {
		focusObj = "";
	}
}

/**
 * VSL Code Help (Pop-Up)에서 받은 데이타 처리.
 * 
 * @param rtnObjs
 * @return
 */
function returnVslCdHelp(rtnObjs) {
	var formObj = document.form;

	if (rtnObjs) {
		var rtnDatas = rtnObjs[0];
		if (rtnDatas) {
			if (rtnDatas.length > 0) {
				formObj.vsl_cd.value = rtnDatas[1];
				clearAllFormData(formObj, "S");
			}
		}
	}
}

/**
 * VVD Code Help (Pop-Up)에서 받은 데이타 처리.
 * 
 * @param rtnObjs
 * @return
 */
function returnVvdHelp(rtnObjs) {
	var formObj = document.form;

	if (rtnObjs) {
		var rtnDatas = rtnObjs[0];
		if (rtnDatas) {
			if (rtnDatas.length > 0) {
				formObj.skd_voy_no.value = rtnDatas[2];
				formObj.skd_dir_cd.value = rtnDatas[3];
				clearAllFormData(formObj, "S");
				
				doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
			}
		}
	}
}

/*
 * ===================================================================== Form
 * Control =====================================================================
 */

/**
 * DlayRsnCd 에 해당하는 DlayRsnNm 을 해당 inputObj 에 보여준다.
 * 
 * @param dlayCd
 * @param inputObj
 * @return
 */
function setDlayRsnNms(dlayCd, inputObj) {
	var rsnCnt = glbDlayRsnNms.length;

	if (rsnCnt > 0) {
		for ( var i = 0; i < rsnCnt; i++) {
			if (dlayCd == glbDlayRsnCds[i]) {
				document.getElementsByName(inputObj.name)[0].value = glbDlayRsnNms[i];
				break;
			} else {
				document.getElementsByName(inputObj.name)[0].value = "";
			}
		}
	}
}

/**
 * xml로 받은 전문을 읽어 form 객체들에 value를 찾아 Setting...
 * 
 * @param sXml
 * @return
 */
function setFormToEtcData(sXml) {
	var rootNode = VskGetXmlRootNode(sXml);
	if (rootNode.selectNodes("//ETC")) {
		var dataNodes = rootNode.selectNodes("//ETC");
		var keyValue = "";
		var inputName = "";
		for ( var i = 0; i < dataNodes.length; i++) {
			keyValue = dataNodes[i].selectSingleNode("@KEY").nodeValue;
			inputName = keyValue.toLowerCase();

			if (document.getElementsByName(inputName)[0]) {
				var inputObj = document.getElementsByName(inputName)[0];
				if (inputObj.type == "text" || inputObj.type == "hidden") {

					// vessel condition에 대해서는 Departure Report 데이터의 경우 색을 변환하여
					// 보여준다.
					var tab2Obj = false;
					var parentObj = inputObj.parentNode;
					while (parentObj.parentNode) {
						parentObj = parentObj.parentNode;
						if (parentObj.tagName) {
							if (parentObj.tagName.toUpperCase() == "TABLE") {
								if (parentObj.id == "tbl_vsl_cond") {
									tab2Obj = true;
								}
								break;
							}
						}
					}
					inputObj.value = ComGetEtcData(sXml, keyValue);
					if (tab2Obj) {
						var flgValue = ComGetEtcData(sXml, keyValue + "_FLG");
						if (flgValue == "Dep") {
							inputObj.style.backgroundColor = "#DDDDFF";
						}
					}
				}
			}
		}
	}
}

/**
 * 해당 Form의 Data들을 지운다.
 * 
 * @param formObj
 * @return
 */
function clearAllFormData(formObj, flag) {
	var eleObjs = formObj.elements;
	var len = eleObjs.length;

	for ( var i = 0; i < len; i++) {
		if (flag != null && flag != undefined && flag != "") {

			if (eleObjs[i].name == "vsl_cd" || eleObjs[i].name == "skd_voy_no"
					|| eleObjs[i].name == "skd_dir_cd") {
				// pass
			} else {
				ComClearObject(eleObjs[i]);
			}
		} else {
			ComClearObject(eleObjs[i]);
		}
	}
	// Combo Remove...
	if (flag == "N")
		comboObjects[0].RemoveAll();
}

/**
 * Vessel Movement - Vessel Condition 을 Setting...
 * 
 * @param sXml
 * @param formObj
 * @return
 */
function setVslCondSts(formObj, flag) {

	var portSkdStsCd = "";

	if (flag != "N") {
		portSkdStsCd = formObj.port_skd_sts_cd.value;
	}

	if (portSkdStsCd != "") {
		for ( var i = 0; i < glbVslCondCds.length; i++) {
			if (glbVslCondCds[i] == portSkdStsCd) {
				formObj.port_skd_sts_nm.value = glbVslCondNms[i];
			}
		}
	} else {
		if (formObj.act_dep_dt.value != "") {
			for ( var i = 0; i < glbVslCondCds.length; i++) {
				if (glbVslCondCds[i] == "D") {
					formObj.port_skd_sts_cd.value = glbVslCondCds[i];
					formObj.port_skd_sts_nm.value = glbVslCondNms[i];
				}
			}
		} else if (formObj.act_brth_dt.value != "") {
			for ( var i = 0; i < glbVslCondCds.length; i++) {
				if (glbVslCondCds[i] == "B") {
					formObj.port_skd_sts_cd.value = glbVslCondCds[i];
					formObj.port_skd_sts_nm.value = glbVslCondNms[i];
				}
			}
		} else {
			for ( var i = 0; i < glbVslCondCds.length; i++) {
				if (glbVslCondCds[i] == "A") {
					formObj.port_skd_sts_cd.value = glbVslCondCds[i];
					formObj.port_skd_sts_nm.value = glbVslCondNms[i];
				}
			}
		}
	}
}

/**
 * RD Viewer 호출.
 * 
 * @param formObj
 * @return
 */
function callRDOpen(formObj, prtFlg) {
	var rdParam = setQueryStr(formObj);

	if (VskIsNull(rdParam)) {
		return;
	} else {
		if (prtFlg == "ARR") {
			formObj.com_mrdPath.value = "apps/alps/vop/vsk/actualschedulemanagement/actualschedulemgt/report/VOP_VSK_0026_1.mrd";
			formObj.com_mrdArguments.value = rdParam;
			formObj.com_mrdBodyTitle.value = "Vessel Arrival Report";
			formObj.com_mrdSaveDialogFileName.value = "Vessel Arrival Report";

			ComOpenRDPopupModal();
		} else if (prtFlg == "DEP") {
			formObj.com_mrdPath.value = "apps/alps/vop/vsk/actualschedulemanagement/actualschedulemgt/report/VOP_VSK_0026_2.mrd";
			formObj.com_mrdArguments.value = rdParam;
			formObj.com_mrdBodyTitle.value = "Vessel Departure Report";
			formObj.com_mrdSaveDialogFileName.value = "Vessel Departure Report";

			ComOpenRDPopupModal();
		}
	}
}

/**
 * RD 에 넘어갈 Parameter Setting.
 * 
 * @param formObj
 * @return
 */
function setQueryStr(formObj) {
	var qryStr = "";
	if (VskIsNull(formObj.vsl_cd.value) || VskIsNull(formObj.skd_voy_no.value)
			|| VskIsNull(formObj.skd_dir_cd.value)
			|| VskIsNull(formObj.loc_cd.value)
			|| VskIsNull(formObj.clpt_ind_seq.value)) {
		qryStr = "";
	} else {
		qryStr += "/rv vsl_cd[" + formObj.vsl_cd.value + "]";
		qryStr += " skd_voy_no[" + formObj.skd_voy_no.value + "]";
		qryStr += " skd_dir_cd[" + formObj.skd_dir_cd.value + "]";
		qryStr += " vps_port_cd[" + formObj.loc_cd.value + "]";
		qryStr += " clpt_ind_seq[" + formObj.clpt_ind_seq.value + "]";
		qryStr += " this_time[" + VskRdPrintDate() + "]";
	}

	return qryStr;
}

/**
 * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function isCheckVslCd(sheetObj, formObj) {
	if (formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined
			|| formObj.vsl_cd.value == "")
		return false;

	var sXml = doActionIBSheet(sheetObj, formObj, SEARCH10);

	var chkVslCd = ComGetEtcData(sXml, "vsl_chk");

	if (chkVslCd == "Y") {
		// MDM_VSL_CNTR 에 Vessel Code가 존재
		return true;
	} else {
		sheetObj.LoadSearchXml(sXml);
		formObj.vsl_cd.value = "";
		return false;
	}
}

/**
 * Date의 구분자들을 제거한다.
 * 
 * @param sDate
 * @return
 */
function Usr_replaceDateOrigin(sDate) {
	var rDate = sDate;
	rDate = ComReplaceStr(rDate, "-", "");
	rDate = ComReplaceStr(rDate, ":", "");
	rDate = ComReplaceStr(rDate, " ", "");

	return rDate;
}

/**
 * Delay Time 을 구하여 해당 input 에 넣는다.
 * 
 * @param formObj
 * @return
 */
function setDelayTime(formObj) {
	var vpsEtaDt = Usr_replaceDateOrigin(formObj.vps_eta_dt.value);
	var vpsEtbDt = Usr_replaceDateOrigin(formObj.vps_etb_dt.value);
	var vpsEtdDt = Usr_replaceDateOrigin(formObj.vps_etd_dt.value);

	var lstEtaDt = Usr_replaceDateOrigin(formObj.lst_eta_dt.value);
	var lstEtbDt = Usr_replaceDateOrigin(formObj.lst_etb_dt.value);
	var lstEtdDt = Usr_replaceDateOrigin(formObj.lst_etd_dt.value);

	var actArrDt = Usr_replaceDateOrigin(formObj.act_arr_dt.value);
	var actBrthDt = Usr_replaceDateOrigin(formObj.act_brth_dt.value);
	var actDepDt = Usr_replaceDateOrigin(formObj.act_dep_dt.value);

	var arrTimeDiff = "";
	var brthTimeDiff = "";
	var depTimeDiff = "";

	var sign = "";

	if (actArrDt != null && actArrDt != "") {
		if (lstEtaDt != null && lstEtaDt != "") {
			arrTimeDiff = setParsingDelayTime(lstEtaDt, actArrDt);
		} else if (vpsEtaDt != null && vpsEtaDt != "") {
			arrTimeDiff = setParsingDelayTime(vpsEtaDt, actArrDt);
		}
	}
	if (actBrthDt != null && actBrthDt != "") {
		if (lstEtbDt != null && lstEtbDt != "") {
			brthTimeDiff = setParsingDelayTime(lstEtbDt, actBrthDt);
		} else if (vpsEtbDt != null && vpsEtbDt != "") {
			brthTimeDiff = setParsingDelayTime(vpsEtbDt, actBrthDt);
		}
	}
	if (actDepDt != null && actDepDt != "") {
		if (lstEtdDt != null && lstEtdDt != "") {
			depTimeDiff = setParsingDelayTime(lstEtdDt, actDepDt);
		} else if (vpsEtdDt != null && vpsEtdDt != "") {
			depTimeDiff = setParsingDelayTime(vpsEtdDt, actDepDt);
		}
	}

	formObj.dlay_arr_tm.value = arrTimeDiff;
	formObj.dlay_brth_tm.value = brthTimeDiff;
	formObj.dlay_dep_tm.value = depTimeDiff;
}

/*
 * CHM-201007712
 */
/**
 * 날짜 문자열을 인자로 받아서 new Date()로 년월일을 설정하여 반환한다. 인자가 날짜형태가 아니면 null을 반환한다. <br>
 */
function getDateObj(sDate) {
	sDate = sDate.replace(/\/|\-|\.|\:|\ /g, ""); // 날짜구분자,시간구분자,스페이스 없애기

	var arr = new Array();
	for ( var i = 0; i < 7; i++) {
		arr[i] = 0;
	}

	var iLen = sDate.length;

	if (iLen >= 4) arr[0] = sDate.substr(0, 4); // year
	if (iLen >= 6) arr[1] = sDate.substr(4, 2) - 1; // month
	if (iLen >= 8) arr[2] = sDate.substr(6, 2); // day

	if (iLen >= 10) arr[3] = sDate.substr(8, 2); // hours
	if (iLen >= 12) arr[4] = sDate.substr(10, 2); // minutes
	if (iLen >= 14) arr[5] = sDate.substr(12, 2); // seconds
	if (iLen <= 17) arr[6] = sDate.substr(14); // hour

	return new Date(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
}

/*
 * CHM-201007712
 */
/**
 * Delay Time을 정해진 Format 으로 변환.
 * 
 * @param fmDate
 * @param toDate
 * @return
 */
function setParsingDelayTime(fmDate, toDate) {
	var fmDate1 = getDateObj(fmDate);
	var toDate1 = getDateObj(toDate);

	var delayDay = (toDate1 - fmDate1) / (1000 * 60 * 60);

	if (delayDay < 0) {
		delayDay = "";
	} else {
		delayDay = parseFloat(delayDay.toFixed(1));
	}

	return delayDay;
}

/**
 * 입력한 날짜를 정해진 포맷으로 변환한다.
 * 
 * @param formObj
 * @param srcName
 * @return
 */
function Usr_setDateTime(formObj, srcName) {
	var inputObj = document.getElementsByName(srcName)[0];
	if (inputObj != null && inputObj != undefined) {
		if (inputObj.value.length >= 10) {
			var sDate = Usr_replaceDateOrigin(inputObj.value);
			sDate = ComGetMaskedValue(sDate, "ymdhm");
			if (ComIsDateTime(sDate, "", "hm")) {
				inputObj.value = sDate;
			}
		}
	}

	// document.getElementsByName(srcName)[0].value =
}

/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * 
 * @param comboId
 * @return
 */
function getComboObject(comboId) {
	var cnt = comboObjects.length;
	if (cnt > 0) {
		for ( var i = 0; i < cnt; i++) {
			if (comboObjects[i].id == comboId) {
				return comboObjects[i];
			}
		}
	}

	return null;
}


function msgmove(){
	msg.style.posLeft = event.x - 10 + document.body.scrollLeft;
	msg.style.posTop = event.y + 10 + document.body.scrollTop;
}

function msgset(strMsg){
	if(strMsg != ""){
		text="<table width=125 bgcolor=#FFFFE0 style='border:1 black solid;'><tr><td>" + strMsg + "</td></tr></table>";
		msg.innerHTML = text;
		msg_box.style.display = "";
	}
}

function msghide(){
	msg.innerHTML = "";
	msg_box.style.display = "none";
}

/* 개발자 작업 끝 */