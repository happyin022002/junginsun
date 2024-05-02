﻿/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0028.js
*@FileTitle : Report data Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
 Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class VOP_VSK_0028 : business script for VOP_VSK_0028
 */
function VOP_VSK_0028() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
//focus object
var focusObj=null;
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var backValue=null;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;  
		//if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_search":
			if(ComChkLen(formObj.vsl_cd.value, 4) !=2){
				openVslCdHelp(formObj, sheetObject1);
			}else{ // if(ComChkLen(formObj.voy_no.value, 4) !=2){
				openVoyNoHelp(formObj, sheetObject1);
				if(ComChkLen(formObj.voy_no.value, 4)==2){
					formObj.dir_cd.focus();
				}
			}
			break;
		case "btn_Retrieve":
			formObj.conv_clpt_seq.value="";
			if(formObj.vsl_cd.value==""){
				ComShowCodeMessage("VSK00027", "Vessel Code");
				formObj.vsl_cd.focus();
			}else if(formObj.voy_no.value==""){
				ComShowCodeMessage("VSK00027", "Voyage No");
				formObj.voy_no.focus();
			}else if(formObj.dir_cd.value==""){
				ComShowCodeMessage("VSK00027", "Direction Code");
				formObj.dir_cd.focus();
			}else{
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			}
			break;
		case "btn_New":
			doNew();
			formObj.vsl_cd.focus();
			break;
		case "btn_Save":
			if(checkOption(sheetObject1, formObj, MULTI) && ComShowCodeConfirm('COM12147', 'data')){
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
			}
//			if(ComShowCodeConfirm('COM12147', 'data')){
//				if(checkOption(sheetObject1, formObj, IBSAVE)){
//					doActionIBSheet(sheetObject1, formObj, IBSAVE);
//				}	
//			}
			break;
		case "btn_Update":
			if(checkOption(sheetObject1, formObj, MULTI) && ComShowCodeConfirm('COM12154', 'data')){
				doActionIBSheet(sheetObject1, formObj, MULTI);
			}
			break;
		case "btn_Delete":
			if(	checkOption(sheetObject1, formObj, IBDELETE) && ComShowCodeConfirm('COM12165', 'data')){
				doActionIBSheet(sheetObject1, formObj, IBDELETE);
			}
			formObj.vsl_cd.focus();
			break;
		case "btn_Conversion":
			var sUrl="/opuscntr/VOP_VSK_0231.do";
			formObj.conv_clpt_seq.value="";
			ComOpenPopupWithTarget(sUrl, 700, 500, "sheet1_vsl_cd:vsl_cd|sheet1_skd_voy_no:voy_no|sheet1_skd_dir_cd:dir_cd|sheet1_clpt_seq:conv_clpt_seq", "0,1", true);
//			ComOpenPopup(sUrl,  500, 530, "returnConvCltpSeqData", "0,0", true);

			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function convClptSeqChange() {
	var formObj= document.form;
	var sheetObject1=sheetObjects[0];
	
	if(formObj.conv_clpt_seq.value != ""){
		doActionIBSheet(sheetObject1, formObj, IBSEARCH);
	}
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	formObj.vsl_cd.focus();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
      
	      if (location.hostname != "")     
	      var HeadTitle1="|||||||||Port|Proforma SKD|Proforma SKD|Actual SKD|Actual SKD|Delay\nOption|Arrival Delay|Arrival Delay|Arrival Delay|Arrival Delay|Arrival Delay|Arrival Delay|Delay\nOption|Departure Delay|Departure Delay|Departure Delay|Departure Delay|Departure Delay|Departure Delay";
	      var HeadTitle2="|||||||||Port|ETB|ETD|ETB|ETD|Arrival|ARR1|ARR1|ARR1|ARR2|ARR2|ARR2|Departure|DEP1|DEP1|DEP1|DEP2|DEP2|DEP2";
	      var HeadTitle3="|||||||||Port|ETB|ETD|ETB|ETD|Arrival|HR|CD|RMK|HR|CD|RMK|Departure|HR|CD|RMK|HR|CD|RMK";
	      var addHeadTitle1="|vsl_cd|skd_voy_no|sub_trd_dir_cd|clpt_ind_seq|clpt_seq|skd_dir_cd|skd_cng_sts_cd|vskd_rslt_xcld_cd|conti_cd|conti_firstport";
	      var addHeadTitle2="|vsl_cd|skd_voy_no|sub_trd_dir_cd|clpt_ind_seq|clpt_seq|skd_dir_cd|skd_cng_sts_cd|vskd_rslt_xcld_cd|conti_cd|conti_firstport";
	      var addHeadTitle3="|vsl_cd|skd_voy_no|sub_trd_dir_cd|clpt_ind_seq|clpt_seq|skd_dir_cd|skd_cng_sts_cd|vskd_rslt_xcld_cd|conti_cd|conti_firstport";
	      HeadTitle1=HeadTitle1 + addHeadTitle1;
	      HeadTitle2=HeadTitle2 + addHeadTitle2;
	      HeadTitle3=HeadTitle3 + addHeadTitle3;
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      var Rowcnt=0;
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"},
	                  { Text:HeadTitle3, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_inp_yrmon",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arr_rmk1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arr_rmk2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dep_rmk1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dep_rmk2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             
             {Type:"Int",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"init_arr_dlay_hrs",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             {Type:"Int",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"init_dep_dlay_hrs",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             
             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"turn_port_ind_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"pf_etb_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"pf_etd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"act_brth_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"act_dep_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Int",       Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"arr_dlay_opt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             {Type:"Int",       Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"arr_dlay_hrs1",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arr_dlay_rsn_cd1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"btn_arr_rmk1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Int",       Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"arr_dlay_hrs2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"arr_dlay_rsn_cd2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"btn_arr_rmk2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Int",       Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"dep_dlay_opt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             {Type:"Int",       Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dep_dlay_hrs1",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dep_dlay_rsn_cd1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"btn_dep_rmk1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Int",       Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dep_dlay_hrs2",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dep_dlay_rsn_cd2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"btn_dep_rmk2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"clpt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_cng_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vskd_rslt_xcld_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"conti_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"conti_firstport",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
	      InitColumns(cols);
	      SetEditable(0);
	      SetColProperty("pf_etd_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty("pf_etb_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty("act_brth_dt", {Format:"####-##-## ##:##"} );
	      SetColProperty("act_dep_dt", {Format:"####-##-## ##:##"} );
	      SetImageList(0,"img/btns_search.gif"); 
	      resizeSheet();  
      }

	    break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
	case IBSEARCH: // Retrieve
		formObj.f_cmd.value=SEARCH;
		var sParam=FormQueryString(formObj);
		if(formObj.conv_clpt_seq.value!=""){
			var clpt_seq_arr=formObj.conv_clpt_seq.value.split(",");
			for(var i=0; i<clpt_seq_arr.length; i++){
				sParam=sParam + "&clpt_seq=" + clpt_seq_arr[i];
			}
		}
		
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("VOP_VSK_0028GS.do", sParam);
		ComOpenWait(false);
		
		var exist=ComGetEtcData(sXml, "exist");
		var vsl_slan_cd=ComGetEtcData(sXml, "vsl_slan_cd");
		if(vsl_slan_cd){
			formObj.vsl_slan_cd.value=vsl_slan_cd;
		}
		
		formObj.exist.value=exist;
		var dlayRsnCd=ComGetEtcData(sXml, "dlay_rsn_cd");	//Delay Reason Code
		var dlayRsnNm=ComGetEtcData(sXml, "dlay_rsn_nm");	//Delay Reason Name
		formObj.dlay_rsn_cd.value=dlayRsnCd;
		formObj.dlay_rsn_nm.value=dlayRsnNm;
		setEventHandle();
		sheetObj.SetColProperty("arr_dlay_rsn_cd1", {ComboText:"|"+dlayRsnNm, ComboCode:"|"+dlayRsnCd} );
		sheetObj.SetColProperty("arr_dlay_rsn_cd2", {ComboText:"|"+dlayRsnNm, ComboCode:"|"+dlayRsnCd} );
		sheetObj.SetColProperty("dep_dlay_rsn_cd1", {ComboText:"|"+dlayRsnNm, ComboCode:"|"+dlayRsnCd} );
		sheetObj.SetColProperty("dep_dlay_rsn_cd2", {ComboText:"|"+dlayRsnNm, ComboCode:"|"+dlayRsnCd} );
		
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		break;
	case SEARCH02: // Vessel Code Retrieve
		formObj.f_cmd.value=COMMAND16;
		var sParam=FormQueryString(formObj);
		ComOpenWait(true);
		//var sXml = sheetObj.getSearchXml("VSK_GLOGS.do?op_=0219", sParam);
		var sXml=sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
		var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
		ComOpenWait(false);
		if(!vsl_eng_nm){ // undefined
    		ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
    		doNew();
			formObj.tmp_vsl_cd.value="";
			formObj.vsl_cd.value="";
			formObj.vsl_cd.focus();
			return false;
    	}else{
    		formObj.tmp_vsl_cd.value=formObj.vsl_cd.value;
    		formObj.voy_no.focus();
    	}
		return true;
		break;
	case IBSAVE: // save
		formObj.f_cmd.value=ADD;
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			sheetObj.SetCellValue(i, "act_inp_yrmon",formObj.act_year.value + formObj.act_month.value,0);
		}
		var sParam="f_cmd=" + ADD + "&" + ComGetSaveString(sheetObj);
		ComOpenWait(true);
		var sXml=sheetObj.GetSaveData("VOP_VSK_0028GS.do", sParam);
		ComOpenWait(false);
		if(!VskGetErrorXml(sXml)){
			ComShowCodeMessage('COM130102', 'Data');
//			btn_Retrieve.fireEvent("onclick");
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}else{
			sheetObj.LoadSaveData(sXml);
		}
		break;
	case IBDELETE: // delete
		formObj.f_cmd.value=REMOVE;;
		var sParam=FormQueryString(formObj);
		ComOpenWait(true);
		var sXml=sheetObj.GetSaveData("VOP_VSK_0028GS.do", sParam);
		ComOpenWait(false);
		if(!VskGetErrorXml(sXml)){
			ComShowCodeMessage('COM12167', 'Data');
			doNew();
		}else{
			sheetObj.LoadSaveData(sXml);
		}
		break;
	case MULTI:
		formObj.f_cmd.value=MULTI;
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			sheetObj.SetCellValue(i, "act_inp_yrmon",formObj.act_year.value + formObj.act_month.value,0);
		}
		var sParam="f_cmd=" + MULTI + "&" + ComGetSaveString(sheetObj);
		
		ComOpenWait(true);
		var sXml=sheetObj.GetSaveData("VOP_VSK_0028GS.do", sParam);
		ComOpenWait(false);
		if(!VskGetErrorXml(sXml)){
			ComShowCodeMessage('COM130102', 'Data');
//			btn_Retrieve.fireEvent("onclick");
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}else{
			sheetObj.LoadSaveData(sXml);
		}
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage))
		// {
		// return false;
		// }
	}
	return true;
}
function initControl(){
	var formObj=document.form;
//    axon_event.addListenerForm("keypress", "obj_keypress", formObj);
    axon_event.addListenerForm("blur", "obj_beforedeactivate", formObj);
//    axon_event.addListenerForm("focus", "obj_activate", formObj);
    axon_event.addListenerForm("keyup", "obj_keyup", formObj);
//    axon_event.addListenerForm("keypress", "enter_keypress", formObj);
//    axon_event.addListenerForm("keyup", "VskKeyFocus", formObj);
//    axon_event.addListenerForm('keydown', 'obj_keydown', form); 	
    axon_event.addListenerForm ('keydown', 'ComKeyEnter', formObj);
}
/**
 * Handling enter key event
 */
//function enter_keypress(){
//	VskKeyEnter();
//}
function obj_change(){
	var srcName=event.srcElement.name;
	switch(event.srcElement.name){
		case "start_date":
		case "end_date":
			sheetObjects[0].RemoveAll();
			break;
		default:
			break;
	}	
}

/**
 * Handling foucs out event and Checking validation
 */
function obj_beforedeactivate() {
	var formObj=document.form;
	var obj=event.srcElement;
	var val=obj.value;
	switch (event.srcElement.name) {
		case "act_year":
			if(!obj || obj.value=="") return;
			if(!ComIsDate(obj.value + "0101")){
				obj.value="";
				ComShowCodeMessage('VSK00003');
				obj.focus();
				return false;
			}
			break;
		case "act_month":
			if(!obj || obj.value=="") return;
			obj.value=ComLpad(obj.value, 2, "0");
			if(!ComIsMonth(obj.value)){
				obj.value="";
				ComShowCodeMessage('VSK00003');
				obj.focus();
				return false;
			}
			break;
	}
}
function obj_keyup(){
	var formObj=document.form;
	var obj=event.srcElement;
	var val=obj.value;
	switch (event.srcElement.name) {
		case "vsl_cd":
			if(val==""){
				doNew();
				break;
			}
			if(!obj || val=="" || ComChkLen(val, 4)!=2){
				break;
			}
			if(formObj.tmp_vsl_cd.value != obj.value){
				sheetObj=sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH02);
			}
			break;
		case "dir_cd":
			formObj.dir_cd.focus();
			break;
	}
}
/**
 * Checking focus in event and Deleting mask separator
 */
//function obj_activate() {
//	if(event.srcElement.name){
//		focusObj=event.srcElement.name;
//	}else{
//		focusObj="";
//	}
//	switch (event.srcElement.name) {
//		case "start_date":
//		case "end_date":
//			ComClearSeparator(event.srcElement);
//			break;	
//	}
//	if(event.srcElement.options){
//		event.srcElement.focus();
//	}else{
//		event.srcElement.select();
//	}
//}
//function obj_keydown(){
//	var formObj=document.form;
//	var sheetObj=sheetObjects[0];
//	if(focusObj=="vsl_cd"){
//		var ctrl=event.ctrlKey;
//		var code=event.keyCode;
//		if(ctrl && code == 86){ 
//			var clipData=window.clipboardData.getData('Text');
//			if(clipData!=null && clipData.length==9){
//				clipData=clipData.toUpperCase();
//				formObj.vsl_cd.value=clipData.substring(0, 4);
//				//if(isCheckVslCd(sheetObj, formObj)){
//				if(doActionIBSheet(sheetObj, formObj, SEARCH02)){
//					formObj.voy_no.value=clipData.substring(4, 8);
//					formObj.dir_cd.value=clipData.substring(8, 9);
//				}
//			}
//			event.returnValue=false;
//		}
//	}
//}
/**
 * Open Vessel Code Help
 */
function openVslCdHelp(formObj, sheetObj){
	//var sUrl = "/opuscntr/VOP_VSK_0219.do?op_=0219";
	//var sUrl = "/opuscntr/VOP_VSK_0219.do?f_cmd=" + COMMAND16;
	var sUrl="/opuscntr/VOP_VSK_0219.do?vsl_cd=" + formObj.vsl_cd.value;
//	var rVal=ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
	ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
}

function returnVslCdHelp(rtnObjs){
	var formObj=document.form;
		var rtnDatas=rtnObjs;
		
		if(rtnObjs[0][1].length > 0){
			formObj.vsl_cd.value=rtnObjs[0][1]; //vessel code
		}
	}
/**
 * Open Voyage No Help
 */
function openVoyNoHelp(formObj, sheetObj){
	//var sUrl = "/opuscntr/VOP_VSK_0230.do?op_=0230&ctrl_cd=RSLT&vsl_cd=" + formObj.vsl_cd.value;
	//var sUrl = "/opuscntr/VOP_VSK_0230.do?f_cmd=" + COMMAND17 + "&ctrl_cd=RSLT&vsl_cd=" + formObj.vsl_cd.value;
	var sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=RSLT&vsl_cd=" + formObj.vsl_cd.value;
	//ComOpenPopupWithTarget(sUrl, 306, 420, "skd_voy_no:voy_no|sub_trd_dir_cd:dir_cd", "0,0", true);
	
	ComOpenPopup(sUrl, 340, 420, "getVvdData", "0,0", true);
	
}

function getVvdData(obj){
	if(obj){
		var rtnDatas=obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				document.form.voy_no.value=rtnDatas[2];
				document.form.dir_cd.value=rtnDatas[3];
			}
		}
	}
}
function setEventHandle(){
	// exist = 0 : retrieving exist data
	// exist = 1 : creating data using port skd
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var exist=formObj.exist.value;
	if(exist=="0"){
		ComBtnDisable("btn_Save");
		ComBtnEnable("btn_Delete");
		ComBtnDisable("btn_Conversion");
		formObj.act_year.readOnly=true;
		formObj.act_month.readOnly=true;
		ComBtnEnable("btn_Update");
		sheetObj.SetEditable(1);
	}else if(exist=="1"){
		ComBtnEnable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnEnable("btn_Conversion");
		formObj.act_year.readOnly=false;
		formObj.act_month.readOnly=false;
		ComBtnDisable("btn_Update");
		sheetObj.SetEditable(1);
	}else if(exist==""){
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Conversion");
		formObj.act_year.readOnly=true;
		formObj.act_month.readOnly=true;
		ComBtnDisable("btn_Update");
		sheetObj.SetEditable(0);
	}
}
function isEditMode(){
	var exist=document.form.exist.value;
	if(exist=="1"){
		// new creating data is not editable
		return false;
	}else{
		// created report data is editable
		return true;
	}
}
function sheet1_OnSearchEnd(sheetObj, ErrMSg) {
	var formObj=document.form;
	var dlayRsnNm=formObj.dlay_rsn_nm.value;
	var dlayRsnCd=formObj.dlay_rsn_cd.value;
	var firstRow=0;
	var endRow=0;
	with(sheetObj){
		if(RowCount()> 0){
			//RenderSheet(0);
			if(!isEditMode()){
				calRsltCstSkdDlayHr(formObj, sheetObj);
			}
			comparePfActSkd(sheetObj);
//			var act_inp_yrmon = CellValue(LastRow, "act_inp_yrmon");
//			formObj.act_year.value = act_inp_yrmon.substring(0, 4);
//			formObj.act_month.value = act_inp_yrmon.substring(4, 6);
			firstRow=HeaderRows();
			endRow=HeaderRows()+ RowCount()- 1;
			var act_inp_yrmon="";
			for(var Row=endRow; Row>=firstRow; Row--){
				if(GetCellValue(Row, "act_dep_dt")!=""){
				act_inp_yrmon=GetCellValue(Row, "act_inp_yrmon");
					break;
				}else if(GetCellValue(Row, "act_brth_dt")!=""){
				act_inp_yrmon=GetCellValue(Row, "act_inp_yrmon");
					break;
				}
			}
			if(act_inp_yrmon!=""){
				formObj.act_year.value=act_inp_yrmon.substring(0, 4);
				formObj.act_month.value=act_inp_yrmon.substring(4, 6);
			}
			for(var i=firstRow; i<=endRow; i++){
				// in case of SKIP Port, deactivate
				if("S"==GetCellValue(i, "skd_cng_sts_cd")){
					SetCellBackColor(i, "act_brth_dt","#F0F0F0");
					SetCellBackColor(i, "act_dep_dt","#F0F0F0");
				}
				if(i==firstRow){
					if("S"==GetCellValue(i, "skd_cng_sts_cd")){
						SetCellValue(i, "vskd_rslt_xcld_cd","S",0);
					}else{
						SetCellValue(i, "vskd_rslt_xcld_cd","A",0);
					}
				}else if(i==endRow){
					SetCellValue(i, "vskd_rslt_xcld_cd","D",0);
				}else{
					SetCellValue(i, "vskd_rslt_xcld_cd","N",0);
				}
			}
			// Deactivating first Arrival Delay and last Departure Delay
			InitCellProperty(firstRow, "arr_dlay_opt",{ Type:"Null",Align:"Null",Format:"dfNone"} );
			InitCellProperty(firstRow, "arr_dlay_hrs1",{ Type:"Null",Align:"Null",Format:"dfNone"} );
			InitCellProperty(firstRow, "arr_dlay_hrs2",{ Type:"Null",Align:"Null",Format:"dfNone"} );
			InitCellProperty(LastRow(), "dep_dlay_opt",{ Type:"Null",Align:"Null",Format:"dfNone"} );
			InitCellProperty(LastRow(), "dep_dlay_hrs1",{ Type:"Null",Align:"Null",Format:"dfNone"} );
			InitCellProperty(LastRow(), "dep_dlay_hrs2",{ Type:"Null",Align:"Null",Format:"dfNone"} );
			SetCellEditable(firstRow, "arr_dlay_opt",0);
			SetCellEditable(firstRow, "arr_dlay_hrs1",0);
			SetCellEditable(firstRow, "arr_dlay_rsn_cd1",0);
			SetCellEditable(firstRow, "btn_arr_rmk1",0);
			SetCellEditable(firstRow, "arr_dlay_hrs2",0);
			SetCellEditable(firstRow, "arr_dlay_rsn_cd2",0);
			SetCellEditable(firstRow, "btn_arr_rmk2",0);
			SetCellEditable(endRow, "dep_dlay_opt",0);
			SetCellEditable(endRow, "dep_dlay_hrs1",0);
			SetCellEditable(endRow, "dep_dlay_rsn_cd1",0);
			SetCellEditable(endRow, "btn_dep_rmk1",0);
			SetCellEditable(endRow, "dep_dlay_hrs2",0);
			SetCellEditable(endRow, "dep_dlay_rsn_cd2",0);
			SetCellEditable(endRow, "btn_dep_rmk2",0);
			SetCellBackColor(firstRow, "arr_dlay_opt","#F0F0F0");
			SetCellBackColor(firstRow, "arr_dlay_hrs1","#F0F0F0");
			SetCellBackColor(firstRow, "arr_dlay_rsn_cd1","#F0F0F0");
			SetCellBackColor(firstRow, "btn_arr_rmk1","#F0F0F0");
			SetCellBackColor(firstRow, "arr_dlay_hrs2","#F0F0F0");
			SetCellBackColor(firstRow, "arr_dlay_rsn_cd2","#F0F0F0");
			SetCellBackColor(firstRow, "btn_arr_rmk2","#F0F0F0");
			SetCellBackColor(endRow, "dep_dlay_opt","#F0F0F0");
			SetCellBackColor(endRow, "dep_dlay_hrs1","#F0F0F0");
			SetCellBackColor(endRow, "dep_dlay_rsn_cd1","#F0F0F0");
			SetCellBackColor(endRow, "btn_dep_rmk1","#F0F0F0");
			SetCellBackColor(endRow, "dep_dlay_hrs2","#F0F0F0");
			SetCellBackColor(endRow, "dep_dlay_rsn_cd2","#F0F0F0");
			SetCellBackColor(endRow, "btn_dep_rmk2","#F0F0F0");
			// arr_dlay_hrs1, dep_dlay_hrs1 are not editable
			SetColFontColor(SaveNameCol("arr_dlay_hrs1"),"#969696");
			SetColFontColor(SaveNameCol("dep_dlay_hrs1"),"#969696");
			controlDelayData(sheetObj);
			//RenderSheet(1);
		}
	}
}
function calRsltCstSkdDlayHr(formObj, sheetObj){
	var start=sheetObj.HeaderRows();
	var end=sheetObj.HeaderRows()+ sheetObj.RowCount();
	// Checking first port of each Conti Code except Canal
	checkContiFirstPort(sheetObj);
	var arrDlayHrs1;
	var depDlayHrs1;
	for(var Row=start; Row<end; Row++){
		// in case of first Port
		if(Row==start){
			arrDlayHrs1="0";
			depDlayHrs1=getDepartureDelay(sheetObj, Row);
			if(sheetObj.GetCellValue(Row, "pf_etd_dt").length > 10 && sheetObj.GetCellValue(Row, "act_dep_dt").length > 10 ){
				// Regarding On-Time when P/F and Actual are same
				if(sheetObj.GetCellValue(Row, "pf_etd_dt")==sheetObj.GetCellValue(Row, "act_dep_dt")){
					depDlayHrs1="0";
				}
			}
		}else{ // in case of no first port
			arrDlayHrs1=getArrivalDelay(sheetObj, Row);
			depDlayHrs1=getDepartureDelay(sheetObj, Row);
			// Handling Delay time as CONTI Code except EGSCA,PAPCA
			if(sheetObj.GetCellValue(Row, "conti_firstport")=="Y"){
				if(ComParseInt(arrDlayHrs1)<=2){
					arrDlayHrs1="0";
				}
				if(ComParseInt(depDlayHrs1)<=2){
					depDlayHrs1="0";
				}
			}else{
				if(sheetObj.GetCellValue(Row, "pf_etb_dt").length > 10 && sheetObj.GetCellValue(Row, "act_brth_dt").length > 10 ){
					if(sheetObj.GetCellValue(Row, "pf_etb_dt")==sheetObj.GetCellValue(Row, "act_brth_dt")){
						arrDlayHrs1="0";
					}
				}
				if(sheetObj.GetCellValue(Row, "pf_etd_dt").length > 10 && sheetObj.GetCellValue(Row, "act_dep_dt").length > 10 ){
					if(sheetObj.GetCellValue(Row, "pf_etd_dt")==sheetObj.GetCellValue(Row, "act_dep_dt")){
						depDlayHrs1="0";
					}
				}
			}
			if(Row==end-1){
				depDlayHrs1="0";
			}
		}
		with(sheetObj){
			SetCellValue(Row, "arr_dlay_opt","0",0);
			SetCellValue(Row, "dep_dlay_opt","0",0);
			SetCellValue(Row, "arr_dlay_hrs1",arrDlayHrs1,0);
			SetCellValue(Row, "dep_dlay_hrs1",depDlayHrs1,0);
			SetCellValue(Row, "arr_dlay_hrs2","0",0);
			SetCellValue(Row, "dep_dlay_hrs2","0",0);
			SetCellValue(Row, "init_arr_dlay_hrs",GetCellValue(Row, "arr_dlay_hrs1"),0);
			SetCellValue(Row, "init_dep_dlay_hrs",GetCellValue(Row, "dep_dlay_hrs1"),0);
		}
	}
}
function checkContiFirstPort(sheetObj){
	var start=sheetObj.HeaderRows();
	var end=sheetObj.HeaderRows()+ sheetObj.RowCount();
	with(sheetObj){
		for(var Row=start; Row<end; Row++){
			if(Row==start){
				continue;
			}
			if(	"EGSCA"!=GetCellValue(Row, "vps_port_cd") &&
					"PAPCA"!=GetCellValue(Row, "vps_port_cd") &&
					GetCellValue(Row-1, "conti_cd")!=GetCellValue(Row, "conti_cd")){
					SetCellValue(Row, "conti_firstport","Y",0);
			}
		}
	}
}
function getArrivalDelay(sheetObj, Row){
	var pfEtb=sheetObj.GetCellValue(Row, "pf_etb_dt");
	var pfEtd=sheetObj.GetCellValue(Row-1, "pf_etd_dt");
	var actEtb=sheetObj.GetCellValue(Row, "act_brth_dt");
	var actEtd=sheetObj.GetCellValue(Row-1, "act_dep_dt");
	/*
	 ===============
	 Calculating time difference
	 ===============
	 vo1 : pre port
	 vo2 : post port
	 P/F Arrival time=P/F ETB(vo2) - P/F ETD(vo1)
	 Actual Arrival time=ACT Berth Date(vo2) - ACT Departure Date(vo1)
	 >>> time difference=Actual Arrival time - P/F Arrival timne
	if time difference is minus, setting 0
	 */
	// if some data is null, setting time difference is 0
	if( pfEtd==null || pfEtd.length==0 
			|| pfEtb == null || pfEtb.length==0 
			|| actEtd == null || actEtd.length==0
			|| actEtb == null || actEtb.length==0
			){
		return "0";
	}
	var pfEtbDt=getDate(pfEtb);
	var pfEtdDt=getDate(pfEtd);
	var actEtbDt=getDate(actEtb);
	var actEtdDt=getDate(actEtd);
	// convert into Hour
	var pfArrTimeByHour=Math.round( (pfEtbDt - pfEtdDt) / (1000 * 60 * 60.0) );
	// convert into Hour
	var actArrTimeByHour=Math.round( (actEtbDt - actEtdDt) / (1000 * 60 * 60.0) );
	var delay=actArrTimeByHour - pfArrTimeByHour <= 0 ? "0" : actArrTimeByHour - pfArrTimeByHour;
	return delay;
}
function getDepartureDelay(sheetObj, Row){
	var pfEtb=sheetObj.GetCellValue(Row, "pf_etb_dt");
	var pfEtd=sheetObj.GetCellValue(Row, "pf_etd_dt");
	var actEtb=sheetObj.GetCellValue(Row, "act_brth_dt");
	var actEtd=sheetObj.GetCellValue(Row, "act_dep_dt");
	/*
	 ===============
	 Calculating time difference
	 ===============
	 P/F Arrival time=P/F ETD - P/F ETB
	 Actual Arrival time=ACT Departure Date - ACT Berth Date 
	 >>> time difference=Actual Arrival time - P/F Arrival time
	if time difference is minus, setting 0
	 */
	// if some data is null, setting time difference is 0
	if( pfEtd==null || pfEtd.length==0 
			|| pfEtb == null || pfEtb.length==0 
			|| actEtd == null || actEtd.length==0
			|| actEtb == null || actEtb.length==0
			){
		return "0";
	}
	var pfEtbDt=getDate(pfEtb);
	var pfEtdDt=getDate(pfEtd);
	var actEtbDt=getDate(actEtb);
	var actEtdDt=getDate(actEtd);
	// convert into Hour
	var pfArrTimeByHour=Math.round( (pfEtdDt - pfEtbDt) / (1000 * 60 * 60.0) );
	// convert into Hour
	var actArrTimeByHour=Math.round( (actEtdDt - actEtbDt) / (1000 * 60 * 60.0) );
	var delay=actArrTimeByHour - pfArrTimeByHour <= 0 ? "0" : actArrTimeByHour - pfArrTimeByHour;
	return delay;
}
function getDate(str){
	var date=null;
	var year=str.substring(0, 4);
	var month=ComParseInt(str.substring(4, 6)) - 1;
	var day=str.substring(6, 8);
	var hour=str.substring(8, 10);
	var minute=str.substring(10, 12);
	date=new Date(year, month, day, hour, minute);
	return date;
}
/**
 * Comparing ETB/ETD of p/f and actual, then Showing delayed proforma data
 */
function comparePfActSkd(sheetObj){
	var start=sheetObj.HeaderRows();
	var end=sheetObj.HeaderRows()+ sheetObj.RowCount();
	for(var Row=start; Row<end; Row++){
		if(compareDate(sheetObj.GetCellValue(Row, "pf_etb_dt"), sheetObj.GetCellValue(Row, "act_brth_dt"))==1){
			sheetObj.SetCellBackColor(Row, "pf_etb_dt","#00FFFF");
		}else{
			sheetObj.SetCellBackColor(Row, "pf_etb_dt","#FFFFFF");
		}
		if(compareDate(sheetObj.GetCellValue(Row, "pf_etd_dt"), sheetObj.GetCellValue(Row, "act_dep_dt"))==1){
			sheetObj.SetCellBackColor(Row, "pf_etd_dt","#00FFFF");
		}else{
			sheetObj.SetCellBackColor(Row, "pf_etd_dt","#FFFFFF");
		}
	}
}
/**
 * Comparing two dates
 * srcDate1 == srcDate2 => 0
 * srcDate1 > srcDate2 => -1
 * srcDate1 < srcDate2 => 1 
 */
function compareDate(srcDate1, srcDate2){
	var date1=getDate(srcDate1);
	var date2=getDate(srcDate2);
	if(date2-date1>0){
		return 1;
	}else if(date2-date1<0){
		return -1;
	}else{
		return 0;
	}
}

function returnArrRmk1(rtnObjs){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	
	if(rtnObjs){
		var rtnDatas=rtnObjs;
		if(rtnDatas){
			if(rtnDatas.length > 0){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "arr_rmk1", rtnDatas,0);
			}
		}
	}
}

function returnArrRmk2(rtnObjs){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	
	if(rtnObjs){
		var rtnDatas=rtnObjs;
		if(rtnDatas){
			if(rtnDatas.length > 0){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "arr_rmk2", rtnDatas,0);
			}
		}
	}
}

function returnDepRmk1(rtnObjs){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	
	if(rtnObjs){
		var rtnDatas=rtnObjs;
		if(rtnDatas){
			if(rtnDatas.length > 0){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "dep_rmk1", rtnDatas,0);
			}
		}
	}
}

function returnDepRmk2(rtnObjs){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	
	if(rtnObjs){
		var rtnDatas=rtnObjs;
		if(rtnDatas){
			if(rtnDatas.length > 0){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "dep_rmk2", rtnDatas,0);
			}
		}
	}
}

function sheet1_OnClick(sheetObj, Row, Col){
	var formObj=document.form;
	var colSaveName=sheetObj.ColSaveName(Col);
	switch(colSaveName){
		case "btn_arr_rmk1":
			//alert(sheetObj.GetCellValue(Row, Col)  );
			if(sheetObj.GetCellValue(Row, Col) != "" ){
			var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + escape(sheetObj.GetCellValue(Row, "arr_rmk1"));
//				if(!isEditMode()){
//					sUrl = sUrl + "&readonly=true";
//				}
//				var rVal=ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				ComOpenPopup(sUrl, 342, 350, "returnArrRmk1", "0,0", true);

//				if(rVal || rVal==''){
//					sheetObj.SetCellValue(Row, "arr_rmk1", rVal,0);
//				}
			}		
			break;
		case "btn_arr_rmk2":
			if(sheetObj.GetCellValue(Row, Col) != ""){
			var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + escape(sheetObj.GetCellValue(Row, "arr_rmk2"));
//				if(!isEditMode()){
//					sUrl = sUrl + "&readonly=true";
//				}
//				var rVal=ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				ComOpenPopup(sUrl, 342, 350, "returnArrRmk2", "0,0", true);
//				if(rVal || rVal==''){
//					sheetObj.SetCellValue(Row, "arr_rmk2",rVal,0);
//				}
			}	
			break;
		case "btn_dep_rmk1":
			if(sheetObj.GetCellValue(Row, Col) != ""){
			var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + escape(sheetObj.GetCellValue(Row, "dep_rmk1"));
//				if(!isEditMode()){
//					sUrl = sUrl + "&readonly=true";
//				}
//				var rVal=ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				ComOpenPopup(sUrl, 342, 350, "returnDepRmk1", "0,0", true);
				
//				if(rVal || rVal==''){
//					sheetObj.SetCellValue(Row, "dep_rmk1",rVal,0);
//				}
			}		
			break;
		case "btn_dep_rmk2":
			if(sheetObj.GetCellValue(Row, Col) !=""){
			var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + escape(sheetObj.GetCellValue(Row, "dep_rmk2"));
//				if(!isEditMode()){
//					sUrl = sUrl + "&readonly=true";
//				}
//				var rVal=ComOpenPopupWithTarget(sUrl, 342, 350, "", "0,0", true);
				ComOpenPopup(sUrl, 342, 350, "returnDepRmk2", "0,0", true);
//				if(rVal || rVal==''){
//					sheetObj.SetCellValue(Row, "dep_rmk2",rVal,0);
//				}
			}	
			break;
	} 
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj=document.form;
	var colSaveName=sheetObj.ColSaveName(Col);
	switch(colSaveName){
		case "pf_etb_dt":
		case "pf_etd_dt":
			calRsltCstSkdDlayHr(formObj, sheetObj);
			comparePfActSkd(sheetObj);
			controlDelayData(sheetObj);
			break;
	}
}
function sheet1_OnBeforeEdit(sheetObj, Row, Col){
	backValue=sheetObj.GetCellValue(Row, Col);
}
function sheet1_OnAfterEdit(sheetObj, Row, Col){
	var colSaveName=sheetObj.ColSaveName(Col);
	var iRow= Number( Row );
	
	switch(colSaveName){
		case "arr_dlay_opt":
			// not handling first row
			if(sheetObj.HeaderRows()== iRow){
				return;
			}
			
			var initValue = 0;
			var oldValue = 0;
			var newValue = 0;
			
			initValue = parseInt(sheetObj.GetCellValue(iRow, "init_arr_dlay_hrs"));
			if(backValue==""){
				oldValue=0;
			}else{
				oldValue=parseInt(backValue);
			}
			
			newValue = parseInt(sheetObj.GetCellValue(iRow, Col));
			
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.SetCellValue(Row, Col,oldValue,0);
				return;
			}
			
			var realValue = newValue - oldValue;
			
			// Control as permited time in SKD
			if(newValue > initValue){
				ComShowCodeMessage("VSK00073");
				sheetObj.SetCellValue(Row, Col,oldValue,0);
				return;
			}else{
				var hrs1= parseInt(sheetObj.GetCellValue(iRow, "arr_dlay_hrs1"));
				var hrs2= parseInt(sheetObj.GetCellValue(iRow, "arr_dlay_hrs2"));
				if(realValue<0){
					sheetObj.SetCellValue(iRow, "arr_dlay_hrs1",hrs1 - realValue,0);
				}else if(realValue<=hrs2){
					sheetObj.SetCellValue(iRow, "arr_dlay_hrs2",hrs2 - realValue,0);
					//sheetObj.CellValue2(Row, "arr_dlay_opt") = newValue;
				}else{
					sheetObj.SetCellValue(iRow, "arr_dlay_hrs1",hrs1 - (realValue - hrs2),0);
					sheetObj.SetCellValue(iRow, "arr_dlay_hrs2",0,0);
				}
			}
			controlDelayData(sheetObj);
			sheetObj.SelectCell(iRow, Col, false);
			break;
		case "arr_dlay_hrs2":
			// not handling first row
			if(sheetObj.HeaderRows()== iRow){
				return;
			}
			var oldValue;
			var newValue;
			if(backValue==""){
				oldValue=0;
			}else{
				oldValue=parseInt(backValue);
			}
			newValue=parseInt(sheetObj.GetCellValue(iRow, Col));
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.SetCellValue(iRow, Col,oldValue,0);
				return;
			}
			var realValue=newValue - oldValue;
			var hrs1= parseInt(sheetObj.GetCellValue(iRow, "arr_dlay_hrs1"));
			var hrs2= parseInt(sheetObj.GetCellValue(iRow, "arr_dlay_hrs2"));
			if(realValue<=hrs1){
				sheetObj.SetCellValue(iRow, "arr_dlay_hrs1",hrs1 - realValue,0);
			}else{
				ComShowCodeMessage("VSK00073");
				sheetObj.SetCellValue(iRow, "arr_dlay_hrs2",oldValue,0);
				return;
			}
			controlDelayData(sheetObj);
			sheetObj.SelectCell(iRow, Col, false);
			break;
		case "dep_dlay_opt":
			// not handling last row
			if(sheetObj.LastRow()==iRow){
				return;
			}
			var initValue;
			var oldValue;
			var newValue;
			initValue=parseInt(sheetObj.GetCellValue(iRow, "init_dep_dlay_hrs"));
			if(backValue==""){
				oldValue=0;
			}else{
				oldValue=parseInt(backValue);
			}
			newValue=parseInt(sheetObj.GetCellValue(iRow, Col));
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.SetCellValue(iRow, Col,oldValue,0);
				return;
			}
			var realValue=newValue - oldValue;
			// Control as permited time in SKD
			if(newValue > initValue){
				ComShowCodeMessage("VSK00073");
				sheetObj.SetCellValue(iRow, Col,oldValue,0);
				return;
			}else{
				var hrs1=parseInt(sheetObj.GetCellValue(iRow, "dep_dlay_hrs1"));
				var hrs2=parseInt(sheetObj.GetCellValue(iRow, "dep_dlay_hrs2"));
				if(realValue<0){
					sheetObj.SetCellValue(iRow, "dep_dlay_hrs1",hrs1 - realValue,0);
				}else if(realValue<=hrs2){
					sheetObj.SetCellValue(iRow, "dep_dlay_hrs2",hrs2 - realValue,0);
					//sheetObj.CellValue2(iRow, "arr_dlay_opt") = newValue;
				}else{
					sheetObj.SetCellValue(iRow, "dep_dlay_hrs1",hrs1 - (realValue - hrs2),0);
					sheetObj.SetCellValue(iRow, "dep_dlay_hrs2",0,0);
				}
			}
			controlDelayData(sheetObj);
			sheetObj.SelectCell(iRow, Col, false);
			break;
		case "dep_dlay_hrs2":
			// not handling last iRow
			if(sheetObj.LastRow()==iRow){
				return;
			}
			var oldValue;
			var newValue;
			if(backValue==""){
				oldValue=0;
			}else{
				oldValue=parseInt(backValue);
			}
			newValue=parseInt(sheetObj.GetCellValue(iRow, Col));
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.SetCellValue(iRow, Col,oldValue,0);
				return;
			}
			var realValue=newValue - oldValue;
			var hrs1=parseInt(sheetObj.GetCellValue(iRow, "dep_dlay_hrs1"));
			var hrs2=parseInt(sheetObj.GetCellValue(iRow, "dep_dlay_hrs2"));
			if(realValue<=hrs1){
				sheetObj.SetCellValue(iRow, "dep_dlay_hrs1",hrs1 - realValue,0);
			}else{
				ComShowCodeMessage("VSK00073");
				sheetObj.SetCellValue(iRow, "dep_dlay_hrs2",oldValue,0);
				return;
			}
			controlDelayData(sheetObj);
			sheetObj.SelectCell(Row, Col, false);
			break;
	}
}
function controlDelayData(sheetObj){
	var start=sheetObj.HeaderRows();
	var end=sheetObj.HeaderRows()+ sheetObj.RowCount();
	// in case Delay Hour is 0, Initializing Reason Code and Remark Button
	with(sheetObj){
		RenderSheet(0);
		for(var Row=start; Row<end; Row++){
			if(GetCellValue(Row, "arr_dlay_hrs1") == "0"){
				SetCellValue(Row, "arr_dlay_rsn_cd1","",0);
				SetCellValue(Row, "arr_rmk1","",0);
				SetCellValue(Row, "btn_arr_rmk1",1,0);
			}else{
//				if(isEditMode() || CellValue(Row, "arr_rmk1")!=""){
					SetCellValue(Row, "btn_arr_rmk1",0,0);
//				}
			}
			if(GetCellValue(Row, "arr_dlay_hrs2") == "0"){
				SetCellValue(Row, "arr_dlay_rsn_cd2","",0);
				SetCellValue(Row, "arr_rmk2","",0);
				SetCellValue(Row, "btn_arr_rmk2",1,0);
			}else{
//				if(isEditMode() || CellValue(Row, "arr_rmk2")!=""){
					SetCellValue(Row, "btn_arr_rmk2",0,0);
//				}
			}
			if(GetCellValue(Row, "dep_dlay_hrs1") == "0"){
				SetCellValue(Row, "dep_dlay_rsn_cd1","",0);
				SetCellValue(Row, "dep_rmk1","",0);
				SetCellValue(Row, "btn_dep_rmk1",1,0);
			}else{
//				if(isEditMode() || CellValue(Row, "dep_rmk1")!=""){
					SetCellValue(Row, "btn_dep_rmk1",0,0);
//				}
			}
			if(GetCellValue(Row, "dep_dlay_hrs2") == "0"){
				SetCellValue(Row, "dep_dlay_rsn_cd2","",0);
				SetCellValue(Row, "dep_rmk2","",0);
				SetCellValue(Row, "btn_dep_rmk2",1,0);
			}else{
//				if(isEditMode() || CellValue(Row, "dep_rmk2")!=""){
					SetCellValue(Row, "btn_dep_rmk2",0,0);
//				}
			}
		}
		SetCellValue(start, "arr_dlay_opt","",0);
		SetCellValue(start, "arr_dlay_hrs1","",0);
		SetCellValue(start, "arr_dlay_rsn_cd1","",0);
		SetCellValue(start, "btn_arr_rmk1","1",0);
		SetCellValue(start, "arr_dlay_hrs2","",0);
		SetCellValue(start, "arr_dlay_rsn_cd2","",0);
		SetCellValue(start, "btn_arr_rmk2","1",0);
		SetCellValue(end-1, "dep_dlay_opt","",0);
		SetCellValue(end-1, "dep_dlay_hrs1","",0);
		SetCellValue(end-1, "dep_dlay_rsn_cd1","",0);
		SetCellValue(end-1, "btn_dep_rmk1","1",0);
		SetCellValue(end-1, "dep_dlay_hrs2","",0);
		SetCellValue(end-1, "dep_dlay_rsn_cd2","",0);
		SetCellValue(end-1, "btn_dep_rmk2","1",0);
		RenderSheet(1);
	}
	if(!isEditMode()){
		for(var Row=start; Row<end; Row++){
			sheetObj.SetRowStatus(Row,"I");
		}
	}
}
function checkOption(sheetObj, formObj, sAction){
	var check=true;
	switch(sAction){
		case IBSAVE:
			if(sheetObj.RowCount()>0){
				check=true;
				if(check){
					for(var Row=sheetObj.HeaderRows(); Row<sheetObj.HeaderRows()+sheetObj.RowCount(); Row++){
						if(sheetObj.GetCellValue(Row, "turn_port_ind_cd")!="F" &&
								sheetObj.GetCellValue(Row, "skd_cng_sts_cd")!="S" &&
								(sheetObj.GetCellValue(Row, "act_brth_dt")=="" || sheetObj.GetCellValue(Row, "act_dep_dt")=="")){
							ComShowCodeMessage("VSK00074");
							check=false;
							break;
						}
					}
				}
			}else{
				check=false;
			}
			break;
		case IBDELETE:
			if(sheetObj.RowCount()> 0 && formObj.vsl_cd.value!="" && formObj.voy_no.value!="" && formObj.dir_cd.value!=""){
				check=true;
			}else{
				check=false;
			}
			break;
		case MULTI:
			with(sheetObj){
				if(RowCount()==0){
					check=false;
					break;
				}
				// in case Delay CD is exist, Delay Hour have to bigger than 0
				for(var i=HeaderRows(); i<=LastRow(); i++){
					if(i!=HeaderRows()){
						check=compareOption(GetCellValue(i, "arr_dlay_hrs1"), GetCellValue(i, "arr_dlay_rsn_cd1"));
						if(!check) break;
						check=compareOption(GetCellValue(i, "arr_dlay_hrs2"), GetCellValue(i, "arr_dlay_rsn_cd2"));
						if(!check) break;
					}
					if(i!=LastRow()){
						check=compareOption(GetCellValue(i, "dep_dlay_hrs1"), GetCellValue(i, "dep_dlay_rsn_cd1"));
						if(!check) break;
						check=compareOption(GetCellValue(i, "dep_dlay_hrs2"), GetCellValue(i, "dep_dlay_rsn_cd2"));
						if(!check) break;
					}
				}
				if(check){
					for(var Row=HeaderRows(); Row<=LastRow(); Row++){
						if(GetCellValue(Row, "turn_port_ind_cd")!="F" &&
								GetCellValue(Row, "skd_cng_sts_cd")!="S" &&
								(GetCellValue(Row, "act_brth_dt")=="" || GetCellValue(Row, "act_dep_dt")=="")){
							ComShowCodeMessage("VSK00074");
							check=false;
							break;
						}
					}
				}
			}
			if(check){
				check=ComIsDate(formObj.act_year.value + "-" + formObj.act_month.value, "ym");
				if(!check){
					ComShowCodeMessage('VSK00021', 'Actual Month');
				}
			}
			break;
		}
		return check;
}
function compareOption(delayHrs, delayCd){
	var check=true;
	if((delayHrs=="0" || delayHrs=="") && delayCd != ""){
		ComShowCodeMessage("VSK00075");
		check=false;
	}else if(delayCd == "" && (delayHrs!="0" && delayHrs!="")){
		ComShowCodeMessage("VSK00076");
		check=false;
	}
	return check;
}
function doNew(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	formObj.vsl_cd.value="";
	formObj.tmp_vsl_cd.value="";
	formObj.voy_no.value="";
	formObj.dir_cd.value="";
	formObj.vsl_slan_cd.value="";
	formObj.conv_clpt_seq.value="";
	formObj.act_year.value="";
	formObj.act_month.value="";
	ComBtnEnable("btn_Save");
	ComBtnEnable("btn_Delete");
	ComBtnEnable("btn_Conversion");
	sheetObj.RemoveAll();
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
