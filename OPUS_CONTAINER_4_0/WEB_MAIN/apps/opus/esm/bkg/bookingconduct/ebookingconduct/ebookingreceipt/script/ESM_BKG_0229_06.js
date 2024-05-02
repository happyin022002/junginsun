﻿﻿﻿/*
 * ========================================================= 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0229_06.js
*@FileTitle  : e-Booking & SI Process Detail(TRO/O) 
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/07/07
 * =========================================================
 */

// public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var isCopy="false";
/* Xml Data  */
var xmlData = new Array();
var troType;

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	/** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) 
		{
		case "btn_cancelcopydata":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			isCopy="false";
			top.isCopyAllRequested=false;
			//ComBtnColor("btn_cancelcopydata", "blue");
			//ComBtnColor("btn_datacopytoopus", "#737373");
			
			document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;font-weight:bold;";
			document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;font-weight:normal;";
			break;
		case "btn_datacopytoopus":
			if (isCopy == "false") {
				dataCopy();
			}
			break;  
		case "btn_add":
			addRow(sheetObjects[0], "N", 0);   
			break;
		case "btn_del":
			var nRow=sheetObjects[0].CheckedRows("del_chk");
			if (nRow <= 0) {
				ComShowCodeMessage("BKG00624");
				return false;
			}
			if (!ComShowCodeConfirm("BKG00535")) {
				return false;
			}
			cancelDtl();
			break;
		case "btn_copy":
			copyRow(sheetObjects[0]);
			break;
		case "btn_upload":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btns_popActCust":
			var conti_cd=" ";
			if("US" == parent.frames["t1frame"].document.form.bkg_por_cd.value.substr(0,2) ){
				conti_cd="M";	//hidden : 대륙코드 
			}
			var cnt_cd=parent.frames["t1frame"].document.form.bkg_por_cd.value.substr(0,2);  //국가코드 -> 사용않함
			var dor_loc_cd=""; 
			var act_shpr_cnt_cd=parent.frames["t1frame"].document.form.s_cust_cnt_cd.value; 
			var act_shpr_seq=parent.frames["t1frame"].document.form.s_cust_seq.value;
			var act_shpr_nm=document.form.act_sh.value; 
			var arrAct_shpr_nm=act_shpr_nm.split(" ");
			act_shpr_nm=arrAct_shpr_nm[0];
			var bkg_no=formObject.bkg_no.value;
			comBkgCallPop0905('setActCustCallBack', conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm);
			break;
		} 
	}catch(e) {
		ComShowMessage(e.message);
	}
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	initControl();
}
function initControl(){
	var formObject=document.form;
	//axon_event.addListenerFormat('keypress', 'form_keypress', formObject);
	axon_event.addListenerForm("change", "form_onChange", formObject);
	applyShortcut();
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo
 adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
	case "sheet1": //opus detail
		  with(sheetObj){
			   var HeadTitle="|xter_tro_seq|xter_tro_sub_seq|Del.|Seq|TP/SZ|Q'ty|Door DT/Time|Pick-Up DT/Time|P/Up CY|P/Up CY|Returm CY|Returm CY|tro_seq";
			   var prefix="sheet1_";
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			   var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                {Type:"Text",      Hidden:1, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"xter_tro_seq" },
			                {Type:"Text",      Hidden:1, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"xter_tro_sub_seq" },
			             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tro_sub_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"tro_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"pkup_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pkup_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rtn_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"tro_seq" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"dor_addr" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cntc_phn_no" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cntc_eml" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"dor_zip_id" }
			             ];
			    
			   InitColumns(cols);
			   SetEditable(1);
			   SetSheetHeight(145);
//			   SetColProperty("dor_arr_dt", {Format:"####-##-## ##:##"});
	   }
		break;
	case "sheet2": //esvc detail
		  with(sheetObj){
		   var HeadTitle="|TP/SZ|Q'ty|Door Date & Time|P/Up CY|P/Up CY|P/Up Loc NM|Pick-Up Date & Time|tro_seq|tro_sub_seq";
		   var prefix="sheet2_";
		   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		   var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		   var headers = [ { Text:HeadTitle, Align:"Center"} ];
		   InitHeaders(headers, info);
		   var cols = [ {Type:"Status",		Hidden:1,	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  	Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dor_rqst_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pkup_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  	Width:120,	Align:"Center",	 ColMerge:0,   SaveName:"pkup_loc_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  	Width:130,  Align:"Center",  ColMerge:0,   SaveName:"pkup_dt",   	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, 	Width:40,   Align:"Left",    ColMerge:0,   SaveName:"tro_seq" },
			             {Type:"Text",      Hidden:1, 	Width:40,   Align:"Left",    ColMerge:0,   SaveName:"tro_sub_seq" } ,
			             {Type:"Text",      Hidden:1, 	Width:0,   	Align:"Left",    ColMerge:0,   SaveName:"eur_tro_dor_zip_id" },
			             {Type:"Text",      Hidden:1, 	Width:0,   	Align:"Left",    ColMerge:0,   SaveName:"eur_tro_dor_addr" },
			             {Type:"Text",      Hidden:1, 	Width:0,   	Align:"Left",    ColMerge:0,   SaveName:"eur_tro_cntc_pson_nm" },
			             {Type:"Text",      Hidden:1, 	Width:0,   	Align:"Left",    ColMerge:0,   SaveName:"eur_tro_cntc_phn_no" },
			             {Type:"Text",      Hidden:1, 	Width:0,   	Align:"Left",    ColMerge:0,   SaveName:"eur_tro_cntc_eml" }
			             ];
		    
		   InitColumns(cols);
		   SetEditable(1);
		   SetSheetHeight(145);
//		   SetColProperty("dor_rqst_dt", {Format:"####-##-## ##:##"});
	   }
		break;
	case "sheet3": //opus master
		  with(sheetObj){
			   var HeadTitle="ibflag|xter_tro_seq|(3)tro_seq|self_trk|request_result|request_date|act_sh|cntc_pson|tel|mobile|zip|addr|rmk|cxl_flg|cfm_flg|is_eur|io_bnd_cd|";
			   var prefix="sheet3_";
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                {Type:"Text",      Hidden:0, Width:80,    Align:"Left",    ColMerge:0,   SaveName:"xter_tro_seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tro_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ownr_trk_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"request_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_shpr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_phn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_mphn_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dor_pst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_shpr_addr",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",     Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cxl_flg" },
			             {Type:"Text",     Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cfm_flg" },
			             {Type:"Text",     Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"is_eur" },
			             {Type:"Text",     Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"io_bnd_cd" },
			             {Type:"Text",     Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd" } 
			             ];
			    
			   InitColumns(cols);
			   SetEditable(1);
			   SetSheetHeight(200);
//			   SetVisible(false);
	      }
		break;
	case "sheet4": // esvc master
		  with(sheetObj){
			   var HeadTitle="|(4)tro_seq|self_trk|act_sh|cntc_pson|tel|mobile|zip|addr|rmk||";
			   var prefix="sheet4_";
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tro_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ownr_trk_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_shpr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_pson_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_phn_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntc_mphn_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dor_pst_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_shpr_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"is_eur" },
			             {Type:"Text",      Hidden:1,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"eur_tro_cntr_tpsz_cd" } 
			             ];
			    
			   InitColumns(cols);
			   SetEditable(1);
//			   SetVisible(false);
			   SetSheetHeight(200);
	      }
		break;
	case "sheet5": //opus detail
		  with(sheetObj){
			   var HeadTitle="ibflag|tro_seq|xter_tro_seq|cntr_tpsz_cd|diff_rmk";
			   var prefix="sheet5_";
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			   var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ {Type:"Status", Hidden:1, Width:0,    	Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0, Width:100,    Align:"Left",    ColMerge:0,   SaveName:"tro_seq" },
			             {Type:"Text",      Hidden:0, Width:100,    Align:"Left",    ColMerge:0,   SaveName:"xter_tro_seq" },
			             {Type:"Text",      Hidden:0, Width:100,    Align:"Left",    ColMerge:0,   SaveName:"cntr_tpsz_cd" },
			             {Type:"Text",      Hidden:0, Width:100,    Align:"Left",    ColMerge:0,   SaveName:"diff_rmk" }
			             ];
			    
			   InitColumns(cols);
			   SetEditable(1);
			   SetSheetHeight(145);
//			   SetColProperty("dor_arr_dt", {Format:"####-##-## ##:##"});
	   }
		break;
	case "sheet6": //opus master
		  with(sheetObj){
			   var HeadTitle="ibflag|tro_seq|xter_tro_seq|tro_sub_seq|xter_tro_sub_seq|dor_addr|cntc_pson_nm|cntc_phn_no|cntc_eml|dor_zip_id|dor_arr_dt";
			   var prefix="sheet6_";
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ {Type:"Status",    	Hidden:1, 	Width:0,    	Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                {Type:"Text",      Hidden:0, 	Width:100,    	Align:"Left",    ColMerge:0,   SaveName:"tro_seq" },
			                {Type:"Text",      Hidden:0, Width:100,    Align:"Left",    ColMerge:0,   SaveName:"xter_tro_seq" },
				             {Type:"Text",      Hidden:0,  	Width:100,   	Align:"Center",  ColMerge:0,   SaveName:"tro_sub_seq"},
				             {Type:"Text",      Hidden:0, Width:100,    Align:"Left",    ColMerge:0,   SaveName:"xter_tro_sub_seq" },
				             {Type:"Text",      Hidden:0, 	Width:300,    	Align:"Left",    ColMerge:0,   SaveName:"dor_addr" },
				             {Type:"Text",      Hidden:0, 	Width:200,    	Align:"Left",    ColMerge:0,   SaveName:"cntc_pson_nm" },
				             {Type:"Text",      Hidden:0, 	Width:100,    	Align:"Left",    ColMerge:0,   SaveName:"cntc_phn_no" },
				             {Type:"Text",      Hidden:0, 	Width:200,    	Align:"Left",    ColMerge:0,   SaveName:"cntc_eml" },
				             {Type:"Text",      Hidden:0, 	Width:100,    	Align:"Left",    ColMerge:0,   SaveName:"dor_zip_id" },
				             {Type:"Text",      Hidden:0,  	Width:200,  	Align:"Center",  ColMerge:0,   SaveName:"dor_arr_dt"}
				             ];
			    
			   InitColumns(cols);
			   SetEditable(1);
			   SetSheetHeight(200);
//			   SetVisible(false);
	      }
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction){
	var opener=window.dialogArguments;
	if (!opener) opener=parent;
	switch(sAction) {
	case IBSEARCH_ASYNC01:  
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);	
		break;
	case IBSEARCH: 
		// if(!validateForm(sheetObj,formObj,sAction)) return;
		formObj.opus_seq.value=""; 
		formObj.self_trk.value=""; 
		formObj.act_sh.value=""; 
		formObj.cntc_pson.value=""; 
		formObj.tel.value=""; 
		formObj.mobile.value=""; 
		formObj.dor_pst_no.value=""; 
		formObj.addr.value=""; 
		formObj.rmk.value=""; 
		isCopy="false";
		var sXml = formObj.sXml.value;
		var arrXml = sXml.split("|$$|");
		for(var i=0; i<arrXml.length; i++) { 
			var dataStr = arrXml[i].replace(/:00\.0/g, '');
			/* 구주에서 사용하기 위한 필드 */
			xmlData[i] = dataStr;
			sheetObjects[i].LoadSearchData(dataStr, {Sync:1});
		}
		formObj.opus_seq.selectedIndex = 0;
		formObj.opus_seq.length = 0;
		formObj.xter_seq.length = 0;
		var obj = document.getElementById("opus_seq");
//		formObj.is_eur_flg.value = sheetObjects[2].GetCellValue(1, "is_eur"); // if it is TRO in Europe

		var troType = sheetObjects[0].GetEtcData("TroType");
		
		/* 구주일 경우 multi, stop 기능 사용안함 */
		if(troType == "EUR"){
			formObj.is_eur_flg.value = "Y";
			eurView(sheetObjects, obj, opener);
		}else{
			formObj.is_eur_flg.value = "N";
			notEurView(sheetObjects, obj, formObj, opener);
		}
		
		if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_06');
		
		break;
	case IBSEARCH_ASYNC02:      // Data Copy
		//no support[check again]CLT 		parent.tabObjects[0].TabBackColor(5)="#fff270";
		var isAppend="true";
		var maxTroSeq=0;
		var finalTroSeq=0;
		var troSubSeq=""
		var troSeqEnd=0;
		var totalRows = sheetObjects[0].GetTotalRows();
		
		for(var i=1; i <= sheetObjects[3].GetTotalRows(); i++) {

			isAppend="true";
			// In case of KOR 
			if ( opener.t1frame.form.bkg_pol_cd.value.substring(0,2) == "KR" ) {
				if ( troSeqEnd <= sheetObjects[2].GetTotalRows()) {
					for (var j=eval(troSeqEnd+"+1"); j <= sheetObjects[2].GetTotalRows(); j++) {
						if (sheetObjects[2].GetCellValue(j, "tro_seq") == sheetObjects[3].GetCellValue(i, "tro_seq")) {
							//isAppend = "true";
							//cancel, confirm -> not copy
							if (sheetObjects[2].GetCellValue(j, "cxl_flg") == "Y" || sheetObjects[2].GetCellValue(j, "cfm_flg") == "Y") {
								if ( opener.t1frame.form.bkg_pol_cd.value.substring(0,2) != "KR" ) {
									continue;
								} else if ( sheetObjects[2].GetCellValue(j, "cxl_flg") == "Y") {
									continue;
								}
							}
							
							sheetObjects[2].SetRowStatus(j,"U");
							if(!ComIsNull(sheetObjects[3].GetCellValue(i, "ownr_trk_flg"))){
								sheetObjects[2].SetCellValue(j, "ownr_trk_flg",sheetObjects[3].GetCellValue(i, "ownr_trk_flg"));
							}
							if(!ComIsNull(sheetObjects[3].GetCellValue(i, "act_shpr_nm"))){
								sheetObjects[2].SetCellValue(j, "act_shpr_nm",sheetObjects[3].GetCellValue(i, "act_shpr_nm"));
							}
							if(!ComIsNull(sheetObjects[3].GetCellValue(i, "cntc_pson_nm"))){
								sheetObjects[2].SetCellValue(j, "cntc_pson_nm",sheetObjects[3].GetCellValue(i, "cntc_pson_nm"));
							}
							if(!ComIsNull(sheetObjects[3].GetCellValue(i, "cntc_phn_no"))){
								sheetObjects[2].SetCellValue(j, "cntc_phn_no",sheetObjects[3].GetCellValue(i, "cntc_phn_no"));
							}
							if(!ComIsNull(sheetObjects[3].GetCellValue(i, "cntc_mphn_no"))){
								sheetObjects[2].SetCellValue(j, "cntc_mphn_no",sheetObjects[3].GetCellValue(i, "cntc_mphn_no"));
							}
							if(!ComIsNull(sheetObjects[3].GetCellValue(i, "dor_pst_no"))){
								sheetObjects[2].SetCellValue(j, "dor_pst_no",sheetObjects[3].GetCellValue(i, "dor_pst_no"));
							}
							if(!ComIsNull(sheetObjects[3].GetCellValue(i, "act_shpr_addr"))){
								sheetObjects[2].SetCellValue(j, "act_shpr_addr",sheetObjects[3].GetCellValue(i, "act_shpr_addr"));
							}
							if(!ComIsNull(sheetObjects[3].GetCellValue(i, "diff_rmk"))){
								sheetObjects[2].SetCellValue(j, "diff_rmk",sheetObjects[3].GetCellValue(i, "diff_rmk"));
							}
							if(!ComIsNull(sheetObjects[3].GetCellValue(i, "is_eur"))){
								sheetObjects[2].SetCellValue(j, "is_eur",sheetObjects[3].GetCellValue(i, "is_eur"));
							}
							isAppend="false";
							finalTroSeq=sheetObjects[2].GetCellValue(j, "tro_seq");
							troSeqEnd=sheetObjects[2].GetCellValue(j, "tro_seq")
							break;
						}
					}
				}
				maxTroSeq=1;
				if(sheetObjects[2].RowCount()>0) 
					maxTroSeq=parseInt(sheetObjects[2].GetCellValue(sheetObjects[2].LastRow(), "tro_seq")) + 1;
//					maxTroSeq=parseInt(sheetObjects[2].GetCellValue(sheetObjects[2].LastRow() - 1, "tro_seq")) + 1;
				// 일치하는 것이 하나도 없을 경우에는 OPUS쪽에 Row를 하나 추가 하고 값을 넣음
				if ( isAppend == "true" ) {
					var insRow=sheetObjects[2].DataInsert(-1);
					sheetObjects[2].SetCellValue(insRow, "tro_seq",maxTroSeq);
					sheetObjects[2].SetCellValue(insRow, "ownr_trk_flg",sheetObjects[3].GetCellValue(i, "ownr_trk_flg"));
//					sheetObjects[2].SetCellValue(insRow, "request_result",sheetObjects[3].GetCellValue(i, "request_result"));
					sheetObjects[2].SetCellValue(insRow, "act_shpr_nm",sheetObjects[3].GetCellValue(i, "act_shpr_nm"));
					sheetObjects[2].SetCellValue(insRow, "cntc_pson_nm",sheetObjects[3].GetCellValue(i, "cntc_pson_nm"));
					sheetObjects[2].SetCellValue(insRow, "cntc_phn_no",sheetObjects[3].GetCellValue(i, "cntc_phn_no"));
					sheetObjects[2].SetCellValue(insRow, "cntc_mphn_no",sheetObjects[3].GetCellValue(i, "cntc_mphn_no"));
					sheetObjects[2].SetCellValue(insRow, "dor_pst_no",sheetObjects[3].GetCellValue(i, "dor_pst_no"));
					sheetObjects[2].SetCellValue(insRow, "act_shpr_addr",sheetObjects[3].GetCellValue(i, "act_shpr_addr"));
					sheetObjects[2].SetCellValue(insRow, "diff_rmk",sheetObjects[3].GetCellValue(i, "diff_rmk"));
//					sheetObjects[2].SetCellValue(insRow, "cxl_flg",sheetObjects[3].GetCellValue(i, "cxl_flg"));
//					sheetObjects[2].SetCellValue(insRow, "cfm_flg",sheetObjects[3].GetCellValue(i, "cfm_flg"));
					sheetObjects[2].SetCellValue(insRow, "is_eur",sheetObjects[3].GetCellValue(i, "is_eur"));
//					sheetObjects[2].SetCellValue(insRow, "io_bnd_cd",sheetObjects[3].GetCellValue(i, "io_bnd_cd"));
					sheetObjects[2].SetRowStatus(insRow,"I");
					finalTroSeq=maxTroSeq;
				}
				// From e-Service on the TRO detail based on the number that corresponds to the Insert Row
				for(var k=1; k <= sheetObjects[1].GetTotalRows(); k++) {
					isAppend="true";
					// Copy to Booking Data OPUS
					for (var j=1; j <= totalRows; j++) {
						if (sheetObjects[1].GetCellValue(k, "tro_seq")     == sheetObjects[3].GetCellValue(i, "tro_seq") &&
								sheetObjects[0].GetCellValue(j, "tro_seq")     == finalTroSeq &&
								sheetObjects[0].GetCellValue(j, "cntr_tpsz_cd") == sheetObjects[1].GetCellValue(k, "cntr_tpsz_cd") &&
								sheetObjects[0].GetCellValue(j, "cxl_flg")   != "Y" ) {
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "cntr_tpsz_cd"))){
								sheetObjects[0].SetCellValue(j, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(k, "cntr_tpsz_cd"));
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "cntr_qty"))){
								sheetObjects[0].SetCellValue(j, "tro_qty", parseInt(sheetObjects[1].GetCellValue(k, "cntr_qty")) || 0);
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "dor_rqst_dt"))){
								sheetObjects[0].SetCellValue(j, "dor_arr_dt",sheetObjects[1].GetCellValue(k, "dor_rqst_dt"));
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "pkup_dt"))){
								sheetObjects[0].SetCellValue(j, "pkup_dt",sheetObjects[1].GetCellValue(k, "pkup_dt"));
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "pkup_loc_cd"))){
								sheetObjects[0].SetCellValue(j, "pkup_loc_cd",sheetObjects[1].GetCellValue(k, "pkup_loc_cd"));
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "pkup_yd_cd"))){
								sheetObjects[0].SetCellValue(j, "pkup_yd_cd",sheetObjects[1].GetCellValue(k, "pkup_yd_cd"));
							}							
							sheetObjects[0].SetRowStatus(j,"U");
							isAppend="false";
							break;
						}
					}
					// If no match is found, one side of the OPUS Add a Row, and putting the value
					if ( isAppend == "true" && 
							sheetObjects[1].GetCellValue(k, "tro_seq") == sheetObjects[3].GetCellValue(i, "tro_seq") &&
							sheetObjects[1].GetCellValue(k, "tro_seq") == finalTroSeq ) {
							troSubSeq=0;
							for (var j=1; j <= sheetObjects[0].RowCount(); j++) {
								if ( sheetObjects[0].GetCellValue(j, "tro_seq")     == finalTroSeq ){
									troSubSeq=sheetObjects[0].GetCellValue(j, "tro_sub_seq");
								}
							}
							var insRow=sheetObjects[0].DataInsert(-1);
							sheetObjects[0].SetCellValue(insRow, "tro_seq",finalTroSeq);
							sheetObjects[0].SetCellValue(insRow, "tro_sub_seq",eval(troSubSeq+"+1"));
							sheetObjects[0].SetCellValue(insRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(k, "cntr_tpsz_cd"));
							sheetObjects[0].SetCellValue(insRow, "tro_qty", parseInt(sheetObjects[1].GetCellValue(k, "cntr_qty")) || 0);
							sheetObjects[0].SetCellValue(insRow, "dor_arr_dt",sheetObjects[1].GetCellValue(k, "dor_rqst_dt"));
							sheetObjects[0].SetCellValue(insRow, "pkup_dt",sheetObjects[1].GetCellValue(k, "pkup_dt"));
							sheetObjects[0].SetCellValue(insRow, "pkup_loc_cd",sheetObjects[1].GetCellValue(k, "pkup_loc_cd"));
							sheetObjects[0].SetCellValue(insRow, "pkup_yd_cd",sheetObjects[1].GetCellValue(k, "pkup_yd_cd"));
							sheetObjects[0].SetRowStatus(insRow,"I");
					}
				}

				for (var j=1; j <= totalRows; j++) {
					if ( sheetObjects[0].GetCellValue(j, "tro_seq")     == finalTroSeq &&
							sheetObjects[0].GetRowStatus(j)   != "D" ){
						if (sheetObj.GetCellValue(j, "ibflag") != "I" && sheetObj.GetCellValue(j, "ibflag") != "U"){
							//Except for the added row cancel processing
							sheetObj.SetCellValue(j, "cxl_flg","Y",0);
							sheetObj.SetRangeFontColor(j, 0, j, sheetObj.LastCol(),"#FF0000");
 							sheetObj.SetCellFont("FontStrikethru", j, 0, j, sheetObj.LastCol(),1);
							sheetObj.SetRowEditable(j,0);
						}
					}
				}
				// In case of KOR,  END
			} else { 
				// In case of not KOR
				// Copy to eSvc data OPUS
				for (var j=1; j <= sheetObjects[2].GetTotalRows(); j++) {
					if (sheetObjects[2].GetCellValue(j, "tro_seq") == sheetObjects[3].GetCellValue(i, "tro_seq")) {
						
						isAppend="false";
						//cancel, confirm ->not  copy
						if (sheetObjects[2].GetCellValue(j, "cxl_flg") == "Y" || sheetObjects[2].GetCellValue(j, "cfm_flg") == "Y") {
							continue;
						}
						sheetObjects[2].SetRowStatus(j,"U");
						if(!ComIsNull(sheetObjects[3].GetCellValue(i, "ownr_trk_flg"))){
							sheetObjects[2].SetCellValue(j, "ownr_trk_flg",sheetObjects[3].GetCellValue(i, "ownr_trk_flg"));
						}
						if(!ComIsNull(sheetObjects[3].GetCellValue(i, "act_shpr_nm"))){
							sheetObjects[2].SetCellValue(j, "act_shpr_nm",sheetObjects[3].GetCellValue(i, "act_shpr_nm"));
						}
						if(!ComIsNull(sheetObjects[3].GetCellValue(i, "cntc_pson_nm"))){
							sheetObjects[2].SetCellValue(j, "cntc_pson_nm",sheetObjects[3].GetCellValue(i, "cntc_pson_nm"));
						}
						if(!ComIsNull(sheetObjects[3].GetCellValue(i, "cntc_phn_no"))){
							sheetObjects[2].SetCellValue(j, "cntc_phn_no",sheetObjects[3].GetCellValue(i, "cntc_phn_no"));
						}
						if(!ComIsNull(sheetObjects[3].GetCellValue(i, "cntc_mphn_no"))){
							sheetObjects[2].SetCellValue(j, "cntc_mphn_no",sheetObjects[3].GetCellValue(i, "cntc_mphn_no"));
						}
						if(!ComIsNull(sheetObjects[3].GetCellValue(i, "dor_pst_no"))){
							sheetObjects[2].SetCellValue(j, "dor_pst_no",sheetObjects[3].GetCellValue(i, "dor_pst_no"));
						}
						if(!ComIsNull(sheetObjects[3].GetCellValue(i, "act_shpr_addr"))){
							sheetObjects[2].SetCellValue(j, "act_shpr_addr",sheetObjects[3].GetCellValue(i, "act_shpr_addr"));
						}
						if(!ComIsNull(sheetObjects[3].GetCellValue(i, "diff_rmk"))){
							sheetObjects[2].SetCellValue(j, "diff_rmk",sheetObjects[3].GetCellValue(i, "diff_rmk"));
						}
						if(!ComIsNull(sheetObjects[3].GetCellValue(i, "is_eur"))){
							sheetObjects[2].SetCellValue(j, "is_eur",sheetObjects[3].GetCellValue(i, "is_eur"));
						}
						break;
					}
				}
				maxTroSeq=1;
				if(sheetObjects[2].RowCount()>0){
					maxTroSeq=parseInt(sheetObjects[2].GetCellValue(sheetObjects[2].LastRow(), "tro_seq")) + 1;
				}
				// If no match is found, one side of the OPUS Add a Row, and putting the value
				if ( isAppend == "true" ) {
					var insRow = sheetObjects[2].DataInsert(-1);
					sheetObjects[2].SetCellValue(insRow, "xter_tro_seq",maxTroSeq);
					sheetObjects[2].SetCellValue(insRow, "tro_seq",maxTroSeq);
					sheetObjects[2].SetCellValue(insRow, "ownr_trk_flg",sheetObjects[3].GetCellValue(i, "ownr_trk_flg"));
					sheetObjects[2].SetCellValue(insRow, "act_shpr_nm",sheetObjects[3].GetCellValue(i, "act_shpr_nm"));
					sheetObjects[2].SetCellValue(insRow, "cntc_pson_nm",sheetObjects[3].GetCellValue(i, "cntc_pson_nm"));
					sheetObjects[2].SetCellValue(insRow, "cntc_phn_no",sheetObjects[3].GetCellValue(i, "cntc_phn_no"));
					sheetObjects[2].SetCellValue(insRow, "cntc_mphn_no",sheetObjects[3].GetCellValue(i, "cntc_mphn_no"));
					sheetObjects[2].SetCellValue(insRow, "dor_pst_no",sheetObjects[3].GetCellValue(i, "dor_pst_no"));
					sheetObjects[2].SetCellValue(insRow, "act_shpr_addr",sheetObjects[3].GetCellValue(i, "act_shpr_addr"));
					sheetObjects[2].SetCellValue(insRow, "diff_rmk",sheetObjects[3].GetCellValue(i, "diff_rmk"));
					sheetObjects[2].SetCellValue(insRow, "is_eur",sheetObjects[3].GetCellValue(i, "is_eur"));
					sheetObjects[2].SetRowStatus(insRow,"I");
					finalTroSeq=maxTroSeq;
				}
				isAppend="true";
				//From e-Service on the TRO detail based on the number that corresponds to the Insert Row
				
				for(var k=1; k <= sheetObjects[1].GetTotalRows(); k++) {
					for (var j=1; j <= totalRows; j++) {
						if (sheetObjects[0].GetCellValue(j, "tro_seq") == sheetObjects[1].GetCellValue(k, "tro_seq") && sheetObjects[0].GetCellValue(j, "tro_sub_seq") == sheetObjects[1].GetCellValue(k, "tro_sub_seq")) {
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "cntr_tpsz_cd"))){
								sheetObjects[0].SetCellValue(j, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(k, "cntr_tpsz_cd"));
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "cntr_qty"))){
								sheetObjects[0].SetCellValue(j, "tro_qty", parseInt(sheetObjects[1].GetCellValue(k, "cntr_qty")) || 0);
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "dor_rqst_dt"))){
								sheetObjects[0].SetCellValue(j, "dor_arr_dt",sheetObjects[1].GetCellValue(k, "dor_rqst_dt"));
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "pkup_dt"))){
								sheetObjects[0].SetCellValue(j, "pkup_dt",sheetObjects[1].GetCellValue(k, "pkup_dt"));
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "pkup_loc_cd"))){
								sheetObjects[0].SetCellValue(j, "pkup_loc_cd",sheetObjects[1].GetCellValue(k, "pkup_loc_cd"));
							}
							if(!ComIsNull(sheetObjects[1].GetCellValue(k, "pkup_yd_cd"))){
								sheetObjects[0].SetCellValue(j, "pkup_yd_cd",sheetObjects[1].GetCellValue(k, "pkup_yd_cd"));
							}
							sheetObjects[0].SetRowStatus(j,"U");
							isAppend="false";    
							break;
						}
					}
					// If no match is found, one side of the OPUS Add a Row, and putting the value
					if ( isAppend == "true" && sheetObjects[1].GetCellValue(k, "tro_seq") == finalTroSeq ) {
						var insRow=sheetObjects[0].DataInsert(-1);
						
						sheetObjects[0].SetCellValue(insRow, "xter_tro_seq", sheetObjects[1].GetCellValue(k, "tro_seq"));
						sheetObjects[0].SetCellValue(insRow, "xter_tro_sub_seq", sheetObjects[1].GetCellValue(k, "tro_sub_seq"));
						
						sheetObjects[0].SetCellValue(insRow, "tro_seq",sheetObjects[1].GetCellValue(k, "tro_seq"));
						sheetObjects[0].SetCellValue(insRow, "tro_sub_seq",sheetObjects[1].GetCellValue(k, "tro_sub_seq"));
						sheetObjects[0].SetCellValue(insRow, "cntr_tpsz_cd",sheetObjects[1].GetCellValue(k, "cntr_tpsz_cd"));
						sheetObjects[0].SetCellValue(insRow, "tro_qty", parseInt(sheetObjects[1].GetCellValue(k, "cntr_qty")) || 0);
						sheetObjects[0].SetCellValue(insRow, "dor_arr_dt",sheetObjects[1].GetCellValue(k, "dor_rqst_dt"));
						sheetObjects[0].SetCellValue(insRow, "pkup_dt",sheetObjects[1].GetCellValue(k, "pkup_dt"));
						sheetObjects[0].SetCellValue(insRow, "pkup_loc_cd",sheetObjects[1].GetCellValue(k, "pkup_loc_cd"));
						sheetObjects[0].SetCellValue(insRow, "pkup_yd_cd",sheetObjects[1].GetCellValue(k, "pkup_yd_cd"));
						sheetObjects[0].SetRowStatus(insRow,"I");
					}
				}	

			}
		} 
		// in case of KOR. END
		/* OPUS SEQ arrangement */
		var obj=document.getElementById("opus_seq");
		obj.length=0;
		for (var i=1; i < sheetObjects[2].LastRow() +1; i++) {
			opt=document.createElement("option");
			opt.value=i;
			opt.text=i;
			obj.add(opt);
		}
		if ( opener.t1frame.form.bkg_pol_cd.value.substring(0,2) == "KR" ) formObj.opus_seq.selectedIndex=finalTroSeq-1;
		change_seq("sheet3", obj);
		compareItem();
		isCopy="true";
		break;
	case IBSAVE:      // Save
		return false;
		if (validateForUpload() == false) return false;
		var sParam=getSaveStringForUpload();
		var sXml=sheetObj.GetSaveData("ESM_BKG_0229_06GS.do", sParam);
		if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
			// 01. msg
			ComBkgSaveCompleted(); 
			var param=opener.t6frame.form.param_data.value;
			opener.t6frame.src="ESM_BKG_0229_06.do"+param;
		} else {
			sheetObjects[2].LoadSaveData(sXml);
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	var opener=window.dialogArguments;
    if (!opener) opener=parent;
	switch (sAction) {
		case IBSAVE:	
			if(troType != "EUR"){
				var t1frameSheetObj = parent.frames["t1frame"].sheetObjects[0];
				for(var i=1; i <= sheetObjects[0].RowCount(); i++) {
					var cntrTpszCdCheck = false;
					var cntrTpszCd = sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd");
					if(sheetObjects[0].GetCellValue(i, "ibflag") == 'I'){
						for (var j = 1; j <= t1frameSheetObj.RowCount(); j++) {
							if(cntrTpszCd == t1frameSheetObj.GetCellValue(j, "cntr_tpsz_cd")){
								cntrTpszCdCheck = true;
								break;
							}
						}
						if(!cntrTpszCdCheck){
							$("#opus_seq").val(sheetObjects[0].GetCellValue(i, "tro_seq"));
							$("#opus_seq").change();
							ComShowCodeMessage("BKG00062", cntrTpszCd);
							return false;
						}
					}
				}
			}
			if(opener.t1frame.form.doc_tp_cd.value == "B"){
				//do not validation 
//				//MST VALIDATION
//				var porCntCd = parent.frames["t1frame"].document.form.bkg_por_cd.value.substr(0,2);
//				for(var i=1; i<=sheetObjects[2].RowCount; i++) {
//				    var sheetObj = sheetObjects[2];				
//				    var tro_seq = sheetObj.GetCellValue(i, "tro_seq");
//				    //If it is not cancel. validation  
//				    if (sheetObj.GetCellValue(i, "cxl_flg") == "Y"){
//				        continue; 
//				    }
//	
//				    //Actual Customer Nm : act_shpr_nm
//				    if (ComIsNull(sheetObj.GetCellValue(i, "act_shpr_nm"))) {
//				        ComShowCodeMessage("COM12200", "Troseq:"+tro_seq+", Actual Customer Name");
//				        return false;
//				    }
//	
//				    //Zip : dor_pst_no
//				    if ("US" == porCntCd && ComIsNull(sheetObj.GetCellValue(i, "dor_pst_no"))) {
//				        ComShowCodeMessage("COM12200", "Troseq:"+tro_seq+", Zip");
//				        return false;
//				    }
//				}
//		
//				//DTL VALIDATION
//			   	for (var i=1; i<=sheetObjects[0].RowCount; i++) {
//				    var sheetObj = sheetObjects[0];
//			   		var tro_seq = sheetObj.GetCellValue(i, "tro_seq");
//			   		var tro_sub_seq = sheetObj.GetCellValue(i, "tro_sub_seq");
//	
//		    		if(sheetObj.GetCellValue(i, "cxl_flg") == "Y"){
//		    			continue; 
//		    		}
//	
//			   		// TP/SZ
//		   			if (ComIsNull(sheetObj.GetCellValue(i, "cntr_tpsz_cd"))) {   
//		   		    	ComShowCodeMessage("COM12200", "Troseq:"+tro_seq+", SubSeq:"+tro_sub_seq+", TP/SZ");
//		   				return false;
//		   			}
//	
//		   			// Qty
//		   			if (ComIsNull(sheetObj.GetCellValue(i, "tro_qty"))||sheetObj.GetCellValue(i, "tro_qty")=="0") {
//		   		    	ComShowCodeMessage("COM12200", "Troseq:"+tro_seq+", SubSeq:"+tro_sub_seq+", Qty");
//		   				return false;
//		   			}
//	
//		   		    // Arrival dt
//					if (ComIsNull(sheetObj.GetCellValue(i, "dor_arr_dt"))) {
//						ComShowCodeMessage("COM12138", "Troseq:"+tro_seq+", SubSeq:"+tro_sub_seq+", Door Arrival Date");
//						return false; 
//					}
//			   	}
//	
				//vol validation
//			   	var bkgQtyTpSz = new Array();
//			   	var bkgQtyTpSzVol = new Array();
//			   	var bkgQtySheetObj = parent.frames["t1frame"].sheetObjects[0];
//			    var sheetObj = sheetObjects[0];
//			 
//			   	for (var i=1; i<=sheetObj.RowCount; i++) {
//					if(bkgQtySheetObj.FindText("cntr_tpsz_cd", sheetObj.GetCellValue(i, "cntr_tpsz_cd")) < 0){
//			   			ComShowCodeMessage("COM12133", "["+sheetObj.GetCellValue(i, "cntr_tpsz_cd")+"] Total Qty", "or equal to the BKG Qty", "lesser");
//			   			return false;
//					}
//				}
//			
//				var troTpSzCnt = 0;
//			   	for(var i=1;i<=bkgQtySheetObj.RowCount;i++){
//			   		bkgQtyTpSz   [i] = bkgQtySheetObj.GetCellValue(i, "cntr_tpsz_cd");
//			   		bkgQtyTpSzVol[i] = bkgQtySheetObj.GetCellValue(i, "op_cntr_qty");
//	
//			   		troTpSzCnt = 0;
//			   		for(var j=1;j<=sheetObj.RowCount;j++){			   			
//			   			if(bkgQtyTpSz[i] == sheetObj.GetCellValue(j, "cntr_tpsz_cd")){
//			   				if(sheetObjects[2].GetCellValue(parseInt(sheetObj.GetCellValue(j, "tro_seq")), "cxl_flg")=="Y"){
//			   					continue;
//			   				}
//			   				if(sheetObj.GetCellValue(j, "cxl_flg")!="Y"){
//			   					troTpSzCnt++;
//			   				}
//			   			}		   			
//			   		}
//			   		if(troTpSzCnt>bkgQtyTpSzVol[i]){
//			   			ComShowCodeMessage("COM12133", "["+bkgQtyTpSz[i]+"] Total Qty", "or equal to the BKG Qty", "lesser");
//			   			return false;
//			   		}
//			   	}
			}		   	
		break;
	}
	return true;
}
function validateForUpload() {
	doTroSaveCopy();
	return validateForm(sheetObjects[0], document.form, IBSAVE);
}
function getSaveStringForUpload() {
	  var opener=window.dialogArguments;
      if (!opener) opener=parent;
	var formObj=document.form;
	var sXml=formObj.sXml.value;
	formObj.sXml.value=null;
	formObj.f_cmd.value=MULTI; 
	formObj.f_del_flg.value="N";
	formObj.curr_tro_seq.value=formObj.opus_seq.value;
	
	for (var i=0; i<sheetObjects[2].GetTotalRows(); i++) {
		if(sheetObjects[2].GetCellValue(i+1,"cfm_flg")=="Y"||sheetObjects[2].GetCellValue(i+1,"cxl_flg")=="Y"){
			if ( opener.t1frame.form.bkg_pol_cd.value.substring(0,2) != "KR" ) {
				return "";
			} else {
				sheetObjects[2].SetCellValue(i+1,"cfm_flg","N");
			}
		}
		
		if(sheetObjects[2].GetCellValue(i+1,"cfm_flg")!="Y"){
			sheetObjects[2].SetCellValue(i+1,"cfm_flg","N");			
		}
		
		if(sheetObjects[2].GetCellValue(i+1,"cxl_flg")!="Y"){
			sheetObjects[2].SetCellValue(i+1,"cxl_flg","N");			
		}
	}
	formObj.sXml.value = sXml;
//	var sParam1 = ComSetPrifix(sheetObjects[2].GetSaveString(true), "sheet3_");
//	var sParam2 = ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
//	var sParam3 = ComSetPrifix(sheetObjects[4].GetSaveString(true), "sheet4_");
//	var sParam4 = ComSetPrifix(sheetObjects[5].GetSaveString(true), "sheet5_");
	var sParam = FormQueryString(formObj, false);
//	if(sheetObjects[2].RowCount() > 0){
	if(formObj.is_eur_flg.value == "Y"){
		/* 마지막 수정 data 저장 */
		setOpusMdfSheetObject();
		
		sParam += "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true), "sheet4_");
		sParam += "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true), "sheet5_");
	}else{
		sParam += "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true), "sheet3_"); 
		sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
	}
//	} else {
//		sParam=""
//	}
	return sParam;
}
function dataCopy() {
	if(document.form.is_eur_flg.value == 'Y'){
		xtroCopy();
	}else{
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		//ComBtnColor("btn_cancelcopydata", "#737373");
		//ComBtnColor("btn_datacopytoopus", "blue");	
		document.getElementById("btn_datacopytoopus").style.fontWeight = "bold";
		document.getElementById("btn_datacopytoopus").style.cssText = "color:blue !important;";
		document.getElementById("btn_cancelcopydata").style.fontWeight = "normal";
		document.getElementById("btn_cancelcopydata").style.cssText = "color:#737373 !important;";
	}
}
//Container list Copy
function doTroSaveCopy() {
	var formObj=document.form;
	var curSeq=ComGetObjValue(formObj.opus_seq);
	if (!ComIsNull(curSeq)) {
		if(sheetObjects[2].RowCount()<1){ //1 row is header
			sheetObjects[2].DataInsert(-1);
		}
		sheetObjects[2].SetCellValue(curSeq, "tro_seq",curSeq,0);
		sheetObjects[2].SetCellValue(curSeq, "ownr_trk_flg",formObj.self_trk.checked?"Y":"N",0);
		sheetObjects[2].SetCellValue(curSeq, "act_shpr_nm",formObj.act_sh.value,0);
		sheetObjects[2].SetCellValue(curSeq, "cntc_pson_nm",formObj.cntc_pson.value,0);
		sheetObjects[2].SetCellValue(curSeq, "cntc_phn_no",formObj.tel.value,0);
		sheetObjects[2].SetCellValue(curSeq, "cntc_mphn_no",formObj.mobile.value,0);
		sheetObjects[2].SetCellValue(curSeq, "dor_pst_no",formObj.dor_pst_no.value,0);
		sheetObjects[2].SetCellValue(curSeq, "act_shpr_addr",formObj.addr.value,0);
		sheetObjects[2].SetCellValue(curSeq, "diff_rmk",formObj.rmk.value,0);
		sheetObjects[2].SetCellValue(curSeq, "io_bnd_cd","O",0);
	}
}
//color comparison
function compareItem() {
	var formObj=document.form;
	//click_seq(formObj.opus_seq);
	var curOpusSeq=formObj.opus_seq.value;
	var curEsvcSeq=formObj.xter_seq.value;
	for(var opusSeq=1;opusSeq<sheetObjects[2].LastRow();opusSeq++){
		for(var esvcSeq=1;esvcSeq<sheetObjects[3].LastRow();esvcSeq++){
			if(curEsvcSeq!=esvcSeq) continue;
			if(opusSeq == esvcSeq){
				setDiffCheckColor(sheetObjects[2].GetCellValue(opusSeq, "act_shpr_nm"),   	sheetObjects[3].GetCellValue(esvcSeq, "act_shpr_nm"),   	"act_sh2");
				setDiffCheckColor(sheetObjects[2].GetCellValue(opusSeq, "cntc_pson_nm"),   sheetObjects[3].GetCellValue(esvcSeq, "cntc_pson_nm"),   "cntc_pson2");
				setDiffCheckColor(sheetObjects[2].GetCellValue(opusSeq, "cntc_phn_no"),   	sheetObjects[3].GetCellValue(esvcSeq, "cntc_phn_no"),  		"tel2");
				setDiffCheckColor(sheetObjects[2].GetCellValue(opusSeq, "cntc_mphn_no"),   sheetObjects[3].GetCellValue(esvcSeq, "cntc_mphn_no"),   	"mobile2");
				setDiffCheckColor(sheetObjects[2].GetCellValue(opusSeq, "dor_pst_no"), 	sheetObjects[3].GetCellValue(esvcSeq, "dor_pst_no"),  "dor_pst_no2");
				setDiffCheckColor(sheetObjects[2].GetCellValue(opusSeq, "act_shpr_addr"),  sheetObjects[3].GetCellValue(esvcSeq, "act_shpr_addr"),   		"addr2");
				setDiffCheckColor(sheetObjects[2].GetCellValue(opusSeq, "diff_rmk"),   	sheetObjects[3].GetCellValue(esvcSeq, "diff_rmk"),   		"rmk2");
			}
		}
	}			
}
function form_keypress(){
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	switch(event.srcElement.dataformat){
	case "int":
		// only num
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		// num+".-_"
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "eng":
		// only Eng  -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		// lower Eng-> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		// English to enter uppercase letters, uppercase letters+number -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "uppernum":
		// English to enter uppercase letters, uppercase letters+number -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
    case "tel":
        ComKeyOnlyNumber(event.srcElement, "-"); 
        break;
	case "etc": 
		if(keyValue >= 97 && keyValue <= 122) {
			event.keyCode=keyValue + 65 - 97;
		}
		break;
	default:
		// enter just number
		ComKeyOnlyNumber(event.srcElement);
	}
}
function form_onChange(){
	var srcName=ComGetEvent("name");
	var formObj=document.form;  
//	isCopy = "false";
	if (sheetObjects[2].RowCount()> 0 ){
		if(sheetObjects[2].GetCellValue(formObj.opus_seq.value, "ibflag")=="R"){
			sheetObjects[2].SetRowStatus(formObj.opus_seq.value,"U");
		}
	}
	compareItem();
}
/**
 * AddRow, process logic control
 */
function addRow(sheetObj, NCflag, nCopyRow) {
	//opus dtl  	  
	if (sheetObj.id == "sheet1"){
		var formObj=document.form;  
		var prevMaxTroSubSeq=0;
		for(var i=1;i<=sheetObj.RowCount();i++){
			if(prevMaxTroSubSeq<parseInt(sheetObj.GetCellValue(i, "tro_sub_seq"))){
				prevMaxTroSubSeq=parseInt(sheetObj.GetCellValue(i, "tro_sub_seq"));
			}
		}
		// 01. add new row
		var nNewRow=sheetObj.DataInsert(-1);
		sheetObj.SetCellValue(nNewRow, "tro_seq",formObj.opus_seq.value,0);//  tro_seq
		sheetObj.SetCellValue(nNewRow, "tro_sub_seq",parseInt(prevMaxTroSubSeq) + 1,0);
		sheetObj.SetCellValue(nNewRow, "tro_qty", 1, 0);
		sheetObj.SetCellValue(nNewRow, "cxl_flg","N",0);
		// 03. dtl copy
		if (NCflag == "C") {  
			sheetObj.SetCellValue(nNewRow, "cntr_tpsz_cd",sheetObj.GetCellValue(nCopyRow, "cntr_tpsz_cd"),0);
			sheetObj.SetCellValue(nNewRow, "tro_qty", parseInt(sheetObj.GetCellValue(nCopyRow, "tro_qty")), 0);
			sheetObj.SetCellValue(nNewRow, "dor_arr_dt",sheetObj.GetCellValue(nCopyRow, "dor_arr_dt"), 0);
			sheetObj.SetCellValue(nNewRow, "pkup_dt",sheetObj.GetCellValue(nCopyRow, "pkup_dt"), 0);
			sheetObj.SetCellValue(nNewRow, "pkup_loc_cd",sheetObj.GetCellValue(nCopyRow, "pkup_loc_cd"),0);
			sheetObj.SetCellValue(nNewRow, "pkup_yd_cd",sheetObj.GetCellValue(nCopyRow, "pkup_yd_cd"),0);
			sheetObj.SetCellValue(nNewRow, "rtn_loc_cd",sheetObj.GetCellValue(nCopyRow, "rtn_loc_cd"),0);
			sheetObj.SetCellValue(nNewRow, "rtn_yd_cd",sheetObj.GetCellValue(nCopyRow, "rtn_yd_cd"),0);
			sheetObj.SetCellValue(nNewRow, "cxl_flg","N",0);
		}
	}
}
/**
 * Copy , process logic conrol
 */
function copyRow(sheetObj) {
	sheetObj.ReDraw=false;
	if(sheetObj.GetSelectRow()<1) return;
	if (sheetObj.id == "sheet1"){
		addRow(sheetObj, "C", sheetObj.GetSelectRow());
	}
	sheetObj.ReDraw=true;
}
function change_seq(sheet, obj) {
	var formObj=document.form;
	var prefix="";
	var postfix="";
	var cn=0;
	if (sheet == "sheet3") { //opus
		prefix="sheet3_";
		postfix="";
		cn=2;
		if( sheetObjects[cn].RowCount() > 0){
			eval("formObj.request_result"+postfix).value=sheetObjects[cn].GetCellValue(obj.value, "request_result");
			eval("formObj.request_date"  +postfix).value=sheetObjects[cn].GetCellValue(obj.value, "rqst_dt");
		}
	} else { //esvc
		prefix="sheet4_";
		postfix="2";
		cn=3;
	}
	
	if( sheetObjects[cn].RowCount() > 0){
		eval("formObj.self_trk" +postfix).value=sheetObjects[cn].GetCellValue(obj.value, "ownr_trk_flg");
	}
	if (sheetObjects[cn].GetCellValue(obj.value, "ownr_trk_flg") == "Y") {
		eval("formObj.self_trk"+postfix).checked=true;
	} else {
		eval("formObj.self_trk"+postfix).checked=false;		
	}
	
	if( sheetObjects[cn].RowCount() > 0){
		eval("formObj.act_sh"    +postfix).value=sheetObjects[cn].GetCellValue(obj.value, "act_shpr_nm");
		eval("formObj.cntc_pson" +postfix).value=sheetObjects[cn].GetCellValue(obj.value, "cntc_pson_nm");
		eval("formObj.tel"       +postfix).value=sheetObjects[cn].GetCellValue(obj.value, "cntc_phn_no");
		eval("formObj.mobile"    +postfix).value=sheetObjects[cn].GetCellValue(obj.value, "cntc_mphn_no");
		eval("formObj.dor_pst_no"+postfix).value=sheetObjects[cn].GetCellValue(obj.value, "dor_pst_no");
		eval("formObj.addr"      +postfix).value=sheetObjects[cn].GetCellValue(obj.value, "act_shpr_addr");
		eval("formObj.rmk"       +postfix).value=sheetObjects[cn].GetCellValue(obj.value, "diff_rmk");
	}
	if (sheet == "sheet3") {
		if( sheetObjects[cn].RowCount() > 0){
			eval("formObj.cxl_flg"+postfix).value=sheetObjects[cn].GetCellValue(obj.value, "cxl_flg");
		}
	}
	seq_rowhidden(sheet, sheetObjects[cn].GetCellValue(obj.value, "tro_seq"));
	if (sheet == "sheet3") { //opus
		checkTroStatus(obj.value);
	}
	// ----------------------
	changeMasterColor(formObj);		
	compareItem();
}
// form의 값을 sheet로 복사
function click_seq(obj) {
	if ( sheetObjects[2].GetTotalRows()> 0 ) {
		sheetObjects[2].SetCellValue(obj.value, "request_result",request_result.value);
		sheetObjects[2].SetCellValue(obj.value, "rqst_dt",request_date.value);
		sheetObjects[2].SetCellValue(obj.value, "ownr_trk_flg",self_trk.checked ? "Y": "N");
		sheetObjects[2].SetCellValue(obj.value, "act_shpr_nm",act_sh.value);
		sheetObjects[2].SetCellValue(obj.value, "cntc_pson_nm",cntc_pson.value);
		sheetObjects[2].SetCellValue(obj.value, "cntc_phn_no",tel.value);
		sheetObjects[2].SetCellValue(obj.value, "cntc_mphn_no",mobile.value);
		sheetObjects[2].SetCellValue(obj.value, "dor_pst_no",dor_pst_no.value);
		sheetObjects[2].SetCellValue(obj.value, "act_shpr_addr",addr.value);
		sheetObjects[2].SetCellValue(obj.value, "diff_rmk",rmk.value);
	}
}    
function seq_rowhidden(sheet, seq){
	var sheetObj=null;
	var prefix=null;
	if (sheet == "sheet3"){
		sheetObj=sheetObjects[0];
		prefix="sheet1_";
	} else {
		sheetObj=sheetObjects[1];
		prefix="sheet2_";
	}
	for (var i=sheetObj.HeaderRows(); i<=sheetObj.RowCount()+sheetObj.HeaderRows()-1; i++){
		// cancel tro detail : Change the color of + Strike		
		if ("Y" == sheetObj.GetCellValue(i, "cxl_flg")) {
			sheetObj.SetRangeFontColor(i, 0, i, sheetObj.LastCol(),"#FF0000");
			sheetObj.SetCellFont("FontStrikethru", i, 0, i, sheetObj.LastCol(),1);
			sheetObj.SetRowEditable(i,0);
		}
		// 02.  tro_seq except row : hidden
		if (sheetObj.GetCellValue(i, "tro_seq") == seq){
			sheetObj.SetRowHidden(i,0);
		} else {
			sheetObj.SetRowHidden(i,1);
		}
	}
}
/**
 * cancel_dtl
 */
function cancelDtl() {
	var formObj=document.form; 
	var sheetObj=sheetObjects[0]
	// 1) tro-detail : cancel
	var sRow=sheetObj.FindCheckedRow("del_chk");
	var arrRow=sRow.split("|");
	for (var idx=arrRow.length-1; idx>=0; idx--){ 
		if ("Y" != sheetObj.GetCellValue(arrRow[idx], "cxl_flg")){
			// added row delete
			if (sheetObj.GetCellValue(arrRow[idx], "ibflag") == "I"){
				sheetObj.SetRowStatus(arrRow[idx],"D");
			} else {
				sheetObj.SetCellValue(arrRow[idx], "cxl_flg","Y",0);
				sheetObj.SetRangeFontColor(arrRow[idx], 0, arrRow[idx], sheetObj.LastCol(),"#FF0000");
				sheetObj.SetCellFont("FontStrikethru", arrRow[idx], 0, arrRow[idx], sheetObj.LastCol(),1);
				sheetObj.SetRowEditable(arrRow[idx],0);
			}
		}
	}
}
// cancel/confirm
function checkTroStatus(seq){
	var formObj=document.form;
	var className="input2";
	  var opener=window.dialogArguments;
      if (!opener) opener=parent;
	if(sheetObjects[2].GetCellValue(seq, "cxl_flg")=="Y"){
		formObj.tro_status.value="Cancel";
		formObj.tro_status.style.color="red";
		formObj.request_result.style.color="red";
	} else if(sheetObjects[2].GetCellValue(seq, "cfm_flg")=="Y"){
		formObj.tro_status.value="Confirm";
		formObj.tro_status.style.color="blue";
		if ( opener.t1frame.form.bkg_pol_cd.value.substring(0,2) == "KR" ) {
			className="input";
		}
	} else {
		formObj.tro_status.value="";
		formObj.tro_status.style.color="#606060";
		className="input";
	}
	if(className=="input2"){
		sheetObjects[0].SetEditable(0);
		BkgEnableObject(formObj.self_trk, false);
	} else {
		sheetObjects[0].SetEditable(1);
		BkgEnableObject(formObj.self_trk, true);		
	}
	document.getElementById("act_sh").className=className;
	document.getElementById("cntc_pson").className=className;
	document.getElementById("tel").className=className;
	document.getElementById("mobile").className=className;
	document.getElementById("dor_pst_no").className=className;
	document.getElementById("addr").className=className;
	document.getElementById("rmk").className=className;
}
 /**
  * Tro-Master : Mater modifying disabled
  */    
function changeMasterColor(formObj) {
 	var isEurFlg=formObj.is_eur_flg.value; 	
 	// 01. cxl_flg checkbox 
	if (formObj.cxl_flg.value == "Y") {
		changeEnabled_master(false);
		ComBtnDisable("btn_add");
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_add"); 	
	} else {
		changeEnabled_master(true);  
		if(formObj.is_eur_flg.value=="N"){
			ComBtnEnable("btn_add");
			ComBtnEnable("btn_del");
			ComBtnEnable("btn_add");		
		} else {
			// eur , button disbled handling 
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_del");
			ComBtnDisable("btn_add"); 				
		}
	}
}
// Tro-Master : enable/disable handling
function changeEnabled_master(bFlag) {
 	with(document.form) {
 		ComEnableManyObjects_loc(bFlag, self_trk, act_sh, cntc_pson, tel, mobile, dor_pst_no, addr, rmk);
 	}
}
// enable/disablehandling
function ComEnableManyObjects_loc(bEnable, objs) {
	try {
		var args=arguments;
		if (args.length < 2) return;
		for(var i=1; i<args.length; i++) {
			if (args[i].tagName != undefined) ComEnableObject_loc(args[i], bEnable);
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}
// enable/disablehandling
function ComEnableObject_loc(obj, bEnable){
	try {
		// disabled, readOnly  Set
		switch( obj.type ) {
			case "text" :
				obj.readOnly=!bEnable;
				break;
			default:
				obj.disabled=!bEnable;
		}
		switch( obj.type ) {
			case "text" :
				//input:white background, input1:white background+Required fields, input2:gray background, input2_2:gray background+Required fields
				if (bEnable){
					if (obj.className=="input2_2"){	      
						obj.className="input1";	      
					} else if (obj.className=="input2"){  
						obj.className="input";          
					}
				} else {
					if (obj.className=="input1"){         
						obj.className="input2_2";       
					} else if (obj.className=="input"){   
						obj.className="input2";         
					}
				}
				break;
			case "textarea":
				if (bEnable){
					obj.className="textarea";
				} else {
					obj.className="textarea2";
				}
				break;
			default :
				if (obj.tagName=="IMG" || obj.tagName=="img") {
					if (bEnable){
						obj.style.cursor="hand";
						obj.style.filter="";
					} else {
						obj.style.cursor="default";
						obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
					}
				}
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}
function setActCustCallBack(aryPopupData) {
    var formObj=document.form;     
	var p_act_shpr_nm=nullToBlank(aryPopupData[0][3]); 
//	var p_cnt_cd              = nullToBlank(aryPopupData[0][4]); 
	var p_cntc_pson_nm=nullToBlank(aryPopupData[0][7]); 
	var p_cntc_phn_no=nullToBlank(aryPopupData[0][8]); 
	var p_cntc_mphn_no=nullToBlank(aryPopupData[0][9]); 
	var p_act_shpr_addr=nullToBlank(aryPopupData[0][10]); 
	var p_dor_zip_id=nullToBlank(aryPopupData[0][11]); 
	var p_cntc_fax_no=nullToBlank(aryPopupData[0][12]); 
//	var p_cntc_eml            = nullToBlank(aryPopupData[0][13]); 
//	var p_tro_act_cust_knd_cd = nullToBlank(aryPopupData[0][14]);
//	var p_cust_seq            = nullToBlank(aryPopupData[0][17]); 
	formObj.act_sh.value=p_act_shpr_nm;
	formObj.dor_pst_no.value=p_dor_zip_id;
	formObj.addr.value=p_act_shpr_addr;
	formObj.cntc_pson.value=p_cntc_pson_nm;
	formObj.tel.value=p_cntc_phn_no;
	formObj.mobile.value=p_cntc_mphn_no;
}
/**
 * Change event handling
 */ 
  function sheet1_OnChange(sheetObj, row, col, val){
	  var opener=window.dialogArguments;
      if (!opener) opener=parent;
  	if(sheetObj.ColSaveName(col) == "dor_arr_dt") {
  		if(val.length == 12){
  			opener.t1frame.form.mty_pkup_dt.value=val.substr(0,4) +"-"+ val.substr(4,2) +"-"+ val.substr(6,2);
  		}
  	}
  }
  
  /**
  * Allow All Char but Eng to Upper
  */
function allowAllCharsButEngup() {
   	event.target.value = event.target.value.toUpperCase();
}  

/**
 * 구주일 경우 multi, stop 기능 사용안함
 * @param sheetObjects
 * @param obj
 * @param formObj
 * @param opener
 * @returns
 */
function notEurView(sheetObjects, obj, formObj, opener){
	var notEurOpus = document.getElementById("not_eur_opus");
	notEurOpus.style.display = '';
	
	for (var i=0; i<sheetObjects[2].GetTotalRows(); i++) {
		opt=document.createElement("option");
		opt.value=i+1;
		opt.text=i+1;
		obj.add(opt);
	}
	var obj2=document.getElementById("xter_seq");
	for (var j=0; j<sheetObjects[3].GetTotalRows(); j++){
		opt2=document.createElement("option");
		opt2.value=j+1;
		opt2.text=j+1;
		obj2.add(opt2);
	}
	if ( sheetObjects[0].GetTotalRows()> 0){
		if(sheetObjects[0].GetCellValue(1,"dor_arr_dt").length == 12){
			parent.frames["t1frame"].document.form.mty_pkup_dt.value=sheetObjects[0].GetCellValue(1,"dor_arr_dt").substr(0,4) + "-" +
			sheetObjects[0].GetCellValue(1,"dor_arr_dt").substr(4,2) + "-" +
			sheetObjects[0].GetCellValue(1,"dor_arr_dt").substr(6,2) ;
		}
	}
	if ( sheetObjects[2].GetTotalRows()> 0 ){
		var prefix="sheet3_";
		formObj.tro_seq.value=sheetObjects[2].GetCellValue(1, "tro_seq");
		formObj.self_trk.value=sheetObjects[2].GetCellValue(1, "ownr_trk_flg");
		if (sheetObjects[2].GetCellValue(1, "ownr_trk_flg") == "Y") {
			formObj.self_trk.checked=true;
		} else {
			formObj.self_trk.checked=false;
		}
		formObj.request_result.value=sheetObjects[2].GetCellValue(1, "request_result");
		formObj.request_date.value=sheetObjects[2].GetCellValue(1, "rqst_dt");
		formObj.act_sh.value=sheetObjects[2].GetCellValue(1, "act_shpr_nm");
		formObj.cntc_pson.value=sheetObjects[2].GetCellValue(1, "cntc_pson_nm");
		formObj.tel.value=sheetObjects[2].GetCellValue(1, "cntc_phn_no");
		formObj.mobile.value=sheetObjects[2].GetCellValue(1, "cntc_mphn_no");
		formObj.dor_pst_no.value=sheetObjects[2].GetCellValue(1, "dor_pst_no");
		formObj.addr.value=sheetObjects[2].GetCellValue(1, "act_shpr_addr");
		formObj.rmk.value=sheetObjects[2].GetCellValue(1, "diff_rmk");
		formObj.cxl_flg.value=sheetObjects[2].GetCellValue(1, "cxl_flg");
		var strBoundCd=sheetObjects[2].GetCellValue(1, "io_bnd_cd");
		formObj.io_bnd_cd.value=(strBoundCd == null)? "Y": strBoundCd;
		checkTroStatus(1);
		// the number of TRO>0 - Skip
		formObj.opus_eur_cnt.value=sheetObjects[2].GetTotalRows();
		if (sheetObjects[2].GetTotalRows()> 0) {
			formObj.tro_opus.value="Y"; 
		} else {
			formObj.tro_opus.value="N";
		} 
		for (var i=1; i<sheetObjects[2].LastRow(); i++) {
			sheetObjects[2].SetRowStatus(i,"U");
		}
		seq_rowhidden("sheet3", "1");
		seq_rowhidden("sheet4", "1");
	} 
	if ( sheetObjects[3].GetTotalRows()> 0 ){
		var prefix="sheet4_";
		formObj.self_trk2.value=sheetObjects[3].GetCellValue(1, "ownr_trk_flg");
		if (sheetObjects[3].GetCellValue(1, "ownr_trk_flg") == "Y"){
			formObj.self_trk2.checked=true;
		}
		formObj.act_sh2.value=sheetObjects[3].GetCellValue(1, "act_shpr_nm");
		formObj.cntc_pson2.value=sheetObjects[3].GetCellValue(1, "cntc_pson_nm");
		formObj.tel2.value=sheetObjects[3].GetCellValue(1, "cntc_phn_no");
		formObj.mobile2.value=sheetObjects[3].GetCellValue(1, "cntc_mphn_no");
		formObj.dor_pst_no2.value=sheetObjects[3].GetCellValue(1, "dor_pst_no");
		formObj.addr2.value=sheetObjects[3].GetCellValue(1, "act_shpr_addr");
		formObj.rmk2.value=sheetObjects[3].GetCellValue(1, "diff_rmk");
		// if it is TRO in Europe
		//formObj.is_eur_flg.value = sheetObjects[3].GetCellValue(1, "is_eur");
		
		if (sheetObjects[3].GetTotalRows()> 0) {
			formObj.tro_esvc.value="Y"; 
		} else {
			formObj.tro_esvc.value="N";
		}
	}
	changeMasterColor(formObj);  // cxl_flg checkbox : Master modifying
	checkTroStatus(1);
	//Not / can handle
	if(top.document.form.tabload6.value == "COPY"){
		dataCopy();
	} else {
		compareItem();
	}
	top.document.form.tabload6.value="LOAD";
	if(opener.t1frame.form.doc_tp_cd.value == "S"){
		ComBtnDisable("btn_datacopytoopus");
	}
	/* XTER SEQ  arrangement*/
	var obj=document.getElementById("xter_seq");
	obj.length=0;
	for (var i=1; i < sheetObjects[3].LastRow()+1; i++) {
		opt=document.createElement("option");
		opt.value=i;
		opt.text=i;
		obj.add(opt);

	}
	change_seq("sheet4", obj);
}