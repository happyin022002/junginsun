/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3503.js
*@FileTitle  : Tariff Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;

//Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name  <br>
 */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject1, formObject, SEARCH01);
                form.tariff_cd.focus();
                break;
            case "btn_Down_Excel":
                if(sheetObject1.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    sheetObject1.Down2Excel();
                }
                break;                  
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
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
* registering IBCombo Object as list <br>
* adding process for list in case of needing batch processing with other items  <br>
* defining list on the top of source <br>
*/
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
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
    //initializing IBMultiCombo
    for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
    //setting Tariff Code Combo 
    ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );      
    form.tariff_cd.focus();
}

/**
* registering event listener <br>
*/
function initControl() {
   //axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
   //axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
}

/**
 * initializing IBCOMBO <br>
 */ 
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
    case "tariff_cd":
        with(comboObj) {
            SetDropHeight(200);
            SetMultiSelect(0);
            SetMaxSelect(1);
            SetUseAutoComplete(1);
            SetMaxLength(8);
            ValidChar(2,3);
        }
        break;          
    }
}

/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
    case "sheet1":
        with(sheetObj){
            var HeadTitle="Seq|Tariff Code|Tariff Name|Tariff Type";
            var headCount=ComCountHeadTitle(HeadTitle);
            
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
            
            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tariff_code",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"trf_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:"trf_bzc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                           
            InitColumns(cols);
            
            SetEditable(1);
            SetWaitImageVisible(0);
            resizeSheet();//SetSheetHeight(440);
        }

        break;
    }
}
function resizeSheet(){ ComResizeSheet(sheetObjects[0]); }

/**
* Handling sheet process <br>
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
   try {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {  
            case SEARCH01: // retrieve
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                ComOpenWait(true);              
                formObj.f_cmd.value=SEARCH01;
                if (ComIsEmpty(comboObjects[0].GetSelectText())){
                    formObj.trf_pfx_cd.value="";
                    formObj.trf_no.value="";
                    formObj.trf_nm.value="";      
                }
                var sXml=sheetObj.GetSearchData("ESM_PRI_3503GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                break;  
        }
    }catch(e){
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }finally {
         ComOpenWait(false);
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

/**
 * checking validation process of inputed form data <br>
 */
function validateForm(sheetObj, formObj, sAction) {
     switch (sAction) {
     }
    return true;
}

/**
 * calling function when occurring OnChange Event <br>
 */
function tariff_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
    var formObj=document.form;
    var arrText=text.split("-");
    if (arrText != null && arrText.length > 1) {            
        formObj.trf_nm.value=comboObj.GetText(code, 1);
        if (ComIsEmpty(comboObj.GetSelectText())) {
            formObj.trf_pfx_cd.value="";
            formObj.trf_no.value="";
            formObj.trf_nm.value="";                            
        }else{
            var arr=code.split("-");
            formObj.trf_pfx_cd.value=arr[0];
            formObj.trf_no.value=arr[1];
        } 
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
    }
}

/**
 * calling function when occurring onkeyDown event <br>
 */
function tariff_cd_OnKeyDown(comboObj, KeyCode) {
    var formObj=document.form;
    if (KeyCode == 13){                             
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
    }
}

/**
 * calling event when focus out<br>
 */     
function tariff_cd_OnBlur(comboObj) {
    var formObj=document.form;
    var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);
    if (comboObj.GetSelectCode() != null && comboObj.GetSelectCode() != "") {
        var arr=code.split("-");                
        formObj.trf_pfx_cd.value=arr[0];
        formObj.trf_no.value=arr[1];
        formObj.trf_nm.value=comboObj.GetText(code, 1);
    }
}
