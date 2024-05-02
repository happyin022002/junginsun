/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0565.js
*@FileTitle  : RDN Performance Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;

// Event handler processing by button click event */
document.onclick=processButtonClick;

/**
* Event handler processing by button name <br>
* @return 
*/
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btns_calendar1":
                var cal=new ComCalendar();
                cal.select(form.rdn_iss_dt_from, 'yyyy-MM-dd');
                break;
            case "btns_calendar2":
                var cal=new ComCalendar();
                cal.select(form.rdn_iss_dt_to, 'yyyy-MM-dd');
                break;
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                break;
            case "btn_New":
                removeAll(formObject);
                break;
            case "btn_DownExcel":
                doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
                break;
            case "btn_Print":
                //alert(srcName);
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
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source <br>
 * @param  sheet_obj
 * @return 
 */ 
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * registering IBMulti Combo Object as list <br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source <br>
 * @param combo_obj
 * @return 
 */ 
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}

/**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * adding first-served functions after loading screen. <br>
 * @return 
 */
function loadPage() {
    //IBMultiComboinitializing
    for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
     for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    //axon_event.addListenerForm('keypress', 'obj_keypress', document.form);          
    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    initIBComboItem();
}
/** 
* Keypress of Object event handler <br>
* checking input validation according to dataformat of object <br>
* @param    
* @return 
*/ 
function obj_keypress(){
    var obj=event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;

    switch(obj.dataformat){
        case "ymd": 
            ComKeyOnlyNumber(obj,"-"); 
            break;
        case "int": 
        case "number":  
            ComKeyOnlyNumber(obj);
            break;
        case "engup":
            ComKeyOnlyAlphabet('upper');
            break;
        case "uppernum":
            ComKeyOnlyAlphabet('uppernum');
            break;
        default:
            break;
    }
}

/**
 * OnBeforeActivate   event handling <br>
 * @param 
 * @return 
 */  
function obj_activate() {
    ComClearSeparator (event.srcElement);      
}

/**
 * OnBeforeDeActivate   event handling <br>
 * @param 
 * @return 
 */
function obj_deactivate() {
    ComChkObjValid(event.srcElement);
}

/**
 * loading IBSHEET COMBO <br>
 * @return 
 */ 
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
    case "rct_rhq_cd":
        var i=0;
        with(comboObj) {
            SetDropHeight(200);
            SetUseAutoComplete(1);
            SetMaxLength(6);
        }
        break;    
    case "rct_ofc_cd":
        var i=0;
        with(comboObj) {
            SetDropHeight(200);
            SetUseAutoComplete(1);
            SetMaxLength(6);
        }
        break;       
    case "respb_ofc_cd":
        var i=0;
        with(comboObj) {
            SetDropHeight(200);
            SetUseAutoComplete(1);
            SetMaxLength(6);
        }
        break;  
    case "respb_rhq_cd":
        var i=0;
        with(comboObj) {
            SetDropHeight(200);
            SetUseAutoComplete(1);
            SetMaxLength(6);
        }
        break;      
    }
}

/**
 * return code value of comboObjects[0]
 * @return String <br>
 */ 
function getRctRhqCd() {
    return comboObjects[0].GetSelectCode();
}

/**
 * return code value of comboObjects[1]
 * @return String <br>
 */ 
function getRctOfcCd() {
    return comboObjects[1].GetSelectCode();
}

/**
 * return code value of comboObjects[2]
 * @return String <br>
 */ 
function getRespbRhqCd() {
    return comboObjects[2].GetSelectCode();
}

/**
 * return code value of comboObjects[3]
 * @return String <br>
 */ 
function getRespbOfcCd() {
    return comboObjects[3].GetSelectCode();
}

/**
 * activating in case of changing rct_rhq_cd combo
 * @param comboObj
 * @param  code    
 * @param  text 
 * @return    
 */ 
function rct_rhq_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
    if(comboObj.GetSelectIndex()== "0") {
        comboObjects[1].RemoveAll();
        return;
    }
    if(comboObjects[0].GetSelectIndex() > 0 && comboObjects[0].GetSelectIndex()!= "-1") {
        var formObj=document.form;
        formObj.etc2.value=code;
        setOfcCd1();
    } 
}

/**
 * rct_ofc_cd combo retrieve and set to hidden value in case of event occurring
 * @param 
 * @return    
 */
function setOfcCd1() {
    var formObj=document.form;
    // 조직도 combo2
    formObj.f_cmd.value=COMMAND02;
    var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
    ComXml2ComboItem(sXml, rct_ofc_cd, "cd", "cd");
    rct_ofc_cd.InsertItem(0,'','');
}

/**
 * activating in case of changing respb_rhq_cd combo
 * @param comboObj
 * @param  code    
 * @param  text 
 * @return    
 */
function respb_rhq_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
    if(comboObj.GetSelectIndex()== "0") {
        comboObjects[3].RemoveAll();
        return;
    }
    if(comboObjects[2].GetSelectIndex() > 0 && comboObjects[2].GetSelectIndex()!= "-1") {
        var formObj=document.form;
        formObj.etc2.value=code;
        setOfcCd2();
    } 
}

/**
 * respb_ofc_cd combo retrieve and set to hidden value in case of event occurring
 * @param 
 * @return    
 */
function setOfcCd2() {
    var formObj=document.form;
    formObj.f_cmd.value=COMMAND02;
    var sXml=sheetObjects[0].GetSearchData("RASCommonGS.do", FormQueryString(formObj));
    ComXml2ComboItem(sXml, respb_ofc_cd, "cd", "cd");
    respb_ofc_cd.InsertItem(0,'','');
}

/**
* setting Item at IBMultiCombo
* @return 
*/
function initIBComboItem() {
    ComBkgTextCode2ComboItem(rhqComboValue, rhqComboValue, getComboObject(comboObjects, 'rct_rhq_cd'),   "|", "\t" );
    ComBkgTextCode2ComboItem(respComboValue,respComboValue,getComboObject(comboObjects, 'respb_rhq_cd'), "|", "\t" );
    respb_rhq_cd.InsertItem(0,'','');
}

/**
* setting sheet initial values and header
* @param sheetObj
* @param sheetNo
* @return
*/
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet0":      //hidden 
            with(sheetObj){
                
                //SetConfig( { SearchMode:2, DataRowMerge:0 } );
                
                //var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                //var headers = [ ];
                //InitHeaders(headers, info);
                
                //var cols = [  ];
                
                //InitColumns(cols);
                SetVisible(0);
            }
              
            break; 
        case "sheet1":
            with(sheetObj){
                var HeadTitle1="|Receipt\nRHQ|Receipt\nOffice|Resp.\nRHQ|Resp.\nOffice|Non-\nCharged B/L|Non-\nCharged B/L|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Grand Total||BLCorrection";
                var HeadTitle2="|Receipt\nRHQ|Receipt\nOffice|Resp.\nRHQ|Resp.\nOffice|Non-\nCharged B/L|Non-\nCharged B/L|CNTR Qty|CNTR Qty|GRI|GRI|Cargo Type|Cargo Type|Route|Route|Others|Others|Sub Total|Sub Total|IHC|IHC|Bunker|Bunker|DG|DG|WSC|WSC|Others|Others|Sub Total|Sub Total|Grand Total||BLCorrection";
                var HeadTitle3="|Receipt\nRHQ|Receipt\nOffice|Resp.\nRHQ|Resp.\nOffice|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|BLCorrection";
                var headCount=ComCountHeadTitle(HeadTitle1);
                
                SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rct_rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rct_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"respb_rhq_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"respb_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"cnt1",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"amt1",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt2",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt2",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt3",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt3",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt4",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt4",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt5",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt5",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt6",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt6",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"oft_subCnt",        KeyField:0,   CalcLogic:"|cnt2|+|cnt3|+|cnt4|+|cnt5|+|cnt6|",Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"oft_subAmt",        KeyField:0,   CalcLogic:"|amt2|+|amt3|+|amt4|+|amt5|+|amt6|",Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt7",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt7",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt8",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt8",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt9",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt9",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt10",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt10",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"cnt11",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"amt11",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"surcharge_subCnt",  KeyField:0,   CalcLogic:"|cnt7|+|cnt8|+|cnt9|+|cnt10|+|cnt11|",Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"surcharge_subAmt",  KeyField:0,   CalcLogic:"|amt7|+|amt8|+|amt9|+|amt10|+|amt11|",Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:57,   Align:"Right",   ColMerge:1,   SaveName:"GrandCntTotal",     KeyField:0,   CalcLogic:"|cnt1|+|oft_subCnt|+|surcharge_subCnt|",Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"GrandAmtTotal",     KeyField:0,   CalcLogic:"|amt1|+|oft_subAmt|+|surcharge_subAmt|",Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"BLCorrection",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
//                ShowSubSum([{StdCol:"rct_rhq_cd", SumCols:"5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33", Sort:false, ShowCumulate:false, CaptionCol:0, OtherColText:"rct_rhq_cd=%s;rct_ofc_cd=SubTotal"}]);
                InitColumns(cols);
                SetEditable(1);
                SetCountPosition(0);
                SetWaitImageVisible(0);
                SetSheetHeight(480);
            }

            break;
    }
}

/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return void
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
        case IBSEARCH:      //retrieve
            if (validateForm(sheetObj,formObj,sAction)) {
                ComOpenWait(true);      
                formObj.f_cmd.value=SEARCH01;
                sheetObj.DoSearch("ESM_BKG_0565GS.do", FormQueryString(formObj) );
            }    
            break;
        case IBDOWNEXCEL:
            if(sheetObj.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
                sheetObj.Down2Excel({ HiddenColumn:1, Merge:1});
            }
            break;    
    }
}

/**
 * handling process for input validation <br>
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return boolean
 */
function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
        case IBSEARCH: // retrieve
            var fmDtObj=form.rdn_iss_dt_from;
            var toDtObj=form.rdn_iss_dt_to;
            var fmDtValue=fmDtObj.value.replace(/-/g, "");
            var toDtValue=toDtObj.value.replace(/-/g, "");
            if(!ComChkObjValid(fmDtObj)) { return false; }
            if(!ComChkObjValid(toDtObj)) { return false; }
            if("" == fmDtValue || "" == toDtValue){
                 ComShowCodeMessage("BKG95025", "Date"); // "Please input {?msg2}."
                 if("" == fmDtValue){
                     ComSetFocus(fmDtObj);
                 }else{
                     ComSetFocus(toDtObj);
                 }
                 return false;
            }
            if( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) {
                 ComShowCodeMessage("BKG95026", "From Date", "To Date");
                 ComSetFocus(fmDtObj);
                 return false;
            }
            var fromAddDays=ComGetDateAdd(fmDtValue, "D", 364, "", true);
            if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
                ComShowCodeMessage("BKG95027", "365 days"); // "The period of Date can't be over {?msg1}."
                ComSetFocus(fmDtObj);
                return false;
            }
            makeInParam(formObj);
            return true;
            break;
     }  
}

/**
 * check or uncheck in case of clicking all
 * @param 
 * @return 
 */
function checkAll() {
    var formObj=document.form;
    if(formObj.all.checked) {
        formObj.rdn_sts_check[0].checked=true;
        formObj.rdn_sts_check[1].checked=true;
        formObj.rdn_sts_check[2].checked=true;
        formObj.rdn_sts_check[3].checked=true;
        formObj.rdn_sts_check[4].checked=true;
        formObj.rdn_sts_check[5].checked=true;
        formObj.rdn_sts_check[6].checked=true;
    } else {
        formObj.rdn_sts_check[0].checked=false;
        formObj.rdn_sts_check[1].checked=false;
        formObj.rdn_sts_check[2].checked=false;
        formObj.rdn_sts_check[3].checked=false;
        formObj.rdn_sts_check[4].checked=false;
        formObj.rdn_sts_check[5].checked=false;
        formObj.rdn_sts_check[6].checked=false;
    }
}


/**
 * check or uncheck in case of clicking all
 * @param 
 * @return 
 */
function checkItem() {
    var formObj=document.form;
    
    if(formObj.rdn_sts_check[0].checked && formObj.rdn_sts_check[1].checked &&
       formObj.rdn_sts_check[2].checked && formObj.rdn_sts_check[3].checked &&
       formObj.rdn_sts_check[4].checked && formObj.rdn_sts_check[5].checked &&
       formObj.rdn_sts_check[6].checked){
    	formObj.all.checked = true;
    } else {
    	formObj.all.checked = false;
    }
}

/**
 * combining checked status list in case of search
 * @param formObj
 * @return 
 */
function makeInParam(formObj) {
    var rdn_sts_cd="";
    var cntCheck=0;
    //alert("e" + rdn_sts_check[0])
    for(var i=0;i<formObj.rdn_sts_check.length;i++){
         if(formObj.rdn_sts_check[i].checked)
            cntCheck=i;
    }
    for(var i=0;i<formObj.rdn_sts_check.length;i++){
        if(formObj.rdn_sts_check[i].checked) {
            //alert("e" + formObj.rdn_sts_check[i].value)
            rdn_sts_cd=rdn_sts_cd + "'" + formObj.rdn_sts_check[i].value + "'";
            if(i < (formObj.rdn_sts_check.length-1) && i < cntCheck) {
                rdn_sts_cd=rdn_sts_cd + ",";
            }     
        }
    }
    formObj.rdn_sts_cd.value=rdn_sts_cd;
    //alert("e" + formObj.rdn_sts_cd.value)
}

/** 
* OnSearchEnd event handler occurring after retrieve sheet1 data<br>
* @param   sheetObj  
* @param   errMsg 
* @return 
*/ 
function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg) {
	ComOpenWait(false);
    with(sheetObj) {
        SetMergeCell(LastRow(), 1, 1, 4);
        SetSumText(0, "rct_rhq_cd","Grand Total");
        SetSumBackColor("#00FFFF");
    }
}

function sheet0_OnSearchEnd(sheetObj, Code, ErrMsg) {
    ComOpenWait(false);
}

/**
 * reset all screen<br>
 * @param  formObj    
 * @return 
 */
function removeAll(formObj) {
    formObj.reset();
    comboObjects[0].SetSelectIndex("-1");
    comboObjects[1].RemoveAll();
    comboObjects[2].RemoveAll();
    sheetObjects[1].RemoveAll();
}   
