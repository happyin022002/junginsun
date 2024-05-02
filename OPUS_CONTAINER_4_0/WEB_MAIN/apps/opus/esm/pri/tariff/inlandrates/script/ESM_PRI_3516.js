/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3516.js
*@FileTitle  : Inland Rates History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
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
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
            case "btn_downexcel":
                doActionIBSheet(sheetObjects[3],formObject,IBSEARCH_ASYNC01);
                break;
            case "btns_calendar": 
                if(!document.getElementById(srcName).disabled){
                    var cal=new ComCalendar();         
                    cal.select(document.form.access_dt, 'yyyy-MM-dd');
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
 * registering IBMulti Combo Object as array <br>
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
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    //initializing IBMultiCombo
    for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
    initControl();
    //Tariff No
    ComPriTextCode2ComboItem(tariffCdValue, tariffCdText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );
    tariff_cd.Focus();
    var formObj=document.form;
    if (formObj.trf_no.value != "") { 
        comboObjects[0].SetSelectText(formObj.trf_pfx_cd.value + "-" + formObj.trf_no.value);
        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
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
                var HeadTitle="|TRF_PFX_CD|TRF_NO|TRF_INLND_SEQ|"
                + "Inland Rates Name";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_pfx_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:330, Align:"Left",    ColMerge:1,   SaveName:"trf_inlnd_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                                          
                InitColumns(cols);
                
                SetEditable(1);
                SetWaitImageVisible(0);
                SetHeaderRowHeight(28);
                SetSheetHeight(150);
            }

            break;
        case "sheet2":
            with(sheetObj){
                SetColProperty("trf_inlnd_sts_cd", {ComboText:trfInlndStsCdComboText, ComboCode:trfInlndStsCdComboValue} );
                SetColProperty("trf_inlnd_amdt_tp_cd", {ComboText:trfInlndAmdtTpCdComboText, ComboCode:trfInlndAmdtTpCdComboValue} );
                var HeadTitle="|TRF_PFX_CD|TRF_NO|TRF_INLND_SEQ|"
                + "Amend\nNo.|Effective\nDate|Expiration\nDate|Publish\nDate|Status|Request\nOffice|Creation\nStaff|Approval\nOffice|"
                + "TRF_INLND_NM|CRE_DT|ATCH_FILE_ID|ATCH_FILE_NM|TRF_INLND_AMDT_TP_CD";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_pfx_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pub_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:trfInlndStsCdComboText, ComboCode:trfInlndStsCdComboValue },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"trf_inlnd_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"atch_file_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"atch_file_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_amdt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ComboText:trfInlndAmdtTpCdComboText, ComboCode:trfInlndAmdtTpCdComboValue } ];
                                                          
                InitColumns(cols);
                
                InitDataCombo(0, "trf_inlnd_sts_cd", trfInlndStsCdComboText, trfInlndStsCdComboValue);
                InitDataCombo(0, "trf_inlnd_amdt_tp_cd", trfInlndAmdtTpCdComboText, trfInlndAmdtTpCdComboValue);
                
                SetEditable(1);
                SetWaitImageVisible(0);
                SetHeaderRowHeight(28);
                SetSheetHeight(150);
            }
            break;
        case "sheet3":  //download
            with(sheetObj){
                var HeadTitle="|File Name|Download|1|2|3|4|5|6";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"atch_file_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"file_dn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"file_path_url" },
                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"atch_file_id" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_pfx_cd" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_no" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_seq" },
                            {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" } ];
                                                          
                InitColumns(cols);
                
                SetEditable(1);
                SetImageList(0,"/opuscntr/img/ico_attach.gif");
                SetCountPosition(0);
                SetWaitImageVisible(0);
                SetRowHidden(0, 1);
                SetDataLinkMouse("file_dn",1);
                SetShowButtonImage(1);
                SetAutoRowHeight(0);
                //SetSheetHeight(50);
            }

            break;
        case "sheet4":
            with(sheetObj){
                //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                var HeadTitle1="| | | | | | | | | | | | |"
                + "One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Note";
                var HeadTitle2="Flag|Seq.|Loc.\nCode|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN<=|Weight\nMAX>=|Weight\nUnit|Type|Currency|"
                + "Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Note";
                var headCount=ComCountHeadTitle(HeadTitle1);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                          KeyField:0,   CalcLogic:"",   Format:"Integer" },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_bse_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rt_bse_loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_bse_loc_zip_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_via_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_inlnd_rt_trsp_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_min_lmt_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_lmt_wgt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rt_lmt_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_bx_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_20ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_40ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_40ft_hc_rt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_one_wy_45ft_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_bx_rt_amt",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_20ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_40ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_40ft_hc_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_45ft_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"inlnd_rt_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                                          
                InitColumns(cols);
                
                SetEditable(1);
                SetWaitImageVisible(0);
                resizeSheet(); //SetSheetHeight(180);
            }
            
            break;
    }
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[3]);
}
/**
 * initializing Combo, Combo items  <br>
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
                SetEditable(1);
                ValidChar(2,3);
            }
            break;
    }
}
/**
 * handling Axon event<br>
 */         
function initControl() {
    //handling Axon event          
    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
    axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);
}
/**
 * handling OnBeforeActivate events <br>
 */   
 function obj_activate() {
     var formObj=document.form;
     var srcName=ComGetEvent("name");
     ComClearSeparator (event.srcElement);
 }
/**
 * handling Onbeforedeactivate events <br>
 */   
function obj_deactivate() {
    var formObj=document.form;
    var eleName=event.srcElement.name;
    switch(eleName){
        case "access_dt":
            ComChkObjValid(event.srcElement);
        break;     
    }
}
/**
 * handling OnKeyDown events <br>
 */  
function obj_onKeydown(){
    // retrieving data when clicking enter key from Proposal No,S/C No.
    var eleName=ComGetEvent("name");
    if (eleName == "access_dt"){
        var keyValue=null;
        if(event == undefined || event == null) {
            keyValue=13;
        }else{
            keyValue=ComGetEvent("keycode") ? ComGetEvent("keycode") : ComGetEvent("which") ? ComGetEvent("which") : ComGetEvent("charCode");
        }
        if (keyValue == 13){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
}
/**
* Handling sheet process <br>
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
    try {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
            case IBSEARCH: // retrieve
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                formObj.f_cmd.value=SEARCHLIST01;
                var param="f_cmd="             + formObj.f_cmd.value
                          + "&trf_pfx_cd="       + formObj.trf_pfx_cd.value
                          + "&trf_no="           + formObj.trf_no.value
                          + "&access_dt="        + formObj.access_dt.value;
                ComOpenWait(true); //->waiting->start
                
                sheet1.RemoveAll();
                sheet2.RemoveAll();
                sheet3.RemoveAll();
                sheet4.RemoveAll();
                formInit(formObj);
                
                var sXml=sheetObj.GetSearchData("ESM_PRI_3516GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml,{Sync:1} );
                
                ComOpenWait(false); //->waiting->End
                break;
                
            case IBSEARCH_ASYNC01: // Down Excel
                if(sheetObj.RowCount() < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                    sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
                }
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
/**
 * checking validation process of inputed form data <br>
 */
function validateForm(sheetObj, formObj, sAction) {
    if(!ComChkValid(document.form)){
        return false;
    }
    switch (sAction) {
        case IBSEARCH: // retrieve
            if (ComIsEmpty(comboObjects[0].GetSelectText())) {
                ComPriInputValueFailed("select","Tariff Code",comboObjects[0]);
                tariff_cd.Focus();
                return false;
            }
        break;
    }
    return true;
}
/////////////////////// Sheet Event (S) ///////////////////////
/**
 * calling function when occurring OnSelectCell Event <br>
 */
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {

	var formObj=document.form;
    var inlndSeq=formObj.trf_inlnd_seq.value;
    formObj.trf_inlnd_seq.value="";
    var findIdx=sheetObj.FindText("trf_inlnd_seq", inlndSeq);
    if(findIdx != -1) sheetObj.SelectCell(findIdx, "trf_inlnd_seq");
    var selRow=sheetObj.GetSelectRow();
    if (OldRow != selRow) {
        formObj.f_cmd.value=SEARCHLIST02;
        var param="f_cmd="           + formObj.f_cmd.value
                  + "&trf_pfx_cd="     + sheetObj.GetCellValue(selRow, "trf_pfx_cd")
                  + "&trf_no="         + sheetObj.GetCellValue(selRow, "trf_no")
                  + "&trf_inlnd_seq="  + sheetObj.GetCellValue(selRow, "trf_inlnd_seq")
                  + "&access_dt="      + formObj.access_dt.value;
        ComOpenWait(true); //->waiting->start
        var sXml=sheetObj.GetSearchData("ESM_PRI_3516GS.do", param);
        sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
    }
    ComOpenWait(false); //->waiting->End
}
/**
 * calling function when occurring OnSelectCell Event <br>
 */
function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {

	var formObj=document.form;
    var amdtSeq=formObj.amdt_seq.value;
    formObj.amdt_seq.value="";
    var findIdx=sheetObj.FindText("amdt_seq", amdtSeq);
    if(findIdx != -1) sheetObj.selectRow=findIdx;
    var selRow=sheetObj.GetSelectRow();
    if (OldRow != selRow) { 
        formObj.f_cmd.value=SEARCH01;
        var param="f_cmd="           + formObj.f_cmd.value
                  + "&trf_pfx_cd="     + sheetObj.GetCellValue(selRow, "trf_pfx_cd")
                  + "&trf_no="         + sheetObj.GetCellValue(selRow, "trf_no")
                  + "&trf_inlnd_seq="  + sheetObj.GetCellValue(selRow, "trf_inlnd_seq")
                  + "&amdt_seq="       + sheetObj.GetCellValue(selRow, "amdt_seq")
                  + "&access_dt="      + formObj.access_dt.value;
        ComOpenWait(true); //->waiting->start
        sheetObjects[2].RemoveAll();
        var sXml=sheetObj.GetSearchData("ESM_PRI_3516GS.do", param);
        sheetObjects[3].LoadSearchData(sXml,{Sync:1} );
    }
    ComOpenWait(false); //->waiting->End
}
/**
 * calling event  when mouse move on the sheet <br>
 * calling event  when mouse move any place on the sheet <br>
 */
function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y)  {
    var Row=sheetObj.MouseRow();
    var Col=sheetObj.MouseCol();
    if(Row == 1 && (Col == 1 || Col == 2)) {
        sheetObj.SetToolTipText(Row, Col,sheetObj.GetCellText(Row, "atch_file_nm"));
    }
}
/**
 * downloading file <br>
 */
function sheet3_OnClick(sheetObj,Row,Col,Value){
    if(sheetObj.ColSaveName(Col)!="file_dn") return;
    location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, "atch_file_id");
    return;
}
/**
 * calling function when occurring OnSearchEnd Event <br>
 */
function sheet4_OnSearchEnd(sheetObj, errMsg){

	var formObj=document.form;
    var mainSheetObj=sheetObjects[1];
    var selRow=mainSheetObj.GetSelectRow();

    ComOpenWait(false);
    formObj.trf_inlnd_nm.value=mainSheetObj.GetCellValue(selRow, "trf_inlnd_nm");
    formObj.amend_seq.value=mainSheetObj.GetCellValue(selRow, "amdt_seq");
    formObj.status.value=mainSheetObj.GetCellValue(selRow, "trf_inlnd_sts_cd");
    formObj.cre_dt.value=ComGetMaskedValue(mainSheetObj.GetCellValue(selRow, "cre_dt"), "ymd");
    formObj.eff_dt.value=ComGetMaskedValue(mainSheetObj.GetCellValue(selRow, "eff_dt"), "ymd");
    formObj.exp_dt.value=ComGetMaskedValue(mainSheetObj.GetCellValue(selRow, "exp_dt"), "ymd");
    formObj.pub_dt.value=ComGetMaskedValue(mainSheetObj.GetCellValue(selRow, "pub_dt"), "ymd");
    formObj.rqst_ofc_cd.value=mainSheetObj.GetCellValue(selRow, "rqst_ofc_cd");
    formObj.cre_usr_id.value=mainSheetObj.GetCellValue(selRow, "cre_usr_id");
    formObj.apro_ofc_cd.value=mainSheetObj.GetCellValue(selRow, "apro_ofc_cd");
    formObj.trf_inlnd_amdt_tp_cd.value=mainSheetObj.GetCellValue(selRow, "trf_inlnd_amdt_tp_cd");
    comboValue2Text(formObj.status.value, formObj.trf_inlnd_amdt_tp_cd.value);
    //Attach file 
    if(mainSheetObj.GetCellValue(selRow, "atch_file_id") != "") {
        //ComPriXml2Sheet(sheetObjects[1], sXml);
        sheetObjects[2].DataInsert(-1);
        sheetObjects[2].SetCellValue(1, "atch_file_nm",mainSheetObj.GetCellValue(selRow, "atch_file_nm"),0);
        sheetObjects[2].SetCellValue(1, "atch_file_id",mainSheetObj.GetCellValue(selRow, "atch_file_id"),0);
        sheetObjects[2].SetCellValue(1, "file_dn",0,0);
    } else {
        sheetObjects[2].RemoveAll();
    }
    //setting Sheet Head Title   
    if(mainSheetObj.RowCount()> 0){
        changeHeadTitle(mainSheetObj, sheetObj, true);
    }else{
        changeHeadTitle(mainSheetObj, sheetObj, false);
    }
}

function formInit(formObj){

    formObj.trf_inlnd_nm.value='';
    formObj.amend_seq.value='';
    formObj.status.value='';
    formObj.cre_dt.value='';
    formObj.eff_dt.value='';
    formObj.exp_dt.value='';
    formObj.pub_dt.value='';
    formObj.rqst_ofc_cd.value='';
    formObj.cre_usr_id.value='';
    formObj.apro_ofc_cd.value='';
    formObj.trf_inlnd_amdt_tp_cd.value='';
    
}

/////////////////////// Sheet Event (E) ///////////////////////
/////////////////////// Combo Event (S) ///////////////////////
/**
 * event handler when changing seleted item in IBMulti Combo<br>
 */
function tariff_cd_OnChange(comboObj, oldindex, oldtext, oldcode , newindex, newtext , newcode){
    var formObj=document.form;
    var arrText=newtext.split("-");
    if (arrText != null && arrText.length > 0) {
        if (ComIsEmpty(comboObj.GetSelectText())) {
            formObj.trf_pfx_cd.value="";
            formObj.trf_no.value="";
            formObj.tariff_nm.value="";
        }else{
            var arr=newcode.split("-");
            formObj.trf_pfx_cd.value=arr[0];
            formObj.trf_no.value=arr[1];
            formObj.tariff_nm.value=comboObj.GetText(newcode, 1);
        }
    }
}
/**
 * calling event when focus out<br>
 */     
function tariff_cd_OnBlur(comboObj) {
    var formObj=document.form;
    var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);
    if (code != null && code != "" && code != "-1") {
        var arr=code.split("-");              
        formObj.trf_pfx_cd.value=arr[0];
        formObj.trf_no.value=arr[1];
        formObj.tariff_nm.value=comboObj.GetText(code, 1);
    }
}
/**
 * Oncalling function when occurring keyDown event <br>
 */
function tariff_cd_OnKeyDown(comboObj, KeyCode) {
    var formObj=document.form;
    if (KeyCode == 13){
        if (comboObj.GetSelectIndex()> 0){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
}
/////////////////////// Combo Event (E) ///////////////////////
 /**
  * setting form object wiht sheet's combo value's text <br>
  */ 
 function comboValue2Text(stsCd, amdtTp){
     var trfInlndStsCdValueArr=trfInlndStsCdComboValue.split("|");
     var trfInlndStsCdTextArr=trfInlndStsCdComboText.split("|");
     var trfInlndAmdtTpCdValueArr=trfInlndAmdtTpCdComboValue.split("|");
     var trfInlndAmdtTpCdTextArr=trfInlndAmdtTpCdComboText.split("|");
     var formObj=document.form;
     var arrIdx=0;
     if(stsCd == "")  formObj.status.value="";
     else {
         var stsCdLen=trfInlndStsCdValueArr.length;
         if(stsCdLen > 0){
             for(i=0 ; i<stsCdLen ; i++){
                 if(stsCd == trfInlndStsCdValueArr[i]){
                     arrIdx=i;
                 }
             }
             formObj.status.value=trfInlndStsCdTextArr[arrIdx];
         }
     }
     arrIdx=0;
     if(amdtTp == "") formObj.trf_inlnd_amdt_tp_cd.value="";
     else {
         var amdtTpLen=trfInlndAmdtTpCdValueArr.length;
         if(amdtTpLen > 0){
             for(i=0 ; i<amdtTpLen ; i++){
                 if(amdtTp == trfInlndAmdtTpCdValueArr[i]){
                     arrIdx=i;
                 }
             }
             formObj.trf_inlnd_amdt_tp_cd.value=trfInlndAmdtTpCdTextArr[arrIdx];
         }
     }
 }
/**
 * setting Sheet Head Title <br>
 */
function changeHeadTitle(mainSheetObj, sheetObj, flg) { 
    var title="";
    if(flg){
        title=mainSheetObj.GetCellValue(mainSheetObj.GetSelectRow(), "trf_pfx_cd") + "-"
              + mainSheetObj.GetCellValue(mainSheetObj.GetSelectRow(), "trf_no")     + " "
              + document.form.tariff_nm.value                                   + " - "
              + mainSheetObj.GetCellValue(mainSheetObj.GetSelectRow(), "trf_inlnd_nm");
    }else{
        title=" ";
    }
    var HeadTitle1="|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"+title+"|"
                   + "One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Note";
    var HeadTitle2="Flag|Seq.|Loc.\nCode|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN<=|Weight\nMAX>=|Weight\nUnit|Type|Currency|"
                   + "Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Note";
    var headertitleArr1 = HeadTitle1.split("|");
    for( var idx= 0 ; idx < headertitleArr1.length-1 ; idx++){
        sheetObj.SetCellValue(0 , idx , headertitleArr1[idx] , 0); 
    }
    var headertitleArr2 = HeadTitle2.split("|");
    for( var idx= 0 ; idx < headertitleArr2.length-1 ; idx++){
        sheetObj.SetCellValue( 1 , idx , headertitleArr2[idx] , 0); 
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	ComOpenWait(false);
}


function sheet4_OnDownFinish(sheetObj, downloadType, result) {
	ComOpenWait(false);
}
