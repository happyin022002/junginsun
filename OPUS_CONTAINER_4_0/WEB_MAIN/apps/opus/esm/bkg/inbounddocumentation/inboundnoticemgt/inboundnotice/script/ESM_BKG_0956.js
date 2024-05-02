/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0243.js
 *@FileTitle : Hold Remark Setup Popup
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * business script for esm_bkg_0243
 */
function esm_bkg_0956() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.obj_keypress = obj_keypress;
}


// global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	// try {
	var srcName = window.event.srcElement.getAttribute("name");

	switch (srcName) {

	case "btn_Retrieve":
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		break;

	case "btn_new":
		sheetObject.RemoveAll();
		break;

	case "btn_down_excel":
		sheetObjects[0].Down2Excel(true, false, true);
		break;

	case "btn_upload_excel":
		sheetObjects[0].LoadExcel(-1, 1, "", -1, -1, "", false);
		break;

	case "btn_save":
		doActionIBSheet(sheetObjects[0], document.form, IBSAVE);

		break;

	case "btn_close":
		if (sheetObjects[0].IsDataModified) {
			if (confirm(ComGetMsg("BKG40068"))) {
				window.close();
			}
		} else {
			window.close();
		}
		break;

	} // end switch
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

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

	var formObj = document.form;
	// alert(sheetObjects.length);

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 * @param sheetObj sheet Object
 * @param sheetNo 
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {

			// setting Height
			style.height = 260;
			// setting Weight
			SheetWidth = mainTable.clientWidth;

			// setting Host Info [Mandatory][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// setting Merge type [Optional, Default msNone]
			MergeSheet = msPrevColumnMerge;

			// setting Edit Type [Optional, Default false]
			Editable = true;

			// setting Row Info [Mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			// setting Column Info [Mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(6, 0, 0, true);

			// setting HEADER MODE.
			InitHeadMode(false, true, false, true, false, false)

			var HeadTitle1 = "ibflag|Seq.|CNTR No.|H|Hold Reason";

			// setting HEADER Info. [Mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			var prefix = "sheet1_";
			// data attribute [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false,
					prefix + "ibflag");
			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, false, prefix
					+ "Seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, prefix
					+ "cntr_no", false, "", dfNone, 0, false, false, 14);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, false, prefix
					+ "hld_flg", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, prefix
					+ "hld_rsn", false, "", dfEngUpKey, 0, true, true, 4000);
			InitDataProperty(0, cnt++, dtHidden, 70, daCenter, false, prefix
					+ "bkg_no", false, "", dfEngUpKey, 0, true, true, 1);

			WaitImageVisible = false;

		}
		break;

	}
}

/**
 * Sheet process handling
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {

	switch (sAction) {

	case IBSEARCH: //Retrieve
		if (sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH01;

			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0956GS.do", FormQueryString(formObj)
					+ "&" + "bkg_no=" + strBkgNo + "&"
					+ ComGetPrefixParam("sheet1_"));
		}
		break;

	case IBSAVE: //저장
		formObj.f_cmd.value = MULTI01;

		var sParam = FormQueryString(formObj);

		sparam = sParam + "&" + ComGetPrefixParam("sheet1_");

		if (!sheetObj.IsDataModified) {
			ComShowCodeMessage('BKG00743');
			return false;
		}

		for ( var i = 1; i <= sheetObj.RowCount; i++) {

			if (sheetObj.CellValue(i, "sheet1_" + "hld_flg") == "0"
					&& sheetObj.CellValue(i, "sheet1_" + "hld_rsn") != "") {
				ComShowCodeMessage("BKG40048");
				return;
			}

			if (sheetObj.CellValue(i, "sheet1_" + "hld_flg") == "1"
					&& sheetObj.CellValue(i, "sheet1_" + "hld_rsn") == "") {
				ComShowCodeMessage("BKG40049");
				return;

			}

		}

		sheetObj.DoSave("ESM_BKG_0956GS.do", sparam);
		break;

	case IBINSERT: // Input
		break;
	}
}

/**
 * handling process for input validation
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}

	return true;
}

/**
 * init control
 */
function initControl() {
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * handling process after ending sheet1 retrieve
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);

}

/**
 * handling process after ending sheet1 save
 * @param sheetObj
 * @param errMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg == "") {
		self.close();
	}
}

/**
 * Sheet1 click event handling
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var prefix = "sheet1_";
	// alert(colName);
	if (colName == prefix + "hld_rsn") {
		sheetObj.CellEditable(Row, Col) = false;
		ComShowMemoPad(sheetObj, Row, Col, false, 200, 100, 200);
		sheetObj.CellEditable(Row, Col) = true;
	}
}

