/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0123.js
*@FileTitle  : Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
/**
 * @extends 
 * @class ESM_COA_0123 : ESM_COA_0123 Business script for the UI
 */

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
            case "btn_Downexcel":
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
/* Sheet default setting and Initialize */
function loadPage() {
    for (i=0; i<sheetObjects.length; i++) {
    	ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i+1, "");
        ComEndConfigSheet(sheetObjects[i]);
    }
    //SJH.20141222.ADD : 자동조회    
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);  //Inquiry in case of loading
}
/* Initialize sheet and define header info */
function initSheet(sheetObj,sheetNo,header) {
    var cnt=0;
    var HeadTitle="";
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
           
         HeadTitle="STS|Seq|Vessel|Vessel Name|Crr|D.Capa|V.Capa";
         cnt=0;

         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
         var headers = [ { Text:HeadTitle, Align:"Center"} ];
         InitHeaders(headers, info);

         var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibseq" },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_dzn_capa",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_vsl_clss_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0 } ];
          
         InitColumns(cols);
         //no support[check again]CLT style.height=GetSheetHeight(8) ;
//         SetSheetHeight(250);
		 resizeSheet();
         SetEditable(0);
         SetHeaderRowHeight(10);
         }


            break;
    }
}
/* Registering IBSheet Object as list */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
/* Handling process about the sheet object */
function doActionIBSheet(sheetObj,formObj,sAction,PageNo) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:      //Inquiry
            if (!validateCond(formObj)) {
               return false;
            }
            // Prohibit button click when a business transaction is processing 
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			setTimeout( function () {
	            formObj.f_cmd.value=SEARCHLIST;
	             sheetObj.DoSearch("ESM_COA_0123GS.do", coaFormQueryString(formObj) );
	            ComOpenWait(false);
			}, 100);
            break;
        case IBDOWNEXCEL:   // Excell download
            selectDownExcelMethod(sheetObj);
//            switch (excelType) {
//                case "AY":
//                     sheetObj.Down2Excel({ HiddenColumn:0,Merge:true});
//                    break;
//                case "DY":
//                     sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
//                    break;
//                case "AN":
//                     sheetObj.Down2Excel({ HiddenColumn:0});
//                    break;
//                case "DN":
//                     sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(                    sheetObj), SheetDesign:1,Merge:1 });
//                    break;
//            }               
            break;
    }
}
function callBackExcelMethod(excelType) {
	var sheetObj = sheet1;
	if(sheetObj.RowCount() < 1){//no data
		ComShowCodeMessage("COM132501");
		return;
	}
	switch (excelType) {
		case "AY":
			sheetObj.Down2Excel({ HiddenColumn:0,Merge:true, SheetDesign:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			break;
		case "DY":
			sheetObj.Down2Excel({ HiddenColumn:1,Merge:true, SheetDesign:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			break;
		case "AN":
			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
			break;
		case "DN":
			sheetObj.Down2Excel( { HiddenColumn:1, SheetDesign:1,Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });	
			break;
	}
}
/* Handling process for form object input validation */
function validateForm(sheetObj) {
	with(sheetObj){
	}
	return true;
}
/* Handling process for input validation */
function validateCond(formObj) {
	with(formObj){
	}
	return true;
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
