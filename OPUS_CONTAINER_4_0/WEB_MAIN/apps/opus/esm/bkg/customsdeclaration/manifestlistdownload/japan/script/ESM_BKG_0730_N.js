/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : Esm_bkg_0730.js
*@FileTitle  : Manifest Registration(MFR)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================**/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// public variable
var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	/**
	 * *** If sheets are more than 2 in one tab, use additional sheet variables
	 * ****
	 */
	var sheetObj = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = ComGetEvent("name");
		 if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case "btn_save":
			doActionIBSheet(sheetObj, formObj, COMMAND01);
			break;

		case "btn_customer":
			doActionIBSheet(sheetObj, formObj, COMMAND04);
			break;

		case "btn_cntr":
			doActionIBSheet(sheetObj, formObj, COMMAND05);
			break;

		case "btn_marks":
			doActionIBSheet(sheetObj, formObj, COMMAND06);
			break;

		case "btn_approval":
			doActionIBSheet(sheetObj, formObj, COMMAND07);
			break;

		case "btn_trans":
			doActionIBSheet(sheetObj, formObj, COMMAND02);
			break;

		case "btn_add":
			doActionIBSheet(sheetObj, formObj, COMMAND03);
			break;

		case "btn_delete":
			doActionIBSheet(sheetObj, formObj, IBDELETE);
			break;

		case "btns_calendar": // calendar button
			var cal = new ComCalendar();
			cal.select(formObj.in_vps_eta_dt, "yyyy-MM-dd");
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
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 *
  * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();
	document.form.in_vvd_cd.focus();
}

/**
 * load HTML Control event on the page <br>
 * {@link #loadPage}call the function and init IBSheet Object <br>
 *
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects
 */
function initControl() {
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	ComBtnDisable("btn_trans");
}

/**
 * setting sheet initial values and header
 *
 * adding case as numbers of counting sheets
 *
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			var HeadTitle1 = "|bl_number2|Del.|Seq.|B/L No.|POL|L/T|F/M|Bonded\nTransport|Approval\nFlag|MSG\nType|Previous|Previous|Next|Next|B/L|B/L|B/L|B/L|B/L|B/L|B/L|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|B/L|B/L|Booking Container|Booking Container" +
							 // Hidden Column
							 "|apro_no|pod_bnd|del_bnd|trsp_mod_cd|delt_flg";
			var HeadTitle2 = "|bl_number2||Seq.|B/L No.|POL|L/T|F/M|Bonded\nTransport|Approval\nFlag|MSG\nType|VVD|POD|VVD|POD|DEL|P|PU|W|WU|M|MU|NM|AD|NM|AD|NM|AD|M|DS|Number|S" +
							 // Hidden Column
							 "|apro_no|pod_bnd|del_bnd|trsp_mod_cd|delt_flg";

			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

			var info = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},
							{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1,   Width:0,    Align:"Center",   ColMerge:1,   SaveName:"ibflag" },
						 {Type:"Text",      Hidden:1,   Width:100,  Align:"Center",   ColMerge:1,   SaveName:"bl_number2"   },
						 {Type:"CheckBox",  Hidden:0,   Width:40,   Align:"Center",   ColMerge:1,   SaveName:"del_chk" },
						 {Type:"Text",      Hidden:0,   Width:40,   Align:"Center",   ColMerge:1,   SaveName:"seq" },

						 {Type:"Text",      Hidden:0,   Width:100,  Align:"Center",   ColMerge:1,   SaveName:"bl_number",       Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:50,   Align:"Center",   ColMerge:1,   SaveName:"pol_cd",          Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:35,   Align:"Center",   ColMerge:1,   SaveName:"locl_ts_flg",     Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:35,   Align:"Center",   ColMerge:1,   SaveName:"full_mty_cd",     Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:65,   Align:"Center",   ColMerge:1,   SaveName:"bd_tr",           Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:65,   Align:"Center",   ColMerge:1,   SaveName:"app_flg" },
						 {Type:"Text",      Hidden:0,   Width:45,   Align:"Center",   ColMerge:1,   SaveName:"msg_tp",          Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:70,   Align:"Center",   ColMerge:1,   SaveName:"pre_vsl_cd",      Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:50,   Align:"Center",   ColMerge:1,   SaveName:"pre_rly_port_cd", Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:70,   Align:"Center",   ColMerge:1,   SaveName:"pst_vsl_cd",      Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:50,   Align:"Center",   ColMerge:1,   SaveName:"pst_rly_pod_cd",  Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:50,   Align:"Center",   ColMerge:1,   SaveName:"bkg_del_cd",      Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"pck_qty",         Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"pck_tp_cd",       Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"grs_wgt",         Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"wgt_ut_cd",       Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"meas_qty",        Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"meas_ut_cd",      Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"cust_nm",         Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"cust_addr",       Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"cust_nm2",        Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"cust_addr2",      Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"cust_nm3",        Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"cust_addr3",      Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"diff_rmk",        Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"bl_desc",         Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:100,  Align:"Center",   ColMerge:1,   SaveName:"cntr_no",         Edit:0 },
						 {Type:"Text",      Hidden:0,   Width:30,   Align:"Center",   ColMerge:1,   SaveName:"cntr_seal_no",    Edit:0 },

						 {Type:"Text",      Hidden:1,   Width:100,  Align:"Center",   ColMerge:1,   SaveName:"apro_no"     },
						 {Type:"Text",      Hidden:1,   Width:100,  Align:"Center",   ColMerge:1,   SaveName:"pod_bnd"     },
						 {Type:"Text",      Hidden:1,   Width:100,  Align:"Center",   ColMerge:1,   SaveName:"del_bnd"     },
						 {Type:"Text",      Hidden:1,   Width:100,  Align:"Center",   ColMerge:1,   SaveName:"trsp_mod_cd" },
						 {Type:"Text",      Hidden:1,   Width:100,  Align:"Center",   ColMerge:1,   SaveName:"delt_flg"    } ];
			InitColumns(cols);

			SetSheetHeight(380);
			SetEditable(1);
			SetWaitImageVisible(0);
			SetCountPosition(0);
			SetRangeBackColor(1, 10, 1, 26, "#555555");
		}
		break;

	}
}

/**
 * handling sheet process
 *
 * @param sheetObj Sheet
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // retrieve
		formObj.f_cmd.value = SEARCH;
		if (!validateForm(sheetObj, formObj, sAction)) return;
		ComOpenWait(true);
		sheetObj.DoSearch("ESM_BKG_0730GS.do", FormQueryString(formObj), {Sync:2});
		ComOpenWait(false);
		if (sheetObj.GetEtcData("send_yn") == "Y") ComShowMessage("'DMF' File Already transmitted.");
		break;

	case COMMAND01: // save
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoAllSave("ESM_BKG_0730GS.do", {Param:FormQueryString(formObj), Quest:"false", UrlEncode:"true", Sync:1});
			ComOpenWait(false);
		}
		break;

	case COMMAND02: // transmit
		if (validateForm(sheetObj, formObj, sAction)) {
			//sheetObj.WaitImageVisible = false;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true, true);
			var msgTp = sheetObj.GetCellValue(sheetObj.HeaderRows(), "msg_tp");
			var msgFlag = "9";
			if (msgTp == "CMF03") msgFlag = "2";
			formObj.in_msg_tp.value = msgTp;
			formObj.in_msg_flag.value = msgFlag;
			formObj.f_cmd.value = MULTI01;
			for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
				sheetObj.SetRowStatus(i,"I");
			}
			var sParam = "";
			var sParamSheet2 = sheetObj.GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "");
			}
			sParam += "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0730GS.do", sParam);
			var key = ComGetEtcData(sXml, "KEY");
			ComOpenWait(true);
			intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
			formObj.in_msg_tp.value = "";
			formObj.in_msg_flag.value = "";
		}
		break;

	case COMMAND03: // B/L add
		if (validateForm(sheetObj, formObj, sAction)) {
			var sUrl = "ESM_BKG_0990.do?pgmNo=ESM_BKG_0990&vvd_cd="
					+ formObj.in_vvd_cd.value + "&pod_cd="
					+ formObj.in_pod_cd.value;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 580, 160, true);
			//ComOpenPopup(sUrl, 580, 150, "ESM_BKG_0990", "1,0,1,1,1,1,1,1", true,false);
		}
		break;

	case COMMAND04: // customer button
		if (validateForm(sheetObj, formObj, sAction)) {
			var selectedBlNumber = "";
			for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
				if (sheetObj.GetCellValue(i, "del_chk") == 1) {
					selectedBlNumber = sheetObj.GetCellValue(i, "bl_number");
					break;
				}
			}
			var sUrl = "ESM_BKG_0456.do?pgmNo=ESM_BKG_0456&bl_no="
					+ selectedBlNumber + "&vvd_cd=" + formObj.in_vvd_cd.value
					+ "&pod_cd=" + formObj.in_pod_cd.value;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0456", 750, 430, true);
		}
		break;

	case COMMAND05: //CNRT button
		if (validateForm(sheetObj, formObj, sAction)) {
			var selectedBlNumber = "";
			for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
				if (sheetObj.GetCellValue(i, "del_chk") == 1) {
					selectedBlNumber = sheetObj.GetCellValue(i, "bl_number");
					break;
				}
			}
			var sUrl = "ESM_BKG_0455.do?pgmNo=ESM_BKG_0455&bl_no=" + selectedBlNumber;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0455", 750, 340, true);
		}
		break;

	case COMMAND06:// Marks & Desc button
		if (validateForm(sheetObj, formObj, sAction)) {
			var selectedBlNumber = "";
			for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
				if (sheetObj.GetCellValue(i, "del_chk") == 1) {
					selectedBlNumber = sheetObj.GetCellValue(i, "bl_number");
					break;
				}
			}
			var sUrl = "ESM_BKG_0458_N.do?pgmNo=ESM_BKG_0458&bl_no=" + selectedBlNumber;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0458_N", 800, 450, true);
		}
		break;

	case COMMAND07: // Approval No.
		if (validateForm(sheetObj, formObj, sAction)) {
			with (sheetObj) {
				var chkRow = FindCheckedRow("del_chk").split("|")[0];
				var selectedBlNumber = GetCellValue(chkRow, "bl_number");
				var podBnd = GetCellValue(chkRow, "pod_bnd");
				var delBnd = GetCellValue(chkRow, "del_bnd");
				var deltFlg = GetCellValue(chkRow, "delt_flg");
			}
			// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
			ComOpenPopup("ESM_BKG_1510.do?bl_no=" + selectedBlNumber + "&pod_bnd=" + podBnd + "&del_bnd=" + delBnd + "&delt_flg=" + deltFlg, 700, 285, "", "1,0", true);
		}
		break;

	case IBDELETE: // input
		if (validateForm(sheetObj, formObj, sAction)) {
			ComRowHideDelete(sheetObj, "del_chk");
			sheetObj.CheckAll("del_chk", 0, 1);
		}
		break;

	}
}

/**
 * handling event after searching
 */
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
//	if (Code < 0) return;
	var formObj = document.form;
	ComEtcDataToForm(formObj, sheetObj);
	if (formObj.in_err_gb[0].checked) {
		if (formObj.in_download_yn.value == "Y") {
			ComBtnEnable("btn_trans");
		} else {
			ComBtnDisable("btn_trans");
		}
	} else {
		ComBtnDisable("btn_trans");
	}

	with (sheetObj) {
		CheckAll("del_chk", 0);
		for (var i=HeaderRows(); i<=LastRow(); i++) {
			if (GetCellValue(i, "pck_qty") == "N") SetCellFontColor(i, "pck_qty", "#FF0000");
			if (GetCellValue(i, "grs_wgt") == "N") SetCellFontColor(i, "grs_wgt", "#FF0000");
			if (GetCellValue(i, "meas_qty") == "N") SetCellFontColor(i, "meas_qty", "#FF0000");
			if (GetCellValue(i, "diff_rmk") == "N") SetCellFontColor(i, "diff_rmk", "#FF0000");
			if (GetCellValue(i, "bl_desc") == "N") SetCellFontColor(i, "bl_desc", "#FF0000");
			if (GetCellValue(i, "grs_wgt") == "N") SetCellFontColor(i, "cmdt_desc", "#FF0000");
			if (GetCellValue(i, "grs_wgt") == "N") SetCellFontColor(i, "cmdt_desc", "#FF0000");
			if (GetCellValue(i, "pck_tp_cd") == "N") SetCellFontColor(i, "pck_tp_cd", "#FF0000");
			if (GetCellValue(i, "wgt_ut_cd") == "N") SetCellFontColor(i, "wgt_ut_cd", "#FF0000");
			if (GetCellValue(i, "meas_ut_cd") == "N") SetCellFontColor(i, "meas_ut_cd", "#FF0000");
			if (GetCellValue(i, "cust_nm") == "N") SetCellFontColor(i, "cust_nm", "#FF0000");
			if (GetCellValue(i, "cust_addr") == "N") SetCellFontColor(i, "cust_addr", "#FF0000");
			if (GetCellValue(i, "cust_nm2") == "N") SetCellFontColor(i, "cust_nm2", "#FF0000");
			if (GetCellValue(i, "cust_addr2") == "N") SetCellFontColor(i, "cust_addr2", "#FF0000");
			if (GetCellValue(i, "cust_nm3") == "N") SetCellFontColor(i, "cust_nm3", "#FF0000");
			if (GetCellValue(i, "cust_addr3") == "N") SetCellFontColor(i, "cust_addr3", "#FF0000");
			if (GetCellValue(i, "cust_nm4") == "N") SetCellFontColor(i, "cust_nm4", "#FF0000");
			if (GetCellValue(i, "cust_addr4") == "N") SetCellFontColor(i, "cust_addr4", "#FF0000");
			if (GetCellValue(i, "bl_number") == "") SetCellEditable(i, "del_chk", 0);
			if (GetCellValue(i, "pst_vsl_cd") == "-") SetCellValue(i, "pst_vsl_cd", " ");
			if (GetCellValue(i, "pst_rly_pod_cd") == "-") SetCellValue(i, "pst_rly_pod_cd", " ");
			if (GetCellValue(i, "delt_flg") == "Y") SetCellFontColor(i, "app_flg", "#FF0000");
		}
	}
}

/**
 * BackEndJob handling
 *
 * @param sheetObj Sheet
 * @param sKey sKey
 */
function doActionValidationResult(sheetObj, sKey) {
	sheetObj.WaitImageVisble = false;
	var sXml = sheetObj.GetSearchData("ESM_BKG_0730GS.do?f_cmd="+ SEARCH03 + "&key=" + sKey);

	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

	// If an error occurred,exit
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);

		// ComShowCodeMessage('BKG00204');
		ComShowMessage(ComResultMessage(sXml));
		// sheet1, sheet2 retrieve again
		state = sheetObj.GetEtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
		return;
	} else if (sJbStsFlg == "FAIL") {
		// error
		clearInterval(intervalId);
		ComOpenWait(false);

		ComShowMessage(ComResultMessage(sXml));
	}
}

/**
 * mother screen retrieve
 */
function retrieve() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * checkbox handling method
 *
 * @param sheetObj Sheet
 * @param row row
 * @param col col
 * @param col value
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	with (sheetObj) {
		switch(ColSaveName(col)) {
			case "del_chk":
				ReDraw = false;
				var sameRows = "";
					// 선택된 row의 seq와 같은 row index를 검색 (Merge된 CheckBox에 체크/체크해제시 버그 보완수정)
					// ComFindAll - 한개의 row값만 return될 경우 숫자형이므로 "|"으로 split되지 않음에 유의
					sameRows = ComFindAll(sheetObj, "seq", GetCellValue(row, "seq")).toString().split("|");
					// 검색된 row index들에 대한 처리
					for (var i in sameRows) SetCellValue(sameRows[i], "check", value);
				ReDraw = true;
			break;
		}
	}

}

/**
 * handling event after saving
 */
function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	if (Code < 0) return;
	if (document.form.f_cmd.value == MULTI) {
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
	} else {
		ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
	}
	// Retrieve after saving
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

/**
 * handling process for input validation
 *
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		return true;
		break;

	case COMMAND01:
		if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		return true;
		break;

	case COMMAND02:
		if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		if (formObj.in_voyage_no.value == "" ) {
			ComShowCodeMessage('BKG02115');// "Please input Voyage number."
			formObj.in_voyage_no.focus();
			return false;
		}
		var vIsCheck2 = false;
		for ( var i = 2; i <= sheetObj.RowCount() + 1; i++) {
			if (sheetObj.GetRowStatus(i) == "D") {
				vIsCheck2 = true;
				break;
			}
		}
		if (vIsCheck2) {
			ComShowCodeMessage("BKG00178");
			return false;
		}

		// MFR과 CMF03이 혼재되어 있는지 체크
		var msgTp = sheetObj.GetCellValue(sheetObj.HeaderRows(), "msg_tp");
		for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "msg_tp") != msgTp) {
				ComShowMessage("You can transmit the same MSG TP only!");
				sheetObj.SelectCell(i, "msg_tp");
				return false;
			}
		}
		if (!ComShowCodeConfirm("BKG00263", formObj.in_vvd_cd.value, formObj.in_pod_cd.value)) {
			return false;
		}
		return true;
		break;

	case COMMAND03:
		if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		return true;
		break;

	case COMMAND04:
		if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		var blNumber = "";
		for ( var i = 2; i <= sheetObj.RowCount() + 1; i++) {
			if (sheetObj.GetCellValue(i, "del_chk") == 1) {
				if (blNumber == "") {
					blNumber = sheetObj.GetCellValue(i, "bl_number");
				} else {
					if (blNumber != sheetObj.GetCellValue(i, "bl_number")) {
						ComShowCodeMessage('BKG01002');
						return false;
					}
				}
			}
		}
		if (blNumber == "") {
			ComShowCodeMessage('BKG01002');
			return false;
		}
		return true;
		break;

	case COMMAND05:
		if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		var blNumber = "";
		for ( var i = 2; i <= sheetObj.RowCount() + 1; i++) {
			if (sheetObj.GetCellValue(i, "del_chk") == 1) {
				if (blNumber == "") {
					blNumber = sheetObj.GetCellValue(i, "bl_number");
				} else {
					if (blNumber != sheetObj.GetCellValue(i, "bl_number")) {
						ComShowCodeMessage('BKG01002');
						return false;
					}
				}

			}
		}
		if (blNumber == "") {
			ComShowCodeMessage('BKG01002');
			return false;
		}
		return true;
		break;

	case COMMAND06:
	case COMMAND07:
		if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9) {
			ComShowCodeMessage('BKG00262');
			formObj.in_vvd_cd.focus();
			return false;
		}
		if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length != 5) {
			ComShowCodeMessage('BKG00262');
			formObj.in_pod_cd.focus();
			return false;
		}
		var blNumber = "";
		for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "del_chk") == 1) {
				if (blNumber == "") {
					blNumber = sheetObj.GetCellValue(i, "bl_number");
				} else {
					if (blNumber != sheetObj.GetCellValue(i, "bl_number")) {
						ComShowCodeMessage('BKG01002');
						return false;
					}
				}

			}
		}
		if (blNumber == "") {
			ComShowCodeMessage('BKG01002');
			return false;
		}
		return true;
		break;

	case IBDELETE: // delete
		var vIsCheck = false;
		for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "del_chk") == 1) {
				vIsCheck = true;
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00249', '');
			return false;
		}
		if (!ComShowCodeConfirm("COM12188")) {
			return false;
		}
		return true;
		break;
	}
}
