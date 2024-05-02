/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0204.js
*@FileTitle  : USA Rail Billing Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/

/*------------------ Defining general java script function   ------------------*/
/* General global variable */
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0; 
var docObjsep="C";
var R=222;
var G=251;
var B=248;
var rail_road_codeCode;
var rail_road_codeText;

/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	$('#frm_node').on('change', function(){
		getComboList(ComGetEvent(), frm_yard, 'F');
	});
	$('#to_node').on('change', function(){
		getComboList(ComGetEvent(), to_yard, 'T');
	});
	
	initRailRoad();
}

function initRailRoad() {
 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	getRailVendorComboList(sel_railroad , rail_road_codeCode , rail_road_codeText , 'ALL');
	initVendorCombo(sel_railroad); 	
	sel_railroad.SetSelectIndex(0);
}

/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
		    with(sheetObj){
//			      var HeadTitle1="S|STS|CNTR No|BKG No|BL No|Reference\nNo|Status|BKG\nSPE|CNTR\nSPE|Unplanned|Rail ORG|Rail ORG|Rail DEST|Rail DEST|Rail Road|Agreement\nReference No";
//			      HeadTitle1+="|Route\nPlan|STCC|Restricted|stcc_cgo_use_flg|stcc_pop_flg|Commodity Group\nDescription|Rail\nBulk|Commodity\nDescription|EDI Resend Target|Suspended\nReason|TP/SZ|Weight\n(LBS)|Internal\nRemark|Internal\nRemark";
//			      HeadTitle1+="|Customs\nC.LOC|IT/Local|IT No|EDI Re-sent|Full/\nEmpty|BND|BKG\nStatus|Term|Revised BKG No|POR/POD|POR/POD|POL/DEL|POL/DEL|POL/DEL|Latest Movement Status|Latest Movement Status|Latest Movement Status|Revised\nPOL|From WRS|From WRS|From WRS|From WRS";
			      var HeadTitle1="S|STS|EDI Re-sent|EDI Resend Target|Suspended\nReason|Through|CNTR No|BKG No|BL No|Reference\nNo|Status|BKG\nSPE|CNTR\nSPE|Unplanned|Rail ORG|Rail ORG|Rail DEST|Rail DEST|Rail Road|Agreement\nReference No";
			      HeadTitle1+="|Route\nPlan|STCC|Restricted|stcc_cgo_use_flg|stcc_pop_flg|Commodity Group\nDescription|Rail\nBulk|Commodity\nDescription|TP/SZ|Weight\n(LBS)|Internal\nRemark|Internal\nRemark";
			      HeadTitle1+="|Customs\nC.LOC|IT/Local|IT No|Full/\nEmpty|BND|BKG\nStatus|Term|Revised BKG No|POR/POD|POR/POD|POL/DEL|POL/DEL|POL/DEL|Latest Movement Status|Latest Movement Status|Latest Movement Status|Revised\nPOL|From WRS|From WRS|From WRS|From WRS";
			      HeadTitle1+="|Stowage|BS|OverWeight|Unmatch|Unmatch|VVD|VVD|POD\n(for Export BKG)|POD\n(for Export BKG)|Revised\nVVD|Revised\nBKG SPE";
			      HeadTitle1+="|Request S/P|Cost\nMonth|S/O Creation Time|S/O Creation Time|BKG Updated Time|BKG Updated Time";
			      HeadTitle1+="|Cancel Request Time|Cancel Request Time|Cancel Request\nReason|Cancel Request Reject Time|Cancel Request Reject Time|Cancel Request\nReject Reason|Requested\nBy BKG|Remark\n(Special Instruction)|CN Underbond\nRelease\nnot Required|Frustrate";
			     
//			      var HeadTitle2="S|STS|CNTR No|BKG No|BL No|Reference\nNo|Status|BKG\nSPE|CNTR\nSPE|Unplanned|Loc|Node|Loc|Node|Rail Road|Agreement\nReference No";
//			      HeadTitle2+="|Route\nPlan|STCC|Restricted|stcc_cgo_use_flg|stcc_pop_flg|Commodity Group\nDescription|Rail\nBulk|Commodity\nDescription|EDI Resend Target|Suspended\nReason|TP/SZ|Weight\n(LBS)|Internal\nRemark|Internal\nRemark";
//			      HeadTitle2+="|Customs\nC.LOC|IT/Local|IT No|EDI Re-sent|Full/\nEmpty|BND|BKG\nStatus|Term|Revised BKG No|Loc|Node|Loc|Node|Name|Status|Yard|Date|Revised\nPOL";
			      var HeadTitle2="S|STS|EDI Re-sent|EDI Resend Target|Suspended\nReason|Through|CNTR No|BKG No|BL No|Reference\nNo|Status|BKG\nSPE|CNTR\nSPE|Unplanned|Loc|Node|Loc|Node|Rail Road|Agreement\nReference No";
			      HeadTitle2+="|Route\nPlan|STCC|Restricted|stcc_cgo_use_flg|stcc_pop_flg|Commodity Group\nDescription|Rail\nBulk|Commodity\nDescription|TP/SZ|Weight\n(LBS)|Internal\nRemark|Internal\nRemark";
			      HeadTitle2+="|Customs\nC.LOC|IT/Local|IT No|Full/\nEmpty|BND|BKG\nStatus|Term|Revised BKG No|Loc|Node|Loc|Node|Name|Status|Yard|Date|Revised\nPOL";
			      HeadTitle2+="|Bulk|Steel Wire|Coil Shipment|Fumigation|Stowage|BS|OverWeight";
			      HeadTitle2+="|VVD|POD|Orignal|Revised|Orignal|Revised|Revised\nVVD|Revised\nBKG SPE|Request S/P|Cost\nMonth| || || ||";
			      HeadTitle2+="Cancel Request\nReason| ||Cancel Request\nReject Reason|Requested\nBy BKG|Remark\n(Special Instruction)|CN Underbond\nRelease\nnot Required|Frustrate";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
			      InitHeaders(headers, info);

			      var cols = [ 
			             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
			             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"edi_resent",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"edi_resend_target_flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"err_desc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"through",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_id",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:85,   Align:"Left",    ColMerge:1,   SaveName:"status",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_spe",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upln_so_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yard",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_yard",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"left",    ColMerge:1,   SaveName:"vndr_abbr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"left",    ColMerge:1,   SaveName:"ref_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_pln_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
                         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_cd",          		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_rstr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_cgo_use_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_pop_flg",      	     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                         
                         {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"stcc_desc",         	     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 			             
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rail_blk_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:150,  Align:"left",    ColMerge:1,   SaveName:"cmdt_name",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//			             {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"edi_resend_target_flag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"err_desc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Image",		Hidden:0, Width:20,   Align:"left",	   ColMerge:0,   SaveName:"pop_img",				                                                                     UpdateEdit:0,   InsertEdit:0,   ImgHeight:20,         ImgWidth:19 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ibd_cstms_clr_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibd_ipi_locl_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ibd_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
//			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"edi_resent",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcvde_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"revised_bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"podpor_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"podpor_yard",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"poldel_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"poldel_yard",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"poldel_cd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",              	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"revised_pol",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"blk_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stel_wire_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"coil_shp_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fumg_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"stwg",                	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"blck_stwg_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"overweight",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"unmatch_vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"unmatch_pod",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trunkvvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trunkvvd_revised",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd_revised",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"revised_trunkvvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"revised_bkg_spe",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Popup",     Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"request_sp",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_month",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt_hms",              KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_updated_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_updated_dt_hms",      KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cxl_rqst_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cxl_rqst_dt_hms",         KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cxl_rqst_rsn",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cxl_rqst_rjct_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cxl_rqst_rjct_dt_hms",    KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cxl_rqst_rjct_rsn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trsp_rqst_bkg_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"spcl_instr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
			             {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnd_cstms_clr_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,	HeaderCheck:0},
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bil_iss_knt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bil_iss_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cxl_rqst_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_rail_bil_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cop_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"rout_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_org_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_dest_nod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rout_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"repo_pln_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pln_yrwk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ref_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"interchange1_loc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"interchange1_nod",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"interchange2_loc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"interchange2_nod",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inv_bil_patt_div_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rail_cmb_thru_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"org_fm_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"org_fm_nod_yard",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"org_to_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"org_to_nod_yard",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"act_grp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"dcgo_flg",       		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq",       		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"decl_nm",       			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"vld_flg",       			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		             
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"dg_cntr_seq",       		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	             
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"bkg_dcgo_flg",       	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"bkg_att_dg_cnt",       	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_sts_cd",       	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"trsp_frst_flg",       	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:1,   SaveName:"org_interchange1_loc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:1,   SaveName:"org_interchange1_nod",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:1,   SaveName:"org_interchange2_loc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,  Align:"Center",  ColMerge:1,   SaveName:"org_interchange2_nod",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
			             ];
			      	InitColumns(cols);
			      	SetEditable(1);
			      	ComResizeSheet(sheetObj);		
			      	SetImageList(1, "img/btns_search_g.gif");
			        SetColProperty('ibd_ipi_locl_ind_cd', {ComboText:ibd_ipi_locl_ind_cdText, ComboCode:ibd_ipi_locl_ind_cdCode} );
					SetColProperty('trsp_rqst_bkg_flg', {ComboText:'|YES|NO', ComboCode:'|Y|N'} );
			      }


		break;
	}
}
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
	/***** Adding additional sheet variables to use more than one sheet per a tab *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "");
				}
			break;
			case "btn_reset": {
				formObject.reset();
				frm_yard.RemoveAll(); // Removing combo data
				to_yard.RemoveAll(); // Removing combo data
				sel_railroad.SetSelectIndex(0);
				sheetObject.RemoveAll();
			}
			break;
			case "btn_minimize":
                if(document.all.MiniLayer.style.display != "none") {
                    document.all.MiniLayer.style.display="none";                
                } else {
                    document.all.MiniLayer.style.display="";                
                }
                ComResizeSheet(sheetObject);	
			break;
			case "btng_irgadjust":
				if( validateForm(sheetObject, formObject) ) {
					doActionPopupOpen(sheetObject, formObject);
				}
			break;
			case "btns_calendar":
				getCalendar();
			break;
			case "btns_frmnode":
				openHireYardPopup('getFromNode');
			break;
			case "btns_tonode":
				openHireYardPopup('getToNode');
			break;
			case "btns_multivvd":
				openMultipleinquiry('VVD', 'T.VVD');
			break;
			case "btns_tvvd":
				openTVVDPopup();
			break;
			case "btns_multibkg":
				openMultipleinquiry('BKG', 'BKG No');
			break;
			case "btns_multibl":
				openMultipleinquiry('BLN', 'B/L No');
			break;
			case "btns_multicntr":
				openMultipleinquiry('CNT', 'CNTR No');
			break;
			case "btng_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL, "");
			break;
			/* case "btng_cancelreqreject":
				doActionCancelReqReject(sheetObject);
			break; 
			 Cancel REQ Reject  */
			case "btng_sodelete":
				if( validateFormDel(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBDELETE, "");
				}
			break;
			case "btng_ediresend_tti":
				if( validateForm_ediresend(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "EDI_RESEND");
				}
			break;
			case "btng_socorrection": {
				if( validateForm(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSAVE, "");
				}
				break;
			}
            case "btng_modstcc": {
            	PopupModifySTCC();
            	break;
			}
			case "btns_multirefer": {
				openMultipleinquiry('REF', 'Reference No');
				break;
            }
            case "btng_declarant":  {
            	PopDeclarant();
            	break;	
            }
            case "btns_vendor": { //Service Provider Pop-up for WRS
				rep_OnPopupClick();
				break;
            }
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
    		errMsg=ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
    		ComShowMessage(e.message);
		}
	}
}
function doActionIBSheet(sheetObj, formObj, sAction, obj) {
	switch (sAction) {
		case IBSEARCH: {
			if (obj == 'EDI_RESEND') {
				docMessage = "S"; 
				formObj.f_cmd.value = MULTI04;
				sheetObj.DoSave("ESD_TRS_0028GS.do", TrsFrmQryString(formObj), "chk1", false, true);
			} else {
				formObj.f_cmd.value = SEARCH03;
				sheetObj.DoSearch("ESD_TRS_0204GS.do", TrsFrmQryString(formObj));
			}
			break;
		}
		case IBSAVE: {
			formObj.f_cmd.value = MODIFY;
			sheetObj.DoSave("ESD_TRS_0204GS.do", TrsFrmQryString(formObj), "chk1", false, true);
			break;
		}
		case IBDELETE: {
			formObj.f_cmd.value = REMOVE;
			sheetObj.DoSave("ESD_TRS_0204GS.do", TrsFrmQryString(formObj), "chk1", false, true);
			break;
		}
		case IBDOWNEXCEL: {
			if (sheetObj.RowCount() < 1) {
				ComShowCodeMessage("COM132501");
			} else {
				var excludeField = ["pop_img" ];
				var includeField = null;
				sheetObj.Down2Excel({ DownCols : makeExcelDownSkipColumn(sheetObj, true, excludeField, includeField), CheckBoxOnValue : 'Y', CheckBoxOffValue : 'N', SheetDesign : 1, Merge : 1 });
			}
			break;
		}
		case IBSEARCH_ASYNC01: {
			var param = 'f_cmd=' + SEARCH + '&cntr_vndr_svc_cd=RAIL&vndr_cost_cd=TR&vndr_cnt_cd=US,CA';
			var sXml = sheetObj.GetSearchData("ESD_TRS_0999GS.do", param);
			rail_road_codeCode = ComGetEtcData(sXml, "rail_vndr_code");
			rail_road_codeText = ComGetEtcData(sXml, "rail_vndr_desc");
			break;
		}
	}
}

function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
		}
	}
}
//Popup
function doSearchPopup() {
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	if( validateFormSearch(formObject) ) {
		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	}
}
// Sheet의 Object
function openObjSheet() {
	return sheetObjects[0];
}
//tab1
function sheet_OnChange(sheetObj, row , col , value) {
	var docObj="";
	if( sheetObj.ColSaveName(col) == "ibd_ipi_locl_ind_cd" ) {

		docObj=sheetObj.GetCellValue(row, "ibd_ipi_locl_ind_cd");
		if( docObj == "I" ) {
			sheetObj.SetCellEditable(row, "ibd_no",1);
		} else {
			sheetObj.SetCellEditable(row, "ibd_no",0);
			sheetObj.SetCellValue(row, "ibd_no","",0);
		}
	} else if( sheetObj.ColSaveName(col) == "ibd_no" ) {

		docObj=sheetObj.GetCellValue(row, "ibd_ipi_locl_ind_cd");
		if( docObj == "I" ) {
			sheetObj.SetCellEditable(row, "ibd_no",1);
		} else {
			sheetObj.SetCellEditable(row, "ibd_no",0);
			sheetObj.SetCellValue(row, "ibd_no","",0);
		}
	} else if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.SetRowStatus(row,"I");
		} else {
			sheetObj.SetRowStatus(row,"R");
		}
	}
}
/**
    * Validating inputted values of form
 */
function validateForm(sheetObj, formObj){
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	var dcgo_flg = "";
	var eq_no = "";
	for( var ir=0, len=arrRow.length; ir < len; ir++ ) {
		dcgo_flg = sheetObj.GetCellValue(arrRow[ir], "dcgo_flg");
		eq_no = sheetObj.GetCellValue(arrRow[ir], "eq_no");
		
		if( sheetObj.GetCellValue(arrRow[ir], "status") == "EDI Sent" ) {
			ComShowCodeMessage("TRS90358");
			return false;
		}
		if( sheetObj.GetCellValue(arrRow[ir], "bkg_dcgo_flg") == 'Y') {
			if( sheetObj.GetCellValue(arrRow[ir], "bkg_att_dg_cnt") == '0') {
				ComShowCodeMessage('TRS90486', eq_no);
				return false;
			} else if( dcgo_flg == 'Y' && sheetObj.GetCellValue(arrRow[ir], "decl_nm") == '') {
				ComShowCodeMessage('TRS90480', eq_no);
				return false;
			} 
		}
		if( sheetObj.GetCellValue(arrRow[ir], "vld_flg") == 'N') {
			if(sheetObj.GetCellValue(arrRow[ir], "trsp_bnd_cd") == 'O' ) {
				ComShowCodeMessage('TRS90481', eq_no);
			} else {
				ComShowCodeMessage('TRS90482', eq_no);
			}
			return false;
		}	
	}	
	return true;
}
/**
    * Validating inputted values of form
 */
function validateFormDel(sheetObj, formObj) { 
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	} else {
		var sRow=sheetObj.FindCheckedRow("chk1");
		var arrRow=sRow.split("|");
		for( var ir=0; ir < arrRow.length; ir++ ) {
			fromRow=arrRow[ir];

			if( sheetObj.GetCellValue(fromRow, "trsp_rqst_bkg_flg") == "Y" ) {
				errMsg=ComGetMsg("TRS90342");
				if( confirm(errMsg) ) {
				} else {
					sheetObj.SetCellValue(fromRow,"trsp_rqst_bkg_flg","",0);
					return false;
				}
			}

			if( sheetObj.GetCellValue(fromRow, "bil_iss_sts_cd") == "I" ) {
				errMsg=ComGetMsg("TRS90475");
				ComShowMessage (errMsg);
				return false;
			}			
		}
	}
	return true;
}
/**
 * Validation of 404 EDI RESEND 
 */
function validateForm_ediresend(sheetObj, formObj){
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	var edi_no_resend_target_cnt=0;
	var edi_resent_cnt=0;
	var edi_no_resend_target_flag;
	for( var i=0; i<arrRow.length; i++ ) {
	    fromRow=arrRow[i];

	    if( sheetObj.GetCellValue(fromRow, "edi_resend_target_flag") == 'X' ){
		   edi_no_resend_target_cnt=edi_no_resend_target_cnt + 1; 

	    }else if( sheetObj.GetCellValue(fromRow, "edi_resend_target_flag") == 'N' ){
		   edi_resent_cnt=edi_resent_cnt + 1;
		}
	}
	if( edi_no_resend_target_cnt > 0 || edi_resent_cnt > 0 ){
	    errMsg=ComGetMsg("TRS90370");
	    ComShowMessage(errMsg);
	    return false;
	}
	return true;
}
/**
 * General processing method working when there is an error of inquiring result
 * DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
function sheet_OnSaveEnd(sheetObj, errCode, errMsg) {
	if (errCode >= 0) {
		var sRow=sheetObj.FindCheckedRow("chk1");
		var arrRow=sRow.split("|");
		if( document.form.f_cmd.value == REMOVE ) {
			ComShowCodeMessage("TRS90146");
			for( var ir=arrRow.length; ir >=0 ; ir-- ) {
				sheetObj.RowDelete(arrRow[ir], false);
			}
		} else if( document.form.f_cmd.value == MULTI04 ) {     //EDI RESEND
			for( var i=arrRow.length-1; i >=0 ; i-- ) {
				 sheetObj.SetCellValue(arrRow[i], "edi_resent","Y",0);
				 sheetObj.SetCellValue(arrRow[i], "edi_resend_target_flag","N",0);
				 sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
			}		
			ComShowMessage("EDI Re-send - Success!!");    
		} else {
			for( var ir=0; ir < arrRow.length; ir++ ) {
				sheetObj.SetRowStatus(arrRow[ir],"I");
			}
			ComShowCodeMessage("TRS90102");
		}		
	}
}
/* Cancel Req Reject 
 * target :TRS_TRSP_RAIL_BIL_ORD.CXL_RQST_FLG ='Y'
 *       TRS_TRSP_EDI_RAIL_ORD.TRSP_RAIL_BIL_TP_CD = 'W' 
 */
function doActionCancelReqReject(sheetObj) {
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i<arrRow.length; i++ ) {
		if( sheetObj.GetCellValue(arrRow[i], "cxl_rqst_flg") == "Y" && sheetObj.GetCellValue(arrRow[i], "trsp_rail_bil_tp_cd") == "W" ) {
		} else {
			sheetObj.SetRowStatus(arrRow[i],"R");
			sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
			sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
		}
	}
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowCodeMessage("TRS90132");
	} else {
	    ComOpenWindow('ESD_TRS_0959Pop.screen', 'ESD_TRS_0959', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:800px;dialogHeight:300px', true);
    }
}
// Opening popup when processing with dtPopupEdit
var docProvvndrseq="";
var docTrsp_so_seq="";
var docTrsp_so_ofc_cd="";
function sheet_OnPopupClick(sheetObj, row, col) {
	docProvvndrseq="";
	if( sheetObj.ColSaveName(col) == "request_sp" ) {

		docProvvndrseq=sheetObj.GetCellValue(row, "request_sp");

		docTrsp_so_seq=sheetObj.GetCellValue(row, "trsp_so_seq");

		docTrsp_so_ofc_cd=sheetObj.GetCellValue(row, "trsp_so_ofc_cty_cd");
		if( docProvvndrseq != "" ) {
			var myOption="top=200,left=200,width=402,height=256,menubar=0,status=0,scrollbars=0,resizable=0";
			var url='ESD_TRS_0956Pop.screen';
			var myWin=ComOpenWindow('ESD_TRS_0956Pop.screen', 'popRequestSP', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:402px;dialogHeight:286px', true);
		}
	}
}
function validateFormSearch(formObj) {
	var lvFrmDate=ComTrimAll(ComTrimAll(formObj.frm_plandate.value, " "), "-");
	var lvToDate=ComTrimAll(ComTrimAll(formObj.to_plandate.value, " "), "-");
	var lvFrm_node=ComTrimAll(formObj.frm_node.value, " ");
	var lvTo_node=ComTrimAll(formObj.to_node.value, " ");
	var lvBkg_no=ComTrimAll(formObj.bkg_no.value, " ");
	var lvCntr_no=ComTrimAll(formObj.cntr_no.value, " ");
	var lvTrunk_vvd=ComTrimAll(formObj.trunk_vvd.value, " ");
	var lvBill_no=ComTrimAll(formObj.bill_no.value, " ");	
	if( lvFrmDate == "" ) 
		formObj.frm_plandate.value="";
	if( lvToDate == "" ) //to date
		formObj.to_plandate.value="";
	if( lvBkg_no == "" ) //BKG No
		formObj.bkg_no.value="";
	if( lvCntr_no == "" ) //CNTR No
		formObj.cntr_no.value="";
	if( lvFrmDate == "" && lvToDate != "" ) { //If there's no date data in one part
		ComShowCodeMessage("TRS90119");
		return false;
	} else if( lvFrmDate != "" && lvToDate == "" ) { //If there's no date data in one part
		ComShowCodeMessage("TRS90121");
		return false;
	} else if( lvFrmDate != "" && lvToDate != "" ) { //The part of checking the date
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
//		for(var i=0; i < formObj.date_sep.length; i++){
//			if(formObj.date_sep[i].checked && formObj.date_sep[i].value == "BU"){				
//				if( lvFrm_node != "" && lvTo_node != "" ){			
//				} else if(lvBkg_no != "" || lvCntr_no != "" || lvTrunk_vvd != "" || lvBill_no != ""){					
//				} else{
//					ComShowCodeMessage("TRS90124");
//					return false;
//				}
//			}
//		}	
	} else {
		if( lvTrunk_vvd == "" && lvBkg_no == "" && lvBill_no == "" && lvCntr_no == "" ) {
			ComShowCodeMessage("TRS90124");
			return false;
		}
	}
	if( lvFrm_node == "" ) { 
		formObj.frm_node.value="";
		frm_yard.RemoveAll(); // Removing combo data
	}
	if( lvTo_node == "" ) { //To Node
		formObj.to_node.value="";
		to_yard.RemoveAll(); // Removing combo data
	}
	if( !ComIsAlphabet(ComTrimAll(lvBkg_no, ","), "n")  && lvBkg_no != "" ) {
		formObj.bkg_no.value="";
		formObj.bkg_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvCntr_no, ","), "n") && lvCntr_no != "" ) {
		formObj.cntr_no.value="";
		formObj.cntr_no.focus();
		return false;
	}
	formObj.hid_frmdate.value=lvFrmDate; 
	formObj.hid_todate.value=lvToDate; //to Date
	formObj.frm_node.value=lvFrm_node.toUpperCase();
	formObj.to_node.value=lvTo_node.toUpperCase();
	formObj.bkg_no.value=lvBkg_no.toUpperCase(); //BKG No.
	formObj.cntr_no.value=lvCntr_no.toUpperCase(); //CNTR No
	return true;
}
/*
 * Calling IRG Adjust Pop up
 */
function doActionPopupOpen(sheetObj, formObject) {
	var doc_flg=false;
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
	} else {
		var sRow=sheetObj.FindCheckedRow("chk1");
		var arrRow=sRow.split("|");
		var lvcgo_tp_cd="";
		var lvchedk=false;
		for( var i=0; i<arrRow.length; i++ ) {
			if( i != 0 ) {

				if( sheetObj.GetCellValue(arrRow[i], "cgo_tp_cd") != lvcgo_tp_cd ) {
					lvchedk=true;
				}
			}

			lvcgo_tp_cd=sheetObj.GetCellValue(arrRow[i], "cgo_tp_cd");

			if( sheetObj.GetCellValue(arrRow[i], "inv_bil_patt_div_flg") == "Y" ) {
				sheetObj.SetRowStatus(arrRow[i],"R");
				sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
				sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
				doc_flg=true;
			}
		}
		if( doc_flg ) {
			errMsg=ComGetMsg("TRS90363");
			ComShowMessage(errMsg);
		} else {
			if( lvchedk ) {
				errMsg=ComGetMsg("TRS90325");
				ComShowMessage(errMsg);
			} else {
				var pop_width=2000;
				var pop_leftloc=window.screenLeft;
				var pop_toploc=window.screenTop-400;
//				ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928', 'top='+pop_toploc +', left='+pop_leftloc+',width='+ pop_width +' , height=475, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0', true);
				ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:'+1000+'px;dialogHeight:'+510+'px', true);
			}
		}
	}
}
/*
 * Loading the list of external combo box (also in ESD_TRS_0003.js).
 */
function getComboList(obj, comObj, sep) { //object, value receiving part, kind of Node
	comObj = eval(comObj.id);
	var formObj=document.form;
	var lvobj=ComTrimAll(obj, " ");
	obj.value=lvobj;
	if( lvobj == "" ) {
		obj.value="";
		comObj.RemoveAll();
		return false;
	} else if( lvobj.length != 5 ) {
		obj.focus();
		errMsg=ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
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
}
/**
 * Calling rep_commodity pop-up
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
 * Calling rep_commodity pop-up : The case selecting one item at pop-up page
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
 * 
 */
function PopupModifySTCC() {
	if (sheetObjects[0].CheckedRows("chk1") < 1) {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	var sRow = sheetObjects[0].FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for ( var i = 0; i < arrRow.length; i++) {
		if(sheetObjects[0].GetCellValue(arrRow[i], "cgo_tp_cd") != 'F' || sheetObjects[0].GetCellValue(arrRow[i], "trsp_so_sts_cd") == 'I') {
			ComShowCodeMessage("TRS90503");
			return false;
		}
	}
	ComOpenPopup('/opuscntr/ESD_TRS_0939.do', 772, 490, "CallbackModifyStcc", '1,0,1,1,1', true);
}


/**
 * Declarant Popup Call
 * @returns {Boolean}
 */
function PopDeclarant() {
	var p_bkgNo = "";
	var p_dcgoSeq = "";
	var p_dgCntrSeq = "";
	var p_dgCntrSeqUpd = "";
	var arrRow = sheetObjects[0].FindCheckedRow("chk1").split("|");
	var j = 0;
	for ( var i = 0; i < arrRow.length; i++) {
		if (sheetObjects[0].GetCellValue(arrRow[i], 'dcgo_flg') == "Y") {
			if (j == 0) {
				p_bkgNo = sheetObjects[0].GetCellValue(arrRow[i], 'bkg_no');
				p_dcgoSeq = sheetObjects[0].GetCellValue(arrRow[i], 'dcgo_seq');
				p_dgCntrSeq = sheetObjects[0].GetCellValue(arrRow[i], 'dg_cntr_seq');
			} else {
				if (p_bkgNo != sheetObjects[0].GetCellValue(arrRow[i], 'bkg_no')) {
					ComShowCodeMessage('TRS90505');
					return false;
				}
			}
			p_dgCntrSeqUpd += sheetObjects[0].GetCellValue(arrRow[i], 'dg_cntr_seq');
			if (i < arrRow.length - 1) {
				p_dgCntrSeqUpd += "|";
			}
			j++;
		}
	}

	if (j > 0) {
		var param = "trsfunc=trsRetrieve&pop_type=W&bkg_no=" + p_bkgNo;
		param += "&dcgo_seq=" + p_dcgoSeq + "&dg_cntr_seq=" + p_dgCntrSeq;
		param += "&dg_cntr_seq_upd=" + p_dgCntrSeqUpd;
		ComOpenPopup('/opuscntr/ESM_BKG_1300.do?' + param, 1200, 550, "", '0,0', true);
	}
}

/**
 * 
 */
function trsRetrieve() {
	var sheetObject=sheetObjects[0];
    var formObject=document.form;
    if( validateFormSearch(formObject) ) {
        doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
    }
}

/**
 * 
 * @param rowArray
 * @param obj
 */
function CallbackModifyStcc(rowArray, obj) {
	 var sRow=sheetObjects[0].FindCheckedRow("chk1");
     var arrRow=sRow.split("|");
     for( var i=0; i<arrRow.length; i++ ) {
	    for(var j = 0; j < rowArray.length; j++) {
	    	var colArray=rowArray[j];
	    	sheetObjects[0].SetCellValue(arrRow[i], "stcc_cd", colArray[2], 0);
	    	sheetObjects[0].SetCellValue(arrRow[i], "stcc_desc", colArray[3], 0);
	    	sheetObjects[0].SetCellValue(arrRow[i], "stcc_rstr_flg", colArray[4], 0);
	    }
     }
}
/**
 * General Node popup
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
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * From Node popup's return value
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
 * To Node popup's return value
 */
function getToNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.to_node.value=lvLoc;
	getYardCombo(to_yard, sheetObjects[0], formObject, lvLoc);
	to_yard.CODE=lvYard;
}
/**
 * General Trunk VVD popup
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
	var param="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+ "&pgmNo=ESD_TRS_0204";
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 390, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}
/**
 * Location : The case selecting one item at pop-up page
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj="";
	var formObject=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[i];
		if( i == rowArray.length-1) {
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
	} else if( obj == "REF" ) {
 		formObject.refer_no.value=reObj;
 	} else {
		errMsg=ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}
/**
 * General Trunk VVD popup
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
/*
 * Multi-Calendar input Pop-Up
 */
function getCalendar() {
	var cal=new ComCalendarFromTo();
	cal.displayType="date";
	cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');
}
function getDateBetween(obj) {
	if(document.form.frm_plandate.value == ""){
		document.form.to_plandate.value="";
	}else{
		document.form.to_plandate.value=ComGetDateAdd(obj.value, "D", 30);		
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 */
function sheet_OnClick(sheetObj, row, col) {
	if(sheetObj.ColSaveName(col) == "pop_img" && sheetObj.GetCellValue(row, "cgo_tp_cd") == 'F') {
		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(row, "eq_no");
		var lvsono=sheetObj.GetCellValue(row, "trsp_so_ofc_cty_cd") + sheetObj.GetCellValue(row, "trsp_so_seq") 
		var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&so_no=" + lvsono + "&inter_rmk_cd=T" + "&rail_chk=Y";
		ComOpenWindowCenter(url, "compopup", 1000, 570, true);
	}
}


/**
 * 
 * @param combo
 */
function sel_railroad_OnBlur(combo) {
	var finded = combo.FindItem(combo.GetSelectCode(), 0);
	if(finded  >= 0 ) {
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

function do_railroad(obj) {
	if( obj == "R" ) {
		document.form.combo_svc_provider.style.visibility = "visible";
		document.form.trsp_so_vndr_no.style.visibility = "visible";
		document.form.btns_vendor.style.visibility = "visible";
		document.form.sel_railroad.style.visibility = "hidden";		
		document.all.item("SV")[0].style.display = "inline";
		document.all.item("SV")[1].style.display = "none"
	} else {
		document.form.combo_svc_provider.style.visibility = "hidden";
		document.form.trsp_so_vndr_no.style.visibility = "hidden";
		document.form.btns_vendor.style.visibility = "hidden";
		document.form.sel_railroad.style.visibility = "visible";
		document.all.item("SV")[0].style.display = "none";
		document.all.item("SV")[1].style.display = "inline"		
	}
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