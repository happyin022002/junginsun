/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FNS_INV_0126.js
 * @FileTitle : EDI Submission (Honey Well)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.05.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 1.0 Creation 2012.05.17 Sang-Hyun Kim
 */

/**
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 *                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 *                 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 */

/**
 * Define script for creating screen.
 */
function FNS_INV_0126() {
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
}

// Common variable.
var sheetObjects = new Array();
var sheetCnt = 0;

// IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

// Checking readOnly calendar.
var isCalendar = false;

// Define event handle for button.
document.onclick = processButtonClick;

/** 
 * Selecting logic by button's name.
 */
function processButtonClick(){
	// Selection sheet.
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_add" :
			sheetObj.DataInsert(-1);
            break;
		case "btn_remove" :
			var iCheckRow = sheetObj.FindCheckedRow("sel_chk");
			var rows = iCheckRow.split("|");
			for (var i=0; i<(rows.length - 1); i++) {
				sheetObj.RowDelete(rows[i], false);
			}
			break;
		case "btn_apply" :
			var value = "";
			for (var i=1; i<=sheetObj.RowCount; i++) {
				var orderNo = sheetObj.CellText(i, "orderNo");
				orderNo = orderNo.replace(/ /g, "");
				if (orderNo != "") {
					value = value + sheetObj.CellText(i, "orderNo");
					if (i != sheetObj.RowCount) {
						value = value + ",";
					}
				}
			}
			opener.location.href = "JavaScript:getFNS_INV_0126(" + selRow + ", '" + value + "');";
			window.close();
			break;
		case "btn_close" :
			window.close();
			break;
		}
	} catch(e) {
		if ( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Add sheet to array.
 * 
 * @param sheet_obj
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Add combo object to array.
 * 
 * @param combo_obj
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/** 
 * Initialize.
 */
function loadPage() {
	var formObj = document.form;

	for (var i=0; i<sheetObjects.length; i++) {
		// Call initial setting.
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1);

		// Call latest setting.
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();

	var orderNo = orderNos.split(",");
	for (var i=0; i<orderNo.length; i++) {
		if (orderNo[i] != "") {
			var sheetObject = sheetObjects[0];
			var row = sheetObject.DataInsert(-1);
			sheetObject.CellValue2(row, 0) = 0;
			sheetObject.CellValue2(row, 1) = orderNo[i];
		}
	}
}

/**
 * Initialize sheet and header.
 * Coding logic by sheet's count.
 * 
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1" :
		with (sheetObj) {
			style.height = 280;
			SheetWidth = mainTable.clientWidth;
		
			// Set host information(Request:HostIp, Port, PagePath).
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// Merge kind(Option:Default msNone).
			MergeSheet = msPrevColumnMerge; //msPrevColumnMerge + msHeaderOnly; or msHeaderOnly;

			// Set use edit(Option:Default false).
			Editable = true;
			sheetObj.EditableColorDiff = false;

			// Set row information(Request:HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100).
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "Sel.|Order Number";
			var headCount = ComCountHeadTitle(HeadTitle);

			// Set column information(Request:COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false).
			InitColumnInfo(headCount, 0, 0, true);

			// Set header's function.
			InitHeadMode(false, false, true, true, false, false);

			// Set header row information(Request:ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false).
			InitHeadRow(0, HeadTitle, true);

			var rowCnt = 0;

			// Data attribute(ROW,      COL,    DATATYPE,       WIDTH,  DATAALIGN,      COLMERGE,    SAVENAME,          KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX).
			InitDataProperty(rowCnt,	cnt++,	dtCheckBox,		45,		daCenter,		false,		 "sel_chk",			false,		"",			dfNone,		0,			true,		true);
			InitDataProperty(rowCnt,	cnt++,	dtData,			90,		daCenter,		true,		 "orderNo",			false,		"",			dfNone,		0,			true,		true);

			CountPosition = 2;
			SelectHighLight = false;
		}
		break;			
	}
}

/** 
 * Initialize object's event.
 */
function initControl() {
	var formObj = document.form;

	// Catching event.
	axon_event.addListenerFormat("keypress", "obj_keypress", formObj);
	axon_event.addListenerFormat("focus", "obj_activate", formObj);
	axon_event.addListenerForm("keyup", "obj_keyup", formObj);
	axon_event.addListenerForm("blur", "obj_deactivate", formObj);
	axon_event.addListenerForm("change", "obj_onchange", formObj);
}
	
/**
 * On key press.
 */
function obj_keypress() {
	var formObj = document.form;

	switch (event.srcElement.dataformat) {
	case "float" :
		// Only number or '.'.
		ComKeyOnlyNumber(event.srcElement, ".-"); 
		break;
	case "int" :
		// Only number.
		ComKeyOnlyNumber(event.srcElement,"-"); 
		break;
	case "engup" :
		switch (event.srcElement.name) {
		case "retr_input" :
			// Only upper case or number.
			ComKeyOnlyAlphabet('uppernum'); 
			break;
		case "ar_if_no" :
			ComKeyOnlyAlphabet('uppernum'); 
			break;
		case "cust_cnt_cd" :
			// Only upper case.		    	        
			ComKeyOnlyAlphabet('upper');
			break;
		case "port" :		    	        
			ComKeyOnlyAlphabet('upper'); 
			break;
		}
		break;
	default :
		ComKeyOnlyNumber(event.srcElement);
		break;
	}
}

/**
 * On before activate.
 */
function obj_activate() {
	var formObj = document.form;

	// Remove mask seperator.
	ComClearSeparator (event.srcElement);
	event.srcElement.select();
}

/**
 * On key up.
 */
function obj_keyup() {
	var formObj = document.form;

	switch (event.srcElement.name) {
	default :
		break;
	}
}

/**
 * On before deactivate.
 */
function obj_deactivate() {
	var sheetObject = sheetObjects[0];
	var formObj = document.form;

	switch (event.srcElement.name) {
	default:
		// Checking length.
		ComChkObjValid(event.srcElement);
		break;
	}
}

/** 
 * On change.
 */
function obj_onchange() {
	var sheetObject = sheetObjects[0];
	var formObj = document.form;

	switch (event.srcElement.name) {
	default :
       	break;
    }
}

/**
 * Function for retrieve, save.
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH_ASYNC01 : // Retrieve initial AR_OFFICE_LIST.
		break;
	case IBSEARCH : // Retrieve.
		break;
	case IBINSERT : // Save.
		break;
	}
}

/**
 * Checking validation values.
 * 
 * @param sheetObj  
 * @param formObj
 * @param sAction
 * @return boolean
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH : // Retrieve.
		break;
	case IBINSERT : // Save.
		break;
	}
	return true;
}

/**
 * Initalization screen.
 * 
 * @param formObj
 */
function removeAll(formObj) {
	// Initialzation B/L, charge grid.
	sheetObjects[0].RemoveAll();
}

/**
 * Search finish.
 * 
 * @param sheetObj
 * @param errorMsg
 */
function sheet1_OnSearchEnd(sheetObj, errorMsg) {
}

/**
 * On change in grid.
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObj = document.form;
	var colSaveName = sheetObj.ColSaveName(col);

	switch (colSaveName) {
	default :
		break;
	}
}

/**
 * On click in grid.
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnClick(sheetObj, row, col ,value) {
	var rowCnt = sheetObj.RowCount;
	var colSaveName = sheetObj.ColSaveName(col);

	switch (colSaveName) {
	default :
		break;
	}
}

/**
 * After popup
 * 
 * @param rowArray
 * @param row
 * @param col
 */
function getFNS_INV_0086_1(rowArray, row, col) {    	 
	var colArray = rowArray[0];
	document.form.cust_cnt_cd.value = colArray[8];
	document.form.cust_seq.value = ComLpad(colArray[9], 6, "0");
	fn_cust_nm();
}
