/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0252.js
*@FileTitle  : Other(s) Code Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class VOP_VSK_0252 : business script for VOP_VSK_0252
     */
 // public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
        switch(srcName) {
	 		case "btn_Retrieve":
	 			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	 			break;
			case "btn_Ok":
//				comPopupOK();
				ComPopUpReturnValue(sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'sheet1_code'));
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
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        //ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //ComEndConfigSheet(sheetObjects[i]);
    }
// 	initControl();
 	document.form.grd_nm.disabled=true;
 	grd_nm_change();
}
 /**
  * registering initial event 
  */
 function initControl() {
	 var formObj=document.form;
// 	axon_event.addListenerFormat("keypress", "obj_keypress",  formObj);
// 	axon_event.addListenerFormat("keyup",    "obj_keyup",     formObj);
 	//axon_event.addListenerForm('focus', 'obj_activate', formObj);
 	axon_event.addListener      ("change",   "grd_nm_change", "grd_nm");
 	axon_event.addListenerForm ('keydown', 'ComKeyEnter', formObj);
 } 
// function obj_activate(){
//	if(ComGetEvent().options){
//		ComGetEvent().focus();
//	}else{
//		ComGetEvent().select();
//	}
//}
 /**
  * Handling key press event
  */
// function obj_keypress() {
// 	switch(ComGetEvent().dataformat){
// 		case "float":
// 			ComKeyOnlyNumber(ComGetEvent(), ".");
// 			break;
// 		case "eng":
// 			ComKeyOnlyAlphabet();
// 			break;
// 		case "engdn":
// 			ComKeyOnlyAlphabet('lower');
// 			break;
// 		case "engup":
// 			ComKeyOnlyAlphabet('upper');
// 			break;
// 		default:
// 	}
// 	switch(ComGetEvent("name")){
// 		case "grd_nm": case "code": case "name": 
// 			if(event.keyCode==13){
// 				DoSearch();
// 			}
// 			break;
// 	}  	
// }
 /**
  * Handling key up event
  */
// function obj_keyup(){
// 	var formObject=document.form;
// 	var sheetObject1=sheetObjects[0];
// 	/*******************************************************/
// 	try {
// 		var srcName=ComGetEvent("name");
// 		switch(srcName) {
// 			default:
// 				obj_nextfocus(ComGetEvent());
// 				break;   				
// 		} // end switch
// 	}catch(e) {
// 		if( e == "[object Error]") {
// 			ComShowCodeMessage('VSK00011');
// 		} else {
// 			ComShowMessage(e.message);
// 		}
// 	}
// } 	
 /**
  * Handling change event
  */
 function grd_nm_change() {
	  clearAllData(sheetObjects[0], form);
	  var valGrdNm=form.grd_nm.value;
	  if(valGrdNm == "CD00717"){
		  document.getElementById("code").setAttribute("maxLength", "1");
	  } else if(valGrdNm == "CD01827" || valGrdNm == "CD01819"){
		  document.getElementById("code").setAttribute("maxLength", "2");
	  } else if(valGrdNm == "CD01830"){
		  document.getElementById("code").setAttribute("maxLength", "3");		  
	  } else if(valGrdNm == "CD0XXXX"){
		  document.getElementById("code").setAttribute("maxLength", "3");		  
	  }
 }   
 // focusing next
 function obj_nextfocus(obj) {
 	var objMaxLength=obj.getAttribute("maxlength");
 	var objValue=obj.getAttribute("value");
 	if (ComChkLen(objValue, objMaxLength) == 2) {
 		ComSetNextFocus(obj);
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
        case 1:      // sheet1 init
        	with(sheetObj){
        	
	        	var HeadTitle="Code|Description";
	        	var headCount=ComCountHeadTitle(HeadTitle);
	        	var prefix="sheet1_";
	
	        	SetConfig( { SearchMode:2,  Page:20} );
	
	        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        	InitHeaders(headers);
	
	        	var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"code", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"name", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	        	 
	        	InitColumns(cols);
	        	SetSheetHeight(202);
	        	SetEditable(0);
        	}
        	break;
        }
    }
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);
    switch(sAction) {
		case IBSEARCH:      //Retrieve
		if(validateForm(sheetObj, formObj, sAction)){
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var prefix="sheet1_";	//prefix 
			var sXml=sheetObj.GetSearchData("VOP_VSK_0252GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			//ComOpenWait(false);
		}
		break;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}
/**
 * Initializing screen
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllData(sheetObj1, formObj){
	formObj.code.value="";
	formObj.name.value="";
	sheetObj1.RemoveAll();
	formObj.code.focus();
} 
 /**
  * Handling enter key
  * @param sheetObj
  * @param formObj
  * @return
  */
function doSearch(){
 	var formObject=document.form;
 	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
 }   
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	return true;
}
/**
 * Return to Parent Screen
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
//	 comPopupOK();
	ComPopUpReturnValue(sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'sheet1_code'));
}


function sheet1_OnClick(sheetObj, Row, Col){
//	var obj=new Object(); 
//	obj.cd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'sheet1_code');
//	ComPopUpReturnValue(obj);
}
