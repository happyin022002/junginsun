/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0947.js
*@FileTitle  : Customs Result Code Setup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], formObject, SEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObjects[0], formObject, MULTI);
			break;
		case "btn_Excel":
			if(sheetObjects[0].RowCount() < 1){//no data
       	     ComShowCodeMessage("COM132501");
       	    } else{
       	    	doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
       	    }
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
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBCombo Object as list
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * Combo Object initialization
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "dspo_tp_cd":
		var i=0;
		with (comboObj) {
			//ColBackColor(0) = "#CCFFFD";
			SetDropHeight(700);
			SetMultiSelect(0);
			SetMaxSelect(0);
		}
		break;
	}
}
/**
 * combo Change event handling
 */
function dspo_tp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode)
{
//	var t_cd = comboObjects[0].GetSelectCode();
//	form.dspo_tp_cd_text.value = comboObj.GetText(parseInt(newindex), 0);
//	comboObj.SetText()
//	if (t_cd == "F" || t_cd == "V") {
//		comboObjects[0].SetSelectCode(document.form.locl_trns_cd.value);
//	}
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
	for (i=0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}
	//Event needed for screen
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	doActionIBSheet(sheetObjects[0], document.form, INIT);
}
/**
 * setting sheet initial values and header
 * 
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
	case "sheet1":
		with(sheetObj){
			var HeadTitle1="|Seq.|Country|Code|Description|H|Type|Hold\nRemoval|Auto notice|Notice to O/B|Remark(s)|Update Date|User ID";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cstms_dspo_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			 {Type:"Text",      Hidden:0, Width:400,  Align:"Left",    ColMerge:1,   SaveName:"cstms_dspo_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hold",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Combo",     Hidden:0, Width:120,   Align:"Center",  ColMerge:1,   SaveName:"dspo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cstms_pair_dspo_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"auto_ntc_flg",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ob_ntc_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"diff_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			InitColumns(cols);
//			SetSheetHeight(470);
			ComResizeSheet(sheetObj);
			SetEditable(1);
			SetColProperty("auto_ntc_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
			SetColProperty("ob_ntc_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
			SetColProperty("upd_dt", {Format:"Ymd"} );
		}
		break;
	}
}
/**
 * process when you enter retrieve condition
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");//window.event.srcElement.getAttribute("maxlength");
	var srcValue=ComGetEvent("value");//window.event.srcElement.getAttribute("value");
	if ((srcName == "cnt_cd" || srcName == "cstms_dspo_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * process After retrieve 
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	setTotal();
	var type;
	for (var i=1; i < sheetObj.RowCount() + 1; i++) {
		type=sheetObj.GetCellValue(i, "dspo_tp_cd");
		if (type == "HP" || type == "HM") {
			sheetObj.SetCellEditable(i, "auto_ntc_flg",1);
		}
	}
}
/**
 * process After save
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
}
/**
 * Data sheet, data changes, the message processing
 */
function sheet1_OnChange(sheetObj, row, col, val){
	var colName=sheetObj.ColSaveName(col);
	switch (colName){
		case "dspo_tp_cd":		// Type
			if( val == "HP" || val == "HM" ){
				sheetObj.SetCellEditable(row, "auto_ntc_flg",1);
			} else {
				sheetObj.SetCellEditable(row, "auto_ntc_flg",0);
			}
		break;
	}
}
/** 
 * handling sheet process
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
		case INIT:
			// COMBO 
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0947GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, dspo_tp_cd, "val", "desc");
			dspo_tp_cd.InsertItem(0, "|", "");
			var arrCombo1=ComXml2ComboString(sXml, "desc", "val") ;
			arrCombo1[0]=" |" + arrCombo1[0];
			arrCombo1[1]=" |"  + arrCombo1[1];
			sheetObj.SetColProperty("dspo_tp_cd", {ComboText:arrCombo1[0], ComboCode:arrCombo1[1]} );
			break;
		case SEARCH: //retrieve
			if (!validateForm(sheetObj, formObj, sAction)) return false;
    		ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0947GS.do", FormQueryString(formObj) );
			//sheetObj.GetSearchData("ESM_BKG_0947GS.do ", FormQueryString(formObj));
			ComOpenWait(false);
			break;
		case MULTI: //save
			if (!validateForm(sheetObj, formObj, sAction)) return false;
    		ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("ESM_BKG_0947GS.do", FormQueryString(formObj));
			setTotal();
    		ComOpenWait(false);
			break;
		case IBDOWNEXCEL:
            if(sheetObj.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
                return;
            }
    		sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH: // retriev
		if (!ComChkRequired(formObj))
			return false;
		return true;
		break;
	case MULTI: //save
		if (!sheetObj.IsDataModified())
		{
			ComShowCodeMessage("BKG00743"); // There is no updated data to save.
			return false;
		}
		break;
	}
	return true;
}
/**
 *Total Row Set
 */
function setTotal() {
	if (sheetObjects[0].RowCount()> 0) {
		document.form.total.value=sheetObjects[0].GetTotalRows();
	}
}