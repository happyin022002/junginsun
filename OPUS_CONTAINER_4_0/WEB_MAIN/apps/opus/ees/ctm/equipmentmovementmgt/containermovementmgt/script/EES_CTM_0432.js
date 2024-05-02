/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0432.js
*@FileTitle  : Detail Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_close":
                document.form.unload_flag.value="reset";
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
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    with (sheetObjects[0]) {
        DataInsert();
        DataInsert();
        DataInsert();
        DataInsert();
        DataInsert();
        SetCellBackColor(1, 0,"#E8EFF9");
        SetCellValue(1, 0,"OK");
        SetCellValue(1, 1,ComAddComma(document.form.ok_count.value));
        SetCellBackColor(2, 0,"#E6B4B4");
        SetCellBackColor(2, 1,"#FAD2D2");
        SetCellFont("FontBold", 2, 0, 2, 1, 1);
        SetCellValue(2, 0,"Error");
        SetCellValue(2, 1,ComAddComma(document.form.error_count.value));
        SetCellBackColor(3, 0,"#E8EFF9");
        SetCellValue(3, 0,"Ignored");
        SetCellValue(3, 1,ComAddComma(document.form.ignored_count.value));
        SetCellBackColor(4, 0,"#E8EFF9");
        SetCellValue(4, 0,"Deleted");
        SetCellValue(4, 1,ComAddComma(document.form.deleted_count.value));
        SetCellBackColor(5, 0,"#E8EFF9");
        SetCellFont("FontBold", 5, 0, 5, 1, 1);
        SetCellValue(5, 0,"Total");
        SetCellValue(5, 1,ComAddComma(document.form.total_count.value));
    }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //t1sheet1 init
            with(sheetObj){
                var HeadTitle="title";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"}];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"Title",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"Content",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
                InitColumns(cols);
                
                SetEditable(0);
                SetCountPosition(0);
                SetRowHidden(0, 1);
                SetDataRowHeight(23);
//                SetSheetHeight(106);
                resizeSheet();
            }

            break;
    }
}
/**
 * event when double clicking cell in IBSheet data part
 * @param {sheetObj} String :  IBSheet cell name
 * @param {Row} Long : cell Row Index
 * @param {Col} Long : cell Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : cell x-coordinate
 * @param {CellY} Long : cell y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell length
 */
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    if (Row == 2 && sheetObj.GetCellValue(2, 1) > 0) {
        document.form.unload_flag.value="errorView";
        ComClosePopup(); 
    }
}
/**
 * event when moving mouse in IBSheet
 * @param {sheetObj} Integer : IBSheet cell
 * @param {Button} Long : mouse button, 1:left, 2:right
 * @param {Shift} Integer : 1 in case of Shift, 2 in case of Ctrl, other cases are 0
 * @param {X} Long : x-coordinate
 * @param {Y} Long : y-coordinate
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    if (sheetObj.MouseRow()== 2 && sheetObj.GetCellValue(2, 1) > 0) {
        sheetObj.SetMousePointer("Hand");
    } else {
        sheetObj.SetMousePointer("Default");
    }
}
/**
 * handling OnUnLoad evnet in HTML Object
 */
function unloadPage(value) {
    var opener=window.dialogArguments;
    if (value == "errorView") {
        document.form.unload_flag.value="";
        opener.popup0432Function("errorView");
    } else if (value == "reset") {
        document.form.unload_flag.value="";
        opener.popup0432Function("reset");
    }
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}
