/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0235.js
*@FileTitle  : Agreement Rate Inquiry Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
/**
 * Define the initial values and headers of sheets
 * European S/O
 */
function initSheet(sheetObj, sheetNo) {
  var sheetObject=sheetObjects[0]; 
  var cnt=0;
  switch(sheetNo) {
  	case 1: //sheet0 init ( Child S/P )
	  with (sheetObj) {
        var HeadTitle1="Equipment\nTYPE/SIZE|Basic Rate|Surchage|Surchage|Surchage|Surchage" ;
        var HeadTitle2="Equipment\nTYPE/SIZE|Basic Rate|Fuel|Over Weight|Hazmat|Etc Total" ;
        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        var headers = [ { Text:HeadTitle1, Align:"Center"},
                        { Text:HeadTitle2, Align:"Center"} ];
        InitHeaders(headers, info);
        var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_tp_sz",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bzc_rt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fuel_scg_rt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ow_scg_rt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dg_scg_rt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
            {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ttl_scg_rt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 } ];
        InitColumns(cols);
        SetEditable(1);
        SetRangeBackColor(1,2,1,5,"#555555");
        SetSheetHeight(270);
	  }
  break;
  }
}
/**
* Setting sheets and initialization 
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); 
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); 
	}
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	doActionIBSheet(sheetObject,formObject,IBSEARCH);
}
/*------------------ Defining general java script function   ------------------*/
/* General global variable */
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
   try {
       var srcName=ComGetEvent("name");
       switch(srcName) {
			case "btng_close":
				ComClosePopup(); 
    	        break;
			break;
       } // end switch
   }catch(e) {
       if( e == "[object Error]") {
			ComShowCodeMessage('TRS90031');
       } else {
			ComShowMessage(e.message);
       }
   }
}
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
	var formObject=document.form;
    switch(sAction) {       
       case IBSEARCH:
	   	    formObj.f_cmd.value=SEARCH01;
	   	    sheetObj.DoSearch("ESD_TRS_0235GS.do", TrsFrmQryString(formObj) );
			break;
    }
}
/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
