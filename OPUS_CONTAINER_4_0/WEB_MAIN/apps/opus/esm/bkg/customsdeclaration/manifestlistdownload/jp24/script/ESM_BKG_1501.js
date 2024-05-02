/* =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1501.js
*@FileTitle  : Advance Cargo Information Download & Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
 ========================================================= */
//Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var backEndJobKey = "";
var ExptAll111Rows = new Array();    // used in sheet2_OnSearchEnd
var ExptAll108Rows = new Array();    // used in sheet2_OnSearchEnd
var ExptErrRows = new Array();       // used in sheet2_OnSearchEnd
var ExptErr111Rows = new Array();    // used in sheet2_OnSearchEnd
var ExptErr108Rows = new Array();    // used in sheet2_OnSearchEnd
//Event handler processing by button click event */
document.onclick = processButtonClick;

	//Event handler processing by button name */
	function processButtonClick() {
		var shtObj1 = sheetObjects[0];
		var shtObj2 = sheetObjects[1];
		var frmObj = document.form;
		try {
			if ($(event.target || event.srcElement).prop("disabled")) return;

			switch (ComGetEvent("name")) {
				case "btn_retrieve":
					frmObj.vvd.value = "";
					frmObj.pol_cd.value = "";
					doActionIBSheet(shtObj1, frmObj, SEARCH);
				break;

				case "btn_new":
					ExptErrRows = new Array();    // 전역변수 초기화
					frmObj.vvd_hdr.readOnly = false;
					frmObj.vvd_hdr.className = "input1";
					frmObj.vvd_hdr.setAttribute("required", "");
					frmObj.date_fm.value = "";
					frmObj.date_fm.removeAttribute("required");
					frmObj.date_fm.className = "input2";
					frmObj.date_fm.readOnly = true;
					frmObj.date_to.value = "";
					frmObj.date_to.removeAttribute("required");
					frmObj.date_to.className = "input2";
					frmObj.date_to.readOnly = true;
					frmObj.pol_cd_hdr.removeAttribute("required");
					frmObj.pol_cd_hdr.className = "input";
					ComResetAll();

					ComBtnDisable("btn_bl_inquiry");
					ComBtnDisable("btn_data_download");
					ComBtnDisable("btn_transmit");
					ComBtnDisable("btn_del_transmit");
					ComBtnDisable("btn_view_file");
				break;

				case "btn_bl_inquiry":
					if (!chkOneBlSelect(shtObj2, "chk", "bl_no")) return;  // One B/L Selected Check
					var sht2ChkRow = shtObj2.FindCheckedRow("chk").split("|")[0];
					var blNo = shtObj2.GetCellValue(sht2ChkRow, "bl_no");
					var tCmrKind = shtObj2.GetCellValue(sht2ChkRow, "t_cmr_kind");
					var polSplitNo = shtObj1.GetCellValue(shtObj1.FindCheckedRow("chk"), "pol_split_no");
					var podSplitNo = frmObj.pod_split_no.value;
					var param = "&bl_no=" + blNo + "&t_cmr_kind=" + tCmrKind + "&pol_split_no=" + polSplitNo + "&pod_split_no=" + podSplitNo;
					// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
					ComOpenPopup("ESM_BKG_1502_POP.do?pgmNo=ESM_BKG_1502" + param, 1100, 640, "", "1,0", true);
				break;

				case "btn_data_download":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					with (shtObj2) {
						var chkdRowArray = FindCheckedRow("chk").split("|");
						// t_s_type이 AMR이고 SAS111에 Clear, " "를 제외한 error 메세지가 있는 경우 return
						for (var k in chkdRowArray) {
							if (GetCellValue(chkdRowArray[k], "t_s_type") == "AMR" &&
									(GetCellValue(chkdRowArray[k], "sa111_rst") != "Clear" && GetCellValue(chkdRowArray[k], "sa111_rst") != " ")) {
								ComShowMessage("Your booking [" + GetCellValue(chkdRowArray[k], "bl_no") + "] has been rolled over.\n\nPlease, DEL Transmit a manifest attached to the previous vessel first.");
								SelectCell(chkdRowArray[k], "sa111_rst");
								return;
							} else if (GetCellValue(chkdRowArray[k], "mst_bl") == "E") {
								ComShowMessage("Simple/Console indicator is not selected. Please, select the right one.");
								shtObj2.SelectCell(chkdRowArray[k], "mst_bl");
								return;
							} else if (GetCellValue(chkdRowArray[k], "cntr_no") == "") {
								ComShowMessage("Booking doesn't have a container to file. Please, check and complete documentation and redownload.");
								shtObj2.SelectCell(chkdRowArray[k], "cntr_no");
								return;
							}
						}
					}
					doActionIBSheet(shtObj2, frmObj, MULTI01);
				break;

				case "btn_down_excel":
					if (shtObj2.RowCount() == 0 ) {
						ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
						return;
					} else {
						ComOpenWait(true);
						shtObj2.Down2Excel( {DownCols: makeHiddenSkipCol(shtObj2), SheetDesign:1,Merge:1 });
						ComOpenWait(false);
					}
				break;

				case "btn_transmit":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					var chkdRowArray = shtObj2.FindCheckedRow("chk").split("|");
					for (var k in chkdRowArray) {
						if (shtObj2.GetCellValue(chkdRowArray[k], "t_cmr_kind") == " ") {
							ComShowCodeMessage("BKG08006", "EMPTY Transmit Status");    // You can't select the data [{?msg1}].
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						} else if (shtObj2.GetCellValue(chkdRowArray[k], "a_cmr_kind") == "9" &&
								   shtObj2.GetCellValue(chkdRowArray[k], "t_cmr_kind") == "9" &&
								   shtObj2.GetCellValue(chkdRowArray[k], "samr_rst") == " ") {
							if (shtObj2.GetCellValue(chkdRowArray[k], "tamr_rst") == " ") {    // Tech Fail인지 여부체크
								ComShowMessage("Please, wait for customs response thru SAMR before you send AMR again.");
								shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
								return;
							}
						} else if (shtObj2.GetCellValue(chkdRowArray[k], "a_cmr_kind") == "2" &&
								   shtObj2.GetCellValue(chkdRowArray[k], "t_cmr_kind") == "2" &&
								   shtObj2.GetCellValue(chkdRowArray[k], "scmr_rst") == " ") {
							ComShowMessage("Please, wait for customs response thru SCMR before you send CMR again.");
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						}
					}
					frmObj.del_trasmit_flag.value = "";
					doActionIBSheet(shtObj2, frmObj, COMMAND01);
				break;

				case "btn_del_transmit":
					if (shtObj2.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					var chkdRowArray = shtObj2.FindCheckedRow("chk").split("|");
					for (var k in chkdRowArray) {
						if (shtObj2.GetCellValue(chkdRowArray[k], "t_cmr_kind") == "9") {
							ComShowCodeMessage("BKG08006", "'AMR' Transmit Status");    // You can't select the data [{?msg1}].
							shtObj2.SelectCell(chkdRowArray[k], "t_s_type");
							return;
						}
					}
					frmObj.del_trasmit_flag.value = "Y";
					doActionIBSheet(shtObj2, frmObj, COMMAND01);
				break;

				case "btn_view_file":
					if (!chkOneBlSelect(shtObj2, "chk", "bl_no")) return;  // One B/L Selected Check
					var sht2ChkRow = shtObj2.FindCheckedRow("chk").split("|")[0];
					var sDt = shtObj2.GetCellValue(sht2ChkRow, "s_dt");
					if (ComTrim(sDt) == "") {
						ComShowCodeMessage("BKG01051");    // "There is no trans data"
						return;
					}
					var blNo = shtObj2.GetCellValue(sht2ChkRow, "bl_no");
					// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
					ComOpenPopup("ESM_BKG_1506.do?pgmNo=ESM_BKG_1506&bl_no=" + blNo + "&snd_dt=" + sDt, 700, 350, "", "1,0", false);
				break;

				case "vvd_date_div":
					if (frmObj.vvd_date_div[0].checked) {
						frmObj.vvd_hdr.readOnly = false;
						frmObj.vvd_hdr.className = "input1";
						frmObj.vvd_hdr.setAttribute("required", "");
						frmObj.vps_dt_div.disabled = true;
						frmObj.date_fm.value = "";
						frmObj.date_fm.removeAttribute("required");
						frmObj.date_fm.className = "input2";
						frmObj.date_fm.readOnly = true;
						frmObj.date_to.value = "";
						frmObj.date_to.removeAttribute("required");
						frmObj.date_to.className = "input2";
						frmObj.date_to.readOnly = true;
						frmObj.btn_calendar.disabled = true;
						frmObj.pol_cd_hdr.removeAttribute("required");
						frmObj.pol_cd_hdr.className = "input";
					} else {
						frmObj.btn_calendar.disabled = false;
						frmObj.date_fm.readOnly = false;
						frmObj.date_fm.className = "input1";
						frmObj.date_fm.setAttribute("required", "");
						frmObj.date_to.readOnly = false;
						frmObj.date_to.className = "input1";
						frmObj.date_to.setAttribute("required", "");
						frmObj.vps_dt_div.disabled = false;
						if (frmObj.vps_dt_div.value == "ETD") {
							frmObj.pol_cd_hdr.className = "input1";
							frmObj.pol_cd_hdr.setAttribute("required", "");
						} else {
							frmObj.pol_cd_hdr.removeAttribute("required");
							frmObj.pol_cd_hdr.className = "input";
						}
						frmObj.vvd_hdr.value = "";
						frmObj.vvd_hdr.removeAttribute("required");
						frmObj.vvd_hdr.className = "input2";
						frmObj.vvd_hdr.readOnly = true;
					}
				break;

				case "btn_calendar":
					if (window.event.srcElement.disabled) return;
					var cal = new ComCalendarFromTo();
					cal.select(frmObj.date_fm, frmObj.date_to, "yyyy-MM-dd");
				break;

			} // end switch
		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}


	/*
	 * One B/L Selected Check
	 * (CheckBox 컬럼도 Merge되어 있으므로, One B/L만 체크되어있는지 여부를 알기위해 다음과 같이 처리)
	 */
	function chkOneBlSelect(shtObj, chkColNm, mergeColNm) {
		if (shtObj.CheckedRows(chkColNm) < 1) {
			ComShowCodeMessage("COM12189");    // Nothing selected
			return false;
		}
		var chkdRows = shtObj.FindCheckedRow(chkColNm);    // 체크된 row 전체
		// 선택된 row들의 bl_no 비교 (ColMerge 때문)
		var chkVal = shtObj.GetCellValue(chkdRows.split("|")[0], mergeColNm);    // 체크된 row중 첫번째 B/L
		var sameRows = ComFindAll(shtObj, mergeColNm, chkVal);    // 첫번째 B/L과 같은 row 전체
		if (chkdRows != sameRows) {
			ComShowCodeMessage("BKG01134");    // You should select one B/L
			return false;
		}
		return true;
	}


	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}


	/**
	* initializing sheet
	* implementing onLoad event handler in body tag
	* adding first-served functions after loading screen.
	*/
	function loadPage() {
		for (var i = 0; i<sheetObjects.length; i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		ComBtnDisable("btn_bl_inquiry");
		ComBtnDisable("btn_data_download");
		ComBtnDisable("btn_transmit");
		ComBtnDisable("btn_del_transmit");
		ComBtnDisable("btn_view_file");
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : shtObj == > 시트오브젝트, shtNo == > 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(shtObj, shtNo) {
		with (shtObj) {
			switch (shtObj.id) {
				case "sheet1":
						var cnt = 0;
						document.form.pagerows.value = 500;
						var HeadTitle = "|SEQ|SEL|VVD|ETA/ETD|V/POL|ATD Receive|SATD|Relaxed|POL Call Seq.|Call Sign|Cons Voy." +
									  // Hidden column
										"|v/pod|call_sgn_no_org|ib_cssm_voy_no_org";

						SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

						var info = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle, Align:"Center"}];
						InitHeaders(headers, info);

						var cols = [ {Type:"Status",   Hidden:1,   Width:40,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
									 {Type:"Seq",      Hidden:0,   Width:30,    Align:"Center",  ColMerge:0,   SaveName:"seq" },
									 {Type:"Radio",    Hidden:0,   Width:30,    Align:"Center",  ColMerge:0,   SaveName:"chk" },
									 {Type:"Text",     Hidden:0,   Width:100,   Align:"Center",  ColMerge:0,   SaveName:"vvd",            Edit:0 },
									 {Type:"Text",     Hidden:0,   Width:110,   Align:"Center",  ColMerge:0,   SaveName:"vps_dt",         Edit:0 },
									 {Type:"Text",     Hidden:0,   Width:55,    Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         Edit:0 },
									 {Type:"Text",     Hidden:0,   Width:110,   Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",         Edit:0 },
									 {Type:"Text",     Hidden:0,   Width:70,    Align:"Center",  ColMerge:0,   SaveName:"atd_rst",        Edit:0 },
									 {Type:"CheckBox", Hidden:0,   Width:60,    Align:"Center",  ColMerge:0,   SaveName:"rlx_div",        Edit:1 },
									 {Type:"Combo",    Hidden:0,   Width:85,    Align:"Center",  ColMerge:0,   SaveName:"pol_split_no",   Edit:1 },
									 {Type:"Text",     Hidden:0,   Width:70,    Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no",    Edit:1,   KeyField:0,   EditLen:15,   AcceptKeys:"E|N",   InputCaseSensitive:1 },
									 {Type:"Text",     Hidden:0,   Width:100,   Align:"Center",  ColMerge:0,   SaveName:"ib_cssm_voy_no", Edit:1,   KeyField:0,   EditLen:10,   AcceptKeys:"E|N",   InputCaseSensitive:1 },

									 {Type:"Text",     Hidden:1,   Width:45,    Align:"Center",  ColMerge:0,   SaveName:"pod_cd" },
									 {Type:"Text",     Hidden:1,   Width:70,    Align:"Center",  ColMerge:0,   SaveName:"call_sgn_no_org" },
									 {Type:"Text",     Hidden:1,   Width:100,   Align:"Center",  ColMerge:0,   SaveName:"ib_cssm_voy_no_org"} ];
						InitColumns(cols);

						SetColProperty("pol_split_no", {ComboText:"|1|2|3|4|5|6|7|8|9", ComboCode:"|1|2|3|4|5|6|7|8|9"} );

						SetWaitImageVisible(0);
						SetEditable(1);
						SetCountPosition(0);
						SetShowButtonImage(4);
						SetSheetHeight(ComGetSheetHeight(shtObj, 7));
				break;

				case "sheet2":
					var cnt = 0;
					var HeadTitle0 = "|SEQ|SEL|B/L No.|H B/L|B/POL|V/POL|V/POD|B/POD|B/DEL" +
									 "|Trasmit Status|Trasmit Status|Trasmit Status|Trasmit Status|S.Date" +
									 "|Customs Results|Customs Results|Customs Results|Customs Results|Customs Results|Customs Results|Customs Results|Customs Results" +
									 "|Shipper|Shipper|Shipper|Shipper|Cnee|Cnee|Cnee|Cnee|Notify|Notify|Notify|Notify" +
									 "|CMDT|HS CD|M & N|PKG|PKG\nUnit|G/WT|WT\nUnit|MEA|MEA\nUnit|IMDG|UN No.|Container No."+
									  // Hidden column
									 "|tamr_rst|pod_div|rvis_cntr_cust_tp_cd|sc108_rst_dtl|s_info";

					var HeadTitle1 = "|SEQ||B/L No.|H B/L|B/POL|V/POL|V/POD|B/POD|B/DEL" +
									 "|Current|Current|Next|Next|S.Date" +
									 "|SAMR|R.Date|SAS111|R.Date|SCMR|R.Date|SAS108|R.Date" +
									 "|NM|ADD|CNT|TEL|NM|ADD|CNT|TEL|NM|ADD|CNT|TEL" +
									 "|CMDT|HS CD|M & N|PKG|PKG\nUnit|G/WT|WT\nUnit|MEA|MEA\nUnit|IMDG|UN No.|Container No."+
									  // Hidden column
									 "|tamr_rst|pod_div|rvis_cntr_cust_tp_cd|sc108_rst_dtl|s_info";

					SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:14, DataRowMerge:0 } );

					var info = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle0, Align:"Center"},
									{ Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var editableYN = 0;
					var substrUsrId = strUsrId.substring(0, 4);
					if (substrUsrId == "TES_" || substrUsrId == "OPUS") editableYN = 1;    // Test용

					var cols = [ {Type:"Status",     Hidden:1,   Width:40,    Align:"Center",   ColMerge:1,   SaveName:"ibflag" },
								 {Type:"Text",       Hidden:0,   Width:30,    Align:"Center",   ColMerge:1,   SaveName:"seq" },
								 {Type:"DummyCheck", Hidden:0,   Width:30,    Align:"Center",   ColMerge:1,   SaveName:"chk" },
								 {Type:"Text",       Hidden:0,   Width:100,   Align:"Center",   ColMerge:1,   SaveName:"bl_no",        Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"mst_bl",       Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:60,    Align:"Center",   ColMerge:1,   SaveName:"bkg_pol_cd",   Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:60,    Align:"Center",   ColMerge:1,   SaveName:"vvd_pol_cd",   Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:60,    Align:"Center",   ColMerge:1,   SaveName:"vvd_pod_cd",   Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:60,    Align:"Center",   ColMerge:1,   SaveName:"bkg_pod_cd",   Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:60,    Align:"Center",   ColMerge:1,   SaveName:"bkg_del_cd",   Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:40,    Align:"Center",   ColMerge:1,   SaveName:"a_s_type",     Edit:editableYN,   EditLen:3,   AcceptKeys:"E",   InputCaseSensitive:1 },
								 {Type:"Text",       Hidden:0,   Width:25,    Align:"Center",   ColMerge:1,   SaveName:"a_cmr_kind",   Edit:editableYN,   EditLen:3,   AcceptKeys:"N" },
								 {Type:"Text",       Hidden:0,   Width:40,    Align:"Center",   ColMerge:1,   SaveName:"t_s_type",     Edit:editableYN,   EditLen:3,   AcceptKeys:"E",   InputCaseSensitive:1 },
								 {Type:"Text",       Hidden:0,   Width:25,    Align:"Center",   ColMerge:1,   SaveName:"t_cmr_kind",   Edit:editableYN,   EditLen:3,   AcceptKeys:"N" },
								 {Type:"Text",       Hidden:0,   Width:110,   Align:"Center",   ColMerge:1,   SaveName:"s_dt",         Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:70,    Align:"Center",   ColMerge:1,   SaveName:"samr_rst",     Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:110,   Align:"Center",   ColMerge:1,   SaveName:"samr_dt",      Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:70,    Align:"Center",   ColMerge:1,   SaveName:"sa111_rst",    Edit:0,   ToolTipText:"Advance Notice of Risk Assessment Result." },
								 {Type:"Text",       Hidden:0,   Width:110,   Align:"Center",   ColMerge:1,   SaveName:"sa111_dt",     Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:70,    Align:"Center",   ColMerge:1,   SaveName:"scmr_rst",     Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:110,   Align:"Center",   ColMerge:1,   SaveName:"scmr_dt",      Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:70,    Align:"Center",   ColMerge:1,   SaveName:"sc108_rst",    Edit:0,   ToolTipText:"Discrepancy Inforamtion of Advance Filing(non-Government)." },
								 {Type:"Text",       Hidden:0,   Width:110,   Align:"Center",   ColMerge:1,   SaveName:"sc108_dt",     Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"shpr_nm",      Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"shpr_addr",    Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"shpr_cnt_cd",  Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"shpr_phn_no",  Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"cnee_nm",      Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"cnee_addr",    Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"cnee_cnt_cd",  Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"cnee_phn_no",  Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"ntfy_nm",      Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"ntfy_addr",    Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"ntfy_cnt_cd",  Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"ntfy_phn_no",  Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"cmdt_cd",      Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"cmdt_hs_cd",   Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"mk_desc",      Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"pck_qty",      Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"pck_tp_cd",    Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"act_wgt",      Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"wgt_ut_cd",    Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"meas_qty",     Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"meas_ut_cd",   Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"imdg_cls",     Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:45,    Align:"Center",   ColMerge:1,   SaveName:"un_no",        Edit:0 },
								 {Type:"Text",       Hidden:0,   Width:110,   Align:"Center",   ColMerge:1,   SaveName:"cntr_no",      Edit:0 },

								 {Type:"Text",       Hidden:1,   Width:80,    Align:"Center",   ColMerge:0,   SaveName:"tamr_rst" },
								 {Type:"Text",       Hidden:1,   Width:60,    Align:"Center",   ColMerge:0,   SaveName:"pod_div" },
								 {Type:"Text",       Hidden:1,   Width:60,    Align:"Center",   ColMerge:0,   SaveName:"rvis_cntr_cust_tp_cd" },
								 {Type:"Text",       Hidden:1,   Width:80,    Align:"Center",   ColMerge:0,   SaveName:"sc108_rst_dtl" },
								 {Type:"Text",       Hidden:1,   Width:100,   Align:"Center",   ColMerge:0,   SaveName:"s_info" } ]
					InitColumns(cols);
					SetWaitImageVisible(0);
					SetHeaderRowHeight(18);
					SetEditableColorDiff(0);
					SetEditable(1);
					SetCountPosition(0);
					SetRangeBackColor(1, 2, 1, 52,"#555555");
					SetSheetHeight(ComGetSheetHeight(shtObj, 14));
				break;
			}
		}
	}


	/**
	 * setting form control  & event
	 */
	function initControl() {
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}


	/**
	 * handling sheet process
	 */
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {
			case SEARCH:    // Header - Retrieve
				if (!ComChkValid(frmObj)) return;
				if (frmObj.vvd_date_div[0].checked) {
					if (ComTrim(frmObj.pol_cd_hdr) == "" && ComTrim(frmObj.vvd_pod_postfix) == "" && ComTrim(frmObj.bkg_pod_hdr) == "" && ComTrim(frmObj.bkg_ofc_cd) == "") {
						ComShowCodeMessage("COM12138", "POL or POD", "BKG OFC");    // Please enter {?msg1} or {?msg2}.
						ComSetFocus(frmObj.pol_cd_hdr);
						return;
					}
				} else {
					if (ComGetDaysBetween(frmObj.date_fm.value, frmObj.date_to.value) > 3) {
						ComShowCodeMessage("COM132001","Period","4 days");    // {?msg1} exceeds maximum duration {?msg2}.
						ComSetFocus(frmObj.date_to);
						return;
					}
				}
				ComOpenWait(true);
				frmObj.call_sgn_no.value = "";
				frmObj.ib_cssm_voy_no.value = "";
				shtObj.RemoveAll();
				//shtObj.RemoveEtcData();
				var shtObj2 = sheetObjects[1];
				shtObj2.RemoveAll();
				//shtObj2.RemoveEtcData();
				shtObj2.SetHeaderCheck(1, "chk",0);
				document.getElementById("disp_ttl_bl").value = "";
				document.getElementById("disp_com_err_bl").value = "";
				document.getElementById("disp_miss_bl").value = "";
				document.getElementById("disp_snt_scc_bl").value = "";
				document.getElementById("disp_snt_err_bl").value = "";
				document.getElementById("disp_dnl").value = "";
				document.getElementById("disp_dnu").value = "";
				document.getElementById("disp_spd").value = "";
				document.getElementById("disp_hld").value = "";

				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1501GS.do", FormQueryString(frmObj), {Sync:2});
				ComOpenWait(false);
			break;

			case SEARCH01:    // Detail - Retrieve (Back End Job)
				if (!ComChkValid(frmObj)) return;
				if (sheetObjects[0].CheckedRows("chk") < 1) {
					ComShowCodeMessage("COM12189");    // Nothing selected
					return;
				}
				if (sheetObjects[0].GetSaveString() == "") return;    // Sheet1의 Mandatory Check 용도
				ComOpenWait(true);
				shtObj.RemoveAll();
				shtObj.RemoveEtcData();

				shtObj.SetHeaderCheck(1, "chk",0);
				document.getElementById("disp_ttl_bl").value = "";
				document.getElementById("disp_com_err_bl").value = "";
				document.getElementById("disp_miss_bl").value = "";
				document.getElementById("disp_snt_scc_bl").value = "";
				document.getElementById("disp_snt_err_bl").value = "";
				document.getElementById("disp_dnl").value = "";
				document.getElementById("disp_dnu").value = "";
				document.getElementById("disp_spd").value = "";
				document.getElementById("disp_hld").value = "";

				frmObj.f_cmd.value = SEARCH01;
				var xmlStr = shtObj.GetSearchData("ESM_BKG_1501GS.do", FormQueryString(frmObj));
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != null && backEndJobKey != undefined && backEndJobKey != "" &&
					backEndJobKey.toUpperCase() != "NULL" && backEndJobKey.toUpperCase() != "UNDEFINDE") {
					shtObj.SetWaitTimeOut(20000);
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			break;

			case MULTI01:    // Detail - Data Download
				if (!ComShowCodeConfirm("COM130101", "data")) return;    // "Do you want to save {?msg1}?"
				ComOpenWait(true);
				frmObj.f_cmd.value = MULTI01;
				var saveString = FormQueryString(frmObj) + "&" + ComSetPrifix(shtObj.GetSaveString(false, true, "chk"), "sheet2_");
				var xmlStr = shtObj.GetSaveData("ESM_BKG_1501GS.do", saveString);
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != null && backEndJobKey != undefined && backEndJobKey != "" &&
					backEndJobKey.toUpperCase() != "NULL" && backEndJobKey.toUpperCase() != "UNDEFINDE") {
					shtObj.SetWaitTimeOut(20000);
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			break;

			case COMMAND01:    // Detail - EDI Transmit
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				frmObj.f_cmd.value = COMMAND01;

				setTimeout(function() {
					with (shtObj) {
						// 체크된 row번호만 수집하여 Loop
						var chkdRowArray = FindCheckedRow("chk").split("|");
						for (var k in chkdRowArray) {
							// 직전 bl_no와 같다면 skip
							if (k > 0 && GetCellValue(chkdRowArray[k], "bl_no") == GetCellValue(chkdRowArray[k - 1], "bl_no")) continue;
							var saveString = FormQueryString(frmObj) + "&" + ComSetPrifix(RowSaveStr(chkdRowArray[k]), "sheet2_");
							var xmlStr = GetSaveData("ESM_BKG_1501GS.do", saveString);
							if (ComBkgErrMessage2(shtObj, xmlStr)) {
								SetCellValue(chkdRowArray[k], "chk", "0");    // 성공시에는 CheckBox 해제
							} else {
								ComOpenWait(false);
								return;    // 오류시에는 return
							}
						}
					}
					ComOpenWait(false);
					ComShowMessage("Data was transmitted successfully.\n\nResult confirmation after 10 minutes.");
					// 전송후 재조회
					frmObj.search_div.value = "DN";
					doActionIBSheet(shtObj, frmObj, SEARCH01);
				} , 100);
			break;
		}
	}


	/**
	 * BackEndJob : check jobState : '3'
	 */
	function getBackEndJobStatus() {
		var shtObj2 = sheetObjects[1];
		var xmlStr = shtObj2.GetSearchData("ESM_BKG_1501GS.do", "f_cmd=" + SEARCH02 + "&backEndJob_Key=" + backEndJobKey);
		var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg");

		if (jbStsFlg == "3") {
			var frmObj = document.form;

			if (frmObj.f_cmd.value == SEARCH01) {
				shtObj2.DoSearch("ESM_BKG_1501View_GS.do", "f_cmd=" + SEARCH03 + "&backEndJob_Key=" + backEndJobKey, {Sync:2});
				clearInterval(timer);
				backEndJobKey = "";
				ComOpenWait(false);
				// HTML Object의 disabled는 ComOpenWait(false)이후에 동작하므로, sheet2_OnSeachEnd가 아닌 여기에 위치
				ComBtnEnable("btn_view_file");
				if (frmObj.search_div.value == "BL") {
					ComBtnDisable("btn_bl_inquiry");
					ComBtnEnable("btn_data_download");
					ComBtnDisable("btn_transmit");
					ComBtnDisable("btn_del_transmit");
				} else {
					ComBtnEnable("btn_bl_inquiry");
					ComBtnDisable("btn_data_download");
					ComBtnEnable("btn_transmit");
					ComBtnEnable("btn_del_transmit");
				}
				return;

			} else if (frmObj.f_cmd.value == MULTI01) {
				xmlStr = "";
				xmlStr = shtObj2.GetSaveData("ESM_BKG_1501GS.do", "f_cmd=" + MULTI03 + "&backEndJob_Key=" + backEndJobKey);
				frmObj.del_trasmit_flag.value = "";
				clearInterval(timer);
				backEndJobKey = "";
				ComOpenWait(false);
				// 저장 후 재조회 (sheet2_OnSaveEnd에서 재조회를 하게 되면 backEndJob의 ComOpenWait이 정상작동하지 않음으로, 여기에 위치)
				frmObj.search_div.value = "DN";
				if (ComBkgErrMessage2(shtObj2, xmlStr)) {
					ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
					doActionIBSheet(shtObj2, frmObj, SEARCH01);
				}
			}
		} else if (jbStsFlg == "4") {
			clearInterval(timer);
			backEndJobKey = "";
			ComOpenWait(false);
			ComShowMessage(ComResultMessage(sXml));
		}
	}


	/**
	 * handling after retrieve
	 * @param sheetObj : IBSheet Object
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0 || shtObj.RowCount() < 1)  return;
		var frmObj = document.form;
		with (shtObj) {
			ReDraw = false;
			var editableYN = 0;
			if (frmObj.search_div.value == "DN") editableYN = 1;
			SetColEditable("rlx_div", editableYN);
			SetColEditable("pol_split_no", editableYN);
			SetColEditable("call_sgn_no", editableYN);
			SetColEditable("ib_cssm_voy_no", editableYN);
			SetColProperty(0, "call_sgn_no", {KeyField:editableYN});
			SetColProperty(0, "ib_cssm_voy_no", {KeyField:editableYN});

			for (var i=HeaderRows(); i<=LastRow(); i++) {
				if (GetCellValue(i, "atd_rst") == "Error") {
					SetCellFontColor(i, "atd_rst", "#FF3C3C");
					SetCellFontBold(i, "atd_rst", 1);
					SetCellFontUnderline(i, "atd_rst", 1);
				}
				if (frmObj.search_div.value == "BL") {
					if (GetCellValue(i, "call_sgn_no_org") != "" && GetCellValue(i, "call_sgn_no") != GetCellValue(i, "call_sgn_no_org")) {
						SetCellFontColor(i, "call_sgn_no", "#FF3C3C");
					}
					if (GetCellValue(i, "ib_cssm_voy_no_org") != "" && GetCellValue(i, "ib_cssm_voy_no") != GetCellValue(i, "ib_cssm_voy_no_org")) {
						SetCellFontColor(i, "ib_cssm_voy_no", "#FF3C3C");
					}
				}
			}
			ReDraw = true;
		}
	}


	/**
	 * Mouse Movement Event on sheet
	 * @param {shtObj} String
	 * @param {Button} Integer : direction of mouse movement, 1:left, 2:right
	 * @param {Shift} Integer : if Shift is pushed : 1, if Ctrl key is pushed : 2, Others : 0
	 */
	function sheet1_OnMouseMove(shtObj, Button, Shift) {
		with (shtObj) {
			switch (ColSaveName(MouseCol())) {
				case "atd_rst":
					if (GetCellValue(MouseRow(), MouseCol()) == "Error") SetMousePointer("Hand");
				break;
			}
		}
	}


	/**
	 * handling in case of clicking on sheet
	 */
	function sheet1_OnClick(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "atd_rst":
					if (Value == "Error") {
						var param = "&jp_msg_tp_id=SATD&vvd=" + GetCellValue(Row, "vvd") + "&pol_cd=" + GetCellValue(Row, "pol_cd");
						// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
						ComOpenPopup("ESM_BKG_1505.do?pgmNo=ESM_BKG_1505" + param, 650, 380, "", "1,0", true);
					}
				break;
			}
		}
	}


	/**
	 * clicking same row of hidden sheet at checkbox in case of clicking checkbox of sheet
	 */
	function sheet1_OnChange(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "pol_split_no":
				case "call_sgn_no":
				case "ib_cssm_voy_no":
					if (Value == CellSearchValue(Row, Col)) {
						SetCellFontColor(Row, Col, GetDataFontColor());
					} else {
						SetCellFontColor(Row, Col, "#FF3C3C");
					}
				break;
			}

			var frmObj = document.form;
			if (frmObj.search_div.value == "DN") {
				if (GetCellValue(Row, "rlx_div") != CellSearchValue(Row, "rlx_div") || GetCellValue(Row, "pol_split_no") != CellSearchValue(Row, "pol_split_no") ||
					frmObj.call_sgn_no.value != GetCellValue(Row, "call_sgn_no") || frmObj.ib_cssm_voy_no.value != GetCellValue(Row, "ib_cssm_voy_no")) {

					ComBtnDisable("btn_transmit");
					ComBtnDisable("btn_del_transmit");
				} else {
					ComBtnEnable("btn_transmit");
					ComBtnEnable("btn_del_transmit");
				}
			}
		}
	}


	/**
	 * handling in case of double clicking on sheet
	 */
	function sheet1_OnDblClick(shtObj, Row, Col){
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "vvd":
				case "vps_dt":
				case "pol_cd":
				case "rcv_dt":
					var frmObj = document.form;
					frmObj.vvd.value = GetCellValue(Row, "vvd");
					frmObj.pol_cd.value = GetCellValue(Row, "pol_cd");
					frmObj.rlx_div.value = GetCellValue(Row, "rlx_div");
					frmObj.pol_split_no.value = GetCellValue(Row, "pol_split_no");
					frmObj.pol_split_no.style.color = GetCellFontColor(Row, "pol_split_no");
					frmObj.call_sgn_no.value = GetCellValue(Row, "call_sgn_no");
					frmObj.call_sgn_no.style.color = GetCellFontColor(Row, "call_sgn_no");
					frmObj.ib_cssm_voy_no.value = GetCellValue(Row, "ib_cssm_voy_no");
					frmObj.ib_cssm_voy_no.style.color = GetCellFontColor(Row, "ib_cssm_voy_no");

					SetCellValue(Row, "chk", "1");
					doActionIBSheet(sheetObjects[1], frmObj, SEARCH01);
				break;
			}
		}
	}


	/**
	 * handling after retrieve
	 * @param sheetObj : IBSheet Object
	 * @param ErrMsg
	 * @return
	 */
	function sheet2_OnSearchEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0 || shtObj.RowCount() < 1)  return;
		with (shtObj) {
			// 화면에 Display하기위한 input에 value setting
			document.getElementById("disp_ttl_bl").value = GetEtcData("disp_ttl_bl");
			document.getElementById("disp_com_err_bl").value = GetEtcData("disp_com_err_bl");
			document.getElementById("disp_miss_bl").value = GetEtcData("disp_miss_bl");
			document.getElementById("disp_snt_scc_bl").value = GetEtcData("disp_snt_scc_bl");
			document.getElementById("disp_snt_err_bl").value = GetEtcData("disp_snt_err_bl");
			document.getElementById("disp_dnl").value = GetEtcData("disp_dnl");
			document.getElementById("disp_dnu").value = GetEtcData("disp_dnu");
			document.getElementById("disp_spd").value = GetEtcData("disp_spd");
			document.getElementById("disp_hld").value = GetEtcData("disp_hld");
		}

		this.sheet1_OnSearchEnd(sheetObjects[0], 0, "");
	}


	/**
	 * IBSeet상에서 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 * @param {shtObj} String : 해당 IBSheet Object
	 * @param {Button} Integer : 마우스버튼 방향, 1:왼쪽, 2:오른쪽
	 * @param {Shift} Integer : Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	 */
	function sheet2_OnMouseMove(shtObj, Button, Shift) {
		with (shtObj) {
			var rcvRst = GetCellValue(MouseRow(), MouseCol());
			switch (ColSaveName(MouseCol())) {
				case "samr_rst":
				case "scmr_rst":
				case "sc108_rst":
					if (rcvRst != "Success" && rcvRst != " ") SetMousePointer("Hand");
				break;

				case "sa111_rst":
					if (rcvRst != "Clear" && rcvRst != " ") SetMousePointer("Hand");
				break;
			}
		}
	}


	/**
	 * handling in case of clicking on sheet
	 */
	function sheet2_OnClick(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "chk":
					// 선택된 row의 seq와 같은 row index를 검색 (ColMerge 때문)
					var blNo = GetCellValue(Row, "bl_no");
					var sameRows = ComFindAll(shtObj, "bl_no", blNo).toString().split("|");
					ReDraw = false;
					// 검색된 row index들에 대한 처리
					for (var i in sameRows) SetCellValue(sameRows[i], "chk", Value);
					ReDraw = true;
				break;

				case "samr_rst":
				case "scmr_rst":
					if (Value == "Error") {
						var param = "&jp_msg_tp_id=" + GetCellText(1, ColSaveName(Col)) + "&bl_no=" + GetCellValue(Row, "bl_no");
						// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
						ComOpenPopup("ESM_BKG_1505.do?pgmNo=ESM_BKG_1505" + param, 650, 380, "", "1,0", true);
					}
				break;

				case "sc108_rst":
					if (Value != "Success" && Value != " ") {
						var param = "&jp_msg_tp_id=" + GetCellText(1, ColSaveName(Col)) + "&sc108_rst_dtl=" + ComTrim(GetCellValue(Row, "sc108_rst_dtl"));
						// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
						ComOpenPopup("ESM_BKG_1505.do?pgmNo=ESM_BKG_1505" + param, 650, 380, "", "1,0", true);
					}
				break;

				case "sa111_rst":
					if (Value != "Clear" && Value != " ") {
						var param = "&jp_msg_tp_id=" + GetCellText(1, ColSaveName(Col)) + "&bl_no=" + GetCellValue(Row, "bl_no") + "&err_cd=" + Value;
						// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
						ComOpenPopup("ESM_BKG_1505.do?pgmNo=ESM_BKG_1505" + param, 850, 380, "", "1,0", true);
					}
				break;
			}
		}
	}


	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		with (document.form) {
			switch (ComGetEvent("name")) {
				case "vps_dt_div":
					if (vvd_date_div[1].checked) {
						if (ComGetEvent("value") == "ETD") {
							pol_cd_hdr.className = "input1";
							pol_cd_hdr.setAttribute("required", "");
						} else {
							pol_cd_hdr.removeAttribute("required");
							pol_cd_hdr.className = "input";
						}
					}
				break;

				case "pod_div":
					if (ComGetEvent("value") == "VVD_POD") {
						vvd_pod_prefix.style.display = "Inline";
						vvd_pod_postfix.style.display = "Inline";
						bkg_pod_hdr.style.display = "none";
						bkg_pod_hdr.value = "";
					} else {
						bkg_pod_hdr.style.display = "Inline";
						vvd_pod_prefix.style.display = "none";
						vvd_pod_postfix.style.display = "none";
						vvd_pod_postfix.value = "";
					}
				break;
			}
		}
	}
