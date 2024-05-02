/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_2002.js
*@FileTitle  : Customs Package Type Code Conversion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    

    var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	var change = 0;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_pop":
			comBkgCallPop0696("callbackPckTp2", "");
			break;

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
			var sheet1RowCnt = sheetObjects[0].RowCount();
			for(var i=1; i <= sheet1RowCnt; i++) {
				if(sheetObjects[0].GetCellValue(i,"ibflag")!='I' && sheetObjects[0].GetCellValue(i,"ibflag")!='U' && sheetObjects[0].GetCellValue(i,"ibflag")!='D'){
					change=change+1;
				}
			}
			if (change == sheet1RowCnt) {
				ComShowCodeMessage('BKG00260');
				break;
			}
			doActionIBSheet(sheetObjects[0], document.form, MULTI);
			break;
		case "btn_exceldown":
			doActionIBSheet(sheetObjects[0], document.form, "btn_exceldown","", "");
			break;
		case "btn_excelup":
			doActionIBSheet(sheetObjects[0], document.form, "btn_excelup");
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
 * registering IBSheet Object as list adding process for list in case of
 * needing batch processing with other items defining list on the top of
 * source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
    
    
    
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// necessary event on the screen
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	axon_event.addListenerForm('click', 'obj_click', document.form); // click

	doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
}


function obj_change() {
	var formObj = document.form;
	var elementNm = ComGetEvent("name");
	switch (elementNm) {
	case "frm_cnt_cd":
		sheetObjects[0].RemoveAll();
		break;
	}
}

function obj_focus() {
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

/**
 * setting sheet initial values and header
 * 
 * @param sheetObj
 * @param sheetNo
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
              var HeadTitle="|Sel.|Seq|Country|Receiver ID|Package Type|Customs Pck Type|Package Code Description";
              var headCount=ComCountHeadTitle(HeadTitle);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
                     {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rcvr_id",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
                     {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cstms_pck_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, AcceptKeys:"E|N", InputCaseSensitive:1 },
                     {Type:"Text",      Hidden:0, Width:600,  Align:"Left",    ColMerge:1,   SaveName:"pck_cd_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetWaitImageVisible(0);              
              SetAutoRowHeight(0);
              SetDataRowHeight(22);
			  SetSheetHeight(440);
		}
		break;
	}
}

/**
 * handling sheet process
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return void
 */
var arrCombo;
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case SEARCH03:
			formObj.f_cmd.value = SEARCH03;
			var sXml = sheetObj.GetSearchData("ESM_BKG_2002GS.do", FormQueryString(formObj));
			arrCombo = ComXml2ComboString(sXml, "attr_ctnt2", "attr_ctnt1");
			break;
		case IBSEARCH:
			ComOpenWait(true);
			if (validateForm(sheetObj, formObj, sAction) != true) {
				ComOpenWait(false);
				break;
			}
			sheetObjects[0].RemoveAll();
			if (formObj.frm_cnt_cd.value == "EU")
			{
				sheetObj.SetColProperty("rcvr_id", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
			}
			else
			{
				sheetObj.SetColProperty("rcvr_id", {ComboText:'ALL', ComboCode:'ALL'});
			}
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			sheetObj.DoSearch("ESM_BKG_2002GS.do", sParam);
			ComOpenWait(false);
			break;
		case SEARCH01:      //retrieve
        	formObj.f_cmd.value=SEARCH01;
			sheetObj.SetWaitImageVisible(0);
			var sXml=sheetObj.GetSaveData("ESM_BKG_2002GS.do", FormQueryString(formObj));
        	var valResult=ComGetEtcData(sXml, "pck_tp_cnt");
        	document.form.chk_tp_cd.value=valResult;
           	break;
		case SEARCH02:
			formObj.f_cmd.value=SEARCH02;
			  sheetObj.SetWaitImageVisible(0);
			  var sXml=sheetObj.GetSaveData("ESM_BKG_2002GS.do", FormQueryString(formObj));
        	  var valResult1=ComGetEtcData(sXml, "pck_tp_cnt1");
        	  document.form.chk_pck_cd.value=valResult1;
         	break;
		case MULTI: // Save
           if(!validateForm(sheetObj,formObj,sAction)){
        	   return;
			}
			ComOpenWait(true, true);
			formObj.f_cmd.value=MULTI;
			var sParam=sheetObj.GetSaveString(false, true, "ibflag");
			var sXml=sheetObjects[0].GetSaveData("ESM_BKG_2002GS.do", "f_cmd=" + MULTI + "&" +sParam);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				ComOpenWait(false, false);
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('BKG00166');
			}
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			ComOpenWait(false, false);
			break;
		case "btn_exceldown":
        	sheetObj.Down2Excel({ HiddenColumn:1});
			break;
		case "btn_excelup":
    	    sheetObj.RemoveAll();
			sheetObj.LoadExcel({ Mode:"HeaderMatch"});
			break;
	}
}

function sheet1_OnLoadExcel(SheetObj,result,code, msg) {
	 if(isExceedMaxRow(msg))return;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	if (result) {
		
		var sheet1RowCnt = sheetObj.RowCount();
		for ( var i = 1; i <= sheet1RowCnt; i++) {
			if (sheetObj.GetCellValue(i, "ibflag") == 'I') {
				formObj.f_cmd.value=SEARCH02;
				formObj.chk_cnt_cd.value=sheetObj.GetCellValue(i, "cnt_cd");
				formObj.chk_pck_tp_cd.value=sheetObj.GetCellValue(i, "pck_tp_cd");
				formObj.chk_cstms_pck_tp_cd.value=sheetObj.GetCellValue(i, "cstms_pck_tp_cd");
				if(sheetObj.GetCellValue(i, "cnt_cd").length != 2){
		      		ComShowCodeMessage('BKG95018', i + ' Row Country Code', '2');
		      		sheetObj.SetCellValue(i, "cnt_cd",'',0);
		      	}
				if(sheetObj.GetCellValue(i, "pck_tp_cd").length != 2){
		      		ComShowCodeMessage('BKG95018', i + ' Row Package Type Code', '2');
					sheetObj.SetCellValue(i, "pck_tp_cd",'',0);
		      	}
				if(sheetObj.GetCellValue(i, "cstms_pck_tp_cd").length < 2){
		      		ComShowCodeMessage('BKG95018', i + ' Row Customs Package Type Code', 'over 2');
					sheetObj.SetCellValue(i, "cstms_pck_tp_cd",'',0);
		      	}

				setRcvrId (i, sheetObj.GetCellValue(i, "cnt_cd"));

				if(sheetObj.GetCellValue(i,"pck_tp_cd") != ""){
		      		doActionIBSheet(sheetObj, formObj, SEARCH02);
					if (document.form.chk_pck_cd.value == '0') {
						ComShowMessage("Package Type Code does not exist. Please check again!!");
						sheetObj.SetCellValue(i, "pck_tp_cd", '', 0);
					}
				}
			}
		}
	}
}
    
/**
 * handling process for input validation
 * 
 * @param SheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
	var sheet1RowCnt = sheetObj.RowCount();
	switch (sAction) {
		case IBSEARCH: { // retrieve
			if (!ComChkValid(formObj))
				return false;
			var frmCntCd = formObj.frm_cnt_cd.value;
			// ComShowMessage("[" + etaDt + "][" + blNo +"]["+ cntrNo + "]");
			if (frmCntCd == "") {
				ComShowCodeMessage('BKG01101', 'Country Code');
				ComSetFocus(formObj.frm_cnt_cd);
				return false;
			}
			if (formObj.frm_cnt_cd.value.length != 2) {
				ComShowCodeMessage('BKG95018', 'Country Code', '2');
				ComSetFocus(formObj.frm_cnt_cd);
				return false;
			}
			break;
		}
		case MULTI : {
			if (!ComChkValid(formObj)) return false;
			for(var i=1; i <= sheet1RowCnt; i++) {
				if(sheetObj.GetCellValue(i,"cnt_cd")=="" || sheetObj.GetCellValue(i,"pck_tp_cd") == "" || sheetObj.GetCellValue(i,"cstms_pck_tp_cd") == "" || sheetObj.GetCellValue(i,"rcvr_id") == ""){
					var Msg="Country Code or Receiver ID or Package Type Code or Customs Package Type Code.";
					ComShowCodeMessage('BKG00626',  Msg);
					return false;
				}
			}
			break;
		}
    } // end switch()
    return true;
}

/**
 * process when input retrieve keyword
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = ComGetEvent("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
}

/**
 * add Row of sheet
 * 
 * @param formObj
 */
function addRow(formObj) {
	with (sheetObjects[0]) {
		var nowRow = GetSelectRow();
		nowRow = DataInsert(-1);
		SetCellValue(nowRow, "cnt_cd", formObj.frm_cnt_cd.value, 0);
		
		setRcvrId (nowRow, GetCellValue(nowRow, "cnt_cd"));

		return true;
	}
}

function setRcvrId (row, cnt_cd) {
	if (cnt_cd != "")
	{
		if (cnt_cd == "EU")
		{
			sheetObjects[0].CellComboItem(row, "rcvr_id", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
			sheetObjects[0].SetCellEditable(row, "rcvr_id", 1);
		}
		else
		{
			sheetObjects[0].CellComboItem(row, "rcvr_id", {ComboText:'ALL', ComboCode:'ALL'});
			sheetObjects[0].SetCellValue(row, "rcvr_id", "ALL");
			sheetObjects[0].SetCellEditable(row, "rcvr_id", 0);
		}
	}
}

/**
 * delete Row handler
 */
function deleteRow() {
	with (sheetObjects[0]) {

		var sRowStr = FindCheckedRow("check");
		var arr = sRowStr.split("|");
		var delCnt = 0;
		
		for ( var i = 0; i < arr.length; i++) {
			var idx = arr[i] - delCnt;

			SetRowStatus(idx, "D");
			
			if (GetRowStatus(idx) == "I")
			{
				delCnt++;
			}
			else
			{
				SetRowHidden(idx, "1");
			}
		}
	}
}

/*
 * setting key input on the sheet
 */
function obj_KeyPress() {
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var srcName = event.srcElement.getAttribute("name");
	var srcValue = event.srcElement.getAttribute("value");
	switch (event.srcElement.dataformat) {
	case "engup":
		ComKeyOnlyAlphabet('upper');
		break;
	}
}

/**
 * checking key field input Validation
 * 
 * @param SheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	// checking Package Type Code validation

	if (sheetObj.ColSaveName(Col) == "pck_tp_cd") {
		formObj.chk_pck_tp_cd.value=sheetObj.GetCellValue(Row, Col);
		formObj.chk_cnt_cd.value=sheetObj.GetCellValue(Row, "cnt_cd");
		formObj.chk_cstms_pck_tp_cd.value=sheetObj.GetCellValue(Row, "cstms_pck_tp_cd");
		if (sheetObj.GetCellValue(Row, "pck_tp_cd") != "") {
			doActionIBSheet(sheetObj, formObj, SEARCH02);
			if (document.form.chk_pck_cd.value == '0') {
				ComShowMessage("Package Type Code does not exist. Please check again!!");
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pck_tp_cd", '', 0);
			}
		}
	} else if (sheetObj.ColSaveName(Col) == "cnt_cd") {
		setRcvrId (Row, sheetObj.GetCellValue(Row, "cnt_cd"));
	}
	
}

/**
 * calling function in case of Sheet OnPopupClick event calling pop-up
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
	var colname = sheetObj.ColSaveName(Col);
	switch (colname) {
	case "pck_tp_cd":
		comBkgCallPop0696("callbackPckTp", "");
		break;
	}
}

function callbackPckTp(returnVal) {
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "pck_tp_cd", returnVal.cd, 0);
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cstms_pck_tp_cd", returnVal.usa_cstms, 0);
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "pck_cd_desc", returnVal.nm, 0);
}
       
function callbackPckTp2(returnVal) {
	var formObj = document.form;
	formObj.frm_pck_tp_cd.value = returnVal.cd;
}
