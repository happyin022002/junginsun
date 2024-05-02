/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0005.jsp
*@FileTitle  : [CPS_CNI_0005] Manager History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/**
 * [CPS_CNI_0005] Manager History
 * 
 * @extends
 * @class business script for manager history
 */
//===================================================================================
//common global variables
//===================================================================================
//IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
var sheet2=null;
//html form
var frm=null;
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {ibsheet} sheetObj IBSheet Object  
 **/
function setSheetObject(sheetObj){
    sheetObjects[sheetCnt++]=sheetObj;
}
//===================================================================================
//initializing 
//===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	//setting Variables
	frm=document.form;
	sheet1=sheetObjects[0];
	sheet2=sheetObjects[1];
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
 	sheet2.SetWaitImageVisible(0);
 	var claim_no=frm.cgo_clm_no.value;
 	if (claim_no != "") {
 		doActionIBSheet(SEARCHLIST02);
 	}
 	sheet2.SetWaitImageVisible(1);
}
/**
 * registering initial event 
 **/
function initControl() {
	//keypress
	axon_event.addListenerForm('keypress',        'obj_keypress', frm);
	// focus in
//	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	// focus out
//	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	//key up
	axon_event.addListenerForm('keyup',			   'obj_keyup', frm); 
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
     		sheet2.SetWaitImageVisible(0);
     		doActionIBSheet(SEARCHLIST02);
     		sheet2.SetWaitImageVisible(1);
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
     		sheet2.SetWaitImageVisible(0);
     		doActionIBSheet(SEARCHLIST02);
     		sheet2.SetWaitImageVisible(1);
  		}
  		break;
  	}
 }
 /**
 * The function called when OnLoad event of page has finished 
 * @param {ibsheet} sheet  sheet
 */
 function sheet2_OnLoadFinish(sheet) {
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
			case "btn2_Row_Add":
				doActionIBSheet(IBINSERT);
				break;
	        case "btn2_Row_Delete":
	        	if (sheet2.RowCount()> 0) {
	        		SheetRowDelete(sheet2,sheet2.GetSelectRow());
	        	}
	    		break; 
			case "btn1_Retrieve":
				if (validateForm(SEARCHLIST01)) {
					doActionIBSheet(SEARCHLIST01);
					sheet2.SetWaitImageVisible(0);
					doActionIBSheet(SEARCHLIST02);
					sheet2.SetWaitImageVisible(1);
				}	
				break;
			case "btn1_New":
				doActionIBSheet(IBCLEAR);
				break;
			case "btn1_Save":
				var changeRowCnt = sheet2.RowCount("I") + 
				                   sheet2.RowCount("U") +
				                   sheet2.RowCount("D");
				if (changeRowCnt == 0) {
					ComShowCodeMessage("CNI00022");//"There is no contents to save.";
					return;
				} else {	
					if (ComShowCodeConfirm("CNI00012")) { //"Data was changed. Do you want to save it?"
						doActionIBSheet(MULTI);
					} 
				}	
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
 * adding case as numbers of counting sheets
 **/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
	    with(sheetObj){
       
		      if (location.hostname != "")
		      var HeadTitle1="||Seq.|Handler|Office|STS|Description|Working Period|Working Period|Working Period|Date|User";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Radio",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"crnt_hdlr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue: "Y" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"tmp_bar",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetEditable(0);
		      SetSheetHeight(120);
            }


	    break;
	case "sheet2": //sheet2 init
	    with(sheetObj){
      
		      if (location.hostname != "")
		      var HeadTitle1="|Seq.|Manager|Office|Date|User|||";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_hdlr_his_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_cd" } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(120);
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
	case SEARCHLIST01: // Retrieve Handler History
		frm.mgr_hdlr_div_cd.value="H";
 		var sXml=sheet1.GetSearchData("CPS_CNI_0004GS.do",	FormQueryString(frm));
		var list=SheetXml2ListMap(sXml);
		if (list.length == 0) {
			ComShowCodeMessage("CNI00013");
		}
		sheet1.LoadSearchData(sXml,{Sync:1} );
		break;
	case SEARCHLIST02: // Retrieve Manager History
		frm.mgr_hdlr_div_cd.value="M";
 		var sXml=sheet2.GetSearchData("CPS_CNI_0005GS.do",	FormQueryString(frm));
		sheet2.LoadSearchData(sXml,{Sync:1} );
		frm.cgo_clm_no.focus();
		break;
	case IBCLEAR: // New  
		//CNI00015 Do you want to initialize?
		if (ComShowCodeConfirm("CNI00015") ) {
			frm.cgo_clm_no.value="" ;
			sheet1.RemoveAll();
			sheet2.RemoveAll();
			frm.cgo_clm_no.focus();
		}
		break;
	case IBINSERT: // Row Add
	    if (!validateForm(sAction)) { return; }
		var row=sheet2.DataInsert(-1);
		sheet2.SelectCell(row,"hdlr_usr_id",true);
		sheet2.SetCellValue(row, "cgo_clm_no",frm.cgo_clm_no.value,0);
		sheet2.SetCellValue(row, "upd_usr_id",frm.usr_id.value,0);
		sheet2.SetCellValue(row, "upd_dt",setDate(),0);
		sheet2.SetCellValue(row, "upd_ofc_cd",userOfficeCode,0);
		sheet2.SetCellValue(row, "hdlr_ofc_cd",userOfficeCode,0);
sheet2.SetCellValue(row, "cgo_clm_sts_cd",sheet1.GetCellValue(1, "cgo_clm_sts_cd"),0);
		break;
	case MULTI: //Save
		if (!validateForm(sAction)) { return; }
		var param=FormQueryString(frm);
		var saveString=sheet2.GetSaveString();
		if (sheet2.IsDataModified()&& ComIsNull(saveString))  {
			return;
		}
		saveString=ComSetPrifix(saveString, "sheet2_");
		param += "&" + saveString;	
 		var sXml=sheet2.GetSaveData("CPS_CNI_0005GS.do", param);
 		sheet2.LoadSaveData(sXml);
		break;
	}	
}
 /**
  * today,time
  */ 
 function setDate(){
 	 var d=new Date;
 	 var s=leadingZeros(d.getFullYear(), 4) + '-'
 		   + leadingZeros(d.getMonth() + 1, 2) + '-'
 		   + leadingZeros(d.getDate(), 2) + ' ';
 	 return s;
 }
 function leadingZeros(n, digits) {
     var zero='';
     n=n.toString();
     if (n.length < digits) {
       for (i=0; i < digits - n.length; i++)
         zero += '0';
     }
     return zero + n;
}
/**
 * handling process for input validation
 **/
function validateForm(sAction) {
	if (!ComChkValid(frm)) return false;
	var cgo_clm_no=frm.cgo_clm_no.value;
	if(cgo_clm_no == "") {
		ComShowCodeMessage("CNI00003","Claim No");
		frm.cgo_clm_no.focus();
		return false;
	}
	return true;
}
