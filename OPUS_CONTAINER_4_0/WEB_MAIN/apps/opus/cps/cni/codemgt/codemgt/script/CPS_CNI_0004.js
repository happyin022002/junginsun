/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0004.js
*@FileTitle  : Handler History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
//===================================================================================
//common global variables
//===================================================================================
//IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
//html form
var frm=null;
//===================================================================================
//initializing 
//===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage() {
	//setting Variables
	frm=document.form;
	sheet1=sheetObjects[0];
	sheetCnt=sheetObjects.length;
	// sheet initial
	for ( var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//registering initial event 
	initControl();
	sheet1.SetWaitImageVisible(0);
 	var claim_no=frm.cgo_clm_no.value;
 	if (claim_no != "") {
 		doActionIBSheet(SEARCHLIST01);
 	}
 	sheet1.SetWaitImageVisible(1);
}
/**
 * registering initial event 
 **/
function initControl() {
	//keypress
	//axon_event.addListenerForm('keypress', 'obj_keypress', frm);
	// focus in
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	// focus out
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	//key up
	//axon_event.addListenerForm('keyup',				'obj_keyup',frm); 
}
 /**
  * HTML Control KeyPress event
  */
function obj_keypress() {
	switch (ComGetEvent("name")) {    
    case "cgo_clm_no":
    	ComKeyOnlyAlphabet('uppernum');
    	if (event.keyCode == 13) {
    		doActionIBSheet(SEARCHLIST01);
 		}
 		break;
 	}
}
 /**
  * HTML Control KeyUp event
  **/
 function obj_keyup() {
 	switch (ComGetEvent("name")) {    
     case "cgo_clm_no":
     	ComKeyOnlyAlphabet('uppernum');
     	if (frm.cgo_clm_no.value.length == 10) {
     		doActionIBSheet(SEARCHLIST01);
  		}
  		break;
  	}
 }
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {ibsheet} sheetObj IBSheet Object  
 **/
function setSheetObject(sheetObj) {
	sheetObjects[sheetCnt++]=sheetObj;
}
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button click event
 * @param none 
 **/
function processButtonClick() {
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn2_Manager":
			var claim_no=frm.cgo_clm_no.value
			var param="cgo_clm_no=" + claim_no ;
			var url="CPS_CNI_0005.do?" + param;
			var display="0,0,1,1,0,1,1,1,1,0,1,1";
			var win=ComOpenPopup(url, 600, 500, "", display);
			win.focus();
			break;
		case "btn1_Retrieve":
			doActionIBSheet(SEARCHLIST01);
			break;
		case "btn1_New":
			doActionIBSheet(IBCLEAR);
			break;
		case "btn1_Close":
			ComClosePopup(); 
			break;
		} // end switch
	} catch (e) {
		if( e == "[object Error]") {
		    ComShowMessage(OBJECT_ERROR);
		} else {
	       ComShowMessage(e.message);
		}
	}
}
/**
 * setting sheet initial values and header
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
 * adding case as numbers of counting sheets
 **/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
	    with(sheetObj){
			var HeadTitle1="||Seq.|Handler|Office|STS|Description|Working Period|Working Period|Working Period|Date|User";
			var headCount=ComCountHeadTitle(HeadTitle1);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			 {Type:"Radio",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"crnt_hdlr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue: "Y" },
			 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:15,   Align:"Center",  ColMerge:1,   SaveName:"tmp_bar",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			   
			InitColumns(cols);
			SetSheetHeight(162);
			SetEditable(0);
            }
		break;
	}
}
/**
 * Handling Sheet's process
 **/
function doActionIBSheet(sAction) {
	frm.f_cmd.value=sAction;
	switch (sAction) {
	case SEARCHLIST01: // Retrieve
		if (validateForm(sAction)) {
			frm.mgr_hdlr_div_cd.value="H";
			var sXml=sheet1.GetSearchData("CPS_CNI_0004GS.do",	FormQueryString(frm));
			var list=SheetXml2ListMap(sXml);
			if (list.length == 0) {
				ComShowCodeMessage("CNI00013");
			}
			sheet1.LoadSearchData(sXml,{Sync:1} );
		}
		break;
	case IBCLEAR: // New 
		//CNI00015 Do you want to initialize?
		if (ComShowCodeConfirm("CNI00015") ) {
			ComResetAll();
			frm.cgo_clm_no.focus();
		}
		break;
	}
}
/**
 * handling process for input validation
 **/
function validateForm(sAction) {
	if (!ComChkValid(frm)) return false;
	if (sAction == SEARCHLIST01) {
		var cgo_clm_no=frm.cgo_clm_no.value;
		if(ComIsNull(cgo_clm_no)) {
			//CNI00003:Please Fill all required entry fields {?msg1}.
			ComShowCodeMessage("CNI00003","Claim No");
			frm.cgo_clm_no.focus();
			return false;
		}
	}
	return true;
}