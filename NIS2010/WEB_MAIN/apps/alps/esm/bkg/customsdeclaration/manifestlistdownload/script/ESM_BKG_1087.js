/*=========================================================
 *Copyright(c) 2017 SM Line
 *@FileName : esm_bkg_1087.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.11.14
 *@LastModifier : 하대성
 *@LastVersion : 1.0
 * 2017.11.14 하대성  두바이 세관 라이브 반영
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1087() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var tab2SearchFlag = false;
var tab3SearchFlag = false;

var sheetObjects = new Array();
var sheetCnt = 0;

var aryPrefix = new Array("s1_", "s2_"); //prefix 문자열 배열

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, SEARCH, 1);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI);
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
 * @param sheet_obj IBSheet Object
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

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'obj_KeyDown', 'form');
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);

			var HeadTitle1 = "|bl_no|pod_cd|vsl_cd|skd_voy_no|skd_dir_cd|du_rotn_no|du_line_id|du_voy_agn_id|org_port_cd|por_cd|pol_cd|pod_cd|del_cd|du_mf_no|du_cgo_cd|du_cntr_svc_tp_cd|du_trd_cd|du_ts_mod_cd|cnsl_cgo_flg|org_cnt_cd|org_bl_no|org_vsl_cd|org_skd_voy_no|org_skd_dir_cd|org_vsl_nm|mk_no_ctnt|du_cmdt_cd|cmdt_desc|pck_qty|du_pck_desc|du_pck_tp_cd|cntr_no|cntr_knt|bkg_teu_qty|tare_wgt|cgo_wgt|grs_wgt|meas_qty|du_ttl_qty|du_frt_wgt|plt_qty|s_bkg_cust_tp_cd|s_cust_cnt_cd|s_cust_nm|s_cust_addr|s_org_cust_nm|s_org_cust_addr|c_bkg_cust_tp_cd|c_du_cust_id|c_cust_nm|c_cust_addr|c_org_cust_nm|c_org_cust_addr|n_bkg_cust_tp_cd|n_cust_nm|n_cust_addr";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 4, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "bl_no");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pod_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "vsl_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "skd_voy_no");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "skd_dir_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_rotn_no");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_line_id");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_voy_agn_id");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "org_port_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "por_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pol_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "del_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_mf_no");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_cgo_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_cntr_svc_tp_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_trd_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_ts_mod_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cnsl_cgo_flg");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "org_cnt_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "org_bl_no");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "org_vsl_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "org_skd_voy_no");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "org_skd_dir_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "vsl_nm");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "mk_no_ctnt");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_cmdt_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cmdt_desc");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pck_qty", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_pck_desc");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_pck_tp_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_no");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_knt", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "bkg_teu_qty", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "tare_wgt", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cgo_wgt", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "grs_wgt", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "meas_qty", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_ttl_qty", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "du_frt_wgt", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "plt_qty", false, "", dfNullFloat);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "s_bkg_cust_tp_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "s_cust_cnt_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "s_cust_nm");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "s_cust_addr");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "s_org_cust_nm");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "s_org_cust_addr");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "c_bkg_cust_tp_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "c_du_cust_id");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "c_cust_nm");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "c_cust_addr");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "c_org_cust_nm");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "c_org_cust_addr");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "n_bkg_cust_tp_cd");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "n_cust_nm");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "n_cust_addr");
			CountPosition = 0;
		}
		break;
	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param tab_obj 탭오브젝트
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 * @param tabObj 탭오브젝트
 * @param tabNo 탭번호
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "B/L Detail", -1);
			InsertTab(cnt++, "Customer Detail", -1);
		}
		break;
	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 * @param tabObj 탭오브젝트
 * @param nItem 탭번호
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";
	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	
	if (nItem == 0)
		document.getElementById("title").innerHTML = "Dubai Inbound Manifest - B/L Detail ";
	else
		document.getElementById("title").innerHTML = "Dubai Inbound Manifest - Customer Detail ";
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 * @param tabno 탭번호
 */
function doActionIBSheet(sheetObj, formObj, sAction, tabno) {
	sheetObj.ShowDebugMsg = false;
	//
	formObj.f_cmd.value = sAction;
	switch (sAction) {
	case SEARCH: //Retrieve, Tab1
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1087GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		sheetObj.loadSearchXml(arrXml[0]);
		// DUBAI TRADE CODE
		ComXml2ComboItem(arrXml[1], formObj.bl_du_trd_cd, "val", "val|name");
		formObj.bl_du_trd_cd.InsertItem(0, "|", "");
		// DUBAI CARGO CODE
		ComXml2ComboItem(arrXml[2], formObj.bl_du_cgo_cd, "val", "val|desc");
		formObj.bl_du_cgo_cd.InsertItem(0, "|", "");
		// DUBAI CONTAINER SERVICE TYPE CODE
		ComXml2ComboItem(arrXml[3], formObj.bl_du_cntr_svc_tp_cd, "val", "val|desc");
		formObj.bl_du_cntr_svc_tp_cd.InsertItem(0, "|", "");
		// DUBAI TRANSSHIPMENT MODE CODE
		ComXml2ComboItem(arrXml[4], formObj.bl_du_ts_mod_cd, "val", "val|name");
		formObj.bl_du_ts_mod_cd.InsertItem(0, "|", "");
		//
		tabObjects[0].SelectedIndex = formObj.tabIndex.value
		
		if (sheetObj.RowCount > 0) {
			IBS_CopyRowToForm(sheetObj, formObj, 1, "bl_");
			formObj.bl_pck_qty.value = ComAddComma2(formObj.bl_pck_qty, "#,###");
			formObj.bl_plt_qty.value = ComAddComma2(formObj.bl_plt_qty, "#,###");
			formObj.bl_cntr_knt.value = ComAddComma2(formObj.bl_cntr_knt, "#,###");
			formObj.bl_du_ttl_qty.value = ComAddComma2(formObj.bl_du_ttl_qty, "#,###");
			
			formObj.bl_tare_wgt.value = ComAddComma2(formObj.bl_tare_wgt, "#,###");
			formObj.bl_cgo_wgt.value = ComAddComma2(formObj.bl_cgo_wgt, "#,###");
			formObj.bl_bkg_teu_qty.value = ComAddComma2(formObj.bl_bkg_teu_qty, "#,###");
			formObj.bl_grs_wgt.value = ComAddComma2(formObj.bl_grs_wgt, "#,###");
			formObj.bl_du_frt_wgt.value = ComAddComma2(formObj.bl_du_frt_wgt, "#,###");
			formObj.bl_meas_qty.value = ComAddComma2(formObj.bl_meas_qty, "#,###");
			
			// 콤보세팅
			formObj.bl_du_trd_cd.Code = sheetObj.CellValue(1, "du_trd_cd");
			formObj.bl_du_cgo_cd.Code = sheetObj.CellValue(1, "du_cgo_cd");
			formObj.bl_du_cntr_svc_tp_cd.Code = sheetObj.CellValue(1, "du_cntr_svc_tp_cd");
			formObj.bl_du_ts_mod_cd.Code = sheetObj.CellValue(1, "du_ts_mod_cd");
			
			formObj.bl_org_vvd.value = sheetObj.CellValue(1, "org_vsl_cd")
				+ sheetObj.CellValue(1, "org_skd_voy_no")
				+ sheetObj.CellValue(1, "org_skd_dir_cd");
		}
		ComOpenWait(false);
		break;
	case MULTI: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			IBS_CopyFormToRow(formObj, sheetObj, 1, "bl_");
			sheetObj.CellValue2(1, "du_trd_cd") = formObj.bl_du_trd_cd.Code
			sheetObj.CellValue2(1, "du_cgo_cd") = formObj.bl_du_cgo_cd.Code
			sheetObj.CellValue2(1, "du_cntr_svc_tp_cd") = formObj.bl_du_cntr_svc_tp_cd.Code
			sheetObj.CellValue2(1, "du_ts_mod_cd") = formObj.bl_du_ts_mod_cd.Code
			
			var vvd = formObj.bl_org_vvd.value;
			if (vvd != "") {
				sheetObj.CellValue2(1, "org_vsl_cd") = vvd.substr(0,4);
				sheetObj.CellValue2(1, "org_skd_voy_no") = vvd.substr(4,4);
				sheetObj.CellValue2(1, "org_skd_dir_cd") = vvd.substr(8);
			}
			// 변경내역이 없는 경우
			if (!sheetObj.IsDataModified) {
				ComShowCodeMessage('BKG00743');
				return;
			}
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_1087GS.do?f_cmd=" + MULTI, sheetObj.GetSaveString());
			// 저장성공메시지
			sheetObj.loadSaveXml(sXml);
			ComOpenWait(false);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case MULTI: //Retrieve, Tab1
		if (!ComChkValid(formObj))
			return false;
		var elems   = formObj.elements;
		
		for(var i = 0; i < elems.length; i++) {
			var elem = elems[i];
			var sTitle = elem.getAttribute("caption");
			if (elem.type == "textarea") {
				if (elem.value.length > elem.getAttribute("maxlength")) {
					ComShowCodeMessage('COM12142', sTitle, elem.getAttribute("maxlength"));
					return false;
				}
			}
		}
		break;
	}
	return true;
}

/**
 * 콤마 붙이기
 * @param numString 입력값 
 * @return 천단위 콤마붙인값
 */
function formatCommas(numString) {
	var re = /,|\s+/g;
	numString = numString.replace(re, "");
 	re = /(-?\d+)(\d{3})/;
	while (re.test(numString)) {
		numString = numString.replace(re, "$1,$2");
	}
	return numString;
}

/**
 * 콤마 붙이기
 * @param value 입력값 
 * @return 천단위 콤마붙인값
 */
function toMoney(value) {
	var indexOfPoint = value.indexOf(".");
	if (indexOfPoint == -1) {
		value = formatCommas(value);
	} else {
		value = formatCommas(value.substring(0, indexOfPoint)) + value.substring(indexOfPoint, value.length);
	}
	return value;
}