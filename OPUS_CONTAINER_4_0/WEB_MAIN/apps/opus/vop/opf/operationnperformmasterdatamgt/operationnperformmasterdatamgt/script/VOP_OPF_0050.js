/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0050.js
*@FileTitle  : Stevedore Damage Part Code (Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/* Developer performance */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;
		case "btn_DownExcel":
			//sheetObject1.Down2Excel(1);
			if(sheetObject1.RowCount() < 1){//no data
     			ComShowCodeMessage("COM132501");
     		} else{
	            var paramObj=new Object();
	            paramObj.title="";
	            paramObj.orientation="Portrait";
	            paramObj.columnwidth="1:5|2:6|3:42|4:20";
	            var url=ComOpfGetExcelSet(sheetObject1, paramObj);
                sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), HiddenColumn:-1,Merge:true,ReportXMLURL:url});
     		}
			break;			
		case "btn_close":
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
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items  
 * 
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag 
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo
 * 　 adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1":
	    with(sheetObj){
	      var HeadTitle1="|No.|Code|Description|Category";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"Integer" },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"stv_dmg_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"stv_dmg_cd_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"stv_dmg_cate_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	
	      SetEditable(0);
	      SetColProperty("stv_dmg_cate_cd", {ComboText:"Hull|Machinary|Material", ComboCode:"HULL|MACH|MATL"} );
	      SetColProperty(0 ,"stv_dmg_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	      //SetSheetHeight(480);
	      resizeSheet();
      	}
		break;
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}


// handling process related Sheet
// function doActionIBSheet(sheetObj, formObj, sAction, a, PageNo) {
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("VOP_OPF_0050GS.do", FormQueryString(formObj) );
			}
		}
		break;
	case IBSAVE: // save
		if(!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		formObj.f_cmd.value=MULTI;
		if(sheetObj.DoSave("VOP_OPF_0048GS.do", FormQueryString(formObj))){
			ComShowCodeMessage('OPF00017');		
		}
		break;
	case IBINSERT: // insert
		sheetObj.DataInsert();
		break;
	case COMMAND01: // copy
		sheetObj.DataCopy();
		break;
	case COMMAND02: // add
		sheetObj.DataInsert(-1);
		break;
	case IBDELETE: // delete
		ComRowHideDelete(sheetObj, "del_chk");
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	if (sAction == IBSAVE) {
		var row = sheetObj.ColValueDupRows("stv_dmg_cd");
		if (row.length > 0)  {
			ComShowCodeMessage('OPF00016');
			var arrRows=row.split(",");
			sheetObj.SelectCell(arrRows[0],2,true);
			return false;
		}
	}
	return true;
}
/* Developer performance end */