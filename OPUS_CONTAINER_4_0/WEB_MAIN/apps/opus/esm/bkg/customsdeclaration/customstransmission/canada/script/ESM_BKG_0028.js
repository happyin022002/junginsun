/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0028.js
 *@FileTitle  : ACI_Vessel Information
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
				OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * business script for esm_bkg_0028
 */
// Common global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var end_no = 0;

//Event handler processing by button click event */
document.onclick = processButtonClick;

	/**
	 * Event handler processing by button name
	 */
	function processButtonClick() {
		/* */
		var sheetObj = sheetObjects[0];
		/** **************************************************** */
		var formObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			if (ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, SEARCH);
				break;

				case "btn_New":
					ComResetAll();
					sheetObj.RemoveEtcData();
				break;

				case "btn_Save":
					doActionIBSheet(sheetObj, formObj, MULTI);
				break;

				case "btn_StartAI":
					doActionIBSheet(sheetObj, formObj, COMMAND01);
				break;

				case "btn_DeleteAI":
					doActionIBSheet(sheetObj, formObj, COMMAND02);
				break;

				case "btn_Modify":
					if (sheetObj.RowCount() < 1) {
						ComShowCodeMessage("BKG00395");
						return;
					}
					if (sheetObj.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					ComOpenPopup("ESM_BKG_0028_01.do", 405, 200, "", "1,0", true);
				break;

				case "btn_SelectAll":
					sheetObj.CheckReverse("chk");
				break;

				case "btn_BlInquiry":
					if (sheetObj.RowCount() < 1) {
						ComShowCodeMessage("BKG00395");
						return;
					}
					sheet1_OnDblClick(sheetObj, sheetObj.GetSelectRow(), "bl_no");
				break;

				case "btn_downexcel":
					if (sheetObj.RowCount() < sheetObj.GetTotalRows()) {
						ComOpenWait(true);
						end_no=sheetObj.GetTotalRows();
						sheetObj.SetTopRow(sheetObj.RowCount());
						ComOpenWait(false);
					}
					if (sheetObj.RowCount() < 1) {    //no data
						ComShowCodeMessage("COM132501");
					} else {
						sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
					}
				break;

				case "btn_Print":
					if (sheetObj.RowCount() < 1) {
						ComShowCodeMessage("BKG00395");
						return;
					}
					if (sheetObj.RowCount() < sheetObj.GetTotalRows()) {
						ComOpenWait(true);
						end_no=sheetObj.GetTotalRows();
						sheetObj.SetTopRow(sheetObj.RowCount());
						ComOpenWait(false);
					}
					ComOpenWindowCenter("ESM_BKG_0871.do?pgmNo=ESM_BKG_0871", "0871", 1024, 768, false);
				break;

				case "btn_calendar":
					var cal=new ComCalendarFromTo();
					cal.select(formObj.s_snd_dt, formObj.e_snd_dt, "yyyy-MM-dd");
				break;

				case "btn2_edit":
					if (sheetObj.CheckedRows("chk") < 1) {
						ComShowCodeMessage("COM12189");    // Nothing selected
						return;
					}
					ComOpenWait(true);
					with (sheetObj) {
						// 체크된 row번호만 수집하여 Loop
						var chkdRowArray = FindCheckedRow("chk").split("|");
						RenderSheet(0);
						for (var k in chkdRowArray) {
							SetCellValue(chkdRowArray[k], "hub_loc_cd", formObj.hub_loc_cd.value);
							SetCellValue(chkdRowArray[k], "ibd_loc_gds_desc", formObj.ibd_loc_gds_desc.value);
						}
						RenderSheet(1);
					}
					ComOpenWait(false);
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
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
		for (i=0; i<sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
			sheetObjects[i].SetWaitImageVisible(0);
		}
		var formObj = document.form;
		if (formObj.cnt_cd.value == "CA") {
			document.getElementById("hub_area").style.visibility = "visible";
			document.getElementById("locGood_area").style.visibility = "visible";
			with (sheetObjects[0]) {
				RenderSheet(0);
				SetColHidden("shpr_nm", 0);
				SetColHidden("cnee_nm", 0);
				SetColHidden("ntfy_nm", 0);
				SetColHidden("hub_loc_cd", 0);
				SetColHidden("ibd_loc_gds_desc", 0);
				RenderSheet(1);
			}
		} else {
			ComBtnDisable("btn_Save");
		}
		ComBtnDisable("btn_DeleteAI");
		ComBtnDisable("btn_Modify");

		initControl();
		formObj.vvd_cd.focus();
	}


	function initControl() {
		axon_event.addListener("keydown", "ComKeyEnter", "form");    // Enter key
		axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
	}


	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1": //sheet1 init
				with (sheetObj) {
					//  if (location.hostname != "")
					var HeadTitle1= "ibflag||Seq.|AI Type|Manifest File No.|M/H|B.Filer|Master B/L No.|ERR|B.STS|VVD|T.BDR|C/A No.|POL|POD|Customs|VSL EDI|B/L EDI|B/L EDI|B/L EDI|C.Filer|C.STS|Action Code" +
									// Hidden column
									"|Shipper Name|Consignee Name|Notify Name|HUB|Location of Goods|action_desc|bkg_no|full_mty_cd|cstms_trsm_sts_cd|pol_cd|pod_cd|bkg_del_cd";
					var HeadTitle2= "ibflag||Seq.|AI Type|Manifest File No.|M/H|B.Filer|Master B/L No.|ERR|B.STS|VVD|T.BDR|C/A No.|POL|POD|Customs|VSL EDI|Sent|VVD|Sent Time|C.Filer|C.STS|Action Code" +
									// Hidden column
									"|Shipper Name|Consignee Name|Notify Name|HUB|Location of Goods|action_desc|bkg_no|full_mty_cd|cstms_trsm_sts_cd|pol_cd|pod_cd|bkg_del_cd";
					var headCount = ComCountHeadTitle(HeadTitle1);
					// (headCount, 5, 0, true);

					SetConfig( {SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1} );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ {Text:HeadTitle1, Align:"Center"}, {Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",   Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								{Type:"CheckBox", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
								{Type:"Seq",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",              Edit:0 },
								{Type:"Text",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ai_type",          Edit:0 },
								{Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            Edit:0 },
								{Type:"Text",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"mh",               Edit:0 },
								{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_file_cd",    Edit:0 },
								{Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mbl_no",           Edit:0 },
								{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"error",            Edit:0 },
								{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",       Edit:0 },
								{Type:"Text",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"t_vvd_cd",         Edit:0 },
								{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bdr_flg",          Edit:0 },
								{Type:"Text",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ca_no",            Edit:0 },
								{Type:"Text",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_cd",       Edit:0 },
								{Type:"Text",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_cd",       Edit:0 },
								{Type:"Text",     Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cstms_port_cd",    Edit:0 },
								{Type:"Text",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"v_mi",             Edit:0 },
								{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"b_mi",             Edit:0 },
								{Type:"Text",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"b_vvd_cd",         Edit:0 },
								{Type:"Text",     Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"mi_snd_dt",        Edit:0 },
								{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_file_tp_cd", Edit:0 },
								{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mf_sts_cd",        Edit:0 },
								{Type:"Text",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"action_code",      Edit:0 },

								// Canada ACI: Amendment Transmit (AI)에만 Display
								{Type:"Text",     Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"shpr_nm",          Edit:0 },
								{Type:"Text",     Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cnee_nm",          Edit:0 },
								{Type:"Text",     Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ntfy_nm",          Edit:0 },
								{Type:"Text",     Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"hub_loc_cd",       Edit:1,    EditLen:5,   AcceptKeys:"E|N", InputCaseSensitive:1, FullInput:1 },
								{Type:"Text",     Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ibd_loc_gds_desc", Edit:1,    EditLen:100 },

								{Type:"Text",     Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"action_desc" },
								{Type:"Text",     Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
								{Type:"Text",     Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd" },
								{Type:"Text",     Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cstms_trsm_sts_cd" },
								{Type:"Text",     Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd" },
								{Type:"Text",     Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd" },
								{Type:"Text",     Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_del_cd" } ];
					InitColumns(cols);

					SetEditableColorDiff(1);
					SetEditable(1);
					sheetObj.SetDataLinkMouse("error", 1);
					SetCountFormat("[SELECTDATAROW / TOTALROWS]");
					SetSheetHeight(420);
				}
			break;
		}
	}


	/**
	 * handling process for Sheet
	 */
	//function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case SEARCH:    // Retrieve
				if (!validateForm(sheetObj, formObj, sAction)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_BKG_0028GS.do", FormQueryString(formObj), {Sync:2});
				end_no = 0;
				ComOpenWait(false);
			break;

			case IBSEARCHAPPEND:
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				//sheetObj.DoSearch("ESM_BKG_0028GS.do", CondParam+"&"+ "page_no=" + PageNo + "&end_no=" + end_no, {Append:true, Sync:2});
				sheetObj.DoSearch("ESM_BKG_0028GS.do", FormQueryString(formObj) + "&page_no=" + PageNo + "&end_no=" + end_no, {Append:true, Sync:2});
				ComOpenWait(false);
			break;

			case COMMAND01:    // Start AI
			case COMMAND02:    // Immediate Delete & AI
				if (!validateForm(sheetObj, formObj, sAction)) return;
				ComOpenWait(true);
				setTimeout(function() {
					with (sheetObj) {
						// 체크된 row번호만 수집하여 Loop
						var chkdRowArray = FindCheckedRow("chk").split("|");
						for (var k in chkdRowArray) {
							var sParam = RowSaveStr(chkdRowArray[k]) + "&f_cmd=" + sAction + "&cnt_cd=" + formObj.cnt_cd.value;
							var sXml = GetSaveData("ESM_BKG_0028GS.do", sParam);
							if (ComBkgErrMessage2(sheetObj, sXml)) {
								SetCellValue(chkdRowArray[k], "chk", "0");    // 성공시에는 CheckBox 해제
							} else {
								ComOpenWait(false);
								return;    // 오류시에는 return
							}
						}
					}
					ComShowCodeMessage("COM130601", "Data");    // {?msg1} was transmitted successfully.
					ComOpenWait(false);
					// 전송후 재조회
					doActionIBSheet(sheetObj, formObj, SEARCH);
				} , 100);
			break;

			case MULTI:    // Save
				if (!sheetObj.IsDataModified()) {
					ComShowCodeMessage("COM130503");    // "There is no updated data to save."
					return;
				}
				if (sheetObj.RowCount() > 0 && sheetObj.GetSaveString(true) == "") return;    // Sheet1의 Mandatory Check 용도
				if (!ComShowCodeConfirm("COM130101", "data")) return;    // "Do you want to save {?msg1}?"
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_BKG_0028GS.do", {Param:FormQueryString(formObj), Quest:0, Sync:1});
				ComOpenWait(false);
			break;

		}
	}


	/**
	 * handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case SEARCH:
				if (!ComChkValid(formObj))
					return false;
				if (ComIsNull(formObj.mbl_no) && ComIsNull(formObj.bkg_no)
						&& (ComIsNull(formObj.vvd_cd) || ComIsNull(formObj.pol_cd))
						&& (ComIsNull(formObj.vvd_cd) || ComIsNull(formObj.pod_cd))
						&& (!formObj.snd_dt_flg.checked)) {
					ComShowCodeMessage("BKG00406");
					return false;
				}
				if (formObj.snd_dt_flg.checked) {
					var diffDate=ComGetDaysBetween(formObj.s_snd_dt, formObj.e_snd_dt);
					var year=formObj.s_snd_dt.value.substring(0, 4);
					var month=formObj.s_snd_dt.value.substring(5, 7);
					var lastDay=ComGetLastDay(year, parseInt(month));
					if (diffDate + 1 > lastDay) {
						ComShowCodeMessage("BKG01080");
						formObj.e_snd_dt.select();
						return false;
					}
				}
			break;

			case COMMAND01:
			case COMMAND02:
				if (sheetObj.RowCount() < 1) {
					ComShowCodeMessage("BKG00395");
					return false;
				}
				//in case of not existing checked item
				if (sheetObj.CheckedRows("chk") < 1) {
					ComShowCodeMessage("COM12189");    // Nothing selected
					return false;
				}
			break;
		}
		return true;
	}


	/**
	 * handling after retrieve
	 * @param sheetObj : IBSheet Object
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (Code < 0 || sheetObj.RowCount() < 1)  return;
		sheetObj.SetHeaderCheck(0, "chk", 0);
		with (sheetObj) {
			for (var i=HeaderRows(); i<=LastRow(); i++) {
				// unchecking in case of AI Type: Add && ERR : (Not Null)
				if (GetCellValue(i, "ai_type") == "Add" && GetCellValue(i, "error") != "") {
					SetCellEditable(i, "chk", 0);
					SetCellBackColor(i, "chk", "#EFF0F3");
				}
// 2016.08.24 유저요청에 의해 주석처리
/*
				// unchecking in case of Origin = BDR
				if (GetCellValue(i, "bdr_flg") == "Y") {
					SetCellEditable(i, "chk", 0);
					SetCellBackColor(i, "chk", "#EFF0F3");
				}
				// unchecking in case of error(excepting B.STS:X/S/A)
				if (GetCellValue(i, "bkg_sts_cd") != "X" && GetCellValue(i, "bkg_sts_cd") != "S" &&
					GetCellValue(i, "bkg_sts_cd") != "A" && GetCellValue(i, "error") != "") {
					SetCellEditable(i, "chk",0);
					SetCellBackColor(i, "chk", "#EFF0F3");
				}
*/
				if (GetCellValue(i, "mh") == "H") SetCellFontColor(i, "bl_no","#0000FF");
				if (GetCellValue(i, "b_mi") == "N") SetCellFontColor(i, "b_mi","#FF0000");
				if (GetCellValue(i, "t_vvd_cd") != GetCellValue(i, "b_vvd_cd")) SetCellFontColor(i, "b_vvd_cd","#FF0000");
				if (GetCellValue(i, "mf_sts_cd") == "A") {
					SetCellFontColor(i, "mf_sts_cd", "#0000FF");
				} else if (GetCellValue(i, "mf_sts_cd") == "D") {
					SetCellFontColor(i, "mf_sts_cd", "#FF0000");
				}
				SetColFontColor("error", "#FF0000");
				SetCellFontUnderline(i, "error",1);
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
		}
		// Retrieve after saving
		doActionIBSheet(sheetObj, document.form, SEARCH);
	}
	var iPageNo = 1;
	function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
		if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
	}


	/**
	 * double click Event
	 * @param sheetObj
	 * @param row row Index
	 * @param col col Index
	 */
	function sheet1_OnDblClick(sheetObj, row, col) {
		if (sheetObj.ColSaveName(col) == "hub_loc_cd" || sheetObj.ColSaveName(col) == "ibd_loc_gds_desc") return;
		var bl_no = sheetObj.GetCellValue(row, "bl_no");
		if (document.form.cnt_cd.value == "US") {
			var params;
			if (document.form.customs.value == "Origin") {
				params = "?pgmNo=ESM_BKG_0034-01&bl_no=" + bl_no;
			} else {
				params = "?pgmNo=ESM_BKG_0034-03&bl_no=" + bl_no;
			}
			ComOpenWindowCenter("ESM_BKG_0034_POP.do" + params, "ESM_BKG_0034", 1200, 750);
		} else {
			var params = "?type=edit&bl_no=" + bl_no;
			if (document.form.customs.value == "Origin") {
				params = params + "&mainPage=false&pgmNo=ESM_BKG_0029";
			} else {
				params = params + "&mainPage=false&pgmNo=ESM_BKG_0029_2";
			}
			ComOpenWindowCenter("ESM_BKG_0029_POP.do" + params, "0029", 1200, 750);
		}
	}


	/**
	 * when inputting search condition
	 */
	function obj_KeyUp() {
		 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		var srcName = ComGetEvent("name");
		var srcMaxLength = ComGetEvent("maxlength");
		var srcValue = ComGetEvent("value");
		if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}


	/**
	 * handling in case of clicking on sheet
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		if (Row > -1) {
			document.form.action_desc.value = sheetObj.GetCellValue(Row, "action_desc");
		} else {
			document.form.action_desc.value = "";
		}
		with (sheetObj) {
			switch (ColSaveName(Col)) {
				case "chk":
					if (GetCellEditable(Row, Col) == 1) return;
					// unchecking in case of AI Type: Add && ERR : (Not Null)
					if (GetCellValue(Row, "ai_type") == "Add" && GetCellValue(Row, "error") != "") {
						ComShowMessage("Error B/L can not be selected.");
					}
				break;
				case "shpr_nm":
				case "cnee_nm":
				case "ntfy_nm":
					// MemoPad를 open시 해당Cell의 Editable속성이 false여야 함에 유의
					ComShowMemoPad(sheetObj, Row, Col, true);
				break;
			}
		}
	}


	/**
	 * @param sheetObj
	 * @param Button
	 * @param Shift : in case of pressed Shift Key -> 1, in case of pressed Ctrl Key -> 2, else -> 0
	 * @param X x-coordinate
	 * @param Y y-coordinate
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		var row = sheetObj.MouseRow();
		var col = sheetObj.MouseCol();
		if (row > -1) {
			if (sheetObj.ColSaveName(col) == "error") {
				sheetObj.SetToolTipText(row, col, error_desc(sheetObj.GetCellValue(row, "error")));
			}
		}
	}


	/**
	 * clicking header(sort)
	 * @param sheetObj
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	var vStartRow = 2;
	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		var col = sheetObj.MouseCol()
		if (sheetObj.MouseRow() == 0 || sheetObj.MouseRow() == 1) {
			if (sheetObj.RowCount() < sheetObj.GetTotalRows()) {
				ComOpenWait(true);
				end_no=sheetObj.GetTotalRows();
				sheetObj.SetTopRow(sheetObj.RowCount());
				sheetObj.SetTopRow(0);
				sheetObj.ColumnSort(col);
				ComOpenWait(false);
			}
		} else {
			if (Shift != 1) {
				vStartRow=sheetObj.MouseRow();
			}
		}
	}


	/**
	 * in case of clicking sheet with pressed Shift Key
	 * @param sheetObj
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y) {
		if (Shift == 1) {
			for ( var i=vStartRow; i <= sheetObj.GetSelectRow(); i++) {
				if (sheetObj.GetCellEditable(i, "chk")) {
					sheetObj.SetCellValue(i, "chk", "1", 0);
				}
			}
		}
	}


	/**
	 * returning error message
	 * @param error_type
	 * @return error_desc
	 */
	function error_desc(error_type) {
		var error_desc;
		switch (error_type) {
			case "B":
				error_desc="B/L No.is not Assigned";
			break;
			case "S":
				error_desc="BKG Status is not Firmed";
			break;
			case "H":
				error_desc="H.B/L & AMS File No.is missing for Filer Type '01'";
			break;
			case "C":
				error_desc="Container No.or Seal No. is missing";
			break;
			case "P":
				error_desc="Piece count un-match (M.B/L & H.B/L TTL vs. C/M Sum ) or C/M is missing";
			break;
			case "F":
				error_desc="Filer Type is missing";
			break;
			case "A":
				error_desc="Consignee(or Notify in case of “To Order”) information is missing";
			break;
		}
		return error_desc;
	}


	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		switch (ComGetEvent("name")) {
			case "ai_div":
				if (formObj.ai_div[0].checked) {          // General AI
					formObj.ai_type.disabled = false;
					formObj.sts_div.disabled = true;
					if (formObj.cnt_cd.value != "CA") ComBtnDisable("btn_Save");
					ComBtnEnable("btn_StartAI");
					ComBtnDisable("btn_DeleteAI");
					ComBtnDisable("btn_Modify");
					sheetObj.SetColHidden("ai_type", 0);
					sheetObj.SetColHidden("cstms_port_cd", 1);
					sheetObj.SetColHidden("action_code", 0);
				} else {                                  // Immediate Delete & AI
					formObj.ai_type.disabled = true;
					formObj.sts_div.disabled = false;
					ComBtnEnable("btn_Save");
					ComBtnDisable("btn_StartAI");
					ComBtnEnable("btn_DeleteAI");
					ComBtnEnable("btn_Modify");
					sheetObj.SetColHidden("ai_type", 1);
					sheetObj.SetColHidden("cstms_port_cd", 0);
					sheetObj.SetColHidden("action_code", 1);
				}
				sheetObj.RemoveAll();
				sheetObj.RemoveEtcData();
			break;
		}
	}
