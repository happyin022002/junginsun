/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName :  VOP_VSK_0704.js
*@FileTitle  : Port Canal Tier & Surcharge 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class VOP_VSK_0044 : business script for VOP_VSK_0044
 */
function VOP_VSK_0704() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
			switch (srcName) {
			case "btn_Ok":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btn_Close":
				ComClosePopup();
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
 * adding first-served functions after loading screen
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var sheetObject=sheetObjects[0];
	for (var i=0; i < 9; i++) {
		sheetObject.DataInsert(-1);
		sheetObject.SetCellValue(i+1,"sheet1_loc_cd",'EGSCA');
		sheetObject.SetCellValue(i+1,"sheet1_vsl_tr_no",i+1);
	}
	initControl();
}
/**
 * registering initial event
*/
function initControl() {
	axon_event.addListenerForm("focus", "obj_activate");
	axon_event.addListener('keypress', 'eng_keypress', 'vsl_cd', 'vsl_eng_nm', 'crr_cd', 'call_sgn_no', 'lloyd_no');
	axon_event.addListener('keyup', 'obj_keyup', 'vsl_cd', 'crr_cd');
	axon_event.addListenerForm('keypress', 'enter_keypress');
	axon_event.addListenerForm('keyup', "VskKeyFocus");
}
/**
  * Handling key press event
  **/
 function obj_keypress() {
     switch(event.srcElement.dataformat){
         default:
             ComKeyOnlyNumber(event.srcElement);
     }
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
	        	tabIndex=-1;
	        	if (location.hostname != "")
			    //no support[check again]CLT 					InitHostInfo(location.hostname, location.port, page_path);
			    var HeadTitle="|Port|Tier|Ratio(%)";
			    var headCount=ComCountHeadTitle(HeadTitle);
			    var prefix="sheet1_";
		
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
			    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
		
		      	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_tr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tr_scg_rto", KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 } ];
		       
		      	InitColumns(cols);
	
		      	SetEditable(1);
		        SetSheetHeight(350);
	            }
				break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
		case IBSAVE: 
			var sParam=ComGetSaveString(sheetObj);
			if (validateForm(sheetObj, formObj, IBSAVE)){
				formObj.f_cmd.value=MULTI;
				var sXml=sheetObj.GetSaveData("VOP_VSK_0704GS.do", "f_cmd=" + MULTI + "&" +sParam);
				if(sXml.indexOf("OK") > -1){
					sheetObj.LoadSaveData(sXml);					
					comPopupOK();
				}else{
					sheetObj.LoadSaveData(sXml);
				}
		break;
		}
	}	
}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
          	switch (sAction) {
   			case IBSAVE:  
        	 	for(var i=sheetObj.HeaderRows(); i< sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
        	 		if((sheetObj.GetCellValue(i, "sheet1_tr_scg_rto")) == "" ) {
      	 			ComShowCodeMessage("COM130403");
        	 		return false;
        	 		} 
        	 	}
        	 	break;
        }
		return true;
     }
/**
 * Handling Enter Key Event
 */
function enter_keypress() {
	VskKeyEnter();
}
