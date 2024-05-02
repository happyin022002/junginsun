/* =========================================================
 *Copyright(c) 2014 CyberLogitec All Rights Reserved
 *@FileName : Esm_bkg_0477.js
 *@FileTitle : Transmit History to SEA_NACCS
 *@author : CLT
 *@version : 1.0
 *@since : 2014.04.24
 =========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var sheetObjects = new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick = processButtonClick;

	function processButtonClick() {
		/** *** using extra sheet valuable if there are more 2 sheets **** */
		/** **************************************************** */
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "date_check":
					if (formObj.date_check.checked) {
						formObj.start_snd_dt.disabled = false;
						formObj.start_snd_dt.className = "input1";
						formObj.start_snd_dt.setAttribute("required", "");
						//formObj.start_snd_dt2.value = "00:00";
						formObj.start_snd_dt2.disabled = false;
						formObj.start_snd_dt2.className = "input1";
						formObj.start_snd_dt2.setAttribute("required", "");
						formObj.end_snd_dt.disabled = false;
						formObj.end_snd_dt.className = "input1";
						formObj.end_snd_dt.setAttribute("required", "");
						//formObj.end_snd_dt2.value = "23:59";
						formObj.end_snd_dt2.disabled = false;
						formObj.end_snd_dt2.className = "input1";
						formObj.end_snd_dt2.setAttribute("required", "");
						formObj.btn_calendar.disabled = false;
						formObj.vvd_cd.className = "input";
						formObj.vvd_cd.removeAttribute("required");
					} else {
						formObj.vvd_cd.setAttribute("required", "");
						formObj.vvd_cd.className = "input1";
						formObj.btn_calendar.disabled = true;
						//formObj.start_snd_dt.value = "";
						formObj.start_snd_dt.removeAttribute("required");
						formObj.start_snd_dt.className = "input2";
						formObj.start_snd_dt.disabled = true;
						//formObj.start_snd_dt2.value = "";
						formObj.start_snd_dt2.removeAttribute("required");
						formObj.start_snd_dt2.className = "input2";
						formObj.start_snd_dt2.disabled = true;
						//formObj.end_snd_dt.value = "";
						formObj.end_snd_dt.removeAttribute("required");
						formObj.end_snd_dt.className = "input2";
						formObj.end_snd_dt.disabled = true;
						//formObj.end_snd_dt2.value = "";
						formObj.end_snd_dt2.removeAttribute("required");
						formObj.end_snd_dt2.className = "input2";
						formObj.end_snd_dt2.disabled = true;
					}
					break;

				case "btn_resend":
					doActionIBSheet(sheetObj, formObj, IBSAVE);
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;

				case "btn_view":
					doActionIBSheet(sheetObj, formObj, SEARCH11);
					break;

				case "btn_calendar":
					// prohibiting to use before searching.
					var cal = new ComCalendarFromTo();
					cal.select(formObj.start_snd_dt,formObj.end_snd_dt, "yyyy-MM-dd");
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
	* adding process for list in case of needing batch processing with other items
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
		ComBtnDisable("btn_resend");
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
	 * Dynamic loading the event of  HTML Control in the page <br>
	 * initializing IBSheet Object when this function is called from {@link #loadPage} <br>
	 */
	function initControl() {
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObject);
		axon_event.addListener("keydown", "ComKeyEnter", "form");
	}


	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 * @param sheetObj sheet Object
	 * @param sheetNo sequence
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
				var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":      //sheet1 init
				with(sheetObj) {
					var HeadTitle1="|Sel.|Seq.|MSG|Send Date|Send Date|Office|User ID|VVD|POD|B/L No.|STS|Update|Update|";
					SetConfig({ SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 });
					var info = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status", Hidden:1,   Width:0,    Align:"Center",   SaveName:"ibflag" },
								{Type:"Radio",  Hidden:0,   Width:30,   Align:"Center",   SaveName:"sel" },
								{Type:"Seq",    Hidden:0,   Width:45,   Align:"Center",   SaveName:"seq" },
								{Type:"Text",   Hidden:0,   Width:65,   Align:"Center",   SaveName:"jp_snd_log_id", Format:"",    Edit:0 },
								{Type:"Text",   Hidden:0,   Width:80,   Align:"Center",   SaveName:"snd_dt",        Format:"Ymd", Edit:0 },
								{Type:"Text",   Hidden:0,   Width:70,   Align:"Center",   SaveName:"snd_dt2",       Format:"Hms", Edit:0 },
								{Type:"Text",   Hidden:0,   Width:70,   Align:"Center",   SaveName:"ofc_cd",        Format:"",    Edit:0 },
								{Type:"Text",   Hidden:0,   Width:85,   Align:"Center",   SaveName:"upd_usr_id",    Format:"",    Edit:0 },
								{Type:"Text",   Hidden:0,   Width:95,   Align:"Center",   SaveName:"vvd_cd",        Format:"",    Edit:0 },
								{Type:"Text",   Hidden:0,   Width:65,   Align:"Center",   SaveName:"pod_cd",        Format:"",    Edit:0 },
								{Type:"Text",   Hidden:0,   Width:130,  Align:"Center",   SaveName:"bl_no",         Format:"",    Edit:0 },

								{Type:"Text",   Hidden:1,   Width:60,   Align:"Center",   SaveName:"log_flg" },
								{Type:"Text",   Hidden:1,   Width:100,  Align:"Center",   SaveName:"log_dt"  },
								{Type:"Text",   Hidden:1,   Width:50,   Align:"Left",     SaveName:"log_dt2" },
								{Type:"Text",   Hidden:1,   Width:50,   Align:"Center",   SaveName:"log_seq" } ];

					InitColumns(cols);

					SetEditable(1);
					SetCountFormat("[SELECTDATAROW / TOTALROWS]");
					SetWaitImageVisible(0);
					ComResizeSheet(sheetObj);
				}
				break;
		}
	}


	/**
	* handling of Sheet
	* @param sheetObj Sheet
	* @param formObj form object
	* @param sAction code
	* @param CondParam CondParam
	* @param PageNo PageNo
	*/
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH:
				if (!validateForm(sheetObj, formObj, sAction)) return;
				formObj.f_cmd.value = SEARCH;
				ComOpenWait(true);
				sheetObj.DoSearch("ESM_BKG_0477GS.do", FormQueryString(formObj)+"&"+"iPage=1", {Append:false, Sync:2});
				iPageNo = 1;
				ComOpenWait(false);
				break;

			case IBSEARCHAPPEND:  // searching paging
				if (!validateForm(sheetObj, formObj, IBSEARCH)) return;
				formObj.f_cmd.value = SEARCH;
				ComOpenWait(true);
				if (PageNo > 0) {
					sheetObj.DoSearch("ESM_BKG_0477GS.do", FormQueryString(formObj)+"&"+"iPage=" + PageNo, {Append:true, Sync:2});
				} else {
					sheetObj.DoSearch("ESM_BKG_0477GS.do", FormQueryString(formObj)+"&"+"iPage=1", {Append:false, Sync:2});
				}
				ComOpenWait(false);
				break;

			case SEARCH11:
				if (!validateForm(sheetObj, formObj, sAction)) return;
				var chkRow = sheetObj.FindCheckedRow("sel");
				var jpSndLogId = sheetObj.GetCellValue(chkRow, "jp_snd_log_id");
				var sndDt = sheetObj.GetCellValue(chkRow, "snd_dt");
				var sndDt2 = sheetObj.GetCellValue(chkRow, "snd_dt2");
				var logSeq = sheetObj.GetCellValue(chkRow, "log_seq");
				var ofcCd = sheetObj.GetCellValue(chkRow, "ofc_cd");
				var blNo = sheetObj.GetCellValue(chkRow, "bl_no");
				var sUrl = "ESM_BKG_0478.do?pgmNo=ESM_BKG_0478&jpSndLogId=" + jpSndLogId + "&blNo=" + blNo + "&sndDt=" + sndDt+sndDt2 + "&logSeq=" + logSeq + "&ofcCd=" + ofcCd;
				ComOpenWindowCenter(sUrl, "ESM_BKG_0478", 700, 400, false);
				break;

			case IBSAVE:    // Resend
				if (!validateForm(sheetObj, formObj, sAction)) return;
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_BKG_0477GS.do", {Param:FormQueryString(formObj), Quest:0, Sync:1});
				ComOpenWait(false);
				break;

		}
	}


	var iPageNo = 1;
	function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
		 if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
		 doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
	}


	/**
	 * handling in case of clicking on sheet
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		with (sheetObj) {
			switch (ColSaveName(Col)) {
				case "sel":
					if (Value == 1) {
						// MFR, CMF01, CMF03만 Resend 가능
						var jpSndLogId = GetCellValue(Row, "jp_snd_log_id");
						if (jpSndLogId.indexOf("DMF") > -1) {
							ComBtnEnable("btn_resend");
						} else {
							ComBtnDisable("btn_resend");
						}
					} else {
						ComBtnDisable("btn_resend");
					}
				break;
			}
		}
	}


	/**
	 * handling event after Retrieve
	 */
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (Code < 0 || sheetObj.RowCount() < 1) return;
	}


	/**
	 * handling event after saving
	 */
	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (Code < 0) return;
		// Retrieve after saving
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}


	/**
	* handling process for input validation
	* @param sheetObj Sheet
	* @param formObj form object
	* @param sAction
	*/
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
				if (!ComChkValid(formObj)) return false;
				if (!formObj.date_check.checked && formObj.vvd_cd.value == "" && formObj.usr_id.value == "" && formObj.ofc_cd.value == "") {
					ComShowCodeMessage("BKG06004");
					formObj.start_snd_dt.focus();
					return false;
				}
				break;

			case IBSAVE:
			case SEARCH11:
				if (sheetObj.CheckedRows("sel") < 1) {
					ComShowCodeMessage("BKG00249");    // No Selected Row
					return false;
				}
				break;
			}
		return true;
	}
