/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0540.js
*@FileTitle  : Entry Type Set-Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_RowAdd":
			doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
			break;
		case "btn_Copy":
			doActionIBSheet(sheetObjects[0], formObject, IBCOPYROW);
			break;
		case "btn_Delete":
			doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_New":
			doActionIBSheet(sheetObjects[0], formObject, IBRESET);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
			break;
		case "btn_Close":
			ComClosePopup();
			break;
		} // end switch
	} catch (e) {
		/*if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}*/
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//ComBtnDisable("btn_RowAdd");
	ComBtnDisable("btn_Copy");
	ComBtnDisable("btn_Delete");
	// necessary event on the screen
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener("keydown", "ComKeyEnter", "form");
	if (document.form.cust_cd.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	var x = document.getElementById("etr_tp");
	var option = document.createElement("option");
	option.text = "All";
	option.value=" ";
	option.Selected;
	x.add(option,x[0]);
	x.selectedIndex=0;
}
 /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with(sheetObj){
			var HeadTitle="|Sel.|Seq.|Customer\nCode|Customer\nName|S/C No.|POD|DEL|Commodity\nCode|Commodity||CGO\nType|Entry\nType|IT Type|FTZ|HUB|C.LOC||Create Date|Create ID|Create Office|Update Date|Update ID|Update Office||";
			var headCount=ComCountHeadTitle(HeadTitle);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_cd",      KeyField:1,   Edit:0,   EditLen:8, InputCaseSensitive:1 },
					 {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",      KeyField:0,   Edit:0 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",        KeyField:0,   Edit:1,   EditLen:9 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",       KeyField:1,   Edit:0,   EditLen:5 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",       KeyField:1,   Edit:0,   EditLen:5 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",      KeyField:0,   Edit:0,   EditLen:6 },
					 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",      KeyField:0,   Edit:0 },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"clr_tp_seq",   KeyField:0,   Edit:0 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",   KeyField:0,   Edit:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"etr_tp",       KeyField:1,   Edit:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"it_tp",        KeyField:0,   Edit:1 },

					 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ftz_flg",      KeyField:0,   Edit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hub_loc_cd",   KeyField:0,   Edit:1,   EditLen:5 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cstms_loc_cd", KeyField:0,   Edit:1,   EditLen:5 },

					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",     KeyField:0,   Edit:1 },
					 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",       KeyField:0,   Edit:0 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",   KeyField:0,   Edit:0 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",   KeyField:0,   Edit:0 },
					 {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",       KeyField:0,   Edit:0 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",   KeyField:0,   Edit:0 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_ofc_cd",   KeyField:0,   Edit:0 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_dt",      KeyField:0,   Edit:0 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_usr_id",  KeyField:0,   Edit:0 } ];

			InitColumns(cols);
			SetEditable(1);
			SetColProperty("cntr_tp_cd", {ComboText:"All|Dry|Reefer", ComboCode:"A|D|R"} );
			SetColProperty("etr_tp", {ComboText:"Local|P/MIB", ComboCode:"L|I"} );
			SetColProperty("it_tp", {ComboText:"|61(IT)|62(T&E)|63(IE)", ComboCode:"|61|62|63"} );
			SetColProperty("ftz_flg", {ComboText:"Yes|No", ComboCode:"Y|N"} );
			SetColProperty("cre_dt", {Format:"YmdHm"} );
			SetColProperty("upd_dt", {Format:"YmdHm"} );
			SetColProperty("delt_dt", {Format:"YmdHm"} );
			SetColProperty("sc_no", {InputCaseSensitive:1});
			SetColProperty("hub_loc_cd", {InputCaseSensitive:1});
			SetColProperty("pod_cd", {InputCaseSensitive:1});
			SetColProperty("del_cd", {InputCaseSensitive:1});

			//기능변경[확인요망]CLT: 			InitDataValid(0, "cust_cd", vtEngUpOther, "1234567890");
		  //기능변경[확인요망]CLT: 			InitDataValid(0, "sc_no", vtEngUpOther, "1234567890");
		  //기능변경[확인요망]CLT: 			InitDataValid(0, "cmdt_cd", vtNumericOnly);
		  //기능변경[확인요망]CLT: 			InitDataValid(0, "pod_cd", vtEngUpOnly);
		  //기능변경[확인요망]CLT: 			InitDataValid(0, "del_cd", vtEngUpOnly);
		  //기능변경[확인요망]CLT: 			InitDataValid(0, "hub_loc_cd", vtEngUpOnly);
//	      SetSheetHeight(420);
		  ComResizeSheet(sheetObj);
		  }


		break;
	}
}
/**
 * retrieve again after save
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if(ErrMsg == "") {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	} else {
		ComShowCodeMessage("BKG00167");
	}
}

/**
 * checking key field Validation and description of code retrieve
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	with (sheetObj) {
		if (GetRowStatus(Row) == "U") {
			SetCellValue(Row, "upd_usr_id", formObj.usr_id.value, 0);
			SetCellValue(Row, "upd_dt", setDate(), 0);
			SetCellValue(Row, "upd_ofc_cd", userOfficeCode, 0);
		}
		switch (ColSaveName(Col)) {
			case "sc_no":
				if (Value == "") {
					SetCellValue(Row, Col,"",0);
					return;
				}
				formObj.strScNo.value = Value;
				if (formObj.strScNo.value != "") {
					formObj.f_cmd.value = SEARCH05;
					doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
				}
				break;
			case "cust_cd":
				if (Value == "") {
					SetCellValue(Row, "cust_cd","",0);
					SetCellValue(Row, "cust_nm","",0);
					return;
				}
				if (!ComIsAlphabet(Value.substring(0, 2)) || !ComIsNumber(Value.substring(2))) {
					ComShowCodeMessage("BKG06012", Value); // {?msg1} is invalid.
					SetCellValue(Row, "cust_cd","",0);
					SetCellValue(Row, "cust_nm","",0);
					SelectCell(Row, Col);
				} else {
					formObj.strCustCntCd.value = Value.substring(0, 2);
					formObj.strCustSeq.value = Value.substring(2);
				}
				if (formObj.strCustCntCd.value != "") {
					formObj.f_cmd.value = SEARCH01;
					doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
				}
				break;
			case "cmdt_cd":
				formObj.strCmdtCd.value = Value;
				if (formObj.strCmdtCd.value != "") {
					formObj.f_cmd.value = SEARCH02;
					doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
				} else {
					SetCellValue(Row, "cmdt_nm","",0);
				}
				break;
			case "pod_cd":
				formObj.strLocCd.value = Value;
				if (formObj.strLocCd.value != "") {
					formObj.f_cmd.value = SEARCH03;
					doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
				}
				formObj.strPod.value = GetCellValue(Row, "pod_cd");
				break;
			case "del_cd":
				formObj.strLocCd.value = Value;
				if (formObj.strLocCd.value != "" && formObj.strLocCd.value != "ALL") {
					formObj.f_cmd.value = SEARCH03;
					doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
				}
				formObj.strDel.value = GetCellValue(Row, "del_cd");
				break;
		}
		// Entry Type이 Local일 때 IT Type 설정
		if (GetCellValue(Row, "etr_tp") == "L"){
			SetCellValue(Row, "it_tp", "");
			SetCellEditable(Row, "it_tp" , 0);
		} else {
			SetCellEditable(Row, "it_tp", 1);
		}
	}
}

/**
 * checking same OFFICE data in case of select row of sheet
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	if (sheetObj.GetRowStatus(Row) == "I") return;
	if (sheetObj.GetCellValue(Row, "cre_ofc_cd") != userOfficeCode) {
		if (sheetObj.ColSaveName(Col) == "Chk" && Value == "1")
			return;
		ComShowCodeMessage("BKG06030", sheetObj.GetCellValue(Row, "cre_ofc_cd"));
		sheetObj.SelectCell(0, 0);
		return;
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	if (sheetObj.GetTotalRows()> 0) {
		ComBtnEnable("btn_Copy");
		ComBtnEnable("btn_Delete");
		for ( var i=1; i <= sheetObj.RowCount(); i++) {
			if (sheetObj.GetCellValue(i, "cre_ofc_cd") != userOfficeCode) {
				sheetObj.SetCellEditable(i, "Chk",0);
			}
			if(sheetObj.GetCellValue(i, "etr_tp") == "L"){
				sheetObj.SetCellEditable(i, "it_tp", 0);
			}
			else{
				sheetObj.SetCellEditable(i, "it_tp",1);
			}
		}
		sheetObj.SelectCell(0, 0);
	}
	ComOpenWait(false);
}

/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return void
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
		case IBSEARCH: //retrieve
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_0540GS.do", FormQueryString(formObj) );
			ComOpenWait(false);
			break;

		case IBROWSEARCH: // Customer Name, Commodity Name retrieve
			var sXml=sheetObj.GetSaveData("ESM_BKG_0540GS.do", FormQueryString(formObj));
			var state=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			var row=sheetObj.GetSelectRow();
			if (state == "S") {
				if (formObj.f_cmd.value == SEARCH01) {
					if (sheetObj.GetCellValue(row, "cust_cd") != "") {
						sheetObj.SetCellValue(row, "cust_nm",ComGetEtcData(sXml, "result"),0);
					}
				} else if (formObj.f_cmd.value == SEARCH02) {
					if (ComGetEtcData(sXml, "result") != undefined) {
						sheetObj.SetCellValue(row, "cmdt_nm",ComGetEtcData(sXml, "result"),0);
					} else {
						ComShowCodeMessage("BKG06012", sheetObj.GetCellValue(row, "cmdt_cd")); // {?msg1} is invalid.
						sheetObj.SetCellValue(row, "cmdt_cd","",0);
						sheetObj.SelectCell(row, "cmdt_cd");
					}
				} else if (formObj.f_cmd.value == SEARCH03) {
					if (ComGetEtcData(sXml, "result") == undefined) {
						var locCd=formObj.strLocCd.value;
						ComShowCodeMessage("BKG06012", locCd); // {?msg1} is invalid.
						if (sheetObj.GetCellValue(row, "pod_cd") == locCd) {
							sheetObj.SetCellValue(row, "pod_cd","",0);
							sheetObj.SelectCell(row, "pod_cd");
						} else {
							sheetObj.SetCellValue(row, "del_cd","",0);
							sheetObj.SelectCell(row, "del_cd");
						}
					}
				} else if (formObj.f_cmd.value == SEARCH05) {
					if (ComGetEtcData(sXml, "sc_no") == "") {
						ComShowCodeMessage("BKG00651", "S/C No. [ " + sheetObj.GetCellValue(row, "sc_no") + " ]"); // {?msg1} is invalid.
						sheetObj.SetCellValue(row, "sc_no","",0);
						sheetObj.SelectCell(row, "sc_no");
					} else {
					}
				}
			} else {
				if (formObj.f_cmd.value == SEARCH01) {
					if (ComGetEtcData(sXml, "result") == undefined) {
						ComShowCodeMessage("BKG00340");
						sheetObj.SetCellValue(row, "cust_cd","",0);
						sheetObj.SetCellValue(row, "cust_nm","",0);
						sheetObj.SelectCell(row, "cust_cd");
					}
				}
			}
			sheetObj.SetWaitImageVisible(1);
			break;
		case IBSAVE:
			if (!validateForm(sheetObj, formObj, sAction))
				return false;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("ESM_BKG_0540GS.do", FormQueryString(formObj), -1, false);
			ComOpenWait(false);
			break;
		case IBRESET: //initializing
			formObj.reset();
			sheetObj.RemoveAll();
			break;
		case IBINSERT:
			var row=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(row, "delt_flg","N",0);
			sheetObj.SetCellValue(row, "cre_usr_id",formObj.usr_id.value,0);
			sheetObj.SetCellValue(row, "cre_dt",setDate(),0);
			sheetObj.SetCellValue(row, "cre_ofc_cd",userOfficeCode,0);
			sheetObj.SetCellValue(row, "upd_usr_id",formObj.usr_id.value,0);
			sheetObj.SetCellValue(row, "upd_dt",setDate(),0);
			sheetObj.SetCellValue(row, "upd_ofc_cd",userOfficeCode,0);
			sheetObj.SetCellEditable(row, "cust_cd",1);
			sheetObj.SetCellEditable(row, "pod_cd",1);
			sheetObj.SetCellEditable(row, "del_cd",1);
			sheetObj.SetCellEditable(row, "cmdt_cd",1);
			sheetObj.SetCellEditable(row, "it_tp" ,0 );
			break;
		case IBCOPYROW:
			if (sheetObj.CheckedRows("Chk") == 0) {
				ComShowCodeMessage("BKG00567");
				return false;
			}
			var Row;
			var ColName;
			for (i=1; i < sheetObj.RowCount()+ 1; i++) {
				if (sheetObj.GetCellValue(i, "Chk") == 1) {
					Row=sheetObj.DataInsert(-1);
					for (j=2; j <= sheetObj.LastCol()- 2; j++) {
						sheetObj.SetCellValue(Row, j,sheetObj.GetCellValue(i, j),0);
						ColName=sheetObj.ColSaveName(j);
						if (ColName == "cust_cd") {
							sheetObj.SetCellEditable(Row, ColName,1);
						} else if (ColName == "pod_cd") {
							sheetObj.SetCellEditable(Row, ColName,1);
						} else if (ColName == "del_cd") {
							sheetObj.SetCellEditable(Row, ColName,1);
						} else if (ColName == "cmdt_cd") {
							sheetObj.SetCellEditable(Row, ColName,1);
						} else if (ColName == "clr_tp_seq") {
							sheetObj.SetCellValue(Row, ColName,"",0);
						}
					}
	//				sheetObj.ReturnCellData(i, "Chk");
	//				sheetObj.ReturnCellData(i, "upd_usr_id");
	//				sheetObj.ReturnCellData(i, "upd_dt");
					sheetObj.ReturnCellData(i, "upd_ofc_cd");
					sheetObj.SetCellValue(Row, "cre_usr_id",formObj.usr_id.value,0);
					sheetObj.SetCellValue(Row, "cre_dt",setDate(),0);
					sheetObj.SetCellValue(Row, "cre_ofc_cd",userOfficeCode,0);
					sheetObj.SetCellValue(Row, "upd_usr_id",formObj.usr_id.value,0);
					sheetObj.SetCellValue(Row, "upd_dt",setDate(),0);
					sheetObj.SetCellValue(Row, "upd_ofc_cd",userOfficeCode,0);
				}
			}
			break;
		case IBDELETE:
			if (!validateForm(sheetObj, formObj, sAction))
				return false;
			var delCnt=0;
			for ( var i=0; i < sheetObj.LastRow()+ 1; i++) {
				if (sheetObj.GetCellValue(i, "Chk") == 1 && sheetObj.GetRowStatus(i) == "U") {
					delCnt++;
					sheetObj.SetCellValue(i, "delt_flg","Y",0);
					sheetObj.SetCellValue(i, "delt_usr_id",formObj.usr_id.value,0);
					sheetObj.SetCellValue(i, "delt_dt",setDate(),0);
				}
			}
			if (ComShowCodeConfirm("BKG03037")) {
				if (delCnt > 0) {
					ComRowHideDelete(sheetObj, "Chk");
				} else {
					sheetObj.RenderSheet(0);
					for ( var i=0; i < sheetObj.LastRow()+ 1; i++) {
						if (sheetObj.GetCellValue(i, "Chk") == 1) {
							sheetObj.RowDelete(i, false);
						}
					}
					sheetObj.RenderSheet(1);
				}
			}
			break;
		case IBDOWNEXCEL:
			ComOpenWait(true);
			 if(sheetObj.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				}
			ComOpenWait(false);
			break;
	}
}

/**
 * calculating now date and time
 */
function setDate() {
	var d=new Date;
	var s=leadingZeros(d.getFullYear(), 4) + "-" + leadingZeros(d.getMonth() + 1, 2) + "-" + leadingZeros(d.getDate(), 2) + " "
			+ leadingZeros(d.getHours(), 2) + ":" + leadingZeros(d.getMinutes(), 2);
	return s;
}
/**
 * adding number 0 in front of single digit
 */
function leadingZeros(n, digits) {
	var zero="";
	n=n.toString();
	if (n.length < digits) {
		for (i=0; i < digits - n.length; i++)
			zero += "0";
	}
	return zero + n;
}
 /**
  * handling process for input validation <br>
  * @param sheetObj
  * @param formObj
  * @param sAction
  * @return boolean
  */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (formObj.cust_cd.value == "" && formObj.pod_cd.value == "" && formObj.del_cd.value == ""
				&& formObj.cre_ofc_cd.value == "") {
			ComShowCodeMessage("BKG06064"); // Please input Customer Code, POD, DEL or Create Office.
			return false;
		}
		break;
	case IBSAVE:
		if (sheetObj.RowCount()<= 0)
			return false;
		if (sheetObj.RowCount("U") + sheetObj.RowCount("D") + sheetObj.RowCount("I") == 0) {
			ComShowCodeMessage("BKG00501");
			return false;
		}
		var cust_cd;
		var sc_no;
		var pod_cd;
		var del_cd;
		var cmdt_cd;
		var cntr_tp_cd;
		var confirmCnt=0;
		for ( var i=1; i < sheetObj.RowCount()+ 1; i++) {
			if (sheetObj.GetRowStatus(i) == "D" || sheetObj.GetRowStatus(i) == "R") continue;
			cust_cd=sheetObj.GetCellValue(i, "cust_cd");
			sc_no=sheetObj.GetCellValue(i, "sc_no");
			pod_cd=sheetObj.GetCellValue(i, "pod_cd");
			del_cd=sheetObj.GetCellValue(i, "del_cd");
			cmdt_cd=sheetObj.GetCellValue(i, "cmdt_cd");
			cntr_tp_cd=sheetObj.GetCellValue(i, "cntr_tp_cd");
			if (cust_cd != "" && pod_cd != "" && del_cd != "") {
				for ( var j=i + 1; j < sheetObj.RowCount()+ 1; j++) {
					if (sheetObj.GetRowStatus(j) == "D") continue;
					if (sheetObj.GetCellValue(j, "cust_cd") == cust_cd && sheetObj.GetCellValue(j, "sc_no") == sc_no
						&& sheetObj.GetCellValue(j, "pod_cd") == pod_cd && sheetObj.GetCellValue(j, "del_cd") == del_cd
						&& sheetObj.GetCellValue(j, "cmdt_cd") == cmdt_cd && sheetObj.GetCellValue(j, "cntr_tp_cd") == cntr_tp_cd) {
						if (sheetObj.GetCellValue(j, "cre_ofc_cd") != userOfficeCode) {
							// You can’t update the data. Not Create Office [{?msg1}].
							ComShowCodeMessage("BKG06030", sheetObj.GetCellValue(j, "cre_ofc_cd"));
							return false;
						}
						else {
							// Sequence No.[{?msg1}] Duplication occurred. Do you want to save it anyway?
							sheetObj.SetCellValue(j, "clr_tp_seq",sheetObj.GetCellValue(i, "clr_tp_seq"),0);
							if (ComShowCodeConfirm("BKG06029", sheetObj.GetCellValue(j, "Seq"))) {
								//sheetObj.CellValue2(j,"clr_tp_seq") = sheetObj.CellValue(i,"clr_tp_seq");
								confirmCnt++;
							} else {
								sheetObj.ReturnCellData(j, "clr_tp_seq");
								return false;
							}
						}
					} else if (sheetObj.GetCellValue(j, "cust_cd") == cust_cd && sheetObj.GetCellValue(j, "sc_no") == sc_no
								&& sheetObj.GetCellValue(j, "pod_cd") == pod_cd && sheetObj.GetCellValue(j, "del_cd") == del_cd
								&& sheetObj.GetCellValue(j, "cmdt_cd") == cmdt_cd) {
						if (sheetObj.GetCellValue(j, "cntr_tp_cd") == "A" || cntr_tp_cd == "A") {
							if (sheetObj.GetCellValue(j, "cre_ofc_cd") != userOfficeCode) {
								// You can’t update the data. Not Create Office [{?msg1}].
								ComShowCodeMessage("BKG06030", sheetObj.GetCellValue(j, "cre_ofc_cd"));
								return false;
							}
							else {
								// Sequence No.[{?msg1}] Duplication occurred. Do you want to save it anyway?
								if (ComShowCodeConfirm("BKG06029", sheetObj.GetCellValue(j, "Seq"))) {
									if (cntr_tp_cd == "A") {
										sheetObj.SetCellValue(j, "delt_flg","Y",0);
										sheetObj.SetCellValue(j, "delt_usr_id",formObj.usr_id.value,0);
										sheetObj.SetCellValue(j, "delt_dt",setDate(),0);
									} else {
										sheetObj.SetCellValue(i, "delt_flg","Y",0);
										sheetObj.SetCellValue(i, "delt_usr_id",formObj.usr_id.value,0);
										sheetObj.SetCellValue(i, "delt_dt",setDate(),0);
									}
									confirmCnt++;
								} else {
									return false;
								}
							}
						}
					}
				}
			}
		}
		if (confirmCnt == sheetObj.RowCount("I")) {
			return true;
		}
		break;
	case IBDELETE:
		if (sheetObj.CheckedRows("Chk") == 0) {
			ComShowCodeMessage("BKG00567");
			return false;
		}
	}
	return true;
}
