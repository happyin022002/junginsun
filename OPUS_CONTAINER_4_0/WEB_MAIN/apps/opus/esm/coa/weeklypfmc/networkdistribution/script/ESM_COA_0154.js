/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0154.js
*@FileTitle  : Space Charter Revenue Missing List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
/**
 * @extends 
 * @class ESM_COA_0154 : ESM_COA_0154 Business script for the UI
 */
function ESM_COA_0154() {
    this.processButtonClick=processButtonClick ;
    this.loadPage=loadPage           ;
    this.initSheet=initSheet          ;
    this.setSheetObject=setSheetObject     ;
    this.sheet1_OnSearchEnd=sheet1_OnSearchEnd ;
    this.doActionIBSheet=doActionIBSheet    ;
}
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
  var sheetObject=sheetObjects[0];
  var formObject=document.form;
  try {
    var srcName=ComGetEvent("name");
    if(ComGetBtnDisable(srcName)) return false;
    switch(srcName) {
      case "btn_Retrieve":
          doActionIBSheet(sheetObject,formObject,IBSEARCH);
          break;
      case "btn_Close":
  ComClosePopup(); 
          break;
    } // end switch
  } catch(e) {
    if( e == "[object Error]") {
      ComShowMessage(OBJECT_ERROR);
    } else {
      ComShowMessage(e.message);
    }
  }
 }
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage() {
  for (i=0; i<sheetObjects.length; i++) {
    ComConfigSheet(sheetObjects[i]);
    initSheet(sheetObjects[i], i+1, "");
    ComEndConfigSheet(sheetObjects[i]);
  }
  doActionIBSheet(sheetObjects[0], document.form, SEARCHLIST);  //Inquiry in case of loading
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo,header) {
  var arrHeader="";
  var formObj=document.form;
  switch(sheetNo) {
    case 1:      //sheet1 init
        with(sheetObj){
        //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
      var HeadTitle="Year|Week|Trade|R.Lane|Vessel|Voyage|Dir|Company \nBSA|Lease \nBSA|Company BSA \n(%)|Lease BSA\n(%)|Expense|Income";
      var cnt=0;

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sls_yrmon",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cost_wk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"n2nd_fnl_co_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_capa",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_rto",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"co_bsa_rto",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"expn",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Float",     Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:"incm",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);

      SetEditable(0);
      SetCountPosition(0);
		SetHeaderRowHeight(30);
		SetSheetHeight(150);
      //no support[check again]CLT style.height=GetSheetHeight(8) ;
      }


        break;
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
* Setting the top of the information after retrieved sheet1
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    if(ComShowConfirm(ComGetMsg('COA10033')) == true) {
        opener.processButtonClick("btn_applytopl_step2");
    }
}
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
  sheetObj.ShowDebugMsg(false);
  switch(sAction) {
    case SEARCHLIST:      //Inquiry
    	// Prohibit button click when a business transaction is processing 
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
        formObj.f_cmd.value=SEARCHLIST;
        sheetObj.DoSearch("ESM_COA_0154GS.do", coaFormQueryString(formObj) );
        ComOpenWait(false);
        break;
  }
}
