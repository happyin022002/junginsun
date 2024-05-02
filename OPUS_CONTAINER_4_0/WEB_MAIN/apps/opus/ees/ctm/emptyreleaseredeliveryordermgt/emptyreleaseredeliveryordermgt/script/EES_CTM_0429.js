/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0429.js
*@FileTitle  : Release/Redelivery History(Europe)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
    var sheetObj=sheetObjects[0];
    var frmObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_Calendar":
                var cal=new ComCalendarFromTo();
                cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
                break;
            case "btn_retrieve":
                if (!checkFormField()) return;
                doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                break;
            case "btn_new":
                ComResetAll();
                if (comboObjects[0].GetItemCount() > 0) {
                    comboObjects[0].SetSelectIndex(0);
                }
                p_yard2.RemoveAll();
                break;
            case "btn_downExcel":
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(                    sheetObj), SheetDesign:1,Merge:1 });
                ComOpenWait(false);
                sheetObj.SetWaitImageVisible(1);
                break;
            case "btn_recovery":
                if (sheetObj.GetSaveString(false, false, "Sel") == "") {
                    ComShowCodeMessage("CTM30001");
                } else if (ComShowCodeConfirm("CTM30006")) {
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    doActionIBSheet(sheetObj, frmObj, IBSAVE);    //saving
                    ComOpenWait(false);
                    sheetObj.SetWaitImageVisible(1);
                }
                break;
        } // end switch
    } catch(e) {
        if ( e == "[object Error]") {
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
 * registering IBMultiCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
   comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i] );
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    setEventProcess("yd_cd_disp");
    //axon_event.addListener("keypress", "obj_keypress", "yd_cd_disp");
    //axon_event.addListener("keyup", "obj_onkeyup", "yd_cd_disp");
    axon_event.addListener("change", "obj_onchange", "type");
    doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
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
        SetSelectionMode(smSelectionList);
        var HeadTitle="|No.||I.Type|I.Office|Mode|Type|Empty CY|P/D Date|TP";
        HeadTitle += "|Booking No.|Seq.|B/L No.|Container No.|MVMT CNTR|VVD Code|POL|POD|Deleted";
        HeadTitle += "|Deleted Date|W/O No.|Empty R/R Date|User ID|SHPR Name|CNEE Name|NTFY Name|S.Office|S/C No.|RFA No.|Invoice";
        
        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:1 } );
        
        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        InitHeaders(headers, info);
        
        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                    {Type:"Seq",       Hidden:0, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"Seq" },
                    {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"i_type",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"i_office",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mode_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"type_disp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"empty_cy",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pd_date",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tro_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pol",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"deleted",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"deleted_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"wo_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"stk_jb_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"user_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"shpr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cnee",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"ntfy",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"office",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rfa_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_no" },
                    {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bd" },
                    {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"type_cd" },
                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"so_ofc_cty_cd" },
                    {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"so_seq" } ];
                               
        InitColumns(cols);
        
        SetEditable(1);
        SetDataAutoTrim(1);
        SetCountPosition(0);
        SetWaitTimeOut(20000);
//        SetSheetHeight(420);
        resizeSheet();
    }

}
// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    var frmObj=document.form;
    switch (sAction) {
        case SEARCH01:    // retrieving TerritoryList for Multicombo by user office code
            var xml=sheetObj.GetSearchData("EES_CTM_0426GS.do", "f_cmd=" + SEARCH01);
            ComXml2ComboItem(xml, comboObjects[0], "cntr_stk_terr_cd", "cntr_stk_terr_txt");
            if (comboObjects[0].GetItemCount() > 0) {
                comboObjects[0].SetSelectIndex(0);
            }
            break;
        case IBSEARCH:  
            if (validateForm(sheetObj, frmObj, sAction)) {
                sheetObj.RemoveAll();
                if (ComGetDaysBetween(frmObj.p_date1.value, frmObj.p_date2.value) > 14) {
                    ComShowCodeMessage("CTM30012", "15 days");
                    frmObj.p_date1.focus();
                    return;
                }
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
              //  frmObj.office.value=comboObjects[0].GetText(comboObjects[0].GetSelectIndex(), 1);
                frmObj.office.value=comboObjects[0].GetText(parseInt(comboObjects[0].GetSelectIndex()), 1);
                frmObj.f_cmd.value=COMMAND01;
                var sXml=sheetObj.GetSearchData("EES_CTM_0429GS.do", FormQueryString(frmObj));
                var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
                if (backendJobKey.length > 0) {
                    frmObj.backendjob_key.value=backendJobKey;
                    sheetObj.SetWaitTimeOut(20000);
                    timer=setInterval(getBackEndJobStatus, 3000); 
                }
            }
            break;
        case IBSAVE:    
            if (validateForm(sheetObj, formObj, sAction)) {
                frmObj.f_cmd.value=MULTI;
                sheetObj.DoSave("EES_CTM_0429GS.do", FormQueryString(frmObj), "Sel", true);
            }
            break;
    }
}
/**
 * handling OnChange event in HTML Object
 */
function obj_onchange(event) {
    sheetObjects[0].RemoveAll();
    var frmObj=document.form;
    switch(ComGetEvent("name")) {
        case "type":
            if (frmObj.type.value == "I") {    // in case of Redelivery
                sheetObjects[0].SetCellText(0, "MTYDest" ,"Empty Org");
                sheetObjects[0].SetColHidden("qty",1);
                sheetObjects[0].SetColHidden("q_qty",1);
            } else {    // in case of Release 
                sheetObjects[0].SetCellText(0, "MTYDest" ,"Empty Dest");
                sheetObjects[0].SetColHidden("qty",0);
                sheetObjects[0].SetColHidden("q_qty",0);
            }
            break;
    }
    onShowErrMsg=false;
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
            var ydCdDisp=frmObj.yd_cd_disp;
            //var pYard2=document.getElementById("p_yard2");
            if (ydCdDisp.value.length > 1) {
                frmObj.p_yard1.value=ydCdDisp.value.toUpperCase();
                if (ydCdDisp.value.length > 4) {
                      // calling  yard_search() in case of 5 characters in p_yard1
                      if (!yard_search()) {
                            ydCdDisp.select();
                            ydCdDisp.focus();
                      } else {
                            //frmObj.p_yard2.focus();
                      }
                } else {
                    pyard2.RemoveAll();
                }
            } else {
                frmObj.p_yard1_text.value="";
                pyard2.RemoveAll();
            }
            break;
    }
    onShowErrMsg=false;
}
/**
 * handling OnSearchEnd event in Sheet
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    if (ErrMsg == "") {
        with (sheetObj) {
            //RenderSheet(0);
            for (var i=1; i<RowCount()+1; i++) {
                if (GetCellValue(i, "inv_no") != "") {
                    SetRowEditable(i,0);
                }
            }
            //RenderSheet(1);
        }
    }
    sheetObj.SetWaitImageVisible(1);
}

function sheet1_OnDownFinish(sheetObj, downloadType, result) {
    ComOpenWait(false);
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
    if(Code == 0){
        ComShowCodeMessage("COM132601");
    }
}

/**
 * event when clicking cell in IBsheet data part
 * @param {sheetObj} String :  IBSheet cell name
 * @param {Row} Long : cell Row Index
 * @param {Col} Long : cell Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : cell x-coordinate
 * @param {CellY} Long : cell y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell height
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    if (sheetObj.ColSaveName(Col) != "Sel") {
        with(sheetObj) {
            var sRowStr=GetSelectionRows("/");
            var arr=sRowStr.split("/");
            if (arr.length > 1) {
                //RenderSheet(0);
                for (i=0; i<arr.length; i++) {
                    if (GetCellEditable(arr[i], "Sel")) {
                        SetCellValue(arr[i], "Sel","1",0);
                    }
                }
                //RenderSheet(1);
            }
        }
    }
}
/**
 * @param {ibsheet} Event       
 * event after saving IBSheet 
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if (ErrMsg == "") {
        ComShowCodeMessage("CTM10022", "Release/Redelivery History");
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
}
/**
 * handling OnKeyDown event in territory[combo0] Object
 */
function territory_OnKeyDown(comboObj, KeyCode, Shift) {
    if (KeyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}
/**
 * handling OnKeyDown event in p_yard2[combo1] Object
 */
function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
    if (KeyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}
/**
 * calling BackEndJob 
 */
function getBackEndJobStatus() {
    frmObj=document.form;
    var sheetObj=sheetObjects[0];
    frmObj.f_cmd.value=SEARCH;
    var sXml=sheetObj.GetSearchData("EES_CTM_0429GS.do", FormQueryString(frmObj));
    var jobState=ComGetEtcData(sXml, "jb_sts_flg")
    // alert("sheet1 :::>> jobState : "+jobState);
    if (jobState == "3") {
        getBackEndJobLoadFile();
        clearInterval(timer);
    } else if (jobState == "4") {
        ComOpenWait(false);
        // BackEndJob failed
        ComShowCodeMessage('CTM10024');
    } else if (jobState == "5") {
        ComOpenWait(false);
        ComShowCodeMessage('CTM10024');
    }
}
/**
* after end of BackEndJob, loading result in sheet
*/
function getBackEndJobLoadFile() {
    frmObj=document.form;
    frmObj.f_cmd.value=SEARCHLIST;
    sheetObjects[0].DoSearch("EES_CTM_0429GS.do", FormQueryString(frmObj) );
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction){
    with(formObj){
    }
    return true;
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}