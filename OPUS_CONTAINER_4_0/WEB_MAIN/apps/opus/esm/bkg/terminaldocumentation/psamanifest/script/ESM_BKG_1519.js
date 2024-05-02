/* =========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1519.js
*@FileTitle  : PSA Inbound Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/01
 ========================================================= */

	// global variable
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Event handler processing by button click event */
	document.onclick = processButtonClick;

	// Event handler processing by button name */
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var shtObj = sheetObjects[0];
		var frmObj = document.form;

		try {
			var srcName = ComGetEvent("name");
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
				break;
				case "btn_new":
					ComResetAll();
				break;
				case "btn_transmit":
					doActionIBSheet(shtObj, frmObj, COMMAND01);
				break;
			} // end switch

		} catch(e) {
			if ( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}


	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var frmObj = document.form;
		for (i=0; i<sheetObjects.length; i++){
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	}


	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}


	/**
	 * setting sheet initial values and header
	 * param : shtObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(shtObj, sheetNo) {
		var cnt = 0;
		var sheetID = shtObj.id;
		switch (sheetID) {
			case "sheet1":
				with(shtObj) {
					var HeadTitle = "|SEQ.|SEL.|B/L NO.|Ready|POR|POL|POD|DEL|TP|RF|DG|AK|BB|RD|Sent Date" +
									// Hidden
									"|FM";
					var headCount = ComCountHeadTitle(HeadTitle);
					var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",     Hidden:1,  Width:40,    Align:"Center",   SaveName:"ibflag"        },
								 {Type:"Seq",        Hidden:0,  Width:40,    Align:"Center",   SaveName:"seq"           },
								 {Type:"DummyCheck", Hidden:0,  Width:50,    Align:"Center",   SaveName:"chk" },

								 {Type:"Text",       Hidden:0,  Width:160,   Align:"Center",   SaveName:"bl_no",       Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:50,    Align:"Center",   SaveName:"ready",       Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:100,   Align:"Center",   SaveName:"por_cd",      Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:100,   Align:"Center",   SaveName:"pol_cd",      Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:100,   Align:"Center",   SaveName:"pod_cd",      Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:100,   Align:"Center",   SaveName:"del_cd",      Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:50,    Align:"Center",   SaveName:"ts_ind",      Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:50,    Align:"Center",   SaveName:"rc_flg",      Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:50,    Align:"Center",   SaveName:"dcgo_flg",    Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:50,    Align:"Center",   SaveName:"awk_cgo_flg", Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:50,    Align:"Center",   SaveName:"bb_cgo_flg",  Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:50,    Align:"Center",   SaveName:"rd_cgo_flg",  Edit:0 },
								 {Type:"Text",       Hidden:0,  Width:150,   Align:"Center",   SaveName:"snd_dt",      Edit:0 },

								 {Type:"Text",       Hidden:1,  Width:160,   Align:"Center",   SaveName:"bkg_no",      Edit:0 } ];
					InitColumns(cols);

					SetEditable(1);
					SetWaitImageVisible(0);
					SetSheetHeight(450);
				}
				break;
		}
	}


	/**
	 *
	 * @param shtObj
	 * @param frmObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(shtObj, frmObj, sAction) {
		 shtObj.ShowDebugMsg(false);
		 switch (sAction) {
			case IBSEARCH:    // Retrieve
				if (!ComChkValid(frmObj)) return;
				ComOpenWait(true);
				var vvd = frmObj.vvd.value;
				ComResetAll();
				frmObj.vvd.value = vvd;
				frmObj.f_cmd.value = SEARCH;
				var xmlStr = shtObj.GetSearchData("ESM_BKG_1519GS.do", FormQueryString(frmObj));
				if (ComGetEtcData(xmlStr, "vsl_nm") == "" || ComGetEtcData(xmlStr, "vsl_voyage") == "") {
					ComShowCodeMessage("BKG08321");
					ComOpenWait(false);
					return;
				}
				shtObj.LoadSearchData(xmlStr, {Sync:1});
			break;

			case COMMAND01:    // EDI Transmit
				if (!ComChkValid(frmObj)) return;
				if (shtObj.CheckedRows("chk") < 1) {
					ComShowCodeMessage("COM12189");    // Nothing selected
					return;
				}
				if (!ComShowCodeConfirm("COM130602", "data", "EDI")) return;    // Do you want to transmit {?msg1} to {?msg2}?
				ComOpenWait(true);
				frmObj.f_cmd.value = COMMAND01;
				var saveString = shtObj.GetSaveString(false, true, "chk");
				if (saveString == "") return;
				var xmlStr = shtObj.GetSaveData("ESM_BKG_1519GS.do", FormQueryString(frmObj) + "&" + saveString);
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != "") {
					shtObj.SetWaitTimeOut(20000);
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			break;
		}
	}


	/**
	 * handling event after searching
	 */
	function sheet1_OnSearchEnd(shtObj, Code, Msg, StCode, StMsg) {
		ComOpenWait(false);
		if (Code < 0) return;
		with (shtObj) {
			ReDraw = false;
			for (var i=HeaderRows(); i<=LastRow(); i++) {
				if (GetCellValue(i, "ready") == "N") SetCellEditable(i, "chk", 0);
			}
			ReDraw = true;

			document.form.vsl_nm.value = GetEtcData("vsl_nm");
			document.form.vsl_voyage.value = GetEtcData("vsl_voyage");
		}
	}

	/**
	 * handling event after saving
	 */
	function sheet1_OnSaveEnd(shtObj, Code, Msg, StCode, StMsg) {
		ComOpenWait(false);
		if (Code < 0) return;
		ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
		// Retrieve after saving
		doActionIBSheet(shtObj, document.form, IBSEARCH);
	}


	/**
	 * Call - BackEndJob : check jobState : '3'
	 */
	function getBackEndJobStatus() {
		var shtObj = sheetObjects[0];
		var xmlStr = shtObj.GetSearchData("ESM_BKG_1519GS.do", "f_cmd=" + COMMAND02 + "&backEndJob_Key=" + backEndJobKey);
		var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg");

		if (jbStsFlg == "3") {
			shtObj.LoadSaveData(shtObj.GetSaveData("ESM_BKG_1519GS.do", "f_cmd=" + COMMAND03 + "&backEndJob_Key=" + backEndJobKey), {Sync:1});
			clearInterval(timer);
			backEndJobKey="";
			ComOpenWait(false);

		} else if (jbStsFlg == "4") {
			clearInterval(timer);
			backEndJobKey="";
			ComOpenWait(false);
			ComShowCodeMessage("COM130406", "using Back End Job");    // Failed to retrieve {?msg1}. Please try again.
		}
	}
