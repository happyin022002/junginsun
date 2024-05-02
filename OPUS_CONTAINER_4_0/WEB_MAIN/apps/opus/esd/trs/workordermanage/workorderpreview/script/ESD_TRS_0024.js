/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0024.js
 *@FileTitle  : W/O Issue Preview
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/09
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var prefix_confirm_all = "confirm_all_";

document.onclick = function () {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_reset": {
				resetForm(formObject, sheetObject);
				break;
			}
			case "btn_close": {
				ComClosePopup();
				break;
			}
			case "btn_print": {
				viewer.print({isServerSide : true});
				break;
			}
			case "btn_confirm": {
				if (formObject.isInquiry.value != 'Y') {
					doActionIBSheet(sheetObject, formObject, IBSAVE);
				}
				break;
			}
			case "btn_confirm_all": {
				if (formObject.isInquiry.value != 'Y') {
					doActionIBSheet(sheetObjects[3], formObject, IBBATCH);
				}
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
};

document.oncontextmenu= function() {
	  event.preventDefault();
	  return false;    
};

$(function () {
    $(document).keydown(function (e) {
        return (e.which || e.keyCode) != 116;
    });
});


/**
 * Register IBSheet Object with array call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	var formObj = document.form;
	for (var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	if (!ComIsEmpty(init_searchStr)) {
		if (document.form.issued.value == 'N') {
			document.form.f_cmd.value = SEARCH01;
		} else {
			document.form.f_cmd.value = SEARCH02;
		}
		sheetObjects[0].DoSearch("ESD_TRS_0024GS.do", init_searchStr + '&' + TrsFrmQryString(document.form), { Sync : 2 });
	} else if (init_wo_searchStr != undefined && init_wo_searchStr != '') {
		sheetObjects[1].DoSearch("ESD_TRS_0025GS.do", init_wo_searchStr + '&f_cmd=' + SEARCH02, { Sync : 2 });
		document.form.f_cmd.value = SEARCH02;
		var queryStr = sheetObjects[1].GetSaveString(true, false);
		sheetObjects[0].DoSearch("ESD_TRS_0024GS.do", queryStr + '&' + TrsFrmQryString(document.form), { Sync : 2 });
	}
	var comboObj = wo_group_no;
	comboObj.SetDropHeight(200);
	comboObj.SetColAlign(0, "left");
	comboObj.RemoveAll();
	for ( var i = 0; i < sheetObjects[0].RowCount(); i++) {
		comboObj.InsertItem(i, sheetObjects[0].GetCellValue(i + 1, 'wo_iss_no'), sheetObjects[0].GetCellValue(i + 1, 'wo_iss_no'));
	}
	rdInit();
	wo_group_no.SetSelectIndex(0, true);
	formObj.rdserver_ip.value = RDServerIP;
	document.getElementById('total_page').innerHTML = '/ ' + sheetObjects[0].RowCount();
}

/**
 * 
 * @param sheetObj
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1: {
			with (sheetObj) {
				var HeadTitle = "||";
				SetConfig({ SearchMode : 2, MergeSheet : 2, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [ { Text : HeadTitle, Align : "Center" } ];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "CheckBox", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibcheck" },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "wo_prv_grp_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "wo_iss_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "wo_fmt_tp_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "wo_iss_sts_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "vndr_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "trsp_crr_mod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "trsp_wo_ofc_cty_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "trsp_wo_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "vndr_lgl_eng_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 200 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "cnt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "conti_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "trsp_bnd_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "trsp_cost_dtl_mod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "pre_dispatch", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "wo_instr_rmk", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 2000 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "wo_edi_use_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "inter_use_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "fax1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 100 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "fax2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 100 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "fax3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 100 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "eml1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 200 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "eml2", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 200 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "eml3", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 200 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "to_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "fm_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "dor_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "via_nod_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0, EditLen : 15 },
						{ Type : "Status", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibflag" }, 
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "wo_dtl_use_flg" },
						{ Type : "Text", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "edi_rcvr_nm_use_flg" }
				];
	
				InitColumns(cols);
				SetEditable(1);
				SetVisible(false);
			}
			break;
		}
		case 2: {
			with (sheetObj) {
				var HeadTitle = "ibflag|trsp_so_ofc_cty_cd|trsp_so_seq|wo_cxl_flg|dtn_use_flg|wo_bl_no_iss_flg|so_delt_flg";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [ { Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Status", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "ibflag" }, 
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "trsp_so_ofc_cty_cd" },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "trsp_so_seq" }, 
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "wo_cxl_flg" },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "dtn_use_flg" }, 
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "wo_bl_no_iss_flg" },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "so_delt_flg" }
				];
	
				InitColumns(cols);
				SetEditable(0);
				SetVisible(false);
			}
			break;
		}
		case 3: {
			with (sheetObj) {
				var HeadTitle = "ibflag|wo_edi_flg|conti_cd";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, FrozenCol : 0, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
				var headers = [ { Text : HeadTitle, Align : "Center" } ];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Status", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "ibflag" }, 
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "wo_edi_flg" },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 1, SaveName : "conti_cd" }
				];
				InitColumns(cols);
				SetEditable(0);
				SetVisible(false);
			}
			break;
		}
		case 4: {
			with (sheetObj) {
				var HeadTitle = "ibcheck|ibflag|wo_prv_grp_seq|wo_iss_no|wo_fmt_tp_cd|wo_iss_sts_cd|wo_vndr_seq|trsp_wo_ofc_cty_cd|trsp_wo_seq|conti_cd|trsp_crr_mod_cd|trsp_cost_dtl_mod_cd"
					          + "|wo_rmk|wo_edi_use_flg|wo_n1st_fax_no|wo_n2nd_fax_no|wo_n3rd_fax_no|fax_app_cd|fax_param|fax_rcv_info|rdserver_ip|wo_n1st_eml|wo_n2nd_eml|wo_n3rd_eml"
					          +	"|email_contents|email_title|wo_eml_use_flg|wo_fax_use_flg|wo_dtl_use_flg|wo_cxl_flg|scg_grp_seq|rt_dp_use_flg|cmdt_dp_use_flg|fax_title|fax_batch_ind|fax_sys_cd|draft_flg";
				SetConfig({ SearchMode : 0 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [ { Text : HeadTitle, Align : "Center" } ];
				InitHeaders(headers, info);
				var cols = [
						{ Type:"CheckBox", Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "ibcheck" },
						{ Type:"Status",   Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "ibflag" }, 
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_prv_grp_seq", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_iss_no", 			KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_fmt_tp_cd", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_iss_sts_cd", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_vndr_seq", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "trsp_wo_ofc_cty_cd", 	KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "trsp_wo_seq", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "conti_cd", 			KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "trsp_crr_mod_cd", 	KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "trsp_cost_dtl_mod_cd",KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_rmk",         		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_edi_use_flg", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_n1st_fax_no", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_n2nd_fax_no", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_n3rd_fax_no", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "fax_app_cd", 			KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "fax_param", 			KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "fax_rcv_info", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "rdserver_ip", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_n1st_eml", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_n2nd_eml", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_n3rd_eml", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "email_contents", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "email_title", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_eml_use_flg", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_fax_use_flg", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_dtl_use_flg", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "wo_cxl_flg", 			KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "scg_grp_seq", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "rt_dp_use_flg", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "cmdt_dp_use_flg", 	KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "fax_title", 			KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "fax_batch_ind", 		KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "fax_sys_cd", 			KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 },
						{ Type:"Text",     Hidden:0, Width:30, Align:"Center", ColMerge:1, SaveName:prefix_confirm_all + "draft_flg", 			KeyField:0, CalcLogic:"", Format:"", PointCount:0, UpdateEdit:0, InsertEdit:0 }
				];
	
				InitColumns(cols);
				SetEditable(1);
				SetVisible(false);
			}
			break;
		}
	}
}
/**
 * Opening the corresponding mrd file when selecting an invoice grouped
 */
function rdOpen(formObj) {
	var comboObj = wo_group_no;
	if (comboObj.GetSelectCode() == '') {
		return;
	}
	var comboSelectSheetRow = getSelectSheetRow(sheetObjects[0], comboObj.GetSelectText());
	var wo_format = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_fmt_tp_cd');
	var wo_page = '';
	var suffix = '_S';
	var prefix = 'USA_';
	var prefix_a = 'ASIA_';
	var prefix_e = 'EUR_';
	var RT_DP_USE_FLG_VALUE = (formObj.RT_DP_USE_FLG[0].checked ? 'Y' : 'N');
	var PRE_DIS_USE_FLG_VALUE = 'N';
	if (wo_format == 'NC') {
		wo_page = 'WO_NORMAL';
	} else if (wo_format == 'MM') {
		wo_page = 'WO_EMPTY';
		suffix = '';
	}
	if (!formObj.WO_DTL_USE_FLG.checked) {
		wo_page += suffix;
	}
	var contiCd = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'conti_cd');
	if (contiCd == "M") {
		if (wo_format == 'NC' || wo_format == 'MM') {
			wo_page = prefix + wo_page;
		}
	} else if (contiCd == "A") {
		wo_page = prefix_a + wo_page;
	} else if (contiCd == "E") {
		wo_page = prefix_e + wo_page;
	}
	var iDraftFlag = formObj.draft_flg.value;
	var woIssStsCdFlag = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_iss_sts_cd');
	if(iDraftFlag == 'DF' && woIssStsCdFlag == 'N') {
		iDraftFlag = '';
	}
	var rdParam = '/rp [' + RT_DP_USE_FLG_VALUE + ']';
	rdParam += '[' + sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_prv_grp_seq') + ']';
	rdParam += '[' + sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_iss_no') + ']';
	rdParam += '[' + formObj.FORM_USR_OFC_CD.value + ']';
	rdParam += '[' + formObj.FORM_CRE_USR_ID.value + ']';
	rdParam += '[' + PRE_DIS_USE_FLG_VALUE + ']';
	rdParam += '[' + wo_page + ']';
	rdParam += '[' + sheetObjects[0].GetCellValue(comboSelectSheetRow, 'conti_cd') + ']';
	rdParam += '[' + iDraftFlag + ']';
	viewer.openFile(RD_path + 'apps/opus/esd/trs/workordermanage/workorderpreview/report/' + wo_page + '.mrd', RDServer + rdParam + "/rfonttype60",{timeout:1800});
	viewer.setDownloadFileName(wo_page);
}
function setWoDtlUseFlg(obj) {
	var sheetObj = sheetObjects[0];
	var comboObj = wo_group_no;
	var comboSelectSheetRow = getSelectSheetRow(sheetObj, comboObj.GetSelectText());
	if (obj.checked) {
		sheetObj.SetCellValue(comboSelectSheetRow, 'wo_dtl_use_flg', '1');
	} else {
		sheetObj.SetCellValue(comboSelectSheetRow, 'wo_dtl_use_flg', '2');
	}
}
/**
 * Initailizing RD environment
 */
function rdInit() {
	viewer.hideToolbarItem(["xls", "hwp", "ppt", "doc"]);
}

/**
 * Event occurred when selecting an invoice group
 */
function wo_group_no_OnChange(obj, code, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	var comboObj = wo_group_no;

	var comboSelectSheetRow = getSelectSheetRow(sheetObj, comboObj.GetSelectText());
	setEDIform(sheetObj, formObj);
	if (sheetObj.GetCellValue(comboSelectSheetRow, 'ibcheck') == 1) {
		ComShowCodeMessage('TRS90136');
	}
	if ((sheetObj.GetCellValue(comboSelectSheetRow, 'conti_cd') == 'E' && sheetObj.GetCellValue(comboSelectSheetRow, 'wo_dtl_use_flg') == '') || sheetObj.GetCellValue(comboSelectSheetRow, 'wo_dtl_use_flg') == '1') {
		formObj.WO_DTL_USE_FLG.checked = true;
		sheetObj.SetCellValue(comboSelectSheetRow, 'wo_dtl_use_flg', '1');
	} else {
		formObj.WO_DTL_USE_FLG.checked = false;
		sheetObj.SetCellValue(comboSelectSheetRow, 'wo_dtl_use_flg', '0');
	}
	formObj.WO_RMK.value = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_instr_rmk');
	formObj.WO_N1ST_FAX_NO.value = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'fax1');
	formObj.WO_N2ND_FAX_NO.value = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'fax2');
	formObj.WO_N3RD_FAX_NO.value = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'fax3');
	formObj.WO_N1ST_EML.value = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'eml1');
	formObj.WO_N2ND_EML.value = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'eml2');
	formObj.WO_N3RD_EML.value = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'eml3');
	if (formObj.WO_N1ST_EML.value != "") {
		formObj.WO_EML_USE_FLG.checked = true;
	} else {
		formObj.WO_EML_USE_FLG.checked = false;
	}
	if (formObj.WO_N1ST_FAX_NO.value != "") {
		formObj.WO_FAX_USE_FLG.checked = true;
	} else {
		formObj.WO_FAX_USE_FLG.checked = false;
	}
		 
	rdOpen(document.form);
}

function setRmk(obj) {
	var comboObj = wo_group_no;
	var comboSelectSheetRow = getSelectSheetRow(sheetObjects[0], comboObj.GetSelectText());
	sheetObjects[0].SetCellValue(comboSelectSheetRow, 'wo_instr_rmk', obj.value, 0);
}


function setFaxToSheet(obj, field) {
	var comboObj = wo_group_no;
	var comboSelectSheetRow = getSelectSheetRow(sheetObjects[0], comboObj.GetSelectText());
	sheetObjects[0].SetCellValue(comboSelectSheetRow, field, obj.value, 0);
}

/**
 * 
 * @param obj
 * @param field
 */
function setEmailToSheet(obj, field) {
	if(!checkEmailValue(obj)){
		return;
	}
	var comboObj = wo_group_no;
	var comboSelectSheetRow = getSelectSheetRow(sheetObjects[0], comboObj.GetSelectText());
	sheetObjects[0].SetCellValue(comboSelectSheetRow, field, obj.value, 0);
}

/**
 * Setting the form checking whether EDI or not
 */
function setEDIform(sheetObj, formObj) {
	var comboObj = wo_group_no;
	var comboSelectSheetRow = getSelectSheetRow(sheetObjects[0], comboObj.GetSelectText());
	var vndr_seq = sheetObj.GetCellValue(comboSelectSheetRow, 'vndr_seq');
	var trsp_cost_dtl_mod_cd = sheetObj.GetCellValue(comboSelectSheetRow, 'trsp_cost_dtl_mod_cd');
	var fm_nod_cd = sheetObj.GetCellValue(comboSelectSheetRow, 'fm_nod_cd');
	var to_nod_cd = sheetObj.GetCellValue(comboSelectSheetRow, 'to_nod_cd');
	var trsp_bnd_cd = sheetObj.GetCellValue(comboSelectSheetRow, 'trsp_bnd_cd');
	var trsp_wo_ofc_cty_cd = sheetObj.GetCellValue(comboSelectSheetRow, 'trsp_wo_ofc_cty_cd');
	
	var woEdiUseFlg = sheetObj.GetCellValue(comboSelectSheetRow, 'wo_edi_use_flg');
	var ediRcvrNmUseFlg = sheetObj.GetCellValue(comboSelectSheetRow, 'edi_rcvr_nm_use_flg');
	if(woEdiUseFlg == 'Y'&& formObj.draft_flg.value != 'DF') {
		formObj.WO_EDI_USE_FLG.disabled = false;
		formObj.WO_EDI_USE_FLG.checked = true;
	} else {
		formObj.WO_EDI_USE_FLG.disabled = true;
		formObj.WO_EDI_USE_FLG.checked = false;	
	}
}

/**
 * Saving the value when PREDISPATCH is clicked
 */
function clickPreDisPatch(obj) {
	var sheetObj = sheetObjects[0];
	var comboObj = wo_group_no;
	var comboSelectSheetRow = getSelectSheetRow(sheetObj, comboObj.GetSelectText());
	if (obj.checked) {
		sheetObj.SetCellValue(comboSelectSheetRow, 'pre_dispatch', 'Y', 0);
	} else {
		sheetObj.SetCellValue(comboSelectSheetRow, 'pre_dispatch', 'N', 0);
	}
	rdOpen(document.form);
}
/**
 * Saving the value when INTERNAL_USE_FLG is clicked
 */
function clickInterUse(obj) {
	var sheetObj = sheetObjects[0];
	var comboObj = wo_group_no;
	var comboSelectSheetRow = getSelectSheetRow(sheetObj, comboObj.GetSelectText());
	if (obj.checked) {
		sheetObj.SetCellValue(comboSelectSheetRow, 'inter_use_flg', 'Y', 0);
	} else {
		sheetObj.SetCellValue(comboSelectSheetRow, 'inter_use_flg', 'N', 0);
	}
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		switch (sAction) {
			case IBSAVE: {
				var comboObj = wo_group_no;
				if (comboObj.GetSelectCode() == '')
					return false;
				var comboSelectSheetRow = getSelectSheetRow(sheetObj, comboObj.GetSelectText());
				if (sheetObj.GetCellValue(comboSelectSheetRow, 'ibcheck') == 1) {
					ComShowCodeMessage('TRS90136');
					return false;
				}
				if(formObj.WO_EML_USE_FLG.checked) {
					if(ComIsNull(formObj.WO_N1ST_EML.value) && ComIsNull(formObj.WO_N2ND_EML.value) && ComIsNull(formObj.WO_N3RD_EML.value)) {
						ComShowCodeMessage('TRS90432');
						return false;
					}
				}
				if(formObj.WO_FAX_USE_FLG.checked) {
					if(ComIsNull(formObj.WO_N1ST_FAX_NO.value) && ComIsNull(formObj.WO_N2ND_FAX_NO.value) && ComIsNull(formObj.WO_N3RD_FAX_NO.value)) {
						ComShowCodeMessage('TRS90433');
						return false;
					}
				}
				
				ComOpenWait(true);
				if (formObj.issued.value == 'Y') {
					formObj.f_cmd.value = MULTI01;
					if(ComIsNull(sheetObj.GetCellValue(comboSelectSheetRow, 'trsp_wo_ofc_cty_cd'))) {
						ComShowCodeMessage('TRS90433');
						return false;
					}
				} else {
					formObj.f_cmd.value = ADD;
				}
				formObj.WO_FMT_TP_CD.value = sheetObj.GetCellValue(comboSelectSheetRow, 'wo_fmt_tp_cd');
				formObj.WO_PRV_GRP_SEQ.value = sheetObj.GetCellValue(comboSelectSheetRow, 'wo_prv_grp_seq');
				formObj.WO_ISS_NO.value = sheetObj.GetCellValue(comboSelectSheetRow, 'wo_iss_no');
				formObj.WO_ISS_STS_CD.value = sheetObj.GetCellValue(comboSelectSheetRow, 'wo_iss_sts_cd');
				formObj.WO_VNDR_SEQ.value = sheetObj.GetCellValue(comboSelectSheetRow, 'vndr_seq');
				formObj.TRSP_WO_OFC_CTY_CD.value = sheetObj.GetCellValue(comboSelectSheetRow, 'trsp_wo_ofc_cty_cd');
				formObj.TRSP_WO_SEQ.value = sheetObj.GetCellValue(comboSelectSheetRow, 'trsp_wo_seq');
				formObj.EMAIL_CONTENTS.value = getEmailContents(sheetObj.GetCellValue(comboSelectSheetRow, 'vndr_lgl_eng_nm'));
				formObj.TRSP_CRR_MOD_CD.value = sheetObj.GetCellValue(comboSelectSheetRow, 'trsp_crr_mod_cd');
				formObj.TRSP_COST_DTL_MOD_CD.value = sheetObj.GetCellValue(comboSelectSheetRow, 'trsp_cost_dtl_mod_cd');
				formObj.EMAIL_TITLE.value = 'WORK ORDER for Reference ';
				formObj.CONTI_CD.value = sheetObj.GetCellValue(comboSelectSheetRow, 'conti_cd');
				var wo_format = sheetObj.GetCellValue(comboSelectSheetRow, 'wo_fmt_tp_cd');
				var wo_page = '';
				var suffix = '_S';
				var prefix = 'USA_';
				var prefix_a = 'ASIA_';
				var prefix_e = 'EUR_';
				var RT_DP_USE_FLG_VALUE = (formObj.RT_DP_USE_FLG[0].checked ? 'Y' : 'N');
				var PRE_DIS_USE_FLG_VALUE = 'N';
				if (wo_format == 'NC') {
					wo_page = 'WO_NORMAL';
				} else if (wo_format == 'MM') {
					wo_page = 'WO_EMPTY';
					suffix = '';
				}
				if (!formObj.WO_DTL_USE_FLG.checked) {
					wo_page += suffix;
				}
	
				var condi = sheetObjects[0].GetCellValue(comboSelectSheetRow, 'conti_cd');
				if ( condi == 'M') {
					if (wo_format == 'NC' || wo_format == 'MM') {
						wo_page = prefix + wo_page;
					}
				} else if (condi == 'A') {
					wo_page = prefix_a + wo_page;
				} else if (condi == 'E') {
					wo_page = prefix_e + wo_page;
				}
	
				var rdParam = '[' + RT_DP_USE_FLG_VALUE + ']';
				rdParam += '[' + sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_prv_grp_seq') + ']';
				rdParam += '[' + sheetObjects[0].GetCellValue(comboSelectSheetRow, 'wo_iss_no') + ']';
				rdParam += '[' + formObj.FORM_USR_OFC_CD.value + ']';
				rdParam += '[' + formObj.FORM_CRE_USR_ID.value + ']';
				rdParam += '[' + PRE_DIS_USE_FLG_VALUE + ']';
				rdParam += '[' + wo_page + ']';
				rdParam += '[' + sheetObjects[0].GetCellValue(comboSelectSheetRow, 'conti_cd') + ']';
				rdParam += '[' + formObj.draft_flg.value + ']';
				
				formObj.FAX_APP_CD.value = wo_page + '.mrd';
				formObj.FAX_PARAM.value = rdParam;
				formObj.FAX_RCV_INFO.value = sheetObj.GetCellValue(comboSelectSheetRow, 'vndr_lgl_eng_nm');
				formObj.rdserver_ip.value = RDServerIP;
				if (formObj.issued.value == 'Y') {
					sheetObj.DoAllSave("ESD_TRS_0024GS.do", TrsFrmQryString(formObj), { Sync : 2 });
				} else {
					if (searchSOStatus(formObj)) {
						formObj.f_cmd.value = ADD;
						sheetObj.DoAllSave("ESD_TRS_0024GS.do", TrsFrmQryString(formObj), { Sync : 2 });
					}
				}
				ComOpenWait(false);
				break;
			}
			case IBBATCH: {
				ComOpenWait(true);
				if(checkEmailFaxEdiForConfirmAll(sheetObjects[0])) {
					if (formObj.issued.value == 'Y') { // ISSUED
						formObj.f_cmd.value = MULTI02;
						if(setConfirmAllSaveData()) {
							// 2. Save to Server
							sheetObj.DoAllSave("ESD_TRS_0024GS.do", TrsFrmQryString(formObj), { Sync : 2 });	
						}
					} else {							// NOT ISSUED
						if (searchSOStatus(formObj)) { // CHECK S/O STATUS
							formObj.f_cmd.value = MULTI03;
							if(setConfirmAllSaveData()) {
								// 2. Save to Server
								sheetObj.DoAllSave("ESD_TRS_0024GS.do", TrsFrmQryString(formObj), { Sync : 2 });	
							}
						}
					}
				}
				ComOpenWait(false);
				break;
			}
		}
	} catch (e) {
		ComOpenWait(false);
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js
 */
function sheet_OnSaveEnd(sheetObj, errCode, errMsg) {
	var comboObj = wo_group_no;
	var comboSelectSheetRow = getSelectSheetRow(sheetObj, comboObj.GetSelectText());
	var formObj = document.form;
	var woGroupCode = comboObj.GetSelectCode();
	var sel_combo_idx = 0;
	var woPrvGrpSeq = "";
	var woIssNo = "";
	if( errCode >= 0) {
		ComShowCodeMessage('TRS90137');
		sheetObj.SetCellValue(comboSelectSheetRow, 'ibcheck', 1, 0);
		rdOpen(formObj); // RD Refresh
		
		woPrvGrpSeq = sheetObj.GetCellValue(comboSelectSheetRow, 'wo_prv_grp_seq');
		woIssNo = sheetObj.GetCellValue(comboSelectSheetRow, 'wo_iss_no');
		opener.processConfirmedWOData(woPrvGrpSeq, woIssNo);
		if (formObj.WO_PRN_USE_FLG.checked) {
			viewer.print({isServerSide : true});
		}
	}
}

/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js
 */
function sheet4_OnSaveEnd(sheetObj, errCode, errMsg) {
//	var comboObj = wo_group_no;
//	var comboSelectSheetRow = getSelectSheetRow(sheetObj, comboObj.GetSelectText());
	var formObj = document.form;
//	var woGroupCode = comboObj.GetSelectCode();
	var sel_combo_idx = 0;
	var woPrvGrpSeq = "";
	var woIssNo = "";
	if( errCode >= 0) {
//		sheetObj.SetCellValue(comboSelectSheetRow, 'ibcheck', 1, 0);
		var rows = sheetObjects[0].RowCount();
		for(var i = 1; i <= rows; i++) {
			sheetObjects[0].SetCellValue(i, 'ibcheck', 1, 0);
		}
		ComShowCodeMessage('TRS90137');
		rdOpen(formObj); // RD Refresh
		
		woPrvGrpSeq = sheetObjects[0].GetCellValue(1, 'wo_prv_grp_seq');
		woIssNo = sheetObjects[0].GetCellValue(1, 'wo_iss_no');
		opener.processConfirmedWOData(woPrvGrpSeq, woIssNo);
//		if (formObj.WO_PRN_USE_FLG.checked) {
//			viewer.print({isServerSide : true});
//		}
	}
}

/**
 * 
 * @param SheetObject
 * @param Row
 */
function sheet_OnRowSearchEnd(SheetObject, Row) {
	if (document.form.issued.value == 'Y') {
		if(ComIsEmpty(SheetObject.GetCellValue(Row, 'trsp_wo_ofc_cty_cd'))) {
			ComShowCodeMessage('TRS90493', 'W/O');
			ComClosePopup();
		}
	}
}
/**
 * Resetting the form options when reset button is clicked
 */
function resetForm(formObj, sheetObj) {
	formObj.WO_PRN_USE_FLG.checked = false;
	formObj.WO_EML_USE_FLG.checked = false;
	formObj.WO_FAX_USE_FLG.checked = false;
	formObj.RT_DP_USE_FLG[1].checked = true;
	formObj.CMDT_DP_USE_FLG.checked = true;
	formObj.WO_RMK.value = '';
	formObj.WO_N1ST_EML.value = '';
	formObj.WO_N2ND_EML.value = '';
	formObj.WO_N3RD_EML.value = '';
	formObj.WO_N1ST_FAX_NO.value = '';
	formObj.WO_N2ND_FAX_NO.value = '';
	formObj.WO_N3RD_FAX_NO.value = '';
}
/**
 * Getting the content of email
 */
function getEmailContents(vndr_nm) {
	var contents = '\n';
	contents += 'Dear ' + vndr_nm + '\n';
	contents += '\n';
	contents += 'Please refer to the attached file.\n';
	contents += 'Thank you.\n';
	contents += '\n';
	contents += 'NYK LINE\n';
	return contents;
}
/**
 * Checking whether the s/o is deleted
 */
function searchSOStatus(formObj) {
	var sheetObject = sheetObjects[1];
	var soCheck = true;
	formObj.f_cmd.value = SEARCH;
	var queryStr = sheetObjects[1].GetSaveString(true, false);
	var rows = sheetObject.SearchRows();
	for (i = 0; i < rows + 1; i++) {
		if (sheetObject.GetCellValue(i, "so_delt_flg") == 'Y') {
			soCheck = false;
		}
	}
	if (soCheck == false) {
		ComShowCodeMessage("TRS90403");
	}
	return soCheck;
}

/**
 * Number Of W/O To Issue 와 일치하는 Sheet 조회
 * 
 * @param sheetObjects
 * @param selectComboValue
 * @returns {Number}
 */
function getSelectSheetRow(sheetObjects, selectComboValue) {
	var sheetRow = 1;
	for ( var i = 1; i < sheetObjects.RowCount() + 1; i++) {
		if (sheetObjects.GetCellValue(i, 'wo_iss_no') == selectComboValue) {
			sheetRow = i;
			break;
		}
	}
	return sheetRow;
}

/**
 * Confirm All 수행 전에 E-Mail, FAX, EDI 중 최소 한 개 이상 발송되어야 함을 확인한다.
 * 
 * @param sheetObject
 * @returns {boolean}
 */
function checkEmailFaxEdiForConfirmAll(sheetObject) {
	var formObj = document.form;
	var logString = "E-Mail | FAX | EDI | DRAFT";
	var check_flg = false;
	var check_vendor = "";
	var result = true;
	// E-Mail, FAX, EDI 중 최소 한 개 이상 선택되어 있는지 여부를 확인
	for ( var i = 1; i < sheetObject.RowCount() + 1; i++) {
		logString += "\n" + sheetObject.GetCellValue(i, 'eml1') + " | " + sheetObject.GetCellValue(i, 'fax1') + " | "+ sheetObject.GetCellValue(i, 'wo_edi_use_flg') + " | "+ formObj.draft_flg.value;
		if(sheetObject.GetCellValue(i, 'eml1').length < 1 
			&&  sheetObject.GetCellValue(i, 'fax1').length < 1
			&&	(sheetObject.GetCellValue(i, 'wo_edi_use_flg') != 'Y' ||  formObj.draft_flg.value == 'DF')) {
			check_flg = true;
			if(check_vendor.length > 0) {
				check_vendor += ", ";
			}
			check_vendor += "'" + sheetObject.GetCellValue(i, 'vndr_lgl_eng_nm') + "(" + sheetObject.GetCellValue(i, 'vndr_seq') + ")'";
		}
	}
	//alert(logString);
	
	// E-Mail, FAX, EDI 중 어떤 것도 선택되어 있지 않다면, 경고 메세지를 띄운다.
	if(check_flg) {
		result = ComShowConfirm(ComGetMsg("TRS90507", check_vendor)); // There is nor EDI, E-mail or Fax setup for Service Provider A, B, C. Do you still want to issue all W/Os?
	}

	return result;
}

/**
 * generate Form QueryString in case of [Confirm All]
 * 
 * @param formObj
 * @returns Form QueryString
 */
function getFrmQryStrOfAllWrkOrd(formObj) {
	return TrsFrmQryString(formObj, "S");
}

function setConfirmAllSaveData() {
	var formObj = document.form;
	var wo_cnt = wo_group_no.GetItemCount();
	var sheetObj1 = sheetObjects[0];
	var sheetObj4 = sheetObjects[3];
	var qParam = "";
	
	sheetObj4.RemoveAll();
	
	// 1. Number Of W/O To Issue 별 
	for(var i = 0; i < wo_cnt; i ++) {
		// original Sheet row
		var row_ = sheetObj1.FindText('wo_iss_no', wo_group_no.GetText(i, 0));
		// when not matched then skip
		if(row_ == -1) 
			continue;
		// when already issued then skip
		if(sheetObj1.GetCellValue(row_, 'ibcheck') == 1) { 
			ComShowCodeMessage('TRS90136');
			return false;
			//continue;
		}
		// add one row in new Sheet
		var row = sheetObj4.DataInsert(-1);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'ibcheck', 1, 0);
		
		// 1.1. FORM ELEMENTS 세팅 ( Combo_change이벤트 + doActionIBSheet IBSAVE case )
		// 1.1.1. Combo_change이벤트
		var woEdiUseFlg = (sheetObj1.GetCellValue(row_, 'wo_edi_use_flg') == 'Y' &&  formObj.draft_flg.value != 'DF') ? "EDI" : "";
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_edi_use_flg', woEdiUseFlg, 0);
		
		var conti_cd = sheetObj1.GetCellValue(row_, 'conti_cd');
		var wo_dtl_use_flg = sheetObj1.GetCellValue(row_, 'wo_dtl_use_flg');
		var woDtlUseFlg = ((conti_cd == 'E' && wo_dtl_use_flg == '') || wo_dtl_use_flg == '1') ? "DTL" : "";
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_dtl_use_flg', woDtlUseFlg, 0);
		
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_rmk', sheetObj1.GetCellValue(row_, 'wo_instr_rmk'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_n1st_fax_no', sheetObj1.GetCellValue(row_, 'fax1'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_n2nd_fax_no', sheetObj1.GetCellValue(row_, 'fax2'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_n3rd_fax_no', sheetObj1.GetCellValue(row_, 'fax3'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_n1st_eml', sheetObj1.GetCellValue(row_, 'eml1'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_n2nd_eml', sheetObj1.GetCellValue(row_, 'eml2'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_n3rd_eml', sheetObj1.GetCellValue(row_, 'eml3'), 0);
		var woEmlUseFlg = (sheetObj1.GetCellValue(row_, 'eml1').length > 0) ? "EML" : "";
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_eml_use_flg', woEmlUseFlg, 0);
		var woFaxUseFlg = (sheetObj1.GetCellValue(row_, 'fax1').length > 0) ? "FAX" : "";
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_fax_use_flg', woFaxUseFlg, 0);
		
		// 1.1.2. doActionIBSheet IBSAVE case
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_fmt_tp_cd', sheetObj1.GetCellValue(row_, 'wo_fmt_tp_cd'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_prv_grp_seq', sheetObj1.GetCellValue(row_, 'wo_prv_grp_seq'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_iss_no', sheetObj1.GetCellValue(row_, 'wo_iss_no'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_iss_sts_cd', sheetObj1.GetCellValue(row_, 'wo_iss_sts_cd'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_vndr_seq', sheetObj1.GetCellValue(row_, 'vndr_seq'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'trsp_wo_ofc_cty_cd', sheetObj1.GetCellValue(row_, 'trsp_wo_ofc_cty_cd'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'trsp_wo_seq', sheetObj1.GetCellValue(row_, 'trsp_wo_seq'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'email_contents', getEmailContents(sheetObj1.GetCellValue(row_, 'vndr_lgl_eng_nm')), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'trsp_crr_mod_cd', sheetObj1.GetCellValue(row_, 'trsp_crr_mod_cd'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'trsp_cost_dtl_mod_cd', sheetObj1.GetCellValue(row_, 'trsp_cost_dtl_mod_cd'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'email_title', 'WORK ORDER for Reference ', 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'conti_cd', sheetObj1.GetCellValue(row_, 'conti_cd'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_rmk', sheetObj1.GetCellValue(row_, 'wo_instr_rmk'), 0);

		var wo_format = sheetObj1.GetCellValue(row_, 'wo_fmt_tp_cd');
		var wo_page = '';
		var suffix = '_S';
		var prefix = 'USA_';
		var prefix_a = 'ASIA_';
		var prefix_e = 'EUR_';
		var RT_DP_USE_FLG_VALUE = (formObj.RT_DP_USE_FLG[0].checked ? 'Y' : 'N');
		var PRE_DIS_USE_FLG_VALUE = 'N';
		if (wo_format == 'NC') {
			wo_page = 'WO_NORMAL';
		} else if (wo_format == 'MM') {
			wo_page = 'WO_EMPTY';
			suffix = '';
		}
		if (!formObj.WO_DTL_USE_FLG.checked) {
			wo_page += suffix;
		}

		var condi = sheetObj1.GetCellValue(row_, 'conti_cd');
		if ( condi == 'M') {
			if (wo_format == 'NC' || wo_format == 'MM') {
				wo_page = prefix + wo_page;
			}
		} else if (condi == 'A') {
			wo_page = prefix_a + wo_page;
		} else if (condi == 'E') {
			wo_page = prefix_e + wo_page;
		}

		var rdParam = '[' + RT_DP_USE_FLG_VALUE + ']';
		rdParam += '[' + sheetObj1.GetCellValue(row_, 'wo_prv_grp_seq') + ']';
		rdParam += '[' + sheetObj1.GetCellValue(row_, 'wo_iss_no') + ']';
		rdParam += '[' + formObj.FORM_USR_OFC_CD.value + ']';
		rdParam += '[' + formObj.FORM_CRE_USR_ID.value + ']';
		rdParam += '[' + PRE_DIS_USE_FLG_VALUE + ']';
		rdParam += '[' + wo_page + ']';
		rdParam += '[' + sheetObj1.GetCellValue(row_, 'conti_cd') + ']';
		rdParam += '[' + formObj.draft_flg.value + ']';

		sheetObj4.SetCellValue(row, prefix_confirm_all + 'fax_app_cd', wo_page + '.mrd', 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'fax_param', rdParam, 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'fax_rcv_info', sheetObj1.GetCellValue(row_, 'vndr_lgl_eng_nm'), 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'rdserver_ip', RDServerIP, 0);

		sheetObj4.SetCellValue(row, prefix_confirm_all + 'wo_cxl_flg', formObj.WO_CXL_FLG.value, 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'scg_grp_seq', formObj.SCG_GRP_SEQ.value, 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'rt_dp_use_flg', formObj.RT_DP_USE_FLG.value, 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'cmdt_dp_use_flg', formObj.CMDT_DP_USE_FLG.value, 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'fax_title', formObj.FAX_TITLE.value, 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'fax_batch_ind', formObj.FAX_BATCH_IND.value, 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'fax_sys_cd', formObj.FAX_SYS_CD.value, 0);
		sheetObj4.SetCellValue(row, prefix_confirm_all + 'draft_flg', formObj.draft_flg.value, 0);
		
		// 1.2. query string 추가
		// qParam += getFrmQryStrOfAllWrkOrd(formObj);
	}
	// when anything is not matched or already issued then skip
	if(sheetObj4.RowCount() < 1) {
		return false;
	}
	
	return true;
}