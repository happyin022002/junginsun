/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0344.js
*@FileTitle  : Korea Manifest Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/
// Common global variable
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var formObj = document.form;
	var sheetObject = sheetObjects[0];
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_New":
				funcNewAction(formObj, false);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, MODIFY);
				break;
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
			case "btn_TransManifest_3G":
				formObj.ff_div.value = "3G";
				doActionIBSheet(sheetObject, formObj, MULTI05);
				break;
			case "btn_TransManifest":
				formObj.ff_div.value = "4G";
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
				doActionIBSheet(sheetObject, formObj, MULTI05);
				break;
			case "btn_DeleteManifest":
				doActionIBSheet(sheetObject, formObj, REMOVE);
				break;
			case "btn_TransperBL":
				doActionIBSheet(sheetObject, formObj, MULTI01);
				break;
			case "btn_CancelperBL":
				doActionIBSheet(sheetObject, formObj, MULTI07);
				break;
			case "btn_TransAmendToPA":
				doActionIBSheet(sheetObject, formObj, MULTI02);
				break;
			case "btn_TransCancellationToPA":
				doActionIBSheet(sheetObject, formObj, MULTI03);
				break;
			case "pol_cd":
				formObj.io_bnd_cd[1].checked = true;
				checkBoundCd(formObj);
				formObj.pol_cd.focus();
				break;
			case "pod_cd":
				formObj.io_bnd_cd[0].checked = true;
				checkBoundCd(formObj);
				formObj.pod_cd.focus();
				break;
			case "io_bnd_cd":
				checkBoundCd(formObj);
				break;
			case "btn_searchBondArea":
				if (formObj.io_bnd_cd[1].checked) {
					var sUrl="ESM_BKG_0334_POP.do?pgmNo=ESM_BKG_0334_POP";
					ComOpenPopup(sUrl, 800, 500, "searchBondArea", "1,0", true);
				}
				break;
			case "btn_searchTmlLoc":
				var sUrl="ESM_BKG_0416_POP.do?pgmNo=ESM_BKG_0416";
				ComOpenPopup(sUrl, 1024, 650, "searchTmlLoc", "0,0", true);
				break;
			case "btn_TransEmptyAmend":
				doActionIBSheet(sheetObject, formObj, MULTI06);
				break;
			case "btn_trans_cancell_popup":
				formObj.f_cmd.value = INIT;
				var sndDate = formObj.f_date.value + " " + formObj.t_date.value;
				sUrl = "ESM_BKG_0346.do?pgmNo=ESM_BKG_0346&" + FormQueryString(formObj) + "&snd_date="+sndDate;
//				var rtnVal = ComOpenWindowCenter(sUrl, "ESM_BKG_0346", 1024, 300, true);
				ComOpenPopup(sUrl, 700, 380, "searchTmlLoc", "1,0", true)
				break;
		} // end switch

	} catch(e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function searchTmlLoc(rtnVal) {
	if (rtnVal != null) document.form.io_tml_loc_cd.value = rtnVal.cd;
}


function searchBondArea(rtnVal) {
	if (rtnVal != null) document.form.bd_area_cd.value = rtnVal.cd;
}


/**
 * Check the bound code
 */
function checkBoundCd(formObj) {
	var inType = form.in_type;
	if (form.io_bnd_cd[0].checked) {
		// IN-BOUND
		form.pol_cd.value = "";
		form.pol_cd.disabled = true;
		form.pol_cd.className = "input2";
		form.pol_yd_cd.value = "";
		form.pol_yd_cd.disabled = true;
		form.pol_yd_cd.className = "input2";
		form.pod_cd.disabled = false;
		form.pod_cd.className = "input1";
		form.tml_cd.disabled = false;
		form.tml_cd.className = "input";
		form.eta_dt.disabled = false;
		form.eta_dt.className = "input";
		form.bd_area_cd.disabled = true;
		form.bd_area_cd.className = "input2";
//		inType.disabled = true;
//		inType.className = "input2";
		// option 항목을 삭제
		ComClearCombo(inType);
		// Inbound용 option 항목을 추가[blank, A, R, M, T]
		ComAddComboItem(inType, "1 : Local", "A");
		ComAddComboItem(inType, "2 : T/S", "R");
		ComAddComboItem(inType, "3 : eMpty Local", "M");
		inType.value = "A";
/*
		ComShowObject(form.dwell, false);
		ComShowObject(document.all.dwell_txt, false);
		ComShowObject(form.ib_vvd, false);
		ComShowObject(document.all.ib_vvd_txt, false);
		ComShowObject(form.whf_notice, false);
		ComShowObject(document.all.whf_notice_txt, false);
		ComShowObject(form.ib_bl_cnt, false);
		ComShowObject(document.all.ib_bl_cnt_txt, false);
		//ComShowObject(document.all.emptyAmend_btn, false);
		ComShowObject(document.all.span_trans, true);
		ComShowObject(form.trans_target, true);
*/
	} else {
		// OUT-BOUND
		form.pol_cd.disabled = false;
		form.pol_cd.className = "input1";
		form.pol_yd_cd.disabled = false;
		form.pol_yd_cd.className = "input";
		form.pod_cd.value = "";
		form.pod_cd.disabled = true;
		form.pod_cd.className = "input2";
		form.tml_cd.value = "";
		form.tml_cd.disabled = true;
		form.tml_cd.className = "input2";
		form.eta_dt.disabled = true;
		form.eta_dt.className = "input2";
		form.bd_area_cd.disabled = false;
		form.bd_area_cd.className = "input1";
//		inType.disabled = false;
//		inType.className = "input1";
		// option 항목을 삭제
		ComClearCombo(inType);
		// Outbound용 option 항목을 추가
		ComAddComboItem(inType, "1 : Local", "B");
		ComAddComboItem(inType, "2 : T/S", "C");
		inType.value = "B";
/*
		ComShowObject(form.dwell, true);
		ComShowObject(document.all.dwell_txt, true);
		ComShowObject(form.ib_vvd, true);
		ComShowObject(document.all.ib_vvd_txt, true);
		ComShowObject(form.whf_notice, true);
		ComShowObject(document.all.whf_notice_txt, true);
		ComShowObject(form.ib_bl_cnt, true);
		ComShowObject(document.all.ib_bl_cnt_txt, true);
		//ComShowObject(document.all.emptyAmend_btn, true);
		ComShowObject(document.all.span_trans, false);
		form.trans_target.value = "A";
		ComShowObject(form.trans_target, false);
*/
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
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (var k=0;k<comboObjects.length;k++) {
		initCombo(comboObjects[k],k+1);
	}

	var formObj = document.form;
	ComShowObject(formObj.dwell, false);
	ComShowObject(document.all.dwell_txt, false);
	ComShowObject(formObj.ib_vvd, false);
	ComShowObject(document.all.ib_vvd_txt, false);
	ComShowObject(formObj.whf_notice, false);
	ComShowObject(document.all.whf_notice_txt, false);
	ComShowObject(formObj.ib_bl_cnt, false);
	ComShowObject(document.all.ib_bl_cnt_txt, false);
	//ComShowObject(document.all.emptyAmend_btn, false);
	ComShowObject(document.all.span_trans, false);
	ComShowObject(formObj.trans_target, false);

}


/**
 * * Event after the sheet Loading
 */
function sheet1_OnLoad(sheetObj) {
	var form = document.form;
	checkBoundCd(form);

	if (form.vvd.value != "") {
		form.in_type.value = selType;
		doActionIBSheet(sheetObj, form, IBSEARCH);
	} else {
		funcNewAction(form, false);
	}
/*
	if (form.dwell.value > 29 || form.whf_notice.value.trim().length > 0) {
		ComBtnDisable("btn_TransEmptyAmend");
	} else {
		ComBtnEnable("btn_TransEmptyAmend");
	}
*/
}


/**************************************************************************************************
 * handling process for input validation
 **************************************************************************************************/
function validateForm(sheetObj, formObj, sAction) {
	with(formObj) {
		if (vvd.value.length < 9) {
			ComShowCodeMessage("BKG00103");
			vvd.focus();
			return false;
		}
		if (io_bnd_cd[1].checked && pol_cd.value.length < 5) {
			ComShowCodeMessage("BKG00103");
			pol_cd.focus();
			return false;
		}
		if (io_bnd_cd[0].checked && pod_cd.value.length < 5) {
			ComShowCodeMessage("BKG00103");
			pod_cd.focus();
			return false;
		}
	}
	return true;
}


/**************************************************************************************************
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 **************************************************************************************************/
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj) {
				var HeadTitle="|Seq|MRN|VVD|POL|POD|Office|User ID|B/L Count|AC|Date|Date";
				var prefix="";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
							{Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
							{Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mrn",     Edit:1 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",     Edit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",     Edit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",     Edit:1 },
							{Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"office",  Edit:1 },
							{Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"userid",  Edit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"blcount", Edit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ac",      Edit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dt",      Edit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dt2",     Edit:1 } ];

				InitColumns(cols);

				SetEditable(1);
				SetCountPosition(0);
				SetWaitImageVisible(0);
				SetVisible(0);
			}

			break;
	}
}


/**************************************************************************************************
 * handling process for Sheet
 **************************************************************************************************/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //retrieve
			formObj.f_cmd.value=SEARCH;
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);
			sheetObj.SetEtcData("mrn_no"," ");
			sheetObj.DoSearch("ESM_BKG_0344GS.do", FormQueryString(formObj));
			break;

		case MODIFY:
			if (!ComShowCodeConfirm("BKG95003", "save")) return;
			formObj.f_cmd.value=MODIFY;
			ComOpenWait(true);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
			sheetObj.LoadSaveData(sXml, {Sync:1} );
			ComOpenWait(false);
			break;

		case REMOVE:
			var delCfm = false;
			if (formObj.old_snd_chk.value == "Y") {
				delCfm = ComShowConfirm("Already Transmitted !!\nDo you want to delete ?");
			} else {
				delCfm=ComShowCodeConfirm("BKG95003", "delete");
			}
			if (delCfm) {
				formObj.f_cmd.value=REMOVE;
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				funcNewAction(formObj, false);
				ComOpenWait(false);
			}
			break;

		case MULTI01: // Trans per B/L
			if (!ComShowCodeConfirm("BKG95003", "trans per B/L")) return;
			if (!validateForm(sheetObj, formObj, sAction)) return;
			var doProcess = false;
			// B/L NO CHECK
			if (formObj.bl_no.value.length < 11) {
				ComShowCodeMessage("BKG00266");
				formObj.bl_no.focus();
				doProcess = false;
			} else if (formObj.in_type.value == "A" || formObj.in_type.value == "B") {
				if (formObj.trans_pre_cnt.value != "0") {
					doProcess = ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
				} else {
					doProcess = true;
				}
			} else {
				doProcess=true;
			}
			if (doProcess) {
				formObj.call_knt.value = ComLpad(formObj.call_knt.value, 3, "0");
				if (formObj.call_knt.value.length < 3 || formObj.call_knt.value == "000") {
					ComShowCodeMessage("COM130201", "입항횟수");
					formObj.call_knt.focus();
					return false;
				} else if (formObj.io_tml_loc_cd.value.trim().length < 2) {
					ComShowCodeMessage("BKG50482");
					formObj.io_tml_loc_cd.focus();
					return false;
				} else {
					formObj.f_cmd.value = MULTI05;
					ComOpenWait(true);
					var sXml=sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
					sheetObj.LoadSaveData(sXml, {Sync:1});
					ComOpenWait(false);
				}
			}
			break;

		case MULTI07: // Cancel Per B/L
			if (!ComShowCodeConfirm("BKG95003", "cancel per B/L")) return;
			if (!validateForm(sheetObj, formObj, sAction)) return;
			var doProcess = false;
			// B/L NO CHECK
			if (formObj.bl_no.value.length < 11) {
				ComShowCodeMessage("BKG00266");
				formObj.bl_no.focus();
				doProcess=false;
			} else if (formObj.in_type.value == "A" || formObj.in_type.value == "B") {
				if (formObj.trans_pre_cnt.value != "0") {
					doProcess = ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
				}else {
					doProcess = true;
				}
			} else {
				doProcess=true;
			}
			if (doProcess) {
				formObj.f_cmd.value = MULTI07;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveData(sXml, {Sync:1});
				ComOpenWait(false);
			}
			break;

		case MULTI02: // Trans Amendment to PA
			if (!ComShowCodeConfirm("BKG95003", "trans amendment to PA")) return;
			if (!validateForm(sheetObj, formObj, sAction)) return;
			var doProcess=true;
			if (formObj.in_type.value == "A" || formObj.in_type.value == "B") {
				if (formObj.trans_pre_cnt.value!="0") {
					doProcess=ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
				}
			}
			if (doProcess) {
				formObj.f_cmd.value=MULTI02;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
			}
			break;

		case MULTI03: // Trans Cancellation to PA
			if (!ComShowCodeConfirm("BKG95003", "trans cancellation to PA")) return;
			if (!validateForm(sheetObj, formObj, sAction)) return;
			var doProcess=true;
			if (formObj.in_type.value == "A" || formObj.in_type.value == "B") {
				if (formObj.trans_pre_cnt.value!="0") {
					doProcess=ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
				}
			}
			if (doProcess) {
				formObj.f_cmd.value = MULTI02;
				// Initialize the parameter
				formObj.cancel_flg.value = "ZD";
				formObj.in_chg_meth.value = "";
				formObj.in_chg_comp.value = "";
				formObj.in_chg_port.value = "";
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
			}
			break;

		case MULTI04: // Discharge
			if (!validateForm(sheetObj, formObj, sAction)) return;
			formObj.f_cmd.value = MULTI04;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
			break;

		case MULTI05: // Trans manifest
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
if (formObj.ff_div.value == "3G") {
	if (!ComShowCodeConfirm("BKG95003", "trans manifest - 3G format")) return;
} else {
	if (!ComShowCodeConfirm("BKG95003", "trans manifest - 4G format")) return;
}
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
			if (!validateForm(sheetObj, formObj, sAction)) return;
			var doProcess = true;
			var transResult = true;
			var sXml;
			if (formObj.in_type.value == "A" || formObj.in_type.value == "B") {
				if (formObj.trans_pre_cnt.value != "0") {
					doProcess = ComShowConfirm("Attention! \nIf you proceed it with type A or B only, t/s cargo will not be transmitted to Port authority/Customs. \nDo you still want to trasmit manifest as it is?");
				}
			}
			if (doProcess) {
				// Discharge if Inbound
//				if (formObj.io_bnd_cd[0].checked && (formObj.trans_target.value=="A" || formObj.trans_target.value=="D") ) {
//					formObj.f_cmd.value=MULTI04;
//					ComOpenWait(true);
//					sXml=sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
//					transResult=ComBkgErrMessage(sheetObj, sXml);
//					ComOpenWait(false);
//				}
				// NOT transmit if TransTarget value us "D"
				if (transResult == true && formObj.trans_target.value != "D") {
					formObj.call_knt.value = ComLpad(formObj.call_knt.value, 3, "0");
					if (formObj.call_knt.value.length < 3 || formObj.call_knt.value == "000") {
						ComShowCodeMessage("COM130201", "입항횟수");
						formObj.call_knt.focus();
						return false;
					} else if (formObj.io_tml_loc_cd.value.trim().length < 2) {
						ComShowCodeMessage("BKG50482");
						formObj.io_tml_loc_cd.focus();
						return false;
					} else {
						formObj.f_cmd.value = MULTI05;
						ComOpenWait(true);
						var sXml = sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
						transResult = ComBkgErrMessage(sheetObj, sXml);
						ComOpenWait(false);
					}
				}
				if (transResult) {
					ComShowCodeMessage("BKG00204");
				}
			}
			break;

		case MULTI06:
			if (!validateForm(sheetObj, formObj, sAction)) return;
			if (formObj.ib_bl_cnt.value < 1) {
				ComShowCodeMessage("BKG01096");
			} else {
				formObj.f_cmd.value=MULTI06;
				ComOpenWait(true);
				formObj.receiver.value=formObj.in_receiver.value;
				var sXml = sheetObj.GetSaveData("ESM_BKG_0344GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
			}
			break;

		case IBDOWNEXCEL:      // Insert
			if (sheetObj.RowCount() < 1) {//no data
				ComShowCodeMessage("COM132501");
			} else {
				sheetObj.Down2Excel({ HiddenColumn:1});
			}
			break;
	}
}


/**
 * handling event after searching
 */
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
	var formObj = document.form;
	var vvd = formObj.vvd.value;
	var polcd = formObj.pol_cd.value;
	var polYdCd = formObj.pol_yd_cd.value;
	var podcd = formObj.pod_cd.value;
	var tmlCd = formObj.tml_cd.value;
	var inType = formObj.in_type.value;
	var blNo = formObj.bl_no.value;
	var ioBndCd = formObj.io_bnd_cd.value;

	if (Code < 0) {
		funcNewAction(formObj, false);
		formObj.io_bnd_cd.value = ioBndCd;
		checkBoundCd(formObj);
		formObj.vvd.value = vvd;
		formObj.pol_cd.value = polcd;
		formObj.pol_yd_cd.value = polYdCd;
		formObj.pod_cd.value = podcd;
		formObj.tml_cd.value = tmlCd;
		formObj.in_type.value = inType;
		formObj.bl_no.value = blNo;
		return;
	}
	if (sheetObj.GetEtcData("mrn_no") == " ") {
		//funcNewAction(formObj, false);
	} else {
		funcNewAction(formObj, true);
		// for Rollback
		ComEtcDataToForm(formObj, sheetObj);
		formObj.old_eta_dt.value = sheetObj.GetEtcData("eta_dt");
		// Rollback the retrieve data
		formObj.tml_cd.value = tmlCd;
		formObj.pol_yd_cd.value = polYdCd;
		formObj.in_type.value = inType;
		// Set to Combo
		comboObjects[1].SetSelectCode(sheetObj.GetEtcData("dchg_mzd_cd"));
		// Initialize the parameter
		formObj.cancel_flg.value = "";
		formObj.in_chg_meth.value = "";
		formObj.in_chg_comp.value = "";
		formObj.in_chg_port.value = "";
	}
	// input the comma(",")
	formObj.ttl_wgt.value = ComAddComma(formObj.ttl_wgt.value);
	formObj.ttl_pck_qty.value = ComAddComma(formObj.ttl_pck_qty.value);
	formObj.ttl_meas_qty.value = ComAddComma(formObj.ttl_meas_qty.value);
}


function funcChange(changeCode) {
	var form = document.form;
	if (changeCode == "ZH3") {
		form.in_chg_comp.value = changeCode;
	} else if(changeCode == "ZH2") {
		form.in_chg_port.value = changeCode;
	} else if(changeCode == "ZH1") {
		form.in_chg_meth.value = changeCode;
	} else if (changeCode == "AI") {
		form.in_chg_eta.value = changeCode;
	}
}


/**
 * Initialize
 */
function funcNewAction(formObj, op) {
	if (op) {
		ComBtnEnable("btn_Save");
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
	ComBtnEnable("btn_TransManifest_3G");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
		ComBtnEnable("btn_TransManifest");
		ComBtnEnable("btn_DeleteManifest");
		ComBtnEnable("btn_TransperBL");
		//ComBtnEnable("btn_CancelperBL");
		//ComBtnEnable("btn_TransAmendToPA");
		//ComBtnEnable("btn_TransCancellationToPA");
	} else {
		ComResetAll();
		ComBtnDisable("btn_Save");
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
	ComBtnDisable("btn_TransManifest_3G");
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
		ComBtnDisable("btn_TransManifest");
		ComBtnDisable("btn_DeleteManifest");
		ComBtnDisable("btn_TransperBL");
		//ComBtnDisable("btn_CancelperBL");
		//ComBtnDisable("btn_TransAmendToPA");
		//ComBtnDisable("btn_TransCancellationToPA");

		// Combo Initialize
		comboObjects[0].SetSelectCode("0");
		comboObjects[1].SetSelectCode("");
		checkBoundCd(formObj);
	}
}


/**
 * Combo Initialize
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	switch(comboObj.options.id) {
	case "combo1":
		with (comboObj) {
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "50");
			SetColWidth(1, "130");
			SetDropHeight(200);
			SetTitle("Type|Description");
			SetMultiSelect(0);
			SetMaxSelect(1 );
			InsertItem(cnt++, "All|관세청 + 해양항만청", "0");
			InsertItem(cnt++, "PA|해양항만청", "1");
		}
		break;
	case "combo2":
		with (comboObj) {
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "50");
			SetColWidth(1, "90");
			SetDropHeight(200);
			SetTitle("Type|Description");
			SetMultiSelect(0);
			SetMaxSelect(1 );
			InsertItem(cnt++, "1|일반하역", "1");
			InsertItem(cnt++, "2|기계하역", "2");
			InsertItem(cnt++, "3|송유관 하역", "3");
			InsertItem(cnt++, "4|무연탄 하역", "4");
		}
		break;
	}
}


function combo1_OnChange(comboObj, oldtext, oldcode, newindex, newtext, newcode) {
	 document.form.in_receiver.value = newcode;
}


function combo2_OnChange(comboObj, oldtext, oldcode, newindex, newtext, newcode) {
	document.form.dchg_mzd_cd.value = newcode;
	funcChange("ZH1");
}


function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}


function transTargetChange(){
	if (document.form.trans_target.value == "D") {
		document.all.btn_TransManifest.innerHTML="Trans Discharge";
	} else {
		document.all.btn_TransManifest.innerHTML="Trans Manifest";
	}
}
