/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0088.js
*@FileTitle  : Reason for Excluding from TPR (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11

=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
/**
 * @extends
 * @class vop_opf_0087 : vop_opf_0087 business script for
 */
function vop_opf_0087() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
/* Developer performance */
//common global variables
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0]; // t1sheet1
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_RowAdd":
			doActionIBSheet(sheetObject1, formObject, COMMAND02);
			break;
		case "btn_RowInsert":
			doActionIBSheet(sheetObject1, formObject, IBINSERT);
			break;
		case "btn_RowCopy":
			doActionIBSheet(sheetObject1, formObject, COMMAND01);
			break;
		case "btn_Delete":
			doActionIBSheet(sheetObject1, formObject, IBDELETE);
			break;
		case "btn_DownExcel":
//            var paramObj=new Object();
//            paramObj.title="";
//            paramObj.orientation="Portrait";
//            paramObj.columnwidth="1:5|2:6|3:65";
//            var url=ComOpfGetExcelSet(sheetObject1, paramObj);
//            if(sheetObject1.RowCount() < 1){//no data
//            	ComShowCodeMessage("COM132501");
//            	}else{
//            		//sheetObject1.Down2Excel({ HiddenColumn:-1,Merge:true},URL:"url");
//            		sheetObject1.Down2Excel({ HiddenColumn:-1,Merge:true});
//            }
            var paramObj=new Object();
            paramObj.title="";
            paramObj.orientation="Portrait";
            paramObj.columnwidth="1:5|2:6|3:65";
            
            var url=ComOpfGetExcelSet(sheetObject1, paramObj);
            
            if(sheetObject1.RowCount() < 1){
            	ComShowCodeMessage("COM132501");
            }else{
            	sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), HiddenColumn:-1,Merge:true,ReportXMLURL:url});
            }
			break;
		case "btn_close":
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
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
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {

	        if (location.hostname != "")
	        var HeadTitle1="|No.|Code|Reason for Excluding from TPR";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        //(headCount, 0, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                    KeyField:0,   CalcLogic:"",   Format:"Integer" },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"tml_prod_rpt_rsn_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	               {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"tml_prod_rpt_rsn_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	         
	        InitColumns(cols);
	
	        SetEditable(0);
	        //SetSheetHeight(482);
	        resizeSheet();
		}
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}


// handling process related Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("VOP_OPF_0087GS.do", FormQueryString(formObj) );
			}
		}
		break;
	case IBSAVE: 
		if(!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
	    formObj.f_cmd.value=MULTI;
	    if(sheetObj.DoSave("VOP_OPF_0087GS.do", FormQueryString(formObj))) {
//			ComShowCodeMessage("OPF50006", 'Data');	//'{?msg1} was saved successfully.'		           		    	
	    }
	    break;
	case IBINSERT: 
		var row=sheetObj.DataInsert();
		sheetObj.SelectCell(row, "tml_prod_rpt_rsn_cd");
		break;
	case COMMAND01: 
		var row=sheetObj.DataCopy();
		sheetObj.SelectCell(row, "tml_prod_rpt_rsn_cd");
		break;
	case COMMAND02: 
		var row=sheetObj.DataInsert(-1);
		sheetObj.SelectCell(row, "tml_prod_rpt_rsn_cd");
		break;
	case IBDELETE: 
		ComRowHideDelete(sheetObj, "del_chk");
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	if (sAction == IBSAVE) {
		var row = sheetObj.ColValueDupRows("tml_prod_rpt_rsn_cd");
		if (row.length > 0)  {
			ComShowCodeMessage("OPF50005", 'Data');	//'{?msg1} is duplicated.'
			var arrRows=row.split(",");
			sheetObj.SelectCell(arrRows[0],3,true);
			return false;
		}
	}
	return true;
}
/* developer performance end */
