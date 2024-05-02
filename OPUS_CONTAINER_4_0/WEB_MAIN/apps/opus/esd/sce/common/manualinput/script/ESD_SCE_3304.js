/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_SCE_3304.js
 *@FileTitle  : Container Status Message & Movement Status Mapping Management
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
 * @author 
 */
/**
 * @extends
 * @class ESD_SCE_3304 : ESD_SCE_3304 business script.
 */
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case "btn_RowAdd":
				addRow(formObject);
				break;
			case "btn_RowDel":
				if (sheetObject.CheckedRows('check') == '0') {
					ComShowCodeMessage('COM12176');
					return false;
				}
				deleteRow();
				sheetObject.CheckAll('check', 0, 1);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], document.form, MULTI);
				break;
			case "btn_exceldown":
				if (sheetObjects[0].RowCount() < 1) {// no data
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObjects[0], document.form, "btn_exceldown", "", "");
				}
				break;
			case "btn_excelup":
				sheetObject.RemoveAll();
				sheetObject.RenderSheet(0);
				sheetObject.LoadExcel({ Mode : "HeaderMatch" });
				sheetObject.RenderSheet(1);
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:
            with(sheetObj){
                  var HeadTitle="|Sel.|Seq|Region|Act Sts Mapg cd|Stnd Edi Sts Cd|Csm Desc|Eff Fm Dt|Eff To Dt|Delt Flg|Creation User|Creation Date|Update User|Update Date";
                  var headCount=ComCountHeadTitle(HeadTitle);

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ 
	                         {Type:"Status",    Hidden:1, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                         {Type:"DummyCheck", Hidden:0, 	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
	                         {Type:"Seq",       Hidden:0, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                         {Type:"Combo",     Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"csm_cnt_cd",  	   	KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1},
	                         {Type:"Text",      Hidden:0,  	Width:125,  Align:"Center",  ColMerge:1,   SaveName:"act_sts_mapg_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
	                         {Type:"Text",      Hidden:0,  	Width:125,  Align:"Center",  ColMerge:1,   SaveName:"stnd_edi_sts_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                         {Type:"Text",      Hidden:0,  	Width:200,  Align:"Left",    ColMerge:1,   SaveName:"csm_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
	                         {Type:"Date",      Hidden:1,  	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
	                         {Type:"Date",      Hidden:1,  	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
	                         {Type:"Combo",     Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
	                         {Type:"Text",      Hidden:0,  	Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                         {Type:"Date",      Hidden:0,  	Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                         {Type:"Text",      Hidden:0,  	Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
	                         {Type:"Date",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 } 
                         ];
                   
                  InitColumns(cols);
                  SetEditable(1);
                  SetWaitImageVisible(0);
                  SetColProperty(0 ,"csm_cnt_cd", 		{AcceptKeys:"E"     , InputCaseSensitive:1});
                  SetColProperty(0 ,"act_sts_mapg_cd", 	{AcceptKeys:"E"     , InputCaseSensitive:1});
                  SetColProperty(0 ,"stnd_edi_sts_cd", 	{AcceptKeys:"E"     , InputCaseSensitive:1});
                  SetColProperty("csm_cnt_cd", 	{ComboText:"US|EU", ComboCode:"US|EU"} );
                  SetColProperty("delt_flg", 	{ComboText:"No|Yes", ComboCode:"N|Y"} );
                  ComResizeSheet(sheetObj);
            }
        break;
    }
}

/**
 * initial init
 * 
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH:
			if (sheetObj.IsDataModified() == true) {
				if (!ComShowCodeConfirm("SCE90051")) {
					return false;
				}
			}
			if (validateForm(sheetObj, formObj, sAction) != true) {
				break;
			}
			formObj.f_cmd.value = SEARCH;
			var csmCntCd = $('#csm_cnt_cd').val();
			sheetObj.DoSearch("ESD_SCE_3304GS.do?csm_cnt_cd=" + csmCntCd, FormQueryString(formObj));
			break;
		case MULTI:
			if (sheetObj.FindStatusRow('I|U|D') == "") {
				ComShowCodeMessage('SCE01222');
				return false;
			}
			if (sheetObj.GetSaveString() == "")
				return;
			if (validateForm(sheetObj, formObj, sAction) != true) {
				ComShowCodeMessage('BKG00167');
				break;
			}
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_SCE_3304GS.do", FormQueryString(formObj));
			break;
		case "btn_exceldown":
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	var sheet1RowCnt = sheetObj.RowCount();
	switch (sAction) {
		case IBSEARCH: {
			break;
		}
		case MULTI: {
			if (!ComChkValid(formObj))
				return false;
			if (sheetObj.ColValueDup("act_sts_mapg_cd|stnd_edi_sts_cd|csm_cnt_cd") > 0) {
				ComShowCodeMessage('SCE90052');
				return false;
			}
			for ( var i = 1; i <= sheet1RowCnt; i++) {
				if (ComIsNull(sheetObj.GetCellValue(i, "act_sts_mapg_cd")) || ComIsNull(sheetObj.GetCellValue(i, "stnd_edi_sts_cd")) || ComIsNull(sheetObj.GetCellValue(i, "csm_cnt_cd"))) {
					ComShowCodeMessage('SCE90053');
					return false;
				} else if (sheetObj.GetCellValue(i, "eff_fm_dt") > sheetObj.GetCellValue(i, "eff_to_dt")) {
					ComShowCodeMessage('COM12133', "Effective to-date", "from-date", "later");
					return false;
				}
			}
		}
			break;
	}
	return true;
}

function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	if (formObj.f_cmd.value == MULTI && errMsg == 0) {
		ComShowCodeMessage('COM130102', "Data");
		formObj.f_cmd.value = SEARCH;
		var sParam = FormQueryString(formObj);
		sheetObj.DoSearch("ESD_SCE_3304GS.do", sParam);
	}
}
/**
 * prcessing about add row of sheet1 add new row
 */
function addRow(formObj) {
	with (sheetObjects[0]) {
		var nowRow = GetSelectRow();
		nowRow = DataInsert(-1);
		var csmCntCd = $('#csm_cnt_cd').val();
		if (!ComIsNull(csmCntCd)) {
			sheetObjects[0].SetCellValue(nowRow, 'csm_cnt_cd', csmCntCd);
			sheetObjects[0].SetCellEditable(nowRow, 'csm_cnt_cd', 0);
		}
		return true;
	}
}

function csmCntCd_onchange(obj) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * prcessing about delete row of sheet1 delete row
 */
function deleteRow() {
	with (sheetObjects[0]) {
		var sRowStr = FindCheckedRow("check");
		var arr = sRowStr.split("|");
		for ( var i = 0; i < arr.length; i++) {
			SetRowStatus(arr[i], "D");
			SetRowHidden(arr[i], "1");
		}
	}
}