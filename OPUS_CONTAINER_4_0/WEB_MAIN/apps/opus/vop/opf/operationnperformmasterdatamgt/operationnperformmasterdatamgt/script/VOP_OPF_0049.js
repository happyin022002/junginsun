/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0049.js
*@FileTitle  : Stevedore Damage Reason Code (Creation)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
/**
 * @extends
 * @class vop_opf_0049 : vop_opf_0049 business script for
 */
function vop_opf_0049() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
/* Developer performance	*/
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
	        var HeadTitle1="|Sel.|No.|Code|Description|Category";
	        var headCount=ComCountHeadTitle(HeadTitle1);
//	        (headCount, 0, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"stv_dmg_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, AcceptKeys:"E|N", InputCaseSensitive:1 },
	               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"stv_dmg_cd_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
	               {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"stv_dmg_cate_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
	        SetColProperty("stv_dmg_cate_cd", {ComboText:"Quotation|No responsible party", ComboCode:"QUOT|NOTH"} );
	        //SetSheetHeight(460);
	        resizeSheet();
		}
		break;
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}


// handling process related Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("VOP_OPF_0049GS.do", FormQueryString(formObj) );
			}
		}
		break;
	case IBSAVE: //save
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		formObj.f_cmd.value=MULTI;
		sheetObj.DoSave("VOP_OPF_0049GS.do", FormQueryString(formObj), -1, false);
		break;
	case IBINSERT: // insert
		var row=sheetObj.DataInsert();
		sheetObj.SelectCell(row, "stv_dmg_cd");
		break;
	case COMMAND01: // copy
		var row=sheetObj.DataCopy();
		sheetObj.SelectCell(row, "stv_dmg_cd");
		break;
	case COMMAND02: // add
		var row=sheetObj.DataInsert(-1);
		sheetObj.SelectCell(row, "stv_dmg_cd");
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
		for ( var ir=1; ir <= sheetObj.LastRow(); ir++) {
			var bfCode=sheetObj.GetCellValue(ir, "stv_dmg_cate_cd") + ":" + sheetObj.GetCellValue(ir, "stv_dmg_cd");
			if (bfCode != "") {
				for ( var jr=1; jr <= sheetObj.LastRow(); jr++) {
					var afCode=sheetObj.GetCellValue(jr, "stv_dmg_cate_cd") + ":" + sheetObj.GetCellValue(jr, "stv_dmg_cd");
					if (ir != jr && afCode == bfCode) {
						ComShowCodeMessage("OPF50005", 'Data');	//'{?msg1} is duplicated.'
						if (sheetObj.GetRowStatus(jr) == "I") {
							sheetObj.SelectCell(jr, 2);
						} else {
							sheetObj.SelectCell(ir, 2);
						}
						return;
					}
				}
			}
		}
	}
	return true;
}
/* Developer performance  end */
