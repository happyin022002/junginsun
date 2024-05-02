/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0421.js
*@FileTitle  : Restuffing Reason
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
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
    var sheetObj=sheetObjects[0];
    var frmObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_excel":
                sheetObj.SetWaitImageVisible(0);
                if(sheet1.RowCount() < 1){//no data
                  ComShowCodeMessage("BKG00109");
                }else{
                  sheet1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
                }
                sheetObj.SetWaitImageVisible(1);
                break;
            case "btn_add":
                sheetObj.DataInsert();
                break;
            case "btn_del":
                var sRowStr=sheetObj.FindCheckedRow("del_chk");
                // making javascript array
                var arr=sRowStr.split("|");
                for (i=arr.length  ; i >= 0; i--) {
                    if (sheetObj.GetRowStatus(arr[i]) == "I") {
                      sheetObj.RowDelete(arr[i], false);    // changing selected row's status to 'D' for deleting
                    } else {
                      sheetObj.SetRowStatus(arr[i],"D");// changing selected row's status to 'D' for deleting
                      sheetObj.SetRowHidden(arr[i],1);// hiding selected row
                    }
                }
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
            ComShowMessage(e);
        }
    }
}

/**
 * registering IBCombo Object as list
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
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    // CTM-COMMON
    setEventProcess();
    // retrieving when loading the page
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //t1sheet1 init
            with(sheetObj){
                SetSelectionMode(smSelectionList);
                var HeadTitle="|Chk.|Seq.|Code|Abbreviation|Description";
                SetEditEnterBehavior("tab");
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [{Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",      KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"xch_rsn_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"xch_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
                            {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"xch_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 } ];
                
                InitColumns(cols);
                
                SetEditable(1);
                SetDataAutoTrim(1);
                

                SetColProperty(0 ,"xch_rsn_cd", {AcceptKeys:"E", InputCaseSensitive:1});
                SetColProperty(0 ,"xch_abbr_nm", {AcceptKeys:"E|N|[ -,'/]"});
                SetColProperty(0 ,"xch_desc", {AcceptKeys:"E|N|[ -,'/]"});
                
//                SetSheetHeight(282);
                resizeSheet();
            }

            break;
    }
}

//handling process for Sheet
function doActionIBSheet(sheetObj,frmObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:   
            if (validateForm(sheetObj,frmObj,sAction)) {
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                frmObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("EES_CTM_0421GS.do", FormQueryString(frmObj) );
            }
            break;
        case IBSAVE:        
            if(validateForm(sheetObj,frmObj,sAction)) {
                frmObj.f_cmd.value=MULTI;
                sheetObj.DoSave("EES_CTM_0421GS.do", FormQueryString(frmObj));
            }
            break;
        case IBSEARCH_ASYNC01:      //기준 Officd Code retrieve
            if ( !OfficeCodeMgr.checkContainOfficeCode("000002", "CTM", strOfcCd) ) {   
                    div_ofc1.style.display = "none";
            }else{
                div_ofc1.style.display="";
            }
            break;
    }
}

/**
 * event after saving IBSheet
 * @param {ibsheet} Event       
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    if (ErrMsg == "") {
        ComShowCodeMessage("CTM10022", "Restuffing Reason");
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
}

/**
 * handling OnSearchEnd event in Sheet1
 */
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    sheetObj.SetWaitImageVisible(1);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,frmObj,sAction){
    with(frmObj){
        if(sAction == 2){
            for(i=1; i < sheetObjects[0].RowCount(); i++){
                if(sheetObjects[0].GetCellValue(i,"ibflag") == "I") {
                    var temp_code=sheetObjects[0].GetCellValue(i,"xch_rsn_cd");
                    for(j=1; j < sheetObjects[0].RowCount(); j++)
                    {
                        if(i != j)
                        {
                            var code=sheetObjects[0].GetCellValue(j,"xch_rsn_cd");                         
                            if(code == temp_code){
                                alert('Data is duplicated.');
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return true;
    }
    return true;
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
     if (sheetObj.ColSaveName(Col) != "del_chk") {
         // checking check box when clicking row
         with(sheetObj) {
             var sRowStr=GetSelectionRows("/");
             var arr=sRowStr.split("/");
             if (arr.length > 1) {
                 for (i=0; i<arr.length; i++) {
                     if (GetCellEditable(Row, "del_chk")) {
                         SetCellValue(arr[i], "del_chk","1",0);// checking checkbox for selected row
                     }
                 }
             }
         }
     }
 }
 function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}
 
