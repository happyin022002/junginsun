/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0457.jsp
*@FileTitle  : Manifest Correction(CMF)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// public variable
var sheetObjects = new Array();
var sheetCnt = 0;
var state = "";

// Event handler processing by button click event
document.onclick=processButtonClick;

function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	/** **************************************************** */
	var formObject=document.form;

	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
			break;
		case "btn_reactivate":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND04);
			break;
		case "btn_container":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND05);
			break;
		case "btn_marks":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND06);
			break;
		case "btn_approval":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND08);
			break;
		case "btn_cust1":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
			break;
		case "btn_cust2":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND02);
			break;
		case "btn_cust3":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND03);
			break;
		case "btn_transmit":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND07);
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
	}
	initControl();
	document.form.in_bl_no.focus();
}

// initializing sheet data
function initSheetData(sheetObj, formObj) {
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);
	IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
}

/**
 * loading event of HTML Control<br>
 * initializing IBSheet Object <br>
 * @param sheetObj
 * @param sheetNo
 */
function initControl() {
	DATE_SEPARATOR="-";
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	ComBtnDisable("btn_reactivate");
	ComBtnDisable("btn_transmit");
	ComBtnDisable("btn_save");
	ComBtnDisable("btn_container");
	ComBtnDisable("btn_marks");
	ComBtnDisable("btn_approval");
	ComBtnDisable("btn_cust1");
	ComBtnDisable("btn_cust2");
	ComBtnDisable("btn_cust3");
}

 /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
		case "sheet1": // sheet1 init
			with(sheetObj){
				var HeadTitle = "ibflag|bl_no|bl_split_no|jp_bl_sts_cd|dcgo_flg|locl_ts_flg|jp_edi_trsm_stg_tp_cd|full_mty_cd|vvd_cd|pod_cd|eta_dt|bkg_por_cd|bkg_pol_cd|bkg_del_cd|pst_vvd_cd|pst_rly_pod_cd|pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|cust_cnt_cd|cust_seq|cust_nm|cust_addr|phn_no|fax_no|cust_cnt_cd2|cust_seq2|cust_nm2|cust_addr2|phn_no2|fax_no2|cust_cnt_cd3|cust_seq3|cust_nm3|cust_addr3|phn_no3|fax_no3|pod_split_cd" +
								// Hidden Column
								"|apro_no|pod_bnd|del_bnd|delt_flg";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

				var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status", Hidden:1,  Width:0,     SaveName:"ibflag" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"bl_no" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"bl_split_no" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"jp_bl_sts_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"dcgo_flg" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"locl_ts_flg" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"jp_edi_trsm_stg_tp_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"full_mty_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"vvd_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"pod_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"eta_dt" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"bkg_por_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"bkg_pol_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"bkg_del_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"pst_vvd_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"pst_rly_pod_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"pck_qty" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"pck_tp_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"grs_wgt" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"wgt_ut_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"meas_qty" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"meas_ut_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_cnt_cd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_seq" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_nm" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_addr" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"phn_no" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"fax_no" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_cnt_cd2" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_seq2" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_nm2" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_addr2" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"phn_no2" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"fax_no2" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_cnt_cd3" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_seq3" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_nm3" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"cust_addr3" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"phn_no3" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"fax_no3" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"pod_split_cd" },

							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"apro_no" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"pod_bnd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"del_bnd" },
							{Type:"Text",   Hidden:0,  Width:100,   SaveName:"delt_flg" } ];
				InitColumns(cols);

				SetEditable(1);
				SetSheetHeight(225);
				SetVisible(0);
			}
			break;
	}
}

/**
* handling sheet process <br>
*
* @param sheetObj
* @param formObj
* @param sAction
* @return
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	if (!validateForm(sheetObj, formObj, sAction)) return;

	switch (sAction) {
		case IBSEARCH: // retrieve
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DoSearch("ESM_BKG_0457GS.do", FormQueryString(formObj), {Sync:2} );
		break;

		case IBSAVE: // save
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
			formObj.f_cmd.value=MULTI;
			sheetObj.DoAllSave("ESM_BKG_0457GS.do", {Param:FormQueryString(formObj),Col:"sel",Quest:"false",UrlEncode:"true", Sync:1} );
			state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
			ComOpenWait(false);
		break;

		case COMMAND01: // btn_cust1
			formObj.f_cmd.value=SEARCH01;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.cust_type.value="S";
			var sXml = sheetObj.GetSearchData("ESM_BKG_0457GS.do ", FormQueryString(formObj));
			formObj.form1_cust_nm.value  = ComGetEtcData(sXml, "form1_cust_nm");
			formObj.form1_cust_addr.value  = ComGetEtcData(sXml, "form1_cust_addr");
			if ( formObj.form1_cust_nm.value == "undefined" ) formObj.form1_cust_nm.value = "";
			if ( formObj.form1_cust_addr.value == "undefined" ) formObj.form1_cust_addr.value = "";

			ComOpenWait(false);
		break;

		case COMMAND02: // btn_cust2
			formObj.f_cmd.value=SEARCH02;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.cust_type.value="C";
			var sXml=sheetObj.GetSearchData("ESM_BKG_0457GS.do ", FormQueryString(formObj));
			formObj.form1_cust_nm2.value  = ComGetEtcData(sXml, "form1_cust_nm2");
			formObj.form1_cust_addr2.value  = ComGetEtcData(sXml, "form1_cust_addr2");
			if ( formObj.form1_cust_nm2.value == "undefined" ) formObj.form1_cust_nm2.value = "";
			if ( formObj.form1_cust_addr2.value == "undefined" ) formObj.form1_cust_addr2.value = "";

			ComOpenWait(false);
		break;

		case COMMAND03:
			formObj.f_cmd.value=SEARCH03;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.cust_type.value="N";
			var sXml=sheetObj.GetSearchData("ESM_BKG_0457GS.do ", FormQueryString(formObj));
			formObj.form1_cust_nm3.value  = ComGetEtcData(sXml, "form1_cust_nm3");
			formObj.form1_cust_addr3.value  = ComGetEtcData(sXml, "form1_cust_addr3");
			if ( formObj.form1_cust_nm3.value == "undefined" ) formObj.form1_cust_nm3.value = "";
			if ( formObj.form1_cust_addr3.value == "undefined" ) formObj.form1_cust_addr3.value = "";

			ComOpenWait(false);
		break;

		case COMMAND04:  // btn_reactivate
			formObj.f_cmd.value=MULTI01;
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var SaveStr = sheetObj.GetSaveString(1);
			var sXml = sheetObj.GetSaveData("ESM_BKG_0457GS.do", FormQueryString(formObj)+"&"+SaveStr );
			sheetObj.LoadSaveData(sXml);
			ComOpenWait(false);
			state = sheetObj.GetEtcData("TRANS_RESULT_KEY");
			if (sheetObj.RowCount()== 1) {
				IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
			} else if (sheetObj.RowCount()== 0) {
				initSheetData(sheetObj, formObj);
			}
			if (state == "S") doActionIBSheet(sheetObj, document.form, IBSEARCH);
		break;

		case COMMAND05:
			var sUrl="ESM_BKG_0455.do?pgmNo=ESM_BKG_0455&gubun=CMF&bl_no=" + formObj.in_bl_no.value + formObj.in_bl_split_no.value;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0455", 750, 340, true);
		break;

		case COMMAND06:  // Mark & Desc
			var sUrl="ESM_BKG_0458.do?pgmNo=ESM_BKG_0458&gubun=CMF&bl_no=" + formObj.in_bl_no.value + formObj.in_bl_split_no.value;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0458", 780, 450, true);
		break;

		case COMMAND07: // Transmit
			var sUrl="ESM_BKG_0991.do?pgmNo=ESM_BKG_0991&bl_no="
					+ formObj.in_bl_no.value + formObj.in_bl_split_no.value
					+ "&in_pod_cd=" + formObj.form1_pod_cd.value
					+ "&in_pod_split_cd=" + formObj.form1_pod_split_cd.value
					+ "&in_vvd_cd=" + formObj.form1_vvd_cd.value;
			ComOpenWindowCenter(sUrl, "ESM_BKG_0991", 500, 250, true);
		break;

		case COMMAND08: // Approval No.
			with (sheetObj) {
				var selectedBlNumber = GetCellValue(HeaderRows(), "bl_no");
				var podBnd = GetCellValue(HeaderRows(), "pod_bnd");
				var delBnd = GetCellValue(HeaderRows(), "del_bnd");
				var deltFlg = GetCellValue(HeaderRows(), "delt_flg");
			}
			// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
			ComOpenPopup("ESM_BKG_1510.do?bl_no=" + selectedBlNumber + "&pod_bnd=" + podBnd + "&del_bnd=" + delBnd + "&delt_flg=" + deltFlg, 700, 285, "", "1,0", true);
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	var formObj=document.form;
	if (formObj.f_cmd.value == SEARCH) {
		state = sheetObj.GetEtcData("TRANS_RESULT_KEY");
		if (sheetObj.RowCount() > 0) {
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
			if (formObj.form1_jp_bl_sts_cd.value == "Active") {
				ComBtnDisable("btn_reactivate");
			} else {
				ComBtnEnable("btn_reactivate");
			}
			if (state == "S") {
				ComBtnEnable("btn_transmit");
			} else {
				ComBtnDisable("btn_transmit");
			}
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_container");
			ComBtnEnable("btn_marks");
			ComBtnEnable("btn_approval");
			ComBtnEnable("btn_cust1");
			ComBtnEnable("btn_cust2");
			ComBtnEnable("btn_cust3");
			if (sheetObj.GetEtcData("send_yn") == "Y") ComShowMessage("'DMF' File Already transmitted.");

		} else {
			ComBtnDisable("btn_reactivate");
			ComBtnDisable("btn_transmit");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_container");
			ComBtnDisable("btn_marks");
			ComBtnDisable("btn_approval");
			ComBtnDisable("btn_cust1");
			ComBtnDisable("btn_cust2");
			ComBtnDisable("btn_cust3");
			initSheetData(sheetObj, formObj);
			ComShowCodeMessage("COM130401");    // There is no data to search.
		}
		ComOpenWait(false);
	}
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	if (state == "S") {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}

/**
 * parents window retrieve at popup
 */
function retrieve() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * handling process for input validation
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSAVE:
	case IBSEARCH:
	case COMMAND04:
	case COMMAND05:
	case COMMAND06:
	case COMMAND07:
	case COMMAND08:
		if (formObj.in_bl_no.value == "") {
			ComShowCodeMessage('BKG00266');
			formObj.in_bl_no.focus();
			return false;
		}
		return true;
		break;
	case COMMAND01:
		if (formObj.form1_cust_cnt_cd.value == "" || formObj.form1_cust_seq.value == "") {
			formObj.form1_cust_cnt_cd.focus();
			return false;
		}
		return true;
		break;
	case COMMAND02:
		if (formObj.form1_cust_cnt_cd2.value == "" || formObj.form1_cust_seq2.value == "") {
			formObj.form1_cust_cnt_cd2.focus();
			return false;
		}
		return true;
		break;
	case COMMAND03:
		if (formObj.form1_cust_cnt_cd3.value == "" || formObj.form1_cust_seq3.value == "") {
			formObj.form1_cust_cnt_cd3.focus();
			return false;
		}
		return true;
		break;
	}
}
