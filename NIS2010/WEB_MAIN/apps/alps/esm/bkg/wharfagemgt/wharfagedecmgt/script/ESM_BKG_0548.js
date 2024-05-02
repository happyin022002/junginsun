/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0548.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.04.16 정재엽
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function esm_bkg_0548() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, document.form, SEARCH01);
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
			doActionIBSheet(sheetObject1, document.form, SEARCH01);

			break;

		case "btn_new":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			break;

		case "btn_DataIF":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND03);
			break;

		case "btn_LocationCode":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND04);
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObject = document.form;
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObject);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	axon_event.addListener("change", "obj_OnChange", "vvd", "vps_port_cd", "io_bnd_cd");
	axon_event.addListenerForm("focus", "obj_Focus", document.form);
	axon_event.addListenerForm('change', 'obj_Change', document.form);

	formObject.vvd.focus();
}

/**
 * 자동 Focus 이동 등을 위해 Key 눌렸다가 떼어질 때 호출
 */
function obj_KeyUp() {
	if (window.event.keyCode == 9 || window.event.keyCode == 16) {
		return false;
	}

	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * Form Object에서 onchange 이벤트 발생 시 호출 됨
 */
function obj_OnChange() {
	var srcName = window.event.srcElement.getAttribute("name");
	var formObject = document.form;

	// VVD, Port, Bound의 값이 변경 된 경우, 서비스를 호출하여 MRN No 및 ETA 정보 등을 가져 옴
	if (srcName == "vvd" || srcName == "vps_port_cd" || srcName == "io_bnd_cd") {

		// 값이 모두 입력된 경우에만 호출 한다.
		if ((ComChkLen(formObject.vvd.value, 9) == "2")
				&& (ComChkLen(formObject.vps_port_cd.value, 5) == "2")) {
			doActionIBSheet(sheetObjects[0], formObject, SEARCH);
		}
		
		// 2018.05.30 iylee Port가 KRKAN 이고 Outbound일 경우 할인율을 70%로 설정함.
		if( srcName == "vps_port_cd" ){
			changeWhfVolDcCdbyPort();
		}
	}

	// 입력내용이 변경되었을시에 쉬트에 상태 플래그를 업데이트로 처리하는 메서드.
	sheetObjects[0].CellValue(1, 0) = 'U';
}

/**
 * 화면 폼 입력 필드에 Focus가 오면 값을 전체 선택 해줌 수정 편의를 위해
 */
function obj_Focus() {
	if (window.event.srcElement.getAttribute("type") == "text") {
		window.event.srcElement.select();
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(27, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|vvd|vps_port_cd|io_bnd_cd|vps_dt|mrn_no|mrn_chk_no|vsl_call_sgn_cd |tml_cd |arr_tms_no |arr_yr |io_port_cd |unld_tp_cd |unld_agn_cd1 |unld_agn_cd2 |unld_agn_cd3 |whf_vol_dc_cd |whf_rt |mf_ref_no |whf_pay_dt |port_nm |vsl_nm |sail_dt|vps_dt|pay_dt|upd_usr_id|upd_dt";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = 'sheet1_';
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, prefix
					+ "ibflag");
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix
					+ "vvd");
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "port_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix
					+ "whf_bnd_cd", false, "", dfNone, 0, true, true, 500);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "vps_dt", false, "", dfUserFormat2, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "mrn_no", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "mrn_chk_no", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "vsl_call_sgn_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "tml_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "arr_tms_no", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "arr_yr", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "io_port_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "unld_tp_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "unld_agn_cd1", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "unld_agn_cd2", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "unld_agn_cd3", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "whf_vol_dc_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "whf_rt", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "mf_ref_no", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "whf_pay_dt", false, "", dfUserFormat2, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "port_nm", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "sail_dt", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "vps_dt", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "pay_dt", false, "", dfUserFormat2, 0, true, true, 5);
			
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "upd_usr_id", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "upd_dt", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 490, daCenter, true, prefix
					+ "vsl_nm", false, "", dfNone, 0, true, true, 5);

			// InitDataValid(0, prefix +"brth_cd", vtEngUpOther, "0123456789");
			// InitDataValid(0, prefix +"brth_kr_nm", vtEngUpOther,
			// "0123456789");

			InitUserFormat2(0, prefix + "vps_dt", "####-##-## ", "-|:");
			InitUserFormat2(0, prefix + "whf_pay_dt", "####-##-## ", "-|:");
			InitUserFormat2(0, prefix + "pay_dt", "####-##-## ", "-|:");
			
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case SEARCH:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			var aryPrefix = new Array("sheet1_");
//			alert(FormQueryString(formObj));
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0548GS.do",
					FormQueryString(formObj));
			

			var arrXml = sXml.split("|$$|");
			var mrnNo = "";
			var vpsDt = "";
			var mrnChkNo = "";
			var tmlCd = "";
			var unldAgnCd1 = "";
			var unldAgnCd2 = "";
			var unldAgnCd3 = "";
			var whfRt = "";

			mrnNo = ComGetEtcData(arrXml[0], "mrn_no");
			if (mrnNo != "") {
				vpsDt = ComGetEtcData(arrXml[0], "vps_dt");
				mrnChkNo = ComGetEtcData(arrXml[0], "mrn_chk_no");
			}
			tmlCd = ComGetEtcData(arrXml[0], "tml_cd");
			if (tmlCd != "") {
				unldAgnCd1 = ComGetEtcData(arrXml[0], "unld_agn_cd1");
				unldAgnCd2 = ComGetEtcData(arrXml[0], "unld_agn_cd2");
				unldAgnCd3 = ComGetEtcData(arrXml[0], "unld_agn_cd3");
				whfRt = ComGetEtcData(arrXml[0], "whf_rt");
			}
			formObj.vps_dt.value = vpsDt;
			formObj.mrn_no.value = mrnNo + mrnChkNo;
			formObj.tml_cd.value = tmlCd;
			formObj.unld_agn_cd1.value = unldAgnCd1;
			formObj.unld_agn_cd2.value = unldAgnCd2;
			formObj.unld_agn_cd3.value = unldAgnCd3;
			formObj.whf_rt.value = whfRt;
			
			
			

			if (arrXml[1] != "") {
				ComBkgXml2ComboItem(arrXml[1], formObj.io_port_cd, "brth_cd",
						"brth_cd");
			}

			var brthCd = sheetObjects[0].CellValue(1, 11);
			if (brthCd != '')
				ComSetObjValue(formObj.io_port_cd, brthCd);

			// VVD 로 조회한 후에 마우스 키가 다음 엘리먼트로 가지않아 강제로 지정함
			if (ComChkLen(formObj.vps_port_cd.value, 5) != "2")
				formObj.vps_port_cd.focus();
			else
				formObj.io_bnd_cd.focus();

			// 특정 이름으로 VO 에 데이터를 넘기기 위해 추가함.
			formObj.port_cd.value    = formObj.vps_port_cd.value;
			formObj.whf_bnd_cd.value = formObj.io_bnd_cd.value;

			// Sailing Date 에 29 일을 더하여 납기일자에 입력한다.
			// 2012.08.02 15일을 더하여 납기일자 입력 하도록 수정요청
			if (vpsDt != '')
				formObj.whf_pay_dt.value = ComGetDateAdd(vpsDt, "D", "15", "-");
			else
				formObj.whf_pay_dt.value = '';

			changeWhfVolDcCdbyPort();
		}
		break;

	case SEARCH01: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			
			formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch("ESM_BKG_0548GS.do", FormQueryString(formObj)
					+ "&" + ComGetPrefixParam("sheet1_"));

			formObj.vsl_call_sgn_cd.value = sheetObjects[0].CellValue(1, 7);
			formObj.unld_agn_cd1.value = sheetObjects[0].CellValue(1, 13);
			formObj.unld_agn_cd2.value = sheetObjects[0].CellValue(1, 14);
			formObj.unld_agn_cd3.value = sheetObjects[0].CellValue(1, 15);

			formObj.tml_cd.value = sheetObjects[0].CellValue(1, 8);
			formObj.whf_rt.value = ComAddComma2(sheetObjects[0]
					.CellValue(1, 17), "#,###.0");
			formObj.arr_yr.value = sheetObjects[0].CellValue(1, 10);
			formObj.arr_tms_no.value = sheetObjects[0].CellValue(1, 9);

			var unld_tp_cd = sheetObjects[0].CellValue(1, 12);
			if ('1' == unld_tp_cd)
				formObj.unld_tp_cd[0].checked = true;
			if ('2' == unld_tp_cd)
				formObj.unld_tp_cd[1].checked = true;

			ComSetObjValue(formObj.io_port_cd, sheetObjects[0].CellValue(1, 11));

			if (sheetObjects[0].CellValue(1, 23) != '') // ComGetDateAdd("2008-01-01",
				// "D", 365, "")
				formObj.whf_pay_dt.value = ComGetDateAdd(sheetObjects[0]
						.CellValue(1, 23), "D", 0, "-");
			
			formObj.whf_vol_dc_cd.value = ( sheetObjects[0].CellValue(1, 16) == '') ? '0':sheetObjects[0].CellValue(1, 16)  ;
			formObj.port_nm.value = sheetObjects[0].CellValue(1, 20);
			formObj.upd_id.value = sheetObjects[0].CellValue(1, 24);
			formObj.upd_dt.value = sheetObjects[0].CellValue(1, 25);
			formObj.vsl_nm.value = sheetObjects[0].CellValue(1, 26);
			
			changeWhfVolDcCdbyPort();
		}
		break;
	case SEARCH02:      //조회
		if( validateForm(sheetObj,formObj,sAction) ){
			formObj.f_cmd.value = SEARCH02;
			var aryPrefix = new Array("sheet1_");
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0548GS.do",
					FormQueryString(formObj));
			
			var arrXml = sXml.split("|$$|");
			var brthKrNm = "";
			if (ComGetEtcData(arrXml[0], "brth_kr_nm") != "") {
				formObj.port_nm.value = ComGetEtcData(arrXml[0], "brth_kr_nm");
			}
		}
		
		changeWhfVolDcCdbyPort();
	break;	

	case MULTI: // Save
		IBS_CopyFormToRow(formObj, sheetObj, 1, "");
		changeWhfVolDcCdbyPort();
		break;
	case COMMAND02: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var sParam = ComGetSaveString(sheetObjects);
			sParam += "&" + FormQueryString(formObj) + "&"
					+ ComGetPrefixParam("sheet1_");
			var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0548GS.do", sParam);
			var xml = sheetObj.LoadSaveXml(SaveXml);
			ComOpenWait(false);
			
			changeWhfVolDcCdbyPort();
		}
		break;
	case COMMAND01: // New
		ComResetAll();
		ComSetFocus(formObj.vvd);
		break;
	case COMMAND03: // 팝업 - Korea Wharfage - Data Interface
		if (validateForm(sheetObj, formObj, sAction))
			ComOpenWindowCenter("ESM_BKG_0549.do?pgmNo=ESM_BKG_0549" + "&vvd="
					+ formObj.vvd.value + "&whf_pol_cd="
					+ formObj.vps_port_cd.value + "&whf_bnd_cd="
					+ formObj.io_bnd_cd.value + "&mrn_no="
					+ formObj.mrn_no.value, "ESM_BKG_0549", 650, 550, false);
		break;
	case COMMAND04: // 팝업 - Wharfage Vessel Information - Location Code
		if (validateForm(sheetObj, formObj, sAction))
			ComOpenWindowCenter("ESM_BKG_0733.do?pgmNo=ESM_BKG_0733"
					+ "&loc_cd=" + formObj.vps_port_cd.value, "ESM_BKG_0733",
					400, 540, false);
		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	var vvd = formObj.vvd.value;
	var vpsPortCd = formObj.vps_port_cd.value;
	var ioBndCd = formObj.io_bnd_cd.value;

	switch (sAction) {
	case SEARCH01:

		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00887', 'vvd');
			formObj.vvd.focus();
			return false;
		}

		if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00887', 'Port');
			formObj.vps_port_cd.focus();
			return false;
		}

		return true;
		break;
	case SEARCH02:
			
		return true;
		break;

	case SEARCH:
		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00887', 'VVD');
			return false;
		}
		if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00887', 'Port');
			return false;
		}
		return true;
		break;

	case MULTI: // 저장
		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00715', 'VVD');
			formObj.vvd.focus();
			return false;
		} else if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00715', 'Port');
			formObj.vps_port_cd.focus();
			return false;
		}

		if (!ComShowConfirm(ComGetMsg("BKG00498")))
			return false;

		return true;
		break;
	case COMMAND02: // 저장

		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00715', 'VVD');
			formObj.vvd.focus();
			return false;
		} else if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00715', 'Port');
			formObj.vps_port_cd.focus();
			return false;
		}

		return true;
		break;
	case COMMAND01: // 화면 초기화
		if (sheetObjects[0].IsDataModified) {

			if (!ComShowConfirm(ComGetMsg("BKG00386"))) {
				return true;
			} else {
				return false;
			}
		}
		return true;
		break;
	case COMMAND03: // 화면 초기화

		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00887', 'vvd');
			formObj.vvd.focus();
			return false;
		}

		if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00887', 'Port');
			formObj.vps_port_cd.focus();
			return false;
		}

		return true;
		break;
	case COMMAND04: // 화면 초기화
		return true;
		break;

	}
}

/**
 * 반출입부두 콤보박스 제어 메서드.
 * @return
 */
function moveIoPortCd() {
	document.form.io_port_cd.focus();
}

/**
 * 반출입부두의 콤보박스 이벤트 처리 메서드. 
 */
function io_port_cd_OnChange(comboObj, value, text){
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
}
 
 /**
  * 조회조건 바꿀때 시트 초기화
  * @return
  */
 function obj_Change() {
 	var formObject = document.form;
 	var srcName = window.event.srcElement.getAttribute("name");
 	if (srcName == "io_bnd_cd") { 		
 		var vvd = formObject.vvd.value
 		var vps_port_cd = formObject.vps_port_cd.value
 		var io_bnd_cd = formObject.io_bnd_cd.value
 		//var vps_dt = formObject.vps_dt.value
 		
 		ComResetAll();
 		
 		formObject.vvd.value = vvd;
 		formObject.vps_port_cd.value = vps_port_cd;
 		formObject.io_bnd_cd.value = io_bnd_cd;
 		//formObject.vps_dt.value = vps_dt;
 	}
 }

 /**
  * 2018.05.30 iylee Port가 KRKAN 이고 Outbound일 경우 할인율을 70%로 설정함.
  */
 function changeWhfVolDcCdbyPort(){
	 	var formObject = document.form;
		if(formObject.vps_port_cd.value == "KRKAN" && formObject.io_bnd_cd.value == "OO"){
			formObject.whf_vol_dc_cd.value = "8";
		} else {
			formObject.whf_vol_dc_cd.value = "0";
		}
 }

/* 개발자 작업 끝 */