/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0264.js
 *@FileTitle : Freight & Charge_BKG Q'TY Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------Added code to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
* @author CLT
 */

/**
 * @extends 
 * @class esm_bkg_0264 : business script for esm_bkg_0264
 */
function esm_bkg_0264() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}


// Common global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
// Event handler processing by button click event */
document.onclick = processButtonClick;

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {

	if (document.form.bkg_no.value == '') {
		ComShowCodeMessage("BKG00463"); 
		self.close();
	}
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee- Preferences change the name of the function to start
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee- The final configuration functions added
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {

			// setting height
			style.height = 100;
			//setting width
			SheetWidth = mainTable.clientWidth;

			//setting Host information[mandatory][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//Merge kind[Selection, Default msNone]
			MergeSheet = msHeaderOnly;

			//Edit kind [Selection, Default false]
			Editable = false;

			//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 15, 100);

			//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(14, 0, 0, true);

			// setting function handling header
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = " |TP/SZ|Q'ty|DR|RF|AK|BB|DG|IMO|EQ SUB TP|EQ SUB Q'ty|C'HGR|C'HGR|M'HGR";
			var HeadTitle2 = " |TP/SZ|Q'ty|DR|RF|AK|BB|DG|IMO|EQ SUB TP|EQ SUB Q'ty|S|D|M'HGR";

			//header Information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//Data attributes    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "op_cntr_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "dr_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "rc_qty", false, "", dfNullFloat, 2, true, true);

			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "awk_cgo_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "bb_cgo_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "dcgo_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daRight, true, "imdg_clss_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, true, "eq_subst_cntr_tpsz_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 75, daRight, true, "eq_subst_cgo_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "crr_hngr_sgl_bar_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "crr_hngr_dbl_bar_qty", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 65, daRight, true, "mer_hngr_qty", false, "", dfNullFloat, 2, true, true);

			MultiSelection = false;
			SelectHighLight = true;
		}
		break;

	}
}

// Event handler processing by button name */
function processButtonClick() {
	/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_close":
			window.close();
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

//Sheet handling process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //Retrieve
		ComSetObjValue(formObj.f_cmd, SEARCH);
		sheetObj.DoSearch4Post("ESM_BKG_0264GS.do", '', FormQueryString(formObj), false);

		break;
	}
}
/**
 * calling event after retrieving Sheet
 */
function sheet0_OnSearchEnd(sheetObj, ErrMsg) {

	var formObj = document.form;
	var c_row = sheetObj.LastRow;

	for ( var row = 2; row <= c_row; row++) {
		sheetObj.CellValue(row, "imdg_clss_cd") = ComGetObjValue(formObj.imdg_clss_cd);
		sheetObj.CellValue(row, "eq_subst_cntr_tpsz_cd") = ComGetObjValue(formObj.eq_subst_cntr_tpsz_cd);
		sheetObj.CellValue(row, "eq_subst_cgo_qty") = ComGetObjValue(formObj.eq_subst_cgo_qty);
	}
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//             if (!isNumber(formObj.iPage)) {
		//                 return false;
		//             }
	}

	return true;
}
