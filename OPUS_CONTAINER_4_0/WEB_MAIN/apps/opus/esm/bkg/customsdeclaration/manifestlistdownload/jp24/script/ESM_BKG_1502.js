/* =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1502
*@FileTitle  : B/L Inquiry(Japan 24HR)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
 ========================================================= */

var sheetObjects = new Array();
var sheetCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var searchCount = 0;
var saveCount = 0;

//Event handler processing by button click event */
document.onclick = processButtonClick;

	// Event handler processing by button name */
	function processButtonClick() {
		var shtObj = sheetObjects[0];
		var frmObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "btn_shpr":
					doActionIBSheet(shtObj, frmObj, SEARCH01, "shpr");
				break;
				case "btn_cnee":
					doActionIBSheet(shtObj, frmObj, SEARCH01, "cnee");
				break;
				case "btn_ntfy":
					doActionIBSheet(shtObj, frmObj, SEARCH01, "ntfy");
				break;
				case "tab2btn_rowadd":
					var newRowIdx = shtObj.DataInsert(-1);
					shtObj.SetCellValue(newRowIdx, "bl_no",frmObj.org_bl_no.value,0);
					shtObj.SelectCell(newRowIdx, "cntr_no");
				break;
				case "tab2btn_delete":
					ComRowHideDelete(shtObj, "del_chk");
				break;
				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
				break;
				case "btn_new":
					frmObj.pol_split_no.className = "input";
					frmObj.pol_split_no.disabled = false;
					frmObj.pod_split_no.className = "input";
					frmObj.pod_split_no.disabled = false;
					ComResetAll();
					shtObj.RemoveEtcData();
					sheetObjects[1].RemoveEtcData();
				break;
				case "btn_save":
					doActionIBSheet(shtObj, frmObj, IBSAVE);
				break;
				case "btn_transmit":
					frmObj.t_cmr_kind.setAttribute("required", "");
					doActionIBSheet(shtObj, frmObj, COMMAND01);
					frmObj.t_cmr_kind.removeAttribute("required");
				break;
				case "btn_close":   // close
					if (saveCount > 0) {
						// 저장이 한번이라도 되었으면 부모창 재조회
						var opener = window.dialogArguments;
						if (!opener) opener = parent;
						opener.doActionIBSheet(opener.sheetObjects[1], opener.document.form, SEARCH01);
					}
					ComClosePopup();
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


	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}


	/**
	 * IBTab Object regist array adding process for list in case of needing batch processing with other items
	 */
	function setTabObject(tabObj){
		tabObjects[tabCnt++] = tabObj;
	}


	/**
	* initializing sheet
	* implementing onLoad event handler in body tag
	* adding first-served functions after loading screen.
	*/
	function loadPage() {
		for (var k = 0; k<tabObjects.length; k++){
			initTab(tabObjects[k], k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		for (var i = 0; i<sheetObjects.length; i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		document.form.t_cmr_kind.value = tCmrKind;        // JSP에서 선언된 전역변수
		document.form.pol_split_no.value = polSplitNo;    // JSP에서 선언된 전역변수
		document.form.pod_split_no.value = podSplitNo;    // JSP에서 선언된 전역변수
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_transmit");
		ComBtnDisable("tab2btn_rowadd");
		ComBtnDisable("tab2btn_delete");
		initControl();

		if (document.form.bl_no.value != "") {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}


	/**
	 * initializing Tab Setting Tab items.
	 */
	function initTab(tabObj, tabNo) {
		with (tabObj) {
			var cnt = 0 ;
			InsertItem( " Customer ", "");
			InsertItem( " Container ", "");
			InsertItem( " Marks & Desc ", "");
		}
	}


	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(shtObj, shtNo) {
		var cnt = 0;

		with(shtObj){
			document.form.pagerows.value = 500;
			SetEditEnterBehavior("tab");
			InitComboNoMatchText(true);
			SetShowButtonImage(3);
			switch (shtObj.id) {
				case "tab2sheet1":

					var HeadTitle = "|Sel.|Seq.|Container|Type|Seal No.|P|R / D|R / D|Empty/Full|Supplied|bl_no";
					SetEditEnterBehavior("tab");

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, Page:20, FrozenCol:0, DataRowMerge:0 } );

					var info = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [{ Text:HeadTitle, Align:"Center"}];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",     Hidden:1,   Width:40,    Align:"Center",   ColMerge:0,    SaveName:"ibflag" },
								{Type:"DummyCheck", Hidden:0,   Width:50,    Align:"Center",   ColMerge:0,    SaveName:"del_chk" },
								{Type:"Seq",        Hidden:0,   Width:50,    Align:"Center",   ColMerge:0,    SaveName:"seq" },
								{Type:"Text",       Hidden:0,   Width:130,   Align:"Center",   ColMerge:0,    SaveName:"cntr_no",        KeyField:1,   Edit:1,   EditLen:14,   AcceptKeys:"E|N",   InputCaseSensitive:1 },
								{Type:"Text",       Hidden:0,   Width:50,    Align:"Center",   ColMerge:0,    SaveName:"cntr_tpsz_cd",   KeyField:0,   Edit:1,   EditLen:2,    AcceptKeys:"E|N",   InputCaseSensitive:1 },
								{Type:"Text",       Hidden:0,   Width:90,    Align:"Center",   ColMerge:0,    SaveName:"cntr_seal_no",   KeyField:0,   Edit:1,   EditLen:20,   AcceptKeys:"E|N",   InputCaseSensitive:1 },
								{Type:"Combo",      Hidden:0,   Width:50,    Align:"Center",   ColMerge:0,    SaveName:"prt_flg" },
								{Type:"Text",       Hidden:0,   Width:30,    Align:"Center",   ColMerge:0,    SaveName:"rcv_term_cd",    KeyField:0,   Edit:1,   EditLen:1,    AcceptKeys:"E",     InputCaseSensitive:1 },
								{Type:"Text",       Hidden:0,   Width:30,    Align:"Center",   ColMerge:0,    SaveName:"de_term_cd",     KeyField:0,   Edit:1,   EditLen:1,    AcceptKeys:"E",     InputCaseSensitive:1 },
								{Type:"Combo",      Hidden:0,   Width:110,   Align:"Center",   ColMerge:0,    SaveName:"full_mty_cd" },
								{Type:"Combo",      Hidden:0,   Width:100,   Align:"Center",   ColMerge:0,    SaveName:"jp_cntr_ownr_cd" },
								{Type:"Text",       Hidden:1,   Width:100,   Align:"Center",   ColMerge:0,    SaveName:"bl_no" }];
					InitColumns(cols);

					SetColProperty("prt_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
					SetColProperty("full_mty_cd", {ComboText:"Empty|Full", ComboCode:"E|F"} );
					SetColProperty("jp_cntr_ownr_cd", {ComboText:"Shipper|Carrier", ComboCode:"1|2"} );

					SetEditable(1);
					SetCountPosition(0);
					SetWaitImageVisible(0);
					SetSheetHeight(265);
				break;

				case "tab3sheet1":    // Hidden , Mark& Desc. Tab
					var HeadTitle = "|bl_no|bl_seq|cmdt_hs_cd|diff_rmk|bl_desc";
					var headCount = ComCountHeadTitle(HeadTitle);

					SetEditEnterBehavior("tab");

					SetConfig( { SearchMode:2, Page:20, DataRowMerge:0 } );

					var info = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",   Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								{Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no" },
								{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bl_seq" },
								{Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hs_cd" },
								{Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"diff_rmk" },
								{Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"bl_desc" } ];
					InitColumns(cols);

					SetEditable(1);
					SetCountPosition(0);
				 break;
				}
			}


	}


	/**
	 * registering initial event
	 */
	function initControl() {
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
		axon_event.addListener("keydown", "ComKeyEnter", "form");
	}


	/**
	* Sheet process handling
	* @param sheetObj
	* @param formObj
	* @param sAction
	* @return
	*/function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {
			case IBSEARCH:    // Retrieve
				if (!ComChkValid(frmObj)) return;
				var shtObj2 = sheetObjects[1];
				ComOpenWait(true);
				var tempBlNo = frmObj.bl_no.value;
				var tempTCmrKind = frmObj.t_cmr_kind.value;
				var tempPolSplitNo = frmObj.pol_split_no.value;
				var tempPodSplitNo = frmObj.pod_split_no.value;
				var tempDelTrasmitFlag = frmObj.del_trasmit_flag.value;
				frmObj.f_cmd.value = SEARCH;
				var xmlArr = shtObj.GetSearchData("ESM_BKG_1502GS.do", FormQueryString(frmObj)).split("|$$|");
				ComResetAll();    //기본 object 초기화
				if (ComGetEtcData(xmlArr[0], "TRANS_RESULT_KEY") == "F") {
					shtObj.LoadSearchData(xmlArr[0], {Sync:1});
				} else if (parseInt(ComGetEtcData(xmlArr[0], "data_rows")) < 1) {
					ComShowCodeMessage("COM130401");    // There is no data to search.
				} else if (ComGetEtcData(xmlArr[1], "TRANS_RESULT_KEY") == "F") {
					shtObj2.LoadSearchData(xmlArr[1], {Sync:1});
				} else {
					shtObj.LoadSearchData(xmlArr[0], {Sync:1});
					shtObj2.LoadSearchData(xmlArr[1], {Sync:1});
				}
				frmObj.bl_no.value = tempBlNo;
				frmObj.org_bl_no.value = tempBlNo;
				frmObj.t_cmr_kind.value = tempTCmrKind;
				frmObj.pol_split_no.value = tempPolSplitNo;
				frmObj.pod_split_no.value = tempPodSplitNo;
				frmObj.del_trasmit_flag.value = tempDelTrasmitFlag;
				ComOpenWait(false);
			break;

			case SEARCH01:     // Retrieve Customer Info.
				if (frmObj[CondParam+"_cnt_cd"].value == "") {
					ComSetFocus(frmObj[CondParam+"_cnt_cd"]);
					return;
				} else if (frmObj[CondParam+"_seq"].value == "") {
					ComSetFocus(frmObj[CondParam+"_seq"]);
					return;
				}
				var xmlStr = shtObj.GetSearchData("ESM_BKG_1502GS.do", "f_cmd="+SEARCH01+"&cust_cnt_cd="+frmObj[CondParam+"_cnt_cd"].value+"&cust_seq="+frmObj[CondParam+"_seq"].value);
				if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
					shtObj.LoadSearchData(xmlStr,{Sync:1} );
				} else {
					var custNm = ComGetEtcData(xmlStr, "cust_lgl_eng_nm");
					var custAddr = ComGetEtcData(xmlStr, "bzet_addr");
					if (custNm != undefined) frmObj[CondParam+"_nm"].value = custNm;
					if (custAddr != undefined) frmObj[CondParam+"_addr"].value = custAddr;
				}
			break;

			case IBSAVE:    // Save
				if (!ComChkValid(frmObj)) return;
				var shtObj2 = sheetObjects[1];
				if (frmObj.onchange_flag.value != "Y" && !shtObj.IsDataModified() && !shtObj2.IsDataModified()) {
					ComShowCodeMessage("COM130503");    // "There is no updated data to save."
					return;
				}
				if (!ComShowCodeConfirm("COM130101", "data")) return;    // "Do you want to save {?msg1}?"
				if (shtObj.RowCount() > 0 && shtObj.GetSaveString(true) == "") {    // Sheet1의 Mandatory Check 용도
					if (tabObjects[0].SetSelectedIndex!= 1) tabObjects[0].GetSelectedIndex()(1);
					return;
				}
				ComOpenWait(true);
				frmObj.f_cmd.value = MULTI01;
				frmObj.bl_no.value = frmObj.org_bl_no.value;    // 저장 전 사용자 실수를 막기 위하여, 조회되었던 bl_no로 원복
				var saveStringArr = new Array();
				saveStringArr[0] = ComSetPrifix(shtObj.GetSaveString(), "container_");
				saveStringArr[1] = ComSetPrifix(shtObj2.GetSaveString(), "markdesc_");
				var sXml = shtObj.GetSaveData("ESM_BKG_1502GS.do", FormQueryString(frmObj)+"&"+saveStringArr[0]+"&"+saveStringArr[1]);
				shtObj.LoadSaveData(sXml);
				ComOpenWait(false);
			break;

			case COMMAND01:    // EDI Transmit
				if (!ComChkValid(frmObj)) return;
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				frmObj.f_cmd.value = COMMAND01;
				frmObj.bl_no.value = frmObj.org_bl_no.value;    // 저장 전 사용자 실수를 막기 위하여, 조회되었던 bl_no로 원복
				shtObj.DoSearch( "ESM_BKG_1502GS.do", FormQueryString(frmObj), {Sync:2});    // FormQueryString만 전송하므로 DoSearch사용
				ComOpenWait(false);
			break;
		}
	}


	/**
	 * Event when clicking Tab
	 * activating selected tab items
	 * @param tabObj tab Object
	 * @param nItem tab Number
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs = document.all.item("tabLayer");
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
		beforetab = nItem;
	}


	/**
	 * handling event after searching
	 */
	function tab2sheet1_OnSearchEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) {
			ComOpenWait(false);
			return;
		}
		if (document.form.f_cmd.value == COMMAND01) {
			ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
			// Retrieve after transmit
			doActionIBSheet(shtObj, document.form, IBSEARCH);
		} else {
			//조회된 ETC데이터를 Form내의 각각 오브젝트에 setting
			ComEtcDataToForm(document.form, shtObj);
		}
	}


	/**
	 * handling event after saving
	 */
	function tab2sheet1_OnSaveEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) {
			ComOpenWait(false);
			return;
		}
		saveCount++;    // 저장여부를 알기위하여 사용됨
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		// Retrieve after saving
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


	/**
	 * handling event after searching
	 */
	function tab3sheet1_OnSearchEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) {
			ComOpenWait(false);
			return;
		}
		if (searchCount < 1) {
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_transmit");
			ComBtnEnable("tab2btn_rowadd");
			ComBtnEnable("tab2btn_delete");
		}
		searchCount++;
		document.form.cmdt_hs_cd.value = shtObj.GetCellValue(shtObj.HeaderRows(), "cmdt_hs_cd");
		document.form.diff_rmk.value = shtObj.GetCellValue(shtObj.HeaderRows(), "diff_rmk");
		document.form.bl_desc.value = shtObj.GetCellValue(shtObj.HeaderRows(), "bl_desc");
	}


	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var shtObj2 = sheetObjects[1];
		with (document.form) {
			switch (ComGetEvent("name")) {
				case "t_cmr_kind":
					if (t_cmr_kind.value == "1") {    // CMR(Del) 선택시
						del_trasmit_flag.value = "Y";
					} else {
						del_trasmit_flag.value = "";
					}
				break;
				case "pod_postfix":
					if (ComTrim(pod_postfix.value) == "") {
						pod_cd.value = "";
					} else {
						pod_cd.value = pod_prefix.value+pod_postfix.value;
					}
				break;
				case "cmdt_hs_cd":
					shtObj2.SetCellValue(shtObj2.HeaderRows(), "cmdt_hs_cd", cmdt_hs_cd.value, 0);
				break;
				case "diff_rmk":
					shtObj2.SetCellValue(shtObj2.HeaderRows(), "diff_rmk", diff_rmk.value, 0);
				break;
				case "bl_desc":
					shtObj2.SetCellValue(shtObj2.HeaderRows(), "bl_desc", bl_desc.value, 0);
				break;
				default:
					onchange_flag.value = "Y";    // 저장시 HTML의 Object내의 value들이 변경되었는지 감지
				break;
			}
		}
	}
