/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_1522.js
 *@FileTitle  : Malaysia Import Status I/F
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/09
=========================================================*/
//global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;

//Event handler processing by button click event */
document.onclick=processButtonClick;

	//Event handler processing by button name */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObj1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = ComGetEvent("name");
			switch(srcName) {
				case "btn_RowAdd":
					sheetObj1.DataInsert(-1);
				break;

				case "btn_Delete":
					if (ComShowCodeConfirm("BKG95003", "delete")) {
						doActionIBSheet(sheetObj1, formObject, IBDELETE);
					}
				break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObj1, formObject, IBSEARCH);
				break;

				case "btn_SpecialInfo":
					openSpecialInfo();
				break;

				case "btn_Save":
					if (sheetObj1.RowCount() < 1) {
						ComShowMessage("There is no data to save.");
						return;
					}
					doActionIBSheet(sheetObj1, formObject, IBSAVE);
				break;

				case "btn_DownExcel":
					with (sheetObj1) {
						if (RowCount() < 1) {    //no data
							ComShowCodeMessage("COM132501");
							return;
						}
						var skipRows="";
						for (var i=HeaderRows(); i<=LastRow(); i++) {
							if (GetCellValue(i, "sel") == 0) skipRows += ("|" + i);
						}
						Down2Excel({HiddenColumn:true, Merge:true, TreeLevel:false, SheetDesign:1});    //*****
					}
				break;

				case "btn_PrintView":
					with (sheetObj1) {
						if (RowCount() < 1) {
							ComShowCodeMessage("COM131002");    // There is no data to print.
							return;
						}
						if (CheckedRows("sel") < 1) {
							ComShowCodeMessage("COM12189");    // Nothing selected
							return;
						}
						// sorting
						ColumnSort("pol_cd|pod_cd");
						ComOpenWindowCenter("ESM_BKG_0884.do?pgmNo=ESM_BKG_0884&pod=" + formObject.pod_cd.value, "ESM_BKG_0884", 1024, 700, false);
					}
				break;

				case "btn_MalaysiaIF":
					formObject.receiver_id.value = "MYIMP";
					doActionIBSheet(sheetObjects[1], formObject, COMMAND01);
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}


	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0;i<sheetObjects.length;i++) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// handling Key
		//axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener("keydown", "ComKeyEnter", "form");

		// HTML Object setting
		ComAddBeginComboItem(document.form.type_cd, "All", "");
		ComSetObjValue(document.form.type_cd, "");

		// IBSheet내 Combo initialization
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	}


	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":
				with(sheetObj) {
					var HeadTitle = "|Seq.|Sel.|SPC|Save|Container No.|TP/SZ|Booking No.|SEAL No.|POL|Last POD|Weight|TP|RF|DG|AK|BB|RD|FM" +
									"|Next VVD|Next VVD|Next VVD|TML-Vessel Name|Ship Call No.|Next POD|Next POD2|COP|IOP|OOP|Batch No.|L/Ins.|Send Date" +
									"|vgm_wgt|del_cntr_yn|n3rd_pod_cd|psa_cre_tp_cd";
					var headCount = ComCountHeadTitle(HeadTitle);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:1 } );

					var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 } ;
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  SaveName:"ibflag" },
								{Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  SaveName:"seq" },
								{Type:"CheckBox",  Hidden:0,  Width:45,   Align:"Center",  SaveName:"sel" },
								{Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  SaveName:"spc",                Edit:0 },
								{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  SaveName:"saveYn",             Edit:0 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  SaveName:"cntr_no",            KeyField:1,     UpdateEdit:0,      InsertEdit:1,        EditLen:11,          AcceptKeys:"E|N",     InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  SaveName:"cntr_tpsz_cd",       KeyField:1,     InsertEdit:1,      EditLen:2,           AcceptKeys:"E|N",    InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:97,   Align:"Center",  SaveName:"bkg_no",             KeyField:1,     InsertEdit:1,      EditLen:12,          AcceptKeys:"E|N",    InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  SaveName:"seal_no",            EditLen:9,      AcceptKeys:"E|N",  InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  SaveName:"pol_cd",             EditLen:5,      AcceptKeys:"E|N",  InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  SaveName:"pod_cd",             EditLen:5,      AcceptKeys:"E|N",  InputCaseSensitive:1 },
								{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   SaveName:"cntr_wgt",           EditLen:12,     Format:"Float",    DefaultValue:"0" },
								{Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  SaveName:"ts_tp_cd",           EditLen:1,      AcceptKeys:"E",    InputCaseSensitive:1 },

								{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  SaveName:"rc_flg",             KeyField:1,     UpdateEdit:0,      InsertEdit:1,        EditLen:1,           AcceptKeys:"[YN]",    InputCaseSensitive:1,    DefaultValue:"N" },
								{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  SaveName:"dcgo_flg",           KeyField:1,     UpdateEdit:0,      InsertEdit:1,        EditLen:1,           AcceptKeys:"[YN]",    InputCaseSensitive:1,    DefaultValue:"N" },
								{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  SaveName:"awk_cgo_flg",        KeyField:1,     UpdateEdit:0,      InsertEdit:1,        EditLen:1,           AcceptKeys:"[YN]",    InputCaseSensitive:1,    DefaultValue:"N" },
								{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  SaveName:"bb_cgo_flg",         KeyField:1,     UpdateEdit:0,      InsertEdit:1,        EditLen:1,           AcceptKeys:"[YN]",    InputCaseSensitive:1,    DefaultValue:"N" },
								{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  SaveName:"rd_cgo_flg",         KeyField:1,     UpdateEdit:0,      InsertEdit:1,        EditLen:1,           AcceptKeys:"[YN]",    InputCaseSensitive:1,    DefaultValue:"N" },

								{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  SaveName:"fm_cd",              EditLen:1,      AcceptKeys:"[FM]", InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  SaveName:"next_vsl_cd",        UpdateEdit:0,   InsertEdit:1,      EditLen:4,           AcceptKeys:"E|N",    InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  SaveName:"next_skd_voy_no",    UpdateEdit:0,   InsertEdit:1,      EditLen:4,           AcceptKeys:"N",      InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  SaveName:"next_skd_dir_cd",    UpdateEdit:0,   InsertEdit:1,      EditLen:1,           AcceptKeys:"E|N",    InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    SaveName:"psa_vsl_nm",         Edit:0 },
								{Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  SaveName:"psa_voy_dir_cd",     Edit:0 },
								{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  SaveName:"n1st_pod_cd",        Edit:1,         EditLen:5,         AcceptKeys:"E|N",    InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  SaveName:"n2nd_pod_cd",        Edit:1,         EditLen:5,         AcceptKeys:"E|N",    InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  SaveName:"cop",                EditLen:4,      AcceptKeys:"E|N",  InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  SaveName:"iop",                EditLen:4,      AcceptKeys:"E|N",  InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  SaveName:"oop",                EditLen:4,      AcceptKeys:"E|N",  InputCaseSensitive:1 },
								{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  SaveName:"batch_no",           EditLen:20,     AcceptKeys:"E|N",  InputCaseSensitive:1 },
								{Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  SaveName:"ld_ins" },
								{Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  SaveName:"snd_dt",             Edit:0 },

								{Type:"Float",     Hidden:1,  Width:60,   Align:"Right",   SaveName:"vgm_wgt",            EditLen:12,     Format:"Float",    DefaultValue:"0" },
								{Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  SaveName:"sav" },
								{Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  SaveName:"n3rd_pod_cd" },
								{Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  SaveName:"psa_cre_tp_cd",      DefaultValue:"A" }  ];
					InitColumns(cols);

					SetEditable(1);
					SetWaitImageVisible(0);
					SetShowButtonImage(3);
					SetSheetHeight(402);
				}
			break;

			case "sheet2":
				with(sheetObj) {
					var HeadTitle="|Seq";
					var headCount=ComCountHeadTitle(HeadTitle);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 } ;
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1,  Width:100,   Align:"Center",  SaveName:"ibflag" } ,
								 {Type:"Seq",       Hidden:0,  Width:100,   Align:"Center",  SaveName:"seq" } ];
					InitColumns(cols);

					SetWaitImageVisible(0);
					SetSheetHeight(100);
					SetVisible(0);

				}
			break;
		}
	}


	// handling of Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:      // IBSheet내 Combo initialization
				var sXml = sheetObj.GetSearchData("ESM_BKG_1522GS.do", "f_cmd=" + INIT);
				var comboCode = ComGetEtcData(sXml, "combo_code");
				var comboText = ComGetEtcData(sXml, "combo_text");
				sheetObj.SetColProperty("ld_ins", {ComboCode:comboCode, ComboText:comboText});
			break;

			case IBSEARCH:
				if (!validateForm(sheetObj, formObj, sAction)) return;
				ComOpenWait(true);
				formObj.vsl_nm.value = "";
				formObj.vsl_voyage.value = "";
				sheetObj.RemoveAll();
				sheetObj.RemoveEtcData();
				formObj.f_cmd.value = SEARCH;
				var xmlStr = sheetObj.GetSearchData("ESM_BKG_1522GS.do", FormQueryString(formObj));
				if (ComGetEtcData(xmlStr, "vsl_nm") == "" || ComGetEtcData(xmlStr, "vsl_voyage") == "") {
					ComShowMessage("Unable to transmit due to missing of KCT Voyage No. Please set the KCT Voyage first");
					ComOpenWait(false);
					return;
				}
				sheetObj.LoadSearchData(xmlStr, {Sync:1} );
			break;

			case IBSAVE:
				if (!validateForm(sheetObj, formObj, sAction)) return;
				if (!ComShowCodeConfirm("BKG95003", "save")) return;
				var saveString = "";
				if (sheetObj.GetSaveString(0) == "") {
					return;
				} else {
					saveString = ComSetPrifix(sheetObj.GetSaveString(0), "sheet1_");
				}
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				var xmlStr = sheetObj.GetSaveData("ESM_BKG_1522GS.do", FormQueryString(formObj) + "&" + saveString);
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != null && backEndJobKey != undefined && backEndJobKey != "" &&
					backEndJobKey.toUpperCase() != "NULL" && backEndJobKey.toUpperCase() != "UNDEFINDE") {
					sheetObj.SetWaitTimeOut(20000);
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			break;

			case IBDELETE:
				ComRowHideDelete(sheetObj, "sel");
			break;

			case COMMAND01:    // TRANSMIT
				if (!validateForm(sheetObj, formObj, sAction)) return;
				if (!ComShowCodeConfirm("BKG95003", "transmit")) return;
				ComOpenWait(true);
				sheetObj.RemoveAll();
				sheetObj.DataInsert(-1);
				formObj.f_cmd.value = COMMAND01;
				var xmlStr = sheetObj.GetSaveData("ESM_BKG_1522GS.do", FormQueryString(formObj));
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != null && backEndJobKey != undefined && backEndJobKey != "" &&
					backEndJobKey.toUpperCase() != "NULL" && backEndJobKey.toUpperCase() != "UNDEFINDE") {
					sheetObj.SetWaitTimeOut(20000);
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			break;
		}
	}


	/**
	 * Call - BackEndJob : check jobState : '3'
	 */
	function getBackEndJobStatus() {
		var sheetObj2 = sheetObjects[1];
		var xmlStr = sheetObj2.GetSearchData("ESM_BKG_1522GS.do", "f_cmd=" + SEARCH02 + "&backEndJob_Key=" + backEndJobKey);
		var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg");

		if (jbStsFlg == "3") {
			var formObj = document.form;

			if (formObj.f_cmd.value == MULTI) {
				xmlStr = "";
				xmlStr = sheetObj2.GetSaveData("ESM_BKG_1522GS.do", "f_cmd=" + MULTI03 + "&backEndJob_Key=" + backEndJobKey);
				clearInterval(timer);
				backEndJobKey = "";
				ComOpenWait(false);
				// 저장 후 재조회 (sheet2_OnSaveEnd에서 재조회를 하게 되면 backEndJob의 ComOpenWait이 정상작동하지 않음으로, 여기에 위치)
				if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "S") {
					ComShowCodeMessage("COM130102", "Data");    // {?msg1} was saved successfully.
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				} else {
					sheetObj2.LoadSaveData(xmlStr);
				}

			} else if (formObj.f_cmd.value == COMMAND01) {
				xmlStr = "";
				xmlStr = sheetObj2.GetSaveData("ESM_BKG_1522GS.do", "f_cmd=" + COMMAND03 + "&backEndJob_Key=" + backEndJobKey);
				clearInterval(timer);
				backEndJobKey = "";
				ComOpenWait(false);
				// 저장 후 재조회 (sheet2_OnSaveEnd에서 재조회를 하게 되면 backEndJob의 ComOpenWait이 정상작동하지 않음으로, 여기에 위치)
				if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "S") {
					ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				} else {
					sheetObj2.LoadSaveData(xmlStr);
				}
			}
		} else if (jbStsFlg == "4") {
			clearInterval(timer);
			backEndJobKey = "";
			ComOpenWait(false);
			ComShowCodeMessage("COM130406", "using Back End Job");    // Failed to retrieve {?msg1}. Please try again.
		}
	}


	/**
	 * handling event after saving
	 */
	function sheet1_OnSearchEnd(sheetObj, Code, Msg) {
		ComOpenWait(false);
		if (Code < 0) return;
		with (sheetObj) {
			if (SearchRows() > 0) {
				document.form.vsl_nm.value = GetEtcData("vsl_nm");
				document.form.vsl_voyage.value = GetEtcData("vsl_voyage");
				for (var i=HeaderRows(); i<=LastRow(); i++) {
					if (GetCellValue(i, "sav") == "+") {
						SetCellValue(i, "saveYn", "N");
						SetRowStatus(i, "I");
						SetCellEditable(i, "next_vsl_cd", 0);
						SetCellEditable(i, "next_skd_voy_no", 0);
						SetCellEditable(i, "next_skd_dir_cd", 0);
						SetCellEditable(i, "rc_flg", 0);
						SetCellEditable(i, "dcgo_flg", 0);
						SetCellEditable(i, "awk_cgo_flg", 0);
						SetCellEditable(i, "bb_cgo_flg", 0);
						SetCellEditable(i, "rd_cgo_flg", 0);

					} else {
						SetCellValue(i, "saveYn", "Y");
						if (GetCellValue(i, "sav") == "-") SetCellFontColor(i, "saveYn", "#FF0000");
						SetRowStatus(i, "");
					}
				}
				SetHeaderCheck(0, "sel", 1);
			} else {
				SetHeaderCheck(0, "sel", 0);
			}
		}
	}


	/**
	 * clicking same row of hidden sheet at checkbox in case of clicking checkbox of sheet
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		with (sheetObj) {
			switch (ColSaveName(Col)) {
				case "n1st_pod_cd":
					SetCellValue(Row, "n3rd_pod_cd", Value);
				break;
			}
		}
	}


	/**
	 * Sheet1 handling event of double clicking (searching Special Info )
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		if (Col==3) openSpecialInfo();
	}


	/**
	 * Special Info pop up
	 * @return
	 */
	function openSpecialInfo() {
		if (!validateForm(sheetObjects[0], document.form, IBSEARCH)) return;
		if (sheetObjects[0].GetSelectRow() < 0) {
			ComShowCodeMessage("COM12189");    // Nothing selected
			return;
		}
		var params = "?pgmNo=ESM_BKG_1524&cntr_no=" + (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cntr_no") == -1 ? "" : sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cntr_no"))
					+ "&bkg_no=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "bkg_no")
					+ "&vsl_cd=" + document.form.vsl_cd.value
					+ "&skd_voy_no=" + document.form.skd_voy_no.value
					+ "&skd_dir_cd=" + document.form.skd_dir_cd.value
					+ "&select_row=" + sheetObjects[0].GetSelectRow();
		ComOpenPopup("ESM_BKG_1524.do?" + params, 715, 450, "", "1,0", true);
	}


	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		if (!ComChkValid(formObj)) return;

		with (formObj) {
			vsl_cd.value = vvd.value.substring(0, 4);
			skd_voy_no.value = vvd.value.substring(4, 8);
			skd_dir_cd.value = vvd.value.substring(8, 9);
		}

		switch(sAction) {
			case COMMAND01:
				with (sheetObjects[0]) {
					if (RowCount() < 1) {    //no data
						ComShowCodeMessage("COM130402", "Send data");
						return false;
					} else {
						if (IsDataModified()) {
							ComShowMessage("First, save any unsaved data!");
							return false;
						}
						for (var i=HeaderRows(); i<=LastRow(); i++) {
							if (GetCellValue(i, "saveYn") == "N") {
								ComShowMessage("First, save any unsaved data!");
								SelectCell(i, "saveYn");
								return false;
							}
							if (GetCellValue(i, "cntr_wgt") == "" || GetCellValue(i, "cntr_wgt") == 0) {
								ComShowCodeMessage("BKG00765");    "Please input weight."
								SelectCell(i, "cntr_wgt", 1);
								return false;
							}
							if (GetCellValue(i, "next_vsl_cd") != "" &&
								GetCellValue(i, "next_skd_voy_no") != "" &&
								GetCellValue(i, "next_skd_dir_cd") != "" &&
								GetCellValue(i, "psa_vsl_nm") == "") {

								ComShowCodeMessage("BKG08321");
								SelectCell(i, "psa_vsl_nm");
								return false;
							}
						}
					}
				}
			break;
		}
		return true;
	}
