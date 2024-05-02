/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0282.js
 *@FileTitle : ESM_BKG-0282
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
 */

// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_trans":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
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
	/*axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);*/
	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
	document.form.vvd_number.focus();
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

	  var HeadTitle="|Sel.|Seq.|VVD|BKG No.|B/L No.|FA|RD|LS|B/POR|V/POL|V/POD|B/DEL|Weight|Weight|Package|Freight|RF|S.Date||";

	  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	  InitHeaders(headers, info);

	  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Chk" },
			 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_number",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mfsnd_code",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnhkg_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bv_pol_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bv_pod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"act_wgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"frt_term_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mf_snd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

	  InitColumns(cols);

	  SetEditable(1);
	  SetSheetHeight(400);
			}



		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //Retrieve
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		initSheet(sheetObjects[0], 0);
		formObj.f_cmd.value=SEARCH;
		formObj.vsl_cd.value=formObj.vvd_number.value.substring(0, 4);
		formObj.skd_voy_no.value=formObj.vvd_number.value.substring(4, 8);
		formObj.skd_dir_cd.value=formObj.vvd_number.value.substring(8);

		var frobs=formObj.pol_flg;

		for (i=0; i < frobs.length; i++) {
			if (frobs[i].checked) {
				if (frobs[i].value == "pol") {
					formObj.pol_cd.value=formObj.pol_code.value;
					formObj.pod_cd.value="";
				} else {
					formObj.pod_cd.value=formObj.pol_code.value;
					formObj.pol_cd.value="";
				}
			}
		}

		//alert(formObj.pol_flg.value);
		sheetObjects[0].RemoveAll();
		sXml=sheetObjects[0].GetSearchData("ESM_BKG_0282GS.do",	FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		}
		ComEtcDataToForm(formObj, sheetObj);
		sheetObj.CheckAll("Chk",1);
		ComOpenWait(false);
		break;
	case IBSAVE: // transmission
		formObj.f_cmd.value=MULTI;
		/*
		 * vIsCheck = 0;
		 *
		 * for(i=1; i<=sheetObjects[0].RowCount; i++) {
		 * if(sheetObj.CellValue(i, "Chk") == 1) vIsCheck++; } if (vIsCheck ==
		 * 0) { ComShowCodeMessage('BKG00249'); return; } var count = 0;
		 */
		for ( var i=1; i <= sheetObjects[0].RowCount(); i++) {
			if (sheetObj.GetCellValue(i, "bv_pol_cd") == "CNHKG") {
				sheetObjects[0].SetCellValue(i, "pol_cd",formObj.pol_code.value,0);
			} else {
				sheetObjects[0].SetCellValue(i, "pod_cd",formObj.pol_code.value,0);
			}
			// Depending on the check box
			if (sheetObj.GetCellValue(i, "Chk") == "1") {
				sheetObjects[0].SetRowStatus(i,"I");
			} else {
				sheetObjects[0].SetRowStatus(i,"R");
			}
		}
		for ( var i=1; i <= sheetObjects[0].RowCount(); i++) {
		}
		if (ComShowCodeConfirm("BKG00217")) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sParam="";
			var sParamSheet2=sheetObjects[0].GetSaveString();
			if (sParamSheet2 != "") {
				sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
			}
			sParam += "&" + FormQueryString(formObj);
			// alert("sParam"+sParam);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0282GS.do", sParam);
			// sheetObj.DoAllSave("ESM_BKG_0723GS.do",
			// FormQueryString(formObj));
			var key=ComGetEtcData(sXml, "KEY");
			ComOpenWait(true);
			intervalId=setInterval(
					"doActionValidationResult(sheetObjects[0], '" + key + "');",
					3000);
		}
		break;
	}
}
/**
 * BackEndJob result retrieve.
 */
function doActionValidationResult(sheetObj, sKey) {
//	sheetObj.SetWaitImageVisble(0);
	var sXml=sheetObj.GetSearchData("ESM_BKG_0282GS.do?f_cmd=" + SEARCH03+ "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	// Error Case.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// Success Msg
		ComShowCodeMessage('BKG00204');
		// ComShowMessage(ComResultMessage(sXml));
		return;
	} else if (sJbStsFlg == "FAIL") {
		//Error
		clearInterval(intervalId);
		ComOpenWait(false);
		// Error Msg
		ComShowMessage(ComResultMessage(sXml));
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (formObj.vvd_number.value == "") {
			ComShowCodeMessage('BKG00213');
			formObj.vvd_number.focus();
			return false;
		}
		if (formObj.pol_code.value == "") {
			ComShowCodeMessage('BKG00214');
			formObj.pol_code.focus();
			return false;
		}
		if (formObj.vvd_number.value.length > 0
				&& formObj.vvd_number.value.length < 9) {
			ComShowCodeMessage('BKG00213');
			formObj.vvd_number.focus();
			return false;
		}
		if (formObj.pol_code.value.length > 0
				&& formObj.pol_code.value.length < 5) {
			ComShowCodeMessage('BKG00214');
			formObj.pol_code.focus();
			return false;
		}
		return true;
		break;
	}
}
/**
 * Radio Button Click Event Handling
 * @param formObj
 * @return
 */
function OnClickRadioButton(formObj) {
	var frobs=formObj.elements("pol_flg");
	for (i=0; i < frobs.length; i++) {
		if (frobs[i].checked) {
			if (frobs[i].value == "pol") {
				formObj.pol_cd.value=formObj.pol_code.value;
				alert(formObj.pol_cd.value);
			} else {
				formObj.pod_cd.value=formObj.pol_code.value;
			}
		}
	}
}
/**
 * OnkeyUp Event Handling
 **/
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * Enter Event Handling
 * @return
 */
function obj_ComKeyEnter() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	if (srcName != "") {
		ComKeyEnter();
	}
}
