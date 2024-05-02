/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0041.js
 *@FileTitle : AMS Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.28  
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.08.24 김도완
 * 1.0 Creation
 * -----------------------------------------------------
 * History
 * 2011.07.06 민정호 [CHM-201111863] US AMS Report - BAPLIE 탭 보완
 * 2011.07.06 민정호 [CHM-201111866] US AMS : AMS Report 의 general의 조회 기능 보완
 * 2011.09.28 민정호 [CHM-201113378] AMS Report에 조회 옵션 추가
 * 2011.10.13 김봉균 [CHM-201112452-01] 미세관 RECEIVE 데이터 중 CUSRES 반영 요청
 * 2011.11.15 민정호 [CHM-201114280] AMS Report 조회 기능 변경
 * 2012.04.09 김봉균 [CHM-201216602-01] Rail AMS 수신시 hold / hold release 관련 보완 (ACE 관련)
 * 2013.02.26 김보배 [CHM-201323166] [BKG] AMS Report 보완 요청
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
 * @class ESM_BKG-0041 : ESM_BKG-0041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0041() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var changetab = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

/** ********************* EDTITABLE MULIT COMBO START ******************* */
var comboCnt = 0;
var comboObjects = new Array();
var rcv_term_cdMultiComboDataAdded = false;
var de_term_cdMultiComboDataAdded = false;
var customs_result_codeXml = null;
var resultXmlFor1 = null;
var resultXmlFor2 = null;

// 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
// ComComboObject생성자 메소드에서 호출됨
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */
function initCombo(comboObj, comboId) {
	var formObject = document.form
	comboObj.DropHeight = 135;
	comboObj.MultiSelect = false;
	comboObj.UseEdit = false;
	if (comboId == "filer") {
		comboObj.DropHeight = 180;
		comboObj.MultiSelect = true;		
	} else if (comboId == "customs_result_code") {
		comboObj.DropHeight = 235;
		comboObj.UseEdit = true;
	} else if (comboId == "eq_ofc"){
		comboObj.DropHeight = 300;
		comboObj.MultiSelect = true;		
	}
	initComboEditable(comboObj)
}

function initComboEditable(combo) {
	with (combo) {
		UseAutoComplete = true; // 편집시 자동 코드 검색
	}
}

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		document.form.search_discrepancy.value = "N";
		switch (srcName) {
		case "btn_Retrieve":			
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;
		case "btn_BLInquiry":
			doActionIBSheet(sheetObject1, document.form, SEARCH11);
			break;
		case "btn_InquiryByCntr":
			doActionIBSheet(sheetObject1, document.form, SEARCH12);
			break;
		case "btn_BlCharge":
			doActionIBSheet(sheetObject1, document.form, SEARCH13);
			break;
		case "btn_RailAmsHistory":
			doActionIBSheet(sheetObject1, document.form, SEARCH14);
			break;
		case "btn_Downexcel":
			doActionIBSheet(sheetObject1, document.form, IBDOWNEXCEL);
			break;
		case "btn_Print":
			doActionIBSheet(sheetObject1, document.form, SEARCH15);
			break;
		case "btn_2q4q":
			doActionIBSheet(sheetObject1, document.form, SEARCH07);
			break;			
		case "btn_2o4o":
			doActionIBSheet(sheetObject1, document.form, SEARCH16);
			break;
		case "btn_2r4r":
			doActionIBSheet(sheetObject1, document.form, SEARCH08);
			break;
			
		case "btn_2z":
			doActionIBSheet(sheetObject1, document.form, SEARCH04);
			break;
		case "btn_6h6i":
			doActionIBSheet(sheetObject1, document.form, SEARCH05);
			break;
		case "btn_non3Z":
			doActionIBSheet(sheetObject1, document.form, SEARCH06);
			break;
		case "btn_discrepancy":
			document.form.search_discrepancy.value = "Y";
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;
		case "btn_calendar":
			if (formObject.fromd.disabled)
				return;
			var cal = new ComCalendarFromTo();
			cal.select(formObject.fromd, formObject.tod, 'yyyy-MM-dd');
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
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
		sheetObjects[i].WaitImageVisible = false;
	}
	
	for ( var k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
    }
	//MultiCombo초기화 
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], comboObjects[k].id);
	}
	initControl();
	// 멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
	setTimeout( function() {
		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	}, 100);
	if (document.form.mbl_no.value != "") {
		tabObjects[0].SelectedIndex = 1;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
 	//BAPLIE(ESM_BKG_1023)화면에서 Go to AMS Report 버튼 클릭으로 Load 될 경우
	if (document.form.event_from.value == "fromBapLieScreen") {
		tabObjects[0].SelectedIndex = 3;
		var formObject = document.form;
		//Parameter 로 넘어온 값을 Form 에 입력
		formObject.vvd.value = formObject.hid_vvd.value;
		formObject.last_pol.value = formObject.hid_last_pol.value;
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	}	
	
	var selTab = document.tab1.SelectedIndex;
	sheetObjects[selTab].WaitImageVisible = true;
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd))
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);	

}

 /**
  * 조회조건 입력할 때 처리
  */
 function obj_KeyUp() {
 	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	var formObject = document.form;
 	var srcName = window.event.srcElement.getAttribute("name");
 	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
 	var srcValue = window.event.srcElement.getAttribute("value");
 	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
 		ComSetNextFocus();
 	}
 }

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. 
 */
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObject = document.form;
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); // - 키보드 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListener('click', 'chkClick2', 'form');
	axon_event.addListenerForm('change', 'chkChange2', formObject);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
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
			style.height = 320;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 16, 1000);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "Seq.|Code|M.B/L No.|Manifest File No.|Filer|C.STS|Stage|VVD|POL|POD|DEL|HUB|Entry Type|Cgo Dest Type|CNTR No.|TP/SZ|F|O|C|P|Consignee/Notify|P/MIB No.|TP|FTZ|P/MIB Issue Date|P/MIB Accepted Date|Arrival Date|Arrival Accepted Date|Export Date|Export Accepted Date|R|D|Customs Reply Date|S/C|TAA NO|T.POL ETD|T.POD ETA|SCAC Qty Check||||";
			var headCount = ComCountHeadTitle(HeadTitle) + 1;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 4, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 30, daCenterTop, true, "seq");
			InitDataProperty(0, cnt++, dtData, 40, daCenterTop, true, "dspo_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenterTop, true, "mbl_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenterTop, true, "ams_file_no", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "filer", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "mf_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "cstms_mf_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vvd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pol_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "del_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "hub_loc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cstms_clr_tp_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "cgo_dest_type_nm", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cntr_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "frt_clt_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "obl_rdem_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cstms_clr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_prt_flg", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "cust_nm", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "ibd_trsp_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "ibd_trsp_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "free_trd_zn_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "ibd_trsp_iss_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "ibd_trsp_acpt_dt", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "ibd_trsp_arr_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "ibd_trsp_arr_acpt_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "ibd_trsp_xpt_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "ibd_trsp_xpt_acpt_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "rcv_term_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "de_term_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "arr_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "sc_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "taa_no", false, "", dfNone, 0, true, true);			
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "t_pol_etd", false, "", dfNone, 0, true, true);			
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "t_pod_eta", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 90, daCenterTop, true, "chk_qty", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cstms_dspo_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");

			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bkg_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "vvd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bl_cnt", false, "", dfNone, 0, true, true);

			CountPosition = 0;
//			CountFormat = "[SELECTDATAROW / TOTALROWS]";
		}
		break;
	case 2: //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 320;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 16, 1000);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//var HeadTitle = "Seq.|Code|M.B/L No.|CNTR No.|TP/SZ|Rail AMS File No.|VVD|POL|POD|DEL|HUB|F|O|C|Consignee/Notify|FTZ|P/MIB No.|P/MIB Accepted Date|Arrival Date|Pick-Up No.|Pick-Up No.\nReleased|Pick-Up No.\nRelease Date|R|D|Customs Reply Date|S/C||||";
			var HeadTitle = "Seq.|C-\nflag|Code|M.B/L No.|Releas\ne EDI|Master|TP/SZ|Sum\nCM\nQ'ty|VVD|POL|POD|DEL|HUB|CNTR No.|Rail AMS File No.|Rail\nQ'ty|Rlse\nQ'ty|R.Billing|FEU|TEU|F|O|C|Consignee/Notify|FTZ|P/MIB No.|P/MIB Accepted Date|Arrival Date|Pick-Up No.|Pick-Up No.\nReleased|Pick-Up No.\nRelease Date|R|D|Customs Reply Date|S/C||||";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 4, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "c_flag", false, "", dfNone, 0, true, true);//
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dspo_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "ams_file_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlse_edi", false, "", dfNone, 0, true, true);//
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "master", false, "", dfNone, 0, true, true);//
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "sum_cm_qty", false, "", dfNone, 0, true, true);//
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vvd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pol_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "del_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "hub_loc_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cntr_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "rail_crr_ref_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "r_qty", false, "", dfNone, 0, true, true);//
			InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "rlse_qty", false, "", dfNone, 0, true, true);//
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "r_billing", false, "", dfNone, 0, true, true);//
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "feu", false, "", dfNone, 0, true, true);//
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "teu", false, "", dfNone, 0, true, true);//
			
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "frt_clt_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "obl_rdem_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cstms_clr_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "cust_nm", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "free_trd_zn_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "usa_ib_trsp_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "ibd_trsp_acpt_dt", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "ibd_trsp_arr_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 130, daCenter, false, "pkup_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "pkup_released", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "pkup_date", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "rcv_term_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "de_term_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "arr_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sc_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cstms_dspo_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");

			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bkg_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "vvd", false, "", dfNone, 0, true, true);
			// MassOfSearch=1;
			CountPosition = 2;
			CountFormat = "[SELECTDATAROW / TOTALROWS]";
			
			//InitTreeInfo("cntr_no", "slevel", RgbColor(0, 0, 255), true);
		}
		break;

	case 3: //sheet3 for excelDownLoad the sheet1.
		with (sheetObj) {

			// 높이 설정
			style.height = 270;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 1000);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "Seq.|M.B/L No.|Manifest File No.|Filer|M/H|VVD|POL|POD|Action\nType|Customs Result|Description|Send Date|Receive Date|Consignee/Notify";
			var headCount = ComCountHeadTitle(HeadTitle) + 2;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 3, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
			// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "mbl_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "ams_file_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "filer", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "mh", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "vvd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pol_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "pod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "isf_act_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "isf_rslt_desc", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "isf_rmk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "snd_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_dt", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "cust_nm", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "isf_rslt_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "bkg_no");
			CountPosition = 2;
		}
		break;
		
	case 4: // sheet4 baplie
		with (sheetObj) {
			// 높이 설정
			style.height = 320;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 4, 100);

			var HeadTitle1 = "|Seq.|Container No.|Container\nOperator|L.POL|POL|POD|TP/SZ|Full/Empty|Cargo Type|Stow\nPosition|IMO Class"
					+ "|UN No.|Original\nPOD|Customs Result|Customs Response|Description|Sent Time|Receiving Date|vsl_eng_nm|vsl_voy|crr_cd|tmp1|tmp2|search_vvd_cd|excludeca";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "opr_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "l_pol", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pol", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "pod", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sztp", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "fmInd", false, "", dfNone, 0, false, false);						
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, "fe", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "sti_pos", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "imdg", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "unno", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "o_pod", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cust_result", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "cust_rspn", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "description", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "sent_time", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "receive_date", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "vsl_eng_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "vsl_voy", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "crr_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "tmp1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "tmp2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "search_vvd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, false, "excludeca", false, "", dfNone, 0, false, false);

			WaitImageVisible = false;
		}
	break;
		
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	sheetObj.ShowDebugMsg = false;
	var targetSheet = null;
	switch (sAction) {
	case IBCLEAR: // 화면 로딩시 코드 조회
		formObj.f_cmd.value = COMMAND01;
	
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0041GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], formObj.rhq, "val", "name");
	
		formObj.rhq.index = -1;	
		break;
	case IBSEARCH: //조회
		var selTab = document.tab1.SelectedIndex;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		
		
		formObj.f_cmd.value = SEARCH;
		//ComOpenWait(true);
		
		sheetObjects[selTab].WaitImageVisible = true;
		var para = "&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
			resultXmlFor1 = null;
		} else if (selTab == 1) {
			para += "RAILAMS";
			resultXmlFor2 = null;
		} else if (selTab == 2) {
			para += "ISF5";
	
		} else if (selTab == 3) {
			para += "BAPLIE";
		}
		targetSheet = sheetObjects[selTab];
		var sXml = targetSheet.GetSearchXml("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=" + para);
		targetSheet.LoadSearchXml(sXml);
		if (selTab == 2) {
		
			formObj.manifest.value = ComGetEtcData(sXml, "manifest");
			formObj.accepted.value = ComGetEtcData(sXml, "accepted");
			formObj.rejected.value = ComGetEtcData(sXml, "rejected");
			formObj.none.value = ComGetEtcData(sXml, "none");
			formObj.target.value = ComGetEtcData(sXml, "target");
			formObj.unmanifest.value = ComGetEtcData(sXml, "unmanifest");
		}
		ComOpenWait(false);
		
		break;

	case IBSEARCHAPPEND: // 페이징 조회
		if (!validateForm(sheetObj, formObj, IBSEARCH))
			return false;
		formObj.f_cmd.value = SEARCH;

		if (formObj.retrieve_remains.value != "") {
			CondParam = CondParam + "&tmp4=" + formObj.retrieve_remains.value
		}

		if (formObj.retrieve_remains_for_report.value != "") {
			CondParam = CondParam + "&tmp4=" + formObj.retrieve_remains_for_report.value
		}
		sheetObj.DoSearch("ESM_BKG_0041GS.do", CondParam, "page_no=" + PageNo + 
				"&last_rnum=" + sheetObj.CellValue(sheetObj.LastRow, "seq") +
				"&last_bl=" + sheetObj.CellValue(sheetObj.LastRow, "ams_file_no"), true);

		// 만약 Print로 인한 페이징 추가조회였다면 retrieve_remains_for_report를 전체RowCount에서 초기화해야 한다.
		// retrieve_remains는 엑셀다운로드 클릭시 셋업된다.
		if (formObj.retrieve_remains_for_report.value != "") {
			formObj.retrieve_remains_for_report.value = "";

			var targetDo = "ESM_BKG_0867.do";
			if (document.tab1.SelectedIndex == 1) {
				targetDo = "ESM_BKG_5027.do";
			}
			ComOpenWindowCenter("/hanjin/" + targetDo, "0867" + document.tab1.SelectedIndex, 1024, 720, false);
		}
		break;

	case SEARCH03: //Open시 콤보박스 데이터를 조회.

		formObj.f_cmd.value = SEARCH03;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0041GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");

		/* R/D R- OUTBOUND RECEIVED */
		/* R/D D- INBOUND DELIVERY */
		/* CUSTOMS RESULT CODE */
		customs_result_codeXml = arrXml[0];
		ComXml2ComboItem(arrXml[1], formObj.rcv_term_cd, "val", "val|desc");
		ComXml2ComboItem(arrXml[2], formObj.de_term_cd, "val", "val|desc");
		ComXml2ComboItem(arrXml[3], formObj.filer, "val", "val|desc");
		ComXml2ComboItem(arrXml[4], formObj.customs_result_code_grp, "val", "val|desc");
		ComXml2ComboItem(arrXml[5], formObj.eq_ofc, "eq_ctrl_ofc_cd", "eq_ctrl_ofc_cd");
				
		formObj.filer.DeleteItem("99");
		formObj.filer.DeleteItem("");
		formObj.filer.InsertItem(0, "All|All", "All");

//		쿼리에서 가져옴.		
//		formObj.eq_ofc.InsertItem(0, "All", "All");
		
		formObj.vvd.focus();
		break;

	case IBDOWNEXCEL: // 엑셀다운로드

		if (!validateForm(sheetObj, formObj, sAction))
			return;
		
		var selTab = document.tab1.SelectedIndex;
		
//		ComOpenWait(true, true);
		
		var totalRowBigger = "";
		if (sheetObjects[selTab].RowCount > 0) {
			// 페이징 처리된 소스이므로, 엑셀 다운로드시 전체 조회가 되지 않았다면, 조회를 끝까지 실행한 후 
			// 엑셀 다운을 실행해야 한다.
			// 따라서, form에 retrieve_remains 객체를 선언하고, TotalRowCount를 지정한뒤 추가 조회를 실행하고,
			// 추가조회하는 위치에서 엑셀 다운로드를 실행한다.
			// retrieve_remains 객체값은 추가조회시 tmp4의 변수로 SC에 전달한다.
			// tmp4를 이용해서 전체조회하는 로직은 UsaCustomsReportDBDAO 단에 정의되어 있다.
			if (sheetObjects[selTab].RowCount < sheetObjects[selTab].TotalRows) {
				formObj.retrieve_remains.value = sheetObjects[selTab].TotalRows;
				totalRowBigger = sheetObjects[selTab].TotalRows;
				sheetObjects[selTab].TopRow = sheetObjects[selTab].RowCount;
			}
			sheetObjects[selTab].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
		}
//		ComOpenWait(false);
		break;

	case SEARCH04: // 2Z
		var selTab = document.tab1.SelectedIndex;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
//		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var para = "&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet = sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=2Z" + para);
//		ComOpenWait(false);
		break;

	case SEARCH05: // 6H6I
		var selTab = document.tab1.SelectedIndex;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
//		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var para = "&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet = sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=6H6I" + para);
//		ComOpenWait(false);
		break;

	case SEARCH06: // Non-3Z
		var selTab = document.tab1.SelectedIndex;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
//		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var para = "&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet = sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=3Z" + para);
//		ComOpenWait(false);
		break;

	case SEARCH07: // 2Q4Q
		var selTab = document.tab1.SelectedIndex;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
//		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var para = "&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet = sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=2Q4Q" + para);
//		ComOpenWait(false);
		break;
		
	case SEARCH16: // 2O4O
		var selTab = document.tab1.SelectedIndex;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = SEARCH;
		var para = "&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet = sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=2O4O" + para);
		break;
		
	case SEARCH08: // 2R4R
		var selTab = document.tab1.SelectedIndex;
		if (!validateForm(sheetObj, formObj, sAction))
			return;
//		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var para = "&general_or_rail=";
		if (selTab == 0) {
			para += "GENERAL";
		} else if (selTab == 1) {
			para += "RAILAMS";
		}
		targetSheet = sheetObjects[selTab];
		targetSheet.DoSearch("ESM_BKG_0041GS.do", FormQueryString(formObj) + "&tmp3=2R4R" + para);
//		ComOpenWait(false);
		break;

	case SEARCH11: //B/L Inquiry
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab = document.tab1.SelectedIndex;
			var selRow = sheetObjects[selTab].SelectRow;
			var bl_no = sheetObjects[selTab].CellValue(selRow, "ams_file_no");
			var param = "bl_no=" + bl_no;
			if (formObj.office.value == "Origin") {
				param = param + "&pgmNo=ESM_BKG_0034-01"
			} else {
				param = param + "&pgmNo=ESM_BKG_0034-03"
			}
			ComOpenWindowCenter("/hanjin/ESM_BKG_0034.do?" + param, "ESM_BKG_0034", 1024, 660, true);
		}
		break;

	case SEARCH12: //btn_InquiryByCntr
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab = document.tab1.SelectedIndex;
			var selRow = sheetObjects[selTab].SelectRow;
			var cntr_no = sheetObjects[selTab].CellValue(selRow, "cntr_no");
			var param = "cntr_no=" + cntr_no;
			ComOpenWindowCenter("/hanjin/ESM_BKG_0518.do?pgmNo=ESM_BKG_0518&" + param, "ESM_BKG_0518", 1024, 560);
		}
		break;

	case SEARCH13: //btn_BlCharge
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab = document.tab1.SelectedIndex;
			var selRow = sheetObjects[selTab].SelectRow;
			var bl_no = sheetObjects[selTab].CellValue(selRow, "ams_file_no");
			var bkg_no = sheetObjects[selTab].CellValue(selRow, "bkg_no");
			var param = "pgmNo=ESM_BKG_0079&openTab=B9&bkg_no=" + bkg_no;
//			201004.10 모달작업
			ComOpenWindowCenter("ESM_BKG_0079.do?" + param, "ESM_BKG_0079", 1024, 650,true);
			
//			comBkgCallPopBkgCharge(sheetObj.CellValue(selRow, prefix+"bkg_no"));
//			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, prefix+"bkg_no"));

//			var param = "pgmNo=ESM_BKG_0079&openTab=B9&isPop=Y&bkg_no=" + bkg_no;
//			ComOpenWindowCenter("/hanjin/ESM_BKG_0079.do?" + param, "ESM_BKG_0079", 1024, 650, true);
		}
		break;
	case SEARCH14: //btn_RailAmsHistory
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab = document.tab1.SelectedIndex;
			var selRow = sheetObjects[selTab].SelectRow;
			var cntr_no = sheetObjects[selTab].CellValue(selRow, "cntr_no");
			var bl_no = sheetObjects[selTab].CellValue(selRow, "ams_file_no");
			var vvd = sheetObjects[selTab].CellValue(selRow, "vvd");
			var param = "cntr_no=" + cntr_no + "&vvd=" + vvd + "&bl_no=" + bl_no;
			ComOpenWindowCenter("/hanjin/ESM_BKG_1037.do?pgmNo=ESM_BKG_1037&" + param, "ESM_BKG_1037", 1024, 610);
		}
		break;

	case SEARCH15: //Print
		if (validateForm(sheetObj, formObj, sAction)) {
			var selTab = document.tab1.SelectedIndex;
			if (sheetObjects[selTab].RowCount < sheetObjects[selTab].TotalRows) {
				formObj.retrieve_remains_for_report.value = sheetObjects[selTab].TotalRows;
				sheetObjects[selTab].TopRow = sheetObjects[selTab].RowCount;
			} else {
				var targetDo = "ESM_BKG_0867.do";
				if (selTab == 1) {
					targetDo = "ESM_BKG_5027.do";
				}
				ComOpenWindowCenter("/hanjin/" + targetDo, "0867" + document.tab1.SelectedIndex, 1024, 690, false);
			}
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
	case SEARCH04:
	case SEARCH05:
	case SEARCH06:
	case SEARCH07:
	case SEARCH16:		
	case SEARCH08:
		if (!ComChkObjValid(formObj.mbl_no))
			return false;
		// mbl_no, ams_file_no 조건이 있으면 다른 조건은 무시한다.
		if (formObj.mbl_no.value == "" && formObj.ams_file_no.value == "") {
			if (formObj.date_search.checked) {
				if (formObj.fromd.value == "" || formObj.fromt.value == "" || formObj.tod.value == "" || formObj.tot.value == "") {
					ComShowCodeMessage("BKG00626", "Date & Time Fields");
					return false;
				}
				if (ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 30) {
					ComShowCodeMessage("BKG00462", "30 days");
					return false;
				}
			} else {
				if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
					ComShowCodeMessage("BKG00626", "VVD");
					return false;
				}
				// BAPLIE일 경우
				if(document.tab1.SelectedIndex == 3){
					if (formObj.last_pol.value == "") {
						ComShowCodeMessage("BKG00626", "Last Foreign POL");
						return false;
					}
				} else {
					if (formObj.pod.value == "" && formObj.pol.value == "") {
						ComShowCodeMessage("BKG00626", "POL OR POD");
						return false;
					}
				}
			}
		}
		break;
	case IBDOWNEXCEL:
		var selTab = document.tab1.SelectedIndex;
		if (sheetObjects[selTab].RowCount == 0) {
			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}
		break;
	case SEARCH11:
	case SEARCH12:
	case SEARCH13:
	case SEARCH14:
	case SEARCH15:
		var selTab = document.tab1.SelectedIndex;
		if (sheetObjects[selTab].RowCount == 0) {
			ComShowCodeMessage("BKG00889");
			return false;
		}
		break;
	}
	return true;
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
	with (tabObj) {
		var cnt = 0;
		InsertTab(cnt++, "General", -1);
		InsertTab(cnt++, "Rail AMS", -1);
		InsertTab(cnt++, "ISF-5", -1);
		InsertTab(cnt++, "BAPLIE", -1);
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 * @param tabObj
 * @param nItem
 * @return
 */
function tab1_OnChange(tabObj, nItem) {	     	
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	
	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	
	var selTab = document.tab1.SelectedIndex;
	sheetObjects[selTab].WaitImageVisible = true;
	
	if (document.tab1.SelectedIndex < 2) {
		// General/Rail AMS Tab
		// Delete condition : last foreign pol
		document.getElementById("lastPol").style.display = "none";
		if(document.tab1.SelectedIndex == 0){
			document.getElementById("general").style.display = "none";			
			document.getElementById("general_1").style.display = "inline";
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		}else{
			document.getElementById("general").style.display = "inline";			
			document.getElementById("general_1").style.display = "none";			
		}
		document.getElementById("general").style.left = "190";
		document.getElementById("general").style.top = "38";

		formObj = document.form;
		var rtn_type;
		if (formObj.mbl_no.value == "" && formObj.ams_file_no.value == "") {
			if (formObj.date_search.checked) {
				if (formObj.fromd.value == "" || formObj.fromt.value == "" || formObj.tod.value == "" || formObj.tot.value == "") {
					rtn_type = false;
				}
				if (ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 30) {
					rtn_type = false;
				}
			} else {
				if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
					rtn_type = false;
				}
				if (formObj.pod.value == "" && formObj.pol.value == "") {
					rtn_type = false;
				}
			}
		}
		
		if(rtn_type != false){
			//sheetObjects[0].WaitImageVisible = true;
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		for(var i=0; i<document.form.elements.length; i++)
		{
			if (document.form.elements[i].name == "hub1" 
//					|| document.form.elements[i].name == "eq_ofc"
					|| document.form.elements[i].name == "b_stf" 
					|| document.form.elements[i].name == "l_rep"
					|| document.form.elements[i].name == "pmib_tp" 
					|| document.form.elements[i].name == "mbl_no" 
					|| document.form.elements[i].name == "ams_file_no" )
			{
				document.form.elements[i].disabled = false;
				document.form.elements[i].className = "input";
			}
		}
		document.form.del1.disabled = false;
		document.form.eq_ofc.Enable = true;			//
		document.form.rcv_term_cd.Enable = true;
		document.form.de_term_cd.Enable = true;
		document.form.filer.Enable = true;
		document.form.customs_result_code_grp.Enable = true;
		document.form.customs_result_code.Enable = true;
		
		document.form.cust_arr_exp[1].checked = true;
		
		document.form.cust_arr_exp[0].disabled = true;
		document.form.cust_arr_exp[1].disabled = false;
		document.form.cust_arr_exp[2].disabled = false;
		document.form.cust_arr_exp[3].disabled = false;
		
		document.form.excl_rls.disabled = false;
		document.form.cntr_prt_flg.disabled = false;
		document.form.final_flg.disabled = false;
		
		document.form.pol1.className = "input1";
		document.form.pod1.className = "input1";
		document.form.del1.className = "input1";
		
		ComBtnEnable('btn_Print');
		ComBtnEnable('btn_InquiryByCntr');
		ComBtnEnable('btn_2q4q');
		ComBtnEnable('btn_2r4r');
		ComBtnEnable('btn_2z');
		ComBtnEnable('btn_6h6i');
		ComBtnEnable('btn_non3Z');
		ComBtnEnable('btn_RailAmsHistory');
		if (document.tab1.SelectedIndex == 0) {
			document.form.cust_arr_exp[3].disabled = false;
		} else {
			document.form.cust_arr_exp[3].disabled = true;
		}
		
	} else if (document.tab1.SelectedIndex == 2){
		// ISF-5 Tab
		// Delete condition : last foreign pol
		document.getElementById("lastPol").style.display = "none";
		document.getElementById("general").style.display = "inline";		
		document.getElementById("general_1").style.display = "none";
		document.getElementById("general").style.left = "190";
		document.getElementById("general").style.top = "38";

		formObj = document.form;
		var rtn_type;
		if (formObj.mbl_no.value == "" && formObj.ams_file_no.value == "") {
			if (formObj.date_search.checked) {
				if (formObj.fromd.value == "" || formObj.fromt.value == "" || formObj.tod.value == "" || formObj.tot.value == "") {
					rtn_type = false;
				}
				if (ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 30) {
					rtn_type = false;
				}
			} else {
				if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
					rtn_type = false;
				}
				if (formObj.pod.value == "" && formObj.pol.value == "") {
					rtn_type = false;
				}
			}
		}
		
		if(rtn_type != false){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
		}	
		
		for(var i=0; i<document.form.elements.length; i++)
		{
			
			if (document.form.elements[i].name == "hub1" 
//				|| document.form.elements[i].name == "eq_ofc"
				|| document.form.elements[i].name == "b_stf" 
				|| document.form.elements[i].name == "l_rep"
				|| document.form.elements[i].name == "pmib_tp")
			{
				document.form.elements[i].disabled = true;
				document.form.elements[i].className = "input2";
			}
		}
		document.form.del1.disabled = false;
		document.form.eq_ofc.Enable = false;			//
		document.form.rcv_term_cd.Enable = false;
		document.form.de_term_cd.Enable = false;
		document.form.filer.Enable = false;
		document.form.customs_result_code_grp.Enable = false;
		document.form.customs_result_code.Enable = false;
		
		document.form.mbl_no.disabled = false;
		document.form.ams_file_no.disabled = false;
		document.form.excl_rls.disabled = false;
		document.form.cntr_prt_flg.disabled = false;
		document.form.final_flg.disabled = true;
		
		document.form.cust_arr_exp[0].checked = true;
		document.form.cust_arr_exp[0].disabled = false;
//		document.form.cust_arr_exp[1].disabled = false;
		document.form.cust_arr_exp[2].disabled = true;
		document.form.cust_arr_exp[3].disabled = true;

		document.form.mbl_no.className = "input";
		document.form.ams_file_no.className = "input";
		document.form.pol1.className = "input1";
		document.form.pod1.className = "input1";
		document.form.del1.className = "input1";
		
		ComBtnDisable('btn_Print');
		ComBtnDisable('btn_InquiryByCntr');
		ComBtnDisable('btn_2q4q');
		ComBtnDisable('btn_2r4r');
		ComBtnDisable('btn_2z');
		ComBtnDisable('btn_6h6i');
		ComBtnDisable('btn_non3Z');
		ComBtnDisable('btn_RailAmsHistory');
	} else {
		// BAPLIE
		// Add condition : last foreign pol
		document.getElementById("lastPol").style.display = "inline";
		document.getElementById("general").style.display = "inline";		
		document.getElementById("general_1").style.display = "none";		
		//document.getElementById("general").style.left = "335";
		document.getElementById("general").style.left = "300";
		document.getElementById("general").style.top = "41";
		
		formObj = document.form;
		var rtn_type;
		if (formObj.mbl_no.value == "" && formObj.ams_file_no.value == "") {
			if (formObj.date_search.checked) {
				if (formObj.fromd.value == "" || formObj.fromt.value == "" || formObj.tod.value == "" || formObj.tot.value == "") {
					rtn_type = false;
				}
				if (ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 30) {
					rtn_type = false;
				}
			} else {
				if (formObj.vvd.value == "" || formObj.vvd.value.length != 9) {
					rtn_type = false;
				}
				if (formObj.last_pol.value == "") {
					rtn_type = false;
				}
			}
		}
		
		// BAPLIE Tab으로 이동될때는 자동 조회되지 않도록 한다.
		//if(rtn_type != false){
		//	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);			
		//}

		// attribute : enabled -> disabled
		document.form.hub1.disabled = true;
		document.form.del1.disabled = true;
		document.form.eq_ofc.Enable = false;		//		
		document.form.b_stf.disabled = true;
		document.form.l_rep.disabled = true;
		document.form.rcv_term_cd.Enable = false;
		document.form.de_term_cd.Enable = false;
		document.form.pmib_tp.disabled = true;
		document.form.filer.Enable = false;
		document.form.customs_result_code_grp.Enable = false;
		document.form.customs_result_code.Enable = false;
		document.form.mbl_no.disabled = true;
		document.form.ams_file_no.disabled = true;
		document.form.excl_rls.disabled = true;
		document.form.cntr_prt_flg.disabled = true;
		document.form.final_flg.disabled = true;		
		
		document.form.cust_arr_exp[0].checked = true;
		document.form.cust_arr_exp[0].disabled = false;
		document.form.cust_arr_exp[2].disabled = true;
		document.form.cust_arr_exp[3].disabled = true;
		
		// attribute style : enbaled -> disabled
		document.form.pol1.className = "input";
		document.form.pod1.className = "input";
		document.form.del1.className = "input2";
		document.form.hub1.className = "input2";
//		document.form.eq_ofc.className = "input2";
		document.form.b_stf.className = "input2";
		document.form.l_rep.className = "input2";
		document.form.pmib_tp.className = "input2";
		document.form.mbl_no.className = "input2";
		document.form.ams_file_no.className = "input2";

		ComBtnDisable('btn_BLInquiry');
		ComBtnDisable('btn_InquiryByCntr');
		ComBtnDisable('btn_BlCharge');
		ComBtnDisable('btn_Print');
		ComBtnDisable('btn_2q4q');
		ComBtnDisable('btn_2r4r');
		ComBtnDisable('btn_2z');
		ComBtnDisable('btn_6h6i');
		ComBtnDisable('btn_non3Z');
		ComBtnDisable('btn_RailAmsHistory');
	}
	
	if (document.tab1.SelectedIndex == 0 ) {
		document.getElementById("contractType").style.display = "inline";
		ComBtnEnable("btn_discrepancy");		
	} else {
		document.getElementById("contractType").style.display = "none";
		ComBtnDisable("btn_discrepancy");		
	}	
	if (document.tab1.SelectedIndex == 1) {
		document.getElementById("railAms").style.display = "inline";
		document.getElementById("useDateCond").rowSpan = 3;
		
		var tbl=document.getElementById("changeTbl"); 
		var oRow = tbl.insertRow(2);
		oRow.className = "tr2_head";
		var oCell = oRow.insertCell(-1);
		oCell.colSpan = 2;
		oCell.align = "left";
		oCell.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' name='cust_arr_exp' value='ETA' class='trans'>&nbsp;POD ETA";
	} else {
		document.getElementById("railAms").style.display = "none";
		if(changetab == 1) {
			document.getElementById("useDateCond").rowSpan = 2;
			var tbl=document.getElementById("changeTbl"); 
			var oRow = tbl.deleteRow(2);
		}
	}
	changetab = nItem;
}

/**
 * change이벤트 발생시, VVD, POL 필드가 대상이 되었다면, ETA 조회실행.
 */
function chkChange2() {
	var srcName = event.srcElement.getAttribute("name");
	var srcObj = event.srcElement;
	srcObj.value = ComTrim(srcObj.value);
	if (srcName == "mbl_no") {
		if (srcObj.value != "" && srcObj.value.length != 12) {
			ComShowCodeMessage('BKG00241');
			srcObj.value = "";
		}
	} else if (srcName == "ams_file_no") {
		if (srcObj.value != "" && srcObj.value.length != 12) {
			ComShowCodeMessage('BKG00388', "AMS FILE NO");
			srcObj.value = "";
		}
	}
		
	if(srcName == "pol1"){		
		document.form.pol.value = document.form.pol1.value;
		document.form.pol2.value = document.form.pol1.value;		
	}else if(srcName == "pod1"){
		document.form.pod.value = document.form.pod1.value;
		document.form.pod2.value = document.form.pod1.value;				
	}else if(srcName == "del1"){
		document.form.del.value = document.form.del1.value;
		document.form.del2.value = document.form.del1.value;				
	}else if(srcName == "hub1"){
		document.form.hub.value = document.form.hub1.value;
		document.form.hub2.value = document.form.hub1.value;						
	}else if(srcName == "pol2"){
		document.form.pol.value = document.form.pol2.value;
		document.form.pol1.value = document.form.pol2.value;				
	}else if(srcName == "pod2"){
		document.form.pod.value = document.form.pod2.value;
		document.form.pod1.value = document.form.pod2.value;						
	}else if(srcName == "del2"){
		document.form.del.value = document.form.del2.value;
		document.form.del1.value = document.form.del2.value;						
	}else if(srcName == "hub2"){
		document.form.hub.value = document.form.hub2.value;
		document.form.hub1.value = document.form.hub2.value;								
	}
}

/**
 * click이벤트 발생시, VVD, POL 필드가 대상이 되었다면, ETA 조회실행.
 */
function chkClick2() {
	var srcName = event.srcElement.getAttribute("name");
	var srcObj = event.srcElement;
	var form = document.form;
	if (srcName == "date_search") {
		if (srcObj.checked) {
			form.fromd.className = "input1";
			form.fromt.className = "input1";
			form.tod.className = "input1";
			form.tot.className = "input1";
			form.vvd.className = "input";
			form.pol.className = "input";
			form.pod.className = "input";
			// BAPLIE일 경우
			if(document.tab1.SelectedIndex == 3){
				form.last_pol.className = "input";
			}
			form.fromd.focus();
		} else {
			form.fromd.className = "input2";
			form.fromt.className = "input2";
			form.tod.className = "input2";
			form.tot.className = "input2";
			form.vvd.className = "input1";
			// BAPLIE일 경우
			if(document.tab1.SelectedIndex == 3){
				form.pol.className = "input";
				form.pod.className = "input";
				form.last_pol.className = "input1";
			} else {
				form.pol.className = "input1";
				form.pod.className = "input1";
			}

		}
	}
}

/**
 * sheet1 조회 후
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i = 1; i <= LastRow; i++) {
			ToolTipText(i, "dspo_cd") = CellValue(i, "cstms_dspo_nm");
			if (CellValue(i, "mbl_no") != CellValue(i, "ams_file_no")) {
				//AMS FILE번호가 MBL이 아니면 파란색.
				CellFontColor(i, "ams_file_no") = RgbColor(0, 0, 255);
			}
			if (CellValue(i, "free_trd_zn_flg") == "Y") {
				//free_trd_zn_flg 'Y'이면 붉은색.
				CellFontColor(i, "free_trd_zn_flg") = RgbColor(255, 0, 0);
			}
			if (CellValue(i, "dspo_cd") == "6H") {
				RowFontColor(i) = RgbColor(255, 0, 0);
			} else if (CellValue(i, "dspo_cd") == "6I") {
				RowFontColor(i) = RgbColor(0, 0, 255);
			}
		}
		if ( document.form.search_discrepancy.value == "N" ) {
			document.getElementById("bl_cnt").innerHTML = sheetObj.CellValue(sheetObj.SelectRow, "bl_cnt");
		} else {
			document.getElementById("bl_cnt").innerHTML = "";
		}
	}
}

/**
 * sheet2 조회 후 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i = 1; i <= LastRow; i++) {
			ToolTipText(i, "dspo_cd") = CellValue(i, "cstms_dspo_nm");
			if (CellValue(i, "free_trd_zn_flg") == "Y") {
				//free_trd_zn_flg 'Y'이면 붉은색.
				CellFontColor(i, "free_trd_zn_flg") = RgbColor(255, 0, 0);
			}
		}
		if (document.form.cntr_prt_flg.checked) {
			sheetObj.SubSumBackColor = sheetObj.RgbColor(195,195,195)
			ShowSubSum("cntr_no", "6|7|8|9|10|11|12|13|15|16", 0, false, false, 0, "0=;6=%s;8=%s;9=%s;10=%s;11=%s;12=%s;13=%s;");
			var sumRow =  FindSubSumRow().split("|");
			for (var idx=0; idx<sumRow.length-1; idx++){
				var sumTpSz = CellValue(sumRow[idx], "cntr_tpsz_cd");
				if(sumTpSz == "X2") {
					CellValue2(sumRow[idx], 18) = "1";
					CellValue2(sumRow[idx], 19) = "0";
				} else {
					CellValue2(sumRow[idx], 18) = "0";
					CellValue2(sumRow[idx], 19) = "1";
				}
			}
			InitTreeInfo("seq", "");
			ShowTreeLevel(0, 1); //모두 접기
			RowExpanded(1) = true; //1행의 트리만 펼치기
			ColWidth("seq") = 50;
		}
	}
}

/**
 * sheet3 조회 후
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		for ( var i = 1; i <= LastRow; i++) {
			if (CellValue(i, "mh") == "H") {
				//House BL 파란색.
				CellFontColor(i, "ams_file_no") = RgbColor(0, 0, 255);
			}
			if (CellValue(i, "isf_rslt_cd") == "01") {
				CellFontColor(i, "isf_rslt_desc") = RgbColor(255, 0, 0);
				CellFontColor(i, "isf_rmk") = RgbColor(255, 0, 0);
			}
		}
	}
}

/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * IBMultiCombo의 item으로 insert 해준다.<br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = ComXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
 * 
 * </pre>
 * 
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
 * @param {string} codeCol 필수, Combo의 Code컬럼명.
 * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
 * @param {string} condCol 필수, 조건 필드. 다수일 경우 '|' 로 연결
 * @param {string} condVal 필수, 조건 값 필드. 다수일 경우 '|' 로 연결
 * @return 없음.
 */
function ComXml2Combo2(xmlStr, cmbObj, codeCol, textCol, condCol, condVal) {
	if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}
	if (condCol == null || condCol == "" || condVal == null || condVal == "") {
		return;
	}
	try {
		cmbObj.RemoveAll();

		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}
		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var colListIdx = Array();
		var arrText = textCol.split("|");
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}
			for ( var j = 0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j + 1] = i;
				}
			}
		}
		var condListIdx = 0;
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == condCol) {
				condListIdx = i;
			}
		}
		var k = 0;
		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			var item = "";
			for ( var j = 1; j < colListIdx.length; j++) {
				item += arrData[colListIdx[j]];
				if (j < colListIdx.length - 1) {
					item += "|";
				}
			}
			if (arrData[condListIdx] == condVal || condVal == "ALL" || condVal == "All") {

				cmbObj.InsertItem(k, item, arrData[colListIdx[0]]);
				k++;
			}
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
 * 입력값을 upper로 변경하여 재등록 한다.
 * @param comboObj
 * @return
 */
function customs_result_code_grp_OnChange(comboObj) {
	if (comboObj.Code == "")
		document.form.customs_result_code.RemoveAll();
		ComXml2Combo2(customs_result_codeXml, document.form.customs_result_code, "cstms_dspo_cd", "cstms_dspo_cd|cstms_dspo_nm", "dspo_tp_cd",
		comboObj.Code);
	}

/**
 * sheet1 더블클릭시
 * @param SheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(SheetObj, Row, Col) {
	doActionIBSheet(SheetObj, document.form, SEARCH11);
}

/**
 * sheet2 더블클릭시
 * @param SheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnDblClick(SheetObj, Row, Col) {
	doActionIBSheet(SheetObj, document.form, SEARCH11);
}

/**
 * customs_result_code Change발생시
 * @param comboObj
 * @return
 */
function customs_result_code_OnChange(comboObj) {
	if (comboObj.Code == "" && comboObj.Text != "") {
		comboObj.InsertItem(-1, comboObj.Text.toUpperCase(), comboObj.Text.toUpperCase());
		comboObj.Index2 = comboObj.GetCount() - 1;
	}
}

/**
 * filer COMBO 체크시
 * @param comboObj
 * @param s_index
 * @param s_code
 * @return
 */
function filer_OnCheckClick(comboObj, s_index, s_code) {
	if (s_code == "All") {
		if ((comboObj.Code).indexOf("All") >= 0) {
			comboObj.CheckCode("01") = true;
			comboObj.CheckCode("02") = true;
			comboObj.CheckCode("03") = true;
			comboObj.CheckCode("00") = true;
		} else {
			comboObj.CheckCode("01") = false;
			comboObj.CheckCode("02") = false;
			comboObj.CheckCode("03") = false;
			comboObj.CheckCode("00") = false;
		}
	} else {
		if ((comboObj.Code).indexOf("All") >= 0) {
			comboObj.CheckCode("All") = false;
		}
	}
}

 /**
  * eq_ofc COMBO 체크시
  * @param comboObj
  * @param s_index
  * @param s_code
  * @return
  */
 function eq_ofc_OnCheckClick(comboObj, index, code) {
	if(index == 0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1; i < comboObj.GetCount(); i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
 } 
 
 
/**
 * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
 * @param sheetObj
 * @param CondParam
 * @param PageNo
 * @param OnePageRows
 * @return
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

/**
 * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
 * @param sheetObj
 * @param CondParam
 * @param PageNo
 * @param OnePageRows
 * @return
 */
function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}
 

/**
 * 헤더를 클릭한 경우(소트시)
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	var form = document.form;
	var col = sheetObj.MouseCol
	if (sheetObj.MouseRow == 0 || sheetObj.MouseRow == 1) {
		if (sheetObj.RowCount < sheetObj.TotalRows) {
			ComOpenWait(true);
			form.retrieve_remains.value = sheetObj.TotalRows;
			sheetObj.TopRow = sheetObj.RowCount;
			sheetObj.TopRow = 0;
			sheetObj.ColumnSort(col);
			ComOpenWait(false);
		}
	}	
}
 

/**
 * 헤더를 클릭한 경우(소트시)
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	var form = document.form;
	var col = sheetObj.MouseCol
	if (sheetObj.MouseRow == 0 || sheetObj.MouseRow == 1) {
		if (sheetObj.RowCount < sheetObj.TotalRows) {
			ComOpenWait(true);
			form.retrieve_remains.value = sheetObj.TotalRows;
			sheetObj.TopRow = sheetObj.RowCount;
			sheetObj.TopRow = 0;
			sheetObj.ColumnSort(col);
			ComOpenWait(false);
		}
	}
} 
 
 /**
  * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
  * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
  */
 function sheet1_OnLoadFinish(shtObj) {
//        for ( var k = 0; k < tabObjects.length; k++) {
//              initTab(tabObjects[k], k + 1);
//        }
        doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
        if (document.form.mbl_no.value != "") {
              tabObjects[0].SelectedIndex = 1;
              doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
        
        //BAPLIE(ESM_BKG_1023)화면에서 Go to AMS Report 버튼 클릭으로 Load 될 경우
        if (document.form.event_from.value == "fromBapLieScreen") {
              tabObjects[0].SelectedIndex = 3;
              var formObject = document.form;
              //Parameter 로 넘어온 값을 Form 에 입력
              formObject.vvd.value = formObject.hid_vvd.value;
              formObject.last_pol.value = formObject.hid_last_pol.value;
              doActionIBSheet(sheetObjects[3], formObject, IBSEARCH);
        }      
 }

 
