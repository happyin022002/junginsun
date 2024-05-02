/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0028.js
*@FileTitle  :  USA 404 EDI Status Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
var docMessage="";
var R=0;
var G=255;
var B=0;
var parmOfccd="";
var parmSoseq="";
var rail_road_codeCode;
var rail_road_codeText;
document.onclick=processButtonClick;
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function loadPage() {
	initComponet();
	for(var i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initRailRoad();
}

function initComponet() {
	$('#pod_cd').change(function(event) {
		event.isDefaultPrevented();
		var value = $(this).val();
		if (ComIsNull(value)) {
			$('#pod_nod_cd').val("");
		} else {
			if (value.length < 5) {
				$(this).val("");
				$('#pod_nod_cd').val("");
			}
		}
	});
	$('#pod_nod_cd').change(function(event) {
		event.isDefaultPrevented();
		if (ComIsNull($('#pod_cd').val())) {
			$(this).val("");
		} else {
			if ($(this).val().length < 2) {
				$(this).val("");
			}
		}
	});
}

function initRailRoad() {
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	getRailVendorComboList(sel_railroad , rail_road_codeCode , rail_road_codeText , 'ALL');
	initVendorCombo(sel_railroad); 	
	sel_railroad.SetSelectIndex(0);
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1: 
		    with(sheetObj){
//			      var HeadTitle="STS|S|Cancellation\nEDI|Frustrate|Confirmation\nMSG Send|Rebill|Status|";
			      var HeadTitle="STS|S|Cancellation\nEDI|Frustrate|Confirmation\nMSG Send|Rebill|Status|Through|";
			      HeadTitle += "Container\nNumber|Booking No|BL No|Reference\nNo|Unplanned|Rail ORG|Rail ORG|InterchangeⅠ|InterchangeⅠ|Interchange Ⅱ|Interchange Ⅱ|Rail DEST|Rail DEST|Yard Character|Rail\nRoad|Billing EDI\nSent Time|Billing EDI\nSent Time|Bill\nACK/NCK|Bill ACK/NCK\nReceived Time|Bill ACK/NCK\nReceived Time|";
			      HeadTitle += "Cancel Request\nTime|Cancel Request\nTime|Cancel Status|Cancel Request\nReason|Cancel Request\nReject Time|Cancel Request\nReject Time|Cancel Request\nReject Reason|Bill ACK/NCK\nError Remark|Waybill\nNo|Agreement\nReference No|Route\nPlan|S/O\nCreation Time|S/O\nCreation Time|" ;
			      HeadTitle += "Type\nSize|BKG\nAttached|BKG\nSPE|CNTR\nSPE|BKG Cargo\nType|";
			      HeadTitle += "POR\n(Loc/Node)|POL\n(Loc/Node)|POD\n(Loc/Node)|DEL\n(Loc/Node)|DEL\nSCC|";
			      HeadTitle += "EDI\nKind|Curr.|Total|Basic|Basic|Surcharge|Surcharge|Fuel|OWT|Hazmat|ETC|";
			      HeadTitle += "Customs\nC.LOC|Trunk\nVVD|Lane|STCC|Commodity Group\nDescription|Rail\nBulk|Commodity\nDescription|Seal No|";
			      HeadTitle += "AES No|AES No|Billing EDI\nResent Time|Billing EDI\nResent Time|";
			      HeadTitle += "Weight(LBS)|Weight(LBS)|Weight(LBS)|Shipper|Consignee|IT No|Rail AMS No|";
			      HeadTitle += "EDI\nCC|EDI CC\nACK/NCK|EDI CC ACK/NCK\nReceived Time|EDI CC ACK/NCK\nReceived Time|Confirmation MSG\nSent Time|" ;
			      HeadTitle += "Confirmation MSG\nSent Time|Request S/P|Cancel\nReason|Internal\nRemark|Internal\nRemark|Remark\n(Special Instruction)|Billing Sent\n User ID|Frustrate|CN Underbond\nRelease\nnot Required";
			      
//			      var HeadTitle2="STS|S|Cancellation\nEDI|Frustrate|Confirmation\nMSG Send|Rebill|Status|";
			      var HeadTitle2="STS|S|Cancellation\nEDI|Frustrate|Confirmation\nMSG Send|Rebill|Status|Through|";
			      HeadTitle2 += "Container\nNumber|Booking No|BL No|Reference\nNo|Unplanned|Rail ORG|Rail ORG|InterchangeⅠ|InterchangeⅠ|Interchange Ⅱ|Interchange Ⅱ|Rail DEST|Rail DEST|Yard Character|Rail\nRoad|Billing EDI\nSent Time|Billing EDI\nSent Time|Bill\nACK/NCK|Bill ACK/NCK\nReceived Time|Bill ACK/NCK\nReceived Time|";
			      HeadTitle2 += "Cancel Request\nTime|Cancel Request\nTime|Cancel Status|Cancel Request\nReason|Cancel Request\nReject Time|Cancel Request\nReject Time|Cancel Request\nReject Reason|Bill ACK/NCK\nError Remark|Waybill\nNo|Agreement\nReference No|Route\nPlan|S/O\nCreation Time|S/O\nCreation Time|" ;
			      HeadTitle2 += "Type\nSize|BKG\nAttached|BKG\nSPE|CNTR\nSPE|BKG Cargo\nType|";
			      HeadTitle2 += "POR\n(Loc/Node)|POL\n(Loc/Node)|POD\n(Loc/Node)|DEL\n(Loc/Node)|DEL\nSCC|";
			      HeadTitle2 += "EDI\nKind|Curr.|Total|Basic|Basic|Surcharge|Surcharge|Fuel|OWT|Hazmat|ETC|";
			      HeadTitle2 += "Customs\nC.LOC|Trunk\nVVD|Lane|STCC|Commodity Group\nDescription|Rail\nBulk|Commodity\nDescription|Seal No|";
			      HeadTitle2 += "AES No|AES No|Billing EDI\nResent Time|Billing EDI\nResent Time|";
			      HeadTitle2 += "Net|Tare|Gross|Shipper|Consignee|IT No|Rail AMS No|";
			      HeadTitle2 += "EDI\nCC|EDI CC\nACK/NCK|EDI CC ACK/NCK\nReceived Time|EDI CC ACK/NCK\nReceived Time|Confirmation MSG\nSent Time|" ;
			      HeadTitle2 += "Confirmation MSG\nSent Time|Request S/P|Cancel\nReason|Internal\nRemark|Internal\nRemark|Remark\n(Special Instruction)|Billing Sent\n User ID|Frustrate|CN Underbond\nRelease\nnot Required";
			      
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 6 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"},  { Text:HeadTitle2, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ 
					             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,  SaveName:"ibflag"},     
			                   	 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,  SaveName:"chk1" },
					             {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"chk2"},
					             {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,  SaveName:"chk4"},
					             {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,  SaveName:"chk3",                     HeaderCheck:0},
					             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,  SaveName:"chk5"},
					             {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,  SaveName:"trsp_so_sts_cd_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"trsp_rail_bil_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"eq_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"bkg_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"bl_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"ref_id",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"upln_so_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"fm_nod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,  SaveName:"fm_nod_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"interchange1_loc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,  SaveName:"interchange1_nod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"interchange2_loc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,  SaveName:"interchange2_nod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"to_nod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,  SaveName:"to_nod_yard",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"yd_chr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,  SaveName:"vndr_abbr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"bil_edi_snt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,  SaveName:"bil_edi_snt_dt_hms",       KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"bil_edi_rcv_rslt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"bil_edi_rcv_rslt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,  SaveName:"bil_edi_rcv_rslt_dt_hms",  KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"cxl_rqst_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,  SaveName:"cxl_rqst_dt_hms",          KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,  SaveName:"status_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,  SaveName:"cxl_rqst_rsn",             KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"cxl_rqst_rjct_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,  SaveName:"cxl_rqst_rjct_dt_hms",     KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"cxl_rqst_rjct_rsn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"cxl_rqst_rjct_rsn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"waybill_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,  SaveName:"ref_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,  SaveName:"rout_pln_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"cre_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,  SaveName:"cre_dt_hms",               KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,  SaveName:"eq_tpsz_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"bkg_cntr_attached",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,  SaveName:"bkg_spe",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,  SaveName:"spcl_cgo_cntr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"cgo_tp_cd",            	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

					             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"por_nod_cd",            	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"pol_nod_cd",            	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"pod_nod_cd",            	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"del_nod_cd",            	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"del_scc_cd",            	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             
					             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,  SaveName:"bil_iss_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             
					             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"curr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,  SaveName:"tot_amt",                  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,  SaveName:"bzc_amt",                  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Popup",     Hidden:0, Width:20,   Align:"Right",   ColMerge:1,  SaveName:"bzc_amt_pop",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,  SaveName:"scg_amt",                  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Popup",     Hidden:0, Width:20,   Align:"Right",   ColMerge:1,  SaveName:"scg_amt_pop",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,  SaveName:"fuel_scg_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,  SaveName:"ovr_wgt_scg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,  SaveName:"hzd_mtrl_scg_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,  SaveName:"etc_add_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             
					             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"ibd_cstms_clr_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"trunkvvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,  SaveName:"slan_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
					             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,  SaveName:"stcc_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
					             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",     ColMerge:1,  SaveName:"stcc_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
		                        
					             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,  SaveName:"rail_blk_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,  SaveName:"cmdt_name",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"cntr_seal_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"auto_xpt_sys_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"auto_xpt_sys_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:15 },
					             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"bil_edi_rsnt_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,  SaveName:"bil_edi_rsnt_dt_hms",      KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,  SaveName:"cntr_wgt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,  SaveName:"tare_wgt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,  SaveName:"gross_wgt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,  SaveName:"shpr_cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,  SaveName:"cnee_cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"ibd_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"rail_crr_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"mtc_edi_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,  SaveName:"mtc_edi_rcv_rslt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"mtc_edi_rcv_rslt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,  SaveName:"mtc_edi_rcv_rslt_dt_hms",  KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"cfm_msg_snt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,  SaveName:"cfm_msg_snt_dt_hms",       KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"prov_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"wo_rjct_rsn",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"inter_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Image",		Hidden:0, Width:20,   Align:"left",	   ColMerge:1,  SaveName:"pop_img",				     UpdateEdit:0, InsertEdit:0,   ImgHeight:20,         ImgWidth:19 },
					             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,  SaveName:"spcl_instr_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
					             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,  SaveName:"edi_usr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,  SaveName:"trsp_frst_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,  SaveName:"cnd_cstms_clr_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, 	HeaderCheck:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"sub_rail_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"vndr_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"trsp_so_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"trsp_so_ofc_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"rail_cmb_thru_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"rail_cmb_thru_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"cxl_rqst_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"cop_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"cost_act_grp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"repo_pln_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"pln_yrwk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"ref_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"cre_ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"bkg_cgo_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"rail_ord_rjct_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"bil_iss_knt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"lastchk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"inv_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"trsp_bnd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"trsp_agmt_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"trsp_agmt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,  SaveName:"delt_flg",            	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,  SaveName:"trsp_so_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
					             ];
			      InitColumns(cols);
			      SetImageList(1, "img/btns_search_g.gif");
			      SetColProperty(0, "wo_rjct_rsn", 		{ComboText:"RequestedBySP|RQSTByBKG|TRSOwnReason", ComboCode:"RBSP|RBB|TOR"} );
			      SetColProperty(0, 'auto_xpt_sys_cd', 	{ComboText:auto_xpt_sys_cdText, ComboCode:auto_xpt_sys_cdCode} );
			      resizeSheet();
			      SetRangeBackColor(0, SaveNameCol("fuel_scg_amt"), 0, SaveNameCol("etc_add_amt"),"#555555");
			      SetShowButtonImage(1);
			      SetEditable(1);
	      }
		break;
	}
}
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve": {
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
				}
				break;
			}
			case "btn_new": {
				formObject.reset();
				sel_railroad.SetSelectIndex(0);
				break;
			}
			case "btn_minimize": {
                if(document.all.MiniLayer.style.display != "none") {
                    document.all.MiniLayer.style.display="none";                
                } else {
                    document.all.MiniLayer.style.display="";                
                }
                ComResizeSheet(sheetObject, 100);				
				break;
			}
			case "btng_404edisend": {
				doActionIBSheet(sheetObject, formObject, IBSEARCH, "02");
				break;
			}
			case "btng_frustrate": {
				if( validationFrustrate(sheetObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "03");
				}
				break;
			}
			case "btng_downexcel": {
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL, "");
				break;
			}
			case "btng_confirmationmsg": {
				doActionPopupOpen(sheetObject, formObject);
				break;
			}
			case "btng_cancellationedisend": {
				if( validationCancel(sheetObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSAVE, "");
				}
				break;
			}
			case "btng_cancelreqreject": {
				doActionCancelReqReject(sheetObject);
				break;
			}
			case "btns_frmnode":  {
				openHireYardPopup('getFromNode');
				break;
			}
			case "btns_tonode":  {
				openHireYardPopup('getToNode');
				break;
			}
			case "btns_vendor":  {
				rep_OnPopupClick();
				break;
			}
			case "btns_calendar": {
				getCalendar();
				break;
			}
			case "btns_tvvd":  {
				openTVVDPopup();
				break;
			}
			case "btns_multivvd":  {
				openMultipleinquiry('VVD', 'T.VVD');
				break;
			}
			case "btns_multibkg":  {
				openMultipleinquiry('BKG', 'BKG No');
				break;
			}
			case "btns_multibl":  {
				openMultipleinquiry('BLN', 'B/L No');
				break;
			}
			case "btns_multicntr":  {
				openMultipleinquiry('CNT', 'CNTR No');
				break;
			}
			case "btns_multirefno":  {
				openMultipleinquiry('REF', 'REF No');
				break;
			}
			case "btng": {
		        ComOpenWindow('ESD_TRS_0084Pop.screen', 'ESD_TRS_0084', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:800px;dialogHeight:460px', true);
		        break;
			}
			case "btng_rebill": {
				doActionIBSheet(sheetObject, formObject, IBSEARCH, "04");
				break;
			}
			case "btn_pod": {
				selectLoc();
				break;	
			}
		} 
	} catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90106");
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * 
 * @param formObj
 * @returns {Boolean}
 */
function validateFormSearch(formObj) {
	var lvFrmDate=ComTrimAll(ComTrimAll(formObj.frm_plandate.value, " "), "-");
	var lvToDate=ComTrimAll(ComTrimAll(formObj.to_plandate.value, " "), "-");
	var lvFrm_node=ComTrimAll(formObj.frm_node.value, " ");
	var lvTo_node=ComTrimAll(formObj.to_node.value, " ");
	var lvTrunk_vvd=ComTrimAll(formObj.trunk_vvd.value, " ");
	var lvBkg_no=ComTrimAll(formObj.bkg_no.value, " ");
	var lvBill_no=ComTrimAll(formObj.bill_no.value, " ");
	var lvCntr_no=ComTrimAll(formObj.cntr_no.value, " ");
	var lvRef_no=ComTrimAll(formObj.ref_no.value, " ");
	
	if( lvFrmDate == "" ) {
		formObj.frm_plandate.value="";
	}
		
	if( lvToDate == "" ) {
		formObj.to_plandate.value="";
	}
	if( lvTrunk_vvd == "" )  {
		formObj.trunk_vvd.value="";
	}
	if( lvBkg_no == "" )  {
		formObj.bkg_no.value="";
	}
	if( lvBill_no == "" )  {
		formObj.bill_no.value="";
	}
	if( lvCntr_no == "" )  {
		formObj.cntr_no.value="";
	}
	if( lvFrmDate == "" && lvToDate != "" ) { 
		ComShowCodeMessage("TRS90119");
		return false;
	} else if( lvFrmDate != "" && lvToDate == "" ) {
		ComShowCodeMessage("TRS90121");
		return false;
	} else if( lvFrmDate != "" && lvToDate != "" ) {
		if( !ComIsDate(lvFrmDate) ) {
			ComShowCodeMessage("TRS90072");
			formObj.frm_plandate.focus();
			return false;
		} else if( !ComIsDate(lvToDate) ) {
			ComShowCodeMessage("TRS90073");
			formObj.to_plandate.focus();
			return false;
		}
		if( ComGetDaysBetween(lvFrmDate, lvToDate) > 30 ) {
			ComShowCodeMessage("TRS90424");
			return false;
		} else if( ComGetDaysBetween(lvFrmDate, lvToDate) < 0 ) {
			ComShowCodeMessage("TRS90118");
			return false;
		}
	} else {
		if(ComIsEmpty(lvTrunk_vvd) && ComIsEmpty(lvBkg_no) && ComIsEmpty(lvBill_no) && ComIsEmpty(lvCntr_no) && ComIsEmpty(lvRef_no)) {
			ComShowCodeMessage("TRS90124");
			return false;
		}
	}	
	if( lvFrm_node == "" ) {
		formObj.frm_node.value="";
		frm_yard.RemoveAll();
	}
	if( lvTo_node == "" ) {
		formObj.to_node.value="";
		to_yard.RemoveAll(); 
	}
	if( !ComIsAlphabet(ComTrimAll(lvTrunk_vvd, ","), "n") && lvTrunk_vvd != "" ) {
		formObj.trunk_vvd.value="";
		formObj.trunk_vvd.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvBkg_no, ","), "n") && lvBkg_no != "" ) {
		formObj.bkg_no.value="";
		formObj.bkg_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvBill_no, ","), "n") && lvBill_no != "" ) {
		formObj.bill_no.value="";
		formObj.bill_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvCntr_no, ","), "n") && lvCntr_no != "" ) {
		formObj.cntr_no.value="";
		formObj.cntr_no.focus();
		return false;
	}
	var lvRdate="";
	var lvRvndr="";
	if( formObj.rad_date[0].checked ) {
		lvRdate=formObj.rad_date[0].value;
	} else if( formObj.rad_date[1].checked ) {
		lvRdate=formObj.rad_date[1].value;
	} 	
	lvRvndr=formObj.rad_vendor.value;
	formObj.hid_rad_date.value=lvRdate;
	formObj.hid_rad_vendor.value=lvRvndr;
	formObj.hid_frmdate.value=lvFrmDate;
	formObj.hid_todate.value=lvToDate;
	formObj.frm_node.value=lvFrm_node.toUpperCase();
	formObj.to_node.value=lvTo_node.toUpperCase();
	formObj.trunk_vvd.value=lvTrunk_vvd.toUpperCase(); 
	formObj.bkg_no.value=lvBkg_no.toUpperCase();
	formObj.bill_no.value=lvBill_no.toUpperCase();
	formObj.cntr_no.value=lvCntr_no.toUpperCase();
	return true;
}
//handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction, obj) {
	switch(sAction) {
		case IBSEARCH: {
			if( obj == "01" ) {
				formObj.f_cmd.value=SEARCH;
			    IBS_DoSearchSax(sheetObj, "ESD_TRS_0028GS.do", TrsFrmQryString(formObj));
			} else if( obj == "02" ) {
				if( sheetObj.CheckedRows("chk1") < 1 ) {
					ComShowCodeMessage("TRS90036");
				} else {
					docMessage = "S";
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(formObj), "chk1", false, true);
				}
			} else if( obj == "03" ) {
				if(ComShowCodeConfirm("TRS90489")) {
				docMessage="F";
				formObj.f_cmd.value=MULTI03;
				sheetObj.DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(formObj), "chk4", false, true);
				}
			} else if( obj == "04" ) {
				if( sheetObj.CheckedRows("chk5") < 1 ) {
					ComShowCodeMessage("TRS90036");
				} else {
					docMessage = "S";
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(formObj), "chk5", false, true);
				}
			}
			break;
		}
		case IBSAVE: {
 			if( sheetObj.CheckedRows("chk2") < 1 ) {
				ComShowCodeMessage("TRS90036");
			} else {
				docMessage="C";
				formObj.f_cmd.value = MULTI02;
				sheetObj.DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(formObj), "chk2", false, true);
			}
 			break;
		}
		case IBDOWNEXCEL:  {
			if(sheetObj.RowCount() < 1){
				ComShowCodeMessage("COM132501");
			} else {
            	var excludeField = ["bzc_amt_pop", "scg_amt_pop", "pop_img"];
            	var includeField = null; //["cng_ind_flg", "vndr_cm"];
            	sheetObj.Down2Excel( {DownCols: makeExcelDownSkipColumn(sheetObj, true, excludeField, includeField), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
			}
			break;
		}
		case IBSEARCH_ASYNC01:  {
			var param = 'f_cmd='+SEARCH +'&cntr_vndr_svc_cd=RAIL&vndr_cost_cd=TR&vndr_cnt_cd=US,CA';
 	    	var sXml=sheetObj.GetSearchData("ESD_TRS_0999GS.do", param);
	    	rail_road_codeCode=ComGetEtcData(sXml, "rail_vndr_code");
	    	rail_road_codeText=ComGetEtcData(sXml, "rail_vndr_desc");
			break;
		}
		case IBINSERT: {
			sheetObj.DataInsert();
			break;
		}
	}
}
//Object of the Sheet is a pop-up window to pass on
function openObjSheet() {
	return sheetObjects[1];
}

function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
		}
	}
}
function do_railroad(obj) {
	if( obj == "R" ) {
		document.form.combo_svc_provider.style.visibility="visible";
		document.form.trsp_so_vndr_no.style.visibility="visible";
		document.form.btns_vendor.style.visibility="visible";
		document.form.sel_railroad.style.visibility="hidden";	
		document.all.item("SV")[0].style.display="inline";
		document.all.item("SV")[1].style.display="none"			
	} else {
		document.form.combo_svc_provider.style.visibility="hidden";
		document.form.trsp_so_vndr_no.style.visibility="hidden";
		document.form.btns_vendor.style.visibility="hidden";
		document.form.sel_railroad.style.visibility="visible";
		document.all.item("SV")[0].style.display="none";
		document.all.item("SV")[1].style.display="inline"		
	}
}
/* Cancel Req Reject 
 * Target :TRS_TRSP_RAIL_BIL_ORD.CXL_RQST_FLG ='Y'
 *       TRS_TRSP_EDI_RAIL_ORD.TRSP_RAIL_BIL_TP_CD = 'W' 
 */
function doActionCancelReqReject(sheetObj) {
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i<arrRow.length; i++ ) {
		if( sheetObj.GetCellValue(arrRow[i], "cxl_rqst_flg") == "Y" ) {
		} else {
			sheetObj.SetRowStatus(arrRow[i],"R");
			sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
			sheetObj.SetRowBackColor(arrRow[i],"#NANNANNAN");
		}
	}
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg=ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	} else {
        ComOpenWindow('ESD_TRS_0959Pop.screen', 'ESD_TRS_0959', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:800px;dialogHeight:300px', true);
	}
}
// Popup window to confirm the results of processing parts.
function doSearchPopup() {
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	if( validateFormSearch(formObject) ) {
		doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
	}
}

/**
 * Generates an event on Sheet1.
 */
function sheet_OnChange(sheetObj, row , col , value) {
	var chk_last=sheetObj.GetCellValue(row, "lastchk");
	var doc_soseq=sheetObj.GetCellValue(row, "trsp_so_seq");
	var lv_spcl_cgo=null;
	var lv_fm_nod_cd=sheetObj.GetCellValue(row, "fm_nod_cd");
	var lv_to_nod_cd=sheetObj.GetCellValue(row, "to_nod_cd");
	var bnd_cd=sheetObj.GetCellValue(row, "trsp_bnd_cd");
	
	if(sheetObj.GetCellValue(row, "trsp_bnd_cd") == 'I'){
		lv_spcl_cgo=sheetObj.GetCellValue(row, "spcl_cgo_cntr_tp_cd");
	} else {
		lv_spcl_cgo=sheetObj.GetCellValue(row, "bkg_spe");
	}
	
	if( (chk_last == "" || chk_last == "Y") ) {
		if( sheetObj.ColSaveName(col) == "chk1") {
			if( value == "1" ) {
				sheetObj.SetRowStatus(row,"I");
				sheetObj.SetCellValue(row, "chk1", "1", 0);
			} else {
				sheetObj.SetRowStatus(row,"R");
				sheetObj.SetCellValue(row, "chk1", "0", 0);
			}
		} else if( sheetObj.ColSaveName(col) == "chk2" ) {
			if( value == "1" ) {
				sheetObj.SetCellValue(row, "chk2","1", 0);
				sheetObj.SetCellValue(row,  "wo_rjct_rsn", "TOR", 0);
			} else {
				sheetObj.SetCellValue(row, "chk2","0", 0);
				sheetObj.SetCellValue(row,  "wo_rjct_rsn", "", 0);
			}		
		}else if( sheetObj.ColSaveName(col) == "chk5") {
			if( value == "1" ) {
				sheetObj.SetRowStatus(row,"I");
				sheetObj.SetCellValue(row, "chk5", "1", 0);
			} else {
				sheetObj.SetRowStatus(row,"R");
				sheetObj.SetCellValue(row, "chk5", "0", 0);
			}
		} 
	} else {
		sheetObj.SetCellValue(row, "chk1","0",0);
		sheetObj.SetRowStatus(row,"R");
	}
}
/**
 * Cancellation EDI Send button validation function on Click
 */
function validationCancel(sheetObj) {
	if( sheetObj.CheckedRows("chk2") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	} else {
		var sRow=sheetObj.FindCheckedRow("chk2");
		var arrRow=sRow.split("|");
		for( var i=0; i<arrRow.length; i++ ) {
			if( sheetObj.GetCellValue(arrRow[i], "cgo_tp_cd") == "F" ) {
				if( sheetObj.GetCellValue(arrRow[i], "wo_rjct_rsn") == "" ) {
					ComShowCodeMessage("TRS90232");
					sheetObj.SelectCell(arrRow[i], "wo_rjct_rsn");
					return false;
				} else {
					if( sheetObj.GetCellValue(arrRow[i], "trsp_frst_flg") == "Y" ) { //Frustrate if the Y
						if(ComShowCodeConfirm("TRS90231")) {
						} else {
							return false;
						}
					}
					if( sheetObj.GetCellValue(arrRow[i], "wo_rjct_rsn") == "RBB" ) { // Cancel Reason if two RQST BY BKG
						if(ComShowCodeConfirm("TRS90342")) {
						} else {
							return false;
						}
					}
				}
			}
		}
	}
	return true;
}
/**
 * When an error occurs, save the results to a common processing function
 * DataSheetObject.prototype.event_OnSaveEnd defined in IBSheetConfig.js
 */
function sheet_OnSaveEnd(sheetObj, errCode, errMsg) {
	if(errCode < 0) {
	} else {
		if( docMessage == "S" ) {
			ComShowMessage("EDI Send - Success!!");
		} else if( docMessage == "C" ) {
			ComShowMessage("Cancellation EDI Send - Success!!");
		} else if( docMessage == "F" ) {
			ComShowMessage("Frustrate - Success!!");
			frustrate_saveEnd(sheetObj);
		} 
		var formObject=document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObj, formObject, IBSEARCH, "01");
		}
	}
}
/*
 *Frustrate , except for the Empty.
 */
function validationFrustrate(sheetObj) {
	if( sheetObj.CheckedRows("chk4") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	} else {
		var sRow=sheetObj.FindCheckedRow("chk4");
		var arrRow=sRow.split("|");
		for( var i=0; i<arrRow.length; i++ ) {
			if( sheetObj.GetCellValue(arrRow[i], "cgo_tp_cd") == "M" || sheetObj.GetCellValue(arrRow[i], "upln_so_flg")  == 'Y') {
				ComShowCodeMessage("TRS90492");
				return false;
			}
			if( sheetObj.GetCellValue(arrRow[i], "trsp_frst_flg") == "Y" ) {
				ComShowCodeMessage("TRS90491");
				return false;
			}
		}
	}
	return true;
}

/*
 * Frustrate , except for the Empty
 */
function frustrate_saveEnd(sheetObj) {
	var sRow=sheetObj.FindCheckedRow("chk4");
	var arrRow=sRow.split("|");
	for( var i=0; i<arrRow.length; i++ ) {
		sheetObj.SetCellValue(arrRow[i], "trsp_frst_flg","Y");
	}
	return true;
}

//Click the radio button when you retrieve data. CHK3
function sheet_OnClick(sheetObj, Row, Col, Value) {
	switch (sheetObj.ColSaveName(Col)) {
		case "chk3" : {
			if( sheetObj.GetCellValue(Row, "lastchk") == "Y" ) {
				parmOfccd="";
				parmSoseq="";
				parmOfccd=sheetObj.GetCellValue(Row, "trsp_so_ofc_cty_cd");
				parmSoseq=sheetObj.GetCellValue(Row, "trsp_so_seq");
			}	
			break;
		}
		case "pop_img" :  {
			if(sheetObj.GetCellValue(Row, "cgo_tp_cd") == "F" ) {
				var lvbkg=sheetObj.GetCellValue(Row, "bkg_no");
				var lveqno=sheetObj.GetCellValue(Row, "eq_no");
				var lvsono=sheetObj.GetCellValue(Row, "trsp_so_ofc_cty_cd") + sheetObj.GetCellValue(Row, "trsp_so_seq") 
				var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&inter_rmk_cd=T" + "&rail_chk=Y";
				ComOpenWindowCenter(url, "compopup", 1000, 570, true);
			}
			break;
		}
	}
	return;
}

function sheet_OnPopupClick (sheetObj , row , col ) {
    var colName=sheetObj.ColSaveName(col);
    var value=sheetObj.GetCellValue(row, colName);
    switch(colName) {
        case('scg_amt_pop'): {
            var url='?targetRow='+row;
            url += '&trsp_so_ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd'); // OK
            url += '&trsp_so_seq='+sheetObj.GetCellValue(row, 'trsp_so_seq'); // OK
            url += '&ctrl_ofc_cd='+sheetObj.GetCellValue(row, 'cre_ofc_cd');

            url += '&rail_cmb_thru_tp_cd='+sheetObj.GetCellValue(row, 'rail_cmb_thru_tp_cd');
            url += '&rail_cmb_thru_tp_nm='+sheetObj.GetCellValue(row, 'rail_cmb_thru_tp_nm');
            
            url += '&basis_dt='+sheetObj.GetCellValue(row, 'cre_dt');//OK
            url += '&eq_knd_cd='+sheetObj.GetCellValue(row, 'eq_knd_cd');
            url += '&eq_tp_sz_cd='+sheetObj.GetCellValue(row, 'eq_tpsz_cd'); // OK
            url += '&cmb_tp_cd='+sheetObj.GetCellValue(row, 'trsp_so_cmb_tp_cd');
            url += '&cgo_tp_cd='+sheetObj.GetCellValue(row, 'cgo_tp_cd'); // OK
            url += '&bkg_cgo_tp_cd='+sheetObj.GetCellValue(row, 'bkg_cgo_tp_cd'); // OK
            url += '&bound_cd='+sheetObj.GetCellValue(row, 'trsp_bnd_cd'); //OK
            url += '&crr_mod_cd='+sheetObj.GetCellValue(row, 'trsp_crr_mod_cd');
            url += '&cost_mod_cd='+sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd');
            url += '&spcl_cgo_cntr_tp_cd='+sheetObj.GetCellValue(row, 'spcl_cgo_cntr_tp_cd');
            url += '&cust_cnt_cd='+sheetObj.GetCellValue(row, 'po_cust_cnt_cd');
            url += '&cust_seq='+sheetObj.GetCellValue(row, 'po_cust_seq');
            url += '&cmdt_cd='+sheetObj.GetCellValue(row, 'cmdt_cd');
            
            url += '&fm_nod_cd='+sheetObj.GetCellValue(row, 'fm_nod_cd'); //OK
            url += '&fm_nod_yard='+sheetObj.GetCellValue(row, 'fm_nod_yard'); //OK
            url += '&to_nod_cd='+sheetObj.GetCellValue(row, 'to_nod_cd'); //OK
            url += '&to_nod_yard='+sheetObj.GetCellValue(row, 'to_nod_yard'); //OK
            
            url += '&bundle_cnt='+sheetObj.GetCellValue(row, 'bundling_no');
            url += '&wgt_uom='+sheetObj.GetCellValue(row, 'wgt_meas_ut_cd');
            url += '&wgt_qty='+sheetObj.GetCellValue(row, 'cntr_wgt'); //OK
            url += '&agmt_ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_agmt_ofc_cty_cd'); //OK
            url += '&agmt_seq='+sheetObj.GetCellValue(row, 'trsp_agmt_seq'); //OK
            url += '&way_type='+sheetObj.GetCellValue(row, 'po_way_type');
            url += '&vndr_seq='+sheetObj.GetCellValue(row, 'vndr_seq'); //OK
            url += '&curr_cd='+sheetObj.GetCellValue(row, 'curr_cd'); //OK
            url += '&bzc_amt='+sheetObj.GetCellValue(row, 'bzc_amt'); //OK
            
            ComOpenPopup('ESD_TRS_0026_POP.do'+url, 1200, 560,'ESD_TRS_0026', '0,0', true);
            break;
        }
        case('bzc_amt_pop'): {
            var url='?targetRow='+row;
            url += '&trsp_so_ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_so_ofc_cty_cd'); // OK
            url += '&trsp_so_seq='+sheetObj.GetCellValue(row, 'trsp_so_seq'); // OK
            url += '&ctrl_ofc_cd='+sheetObj.GetCellValue(row, 'cre_ofc_cd');

            url += '&rail_cmb_thru_tp_cd='+sheetObj.GetCellValue(row, 'rail_cmb_thru_tp_cd');
            url += '&rail_cmb_thru_tp_nm='+sheetObj.GetCellValue(row, 'rail_cmb_thru_tp_nm');
            
            url += '&basis_dt='+sheetObj.GetCellValue(row, 'cre_dt');//OK
            url += '&eq_knd_cd='+sheetObj.GetCellValue(row, 'eq_knd_cd');
            url += '&eq_tp_sz_cd='+sheetObj.GetCellValue(row, 'eq_tpsz_cd'); // OK
            url += '&cmb_tp_cd='+sheetObj.GetCellValue(row, 'trsp_so_cmb_tp_cd');
            url += '&cgo_tp_cd='+sheetObj.GetCellValue(row, 'cgo_tp_cd'); // OK
            url += '&bound_cd='+sheetObj.GetCellValue(row, 'trsp_bnd_cd'); //OK
            url += '&crr_mod_cd='+sheetObj.GetCellValue(row, 'trsp_crr_mod_cd');
            url += '&cost_mod_cd='+sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd');
            url += '&cust_cnt_cd='+sheetObj.GetCellValue(row, 'po_cust_cnt_cd');
            url += '&cust_seq='+sheetObj.GetCellValue(row, 'po_cust_seq');
            url += '&cmdt_cd='+sheetObj.GetCellValue(row, 'cmdt_cd');
            
            url += '&fm_nod_cd='+sheetObj.GetCellValue(row, 'fm_nod_cd'); //OK
            url += '&fm_nod_yard='+sheetObj.GetCellValue(row, 'fm_nod_yard'); //OK
            url += '&to_nod_cd='+sheetObj.GetCellValue(row, 'to_nod_cd'); //OK
            url += '&to_nod_yard='+sheetObj.GetCellValue(row, 'to_nod_yard'); //OK
            
            url += '&bundle_cnt='+sheetObj.GetCellValue(row, 'bundling_no');
            url += '&wgt_uom='+sheetObj.GetCellValue(row, 'wgt_meas_ut_cd');
            url += '&wgt_qty='+sheetObj.GetCellValue(row, 'cntr_wgt'); //OK
            url += '&agmt_ofc_cty_cd='+sheetObj.GetCellValue(row, 'trsp_agmt_ofc_cty_cd'); //OK
            url += '&agmt_seq='+sheetObj.GetCellValue(row, 'trsp_agmt_seq'); //OK
            url += '&way_type='+sheetObj.GetCellValue(row, 'po_way_type');
            url += '&vndr_seq='+sheetObj.GetCellValue(row, 'vndr_seq'); //OK
            url += '&curr_cd='+sheetObj.GetCellValue(row, 'curr_cd'); //OK
            url += '&bzc_amt='+sheetObj.GetCellValue(row, 'bzc_amt'); //OK
            ComOpenPopup('ESD_TRS_0027_POP.do'+url, 700, 420, 'ESD_TRS_0027', '0,0', true);
            break;
        }
    }
}

// Confirmation MSG Send
function doActionPopupOpen(sheetObj, formObj)
{
    if( sheetObj.CheckedRows("chk3") == 1 ) {
        ComOpenWindow('ESD_TRS_0927.do', 'ESD_TRS_0927', 'top=200, left=200, width=795, height=400, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
    } else if( sheetObj.CheckedRows("chk3") > 1 ) {
        ComShowCodeMessage("TRS90434");
    } else if( sheetObj.CheckedRows("chk3") == 0 ) {
        ComShowCodeMessage("TRS90382");
    }
}

/*
 * Get a list of external combo box (Refer to ESD_TRS_0003.js).
 */
function getComboList(obj, comObj, sep) { 
	comObj = eval(comObj.id);
	var formObj=document.form;
	var lvobj=ComTrimAll(obj.value.toUpperCase(), " ");
	obj.value=lvobj;
	if( lvobj == "" ) {
		obj.value="";
		comObj.RemoveAll();
		obj.focus();
		return false;
	} else if( lvobj.length != 5 ) {
		obj.focus();
		ComShowCodeMessage("TRS90074");
		return false;
	}
	if( !doengnumcheck(lvobj) ) {
		obj.value="";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if( sep == 'F' ) {
		lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.focus();
}
/**
 * common Node popup
 */
 function openHireYardPopup(objName) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val="";   
	var cmdt_desc_val="";  
	var classId=objName;
	var xx1=""; //CONTI
	var xx2=""; //SUB CONTI
	var xx3=""; //COUNTRY
	var xx4=""; //STATE
	var xx5=""; //CONTROL OFFIC
	var xx6=""; //LOC CODE
	var xx7=""; //LOC NAME
	var xx8="";
	var xx9="";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 820, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * The return value for the From Node
 */
function getFromNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.frm_node.value=lvLoc;
	getYardCombo(frm_yard, sheetObjects[0], formObject, lvLoc);
	frm_yard.CODE=lvYard;
}
/**
 * The return value for the pop-up To Node
 */
function getToNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.to_node.value=lvLoc;
	getYardCombo(document.to_yard, sheetObjects[0], formObject, lvLoc);
	document.to_yard.CODE=lvYard;
}
/**
 * call rep_commodity popup
 */
function rep_OnPopupClick() {
	var formObject=document.form;
	var cmdt_cd_val="";   		
	var rep_cmdt_cd_val="";   	
	var cmdt_desc_val="";   	
	var classId="getCOM_ENS_rep";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * call rep_commodity popup : If a single selection from a pop-up
 */
function getCOM_ENS_rep(rowArray) {
	var formObj=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[3];
		var colArray4=colArray[4];
		formObj.combo_svc_provider.value=colArray2;
		formObj.trsp_so_vndr_no.value=colArray4;
	}
}
/**
 * common Trunk VVD popup
 */
 function openTVVDPopup() {
	var formObject=document.form;
	var cmdt_cd_val="";   		
	var rep_cmdt_cd_val="";   	
	var cmdt_desc_val="";   	
	var v1=""; //ETDETA
	var v2=""; //SDATE
	var v3=""; //EDATE
	var v4=""; //VVD_CD
	var v5=""; //LOC_CD
	var v6=""; //LANE_CD
	var v7=""; //OPER
	var xx1=""; //CONTI
	var xx2=""; //SUB CONTI
	var xx3=""; //COUNTRY
	var xx4=""; //STATE
	var xx5=""; //CONTROL OFFIC
	var xx6=""; //LOC CODE
	var xx7=""; //LOC NAME
	var xx8="";
	var xx9="";
	var classId="getCOM_ENS_VVD_1";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 772, 490, classId, '1,0,1,1,1,1,1,1');
}
function getCOM_ENS_VVD_1(rowArray) {
	var formObject=document.form;
	var gubun="";
	var colArray=rowArray[0];
	formObject.trunk_vvd.value=colArray[7] + gubun;
}
/**
 * common Trunk VVD popup
 */
 function openMultipleinquiry(obj, obj2) {
	var formObject=document.form;
	var cmdt_cd_val="";
	var rep_cmdt_cd_val="";
	var cmdt_desc_val="";
	var xx1=""; //CONTI
	var xx2=""; //SUB CONTI
	var xx3=""; //COUNTRY
	var xx4=""; //STATE
	var xx5=""; //CONTROL OFFIC
	var xx6=""; //LOC CODE
	var xx7=""; //LOC NAME
	var xx8="";
	var xx9="";
	var classId="getTRS_ENS_906";
	var param="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+ "&pgmNo=ESD_TRS_0028";
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 390, "getTRS_ENS_906", '0,1', true);
}
/**
 * Location : If a single selection from a pop-up
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj="";
	var formObject=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj=reObj + colArray;
		} else {
			reObj=reObj + colArray + ",";
		}
	}
	if( obj == "VVD" ) {
		formObject.trunk_vvd.value=reObj;
	} else if( obj == "BKG" ) {
		formObject.bkg_no.value=reObj;
	} else if( obj == "BLN" ) {
		formObject.bill_no.value=reObj;
	} else if( obj == "CNT" ) {
		formObject.cntr_no.value=multiCntrChkDgt(reObj);
	} else if( obj == "SON" ) {
		formObject.so_no.value=reObj;
	} else if( obj == "WON" ) {
		formObject.wo_no.value=reObj;
	} else if( obj == "REF" ) {
		formObject.ref_no.value=reObj;
	} else {
		errMsg=ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}
/**
 * Click the Tab at the event-related
 * Elements selected tab is active.
 */
function Minimize(nItem) {
	var objs=document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display="none";
		sheet.SetSheetHeight(ComGetSheetHeight(sheet, 19));
	} else {
		objs.style.display="inline";
		resizeSheet();
	}
}
/*
 * Calendar Pop-Up
 */
function getCalendar() {
	var cal=new ComCalendarFromTo();
	cal.displayType="date";
	cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyyMMdd');
}
// To date plus
function getDateBetween(obj) {
	if(document.form.frm_plandate.value == ""){
		document.form.to_plandate.value="";
	}else{
		document.form.to_plandate.value=ComGetDateAdd(obj.value, "D", 30);		
	}
}

/**
 * 
 * @param obj
 */
function onChange_through(obj){
	var codeval=obj.value;
	var formObject=document.form;
    if ( codeval == 'W' ){
	    formObject.sel_bnd.value='O';
	    formObject.rad_vendor[1].checked=true;
	    do_railroad('R');
    } else {
    	formObject.sel_bnd.value='ALL';
	    formObject.rad_vendor[0].checked=true;
	    do_railroad('W');
    }
}

//UI 표준화관련 하단 여백 설정
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}

/**
 * 
 * @param combo
 */
function sel_railroad_OnBlur(combo) {
	var finded = combo.FindItem(combo.GetSelectCode(), 0);
	if(finded >= 0) {
		if (document.form.rail_road_name.value == combo.GetText(finded, 1)) {
			return false;
		}
		document.form.rail_road_name.value = combo.GetText(combo.GetSelectCode(), 1);
	}
}

/**
 * Rail Road combo
 */
function sel_railroad_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	if (document.form.rail_road_name.value == newText) {
		return false;	
	}
	document.form.rail_road_name.value = comboObj.GetText(newCode, 1);
}

function selectLoc() {
	var param = '?loc_port_ind=1';
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 500, 'getLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}

function getLoc(rowArray) {
	var frm = document.form;
	var colArray = rowArray[0];
		frm.pod_cd.value = colArray[3].substring(0, 5);
		frm.pod_nod_cd.value = colArray[3].substring(5);
}

//Service Provider
function  vendor_blur(){
	var formObj = document.form;
	var lvobj = formObj.combo_svc_provider.value;
	var error_val = "";

	if(lvobj !=""){
		for (var i = 0; i < lvobj.length; i++) {
			var oneChar = lvobj.charAt(i);
			if (oneChar != "") {
				if (  (oneChar >= "0" && oneChar <= "9" )  ){
				}else {
					error_val ="Y";
					break;
				}
			}
		}
		if(error_val !="Y" ) {			
			formObj.f_cmd.value = SEARCH11;
			formObj.combo_svc_provider.value = get_only_num(formObj.combo_svc_provider.value);
			sheetObjects[0].RemoveEtcData();
			var sXml = sheetObjects[0].GetSearchData("ESD_TRS_0014GS.do", TrsFrmQryString(formObj));

			var vendorNoList = ComGetEtcData(sXml,'vndr_no');
			var vendorNmList = ComGetEtcData(sXml,'vndr_nm_eng');

			if (vendorNoList == undefined || vendorNoList == ''){
				   formObj.combo_svc_provider.value = '';
				   formObj.trsp_so_vndr_no.value = '';
			}else{
				formObj.combo_svc_provider.value = lpad(ComTrim(vendorNoList), 6, '0') ;
				formObj.trsp_so_vndr_no.value = vendorNmList;
			}
		} else {
			errMsg = ComGetMsg("TRS90076");
			ComShowMessage(errMsg);
			formObj.combo_svc_provider.focus();
			formObj.trsp_so_vndr_no.value ="";
		}
	} else {
		formObj.trsp_so_vndr_no.value ="";
	}
}