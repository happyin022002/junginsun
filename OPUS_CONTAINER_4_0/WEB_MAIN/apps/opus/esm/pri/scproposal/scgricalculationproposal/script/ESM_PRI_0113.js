/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0113.js
*@FileTitle  : GRI Calculation - Arbitray
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
/**
 * @extends  
 * @class ESM_PRI_0109 : business script for ESM_PRI_0109 
 */
function ESM_PRI_0113() {
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.obj_click=obj_click;
	this.processButtonClick=processButtonClick;
	this.sheet3_OnSearchEnd=sheet3_OnSearchEnd;
	this.sheet1_OnSearchEnd=sheet1_OnSearchEnd;
	this.sheet5_OnSearchEnd=sheet5_OnSearchEnd;
	this.sheet1_OnComboChange=sheet1_OnComboChange;
	this.sheet1_OnSaveEnd=sheet1_OnSaveEnd;
	this.sheet6_OnSaveEnd=sheet6_OnSaveEnd;	
	this.sheet1_OnSelectCell=sheet1_OnSelectCell;
	this.sheet1_OnSort=sheet1_OnSort;
	this.setPointComboMake=setPointComboMake;
	this.setCurrencyComboMake=setCurrencyComboMake;
	this.setSheet1ComboNextMake=setSheet1ComboNextMake;
	this.setSheet1ComboInit=setSheet1ComboInit;
	this.setChkAppDupRow=setChkAppDupRow;
	this.setEditAmtPer=setEditAmtPer;
	this.doActionIBSheet=doActionIBSheet;
	this.doActionIBSheet2=doActionIBSheet2;
	this.doActionIBSheet3=doActionIBSheet3;
	this.doActionIBSheet5=doActionIBSheet5;		
	this.doActionIBSheet6=doActionIBSheet6;		
}
//global variables 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1;
var sheet2;
var sheet3;
var sheet4;
var vOpener=window.dialogArguments;
// Sheet1 Column information
var C1_GRPSEQ="gri_grp_seq";
//var C1_APPL_OPTION    = "flt_pct_tp_cd";
var C1_APPLICATION="gri_appl_div_cd";
var C1_POINT="rout_pnt_loc_def_cd";
var C1_TRANSMODE="prc_trsp_mod_cd";
var C1_TERM="rcv_de_term_cd";
var C1_BASEPORT="bse_port_def_cd";
var C1_VIA="via_port_def_cd";
var C1_POINT_O="point_o";
var C1_TRANSMODE_O="transmode_o";
var C1_TERM_O="term_o";
var C1_BASEPORT_O="baseport_o";
var C1_VIA_O="via_o";
//Sheet2 Column information
var C2_PER="rat_ut_cd";
var C2_CARGOTYPE="prc_cgo_tp_cd";
var C2_CURRENCY="curr_cd";
var C2_AMT="gri_rt_amt";
var C2_RTO="gri_rt_rto";
//Sheet3 Column information
var C3_POINT="rout_pnt_loc_def_cd";
var C3_POINT_NM="rout_pnt_loc_def_nm";
var C3_TRANSMODE="prc_trsp_mod_cd";
var C3_TRANSMODE_NM="prc_trsp_mod_nm";
var C3_TERM="rcv_de_term_cd";
var C3_TERM_NM="rcv_de_term_nm";
var C3_BASEPORT="bse_port_def_cd";
var C3_BASEPORT_NM="bse_port_def_nm";
var C3_VIA="via_port_def_cd";
var C3_VIA_NM="via_port_def_nm";
var C3_CURRENCY="curr_cd";
//Sheet5 Column information
var C5_APPLICATION="gri_appl_div_cd";
var C5_POINT="rout_pnt_loc_def_cd";
var C5_TRANSMODE="prc_trsp_mod_cd";
var C5_TERM="rcv_de_term_cd";
var C5_BASEPORT="bse_port_def_cd";
var C5_VIA="via_port_def_cd";
var C5_APPL_OPTION="flt_pct_tp_cd";
var C5_PER="rat_ut_cd";
var C5_CARGOTYPE="prc_cgo_tp_cd";
var C5_CURRENCY="curr_cd";
var C5_AMT="gri_rt_amt";
var C5_RTO="gri_rt_rto";
//Sheet6 Column information
var C6_POINT="rout_pnt_loc_def_cd";
var C6_TRANSMODE="prc_trsp_mod_cd";
var C6_TERM="rcv_de_term_cd";
var C6_BASEPORT="bse_port_def_cd";
var C6_VIA="via_port_def_cd";
var C6_PER="rat_ut_cd";
var C6_CARGOTYPE="prc_cgo_tp_cd";
var C6_CURRENCY="curr_cd";
var C6_APPL_OPTION="flt_pct_tp_cd";
var C6_AMT="gri_rt_amt";
var C6_RTO="gri_rt_rto";
var gIsSheet1SearchEnd=false;
var gBeforeRow=-1;
var gBeforeColName="";
var gBeforeGrpSeq="";
var gArrPointRange={};  // Point range
var gArrPointCob={}; // Point Mode combo
var gArrTransCob={};    // Trans Mode combo
var gArrTermCob={};     // Term combo
var gArrBPortCob={};    // Base Port combo
var gArrVIACob={};      // VIA combo

//다음의 화면들에서 호출됨
//ESM_PRI_0057_07

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Initializing and setting Sheet basics<br> 
 * Setting body tag's onLoad event handler<br>
 * Adding pre-handling function after loading screen on the browser <br>
 */
function loadPage() {
 	var form=document.form;
	if( form.prop_no.value == "" || form.amdt_seq.value == "" || form.svc_scp_cd.value == "" || form.add_chg_tp_cd.value == "" 
		|| form.org_dest_tp_cd.value == "" || form.gri_appl_tp_cd.value == "" ) {
		ComClosePopup(); 
	}
    sheet1=sheetObjects[0]; // upper grid
    sheet2=sheetObjects[1]; // lower grid
    sheet3=sheetObjects[2]; // combo grid
    sheet4=sheetObjects[3]; // find_text    
    sheet5=sheetObjects[4]; // GRI Calculation
    sheet6=sheetObjects[5]; // Abitrary list for duplicate check  
    sheetCnt=sheetObjects.length;
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); 
        initSheet(sheetObjects[i],i+1);
        sheetObjects[i].SetWaitImageVisible(0);
        ComEndConfigSheet(sheetObjects[i]); 
    }
    initControl();
    //sheet3.WaitImageVisible = false;
    //ComOpenWait(true, false);
    doActionIBSheet3(sheet3, form, IBSEARCH); 
    var statusObjValue=form.gri_appl_tp_cd.value;
    //ComOpenWait(false, false);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1": //  upper grid
			with(sheet1){

			HeadTitle1="ibflag|Seq.|prop_no|amdt_seq|svc_scp_cd|org_dest_tp_cd|gri_grp_seq|Application|Point|TransMode|Term|BasePort|VIA|point org|trans org|term org|baseport org|via org";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prop_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:C1_GRPSEQ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_APPLICATION,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_POINT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_TRANSMODE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_TERM,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_BASEPORT,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_VIA,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_POINT_O,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_TRANSMODE_O,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_TERM_O,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_BASEPORT_O,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C1_VIA_O,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
			
			InitColumns(cols);
			
			SetEditable(0);
			SetDataAutoTrim(1);
			SetColProperty(C1_APPLICATION, {ComboText:"|Include|Exclude", ComboCode:"|I|E"} );
			InitComboNoMatchText(true);
			SetSheetHeight(130);
			}
			break;

    	case "sheet2": // lower grid
			with(sheet2){
			
			var HeadTitle1="status|Seq.|prop no|amdt_seq|svc_scp_cd|org_dest_tp_cd|gri_grp_seq|gri_adj_seq|flt_pct_tp_cd|Per|Cargo Type|Currency|GRI Amount|Percentage(%)"
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prop_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"gri_adj_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"flt_pct_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C2_PER,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:C2_CARGOTYPE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:C2_CURRENCY,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:C2_AMT,            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
			{Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:C2_RTO,            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 } ];
			
			InitColumns(cols);
			
			SetEditable(0);
			SetDataAutoTrim(1);
			SetSheetHeight(130);
    		}
			break;

    	case "sheet3": // hidden grid : combo data selected on parent screen
			with(sheet3){
			
			var HeadTitle1="rnum|Point|Point Nm|Trans\nMode|Trans\nMode Nm|Term|Term Nm|Base Port|Base Port nm|VIA|VIA nm|Currency"
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"rnum",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:C3_POINT,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:C3_POINT_NM,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:C3_TRANSMODE,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C3_TRANSMODE_NM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:C3_TERM,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:C3_TERM_NM,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:C3_BASEPORT,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:C3_BASEPORT_NM,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:C3_VIA,             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:C3_VIA_NM,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:C3_CURRENCY,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetDataAutoTrim(1);
			SetSheetHeight(100);
    		}
			break;

    	case "sheet4": // find_text
			with(sheet4){
			
			var HeadTitle1="f_text1"
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"f_text1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			var idx=sheet4.DataInsert();
			SetSheetHeight(100);
			}
			break;

    	case "sheet5": // all GRI calculation list

			with(sheet5){
			
			var HeadTitle1="Seq.|gri_grp_seq|gri_adj_seq|Application|Point|TransMode|Term|BasePort|VIA|Appl Option|Per|Cargo Type|Currency|amt|percentage";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"gri_grp_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"gri_adj_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_APPLICATION,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_POINT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_TRANSMODE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_TERM,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_BASEPORT,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_VIA,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_APPL_OPTION,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_PER,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_CARGOTYPE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_CURRENCY,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_AMT,            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C5_RTO,            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetDataAutoTrim(1);
			SetSheetHeight(100);
    		}
			break;

    	case "sheet6": // apply target Arbitrary list
			with(sheet6){
			
			var HeadTitle1="status|update cnt|Seq.|prop_no|amdt_seq|svc_scp_cd|add_chg_tp_cd|org_dest_tp_cd|add_chg_seq|gri_grp_seq|Point|Trans Mode|Term|Base Port|VIA|Per|Cargo Type|Currency|appl opt|amt|rto"
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Int",       Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"up_cnt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
			{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"add_chg_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"org_dest_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"add_chg_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"gri_grp_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_POINT,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_TRANSMODE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_TERM,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_BASEPORT,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_VIA,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_PER,            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_CARGOTYPE,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_CURRENCY,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_APPL_OPTION,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_AMT,            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
			{Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:C6_RTO,            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetDataAutoTrim(1);
			SetSheetHeight(100);
    		}
			break;
	}
}
 /**
 * initializing html control<br>
 */ 
function initControl() {
	axon_event.addListenerForm('click', 'obj_click', form);
}
//Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name 
 */
function processButtonClick(){
	var form=document.form;
    try {
	    var srcName=ComGetEvent("name");
	    if(ComGetBtnDisable(srcName)) return false;
	    
	    switch(srcName) {
	    	case "btn_Close":
	    		ComClosePopup(); 
	    		break;
	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
}
    /**
    * calling function when occurring Onclick Event <br>
    * handling process for input validation by object's dataformat 
    */ 
function obj_click(){
	var form=document.form;
	var obj=ComGetEvent();
	switch(ComGetEvent("name")){
	 	case "rdo_appl_option":
	 		setEditAmtPer("CLICK");
	 		break;
	}
 	//if(obj.dataformat == null) return;
}
    /**
     * calling function when occurring OnSearchEnd Event after finishing retrieve sheet3 <br>
     */ 
function sheet3_OnSearchEnd(sheetObj, errMsg) {
    if (sheet3.SearchRows()== 0) return;
    if (errMsg == "") {
    	sheet2.SetWaitImageVisible(0);
        ComOpenWait(true, false);
        setPointComboMake();
    	setCurrencyComboMake();
    	doActionIBSheet2(sheet2, form, IBCLEAR);
        ComOpenWait(false, false);
    	sheet2.SetWaitImageVisible(1);
    	doActionIBSheet(sheet1, form, IBSEARCH);
    }
}   
/**
 * calling function when occurring OnSearchEnd Event after finishing retrieve sheet1 <br>
 */ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
    var form=document.form;
	var rRowCnt=0;
    if (errMsg == "") {
    	if(sheet1.RowCount() > 0) {
            ComOpenWait(true, false);
            var chkPointCd="", chkPointNm=""; 
    		var pointRange, arrPointRange, startRng, endRng; 
    		var pointComboArrCd="=", pointComboArrNm=" "; // making default blank in combo data
    		var startRow1=sheet1.HeaderRows()();
    		var endRow1 = sheet1.HeaderRows() + sheet1.RowCount();
    		for(var k=startRow1; k < endRow1; k++) {
    			// Trans creation
    			var pointCd=sheet1.GetCellValue(k, C1_POINT_O);
        		setSheet1ComboNextMake("SEARCH", k, C1_POINT, pointCd, "");
        		var transModeCd=sheet1.GetCellValue(k, C1_TRANSMODE_O);
        		sheet1.SetCellValue(k, C1_TRANSMODE, transModeCd, 0);
        		// Term creation
        		setSheet1ComboNextMake("SEARCH", k, C1_TRANSMODE, transModeCd, "");
        		var termCd=sheet1.GetCellValue(k, C1_TERM_O);
        		sheet1.SetCellValue(k, C1_TERM, termCd, 0);
        		// Base Port creation
        		setSheet1ComboNextMake("SEARCH", k, C1_TERM, termCd, "");
        		var basePortCd=sheet1.GetCellValue(k, C1_BASEPORT_O);
        		sheet1.SetCellValue(k, C1_BASEPORT, basePortCd, 0);
        		// Via creation
        		setSheet1ComboNextMake("SEARCH", k, C1_BASEPORT, basePortCd, "");
        		var viaCd=sheet1.GetCellValue(k, C1_VIA_O);
        		sheet1.SetCellValue(k, C1_VIA, viaCd, 0);
        		sheet1.SetRowStatus(k,"R");
    		}
            ComOpenWait(false, false);
    		//sheet1.SelectCell(sheet1.HeaderRows(), C1_APPLICATION);
    		gIsSheet1SearchEnd=true;
    		setSheet1RowChange(0, C1_APPLICATION, sheet1.HeaderRows()(), C1_APPLICATION);
    	}
    }
}   
/**
 * calling function when occurring OnSearchEnd Event after finishing retrieve sheet2 <br>
 */ 
function sheet2_OnSearchEnd(sheetObj, errMsg) {
    var form=document.form;
    if (errMsg == "") {
    	if(sheet2.RowCount() > 0) {
    		setEditAmtPer("SEARCH");    		
    	}
    }
	if(gBeforeRow != -1) {
		sheet1.SelectCell(gBeforeRow, gBeforeColName, false);
		gBeforeRow=-1;
		gBeforeColName=C1_APPLICATION;
	}
}   
/**
 * calling function when occurring OnSearchEnd Event after finishing retrieve sheet5 <br>
 */ 
function sheet5_OnSearchEnd(sheetObj, errMsg) {
    var form=document.form;
    if (errMsg == "") {
		if(sheet5.RowCount() > 0) {
			doActionIBSheet6(sheet6, form, IBSEARCH); // getting Arbitrary information to apply for duplicate checking
		} else {
			alert("적용할 GRI Calculation 항목이 없습니다.");
			return;
		}
    }
}   
/**
 * calling function when occurring OnSearchEnd Event after finishing retrieve sheet6 <br>
 */ 
function sheet6_OnSearchEnd(sheetObj, errMsg) {
    var form=document.form;
    if (errMsg == "") {
		if(sheet6.RowCount() > 0) {
	        setChkAppDupRow();
		} else {
			alert("적용될 Arbitrary 항목이 없습니다.");
			return;
		}
    }
}   
/**                                                                                            
 * sheet1_OnComboChange event handler when changing sheet1 combo selection<br>                                                                             
 */  
function sheet1_OnComboChange(sheetObj, Row, Col, Code, Text) {
	var form=document.form;
    var colName=sheet1.ColSaveName(Col);
	switch(colName) {
		case C1_POINT:     
		case C1_TRANSMODE: 
		case C1_TERM:      
		case C1_BASEPORT:  
			ComOpenWait(true, false);
			setSheet1ComboNextMake("CHANGE", Row, colName, Code, Text);
			ComOpenWait(false, false);
			break;
	}
}
/**
 * handling event in case of specific cell on the sheet1 selected <br>
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	var form=document.form;
	var oldGrpSeq=sheet1.GetCellValue(OldRow, C1_GRPSEQ);
	var newGrpSeq=sheet1.GetCellValue(NewRow, C1_GRPSEQ);
	var oldColName=sheet1.ColSaveName(OldCol);
	var newColName=sheet1.ColSaveName(NewCol);
	//alert("[OldRow]" + OldRow + "<=>[NewRow]" + NewRow + "<=>[oldGrpSeq]" + oldGrpSeq + "<=>[newGrpSeq]" + newGrpSeq);	
	if(gIsSheet1SearchEnd && OldRow != NewRow && oldGrpSeq != newGrpSeq) {
		setSheet1RowChange(OldRow, oldColName, NewRow, newColName);
	}	
}
/**
 * handling event when sorting sheet1  <br>
 */
function sheet1_OnSort(sheetObj, Col, SortArrow)  {
	var grpSeq=sheet1.GetCellValue(sheet1.GetSelectRow(), C1_GRPSEQ);
	var colName=sheet1.ColSaveName(Col);
	if(gBeforeGrpSeq != grpSeq) {
		setSheet1RowChange(-1, colName, sheet1.GetSelectRow(), colName);
	}	
}
/**
 * handling setSheet1RowChange event when changing sheet1 row  <br>
 */
function setSheet1RowChange(OldRow, OldColName, NewRow, NewColName) {
	var form=document.form;
	var grpSeq=sheet1.GetCellValue(NewRow, C1_GRPSEQ);
	gBeforeRow=NewRow;
	gBeforeColName=NewColName;
	gBeforeGrpSeq=grpSeq;
	doActionIBSheet2(sheet2, form, IBSEARCH);
}
/** 
* creating Point combo based on registered point data on Arbitray screen <br>
*/
function setPointComboMake() {
	var chkPointCd="", chkPointNm=""; 
	var pointRange, arrPointRange, startRng, endRng; 
	var pointComboArrCd="=", pointComboArrNm=" "; 
	var startRow3=sheet3.HeaderRows()();
	var endRow3 = sheet3.HeaderRows() + sheet3.RowCount();
	for(var k=startRow3; k < endRow3; k++) {
		chkPointCd=sheet3.GetCellValue(k, C3_POINT);           // checking Point Cd value
		chkPointNm=sheet3.GetCellValue(k, C3_POINT_NM);        // checking Point Nm value
		pointRange=sheet3.GetColSameDataRange(k, C3_POINT); // checking same data range
		gArrPointRange[chkPointCd]=pointRange;              // getting range data by Point
		pointComboArrCd=pointComboArrCd + "|" + chkPointCd;
		pointComboArrNm=pointComboArrNm + "|" + chkPointCd + "\t" +chkPointNm;
		arrPointRange=pointRange.split("|");
		startRng=parseInt(arrPointRange[0],10);
		endRng=parseInt(arrPointRange[1],10);
		if(endRng > startRng) {
			k=k + (endRng - startRng);
		}
	}
	sheet1.SetColProperty(C1_POINT, {ComboText:pointComboArrNm, ComboCode:pointComboArrCd} );
}
/** 
* creating Currency combo based on registered Currency data on Arbitray screen <br>
*/
function setCurrencyComboMake() {
	var chkCurrencyCd=""; 
	var currencyRange, arrCurrencyRange, startRng, endRng; 
	var currencyComboArrCd="="; 
	var currencyComboArrNm=" "; 	
	var startRow3=sheet3.HeaderRows()();
	var endRow3 = sheet3.HeaderRows() + sheet3.RowCount();
	for(var k=startRow3; k < endRow3; k++) {
		chkCurrencyCd=sheet3.GetCellValue(k, C3_CURRENCY); // checking Currency Cd value
		currencyRange=sheet3.GetColSameDataRange(k, C3_CURRENCY); // checking same data range
		currencyComboArrCd=currencyComboArrCd + "|" + chkCurrencyCd;
		currencyComboArrNm=currencyComboArrNm + "|" + chkCurrencyCd;
		arrCurrencyRange=currencyRange.split("|");
		startRng=parseInt(arrCurrencyRange[0],10);
		endRng=parseInt(arrCurrencyRange[1],10);
		if(endRng > startRng) {
			k=k + (endRng - startRng);
		}
	}
	sheet2.SetColProperty(C3_CURRENCY, {ComboText:currencyComboArrNm, ComboCode:currencyComboArrCd} );
}
/** 
* creating combo based on sheet3's Point range data when changing sheet1 combo selection <br>
*/
function setSheet1ComboNextMake(mod, colRow, colName, colCode, colText) {
	setSheet1ComboInit(colRow, colName); 
	sheet4.SetCellValue(1, "f_text1","",0);
	var colCode=ComReplaceStr(colCode                               ,'=','');
	var thePointCd=ComReplaceStr(sheet1.GetCellValue(colRow, C1_POINT)    ,'=','');
	var theTransModeCd=ComReplaceStr(sheet1.GetCellValue(colRow, C1_TRANSMODE),'=','');
	var theTermCd=ComReplaceStr(sheet1.GetCellValue(colRow, C1_TERM)     ,'=','');
	var theBasePortCd=ComReplaceStr(sheet1.GetCellValue(colRow, C1_BASEPORT) ,'=','');
	if(thePointCd.length > 0 &&  undefined == gArrPointRange[thePointCd]) { // checking Point Range 
		alert("필터 생성을 위한  Point 구간 정보가 없습니다.");
		return; 
	}
	var startRow=sheet3.HeaderRows()();
	var endRow = sheet3.HeaderRows() + sheet3.RowCount();
	if("" != thePointCd) {
		var arrRange=gArrPointRange[thePointCd].split("|"); // Point Range filter section
		startRow=parseInt(arrRange[0],10);
		endRow=parseInt(arrRange[1],10) + 1;
	}
	var chkFindNum;
	var tmpText;
	var chkPointCd, chkTransModeCd, chkTransNm, chkTermCd, chkTermNm, chkBasePortCd, chkBasePortNm, chkVIACd, chkVIANm;
	var compPointCd=thePointCd;
	var compTransModeCd=theTransModeCd;
	var compTermCd=theTermCd;
	var compBasePortCd=theBasePortCd;
	switch(colName) {
		case C1_POINT: // setting Trans Mode combo when selecting point
			var keyPoint="[" + thePointCd + "]";
			var arrTransCd="=", arrTransNm=" ";
			if(undefined == gArrTransCob[keyPoint]) { 
				for(var i=startRow; i < endRow; i++) {
					chkPointCd=sheet3.GetCellValue(i, C3_POINT);
					chkTransModeCd=sheet3.GetCellValue(i, C3_TRANSMODE);
					chkTransNm=sheet3.GetCellValue(i, C3_TRANSMODE_NM);
					if("" == colCode) compPointCd=chkPointCd;
				    if( chkTransModeCd != "" && compPointCd == chkPointCd ) {
						chkFindNum=sheet4.FindText("f_text1", "[" + chkTransModeCd + "]", 1, 2, true);
						if(chkFindNum < 0){
							arrTransCd=arrTransCd + "|" + chkTransModeCd;
							arrTransNm=arrTransNm + "|" + chkTransNm;
							tmpText=sheet4.GetCellValue(1, "f_text1");
							sheet4.SetCellValue(1, "f_text1",tmpText + "[" + chkTransModeCd + "]",0);
						}
				    }
				}
				gArrTransCob[keyPoint]=arrTransNm + "☜☞" + arrTransCd;
			}
			var filterArrTrans=gArrTransCob[keyPoint].split("☜☞");
			sheet1.CellComboItem(colRow,C1_TRANSMODE, {ComboText:filterArrTrans[0], ComboCode:filterArrTrans[1]} );
			sheet1.SetCellValue(colRow, C1_TRANSMODE," ",0);
			if(mod == "CHANGE") {
        		setSheet1ComboNextMake("CHANGE", colRow, C1_TRANSMODE, "", "");
			}
			break;
		case C1_TRANSMODE: 
			var keyTrans="[" + thePointCd + "][" + theTransModeCd + "]";
			var arrTermCd="=", arrTermNm=" ";
			if(undefined == gArrTermCob[keyTrans]) { 
				for(var i=startRow; i < endRow; i++) {
					chkPointCd=sheet3.GetCellValue(i, C3_POINT); // checking point Mode Cd value
					chkTransModeCd=sheet3.GetCellValue(i, C3_TRANSMODE); // checking Trans Mode Cd value
					chkTermCd=sheet3.GetCellValue(i, C3_TERM);        // checking Term Cd value
					chkTermNm=sheet3.GetCellValue(i, C3_TERM_NM);     // checking Term Nm value
					if("" == thePointCd) compPointCd=chkPointCd;
					if("" == colCode) compTransModeCd=chkTransModeCd;
					if( chkTermCd != "" && compPointCd == chkPointCd && compTransModeCd == chkTransModeCd ) {
						chkFindNum=sheet4.FindText("f_text1", "[" + chkTermCd + "]", 1, 2, true);
						if(chkFindNum < 0){
							// creating Trans combo data
							arrTermCd=arrTermCd + "|" + chkTermCd;
							arrTermNm=arrTermNm + "|" + chkTermNm;
							// saving data for filter
							tmpText=sheet4.GetCellValue(1, "f_text1");
							sheet4.SetCellValue(1, "f_text1",tmpText + "[" + chkTermCd + "]",0);
						}
					}
				}
				gArrTermCob[keyTrans]=arrTermNm + "☜☞" + arrTermCd;
			}
			var filterArrTerm=gArrTermCob[keyTrans].split("☜☞");
			sheet1.CellComboItem(colRow,C1_TERM, {ComboText:filterArrTerm[0], ComboCode:filterArrTerm[1]} );
			sheet1.SetCellValue(colRow, C1_TERM," ",0);
			if(mod == "CHANGE") {
        		setSheet1ComboNextMake("CHANGE", colRow, C1_TERM, "", "");
			}
			break;
		case C1_TERM:      
			var keyTerm="[" + thePointCd + "][" + theTransModeCd + "][" +theTermCd + "]";
			var arrBasePortCd="=", arrBasePortNm=" ";
			if(undefined == gArrBPortCob[keyTerm]) { 
				for(var i=startRow; i < endRow; i++) {
					chkPointCd=sheet3.GetCellValue(i, C3_POINT); // checking point Mode Cd value
					chkTransModeCd=sheet3.GetCellValue(i, C3_TRANSMODE); // checking Trans Mode Cd value
					chkTermCd=sheet3.GetCellValue(i, C3_TERM);        // checking Term Cd value
					chkBasePortCd=sheet3.GetCellValue(i, C3_BASEPORT);
					chkBasePortNm=sheet3.GetCellValue(i, C3_BASEPORT_NM);
					if("" == thePointCd) compPointCd=chkPointCd;
					if("" == theTransModeCd) compTransModeCd=chkTransModeCd;
					if("" == colCode) compTermCd=chkTermCd;
					if( chkBasePortCd != "" && compPointCd == chkPointCd && compTransModeCd == chkTransModeCd && compTermCd == chkTermCd) {
						chkFindNum=sheet4.FindText("f_text1", "[" + chkBasePortCd + "]", 1, 2, true);
						if(chkFindNum < 0){
							// creating Trans combo data
							arrBasePortCd=arrBasePortCd + "|" + chkBasePortCd;
							arrBasePortNm=arrBasePortNm + "|" + chkBasePortCd + "\t" + chkBasePortNm;
							// saving data for filter
							tmpText=sheet4.GetCellValue(1, "f_text1");
							sheet4.SetCellValue(1, "f_text1",tmpText + "[" + chkBasePortCd + "]",0);
						}
					}
				}
				gArrBPortCob[keyTerm]=arrBasePortNm + "☜☞" + arrBasePortCd;
			}
			var filterArrBport=gArrBPortCob[keyTerm].split("☜☞");
			sheet1.CellComboItem(colRow,C1_BASEPORT, {ComboText:filterArrBport[0], ComboCode:filterArrBport[1]} );
			sheet1.SetCellValue(colRow, C1_BASEPORT," ",0);
			if(mod == "CHANGE") {
        		setSheet1ComboNextMake("CHANGE", colRow, C1_BASEPORT, "", "");
			}
			break;
		case C1_BASEPORT:    
			var keyBPort="[" + thePointCd + "][" + theTransModeCd + "][" +theTermCd + "][" + theBasePortCd + "]";
			var arrVIACd="=", arrVIANm=" ";
			if(undefined == gArrVIACob[keyBPort]) { 
				for(var i=startRow; i < endRow; i++) {
					chkPointCd=sheet3.GetCellValue(i, C3_POINT); // checking point Mode Cd value
					chkTransModeCd=sheet3.GetCellValue(i, C3_TRANSMODE); // checking Trans Mode Cd value
					chkTermCd=sheet3.GetCellValue(i, C3_TERM);        // checking Term Cd value
					chkBasePortCd=sheet3.GetCellValue(i, C3_BASEPORT);    // checking Base Port Cd value
					chkVIACd=sheet3.GetCellValue(i, C3_VIA);    // checking VIA Cd value
					chkVIANm=sheet3.GetCellValue(i, C3_VIA_NM); // checking VIA Nm value
					if("" == thePointCd) compPointCd=chkPointCd;
					if("" == theTransModeCd) compTransModeCd=chkTransModeCd;
					if("" == theTermCd) compTermCd=chkTermCd;
					if("" == colCode) compBasePortCd=chkBasePortCd;
					if( chkVIACd != "" && compPointCd == chkPointCd && compTransModeCd == chkTransModeCd && compTermCd == chkTermCd && compBasePortCd == chkBasePortCd ) {
						chkFindNum=sheet4.FindText("f_text1", "[" + chkVIACd + "]", 1, 2, true);
						if(chkFindNum < 0){
							// creating Trans combo data
							arrVIACd=arrVIACd + "|" + chkVIACd;
							arrVIANm=arrVIANm + "|" + chkVIACd + "\t" + chkVIANm;
							// saving data for filter
							tmpText=sheet4.GetCellValue(1, "f_text1");
							sheet4.SetCellValue(1, "f_text1",tmpText + "[" + chkVIACd + "]",0);
						}
					}
				}
				gArrVIACob[keyBPort]=arrVIANm + "☜☞" + arrVIACd;
			}
			var filterArrVia=gArrVIACob[keyBPort].split("☜☞");
			sheet1.CellComboItem(colRow,C1_VIA, {ComboText:filterArrVia[0], ComboCode:filterArrVia[1]} );
			sheet1.SetCellValue(colRow, C1_VIA," ",0);
			break;
	}
}
/** 
* initializaing sheet1's combo  <br>
*/
function setSheet1ComboInit(colRow, colName) {
	switch(colName) {
		case C1_POINT: // when selecting Point, setting Term combo
			sheet1.CellComboItem(colRow,C1_TRANSMODE, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_TRANSMODE," ",0);
			sheet1.CellComboItem(colRow,C1_TERM, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_TERM," ",0);
			sheet1.CellComboItem(colRow,C1_BASEPORT, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_BASEPORT," ",0);
			sheet1.CellComboItem(colRow,C1_VIA, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_VIA," ",0);
			return;
		case C1_TRANSMODE:     // when selecting Trans Mode 
			sheet1.CellComboItem(colRow,C1_TERM, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_TERM," ",0);
			sheet1.CellComboItem(colRow,C1_BASEPORT, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_BASEPORT," ",0);
			sheet1.CellComboItem(colRow,C1_VIA, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_VIA," ",0);
			break;
		case C1_TERM:      // when selecting Term  
			sheet1.CellComboItem(colRow,C1_BASEPORT, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_BASEPORT," ",0);
			sheet1.CellComboItem(colRow,C1_VIA, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_VIA," ",0);
		    break;
		case C1_BASEPORT:     // when selecting Base Port  
			sheet1.CellComboItem(colRow,C1_VIA, {ComboText:"", ComboCode:"="} );
			sheet1.SetCellValue(colRow, C1_VIA," ",0);
			break;
	}
}
/** 
* GRI Calculation - checking duplicate for applying Arbitray and creating implement data  <br>
*/
function setChkAppDupRow() {
	var form=document.form;
	var totalCnt=0;
	var calApplication, calApplOpt;
	var calKey, calTarget;
	var calPoint, calTRansMode, calTerm, calBasePort, calVIA, calPer, calCargoType, calCurrency;
	var compPoint, compTRansMode, compTerm, compBasePort, compVIA;
	var arbCnt=0;
	var arbKey, arbTarget;
	var arbPoint, arbTRansMode, arbTerm, arbBasePort, arbVIA, arbPer, arbCargoType, arbCurrency;
	var startRow5=sheet5.HeaderRows()();
	var endRow5 = sheet5.HeaderRows() + sheet5.RowCount();
	var startRow6=sheet6.HeaderRows()();
	var endRow6 = sheet6.HeaderRows() + sheet6.RowCount();
	for(var i=startRow5; i < endRow5; i++) {
		calGrpSeq=sheet5.GetCellValue(i, "gri_grp_seq");
		calApplication=sheet5.GetCellValue(i, C5_APPLICATION);
		calApplOpt=sheet5.GetCellValue(i, C5_APPL_OPTION);
		calAmt=sheet5.GetCellValue(i, C5_AMT);
		calRto=sheet5.GetCellValue(i, C5_RTO);
		calPoint=sheet5.GetCellValue(i, C5_POINT);
		calTRansMode=sheet5.GetCellValue(i, C5_TRANSMODE);
		calTerm=sheet5.GetCellValue(i, C5_TERM);
		calBasePort=sheet5.GetCellValue(i, C5_BASEPORT);
		calVIA=sheet5.GetCellValue(i, C5_VIA);
		calPer=sheet5.GetCellValue(i, C5_PER);
		calCargoType=sheet5.GetCellValue(i, C5_CARGOTYPE);
		calCurrency=sheet5.GetCellValue(i, C5_CURRENCY);
		compPoint=calPoint    ;
		compTRansMode=calTRansMode;
		compTerm=calTerm     ;
		compBasePort=calBasePort ;
		compVIA=calVIA      ;
		if (calApplication != "I" && calApplication != "E") {
				alert('Application 이 존재하지 않는 GRI Calculation 항목이 존재합니다.');
				return;
		}
		if(calApplOpt == "F") {
			if(calAmt == "" || parseInt(calAmt, 10) == 0) {
				ComShowCodeMessage("PRI00335", "GRI Amount");  
				return;
			}
			if(calRto != "") {
				alert("Application Option 과 GRI Amount, Percentage(%) 가 일치하지 않습니다. ");
				return;
			}
		}
		if(calApplOpt == "P") {
			if(calRto == "" || parseInt(calRto, 10) == 0) {
				ComShowCodeMessage("PRI00335", "Percentage");  
				return;
			}
			if(calAmt != "") {
				alert("Application Option 과 GRI Amount, Percentage(%) 가 일치하지 않습니다. ");
				return;
			}
		}
		if( calApplOpt == "" || (calRto != "" && calAmt != "") ) {
			alert("Application Option 과 GRI Amount, Percentage(%) 가 일치하지 않습니다. ");
			return;
		}
		for(var k=startRow6; k < endRow6; k++) {
			var OK=false;
			arbCnt=sheet6.GetCellValue(k, "up_cnt");
			arbPoint=sheet6.GetCellValue(k, C6_POINT);
			arbTRansMode=sheet6.GetCellValue(k, C6_TRANSMODE);
			arbTerm=sheet6.GetCellValue(k, C6_TERM);
			arbBasePort=sheet6.GetCellValue(k, C6_BASEPORT);
			arbVIA=sheet6.GetCellValue(k, C6_VIA);
			arbPer=sheet6.GetCellValue(k, C6_PER);
			arbCargoType=sheet6.GetCellValue(k, C6_CARGOTYPE);
			arbCurrency=sheet6.GetCellValue(k, C6_CURRENCY);
			if(calApplication == "I" || calApplication == "E") {
				if(calPoint == "") compPoint=arbPoint;
				if(calTRansMode == "") compTRansMode=arbTRansMode;
				if(calTerm == "") compTerm=arbTerm;
				if(calBasePort == "") compBasePort=arbBasePort;
				if(calVIA == "") compVIA=arbVIA;
				calKey=compPoint + compTRansMode + compTerm + compBasePort + compVIA;
				calTarget=calPer + calCargoType + calCurrency;
				arbKey=arbPoint + arbTRansMode + arbTerm + arbBasePort + arbVIA;
				abrTarget=arbPer + arbCargoType + arbCurrency;
				if(calApplication == "I") {
					if(calKey == arbKey && calTarget == abrTarget) OK=true;
				}else{
					if(calKey != arbKey && calTarget == abrTarget) OK=true;
				}
				if(OK) {
					totalCnt++;
					arbCnt++;
					sheet6.SetRowStatus(k,"U");
					sheet6.SetCellValue(k, "up_cnt",arbCnt);
					sheet6.SetCellValue(k, "gri_grp_seq",calGrpSeq);
					sheet6.SetCellValue(k, C6_APPL_OPTION,calApplOpt);
					sheet6.SetCellValue(k, C6_AMT,calAmt);
					sheet6.SetCellValue(k, C6_RTO,calRto);
				}
			}else{
				return;
			}
			if(arbCnt > 1) {
				alert('Arbitrary 항목중 중복 적용되는 항목이 존재합니다.');
				return;
			}
		} // end for Arbitrary
	} // end for Calculation
	if(totalCnt == 0) {
		alert('적용 항목이 존재하지 않습니다.');
		return;
	}
	doActionIBSheet6(sheet6, form, IBSAVE);
}
/** 
*  setting sheet2 cell editable or not by Appcication Option<br>
*/
function setEditAmtPer(mod) {
	var form=document.form;
	var obj=form.rdo_appl_option;
	var rdoApplOptionValue=ComGetObjValue(obj);
	var startRow2=sheet2.HeaderRows()();
	var endRow2 = sheet2.HeaderRows() + sheet2.RowCount();
	var isAmt=false;
	var amt, rto;
	if(mod == "SEARCH") {
		for(var i=startRow2; i < endRow2; i++ ) {
			amt=sheet2.GetCellValue(i, C2_AMT);
			rto=sheet2.GetCellValue(i, C2_RTO);
			if(amt == "") {
				sheet2.SetCellEditable(i, C2_AMT,0);
	  		    sheet2.SetCellEditable(i, C2_RTO,1);
			} else {
				isAmt=true;
	  		    sheet2.SetCellEditable(i, C2_AMT,1);
	  		    sheet2.SetCellEditable(i, C2_RTO,0);
			}
			sheet2.SetCellValue(i, "flt_pct_tp_cd",rdoApplOptionValue,0);
			sheet2.SetRowStatus(i,"R");
		}
		if(isAmt){
			obj[0].checked=true;
		}else{
			obj[1].checked=true;
		}
	}else if(mod == "CLICK"){
		for(var i=startRow2; i < endRow2; i++ ) {
			if(rdoApplOptionValue == "F") {
				sheet2.SetCellEditable(i, C2_AMT,1);
	  		    sheet2.SetCellEditable(i, C2_RTO,0);
  		    	sheet2.SetCellValue(i, C2_RTO,"",0);
			} else {
	  		    sheet2.SetCellEditable(i, C2_AMT,0);
	  		    sheet2.SetCellEditable(i, C2_RTO,1);
  	  		    sheet2.SetCellValue(i, C2_AMT,"",0);
			}
			sheet2.SetCellValue(i, "flt_pct_tp_cd",rdoApplOptionValue,0);
		}
	}else if(mod == "ROWADD") {
		if(rdoApplOptionValue == "F") {
			sheet2.SetCellEditable(sheet2.GetSelectRow(), C2_AMT,1);
  		    sheet2.SetCellEditable(sheet2.GetSelectRow(), C2_RTO,0);
		} else {
  		    sheet2.SetCellEditable(sheet2.GetSelectRow(), C2_AMT,0);
  		    sheet2.SetCellEditable(sheet2.GetSelectRow(), C2_RTO,1);
		}
		sheet2.SetCellValue(sheet2.GetSelectRow(), "flt_pct_tp_cd",rdoApplOptionValue,0);
	}
}
/**
 * Handling sheet process <br>
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheet1.ShowDebugMsg(false);
	switch(sAction) {
		case IBCLEAR: 
			var sXml="";
			break;
        case IBSEARCH: //  retrieving upper grid
			formObj.f_cmd.value=SEARCH;
 			var sXml = sheet1.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) );
 			sheet1.LoadSaveData(sXml);
 			//sheet1.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj));
 			break;
	}
}
/**
 * Handling sheet process 2 <br>
 */
function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheet2.ShowDebugMsg(false);
	switch(sAction) {
		case IBCLEAR: 
			var sXml="";
			//per combo
			formObj.f_cmd.value=SEARCH03;
 			sXml=sheet2.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			setIBCombo(sheet2, sXml, "rat_ut_cd", true, 0);
			//setIBCombo(sheet2, sXml, "rat_ut_cd", true, 0, " ", " ", 1);
			//comon cargo
			formObj.f_cmd.value=SEARCH19;
			formObj.cd.value="CD02202";
 			sXml=sheet2.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			//setIBCombo(sheet2, sXml, "prc_cgo_tp_cd", false, 0, "DR");
			setIBCombo(sheet2, sXml, "prc_cgo_tp_cd", true, 0);			
			break;
        case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH01; // retrieving lower grid
			var griGrpSeq=sheet1.GetCellValue(sheet1.GetSelectRow(), C1_GRPSEQ);
 			var sXml = sheet2.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) + "&gri_grp_seq="+griGrpSeq );
 			sheet2.LoadSaveData(sXml);
 			break;
	}
}
/**
 * Handling sheet process 3 <br>
 */
function doActionIBSheet3(sheetObj, formObj, sAction) {
	sheet3.ShowDebugMsg(false);
	switch(sAction) {
		case IBCLEAR: 
			var sXml="";
			break;
        case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH02;
			var pGriGrpSeq=sheet1.GetCellValue(sheet1.GetSelectRow(), C1_GRPSEQ);
        	var orgDestTpCd=form.org_dest_tp_cd.value;
 			var sXml = sheet3.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) + "&gri_grp_seq=" + pGriGrpSeq + "&org_dest_tp_cd=" + orgDestTpCd );
 			sheet3.LoadSaveData(sXml);
 			//sheet3.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj));
 			break;
	}
}
/**
 * Handling sheet process 5 <br>
 */
function doActionIBSheet5(sheetObj, formObj, sAction) {
	sheet5.ShowDebugMsg(false);
	sheet5.SetWaitImageVisible(0);
	switch(sAction) {
		case IBCLEAR: 
			var sXml="";
			break;
        case IBSEARCH: //retrieve
        	sheet5.RemoveAll();
			formObj.f_cmd.value=SEARCH03; // all Cal possible applying
  			sheet5.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) );
 			//var sXml = sheet5.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj));	
			//sheet5.LoadSaveXml(sXml);
 			break;
	}
}
/**
 * Handling sheet process 6 <br>
 */
function doActionIBSheet6(sheetObj, formObj, sAction) {
	sheet6.ShowDebugMsg(false);
	sheet6.SetWaitImageVisible(0);
	switch(sAction) {
		case IBCLEAR: 
			var sXml="";
			break;
        case IBSEARCH: //retrieve
        	sheet6.RemoveAll();
			formObj.f_cmd.value=SEARCH04; 
  			sheet6.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) );
 			break;
	}
}
