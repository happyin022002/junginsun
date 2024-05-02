/*=========================================================
* 
* * 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_3305.js
*@FileTitle  :  SCE COP CNTR REPO RULE Manage
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
			if(sheetObject.CheckedRows('check')=='0' ){
				ComShowCodeMessage('COM12176');
				return false;
			} 
			deleteRow();
			sheetObject.CheckAll('check',0,1);
			break;
		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, MULTI);
			break;
		case "btn_exceldown":
			doActionIBSheet(sheetObjects[0], document.form, "btn_exceldown", "", "");
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
//	initControl();
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
		      var HeadTitle="STS|CHK|CNTR Type Size|CNTR Display SEQ|Provider CNTR Type Size|Active Flag|"
		      + "Country Code|Location Code|Region Code|Center Code|Updation User|Update Date|Creation User|Creation Date";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"check" },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
		             {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"cntr_dp_seq",        KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"prov_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"act_flg",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rgn_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ctr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetWaitImageVisible(0);
		      SetColProperty("cre_dt", {Format:"####-##-####:##:##"} );
		      SetColProperty("upd_dt", {Format:"####-##-####:##:##"} );
		      SetColProperty("act_flg", {ComboText:"Yes|No", ComboCode:"Y|N"} );
              SetColProperty(0 ,"cntr_tpsz_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});	
              SetColProperty(0 ,"cntr_dp_seq" , {AcceptKeys:"N" , InputCaseSensitive:1});
              SetColProperty(0 ,"prov_cntr_tpsz_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      SetAutoRowHeight(0);
		      SetDataRowHeight(22);
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
	   //2013505 박은정 수정된 데이타 있을 경우 무시하고 리트리브 진행할것인지 물어봄 
 	   if(sheetObj.IsDataModified()== true){
 		   if(!ComShowConfirm("There are changed data. Do you still want to retrieve?")){
 			   return false;
 		   }
 	   }
 	   //
		ComOpenWait(true);
		if (validateForm(sheetObj, formObj, sAction) != true) {
			ComOpenWait(false);
			break;
		}
		formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj);
		sheetObj.DoSearch("ESD_SCE_3305GS.do", sParam );
		ComOpenWait(false);
		break;
		
	case SEARCH01:
		formObj.f_cmd.value=SEARCH01;
		var sParam=FormQueryString(formObj);
		var arrXml=sheetObj.GetSearchData("ESD_SCE_3305GS.do", sParam);
		if (arrXml.length > 0) {
			var valResult = ComGetTotalRows(arrXml);
			if(valResult == 1)
				return 'S';
			else 
				return 'F';
		}
		break;
		
	case MULTI: // Save
		if (sheetObj.FindStatusRow('I|U|D') ==""){
			ComShowCodeMessage('SCE01222');
			return false;
		} 
 	   	if (sheetObj.GetSaveString() == "") return;
		ComOpenWait(true, true);
		if (validateForm(sheetObj, formObj, sAction) != true) {
			ComShowCodeMessage('BKG00167');
			ComOpenWait(false, false);
			break;
		}
		formObj.f_cmd.value=MULTI;
		var sParam=sheetObj.GetSaveString(false, true, "ibflag");
		if (sParam == "") {
			ComOpenWait(false, false);
			return;
		}
		sParam += "&" + FormQueryString(formObj);
		var sXml=sheetObj.GetSaveData("ESD_SCE_3305GS.do", sParam);
		var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State != "S") {
			ComShowCodeMessage('COM130103', 'Data');
			ComOpenWait(false, false);
			return false;
		} else if (State == "S") {
			ComShowCodeMessage('COM130102', 'Data');
		}
		formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj);
		sheetObj.DoSearch("ESD_SCE_3305GS.do", sParam );
		ComOpenWait(false, false);
		break;

	case "btn_exceldown":
		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		break;
	}
}
function validateForm(sheetObj, formObj, sAction) {
	var sheet1RowCnt=sheetObj.RowCount();
	switch (sAction) {
		case IBSEARCH: { // retrieve
			break;
		}
		case MULTI: {
			var Msg="";
			if (!ComChkValid(formObj))
				return false;
			if(sheetObj.ColValueDup("cntr_tpsz_cd|cntr_dp_seq") > 0) {
				Msg="CNTR TPSZ Code";
				ComShowCodeMessage('COM131302', Msg);
				return false;
			}
			for ( var i=1; i <= sheet1RowCnt; i++) {
				if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "") {
					Msg="CNTR TPSZ Code";
					ComShowCodeMessage('COM130403', Msg);
					return false;
				}
				else if (sheetObj.GetCellValue(i, "cntr_dp_seq").toString() == "") {
					Msg="CNTR Display Seq";
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
		//CellValue2(nowRow, "cnt_cd") = formObj.frm_cnt_cd.value;
		// RowBackColor(nowRow) = "#FFCCFF";
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
	/*if(sheetObj.GetCellValue(Col) == "cntr_tpsz_cd" ||
			sheetObj.GetColSavename(Col) == "prov_cntr_tpsz_cd" ||
			sheetObj.GetColSavename(Col) == "cnt_cd" ||
			sheetObj.GetColSavename(Col) == "loc_cd" ||
			sheetObj.GetColSavename(Col) == "rgn_cd") 
	{*/
//		clearHiddenData();
//		if(sheetObj.ColSavename(Col) == "cntr_tpsz_cd" || sheetObj.ColSavename(Col) == "prov_cntr_tpsz_cd") {
//			formObj.fm_cntr_tpsz_cd.value=sheetObj.GetCellValue(Row, Col);
//		} 
//		else if(sheetObj.ColSavename(Col) == "cnt_cd") {
//			formObj.fm_cnt_cd.value=sheetObj.GetCellValue(Row, Col);
//		}
//		else if(sheetObj.ColSavename(Col) == "loc_cd") {
//			formObj.fm_loc_cd.value=sheetObj.GetCellValue(Row, Col);
//		}
//		else if(sheetObj.ColSavename(Col) == "rgn_cd") {
//			formObj.fm_rgn_cd.value=sheetObj.GetCellValue(Row, Col);
//		}
//		var result=doActionIBSheet(sheetObj, formObj, SEARCH01);
//		if(result == 'F') {
//			ComShowCodeMessage('COM130402', "[" + sheetObj.GetCellValue(Row, Col) + "] ");
//			// Init
//			clearHiddenData();
//			sheetObj.SetCellValue(Row, Col,"");
////			sheetObj.SelectCell(Row, Col, false);
////		}
//	}
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
