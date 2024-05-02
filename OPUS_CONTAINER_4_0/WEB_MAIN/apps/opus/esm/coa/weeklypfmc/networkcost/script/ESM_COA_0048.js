/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0048.js
*@FileTitle  : Trunk IPC Internal Pricing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
//Grobal Variable
var sheetObjects=new Array();
var sheetCnt=0;

/* Event handler processing by button click event */
document.onclick=processButtonClick;

function processButtonClick(){
    var sheetObject=sheetObjects[0];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_Retrieve":        //Inquiry
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
            case "btn_Save":            //Save
                doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
        }
    } catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(ComGetMsg("COM12111", "", ""));
        } else {
            ComShowMessage(e);
        }
    }
}
function loadPage(){
    for(i=0;i<sheetObjects.length;i++){
        //Sheet configuration setting function(start)
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        //Sheet configuration setting function(end)
        ComEndConfigSheet(sheetObjects[i]);
    }
    // Default YYYY-MM
    var nowYear=ComGetNowInfo("yy");
    var nowMon=ComGetNowInfo("mm");
    if ( nowMon.length == 1 ) nowMon="0" + nowMon; // conversion : 1month -> 01month 
    var nowYrMon=nowYear + "-" + nowMon;
    document.form.f_cost_yrmon.value=nowYrMon;
}
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:     //sheet1 init
            with(sheetObj){
              var HeadTitle="STS|No.|YYYY-MM|Trade|Unit Cost";
              var cnt=0;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrmon",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inter_prc_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);
//              SetSheetHeight(430) ;
			  resizeSheet();
            }
            break;
    }
}
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    sheetObj.SetWaitImageVisible(0);//  Prohibit button click when a business transaction is processing
    switch(sAction) {
        case IBSEARCH:      //Inquiry
            if (!validateCond(formObj)) {
                return false;
            }
            // Prohibit button click when a business transaction is processing 
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCHLIST;
            sheetObj.DoSearch("ESM_COA_0048GS.do", coaFormQueryString(formObj) );
//            ComOpenWait(false);
            break;
        case IBSAVE:        //Save
            if(validateCond(formObj)){
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI01;
                sheetObj.DoSave("ESM_COA_0048GS.do", coaFormQueryString(formObj,'f_cmd',true), -1, false);
                ComOpenWait(false);
            }
            break;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    if(Code == 0){
        ComShowCodeMessage("COM132601");
    }
}

/**
 * Handling process for input validation
 */
function validateCond(formObj) {
    var rt=false;
    with(formObj){
        if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
            ComShowCodeMessage('COA10002','YYYY-MM');
            ComSetFocus(formObj.f_cost_yrmon);
        } else {
            rt=true;
        }
    }
    return rt;
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}
/* Developer's task ends */
