/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_1001.js
*@FileTitle  : CNTR MVMT Sequence
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
/****************************************************************************************
  Event Define Code: [Initiate]INIT=0; [Insert]ADD=1; [Search]SEARCH=2; [Search List]SEARCHLIST=3;
                    [Modify]MODIFY=4; [Remove]REMOVE=5; [Remove List]REMOVELIST=6 [Multi]MULTI=7
                    Other Character Constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/   
// Common Global Variable
var sheetObjects=new Array();
var sheetCnt=0;
// Define Event Handler handling event by receiving Button-click event */
 document.onclick=processButtonClick;
// Event Handler assorting events by Button name  */
function processButtonClick(){
    var sheetObj=sheetObjects[0];
    var frmObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_excel":
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                if(sheetObj.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
                }
                sheetObj.SetWaitImageVisible(1);
                break;
            case "btn_add":
                sheetObj.DataInsert(-1);
                break;
            case "btn_del":
                 var sRowStr=sheetObj.FindCheckedRow("del_chk");
                 if (sRowStr == "") {
                     ComShowCodeMessage("CTM30001"); 
                     return ;
                 }
                 var arr=sRowStr.split("|");
                    for (i=arr.length; i >= 0; i--) {
                      if (sheetObj.GetRowStatus(arr[i]) == "I") {
                          sheetObj.RowDelete(arr[i], false);	// delete 수정 by 2015/06/05 황미연
                      } else {
                          sheetObj.SetRowStatus(arr[i],"D");// Changing status of selected row as "D" to delete
                          sheetObj.SetRowHidden(arr[i],1);// Hiding seleted row
                      }
                 }
                break;
           case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
           case "btn_Save":
                for (var i=1; i<=sheetObj.LastRow(); i++){
                    var tmpIbFlag=sheetObj.GetCellValue(i, "ibflag");
                    if(tmpIbFlag == 'I') {
                        var bkgCgoTp=sheetObj.GetCellValue(i, "bkg_cgo_tp_cd");
                        var mvmtStsCd=sheetObj.GetCellValue(i, "mvmt_sts_cd");
                        for (var j=1; j<=sheetObj.LastRow(); j++){
                            var tmpBkgCgoTp=sheetObj.GetCellValue(j, "bkg_cgo_tp_cd");
                            var tmpMvmtStsCd=sheetObj.GetCellValue(j, "mvmt_sts_cd");
                            if(i != j && tmpBkgCgoTp == bkgCgoTp && tmpMvmtStsCd == mvmtStsCd)
                            {
                                ComShowCodeMessage("CTM30011", "Data");
                                return ;
                            }
                        }
                   }
               }
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                doActionIBSheet(sheetObj, frmObj, IBSAVE);
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
 * Registering IBSheet Object to Array
 * Process saving as Array can be added in case of handling other items in batch processing
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Basic Sheet setting and initializing 
 * Implement onLoad Event Handler of body tag
 * Adding first-served function 
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    // CTM-COMMON
    setEventProcess();
    // Retrieving when page loading
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * Initiated sheet value, Define header
 * param : sheetObj ==> sheet object, sheetNo ==> serial number corresponding to sheet object tag
 * In case of multi-sheet, add case as amount of sheets 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //t1sheet1 init
            with(sheetObj){
                SetSelectionMode(smSelectionList);
                var HeadTitle="|Chk.|Seq.|BKG Cargo Type|MVMT Status Code|Level No|Start Position Y/N|End Position Y/N|Full CNTR Y/N";
                SetEditEnterBehavior("tab");
                
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"" },
                            {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_lvl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_st_psn_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_end_psn_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"fcntr_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
                                                       
                InitColumns(cols);
                
                SetEditable(1);
                SetDataAutoTrim(1);
                SetColProperty(0 ,"bkg_cgo_tp_cd"   , {AcceptKeys:"E"   , InputCaseSensitive:1});
                SetColProperty(0 ,"mvmt_sts_cd"     , {AcceptKeys:"E"   , InputCaseSensitive:1});
                SetColProperty(0 ,"cnmv_lvl_no"     , {AcceptKeys:"N"   , InputCaseSensitive:1});
                SetColProperty(0 ,"cnmv_st_psn_flg" , {AcceptKeys:"E"   , InputCaseSensitive:1});
                SetColProperty(0 ,"cnmv_end_psn_flg", {AcceptKeys:"E"   , InputCaseSensitive:1});
                SetColProperty(0 ,"fcntr_flg"       , {AcceptKeys:"E"   , InputCaseSensitive:1});
//                SetSheetHeight(480);
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
                sheetObj.DoSearch("EES_CTM_1001GS.do", FormQueryString(frmObj) );
            }
            break;
        case IBSAVE:        
            if(validateForm(sheetObj,frmObj,sAction)) {
                frmObj.f_cmd.value=MULTI;
                sheetObj.DoSave("EES_CTM_1001GS.do", FormQueryString(frmObj));
                ComOpenWait(false);
            }
            break;
    }
}
/**
* event after saving IBSheet
* @param {ibsheet} Event       
*/
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
   if (ErrMsg == "") {
       ComShowCodeMessage("CTM10022", "CNTR MVMT Sequence");
       doActionIBSheet(sheetObj, document.form, IBSEARCH);
   }
}
/**
 * handling OnSearchEnd event in Sheet1
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    ComOpenWait(false);
    sheetObj.SetWaitImageVisible(1);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,frmObj,sAction){
    with(frmObj){
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

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
    if(Code == 0){
        ComShowCodeMessage("COM132601");
    }
}

function sheet1_OnDownFinish(sheetObj, downloadType, result) {
    ComOpenWait(false);
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}