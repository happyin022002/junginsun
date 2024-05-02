/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_6096.js
 *@FileTitle : Rate Creation - Excel Import(Horizontal)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.30
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
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
 * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_6096() {
	this.processButtonClick = tprocessButtonClick;
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
var sheetObjects = new Array();
var sheetCnt = 0;

var bIsReqUsr = false;
var bIsAproUsr = false;

var isOViaMandatory = false;
var isDViaMandatory = false;
var isDirCallVisible = false;
var ratePortArray = new Array();
var obj_ratCargoTpCd = new Array({
	rat_ut_cd : 'D2',
	prc_cgo_tp_cd : 'DR',
	prop_frt_rt_amt : 'rate_dry20',
	prop_bof_amt : 'rate_bof_dry20',
	fic_prop_rt_amt : 'rate_prop_dry20',
	fic_gline_rt_amt : 'fic_gline_rt_amt_rate_dry20',
	fic_rt_use_sts_cd : 'fic_rt_use_sts_cd_rate_dry20',
	optm_trsp_mod_flg : 'optm_trsp_mod_flg_rate_dry20'
}, {
	rat_ut_cd : 'D4',
	prc_cgo_tp_cd : 'DR',
	prop_frt_rt_amt : 'rate_dry40',
	prop_bof_amt : 'rate_bof_dry40',
	fic_prop_rt_amt : 'rate_prop_dry40',
	fic_gline_rt_amt : 'fic_gline_rt_amt_rate_dry40',
	fic_rt_use_sts_cd : 'fic_rt_use_sts_cd_rate_dry40',
	optm_trsp_mod_flg : 'optm_trsp_mod_flg_rate_dry40'
}, {
	rat_ut_cd : 'D5',
	prc_cgo_tp_cd : 'DR',
	prop_frt_rt_amt : 'rate_dry40hc',
	prop_bof_amt : 'rate_bof_dry40hc',
	fic_prop_rt_amt : 'rate_prop_dry40hc',
	fic_gline_rt_amt : 'fic_gline_rt_amt_rate_dry40hc',
	fic_rt_use_sts_cd : 'fic_rt_use_sts_cd_rate_dry40hc',
	optm_trsp_mod_flg : 'optm_trsp_mod_flg_rate_dry40hc'
}, {
	rat_ut_cd : 'D7',
	prc_cgo_tp_cd : 'DR',
	prop_frt_rt_amt : 'rate_dry45',
	prop_bof_amt : 'rate_bof_dry45',
	fic_prop_rt_amt : 'rate_prop_dry45',
	fic_gline_rt_amt : 'fic_gline_rt_amt_rate_dry45',
	fic_rt_use_sts_cd : 'fic_rt_use_sts_cd_rate_dry45',
	optm_trsp_mod_flg : 'optm_trsp_mod_flg_rate_dry45'
}, {
	rat_ut_cd : 'R5',
	prc_cgo_tp_cd : 'RF',
	prop_frt_rt_amt : 'rate_rf40hc',
	prop_bof_amt : 'rate_bof_rf40hc',
	fic_prop_rt_amt : 'rate_prop_rf40hc',
	fic_gline_rt_amt : 'fic_gline_rt_amt_rate_rf40hc',
	fic_rt_use_sts_cd : 'fic_rt_use_sts_cd_rate_rf40hc',
	optm_trsp_mod_flg : 'optm_trsp_mod_flg_rate_rf40hc'
}, {
	rat_ut_cd : 'R5',
	prc_cgo_tp_cd : 'DR',
	prop_frt_rt_amt : 'rate_rd40hc',
	prop_bof_amt : 'rate_bof_rd40hc',
	fic_prop_rt_amt : 'rate_prop_rd40hc',
	fic_gline_rt_amt : 'fic_gline_rt_amt_rate_rd40hc',
	fic_rt_use_sts_cd : 'fic_rt_use_sts_cd_rate_rd40hc',
	optm_trsp_mod_flg : 'optm_trsp_mod_flg_rate_rd40hc'
});

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * processButtonClick();
 * </pre>
 * 
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
			if (getButtonTable(srcName).disabled) {
				return false;
			}
		}

		switch (srcName) {

		case "btn_openfile":
			var strFilePath = sheetObject1.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
			if (strFilePath != "<USER_CANCEL>") {
				sheetObject1.LoadExcel(-1, 1, strFilePath, -1, -1, "", false, false, "");
			}
			if (sheetObject1.RowCount > 0) {
				toggleButtons("LOAD");
			} else {
				toggleButtons("INIT");
			}
			break;

		case "btn_check":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
			break;

		case "btn_save":
			doActionIBSheet(sheetObject1, document.form, IBSAVE);
			break;

		case "btn_close":
			window.close();
			break;

		case "btn_Template":
			downform.submit();
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
 * IBSheet Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * setSheetObject(sheetObj);
 * </pre>
 * 
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * loadPage();
 * </pre>
 * 
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	toggleButtons("INIT");

	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
}

/**
 * OnKeyUp event를 처리한다. <br>
 * cell의 색이 빨간 색인 경우 cell을 선택한다. <br>
 * <b>Example :</b>
 * 
 * <pre>
 * sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift)
 * </pre>
 * 
 * @param {sheetObj} sheetObj
 * @param {int} Row
 * @param {int} Col
 * @param {String} KeyCode
 * @param {int} Shift
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
	if (!isClear && KeyCode == 9) {
		while (true) {
			Col++;
			if (Col > sheetObj.LastCol) {
				Row++;
				Col = 1;
			}
			if (Row > sheetObj.LastRow) {
				Row = sheetObj.HeaderRows;
			}
			if (sheetObj.CellBackColor(Row, Col) == sheetObj.RgbColor(255, 0, 0)) {
				sheetObj.SelectCell(Row, Col, false);
				break;
			}
		}
	}
}

/**
 * sheet에서 값이 바뀐 경우 발생한다. <br>
 * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
 * src_info_cd 값을 세팅한다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row
 * @param {int} Col
 * @param {String} Value
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	if (colName == 'cmdt_dp_seq' || colName == 'rout_dp_seq') {
		if (colName == 'cmdt_dp_seq') {
			if (!funcDupCheckCmdtSeq(sheetObj, Row, Value)) {
				ComShowCodeMessage("PRI00303", 'CMDT Seq', Value);
				return false;
			}
		}
		sheet1_OnLoadExcel(sheetObj);
	} else if (colName == "prc_cmdt_def_cd") {
		if (Value.length == 6) {
			formObj.f_cmd.value = SEARCH08;
			var param = "&cd=" + Value;
			var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
				sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
				sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
				return false;
			}
		} else if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH10;
			var param = "&cd=" + Value + "&nm=rq" + "&etc1=" + formObj.qttn_no.value + "&etc2=" + formObj.qttn_ver_no.value;
			var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
				sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
				sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
				return false;
			}
		} else if (Value.length == 4) {
			formObj.f_cmd.value = COMMAND29;
			var param = "&cd=" + Value;
			var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
				sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
				sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
				return false;
			}
		} else {
			sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
			sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
			sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
			return false;
		}
	} else if (colName == "org_rout_pnt_loc_def_cd") {
		if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			var param = "&cd=" + Value;
			var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
				sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
				initFicRoute(sheetObj, Row, Col);
				return false;
			}
		} else if (Value.length == 4) {
			formObj.f_cmd.value = SEARCH11;
			var param = "&cd=" + Value + "&nm=rq" + "&etc1=" + formObj.qttn_no.value + "&etc2=" + formObj.qttn_ver_no.value;
			var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
				sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
				initFicRoute(sheetObj, Row, Col);
				return false;
			}
		} else {
			sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
			sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
			sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
			initFicRoute(sheetObj, Row, Col);
			return false;
		}
		initFicRoute(sheetObj, Row, Col);
	} else if (colName == "dest_rout_pnt_loc_def_cd") {
		if (Value.length == 5) {
			formObj.f_cmd.value = SEARCH05;
			var param = "&cd=" + Value;
			var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
				sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
				initFicRoute(sheetObj, Row, Col);
				return false;
			}
		} else if (Value.length == 4) {
			formObj.f_cmd.value = SEARCH11;
			var param = "&cd=" + Value + "&nm=rq" + "&etc1=" + formObj.qttn_no.value + "&etc2=" + formObj.qttn_ver_no.value;
			var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
			} else {
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
				sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
				initFicRoute(sheetObj, Row, Col);
				return false;
			}
		} else {
			sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
			sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
			sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
			initFicRoute(sheetObj, Row, Col);
			return false;
		}
		initFicRoute(sheetObj, Row, Col);
	} else if (colName == 'org_prc_trsp_mod_nm') {
		if (formObj.svc_scp_cd.value == 'AEE') {
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		}
	} else if (colName == 'dest_prc_trsp_mod_nm') {
		if (formObj.svc_scp_cd.value == 'AEW') {
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		}
	} else if (colName == "org_rcv_de_term_nm") {
		if (formObj.svc_scp_cd.value == 'AEE') {
			initFicRoute(sheetObj, Row, Col);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
		}
	} else if (colName == "dest_rcv_de_term_nm") {
		if (formObj.svc_scp_cd.value == 'AEW') {
			initFicRoute(sheetObj, Row, Col);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
		}
	} else if (colName == "org_rout_via_port_def_cd") {
		if (formObj.svc_scp_cd.value == 'AEE') {
			if (sheetObj.CellValue(Row, 'org_rout_pnt_loc_def_cd') != '') {
				initFicRoute(sheetObj, Row, Col);
				doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC07);
				doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
			}
		}
	} else if (colName == "dest_rout_via_port_def_cd") {
		if (formObj.svc_scp_cd.value == 'AEW') {
			if (sheetObj.CellValue(Row, 'dest_rout_pnt_loc_def_cd') != '') {
				initFicRoute(sheetObj, Row, Col);
				doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC07);
				doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
			}
		}
	} else if (colName == "rate_dry20" || colName == 'rate_prop_dry20') {
		funcSheet1_Change_SetRate(sheetObj, Row, 'rate_dry20', 'rate_bof_dry20', 'rate_prop_dry20', 'fic_gline_rt_amt_rate_dry20');
	} else if (colName == "rate_dry40" || colName == 'rate_prop_dry40') {
		funcSheet1_Change_SetRate(sheetObj, Row, 'rate_dry40', 'rate_bof_dry40', 'rate_prop_dry40', 'fic_gline_rt_amt_rate_dry40');
	} else if (colName == "rate_dry40hc" || colName == 'rate_prop_dry40hc') {
		funcSheet1_Change_SetRate(sheetObj, Row, 'rate_dry40hc', 'rate_bof_dry40hc', 'rate_prop_dry40hc', 'fic_gline_rt_amt_rate_dry40hc');
	} else if (colName == "rate_dry45" || colName == 'rate_prop_dry45') {
		funcSheet1_Change_SetRate(sheetObj, Row, 'rate_dry45', 'rate_bof_dry45', 'rate_prop_dry45', 'fic_gline_rt_amt_rate_dry45');
	} else if (colName == "rate_rf40hc" || colName == 'rate_prop_rf40hc') {
		funcSheet1_Change_SetRate(sheetObj, Row, 'rate_rf40hc', 'rate_bof_rf40hc', 'rate_prop_rf40hc', 'fic_gline_rt_amt_rate_rf40hc');
	} else if (colName == "rate_rd40hc" || colName == 'rate_prop_rd40hc') {
		funcSheet1_Change_SetRate(sheetObj, Row, 'rate_rd40hc', 'rate_bof_rd40hc', 'rate_prop_rd40hc', 'fic_gline_rt_amt_rate_rd40hc');
	}
}

/**
 * Rate에 따른 BOF 및 IHC 금액 셋팅.
 */
function funcSheet1_Change_SetRate(sheetObj, Row, rateAmt, bofAmt, ihcAmt, guideRtAmt) {
	if (sheetObj.CellValue(Row, rateAmt) == '' || sheetObj.CellValue(Row, rateAmt) == 0) {
		sheetObj.CellValue2(Row, rateAmt) = '';
		sheetObj.CellValue2(Row, bofAmt) = '';
		sheetObj.CellValue2(Row, ihcAmt) = '';
	} else {
		if (sheetObj.CellValue(Row, ihcAmt) == '' || sheetObj.CellValue(Row, ihcAmt) == 0) {
			if (sheetObj.CellValue(Row, guideRtAmt) == 'N/A') {
				sheetObj.CellValue2(Row, ihcAmt) = 0.00;
			} else {
				sheetObj.CellValue2(Row, ihcAmt) = sheetObj.CellValue(Row, guideRtAmt);
			}
		}
		sheetObj.CellValue2(Row, bofAmt) = sheetObj.CellValue(Row, rateAmt) - sheetObj.CellValue(Row, ihcAmt);
	}
}

/**
 * OnDblClick event를 처리한다. <br>
 * 더블클릭시 해당 팝업을 호춣한다.<br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * sheet1_OnDblClick(sheetObj, Row, Col)
 * </pre>
 * 
 * @param {sheetObj} sheetObj
 * @param {int} Row
 * @param {int} Col
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	if (colName == "prc_cmdt_def_nm") {
		var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
		sUrl += "&grp_cd=" + PRI_RQ + "&commodity_cmd=CG&prc_cmdt_tp_cd=C";
		sUrl += "&prc_cmdt_def_nm=" + sheetObj.CellValue(Row, Col);

		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 304, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = rtnVal.cd;
			sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = rtnVal.nm;
		}
	} else if (colName == "org_rout_pnt_loc_def_nm") {
		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
		sUrl += "&group_cmd=" + PRI_RQ + "&location_cmd=LG&loc_tp_cd=L";
		sUrl += "&loc_def_nm=" + sheetObj.CellValue(Row, Col);

		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = rtnVal.cd;
			sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = rtnVal.nm;
		}
	} else if (colName == "dest_rout_pnt_loc_def_nm") {
		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
		sUrl += "&group_cmd=" + PRI_RQ + "&location_cmd=LG&loc_tp_cd=L";
		sUrl += "&loc_def_nm=" + sheetObj.CellValue(Row, Col);

		var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = rtnVal.cd;
			sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = rtnVal.nm;
		}
	}
}

/**
 * Sheet관련 프로세스 처리 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
			ComOpenWait(true);
		}
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {

		case IBSEARCH_ASYNC01: // Check
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}
			break;
		case IBSEARCH_ASYNC06: // Search FIC Route
			funcGetBasePortList(sheetObj, formObj, sheetObj.SelectRow);
			break;
		case IBSEARCH_ASYNC07: // Search FIC Route
			funcGetBasePortTrspModeCd(sheetObj, formObj, sheetObj.SelectRow);
			break;
		case IBSEARCH_ASYNC08: // Guide Line 정보 조회
			sheet3_setting(sheetObj, formObj, sheetObj.SelectRow, false);
			sheetObjects[2].ColumnSort('h_seq', "ASC");
			var org_seq = sheetObjects[0].CellValue(sheetObj.SelectRow, "cmdt_rout");
			for ( var i = sheetObj.HeaderRows; i < sheetObj.Rows; i++) {
				if (org_seq == sheetObjects[0].CellValue(i, "cmdt_rout") && sheetObjects[0].CellValue(i, "rout_dp_seq") != '') {
					funcGuideLineAmount(sheetObj, i);
				}
			}

			break;

		case IBSEARCH_ASYNC19: // PORT 조회를 위한
			var sXml = "";
			formObj.f_cmd.value = SEARCH23;
			sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			ratePortArray = ComPriXml2Array(sXml, "loc_cd");
			break;

		case IBSAVE: // Save
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}

			if (!ComPriConfirmSave()) {
				return false;
			}

			var svcScpCd = formObj.svc_scp_cd.value;
			for ( var i = sheetObj.HeaderRows; i < sheetObj.Rows; i++) {
				sheetObj.CellValue2(i, 'fic_rout_cmb_tp_cd') = sheetObjects[2].CellValue(sheetObjects[2].FindText('h_seq', sheetObj.CellValue(i, 'h_seq')), 'fic_rout_cmb_tp_cd');
				if (svcScpCd == 'AEE') {
					sheetObj.CellValue2(i, 'bse_port_loc_cd') = sheetObj.CellValue(i, 'org_rout_via_port_def_cd');
					sheetObj.CellValue2(i, 'group_no') = sheetObj.CellValue(i, 'group_no_1');
				} else {
					sheetObj.CellValue2(i, 'bse_port_loc_cd') = sheetObj.CellValue(i, 'dest_rout_via_port_def_cd');
					sheetObj.CellValue2(i, 'group_no') = sheetObj.CellValue(i, 'group_no_2');
				}
			}

			try {
				for ( var i = 0; i < sheetObjects.length; i++) {
					sheetObjects[i].WaitImageVisible = false;
				}
				formObj.f_cmd.value = MODIFY01;
				var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();

				var sXml = sheetObj.GetSaveXml("ESM_PRI_6096GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);
			} catch (e) {
				if (e == "[object Error]") {
					ComShowMessage(OBJECT_ERROR);
				} else {
					ComShowMessage(e);
				}
			} finally {
			}

			if (sXml.indexOf("ERROR") >= 0) {
				return false;
			}

			dialogArguments.reSearch();

			ComPriSaveCompleted();

			window.close();
			break;

		case IBCLEAR: // 화면 로딩시
			sheetObj.WaitImageVisible = false;
			var sXml = "";

			// 공통 Term Origin
			formObj.f_cmd.value = SEARCH19;
			sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
			setIBCombo(sheetObj, sXml, "org_rcv_de_term_nm", true, 0);

			// 공통 Term Destination
			formObj.f_cmd.value = SEARCH19;
			sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
			setIBCombo(sheetObj, sXml, "dest_rcv_de_term_nm", true, 0);

			// 공통 Trans. Mode
			formObj.f_cmd.value = SEARCH19;
			sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
			setIBCombo(sheetObj, sXml, "org_prc_trsp_mod_nm", true, 0);
			setIBCombo(sheetObj, sXml, "dest_prc_trsp_mod_nm", true, 0);

			sheetObj.WaitImageVisible = true;
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false);
	}
}

var isClear = true;

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * if (validateForm(sheetObj, document.form, IBSAVE)) {
 * 	로직처리;
 * }
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @returns bool <br>
 *          true : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 이승준
 * @version 2009.08.27
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH_ASYNC01: // Check
		if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
			return false;
		}
		if (sheetObj.RowCount <= 0) {
			return false;
		}
		if (formObj.qttn_sts_cd.value != "N") {
			return false;
		}

		isClear = true;

		var prevCmdtRow = sheetObj.HeaderRows;
		var prevRouteRow = sheetObj.HeaderRows;
		var prevRouteRowOPnt = sheetObj.HeaderRows;
		var prevRouteRowOVia = sheetObj.HeaderRows;
		var prevRouteRowDVia = sheetObj.HeaderRows;
		var prevRouteRowDPnt = sheetObj.HeaderRows;
		var prevRouteRowRate = sheetObj.HeaderRows;

		var chkMdtryCmdt = true;
		var chkMdtryOrgPnt = true;
		var chkMdtryOrgVia = true;
		var chkMdtryDestVia = true;
		var chkMdtryDestPnt = true;

		var rateDry20 = 0;
		var rateDry40 = 0;
		var rateDry40hc = 0;
		var rateDry45 = 0;
		var rateRf40hc = 0;
		var rateRd40hc = 0;

		var svcScpCd = formObj.svc_scp_cd.value;

		var isOViaMandatory = false;
		var isDViaMandatory = false;
		if (svcScpCd == "TPE") {
			isOViaMandatory = true;
			isDViaMandatory = true;
		}
		try {
			for ( var i = 0; i < sheetObjects.length; i++) {
				sheetObjects[i].WaitImageVisible = false;
			}
			clearTooltip();

			for ( var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows + sheetObj.RowCount; i < n; i++) {
				// Commodity Group Mendatory Check.
				if (sheetObj.CellValue(i, "cmdt_dp_seq") != "") {
					if (!chkMdtryCmdt) {
						add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
						isClear = false;
						prevCmdtRow = i;
					} else {
						chkMdtryCmdt = false;
						prevCmdtRow = i;
					}
				}

				// Commodity Check.
				var cmdtCode = sheetObj.CellValue(i, "prc_cmdt_def_cd");
				var cmdtDesc = sheetObj.CellValue(i, "prc_cmdt_def_nm");

				if (cmdtCode != "" || cmdtDesc != "") {
					chkMdtryCmdt = true;
					if (cmdtCode != "") {

						if (cmdtCode.length != 6 && cmdtCode.length != 5 && cmdtCode.length != 4) {
							add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00314", "4 ~ 6"));
							isClear = false;
						}
					}
					if (cmdtCode == "" && cmdtDesc != "") {
						add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
						isClear = false;
					}
				}

				// Origin Point Mendatory Check.
				if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
					if (!chkMdtryOrgPnt) {
						add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
						isClear = false;
						prevRouteRowOPnt = i;
					} else {
						chkMdtryOrgPnt = false;
						prevRouteRowOPnt = i;
					}
				}

				// Origin Point Check.
				var orgPntCode = sheetObj.CellValue(i, "org_rout_pnt_loc_def_cd");
				var orgPntDesc = sheetObj.CellValue(i, "org_rout_pnt_loc_def_nm");
				var orgPntTerm = sheetObj.CellValue(i, "org_rcv_de_term_nm");
				var orgPntTrans = sheetObj.CellValue(i, "org_prc_trsp_mod_nm");
				// Origin Code가 not null일경우 term이 필수 입력이 된다.
				if (orgPntCode != "" && orgPntTerm == "") {
					add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00316", "Origin Term"));
					isClear = false;
				}
				if (orgPntCode != "" || orgPntDesc != "" || orgPntTerm != "" || sheetObj.CellText(i, "org_rcv_de_term_nm").trim() != "" || orgPntTrans != ""
						|| sheetObj.CellText(i, "org_prc_trsp_mod_nm").trim() != "") {
					chkMdtryOrgPnt = true;

					if (orgPntCode != "") {
						if (orgPntCode.length != 5 && orgPntCode.length != 4) {
							add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
							isClear = false;
						}
					} else {
						add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Origin Code"));
						isClear = false;
					}
				}

				// Origin Via Mendatory Check.
				if (isOViaMandatory && sheetObj.CellValue(i, "rout_dp_seq") != "") {
					if (!chkMdtryOrgVia) {
						add2Tooltip(prevRouteRowOVia, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
						isClear = false;
						prevRouteRowOVia = i;
					} else {
						chkMdtryOrgVia = false;
						prevRouteRowOVia = i;
					}
				}

				// Origin Via Check.
				var orgViaCode = sheetObj.CellValue(i, "org_rout_via_port_def_cd");
				if (orgViaCode != "") {
					chkMdtryOrgVia = true;

					if (orgViaCode.length != 5 && orgViaCode.length != 4) {
						add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
						isClear = false;
					}
				}

				// Destination Via Mendatory Check.
				if (isDViaMandatory && sheetObj.CellValue(i, "rout_dp_seq") != "") {
					if (!chkMdtryDestVia) {
						add2Tooltip(prevRouteRowDVia, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
						isClear = false;
						prevRouteRowDVia = i;
					} else {
						chkMdtryDestVia = false;
						prevRouteRowDVia = i;
					}
				}

				// Destination Via Check.
				var destViaCode = sheetObj.CellValue(i, "dest_rout_via_port_def_cd");
				if (destViaCode != "") {
					chkMdtryDestVia = true;

					if (destViaCode.length != 5 && destViaCode.length != 4) {
						add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
						isClear = false;
					}
				}

				// Destination Point Mendatory Check.
				if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
					if (!chkMdtryDestPnt) {
						add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
						isClear = false;
						prevRouteRowDPnt = i;
					} else {
						chkMdtryDestPnt = false;
						prevRouteRowDPnt = i;
					}
				}

				// Destination Point Check.
				var destPntCode = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_cd");
				var destPntDesc = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_nm");
				var destPntTerm = sheetObj.CellValue(i, "dest_rcv_de_term_nm");
				var destPntTrans = sheetObj.CellValue(i, "dest_prc_trsp_mod_nm");

				// dest Code가 not null일경우 term이 필수 입력이 된다.
				if (destPntCode != "" && destPntTerm == "") {
					add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00316", "Destination Term"));
					isClear = false;
				}
				if (destPntCode != "" || destPntDesc != "" || destPntTerm != "" || sheetObj.CellText(i, "dest_rcv_de_term_nm").trim() != "" || destPntTrans != ""
						|| sheetObj.CellText(i, "dest_prc_trsp_mod_nm").trim() != "") {
					chkMdtryDestPnt = true;
					if (destPntCode != "") {

						if (destPntCode.length == 5) {
							formObj.f_cmd.value = SEARCH05;
							var param = "&cd=" + destPntCode;
							var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
							var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
							if (arrData == null || arrData.length <= 0) {
								add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
								isClear = false;
							}
						} else if (destPntCode.length == 4) {
							formObj.f_cmd.value = SEARCH11;
							var param = "&cd=" + destPntCode + "&nm=rq" + "&etc1=" + formObj.qttn_no.value + "&etc2=" + formObj.qttn_ver_no.value;
							var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
							var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

							if (arrData == null || arrData.length <= 0) {
								add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
								isClear = false;
							}
						} else {
							add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
							isClear = false;
						}
					} else {
						add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Destination Code"));
						isClear = false;
					}
				}

				// Rate Check.
				var rateDry20 = sheetObj.CellValue(i, "rate_dry20");
				var rateDry40 = sheetObj.CellValue(i, "rate_dry40");
				var rateDry40hc = sheetObj.CellValue(i, "rate_dry40hc");
				var rateDry45 = sheetObj.CellValue(i, "rate_dry45");
				var rateRf40hc = sheetObj.CellValue(i, "rate_rf40hc");
				var rateRd40hc = sheetObj.CellValue(i, "rate_rd40hc");

				// Rate - IHC Check
				var ratePropDry20 = sheetObj.CellValue(i, "rate_prop_dry20");
				var ratePropDry40 = sheetObj.CellValue(i, "rate_prop_dry40");
				var ratePropDry40hc = sheetObj.CellValue(i, "rate_prop_dry40hc");
				var ratePropDry45 = sheetObj.CellValue(i, "rate_prop_dry45");
				var ratePropRf40hc = sheetObj.CellValue(i, "rate_prop_rf40hc");
				var ratePropRd40hc = sheetObj.CellValue(i, "rate_prop_rd40hc");

				// Rate Mendatory Check.
				if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
					prevRouteRowRate = i;

					var rateDry20 = sheetObj.CellValue(i, "rate_dry20");
					var rateDry40 = sheetObj.CellValue(i, "rate_dry40");
					var rateDry40hc = sheetObj.CellValue(i, "rate_dry40hc");
					var rateDry45 = sheetObj.CellValue(i, "rate_dry45");
					var rateRf40hc = sheetObj.CellValue(i, "rate_rf40hc");
					var rateRd40hc = sheetObj.CellValue(i, "rate_rd40hc");

					if (rateDry20 == "" && rateDry40 == "" && rateDry40hc == "" && rateDry45 == "" && rateRf40hc == "" && rateRd40hc == "") {
						add2Tooltip(prevRouteRowRate, "rate_dry20", ComGetMsg("PRI00316", "Rate"));
						add2Tooltip(prevRouteRowRate, "rate_dry40", ComGetMsg("PRI00316", "Rate"));
						add2Tooltip(prevRouteRowRate, "rate_dry40hc", ComGetMsg("PRI00316", "Rate"));
						add2Tooltip(prevRouteRowRate, "rate_dry45", ComGetMsg("PRI00316", "Rate"));
						add2Tooltip(prevRouteRowRate, "rate_rf40hc", ComGetMsg("PRI00316", "Rate"));
						add2Tooltip(prevRouteRowRate, "rate_rd40hc", ComGetMsg("PRI00316", "Rate"));
						isClear = false;
					}
				}

				if (rateDry20 != "") {
					if (rateDry20 != "" && parseFloat(rateDry20) <= 0.00) {
						add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (rateDry20 != "" && parseFloat(rateDry20) >= 9999999.99) {
						add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}

					if (ratePropDry20 != "" && parseFloat(ratePropDry20) <= 0.00) {
						add2Tooltip(i, "rate_prop_dry20", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (ratePropDry20 != "" && parseFloat(ratePropDry20) >= 9999999.99) {
						add2Tooltip(i, "rate_prop_dry20", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}
				}

				if (rateDry40 != "") {
					if (rateDry40 != "" && parseFloat(rateDry40) <= 0.00) {
						add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (rateDry40 != "" && parseFloat(rateDry40) >= 9999999.99) {
						add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}

					if (ratePropDry40 != "" && parseFloat(ratePropDry40) <= 0.00) {
						add2Tooltip(i, "rate_prop_dry40", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (ratePropDry40 != "" && parseFloat(ratePropDry40) >= 9999999.99) {
						add2Tooltip(i, "rate_prop_dry40", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}
				}

				if (rateDry40hc != "") {
					if (rateDry40hc != "" && parseFloat(rateDry40hc) <= 0.00) {
						add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (rateDry40hc != "" && parseFloat(rateDry40hc) >= 9999999.99) {
						add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}

					if (ratePropDry40hc != "" && parseFloat(ratePropDry40hc) <= 0.00) {
						add2Tooltip(i, "rate_prop_dry40hc", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (ratePropDry40hc != "" && parseFloat(ratePropDry40hc) >= 9999999.99) {
						add2Tooltip(i, "rate_prop_dry40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}
				}

				if (rateDry45 != "") {
					if (rateDry45 != "" && parseFloat(rateDry45) <= 0.00) {
						add2Tooltip(i, "rate_dry45", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (rateDry45 != "" && parseFloat(rateDry45) >= 9999999.99) {
						add2Tooltip(i, "rate_dry45", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}

					if (ratePropDry45 != "" && parseFloat(ratePropDry45) <= 0.00) {
						add2Tooltip(i, "rate_prop_dry45", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (ratePropDry45 != "" && parseFloat(ratePropDry45) >= 9999999.99) {
						add2Tooltip(i, "rate_prop_dry45", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}
				}

				if (rateRf40hc != "") {
					if (rateRf40hc != "" && parseFloat(rateRf40hc) <= 0.00) {
						add2Tooltip(i, "rate_rf40hc", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (rateRf40hc != "" && parseFloat(rateRf40hc) >= 9999999.99) {
						add2Tooltip(i, "rate_rf40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}

					if (ratePropRf40hc != "" && parseFloat(ratePropRf40hc) <= 0.00) {
						add2Tooltip(i, "rate_prop_rf40hc", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (ratePropRf40hc != "" && parseFloat(ratePropRf40hc) >= 9999999.99) {
						add2Tooltip(i, "rate_prop_rf40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}
				}

				if (rateRd40hc != "") {
					if (rateRd40hc != "" && parseFloat(rateRd40hc) <= 0.00) {
						add2Tooltip(i, "rate_rd40hc", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (rateRd40hc != "" && parseFloat(rateRd40hc) >= 9999999.99) {
						add2Tooltip(i, "rate_rd40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}

					if (ratePropRd40hc != "" && parseFloat(ratePropRd40hc) <= 0.00) {
						add2Tooltip(i, "rate_prop_rd40hc", ComGetMsg("PRI00321", "Rate", "0"));
						isClear = false;
					} else if (ratePropRd40hc != "" && parseFloat(ratePropRd40hc) >= 9999999.99) {
						add2Tooltip(i, "rate_prop_rd40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
						isClear = false;
					}
				}

				/**
				 * MDM_LOCATION CALL_PORT_FLG='Y'인경우는 입력 불가 <BR>
				 * 단 Term이 Door인 경우는 제외.
				 */
				if (formObj.svc_scp_cd.value == 'AEE') {
					var org_rout_pnt_loc_def_cd = sheetObj.CellValue(i, "org_rout_pnt_loc_def_cd");
					var org_rcv_de_term_nm = sheetObj.CellValue(i, "org_rcv_de_term_nm");
					var org_prc_trsp_mod_nm = sheetObj.CellValue(i, "org_prc_trsp_mod_nm");
					var org_rout_via_port_def_cd = sheetObj.CellValue(i, "org_rout_via_port_def_cd");

					var dest_rout_pnt_loc_def_cd = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_cd");
					var dest_rcv_de_term_nm = sheetObj.CellValue(i, "dest_rcv_de_term_nm");
					var dest_prc_trsp_mod_nm = sheetObj.CellValue(i, "dest_prc_trsp_mod_nm");
					var dest_rout_via_port_def_cd = sheetObj.CellValue(i, "dest_rout_via_port_def_cd");

					if (org_rcv_de_term_nm != 'D') {
						if (org_rout_pnt_loc_def_cd != '') {
							if (org_rout_pnt_loc_def_cd.length == 5) {
								if (ratePortArray.toString().indexOf(org_rout_pnt_loc_def_cd) > -1) {
									add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI07020"));
									isClear = false;
								}
							}

							if (!funcCheckGroupNo(i, sheetObj.CellValue(i, "group_no_1"))) {
								add2Tooltip(i, "group_no_1", ComGetMsg("PRI07019"));
								isClear = false;
							}
						}
					}
					// 같은 LOCATION GROUP만 여러건 넣을수 있다. ROUTE POPUP에서 서로 다른 LOCATION을 넣으려 할때
					if (org_rout_pnt_loc_def_cd != '') {
						if (!funcCheckGroupNo(i, sheetObj.CellValue(i, "group_no_1"))) {
							add2Tooltip(i, "group_no_1", ComGetMsg("PRI07019"));
							isClear = false;
						}

						if (org_rcv_de_term_nm == '') {
							add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00316", 'Origin Term'));
							isClear = false;
						}
						if (org_prc_trsp_mod_nm == '') {
							add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00316", 'Origin Transmode'));
							isClear = false;
						}
						if (org_rout_via_port_def_cd == '') {
							add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", 'Origin Via'));
							isClear = false;
						}
						if (!funcDupCheckIHC(sheetObj, sheetObj.CellValue(i, 'cmdt_rout'), i, true, 'O', org_rout_pnt_loc_def_cd, org_rcv_de_term_nm, org_prc_trsp_mod_nm, org_rout_via_port_def_cd)) {
							add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00302"));
							add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00302"));
							add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00302"));
							add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00302"));
							isClear = false;
						}
					} else {
						if (sheetObj.CellValue(i, "org_rout_via_port_def_cd") != '') {
							add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", 'Origin Code'));
							isClear = false;
						}
					}
					if (dest_rout_pnt_loc_def_cd != '') {
						if (!funcDupCheckIHC(sheetObj, sheetObj.CellValue(i, 'cmdt_rout'), i, false, 'D', dest_rout_pnt_loc_def_cd, dest_rcv_de_term_nm, dest_prc_trsp_mod_nm,
								dest_rout_via_port_def_cd)) {
							add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00302"));
							add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00302"));
							add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00302"));
							isClear = false;
						}
					}

					if (dest_rout_via_port_def_cd != '') {
						if (!funcDupCheckVia(sheetObj, sheetObj.CellValue(i, 'cmdt_rout'), i, 'D', dest_rout_via_port_def_cd)) {
							add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00302"));
							isClear = false;
						}
					}
				} else if (formObj.svc_scp_cd.value == 'AEW') {
					var org_rout_pnt_loc_def_cd = sheetObj.CellValue(i, "org_rout_pnt_loc_def_cd");
					var org_rcv_de_term_nm = sheetObj.CellValue(i, "org_rcv_de_term_nm");
					var org_prc_trsp_mod_nm = sheetObj.CellValue(i, "org_prc_trsp_mod_nm");
					var org_rout_via_port_def_cd = sheetObj.CellValue(i, "org_rout_via_port_def_cd");

					var dest_rout_pnt_loc_def_cd = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_cd");
					var dest_rcv_de_term_nm = sheetObj.CellValue(i, "dest_rcv_de_term_nm");
					var dest_prc_trsp_mod_nm = sheetObj.CellValue(i, "dest_prc_trsp_mod_nm");
					var dest_rout_via_port_def_cd = sheetObj.CellValue(i, "dest_rout_via_port_def_cd");
					if (dest_rcv_de_term_nm != 'D') {
						if (dest_rout_pnt_loc_def_cd != '') {
							if (dest_rout_pnt_loc_def_cd.length == 5) {
								if (ratePortArray.toString().indexOf(dest_rout_pnt_loc_def_cd) > -1) {
									add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI07020"));
									isClear = false;
								}

							}
							if (!funcCheckGroupNo(i, sheetObj.CellValue(i, "group_no_2"))) {
								add2Tooltip(i, "group_no_2", ComGetMsg("PRI07019"));
								isClear = false;
							}
						}
					}

					// 같은 LOCATION GROUP만 여러건 넣을수 있다. ROUTE POPUP에서 서로 다른 LOCATION을 넣으려 할때
					if (dest_rout_pnt_loc_def_cd != '') {
						if (!funcCheckGroupNo(i, sheetObj.CellValue(i, "group_no_2"))) {
							add2Tooltip(i, "group_no_2", ComGetMsg("PRI07019"));
							isClear = false;
						}

						if (dest_rcv_de_term_nm == '') {
							add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00316", 'Destination Term'));
							isClear = false;
						}
						if (dest_prc_trsp_mod_nm == '') {
							add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00316", 'Destination Transmode'));
							isClear = false;
						}
						if (dest_rout_via_port_def_cd == '') {
							add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", 'Destination Via'));
							isClear = false;
						}

						if (!funcDupCheckIHC(sheetObj, sheetObj.CellValue(i, 'cmdt_rout'), i, true, 'D', dest_rout_pnt_loc_def_cd, dest_rcv_de_term_nm, dest_prc_trsp_mod_nm, dest_rout_via_port_def_cd)) {
							add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00302"));
							add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00302"));
							add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00302"));
							add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00302"));
							isClear = false;
						}
					} else {
						if (sheetObj.CellValue(i, "dest_rout_via_port_def_cd") != '') {
							add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", 'Destination Code'));
							isClear = false;
						}
					}

					if (org_rout_pnt_loc_def_cd != '') {
						if (!funcDupCheckIHC(sheetObj, sheetObj.CellValue(i, 'cmdt_rout'), i, false, 'O', org_rout_pnt_loc_def_cd, org_rcv_de_term_nm, org_prc_trsp_mod_nm, org_rout_via_port_def_cd)) {
							add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00302"));
							add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00302"));
							add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00302"));
							isClear = false;
						}
					}

					if (org_rout_via_port_def_cd != '') {
						if (!funcDupCheckVia(sheetObj, sheetObj.CellValue(i, 'cmdt_rout'), i, 'O', org_rout_via_port_def_cd)) {
							add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00302"));
							isClear = false;
						}
					}
				}
			}

			if (!chkMdtryCmdt) {
				add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
				isClear = false;
			}
			if (!chkMdtryOrgPnt) {
				add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
				isClear = false;
			}
			if (isOViaMandatory && !chkMdtryOrgVia) {
				add2Tooltip(prevRouteRowOVia, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
				isClear = false;
			}
			if (isDViaMandatory && !chkMdtryDestVia) {
				add2Tooltip(prevRouteRowDVia, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
				isClear = false;
			}
			if (!chkMdtryDestPnt) {
				add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
				isClear = false;
			}

			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
			var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_6056GS.do", sParam);
			var arrErr = ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
			if (arrErr != null && arrErr.length > 0) {
				isClear = false;
				var msg = ComGetMsg("PRI00315");
				for ( var i = 0; i < arrErr.length; i++) {
					add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows, arrErr[i][1], msg);
				}
			}
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		} finally {
		}

		document.body.scroll = "no";

		if (isClear) {
			toggleButtons("CHECK");
			return true;
		} else {
			toggleButtons("LOAD");
			selectCheckedCell();
			return false;
		}
		break;

	case IBSAVE: // 저장
		if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
			return false;
		}
		return true;
		break;
	}
}

/**
 * tooltip을 제거한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * clearTooltip()
 * </pre>
 * 
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function clearTooltip() {
	var sheetObj = sheetObjects[0];
	var n = sheetObj.Rows;
	var m = sheetObj.LastCol;
	var i = sheetObj.HeaderRows;
	var j = 0;
	for (i = sheetObj.HeaderRows; i < n; i++) {
		for (j = 0; j <= m; j++) {
			if (sheetObj.ToolTipText(i, j) != "") {
				if (sheetObj.CellEditable(i, j)) {
					sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
				} else {
					sheetObj.CellBackColor(i, j) = sheetObj.UnEditableColor;
				}
				sheetObj.ToolTipText(i, j) = "";
			}
		}
	}
}

/**
 * tooltip을 생성한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * add2Tooltip(row, col, msg)
 * </pre>
 * 
 * @param {int} row
 * @param {int} col
 * @param {String} msg
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function add2Tooltip(row, col, msg) {
	var sheetObj = sheetObjects[0];
	sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255, 0, 0);
	sheetObj.ToolTipText(row, col) += "\n- " + msg;
}

/**
 * check 후 check 된 컬럼을 찾아 선택한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * clearTooltip()
 * </pre>
 * 
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function selectCheckedCell() {
	var sheetObj = sheetObjects[0];

	for ( var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i < sheetObj.LastRow; i++) {
		for ( var j = 0; j <= sheetObj.LastCol; j++) {
			if (sheetObj.ToolTipText(i, j) != "") {
				sheetObj.SelectCell(i, j);
				return;
			}
		}
	}
}

/**
 * ckeck 후 check 된 컬럼을 찾아 선택한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * clearTooltip()
 * </pre>
 * 
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function selectCheckedCell() {
	var sheetObj = sheetObjects[0];

	for ( var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i < sheetObj.LastRow; i++) {
		for ( var j = 0; j <= sheetObj.LastCol; j++) {
			if (sheetObj.ToolTipText(i, j) != "") {
				sheetObj.SelectCell(i, j);
				return;
			}
		}
	}
}

/**
 * 버튼을 활성화 또는 비활성화한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * toggleButtons(step)
 * </pre>
 * 
 * @param {String} step
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function toggleButtons(step) {
	switch (step) {
	case "INIT":
		enableButton("btn_openfile");
		disableButton("btn_check");
		disableButton("btn_save");
		break;
	case "LOAD":
		enableButton("btn_openfile");
		enableButton("btn_check");
		disableButton("btn_save");
		break;
	case "CHECK":
		enableButton("btn_openfile");
		enableButton("btn_check");
		enableButton("btn_save");
		break;
	}
}

/**
 * Excel Load후 처리 이벤트 1, Guide Line 정보 조회 2, rout_pnt_loc_def_cd 당 Base port editable 처리 여부 체크
 */
function sheet1_OnLoadExcel(obj) {
	obj.Redraw = false;
	var formObj = document.form;
	var headerRows = obj.HeaderRows;
	var rows = obj.Rows;
	var cmdt_dp_seq = "";
	var rout_dp_seq = "";
	var before_cmdt_dp_seq = "";
	var before_rout_dp_seq = "";
	for ( var i = obj.HeaderRows; i < rows; i++) {
		cmdt_dp_seq = obj.CellValue(i, 'cmdt_dp_seq');
		rout_dp_seq = obj.CellValue(i, 'rout_dp_seq');
		if (cmdt_dp_seq != '') {
			before_cmdt_dp_seq = cmdt_dp_seq;
		}
		if (rout_dp_seq != '') {
			before_rout_dp_seq = rout_dp_seq;
		}
		obj.CellValue2(i, 'h_seq') = i - headerRows + 1;
		obj.CellValue2(i, 'cmdt_rout') = before_cmdt_dp_seq + "|" + before_rout_dp_seq;
		funcCellEnabledControl(obj, i);
	}

	// Addon , IHC 값을 조회한다.
	funcSearchGuidelineRates(obj, formObj);
	obj.Redraw = true;
}

function sheet3_OnSearchEnd(sheetObj) {
	sheetObjects[0].Redraw = false;
	var obj = sheetObjects[0];
	var headerRows = obj.HeaderRows;
	var rows = obj.Rows;
	var formObj = document.form;
	for ( var i = headerRows; i < rows; i++) {
		if (obj.CellValue(i, 'rout_dp_seq') == '') {
			continue;
		}
		funcGuideLineAmount(sheetObjects[0], i);

	}
	headerRows = sheetObj.HeaderRows;
	rows = sheetObj.Rows;
	var h_seq_row = '';
	for ( var i = headerRows; i < rows; i++) {
		h_seq_row = obj.FindText("h_seq", sheetObj.CellValue(i, "h_seq"));
		if (formObj.svc_scp_cd.value == 'AEE') {
			obj.CellValue2(h_seq_row, "group_no_1") = sheetObj.CellValue(i, "group_no");
		} else {
			obj.CellValue2(h_seq_row, "group_no_2") = sheetObj.CellValue(i, "group_no");
		}
	}
	sheetObjects[0].Redraw = true;
}

/**
 * Addon, IHC 금액 전체를 조회 한다.
 */
function funcSearchGuidelineRates(sheetObj, formObj) {
	var sheetParam = funcGetSaveParamsFromSheet(sheetObj, formObj);
	formObj.f_cmd.value = SEARCH02;
	var sParam = FormQueryString(formObj);
	sParam = sParam + "&" + sheetParam
	sheetObjects[2].DoSearch("ESM_PRI_2067GS.do", sParam);
}

/**
 * 
 */
function funcGetSaveParamsFromSheet(sheetObj, formObj) {

	var sheetParam = "";
	var orgParamCols = "ibflag|h_seq|cmdt_dp_seq|rout_dp_seq|org_rout_pnt_loc_def_cd|org_rout_via_port_def_cd|org_rcv_de_term_nm|org_prc_trsp_mod_nm";
	var destParamCols = "ibflag|h_seq|cmdt_dp_seq|rout_dp_seq|dest_rout_pnt_loc_def_cd|dest_rout_via_port_def_cd|dest_rcv_de_term_nm|dest_prc_trsp_mod_nm";

	var arrParamCols = [];
	var colSize = 0;
	var checkColName = "";
	var keyStr = "";
	var rowCount = sheetObj.HeaderRows + sheetObj.Rows;

	if (formObj.svc_scp_cd.value == 'AEE') {

		arrParamCols = orgParamCols.split("|");
		checkColName = "org_rout_pnt_loc_def_cd";
	} else {
		arrParamCols = destParamCols.split("|");
		checkColName = "dest_rout_pnt_loc_def_cd";
	}
	colSize = arrParamCols.length;
	for ( var i = sheetObj.HeaderRows; i < sheetObj.Rows; i++) {
		if (sheetObj.CellValue(i, checkColName) != '') {
			for ( var iCol = 0; iCol < colSize; iCol++) {
				if (sheetObj.CellValue(i, "h_seq") == undefined) {
					break;
				}
				if (arrParamCols[iCol] == "cmdt_dp_seq") {
					keyStr = sheetObj.CellValue(i, "cmdt_rout");
					keyStr = keyStr.split("|");
					sheetParam = sheetParam + "&cmdt_dp_seq=" + keyStr[0];
					sheetParam = sheetParam + "&rout_dp_seq=" + keyStr[1];
				} else if (arrParamCols[iCol] != "rout_dp_seq") {
					sheetParam = sheetParam + "&" + arrParamCols[iCol] + "=" + sheetObj.CellValue(i, arrParamCols[iCol]);
				}
			}
		}
	}

	return sheetParam;
}

/**
 * Guide의 최고 금액을 구해 Sheet3에 추가
 */
function funcGuideLineAmount(targetSheet, Row) {
	var formObj = document.form;
	var svcScpCd = formObj.svc_scp_cd.value;
	var sheetObj = sheetObjects[2];
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;

	var cmdtSeqRoutDpSeq = sheetObjects[0].CellValue(Row, "cmdt_rout");
	if (cmdtSeqRoutDpSeq == undefined) {
		return;
	}
	var findRow = sheetObj.FindText("cmdt_rout", cmdtSeqRoutDpSeq);
	if (findRow > -1) {
		for ( var x = 0; x < obj_ratCargoTpCd.length; x++) {
			var amart_arr = new Array();
			var ficGlineInfo = new Array();
			var minAmt = '';
					
			var ratUtCd = obj_ratCargoTpCd[x].rat_ut_cd;
			if (ratUtCd == undefined || ratUtCd == null)
				continue;
			var prcCgoTpCd = obj_ratCargoTpCd[x].prc_cgo_tp_cd;
			var Col_propFrtRtAmt = obj_ratCargoTpCd[x].prop_frt_rt_amt;
			var Col_propBofAmt = obj_ratCargoTpCd[x].prop_bof_amt;
			var Col_ficPropRtAmt = obj_ratCargoTpCd[x].fic_prop_rt_amt;
			var Col_ficGlineRtAmt = obj_ratCargoTpCd[x].fic_gline_rt_amt;
			var Col_ficRtUseStsCd = obj_ratCargoTpCd[x].fic_rt_use_sts_cd;
			var Col_optmTrspModFlg = obj_ratCargoTpCd[x].optm_trsp_mod_flg;

			for ( var i = findRow; i < r; i++) {
				var rsltAmt = '';
				if (sheetObj.CellValue(i, 'cmdt_rout') == cmdtSeqRoutDpSeq) {
					var ficRtUseStsCd = sheetObj.CellValue(i, "fic_rt_use_sts_cd");
					var optmTrspModFlg = sheetObj.CellValue(i, "optm_trsp_mod_flg");
					if (ratUtCd == 'D2' || ratUtCd == 'R2') {
						if (prcCgoTpCd == "DR") {
							rsltAmt = sheetObj.CellValue(i, "dr_20ft_amt");
						} else if (prcCgoTpCd == "DG") {
							rsltAmt = sheetObj.CellValue(i, "dg_20ft_amt");
						} else if (prcCgoTpCd == "RF") {
							rsltAmt = sheetObj.CellValue(i, "rf_20ft_amt");
						} else {
							rsltAmt = -1;
						}
					} else if (ratUtCd == 'D4' || ratUtCd == 'R4' || ratUtCd == 'D5' || ratUtCd == 'R5') {
						if (prcCgoTpCd == "DR") {
							rsltAmt = sheetObj.CellValue(i, "dr_40ft_amt");
						} else if (prcCgoTpCd == "DG") {
							rsltAmt = sheetObj.CellValue(i, "dg_40ft_amt");
						} else if (prcCgoTpCd == "RF") {
							rsltAmt = sheetObj.CellValue(i, "rf_40ft_amt");
						} else {
							rsltAmt = -1;
						}
					} else {
						rsltAmt = "N/A";
						ficRtUseStsCd = "";
						optmTrspModFlg = "";
					}

					if (ficRtUseStsCd != "S" || ComIsEmpty(rsltAmt)) {
						rsltAmt = "N/A";
						minAmt = "N/A";
					}

					if ((rsltAmt != -1 && rsltAmt != "N/A" && rsltAmt != '') && minAmt != 'N/A') {
						if (parseFloat(minAmt) <= parseFloat(rsltAmt)) {
							ficGlineInfo[0] = minAmt;
							ficGlineInfo[1] = ficRtUseStsCd;
							ficGlineInfo[2] = optmTrspModFlg;
						} else {
							minAmt = rsltAmt;
							ficGlineInfo[0] = minAmt;
							ficGlineInfo[1] = ficRtUseStsCd;
							ficGlineInfo[2] = optmTrspModFlg;
						}
					} else {
						ficGlineInfo[0] = "N/A";
						ficGlineInfo[1] = ficRtUseStsCd;
						ficGlineInfo[2] = optmTrspModFlg;
					}
				} else {
					break;
				}
			}
			if (ficGlineInfo.length > 0) {
				if (Col_propFrtRtAmt != '' && Col_ficPropRtAmt != '') {
					targetSheet.CellValue2(Row, Col_ficGlineRtAmt) = ficGlineInfo[0];
					if (ficGlineInfo[0] == 'N/A') {
						targetSheet.CellValue2(Row, Col_ficPropRtAmt) = 0.00;
					} else {
						targetSheet.CellValue2(Row, Col_ficPropRtAmt) = ficGlineInfo[0];
					}
					targetSheet.CellValue2(Row, Col_ficRtUseStsCd) = ficGlineInfo[1];
					targetSheet.CellValue2(Row, Col_optmTrspModFlg) = ficGlineInfo[2];

					if (targetSheet.CellValue(Row, Col_propFrtRtAmt) == '') {
						targetSheet.CellValue2(Row, Col_propFrtRtAmt) = '';
						targetSheet.CellValue2(Row, Col_propBofAmt) = '';
						targetSheet.CellValue2(Row, Col_ficPropRtAmt) = '';
					} else {
						targetSheet.CellValue2(Row, Col_propBofAmt) = targetSheet.CellValue(Row, Col_propFrtRtAmt) - targetSheet.CellValue(Row, Col_ficPropRtAmt);
					}
				} else {
					targetSheet.CellValue2(Row, Col_propFrtRtAmt) = '';
					targetSheet.CellValue2(Row, Col_propBofAmt) = '';
					targetSheet.CellValue2(Row, Col_ficPropRtAmt) = '';
					targetSheet.CellValue2(Row, Col_ficGlineRtAmt) = '';
					targetSheet.CellValue2(Row, Col_ficRtUseStsCd) = '';
					targetSheet.CellValue2(Row, Col_optmTrspModFlg) = '';
				}
			}
		}
	}
}

/*
 * 
 */
function initFicRoute(sheetObj, Row, Col) {
	var formObj = document.form;
	var saveName = sheetObj.ColSaveName(Col);
	sheetObj.Redraw = false;
	switch (saveName) {
	case "org_rout_pnt_loc_def_cd":
		if (sheetObj.CellValue(Row, 'org_rout_pnt_loc_def_cd') == '') {
			sheetObj.CellValue2(Row, "group_no_1") = '';
			sheetObj.CellValue2(Row, "org_rcv_de_term_nm") = '';
			sheetObj.CellValue2(Row, "org_prc_trsp_mod_nm") = '';
		}

		if (formObj.svc_scp_cd.value == 'AEE') {
			sheetObj.CellValue2(Row, "org_rout_via_port_def_cd") = '';
			sheetObj.CellValue(Row, "base_port_list") = '';
			funcCellEnabledControl(sheetObj, Row);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
		}
		break;
	case "dest_rout_pnt_loc_def_cd":
		if (sheetObj.CellValue(Row, 'dest_rout_pnt_loc_def_cd') == '') {
			sheetObj.CellValue2(Row, "group_no_2") = '';
			sheetObj.CellValue2(Row, "dest_rcv_de_term_nm") = '';
			sheetObj.CellValue2(Row, "dest_prc_trsp_mod_nm") = '';
		}
		if (formObj.svc_scp_cd.value == 'AEW') {
			sheetObj.CellValue(Row, "base_port_list") = '';
			funcCellEnabledControl(sheetObj, Row);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
		}
		break;
	case "org_rout_via_port_def_cd":
	case "dest_rout_via_port_def_cd":
		if (formObj.svc_scp_cd.value == 'AEW') {
			sheetObj.CellValue2(Row, "group_no_2") = "";
			sheetObj.CellValue2(Row, "dest_prc_trsp_mod_nm") = "";
		} else if (formObj.svc_scp_cd.value == 'AEE') {
			sheetObj.CellValue2(Row, "group_no_1") = "";
			sheetObj.CellValue2(Row, "org_prc_trsp_mod_nm") = "";
		}
		sheetObj.CellValue2(Row, "fic_gline_rt_amt") = "";
		sheetObj.CellValue2(Row, "base_port_list") = "";
		sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = "";
		sheetObj.CellValue2(Row, "fic_rout_cmb_tp_cd") = "";
		sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = "";
		sheetObj.CellValue2(Row, "fic_gline_upd_dt") = "";
		break;
	}
	sheetObj.Redraw = true;
}

/**
 * IBSEARCH_ASYNC06
 */
function funcGetBasePortList(sheetObj, formObj, Row) {
	var sender = sheetObjects[1];
	formObj.f_cmd.value = SEARCH01;
	var sParam = FormQueryString(formObj);
	if (formObj.svc_scp_cd.value == 'AEE') {
		if (sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd") == '' || sheetObj.CellValue(Row, "org_rcv_de_term_nm") == '' || sheetObj.CellValue(Row, "org_prc_trsp_mod_nm") == '') {
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "org_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "org_rcv_de_term_nm");
		sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "org_prc_trsp_mod_nm");
	} else {
		if (sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd") == '' || sheetObj.CellValue(Row, "dest_rcv_de_term_nm") == '' || sheetObj.CellValue(Row, "dest_prc_trsp_mod_nm") == '') {
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "dest_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "dest_rcv_de_term_nm");
		sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "dest_prc_trsp_mod_nm");
	}
	var sXml = sender.getSearchXml("ESM_PRI_6094GS.do", sParam);
	var arr = ComPriXml2ComboString(sXml, "base_port_list", "base_port_list");
}

/**
 * IBSEARCH_ASYNC07
 */
function funcGetBasePortTrspModeCd(sheetObj, formObj, Row) {
	var sender = sheetObjects[1];
	formObj.f_cmd.value = SEARCH01;
	var sParam = FormQueryString(formObj);
	if (formObj.svc_scp_cd.value == 'AEE') {
		if (sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd") == '' || sheetObj.CellValue(Row, "org_rcv_de_term_nm") == '' || sheetObj.CellValue(Row, "org_rout_via_port_def_cd") == '') {
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "org_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "org_rcv_de_term_nm");
	} else {
		if (sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd") == '' || sheetObj.CellValue(Row, "dest_rcv_de_term_nm") == '' || sheetObj.CellValue(Row, "dest_rout_via_port_def_cd") == '') {
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "dest_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "dest_rcv_de_term_nm");
	}
	var sXml = sender.getSearchXml("ESM_PRI_6094GS.do", sParam);
	var saveName = "base_port_list|prc_trsp_mod_cd";
	var saveNameArr = saveName.split("|");
	var arrDesc = ComPriXml2Array(sXml, saveName);
	if (arrDesc != null && arrDesc.length > 0) {
		sheetObj.CellValue2(Row, "base_port_list") = arrDesc[0][0];
		if (formObj.svc_scp_cd.value == 'AEE') {
			sheetObj.CellValue(Row, "org_prc_trsp_mod_nm") = arrDesc[0][1];
		} else {
			sheetObj.CellValue(Row, "dest_prc_trsp_mod_nm") = arrDesc[0][1];
		}
	}
}

/**
 * 가이드라인 정보 조회. , IBSEARCH_ASYNC08
 */
function sheet3_setting(sheetObj, formObj, Row, insertFlag) {
	var sender = sheetObjects[1];
	var sheet3 = sheetObjects[2];

	formObj.f_cmd.value = SEARCH01;
	var sParam = FormQueryString(formObj);
	if (formObj.svc_scp_cd.value == 'AEE') {
		if (sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd") == '') {
			if (!insertFlag) {
				sheet3.RowDelete(sheet3.FindText('h_seq', sheetObj.CellValue(Row, "h_seq")), false);
			}
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "org_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "org_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "org_rcv_de_term_nm");
		sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "org_prc_trsp_mod_nm");
	} else {
		if (sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd") == '') {
			if (!insertFlag) {
				sheet3.RowDelete(sheet3.FindText('h_seq', sheetObj.CellValue(Row, "h_seq")), false);
			}
			return false;
		}
		sParam += "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "dest_rout_pnt_loc_def_cd");
		sParam += "&bse_port_def_cd=" + sheetObj.CellValue(Row, "dest_rout_via_port_def_cd");
		sParam += "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "dest_rcv_de_term_nm");
		sParam += "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "dest_prc_trsp_mod_nm");
	}
	var cmdtRoutSeq = sheetObjects[0].CellValue(Row, "cmdt_rout");
	var arr_seq = cmdtRoutSeq.split("|");

	var sRow;
	if (insertFlag) {
		sRow = sheet3.DataInsert();
	} else {
		sRow = sheet3.FindText('h_seq', sheetObj.CellValue(Row, "h_seq"));
		if (sRow == -1) {
			sRow = sheet3.DataInsert();
		}
	}
	sheet3.CellValue2(sRow, 'cmdt_dp_seq') = arr_seq[0];
	sheet3.CellValue2(sRow, 'rout_dp_seq') = arr_seq[1];
	sheet3.CellValue2(sRow, 'cmdt_rout') = cmdtRoutSeq;
	sheet3.CellValue2(sRow, 'h_seq') = sheetObj.CellValue(Row, "h_seq");

	var sXml = sender.getSearchXml("ESM_PRI_6094GS.do", sParam);
	var saveName = "fic_rt_use_sts_cd";
	var saveNameArr = saveName.split("|");
	var arrDesc = ComPriXml2Array(sXml, saveName);
	if (arrDesc != null && arrDesc.length > 0) {
		var data = arrDesc[0][0].split("|");
		sheet3.CellValue2(sRow, "fic_rt_use_sts_cd") = data[0];
		sheet3.CellValue2(sRow, "fic_rout_cmb_tp_cd") = data[1];
		sheet3.CellValue2(sRow, "optm_trsp_mod_flg") = data[2];
		if (formObj.svc_scp_cd.value == 'AEE') {
			sheet3.CellValue2(sRow, "group_no") = ComTrim(data[3]);
			sheetObj.CellValue2(Row, "group_no_1") = ComTrim(data[3]);
		} else {
			sheet3.CellValue2(sRow, "group_no") = ComTrim(data[3]);
			sheetObj.CellValue2(Row, "group_no_2") = ComTrim(data[3]);
		}
		if (data[4]) {
			sheet3.CellValue2(sRow, "dr_20ft_amt") = data[4];
		}
		if (data[5]) {
			sheet3.CellValue2(sRow, "rf_20ft_amt") = data[5];
		}
		if (data[6]) {
			sheet3.CellValue2(sRow, "dg_20ft_amt") = data[6];
		}
		if (data[7]) {
			sheet3.CellValue2(sRow, "dr_40ft_amt") = data[7];
		}
		if (data[8]) {
			sheet3.CellValue2(sRow, "rf_40ft_amt") = data[8];
		}
		if (data[9]) {
			sheet3.CellValue2(sRow, "dg_40ft_amt") = data[9];
		}
	}
	saveName = "base_port_list|prc_trsp_mod_cd";
	saveNameArr = saveName.split("|");
	arrDesc = ComPriXml2Array(sXml, saveName);
	if (arrDesc != null && arrDesc.length > 0) {
		sheet3.CellValue2(sRow, "base_port_list") = arrDesc[0][0];
		sheet3.CellValue2(sRow, "prc_trsp_mod_cd") = arrDesc[0][1];
	}
	return true;
}

/**
 * 그룹 체크
 */
function funcCheckGroupNo(Row, group_no) {
	var sheetObj = sheetObjects[2];
	var formObj = document.form;
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;
	var amart_arr = new Array();

	var cmdtSeqRoutDpSeq = sheetObjects[0].CellValue(Row, "cmdt_rout");
	var findRow = sheetObj.FindText("cmdt_rout", cmdtSeqRoutDpSeq);
	var chk = 0;
	if (findRow > -1) {
		for ( var i = findRow; i < r; i++) {
			if (sheetObj.CellValue(i, 'cmdt_rout') == cmdtSeqRoutDpSeq) {
				if (group_no != sheetObj.CellValue(i, 'group_no')) {
					return false;
				}

				if (sheetObj.CellValue(i, 'group_no') == 'N/A') {
					chk++;
				}
			} else {
				break;
			}
		}
	}
	if (chk > 1) {
		return false;
	}
	return true;
}

/**
 * Origin, Destination의 중복 체크
 */
function funcDupCheckIHC(sheetObj, cmdtRoutVal, inRow, ihcFlag, originDestGubun, routPntLocDefCd, rcvDeTermCd, prcTrspModCd, basePortCd) {
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;

	var svcScpCd = document.form.svc_scp_cd.value;
	var findRow = sheetObj.FindText("cmdt_rout", cmdtRoutVal);

	for ( var i = findRow; i < r; i++) {
		var sheet_routPntLocDefCd = '';
		var sheet_rcvDeTermCd = '';
		var sheet_prcTrspModCd = '';
		var sheet_basePortCd = '';
		if (i == inRow) {
			continue;
		}
		if (sheetObj.CellValue(i, 'cmdt_rout') != cmdtRoutVal) {
			break;
		}
		if (originDestGubun == 'O') {
			sheet_routPntLocDefCd = sheetObj.CellValue(i, 'org_rout_pnt_loc_def_cd');
			sheet_rcvDeTermCd = sheetObj.CellValue(i, 'org_rcv_de_term_nm');
			sheet_prcTrspModCd = sheetObj.CellValue(i, 'org_prc_trsp_mod_nm');
			sheet_basePortCd = sheetObj.CellValue(i, 'org_rout_via_port_def_cd');
		} else {
			sheet_routPntLocDefCd = sheetObj.CellValue(i, 'dest_rout_pnt_loc_def_cd');
			sheet_rcvDeTermCd = sheetObj.CellValue(i, 'dest_rcv_de_term_nm');
			sheet_prcTrspModCd = sheetObj.CellValue(i, 'dest_prc_trsp_mod_nm');
			sheet_basePortCd = sheetObj.CellValue(i, 'dest_rout_via_port_def_cd');
		}

		if (ihcFlag) {
			if (sheet_routPntLocDefCd == routPntLocDefCd && sheet_rcvDeTermCd == rcvDeTermCd && sheet_prcTrspModCd == prcTrspModCd && sheet_basePortCd == basePortCd) {
				return false;
			}
		} else {
			if (sheet_routPntLocDefCd == routPntLocDefCd && sheet_rcvDeTermCd == rcvDeTermCd && sheet_prcTrspModCd == prcTrspModCd) {
				return false;
			}
		}
	}
	return true;
}

/**
 * IHC가 아닌쪽에 동일한 Router에 동일한 Via가 존재 여부 체크
 */
function funcDupCheckVia(sheetObj, cmdtRoutVal, inRow, originDestGubun, routViaPortDefCd) {
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;

	var svcScpCd = document.form.svc_scp_cd.value;
	var findRow = sheetObj.FindText("cmdt_rout", cmdtRoutVal);

	for ( var i = findRow; i < r; i++) {
		var sheet_routPntLocDefCd = '';
		var sheet_rcvDeTermCd = '';
		var sheet_prcTrspModCd = '';
		var sheet_basePortCd = '';
		if (i == inRow) {
			continue;
		}
		if (sheetObj.CellValue(i, 'cmdt_rout') != cmdtRoutVal) {
			break;
		}
		if (originDestGubun == 'O') {
			sheet_basePortCd = sheetObj.CellValue(i, 'org_rout_via_port_def_cd');
		} else {
			sheet_basePortCd = sheetObj.CellValue(i, 'dest_rout_via_port_def_cd');
		}

		if (sheet_basePortCd == routViaPortDefCd) {
			return false;
		}
	}
	return true;
}

function funcDupCheckCmdtSeq(sheetObj, inRow, cmdtSeqVal) {
	var h = sheetObj.HeaderRows;
	var r = sheetObj.Rows;
	for ( var i = h; i < r; i++) {
		if (i == inRow) {
			continue;
		}
		if (sheetObj.CellValue(i, 'cmdt_dp_seq') == cmdtSeqVal) {
			return false;
		}
	}
	return true;
}

/**
 * 
 */
function funcCellEnabledControl(sheetObj, Row, ColGubun) {
	var formObj = document.form;
	if (formObj.svc_scp_cd.value == 'AEE') {
		if (sheetObj.CellValue(Row, 'org_rout_pnt_loc_def_cd') == '') {
			sheetObj.CellEditable(Row, 'org_rout_via_port_def_cd') = false;
		} else {
			sheetObj.CellEditable(Row, 'org_rout_via_port_def_cd') = true;
		}
	} else {
		if (sheetObj.CellValue(Row, 'dest_rout_pnt_loc_def_cd') == '') {
			sheetObj.CellEditable(Row, 'dest_rout_via_port_def_cd') = false;
		} else {
			sheetObj.CellEditable(Row, 'dest_rout_via_port_def_cd') = true;
		}
	}
	if (sheetObj.CellValue(Row, 'rout_dp_seq') == '') {
		funcRateCellEnabledControl(sheetObj, Row, false);
	} else {
		funcRateCellEnabledControl(sheetObj, Row, true);
	}
}

function funcRateCellEnabledControl(sheetObj, Row, disableFlg) {
	sheetObj.CellEditable(Row, 'rate_dry20') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_prop_dry20') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_dry40') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_prop_dry40') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_dry40hc') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_prop_dry40hc') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_dry45') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_prop_dry45') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_rf40hc') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_prop_rf40hc') = disableFlg
	sheetObj.CellEditable(Row, 'rate_rd40hc') = disableFlg;
	sheetObj.CellEditable(Row, 'rate_prop_rd40hc') = disableFlg;
}

/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * initSheet(sheetObj, 1);
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */
function initSheet(sheetObj, sheetNo) {
	var formObj = document.form;
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {

	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 440;
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
			InitRowInfo(3, 1, 3, 100);

			var HeadTitle1 = "||cmdt_rout|CMDT\nSeq.|Commodity Group|Commodity Group|Route\nSeq.|Origin|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Destination|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|fic_rt_use_sts_cd|optm_trsp_mod_flg|base_port_list|fic_rout_cmb_tp_cd|fic_gline_upd_dt|group_no|bse_port_loc_cd||||||||||||||||||";
			var HeadTitle2 = "||cmdt_rout|CMDT\nSeq.|Code|Description|Route\nSeq.|Code|Description|Loc Group|Term|Transmode|Code|Code|Code|Description|Loc Group|Term|Transmode|Dry 20'|Dry 20'|Dry 20'|Dry 40'|Dry 40'|Dry 40'|Dry 40'HC|Dry 40'HC|Dry 40'HC|Dry 45'|Dry 45'|Dry 45'|RF 40'HC|RF 40'HC|RF 40'HC|RD 40'HC|RD 40'HC|RD 40'HC|fic_rt_use_sts_cd|optm_trsp_mod_flg|base_port_list|fic_rout_cmb_tp_cd|fic_gline_upd_dt|group_no|bse_port_loc_cd||||||||||||||||||";
			var HeadTitle3 = "||cmdt_rout|CMDT\nSeq.|Code|Description|Route\nSeq.|Code|Description|Loc Group|Term|Transmode|Code|Code|Code|Description|Loc Group|Term|Transmode|Rate|BOF|IHC|Rate|BOF|IHC|Rate|BOF|IHC|Rate|BOF|IHC|Rate|BOF|IHC|Rate|BOF|IHC|fic_rt_use_sts_cd|optm_trsp_mod_flg|base_port_list|fic_rout_cmb_tp_cd|fic_gline_upd_dt|group_no|bse_port_loc_cd||||||||||||||||||";
			var headCount = ComCountHeadTitle(HeadTitle3);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, false);
			InitHeadRow(2, HeadTitle3, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "h_seq");
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cmdt_rout");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cmdt_dp_seq", false, "", dfNullInteger, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "prc_cmdt_def_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rout_dp_seq", false, "", dfNullInteger, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "org_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "org_rout_pnt_loc_def_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "group_no_1", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, false, "org_rcv_de_term_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "org_prc_trsp_mod_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "dest_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "dest_rout_pnt_loc_def_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "group_no_2", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, false, "dest_rcv_de_term_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "dest_prc_trsp_mod_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry20", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_dry20", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_dry20", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_dry40", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_dry40", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40hc", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_dry40hc", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_dry40hc", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry45", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_dry45", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_dry45", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rf40hc", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_rf40hc", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_rf40hc", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rd40hc", false, "", dfNullFloat, 2, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_bof_rd40hc", false, "", dfNullFloat, 2, false, false, 9);
			InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_prop_rd40hc", false, "", dfNullFloat, 2, true, true, 9);

			// Route를 위한 Field
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_rt_use_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "optm_trsp_mod_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "base_port_list", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "fic_rout_cmb_tp_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "fic_gline_upd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "group_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bse_port_loc_cd", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 100, daRight, false, "fic_gline_rt_amt_rate_dry20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_rt_use_sts_cd_rate_dry20", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "optm_trsp_mod_flg_rate_dry20", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 100, daRight, false, "fic_gline_rt_amt_rate_dry40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_rt_use_sts_cd_rate_dry40", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "optm_trsp_mod_flg_rate_dry40", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 100, daRight, false, "fic_gline_rt_amt_rate_dry40hc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_rt_use_sts_cd_rate_dry40hc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "optm_trsp_mod_flg_rate_dry40hc", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 100, daRight, false, "fic_gline_rt_amt_rate_dry45", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_rt_use_sts_cd_rate_dry45", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "optm_trsp_mod_flg_rate_dry45", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 100, daRight, false, "fic_gline_rt_amt_rate_rf40hc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_rt_use_sts_cd_rate_rf40hc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "optm_trsp_mod_flg_rate_rf40hc", false, "", dfNone, 0, false, false);

			InitDataProperty(0, cnt++, dtHidden, 100, daRight, false, "fic_gline_rt_amt_rate_rd40hc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "fic_rt_use_sts_cd_rate_rd40hc", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "optm_trsp_mod_flg_rate_rd40hc", false, "", dfNone, 0, false, false);

			ShowButtonImage = 2;
			ToolTipOption = "balloon:true;width:1000;icon:3;title:Load Excel";
			InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "org_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "org_rout_via_port_def_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "dest_rout_via_port_def_cd", vtEngUpOther, "0123456789");
			InitDataValid(0, "dest_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");

			sheetObj.SetMergeCell(1, 4, 2, 1);
			sheetObj.SetMergeCell(1, 5, 2, 1);
			sheetObj.SetMergeCell(1, 6, 2, 1);
			sheetObj.SetMergeCell(1, 7, 2, 1);
			sheetObj.SetMergeCell(1, 8, 2, 1);
			sheetObj.SetMergeCell(1, 9, 2, 1);
			sheetObj.SetMergeCell(1, 10, 2, 1);
			sheetObj.SetMergeCell(1, 11, 2, 1);
			sheetObj.SetMergeCell(1, 12, 2, 1);
			sheetObj.SetMergeCell(1, 13, 2, 1);
			sheetObj.SetMergeCell(1, 14, 2, 1);
			sheetObj.SetMergeCell(1, 15, 2, 1);
			sheetObj.SetMergeCell(1, 16, 2, 1);
			sheetObj.SetMergeCell(1, 17, 2, 1);
			sheetObj.SetMergeCell(1, 18, 2, 1);
			sheetObj.SetMergeCell(1, 19, 1, 3);
			sheetObj.SetMergeCell(1, 22, 1, 3);
			sheetObj.SetMergeCell(1, 25, 1, 3);
			sheetObj.SetMergeCell(1, 28, 1, 3);
			sheetObj.SetMergeCell(1, 31, 1, 3);
			sheetObj.SetMergeCell(1, 34, 1, 3);

			if (formObj.svc_scp_cd.value == 'AEE') {
				sheetObj.ColHidden('group_no_1') = false;
				sheetObj.ColHidden('group_no_2') = true;
			} else {
				sheetObj.ColHidden('group_no_1') = true;
				sheetObj.ColHidden('group_no_2') = false;
			}
			SelectHighLight = false;
			WaitImageVisible = false;
		}
		break;

	case "sheet2": // hidden
		with (sheetObj) {
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(1, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "status";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");

			Visible = false;
			WaitImageVisible = false;
		}
		break;
	case "sheet3": // guide-line sheet
		with (sheetObj) {
			// 높이 설정
			style.height = 440;
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

			var HeadTitle1 = "h_seq|cmdt_dp_seq|rout_dp_seq|group_no|base_port_list|optm_trsp_mod_flg|fic_rout_cmb_tp_cd|fic_rt_use_sts_cd|fic_gline_upd_dt|dr_20ft_amt|rf_20ft_amt|dg_20ft_amt|dr_40ft_amt|rf_40ft_amt|dg_40ft_amt|cmdt_rout";
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "h_seq", false, "", dfNullInteger, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cmdt_dp_seq", false, "", dfNullInteger, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rout_dp_seq", false, "", dfNullInteger, 0, false, false, 5);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "group_no");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "base_port_list");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "optm_trsp_mod_flg");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fic_rout_cmb_tp_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fic_rt_use_sts_cd");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "fic_gline_upd_dt");
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "dr_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "rf_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "dg_20ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "dr_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "rf_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, "dg_40ft_amt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cmdt_rout");
		}
		break;
	}
}
