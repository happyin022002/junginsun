/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0214.js
*@FileTitle  : Invoice Summary Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var LANE="lane";
var ROWMARK="|";
var FIELDMARK=",";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_DownExcel":
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
					}

				
				break;
			case "btn_Close":
				ComClosePopup(); 
				break;
		}
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
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl(sheetObjects[0]);  
	ComOpenWait(true);
 	xsheet1_OnLoadFinish(sheetObjects[0]);
	ComOpenWait(false);
	
}
/**
 * registering initial event 
 */
function initControl(sheetObj){
	var formObj=document.form;
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
	case "sheet1":
	    with(sheetObj){
      
      var HeadTitle1="CSR No.|INV.No.|Status|Rev VVD|Rev Lane|Rev DIR|Account Code|Cost Code|Cost Code\nDescription|I/O|Tariff Cost|Adjustment\nCost|Amount|Formula|Formula";
      var headCount=ComCountHeadTitle(HeadTitle1);
      var prefix="sheet1_";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ 
             {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"csr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"status",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rlane_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_dir_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cost_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"io",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"calc_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"adj_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"locl_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"xpr_desc",   KeyField:0 },
             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",  KeyField:0 } ];
            //ShowSubSum([{StdCol:"vvd", SumCols:"10|11|12", Sort:false, ShowCumulate:false, CaptionCol:4, CaptionText:"SUB.Total"}]);
      		InitColumns(cols);
            ShowSubSum([{StdCol:prefix+"vvd", SumCols:"10|11|12", Sort:false, ShowCumulate:false, CaptionCol:4, CaptionText:"SUB.Total"}]);
      		SetEditable(0);
            SetShowButtonImage(1);
            SetSheetHeight(280);
      }


		break;
	}
}
//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      // Retrieving
			var aryPrefix=new Array( "sheet1_");       
			formObj.f_cmd.value=SEARCH;
			sheetObj.SetWaitImageVisible(0);
 			var sXml=sheetObj.GetSearchData("VOP_PSO_0214GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			//var arrXml=sXml.split("|$$|");
			sheetObj.LoadSearchData(sXml,{Sync:0} );
		break;
	}
}
 function xsheet1_OnLoadFinish(sheetObj){
	var formObj=document.form;
	var port=document.getElementById("port_cd").value;
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}
 

function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
	var prefix=sheetObj.id+"_";
	var Row=sheetObj.MouseRow();
	var Col=sheetObj.MouseCol();
	var colName=sheetObj.ColSaveName(Col);
	
	if(Row>=sheetObj.HeaderRows()&& Row!=sheetObj.LastRow() && (colName==prefix+"xpr_desc" || colName==prefix+"foml_desc")){
		var tipText=sheetObj.GetCellText(Row, Col);
		sheetObj.SetToolTipText(Row, Col, tipText);
	}
}
	
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	var prefix="sheet1_";
	//Sub Sum
	//sheetObj.ShowSubSum("vvd", "calc_amt|locl_amt|usd_amt", -1, false, false, 0, "1=;6=Sub Total;7=");
//	var sumcols = sheetObj.SaveNameCol(prefix+"calc_amt")+"|"+sheetObj.SaveNameCol(prefix+"adj_amt")+"|"+sheetObj.SaveNameCol(prefix+"locl_amt");
//	sheetObj.ShowSubSum([{StdCol:sheetObj.SaveNameCol(prefix+"vvd"), SumCols:sumcols, Sort:0, ShowCumulate:0, CaptionCol:1, CaptionText:"1=SUB.Total"}]);
//	sheetObj.ShowSubSum([{StdCol:sheetObj.SaveNameCol(prefix+"vvd"), SumCols:sumcols, Sort:0, ShowCumulate:0}]);
	//Total Sum
//	sheetObj.SetSumValue(prefix + "csr_no","");
	sheetObj.SetSumValue(prefix + "rlane_cd","Grand TTL");
	sheetObj.SetCellAlign(sheetObj.LastRow(), prefix + "rlane_cd","Center");
}
