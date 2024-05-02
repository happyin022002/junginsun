/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3507.js
*@FileTitle  : Tariff Rule Creation &amp; Amendment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                    Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var selectRow = 1;
var selectCol = 1;
var rowAddValue = "";
var rowAddStatus = "";

// Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * Event handler processing by button name  <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return void
 * @author 
 * @version 2010.10.13
 */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_new":
                doActionIBSheet(sheetObject1,formObject,IBCREATE);
                break;
            case "btn_retrieve":
            	selectRow = 1;
            	selectCol = 1;
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
            case "btn_save":
                doActionIBSheet(sheetObject1,formObject,IBSAVE);
                break;
            case "btn_amend":
                doActionIBSheet(sheetObject1,formObject,MODIFY01);
                break;
            case "btn_amendcancel":
                doActionIBSheet(sheetObject1,formObject,MODIFY02);
                break;
            case "btn_rowadd":
                doActionIBSheet(sheetObject1,formObject,IBINSERT);
                break;
            case "btn_rowdelete":
                doActionIBSheet(sheetObject1,formObject,IBDELETE);
                break;
            case "btn_request":
                doActionIBSheet(sheetObject1,formObject,MODIFY03);
                break;
            case "btn_approve":
                doActionIBSheet(sheetObject1,formObject,MODIFY04);
                break;
            case "btn_publish":
                doActionIBSheet(sheetObject1,formObject,MODIFY05);                  
                break;
            case "btn_cancel":
                doActionIBSheet(sheetObject1,formObject,MODIFY06);
                break;
            case "btn_amendcompare":
                doActionIBSheet(sheetObject1,formObject,MODIFY07);
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
* registering IBSheet Object as list <br>
* adding process for list in case of needing batch processing with other items<br>
* defining list on the top of source <br>
* <br><b>Example :</b>
* <pre>
*     setSheetObject(sheetObj);
* </pre>
* @param {ibsheet} sheet_obj mandatory IBSheet Object
* @return void
* @author 
* @version 2010.10.13
*/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* registering IBCombo Object as list</b>
* adding process for list in case of needing batch processing with other items<br>
* defining list on the top of source <br>
* <br><b>Example :</b>
* <pre>
*     setComboObject(comboObj);
* </pre>
* @param {ibcombo} combo_obj Mandatory IBCombo Object
* @return void
* @author 
* @version 2010.10.13
*/
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
* initializing sheet <br>
* implementing onLoad event handler in body tag <br>
* adding first-served functions after loading screen. <br>
* <br><b>Example :</b>
* <pre>
*     loadPage();
* </pre>
* @return void
* @author 
* @version 2010.10.13
*/
function loadPage() {
    var formObj=document.form;
    for(i=0;i<sheetObjects.length;i++){
        //Modify Environment Setting Function's name
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //Add Environment Setting Function
        ComEndConfigSheet(sheetObjects[i]);
    }
    //Initializing IBMultiCombo
    for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
    // Axon Event Initialize
    initControl();
    // Button Initialize
    toggleButtons("INIT");
    // Tariff Code Combo Setting
    ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );   
    // It calls when moves on Inquiry window.
    if(formObj.trf_no.value != "") {
        var trfPfxCd=formObj.trf_pfx_cd.value;
        var trfNo=formObj.trf_no.value;
        var trfRuleNo=formObj.temp_rule_no.value;
        var trfCd=trfPfxCd + "-" + trfNo;           
        comboObjects[0].SetSelectCode(trfCd);
        selectRow = 1;
    	selectCol = 1;
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);          
        var Row=sheetObjects[0].FindText("trf_rule_no", trfRuleNo);
        sheetObjects[0].SelectCell(Row, "trf_rule_no");
    }
    tariff_cd.Focus();
}
/**
 * Catching events for Axon event.<br>
 * <br><b>Example :</b>
 * <pre>
 *     initControl()
 * </pre>
 * @param  void
 * @return void
 * @author 
 * @version 2010.10.13
 */         
 function initControl() {
    // Process Axon Event No.1, Event Catch             
//    axon_event.addListener('change', 'trf_rule_ctnt_onChange', 'trf_rule_ctnt');
	 axon_event.addListener('keyup', 'trf_rule_ctnt_onkeyup', 'trf_rule_ctnt');	
 }
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets  <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {int} sheetNo mandatory IBSheet Object Serial No
 * @return void
 * @author 
 * @version 2010.10.13
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch(sheetID) {
        case "sheet1":
            with(sheetObj){
                var HeadTitle="Flag|Seq.|Rule\nNo.|Rule Name|Charge\nCode|Amend\nType|Approval\nOffice|Creation\nDate|Effective\nDate|Expiration\nDate|Publish\nDate|Amend\nNo. " +
                "|Status|Request\nOffice|Creation\nStaff" +
                "|1|2|3|4|5|6|7|8";
                var headCount=ComCountHeadTitle(HeadTitle);
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:0 } );
                
                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                            {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                            {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"trf_rule_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
                            {Type:"Text",      Hidden:0, Width:240,  Align:"Left",    ColMerge:0,   SaveName:"trf_rule_nm",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                            {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_chg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_amdt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"apro_ofc_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Date", 	   Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                            {Type:"Date", 	   Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
                            {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pub_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rqst_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_rule_ctnt", 	     KeyField:0 },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bef_trf_rule_ctnt" },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_flg" },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt" },
                            {Type:"Date",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bef_pub_dt",			 KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                            {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"apro_flg" } ];
                   
                InitColumns(cols);
                
                SetEditable(1);
                SetImageList(0,"img/btns_calendar.gif");
                SetImageList(1,"img/btns_calendar_off.gif");
                SetWaitImageVisible(0);
                SetColProperty(0 ,"trf_rule_no" , {AcceptKeys:"E|N|[-]|[.]" , InputCaseSensitive:1});
                SetColProperty(0 ,"trf_rule_nm" , {AcceptKeys:"E|[01234567890 !@#$%^&*()-=\\_+|[]{},.<>/?;':`~\"\r\n\t]]"});
                //SetShowButtonImage(2);
                SetSelectionMode(smSelectionRow);//1
                //SetAutoRowHeight(0);
                SetColProperty("trf_rule_chg_cd", {ComboText:trfRuleChgCdComboText, ComboCode:trfRuleChgCdComboValue} );
                SetColProperty("trf_rule_amdt_tp_cd", {ComboText:trfRuleAmdtTpCdComboText, ComboCode:trfRuleAmdtTpCdComboValue} );
                SetColProperty("trf_rule_sts_cd", {ComboText:trfRuleStsCdComboText, ComboCode:trfRuleStsCdComboValue} );
                SetColProperty("apro_ofc_cd", {ComboText:aproOfcCdComboText, ComboCode:aproOfcCdComboValue} );
                SetSheetHeight(250);
            }
            break;
    }
}
/**
* setting intial combo value <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibsheet} comboObj Mandatory IBMultiCombo Object
* @param {int} comboNo Mandatory IBMultiCombo's Serial No
* @return void
* @author 
* @version 2010.10.13
*/ 
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
        case "tariff_cd":
            with(comboObj) {
                SetDropHeight(260);
                SetMultiSelect(0);
                SetMaxSelect(1);
                SetMaxLength(8);
                SetUseAutoComplete(1);
                SetSelectIndex(0);
                ValidChar(2,3);
            }
            break;          
    }
}
/**
* Handling sheet's processes <br>
* <br><b>Example :</b>
* <pre>
*     doActionIBSheet(sheetObj, document.form, IBSEARCH)
* </pre>
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @param {form} formObj mandatory html form object
* @param {int} sAction mandatory,Constant Variable
* @return void
* @author 
* @version 2010.10.13
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
    try {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {              
            case IBSEARCH: // retrieving
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH01;
                sheetObj.DoSearch("ESM_PRI_3507GS.do", FormQueryString(formObj));
                //var sXml=sheetObj.GetSearchData("ESM_PRI_3507GS.do", FormQueryString(formObj));
                //sheetObj.LoadSearchData(sXml,{Sync:1} );
                
                
                	
                break;
            case IBSEARCH_ASYNC01: // Duplication Check                 
                formObj.f_cmd.value=SEARCH02;
                var sParam=FormQueryString(formObj);                    
                    sParam += "&trf_rule_no=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no");
                    sParam += "&amdt_seq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq");
                var sXml=sheetObj.GetSearchData("ESM_PRI_3507GS.do", sParam);
                var dupLen=ComGetEtcData(sXml,"DUP_LEN");
                if(dupLen > 0) {
                    return false;
                } else {
                    return true;
                }
                break;
            case IBCREATE: // New
                comboObjects[0].SetSelectIndex(-1);
                formObj.trf_pfx_cd.value="";
                formObj.trf_no.value="";
                formObj.trf_nm.value="";    
                formObj.trf_rule_ctnt.value="";
                formObj.bef_trf_rule_ctnt.value="";
                sheetObj.RemoveAll();
                tariff_cd.Focus();
                toggleButtons("INIT");
                break;
            case IBINSERT: // Row Add
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                var idx=doRowChange(sheetObj, -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol, true);
                if (idx < 0) {
                    return false;
                }
                formObj.trf_rule_ctnt.value="";
                formObj.bef_trf_rule_ctnt.value="";
                sheetObj.SetCellValue(idx, "trf_pfx_cd",formObj.trf_pfx_cd.value,0);
                sheetObj.SetCellValue(idx, "trf_no",formObj.trf_no.value,0);
                sheetObj.SetCellValue(idx, "amdt_seq",0,0);
                sheetObj.SetCellValue(idx, "trf_rule_sts_cd","I",0);
                sheetObj.SetCellValue(idx, "cre_usr_id",formObj.strusr_id.value,0);
                sheetObj.SetCellValue(idx, "rqst_ofc_cd",formObj.strofc_cd.value,0);
                
                sheetObj.SetCellEditable(idx, "trf_rule_no",1);
                sheetObj.SetCellEditable(idx, "trf_rule_nm",1);
                sheetObj.SelectCell(idx, "trf_rule_no", true);
                
                var actnt=document.getElementById("trf_rule_ctnt");
                actnt.removeAttribute("readOnly");   
                actnt.className="";
                
                toggleButtons("INSERT");
                break;
            case IBSAVE: // Save
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                if (!supressConfirm && !ComPriConfirmSave()) {
                    return false;
                }
                // In case Content modified, update it to sheet.
                // It calls when save button clicked as soon as Content modified.
                if (formObj.trf_rule_ctnt.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_ctnt")) {
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_ctnt",formObj.trf_rule_ctnt.value,0);
                }
                ComOpenWait(true);
                formObj.f_cmd.value=MULTI01;
                var sParam=FormQueryString(formObj);
                var sParamSheet=sheetObj.GetSaveString();
                if (sParamSheet != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                }
                var sXml=sheetObj.GetSaveData("ESM_PRI_3507GS.do", sParam);
                // Find the rows that before retrieve again.
                selectRow=sheetObj.GetSelectRow();
                selectCol=sheetObj.GetSelectCol();
                rowAddValue=sheetObj.GetCellValue(selectRow, "trf_rule_no");
                rowAddStatus=sheetObj.GetRowStatus(selectRow);
                doActionIBSheet(sheetObj,document.form,IBSEARCH);   
                sheetObj.LoadSaveData(sXml);
                return true;
                break;
            case IBDELETE: // Delete
            	//can not delete row when there is deleted row in the sheet
            	if(sheetObj.RowCount("D") > 0) {
            		supressConfirm = false;
            		doActionIBSheet(sheetObj,formObj,IBSAVE);
            		return;
            	}
            	
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                var amdtSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq");
                if(amdtSeq == 0) {  
                    if(sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "I"){
                        sheetObj.RowDelete(sheetObj.GetSelectRow(), false);
                    } else {
                    	var delRowIdx = sheetObj.GetSelectRow();
                        sheetObj.SetRowHidden(delRowIdx, 1);
                        sheetObj.SetRowStatus(delRowIdx,"D");
                    }
                }
                // Contents In/output Management
                setRuleContents(sheetObj, sheetObj.GetSelectRow(), 1);
                // Button Control
                setButtonControl(sheetObj, sheetObj.GetSelectRow(), 1);
                // Privilege Management Control
                var tRowCnt = sheetObj.RowCount() - sheetObj.RowCount("D");
                if(tRowCnt != 0) {
                	setAuthButtonControl(sheetObj, sheetObj.GetSelectRow(), 1);
                }
                //after deleting a row, to stop to be disable the save button by setAuthButtonControl funtion
                toggleButtons("INSERT");
                break;
            case MODIFY01: // Amend
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                var sUrl="ESM_PRI_3519.do";
                ComOpenPopup(sUrl, 450, 300, "callbackEsmPri3519", "1,0", true);
                break;
            case MODIFY02: // Amend Cancel
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                if (!ComShowCodeConfirm("PRI00015")) {
                    return false;
                }
                ComOpenWait(true);
                // To let process via transaction
                sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"D");
                formObj.f_cmd.value=MODIFY02;
                var sParam=FormQueryString(formObj);
                var sParamSheet=sheetObj.GetSaveString();
                if (sParamSheet != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                }
                var sXml=sheetObj.GetSaveData("ESM_PRI_3507GS.do", sParam);
                selectRow=sheetObj.GetSelectRow()-1;
                selectCol=sheetObj.GetSelectCol();
                doActionIBSheet(sheetObj,document.form,IBSEARCH);                   
                sheetObj.LoadSaveData(sXml);
                break;
            case MODIFY03: // Request
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                // When modified data exists, save prior to request.
                if (sheetObj.IsDataModified()) {
                    if (ComShowCodeConfirm("PRI00006")) {
                        supressConfirm=true;
                        var rslt=doActionIBSheet(sheetObj,document.form,IBSAVE);
                        supressConfirm=false;
                    }
                    if (!rslt) {
                        return false;
                    }
                }
                if (!ComShowCodeConfirm("PRI06001")) {
                    return false;
                }
                ComOpenWait(true);
                formObj.f_cmd.value=MODIFY03;
                sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd","Q",0);
                var sParam=FormQueryString(formObj);
                var sParamSheet=sheetObj.GetSaveString();
                if (sParamSheet != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                }
                var sXml=sheetObj.GetSaveData("ESM_PRI_3507GS.do", sParam);
                selectRow=sheetObj.GetSelectRow();
                selectCol=sheetObj.GetSelectCol();
                doActionIBSheet(sheetObj,document.form,IBSEARCH);                   
                sheetObj.LoadSaveData(sXml);
                break;
            case MODIFY04: // Approval
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                if (!ComShowCodeConfirm("PRI06002")) {
                    return false;
                }
                ComOpenWait(true);
                formObj.f_cmd.value=MODIFY04;
                sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd","A",0);
                var sParam=FormQueryString(formObj);
                var sParamSheet=sheetObj.GetSaveString();
                if (sParamSheet != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                }
                var sXml=sheetObj.GetSaveData("ESM_PRI_3507GS.do", sParam);
                selectRow=sheetObj.GetSelectRow();
                selectCol=sheetObj.GetSelectCol();
                doActionIBSheet(sheetObj,document.form,IBSEARCH);                   
                sheetObj.LoadSaveData(sXml);
                break;
            case MODIFY05: // Publish
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                var sUrl="ESM_PRI_3510.do";
                
                ComOpenPopup(sUrl, 550, 280, "callbackEsmPri3510", "1,0", true);
                break;
            case MODIFY06: // Cancel
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                if (!ComShowCodeConfirm("PRI00015")) {
                    return false;
                }
                ComOpenWait(true);
                formObj.f_cmd.value=MODIFY06;
                if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd") == "Q") {
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd","I",0);
                } else if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd") == "A") {
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd","Q",0);
                } else if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd") == "F") {
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd","I",0);
                }
                var sParam=FormQueryString(formObj);
                var sParamSheet=sheetObj.GetSaveString();
                if (sParamSheet != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet, "");
                }
                var sXml=sheetObj.GetSaveData("ESM_PRI_3507GS.do", sParam);
                selectRow=sheetObj.GetSelectRow();
                selectCol=sheetObj.GetSelectCol();
                doActionIBSheet(sheetObj,document.form,IBSEARCH);                   
                sheetObj.LoadSaveData(sXml);
                break;
            case MODIFY07: // amendcompare
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }
                // When modified data exists, save prior to process.
                if (sheetObj.IsDataModified()) {
                    if (ComShowCodeConfirm("PRI00006")) {
                        supressConfirm=true;
                        var rslt=doActionIBSheet(sheetObj,document.form,IBSAVE);
                        supressConfirm=false;
                    }
                    if (!rslt) {
                        return false;
                    }
                }
                var sUrl="/opuscntr/ESM_PRI_3599.do";
                selectRow=sheetObj.GetSelectRow();
                selectCol=sheetObj.GetSelectCol();
                var trf_rule_no=sheetObj.GetCellValue(selectRow,"trf_rule_no");
                var trf_pfx_cd=sheetObj.GetCellValue(selectRow,"trf_pfx_cd");
                var trf_no=sheetObj.GetCellValue(selectRow,"trf_no");
                var amdt_seq2=sheetObj.GetCellValue(selectRow,"amdt_seq");
                var amdt_seq1=amdt_seq2 -1;
                var param="?trf_rule_no="+trf_rule_no+"&trf_pfx_cd="+trf_pfx_cd+"&trf_no="+trf_no+"&amdt_seq1="+amdt_seq1+"&amdt_seq2="+amdt_seq2
                ComOpenPopup(sUrl+param, 1024, 700, "", "1,0", true);
            break;
        }
    }catch(e){
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}



function callbackEsmPri3519(retVal){

	if(retVal){
	    selectRow=sheetObjects[0].GetSelectRow()+ 1;
	    selectCol=sheetObjects[0].GetSelectCol();
	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                   
	}
}

function callbackEsmPri3510(retVal){

	 if (retVal) {
         selectRow=sheetObjects[0].GetSelectRow();
         selectCol=sheetObjects[0].GetSelectCol();
         if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "amdt_seq") > 0) {
             selectRow=selectRow - 1;
         }                       
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         sheetObjects[0].SelectCell(selectRow, selectCol, false);
     }   
}



// Use it to control event. Validation check before event triggering.
var isFiredNested=false;
// Use it to separate save message
var supressConfirm=false;
/**
* Calling function in case of clicking SHEET's ROW<br>
* when modified data exists on selected row, Execute save when selected row on sheet changed. <br>
* <br><b>Example :</b>
* <pre>
*   doRowChange(sheetObj, OldRow, NewRow, OldCol, NewCol, appendRow);
* </pre>
* @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
* @param {int} OldRow Mandatory Onclick ,Cell's Row Index
* @param {int} NewRow Mandatory Onclick ,Cell's Row Index
* @param {int} OldCol Mandatory Onclick ,Cell's Column Index
* @param {int} NewCol Mandatory Onclick ,Cell's Column Index
* @param {string} appendRow Mandatory SHEET Row Add Option
* @return void
* @author 
* @version 2010.10.13
*/
function doRowChange(sheetObj, OldRow, NewRow, OldCol, NewCol, appendRow) {
    var formObj=document.form;
    var adjNewRow=NewRow;
    if (!isFiredNested && (OldRow != NewRow)) {
        if (sheetObj.IsDataModified()) {
            isFiredNested=true;
            sheetObj.SelectCell(OldRow, OldCol, false);
            isFiredNested=false;
            var rslt=false;
            if (ComShowCodeConfirm("PRI00006")) {
                supressConfirm=true;
                adjNewRow = Math.max(NewRow - sheetObj.RowCount("D"), sheetObj.HeaderRows());
                var rslt=doActionIBSheet(sheetObj,document.form,IBSAVE);
                supressConfirm=false;
            }
            if (rslt) {
                isFiredNested=true;
                sheetObj.SelectCell(adjNewRow, NewCol, false);
                isFiredNested=false;
            } else {
                isFiredNested=true;
                sheetObj.SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                return -1;
            }
        }
        if (appendRow) {
            isFiredNested=true;
            var idx=sheetObj.DataInsert();
            isFiredNested=false;
            return idx;
        }
    }
}
/**
* Calling function in case of Onclick event <br>
* Manage the contents input/output, Button Control option, Privilege control when selecting rows on sheet. <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
* @param {int} OldRow Mandatory Onclick ,Cell's Row Index
* @param {int} OldCol Mandatory Onclick ,Cell's Column Index
* @param {int} NewRow Mandatory Onclick ,Cell's Row Index
* @param {int} NewCol Mandatory Onclick ,Cell's Column Index
* @return void
* @author 
* @version 2010.10.13
*/  
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    var formObj=document.form;
    if (OldRow != NewRow) { 
        var idx=doRowChange(sheetObj, OldRow, NewRow, OldCol, NewCol, false);
        if(idx != -1) {
            // Contents In/output Management
        	setRuleContents(sheetObj, NewRow, NewCol);
            // Button Control
            setButtonControl(sheetObj, NewRow, NewCol);
            // Privilege Management Control
            setAuthButtonControl(sheetObj, NewRow, NewCol);
        }
        changeSelectBackColor4Rule(sheetObj, formObj);
    }
}
/**
 * Calling Function in case of OnChange event <br>
 * showing Description<br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {int} Row mandatory Onclick ,Cell's Row Index
 * @param {int} Col mandatory Onclick ,Cell's Column Index
 * @param {string} Value Mandatory Value
 * @return void
 * @author 
 * @version 2010.10.13
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
    var colName=sheetObj.ColSaveName(Col);
    var formObj=document.form;
    switch(colName)
    {
        case "eff_dt":
            if(sheetObj.GetCellValue(Row, "exp_dt") != "") {
            if(sheetObj.GetCellValue(Row, "eff_dt") >= sheetObj.GetCellValue(Row, "exp_dt")) {
                    ComShowCodeMessage("PRI00346");
                    sheetObj.SetCellValue(Row, "eff_dt","",0);
                    sheetObj.SelectCell(Row,"eff_dt");
                }
            }
            break;
        case "exp_dt":
            if(sheetObj.GetCellValue(Row, "exp_dt") != "") {
            if(sheetObj.GetCellValue(Row, "eff_dt") >= sheetObj.GetCellValue(Row, "exp_dt")) {
                    ComShowCodeMessage("PRI00345");
                    sheetObj.SetCellValue(Row, "exp_dt","",0);
                    sheetObj.SelectCell(Row,"exp_dt");
                }
            }
            break;
    }
}
/**
 * Calling function in case of Onclick event <br>
 * Depend on Status, setting input/ouptu option of Rule Contents. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
 * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
 * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
 * @return void
 * @author 
 * @version 2010.10.13
 */ 
function setRuleContents(sheetObj, NewRow, NewCol)  {
    var formObj=document.form;
    var ofcCd=formObj.strofc_cd.value; 
    var bCtnt=sheetObj.GetCellValue(NewRow, "bef_trf_rule_ctnt");
    var aCtnt=sheetObj.GetCellValue(NewRow, "trf_rule_ctnt");
    var trfRuleStsCd=sheetObj.GetCellValue(NewRow, "trf_rule_sts_cd");
    var amdtFlg=sheetObj.GetCellValue(NewRow, "amdt_flg");
    
    var tRowCnt = sheetObj.RowCount() - sheetObj.RowCount("D");
    if(tRowCnt == 0 ) {
    	formObj.trf_rule_ctnt.value="";
    	formObj.bef_trf_rule_ctnt.value="";
    } else {
//    	if(amdtFlg == "Y" && trfRuleStsCd == "F"){
//    		formObj.trf_rule_ctnt.value="";
//    	} else {
//    		formObj.trf_rule_ctnt.value=aCtnt;
//    	}
    	formObj.trf_rule_ctnt.value=aCtnt;
    	formObj.bef_trf_rule_ctnt.value=bCtnt;
    }

    
    // Initialization
    var actnt=document.getElementById("trf_rule_ctnt");     
    if(sheetObj.GetRowStatus(NewRow) != "I"
        && (sheetObj.GetCellValue(NewRow, "amdt_flg") == "N" || sheetObj.GetCellValue(NewRow, "trf_rule_sts_cd") != "I")) {
        actnt.setAttribute("readOnly", true);   
        actnt.className="input2";
    } else {
        if (sheetObj.GetRowStatus(NewRow) == "I" || ofcCd == sheetObj.GetCellValue(NewRow, "rqst_ofc_cd")) {
            actnt.removeAttribute("readOnly");              
        } else {
            actnt.setAttribute("readOnly", true);   
        }
        actnt.className="";
    }
}
/**
 * calling function in case of OnSelectCell event <br>
 * when Row is selected, Depend on status of selected row, Control the button.<br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
 * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
 * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
 * @return void
 * @author 
 * @version 2010.10.13
 */ 
function setButtonControl(sheetObj, NewRow, NewCol)  {
    // Initialization
    toggleButtons("INIT");
    
    var tRowCnt = sheetObj.RowCount() - sheetObj.RowCount("D");
    if(tRowCnt == 0 && sheetObj.IsDataModified()) {
    	toggleButtons("INSERT");
    } else {
	    if(sheetObj.GetCellValue(NewRow, "amdt_flg") == "N") {
	        toggleButtons("NOTAMEND");
	    } else {
	        if(sheetObj.GetCellValue(NewRow, "trf_rule_sts_cd") == "Q") {
	            toggleButtons("REQUESTED");             
	        } else if(sheetObj.GetCellValue(NewRow, "trf_rule_sts_cd") == "A") {
	            toggleButtons("APPROVED");
	        } else if(sheetObj.GetCellValue(NewRow, "trf_rule_sts_cd") == "F") {
	            toggleButtons("PUBLISH");
	        } else {
	            if(sheetObj.GetCellValue(NewRow, "amdt_seq") > 0) {
	                toggleButtons("AMEND");
	            } else {
	                if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "ibflag") == "I"){
	                    toggleButtons("INSERT");
	                } else {
	                    toggleButtons("NEW");
	                }
	            }
	        }
	    }
    }
}
/**
 * calling function in case of OnSelectCell event <br>
 * when Row is selected, Depend on privilege, Control the button.<br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
 * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
 * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
 * @return void
 * @author 
 * @version 2010.10.13
 */ 
function setAuthButtonControl(sheetObj, NewRow, NewCol)  {
    var formObj=document.form;
    var ofcCd=formObj.strofc_cd.value;
    //Amend Cancel
    if(ofcCd != sheetObj.GetCellValue(NewRow, "rqst_ofc_cd")) {
        ComBtnDisable("btn_amendcancel");
    }
    //Request 
    if(ofcCd != sheetObj.GetCellValue(NewRow, "rqst_ofc_cd")) {
        ComBtnDisable("btn_request");
    }
    //Approve
    /*
if(ofcCd != sheetObj.GetCellValue(NewRow, "apro_ofc_cd")) {
        ComBtnDisable("btn_approve");
    }
    */
    if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "apro_flg") != "Y") {
        ComBtnDisable("btn_approve");
    }
    //Cancel(REQUESTED)      
    if(sheetObj.GetCellValue(NewRow, "trf_rule_sts_cd") == "Q") {
        if(ofcCd == sheetObj.GetCellValue(NewRow, "rqst_ofc_cd")  || sheetObj.GetCellValue(sheetObj.GetSelectRow(), "apro_flg") == "Y") {
            ComBtnEnable("btn_cancel");
        }
    //Cancel(APPROVED)      
    }else if(sheetObj.GetCellValue(NewRow, "trf_rule_sts_cd") == "A") {
        if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "apro_flg") == "Y") {
            ComBtnEnable("btn_cancel");
        }
        /*
if(ofcCd == sheetObj.GetCellValue(NewRow, "apro_ofc_cd")) {
            ComBtnEnable("btn_cancel");
        }   
        */
    }
    //Row Delete
    if(ofcCd != sheetObj.GetCellValue(NewRow, "rqst_ofc_cd")) {
        ComBtnDisable("btn_rowdelete");
    }
    //Save
    if(ofcCd != sheetObj.GetCellValue(NewRow, "rqst_ofc_cd")) {
        ComBtnDisable("btn_save");
    }
}
/**
 * Displaying different highlight color at Amend Row<br>
 * Modify the color using selected row's RowFontColor or CellFontColor Property.<br>
 * <b>Example :</b>
 * <pre>
 *     changeSelectBackColor4Rule(sheetObj, formObj);
 * </pre>
 *
 * @param {sheet} sheetObj Mandatory, SheetObject
 * @param {form}  formobj   Mandatory,html's Form Object Name
 * @return void
 * @author 
 * @version 2009.12.31
 */
function changeSelectBackColor4Rule(sheetObj, formObj) {
    if (baseSelectBackColor == null) {
        baseSelectBackColor=getPriHighlightColor(sheetObj, "basic");
    }
     if (newSelectBackColor == null) {
         newSelectBackColor=getPriHighlightColor(sheetObj, "new");
    }
    if (sheetObj.GetRowFontColor(sheetObj.GetSelectRow()) != 0 
        || sheetObj.GetCellFontColor(sheetObj.GetSelectRow(), 1) != 0 
        || (sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "I"))
    {
        //sheetObj.SetRowFontColor(sheetObj.GetSelectRow() , newSelectBackColor);
        //no support[implemented common]CLT sheetObj.SelectBackColor=newSelectBackColor;
    } else {
        //sheetObj.SetRowFontColor(sheetObj.GetSelectRow() , baseSelectBackColor);
        //no support[implemented common]CLT sheetObj.SelectBackColor=baseSelectBackColor;
    }
}
 /**
 * handling process for input validation <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *        handling logic
 *     }
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {form} formObj mandatory html form object
 * @param {int} sAction mandatory,Constant Variable
 * @returns bool <br>
 *          true  : valid<br>
 *          false : inValid
 * @author 
 * @version 2010.10.13
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
    case IBSEARCH: // retrieving
        if (comboObjects[0].GetSelectCode()== "") {
            ComShowCodeMessage("PRI00308","select", "Tariff Code");
            tariff_cd.Focus();
            return false;
        }
        break;
    case IBCREATE: // New
        break;
    case IBSAVE:
        if (!sheetObj.IsDataModified()) {
            ComShowCodeMessage("PRI00301");
            return false;
        }
        if (comboObjects[0].GetSelectCode()== "") {
            return false;
        }
        
        var tRowCnt = sheetObj.RowCount() - sheetObj.RowCount("D");
        if(tRowCnt > 0) {
        
	        if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no") == "") {
	            ComShowCodeMessage("PRI00316", "Rule No");
	            sheetObj.SelectCell(sheetObj.GetSelectRow(), "trf_rule_no");
	            return false;
	        }
	        if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_nm") == "") {
	            ComShowCodeMessage("PRI00316", "Rule Name");
	            sheetObj.SelectCell(sheetObj.GetSelectRow(), "trf_rule_nm");
	            return false;
	        }
	        if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "apro_ofc_cd") == "") {
	            ComShowCodeMessage("PRI00316", "Approval Office");
	            sheetObj.SelectCell(sheetObj.GetSelectRow(), "apro_ofc_cd");
	            return false;
	        }
	        if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt") == "") {
	            ComShowCodeMessage("PRI00316", "Effective Date");
	            sheetObj.SelectCell(sheetObj.GetSelectRow(), "eff_dt");
	            return false;
	        }
	        if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "ibflag") != "R" && 
	            ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_ctnt")) == "") {
	            ComShowCodeMessage("PRI01042", "Rule Detail");
	            formObj.trf_rule_ctnt.focus();
	            return false;
	        }
	        if (sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "I") {
	            if(!doActionIBSheet(sheetObj,formObj, IBSEARCH_ASYNC01)) {
	                sheetObj.SelectCell(sheetObj.GetSelectRow(),"trf_rule_no");
	                ComShowCodeMessage("PRI00342", "Rule No.");
	                return false;
	            } 
	        }
	        // Date Check - when onchange event triggered               
	        if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt") != "") {
	            if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt") >= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt")) {
	                ComShowCodeMessage("PRI00345");
	                sheetObj.SetCellValue(sheetObj.GetSelectRow(), "exp_dt","",0);
	                sheetObj.SelectCell(sheetObj.GetSelectRow(),"exp_dt");
	                return false;
	            }
	        }
        
        }
        /////////////////////////////////////////////////////////////////////
        // update date checking
        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
            return false;
        }
        /////////////////////////////////////////////////////////////////////
        break;
    case IBINSERT:
        if (comboObjects[0].GetSelectCode()== "") {
            return false;
        }
        break;
    case MODIFY01: // Amend
        if (comboObjects[0].GetSelectCode()== "") {
            return false;
        }
        break;
    case MODIFY02: // Amend Cancel
        if (comboObjects[0].GetSelectCode()== "") {
            return false;
        }
        /////////////////////////////////////////////////////////////////////
        // update date checking
        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
            return false;
        }
        /////////////////////////////////////////////////////////////////////            
        break;
    case MODIFY03: // Request
        if (comboObjects[0].GetSelectCode()== "") {
            return false;
        }
        if(ComIsEmpty(formObj.trf_rule_ctnt)) {
            ComShowCodeMessage("PRI00308","input", "Rule Detail");
            formObj.trf_rule_ctnt.focus();
            return false;
        }
        if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt") != "") {
            if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt") > sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt")) {
                ComShowCodeMessage("PRI00346");
                return false;
            }
        }
        /////////////////////////////////////////////////////////////////////
        // update date checking
        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
            return false;
        }
        /////////////////////////////////////////////////////////////////////
        break;
    case IBDELETE: // Row Delete
        if (comboObjects[0].GetSelectCode()== "") {
            return false;
        }
        if(sheetObj.RowCount()< 1) {
            return false;
        }
        break;
    case MODIFY04: // Approve
        if (comboObjects[0].GetSelectCode()== "") {
            return false;
        }
        /////////////////////////////////////////////////////////////////////
        // update date checking
        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
            return false;
        }
        /////////////////////////////////////////////////////////////////////
        break;
    case MODIFY06: // Cancel
        if (comboObjects[0].GetSelectCode()== "") {
            return false;
        }
        /////////////////////////////////////////////////////////////////////
        // update date checking
        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
            return false;
        }
        /////////////////////////////////////////////////////////////////////
        break;
    }
    return true;
}
/**
 * Calling Function in case of OnSearchEnd event <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {string} ErrMsg mandatory from server
 * @return void
 * @author 
 * @version 2010.10.13
 */
function sheet1_OnSearchEnd(sheetObj, errMsg){
    var formObj=document.form;
    var ofcCd=formObj.strofc_cd.value;

    for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
       
    	if(sheetObj.GetCellValue(i, "amdt_seq") > 0) {
            sheetObj.SetCellEditable(i,"eff_dt",0);
        }
        if(sheetObj.GetCellValue(i, "trf_rule_sts_cd") != "I") {
            sheetObj.SetRowEditable(i,0);
        }
        if(sheetObj.GetCellValue(i, "amdt_flg") == "N") {
            sheetObj.SetRowEditable(i,0);
            ComSetRangeFont(sheetObj, "FontStrikethru", true, i, 1, i, sheetObj.LastCol())
        } else if (sheetObj.GetCellValue(i, "amdt_flg") == "Y" && sheetObj.GetCellValue(i, "trf_rule_sts_cd") != "F") {
            sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
        }
        if (ofcCd != sheetObj.GetCellValue(i, "rqst_ofc_cd")) {
            sheetObj.SetRowEditable(i,0);
        }
    }
    
    changeSelectBackColor4Rule(sheetObj, formObj); 
    
    // modify
    //function modify_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    if(sheetObj.RowCount() > 0){
    	sheet1_OnSelectCell(sheetObj, 0, 0, 1, 0);
    } else {
    	setButtonControl(sheetObj, 0, 0);
    }
    
    // Add Row Case
    if(rowAddStatus == "I") {
        selectRow=sheetObj.FindText("trf_rule_no", rowAddValue, 0, -1, true);
        rowAddValue = "";
    }
    sheetObj.SelectCell(selectRow, selectCol, false);
    ComOpenWait(false);
}

	/**
	 * Calling Function in case of OnSaveEnd event <br>
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {Long} Processing result code (0 is success, others should be processed as error)
	 * @param {string} Processing result message
	 * @param {Integer} HTTP response code
	 * @param {string} HTTP response message
	 * @return N/A
	 */
	function sheet1_OnSaveEnd(sheetObj, code, msg, stCode, stMsg) {
		if(code == 0) {
			ComOpenWait(false);
		}

	}

 /**
  * Calling function in case of Onclick event <br>
  * calling calendar  DIV <br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param {ibsheet} sheetObj mandatory IBSheet Object
  * @param {int} Row mandatory Onclick ,Cell's Row Index
  * @param {int} Col Mandatory OnClick ,Cell's Column Index 
  * @param {str} Value without Value Mandatory Format when saving
  * @return void
  * @author 
  * @version 2010.10.13
  */
  function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
    var colname=sheetObj.ColSaveName(Col);
    var formObj=document.form;
    var pinkColor="#FFC0CB";
    switch(colname)
    {
        case "eff_dt":
            cal=new ComCalendarGrid();
            cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
            break;
        case "exp_dt":
            cal=new ComCalendarGrid();
            cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
            break;
    }
  }
/**
 * Getting Sheet Data as XML format<br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param {int} sheetObj sheetObject
 * @author 
 * @version 2010.10.13
 */
function getSheetXml() { 
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var sXml="";
    var sCol="";
    var sValue="";
    sCol="trf_pfx_cd|trf_no|trf_rule_no|amdt_seq";
    sValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
            + "|" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
            + "|" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no")
            + "|" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq");
    sXml=ComPriSheet2Xml(sheetObj, null, sCol, sValue);
    return sXml;
}
/**
 * Controlling all buttons as enable/Disable<br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param {string} mode Mandatory,user mode or authority
 * @author 
 * @version 2010.10.13
 */
function toggleButtons(mode) {
    var sheetObj=sheetObjects[0];
    switch (mode) {
    case "INIT":
        ComBtnEnable("btn_retrieve");
        ComBtnEnable("btn_new");
        ComBtnEnable("btn_save");
        ComBtnDisable("btn_amend");
        ComBtnDisable("btn_amendcancel");
        ComBtnDisable("btn_rowadd");
        ComBtnDisable("btn_rowdelete");
        ComBtnDisable("btn_request");
        ComBtnDisable("btn_approve");
        ComBtnDisable("btn_publish");
        ComBtnDisable("btn_cancel");
        // Process it here, Because init always calls at first.
        ComBtnDisable("btn_amendcompare");
        if(sheetObjects[0].GetSelectRow() > 0   ){
            if( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "amdt_seq") > 0){
                ComBtnEnable("btn_amendcompare"); 
            }
            if( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "pub_dt") != "" &&
                sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "trf_rule_sts_cd") == "I"){
                    	ComBtnDisable("btn_request");
                    	ComBtnEnable("btn_publish");
            }
            
        }
        break;
    case "INSERT":      
        ComBtnEnable("btn_rowadd");
        ComBtnEnable("btn_rowdelete");
        ComBtnEnable("btn_save");
        break;
    case "NEW":     
        ComBtnEnable("btn_rowadd");
        ComBtnEnable("btn_rowdelete");
        ComBtnEnable("btn_request");
        if(sheetObjects[0].GetSelectRow() > 0   ){
	        if( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "pub_dt") != "" &&
	            sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "trf_rule_sts_cd") == "I"){
	            	ComBtnDisable("btn_request");
	            	ComBtnEnable("btn_publish");
	        }
        }
        break;
    case "NOTAMEND":
        ComBtnDisable("btn_save");
        break;
    case "AMEND":           
        ComBtnEnable("btn_amendcancel");
        ComBtnEnable("btn_rowadd");
        ComBtnEnable("btn_request");
        if(sheetObjects[0].GetSelectRow() > 0   ){
	        if( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "pub_dt") != "" &&
	            sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "trf_rule_sts_cd") == "I"){
	            	ComBtnDisable("btn_request");
	            	ComBtnEnable("btn_publish");
	        }
        }
        break;
    case "REQUESTED":
        ComBtnEnable("btn_rowadd");
        ComBtnEnable("btn_approve");
        break;
    case "APPROVED":        
        ComBtnEnable("btn_rowadd");
        ComBtnEnable("btn_publish");
        break;
    case "PUBLISH":             
        ComBtnEnable("btn_amend");
        ComBtnEnable("btn_rowadd");
        ComBtnEnable("btn_cancel");
        break;
    }
}
/**
 * Calling Function in case of OnChange event <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
 * @param {int} code Mandatory Onclick 
 * @param {int} text Mandatory 
 * @return void
 * @author 
 * @version 2010.10.13
 */
function tariff_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    var formObj=document.form;
    
    if (NewCode != null && NewCode.length > 1) {        
        formObj.trf_nm.value=comboObj.GetText(NewCode, 1);
        var arr=NewText.split("-");             
        formObj.trf_pfx_cd.value=arr[0];
        formObj.trf_no.value=arr[1];
    } else {
    	formObj.trf_pfx_cd.value="";
        formObj.trf_no.value="";
        formObj.trf_nm.value="";
        formObj.bef_trf_rule_ctnt.value = "";
        formObj.trf_rule_ctnt.value = "";
    }
    selectRow = 1;
    selectCol = 1;
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    
}
/**
 * calling function in case of OnClear event <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
 * @return void
 * @author 
 * @version 2010.10.13
 */
function tariff_cd_OnClear(comboObj) {
    var formObj=document.form;
    formObj.trf_nm.value="";        
    comboObj.SetSelectIndex(-1);
}
/**
 * event in case of losting IBMulti Combo's focus<br>
 * <br><b>Example :</b>
 * <pre>
 *    tariff_cd_OnBlur(comboObj);
 * </pre>
 * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
 * @return void
 * @author 
 * @version 2010.10.13
 */     
//function tariff_cd_OnBlur(comboObj) {
//    var formObj=document.form;
//    var code=comboObj.GetText(comboObj.FindItem(comboObj.GetSelectCode(), 0),0);
//
//    if (code != null && code != "" && code != "-1") {
//        var arr=code.split("-");                
//        formObj.trf_pfx_cd.value=arr[0];
//        formObj.trf_no.value=arr[1];
//        var text=comboObj.GetText(comboObj.FindItem(comboObj.GetSelectCode(), 0), 1);
//        if (text != null && text != "" && text != formObj.trf_nm.value) {
//            formObj.trf_nm.value=comboObj.GetText(comboObj.FindItem(comboObj.GetSelectCode(), 0), 1);
//            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);                  
//        }
//    }
//}
/**
* checking whether other user modified datas already about same s/c no.<BR>
* Checking whether data modified by other user <br> 
* <br><b>Example :</b>
* <pre>
*     (sheetObjects[0],"CHECK1");
* </pre>
* @param {object} sheetObj sheet object contains update date and key
* @param {String} checkTpCd ,code to be define table to check update date
*  
* @return boolean , true :modified, false: not modified
* @author 
* @version 2010.06.29
*/
function checkChangingUpdateDate(sheetObj, checkTpCd ){
    var returnValue=false;
    /////////////////////////////////////////////////////////////////////
    // update date checking
   switch(checkTpCd){
   case "CHECK1" :
        var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_RULE&page_name=Tariff Rule"
                            + "&key1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
                            + "&key2="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
                            + "&key3="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
                            + "&key4="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no")
                            + "&upd_dt="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "upd_dt");
        var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
            sheetObj.LoadSearchData(cXml,{Sync:1} );
            ComOpenWait(false); //->waiting->End
            returnValue=true;
        }
        break;
   case "CHECK2" : //amend
       var amdt_seq=parseInt(sheetObj.GetCellValue(1, "amdt_seq"));
        //checking if next seq is created already
        amdt_seq++;
        var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_RULE&page_name=Tariff Rule"
                            + "&key1="+sheetObj.GetCellValue(sheetObj.HeaderRows(), "trf_pfx_cd")
                            + "&key2="+sheetObj.GetCellValue(sheetObj.HeaderRows(), "trf_no")
                            + "&key3="+amdt_seq
                            + "&key4="+sheetObj.GetCellValue(sheetObj.HeaderRows(), "trf_rule_no")
                            + "&upd_dt="+sheetObj.GetCellValue(sheetObj.HeaderRows(), "upd_dt");
        var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
            sheetObj.LoadSearchData(cXml,{Sync:1} );
            ComOpenWait(false); //->waiting->End
            returnValue=true;
        }
        break;
   }
   return returnValue;
    /////////////////////////////////////////////////////////////////////
}
/**
* Process onChange event. <br>
* when sheet row focus changed, TextArea of the row has changed, Display the Save Message.
* <br><b>Example :</b>
* <pre>
*     trf_rule_ctnt_onChange()
* </pre>
* @param  void
* @return void
* @author 
* @version 2010.10.13
*/    
//function trf_rule_ctnt_onChange() {
//    var sheetObj=sheetObjects[0];
//    var formObj=document.form;       
//    var ruleCtnt=formObj.trf_rule_ctnt.value;
//    if(ruleCtnt != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_ctnt")) {
//        sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_ctnt",ruleCtnt,0);
//    }
//}

function trf_rule_ctnt_onkeyup() {
	var sheetObj=sheetObjects[0];
  var formObj=document.form;       
  var ruleCtnt=formObj.trf_rule_ctnt.value;
  if(ruleCtnt != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_ctnt")) {
      sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_ctnt",ruleCtnt,0);
  }
}