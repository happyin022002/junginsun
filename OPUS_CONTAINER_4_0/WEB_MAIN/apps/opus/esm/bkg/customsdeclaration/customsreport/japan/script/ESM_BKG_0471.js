/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0471.js
 *@FileTitle : Receive History from SEA_NACCS
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
 /****************************************************************************************
	Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
	MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
	 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG-0471 : define business script for ESM_BKG-0471.
 */
var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

	function processButtonClick() {
		/** **************************************************** */
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "jp24_check":
					if (formObj.jp24_check.checked) {
						formObj.disp_jp_msg_tp_cd2.style.display = "Inline";
						formObj.disp_jp_msg_tp_cd1.style.display = "none";
						formObj.disp_jp_msg_tp_cd1.value = "";
						formObj.jp_msg_tp_cd.value = "";
						formObj.error_check[0].disabled = true;
						formObj.error_check[1].disabled = true;
					} else {
						formObj.disp_jp_msg_tp_cd1.style.display = "Inline";
						formObj.disp_jp_msg_tp_cd2.style.display = "none";
						formObj.disp_jp_msg_tp_cd2.value = "";
						formObj.jp_msg_tp_cd.value = "";
						formObj.error_check[0].disabled = false;
						formObj.error_check[1].disabled = false;
					}
					break;

				case "date_check":
					if (formObj.date_check.checked) {
						formObj.start_rcv_dt.disabled = false;
						formObj.start_rcv_dt.className = "input1";
						formObj.start_rcv_dt.setAttribute("required", "");
						//formObj.start_rcv_dt2.value = "00:00";
						formObj.start_rcv_dt2.disabled = false;
						formObj.start_rcv_dt2.className = "input1";
						formObj.start_rcv_dt2.setAttribute("required", "");
						formObj.end_rcv_dt.disabled = false;
						formObj.end_rcv_dt.className = "input1";
						formObj.end_rcv_dt.setAttribute("required", "");
						//formObj.end_rcv_dt2.value = "23:59";
						formObj.end_rcv_dt2.disabled = false;
						formObj.end_rcv_dt2.className = "input1";
						formObj.end_rcv_dt2.setAttribute("required", "");
						formObj.btn_calendar.disabled = false;
						formObj.in_vvd_cd.className = "input";
						formObj.in_vvd_cd.removeAttribute("required");
					} else {
						formObj.in_vvd_cd.setAttribute("required", "");
						formObj.in_vvd_cd.className = "input1";
						formObj.btn_calendar.disabled = true;
						//formObj.start_rcv_dt.value = "";
						formObj.start_rcv_dt.removeAttribute("required");
						formObj.start_rcv_dt.className = "input2";
						formObj.start_rcv_dt.disabled = true;
						//formObj.start_rcv_dt2.value = "";
						formObj.start_rcv_dt2.removeAttribute("required");
						formObj.start_rcv_dt2.className = "input2";
						formObj.start_rcv_dt2.disabled = true;
						//formObj.end_rcv_dt.value = "";
						formObj.end_rcv_dt.removeAttribute("required");
						formObj.end_rcv_dt.className = "input2";
						formObj.end_rcv_dt.disabled = true;
						//formObj.end_rcv_dt2.value = "";
						formObj.end_rcv_dt2.removeAttribute("required");
						formObj.end_rcv_dt2.className = "input2";
						formObj.end_rcv_dt2.disabled = true;
					}
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;

				case "btn_view":
					doActionIBSheet(sheetObj, formObj, SEARCH11);
					break;

				case "btn_calendar":
					// disabled when before retrieve
					var cal = new ComCalendarFromTo();
					cal.select(formObj.start_rcv_dt, formObj.end_rcv_dt, "yyyy-MM-dd");
					break;

				case "btn_print":
					doActionIBSheet(sheetObj, formObj, SEARCH12);
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
	 * registering IBSheet Object as list
	 *  adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 * @param sheet_obj IBSheet Object
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}


	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (var i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		ComBtnDisable("btn_print");
	}


	/**
	 * processing when input search conditions
	 */
	function obj_KeyUp() {
		if (ComChkLen(window.event.srcElement.getAttribute("value"), window.event.srcElement.getAttribute("maxlength")) == "2") {
			ComSetNextFocus();
		}
	}


	/**
	 * registering initial event
	 */
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObj);
		axon_event.addListener("keydown", "ComKeyEnter", formObj);
		axon_event.addListenerForm("change", "obj_change", formObj);
	}


	/**
	 * setting sheet initial values and header
	 * adding case as numbers of counting sheets
	 * @param sheetObj
	 * @param sheetNo
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1": // sheet1 init
				with(sheetObj){
					var HeadTitle1 ="|Sel.|Seq.|MSG|Code|Data|BKG No.|User ID|VVD|VVD|VVD|POD|RCV Date|RCV Date|R.Seq." +
									// Hidden
									"|jp24_check";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					             {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sel" },
					             {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"jp_msg_tp_cd",      Edit:0 },
					             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"jp_svc_cd",         Edit:0 },
					             {Type:"Text",      Hidden:0,  Width:265,  Align:"Left",    ColMerge:1,   SaveName:"rcv_key_dat_ctnt",  Edit:0 },
					             {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"bkg_no",            Edit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",        Edit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",            Edit:0 },
					             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",        Edit:0 },
					             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",        Edit:0 },
					             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            Edit:0 },
					             {Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",            Edit:0,   Format:"Ymd" },
					             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rcv_dt2",           Edit:0,   Format:"Hms" },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcv_seq",           Edit:0 },

					             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"jp24_check" },
						];
					InitColumns(cols);

					SetEditable(1);
					SetCountFormat("[SELECTDATAROW / TOTALROWS]");
					SetSheetHeight(410);
				}
			break;
			}
	}


	/**
	 * handling process for sheet
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case MODIFY:
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			formObj.f_cmd.value=MODIFY;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			// alert(formObj.in_pod_cd.value);
			var xmlrs = sheetObj.getSaveData("ESM_BKG_0471GS.do", FormQueryString(formObj));
			sheetObj.LoadSaveData(xmlrs);
			ComOpenWait(false);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case IBSEARCH:
			if (!validateForm(sheetObj, formObj, sAction)) return;
			formObj.f_cmd.value = SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			iPageNo = 1;
			sheetObj.DoSearch("ESM_BKG_0471GS.do", FormQueryString(formObj) + "&i_page=1", {Append:false, Sync:2} );
			ComOpenWait(false);
			break;

		case IBSEARCHAPPEND: // search page
			if (!validateForm(sheetObj, formObj, IBSEARCH)) return false;
			formObj.f_cmd.value = SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			if (PageNo >= 1) {
				sheetObj.DoSearch("ESM_BKG_0471GS.do", FormQueryString(formObj) + "&i_page=" + PageNo, {Append:true, Sync:2} );
			} else {
				sheetObj.DoSearch("ESM_BKG_0471GS.do", FormQueryString(formObj) + "&i_page=1", {Append:false, Sync:2} );
			}
			ComOpenWait(false);
			break;

		case SEARCH11:
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			var chkRow = sheetObj.FindCheckedRow("sel");
			var jpMsgTpCd = sheetObj.GetCellValue(chkRow, "jp_msg_tp_cd");
			var rcvDt = sheetObj.GetCellValue(chkRow, "rcv_dt");
			var rcvDt2 = sheetObj.GetCellValue(chkRow, "rcv_dt2");
			var rcvSeq = sheetObj.GetCellValue(chkRow, "rcv_seq");
			var jp24Check = sheetObj.GetCellValue(chkRow, "jp24_check");
			var sUrl = "ESM_BKG_0472.do?pgmNo=ESM_BKG_0472&jpMsgTpCd=" + jpMsgTpCd + "&rcvDt=" + rcvDt + rcvDt2 + "&rcvSeq=" + rcvSeq + "&jp24Check=" + jp24Check;
			// var sUrl = "ESM_BKG_0456.do?bl_no="+selectedBlNumber;
			// ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 1024, 768, false);
			ComOpenWindowCenter(sUrl, "ESM_BKG_0472", 600, 360, false);
			break;

		case SEARCH12: //print
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			var jpMsgTpCd = formObj.jp_msg_tp_cd.value;
			var userId = formObj.usr_id.value;
			var errorCheck = formObj.error_check.value;
			var dateCheck = "";
			if (formObj.date_check.checked) dateCheck = "Y";
			var inVvdCd = formObj.in_vvd_cd.value;
			var inPodCd = formObj.in_pod_cd.value;
			var startRcvDt = formObj.start_rcv_dt.value;
			var startRcvDt2 = formObj.start_rcv_dt2.value;
			var endRcvDt = formObj.end_rcv_dt.value;
			var endRcvDt2 = formObj.end_rcv_dt2.value;
			// alert(errorCheck);
			// alert(jpMsgTpCd);
			var errorCheckValue = "";
			if (errorCheck == "A") {
				errorCheckValue = "";
			}else if (errorCheck == "E" && jpMsgTpCd == "MFR") {
				errorCheckValue = errorCheck;
			}
			var param = "/rp [" + jpMsgTpCd + "][" + dateCheck + "][" + startRcvDt +
						" " + startRcvDt2 + "][" + endRcvDt + " " + endRcvDt2 + "][" +
						inVvdCd + "][" + inPodCd + "][" + userId + "][" +
						errorCheckValue + "]";
			formObj.com_mrdArguments.value = param + " /riprnmargin /rwait";
			ComOpenRDPopup();
			break;
		}
	}


	var iPageNo = 1;
	function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
		 if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
		 doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
	}


	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (Code < 0 || sheetObj.RowCount() < 1) return;
		with (sheetObj) {
			ReDraw = false;
			if (document.form.jp24_check.checked) {
				SetColHidden("jp_svc_cd", 1);
				SetColHidden("sas112", 0);
				SetColHidden("bkg_no", 0);
				SetColHidden("pol_cd", 0);
				ComBtnDisable("btn_print");
			} else {
				SetColHidden("jp_svc_cd", 0);
				SetColHidden("sas112", 1);
				SetColHidden("bkg_no", 1);
				SetColHidden("pol_cd", 1);
				if (Code < 0 || RowCount() < 1) {
					ComBtnDisable("btn_print");
				} else {
					ComBtnEnable("btn_print");
				}
			}
			ReDraw = true;
		}
	}


	/**
	 *  handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH:
			if (!ComChkValid(formObj)) return false;
			if (!formObj.date_check.checked && formObj.in_vvd_cd.value == "" && formObj.usr_id.value == "" && formObj.in_pod_cd.value == "") {
				ComShowCodeMessage("BKG06004");
				formObj.start_rcv_dt.focus();
				return false;
			}
			break;

		case MODIFY:
			if (!ComChkValid(formObj)) return false;
			if (formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length < 9) {
				ComShowCodeMessage("BKG00251");
				formObj.in_vvd_cd.focus();
				return false;
			}
			if (formObj.in_pod_cd.value == "" || formObj.in_pod_cd.value.length < 5) {
				ComShowCodeMessage("BKG00252");
				formObj.in_pod_cd.focus();
				return false;
			}
			break;

		case SEARCH11:
			if (sheetObj.CheckedRows("sel") < 1) {
				ComShowCodeMessage("BKG00249");    // No Selected Row
				return false;
			}
			break;
		}
		return true;
	}


	function obj_change() {
		var formObj = document.form;
		var elementName = ComGetEvent("name");
		switch (elementName) {
			case "disp_jp_msg_tp_cd1":
				formObj.jp_msg_tp_cd.value = formObj.disp_jp_msg_tp_cd1.value;
				break;
			case "disp_jp_msg_tp_cd2":
				formObj.jp_msg_tp_cd.value = formObj.disp_jp_msg_tp_cd2.value;
				break;
		}
	}
