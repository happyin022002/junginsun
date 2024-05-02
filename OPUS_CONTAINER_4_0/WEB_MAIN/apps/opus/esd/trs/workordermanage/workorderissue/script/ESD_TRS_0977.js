/*
 *=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0977.js
 *@FileTitle  : Shipment Change Management
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/05
=========================================================
 */
/**
 * @class ESD_TRS_0977
 */
/**------------------From here the common JavaScript function is defined.     ------------------*/
/** Common global variable */
var sheetObjects = new Array();
var sheetCnt = 0;
var queryStr = "";
/** Event handler processing by button click event */
document.onclick = processButtonClick;
/** Event handler processing by button name */
var popOpenObj = opener;
if(!popOpenObj) {
	popOpenObj = parent;
}
var acceptCnt = 0; // Change Accept 적용 여부 확인을 위한 cnt

function processButtonClick() {
	/**
	 * ***Case more than two additional sheets tab sheet is used to specify a variable ****
	 */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		switch (srcName) {
			case "btn_ac_change": {
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			}
			case "btn_close": {
				// Change Accept가 실행되었을 경우에만 W/O Issue 화면 재검색
				if (acceptCnt != 0) {
					popOpenObj.afterChangeMgmt();
				}
				ComClosePopup();
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	queryStr= popOpenObj.sheet.GetSaveString(false, false, 'ibcheck');
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1:
		with (sheetObj) {
			var HeadTitle1 = "bkg_cng_group||BKG No.|trsp_cng_sub_seq|Container No.|Type/Size|S/O No.|trsp_so_ofc_cty_cd|trsp_so_seq|cng_cate_cd|Change Item|Change Item|Change Item|Change Item|Now Read| Previous|User Name|Office|Date|Date|bkg_trsp_so_ofc_cty_cd|bkg_trsp_so_seq|cng_ind_flg|bkg_cng_ind_flg|ibFlag";
			var HeadTitle2 = "bkg_cng_group||BKG No.|trsp_cng_sub_seq|Container No.|Type/Size|S/O No.|trsp_so_ofc_cty_cd|trsp_so_seq|cng_cate_cd|cng_cate_cd_desc|Category|cng_cate_sub_cd|Sub Category|Now Read| Previous|User Name|Office|Local|GMT|bkg_trsp_so_ofc_cty_cd|bkg_trsp_so_seq|cng_ind_flg|bkg_cng_ind_flg|ibFlag";

			SetConfig({ HeaderCheckMode : 1, SearchMode : 2, MergeSheet : 7, Page : 20, DataRowMerge : 0, PrevColumnMergeMode:0 });
			var info = { Sort : 0, ColMove : 0, HeaderCheck : 1, ColResize : 1 };
			var headers = [ { Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }];
			InitHeaders(headers, info);
			var cols = [
			                   
					{ Type : "Text", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "bkg_cng_group" },
					{ Type : "CheckBox", Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "ibcheck" },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "bkg_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 1, SaveName : "trsp_cng_sub_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "eq_no", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 1, SaveName : "eq_tpsz_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "trsp_so_ofc_cty_cd_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 1, SaveName : "trsp_so_ofc_cty_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 1, SaveName : "trsp_so_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 1, SaveName : "trsp_so_sub_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 1, SaveName : "cng_cate_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Left", ColMerge : 1, SaveName : "cng_cate_cd_desc", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 0, SaveName : "cng_cate_sub_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 100, Align : "Left", ColMerge : 0, SaveName : "cng_cate_sub_cd_desc", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 200, Align : "Left", ColMerge : 0, SaveName : "now_read_val", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 200, Align : "Left", ColMerge : 0, SaveName : "previous_val", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 0, SaveName : "usr_nm", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 80, Align : "Center", ColMerge : 0, SaveName : "ofc_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "locl_upd_dt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "upd_dt", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 0, SaveName : "bkg_trsp_so_ofc_cty_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 0, SaveName : "bkg_trsp_so_seq", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 0, SaveName : "cng_ind_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type : "Text", Hidden : 1, Width : 90, Align : "Center", ColMerge : 0, SaveName : "bkg_cng_ind_flg", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 0 },
					{ Type:"Status",  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" }	
			];
			InitColumns(cols);
			SetEditable(1);
			resizeSheet(sheetObj)
		}
		break;
	}
}

/**
 * Action Event
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0977GS.do", "f_cmd=" + SEARCH + "&" + queryStr, {Sync:2});
			break;
		}
		case IBSAVE: {
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var arrRow=checkList.split("|");
            if(checkList == '') {
                ComShowCodeMessage('COM12176');
                return false;
            }  
			formObj.f_cmd.value = MULTI;
			if (!ComIsNull(queryStr)) {
				sheetObj.DoAllSave("ESD_TRS_0977GS.do", queryStr + "&f_cmd=" + MULTI);
				acceptCnt++;
			}
			break;
		}
	}
}

/**
 * OnSearchEnd Event
 * 
 * @param sheetObj
 * @param errMsg
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
    if( errMsg != null && errMsg != '' ) {
        ComShowMessage(errMsg);
    }else{
		if (formObj.f_cmd.value == SEARCH) {
			for ( var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
				if (sheetObj.GetCellValue(i, "cng_ind_flg") == "N") {
					sheetObj.SetCellEditable(i, "ibcheck", false);
				}
			}
		}
    }
}

/**
 * OnSearchEnd Event
 * 
 * @param sheetObj
 * @param errMsg
 */
function sheet1_OnSaveEnd(Code, Msg, StCode, StMsg) {
	var formObj = document.form;
    if( Msg != null && Msg != '' ) {
        ComShowMessage(errMsg);
    }else{
		if (formObj.f_cmd.value == MULTI) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			ComShowCodeMessage('TRS90405');
		}
    }
}

function resizeSheet(sheetObj) {
    ComResizeSheet(sheetObj);
}