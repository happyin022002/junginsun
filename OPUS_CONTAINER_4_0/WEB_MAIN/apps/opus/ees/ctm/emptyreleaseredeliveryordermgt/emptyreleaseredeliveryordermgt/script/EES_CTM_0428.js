/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0428.js
*@FileTitle  : Territories Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboCountryText=null;
var comboOfficeText=null;

// Event handler processing by button click event  */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
    var sheetObj=sheetObjects[0];
    var frmObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_add":
                sheetObj.SelectCell(sheetObj.DataInsert(), 2);    // adding row
                break;
            case "btn_del":
                var sRowStr=sheetObj.GetSelectionRows("/");
                var arr=sRowStr.split("/");
                for (i=0; i<arr.length; i++) {
                    sheetObj.SetRowStatus(arr[i],"D");// setting D as status for deleting
                    sheetObj.SetRowHidden(arr[i],1);// hiding selected row
                }
                break;
            case "btn_save":
                ComOpenWait(true);
                doActionIBSheet(sheetObj, frmObj, IBSAVE);    //saving
                ComOpenWait(false);
                break;
            case "btn_downexcel":
                if(sheetObj.RowCount() < 1){//no data
                  ComShowCodeMessage("COM132501");
                }else{
                  sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
                }
                break;
        } // end switch
    } catch(e) {
        if(e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
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
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    // CTM-COMMON
    setEventProcess();
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
        case 1: //sheet1 init
            with(sheetObj){
                // SetSelectionMode(smSelectionList);
                var HeadTitle="|Seq.|Territory|Country|Country Name||Office|User|Creation Date|Update Date";
                // SetEditEnterBehavior("tab");
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
                            {Type:"Combo",     Hidden:0, Width:125,  Align:"Left",    ColMerge:0,   SaveName:"cntr_stk_terr_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Combo", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cnt_nm",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
                            {Type:"Text",      Hidden:0,  Width:155,  Align:"Center",  ColMerge:0,   SaveName:"cnt_nm0",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd" },
                            {Type:"Combo", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_stk_terr_cd0" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd0" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd0" } ];
                InitColumns(cols);
                SetEditable(1);
                SetDataAutoTrim(1);
                SetColProperty("cntr_stk_terr_cd", {ComboText:"|CentralEurope(CEU)|EasternAfrica(EAF)|EasternEurope(EEU)|MediterraneanEurope(MED)|NorthernAfrica(NAF)|NorthernEurope(NEU)|Scandinavian(SCA)|SouthernAfrica(SAF)|SouthernEurope(SEU)|WesternAfrica(WAF)|WesternEurope(WEU)" , ComboCode:"|CEU|EAF|EEU|MED|NAF|NEU|SCA|SAF|SEU|WAF|WEU"} );
                SetWaitImageVisible(0);
                InitComboNoMatchText(true);
//                SetSheetHeight(462);
                resizeSheet();
            }
    
            break;
    }
}

// handling process for Sheet
function doActionIBSheet(sheetObj, frmObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:    
            if(validateForm(sheetObj, frmObj, sAction)) {
                ComOpenWait(true);
                // rtnValue[0] : CimTerritory list
                // rtnValue[1] : Combo1-MdmCountry
                // rtnValue[2] : Combo2-MdmOrganization
                var rtnValue=sheetObj.GetSearchData("EES_CTM_0428GS.do", "f_cmd=" + SEARCH).split("|$$|");
                // creating Country Combo 
                var countryXml=ComXml2ComboString(rtnValue[1], "cnt_cd", "cnt_nm");
                comboCountryText=countryXml[0];    
                sheetObj.SetColProperty("cnt_nm", {ComboText:"|"+countryXml[0], ComboCode:"|"+countryXml[1]} );
                // creating Office Combo 
                var officeXml=ComXml2ComboString(rtnValue[2], "ofc_cd", "ofc_nm");
                comboOfficeText=officeXml[0];    
                sheetObj.SetColProperty("ofc_cd", {ComboText:"|"+officeXml[1], ComboCode:"|"+officeXml[0]} );
                // CimTerritory list
                sheetObjects[0].LoadSearchData(rtnValue[0],{Sync:1} );
              }
            break;
        case IBSAVE:       
            if(validateForm(sheetObj, frmObj, sAction)) {
                frmObj.f_cmd.value=MULTI;
                sheetObj.DoSave("EES_CTM_0428GS.do", FormQueryString(frmObj));
            }
            break;
    }
}

/**
 * handling OnSearchEnd event for Sheet1
 */
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

/**
 * event when changeing value in cell
 * @param {ibsheet} SheetObj    IBSheet Object
 * @param {ibsheet} Row         selected Row
 * @param {ibsheet} Col         selected Col
 */
function sheet1_OnChange(sheetObj, Row, Col) {
    with (sheetObj) {
        var colName=ColSaveName(Col);
        if (colName == "cnt_nm") {
            if (comboCountryText.indexOf(GetCellText(Row, "cnt_nm")) == -1) {
                SetCellText(Row, "cnt_nm0" ,"");
                SetCellText(Row, "cnt_nm" ,"");
                ComShowCodeMessage("CTM20096");
                SelectCell(Row, "cnt_nm");
                return false;
            } else {
                SetCellValue(Row, "cnt_nm0",GetCellValue(Row, "cnt_nm"));
                SetCellValue(Row, "cnt_cd",GetCellText(Row, "cnt_nm"));
            }
        }
        if (colName == "ofc_cd") {
            if (comboOfficeText.indexOf(GetCellText(Row, "ofc_cd")) == -1) {
                SetCellText(Row, "ofc_cd" ,"");
                ComShowCodeMessage("CTM20097");
                SelectCell(Row, "ofc_cd");
                return false;
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
        ComShowCodeMessage("CTM10022", "Territories Management");
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, frmObj, sAction){
    with(sheetObj){
    }
    return true;
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}