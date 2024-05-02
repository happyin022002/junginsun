/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ESD_TRS_0054.js
 *@FileTitle  : Supplement 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/05
 *@LastVersion : 1.0 
=========================================================*/

/**------------------From here the common JavaScript function is defined.     ------------------*/
/** Common global variable */
var prefix = 'surcharge_';
var key_row_name = 'Adjusted';
var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		switch (srcName) {
			case "btn_retrieve": {
				doActionIBSheet(sheetObject, formObject, IBSEARCH, "");
				break;
			}
			case "btn_reset": {
				fn_reset();
				break;
			}
			case "btng_rowadd": {
				doActionIBSheet(sheetObject, formObject, IBINSERT, "");
				break;
			}
			case "btng_downexcel":
				if (sheetObject.RowCount() < 1) {
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL, "");
				}
				break;
			case "btn_minimize": {
				if (document.all.MiniLayer.style.display != "none") {
					document.all.MiniLayer.style.display = "none";
				} else {
					document.all.MiniLayer.style.display = "";
				}		
				resizeSheet();
				break;
			}
			case "btns_frmnode": {
				openHireYardPopup('getFromNode');
				break;
			}
			case "btns_vianode": {
				openHireYardPopup('getViaNode');
				break;
			}
			case "btns_tonode": {
				openHireYardPopup('getToNode');
				break;
			}
			case "btns_dorloc": {
				openHireYardPopup('getDorLoc');
				break;
			}
			case "btng_provider":
				rep_OnPopupClick();
				break;
			case "btng_sodelete": {
				doActionIBSheet(sheetObject, formObject, IBSAVE, "SO_DELETE");
				break;
			}
			case "btng_woissue": {
				doActionIBSheet(sheetObject, formObject, IBSAVE, "WO_ISSUE");
				break;
			}
			case "btns_calendar": {
				getCalendar();
				break;
			}
			case "btn_eq_no": {
				so_OnPopupClick('EQ', 'EQ No.');
				break;
			}
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('TRS90384');
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
	change_eq_tp_sz(0);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch(sheetNo) {
       case 1:      //sheet1 init
    	      with(sheetObj){
		            var HeadTitle="|||EQ No.|TP/SZ|Cost\nMode|Trans\nMode|";
		            HeadTitle += "From Node|From Node|Via Node|Via Node|To Node|To Node|Door Loc|Door Loc|";
		            HeadTitle += "Actual\nCustomer|Door Delivery\nAddress|";
		            HeadTitle += "Service Provider|Service Provider|BKG No|BL No|T.VVD|S/O No|Org. W/O No|Org. W/O\nCreation Date|";
		            HeadTitle += "Org. Invoice No|Org. Invoice\nConfirm Date|Reference No|Reason|Internal\nRemark|";
		            HeadTitle += "Amount Kind|Default\nS/P|S/P\nType|Agmt Rate TP|Oneway\nRoundTrip|Currency|Basic|Nego|Fuel|Additional|Total|";
		            HeadTitle += "Agmt No1|Agmt No2|Agmt RT TP CD|Cnt Flag|Cust Cnt|Cust Seq";
		            SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1, MergeSheet: msHeaderOnly+msPrevColumnMerge } );
		            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1, ColMerge: 1  };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		            var cols = [ {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck" },
		                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"fm_yard",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"via_loc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"via_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"to_loc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"to_yard",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"dor_loc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"dor_zone",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_val",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dor_de_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"truck_vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"so_number",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wo_number",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_cfm_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"spl_iss_rsn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:100 },
		                {Type:"Popup",     Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"amount_kind",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trsp_dflt_vndr_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"sp_type",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_rate_type_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"way_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"bzc_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"nego_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"fuel_scg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"etc_add_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"total_amt",             KeyField:0,   CalcLogic:"|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|",Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		                {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"ovr_wgt_scg_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
		                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd" },
		                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq" },
		                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_rate_type" },
		                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_way_type" },
		                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_nomi_trkr_flg" },
		                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd" },
		                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq" },
		                {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                {Type:"Seq",       Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"surcharge_key" },
		                {Type:"Text",      Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_sts_cd" },
		                
		                ];
		             
		            InitColumns(cols);
		            SetEditable(1);
		            SetRangeBackColor(1, 16, 1, 33,"#555555");// ENIS
		            SetColProperty("way_type", {ComboText:"|"+way_typeText, ComboCode:"|"+way_typeCode} );
		            SetColProperty('curr_cd', {ComboText:curr_cdText, ComboCode:curr_cdCode} );
		            SetColHidden('ibflag',1);
		            SetColHidden('surcharge_key',1);
		            SetDataRowMerge(false);
		            resizeSheet();
          }
            break;
		   case 2:      //SO CREATED SHEET
			    with(sheetObj){
				       var cnt=0;
				      var HeadTitle="sts|svc_ord|seq";
				      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetVisible(false);
		            }
			break;
		   case 3:      //SURCHARGE SHEET
			    with(sheetObj){
				      var HeadTitle="STS||Office|Cost Mded|Trans Mode|Bound|Remarks|Created Date|Creation Office|User ID" ;
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibcheck" },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'unique_cd',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_ofc_cty_cd',          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_seq',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_full_nm',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_step_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scg_amt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'chss_mgst_tpsz_cd',           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'dry_run_rlbl_pty_tp_cd',      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fne_cuz_desc',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fumg_cost_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'mgst_tpsz_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'insp_rf_pti_cstms_tp_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_knt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_cuz_desc',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'stop_loc_nod_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'grs_wgt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incrt_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scl_stop_plc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'sto_dys',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no_split',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'wt_hrs',                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'otr_rmk',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scg_amt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_chss_mgst_tpsz_cd',       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_dry_run_rlbl_pty_tp_cd',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fne_cuz_desc',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fumg_cost_tp_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_mgst_tpsz_cd',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_insp_rf_pti_cstms_tp_cd', KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_knt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_cuz_desc',           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_stop_loc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_grs_wgt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incrt_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scl_stop_plc_nod_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_sto_dys',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_ob_bkg_no',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_ob_bkg_no_split',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_wt_hrs',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_otr_rmk',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_bil_flg',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_cnt_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_seq',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_vndr_seq',              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_ofc_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_amt',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_desc',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_ofc_cd',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_usr_id',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetVisible(false);
		            }
			break;				
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var vvd = formObj.vvdnumber.value;
			var bkg_no = formObj.bkgnumber.value;
			var bl_no = formObj.blnumber.value;
			var eq_no = formObj.eqnumber.value;
			var ref_no = formObj.refnumber.value;
			var so_no = formObj.sonumber.value;
			var wo_no = formObj.wonumber.value;
			var lvfrmDate = doSepRemove(doSepRemove(formObj.from_date.value, " "), "-");
			var lvtoDate = doSepRemove(doSepRemove(formObj.to_date.value, " "), "-");
			if (ComIsEmpty(vvd) && ComIsEmpty(bkg_no) && ComIsEmpty(bl_no) && ComIsEmpty(eq_no) && ComIsEmpty(ref_no) && ComIsEmpty(so_no) && ComIsEmpty(wo_no)) {
				if (lvfrmDate == "" && lvtoDate == "") {
					ComShowCodeMessage("TRS90460");
					return false;
				} else if (lvfrmDate == "" && lvtoDate != "") {
					ComShowCodeMessage("TRS90119");
					return false;
				} else if (lvfrmDate != "" && lvtoDate == "") {
					ComShowCodeMessage("TRS90121");
					return false;
				} else if (lvfrmDate != "" && lvtoDate != "") {
					if (!doDatecheck(lvfrmDate)) {
						ComShowCodeMessage("TRS90072");
						formObj.from_date.focus();
						return false;
					} else if (!doDatecheck(lvtoDate)) {
						ComShowCodeMessage("TRS90073");
						formObj.from_date.focus();
						return false;
					}
					if (ComGetDaysBetween(lvfrmDate, lvtoDate) > 30) {
						ComShowCodeMessage("TRS90424");
						return false;
					} else if (ComGetDaysBetween(lvfrmDate, lvtoDate) < 0) {
						ComShowCodeMessage("TRS90118");
						return false;
					}
				}
			}
			if(!TrsComValidFormat("SO", so_no, true)) { return false; }
			if(!TrsComValidFormat("WO", wo_no, true, "Origin Work Order No")) { return false; }
			break;
		}
		case IBSAVE:
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			if (checkList == '') {
				ComShowCodeMessage('COM12176');
				return false;
			}
			break;
	}
	return true;
}
function doActionIBSheet(sheetObj, formObj, sAction, sFlag) {
	var formObj = document.form;
	switch (sAction) {
		case IBSEARCH: {
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.hid_from_node.value = formObj.search_fm_loc.value + search_fm_yard.GetSelectCode();
				formObj.hid_via_node.value = formObj.search_via_loc.value + search_via_yard.GetSelectCode();
				formObj.hid_to_node.value = formObj.search_to_loc.value + search_to_yard.GetSelectCode();
				formObj.hid_dor_node.value = formObj.search_door_loc.value + search_door_yard.GetSelectCode();
				formObj.hid_from_date.value = removeBar(formObj.from_date.value);
				formObj.hid_to_date.value = removeBar(formObj.to_date.value);
				formObj.hid_provider.value = formObj.combo_svc_provider.value;
				formObj.hid_tp_sz.value = formObj.tp_sz.value;
				formObj.f_cmd.value = SEARCHLIST02;
				ComOpenWait(true);
				try {
					sheetObj.DoSearch("ESD_TRS_0054GS.do", TrsFrmQryString(formObj), { Sync : 2 });
					sheetObj.CheckAll("ibcheck", 0, 1);
					cols_controll_color();
				} catch (e) {
				} finally {
					ComOpenWait(false);
				}
			}
			break;
		}
		case IBSAVE:
			var mainSheetObj = sheetObj;
			var creSheetObj = sheetObjects[1];
			if (sFlag == "SO_DELETE") {
				if (!validateForm(mainSheetObj, formObj, sAction)) {
					return false;
				}
				if (!ComShowCodeConfirm("TRS90478")) {
					return false;
				}
				var rowCount = mainSheetObj.RowCount();
				var checkedRow = "";
				var targetRowValue = "";
				var mainQueryString = "";
				if (rowCount > 0) {
					for ( var i = 1; i <= rowCount; i++) {
						checkedRow = mainSheetObj.GetCellValue(i, "ibcheck");
						targetRowValue = mainSheetObj.GetCellValue(i, "amount_kind");
						if (checkedRow > 0) {
							if (targetRowValue == key_row_name) {
								mainSheetObj.SetRowStatus(i, "I");
							} else {
								mainSheetObj.SetRowStatus(i, "R");
							}
						}
					}
					formObj.f_cmd.value = MULTI02;
					mainSheetObj.DoSave("ESD_TRS_0982GS.do", { Param : TrsFrmQryString(formObj), Quest : false, Sync : 2 });

					mainQueryString = mainSheetObj.GetSaveString(false, false, "ibcheck");
					formObj.f_cmd.value = REMOVE;
					mainSheetObj.DoSave("ESD_TRS_0054GS.do", { Param : TrsFrmQryString(formObj), Col : '-1', Quest : false, Sync : 2 });
					doActionIBSheet(mainSheetObj, formObj, IBSEARCH);
				}
			} else if (sFlag == "WO_ISSUE") {
				var checkList=sheetObj.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				var cty_cd="";
				var seq_no="";
				for(var i=1; i<sheetObj.RowCount()+1; i++) {
					if( i == sheetObj.RowCount()) {
						cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd');
						seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq');
					} else {
						cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd') + ",";
						seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq') + ",";
					}
				}
				document.woForm.trsp_so_ofc_cty_cd.value=cty_cd;
				document.woForm.trsp_so_seq.value=seq_no;
				document.woForm.eq_mode.value="CG";
				document.woForm.pgmNo.value="ESD_TRS_0023";
				document.woForm.parentPgmNo.value="ESD_TRS_M001";
				document.woForm.action="ESD_TRS_0023.screen";
				document.woForm.submit();
			}
			break;
		case IBDOWNEXCEL: {
			sheetObj.Down2Excel({ HiddenColumn : 1, Merge : 1 });
			break;
		}
		case IBINSERT: {
			sheetObj.DataInsert();
			break;
		}
	}
}
/**
 * When an error occurs, search the results to a common processing function DataSheetObject.prototype.event_OnSearchEnd define in IBSheetConfig.js
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	if (errMsg == null || errMsg == '') {
		cols_controll();
		cols_controll_color();
	} else {
		ComShowCodeMessage('errMsg');
		return;
	}
}
/**
 * ofc팝업호출
 */
function so_OnPopupClick(val, title) {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_so";
	var xx1 = val; // CONTI
	var xx2 = title; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?returnval=" + xx1 + "&returntitle=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9 + "&pgmNo=ESD_TRS_0054";
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 415, 'getCOM_ENS_906', '0,1', true);
}
/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, returnval) {
	var formObject = document.form;
	if (returnval == "SO") {
		formObject.sonumber.value = rowArray;
	} else if (returnval == "WO") {
		formObject.wonumber.value = rowArray;
	} else if (returnval == "BKG") {
		formObject.bkgnumber.value = rowArray;
	} else if (returnval == "BL") {
		formObject.blnumber.value = rowArray;
	} else if (returnval == "EQ") {
		formObject.eqnumber.value = rowArray;
		checkDigit();
	} else if (returnval == "VVD") {
		formObject.vvdnumber.value = rowArray;
	}
}
function checkDigit(obj) {
	var formObj = document.form;
	if (obj == undefined) {
		obj = formObj.eqnumber;
	}
	obj.value = obj.value.toUpperCase();
	if (formObj.btns_radio_eq[0].checked) {
		obj.value = multiCntrChkDgt(obj.value);
	}
}
function checkWoCreDt() {
	var formObj = document.form;
	if (formObj.from_date.value == null || formObj.from_date.value == "" || formObj.to_date.value == null || formObj.to_date.value == "") {
		if ((formObj.vvdnumber.value == null || formObj.vvdnumber.value == "") && (formObj.bkgnumber.value == null || formObj.bkgnumber.value == "") && (formObj.blnumber.value == null || formObj.blnumber.value == "") && (formObj.refnumber.value == null || formObj.refnumber.value == "")
				&& (formObj.sonumber.value == null || formObj.sonumber.value == "") && (formObj.wonumber.value == null || formObj.wonumber.value == "")) {
			ComShowCodeMessage("TRS90460");
			return false;
		} else {
			return true;
		}
	}
	return true;
}

/**
 * When you click the radio button to delete the status change and add hidden value, the opposite value.
 */
function change_eq_val() {
	var formObject = document.form;
	var sheetObject = formObject.sheet1;
	var num;
	if (formObject.btns_radio_eq[0].checked == true) {
		formObject.hid_eq_radio.value = "U";
		num = 0;
	} else if (formObject.btns_radio_eq[1].checked == true) {
		formObject.hid_eq_radio.value = "Z";
		num = 1;
	} else if (formObject.btns_radio_eq[2].checked == true) {
		formObject.hid_eq_radio.value = "G";
		num = 2;
	} else {
		formObject.hid_eq_radio.value = "";
	}
	change_eq_tp_sz(num);
}
// on focus
function fun_Focus(obj) {
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}
function fun_Focus_del(obj) {
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}
function removeBar(str) {
	var value = "";
	for ( var i = 0; i < str.length; i++) {
		var ch = str.charAt(i);
		if (ch != '-')
			value = value + ch;
	}
	return value;
}
function isValidDate(date) {
	var year = date.substring(0, 4);
	var month = date.substring(4, 6);
	var day = date.substring(6, 8);
	if (isDatecheck(year, month, day)) {
		return true;
	} else {
		return false;
	}
}
function isDatecheck(year, month, day) {
	if (parseInt(year) >= 1900 && checkMonth(month) && checkDay(year, month, day)) {
		return true;
	} else {
		return false;
	}
}
// month checking
function checkMonth(month) {
	var intmonth = parseInt(month, 10)
	if (intmonth >= 1 && intmonth <= 12) {
		return true;
	} else {
		return false;
	}
}
// Check valid date
function checkDay(yyyy, mm, dd) {
	var monthDD = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	var im = parseInt(mm, 10) - 1;
	if (((yyyy % 4 == 0) && (yyyy % 100 != 0)) || (yyyy % 400 == 0)) {
		monthDD[1] = 29;
	}
	if (parseInt(dd, 10) <= 0 || parseInt(dd, 10) > monthDD[im]) {
		return false;
	} else {
		return true;
	}
}
// date format(yyyy-mm-dd)
function addBar(dt) {
	var dat = "";
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	return dat;
}
// date format(yyyy-mm-dd)
function addBar_from(obj) {
	var formObject = document.form;
	var dt = obj.value;
	var dat = dt;
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	formObject.from_date.value = dat;
}
// date format(yyyy-mm-dd)
function addBar_to(obj) {
	var formObject = document.form;
	var dt = obj.value;
	var dat = dt;
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	formObject.to_date.value = dat;
}
function date() {
}
/**
 * From Node pop-up for the return value
 */
function getFromNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_fm_loc.value = lvLoc;
	getYardCombo(search_fm_yard, sheetObjects[0], formObject, lvLoc);
	search_fm_yard.SetSelectCode(lvYard, true);
}
/**
 * Via Node pop-up for the return value
 */
function getViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_via_loc.value = lvLoc;
	getYardCombo(search_via_yard, sheetObjects[0], formObject, lvLoc);
	search_via_yard.SetSelectCode(lvYard, true);
}
/**
 * To Node pop-up for the return value
 */
function getToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_to_loc.value = lvLoc;
	getYardCombo(search_to_yard, sheetObjects[0], formObject, lvLoc);
	search_to_yard.SetSelectCode(lvYard, true);
}
/**
 * Door Location pop-up for the return value
 */
function getDorLoc(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var lvLoc = node.substring(0, 5);
	var lvYard = node.substring(5, 7);
	formObject.search_door_loc.value = lvLoc;
	getZoneCombo(search_door_yard, sheetObjects[0], formObject, lvLoc);
	search_door_yard.SetSelectCode(lvYard, true);
}
/*
 * Get a list of external combo box (Refer to ESD_TRS_0003.js).
 */
function getComboList(obj, comObj, sep) {
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";
	obj.value = lvobj;
	comObj = eval(comObj.id);
	for ( var i = 0; i < lvobj.length; i++) {
		var oneChar = lvobj.charAt(i)
		if (oneChar != "") {
			if ((oneChar >= "a" && oneChar <= "z") || (oneChar >= "A" && oneChar <= "Z")) {
			} else {
				charval = "N";
				break;
			}
		} else {
			charval = "N";
			break;
		}
	}
	if (charval == "Y") {
	} else {
		var errMessage = ComGetMsg('COM12130', 'NODE', '', '');
		ComShowMessage(errMessage);
		obj.value = "";
		obj.focus();
		return false;
	}
	if (lvobj == "") {
		obj.value = "";
		if (obj.name == 'search_fm_loc')
			yard_obj = search_fm_yard;
		else if (obj.name == 'search_via_loc')
			yard_obj = search_via_yard;
		else if (obj.name == 'search_to_loc')
			yard_obj = search_to_yard;
		else if (obj.name == 'search_door_loc')
			yard_obj = search_door_yard;
		var locValue = obj.value;
		if (ComTrim(locValue) == '') {
			yard_obj.RemoveAll();
			return;
		}
	} else if (lvobj.length != 5 && lvobj.length != 2) {
		ComShowCodeMessage('TRS90122');
		if (sep == "F") {
			formObj.search_fm_loc.select();
			formObj.search_fm_loc.focus();
		} else if (sep == "V") {
			formObj.search_via_loc.select();
			formObj.search_via_loc.focus();
		} else if (sep == "T") {
			formObj.search_to_loc.select();
			formObj.search_to_loc.focus();
		} else if (sep == "D") {
			formObj.search_door_loc.select();
			formObj.search_door_loc.focus();
		} else {
		}
	} else {
		if (sep == 'F') {
			lvFromNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		} else if (sep == 'V') {
			lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		} else if (sep == 'T') {
			lvToNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
		} else if (sep == 'D') {
			lvDoorLoc = getZoneCombo(comObj, sheetObjects[0], formObj, lvobj);
		} else {
		}
	}
}
/**
 * 공통 Node popup
 */
function openHireYardPopup(objName) {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
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
	var v_mode = "";
	if (objName == 'getDorLoc') {
		v_mode = "zone"
	} else {
		v_mode = "yard";
	}
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9 + "&mode=" + v_mode;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * SOcheck.
 */
function val_check(obj, val) {
	var formObject = document.form;
	var inputStr = obj.value;
	var value = obj.value;
	var charval = "Y";
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	lvobj = obj.value;
	if (lvobj != "") {
		for ( var i = 0; i < inputStr.length; i++) {
			var oneChar = inputStr.charAt(i)
			if (oneChar != "") {
				if ((oneChar >= "a" && oneChar <= "z") || (oneChar >= "A" && oneChar <= "Z") || (oneChar >= "0" && oneChar <= "9") || (oneChar == ",")) {
				} else {
					charval = "N";
					break;
				}
			} else {
				charval = "N";
				break;
			}
		}
		if (charval == "Y") {
		} else {
			ComShowCodeMessage('COM12130', val);
			obj.value = "";
			obj.focus();
		}
	}
}
/**
 * combo box -bound
 */
function bound_OnChange_1(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_boundmode.value = codeval;
}
/**
 * combo box -cost
 */
function bound_OnChange_2(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_costmode.value = codeval;
}
/**
 * combo box -trans
 */
function bound_OnChange_3(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_transmode.value = codeval;
}
/**
 * combo box -trans
 */
function bound_OnChange_4(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_transmode.value = codeval;
}
/**
 * VNDR_check.
 */
function vndr_check(obj) {
	var formObject = document.form;
	var inputStr = obj.value;
	var value = obj.value;
	var charval = "Y";
	for ( var i = 0; i < inputStr.length; i++) {
		var oneChar = inputStr.charAt(i)
		if (oneChar != "") {
			if ((oneChar >= "0" && oneChar <= "9")) {
			} else {
				charval = "N";
				break;
			}
		} else {
			charval = "N";
			break;
		}
	}
	if (charval == "Y") {
		if (value != "") {
			formObject.f_cmd.value = SEARCH04;
			var queryString = "vndr_cd=" + value + "&" + TrsFrmQryString(formObject);
			formObject.vndr_cd.value = "";
			formObject.vndr_cd.focus();
		}
	} else {
		formObject.vndr_cd.value = "";
		formObject.vndr_cd.focus();
		var errMessage = ComGetMsg('COM12130', 'Service Provide', '', '');
		ComShowMessage(errMessage);
	}
}
/**
 * VNDR the presence of input Check
 * 
 */
function check_vndr(value, obj) {
	var formObject = document.form;
	if (value == 0) {
		var errMessage = ComGetMsg('COM12114', 'VNDR', '', '');
		ComShowMessage(errMessage);
		return false;
	} else {
		return true;
	}
}
/**
 * Get a list of external combo box
 */
function getVendorComboList() {
	var formObj = document.form;
	var vendorNo = formObj.combo_svc_provider.GetSelectText();
	getVendorCombo(document.combo_svc_provider, sheetObjects[0], formObj, vendorNo, '', '');
}
/**
 * call rep_commodity pop-up
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
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * call rep_commodity pup-up : If a single selection from a pop-up.
 */
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];
		formObj.combo_svc_provider.value = colArray2;
		formObj.svc_provider.value = colArray3;
	}
}

/**
 * sheet click events that occur during
 */
function sheet1_OnDblClick(sheetObj, row, col, value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	var r_hid_kind = formObj.hid_kind.value;
	switch (colName) {
		case 'etc_add_amt':
			if (r_hid_kind == 'AS') {
				sheet1_check = sheetObj.GetCellValue(row, "amount_kind");
				if (sheet1_check == key_row_name) {
					popSurchargeInputInquiry(sheetObj, row, col, 'search');
				}
			} else {
				return;
			}
			break;
	}
	if (sheetObj.GetCellProperty(row, col, 0) == 6) {
		return;
	}
	if (!sheetObj.GetCellEditable(row, col))
		return;
	switch (colName) {
		case 'fm_nod_cd_sub':
			if (sheetObj.GetCellValue(row, 'fm_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.GetCellValue(row, 'fm_nod_cd'));
			}
			break;
		case 'via_nod_cd_sub': {
			if (sheetObj.GetCellValue(row, 'via_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.GetCellValue(row, 'via_nod_cd'));
			}
			break;
		}
		case 'to_nod_cd_sub': {
			if (sheetObj.GetCellValue(row, 'to_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.GetCellValue(row, 'to_nod_cd'));
			}
			break;
		}
		case 'dor_nod_cd_sub': {
			if (sheetObj.GetCellValue(row, 'dor_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.GetCellValue(row, 'dor_nod_cd'));
			}
			break;
		}
	}
}
/**
 * sheet click events that occur during
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	var formObj = document.form;
	var sheet1_x1 = "";
	var sheet1_x2 = "";
	var sheet1_checkval = "";
	var sheet1_x1val = "";
	var sheet1_count = sheetObjects[0].RowCount();
	var sheet1_check = "";
	if (sheetObj.GetCellProperty(row, col, 0) == 6) {
		return;
	}
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case 'ibcheck':
			sheet1_x1 = sheetObjects[0].GetCellValue(row, "trsp_so_seq");
			sheet1_x1val = sheetObjects[0].GetCellValue(row, "ibcheck");
			if (sheet1_count > 0) {
				for ( var i = 1; i < sheet1_count + 1; i++) {
					sheet1_x2 = sheetObjects[0].GetCellValue(i, "trsp_so_seq");
					if (sheet1_x1 == sheet1_x2) {
						if (sheet1_x1val < 1) {
							sheetObjects[0].SetCellValue(i, 'ibcheck', 0, 0);
							sheet1_check = sheetObjects[0].GetCellValue(i, "amount_kind");
							if (sheet1_check == key_row_name) {
								sheetObjects[0].SetRowStatus(i, "R");
							}
						} else {
							sheetObjects[0].SetCellValue(i, 'ibcheck', 1, 0);
							sheet1_check = sheetObjects[0].GetCellValue(i, "amount_kind");
							if (sheet1_check == key_row_name) {
								sheetObjects[0].SetRowStatus(i, "I");
							}
						}
					} else {
					}
				}
			}
			status_change();
			break;
		case 'fm_nod_cd':
			if (sheetObj.GetCellValue(row, 'fm_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col + 1), sheetObj.GetCellValue(row, colName));
			}
			break;
		case 'via_nod_cd':
			if (sheetObj.GetCellValue(row, 'via_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col + 1), sheetObj.GetCellValue(row, colName));
			}
			break;
		case 'to_nod_cd':
			if (sheetObj.GetCellValue(row, 'to_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col + 1), sheetObj.GetCellValue(row, colName));
			}
			break;
		case 'dor_nod_cd':
			if (sheetObj.GetCellValue(row, 'dor_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col + 1), sheetObj.GetCellValue(row, colName));
			}
			break;
		case 'curr_cd':
			var tot_sum = "";
			tot_sum = parseFloat(sheetObjects[0].GetCellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].GetCellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'fuel_scg_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'etc_add_amt'));
			sheetObjects[0].SetCellValue(row, 'tot_amt', parseFloat(tot_sum), 0);
			break;
		case 'bzc_amt':
			var tot_sum = "";
			tot_sum = parseFloat(sheetObjects[0].GetCellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].GetCellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'fuel_scg_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'etc_add_amt'));
			sheetObjects[0].SetCellValue(row, 'tot_amt', parseFloat(tot_sum), 0);
			break;
		case 'fuel_scg_amt':
			var tot_sum = "";
			tot_sum = parseFloat(sheetObjects[0].GetCellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].GetCellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'fuel_scg_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'etc_add_amt'));
			sheetObjects[0].SetCellValue(row, 'tot_amt', parseFloat(tot_sum), 0);
			break;
		case 'ovr_wgt_scg_amt':
			var tot_sum = "";
			tot_sum = parseFloat(sheetObjects[0].GetCellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].GetCellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'fuel_scg_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'etc_add_amt'));
			sheetObjects[0].SetCellValue(row, 'tot_amt', parseFloat(tot_sum), 0);
			break;
		case 'etc_add_amt':
			var tot_sum = "";
			tot_sum = parseFloat(sheetObjects[0].GetCellValue(row, 'curr_cd')) + parseFloat(sheetObjects[0].GetCellValue(row, 'bzc_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'fuel_scg_amt')) + parseFloat(sheetObjects[0].GetCellValue(row, 'etc_add_amt'));
			sheetObjects[0].SetCellValue(row, 'tot_amt', parseFloat(tot_sum), 0);
			break;
	}
	cols_controll_color();
}
function fn_reset() {
	var formObj = document.form;
	var rowCount = sheetObjects[0].RowCount();
	formObj.reset();
	if (rowCount > 0) {
		sheetObjects[0].RemoveAll();
		formObj.reset();
		formObj.btns_radio_kind[0].checked = true;
		formObj.btns_radio_eq[0].checked = true;
	}
}
/**
 * After about a specific column views that enable users to modify the logic processing
 */
function cols_controll_color() {
	var formObj = document.form;
	var sheet1_x1 = "";
	var sheet1_x2 = "";
	var sheet1_color = "Y";
	var sheet1_count = sheetObjects[0].RowCount();
	sheet1_x1 = sheetObjects[0].GetCellValue(1, "trsp_so_seq");
	if (sheet1_count > 0) {
		for ( var i = 1; i < sheet1_count + 1; i++) {
			sheet1_x2 = sheetObjects[0].GetCellValue(i, "trsp_so_seq");
			if (sheet1_x1 == sheet1_x2) {
				if (sheet1_color == "Y") {
					sheetObjects[0].SetRowBackColor(i, 15723503);
				} else {
					sheetObjects[0].SetRowBackColor(i, "#EEFFE2");
				}
			} else {
				sheet1_x1 = sheetObjects[0].GetCellValue(i, "trsp_so_seq");
				i = i - 1;
				if (sheet1_color == "Y") {
					sheet1_color = "N";
				} else {
					sheet1_color = "Y";
				}
			}
		}
	}
}

function cols_controll() {
	var formObj = document.form;
	var sheet1_x1 = "";
	var sheet1_count = sheetObjects[0].RowCount();
	if (sheet1_count > 0) {
		for ( var i = 1; i < sheet1_count + 1; i++) {
			sheet1_x1 = sheetObjects[0].GetCellValue(i, "amount_kind");
			if (sheet1_x1 == key_row_name) {
				sheetObjects[0].SetCellEditable(i, "curr_cd", 1);
			} else {
			}
		}
	}
}

/**
 * Clicking on the sheet adjusted only status with i should be.
 */
function status_change() {
	var formObj = document.form;
	for (i = 1; i <= sheet1.RowCount(); i++) {
		if (sheet1.GetRowStatus(i) == "U") {
			sheet1.SetRowStatus(i, "R");
		}
	}
	cols_controll_color();
}
/**
 * call vvd pop-up
 */
function vvd_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_VVD";
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
	ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 772, 450, 'getCOM_ENS_VVD', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * Location : If a single selection from a pop-up.
 */
function getCOM_ENS_VVD(rowArray) {
	var formObject = document.form;
	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[7];
		document.form.trunk_vvd.value = colArray2;
	}
}
/**
 * vvd checking.
 */
function vvd_check(obj) {
	var formObject = document.form;
	var value = "";
	var xxx = obj.value;
	if (xxx != "") {
		formObject.f_cmd.value = SEARCH02;
		var queryString = "searchStr=" + value + "&" + TrsFrmQryString(formObject);
		if (!check_vvd(formObject.sheet1.GetEtcData('CNT_CD'), obj)) {
			return;
		}
	}
}
/**
 * S/C Number checking
 * 
 */
function check_vvd(val, obj) {
	var formObject = document.form;
	if (val == 0) {
		var errMessage = ComGetMsg('COM12114', 'Trunk vvd data', '', '');
		ComShowMessage(errMessage);
		formObject.trunk_vvd.value = "";
		formObject.trunk_vvd.select();
		formObject.trunk_vvd.focus();
	}
}
/*
 * Calendar Pop-Up
 */
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.from_date, document.form.to_date, 'yyyy-MM-dd');
}
/**
 * Opne popup when Additional Amount click.
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case 'inter_rmk':
			var lvbkg = sheetObj.GetCellValue(row, "bkg_sq");
			var lveqno = sheetObj.GetCellValue(row, "eq_no");
			var lvsono = sheetObj.GetCellValue(row, "so_number");
			var url = "ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&inter_rmk_cd=T";
			ComOpenWindowCenter(url, "compopup", 1000, 570, true);
	}
}
function popSurchargeInputInquiry(sheetObj, row, col, mode) {
	var myOption = "width=950,height=805,menubar=0,status=0,scrollbars=1,resizable=0";
	var url = 'ESD_TRS_0918.screen';
	url += '?unique_cd=' + sheetObj.GetCellValue(row, 'surcharge_key');
	url += '&open_mode=' + mode;
	url += '&step_cd=WO';
	url += '&main_row=' + row;
	url += '&ofc_cty_cd=' + sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&so_seq=' + sheetObj.GetCellValue(row, 'trsp_so_seq');
	url += '&sheet_arr_no=2';
	url += '&curr_cd=' + sheetObj.GetCellValue(row, 'curr_cd');
	myWin = window.open(url, "popSurchargeInputInquiry", myOption);
	myWin.focus();
}

/**
 * Receive data from Surcharge Input Inquiry popup
 */
function setSurchargeInputInquiry(winObj, sheetObj, formObj, totalSum) {
	var mainSheetObj = sheetObjects[0];
	var surchargeSheetObj = sheetObjects[2];
	var row = formObj.main_row.value;
	var unique_cd = formObj.unique_cd.value;
	for ( var a = surchargeSheetObj.RowCount(); a > 0; a--) {
		if (surchargeSheetObj.GetCellValue(a, prefix + 'unique_cd') == unique_cd)
			surchargeSheetObj.RowDelete(a, false);
	}
	var queryStr = sheetObj.GetSaveString(true, false);
	if (queryStr == '')
		return false;
	mainSheetObj.SetCellValue(row, 'etc_add_amt', totalSum, 0);
	var url = '?prefix=' + prefix;
	surchargeSheetObj.DoSearch("ESD_TRS_0969.screenurl", queryStr, { Append : true });
	ComClosePopup();
}

/**
 * Click the radio button for the status change when hidden value delete and add the opposite value.
 */
function change_val(){
	var formObject=document.form;
	var sheetObj1 = sheetObjects[0];
	var val="";
	if ( formObject.btns_radio_kind[0].checked == true ) {
		formObject.hid_kind.value="AS";
	}else if( formObject.btns_radio_kind[1].checked == true ) {
		formObject.hid_kind.value="RR";
	}else{
		formObject.hid_kind.value="";
	}
	var vla_1="";
	var sheet1_count=sheetObj1.RowCount();
	if(sheet1_count>0){
		if(confirm(sheet1_count+" Data exists. Change the conditions are clear views.\n  To continue, please press the OK button.")){
			sheetObj1.RemoveAll();
		}else{
			if ( formObject.hid_kind.value=="AS" ) {
				formObject.btns_radio_kind[1].checked=true;
				formObject.hid_kind.value="RR";
			}else{
				formObject.btns_radio_kind[0].checked=true;
				formObject.hid_kind.value="AS";
			}
			return false;
		}
	}
}

// according to eq type tp / sz Import data list
function change_eq_tp_sz(num) {
	var formObject = document.form;
	tpszList = new Array(2);
	tpszList[0] = new Array(27);
	tpszList[1] = new Array(10);
	// CNTR
	tpszList[0][0] = "ALL";
	tpszList[0][1] = "A2";
	tpszList[0][2] = "A4";
	tpszList[0][3] = "D2";
	tpszList[0][4] = "D3";
	tpszList[0][5] = "D4";
	tpszList[0][6] = "D5";
	tpszList[0][7] = "D7";
	tpszList[0][8] = "D8";
	tpszList[0][9] = "D9";
	tpszList[0][10] = "DW";
	tpszList[0][11] = "DX";
	tpszList[0][12] = "F2";
	tpszList[0][13] = "F4";
	tpszList[0][14] = "F5";
	tpszList[0][15] = "O2";
	tpszList[0][16] = "O4";
	tpszList[0][17] = "P2";
	tpszList[0][18] = "P4";
	tpszList[0][19] = "R2";
	tpszList[0][20] = "R4";
	tpszList[0][21] = "R5";
	tpszList[0][22] = "R7";
	tpszList[0][23] = "S2";
	tpszList[0][24] = "S4";
	tpszList[0][25] = "T2";
	tpszList[0][26] = "T4";
	// Chassis
	tpszList[1][0] = "ALL";
	tpszList[1][1] = "EG8";
	tpszList[1][2] = "EG5";
	tpszList[1][3] = "CB4";
	tpszList[1][4] = "SF4";
	tpszList[1][5] = "TA2";
	tpszList[1][6] = "SL2";
	tpszList[1][7] = "SF2";
	tpszList[1][8] = "GN4";
	tpszList[1][9] = "GN5";
	tpszList[1][10] = "ZT4";
	if (num == 0 || num == 1) {
		for (ctr = 0; ctr < tpszList[num].length; ctr++) {
			formObject.tp_sz.options[ctr] = new Option(tpszList[num][ctr], tpszList[num][ctr]);
		}
		formObject.tp_sz.length = tpszList[num].length;
	} else {
		formObject.tp_sz.options[0] = new Option("ALL", "ALL");
		formObject.tp_sz.length = 1;
	}
}
/**
 * enter check
 */
function enterCheck(obj) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	if (event.keyCode == 13) {
		switch (ComGetEvent("name")) {
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
		}
	}
}

function resizeSheet() {
	ComResizeSheet(sheetObjects[0]);
}

/**
 * 
 * @param obj
 */
function getDateBetween(obj) {
	if (obj.value.length >= 8) {
		document.form.to_date.value = ComGetDateAdd(obj.value, "D", 30, "-");
	} else {
		document.form.to_date.value = "";
	}
}
