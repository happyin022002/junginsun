/* =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1503.js
*@FileTitle  : Departure Time Registration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
 ========================================================= */
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//Event handler processing by button click event */
	document.onclick = processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		var shtObj = sheetObjects[0];
		var frmObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_calendar":
					var cal = new ComCalendar();
					cal.select(frmObj.etd_date, "yyyy-MM-dd");
					break;
				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
				break;
				case "btn_new":
					frmObj.pol_split_no.className = "input";
					frmObj.pol_split_no.disabled = false;
					ComResetAll();
				break;
				case "btn_transmit":
					doActionIBSheet(shtObj, frmObj, COMMAND01);
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
		ComBtnDisable("btn_transmit");
		initControl();
	}


	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(shtObj, shtNo) {
		with (shtObj) {
			switch (shtObj.id) {
				case "sheet1":    // 트랜잭션을 위해 사용되는 Dummy Sheet
					var cnt = 0;
					var HeadTitle = "status";

					SetEditEnterBehavior("tab");
					SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
					var info = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];

					InitColumns(cols);
					SetEditable(1);
					SetWaitImageVisible(0);
					SetVisible(0);
					break;
			}
		}
	}


	/**
	 * registering initial event
	 */
	function initControl() {
		axon_event.addListener("keydown", "ComKeyEnter", "form");
	}

	/**
	* Sheet process handling
	* @param sheetObj
	* @param formObj
	* @param sAction
	* @return
	*/
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {
			case IBSEARCH:    // Retrieve
				frmObj.etd_date.removeAttribute("required");
				frmObj.etd_time.removeAttribute("required");
				// ETD_DATE를 제외하고 Validation
				if (!ComChkObjValid(frmObj.vvd) || !ComChkObjValid(frmObj.pol_cd)) return;
				ComOpenWait(true);
				var vvd = frmObj.vvd.value;
				var polCd = frmObj.pol_cd.value;
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_BKG_1503GS.do", FormQueryString(frmObj), {Sync:2});
				frmObj.vvd.value = vvd;
				frmObj.pol_cd.value = polCd;
				ComOpenWait(false);
				// HTML Object의 disabled는 ComOpenWait(false)이후에 동작하므로, sheet1_OnSeachEnd가 아닌 여기에 위치
				if (parseInt(shtObj.GetEtcData("data_rows")) < 1) {
					frmObj.pol_split_no.className = "input";
					frmObj.pol_split_no.disabled = false;
					frmObj.etd_date.value = "";
					frmObj.etd_time.value = "";
					frmObj.ib_cssm_voy_no.value = "";
					ComBtnDisable("btn_transmit");
					ComShowCodeMessage("COM130401");    // There is no data to search.
				} else {
					frmObj.pol_split_no.className = "input2";
					frmObj.pol_split_no.disabled = true;
					ComBtnEnable("btn_transmit");
					// 조회된 ETC데이터를 Form의 Element에 setting
					frmObj.etd_date.value = shtObj.GetEtcData("etd_date");
					frmObj.etd_time.value = shtObj.GetEtcData("etd_time");
					frmObj.ib_cssm_voy_no.value = shtObj.GetEtcData("ib_cssm_voy_no");
					if (shtObj.GetEtcData("rlx_div") == "1") {
						frmObj.rlx_div.checked = true;
					} else {
						frmObj.rlx_div.checked = false;
					}
				}
				break;

			case COMMAND01:    // EDI Transmit
				frmObj.etd_date.setAttribute("required", "");
				frmObj.etd_time.setAttribute("required", "");
				if (!ComChkValid(frmObj)) return;
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				frmObj.f_cmd.value = COMMAND01;
				shtObj.LoadSaveData(shtObj.GetSaveData("ESM_BKG_1503GS.do", FormQueryString(frmObj)));
				ComOpenWait(false);
			break;
		}
	}


	/**
	 * handling event after saving
	 */
	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) return;
		ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
	}
