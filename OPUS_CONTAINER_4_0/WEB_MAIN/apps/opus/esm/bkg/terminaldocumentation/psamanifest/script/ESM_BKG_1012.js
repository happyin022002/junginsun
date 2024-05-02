/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1012.js
*@FileTitle  : PSA Special Cargo Info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
//public variable
var sheetObjects = new Array();
var sheetCnt=0;
var comboObjects = new Array();
var comboCnt=0;
var saveCount = 0;

//Event handler processing by button click event */
document.onclick = processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;

			case "btn_calendar1":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.etb_dt1,formObject.etb_dt2, "yyyy-MM-dd");
			break;

			case "btn_Save":
				if (!ComShowCodeConfirm("BKG95003", "save")) return;
				formObject.type_cd.value="I";
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;

			case "btn_Delete":
				if (!ComShowCodeConfirm("BKG95003", "delete")) return;
				formObject.type_cd.value="D";
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;

			case "btn_Close":
				if (saveCount > 0) {
					// 저장이 한번이라도 되었으면 부모창 재조회
					var opener = window.dialogArguments;
					if (!opener) opener = parent;
					opener.doActionIBSheet(opener.sheetObjects[0], opener.document.form, IBSEARCH);
				}
				ComClosePopup();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
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
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}


/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}


/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}

	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}


/**
 * Combo Object initialization
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.options.id) {
		case "ld_ins":
			with(comboObj) {
				SetDropHeight(250);
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "45");
				SetColWidth(1, "200");
			}
		break;
	}
}


/**
 * setting sheet initial values and header
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetObj.id) {
	case "sheet1":
		with (sheetObj) {
			var HeadTitle1="|SEQ";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq"    } ];
			InitColumns(cols);
			SetEditable(1);
			SetVisible(false);

		}
		break;
	}
}


// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBCLEAR:      //combo initialization
			var sXml = sheetObj.GetSearchData("ESM_BKG_1012GS.do", "f_cmd=" + INIT);
			ComXml2ComboItem(sXml, comboObjects[0], "val", "val|name");
			comboObjects[0].InsertItem(0, "|", "");
		break;

		case IBSEARCH:      //retrieve
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchData("ESM_BKG_1012GS.do", FormQueryString(formObj));
			sXml = sXml.replace("\n<DATA  TOTAL='0'>\n</DATA>", ""); // If the xmlString has this one, the data won't bind to sheet object.
			sheetObj.LoadSearchData(sXml, {Sync:1});
		break;

		case IBSAVE:    // Save
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.RemoveAll();
			sheetObj.DataInsert(-1);
			sheetObj.DoSave("ESM_BKG_1012GS.do",  FormQueryString(formObj), -1, false)
			ComOpenWait(false);
		break;
	}
}


/**
 * handling event after searching
 */
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
	ComEtcDataToForm(document.form, sheetObj);
}


/**
 * handling event after saving
 */
function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
	saveCount++;    // 저장여부를 알기위하여 사용됨
	// INSERT or UPDATE process
	if (document.form.type_cd.value == "D") {
		ComResetAll();
	} else {
		// Retrieve after saving
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}
