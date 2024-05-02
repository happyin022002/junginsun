/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0034.js
 *@FileTitle : B/L Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.05.04 이수빈
 * 1.0 Creation
 * -----------------------------------------------------
 * History
 * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
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
function ESM_BKG_0034() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var trnkBdrFlg = "";
var ofcCode = "";

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var open_flg = true;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	var sheetObject1 = sheetObjects[0];
	/** ******************************************************************* */
	var formObject = document.form;
	var rdObject = rdObjects[0];
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {
		case "btn_edit":
			setEditable();
			break;
		
		case "btn_retrieve":
			tabObjects[0].SelectedIndex = 0;
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		
		case "btn_save":
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			//재조회
			//doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		
		case "btn_del":
			doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
			break;
		
		case "btn_reactivate":
			doActionIBSheet(sheetObjects[0], formObject, IBRESET);
			break;
		
		case "btn_print":
			rdOpen(rdObject);
			break;
		
		case "btn_container":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
			break;
		
		case "btn_cm":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
			break;
		
		case "btn_blcharge":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
			break;
		
		case "btn_view":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC05);
			break;
		
		case "btn_transmit":
			if (ComShowCodeConfirm('BKG01023', 'AI', 'US Customs')) { // AI전송여부 확인
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
			}
//			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC06);
			break;
		
		case "btn_trans_ptt":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC07);
			break;
		
		case "btn_trans_isf":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC08);
			break;
		
		case "btn_customer":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC09);
			break;
			
		case "btn_div":
			doActionIBSheet(sheetObjects[0], formObject, MULTI03);
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 콤보 Object를 comboObjects 배열에 등록
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
	switch (comboObj.id) {
	case "combo_c_cd":
		var i = 0;
		with (comboObj) {
			ColBackColor(0) = "#CCFFFD";
			DropHeight = 600;
			MultiSelect = false;
			MaxSelect = 0;
		}
		break;
	case "combo_t_cd":
		var i = 0;
		with (comboObj) {
			DropHeight = 300;
			MultiSelect = false;
			MaxSelect = 0;
			// Enable = false;
		}
		break;
	}
}

/**
 * 콤보 Change 이벤트
 */
function combo_t_cd_OnChange() {
	var formObj = document.form;
	var t_cd = comboObjects[0].Code;
	/*
	 * 20100410
	 * 정민정 과장 요청으로 주석처리함.
	 */
//	if (t_cd == "F" || t_cd == "V") {
//		comboObjects[0].Code = document.form.locl_trns_cd.value;
//	}
	
}

/**
 * 콤보 Change 이벤트
 */
function combo_c_cd_OnChange() {
	comboObjects[1].Code = document.form.cstms_clr_cd.value;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	
	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}
	
	comboObjects[0].InsertItem(0, "LOCAL", "L");
	comboObjects[0].InsertItem(1, "P/MIB", "I");
	comboObjects[0].InsertItem(2, "NVOCC", "N");
	comboObjects[0].InsertItem(3, "FROB(F)", "F");
	comboObjects[0].InsertItem(4, "FROB(V)", "V");
	
	comboObjects[0].Enable = false;
	
	
	comboObjects[1].InsertItem(0, "D | Partial SML In-bond", "D");
	comboObjects[1].InsertItem(1, "E | I. E. Closed", "E");
	comboObjects[1].InsertItem(2, "H | US Government Hold", "H");
	comboObjects[1].InsertItem(3, "I | Broker In-bond after SML In-Bond", "I");
	comboObjects[1].InsertItem(4, "J | In-Bond Authorization", "J");
	comboObjects[1].InsertItem(5, "N | No Customs", "N");
	comboObjects[1].InsertItem(6, "P | Partial Customs Entry", "P");
	comboObjects[1].InsertItem(7, "T | T&E Closed", "T");
	comboObjects[1].InsertItem(8, "V | Broker In-Bond", "V");
	comboObjects[1].InsertItem(9, "W | Permit to Transfer", "W");
	comboObjects[1].InsertItem(10, "Y | Customs Clearance", "Y");
	
	comboObjects[2].InsertItem(0, "Y", "Y");
	comboObjects[2].InsertItem(1, "N", "N");
	
	var formObj = document.form;
	
	if (formObj.open_tab.value != "") {
		tabObjects[0].SelectedIndex = formObj.open_tab.value;
	}
	
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("click", "obj_click", formObj);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObj);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", formObj);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	// 사용자 버튼별 권한 정보 조회
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);

	// SETTING WGT UNIT CODE 
	doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
	
	initRdConfig(rdObjects[0]);
	formObj.bl_nos.focus();
}

function callSearchBlInfo(sheetObj) {
	
	var formObj = document.form;
	
	// B/L No. 정보 조회
	var blNo = formObj.bl_no.value;
	if (blNo != "") {
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	} else {
		if (formObj.vvd.value != "") {
			doActionIBSheet(sheetObj, formObj, COMMAND20);
		}
	}
	
	// 전역변수 셋팅
	ofcCode = formObj.office.value;
	setButton();
	
	// 버튼 초기화
	ComBtnDisable("btn_view");
//	ComBtnDisable("btn_trans_isf");
}

/**
 * Rd 설정
 */
function initRdConfig(rdObject) {
	
	var Rdviewer = rdObject;
	
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.IsShowDlg = 0;
	Rdviewer.setbackgroundcolor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
	Rdviewer.style.height = 0;
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if ((srcName == "vvd" || srcName == "pod_cd" || srcName == "del_cd" || srcName == "hub_loc_cd" || srcName == "cstms_loc_cd" || srcName == "ibd_trsp_no" || srcName == "usa_lst_loc_cd")
			&& ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
	
	if (srcName == "bl_nos") {
		if (ComChkLen(srcValue, 12) == "0") {
			formObject.bl_nos.value = srcValue.substr(0, srcValue.length - 1);
			ComSetNextFocus();
		}
	}
	if (srcName == "pck_qty") {
		AddComma(formObject.pck_qty, "#,###");
	}
	if (srcName == "cgo_wgt") {
		AddComma(formObject.cgo_wgt, "#,###.###");
	}
}

/**
 * Click 이벤트 발생 시 처리
 */
function obj_click() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if (srcName == "full_mty_chk") {
		if (formObject.full_mty_chk.checked) {
			formObject.full_mty_cd.value = 'M';
		} else {
			formObject.full_mty_cd.value = 'F';
		}
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
	case 1:
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			// SheetWidth = mainTable.clientWidth;
			
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
			
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(31, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			
			var HeadTitle = "|bl_no|cstms_file_tp_cd|mf_sts_cd|entry type|full_mty_cd|cstms_mf_tp_cd|F|O|C|mbl_no|pre_mf_no|vvd|pol|pod|vps_eta_dt|del|cstms_loc_cd|hub|usa_lst|pck_qty||cgo_wgt||p/mib no.|type|R|D|trnk_bdr_flg|bl_tp_cd|FTZ";
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cstms_file_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "mf_sts_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "locl_trns_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "full_mty_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "cstms_mf_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "frt_clt_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "obl_rdem_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cstms_clr_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "mbl_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "pre_mf_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "vvd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "pol_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "pod_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "vps_eta_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "del_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cstms_loc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "hub_loc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "usa_lst_loc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "pck_qty", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "ams_pck_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "cgo_wgt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "wgt_ut_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "ibd_trsp_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "ibd_tp_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "rcv_term_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "de_term_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daLeft, false, "trnk_bdr_flg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "bl_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "free_trd_zn_flg", false, "", dfNone, 0, false, false);
			
			CountPosition = 0;
			Visible = true;
		}
		break;
	
	} // switch end
}

/**
 * StringBuffer 설정
 */
var StringBuffer = function() {
	this.buffer = new Array();
}
StringBuffer.prototype.append = function(obj) {
	this.buffer.push(obj);
}
StringBuffer.prototype.toString = function() {
	return this.buffer.join("");
}

var objTabWin;
/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {

	case COMMAND01: // setting wgt unit code
		formObj.f_cmd.value = COMMAND01;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0034GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sXml, formObj.wgt_ut_cd, "val", "name");
		formObj.wgt_ut_cd.InsertItem(0, "", "");
		break;
	
	case IBCLEAR: // 사용자 버튼별 권한 정보 조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0034GS.do", FormQueryString(formObj));
		break;
		
	case COMMAND20: // Dummy B/L No. 생성
		
		formObj.f_cmd.value = INIT;
		sheetObj.DoSearch("ESM_BKG_0034GS.do", FormQueryString(formObj));
		// 2010.04.27 Edit 버튼이 안먹어서 수정(사용자 버튼별 권한 정보 세팅)
		IBS_EtcDataToForm(formObj, sheetObj);
		
		formObj.bl_nos.value = sheetObj.EtcData("dummy_bl_no");
		formObj.bl_no.value = sheetObj.EtcData("dummy_bl_no");
		formObj.bak_bl_no.value = sheetObj.EtcData("dummy_bl_no");
		
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_reactivate");
		
		formObj.full_mty_chk.disabled = false;
		formObj.pol_cd.readOnly = false;
		formObj.pol_cd.className = 'input';
		formObj.del_cd.readOnly = false;
		formObj.del_cd.className = 'input';
		loadTabPage(1);
		sheetObj.DataInsert();
		sheetObj.CellValue2(1, "bl_no") = formObj.bl_no.value;
		sheetObj.CellValue2(1, "full_mty_cd") = "M";
		formObj.full_mty_chk.checked = true;
		break;
	
	case IBSEARCH: // Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		
		initInputData();
		clearAllTabPages();
		
//		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH01;
		sheetObj.DoSearch("ESM_BKG_0034GS.do", FormQueryString(formObj));
		
		var tabObj = tabObjects[0];
		
		if (sheetObj.RowCount <= 0) {
			ComShowCodeMessage('BKG00889'); // No Data Found.
		} else {
			IBS_EtcDataToForm(formObj, sheetObj);
			
			trnkBdrFlg = sheetObj.EtcData("trnk_bdr_flg");
			setButton();
			
			formObj.bl_nos.value = sheetObj.EtcData("bl_no") + sheetObj.EtcData("bl_tp_cd");
			formObj.bkg_no.value = sheetObj.EtcData("bkg_no");
			formObj.dir_de_flg.value = sheetObj.EtcData("dir_de_flg");

			var hblCnt = parseInt(sheetObj.EtcData("hbl_cnt"));
			if (formObj.mbl_no.value != "") { // H.B/L 이면 탭 비활성
				tabObj.TabEnable(5) = false;
			} else {
				if (hblCnt == 0) { // M.B/L 이고  해당 H.B/L 이 없으면 탭 비활성
					tabObj.TabEnable(5) = false;
				} else {
					tabObj.TabEnable(5) = true;
				}
			}
			var blCnt = parseInt(sheetObj.EtcData("bl_cnt"));
			if (blCnt == 0) { // Multi B/L 이 아니면 탭 비활성
				tabObj.TabEnable(6) = false;
			} else {
				tabObj.TabEnable(6) = true;
			}
			
			AddComma(formObj.pck_qty, "#,###");
			AddComma(formObj.cgo_wgt, "#,###.###");
			
			if (sheetObj.EtcData("cstms_file_tp_cd") != "") {
				formObj.cstms_file_tp_cd.value = "0" + sheetObj.EtcData("cstms_file_tp_cd");
			}
			
			var stsCd = sheetObj.EtcData("mf_sts_cd");
			if (stsCd == "A") {
				document.getElementById("mf_sts_cd").innerHTML = "Active";
				document.getElementById("mf_sts_cd").style.color = "blue";
				formObj.mf_sts_code.value = "A";
			} else if (stsCd == "D") {
				document.getElementById("mf_sts_cd").innerHTML = "Deleted";
				document.getElementById("mf_sts_cd").style.color = "red";
				formObj.mf_sts_code.value = "D";
			}

			/*
			 * 20100417 새벽 경종윤
			 * inbound(cstms_clr_cd)쪽 데이타가  manual인지 아니지 보여준다
			 */
			var cgorTeamCd = sheetObj.EtcData("cgor_team_cd");
			if (cgorTeamCd == "M") {
				document.getElementById("cgor_team_cd").innerHTML = "M";
				document.getElementById("cgor_team_cd").style.color = "red";
			} else {
				document.getElementById("cgor_team_cd").innerHTML = "";
				document.getElementById("cgor_team_cd").style.color = "";
			}
			
			comboObjects[0].Code = sheetObj.EtcData("locl_trns_cd");
			formObj.locl_trns_cd.value = sheetObj.EtcData("locl_trns_cd");
			comboObjects[1].Code = sheetObj.EtcData("cstms_clr_cd");
			formObj.cstms_clr_cd.value = sheetObj.EtcData("cstms_clr_cd");
			
			formObj.bak_bl_no.value = sheetObj.EtcData("bl_no");
			
			var fullMtyCd = sheetObj.EtcData("full_mty_cd");
			if (fullMtyCd == 'M') {
				formObj.full_mty_chk.checked = true;
			}
			if (formObj.open_tab.value == "") {
				loadTabPage(0);
				loadTabPage(1);
			}
			
			setUnEditable();
		}
		break;
	
	case IBSAVE: // Save
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		if (formObj.full_mty_chk.checked) {
			formObj.full_mty_cd.value = 'M';
		} else {
			formObj.full_mty_cd.value = 'F';
		}
		var sParam = new StringBuffer();
		formObj.f_cmd.value = MULTI;
		
		var temp = new StringBuffer();
		var eta = formObj.vps_eta_dt2.value;
		temp.append(eta.substr(0, 10).replace(/-/gi, '').trim());
		temp.append(eta.substr(11, 8).replace(/:/gi, '').trim());
		formObj.vps_eta_dt.value = temp.toString();
		
		if (comboObjects[0].Code != formObj.locl_trns_cd.value) {
			formObj.locl_trns_cd.value = comboObjects[0].Code;
		}
		
		sParam.append(FormQueryString(document.form) + "&");
		
		var newParam = ComSetPrifix(FormQueryString(document.form), "t0_new_");
		var oldParam = ComSetPrifix(sheetObjects[0].GetSaveString(true), "t0_old_");
		sParam.append(newParam + "&" + oldParam);
		
		var sParamTab1 = document.getElementById("t1frame").contentWindow.getSaveString();
		if (sParamTab1 != "") {
			sParam.append("&" + sParamTab1);
		}
		var sParamTab2 = document.getElementById("t2frame").contentWindow.getSaveString();
		if (sParamTab2 != "") {
			sParam.append("&" + sParamTab2);
		}
		objTabWin = document.getElementById("t4frame").contentWindow;
		if (objTabWin.location.href != "about:blank") {
			var sParamTab4 = document.getElementById("t4frame").contentWindow.getSaveString();
			if (sParamTab4 != "") {
				sParam.append("&" + sParamTab4);
			}
		} else {
			sParam.append("&t4_diff_rmk=" + document.form.diff_rmk.value);
			sParam.append("&t4_bak_diff_rmk=" + document.form.diff_rmk.value);
		}

		if (formObj.bak_bl_no.value != formObj.bl_no.value) {
			ComShowCodeMessage('BKG00439'); // B/L No. 다름
			return;
		}
		
		if (formObj.pol_cd.value == ''){
			
			ComShowCodeMessage("BKG00104", "POL");
			return false;
		}
		if (formObj.del_cd.value == ''){
			ComShowCodeMessage("BKG00104", "DEL");
			return false;
		}
		if (formObj.cstms_loc_cd.value == ''){
			ComShowCodeMessage("BKG00104", "Customs Loc");
			return false;
		}
		if (formObj.hub_loc_cd.value == ''){
			ComShowCodeMessage("BKG00104", "HUB");
			return false;
		}
		if (ComShowCodeConfirm('BKG00498')) { // 저장 여부 확인
			ComOpenWait(true);
			sheetObj.RowStatus(sheetObj.LastRow) = "U";
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0034GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);
			ComOpenWait(false);
		}
		break;
	
	case IBRESET: // Reactive
		if (ComShowCodeConfirm('BKG00498')) { // 저장 여부 확인
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0034GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			try {
				var vPrefix = sXml.substring(1, 6);
				
				if (vPrefix != "ERROR") {
					
					document.getElementById("mf_sts_cd").innerHTML = "Active";
					document.getElementById("mf_sts_cd").style.color = "blue";
					formObj.mf_sts_code.value = "A";
					ComBtnDisable("btn_reactivate");
					ComBtnEnable("btn_del");
					ComShowCodeMessage('BKG95004', 'Reativated'); // Data Reativated Successfully
					
					if (ComShowCodeConfirm('BKG01023', 'AI', 'US Customs')) { // AI전송여부 확인
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
					}
				}
			} catch (err) {
				ComFuncErrMsg(err.message);
			}
		}
		break;
	
	case IBDELETE: // Delete
		if (ComShowCodeConfirm('BKG00498')) { // 저장 여부 확인
			formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0034GS.do", FormQueryString(formObj));
			try {
				var vPrefix = sXml.substring(1, 6);
				
				if (vPrefix != "ERROR") {
					document.getElementById("mf_sts_cd").innerHTML = "Deleted";
					document.getElementById("mf_sts_cd").style.color = "red";
					formObj.mf_sts_code.value = "D";
					ComBtnDisable("btn_del");
					ComBtnEnable("btn_reactivate");
					ComShowCodeMessage('BKG00593'); // Data Deleted Successfully
					
					if (ComShowCodeConfirm('BKG01023', 'AI', 'US Customs')) { // AI전송여부 확인
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
					}
				}
			} catch (err) {
				ComFuncErrMsg(err.message);
			}
		}
		break;
	
	case IBSEARCH_ASYNC01: // Print 
		formObj.f_cmd.value = '';
		formObj.pagerows.value = '';
		ComOpenWindow("ESM_BKG_5013.do?" + FormQueryString(formObj), "ESM_BKG_5013", 1042, 730);
		break;
	
	case IBSEARCH_ASYNC02: // Container 
		if (!validateForm(sheetObj, formObj, IBSEARCH))
			return false;
		formObj.f_cmd.value = '';
		formObj.pagerows.value = '';
		ComOpenWindowCenter("ESM_BKG_0037.do?bl_no=" + formObj.bl_no.value + "&trnk_bdr_flg=" + trnkBdrFlg, "ESM_BKG_0037", 617,
				404, true);
		break;
	
	case IBSEARCH_ASYNC03: // C/M
		if (!validateForm(sheetObj, formObj, IBSEARCH))
			return false;
		formObj.f_cmd.value = '';
		formObj.pagerows.value = '';
		ComOpenWindowCenter("ESM_BKG_0036.do?" + FormQueryString(formObj), "ESM_BKG_0036", 836, 530);
		break;
	
	case IBSEARCH_ASYNC04: // B/L Charge 
		if (!validateForm(sheetObj, formObj, IBSEARCH))
			return false;
		formObj.f_cmd.value = '';
		formObj.pagerows.value = '';
//		alert(formObj.bkg_no.value);
//		comBkgCallPopBkgCharge(formObj.bkg_no.value);
		
		var param = "pgmNo=ESM_BKG_0079&openTab=B9&bkg_no=" + formObj.bkg_no.value;
		
//		201004.10 모달작업
		ComOpenWindowCenter("ESM_BKG_0079.do?" + param, "ESM_BKG_0079", 1024, 650,true);
		break;
	
	case IBSEARCH_ASYNC05: // View Receive File 
		formObj.f_cmd.value = '';
		formObj.pagerows.value = '';
		var params = document.getElementById("t3frame").contentWindow.getSaveString();
		if (params == "")
			return false;
		ComOpenWindowCenter("ESM_BKG_0429.do?" + params, "ESM_BKG_0429", 500, 540);
		break;
	
	case IBSEARCH_ASYNC06: // Transmit AI
		formObj.f_cmd.value = MODIFY11;
		ComOpenWait(true);
		var params = FormQueryString(formObj) + "&pol=" + formObj.pol_cd.value + "&pod=" + formObj.pod_cd.value
				+ "&transmit_cd=AI"
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0034GS.do", params);
		ComOpenWait(false);
		
		sheetObj.LoadSaveXml(sXml);
		ComShowCodeMessage('BKG95117'); // Please check the transmission information sent in 1-2 minutes.		
		break;
	
	case IBSEARCH_ASYNC07: // Transmit PTT
		if (ComShowCodeConfirm('BKG01023', 'PTT', 'US Customs')) {
			formObj.f_cmd.value = MODIFY11;
			ComOpenWait(true);
			var params = FormQueryString(formObj) + "&pol=" + formObj.pol_cd.value + "&pod=" + formObj.pod_cd.value
					+ "&transmit_cd=TI"
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0034GS.do", params);
			ComOpenWait(false);
			sheetObj.LoadSaveXml(sXml);
		}
		break;
	
	case IBSEARCH_ASYNC08: // Transmit ISF
		if (ComShowCodeConfirm('BKG01023', 'ISF', 'US Customs')) {
			formObj.f_cmd.value = MODIFY12;
			ComOpenWait(true);
			var params = FormQueryString(formObj) + "&pol=" + formObj.pol_cd.value + "&pod=" + formObj.pod_cd.value
					+ "&transmit_cd=AI"
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0034GS.do", params);
			ComOpenWait(false);
			if (ComBkgErrMessage(sheetObj, sXml)) {
				sheetObj.LoadSaveXml(sXml);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} 
		}
		break;
	
	case IBSEARCH_ASYNC09: // Customer Master 
		formObj.f_cmd.value = '';
		formObj.pagerows.value = '';
		ComOpenWindowCenter("ESM_BKG_0240.do?pgmNo=ESM_BKG_0240", "ESM_BKG_0240", 1024, 640);
		break;
		
		
	case MULTI03: // DIV

		var sParam = "";
		
		var sParamSheet = sheetObj.GetSaveString();

		if (sParamSheet != "") {
			sParam += "&" + sParamSheet;
		}
		
		formObj.f_cmd.value = MULTI03;
		sParam += "&" + FormQueryString(formObj);
		
//		alert("sParam : " + sParam);
		
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true,true);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0034_11GS.do", sParam)
		
		var key = ComGetEtcData(sXml, "KEY");
		intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
		
		break;

	}// end switch
}

/**
 * 시트 조회 후 처리 이벤트
 */
function t0sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
	ComOpenWait(false);
	
	var formObj = document.form;
	
	if (ErrMsg == "") {
		
		var f_cmd = document.form.f_cmd.value;
		
		if (f_cmd == SEARCH) {
			callSearchBlInfo(sheetObj);
			formObj.free_trd_zn_flg.Enable = false;
//			if (ofcCode == "Origin") {
//				formObj.free_trd_zn_flg.Enable = false;
//			}
		}
		
		if (f_cmd == SEARCH02 || f_cmd == SEARCH03) {
			if (ComShowCodeConfirm('BKG01023', 'AI', 'US Customs')) { // AI전송여부 확인
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
			}
		}
	}
}

/**
 * 시트 저장 후 처리 이벤트
 */
function t0sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
	if (ErrMsg == "") {
		var f_cmd = document.form.f_cmd.value;
		if (f_cmd == MULTI) {
			setUnEditable();
			ComShowCodeMessage('BKG00166'); // Data Saved Successfully
			
			if (tabObjects[0].SelectedIndex == 0) {
				if (ComShowCodeConfirm('BKG01023', 'AI', 'US Customs')) { // AI전송여부 확인
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
				} else {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
			} else {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			opener.document.form.vvd.focus();
		} else if (f_cmd == MODIFY11) {
			ComShowCodeMessage('BKG00101'); // EDI was transmitted successfully.
		}
	}
	
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "Customer", -1);
			InsertTab(cnt++, "Customer 2", -1);
			InsertTab(cnt++, "Customs Result", -1);
			InsertTab(cnt++, "Remark(s)", -1);
			InsertTab(cnt++, "History", -1);
			InsertTab(cnt++, "H.B/L List", -1);
			InsertTab(cnt++, "Multi B/L List", -1);
		}
		break;
	}
}

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, tabIndex) {
	if (beforetab != tabIndex) {
		var objs = document.all.item("tabLayer");
		
		objs[tabIndex].style.display = "inline";
		objs[beforetab].style.display = "none";
	}
	beforetab = tabIndex;
	if (document.form.open_tab.value == "") {
		loadTabPage(tabIndex);
	} else {
		if (!open_flg) {
			loadTabPage(tabIndex);
		}
	}
	open_flg = false;
}

/**
 * 선택한 탭의 요소가 활성화 된다.
 */
function loadTabPage(tabIndex) {
	var formObj = document.form;
	var strBlNo = formObj.bl_no.value;
	var strDiffRmk = formObj.diff_rmk.value;
	var strVvd = formObj.vvd.value;
	
	var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
	if (objTabWindow.location.href == "about:blank" || objTabWindow.location.href == "") {
		objTabWindow.location.href = "ESM_BKG_0034_0" + (tabIndex + 1) + ".do";
	}
	
	if (objTabWindow.document.readyState == "complete") {
		if (tabIndex == 3) {
			objTabWindow.tabLoadSheet(strBlNo, strDiffRmk);
		} else if (tabIndex == 5) {
			objTabWindow.tabLoadSheet(strBlNo, strVvd);
		} else {
			objTabWindow.tabLoadSheet(strBlNo);
		}
		
		// 최초 조회 후 다른 탭 선택시 리셋되는 경우가 있어 다시 설정
		var tabObj = tabObjects[0];
		// H.B/L 이 있으면 탭 활성
		if (formObj.hbl_cnt.value != "0") {
			tabObj.TabEnable(5) = true;
		}
		if (formObj.bl_cnt.value != "0") {
			tabObj.TabEnable(6) = true;
		}
		
		if (tabIndex != 2) {
			ComBtnDisable("btn_view");
		} else {
			ComBtnEnable("btn_view");
		}
	}
}

/**
 * 모든 탭의 데이터를 초기화 한다.
 */
function clearAllTabPages() {
	for ( var i = 0; i < tabObjects[0].GetCount(); i++) {
		objTabWin = document.getElementById("t" + (i + 1) + "frame").contentWindow;
		if (objTabWin.location.href != "about:blank") {
			if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
				document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
			}
		}
	}
}

/**
 * 모든 탭을 활성화 처리 한다.
 */
function enableAllTabPages(flag) {
	if (flag == null || flag == "") {
		if (document.form.bl_no.value != "") {
			flag = true;
		} else {
			flag = false;
		}
	}
	
	for ( var i = 0; i < tabObjects[0].GetCount(); i++) {
		objTabWin = document.getElementById("t" + (i + 1) + "frame").contentWindow;
		if (objTabWin.location.href != "about:blank") {
			if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
				document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
			}
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	switch (sAction) {
	case IBSEARCH: // 조회
		// 기본포멧체크
		if (!ComChkObjValid(formObj.bl_nos))
			return false;
		
		var blNos = formObj.bl_nos.value;
		if (blNos.length > 12) {
			formObj.bl_no.value = blNos.substr(0, 12);
		} else {
			formObj.bl_no.value = blNos;
		}
		return true;
		break;
	
	case IBSAVE: // 저장
		if (!ComChkValid(formObj))
			return false;
		return true;
		break;
	}
}

/**
 * 조회된 내용이 없을 경우 입력 폼 초기화
 */
function initInputData() {
	var frmChild = document.getElementsByTagName("input");
	
	for ( var i = 0; i < frmChild.length; i++) {
		if (frmChild[i].type == "text" && frmChild[i].name != "bl_nos") {
			frmChild[i].value = "";
		}
		if (frmChild[i].type == "checkbox") {
			frmChild[i].checked = false;
		}
	}
	comboObjects[0].Code2 = -1;
	comboObjects[1].Code2 = -1;
	document.getElementById("mf_sts_cd").innerHTML = "";
	document.getElementById("cgor_team_cd").innerHTML = "";
}

/**
 * Edit 버튼 클릭 시 활성화 처리
 */
function setEditable() {
	var formObj = document.form;
	var entryTypeChangeYn ="N";
	
	if (formObj.bl_vvd.value == "1") {
		formObj.vvd.className = "input";
		formObj.vvd.readOnly = false;
		entryTypeChangeYn ="Y";
	}
	if (formObj.bl_pod.value == "1") {
		formObj.pod_cd.className = "input";
		formObj.pod_cd.readOnly = false;
		entryTypeChangeYn ="Y";
	}
	if (formObj.bl_del.value == "1") {
		formObj.del_cd.className = "input";
		formObj.del_cd.readOnly = false;
		entryTypeChangeYn ="Y";
	}
	if (formObj.bl_hub.value == "1") {
		formObj.hub_loc_cd.className = "input";
		formObj.hub_loc_cd.readOnly = false;
		formObj.ibd_tp_cd.className = "input";
		formObj.ibd_tp_cd.readOnly = false;
		entryTypeChangeYn ="Y";
	}
	if (formObj.bl_cstms.value == "1") {
		formObj.cstms_loc_cd.className = "input";
		formObj.cstms_loc_cd.readOnly = false;
		entryTypeChangeYn ="Y";
	}
	if (formObj.bl_fpo.value == "1") {
		formObj.f_pod.className = "input";
		formObj.f_pod.readOnly = false;
		entryTypeChangeYn ="Y";
	}
	if (formObj.bl_mib.value == "1") {
		formObj.ibd_trsp_no.className = "input";
		formObj.ibd_trsp_no.readOnly = false;
		entryTypeChangeYn ="Y";
	}
	if (formObj.bl_ftz.value == "1") {
		formObj.free_trd_zn_flg.Enable = true;
		entryTypeChangeYn ="Y";
	}
	
	// 권한이 하나라도 있으면 Entry Type을 수정할 수 있도록 수정 ( 2017.05.30 박해진 과장님 요청)
	if (entryTypeChangeYn == "Y") {
		formObj.combo_t_cd.Enable = true;
	}
}

/**
 * Save 처리 후 비활성화 처리
 */
function setUnEditable() {
	var formObj = document.form;
	if (formObj.bl_vvd.value == "1") {
		formObj.vvd.className = "input2";
		formObj.vvd.readOnly = true;
	}
	if (formObj.bl_pod.value == "1") {
		formObj.pod_cd.className = "input2";
		formObj.pod_cd.readOnly = true;
	}
	if (formObj.bl_del.value == "1") {
		formObj.del_cd.className = "input2";
		formObj.del_cd.readOnly = true;
	}
	if (formObj.bl_hub.value == "1") {
		formObj.hub_loc_cd.className = "input2";
		formObj.hub_loc_cd.readOnly = true;
		formObj.ibd_tp_cd.className = "input2";
		formObj.ibd_tp_cd.readOnly = true;
	}
	if (formObj.bl_cstms.value == "1") {
		formObj.cstms_loc_cd.className = "input2";
		formObj.cstms_loc_cd.readOnly = true;
	}
	if (formObj.bl_fpo.value == "1") {
		formObj.f_pod.className = "input2";
		formObj.f_pod.readOnly = true;
	}
	if (formObj.bl_mib.value == "1") {
		formObj.ibd_trsp_no.className = "input2";
		formObj.ibd_trsp_no.readOnly = true;
	}
	if (formObj.bl_ftz.value == "1") {
		formObj.free_trd_zn_flg.Enable = false;
	}
	formObj.combo_t_cd.Enable = false;
}

/**
 * 버튼 활성화 처리
 */
function setButton() {
	
	if (ofcCode == "Origin" && trnkBdrFlg == "Y") {
		ComBtnDisable("btn_edit");
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_reactivate");
		ComBtnDisable("btn_transmit");
		ComBtnDisable("btn_trans_ptt");
		ComBtnDisable("btn_trans_isf");
	} else {
		ComBtnEnable("btn_edit");
		ComBtnEnable("btn_save");
		if (sheetObjects[0].CellValue(1,"mf_sts_cd") == 'A') {
			ComBtnEnable("btn_del");
			ComBtnDisable("btn_reactivate");
		} else {
			ComBtnDisable("btn_del");
			ComBtnEnable("btn_reactivate");
		}
		ComBtnEnable("btn_transmit");
		if (document.form.bl_ptt.value == "1") {
			ComBtnEnable("btn_trans_ptt");
		}
		// Transmit ISF 버튼은 M.B/L 이고, Filer 가 '01' 인 경우 비활성, 그 외는 활성
		if (document.form.mbl_no.value == "" && document.form.cstms_file_tp_cd.value == "01") {
			ComBtnDisable("btn_trans_isf");
		} else {
			ComBtnEnable("btn_trans_isf");
		}
	}
	
	// div_ind 값이 DIV 이며 해당 권한을 가지고 있는 user 에게만 DIV 버튼 활성화
	if(document.form.div_ind.value == "DIV" && document.form.bl_div.value == "1"){
		ComBtnEnable("btn_div");
	}else{
		ComBtnDisable("btn_div");
	}
}

/**
 * 문자열을 포멧에 맞게 변경하여 리턴한다
 */
function AddComma(obj, sFormat) {
	try {
		var sVal = obj.value.replace(/\,/g, "");
		switch (sFormat) {
		case "#,###":
			obj.value = ComAddComma(sVal);
			break;
		case "#,###.###":
			if (sVal == ".")
				sVal = "0.";
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if (p.length <= 1)
				obj.value = p[0];
			else if (p.length == 2)
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
 * RD 오픈  및  출력
 */
function rdOpen(rdObject) {
	
	loadTabPage(2); // Customs Result Tab 로드
	
	var formObject = document.form;
	
	var blNo = formObject.bl_no.value;
	var pMib = formObject.ibd_trsp_no.value;
	var type = formObject.ibd_tp_cd.value;
	var vvd = formObject.vvd.value + "(" + formObject.vsl_eng_nm.value + ")";
	var pod = formObject.pod_cd.value;
	var eta = formObject.vps_eta_dt2.value;
	var pol = formObject.pol_cd.value;
	var del = formObject.del_cd.value;
	var hub = formObject.hub_loc_cd.value;
	var usa = formObject.usa_lst_loc_cd.value;
	var qty = formObject.pck_qty.value + " " + formObject.ams_pck_tp_cd.value;
	var wgt = formObject.cgo_wgt.value + " " + formObject.wgt_ut_cd.value;
	var f = formObject.frt_clt_flg.value;
	var o = formObject.obl_rdem_flg.value;
	var c = formObject.cstms_clr_cd.value;
	
	var shpr_nm = document.getElementById("t1frame").contentWindow.getFormString("shpr_cust_nm");
	var shpr_addr = document.getElementById("t1frame").contentWindow.getFormString("shpr_cust_addr");
	var cnee_nm = document.getElementById("t1frame").contentWindow.getFormString("cnee_cust_nm");
	var cnee_addr = document.getElementById("t1frame").contentWindow.getFormString("cnee_cust_addr");
	var ntfy_nm = document.getElementById("t1frame").contentWindow.getFormString("ntfy_cust_nm");
	var ntfy_addr = document.getElementById("t1frame").contentWindow.getFormString("ntfy_cust_addr");
	
	var antf_nm = document.getElementById("t2frame").contentWindow.getFormString("antf_cust_nm");
	var antf_addr = document.getElementById("t2frame").contentWindow.getFormString("antf_cust_addr");
	
	var param = "/rp [" + blNo + "][" + pMib + "][" + type + "][" + vvd + "][" + pod + "][" + eta + "][" + pol + "][" + del
			+ "][" + hub + "][" + usa + "][" + qty + "][" + wgt + "][" + f + "][" + o + "][" + c + "][" + shpr_nm + "]["
			+ shpr_addr + "][" + cnee_nm + "][" + cnee_addr + "][" + ntfy_nm + "][" + ntfy_addr + "][" + antf_nm + "]["
			+ antf_addr + "]";
	
	var rdParam = param + " /riprnmargin /rwait";
	var strPath = RD_path + "apps/alps/esm/bkg/customsdeclaration/manifestlistdownload/report/ESM_BKG_5013.mrd";
	
	var Rdviewer = rdObject;
	Rdviewer.FileOpen(strPath, RDServer + rdParam);
	if (strCntCd == "US") {
		Rdviewer.SetPrint2(4, 1, 1, 100);
	}
	Rdviewer.PrintDialog();
}

/**
 * RD 출력
 * @param rdObject
 * @return
 */
function rdPrint(rdObject) {
	var Rdviewer = rdObject;
	Rdviewer.PrintDialog();
}


/**
* BackEndJob 실행결과조회.
*/
function doActionValidationResult(sheetObj, sKey) {

	var sXml = sheetObj.GetSearchXml("ESM_BKG_0034_11GS.do?f_cmd=" + SEARCH03
			+ "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	
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
		doActionIBSheet(sheetObj, document.form, IBSEARCH);	
		return;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
	}
}

/* 개발자 작업  끝 */