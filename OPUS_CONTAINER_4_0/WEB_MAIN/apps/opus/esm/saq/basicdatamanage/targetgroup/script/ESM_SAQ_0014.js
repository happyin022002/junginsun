/*=========================================================
 * *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0014.js
*@FileTitle  : TargetGroup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_SAQ_0014 : business script for  ESM_SAQ_0014.
 */
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
// Event handler processing by button click event */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[0];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;
            case "btn_save":
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;
            case "btn_downexcel":
                doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                break;
            case "btn_rowadd":
                doActionIBSheet(sheetObject, formObject, IBINSERT);
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(getMsg("COM12111"));
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
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        //khlee-마지막 환경 설정 함수 추가
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
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
				SetFocusEditMode(default_edit_mode);
				var HeadTitle="Del.|STS|SEQ|Target Group|Organization|Description|Disable" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"DelCheck",  Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Status",    Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Seq",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"saq_tgt_grp_cd",    KeyField:1,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2,   AcceptKeys:"E", InputCaseSensitive:1},
				{Type:"PopupEdit", Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6,   AcceptKeys:"E", InputCaseSensitive:1},
				{Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"saq_tgt_grp_desc",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				{Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1,   AcceptKeys:"E"  } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetColProperty("delt_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				//SetSheetHeight(585);
				resizeSheet();
			}
		break;
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

// handling sheet1 process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //search
            if (ComIsModifiedSheets(sheetObj)) {
                //Used in case of checking from changing sheet
                if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                    return;
                }
            }
            formObj.f_cmd.value = SEARCHLIST;
            sheetObj.DoSearch("ESM_SAQ_0014GS.do", saqFormString(formObj));
            break;
            
        case IBSAVE: //save
            var tran_rows = sheetObj.FindStatusRow("I|U");
            if (!checkFormat(sheetObj, tran_rows)) {
                return false;
            }
			
            // Target Group Duplicate 체크
            var Row = sheetObj.ColValueDup("saq_tgt_grp_cd", false);
            if (Row != -1) {
                ComShowCodeMessage("COM131302", "Target Group");
                return;
            }
            
            // Organization Duplicate 체크
    //        var nRow = sheetObj.ColValueDup("ofc_cd", false);           
//            if (nRow != -1) {
//                ComShowCodeMessage("COM131302", "Organization");
//                return;
//            }

            formObj.f_cmd.value = MULTI;
            //sheetObj.DoSave("ESM_SAQ_0014GS.do", saqFormString(formObj));
            var rtn = doSaveSheet(sheetObj, "ESM_SAQ_0014GS.do", saqFormString(formObj));
            break;
            
        case IBINSERT: // input
            var Row = sheetObj.DataInsert();
            sheetObj.SetCellValue(Row, "delt_flg", "N", 0);
            sheetObj.SelectCell(Row, 3, true, "");
            break;
        case IBCOPYROW: //row copy
            sheetObj.DataCopy();
            break;
        case IBDOWNEXCEL: //excel download
            selectDownExcelMethod(sheetObj);
            break;
        case IBLOADEXCEL: //excel upload
            sheetObj.LoadExcel();
            break;
    }
}

function callBackExcelMethod(excelType) {
    var sheetObj = sheetObjects[0];
    if (sheetObj.RowCount() < 1) { //no data
        ComShowCodeMessage("COM132501");
        return;
    }
    DownExcel(sheetObj, excelType);
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg){
       if(isExceedMaxRow(msg))return; //2014-04-22 공통 요청사항(10,000 Row 제어)
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {}
    return true;
}

/**
 * handling process for input validation
 */
function checkFormat(sheetObj, trans_rows) {
    var arrRow = trans_rows.split(";");
    
    for (var idx = 0; idx < arrRow.length - 1; idx++) {
        var target_cd = sheetObj.GetCellValue(arrRow[idx], 3);
        if (target_cd == "") {
            ComShowMessage(getMsg("SAQ90117", "Target Group"));
            sheetObj.SelectCell(arrRow[idx], 3, true);
            return false;
        }
    }
    return true;
}


/**
 * handling process for input validation
 */
function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    if (Col == 3) {
        if (Value == "") {
            ComShowMessage(getMsg("SAQ90117", "Target Group"));
            ValidateFail(true);
            SelectCell(Row, Col + 1);
        }
    }
}

/**
 * handling event in case of clicking Sheet
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
    if (sheetObj.ColSaveName(col) == "ofc_cd") {
        var office_cd = sheetObj.GetCellValue(row, col);
        saqPopup("SalesOffice", "ofc_cd=" + office_cd, 800, 500, "setSheet1PopUpValue", dispaly, row, col);
    }
}

/* setting variable */
function setSheet1PopUpValue(rowArray, row, col) {
    var sheetObj = sheetObjects[0];
    var colArray = rowArray[0];
    sheetObj.SetCellValue(row, col, colArray[3], 0);
    sheetObj.SetCellValue(row, parseInt(col) + 1, colArray[4], 0);
}