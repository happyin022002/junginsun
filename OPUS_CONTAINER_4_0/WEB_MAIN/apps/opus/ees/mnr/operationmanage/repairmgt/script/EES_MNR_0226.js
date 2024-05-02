/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0226.js
*@FileTitle  : M&R Simple W/O Inquiry Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
//Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var costDtlCode="";
var costDtlDesc="";
var OrgCostType="";
var nowLoad=0;
//Using for upload file
var uploadObjects=new Array();
var uploadCnt=0;
//Requesting calculate
var calReq=0;
//Deleting calculate
var calDel="";
var OrgVndrSeq="";
var OrgCostCd="";
//At retrieving combo of sheet
var arrDataSearchDbXml;
//Defining event handler of button click */
document.onclick=processButtonClick;
//Event handler to diverge process by button name */
function processButtonClick(){
	/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_downExcel":
 			sheetObjects[0].Down2Excel();
			break;
        case "btn_Close":
        	ComClosePopup(); 
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
* Assigning array of IBSheet object
* Array defined at the top of the source
*/
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Sheet default setting and initializing
* To implement for onload event of body tag
* After loading in your browser should display the ability to add pre-processing
*/
function loadPage() {
	MnrWaitControl(true);
	initControl();
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k + 1);
	}
	initCombo();
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	MnrWaitControl(false);
}
function initControl() {
	//Axon event handling 1. Catching event
	var formObject=document.form;
	axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
//	axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
	//axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
	axon_event.addListenerFormat('change',	 'obj_change',	formObject);
}
//Axon event handling 2. Event handling function
function obj_deactivate(){
	ComChkObjValid(ComGetEvent());
}
function obj_activate(){
	ComClearSeparator(ComGetEvent());
}
function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if ( ComTrim(obj.value) != "" ) {
		switch(ComGetEvent("name")) {
		case "none":
			break;
		}
	}
}
function obj_keypress(){
	obj=ComGetEvent();
	keys=event.keyCode;
	if(obj.dataformat == null) return;
	window.defaultStatus=obj.dataformat;
	var formObj=document.form;
	if ( ComTrim(obj.value) != "" ) {
		switch(ComGetEvent("name")) {
		case "none":
			break;
		}
	}
	switch(obj.dataformat) {
	case "ymd":
	case "int":
		ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet();
		break;
	case "engup":
		ComKeyOnlyAlphabet('uppernum');
		break;
	}
}
/**
* Initializing variable for IBSheet and defining header
* param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
*/
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //t1sheet1 init
	    with(sheetObj){        
	      var HeadTitle="|Sel|Seq.|Service Sub Type|EQ No.|TP/SZ|Yard|Work Date|Recent Record Information|Recent Record Information|Recent Record Information|Booking No|Trade Code";
	      var HeadTitle1="|Sel|Seq.|Service Sub Type|EQ No.|TP/SZ|Yard|Work Date|Recent Date|Recent Yard|Recent S/P|Booking No|Trade Code";
	      var headCount=ComCountHeadTitle(HeadTitle) + 9;
	      (headCount, 0, 0, true);
	      var prefix="sheet1_";
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cost_dtl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_rslt_dt2",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_rslt_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"sp_name",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_rt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_vrfy_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"spr_prt_uc_amt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"bzc_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rpr_offh_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_inv_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetEditable(0);
	      SetShowButtonImage(2);
	      SetSheetHeight(167);
      }
	break;
	case 2:      //t1sheet1 init
	    with(sheetObj){
		      var HeadTitle="|Summary Information|Summary Information|Summary Information|Summary Information|Summary Information|Summary Information|Summary Information|Summary Information";
		      var HeadTitle1="|Seq.|S/Type|TP/SZ|Yard Code|Q'ty|Unit Cost|Total|System Veify Result";
		      var prefix="sheet2_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_dtl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:85,  Align:"Right",   ColMerge:0,   SaveName:prefix+"rpr_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:114,  Align:"Right",   ColMerge:0,   SaveName:prefix+"agmt_rt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"total",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:117,  Align:"Left",    ColMerge:0,   SaveName:prefix+"result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ord_index",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_vrfy_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"bzc_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetEditable(0);
		      SetSheetHeight(167);
            }
	    break;
	case 3:      // sheet1 init
	    with(sheetObj){       
		      var HeadTitle1="MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|EQ_KND_CD|MNR_GRP_TP_CD|MNR_WO_TP_CD|COST_CD|TRSM_MOD_CD|AGMT_OFC_CTY_CD|AGMT_SEQ"
		      + "|AGMT_VER_NO|CURR_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|ORD_ISS_OFC_CD|MNR_ORD_SND_DT|COST_OFC_CD|VNDR_SEQ"
		      + "|SPR_PRT_SPL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|SPR_PRT_BRTH_DT|SPR_PRT_SPL_YD_CD|SPR_PRT_SPL_DT|ORD_HDR_RMK"
		      + "|MNR_INP_DT|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT|AGMT_NO" ;
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      var prefix="sheet3_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_ofc_cty_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_knd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_grp_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_wo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trsm_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_ver_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_agmt_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_wrk_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_amt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ord_iss_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_snd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_brth_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ord_hdr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_inp_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetEditable(0);
		      SetSelectionMode(smSelectionRow);
		      SetVisible(false);
      }
	break;
	case 4:
		with (sheetObj) {
		SetVisible(false);
		}
		break;
	}
}
/**
* Initializing multi combo
* @return
*/
function initCombo() {
	var formObject=document.form
	with (combo_vndr_seq) {
		SetMultiSeparator("|");
		SetTitle("S/P Name|S/P Code|AGMT No|EQ TYPE|Effective Date|Reference No|Tariff No|Currency^AgmtVerNo^EQ code");
		SetColAlign(0, "left");
		SetColAlign(1, "left");
		SetColAlign(2, "center");
		SetColAlign(3, "left");
		SetColAlign(4, "center");
		SetColAlign(5, "left");
		SetColAlign(6, "left");
		SetColAlign(7, "left");
		SetColWidth(0, "180");
		SetColWidth(1, "80");
		SetColWidth(2, "90");
		SetColWidth(3, "80");
		SetColWidth(4, "170");
		SetColWidth(5, "180");
		SetColWidth(6, "180");
		SetColWidth(7, "0");
		SetDropHeight(160);
	}
	with (combo_cost_cd) {
		SetMultiSeparator("|");
		SetColAlign(0, "left");
		SetColWidth(0, "180");
		SetDropHeight(160);
	}
	with (combo_eq_knd_cd) {
		SetMultiSeparator("|");
		SetTitle("Code|Name");
		SetColAlign(0, "left");
		SetColAlign(1, "left");
		SetColWidth(0, "90");
		SetColWidth(1, "180");
		SetDropHeight(160);
		SetEnable(0);
	}
	combo_eq_knd_cd_Initialize();
}
function combo_vndr_seq_Initialize(){
	var formObj=document.form;
	var sXml=MnrAGMTHdrCombo(sheetObjects[0],formObj.cost_ofc_cd.value);
	var arrResult=MnrXmlToArray(sXml);
	if(arrResult != null){
		for(var i=0; i < arrResult.length;i ++){
			var tempComboText=arrResult[i][8]       //8 vndr_nm|
			                 + "|" + arrResult[i][1]  //1 vndr_seq|
			                 + "|" + arrResult[i][9]  //9 agmt_no|
			     			 + "|" + arrResult[i][30]  //29 agmt_ofc_cd|
			                 + "|" + arrResult[i][3]   //3eq_type_name|
			                 + "|" + arrResult[i][13] +"~" + arrResult[i][15]  //  13 eff_dt - 15 exp_dt|
			                 + "|" + arrResult[i][2] //2 agmt_ref_no|
			                 + "|" + arrResult[i][25]   //25 trf_no|
			                 + "|" + arrResult[i][14] //14 curr_cd|
			                 + "^" + arrResult[i][12]   //12 agmt_ver_no|
                             + "^" + arrResult[i][28]   //28eq_knd_cd|
			                  ;
			combo_vndr_seq.InsertItem(i, tempComboText ,arrResult[i][1]);
		}
	} else {
		ComShowCodeMessage("MNR00056");
	}
}
function combo_vndr_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;
	for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++)
	{
		var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
		if(intPayInvSeq =="") intPayInvSeq=0;
		if(parseInt(intPayInvSeq) > 0 )
		{
			ComShowCodeMessage("MNR00229");
			combo_vndr_seq.SetSelectCode(OrgVndrSeq,false);
			return false;
		}
	}
	var strEtc=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()),  8 );
	var spltEtc=strEtc.split("^");
	formObj.pic_eng_nm.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 0 );
	formObj.curr_cd.value=spltEtc[0];
	var strAgmtNo=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()),  2 );
	if(strAgmtNo.length > 3)
	{
		formObj.agmt_ofc_cty_cd.value=strAgmtNo.substring(0,3);
		formObj.agmt_seq.value=strAgmtNo.substring(3);
	}
	var strAgmtVerNo=spltEtc[1];
	if ( ComIsNumber(strAgmtVerNo))
	{
		formObj.agmt_ver_no.value=strAgmtVerNo;
	}
	var arr=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()),  5 ).split("~");
	var tmpEffFrom="";
	var tmpEffTo="";
	if(arr==""){
		tmpEffFrom="";
		tmpEffTo="";
	}else{
		tmpEffFrom=arr[0];
		tmpEffTo=arr[1];
	}
	formObj.eff_dt.value=tmpEffFrom.trim();
	formObj.exp_dt.value=tmpEffTo.trim();
	combo_eq_knd_cd.SetSelectCode(spltEtc[2],false);
	combo_cost_cd_Initialize(combo_eq_knd_cd.GetSelectCode());
	if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
		if(ComShowCodeConfirm("MNR00080")){
			sheet1_cost_dtl_cd_Initialize(combo_cost_cd.GetSelectCode());
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
		}else{
			combo_cost_cd.SetSelectCode(OrgCostType,false);
		}
	}
}
function combo_eq_knd_cd_Initialize(){
	var formObj=document.form;
	combo_eq_knd_cd.SetSelectCode("-1",false);
	combo_eq_knd_cd.RemoveAll();
	//comboRetrieving
	var sheetObj=sheetObjects[0];
	var sCondition=new Array (
			new Array("MnrGenCd","CD00002", "COMMON") //EQ Type
	);
	var comboList=MnrComSearchCombo(sheetObj,sCondition);
	for(var i=0; i < comboList.length;i++)
	{
		if(comboList[i] != null)
		{
			for(var j=0; j < comboList[i].length;j++)
			{
				var tempText=comboList[i][j].split("|");
				if(i==0)
				{
					combo_eq_knd_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
				}
			}
			if(i ==0)
			{
				combo_eq_knd_cd.SetSelectCode("");
			}
		}
	}
}
function combo_eq_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	if(Text == null) return;
	combo_cost_cd_Initialize(newText);
}
function combo_cost_cd_Initialize(eqtype){
	var formObj=document.form;
	combo_cost_cd.SetSelectCode(-1,false);
	combo_cost_cd.RemoveAll();
	var sheetObj=sheetObjects[0];
	var sCondition=new Array (
			new Array("MnrGenCd",eqtype, "CUSTOM7") //Cost Type
	);
	var comboList=MnrComSearchCombo(sheetObj,sCondition);
	for(var i=0; i < comboList.length;i++)
	{
		if(comboList[i] != null)
		{
			for(var j=0; j < comboList[i].length;j++)
			{
				var tempText=comboList[i][j].split("|");
				if(i==0)
				{
					var tempTxt = tempText[0]+"-"+tempText[1];
					combo_cost_cd.InsertItem(j, tempText[0]+"|"+tempText[1]+"|"+ tempTxt,tempText[0]);
				}
			}
		}
	}
	if(sheetObjects[0].RowCount()> 1)
		combo_cost_cd.SetSelectCode(OrgCostType,false);
}
function combo_cost_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;
	for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++)
	{
		var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
		if(intPayInvSeq =="") intPayInvSeq=0;
		if(parseInt(intPayInvSeq) > 0 )
		{
			ComShowCodeMessage("MNR00229");
			combo_cost_cd.SetSelectCode(OrgCostCd,false);
			return false;
		}
	}
	if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
 		for(var i=0; i < sheetObjects[0].DataRows; i ++ ){
		var tmpEx=sheetObjects[0].GetCellValue(i, "sheet1_cost_dtl_cd");
			if(tmpEx != Text){
				if(ComShowCodeConfirm("MNR00080")){
					sheet1_cost_dtl_cd_Initialize(combo_cost_cd.GetSelectCode());
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
				}else{
					combo_cost_cd.SetSelectCode(OrgCostType,false);
					break;
				}
			}
		}
	}else{
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheet1_cost_dtl_cd_Initialize(combo_cost_cd.GetSelectCode());
	}
	
	if(combo_cost_cd.GetSelectCode() == "MRDRPT"){
		sheetObjects[0].SetColHidden("sheet1_bkg_no",0);
		sheetObjects[0].SetColHidden("sheet1_trd_cd",0);
	}else{
		sheetObjects[0].SetColHidden("sheet1_bkg_no",1);
		sheetObjects[0].SetColHidden("sheet1_trd_cd",1);
	}
	OrgCostType=combo_cost_cd.GetSelectCode();
}
function sheet1_OnPopupClick(sheetObj, Row,Col){
	if (sheetObj.ColSaveName(Col) != "sheet1_rpr_rslt_dt2") return;
var intPayInvSeq=sheetObj.GetCellValue(Row,"sheet1_pay_inv_seq");
	if(intPayInvSeq =="") intPayInvSeq=0;
	if(parseInt(intPayInvSeq) > 0 )
	{
		ComShowCodeMessage("MNR00229");
		return false;
	}else{
		var cal=new ComCalendarGrid();
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
}
//Extra Expense Type Sheet Combo
function sheet1_cost_dtl_cd_Initialize(costtype){
	if(nowLoad==0)
	{
		sheetObjects[0].RemoveAll();
	}
	var sheetObj=sheetObjects[0];
	var sCondition=new Array (
			new Array("MnrGenCd",costtype, "COMMON") //Service Sub Type
	);
	costDtlCode="";
	costDtlDesc="";
	var comboList=MnrComSearchCombo(sheetObj,sCondition);
	for(var i=0; i < comboList.length;i++)
	{
		if(comboList[i] != null)
		{
			for(var j=0; j < comboList[i].length;j++)
			{
				var tempText=comboList[i][j].split("|");
				if(i==0)
				{
					costDtlCode=costDtlCode + tempText[0] + "|";
					costDtlDesc=costDtlDesc + tempText[1] + "|";
				}
			}
			if(i==0)
			{
				costDtlCode=costDtlCode.substring(0, costDtlCode.length - 1);
				costDtlDesc=costDtlDesc.substring(0, costDtlDesc.length - 1);
				sheetObjects[0].SetColProperty(0,"sheet1_cost_dtl_cd", {ComboText:costDtlDesc, ComboCode:costDtlCode} );
				sheetObjects[1].SetColProperty(0,"sheet2_cost_dtl_cd", {ComboText:costDtlDesc, ComboCode:costDtlCode} );
			}
		}
	}
}
function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
	if(nowLoad==1)return;
	var formObj=document.form;
	if(sheetObj.ColSaveName(OldCol) == "sheet1_eq_no" )
	{
		var checkEqn=sheetObjects[0].GetCellValue(OldRow,"sheet1_eq_no");
		if(checkEqn == "")
		{
			return;
		}
	}
	if(sheetObj.ColSaveName(OldCol) == "sheet1_yd_cd2" )
	{
		if (NewRow <sheetObjects[0].HeaderRows())
			return;
		var strYard=sheetObjects[0].GetCellValue(OldRow,"sheet1_yd_cd2");
		if(strYard == "")
		{
			ComShowCodeMessage("MNR00161","Yard");
			sheetObjects[0].SetCellValue(OldRow,"sheet1_yd_cd2","",0);
			sheetObjects[0].SelectCell(OldRow,"sheet1_yd_cd2");
			return;
		}
	}
}
function sheet3_OnSearchEnd(sheetObj, errMsg) {
	var formObj=document.form;
	var prefix="sheet3_";
	if(sheetObj.RowCount()<=0)
	{
		doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
		ComSetObjValue(formObj.mnr_ord_seq, "");
		ComShowCodeMessage("MNR00005", "W/O No.");
		ComSetFocus(formObj.mnr_ord_seq);
		nowLoad=0;
		return false;
	}
//no support[check again]CLT 	combo_vndr_seq.UseCode=false;
	var agree_no=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ofc_cty_cd")
	+ ComLpad(sheetObjects[2].GetCellValue(1, prefix+ "agmt_seq"),6,"0");
	if(agree_no !="000000"){
		combo_vndr_seq.SetSelectIndex(combo_vndr_seq.FindItem(agree_no,2, true));
	 	//no support[check again]CLT 	combo_vndr_seq.UseCode=true;
		OrgVndrSeq=combo_vndr_seq.GetSelectCode();
		formObj.pic_eng_nm.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 0 );
		formObj.vndr_seq.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 2 ) ;
	}else{
		formObj.pic_eng_nm.value="";
		formObj.vndr_seq.value="" ;
	}
	combo_eq_knd_cd.SetSelectCode(sheetObjects[2].GetCellValue(1, prefix+ "eq_knd_cd"),false);
	formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectText();
	formObj.curr_cd.value=sheetObjects[2].GetCellValue(1, prefix+ "curr_cd");
	formObj.agmt_ofc_cty_cd.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ofc_cty_cd");
	formObj.agmt_seq.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_seq");
	formObj.agmt_ver_no.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ver_no");
	formObj.showDate.value=sheetObjects[2].GetCellValue(1, prefix+ "cre_dt");
	formObj.ord_hdr_rmk.value=sheetObjects[2].GetCellValue(1, prefix+ "ord_hdr_rmk");
	var costcd=sheetObjects[2].GetCellValue(1, prefix+ "cost_cd");
	OrgCostCd=costcd;
	combo_cost_cd_Initialize(combo_eq_knd_cd.GetSelectCode());
	combo_cost_cd.SetSelectCode(costcd);
	formObj.cost_cd.value=combo_cost_cd.GetText(parseInt(combo_cost_cd.GetSelectIndex()), 2);
	for ( var i=0; i < arrDataSearchDbXml.length; i++) {
		if(i>0)break;
		sheetObjects[i].RenderSheet(0);
		if (i > 0) {
			sheetObjects[i].SetWaitImageVisible(0);
		}
		sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
		sheetObjects[i].RenderSheet(1);
	}
	var prefix="sheet1_";
	var ArrCostDtlDesc=costDtlDesc.split("|");
	for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++)
	{
		if(i==sheetObjects[0].HeaderRows())
		{
			if(sheetObjects[0].GetCellValue(i, "sheet1_rpr_offh_flg")=="Y")
				formObj.rpr_offh_flg.checked=true;
			else
				formObj.rpr_offh_flg.checked=false;
		}
		var idx=sheetObjects[0].GetComboInfo(i, prefix+ "cost_dtl_cd", "SelectedIndex");
		sheetObjects[0].SetCellText(i, prefix+ "cost_dtl_cd" ,ArrCostDtlDesc[idx]);
		sheetObjects[0].SetCellValue(i, "sheet1_sp_name",formObj.pic_eng_nm.value,0);
		var strYard=ComTrimAll(sheetObjects[0].GetCellValue(i, "sheet1_yd_cd")," ");
		var strRprRsltDt=ComTrimAll(sheetObjects[0].GetCellValue(i, "sheet1_rpr_rslt_dt")," ");
		if(strYard!="") sheetObjects[0].SetCellValue(i,"sheet1_yd_cd2",strYard,0);
		if(strRprRsltDt!="")sheetObjects[0].SetCellValue(i,"sheet1_rpr_rslt_dt2",strRprRsltDt,0);
		sheetObjects[0].SetRowStatus(i,"R");
	}
	if(sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(),3)!= "")
	{
		calculateAgmtRateSubSum(sheetObjects[0], formObj,"N");
	}else{
		MnrWaitControl(false);
	}
	nowLoad=0;
}
//Sheet processing-related processes
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBCLEAR:
		MnrWaitControl(true);
		formObj.f_gubuns.value="popup";
		formObj.showDate.value=ComGetNowInfo();
		formObj.pic_eng_nm.value="";
		formObj.eff_dt.value="";
		formObj.exp_dt.value="";
		formObj.curr_cd.value="";
		formObj.cost_cd.value="";
		combo_vndr_seq.SetSelectCode("-1",false);
		combo_vndr_seq.RemoveAll();
		combo_cost_cd.SetSelectCode("-1",false);
		combo_cost_cd.RemoveAll();
		formObj.ord_hdr_rmk.value="";
		combo_vndr_seq_Initialize ();
		combo_eq_knd_cd_Initialize();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		MnrWaitControl(false);
		break;
	case IBSEARCH:      //Retrieving
		if(!validateForm(sheetObj,formObj,sAction))return;
		MnrWaitControl(true);
		nowLoad=1;
		formObj.f_gubuns.value="popup";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		formObj.f_cmd.value=SEARCH;
		var sParam="";
		var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_");
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
 		var sXml=sheetObj.GetSearchData("EES_MNR_0226GS.do", sParam);
		arrDataSearchDbXml=sXml.split("|$$|");
		for ( var i=0; i < arrDataSearchDbXml.length; i++) {
			if(i==0 || i==1)continue;
//			sheetObjects[i].RenderSheet(0);
			if (i > 0) {
				sheetObjects[i].SetWaitImageVisible(0);
			}
			sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
//			sheetObjects[i].RenderSheet(1);
		}
	break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		break;
	}
}
function calculateAgmtRateSubSum(sheetObj, formObj,Gubun)
{
	MnrWaitControl(true);
	var sAgmtOfcCtyCd=formObj.agmt_ofc_cty_cd.value;
	var sAgmtSeq=formObj.agmt_seq.value;
	var sAgmtVerNo=formObj.agmt_ver_no.value;
	var sCostCd=combo_cost_cd.GetSelectCode();
	var sCostDtlCd="";
	var sEqNo="";
	var chkOk=false;
	sheetObjects[1].RemoveAll();
	sheetObj.ColumnSort("sheet1_cost_dtl_cd|sheet1_eq_no", "ASC");
	for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
	{
		if(sheetObj.GetRowStatus(i)=="D") continue;
		var checkEqNo=sheetObj.GetCellValue(i, "sheet1_eq_no");
		if(checkEqNo=="") continue;
 		sheetObj.SetCellFont("FontBold", i, "sheet1_eq_no",0);
		if(chkOk==false)
		{
			sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
			sEqNo=sheetObj.GetCellValue(i, "sheet1_eq_no");
			chkOk=true;
			continue;
		}else{
			if(sCostDtlCd ==sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd")
					&& sEqNo ==sheetObj.GetCellValue(i, "sheet1_eq_no")
			)
			{
				var sSeq=sheetObj.GetCellValue(i, "Seq");
 				sheetObj.SetCellFont("FontBold", sheetObj.FindText("Seq",sSeq)-1, "sheet1_eq_no",1);
 				sheetObj.SetCellFont("FontBold", sheetObj.FindText("Seq",sSeq), "sheet1_eq_no",1);
				sheetObj.ColumnSort("Seq", "ASC"); //Initializing sort
				ComShowCodeMessage("MNR00228");
				sheetObj.SelectCell(sheetObj.FindText("Seq",sSeq), "sheet1_eq_no",true);
				MnrWaitControl(false);
				return false;
			}else
			{
				sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
				sEqNo=sheetObj.GetCellValue(i, "sheet1_eq_no");
			}
		}
	}
	//Initializing sort
	sheetObj.ColumnSort("sheet1_cost_dtl_cd|sheet1_eq_tpsz_cd", "ASC");
	var sCostDtlCd="";
	var sMnrRtTpCd="";
	var sYdCd = "";
	var row=0;
	var chkOk=false;
	for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
	{
		if(sheetObj.GetRowStatus(i)=="D") continue;
		var checkMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
		if(checkMnrRtTpCd=="") continue;
		if(chkOk==false)
		{
			sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
			sMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
			sYdCd = sheetObj.GetCellValue(i, "sheet1_yd_cd2");
			row=sheetObjects[1].DataInsert(-1);
			sheetObjects[1].SetCellValue(row, "sheet2_cost_dtl_cd",sCostDtlCd,0);
			sheetObjects[1].SetCellValue(row, "sheet2_eq_tpsz_cd",sMnrRtTpCd,0);
			sheetObjects[1].SetCellValue(row, "sheet2_yd_cd",sYdCd,0);
			sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",1,0);
			var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
			sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
			chkOk=true;
			continue;
		}else{
			if(sCostDtlCd !=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd"))
			{
				row=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetCellValue(row, "sheet2_cost_dtl_cd",sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd"),0);
				sheetObjects[1].SetCellValue(row, "sheet2_eq_tpsz_cd",sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd"),0);
				sheetObjects[1].SetCellValue(row, "sheet2_yd_cd",sheetObj.GetCellValue(i, "sheet1_yd_cd2"),0);
				sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",1,0);
				var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
				sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
				sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
				sMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
				sYdCd = sheetObj.GetCellValue(i, "sheet1_yd_cd2");
				continue;
			}
			if(sMnrRtTpCd !=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd"))
			{
				row=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetCellValue(row, "sheet2_cost_dtl_cd",sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd"),0);
				sheetObjects[1].SetCellValue(row, "sheet2_eq_tpsz_cd",sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd"),0);
				sheetObjects[1].SetCellValue(row, "sheet2_yd_cd",sheetObj.GetCellValue(i, "sheet1_yd_cd2"),0);
				sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",1,0);
				var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
				sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
				sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
				sMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
				sYdCd = sheetObj.GetCellValue(i, "sheet1_yd_cd2");
				continue;
			}
			if(sYdCd !=sheetObj.GetCellValue(i, "sheet1_yd_cd2"))
			{
				row=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetCellValue(row, "sheet2_cost_dtl_cd",sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd"),0);
				sheetObjects[1].SetCellValue(row, "sheet2_eq_tpsz_cd",sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd"),0);
				sheetObjects[1].SetCellValue(row, "sheet2_yd_cd",sheetObj.GetCellValue(i, "sheet1_yd_cd2"),0);
				sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",1,0);
				var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
				sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
				sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
				sMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
				sYdCd = sheetObj.GetCellValue(i, "sheet1_yd_cd2");
				continue;
			}
			if(sCostDtlCd ==sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd")
					&& sMnrRtTpCd ==sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd")
					&& sYdCd ==sheetObj.GetCellValue(i, "sheet1_yd_cd2"))
			{
				sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",parseInt(sheetObjects[1].GetCellValue(row, "sheet2_rpr_qty")) +1,0);
				var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
				sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
				continue;
			}
		}
	}
	for(var i=sheetObjects[1].HeaderRows();i<sheetObjects[1].LastRow();i++)
	{
		var sCostDtlCd=sheetObjects[1].GetCellValue(i, "sheet2_cost_dtl_cd");
		var sMnrRtTpCd=sheetObjects[1].GetCellValue(i, "sheet2_eq_tpsz_cd");
		var strOrdIndex=sheetObjects[1].GetCellValue(i, "sheet2_ord_index");
		var sYdCd=sheetObjects[1].GetCellValue(i, "sheet2_yd_cd");
		var splOrdIndex=strOrdIndex.split("|");
		var iAgmtRtAmt=0;
		var iRprQty=1;
		var iUnitCost=0;
		var strMnrVrfyTpCd="";
		var strResult="";
		var sXml=MnrAgmtRateInfoSearch(sheetObj,sAgmtOfcCtyCd,sAgmtSeq,sAgmtVerNo,sCostCd,sCostDtlCd,sMnrRtTpCd,sYdCd);
		var retArr=MnrXmlToArray(sXml);
		//0 agmt_ofc_cty_cd|1 agmt_rt_amt|2 agmt_seq|3 pagerows|4 cost_dtl_cd|5 agmt_ver_no|6 ibflag|7 rpr_qty|8 cre_dt|9 upd_usr_id|10 upd_dt|11 mnr_rt_tp_cd|12 cre_usr_id|13 cost_cd|' COLSEPARATOR='☜☞' TOTAL='1'>
		if(retArr != null){
			iAgmtRtAmt=retArr[0][1]; //agmt_rt_amt
			iRprQty=((retArr[0][7]==0)?1:retArr[0][7]); //rpr_qty
			if(iAgmtRtAmt != 0)
				iUnitCost=iAgmtRtAmt/iRprQty;
			strMnrVrfyTpCd="SS";
			strResult="Success";
		}else{
			strMnrVrfyTpCd="UT";
			strResult="Not found Rate due to TP/SZ Error";
		}
		sheetObjects[1].SetCellValue(i, "sheet2_mnr_vrfy_tp_cd",strMnrVrfyTpCd,0);
		sheetObjects[1].SetCellValue(i, "sheet2_result",strResult,0);
		sheetObjects[1].SetCellValue(i, "sheet2_agmt_rt_amt",iUnitCost,0);
		sheetObjects[1].SetCellValue(i, "sheet2_bzc_amt",iUnitCost,0);
		sheetObjects[1].SetCellValue(i, "sheet2_total",parseInt(sheetObjects[1].GetCellValue(i, "sheet2_rpr_qty")) *iUnitCost,0);
		for(var j=0;j<splOrdIndex.length - 1;j++)
		{
			var dtlRow=sheetObjects[0].FindText("Seq",splOrdIndex[j]);
			sheetObjects[0].SetCellValue(dtlRow, "sheet1_mnr_vrfy_tp_cd",strMnrVrfyTpCd,0);
			sheetObjects[0].SetCellValue(dtlRow, "sheet1_rpr_qty",1,0);
			sheetObjects[0].SetCellValue(dtlRow, "sheet1_bzc_amt",iUnitCost,0);
			var iSprPrtUcAmt=sheetObjects[0].GetCellValue(dtlRow, "sheet1_spr_prt_uc_amt");
			if(iSprPrtUcAmt == 0 ||  iSprPrtUcAmt=="")
			{
				sheetObjects[0].SetCellValue(dtlRow, "sheet1_spr_prt_uc_amt",iUnitCost,0);
				sheetObjects[0].SetCellValue(dtlRow, "sheet1_cost_amt",iUnitCost,0);
			}else{
				sheetObjects[1].SetCellValue(i, "sheet2_agmt_rt_amt",iSprPrtUcAmt,0);
				sheetObjects[1].SetCellValue(i, "sheet2_total",parseInt(sheetObjects[1].GetCellValue(i, "sheet2_rpr_qty")) * iSprPrtUcAmt,0);
			}
			sheetObjects[0].SetRowStatus(dtlRow,"R");
		}
	}
	sheetObj.ColumnSort("Seq", "ASC") //Initializing sort
	calReq=1;
	MnrWaitControl(false);
}
/**
* Assigning array of IBTab object
* Array defined at the top of the source
*/
function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}
/**
* Tab Setting default
* Setting tab's item
*/
function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {
		}
		break;
	}
}
/**
* Event handling of changing tab
* Activating tab for selected
*/
function tab1_OnChange(tabObj , nItem)
{
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	//--------------- Important logic --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab=nItem;
}
/**
* Validating process for input form data
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		//At retrieving
		if(sAction==IBSEARCH)
		{
			var sRow=sheetObj.FindStatusRow("I|U|D");
			if(sRow != "")
			{
				if(!ComShowCodeConfirm("MNR00007"))
				{
					return false;
				}
			}
			if( formObj.mnr_ord_seq.value =="" || formObj.mnr_ord_seq.value==null)
			{
				ComShowCodeMessage("MNR00172",'W/O No');
				return false;
			}
			var strMnrOrdSeq=formObj.mnr_ord_seq.value;
			if(strMnrOrdSeq.length > 3)
			{
				strMnrOrdSeq=strMnrOrdSeq.substring(3);
				if(!ComIsNumber(strMnrOrdSeq))
				{
					ComShowCodeMessage("MNR00003");
					return false;
				}
			}else{
				ComShowCodeMessage("MNR00003");
				return false;
			}
		}
		//Load Excel
		else if (sAction==IBLOADEXCEL) {
			//Checking tariff status value
			if(!checkTariffStatus()) {return false;}
		}
	}
	return true;
}
function nvl(str){
	if(str == null) return '0';
	else return str;
}
