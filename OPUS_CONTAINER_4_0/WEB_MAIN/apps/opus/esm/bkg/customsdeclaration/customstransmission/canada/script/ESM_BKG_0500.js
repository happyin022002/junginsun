/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0500.js
*@FileTitle  : Canada ACI: Transmission History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/

// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name
 */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
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
			if (sheetObject.RowCount()== 0 ) {
		   		ComShowCodeMessage("COM132501"); // No data to dowload as Excel
		   	    return;
		   	} else {
		   		sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObject), SheetDesign:1,Merge:1 });
		   	}
 			
			break;
		case "btn_viewSendFile":
			if (validateForm(sheetObject, formObject, COMMAND01)) {
				sheet1_OnDblClick(sheetObject, sheetObject.GetSelectRow(), 0);
			}
			break;
		case "btn_calendar":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.s_snd_dt, formObject.e_snd_dt, 'yyyy-MM-dd');
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	document.form.vvd_cd.focus();
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj sheet Object
 * @param sheetNo sequence
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
		case "sheet1": //sheet1 init
		    with(sheetObj){        
	      var HeadTitle1="|Seq.|MSG|SEND DATE|OFFICE|USER ID|VVD|VVD in Baplie|POL|POD|Request|Status|UPDATE|SEND|RCV|ACCEPT||||||";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsm_msg_tp_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"snd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"snd_usr_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"snd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vvd_baplie",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ack_rcv_tp_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ack_snd_knt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ack_rcv_knt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ack_acpt_knt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ack_rcv_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dtl_snd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"his_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"stwg_snd_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	       
	      	InitColumns(cols);
	
	      	SetEditable(0);
	        sheetObj.SetDataLinkMouse("ack_rcv_tp_id",1);
//	        SetSheetHeight(420);
	        ComResizeSheet(sheetObj);

		}
	    break;
	}
}

/**
 * handling of Sheet 
 * @param sheetObj Sheet
 * @param formObj form object
 * @param sAction code
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case INIT: //init
		if (sheetObj.id == "sheet1") {
			formObj.reset();
			sheetObj.RemoveAll();
			//initSheet(sheetObj, 1)
			formObj.s_snd_dt.value=ComGetDateAdd(null, 'd', -12, '-');
			formObj.e_snd_dt.value=ComGetNowInfo('ymd', '-');
		}
		break;
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
 			sheetObj.DoSearch("ESM_BKG_0500GS.do", FormQueryString(formObj) );
			for ( var i=1; i <= sheetObj.RowCount(); i++) {
 				sheetObj.SetCellFontColor(i, "ack_rcv_tp_id","#0000FF");
 				sheetObj.SetCellFontUnderline(i, "ack_rcv_tp_id",1);
			}
			ComOpenWait(false);
		}
		break;
	}
}

/**
 * handling process for input validation
 * @param sheetObj Sheet
 * @param formObj form object
 * @param sAction code
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH:
		//checking format
		if (!ComChkValid(formObj))
			return false;
		if (formObj.snd_dt_flg.checked) {
			if (ComIsNull(formObj.s_snd_dt) || ComIsNull(formObj.s_snd_tm) ||
				ComIsNull(formObj.e_snd_dt) || ComIsNull(formObj.e_snd_tm)) {
				ComShowCodeMessage('BKG00626', 'Send Date & Send Time');
				return false;
			}
			if (formObj.s_snd_dt.value + formObj.s_snd_tm.value > formObj.e_snd_dt.value + formObj.e_snd_tm.value) {
				ComShowMessage('Send Date is invalid');
				return false;
			}
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
		if (ComIsNull(formObj.vvd_cd) && !formObj.snd_dt_flg.checked && ComIsNull(formObj.bl_no)) {
			ComShowCodeMessage('BKG00626', 'VVD or Send Date or B/L No');
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
 * moving next item automatically after inputting condition for searching 
 */
function obj_KeyUp() {
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var ssndalue=window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(ssndalue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * Event when the mouse is moving on sheet
 * @param sheetObj sheet Object
 * @param Button direction of mouse
 * @param Shift Shift 1, Ctrl  2, Etc. 0
 * @param X X coordinate
 * @param Y Y coordinate
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	var row=sheetObj.MouseRow();
	var col=sheetObj.MouseCol();
	if (row > 0) {
		if (sheetObj.ColSaveName(col) == "ack_rcv_tp_id") {
			sheetObj.SetToolTipText(row, col,sheetObj.GetCellText(row, "ack_rcv_desc"));
		}
	}
}

/**
 * Event which can be called when you double click at data cell
 * @param sheetObj sheet Object
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var cnt_cd=sheetObj.GetCellValue(row, "cnt_cd");
	var io_bnd_cd=sheetObj.GetCellValue(row, "io_bnd_cd");
	var dtl_snd_dt=sheetObj.GetCellValue(row, "dtl_snd_dt");
	var his_seq=sheetObj.GetCellValue(row, "his_seq");
	var msg_tp = sheetObj.GetCellValue(row, "trsm_msg_tp_id");
	var stwg_snd_id = sheetObj.GetCellValue(row, "stwg_snd_id");
	if(msg_tp=="BAPLIE"){
		params = "&trsm_msg_tp_id=" + msg_tp + "&stwg_snd_id=" + stwg_snd_id + "&snd_date=" + dtl_snd_dt;
	}else{
		params = "&cnt_cd=" + cnt_cd + "&io_bnd_cd=" + io_bnd_cd + "&snd_dt=" + dtl_snd_dt + "&his_seq="+ his_seq;
	}
	ComOpenWindowCenter("/opuscntr/ESM_BKG_0501.do?pgmNo=ESM_BKG_0501"+params, "0501", 700, 630, false);
}

function sheet1_OnSearchEnd(sheet1, ErrMsg) { // BAPLIE로 조회하는 경우 숨겨진 칼럼이 나타내게 한다.
    if(document.form.trsm_msg_tp_id.value=="BACA"){
    	sheet1.SetColHidden("vvd_baplie",0);
    }else{
    	sheet1.SetColHidden("vvd_baplie",1);
    }
}