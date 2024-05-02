/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0119.js
*@FileTitle  : PFMC by CEDEX Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
      Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class EES_MNR_0119 : business script for EES_MNR_0119.
 */
// common global variables

var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
        case "btn_Retrieve":
            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            break;
        case "btn_New":
            doActionIBSheet(sheetObject1,formObject,IBCLEAR);
            break;                  
        case "btn_DownExcel":
            if(sheetObject1.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
                doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
            }
            break;
        case "btn_calendar": 
            var cal=new ComCalendarFromTo(); 
            cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');                               
            break;                  
        case "btn_provider_popup":
            ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
            break;                  
        case "btn_location":
            ComOpenPopup('EES_MNR_0193.do?rec_eq_knd_cd=' + eq_type.GetSelectCode(), 950, 510, 'setEES_MNR_0193', '1,0', true);
            break;  
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
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
 * registering IBCombo Object as list
 * @param   {IBMultiCombo}  combo_obj   adding ComboObject. 
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj){    
    comboObjects[comboCnt++]=combo_obj;  
} 
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    initControl();
    for(i=0;i<sheetObjects.length;i++){
        //
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i + 1);
        //
        ComEndConfigSheet(sheetObjects[i]);
    }
    //initializing IBMultiCombo 
    for(var k=0;k<comboObjects.length;k++){ 
        initCombo(comboObjects[k],k + 1);    
    }   
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}   
function initControl() {       
    //Axon handling event1. event catch  
    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);                
 //   axon_event.addListenerFormat('focus',   'obj_activate',    form);             
    axon_event.addListenerFormat('keypress', 'obj_keypress',    form);            
    axon_event.addListenerFormat('change',   'obj_change',      form);    
}           
/**
 * HTML Control's deactivate event <br>
 **/
function obj_deactivate(){    
    obj=ComGetEvent();       
    ComChkObjValid(ComGetEvent()); 
} 
/**
 * HTML Control's activate event <br>
 **/
function obj_activate(){   
    ComClearSeparator(ComGetEvent());
}  
function obj_change(){       
    var obj=ComGetEvent(); 
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
 * HTML Control's keypress event <br>
 **/     
function obj_keypress(){     
    obj=ComGetEvent();    
    if(obj.dataformat == null) return; 
    window.defaultStatus=obj.dataformat;
    switch(obj.dataformat) {  
    case "ymd":   
    case "int":    
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
/**   
 * setting combo basic info    
 * @param   {IBMultiCombo}  combo_obj   ComboObject. 
 * @param   {Number}    comboNo     ComboObject tag serial number 
 * adding case as numbers of counting combos 
 */     
function initCombo (comboObj, comboNo) {        
    switch(comboNo) {               
    case 1: 
        with (comboObj) { 
            SetMultiSeparator("|");
            SetTitle("Period|Amount");  
            SetColAlign(0, "left");
            SetColAlign(1, "left");
            SetColWidth(0, "100");
            SetColWidth(1, "0");
            SetDropHeight(160);
            SetUseAutoComplete(1);
        }        
        break;  
    case 2: 
        with (comboObj) { 
            SetColAlign(0, "left");
            SetColWidth(0, "80");
            SetDropHeight(160);
            SetUseAutoComplete(1);
        }   
        break;                          
    case 3: 
    case 4: 
        with (comboObj) { 
            SetMultiSeparator("|");
            SetTitle("Office Code|Office Name");
            SetColAlign(0, "left");
            SetColAlign(1, "left");
            //SetColWidth("100|150"); 
            SetDropHeight(160);
            SetUseAutoComplete(1);
            ValidChar(2);
            SetTitleVisible(1);
            SetMaxLength(6);
        }      
        break;      
    case 5: 
        with (comboObj) { 
            SetTitle("Code|Code Desc");
            SetColAlign(0, "left");
            SetColAlign(1, "left");
            SetColWidth(0, "50");
            SetColWidth(1, "150");
            SetDropHeight(160);
            SetUseAutoComplete(1);
            ValidChar(2);
            SetMaxLength(3);
        }      
        break;
    case 6: 
        with (comboObj) { 
            SetTitle("Code|Code Desc");
            SetColAlign(0, "left");
            SetColAlign(1, "left");
            SetColWidth(0, "50");
            SetColWidth(1, "150");
            SetDropHeight(160);
            SetUseAutoComplete(1);
            ValidChar(2);
            SetTitleVisible(1);
//            SetMaxLength(2);
        }      
        break;          
    case 7: 
        with (comboObj) { 
            SetTitle("Code|Code Desc");
            SetColAlign(0, "left");
            SetColAlign(1, "left");
            SetColWidth(0, "50");
            SetColWidth(1, "150");
            SetDropHeight(160);
            SetUseAutoComplete(1);
            ValidChar(2);
            SetTitleVisible(1);
//            SetMaxLength(2);
        }      
        break;   
    case 8:     
        with (comboObj) { 
            SetTitle("Code|Code Desc");
            SetColAlign(0, "left");
            SetColAlign(1, "left");
            SetColWidth(0, "50");
            SetColWidth(1, "150");
            SetDropHeight(160);
            SetUseAutoComplete(1);
            ValidChar(2);
            SetTitleVisible(1);
//            SetMaxLength(2);
        }      
        break;   
    } 
} 
function resizeSheet( sheetObj ){
    ComResizeSheet( sheetObj );
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
    case "sheet1":
        with(sheetObj){
          var HeadTitle="|Seq.|EQ Type|Location\nCode|Component|Component\nName|Repair|Repair\nName|Division|Division\nName|Damage|Damage\nName|RHQ.|Office|S/P Code|S/P Name|Curr|QTY|Labor\nCost|Material\nCost|Total\nAMT|Average\nAmt";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
                 {Type:"Seq",       Hidden:0, Width:55,   Align:"Right",  ColMerge:0,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",  ColMerge:0,   SaveName:"eq_knd_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_cmpo_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eq_cmpo_nm",     KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_rpr_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eq_rpr_nm",      KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_div_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"trf_div_nm",     KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_dmg_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eq_dmg_nm",      KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rhq",            KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"vndr_seq_nm",    KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"qty",            KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"lbr_cost_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
                 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mtrl_cost_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
                 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"t_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
                 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"t_avg",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 } ];
           
          InitColumns(cols);

          SetEditable(0);
          SetCountPosition(0);
//            SetSheetHeight(350);
          resizeSheet( sheetObj );
        }


        break;
    }
}
// handling process for sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
    case IBSEARCH:      //retrieving
    if(validateForm(sheetObj,formObj,sAction)){
        if (sheetObj.id == "sheet1"){
            if(formObj.currency_ck.checked)
            {
                formObj.currency.value="Y";
            }else{
                formObj.currency.value="N";
            }
            if(formObj.qty_ck.checked)
            {
                formObj.qty.value="Y";
            }else{
                formObj.qty.value="N";
            }
            formObj.f_cmd.value=SEARCH;                             
            sheetObj.DoSearch("EES_MNR_0119GS.do",FormQueryString(formObj) );
        }
    }
    break;
    case IBCLEAR:      //initializing
    MnrWaitControl(true);
    sheetObj.SetWaitImageVisible(0);
    //initializing sheet   
    for(i=0;i<sheetObjects.length;i++){   
        sheetObjects[i].RemoveAll();
    }  
    //initializing combo
    for(var i=0; i < comboObjects.length;i++){ 
        comboObjects[i].RemoveAll();
    }                   
    //retrieving common combo.    
    var sCondition=new Array ( 
            new Array("MnrGenCd","CD00055", "COMMON"),   //Report Period Type
            new Array("MnrGenCd","","CUSTOM9"),          //EQ TYPE
            new Array("MdmOrganization","RHQ","FALSE"),  //Regional HQ
            new Array("MnrEqCmpoCd","3","COMMON"),       //Component
            new Array("MnrCedexOthCd","RPR","COMMON"),    //Repair
            new Array("MnrCedexOthCd","DMG","COMMON")     //Demage  
    );
    //EQ Type   
    eq_type.InsertItem(0,"ALL","A");
    //Regional HQ  
    rhq.InsertItem(0,"ALL","A");
    //Component
    component.InsertItem(0,"ALL","A");
    //Repair        
    repair.InsertItem(0,"ALL","A"); 
    //Damage        
    damage.InsertItem(0,"ALL","A"); 
    var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
    var sheetComboText="";
    var sheetComboCode="";
    var sheetComboCodeText="";
    var sheetComboDefault="";
    for(var i=0;i<comboList.length;i++)
    {
        sheetComboText="";
        sheetComboCode="";
        sheetComboCodeText="";
        sheetComboDefault=""; 
        if(comboList[i] != null){        
            for(var j=0; j < comboList[i].length;j++){  
                var tempText=comboList[i][j].split("|");  
                sheetComboText +=  tempText[1] + "|";
                sheetComboCode +=  tempText[0] + "|";
                sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
                if(i==0){
                    tempText[1]=tempText[1] + '|' + 'Estimate Amt';
                    report_period_type.InsertItem(j,tempText[1] ,tempText[0]);
                }else if(i==1){
                    eq_type.InsertItem(j + 1,tempText[1] ,tempText[0]);
                }else if(i==2){
                    rhq.InsertItem(j + 1,comboList[i][j] ,tempText[0]);
                }else if(i==3){
                    component.InsertItem(j + 1,comboList[i][j] ,tempText[0]);
                }else if(i==4){
                    repair.InsertItem(j + 1,comboList[i][j] ,tempText[0]);
                }else if(i==5){
                    damage.InsertItem(j + 1,comboList[i][j] ,tempText[0]);                      
                }
                if(i==1)sheetObjects[0].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
            }  
        }  
    }
    //setting default value     
    report_period_type.SetSelectCode("WI");
    formObj.currency_ck.checked=false;
    formObj.qty_ck.checked=false;
    formObj.qty.value="N";
    eq_type.SetSelectCode("A");
    rhq.SetSelectCode("A");
    ofc_cd.SetSelectCode("A");
    component.SetSelectCode("A");
    repair.SetSelectCode("A");
    division.SetSelectCode(-1);
    damage.SetSelectCode("A");
    formObj.fm_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "M", -1);
    MnrSetFromDate(formObj.fm_dt);  
    formObj.to_dt.value=ComGetNowInfo();
    formObj.vndr_seq.value=""; 
    formObj.vndr_lgl_eng_nm.value=""; 
    sheetObj.SetColHidden("eq_dmg_cd",0);
    sheetObj.SetColHidden("eq_dmg_nm",0);
    sheetObj.SetColHidden("rhq",0);
    sheetObj.SetColHidden("cost_ofc_cd",0);
    sheetObj.SetColHidden("vndr_seq",0);
    sheetObj.SetColHidden("vndr_seq_nm",0);
    sheetObj.SetColHidden("eq_loc_cd",0);
    sheetObj.SetWaitImageVisible(1);
    MnrWaitControl(false);                  
    break;
    case IBDOWNEXCEL:
        sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, AutoSizeColumn:1 });
        break;   
    case IBSEARCH_ASYNC01:  //retrieving(in case of input sevice provider No.)
    if ( validateForm(sheetObj, formObj, sAction) ) { 
        //retrieving service provider       
        var sCondition=new Array (   
                new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
        )                             
        //setting in case of existing retrieving result
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
    }
}
/**
 * initializing Division combo
 */      
function set_Division_Combo(sheetObj,formObj,sAction){    
    if(ComTrimAll(component.GetSelectCode()) != "A" && ComTrimAll(repair.GetSelectCode()) != "A"){
        division.RemoveAll();
        var compRprJoinStr=ComTrimAll(component.GetSelectCode()) + ComTrimAll(repair.GetSelectCode());
        var sCondition=new Array (      
                new Array("MnrDivCd",compRprJoinStr,"COMMON")       //Division
        )              
        var comboList=MnrComSearchCombo(sheetObj,sCondition);
        if(comboList[0] != null){           
            for(var j=0; j < comboList[0].length;j++){   
                var tempText=comboList[0][j].split("|");  
                division.InsertItem(j, comboList[0][j] ,tempText[0]);
            }                   
        }
    }   
}          
/**  
 * component Change event      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  
//function component_OnChange(comboObj,Index_Code, Text){  
function component_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    set_Division_Combo(sheetObjects[0],document.form,'');   
}        
/**  
 * repair Change event      
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */  
//function repair_OnChange(comboObj,Index_Code, Text){
function repair_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    set_Division_Combo(sheetObjects[0],document.form,'');   
}
/**  
 * rhq Change event           
 * @param {IBMultiCombo}  comboObj ComboObject  
 * @param  {String}    Index_Code   Index or Code
 * @param  {String}    Text
 */     
//function rhq_OnChange(comboObj,Index_Code, Text){
function rhq_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;       
    var sCondition=new Array (
            new Array("MdmOrganization","SEARCH",NewCode)   //Office
        );   
    var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
    if(comboList[0] != null){
        for(var i=0; i < comboList[0].length;i++){ 
            var code=comboList[0][i].substring(0, comboList[0][i].indexOf('|') );
            ofc_cd.InsertItem(i, comboList[0][i] , code);              
        }
        ofc_cd.InsertItem(0, "ALL" , "A"); 
        ofc_cd.SetSelectCode("A");
    }        
}   
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        if(sAction==IBSEARCH) {         
            if(!MnrChkFromDate(formObj.fm_dt)) return false;
        }               
    }
    return true;
}
/**
 * (Service Provider) handling Pop-up Return Value<br>
 * @param {arry} Return value array of returnedValues Pop-up
 * @param Row IBSheet Row index
 * @param Col IBSheet Col index
 * @param Sheet Array index 
 */
function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
    var formObj=document.form;   
    if ( aryPopupData.length > 0 ) {
        formObj.vndr_seq.value=aryPopupData[0][2];
        formObj.vndr_lgl_eng_nm.value=aryPopupData[0][4];
    }
}   
/**
 * getting rep_Multiful_inquiry  
 *           
 * Location : in case of Single choice     
 */      
function getMnr_Multi(rowArray,return_val) {
    var formObj=document.form;  
    var tempText="";    
    //initializing     
    for(var i=0; i<rowArray.length; i++) {   
        var colArray=rowArray[i];     
        tempText +=  rowArray[i] + ',';       
    }      
    //clearing comma(,)     
    tempText=MnrDelLastDelim(tempText);  
    tempText=tempText.toUpperCase();                
    eval("document.form." + return_val + ".value='" + tempText + "';"); 
}   
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{   
    with(sheetObj)  
    {
        SetSumText(0, "seq","Total");
    }       
    if(document.form.qty.value=="Y"){
        sheetObj.SetColHidden("eq_dmg_cd",1);
        sheetObj.SetColHidden("eq_dmg_nm",1);
        sheetObj.SetColHidden("rhq",1);
        sheetObj.SetColHidden("cost_ofc_cd",1);
        sheetObj.SetColHidden("vndr_seq",1);
        sheetObj.SetColHidden("vndr_seq_nm",1);
        sheetObj.SetColHidden("eq_loc_cd",1);
    } else {                                    
        sheetObj.SetColHidden("eq_dmg_cd",0);
        sheetObj.SetColHidden("eq_dmg_nm",0);
        sheetObj.SetColHidden("rhq",0);
        sheetObj.SetColHidden("cost_ofc_cd",0);
        sheetObj.SetColHidden("vndr_seq",0);
        sheetObj.SetColHidden("vndr_seq_nm",0);
        sheetObj.SetColHidden("eq_loc_cd",0);
    }               
    var aFloat=parseFloat(sheetObj.GetSumValue(0,"t_amt") + "");
    var bFloat=parseFloat(sheetObj.GetSumValue(0,"qty") + "");
    var avgFloat=0; 
    if(bFloat != 0){            
        avgFloat=MnrMakeRound((aFloat / bFloat),2);
    }                           
    sheetObj.SetSumValue(0,"t_avg",avgFloat);
}
/**
 * EES_MNR_0193 receiving function values ??from Pop-up        
 */ 
function setEES_MNR_0193(aryPopupData){
    var tagetSheet=sheetObjects[2]; 
    var formObj=document.form;                      
    for(var i=0; i < aryPopupData.length;i++){
        formObj.location_cd.value=aryPopupData;  
    }   
}   
