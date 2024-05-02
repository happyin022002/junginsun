/*=========================================================
 *Copyright(c) 2017 SMLines
 *@FileName : ESM_BKG_N009.js
 *@FileTitle : Canada Export: Vessel Departure Transmit (A6)
 *Open Issues :
 *Change history :
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  ADD=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_N009() {
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

var sheetObjects = new Array();
var sheetCnt = 0;

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
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;
		case "btn_transmit":
			doActionIBSheet(sheetObject, formObject, ADD);
			break;
		case "btn_dep_transmit":
			doActionIBSheet(sheetObject, formObject, MULTI01);
			break;
		case "btn_delete":
			doActionIBSheet(sheetObject, formObject, REMOVE);
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
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	document.form.vvd_cd.focus();
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);	
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
	case "sheet1": //sheet1 init
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
			InitRowInfo(1, 1, 2, 100);

			var HeadTitle1 = "|vsl_cd|skd_voy_no|skd_dir_cd|VPS_PORT_CD|Carrier Code|Departure Date|CRN|Captain Name|Total WGT|TEU Full|FEU Full|OTH Full|TEU Empty|FEU Empty|OTH Empty|crr_cd_val|cnd_vsl_cd|del_flag|CREW|Passenger|Actual Departure Date";
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
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, "ibflag");

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vsl_cd",      false, "", dfNone,   0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "skd_voy_no",  false, "", dfNone,   0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "skd_dir_cd",  false, "", dfNone,   0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vps_port_cd", false, "", dfNone,   0, false, false);
                                                                                                      
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "crr_cd",      false, "", dfNone,   0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "vps_etd_dt",  false, "", dfNone,   0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "cvy_ref_no",  false, "", dfNone,   0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "cap_nm",      false, "", dfNone,   0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "cgo_wgt",      false, "", dfFloat, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "teu_ful",      false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "feu_ful",      false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "oth_ful",      false, "", dfFloat, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "teu_mty",      false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "feu_mty",      false, "", dfFloat, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "oth_mty",      false, "", dfFloat, 0, false, false);

			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "attr_ctnt2",   false, "", dfNone,  0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "cnd_vsl_cd",   false, "", dfNone,  0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "del_flag",     false, "", dfNone,  0, false, false);
			                                                                                           
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "crw_knt",      false, "", dfNone,  0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "pasg_cnt",     false, "", dfNone,  0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, false, "act_dep_dt",   false, "", dfNone,  0, false, false);
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {

	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_N009GS.do", FormQueryString(formObj));

			if (sheetObj.RowCount > 0) {
				IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
				formObj.frm_cgo_wgt.value = ComAddComma2(formObj.frm_cgo_wgt, "#,###");
				formObj.frm_teu_ful.value = ComAddComma2(formObj.frm_teu_ful, "#,###");
				formObj.frm_feu_ful.value = ComAddComma2(formObj.frm_feu_ful, "#,###");
				formObj.frm_oth_ful.value = ComAddComma2(formObj.frm_oth_ful, "#,###");
				formObj.frm_teu_mty.value = ComAddComma2(formObj.frm_teu_mty, "#,###");
				formObj.frm_feu_mty.value = ComAddComma2(formObj.frm_feu_mty, "#,###");
				formObj.frm_oth_mty.value = ComAddComma2(formObj.frm_oth_mty, "#,###");
			} else {
				//조회된 데이가 없을경우 모든 필드값을 ""으로 세팅한다. 조회조건 제외하고.
				for ( var i = 0; i < formObj.getElementsByTagName("input").length; i++) {
					if (formObj.getElementsByTagName("input")[i].name != "vvd_cd"
							&& formObj.getElementsByTagName("input")[i].name != "pol_cd") {
						formObj.getElementsByTagName("input")[i].value = "";
					}
				}
			}
			ComOpenWait(false);
		}
		break;

	case MULTI: //Save
		// date + " " + time (요렇게 해야함)
		formObj.frm_act_dep_dt.value = formObj.frm_act_dep_da.value + " " +formObj.frm_act_dep_tm.value;
		
		if (!validateForm(sheetObj, formObj, sAction)) return false;
			
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
		if (sheetObj.RowStatus(1) == "U" && sheetObj.CellValue(1, "cnd_vsl_cd") == "") {
			sheetObj.RowStatus(1) = "I";
		}
		
		var sParam = ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj);
		sheetObj.DoSave("ESM_BKG_N009GS.do", sParam, -1, false);
		ComOpenWait(false);
		
		break;

	case ADD:
		if (validateForm(sheetObj, formObj, sAction)) {
			if (ComShowCodeConfirm("BKG01023", "A6", "Canada Customs")) {
				ComOpenWait(true);
				IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
				formObj.f_cmd.value = ADD;
				sheetObj.RowStatus(1) = "U";
				// 삭제 flag 세팅
				sheetObj.CellValue2(1, "del_flag") = "";
				sheetObj.DoSave("ESM_BKG_N009GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
			}
		}
		break;
		
	case MULTI01:
		// date + " " + time (요렇게 해야함)
		formObj.frm_act_dep_dt.value = formObj.frm_act_dep_da.value + " " +formObj.frm_act_dep_tm.value;
		if (!validateForm(sheetObj, formObj, sAction)) return false;

		if (ComShowCodeConfirm("BKG01023", "ATA", "Canada Customs")) {
			ComOpenWait(true);
			IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
			formObj.f_cmd.value = MULTI01;
			sheetObj.RowStatus(1) = "U";
			// 삭제 flag 세팅
			sheetObj.CellValue2(1, "del_flag") = "";
			sheetObj.DoSave("ESM_BKG_N009GS.do", FormQueryString(formObj), -1, false);
			ComOpenWait(false);
		}
		break;

	case REMOVE:
		if (validateForm(sheetObj, formObj, sAction)) {
			if (ComShowCodeConfirm("COM12165", "Vessel Arrival Manifest")) {
				ComOpenWait(true);
				IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
				formObj.f_cmd.value = ADD;
				sheetObj.RowStatus(1) = "U";
				// 삭제 flag 세팅
				sheetObj.CellValue2(1, "del_flag") = "D";
				sheetObj.DoSave("ESM_BKG_N009GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
			}
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

	case SEARCH: //조회
		// 기본포멧체크
		if (!ComChkValid(formObj))
			return false;

		if (sheetObj.RowCount > 0){
			IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
		}
		// 수정한 정보가 있을 경우 저장후 조회처리
		if (sheetObj.IsDataModified) {
			if (ComShowCodeConfirm("BKG00386")) {
				doActionIBSheet(sheetObj, formObj, MULTI);
				return false;
			}
		}
		break;

	case MULTI: //수정
		// 기본포멧체크
		if (!ComChkValid(formObj))
			return false;
		if (sheetObj.RowCount < 1) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
		if (!sheetObj.IsDataModified)
		{
			ComShowCodeMessage("BKG95005");
			return false;
		}
		if( formObj.frm_act_dep_da.value == "" ) {
			formObj.frm_act_dep_dt.value = "";
		}
		break;

	case ADD:
	case MULTI01:
	case REMOVE:
		if (sheetObj.RowCount < 1) {
			ComShowCodeMessage('BKG00395');
			return false;
		} else {
			if (ComIsNull(formObj.frm_cvy_ref_no)) {
				ComShowCodeMessage('BKG00717', formObj.frm_cvy_ref_no.getAttribute("caption"));
				return false;
			}
			if (ComIsNull(formObj.frm_cap_nm)) {
				ComShowCodeMessage('BKG00717', formObj.frm_cap_nm.getAttribute("caption"));
				return false;
			}
		}
		
		if(sAction == MULTI01) {
			if( formObj.frm_act_dep_da.value == "" ) {
				ComShowCodeMessage('BKG00104', "Actual Arrival Date");
				return false;
			}
		}
		break;
	}
	return true;
}

/**
 * 조회조건 입력 후 자동으로 다음항목으로 이동
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (srcName == "vvd_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 조회후  이벤트 처리
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    with (sheetObj) {
    	var formObject = document.form;
    	var actdt = sheetObj.CellValue(1, "act_dep_dt");
    	formObject.frm_act_dep_da.value = actdt.substr(0,10); 
    	formObject.frm_act_dep_tm.value = actdt.substr(11,5);
    }
}