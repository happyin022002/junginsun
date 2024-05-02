/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0118.js
*@FileTitle  : MNR PFMC by EQ
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
 Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_MNR_0118 : EES_MNR_0118 - Defining a script used by screen
 */
/* Developer's task */

var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var uTpSz=new Array();
var gTpSz=new Array();
var zTpSz=new Array();
var selComboIndex=0;
var selComboCode="";

// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
function processButtonClick() {
    /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
    var sheetObject=sheetObjects[0];
    /** **************************************************** */
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
        case "btn_Retrieve":
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;
        case "btn_New":
            doActionIBSheet(sheetObject, formObject, IBCLEAR);
            break;
        case "btn_DownExcel":
            if(sheet1.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
                doActionIBSheet(sheet1, formObject, IBDOWNEXCEL);
            }
            break;
        case "btn_calendar":
            var cal=new ComCalendarFromTo();
            cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
            break;
        case "btn_provider_popup":
            ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Sp','1,0,1,1,1,1,1,1', true);
            break;
        //Calendar From PopUP
        case "manu_yr_fr_cal":
            var cal=new ComCalendar();
            cal.setDisplayType('year');
            cal.select(formObject.manu_yr_fr, 'yyyy');
            break;
        //Calendar To PopUP
        case "manu_yr_to_cal":
            var cal=new ComCalendar();
            cal.setDisplayType('year');
            cal.select(formObject.manu_yr_to, 'yyyy');
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}
/**
* Assigning array of IBSheet object
* Array defined at the top of the source
*/
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Assigning array of IBCombo object
 * @param   {IBMultiCombo}  combo_obj
 * Array defined at the top of the source
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
* Sheet default setting and initializing
* To implement for onload event of body tag
* After loading in your browser should display the ability to add pre-processing
*/
function loadPage() {
    initControl();
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1, '');
        ComEndConfigSheet(sheetObjects[i]);
    }
   //Initializing IBMultiCombo
   for(var k=0;k<comboObjects.length;k++){
       initCombo(comboObjects[k],k + 1);
   }
   setTpSzArray(sheetObjects[0]);
   doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}
/**
 * Combo Setting default
 * @param   {IBMultiCombo}  combo_obj.
 * @param   {Number}    comboNo     Sequence number from combo object tag id
 */
function initCombo (comboObj, comboNo) {
    var formObject=document.form
    switch(comboNo) {
        case 1:
            with (comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "140");
                SetDropHeight(160);
                SetUseAutoComplete(1);
            }
            break;
        case 2:
            with (comboObj) {
                SetTitle("Period|Amount");
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                SetColWidth(0, "100");
                SetColWidth(1, "0");
                SetDropHeight(160);
                SetUseAutoComplete(1);
            }
            break;
        case 3:
            with (comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "80");
                SetDropHeight(160);
                SetUseAutoComplete(1);
            }
            break;
        case 4:
            with (comboObj) {
                SetMultiSelect(1);
                SetMultiSeparator(",");
                SetUseAutoComplete(1);
                SetColAlign(0, "left");
                SetColWidth(0, "100");
                SetDropHeight(200);
            }
            break;
        case 5:
            with (comboObj) {
                SetTitle("Office Code|Office Name");
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                //SetColWidth("100|150");
                SetDropHeight(160);
                SetUseAutoComplete(1);
                SetTitleVisible(1);
                ValidChar(2);
                SetMaxLength(6);
            }
            break;
        case 6:
            with (comboObj) {
                SetTitle("Office Code|Office Name");
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                //SetColWidth("100|150");
                SetDropHeight(160);
                SetUseAutoComplete(1);
                SetTitleVisible(1);
                ValidChar(2);
                SetMaxLength(6);
            }
            break;
         case 7:
            with (comboObj) {
                    SetMultiSelect(1);
                    SetMultiSeparator(",");
                    SetUseAutoComplete(1);
                    SetColAlign(0, "left");
                    SetColWidth(0, "180");
                    SetDropHeight(200);
            }
            break;
      }
}
function resizeSheet( sheetObj ){
    ComResizeSheet( sheetObj );
}
/**
 * Initializing variable for IBSheet and defining header
 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
 */
function initSheet(sheetObj,sheetNo,sheetHeadTitle) {	
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":

            with(sheetObj){
              var HeadTitle1="|RHQ|Office|S/P Code|S/P Name|Curr||||||||||||||||||||||||||||||";
              if(MnrNullToBlank(sheetHeadTitle) != ""){
                  HeadTitle1=sheetHeadTitle;
              }
              
              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:7, DataRowMerge:0 } );
              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"iflag" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sp_cd" },
                     {Type:"Text",     Hidden:0,  Width:260,  Align:"Left",    ColMerge:1,   SaveName:"sp_nm" },
                     {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
                     {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dcol" },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts01",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts02",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts03",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts04",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts05",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts06",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts07",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts08",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts09",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts10",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts11",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts12",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts13",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts14",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts15",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts16",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts17",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts18",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts19",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts20",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts21",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts22",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts23",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts24",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts25",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts26",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts27",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts28",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts29",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ts30",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 }]
              InitColumns(cols);
                      cnt=0;
              SetEditable(0);
//              SetSheetHeight(380);
              SetFocusAfterProcess(0);
              resizeSheet( sheetObj );
          }


            break;
    }
}
//Sheet processing-related processes
 function doActionIBSheet(sheetObj, formObj, sAction) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
        case IBSEARCH:      //Retrieving
            if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value=SEARCH;
                //USD Only
                if(formObj.check_usd_only.checked){
                    formObj.curr_cd.value="Y";
                } else {
                    formObj.curr_cd.value="N";
                }
                //Warranty
                if(formObj.check_warranty.checked){
                    formObj.mnr_warr_flg.value="Y";
                } else {
                    formObj.mnr_warr_flg.value="N";
                }
                var sXml=sheetObj.GetSearchData("EES_MNR_0118GS.do",FormQueryString(formObj));
                var headTitle1=ComGetEtcData(sXml,"TITLE");
                headTitle1="|RHQ|Office|S/P Code|S/P Name|Curr||" + headTitle1;
                //sheetObj=sheetObj.Reset();
        		sheetObjects[0] = sheetObjects[0].Reset();
        		sheetObj = sheetObjects[0]; 
                
                initSheet(sheetObj,1,headTitle1);
                sheetObj.LoadSearchData(sXml,{Sync:0} );
                
                //sheetObj.DoSearch("EES_MNR_0118GS.do",FormQueryString(formObj));
            }
            break;
        case IBCLEAR:        //Initializing
            MnrWaitControl(true);
            sheetObj.SetWaitImageVisible(0);
            sheet1.RemoveAll();
            //Initializing combo
            for(var i=0; i < comboObjects.length;i++){
                comboObjects[i].RemoveAll();
            }
            //Retrieving combo data
            var sCondition=new Array (
                new Array("MnrGenCd","","CUSTOM9"),
                new Array("MnrGenCd","CD00057", "COMMON"),
                new Array("MnrGenCd","CD00055", "COMMON"),
                new Array("MdmOrganization","RHQ","FALSE"),
                new Array("MnrGenCd","CD00084", "COMMON")
            )
            var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
            //EQ Type
            var defEqType="";
            if(comboList[0] != null){
                for(var j=0; j < comboList[0].length;j++){
                    var tempText=comboList[0][j].split("|");
                    eq_type.InsertItem(j, tempText[1] ,tempText[0]);
                    if(j == 0){
                        defEqType=tempText[0];
                    }
                }
            }
            eq_type.SetSelectCode(defEqType);
            //Report Type
            if(comboList[1] != null){
                for(var j=0; j < comboList[1].length;j++){
                    var tempText=comboList[1][j].split("|");
                    report_type.InsertItem(j, tempText[1] ,tempText[0]);
                }
            }
            report_type.SetSelectCode("SP");
            //Report Type Period
            if(comboList[2] != null){
                for(var j=0; j < comboList[2].length;j++){
                    var tempText=comboList[2][j].split("|");
                    tempText[1]=tempText[1] + '|' + 'WO Amt';
                    report_period_type.InsertItem(j, tempText[1] ,tempText[0]);
                }
            }
            report_period_type.SetSelectCode("WI");
            //Regional HQ
            rhq.InsertItem(0,"ALL","A");
            if(comboList[3] != null){
                for(var j=0; j < comboList[3].length;j++){
                    var tempText=comboList[3][j].split("|");
                    rhq.InsertItem(j + 1, comboList[3][j] ,tempText[0]);
                }
            }
            rhq.SetSelectCode("A");
            //EQ Term
            lstm_cd.InsertItem(0,"ALL","A");
            if(comboList[4] != null){
                for(var j=0; j < comboList[4].length;j++){
                    var tempText=comboList[4][j].split("|");
                    lstm_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);
                }
            }
            var HeadTitle1="|RHQ|Office|S/P Code|S/P Name|Curr|||||||||||||||||||||||||||||||";
    		sheetObjects[0] = sheetObjects[0].Reset();
    		sheetObj = sheetObjects[0]; 
            
            initSheet(sheetObj,1,headTitle1);
            //Setting init value
            formObj.fm_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
            MnrSetFromDate(formObj.fm_dt);
            formObj.to_dt.value=ComGetNowInfo();
            formObj.vndr_seq.value="";
            formObj.vndr_lgl_eng_nm.value="";
            formObj.check_usd_only.checked=true;
            formObj.check_warranty.checked=false;
            sheetObj.SetWaitImageVisible(1);
            MnrWaitControl(false);
            break;
        case IBSEARCH_ASYNC01:  //Retrieving(sevice provider No. at inserting)
            if ( validateForm(sheetObj, formObj, sAction) ) {
                //Retrieving service provider
                var sCondition=new Array (
                    new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
                )
                //Setting when returned data exist
                var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
                if(comboList[0] != null){
                    var tempText=comboList[0][0].split("|");
                    formObj.vndr_lgl_eng_nm.value=tempText[1];
                } else {
                    ComShowCodeMessage("MNR00005", "Service Provider");
                    ComSetObjValue(formObj.vndr_lgl_eng_nm, "");
                    ComSetObjValue(formObj.vndr_seq, "");
                    ComSetFocus(formObj.vndr_seq);
                }
            }
            break;
        case IBDOWNEXCEL:
            sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, AutoSizeColumn:1 });
            break;
     }
 }
/**
* Validating process for input form data
*/
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        //At retrieving
        if(sAction==IBSEARCH){
            if(!MnrChkFromDate(formObj.fm_dt)) return false;
            //EQ ManuFacturing Period
            var manuYrFr=formObj.manu_yr_fr.value;
            var manuYrTo=formObj.manu_yr_to.value;
            var manuYrFrLen=manuYrFr.length;
            var manuYrToLen=manuYrTo.length;
            if((manuYrFrLen==0 && manuYrToLen!=0) || (manuYrFrLen!=0 && manuYrToLen==0)) {
                ComShowCodeMessage("MNR00162");
                formObj.manu_yr_fr.focus();
                return false;
            }
            if(manuYrTo - manuYrFr < 0){
                ComShowCodeMessage("MNR00162");
                formObj.manu_yr_fr.focus();
                return false;
            }
        }
    }
    return true;
}
 /**
 * rhq : OnChange event
 * @param {IBMultiCombo}  comboObj
 * @param  {String}    Index_Code
 * @param  {String}    Text
 */
//function rhq_OnChange(comboObj,Index_Code, Text){
    function rhq_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    sheetObjects[0].SetWaitImageVisible(0);
    var formObj=document.form;
    ofc_cd.RemoveAll();
    var sCondition=new Array (
        new Array("MdmOrganization","SEARCH",NewCode)
    )
    var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
    if(comboList[0] != null){
        for(var j=0; j < comboList[0].length;j++){
            var tempText=comboList[0][j].split("|");
            ofc_cd.InsertItem(j,comboList[0][j] ,tempText[0]);
        }
    }
    ofc_cd.InsertItem(0,"ALL","A");
    ofc_cd.SetSelectCode("A");
    sheetObjects[0].SetWaitImageVisible(1);
}
/**
 * combo_eq_type_cd : OnChange event
 * @param {IBMultiCombo}  comboObj
 * @param  {String}    Index_Code
 * @param  {String}    Text
 */
//function eq_type_OnChange(comboObj,Index_Code, Text){
function eq_type_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;
    //--------------------------------------
    var comboValue=eq_type.GetSelectCode();
    tp_sz_cd.RemoveAll();
    var selTpSz=new Array();
    if(comboValue == "U"){
        selTpSz=uTpSz;
    } else if(comboValue == "G"){
        selTpSz=gTpSz;
    } else if(comboValue == "Z"){
        selTpSz=zTpSz;
    }
    
    tp_sz_cd.InsertItem(0,"ALL","ALL");
    for(var i=1;i < (selTpSz.length + 1);i++){
        tp_sz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]);
    }
}

function tp_sz_cd_OnSelect(comboObj ,index, code) {
    selComboIndex = index;
    selComboCode = code;
}
function tp_sz_cd_OnChange(comboObj) {
    ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
}

function lstm_cd_OnSelect(comboObj ,index, code) {
    selComboIndex = index;
    selComboCode = code;
}
function lstm_cd_OnChange(comboObj) {
   ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
}

function setTpSzArray(sheetObj){
    var arrXml=MnrComSearchGrid2(sheetObj,"ACTTypeSize");
    if(arrXml != null){
        for(var i=0; i < arrXml.length; i++){
            if(i == 0){
                uTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
            } else if(i == 1){
                zTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
            } else if(i == 2){
                gTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
            }
        }
    }
}
/**
 * (Service Provider) Function of processing for pop-up screen return value<br>
 * @param {arry} returnedValues Returned value array of pop-up screen
 * @param Row The object is row index in case of IBSheet
 * @param Col The object is column index in case of IBSheet
 * @param The object is sheet index in case of IBSheet
 */
function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
    var formObj=document.form;
    if ( aryPopupData.length > 0 ) {
        formObj.vndr_seq.value=aryPopupData[0][2];
        formObj.vndr_lgl_eng_nm.value=aryPopupData[0][4];
    }
}
/**
* Event handling of OnSearchEnd of sheet1
*/
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    if (ErrMsg != "") {
        ComShowCodeMessage("MNR00057","MNR PFMC by EQ");
    }else{
    	if(report_type.GetSelectCode()== "OF"){
            sheetObj.SetColHidden("sp_cd",1);
            sheetObj.SetColHidden("sp_nm",1);
        } else {
            sheetObj.SetColHidden("sp_cd",0);
            sheetObj.SetColHidden("sp_nm",0);
        }
        for(var i=0; i < 37; i++){
            if(sheetObj.GetCellValue(0,i) == 'N'){
                sheetObj.SetColHidden(i,1);
            }
        }
        var row=sheetObj.RowCount();
        var col=3;
        if(sheetObj.RowCount()> 0){
            //USD Only checked
            if(document.form.check_usd_only.checked){
                sheetObj.DataInsert(-1);
                sheetObj.DataInsert(-1);
                sheetObj.DataInsert(-1);
            	
                sheetObj.SetCellValue(row + 1,6,"QTY",0);
                sheetObj.SetCellValue(row + 1,1,"TOTAL",0);
                sheetObj.SetCellValue(row + 2,6,"AMT",0);
                sheetObj.SetCellValue(row + 3,6,"AVG",0);
                
                var j=7;
                for(var j=7; j < 37; j++){
                	var sumQty = 0;
                	var sumAmt = 0;
                	for(var k=sheetObj.HeaderRows(); k <= row; k++){
                		if(sheetObj.GetCellValue(k, 6) == "QTY"){
                			sumQty = sumQty + sheetObj.GetCellValue(k, j);
                		}else if(sheetObj.GetCellValue(k, 6) == "AMT"){
                			sumAmt = sumAmt + sheetObj.GetCellValue(k, j);
                		}
                	}
                	
                	sheetObj.SetCellValue(row+1, j, sumQty);
                	sheetObj.SetCellValue(row+2, j, sumAmt);
                	
                    if(sheetObj.GetCellValue(row + 1,j) == 0){
                        sheetObj.SetCellValue(row + 3,j,0,0);
                    }else{
                        //sheetObj.CellValue2(row + 3,j) = sheetObj.CellValue(row + 3,j) / sheetObj.CellValue(row + 2,j);
                        //sheetObj.CellValue2(row + 3,j) = Math.round(sheetObj.CellValue(row + 4,j)*100)/100;
                        var avg1=sheetObj.GetCellValue(row + 2,j) / sheetObj.GetCellValue(row + 1,j);   // (TOTAL)AMT / (TOTAL)QTY
                        var avg2=Math.round(avg1*100)/100;                                      // Rounding to two decimal digits
                        sheetObj.SetCellValue(row + 3,j,avg2,0);
                    }
                }
                sheetObj.SetRangeBackColor(row+1, 0, row+3, sheetObj.LastCol(), "#FFA7A7");
     			sheetObj.SetRangeFontBold(row+1, 0, row+3, sheetObj.LastCol(), 1);
     			sheetObj.SetSelectRow(1);
            } else {
                sheetObj.SetRowHidden(row + 1,1);
                sheetObj.SetRowHidden(row + 2,1);
                sheetObj.SetRowHidden(row + 3,1);
            }
        }
    }
}
function initControl() {
    //Axon event handling 1. Catching event
    axon_event.addListenerForm  ('blur', 'obj_deactivate',      form);
//    axon_event.addListenerFormat('focus',   'obj_activate',     form);
    axon_event.addListenerFormat('keypress', 'obj_keypress',    form);
    axon_event.addListenerFormat('change',   'obj_change',      form);    
}
/**
 * Disable event handling <br>
 **/
function obj_deactivate(){
    obj=event.srcElement;
    ComChkObjValid(event.srcElement);
}
/**
 * Enable event handling <br>
 **/
function obj_activate(){
    ComClearSeparator(event.srcElement);
}
function obj_change(){
    var obj=event.srcElement;
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if ( ComTrim(obj.value) != "" ) {
        switch(ComGetEvent("name")) {
            case "vndr_seq":
                formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value,6,"0");
                doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
                break;
        }
    } else {
        switch(ComGetEvent("name")) {
            case "vndr_seq":
                ComSetObjValue(formObj.vndr_lgl_eng_nm,"")
                break;
        }
    }
}
/**
 * Keypress event handling <br>
 **/
function obj_keypress(){
    obj=event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;
    switch(obj.dataformat) {
        case "ymd":
        case "int":
        case "yyyy":
            ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, ".");
            break;
        case "eng":
            ComKeyOnlyAlphabet();
            break;
        case "engup":
            ComKeyOnlyAlphabet('uppernum');
            break;
    }
}
/* End of developer's task */
