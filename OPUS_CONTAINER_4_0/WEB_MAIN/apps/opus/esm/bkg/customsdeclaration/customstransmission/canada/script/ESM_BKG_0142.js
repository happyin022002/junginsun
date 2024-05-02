/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0142.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * esm_bkg_0142: business script for esm_bkg_0142
 */
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var combo1=null;
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
	var sheetObj=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		var row=sheetObj.GetSelectRow();
		switch (srcName) {
		case "btn_retrieve":
			formObj.subcmd.value="";
			doActionIBSheet(sheetObj, formObj, SEARCH);
			break;
		case "btn_new":
			formObj.reset();
			sheetObj.RemoveAll();
			break;
		case "btn_downexcel":
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			}
			break;
			
		case "btn_print":
			if (sheetObj.RowCount()== 0) {
				ComShowCodeMessage("BKG00889");
				return;
			}
			ComOpenWindowCenter("/opuscntr/ESM_BKG_0840.do?pgmNo=ESM_BKG_0840", "0840", 1024, 768, false);
			break;
		case "btn_blInquiry":
			if (validateForm(sheetObj, formObj, COMMAND01)) {
				var bl_no=sheetObj.GetCellValue(row, "bl_no");
				if (bl_no != "") {
					ComOpenWindowCenter("/opuscntr/ESM_BKG_0029_POP.do?mainPage=false&pgmNo=ESM_BKG_0029_2&type=edit&bl_no=" + bl_no, "0029", 1200, 750, false);
				}
			}
			break;
		case "btn_history":
			if (validateForm(sheetObj, formObj, COMMAND01)) {
				var bl_no=sheetObj.GetCellValue(row, "bl_no");
				var vvd_cd=sheetObj.GetCellValue(row, "vvd_cd");
				var url="/opuscntr/ESM_BKG_0431_POP.do?pgmNo=ESM_BKG_0431&bl_no=" + bl_no + "&vvd_cd=" + vvd_cd + "&f_cmd=" + SEARCH;
				ComOpenWindowCenter(url, "0431", 1020, 660, true);
			}
			break;
//		case "btn_viewMsg":
//			if (validateForm(sheetObj, formObj, COMMAND01)) {
//				sheet1_OnDblClick(sheetObj, sheetObj.GetSelectRow(), 0);
//			}
//			break;
		case "btn_37":
			formObj.subcmd.value="37";
			if (ComIsBtnEnable("btn_37"))
				doActionIBSheet(sheetObj, formObj, SEARCH);
			break;
		case "btn_21":
			formObj.subcmd.value="21";
			if (ComIsBtnEnable("btn_21"))
				doActionIBSheet(sheetObj, formObj, SEARCH);
			break;
		case "btn_snd_calendar":
			var cal=new ComCalendarFromTo();
			cal.select(formObj.s_snd_dt, formObj.e_snd_dt, 'yyyy-MM-dd');
			break;
		case "btn_rcv_calendar":
			var cal=new ComCalendarFromTo();
			cal.select(formObj.s_rcv_dt, formObj.e_rcv_dt, 'yyyy-MM-dd');
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
 * registering combo Object as list
 * @param combo_obj combo Object
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
* control scroll event
*/
var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		//khlee- Preferences change the name of the function to start
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee- The final configuration functions added
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}
	combo1=comboObjects[0];
	comboCnt=comboObjects.length;
	// IBMultiCombo initialization
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	document.form.vvd_cd.focus();
	// The required events on the screen
//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('click', 'obj_Click', document.form);
}
/**
 * The initial setting combo
 * @param comboObj combo Object
 */
function initCombo(comboObj) {
	comboObj.SetMultiSelect(1);
	comboObj.UseCode=true;
	comboObj.LineColor="#ffffff";
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	///comboObj.SetMultiSeparator(",");
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj sheet Object
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
	    with(sheetObj){
        
		      var HeadTitle1="Seq.|VVD|POL|POD|B/L No.|Filer|C.STS|Stage|Status|Status|Reason|Type|Send Date|Receive Date|Error Note|||||||||||processed|error";
		      var HeadTitle2="Seq.|VVD|POL|POD|B/L No.|Filer|C.STS|Stage|Ack.|Result|Reason|Type|Send Date|Receive Date|Error Note|||||||||||processed|error";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cstms_file_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mf_sts_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cstms_trsm_sts_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cstms_ack_rcv_rslt_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cstms_ack_proc_rslt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cstms_ack_rjct_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"amdt_snd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cstms_ack_rcv_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"cstms_ack_rjct_msg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ack_desc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"result_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"err_cd_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"err_tp_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"manifest_ttl",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"sent_by_a6a",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"sent_by_al",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"target_ttl",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"unmanifest",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"total",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"processed",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"error",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(0);
		      sheetObj.SetDataLinkMouse("cstms_ack_rcv_rslt_cd",1);
		      sheetObj.SetDataLinkMouse("cstms_ack_proc_rslt_cd",1);
		      sheetObj.SetDataLinkMouse("cstms_ack_rjct_cd",1);
		      SetSheetHeight(330);
	    }
		break;
	}
}
/**
 * Sheet handling process
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction Work-handling code
 */
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case INIT:
		//Status Combo
		formObj.f_cmd.value=INIT;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0142GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sXml, cstms_ack_proc_rslt_cd, "attr_ctnt1", "attr_ctnt1|attr_ctnt2");
		cstms_ack_proc_rslt_cd.InsertItem(0, "", "");
		cstms_ack_proc_rslt_cd.SetDropHeight(200);
		break;
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0142GS.do", FormQueryString(formObj) );
		}
		break;
	case IBSEARCHAPPEND: // Retrieve the paging
		formObj.f_cmd.value=SEARCH;
		sheetObj.DoSearch("ESM_BKG_0142GS.do", FormQueryString(formObj) +"&"+ "page_no=" + PageNo,{Append:true} );
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj){
	var formObj = document.form;
	if (sheetObj.RowCount()> 0 && !formObj.rpt_flag[2].checked) {
		IBS_CopyRowToForm(sheetObj, formObj, 2, "frm_");
		for ( var i=0; i < formObj.elements.length; i++) {
			if (formObj.elements[i].name.indexOf("frm_") >= 0)
			{
				formObj.elements[i].value=ComAddComma2(formObj.elements[i], "#,###");
			}
		}
	} else {
		for ( var i=0; i < formObj.elements.length; i++) {
			if (formObj.elements[i].getAttribute("readonly") == true) {
				formObj.elements[i].value="";
			}
		}
	}
	for ( var i=2; i <= sheetObj.RowCount()+ 1; i++) {
		sheetObj.SetCellFontColor(i, "cstms_ack_rcv_rslt_cd","#0000FF");
			sheetObj.SetCellFontUnderline(i, "cstms_ack_rcv_rslt_cd",1);
			sheetObj.SetCellFontColor(i, "cstms_ack_proc_rslt_cd","#0000FF");
			sheetObj.SetCellFontUnderline(i, "cstms_ack_proc_rslt_cd",1);
			sheetObj.SetCellFontColor(i, "cstms_ack_rjct_cd","#0000FF");
			sheetObj.SetCellFontUnderline(i, "cstms_ack_rjct_cd",1);
			if (sheetObj.GetCellValue(i, "cstms_ack_proc_rslt_cd") == "37"
			|| sheetObj.GetCellValue(i, "cstms_ack_proc_rslt_cd") == "44"
			|| sheetObj.GetCellValue(i, "cstms_ack_proc_rslt_cd") == "21"
			|| sheetObj.GetCellValue(i, "cstms_ack_proc_rslt_cd") == "48") {
				sheetObj.SetRowFontColor(i,"#FF0000");
			} else if (sheetObj.GetCellValue(i, "cstms_ack_proc_rslt_cd") == "01") {
								sheetObj.SetRowFontColor(i,"#0000FF");
			}
	}
		ComOpenWait(false);
}
/**
 * Status combo click -> all checkd
 * @param comboObj combo Object
 * @param index  index
 * @param code code
 */
//function cstms_ack_proc_rslt_cd_OnCheckClick(comboObj, index, code) {
////	if (code == "") {
////		var bChk=comboObj.GetItemCheck(index);
////		for ( var i=1; i < comboObj.GetItemCount(); i++) {
////			comboObj.SetItemCheck(i,bChk);
////		}
////	}
//	if (index == 0) {
//		var bChk = comboObj.GetItemCheck(0);
//		var comboCnt = comboObj.GetItemCount();
//		for (var i = 0; i < comboCnt; i++) {
//			comboObj.SetItemCheck(i, bChk)
//		}
//	} else {
//		comboObj.SetItemCheck(0, false)
//	}
//}

function cstms_ack_proc_rslt_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
}

var selComboIndex, selComboCode;
function cstms_ack_proc_rslt_cd_OnSelect(comboObj, index, text, code) {
	selComboIndex = index;
	selComboCode = code;
}
/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj form Object
 * @param sAction Work-handling code
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH: //Retrieve
		// Check the default format
		if (!ComChkValid(formObj))
			return false;
		if (formObj.rpt_flag[0].checked || formObj.rpt_flag[1].checked) {
			// A6A, E10
			if (formObj.subcmd.value == "") {
				// Retrieve
				if (ComIsNull(formObj.vvd_cd) && ComIsNull(formObj.bl_no) && ComIsNull(formObj.s_snd_dt) && ComIsNull(formObj.s_rcv_dt)) {
					ComShowCodeMessage('BKG00626', 'VVD or B/L No or Send Date(From,To) or Receive Date(From, To)');
					return false;
				}
			} else {
				// 37/01, 21/01
				if (ComIsNull(formObj.bl_no) && ComIsNull(formObj.vvd_cd) && ComIsNull(formObj.s_rcv_dt)) {
					ComShowCodeMessage('BKG00626', 'VVD or B/L No or Receive Date(From, To)');
					return false;
				}
				break;
			}
		} else {
			// A6
			if (ComIsNull(formObj.vvd_cd) && ComIsNull(formObj.s_snd_dt) && ComIsNull(formObj.s_rcv_dt)) {
				ComShowCodeMessage('BKG00626', 'VVD or Send Date(From,To) or Receive Date(From, To)');
				return false;
			}
		}
		if (!ComIsNull(formObj.s_snd_dt.value)) {
			var diffDate=ComGetDaysBetween(formObj.s_snd_dt, formObj.e_snd_dt);
			var year=formObj.s_snd_dt.value.substring(0, 4);
			var month=formObj.s_snd_dt.value.substring(5, 7);
			var lastDay=ComGetLastDay(year, parseInt(month, 10));			
			if (diffDate + 1 > lastDay) {
				ComShowCodeMessage('BKG01080');
				formObj.e_snd_dt.select();
				return false;
			}
		}
		if (!ComIsNull(formObj.s_rcv_dt.value)) {
			var diffDate=ComGetDaysBetween(formObj.s_rcv_dt, formObj.e_rcv_dt);
			var year=formObj.s_rcv_dt.value.substring(0, 4);
			var month=formObj.s_rcv_dt.value.substring(5, 7);
			var lastDay=ComGetLastDay(year, parseInt(month, 10));
			if (diffDate + 1 > lastDay) {
				ComShowCodeMessage('BKG01080');
				formObj.e_rcv_dt.select();
				return false;
			}
		}
		break;
	case COMMAND01:
		if (sheetObj.RowCount()<= 0) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		break;
	}
	return true;
}
/**
 * Mouse Event
 * @param sheetObj sheet Object
 * @param The direction of the mouse button
 * @param Shift (Shift key press: 1, Ctrl key press: 2,ETC:0)
 * @param X X Coordinates
 * @param Y Y Coordinates
 */
function sheet1_OnMouseMove(Button, Shift, X, Y) {
	var sheetObj=sheetObjects[0];
	var row=sheetObj.MouseRow();
	var col=sheetObj.MouseCol();
	if (row > 0) {
		if (sheetObj.ColSaveName(col) == "cstms_ack_rcv_rslt_cd") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "ack_desc"));
		} else if (sheetObj.ColSaveName(col) == "cstms_ack_proc_rslt_cd") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "result_desc"));
		} else if (sheetObj.ColSaveName(col) == "cstms_ack_rjct_cd") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "err_cd_desc"));
		}
	}
}
/**
 * double Click Event
 * @param sheetObj sheet Object
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
//	var p1=sheetObj.GetCellValue(row, "cstms_ack_rcv_rslt_cd");
//	var p2=sheetObj.GetCellValue(row, "ack_desc");
//	var p3=sheetObj.GetCellValue(row, "cstms_ack_proc_rslt_cd");
//	var p4=sheetObj.GetCellValue(row, "result_desc");
//	var p5=sheetObj.GetCellValue(row, "cstms_ack_rjct_msg");
//	var p6=sheetObj.GetCellValue(row, "cstms_ack_rjct_cd");
//	var p7=sheetObj.GetCellValue(row, "err_cd_desc");
//	var p8=sheetObj.GetCellValue(row, "err_tp_ctnt");
//	ComOpenWindowCenter("/opuscntr/ESM_BKG_0433.do?pgmNo=ESM_BKG_0433&p1=" + p1 + "&p2=" + p2 + "&p3=" + p3 + "&p4=" + p4 + "&p5=" + p5 + "&p6=" + p6 + "&p7="
//			+ p7 + "&p8=" + p8, "0433", 560, 460);
	
	var formObj = document.form;
	
	if (validateForm(sheetObj, formObj, COMMAND01)) {
		var bl_no=sheetObj.GetCellValue(row, "bl_no");
		var vvd_cd=sheetObj.GetCellValue(row, "vvd_cd");
		var url="/opuscntr/ESM_BKG_0431_POP.do?pgmNo=ESM_BKG_0431&bl_no=" + bl_no + "&vvd_cd=" + vvd_cd + "&f_cmd=" + SEARCH;
		ComOpenWindowCenter(url, "0431", 1020, 660, true);
	}	
}
/**
 * Button Disable 
 */
function obj_Click() {
	if (document.form.rpt_flag[2].checked) {
		ComBtnDisable("btn_37");
		ComBtnDisable("btn_21");
		ComBtnDisable("btn_blInquiry");
	} else {
		ComBtnEnable("btn_37");
		ComBtnEnable("btn_21");
		ComBtnEnable("btn_blInquiry");
	}
}
/**
 * handling  search condition  Input 
 */
function obj_KeyUp() {
	 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	 var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
