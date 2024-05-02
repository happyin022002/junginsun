/*=========================================================
* * 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_3306.js
*@FileTitle  :  SCE RAIL SPLC Manage
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/*******************************************************************************
 * Event classify code: [initialization]INIT=0; [input]ADD=1;
 * [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3; [modify]MODIFY=4;
 * [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 * character constant COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/
/* Developer Work	*/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
	    if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_RowAdd":
			addRow(formObject);
			break;
		case "btn_RowDel":
			deleteRow();
			break;
		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, MULTI);
			break;
		case "btn_exceldown":
			doActionIBSheet(sheetObjects[0], document.form, "btn_exceldown","", "");
			break;
		case "btn_excelup":
			sheetObject.RemoveAll();
			sheetObject.RenderSheet(0);
			sheetObject.LoadExcel({ Mode:"HeaderMatch"});
			sheetObject.RenderSheet(1);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
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
	// initPage();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
//	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
//	axon_event.addListenerFormat('keyup', 'obj_change', formObj);
}
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){		       
		      if (location.hostname != "")
		      var HeadTitle="STS|CHK|SPLC Code|Vendor Name|Yard|Abbr Location Name|State Code|Citi|" +
		      "Location Name|Delete|Company Location Code|Updation User|Update Date|Creation User|Creation Date";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"check" },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"splc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6, InputCaseSensitive: 1  },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"splc_vndr_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7, AcceptKeys:"E|N", InputCaseSensitive: 1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"splc_abbr_loc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ste_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3, InputCaseSensitive: 1  },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cuty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"splc_loc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"splc_dflt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive: 1  },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetWaitImageVisible(0);
		      SetColProperty("cre_dt", {Format:"####-##-####:##:##"} );
		      SetColProperty("upd_dt", {Format:"####-##-####:##:##"} );
		      SetColProperty("splc_dflt_flg", {ComboText:"Yes|No", ComboCode:"Y|N"} );
		      SetAutoRowHeight(0);
		      SetDataRowHeight(22);
		      SetColProperty(0 ,"splc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
//		      SetSheetHeight(440);
		      resizeSheet(); 
      }
		break;
	}
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH:
		ComOpenWait(true);
		if (validateForm(sheetObj, formObj, sAction) != true) {
			ComOpenWait(false);
			break;
		}
		formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj);
		sheetObj.DoSearch("ESD_SCE_3306GS.do", sParam );
		ComOpenWait(false);
		break;
	case SEARCH01:
		formObj.f_cmd.value=SEARCH01;
		var sParam=FormQueryString(formObj);
		var arrXml=sheetObj.GetSearchData("ESD_SCE_3306GS.do", sParam);
		if (arrXml.length > 0) {
			var valResult=ComGetTotalRows(arrXml);
			if(valResult == 1)
				return 'S';
			else 
				return 'F';
		}
		break;
	case MULTI: // Save
		ComOpenWait(true, true);
		if (validateForm(sheetObj, formObj, sAction) != true) {
			ComShowCodeMessage('BKG00167');
			ComOpenWait(false, false);
			break;
		}
		formObj.f_cmd.value=MULTI;
//		var sParam = ComGetSaveString(sheetObj);
		var sParam=sheetObj.GetSaveString(false, true, "ibflag");
		if (sParam == "") {
			ComOpenWait(false, false);
			return;
		}
		sParam += "&" + FormQueryString(formObj);
		var sXml=sheetObj.GetSaveData("ESD_SCE_3306GS.do", sParam);
		var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State != "S") {
			ComShowCodeMessage('COM130103', 'Data');
			ComOpenWait(false, false);
			return false;
		} else if (State == "S") {
			ComShowCodeMessage('COM130102', 'Data');
		}
		ComOpenWait(false, false);
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		break;
	case "btn_exceldown":
		sheetObj.Down2Excel({ HiddenColumn:1});
		break;
	}
}
function validateForm(sheetObj, formObj, sAction) {
	var sheet1RowCnt=sheetObj.RowCount();
	switch (sAction) {
	case IBSEARCH: { // RETRIEVE
		break;
	}
	case MULTI: {
		var Msg="";
		if (!ComChkValid(formObj))
			return false;
		if(sheetObj.ColValueDup("splc_cd|splc_vndr_nm|yd_cd") > 0) {
			alert("Check Duplicate SPLC CODE and VENDOR NAME and YARD");
			return false;
		}
		for ( var i=1; i <= sheet1RowCnt; i++) {
			if (sheetObj.GetCellValue(i, "splc_cd") == "") {
				Msg="SPLC CODE";
				ComShowCodeMessage('COM130403', Msg);
				return false;
			}
			else if (sheetObj.GetCellValue(i, "splc_vndr_nm") == "") {
				Msg="VENDOR NAME";
				ComShowCodeMessage('COM130403', Msg);
				return false;
			}
			else if (sheetObj.GetCellValue(i, "yd_cd") == "") {
				Msg="YARD CODE";
				ComShowCodeMessage('COM130403', Msg);
				return false;
			}
		}
		break;
	}
	} // end switch()
	return true;
}
function addRow(formObj) {
	with (sheetObjects[0]) {
		var nowRow=GetSelectRow();
		nowRow=DataInsert(-1);
		return true;
	}
}
/**
 * row delete
 */
function deleteRow() {
	with (sheetObjects[0]) {
		var sRowStr=FindCheckedRow("check");
		var arr=sRowStr.split("|");
		for ( var i=0; i < arr.length; i++) {
			SetRowStatus(arr[i],"D");
			SetRowHidden(arr[i],"1");
		}
	}
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj=document.form;
	if(sheetObj.GetCellValue(Row, Col) == null || sheetObj.GetCellValue(Row, Col) == "") return;
	if(	sheetObj.ColSaveName(Col) == "loc_cd" || sheetObj.ColSaveName(Col) == "yd_cd") 
	{
		clearHiddenData();
		if(sheetObj.ColSaveName(Col) == "loc_cd") {
			formObj.fm_loc_cd.value=sheetObj.GetCellValue(Row, Col);
		}
		else if(sheetObj.ColSaveName(Col) == "yd_cd") {
			formObj.fm_yd_cd.value=sheetObj.GetCellValue(Row, Col);
		}
		var result=doActionIBSheet(sheetObj, formObj, SEARCH01);
		if(result == 'F') {
			ComShowCodeMessage('COM130402', "[" + sheetObj.GetCellValue(Row, Col) + "] ");
			// Init
			clearHiddenData();
			sheetObj.SetCellValue(Row, Col,"");
//			sheetObj.SelectCell(Row, Col, false);
		}
	}
}
function clearHiddenData() {
	var formObj=document.form;
	formObj.fm_cntr_tpsz_cd.value="";
	formObj.fm_cnt_cd.value="";
	formObj.fm_loc_cd.value="";
	formObj.fm_rgn_cd.value=""; 
	formObj.fm_yd_cd.value="";
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
/* Developer Work End */
