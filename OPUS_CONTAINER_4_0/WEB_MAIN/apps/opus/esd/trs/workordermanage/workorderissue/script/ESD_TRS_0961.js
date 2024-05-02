/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0961.js
 *@FileTitle  : Service Provider Select
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/12
=========================================================*/
/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0961 : SP SELECT Popup
 */
/*------------------ Defining general java script function   ------------------*/
// General global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var defaultLoginOfficeCurr = '';
var docObjects = new Array();

// 2014.12.15 Hyungwook Choi
var prefix = 'surcharge_';

document.onclick = processButtonClick;
var opener_obj = opener;
if (!opener_obj) {
	opener_obj = parent;
}

function processButtonClick() {
	/** *** Adding additional sheet variables to use more than one sheet per a tab **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_ok":
				doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
				break;
			case "btn_close":
				ComClosePopup();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Customor code
 */
function custCode() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	sheetObjects[0].SetCellValue(1, 'cust_cnt_cd_seq', formObj.cust_cnt_cd_seq.value);
}
/**
 * OFC CD Default Currency.
 */
function initCurrency() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	formObj.f_cmd.value = SEARCH01;
	sheetObj.DoRowSearch("ESD_TRS_0921GS.do", TrsFrmQryString(formObj));
}
/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	sheetObjects[0].DataInsert();
	initCurrency();
}
/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var formObj=document.form;
    var wo_radio_flg=true;
    if(formObj.wo_radio.value == 'Y') wo_radio_flg=false;
    switch(sheetNo) {
        case 1:      //t1sheet1 init
            with (sheetObj) {
            var HeadTitle="S/P\nCode|S/P\nName|T/Ship|Cargo\nNature|One Way/\nRound Trip|CNT|Customer\nCode|Default\nCurrency|Effective\nDate|Feeder Term\n(RCV / DEL)|Feeder Term\n(RCV / DEL)";

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"PopupEdit", Hidden:0, Width:70,  Align:"Center", ColMerge:0, SaveName:"vndr_seq",            KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:6 },
                         {Type:"Text",      Hidden:0, Width:100, Align:"Left",   ColMerge:0, SaveName:"vndr_nm",             KeyField:0, CalcLogic:"", Format:"",    PointCount:2, UpdateEdit:0, InsertEdit:0 },
                         {Type:"Combo",     Hidden:0, Width:40,  Align:"Center", ColMerge:1, SaveName:"trsp_bnd_cd",         KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:1 },
                         {Type:"Combo",     Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"spcl_cgo_cntr_tp_cd", KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:10 },
                         {Type:"Combo",     Hidden:0, Width:130, Align:"Center", ColMerge:0, SaveName:"po_way_type",         KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1 },
                         {Type:"Combo",     Hidden:0, Width:50,  Align:"Center", ColMerge:0, SaveName:"sp_type",             KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:"cust_cnt_cd_seq",     KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                         {Type:"Combo",     Hidden:0, Width:70,  Align:"Center", ColMerge:0, SaveName:"default_curr",        KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1 },
                         {Type:"Date",      Hidden:0, Width:90,  Align:"Center", ColMerge:0, SaveName:"eff_dt",              KeyField:0, CalcLogic:"", Format:"Ymd", PointCount:0, UpdateEdit:1, InsertEdit:1, EditLen:8 },
                         {Type:"Combo",     Hidden:0, Width:55,  Align:"Center", ColMerge:0, SaveName:"ft_receiving",        KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1 },
                         {Type:"Combo",     Hidden:0, Width:55,  Align:"Center", ColMerge:0, SaveName:"ft_delivery",         KeyField:0, CalcLogic:"", Format:"",    PointCount:0, UpdateEdit:1, InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:10,  Align:"Center", ColMerge:0, SaveName:"wo_edi_use_flg",      KeyField:0, CalcLogic:"", Format:"",    PointCount:2, UpdateEdit:0, InsertEdit:0 },
                         {Type:"Status",    Hidden:0, Width:0,   Align:"Center", ColMerge:1, SaveName:"ibflag" } ];
             
                InitColumns(cols);
    
                SetEditable(1);
                SetColHidden('ibflag',1);
                SetColProperty('trsp_bnd_cd',         {ComboText:"|Y|N",                              ComboCode:"|Y|N"} );
                SetColProperty('spcl_cgo_cntr_tp_cd', {ComboText:"|"+spcl_cgo_cntr_tp_cdCode,         ComboCode:"|"+spcl_cgo_cntr_tp_cdCode} );
                SetColProperty('po_way_type',         {ComboText:"|OneWay(CYrate)|RoundTrip(DRrate)", ComboCode:"|ONE|RND"} );
                SetColProperty('sp_type',             {ComboText:sp_typeText,                         ComboCode:sp_typeCode} );
                SetColProperty('default_curr',        {ComboText:default_currText,                    ComboCode:default_currCode} );
                SetColProperty('ft_receiving',        {ComboText:ft_receivingText,                    ComboCode:ft_receivingCode} );
                SetColProperty('ft_delivery',         {ComboText:ft_deliveryText,                     ComboCode:ft_deliveryCode} );
                SetColProperty("vndr_seq",            {AcceptKeys:"N"});
                SetColProperty("cust_cnt_cd_seq",     {AcceptKeys:"E|[0123456789]",                   InputCaseSensitive:1});
                SetShowButtonImage(4);
                ComResizeSheet(sheetObjects[0]);
            }
            break;
        case 2:      //sheet1 init
            with (sheetObj) {
           
                    var HeadTitle="flag|cty|seq|agmt_cty|agmt_seq|rt_tp_cd|way_type|rt_tp_nm|sp_type|cust_flg|cust_cnt|cust_seq|curr|basic|fuel|over_wgt|local_tot|usd_tot|rtn_cd|rtn_msg|etc_add";

                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);

                    var cols = [
                        {Type:"Status",    Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_trsp_agmt_ofc_cty_cd" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_trsp_agmt_seq" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_trsp_agmt_rt_tp_cd" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_way_type" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_trsp_agmt_rt_tp_nm" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_sp_type" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_cust_nomi_trkr_flg" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_cust_cnt_cd" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_cust_seq" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_local_curr_cd" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_basic_rt" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_fuel_scg_rt" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_over_wgt_scg_rt" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_local_curr_tot_amt" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_usd_curr_tot_amt" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_rtn_cd" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"po_rtn_msg" },
                        {Type:"Text",      Hidden:0, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"etc_add_amt" },
                        {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"kgs_net_wgt" },
                        {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:1,   SaveName:"lbs_net_wgt" }
                        ];
                     
                    InitColumns(cols);
                    SetEditable(1);
                    SetSheetHeight(200);
                    sheetObj.SetVisible(false);
            }
            break;
    }
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: {
			if (!validateForm(sheetObjects[0], formObj, sAction)) {
				return;
			}
			
			var open_SheetObj = opener_obj.sheetObjects[0];
			var queryStr = open_SheetObj.GetSaveString(false, true, 'ibcheck');
			sheetObj.DoSearch("ESD_TRS_0969.screen", queryStr, { Sync : 2, Append : true });
			this.focus();
			if (sheetObjects[0].GetCellValue(1, 'sp_type') == 'CNT' && sheetObjects[0].GetCellValue(1, 'cust_cnt_cd_seq') == '') {
				ComShowMessage("Please input Customer code for CNT");
				break;
			}
			var iCustCntCdSeq = sheetObjects[0].GetCellValue(1, 'cust_cnt_cd_seq');
			
			formObj.f_cmd.value = SEARCH02;
			formObj.WY_TP_CD.value = sheetObjects[0].GetCellValue(1, 'po_way_type');
			formObj.SP_TP_CD.value = sheetObjects[0].GetCellValue(1, 'sp_type');
			formObj.CUST_CNT_CD.value = iCustCntCdSeq.substring(0, 2);
			formObj.CUST_SEQ.value = iCustCntCdSeq.substring(2, 8);
			formObj.VNDR_CD.value = sheetObjects[0].GetCellValue(1, 'vndr_seq');
			formObj.BASIS_DT.value = sheetObjects[0].GetCellValue(1, 'eff_dt');
			formObj.WTR_RCV_TERM.value = sheetObjects[0].GetCellValue(1, 'ft_receiving');
			formObj.WTR_DE_TERM.value = sheetObjects[0].GetCellValue(1, 'ft_delivery');
			sheetObj.DoAllSave("ESD_TRS_0023GS.do", TrsFrmQryString(formObj));
			break;
		}
	}
}

/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js
 */
function sheet1_OnSearchEnd(sheetObj, Code, errMsg) {
	var formObj = document.form;
	if (Code < 0) {
		ComShowMessage(errMsg);
	} else {
		/* OFFICE CD CURRENCY */
		if (formObj.f_cmd.value == SEARCH01) {
			var conti_cd = sheetObj.GetEtcData('conti_cd');
			var bil_curr_cd = sheetObj.GetEtcData('bil_curr_cd');
			sheetObj.SetCellValue(1, 'default_curr', bil_curr_cd, 0);
			defaultLoginOfficeCurr = bil_curr_cd;
		}
	}
}

/**
 * 
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js
 */
function sheet2_OnSaveEnd(sheetObj, Code, errMsg) {
	var formObj = document.form;
	var sheetObj1 = sheetObjects[0];
	if (Code < 0) {
		ComShowMessage(errMsg);
	} else {
		var open_SheetObj = opener_obj.sheetObjects[0];
		if (sheetObj.RowCount() < 1) {
			ComShowCodeMessage('TRS90132');
			return;
		}

		var checkList = open_SheetObj.FindCheckedRow('ibcheck');
		var checkArray = checkList.split('|');
		var value1 = '';
		var value2 = '';
		var result = 0;
		var isSearch = false;
		var etc_add_amt;
		for ( var i = 0; i < checkArray.length; i++) {
			value1 = open_SheetObj.GetCellValue(checkArray[i], 'trsp_so_ofc_cty_cd') + open_SheetObj.GetCellValue(checkArray[i], 'trsp_so_seq');
			isSearch = false;
			for ( var k = 1; k < sheetObj.RowCount() + 1; k++) {
				value2 = sheetObj.GetCellValue(k, 'trsp_so_ofc_cty_cd') + sheetObj.GetCellValue(k, 'trsp_so_seq');
				if (value1 == value2) {
					open_SheetObj.SetCellValue(checkArray[i], 'po_trsp_agmt_ofc_cty_cd', sheetObj.GetCellValue(k, 'po_trsp_agmt_ofc_cty_cd'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_trsp_agmt_seq', sheetObj.GetCellValue(k, 'po_trsp_agmt_seq'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_trsp_agmt_rt_tp_cd', sheetObj.GetCellValue(k, 'po_trsp_agmt_rt_tp_cd'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_way_type', sheetObj.GetCellValue(k, 'po_way_type'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_trsp_agmt_rt_tp_nm', sheetObj.GetCellValue(k, 'po_trsp_agmt_rt_tp_nm'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_sp_type', sheetObj.GetCellValue(k, 'po_sp_type'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_cust_nomi_trkr_flg', sheetObj.GetCellValue(k, 'po_cust_nomi_trkr_flg'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_cust_cnt_cd', sheetObj.GetCellValue(k, 'po_cust_cnt_cd'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_cust_seq', sheetObj.GetCellValue(k, 'po_cust_seq'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_local_curr_cd', sheetObj.GetCellValue(k, 'po_local_curr_cd'));
					open_SheetObj.SetCellValue(checkArray[i], 'po_basic_rt', sheetObj.GetCellValue(k, 'po_basic_rt'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_fuel_scg_rt', sheetObj.GetCellValue(k, 'po_fuel_scg_rt'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_over_wgt_scg_rt', sheetObj.GetCellValue(k, 'po_over_wgt_scg_rt'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_local_curr_tot_amt', sheetObj.GetCellValue(k, 'po_local_curr_tot_amt'), 0);
					// open_SheetObj.SetCellValue(checkArray[i], 'po_usd_curr_tot_amt',sheetObj.GetCellValue(k, 'po_usd_curr_tot_amt'),0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_rtn_cd', sheetObj.GetCellValue(k, 'po_rtn_cd'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_rtn_msg', sheetObj.GetCellValue(k, 'po_rtn_msg'), 0);

					// 2014.11.21 Hyungwook Choi
					if (ComIsNull(sheetObj.GetCellValue(k, 'etc_add_amt'))) {
						etc_add_amt = "0.00";
						open_SheetObj.SetCellValue(checkArray[i], 'etc_add_amt', etc_add_amt, 0);
					} else {
						etc_add_amt = (sheetObj.GetCellValue(k, 'etc_add_amt') * 100 / 100).toFixed(2);
						open_SheetObj.SetCellValue(checkArray[i], 'etc_add_amt', etc_add_amt, 0);
					}

					if (ComTrim(sheetObj.GetCellValue(k, 'po_trsp_agmt_seq')) != '') {
						isSearch = true;
						result++;
					}
					break;
				}
			}

			if (formObj.wo_radio.value != 'Y') {
				open_SheetObj.SetCellValue(checkArray[i], 'vndr_seq', sheetObj1.GetCellValue(1, 'vndr_seq'), 0);
				open_SheetObj.SetCellValue(checkArray[i], 'vndr_nm', sheetObj1.GetCellValue(1, 'vndr_nm'), 0);
				open_SheetObj.SetCellValue(checkArray[i], 'wo_edi_use_flg', sheetObj1.GetCellValue(1, 'wo_edi_use_flg'), 0);

				if (sheetObj1.GetCellValue(1, 'cust_cnt_cd_seq').length > 0) {
					open_SheetObj.SetCellValue(checkArray[i], 'po_sp_type', "CNT", 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_cust_nomi_trkr_flg', "Y", 0);
					open_SheetObj.SetCellValue(checkArray[i], 'cust_cnt_cd_seq', sheetObj1.GetCellValue(1, 'cust_cnt_cd_seq'), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_cust_cnt_cd', sheetObj1.GetCellValue(1, 'cust_cnt_cd_seq').substring(0, 2), 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_cust_seq', sheetObj1.GetCellValue(1, 'cust_cnt_cd_seq').substring(2, 8), 0);
				} else {
					open_SheetObj.SetCellValue(checkArray[i], 'po_sp_type', "NYK", 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_cust_nomi_trkr_flg', "N", 0);
					open_SheetObj.SetCellValue(checkArray[i], 'cust_cnt_cd_seq', "", 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_cust_cnt_cd', "", 0);
					open_SheetObj.SetCellValue(checkArray[i], 'po_cust_seq', "", 0);
				}
			}
			if (!isSearch) {
				open_SheetObj.SetCellValue(checkArray[i], 'po_local_curr_cd', sheetObj1.GetCellValue(1, 'default_curr'));
			}

			// esd_trs_0023 total(usd)
			opener_obj.searchLocalCurr2UsdCurr(open_SheetObj, opener_obj.document.form, checkArray[i]);
		}

		// 2014.12.12 Hyungwook Choi
		var open_SheetObj1 = opener_obj.sheetObjects[1];
		var value3 = '';
		var value4 = '';
		for ( var k = 1; k < sheetObj.RowCount() + 1; k++) {
			value3 = sheetObj.GetCellValue(k, 'trsp_so_ofc_cty_cd') + sheetObj.GetCellValue(k, 'trsp_so_seq');
			for ( var m = open_SheetObj1.RowCount(); m > 0; m--) {
				value4 = open_SheetObj1.GetCellValue(m, prefix + 'trsp_so_ofc_cty_cd') + open_SheetObj1.GetCellValue(m, prefix + 'trsp_so_seq');
				if (value3 == value4) {
					open_SheetObj1.RowDelete(m, false);
				}
			}
		}
		var scgXml = sheetObj.GetEtcData("scgXml");
		if (scgXml == undefined || ComTrim(scgXml) == '') {
			sheetObjects[1].RemoveAll();
			return;
		}
		scgXml = scgXml.replace(new RegExp("<TD>", "gi"), '<TD><![CDATA[');
		scgXml = scgXml.replace(new RegExp("</TD>", "gi"), ']]></TD>');
		open_SheetObj1.LoadSearchData(scgXml, { Append : 1, Sync : 1 });
		
		if (result < 1)
			ComShowCodeMessage('TRS90132');
		else {
			ComShowCodeMessage('TRS90216') + ' [' + result + '/' + (checkArray.length) + ']';
		}
		ComClosePopup();
	}
}

/**
 * Validating inputted values of form
 */
function validateForm(sheetObj, formObj, sAction) {
	if (formObj.wo_radio.value != 'Y' && (sheetObj.GetCellValue(1, 'vndr_seq') == undefined || sheetObj.GetCellValue(1, 'vndr_seq') == '')) {
		ComShowCodeMessage('COM12114', 'vendor');
		sheetObj.SelectCell(1, 'vndr_seq');
		return false;
	} else if (sheetObj.GetCellValue(1, 'sp_type') == undefined || sheetObj.GetCellValue(1, 'sp_type') == '') {
		ComShowCodeMessage('COM12114', 'service provider type');
		sheetObj.SelectCell(1, 'sp_type');
		return false;
	}
	return true;
}

function sheet1_OnPopupClick(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.GetCellValue(row, colName);

	switch (colName) {
		case ('vndr_seq'):
			rep_OnPopupClick();
			break;
	}
}

/**
 * Defining OnChange Event of sheet
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	var value = sheetObj.GetCellValue(row, colName);
	switch (colName) {
		case ('vndr_seq'):
			getSheetVendorSeq(sheetObj, document.form, value, row);
			break;
		case ('cust_cnt_cd_seq'):
			// 2015.02.10 Hyungwook Choi
			if (isNaN(value.substring(2, 7))) {
				ComShowMessage("Invalid customer code!");
				sheetObj.SetCellValue(row, "cust_cnt_cd_seq", "");
				return;
			} else {
				if (value != "" && value != null && value != undefined) {
					document.form.f_cmd.value = INIT;
					document.form.custCode.value = value;
					var sXml = sheetObj.GetSearchData("ESD_TRS_0221GS.do", FormQueryString(document.form));
					// alert(ComGetTotalRows(sXml));
					if (ComGetTotalRows(sXml) == "0") {
						ComShowMessage("No corresponding customer code!");
						sheetObj.SetCellValue(row, "cust_cnt_cd_seq", "");
						return;
					}
				}
			}

			break;
	}
}

function getSheetVendorSeq(sheetObj, formObj, vndr_seq, row) {
	var returnFlg = false;
	formObj.f_cmd.value = SEARCH11;

    var temp = get_only_num(vndr_seq);
    if(temp != vndr_seq) {
    	sheetObj.SetCellValue(row, "vndr_seq", "", 0);
    	return returnFlg;
    }
    
	formObj.combo_svc_provider.value = vndr_seq;
	var sXml = sheetObj.GetSearchData("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));
	var vendorNoList = ComGetEtcData(sXml, 'vndr_no');
	var vendorNmList = ComGetEtcData(sXml, 'vndr_nm_eng');
	var vendorCurr = ComGetEtcData(sXml, 'vndr_cnt_curr_cd');
	var vendorWoEdiUseFlg = ComGetEtcData(sXml, 'wo_edi_use_flg');

	if (vendorNoList == undefined || vendorNoList == '') {
		formObj.combo_svc_provider.value = '';
		sheetObj.SetCellValue(row, 'vndr_seq', '', 0);
		sheetObj.SetCellValue(row, 'vndr_nm', '', 0);
		sheetObj.SetCellValue(row, 'default_curr', '', 0);
		sheetObj.SetCellValue(row, 'wo_edi_use_flg', '', 0);
		returnFlg = false;
	} else {
		sheetObj.SetCellValue(row, 'vndr_seq', ComTrim(vendorNoList), 0);
		sheetObj.SetCellValue(row, 'vndr_nm', vendorNmList, 0);
		sheetObj.SetCellValue(row, 'default_curr', vendorCurr, 0);
		sheetObj.SetCellValue(row, 'wo_edi_use_flg', vendorWoEdiUseFlg, 0);
		returnFlg = true;
	}
	if (vendorCurr == undefined || vendorCurr == '') {
		sheetObj.SetCellValue(row, 'default_curr', defaultLoginOfficeCurr, 0);
	}
	return returnFlg;
}

/**
 * Calling rep_commodity pop-up
 */
function rep_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_rep";
	var xx1 = ""; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	// var xx5=""; //CONTROL OFFIC
	var xx5 = formObject.form_usr_ofc_cd.value; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 475, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Calling rep_commodity pop-up : The case selecting one item at pop-up page
 */
function getCOM_ENS_rep(rowArray) {
	var sheetObj = sheetObjects[0];
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];

		sheetObj.SetCellValue(1, "vndr_seq", colArray2, 0);
		sheetObj.SetCellValue(1, "vndr_nm", colArray3, 0);

	}
	getSheetVendorSeq(sheetObj, document.form, colArray2, i);
}
