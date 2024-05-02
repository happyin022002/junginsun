/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0431.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion :
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
//business script for esm_bkg_0431
/* developer job	*/
//common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event 
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, SEARCH);
			break;
		case "btn_new":
			doActionIBSheet(sheetObject, formObject, INIT);
			break;
		case "btn_downexcel":
			if(sheetObject.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObject.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
			}
			break;
		case "btn_viewReceiveFile":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				var row=sheetObject.GetSelectRow();
				var cnt_cd=sheetObject.GetCellValue(row, "cnt_cd");
				var io_bnd_cd=sheetObject.GetCellValue(row, "io_bnd_cd");
				
				
				var rcv_dt=sheetObject.GetCellValue(row, "dtl_rcv_dt");
				var rcv_seq=sheetObject.GetCellValue(row, "rcv_seq");
				var rcv_msg_tp_id=sheetObject.GetCellValue(row, "rcv_msg_tp_id");
				var vvd_cd=sheetObject.GetCellValue(row, "vvd_cd");
				var pol_cd=sheetObject.GetCellValue(row, "pol_cd");
				var pod_cd=sheetObject.GetCellValue(row, "pod_cd");
				var bl_no=sheetObject.GetCellValue(row, "bl_no");
				
				var param = "/opuscntr/ESM_BKG_0434.do" + "?pgmNo=ESM_BKG_0434&cnt_cd=" + cnt_cd + "&io_bnd_cd=" + io_bnd_cd
				+ "&rcvMsgTpId=" + rcv_msg_tp_id 
				+ "&vvdCd="   + vvd_cd 
				+ "&polCd="   + pol_cd
				+ "&podCd="   + pod_cd 
				+ "&blNo="    + bl_no
				+ "&rcv_dt="  + rcv_dt
				+ "&rcv_seq=" + rcv_seq;
				
				ComOpenWindowCenter(param, "0434", 600, 500, false);
			}
			break;
		case "btn_viewMsg":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				sheet1_OnDblClick(sheetObject, sheetObject.GetSelectRow(), 0);
			}
			break;
		case "btn_calendar":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.s_rcv_dt, formObject.e_rcv_dt, 'yyyy-MM-dd');
			break;
			
		case "btn_close":
			ComClosePopup(); 
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
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
function loadPage(sAction) {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}
	if (SEARCH == sAction) {
		doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	} else {
		doActionIBSheet(sheetObjects[0], document.form, INIT);
	}
	document.form.vvd_cd.focus();
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
	    with(sheetObj){
			var HeadTitle1="|Seq.|MSG|Receive Date|RCV SEQ|VVD|POL|POD|B/L No|Status|Status|Reason||||||||";
			var HeadTitle2="|Seq.|MSG|Receive Date|RCV SEQ|VVD|POL|POD|B/L No|Ack.|Result|Reason||||||||";
			var headCount=ComCountHeadTitle(HeadTitle1);
	
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
	
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hdnStatus" },
	             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rcv_msg_tp_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rcv_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rcv_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnd_ack_rcv_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	FontColor:"blue"  },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnd_ack_sub_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	FontColor:"blue"  },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cstms_rjct_msg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	FontColor:"blue"  },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ack_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"result_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnd_ack_err_note_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"err_cd_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"err_tp_ctnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dtl_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rcv_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
	             ];
	       
			InitColumns(cols);
			
			SetEditable(0);
			sheetObj.SetDataLinkMouse("cnd_ack_rcv_id",1);
			sheetObj.SetDataLinkMouse("cnd_ack_sub_cd",1);
			sheetObj.SetDataLinkMouse("cstms_rjct_msg",1);
//			SetSheetHeight(380);
			ComResizeSheet(sheetObj);
      	}


		break;
	}
}
/**
 * handling of Sheet process
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case INIT: //init
		if (sheetObj.id == "sheet1") {
			formObj.reset();
			sheetObj.RemoveAll();
			formObj.s_rcv_dt.value=ComGetDateAdd(null, 'd', -12, '-');
			formObj.e_rcv_dt.value=ComGetNowInfo('ymd', '-');
		}
		break;
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0431GS.do", FormQueryString(formObj) );
			for ( var i=2; i <= sheetObj.RowCount()+ 1; i++) {
				sheetObj.SetCellFontColor(i, "cnd_ack_rcv_id","#0000FF");
				sheetObj.SetCellFontUnderline(i, "cnd_ack_rcv_id",1);
				sheetObj.SetCellFontColor(i, "cnd_ack_sub_cd","#0000FF");
				sheetObj.SetCellFontUnderline(i, "cnd_ack_sub_cd",1);
				sheetObj.SetCellFontColor(i, "cstms_rjct_msg","#0000FF");
				sheetObj.SetCellFontUnderline(i, "cstms_rjct_msg",1);
				if (sheetObj.GetCellValue(i, "cnd_ack_sub_cd") == "37" || sheetObj.GetCellValue(i, "cnd_ack_sub_cd") == "21") {
					sheetObj.SetRowFontColor(i,"#FF0000");
				} else if (sheetObj.GetCellValue(i, "cnd_ack_sub_cd") == "01") {
					sheetObj.SetRowFontColor(i,"#0000FF");
				}
			}
			ComOpenWait(false);
		}
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj) {
	ComOpenWait(false);
	
	
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH:
		if (!ComChkValid(formObj))
			return false;
		if (formObj.rcv_dt_flg.checked) {
			if (ComIsNull(formObj.s_rcv_dt) || ComIsNull(formObj.s_rcv_tm) ||
				ComIsNull(formObj.e_rcv_dt) || ComIsNull(formObj.s_rcv_tm)) {
				ComShowCodeMessage('BKG00626', 'Receive Date & Receive Time');
				return false;
			}
			if (formObj.s_rcv_dt.value + formObj.s_rcv_tm.value > formObj.e_rcv_dt.value + formObj.e_rcv_tm.value) {
				ComShowMessage('Receive Date is invalid');
				return false;
			}
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
		if (ComIsNull(formObj.bl_no) && ComIsNull(formObj.vvd_cd) && !formObj.rcv_dt_flg.checked) {
			ComShowCodeMessage('BKG00626', 'VVD or Receive Date');
			ComSetFocus(form.vvd_cd)
			return false;
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
 * process input retrieving search condition
 */
function obj_KeyUp() {
	 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	 var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	/*if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}*/
}
/**
* mouse Event
* @param sheetObj sheetobj
* @param Button button
* @param Shift
* @param X 
* @param Y
*/
function sheet1_OnMouseMove(Button, Shift, X, Y) {
	var sheetObj=sheetObjects[0];
	var row=sheetObj.MouseRow();
	var col=sheetObj.MouseCol();
	if (row > 0) {
		if (sheetObj.ColSaveName(col) == "cnd_ack_rcv_id") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "ack_desc"));
		} else if (sheetObj.ColSaveName(col) == "cnd_ack_sub_cd") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "result_desc"));
		} else if (sheetObj.ColSaveName(col) == "cstms_rjct_msg") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "err_cd_desc"));
		}
	}
}
/**
* handling double click event
*/
function sheet1_OnDblClick(sheetObj, row, col) {
	var p1=sheetObj.GetCellValue(row, "cnd_ack_rcv_id");
	var p2=sheetObj.GetCellValue(row, "ack_desc");
	var p3=sheetObj.GetCellValue(row, "cnd_ack_sub_cd");
	var p4=sheetObj.GetCellValue(row, "result_desc");
	var p5=sheetObj.GetCellValue(row, "cnd_ack_err_note_desc");
	var p6=sheetObj.GetCellValue(row, "cstms_rjct_msg");
	var p7=sheetObj.GetCellValue(row, "err_cd_desc");
	var p8=sheetObj.GetCellValue(row, "err_tp_ctnt");
	var p9="";
	var p10="";
	var rcv_dt=sheetObj.GetCellValue(row, "dtl_rcv_dt");
	var rcv_seq=sheetObj.GetCellValue(row, "rcv_seq");
	var rcv_msg_tp_id=sheetObj.GetCellValue(row, "rcv_msg_tp_id");
	var vvd_cd=sheetObj.GetCellValue(row, "vvd_cd");
	var pol_cd=sheetObj.GetCellValue(row, "pol_cd");
	var pod_cd=sheetObj.GetCellValue(row, "pod_cd");
	var bl_no=sheetObj.GetCellValue(row, "bl_no");
	
	if ("BRC" == sheetObj.CellValue(row, "rcv_msg_tp_id") ) {
		if ( "R" == p1 ) {
			p9 = p3;
			p10 = p4;
		} else {	
			p9 = p1;
			p10 = p2;
		}
		p1 = "";
		p2 = "";
		p3 = "";
		p4 = "";
	}
	
	var param = "/opuscntr/ESM_BKG_0433.do?pgmNo=ESM_BKG_0433&rcvMsgTpId=" + rcv_msg_tp_id 
	+ "&vvdCd="   + vvd_cd 
	+ "&polCd="   + pol_cd
	+ "&podCd="   + pod_cd 
	+ "&blNo="    + bl_no
	+ "&rcv_dt="  + rcv_dt
	+ "&rcv_seq=" + rcv_seq
	+ "&p1=" + p1 + "&p2=" + p2 + "&p3=" + p3 + "&p4=" + p4 + "&p5=" + p5 
	+ "&p6=" + p6 + "&p7=" + p7 + "&p8=" + p8;	
	
	
	ComOpenWindowCenter(param, "04331", 520, 450, true);
}


