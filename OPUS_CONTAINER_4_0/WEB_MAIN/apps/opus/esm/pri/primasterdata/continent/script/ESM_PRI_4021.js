/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4021.js
*@FileTitle  : Continent-Subcontinent Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variables
var sheetObjects=new Array();
var sheetCnt=0;

//Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name  <br>
 */
function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var sheetObject2=sheetObjects[1];
     /*******************************************************/
     var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
            case "btn_Retrieve":
                alert(srcName);
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
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items  <br>
 * defining list on the top of source <br>
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * Initializing and setting Sheet basics <br>
 * Setting body tag's onLoad event handler <br>
 * Adding pre-handling function after loading screen on the browser  <br>
 */
function loadPage() {
     for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    pageOnLoadFinish();
}

/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetId=sheetObj.id;
    switch(sheetId) {
        case "sheet1":
            with(sheetObj){
                var HeadTitle1="Seq.|Continent|Continent";
                var HeadTitle2="Seq.|Code|Description";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",       KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"conti_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"conti_nm",  KeyField:0,   CalcLogic:"",   Format:"" } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
//                SetCountPosition(0);
                SetWaitImageVisible(0);
                SetAutoRowHeight(0);
                resizeSheet();//SetSheetHeight(250);
        }

        break;
        case "sheet2":
            with(sheetObj){
                var HeadTitle1="Seq.|Sub-Continent|Sub-Continent";
                var HeadTitle2="Seq.|Code|Description";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",        KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sconti_nm",  KeyField:0,   CalcLogic:"",   Format:"" } ];
                                                       
                InitColumns(cols);
                
                SetEditable(0);
//                SetCountPosition(0);
                SetWaitImageVisible(0);
                SetAutoRowHeight(0);
                resizeSheet();//SetSheetHeight(250);
        }

        break;
    }
}
function resizeSheet(){ ComResizeSheet(sheetObjects[0]); ComResizeSheet(sheetObjects[1]); }

/**
 * Handling sheet process <br>
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH01;
            sheetObj.DoSearch("ESM_PRI_4021GS.do", FormQueryString(formObj) );
            break;
        case IBSEARCH_ASYNC01:
            var contiCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "conti_cd");
            formObj.f_cmd.value=SEARCH02;
            sheetObj.DoSearch("ESM_PRI_4021GS.do", FormQueryString(formObj)+"&conti_cd="+contiCd );
            ComOpenWait(false);
            break;
    }
}

/**
 * calling function when occurring OnClick Event <br>
 */
function sheet1_OnClick(sheetObj, Row, Col) {
    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
}

/**
 * calling function when occurring OnSearchEnd Event <br>
 */     
function sheet1_OnSearchEnd(sheetObj, errMsg)  {
    if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
    }
}

/**
 * calling function when Page Loading <br>
 */ 
function pageOnLoadFinish() {
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
