/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0587.js
*@FileTitle  : Booking Close for Bay Plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";

// Event handler processing by button click event  */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {                
            case "btn_Retrieve": 
                doActionIBSheet(sheetObject,document.form,IBSEARCH);
                break;
            case "btn_Booking_Close":    
                if(sheetObject.CheckedRows(prefix1+"del_chk")<1){
                    ComShowCodeMessage("BKG00155");
                }else if(sheetObject.GetCellValue(sheetObject.GetSelectRow(),prefix1+"bkg_ofc_cd").toUpperCase().indexOf(formObject.userOfc_cd.value.toUpperCase())<0){
                    ComShowCodeMessage("BKG00875");
                }else if(sheetObject.GetCellValue(sheetObject.GetSelectRow(),prefix1+"bkg_clz_sts_cd").toUpperCase().indexOf("C".toUpperCase())>-1){
                    ComShowCodeMessage("BKG00233");
                }else{
                    formObject.f_cmd.value=MULTI01; 
                    doActionIBSheet(sheetObject,document.form,MULTI01); 
                } 
                break;
            case "btn_Re_Open": 
                if(sheetObject.CheckedRows(prefix1+"del_chk")<1){
                    ComShowCodeMessage("BKG00155");
                }else if(sheetObject.GetCellValue(sheetObject.GetSelectRow(),prefix1+"bkg_ofc_cd").toUpperCase().indexOf(formObject.userOfc_cd.value.toUpperCase())<0){
                    ComShowCodeMessage("BKG00875"); 
                }else if(sheetObject.GetCellValue(sheetObject.GetSelectRow(),prefix1+"bkg_clz_sts_cd").toUpperCase().indexOf("R".toUpperCase())>-1
                      || sheetObject.GetCellValue(sheetObject.GetSelectRow(),prefix1+"bkg_clz_sts_cd").toUpperCase().indexOf("O".toUpperCase())>-1){
                    ComShowCodeMessage("BKG00233"); 
                }else{ 
                    formObject.f_cmd.value=MULTI02; 
                    doActionIBSheet(sheetObject,document.form,MULTI01); 
                }
                break;
            case "btn_Excel":
                if(sheetObject.RowCount()>0){
                    doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
                }else{
                    ComShowCodeMessage("BKG00155");
                }
                break; 
            case "btn_Close":
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
 */
function setSheetObject(sheet_obj){
     sheetObjects[sheetCnt++]=sheet_obj;            
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage(flag) {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
        if (flag){
            doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }            
    }
    var formObject=document.form;
    //axon_event.addListenerFormat('keydown', 'obj_keydown', formObject);
    //axon_event.addListenerFormat('keypress', 'bkg0587_keypress',formObject);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    axon_event.addListenerForm  ("change",          "form_onChange",        formObject);
    ComSetFocus(document.form.vsl_cd);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                var HeadTitle="|Sel.|VVD|POL|POL|Booking Office|Status|Office|User ID|Date";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
                            {Type:"CheckBox",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"bkg_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"bkg_clz_sts_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"vsl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"skd_voy_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"skd_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"clpt_ind_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"bkg_clz_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                                                           
                InitColumns(cols);
                
                SetEditable(1);
                SetSheetHeight(420);
            }
    
            break;
    }
}

// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) { 
    var arrPreFix=new Array("sheet1_");
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case COMMAND01:   //Booking Office retrieve            
            formObj.f_cmd.value=COMMAND01; 
            var sXml=sheetObj.GetSearchData("ESM_BKG_0587GS.do", FormQueryString(formObj));
            var arrVal=ComXml2ComboString(sXml, "val", "name"); 
            ComboList(arrVal);
            break;
        case IBSEARCH:      
            if (ComChkLen(ComTrim(formObj.vsl_cd),9)!=2 ||ComChkLen(ComTrim(formObj.pol_cd),5)!=2){
                ComShowCodeMessage("BKG00213");
                return false;
            }
            formObj.f_cmd.value=SEARCH; 
            var sXml=sheetObj.GetSearchData("ESM_BKG_0587GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
            var arrXml=sXml.split("|$$|");
            for(var i=0; i < arrXml.length; i++){ 
                sheetObjects[i].RenderSheet(0);
                if(i > 0) {
                    sheetObjects[i].SetWaitImageVisible(0);
                }  
                sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
                sheetObjects[i].RenderSheet(1);
            }   
            ComSetFocus(formObj.vsl_cd);
            break;
        case MULTI01:        //sheet1 save  
            if (sheetObj.GetCellValue(sheetObj.GetSelectRow(),prefix1+"bkg_clz_sts_cd").toUpperCase().indexOf("O".toUpperCase())>-1) {
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"ibflag","I");
            }else{
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"ibflag","U");
            }
            if (formObj.f_cmd.value==MULTI01){
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"bkg_clz_sts_nm","Closed");
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"bkg_clz_sts_cd","C");
            }else{ 
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"bkg_clz_sts_nm","Re-open");
                sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"bkg_clz_sts_cd","R");
            }
            sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"ofc_cd",formObj.userOfc_cd.value);
            sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"upd_usr_id",formObj.user_id.value);
            sheetObj.SetCellValue(sheetObj.GetSelectRow(),prefix1+"upd_dt",ComGetNowInfo());
            var sParam=ComGetSaveString(sheetObjects);
            if (sParam == "") return; 
            sParam += "&" + FormQueryString(formObj);
            var sXml=sheetObj.GetSaveData("ESM_BKG_0587GS.do", sParam);
            sheetObj.LoadSaveData(sXml);
            break;
        case IBDOWNEXCEL:       
            if(sheetObj.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
            }else{
                sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
            }
            break; 
    } 
}

function bkg0587_keypress(){
    obj=event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;
    switch(obj.dataformat) { 
        case "engup":
            ComKeyOnlyAlphabet('uppernum');
            break; 
    }
}

function obj_keydown() {
    var obj=event.srcElement;
    var vKeyCode=event.keyCode;
    var formObj=document.form;
    if ( vKeyCode == 13 ) {
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
    }
}

/*
* Booking Office retrieve
*/
function form_onChange(){ 
    var srcName=ComGetEvent("name");
    var srcValue=ComGetEvent("value");
    var formObject=document.form; 
    if(srcName == "pol_cd"||srcName=='vsl_cd'){
        if (ComChkLen(ComTrim(formObject.vsl_cd),9)!=2){
            ComShowCodeMessage("BKG00213");
            ComSetFocus(formObject.vsl_cd);
        }else if (ComChkLen(ComTrim(formObject.pol_cd),5)==2){
            doActionIBSheet(sheetObjects[0],formObject,COMMAND01); 
        }
    }
}


/*
* create combobox by retrieved Booking Office data
*/
function ComboList(arrVal){
    var objCbo=document.getElementById("ofc_cd");
    clearComboList(objCbo);
    var arr_value=arrVal[0].split("|"); 
    if (arr_value.length >1){
        for(var i=0; i < arr_value.length; i++) {
            var opt=document.createElement("option"); 
            var arr_text=arr_value[i];   
            opt.setAttribute("value", arr_text);  
            opt.innerHTML=arr_text;  
            objCbo.appendChild(opt);
         }
    }else{
        var opt=document.createElement("option"); 
        var arr_text="All";   
        opt.setAttribute("value", arr_text);  
        opt.innerHTML=arr_text;  
        objCbo.appendChild(opt);
    }
}

/*
* initialize combobox
*/
function clearComboList(objCbo){
    var option=objCbo.getElementsByTagName("option");
    for(var i=option.length-1; i>-1 ; i--) {
        option[i].parentNode.removeChild(option[i]);
    }  
}

/*
* ToolTip
*/
function sheet1_OnMouseMove(sheet1,Button, Shift, X, Y){  
    if (sheet1.MouseCol()==sheet1.SaveNameCol(prefix1+"upd_usr_id")){
        sheet1.SetMousePointer("Hand");
    }else{
        sheet1.SetMousePointer("Default");
    }
}
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    for(i=1;i<sheetObj.LastRow();i++){
        sheetObj.SetCellFontColor(i, prefix1+"bkg_clz_sts_nm","#0000FF");
    }
}
