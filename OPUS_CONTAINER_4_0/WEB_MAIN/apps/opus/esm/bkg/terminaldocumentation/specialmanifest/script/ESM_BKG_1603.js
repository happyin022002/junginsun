/*=========================================================
* *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_1603.js
*@FileTitle : EU DG Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/12/11
=========================================================*/

 // global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {     
    var sheetObject = sheetObjects[0];     
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
                
            case "btn_save":
                doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;
                
            case "btn_add":
                var row = sheetObject.DataInsert();
                break;
                
            case "btn_delete":
                ComRowHideDelete(sheetObject, "delChk"); 
                break;
                
            case "btn_DownExcel":
                doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                break;
                
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage("COM12111");
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":      //sheet1 init
		with(sheetObj){		
			var HeadTitle="||Port|Vessel Operator|Send Stow|Discharge|Transit|Load";
			var headCount=ComCountHeadTitle(HeadTitle);			
			
			SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:0 } );			
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",	Hidden:1, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			 {Type:"DummyCheck",   	Hidden:0,  Width:40,     Align:"Center",  ColMerge:0,   SaveName:"delChk",         	KeyField:0,   CalcLogic:"",   Format:"",     	   	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },					 
			 {Type:"Text",      			Hidden:0,  Width:200,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",         	KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1},
			 {Type:"Text",      			Hidden:0,  Width:200,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",            KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:3, AcceptKeys:"E|N", InputCaseSensitive:1},
			 {Type:"Combo",   			Hidden:0,  Width:200,   Align:"Center",  ColMerge:0,   SaveName:"stwg_flg",        	KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Combo",   			Hidden:0,  Width:200,   Align:"Center",  ColMerge:0,   SaveName:"dchg_cd",         	KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Combo",   			Hidden:0,  Width:200,   Align:"Center",  ColMerge:0,   SaveName:"tz_cd",            	KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Combo",   			Hidden:0,  Width:200,   Align:"Center",  ColMerge:0,   SaveName:"lod_cd",         	KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1 }					
			];
			
			InitColumns(cols);
			SetEditable(1);
			SetColProperty("stwg_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
			SetColProperty("lod_cd", {ComboText:"Container Line Allowed|Vessel Operator Allowed", ComboCode:"C|V"} );
			SetColProperty("tz_cd", {ComboText:"Container Line Allowed|Vessel Operator Allowed", ComboCode:"C|V"} );
			SetColProperty("dchg_cd", {ComboText:"Container Line Allowed|Vessel Operator Allowed", ComboCode:"C|V"} );
			
			resizeSheet();
			//SetSheetHeight(480);
		}
		break;
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

function doActionIBSheet(sheetObj, formObj, sAction) {
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
            	return false;
            }
            
            formObj.f_cmd.value = SEARCH01;
            sheetObj.DoSearch("ESM_BKG_1603GS.do", FormQueryString(formObj));
            break;
            
        case IBSAVE: //SAVE
            if (!validateForm(sheetObj, formObj, sAction)) {
            	return false;
            }            
            ComOpenWait(true);
            sheetObj.DoSave("ESM_BKG_1603GS.do", "f_cmd=" + MULTI01);
            ComOpenWait(false);            
            break;
        
        case IBSEARCHAPPEND:  // Scrolling
		 formObj.f_cmd.value=SEARCH01;              
		 sheetObj.DoSearch("ESM_BKG_1603GS.do", FormQueryString(formObj)+"&"+ "iPage=" + PageNo,{Append:true} );
		 break;	
        
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) {
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1} );
            }
            break;
    }
}

function sheet1_OnScrollNext(sheet, CondParam, PageNo, OnePageRows) {
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
        case SEARCH01:
//            if (comObjects[0].GetSelectCode() == "") {
//                ComShowCodeMessage("COM132501");                
//                comObjects[0].Focus();
//                return false;
//            }
            break;
        
        case IBSAVE:
            var rowCnt = sheetObj.RowCount();
            for (var i=1;  i < rowCnt+1; i++) {
            	if (sheetObj.GetCellValue(i, "port_cd").length == 0){
            		sheetObj.SelectCell(i, "port_cd");	
            		ComShowCodeMessage("COM132201", "Port");            		
            		return false;
            	}
            	
            	if (sheetObj.GetCellValue(i, "crr_cd").length == 0){
            		sheetObj.SelectCell(i, "crr_cd");
            		ComShowCodeMessage("COM132201", "Vessel Operator");            		
            		return false;	
            	}
           	}           
            
            var Row = sheetObj.ColValueDup("port_cd|crr_cd", 1);           
			if(Row > 0){		
				ComShowCodeMessage("COM131301", "Port and Operator");     
				sheetObj.SelectCell(Row, "port_cd");		
				return false;
			}			
            break;
    }
    return true;
}
