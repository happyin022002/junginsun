/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0942.js
*@FileTitle  : Inbound C/S Screen_Inquiry Pop up1(Multi container No Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
    

// Event handler processing by button click event  */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn1_Close":
                ComClosePopup(); 
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
* @param sheet_obj IBSheet Object
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
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }    
    SheetGetData();
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
* @param sheetObj sheet Object
* @param sheetNo 
*/
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetId=sheetObj.id;
    switch(sheetId) {
        case "sheet1":
            with(sheetObj){
                var HeadTitle1="|SEQ||B/L No.|CNEE Name|Bkg No.|B/L Type|SPLIT FLG";
                
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                             {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"radio",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cstms_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"split_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                
                InitColumns(cols);
                
                SetEditable(1);
                SetCountPosition(0);
                SetColHidden("radio",1);
                SetDataLinkMouse("mst_cvrd_bl_no",1);
                SetDataLinkMouse("cntr_cmdt_desc",1);
                SetDataLinkMouse("bkg_no",1);
                SetSheetHeight(130);
            }
            break;
    }
}
/**
 * Sheet process handling
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {
        case IBSEARCH:      //Retrieve
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESM_BKG_0942GS.do",FormQueryString(formObj) );
            break;
    }
}
/**
 * Sheet1 double click event handling
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col){
    sheetObj.SetCellValue(Row, "radio",1);
    comPopupOK();
}
/**
 * Get data from opener sheet
 */
function SheetGetData() {
    //
    var win=(opener||parent);
    var sXml=win.form.xmlData.value;
    sheetObjects[0].LoadSearchData(sXml);
}
/**
 * Set data from opener sheet
 */     
function SheetSetData() {
    //
    var win=(opener||parent);
    win.sheetObjects[3].RemoveAll();
    win.sheetObjects[3].LoadSearchData(IBS_GetDataSearchXml(sheetObjects[0]));

}      
