/*=========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_1526-01.js
 *@FileTitle : ESM_BKG-1526-01
*@author     : CLT
*@version    : 1.0
*@since      :
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event  */
document.onclick = processButtonClick;

	// Event handler processing by button name */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		/** **************************************************** */
		var frmObj = document.form;
		var shtObj = sheetObjects[0];
		var shtObj2 = sheetObjects[1];

		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
				break;

				case "btn_new":
					ComResetAll();
				break;


				case "btn_confirm":
					doActionIBSheet(shtObj2, frmObj, IBSAVE);
				break;

				case "btn_transmit":
					frmObj.del_trasmit_flag.value = "";
					doActionIBSheet(shtObj, frmObj, COMMAND01);
				break;

				case "btn_del_transmit":
					frmObj.del_trasmit_flag.value = "Y";
					ComOpenPopup("ESM_BKG_1526_01.do?opnrPgmDiv=1526", 500, 265, "ESM_BKG_1526_01.do?opnrPgmDiv=1526", "1,0", true);
				break;

				case "btn_close":
					ComClosePopup();
				break;

				case "btn_rowadd":
					var newRowIdx = shtObj2.DataInsert(-1);
					shtObj2.SetCellValue(newRowIdx, "bl_no", shtObj.GetCellValue(1, "bl_no"), 0);
					shtObj2.SelectCell(newRowIdx, "new_bl_no", 1);
				break;

				case "btn_delete":
					ComRowHideDelete(shtObj2, "chk");
				break;
			} // end switch

		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
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
	* initializing sheet
	* implementing onLoad event handler in body tag
	* adding first-served functions after loading screen.
	*/
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		ComBtnDisable("btn_confirm");
		ComBtnDisable("btn_transmit");
		ComBtnDisable("btn_del_transmit");
		ComBtnDisable("btn_rowadd");
		ComBtnDisable("btn_delete");

		var frmObj = document.form;
		if (frmObj.bl_no.value != "") {
			var shtObj = sheetObjects[0];
			shtObj.SetCellValue(shtObj.DataInsert(-1), "bl_no", frmObj.bl_no.value, 0);
			doActionIBSheet(shtObj, frmObj, IBSEARCH);
		}
	}


	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(shtObj, shtNo) {
		var cnt = 0;
		with (shtObj) {
			switch (id) {
				case "sheet1":
					var HeadTitle = "|B/L No.|VVD|POL|POD|TTL PCS|G.WGT|Current Status|BLL Send Status|BLL Send Date";
					SetConfig({SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0});
					var info = {Sort:1, ColMove:0, HeaderCheck:0, ColResize:1};
					var headers = [{Text:HeadTitle, Align:"Center"}];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",   Hidden:1,   Width:50,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								{Type:"Text",     Hidden:0,   Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bl_no" },
								{Type:"Text",     Hidden:0,   Width:95,    Align:"Center",  ColMerge:0,   SaveName:"vvd" },
								{Type:"Text",     Hidden:0,   Width:50,    Align:"Center",  ColMerge:0,   SaveName:"pol_cd" },
								{Type:"Text",     Hidden:0,   Width:50,    Align:"Center",  ColMerge:0,   SaveName:"pod_cd" },
								{Type:"Text",     Hidden:0,   Width:60,    Align:"Center",  ColMerge:0,   SaveName:"pck_qty" },
								{Type:"Text",     Hidden:0,   Width:60,    Align:"Center",  ColMerge:0,   SaveName:"grs_wgt" },
								{Type:"Text",     Hidden:0,   Width:100,   Align:"Center",  ColMerge:0,   SaveName:"a_s_type" },
								{Type:"Text",     Hidden:0,   Width:105,   Align:"Center",  ColMerge:0,   SaveName:"bll_snd_sts_cd" },
								{Type:"Text",     Hidden:0,   Width:115,   Align:"Center",  ColMerge:0,   SaveName:"bll_snd_dt" } ];
					InitColumns(cols);

					SetWaitImageVisible(0);
					SetEditable(0);
					SetCountPosition(0);
					SetSheetHeight(55, 1);
				break;

				case "sheet2":
					var HeadTitle = "|Seq.| Del.|B/L No.|VVD|POL|POD|TTL PCS|G.WGT|Current Status|Sent Date|BLL Send Status|BLL Send Date" +
									// Hidden column
									"|bl_no(original)|snd_tp_cd";

					SetConfig({SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0});
					var info = {Sort:1, ColMove:0, HeaderCheck:1, ColResize:1};
					var headers = [{Text:HeadTitle, Align:"Center"}];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",     Hidden:1,   Width:50,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								{Type:"Seq",        Hidden:0,   Width:30,    Align:"Center",  ColMerge:0,   SaveName:"seq" },
								{Type:"DummyCheck", Hidden:0,   Width:50,    Align:"Center",  ColMerge:0,   SaveName:"chk" },
								{Type:"Text",       Hidden:0,   Width:100,   Align:"Center",  ColMerge:0,   SaveName:"new_bl_no",      KeyField:1, UpdateEdit:0, InsertEdit:1, EditLen:12, AcceptKeys:"E|N", InputCaseSensitive:1 },
								{Type:"Text",       Hidden:0,   Width:95,    Align:"Center",  ColMerge:0,   SaveName:"vvd",            Edit:0 },
								{Type:"Text",       Hidden:0,   Width:50,    Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         Edit:0 },
								{Type:"Text",       Hidden:0,   Width:50,    Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         Edit:0 },
								{Type:"Text",       Hidden:0,   Width:60,    Align:"Center",  ColMerge:0,   SaveName:"pck_qty",        Edit:0 },
								{Type:"Text",       Hidden:0,   Width:60,    Align:"Center",  ColMerge:0,   SaveName:"grs_wgt",        Edit:0 },
								{Type:"Text",       Hidden:0,   Width:100,   Align:"Center",  ColMerge:0,   SaveName:"a_s_type",       Edit:0 },
								{Type:"Text",       Hidden:0,   Width:115,   Align:"Center",  ColMerge:0,   SaveName:"s_dt",           Edit:0 },
								{Type:"Text",       Hidden:0,   Width:105,   Align:"Center",  ColMerge:0,   SaveName:"bll_snd_sts_cd", Edit:0 },
								{Type:"Text",       Hidden:0,   Width:115,   Align:"Center",  ColMerge:0,   SaveName:"bll_snd_dt",     Edit:0 },

								{Type:"Text",       Hidden:1,   Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bl_no" },
								{Type:"Text",       Hidden:1,   Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bll_snd_tp_cd",  DefaultValue:"S" } ];
					InitColumns(cols);

					SetWaitImageVisible(0);
					SetEditable(1);
					SetSheetHeight(ComGetSheetHeight(shtObj, 10));
				break;
			}
		}
	}


	/**
	* Sheet process handling
	* @param shtObj
	* @param formObj
	* @param sAction
	* @return
	*/function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {
			case IBSEARCH:    // Retrieve
				ComOpenWait(true);
				var blNo = frmObj.bl_no.value;
				frmObj.f_cmd.value = SEARCH;
				var xmlArr = shtObj.GetSearchData("ESM_BKG_1526GS.do", FormQueryString(frmObj)).split("|$$|");
				ComResetAll();    //기본 object 초기화
				frmObj.bl_no.value = blNo;
				if (xmlArr == null || xmlArr == "") {
					shtObj.SetCellValue(shtObj.DataInsert(-1), "bl_no", frmObj.bl_no.value, 0);
					ComShowCodeMessage("COM130401");    // There is no data to search.
				} else {
					if (ComBkgErrMessage(sheetObjects[1], xmlArr[1])) sheetObjects[1].LoadSearchData(xmlArr[1], {Sync:1});
					if (ComBkgErrMessage(shtObj, xmlArr[0])) shtObj.LoadSearchData(xmlArr[0], {Sync:1});
				}
				ComOpenWait(false);
			break;

			case IBROWSEARCH:    // Row Search
				frmObj.f_cmd.value = SEARCH01;    // sheet2_OnSearchEnd에서 구분시 사용
				var rowIdx = CondParam;
				var newBlNo = shtObj.GetCellValue(rowIdx, "new_bl_no");
				var bllSndStsCd = sheetObjects[0].GetCellValue(1, "bll_snd_sts_cd");
				var blNo = shtObj.GetCellValue(rowIdx, "bl_no");
				shtObj.DoRowSearch(rowIdx, "ESM_BKG_1526GS.do", "f_cmd="+frmObj.f_cmd.value+"&new_bl_no="+newBlNo+"&bll_snd_sts_cd="+bllSndStsCd+"&bl_no="+blNo, {Sync:2});
				var aSType = shtObj.GetEtcData("a_s_type");
				if (aSType == "0") {
					ComShowMessage("B/L No. ["+newBlNo+"] no data found.");
					shtObj.SetCellValue(rowIdx, "new_bl_no", "", 0);
					shtObj.SelectCell(rowIdx, "new_bl_no", 1);
				} else if (aSType == "1") {
					ComShowMessage("B/L No. ["+newBlNo+"] was not sent.");
					shtObj.SetCellValue(rowIdx, "new_bl_no", "", 0);
					shtObj.SelectCell(rowIdx, "new_bl_no", 1);
				}
			break;

			case IBSAVE:    // Save
				// Sheet의 Mandatory Check 용도
				if (shtObj.RowCount() > 0 && shtObj.GetSaveString(true) == "") return;
				var dupRow = shtObj.ColValueDup("new_bl_no", 0);
				if (dupRow > 0) {
					ComShowCodeMessage("BKG00460", shtObj.GetCellValue(dupRow, "new_bl_no"));    // "Duplication occurred.({?msg1})"
					shtObj.SetCellValue(dupRow, "new_bl_no", "", 0);
					shtObj.SelectCell(dupRow, "new_bl_no", 1);
					return;
				}
				if (!ComShowCodeConfirm("COM130101", "data")) return;    // "Do you want to save {?msg1}?"
				ComOpenWait(true);
				frmObj.f_cmd.value = MULTI;
				shtObj.DoAllSave("ESM_BKG_1526GS.do", {Param:FormQueryString(frmObj), Quest:0, Sync:1});
				ComOpenWait(false);
			break;

			case COMMAND01:    // EDI Transmit
				if (shtObj.IsDataModified()) {
					ComShowCodeMessage("BKG00178");    // "Data modifed, save modifed data first!"
					return;
				}
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				var blNo = frmObj.bl_no.value;
				frmObj.f_cmd.value = COMMAND01;
				shtObj.DoAllSave("ESM_BKG_1526GS.do", {Param:FormQueryString(frmObj), Quest:0, Sync:1});
				frmObj.bl_no.value = blNo;
				ComOpenWait(false);
			break;
		}
	}


	/**
	 * handling after retrieve
	 */
	function sheet1_OnSearchEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) return;
		if (shtObj.RowCount() < 1) {
			ComBtnDisable("btn_confirm");
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_delete");
		} else {
			ComBtnEnable("btn_confirm");
			ComBtnEnable("btn_rowadd");
			ComBtnEnable("btn_delete");
		}
	}


	/**
	 * handling after retrieve
	 */
	function sheet2_OnSearchEnd(shtObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) return;
		shtObj.SetHeaderCheck(0, "chk", 0);
//		ComBtnEnable("btn_transmit");
//		ComBtnEnable("btn_del_transmit");
	}


	/**
	 * clicking same row of hidden sheet at checkbox in case of clicking checkbox of sheet
	 */
	function sheet2_OnChange(shtObj, Row, Col, Value) {
		with (shtObj) {
			switch (ColSaveName(Col)) {
				case "new_bl_no":
					if (Value.trim() != "") {
						var dupRow = shtObj.ColValueDup(Col, 0);
						if (dupRow > 0) {
							ComShowCodeMessage("BKG00460", shtObj.GetCellValue(Row, Col));    // "Duplication occurred.({?msg1})"
							shtObj.SetCellValue(Row, Col, "", 0);
							shtObj.SelectCell(Row, Col, 1);
							return;
						}
						doActionIBSheet(shtObj, document.form, IBROWSEARCH, Row);
					}
				break;
			}
		}
	}


	/**
	 * handling event after saving
	 */
	function sheet2_OnSaveEnd(shtObj, Code, Msg, StCode, StMsg) {
		ComOpenWait(false);
		if (Code < 0) return;
		ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
		// Retrieve after saving
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
