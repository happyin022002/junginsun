/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0202.js
*@FileTitle  : Creating USA Rail Billing S/O
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
var sheetObjects=new Array();
var comboObjects=new Array();
var sheetCnt=0;
var comboCnt=0;
var Mincount=0; 
var docObjsep="O";
var R=222;
var G=251;
var B=248;
var OverWeight20FT = 43000;
var OverWeight40FT = 45000;
var OverWeight45FT = 42700;

var CN_OverWeight20FT = 47901;
var CN_OverWeight40FT = 60001;
var CN_OverWeight45FT = 60001;

var docProvvndrseq="";
/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}

/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	for(var i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	var comboObjMaxLen=comboObjects.length;
	for (i=0; i < comboObjMaxLen; i++) {
		initCombo(comboObjects[i], i + 1);
	}
}

function initControl() {
    var formObject=document.form;
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
}

/**
 * Init Combo
 * @param comboObj
 * @param comNo
 */
function initCombo(comboObj, comNo) {
 	var i=0;
 	switch (comboObj.options.id) {
 		case "stop_off_flg": {
 			i=0;
 			with (comboObj) {
 				InsertItem(i++, "", "");	
 				InsertItem(i++, "Y", "Y");
 				InsertItem(i++, "N", "N");
 				SetSelectIndex(0);
 			}
 			break;
 		}
 		case "ovr_wgt_flg": {
 			i=0;
 			with (comboObj) {
 				InsertItem(i++, "", "");	
 				InsertItem(i++, "Y", "Y");
 				InsertItem(i++, "N", "N");
 				SetSelectIndex(0);
 			}
 			break;
 		}
 		case "rest_flg": {
 			i=0;
 			with (comboObj) {
 				InsertItem(i++, "", "");	
 				InsertItem(i++, "Y", "Y");
 				InsertItem(i++, "N", "N");
 				SetSelectIndex(0);
 			}
 			break;
 		}
 		case "bkg_spe": {
 			i=0;
 			with (comboObj) {
 				InsertItem(i++, "", "");	
 				InsertItem(i++, "General Cargo", "G");
 				InsertItem(i++, "Other Cargo", "O");
 				SetSelectIndex(0);
 			}
 			break;
 		}
 	}
 }

/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:
		    with(sheetObj){
				var HeadTitle1  = "S|STS|Container\nNumber|Booking No|Shipper|Type\nSize|BKG QTY|BKG\nSPE|Internal\nRemark|Weight(LBS)|Weight(LBS)|Weight(LBS)|Rail ORG|Rail ORG|InterchangeⅠ|InterchangeⅠ|InterchangeⅡ|InterchangeⅡ";
				    HeadTitle1 += "|Rail DEST|Rail DEST|Yard Character|Lane|Trunk\nVVD|Agreement\nReference No|Route\nPlan|Rail\nBulk|Commodity\nDescription|Commodity Group\nDescription|STCC|AES No|AES No|No of\nPKG|PKG\nCode|Seal No|OverWeight";
					HeadTitle1 += "|Stop Off|Restricted|POL|POL|POL|Latest Movement Status|Latest Movement Status|Latest Movement Status|POR|POR|Term|BKG\nCargo Type|CNTR\nSPE|EQ Type Size(Feet)|stcc_cgo_use_flg|stcc_pop_flg|Consignee|Rail\nRoad";
					HeadTitle1 += "|Request S/P|Verify\nResult|Planned Time|Planned Time|Planned Time|Planned Time|Remark\n(Special Instruction)";
					HeadTitle1 += "|stop_off_loc_cd|stop_off_cntc_pson_nm|stop_off_cntc_phn_no|stop_off_diff_rmk";
				
				var HeadTitle2  = "S|STS|Container\nNumber|Booking No|Shipper|Type\nSize|BKG QTY|BKG\nSPE|Internal\nRemark|Net|Tare|Gross|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Yard Character|Lane|Trunk\nVVD|Agreement\nReference No|Route\nPlan";
				    HeadTitle2 += "|Rail\nBulk|Commodity\nDescription|Commodity Group\nDescription|STCC| ||No of\nPKG|PKG\nCode|Seal No|OverWeight|Stop Off|Restricted|Loc|Node|Name|Status|Yard|Date|Loc|Node|Term|BKG\nCargo Type|CNTR\nSPE|EQ Type Size(Feet)";
				    HeadTitle2 += "|stcc_cgo_use_flg|stcc_pop_flg|Consignee|Rail\nRoad|Request S/P|Verify\nResult|From Departure|From Departure|To Arrival|To Arrival|Remark\n(Special Instruction)";
					HeadTitle2 += "|stop_off_loc_cd|stop_off_cntc_pson_nm|stop_off_cntc_phn_no|stop_off_diff_rmk"; 
					
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 3 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ 
				         {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
			             {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shpr_cust_nm",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"bkg_qty",                     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_spe",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Popup",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt",                      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_tpsz_tare_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"gross_wgt",                     KeyField:0,   CalcLogic:"|cntr_wgt| + |cntr_tpsz_tare_wgt|",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yard",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"interchange1_loc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"interchange1_nod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"interchange2_loc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"interchange2_nod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_yard",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"yd_chr_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trunkvvd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_no",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_pln_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rail_blk_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_name",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",  	ColMerge:1,   SaveName:"stcc_desc",         			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_cd",          				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"auto_xpt_sys_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"auto_xpt_sys_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",                       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"left",  	ColMerge:1,   SaveName:"cntr_seal_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"overweight",          			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Popup",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stop_off_flg",             		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_rstr_flg",         		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd_yard",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"pol_cd_nm",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",            		KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",              			KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_nod_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"por_nod_cd_yard",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcvde_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ez_tpsz_ft",          			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_cgo_use_flg",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_pop_flg",      			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cnee_cust_nm",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vndr_abbr_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Popup",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"request_sp",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"verify_result",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"n1st_nod_pln_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n1st_nod_pln_dt_hms",           KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lst_nod_pln_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lst_nod_pln_dt_hms",            KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"spcl_instr_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
			             {Type:"Text",      Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibd_cstms_clr_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rail_cmb_thru_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"so_cre_yn",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cop_no",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_grp_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_org_nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_dest_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rout_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd_yard",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"del_nod_cd_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd_yard",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_scc_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_dtl_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibd_ipi_locl_ind_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_patt_div_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rtr_div_cnt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_fm_nod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_fm_nod_yard",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_to_nod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_to_nod_yard",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"stop_off_loc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"stop_off_cntc_pson_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"stop_off_cntc_phn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"stop_off_diff_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",       				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",       				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"decl_nm",       				KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ship_vld_flg",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"con_vld_flg",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dcgo_flg",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"upln_so_flg",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_att_dg_cnt",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_interchange1_loc",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_interchange1_nod",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_interchange2_loc",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_interchange2_nod",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
			             ];
					InitColumns(cols);
					SetEditable(1);
					SetColProperty('auto_xpt_sys_cd', {ComboText:auto_xpt_sys_cdText, ComboCode:auto_xpt_sys_cdCode} );
					resizeSheet();
	      	}
			break;
		case 2:      //sheet1 init
			with(sheetObj){
	        
				var HeadTitle1="S|BKG No|BKG CNTR No|COP CNTR No|TP/SZ|S/O No|Rail ORG|Rail Dest|Rail Road|404 EDI Sent Time" ;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cntr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cop_cntr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"so_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rail_org",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rail_dest",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rail_road",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"edi_sent_time",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				InitColumns(cols);
				SetEditable(1);
	            SetRangeBackColor(1, 30, 1, 33,"#555555");
	            SetVisible(false);
	            SetSheetHeight(100);
	      	}
			break;
		case 3:      //sheet1 init
		    with(sheetObj){
				var HeadTitle1="SEP|EQ_NO|VERIFY_RESULT|VERIFY_YN" ;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sep",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:600,  Align:"Center",  ColMerge:1,   SaveName:"verify_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"verify_yn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				InitColumns(cols);
				SetEditable(1);
				 SetVisible(false);
			}
		    break;
	}
}
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick() {
	/***** Adding additional sheet variables to use more than one sheet per a tab *****/
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var sheetObject2=sheetObjects[2];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
				}
			break;
			case "btn_reset":
				formObject.reset();
				frm_yard.RemoveAll(); // Removing combo data
				to_yard.RemoveAll(); // Removing combo data
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
			break;
			case "btn_minimize":
				Mincount=(Mincount+1)%2;
				Minimize(Mincount);
			break;
			case "btng_verify":
				if( searchValidation(sheetObject, formObject, "chk1") ) {
					doActionIBSheet(sheetObject2, formObject, IBSEARCH, "02");
				}
			break;
			case "btng_irgadjust":
				doActionPopupOpen(sheetObject, formObject);
			break;
			case "btng_socreation":
				if( validateForm(sheetObject, formObject ) ) {
					doActionIBSheet(sheetObject, formObject, IBINSERT, "");
				}
			break;
			case "btns_frmnode": //FromNode Popup
				openHireYardPopup('getFromNode');
			break;
			case "btns_tonode": //ToNode Popup
				openHireYardPopup('getToNode');
			break;
			case "btns_pornode": //PorNode Popup
				openHireYardPopup('getPorNode');
			break;
			case "btns_polnode": //PorNode Popup
				openPolYardPopup('getPolNode');
			break;
			case "btns_multibkg": //M BKG No
				openMultipleinquiry('BKG', 'BKG No');
			break;
			case "btns_multicntr": //M CNTR
				openMultipleinquiry('CNT', 'CNTR No');
			break;
			case "btns_multivvd": //M Trunk VVD
				openMultipleinquiry('VVD', 'T.VVD');
			break;
			case "btns_calendar":
				getCalendar();
			break;
			case "btns_tvvd": //Trunk VVD Popup
				openTVVDPopup();
			break;
			case "bkg_dtl_upper":
				reSize( 0 );
			break;
			case "bkg_dtl_downer":
				reSize( 1 );
			break;
            case "btng_modstcc": {
            	PopupModifySTCC();
            	break;
            }
            case "btng_downexcel": {
                if(sheetObject.RowCount() < 1){
                    ComShowCodeMessage("COM132501");
                } else {
                	var excludeField = null; //["expt"];
                	var includeField = null; //["cng_ind_flg", "vndr_cm"];
                	sheetObject.Down2Excel( {DownCols: makeExcelDownSkipColumn(sheetObject, true, excludeField, includeField), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
                }
                break;
            }
            case "btng_declarant": 
            	PopDeclarant();
            	break;            
		} 
	} catch(e) {
		if( e == "[object Error]") {
			errMsg=ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function doActionIBSheet(sheetObj,formObj,sAction,obj) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case COMMAND01: {
			formObj.f_cmd.value = SEARCH07;
            var pck_tp_cd_val = ComSearchEtcData(sheetObj, "ESD_TRS_0999GS.do", TrsFrmQryString(formObj), 'pck_tp_cd');
            sheetObj.SetColProperty('pck_tp_cd', {ComboText:"|" + pck_tp_cd_val, ComboCode:"|" + pck_tp_cd_val} );
			break;
		}
		case IBSEARCH:{
			if( obj == "01" ) {  
				formObj.f_cmd.value=SEARCH06;
				sheetObj.DoSearch("ESD_TRS_0202GS.do", TrsFrmQryString(formObj) );
			} else if( obj == "02" ) {  
				formObj.f_cmd.value=SEARCH07;
				sheetObj.DoSearch("ESD_TRS_0202GS.do", TrsFrmQryString(formObj) );
			} else if( obj == "03" ) {  
				formObj.f_cmd.value=SEARCH16;
				sheetObj.DoSearch("ESD_TRS_0202GS.do", TrsFrmQryString(formObj) );
			}
			break;
		}
		case IBINSERT: {
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("ESD_TRS_0202GS.do", TrsFrmQryString(formObj), "chk1", false, true);
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
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
		}
	}
}
/**
    * Validating inputted values of form
 */
function validateForm(sheetObj, formObj){
	if( sheetObj.RowCount("I") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	var fromRow=0;
	var pckweightchk = false;
	var weitcheck=false;
	var bverifychk=false;
	var birgchk=false;
	var stccRstrChk=false;
	var stopOffFlg=false;
	var overweight = false;
	var stccCmdGrop = new Array();
	var fromCnt ="";
	var toCnt ="";
	var dgValdArray = new Array();
	var declCntrArray = new Array();
	var shipperCntrArray = new Array();	
	for( var i=0; i< arrRow.length; i++ ) {
		fromRow=arrRow[i];
		fromCnt = sheetObj.GetCellValue(fromRow, "fm_nod_cd").substring(0, 2);
		toCnt = sheetObj.GetCellValue(fromRow, "to_nod_cd").substring(0, 2);
		
		if(fromCnt != toCnt ) {
			if( sheetObj.GetCellValue(fromRow, "cntr_wgt") <= 0.00 || sheetObj.GetCellValue(fromRow, "pck_qty") < 1  || sheetObj.GetCellValue(fromRow, "pck_tp_cd") == "" ) {
				sheetObj.SetRowBackColor(fromRow,"#DEFAF0");
				pckweightchk=true;
			} else {
				sheetObj.SetRowBackColor(fromRow,"#EAEAEA");
			}
		} else {
			if(sheetObj.GetCellValue(fromRow, "cntr_wgt") <= 0.00) {
				sheetObj.SetRowBackColor(fromRow,"#DEFAF0");
				weitcheck=true;
			} else {
				sheetObj.SetRowBackColor(fromRow,"#EAEAEA");
			}
		}
		
		if(sheetObj.GetCellValue(fromRow, "overweight") == 'Y') {
			overweight = true;
		}
		if(sheetObj.GetCellValue(fromRow, "so_cre_yn") != "Y" ) {
			sheetObj.SetRowStatus(fromRow,"R");
			sheetObj.SetCellValue(fromRow, "chk1","0",0);
			sheetObj.SetRowBackColor(fromRow,"#DEFAF0");
			bverifychk=true;
		}
		if( sheetObj.GetCellValue(fromRow, "stcc_rstr_flg") == 'Y') {
			stccCmdGrop.push(sheetObj.GetCellValue(fromRow, "stcc_desc"))
			stccRstrChk=true;
		} 
		if( sheetObj.GetCellValue(fromRow, "stop_off_flg") == 'Y') {
			stopOffFlg=true;
		} 	
		if( sheetObj.GetCellValue(fromRow, "bkg_dcgo_flg") == 'Y') {
			if(sheetObj.GetCellValue(fromRow, "bkg_att_dg_cnt") == "0" ) {
				dgValdArray.push(sheetObj.GetCellValue(fromRow, "eq_no"));
			} else if( sheetObj.GetCellValue(fromRow, "dcgo_flg") == 'Y' && ComIsEmpty(sheetObj.GetCellValue(fromRow, "decl_nm"))) {
				declCntrArray.push(sheetObj.GetCellValue(fromRow, "eq_no"));
			}
		}
		if( sheetObj.GetCellValue(fromRow, "ship_vld_flg") == 'N' ) {
			shipperCntrArray.push(sheetObj.GetCellValue(fromRow, "eq_no"));
		}		
		funcRowFontColor(sheetObj, fromRow);
	}
	if( weitcheck ) {
		ComShowCodeMessage("TRS90455");
		return false;
	}
	if( pckweightchk ) {
		ComShowCodeMessage("TRS90340");
		return false;
	}
	if( bverifychk ) {
		ComShowCodeMessage("TRS90078");
		return false;
	}
    if(dgValdArray.length > 0 ) {
   	 	ComShowCodeMessage('TRS90486', dgValdArray.toString());
        return false;
    }	
    if(declCntrArray.length > 0) {
   	 	ComShowCodeMessage('TRS90480', declCntrArray.toString());
        return false;
    }
    if(shipperCntrArray.length > 0) {
   	 	ComShowCodeMessage('TRS90481', shipperCntrArray.toString());
        return false;
    }	    

	if( sheetObj.RowCount("I") < 1 ) {
		ComShowCodeMessage("TRS90036");
		return false;
	} else {
	   	 if( stccRstrChk || overweight || stopOffFlg) {
			 if (!ComShowCodeConfirm("TRS90426")) {
				 return false; 
			 }
		 }
		return true;
	}
}
/**
    * Validating inputted values of form
 */
function searchValidation(sheetObj, formObj, sStatus) {
	if( sheetObj.RowCount("I") < 1 ) {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	var fromRow=0;
	var lvEq_no="";
	var lvToNodCd="";
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	if( arrRow.length > 0 && arrRow.length < 1001 ) {
		for( var i=0; i<arrRow.length; i++ ) {
			fromRow=arrRow[i];
			if( arrRow.length-1 == i ) {
				lvEq_no=lvEq_no +""+ sheetObj.GetCellValue(fromRow, "eq_no");
				lvToNodCd=lvToNodCd +""+ sheetObj.GetCellValue(fromRow, "to_nod_cd");
			} else {
				lvEq_no=lvEq_no +""+ sheetObj.GetCellValue(fromRow, "eq_no")+",";
				lvToNodCd=lvToNodCd +""+ sheetObj.GetCellValue(fromRow, "to_nod_cd")+",";
			}
		}
		formObj.eq_no_verify.value=lvEq_no;
		formObj.to_nod_verify.value=lvToNodCd;
	}else{
		ComShowMessage('Only 1000 rows or less could be imported at a time.');
		return false;
	}	
	return true;
}

function openObjSheet() {
	return sheetObjects[0];
}
/**
 * Event of Sheet1
 */
function sheet1_OnChange(sheetObj, row , col , value) {
	switch(sheetObj.ColSaveName(col)) {
		case "chk1" : {
			if( value == "1" ) {
				sheetObj.SetRowStatus(row,"I");
			} else {
				sheetObj.SetRowStatus(row,"R");
			}
			break;
		}
		case "cntr_wgt" :  {
			var ez_tpsz_ft = sheetObj.GetCellValue(row, 'ez_tpsz_ft');
			var sVndrAbbrNm = sheetObj.GetCellValue(row, 'vndr_abbr_nm');
			switch(ez_tpsz_ft) {
				case "20" : {
					if(value >= (sVndrAbbrNm=='CN' ? CN_OverWeight20FT : OverWeight20FT)) {
						sheetObj.SetCellValue(row, 'overweight', 'Y', 0);
					} else {
						sheetObj.SetCellValue(row, 'overweight', 'N', 0);
					}
					funcRowFontColor(sheetObj, row);
					break;
				}
				case "40" :  {
					sVndrAbbrNm = 'CN';
					if(value >= (sVndrAbbrNm=='CN' ? CN_OverWeight40FT : OverWeight40FT) ) {
						sheetObj.SetCellValue(row, 'overweight', 'Y', 0);
					} else {
						sheetObj.SetCellValue(row, 'overweight', 'N', 0);
					}
					funcRowFontColor(sheetObj, row);
					break;
				}
				case "45" : {
					if(value >= (sVndrAbbrNm=='CN' ? CN_OverWeight45FT : OverWeight45FT)) {
						sheetObj.SetCellValue(row, 'overweight', 'Y', 0);
					} else {
						sheetObj.SetCellValue(row, 'overweight', 'N', 0);
					}
					funcRowFontColor(sheetObj, row);
					break;
				}
			};
			break;
		}
	}
}

function funcRowFontColor(sheetObject, Row) {
	if(sheetObject.GetCellValue(Row, 'overweight') == 'Y' || sheetObject.GetCellValue(Row, 'stop_off_flg') == 'Y' || sheetObject.GetCellValue(Row, 'stcc_rstr_flg') == 'Y') {
		sheetObject.SetRowFontColor(Row, "#FF0000");
	} else {
		sheetObject.SetRowFontColor(Row, "#000000");
	}
}
/**
 * 
 * DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		var formObj=document.form;
		if( sheetObj.Rowcount ==0 &&  (formObj.bkg_no.value != "" || formObj.cntr_no.value != "")   )  {
			document.all.bkgdtl.style.visibility="visible" ;
			document.all.bkgdtl.style.display="inline" ;
			doActionIBSheet(sheetObjects[1] , formObj, IBSEARCH, "03");
		} else{
			sheetObjects[1] .RemoveAll();
		}
		
		doSearchVerifyByHardcoding(sheetObj);
	}
	reSize(1);
	sheetObject1 = sheetObjects[1];
	doActionIBSheet(sheetObject1, formObj, IBSEARCH, "01");
}
/**
 * 
 * DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
function sheet1_OnSaveEnd(sheetObj,errMsg) {
	var formObject=document.form;
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		if(errMsg != -1){
			 ComShowMessage(ComGetMsg("TRS90103"));
//			
//			errMsg=ComGetMsg("TRS90103");
//			ComShowMessage(errMsg);
//			var sRow=sheetObj.FindCheckedRow("chk1");
//			var arrRow=sRow.split("|");
//			for( var ir=arrRow.length-1; ir >=0 ; ir-- ) {
//				sheetObj.RowDelete(arrRow[ir], false);
//			}
			doActionIBSheet(sheetObj, formObject, IBSEARCH, "01");
//			if( sheetObj.Rowcount ==0 &&  (formObj.bkg_no.value != "" || formObj.cntr_no.value != "")   )  {
//				doActionIBSheet(sheetObjects[1] , formObject, IBSEARCH, "03");
//			}
		}
	}
}
/**
 * General processing method working when there is an error of inquiring result
 * DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
function sheet3_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		doSearchVerifyByHardcoding(sheetObj);
	}
}

/**
 * 
 */
function PopupModifySTCC() {
	if(sheetObjects[0].CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
//	var sRow=sheetObjects[0].FindCheckedRow("chk1");
//	var arrRow=sRow.split("|");
//    for( var i=0; i < arrRow.length; i++ ) {
//    	if(sheetObjects[0].GetCellValue(arrRow[i], 'stcc_pop_flg') == 'N') {
//    		ComShowMessage(ComGetMsg("TRS90427"));
//    		return false;
//    	}
//    }	
	ComOpenPopup('/opuscntr/ESD_TRS_0939.do', 772, 490, "CallbackModifyStcc", '1,0,1,1,1', true);
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
	    	
	    	funcRowFontColor(sheetObjects[0], arrRow[i]);
	    }
     }
}

/**
 * Declarant Popup
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

function trsRetrieve() {
	var sheetObject=sheetObjects[0];
    var formObject=document.form;
    if( validateFormSearch(formObject) ) {
        doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
    }
}


/**
 * 
 * @param sheetObj
 */
function doSearchVerifyByHardcoding(sheetObj) {
	 for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
		 sheetObj.SetCellValue(row, 'verify_result', 'OK', 0);
         sheetObj.SetCellValue(row, 'verify_yn', 'Y', 0);
         sheetObj.SetCellValue(row, "so_cre_yn", "Y", 0);
     }	
}
/*
 * Selecting S/O Creation item of the result of verification function
 */
function doSearchVerify(sheetObj1, sheetObj2) {	
	var sRow=sheetObj1.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	var fromRow=0;	
	var two_year="";
	var two_month="";
	var two_day="";
	var verifyCount=0;
	for( var i=0; i<arrRow.length; i++ ) {
		fromRow=arrRow[i];
		var lvEa_no=sheetObj1.GetCellValue(fromRow, "eq_no");
		sheetObj1.SetCellValue(fromRow, "so_cre_yn", "Y", 0);
		
		var vFm_nod_cd = sheetObj1.GetCellValue(fromRow, "fm_nod_cd").substring(0,2);
		var vTo_nod_cd = sheetObj1.GetCellValue(fromRow, "to_nod_cd").substring(0,2);
		var vAuto_xpt_sys_cd = sheetObj1.GetCellValue(fromRow, "auto_xpt_sys_cd");
		var vAuto_xpt_sys_no = sheetObj1.GetCellValue(fromRow, "auto_xpt_sys_no");
		
		if( vFm_nod_cd == "US" &&  vTo_nod_cd == "CA" && (vAuto_xpt_sys_cd == "" || vAuto_xpt_sys_no == "")){
			sheetObj1.SetCellValue(fromRow, "verify_result","AES No is mandatory",0);
			sheetObj1.SetCellValue(fromRow, "so_cre_yn","",0);
		} else {
			sheetObj1.SetCellValue(fromRow, "verify_result","",0);
		}
		for( var z=1; z < (sheetObj2.RowCount() +1 ); z++ ) {
			if( lvEa_no == sheetObj2.GetCellValue(z, "eq_no") ) {
				sheetObj1.SetCellValue(fromRow, "verify_result", sheetObj2.GetCellValue(z, "verify_result"),0);
				if( sheetObj2.GetCellValue(z, "verify_yn") == "N" ) {
					sheetObj1.SetCellValue(fromRow, "so_cre_yn","Y",0);
				} else {
					sheetObj1.SetCellValue(fromRow, "so_cre_yn","",0);
					sheetObj1.SetRowStatus(fromRow,"R");
					sheetObj1.SetCellValue(fromRow, "chk1","0",0);
					sheetObj1.SetRowBackColor(fromRow,"#DEFAF0");
				}
				sheetObj2.RowDelete(z, false);
				break;
			}
		}
		if( sheetObj1.GetCellValue(fromRow, "verify_result") == "" ) {
			sheetObj1.SetCellValue(fromRow, "verify_result","OK",0);
		}
		if(sheetObj1.GetCellValue(fromRow, "verify_result") != "OK"){
			verifyCount=verifyCount + 1;
		}
	}
	if(verifyCount < 1){
		errMsg=ComGetMsg("TRS90375");
		ComShowMessage(errMsg);	
	}
}

/**
 * 
 * @param sheetObj
 * @param row
 * @param col
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	docProvvndrseq="";
	var colNm = sheetObj.ColSaveName(col);
	if(  colNm == "request_sp" ) {
		docProvvndrseq=sheetObj.GetCellValue(row, "request_sp");
		if( docProvvndrseq != "" ) {
		    ComOpenWindow('ESD_TRS_0956Pop.screen', 'ESD_TRS_0956Pop', 'scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogwidth:402px;dialogHeight:286px', true);
        }
	} else if( colNm == "bkg_spe" ) {
		var myOption="top=200, left=200, width=900, height=450, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0";
		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(row, "eq_no");
		var lvbkgspe=sheetObj.GetCellValue(row, "bkg_spe").substr(0,2)	;
		if( lvbkgspe == 'DG' ) {
			var url="ESD_TRS_0938.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			 ComOpenWindow(url,  window,  myOption );
		} else if( lvbkgspe== 'BB' ) {
			var url="ESD_TRS_0937.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			 ComOpenWindow(url,  window,  myOption );
		} else if( lvbkgspe== 'AK' ) {
			var url="ESD_TRS_0936.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			ComOpenWindow(url,  window,  myOption);
		} else if( lvbkgspe== 'RF' ) {
			var url="ESD_TRS_0935.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			ComOpenWindow(url,  window,  myOption);
		} else if( lvbkgspe== 'HG' ) {
			var url="ESD_TRS_0932.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
			ComOpenWindow(url,  window,  myOption);
		}
	} else if( colNm == "stop_off_flg") {
		if(sheetObj.GetCellValue(row, col) == 'Y') {
			var myOption="scroll:no;status:no;toolbar:no;directories:no;menubar:no;resizable:no;dialogWidth:540px;dialogHeight:300px";
			ComOpenWindow("ESD_TRS_0965.screen?currow=" + row, "ESD_TRS_0965", myOption, true);
		}
	} else if( colNm == "inter_rmk") {
		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(row, "eq_no");
		var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&inter_rmk_cd=T" + "&rail_chk=Y";
		ComOpenWindowCenter(url, "compopup", 1000, 570, true);
	}
}

/**
 * 
 * @param row
 * @returns {___anonymous44350_44683}
 */
function GetStopOffInfo(row) {
	var stopObject = {
			stop_off_loc_cd : sheetObjects[0].GetCellValue(row, "stop_off_loc_cd"),
			stop_off_cntc_pson_nm : sheetObjects[0].GetCellValue(row, "stop_off_cntc_pson_nm"),
			stop_off_cntc_phn_no : sheetObjects[0].GetCellValue(row, "stop_off_cntc_phn_no"),
			stop_off_diff_rmk : sheetObjects[0].GetCellValue(row, "stop_off_diff_rmk")
	}
	return stopObject;
	
}

/**
 * Resizing the page
 */
function Minimize(nItem) {
	var objs=document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display="none";
		sheet1.SetSheetHeight(535);
	} else {
		objs.style.display="inline";
		resizeSheet();
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
	var lvBkg_no=ComTrimAll(formObj.bkg_no.value, " ");
	var lvCntr_no=ComTrimAll(formObj.cntr_no.value, " ");
	var lvTrunk_vvd=ComTrimAll(formObj.trunk_vvd.value, " ");
	if( lvFrmDate == "" ) 
		formObj.frm_plandate.value="";
	if( lvToDate == "" ) //to date
		formObj.to_plandate.value="";
	if( lvBkg_no == "" ) //BKG No
		formObj.bkg_no.value="";
	if( lvCntr_no == "" ) //CNTR No
		formObj.cntr_no.value="";
	if( lvFrmDate == "" && lvToDate != "" ) { //If there's no date data in one part
		errMsg=ComGetMsg("TRS90119");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate == "" ) { //If there's no date data in one part
		errMsg=ComGetMsg("TRS90121");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate != "" ) { //The part of checking the date
		if( !ComIsDate(lvFrmDate) ) {
			errMsg=ComGetMsg("TRS90072");
			ComShowMessage(errMsg);
			formObj.frm_plandate.focus();
			return false;
		} else if( !ComIsDate(lvToDate) ) {
			errMsg=ComGetMsg("TRS90073");
			ComShowMessage(errMsg);
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
		if( lvBkg_no == "" && lvCntr_no == "" && lvTrunk_vvd == "" ) {
			errMsg=ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
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
	if( !ComIsAlphabet(ComTrimAll(lvBkg_no, ","), "n") && lvBkg_no != "" ) {
		formObj.bkg_no.value="";
		formObj.bkg_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvCntr_no, ","), "n") && lvCntr_no != ""  ) {
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
	if( sheetObj.RowCount("I") < 1 ) {
		errMsg=ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
	} else {
		var sRow=sheetObj.FindCheckedRow("chk1");
		var arrRow=sRow.split("|");
		for( var i=0; i<arrRow.length; i++ ) {
			if( sheetObj.GetCellValue(arrRow[i], "inv_bil_patt_div_flg") == "Y" ) {
				sheetObj.SetRowStatus(arrRow[i],"R");
				sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
				sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
				doc_flg=true;
			} 
//			else {
//				if( sheetObj.GetCellValue(arrRow[i], "rout_dtl_seq") == "0" ) {
//					sheetObj.SetRowStatus(arrRow[i],"R");
//					sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
//					sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
//				}
//			}
		}
		if( doc_flg ) {
			ComShowMessage(ComGetMsg("TRS90363"));
		} else {
			if( sheetObj.RowCount("I") < 1 ) {
				ComShowMessage(ComGetMsg("TRS90363"));
			} else {
                ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928',"width=1000; height=480; help=no; status=no; resizable=no; scroll=no; ", false);
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
		errMsg=ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		return false;
	}
	if( sep == 'F' ) {
		lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'R' ) {
		lvPorNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'L' ) {
		lvPolNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
}
/**
 * POL Node popup
 */
function openPolYardPopup(objName) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val="";   
	var cmdt_desc_val="";   
	var classId=objName;
	var param='?sysCode=ENIS';
	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 770, 470, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
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
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 820, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
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
 * Por Node popup's return value
 */
function getPorNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.por_node.value=lvLoc;
	getYardCombo(por_yard, sheetObjects[0], formObject, lvLoc);
	por_yard.CODE=lvYard;
}
/**
 * Por Node popup's return value
 */
function getPolNode(rowArray) {
	var colArray=rowArray[0];
	document.form.pol_node.value=colArray[3];
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
	var param="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+ "&pgmNo=ESD_TRS_0202";
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
	ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 772, 500, classId, '1,0,1,1,1,1,1,1');
}
// Trunk VVD Return Value
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
/*  Resizing bkg_detail sheet */
function reSize(i){
	if ( i==0 ){
		document.all.bkgdtl.style.display="none" ;
	} else {
		document.all.bkgdtl.style.display="inline" ;
	}
}

//UI 표준화관련 하단 여백 설정
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}
