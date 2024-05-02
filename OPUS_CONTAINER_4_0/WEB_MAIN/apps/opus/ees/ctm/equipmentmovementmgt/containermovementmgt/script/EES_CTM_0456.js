/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0456.js
*@FileTitle  : Pre-booked VL/VD Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
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
    var frmObj=document.form;
    var sheetObj=sheetObjects[0];
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Calendar":
                var cal=new ComCalendarFromTo();
                cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                break;
            case "btn_Delete":
                with(sheetObj) {
                    var chkRows=FindCheckedRow("Sel");
                    var arr=chkRows.split("|");
                    if (arr.length > 0) {
                        for (i=0; i<arr.length; i++) {
                            SetRowHidden(arr[i],1);// hiding selected row
                            SetRowStatus(arr[i],"D");// changing selected row's status to 'D' for deleting
                        }
                    }
                }
                break;
            case "btn_Retrieve":
                if (!checkFormField()) return;
                doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                break;
            case "btn_New":
                ComResetAll();
                p_yard2.RemoveAll();
                break;
            case "btn_Save":
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                doActionIBSheet(sheetObj, frmObj, IBSAVE);    
                ComOpenWait(false);
                sheetObj.SetWaitImageVisible(1);
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
function setSheetObject(sheetObj){
   sheetObjects[sheetCnt++]=sheetObj;
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
    // CTM-COMMON (& exception)
    setEventProcess("yd_cd_disp");
    //axon_event.addListener("keypress", "obj_keypress", "yd_cd_disp");
    axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");
    // focusing on page loading
    document.form.p_date1.focus();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    with(sheetObj){
        var headTitle="|Seq.||Container No.|T/S|STS|Origin YD|Event Date|VVD|Booking No.|Booking No.|B/L No.|F/M|Pre-booked Date|Office|User Name|Remark(s)|";
        var headCount=ComCountHeadTitle(headTitle);
        SetEditEnterBehavior("tab");
        
        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
        
        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        var headers = [ { Text:headTitle, Align:"Center"} ];
        InitHeaders(headers, info);
        
        var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                    {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ts",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"status",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"org_yard",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"event_dt",      KeyField:1,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"bkg_knt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"fm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"prebkg_dt",     KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:16 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"office",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"user_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                    {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                    {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"org_event_dt" } ];
                               
        InitColumns(cols);
        
        SetEditable(1);
        SetDataAutoTrim(1);
        //SetColProperty("event_dt", {Format:"####-##-## ##:##"} );
        SetCountPosition(0);
//        SetSheetHeight(442);
        resizeSheet();
    }

}
// handling process for Sheet
function doActionIBSheet(sheetObj, frmObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:   
            if (validateForm(sheetObj, frmObj, sAction)) {
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                if (frmObj.error.checked) {
                    frmObj.error_status.value=frmObj.error.value;
                } else {
                    frmObj.error_status.value="";
                }
                frmObj.f_cmd.value=SEARCH;
                sheetObj.DoSearchFx("EES_CTM_0456GS.do", FormQueryString(frmObj) );
            }
            break;
        case IBSAVE:        
            if(validateForm(sheetObj, frmObj, sAction)) {
                frmObj.f_cmd.value=MULTI;
                sheetObj.DoSave("EES_CTM_0456GS.do", FormQueryString(frmObj), "Sel");
            }
            break;
    }
}
/**
 * handling OnKeyUp event in HTML Object
 */
function obj_onkeyup(event) {
    srcValue=event.srcElement.value;    
    var frmObj=document.form;
    var sheetObj=sheetObjects[0];
    switch(ComGetEvent("name")) {
        case "yd_cd_disp":
        // handling by length of inputted value in yd_cd_disp
            var ydCdDisp=frmObj.yd_cd_disp;
            if (ydCdDisp.value.length > 0) {
                frmObj.p_yard1.value=ydCdDisp.value.toUpperCase();
                if (ydCdDisp.value.length > 4) {
                    // calling yard_search() in CTM common function in case p_yard1 is 5 characters
                    if (!yard_search()) {
                          ydCdDisp.select();
                          ydCdDisp.focus();
                    } else {
                          //p_yard2.focus();
                    }
                } else {
                    p_yard2.RemoveAll();
                }
            } else {
                frmObj.p_yard1.value="";
                p_yard2.RemoveAll();
            }
            break;
    }
    onShowErrMsg=false;
}
/**
 * handling OnSearchEnd event in Sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    sheetObj.SetWaitImageVisible(1);
}
 /**
  * event when clicking cell in IBSheet data part
  * @param {sheetObj} String :  IBSheet cell name
  * @param {Row} Long : cell Row Index
  * @param {Col} Long : cell Column Index
  * @param {Value} String : changed value
  * @param {CellX} Long : cell x-coordinate
  * @param {CellY} Long : cell y-coordinate
  * @param {CellW} Long : cell width
  * @param {CellH} Long : cell length
  */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    if (sheetObj.ColSaveName(Col) != "Sel") {
        with(sheetObj) {
            var sRowStr=GetSelectionRows("/");
            var arr=sRowStr.split("/");
            if (arr.length > 1) {
                for (i=0; i<arr.length; i++) {
                    if (GetCellEditable(arr[i], "Sel")) {
                        SetCellValue(arr[i], "Sel","1",0);
                    }
                }
            }
        }
    }
}
/**
 * handling OnChagne event in Sheet
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
    var frmObj=document.form;
    with (sheetObj) {
        var cellval=GetCellValue(Row, Col).trim();
        switch(ColSaveName(Col)) {
            case "event_dt":
                if (cellval != GetCellValue(Row, "org_event_dt")) {
                    var tmpDatetime=cellval.substring(0, 8) + " " + cellval.substring(8, 12);
                    if (!ComIsDateTime(tmpDatetime, "", "hm")) {
                        ComShowCodeMessage("CTM00001");
                        SetCellValue(Row, Col,GetCellValue(Row, "org_event_dt"),0);
                        SetCellValue(Row, "Sel","",0);
                        SelectCell(Row, Col);
                        return;
                    }
                }
                break;
        }
        if (ColSaveName(Col) != "Sel") {
            SetCellValue(Row, "Sel","1",0);
        }
    }
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if (ErrMsg == "") {
        ComShowCodeMessage("CTM10022", "Pre-booked VL/VD Correction");
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, frmObj, sAction){
    with(frmObj){
    }
    return true;
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}