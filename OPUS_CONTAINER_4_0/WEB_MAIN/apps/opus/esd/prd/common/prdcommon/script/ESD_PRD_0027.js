// Common global variable 
var ipageNo = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
            case "btn_ok":
            	if(sheetObject.CheckedRows("checkbox") > 3) {
            		return;
            	}
    	    	comPopupOK();
                break;
            case "btn_close":
                ComClosePopup();
                break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage(sDisplay) {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var DisplayArr = sDisplay.split(",");
    for(var i=0 ; i < DisplayArr.length ; i++ ){
    	if( DisplayArr[i] == "0") {
    		sheetObjects[0].SetColHidden(i, true);
    	} 
    }     
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    switch(sheetNo) {
        case 1:  
        	with (sheetObj) {
				var HeadTitle = "||Code|Value";
				SetConfig({ SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 1 });
				var info = { Sort : 1, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
				        {Type:"Radio",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },    
						{Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"intg_cd_val_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"intg_cd_val_dp_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
				];
				InitColumns(cols);
				SetVisible(true);
				ComResizeSheet(sheetObj);
			}
            break;
    }
}
/**
 * 
 * @param sheetObj
 * @param Row
 */
function sheet1_OnRowSearchEnd(sheetObj, Row) { 
	var selVal = document.form.select_val.value;
	if(selVal.indexOf(sheetObj.GetCellValue(Row, 'intg_cd_val_ctnt')) > -1)  {
		sheetObj.SetCellValue(Row, 'checkbox', 1)
	}
}

// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: 
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_PRD_0027GS.do", PrdFQString(formObj));
			break;
	}
}
