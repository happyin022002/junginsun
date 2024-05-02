/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0013.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
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
function esm_bkg_0013() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnKeyUp = sheet1_OnKeyUp;
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

		case "btn_new":
			doActionIBSheet(sheetObjects[0], document.form, "NEW");
			break;

		case "btn_save":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;

		case "btn_downexcel":
			sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			break;

		case "btn_create":
			doActionIBSheet(sheetObject, formObject, SEARCH11);
			break;

		case "btn_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.s_vps_eta_dt, formObject.e_vps_eta_dt, 'yyyy-MM-dd');
			break;
			
		case "btn_delete":
			sUrl = "ESM_BKG_1178.do?";
			sParam = "pgmNo=ESM_BKG_1178";
			ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_1178", 900, 500, false);		
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
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	doActionIBSheet(sheetObjects[0], document.form, INIT);
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
			style.height = 420;
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

			var HeadTitle1 = "|Sel.|Lane|VVD|Operator|POD|ETA|CRN|||||||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, true, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 50, daCenter, false, "check", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "slan_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 165, daCenter, false, "vvd_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 140, daCenter, false, "crr_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vps_port_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 200, daCenter, false, "vps_eta_dt", false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, "cvy_ref_no", false, "", dfNone, 0, true, false, 20);
			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vsl_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "skd_voy_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "skd_dir_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "is_crn_no", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "check_flag", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "upd_crn", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true, "pre_crr", false, "", dfNone, 0, true, true);

			InitUserFormat2(0, "vps_eta_dt", "####-##-## ##:##", "-|:");
			InitDataValid(0, "cvy_ref_no", vtEngUpOther, "1234567890");
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
	formObj.f_cmd.value = sAction;

	switch (sAction) {

	case INIT: //init
		formObj.s_vps_eta_dt.value = ComGetNowInfo('ymd', '-');
		formObj.e_vps_eta_dt.value = ComGetDateAdd(null, 'd', 14, '-');
		formObj.vps_port_cd.focus();
		formObj.vps_port_cd.value = 'CA';
		break;
	case "NEW":
		formObj.reset();
		initSheet(sheetObj, 1);
		formObj.s_vps_eta_dt.value = ComGetNowInfo('ymd', '-');
		formObj.e_vps_eta_dt.value = ComGetDateAdd(null, 'd', 14, '-');
		formObj.vps_port_cd.value = 'CA';
		formObj.vps_port_cd.focus();
		break;
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0013GS.do", FormQueryString(formObj));
			sheetObj.loadSearchXml(sXml);
			ComOpenWait(false);
		}
		break;

	case MULTI: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;

			for ( var i = 1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.CellValue(i, "upd_crn") != "") {
					//							sheetObj.CellValue2(i,"cvy_ref_no") = sheetObj.CellValue(i, "upd_crn");
				}
				if (sheetObj.RowStatus(i) == "U" && sheetObj.CellValue(i, "is_crn_no") == "0") {
					sheetObj.RowStatus(i) = "I";
				}
			}
			var sParam = ComGetSaveString(sheetObj);
			if (sParam == "") {
				ComShowCodeMessage('BKG00743');
				return;
			}
			sParam += "&" + FormQueryString(formObj);
			if (ComShowCodeConfirm("BKG00350")) {
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0013GS.do", sParam);
				if (ComBkgErrMessage(sheetObj, sXml)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_0013GS.do", FormQueryString(formObj));
				} else {
					//왜 그런지는 모르겠는데 cvy_ref_no가 EDIT가 불가능해져서 TRUE로 강제설정
					for ( var i = 1; i <= sheetObj.RowCount; i++) {
						sheetObj.CellEditable(i, "cvy_ref_no") = true;
					}
				}
				ComOpenWait(false);
			}
		}
		break;

	case SEARCH11: // CRN Create
		if (validateForm(sheetObj, formObj, sAction)) {
			if (ComShowCodeConfirm("BKG00390")) {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH11;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0013GS.do", FormQueryString(formObj));
				var sMaxCvyRefNo = ComGetEtcData(sXml, "max_cvy_ref_no");
				var sPrefix = "918PCE";
				var vIndex = 1;

				var vVsl_cd;
				var vSkd_voy_no;
				var vSkd_dir_cd;
				for ( var i = 1; i <= sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i, "check") == 1) {
						sheetObj.CellValue2(i, "cvy_ref_no") = sPrefix + ComLpad((parseInt(sMaxCvyRefNo) + vIndex), 4, '0');
						vIndex++;
					}
				}
				ComOpenWait(false);
			}
		}
		break;
	}

	for ( var i = 1; i <= sheetObj.RowCount; i++) {
		if (sheetObj.CellValue(i, "check_flag") == "T") {
			sheetObj.CellEditable(i, "check") = true;
		}
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
	case SEARCH:
		//기본포멧체크
		if (!ComChkValid(formObj))
			return false;
		// 수정한 정보가 있을 경우 저장후 조회처리
		if (sheetObj.IsDataModified) {
			if (ComShowCodeConfirm("BKG00386")) {
				doActionIBSheet(sheetObj, formObj, MULTI);
				return false;
			}
		}
		//널체크 및 포멧 길이체크
		if ((ComIsNull(formObj.vps_port_cd) || ComIsNull(formObj.s_vps_eta_dt) || ComIsNull(formObj.e_vps_eta_dt))
				&& (ComIsNull(formObj.vvd_cd)) && (ComIsNull(formObj.cvy_ref_no))) {
			ComShowCodeMessage('BKG00626', '(POD and ETA) or (VVD) or (CRN)');
			ComSetFocus(form.vps_port_cd)
			return false;
		}
		break;
	case MULTI:
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			var vCRN = sheetObj.CellValue(i, "cvy_ref_no");
			var vVvd = sheetObj.CellValue(i, "vvd_cd");
			var vCrr = sheetObj.CellValue(i, "crr_cd");
			var vPreCrr = sheetObj.CellValue(i, "pre_crr");
			if (sheetObj.RowStatus(i) != "R") {
				if (vPreCrr == "")
				{
					ComShowMessage('This Operator[' + vCrr + '] does not exist!');
					return false;
				}
				if (!ComIsNull(vCRN)) {
					if (ComChkLen(vCRN, 7) == 1) {
						ComShowCodeMessage('BKG00388', 'CRN');
						return false;
					}
					if (vCrr == "YML" || vCrr == "COS") {
						if (vCRN.substr(0, 4) != vPreCrr) {
							ComShowCodeMessage('BKG00796', vCRN, vVvd, vCrr);
							return false;
						}
					} else {
						if (vCRN.substr(0, 6) != vPreCrr + "CE") {
							ComShowCodeMessage('BKG00796', vCRN, vVvd, vCrr);
							return false;
						}
					}
				}
			}
		}
		break;
	case SEARCH11:
		var vIsCheck = false;
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "check") == 1) {
				vIsCheck = true;
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00333');
			return false;
		}
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
	if ((srcName == "vps_port_cd" || srcName == "slan_cd" || srcName == "crr_cd" || srcName == "vvd_cd")
			&& ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}