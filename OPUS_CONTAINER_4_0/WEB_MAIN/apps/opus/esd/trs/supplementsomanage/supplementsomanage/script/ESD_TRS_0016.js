/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0016.jsp
 *@FileTitle  : Service Order Creation -Supplement
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/05
=========================================================*/
var prefix = 'surcharge_';
var key_row_name = 'Adjusted';
var sheetObjects = new Array();
var sheetCnt = 0;
var minCount = 0;
var row_val = "";
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH, "");
				break;
			case "btn_reset":
				fn_reset();
				break;
			case "btng_rowadd":
				doActionIBSheet(sheetObject, formObject, IBINSERT, "");
				break;
			case "btng_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL, "");
				break;
			case "btn_minimize":
				if (document.all.MiniLayer.style.display != "none") {
					document.all.MiniLayer.style.display = "none";
				} else {
					document.all.MiniLayer.style.display = "";
				}
				ComResizeSheet(sheetObjects[0]);
				break;
			case "btns_frmnode":
				openHireYardPopup('getFromNode');
				break;
			case "btns_vianode":
				openHireYardPopup('getViaNode');
				break;
			case "btns_tonode":
				openHireYardPopup('getToNode');
				break;
			case "btns_dorloc":
				openHireYardPopup('getDorLoc');
				break;
			case "btng_provider":
				rep_OnPopupClick();
				break;
			case "btng_socreation":
				doActionIBSheet(sheetObject, formObject, IBSAVE, "SO_CREATE");
				break;
			case "btng_woissue":
				doActionIBSheet(sheetObject1, formObject, IBSAVE, "WO_ISSUE");
				break;
			case "btns_calendar":
				getCalendar();
				break;
			case "btn_eq_no":
				so_OnPopupClick('EQ', 'EQ No.');
				break;
			case "btng_surchargeapply":
				popSurchargeInputInquiry(sheetObject, '', '', 'multiple');
				break;
			case "btns_invnumber":
				rep_Multiful_inquiry(srcName);
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('TRS90384');
		} else {
			ComShowCodeMessage(e);
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
	initControl();
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch(sheetNo) {
       case 1: 
           with(sheetObj){
                  var HeadTitle="|||EQ No.|TP/SZ|Cost\nMode|Trans\nMode|";
                  HeadTitle += "From Node|From Node|Via Node|Via Node|To Node|To Node|Door Loc|Door Loc|";
                  HeadTitle += "Actual\nCustomer|Door Delivery\nAddress|";
                  HeadTitle += "Service Provider|Service Provider|BKG No|BL No|T.VVD|S/O No|W/O No|W/O\nCreation Date|";
                  HeadTitle += "Invoice No|Invoice\nConfirm Date|Reference No|Reason|Internal\nRemark|";
                  HeadTitle += "Amount Kind|Default\nS/P|S/P\nType|Agmt Rate TP|Oneway\nRoundTrip|Currency|Basic|Nego|Fuel|Additional|Total|KEY|";
                  HeadTitle += "Agmt No1|Agmt No2|Agmt RT TP CD|Cnt Flag|Cust Cnt|Cust Seq";

                  SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:4, DataRowMerge:0, } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ 
                    {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck" },
	                {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"fm_yard",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"via_loc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"via_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"to_loc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"to_yard",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"dor_loc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"dor_zone",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_val",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dor_de_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"truck_vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"so_number",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wo_number",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_cfm_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"spl_iss_rsn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:100 },
	                {Type:"Popup",     Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"amount_kind",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trsp_dflt_vndr_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"sp_type",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_rate_type_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"way_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"bzc_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"nego_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"fuel_scg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"etc_add_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"total_amt",             KeyField:0,   CalcLogic:"|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|",Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"ovr_wgt_scg_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd" },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq" },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_rate_type" },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_way_type" },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_nomi_trkr_flg" },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd" },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq" },
	                {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cgo_tp_cd" },
	                {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"surcharge_key",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
                    {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"scg_ind_cd" },
	                {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
	                InitColumns(cols);
	                SetEditable(1);
	                SetRangeBackColor(1, 16, 1, 33,"#555555");
//	                SetColHidden('ibflag',1);
	                SetColProperty("way_type", {ComboText:"|"+way_typeText, ComboCode:"|"+way_typeCode} );
	       	   		SetColProperty('curr_cd', {ComboText:curr_cdText, ComboCode:curr_cdCode} );
	       	   		ComResizeSheet(sheetObj);
           	   }
            break;
	   case 2:      //SO CREATED SHEET
		    with(sheetObj){
	        	cnt=0;
		      var HeadTitle="ibflag|trsp_so_ofc_cty_cd|trsp_so_seq|vndr_seq";
		      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetVisible(false);
          }
		break;		
		   case 3:      //SURCHARGE SHEET
			    with(sheetObj){
		      var HeadTitle="ibflag|ibcheck|unique_cd|trsp_so_ofc_cty_cd|trsp_so_seq|lgs_cost_cd|lgs_cost_full_nm|trsp_step_tp_cd" ;
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:0 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibcheck" },
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
 * Form validation
 */
function validateForm(sheetObj, formObj, sAction, sFlag) {
	var surcharge_sheetObj = sheetObjects[2];
	switch (sAction) {
		case IBSEARCH:
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			var vvd = formObj.vvdnumber.value;
			var bkg_no = formObj.bkgnumber.value;
			var bl_no = formObj.blnumber.value;
			var eq_no = formObj.eqnumber.value;
			var ref_no = formObj.refnumber.value;
			var so_no = formObj.sonumber.value;
			var wo_no = formObj.wonumber.value;
			var inv_no = formObj.invnumber.value;
			var lvfrmDate = doSepRemove(doSepRemove(formObj.from_date.value, " "), "-");
			var lvtoDate = doSepRemove(doSepRemove(formObj.to_date.value, " "), "-");
			if ((vvd == null || ComTrim(vvd) == "") && (bkg_no == null || ComTrim(bkg_no) == "") && (bl_no == null || ComTrim(bl_no) == "") && (eq_no == null || ComTrim(eq_no) == "") && (ref_no == null || ComTrim(ref_no) == "") && (so_no == null || ComTrim(so_no) == "")
					&& (wo_no == null || ComTrim(wo_no) == "") && (inv_no == null || ComTrim(inv_no) == "")) {
				if (lvfrmDate == "" && lvtoDate == "") {
					ComShowCodeMessage("TRS90070");
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
			if (!TrsComValidFormat("SO", so_no, true)) {
				return false;
			}
			if (!TrsComValidFormat("WO", wo_no, true)) {
				return false;
			}
			break;
		case IBSAVE:
			var checkList = sheetObj.FindCheckedRow('ibcheck');
			if (checkList == '') {
				ComShowCodeMessage('COM12176');
				return;
			}
			/* SO CREATION CHECK RULE : 1. CURRENCY IS EMPTY/NULL, 2. TOTAL AMOUNT IS EMPTY/NULL */
			if (sFlag == "SO_CREATE") {
				var supplementSOTpCd = formObj.hid_kind.value;
				var checkArray = checkList.split('|');
				for ( var k = 0; k < checkArray.length - 1; k++) {
					var row = checkArray[k];
					var amountKind = sheetObj.GetCellValue(row, "amount_kind");
					if (amountKind == key_row_name) {
						var agmtOfcCtyCd = sheetObj.GetCellValue(row, "agmt_ofc_cty_cd");
						var agmtSeq = sheetObj.GetCellValue(row, "agmt_seq");
						var agmtRateTypeCd = sheetObj.GetCellValue(row, "agmt_rate_type");
						var agmtWayTypeCd = sheetObj.GetCellValue(row, "agmt_way_type");
						var agmtCurrCd = sheetObj.GetCellValue(row, "curr_cd");
						var agmtBzcAmt = sheetObj.GetCellValue(row, "bzc_amt");
						var agmtFuelScgAmt = sheetObj.GetCellValue(row, "fuel_scg_amt");
						var agmtEtcAddAmt = sheetObj.GetCellValue(row, "etc_add_amt");
						var agmtTotalAmt = sheetObj.GetCellValue(row, "total_amt");
						if (supplementSOTpCd == "AS" && (agmtCurrCd == null || agmtCurrCd == "" || agmtEtcAddAmt == null || Number(agmtEtcAddAmt) == 0)) {
							ComShowCodeMessage('TRS90381');
							return false;
						} else if (supplementSOTpCd == "RR" && (agmtOfcCtyCd == null || agmtOfcCtyCd == "" || agmtSeq == null || agmtSeq == "" || agmtRateTypeCd == null || agmtRateTypeCd == "" || agmtWayTypeCd == null || agmtWayTypeCd == "" || agmtTotalAmt == null || Number(agmtTotalAmt) == 0)) {
							ComShowCodeMessage('TRS90381');
							return false;
						}
					}
				}
			}
			break;
	}
	return true;
}
/* handling sheet process */
function doActionIBSheet(sheetObj, formObj, sAction, sFlag) {
	sheetObj.ShowDebugMsg(false);
	var formObj = document.form;
	switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction, "")) {
				formObj.hid_from_node.value = formObj.search_fm_loc.value + (document.search_fm_yard == undefined ? "" : document.search_fm_yard.GetSelectCode());
				formObj.hid_via_node.value = formObj.search_via_loc.value + (document.search_via_yard == undefined ? "" : document.search_via_yard.GetSelectCode());
				formObj.hid_to_node.value = formObj.search_to_loc.value + (document.search_to_yard == undefined ? "" : document.search_to_yard.GetSelectCode());
				formObj.hid_dor_node.value = formObj.search_door_loc.value + (document.search_door_yard == undefined ? "" : document.search_door_yard.GetSelectCode());
				formObj.hid_from_date.value = removeBar(formObj.from_date.value);
				formObj.hid_to_date.value = removeBar(formObj.to_date.value);
				formObj.hid_provider.value = formObj.combo_svc_provider.value;
				formObj.hid_period.value = formObj.sel_period.value;
				formObj.hid_tp_sz.value = formObj.tp_sz.value;
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch("ESD_TRS_0016GS.do", TrsFrmQryString(formObj), { Sync : 2 });
				sheetObj.CheckAll("ibcheck", 0, 1);
				cols_controll_color();
				if (sFlag = "" || sFlag != "SO_CREATE") {
					sheetObjects[1].RemoveAll();
				}
				sheetObjects[2].RemoveAll();
			}
			break;
		case IBSAVE:
			var mainSheetObj = sheetObjects[0];
			var creSheetObj = sheetObjects[1];
			var surchargeSheetObj = sheetObjects[2];
			var mainQueryString = "";
			var surchargeQueryString = "";
			if (sFlag == "SO_CREATE") {
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				for ( var k = 0; k < checkArray.length - 1; k++) {
					var row = checkArray[k];
				}
				if (!validateForm(sheetObj, formObj, sAction, sFlag))
					return false;
				if (!ComShowCodeConfirm("TRS90478")) {
					return false;
				}
				var rowCount = mainSheetObj.RowCount();
				var checkedRow = "";
				var targetRowValue = "";
				addSurchargeData();
				if (rowCount > 0) {
					for ( var i = 1; i < rowCount + 1; i++) {
						checkedRow = mainSheetObj.GetCellValue(i, "ibcheck");
						targetRowValue = mainSheetObj.GetCellValue(i, "amount_kind");
						if (checkedRow > 0) { // Checked ROW PUT only
							if (targetRowValue == key_row_name) { // key_row_name == "Adjusted"
								mainSheetObj.SetRowStatus(i, "I");
							} else {
								mainSheetObj.SetRowStatus(i, "R");
							}
						}
					}
					surchargeQueryString = surchargeSheetObj.GetSaveString(true, false);
					formObj.f_cmd.value = ADD;
					mainQueryString = mainSheetObj.GetSaveString(false, false, "ibcheck");
					creSheetObj.DoSearch("ESD_TRS_0016GS.do", mainQueryString + '&' + TrsFrmQryString(formObj) + '&' + surchargeQueryString, { Sync : 2 });
					doActionIBSheet(sheetObj, formObj, IBSEARCH, "SO_CREATE");
				}
				// END OF "SO_CREATE".
			} else if (sFlag == "WO_ISSUE") {
				if (sheetObj.RowCount() < 1) {
					ComShowCodeMessage("TRS90110");
					return false;
				}
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
				document.woForm.pgmNo.value = "ESD_TRS_0023";
				document.woForm.parentPgmNo.value = "ESD_TRS_M001";
				document.woForm.action = "ESD_TRS_0023.screen";
				document.woForm.submit();
			}
			// END OF "WO_ISSUE".
			break;
		case IBDOWNEXCEL:
			if (sheetObj.RowCount() < 1) {
				ComShowCodeMessage("COM132501");
			} else {
				sheetObj.Down2Excel({ HiddenColumn : true, AutoSizeColumn : 1, ExcelFontSize : 10, ExcelRowHeight : "18", Merge : 1, SheetDesign : 1 });
			}
			break;
		case IBINSERT:
			sheetObj.DataInsert();
			break;
	}
}
/**
 * When an error occurs, query the results to a common processing function DataSheetObject.prototype.event_OnSearchEnd define in IBSheetConfig.js
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	if (errMsg == null || errMsg == '') {
		cols_controll();
	} else {
		ComShowCodeMessage(errMsg);
		return;
	}
}

function change_val() {
	var formObject = document.form;
	var sheetObj1 = sheetObjects[0];
	var val = "";
	var vla_1 = "";
	var sheet1_count = sheetObj1.RowCount();
	if (sheet1_count > 0) {
		if (confirm("If you change the inquiry option, the existing data in the grid will be refreshed. \n\n Are you sure to proceed?")) {
			sheetObj1.RemoveAll();
		} else {
			if (formObject.hid_kind.value == "AS") {
				formObject.btns_radio_kind[1].checked = true;
				formObject.hid_kind.value = "RR";
			} else {
				formObject.btns_radio_kind[0].checked = true;
				formObject.hid_kind.value = "AS";
			}
			return false;
		}
	}
}

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
/**
 * ofc pop-up
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
	var param = "?returnval=" + xx1 + "&returntitle=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9 + "&pgmNo=ESD_TRS_0016";
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 450, 420, "getTRS_ENS_906", '0,1', true);
}
/**
 * Location : If a single selection from a pop-up.
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
	} else if (returnval == "INV") {
		formObject.invnumber.value = rowArray;
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
	if (ComIsNull(formObj.from_date) || ComIsNull(formObj.to_date)) {
		if (ComIsNull(formObj.vvdnumber) && ComIsNull(formObj.bkgnumber) && ComIsNull(formObj.blnumber) && ComIsNull(formObj.refnumber) && ComIsNull(formObj.sonumber) && ComIsNull(formObj.wonumber) && ComIsNull(formObj.invnumber)) {
			ComShowCodeMessage("TRS90070");
			return false;
		} else {
			return true;
		}
	}
	return true;
}
// '?????
function fun_Focus(obj) {
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}
// '-' remove bar
function fun_Focus_del(obj) {
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}
// remove bar
function removeBar(str) {
	var value = "";
	for ( var i = 0; i < str.length; i++) {
		var ch = str.charAt(i);
		if (ch != '-')
			value += ch;
	}
	return value;
}
// add comma
function commaadd(str) {
	var value = "";
	for ( var i = 0; i < str.length; i++) {
		var ch = str.charAt(i);
		if (ch == ',') {
			value += "','";
		} else {
			value += ch;
		}
	}
	return value;
}
function removeDbval(str) {
	var value = "";
	for ( var i = 0; i < str.length; i++) {
		var ch = str.charAt(i);
		if (ch != '???')
			value += ch;
	}
	return value;
}
function BlurDate(obj) {
	var f = document.form;
	var dt = removeBar(obj.value);
	if (!ComIsNull(dt)) {
		if (isValidDate(dt)) {
			if (dt.length == 8) {
				addBar(obj);
				return;
			} else {
				ComShowCodeMessage('TRS90388', 'date');
				obj.select();
				obj.focus();
				return;
			}
		}
		ComShowCodeMessage('TRS90388', 'date');
		obj.select();
		obj.focus();
		return;
	}
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
function checkMonth(month) {
	var intmonth = parseInt(month, 10)
	if (intmonth >= 1 && intmonth <= 12) {
		return true;
	} else {
		return false;
	}
}
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
function addBar(dt) {
	var dat = "";
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	return dat;
}
function addBar_from(obj) {
	var formObject = document.form;
	var dt = obj.value;
	var dat = dt;
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	formObject.from_date.value = dat;
}
function addBar_to(obj) {
	var formObject = document.form;
	var dt = obj.value;
	var dat = dt;
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	formObject.to_date.value = dat;
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
	search_fm_yard.SetSelectCode(lvYard);
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
	search_via_yard.SetSelectCode(lvYard);
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
	search_to_yard.SetSelectCode(lvYard);
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
	search_door_yard.SetSelectCode(lvYard);
}
function getComboList(obj, comObj, sep) {
	comObj = eval(comObj.id);
	var formObj = document.form;
	var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
	var charval = "Y";
	obj.value = lvobj;
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
		ComShowCodeMessage('COM12130', 'NODE');
		obj.value = "";
		obj.focus();
		return false;
	}
	if (lvobj == "") {
		obj.value = "";
		comObj.RemoveAll();
		return false;
		if (obj.name == 'search_fm_loc')
			yard_obj = document.search_fm_yard;
		else if (obj.name == 'search_via_loc')
			yard_obj = document.search_via_yard;
		else if (obj.name == 'search_to_loc')
			yard_obj = document.search_to_yard;
		else if (obj.name == 'search_door_loc')
			yard_obj = document.search_door_yard;
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
 * Common Node popup
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
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 830, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * ???? -bound
 */
function bound_OnChange_1(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_boundmode.value = codeval;
}
/**
 * common -cost
 */
function bound_OnChange_2(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_costmode.value = codeval;
}
/**
 * common -trans
 */
function bound_OnChange_3(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_transmode.value = codeval;
}
/**
 * common -trans
 */
function bound_OnChange_4(obj) {
	var codeval = obj.value;
	var formObject = document.form;
	formObject.hid_transmode.value = codeval;
}

/**
 * rep_commodity
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
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 520, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * rep_commodity
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
 * sheet click
 */
function sheet1_OnDblClick(sheetObj, row, col, value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);
	var r_hid_kind = formObj.hid_kind.value;
	switch (colName) {
		case 'etc_add_amt':
			if (r_hid_kind == 'AS') {
				sheet1_check = sheet1.GetCellValue(row, "amount_kind");
				if (sheet1_check == key_row_name) {
					popSurchargeInputInquiry(sheetObj, row, col, 'modify_supplement');
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
			if (sheetObj.cellValue(row, 'fm_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'fm_nod_cd'));
			}
			break;
		case 'via_nod_cd_sub':
			if (sheetObj.cellValue(row, 'via_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'via_nod_cd'));
			}
			break;
		case 'to_nod_cd_sub':
			if (sheetObj.cellValue(row, 'to_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'to_nod_cd'));
			}
			break;
		case 'dor_nod_cd_sub':
			if (sheetObj.cellValue(row, 'dor_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, colName, sheetObj.cellValue(row, 'dor_nod_cd'));
			}
			break;
		case 'ibcheck':
			break;
	}
}
/**
 * sheet click
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
				}// for(var i=1; i < p; i++) {
			}
			status_change();
			break;
		case 'fm_nod_cd':
			if (sheetObj.cellValue(row, 'fm_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col + 1), sheetObj.cellValue(row, colName));
			}
			break;
		case 'via_nod_cd':
			if (sheetObj.cellValue(row, 'via_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col + 1), sheetObj.cellValue(row, colName));
			}
			break;
		case 'to_nod_cd':
			if (sheetObj.cellValue(row, 'to_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col + 1), sheetObj.cellValue(row, colName));
			}
			break;
		case 'dor_nod_cd':
			if (sheetObj.cellValue(row, 'dor_nod_cd') != '') {
				getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col + 1), sheetObj.cellValue(row, colName));
			}
			break;
		case 'etc_add_amt':
			if (value == '' || Number(value) == 0) {
				var surcharge_sheetObj = sheetObjects[2];
				var unique_cd = sheetObj.GetCellValue(row, 'surcharge_key');
				for ( var a = surcharge_sheetObj.RowCount(); a > 0; a--) {
					if (surcharge_sheetObj.GetCellValue(a, prefix + 'unique_cd') == unique_cd)
						surcharge_sheetObj.RowDelete(a, false);
				}
			} else {
				var surcharge_sheetObj = sheetObjects[2];
				var unique_cd = sheetObj.GetCellValue(row, 'surcharge_key');
				var sum = 0;
				for ( var a = surcharge_sheetObj.RowCount(); a > 0; a--) {
					if (surcharge_sheetObj.GetCellValue(a, prefix + 'unique_cd') == unique_cd)
						sum += Number(surcharge_sheetObj.GetCellValue(a, prefix + 'scg_amt'));
				}
				if (sum != Number(deleteComma(value))) {
					ComShowCodeMessage('COM12114', 'Additional Etc Amount');
					sheetObj.SetCellValue(row, 'etc_add_amt', 0, 0);
					for ( var a = surcharge_sheetObj.RowCount(); a > 0; a--) {
						if (surcharge_sheetObj.GetCellValue(a, prefix + 'unique_cd') == unique_cd)
							surcharge_sheetObj.RowDelete(a, false);
					}
				}
			}
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
function cols_controll() {
	var formObj = document.form;
	var sheet1_x1 = "";
	var sheet1_count = sheetObjects[0].RowCount();
	if (sheet1_count > 0) {
		for ( var i = 1; i < sheet1_count + 1; i++) {
			sheet1_x1 = sheetObjects[0].GetCellValue(i, "amount_kind");
			if (sheet1_x1 == key_row_name) {
				sheetObjects[0].SetCellEditable(i, "nego_amt", 1);
				sheetObjects[0].SetCellEditable(i, "curr_cd", 1);
			} else {
			}
		}
	}
	cols_controll_color();
}
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
function status_change() {
	var formObj = document.form;
	for (i = 1; i <= sheetObjects[0].RowCount(); i++) {
		if (sheetObjects[0].GetRowStatus(i) == "U") {
			sheetObjects[0].SetRowStatus(i, "R");
		}
	}
	cols_controll_color();
}
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.from_date, document.form.to_date, 'yyyy-MM-dd');
}
function popSurchargeInputInquiry(sheetObj, row, col, mode) {
	if (mode == 'multiple') {
		checkList = sheetObj.FindCheckedRow('ibcheck');
		checkArray = checkList.split('|');
		if (checkArray == '') {
			ComShowCodeMessage('TRS90036');
			return false;
		} else {
			row = checkArray[0];
		}
	}
	var formObj = document.scgForm;
	var myOption = "width=950,height=805,menubar=0,status=0,scrollbars=1,resizable=0";
	var myWin = window.open('', "popSurchargeInputInquiry", myOption);
	myWin.focus();
	formObj.open_mode.value = mode;
	formObj.step_cd.value = "WO";
	formObj.sheet_arr_no.value = '2'; // surcharge sheet
	formObj.main_row.value = row;
	var checkList = null;
	var checkArray = null;
	var returnOfcCdStr = '';
	var returnSoSeqStr = '';
	var returnCgoTpCdStr = '';
	var returnRowStr = '';
	if (mode == 'modify_supplement') {
		formObj.unique_cd.value = sheetObj.GetCellValue(row, 'surcharge_key');
		formObj.ofc_cty_cd.value = sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
		formObj.so_seq.value = sheetObj.GetCellValue(row, 'trsp_so_seq');
		formObj.curr_cd.value = sheetObj.GetCellValue(row, 'curr_cd');
		formObj.cgo_tp_cd.value = sheetObj.GetCellValue(row, 'cgo_tp_cd');
	} else if (mode == 'multiple') {
		checkList = sheetObj.FindCheckedRow('ibcheck');
		checkArray = checkList.split('|');
		for ( var k = 0; k < checkArray.length; k++) {
			var row = checkArray[k];
			var amountKind = sheetObj.GetCellValue(row, "amount_kind");
			if (amountKind == key_row_name) {
				formObj.unique_cd.value = sheetObj.GetCellValue(row, 'surcharge_key');
				returnOfcCdStr += sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
				returnSoSeqStr += sheetObj.GetCellValue(row, 'trsp_so_seq');
				returnCgoTpCdStr += sheetObj.GetCellValue(row, 'cgo_tp_cd');
				returnRowStr += row;
				if (row != 0) {
					returnOfcCdStr += '|';
					returnSoSeqStr += '|';
					returnCgoTpCdStr += '|';
					returnRowStr += '|';
				}
			}
		}
		formObj.multi_ofc_cty_cd.value = returnOfcCdStr;
		formObj.multi_so_seq.value = returnSoSeqStr;
		formObj.multi_cgo_tp_cd.value = returnCgoTpCdStr;
		formObj.check_row.value = returnRowStr;
	}
	formObj.scg_ind_cd.value = 'S';
	formObj.action = 'ESD_TRS_0918.screen';
	formObj.target = 'popSurchargeInputInquiry';
	formObj.submit();
}
/**
 * Surcharge Input Inquiry popup
 */
function setSurchargeInputInquiry(winObj, sheetObj, formObj, totalSum) {
	var mainSheetObj = sheetObjects[0];
	var surchargeSheetObj = sheetObjects[2];
	var row = formObj.main_row.value;
	var unique_cd = formObj.unique_cd.value;
	mainSheetObj.SetCellValue(row, 'etc_add_amt', totalSum, 0);
	for ( var a = surchargeSheetObj.RowCount(); a > 0; a--) {
		if (surchargeSheetObj.GetCellValue(a, prefix + 'unique_cd') == unique_cd)
			surchargeSheetObj.RowDelete(a, false);
	}
	var queryStr = sheetObj.GetSaveString(true, false);
	if (queryStr != '') {
		var url = '?prefix=' + prefix;
		surchargeSheetObj.DoSearch("ESD_TRS_0969.screenurl", queryStr, { Sync : 2 });
	}
	ComClosePopup();
}
/**
 * main sheet fuel surcharge, surcharge sheet
 */
function addSurchargeData() {
	var mainSheetObj = sheetObjects[0];
	var surchargeSheetObj = sheetObjects[2];
	var checkList = mainSheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var temp_lgs_cost_cd = '';
	for ( var a = surchargeSheetObj.RowCount(); a > 0; a--) {
		temp_lgs_cost_cd = surchargeSheetObj.GetCellValue(a, prefix + 'lgs_cost_cd');
		temp_lgs_cost_cd = temp_lgs_cost_cd.substring(2, 4);
		if (temp_lgs_cost_cd == 'FU')
			surchargeSheetObj.RowDelete(a, false);
	}
	for ( var k = 0; k < checkArray.length - 1; k++) {
		var amountKind = mainSheetObj.GetCellValue(main_row, "amount_kind");
		if (amountKind == key_row_name) {
			var main_row = checkArray[k];
			var fuelSurcharge = mainSheetObj.GetCellValue(main_row, 'fuel_scg_amt');
			var cgo_tp_cd = mainSheetObj.GetCellValue(main_row, 'cgo_tp_cd');
			if (cgo_tp_cd == 'F') {
				cgo_tp_cd = 'C';
			} else {
				cgo_tp_cd = 'M';
			}
			if (Number(fuelSurcharge) != 0) {
				var surcharge_row = surchargeSheetObj.DataInsert(-1);
				var trans_md = mainSheetObj.GetCellValue(main_row, 'trsp_crr_mod_cd');
				if (trans_md == 'RW') {
					trans_md = 'WR';
				} else if (trans_md == 'TW') {
					trans_md = 'WT';
				} else if (trans_md == 'TR') {
					trans_md = 'RT';
				}
					
				surchargeSheetObj.SetCellValue(surcharge_row, prefix + 'trsp_so_ofc_cty_cd', mainSheetObj.GetCellValue(main_row, 'trsp_so_ofc_cty_cd'), 0);
				surchargeSheetObj.SetCellValue(surcharge_row, prefix + 'trsp_so_seq', mainSheetObj.GetCellValue(main_row, 'trsp_so_seq'), 0);
				surchargeSheetObj.SetCellValue(surcharge_row, prefix + 'unique_cd', mainSheetObj.GetCellValue(main_row, 'surcharge_key'), 0);
				surchargeSheetObj.SetCellValue(surcharge_row, prefix + 'lgs_cost_cd', 'S' + cgo_tp_cd + 'FU' + trans_md, 0);
				surchargeSheetObj.SetCellValue(surcharge_row, prefix + 'scg_amt', mainSheetObj.GetCellValue(main_row, 'fuel_scg_amt'), 0);
			}
		}
	}
}

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

/**
 * Click the Additional Amount gives a separate pop-up window when popup.
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case 'inter_rmk':
			var lvbkg = sheetObj.GetCellValue(row, "bkg_sq");
			var lveqno = sheetObj.GetCellValue(row, "eq_no");
			var url = "ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&inter_rmk_cd=T";
			ComOpenWindowCenter(url, "compopup", 1000, 570, true);
			break;
	}
}