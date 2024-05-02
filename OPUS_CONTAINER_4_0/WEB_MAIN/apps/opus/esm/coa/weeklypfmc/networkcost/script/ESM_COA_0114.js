/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0114.js
*@FileTitle  : Missing List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================
* History
*/
/*------------------Code for JSDoc creation below ------------------*/
/**
 * @extends 
 * @class ESM_COA_0114 : ESM_COA_0114 Business script for the UI
 */
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
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
	loadingMode=true;
	var formObj = document.form;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    //1st tab BSA Flag display none, 2nd tab BSA Flag display on
    if(formObj.f_strtype.value == "1") {
    	div_bsazrflg.style.display = "none";
    	formObj.f_chk_bsazrflg.checked = false;
    } else { 
    	div_bsazrflg.style.display = "inline";
    	formObj.f_chk_bsazrflg.checked = true;
    }
    chgBsazrflg();
    
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
	loadingMode=false;
}
/**
 * Setting multicombo items
 */
function initCombo(comboObj, comboId) {
	with (comboObj) {
		SetDropHeight(300);
		Index=0;
	}
}
/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
  var formObj=document.form;
  switch(sheetNo) {
    case 1:      //sheet1 init
        with(sheetObj){
//		        (9, 1, 0, true);
		      var HeadTitle="";
		      if(formObj.f_strchkprd.value == "W")HeadTitle="YYYY-WW|";
		      else HeadTitle="YYYY-MM|";
		      HeadTitle=HeadTitle+"Code|Network Cost Item|Trade|R.Lane|IOC|VVD|Create Date|Remark";
		      var cnt=0;
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      //SJH.20141226.MOD : 가로사이즈 늘리기
		      var cols = [ {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrwk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"stnd_cost_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"stnd_cost_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:1000,  Align:"Left",    ColMerge:1,   SaveName:"cost_calc_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetEditable(0);
		      SetHeaderRowHeight(10);
		      SetSheetHeight(300);
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
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
  sheetObj.ShowDebugMsg(false);
  switch(sAction) {
	case IBCLEAR:          //Inquiry
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=INIT;
 		var sXml=sheetObj.GetSearchData("ESM_COA_0114GS2.do", coaFormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (0 < arrXml.length)
			ComXml2ComboItem(arrXml[0], f_cobcost, "code", "name");
			f_cobcost.SetSelectIndex(0);
		ComOpenWait(false);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);  //Inquiry in case of loading
		break;
    case IBSEARCH:      //Inquiry
    	// Prohibit button click when a business transaction is processing 
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
        formObj.f_cmd.value=SEARCHLIST;
 		sheetObj.DoSearch("ESM_COA_0114GS.do", coaFormQueryString(formObj) );
//		ComOpenWait(false);
        break;
  }
}

function sheet1_OnSearchEnd(shtObj, ErrMsg) {		
	shtObj.SetColWidth("cost_calc_rmk", 0);		//20150629.ADD
	if(shtObj.GetColWidth("cost_calc_rmk") < 320)	shtObj.SetColWidth("cost_calc_rmk", 320);	//20150630.ADD
	ComOpenWait(false);
}			

/**
* setting check condition
 */
function chgBsazrflg(){
	var formObj = document.form;
	
	if(formObj.f_chk_bsazrflg.checked){
		formObj.f_chk_bsazrflg.value = "Y";
	} else {
		formObj.f_chk_bsazrflg.value = "N";
	}
}

