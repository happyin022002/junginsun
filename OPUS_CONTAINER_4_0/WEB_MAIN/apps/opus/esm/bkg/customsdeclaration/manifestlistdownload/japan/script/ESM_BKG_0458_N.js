/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : Esm_bkg_0458.js
 *@FileTitle : ESM_BKG-0458
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/03
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
	MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
	 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var sheetObjects=new Array();
var sheetCnt=0;
var totalCount=0;
var state="";
// Event handler processing by button click event  */
document.onclick=processButtonClick;
function processButtonClick() {
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
			case "btn_add":
				doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
				break;
			case "btn_delete":
				doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
				break;
			case "btn_close":
				doActionIBSheet(sheetObjects[0], document.form, COMMAND03);
				break;
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
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	initSheetData(sheetObjects[0], document.form);

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

// initialize sheet data
function initSheetData(sheetObj, formObj) {
	//formObj.vvd_cd.value = "";
	// formObj.pod_cd.value = "";
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);
	IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
}

/**
 * registering initial event
 */
function initControl() {
	DATE_SEPARATOR = "-";
	var formObject = document.form;
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - focus out
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * handling search conditions input
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * handler onblur event
 **/
function obj_deactivate() {
//if (event.srcElement.getAttribute("required") != null) return;
	switch (event.srcElement.name) {
		case "diff_rmk":
			ComKeyCopy(1);
			break;
		case "bl_desc":
			ComKeyCopy(2);
			break;
		default:
			break;
	// ComAddSeparator(event.srcElement);
	// ComChkObjValid(event.srcElement);
	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": // sheet1 init
		with(sheetObj) {
			var HeadTitle1="Flag|bl_seq|bl_seq2|diff_rmk|bl_desc";
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_seq" },
						{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_seq2" },
						{Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"diff_rmk" },
						{Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"bl_desc" } ];
			InitColumns(cols);

			SetEditable(1);
			SetSheetHeight(225);
		}
		break;
	}
}

/**
 * handling sheet process
 * @param sheetObj Sheet
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSAVE:
			if (!validateForm(sheetObj, formObj, sAction)) return;
			//IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
			formObj.f_cmd.value=MULTI;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoAllSave("ESM_BKG_0458GS.do", {Param:FormQueryString(formObj),Col:"sel",Quest:"false",UrlEncode:"true", Sync:1} );
			break;
		case IBSEARCH:
			if (!validateForm(sheetObj, formObj, sAction)) return;
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0458GS.do", FormQueryString(formObj), {Sync:2});
			ComEtcDataToForm(formObj, sheetObj);
			state=sheetObj.GetEtcData("TRANS_RESULT_KEY");

			if (state == "S") {
				document.form.select_bl_seq.options.length="0";
				// alert(document.form.select_bl_seq.length);
				for (var i=1; i < sheetObj.RowCount()+ 1; i++) {
					ComAddComboItem(document.form.select_bl_seq, "0" + sheetObj.GetCellValue(i, "bl_seq"), i)
					sheetObj.SetCellValue(i, "bl_seq2",i);
					sheetObjects[0].SetRowStatus(i,"R");
				}
				if (sheetObj.RowCount()== 0) {
					ComAddComboItem(document.form.select_bl_seq, "01", 1)
					sheetObj.RemoveAll();
					sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(i, "bl_seq",1);
					sheetObj.SetCellValue(i, "bl_seq2",1);
					sheetObjects[0].SetRowStatus(i,"I");
					totalCount=1;
					document.form.diff_rmk.value="";
					document.form.bl_desc.value="";

				} else {
					document.form.select_bl_seq[0].selected=true;
					totalCount=document.form.select_bl_seq[document.form.select_bl_seq.length - 1].value;
					document.form.diff_rmk.value=sheetObj.GetCellValue(1, "diff_rmk");
					document.form.bl_desc.value=sheetObj.GetCellValue(1, "bl_desc");
				}

			}
			ComOpenWait(false);
			break;
		case COMMAND01:
			//if (!sheetObjects[0].IsDataModified)
			// {
			// alert(sheetObjects[0].RowCount);
			sheetObjects[0].DataInsert(-1);
			// alert(sheetObjects[0].RowCount);
			totalCount++;
			var totalOption=0;
			for (var i=1; i < sheetObj.RowCount()+ 1; i++) {
				if (sheetObjects[0].GetRowStatus(i) != "D") {
					totalOption++;
				}
			}
			if (totalCount > 9)
				ComAddComboItem(document.form.select_bl_seq, totalOption, totalOption)
			else
				ComAddComboItem(document.form.select_bl_seq, "0" + totalOption,
						totalOption)
				// alert(totalCount);
			var lastValue=0;
			var lastValue2=0;
			if (totalCount != 1) {
				lastValue=sheetObjects[0].GetCellValue(totalCount - 1, "bl_seq") * 1 + 1 * 1
				lastValue2=sheetObjects[0].GetCellValue(totalCount - 1, "bl_seq2") * 1 + 1 * 1
			} else {
				lastValue=1;
			}
			sheetObjects[0].SetCellValue(totalCount, "bl_seq",lastValue);
			sheetObjects[0].SetCellValue(totalCount, "bl_seq2",lastValue2);
			formObj.diff_rmk.value="";
			formObj.bl_desc.value="";
			// sheetObjects[0].RowStatus(totalCount) = "I";
			formObj.select_bl_seq.options[formObj.select_bl_seq.options.length - 1].selected=true;
			// } else {
			// ComShowCodeMessage("BKG00178");
			// }
			break;
		case COMMAND02:
			//if (!sheetObjects[0].IsDataModified)
			// {
			if (sheetObjects[0].GetRowStatus(formObj.select_bl_seq.selectedIndex + 1) == "R") {
				//alert("here2");
				sheetObjects[0].SetRowStatus(formObj.select_bl_seq.selectedIndex + 1,"D");
				for (var i=formObj.select_bl_seq.selectedIndex + 1; i < sheetObj.RowCount()+ 1; i++) {
					if (sheetObjects[0].GetRowStatus(i) != "D") {
						//sheetObjects[0].CellValue(i,"bl_seq") = sheetObjects[0].CellValue(i,"bl_seq")*1-1*1;
						sheetObjects[0].SetCellValue(i, "bl_seq2") = sheetObjects[0].GetCellValue(i, "bl_seq2") * 1 - 1 * 1;
						sheetObjects[0].SetRowStatus(i,"R");
					}
				}
				//sheetObjects[0].RowDelete(formObj.select_bl_seq.selectedIndex+1, false);
				// alert(sheetObj.RowCount);
				var totalOption=0;
				for (var i=1; i < sheetObj.RowCount()+ 1; i++) {
					if (sheetObjects[0].GetRowStatus(i) != "D") {
						totalOption++;
					}
				}
				document.all.select_bl_seq.remove(totalOption);
				if (formObj.select_bl_seq.options.length != 0) {
					var firstIndex;
					for (var i=1; i < sheetObj.RowCount()+ 1; i++) {
						if (sheetObjects[0].GetRowStatus(i) != "D") {
							firstIndex=i;
							break;
						}
					}
					formObj.select_bl_seq.options[0].selected=true;
					formObj.diff_rmk.value=sheetObjects[0].GetCellValue(firstIndex,"diff_rmk");
					formObj.bl_desc.value=sheetObjects[0].GetCellValue(firstIndex,"bl_desc");
				} else {
					//formObj.bl_seq.options[0].selected = true;
					formObj.diff_rmk.value="";
					formObj.bl_desc.value="";
				}
				//totalCount--;
				// sheetObjects[0].RowStatus(i) = "D";
				// formObj.f_cmd.value = MULTI01;
				// sheetObj.DoAllSave("ESM_BKG_0458GS.do", FormQueryString(formObj));
			} else {
				for (var i=formObj.select_bl_seq.selectedIndex + 1; i < sheetObj.RowCount()+ 1; i++) {
					if (sheetObjects[0].GetRowStatus(i) != "D") {
						sheetObjects[0].SetCellValue(i, "bl_seq") = sheetObjects[0].GetCellValue(i, "bl_seq") * 1 - 1 * 1;
						sheetObjects[0].SetCellValue(i, "bl_seq2") = sheetObjects[0].GetCellValue(i, "bl_seq2") * 1 - 1 * 1;
					}
				}
				sheetObjects[0].RowDelete(formObj.select_bl_seq.selectedIndex + 1,
						false);
				// alert(sheetObj.RowCount);
				document.all.select_bl_seq.remove(sheetObj.RowCount());
				if (formObj.select_bl_seq.options.length != 0) {
					formObj.select_bl_seq.options[0].selected = true;
					formObj.diff_rmk.value=sheetObjects[0].GetCellValue(1, "diff_rmk");
					formObj.bl_desc.value=sheetObjects[0].GetCellValue(1, "bl_desc");
				} else {
					//formObj.bl_seq.options[0].selected = true;
					formObj.diff_rmk.value="";
					formObj.bl_desc.value="";
				}
				totalCount--;
			}
			//} else {
			//	ComShowCodeMessage("BKG00178");
			// }
			break;
		case COMMAND03:
			var vIsCheck=true
			var opener = window.dialogArguments;
			if (!opener) opener = parent;
			for (var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetRowStatus(i) == "I" || sheetObj.GetRowStatus(i) == "U" || sheetObj.GetRowStatus(i) == "D") {
					vIsCheck = false;
					break;
				}
			}
			if (vIsCheck) {
				opener.retrieve();
				ComClosePopup();
				break;
			}
			if (!validateForm(sheetObj, formObj, sAction)) {
				opener.retrieve();
				ComClosePopup();
			} else {
				formObj.f_cmd.value = MULTI;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				sheetObj.DoAllSave("ESM_BKG_0458GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}
			break;
	}
}

/**
 * handling event after saving
 */
function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
	if (Code < 0) return;
	// Retrieve after saving
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}

/**
 * copy form value to sheet
 * @param gubun gubun
 */
function ComKeyCopy(gubun) {
	var formObject = document.form;
	if (gubun == 1)
		sheetObjects[0].SetCellValue(formObject.select_bl_seq.value, "diff_rmk",formObject.diff_rmk.value);
	if (gubun == 2)
		sheetObjects[0].SetCellValue(formObject.select_bl_seq.value, "bl_desc",formObject.bl_desc.value);
}

/**
 * change sequence of select box
 * @param obj object
 */
function changeSeq(obj) {
	var formObject=document.form;
	for (var i=1; i < sheetObjects[0].RowCount()+ 1; i++) {
		if (obj.selectedIndex + 1 == sheetObjects[0].GetCellValue(i + 1, "bl_seq2")) {
			formObject.diff_rmk.value = sheetObjects[0].GetCellValue(i + 1, "diff_rmk");
			formObject.bl_desc.value = sheetObjects[0].GetCellValue(i + 1, "bl_desc");
		}
	}
	//formObject.diff_rmk.value = sheetObjects[0].CellValue(obj.selectedIndex+1,"diff_rmk");
	// formObject.bl_desc.value =
	// sheetObjects[0].CellValue(obj.selectedIndex+1,"bl_desc");
}

/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			return true;
			break;
		case IBSAVE:
			if (!ComChkValid(formObj)) return false;
			return true;
			break;
		case COMMAND03:
			//check checked row count is one and over
			var vIsCheck=true;
			for (var i=1; i<=sheetObj.RowCount(); i++) {
				if (sheetObj.GetRowStatus(i) == "I" || sheetObj.GetRowStatus(i) == "U"|| sheetObj.GetRowStatus(i) == "D") {
					vIsCheck=false;
					break;
				}
			}
			if (!vIsCheck) {
				//ComShowCodeMessage('BKG00265','');
				if (!confirm("Do you want to save your change(s)?")) {
					return false;
				}
			}
			return true;
			break;
	}
}
