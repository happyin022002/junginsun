/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0533.js
 *@FileTitle : Inbond Arrival Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
		   MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
		   Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview
 * @author
 */
/**
 * @extends
 * @class ESM_BKG-0533 : ESM_BKG-0533 - task script definition for screen
 */
// public variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var tabMove=0;
var sheetObjects=new Array();
var sheetCnt=0;
// public variables
var intervalId="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			/*** (Tab) Container (S) ***/
			case "btn_t1SetArrivalDate":
				setArrDt(sheetObject1, document.form, "arr", "t1sheet1_", 0);
			break;
			case "btn_t1SetExportDate":
				setArrDt(sheetObject1, document.form, "xpt", "t1sheet1_", 0);
			break;
			/*** (Tab) Container (E) ***/
			/*** (Tab) B/L (S) ***/
			case "btn_t2SetArrivalDate":
				setArrDt(sheetObject2, document.form, "arr", "t2sheet1_", 1);
			break;
			case "btn_t2SetExportDate":
				setArrDt(sheetObject2, document.form, "xpt", "t2sheet1_", 1);
			break;
			/*** (Tab) B/L (E) ***/
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;
			case "btn_Save":
				doActionIBSheet(sheetObject1, document.form, IBSAVE);
			break;
			case "btn_TransAN":
				doActionIBSheet(sheetObject1, document.form, MULTI01);
			break;
			case "btn_TransExp":
				doActionIBSheet(sheetObject1, document.form, MULTI02);
			break;
			case "btn_SelectAll":
				sheetObjects[tab1.GetSelectedIndex()].CheckAll("t"+(tab1.GetSelectedIndex()+1)+"sheet1_chk", 1, 1);
			break;
			case "btn_DeselectAll":
				sheetObjects[tab1.GetSelectedIndex()].CheckAll("t"+(tab1.GetSelectedIndex()+1)+"sheet1_chk", 0, 1);
			break;
			case "btn_DownExcel":
				ComOpenWait(true);
				if (sheetObjects[tab1.GetSelectedIndex()].RowCount() < 1) {//no data
					ComShowCodeMessage("COM132501");
				} else {
					sheetObjects[tab1.GetSelectedIndex()].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[tab1.GetSelectedIndex()]), SheetDesign:1, Merge:1 });
				}
				ComOpenWait(false);
			break;
			case "arr_gubun":
				if (event.srcElement.checked) {
					form.eq_ofc.className = "input";
					form.eq_ofc.readOnly = false;
					form.fromd.className = "input1";
					form.fromd.readOnly = false;
					form.fromd.setAttribute("required", "");
					form.fromt.className = "input1";
					form.fromt.readOnly = false;
					form.fromt.setAttribute("required", "");
					form.tod.className = "input1";
					form.tod.readOnly = false;
					form.tod.setAttribute("required", "");
					form.tot.className = "input1";
					form.tot.readOnly = false;
					form.tot.setAttribute("required", "");
				} else {
					form.eq_ofc.className = "input2";
					form.eq_ofc.readOnly = true;
					form.eq_ofc.value = "";
					form.fromd.removeAttribute("required");
					form.fromd.className = "input2";
					form.fromd.readOnly = true;
					form.fromd.value = "";
					form.fromt.removeAttribute("required");
					form.fromt.className = "input2";
					form.fromt.readOnly = true;
					form.fromt.value = "00:00";
					form.tod.removeAttribute("required");
					form.tod.className = "input2";
					form.tod.readOnly = true;
					form.tod.value = "";
					form.tot.removeAttribute("required");
					form.tot.className = "input2";
					form.tot.readOnly = true;
					form.tot.value = "23:59";
				}
			break;
			case "btn_calendar":
				if (formObject.fromd.disabled) return;
				var cal=new ComCalendarFromTo();
				cal.select(formObject.fromd, formObject.tod, 'yyyy-MM-dd');
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * initializing sheet implementing onLoad event handler in body tag
 */
function loadPage() {
	for (i=0; i<sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for (k=0; k<tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	initControl();
}


/**
 * load HTML Control event on the page <br>
 * {@link #loadPage}call the function and init IBSheet Object <br>
 *
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects
 */
function initControl() {
	axon_event.addListener("keydown", "ComKeyEnter", "form");
}

/**
 * setting sheet initial values and header
 *
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetObj.id) {
		case "t1sheet1":
			with(sheetObj) {

			var HeadTitle="|Sel.|Seq.|Container No.|B/L No.|POD|Hub|DEL|Customs|L.USA|P/MIB No.|Type|Arrival Date|Arrival Date|A|Arrival Accept Date|Arrival Accept Date" +
						  "|Export Date|Export Date|E|Export Accept Date|Export Accept Date|Available Date|Yard|ST|VVD|F|O|C|P/MIB Issue Date|P/MIB Accept Date||||||";
			var headCount=ComCountHeadTitle(HeadTitle);
			var prefix="t1sheet1_";

			SetConfig( { SearchMode:2, FrozenCol:11, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [{Type:"Status",   Hidden:1, Width:130,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						{Type:"CheckBox", Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chk" },
						{Type:"Seq",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
						{Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         Edit:0 },
						{Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",           Edit:0 },
						{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",          Edit:0 },
						{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hub_loc_cd",      Edit:0 },
						{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",          Edit:0 },
						{Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_loc_cd",    Edit:0 },
						{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"usa_lst_loc_cd",  Edit:0 },
						{Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_trsp_no",     Edit:0 },
						{Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_tp_cd",       Edit:0 },
						{Type:"Date",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_dt",          Format:"Ymd" },
						{Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_time",        Format:"Hm" },
						{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_flg" },
						{Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"trsp_auth_dt" },
						{Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"trsp_auth_time",  Edit:0 },
						{Type:"Date",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_dt",          Format:"Ymd" },
						{Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_time",        Format:"Hm" },
						{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_flg",         Edit:0 },
						{Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_acpt_dt",     Edit:0 },
						{Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_acpt_time",   Edit:0 },
						{Type:"Text",     Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix+"aval_dt",         Edit:0 },
						{Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",           Edit:0 },
						{Type:"Text",     Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cnmv_sts_cd",     Edit:0 },
						{Type:"Text",     Hidden:1,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",             Edit:0 },
						{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_flg",     Edit:0 },
						{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg",    Edit:0 },
						{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_cd",    Edit:0 },
						{Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"trsp_iss_dt",     Edit:0 },
						{Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mjr_ibd_auth_dt", Edit:0 },
						{Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_cntr_flag",    Edit:0 },
						{Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"usdate",          Edit:0 },
						{Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_dt_before",   Edit:0 },
						{Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_dt_before",   Edit:0 },
						{Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"partial_cntr_no", Edit:0 },
						{Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_pod_cd",    Edit:0 } ];
			InitColumns(cols);

			SetEditable(1);
			SetWaitImageVisible(0);
			FrozenCols=11;
			SetSheetHeight(360);
		}
		break;

	case "t2sheet1":
		with(sheetObj) {
			var HeadTitle="|Sel.|Seq.|B/L No.|VVD|POD|Hub|DEL|Customs|L.USA|P/MIB No|Type|Arrival Date|Arrival Date|A|Arrival Accept Date|Arrival Accept Date" +
			"|Export Date|Export Date|E|Export Accept Date|Export Accept Date|F|O|C|P/MIB Issue Date|P/MIB Accept Date|||||";
			var headCount=ComCountHeadTitle(HeadTitle);
			//(headCount, 0, 0, true);
			var prefix="t2sheet1_";

			SetConfig( { SearchMode:2, FrozenCol:11, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [{Type:"Status",    Hidden:1,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						{Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chk" },
						{Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq" },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",             Edit:0 },
						{Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",               Edit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",            Edit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hub_loc_cd",        Edit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",            Edit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_loc_cd",      Edit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"usa_lst_loc_cd",    Edit:0 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_trsp_no",       Edit:0 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_tp_cd",         Edit:0 },
						{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_dt",            Format:"Ymd" },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_time",          Format:"Hm" },
						{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_flg",           Edit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"trsp_auth_dt",      Edit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"trsp_auth_time",    Edit:0 },
						{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_dt",            Format:"Ymd" },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_time",          Format:"Hm" },
						{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_flg",           Edit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_acpt_dt",       Edit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_acpt_time",     Edit:0 },
						{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_flg",       Edit:0 },
						{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg",      Edit:0 },
						{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_cd",      Edit:0 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_trsp_iss_dt",   Edit:0 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mjr_ibd_auth_dt",   Edit:0 },
						{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_cntr_flag",      Edit:0 },
						{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"usdate",            Edit:0 },
						{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_dt_before",     Edit:0 },
						{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xpt_dt_before",     Edit:0 },
						{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_pod_cd",      Edit:0 } ];
			InitColumns(cols);

			SetEditable(1);
			SetWaitImageVisible(0);
			FrozenCols=11;
			SetSheetHeight(360);
		}
		break;
	}
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var selTab=tab1.GetSelectedIndex();
	if (selTab == 0) {
		formObj.bl_cntr_gubun.value="Cntr";
	} else {
		formObj.bl_cntr_gubun.value="BL";
	}
	var prefix="t"+(selTab+1)+"sheet1_";
	switch (sAction) {
		case IBSEARCH: // retrieve
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0533GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefix));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) {
				sheetObjects[selTab].LoadSearchData(arrXml[0],{Sync:1} );
			}
			if (arrXml.length > 1) {
				sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			}
			ComOpenWait(false);
		break;
		case IBSAVE: // Save
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var sParam=ComGetSaveString(sheetObjects[selTab]) + "&f_cmd=" + MULTI+ "&" + ComGetPrefixParam(prefix);
			var sXml=sheetObjects[selTab].GetSaveData("ESM_BKG_0533GS.do", sParam);
			ComOpenWait(false);
			for ( var i=1; i < sheetObjects[selTab].RowCount()+ 1; i++) {
				//if (sheetObjects[selTab].CellValue(i, prefix + "ibflag") != "R") {
				if (sheetObjects[selTab].GetRowStatus(i) != "R") {
					sheetObjects[selTab].SetCellValue(i, prefix + "arr_dt_before",sheetObjects[selTab].GetCellValue(i, prefix + "arr_dt") + sheetObjects[selTab].GetCellValue(i, prefix + "arr_time"),0);
					sheetObjects[selTab].SetCellValue(i, prefix + "xpt_dt_before",sheetObjects[selTab].GetCellValue(i, prefix + "xpt_dt") + sheetObjects[selTab].GetCellValue(i, prefix + "xpt_time"),0);
				}
			}
			if (sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0) {
				ComShowCodeMessage('BKG06022');
				doActionIBSheet(sheetObjects[selTab], document.form, IBSEARCH);
			} else {
				ComShowCodeMessage('BKG00099');
			}
		break;
		case MULTI01: // Arr Trans
			if (!validateForm(sheetObjects[selTab], formObj, sAction)) return;
			formObj.f_cmd.value=MULTI01;
			var sParam=ComGetSaveString(sheetObjects[selTab]) + "&f_cmd=" + MULTI01 + "&" + ComGetPrefixParam(prefix);
			sheetObjects[selTab].SetWaitImageVisible(0);
			ComOpenWait(true,true);
			var sXml=sheetObjects[selTab].GetSaveData("ESM_BKG_0533GS.do", sParam);
			var key=ComGetEtcData(sXml, "KEY");
			intervalId=setInterval("doActionValidationResult(sheetObjects["+selTab+"], '" + key + "');", 3000);
		break;
		case MULTI02: // Exp Trans
			if (!validateForm(sheetObjects[selTab], formObj, sAction)) return;
			formObj.f_cmd.value=MULTI02;
			var sParam=ComGetSaveString(sheetObjects[selTab]) + "&f_cmd=" + MULTI02+ "&" + ComGetPrefixParam(prefix);
			sheetObjects[selTab].SetWaitImageVisible(0);
			ComOpenWait(true,true);
			var sXml=sheetObjects[selTab].GetSaveData("ESM_BKG_0533GS.do", sParam);
			var key=ComGetEtcData(sXml, "KEY");
			intervalId=setInterval("doActionValidationResult(sheetObjects["+selTab+"], '" + key + "');", 3000);
		break;
	}
	// Partial Container Background Color modifying
	if (selTab == 0) { // Container TAB
		var cntrSheet=sheetObjects[selTab];
		var cntrSheetMaxSize=cntrSheet.RowCount();
		var partialCntrNo="";
		for(var i=1; i<=cntrSheetMaxSize; i++) {
			partialCntrNo=cntrSheet.GetCellValue(i, "t1sheet1_partial_cntr_no");
			if (partialCntrNo != "") cntrSheet.SetRowBackColor(i,"#FFFFC0");
		} // end for(i)
	}
}

/**
* BackEndJob result retrieve.
*/
function doActionValidationResult(sheetObj, sKey) {
	var sXml=sheetObj.GetSearchData("ESM_BKG_0533GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	// If an error occurred, exit
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowCodeMessage("BKG00101");
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		return;
	} else if (sJbStsFlg == "FAIL") {
		// error
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowMessage(ComResultMessage(sXml));
	}
}

/**
 * registering IBTab Object as list adding process for list in case of needing batch processing with other items
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}

/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
		with (tabObj) {
			var cnt=0 ;
			InsertItem( "Container" , "");
			InsertItem( "B/L" , "");
		}
		break;
	}
}

/**
 * Event when clicking Tab activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	//--------------- important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab=nItem;
	if (nItem == 1) {
		ComBtnDisable("btn_TransAN");
	} else {
		ComBtnEnable("btn_TransAN");
	}
	if (tabMove > 0) {
		doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);
	}
	tabMove++;
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	var selTab=tab1.GetSelectedIndex();
	var prefix="t"+(selTab+1)+"sheet1_";
	switch (sAction) {
		case IBSEARCH: // retrieve
			if (!ComChkValid(formObj)) return false;
			if (formObj.arr_gubun.checked) {
				if (formObj.vvd.value == "" && formObj.eq_ofc.value == "") {
					ComShowCodeMessage("BKG06113", "Arrival Date + VVD", "Arrival Date + EQ Office");
					ComSetFocus(formObj.vvd);
					return false;
				}
				// from - to  : Within 10 days
				if (ComGetDaysBetween(formObj.fromd.value, formObj.tod.value) > 10) {
					ComShowCodeMessage("BKG50472");
					ComSetFocus(formObj.fromd);
					return false;
				}
			} else {
				if (formObj.vvd.value == "" && formObj.pod.value == "" && formObj.cntr_no.value == "" && formObj.bl_no.value == "") {
					ComShowCodeMessage("BKG06113", "VVD + POD", "Container No.] or [B/L No.");
					formObj.vvd.focus();
					return false;
				} else if (formObj.vvd.value != "" && formObj.pod.value == "") {
					ComShowCodeMessage("BKG40115");    // "VVD and POD is mandatory item"
					formObj.pod.focus();
					return false;
				} else if (formObj.vvd.value == "" && formObj.pod.value != "") {
					ComShowCodeMessage("BKG40115");    // "VVD and POD is mandatory item"
					formObj.vvd.focus();
					return false;
				}
			}
			if (formObj.ibd_tp_cd.value.indexOf("1") > -1) {
				if (formObj.hub.value == "") {
					ComShowMessage("Is 61 is included, hub is necessary.");
					formObj.hub.focus();
					return false;
				}
			}
			return true;
		break;
		case IBSAVE: // Save
			if (selTab == 0)	{
				return partialGroupDateCheck();
			}
			return true;
		break;
		case MULTI01: // Transmit Arrival
			var type="";
			var chked=0;
			for(var i=1; i < sheetObj.RowCount()+1; i++) {
				if (sheetObj.GetCellValue(i, prefix+"chk") == 1) {
					type=sheetObj.GetCellValue(i, prefix+"ibd_tp_cd");
					if (type == "63") {
						ComShowCodeMessage('BKG06072');
						return false;
					}
					if (sheetObj.GetCellValue(i, prefix+"arr_dt") == "") {
						ComShowCodeMessage('BKG06073');
						return false;
					}
	//				if (sheetObj.CellValue(i, prefix+"arr_flg") == "Y") {
	//					ComShowCodeMessage('BKG06074');
	//					return false;
	//				}
					if (sheetObj.GetCellValue(i, prefix + "arr_dt").replace("-", "").replace("-", "") + "" + sheetObj.GetCellValue(i, prefix + "arr_time").replace(":", "") != sheetObj.GetCellValue(i, prefix + "arr_dt_before").replace("-", "").replace("-", "").replace(":", "")) {
						ComShowCodeMessage('BKG06075');
						return false;
					}
					chked++;
				}
			}
			if (chked == 0) {
				//BKG00249, No Selected Row
				ComShowCodeMessage('BKG00249');
				return false;
			}
			return true;
		break;
		case MULTI02: // Transmit Export
			var type="";
			var chked=0;
			for(var i=1; i < sheetObj.RowCount()+1; i++) {
				if (sheetObj.GetCellValue(i, prefix+"chk") == 1) {
					type=sheetObj.GetCellValue(i, prefix+"ibd_tp_cd");
					if (type == "61") {
						ComShowCodeMessage('BKG06076');
						return false;
					}
	//				if (sheetObj.CellValue(i, prefix+"xpt_flg") == "Y") {
	//					ComShowCodeMessage('BKG06077');
	//					return false;
	//				}
					if (sheetObj.GetCellValue(i, prefix+"xpt_dt") == "") {
						ComShowCodeMessage('BKG06078');
						return false;
					}
					if (sheetObj.GetCellValue(i, prefix+"xpt_dt").replace("-", "").replace("-", "")+""+ sheetObj.GetCellValue(i, prefix+"xpt_time").replace(":","") != sheetObj.GetCellValue(i, prefix+"xpt_dt_before").replace("-", "").replace("-", "").replace(":","")) {
						ComShowCodeMessage('BKG06079');
						return false;
					}
					chked++;
				}
			}
			if (chked == 0) {
				//BKG00249, No Selected Row
				ComShowCodeMessage('BKG00249');
				return false;
			}
			return true;
		break;
	}
	return true;
}

/**
 * Export Date Arrival Date or CNTR failed attempts to find the same logic when saving(Partial CNTR )<br>
 * CNTR is the same if a different date, enter the show alert msg pop-up messages.<br>
 *
 * @return
 */
function partialGroupDateCheck() {
	var currPartialCntrNo="";
	var prePartialCntrNo="";
	var currCntrNo="";
	var preCntrNo="";
	var sheetObj=sheetObjects[0]
	var sheetRowCnt=sheetObj.RowCount();
	var disArrDtCntrNoList="";
	var disExpDtCntrNoList="";
	var currArrDate="";
	var preArrDate="";
	var currExpDate="";
	var preExpDate="";
	var subPartialCntrNo="";
	for(var i=1; i <= sheetRowCnt; i++) {
		if (sheetObj.GetRowStatus(i) != 'U') continue;
		currPartialCntrNo=sheetObj.GetCellValue(i, "t1sheet1_partial_cntr_no");
		if (currPartialCntrNo == "" || currPartialCntrNo == prePartialCntrNo) continue;
		preArrDate="";
		preExpDate="";
		for(var j=i; j<=sheetRowCnt; j++) {
			currArrDate=sheetObj.GetCellValue(j, "t1sheet1_arr_dt") + sheetObj.GetCellValue(j, "t1sheet1_arr_time");
			currExpDate=sheetObj.GetCellValue(j, "t1sheet1_xpt_dt") + sheetObj.GetCellValue(j, "t1sheet1_xpt_time");
			subPartialCntrNo=sheetObj.GetCellValue(j, "t1sheet1_partial_cntr_no");
			if (j == i) {
				preArrDate=currArrDate;
				preExpDate=currExpDate;
			}
			if (currPartialCntrNo != subPartialCntrNo) break;
			if (currArrDate != preArrDate) {
				disArrDtCntrNoList += subPartialCntrNo + ", ";
			}
			if (currExpDate != preExpDate) {
				disExpDtCntrNoList += subPartialCntrNo + ", ";
			}
			preArrDate=currArrDate;
			currExpDate=preExpDate;
		} // end for(j)
		preArrDate="";
		preExpDate="";
		for(var j=i; j>=1; j--) {
			currArrDate=sheetObj.GetCellValue(j, "t1sheet1_arr_dt") + sheetObj.GetCellValue(j, "t1sheet1_arr_time");
			currExpDate=sheetObj.GetCellValue(j, "t1sheet1_xpt_dt") + sheetObj.GetCellValue(j, "t1sheet1_xpt_time");
			subPartialCntrNo=sheetObj.GetCellValue(j, "t1sheet1_partial_cntr_no");
			if (j == i) {
				preArrDate=currArrDate;
				preExpDate=currExpDate;
			}
			if (currPartialCntrNo != subPartialCntrNo) break;
			if (currArrDate != preArrDate) {
				disArrDtCntrNoList += subPartialCntrNo + ", ";
			}
			if (currExpDate != preExpDate) {
				disExpDtCntrNoList += subPartialCntrNo + ", ";
			}
			preArrDate=currArrDate;
			currExpDate=preExpDate;
		} // end for(j)
		prePartialCntrNo=currPartialCntrNo;
	} // end for(i)
	if (disArrDtCntrNoList != "") {
		disArrDtCntrNoList=disArrDtCntrNoList.substring(0, disArrDtCntrNoList.lastIndexOf(","));
	}
	if (disExpDtCntrNoList != "") {
		disExpDtCntrNoList=disExpDtCntrNoList.substring(0, disExpDtCntrNoList.lastIndexOf(","));
	}
	if (disArrDtCntrNoList != "" && disExpDtCntrNoList != "") {
		ComShowMessage(ComGetMsg("BKG06112", "Arrival", disArrDtCntrNoList) + "\n" + ComGetMsg("BKG06112", "Export ", disExpDtCntrNoList));
		return false;
	} else if (disArrDtCntrNoList != "" && disExpDtCntrNoList == "") {
		ComShowCodeMessage("BKG06112", "Arrival", disArrDtCntrNoList);
		return false;
	} else if (disArrDtCntrNoList == "" && disExpDtCntrNoList != "") {
		ComShowCodeMessage("BKG06112", "Export", disExpDtCntrNoList);
		return false;
	}
	return true;
}

function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (sheetObj.RowCount()> 0) {
		var usdate=sheetObj.GetCellValue(1, "t1sheet1_usdate");
		var d=usdate.substring(0, 10);
		var t=usdate.substring(11);
		document.form.set_arr_d[0].value=d;
		document.form.set_arr_t[0].value=t;
	}
}

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (sheetObj.RowCount()> 0) {
		var usdate=sheetObj.GetCellValue(1, "t2sheet1_usdate");
		var d=usdate.substring(0, 10);
		var t=usdate.substring(11);
		document.form.set_arr_d[1].value=d;
		document.form.set_arr_t[1].value=t;
	}
}

function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

function setArrDt(sObj, fObj, field_id, prefix, idx) {
	try{
		if (sObj.CheckedRows(prefix+"chk") == 0) {
			//BKG00249, No Selected Row
			ComShowCodeMessage('BKG00249');
			return;
		}
		var dt = chkDateTimeValid(fObj.set_arr_d[idx], "ymd");
		if (dt == "false") {
			ComSetFocus(fObj.set_arr_d[idx]);
			return;
		}
		var hm = chkDateTimeValid(fObj.set_arr_t[idx], "hm");
		if (hm == "false") {
			ComSetFocus(fObj.set_arr_t[idx]);
			return;
		}

		// 날짜만이 아닌, 시간까지의 24시간 Gap을 계산
		var inputDate = fObj.set_arr_d[idx].value + " " + fObj.set_arr_t[idx].value;
		var usDate = sObj.GetCellValue(1, prefix+"usdate");
		// 1Day = 24시간 = 86400000밀리초 (1000 * 60 * 60 * 24)
		if (new Date(inputDate).getTime() - new Date(usDate).getTime() > 0) {
			if (field_id == "arr")
				ComShowCodeMessage("BKG06160", "Arrival date");    // "Arrival date should not be later than \ncurrent time in EST"
			else
				ComShowCodeMessage("BKG06160", "Export date");    // "Export date should not be later than \ncurrent time in EST"
			ComSetFocus(fObj.set_arr_t[idx]);
			return;
		}

		for (var i=1; i < sObj.RowCount()+1; i ++) {
			if (sObj.GetCellValue(i, prefix+"chk") == 1) {
				sObj.SetCellValue(i, prefix+field_id+"_dt", dt, 0);
				sObj.SetCellValue(i, prefix+field_id+"_time", hm, 0);
				if (!dateTimeChangeValidate(sObj, i, sObj.SaveNameCol(prefix+field_id+"_dt"), dt, prefix)) return;

				if (sObj.GetCellValue(i,prefix+field_id+"_dt")==""  ) { //시간이 null로 set 되지 않는 점을 해결하기 위한 부분
					sObj.SetCellValue(i, prefix+field_id+"_time","");
				}
				if (idx == 0) { // In case of  Container
					var currPartialCntrNo=sObj.GetCellValue(i, prefix+"partial_cntr_no");
					if (currPartialCntrNo == "") continue;
					var subPartialCntrNo="";
					var subDate="";
					// search
					for(var j=i; j<=sObj.RowCount(); j++) {
						subPartialCntrNo=sObj.GetCellValue(j, prefix+"partial_cntr_no");
						if (subPartialCntrNo == "") continue;
						if (currPartialCntrNo == subPartialCntrNo) {
							subDate=sObj.GetCellValue(j, prefix+field_id+"_dt") + sObj.GetCellValue(j, prefix+field_id+"_time");
							if (subDate == "") {
								sObj.SetCellValue(j, prefix+field_id+"_dt",dt,0);
								sObj.SetCellValue(j, prefix+field_id+"_time",hm,0);
							}
						} else {
							break;
						}
					} // end for(j)
					// search
					for(var j=i; j >= 1; j--) {
						subPartialCntrNo=sObj.GetCellValue(j, prefix+"partial_cntr_no");
						if (subPartialCntrNo == "") continue;
						if (currPartialCntrNo == subPartialCntrNo) {
							subDate=sObj.GetCellValue(j, prefix+field_id+"_dt") + sObj.GetCellValue(j, prefix+field_id+"_time");
							if (subDate == "") {
								sObj.SetCellValue(j, prefix+field_id+"_dt",dt,0);
								sObj.SetCellValue(j, prefix+field_id+"_time",hm,0);
							}
						} else {
							break;
						}
					} // end for(j)
				}
			}
		}

	} catch(e) {
		ComShowMessage(e.message);
	}
}

function chkDateTimeValid(obj, gubun) {
	var rtn="";
	if (gubun == "ymd") {
		var tmp=obj.value.replace('-', '').replace('-', '').replace('/', '').replace('/', '');
		if (tmp.length < 8) {
			//BKG00920, Please enter a valid date format: YYYYMMDD
			ComShowCodeMessage('BKG00921');
			obj.focus();
			return "false";
		}
		var year=parseInt(tmp.substring(0, 4));
		var mon=parseInt(eval(tmp.substring(4, 6))) - 1;
		var days=parseInt(eval(tmp.substring(6, 8)));
		d=new Date(year, mon, days);
		var yearD=d.getFullYear();
		var monD=d.getMonth();
		var daysD=d.getDate();
		if (year != yearD || mon != monD || days != daysD) {
			//BKG00714, Please Check Date
			ComShowCodeMessage('BKG00714');
			obj.focus();
			return "false";
		}
		var arrDtM="";
		if (monD+1 < 10) arrDtM="0"+(monD+1);
		else arrDtM=""+(monD+1);
		var arrDtD="";
		if (daysD < 10) arrDtD="0"+daysD;
		else arrDtD=""+daysD;
		rtn=yearD+"-"+arrDtM+"-"+arrDtD;
	} else if (gubun == "hm") {
		var tmp=obj.value.replace(':', '');
		if (tmp.length < 4) {
			//BKG00714, Please Check Date
			ComShowCodeMessage('BKG00714');
			obj.focus();
			return "false";
		}
		var hh=parseInt(eval(tmp.substring(0, 2)));
		if ( ! (0 <= hh && hh <= 23)) {
			//BKG00714, Please Check Date
			ComShowCodeMessage('BKG00714');
			obj.focus();
			return "false";
		}
		var mi=parseInt(eval(tmp.substring(2, 4)));
		if ( ! (0 <= mi && mi <= 59)) {
			//BKG00714, Please Check Date
			ComShowCodeMessage('BKG00714');
			obj.focus();
			return "false";
		}
		var arrDtH="";
		if (hh < 10) arrDtH="0"+hh;
		else arrDtH=""+hh;
		var arrDtMi="";
		if (mi < 10) arrDtMi="0"+mi;
		else arrDtMi=""+mi;
		rtn=arrDtH+":"+arrDtMi;
	}
	return rtn;
}

function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (Value != "")
		dateTimeChangeValidate(sheetObj, Row, Col, Value, "t1sheet1_");
}

function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (Value != "")
		dateTimeChangeValidate(sheetObj, Row, Col, Value, "t2sheet1_");
}

function dateTimeChangeValidate(sheetObj, Row, Col, Value, prefix) {
	with (sheetObj) {

		var usdate = parseInt(GetCellValue(1, prefix+"usdate").replace("-", "").replace("-", "").replace(" ", "").replace(":", ""));

		var arrTime = "";
		if (GetCellValue(Row, prefix+"arr_dt") != "") {
			arrTime = GetCellValue(Row, prefix+"arr_dt");
			if (GetCellValue(Row, prefix+"arr_time") == "") {
				arrTime = parseInt(arrTime + "0000");
			} else {
				arrTime = parseInt(arrTime + GetCellValue(Row, prefix+"arr_time"));
			}
		}
		var xptTime = "";
		if (GetCellValue(Row, prefix+"xpt_dt") != "") {
			xptTime = GetCellValue(Row, prefix+"xpt_dt");
			if (GetCellValue(Row, prefix+"xpt_time") == "") {
				xptTime = parseInt(xptTime + "0000");
			} else {
				xptTime = parseInt(xptTime + GetCellValue(Row, prefix+"xpt_time"));
			}
		}

		switch (ColSaveName(Col)) {
			case prefix+"arr_dt":
			case prefix+"arr_time":
				if (GetCellValue(Row, prefix+"arr_dt") != "" ) {
					if (arrTime > usdate) {
						ComShowCodeMessage("BKG06160", "Arrival date");     // "Arrival date should not be later than \ncurrent time in EST"
						SetCellValue(Row, Col, "");
						SelectCell(Row, Col);
						return false;
					}
					if (GetCellValue(Row, prefix+"xpt_dt") != "") {
						if (arrTime > xptTime) {
							ComShowCodeMessage("BKG06159");     // "Export date should not be earlier than arrival date."
							SetCellValue(Row, Col, "");
							SelectCell(Row, Col);
							return false;
						}
					}
				}
				break;
			case prefix+"xpt_dt":
			case prefix+"xpt_time":
				if (GetCellValue(Row, prefix+"xpt_dt") != "" ) {
					if (xptTime > usdate) {
						ComShowCodeMessage("BKG06160", "Export date");     // "Export date should not be later than \ncurrent time in EST"
						SetCellValue(Row, Col, "");
						SelectCell(Row, Col);
						return false;
					}
					if (GetCellValue(Row, prefix+"arr_dt") != "") {
						if (arrTime > xptTime) {
							ComShowCodeMessage("BKG06159");     // "Export date should not be earlier than arrival date."
							SetCellValue(Row, Col, "");
							SelectCell(Row, Col);
							return false;
						}
					}
				}
				break;
		}
	}
	return true;
}
