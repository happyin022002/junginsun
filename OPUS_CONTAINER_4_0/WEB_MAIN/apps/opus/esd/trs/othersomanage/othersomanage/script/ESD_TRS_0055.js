/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_TRS_0055.js
 *@FileTitle : Other SO Correction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
var ctMode = 0;
var eqKindFlag = 'container';
var prefix = 'surcharge_';
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case 'btng_sodelete':
				doActionIBSheet(sheetObject, formObject, IBDELETE);
				break;
			case 'btn_retrieve':
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_reset":
				resetForm(formObject);
				break;
			case 'btng_socorrection':
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btng_woissue":
				gotoIssue(sheetObject, formObject);
				break;
			case "btng_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				break;
			case "btn_minimize":
				 if(document.all.MiniLayer.style.display != "none") {
	                    document.all.MiniLayer.style.display="none";                
	                } else {
	                    document.all.MiniLayer.style.display="";                
	                }
	                ComResizeSheet(sheetObject);
				break;
			case "btng_provider":
				rep_OnPopupClick();
				break;
			case "btn_fm_node":
				openHireYardPopup('fm_node');
				break;
			case "btn_via_node":
				if (ctMode == 1 || ctMode == 3) {
					return false;
				}
				openHireYardPopup('via_node');
				break;
			case "btn_to_node":
				openHireYardPopup('to_node');
				break;
			case "btn_dr_node":
				if (ctMode == 1 || ctMode == 2) {
					return false;
				}
					
				openHireYardPopup('dr_node');
				break;
			case "btn_eq_no": {
				rep_Multiful_inquiry(srcName);
				break;
			}
			case 'btns_calendar': {
				getCalendar();
				break;
			}
		} 
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
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
	for (var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
/**
 * initControl
 */
function initControl() {
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
	   case 1:   { 
		   with(sheetObj)	{			   
			   var HeadTitle1="STS||EQ\nNumber|Type\nSize|Cost\nMode|Trans\nMode|From Node|From Node|Via Node|Via Node|To Node|To Node|Door Loc.|Door Loc.|Actual\nCustomer|Door Delivery\nAddress|Service Provider|Service Provider|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBKG No|Reason|Internal\nRemark";
			   var HeadTitle2="STS||EQ\nNumber|Type\nSize|Cost\nMode|Trans\nMode|Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Actual\nCustomer|Door Delivery\nAddress|Provider Code|Provider Name|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Additional\nAmount|Total\nAmount|BKG No|Reference\nBL No|Reason|Internal\nRemark";
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
			   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			   var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ 
			             {Type:"Status",    Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_yard_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"via_loc_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"via_yard_value",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_loc_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_yard_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dr_loc_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dr_yard_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
			             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",  	ColMerge:1,   SaveName:"dor_de_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"vndr_abbr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			             {Type:"Float",     Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bzc_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			             {Type:"Float",     Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"nego_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			             {Type:"Float",     Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fuel_scg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			             {Type:"Float", 	Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"etc_add_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
			             {Type:"Float",     Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"total_amt",             KeyField:0,   CalcLogic:"|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:12 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ref_bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:12 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trsp_purp_rsn",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:0,   EditLen:1000 },
			             {Type:"Popup",     Hidden:1, Width:70,    Align:"Center",  ColMerge:0,   SaveName:"inter_rmk",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,     Align:"Center",  ColMerge:0,   SaveName:"trsp_so_sts_cd",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
			             ];
	      			InitColumns(cols);
	      			SetEditable(1);
	      			SetColHidden('ibflag',1);
	      			ComResizeSheet(sheetObjects[0]);
		   }
		   break;
	   }
		case 2:	{
			with(sheetObj)	{				
				var HeadTitle="STS||EQ\nNumber|Type\nSize|Cost\nMode|Trans\nMode|From Node|From Node|Via Node|Via Node|To Node|To Node|Door Loc.|Door Loc.|Actual\nCustomer|Door Delivery\nAddress|Service Provider|Service Provider|Currency|Basic\nAmount|Fuel\nSurcharge|Over Weight\nSurcharge|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|Reason";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc_value",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_yard_value",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"via_loc_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"via_yard_value",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_loc_value",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_yard_value",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dr_loc_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dr_yard_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		             {Type:"Popup",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Popup",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dor_de_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bzc_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"nego_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fuel_scg_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"etc_add_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"total_amt",             KeyField:0,   CalcLogic:"|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ref_bkg_no",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ref_bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trsp_purp_rsn",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		             {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:12 } ];
	      			InitColumns(cols);
	      			SetEditable(1);
	      			SetColHidden('ibflag',1);
	      			SetVisible(0);
			}
			break;			
		}
		case 3:      {
			with(sheetObj)	{
				var HeadTitle="STS||Office|Cost Mded|Trans Mode|Bound|Remarks|Created Date|Creation Office|User ID" ;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:0 } );
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
		             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incur_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'chss_no',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
		             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incur_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_chss_no',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
				SetVisible(0);
			}
		    break;
		}
	}
}

/**
 * move to W/O Issue
 */
function gotoIssue(sheetObj, formObj) {
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	if (checkList == '') {
		ComShowCodeMessage('COM12176');
		return;
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
	return;
}

/*
 * handling of Sheet
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		switch (sAction) {
			case IBSEARCH:
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH09;
				sheetObj.DoSearch("ESD_TRS_0018GS.do", TrsFrmQryString(formObj));
				break;
			case IBSAVE:
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				if (checkList == '') {
					ComShowCodeMessage('COM12176');
					return false;
				}
				var checkArray = checkList.split('|');
				sheetObj.RemoveEtcData();
				formObj.f_cmd.value = MODIFY;
				sheetObj.DoSave("ESD_TRS_0018GS.do", TrsFrmQryString(formObj), 'ibcheck', false);
				break;
			case IBDOWNEXCEL:
				if (sheetObj.RowCount() == 0) {
					ComShowCodeMessage("COM132501");
					return;
				} else {
					sheetObj.Down2Excel({ HiddenColumn : 1, Merge : 1 });
				}
				break;
			case IBINSERT:
				sheetObj.DataInsert();
				break;
			case IBDELETE:
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				if (checkList == '') {
					ComShowCodeMessage('COM12176');
					return false;
				}
				if(!ComShowCodeConfirm("COM12165")) return false;
				formObj.f_cmd.value = REMOVE;
				sheetObj.DoSave("ESD_TRS_0018GS.do", { Param : TrsFrmQryString(formObj), Col : 'ibcheck', Sync : 2,  Quest : 0});
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * Screen form validation process for processing the input values
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			if (formObj.eq_no.value == '') {
				if (formObj.fmdate == '') {
					ComShowCodeMessage('COM12114', 'from date');
					formObj.fmdate.focus();
					return false;
				} else if (formObj.todate == '') {
					ComShowCodeMessage('COM12114', 'to date');
					formObj.todate.focus();
					return false;
				}
				var days_between = ComGetDaysBetween(formObj.fmdate, formObj.todate);
				if (days_between < 0) {
					ComShowCodeMessage("TRS90118");
					formObj.fmdate.focus();
					return false;
				}
				if (days_between > 30) {
					ComShowCodeMessage("TRS90424");
					return false;
				}
			}

			if (formObj.trs_cost_md_cd.options[0].selected) {
				ComShowCodeMessage('COM12114', 'Cost Mode');
				formObj.trs_cost_md_cd.focus();
				return false;
			} else if (formObj.trs_md_cd.options[0].selected) {
				ComShowCodeMessage('COM12114', 'Trans Mode');
				formObj.trs_md_cd.focus();
				return false;
			}
			break;
		}
	}
	return true;
}
/**
 * Get a list of external combo box
 */
function getComboList(obj) {
	var yard_obj = null;
	var formObj = document.form;
	obj.value = obj.value.toUpperCase();
	if (obj.name == 'search_fm_loc') {
		yard_obj = search_fm_yard;
		if (formObj.trs_cost_md_cd.value == 'CN') {
			formObj.TRSP_SO_EQ_KIND.value = 'N';
		} else if (formObj.trs_cost_md_cd.value == 'CF') {
			formObj.TRSP_SO_EQ_KIND.value = 'F';
		}
	} else if (obj.name == 'search_via_loc') {
		yard_obj = search_via_yard;
		formObj.TRSP_SO_EQ_KIND.value = '';
	} else if (obj.name == 'search_to_loc') {
		yard_obj = search_to_yard;
		if (formObj.trs_cost_md_cd.value == 'CN') {
			formObj.TRSP_SO_EQ_KIND.value = 'F';
		} else if (formObj.trs_cost_md_cd.value == 'CF') {
			formObj.TRSP_SO_EQ_KIND.value = 'N';
		}
	} else if (obj.name == 'search_dr_loc') {
		yard_obj = search_dr_yard;
		formObj.TRSP_SO_EQ_KIND.value = '';
	} else {
		formObj.TRSP_SO_EQ_KIND.value = '';
	}
	var locValue = obj.value;
	if (ComTrim(locValue) == '') {
		yard_obj.RemoveAll();
		return;
	}
	if (obj.name == 'search_dr_loc') {
		getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
	} else {
		getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
	}
}
/**
 * enter check
 */
function enterCheck(obj) {
	if (event.keyCode == 13) {
		switch (ComGetEvent("name")) {
			case 'search_fm_loc':
			case 'search_via_loc':
			case 'search_to_loc':
			case 'search_dr_loc':
				getComboList(obj);
				break;
		}
	}
}
/**
 * Common Node popup
 */
function openHireYardPopup(btn_obj) {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getCOM_ENS_061_1";
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
	if (btn_obj == 'dr_node') {
		v_mode = "zone"
	} else {
		v_mode = "yard";
	}
	var returnFunction = 'setFmNode';
	if (btn_obj == 'via_node')
		returnFunction = 'setViaNode';
	else if (btn_obj == 'to_node')
		returnFunction = 'setToNode';
	else if (btn_obj == 'dr_node')
		returnFunction = 'setDoorNode';
	var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9 + "&mode=" + v_mode;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 830, 500, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * popSearchPiCommCodeGrid process
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
 * fmNode through a pop-up settings
 */
function setFmNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var loc = node.substring(0, 5);
	var yard = node.substring(5, 7);
	document.form.search_fm_loc.value = loc;
	getComboList(document.form.search_fm_loc);
	search_fm_yard.SetSelectCode(yard, true);
}
/**
 * viaNode through a pop-up settings
 */
function setViaNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var loc = node.substring(0, 5);
	var yard = node.substring(5, 7);
	document.form.search_via_loc.value = loc;
	getComboList(document.form.search_via_loc);
	search_via_yard.SetSelectCode(yard, true);
}
/**
 * toNode through a pop-up settings
 */
function setToNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var loc = node.substring(0, 5);
	var yard = node.substring(5, 7);
	document.form.search_to_loc.value = loc;
	getComboList(document.form.search_to_loc);
	search_to_yard.SetSelectCode(yard, true);
}
/**
 * doorNode through a pop-up settings
 */
function setDoorNode(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	var node = colArray[3];
	var loc = node.substring(0, 5);
	var yard = node.substring(5, 7);
	document.form.search_dr_loc.value = loc;
	getComboList(document.form.search_dr_loc);
	search_dr_yard.SetSelectCode(yard, true);
}
/**
 * Click the Additional Amount gives a separate pop-up window when popup.
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
		case 'act_cust_cnt_cd':
		case 'dor_de_addr':
			popActualCustomer(sheetObj, document.form);
			break;
		case 'inter_rmk':
			var lvbkg = sheetObj.GetCellValue(row, "ref_bkg_no");
			var lveqno = sheetObj.GetCellValue(row, "eq_no");
			var lvsono = sheetObj.GetCellValue(row, "trsp_so_ofc_cty_cd") + sheetObj.GetCellValue(row, "trsp_so_seq");
			var url = "ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&inter_rmk_cd=T";
			ComOpenWindowCenter(url, "compopup", 1000, 570, true);
			break;
	}
}
function sheet1_OnDblClick(sheetObj, row, col) {
	var colName = sheetObj.ColSaveName(col);
	switch (colName) {
//		case 'etc_add_amt':
//			popSurchargeInputInquiry(sheetObj, row, col);
//			break;
	}
}

/**
 * Viewed reset condition
 */
function resetForm(formObj) {
	formObj.fmdate.value = beforeOneMonth;
	formObj.todate.value = today;
	formObj.trs_cost_md_cd.options[0].selected = true;
	formObj.trs_md_cd.options[0].selected = true;
	formObj.search_fm_loc.value = '';
	search_fm_yard.RemoveAll();
	formObj.search_to_loc.value = '';
	search_to_yard.RemoveAll();
	formObj.search_via_loc.value = '';
	search_via_yard.RemoveAll();
	formObj.search_dr_loc.value = '';
	search_dr_yard.RemoveAll();
	formObj.eq_no.value = '';
}
/**
 * COST MODE, TRANS MODE reset when changing query conditions
 */
function resetSearchCondition(selObj) {
	var formObj = document.form;
	formObj.search_fm_loc.value = '';
	search_fm_yard.RemoveAll();
	formObj.search_via_loc.value = '';
	search_via_yard.RemoveAll();
	formObj.search_to_loc.value = '';
	search_to_yard.RemoveAll();
	formObj.search_dr_loc.value = '';
	search_dr_yard.RemoveAll();
	var costMode = formObj.trs_cost_md_cd.value;
	var tranMode = formObj.trs_md_cd.value;
	if ((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR')
		ctMode = 1;
	else if (!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR')
		ctMode = 2;
	else if ((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR')
		ctMode = 3;
	else if (!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR')
		ctMode = 4;
	setKindEnabled();
}
/**
 * COST MODE, TRANS MODE to select the query processing conditions enabled
 */
function setKindEnabled() {
	var sheetObj = sheetObjects[0];
	var obj = document.form;
	switch (ctMode) {
		case 1:
			obj.search_via_loc.disabled = true;
			obj.search_dr_loc.disabled = true;
			search_via_yard.SetEnable(0);
			search_dr_yard.SetEnable(0);
			break;
		case 2:
			obj.search_via_loc.disabled = false;
			obj.search_dr_loc.disabled = true;
			search_via_yard.SetEnable(1);
			search_dr_yard.SetEnable(0);
			break;
		case 3:
			obj.search_via_loc.disabled = true;
			obj.search_dr_loc.disabled = false;
			search_via_yard.SetEnable(0);
			search_dr_yard.SetEnable(1);
			break;
		case 4:
			obj.search_via_loc.disabled = false;
			obj.search_dr_loc.disabled = false;
			search_via_yard.SetEnable(1);
			search_dr_yard.SetEnable(1);
			break;
	}
}
function setEqKindRadio(selObj) {
	var sheetObj = sheetObjects[0];
	if (sheetObj.RowCount() > 0 && eqKindFlag != selObj.value) {
		if (ComShowCodeConfirm('TRS90230')) {
			sheetObjects[0].RemoveAll();
			eqKindFlag = selObj.value;
			return;
		} else {
			if (eqKindFlag == 'container')
				document.form.eq_kind[0].checked = true;
			else if (eqKindFlag == 'chassis')
				document.form.eq_kind[1].checked = true;
			else if (eqKindFlag == 'genset')
				document.form.eq_kind[2].checked = true;
			return;
		}
	} else {
		eqKindFlag = selObj.value;
	}
}
/**
 * number check
 */
function checkNumber(obj, delflag) {
	if (!ComIsNumber(obj)) {
		ComShowCodeMessage('COM12122', obj.name);
		if (delflag)
			obj.value = '';
	}
}
/**
 * Pop-up call rep_commodity
 */
function rep_Multiful_inquiry(btn_obj) {
	var formObject = document.form;
	var cmdt_cd_val = "";
	var rep_cmdt_cd_val = "";
	var cmdt_desc_val = "";
	var classId = "getTRS_ENS_906";
	var xx1 = btn_obj; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var param = "?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9 + "&pgmNo=ESD_TRS_0055";
	ComOpenPopup('ESD_TRS_0906.do' + param, 420, 415, 'getTRS_ENS_906', '0,1', true);
}
/**
 * Location: If a pop-up from a single selection.
 */
function getTRS_ENS_906(rowArray, x1) {
	var formObject = document.form;
	if (x1 == 'btn_eq_no') {
		formObject.eq_no.value = rowArray;
		checkDigit();
	}
}

/**
 * 
 * @param sheetObject
 * @param formObject
 */
function popActualCustomer(sheetObject, formObject) {
	ComOpenPopup('ESD_TRS_0914.screen?conti_cd=&act_loc=&zone_cd=', 800, 565, "ESD_TRS_0914", '0,0', true);
}

/**
 * 
 * @param winObj
 * @param selected_row
 * @param act_cust_cd
 * @param act_cust_cnt_cd
 * @param act_cust_seq
 * @param act_cust_addr_seq
 * @param act_cust_nm
 * @param factory_nm
 * @param factory_zip_code
 * @param factory_addr
 * @param factory_tel_no
 * @param factory_fax_no
 * @param pic_nm
 */
function applyAtualCustomer(winObj, selected_row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm) {
	var sheetObj = sheetObjects[0];
	var row = sheetObj.GetSelectRow();
	sheetObj.SetCellValue(row, 'act_cust_cnt_cd', act_cust_cd, 0);
	sheetObj.SetCellValue(row, 'dor_de_addr', factory_addr, 0);
}
/**
 * 
 */
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.fmdate, document.form.todate, 'yyyy-MM-dd');
}
/**
 * Surcharge Input Inquiry popup
 */
/*
function popSurchargeInputInquiry(sheetObj, row, col) {
	var myOption = "width=773,height=805,menubar=0,status=0,scrollbars=0,resizable=0";
	var url = 'ESD_TRS_0918.screen';
	url += '?unique_cd=' + sheetObj.GetCellValue(row, 'surcharge_key');
	url += '&open_mode=search';
	url += '&step_cd=WO';
	url += '&main_row=' + row;
	url += '&sheet_arr_no=2';
	url += '&ofc_cty_cd=' + sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd');
	url += '&so_seq=' + sheetObj.GetCellValue(row, 'trsp_so_seq');
	ComOpenPopup(url, 950, 800, "ESD_TRS_0918", "1,0,1,1,1,1,1", true);
}
*/

/**
 * 
 * @param obj
 */
function fun_Focus(obj) {
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

/**
 * sheet1_OnSaveEnd
 */
function sheet1_OnSaveEnd(sheetObj, errCode, errMsg) {
	if (errCode >= 0) {
		switch (Number(document.form.f_cmd.value)) {
			case MODIFY : {
				ComShowCodeMessage('TRS90105');
				break;
			}
			case REMOVE: {
				ComShowCodeMessage('TRS90109');
				var checkList = sheetObj.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				for ( var k = checkArray.length - 1; k >= 0; k--) {
					sheetObj.RowDelete(checkArray[k], false);
				}
				break;
			}
		}
	}
}

/**
 * 
 * @param obj
 */
function checkDigit(obj) {
	var formObj = document.form;
	if (obj == undefined) {
		obj = formObj.eq_no;
	}
	obj.value = obj.value.toUpperCase();
	if (formObj.eq_kind[0].checked) {
		obj.value = multiCntrChkDgt(obj.value);
	}
}
// Check the data on blur
function BlurDate(obj) {
	var f = document.form;
	var dt = obj.value;
	if (dt == "") {
	} else {
		if (isValidDate(dt)) {
			if (dt.length == 8) {
				addBar(obj);
				return;
			} else {
				ComShowCodeMessage('TRS90070');
				obj.select();
				obj.focus();
				return;
			}
		}
		ComShowCodeMessage('TRS90070');
		obj.select();
		obj.focus();
		return;
	}
}
// Check the effective date of)
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
// Check the effective date of
function isDatecheck(year, month, day) {
	if (parseInt(year) >= 1900 && checkMonth(month) && checkDay(year, month, day)) {
		return true;
	} else {
		return false;
	}
}
// Month Check
function checkMonth(month) {
	var intmonth = parseInt(month, 10)
	if (intmonth >= 1 && intmonth <= 12) {
		return true;
	} else {
		return false;
	}
}
// Check the effective date of
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
// Date format yyyy-mm-dd
function addBar(dt) {
	var dat = "";
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	return dat;
}
// Date format yyyy-mm-dd
function addBar_from(obj) // Date format yyyy-mm-dd
{
	var formObject = document.form;
	var dt = obj.value;
	var dat = dt;
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	formObject.fmdate.value = dat;
}
// Date format yyyy-mm-dd
function addBar_to(obj) // Date format yyyy-mm-dd
{
	var formObject = document.form;
	var dt = obj.value;
	var dat = dt;
	if (dt.length == 8) {
		dat = dt.substr(0, 4) + '-' + dt.substr(4, 2) + '-' + dt.substr(6, 2);
	}
	formObject.todate.value = dat;
}
// '-' Clear
function fun_Focus_del(obj) {
	var val = removeBar(obj.value);
	obj.value = val;
	obj.select();
}
// Addition to date.
function getDateBetween(obj) {
	if (document.form.fmdate.value != "" && document.form.fmdate.value.split("-").join("").length == 8) {
		document.form.todate.value = ComGetDateAdd(obj.value, "D", 30, "-");
	}
}