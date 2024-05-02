/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0012.js
 *@FileTitle  : Empty Repo & S/T On/Off Hire S/O Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/30
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/** Common global variable */
var openWindownm = 'MT';
var sheetObjects = new Array();
var sheetCnt = 0;
var tabCnt = 0;
var beforetab = 1;
var Mincount = 0;
var R = 222;
var G = 251;
var B = 248;

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();

	var formObj = document.form;
	if (validateFormSearch(formObj) & ComGetObjValue(formObj.isInquiry) == "Y") {
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, "RE");
	}
}

function initControl() {
}


function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1:
			with (sheetObj) {
				var HeadTitle0 = "||Kind|Requested Date|Reference No|BKG No|CNTR \nTP/SZ|Quantity|Quantity|Quantity|Quantity|From\nNode|To\nNode|Trans. Mode";
				var HeadTitle1 = "||Kind|Requested Date|Reference No|BKG No|CNTR \nTP/SZ|Allocated|S/O Created|W/O Issued|Remaining|From\nNode|To\nNode|Trans. Mode";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle0, Align : "Center" }, { Text : HeadTitle1, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "CheckBox",	Hidden : 0, Width : 30,  Align : "Center", ColMerge : 1, SaveName : "chk1" },
						{ Type : "Status",		Hidden : 1, Width : 30,  Align : "Center", ColMerge : 1, SaveName : "ibflag", 					KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "trsp_cost_dtl_mod_name",	KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Date",		Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "requested_date",			KeyField : 0, CalcLogic : "", Format : "Ymd",	PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 120, Align : "Center", ColMerge : 1, SaveName : "ref_id",					KeyField : 0, CalcLogic : "", Format : "",		PointCount : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "bkg_no",					KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 60,  Align : "Center", ColMerge : 1, SaveName : "eq_tpsz_cd",				KeyField : 0, CalcLogic : "", Format : "",		PointCount : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "allocated",				KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "cret_qty",					KeyField : 0, CalcLogic : "", Format : "",		PointCount : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "wo_qty",					KeyField : 0, CalcLogic : "", Format : "",		PointCount : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "remaing_qty",				KeyField : 0, CalcLogic : "", Format : "",		PointCount : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "fm_nod_cd",				KeyField : 0, CalcLogic : "", Format : "",		PointCount : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "to_nod_cd",				KeyField : 0, CalcLogic : "", Format : "",		PointCount : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "trsp_crr_mod_name",		KeyField : 0, CalcLogic : "", Format : "",		PointCount : 1, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 1, Width : 100, Align : "Center", ColMerge : 1, SaveName : "trsp_cost_dtl_mod_cd",		KeyField : 0, CalcLogic : "", Format : "",		PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",		Hidden : 1, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "trsp_crr_mod_cd",			KeyField : 0, CalcLogic : "", Format : "",		PointCount : 1, UpdateEdit : 0, InsertEdit : 0 }
				];
				InitColumns(cols);
				SetEditable(1);
				SetHeaderRowHeight(10);
				SetRangeBackColor(1, 6, 1, 9, "#555555");
				SetSheetHeight(180);
			}
			break;
		case 2:
			with (sheetObj) {
				var HeadTitle = "||CB\nSeq|Kind|Reference No|Purpose|BKG No|CNTR No|CNTR\nTP/SZ|From\nNode|To\nNode|Trans.\nMode|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Remark|Verify Result|Transfer Requesting\nOffice Code|Transfer Requesting\nUser Name|Transfer Requesting\n Reason|Lease\n flag";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 5, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "CheckBox", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "chk1" },
						{ Type : "Status", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 50, Align : "Center", ColMerge : 1, SaveName : "trsp_so_cmb_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "trsp_cost_dtl_mod_name", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 120, Align : "Center", ColMerge : 1, SaveName : "ref_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "repo_purp_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "bkg_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "eq_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 11, AcceptKeys : "N|E", InputCaseSensitive : 1 },
						{ Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 1, SaveName : "eq_tpsz_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "fm_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "to_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "trsp_crr_mod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "lessor", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "lstm_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "ownr_co_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "eq_used", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "movement_sts", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "creation_yard", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Date", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "event_date", KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 200, Align : "Center", ColMerge : 1, SaveName : "inter_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 1, InsertEdit : 1, EditLen : 255 },
						{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "verify_result", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 255 },
						{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "trns_rqst_ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "trns_rqst_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 120, Align : "Left", ColMerge : 1, SaveName : "trns_rqst_rsn", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "lse_cntr_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Center", ColMerge : 1, SaveName : "trsp_so_ofc_cty_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Center", ColMerge : 1, SaveName : "cre_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Center", ColMerge : 1, SaveName : "upd_usr_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "trsp_mty_rqst_dt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Center", ColMerge : 1, SaveName : "trsp_mty_cost_mod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "repo_pln_id", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "pln_yrwk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "pln_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Center", ColMerge : 1, SaveName : "ref_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "vsl_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 80, Align : "Center", ColMerge : 1, SaveName : "skd_voy_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Center", ColMerge : 1, SaveName : "skd_dir_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Center", ColMerge : 1, SaveName : "slan_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Center", ColMerge : 1, SaveName : "imdt_ext_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 10, Align : "Center", ColMerge : 1, SaveName : "conti_cd", 	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "so_cre_yn",	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 50, Align : "Center", ColMerge : 1, SaveName : "org_eq_no",	KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 50, Align : "Center", ColMerge : 1, SaveName : "n1st_nod_pln_dt", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 1, Width : 50, Align : "Center", ColMerge : 1, SaveName : "lst_nod_pln_dt", 		KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				];
				InitColumns(cols);
				SetEditable(1);
				ComResizeSheet(sheetObj);
			}
			break;
		case 3:
			with (sheetObj) {
				var HeadTitle0 = "Office Code|Seqence";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 5, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle0, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "trsp_so_ofc_cty_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text", Hidden : 0, Width : 50, Align : "Center", ColMerge : 1, SaveName : "trsp_so_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 1, UpdateEdit : 0, InsertEdit : 0 }
				];
				InitColumns(cols);
				SetEditable(0);
				SetVisible(0);
			}
			break;
		case 4:
			with (sheetObj) {
				var HeadTitle1 = "|SEP|EQ_NO|TPSZ|VERIFY_RESULT|YN";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 5, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle1, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Status", Hidden : 1, Width : 30,  Align : "Center", ColMerge : 1, SaveName : "ibflag", 		KeyField : 0, CalcLogic : "", Format : "",	  PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 60,  Align : "Center", ColMerge : 1, SaveName : "sep",           KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "eq_no",         KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 40,  Align : "Center", ColMerge : 1, SaveName : "eq_tpsz_cd",    KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 300, Align : "Center", ColMerge : 1, SaveName : "verify_result", KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 90,  Align : "Center", ColMerge : 1, SaveName : "verify_yn",     KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "lessor",        KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "lstm_cd",       KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "ownr_co_cd",    KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "eq_used",       KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "movement_sts",  KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "creation_yard", KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Date",   Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "event_date",    KeyField : 0, CalcLogic : "", Format : "Ymd", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
						{ Type : "Text",   Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "offh_yd_cd",    KeyField : 0, CalcLogic : "", Format : "",    PointCount : 0, UpdateEdit : 0, InsertEdit : 0 }
				];
				InitColumns(cols);
				SetEditable(1);
				SetVisible(0);
			}
			break;
	}
}
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				if (validateFormSearch(formObject)) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
					sheetObject1.RemoveAll();
				}
				break;
			case "btn_new":
				formObject.reset();
				frm_yard.RemoveAll();
				to_yard.RemoveAll();
				break;
			case "btn_minimize": {
				 if($(".wrap_search").is(':visible')) {
					 $('.wrap_search').hide();
				 } else {
					 $('.wrap_search').show();
				 }
				ComResizeSheet(sheetObject1);
				break;
			}
			case "btng_apply":
				if (searchValidation(sheetObject, formObject, "chk1")) {
					doActionIBSheet(sheetObject1, formObject, IBSEARCH, "SE");
					sheetObject2.RemoveAll();
				}
				break;
			case "btng_fillincontainers":
				if (contatnerValidation(sheetObject1, formObject, "chk1")) {
					popEqFileImport(sheetObject1, formObject);
				}
				break;
			case "btng_socreation":
				if (validateForm(sheetObject1, formObject)) {
					doActionIBSheet(sheetObject1, formObject, IBINSERT, "");
				}
				break;
			case "btng_woissue":
				doActionIBSheet(sheetObject2, formObject, IBINSERT, "WO");
				break;
			case "btng_downexcel": {
				if (sheetObject1.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					sheetObject1.Down2Excel({ DownCols : makeHiddenSkipCol_TRS(sheetObject1), SheetDesign : 1, Merge : 1 });
				}
				break;
			}
			case "btns_frmnode": // FromNode Popup
				openHireYardPopup('getFromNode');
				break;
			case "btns_tonode": // ToNode Popup
				openHireYardPopup('getToNode');
				break;
			case "btns_multireference": // Reference No
				openMultipleinquiry('REF', 'Reference No');
				break;
			case "btns_multicntrno": // CNTR No
				openMultipleinquiry(srcName, 'CNT');
				break;
			case "btns_multibkgno": // Booking No
				openMultipleinquiry(srcName, 'Booking No');
				break;
			case "btns_calendar": // CNTR No
				getCalendar();
				break;
			case "btns_office": // M CNTR
				var ofc_cd = formObject.ctrl_so_office.value;
				ComOpenWindow('ESD_TRS_0964.screen?ctrl_ofc_cd=' + ofc_cd, 'ESD_TRS_0964', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:410px;dialogHeight:410px', true);
				break;
			case "btng_officetransfer": // Office Transfer button
				if (doOfficeTrans(sheetObject1))
					ComOpenWindow('ESD_TRS_0930Pop.screen', 'ESD_TRS_0930Pop', 'top=200, left=200, width=500, height=180, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
				break;
			case "btng_verify":
				if (searchVerify(sheetObject1, formObject, "chk1")) {
					doActionIBSheet(sheetObjects[3], document.form, IBSEARCH, "EQ");
//					doActionIBSheet(sheetObject3, formObject, IBSEARCH, "VY");
				}
				break;
			case "btns_multi_search_fm_node":
				openMultipleinquiry('FM_NODE', 'NODE Code');
				break;
			case "btns_multi_search_to_node":
				openMultipleinquiry('TO_NODE', 'NODE Code');
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			errMsg = ComGetMsg("TRS90108");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}
// control s/o office code return value.
function rtn_office_code(obj) {
	document.form.ctrl_so_office.value = obj;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj) {
	if (sheetObj.FindCheckedRow("chk1") == "") {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	// Make sure the number of data rows
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for ( var i = 0; i < arrRow.length; i++) { // Case One
		fromRow = arrRow[i];
		var lvfmnod = doSepRemove(sheetObj.GetCellValue(fromRow, "fm_nod_cd"), " ");
		var lvtonod = doSepRemove(sheetObj.GetCellValue(fromRow, "to_nod_cd"), " ");
	}

	var doc_eq_no = "";
	var bverifychk = false;
	var birgchk = false;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for ( var i = 0; i < arrRow.length; i++) {
		doc_eq_no = doSepRemove(sheetObj.GetCellValue(arrRow[i], "eq_no"), " ");
		if (sheetObj.GetCellValue(arrRow[i], "so_cre_yn") != "Y" && sheetObj.GetCellValue(arrRow[i], "eq_no") != "") {
			sheetObj.SetCellValue(arrRow[i], "chk1", "0", 0);
			sheetObj.SetRowBackColor(arrRow[i], "#NANNANNAN");
			bverifychk = true;
			if (sheetObj.GetCellValue(arrRow[i], "verify_result") == "") {
				errMsg = ComGetMsg("TRS90360");
			} else {
				errMsg = ComGetMsg("TRS90078");
			}
		} else if (sheetObj.GetCellValue(arrRow[i], "so_cre_yn") != "Y" && sheetObj.GetCellValue(arrRow[i], "eq_no") == "" && sheetObj.GetCellValue(arrRow[i], "org_eq_no") != "") {
			sheetObj.SetCellValue(arrRow[i], "chk1", "0", 0);
			sheetObj.SetRowBackColor(arrRow[i], "#NANNANNAN");
			bverifychk = true;
			if (sheetObj.GetCellValue(arrRow[i], "verify_result") == "") {
				errMsg = ComGetMsg("TRS90360");
			} else {
				errMsg = ComGetMsg("TRS90078");
			}
		}
	}
	if (bverifychk) {
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}
/**
 * handling process for input validation
 */
function validateFormSearch(formObj) {
	var lvfrmDate = doSepRemove(doSepRemove(formObj.frm_reqdate.value, " "), "-");
	var lvtoDate = doSepRemove(doSepRemove(formObj.to_reqdate.value, " "), "-");
	var lvfrm_node = doSepRemove(formObj.frm_node.value, " ");
	var lvto_node = doSepRemove(formObj.to_node.value, " ");
	var lvcntr_no = doSepRemove(formObj.cntr_no.value, " ");
	var lvreference_no = doSepRemove(formObj.reference_no.value, " ");
	var lvbkg_no = doSepRemove(formObj.bkg_no.value, " ");
	var lvctrl_so_office = doSepRemove(formObj.ctrl_so_office.value, " ");

	if (lvfrmDate == "") {
		formObj.frm_reqdate.value = "";
	}
	if (lvtoDate == "") {
		formObj.to_reqdate.value = "";
	}
		
	if (lvfrmDate == "" && lvtoDate != "") {
		ComShowCodeMessage("TRS90119");
		return false;
	} else if (lvfrmDate != "" && lvtoDate == "") {
		ComShowCodeMessage("TRS90121");
		return false;
	} else if (lvfrmDate != "" && lvtoDate != "") {
		if (!doDatecheck(lvfrmDate)) {
			ComShowCodeMessage("TRS90072");
			formObj.frm_reqdate.focus();
			return false;
		} else if (!doDatecheck(lvtoDate)) {
			ComShowCodeMessage("TRS90073");
			formObj.to_reqdate.focus();
			return false;
		}
		if (ComGetDaysBetween(lvfrmDate, lvtoDate) > 60) {
			ComShowCodeMessage("TRS90502", "2");
			return false;
		} else if (ComGetDaysBetween(lvfrmDate, lvtoDate) < 0) {
			ComShowCodeMessage("TRS90118");
			return false;
		}
		if (ComIsEmpty(lvctrl_so_office) && lvreference_no == "" && lvcntr_no == "" && lvbkg_no == "") {
			formObj.ctrl_so_office.focus();
			ComShowCodeMessage("TRS90430");
			return false;
		}
	} else {
		if (lvreference_no == "" && lvcntr_no == "" && lvbkg_no == "") {
			ComShowCodeMessage("TRS90124");
			return false;
		}
	}
	if (lvfrm_node == "") {
		formObj.frm_node.value = "";
		frm_yard.RemoveAll();
	}
	if (lvto_node == "") {
		formObj.to_node.value = "";
		to_yard.RemoveAll();
	}
	if (!doengnumcheck(lvreference_no)) {
		formObj.reference_no.value = "";
		formObj.reference_no.focus();
		return false;
	}
	if (!doengnumcheck(lvcntr_no)) {
		formObj.cntr_no.value = "";
		formObj.cntr_no.focus();
		return false;
	}
	if (!doengnumcheck(lvbkg_no)) {
		formObj.bkg_no.value = "";
		formObj.bkg_no.focus();
		return false;
	}
	formObj.hid_frmreqdate.value = lvfrmDate; // from Date
	formObj.hid_toreqdate.value = lvtoDate; // to Date
	formObj.frm_node.value = lvfrm_node.toUpperCase();
	formObj.to_node.value = lvto_node.toUpperCase();
	formObj.cntr_no.value = lvcntr_no.toUpperCase(); // CNTR No
	formObj.reference_no.value = lvreference_no.toUpperCase(); // Reference No
	formObj.bkg_no.value = lvbkg_no.toUpperCase(); // Booking No
	return true;
}

function doSearchEnter() {
	if (ComGetEvent("keycode") == 13) {
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var formObject = document.form;
		if (validateFormSearch(formObject)) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
			sheetObject1.RemoveAll(); // Remove the contents of sheets of Single Transportation
		}
	}
}
/*
 * Controller for Tab1 Sheet1 IbSheet related
 */
function t1sheet1_OnChange(sheetObj, row, col, value) {
	if (sheetObj.ColSaveName(col) == "chk1") {
		if (value == "1") {
			sheetObj.SetRowStatus(row, "I");
		} 
	} 
	else if (sheetObj.ColSaveName(col) == "eq_no") {
		var doc_eq_no = sheetObj.GetCellValue(row, "eq_no");
		var doc_org_eq_no = sheetObj.GetCellValue(row, "org_eq_no");
		if (doc_eq_no.length >= 10 && doc_org_eq_no == "") {
			doc_row = row;
			document.form.hid_cntr_no.value = doc_eq_no.toUpperCase();
			document.form.hid_cntr_tpsz_cd.value = sheetObj.GetCellValue(row, "eq_tpsz_cd");
			document.form.frm_node_verify.value = sheetObj.GetCellValue(row, "fm_nod_cd");
			sheetObj.SetCellValue(row, "so_cre_yn", "", 0);
			sheetObj.SetCellValue(row, "verify_result", "", 0);
//			doActionIBSheet(sheetObjects[3], document.form, IBSEARCH, "EQ");
		} else {
			if (doc_org_eq_no != "") {
				sheetObj.SetCellValue(row, "eq_no", doc_org_eq_no);
			} else {
				sheetObj.SetCellValue(row, "eq_no", "");
				sheetObj.SetCellValue(row, "lessor", "", 0);
				sheetObj.SetCellValue(row, "lstm_cd", "", 0);
				sheetObj.SetCellValue(row, "ownr_co_cd", "", 0);
				sheetObj.SetCellValue(row, "eq_used", "", 0);
				sheetObj.SetCellValue(row, "movement_sts", "", 0);
				sheetObj.SetCellValue(row, "creation_yard", "", 0);
				sheetObj.SetCellValue(row, "event_date", "", 0);
				sheetObj.SetCellValue(row, "so_cre_yn", "", 0);
				sheetObj.SetCellValue(row, "verify_result", "", 0);
//				sheetObj.SetCellValue(row, "to_nod_cd", "", 0);
				sheetObj.SetCellValue(row, "lse_cntr_flg", "N", 0);
			}
		}
	}
}
// Sheet processing-related processes
function doActionIBSheet(sheetObj, formObj, sAction, sObj) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: // retrieve
			if (sObj == "RE") {
				formObj.f_cmd.value = SEARCH;
				formObj.hid_fm_yard_cd.value = frm_yard.GetSelectText();
				formObj.hid_to_yard_cd.value = to_yard.GetSelectText();
				sheetObj.DoSearch("ESD_TRS_0012GS.do", TrsFrmQryString(formObj));
			} else if (sObj == "SE") {
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESD_TRS_0013GS.do", TrsFrmQryString(formObj));
			} else if (sObj == "VY") {
				sheetObj.RemoveAll();
				formObj.f_cmd.value = SEARCH05;
				sheetObj.DoSearch("ESD_TRS_0012GS.do", TrsFrmQryString(formObj));
			} else if (sObj == "EQ") { // Verify
				formObj.f_cmd.value = SEARCH04;
				var queryStr = sheetObj.GetSaveString(true, true);
				sheetObj.DoSearch("ESD_TRS_0012GS.do", queryStr + "&" + TrsFrmQryString(formObj));
			}
			break;
		case IBINSERT: // adding
			if (sObj == "") {
				formObj.f_cmd.value = MULTI;
				formObj.cbstatus.value = sObj;
				var queryStr = sheetObj.GetSaveString(false, true, "chk1");
				sheetObjects[2].DoSearch("ESD_TRS_0012GS.do", queryStr + "&" + TrsFrmQryString(formObj), { Append : true, Sync : 2 });
			} else if (sObj == "WO") {
				if (sheetObj.RowCount() < 1) {
					errMsg = "W/O can't be issued at this time as S/O has not been created yet. Please create S/O first.";
					ComShowMessage(errMsg);
					return false;
				} else {
					var cty_cd = "";
					var seq_no = "";
					for ( var i = 1; i < sheetObj.RowCount() + 1; i++) {
						if (i == sheetObj.RowCount()) {
							cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd');
							seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq');
						} else {
							cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd') + ",";
							seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq') + ",";
						}
					}
					document.woForm.trsp_so_ofc_cty_cd.value = cty_cd;
					document.woForm.trsp_so_seq.value = seq_no;
					document.woForm.eq_mode.value = "CG";
					document.woForm.action = "ESD_TRS_0023.screen?parentPgmNo=ESD_TRS_M001";
					document.woForm.submit();
				}
			}
			break;
	}
}
/**
 * handling process for input validation
 */
function searchValidation(sheetObj, formObj, sStatus) {
	if (sheetObj.CheckedRows("chk1") < 1) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	// Make sure the number of data rows
	var fromRow = 0;
	var lvTrspCostModCd = "";
	var lvRefId = "";
	var lvFmNodCd = "";
	var lvToNodCd = "";
	var lvTrspCrrModCd = "";
	var lvEqTpszCd = "";
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for ( var i = 0; i < arrRow.length; i++) {
		fromRow = arrRow[i];
		if (arrRow.length - 1 == i) {
			lvTrspCostModCd = lvTrspCostModCd + "" + sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_cd");
			lvRefId = lvRefId + "" + sheetObj.GetCellValue(fromRow, "ref_id");
			lvFmNodCd = lvFmNodCd + "" + sheetObj.GetCellValue(fromRow, "fm_nod_cd");
			lvToNodCd = lvToNodCd + "" + sheetObj.GetCellValue(fromRow, "to_nod_cd");
			lvTrspCrrModCd = lvTrspCrrModCd + "" + sheetObj.GetCellValue(fromRow, "trsp_crr_mod_cd");
			lvEqTpszCd = lvEqTpszCd + "" + sheetObj.GetCellValue(fromRow, "eq_tpsz_cd");
		} else {
			lvTrspCostModCd = lvTrspCostModCd + "" + sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_cd") + ",";
			lvRefId = lvRefId + "" + sheetObj.GetCellValue(fromRow, "ref_id") + ",";
			lvFmNodCd = lvFmNodCd + "" + sheetObj.GetCellValue(fromRow, "fm_nod_cd") + ",";
			lvToNodCd = lvToNodCd + "" + sheetObj.GetCellValue(fromRow, "to_nod_cd") + ",";
			lvTrspCrrModCd = lvTrspCrrModCd + "" + sheetObj.GetCellValue(fromRow, "trsp_crr_mod_cd") + ",";
			lvEqTpszCd = lvEqTpszCd + "" + sheetObj.GetCellValue(fromRow, "eq_tpsz_cd") + ",";
		}
	}
	formObj.hid_trsp_cost_mod_cd.value = lvTrspCostModCd;
	formObj.hid_ref_id.value = lvRefId;
	formObj.hid_fm_nod_cd.value = lvFmNodCd;
	formObj.hid_to_nod_cd.value = lvToNodCd;
	formObj.hid_trsp_crr_mod_cd.value = lvTrspCrrModCd;
	formObj.hid_eq_tpsz_cd.value = lvEqTpszCd;
	return true;
}
/**
 * Container File import process for input validation
 */
function contatnerValidation(sheetObj, formObj, sStatus) {
	if (sheetObj.CheckedRows("chk1") < 1) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for ( var i = 0; i < arrRow.length; i++) {
		if (sheetObj.GetCellValue(arrRow[i], "eq_no") != "") {
			sheetObj.SetCellValue(arrRow[i], "chk1", "0", 0);
			sheetObj.SetRowBackColor(arrRow[i], "#NANNANNAN");
		}
	}
	if (sheetObj.RowCount("I") < 1) {
		errMsg = ComGetMsg("TRS90051");
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}
/**
 * Click the Tab at the event-related Elements selected tab is active.
 */
function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
	if (nItem == "1") {
		objs.style.display = "none";
		sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 7));
		t1sheet1.SetSheetHeight(ComGetSheetHeight(t1sheet1, 7));
	} else {
		objs.style.display = "inline";
		sheet1.SetSheetHeight(ComGetSheetHeight(sheet1, 6));
		t1sheet1.SetSheetHeight(ComGetSheetHeight(t1sheet1, 6));
	}
}
/**
 * Common Node popup
 */
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val = ""; // Variables will be available for future use
	var rep_cmdt_cd_val = ""; // Variables will be available for future use
	var cmdt_desc_val = ""; // Variables will be available for future use
	var classId = objName;
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 830, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * popSearchPiCommCodeGrid process handling
 */
function popSearchPiCommCodeGrid(classID, midCD, cdName, sheetName, sRow, colCode, colName) {
	var myUrl = getPopupURL(POPUP_PI_COMM);
	var myOption = getPopupOption(POPUP_PI_COMM);
	var url;
	if (myWin != null)
		ComClosePopup();
	url = myUrl + "?class_id=" + classID + "&mid_cd=" + midCD + "&cdName=" + cdName + "&sheetName=" + sheetName + "&sRow=" + sRow + "&colCode=" + colCode + "&colName=" + colName;
	myWin = window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}
/**
 * From Node for the return value
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.frm_node.value = lvLoc;
	formObject.search_fm_node.value = "";
	getYardCombo(frm_yard, sheetObjects[0], formObject, lvLoc);
	frm_yard.SetSelectCode(lvYard);
}
/**
 * To Node for the return value
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.to_node.value = lvLoc;
	formObject.search_to_node.value = "";
	getYardCombo(to_yard, sheetObjects[0], formObject, lvLoc);
	to_yard.SetSelectCode(lvYard);
}
/*
 * Get a list of external combo box (Refer to ESD_TRS_0003.js).
 */
function getComboList(obj, comObj, sep) {
	comObj = eval(comObj);
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var lvkind = formObj.sel_kind.value;
	if (lvobj == "") {
		obj.value = "";
		comObj.RemoveAll();
		return false;
	} else if (lvobj.length != 5) {
		obj.focus();
		errMsg = ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		return false;
	}
	if (!doengnumcheck(lvobj)) {
		obj.value = "";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if (sep == 'F') {
		if (lvkind == "ALL") {
			formObj.TRSP_SO_EQ_KIND.value = "A";
		} else if (lvkind == "CN") {
			formObj.TRSP_SO_EQ_KIND.value = "N";
		} else {
			formObj.TRSP_SO_EQ_KIND.value = "";
		}
		formObj.search_fm_node.value = "";
		lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if (sep == 'V') {
		lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if (sep == 'T') {
		if (lvkind == "ALL") {
			formObj.TRSP_SO_EQ_KIND.value = "A";
		} else if (lvkind == "CF") {
			formObj.TRSP_SO_EQ_KIND.value = "N";
		} else {
			formObj.TRSP_SO_EQ_KIND.value = "";
		}
		formObj.search_to_node.value = "";
		lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if (sep == 'D') {
		lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.Focus();
}
function getSheetObj() {
	return sheetObjects[1];
}
/**
 * call file import window
 */
function popEqFileImport(sheetObject, formObject) {
	ComOpenWindow('ESD_TRS_0951.screen', 'ESD_TRS_0951', 'top=200, left=200, width=430, height=440, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
}
/**
 * import popup called from data to sheet compared to the fill.
 */
function importEqNo(popSheetObj, obj) {
	var sheetObj = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var checkList = popSheetObj.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	var row = 0;
	var value = '';

	if (document.form.kind_chassis[0].checked) {
		document.form.f_cmd.value = SEARCH06;
	} else {
		document.form.f_cmd.value = SEARCH07;
	}
	var queryStr = popSheetObj.GetSaveString(false, false, "chk1");
	if (queryStr == '') {
		ComClosePopup();
		return false;
	}
	sheetObj2.DoSearch("ESD_TRS_0014GS.do", queryStr + '&' + TrsFrmQryString(document.form), { Append : false, Sync : 2 });
	var emptyEqArray = new Array();
	var cnt = 0;
	for ( var k = 1; k < sheetObj.RowCount() + 1; k++) {
		if (sheetObj.GetCellValue(k, 'eq_no') == '')
			emptyEqArray[cnt++] = k;
	}
	cnt = 0;
	var tempEqNo = '';
	for ( var i = 1; i < sheetObj2.RowCount() + 1; i++) {
		for ( var k = 0; k < emptyEqArray.length; k++) {
			if (emptyEqArray[k] != -1) {
				if (sheetObj.GetCellValue(emptyEqArray[k], 'eq_tpsz_cd') == sheetObj2.GetCellValue(i, 'eq_tpsz_cd')) {
					sheetObj.SetCellValue(emptyEqArray[k], 'eq_no', sheetObj2.GetCellValue(i, 'eq_no'), 0);
					sheetObj.SetCellValue(emptyEqArray[k], 'vndr_abbr_nm', sheetObj2.GetCellValue(i, 'vndr_abbr_nm'), 0);
					sheetObj.SetCellValue(emptyEqArray[k], 'lstm_cd', sheetObj2.GetCellValue(i, 'lstm_cd'), 0);
					sheetObj.SetCellValue(emptyEqArray[k], 'ownr_co_cd', sheetObj2.GetCellValue(i, 'ownr_co_cd'), 0);
					sheetObj.SetCellValue(emptyEqArray[k], 'usr_co_cd', sheetObj2.GetCellValue(i, 'usr_co_cd'), 0);
					sheetObj.SetCellValue(emptyEqArray[k], 'mvmt_sts_cd', sheetObj2.GetCellValue(i, 'mvmt_sts_cd'), 0);
					sheetObj.SetCellValue(emptyEqArray[k], 'lst_sts_yd_cd', sheetObj2.GetCellValue(i, 'lst_sts_yd_cd'), 0);
					sheetObj.SetCellValue(emptyEqArray[k], 'mvmt_dt', sheetObj2.GetCellValue(i, 'mvmt_dt'), 0);
					emptyEqArray[k] = -1;
					cnt++;
					break;
				}
			}
		}
		if (cnt == emptyEqArray.length)
			break;
	}
	ComClosePopup();
}
/**
 * Common Trunk VVD popup
 */
function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val = ""; // Variables will be available for future use
	var rep_cmdt_cd_val = ""; // Variables will be available for future use
	var cmdt_desc_val = ""; // Variables will be available for future use
	var xx1 = obj; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";
	var param = "?returnval=" + xx1 + "&returntitle=" + obj2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 500, 420, "getTRS_ENS_906", '0,1', true);
}
/**
 * Location : If multiple selections from a pop-up..
 */
function getTRS_ENS_906(rowArray, x1) {
	var reObj = "";
	var formObject = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[i];
		if (i == rowArray.length - 1) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ",";
		}
	}
	if (x1 == 'REF') {
		formObject.reference_no.value = reObj;
	} else if (x1 == "FM_NODE") {
		formObject.search_fm_node.value = reObj;
		resetLocYard("FROM");
	} else if (x1 == "TO_NODE") {
		formObject.search_to_node.value = reObj;
		resetLocYard("TO");
	} else {
		var formObject = document.form;
		if (x1 == 'btns_multicntrno') {
			formObject.cntr_no.value = rowArray;
			checkDigit();
		} else if (x1 == 'btns_multibkgno') {
			formObject.bkg_no.value = rowArray;
			checkDigit();
		}
	}
}
function checkDigit(obj) {
	var formObj = document.form;
	if (obj == undefined) {
		obj = formObj.cntr_no;
	}
	obj.value = obj.value.toUpperCase();
	if (formObj.name == 'form') {
		obj.value = multiCntrChkDgt(obj.value);
	}
}
/*
 * Business Validation Check
 */
function doDataEquals(sheetObj) {
	if (sheetObj.CheckedRows("chk1") < 1) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	// Make sure the number of data rows
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for ( var i = 0; i < arrRow.length; i++) {
		fromRow = arrRow[i];
		var lvFmnod = doSepRemove(sheetObj.GetCellValue(fromRow, "fm_nod_cd"), " ");
		var lvTonod = doSepRemove(sheetObj.GetCellValue(fromRow, "to_nod_cd"), " ");
		if (sheetObj.GetCellValue(fromRow, "eq_tpsz_cd").indexOf("2") < 0) {
			sheetObj.SetCellValue(fromRow, "chk1", "0", 0);
			sheetObj.SetRowBackColor(fromRow, "#NANNANNAN");
		} else {
			if (lvFmnod == "" || lvTonod == "") {
				sheetObj.SetCellValue(fromRow, "chk1", "0", 0);
				sheetObj.SetRowBackColor(fromRow, "#NANNANNAN");
			}
		}
	}
	return true;
}
// From Node1/2, To Node1/2
function doTimeCheck(of, of2, ot, ot2) {
	if (of == of2 && ot == ot2) {
		return true;
	} else {
		return false;
	}
}
function IBS_Sheet2SheetStatus4(fromSheet) {
	var iz = 0;
	var cs = 0;
	for ( var i = 0; i < fromSheet.RowCount(); i++) {
		if (i % 2 == 0)
			iz++;
		if (cs == 0)
			cs = 1;
		else if (cs == 1)
			cs = 2;
		else if (cs == 2)
			cs = 1;
		if (iz % 2 == 0) {
			fromSheet.SetCellValue(i + 1, "trsp_so_cmb_seq", iz + "-" + cs, 0);
			fromSheet.SetRowBackColor(i + 1, "#EEFFE2");
		} else {
			fromSheet.SetCellValue(i + 1, "trsp_so_cmb_seq", iz + "-" + cs, 0);
			fromSheet.SetRowBackColor(i + 1, "#FFFFFF");
		}
	}
}
/*
 * Calendar Pop-Up
 */
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.frm_reqdate, document.form.to_reqdate, 'yyyyMMdd');
}
/**
 * When an error occurs, save the results to a common processing function IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var cmbTbcd = "";
	cmbTbcd = document.form.cbstatus.value;
	var sheetObjOrigin;
	var cmbSep = "";
	if (cmbTbcd == "") {
		sheetObjOrigin = sheetObjects[1];
		cmbSep = "NO";
	}
	if (errMsg.length > 0) {
		ComShowMessage(errMsg);
	} else {
		errMsg = ComGetMsg("TRS90107");
		ComShowMessage(errMsg);
		IBS_Sheet2SheetStatus3_2(sheetObjOrigin, "chk1", cmbSep);
	}
}
/**
 * When an error occurs, query the results to a common processing function DataSheetObject.prototype.event_OnSaveEnd define in IBSheetConfig.js
 */
function t1sheet1_OnSearchEnd(sheetObj, errMsg) {
	if (errMsg.length > 0) {
		if (document.form.f_cmd.value == SEARCH04) {
			sheetObjects[1].SetCellValue(doc_row, "eq_no", "", 0);
			sheetObjects[1].SetCellValue(doc_row, "chk1", "0", 0);
			sheetObjects[1].SetRowBackColor(doc_row, "#NANNANNAN");
		} else {
			ComShowMessage(errMsg);
		}
	}
}
/**
 * When an error occurs, query the results to a common processing function DataSheetObject.prototype.event_OnSaveEnd define in IBSheetConfig.js
 */
function sheet3_OnSearchEnd(sheetObj, errMsg) {
	if (errMsg.length > 0) {
		if (document.form.f_cmd.value == SEARCH04) {
			sheetObjects[1].SetCellValue(doc_row, "eq_no", "", 0);
			// sheetObjects[1].RowStatus(doc_row) = "R";
			sheetObjects[1].SetCellValue(doc_row, "chk1", "0", 0);
			sheetObjects[1].SetRowBackColor(doc_row, "#NANNANNAN");
		} else {
			ComShowMessage(errMsg);
		}
	} else {
		if (document.form.f_cmd.value == SEARCH04) {
			for ( var ir = 1; ir < sheetObjects[1].RowCount() + 1; ir++) {
				for ( var row = 1; row < sheetObjects[3].RowCount() + 1; row++) {
					if (sheetObjects[1].GetCellValue(ir, "eq_no") == sheetObjects[3].GetCellValue(row, "eq_no")) {
						if (sheetObjects[1].GetCellValue(ir, "eq_tpsz_cd") != sheetObjects[3].GetCellValue(row, "eq_tpsz_cd")) {
							sheetObjects[1].SetCellValue(ir, "chk1", "0", 0);
							sheetObjects[1].SetRowBackColor(ir, "#NANNANNAN");
							sheetObjects[1].SetCellValue(ir, "eq_no", "", 0);
							sheetObjects[1].SetCellValue(ir, "lessor", "", 0);
							sheetObjects[1].SetCellValue(ir, "lstm_cd", "", 0);
							sheetObjects[1].SetCellValue(ir, "ownr_co_cd", "", 0);
							sheetObjects[1].SetCellValue(ir, "eq_used", "", 0);
							sheetObjects[1].SetCellValue(ir, "movement_sts", "", 0);
							sheetObjects[1].SetCellValue(ir, "creation_yard", "", 0);
							sheetObjects[1].SetCellValue(ir, "event_date", "", 0);
							sheetObjects[1].SetCellValue(ir, "so_cre_yn", "", 0);
							sheetObjects[1].SetCellValue(ir, "verify_result", "", 0);
							
							errMsg = ComGetMsg("TRS90345");
							ComShowMessage(errMsg);
							return;
						} else {
							sheetObjects[1].SetCellValue(ir, "eq_no", sheetObjects[3].GetCellValue(row, "eq_no"), 0);
							sheetObjects[1].SetCellValue(ir, "lessor", sheetObjects[3].GetCellValue(row, "lessor"), 0);
							sheetObjects[1].SetCellValue(ir, "lstm_cd", sheetObjects[3].GetCellValue(row, "lstm_cd"), 0);
							sheetObjects[1].SetCellValue(ir, "ownr_co_cd", sheetObjects[3].GetCellValue(row, "ownr_co_cd"), 0);
							sheetObjects[1].SetCellValue(ir, "eq_used", sheetObjects[3].GetCellValue(row, "eq_used"), 0);
							sheetObjects[1].SetCellValue(ir, "movement_sts", sheetObjects[3].GetCellValue(row, "movement_sts"), 0);
							sheetObjects[1].SetCellValue(ir, "creation_yard", sheetObjects[3].GetCellValue(row, "creation_yard"), 0);
							sheetObjects[1].SetCellValue(ir, "event_date", sheetObjects[3].GetCellValue(row, "event_date"), 0);
							// Off-Hire Cntr
							if (sheetObjects[1].GetCellValue(ir, "trsp_cost_dtl_mod_name") == 'Off-Hire' && sheetObjects[1].GetCellValue(ir, "org_eq_no") == '' && sheetObjects[3].GetCellValue(row, "offh_yd_cd") != '') {
								sheetObjects[1].SetCellValue(ir, "to_nod_cd", sheetObjects[3].GetCellValue(row, "offh_yd_cd"), 0);
								sheetObjects[1].SetCellValue(ir, "lse_cntr_flg", 'Y', 0);
							}
						}
					}
				}
			}

			sheetObjects[3].RemoveAll();
			document.form.hid_cntr_no.value = "";
			doc_row = 0;
			
			doActionIBSheet(sheetObjects[3], document.form, IBSEARCH, "VY");
		} else {
			doSearchVerify(sheetObjects[1], sheetObjects[3]);
			ComShowCodeMessage('COM12116', 'Verify');
		}
	}
}
/**
 * Inert success depending on the contents of the grid is removed.
 */
function IBS_Sheet2SheetStatus3_2(fromSheet, sStatus, bgObj) {
	if (typeof fromSheet == null || fromSheet.tagName == "undefined") {
		return false;
	}
	var fromRow = 0;
	var sRow = fromSheet.FindCheckedRow(sStatus);
	var arrRow = sRow.split("|");

	for ( var ir = arrRow.length - 1; ir >= 0; ir--) {
		fromRow = arrRow[ir];
		fromSheet.RowDelete(fromRow, false);
	}
	if (bgObj == "YES") {
		IBS_Sheet2SheetStatus4(fromSheet);
	}
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var formObject = document.form;
	if (validateFormSearch(formObject)) {
		doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
	}
}
// To date plus.
function getDateBetween(obj) {
	if(document.form.frm_reqdate.value != "" && document.form.frm_reqdate.value.split("-").join("").length == 8) {
	    document.form.to_reqdate.value=ComGetDateAdd(obj.value,"D", 60, "-");
	}
}
function doOfficeTrans(sheetObj) {
	var fromRow = 0;
	if (sheetObj.CheckedRows("chk1") < 1) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for ( var i = 0; i < arrRow.length; i++) {
		fromRow = arrRow[i];
		if (sheetObj.GetCellValue(fromRow, "trsp_crr_mod_cd").indexOf("T") < 0) {
			return false;
		}
	}

	return true;
}
function openObjSheet() {
	return sheetObjects[1];
}
function doOfficeTrans_end(obj) {
	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	if (validateFormSearch(formObject)) {
		doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
	}
}
/**
 * handling process for input validation - Cntr verify
 */
function searchVerify(sheetObj, formObj, sStatus) {
	sheetObjects[3].RemoveAll();
	if (sheetObj.CheckedRows("chk1") < 1) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var fromRow = 0;
	var lvEq_no = "";
	var lvFm_nod_cd = "";
	var sRow = sheetObj.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");

	for ( var i = 0; i < arrRow.length; i++) {
		fromRow = arrRow[i];
		sheetObj.SetCellValue(fromRow, "verify_result", "", 0);
		if (sheetObj.GetCellValue(fromRow, "eq_no") == "") {
		} else {
			if (arrRow.length - 1 == i) {
				lvEq_no = lvEq_no + "" + sheetObj.GetCellValue(fromRow, "eq_no");
				lvFm_nod_cd = lvFm_nod_cd + "" + sheetObj.GetCellValue(fromRow, "fm_nod_cd");
			} else {
				lvEq_no = lvEq_no + "" + sheetObj.GetCellValue(fromRow, "eq_no") + ",";
				lvFm_nod_cd = lvFm_nod_cd + "" + sheetObj.GetCellValue(fromRow, "fm_nod_cd") + ",";
			}
			
			var row = sheetObjects[3].DataInsert(-1);
			sheetObjects[3].SetCellValue(row, "eq_no", sheetObj.GetCellValue(fromRow, "eq_no"), 0);
		}
	}
	if (sheetObj.CheckedRows("chk1") < 1 || lvEq_no.length < 1) {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
		return false;
	}
	
	// TODO CHECK EQ_NO VALIDATION
	var dupRow = sheetObjects[3].ColValueDup("eq_no");
	if(dupRow > -1 || dupRow !="-1") {
		errMsg = ComGetMsg("TRS90133");
		ComShowMessage(errMsg);
		return false;
	}
	
	formObj.eq_no_verify.value = lvEq_no;
	formObj.frm_node_verify.value = lvFm_nod_cd;
	return true;
}
/*
 * Verify the results viewed on the S / O Creation item selection
 */
function doSearchVerify(sheetObj1, sheetObj2) {
	var sRow = sheetObj1.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	var fromRow = 0;

	for ( var i = 0; i < arrRow.length; i++) {
		fromRow = arrRow[i];
		var lvEa_no = sheetObj1.GetCellValue(fromRow, "eq_no");
		if (sheetObj1.GetCellValue(fromRow, "eq_no") != "") {
			sheetObj1.SetCellValue(fromRow, "so_cre_yn", "Y", 0);
		}
		if (sheetObj1.GetCellValue(fromRow, "verify_result") == "" && sheetObj1.GetCellValue(fromRow, "eq_no") != "") {
			sheetObj1.SetCellValue(fromRow, "verify_result", "OK", 0);
		}
		for ( var z = 1; z < (sheetObj2.RowCount() + 1); z++) {
			if (lvEa_no == sheetObj2.GetCellValue(z, "eq_no")) {
				sheetObj1.SetCellValue(fromRow, "verify_result", sheetObj2.GetCellValue(z, "verify_result"), 0);
				if (sheetObj2.GetCellValue(z, "verify_yn") == "N") { 
					sheetObj1.SetCellValue(fromRow, "so_cre_yn", "Y", 0);
				} else {
					sheetObj1.SetCellValue(fromRow, "so_cre_yn", "", 0);
					sheetObj1.SetCellValue(fromRow, "chk1", "0", 0);
					sheetObj1.SetRowBackColor(fromRow, "#NANNANNAN");
				}
				break;
			}
		}
	}
}
// Include Check Bok Click
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.ctrl_so_office.value.toUpperCase(), " ");
	if (prm_office == "") {
		doc_office.checked = false;
		document.form.ctrl_so_office.value = "";
		ComShowMessage("Please input the 'S/O Office'!!");
		return false;
	}
	if (doc_office.checked == true) {
		var url = "ESD_TRS_0002GS.do?f_cmd=" + SEARCH11 + "&ctrl_so_office=" + prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.ctrl_so_office.value = document.form.old_ofc_cd.value;
	}
}
// Include Office handling Logic
var request = null;
function createHttpRequest() {
	try {
		request = new XMLHttpRequest();
	} catch (trymicrosoft) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (othermicosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = null;
			}
		}
	}
	if (request == null) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}
// Get Office value
function subCntorlOffice() {
	if (request.readyState == 4) {
		if (request.status == 200) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for ( var n = 0; n < rowXml.firstChild.nodeValue; n++) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc + subXml.firstChild.nodeValue + ",";
			}
			if (text_ofc.length < 1) {
				ComShowMessage("No Data!");
			}
			document.form.ctrl_so_office.value = text_ofc.substring(0, text_ofc.length - 1);
		}
	}
}

function resetLocYard(which) {
	var formObj = document.form;
	if (which == 'FROM') {
		if (formObj.search_fm_node.value.length > 0) {
			formObj.frm_node.value = "";
			frm_yard.RemoveAll();
		}
	} else {
		if (formObj.search_to_node.value.length > 0) {
			formObj.to_node.value = "";
			to_yard.RemoveAll();
		}
	}
}
