/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0123.js
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
function esm_bkg_0123() {
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

var vvd;
var portCd;
var whfBndCd;
var whfRate;
var CustArry = new Array();
var isUpdInt = 'U';

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
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;

		case "btn_save":
			doActionIBSheet(sheetObjects[2], document.form, IBSAVE);

			break;

		case "btn_downexcel":
			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			break;

		case "btn_add1":
			sheetObject1.DataInsert(-1);
			break;

		case "btn_del1":
			doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
			break;

		case "btn_add2":
			sheetObjects[1].DataInsert(-1);
			break;

		case "btn_del2":
			doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
			break;

		case "btn_close":
			window.close();
			break;
		case "btn_new1":
			sheetObjects[0].RemoveAll();
			sheetObjects[0].DataInsert(-1);
			break;
		case "btn_new2":
			sheetObjects[1].RemoveAll();
			sheetObjects[1].DataInsert(-1);
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

	// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	initControl();

	// if( '' != document.form.bl_no.value )
	// isUpdInt = 'I';
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
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	ComSetObjValue(formObject.frm_whf_bnd_cd, formObject.whf_bnd_cd.value);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 160;
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

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(7, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			var HeadTitle1 = "|Sel.|Seq.|Container No.|TP|Seal No.|F/M";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = 'sheet1_';
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "Chk");
			InitDataProperty(0, cnt++, dtDataSeq, 30, daCenter, true, prefix + "SEQ", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 190, daLeft, true, prefix + "cntr_no", false, "", dfNone, 0, true, true, 14);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, prefix + "cntr_tpsz_cd", false, "", dfNone, 0, true, true, 2);

			InitDataProperty(0, cnt++, dtData, 115, daLeft, true, prefix + "cntr_seal_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix + "fm", false, "", dfNone, 0, true, true, 1);

			InitDataValid(0, prefix + "cntr_no", vtEngUpOther, "0123456789");
			InitDataValid(0, prefix + "cntr_tpsz_cd", vtEngUpOther,
					"0123456789");
			InitDataValid(0, prefix + "cntr_seal_no", vtEngUpOther,
					"0123456789");
			InitDataValid(0, prefix + "fm", vtEngUpOther, "");
		}
		break;

	case "sheet2": // sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 160;
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

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(5, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|Sel.|TP|Customer Name|Customer Address";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = 'sheet2_';
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, prefix + "Chk");
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, prefix + "bkg_cust_tp_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 210, daLeft, true, prefix + "cust_nm", false, "", dfNone, 0, true, true, 500);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, prefix + "cust_addr", false, "", dfNone, 0, true, true, 500);

			InitDataValid(0, prefix + "bkg_cust_tp_cd", vtEngUpOther, "");
			InitDataValid(0, prefix + "cust_nm", vtEngUpOther, "0123456789");
			InitDataValid(0, prefix + "cust_addr", vtEngUpOther, "0123456789");

			AutoRowHeight = false;

		}
		break;

	case "sheet3": // sheet2 init
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

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(23, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle1 = "|bl_no|bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|bkg_sts_cd|rcv_term_cd|de_term_cd|pck_qty|pck_tp_cd|act_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|revenue|amount|whf_bnd_cd|port_cd";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = 'sheet3_';
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bl_no",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_no",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "vsl_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "skd_voy_no", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "skd_dir_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pol_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pod_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "por_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "del_cd",	false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "bkg_sts_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rcv_term_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "de_term_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pck_qty",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pck_tp_cd",	false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "act_wgt",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "wgt_ut_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "meas_qty",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "meas_ut_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "revenue",	false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "amount",	false, "", dfFloat, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "whf_bnd_cd",	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "port_cd",	false, "", dfNone, 0, true, true);

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
			
			formObj.frm_pol_cd.value = '';
			formObj.frm_pod_cd.value = '';
			formObj.frm_por_cd.value = '';
			formObj.frm_del_cd.value = '';
			formObj.frm_bkg_sts_cd.value = '';
			formObj.frm_rcv_term_cd.value = '';
			formObj.frm_de_term_cd.value = '';			
			formObj.frm_pck_qty.value = '';
			formObj.frm_pck_tp_cd.value = '';
			formObj.frm_act_wgt.value = '';
			formObj.frm_wgt_ut_cd.value = '';
			formObj.frm_meas_qty.value = '';
			formObj.frm_meas_ut_cd.value = '';
			formObj.frm_revenue.value = '';
			formObj.frm_amount.value = '';
			
			formObj.f_cmd.value = SEARCH;

			var aryPrefix = new Array("sheet1_", "sheet2_", ""); // prefix
			// 문자열 배열
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0123GS.do",
					FormQueryString(formObj) + "&"
							+ ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 2) {
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				sheetObjects[2].LoadSearchXml(arrXml[2]);
			}

			if (sheetObjects[2].RowCount > 0) {
				IBS_CopyRowToForm(sheetObjects[2], formObj, 1, "frm_");
				document.getElementById("frm_pck_qty").value = CommaInputWithPoint(
						document.getElementById("frm_pck_qty").value, 3)
				document.getElementById("frm_act_wgt").value = ComAddComma3(
						CommaInputWithPoint(
								document.getElementById("frm_act_wgt").value, 3),
						"#,###.000");
				document.getElementById("frm_meas_qty").value = ComAddComma3(
						CommaInputWithPoint(
								document.getElementById("frm_meas_qty").value, 3),
						"#,###.000");
				document.getElementById("frm_revenue").value = ComAddComma3(
						document.getElementById("frm_revenue").value, "#,###.000");
				document.getElementById("frm_amount").value = CommaInputWithPoint(
						document.getElementById("frm_amount").value, 3);
/*				document.getElementById("vvd").value = document
						.getElementById("vsl_cd").value.
						+ document.getElementById("skd_voy_no").value
						+ document.getElementById("skd_dir_cd").value;*/
/*				document.getElementById("frm_port_cd").value = document
						.getElementById("frm_pol_cd").value;
				document.getElementById("frm_bkg_no").value = document
						.getElementById("frm_bkg_no").value;
				document.getElementById("frm_bl_no").value = document
						.getElementById("frm_bl_no").value;*/
			}

			/*
			 * 데이터 중복체크를 위해
			 */
			for ( var i = 1; i < sheetObjects[1].RowCount + 1; i++) {
				CustArry[i - 1] = sheetObjects[1].CellValue(i, 2);
			}

			/*
			 * BL 를 새롭게 추가할때 모든데이터를 저장하게끔 IBFLAG 를 'U' 로해준다.
			 */
			for ( var m = 0; m < sheetObjects[0].RowCount; m++) {
				sheetObjects[0].CellValue2(m + 1, 0) = 'U';
			}
			for ( var j = 0; j < sheetObjects[1].RowCount; j++) {
				sheetObjects[1].CellValue2(j + 1, 0) = 'U';
			}
		}
		break;

	case IBSAVE: // 저장
		if (validateForm(sheetObj, formObj, sAction)) {

			IBS_CopyFormToRow(formObj, sheetObjects[2], 1, "frm_");
			sheetObjects[2].CellValue2(1, "vsl_cd") = formObj.vvd.value.substring(0, 4);
			sheetObjects[2].CellValue2(1, "skd_voy_no") = formObj.vvd.value.substring(4, 8);
			sheetObjects[2].CellValue2(1, "skd_dir_cd") = formObj.vvd.value.substring(8, 9);
			sheetObjects[2].CellValue2(1, "port_cd") = formObj.port_cd.value;
			
			sheetObjects[2].CellValue2(1, 'amount') = sheetObjects[2]
					.CellValue(1, 'amount').split(",").join("");

			formObj.f_cmd.value = MULTI;
			var sParam1 = sheetObjects[0].GetSaveString();
			var sParam2 = sheetObjects[1].GetSaveString();
			var sParam3 = sheetObjects[2].GetSaveString();

			var aryPrefix = new Array("sheet1_", "sheet2_", ""); // prefix
			// 문자열 배열
			var sParam = ComGetSaveString(sheetObjects);
			sParam = sParam + "&" + FormQueryString(formObj) + "&"
					+ ComGetPrefixParam(aryPrefix);

//			alert(sParam);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0123GS.do", sParam);

			// XML 문자열을 인자로 받아 트랜잭션 대상 데이터에 각종 결과 처리를 완료하고, OnSaveEnd Event를
			// 발생한다.
			sheetObjects[0].LoadSaveXml(sXml);
			sXml = ComDeleteMsg(sXml); // / 넘어온 메시지는 한번만 보이고 싶을 때 사용
			sheetObjects[1].LoadSaveXml(sXml);
			sheetObjects[2].LoadSaveXml(sXml);

			opener.addRowSheet1(sheetObjects[2].CellValue(1, "bl_no"),
					sheetObjects[2].CellValue(1, "bkg_no"), sheetObjects[2]
							.CellValue(1, "vsl_cd")
							+ sheetObjects[2].CellValue(1, "skd_voy_no")
							+ sheetObjects[2].CellValue(1, "skd_dir_cd"),
					sheetObjects[2].CellValue(1, "pol_cd"), sheetObjects[2]
							.CellValue(1, "pod_cd"), formObj.whf_bnd_cd.value);
			window.close();

		}
		break;

	case IBDELETE: // 삭제
		var checked = 0;
		for ( var i = 1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, 1) == '1') {
				checked = 1;
				if (sheetObj.CellValue(i, 0) != "I") {
					sheetObj.RowHidden(i) = true;
					sheetObj.RowStatus(i) = "D";
				} else {
					if (sheetObj.CellValue(i, 1) == '1') {
						sheetObj.RowStatus(i) = "D";
						i--;
					}
				}
			}
		}
		if (checked == 0)
			ComShowCodeMessage('BKG00249');

		break;
	case IBDOWNEXCEL:
		if (sheetObj.RowCount > 0)
			sheetObjects[0].Down2Excel(-1, false, false, true, "", "", false,
					false, "", true, "sheet1_Chk");
		else
			ComShowCodeMessage('BKG00389');

		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
	/*
	 * if ('y' == formObj.popup.value && (formObj.bl_no.value == "" ||
	 * formObj.bkg_no.value == "")) { formObj.popup.value = ''; return false; }
	 */

		if (formObj.frm_bl_no.value == "" && formObj.frm_bkg_no.value == "") {
			if (formObj.frm_bl_no.value == "") {
				ComShowCodeMessage("BKG00887", "B/L No");
				return false;
			}

			if (formObj.frm_bkg_no.value == "") {
				ComShowCodeMessage("BKG00887", "BKG No");
				return false;
			}
		}
		return true;
		break;
	case IBSAVE: // 저장
		if (formObj.frm_bl_no.value == "" || formObj.frm_bkg_no.value == "") {
			ComShowCodeMessage('BKG00104');
			return false;
		}
		if ((!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified)) {
			ComShowCodeMessage('BKG00743');
			return false;
		}

		/*
		 * 필수 입력 체크
		 */
		if (sheetObjects[0].IsDataModified == false) {
			var chk1 = 0;
			for ( var i = 0; i < sheetObjects[0].RowCount; i++) {
				if (sheetObjects[0].CellValue(i + 1, 0) == 'U'
						|| sheetObjects[0].CellValue(i + 1, 0) == 'I') {
					if (sheetObjects[0].CellValue(i + 1, 3) == '') {
						ComShowCodeMessage('BKG00715', 'Container No');
						return false;
					}
					chk1 = 1;
				}
			}
			if (chk1 == 0) {
				ComShowCodeMessage('BKG00358');
				return false;
			}
			/*
			 * 데이터 중복체크
			 */
			var CntrArry = new Array();
			var CntrArry2 = new Array();

			var cntrCnt = 0;
			for ( var i = 0; i < sheetObjects[0].RowCount; i++) {
				if ('I' == sheetObjects[0].CellValue(i + 1, 0)
						|| 'U' == sheetObjects[0].CellValue(i + 1, 0)) {
					CntrArry[cntrCnt] = sheetObjects[0].CellValue(i + 1, 3);
					CntrArry2[cntrCnt] = sheetObjects[0].CellValue(i + 1, 3);
					cntrCnt++;
				}
			}
			for ( var j = 0; j < CntrArry.length; j++) {
				var duCnt = 0;
				for ( var h = 0; h < CntrArry2.length; h++) {
					if (CntrArry[j] == CntrArry2[h]) {
						duCnt++;
					}
				}
				// alert(duCnt);
				if (duCnt >= 2) {
					ComShowCodeMessage('BKG00764', 'Container No');
					return false;
				}
			}
		}

		/*
		 * 필수 입력 체크
		 */
		if (sheetObjects[1].IsDataModified) {

			var chk2 = 0;
			for ( var i = 0; i < sheetObjects[1].RowCount; i++) {
				if (sheetObjects[1].CellValue(i + 1, 0) == 'U'
						|| sheetObjects[1].CellValue(i + 1, 0) == 'I') {
					if (sheetObjects[1].CellValue(i + 1, 2) == '') {
						ComShowCodeMessage('BKG00715', 'TP');
						return false;
					}
					chk2 = 1;
				}
			}
			if (chk2 == 0) {
				ComShowCodeMessage('BKG00358');
				return false;
			}
			/*
			 * 데이터 중복체크
			 */
			var TempArry = new Array();
			var TempArry2 = new Array();

			var tempCnt = 0;
			for ( var i = 0; i < sheetObjects[1].RowCount; i++) {
				if ('I' == sheetObjects[1].CellValue(i + 1, 0)
						|| 'U' == sheetObjects[1].CellValue(i + 1, 0)) {
					TempArry[tempCnt] = sheetObjects[1].CellValue(i + 1, 2);
					TempArry2[tempCnt] = sheetObjects[1].CellValue(i + 1, 2);
					tempCnt++;
				}
			}
			for ( var j = 0; j < TempArry.length; j++) {
				var duCnt = 0;
				for ( var h = 0; h < TempArry2.length; h++) {
					if (TempArry[j] == TempArry2[h]) {
						duCnt++;
					}
				}
				if (duCnt >= 2) {
					ComShowCodeMessage('BKG00764', 'TP');
					return false;
				}
			}
		}

		// 바운드 코드 체크
		if ('' == formObj.frm_whf_bnd_cd.value) {
			ComShowCodeMessage('BKG00715', 'Tran Mode');
			return false;
		}

		return true;
		break;
	case IBDELETE: // 저장

		if (formObj.port_cd.value == "") {
			ComShowCodeMessage('BKG00266');
			formObj.port_cd.focus();
			return false;
		}

		return true;
		break;
	}
}

/**
 * 소숫점 체크
 */
function PointNumberFixed() {
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");
	document.getElementById(srcName).value = CommaInputWithPoint(srcValue, 3);
}

/* 개발자 작업 끝 */