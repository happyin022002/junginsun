/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0201.js
*@FileTitle  : USA Rail Billing S / O to generate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------From here the common JavaScript function is defined.     ------------------*/
/* Common global variable  */
var sheetObjects=new Array();
var comboObjects=new Array();
var sheetCnt=0;
var comboCnt=0;
var Mincount=0; //SHEET is reduced by the increased
var docObjsep="I";
var R=222;
var G=251;
var B=248;

var OverWeight20FT = 43000;
var OverWeight40FT = 45000;
var OverWeight45FT = 42700;

var CN_OverWeight20FT = 47901;
var CN_OverWeight40FT = 60001;
var CN_OverWeight45FT = 60001;
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}

/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
    for(i=0;i<sheetObjects.length;i++) {
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
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                  var HeadTitle1  =  "S|STS|Container\nNumber|Type\nSize|Rail ORG|Rail ORG|Yard Character|InterchangeⅠ|InterchangeⅠ|InterchangeⅡ|InterchangeⅡ|Rail DEST|Rail DEST|BL No|Weight(LBS)|Weight(LBS)|Weight(LBS)|Consignee|STCC";
                      HeadTitle1 +=	 "|Commodity Group\nDescription|Rail\nBulk|Commodity\nDescription|Seal No|Stowage|Restricted|OverWeight|Agreement\nReference No|Rail\nRoad|POD|POD|Booking No|Expt|Customs\nC.LOC|DEL\nSCC|Term|BKG\nCargo\nType|BKG\nSPE|CNTR\nSPE|Filer|DEL|DEL|DEL";
                      HeadTitle1 +=	 "|Latest Movement Status|Latest Movement Status|Latest Movement Status|BS|IT No|CN Underbond\nRelease\nnot Required|No of\nPKG|PKG\nCode|stcc_cgo_use_flg|stcc_pop_flg";
                      HeadTitle1 +=	 "|Shipper|Route\nPlan|Trunk\nVVD|Lane|S/C No|Verify\nResult|Planned Time|Planned Time|Planned Time|Planned Time|Internal\nRemark|Remark\n(Special Instruction)" ;
                      
                  var HeadTitle2  =  "S|STS|Container\nNumber|Type\nSize|Loc|Node|Yard Character|Loc|Node|Loc|Node|Loc|Node|BL No|Net|Tare|Gross|Consignee|STCC|Commodity Group\nDescription|Rail\nBulk|Commodity\nDescription|Seal No|Stowage|Restricted|OverWeight";
                  	  HeadTitle2 +=	 "|Agreement\nReference No|Rail\nRoad|Loc|Node|Booking No|Expt|Customs\nC.LOC|DEL\nSCC|Term|BKG\nCargo\nType|BKG\nSPE|CNTR\nSPE|Filer|Loc|Node|Name|Status|Yard|Date|BS|IT No|CN Underbond\nRelease\nnot Required";
                      HeadTitle2 +=	 "|No of\nPKG|PKG\nCode|stcc_cgo_use_flg|stcc_pop_flg";
                      HeadTitle2 +=	 "|Shipper|Route\nPlan|Trunk\nVVD|Lane|S/C No|Verify\nResult|From Departure|From Departure|To Arrival|To Arrival|Internal\nRemark|Remark\n(Special Instruction)" ;
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);
                  var cols = [ 
                             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
                             {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yard",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"yd_chr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"interchange1_loc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"interchange1_nod",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"interchange2_loc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"interchange2_nod",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_yard",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_tpsz_tare_wgt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"gross_wgt",             KeyField:0,   CalcLogic:"|cntr_wgt| + |cntr_tpsz_tare_wgt|",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cnee_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_cd",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",  	ColMerge:1,   SaveName:"stcc_desc",         	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rail_blk_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
                             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_name",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"stwg",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_rstr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"overweight",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"vndr_abbr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd_yard",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Image",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"expt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ibd_cstms_clr_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_scc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcvde_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_spe",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"nvocc_file_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd_yard",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"del_nod_cd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",              	KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"blck_stwg_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibd_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"CheckBox",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnd_cstms_clr_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, 	HeaderCheck:0},
                             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
    			             {Type:"Combo",     Hidden:0, Width:60,    Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_pop_flg",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"stcc_cgo_use_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shpr_cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_pln_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trunkvvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"n1st_nod_pln_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n1st_nod_pln_dt_hms",   KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lst_nod_pln_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lst_nod_pln_dt_hms",    KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Popup",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"spcl_instr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibd_ipi_locl_ind_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rail_cmb_thru_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cop_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cost_act_grp_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_grp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_org_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_dest_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rout_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd_yard",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_nod_cd_yard",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_dtl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"so_cre_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inv_bil_patt_div_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rtr_div_cnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vd_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tml_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_fm_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_fm_nod_yard",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_to_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_to_nod_yard",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",       		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",       		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"decl_nm",       		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ship_vld_flg",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"con_vld_flg",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dcgo_flg",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"upln_so_flg",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_att_dg_cnt",       	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_interchange1_loc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_interchange1_nod",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_interchange2_loc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_interchange2_nod",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                             ];
                   
                  InitColumns(cols);
        
                  SetEditable(1);
                  SetImageList(0,"/opuscntr/img/opus/ico_r.gif");
                  SetHeaderRowHeight(25);
                  SetCellBackColor(1, "pod_cd", "#555555");
                  SetCellBackColor(1, "pod_cd_yard", "#555555");
                  SetCellBackColor(1, "fm_nod_cd", "#555555");
                  SetCellBackColor(1, "fm_nod_yard", "#555555");
                  SetCellBackColor(1, "interchange1_loc", "#555555");
                  SetCellBackColor(1, "interchange1_nod", "#555555");
                  SetCellBackColor(1, "interchange2_loc", "#555555");
                  SetCellBackColor(1, "interchange2_nod", "#555555");
                  SetCellBackColor(1, "to_nod_cd", "#555555");
                  SetCellBackColor(1, "to_nod_yard", "#555555");

                  SetCellBackColor(1, "del_nod_cd", "#555555");
                  SetCellBackColor(1, "del_nod_cd_yard", "#555555");
                  SetCellBackColor(1, "del_nod_cd_nm", "#555555");
                  SetCellBackColor(1, "cnmv_sts_cd", "#555555");
                  SetCellBackColor(1, "crnt_yd_cd", "#555555");
                  SetCellBackColor(1, "cnmv_dt", "#555555");

                  SetCellBackColor(1, "cntr_wgt", "#555555");
                  SetCellBackColor(1, "cntr_tpsz_tare_wgt", "#555555");
                  SetCellBackColor(1, "gross_wgt", "#555555");
                  
                  SetCellBackColor(1, "n1st_nod_pln_dt", "#555555");
                  SetCellBackColor(1, "n1st_nod_pln_dt_hms", "#555555");
                  SetCellBackColor(1, "lst_nod_pln_dt", "#555555");
                  SetCellBackColor(1, "lst_nod_pln_dt_hms", "#555555");
                  resizeSheet();
            }
            break;
        case 2:      //sheet1 init
            with(sheetObj){            
              var HeadTitle1="SEP|EQ_NO|VERIFY_RESULT|VERIFY_YN" ;
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sep",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:600,  Align:"Center",  ColMerge:1,   SaveName:"verify_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"verify_yn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);
    
              SetEditable(1);
              SetVisible(0);
            }
            break;
    }
}
/* Click the button to define an event handler that receives and processes events */
document.onclick=processButtonClick;
/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick() {
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_retrieve":
                if( validateFormSearch(formObject) ) {
                    doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
                }
            break;
            case "btn_reset":
                formObject.reset();
                frm_yard.RemoveAll(); // combo Deletion of data
                to_yard.RemoveAll(); // combo Deletion of data
                sheetObject.RemoveAll();
            break;
            case "btn_minimize":
                Mincount=(Mincount+1)%2;
                Minimize(Mincount);
            break;
            case "btng_irgadjust":
                doActionPopupOpen(sheetObject, formObject);
            break;
            case "btng_socreation":
                if( validateForm(sheetObject, formObject) ) {
                    doActionIBSheet(sheetObject, formObject, IBINSERT, "");
                }
            break;
            case "btng_verify":
                if( searchValidation(sheetObject, formObject, "chk1") ) {
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH, "02");
                }
            break;
            case "btng_downexcel": 
                if(sheetObject.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                	var excludeField = ["expt"];
                	var includeField = null; //["cng_ind_flg", "vndr_cm"];
                	sheetObject.Down2Excel( {DownCols: makeExcelDownSkipColumn(sheetObject, true, excludeField, includeField), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 });
                }
            break;
            case "btns_frmnode": //FromNode Popup Window
                openHireYardPopup('getFromNode');
            break;
            case "btns_tonode": //ToNode Popup Window
                openHireYardPopup('getToNode');
            break;
            case "btns_delnode": //DelNode Popup Window
                openHireYardPopup('getDelNode');
            break;
            case "btns_podnode": //PodNode Popup Window
                openHireYardPopup('getPodNode');
            break;
            case "btns_multivvd": //M Trunk VVD
                openMultipleinquiry('VVD', 'T.VVD');
            break;
            case "btns_multibl": //M B/L No
                openMultipleinquiry('BLN', 'B/L No');
            break;
            case "btns_multibkg": //M BKG No
                openMultipleinquiry('BKG', 'BKG No');
            break;
            case "btns_multicntr": //M CNTR
                openMultipleinquiry('CNT', 'CNTR No');
            break;
            case "btns_multisc": //M S/C No
                openMultipleinquiry('SC', 'S/C No');
            break;
            case "btns_calendar":
                getCalendar();
            break;
            case "btns_tvvd": //Trunk VVD Popup Window
                openTVVDPopup();
            break;
            case "btng_modstcc": {
            	PopupModifySTCC();
            	break;
            }
            case "btng_declarant": 
            	PopDeclarant();
            	break;
        }
    } catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("TRS90106"));
        } else {
            ComShowMessage(e.message);
        }
    }
}

/*
 * Sheet processing-related processes
 */
function doActionIBSheet(sheetObj,formObj,sAction, obj) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
	    case COMMAND01:
			formObj.f_cmd.value = SEARCH07;
	        var pck_tp_cd_val = ComSearchEtcData(sheetObj, "ESD_TRS_0999GS.do", TrsFrmQryString(formObj), 'pck_tp_cd');
	        sheetObj.SetColProperty('pck_tp_cd', {ComboText:"|" + pck_tp_cd_val, ComboCode:"|" + pck_tp_cd_val} );
		break;
    	case IBSEARCH:      
            if( obj == "01" ) {
                formObj.f_cmd.value=SEARCH01;
            } else if( obj == "02" ) {
                formObj.f_cmd.value=SEARCH02;
            }
            IBS_DoSearchSax(sheetObj, "ESD_TRS_0201GS.do", TrsFrmQryString(formObj));
        break;
        case IBINSERT:      
            formObj.f_cmd.value=MULTI;
            sheetObj.DoSave("ESD_TRS_0201GS.do", TrsFrmQryString(formObj), "chk1", false, true);
        break;
    }
}
/*
 * doSearchEnter
 */
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
 * Screen form validation process for processing the input values
 */
function validateForm(sheetObj, formObj){
    if( sheetObj.RowCount("I") < 1 ) {
        errMsg=ComGetMsg("TRS90036");
        ComShowMessage(errMsg);
        return false;
    }
    var sRow=sheetObj.FindCheckedRow("chk1");
    var arrRow=sRow.split("|");
    var fromRow=0;
    var bverifychk=false;
    var birgchk=false;
	var stccRstrChk=false;
	var overweight=false;
	var stopOffFlg = false;
	var dgValdArray = new Array();
	var declCntrArray = new Array();
	var consigneeCntrArray = new Array();
    for( var i = 0; i < arrRow.length; i++ ) {
        fromRow=arrRow[i];
        if( sheetObj.GetCellValue(fromRow, "overweight") == 'Y') {
        	overweight = true;
        }
        if( sheetObj.GetCellValue(fromRow, "so_cre_yn") != "Y" ) {
            sheetObj.SetRowStatus(fromRow,"R");
            sheetObj.SetCellValue(fromRow, "chk1","0",0);
            sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
            bverifychk=true;
        }
		if( sheetObj.GetCellValue(fromRow, "stcc_rstr_flg") == 'Y') {
			stccRstrChk=true;
		}
		
		if( sheetObj.GetCellValue(fromRow, "bkg_dcgo_flg") == 'Y') {
			if(sheetObj.GetCellValue(fromRow, "bkg_att_dg_cnt") == "0" )  {
				dgValdArray.push(sheetObj.GetCellValue(fromRow, "eq_no"));
			} else if(sheetObj.GetCellValue(fromRow, "dcgo_flg") == 'Y' && ComIsEmpty(sheetObj.GetCellValue(fromRow, "decl_nm"))){
				declCntrArray.push(sheetObj.GetCellValue(fromRow, "eq_no"));
			}
		} 
		if( sheetObj.GetCellValue(fromRow, "con_vld_flg") == 'N' ) {
			consigneeCntrArray.push(sheetObj.GetCellValue(fromRow, "eq_no"));
		}
		funcRowFontColor(sheetObj, fromRow);
    }
    if( bverifychk ) {
        ComShowCodeMessage('TRS90078');
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
    if(consigneeCntrArray.length > 0) {
   	 	ComShowCodeMessage('TRS90482', consigneeCntrArray.toString());
        return false;
    }	     
    if( sheetObj.RowCount("I") < 1 ) {
        ComShowCodeMessage('TRS90078');
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

function trsRetrieve() {
	var sheetObject=sheetObjects[0];
    var formObject=document.form;
    if( validateFormSearch(formObject) ) {
        doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
    }
}

/**
 * 
 * @param sheetObject
 * @param Row
 */
function funcRowFontColor(sheetObject, Row) {
	if( sheetObject.GetCellValue(Row, 'expt') == "0" || sheetObject.GetCellValue(Row, 'overweight') == 'Y' || sheetObject.GetCellValue(Row, 'stop_off_flg') == 'Y' || sheetObject.GetCellValue(Row, 'stcc_rstr_flg') == 'Y') {
		sheetObject.SetRowFontColor(Row, "#FF0000");
	} else {
		sheetObject.SetRowFontColor(Row, "#000000");
	}
}
/**
 * Screen form validation process for processing the input values
 */
function searchValidation(sheetObj, formObj, sStatus) {
    if( sheetObj.RowCount("I") < 1 ) {
        errMsg=ComGetMsg("TRS90036");
        ComShowMessage(errMsg);
        return false;
    }
    //Determine the number of data rows
    var fromRow=0;
    var lvEq_no="";
    var sRow=sheetObj.FindCheckedRow("chk1");
    var arrRow=sRow.split("|");
    if( arrRow.length > 0 && arrRow.length < 1001 ) {
        for( var i=0; i<arrRow.length; i++ ) {
            fromRow=arrRow[i];
            if( i == 0 )
            {
                lvEq_no = sheetObj.GetCellValue(fromRow, "eq_no");
            }
            else
            {
                lvEq_no = lvEq_no + "," + sheetObj.GetCellValue(fromRow, "eq_no") + ",";
            }
        }
        formObj.eq_no_verify.value=lvEq_no;        
    }else{
        ComShowMessage('Only 1000 rows or less could be imported at a time.');
        return false;
    }    
    return true;
}
/*
 * openObjSheet
 */
function openObjSheet() {
    return sheetObjects[0];
}
/**
 * sheet1_OnChange
 */
function sheet1_OnChange(sheetObj, row , col , value) {
    if( sheetObj.ColSaveName(col) == "chk1" ) {
        if( value == "1" ) {
            sheetObj.SetRowStatus(row,"I");
        } else {
            sheetObj.SetRowStatus(row,"R");
        }
    }
}
/**
 * When the error occurs on the result of a lookup function to handle common
 */
function sheet1_OnSaveEnd(sheetObj, errCode, errMsg) {
	if(errCode < 0 ) {
		ComShowMessage(errMsg);
	} else {
		ComShowMessage(ComGetMsg("TRS90103"));
		doActionIBSheet(sheetObj, document.form, IBSEARCH, "01");
	}
}

/**
 * sheet1_OnSearchEnd
 * 2015.02.05    Hyungwook Choi
 */
function sheet1_OnSearchEnd(sheetObj, errCode, errMsg) {
    if( errCode < 0 ) {
        ComShowMessage(errMsg);
    } else {
        for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++) {
            sheetObj.SetCellValue(row, 'verify_result', 'OK', 0);
            sheetObj.SetCellValue(row, 'so_cre_yn', 'Y', 0);
        }
    }
}

/**
 * 조When the error occurs on the result of a lookup function to handle common
 */
function sheet2_OnSearchEnd(sheetObj, errMsg)
{
    if( errMsg.length > 0 )
    {
        ComShowMessage(errMsg);
    }
    else
    {
        for(var row = sheetObj.HeaderRows(); row < sheetObj.HeaderRows() + sheetObj.RowCount(); row++)
        {
            sheetObj.SetCellValue(row, 'verify_result', 'OK', 0);
            sheetObj.SetCellValue(row, 'verify_yn', 'Y', 0);
        }

    }
}

/*
 * Verify the results viewed on the S / O Creation item selection
 */
function doSearchVerify(sheetObj1, sheetObj2) {
    var sRow=sheetObj1.FindCheckedRow("chk1");
    var arrRow=sRow.split("|");
    var fromRow=0;
    var verifyCount=0;
    for( var i=0; i<arrRow.length; i++ ) {
        fromRow=arrRow[i];
        var lvEa_no=sheetObj1.GetCellValue(fromRow, "eq_no");
        sheetObj1.SetCellValue(fromRow, "so_cre_yn","Y",0);
        if( sheetObj1.GetCellValue(fromRow, "verify_result") == "" ) {
            sheetObj1.SetCellValue(fromRow, "verify_result","OK",0);
        }
        for( var z=1; z<(sheetObj2.RowCount()+1); z++ ) {
            if( lvEa_no == sheetObj2.GetCellValue(z, "eq_no") ) {
                sheetObj1.SetCellValue(fromRow, "verify_result",sheetObj2.GetCellValue(z, "verify_result"),0);
                if( sheetObj2.GetCellValue(z, "verify_yn") == "N" ) { //S / O Creation available
                    sheetObj1.SetCellValue(fromRow, "so_cre_yn","Y",0);
                } else {
                    sheetObj1.SetCellValue(fromRow, "so_cre_yn","",0);
                    sheetObj1.SetRowStatus(fromRow,"R");
                    sheetObj1.SetCellValue(fromRow, "chk1","0",0);
                    sheetObj1.SetRowBackColor(fromRow,"#NANNANNAN");
                }
                sheetObj2.RowDelete(z, false);
                break;
            }
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
 * Is increased by reducing the screen.
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
function validateFormSearch(formObj) {
    var lvFrmDate=ComTrimAll(ComTrimAll(formObj.frm_plandate.value, " "), "-");
    var lvToDate=ComTrimAll(ComTrimAll(formObj.to_plandate.value, " "), "-");
    var lvFrm_node=ComTrimAll(formObj.frm_node.value, " ");
    var lvTo_node=ComTrimAll(formObj.to_node.value, " ");
    var lvTrunk_vvd=ComTrimAll(formObj.trunk_vvd.value, " ");
    var lvBill_no=ComTrimAll(formObj.bill_no.value, " ");
    var lvBkg_no=ComTrimAll(formObj.bkg_no.value, " ");
    var lvCntr_no=ComTrimAll(formObj.cntr_no.value, " ");
    var lvSc_no=ComTrimAll(formObj.sc_no.value, " ");
    if( lvFrmDate == "" ) //from date
        formObj.frm_plandate.value="";
    if( lvToDate == "" ) //to date
        formObj.to_plandate.value="";
    if( lvTrunk_vvd == "" ) //T.VVD
        formObj.trunk_vvd.value="";
    if( lvBill_no == "" ) //B/L No
        formObj.bill_no.value="";
    if( lvFrmDate == "" && lvToDate != "" ) { //If either date is missing
        errMsg=ComGetMsg("TRS90119");
        ComShowMessage(errMsg);
        return false;
    } else if( lvFrmDate != "" && lvToDate == "" ) { //If either date is missing
        errMsg=ComGetMsg("TRS90121");
        ComShowMessage(errMsg);
        return false;
    } else if( lvFrmDate != "" && lvToDate != "" ) { //Check the date the part
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
            errMsg=ComGetMsg("TRS90118");
            ComShowMessage(errMsg);
            return false;
        }
    } else {
        if( lvTrunk_vvd == "" && lvBill_no == "" && lvBkg_no == "" && lvCntr_no == "" ) {
            errMsg=ComGetMsg("TRS90124");
            ComShowMessage(errMsg);
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
    if( !ComIsAlphabet(ComTrimAll(lvBill_no, ","), "n") && lvBill_no != "" ) {
        formObj.bill_no.value="";
        formObj.bill_no.focus();
        return false;
    }
    formObj.hid_frmdate.value=lvFrmDate; //from Date
    formObj.hid_todate.value=lvToDate; //to Date
    formObj.frm_node.value=lvFrm_node.toUpperCase();
    formObj.to_node.value=lvTo_node.toUpperCase();
    formObj.trunk_vvd.value=lvTrunk_vvd.toUpperCase(); //T.VVD
    formObj.bill_no.value=lvBill_no.toUpperCase(); //B/L No
    formObj.bkg_no.value=lvBkg_no.toUpperCase(); //BKG No
    formObj.cntr_no.value=lvCntr_no.toUpperCase(); //CNTR No
    formObj.sc_no.value=lvSc_no.toUpperCase(); //S/C No
    return true;
}
/*
 * IRG Adjuct Pop up will call.
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
//                else {
//                    if( sheetObj.GetCellValue(arrRow[i], "rout_dtl_seq") == "0" ) {
//                        sheetObj.SetRowStatus(arrRow[i],"R");
//                        sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
//                        sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
//                    }
//                }
            }
            if( doc_flg ) {
                errMsg=ComGetMsg("TRS90363");
                ComShowMessage(errMsg);
            } else {
                if( sheetObj.RowCount("I") < 1 ) {
                    errMsg=ComGetMsg("TRS90148");
                    ComShowMessage(errMsg);
                } else {
                    var myOption="width=1000; height=480; help=no; status=no; resizable=no; scroll=no; ";
                    ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928', myOption, false);
                }
            }
        }
}
/*
 * Get a list of external combo box
 */
function getComboList(obj, comObj, sep) {
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
    } else if( sep == 'D' ) {
        lvDelNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
    } else if( sep == 'P' ) {
        lvDelNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
    }
}
/**
 * Common Node popup
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
 * From Node to pop the return value for
 */
function getPodNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.pod_node.value=lvLoc;
    getYardCombo(pod_yard, sheetObjects[0], formObject, lvLoc);
    pod_yard.CODE=lvYard;
}

/**
 * From Node to pop the return value for
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
    getYardCombo(to_yard, sheetObjects[0], formObject, lvLoc);
    to_yard.CODE=lvYard;
}

/**
 * The return value for the pop-up Del Node
 */
function getDelNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var lvLoc=node.substring(0, 5);
    var lvYard=node.substring(5, 7);
    formObject.del_node.value=lvLoc;
    getYardCombo(del_yard, sheetObjects[0], formObject, lvLoc);
    del_yard.CODE=lvYard;
}

/**
 * Common Trunk VVD popup
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
    var param="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+ "&pgmNo=ESD_TRS_0201";
    ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 390, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
 * Location: If a pop-up from a single selection.
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
    } else if( obj == "SC" ) {
        formObject.sc_no.value=reObj;
    } else {
        errMsg=ComGetMsg("TRS90132");
        ComShowMessage(errMsg);
    }
}

/**
 * Common Trunk VVD popup
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

/**
 * 
 */
function PopupModifySTCC() {
	if( sheetObjects[0].CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	ComOpenPopup('/opuscntr/ESD_TRS_0939.do', 772, 490, "CallbackModifyStcc", '1,0,1,1,1', true);
}

/**
 * 
 * @returns
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
 * 
 * @param rowArray
 */
function getCOM_ENS_VVD_1(rowArray) {
    var formObject=document.form;
    var gubun="";
    var colArray=rowArray[0];
    formObject.trunk_vvd.value=colArray[7] + gubun;
}

/*
 * If you open the pop-up handle to handle dtPopupEdit
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
    if( sheetObj.ColSaveName(col) == "bkg_spe" ) {
        var myOption="top=200, left=200, width=900, height=450, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0";
        var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
        var lveqno=sheetObj.GetCellValue(row, "eq_no");
        if( sheetObj.GetCellValue(row, "bkg_spe") == 'DG ' ) {
            var url="ESD_TRS_0938.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
             ComOpenWindow(url,  window,  myOption );
        } else if( sheetObj.GetCellValue(row, "bkg_spe") == 'BB ' ) {
            var url="ESD_TRS_0937.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
             ComOpenWindow(url,  window,  myOption);
        } else if( sheetObj.GetCellValue(row, "bkg_spe") == 'AK ' ) {
            var url="ESD_TRS_0936.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
             ComOpenWindow(url,  window,  myOption);
        } else if( sheetObj.GetCellValue(row, "bkg_spe") == 'RF ' ) {
            var url="ESD_TRS_0935.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
             ComOpenWindow(url,  window,  myOption);
        } else if( sheetObj.GetCellValue(row, "bkg_spe") == 'HG ' ) {
            var url="ESD_TRS_0932.do?bkg_no="+lvbkg+"&cntr_no="+lveqno;
             ComOpenWindow(url,  window,  myOption);
        }
    } else if( sheetObj.ColSaveName(col) == "inter_rmk") {
		var lvbkg=sheetObj.GetCellValue(row, "bkg_no");
		var lveqno=sheetObj.GetCellValue(row, "eq_no");
		var url="ESD_TRS_0982Pop.do?bkg_no=" + lvbkg + "&eq_no=" + lveqno + "&inter_rmk_cd=T" + "&rail_chk=Y";
		ComOpenWindowCenter(url, "compopup", 1000, 570, true);
	}
}

/*
 * Calendar Pop-Up Multi-Input
 */
function getCalendar() {
    var cal=new ComCalendarFromTo();
    cal.displayType="date";
    cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');
}

/*
 * Addition to date.
 */
function getDateBetween(obj) {
    if(document.form.frm_plandate.value == ""){
        document.form.to_plandate.value="";
    }else{
        document.form.to_plandate.value=ComGetDateAdd(obj.value, "D", 30);        
    }
}

//UI 표준화관련 하단 여백 설정
function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}