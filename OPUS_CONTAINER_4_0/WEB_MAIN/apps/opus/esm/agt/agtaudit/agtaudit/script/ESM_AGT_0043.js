/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_AGT_0043.js
*@FileTitle  : Agent Commission CSR Detail Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;

function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}

function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    var formObj=document.form;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:
            with(sheetObj){
				var HeadTitle = "Cost Office|Confirmed Date|Vender Seq|Vender Name|No of INV|INV Currency|Total Amount|Payment Due Date|ASA No";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			    var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);

			    var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tj_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vndr_locl_lang_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"attr_ctnt1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"csr_curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"csr_amt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"inv_term_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"attr_ctnt2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
     
			    InitColumns(cols);
			
			    SetEditable(0);
			    SetCountPosition(0);
			    SetVisible(0);
		}
        break;
		case 2:
			with(sheetObj){
				var HeadTitle="SEQ|Invoice No|Net Amount|Tax Amount|Total Amount";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"inv_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"net_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"tax_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"tot_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
	       
		      	InitColumns(cols);

		      	SetEditable(0);
		      	SetCountPosition(0);
		      	resizeSheet(0);
		}
		break;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[1]);
}

/** 
 * Event handler processing by button name 
 */
function processButtonClick(){
	var formObj=document.form;
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_close":
				ComClosePopup();
				break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	switch(sAction) {
	    case IBSEARCH:		//Retrieve
			formObj.f_cmd.value=SEARCH;
			sheetObject.DoSearch("ESM_AGT_0043GS.do", agtQryStr(formObj) );
			
			formObj.f_cmd.value=SEARCH01;
			sheetObject1.DoSearch("ESM_AGT_0043GS.do", agtQryStr(formObj) );
		break;
	}
}


function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;
	var sheetObject=sheetObjects[0];
    if (ErrMsg != "") return;
    with (sheetObj) {

    	formObj.ofccd.value=sheetObject.GetCellValue(1, "tj_ofc_cd");
		formObj.confdt.value=sheetObject.GetCellValue(1, "inv_dt");
		formObj.vndrno.value=sheetObject.GetCellValue(1, "vndr_seq");
		formObj.vndrnm.value=sheetObject.GetCellValue(1, "vndr_locl_lang_nm");
		formObj.cnt.value=sheetObject.GetCellValue(1, "attr_ctnt1");
		formObj.currcd.value=sheetObject.GetCellValue(1, "csr_curr_cd");
		formObj.totamt.value=ComAddComma2(sheetObject.GetCellValue(1, "csr_amt"), "#,###.00");
		formObj.paydt.value=sheetObject.GetCellValue(1, "inv_term_dt");
		formObj.asano.value=sheetObject.GetCellValue(1, "attr_ctnt2");
    	
    }
}
