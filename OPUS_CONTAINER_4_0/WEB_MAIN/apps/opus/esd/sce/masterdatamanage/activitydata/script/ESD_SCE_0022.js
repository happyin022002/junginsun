/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0022.js
*@FileTitle  : tivity Attribute Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick(){
	 var sheetObject=sheetObjects[0];
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH) ;
}

/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:	  //IBSheet1 init
			with (sheetObj) {
				var HeadTitle="STS|SEQ|Activity\nType|Activity\nCode|Activity Name|Scheduling\nSource|Standard EDI\nStatus Code|Customer\nVisibility|Active Flag" ;
	
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
	
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"act_tp_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"act_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"act_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cop_skd_lgc_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_stnd_edi_sts_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5,AcceptKeys:"E|N", InputCaseSensitive:1 },
				{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_vis_flg",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"act_flg",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				 
				InitColumns(cols);	
				SetEditable(1);
//				SetSheetHeight(ComGetSheetHeight(sheetObj, 21));
				resizeSheet(); 
			}
			break;
		}
	}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	   case IBSEARCH:	  //Query
			formObj.f_cmd.value=SEARCHLIST;
 			sheetObj.DoSearch("ESD_SCE_0022GS.do", SceFrmQryString(formObj) );
			break;
	   case IBDOWNEXCEL:
 			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
			break;
		}
	}
/**
* handling process for input validation
*/
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSAVE:
			break;
		default:
			break;
	}
	return true;
}
function sheet1_OnChange(sheetObj, row, col){
	var colName=sheetObj.ColSaveName(col) ;
	if(colName=="act_stnd_edi_sts_cd"){
		sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase() ,0);
	}		
}
function sheet1_OnSaveEnd(sheetObj, errMsg){
	if(errMsg==""){
		doActionIBSheet(sheetObj, document.form, IBSEARCH) ;
		ComShowMessage(ComGetMsg('SCE90005')) ;
	}	
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
} 
