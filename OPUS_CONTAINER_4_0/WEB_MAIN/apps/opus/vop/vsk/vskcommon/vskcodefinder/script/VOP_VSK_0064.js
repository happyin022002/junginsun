/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0064.js
*@FileTitle  : Other(s) Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

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
 function loadPage(){
 	for(i=0;i<sheetObjects.length;i++){
 		ComConfigSheet (sheetObjects[i] );
 		initSheet(sheetObjects[i],i+1);
 		ComEndConfigSheet(sheetObjects[i]);
 	}
 	ComChkObjValid(document.form.name);
 	initControl();
// 	grd_nm_change();
 }
 
/**
 * registering initial event 
 */
function initControl(){
	var formObj=document.form;
	axon_event.addListenerFormat("keypress", "obj_keypress", formObj);
	axon_event.addListenerFormat("keyup"   ,    "obj_keyup", formObj);
}

/**
 * Handling key up event
 */
function obj_keyup(){
	var formObject=document.form;
  	var sheetObject1=sheetObjects[0];
  	/*******************************************************/
  	try {
  		var srcName=ComGetEvent("name");
  		switch(srcName) {
  			default:
  				obj_nextfocus(ComGetEvent());
  				break;   				
  		} // end switch
  	}catch(e) {
  		if( e == "[object Error]") {
  			ComShowCodeMessage('VSK00011');
  		} else {
  			ComShowMessage(e.message);
  		}
  	}
}
  
  // next focus
 function obj_nextfocus(obj){
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
 	var sheetId=sheetObj.id;
 	switch(sheetId) {
 	case "sheet1":      // sheet1 init
 	    with(sheetObj){
 			var HeadTitle="Code|Description ";
 			var headCount=ComCountHeadTitle(HeadTitle);
 			var prefix="sheet1_";

 			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

 			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
 			var headers = [ { Text:HeadTitle, Align:"Center"} ];
 			InitHeaders(headers, info);

 			var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"code", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
 			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"name", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
       
 			InitColumns(cols);

 			SetEditable(0);
 			resizeSheet();
 		}
 	    break;
 	}
}
 
 // handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
 	sheetObj.ShowDebugMsg(false);
 	sheetObj.SetWaitImageVisible(0);
 	switch(sAction) {
		case IBSEARCH:      //btn_Retrieve
			if(validateForm(sheetObj, formObj, sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var prefix="sheet1_";	//prefix 
				var sXml=sheetObj.GetSearchData("VOP_VSK_0064GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
			}
		break;
 	}	
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
 * KEY PRESS event
 */
function obj_keypress(){	
	VskKeyEnter();
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}